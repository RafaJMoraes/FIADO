package com.cursoBackend.fiado.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.Dependente;
import com.cursoBackend.fiado.dto.DependenteDto;
import com.cursoBackend.fiado.repository.DependenteRepository;

@Service
public class DependenteServices {
	
	
	
	@Autowired
	private DependenteRepository dependenteRepository;

	public Dependente create(Cliente cliente, DependenteDto dto) {
	    Dependente dependente = new Dependente();
	    dependente.setCliente(cliente);	    
	    BeanUtils.copyProperties(dto, dependente);
	    
		return dependenteRepository.save(dependente);
	}
	
	
	
	

}
