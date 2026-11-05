package com.example.atividade4.repositories;

import com.example.atividade4.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TutorRepository
        extends JpaRepository<Tutor, Integer> {

    Optional<Tutor> findByCpf(String cpf);

}
