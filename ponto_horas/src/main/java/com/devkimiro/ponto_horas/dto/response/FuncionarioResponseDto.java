package com.devkimiro.ponto_horas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioResponseDto {
    
    private Long id;
    private String nome;
    private String email;
    private String nomeCargo;
    private String nomeSetor;
    private String cracha;

}
