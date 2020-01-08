package com.ipartek.formacion.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.ipartek.formacion.modelo.Libro;

public class LibroDAO implements LDAO<Libro>{
	
	private static List<Libro> libros;
	
	private static int index = 1;
	private final static String USUARIO ="root";
	private final static String PASS ="";
	private final static String URL ="jdbc:mysql://localhost:3306/libros";
	
	private static LibroDAO INSTANCE = null;
	//Constructor
	private LibroDAO() {
		//String imagen = "https://image.flaticon.com/icons/png/512/260/260506.png";
		libros = new ArrayList<>();
//		libros.add(new Libro("Lord of the rings", 24.53f, 20, imagen, "Autor"));
//		libros.get(0).setId(0);
//		libros.add(new Libro("The bible", 5.3f, 0, imagen, "Autor"));
//		libros.get(1).setId(1);
//		libros.add(new Libro("Necronomicon", 56.1f, 10, imagen, "Autor"));
//		libros.get(2).setId(2);
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
				index=libros.size();
				pojo.setId(++index);
				libros.add(pojo);
			}else {
				throw new Exception("Libro NULL sin datos");
			}
			
		return book;
	}

	@Override
	public void update(int id, Libro pojo) {
		for(Libro libro : libros) {
			if(id == libro.getId()) {
				libros.remove(id);
				break;
			}
		}
		libros.add(id, pojo);
		libros.get(id).setId(id);
		libros.sort(Comparator.comparing(Libro::getId));
	}
	
	
	
}
