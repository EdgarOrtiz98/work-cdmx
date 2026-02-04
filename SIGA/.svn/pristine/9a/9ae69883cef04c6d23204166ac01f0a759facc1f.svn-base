package com.meve.sigma.asunto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.meve.sigma.asunto.AsuntoContentForm;
import com.meve.sigma.asunto.AsuntoForm;
import com.meve.sigma.beans.BeanRemitente;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.reporte.ReporteForm;
import com.meve.sigma.util.Estatus;


public class AsuntoDao {
	private static final String SELECT_ASUNTO = "SELECT ID_ASUNTO,ASU_ENTIDAD, ASU_ENTIDAD_OTRO, ASU_REMITENTE, "
			+ "ASU_REMITENTE_OTRO, ASU_FIRMANTE, ASU_DESCRIPCION,  "
			+ " ASU_TIP_DOCTO, ASU_FECHA_RECEPCION, "
			+ "ASU_FECHA_DOCTO, ASU_FECHA_CADUCIDAD, ASU_FOLIO_EXTERNO, ASU_FECHA_TERMINACION, "
			+ "ASU_FOLIO_INTERMEDIO, ASU_SINTESIS, ASU_COMENTARIOS, ASU_PALABRA_CLAVE, ASU_PRIORIDAD, "
			+ "ASU_FOLIO_RECEPCION, ASU_USUARIO_CAPTURA, ASU_FECHA_CAPTURA, ASU_AREA_RECEPCION, "			
			+ "ASU_TIPO_ASUNTO,ASU_ESTATUS, ASU_AVANCE,  ASU_TIP_DOCTO, ASU_PRIORIDAD, ASU_USR_TURNA, ASU_CONTROL, "
			+ "ASU_RUTA_AUTOMATICA,ASU_LISTAIDS_PARA, asu_lista_cc, ASU_FECHA_EVENTO , ASU_LUGAR_EVENTO,  "
			+ "ASU_HORA_EVENTO, ASU_MIN_EVENTO, asu_lista_para_Ext, ASU_TRAMITE, ASU_MAIL,  ASU_FOLIO_ENTRADA, ASU_CONTROL_FOLIO, "
			+ "ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC, ASU_LISTAIDS_PARA_EXT, ASU_FECHA_RECEPCION,  (SELECT RMT_NOMBRE  FROM SD_REMITENTE"
			+ " WHERE ASU_REMITENTE = ID_REMITENTE) AS RMT_NOMBRE, (SELECT RMT_CARGO FROM SD_REMITENTE    WHERE ASU_REMITENTE = ID_REMITENTE) AS RMT_CARGO,"
			+ " (SELECT ENT_NOMBRE FROM SD_ENTIDAD WHERE ID_ENTIDAD = (SELECT RMT_ENTIDAD FROM SD_REMITENTE WHERE ASU_REMITENTE = ID_REMITENTE)) AS REMITENTE_ENTIDAD ";

	private static final String SELECT_ASUNTO_OTRAS_VENTANILLAS = "SELECT SD_ASUNTO.ID_ASUNTO,ASU_ENTIDAD, ASU_ENTIDAD_OTRO, ASU_REMITENTE,  "
			+ "ASU_REMITENTE_OTRO, ASU_FIRMANTE, ASU_DESCRIPCION,"
			+ "ASU_TIP_DOCTO, ASU_FECHA_RECEPCION, ASU_FECHA_DOCTO, ASU_FECHA_CADUCIDAD, ASU_FOLIO_EXTERNO, ASU_FECHA_TERMINACION,  "
			+ "ASU_FOLIO_INTERMEDIO, ASU_SINTESIS, ASU_COMENTARIOS, ASU_PALABRA_CLAVE, ASU_PRIORIDAD, "
			+ "ASU_FOLIO_RECEPCION, ASU_USUARIO_CAPTURA, ASU_FECHA_CAPTURA, ASU_AREA_RECEPCION, "
			+ "ASU_TIPO_ASUNTO,INS_ESTATUS AS ASU_ESTATUS, ASU_AVANCE,  ASU_TIP_DOCTO, ASU_PRIORIDAD, ASU_USR_TURNA, ASU_CONTROL, "
			+ "ASU_RUTA_AUTOMATICA,asu_lista_para, asu_lista_cc, ASU_FECHA_EVENTO , ASU_LUGAR_EVENTO,  "
			+ "ASU_HORA_EVENTO, ASU_MIN_EVENTO, asu_lista_para_Ext, ASU_TRAMITE, ASU_MAIL,  ASU_FOLIO_ENTRADA, ASU_CONTROL_FOLIO, "
			+ "ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC, ASU_LISTAIDS_PARA_EXT, ASU_FECHA_RECEPCION, RMT_NOMBRE,RMT_CARGO, "
			+ "(SELECT ENT_NOMBRE FROM SD_ENTIDAD WHERE ID_ENTIDAD = RMT_ENTIDAD) AS REMITENTE_ENTIDAD ";

