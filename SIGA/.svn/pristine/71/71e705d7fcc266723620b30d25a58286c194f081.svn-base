package com.meve.sigma.parametros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.parametros.ParametrosForm;

public class ParametrosDao {

	public static List getParametros(Connection conn) {
		String sql = "SELECT PARAM_DESCRIPCION, PARAM_ID,PARAM_VALOR FROM SD_PARAMETROS";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List parametros = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ParametrosForm parametro = new ParametrosForm();
				parametro.setParametroId(rs.getString("PARAM_ID"));
				parametro.setParametroDescripcion(rs.getString("PARAM_DESCRIPCION"));
				parametro.setParametroValor(rs.getString("PARAM_VALOR"));
				parametros.add(parametro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return parametros;

	}
	
	public static boolean insertaParametro(Connection conn,ParametrosForm parametro) {
		String sql = "INSERT INTO SD_PARAMETROS(PARAM_DESCRIPCION,PARAM_ID,PARAM_VALOR) VALUES(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, parametro.getParametroDescripcion());
			pstmt.setString(2, parametro.getParametroId());
			pstmt.setString(3, parametro.getParametroValor());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
		return false;

	}
	
	public static boolean modificaParametro(Connection conn,ParametrosForm parametro) {
		String sql = "UPDATE SD_PARAMETROS SET PARAM_DESCRIPCION = ?, PARAM_VALOR = ? WHERE PARAM_ID = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, parametro.getParametroDescripcion());
			pstmt.setString(2, parametro.getParametroValor());
			pstmt.setString(3, parametro.getParametroId());
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
		return false;

	}
	
	public static boolean eliminaParametro(Connection conn,String idParametro) {
		String sql = "DELETE FROM SD_PARAMETROS WHERE PARAM_ID = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idParametro);
			return pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, pstmt, null);
		}
		return false;

	}

}
