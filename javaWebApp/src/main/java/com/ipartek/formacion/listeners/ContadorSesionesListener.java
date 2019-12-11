package com.ipartek.formacion.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class ContadorSesionesListener
 *
 */
@WebListener
public class ContadorSesionesListener implements HttpSessionAttributeListener {

	private final Logger LOG=Logger.getLogger(this.getClass().getName());
	private int numeroIntentosFallidos = 0;
	public void attributeAdded(HttpSessionBindingEvent event)  { 
		
		LOG.debug("attributeAdded " + event.getName() + " " + event.getValue());
		
    	if("usuarioLogeado".equals(event.getName())) {
    		//recuperar del ambito de session los usuarios y añadir el nuevo usuario
			// ServletContext == applicationScope en la JSP
			ServletContext applicationScope = event.getSession().getServletContext();
			
			//ArrayList<String> usuarios = (ArrayList<String>) applicationScope.getAttribute("usuariosConectados");
			int numeroUsuarios = (int) ((applicationScope.getAttribute("numeroUsuariosConectados")==null)? 0 : applicationScope.getAttribute("numeroUsuariosConectados"));
			numeroUsuarios++;
			applicationScope.setAttribute("numeroUsuariosConectados", numeroUsuarios);
    	}else {
    		numeroIntentosFallidos += 1; 
    	}
	    	
    }

    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	LOG.debug("attributeRemoved " + event.getName() + " " + event.getValue());
    	
    	
    	
    	if("usuarioLogeado".equals(event.getName())) {
    		//recuperar del ambito de session los usuarios y añadir el nuevo usuario
			// ServletContext == applicationScope en la JSP
			ServletContext applicationScope = event.getSession().getServletContext();
			
			//ArrayList<String> usuarios = (ArrayList<String>) applicationScope.getAttribute("usuariosConectados");
			int numeroUsuarios = (int) ((applicationScope.getAttribute("numeroUsuariosConectados")==null)? 0 : applicationScope.getAttribute("numeroUsuariosConectados"));
			numeroUsuarios--;
			applicationScope.setAttribute("numeroUsuariosConectados", numeroUsuarios);
    	}
    	
    	
		
    }

    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	LOG.debug("attributeReplaced " + event.getName() + " " + event.getValue());
		
		
    }
	
}
