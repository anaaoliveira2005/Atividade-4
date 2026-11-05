package com.example.atividade4.services;

import com.example.atividade4.dtos.VacinaAplicadaDTO;
import com.example.atividade4.dtos.DadosVacinaAplicadaDTO;

import java.util.List;

public interface VacinaAplicadaService {

    void adicionar(VacinaAplicadaDTO vacina);

    DadosVacinaAplicadaDTO buscarPorId(Integer id);

    List<DadosVacinaAplicadaDTO> buscarHistoricoPorAnimal(
            Integer animalId);

}