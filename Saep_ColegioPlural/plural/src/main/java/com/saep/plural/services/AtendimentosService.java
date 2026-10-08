package com.saep.plural.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saep.plural.models.Atendimentos;
import com.saep.plural.repositories.AtendimentosRepository;

@Service
public class AtendimentosService {
    private final AtendimentosRepository atendimentosRepository;

    public AtendimentosService(AtendimentosRepository atendimentosRepository) {
        this.atendimentosRepository = atendimentosRepository;
    }

    public Long countAtendimentos() {
        return atendimentosRepository.count();
    }

    public Atendimentos buscarAtendimentoPorId(Integer id) {
        return atendimentosRepository.findById(id).orElse(null);
    }

    public List<Atendimentos> buscarTodosAtendimentos() {
        return atendimentosRepository.findAll();
    }

    public boolean deletarAtendimento(Integer id) {
        if (atendimentosRepository.existsById(id)) {
            atendimentosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Atendimentos cadastrarAtendimento(Atendimentos atendimento) {
        return atendimentosRepository.save(atendimento);
    }

    public Atendimentos atualizarAtendimento(Integer id, Atendimentos atendimentos) {
        Atendimentos atendimentoRecuperado = buscarAtendimentoPorId(id);
        if(atendimentoRecuperado != null) {
            atendimentoRecuperado.setAtendimentoId(id);
        
            if (atendimentos.getAtendimentoDescricao() != null) {
                atendimentoRecuperado.setAtendimentoDescricao(atendimentos.getAtendimentoDescricao());
            }
            if (atendimentos.getAtendimentoData() != null) {
                atendimentoRecuperado.setAtendimentoData(atendimentos.getAtendimentoData());
            }
            if (atendimentos.getAtendimentoNome() != null) {
                atendimentoRecuperado.setAtendimentoNome(atendimentos.getAtendimentoNome());
            }
            if (atendimentos.getAluno() != null) {
                atendimentoRecuperado.setAluno(atendimentos.getAluno());
            }
            return atendimentosRepository.save(atendimentoRecuperado);
        }
        return null;
    }
}
