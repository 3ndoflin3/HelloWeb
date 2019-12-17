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

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Perro;

/**
 * Servlet implementation class DogeController
 */
@WebServlet("/doge")
public class DogeController extends HttpServlet {
	
	//TODO LOG CONFIG 
	//private final static Logger LOG = Logger.getLogger(DogeController.class);
	private final Logger LOG=Logger.getLogger(this.getClass().getName());
	private static final long serialVersionUID = 1L;
	private List<Perro> listaPerros = new ArrayList<>();
	private String mensaje;
	private int indice = 0;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//BasicConfigurator.configure();
		LOG.trace("Se ejecuta la primera vez que se llama a este Servlet y nunca mas"); 
		super.init(config);
		
		listaPerros.add(new Perro(1, "Mr. Doge"));
		listaPerros.add(new Perro(1, "El Dogo"));
		listaPerros.add(new Perro(1, "Mr. Guau"));
		listaPerros.add(new Perro(1, "Yo Ladro"));
		listaPerros.add(new Perro(1, "Polisia"));
		listaPerros.add(new Perro(1, "Perro"));
		indice = 6;
	}
	
	
	
	@Override
	public void destroy() {
		LOG.trace("Se ejecuta solo una vez cuando se para el servidor");
		super.destroy();
		listaPerros = null;
	}
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Se ejecuta antes del doGet() o doPost()");
		LOG.warn("WARNING");
		mensaje = "";
		
		super.service(request, response);
		LOG.trace("Se ejecuta antes del doGet() o doPost()");
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("perros", listaPerros);
		
		//request.getRequestDispatcher("/jsp/Doges.jsp").forward(request, response);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Add dogs");
		listaPerros.add(new Perro(request.getParameter("nombre")));
		
		request.setAttribute("perros", listaPerros);
		
		request.getRequestDispatcher("/jsp/Doges.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("KILL DOGZ");
		
		listaPerros.remove(listaPerros.size()-1);
		
		
		
		
		request.setAttribute("perros", listaPerros);
		
		request.getRequestDispatcher("/jsp/Doges.jsp").forward(request, response);
	}

}
