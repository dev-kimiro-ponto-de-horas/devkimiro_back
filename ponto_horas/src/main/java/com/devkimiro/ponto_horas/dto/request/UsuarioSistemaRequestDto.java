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
public class UsuarioSistemaRequestDto {
    
    @NotBlank(message = "O nome do usuário não pode ser enviado em branco!")
    @NotNull(message = "O nome do usuário não pode ser nula!")
    private String nome;

    @NotBlank(message = "O e-mail do usuário não pode ser enviado em branco!")
    @NotNull(message = "O e-mail do usuário não pode ser nulo!")
    private String email;

    @NotBlank(message = "O login do usuário não pode ser enviado em branco!")
    @NotNull(message = "O login do usuário não pode ser enviado em branco!")
    private String login;

    @NotBlank(message = "A senha do usuário não pode ser enviado em branco!")
    @NotNull(message = "A senha do usuário não pode ser nula!")
    private String senha;

}
