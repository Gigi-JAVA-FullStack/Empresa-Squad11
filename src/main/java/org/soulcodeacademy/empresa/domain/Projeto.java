package org.soulcodeacademy.empresa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProjeto;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double orcamento;

    @Column(nullable = false, length = 200)
    private String descricao;

    public Projeto() {}

    public Projeto(Integer idProjeto, String nome, Double orcamento, String descricao) {
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.orcamento = orcamento;
        this.descricao = descricao;
    }

    public Integer getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        // Compara se estão no mesmo local da memória
        if (this == o) return true;
        // Se o é nulo OU a classe dos dois for diferente então são diferentes
        if (o == null || getClass() != o.getClass()) return false;
        Projeto projeto = (Projeto) o; // Tenta converter o objeto genérico para Projeto
        // Se o ID dos objetos forem iguais então os objetos são iguais
        return idProjeto.equals(projeto.idProjeto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProjeto);
    }
}
