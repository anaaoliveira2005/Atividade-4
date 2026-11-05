package com.example.atividade4.services;

import com.example.atividade4.dtos.VeterinarioDTO;
import com.example.atividade4.dtos.DadosVeterinarioDTO;
import com.example.atividade4.dtos.DadosEspecieDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Especie;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.repositories.EspecieRepository;
import com.example.atividade4.repositories.VeterinarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;
    private final EspecieRepository especieRepository;

    public VeterinarioServiceImpl(
            VeterinarioRepository veterinarioRepository,
            EspecieRepository especieRepository) {

        this.veterinarioRepository = veterinarioRepository;
        this.especieRepository = especieRepository;
    }

    @Override
    public void adicionar(VeterinarioDTO dto) {

        if (dto == null) {
            throw new RegraNegocioException(
                    "Os dados do veterinário são obrigatórios.");
        }

        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new RegraNegocioException(
                    "O nome do veterinário é obrigatório.");
        }

        if (dto.getCrmv() == null || dto.getCrmv().isBlank()) {
            throw new RegraNegocioException(
                    "O CRMV do veterinário é obrigatório.");
        }

        if (dto.getEspeciesIds() == null
                || dto.getEspeciesIds().isEmpty()) {
            throw new RegraNegocioException(
                    "Informe pelo menos uma espécie que o veterinário atende.");
        }

        String crmv = dto.getCrmv().trim();

        if (veterinarioRepository.findByCrmv(crmv).isPresent()) {
            throw new RegraNegocioException(
                    "Já existe um veterinário com esse CRMV.");
        }

        List<Especie> especies = new ArrayList<>();

        for (Integer especieId : dto.getEspeciesIds()) {

            if (especieId == null) {
                throw new RegraNegocioException(
                        "O ID da espécie não pode ser vazio.");
            }

            for (Especie especie : especies) {
                if (especie.getId().equals(especieId)) {
                    throw new RegraNegocioException(
                            "Não informe a mesma espécie mais de uma vez.");
                }
            }

            Especie especie = especieRepository.findById(especieId)
                    .orElseThrow(() ->
                            new RegraNegocioException(
                                    "Espécie não encontrada: " + especieId));

            especies.add(especie);
        }

        Veterinario veterinario = new Veterinario(
                dto.getNome().trim(),
                crmv
        );

        veterinario.setEspecies(especies);

        veterinarioRepository.save(veterinario);
    }

    @Override
    @Transactional(readOnly = true)
    public DadosVeterinarioDTO buscarPorId(Integer id) {

        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Veterinário não encontrado."));

        return converterParaDTO(veterinario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosVeterinarioDTO> listarTodos() {

        List<Veterinario> veterinarios =
                veterinarioRepository.findAll();

        List<DadosVeterinarioDTO> resultado = new ArrayList<>();

        for (Veterinario veterinario : veterinarios) {
            resultado.add(converterParaDTO(veterinario));
        }

        return resultado;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosVeterinarioDTO> buscarPorEspecie(
            Integer especieId) {

        if (especieId == null) {
            throw new RegraNegocioException(
                    "Informe o ID da espécie.");
        }

        especieRepository.findById(especieId)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Espécie não encontrada."));

        List<Veterinario> veterinarios =
                veterinarioRepository.buscarPorEspecie(especieId);

        List<DadosVeterinarioDTO> resultado = new ArrayList<>();

        for (Veterinario veterinario : veterinarios) {
            resultado.add(converterParaDTO(veterinario));
        }

        return resultado;
    }

    private DadosVeterinarioDTO converterParaDTO(
            Veterinario veterinario) {

        List<DadosEspecieDTO> especies = new ArrayList<>();

        for (Especie especie : veterinario.getEspecies()) {

            especies.add(
                    new DadosEspecieDTO(
                            especie.getId(),
                            especie.getNome()
                    )
            );
        }

        return new DadosVeterinarioDTO(
                veterinario.getId(),
                veterinario.getNome(),
                veterinario.getCrmv(),
                especies
        );
    }
}