package com.example.atividade4.dtos;

public class EspecieDTO {

    private String nome;

    public EspecieDTO() {
    }

    public EspecieDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}