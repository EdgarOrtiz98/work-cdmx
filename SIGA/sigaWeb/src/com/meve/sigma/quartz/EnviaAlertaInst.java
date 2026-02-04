/*
 * Creado el 11/04/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.quartz;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.meve.sigma.catalogos.CatalogoUtil;
import com.meve.sigma.catalogos.Catalogos;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.instruccion.dao.InstruccionDao;
import com.meve.sigma.util.Utilerias;

import javax.naming.NamingException;

//import javax.sql.DataSource;

/**
 * @author Enrique
 * 
 * TODO Para cambiar la plantilla de este comentario generado, vaya a Ventana -
 * Preferencias - Java - Estilo de código - Plantillas de código
 */
public class EnviaAlertaInst implements Job {

	public static final String getDatosAsuntoTramite = "SELECT ID_INSTRUCCION_ASUNTO,INS_ESTATUS, "
			+ " INS_INSTRUCCION_OTRO,INS_AVANCE,TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd') DCD, "
			+ " TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd') DCP, USU_CORREO, INS_FOLIO_TURNADO, USU_NOTIFICACION, USU_CARGO, INS_INSTRUCCION "
			+ " FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO "
			+ " WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
			+ " AND INS_ESTATUS IN (1,2)";
	public static final String getDatosConfig = "SELECT ID_CONF, CONF_DURACION, CONF_AMARILLO FROM SD_CONFIGURACION";
	public static final String getInsertAlert = "INSERT INTO SD_ALARMA_ENVIADO VALUES(?,?,?,?,SYSDATE,'INSTRUCC')";
	public static final String getSelectAlert = "SELECT  ID_ASUNTO,ALA_VERDE,ALA_AMARILLO,ALA_ROJO,ALA_FEC_ACTUALIZACION FROM SD_ALARMA_ENVIADO WHERE ALA_VERDE = ? AND ALA_AMARILLO = ? AND ALA_ROJO = ? AND ID_ASUNTO = ? AND ALAR_OPERACION = 'INSTRUCC'";
	public static final String datosConf = "SELECT CONF_AMARILLO FROM SD_CONFIGURACION";

	public EnviaAlertaInst() {
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
		int notificacion = 0;
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
				idUsu = rs.getString("ID_INSTRUCCION_ASUNTO");
				dcd = rs.getString("DCD");
				dcp = rs.getString("DCP");
				ava = rs.getFloat("INS_AVANCE");
				asudesc = rs.getString("INS_INSTRUCCION_OTRO");
				if(asudesc==null||"null".equals(asudesc)){
					asudesc=InstruccionDao.getDescripcionInstruccion(rs.getInt("INS_INSTRUCCION"),con);
				}
				mail = rs.getString("USU_CORREO");
				nombre = rs.getString("USU_CARGO");
				folio = rs.getString("INS_FOLIO_TURNADO");
				notificacion = rs.getInt("USU_NOTIFICACION");

				iDuracion = Utilerias.DiasdeTrabajoEntre(Utilerias
						.StringCalendar(dcp), Utilerias.StringCalendar(dcd), 0);
				fPorcentaje = Utilerias.getPorcentajeDebido(iDuracion, dcp,
						dcp, 5);
				fAvance = new Float(ava).floatValue();
				if (fPorcentaje >= 100) {
					sem = "Rojo";
					if (getSelectAlert("0", "0", "1", idUsu, con) == null) {
						// Validacion de bandera de notificacion
						if (notificacion == 0) {
							mails.sendConfirmacionCambioSemaforoInst(asudesc,
									mail,nombre, sem,
									folio,context);
							getInsertAlerm(idUsu, "0", "0", "1", con);
						}
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
								// Validacion de bandera de notificacion
								if (notificacion == 0) {
									mails.sendConfirmacionCambioSemaforoInst(
											asudesc, mail,nombre, sem,folio,context);
									getInsertAlerm(idUsu, "0", "1", "0", con);
								}
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
	 * Método que consulta en la base de datos el estatus del registro para
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
			// System.out.println("getSelectAlertIns:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
		ConexionDS.endConnection(rs, ps, null);
		return alert;
	}

	/**
	 * Método que inserta en la base de datos el estatus de la alarma
	 * 
	 * @param usu
	 *            usuario
	 * @param verde
	 *            bandera verde
	 * @param amarillo
	 *            bandera amarilla
	 * @param rojo
	 *            bandera roja
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
			// System.out.println("getInsertAlermInst:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		} finally {
			ConexionDS.endConnection(null, ps, null);
		}
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
			// System.out.println("getDatosAsuntoTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return 0;
		}
		ConexionDS.endConnection(rs, ps, null);
		return amarillo;
	}

}
