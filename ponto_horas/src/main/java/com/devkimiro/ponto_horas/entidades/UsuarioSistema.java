package com.devkimiro.ponto_horas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSistema extends BaseUser {

    @Column(unique = true)
    @NotBlank(message = "O login do usuário não pode ser enviado em branco!")
    @NotNull(message = "O login do usuário não pode ficar vazio!")
    private String login;

    @NotBlank(message = "A senha do usuário não pode ser enviada em branco!")
    @NotNull(message = "A senha do usuário não pode ficar vazia!")
    private String senha;

    @Value("ADMIN")
    private String role;    

}
