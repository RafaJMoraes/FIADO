package com.cursoBackend.fiado.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cursoBackend.fiado.dto.ClienteDto;


@Entity
@Table(name = "cleintes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@org.hibernate.annotations.Type(type="uuid-char")
	private UUID id;
	
	private String nome;
	
	private String documento;
	
	private String telefone;
	
	@Embedded
	private Endereco endereco = new Endereco();

	public Cliente() {

	}

	public Cliente(String nome, String documento, String telefone, String rua, int numero) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
	}
	
	public Cliente(UUID id, String nome, String documento, String telefone, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public Cliente(ClienteDto dto) {
		super();
		this.nome = dto.getNome();
		this.documento = dto.getDocumento();
		this.telefone = dto.getTelefone();
		this.endereco.setRua(dto.getEndereco().getRua());
		this.endereco.setNumero(dto.getEndereco().getNumero());
	}


	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	

}
