package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vista = "";
		//1. Recibir parametros
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String idioma = request.getParameter("idioma");
		String recuerdame = request.getParameter("recuerdame");
		
		//2. Logica de negocio
		if("admin".equals(name) && "admin".equals(pass) && "1".equals(recuerdame) ) {
			String mensaje="";
			switch(idioma) {
			case "es":
				mensaje = (recuerdame == null)?"Sea bienvenido" : "Sea bienvenido y recordado" ;
				break;
			
			case "en":
				mensaje = (recuerdame == null)?"Whats up m8" : "Welcome m8 you will be remembered" ;
				
				break;
				
			case "eu":
				mensaje = (recuerdame == null)?"Ongi etorri txo!" : "Ongi etorri txo! zure pasahitza gorde dut" ;

				break;
				
			case "cat":
				
				mensaje = "Hola mare";
				break;
				
			}
			
			vista = "LoginExito.jsp";
		}
		else {
			vista = "LoginFallido.jsp";
		}
		
		request.getRequestDispatcher(vista).forward(request, response);
	}

}
