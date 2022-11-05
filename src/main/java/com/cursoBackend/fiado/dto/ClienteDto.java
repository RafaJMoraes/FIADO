package com.cursoBackend.fiado.dto;


public class ClienteDto {
	
	
	private String nome;
	private String documento;
	private String telefone;
	private EnderecoDto endereco;
	
	
	public EnderecoDto getEndereco() {
		return endereco;
	}


	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}


	public ClienteDto() {
		super();
	}
	
	
	public ClienteDto(String nome, String documento, String telefone) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
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
	
	

}
