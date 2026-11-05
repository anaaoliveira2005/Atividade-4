package com.example.atividade4.services;

import com.example.atividade4.dtos.TutorDTO;
import com.example.atividade4.dtos.DadosTutorDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Tutor;
import com.example.atividade4.repositories.TutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public void adicionar(TutorDTO dto) {

        if (dto == null) {
            throw new RegraNegocioException(
                    "Os dados do tutor são obrigatórios.");
        }

        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new RegraNegocioException(
                    "O nome do tutor é obrigatório.");
        }

        if (dto.getCpf() == null || dto.getCpf().isBlank()) {
            throw new RegraNegocioException(
                    "O CPF do tutor é obrigatório.");
        }

        if (dto.getTelefone() == null
                || dto.getTelefone().isBlank()) {
            throw new RegraNegocioException(
                    "O telefone do tutor é obrigatório.");
        }

        if (dto.getEndereco() == null
                || dto.getEndereco().isBlank()) {
            throw new RegraNegocioException(
                    "O endereço do tutor é obrigatório.");
        }

        String cpf = dto.getCpf().replaceAll("\\D", "");

        if (cpf.length() != 11) {
            throw new RegraNegocioException(
                    "O CPF deve possuir 11 números.");
        }

        if (tutorRepository.findByCpf(cpf).isPresent()) {
            throw new RegraNegocioException(
                    "Já existe um tutor cadastrado com esse CPF.");
        }

        Tutor tutor = new Tutor(
                dto.getNome().trim(),
                cpf,
                dto.getTelefone().trim(),
                dto.getEndereco().trim());

        tutorRepository.save(tutor);
    }

    @Override
    @Transactional(readOnly = true)
    public DadosTutorDTO buscarPorId(Integer id) {

        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException(
                        "Tutor não encontrado."));

        return converterParaDTO(tutor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosTutorDTO> listarTodos() {

        List<Tutor> tutores = tutorRepository.findAll();

        List<DadosTutorDTO> resultado = new ArrayList<>();

        for (Tutor tutor : tutores) {
            resultado.add(converterParaDTO(tutor));
        }

        return resultado;
    }

    private DadosTutorDTO converterParaDTO(Tutor tutor) {

        return new DadosTutorDTO(
                tutor.getId(),
                tutor.getNome(),
                tutor.getCpf(),
                tutor.getTelefone(),
                tutor.getEndereco());
    }
}