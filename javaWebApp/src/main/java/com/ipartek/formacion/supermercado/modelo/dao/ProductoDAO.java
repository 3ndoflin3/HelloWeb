package com.ipartek.formacion.supermercado.modelo.dao;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.modelo.dao.IDAO;


public class ProductoDAO implements IDAO<Producto>{

	private static ProductoDAO INSTANCE;
	private ArrayList<Producto> registros;
	private int indice = 1;
	
	
	
	private ProductoDAO() {
		super();
		
		registros = new ArrayList<>();
		
		//TODO 10 productos un poco mas elaborados
		for (int i = 0; i <= 10; i++) {
			registros.add(new Producto(indice+"", "nombre", "imagen", "descripcion", "23", "14"));
			indice++;
		}
		
	}
	
	
	public synchronized static ProductoDAO getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new ProductoDAO();
		}
		return INSTANCE;
	}


	@Override
	public List<Producto> getAll() {
		return registros;
	}


	@Override
	public Producto getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Producto delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Producto update(int id, Producto pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Producto create(Producto pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
