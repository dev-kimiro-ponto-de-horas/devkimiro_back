package com.devkimiro.ponto_horas.mapeamento;

import com.devkimiro.ponto_horas.dto.response.FuncionarioResponseDto;
import com.devkimiro.ponto_horas.entidades.Funcionario;

public class MapeamentoFuncionario {

    public static  FuncionarioResponseDto deFuncionarioParaResponse (Funcionario funcionario){
        return new FuncionarioResponseDto(funcionario.getNome(), funcionario.getEmail(), funcionario.getCargo().getNomeCargo());
    }
}
