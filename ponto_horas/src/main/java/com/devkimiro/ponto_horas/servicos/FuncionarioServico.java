package com.devkimiro.ponto_horas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.entidades.Funcionario;
import com.devkimiro.ponto_horas.repositorios.CargoRepositorio;
import com.devkimiro.ponto_horas.repositorios.FuncionarioRepositorio;
import com.devkimiro.ponto_horas.repositorios.SetorRepositorio;

@Service
public class FuncionarioServico {
    
    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @Autowired
    private SetorRepositorio setorRepositorio;

    @Autowired
    private CargoRepositorio cargoRepositorio;

    public List<Funcionario> listarTodosFuncionarios (){
        return funcionarioRepositorio.findAll();
    }

    public Funcionario criarFuncionario (Funcionario funcionario){
        setorRepositorio.save(funcionario.getSetor());
        cargoRepositorio.save(funcionario.getCargo());
        return funcionarioRepositorio.save(funcionario);
    }

    public Funcionario buscarFuncionarioPorId (Long id){
        Optional<Funcionario> usuario = funcionarioRepositorio.findById(id);
        if(usuario.isEmpty()){
            throw new RuntimeException("O funcionário não pode encontrado pelo Id");
        }
        return usuario.get();
    }

    public Funcionario buscarFuncionarioPorCracha (String cracha){
        Optional<Funcionario> funcionarioEncontrado = funcionarioRepositorio.findByCracha(cracha);
        if(funcionarioEncontrado.isEmpty()){
            throw new RuntimeException("O funcionário não pode ser encontrado pelo cracha");
        }
        return funcionarioEncontrado.get();
    }

    public Funcionario buscarFuncionarioPorEmail (String email) {
        Optional<Funcionario> funcionarioEncontrado = funcionarioRepositorio.findByEmail(email);
        if(funcionarioEncontrado.isEmpty()){
            throw new RuntimeException("O funcionário não pode ser encontrado pelo e-mail");
        }
        return funcionarioEncontrado.get();
    }

    public Funcionario atualizarFuncionario (Funcionario funcionario, Long id){
        Funcionario funcionarioAntigo = buscarFuncionarioPorId(id);
        funcionario.setId(funcionarioAntigo.getId());
        setorRepositorio.save(funcionario.getSetor());
        cargoRepositorio.save(funcionario.getCargo());
        return funcionarioRepositorio.save(funcionario);
    }

    public void deletarFuncionario (Long id){
        funcionarioRepositorio.deleteById(id);
    }
}
