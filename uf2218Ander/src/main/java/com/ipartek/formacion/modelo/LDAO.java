package com.ipartek.formacion.modelo;

import java.util.List;

public interface LDAO<L> {

//	create update delete getbyId getall setall
	
	List<L> getAll();
	
	void update(int id, L pojo);
	
	L getById(int id) throws Exception;
	
	L create(L pojo) throws Exception;
	
}
