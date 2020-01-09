package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.model.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Categoria;

public class CategoriaDAO implements ICategoriaDAO{
	
	private final static Logger LOG = Logger.getLogger(CategoriaDAO.class);
	private static CategoriaDAO INSTANCE;
	
	private CategoriaDAO() {
		super();
	}
	
	
	
	public static CategoriaDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Categoria> getAll() {
		LOG.trace("Recuperar todas las categorias");
		List<Categoria> registros = new ArrayList<>();

		try(Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{CALL pa_categoria_getall()}");
				){
			
			LOG.debug(cs);
			
			try(ResultSet rs = cs.executeQuery()){
				//TODO mapper 
				while(rs.next()) {
					registros.add(mapper(rs));
				}
			}
			
		}catch(Exception e) {
			LOG.error(e);
		}
		
		
		
		return registros;
	}

	@Override
	public Categoria getById(int id) throws SQLException {
		
		Categoria registro = new Categoria();
		
		try(Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{Call pa_categoria_getbyid(?)}")){
			
			cs.setInt(1, id);
			
			try(ResultSet rs = cs.executeQuery()){
				if(rs.next()) {
					registro = mapper(rs);
				}else {
					throw new SQLException("No se ha encontrado el registro");
				}
			}
			
		}
		
		return registro;
	}

	@Override
	public Categoria delete(int id) throws Exception {
		LOG.trace("Delete de una categoria");
		
		Categoria registro = getById(id);
		if(registro == null) {
			throw new Exception("No existe el registro a borrar");
		}
		
		try(Connection con = ConnectionManager.getConnection();
			CallableStatement cs = con.prepareCall("{CALL pa_categoria_delete(?)}");){
			
			cs.setInt(1, id);
			LOG.debug(cs);
			
			if(cs.executeUpdate() == 1) {
				registro.setId(id);
			}else {
				throw new Exception("Producto no encontrado");
			}
			
			LOG.debug("registro borrado ");
			
		}
		
		return registro;
	}

	@Override
	public Categoria update(int id, Categoria pojo) throws Exception {
		LOG.trace("Update de una categoria");
		Categoria registro = pojo;
		try(Connection con = ConnectionManager.getConnection();
			CallableStatement cs = con.prepareCall("{CALL pa_categoria_update(?,?)}");){
			cs.setInt(1, id);
			cs.setString(2, pojo.getNombre());
			
			LOG.debug(cs);
			
			if(cs.executeUpdate() == 1) {
				pojo.setId(id);
			}else {
				throw new Exception("Producto no encontrado");
			}
			LOG.debug("registros creados ");
			
		}
		
		return registro;
	}

	@Override
	public Categoria create(Categoria pojo) throws Exception {
		
		LOG.trace("insertar nueva categoria " + pojo );
		Categoria registro = pojo;

		try (Connection con = ConnectionManager.getConnection();
			 CallableStatement cs = con.prepareCall("{ CALL pa_categoria_insert(?,?) }");) {

			// parametro de entrada 1º?
			cs.setString(1, pojo.getNombre() );

			//registro el paremetro de salida 2º ?
			cs.registerOutParameter(2, java.sql.Types.INTEGER );

			LOG.debug(cs);

			//executamos el procedimiento almacenado executeUpdate, CUIDADO no es una SELECT => executeQuery	
			int affectedRows = cs.executeUpdate();
			LOG.debug("registros creados " + affectedRows);

			// una vez ejecutado, podemos recuperar el parametro de salida 2º ?			
			pojo.setId( cs.getInt(2) );

		}

		return registro;
	}

	
	public Categoria mapper(ResultSet rs) throws SQLException {
		Categoria c = new Categoria();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		
		return c;
		
	}
	
}