	public static List getReporteAsuntoDetalle(Connection conn, ReporteForm rf,
			int idArea) {
		StringBuffer sb = new StringBuffer(SELECT_ASUNTO);
		sb.append(" FROM SD_ASUNTO, SD_USUARIO ");
		sb.append(" WHERE "
				+ " SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " + "AND "
				+ rf.getTipoFechaCampo() + " BETWEEN TO_CHAR(TO_DATE('"+rf.getFechaInicial()+"','DD/MM/YYYY'), 'YYYY-MM-DD') " + "AND TO_CHAR(TO_DATE('"+rf.getFechaFinal()+"','DD/MM/YYYY'), 'YYYY-MM-DD') "
				+ "AND ASU_AREA_RECEPCION = ?" + " AND ASU_ESTATUS "
				+ getIn(rf.getEstatus()));
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List resultado = new ArrayList();	
		try {
			pstmt = conn.prepareStatement(sb.toString());			
			pstmt.setInt(1, idArea);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AsuntoForm af = new AsuntoForm(rs);
				af.setProcedencia("Ventanilla");
				af.setEstatusNombre(Estatus.getAsuntoEstatus(af.getEstatus()));
				resultado.add(af);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return resultado;
	}

	public static List getReporteAsuntoTotales(Connection conn, ReporteForm rf,
			int idArea) {
		StringBuffer sb = new StringBuffer(
				"SELECT COUNT(ID_ASUNTO) AS NUM_ASUNTO, ASU_ESTATUS ");
		sb.append(" FROM SD_ASUNTO, SD_USUARIO ");
		sb.append(" WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA AND ASU_AREA_RECEPCION = ? AND "
						+ rf.getTipoFechaCampo() + " BETWEEN TO_CHAR(TO_DATE('"+rf.getFechaInicial()+"','DD/MM/YYYY'), 'YYYY-MM-DD') " + "AND TO_CHAR(TO_DATE('"+rf.getFechaFinal()+"','DD/MM/YYYY'), 'YYYY-MM-DD')");
		sb.append("AND ASU_ESTATUS " + getIn(rf.getEstatus()));
		sb.append(" GROUP BY ASU_ESTATUS");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List resultado = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, idArea);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AsuntoForm af = new AsuntoForm();
				af.setTotalPorEstatus(rs.getInt("NUM_ASUNTO"));
				af.setEstatus(rs.getInt("ASU_ESTATUS"));
				af.setEstatusNombre(Estatus.getAsuntoEstatus(af.getEstatus()));
				af.setProcedencia("De la Ventanilla");
				resultado.add(af);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return resultado;
	}

	public static List getReporteOtrasVentanillasDetalle(Connection conn,
			ReporteForm rf, int idArea) {
		StringBuffer sb = new StringBuffer(SELECT_ASUNTO_OTRAS_VENTANILLAS);
		sb.append(" FROM SD_ASUNTO, SD_INSTRUCCION_ASUNTO, SD_REMITENTE ");
		sb
				.append(" WHERE SD_ASUNTO.ID_ASUNTO = SD_INSTRUCCION_ASUNTO.ID_ASUNTO  ");
		sb.append("AND ASU_REMITENTE = ID_REMITENTE ");
		sb.append("AND " + rf.getTipoFechaCampo() + " BETWEEN TO_CHAR(TO_DATE('"+rf.getFechaInicial()+"','DD/MM/YYYY'), 'YYYY-MM-DD') " + "AND TO_CHAR(TO_DATE('"+rf.getFechaFinal()+"','DD/MM/YYYY'), 'YYYY-MM-DD')");
		sb
				.append("AND INS_USUARIO IN(SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_AREA= ? )");
		sb.append(" AND INS_BANDERA1 = 1 ");
		sb.append("AND INS_ESTATUS ");
		sb.append(getIn(rf.getEstatusOtrasVentanillas()));
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List resultado = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			//pstmt.setDate(1, new Date(rf.getFechaInicialLong()));
			//pstmt.setDate(2, new Date(rf.getFechaFinalLong()));
			;
			pstmt.setInt(1, idArea);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AsuntoForm af = new AsuntoForm(rs);
				af.setEstatusNombre(Estatus.getOtrasVentanillasEstatus(af
						.getEstatus()));
				af.setProcedencia("Otras Ventanillas");
				resultado.add(af);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return resultado;
	}

