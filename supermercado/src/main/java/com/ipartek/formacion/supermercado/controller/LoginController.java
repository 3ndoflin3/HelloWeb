package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;

import com.ipartek.formacion.supermercado.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private final static Logger LOG = Logger.getLogger(LoginController.class);

	private static final long serialVersionUID = 1L;
	private static final String USUARIO = "admin";
	private static final String PASSWORD = "admin";
    private static UsuarioDAO usuarioDao = UsuarioDAO.getInstance();   


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
		
		String view = "login.jsp";
		
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("contrasenya");
		
		try {
			
			Usuario usuario = usuarioDao.existe(nombre, pass);
			
			if ( usuario!=null ) {
				LOG.infof("login correcto " + usuario);
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogeado", usuario);
				session.setMaxInactiveInterval(60*3); // 3min
				
				view = "seguridad/index.jsp";
				
			}else {
				
				request.setAttribute("mensajeAlerta", new Alerta( Alerta.TIPO_DANGER, "Credenciales incorrectas, prueba de nuevo"));
				
			}
		}catch (Exception e) {
			LOG.error(e);
			
		}finally {
			
			request.getRequestDispatcher(view).forward(request, response);
		}	
		
		
		
	}

}
