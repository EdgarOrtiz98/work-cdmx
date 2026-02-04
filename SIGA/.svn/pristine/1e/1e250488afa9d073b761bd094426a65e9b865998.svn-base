package com.meve.sigma.catalogos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.catalogos.CatalogoArea;
import com.meve.sigma.catalogos.CatalogoEntidad;
import com.meve.sigma.catalogos.CatalogoRemitente;
import com.meve.sigma.db2.ConexionDS;

public class CatalogoDao {

	private static final String SQL_ENTIDADES_INTERNAS = "SELECT ID_AREA, ARE_NOMBRE, "
			+ "ARE_BANDERA "
			+ "FROM SD_AREA WHERE ID_AREA <> 0 AND ARE_ESTATUS=1 ";

	private static final String SQL_ENTIDADES_EXTERNAS = "SELECT ID_ENTIDAD, ENT_NOMBRE  "
			+ "FROM SD_ENTIDAD WHERE (ENT_AREA=? OR ENT_AREA=0)"
			+ "AND ENT_ESTATUS=1";

	public static List getEntidadesInternas(Connection conn,
			String cadenaBusqueda, String campoOrd, String asc) {

		String sql = SQL_ENTIDADES_INTERNAS;
		sql += "AND LOWER(ARE_NOMBRE) LIKE LOWER('%" + cadenaBusqueda + "%') ";
		if (campoOrd.equals("1")) {
			sql += "ORDER BY LOWER(ARE_NOMBRE) " + asc + " ";
		} else if (campoOrd.equals("2")) {
			sql += "ORDER BY LOWER(ARE_BANDERA) " + asc + "";
		}
		System.out.println("SQSL: " + sql);
		List areas = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CatalogoArea ca = new CatalogoArea();
				ca.setId(rs.getInt("ID_AREA"));
				ca.setNombre(rs.getString("ARE_NOMBRE"));
				ca.setActiva(rs.getInt("ARE_BANDERA") == 0);
				areas.add(ca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return areas;

	}

	public static List getEntidadesExternas(Connection conn,
			String cadenaBusqueda, String campoOrd, String asc, int idArea) {

		String sql = SQL_ENTIDADES_EXTERNAS;
		sql += "AND ENT_ESTATUS=1 AND LOWER(ENT_NOMBRE) LIKE LOWER('%"
				+ cadenaBusqueda + "%') ";
		sql += "ORDER BY 2 " + asc + " ";
		System.out.println("SQSL: " + sql);
		System.out.println("idArea: " + idArea);
		List entidades = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idArea);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CatalogoEntidad ce = new CatalogoEntidad();
				ce.setId(rs.getInt("ID_ENTIDAD"));
				ce.setNombre(rs.getString("ENT_NOMBRE"));
				ce.setActiva(true);
				entidades.add(ce);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return entidades;

	}
	
