package com.cursoBackend.fiado.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoBackend.fiado.domain.Estabelecimento;


public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, UUID> {

	
  
}
