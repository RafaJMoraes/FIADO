package com.cursoBackend.fiado.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.CompraFiada;


public interface CompraFiadaRepository extends JpaRepository<CompraFiada, UUID> {

	List<CompraFiada> findByCliente(Cliente c);

	
  
}
