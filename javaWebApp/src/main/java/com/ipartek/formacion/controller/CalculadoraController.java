package com.ipartek.formacion.controller;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraController
 */
@WebServlet("/sumar")
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculadoraController() {
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
	 * @RequestMapping(value = "sumar", method=RequestMethod.POST)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		calcular(request.getParameter("op"), request, response);	
	
		
	
		//Ir a la vista
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	
	}
	
	private void calcular(String operacion, HttpServletRequest request, HttpServletResponse response) {
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int n1 = Integer.parseInt( num1) ;
		int n2 = Integer.parseInt( num2);
		int resultado  = 0;
		
		
		switch(operacion) {
			case "1":
				try{
					resultado =  n1 + n2;
					request.setAttribute("simbolo", "+");
				}catch (NumberFormatException nfe) {
					nfe.getMessage();
				}
				break;
				
			case "2":
				try{
					resultado =  n1 - n2;
					request.setAttribute("simbolo", "-");
				}catch (NumberFormatException nfe) {
					nfe.getMessage();
				}
				break;
				
			case "3": 
				try{
					resultado =  n1 * n2;
					request.setAttribute("simbolo", "*");
				}catch (NumberFormatException nfe) {
					nfe.getMessage();
				}
				break;
				
				
			case "4": 
				try{
					resultado =  n1 / n2;
					request.setAttribute("simbolo", "/");
				}catch (NumberFormatException nfe) {
					nfe.getMessage();
				}
				break;
				
				
				
		}
		
				//Enviar el atributo (se puede mas de uno repitiendo la llamada al metodo)
				request.setAttribute("num1", num1);
				request.setAttribute("num2", num2);
				request.setAttribute("resultado", resultado);
	}
	
	
 
}
