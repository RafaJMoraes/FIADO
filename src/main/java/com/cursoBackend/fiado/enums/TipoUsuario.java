package com.cursoBackend.fiado.enums;

public enum TipoUsuario {

	Cliente("Cliente"),
	Estabelecimento("Estabelecimento");
	
	private String label;
	
	TipoUsuario(String label){this.label = label;}
}
