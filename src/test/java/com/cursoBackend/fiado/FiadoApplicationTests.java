package com.cursoBackend.fiado;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.repository.EstabelecimentoRepository;

@SpringBootTest
class FiadoApplicationTests {
	
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	

	@Test
	void contextLoads() {
		//criacaoEstabelecimento();
	}
	
	public void criacaoEstabelecimento() {
		Estabelecimento estabelecimento = new Estabelecimento("Bar do Joao","14981111111","12345678910");
		
		assertEquals(estabelecimento, estabelecimentoRepository.save(estabelecimento));
	}

}
