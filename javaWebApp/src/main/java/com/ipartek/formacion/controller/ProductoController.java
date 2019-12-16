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

import com.ipartek.formacion.modelo.pojo.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/producto")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Producto> listaProductos = new ArrayList<>();
	
//	public void init(ServletConfig config) throws ServletException {
//		
//		
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//TODO visualizar contenido
		Producto p = new Producto( request.getParameter("id"), request.getParameter("nombre"), request.getParameter("imagen"), request.getParameter("descripcion"), request.getParameter("precio"), request.getParameter("descuento"));
		listaProductos.add(p);
		request.setAttribute("listaProductos", listaProductos);
		request.getRequestDispatcher("/jsp/visualizar-productos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String imagen = request.getParameter("imagen");
		String descripcion = request.getParameter("descripcion");
		
		request.setAttribute("id", id);
		request.setAttribute("nombre", nombre);
		request.setAttribute("imagen", imagen);
		request.setAttribute("descripcion", descripcion);

		
		if(isNumeric(request.getParameter("precio")) && isNumeric(request.getParameter("descuento"))
				&& !"".equals(request.getParameter("precio")) && !"".equals(request.getParameter("descuento") )) {
			
			int precio = Integer.parseInt(request.getParameter("precio"));
			int descuento = Integer.parseInt(request.getParameter("descuento"));
			
			
			if(descuento <= 100 && descuento >= 0 ) {
				request.setAttribute("precio", precio);
				request.setAttribute("descuento", descuento);
				/** Si llamo al servlet otra vez, llamo al metodo post con una nueva request
				 * y el Servlet no sabe de donde le viene la peticion. Asi que, hago que vaya 
				 * al metodo get.
				 * @see https://community.oracle.com/thread/1476142
				 * */
				doGet(request, response);
				//request.getRequestDispatcher("helloweb/producto").forward(request, response);				
				
			}else {
				request.setAttribute("precio", precio);
				request.setAttribute("descuento", descuento);
				request.setAttribute("mensaje", "Introduce un descuento entre 0 y 100");
				request.getRequestDispatcher("/jsp/producto.jsp").forward(request, response);
			}
				
				
		}else {
			String precio = (String)request.getParameter("precio");
			String descuento = (String)request.getParameter("descuento");
			
			request.setAttribute("precio", precio);
			request.setAttribute("descuento", descuento);	
			request.setAttribute("mensaje", "Introduce un numero");
			request.getRequestDispatcher("/jsp/producto.jsp").forward(request, response);
		}
		
		
		
	}
	
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
//	public static boolean isNumeric(String str) { 
//		  try {  
//		    Double.parseDouble(str);  
//		    return true;
//		  } catch(NumberFormatException e){  
//		    return false;  
//		  }  
//		}

}
