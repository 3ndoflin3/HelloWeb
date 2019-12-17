package com.ipartek.formacion.modelo.pojo;

public class Libro {
	
	private int id;
	private String nombre;
	private String imagen;
	private String descripcion;
	private float precio;
	private int descuento;
	
	
	
	public Libro() {
		super();
		this.id =0;
		this.nombre ="";
		this.imagen ="";
		this.descripcion ="";
		this.precio =0;
		this.descuento =0;
	}
	
	
	public Libro(int id, String nombre, String imagen, String descripcion, float precio, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.precio = precio;
		this.descuento = descuento;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", descuento=" + descuento + "]";
	}
	
	
	
	
	
	
	
	
}
