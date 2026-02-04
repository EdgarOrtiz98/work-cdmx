package com.meve.sigma.instruccion.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.instruccion.InstruccionForm;
import com.meve.sigma.reporte.ReporteForm;
import com.meve.sigma.util.Estatus;

public class InstruccionDao {

	private static final String SELECT_INSTRUCCION = "SELECT ID_INSTRUCCION_ASUNTO,INS.ID_ASUNTO, INS_USUARIO, "
			+ "INS_INSTRUCCION, INS_INSTRUCCION_OTRO, INS_TIPO_ATENCION, INS_PASO, INS_TIEMPO, INS_ACCESO, "
			+ "INS_FOLIO_TURNADO, INS_ESTATUS, INS_AVANCE, INS_FECHA_ASIGNACION, INS_FECHA_TERMINACION,USU_CARGO, USU_NOMBRE, "
			+ "ASU_USR_TURNA, ASU_FOLIO_ENTRADA, ASU_FOLIO_INTERMEDIO,ASU_FOLIO_EXTERNO , INS_TIPO_ATENCION, ASU_DESCRIPCION ";

	public static List getReporteInstruccionDetalle(Connection conn,
			int idUsuario, ReporteForm rf) {
		List instrucciones = new ArrayList();
		StringBuffer sql = new StringBuffer(SELECT_INSTRUCCION);
		sql
				.append(",(SELECT INS_NOMBRE FROM SD_INSTRUCCION WHERE INS_INSTRUCCION = ID_INSTRUCCION)AS INSTRUCCION_NOMBRE");
		sql
				.append(",(SELECT USU_CARGO FROM SD_USUARIO WHERE ASU_USR_TURNA = ID_USUARIO)AS USR_TURNO_NOMBRE");
		sql
				.append(",(SELECT USU_NOMBRE FROM SD_USUARIO WHERE ASU_USR_TURNA = ID_USUARIO)AS USR_TURNO_CARGO");
		sql
				.append(" FROM SD_INSTRUCCION_ASUNTO INS, SD_USUARIO, SD_ASUNTO ASU "
						+ "WHERE INS.ID_ASUNTO = ASU.ID_ASUNTO AND INS_USUARIO = ID_USUARIO AND INS_BANDERA1=0 AND TO_CHAR(INS_FECHA_ASIGNACION, 'DD/MM/YYYY') BETWEEN ? AND ? ");

		if (rf.isMuestraSubordinados() && rf.getSubordinados() != null) {
			sql.append(" AND INS_USUARIO " + getIn(rf.getSubordinados()));
		} else {
			sql.append(" AND INS_USUARIO = ? ");
		}
		if (rf.getEstatus() != null) {
			sql.append(" AND INS_ESTATUS " + getIn(rf.getEstatus()));
		}
		sql.append(" ORDER BY USU_CARGO ");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setDate(1, new Date(rf.getFechaInicialLong()));
			pstmt.setDate(2, new Date(rf.getFechaFinalLong()));
			if (!rf.isMuestraSubordinados() || rf.getSubordinados() == null) {
				pstmt.setInt(3, idUsuario);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				InstruccionForm ins = new InstruccionForm(rs);
				ins.setEstatusNombre(Estatus.getInstruccionEstatus(ins
						.getEstatus()));
				ins.setInstruccionDescripcion(rs
						.getString("INSTRUCCION_NOMBRE") != null ? rs
						.getString("INSTRUCCION_NOMBRE") : rs
						.getString("INS_INSTRUCCION_OTRO"));
				instrucciones.add(ins);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instrucciones;
	}

	public static List getReporteInstruccionTotales(Connection conn,
			int idUsuario, ReporteForm rf) {
		List instrucciones = new ArrayList();
		StringBuffer sql = new StringBuffer(
				" SELECT COUNT (ID_INSTRUCCION_ASUNTO) AS NUM_INSTRUCCIONES, INS_ESTATUS, USU_CARGO ");

		sql.append(" FROM SD_INSTRUCCION_ASUNTO,SD_USUARIO  ");
		sql
				.append(" WHERE INS_USUARIO = ID_USUARIO AND INS_BANDERA1=0 AND TO_CHAR(INS_FECHA_ASIGNACION, 'DD/MM/YYYY') BETWEEN ? AND ? ");
		if (rf.isMuestraSubordinados() && rf.getSubordinados() != null) {
			sql.append(" AND INS_USUARIO " + getIn(rf.getSubordinados()));
		} else {
			sql.append(" AND INS_USUARIO = ? ");
		}
		sql.append(" AND INS_ESTATUS " + getIn(rf.getEstatus()));
		sql.append(" GROUP BY INS_ESTATUS, USU_CARGO ORDER BY USU_CARGO");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setDate(1, new Date(rf.getFechaInicialLong()));
			pstmt.setDate(2, new Date(rf.getFechaFinalLong()));
			if (!rf.isMuestraSubordinados() || rf.getSubordinados() == null) {
				pstmt.setInt(3, idUsuario);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				InstruccionForm ins = new InstruccionForm();
				ins.setEstatusNombre(Estatus.getInstruccionEstatus(rs
						.getInt("INS_ESTATUS")));
				ins.setUsuarioNombre(rs.getString("USU_CARGO"));
				ins.setTotalPorEstatus(rs.getInt("NUM_INSTRUCCIONES"));
				instrucciones.add(ins);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return instrucciones;
	}

	private static String getInUsuarios(List usuarios) {
		StringBuffer sb = new StringBuffer("IN( ");
		for (int i = 0; i < usuarios.size(); i++) {
			sb.append(((UsuarioBean) usuarios.get(i)).getStrIdUsuario());
			if (i != usuarios.size() - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		return sb.toString();
	}

	private static String getIn(String[] datos) {
		if (datos != null) {
			StringBuffer sb = new StringBuffer("IN( ");
			for (int i = 0; i < datos.length; i++) {
				sb.append(datos[i]);
				if (i != datos.length - 1) {
					sb.append(",");
				} else {
					sb.append(")");
				}
			}
			return sb.toString();
		}
		return "-1";
	}
	
	public static String getDescripcionInstruccion(int idInstruccion,Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT INS_NOMBRE FROM SD_INSTRUCCION WHERE ID_INSTRUCCION=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idInstruccion);
			rs=pstmt.executeQuery();
			while(rs.next()){
				return rs.getString("INS_NOMBRE");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return "N/A";
	}
}
