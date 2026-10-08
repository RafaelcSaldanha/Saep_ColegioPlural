package com.saep.plural.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saep.plural.models.Alunos;
import com.saep.plural.repositories.AlunosRepository;

@Service 
public class AlunosService {
    private final AlunosRepository alunosRepository;

    public AlunosService(AlunosRepository alunosRepository) {
        this.alunosRepository = alunosRepository;
    }

    public Long countAlunos() {
        return alunosRepository.count();
    }

    public Alunos buscarAlunoPorId(Integer id) {
        return alunosRepository.findById(id).orElse(null);
    }

    public List<Alunos> buscarTodosAlunos() {
        return alunosRepository.findAll();
    }

    public boolean deletarAluno(Integer id) {
        if (alunosRepository.existsById(id)) {
            alunosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Alunos cadastrarAluno(Alunos aluno) {
        return alunosRepository.save(aluno);
    }


    public Alunos atualizarAluno(Integer id, Alunos alunos) {
        Alunos alunoRecuperado = buscarAlunoPorId(id);
        if(alunoRecuperado != null) {
            alunoRecuperado.setAlunoId(id);
        
            if (alunos.getAlunoNome() != null) {
                alunoRecuperado.setAlunoNome(alunos.getAlunoNome());
            }
            if (alunos.getAlunoCpf() != null) {
                alunoRecuperado.setAlunoCpf(alunos.getAlunoCpf());
            }
            if (alunos.getResponsaveis() != null) {
                alunoRecuperado.setResponsaveis(alunos.getResponsaveis());
            }
            return alunosRepository.save(alunoRecuperado);
        }
        return null;
    }
}