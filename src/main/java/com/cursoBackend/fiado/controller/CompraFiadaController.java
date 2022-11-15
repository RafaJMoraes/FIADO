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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.CompraFiada;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.domain.EstabelecimentoCliente;
import com.cursoBackend.fiado.dto.CompraFiadaDto;
import com.cursoBackend.fiado.services.ClienteServices;
import com.cursoBackend.fiado.services.CompraFiadaServices;
import com.cursoBackend.fiado.services.EstabelecimentoClienteServices;
import com.cursoBackend.fiado.services.EstabelecimentoServices;



@RestController
@RequestMapping(path = "api/compras")
public class CompraFiadaController {
	
	@Autowired
	private CompraFiadaServices services;
	
	@Autowired
	private EstabelecimentoServices estabelecimentoServices;

	@Autowired
	private ClienteServices clienteServices;
	
	@Autowired
	private EstabelecimentoClienteServices estabelecimentoClienteServices;

	
	@PostMapping(path = "/create")
	public ResponseEntity<Object> create(
						@RequestBody CompraFiadaDto dto) {
		Optional<Cliente> optionalCliente = clienteServices.findById(dto.getIdCliente());
		Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoServices.findById(dto.getIdEstabelecimento());

		if (!optionalCliente.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não existe na base de dados!");
		}
		if (!optionalEstabelecimento.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estabelecimento não existe na base de dados!");
		}
		
		EstabelecimentoCliente ec = new EstabelecimentoCliente();
		ec.setCliente(optionalCliente.get());
		ec.setEstabelecimento(optionalEstabelecimento.get());
		
		Optional<EstabelecimentoCliente> OptionalEC = estabelecimentoClienteServices.findOne(ec);
		
		if(!OptionalEC.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não está vinculado a esse estabelecimento!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(services.save(dto,optionalCliente.get(), optionalEstabelecimento.get()));
	}
	
	
	@GetMapping("")
	public ResponseEntity<List<CompraFiada>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(services.findAll());
	}
	
	@PutMapping("/alterarpagameto/{id}")
	public ResponseEntity<Object> alterarPagamento(@PathVariable UUID id){
		Optional<CompraFiada> optionalCompra = services.findOne(id);
		
		if(!optionalCompra.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra nao encontrada!");
		}
		
		CompraFiada compra =  optionalCompra.get();
		compra.setFoiPaga(true);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(services.update(compra));
		
	}
	
	@GetMapping("/verificarpagamentos")
	public ResponseEntity<Object> verificarPagamentos(@RequestParam UUID estabelecimentoId) {
		Optional<Estabelecimento> esOptional = estabelecimentoServices.findById(estabelecimentoId);
		services.verificarComprasNaoPagas(esOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Verificação feita com sucesso!!");
	}
	
	
	

}
