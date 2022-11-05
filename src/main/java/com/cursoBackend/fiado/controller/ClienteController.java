package com.cursoBackend.fiado.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.dto.ClienteDto;
import com.cursoBackend.fiado.dto.EstabelecimentoDto;
import com.cursoBackend.fiado.services.ClienteServices;
import com.cursoBackend.fiado.services.EstabelecimentoServices;



@RestController
public class ClienteController {
	
	@Autowired
	private ClienteServices services;
	
	@PostMapping(path = "api/cliente/create")
	public ResponseEntity<Cliente> create(
						@RequestBody ClienteDto dto) {
		
		return ResponseEntity.status(HttpStatus.OK).body(services.save(dto));
	}
	
	@GetMapping(path = "api/clientes")
	public ResponseEntity<List<Cliente>> estabelecimentos() {
		return ResponseEntity.status(HttpStatus.OK).body(services.findAll());
	}
	

}
