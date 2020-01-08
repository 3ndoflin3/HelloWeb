package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelo.pojo.Libro;
import com.ipartek.formacion.modelo.pojo.Perro;

public class LibroDAO implements LDAO<Libro>{
	
	private ArrayList<Libro> libros;
	
	private static int index = 1;
	
	private static LibroDAO INSTANCE = null;
	
	private LibroDAO() {
		libros = new ArrayList<>();
	}
	
	public synchronized static LibroDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		
		return INSTANCE;
		
	}

	@Override
	public List<Libro> getAll() {
		return libros;
	}

	@Override
	public Libro getById(int id) throws Exception {
		Libro book = null;
		
		for(Libro libro: libros) {
			
			if(id == libro.getId()) {
				book = libro;
				break;
			}
		}
		
		return book;
	}

	@Override
	public Libro create(Libro pojo) throws Exception {
		Libro book = null;
			if(pojo!=null) {
				pojo.setId(++index);
				libros.add(pojo);
			}else {
				throw new Exception("Libro NULL sin datos");
			}
			
		return book;
	}

	@Override
	public Libro update(int id, Libro pojo) throws Exception {
		Libro libro = null;
		
		for(int i = 0; i < libros.size(); i++) {
			if(id == libros.get(i).getId()) {
				
				libros.remove(i);
				libros.add(pojo);
				libro = pojo;
				
				break;
			}
		}
		
		if(libro == null) {
			throw new Exception("Libro no encontrado por su id: " + "id");
		}
		
		return libro;
	}

	@Override
	public Libro delete(int id) throws Exception {
		Libro book= null;		
		for (Libro libro: libros) {
			
			if ( id == libro.getId() ) {
				book = libro;
				libros.remove(libro);
				break;
			}
			
		}
		
		if ( book == null ) {
			throw new Exception("Perro no encontrado por su id " + id );
		}
		
		return book;
	}
	
}
