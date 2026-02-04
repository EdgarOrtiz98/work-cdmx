package com.meve.sigma.catalogos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meve.sigma.catalogos.CatalogoTramite;
import com.meve.sigma.db2.ConexionDS;

public class TramiteDao {

	public static List getCatalogo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID_TRAMITE, TRA_NOMBRE, TRA_CLAVE,TRA_DESCRIPCION, TRA_TIEMPO, "
				+ "TRA_FECHA_CREACION, TRA_FECHA_ACTUALIZACION, TRA_ESTATUS, TRA_AREA, TRA_USR_ACTUALIZO "
				+ " FROM SD_TRAMITE ";
		List catalogoTramite = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CatalogoTramite tramite = new CatalogoTramite();
				tramite.setId(rs.getInt("ID_TRAMITE"));
				tramite.setNombre(rs.getString("TRA_NOMBRE"));
				tramite.setClave(rs.getString("TRA_CLAVE"));
				tramite.setDescripcion(rs.getString("TRA_DESCRIPCION"));
				tramite.setTiempo(rs.getString("TRA_TIEMPO"));
				tramite.setFechaCreacion(rs.getDate("TRA_FECHA_CREACION")
						.getTime());
				tramite.setFechaActualizacion(rs.getDate(
						"TRA_FECHA_ACTUALIZACION").getTime());
				tramite.setEstatus(rs.getInt("TRA_ESTATUS"));
				tramite.setIdArea(rs.getInt("TRA_AREA"));
				tramite.setIdUsuarioActualizo(rs.getInt("TRA_USR_ACTUALIZO"));
				catalogoTramite.add(tramite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return catalogoTramite;
	}

}
