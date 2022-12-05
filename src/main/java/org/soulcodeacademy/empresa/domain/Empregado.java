package org.soulcodeacademy.empresa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Empregado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpregado;

    @Column(length = 120, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private Double salario;

    @OneToOne(cascade = CascadeType.REMOVE) // 1:1 (Empregado-Endereço)
    // cascate = uma ação desencadeia outra ação, remover o empregado vai remover seus dependentes, indicado para rel 1:1
    @JoinColumn(name = "id_endereco") // renomeia a coluna da FK
    private Endereco endereco;

    // Esta lista representa quais projetos o empregado participa
    @ManyToMany(fetch = FetchType.EAGER) // EAGER = antecipa os dados de projeto
    private List<Projeto> projetos = new ArrayList<>();

    public Empregado() {
    }

    public Empregado( String nome, String email, Double salario) {

        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public Integer getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(Integer idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(Projeto projeto) {
        this.projetos.add(projeto) ;
    }
}
