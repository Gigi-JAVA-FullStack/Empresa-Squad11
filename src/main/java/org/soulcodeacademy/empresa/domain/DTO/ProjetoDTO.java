package org.soulcodeacademy.empresa.domain.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProjetoDTO {

    @NotBlank(message = "Campo nome é obrigatorio.")
    private String nome;

    @NotNull(message = "Campo orcamento é obrigatorio.")
    private Double orcamento;

    @NotBlank(message = "Campo descricao é obrigatorio.")
    private String descricao;

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
}
