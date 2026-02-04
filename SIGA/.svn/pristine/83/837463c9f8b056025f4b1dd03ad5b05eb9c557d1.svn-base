/*
 * Clase:						ActualizaAsunto.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 22, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		
 */

package com.meve.sigma.actualiza;

import java.sql.SQLException;
import java.util.StringTokenizer;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.db2.ConexionDocs;
import com.meve.sigma.sql.SQLAsunto;
import com.meve.sigma.sql.SQLDocs;

/**
 * ActualizaAsunto es una clase que ejecuta Querys de Consulta y Actualización
 * de registros de la Tabla de Asuntos
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaAsunto {

	/**
	 * Inserta el registro de un Asunto
	 * 
	 * @param strIdEntidad
	 *            Id de la Entidad
	 * @param strIdRemitente
	 *            Id del Remitente
	 * @param strFirmante
	 *            Firmante del Asunto
	 * @param strAsunto
	 *            Descripción del Asunto
	 * @param strIdExpediente
	 *            Id del Expediente
	 * @param strIdTipoDocto
	 *            Id Tipo Docto.
	 * @param strFechaRep
	 *            Fecha de Recepción del Asunto
	 * @param strFechaDoc
	 *            Fecha del Documento
	 * @param strFechaCad
	 *            Fecha Compromiso del Asunto
	 * @param strFolioExt
	 *            Identificador del Documento
	 * @param strFolioInt
	 *            Folio Intermedio
	 * @param strSintesis
	 *            Descripción del Asunto
	 * @param strComentarios
	 *            Comentarios del Asunto
	 * @param strPalabraClave
	 *            Palabra Clave
	 * @param strAsuntoAnt
	 *            Referencia del Asunto
	 * @param strIdPrioridad
	 *            Id Prioridad
	 * @param FolioGenerado
	 *            Folio Generado
	 * @param strUsUpdate
	 *            Usuario que Actualizo el Asunto
	 * @param strFecUpdate
	 *            Fecha de Actualización
	 * @param strAreaRecepcion
	 *            área o UA de Recepción
	 * @param strIdTipoAsunto
	 *            Id Tipo Asunto
	 * @param strUsrTurnar
	 *            Id del Turnador o Ventanilla
	 * @param strControl
	 *            Control de un Asunto(0=Entidad, 1=UA ó área)
	 * @param strEstatus
	 *            Estatus del Asunto
	 * @param strPara
	 *            Lista de Para
	 * @param strCC
	 *            Lista de CC
	 * @param strIdsPara
	 *            Lista Ids Para
	 * @param strIdsCC
	 *            Lista Ids CC
	 * @param lugarEvento
	 *            Lugar de Evento
	 * @param stringHoraEvento
	 *            Hora de Recepción
	 * @param strFechaEvento
	 *            Fecha del Evento
	 * @param stringMinEvento
	 *            Minuto del Evento
	 * @param strParaE
	 *            Lista Para Destinatarios Externos
	 * @param strIdsParaE
	 *            Lista Ids Para Destinatarios Externos
	 * @param strTramite
	 *            Trámite de un Asunto
	 * @param strTipoFolio
	 *            Tipo de Folio
	 * @return Regresa el Id del nuevo asunto
	 */
	public synchronized static String InsertarAsunto(
			String strIdEntidad,
			String strIdRemitente,
			String strFirmante,
			String strAsunto,
			String strIdExpediente,
			/* String strUbicacion, String strReferencia, */String strIdTipoDocto,
			/* String strCategoria, */String strFechaRep, String strFechaDoc,
			String strFechaCad, String strFolioExt, String strFolioInt,
			String strSintesis, String strComentarios, String strPalabraClave,
			String strAsuntoAnt, String strIdPrioridad, String FolioGenerado,
			String strUsUpdate, String strFecUpdate, String strAreaRecepcion,
			String strIdTipoAsunto, String strUsrTurnar, String strControl,
			String strEstatus, String strPara, String strCC, String strIdsPara,
			String strIdsCC, String lugarEvento, String stringHoraEvento,
			String strFechaEvento, String stringMinEvento, String strParaE,
			String strIdsParaE, String strTramite, String strTipoFolio) {
		int r = 0;
		try {
			String strSql = SQLAsunto.getInsertaAsunto(strIdEntidad,
					strIdRemitente, strFirmante, strAsunto, strIdExpediente, /*
																				 * strUbicacion,
																				 * strReferencia,
																				 */strIdTipoDocto,
					/* strCategoria, */strFechaRep, strFechaDoc, strFechaCad,
					strFolioExt, strFolioInt, strSintesis, strComentarios,
					strPalabraClave, strAsuntoAnt, strIdPrioridad,
					FolioGenerado, strUsUpdate, strFecUpdate, strAreaRecepcion,
					strIdTipoAsunto, strUsrTurnar, strControl, strEstatus,
					strPara, strCC, strIdsPara, strIdsCC, lugarEvento,
					stringHoraEvento, strFechaEvento, stringMinEvento,
					strParaE, strIdsParaE, strTramite, strTipoFolio);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.err.println("InsertaAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
		}
		return getUltimoIdAsunto();
	}

	/**
	 * Función que regresa true o false si existe Asuntos
	 * 
	 * @return true o false
	 */
	public static boolean getExistenAsuntos(String strIdArea,
			String strIdUsuario) {
		try {
			String strsql = SQLAsunto
					.getExistenAsuntos(strIdArea, strIdUsuario);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.err.println("ExistenAsuntos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si existen asuntos por Solicitante Externo
	 * 
	 * @return true o false
	 */
	public static boolean existenAsuntosPorSolicitanteExterno() {
		try {
			String strsql = SQLAsunto.existenAsuntosPorSolicitanteExterno();
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.err.println("existenAsuntosPorSolicitanteExterno:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si existen asuntos en Trámite
	 * 
	 * @return true o false
	 */
	public static boolean getExistenAsuntosTramite(String strIdArea,
			String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getExistenAsuntosTramite(strIdArea,
					strIdUsuario);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.err.println("getExistenAsuntosTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si existen asuntos terminados
	 * 
	 * @return true o false
	 */
	public static boolean getExistenAsuntosTerminado(String strIdArea,
			String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getExistenAsuntosTerminado(strIdArea,
					strIdUsuario);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExistenAsuntosTerminado:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si existen asuntos de la fecha actual
	 * 
	 * @param strFechaHoy
	 *            Fecha Actual
	 * @deprecated
	 * @return true o false
	 */
	public static boolean getExistenAsuntosHoy(String strFechaHoy) {
		try {
			String strsql = SQLAsunto.getExistenAsuntosHoy(strFechaHoy);
			// //System.out.println("getExistenAsuntosHoy:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExistenAsuntosHoy:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica la existencia de Asuntos el la pestaña de asuntos por atender
	 * 
	 * @param strIdUsuario
	 *            Id del Usuario que tiene asignado como turnador de un asunto
	 * @return true o false
	 */
	public static boolean getExistenMisAsuntos(String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getExistenMisAsuntos(strIdUsuario);
			// //System.out.println("getExistenMisAsuntos:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExistenMisAsuntos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica la existencia de Asuntos el la pestaña de asuntos en Trámite
	 * 
	 * @param strIdUsuario
	 *            Id del Usuario que tiene asignado como turnador de un asunto
	 * @return
	 */
	public static boolean getExistenMisAsuntosTramite(String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getExistenMisAsuntosTramite(strIdUsuario);
			// //System.out.println("getExistenMisAsuntos:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExistenMisAsuntos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica la existencia de Asuntos el la pestaña de asuntos Terminados
	 * 
	 * @param strIdUsuario
	 *            Id del Usuario que tiene asignado como turnador de un asunto
	 * @return
	 */
	public static boolean getExistenMisAsuntosTerminados(String strIdUsuario) {
		try {
			String strsql = SQLAsunto
					.getExistenMisAsuntosTerminados(strIdUsuario);
			// //System.out.println("getExistenMisAsuntosTerminados:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExistenMisAsuntosTerminados:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Lista de Asuntos por atender
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param strTipo
	 *            Tipo (Ascendente o descendente)
	 * @param stridArea
	 *            Id del área
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return Arreglo que regresa la lista de asuntos por atender por orden de
	 *         campos
	 */
	public static String[][] getDatosAsunto(String strOrden, String strTipo,
			String stridArea, String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getDatosAsunto(strOrden, strTipo,
					stridArea, strIdUsuario);
			// //System.out.println("getDatosAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query que muestra una lista de los asuntos de un
	 * turnador
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param strTipo
	 *            Tipo (Ascendente o descendente)
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return Arreglo que regresa la lista de asuntos por turnador para atender
	 */
	public static String[][] getDatosMisAsunto(String strOrden, String strTipo,
			String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getDatosMisAsunto(strOrden, strTipo,
					strIdUsuario);
			// //System.out.println("getDatosMisAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosMisAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query que muestra una lista de los asuntos que
	 * estan siendo en Trámite
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param tipo
	 *            Tipo (Ascendente o descendente)
	 * @param strIdArea
	 *            Id área
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return Arreglo que regresa la lista de asuntos por turnador en Trámite
	 */
	public static String[][] getDatosAsuntoTramite(String strOrden,
			String tipo, String strIdArea, String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getDatosAsuntoTramite(strOrden, tipo,
					strIdArea, strIdUsuario);
			// //System.out.println("getDatosAsuntoTramite:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosAsuntoTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query que muestra una lista de los asuntos que
	 * estan siendo en Trámite
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param tipo
	 *            Tipo (Ascendente o descendente)
	 * @param strIdUsuario
	 *            IdUsuario
	 * @return Arreglo que regresa la lista de asuntos por turnador en Trámite
	 */
	public static String[][] getDatosMisAsuntosTramite(String strOrden,
			String tipo, String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getDatosMisAsuntosTramite(strOrden, tipo,
					strIdUsuario);
			// //System.out.println("getDatosMisAsuntosTramite:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosMisAsuntosTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de Asuntos en Trámite por atención
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param tipo
	 *            Tipo (Ascendente o descendente)
	 * @param strIdUs
	 *            Id Usuario
	 * @return Arreglo que regresa la lista de asuntos en Trámite por atención
	 */
	public static String[][] getDatosAsuntoTramitePorAtencion(String strOrden,
			String tipo, String strIdUs) {
		try {
			String strsql = SQLAsunto.getDatosAsuntoTramitePorAtencion(
					strOrden, tipo, strIdUs);
			// //System.out.println("getDatosAsuntoTramitePorAtencion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosAsuntoTramitePorAtencion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de Asuntos Terminados
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param tipo
	 *            Tipo (Ascendente o descendente)
	 * @param strIdArea
	 *            Id área
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return Arreglo de asuntos terminados
	 */
	public static String[][] getDatosAsuntoTerminado(String strOrden,
			String tipo, String strIdArea, String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getDatosAsuntoTerminado(strOrden, tipo,
					strIdArea, strIdUsuario);
			// //System.out.println("getDatosAsuntoTerminado:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosAsuntoTerminado:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de Asuntos terminados por turnador
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param tipo
	 *            Tipo (Ascendente o descendente)
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return Arreglo de Asuntos terminados por turnador
	 */
	public static String[][] getDatosMisAsuntosTerminado(String strOrden,
			String tipo, String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getDatosMisAsuntosTerminado(strOrden,
					tipo, strIdUsuario);
			// //System.out.println("getDatosMisAsuntosTerminado:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosMisAsuntosTerminado:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de asuntos terminados por atención
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param tipo
	 *            Tipo (Ascendente o descendente)
	 * @param strIdUs
	 *            Id usuario
	 * @return Arreglo de asuntos terminados por atención
	 */
	public static String[][] getDatosAsuntoTerminadoPorAtencion(
			String strOrden, String tipo, String strIdUs) {
		try {
			String strsql = SQLAsunto.getDatosAsuntoTerminadoPorAtencion(
					strOrden, tipo, strIdUs);
			// //System.out.println("getDatosAsuntoTerminadoPorAtencion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosAsuntoTerminadoPorAtencion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de Asuntos de la fecha actual
	 * 
	 * @param strFechaHoy
	 *            Fecha Actual
	 * @return Arreglo de asuntos de la fecha actual
	 */
	public static String[][] getDatosAsuntoHoy(String strFechaHoy) {
		try {
			String strsql = SQLAsunto.getDatosAsuntoHoy(strFechaHoy);
			// //System.out.println("getDatosAsuntoHoy:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getDatosAsuntoHoy:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Datos de un Asuntos al consultarse
	 * 
	 * @param strIdAsunto
	 *            Id del Asunto
	 * @return Arreglo de un Asunto para la consulta
	 */
	public static String[][] getAsuntos(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getAsuntos(strIdAsunto);
			//System.out.println("getAsuntos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntos:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza el asunto
	 * 
	 * @param strIdEntidad
	 *            Id de la Entidad
	 * @param strIdRemitente
	 *            Id del Remitente
	 * @param strFirmante
	 *            Firmante del Asunto
	 * @param strAsunto
	 *            Descripción del Asunto
	 * @param strIdExpediente
	 *            Id del Expediente
	 * @param strIdTipoDocto
	 *            Id Tipo Docto.
	 * @param strFechaRep
	 *            Fecha de Recepción del Asunto
	 * @param strFechaDoc
	 *            Fecha del Documento
	 * @param strFechaCad
	 *            Fecha Compromiso del Asunto
	 * @param strFolioExt
	 *            Identificador del Documento
	 * @param strFolioInt
	 *            Folio Intermedio
	 * @param strSintesis
	 *            Descripción del Asunto
	 * @param strComentarios
	 *            Comentarios del Asunto
	 * @param strPalabraClave
	 *            Palabra Clave
	 * @param strAsuntoAnt
	 *            Referencia del Asunto
	 * @param strIdPrioridad
	 *            Id Prioridad
	 * @param FolioGenerado
	 *            Folio Generado
	 * @param strUsUpdate
	 *            Usuario que Actualizo el Asunto
	 * @param strFecUpdate
	 *            Fecha de Actualización
	 * @param strAreaRecepcion
	 *            área o UA de Recepción
	 * @param strIdTipoAsunto
	 *            Id Tipo Asunto
	 * @param strUsrTurnar
	 *            Id del Turnador o Ventanilla
	 * @param strControl
	 *            Control de un Asunto(0=Entidad, 1=UA ó área)
	 * @param strEstatus
	 *            Estatus del Asunto
	 * @param strPara
	 *            Lista de Para
	 * @param strCC
	 *            Lista de CC
	 * @param strIdsPara
	 *            Lista Ids Para
	 * @param strIdsCC
	 *            Lista Ids CC
	 * @param lugarEvento
	 *            Lugar de Evento
	 * @param stringHoraEvento
	 *            Hora de Recepción
	 * @param strFechaEvento
	 *            Fecha del Evento
	 * @param stringMinEvento
	 *            Minuto del Evento
	 * @param strParaE
	 *            Lista Para Destinatarios Externos
	 * @param strIdsParaE
	 *            Lista Ids Para Destinatarios Externos
	 * @param strTramite
	 *            Trámite de un Asunto
	 * @param strTipoFolio
	 *            Tipo de Folio
	 * @return true si se actualizo exitosamente el asunto, false si la
	 *         Actualización es fallida
	 */
	public static boolean ActualizarAsuntos(
			String strIdEntidad,
			String strIdRemitente,
			String strFirmante,
			String strAsunto,
			String strIdExpediente,
			/* String strUbicacion, String strReferencia, */String strIdTipoDocto,
			/* String strCategoria, */String strFechaRep, String strFechaDoc,
			String strFechaCad, String strFolioExt, String strFolioInt,
			String strSintesis, String strComentarios, String strPalabraClave,
			String strAsuntoAnt, String strIdPrioridad, String strIdTipoAsunto,
			String strIdAsunto, int numero, String strEstatus,
			String strFolioRep, String strPara, String strCC,
			String strIdsPara, String strIdsCC, String lugarEvento,
			String stringHoraEvento, String strFechaEvento,
			String stringMinEvento, String strParaE, String strIdsParaE,
			String strControl, String strTramite, String striIdDestinatario,
			String strTipoFolio) {
		int r = 0;
		try {
			String strsql = SQLAsunto.getActualizarAsuntos(strIdEntidad,
					strIdRemitente, strFirmante, strAsunto, strIdExpediente,
					strIdTipoDocto, strFechaRep, strFechaDoc, strFechaCad,
					strFolioExt, strFolioInt, strSintesis, strComentarios,
					strPalabraClave, strAsuntoAnt, strIdPrioridad,
					strIdTipoAsunto, strIdAsunto, numero, strEstatus,
					strFolioRep, strPara, strCC, strIdsPara, strIdsCC,
					lugarEvento, stringHoraEvento, strFechaEvento,
					stringMinEvento, strParaE, strIdsParaE, strControl,
					strTramite, striIdDestinatario, strTipoFolio);
			//System.out.println("ActualizarAsuntos:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
			
			if(numero==1) {
				 int lbln_ins = 0;
				 try{//inserta docuemnto en base de datos
					 
                     lbln_ins = ConexionDocs.ejecutarActualizacion(SQLDocs.setFolio("",strIdAsunto,strFolioRep));                                                                
                 }catch(Exception e){
                	 System.out.println(e.getMessage());}
                 
			}
		} catch (SQLException sqle) {
			// System.out.println("ActualizarAsuntos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Elimina un Asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return true o false
	 */
	public static boolean deleteAsunto(String strIdAsunto) {
		int r = 0;
		if (strIdAsunto == null || strIdAsunto.length() < 0)
			return false;

		try {
			String strsql = SQLAsunto.getDeleteAsunto(strIdAsunto);
			// //System.out.println("deleteAsunto:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("deleteAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Función que regresa un String[][] con las fechas de un asunto
	 * 
	 * @return Arreglo de asuntos por fechas
	 */
	public static String[][] AsuntosPorFecha() {
		try {
			String strsql = SQLAsunto.AsuntosPorFecha();
			// //System.out.println("AsuntosPorFecha:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorFecha:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de asuntos por fecha de vencimiento
	 * 
	 * @return Arreglo de asuntos por fecha de vencimiento
	 */
	public static String[][] AsuntosPorFechaRV() {
		try {
			String strsql = SQLAsunto.AsuntosPorFechaRV();
			// //System.out.println("AsuntosPorFechaRV:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorFechaRV:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de asuntos por fecha de asuntos en Trámite
	 * 
	 * @return Arreglo de asuntos por fecha de asuntos en Trámite
	 */
	public static String[][] AsuntosPorFechaTV() {
		try {
			String strsql = SQLAsunto.AsuntosPorFechaTV();
			// //System.out.println("AsuntosPorFechaTV:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorFechaTV:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Asuntos por solicitantes externos
	 * 
	 * @return Arreglo de asuntos por solicitantes externos
	 */
	public static String[][] AsuntosPorSolicitanteExterno() {
		try {
			String strsql = SQLAsunto.AsuntosPorSolicitanteExterno();
			// //System.out.println("AsuntosPorSolicitanteExterno:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorSolicitanteExterno:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Asuntos por solicitantes internos
	 * 
	 * @return Arreglo de asuntos por solicitantes internos
	 */
	public static String[][] AsuntosPorSolicitanteInternos() {
		try {
			String strsql = SQLAsunto.AsuntosPorSolicitanteInternos();
			// //System.out.println("AsuntosPorSolicitanteInternos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorSolicitanteInternos:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Asuntos por solicitante
	 * 
	 * @return Arreglo de asuntos por solicitantes
	 */
	public static String[][] AsuntosPorSolicitanteT() {
		try {
			String strsql = SQLAsunto.AsuntosPorSolicitanteT();
			// //System.out.println("AsuntosPorSolicitanteT:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorSolicitanteT:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Asuntos por solicitantes externos
	 * 
	 * @return Arreglo de asuntos por solicitantes externos
	 */
	public static String[][] AsuntosPorSolicitanteExternoT() {
		try {
			String strsql = SQLAsunto.AsuntosPorSolicitanteExternoT();
			// //System.out.println("AsuntosPorSolicitanteExternoT:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorSolicitanteExternoT:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de asuntos por folios
	 * 
	 * @return Arreglo de asuntos por folios
	 */
	public static String[][] AsuntosPorFolio() {
		try {
			String strsql = SQLAsunto.AsuntosPorFolio();
			// //System.out.println("AsuntosPorFolio:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorFolio:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de asuntos por folio
	 * 
	 * @return Arreglo de asuntos por folio
	 */
	public static String[][] AsuntosPorFolioT() {
		try {
			String strsql = SQLAsunto.AsuntosPorFolioT();
			// //System.out.println("AsuntosPorFolioT:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorFolioT:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Asuntos por Recepción
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Arreglo de asuntos en Recepción
	 */
	public static String[][] getAsuntosRep(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getAsuntosRep(strIdAsunto);
			// //System.out.println("AgetAsuntos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntos:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de asuntos por remitente por atender
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Arrelgo de asuntos por remitente por atender
	 */
	public static String[][] getRemitenteAsunto(String strControl,
			String strId, String strOrden, String strTipo) {
		try {
			String strsql = SQLAsunto.getRemitenteAsunto(strControl, strId,
					strOrden, strTipo);
			// //System.out.println("getRemitenteAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getRemitenteAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query regresando unos datos de la tabla de
	 * SD_ASUNTO tomando en cuenta el Estatus del Asunto que es Turnado
	 * 
	 * @param strIdRemitente
	 * @return
	 */
	public static String[][] getRemitenteAsuntoT(String strIdRemitente,
			String strOrden, String strTipo) {
		try {
			String strsql = SQLAsunto.getRemitenteAsuntoT(strIdRemitente,
					strOrden, strTipo);
			// //System.out.println("getRemitenteAsuntoT:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getRemitenteAsuntoT:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Asuntos por fecha
	 * 
	 * @param strIdRemitente
	 *            Id Remitente
	 * @return Asuntos por remitente
	 */
	public static String[][] getFechaAsunto(String strfecha) {
		try {
			String strsql = SQLAsunto.getFechaAsunto(strfecha);
			// //System.out.println("getFechaAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getFechaAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Asuntos por fecha
	 * 
	 * @param strfecha
	 *            Fecha Actual
	 * @return Arreglo por asuntos por fecha
	 */
	public static String[][] getFechaAsuntoRV(String strfecha) {
		try {
			String strsql = SQLAsunto.getFechaAsuntoRV(strfecha);
			// //System.out.println("getFechaAsuntoRV:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getFechaAsuntoRV:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Asuntos por fecha en Trámite
	 * 
	 * @param strfecha
	 *            fecha actual
	 * @return Arreglo de asuntos por fecha en tr{amite
	 */
	public static String[][] getFechaAsuntoTV(String strfecha) {
		try {
			String strsql = SQLAsunto.getFechaAsuntoTV(strfecha);
			// //System.out.println("getFechaAsuntoTV:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getFechaAsuntoTV:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que regresa que ejecuta un query, donde se trae una lista de las
	 * ID de area a la que pertenece un usuario de un asunto
	 * 
	 * @return Query
	 */
	public static String[][] getIdsAreaPertenece() {
		try {
			String strsql = SQLAsunto.getIdsAreaPertenece();
			// //System.out.println("getIdsAreaPertenece:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getIdsAreaPertenece:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query donde se muestra el nombre del usuario y su
	 * correo
	 * 
	 * @param strIdAsunto
	 *            String Contiene el ID del Asuto
	 * @return Nombre y correo
	 */
	public static String[][] getNombreCorreo(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getNombreCorreo(strIdAsunto);
			// //System.out.println("getNombreCorreo:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getNombreCorreo:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query, donde traera el ultimo ID que ha sido
	 * registrado en la tabla SD_ASUNTO
	 * 
	 * @return Id de ultimo asunto registrado
	 */
	public synchronized static String getUltimoIdAsunto() {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLAsunto
					.getUltimoIdAsunto());
			// //System.out.println("getUltimoIdAsunto:"+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return "";
		} catch (SQLException sqle) {
			// System.out.println("getUltimoIdAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Folio de un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Folio de Recepción de un asunto
	 */
	public static String getFolioAsunto(String strIdAsunto) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLAsunto
					.getFolioAsunto(strIdAsunto));
			// //System.out.println("getFolioAsunto:"+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getFolioAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Folio de Recepción de un asunto
	 * 
	 * @param strIdInstruccion
	 *            Id instrucción
	 * @return Folio de Recepción
	 */
	public static String getFolioAsuntoInst(String strIdInstruccion) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLAsunto
					.getFolioAsuntoIns(strIdInstruccion));
			// //System.out.println("getFolioAsuntoInst:"+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getFolioAsuntoInst:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Fecha de Inicio o Recepción de un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asuntos
	 * @return Fecha de Inicio
	 */
	public static String getFechaInicioAsunto(String strIdAsunto) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLAsunto
					.getFechaInicioAsunto(strIdAsunto));
			// //System.out.println("getFechaInicioAsunto:"+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getFechaInicioAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query, donde muestra unalista del os asuntos que
	 * no han sido turnados y que se determinara cuales de ellos ya se pasaron
	 * de tiempos
	 * 
	 * @param strIdArea
	 *            String stIdArea
	 * @return Arreglo de asuntos retrasados
	 */
	public static String[][] getAsuntosPorTurnarRetrasados(String strIdArea) {
		try {
			String strsql = SQLAsunto.getAsuntosPorTurnarRetrasados(strIdArea);
			// //System.out.println("getAsuntosPorTurnarRetrasados:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntosPorTurnarRetrasados:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query, donde contabiliza el numero de
	 * instrucciones que tiene el asunto sin turnar
	 * 
	 * @param strIdAsunto
	 *            Id del Asunto
	 * @return Número de instrucciones son turnar
	 */
	public static String getCountInstSinTurnar(String strIdAsunto) {
		try {
			String strResult[][] = ConexionDS.ejecutarSQL(SQLAsunto
					.getCountInstSinTurnar(strIdAsunto));
			// //System.out.println("getCountInstSinTurnar:"+strResult[0][0]);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			return null;
		} catch (SQLException sqle) {
			// System.out.println("getCountInstSinTurnar:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query, donde muestra una lista de los asuntos que
	 * estan atendiendose y que se determinara cuales de ellos ya se pasaron de
	 * tiempos
	 * 
	 * @param strIdArea
	 *            String stIdArea
	 * @return Asuntos en tr{amite retrasados
	 */
	public static String[][] getAsuntosEnTramiteRetrasados(String strIdArea) {
		try {
			String strsql = SQLAsunto.getAsuntosEnTramiteRetrasados(strIdArea);
			// //System.out.println("getAsuntosEnTramiteRetrasados:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntosEnTramiteRetrasados:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que regresa true o false si existe Asuntos en atención es estatus
	 * del documento es 0
	 * 
	 * @return true o false
	 */
	public static boolean getExistenAsuntosEnAtencion() {
		try {
			String strsql = SQLAsunto.getExistenAsuntosEnAtencion();
			// //System.out.println("getExistenAsuntosEnAtencion:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExistenAsuntosEnAtencion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Función que ejecuta un query, donde muestra la lista de los asuntos que
	 * se encuentras en Recepción
	 * 
	 * @return Arreglo de asuntos en Recepción
	 */
	public static String[][] getAsuntoEnAtencion(String strOrden, String strTipo) {
		try {
			String strsql = SQLAsunto.getAsuntoEnAtencion(strOrden, strTipo);
			// //System.out.println("getAsuntoEnAtencion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntoEnAtencion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de asuntos en Recepción
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param strTipo
	 *            Orden de la columan(Ascendente o descendente)
	 * @param strIdArea
	 *            Id área
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return Arreglo de asuntos en Recepción
	 */
	public static String[][] getAsuntoEnAtencion(String strOrden,
			String strTipo, String strIdArea, String strIdUsuario) {
		try {
			String strsql = SQLAsunto.getAsuntoEnAtencion(strOrden, strTipo,
					strIdArea, strIdUsuario);
			// //System.out.println("getAsuntoEnAtencion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntoEnAtencion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que ejecuta un query con los datos para y cc para cargar al
	 * applet
	 * 
	 * @param strIdAsunto
	 * @return Arreglo de para y cc
	 */
	public static String[][] getParaCC(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getParaCC(strIdAsunto);
			// //System.out.println("getParaCC:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getParaCC:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Verifica si el identificador del docto. existe en el asunto
	 * 
	 * @param strFolio
	 *            Identificador del Docto.
	 * @param strFechaDoc
	 *            Fecha del documento
	 * @param strControl
	 *            Control del asunto
	 * @param strEntidad
	 *            Entidad
	 * @param strRemitente
	 *            Remitente
	 * @return true o false
	 */
	public static boolean getExisteFolioExterno(String strFolio,
			String strFechaDoc, String strControl, String strEntidad,
			String strRemitente, String idArea) {
		try {
			String strsql = SQLAsunto.getExisteFolioExterno(strFolio,
					strFechaDoc, strControl, strEntidad, strRemitente, idArea);
			// //System.out.println("getExisteFolioExterno:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExisteFolioExterno:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si existe folio de salida de un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return true o false
	 */
	public static boolean getExisteFolioSalidaAsunto(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getExisteFolioSalidaAsunto(strIdAsunto);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 1)
				return true;
			if(strExpediente[0][0]!=null&&!"".equals(strExpediente[0][0].trim())){
				return true;
			}
			return false;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Clave del área para le foleo del asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Id del area y clave del folio
	 */
	public static String[][] getAreaFoleo(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getAreaFoleo(strIdAsunto);
			// //System.out.println("getAreaFoleo:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAreaFoleo:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Folio de entrada
	 * 
	 * @param strFolio
	 *            Folio de entrada
	 * @param stridAsunto
	 *            Id Asunto
	 * @return Folio de entrada
	 */
	public static boolean setFolioEntrada(String strFolio, String stridAsunto) {
		int r = 0;
		try {
			String strsql = SQLAsunto.setFolioEntrada(strFolio, stridAsunto);
			// //System.out.println("setFolioEntrada:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("setFolioEntrada:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Descripción de asunto e identificador del área
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Descripción asunto e identificador del área
	 */
	public static String[][] getAsuntoFoleo(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getAsuntoFoleo(strIdAsunto);
			// //System.out.println("getAsuntoFoleo:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntoFoleo:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Descripción y folio del asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Descripción asunto e identificador del área
	 */
	public static String[][] getAsuntoRecuperado(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getAsuntoRecuperado(strIdAsunto);
			// //System.out.println("getAsuntoFoleo:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntoFoleo:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Insertar la relación de asuntos
	 * 
	 * @param strIdsAsunto
	 *            Ids Asuntos de relación
	 * @param strIdAsunto
	 *            Id Asuntos al que se le relacionan
	 * @return Ultimo Id de asunto registrado
	 */
	public synchronized static String InsertarAsuntosAnt(String strIdsAsunto,
			String strIdAsunto) {
		int r = 0;
		try {
			String strSql = SQLAsunto.InsertarAsuntosAnt(strIdsAsunto,
					strIdAsunto);
			// //System.out.println("InsertarAsuntosAnt"+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarAsuntosAnt:"+sqle.getMessage());
			sqle.printStackTrace();
			// return false;
		}
		return getUltimoIdAsunto();
		// return (r>0);
	}

	/**
	 * Actualiza un registro cuando se envia notificación de terminación de
	 * asunto y no se envíen mas notificaciones
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return true o false
	 */
	public static boolean getUpdateMail(String strIdAsunto) {
		int r = 0;
		try {
			String strsql = SQLAsunto.getUpdateMail(strIdAsunto);
			// //System.out.println("getUpdateMail:"+strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getUpdateMail:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Lista de Ids de referencias
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Arreglo Ids de referencias de asunto
	 */
	public static String[][] getIdsRef(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getidsAsunt(strIdAsunto);
			// //System.out.println("getidsAsunt:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getidsAsunt:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}

	}

	/**
	 * Lista de asuntos referenciados
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Arreglo de asuntos referenciados
	 */
	public static String[][] getAsuntosAnt(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getAsuntosAnt(strIdAsunto);
			// //System.out.println("getAsuntosAnt:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntosAnt:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Lista de ids asuntos referenciados
	 * 
	 * @param strIdAsunto
	 *            id Asuntos
	 * @return Arreglo de asuntos referenciados
	 */
	public static String[][] getAsuntosAntRef(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getAsuntosAntRef(strIdAsunto);
			// //System.out.println("getAsuntosAntRef:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntosAntRef:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}

	}

	/**
	 * Lista de asuntos
	 * 
	 * @param idAsunto
	 *            Id Asuntos
	 * @return Arreglo de lista de asuntos
	 */
	public static String idAsuntosAnt(String idAsunto) {
		String idAsuntoInsertado = null;

		try {
			String strSql = SQLAsunto.getIdsAsuntosAnt(idAsunto);
			// //System.out.println("getIdsAsuntosAnt"+strSql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strSql);
			if (strExpediente.length == 0)
				idAsuntoInsertado = "";
			else
				idAsuntoInsertado = strExpediente[0][0];
			return idAsuntoInsertado;
		} catch (SQLException sqle) {
			// System.out.println("getIdsAsuntosAnt:"+sqle.getMessage());
			sqle.printStackTrace();
			return idAsuntoInsertado;
		}

	}

	/**
	 * Lista de asuntos referenciados
	 * 
	 * @param idAsunto
	 *            id Asuntos
	 * @return Arreglo de asuntos referenciados
	 */
	public static String idAsuntosRef(String idAsunto) {
		String idAsuntoInsertado = null;

		try {
			String strSql = SQLAsunto.getIdsAsuntosRef(idAsunto);
			// //System.out.println("getIdsAsuntosRef"+strSql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strSql);
			if (strExpediente.length == 0)
				idAsuntoInsertado = "";
			else
				idAsuntoInsertado = strExpediente[0][0];

			return idAsuntoInsertado;
		} catch (SQLException sqle) {
			// System.out.println("getIdsAsuntosRef:"+sqle.getMessage());
			sqle.printStackTrace();
			return idAsuntoInsertado;
		}

	}

	/**
	 * Se inserta las referencias de los ids a un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @param strIdsAsunto
	 *            Ids de asuntos referenciados
	 * @param strAsuntoRef
	 *            Asunto referenciado
	 * @return Id del ultimo asunto
	 */
	public synchronized static String InsertarAsuntosAnt(String strIdAsunto,
			String strIdsAsunto, String strAsuntoRef) {
		int r = 0;
		String strSql;

		try {

			strSql = SQLAsunto.EliminaAsuntosAnexRef(strIdAsunto);
			r = ConexionDS.ejecutarActualizacion(strSql);
			strSql = SQLAsunto.EliminaAsuntosAnex(strIdAsunto);
			r = ConexionDS.ejecutarActualizacion(strSql);

		} catch (SQLException sqle) {
			// System.out.println("EliminaAsuntosAnex:"+sqle.getMessage());
			sqle.printStackTrace();
		}

		StringTokenizer tokens = new StringTokenizer(strIdsAsunto, "|");
		StringTokenizer tokens1 = new StringTokenizer(strAsuntoRef, "|");
		int nDatos = tokens.countTokens();
		String strDatoA[] = new String[nDatos];
		String strDatosR[] = new String[nDatos];

		int i = 0;
		int y = 0;
		int x = 0;

		while (tokens.hasMoreTokens()) {
			String str = tokens.nextToken();
			strDatoA[x] = str;
			x++;
		}
		while (tokens1.hasMoreTokens()) {
			String str = tokens1.nextToken();
			strDatosR[y] = str;
			y++;
		}

		try {
			for (i = 0; strDatoA.length > i; i++) {
				strSql = SQLAsunto.InsertarAsuntosAnt(strDatoA[i], strIdAsunto,
						strDatosR[i]);
				r = ConexionDS.ejecutarActualizacion(strSql);
			}
			strSql = SQLAsunto.InsertarAsuntosAnex(strIdsAsunto, strIdAsunto,
					strAsuntoRef);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			// System.out.println("InsertarAsuntosAnt:"+sqle.getMessage());
			sqle.printStackTrace();
		}
		return getUltimoIdAsunto();
	}

	/**
	 * Elimina referencias de asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @param strIdsAsunto
	 *            Ids de asuntos referenciados
	 * @param strAsuntoRef
	 *            Asunto referenciado
	 * @return Id del ultimo asunto
	 */
	public synchronized static String EliminarAsuntosAnt(String strIdAsunto,
			String strIdsAsunto, String strAsuntoRef) {
		// //System.out.println("Valores q entran "+ strIdsAsunto +" "
		// +strIdAsunto + " " + strAsuntoRef );
		String strSql;
		int r = 0;

		StringTokenizer tokens = new StringTokenizer(strIdsAsunto, "|");
		StringTokenizer tokens1 = new StringTokenizer(strAsuntoRef, "|");
		int nDatos = tokens.countTokens();
		String strDatoA[] = new String[nDatos];
		String strDatosR[] = new String[nDatos];

		int i = 0;
		int y = 0;
		int x = 0;

		while (tokens.hasMoreTokens()) {
			String str = tokens.nextToken();
			strDatoA[x] = str;
			x++;
		}
		while (tokens1.hasMoreTokens()) {
			String str = tokens1.nextToken();
			strDatosR[y] = str;
			y++;
		}
		try {
			for (i = 0; strDatoA.length > i; i++) {

				strSql = SQLAsunto.InsertarAsuntosAnt(strDatoA[i], strIdAsunto,
						strDatosR[i]);
				r = ConexionDS.ejecutarActualizacion(strSql);

			}
			strSql = SQLAsunto.InsertarAsuntosAnex(strIdsAsunto, strIdAsunto,
					strAsuntoRef);
			r = ConexionDS.ejecutarActualizacion(strSql);

		} catch (SQLException sqle) {
			// System.out.println("InsertarAsuntosAnt:"+sqle.getMessage());
			sqle.printStackTrace();
		}
		return getUltimoIdAsunto();
	}

	/**
	 * Función que trae la fecha de compromiso
	 * 
	 * @param strIdAsunto
	 * @return Fecha Compromiso
	 * @throws SQLException
	 */
	public static String[][] getFechaVencimiento(String strIdAsunto)
			throws SQLException {
		return ConexionDS.ejecutarSQL(SQLAsunto
				.getFechaVencimiento(strIdAsunto));
	}

	/**
	 * Verifia si un usuario tiene acceso a un asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return true si tiene acceso y false si no tiene acceso
	 */
	public static boolean getAccesoAsunto(String strIdAsunto,
			String strIdUsuario) {
		try {
			String strsql = SQLAsunto
					.getAccesoAsunto(strIdAsunto, strIdUsuario);
			// //System.out.println("getAccesoAsunto:"+strsql);
			String strAcceso[][] = ConexionDS.ejecutarSQL(strsql);
			if (strAcceso != null && strAcceso.length > 0)
				return true;
			return false;

		} catch (SQLException sqle) {
			// System.out.println("getAccesoAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Ids de ruta de acceso
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Ids de acceso
	 */
	public static String[][] getIdsRutaAcceso(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getIdsRutaAcceso(strIdAsunto);
			String strAcceso[][] = ConexionDS.ejecutarSQL(strsql);
			return strAcceso;

		} catch (SQLException sqle) {
			// System.out.println("getAccesoAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Control de un asunto para verificar si viene de una entidad o un área
	 * interna
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return 0 ó 1
	 */
	public static String getControl(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getControl(strIdAsunto);
			// //System.out.println("getControl:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0)
				return strResult[0][0];
			else
				return "";
		} catch (SQLException sqle) {
			// System.out.println("getControl:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Lista de asuntos por folio
	 * 
	 * @param strIdArea
	 *            Id área
	 * @param orden
	 *            Orden del campo
	 * @param tipo
	 *            Tipo de orden
	 * @return Arreglo de asuntos por folio
	 */
	public static String[][] AsuntosPorFolio(String strIdArea, String orden,
			String tipo) {
		try {
			String strsql = SQLAsunto.AsuntosPorFolio(strIdArea, orden, tipo);
			// //System.out.println("AsuntosPorFolio:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorFolio:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Asuntos por folio en Trámite
	 * 
	 * @param orden
	 *            Orden de la columna
	 * @param tipo
	 *            Orden
	 * @return Arreglo por folio en Trámite
	 */
	public static String[][] AsuntosPorFolioT(String strIdArea, String orden,
			String tipo) {
		try {
			String strsql = SQLAsunto.AsuntosPorFolioT(strIdArea, orden, tipo);
			// //System.out.println("AsuntosPorFolioT:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("AsuntosPorFolioT:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa los asuntos segun su remitente
	 * 
	 * @param strIdUsuario
	 *            ID Usuario
	 * @param strOrden
	 *            Orden
	 * @param tipo
	 *            Tipo de ordenamiento
	 * @param stridArea
	 *            ID de la UA
	 * @return String[][] con el resultado de la busqueda
	 */
	public static String[][] getAsuntosSolicitados(String strIdUsuario,
			String strOrden, String tipo, String stridArea) {
		try {
			String strsql = SQLAsunto.getAsuntosSolicitados(strIdUsuario,
					strOrden, tipo, stridArea);
			// //System.out.println("getAsuntosSolicitados:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntosSolicitados:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Regresa los asuntos segun su remitente de otras UA
	 * 
	 * @param strIdUsuario
	 *            ID Usuario
	 * @param strOrden
	 *            Orden
	 * @param tipo
	 *            Tipo de ordenamiento
	 * @param stridArea
	 *            ID de la UA
	 * @return String[][] con el resultado de la busqueda
	 */
	public static String[][] getAsuntosSolicitadosOtrasUA(String strIdUsuario,
			String strOrden, String tipo, String stridArea) {
		try {
			String strsql = SQLAsunto.getAsuntosSolicitadosOtrasUA(
					strIdUsuario, strOrden, tipo, stridArea);
			// //System.out.println("getAsuntosSolicitados:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntosSolicitadosOtrasUA:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * verifica si existen asuntos solicitados por el remitente interno
	 * 
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return true o false
	 */
	public static boolean getExistenAsuntosSolicitadas(String strIdUsuario,
			String strIdArea) {
		try {
			String strsql = SQLAsunto.getExistenAsuntosSolicitadas(
					strIdUsuario, strIdArea);
			// //System.out.println("getExistenAsuntosSolicitadas:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExistenAsuntosSolicitadas:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Lista de asuntos ligados
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Arreglo de asuntos ligados
	 */
	public static String[][] getAsuntosLigados(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getAsuntosLigados(strIdAsunto);
			// //System.out.println("getAsuntosLigados:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getAsuntosLigados:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Acceso de la ruta de atención
	 * 
	 * @param strIdUsuario
	 *            Id Asunto
	 * @param strRuta
	 *            Arreglo de ruta
	 * @return true o false
	 */
	public static boolean getAccesoRutaAtencion(String strIdUsuario,
			String[][] strRuta) {

		boolean accJefes = false;
		if (strRuta != null && strRuta.length > 0) {
			for (int j = 0; j < strRuta.length; j++) {
				String aux = strRuta[j][0];
				if (aux.equals(strIdUsuario)) {
					accJefes = true;
				}
			}
		}
		return accJefes;
	}

	/**
	 * Regresa el Estatus de un Asunto
	 * 
	 * @param strIdAsunto
	 *            Id Asunto
	 * @return Estatus del Asunto
	 */
	public static String getEstatus(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getEstatus(strIdAsunto);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0) {
				return strResult[0][0];
			} else {
				return "";
			}
		} catch (SQLException sqle) {
			// System.out.println("getEstatus:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}
	}

	/**
	 * Regresa el id del turnador del asunto
	 * 
	 * @param strIdAsunto
	 *            Id del asunto
	 * @return Id del turnador
	 */
	public static String getAsuntoTurnado(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getAsuntoTurnado(strIdAsunto);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0) {
				return strResult[0][0];
			} else {
				return "";
			}
		} catch (SQLException sqle) {
			// System.out.println("getAsuntoTurnado:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}
	}

	public static boolean getTieneTramite(String strIdAsunto) {
		try {
			String strsql = SQLAsunto.getTieneTramite(strIdAsunto);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0) {
				if (!strResult[0][0].equals("")
						&& !strResult[0][0].equals("null"))
					return true;
				else
					return false;
			} else {
				return false;
			}
		} catch (SQLException sqle) {
			// System.out.println("getTieneTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Turnadores del área, no muestra al usuario que consulta
	 * 
	 * @param idArea
	 *            id de la unidad administrativa
	 * @param idusuario
	 *            id del usuario que no se tomara en cuenta
	 * @return Turnadores de la ua
	 */
	public static String[][] getTurnadoreUnidad(String idArea, String idusuario) {
		try {
			String strsql = SQLAsunto.getTurnadoreUnidad(idArea, idusuario);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getTurnadoreUnidad:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que regresa true o false si existe Asuntos
	 * 
	 * @return true o false
	 */
	public static boolean existeAsuntoTurnadorAtender(String strIdArea,
			String strIdUsuario) {
		try {
			String strsql = SQLAsunto.existeAsuntoTurnadorAtender(strIdArea,
					strIdUsuario);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("existeAsuntoTurnadorAtender:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Lista de Asuntos por atender
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param strTipo
	 *            Tipo (Ascendente o descendente)
	 * @param stridArea
	 *            Id del área
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return Arreglo que regresa la lista de asuntos por atender por orden de
	 *         campos
	 */
	public static String[][] datosAsuntoTurnadorAtender(String strOrden,
			String strTipo, String stridArea, String strIdUsuario) {
		try {
			String strsql = SQLAsunto.datosAsuntoTurnadorAtender(strOrden,
					strTipo, stridArea, strIdUsuario);
			// //System.err.println("datosAsuntoTurnadorAtender:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("datosAsuntoTurnadorAtender:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Turnadores del área, no muestra al usuario que consulta
	 * 
	 * @param idArea
	 *            id de la unidad administrativa
	 * @param idusuario
	 *            id del usuario que no se tomara en cuenta
	 * @return Turnadores de la ua
	 */
	public static String[][] getTurnadoreUnidadTramite(String idArea,
			String idusuario) {
		try {
			String strsql = SQLAsunto.getTurnadoreUnidadTramite(idArea,
					idusuario);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getTurnadoreUnidadTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que regresa true o false si existe Asuntos
	 * 
	 * @return true o false
	 */
	public static boolean existeAsuntoTurnadorTramite(String strIdArea,
			String strIdUsuario) {
		try {
			String strsql = SQLAsunto.existeAsuntoTurnadorTramite(strIdArea,
					strIdUsuario);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("existeAsuntoTurnadorTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Lista de Asuntos por atender
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param strTipo
	 *            Tipo (Ascendente o descendente)
	 * @param stridArea
	 *            Id del área
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return Arreglo que regresa la lista de asuntos por atender por orden de
	 *         campos
	 */
	public static String[][] datosAsuntoTurnadorTramite(String strOrden,
			String strTipo, String stridArea, String strIdUsuario) {
		try {
			String strsql = SQLAsunto.datosAsuntoTurnadorTramite(strOrden,
					strTipo, stridArea, strIdUsuario);
			// //System.err.println("datosAsuntoTurnadorAtender:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("datosAsuntoTurnadorTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Turnadores del área, no muestra al usuario que consulta
	 * 
	 * @param idArea
	 *            id de la unidad administrativa
	 * @param idusuario
	 *            id del usuario que no se tomara en cuenta
	 * @return Turnadores de la ua
	 */
	public static String[][] getTurnadoreUnidadTerminado(String idArea,
			String idusuario) {
		try {
			String strsql = SQLAsunto.getTurnadoreUnidadTerminado(idArea,
					idusuario);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("getTurnadoreUnidadTerminado:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que regresa true o false si existe Asuntos
	 * 
	 * @return true o false
	 */
	public static boolean existeAsuntoTurnadorTerminado(String strIdArea,
			String strIdUsuario) {
		try {
			String strsql = SQLAsunto.existeAsuntoTurnadorTerminado(strIdArea,
					strIdUsuario);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("existeAsuntoTurnadorTerminado:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Lista de Asuntos por atender
	 * 
	 * @param strOrden
	 *            Orden de la columna
	 * @param strTipo
	 *            Tipo (Ascendente o descendente)
	 * @param stridArea
	 *            Id del área
	 * @param strIdUsuario
	 *            Id Usuario
	 * @return Arreglo que regresa la lista de asuntos por atender por orden de
	 *         campos
	 */
	public static String[][] datosAsuntoTurnadorTerminado(String strOrden,
			String strTipo, String stridArea, String strIdUsuario) {
		try {
			String strsql = SQLAsunto.datosAsuntoTurnadorTerminado(strOrden,
					strTipo, stridArea, strIdUsuario);
			// //System.err.println("datosAsuntoTurnadorAtender:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			// System.out.println("datosAsuntoTurnadorTerminado:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Acceso al pool de turnadores, verificando si es el área a la que es el
	 * rol de atención
	 * 
	 * @param idArea
	 *            Id área
	 * @param idAsunto
	 *            Id Asunto
	 * @return acceso
	 */
	public static boolean getAccesoTurnadores(String idArea, String idAsunto) {
		try {
			String strsql = SQLAsunto.getAccesoTurnadores(idArea, idAsunto);
			// //System.out.println("getControl:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0)
				return true;
			else
				return false;
		} catch (SQLException sqle) {
			// System.out.println("getAccesoTurnadores:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

	/**
	 * Trae la hora de la base de datos
	 * 
	 * @return
	 */
	public static int getHora() {
		try {
			String strsql = SQLAsunto.getHora();
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
			if (strResult != null && strResult.length > 0) {
				return new Integer(strResult[0][0]).intValue();
			} else {
				return 0;
			}
		} catch (SQLException sqle) {
			// System.out.println("getHora:"+sqle.getMessage());
			sqle.printStackTrace();
			return 0;
		}
	}

	/**
	 * Verifica si el identificador del docto. existe en el asunto
	 * 
	 * @param strFolio
	 *            Identificador del Docto.
	 * @param strFechaDoc
	 *            Fecha del documento
	 * @param strControl
	 *            Control del asunto
	 * @param strEntidad
	 *            Entidad
	 * @param strRemitente
	 *            Remitente
	 * @return true o false
	 */
	public static boolean getExisteFolioExternoRepTur(String strFolio,
			String strFechaDoc, String strControl, String strEntidad,
			String strRemitente, String idArea) {
		try {
			String strsql = SQLAsunto.getExisteFolioExternoRepTur(strFolio,
					strFechaDoc, strControl, strEntidad, strRemitente, idArea);
			// //System.out.println("getExisteFolioExterno:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
			if (strExpediente.length > 0)
				return true;
			return false;
		} catch (SQLException sqle) {
			// System.out.println("getExisteFolioExternoRepTur:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}

}
