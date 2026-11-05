package com.example.atividade4.services;

import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.dtos.DadosTutorDTO;

import java.util.List;

public interface TutorService {

    void adicionar(TutorDTO tutor);

    DadosTutorDTO buscarPorId(Integer id);

    List<DadosTutorDTO> listarTodos();

}