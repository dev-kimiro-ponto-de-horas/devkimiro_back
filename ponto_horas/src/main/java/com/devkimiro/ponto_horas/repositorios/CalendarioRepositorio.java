package com.devkimiro.ponto_horas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devkimiro.ponto_horas.entidades.Calendario;

@Repository
public interface CalendarioRepositorio extends JpaRepository<Calendario, Long> {

    @Query("SELECT u FROM Calendario u WHERE cracha = :cracha")
    List<Calendario> findByCracha(String cracha);
}
