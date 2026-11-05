package com.example.atividade4.dtos;

import java.time.LocalDate;

public class AnimalDTO {

    private String nome;
    private String raca;
    private LocalDate dataNascimento;
    private Integer tutorId;
    private Integer especieId;

    public AnimalDTO() {
    }

    public AnimalDTO(String nome, String raca, LocalDate dataNascimento, Integer tutorId, Integer especieId) {
        this.nome = nome;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.tutorId = tutorId;
        this.especieId = especieId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
    }

    public Integer getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Integer especieId) {
        this.especieId = especieId;
    }
}