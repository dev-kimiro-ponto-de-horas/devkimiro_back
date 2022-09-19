package com.devkimiro.ponto_horas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.repositorios.BaseUserRepositorio;

@Service
public class BaseUserServico {
    
    @Autowired
    private BaseUserRepositorio baseUserRepositorio;
}
