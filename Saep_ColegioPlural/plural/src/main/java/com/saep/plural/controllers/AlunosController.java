package com.saep.plural.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saep.plural.models.Alunos;
import com.saep.plural.services.AlunosService;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private final AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @PostMapping("/salvar-alunos")
    public Alunos salvarAluno(@RequestBody Alunos aluno) {
        return alunosService.cadastrarAluno(aluno);
    }

    @GetMapping("/contar-alunos")
    public Long contarAlunos() {
        return alunosService.countAlunos();
    }

    @GetMapping("/listar-alunos")
    public List<Alunos> listarAlunos() {
        return alunosService.buscarTodosAlunos();
    }

    @GetMapping("/buscar-alunos/{id}")
    public Alunos buscarAlunoPorId(@PathVariable Integer id) {
        return alunosService.buscarAlunoPorId(id);
    }

    @DeleteMapping("/deletar-alunos/{id}")
    public String deletarAluno(@PathVariable Integer id) {
        boolean deletado = alunosService.deletarAluno(id);

        if (deletado) {
            return "Aluno com ID " + id + " deletado com sucesso.";
        } else {
            return "Aluno com ID " + id + " não encontrado.";
        }
    }

    @PutMapping("/atualizar-alunos/{id}")
    public String atualizarAluno(
            @PathVariable Integer id,
            @RequestBody Alunos alunos) {

        if (alunosService.atualizarAluno(id, alunos) != null) {
            return "Aluno com ID " + id + " atualizado com sucesso.";
        }

        return "Erro ao atualizar aluno";
    }
}