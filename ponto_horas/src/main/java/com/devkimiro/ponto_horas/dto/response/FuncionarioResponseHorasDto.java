package com.devkimiro.ponto_horas.dto.response;

import java.util.List;

import com.devkimiro.ponto_horas.entidades.Calendario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioResponseHorasDto {
    
    private String nome;
    private String cracha;
    private List<Calendario> calendario;

}
