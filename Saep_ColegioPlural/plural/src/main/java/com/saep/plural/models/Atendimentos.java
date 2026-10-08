package com.saep.plural.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "atendimentos")
public class Atendimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atendimento_id")
    private Integer atendimentoId;

    @Column(name = "atendimento_descricao")
    private String atendimentoDescricao;

    @Column(name = "atendimento_data")
    private String atendimentoData;

    @Column(name = "atendimento_nome")
    private String atendimentoNome;

    @OneToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "aluno_id")
    private Alunos aluno;

    public Atendimentos() {
    }

    public Atendimentos(Integer atendimentoId, String atendimentoDescricao,
            String atendimentoData, String atendimentoNome, Alunos aluno) {
        this.atendimentoId = atendimentoId;
        this.atendimentoDescricao = atendimentoDescricao;
        this.atendimentoData = atendimentoData;
        this.atendimentoNome = atendimentoNome;
        this.aluno = aluno;
    }

    public Integer getAtendimentoId() {
        return atendimentoId;
    }

    public void setAtendimentoId(Integer atendimentoId) {
        this.atendimentoId = atendimentoId;
    }

    public String getAtendimentoDescricao() {
        return atendimentoDescricao;
    }

    public void setAtendimentoDescricao(String atendimentoDescricao) {
        this.atendimentoDescricao = atendimentoDescricao;
    }

    public String getAtendimentoData() {
        return atendimentoData;
    }

    public void setAtendimentoData(String atendimentoData) {
        this.atendimentoData = atendimentoData;
    }

    public String getAtendimentoNome() {
        return atendimentoNome;
    }

    public void setAtendimentoNome(String atendimentoNome) {
        this.atendimentoNome = atendimentoNome;
    }

    public Alunos getAluno() {
        return aluno;
    }

    public void setAluno(Alunos aluno) {
        this.aluno = aluno;
    }
}