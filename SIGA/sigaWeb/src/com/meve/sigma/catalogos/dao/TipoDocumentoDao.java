package com.meve.sigma.catalogos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meve.sigma.catalogos.CatalogoTipoDocumento;
import com.meve.sigma.db2.ConexionDS;

public class TipoDocumentoDao {

	public static List getCatalogo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID_TIPO_DOCTO, TIP_DOCTO_NOMBRE, TIP_DOCTO_CLAVE_DOCTO ,TIP_DOCTO_AREA, "
				+ "TIP_DOCTO_FEC_ACTUALIZACION, TIP_DOCTO_ESTATUS, TIP_DOCTO_USR_ACTUALIZO, TIP_DOCTO_CONSECUTIVO "
				+ " FROM SD_TIPO_DOCUMENTO ";
		List catalogoTipoDocumento = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CatalogoTipoDocumento tipoDocumento = new CatalogoTipoDocumento();
				tipoDocumento.setId(rs.getInt("ID_TIPO_DOCTO"));
				tipoDocumento.setNombre(rs.getString("TIP_DOCTO_NOMBRE"));
				tipoDocumento.setClave(rs.getString("TIP_DOCTO_CLAVE_DOCTO"));
				tipoDocumento.setFechaActualizacion(rs.getDate("TIP_DOCTO_FEC_ACTUALIZACION").getTime());
				tipoDocumento.setEstatus(rs.getInt("TIP_DOCTO_ESTATUS"));
				tipoDocumento.setIdArea(rs.getInt("TIP_DOCTO_AREA"));
				tipoDocumento.setIdUsuarioActualizo(rs.getInt("TIP_DOCTO_USR_ACTUALIZO"));
				tipoDocumento.setConsecutivo(rs.getDouble("TIP_DOCTO_CONSECUTIVO"));
				catalogoTipoDocumento.add(tipoDocumento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return catalogoTipoDocumento;
	}

}
