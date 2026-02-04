package com.meve.sigma.catalogos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meve.sigma.catalogos.CatalogoPrioridad;
import com.meve.sigma.catalogos.CatalogoTipoAsunto;
import com.meve.sigma.db2.ConexionDS;

public class TipoAsuntoDao {

	public static List getCatalogo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID_TIPO_ASUNTO, TIP_ASU_NOMBRE, TIP_ASU_AREA, "
				+ "TIP_ASU_FEC_ACTUALIZACION, TIP_ASU_ESTATUS, TIP_ASU_USR_ACTUALIZO "
				+ " FROM SD_TIPO_ASUNTO ";
		List catalogoTipoAsunto = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CatalogoTipoAsunto tipoAsunto = new CatalogoTipoAsunto();
				tipoAsunto.setId(rs.getInt("ID_TIPO_ASUNTO"));
				tipoAsunto.setNombre(rs.getString("TIP_ASU_NOMBRE"));
				tipoAsunto.setFechaActualizacion(rs.getDate(
						"TIP_ASU_FEC_ACTUALIZACION").getTime());
				tipoAsunto.setEstatus(rs.getInt("TIP_ASU_ESTATUS"));
				tipoAsunto.setIdArea(rs.getInt("TIP_ASU_AREA"));
				tipoAsunto.setIdUsuarioActualizo(rs.getInt("TIP_ASU_USR_ACTUALIZO"));
				catalogoTipoAsunto.add(tipoAsunto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return catalogoTipoAsunto;
	}

}
