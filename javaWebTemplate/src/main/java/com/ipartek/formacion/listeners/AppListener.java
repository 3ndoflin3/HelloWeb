package com.ipartek.formacion.listeners;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

    private ServletContext sc;

    public void contextDestroyed(ServletContextEvent sce)  { 
       
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    
    	sc = sce.getServletContext();
    	//deportes
    	HashMap<String,String> hmDeportes = new HashMap<String, String>();
    	hmDeportes.put("1", "Surf");
    	hmDeportes.put("23", "Bodyboard");
    	hmDeportes.put("34", "Quidditch");
    	hmDeportes.put("33", "Jugger");
    	hmDeportes.put("7", "Soffing");
    	
    	Set<String> keyDeportes = hmDeportes.keySet();
    	List<String> valueDeportes = (List<String>) hmDeportes.values();
    	
    	String[] keysDeportes, valuesDeportes;
    	
    	keysDeportes = (String[]) keyDeportes.toArray();
    	valuesDeportes = (String[]) valueDeportes.toArray();  
    	
    	
    	sc.setAttribute("keyDeportes", keysDeportes);
    	sc.setAttribute("valuesDeportes", valuesDeportes);
    }
	
}
