package com.saep.plural.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saep.plural.models.Atendimentos;
public interface AtendimentosRepository extends JpaRepository<Atendimentos, Integer> {
    
}
