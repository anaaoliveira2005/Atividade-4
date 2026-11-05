package com.example.atividade4.dtos;

import java.util.ArrayList;
import java.util.List;

public class DadosVeterinarioDTO {

    private Integer id;
    private String nome;
    private String crmv;
    private List<DadosEspecieDTO> especies = new ArrayList<>();

    public DadosVeterinarioDTO() {
    }

    public DadosVeterinarioDTO(Integer id, String nome, String crmv, List<DadosEspecieDTO> especies) {
        this.id = id;
        this.nome = nome;
        this.crmv = crmv;
        this.especies = especies;
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

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public List<DadosEspecieDTO> getEspecies() {
        return especies;
    }

    public void setEspecies(List<DadosEspecieDTO> especies) {
        this.especies = especies;
    }
}