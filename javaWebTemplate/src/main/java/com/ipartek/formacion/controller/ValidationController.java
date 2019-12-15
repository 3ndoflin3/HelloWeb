package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ValidationController
 */
@WebServlet("/validar")
public class ValidationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(ValidationController.class);
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");

		//This is to take 1 value
		//String deporte = request.getParameter("deporte");
		String[] deporte = request.getParameterValues("deporte");
		
		
		
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("email", email);
		request.setAttribute("deporte", deporte);
		request.setAttribute("valor", "K kiere ase");
		
		request.getRequestDispatcher("/jsp/visualizardatos.jsp").forward(request, response);
		
	}
	
	

}
