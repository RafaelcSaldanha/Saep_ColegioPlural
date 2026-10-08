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

import com.saep.plural.models.Atendimentos;
import com.saep.plural.services.AtendimentosService;

@RestController 
@RequestMapping("/atendimentos")
public class AtendimentosController {
    private final AtendimentosService atendimentosService;
    
    public AtendimentosController(AtendimentosService atendimentosService, ResponsaveisController responsaveisController) {
        this.atendimentosService = atendimentosService;
    }

    @GetMapping("/contar-atendimentos")
    public Long contarAtendimentos() {
        return atendimentosService.countAtendimentos();
    }

    @PostMapping("/salvar-atendimentos")
    public Atendimentos salvarAtendimento(@RequestBody Atendimentos atendimento) {
        return atendimentosService.cadastrarAtendimento(atendimento);
    }

    @GetMapping ("/listar-atendimentos")
    public List<Atendimentos> listarAtendimentos() {
        return atendimentosService.buscarTodosAtendimentos();
    }

    @GetMapping ("/buscar-atendimentos/{id}")
    public Atendimentos buscarAtendimentoPorId(@PathVariable Integer id) {
        return atendimentosService.buscarAtendimentoPorId(id);
    }

    @DeleteMapping("/deletar-atendimentos/{id}")
    public String deletarAtendimento(@PathVariable Integer id) {
        boolean deletado = atendimentosService.deletarAtendimento(id);
        if (deletado) {
            return "Atendimento com ID " + id + " deletado com sucesso.";
        } else {
            return "Atendimento com ID " + id + " não encontrado.";
        }
    }

    @PutMapping("/atualizar-atendimentos/{id}")
    public String atualizarAtendimento(@PathVariable Integer id, @RequestBody Atendimentos atendimentos) {
        if (atendimentosService.atualizarAtendimento(id, atendimentos) != null) {
            return "Atendimento com ID " + id + " atualizado com sucesso.";
        }
        return "erro ao atualizar atendimento";
    }
}
