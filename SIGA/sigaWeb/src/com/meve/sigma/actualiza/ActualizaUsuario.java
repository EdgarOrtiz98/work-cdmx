/* 
 * Nombre de Clase:     ActualizaUsuario.java
 * Paquete:             
 * Versión             1.0
 * Fecha Creación:      23/09/2005
 * Autor:               Arturo Corichi Guerrero
 * Empresa:             Meve Soluciones
 * Contacto:            corichi@yahoo.com.mx
 * Modificación:        21/Sep/2005 
 * Descripción de Clase:
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.actualiza;

import java.sql.SQLException;

import com.meve.sigma.beans.*;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.ldap.Autenticacion;
import com.meve.sigma.sql.SQLUsuario;
import com.meve.sigma.util.*;

import java.util.*;

import javax.servlet.ServletContext;

/**
 * ActualizaUsuario es una clase que ejecuta Querys de Consulta y Actualización
 * de registros de la Tabla de Usuarios
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaUsuario {
	/**
	 * Bean para cargar los datos del usuario al logearse en la aplicación
	 * 
	 * @param Dn
	 *            UID del usuario
	 * @return UsuarioBean
	 */
	public static UsuarioBean getUsuarioBean(String Dn) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		java.util.Date f = new java.util.Date();
		String strFechaCreacion = sdf.format(f);

		boolean admon = false;
		boolean atencion = false;
		boolean gestion = false;
		boolean recepcion = false;
		boolean supervisor = false;
		boolean turnado = false;
		boolean asistente = false;
		boolean nuevoAsunto = false;// 0
		boolean turnar = false;// 1
		boolean responder = false;// 2
		boolean rechazar = false;// 3
		boolean delegar = false;// 4
		boolean reasignar = false;// 5
		boolean habilitar = false;// 6
		boolean solCambio = false;// 7
		boolean respCambio = false;// 8
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getUsuarioBean(Dn));

			String SQL_BITACORA = "INSERT INTO SD_BITACORA1(ID_BITACORA, BIT_USUARIO, BIT_FECHA_EVENTO, BIT_EVENTO) "
					+ "VALUES(SD_BITACORA1_SEQ.NEXTVAL,"
					+ strResult[0][0]
					+ ", SYSDATE, 'Entró al Sistema')";

			int iInsertarBitacora = ConexionDS
					.ejecutarActualizacion(SQL_BITACORA);

			String strIdsRol[][] = ActualizaRol.getRoles(strResult[0][0]);
			String strIdsCorreo[][] = ActualizaParamCorreo
					.getParamCorreo(strResult[0][0]);
			for (int i = 0; i < strIdsRol.length; i++) {
				if (new Integer(strIdsRol[i][0]).intValue() == 0)
					admon = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 1)
					atencion = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 2)
					gestion = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 3)
					recepcion = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 4)
					supervisor = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 5)
					turnado = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 6)
					asistente = true;
			}
			for (int j = 0; j < strIdsCorreo.length; j++) {
				if (new Integer(strIdsCorreo[j][0]).intValue() == 0)
					nuevoAsunto = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 1)
					turnar = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 2)
					responder = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 3)
					rechazar = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 4)
					delegar = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 5)
					reasignar = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 6)
					habilitar = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 7)
					solCambio = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 8)
					respCambio = true;
			}
			return new UsuarioBean(strResult[0][1], strResult[0][0],
					strResult[0][5], strResult[0][2], strResult[0][3],
					strResult[0][4], strResult[0][11], strResult[0][12],
					strResult[0][9], strResult[0][8],/* strResult[0][14], */
					admon, atencion, gestion, recepcion, supervisor, turnado,
					asistente, nuevoAsunto, turnar, responder, rechazar,
					delegar, reasignar, habilitar, solCambio, respCambio,
					strResult[0][15], strResult[0][16]);
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioBean:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	public static UsuarioBean getUsuarioBeanPorArea(String Dn, String idArea) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		java.util.Date f = new java.util.Date();
		String strFechaCreacion = sdf.format(f);

		boolean admon = false;
		boolean atencion = false;
		boolean gestion = false;
		boolean recepcion = false;
		boolean supervisor = false;
		boolean turnado = false;
		boolean asistente = false;
		boolean nuevoAsunto = false;// 0
		boolean turnar = false;// 1
		boolean responder = false;// 2
		boolean rechazar = false;// 3
		boolean delegar = false;// 4
		boolean reasignar = false;// 5
		boolean habilitar = false;// 6
		boolean solCambio = false;// 7
		boolean respCambio = false;// 8
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getUsuarioBeanArea(Dn, idArea));

			String SQL_BITACORA = "INSERT INTO SD_BITACORA1(ID_BITACORA, BIT_USUARIO, BIT_FECHA_EVENTO, BIT_EVENTO) "
					+ "VALUES(SD_BITACORA1_SEQ.NEXTVAL,"
					+ strResult[0][0]
					+ ", SYSDATE, 'Entró al Sistema')";

			int iInsertarBitacora = ConexionDS
					.ejecutarActualizacion(SQL_BITACORA);

			String strIdsRol[][] = ActualizaRol.getRoles(strResult[0][0]);
			String strIdsCorreo[][] = ActualizaParamCorreo
					.getParamCorreo(strResult[0][0]);
			for (int i = 0; i < strIdsRol.length; i++) {
				if (new Integer(strIdsRol[i][0]).intValue() == 0)
					admon = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 1)
					atencion = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 2)
					gestion = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 3)
					recepcion = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 4)
					supervisor = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 5)
					turnado = true;
				if (new Integer(strIdsRol[i][0]).intValue() == 6)
					asistente = true;
			}
			for (int j = 0; j < strIdsCorreo.length; j++) {
				if (new Integer(strIdsCorreo[j][0]).intValue() == 0)
					nuevoAsunto = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 1)
					turnar = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 2)
					responder = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 3)
					rechazar = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 4)
					delegar = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 5)
					reasignar = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 6)
					habilitar = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 7)
					solCambio = true;
				if (new Integer(strIdsCorreo[j][0]).intValue() == 8)
					respCambio = true;
			}
			return new UsuarioBean(strResult[0][1], strResult[0][0],
					strResult[0][5], strResult[0][2], strResult[0][3],
					strResult[0][4], strResult[0][11], strResult[0][12],
					strResult[0][9], strResult[0][8],/* strResult[0][14], */
					admon, atencion, gestion, recepcion, supervisor, turnado,
					asistente, nuevoAsunto, turnar, responder, rechazar,
					delegar, reasignar, habilitar, solCambio, respCambio,
					strResult[0][15], strResult[0][16]);
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioBean:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de los datos de un suarios por medio del ID
	 * 
	 * @param IDUsuario
	 *            Id usuarios
	 * @return regresa arreglo con datos del usuario
	 */
	public static String[][] getIDUsuarioBean(String IDUsuario) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getIDUsuarioBean(IDUsuario));

			return strResult;
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioBean:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query para insertar los datos de un usuario
	 * 
	 * @param nombre
	 *            Nombre del usuario
	 * @param idArea
	 *            ID del área
	 * @param cargo
	 *            Cargo que ejerce el usuario
	 * @param correo
	 *            mail del usuario
	 * @param telefono
	 *            telefono del usuario
	 * @param consecutivo
	 *            Numero consecutivo se las ceves que ingresa al sistema
	 * @param jefe
	 *            ID del jefe del usuario
	 * @param asistente
	 *            ID del asistente del usuario
	 * @param actualizo
	 *            Id del usuario que creo el registro del nuevo usuario
	 * @param fecha
	 *            fecha en la que fue creado el registro del usuario
	 * @param estatus
	 *            Estatus 0
	 * @param UID
	 *            UID
	 * @return True si guardo, False si no lo guardo
	 */
	public static boolean InsertarUsuario(String nombre, String idArea,
			String cargo, String correo, String telefono, String consecutivo,
			String jefe, String asistente, String actualizo, String fecha,
			String estatus, String UID) {
		int r = 0;
		try {
			String strSql = SQLUsuario.getInsertaUsuario(nombre, idArea, cargo,
					correo, telefono, consecutivo, jefe, asistente, actualizo,
					fecha, estatus, UID);

			// //System.out.println("InsertaUsuario"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("InsertaUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query para insertar los datos de un usuario
	 * 
	 * @param nombre
	 *            Nombre del usuario
	 * @param idArea
	 *            ID del área
	 * @param cargo
	 *            Cargo que ejerce el usuario
	 * @param correo
	 *            mail del usuario
	 * @param telefono
	 *            telefono del usuario
	 * @param consecutivo
	 *            Numero consecutivo se las ceves que ingresa al sistema
	 * @param jefe
	 *            ID del jefe del usuario
	 * @param asistente
	 *            ID del asistente del usuario
	 * @param actualizo
	 *            Id del usuario que creo el registro del nuevo usuario
	 * @param fecha
	 *            fecha en la que fue creado el registro del usuario
	 * @param estatus
	 *            Estatus 0
	 * @param UID
	 *            UID
	 * @param strCat
	 *            Acceso a catalogos
	 * @param strNotificacion
	 *            Notificaciones
	 * @param strDesExt
	 *            atención a destinatarios externos
	 * @param strSubVent
	 *            Subventanilla
	 * @param ldap
	 *            Configuración Ldap
	 * @param idUsuario
	 *            Id del usuario
	 * @param pass
	 *            pass del usuario
	 * @param idRol
	 *            Roles del usuario
	 * @param confMail
	 *            Configuración del envio de mails
	 * @return True si guardo, False si no lo guardo
	 */
	public static synchronized boolean InsertarUsuario1(String nombre,
			String idArea, String cargo, String correo, String telefono,
			String consecutivo, String jefe, String[] asistente,
			String actualizo, String fecha, String estatus, String UID,
			String strCat, String strNotificacion, String strDesExt,
			String strSubVent, String ldap, String idUsuario, String pass,
			String idRol, String confMail) {
		int r = 0;
		boolean bBitacora = false;
		boolean bActualizaUSR = false;
		boolean bInsertaRol = false;
		boolean bInsertaCorreo = false;
		try {
			String strSql = SQLUsuario.getInsertaUsuario1(nombre, idArea,
					cargo, correo, telefono, consecutivo, jefe, actualizo,
					fecha, estatus, UID, strCat, strNotificacion, strDesExt,
					strSubVent);

			r = ConexionDS.ejecutarActualizacion(strSql);

			if (r > 0) {
				String idusuario = ActualizaUsuario
						.getIdUsuarioUID(UID, idArea);
				bBitacora = ActualizaBitacora.InsertarEventoAltaPuesto(
						idUsuario, cargo);
				if (ldap.equals("0")) {
					bActualizaUSR = ActualizaAutentificacion
							.insertarDatosUsuario(UID, pass);
				} else {
					bActualizaUSR = ActualizaAutentificacion
							.insertarDatosUsuario(UID, pass);
				}
				if (idusuario.length() > 0) {
					bInsertaRol = ActualizaRol.InsertaRolUsuario(idusuario,
							idRol);
					bInsertaCorreo = ActualizaParamCorreo.InsertaParamCorreo(
							idusuario, confMail);

					if (asistente != null) {
						for (int i = 0; i < asistente.length; i++) {
							int insert = ConexionDS
									.ejecutarActualizacion(SQLUsuario
											.insertAsistente(idusuario,
													asistente[i]));
						}
					}
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Datos del área de un usuario
	 * 
	 * @return regresa arreglo con el id y nombre de un área
	 */
	public static String[][] getAreas() {
		String sqlStr = SQLUsuario.getAreas();

		String[][] strResul = null;

		try {
			strResul = ConexionDS.ejecutarSQL(sqlStr);

		} catch (SQLException ex) {

			// System.out.println(" getAreas: "+ex.getMessage());
			ex.printStackTrace();

		}
		return strResul;
	}

	/**
	 * Meses
	 * 
	 * @return Regresa arreglo de meses
	 */
	public static String[][] getMeses() {

		String[][] strResul = { { "1", "1", "1" }, { "2", "2", "2" },
				{ "3", "3", "3" }, { "4", "4", "4" }, { "5", "5", "5" },
				{ "6", "6", "6" }, { "7", "7", "7" }, { "8", "8", "8" },
				{ "9", "9", "9" }, { "10", "10", "10" }, { "11", "11", "11" },
				{ "12", "12", "12" } };

		return strResul;
	}

	/**
	 * Organigrama de los puestos o usuarios
	 * 
	 * @return regresa un ArrayList con el organigrama
	 */
	public static ArrayList getOrganigrama() {
		ArrayList jerarquia = new ArrayList();
		ArrayList nivelActual = new ArrayList();
		String sqlStr = "";
		String strResult[][] = null;

		for (int i = 0;; i++) {

			sqlStr = SQLUsuario.getJerarquia(i, nivelActual);

			try {
				// //System.out.println("\t\tstrSql=-->"+sqlStr);
				strResult = ConexionDS.ejecutarSQL(sqlStr);
			} catch (SQLException ex) {

				// System.out.println(" getOrganigrama: "+ex.getMessage());
				ex.printStackTrace();
			}
			if (strResult == null || strResult.length == 0)
				break;
			else {

				nivelActual = new ArrayList();
				for (int m = 0; m < strResult.length; m++) {
					UsuarioBean usuario = new UsuarioBean(strResult[m][1],
							strResult[m][0], strResult[m][5], strResult[m][2],
							strResult[m][3], strResult[m][4], strResult[m][11],
							strResult[m][12], strResult[m][9], strResult[m][8],/* strResult[m][14] */
							false, false, false, false, false, false, false,
							false, false, false, false, false, false, false,
							false, false, strResult[0][15], strResult[0][16]);

					nivelActual.add(usuario);
				}

				jerarquia.add(nivelActual);

			}

		}
		return jerarquia;
	}

	/**
	 * Historial de Configuración de usuarios
	 * 
	 * @param id_usu
	 *            Id usuario
	 * @param idArea
	 *            Id área
	 * @param mes
	 *            mes
	 * @return ArrayList
	 */
	public static ArrayList getHistConfig(String id_usu, String idArea,
			String mes) {
		ArrayList jerarquia = new ArrayList();
		ArrayList nivelActual = new ArrayList();
		String sqlStr = "";
		String sqlStrIns = "";
		String sqlStrUpd = "";
		String sqlUsu = "";
		String sqlAer = "";
		String strResult[][] = null;
		int strResult2 = 0;
		int strResult3 = 0;

		for (int i = 0;; i++) {

			sqlStr = SQLUsuario.getHisto(id_usu, idArea);

			try {
				// //System.out.println("\t\tstrSql=-->"+sqlStr);
				strResult = ConexionDS.ejecutarSQL(sqlStr);
			} catch (SQLException ex) {

				// System.out.println(" Mensaje de Conf: "+ex.getMessage());
				ex.printStackTrace();
			}
			if (strResult == null || strResult.length == 0) {
				try {
					sqlStrIns = SQLUsuario.getInserHist(id_usu, idArea, mes);
					// //System.out.println("\t\tsqlStrIns=-->"+sqlStrIns);
					strResult2 = ConexionDS.ejecutarActualizacion(sqlStrIns);
				} catch (SQLException ex) {

					// System.out.println(" Mensaje de Conf: "+ex.getMessage());
					ex.printStackTrace();
				}

				break;
			} else {

				try {

					sqlStrUpd = SQLUsuario
							.getActualizaHist(id_usu, idArea, mes);
					// //System.out.println("\t\tsqlStrUpd=-->"+sqlStrUpd);
					strResult3 = ConexionDS.ejecutarActualizacion(sqlStrUpd);
					break;
				} catch (SQLException ex) {

					// System.out.println(" Mensaje de Conf: "+ex.getMessage());
					ex.printStackTrace();
				}

			}

		}
		return jerarquia;
	}

	/**
	 * Función que ejecuta un query y determina quien es el asistente de un
	 * usuario
	 * 
	 * @param idUsuario
	 * @return UsuarioBean
	 */
	public static UsuarioBean getAsistenteDe(String idUsuario) {

		UsuarioBean asistente = null;

		String strSql = SQLUsuario.getAsistenteDe(idUsuario);
		String[][] strResult = null;
		try {
			strResult = ConexionDS.ejecutarSQL(strSql);
		} catch (SQLException ex) {

			// System.out.println("getAsistente de: "+idUsuario+" -->
			// "+ex.getMessage());
			ex.printStackTrace();
		}

		asistente = new UsuarioBean(strResult[0][1], strResult[0][0],
				strResult[0][5], strResult[0][2], strResult[0][3],
				strResult[0][4], strResult[0][11], strResult[0][12],
				strResult[0][9], strResult[0][8],/* strResult[0][14], */false,
				false, false, false, false, false, false, false, false, false,
				false, false, false, false, false, false, strResult[0][15],
				strResult[0][16]);

		return asistente;
	}

	/**
	 * Función que ejecuta un query y determina quien son los jefes del
	 * asistente de un usuario
	 * 
	 * @param idUsuario
	 * @return regresa arreglo con los jefes del asistente
	 */
	public static String[][] getJefesDeAsistente(String idUsuario) {

		String strSql = SQLUsuario.getJefesDeAsistente(idUsuario);
		String[][] strResult = null;
		try {
			strResult = ConexionDS.ejecutarSQL(strSql);
			return strResult;
		} catch (SQLException ex) {

			// System.out.println("getJefesDeAsistente de: "+strSql+" -->
			// "+ex.getMessage());
			ex.printStackTrace();
			return null;
		}

	}

	/**
	 * Función que ejecuta un query y determina con un ArrayList las personas
	 * que tiene a su cargo
	 * 
	 * @param idUsuario
	 * @return regresa ArrayList de subalternos
	 */
	public static ArrayList getSubalternosDe(String idUsuario) {

		ArrayList subAlternos = new ArrayList();
		String strSql = SQLUsuario.getSubalternosDe(idUsuario);

		String strResult[][] = null;
		try {
			strResult = ConexionDS.ejecutarSQL(strSql);
		} catch (SQLException ex) {

			// System.out.println("ex="+ex);
			ex.printStackTrace();

		}

		if (strResult != null) {
			for (int i = 0; i < strResult.length; i++) {

				// String strNombre = NombreUsuario(strResult[i][0]);
				String strNombre = strResult[i][0];

				subAlternos.add(strNombre);
			}
		}
		return subAlternos;
	}

	/**
	 * Lista de subalternos de un usuario
	 * 
	 * @param idUsuario
	 *            id usuario
	 * @return regresa arreglo de subalternos
	 */
	public static String[][] getSubalterno(String idUsuario) {
		try {
			String strsql = SQLUsuario.getSubalternosDe(idUsuario);
			// //System.out.println("getSubalterno:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getSubalterno:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de subalternos sin rol
	 * 
	 * @param idUsuario
	 *            id usuario
	 * @return regresa arreglo de subalternos sin rol
	 */
	public static String[][] getSubalternoSinRol(String idUsuario) {
		try {
			String strsql = SQLUsuario.getSubalternosSinRol(idUsuario);
			// //System.out.println("getSubalterno:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getSubalternoSinRol:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Verifica si el usuario tiene puesto subalternos
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return true si tiene hijos
	 */
	public static boolean tieneHijos(String strIdUsuario) {
		try {
			String strSql = SQLUsuario.getSubalternosDe(strIdUsuario);

			String str[][] = ConexionDS.ejecutarSQL(strSql);
			if (str.length != 0)
				return true;// tiene = true;
			return false;// tiene = false;
		} catch (SQLException sqle) {
			// System.out.println("tieneHijos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si el usuario tiene puesto subalternos sin rol
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return true si tiene hijos sin rol
	 */
	public static boolean tieneHijosSinRol(String strIdUsuario) {
		try {
			String strSql = SQLUsuario.getSubalternosSinRol(strIdUsuario);

			String str[][] = ConexionDS.ejecutarSQL(strSql);
			if (str.length != 0)
				return true;// tiene = true;
			return false;// tiene = false;
		} catch (SQLException sqle) {
			// System.out.println("tieneHijos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Nombre del usuario(Puesto)
	 * 
	 * @param idUsuario
	 *            id usuario
	 * @return Nombe del usuario
	 */
	public static String getNombreUsuario(String idUsuario) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getNombreUsuario(idUsuario));

			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getNombreUsuario:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Elimina registros de usuarios
	 * 
	 * @param strIds
	 *            arreglo de ids de usuarios a eliminar
	 * @return Vector con los ids de usuarios que no se eliminarón
	 */
	public static Vector deleteUsuario(String strIds[], String strIdUsuario) {
		Vector vTiene = new Vector();
		int r = 0;
		if (strIds == null || strIds.length < 0)
			return vTiene;

		try {
			for (int i = 0; i < strIds.length; i++) {
				if (getCountInstruccion(strIds[i]) && getCountAsunto(strIds[i])
						&& getCountJefe(strIds[i])
						&& getExisteParaCC(strIds[i])
						&& getCountRemitenteAsunto(strIds[i])) {

					boolean bBitacora = ActualizaBitacora.deleteEventoPuesto(
							strIdUsuario, strIds[i], NombreUsuario(strIds[i]));
					String strsql = SQLUsuario.getDeleteUsuario(strIds[i],
							getUID(strIds[i]));
					// //System.err.println("deleteUsuario:"+strsql);
					r = ConexionDS.ejecutarActualizacion(strsql);
				} else {
					vTiene.add(strIds[i]);
				}
			}
		} catch (SQLException sqle) {
			// System.out.println("deleteUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
		}
		return vTiene;
	}

	/**
	 * Lista de usuarios
	 * 
	 * @return Regresa arreglo de usuarios
	 */
	public static String[][] getListaUsuarios() {
		try {
			String strsql = SQLUsuario.getUsuarios();
			// //System.out.println("getListaUsuarios:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getListaUsuarios:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Datos del usuario
	 * 
	 * @param idUsuario
	 *            id usuario consultado
	 * @return Regresa arreglo de los datos de un usuario
	 */
	public static String[][] getUsuario(String idUsuario) {
		try {
			String strsql = SQLUsuario.getUsuario(idUsuario);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {

			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza registro de un usuario
	 * 
	 * @param idUsuario
	 *            Id usuario
	 * @param nombre
	 *            Nombre del usuario
	 * @param idArea
	 *            ID del área
	 * @param cargo
	 *            Cargo que ejerce el usuario
	 * @param correo
	 *            mail del usuario
	 * @param telefono
	 *            telefono del usuario
	 * @param consecutivo
	 *            Numero consecutivo se las ceves que ingresa al sistema
	 * @param jefe
	 *            ID del jefe del usuario
	 * @param asistente
	 *            ID del asistente del usuario
	 * @param actualizo
	 *            Id del usuario que creo el registro del nuevo usuario
	 * @param fecha
	 *            fecha en la que fue creado el registro del usuario
	 * @param strActivo
	 *            Si es activo el usuario
	 * @param UID
	 *            UID
	 * @return
	 */
	public static boolean ActualizarUsuario(String idUsuario, String nombre,
			String idArea, String cargo, String correo, String telefono,
			String consecutivo, String jefe, String asistente,
			String actualizo, String fecha, String strActivo, String UID) {
		int r = 0;
		try {
			String strsql = SQLUsuario.getActualizarUsuario(idUsuario, nombre,
					idArea, cargo, correo, telefono, consecutivo, jefe,
					asistente, actualizo, fecha, strActivo, UID);
			// //System.out.println("ActualizarUsuario:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("ActualizarUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * 
	 * @param idUsuario
	 *            Id usuario
	 * @param nombre
	 *            Nombre del usuario
	 * @param idArea
	 *            ID del área
	 * @param cargo
	 *            Cargo que ejerce el usuario
	 * @param correo
	 *            mail del usuario
	 * @param telefono
	 *            telefono del usuario
	 * @param consecutivo
	 *            Numero consecutivo se las ceves que ingresa al sistema
	 * @param jefe
	 *            ID del jefe del usuario
	 * @param asistente
	 *            ID del asistente del usuario
	 * @param actualizo
	 *            Id del usuario que creo el registro del nuevo usuario
	 * @param fecha
	 *            fecha en la que fue creado el registro del usuario
	 * @param strActivo
	 *            Si es activo el usuario
	 * @param UID
	 *            UID
	 * @param strCat
	 *            Acceso a los catalogos
	 * @param strNotificacion
	 *            Notificaciones
	 * @param strDesExt
	 *            atención a destinatarios externos
	 * @param strSubVent
	 *            Subventanilla
	 * @return true si actualizo exitosamente
	 */
	public static synchronized boolean ActualizarUsuario1(String idUsuario,
			String nombre, String idArea, String cargo, String correo,
			String telefono, String consecutivo, String jefe,
			String[] asistente, String actualizo, String fecha,
			String strActivo, String UID, String strCat,
			String strNotificacion, String strDesExt, String strSubVent,
			String ldap, String idUs, String[][] datos, String pass,
			String idRol, String confMail) {
		int r = 0;
		boolean bBitacora = false;
		boolean bInsertaRol = false;
		boolean bInsertaCorreo = false;
		try {
			String strsql = SQLUsuario.getActualizarUsuario1(idUsuario, nombre,
					idArea, cargo, correo, telefono, consecutivo, jefe,
					actualizo, fecha, strActivo, UID, strCat, strNotificacion,
					strDesExt, strSubVent);
			r = ConexionDS.ejecutarActualizacion(strsql);

			// **Actualiza bitacora
			bBitacora = ActualizaBitacora.InsertarEventoCambioPuesto(idUs,
					idUsuario, cargo, datos);

			// **Verifica si existe el usuario y si esta configurado el sistema
			// con ldap o DB
			if (ldap.equals("0")) {
				boolean existe = ActualizaAutentificacion.getExisteUsuario(UID);
				if (existe) {
					boolean bActualizaUSR = ActualizaAutentificacion
							.updateDatosUsuario(UID, pass);
				} else {
					boolean bActualizaUSR = ActualizaAutentificacion
							.insertarDatosUsuario(UID, pass);
				}
			} else {
				boolean existe = ActualizaAutentificacion.getExisteUsuario(UID);
				if (existe) {
					boolean bActualizaUSR = ActualizaAutentificacion
							.updateDatosUsuario(UID, pass);
				} else {
					boolean bActualizaUSR = ActualizaAutentificacion
							.insertarDatosUsuario(UID, pass);
				}
			}

			// **Actualiza los roles del usuario
			bInsertaRol = ActualizaRol.InsertaRolUsuario(idUsuario, idRol);

			// **Actualiza la Configuración de mails de envio
			bInsertaCorreo = ActualizaParamCorreo.InsertaParamCorreo(idUsuario,
					confMail);

			int delete = ConexionDS.ejecutarActualizacion(SQLUsuario
					.deleteAsistente(idUsuario));
			if (asistente != null) {
				for (int i = 0; i < asistente.length; i++) {
					int insert = ConexionDS.ejecutarActualizacion(SQLUsuario
							.insertAsistente(idUsuario, asistente[i]));
				}
			}
		} catch (SQLException sqle) {
			// System.out.println("ActualizarUsuario:"+sqle.getMessage());
			// sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Cadena de mando de destinatarios para
	 * 
	 * @param idUsuario
	 *            Id usuario
	 * @return Stack de la cadena de mando
	 */
	public static Stack getCadenaDeMandoPara(String idUsuario) {
		Stack st = new Stack();
		String idUsuarioActual = idUsuario;
		String idJefe = "";
		String strResult[][] = null;
		while (idJefe != null) {
			String strSql = SQLUsuario.getJefeDe(idUsuarioActual);

			try {
				// //System.out.println("getJefeDe: "+strSql);
				strResult = ConexionDS.ejecutarSQL(strSql);
			} catch (SQLException ex) {
				// System.err.println("getCadenaDeMando: "+ex.getMessage());
				ex.printStackTrace();
				idJefe = null;
			}
			if (strResult != null && strResult.length > 0) {
				if (!idUsuarioActual.equals(strResult[0][0])
						&& !strResult[0][0].equals("")) {
					String strNombre = NombreUsuario(strResult[0][0]);
					st.push(strNombre);
					idUsuarioActual = strResult[0][0];
				} else {
					// //System.err.println("Error: El usuario tiene asignado un
					// jefe inválido");
					idJefe = null;
				}
			} else
				idJefe = null;
		}
		return st;
	}

	/**
	 * Compañeros del área por usuario
	 * 
	 * @param idUsuario
	 *            Id usuario
	 * @return Regresa arreglo de Compañeros del área
	 */
	public static String[][] getCompanierosArea(String idUsuario) {
		String strSql = SQLUsuario.getCompanierosArea(idUsuario);
		String strResult[][] = null;
		try {
			// //System.out.println("getCompanierosArea:"+strSql);
			strResult = ConexionDS.ejecutarSQL(strSql);
			// //System.out.println("sizeCompanieros--->"+strResult.length);
		} catch (SQLException ex) {
			// System.out.println("getCompanierosArea: "+ex.getMessage());
			ex.printStackTrace();
		}
		// //System.out.println("Lena ListArray--->");
		return strResult;
	}

	/**
	 * Usuarios del área
	 * 
	 * @param idArea
	 *            Id área
	 * @return ArrayList de los usuarios del área
	 */
	public static ArrayList getUsuariosArea(String idArea) {

		ArrayList usuarios = new ArrayList();
		String sqlStr = SQLUsuario.getUsuariosArea(idArea);
		String strResult[][] = null;
		try {
			strResult = ConexionDS.ejecutarSQL(sqlStr);
		} catch (SQLException ex) {
			// System.out.println(" getUsuariosArea: "+ex.getMessage());
			ex.printStackTrace();
		}

		if (strResult != null)
			for (int i = 0; i < strResult.length; i++) {

				UsuarioBean usuario = new UsuarioBean(strResult[i][1],
						strResult[i][0], strResult[i][5], strResult[i][2],
						strResult[i][3], strResult[i][4], strResult[i][11],
						strResult[i][12], strResult[i][9], strResult[i][8],/* strResult[i][14], */
						false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false,
						strResult[0][15], strResult[0][16]);

				usuarios.add(usuario);
			}

		return usuarios;
	}

	/**
	 * Función que verifica si existe un usuario para ser autentificado por LDAP
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return True SI existe, False si no existe
	 */
	public static boolean getExisteUsuario(String strNombre, String strAux) {
		int r = 0;
		int nusuario = 0;
		try {
			String strsql = SQLUsuario.getBuscaUsuarioNombre(strNombre, strAux);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			nusuario = new Integer(strResultado[0][0]).intValue();
		} catch (SQLException sqle) {
			// System.out.println("getExisteUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario = 0;
		} catch (NumberFormatException nfe) {
			nusuario = 0;
		}

		if (nusuario == 0)
			return false;
		return true;
	}

	/**
	 * Función que verifica si existe un usuario en una unidad adinistrativa
	 * para ser autentificado por LDAP
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return True SI existe, False si no existe
	 */
	public static boolean getExisteUsuarioEnUnidad(String strNombre,
			String strAux, String idArea) {
		int r = 0;
		int nusuario = 0;
		try {
			String strsql = SQLUsuario.getBuscaUsuarioNombreEnUnidad(strNombre,
					strAux, idArea);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			nusuario = new Integer(strResultado[0][0]).intValue();
		} catch (SQLException sqle) {
			// System.out.println("getExisteUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario = 0;
		} catch (NumberFormatException nfe) {
			nusuario = 0;
		}

		if (nusuario == 0)
			return false;
		return true;
	}

	/**
	 * Función que ejecuta un query para verificar si el usuario tiene el estado
	 * de activo
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return True si es activo, False si no lo es
	 */
	public static boolean getEsActivo(String strNombre) {
		int r = 0;
		int nusuario = 0;
		try {
			String strsql = SQLUsuario.getEsActivo(strNombre);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			nusuario = new Integer(strResultado[0][0]).intValue();
		} catch (SQLException sqle) {
			// System.out.println("getEsActivo:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario = 0;
		} catch (NumberFormatException nfe) {
			nusuario = 0;
		}
		if (nusuario == 0)
			return false;
		return true;
	}

	/**
	 * Verifica si es usuario esta eliminado lógicamente
	 * 
	 * @param strNombre
	 *            UID del usuario
	 * @return true si esta eliminado
	 */
	public static boolean getEsBorrado(String strNombre) {
		int r = 0;
		int nusuario = 0;
		try {
			String strsql = SQLUsuario.getEsBorrado(strNombre);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			nusuario = new Integer(strResultado[0][0]).intValue();
		} catch (SQLException sqle) {
			// System.out.println("getEsBorrado:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario = 0;
		} catch (NumberFormatException nfe) {
			nusuario = 0;
		}
		if (nusuario == 0)
			return false;
		return true;
	}

	/**
	 * Nombre del Usuario
	 * 
	 * @param idUsuario
	 *            Id Usuario
	 * @return Nombre del usuario
	 */
	public static String NombreUsuario(String idUsuario) {
		if (idUsuario.length() > 0) {
			try {
				// //System.out.println("NombreUsuario="+SQLUsuario.NombreUsuario(idUsuario));
				String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
						.NombreUsuario(idUsuario));
				if (strResult != null && strResult.length > 0)
					return strResult[0][0];
				return null;
			} catch (SQLException sqle) {
				// System.out.println("NombreUsuario:
				// "+SQLUsuario.NombreUsuario(idUsuario)+" \n"+sqle);
				// sqle.printStackTrace();
				return null;
			}
		} else
			return null;
	}

	/**
	 * Nombre del Puesto
	 * 
	 * @param idUsuario
	 * @return Nombre puesto
	 */
	public static String NombrePuesto(String idUsuario) {
		String resultado = "";
		if (idUsuario == null || idUsuario.equals("")
				|| idUsuario.equalsIgnoreCase("null")) {
			return null;
		}
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.NombrePuesto(idUsuario));
			if (strResult != null && strResult.length > 0)
				resultado = strResult[0][0];
		} catch (SQLException sqle) {
			System.err.println("ActualizaUsuario.NombrePuesto(...): "
					+ SQLUsuario.NombrePuesto(idUsuario) + "\n"
					+ sqle.getMessage());
			sqle.printStackTrace();
		}
		return resultado;
	}

	/**
	 * Nombre y mail de un usuario
	 * 
	 * @param idUsuario
	 *            Id usuario
	 * @return Arreglo con los datos de un usuario
	 */
	public static String[][] NombreMailUsuario(String idUsuario) {
		try {
			String strsql = SQLUsuario.NombreMailUsuario(idUsuario);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Verifica si existe usuarios con estatus 1
	 * 
	 * @return true si existe
	 */
	public static boolean getExistenUsuarios() {
		int r = 0;
		String SQL = "SELECT * FROM SD_USUARIO WHERE USU_ESTATUS=1";
		try {
			String strsql = SQL;
			// //System.out.println("getExistenUsuarios:"+SQL);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResultado.length > 0)
				return true;

			// //System.out.println("="+false);
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExistenAsuntosTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Función que ejecuta un query que trae una lista de los usuarios que tiene
	 * el rol de turnadores
	 * 
	 * @return Regresa arreglo de usuarios por rol de turnado
	 */
	public static String[][] getUsuarioPorRol(String strIdArea) {
		try {
			String strsql = SQLUsuario.getUsuarioPorRol(strIdArea);
			// //System.out.println("getUsuarioPorRol:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioPorRol:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Usuarios a notificar
	 * 
	 * @return regresa arreglo de usuarios a arreglar
	 */
	public static String[][] getUsuarioNotificar() {
		try {
			String strsql = SQLUsuario.getUsuarioNotificar();
			// //System.out.println("getUsuarioNotificar:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioNotificar:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Puesto, Nombre y área de un usuario
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return regresa arreglo de los datos de un usuario
	 */
	public static String[][] getNombreCargoAreaUsr(String strIdUsuario) {
		try {
			String strsql = SQLUsuario.getNombreCargoAreaUsr(strIdUsuario);
			// //System.out.println("getNombreCargoAreaUsr:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getNombreCargoAreaUsr:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query donde se cambia el valor del campo de la
	 * tabla USU_ACTIVO a 0
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario que sera suspendido
	 * @return True
	 */
	public static boolean SuspenderUsuario(String strNombre) {
		int r = 0;
		try {
			String strsql = SQLUsuario.SuspenderUsuario(strNombre);
			// //System.out.println("SuspenderUsuario:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("SuspenderUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query donde retorna el Número de veces que un
	 * usuario a entrado al sistema
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return Numero de veces que ha entrado al sistema
	 */
	public static int getIntentos(String strNombre) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getIntentos(strNombre));

			if (strResult != null && strResult.length > 0)
				return new Integer(strResult[0][0]).intValue();
			return 0;
		} catch (SQLException sqle) {
			// System.out.println("getIntentos:"+sqle);
			sqle.printStackTrace();
			return 0;
		}
	}

	/**
	 * Función que ejecuta un qury donde se actualiza el numero de intentos de
	 * un usuario al acceder al sistema
	 * 
	 * @param iIntentos
	 *            Int Numero de intentos
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return True
	 */
	public static boolean UpdateIntentos(int iIntentos, String strNombre) {
		int r = 0;
		try {
			String strsql = SQLUsuario.UpdateIntentos(iIntentos, strNombre);
			// //System.out.println("UpdateIntentos:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("UpdateIntentos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que ejecuta un query donde trae el ultimo Id del usuario que ha
	 * sido registrado
	 * 
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String getUltimoIDUsuario() {
		try {
			String strsql = SQLUsuario.getUltimoIDUsuario();
			// //System.out.println("getUltimoIDUsuario:"+strsql);
			String IdMax[][] = ConexionDS.ejecutarSQL(strsql);
			if (IdMax != null && IdMax.length > 0)
				return IdMax[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getUltimoIDUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa el Id del usuario con el parametro del uid
	 * 
	 * @param UID
	 *            uid del usuario
	 * @return id usuario
	 */
	public static String getIdUsuarioUID(String UID, String idArea) {
		try {
			String strsql = SQLUsuario.getIdUsuarioUID(UID, idArea);
			// //System.out.println("getUltimoIDUsuario:"+strsql);
			String IdMax[][] = ConexionDS.ejecutarSQL(strsql);
			if (IdMax != null && IdMax.length > 0)
				return IdMax[0][0];
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getIdUsuarioUID:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Función que ejecuta un query, donde regresa el Id del Area al que
	 * pertenece un usuario
	 * 
	 * @param idUsuario
	 *            Contiene el Id del Usuario
	 * @return strResult[0][0]
	 */
	public static String getIdUsrArea(String idUsuario) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getIdUsrArea(idUsuario));

			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getIdUsrArea:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Nombre y mail del usuario
	 * 
	 * @param idUsuario
	 *            id usuario
	 * @return regresa arreglo de usuario
	 */
	public static String[][] getMailCargoUsuario(String idUsuario) {
		String SQL = "SELECT USU_CARGO, USU_CORREO FROM SD_USUARIO WHERE ID_USUARIO="
				+ idUsuario;
		try {
			// //System.out.println("getMailCargoUsuario:"+SQL);
			return ConexionDS.ejecutarSQL(SQL);
		} catch (SQLException sqle) {
			// System.out.println("getNombreCargoAreaUsr:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Cambio de nombre
	 * 
	 * @param strCadena
	 *            Cadena
	 * @return String con el cambio de nombre
	 */
	public static String cambiarNombre(String strCadena) {
		String strNombre = "";
		int iComa = 0;
		int iIgual = 0;
		String strAux = "";

		iComa = strCadena.indexOf(',');
		iIgual = strCadena.indexOf('=');

		if ((iComa >= 0) && (iComa < iIgual)) {
			strNombre = strCadena.substring(0, iComa);
			strAux = cambiarNombre(strCadena.substring(iComa + 1));
			if (strAux.length() > 0) {
				strNombre += "/" + strAux;
			}
		} else if ((iIgual >= 0) && (iIgual < iComa)) {
			strNombre = strCadena.substring(iIgual + 1, iComa);
			strAux = cambiarNombre(strCadena.substring(iComa + 1));
			if (strAux.length() > 0) {
				strNombre += "/" + strAux;
			}
		} else if ((iIgual >= 0) && iComa < 0) {
			strNombre = strCadena.substring(iIgual + 1);
		} else if (iComa == iIgual) {

			return "";
		}

		return strNombre;
	}

	/**
	 * Nombre, mail y área de los supervisores o responsables de un área
	 * 
	 * @return regresa arreglo de los datos de un responsable del área
	 */
	public static String[][] getCorreoNombreResponsableArea() {
		try {
			String strsql = SQLUsuario.getCorreoNombreResponsableArea();
			// //System.out.println("getCorreoNombreResponsableArea:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getCorreoNombreResponsableArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query, donde se crea una lista de los usuarios
	 * pertenecientes a un area
	 * 
	 * @param getUsuariosPorArea
	 * @return regresa arreglo de usuarios por área
	 */
	public static String[][] getUsuariosPorArea(String getUsuariosPorArea,
			String strOrden, String tipo) {
		try {
			String strsql = SQLUsuario.getUsuariosPorArea(getUsuariosPorArea,
					strOrden, tipo);
			// //System.out.println("getUsuariosPorArea:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getUsuariosPorArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query, donde se crea una lista de los usuarios
	 * pertenecientes a un Area y sus Roles
	 * 
	 * @param getUsuariosPorArea
	 * @return regresa arreglo de usuarios por área
	 */
	public static String[][] getUsuariosPorAreaRol(String getUsuariosPorArea,
			String strIdRol, String strOrden, String tipo) {
		try {
			String strsql = SQLUsuario.getUsuariosPorAreaRol(
					getUsuariosPorArea, strIdRol, strOrden, tipo);
			// //System.out.println("getUsuariosPorArea:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getUsuariosPorAreaRol:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query, donde se crea una lista de los roles
	 * pertenecientes a una Area
	 * 
	 * @param getUsuariosPorArea
	 * @return regresa arreglo de usuarios por área
	 */
	public static String[][] getRolesPorArea(String getUsuariosPorArea) {
		try {
			String strsql = SQLUsuario.getRolesPorArea(getUsuariosPorArea);
			// //System.out.println("getUsuariosPorArea:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getRolesPorArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Usuarios del área con el rol de atención
	 * 
	 * @param getUsuariosPorArea
	 *            Id usuario
	 * @return regresa arreglo de los usuarios con el rol de atención
	 */
	public static String[][] getUsuarioAreaAtencion(String getUsuariosPorArea) {
		try {
			String strsql = SQLUsuario
					.getUsuarioAreaAtencion(getUsuariosPorArea);
			// //System.out.println("getUsuariosPorArea:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getUsuariosPorArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de ids de las áreas por usuario
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return regresa arreglo de ids de áreas
	 */
	public static String[][] getIdsAreas(String strIdUsuario) {
		try {
			String strsql = SQLUsuario.getIdsAreas(strIdUsuario);
			// //System.out.println("getIdsAreas:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getIdsAreas:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Verifica si el usuario tiene puestos hijos
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return true si tiene puestos hijos
	 */
	public static boolean tieneHijosAreas(String strIdUsuario) {
		int r = 0;
		try {
			String strSql = SQLUsuario.getIdsAreas(strIdUsuario);

			// //System.out.println("tieneHijos="+strSql);
			//
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// //System.out.println("tieneHijos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Lista de usuarios externos
	 * 
	 * @param getUsuariosPorArea
	 *            id usuario
	 * @return regresa arreglo de usuarios
	 */
	public static String[][] getUsuarioAreaAtencionE(String getUsuariosPorArea) {
		try {
			String strsql = SQLUsuario
					.getUsuarioAreaAtencionE(getUsuariosPorArea);
			// //System.out.println("getUsuariosPorArea:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getUsuariosPorArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Funcion que verifica a que área pertenece un usuario
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return Id área
	 */
	public static String getIdAreaUs(String strIdUsuario) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getIdAreaUs(strIdUsuario));
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getIdAreaUs:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de los ids de los turnadores de un área
	 * 
	 * @param strIdArea
	 *            id área
	 * @return regresa arreglo de la lista de ids de turnadores
	 */
	public static String[][] getIdUsuarioTurnador(String strIdArea) {
		try {
			String strsql = SQLUsuario.getIdUsuarioTurnador(strIdArea);
			// //System.out.println("getIdUsuarioTurnador:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getIdUsuarioTurnador:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Total de instrucciones por usuario
	 * 
	 * @param strIdUsuario
	 * @return true si no tiene instrucciones
	 */
	public static boolean getCountInstruccion(String strIdUsuario) {
		boolean bTiene = false;
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getCountInstruccion(strIdUsuario));
			// //System.err.println("getCountInstruccion:"+SQLUsuario.getCountInstruccion(strIdUsuario));
			if (strResult != null && strResult.length > 0) {
				if (strResult[0][0].equals("0"))
					bTiene = true;
				else
					bTiene = false;
			}

		} catch (SQLException sqle) {
			// System.out.println("getCountInstruccion:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}

	/**
	 * Total de asuntos por usuario
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return true si no tiene
	 */
	public static boolean getCountAsunto(String strIdUsuario) {
		boolean bTiene = false;
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getCountAsunto(strIdUsuario));
			// System.err.println("getCountAsunto:"+SQLUsuario.getCountAsunto(strIdUsuario));
			if (strResult != null && strResult.length > 0) {
				if (strResult[0][0].equals("0"))
					bTiene = true;
				else
					bTiene = false;
			}

		} catch (SQLException sqle) {
			// System.out.println("getCountAsunto:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}

	/**
	 * Verifica si existen destinatarios por usuario
	 * 
	 * @param strIdUsuario
	 *            id usuario
	 * @return true si no tiene
	 */
	public static boolean getExisteParaCC(String strIdUsuario) {
		boolean bTiene = false;
		int iTiene = 0;
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getExisteParaCC());
			// //System.err.println("getExisteParaCC:"+SQLUsuario.getExisteParaCC());//strIdUsuario));
			if (strResult != null && strResult.length > 0) {
				for (int i = 0; i < strResult.length; i++) {
					if (strResult[i][0] != null
							&& strResult[i][0].length() != 0) {
						StringTokenizer strtST = new StringTokenizer(
								strResult[i][0], ",");
						while (strtST.hasMoreElements()) {
							String aux = strtST.nextToken();
							// //System.err.println("ParaCC1: " + aux + " ---- "
							// + iTiene);
							if (strIdUsuario.equals(aux))
								iTiene++;
						}
					}
					if (strResult[i][1] != null
							&& strResult[i][1].length() != 0) {
						StringTokenizer strtSTCC = new StringTokenizer(
								strResult[i][1], ",");
						while (strtSTCC.hasMoreElements()) {
							String aux = strtSTCC.nextToken();
							// //System.err.println("ParaCC2: " + aux + " ---- "
							// + iTiene);
							if (strIdUsuario.equals(aux))
								iTiene++;
						}
					}
				}

			}

		} catch (SQLException sqle) {
			// System.out.println("getCountAsunto:"+sqle);
			sqle.printStackTrace();
		}
		if (iTiene == 0)
			bTiene = true;
		else
			bTiene = false;
		return bTiene;
	}

	/**
	 * Total de remitentes por usuario
	 * 
	 * @param strIdUsuario
	 *            id usuario
	 * @return true si no tiene
	 */
	public static boolean getCountRemitenteAsunto(String strIdUsuario) {
		boolean bTiene = false;
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getCountRemitenteAsunto(strIdUsuario));
			// //System.err.println("getCountRemitenteAsunto:"+SQLUsuario.getCountRemitenteAsunto(strIdUsuario));
			if (strResult != null && strResult.length > 0) {
				if (strResult[0][0].equals("0"))
					bTiene = true;
				else
					bTiene = false;
			}

		} catch (SQLException sqle) {
			// System.out.println("getCountRemitenteAsunto:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}

	/**
	 * Total de usuarios por jefe
	 * 
	 * @param strIdUsuario
	 *            id usuario jefe
	 * @return true si no tiene
	 */
	public static boolean getCountJefe(String strIdUsuario) {
		boolean bTiene = false;
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getCountJefe(strIdUsuario));
			// //System.err.println("getCountJefe:"+SQLUsuario.getCountJefe(strIdUsuario));
			if (strResult != null && strResult.length > 0) {
				if (strResult[0][0].equals("0"))
					bTiene = true;
				else
					bTiene = false;
			}

		} catch (SQLException sqle) {
			// System.out.println("getCountJefe:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}

	/**
	 * Verifica si existe el puesto
	 * 
	 * @param strNombre
	 *            Nombre del puesto o usuario
	 * @param strAux
	 *            Auxiliar
	 * @param strArea
	 *            área
	 * @param strAux2
	 *            Auxiliar 2
	 * @return 1 si existe, 2 no existe
	 */
	public static int getPuestoExiste(String strNombre, String strAux,
			String strArea, String strAux2) {
		try {
			String strSQL = SQLUsuario.getPuestoExiste(strNombre.trim(), strAux
					.trim(), strArea.trim(), strAux2.trim());
			String strResult[][] = ConexionDS.ejecutarSQL(strSQL);
			// //System.out.println("getPuestoExiste:" + strSQL);
			if (strResult != null && strResult.length > 0) {
				return 1;
			} else
				return 2;
		} catch (SQLException sqle) {
			// System.out.println("getPuestoExiste:"+sqle);
			sqle.printStackTrace();
			return -1;
		}
	}

	/**
	 * Verifica si exsite responsable
	 * 
	 * @param strCargo
	 *            Nombre
	 * @param strAux
	 *            Auxiliar
	 * @return 1 si existe, 2 no existe
	 */
	public static int getResponsableExiste(String strCargo, String strAux) {
		try {
			String strSQL = SQLUsuario.getResponsableExiste(strCargo.trim(),
					strAux.trim());
			String strResult[][] = ConexionDS.ejecutarSQL(strSQL);
			// //System.out.println("getResponsableExiste:" + strSQL);
			if (strResult != null && strResult.length > 0) {
				return 1;
			} else
				return 2;
		} catch (SQLException sqle) {
			// System.out.println("getResponsableExiste:"+sqle);
			sqle.printStackTrace();
			return -1;
		}
	}

	/**
	 * Función que verifica si existe un usuario para ser autentificado por LDAP
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return True SI existe, False si no existe
	 */
	public static boolean getExisteUsuario(String strNombre) {
		int r = 0;
		int nusuario = 0;
		try {
			String strsql = SQLUsuario.getBuscaUsuarioNombre(strNombre);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			nusuario = new Integer(strResultado[0][0]).intValue();
		} catch (SQLException sqle) {
			// System.out.println("getExisteUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario = 0;
		} catch (NumberFormatException nfe) {
			nusuario = 0;
		}

		if (nusuario == 0)
			return false;
		return true;
	}

	/**
	 * Función que ejecuta un query donde se cambia el valor del campo de la
	 * tabla USU_ACTIVO a 0
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario que sera suspendido
	 * @return True
	 */
	public static boolean resetIntentos(String strNombre) {
		int r = 0;
		try {
			String strsql = SQLUsuario.resetIntentos(strNombre);
			// //System.out.println("resetIntentos:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("resetIntentos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}
	public static boolean esAdmin(String strNombre) {
		int r = 0;
		int nusuario = 0;
		try {
			String strsql = SQLUsuario.IsAdmin(strNombre);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			nusuario = new Integer(strResultado[0][0]).intValue();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			nusuario = 0;
		} catch (NumberFormatException nfe) {
			nusuario = 0;
		}
		if (nusuario == 0)
			return false;
		return true;
	}

	/**
	 * Id Usuario por el UID
	 * 
	 * @param UID
	 *            UID
	 * @return Id del usuario
	 */
	public static String getIdUsuario(String UID) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getIdUsuario(UID));

			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getIdUsuario:"+sqle);
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Lista de remitente por unidad o área(entidad)
	 * 
	 * @param strIdEntidad
	 *            id Entidad(área)
	 * @return regresa arreglo de los usuarios por entidad
	 */
	public static String[][] getRemitenteXEntidad(String strIdEntidad) {
		try {
			String strsql = SQLUsuario.getRemitenteXEntidad(strIdEntidad);
			// //System.out.println("getRemitenteXEntidad:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getRemitenteXEntidad:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query con la lista de usuarios con el rol de
	 * atención de un area
	 * 
	 * @param strIdArea
	 * @return usuarios con rol de atención
	 */
	public static String[][] getUsuarioAtencion(String strIdArea) {
		try {
			String strsql = SQLUsuario.getUsuarioAtencion(strIdArea);
			// //System.out.println("getUsuarioAtencion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioAtencion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query con la lista de usuarios con el rol de
	 * atención de un area
	 * 
	 * @param strIdArea
	 * @return Nombre/Puesto por rol de atención
	 */
	public static String[][] getPuestoUsuarioAtencion(String strIdArea) {
		try {
			String strsql = SQLUsuario.getPuestoUsuarioAtencion(strIdArea);
			// //System.out.println("getUsuarioAtencion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getPuestoUsuarioAtencion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Id usuario que turno un asunto o instrucción
	 * 
	 * @param strIdUsuario
	 *            id usuario
	 * @param strIdInstruccion
	 *            instrucción
	 * @return Id usuario
	 */
	public static String getUsuarioTurno(String strIdUsuario,
			String strIdInstruccion) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getUsuarioTurno(strIdUsuario, strIdInstruccion));
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioTurno(..):
			// "+SQLUsuario.getUsuarioTurno(strIdUsuario,
			// strIdInstruccion)+"\n"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Cdena de mando por un usuario
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return Cadena de mando
	 */
	public static String getCadenaMando(String strIdUsuario) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getCadenaMando(strIdUsuario));

			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "";
		} catch (SQLException sqle) {
			// //System.out.println("getCadenaMando:"+sqle);
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Estatus del usuario
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return estatus
	 */
	public static String getEstatusUsuario(String strIdUsuario) {
		try {
			String strsql = SQLUsuario.getEstatusUsuario(strIdUsuario);
			// //System.out.println("getEstatusUsuario:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			else
				return "";
		} catch (SQLException sqle) {
			// System.out.println("getEstatusUsuario:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Id de usuarios que asiste un asistente
	 * 
	 * @param strIdAsistente
	 *            id asistente
	 * @return regresa arreglo de ids de usuarios
	 */
	public static String[][] getIdsUsAsistente(String strIdAsistente) {
		if (strIdAsistente == null || strIdAsistente.equals("")
				|| strIdAsistente.equalsIgnoreCase("null")) {
			return null;
		}
		try {
			String strsql = SQLUsuario.getIdsUsAsistente(strIdAsistente);
			// System.out.println("getIdsUsAsistente:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getIdsUsAsistente:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Verifica si envio notificación por mail
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return true si hizo la notificación
	 */
	public static boolean getNotificacionMail(String strIdUsuario) {
		try {
			String strsql = SQLUsuario.getNotificacionMail(strIdUsuario);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0
					&& strResult[0][0].equals("0"))
				return true;
			else
				return false;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Uid del usuario
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return UID
	 */
	public static String getUID(String strIdUsuario) {
		try {
			String strsql = SQLUsuario.getUID(strIdUsuario);
			// //System.out.println("getUID:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			else
				return "";
		} catch (SQLException sqle) {
			// System.out.println("getUID:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Id área del usuario
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return id área
	 */
	public static String getAreaUsuario(String strIdUsuario) {
		String strsql = "";
		String resultado = "";
		if (strIdUsuario == null || strIdUsuario.equals("")
				|| strIdUsuario.equalsIgnoreCase("null")) {
			return "";
		}
		try {
			strsql = SQLUsuario.getAreaUsuario(strIdUsuario);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0)
				resultado = strResult[0][0];
		} catch (SQLException sqle) {
			// System.out.println("ActualizaUsuario.getAreaUsuario(...):
			// "+strsql+"\n"+sqle.getMessage());
			sqle.printStackTrace();
		}
		return resultado;
	}

	/**
	 * Datos de un usuario par alos destinatarios externos
	 * 
	 * @param strIdArea
	 *            id área
	 * @return regresa arreglo de destinatarios externos
	 */
	public static String[][] getUsuarioDesExt(String strIdArea) {
		try {
			String strsql = SQLUsuario.getUsuarioDesExt(strIdArea);
			// //System.out.println("getUsuarioDesExt:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioDesExt:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Id usuario responsable de un área
	 * 
	 * @param Responsable
	 *            Id usuario responsable
	 * @return Id usuario
	 */
	public static String getIdUsuarioxResponsable(String Responsable) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getIdUsuarioxResponsable(Responsable));
			// //System.out.println("getIdUsuarioxResponsable:"+SQLUsuario.getIdUsuarioxResponsable(Responsable));
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getIdUsuarioxResponsable:"+sqle);
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Verifica si el usuario es del rol de atención
	 * 
	 * @param strIdUsuario
	 *            Id usuario
	 * @return true si es de atención
	 */
	public static boolean getEsAtencion(String strIdUsuario) {
		try {
			String strsql = SQLUsuario.getEsAtencion(strIdUsuario);
			// //System.out.println("getEsAtencion:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult.length > 0)
				return true;
			else
				return false;
		} catch (SQLException sqle) {
			// System.err.println("getEsAtencion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Id supervisor
	 * 
	 * @param strIdArea
	 *            Id area
	 * @return id del usuario y nombre/puesto
	 */
	public static String[][] getIdSupervisor(String strIdArea) {
		try {
			String strsql = SQLUsuario.getIdSupervisor(strIdArea);
			// //System.out.println("getUsuarioDesExt:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getIdSupervisor:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de los subordinados directos del Puesto
	 * 
	 * @param idUsuario
	 *            Id del Puesto Jefe
	 * @param strIdArea
	 *            Id área o UA
	 * @return Devuelve un arreglo con la lista de subordinados
	 */
	public static String[][] getSubalternosSubVentanilla(String idUsuario,
			String strIdArea) {
		try {
			String strsql = SQLUsuario.getSubalternosSubVentanilla(idUsuario,
					strIdArea);
			// //System.out.println("getSubalterno:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getSubalternosSubVentanilla:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Combo con la lista de Puestos con Roles de atención
	 * 
	 * @param strIdArea
	 * @return Combo de usuarios de atención
	 */
	public static String getComboAtencion(String strIdArea, String strSubVent) {
		String strHtml = "";

		JerarquiaAtencion tree = null;
		Vector vNombrePuesto = null;
		Vector vIds = null;
		String strSub[][] = null;
		String strSup[][] = ActualizaUsuario.getIdSupervisor(strIdArea);
		boolean bEsAtencion = false;
		if (strSup.length != 0) {
			strSub = ActualizaUsuario.getSubalternosSubVentanilla(strSup[0][0],
					strIdArea);
			tree = new JerarquiaAtencion(strSub, strIdArea);

			vNombrePuesto = tree.getNombrePuesto();
			vIds = tree.getIds();

			strHtml += "<OPTION value='" + strSup[0][0] + "' "
					+ (strSup[0][0].equals(strSubVent) ? "selected" : "")
					+ ">1-" + strSup[0][1] + "</OPTION>";
			for (int i = 0; i < vIds.size(); i++) {
				if (ActualizaUsuario.getEsAtencion((String) vIds.get(i)))
					strHtml += "<OPTION value='"
							+ vIds.get(i)
							+ "' "
							+ (vIds.get(i).equals(strSubVent) ? "selected" : "")
							+ ">" + vNombrePuesto.get(i) + "</OPTION>";
			}
		}
		return strHtml;
	}

	/**
	 * Datos del usuario de subventanilla que atendera el turnador
	 * 
	 * @param strIdUsuario
	 *            id usuario
	 * @return arreglo con los los datos del turnador
	 */
	public static String[][] getSubalternosTurnador(String strIdUsuario) {
		try {
			String strsql = SQLUsuario.getSubalternosTurnador(strIdUsuario);
			// //System.out.println("getSubalterno:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getSubalternosTurnador:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Datos del usuario de subventanilla que atendera el turnador
	 * 
	 * @param strIdUsuario
	 *            id usuario
	 * @return arreglo con los los datos del turnador
	 */
	public static String[][] getSubalternosTurnadorSub(String strIdUsuario) {
		try {
			String strsql = SQLUsuario.getSubalternosTurnadorSub(strIdUsuario);
			// //System.out.println("getSubalterno:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getSubalternosTurnadorSub:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Nombre y puesto del usuario
	 * 
	 * @param idUsuario
	 *            Id del usuario
	 * @return Nombre y puesto del usuario
	 */
	public static String getUsuarioPuesto(String idUsuario) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLUsuario
					.getUsuarioPuesto(idUsuario));
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getUsuarioPuesto:"+sqle);
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa un arreglo con los IDS de los asistentes asignados a un rol de
	 * atención
	 * 
	 * @param idusuario
	 *            id Usuario de atención
	 * @return IDS asistentes
	 */
	public static String[] getAsistentes(String idusuario) {
		try {
			String consulta[][] = null;
			String asistente[] = new String[0];
			String strsql = SQLUsuario.getAsistentes(idusuario);
			consulta = ConexionDS.ejecutarSQL(strsql);
			if (consulta.length > 0 && consulta != null) {
				asistente = new String[consulta.length];
				for (int i = 0; i < consulta.length; i++)
					asistente[i] = consulta[i][0];
			}
			return asistente;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que verifica si el usuario que consulta es asistente y esta
	 * dentro de la lista de los asistentes del rol de atención
	 * 
	 * @param idUsuario
	 *            Id del asistente
	 * @param arreglo
	 *            ids de los asistetes asignados al rol de atención
	 * @return true si forma parte de los asistentes del rol de atención
	 */
	public static boolean esAsistente(String idUsuario, String arreglo[]) {
		boolean existe = false;
		for (int i = 0; i < arreglo.length; i++) {
			if (idUsuario.equals(arreglo[i]))
				existe = true;
		}
		return existe;
	}

	/**
	 * Query que regresa a los usuarios que son subordinados directos que
	 * pertenescan a la UA del usuario
	 * 
	 * @param idUsuario
	 *            id Usuario
	 * @param idArea
	 *            id área
	 * @return Arreglo
	 */
	public static String[][] getSubordinadosDirectos(String idUsuario,
			String idArea) {
		try {
			String strsql = SQLUsuario.getSubordinadosDirectos(idUsuario,
					idArea);
			// //System.err.println("getSubordinadosDirectos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getSubordinadosDirectos:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Query que regresa a los usuarios que son subordinados de otras UA's
	 * 
	 * @param idUsuario
	 *            id Usuario
	 * @param idArea
	 *            id área
	 * @return Arreglo
	 */
	public static String[][] getSubordinadosOtraUA(String idUsuario,
			String idArea) {
		try {
			String strsql = SQLUsuario.getSubordinadosOtraUA(idUsuario, idArea);
			// //System.err.println("getSubordinadosOtraUA:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getSubordinadosOtraUA:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de subordinados de un usuario
	 * 
	 * @param idUsuario
	 *            id usuario
	 * @return regresa arreglo de subalternos
	 */
	public static String[][] getSubordinados(String idUsuario) {
		try {
			String strsql = SQLUsuario.getSubordinados(idUsuario);
			// System.out.println("ActualizaUsuario.getSubalterno:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getSubordinados:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * muestra los usuarios que han rechazado instrucciones a cierta persona
	 * 
	 * @param idUsuario
	 *            Id usuario
	 * @return Query
	 */
	public static String[][] getInsRechazadas(String idUsuario) {
		try {
			String strsql = SQLUsuario.getInsRechazadas(idUsuario);
			// System.out.println("getInsRechazadas:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getInsRechazadas:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de subalternos sin rol
	 * 
	 * @param idUsuario
	 *            id usuario
	 * @return regresa arreglo de subalternos sin rol
	 */
	public static String[][] getSubordinadosSinRol(String idUsuario) {
		try {
			String strsql = SQLUsuario.getSubordinadosSinRol(idUsuario);
			// //System.out.println("getSubalterno:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getSubordinadosSinRol:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	public static String getJSUsuarioArea(String usuarioID) {
		List areasUsu = Autenticacion.getUsuarioAreas(usuarioID.trim());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < areasUsu.size(); i++) {
			sb.append("\\n");
			sb.append("- ");
			sb.append(((AreaBean) areasUsu.get(i)).getNombreArea());
		}
		return sb.toString();
	}
	
	public static boolean getEnviaEmailRespIns(ServletContext contexto, String idUsuario){
		if (contexto.getAttribute("app.siga.enviaEmail.RespIns")==null || contexto.getAttribute("app.siga.enviaEmail.RespIns")==""){
			return false;
		}
		else{
			String uas = contexto.getAttribute("app.siga.enviaEmail.RespIns").toString();		
			if (uas != null) {
				StringTokenizer st = new StringTokenizer(uas, ",");
				while (st.hasMoreTokens()) {
					String token = st.nextToken();				
					if (idUsuario.equals(token.trim())) {
						return true;
					}
				}
			}
			return false;
		}
	}				
}
