package com.cursoBackend.fiado.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.domain.EstabelecimentoCliente;
import com.cursoBackend.fiado.repository.EstabelecimentoClienteRepository;

@Service
public class EstabelecimentoClienteServices {

	@Autowired
	private EstabelecimentoClienteRepository estabelecimentoClienteRepository;

	public EstabelecimentoCliente save(Cliente cliente, Estabelecimento estabelecimento) {
		EstabelecimentoCliente ec = new EstabelecimentoCliente();
		ec.setCliente(cliente);
		ec.setEstabelecimento(estabelecimento);
		return estabelecimentoClienteRepository.save(ec);
	}

	public List<Cliente> findByEstabelecimento(Estabelecimento estabelecimento) {
		List<EstabelecimentoCliente> list = estabelecimentoClienteRepository.findByEstabelecimento(estabelecimento);
		ArrayList<Cliente> clientes = new ArrayList<>();

		list.stream().forEach(x -> {
			clientes.add(x.getCliente());
		});

		return clientes;
	}

	public Optional<EstabelecimentoCliente> findOne(EstabelecimentoCliente ec) {
		return estabelecimentoClienteRepository.findByEstabelecimentoAndCliente(
				ec.getEstabelecimento(),ec.getCliente());
	}

	public void delete(EstabelecimentoCliente ec) {
		estabelecimentoClienteRepository.delete(ec);
	}

	public List<EstabelecimentoCliente> findAll() {
		return estabelecimentoClienteRepository.findAll();
	}

}
