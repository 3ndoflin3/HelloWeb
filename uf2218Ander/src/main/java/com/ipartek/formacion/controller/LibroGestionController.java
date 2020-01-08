package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.Libro;
import com.ipartek.formacion.modelo.LibroDAO;

/**
 * Servlet implementation class LibroGestionController
 */
@WebServlet("/seguridad/librogestion")
public class LibroGestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LibroController.class);
	private LibroDAO libroDAO = LibroDAO.getInstance();   
   
	//Para borrar usar el boton de eliminar y mandar params en la url
	/*METODO PARA BORRAR*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		
		if(isPositiveNumericArray(idString)) {
			int id = Integer.parseInt(idString);
			if(id<=libroDAO.getAll().size()) {
				libroDAO.getAll().remove(id);
				request.setAttribute("mensaje", "Libro eliminado");
				request.getRequestDispatcher("/libro").forward(request, response);
			}else {
				request.setAttribute("mensaje", "El ID no corresponde con nuestros datos");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("mensaje", "Introduce un ID valido");
			response.sendRedirect("index.jsp");
		}
	}

	/*METODO PARA EDITAR*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("editar libros");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		float precio;
		int descuento;
		String precioFormateado = request.getParameter("precio");
		String enlace = request.getParameter("enlace");
		String autor = request.getParameter("autor");
		
		precioFormateado = precioFormateado.replace(".", "");
		precioFormateado = precioFormateado.replace(",", ".");

		if( isPositiveNumericFloat(precioFormateado) && 
			isPositiveNumericArray(request.getParameter("descuento")) &&
			isPositiveNumericArray(request.getParameter("id"))
			) {
			LOG.trace("Son numeros positivos");	
			descuento = Integer.parseInt(request.getParameter("descuento"));
			precio = Float.parseFloat(precioFormateado);
			//Get the PARAMETERS and add them to the new instance
			
			if(nombre.length()>2 && nombre.length()<150 && 
				descuento>=0 && descuento<=100 && Integer.parseInt(id)<=libroDAO.getAll().size()) {
				
				libroDAO.update(Integer.parseInt(id), new Libro(nombre, precio, descuento, enlace, autor));
				
				//Envia la lista para poder visualizarla tras recogerla
				request.setAttribute("listaLibros", libroDAO.getAll());
				
				//Ir a la otra pagina
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else if(!isPositiveNumericArray(request.getParameter("id"))) {
				request.setAttribute("mensaje", "Introduce un ID numerico valido");
			}else {
				
				request.setAttribute("mensaje", "Introduce un nombre con una longitud entre 2 y 150 y un descuento con una longitud entre 0 y 100 ");
				request.getRequestDispatcher("jsp/formularioEditar.jsp").forward(request, response);
			}
				
			
	   		
		}else {
			request.setAttribute("nombre", request.getParameter("nombre"));
			request.setAttribute("precio", request.getParameter("precio"));
			request.setAttribute("descuento", request.getParameter("descuento"));
			
			request.setAttribute("mensaje", "Introduce un precio con valor positivo y un descuento con una longitud entre 0 y 100");
			request.getRequestDispatcher("jsp/formularioEditar.jsp").forward(request, response);
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
