package com.example.atividade4.services;

import com.example.atividade4.dtos.VeterinarioDTO;
import com.example.atividade4.dtos.DadosVeterinarioDTO;

import java.util.List;

public interface VeterinarioService {

    void adicionar(VeterinarioDTO veterinario);

    DadosVeterinarioDTO buscarPorId(Integer id);

    List<DadosVeterinarioDTO> listarTodos();

    List<DadosVeterinarioDTO> buscarPorEspecie(Integer especieId);

}