package com.saep.plural.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    private Integer alunoId;

    @Column(name = "aluno_nome")
    private String alunoNome;

    @Column(name = "aluno_cpf")
    private String alunoCpf;

    @OneToMany(mappedBy = "aluno")
    private List<Responsaveis> responsaveis;

    public Alunos() {
    }

    public Alunos(Integer alunoId, String alunoNome, String alunoCpf,
            List<Responsaveis> responsaveis) {
        this.alunoId = alunoId;
        this.alunoNome = alunoNome;
        this.alunoCpf = alunoCpf;
        this.responsaveis = responsaveis;
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(String alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public List<Responsaveis> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(List<Responsaveis> responsaveis) {
        this.responsaveis = responsaveis;
    }
}