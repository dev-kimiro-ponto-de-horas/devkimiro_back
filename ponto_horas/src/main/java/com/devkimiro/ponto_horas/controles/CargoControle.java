package com.devkimiro.ponto_horas.controles;

import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.*;
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

import com.devkimiro.ponto_horas.entidades.Cargo;
import com.devkimiro.ponto_horas.servicos.CargoServico;

@RestController
@RequestMapping("/cargo")
@Api("Controle de Cargo")
public class CargoControle {

    @Autowired
    private CargoServico cargoServico;

    @GetMapping
    @ApiOperation("Listar todos os Cargos")
    @ApiResponse(code = 200, message = "Todos os cargos listados com sucesso!")
    public ResponseEntity <List<Cargo>> listarTodosCargos(){
        return ResponseEntity.ok(cargoServico.listarTodosCargos());
    }

    @PostMapping
    @ApiOperation("Criar um Cargo")
    @ApiResponse(code = 200,message = "Cargo Criado com Sucesso!")
    public ResponseEntity<Cargo> criarCargo (@Valid @RequestBody Cargo cargo){
        return ResponseEntity.ok(cargoServico.criarCargo(cargo));
    }

    @GetMapping("{id}")
    @ApiOperation("Buscar um Cargo por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cargo encontrado com sucesso!") ,
            @ApiResponse(code = 404, message = "Cargo não encontrado!")
    })
    public ResponseEntity <Cargo> buscarCargoPorId (@PathVariable Long id){
        try{
        return ResponseEntity.ok(cargoServico.buscarCargoPorId(id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome/{nomeCargo}")
    @ApiOperation("Buscar Cargo por Nome")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cargo encontrado com sucesso!") ,
            @ApiResponse(code = 404, message = "Cargo não encontrado!")
    })
    public ResponseEntity <Cargo> buscarCargoPorNome (@PathVariable String nomeCargo){
        try{
        return ResponseEntity.ok(cargoServico.buscarCargoPorNome(nomeCargo));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @ApiOperation("Atualizar Cargo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cargo atualizado com sucesso!") ,
            @ApiResponse(code = 404, message = "Cargo não encontrado!")
    })
    public ResponseEntity<Cargo> atualizarCargo (@Valid @RequestBody Cargo cargo, @PathVariable Long id){
        try{
        return ResponseEntity.ok(cargoServico.atualizarCargo(cargo, id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation("Deletar Cargo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cargo deletado com sucesso!") ,
            @ApiResponse(code = 404, message = "Cargo não encontrado!")
    })
    public ResponseEntity<?> deletarCargo (@PathVariable Long id){
        try{
        cargoServico.deletarCargo(id);
        return ResponseEntity.ok().build();
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
