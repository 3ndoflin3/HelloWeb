package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USUARIO = "admin";   
    private static final String PASSWORD= "admin";   
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO POJO y DAO usuario
		String vista = "";
		//1. Recibir parametros
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String idioma = request.getParameter("idioma");
		String recuerdame = request.getParameter("recuerdame");
		
		//2. Logica de negocio
		if(USUARIO.equals(name) && PASSWORD.equals(pass) ) {
			
			
			//recuperar la sesion del usuario == browser
			
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", "Administrador");
			session.setAttribute("idioma", idioma);
			session.setMaxInactiveInterval(60*3); //5 seg poner la operacion 1 dia = 60*60*24
			
			
			
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
			String base = request.getContextPath() + "/";
			vista = "private/home";
			response.sendRedirect(base + vista);
		}
		else {
			request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO__DANGER, "Credenciales incorrectas, prueba de nuevo");
			vista = "jsp/LoginFallido.jsp";
			request.getRequestDispatcher(vista).forward(request, response);
		}
		
		
		//request.getRequestDispatcher(vista).forward(request, response);
	}

}
