package com.cursoBackend.fiado.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cursoBackend.fiado.dto.EstabelecimentoDto;

@Entity
@Table(name = "estabelecimento_cliente")
public class EstabelecimentoCliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@org.hibernate.annotations.Type(type="uuid-char")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "estabelecimento_id")
	private Estabelecimento estabelecimento;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public EstabelecimentoCliente() {
		super();
		
	}


	public EstabelecimentoCliente(UUID id, Estabelecimento estabelecimento, Cliente cliente) {
		super();
		this.id = id;
		this.estabelecimento = estabelecimento;
		this.cliente = cliente;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}


	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	

}
