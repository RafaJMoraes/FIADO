package com.cursoBackend.fiado.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cursoBackend.fiado.dto.CompraFiadaDto;

@Entity
@Table(name = "compras_fiadas")
public class CompraFiada implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "estabelecimento_id")
	private Estabelecimento estabelecimento;

	@Id
	@GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@org.hibernate.annotations.Type(type="uuid-char")
	private UUID id;
	
	private String nome;
	
	private String observacao;
	
	private int valor;
	
	private LocalDateTime data;
	
	private boolean foiPaga;


	public CompraFiada() {
		this.data = LocalDateTime.now();
	}

	public CompraFiada( String nome, String observacao, int valor) {
		super();

		this.nome = nome;
		this.observacao = observacao;
		this.valor = valor;
		this.data = LocalDateTime.now();
	}
	
	public CompraFiada(CompraFiadaDto dto) {
		super();
		this.nome = dto.getNome();
		this.observacao = dto.getObservacao();
		this.valor = dto.getValor();
		this.data = LocalDateTime.now();
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		CompraFiada other = (CompraFiada) obj;
		return Objects.equals(id, other.id);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	

	public boolean isFoiPaga() {
		return foiPaga;
	}

	public void setFoiPaga(boolean foiPaga) {
		this.foiPaga = foiPaga;
	}
	
	
	

}
