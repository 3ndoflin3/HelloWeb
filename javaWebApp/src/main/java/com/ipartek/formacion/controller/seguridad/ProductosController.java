package com.ipartek.formacion.controller.seguridad;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;

/**
 * Servlet implementation class ProductosController
 */
@WebServlet("/seguridad/Productos")
public class ProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_FORM = "formulario.jsp";
	private static final String VIEW_TABLA = "index.jsp";
	private static ProductoDAO dao;
	
	
	//Acciones Constantes
	private static final String ACCION_LISTAR = "listar";
	private static final String ACCION_IR_FORMULARIO = "formulario";
	private static final String ACCION_GUARDAR 	= "guardar";
	private static final String ACCION_ELIMINAR = "eliminar";
	
	//Parametros
	String accion;
	String id;
	String nombre;
	String imagen;
	String descripcion;
	int precio;
	int descuento;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	
		super.init(config);
		dao = ProductoDAO.getInstance();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		dao = null;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAction(request, response);
	}
	
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//RECOGER PARAMETROS
		//Declararlo global (en el principio de la clase)
		accion = request.getParameter("accion");
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		imagen = request.getParameter("imagen");
		descripcion = request.getParameter("descripcion");
		precio = Integer.parseInt(request.getParameter("precio"));
		descuento = Integer.parseInt(request.getParameter("descuento"));
		
		//TODO switch de acciones funcional
		//TODO metodos para cada accion (listar, eliminar ...)
		try {
			switch(accion) {
			case "":
				
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
}
