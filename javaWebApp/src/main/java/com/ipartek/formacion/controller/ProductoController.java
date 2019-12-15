package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/product")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
//	public void init(ServletConfig config) throws ServletException {
//		
//		
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//TODO visualizar contenido
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String imagen = request.getParameter("imagen");
		String descripcion = request.getParameter("descripcion");

		if(((String)request.getParameter("precio")) != null) {
			
			String precio = (String)request.getParameter("precio");
			String descuento = (String)request.getParameter("descuento");
			
//			int precio = Integer.parseInt((String)request.getAttribute("precio"));
//			int descuento = Integer.parseInt((String)request.getAttribute("descuento"));
//			
			request.setAttribute("precio", precio);
			request.setAttribute("descuento", descuento);
			
		}else {
			request.setAttribute("mensaje", "Introduce un numero");
		}
		
		request.setAttribute("id", id);
		request.setAttribute("nombre", nombre);
		request.setAttribute("imagen", imagen);
		request.setAttribute("descripcion", descripcion);
		
		request.getRequestDispatcher("/jsp/producto.jsp").forward(request, response);
		
	}

}
