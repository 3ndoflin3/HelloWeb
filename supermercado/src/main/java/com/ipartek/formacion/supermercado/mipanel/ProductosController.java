package com.ipartek.formacion.supermercado.mipanel;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.controller.Alerta;
import com.ipartek.formacion.supermercado.filters.RolUsuarioFilter;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoDAO;
import com.ipartek.formacion.supermercado.modelo.dao.ProductoException;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

/**
 * Servlet implementation class ProductosController
 */
@WebServlet("/mipanel/productos")
public class ProductosController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW_TABLA = "productos/index.jsp";
	private static final String VIEW_FORM = "productos/formulario.jsp";
	private static String vistaSeleccionda = VIEW_TABLA;
	private static ProductoDAO dao;
	private final static Logger LOG = Logger.getLogger(ProductosController.class);

	//acciones
	public static final String ACCION_LISTAR = "listar";
	public static final String ACCION_IR_FORMULARIO = "formulario";
	public static final String ACCION_GUARDAR = "guardar";   // crear y modificar
	public static final String ACCION_ELIMINAR = "eliminar";
	private boolean isRedirect;
	
	//Crear Factoria y Validador
	 ValidatorFactory factory ;
	 Validator validator;



	
	//parametros
	String pAccion;	
	String pId;
	String pNombre;
	String pPrecio;
	String pImagen;
	String pDescripcion;
	String pDescuento;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		dao = ProductoDAO.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
      
	@Override
	public void destroy() {	
		super.destroy();
		dao = null;
		factory = null;
		validator = null;
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			isRedirect = false;
			//recoger parametros
			pAccion = request.getParameter("accion");
			pId = request.getParameter("id");
			pNombre = request.getParameter("nombre");
			pPrecio = request.getParameter("precio");
			pImagen = request.getParameter("imagen");
			pDescripcion = request.getParameter("descripcion");
			pDescuento = request.getParameter("descuento");
			
			
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
				case ACCION_IR_FORMULARIO:	
					irFormulario(request, response);
					break;
				default:
					listar(request, response);
					break;
				}
				/** @SuppressWarnings("unreachable") */
			}catch (ProductoException ex) {
				// TODO log
				ex.printStackTrace();
				
			}catch (Exception e) {
				// TODO log
				e.printStackTrace();
				
			}finally {
				
				request.getRequestDispatcher(vistaSeleccionda).forward(request, response);
			}
			
			
		
		
	}


	private void irFormulario(HttpServletRequest request, HttpServletResponse response) {
		
		Producto pEditar = new Producto();
		
		if ( pId != null ) {
			
			int id = Integer.parseInt(pId);
			pEditar = dao.getById(id);
			
		}
		
		
		request.setAttribute("producto", pEditar );
		vistaSeleccionda = VIEW_FORM;
		
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		
		
		int id = Integer.parseInt(pId);
		Producto pGuardar = new Producto();		
		pGuardar.setId(id);
		pGuardar.setNombre(pNombre);
//		pGuardar.setPrecio(Float.parseFloat(pPrecio));
//		pGuardar.setImagen(pImagen);
//		pGuardar.setDescripcion(pDescripcion);
		pGuardar.setDescuento(Integer.parseInt(pDescuento));
		
		Set<ConstraintViolation<Producto>> validaciones = validator.validate(pGuardar);
		if(validaciones.size() >0) {

			StringBuilder mensaje = new StringBuilder();
			for (ConstraintViolation<Producto> cv : validaciones) {
				
				mensaje.append("<p>");
				mensaje.append(cv.getPropertyPath()).append(":");
				mensaje.append(cv.getMessage());				
				mensaje.append("</p>");
			}
			request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO_DANGER, mensaje.toString()));
					
			
		}else {  // validacion de campos del formulario incorrectos
			try {
				Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogeado");
				Producto comparar = dao.getByIdByUser(user.getId(), pGuardar.getId());
				if(comparar != null) {
					if ( id > 0 ) {  // modificar
						
						dao.update(id, pGuardar);		
						
					}else {            // crear
						dao.create(pGuardar);
					}
				}else {
					throw new ProductoException("El usuario no es dueño del producto");
				}
				
				
			}catch (Exception e) {  // validacion a nivel de base datos
				request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO_DANGER, "El nombre ya existe, selecciona otro"));
			}	
			
		}
		
		request.setAttribute("productos", pGuardar);
		vistaSeleccionda = VIEW_FORM;
		
		
		
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogeado");
		int id = Integer.parseInt(pId);
		try {
			Producto pEliminado = dao.deleteByUser(id, user.getId());
			request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO_PRIMARY, "Eliminado " + pEliminado.getNombre() ));
		} catch (Exception e) {
			request.setAttribute("mensajeAlerta", new Alerta(Alerta.TIPO_DANGER, "No se puede Eliminar el producto"));
			
		}
		
		listar(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogeado");
		request.setAttribute("productos", dao.getAllByUser(user.getId()) );
		vistaSeleccionda = VIEW_TABLA;
		
	}
	
	

}
