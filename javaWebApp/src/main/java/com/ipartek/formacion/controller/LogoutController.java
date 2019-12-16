package com.ipartek.formacion.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String USUARIO = "admin";   
    private static final String PASSWORD= "admin";   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("usuarioLogeado");
		session.invalidate();
		session = null;
		String base = "/" + request.getContextPath() + "/";
		String mensaje = "Gracias por visitarnos";
		//response.sendRedirect(base +"index.jsp?mensaje=" + URLEncoder.encode(mensaje, "UTF-8"));
		request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO__PRIMARY, "Gracias por la visita, te echaremos de menos"));
		//request.getRequestDispatcher("index.jsp?mensaje=" + URLEncoder.encode(mensaje, "UTF-8")).forward(request, response);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
