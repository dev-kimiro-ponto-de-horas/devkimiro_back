package com.devkimiro.ponto_horas.controles;

import java.util.List;

import javax.validation.Valid;

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
public class CargoControle {

    @Autowired
    private CargoServico cargoServico;

    @GetMapping
    public ResponseEntity <List<Cargo>> listarTodosCargos(){
        return ResponseEntity.ok(cargoServico.listarTodosCargos());
    }

    @PostMapping
    public ResponseEntity<Cargo> criarCargo (@Valid @RequestBody Cargo cargo){
        return ResponseEntity.ok(cargoServico.criarCargo(cargo));
    }

    @GetMapping("{id}")
    public ResponseEntity <Cargo> buscarCargoPorId (@PathVariable Long id){
        try{
        return ResponseEntity.ok(cargoServico.buscarCargoPorId(id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome/{nomeCargo}")
    public ResponseEntity <Cargo> buscarCargoPorNome (@PathVariable String nomeCargo){
        try{
        return ResponseEntity.ok(cargoServico.buscarCargoPorNome(nomeCargo));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Cargo> atualizarCargo (@Valid @RequestBody Cargo cargo, @PathVariable Long id){
        try{
        return ResponseEntity.ok(cargoServico.atualizarCargo(cargo, id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarCargo (@PathVariable Long id){
        try{
        cargoServico.deletarCargo(id);
        return ResponseEntity.ok().build();
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
