package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Conversor
 */
@WebServlet("/conversor")
public class ConversorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final float METROS_PIES = 0.3048f;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConversorController() {
        super();
        
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
		
		convertiraPies(request, response);
		

		//Ir a la vista
		request.getRequestDispatcher("final/jsp/conversor.jsp").forward(request, response);
	}

	
	private void convertiraPies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String meters = request.getParameter("metros");
		
		if(!isNumeric(meters) ) {
			if(meters.isEmpty()) {
				
				request.setAttribute("mensaje", "Introduce un numero por favor");
			}else {
				request.setAttribute("mensaje", "Por favor introduce numeros");
			}
			
		}else {
			float nMeters = Float.parseFloat(meters);
			float feet = (float) (nMeters / METROS_PIES);

			request.setAttribute("feet", feet);
			request.setAttribute("meters", nMeters);
			request.setAttribute("mensaje", nMeters + " en pies es " + feet);
		}
		
		
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
}
