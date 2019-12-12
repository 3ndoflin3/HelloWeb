package com.ipartek.formacion.controller.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.omg.CORBA.Request;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/private/*" })
public class SeguridadFilter implements Filter {

	private final Logger LOG=Logger.getLogger(this.getClass().getName());
	private int numeroIntentosFallidos;
	private ServletContext applicationScope;
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.trace("Destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		LOG.debug("RequestURL" + req.getRequestURL());
		LOG.debug("RequestURI" + req.getRequestURI());
		LOG.debug("RequestURL" + req.getProtocol());
		LOG.debug("HTTP Protocol " + req.getProtocol());
		LOG.debug("HTTP RemoteAddr " + req.getRemoteAddr());
		LOG.debug("HTTP RemoteHost " + req.getRemoteHost());
		
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("usuarioLogeado") == null) {
			
			LOG.warn("Intrusion no deseada");
			
    		numeroIntentosFallidos += 1; 
    					
		}else {
			//Dejamos continuar
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.trace("init");
		numeroIntentosFallidos = 0;
		applicationScope = fConfig.getServletContext();
		applicationScope.setAttribute("numeroIntentosFallidos", numeroIntentosFallidos);

	}

}
