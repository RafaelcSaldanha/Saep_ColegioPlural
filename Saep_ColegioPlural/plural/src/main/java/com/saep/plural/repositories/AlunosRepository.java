package com.saep.plural.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saep.plural.models.Alunos;
public interface AlunosRepository extends JpaRepository<Alunos, Integer> {
    
}
