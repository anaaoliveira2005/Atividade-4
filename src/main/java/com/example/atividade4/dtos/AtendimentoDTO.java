package com.example.atividade4.dtos;

public class AtendimentoDTO {

    private String diagnostico;
    private String observacoes;
    private String orientacoes;
    private Integer consultaId;

    public AtendimentoDTO() {
    }

    public AtendimentoDTO(String diagnostico, String observacoes, String orientacoes, Integer consultaId) {
        this.diagnostico = diagnostico;
        this.observacoes = observacoes;
        this.orientacoes = orientacoes;
        this.consultaId = consultaId;
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
}