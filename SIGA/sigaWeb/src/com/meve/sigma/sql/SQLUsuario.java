/*
 * Created on Aug 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.meve.sigma.sql;

/**
 * Clase que contiene metodos que contruyen sentencias sql para la actualizacion
 * y lectura de la tabla USUARIO
 * 
 * @author Rodrigo Soto Ch. rodrigo_s_ch@yahoo.com.mx
 * @version 1.0
 * @see http://java.sun.com/
 */
public class SQLUsuario {
	/**
	 * 
	 * @param DN
	 * @return
	 */
	public static String getUsuario(String DN) {
		String strSql = "";
		strSql = "SELECT  USU_NOMBRE, USU_AREA, USU_CARGO, USU_CORREO,"
				+ " USU_TELEFONO, USU_INTENTOS, USU_JEFE,"
				+ " USU_ASISTENTE, USU_USR_ACTUALIZO, "
				+ " TO_CHAR(USU_FEC_ACTUALIZACION, 'dd/MM/yyyy HH:MI:SS AM'), "
				+ " USU_ROL, USU_FIRMA, USU_ACTIVO, USU_UID, "
				+ " USU_CAT, USU_NOTIFICACION, USU_BANDERA, USU_SUBVENTANILLA "
				+ " FROM SD_USUARIO" + " WHERE ID_USUARIO=" + DN;
		return strSql;
	}

	/**
	 * Función que regresa un query, donde se inserta el registro de un usuario
	 * 
	 * @param nombre
	 *            Nombre del usuario
	 * @param idArea
	 *            ID del area al que va a pertenecer el usuario
	 * @param cargo
	 *            Cargo que ejerce el usuario
	 * @param correo
	 *            Mail del usuario
	 * @param telefono
	 *            Telefono del usuario
	 * @param consecutivo
	 *            Numero consecutivo de las veces que ha entrado el usuario a la
	 *            aplicación
	 * @param jefe
	 *            Id del jefe
	 * @param asistente
	 *            ID de Asistente
	 * @param actualizo
	 *            Id del usuario que registra al nuevo usuario
	 * @param fecha
	 *            fecha en la que se ha registrado el usuario
	 * @param estatus
	 * @return SQL;
	 */
	public static String getInsertaUsuario(String nombre, String idArea,
			String cargo, String correo, String telefono, String consecutivo,
			String jefe, String asistente, String actualizo, String fecha,
			String estatus, String UID) {
		String sql = "";
		sql = "INSERT INTO SD_USUARIO (ID_USUARIO, USU_NOMBRE, USU_AREA, USU_CARGO, USU_CORREO, USU_TELEFONO,"
				+ " USU_INTENTOS, USU_JEFE, USU_ASISTENTE, USU_USR_ACTUALIZO, USU_FEC_ACTUALIZACION, USU_ESTATUS, USU_UID, USU_FIRMA)"
				+ " VALUES (SD_USUARIO_SEQ.NEXTVAL,'"
				+ nombre
				+ "', "
				+ idArea
				+ ", '"
				+ cargo
				+ "', '"
				+ correo
				+ "', '"
				+ telefono
				+ "', "
				+ consecutivo
				+ ", "
				+
				// " "+jefe+", "+asistente+", "+actualizo+", '"+fecha+"',
				// "+estatus+", '"+UID+"', ?)";
				" "
				+ jefe
				+ ", "
				+ asistente
				+ ", "
				+ actualizo
				+ ", SYSDATE, " + estatus + ", '" + UID + "', ?)";
		return sql;
	}

	/**
	 * 
	 * @param nombre
	 * @param idArea
	 * @param cargo
	 * @param correo
	 * @param telefono
	 * @param consecutivo
	 * @param jefe
	 * @param asistente
	 * @param actualizo
	 * @param fecha
	 * @param estatus
	 * @return
	 */
	public static synchronized String getInsertaUsuario1(String nombre,
			String idArea, String cargo, String correo, String telefono,
			String consecutivo, String jefe, String actualizo, String fecha,
			String estatus, String UID, String strCat, String strNotificacion,
			String strDesExt, String strSubVent) {
		String sql = "INSERT INTO SD_USUARIO (ID_USUARIO,USU_NOMBRE, USU_AREA, USU_CARGO, USU_CORREO, USU_TELEFONO,"
				+ " USU_INTENTOS, USU_JEFE, USU_USR_ACTUALIZO, "
				+ " USU_FEC_ACTUALIZACION, USU_ESTATUS, USU_UID, USU_CAT, USU_NOTIFICACION, USU_BANDERA, USU_SUBVENTANILLA)"
				+ " VALUES (SD_USUARIO_SEQ.NEXTVAL,'"
				+ nombre
				+ "', "
				+ idArea
				+ ", '"
				+ cargo
				+ "', "
				+ "'"
				+ correo
				+ "', '"
				+ telefono
				+ "', "
				+ consecutivo
				+ ","
				+ " "
				+ jefe
				+ ", "
				+ actualizo
				+ ", "
				+ "SYSDATE, "
				+ estatus
				+ ", '"
				+ UID
				+ "', "
				+ strCat
				+ ", "
				+ ""
				+ strNotificacion
				+ ", " + strDesExt + ", " + strSubVent + ")";
		return sql;
	}

	/**
	 * Configurando Historial
	 */
	public static String getInserHist(String id_usu, String idArea, String mes) {
		String sql = "";
		int mesc = Integer.parseInt(mes);
		sql = "INSERT INTO SD_CONFIG_HISTORIA (HIS_USUARIO, HIS_AREA, HIS_MES)"
				+ " VALUES ('" + id_usu + "','" + idArea + "', " + mesc + ")";
		return sql;
	}

	public static String getHisto(String id_usu, String idArea) {
		String strSql = "";
		strSql = "SELECT * FROM SD_CONFIG_HISTORIA WHERE HIS_USUARIO = '"
				+ id_usu + "' AND HIS_AREA = '" + idArea + "' ";
		return strSql;
	}

	public static String getActualizaHist(String id_usu, String idArea,
			String mes) {
		String sql = "";
		int mesc = Integer.parseInt(mes);
		sql = "UPDATE SD_CONFIG_HISTORIA SET HIS_MES = " + mesc
				+ " WHERE HIS_USUARIO='" + id_usu + "' AND  HIS_AREA= '"
				+ idArea + "'";
		return sql;
	}

	/**
	 * 
	 * @return
	 */
	public static String getUsuariosCombo() {
		String strSql = "";
		// strSql= "SELECT ID_USUARIO, USU_NOMBRE FROM SD_USUARIO " +
		strSql = "SELECT  ID_USUARIO, USU_CARGO FROM SD_USUARIO "
				+ "WHERE USU_ESTATUS=1 ORDER BY 2";
		return strSql;
	}

