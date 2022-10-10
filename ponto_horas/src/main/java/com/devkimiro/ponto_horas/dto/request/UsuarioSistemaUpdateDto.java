package com.devkimiro.ponto_horas.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSistemaUpdateDto {
    
    @NotBlank(message = "A senha do usuário não pode ser nula!")
    @NotNull(message = "A senha do usuário não pode ser vazia!")
    private String senha;

}
