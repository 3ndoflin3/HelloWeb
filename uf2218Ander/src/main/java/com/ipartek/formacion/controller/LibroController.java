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
		LOG.trace("Visualizar libros");
		
		request.setAttribute("listaLibros", libroDAO.getAll());
		
		//forward to the jsp
		request.getRequestDispatcher("jsp/visualizarlibros.jsp").forward(request, response);
		
	}
	
	//*****************************METODO*PARA*AÑADIR******************************************************************
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("add libros");
		String nombre = request.getParameter("nombre");
		float precio;
		int descuento;
		String precioFormateado = request.getParameter("precio");
		
		precioFormateado = precioFormateado.replaceAll(".", "");
		precioFormateado = precioFormateado.replaceAll(",", ".");

		if( isPositiveNumericFloat(precioFormateado) && 
			isPositiveNumericArray(request.getParameter("descuento"))
			) {
			LOG.trace("Son numeros positivos");	
			//id = Integer.parseInt(request.getParameter("id"));
			descuento = Integer.parseInt(request.getParameter("descuento"));
			precio = Float.parseFloat(precioFormateado);
			//Get the PARAMETERS and add them to the new instance
			
			if(nombre.length()>2 && nombre.length()<150 && 
				descuento>=0 && descuento<=100) {
				
				//Esta con try y catch porque el metodo de la interfaz lanza una excepcion (aunque nunca va a dar error)
				try {
					libroDAO.create(new Libro(nombre, precio, descuento));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Envia la lista para poder visualizarla tras recogerla
				request.setAttribute("listaLibros", libroDAO.getAll());
				
				//Ir a la otra pagina
				request.getRequestDispatcher("jsp/visualizarlibros.jsp").forward(request, response);
			}else {
				request.setAttribute("mensaje", "Introduce un nombre con una longitud entre 2 y 150 y un descuento con una longitud entre 0 y 100 ");
				request.getRequestDispatcher("jsp/formulario.jsp").forward(request, response);
			}
				
			
	   		
		}else {
			request.setAttribute("nombre", request.getParameter("nombre"));
			request.setAttribute("precio", request.getParameter("precio"));
			request.setAttribute("descuento", request.getParameter("descuento"));
			
			request.setAttribute("mensaje", "Introduce un precio con valor positivo y un descuento con una longitud entre 0 y 100");
			request.getRequestDispatcher("jsp/formulario.jsp").forward(request, response);
		}
		
		
	}

   	//Metodo para comprobar si el String que recibe es un numero flotante
   	private boolean isPositiveNumericFloat(String precioFormateado) {
   		float numero;
		try {
			numero = Float.parseFloat(precioFormateado);
			if(numero<=0) {
				return false;
			}else {
				return true;
			}
			
		}catch(Exception e){
			return false;
		}

	}

	//Metodo para comprobar si el String que recibe esta formado unicamente por valores numericos
	public static boolean isPositiveNumericArray(String str) {
	    if (str == null)
	        return false;
	    char[] data = str.toCharArray();
	    if (data.length <= 0)
	        return false;
	    int index = 0;
	    
	    if (data[0] == '-' && data.length > 1) {
	        index = 1;
	        return false;
	    }
	    
	    
	    for (; index < data.length; index++) {
	        if (data[index] < '0' || data[index] > '9') // Se puede cambiar por Character.isDigit()
	            return false;
	    }
    
	    return true;
	}
   	
}
