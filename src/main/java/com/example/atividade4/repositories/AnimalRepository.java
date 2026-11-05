package com.example.atividade4.repositories;

import com.example.atividade4.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AnimalRepository
        extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a " +
           "JOIN FETCH a.especie " +
           "WHERE a.tutor.id = :tutorId")
    List<Animal> buscarAnimaisPorTutor(
            @Param("tutorId") Integer tutorId);

}
