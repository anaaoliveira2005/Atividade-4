package com.example.atividade4.repositories;

import com.example.atividade4.models.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EspecieRepository
        extends JpaRepository<Especie, Integer> {

    Optional<Especie> findByNomeIgnoreCase(String nome);

}
