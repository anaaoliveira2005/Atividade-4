package com.example.atividade4.services;

import com.example.atividade4.dtos.EspecieDTO;
import com.example.atividade4.dtos.DadosEspecieDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Especie;
import com.example.atividade4.repositories.EspecieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EspecieServiceImpl implements EspecieService {

    private final EspecieRepository especieRepository;

    public EspecieServiceImpl(
            EspecieRepository especieRepository) {
        this.especieRepository = especieRepository;
    }

    @Override
    public void adicionar(EspecieDTO dto) {

        if (dto == null) {
            throw new RegraNegocioException(
                    "Os dados da espécie são obrigatórios.");
        }

        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new RegraNegocioException(
                    "O nome da espécie é obrigatório.");
        }

        String nome = dto.getNome().trim();

        if (especieRepository.findByNomeIgnoreCase(nome).isPresent()) {
            throw new RegraNegocioException(
                    "Essa espécie já está cadastrada.");
        }

        Especie especie = new Especie(nome);

        especieRepository.save(especie);
    }

    @Override
    @Transactional(readOnly = true)
    public DadosEspecieDTO buscarPorId(Integer id) {

        Especie especie = especieRepository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Espécie não encontrada."));

        return converterParaDTO(especie);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosEspecieDTO> listarTodos() {

        List<Especie> especies = especieRepository.findAll();

        List<DadosEspecieDTO> resultado = new ArrayList<>();

        for (Especie especie : especies) {
            resultado.add(converterParaDTO(especie));
        }

        return resultado;
    }

    private DadosEspecieDTO converterParaDTO(Especie especie) {

        return new DadosEspecieDTO(
                especie.getId(),
                especie.getNome()
        );
    }
}