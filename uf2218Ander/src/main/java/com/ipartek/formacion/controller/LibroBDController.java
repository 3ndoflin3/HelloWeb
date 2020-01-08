package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Libro;
import com.ipartek.formacion.modelo.LibroDAO;

/**
 * Servlet implementation class LibroBDController
 */
@WebServlet("/LibroBD")
public class LibroBDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LibroDAO libroDAO = LibroDAO.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Libro> listaLibros = libroDAO.getAll();
		
		if(listaLibros != null)
		request.setAttribute("listaLibros", listaLibros);
		else
			request.setAttribute("mensaje", "La lista es null :c");
		request.getRequestDispatcher("/jsp/listarlibros.jsp").forward(request, response);
		
		
	}

}
