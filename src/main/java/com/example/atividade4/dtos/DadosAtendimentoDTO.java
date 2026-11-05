package com.example.atividade4.dtos;

import java.time.LocalDate;

public class DadosAtendimentoDTO {

    private Integer id;
    private String diagnostico;
    private String observacoes;
    private String orientacoes;
    private Integer consultaId;
    private LocalDate dataConsulta;
    private String nomeAnimal;
    private String nomeVeterinario;

    public DadosAtendimentoDTO() {
    }

    public DadosAtendimentoDTO(Integer id, String diagnostico,
            String observacoes, String orientacoes,
            Integer consultaId, LocalDate dataConsulta,
            String nomeAnimal, String nomeVeterinario) {

        this.id = id;
        this.diagnostico = diagnostico;
        this.observacoes = observacoes;
        this.orientacoes = orientacoes;
        this.consultaId = consultaId;
        this.dataConsulta = dataConsulta;
        this.nomeAnimal = nomeAnimal;
        this.nomeVeterinario = nomeVeterinario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getOrientacoes() {
        return orientacoes;
    }

    public void setOrientacoes(String orientacoes) {
        this.orientacoes = orientacoes;
    }

    public Integer getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Integer consultaId) {
        this.consultaId = consultaId;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }

    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }
}