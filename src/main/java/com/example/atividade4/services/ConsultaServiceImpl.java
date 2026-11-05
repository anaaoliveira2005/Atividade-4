
package com.example.atividade4.services;

import com.example.atividade4.dtos.ConsultaDTO;
import com.example.atividade4.dtos.DadosConsultaDTO;
import com.example.atividade4.enums.StatusConsulta;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Consulta;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.ConsultaRepository;
import com.example.atividade4.repositories.VeterinarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final AnimalRepository animalRepository;
    private final VeterinarioRepository veterinarioRepository;

    public ConsultaServiceImpl(
            ConsultaRepository consultaRepository,
            AnimalRepository animalRepository,
            VeterinarioRepository veterinarioRepository) {

        this.consultaRepository = consultaRepository;
        this.animalRepository = animalRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    @Override
    public void adicionar(ConsultaDTO dto) {

        if (dto == null) {
            throw new RegraNegocioException(
                    "Os dados da consulta são obrigatórios.");
        }

        if (dto.getLocal() == null || dto.getLocal().isBlank()) {
            throw new RegraNegocioException(
                    "O local da consulta é obrigatório.");
        }

        if (dto.getData() == null) {
            throw new RegraNegocioException(
                    "A data da consulta é obrigatória.");
        }

        if (dto.getHorario() == null) {
            throw new RegraNegocioException(
                    "O horário da consulta é obrigatório.");
        }

        if (dto.getAnimalId() == null) {
            throw new RegraNegocioException(
                    "Informe o animal da consulta.");
        }

        if (dto.getVeterinarioId() == null) {
            throw new RegraNegocioException(
                    "Informe o veterinário da consulta.");
        }

        if (dto.getData().isBefore(LocalDate.now())) {
            throw new RegraNegocioException(
                    "Não é possível agendar uma consulta em uma data passada.");
        }

        if (dto.getData().equals(LocalDate.now())
                && dto.getHorario().isBefore(LocalTime.now())) {
            throw new RegraNegocioException(
                    "Não é possível agendar uma consulta em um horário que já passou.");
        }

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Animal não encontrado."));

        Veterinario veterinario =
                veterinarioRepository.findById(dto.getVeterinarioId())
                        .orElseThrow(() ->
                                new RegraNegocioException(
                                        "Veterinário não encontrado."));

        boolean habilitado = false;

        for (var especie : veterinario.getEspecies()) {
            if (especie.getId().equals(animal.getEspecie().getId())) {
                habilitado = true;
                break;
            }
        }

        if (!habilitado) {
            throw new RegraNegocioException(
                    "O veterinário não está habilitado para atender essa espécie.");
        }

        List<Consulta> conflitos =
                consultaRepository.buscarAgendamentosNoHorario(
                        veterinario.getId(),
                        dto.getData(),
                        dto.getHorario(),
                        StatusConsulta.CANCELADA
                );

        if (!conflitos.isEmpty()) {
            throw new RegraNegocioException(
                    "O veterinário já possui uma consulta nesse dia e horário.");
        }

        Consulta consulta = new Consulta(
                dto.getLocal().trim(),
                dto.getData(),
                dto.getHorario(),
                animal,
                veterinario
        );

        consultaRepository.save(consulta);
    }

    @Override
    @Transactional(readOnly = true)
    public DadosConsultaDTO buscarPorId(Integer id) {

        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Consulta não encontrada."));

        return converterParaDTO(consulta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosConsultaDTO> listarTodos() {

        List<Consulta> consultas = consultaRepository.findAll();

        List<DadosConsultaDTO> resultado = new ArrayList<>();

        for (Consulta consulta : consultas) {
            resultado.add(converterParaDTO(consulta));
        }

        return resultado;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosConsultaDTO> buscarPorAnimal(
            Integer animalId) {

        if (animalId == null) {
            throw new RegraNegocioException(
                    "Informe o ID do animal.");
        }

        animalRepository.findById(animalId)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Animal não encontrado."));

        List<Consulta> consultas =
                consultaRepository.buscarConsultasPorAnimal(animalId);

        List<DadosConsultaDTO> resultado = new ArrayList<>();

        for (Consulta consulta : consultas) {
            resultado.add(converterParaDTO(consulta));
        }

        return resultado;
    }

    @Override
    public void cancelar(Integer id) {

        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Consulta não encontrada."));

        if (consulta.getStatus() == StatusConsulta.CANCELADA) {
            throw new RegraNegocioException(
                    "Essa consulta já foi cancelada.");
        }

        if (consulta.getStatus() == StatusConsulta.REALIZADA) {
            throw new RegraNegocioException(
                    "Não é possível cancelar uma consulta já realizada.");
        }

        consulta.setStatus(StatusConsulta.CANCELADA);

        consultaRepository.save(consulta);
    }

    private DadosConsultaDTO converterParaDTO(Consulta consulta) {

        return new DadosConsultaDTO(
                consulta.getId(),
                consulta.getLocal(),
                consulta.getData(),
                consulta.getHorario(),
                consulta.getStatus(),
                consulta.getAnimal().getId(),
                consulta.getAnimal().getNome(),
                consulta.getVeterinario().getId(),
                consulta.getVeterinario().getNome()
        );
    }
}