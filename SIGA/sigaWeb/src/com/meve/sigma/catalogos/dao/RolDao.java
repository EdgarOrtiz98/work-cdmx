package com.meve.sigma.catalogos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meve.sigma.catalogos.CatalogoPrioridad;
import com.meve.sigma.catalogos.CatalogoRol;
import com.meve.sigma.db2.ConexionDS;

public class RolDao {

	/**
	 * Obtien el catalogo de roles de la tabla sd_rol, pero actualmente no se
	 * utiliza por errores de base de datos Utilizar el metodo getCatalogo() de
	 * esta clase;
	 * 
	 * @param conn
	 * @return Lista de objetos CatalogoRol
	 */
	public static List getCatalogo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID_ROL, ROL_NOMBRE, ROL_DESCRIPCION "
				+ " FROM SD_ROL ";
		List catalogoRol = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CatalogoRol rol = new CatalogoRol();
				rol.setId(rs.getInt("ID_ROL"));
				rol.setNombre(rs.getString("ROL_NOMBRE"));
				rol.setDescripcion(rs.getString("ROL_DESCRIPCION"));
				catalogoRol.add(rol);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return catalogoRol;
	}

	public static List getCatalogo() {
		List catalogoRol = new ArrayList();

		CatalogoRol rolAdmin = new CatalogoRol();
		rolAdmin.setId(CatalogoRol.ROL_ADMINISTRADOR);
		rolAdmin.setNombre("Administrador");

		CatalogoRol rolAtencion = new CatalogoRol();
		rolAtencion.setId(CatalogoRol.ROL_ATENCION);
		rolAtencion.setNombre("atención");

		CatalogoRol rolSCP = new CatalogoRol();
		rolSCP.setId(CatalogoRol.ROL_SCP);
		rolSCP.setNombre("SCP");

		CatalogoRol rolRecepcion = new CatalogoRol();
		rolRecepcion.setId(CatalogoRol.ROL_RECEPCION);
		rolRecepcion.setNombre("Recepción");

		CatalogoRol rolSupervisor = new CatalogoRol();
		rolSupervisor.setId(CatalogoRol.ROL_SUPERVISOR);
		rolSupervisor.setNombre("Supervisor de área");

		CatalogoRol rolTurnador = new CatalogoRol();
		rolTurnador.setId(CatalogoRol.ROL_TURNADOR);
		rolTurnador.setNombre("Turnador");

		CatalogoRol rolAsistente = new CatalogoRol();
		rolAsistente.setId(CatalogoRol.ROL_ASISTENTE);
		rolAsistente.setNombre("Asistente");

		catalogoRol.add(rolAdmin);
		catalogoRol.add(rolAtencion);
		catalogoRol.add(rolSCP);
		catalogoRol.add(rolRecepcion);
		catalogoRol.add(rolSupervisor);
		catalogoRol.add(rolTurnador);
		catalogoRol.add(rolAsistente);

		return catalogoRol;
	}

	public static List getRoles(int idUsuario, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID_ROL, ROL_NOMBRE, ROL_DESCRIPCION "
				+ " FROM SD_ROL WHERE ID_ROL IN(SELECT ID_ROL FROM SD_USUARIO_ROL WHERE ID_USUARIO1 = ?)";
		List roles = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CatalogoRol rol = new CatalogoRol();
				rol.setId(rs.getInt("ID_ROL"));
				rol.setNombre(rs.getString("ROL_NOMBRE"));
				rol.setDescripcion(rs.getString("ROL_DESCRIPCION"));
				roles.add(rol);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return roles;
	}

}
