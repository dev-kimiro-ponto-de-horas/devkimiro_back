package com.devkimiro.ponto_horas.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devkimiro.ponto_horas.entidades.Funcionario;
import com.devkimiro.ponto_horas.servicos.FuncionarioServico;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioControle {
    
    @Autowired
    private FuncionarioServico funcionarioServico;

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodosFuncionarios (){
        return ResponseEntity.ok(funcionarioServico.listarTodosFuncionarios());
    }

    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario (@Valid @RequestBody Funcionario funcionario){
        return ResponseEntity.ok(funcionarioServico.criarFuncionario(funcionario));
    }

    @GetMapping("{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId (@PathVariable Long id){
        try{
        return ResponseEntity.ok(funcionarioServico.buscarFuncionarioPorId(id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cracha/{cracha}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorCracha (@PathVariable String cracha){
        try{
        return ResponseEntity.ok(funcionarioServico.buscarFuncionarioPorCracha(cracha));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorEmail (@PathVariable String email){
        try{
        return ResponseEntity.ok(funcionarioServico.buscarFuncionarioPorEmail(email));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario (@Valid @RequestBody Funcionario funcionario, @PathVariable Long id){
        return ResponseEntity.ok(funcionarioServico.atualizarFuncionario(funcionario, id));
    }

    public ResponseEntity<?> deletarFuncionario (@PathVariable Long id){
        try{
        funcionarioServico.deletarFuncionario(id);
        return ResponseEntity.ok().build();
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
