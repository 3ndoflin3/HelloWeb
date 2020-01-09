package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.supermercado.model.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.dao.CategoriaDAO;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Categoria;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ProductoDAO dao;
	private static CategoriaDAO daoCategoria;
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		dao = ProductoDAO.getInstance();
		daoCategoria = CategoriaDAO.getINSTANCE();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		  Connection con = ConnectionManager.getConnection();
	         if(null == con) {
	        	 response.sendRedirect("/error/error.jsp");
	         }else {
	        	 super.service(request, response);
	         }	
		
	}
	
	@Override
	public void destroy() {	
		super.destroy();
		dao = null;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO guaramente creamos una categoria, esto deberia probarse en otro sitio
		try {
			Categoria c = new Categoria();
			c.setNombre("mock" + System.currentTimeMillis() );
			daoCategoria.create(c);

			daoCategoria.delete(c.getId());

			daoCategoria.update(1, c);

			daoCategoria.getById(1) ;

		}catch (Exception e) {
			e.printStackTrace();
		}	

		//llamar al DAO capa modelo
		List<Producto> productos = dao.getAll();
		List<Categoria> categorias = daoCategoria.getAll();



		request.setAttribute("productos", productos );		
		request.setAttribute("categorias", categorias );
		
		request.setAttribute("mensajeAlerta", new Alerta( Alerta.TIPO_PRIMARY , "Los últimos productos destacados.") );		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

}
