package com.cursoBackend.fiado.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cursoBackend.fiado.domain.EstabelecimentoCliente;


public interface EstabelecimentoClienteRepository extends JpaRepository<EstabelecimentoCliente, UUID> {

	
  
}
