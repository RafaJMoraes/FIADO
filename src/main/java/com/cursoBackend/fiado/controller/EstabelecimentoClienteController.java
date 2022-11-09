package com.cursoBackend.fiado.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.services.ClienteServices;
import com.cursoBackend.fiado.services.EstabelecimentoClienteServices;
import com.cursoBackend.fiado.services.EstabelecimentoServices;

@RestController
@RequestMapping(path = "api/estabelecimentocliente/")
public class EstabelecimentoClienteController {

	@Autowired
	private EstabelecimentoClienteServices estabelecimentoClienteServices;

	@Autowired
	private EstabelecimentoServices estabelecimentoServices;

	@Autowired
	private ClienteServices clienteServices;

	@PostMapping(path = "create")
	public ResponseEntity<Object> create(@RequestParam UUID estabelecimentoId, @RequestParam UUID clientId) {
		Optional<Cliente> optionalCliente = clienteServices.findById(clientId);
		Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoServices.findById(estabelecimentoId);

		if (!optionalCliente.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não existe na base de dados!");
		}
		if (!optionalEstabelecimento.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estabelecimento não existe na base de dados!");
		}

		return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoClienteServices.save(optionalCliente.get(), optionalEstabelecimento.get()));
	}

}
