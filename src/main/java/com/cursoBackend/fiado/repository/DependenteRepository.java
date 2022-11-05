package com.cursoBackend.fiado.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.CompraFiada;
import com.cursoBackend.fiado.domain.Dependente;


public interface DependenteRepository extends JpaRepository<Dependente, UUID> {

	
  
}
