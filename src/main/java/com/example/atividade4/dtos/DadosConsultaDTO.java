package com.example.atividade4.dtos;

import com.example.atividade4.enums.StatusConsulta;
import java.time.LocalDate;
import java.time.LocalTime;

public class DadosConsultaDTO {

    private Integer id;
    private String local;
    private LocalDate data;
    private LocalTime horario;
    private StatusConsulta status;
    private Integer animalId;
    private String nomeAnimal;
    private Integer veterinarioId;
    private String nomeVeterinario;

    public DadosConsultaDTO() {
    }

    public DadosConsultaDTO(Integer id, String local, LocalDate data, LocalTime horario, StatusConsulta status,
            Integer animalId, String nomeAnimal, Integer veterinarioId, String nomeVeterinario) {
        this.id = id;
        this.local = local;
        this.data = data;
        this.horario = horario;
        this.status = status;
        this.animalId = animalId;
        this.nomeAnimal = nomeAnimal;
        this.veterinarioId = veterinarioId;
        this.nomeVeterinario = nomeVeterinario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public Integer getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Integer veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }

    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }
}