package com.saep.plural.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "responsaveis")
public class Responsaveis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "responsavel_id")
    private Integer responsavelId;

    @Column(name = "responsavel_nome")
    private String responsavelNome;

    @Column(name = "responsavel_cpf")
    private String responsavelCpf;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Alunos aluno;

    public Responsaveis() {
    }

    public Responsaveis(Integer responsavelId, String responsavelNome,
            String responsavelCpf, Alunos aluno) {
        this.responsavelId = responsavelId;
        this.responsavelNome = responsavelNome;
        this.responsavelCpf = responsavelCpf;
        this.aluno = aluno;
    }

    public Integer getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Integer responsavelId) {
        this.responsavelId = responsavelId;
    }

    public String getResponsavelNome() {
        return responsavelNome;
    }

    public void setResponsavelNome(String responsavelNome) {
        this.responsavelNome = responsavelNome;
    }

    public String getResponsavelCpf() {
        return responsavelCpf;
    }

    public void setResponsavelCpf(String responsavelCpf) {
        this.responsavelCpf = responsavelCpf;
    }

    public Alunos getAluno() {
        return aluno;
    }

    public void setAluno(Alunos aluno) {
        this.aluno = aluno;
    }
}