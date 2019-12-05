package com.ipartek.formacion.modelo.pojo;

public class Perro {

	private int id;
	private String nombre, foto;
	
	
	public Perro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.foto = "https://ih0.redbubble.net/image.445130512.1102/fposter,small,wall_texture,product,750x1000.u1.jpg";
	}
	
	public Perro(int id, String nombre, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}


	

}