	public static List getReporteOtrasVentanillasTotales(Connection conn,
			ReporteForm rf, int idArea) {
		StringBuffer sb = new StringBuffer(
				" SELECT COUNT(ID_INSTRUCCION_ASUNTO) AS NUM_ASUNTO, INS_ESTATUS ");
		sb.append(" FROM SD_ASUNTO, SD_INSTRUCCION_ASUNTO ");
		sb
				.append(" WHERE SD_ASUNTO.ID_ASUNTO = SD_INSTRUCCION_ASUNTO.ID_ASUNTO AND "
						+ "INS_USUARIO IN(SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_AREA=?) AND INS_BANDERA1 = 1 AND ");
		sb.append(rf.getTipoFechaCampo());
		sb.append(" BETWEEN TO_CHAR(TO_DATE('"+rf.getFechaInicial()+"','DD/MM/YYYY'), 'YYYY-MM-DD') " + "AND TO_CHAR(TO_DATE('"+rf.getFechaFinal()+"','DD/MM/YYYY'), 'YYYY-MM-DD')");
		sb.append("AND INS_ESTATUS " + getIn(rf.getEstatusOtrasVentanillas()));
		sb.append(" GROUP BY INS_ESTATUS ");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List resultado = new ArrayList();
		try {

			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, idArea);
			//pstmt.setDate(2, new Date(rf.getFechaInicialLong()));
			//pstmt.setDate(3, new Date(rf.getFechaFinalLong()));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AsuntoForm af = new AsuntoForm();
				af.setTotalPorEstatus(rs.getInt("NUM_ASUNTO"));
				af.setEstatus(rs.getInt("INS_ESTATUS"));
				af.setEstatusNombre(Estatus.getOtrasVentanillasEstatus(af
						.getEstatus()));
				af.setProcedencia("Otras Ventanillas");
				resultado.add(af);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return resultado;
	}

