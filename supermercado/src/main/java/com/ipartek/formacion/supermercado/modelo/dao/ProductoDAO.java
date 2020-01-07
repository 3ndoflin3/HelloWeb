package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.supermercado.model.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

public class ProductoDAO implements IProductoDAO{
	
	private static ProductoDAO INSTANCE;

	/*JOIN QUERT SYNTAX: ****** SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
	FROM Orders
	INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;*/
	private static final String SQL_GET_ALL = "SELECT p.id, p.nombre, p.precio, p.imagen, p.descripcion, p.descuento, u.nombre AS usuario  FROM producto p INNER JOIN usuario u ON p.id_usuario=u.id ORDER BY id ASC LIMIT 500;";
	private static final String SQL_GET_BY_ID ="SELECT  id, nombre, precio, imagen, descripcion, descuento, id_usuario FROM producto WHERE id = ? ;"; 
	private static final String SQL_GET_INSERT ="INSERT INTO producto ( nombre, precio, imagen, descripcion, descuento ) VALUES ( ?, ?, ?, ?, ? );";
	private static final String SQL_GET_UPDATE ="UPDATE producto SET nombre = ? WHERE id = ? ;";
	private static final String SQL_DELETE ="DELETE FROM producto WHERE id = ? ;";
	//CRUD BY USER
	private static final String SQL_GET_ALL_BY_USER = "SELECT p.id, p.nombre, p.precio, p.imagen, p.descripcion, p.descuento, u.nombre AS usuario  FROM producto p INNER JOIN usuario u ON p.id_usuario=u.id AND p.id_usuario = ? ORDER BY id ASC LIMIT 500;";
	private static final String SQL_GET_ALL_BY_ID_USER = "SELECT p.id, p.nombre, p.precio, p.imagen, p.descripcion, p.descuento, u.nombre AS usuario  FROM producto p INNER JOIN usuario u ON p.id_usuario=u.id AND p.id_usuario = ? AND p.id = ? ORDER BY id ASC LIMIT 500;";
	private static final String SQL_GET_UPDATE_BY_USER ="UPDATE producto SET nombre = ? WHERE id = ? AND id_usuario = ?;";
	private static final String SQL_DELETE_BY_USER ="DELETE FROM producto WHERE id = ? AND id_usuario = ?;";
		
	
	private ProductoDAO() {		
		super();			
	}
	
	public static synchronized ProductoDAO getInstance() {
		
		if ( INSTANCE == null ) {
			INSTANCE = new ProductoDAO(); 
		}
		
		return INSTANCE;
	}
	
	

	@Override
	public List<Producto> getAll() {		
		
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				
				Producto p = new Producto();
				p.setId( rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getFloat("precio"));
				//p.setImagen(rs.getString("imagen"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setDescuento(rs.getInt("descuento"));
				
				//Crear usuario del producto ************ Solo visualizar el nombre
				Usuario user = new Usuario();
				//user.setId( rs.getInt("id"));
				user.setNombre(rs.getString("usuario"));
				//user.setContrasenia(rs.getString("constrasenia"));
				p.setUsuario(user);
				
				lista.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Producto getById(int id) {
		
		Producto registro = null;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);
				) {
			
			// sustituyo parametros en la SQL, en este caso 1º ? por id			
			pst.setInt(1, id);
			
			//ejecuto la consulta
			try( ResultSet rs = pst.executeQuery() ){

				while (rs.next()) {
					
					registro = new Producto();
					registro.setId( rs.getInt("id"));
					registro.setNombre(rs.getString("nombre"));
					registro.getUsuario().setId(rs.getInt("id_usuario"));;	
				}
			}	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return registro;
	}

	@Override
	public Producto delete(int id) throws Exception {
		
		Producto registro = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {

			pst.setInt(1, id);			
			
			registro = this.getById(id); //recuperar
			
			
			int affectedRows = pst.executeUpdate();  //eliminar
			if (affectedRows != 1) {
				registro = null;
				throw new Exception("No se puede eliminar " + registro);
			}

		}
		return registro;
	}

	@Override
	public boolean update(int id, Producto pojo) throws Exception {
		boolean resultado = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, id);
			
			int affectedRows = pst.executeUpdate();  // lanza una excepcion si nombre repetido
			if (affectedRows == 1) {
				pojo.setId(id);				
			}else {
				throw new Exception("No se encontro registro para id=" + id);
			}

		}
		return resultado;
	}

	@Override
	public Producto create(Producto pojo) throws Exception {
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement( SQL_GET_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());			
			pst.setFloat(2, pojo.getPrecio());
			pst.setString(3, pojo.getImagen());
			pst.setString(4, pojo.getDescripcion());
			pst.setInt(5, pojo.getDescuento());
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// conseguimos el ID que acabamos de crear
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					pojo.setId(rs.getInt(1));
				}

			}

		}

		return pojo;
	}


	@Override
	public List<Producto> getAllByUser(int idUsuario) {
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_USER);
				) {
			pst.setInt(1, idUsuario);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				Producto p = new Producto();
				p.setId( rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getFloat("precio"));
				//p.setImagen(rs.getString("imagen"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setDescuento(rs.getInt("descuento"));
				
				//Crear usuario del producto ************ Solo visualizar el nombre
				Usuario user = new Usuario();
				//user.setId( rs.getInt("id"));
				user.setNombre(rs.getString("usuario"));
				//user.setContrasenia(rs.getString("constrasenia"));
				p.setUsuario(user);
				
				lista.add(p);

			}
		rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Producto getByIdByUser(int idUsuario, int idProducto) throws ProductoException {
		Producto p = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				) {
			pst.setInt(1, idUsuario);
			pst.setInt(2, idProducto);
			ResultSet rs = pst.executeQuery();
				if(rs.next()) {
				
				p = new Producto();
				p.setId( rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getFloat("precio"));
				//p.setImagen(rs.getString("imagen"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setDescuento(rs.getInt("descuento"));
				
				//Crear usuario del producto ************ Solo visualizar el nombre
				Usuario user = new Usuario();
				user.setNombre(rs.getString("usuario"));
				p.setUsuario(user);
			}else {
				throw new ProductoException("Producto no encontrado por tu usuario");
			}
		rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Producto updateByUser(int idProducto, int idUsuario, Producto pojo) throws ProductoException {
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_UPDATE_BY_USER)) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, idProducto);
			pst.setInt(3, idUsuario);
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				pojo.setId(idProducto);				
			}else {
				throw new ProductoException("No se encontro registro para id=" + idProducto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProductoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pojo;
	}

	@Override
	public Producto deleteByUser(int idProducto, int idUsuario) throws ProductoException {
		
		
		Producto registro = null;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_BY_USER)) {

			pst.setInt(1, idProducto);			
			pst.setInt(2, idUsuario);			
			
			registro = this.getByIdByUser(idUsuario, idProducto); //recuperar
			
			
			int affectedRows = pst.executeUpdate();  //eliminar
			if (affectedRows == 1) {
				registro = null; // Eliminado con exito
			}else {
				throw new ProductoException(ProductoException.EXCEPTION_UNAUTHORIZED + " no se puede eliminar el producto");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registro;
		
		
		//return null;
	}
	
}