	public static CatalogoArea getArea(Connection conn,int idArea) {

		String sql = SQL_ENTIDADES_INTERNAS;
		sql += " AND ID_AREA = ?";
		System.out.println("SQSL: " + sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CatalogoArea ca = new CatalogoArea();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idArea);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ca.setId(rs.getInt("ID_AREA"));
				ca.setNombre(rs.getString("ARE_NOMBRE"));
				ca.setActiva(rs.getInt("ARE_BANDERA") == 0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return ca;
	}
	
	public static CatalogoEntidad getEntidad(Connection conn,int idEntidad) {

		String sql = "SELECT ID_ENTIDAD, ENT_NOMBRE  "
		+ "FROM SD_ENTIDAD WHERE ID_ENTIDAD = ? ";
		
		System.out.println("SQSL: " + sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CatalogoEntidad ce = new CatalogoEntidad();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idEntidad);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ce.setId(rs.getInt("ID_ENTIDAD"));
				ce.setNombre(rs.getString("ENT_NOMBRE"));
				ce.setActiva(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return ce;

	}
	
	public static List getEntidadesPorArea(Connection conn,int idArea) {

		String sql = "SELECT ID_ENTIDAD, ENT_NOMBRE  "
		+ "FROM SD_ENTIDAD WHERE ENT_AREA = ? ";
		
		System.out.println("SQSL: " + sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List entidades = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idArea);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CatalogoEntidad ce = new CatalogoEntidad();
				ce.setId(rs.getInt("ID_ENTIDAD"));
				ce.setNombre(rs.getString("ENT_NOMBRE"));
				ce.setActiva(true);
				entidades.add(ce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return entidades;

	}
	
	public static boolean insertaEntidad(Connection conn, CatalogoEntidad ce, UsuarioBean ub){
		String sql = "INSERT INTO SD_ENTIDAD (ID_ENTIDAD, ENT_NOMBRE, ENT_AREA, " +
				      "ENT_CLASIFICACION, ENT_DIRECCION, ENT_TELEFONO, " +
		              "ENT_FEC_ACTUALIZACION, ENT_USR_ACTUALIZO, ENT_ESTATUS) " +
		              " VALUES (SD_ENTIDAD_SEQ.NEXTVAL,?,?,?, ?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ce.getNombre());
			pstmt.setInt(2, ce.getArea());
			pstmt.setString(3, ce.getClasificacion());
			pstmt.setString(4, ce.getDireccion());
			pstmt.setString(5, String.valueOf(ce.getTelefono()));
			pstmt.setDate(6, new java.sql.Date(new Date().getTime()));
			pstmt.setInt(7, Integer.parseInt(ub.getIdUsuario()));
			pstmt.setInt(8, 1);
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			ConexionDS.endConnection(null, pstmt, null);
		}
		return false;
	}
	
	public static List getRemitentesInternos(Connection conn, int idArea, String buscaPuesto, String buscaResponsable){
		String sql = "SELECT ID_USUARIO, USU_NOMBRE, USU_CARGO, USU_CORREO " +
        		"FROM SD_USUARIO WHERE USU_AREA= ? " +
        		"AND LOWER(USU_CARGO) LIKE LOWER('%"+buscaResponsable+"%') " +
        		"AND LOWER(USU_NOMBRE) LIKE LOWER('%"+buscaPuesto+"%') " +
        		"AND USU_ESTATUS=1 " +
        		"ORDER BY 2";
		System.out.println(sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List remitentes = new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idArea);
			rs = pstmt.executeQuery();
			while(rs.next()){
				UsuarioBean usuario = new UsuarioBean();
				usuario.setStrIdUsuario(rs.getString("ID_USUARIO"));
				usuario.setStrNombre(rs.getString("USU_CARGO"));
				usuario.setStrCargo(rs.getString("USU_NOMBRE"));
				usuario.setStrCorreo(rs.getString("USU_CORREO"));
				remitentes.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return remitentes;
	}
	
	public static List getRemitentesExternos(Connection conn, int idArea, String buscaPuesto, String buscaResponsable){
		String sql = "SELECT ID_REMITENTE, RMT_NOMBRE, RMT_CARGO, RMT_CORREO " +
 		"FROM SD_REMITENTE WHERE RMT_ENTIDAD= ? " +
 		"AND LOWER(RMT_CARGO) LIKE LOWER('%"+buscaPuesto+"%') " +
 		"AND LOWER(RMT_NOMBRE) LIKE LOWER('%"+buscaResponsable+"%') " +
 		"AND RMT_ESTATUS=1 ORDER BY RMT_NOMBRE ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List remitentes = new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idArea);
			rs = pstmt.executeQuery();
			while(rs.next()){
				UsuarioBean usuario = new UsuarioBean();
				usuario.setStrIdUsuario(rs.getString("ID_REMITENTE"));
				usuario.setStrNombre(rs.getString("RMT_CARGO"));
				usuario.setStrCargo(rs.getString("RMT_NOMBRE"));
				usuario.setStrCorreo(rs.getString("RMT_CORREO"));
				remitentes.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return remitentes;
	}
	
	public static UsuarioBean getRemitenteInterno(Connection conn, int idUsuario){
		String sql = "SELECT ID_USUARIO, USU_NOMBRE, USU_CARGO, USU_CORREO " +
        		"FROM SD_USUARIO WHERE ID_USUARIO= ? ";
		System.out.println(sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UsuarioBean usuario = new UsuarioBean();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			rs = pstmt.executeQuery();
			while(rs.next()){
				usuario.setStrIdUsuario(rs.getString("ID_USUARIO"));
				usuario.setStrNombre(rs.getString("USU_CARGO"));
				usuario.setStrCargo(rs.getString("USU_NOMBRE"));
				usuario.setStrCorreo(rs.getString("USU_CORREO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return usuario;
	}
	
	public static UsuarioBean getRemitenteExterno(Connection conn, int idRemitente){
		String sql = "SELECT ID_REMITENTE, RMT_NOMBRE, RMT_CARGO, RMT_CORREO " +
 		"FROM SD_REMITENTE WHERE ID_REMITENTE = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UsuarioBean usuario = new UsuarioBean();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idRemitente);
			rs = pstmt.executeQuery();
			while(rs.next()){
				usuario.setStrIdUsuario(rs.getString("ID_REMITENTE"));
				usuario.setStrNombre(rs.getString("RMT_CARGO"));
				usuario.setStrCargo(rs.getString("RMT_NOMBRE"));
				usuario.setStrCorreo(rs.getString("RMT_CORREO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return usuario;
	}

	
	public static boolean insertaRemitente(Connection conn, CatalogoRemitente cr, UsuarioBean ub){
		  String sql =	"INSERT INTO SD_REMITENTE (ID_REMITENTE, RMT_NOMBRE, RMT_AREA, RMT_CARGO, RMT_ENTIDAD," +
	        " RMT_TELEFONO, RMT_CORREO, RMT_USR_ACTUALIZO, RMT_FEC_ACTUALIZACION, RMT_ESTATUS, RMT_DIRECCION, RMT_FAX) " +
	        " VALUES (SD_REMITENTE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
		  PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cr.getNombre());
				pstmt.setInt(2, cr.getIdArea());
				pstmt.setString(3, cr.getCargo());
				pstmt.setInt(4, cr.getIdEntidad());
				pstmt.setString(5,cr.getTelefono());
				pstmt.setString(6, cr.getCorreo());
				pstmt.setInt(7, Integer.parseInt(ub.getIdUsuario()));
				pstmt.setDate(8, new java.sql.Date(new Date().getTime()));
				pstmt.setInt(9, 1);
				pstmt.setString(10, cr.getDireccion());
				pstmt.setString(11, cr.getFax());
				return pstmt.executeUpdate()>0;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				ConexionDS.endConnection(null, pstmt, null);
			}
		return false;
	}
}
