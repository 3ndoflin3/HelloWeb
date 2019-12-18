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
		
		
		
		if(isNumericArray(request.getParameter("id")) && 
			isNumericArray(request.getParameter("precio")) && 
			isNumericArray(request.getParameter("descuento"))
			) {
			
			id = Integer.parseInt(request.getParameter("id"));
			descuento = Integer.parseInt(request.getParameter("descuento"));
			precio = Float.parseFloat(request.getParameter("precio"));
			//Get the PARAMETERS and add them to the new instance
			
			try {
				
				libroDAO.create(new Libro(id, nombre, precio, descuento));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Send the ATTRIBUTE to visualize it 
			request.setAttribute("listaLibros", libroDAO.getAll());
			
			//Go to the other page
			request.getRequestDispatcher("jsp/visualizarlibros.jsp").forward(request, response);
	   		
		}else {
			
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
	        if (data[index] < '0' || data[index] > '9') // Character.isDigit() can go here too.
	            return false;
	    }
	    return true;
	}
   	
}
