package com.cursoBackend.fiado.dto;


import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.cursoBackend.fiado.domain.Estabelecimento;


@Valid
public class EstabelecimentoDto {
	
	@NotBlank(message = "Nome não pode ser nulo na criação!")
	private String nome;
	
	@Column(length = 14)
	@Size(max = 14, min = 9)
	private String telefone;
	
	private String documento;
	
	

	public EstabelecimentoDto() {
		super();
	}

	public EstabelecimentoDto(String nome, String telefone, String documento) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.documento = documento;
	}
	
	public EstabelecimentoDto(Estabelecimento estabelecimento) {
		super();
		this.nome = estabelecimento.getNome();
		this.telefone = estabelecimento.getTelefone();
		this.documento = estabelecimento.getDocumento();
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
	
	

}
