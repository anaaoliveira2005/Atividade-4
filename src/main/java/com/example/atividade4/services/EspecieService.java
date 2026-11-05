package com.example.atividade4.services;

import com.example.atividade4.dtos.EspecieDTO;
import com.example.atividade4.dtos.DadosEspecieDTO;

import java.util.List;

public interface EspecieService {

    void adicionar(EspecieDTO especie);

    DadosEspecieDTO buscarPorId(Integer id);

    List<DadosEspecieDTO> listarTodos();
}