	public static String getAsuntosRelacionados(Connection conn, int idAsunto,
			String folio) {
		String sqlAsuntosAnex = "SELECT ID_ASUNTOS_REL, TIPO_REF FROM SD_ASUNTOS_ANEX WHERE ID_ASUNTO = ?";
		String sqlAsunto = "SELECT ASU_FOLIO_RECEPCION FROM SD_ASUNTO WHERE ID_ASUNTO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		try {
			pstmt = conn.prepareStatement(sqlAsuntosAnex);
			pstmt.setInt(1, idAsunto);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StringTokenizer ids = new StringTokenizer(rs
						.getString("ID_ASUNTOS_REL"), "|");
				StringTokenizer permiso = new StringTokenizer(rs
						.getString("TIPO_REF"), "|");
				while (ids.hasMoreElements()) {
					String id = (String) ids.nextElement();
					PreparedStatement pstmt2 = null;
					ResultSet rs2 = null;
					if (!" ".equals(id) && !"".equals(id)) {
						try {
							pstmt2 = conn.prepareStatement(sqlAsunto);
							pstmt2.setInt(1, Integer.parseInt(id));
							rs2 = pstmt2.executeQuery();
							while (rs2.next()) {
								sb.append(folio);
								sb
										.append(getTipoReferencia(permiso
												.nextToken()));
								sb.append(rs2.getString("ASU_FOLIO_RECEPCION")
										+ "\n");
							}
						} finally {
							ConexionDS.endConnection(rs2, pstmt2, null);
						}
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return sb.toString();
	}

	private static String getIn(String[] datos) {
		StringBuffer sb = new StringBuffer("IN( ");
		if (datos != null) {
			for (int i = 0; i < datos.length; i++) {
				sb.append(datos[i]);
				if (i != datos.length - 1) {
					sb.append(",");
				} else {
					sb.append(")");
				}
			}
		} else {
			sb.append("-1)");
		}
		return sb.toString();
	}

	public static BeanRemitente getRemitente(Connection conn, int idRemitente) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT RMT_NOMBRE, RMT_CARGO, RMT_TELEFONO, RMT_CORREO, ENT_NOMBRE, ARE_NOMBRE,RMT_DIRECCION "
				+ " FROM SD_REMITENTE, SD_AREA, SD_ENTIDAD "
				+ "WHERE ID_REMITENTE = ? AND RMT_ENTIDAD = ID_ENTIDAD AND RMT_AREA = ID_AREA ";
		BeanRemitente remitente = new BeanRemitente();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idRemitente);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				remitente.setRemitente(rs.getString("RMT_NOMBRE"));
				remitente.setRemitenteCargo(rs.getString("RMT_CARGO"));
				remitente.setRemitenteTelefono(rs.getString("RMT_TELEFONO"));
				remitente.setRemitenteCorreo(rs.getString("RMT_CORREO"));
				remitente.setRemitenteEntidad(rs.getString("ENT_NOMBRE"));
				remitente.setRemitenteArea(rs.getString("ARE_NOMBRE"));
				remitente.setRemitenteDireccion(rs.getString("RMT_DIRECCION"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return remitente;
	}

	public static UsuarioBean getDestinatario(Connection conn, int idUsuario) {
		String sql = "SELECT USU_NOMBRE, USU_CARGO, USU_AREA FROM SD_USUARIO WHERE ID_USUARIO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UsuarioBean usuario = new UsuarioBean();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				usuario.setStrNombre(rs.getString("USU_CARGO"));// Esta asi
				// porque en la
				// base de datos
				// esta al revez
				usuario.setStrCargo(rs.getString("USU_NOMBRE"));
				usuario.setIdArea(rs.getString("USU_AREA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return usuario;
	}
	public static UsuarioBean getUsuarioExt(Connection conn, int idUsuario) {
		String sql = "select * FROM sd_remitente where id_remitente = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UsuarioBean usuario = new UsuarioBean();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idUsuario);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				usuario.setStrNombre(rs.getString("RMT_NOMBRE"));// Esta asi
				// porque en la
				// base de datos
				// esta al revez
				//usuario.setStrCargo(rs.getString("USU_NOMBRE"));
				//usuario.setIdArea(rs.getString("USU_AREA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}
		return usuario;
	}	
	private static String getTipoReferencia(String refId) {
		if ("r".equals(refId)) {
			return (" es Respuesta de ");
		}
		if ("a".equals(refId)) {
			return (" es Alcance de ");
		}
		if ("f".equals(refId)) {
			return (" es Referencia de ");
		}
		return "";
	}
	
	public static List getAsuntoscontent(Connection conn, String idarea, String fecha_desde, String fecha_hasta){
    	    	    	    
			//String sql="and  asunto.asu_area_recepcion=12 and asunto.asu_fecha_recepcion between '07/11/2006' and '09/11/2006'";
			
			StringBuffer sb = new StringBuffer(" SELECT  asunto.id_asunto,asunto.asu_folio_recepcion,contentm.* ");
			sb.append(" FROM SD_ASUNTO asunto,sd_content_oracle contentm ");
			sb.append(" where asunto.id_asunto=contentm.id_asunto_content ");
			
			if (idarea!="" && idarea.length()>0){
				sb.append(" and  asunto.asu_area_recepcion="+idarea);
			}
			if(fecha_desde!="" && fecha_hasta!="" && fecha_desde.length()>0 && fecha_hasta.length()>0){
				sb.append(" and asunto.asu_fecha_recepcion between '"+fecha_desde+"' and '"+fecha_hasta+"'");
			}
			sb.append(" order by asunto.id_asunto desc ");
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List resultado = new ArrayList();
			try {
                                System.out.println(sb);
				pstmt = conn.prepareStatement(sb.toString());								
				rs = pstmt.executeQuery();
				//System.out.println("executeQuery");
				while (rs.next()) {
                                        //System.out.println("In While");
                                        AsuntoContentForm asu = new AsuntoContentForm();
                                        //System.out.println("AsuntoContentForm");
                                        asu.setIdAsunto(rs.getString("ID_ASUNTO"));					
					asu.setNombreArchivo(rs.getString("NOMBRE_ARCHIVO"));
					asu.setFolio(rs.getString("ASU_FOLIO_RECEPCION"));
					asu.setContentType(rs.getString("CONTENT_TYPE"));
					asu.setIdItemDoc(rs.getString("ID_ITEM_DOC"));
					asu.setIdUsuario(rs.getString("ID_USUARIO_CONTENT"));
					asu.setIdInsContent(rs.getString("ID_INS_CONTENT"));
					asu.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));
                                        asu.setIdReferencia(rs.getString("ID_REFERENCIA"));
					
					resultado.add(asu);
				}																																						
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConexionDS.endConnection(rs, pstmt, null);
			}
			return resultado;	
    }


	
}
