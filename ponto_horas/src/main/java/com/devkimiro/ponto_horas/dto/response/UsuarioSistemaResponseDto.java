package com.devkimiro.ponto_horas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSistemaResponseDto {
    
    private Long id;
    private String nome;
    private String email;
    private String login;

}
