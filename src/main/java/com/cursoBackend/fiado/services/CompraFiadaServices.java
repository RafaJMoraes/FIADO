package com.cursoBackend.fiado.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.CompraFiada;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.dto.CompraFiadaDto;
import com.cursoBackend.fiado.repository.ClienteRepository;
import com.cursoBackend.fiado.repository.CompraFiadaRepository;
import com.cursoBackend.fiado.repository.EstabelecimentoClienteRepository;

@Service
public class CompraFiadaServices {

	@Autowired
	private CompraFiadaRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EstabelecimentoClienteRepository estabelecimentoClienteRepository;

	private boolean devedor;
	
	@Autowired
	private CompraFiadaRepository compraFiadaRepository;
	
	@Autowired
	private SMSServices smsServices;

	public CompraFiada save(CompraFiadaDto dto, Cliente cliente, Estabelecimento estabelecimento) {
	     CompraFiada compra = new CompraFiada(dto);
		 compra.setCliente(cliente);
		 compra.setEstabelecimento(estabelecimento);
		 return repository.save(compra);
	}

	public List<CompraFiada> findAll() {
		return repository.findAll();
	}

	public Optional<CompraFiada> findOne(UUID id) {	
		return repository.findById(id);
	}

	public CompraFiada update(CompraFiada compra) {
	  return repository.save(compra);
	}
	
	
	public void verificarComprasNaoPagas(Estabelecimento estabelecimento) {
		List<Cliente> clientes = new ArrayList<>();
		clientes = estabelecimentoClienteRepository.findClienteByEstabelecimento(estabelecimento);
		System.out.println("verificar pagamento!!!!!!!!!!!!!!!!!!");
		
		
		//VERIFICAR OS CLIENTES E SUAS COMPRASFIADAS
		clientes.stream().forEach(c-> {
			List<CompraFiada> compras = compraFiadaRepository.findByCliente(c);			
			//VERIFICA SE O CLIENTE TEM CONTA N PAGA
			compras.stream().forEach(compra -> {
				int count = 0;
				if(!compra.isFoiPaga()) {
					count = count+1;
				}
				if(count> 0) {
					devedor = true;
				}
			});
			// ENVIA UM SMS PARA O CLIENTE DEVEDOR
			if(devedor) {
				smsServices.sendSms();
			}
		});
		
		

	}

}
