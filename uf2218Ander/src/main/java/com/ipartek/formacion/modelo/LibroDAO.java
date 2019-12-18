package com.ipartek.formacion.modelo;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.modelo.Libro;

public class LibroDAO implements LDAO<Libro>{
	
	private static ArrayList<Libro> libros;
	
	private static int index = 1;
	
	private static LibroDAO INSTANCE = null;
	
	//Constructor
	private LibroDAO() {
		libros = new ArrayList<>();
	}
	
	//*******************************************************METODOS****************************************************************/
	//Metodo para llamar al constructor en el caso en que la variable INSTANCE sea null
	public synchronized static LibroDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		
		return INSTANCE;
		
	}

	//Metodo para obtener la lista de libros
	@Override
	public List<Libro> getAll() {
		return libros;
	}

	//Metodo para obtener un libro por su ID
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

	//Metodo para crear un libro y meterlo en la lista 
	@Override
	public Libro create(Libro pojo) throws Exception {
		Libro book = null;
			if(pojo!=null) {
				pojo.setId(index++);
				libros.add(pojo);
			}else {
				throw new Exception("Libro NULL sin datos");
			}
			
		return book;
	}

}