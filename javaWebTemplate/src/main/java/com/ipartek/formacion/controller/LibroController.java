package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Libro;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LibroController.class);
	private List<Libro> listaLibros = new ArrayList<>();
	@SuppressWarnings("unused")
	private int indice = 0;
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		//LOG.trace("");
//		listaLibros.add(new Libro());
//		listaLibros.add(new Libro());
//		listaLibros.add(new Libro());
//		listaLibros.add(new Libro());
//		indice = listaLibros.size();
	}
	
	@Override
	public void destroy() {
//		LOG.trace("Me inmolo contra las torres gemelas  #9/11");
//		super.destroy();
//		listaLibros = null;
	}
	
	//Si se llama al controlador, lo primero que ejecuta es el init y luego el service, si el service no redirige a 
	//ninguna pagina o metodo el resultado es una pagina en blanco
	
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		LOG.trace("Ola k ase estoy antes del goGet() y el doPost()");
//		
//		//TODO Set attributes de un mensaje y de la lista
//		
//	}
	
    //*****************************METHOD*FOR*REMOVING*************************************************************
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Remove bookz");
		
		listaLibros.remove(listaLibros.size()-1);
		
		//setAttribute of the modified list
		
		request.setAttribute("listaLibros", listaLibros);
		
		
		
		//forward to the jsp
		request.getRequestDispatcher("jsp/visualizarlibros.jsp").forward(request, response);
		
		
	}
	
	//*****************************METHOD*FOR*EDITING*************************************************************
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("add bookz");
		int id ;
		String nombre = request.getParameter("nombre");
		String imagen = request.getParameter("enlace");
		String descripcion = request.getParameter("descripcion");
		float precio;
		int descuento;
		String condicion = "isNumericArray(request.getParameter(\"id\")) && isNumericArray(request.getParameter(\"precio\"))\n	&& isNumericArray(request.getParameter(\"descuento\"))";
		
		//TODO meter en la condicion que los otros valores no esten vacios y validarlos
		//Los mas complicados son los numericos porque tienes que saber antes de parsearlo si el
		//String definido es numerico o contiene algun valor no valido
//		if(isNumericArray(request.getParameter("id")) && isNumericArray(request.getParameter("precio"))
//				&& isNumericArray(request.getParameter("descuento"))) {
		if(Boolean.parseBoolean(condicion)) {
			id = Integer.parseInt(request.getParameter("id"));
			descuento = Integer.parseInt(request.getParameter("descuento"));
			precio = Float.parseFloat(request.getParameter("precio"));
			//Get the PARAMETERS and add them to the new instance
			listaLibros.add(new Libro(id, nombre, imagen, descripcion, precio, descuento));
			
		}
		
		
		
   		
		//Send the ATTRIBUTE to visualize it 
		request.setAttribute("listaLibros", listaLibros);
		
		//Go to the other page
		request.getRequestDispatcher("jsp/visualizarlibros.jsp").forward(request, response);
   		
	}

   	/*Crear un metodo para validar(?)
   	 * el metodo recibe los parametros o un objeto con los parametros(?)
   	 * */

   	public boolean validar(String condicion) {
   		boolean statement = Boolean.parseBoolean(condicion);
   		if(statement) {
   			return true;
   		}else {
   			return false;
   		}
   		
   	}
   	
   	
public static boolean isNumericArray(String str) {
    if (str == null)
        return false;
    char[] data = str.toCharArray();
    if (data.length <= 0)
        return false;
    int index = 0;
    if (data[0] == '-' && data.length > 1)
        index = 1;
    for (; index < data.length; index++) {
        if (data[index] < '0' || data[index] > '9') // Character.isDigit() can go here too.
            return false;
    }
    return true;
}
   	
}
