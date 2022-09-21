package com.devkimiro.ponto_horas.controles;

import java.util.List;

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
public class SetorControle {

    @Autowired
    private SetorServico setorServico;

    @GetMapping
    public ResponseEntity<List<Setor>> listarTodosSetores (){
        return ResponseEntity.ok(setorServico.listarTodosSetores());
    }

    @PostMapping
    public ResponseEntity<Setor> criarSetor(@RequestBody Setor setor){
        return ResponseEntity.ok(setorServico.criarSetor(setor));
    }

    @GetMapping("{id}")
    public ResponseEntity<Setor> buscarSetorPorid(@PathVariable Long id){
        return ResponseEntity.ok(setorServico.buscarSetorPorId(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Setor> atualizarSetor(@RequestBody Setor setor, @PathVariable Long id){
        return ResponseEntity.ok(setorServico.atualizarSetor(setor, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarSetor (@PathVariable Long id){
        setorServico.deletarSetor(id);
        return ResponseEntity.ok().build();
    }
    
}
