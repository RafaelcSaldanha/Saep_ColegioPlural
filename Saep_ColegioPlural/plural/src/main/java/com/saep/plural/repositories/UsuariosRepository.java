package com.saep.plural.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saep.plural.models.Usuarios;
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    
}
