package com.ipartek.formacion.modelo;

import java.util.List;

public interface LDAO<L> {

	
	
//	create update delete getbyId getall
	
	List<L> getAll();
	
	L getById(int id) throws Exception;
	
	L create(L pojo) throws Exception;
	
}
