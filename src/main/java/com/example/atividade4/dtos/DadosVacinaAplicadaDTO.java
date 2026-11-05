package com.example.atividade4.dtos;

import java.time.LocalDate;

public class DadosVacinaAplicadaDTO {

    private Integer id;
    private String nome;
    private LocalDate dataAplicacao;
    private String lote;
    private Integer animalId;
    private String nomeAnimal;

    public DadosVacinaAplicadaDTO() {
    }

    public DadosVacinaAplicadaDTO(Integer id, String nome,
            LocalDate dataAplicacao,
            String lote, Integer animalId,
            String nomeAnimal) {
        this.id = id;
        this.nome = nome;
        this.dataAplicacao = dataAplicacao;
        this.lote = lote;
        this.animalId = animalId;
        this.nomeAnimal = nomeAnimal;
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

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
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
}