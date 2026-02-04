package com.meve.sigma.catalogos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meve.sigma.catalogos.CatalogoPrioridad;
import com.meve.sigma.db2.ConexionDS;

public class PrioridadDao {

	public static List getCatalogo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID_PRIORIDADES, PRI_NOMBRE, PRI_NUMERO_HEX, "
				+ "PRI_FEC_ACTUALIZACION, PRI_ESTATUS, PRI_AREA, PRI_USR_ACTUALIZO "
				+ " FROM SD_PRIORIDAD ";
		List catalogoPrioridad = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CatalogoPrioridad prioridad = new CatalogoPrioridad();
				prioridad.setId(rs.getInt("ID_PRIORIDADES"));
				prioridad.setNombre(rs.getString("PRI_NOMBRE"));
				prioridad.setColorHex(rs.getString("PRI_NUMERO_HEX"));
				prioridad.setFechaActualizacion(rs.getDate(
						"PRI_FEC_ACTUALIZACION").getTime());
				prioridad.setEstatus(rs.getInt("PRI_ESTATUS"));
				prioridad.setIdArea(rs.getInt("PRI_AREA"));
				prioridad.setIdUsuarioActualizo(rs.getInt("PRI_USR_ACTUALIZO"));
				catalogoPrioridad.add(prioridad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return catalogoPrioridad;
	}

}
