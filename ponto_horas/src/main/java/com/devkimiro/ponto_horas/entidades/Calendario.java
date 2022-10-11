package com.devkimiro.ponto_horas.entidades;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "hora_entrada")
    @JsonFormat(pattern = "dd-MM-yyyy HH-mm-ss", shape = Shape.STRING)
    private LocalDateTime horaEntrada;

    @Column(name = "hora_saida")
    @JsonFormat(pattern = "dd-MM-yyyy HH-mm-ss", shape = Shape.STRING)
    private LocalDateTime horaSaida;
}
