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

import com.saep.plural.models.Responsaveis;
import com.saep.plural.services.ResponsaveisService;

@RestController
@RequestMapping("/responsaveis")
public class ResponsaveisController {

    private final ResponsaveisService responsaveisService;

    public ResponsaveisController(ResponsaveisService responsaveisService) {
        this.responsaveisService = responsaveisService;
    }

    @GetMapping("/contar-responsaveis")
    public Long contarResponsaveis() {
        return responsaveisService.countResponsaveis();
    }

    @PostMapping("/salvar-responsaveis")
    public Responsaveis salvarResponsavel(@RequestBody Responsaveis responsavel) {
        return responsaveisService.cadastrarResponsavel(responsavel);
    }

    @GetMapping("/listar-responsaveis")
    public List<Responsaveis> listarResponsaveis() {
        return responsaveisService.buscarTodosResponsaveis();
    }

    @GetMapping("/buscar-responsaveis/{id}")
    public Responsaveis buscarResponsavelPorId(@PathVariable Integer id) {
        return responsaveisService.buscarResponsavelPorId(id);
    }

    @DeleteMapping("/deletar-responsaveis/{id}")
    public String deletarResponsavel(@PathVariable Integer id) {
        boolean deletado = responsaveisService.deletarResponsavel(id);

        if (deletado) {
            return "Responsável com ID " + id + " deletado com sucesso.";
        } else {
            return "Responsável com ID " + id + " não encontrado.";
        }
    }

    @PutMapping("/atualizar-responsaveis/{id}")
    public String atualizarResponsavel(
            @PathVariable Integer id,
            @RequestBody Responsaveis responsaveis) {

        if (responsaveisService.atualizarResponsavel(id, responsaveis) != null) {
            return "Responsável com ID " + id + " atualizado com sucesso.";
        }

        return "Erro ao atualizar responsável";
    }
}