package com.cursoBackend.fiado.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.domain.EstabelecimentoCliente;


public interface EstabelecimentoClienteRepository extends JpaRepository<EstabelecimentoCliente, UUID> {

	
	List<EstabelecimentoCliente> findByEstabelecimento(Estabelecimento estabelecimento);

	Optional<EstabelecimentoCliente> findByEstabelecimentoAndCliente(Estabelecimento estabelecimento, Cliente cliente);

	@Query("select new com.cursoBackend.fiado.domain.Cliente(ec.cliente.id, "
			+ "ec.cliente.nome, "
			+ "ec.cliente.documento, "
			+ "ec.cliente.telefone, "
			+ "ec.cliente.endereco) from EstabelecimentoCliente ec where ec.estabelecimento = ?1")
	List<Cliente> findClienteByEstabelecimento(Estabelecimento estabelecimento);

}
