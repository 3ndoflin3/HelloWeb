package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.jboss.logging.Logger;

import com.ipartek.formacion.supermercado.modelo.dao.UsuarioDAO;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private final static Logger LOG = Logger.getLogger(LoginController.class);

	private static final long serialVersionUID = 1L;
    private static UsuarioDAO usuarioDao = UsuarioDAO.getInstance();   
	private static final String VIEW_TABLA = "seguridad/usuarios/index.jsp";
	private static final String VIEW_FORM = "seguridad/usuarios/formulario.jsp";
    private static String vistaSeleccionada = VIEW_TABLA;
  
    //acciones
  	public static final String ACCION_LISTAR = "listar";
  	public static final String ACCION_EDITAR = "editar";
  	public static final String ACCION_GUARDAR = "guardar";   // crear y modificar
  	public static final String ACCION_ELIMINAR = "eliminar";
  	public static final String ACCION_LOGIN = "login";
  	
  	//Variables del POJO
  	private String nombre;
  	private String contrasenia;
  	private String pAccion;
  	private String id;

	//Crear Factoria y Validador
	 ValidatorFactory factory ;
	 Validator validator;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		id= request.getParameter("id");
		nombre = request.getParameter("nombre");
		contrasenia = request.getParameter("contrasenia");
		pAccion = request.getParameter("accion");
		int []rol = {1,2};
		request.getSession().setAttribute("rol", rol );
		try {
			
			switch (pAccion) {
			case ACCION_LISTAR:
				listar(request, response);
				break;
			case ACCION_ELIMINAR:	
				eliminar(request, response);
				break;
			case ACCION_GUARDAR:	
				guardar(request, response);
				break;
			case ACCION_EDITAR:	
				irFormulario(request, response);
				break;
			case ACCION_LOGIN:
				login(request, response);
				break;
			default:
				listar(request, response);
				break;
			
			}
			
		}catch (Exception e) {
			LOG.error(e);
			
		}finally {
			
			request.getRequestDispatcher(vistaSeleccionada).forward(request, response);
		}	
		
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = usuarioDao.existe(nombre, contrasenia);
		
		
		if(usuario !=null) { //si es null no existe
		switch(usuario.getRol().getId()){
		
		case 1: //ADMIN
			LOG.info("login admin correcto " + usuario);
			HttpSession sesionAdmin = request.getSession();
			sesionAdmin.setAttribute("usuarioLogeado", usuario);
			sesionAdmin.setMaxInactiveInterval(60*3); // 3min
			
			vistaSeleccionada = "seguridad/index.jsp";
			break;
			
		case 2: //USUARIO
			LOG.info("login usuario correcto " + usuario);
			HttpSession sesionUsuario = request.getSession();
			sesionUsuario.setAttribute("usuarioLogeado", usuario);
			sesionUsuario.setMaxInactiveInterval(60*3); // 3min
			vistaSeleccionada = "mipanel/index.jsp";
			break;
			
		default: //CUALQUIER OTRO || MENSAJE DIFERENTE AL CASO 3
			request.setAttribute("mensajeAlerta", new Alerta( Alerta.TIPO_DANGER, "Credenciales incorrectas, intentalo de nuevo"));
			vistaSeleccionada = "login.jsp";
			break;
		}
	
		 /**************************************************************************************************************************** 
		 * CATCH CON UN IF EN CASO DE QUE EL USUARIO QUE RECIBA SEA NULL															 *
		 *  @see above 																												 *
		 *  																														 *
		 ****************************************************************************************************************************/
		}
	}

	private void irFormulario(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuarioEditar = new Usuario();
		
		if(id!=null) {
			int pId = Integer.parseInt(id);
			usuarioEditar = usuarioDao.getById(pId);
		}
		
		request.setAttribute("usuario", usuarioEditar );
		vistaSeleccionada = VIEW_FORM;
		
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		int pId = Integer.parseInt(id);
		Usuario uGuardar = new Usuario();		
		uGuardar.setId(pId);
		uGuardar.setNombre(nombre);
		uGuardar.setContrasenia(contrasenia);
		
			try {
				
				if ( pId > 0 ) {  // modificar
					
					usuarioDao.update(pId, uGuardar);		
					
				}else {            // crear
					usuarioDao.create(uGuardar);
				}
				
			}catch (Exception e) {  // validacion a nivel de base datos
				request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO_DANGER, "El nombre ya existe, selecciona otro"));
			}	
			
		
		
		request.setAttribute("productos", uGuardar);
		vistaSeleccionada = VIEW_FORM;
		
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			int pId = Integer.parseInt(id);
			Usuario usuarioEliminado = usuarioDao.delete(pId);
			request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO_PRIMARY, "Eliminado " + usuarioEliminado.getNombre() ));
		}catch (MySQLIntegrityConstraintViolationException ex) {
			LOG.warn("No se puede borrar debido a que provoca la violacion de una restriccion");
			request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO_DANGER, "No se puede Eliminar el producto debido a una restriccion"));
		} catch (Exception e) {
			request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO_DANGER, "No se puede Eliminar el producto"));
			
		}
		
		listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("usuarios", usuarioDao.getAll());
		vistaSeleccionada = VIEW_TABLA;
	}

}
