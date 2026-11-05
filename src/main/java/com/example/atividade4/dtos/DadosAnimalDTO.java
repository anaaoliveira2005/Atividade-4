package com.example.atividade4.dtos;

import java.time.LocalDate;

public class DadosAnimalDTO {

    private Integer id;
    private String nome;
    private String raca;
    private LocalDate dataNascimento;
    private Integer tutorId;
    private String nomeTutor;
    private Integer especieId;
    private String nomeEspecie;

    public DadosAnimalDTO() {
    }

    public DadosAnimalDTO(Integer id, String nome, String raca, LocalDate dataNascimento, Integer tutorId, String nomeTutor, Integer especieId, String nomeEspecie) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.tutorId = tutorId;
        this.nomeTutor = nomeTutor;
        this.especieId = especieId;
        this.nomeEspecie = nomeEspecie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    public Integer getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Integer especieId) {
        this.especieId = especieId;
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }
}