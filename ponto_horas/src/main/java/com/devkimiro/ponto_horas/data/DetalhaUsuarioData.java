package com.devkimiro.ponto_horas.data;

import com.devkimiro.ponto_horas.entidades.UsuarioSistema;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalhaUsuarioData implements UserDetails {

    private final Optional<UsuarioSistema> usuarioSistema;

    public DetalhaUsuarioData(Optional<UsuarioSistema> usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usuarioSistema.orElse(new UsuarioSistema()).getSenha();
    }

    @Override
    public String getUsername() {
        return usuarioSistema.orElse(new UsuarioSistema()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
