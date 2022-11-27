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
        Optional<Cargo> cargoEncontrado = cargoRepositorio.findByNomeCargo(cargo.getNomeCargo());
        if(cargoEncontrado.isPresent()){
            throw new RuntimeException("O nome do cargo já");
        }
        return cargoRepositorio.save(cargo);
    }
    
    public Cargo buscarCargoPorId(Long id){
        Optional<Cargo> cargo = cargoRepositorio.findById(id);
        if(cargo.isEmpty()){
            throw new RuntimeException("O cargo não pode ser encontrado pelo Id!");
        }
        return cargo.get();
    }

    public Cargo buscarCargoPorNome (String nomeCargo){
        Optional<Cargo> cargoEncontrado = cargoRepositorio.findByNomeCargo(nomeCargo);
        if(cargoEncontrado.isEmpty()){
            throw new RuntimeException("O cargo não pode ser encontrado pelo nome!");
        }
        return cargoEncontrado.get();
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
