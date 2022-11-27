package com.devkimiro.ponto_horas.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devkimiro.ponto_horas.entidades.Setor;

@Repository
public interface SetorRepositorio extends JpaRepository<Setor, Long> {

    @Query(value = "SELECT u FROM Setor u WHERE nomeSetor = :nomeSetor")
    Optional<Setor> findByNomeSetor(String nomeSetor);
    
}
