package com.ipartek.formacion.controller;

public class Alerta {
	//TODO el resto de tipos de alertas
	public static final String TIPO__PRIMARY = "primary";
	public static final String TIPO__DANGER ="danger";
	
	private String tipo, texto;

	
	
	public Alerta() {
		super();
		this.texto = "ERROR inesperado de la aplcacion";
		this.tipo = TIPO__DANGER;
	}

	public Alerta(String tipo, String texto) {
		super();
		this.tipo = tipo;
		this.texto = texto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Alerta [tipo=" + tipo + ", texto=" + texto + "]";
	}
	
	
}
