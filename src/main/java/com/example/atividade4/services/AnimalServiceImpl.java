package com.example.atividade4.services;

import com.example.atividade4.dtos.AnimalDTO;
import com.example.atividade4.dtos.DadosAnimalDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Especie;
import com.example.atividade4.models.Tutor;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.EspecieRepository;
import com.example.atividade4.repositories.TutorRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final TutorRepository tutorRepository;
    private final EspecieRepository especieRepository;

    public AnimalServiceImpl(
            AnimalRepository animalRepository,
            TutorRepository tutorRepository,
            EspecieRepository especieRepository) {

        this.animalRepository = animalRepository;
        this.tutorRepository = tutorRepository;
        this.especieRepository = especieRepository;
    }

    @Override
    public void adicionar(AnimalDTO dto) {

        if (dto == null) {
            throw new RegraNegocioException(
                    "Os dados do animal são obrigatórios.");
        }

        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new RegraNegocioException(
                    "O nome do animal é obrigatório.");
        }

        if (dto.getRaca() == null || dto.getRaca().isBlank()) {
            throw new RegraNegocioException(
                    "A raça do animal é obrigatória.");
        }

        if (dto.getDataNascimento() == null) {
            throw new RegraNegocioException(
                    "A data de nascimento é obrigatória.");
        }

        if (dto.getDataNascimento().isAfter(LocalDate.now())) {
            throw new RegraNegocioException(
                    "A data de nascimento não pode ser futura.");
        }

        if (dto.getTutorId() == null) {
            throw new RegraNegocioException(
                    "O tutor do animal é obrigatório.");
        }

        if (dto.getEspecieId() == null) {
            throw new RegraNegocioException(
                    "A espécie do animal é obrigatória.");
        }

        Tutor tutor = tutorRepository.findById(dto.getTutorId())
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Tutor não encontrado."));

        Especie especie = especieRepository.findById(dto.getEspecieId())
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Espécie não encontrada."));

        Animal animal = new Animal(
                dto.getNome().trim(),
                dto.getRaca().trim(),
                dto.getDataNascimento(),
                tutor,
                especie
        );

        animalRepository.save(animal);
    }

    @Override
    @Transactional(readOnly = true)
    public DadosAnimalDTO buscarPorId(Integer id) {

        Animal animal = animalRepository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Animal não encontrado."));

        return converterParaDTO(animal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosAnimalDTO> listarTodos() {

        List<Animal> animais = animalRepository.findAll();

        List<DadosAnimalDTO> resultado = new ArrayList<>();

        for (Animal animal : animais) {
            resultado.add(converterParaDTO(animal));
        }

        return resultado;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosAnimalDTO> buscarPorTutor(Integer tutorId) {

        if (tutorId == null) {
            throw new RegraNegocioException(
                    "Informe o ID do tutor.");
        }

        tutorRepository.findById(tutorId)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Tutor não encontrado."));

        List<Animal> animais =
                animalRepository.buscarAnimaisPorTutor(tutorId);

        List<DadosAnimalDTO> resultado = new ArrayList<>();

        for (Animal animal : animais) {
            resultado.add(converterParaDTO(animal));
        }

        return resultado;
    }

    private DadosAnimalDTO converterParaDTO(Animal animal) {

        return new DadosAnimalDTO(
                animal.getId(),
                animal.getNome(),
                animal.getRaca(),
                animal.getDataNascimento(),
                animal.getTutor().getId(),
                animal.getTutor().getNome(),
                animal.getEspecie().getId(),
                animal.getEspecie().getNome()
        );
    }
}