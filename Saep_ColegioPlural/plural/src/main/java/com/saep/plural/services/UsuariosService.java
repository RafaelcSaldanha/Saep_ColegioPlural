package com.saep.plural.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saep.plural.models.Usuarios;
import com.saep.plural.repositories.UsuariosRepository;

@Service 
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public Long countUsuarios() {
        return usuariosRepository.count();
    }

    public Usuarios buscarUsuarioPorId(Integer id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    public List<Usuarios> buscarTodosUsuarios() {
        return usuariosRepository.findAll();
    }

    public boolean deletarUsuario(Integer id) {
        if (usuariosRepository.existsById(id)) {
            usuariosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Usuarios cadastrarUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    public Usuarios atualizarUsuario(Integer id, Usuarios usuarios) {
        Usuarios usuarioRecuperado = buscarUsuarioPorId(id);
        if(usuarioRecuperado != null) {
            usuarioRecuperado.setUsuarioId(id);
        
            if (usuarios.getUsuarioNome() != null) {
                usuarioRecuperado.setUsuarioNome(usuarios.getUsuarioNome());
            }
            if (usuarios.getUsuarioCpf() != null) {
                usuarioRecuperado.setUsuarioCpf(usuarios.getUsuarioCpf());
            }
            if (usuarios.getAtendimento() != null) {
                usuarioRecuperado.setAtendimento(usuarios.getAtendimento());
            }
            return usuariosRepository.save(usuarioRecuperado);
        }
        return null;
    }
}
