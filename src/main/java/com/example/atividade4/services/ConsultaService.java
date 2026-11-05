package com.example.atividade4.services;

import com.example.atividade4.dtos.ConsultaDTO;
import com.example.atividade4.dtos.DadosConsultaDTO;

import java.util.List;

public interface ConsultaService {

    void adicionar(ConsultaDTO consulta);

    DadosConsultaDTO buscarPorId(Integer id);

    List<DadosConsultaDTO> listarTodos();

    List<DadosConsultaDTO> buscarPorAnimal(Integer animalId);

    void cancelar(Integer id);

}