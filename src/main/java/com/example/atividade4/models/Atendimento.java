package com.example.atividade4.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 2000)
    private String diagnostico;

    @Column(nullable = false, length = 2000)
    private String observacoes;

    @Column(nullable = false, length = 2000)
    private String orientacoes;

    @OneToOne
    @JoinColumn(name = "consulta_id", nullable = false, unique = true)
    private Consulta consulta;

    public Atendimento() {
    }

    public Atendimento(String diagnostico, String observacoes, String orientacoes, Consulta consulta) {
        this.diagnostico = diagnostico;
        this.observacoes = observacoes;
        this.orientacoes = orientacoes;
        this.consulta = consulta;
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

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}