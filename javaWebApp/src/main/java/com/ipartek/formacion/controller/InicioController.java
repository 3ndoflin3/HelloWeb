package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;

/**
 * Servlet implementation class ValidationController
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(InicioController.class);
    private static ProductoDAO dao;
	
    
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
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO llamar al DAO
		ArrayList <Producto> listaProductos = (ArrayList<Producto>) dao.getAll();
		
	
		request.setAttribute("listaProductos", listaProductos);
		request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO__PRIMARY, "Los ultimos productos destacados para ti."));
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	

}
