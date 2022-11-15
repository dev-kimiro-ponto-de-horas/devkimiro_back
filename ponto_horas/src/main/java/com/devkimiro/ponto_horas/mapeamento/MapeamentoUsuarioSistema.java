package com.devkimiro.ponto_horas.mapeamento;

import com.devkimiro.ponto_horas.dto.response.UsuarioSistemaResponseDto;
import com.devkimiro.ponto_horas.entidades.UsuarioSistema;

public class MapeamentoUsuarioSistema {
    
    public static UsuarioSistemaResponseDto deUsuarioParaResponse (UsuarioSistema usuario){
        return new UsuarioSistemaResponseDto(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getLogin());
    }

}
