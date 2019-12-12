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

import com.ipartek.formacion.modelo.pojo.Perro;

/**
 * Servlet implementation class DogeController
 */
@WebServlet("/doge")
public class DogeController extends HttpServlet {
	
	private final static Logger LOG = Logger.getLogger(DogeController.class);
	private static final long serialVersionUID = 1L;
	private List<Perro> listaPerros = new ArrayList<>();
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		LOG.trace("Se ejecuta la primera vez que se llama a este Servlet y nunca mas"); 
		super.init(config);
	}
	
	
	
	@Override
	public void destroy() {
		LOG.trace("Se ejecuta solo una vez cuando se para el servidor");
		super.destroy();
		listaPerros = null;
	}
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.trace("Se ejecuta antes del doGet() o doPost()");
		super.service(req, resp);
		LOG.trace("Se ejecuta antes del doGet() o doPost()");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Add dogs");
		listaPerros.add(new Perro(request.getParameter("nombre")));
		
		request.setAttribute("perros", listaPerros);
		
		request.getRequestDispatcher("/jsp/Doges.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("KILL DOGZ");
		
		listaPerros.remove(listaPerros.size()-1);
		
		
		
		
		request.setAttribute("perros", listaPerros);
		
		request.getRequestDispatcher("/jsp/Doges.jsp").forward(request, response);
	}

}
