package com.ipartek.formacion.model;

import java.util.List;

public interface LDAO<L> {

	
	
//	create update delete getbyId getall
	
	List<L> getAll();
	
	L getById(int id) throws Exception;
	
	L create(L pojo) throws Exception;
	
	L update (int id, L pojo) throws Exception;
	
	L delete(int id) throws Exception;
}
