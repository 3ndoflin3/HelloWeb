package com.ipartek.formacion.supermercado.modelo.dao;

import java.util.List;

import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

public interface IProductoDAO extends IDAO<Producto>{

	
	/** 
	 * Lista los productos de un usuario
	 * @param idUsuario int id del Usuario
	 * @return List<Producto>, lista inicializada en caso de que no tenga productos
	 * 
	 * */
	
	List<Producto> getAllByUser(int idUsuario);
	
	
	/**
	 * Recupera un Producto de un Usuario concreto
	 * @param idProducto
	 * @param idUsuario
	 * @return Producto si lo encuentra, null si no lo encuentra
	 * @throws ProductoException (Cuando el producto que intenta recuperar no pertenece al Usuario)
	 */
	
	Producto getByIdByUser(int idProducto, int idUsuario) throws ProductoException;
	
	/**
	 * 
	 * @param idProducto
	 * @param idUsuario
	 * @param pojo
	 * @return @class Producto actualizado si lo encuentra, null si no lo encuentra
	 * @throws @class ProductoException
	 * 		<ol>
	 * 			<li> Cuando intenta eliminar un producto que no pertenece al usuario </li>
	 * 			<li> Cuando no encuentra un producto por su id </li>
	 * 		</ol>
	 */
	
	public Producto updateByUser(int idProducto, int idUsuario, Producto pojo) throws ProductoException;

	/**
	 * 
	 * @param idProducto
	 * @return Producto eliminado si lo encuentra, lanza una excepcion si no lo encuentra
	 * @throws ProductoException
	 */
	public Producto deleteByUser (int idProducto) throws ProductoException;
}
