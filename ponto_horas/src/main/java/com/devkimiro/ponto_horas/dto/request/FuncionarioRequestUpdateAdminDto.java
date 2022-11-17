package com.devkimiro.ponto_horas.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FuncionarioRequestUpdateAdminDto {

    @NotBlank(message = "O nome não pode ser enviado em branco!")
    @NotNull(message = "O nome não pode ser vazio!")
    private String nome;

    @NotBlank(message = "O e-mail não pode ser enviado em branco!")
    @NotNull(message = "O e-mail não pode ser vazio!")
    private String email;

    @NotBlank(message = "O nome do cargo não pode ser enviado em branco!")
    @NotNull(message = "O nome do cargo não pode vazio!")
    private String nomeCargo;

    @NotBlank(message = "O nome do setor não pode enviado em branco!")
    @NotNull(message = "O nome do setor não pode ser vazio!")
    private String nomeSetor;

    @NotBlank(message = "A senha não pode ser enviado em branco!")
    @NotNull(message = "A senha não pode ser enviada sozinha!")
    private String senha;
    
}
