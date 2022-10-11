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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome do setor não pode ser enviado em branco!")
    @NotNull(message = "O nome do setor não pode ser vazio!")
    @Column(unique = true, name = "nome_setor")
    private String nomeSetor;

    @NotBlank(message = "O nome do responsável do setor não poder ser enviado em branco!")
    @NotNull(message = "O nome do responsável do setor não ser vazio!")
    private String responsavel;
}
