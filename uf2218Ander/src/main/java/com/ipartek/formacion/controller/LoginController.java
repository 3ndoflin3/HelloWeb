package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);		
	}
	

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vista = "";
		@SuppressWarnings("null")
		boolean usuarioLogeado;
		HttpSession session = request.getSession();
		//1. recibir parametros
		String usuario    = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
	
		
		//2. logica de negocio
		
		if ( "administrador".equalsIgnoreCase(usuario) && 
		     "123456".equalsIgnoreCase(contrasena)
		 ) {
			
			String mensaje = "Logeado con exito!";
			request.setAttribute("mensaje", mensaje);
			vista = "/kiryl/libro";			
			usuarioLogeado = true;
			session.setAttribute("usuarioLogeado",usuarioLogeado);// ir a JSP
			response.sendRedirect(vista);
		}else {
			
			request.setAttribute("mensaje", "Credenciales Incorrectas, por favor prueba de nuevo");
			vista = "/jsp/login.jsp";
			// ir a JSP
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
		

		
		
	}



}
