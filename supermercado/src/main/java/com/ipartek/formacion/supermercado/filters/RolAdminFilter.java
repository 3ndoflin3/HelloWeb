package com.ipartek.formacion.supermercado.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.pojo.Rol;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

/**
 * Servlet Filter implementation class RolAdminFilter
 */
@WebFilter({ "/seguridad/*"})
public class RolAdminFilter implements Filter {

	private final static Logger LOG = Logger.getLogger(RolAdminFilter.class);


	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		Usuario usuarioLogeado = (Usuario) session.getAttribute("usuarioLogeado");
		
		if ( usuarioLogeado != null && usuarioLogeado.getRol().getId() == Rol.ROL_ADMIN ) {
		
			chain.doFilter(request, response);
			
		}else{
			
			LOG.warn("Acceso denegado, te invalido la sesion " + usuarioLogeado);
			session.invalidate();
			res.sendRedirect( req.getContextPath() +  "/login.jsp");
				
		}
		//chain.doFilter(request, response);
	}


}
