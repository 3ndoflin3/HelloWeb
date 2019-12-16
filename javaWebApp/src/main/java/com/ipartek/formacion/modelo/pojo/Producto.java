package com.ipartek.formacion.modelo.pojo;

public class Producto {

	private String id;
	private String nombre;
	private String imagen;
	private String descripcion;
	private String precio;
	private String descuento;
	
	
	public Producto() {
		id = "";
		nombre = "";
		imagen = "";
		descripcion = "";
		precio = "";
		descuento = "";
	}
	
	public Producto(String id, String nombre, String imagen, String descripcion, String precio, String descuento) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.precio = precio;
		this.descuento = descuento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	
	

	
	
		

}
