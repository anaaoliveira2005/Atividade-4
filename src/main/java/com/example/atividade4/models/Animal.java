
package com.example.atividade4.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String raca;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "especie_id", nullable = false)
    private Especie especie;

    @OneToMany(mappedBy = "animal")
    private List<Consulta> consultas = new ArrayList<>();

    @OneToMany(mappedBy = "animal")
    private List<VacinaAplicada> vacinas = new ArrayList<>();

    public Animal() {
    }

    public Animal(String nome, String raca, LocalDate dataNascimento, Tutor tutor, Especie especie) {
        this.nome = nome;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.tutor = tutor;
        this.especie = especie;
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

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<VacinaAplicada> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<VacinaAplicada> vacinas) {
        this.vacinas = vacinas;
    }
}