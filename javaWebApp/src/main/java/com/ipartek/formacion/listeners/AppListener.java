package com.ipartek.formacion.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

	
	
	private final Logger LOG=Logger.getLogger(this.getClass().getName());
		
    public void contextInitialized(ServletContextEvent sce)  { 
    	LOG.info("La app se ha iniciado");
    	
    	ServletContext sc = sce.getServletContext();
    	sc.setAttribute("numeroUsuariosConectados", 0);
    	
    }
    
   
    public void contextDestroyed(ServletContextEvent sce)  { 
        LOG.info("La app se ha detenido");
    }

	
}
