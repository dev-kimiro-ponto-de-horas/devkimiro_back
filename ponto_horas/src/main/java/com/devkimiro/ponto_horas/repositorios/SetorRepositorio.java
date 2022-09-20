package com.devkimiro.ponto_horas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devkimiro.ponto_horas.entidades.Setor;

@Repository
public interface SetorRepositorio extends JpaRepository<Setor, Long> {
    
}
