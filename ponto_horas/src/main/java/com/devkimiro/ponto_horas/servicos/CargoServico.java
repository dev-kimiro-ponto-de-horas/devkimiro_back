package com.devkimiro.ponto_horas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkimiro.ponto_horas.entidades.Cargo;
import com.devkimiro.ponto_horas.repositorios.CargoRepositorio;

@Service
public class CargoServico {
    
    @Autowired
    private CargoRepositorio cargoRepositorio;

    public List<Cargo> listarTodosCargos(){
        return cargoRepositorio.findAll();
    }

    public Cargo criarCargo(Cargo cargo){
        return cargoRepositorio.save(cargo);
    }

    public Cargo buscarCargoPorId(Long id){
        Optional<Cargo> cargo = cargoRepositorio.findById(id);
        return cargo.get();
    }

    public Cargo atualizarCargo(Cargo cargo, Long id){
        Cargo cargoAntigo = buscarCargoPorId(id);
        cargo.setId(cargoAntigo.getId());
        return cargoRepositorio.save(cargo);
    }

    public void deletarCargo(Long id){
        cargoRepositorio.deleteById(id);
    }
}
