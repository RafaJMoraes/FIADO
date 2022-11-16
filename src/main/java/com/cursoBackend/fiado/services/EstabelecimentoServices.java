package com.cursoBackend.fiado.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.domain.UsuarioSistema;
import com.cursoBackend.fiado.dto.EstabelecimentoDto;
import com.cursoBackend.fiado.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoServices {
	
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	
	public Estabelecimento	save(EstabelecimentoDto estabelecimentoDto) {
		Estabelecimento estabelecimento = new Estabelecimento(estabelecimentoDto);
		
		return estabelecimentoRepository.save(estabelecimento);
	}


	public List<Estabelecimento> findAll() {
		return estabelecimentoRepository.findAll();
	}


	public Optional<Estabelecimento> findById(UUID estabelecimentoId) {
		
		return estabelecimentoRepository.findById(estabelecimentoId);
	}


	public Optional<UsuarioSistema> findByLogin(String username) {
		return estabelecimentoRepository.findByTelefone(username);
	}
	
}
