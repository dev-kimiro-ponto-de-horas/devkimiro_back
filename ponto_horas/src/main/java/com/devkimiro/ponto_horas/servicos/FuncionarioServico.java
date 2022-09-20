package com.devkimiro.ponto_horas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.entidades.Funcionario;
import com.devkimiro.ponto_horas.repositorios.FuncionarioRepositorio;

@Service
public class FuncionarioServico {
    
    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    public List<Funcionario> listarTodosFuncionarios (){
        return funcionarioRepositorio.findAll();
    }

    public Funcionario criarFuncionario (Funcionario funcionario){
        return funcionarioRepositorio.save(funcionario);
    }

    public Funcionario buscarFuncionarioPorId (Long id){
        Optional<Funcionario> usuario = funcionarioRepositorio.findById(id);
        return usuario.get();
    }

    public Funcionario buscarFuncionarioPorCracha (String cracha){
        Optional<Funcionario> funcionarioEncontrado = funcionarioRepositorio.findByCracha(cracha);
        return funcionarioEncontrado.get();
    }

    public Funcionario atualizarFuncionario (Funcionario funcionario, Long id){
        Funcionario funcionarioAntigo = buscarFuncionarioPorId(id);
        funcionario.setId(funcionarioAntigo.getId());
        return funcionarioRepositorio.save(funcionario);
    }

    public void deletarFuncionario (Long id){
        funcionarioRepositorio.deleteById(id);
    }
}
