package org.soulcodeacademy.empresa.domain.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmpregadoDTO {
    @NotNull(message = "Nome é obrigatório")
    private String Nome;

    @NotNull(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @NotNull(message = "Campo Salario é obrigatório")
    @Min(value = 500,message = "Salario Abaixo de 500 ")
    private Double salario;
}
