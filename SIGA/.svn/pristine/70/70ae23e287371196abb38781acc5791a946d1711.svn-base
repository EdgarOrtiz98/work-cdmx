package com.meve.sigma.quartz;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.util.Utilerias;

/**
 * Envia alertas a asuntos (cambio de semaforo)
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class EnviaAlerta implements Job {

	public static final String getDatosAsuntoTramite = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, "
			+ "ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, TO_CHAR(ASU_FECHA_CADUCIDAD, 'yyyy-MM-dd') DCD, TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd') DCP,USU_CORREO, USU_NOTIFICACION, USU_CARGO "
			+ "FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD "
			+ "ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO "
			+ "WHERE ASU_ESTATUS=2 "
			+ "AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
	public static final String getDatosConfig = "SELECT ID_CONF, CONF_DURACION, CONF_AMARILLO FROM SD_CONFIGURACION";
	public static final String getInsertAlert = "INSERT INTO SD_ALARMA_ENVIADO VALUES(?,?,?,?,SYSDATE,'ASUNTO')";
	public static final String getSelectAlert = "SELECT ID_ASUNTO, ALA_VERDE, ALA_AMARILLO, ALA_ROJO, ALA_FEC_ACTUALIZACION FROM SD_ALARMA_ENVIADO WHERE ALA_VERDE = ? AND ALA_AMARILLO = ? AND ALA_ROJO = ? AND ID_ASUNTO = ? AND ALAR_OPERACION = 'ASUNTO'";
	public static final String datosConf = "SELECT CONF_AMARILLO FROM SD_CONFIGURACION";

	/**
	 * Constructor por defecto
	 * 
	 */
	public EnviaAlerta() {
		super();
	}

	/**
	 * EJECUTA EL TRABAJO DE MONITOREO
	 */
	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		JobDataMap jdm = context.getJobDetail().getJobDataMap();
		ServletContext servletContext = (ServletContext) jdm
				.get("servletContext");
		getDatosAsuntoTramite(servletContext);
	}

	/**
	 * Interface
	 */
	public void performPaymentNotice() {

	}

	/**
	 * Ejecuta el monitoreo para saber cuando cambio de color un semáforo
	 * 
	 * @return Asuntos en Trámite
	 */

	public static String getDatosAsuntoTramite(ServletContext context) {
		Connection con = null;
		int iDuracion = 0;
		String idUsu = null;
		String dcd = null;
		String dcp = null;
		String asudesc = null;
		String mail = null;
		String nombre = null;
		String sem = null;
		String folio = null;
		com.meve.sigma.util.SenderMail mails = new com.meve.sigma.util.SenderMail();
		float ava = 0;
		float fAvance = 0;
		float fPorcentaje = 0;
		ResultSet rs;
		try {
			con = ConexionDS.getConexion();
			PreparedStatement ps = con.prepareStatement(getDatosAsuntoTramite);
			rs = ps.executeQuery();

			int iSAmarillo = 0;
			int strConfig = getDatosConfig(con);
			iSAmarillo = strConfig;
			int count = 0;
			while (rs.next()) {
				count++;
				idUsu = rs.getString("ID_ASUNTO");
				dcd = rs.getString("DCD");
				dcp = rs.getString("DCP");
				ava = rs.getFloat("ASU_AVANCE");
				asudesc = rs.getString("ASU_DESCRIPCION");
				mail = rs.getString("USU_CORREO");
				nombre = rs.getString("USU_CARGO");
				folio = rs.getString("ASU_FOLIO_RECEPCION");
				iDuracion = Utilerias.DiasdeTrabajoEntre(Utilerias
						.StringCalendar(dcp), Utilerias.StringCalendar(dcd), 0);
				fPorcentaje = Utilerias.getPorcentajeDebido(iDuracion, dcp,
						dcp, 5);
				fAvance = new Float(ava).floatValue();
				if (fPorcentaje >= 100) {
					sem = "Rojo";
					if (getSelectAlert("0", "0", "1", idUsu, con) == null) {

						mails.sendConfirmacionCambioSemaforo(asudesc, mail,nombre,
								sem, folio, context);

						getInsertAlerm(idUsu, "0", "0", "1", con);
					}
				} else if (fPorcentaje >= iSAmarillo && fPorcentaje <= 100) {
					if (fPorcentaje <= fAvance) {
						sem = "Verde";
						if (getSelectAlert("1", "0", "0", idUsu, con) == null) {
							getInsertAlerm(idUsu, "1", "0", "0", con);
						}
					} else {
						sem = "Amarillo";
						if (fPorcentaje > fAvance) {
							if (getSelectAlert("0", "1", "0", idUsu, con) == null) {

								mails.sendConfirmacionCambioSemaforo(asudesc,
										mail,nombre, sem, folio, context);

								getInsertAlerm(idUsu, "0", "1", "0", con);
							}
						}
					}
				} else if (fPorcentaje < iSAmarillo) {
					sem = "Verde";
					if (getSelectAlert("1", "0", "0", idUsu, con) == null) {
						getInsertAlerm(idUsu, "1", "0", "0", con);
					}
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, con);
		}
		return null;
	}

	/**
	 * Metodo que consulta la base de datos la configuracion de las banderas
	 * 
	 * @return valores de consulta
	 */
	public static String getSelectAlert(String verde, String amarillo,
			String rojo, String usu, Connection con) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		String alert = null;
		try {
			ps = con.prepareStatement(getSelectAlert);
			ps.setString(1, verde);
			ps.setString(2, amarillo);
			ps.setString(3, rojo);
			ps.setInt(4, Integer.parseInt(usu));
			rs = ps.executeQuery();
			if (rs.next()) {
				alert = "enviar";
			}
		} catch (SQLException sqle) {
			// System.out.println("getSelectAlert:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
		ConexionDS.endConnection(rs, ps, null);
		return alert;
	}

	/**
	 * Funcion que consulta en la base de datos el estatus del registro para
	 * alarma
	 * 
	 * @param verde
	 *            bandera verde
	 * @param amarillo
	 *            bandera amarilla
	 * @param rojo
	 *            bandera roja
	 * @param usu
	 *            usuario
	 * @return un indicador que indica el exito de la operación
	 */
	public static String getInsertAlerm(String usu, String verde,
			String amarillo, String rojo, Connection con) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(getInsertAlert);
			ps.setInt(1, Integer.parseInt(usu));
			ps.setString(2, verde);
			ps.setString(3, amarillo);
			ps.setString(4, rojo);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
		ConexionDS.endConnection(null, ps, null);
		return null;
	}

	/**
	 * Configuración de semáforo
	 * 
	 * @param con
	 * @return
	 */
	public static int getDatosConfig(Connection con) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		int amarillo = 0;
		try {
			ps = con.prepareStatement(datosConf);
			rs = ps.executeQuery();
			if (rs.next())
				amarillo = rs.getInt("CONF_AMARILLO");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return 0;
		}
		ConexionDS.endConnection(rs, ps, null);
		return amarillo;
	}
}
