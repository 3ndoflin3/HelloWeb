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
		
		
		
		
		
	}

}
