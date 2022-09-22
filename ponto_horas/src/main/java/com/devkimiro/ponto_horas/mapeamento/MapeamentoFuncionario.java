package com.devkimiro.ponto_horas.mapeamento;

import com.devkimiro.ponto_horas.dto.response.FuncionarioResponseDto;
import com.devkimiro.ponto_horas.entidades.Funcionario;

public class MapeamentoFuncionario {
    
    //de requestDTO para Funcionario

    // de funcionario para responseDTO

    public static FuncionarioResponseDto DeFuncionarioParaResponse (Funcionario funcionario){
        return new FuncionarioResponseDto(funcionario.getNome(), funcionario.getEmail(), funcionario.getCargo().getNomeCargo());
    }

}
