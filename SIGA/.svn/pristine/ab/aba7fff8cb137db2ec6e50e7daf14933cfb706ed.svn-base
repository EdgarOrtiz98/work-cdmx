/*
 **************************************************************
 * Copyright (C) 2007 SHCP
 * Javier Vega Tecalco
 * Este software es información propietaria y confidencial de la SHCP - CGTIyC.
 ***************************************************************
 */

package gob.hacienda.cgtic.siga.asunto;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.util.Estatus;

import java.io.FileWriter;

import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.naming.NamingException;
import javax.servlet.ServletContext;

public class AsuntoVerifica {

	AsuntoVerifica() {
	}

	/**
	 * Método que realiza la Búsqueda de asuntos que contengan el mismo
	 * remitente, el o los mismos destinatarios, la misma fecha del documento
	 * así como el mismo identificador del documento, esto con la finalidad de
	 * no tener redundancia de datos en la base de datos.
	 * 
	 * Regresa verdadero en caso de encontrar el documento que se desea
	 * ingresar, falso en otro caso...
	 * 
	 * @param strIdRemitente
	 *            Identificador de remitente en formato String.
	 * @param strIdDestinatario
	 *            Identificador de destinatario en formato String.
	 * @param strFechaDoc
	 *            Fecha del documento.
	 * @param strIdDoc
	 *            Identificador externo del documento
	 * @return boolean
	 * 
	 */
	public static boolean verifica(String strIdRemitente,
			String strIdDestinatario, String strFechaDoc, String strIdDoc) {

		String strSql = "SELECT ID_ASUNTO " + "FROM SD_ASUNTO "
				+ "WHERE ASU_REMITENTE=" + strIdRemitente
				+ " AND ASU_LISTAIDS_PARA LIKE '%" + strIdDestinatario
				+ "%' AND ASU_FECHA_DOCTO='" + strFechaDoc
				+ "' AND ASU_FOLIO_EXTERNO='" + strIdDoc + "'";

		try {
			String strExpediente[][] = ConexionDS.ejecutarSQL(strSql);
			if (strExpediente.length > 0)
				return true;
		} catch (SQLException sqle) {
			// System.out.println("Error en AsuntoVerifica.java, línea 24 de
			// gob.hacienda.cgtic.siga.asunto");
			sqle.printStackTrace();
		}
		return false;
	}

	public static boolean esRecuperable(int idAsunto) {
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			return esRecuperable(conn, idAsunto);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return false;
	}

	/**
	 * Metodo que verifica que el asunto no tenga instrucciones que ya se esten
	 * atendiendo
	 * 
	 * @return
	 */
	public static boolean esRecuperable(Connection conn, int idAsunto) {
		// TODO: Hay que sacar las conexiones, para evitarnos estarlas abriendo
		// y cerrando
		String sql = "SELECT ID_INSTRUCCION_ASUNTO FROM SD_INSTRUCCION_ASUNTO WHERE ID_ASUNTO = ? "
				+ "AND (INS_ESTATUS NOT IN(?,?) OR ID_ASUNTO IN("
				+ " SELECT ID_ASUNTO_CONTENT FROM SD_CONTENT_ORACLE WHERE ID_ASUNTO_CONTENT = ? AND ID_INS_CONTENT <> -1) "
				+ " OR ID_ASUNTO IN(SELECT ID_ASUNTO FROM SD_HISTORIAL_INSTRUCCIONES WHERE ID_ASUNTO = ?))";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idAsunto);
			pstmt.setInt(2, Estatus.INS_POR_TURNAR);
			pstmt.setInt(3, Estatus.INS_POR_ATENDER);
			pstmt.setInt(4, idAsunto);
			pstmt.setInt(5, idAsunto);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(rs, pstmt, null);
		}

		return true;
	}

	public static boolean puedeUaRecuperar(ServletContext contexto, String idUa) {
		String uas = contexto.getAttribute("app.siga.recuperar.uas").toString();		
		if (uas != null) {
			StringTokenizer st = new StringTokenizer(uas, ",");
			while (st.hasMoreTokens()) {
				String token = st.nextToken();				
				if (idUa.equals(token.trim())) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean noPuedeUaVerVentanillas(ServletContext contexto, String idUa) {
		if (contexto.getAttribute("app.siga.nover.ventanillas")==null || contexto.getAttribute("app.siga.nover.ventanillas")==""){
			return false;
		}
		else{
			String uas = contexto.getAttribute("app.siga.nover.ventanillas").toString();		
			if (uas != null) {
				StringTokenizer st = new StringTokenizer(uas, ",");
				while (st.hasMoreTokens()) {
					String token = st.nextToken();				
					if (idUa.equals(token.trim())) {
						return true;
					}
				}
			}
			return false;
		}
	}	
	
}
