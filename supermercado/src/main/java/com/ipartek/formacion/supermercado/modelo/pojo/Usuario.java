package com.ipartek.formacion.supermercado.modelo.pojo;

import javax.validation.constraints.Size;

public class Usuario {
	
	@Size(min = 2, max = 50)
	private int id;
	
	@Size(min = 2, max = 50)
	private String nombre;
	
	@Size(min = 2, max = 50)
	private String contrasenia;

	public Usuario(int id, String nombre, String contrasenia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}

	public Usuario() {
		this.id = 0;
		this.nombre = "";
		this.contrasenia = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
}
