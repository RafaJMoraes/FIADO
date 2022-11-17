package com.cursoBackend.fiado.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import com.cursoBackend.fiado.dto.EstabelecimentoDto;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "establecimentos")
public class Estabelecimento extends RepresentationModel<Estabelecimento> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@org.hibernate.annotations.Type(type="uuid-char")
	private UUID id;

	@NotBlank
	private String nome;
	
	@Column(length = 14)
	private String telefone;
	
	private String documento;
	

	public Estabelecimento() {
		
	}


	public Estabelecimento(String nome, String telefone, String documento) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.documento = documento;
	}
	

	public Estabelecimento(EstabelecimentoDto estabelecimentoDto) {
		super();
		this.nome = estabelecimentoDto.getNome();
		this.telefone = estabelecimentoDto.getTelefone();
		this.documento = estabelecimentoDto.getDocumento();
	}



	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
