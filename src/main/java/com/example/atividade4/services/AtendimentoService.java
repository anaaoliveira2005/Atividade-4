package com.example.atividade4.services;

import com.example.atividade4.dtos.AtendimentoDTO;
import com.example.atividade4.dtos.DadosAtendimentoDTO;

import java.util.List;

public interface AtendimentoService {

    void adicionar(AtendimentoDTO atendimento);

    DadosAtendimentoDTO buscarPorId(Integer id);

    List<DadosAtendimentoDTO> buscarHistoricoPorAnimal(
            Integer animalId);

}