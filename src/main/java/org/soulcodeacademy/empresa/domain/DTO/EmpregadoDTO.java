package org.soulcodeacademy.empresa.domain.DTO;



import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class EmpregadoDTO {
    @NotNull(message = "Nome é obrigatório")
    private String Nome;

    @NotNull(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @NotNull(message = "Campo Salario é obrigatório")
    @Min(value = 500,message = "Campo salário inválido")
    @Max(value = 1000000, message = "Campo salário inválido")
    private Double salario;


    private Integer endereco;



    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
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

    public Integer getEndereco() {
        return endereco;
    }

    public void setEndereco(Integer endereco) {
        this.endereco = endereco;
    }


}
