package com.example.atividade4.dtos;

import java.time.LocalDate;

public class VacinaAplicadaDTO {

    private String nome;
    private LocalDate dataAplicacao;
    private String lote;
    private Integer animalId;

    public VacinaAplicadaDTO() {
    }

    public VacinaAplicadaDTO(String nome, LocalDate dataAplicacao, String lote, Integer animalId) {
        this.nome = nome;
        this.dataAplicacao = dataAplicacao;
        this.lote = lote;
        this.animalId = animalId;
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
}