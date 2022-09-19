package com.devkimiro.ponto_horas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser enviado em branco!")
    @NotNull(message = "O nome não pode ser nulo!")
    private String nome;

    @Column(unique = true)
    @NotBlank(message = "O e-mail não pode ser enviado em branco!")
    @NotNull(message = "O e-mail não pode estar vazio!")
    private String email;

}
