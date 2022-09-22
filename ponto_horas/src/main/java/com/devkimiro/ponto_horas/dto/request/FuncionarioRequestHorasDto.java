package com.devkimiro.ponto_horas.dto.request;

import java.sql.Time;

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
public class FuncionarioRequestHorasDto {
    
    @JsonFormat(pattern = "HH-mm-ss", shape = Shape.STRING)
    private Time horaEntrada;

    @JsonFormat(pattern = "HH-mm-ss", shape = Shape.STRING)
    private Time horaSaida;
}
