package com.example.atividade4.services;

import com.example.atividade4.dtos.VacinaAplicadaDTO;
import com.example.atividade4.dtos.DadosVacinaAplicadaDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Animal;
import com.example.atividade4.models.VacinaAplicada;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.VacinaAplicadaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VacinaAplicadaServiceImpl
        implements VacinaAplicadaService {

    private final VacinaAplicadaRepository vacinaRepository;
    private final AnimalRepository animalRepository;

    public VacinaAplicadaServiceImpl(
            VacinaAplicadaRepository vacinaRepository,
            AnimalRepository animalRepository) {

        this.vacinaRepository = vacinaRepository;
        this.animalRepository = animalRepository;
    }

    @Override
    public void adicionar(VacinaAplicadaDTO dto) {

        if (dto == null) {
            throw new RegraNegocioException(
                    "Os dados da vacina são obrigatórios.");
        }

        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new RegraNegocioException(
                    "O nome da vacina é obrigatório.");
        }

        if (dto.getDataAplicacao() == null) {
            throw new RegraNegocioException(
                    "A data de aplicação é obrigatória.");
        }

        if (dto.getDataAplicacao().isAfter(LocalDate.now())) {
            throw new RegraNegocioException(
                    "A data de aplicação não pode ser futura.");
        }

        if (dto.getLote() == null || dto.getLote().isBlank()) {
            throw new RegraNegocioException(
                    "O lote da vacina é obrigatório.");
        }

        if (dto.getAnimalId() == null) {
            throw new RegraNegocioException(
                    "Informe o animal que recebeu a vacina.");
        }

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Animal não encontrado."));

        VacinaAplicada vacina = new VacinaAplicada(
                dto.getNome().trim(),
                dto.getDataAplicacao(),
                dto.getLote().trim(),
                animal
        );

        vacinaRepository.save(vacina);
    }

    @Override
    @Transactional(readOnly = true)
    public DadosVacinaAplicadaDTO buscarPorId(Integer id) {

        VacinaAplicada vacina = vacinaRepository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Registro de vacinação não encontrado."));

        return converterParaDTO(vacina);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosVacinaAplicadaDTO> buscarHistoricoPorAnimal(
            Integer animalId) {

        if (animalId == null) {
            throw new RegraNegocioException(
                    "Informe o ID do animal.");
        }

        animalRepository.findById(animalId)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Animal não encontrado."));

        List<VacinaAplicada> vacinas =
                vacinaRepository.buscarHistoricoPorAnimal(animalId);

        List<DadosVacinaAplicadaDTO> resultado = new ArrayList<>();

        for (VacinaAplicada vacina : vacinas) {
            resultado.add(converterParaDTO(vacina));
        }

        return resultado;
    }

    private DadosVacinaAplicadaDTO converterParaDTO(
            VacinaAplicada vacina) {

        return new DadosVacinaAplicadaDTO(
                vacina.getId(),
                vacina.getNome(),
                vacina.getDataAplicacao(),
                vacina.getLote(),
                vacina.getAnimal().getId(),
                vacina.getAnimal().getNome()
        );
    }
}