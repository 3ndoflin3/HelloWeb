package com.ipartek.formacion.supermercado.modelo.dao;

import java.util.List;

import com.ipartek.formacion.modelo.pojo.Perro;

public interface IDAO<P> {

	/**
	 * 
	 * 
	 * 
	 *	@return List<P> 
	 */
	List<P> getAll();
	
	/**
	 * 
	 * @param id
	 * @return POJO
	 * @throws Exception 
	 */
	
	P getById(int id) throws Exception;
	
	
	/**
	 * 
	 * @param id del elemento a eliminar
	 * @return Deleted POJO 
	 * @throws si no puede eliminar 
	 */
	
	P delete(int id) throws Exception;
	
	/**
	 * 
	 * @param id del elemento a actualizar
	 * @return Updated POJO
	 * @throws Exception si no se encuentra
	 */
	
	P update(int id, P pojo) throws Exception;
	
	/**
	 * 
	 * @param pojo con los datos a crear
	 * @return Created POJO
	 * @throws Exception si no se encuentra
	 */
	P create(P pojo) throws Exception;
	
	
	/**
	 *  
	 * @return Size of the list
	 * @throws Exception si no tiene tamaño
	 */
	//int size() throws Exception;
	
	
}