	/**
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getUsuariosCombo(String strIdArea) {
		String strSql = "";
		strSql = "SELECT  ID_USUARIO, USU_CARGO||'/'||USU_NOMBRE "
				+ "FROM SD_USUARIO " + "WHERE USU_AREA=" + strIdArea + " "
				+ "AND USU_ESTATUS=1 AND USU_ACTIVO = 1"
				+ "AND USU_NOMBRE <> 'Admin Sigma'  ORDER BY 2   ";
		return strSql;
	}

	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String getAreaUsuario(String idUsuario) {

		String strSql = "";
		strSql = "SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="
				+ idUsuario;
		return strSql;
	}

	/**
	 * 
	 * @return
	 */
	public static String getAreas() {

		return " SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA WHERE ARE_ESTATUS=1 ORDER BY 2";
	}

	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String getAsistenteDe(String idUsuario) {

		StringBuffer strSql = new StringBuffer(
				"SELECT * FROM SD_USUARIO ti INNER JOIN SD_USUARIO t2"/*
																		 * "select *
																		 * from
																		 * SD_USUARIO
																		 * t1
																		 * inner
																		 * join
																		 * sd_usuario
																		 * t2"
																		 */);
		strSql.append(" ON t1.ID_USUARIO=t2.USU_ASISTENTE AND t2.ID_USUARIO=");
		strSql.append(idUsuario);

		return strSql.toString();
	}

	public static String getJefesDeAsistente(String idUsuario) {

		// String sql = "SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_ASISTENTE =
		// " + idUsuario;
		String sql = "SELECT ASI_USUARIO FROM SD_ASISTENTES WHERE ASI_ASISTENTE="
				+ idUsuario;
		return sql;
	}

	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String getSubalternosDe(String idUsuario) {

		// StringBuffer strSql=new StringBuffer("SELECT ID_USUARIO, USU_CARGO
		// FROM SD_USUARIO WHERE USU_JEFE=");
		// strSql.append(idUsuario);
		String sql = "SELECT ID_USUARIO, USU_CARGO, USU_NOMBRE FROM SD_USUARIO, SD_USUARIO_ROL WHERE USU_JEFE="
				+ idUsuario
				+ " "
				+ "AND USU_ESTATUS=1 AND USU_ACTIVO=1 "
				+ "AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO "
				+ "AND USU_AREA IN (SELECT ID_AREA FROM SD_AREA WHERE ARE_ESTATUS = 1) "
				+ "AND ID_ROL=1 AND ID_USUARIO<>" + idUsuario + " ORDER BY 3";
		return sql;
	}

	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String getSubalternosSinRol(String idUsuario) {

		// StringBuffer strSql=new StringBuffer("SELECT ID_USUARIO, USU_CARGO
		// FROM SD_USUARIO WHERE USU_JEFE=");
		// strSql.append(idUsuario);
		String sql = "SELECT DISTINCT ID_USUARIO, USU_CARGO, USU_NOMBRE FROM SD_USUARIO, SD_USUARIO_ROL WHERE USU_JEFE="
				+ idUsuario
				+ " "
				+ "AND USU_ESTATUS=1 AND USU_ACTIVO=1 "
				+ "AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO AND ID_USUARIO<>"
				+ idUsuario
				+ " "
				+ "AND USU_AREA IN (SELECT ID_AREA FROM SD_AREA WHERE ARE_ESTATUS = 1) "
				+ "ORDER BY 3";

		return sql;
	}

	public static String getUsuariosArea(String idArea) {

		StringBuffer sqlStr = new StringBuffer(
				"SELECT * FROM SD_USUARIO WHERE USU_AREA = " /*
																 * "select *
																 * from
																 * SD_USUARIO
																 * where
																 * USU_AREA="
																 */);
		sqlStr.append(idArea);
		return sqlStr.toString();
	}

	/**
	 * 
	 * @param idArea
	 * @param idUsuario
	 * @return
	 */
	public static String getCompanierosArea(String idUsuario) {

		StringBuffer strSql = new StringBuffer(
				"SELECT * FROM SD_USUARIO t1 INNER ");
		strSql
				.append("JOIN SD_USUARIO t2 on t1.USU_AREA=t2.USU_AREA and t2.ID_USUARIO=");
		strSql.append(idUsuario);
		strSql.append(" AND t1.USU_ESTATUS=1 ");
		strSql.append(" AND t1.ID_USUARIO<>");
		strSql.append(idUsuario);
		strSql.append(" ORDER BY 2");

		return strSql.toString();
	}

	/**
	 * 
	 * @param nivel
	 * @param jefes
	 * @return
	 */
	public static String getJerarquia(int nivel, java.util.ArrayList jefes) {

		StringBuffer strSql = new StringBuffer();

		if (nivel == 0)
			strSql
					.append("SELECT * FROM SD_USUARIO WHERE USU_JEFE<0 AND USU_ESTATUS=1");
		else {

			strSql.append(" SELECT * FROM SD_USUARIO WHERE USU_ESTATUS=1 AND ");
			for (int i = 0; i < jefes.size(); i++) {
				if (jefes.get(i) instanceof com.meve.sigma.beans.UsuarioBean) {

					com.meve.sigma.beans.UsuarioBean usuario = (com.meve.sigma.beans.UsuarioBean) jefes
							.get(i);
					if (i < jefes.size() - 1) {
						strSql.append(" USU_JEFE=");
						strSql.append(usuario.getIdUsuario());
						strSql.append(" OR ");
					} else {

						strSql.append(" USU_JEFE=");
						strSql.append(usuario.getIdUsuario());
					}
				}
			}
		}
		return strSql.toString();
	}

	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String getJefeDe(String idUsuario) {
		String sql = "";
		sql = "SELECT USU_JEFE FROM SD_USUARIO WHERE ID_USUARIO=" + idUsuario;
		return sql;
	}

