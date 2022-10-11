package com.devkimiro.ponto_horas.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioRequestUpdateDto {

    @NotBlank(message = "A senha não pode ser enviada em branco!")
    @NotNull(message = "A senha não pode ser vazia!")
    private String senha;

}
