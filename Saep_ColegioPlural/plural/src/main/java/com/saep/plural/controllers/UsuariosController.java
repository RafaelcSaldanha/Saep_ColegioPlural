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

import com.saep.plural.models.Usuarios;
import com.saep.plural.services.UsuariosService;

@RestController 
@RequestMapping ("/usuarios")
public class UsuariosController {
    private final UsuariosService usuariosService;
    
    public UsuariosController(UsuariosService usuariosService, ResponsaveisController responsaveisController) {
        this.usuariosService = usuariosService;
    }

    @GetMapping("/contar-usuarios")
    public Long contarUsuarios() {
        return usuariosService.countUsuarios();
    }

    @PostMapping("/salvar-usuarios")
    public Usuarios salvarUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.cadastrarUsuario(usuario);
    }

    @GetMapping ("/listar-usuarios")
    public List<Usuarios> listarUsuarios() {
        return usuariosService.buscarTodosUsuarios();
    }

    @GetMapping ("/buscar-usuarios/{id}")
    public Usuarios buscarUsuarioPorId(@PathVariable Integer id) {
        return usuariosService.buscarUsuarioPorId(id);
    }

    @DeleteMapping("/deletar-usuarios/{id}")
    public String deletarUsuario(@PathVariable Integer id) {
        boolean deletado = usuariosService.deletarUsuario(id);
        if (deletado) {
            return "Usuário com ID " + id + " deletado com sucesso.";
        } else {
            return "Usuário com ID " + id + " não encontrado.";
        }
    }

    @PutMapping("/atualizar-usuarios/{id}")
    public String atualizarUsuario(@PathVariable Integer id, @RequestBody Usuarios usuarios) {
        if (usuariosService.atualizarUsuario(id, usuarios) != null) {
            return "Usuário com ID " + id + " atualizado com sucesso.";
        }
        return "erro ao atualizar usuário";
    }
}
