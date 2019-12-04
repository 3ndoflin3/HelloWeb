package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloController
 * Ejemplo para aprender como recibir peticiones del cliente 
 * y responderle solo usando SERVLET
 * @see HelloController2 para ver como se hace lo mismo desde SERVLET + jsp
 */
@WebServlet("/ejemplo1")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//peticion del cliente
		String userAgent = request.getHeader("User-Agent");
		String http = request.getProtocol();
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		final int TETERA = 418, UNAUTHORIZED = 401, passW = 123456;
		final String name ="admin";
		//respuesta
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		//Introducir codigo de estado http default = 200
		//@see https://es.wikipedia.org/wiki/Anexo:C%C3%B3digos_de_estado_HTTP
		PrintWriter out = response.getWriter();
		
		if(name.equals(nombre) && passW == Integer.parseInt(pass)) {
			out.println("<html lang=\"es\">");
			out.println("<head>");
			out.println("<meta charset=\"utf-8\">\r\n" );
			out.println("<title>Título del sitio</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Página principal de tuHost</h1>");
			out.println("<ol>");
			out.println("<li> Tu navegador es: " + userAgent + "</li>");
			out.println("<li> Nombre: " + nombre + "</li>");
			out.println("<li> Tu protocolo es: " + http + "</li>");
			out.println("<li> Tu direccion MAC es: " +  getMac() + "</li>");
			
		}else {
			response.setStatus(UNAUTHORIZED);
			out.println("No estas autorizado");
		}
		
		if("tetera".equals(nombre)) {
			response.setStatus(TETERA);
			out.println("Tetera");
		}
		
		
		
		if(userAgent.contains("mobile")) {
			out.println("<li> Eres movil</li>");
		}
		
		out.println("</ol>");
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		
		//por defecto response de 200
		
		
		//.append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	public static String getMac() {
		  try {
		    @SuppressWarnings("unused")
			InetAddress ip = InetAddress.getLocalHost();
		    //System.out.println("Current IP address : " + ip.getHostAddress());

		    Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
		    while(networks.hasMoreElements()) {
		      NetworkInterface network = networks.nextElement();
		      byte[] mac = network.getHardwareAddress();

		      if(mac != null) {
		        //System.out.print("Current MAC address : ");

		        StringBuilder sb = new StringBuilder();
		        for (int i = 0; i < mac.length; i++) {
		          sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		        }
		        return sb.toString();
		      }
		    }
		  } catch (UnknownHostException e) {
		    e.printStackTrace();
		  } catch (SocketException e){
		    e.printStackTrace();
		  }
		  return null;
		}
}
