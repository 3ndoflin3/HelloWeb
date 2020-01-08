package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int cont = 0;
	private boolean isLogged = false;
	private final static Logger LOG = Logger.getLogger(DogeController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("nombre");
		String pass = request.getParameter("contrasena");
		
		if(!"".equals(pass) && !"".equals(username) && username != null && pass!=null && !isLogged) {
			cont++;
			isLogged = (request.getAttribute("isLogged") == null || (boolean)request.getAttribute("isLogged") == false )?true :false;
			session.setAttribute("isLogged", isLogged);
			request.setAttribute("nombre", username);
			request.setAttribute("contrasena", pass);
			session.setAttribute("mensaje", "login con exito");
			request.setAttribute("contador", cont);
			
		}else {
			if(isLogged) {
				session.setAttribute("mensaje", "Ya estas logeado, no puedes hacerlo 2 veces :v");
				session.setAttribute("isLogged", isLogged);
				request.setAttribute("contador", cont);
			}else {
				session.setAttribute("mensaje", "Introduce datos correctos");
				session.setAttribute("isLogged", isLogged);
				request.setAttribute("contador", cont);
			}
			
			
		}
		
		
		
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

}
