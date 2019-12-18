package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.Libro;
import com.ipartek.formacion.modelo.LibroDAO;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LibroController.class);
	//private List<Libro> listaLibros;
	private LibroDAO libroDAO = LibroDAO.getInstance();
	
	
	

    //*****************************METODO*PARA*VISUALIZAR*************************************************************
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Visualize bookz");
		
		request.setAttribute("listaLibros", libroDAO.getAll());
		
		//forward to the jsp
		request.getRequestDispatcher("jsp/visualizarlibros.jsp").forward(request, response);
		
	}
	
	//*****************************METODO*PARA*AÑADIR******************************************************************
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("add bookz");
		int id ;
		String nombre = request.getParameter("nombre");
		float precio;
		int descuento;
		
		
//		•	Id: numérico DONE 
//		•	Nombre: Cadena de texto, mínimo 2 letras máximo 150 DONE
//		•	Precio: número mayor que cero y con dos decimales escrito con comas
//		•	Descuento: valor numérico entre 0 y 100 DONE 

		if(isNumericArray(request.getParameter("id")) && 
			isNumericArray(request.getParameter("precio")) && 
			isNumericArray(request.getParameter("descuento"))
			) {
			String precioFormateado = request.getParameter("precio");
			precioFormateado.replace(",", ".");
				
			id = Integer.parseInt(request.getParameter("id"));
			descuento = Integer.parseInt(request.getParameter("descuento"));
			precio = Float.parseFloat(precioFormateado);
			//Get the PARAMETERS and add them to the new instance
			
			if(nombre.length()>2 && nombre.length()<150 && 
				descuento>0 && descuento<=100) {
			
				try {
					libroDAO.create(new Libro(id, nombre, precio, descuento));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
			//Send the ATTRIBUTE to visualize it 
			request.setAttribute("listaLibros", libroDAO.getAll());
			
			//Go to the other page
			request.getRequestDispatcher("jsp/visualizarlibros.jsp").forward(request, response);
	   		
		}else {
			request.setAttribute("mensaje", "Introduce valores correctos");
			request.getRequestDispatcher("jsp/formulario.jsp").forward(request, response);
		}
		
		
	}

   	//Metodo para comprobar si el String que recibe esta formado unicamente por valores numericos
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
	        if (data[index] < '0' || data[index] > '9') // Se puede cambiar por Character.isDigit()
	            return false;
	    }
	    return true;
	}
   	
}
