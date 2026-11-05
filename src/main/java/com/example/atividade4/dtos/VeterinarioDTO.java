package com.example.atividade4.dtos;

import java.util.ArrayList;
import java.util.List;

public class VeterinarioDTO {

    private String nome;
    private String crmv;
    private List<Integer> especiesIds = new ArrayList<>();

    public VeterinarioDTO() {
    }

    public VeterinarioDTO(String nome, String crmv, List<Integer> especiesIds) {
        this.nome = nome;
        this.crmv = crmv;
        this.especiesIds = especiesIds;
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

    public List<Integer> getEspeciesIds() {
        return especiesIds;
    }

    public void setEspeciesIds(List<Integer> especiesIds) {
        this.especiesIds = especiesIds;
    }
}