package com.example.atividade4.services;

import com.example.atividade4.dtos.AnimalDTO;
import com.example.atividade4.dtos.DadosAnimalDTO;

import java.util.List;

public interface AnimalService {

    void adicionar(AnimalDTO animal);

    DadosAnimalDTO buscarPorId(Integer id);

    List<DadosAnimalDTO> listarTodos();

    List<DadosAnimalDTO> buscarPorTutor(Integer tutorId);

}