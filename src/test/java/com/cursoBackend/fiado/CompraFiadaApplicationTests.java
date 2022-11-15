package com.cursoBackend.fiado;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.CompraFiada;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.repository.CompraFiadaRepository;
import com.cursoBackend.fiado.repository.EstabelecimentoClienteRepository;
import com.cursoBackend.fiado.services.SMSServices;

@SpringBootTest
class CompraFiadaApplicationTests {
	
	
	@Autowired
	private EstabelecimentoClienteRepository estabelecimentoClienteRepository;
	
	@Autowired
	private CompraFiadaRepository compraFiadaRepository;

	@Autowired
	private SMSServices smsServices;
	
	@Test
	void contextLoads() {
//		verificarComprasNaoPagas();
	}
	
	boolean devedor = false;
	
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
