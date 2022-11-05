package com.cursoBackend.fiado.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.Dependente;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.dto.ClienteDto;
import com.cursoBackend.fiado.dto.DependenteDto;
import com.cursoBackend.fiado.dto.EstabelecimentoDto;
import com.cursoBackend.fiado.services.ClienteServices;
import com.cursoBackend.fiado.services.DependenteServices;
import com.cursoBackend.fiado.services.EstabelecimentoServices;



@RestController
public class DependenteController {
	
	@Autowired
	private DependenteServices services;
	

	@Autowired
	private ClienteServices clienteServices;
	
	@PostMapping(path = "api/dependentes/create/{idCliente}")
	public ResponseEntity<Object> create(
						@PathVariable UUID idCliente,
						@RequestBody DependenteDto dto) {
		
		Optional<Cliente> optionalCliente = clienteServices.findById(idCliente);
		
		if(!optionalCliente.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não existe!");
		}
//		return ResponseEntity.status(HttpStatus.OK).body());
		return ResponseEntity.status(HttpStatus.OK).body(services.create(optionalCliente.get(), dto));
	}
	
	
	

}
