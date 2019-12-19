package com.ipartek.formacion.modelo;

public class Libro {
	
	private int id;
	private String nombre;
	private float precio;
	private int descuento;
	private String enlace;
	private String autor;
	private String imagenPre ="https://image.flaticon.com/icons/png/512/260/260506.png";
	
	public Libro() {
		super();
		this.id =0;
		this.nombre ="";
		this.precio =0;
		this.descuento =0;
		this.enlace = imagenPre;
		this.autor = "";
	}
	
	
	public Libro( String nombre, float precio, int descuento, String enlace, String autor) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.enlace = (!"".equals(enlace))?enlace : imagenPre;
		this.autor = (!"".equals(autor))?autor: "Anonimo";
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getEnlace() {
		return enlace;
	}


	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + "]";
	}
	
}
