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
	private static final String SQL_GET_BY_ID ="SELECT  id, nombre, precio, imagen, descripcion, descuento  FROM producto WHERE id = ? ;"; 
	private static final String SQL_GET_INSERT ="INSERT INTO producto ( nombre, precio, imagen, descripcion, descuento ) VALUES ( ?, ?, ?, ?, ? );";
	private static final String SQL_GET_UPDATE ="UPDATE producto SET nombre = ? WHERE id = ? ;";
	private static final String SQL_DELETE ="DELETE FROM producto WHERE id = ? ;";
	private static final String SQL_GET_ALL_BY_USER = "SELECT p.id, p.nombre, p.precio, p.imagen, p.descripcion, p.descuento, u.nombre AS usuario  FROM producto p INNER JOIN usuario u ON p.id_usuario=u.id AND p.id_usuario = ? ORDER BY id ASC LIMIT 500;";
		
	
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

	//TODO crear metodo para ver productos por usuario 
	
	public ArrayList<Producto> getByUser(Usuario usuario) {
		ArrayList<Producto> lista = new ArrayList<Producto>();

		String SQL_GET_BY_USER = "SELECT * FROM usuario u, producto p, rol r WHERE p.id_usuario = u.id AND r.id = u.id_rol AND u.id_rol = ?;";
		
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_USER);
				) {
			pst.setString(1, String.valueOf(usuario.getRol().getId()));
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
	public List<Producto> getAllByUser(int idUsuario) {
		ArrayList<Producto> lista = new ArrayList<Producto>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
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
	public Producto getByIdByUser(int idProducto, int idUsuario) throws ProductoException {
		
		return null;
	}

	@Override
	public Producto updateByUser(int idProducto, int idUsuario, Producto pojo) throws ProductoException {
		
		return null;
	}

	@Override
	public Producto deleteByUser(int idProducto) throws ProductoException {
		
		throw new ProductoException(ProductoException.EXCEPTION_UNAUTHORIZED);
		
		//return null;
	}
	
}
