package com.example.atividade4.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaDTO {

    private String local;
    private LocalDate data;
    private LocalTime horario;
    private Integer animalId;
    private Integer veterinarioId;

    public ConsultaDTO() {
    }

    public ConsultaDTO(String local, LocalDate data, LocalTime horario, Integer animalId, Integer veterinarioId) {
        this.local = local;
        this.data = data;
        this.horario = horario;
        this.animalId = animalId;
        this.veterinarioId = veterinarioId;
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

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public Integer getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Integer veterinarioId) {
        this.veterinarioId = veterinarioId;
    }
}