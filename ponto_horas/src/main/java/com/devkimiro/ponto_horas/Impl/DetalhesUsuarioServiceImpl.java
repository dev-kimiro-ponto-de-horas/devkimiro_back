package com.devkimiro.ponto_horas.Impl;

import com.devkimiro.ponto_horas.entidades.UsuarioSistema;
import com.devkimiro.ponto_horas.repositorios.UsuarioSistemaRepositorio;
import com.devkimiro.ponto_horas.data.DetalhaUsuarioData;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalhesUsuarioServiceImpl implements UserDetailsService {

    private final UsuarioSistemaRepositorio usuarioSistemaRepositorio;

    public DetalhesUsuarioServiceImpl(UsuarioSistemaRepositorio usuarioSistemaRepositorio) {
        this.usuarioSistemaRepositorio = usuarioSistemaRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioSistema> usuario = usuarioSistemaRepositorio.findByLogin(username);
        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado!");
        }

        return new DetalhaUsuarioData(usuario);

    }
}
