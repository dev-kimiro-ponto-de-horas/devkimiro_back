package com.devkimiro.ponto_horas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.dto.request.FuncionarioRequestDto;
import com.devkimiro.ponto_horas.dto.request.FuncionarioRequestUpdateDto;
import com.devkimiro.ponto_horas.entidades.Cargo;
import com.devkimiro.ponto_horas.entidades.Funcionario;
import com.devkimiro.ponto_horas.entidades.Setor;
import com.devkimiro.ponto_horas.repositorios.FuncionarioRepositorio;

@Service
public class FuncionarioServico {
    
    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @Autowired
    private SetorServico setorServico;

    @Autowired
    private CargoServico cargoServico;

    public List<Funcionario> listarTodosFuncionarios (){
        return funcionarioRepositorio.findAll();
    }

    public Funcionario criarFuncionario (FuncionarioRequestDto funcionarioDto){
        Optional<Funcionario> funcionarioCracha = funcionarioRepositorio.findByCracha(funcionarioDto.getCracha());
        if(funcionarioCracha.isPresent()){
            throw new RuntimeException("Já existe um cracha cadastrado como: " + funcionarioDto.getCracha());
        }
        Setor setor = setorServico.buscarSetorPorNome(funcionarioDto.getNomeSetor());
        Cargo cargo = cargoServico.buscarCargoPorNome(funcionarioDto.getNomeCargo());
        Funcionario funcionario = new Funcionario(null, funcionarioDto.getNome(), funcionarioDto.getEmail(), cargo, setor, funcionarioDto.getCracha(), funcionarioDto.getSenha());
        return funcionarioRepositorio.save(funcionario);
    }

    public Funcionario buscarFuncionarioPorId (Long id){
        Optional<Funcionario> usuario = funcionarioRepositorio.findById(id);
        if(usuario.isEmpty()){
            throw new RuntimeException("O funcionário não pode encontrado! :(");
        }
        return usuario.get();
    }

    public Funcionario buscarFuncionarioPorCracha (String cracha){
        Optional<Funcionario> funcionarioEncontrado = funcionarioRepositorio.findByCracha(cracha);
        if(funcionarioEncontrado.isEmpty()){
            throw new RuntimeException("O funcionário não pode ser encontrado! :(");
        }
        return funcionarioEncontrado.get();
    }

    public Funcionario buscarFuncionarioPorEmail (String email) {
        Optional<Funcionario> funcionarioEncontrado = funcionarioRepositorio.findByEmail(email);
        if(funcionarioEncontrado.isEmpty()){
            throw new RuntimeException("O funcionário não pode ser encontrado! :(");
        }
        return funcionarioEncontrado.get();
    }

    public Funcionario atualizarFuncionario (FuncionarioRequestUpdateDto funcionarioDto, String cracha){
        Funcionario funcionario = buscarFuncionarioPorCracha(cracha);
        funcionario.setSenha(funcionarioDto.getSenha());
        return funcionarioRepositorio.save(funcionario);
    }

    public Funcionario atualizarFuncionarioAdmin (FuncionarioRequestDto funcionarioDto, String cracha){
        Funcionario funcionario = buscarFuncionarioPorCracha(cracha);
        Setor setor = setorServico.buscarSetorPorNome(funcionarioDto.getNomeSetor());
        Cargo cargo = cargoServico.buscarCargoPorNome(funcionarioDto.getNomeCargo());
        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setEmail(funcionarioDto.getEmail());
        funcionario.setCargo(cargo);
        funcionario.setSetor(setor);
        funcionario.setSenha(funcionarioDto.getSenha());
        return funcionarioRepositorio.save(funcionario);
        
    }

    public void deletarFuncionario (Long id){
        funcionarioRepositorio.deleteById(id);
    }
}
