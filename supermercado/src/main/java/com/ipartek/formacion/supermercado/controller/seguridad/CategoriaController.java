package com.ipartek.formacion.supermercado.controller.seguridad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.modelo.dao.CategoriaDAO;

/**
 * Servlet implementation class CategoriaController
 */
@WebServlet("/seguridad/categorias")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoriaDAO categoriaDao;   

    //acciones
  	public static final String ACCION_LISTAR = "listar";
  	public static final String ACCION_IR_FORMULARIO = "formulario";
  	public static final String ACCION_GUARDAR = "guardar";   // crear y modificar
  	public static final String ACCION_ELIMINAR = "eliminar";
  	
  	
    
    public void init() {
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) {
		int id ;
		String nombre = request.getParameter("nombre");
		String accion = request.getParameter("accion");
		
		switch(accion) {
		case ACCION_LISTAR:
			listar();
			break;
			
		case ACCION_GUARDAR:
			guardar();
			break;
			
		case ACCION_IR_FORMULARIO:
			irFormulario();
			break;
			
		case ACCION_ELIMINAR: 
			eliminar();
			break;
		}
		
		
		
	}

}
