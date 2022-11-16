package com.cursoBackend.fiado.security;


import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cursoBackend.fiado.domain.UsuarioSistema;

public class DetalhesUsuario implements UserDetails {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 4996708688894501428L;
	private final Optional<UsuarioSistema> usuarioSistema;
	
	public DetalhesUsuario(Optional<UsuarioSistema> usuarioSistema) {
		super();
		this.usuarioSistema = usuarioSistema;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList();
	}

	@Override
	public String getPassword() {
		return usuarioSistema.orElse(new UsuarioSistema()).getHashPassword();
	}

	@Override
	public String getUsername() {
		return usuarioSistema.orElse(new UsuarioSistema()).getTelefone();
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
