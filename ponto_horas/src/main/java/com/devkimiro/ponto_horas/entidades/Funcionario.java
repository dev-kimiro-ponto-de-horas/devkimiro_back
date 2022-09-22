package com.devkimiro.ponto_horas.entidades;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends BaseUser {

    //id
    //nome
    //email
    
    @ManyToOne
    private Cargo cargo;

    @ManyToOne
    private Setor setor;

    @Column(unique = true)
    @NotBlank(message = "O crachá do funcionário não ser enviado em branco!")
    @NotNull(message = "O crachá do funcionário não pode ser vazio!")
    private String cracha;

    @NotBlank(message = "A senha do funcionário não pode ser enviado em branco!")
    @NotNull(message = "A senha do funcionário não pode ser vazia!")
    private String senha;

    @Column(name = "hora_entrada")
    @JsonFormat(pattern = "HH-mm-ss", shape = Shape.STRING)
    private Time horaEntrada;

    @Column(name = "hora_saida")
    @JsonFormat(pattern = "HH-mm-ss", shape = Shape.STRING)
    private Time horaSaida;
    
}
