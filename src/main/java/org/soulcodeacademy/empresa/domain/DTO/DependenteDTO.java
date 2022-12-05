package org.soulcodeacademy.empresa.domain.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DependenteDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;


    @NotEmpty(message = "id empregado obrigatorio")
    private Integer idade;


    @NotEmpty(message = "id empregado obrigatorio")
    private Integer idEmpregado;

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

    public Integer getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(Integer idEmpregado) {
        this.idEmpregado = idEmpregado;
    }
}
