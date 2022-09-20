package com.devkimiro.ponto_horas.entidades;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cargo")
    @NotBlank(message = "O nome do cargo não pode ser enviado em branco!")
    @NotNull(message = "O nome do cargo não pode ser vazio!")
    private String nomeCargo;

    @NotNull(message = "O salário do cargo não pode ser vazio!")
    private double salario;

    @Column(name = "carga_horaria")
    @JsonFormat(pattern = "HH-mm-ss", shape = Shape.STRING)
    private Time cargaHoraria;
    
}
