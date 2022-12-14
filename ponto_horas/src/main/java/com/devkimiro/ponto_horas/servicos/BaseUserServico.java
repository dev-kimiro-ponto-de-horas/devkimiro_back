package com.devkimiro.ponto_horas.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.entidades.BaseUser;
import com.devkimiro.ponto_horas.repositorios.BaseUserRepositorio;

@Service
public class BaseUserServico {

    @Autowired
    private BaseUserRepositorio baseUserRepositorio;

    public BaseUser buscarUserPorNome(String nome){
        Optional<BaseUser> user = baseUserRepositorio.findByNome(nome);
        if(user.isEmpty()){
            throw new RuntimeException("O usuário não pode ser encontrado pelo nome!");
        }
        return user.get();
    }

    public BaseUser buscarUserPorEmail(String email){
        Optional<BaseUser> user = baseUserRepositorio.findByEmail(email);
        if(user.isEmpty()){
            throw new RuntimeException("O usuário não pode ser encontrado pelo e-mail!");
        }
        return user.get();
    }
}
