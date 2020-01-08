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
					Categoria c = new Categoria();
					c.setId(rs.getInt("id"));
					c.setNombre(rs.getString("nombre"));
					registros.add(c);
				}
			}
			
		}catch(Exception e) {
			LOG.error(e);
		}
		
		
		
		return registros;
	}

	@Override
	public Categoria getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria delete(int id) throws Exception {
		LOG.trace("Delete de una categoria");
		
		try(Connection con = ConnectionManager.getConnection();
			CallableStatement cs = con.prepareCall("{CALL pa_categoria_delete(?)}");){
			
			cs.setInt(1, id);
			LOG.debug(cs);
			
			int affectedRows = cs.executeUpdate();
			
			LOG.debug("registro borrado " + affectedRows);
			
		}
		
		return null;
	}

	@Override
	public boolean update(int id, Categoria pojo) throws Exception {
		LOG.trace("Update de una categoria");
		Categoria registro = pojo;
		try(Connection con = ConnectionManager.getConnection();
			CallableStatement cs = con.prepareCall("{CALL pa_categoria_update(?,?)}");){
			cs.setString(1, pojo.getNombre());
			cs.setInt(2, id);
			
			LOG.debug(cs);
			
			int affectedRows = cs.executeUpdate();
			LOG.debug("registros creados " + affectedRows);
			
		}
		
		return false;
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

}
