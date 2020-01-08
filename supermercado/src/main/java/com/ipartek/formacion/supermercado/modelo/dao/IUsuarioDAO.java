package com.ipartek.formacion.supermercado.modelo.dao;

import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

public interface IUsuarioDAO extends IDAO<Usuario>{

	/**
	 * Comprueba si existe el usuario en la base de datos
	 * @param nombre
	 * @param contrasenia
	 * @return Retorna un Usuario si lo encuentra  y si no devuelve un null
	 * */
	
	Usuario existe(String nombre, String contrasenia);
	
	
	
}
