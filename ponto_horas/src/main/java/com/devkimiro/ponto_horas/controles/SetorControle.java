package com.devkimiro.ponto_horas.controles;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devkimiro.ponto_horas.entidades.Setor;
import com.devkimiro.ponto_horas.servicos.SetorServico;

@RestController
@RequestMapping("/setor")
@Api("Controle de Setor")
public class SetorControle {

    @Autowired
    private SetorServico setorServico;

    @GetMapping
    @ApiOperation("Listar todos os Setores")
    @ApiResponse(code = 200, message = "Todos os Setores listados com sucesso!")
    public ResponseEntity<List<Setor>> listarTodosSetores (){
        return ResponseEntity.ok(setorServico.listarTodosSetores());
    }

    @PostMapping
    @ApiOperation("Criar um Setor")
    @ApiResponse(code = 200,message = "Setor criado com Sucesso!")
    public ResponseEntity<Setor> criarSetor(@RequestBody Setor setor){
        return ResponseEntity.ok(setorServico.criarSetor(setor));
    }

    @GetMapping("{id}")
    @ApiOperation("Buscar um Setor por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Setor encontrado com sucesso!") ,
            @ApiResponse(code = 404, message = "Setor não encontrado!")
    })
    public ResponseEntity<Setor> buscarSetorPorid(@PathVariable Long id){
        try{
        return ResponseEntity.ok(setorServico.buscarSetorPorId(id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("nome/{nomeSetor}")
    @ApiOperation("Buscar Setor por Nome")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Setor encontrado com sucesso!") ,
            @ApiResponse(code = 404, message = "Setor não encontrado!")
    })
    public ResponseEntity<Setor> buscarSetorPorNome(@PathVariable String nomeSetor){
        try{
        return ResponseEntity.ok(setorServico.buscarSetorPorNome(nomeSetor));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @ApiOperation("Atualizar Setor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Setor atualizado com sucesso!") ,
            @ApiResponse(code = 404, message = "Setor não encontrado!")
    })
    public ResponseEntity<Setor> atualizarSetor(@RequestBody Setor setor, @PathVariable Long id){
        try{
        return ResponseEntity.ok(setorServico.atualizarSetor(setor, id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation("Deletar Setor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Setor deletado com sucesso!") ,
            @ApiResponse(code = 404, message = "Setor não encontrado!")
    })
    public ResponseEntity<?> deletarSetor (@PathVariable Long id){
        try{
        setorServico.deletarSetor(id);
        return ResponseEntity.ok().build();
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    
}
