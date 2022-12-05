package org.soulcodeacademy.empresa.domain.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DependenteDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;


    @NotNull(message = "id empregado obrigatorio")
    private Integer idade;


    @NotNull(message = "id empregado obrigatorio")
    private Integer responsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Integer responsavel) {
        this.responsavel = responsavel;
    }
}