	public static String getNombreUsuario(String idUsuario) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO, USU_NOMBRE FROM SD_USUARIO WHERE ID_USUARIO="
				+ idUsuario + "";
		return strSql;
	}

	/**
	 * 
	 * @param strIds
	 * @return
	 */
	public static String getDeleteUsuario(String strIds, String strUid) {
		String strSql = "";
		// strSql="DELETE FROM SD_USUARIO WHERE ID_USUARIO IN("+strIds+")";
		strSql = "UPDATE SD_USUARIO SET USU_ESTATUS=0, USU_FEC_ACTUALIZACION=SYSDATE, "
				+ "USU_UID='', USU_UID_HISTORIAL='"
				+ strUid
				+ "' WHERE ID_USUARIO IN (" + strIds + ")";
		return strSql;
	}

	/**
	 * 
	 * @return
	 */
	public static String getUsuarios() {
		String strSql = "";
		strSql = "SELECT ID_USUARIO, USU_NOMBRE, ARE_NOMBRE, USU_AREA"
				+ " FROM SD_USUARIO , SD_AREA"
				+ " WHERE USU_ESTATUS=1 AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA"
				+ " AND ID_USUARIO <> 0" + " ORDER BY 3";
		return strSql;
	}

	/*
	 * public static String getUsuarios() { String strSql=""; strSql= "SELECT
	 * ID_USUARIO, USU_NOMBRE FROM ADMINISTRATOR.SD_USUARIOS ORDER BY
	 * USU_NOMBRE"; return strSql; }
	 */

	/**
	 * 
	 */
	public static String getActualizarUsuario(String idUsuario, String nombre,
			String idArea, String cargo, String correo, String telefono,
			String consecutivo, String jefe, String asistente,
			String actualizo, String fecha, String strActivo, String UID) {
		String strSql = "";
		strSql = "UPDATE SD_USUARIO SET " + "USU_NOMBRE='" + nombre
				+ "', USU_AREA=" + idArea + ", USU_CARGO='" + cargo + "', "
				+ "USU_CORREO='" + correo + "', USU_TELEFONO='" + telefono
				+ "', USU_INTENTOS=" + consecutivo + ", " + "USU_JEFE=" + jefe
				+ ", USU_ASISTENTE=" + asistente + ", USU_USR_ACTUALIZO="
				+ actualizo
				+ ", "
				+
				// "USU_FEC_ACTUALIZACION='"+fecha+"', USU_ACTIVO="+strActivo+",
				// USU_UID='"+UID+"', USU_FIRMA=? WHERE ID_USUARIO="+idUsuario;
				"USU_FEC_ACTUALIZACION=TO_DATE('" + fecha
				+ "', 'DD/MM/YYYY'), USU_ACTIVO=" + strActivo + ", USU_UID='"
				+ UID + "', USU_FIRMA=? WHERE ID_USUARIO=" + idUsuario;
		return strSql;
	}

	/**
	 * 
	 * @param idUsuario
	 * @param nombre
	 * @param idArea
	 * @param cargo
	 * @param correo
	 * @param telefono
	 * @param consecutivo
	 * @param jefe
	 * @param asistente
	 * @param actualizo
	 * @param fecha
	 * @param strActivo
	 * @param UID
	 * @return
	 */
	public static String getActualizarUsuario1(String idUsuario, String nombre,
			String idArea, String cargo, String correo, String telefono,
			String consecutivo, String jefe, String actualizo, String fecha,
			String strActivo, String UID, String strCat,
			String strNotificacion, String strDesExt, String strSubVent) {
		String strSql = "UPDATE SD_USUARIO SET " + "USU_NOMBRE='" + nombre
				+ "', USU_AREA=" + idArea + ", USU_CARGO='" + cargo + "', "
				+ "USU_CORREO='" + correo + "', USU_TELEFONO='" + telefono
				+ "', USU_INTENTOS=" + consecutivo + ", " + "USU_JEFE=" + jefe
				+ ", USU_USR_ACTUALIZO=" + actualizo + ", "
				+ "USU_FEC_ACTUALIZACION=SYSDATE, USU_ACTIVO=" + strActivo
				+ ", " + "USU_UID='" + UID + "', USU_CAT=" + strCat
				+ ", USU_NOTIFICACION=" + strNotificacion + ", "
				+ "USU_BANDERA=" + strDesExt + ", USU_SUBVENTANILLA="
				+ strSubVent + " " + "WHERE ID_USUARIO=" + idUsuario;
		return strSql;
	}

	/**
	 * 
	 * @param Dn
	 * @return
	 */
	public static String getUsuarioBean(String Dn) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO, USU_NOMBRE, USU_CARGO, "
				+ "USU_CORREO, USU_TELEFONO, USU_AREA, USU_FEC_ACTUALIZACION, "
				+ "USU_ESTATUS, USU_ASISTENTE, USU_JEFE, USU_USR_ACTUALIZO, "
				+ "USU_CONSECUTIVO, USU_ROL, USU_ACTIVO, USU_INTENTOS, USU_UID, USU_CAT "
				+ "FROM SD_USUARIO WHERE USU_ESTATUS=1 AND USU_UID='" + Dn
				+ "' ";
		return strSql;
	}
	
	/**
	 * 
	 * @param Dn
	 * @return
	 */
	public static String getUsuarioBeanArea(String usuario, String idArea) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO, USU_NOMBRE, USU_CARGO, "
				+ "USU_CORREO, USU_TELEFONO, USU_AREA, USU_FEC_ACTUALIZACION, "
				+ "USU_ESTATUS, USU_ASISTENTE, USU_JEFE, USU_USR_ACTUALIZO, "
				+ "USU_CONSECUTIVO, USU_ROL, USU_ACTIVO, USU_INTENTOS, USU_UID, USU_CAT "
				+ "FROM SD_USUARIO WHERE USU_ESTATUS=1 AND USU_UID='" + usuario +"' "
				+ " AND USU_AREA = '"+idArea+"' ";
		return strSql;
	}

	/**
	 * 
	 * @param IDUsuario
	 * @return
	 */
	public static String getIDUsuarioBean(String IDUsuario) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO, USU_AREA, USU_NOMBRE, USU_CARGO, USU_ASISTENTE, USU_BANDERA, USU_CAT "
				+ "FROM SD_USUARIO WHERE ID_USUARIO=" + IDUsuario + "";
		// System.out.println(strSql);
		return strSql;
	}

	/**
	 * Función que regresa un query, donde se verifica si el usuario ya existe,
	 * si existe no deja insertarlo por segunda vez
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return Query
	 */
	public static String getBuscaUsuarioNombre(String strNombre, String strAux) {
		String strSql = "";
		// strSql= "SELECT COUNT(*) FROM SD_USUARIO WHERE USU_ESTATUS=1 AND
		// USU_UID='"+strNombre+"'";
		strSql = "SELECT COUNT(*) FROM SD_USUARIO WHERE USU_UID='" + strNombre
				+ "' AND USU_UID <> '" + strAux + "' AND USU_ESTATUS=1";
		// //System.err.println("sql="+strSql);
		return strSql;
	}
	
	public static String getBuscaUsuarioNombreEnUnidad(String strNombre, String strAux, String areaId) {
		String strSql = "";
		// strSql= "SELECT COUNT(*) FROM SD_USUARIO WHERE USU_ESTATUS=1 AND
		// USU_UID='"+strNombre+"'";
		strSql = "SELECT COUNT(*) FROM SD_USUARIO WHERE USU_UID='" + strNombre
				+ "' AND USU_UID <> '" + strAux + "' AND USU_ESTATUS=1 AND USU_AREA = '"+areaId+"' "; 
		// //System.err.println("sql="+strSql);
		return strSql;
	}

	/**
	 * Función que regresa un query para verificar si el nombre del usuario es
	 * activo
	 * 
	 * @param strNombre
	 *            Nombre del Usuario
	 * @return strSql
	 */
	public static String getEsActivo(String strNombre) {
		String strSql = "";
		strSql = "SELECT COUNT(*) FROM SD_USUARIO, SD_AREA "
				+ "WHERE SD_AREA.ID_AREA=SD_USUARIO.USU_AREA "
				+ "AND USU_UID='" + strNombre + "' AND USU_ACTIVO=1 "
				+ "AND USU_ESTATUS=1 AND ARE_BANDERA=0";
		return strSql;
	}

	public static String getEsBorrado(String strNombre) {
		String strSql = "";
		// strSql= "SELECT COUNT(*) FROM SD_USUARIO WHERE USU_ACTIVO=1 AND
		// USU_UID='"+strNombre+"'";
		strSql = "SELECT COUNT(*) FROM SD_USUARIO WHERE USU_UID='" + strNombre
				+ "' AND USU_ESTATUS=0";
		return strSql;
	}

	/**
	 * Nombre del Usuario
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String NombreUsuario(String idUsuario) {
		String strSql = "";
		strSql = "SELECT USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO="
				+ idUsuario + "";
		return strSql;
	}

	/**
	 * Nombre del Puesto
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String NombrePuesto(String idUsuario) {
		String strSql = "";
		strSql = "SELECT USU_NOMBRE FROM SD_USUARIO WHERE ID_USUARIO="
				+ idUsuario + "";
		return strSql;
	}

	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String NombreMailUsuario(String idUsuario) {
		String strSql = "";
		strSql = "SELECT USU_NOMBRE, USU_CORREO,USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO="
				+ idUsuario + "";
		return strSql;
	}

	/**
	 * 
	 * @return
	 */
	public static String getUsuarioPorRol(String strIdArea) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO, USU_NOMBRE, USU_CARGO, ARE_NOMBRE, USU_CORREO, ID_AREA "
				+ "FROM SD_USUARIO, SD_AREA, SD_USUARIO_ROL "
				+ "WHERE USU_ESTATUS=1 AND ID_ROL=5 AND USU_ACTIVO=1 "
				+ "AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA "
				+ "AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO "
				+ "AND ID_AREA=" + strIdArea + " " + "ORDER BY 4";
		return strSql;
	}

	/**
	 * 
	 * @return
	 */
	public static String getUsuarioNotificar() {
		String strSql = "";
		strSql = "SELECT ID_USUARIO, USU_NOMBRE, USU_CORREO "
				+ "FROM SD_USUARIO, SD_AREA " + "WHERE USU_ESTATUS=1 "
				+ "AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA " + "ORDER BY 1";
		return strSql;
	}

	/**
	 * 
	 * @param strIdUsuario
	 * @return
	 */
	public static String getNombreCargoAreaUsr(String strIdUsuario) {
		String strSql = "";
		strSql = "SELECT USU_NOMBRE ,USU_CARGO, ARE_NOMBRE FROM SD_USUARIO, SD_AREA "
				+ "WHERE ID_USUARIO="
				+ strIdUsuario
				+ " "
				+ "AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA ";
		return strSql;
	}

	/**
	 * Función que regresa un query con el numero de intentos que ha realizado
	 * un usuario al ingresar a la aplicación
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return Query
	 */
	public static String getIntentos(String strNombre) {
		String strSql = "";
		strSql = "SELECT USU_INTENTOS FROM SD_USUARIO WHERE USU_ESTATUS=1 "
				+ "AND USU_UID='" + strNombre + "'";
		return strSql;
	}

	/**
	 * Función que regresa un query donde se suspende la cuenta del usuario
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return Query
	 */
	public static String SuspenderUsuario(String strNombre) {
		String strSql = "";
		strSql = "UPDATE SD_USUARIO SET USU_ACTIVO=0, USU_INTENTOS=0 WHERE USU_ESTATUS=1 "
				+ "AND USU_UID='" + strNombre + "'";
		return strSql;
	}

	/**
	 * Función que regresa un query donde se actualiza el numero de intentos del
	 * usuario que entra al sistema
	 * 
	 * @param iIntentos
	 *            Int Numero de intentos
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return Query
	 */
	public static String UpdateIntentos(int iIntentos, String strNombre) {
		String strSql = "";
		// strSql= "UPDATE SD_USUARIO SET USU_INTENTOS="+iIntentos+" WHERE
		// USU_NOMBRE='"+strNombre+"'";
		strSql = "UPDATE SD_USUARIO SET USU_INTENTOS=" + iIntentos
				+ " WHERE USU_UID='" + strNombre + "'";
		return strSql;
	}

	/**
	 * Función que regresa un query con el ultimo ID que se ha creado
	 * 
	 * @return Query
	 */
	public static String getUltimoIDUsuario() {
		String strSql = "";
		strSql = "SELECT MAX(ID_USUARIO) FROM SD_USUARIO";
		return strSql;
	}

	/**
	 * Regresa el Id del usuario con el parametro del uid
	 * 
	 * @param UID
	 *            uid del usuario
	 * @return query
	 */
	public static String getIdUsuarioUID(String UID, String idArea) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO FROM SD_USUARIO " + "WHERE USU_UID='" + UID
				+ "' AND USU_ESTATUS=1 AND USU_AREA = '"+idArea+"'";
		return strSql;
	}

	/**
	 * Función que regresa el Id del Area al que pertenece el usuario
	 * 
	 * @param idUsuario
	 *            Contiene el ID del Usuario
	 * @return Query
	 */
	public static String getIdUsrArea(String idUsuario) {
		String sql = "";
		sql = "SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO=" + idUsuario;
		return sql;
	}

	/**
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getCorreoNombreResponsableArea() {
		String sql = "SELECT ID_USUARIO, USU_NOMBRE, USU_CORREO, USU_AREA "
				+ "FROM SD_AREA, SD_USUARIO "
				+ "WHERE SD_AREA.ARE_SUPERVISOR=SD_USUARIO.ID_USUARIO "
				+ "AND ID_AREA=1";
		return sql;
	}

	/**
	 * 
	 * @return
	 */
	public static String getComboAsistente() {
		String sql = "SELECT ID_USUARIO, USU_NOMBRE FROM SD_USUARIO, SD_USUARIO_ROL "
				+ " WHERE SD_USUARIO.ID_USUARIO=SD_USUARIO_ROL.ID_USUARIO1 "
				+ " AND ID_ROL=6";
		return sql;
	}

	/**
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getComboAsistente(String strIdArea) {
		String sql = "SELECT ID_USUARIO, USU_CARGO||'/'||USU_NOMBRE "
				+ " FROM SD_USUARIO, SD_USUARIO_ROL "
				+ " WHERE SD_USUARIO.ID_USUARIO=SD_USUARIO_ROL.ID_USUARIO1 "
				+ " AND ID_ROL=6 AND USU_ESTATUS=1 AND USU_AREA=" + strIdArea
				+ " " + " ORDER BY 2";
		return sql;
	}

	/**
	 * Genera un String Query para regresar los Usuarios de una UA con
	 * ordenamiento
	 * 
	 * @param strIdArea:
	 *            ID de la UA
	 * @param strOrden:
	 *            Tipo de ordenamiento Ascendente o Descendente
	 * @param tipo:
	 *            Campo por el que se hace el ordenamiento
	 * 
	 * @return Regresa un String del Query correspondiente
	 */
	public static String getUsuariosPorArea(String strIdArea, String strOrden,
			String tipo) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO, USU_NOMBRE, ARE_NOMBRE, USU_AREA, USU_CARGO";
		strSql += " FROM SD_USUARIO , SD_AREA";
		strSql += " WHERE USU_ESTATUS=1 AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA";
		strSql += " AND ID_USUARIO <> 0 ";
		strSql += " AND USU_AREA=" + strIdArea + " ";
		if (tipo.equals("1")) {
			strSql += "ORDER BY 2 " + strOrden + ", 2 ASC ";
		} else if (tipo.equals("2")) {
			strSql += "ORDER BY 5 " + strOrden + ", 2 ASC ";
		}
		return strSql;
	}

	/**
	 * Genera un String Query para regresar los Usuarios y Roles de una UA con
	 * ordenamiento
	 * 
	 * @param strIdArea:
	 *            ID de la UA
	 * @param strOrden:
	 *            Tipo de ordenamiento Ascendente o Descendente
	 * @param tipo:
	 *            Campo por el que se hace el ordenamiento
	 * 
	 * @return Regresa un String del Query correspondiente
	 */
	public static String getUsuariosPorAreaRol(String strIdArea,
			String strIdRol, String strOrden, String tipo) {
		String strSql = "";
		if (strIdRol.equals("-1")) {
			strSql = "SELECT ID_USUARIO, USU_NOMBRE, ARE_NOMBRE, "
					+ "USU_AREA, USU_CARGO, 'atención Destinatarios Externos'"
					+ "FROM SD_USUARIO , SD_AREA " + "WHERE USU_ESTATUS=1 "
					+ "AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA "
					+ "AND USU_AREA= " + strIdArea + " "
					+ "AND USU_BANDERA = 1";
			if (tipo.equals("1")) {
				strSql += "ORDER BY 2 " + strOrden + ", 2 ASC ";
			} else if (tipo.equals("2")) {
				strSql += "ORDER BY 5 " + strOrden + ", 2 ASC ";
			} else if (tipo.equals("3")) {
				strSql += "ORDER BY 6 " + strOrden + ", 2 ASC ";
			}
		} else if (strIdRol.equals("-2")) {
			strSql = "SELECT ID_USUARIO, USU_NOMBRE, ARE_NOMBRE, "
					+ "USU_AREA, USU_CARGO, 'Catálogo de Archivado'"
					+ "FROM SD_USUARIO , SD_AREA " + "WHERE USU_ESTATUS=1 "
					+ "AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA "
					+ "AND USU_AREA= " + strIdArea + " " + "AND USU_CAT = 1";
			if (tipo.equals("1")) {
				strSql += "ORDER BY 2 " + strOrden + ", 2 ASC ";
			} else if (tipo.equals("2")) {
				strSql += "ORDER BY 5 " + strOrden + ", 2 ASC ";
			} else if (tipo.equals("3")) {
				strSql += "ORDER BY 6 " + strOrden + ", 2 ASC ";
			}
		} else {
			strSql = "SELECT ID_USUARIO, USU_NOMBRE, ARE_NOMBRE, "
					+ "USU_AREA, USU_CARGO, " + "CASE ID_ROL "
					+ "	WHEN 0 THEN 'Administrador' "
					+ "	WHEN 1 THEN 'atención' " + "	WHEN 2 THEN 'SCP' "
					+ "	WHEN 3 THEN 'Recepción' "
					+ "	WHEN 4 THEN 'Supervisor de área' "
					+ "	WHEN 5 THEN 'Turnador' " + "	WHEN 6 THEN 'Asistente' "
					+ "END " + "FROM SD_USUARIO , SD_AREA, SD_USUARIO_ROL "
					+ "WHERE USU_ESTATUS=1 "
					+ "AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA "
					+ "AND USU_AREA= " + strIdArea + " "
					+ "AND SD_USUARIO_ROL.ID_USUARIO1 = SD_USUARIO.ID_USUARIO "
					+ "AND ID_ROL = " + strIdRol + " ";
			if (tipo.equals("1")) {
				strSql += "ORDER BY 2 " + strOrden + ", 2 ASC ";
			} else if (tipo.equals("2")) {
				strSql += "ORDER BY 5 " + strOrden + ", 2 ASC ";
			} else if (tipo.equals("3")) {
				strSql += "ORDER BY 6 " + strOrden + ", 2 ASC ";
			}
		}
		return strSql;
	}

	/**
	 * Genera un String Query para regresar los Usuarios y Roles de una UA con
	 * ordenamiento
	 * 
	 * @param strIdArea:
	 *            ID de la UA
	 * 
	 * @return Regresa un String del Query correspondiente
	 */
	public static String getRolesPorArea(String strIdArea) {
		String strSql = "";
		strSql = "SELECT DISTINCT ID_ROL, " + "CASE ID_ROL "
				+ "	WHEN 0 THEN 'Administrador' " + "	WHEN 1 THEN 'atención' "
				+ "	WHEN 2 THEN 'SCP' " + "	WHEN 3 THEN 'Recepción' "
				+ "	WHEN 4 THEN 'Supervisor de área' "
				+ "	WHEN 5 THEN 'Turnador' " + "	WHEN 6 THEN 'Asistente' "
				+ "END " + "FROM SD_USUARIO , SD_AREA, SD_USUARIO_ROL "
				+ "WHERE USU_ESTATUS=1 "
				+ "AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA " + "AND USU_AREA= "
				+ strIdArea + " "
				+ "AND SD_USUARIO_ROL.ID_USUARIO1 = SD_USUARIO.ID_USUARIO "
				+ "UNION " + "SELECT -1, 'atención Destinatarios Externos' "
				+ "FROM DUAL " + "UNION "
				+ "SELECT -2, 'Catálogo de Archivado' " + "FROM DUAL "
				+ "ORDER BY 2 ";
		return strSql;
	}

	/**
	 * Función que me trera la lista de usuarios que dependad del usuario
	 * jerarquicamente
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getUsuariosJerarquia(String strIdArea) {
		String strSql = "";

		strSql = "SELECT ID_USUARIO, USU_CARGO FROM SD_USUARIO, SD_USUARIO_ROL "
				+ "WHERE ID_ROL=1 AND USU_ESTATUS=1 "
				+ "AND SD_USUARIO.ID_USUARIO=SD_USUARIO_ROL.ID_USUARIO1 AND "
				+ "USU_AREA=" + strIdArea + " " + "ORDER BY 2 ";
		return strSql;
	}

	/**
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getUsuarioAreaAtencion(String strIdArea) {

		String sql = "select ID_USUARIO, USU_NOMBRE, ARE_NOMBRE, USU_AREA, USU_CARGO "
				+ "from SD_USUARIO, SD_AREA, SD_USUARIO_ROL WHERE USU_ESTATUS=1 "
				+ "AND ID_ROL=1 AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA "
				+ "AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO "
				+ "AND USU_AREA=" + strIdArea + " AND USU_ACTIVO=1 ORDER BY 5";
		return sql;
	}

	/**
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getUsuarioResponsable(String strIdArea) {

		String sql = "SELECT ID_USUARIO, USU_CARGO||'/'||USU_NOMBRE "
				+ "FROM SD_USUARIO, SD_AREA " + "WHERE ID_AREA=" + strIdArea
				+ " " + "AND SD_USUARIO.ID_USUARIO=SD_AREA.ARE_SUPERVISOR "
				+ "ORDER BY 2";
		return sql;
	}

	/**
	 * 
	 * @param strIdUsuario
	 * @return
	 */
	public static String getIdsAreas(String strIdUsuario) {

		String sql = "SELECT USU_AREA, ID_USUARIO FROM SD_USUARIO WHERE ID_USUARIO<>"
				+ strIdUsuario + " AND USU_JEFE=" + strIdUsuario;
		return sql;
	}

	/**
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getUsuarioAreaAtencionE(String strIdArea) {

		String sql = "select ID_USUARIO, DES_NOMBRE, ARE_NOMBRE, DES_AREA, DES_DESCRIPCION "
				+ "from SD_DESTINATARIO, SD_AREA "
				+ "WHERE SD_AREA.ID_AREA=SD_DESTINATARIO.DES_AREA AND DES_AREA="
				+ strIdArea + " AND DES_ESTATUS=1 ORDER BY 2";
		return sql;
	}

	/**
	 * 
	 * @param strIdJefe
	 * @return
	 */
	public static String getPuestoJefe(String strIdJefe) {
		String strSql = "";
		strSql = "SELECT USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO = "
				+ strIdJefe;
		return strSql;
	}

	/**
	 * Funcion que verifica de que area es el usuario
	 * 
	 * @param strIdUsuario
	 * @return
	 */
	public static String getIdAreaUs(String strIdUsuario) {
		String strSql = "";
		strSql = "SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="
				+ strIdUsuario;
		return strSql;
	}

	/**
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getIdUsuarioTurnador(String strIdArea) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO FROM SD_USUARIO, SD_USUARIO_ROL "
				+ "WHERE USU_AREA=" + strIdArea + " "
				+ "AND SD_USUARIO.ID_USUARIO=SD_USUARIO_ROL.ID_USUARIO1 "
				+ "AND ID_ROL=5 AND USU_ESTATUS=1 ";
		return strSql;
	}

	/**
	 * 
	 * @param stridUsuario
	 * @return
	 */
	public static String getCountInstruccion(String stridUsuario) {
		String sql = "SELECT COUNT(*) FROM SD_INSTRUCCION_ASUNTO WHERE INS_USUARIO="
				+ stridUsuario
				+ " AND (INS_ESTATUS=0 OR INS_ESTATUS=1 OR INS_ESTATUS=2 OR INS_ESTATUS=3)";
		// //System.out.println("sql=="+sql);
		return sql;
	}

	/**
	 * 
	 * @param stridUsuario
	 * @return
	 */
	public static String getCountAsunto(String stridUsuario) {
		String sql = "SELECT COUNT(*) FROM SD_ASUNTO WHERE ASU_USR_TURNA="
				+ stridUsuario
				+ " "
				+ "AND (ASU_ESTATUS=1 OR ASU_ESTATUS=2 OR ASU_ESTATUS=0) AND ASU_CONTROL=1";
		return sql;
	}

	/**
	 * 
	 * @param stridUsuario
	 * @return
	 */
	public static String getCountJefe(String stridUsuario) {
		String sql = "SELECT COUNT(*) FROM SD_USUARIO WHERE USU_JEFE="
				+ stridUsuario + " AND USU_ESTATUS<>0";
		return sql;
	}

	/**
	 * 
	 * @param stridUsuario
	 * @return
	 */
	public static String getCountRemitenteAsunto(String stridUsuario) {
		String sql = "SELECT COUNT(ASU_REMITENTE) FROM SD_ASUNTO, SD_USUARIO "
				+ "WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_REMITENTE "
				+ "AND ASU_CONTROL=1 AND ID_USUARIO=" + stridUsuario + " "
				+ "AND (ASU_ESTATUS=1 OR ASU_ESTATUS=2 OR ASU_ESTATUS=0)";
		return sql;
	}

	public static String getExisteParaCC() {
		String sql = "SELECT ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC FROM SD_ASUNTO "
				+ "WHERE (ASU_ESTATUS=1 OR ASU_ESTATUS=2 OR ASU_ESTATUS=0)";
		return sql;
	}

	/**
	 * 
	 * @param strNombre
	 * @param strAux
	 * @param strArea
	 * @param strAux2
	 * @return
	 */
	public static String getPuestoExiste(String strNombre, String strAux,
			String strArea, String strAux2) {
		String strSql = "SELECT USU_NOMBRE FROM SD_USUARIO WHERE "
				+ "NOT (LOWER(USU_NOMBRE) 	= LOWER('" + strAux + "') "
				+ "AND  LOWER(USU_AREA) 		= LOWER('" + strAux2 + "')) "
				+ "AND  LOWER(USU_NOMBRE) 	= LOWER('" + strNombre + "') "
				+ "AND  LOWER(USU_AREA)	 	= LOWER('" + strArea + "') "
				+ "AND USU_ESTATUS = 1";

		return strSql;
	}

	public static String getResponsableExiste(String strCargo, String strAux) {
		String strSql = "SELECT USU_CARGO FROM SD_USUARIO WHERE "
				+ "NOT (LOWER(TRANSLATE(USU_CARGO,'áéíóúÁÉÍÓÚ','aeiouAEIOU')) 	= LOWER(TRANSLATE('"
				+ strAux
				+ "','áéíóúÁÉÍÓÚ','aeiouAEIOU'))) "
				+ "AND  LOWER(TRANSLATE(USU_CARGO,'áéíóúÁÉÍÓÚ','aeiouAEIOU')) 	= LOWER(TRANSLATE('"
				+ strCargo + "','áéíóúÁÉÍÓÚ','aeiouAEIOU')) "
				+ "AND USU_ESTATUS = 1";

		return strSql;
	}

	/**
	 * Función que regresa un query, donde se verifica si el usuario ya existe,
	 * si existe no deja insertarlo por segunda vez
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return Query
	 */
	public static String getBuscaUsuarioNombre(String strNombre) {
		String strSql = "";
		// strSql= "SELECT COUNT(*) FROM SD_USUARIO WHERE USU_ESTATUS=1 AND
		// USU_UID='"+strNombre+"'";
		strSql = "SELECT COUNT(*) FROM SD_USUARIO WHERE USU_UID='" + strNombre
				+ "' AND USU_ESTATUS=1";
		return strSql;
	}

	/*
	 * sql = "INSERT INTO SD_USUARIO (ID_USUARIO,USU_NOMBRE, USU_AREA,
	 * USU_CARGO, USU_CORREO, USU_TELEFONO," + " USU_INTENTOS, USU_JEFE,
	 * USU_ASISTENTE, USU_USR_ACTUALIZO, USU_FEC_ACTUALIZACION, USU_ESTATUS,
	 * USU_UID)" + " VALUES (SD_USUARIO_SEQ.NEXTVAL,'"+nombre+"', "+idArea+",
	 * '"+cargo+"', '"+correo+"', '"+telefono+"', "+consecutivo+"," + //"
	 * "+jefe+", "+asistente+", "+actualizo+", '"+fecha+"', "+estatus+",
	 * '"+UID+"')"; " "+jefe+", "+asistente+", "+actualizo+", SYSDATE,
	 * "+estatus+", '"+UID+"')"; return sql;
	 */

	/**
	 * Función que regresa un query donde se suspende la cuenta del usuario
	 * 
	 * @param strNombre
	 *            String Contiene el nombre del usuario
	 * @return Query
	 */
	public static String resetIntentos(String strNombre) {
		String strSql = "";
		strSql = "UPDATE SD_USUARIO SET USU_INTENTOS=0 WHERE USU_ESTATUS=1 "
				+ "AND USU_UID='" + strNombre + "'";
		return strSql;
	}
	public static String IsAdmin(String strNombre) {
		String strSql = "";
		/*strSql = "UPDATE SD_USUARIO SET USU_INTENTOS=0 WHERE USU_ESTATUS=1 "
				+ "AND USU_UID='" + strNombre + "'";*/
		strSql="SELECT * FROM SD_USUARIO WHERE USU_AREA=0 AND USU_UID='" + strNombre + "' AND USU_ESTATUS=1";
		return strSql;
	}
	public static String getIdUsuario(String UID) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_UID='" + UID
				+ "' AND USU_ESTATUS=1";
		return strSql;
	}

	public static String getRemitenteXEntidad(String strIdEntidad) {

		String sql = "SELECT ID_REMITENTE, RMT_NOMBRE FROM SD_REMITENTE "
				+ "WHERE RMT_ENTIDAD = " + strIdEntidad
				+ " AND RMT_ESTATUS=1 ORDER BY RMT_NOMBRE";
		return sql;
	}

	/**
	 * Regresa un query con la lista de usuarios con rol de atención de un área
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getUsuarioAtencion(String strIdArea) {

		String sql = "select ID_USUARIO, USU_NOMBRE "
				+ "FROM SD_USUARIO, SD_USUARIO_ROL WHERE USU_ESTATUS=1 "
				+ "AND ID_ROL=1 "
				+ "AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO "
				+ "AND USU_AREA=" + strIdArea + " AND USU_ACTIVO=1 ORDER BY 2";
		return sql;
	}

	/**
	 * Regresa un query con la lista de usuarios con rol de atención de un área
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getPuestoUsuarioAtencion(String strIdArea) {

		String sql = "select ID_USUARIO, USU_CARGO||'/'||USU_NOMBRE "
				+ "FROM SD_USUARIO, SD_USUARIO_ROL WHERE USU_ESTATUS=1 "
				+ "AND ID_ROL=1 "
				+ "AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO "
				+ "AND USU_AREA=" + strIdArea + " AND USU_ACTIVO=1 ORDER BY 2";
		return sql;
	}

	/**
	 * 
	 * @param strIdUsuario
	 * @param strIdInstruccion
	 * @return
	 */
	public static String getUsuarioTurno(String strIdUsuario,
			String strIdInstruccion) {
		String sql = "SELECT INS_TURNO FROM SD_INSTRUCCION_ASUNTO "
				+ "WHERE INS_USUARIO=" + strIdUsuario
				+ " AND ID_INSTRUCCION_ASUNTO=" + strIdInstruccion;
		return sql;
	}

	/**
	 * Función que regresa una query para verificar la linea de mando de un
	 * usuario al ser consultado
	 * 
	 * @param strIdUsuario
	 * @return
	 */
	public static String getCadenaMando(String strIdUsuario) {
		String sql = "SELECT USU_JEFE FROM SD_USUARIO WHERE ID_USUARIO="
				+ strIdUsuario;
		return sql;
	}

	/**
	 * 
	 * @param strIdUsuario
	 * @return
	 */
	public static String getEstatusUsuario(String strIdUsuario) {
		String sql = "";
		sql = "SELECT USU_ESTATUS FROM SD_USUARIO WHERE ID_USUARIO="
				+ strIdUsuario;
		return sql;
	}

	/**
	 * 
	 * @param strIdAsistente
	 * @return
	 */
	public static String getIdsUsAsistente(String strIdAsistente) {
		// String sql = "SELECT ID_USUARIO FROM SD_USUARIO WHERE
		// USU_ASISTENTE="+strIdAsistente;
		String sql = "SELECT ASI_USUARIO FROM SD_ASISTENTES WHERE ASI_ASISTENTE="
				+ strIdAsistente;
		return sql;
	}

	/**
	 * 
	 * @param strIdJefe
	 * @return
	 */
	public static String getDependencia(String strIdJefe) {
		String strSql = "";
		strSql = "SELECT ARE_SUPERVISOR FROM SD_AREA WHERE ARE_SUPERVISOR = "
				+ strIdJefe;

		return strSql;
	}

	/**
	 * 
	 * @param strIdUsuario
	 * @return
	 */
	public static String getNotificacionMail(String strIdUsuario) {
		String strSql = "";
		strSql = "SELECT" + " USU_NOTIFICACION " + " FROM SD_USUARIO"
				+ " WHERE ID_USUARIO=" + strIdUsuario;
		return strSql;
	}

	/**
	 * 
	 * @param strIdUsuario
	 * @return
	 */
	public static String getUID(String strIdUsuario) {
		String sql = "SELECT USU_UID FROM SD_USUARIO WHERE ID_USUARIO="
				+ strIdUsuario;
		return sql;
	}

	/**
	 * 
	 * @param strIdArea
	 * @return
	 */
	public static String getUsuarioDesExt(String strIdArea) {
		String sql = "SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_BANDERA=1 AND USU_AREA="
				+ strIdArea + " AND USU_ESTATUS=1";
		return sql;
	}

	/**
	 * 
	 * @param Responsable
	 * @return
	 */
	public static String getIdUsuarioxResponsable(String Responsable) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_CARGO='"
				+ Responsable + "' AND USU_ESTATUS=1";
		return strSql;
	}

	/**
	 * 
	 * @param strIdUsuario
	 * @return
	 */
	public static String getEsAtencion(String strIdUsuario) {
		String strSql = "";
		strSql = "SELECT * FROM SD_USUARIO, SD_USUARIO_ROL WHERE SD_USUARIO.ID_USUARIO=SD_USUARIO_ROL.ID_USUARIO1 AND ID_USUARIO="
				+ strIdUsuario + " AND ID_ROL=1";
		return strSql;
	}

	/**
	 * IdSupervisor
	 * 
	 * @param strIdArea
	 *            Id del área a la que pertenece el supervisor
	 * @return
	 */
	public static String getIdSupervisor(String strIdArea) {
		String strSql = "";
		strSql = "SELECT ID_USUARIO, USU_CARGO || '/' || USU_NOMBRE "
				+ "FROM SD_AREA, SD_USUARIO WHERE ID_AREA=" + strIdArea + " "
				+ "AND SD_AREA.ARE_SUPERVISOR=SD_USUARIO.ID_USUARIO";
		return strSql;
	}

	/**
	 * Query con los subordinados directos directos del Puesto o encargado de un
	 * área ó UA
	 * 
	 * @param strIdSupervisor
	 *            Id de Puesto Jefe
	 * @return
	 */
	public static String getSubalternosSubVentanilla(String strIdSupervisor,
			String strIdArea) {

		String sql = "SELECT DISTINCT ID_USUARIO, USU_CARGO || '/' || USU_NOMBRE "
				+ "FROM SD_USUARIO WHERE USU_JEFE="
				+ strIdSupervisor
				+ " "
				+ "AND USU_ESTATUS=1 AND USU_ACTIVO=1 "
				+ "AND ID_USUARIO<>"
				+ strIdSupervisor
				+ " "
				+ "AND USU_AREA = "
				+ strIdArea
				+ ""
				+ "ORDER BY 2";
		return sql;
	}

	/**
	 * Datos del usuario de subventanilla que atendera el turnador
	 * 
	 * @param strIdUsuario
	 *            id usuario
	 * @return Query
	 */
	public static String getSubalternosTurnador(String strIdUsuario) {
		String sql = "SELECT ID_USUARIO, USU_CARGO, USU_NOMBRE, USU_CORREO, USU_TELEFONO FROM SD_USUARIO WHERE USU_JEFE="
				+ strIdUsuario;
		return sql;
	}

	/**
	 * Datos del usuario de subventanilla que atendera el turnador
	 * 
	 * @param strIdUsuario
	 *            id usuario
	 * @return Query
	 */
	public static String getSubalternosTurnadorSub(String strIdUsuario) {
		String sql = "SELECT ID_USUARIO, USU_CARGO, USU_NOMBRE, USU_CORREO, USU_TELEFONO FROM SD_USUARIO WHERE ID_USUARIO="
				+ strIdUsuario;
		return sql;
	}

	/**
	 * Nombre y puesto del usuario para el reporte de un asunto
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String getUsuarioPuesto(String idUsuario) {
		String sql = "SELECT USU_CARGO || '/' || USU_NOMBRE FROM SD_USUARIO WHERE ID_USUARIO="
				+ idUsuario;
		return sql;
	}

	/**
	 * Query con los ids de los asistentes asignados a un rol de atención
	 * 
	 * @param idusuario
	 *            Id usuario de atención
	 * @return IDS asistentes
	 */
	public static String getAsistentes(String idusuario) {
		String sql = "SELECT ASI_ASISTENTE FROM SD_ASISTENTES WHERE ASI_USUARIO="
				+ idusuario;
		return sql;
	}

	/**
	 * Inserta los datos de un asistente
	 * 
	 * @param idUsuario
	 *            Id usuario de atención
	 * @param idAsistente
	 *            Id asistente
	 * @return
	 */
	public static String insertAsistente(String idUsuario, String idAsistente) {
		String sql = "INSERT INTO SD_ASISTENTES (ASI_USUARIO, ASI_ASISTENTE) VALUES("
				+ idUsuario + ", " + idAsistente + ")";
		return sql;
	}

	/**
	 * Elimina de la tabla de asistente las referencias de los mismos
	 * 
	 * @param idUsuario
	 *            id usuario de atención
	 * @return Query
	 */
	public static String deleteAsistente(String idUsuario) {
		String sql = "DELETE FROM SD_ASISTENTES WHERE ASI_USUARIO=" + idUsuario;
		return sql;
	}

	/**
	 * Query que regresa a los usuarios que son subordinados directos que
	 * pertenescan a la UA del usuario
	 * 
	 * @param idUsuario
	 *            id Usuario
	 * @param idArea
	 *            id área
	 * @return Query
	 */
	public final static String getSubordinadosDirectos(String idUsuario,
			String idArea) {
		/*
		 * String sql = "SELECT ID_USUARIO, USU_CARGO, USU_NOMBRE, USU_AREA " +
		 * "FROM SD_USUARIO, SD_USUARIO_ROL " + "WHERE USU_JEFE="+idUsuario+"
		 * AND USU_ESTATUS=1 " + "AND USU_ACTIVO=1 " + "AND
		 * SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO " + "AND
		 * USU_AREA="+idArea+" AND ID_ROL=1 " + "AND ID_USUARIO<>"+idUsuario+"
		 * ORDER BY USU_NOMBRE";
		 */
		String sql = "SELECT DISTINCT ID_USUARIO, USU_CARGO, USU_NOMBRE, USU_AREA "
				+ "FROM SD_USUARIO, SD_USUARIO_ROL "
				+ "WHERE USU_ESTATUS=1 AND USU_ACTIVO=1 AND USU_AREA="
				+ idArea
				+ " "
				+ "AND ID_ROL=1 "
				+ "AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO "
				+ "START WITH USU_JEFE = "
				+ idUsuario
				+ " CONNECT BY PRIOR ID_USUARIO = USU_JEFE " + "ORDER BY 3";
		return sql;
	}

	/**
	 * Query que regresa a los usuarios que son subordinados de otras UA's
	 * 
	 * @param idUsuario
	 *            id Usuario
	 * @param idArea
	 *            id área
	 * @return Query
	 */
	public static String getSubordinadosOtraUA(String idUsuario, String idArea) {
		String sql = "SELECT ID_USUARIO, USU_CARGO, USU_NOMBRE, USU_AREA "
				+ "FROM SD_USUARIO, SD_USUARIO_ROL " + "WHERE USU_JEFE="
				+ idUsuario + " AND USU_ESTATUS=1 " + "AND USU_ACTIVO=1 "
				+ "AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO "
				+ "AND USU_AREA<>" + idArea + " AND ID_ROL=1 "
				+ "AND ID_USUARIO<>" + idUsuario + " ORDER BY USU_NOMBRE";
		return sql;
	}

	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String getSubordinados(String idUsuario) {
		String sql = "";
		sql = "SELECT DISTINCT A.ID_USUARIO, A.USU_CARGO, A.USU_NOMBRE  "
				+ " FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE  A.USU_ESTATUS = 1 "
				+ " AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 AND B.ID_ROL = 1 "
				+ " START WITH A.USU_JEFE = " + idUsuario
				+ " CONNECT BY PRIOR A.ID_USUARIO = "
				+ " A.USU_JEFE ORDER BY 2";
		// //System.out.println("SQL Subordinados: "+sql);
		return sql;
	}

	/**
	 * muestra los usuarios que han rechazado instrucciones a cierta persona
	 * 
	 * @param idUsuario
	 *            Id usuario
	 * @return Query
	 */
	public static String getInsRechazadas(String idUsuario) {
		String sql = "SELECT ID_USUARIO, USU_CARGO, USU_NOMBRE "
				+ "FROM SD_USUARIO, SD_INSTRUCCION_ASUNTO "
				+ "WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "
				+ "AND INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO="
				+ idUsuario + " ORDER BY 3";
		return sql;
	}

	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static String getSubordinadosSinRol(String idUsuario) {
		String sql = "SELECT DISTINCT ID_USUARIO, USU_CARGO, USU_NOMBRE "
				+ "FROM SD_USUARIO, SD_USUARIO_ROL "
				+ "WHERE USU_ESTATUS=1 AND USU_ACTIVO=1 "
				+ "AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO "
				+ "START WITH USU_JEFE = " + idUsuario
				+ " CONNECT BY PRIOR ID_USUARIO = USU_JEFE ORDER BY 2";

		return sql;
	}

}
