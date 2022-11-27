package com.devkimiro.ponto_horas.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devkimiro.ponto_horas.entidades.Cargo;

@Repository
public interface CargoRepositorio extends JpaRepository<Cargo, Long> {
    
    @Query(value = "SELECT u FROM Cargo u WHERE nomeCargo = :nomeCargo")
    Optional<Cargo> findByNomeCargo(String nomeCargo);

}
