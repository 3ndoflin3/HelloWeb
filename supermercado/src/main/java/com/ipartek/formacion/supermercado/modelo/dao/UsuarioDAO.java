package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jboss.logging.Logger;

import com.ipartek.formacion.supermercado.model.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Rol;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

	private final static Logger LOG = Logger.getLogger(UsuarioDAO.class);
	private static UsuarioDAO INSTANCE = null;

	private static final String SQL_GET_ALL = "SELECT id, nombre, contrasenia  FROM usuario ORDER BY id DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre, contrasenia FROM usuario WHERE u.id = ?;";
	private static final String SQL_GET_ALL_BY_NOMBRE = "SELECT u.id, u.nombre, contrasenia FROM usuario  WHERE nombre LIKE ? ORDER BY u.nombre ASC LIMIT 500;";
	private static final String SQL_EXISTE = " SELECT id, nombre, contrasenia from usuario where nombre = ? and contrasenia = ?;";
	private static final String SQL_INSERT = "INSERT INTO usuario ( nombre, contrasenia) VALUES ( ? , ?);";
	private static final String SQL_UPDATE = "UPDATE usuario SET nombre= ?, contrasenia= ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
	private static final String SQL_DELETE_LOGICO = "UPDATE usuario SET fecha_eliminacion = CURRENT_TIMESTAMP() WHERE id = ?;";

	private UsuarioDAO() {
		super();
	}

	public static synchronized UsuarioDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

		return INSTANCE;

	}

	/**
	 * Compruab si existe el usuario en la base datos, lo busca por su nombre y
	 * conetrsenya
	 * 
	 * @param nombre
	 * @param contrasenya
	 * @return Usuario con datos si existe, null en caso de no existir
	 */
	@SuppressWarnings("null")
	@Override
	public Usuario existe(String nombre, String contrasenia) {

		Usuario usuario = null;

		LOG.debug("nombre =" + nombre + " contrasenia= " + contrasenia);

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_EXISTE);) {

			// sustituir ? por parametros
			pst.setString(1, nombre);
			pst.setString(2, contrasenia);

			LOG.debug(pst);
	
				// ejecutar sentencia SQL y obtener Resultado
				try (ResultSet rs = pst.executeQuery()) {
	
					if (rs.next()) {
						usuario = mapper(rs);
					}
				}
				
		} catch (SQLException e) {
			LOG.error(e);
		}

		return usuario;
	}

	@Override
	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {
			LOG.debug(pst);

			while (rs.next()) {
				/*
				 * Usuario u = new Usuario(); u.setId(rs.getInt("id"));
				 * u.setNombre(rs.getString("nombre"));
				 * u.setContrasenya(rs.getString("contrasenya")); lista.add(u);
				 */
				lista.add(mapper(rs));

			}

		} catch (SQLException e) {
			LOG.error(e);
		}

		return lista;
	}

	@Override
	public Usuario getById(int id) {
		Usuario resul = new Usuario();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID)) {

			pst.setInt(1, id);
			LOG.debug(pst);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					resul = mapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return resul;
	}

	public boolean update(int id, Usuario pojo) throws Exception {
		boolean resultado = false;
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			LOG.debug(pst);
			
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenia());
			pst.setInt(3, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resultado = true;
			}

		}
		return resultado;
	}

	@Override
	public Usuario create(Usuario pojo) throws Exception {

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenia());

			LOG.debug(pst);
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				// conseguimos el ID que acabamos de crear
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					pojo.setId(rs.getInt(1));
				}

			}

		}catch(SQLException e) {
			LOG.error(e);
		}

		return pojo;
	}

	private Usuario mapper(ResultSet rs) throws SQLException {

		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setContrasenia(String.valueOf(rs.getInt("contrasenia")));
		return u;
	}

	@Override
	public Usuario delete(int id) throws Exception {
		Usuario resul = new Usuario();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {

			pst.setInt(1, id);

			pst.executeUpdate();

		}catch(SQLException e) {
			LOG.error(e);
		}
		return resul;
	}

}
