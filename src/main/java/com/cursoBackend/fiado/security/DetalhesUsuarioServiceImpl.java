package com.cursoBackend.fiado.security;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cursoBackend.fiado.domain.UsuarioSistema;
import com.cursoBackend.fiado.repository.EstabelecimentoRepository;
import com.cursoBackend.fiado.services.EstabelecimentoServices;


@Component
public class DetalhesUsuarioServiceImpl implements UserDetailsService {
	
	@Autowired
	private final EstabelecimentoServices estabelecimentoServices;
	
	DetalhesUsuarioServiceImpl(EstabelecimentoServices estabelecimentoServices){
		this.estabelecimentoServices = estabelecimentoServices;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioSistema> usOptional = estabelecimentoServices.findByLogin(username);
		if(usOptional.isEmpty()) {
			throw new UsernameNotFoundException("Usuário ["+username+"] não existe");
		}
		return new DetalhesUsuario(usOptional);
	}


}
