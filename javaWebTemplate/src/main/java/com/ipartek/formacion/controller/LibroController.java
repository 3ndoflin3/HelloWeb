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

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Libro;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/libro")
public class LibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LibroController.class);
	private List<Libro> listaLibros = new ArrayList<>();
	private int indice = 0;
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		LOG.trace("");
		listaLibros.add(new Libro());
		listaLibros.add(new Libro());
		listaLibros.add(new Libro());
		listaLibros.add(new Libro());
		indice = listaLibros.size();
	}
	
	@Override
	public void destroy() {
		LOG.trace("Me inmolo contra las torres gemelas  #9/11");
		super.destroy();
		listaLibros = null;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Ola k ase estoy antes del goGet() y el doPost()");
		
		//TODO Set attributes de un mensaje y de la lista
		
	}
	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("add bookz");
		
   		//Get the PARAMETERS and add them to the new instance
		listaLibros.add(new Libro());
		
		//Send the ATTRIBUTE to visualize it 
		request.setAttribute("listaLibros", listaLibros);
		
		//Go to the other page
		request.getRequestDispatcher("").forward(request, response);
   		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Remove bookz");
		
		listaLibros.remove(listaLibros.size()-1);
		
		//setAttribute of the modified list
		
		request.setAttribute("listaLibros", listaLibros);
		
		
		
		//forward to the jsp
		request.getRequestDispatcher("").forward(request, response);
		
		
	}

}
