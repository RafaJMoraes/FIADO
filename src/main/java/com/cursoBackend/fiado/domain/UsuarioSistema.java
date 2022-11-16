package com.cursoBackend.fiado.domain;



import java.io.Serializable;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import com.cursoBackend.fiado.enums.TipoUsuario;

@MappedSuperclass
public class UsuarioSistema extends RepresentationModel<Estabelecimento> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@org.hibernate.annotations.Type(type="uuid-char")
	private UUID id;
	
	private String telefone;
	
	private String hashPassword;
	
	private TipoUsuario tipoUsuario;



	

}
