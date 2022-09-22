package com.devkimiro.ponto_horas.mapeamento;

import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.dto.response.FuncionarioResponseDto;
import com.devkimiro.ponto_horas.entidades.Funcionario;

@Service
public class MapeamentoFuncionario {

    public static  FuncionarioResponseDto deFuncionarioParaResponse (Funcionario funcionario){
        return new FuncionarioResponseDto(funcionario.getNome(), funcionario.getEmail(), funcionario.getCargo().getNomeCargo());
    }
}
