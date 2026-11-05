
package com.example.atividade4.services;

import com.example.atividade4.dtos.AtendimentoDTO;
import com.example.atividade4.dtos.DadosAtendimentoDTO;
import com.example.atividade4.exceptions.RegraNegocioException;
import com.example.atividade4.models.Atendimento;
import com.example.atividade4.models.Consulta;
import com.example.atividade4.repositories.AtendimentoRepository;
import com.example.atividade4.repositories.ConsultaRepository;

import com.example.atividade4.enums.StatusConsulta;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AtendimentoServiceImpl implements AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final ConsultaRepository consultaRepository;

    public AtendimentoServiceImpl(
            AtendimentoRepository atendimentoRepository,
            ConsultaRepository consultaRepository) {

        this.atendimentoRepository = atendimentoRepository;
        this.consultaRepository = consultaRepository;
    }

    @Override
    public void adicionar(AtendimentoDTO dto) {

        if (dto == null) {
            throw new RegraNegocioException(
                    "Os dados do atendimento são obrigatórios.");
        }

        if (dto.getDiagnostico() == null
                || dto.getDiagnostico().isBlank()) {
            throw new RegraNegocioException(
                    "O diagnóstico é obrigatório.");
        }

        if (dto.getObservacoes() == null
                || dto.getObservacoes().isBlank()) {
            throw new RegraNegocioException(
                    "As observações são obrigatórias.");
        }

        if (dto.getOrientacoes() == null
                || dto.getOrientacoes().isBlank()) {
            throw new RegraNegocioException(
                    "As orientações são obrigatórias.");
        }

        if (dto.getConsultaId() == null) {
            throw new RegraNegocioException(
                    "Informe a consulta relacionada ao atendimento.");
        }

        Consulta consulta = consultaRepository
                .findById(dto.getConsultaId())
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Consulta não encontrada."));

        if (consulta.getStatus() == StatusConsulta.CANCELADA) {
            throw new RegraNegocioException(
                    "Não é possível registrar atendimento em uma consulta cancelada.");
        }

        if (atendimentoRepository
                .findByConsultaId(dto.getConsultaId()).isPresent()) {
            throw new RegraNegocioException(
                    "Essa consulta já possui um atendimento registrado.");
        }

        Atendimento atendimento = new Atendimento(
                dto.getDiagnostico().trim(),
                dto.getObservacoes().trim(),
                dto.getOrientacoes().trim(),
                consulta
        );

        consulta.setAtendimento(atendimento);
        consulta.setStatus(StatusConsulta.REALIZADA);

        atendimentoRepository.save(atendimento);
        consultaRepository.save(consulta);
    }

    @Override
    @Transactional(readOnly = true)
    public DadosAtendimentoDTO buscarPorId(Integer id) {

        Atendimento atendimento = atendimentoRepository.findById(id)
                .orElseThrow(() ->
                        new RegraNegocioException(
                                "Atendimento não encontrado."));

        return converterParaDTO(atendimento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DadosAtendimentoDTO> buscarHistoricoPorAnimal(
            Integer animalId) {

        if (animalId == null) {
            throw new RegraNegocioException(
                    "Informe o ID do animal.");
        }

        List<Atendimento> atendimentos =
                atendimentoRepository.buscarHistoricoPorAnimal(animalId);

        List<DadosAtendimentoDTO> resultado = new ArrayList<>();

        for (Atendimento atendimento : atendimentos) {
            resultado.add(converterParaDTO(atendimento));
        }

        return resultado;
    }

    private DadosAtendimentoDTO converterParaDTO(
            Atendimento atendimento) {

        Consulta consulta = atendimento.getConsulta();

        return new DadosAtendimentoDTO(
                atendimento.getId(),
                atendimento.getDiagnostico(),
                atendimento.getObservacoes(),
                atendimento.getOrientacoes(),
                consulta.getId(),
                consulta.getData(),
                consulta.getAnimal().getNome(),
                consulta.getVeterinario().getNome()
        );
    }
}