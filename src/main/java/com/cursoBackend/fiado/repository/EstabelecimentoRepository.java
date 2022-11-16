package com.cursoBackend.fiado.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.domain.EstabelecimentoCliente;
import com.cursoBackend.fiado.domain.UsuarioSistema;


public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, UUID> {

	Optional<UsuarioSistema> findByTelefone(String username);

	
  
}
