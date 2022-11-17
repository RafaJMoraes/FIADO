package com.cursoBackend.fiado.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.dto.EstabelecimentoDto;
import com.cursoBackend.fiado.services.EstabelecimentoServices;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;



@RestController
@RequestMapping(value = "api/estabelecimentos")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoServices services;
	
	@PostMapping(path = "/criar")
	public ResponseEntity<Estabelecimento> criarEstabelecimento(
						@RequestBody EstabelecimentoDto estabelecimentoDto) {
		
		return ResponseEntity.status(HttpStatus.OK).body(services.save(estabelecimentoDto));
	}
	
	@GetMapping()
	public ResponseEntity<List<Estabelecimento>> estabelecimentos() {
		List<Estabelecimento> list = services.findAll();
		
		if(!list.isEmpty()) {
			for(Estabelecimento et : list) {
				et.add(linkTo(methodOn(EstabelecimentoController.class).estabelecimentoPorId(et.getId())).withSelfRel());
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(services.findAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Estabelecimento> estabelecimentoPorId(@PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(services.findById(id).get());
	}
	

}
