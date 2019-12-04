package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloController2
 *  @see HelloController para ver como hacer esto sin JSP
 */
@WebServlet("/ejemplo2")
public class HelloController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userAgent = request.getHeader("User-Agent");
		String http = request.getProtocol();
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		final int TETERA = 418, UNAUTHORIZED = 401, passW = 123456;
		final String name ="admin";

		
		
		
		request.getRequestDispatcher("jsp/Ejemplo+JSP.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
