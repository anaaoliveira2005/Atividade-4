package com.example.atividade4.repositories;

import com.example.atividade4.models.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface VeterinarioRepository
        extends JpaRepository<Veterinario, Integer> {

    Optional<Veterinario> findByCrmv(String crmv);

    @Query("SELECT DISTINCT v FROM Veterinario v " +
           "JOIN FETCH v.especies e " +
           "WHERE e.id = :especieId")
    List<Veterinario> buscarPorEspecie(
            @Param("especieId") Integer especieId);

}