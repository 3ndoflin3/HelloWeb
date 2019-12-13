package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelo.pojo.Perro;

public class ArrayPerroDao implements IDAO<Perro>{

	
	private ArrayList<Perro> registros ;
	
	private static int indice = 1;

	private static ArrayPerroDao INSTANCE = null;
	
	//Changing the constructor to private provokes making instances impossible
	//by calling him because of the access modifier
	private ArrayPerroDao() {
		registros = new ArrayList<>();
	}
	
		
	
	
	
	public synchronized static ArrayPerroDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ArrayPerroDao();
		}
		return INSTANCE;
	}
	
	
	
	
	@Override
	public List<Perro> getAll() {		
		return registros;
	}

	@Override
	public Perro getById(int id) {
		
		Perro resul = null;
		
		for (Perro perro : registros) {
			
			if ( id == perro.getId() ) {
				resul = perro;
				break;
			}
			
		}
		
		return resul;
	}


	@Override
	public Perro delete(int id) throws Exception {
		Perro resul = null;		
		for (Perro perro : registros) {
			
			if ( id == perro.getId() ) {
				resul = perro;
				registros.remove(perro);
				break;
			}
			
		}
		
		if ( resul == null ) {
			throw new Exception("Perro no encontrado por su id " + id );
		}
		
		return resul;
	}

	@Override
	public Perro update(int id, Perro pojo) throws Exception {
		Perro resul = null;
		
		for (int i = 0; i < registros.size(); i++) {
			
			if(id == registros.get(i).getId()) {
				
				registros.remove(i);
				registros.add(pojo);
				resul = pojo;
				
				break;
			}
		}

			
		if(resul== null) {
			throw new Exception("Perro no encontrado por su id " + id);
		}	
		
		return resul;
	}

	@Override
	public Perro create(Perro pojo) throws Exception {
		Perro resul = null;
		
		//TODO comprobar campos del POJO
		if(pojo!= null) {
			pojo.setId(++indice);
			registros.add(pojo);
		}else {
			throw new Exception ("Perro NULL sin datos");
		}
		
		
		return resul;
	}

//	@Override
//	public int size() throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
