package com.example.atividade4.repositories;

import com.example.atividade4.models.Consulta;
import com.example.atividade4.enums.StatusConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ConsultaRepository
        extends JpaRepository<Consulta, Integer> {

    @Query("SELECT c FROM Consulta c " +
           "WHERE c.veterinario.id = :veterinarioId " +
           "AND c.data = :data " +
           "AND c.horario = :horario " +
           "AND c.status <> :status")
    List<Consulta> buscarAgendamentosNoHorario(
            @Param("veterinarioId") Integer veterinarioId,
            @Param("data") LocalDate data,
            @Param("horario") LocalTime horario,
            @Param("status") StatusConsulta status);

    @Query("SELECT c FROM Consulta c " +
           "JOIN FETCH c.animal " +
           "JOIN FETCH c.veterinario " +
           "WHERE c.animal.id = :animalId " +
           "ORDER BY c.data DESC, c.horario DESC")
    List<Consulta> buscarConsultasPorAnimal(
            @Param("animalId") Integer animalId);

}