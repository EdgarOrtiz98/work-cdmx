/*
 * Clase:						SQLInstrucciones.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 3, 2005
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

package com.meve.sigma.sql;

import java.util.Calendar;

import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.util.Estatus;
import com.meve.sigma.util.Utilerias;

import gob.hacienda.cgtic.siga.Usuario;


public class SQLInstrucciones {
   
   /**
    * Función que regresa un query de una lista de usuarios que van a a atender 
    * una instrucción
    * @param strIdUsuario Id de usuario
    * @return String sql
    */
   public static String UsuarioInstruccionAtender(String strIdUsuario)
   {
       String sql = "";
       sql = "SELECT DISTINCT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=1 AND INS_BANDERA1=0 AND INS_USUARIO="+strIdUsuario;
       return sql;
   }
   
   /**
    * Función que regresa un query de una lista de usuarios que estan llevando
    * el tramite de la instrucción
    * @param strIdUsuario Id de usuario
    * @return String sql
    */
   public static String UsuarioInstruccionTramite(String strIdUsuario)
   {
       String sql = "";
       sql = "SELECT DISTINCT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=2 AND INS_BANDERA1=0 AND INS_USUARIO="+strIdUsuario;
       
       return sql;
   }
   
   /**
    * Función que regresa un query de una lista de usuarios que han
    * terminado la instruccion
    * @param strIdUsuario Id de usuario
    * @return sql
    */
   public static String UsuarioInstruccionTerminada(String strIdUsuario)
   {
       String sql = "";
       sql = "SELECT DISTINCT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS= " +
       Estatus.INS_TERMINADA
       		+" AND INS_BANDERA1=0 AND INS_USUARIO="+strIdUsuario;
       return sql;
   }
   
   /**
    * Función que regresa un query de una lista de usuarios que han
    * rechazado la instruccion
    * @return sql
    */
   public static String UsuarioInstruccionRechazada()
   {
       String sql = "";
       sql = "SELECT DISTINCT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO " +
       		"WHERE INS_ESTATUS=3 AND INS_BANDERA1=0";
       return sql;
   }
   
   /**
    * Regresa el query de instrucciones por atender
    * @param strIdUsuario Id de usuario
    * @return String sql 
    */
   public static String getInstruccionAtenderUsuario(String strIdUsuario)
   {
       String sql = "";
       sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, " +
       		"TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), " +
       		"TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
       		"INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, INS_INSTRUCCION_OTRO, " +
       		"INS_TIEMPO, INS_AVANCE, INS_USUARIO, USU_ASISTENTE, USU_JEFE, " +
       		"INS_HABILITADA, INS_CONFIDENCIAL, INS_TURNO, INS_PADRE " +
       		"FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, " +
       		"SD_ASUNTO WHERE INS_USUARIO="+strIdUsuario+" AND " +
       		"SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO AND " +
       		"SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
       		"AND INS_ESTATUS=1 AND INS_BANDERA1=0";
       return sql;
   }
   

   /**
    * Regresa el query de instrucciones por atender ordenadas 
    * @param strIdUsuario ID usurio 
    * @param orden Orden 
    * @param tipo Tipo de ordenamiento 
    * @return sql 	
    */
   public static String getInstruccionAtenderUsuario(String strIdUsuario, String orden, String tipo)
   {
       String sql = "";
       sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, " +
       		"TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), " +
       		"TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
       		"INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, INS_INSTRUCCION_OTRO, " +
       		"INS_TIEMPO, INS_AVANCE, INS_USUARIO, USU_ASISTENTE, USU_JEFE, " +
       		"INS_HABILITADA, INS_CONFIDENCIAL, INS_TURNO, INS_PADRE, " +
       		"INS_FECHA_ASIGNACION, INS_FECHA_TERMINACION " +
       		"FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, " +
       		"SD_ASUNTO WHERE INS_USUARIO="+strIdUsuario+" AND " +
       		"SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO AND " +
       		"SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
       		"AND INS_ESTATUS=1 AND INS_BANDERA1=0 " +
       		"ORDER BY " + tipo + " " + orden + ", 7 ASC";
       return sql;
   }
   
   /**
    * Regresa query de instrucciones en tramite 
    * @param strIdUsuario ID usuario  
    * @param orden Orden 
    * @param tipo Tipo de ordenamiento 
    * @return sql
    */
   public static String getInstruccionTramiteUsuario(String strIdUsuario, String orden, String tipo)
   {
       String sql = "";
       sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, " +
       		"TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), " +
       		"TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
       		"INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, " +
       		"INS_AVANCE, INS_INSTRUCCION_OTRO, INS_TIEMPO, INS_USUARIO, " +
       		"USU_ASISTENTE, USU_JEFE, INS_HABILITADA, INS_CONFIDENCIAL, INS_TURNO, INS_PADRE, INS_FECHA_ASIGNACION " +
       		"FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, " +
       		"SD_ASUNTO WHERE INS_USUARIO="+strIdUsuario+" AND " +
       		"SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO " +
       		"AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
       		"AND INS_ESTATUS=2 AND INS_BANDERA1=0 " +
       		"ORDER BY " + tipo + " " + orden + ", 7 ASC";
       return sql;
   }
   
   /**
    * Regresa query de instrucciones Terminadas
    * @param strIdUsuario ID usuarios 
    * @param orden Orden 
    * @param tipo Tipo de ordenamiento 
    * @return sql
    */
   public static String getInstruccionTerminadaUsuario(String strIdUsuario, String orden, String tipo)
   {
       String sql = "";
       sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, " +
       		"TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), " +
       		"TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
       		"INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, " +
       		"INS_INSTRUCCION_OTRO, INS_TIEMPO, INS_AVANCE, " +
			"INS_USUARIO, USU_ASISTENTE, USU_JEFE, INS_HABILITADA, " +
			"TO_CHAR(INS_FECHA_TERMINACION_REAL, 'yyyy-MM-dd'), " +
			"INS_CONFIDENCIAL, INS_TURNO, INS_PADRE, INS_FECHA_ASIGNACION " +
       		"FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, " +
       		"SD_ASUNTO WHERE INS_USUARIO="+strIdUsuario+" AND " +
       		"SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO " +
       		"AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
       		//"AND INS_AVANCE=100.0";
       		"AND INS_ESTATUS=4 AND INS_BANDERA1=0 " +
			"ORDER BY " + tipo + " " + orden + ", 7 ASC";
       return sql;
   }
   
   /**
    * Regresa query de instrucciones Rechazadas 
    * @param strIdUsuario ID usuario 
    * @param orden Orden 
    * @param tipo Tipo de ordenamiento 
    * @return sql
    */
   public static String getInstruccionRechazadaUsuario(String strIdUsuario, String orden, String tipo)
   {
       String sql = "";
       sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
       		"INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, INS_INSTRUCCION_OTRO, INS_TIEMPO, INS_AVANCE, INS_USUARIO, USU_ASISTENTE, USU_JEFE, " +
       		"INS_FECHA_ASIGNACION, INS_HABILITADA, INS_PADRE "+
			"FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, " +
       		"SD_ASUNTO WHERE INS_USUARIO="+strIdUsuario+" AND " +
       		"SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO AND " +
       		"SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
       		"AND INS_ESTATUS=3 AND INS_BANDERA1=0 " +
       		"ORDER BY "+tipo+" "+orden + ", 7 ASC";
       return sql;
   }
   
   /**
    * Regresa query para obtener datos de instrucciones 
    * @param strIdInstruccion ID instruccion 
    * @return sql 
    */
   public static String getInstruccionDatos(String strIdInstruccion)//INS_HABILITADA
   {
       String sql = "";
       sql = "SELECT INS_USUARIO, INS_INSTRUCCION, INS_PASO, INS_TIPO_ATENCION, INS_ACCESO, INS_REQUERIDO, " + //6
       		"INS_CONFIDENCIAL, TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), " + //8
       		"TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), INS_INSTRUCCION_OTRO, " + //10
       		"ASU_DESCRIPCION, ASU_SINTESIS, ASU_USR_TURNA, USU_NOMBRE, USU_TELEFONO, USU_CORREO, " + //16
       		"ASU_FOLIO_RECEPCION, ASU_FOLIO_INTERMEDIO, INS_FOLIO_TURNADO, INS_ESTATUS, INS_AVANCE, " + //21
       		"INS_USR_DELEGADO, INS_PADRE, " + //23
			"INS_IMG_FIRMA, TO_CHAR(INS_FECHA_TERMINACION_REAL, 'yyyy-MM-dd'), USU_ASISTENTE, " + //26
			"USU_JEFE, ID_USUARIO, USU_AREA, TO_CHAR(INS_FECHA_CAMBIO, 'yyyy-MM-dd'), INS_HABILITADA, " + //31
			"INS_BANDERA, USU_CARGO, INS_BANDERA1, INS_TURNO, INS_BANDERA3, INS_ENTRADA, INS_USUARIO_TERMINO "+ //38
       		"FROM SD_INSTRUCCION_ASUNTO, SD_ASUNTO, SD_USUARIO " +
       		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion+" AND SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO " +
       		"AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO ";
       return sql;
   }
   
   /**
    * Función que regresa el ID del Asunto a la que pertenece la instrucción
    * @param strIdInstruccion String que recibe el ID de la Instruccion
    * @return sql 
    */
   public static String getIdAsuntoInstruccion(String strIdInstruccion)
   {
       String sql = "";
       sql = "SELECT ID_ASUNTO FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
       return sql;
   }
   
   /**
    * Función que regresa el query que actualiza el Avance en la tabla de
    * SD_INSTRUCCION_ASUNTO
    * @param strIdInstrucion Id instrucción
    * @param strAvance Avance
    * @param strEstatus Estatus
    * @param evento Evento
    * @param usuarioOriginal usuario original
    * @param liberado Liberado
    * @param id_historial Id historial
    * @param firmarDigitalmente firma
    * @param strFechaTerminacionReal Fecha terminación
    * @return Query
    */
   public static String ActualizarAvance(String strIdInstrucion, String strAvance, String strEstatus,
           								String evento, String usuarioOriginal, String liberado, String id_historial,
										String firmarDigitalmente, String strFechaTerminacionReal)
   {
       String sql = "";
       if(liberado.equals("0")){
       	////System.out.println("***es una Delegación que le pasa el control al usuario original********");
       	   if(new Float(strAvance).floatValue() >=100){
       	 ////System.out.println("ENTRA1");
       	   		sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE=99, " +
				"INS_ESTATUS=2, INS_USUARIO="+usuarioOriginal+" WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
       	   		
       	   		ActualizaInstrucciones.getActualizarVigencia(id_historial);
       	   }else{
       	 ////System.out.println("ENTRA2");
       	   		sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", " +
				"INS_ESTATUS=2 WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
       	   		
       	   }
       	////System.out.println("sql="+sql);
           
           return sql;
       }
       //** Si la instrucción esta por atender y se le asigna un avance < al
       //** 100%, hace el cambio a una instrucción en tramite
       else if(strEstatus.equals("1") && !strAvance.equals("100")){
           sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", " +
       			"INS_ESTATUS=2, INS_IMG_FIRMA="+firmarDigitalmente+" WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
           ////System.out.println("sql="+sql);
           return sql;
       }
       //** Si la instrucción esta por atender y le le asigna un avance del
       //** 100%, entonces cambia el estatus de la instrucción a terminada
       else if(strEstatus.equals("1") && strAvance.equals("100")){
           
           String strDates[][] = ActualizaAsuntoTurnado.FechasAsignacion(strIdInstrucion);
           String fechaInicio = strDates[0][0];
           Calendar cFechaInicio	=	Utilerias.StringCalendar(fechaInicio);
           Calendar cFechaFin 		=	Utilerias.StringCalendar(strFechaTerminacionReal);
           int real 				= 	Utilerias.DiasdeTrabajoEntre(cFechaInicio, cFechaFin, 0);
           String strFechaR			=	Utilerias.formatearFechas(strFechaTerminacionReal);
           
           sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", " +
  				"INS_ESTATUS=4, INS_IMG_FIRMA="+firmarDigitalmente+", " +
  				//"INS_FECHA_TERMINACION_REAL='"+strFechaR+"', " +
  				"INS_FECHA_TERMINACION_REAL=TO_DATE('"+strFechaR+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'DD/MM/YYYY HH24:MI:SS'), " +
  				"INS_TIEMPO_REAL="+real+" WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
           ////System.out.println("sql="+sql);
           return sql;
       }
       //** Si la instrucción esta en tramite y se le da un avance que sea menor a
       //** 100%, entonces actualiza el avance
       else if(strEstatus.equals("2") && !strAvance.equals("100")){
           sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+" " +
           		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
           ////System.out.println("sql="+sql);
           return sql;
       }
       else if(strEstatus.equals("2") && strAvance.equals("100")){
           //** Si la instrucción esta en tramite y se le da un avance del 100%,
           //** entonces actuliza el estatus por terminado y el avance. Además
           //** toma en cuenta si la instrucción tiene algun evento en el historial
           if(evento.length() == 0 && usuarioOriginal.length() == 0){
           	////System.out.println("***No tiene el evento de Delegación");
               
               String strDates[][] = ActualizaAsuntoTurnado.FechasAsignacion(strIdInstrucion);
               String fechaInicio = strDates[0][0];
               Calendar cFechaInicio	=	Utilerias.StringCalendar(fechaInicio);
               Calendar cFechaFin 		=	Utilerias.StringCalendar(strFechaTerminacionReal);
               int real 				= 	Utilerias.DiasdeTrabajoEntre(cFechaInicio, cFechaFin, 0);
               String strFechaR			=	Utilerias.formatearFechas(strFechaTerminacionReal);
               
               sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", " +
               	"INS_ESTATUS=4, INS_IMG_FIRMA="+firmarDigitalmente+", " +
               	"INS_FECHA_TERMINACION_REAL=TO_DATE('"+strFechaR+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'DD/MM/YYYY HH24:MI:SS'), INS_TIEMPO_REAL="+real+" WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
               ////System.out.println("sql="+sql);
               return sql;
           }
           else if(evento.length() != 0 && usuarioOriginal.length() != 0 && liberado.equals("1")){
           	// //System.out.println("***Entra actualizar sin eventoBBBBBBB");
               
               String strDates[][] = ActualizaAsuntoTurnado.FechasAsignacion(strIdInstrucion);
               String fechaInicio = strDates[0][0];
               Calendar cFechaInicio	=	Utilerias.StringCalendar(fechaInicio);
               Calendar cFechaFin 		=	Utilerias.StringCalendar(strFechaTerminacionReal);
               int real 				= 	Utilerias.DiasdeTrabajoEntre(cFechaInicio, cFechaFin, 0);
               
               sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", " +
              	"INS_ESTATUS=4, INS_TIEMPO_REAL="+real+" WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
               ////System.out.println("sql="+sql);
               return sql;
           }
           
       }
       return sql;
   }
   
   /**
    * Regresa query para actualizar rechazo 
    * @param strIdInstruccion ID instruccion 
    * @param strAvance Avance 
    * @return sql 
    */
   public static String ActualizarRechazo(String strIdInstruccion, String strAvance)
   {
       String sql = "";
       sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", INS_ESTATUS=3 " +
       		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
       return sql;
   }
   
   /**
    * Regresa query para actualizar reasignar 
    * @param strIdInstruccion ID instruccion 
    * @param strIdUsuario ID usuario 
    * @param strAvance Avance 
    * @return sql 
    */
   public static String ActualizaReasignar(String strIdInstruccion, String strIdUsuario, String strAvance)
   {
       String sql = "";
       if(strAvance.equals("0")){
       	    sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_USUARIO="+strIdUsuario+", INS_ESTATUS=1 " +
       			"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
       }
       else{
           sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_USUARIO="+strIdUsuario+" " +
  			"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
       }
       return sql;
   }
   
   /**
    * Regresa query para actualizar delegar 
    * @param strIdInstruccion ID instruccion 
    * @param strAvance Avance 
    * @param strIdUsuario ID usuario 
    * @return sql 
    */
   public static String ActualizaDelegar(String strIdInstruccion, String strAvance, String strIdUsuario)
   {
       String sql = "";
       sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_USR_DELEGADO="+strIdUsuario+", INS_USUARIO="+strIdUsuario+", " +
       		"INS_ESTATUS=2 WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
       return sql;
   }
   
   /**
    * Función que retrna un query que determina si existen Instrucciones
    * en tramite
    * @param strIdUsuario ID usuario
    * @return sql
    */
   public static String TieneInstruccionesEnTramite(String strIdUsuario)
   {
       String sql = "";
       sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=2 AND INS_BANDERA1=0 AND INS_USUARIO="+strIdUsuario;
       return sql;
   }
   
   /**
    * Función que retrna un query que determina si existen Instrucciones
    * por atender
    * @param strIdUsuario ID usuario
    * @return sql
    */
   public static String TieneInstruccionesPorAtender(String strIdUsuario)
   {
       String sql = "";
       //sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=1 AND INS_BANDERA1=0 AND INS_USUARIO="+strIdUsuario;
       sql  = "SELECT COUNT (ID_INSTRUCCION_ASUNTO) FROM (SD_INSTRUCCION_ASUNTO INNER JOIN SD_ASUNTO ON SD_INSTRUCCION_ASUNTO.ID_ASUNTO = SD_ASUNTO .ID_ASUNTO) INNER JOIN SD_USUARIO ON INS_USUARIO = ID_USUARIO WHERE INS_ESTATUS = 1 AND INS_BANDERA1 = 0 AND ID_USUARIO = "+strIdUsuario;
       return sql;
   }
   
   /**
    * Función que retrna un query que determina si existen Instrucciones
    * Terminadas
    * @param strIdUsuario ID usuario 
    * @return sql
    */
   public static String TieneInstruccionesTerminadas(String strIdUsuario)
   {
       String sql = "";
       sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=4 AND INS_BANDERA1=0 AND INS_USUARIO="+strIdUsuario;
       return sql;
   }
   
   /**
    * Función que retrna un query que determina si existen Instrucciones
    * Rechazadas 
    * @param strIdUsuario ID usuario 
    * @return sql 
    */
   public static String TieneInstruccionesRechazadas(String strIdUsuario)
   {
       String sql = "";
       sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_USUARIO="+strIdUsuario;
       return sql;
   }
   
   /**
    * Función que retrna un query que determina si existen Instrucciones
    * rechazadas
    * @return sql
    */
   public static String TieneInstruccionesRechazadas()
   {
       String sql = "";
       sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=3 AND INS_BANDERA1=0";
       return sql;
   }
   
   /**
    * Regresa query para instrucciones por Asunto 
    * @param strIdAsunto ID Asunto 
    * @return sql  
    */
   public static String InstruccionPorIdAsunto(String strIdAsunto)
   {
       String sql = "";
       sql = "SELECT INS_PASO, INS_USUARIO, INS_INSTRUCCION, TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), " +
       		" TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
       		" INS_AVANCE, INS_ESTATUS, INS_INSTRUCCION_OTRO, USU_NOMBRE, " +
       		" USU_AREA, PAS_DESCRIPCION, ID_INSTRUCCION_ASUNTO," +
       		" PAS_SECUENCIA, INS_TIEMPO, ID_INSTRUCCION_ASUNTO, INS_PADRE, " +
       		" INS_HABILITADA, INS_TIEMPO_REAL, INS_BANDERA, USU_CARGO " +
       		" FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_PASO " +
       		" WHERE ID_ASUNTO="+strIdAsunto+" " +
       		" AND INS_PADRE IS NULL " +
       		" AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO" +
       		" AND SD_PASO.ID_PASOS=SD_INSTRUCCION_ASUNTO.INS_PASO" +
       		" ORDER BY 13, 15";
       return sql;
   }
   
   /**
    * Regresa query para instrucciones por ID 
    * @param strIdInstruccion ID de instruccion 
    * @return sql
    */
   public static String InstruccionPorIdInstruccion(String strIdInstruccion)
   {
       String sql = "";
       sql = "SELECT INS_PASO, INS_USUARIO, INS_INSTRUCCION, TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
       		" INS_AVANCE, INS_ESTATUS, INS_INSTRUCCION_OTRO, USU_NOMBRE, USU_AREA, PAS_DESCRIPCION, ID_INSTRUCCION_ASUNTO," +
       		" PAS_SECUENCIA, INS_TIEMPO, ID_INSTRUCCION_ASUNTO, INS_PADRE, INS_HABILITADA, INS_TIEMPO_REAL, INS_BANDERA, USU_CARGO " +
       		" FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_PASO " +
       		" WHERE INS_PADRE="+strIdInstruccion+"" +
       		" AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO" +
       		" AND SD_PASO.ID_PASOS=SD_INSTRUCCION_ASUNTO.INS_PASO" +
       		" ORDER BY 13, 15";
       return sql;
   }
   
   /**
    * Verifica si hay instrucciones por asunto 
    * @param strIdAsunto ID asunto 
    * @return sql
    */
   public static String TieneInstrucciones(String strIdAsunto)
   {
       String sql = "";
       sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
       return sql;
   }
   
   /**
    * Regresa query de tiempo de instrucciones 
    * @param strIdAsunto ID del asunto 
    * @return sql
    */ 
   public static String getTimeInstrucciones(String strIdAsunto)
   {
       String sql = ""; 
       sql = "SELECT INS_TIEMPO, PAS_SECUENCIA, ID_INSTRUCCION_ASUNTO, " +
       		"INS_USUARIO, USU_CORREO, INS_REQUERIDO, USU_AREA, INS_INSTRUCCION, INS_TIPO_ATENCION " +
       		"FROM SD_INSTRUCCION_ASUNTO, SD_PASO, SD_USUARIO " +
       		"WHERE ID_ASUNTO="+strIdAsunto+" AND INS_ESTATUS=0 " +
       		"AND SD_PASO.ID_PASOS=SD_INSTRUCCION_ASUNTO.INS_PASO " +
       		"AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
       		"AND INS_PADRE IS NULL " +
       		"ORDER BY 2, 3 ASC";
       // //System.out.println("SQL="+sql);
       return sql;
   }
   
   /**
    * Regresa query de tiempo de instrucciones habilitadas 
    * @param strIdInstruccion ID instruccion 
    * @return sql 
    */
   public static String getTimeInstruccionesHabilitadas(String strIdInstruccion)
   {
       String sql = ""; 
       sql = "SELECT INS_TIEMPO, PAS_SECUENCIA, ID_INSTRUCCION_ASUNTO FROM SD_INSTRUCCION_ASUNTO, SD_PASO " +
       		"WHERE INS_PADRE="+strIdInstruccion+" AND INS_ESTATUS=0 " +
       		"AND SD_PASO.ID_PASOS=SD_INSTRUCCION_ASUNTO.INS_PASO";
       ////System.out.println("SQL="+sql);
       return sql;
   }
   
   /**
    * Función que regresa un query para actualizar la fecha de inicio y fin
    * de una instrucción al ser turnado el asunto.
    * @param strIdInstruccion String COntiene el ID de la instrucción a la que se le va a actualizar las fechas.
    * @param strFechaInicio	Fecha inicial.
    * @param strFechaFin Fecha final.
    * @param strTurnador Turnador.
    * @param strAreaOrigen Area Origen.
    * @param strAreaInst Area de la instruccion.
    * @param iBandera Si es de otra instrucción o no.
    * @param nombreInst Nombre de la sintruccion.
    * @return sql 
    */
   	public static String UpdateInstruccionTurnado(String strIdInstruccion, String strFechaInicio,String strFechaFin, String strTurnador,String strAreaOrigen, String strAreaInst,int iBandera, String nombreInst){            
                strTurnador = Usuario.esAsistente(strTurnador)?Usuario.aTitular(strTurnador):strTurnador;
   		String instruccion = "";
   		if(iBandera==0)
   			instruccion = ", INS_INSTRUCCION=null, INS_INSTRUCCION_OTRO='"+nombreInst+"' ";
   		
   		String sql = "";
   		if(strAreaOrigen.equals(strAreaInst)){
   			sql = "UPDATE SD_INSTRUCCION_ASUNTO SET " +
       				"INS_FECHA_ASIGNACION=TO_DATE('"+strFechaInicio+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'DD/MM/YYYY HH24:MI:SS'), " +
					" INS_FECHA_TERMINACION=TO_DATE('"+strFechaFin+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'DD/MM/YYYY HH24:MI:SS'), " +
					" INS_ESTATUS=1, INS_TURNO="+strTurnador+" " +
					" "+instruccion+" " +
					"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
   		}
   		else{//Se habilita la instruccion para returnar y se le agrega una bandera que la identifica como ventanilla
   			sql = "UPDATE SD_INSTRUCCION_ASUNTO SET " +
       				"INS_FECHA_ASIGNACION=TO_DATE('"+strFechaInicio+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'DD/MM/YYYY HH24:MI:SS'), " +
					" INS_FECHA_TERMINACION=TO_DATE('"+strFechaFin+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'DD/MM/YYYY HH24:MI:SS'), " +
					" INS_ESTATUS=1, INS_TURNO="+strTurnador+", INS_HABILITADA=1, INS_BANDERA1=1 " +
					" "+instruccion+" " +
					" WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
       	}
   		return sql;
   	}
   

   /**
    * Regresa query para insertar instrucción
    * @param strIdUsuario ID usuario 
    * @param strIdInstruccion ID instrucción
    * @param strInstruccionOtro Descripcion de la instrucción
    * @param strAtencion Tipo de atencion 
    * @param strPaso Paso 
    * @param strTiempo Tiempo de la instrucción
    * @param strAcceso Permiso de acceso 
    * @param strRequerido Instruccion requerida 
    * @param strConfidencial Instruccion confidencial 
    * @param strIdAsunto ID del asunto 
    * @return sql
    */
   public static String insertaInstruccion(	String strIdUsuario, String strIdInstruccion, 
   											String strInstruccionOtro, String strAtencion, 
											String strPaso, String strTiempo, String strAcceso,
           									String strRequerido, String strConfidencial, String strIdAsunto)
   	{
   		String sql = "";
   		if(strIdAsunto.length() == 0){
   			sql = "INSERT INTO SD_INSTRUCCION_ASUNTO (ID_INSTRUCCION_ASUNTO, INS_USUARIO, ";
   			sql +="INS_INSTRUCCION, INS_INSTRUCCION_OTRO, INS_TIPO_ATENCION, INS_PASO, INS_TIEMPO, ";
   			sql +="INS_ACCESO, INS_REQUERIDO, INS_CONFIDENCIAL, ID_ASUNTO, ";
   			sql +="INS_ESTATUS, INS_AVANCE) VALUES (SD_INSTRUCCION_ASUNTO_SEQ.NEXTVAL, "+strIdUsuario+", ";
   			if(strIdInstruccion.length() == 0)
   				sql +="null, ";
   			else
   				sql +=""+strIdInstruccion+", ";
   			sql +="'"+strInstruccionOtro+"', "+strAtencion+", ";
   			sql +=""+strPaso+", "+strTiempo+", "+strAcceso+", "+strRequerido+", ";
   			sql +=""+strConfidencial+", ";
   			sql +="(SELECT MAX(ID_ASUNTO) FROM SD_ASUNTO), 0, 0)";
   		}else{
   			sql = "INSERT INTO SD_INSTRUCCION_ASUNTO (ID_INSTRUCCION_ASUNTO, INS_USUARIO, ";
   			sql +="INS_INSTRUCCION, INS_INSTRUCCION_OTRO, INS_TIPO_ATENCION, INS_PASO, INS_TIEMPO, ";
   			sql +="INS_ACCESO, INS_REQUERIDO, INS_CONFIDENCIAL, ID_ASUNTO, ";
   			sql +="INS_ESTATUS, INS_AVANCE) VALUES (SD_INSTRUCCION_ASUNTO_SEQ.NEXTVAL, "+strIdUsuario+", ";
   			if(strIdInstruccion.length() == 0)
   				sql +="null, ";
   			else
   				sql +=""+strIdInstruccion+", ";
   			sql +="'"+strInstruccionOtro+"', "+strAtencion+", ";
   			sql +=""+strPaso+", "+strTiempo+", "+strAcceso+", "+strRequerido+", ";
   			sql +=""+strConfidencial+", ";
   			sql +=""+strIdAsunto+", 0, 0)";
   		}
   		return sql;
   	}
   
   /**
    * Actualiza folio de instrucción
    * @param strIdInstruccion ID instruccion 
    * @param folio Folio
    * @return sql
    */
   public static String UpdateFolioInstruccion(String strIdInstruccion, String folio/*, String strSalida*/)
   {
       String sql = "";
       sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_FOLIO_TURNADO='"+folio+"' " +
       		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
       return sql;
   }
   
   /**
    * Función que regresa un query, donde se trae el nombre del Asunto y
    * el nombre de la instrucción
    * @param strIdInstruccion String Contienes el ID de la instrucción
    * @return Query
    */
   public static String getNombreInstruccion(String strIdInstruccion)
   {
       String sql = "";
       sql = "SELECT ASU_DESCRIPCION, INS_INSTRUCCION, INS_INSTRUCCION_OTRO, INS_USUARIO, ASU_USR_TURNA," +
       		"INS_PADRE, INS_HABILITADA, INS_FOLIO_TURNADO " +
       		"FROM SD_ASUNTO, SD_INSTRUCCION_ASUNTO " +
       		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion+" " +
       		"AND SD_INSTRUCCION_ASUNTO.ID_ASUNTO=SD_ASUNTO.ID_ASUNTO";
       return sql;
   }
   
   /**
    * Funcion que regresa un query donde se muestra la secuencia a la que pertenece 
    * el Id de la instrucción
    * @param strIdInstruccion Contiene el ID de la instrucción
    * @return Query
    */
   public static String getPasoPertenece(String strIdInstruccion)
   {
       String sql = "";
       sql = "SELECT PAS_SECUENCIA FROM SD_PASO, SD_INSTRUCCION_ASUNTO " +
       		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion+" " +
       		"AND SD_INSTRUCCION_ASUNTO.INS_PASO=SD_PASO.ID_PASOS";
       return sql;
   }
   
   /**
    * Función que regresa un query con el numero total de instrucciones que 
    * tienen un campo requerido
    * @param strIdAsunto Contiene el ID del Asunto
    * @param secuencia Contiene la secuencia a la que pertenece la instrucción que se acaba de terminar
    * @return Query
    */
   public static String getCountInstruccionesRequeridas(String strIdAsunto, String secuencia)
   {
       String sql = "";
       sql = "SELECT COUNT(INS_REQUERIDO) FROM SD_PASO, SD_INSTRUCCION_ASUNTO " +
       		"WHERE ID_ASUNTO="+strIdAsunto+" AND PAS_SECUENCIA="+secuencia+" " +
       		"AND INS_ESTATUS !=4 AND INS_REQUERIDO=1 " +
       		"AND INS_PADRE IS NULL " +
       		"AND SD_INSTRUCCION_ASUNTO.INS_PASO=SD_PASO.ID_PASOS";
       return sql;
   }
   
   /**
    * Funcion que verifica si existen instrucciones del mismo paso con un 
    * estatus cero, osea que fueron creados en el applet
    * @param strIdAsunto
    * @param secuencia
    * @return
    */
   public static String getCountInstCreadasSinTurnar(String strIdAsunto, String secuencia){
   		String sql = "";
   		sql = "SELECT COUNT(INS_REQUERIDO) FROM SD_PASO, SD_INSTRUCCION_ASUNTO " +
    		"WHERE ID_ASUNTO="+strIdAsunto+" AND PAS_SECUENCIA="+secuencia+" " +
    		"AND INS_ESTATUS=0  " +
    		"AND INS_PADRE IS NULL " +
    		"AND SD_INSTRUCCION_ASUNTO.INS_PASO=SD_PASO.ID_PASOS";
   		return sql;
   }
   
   /**
    * Función que regresa un query con el numero total de instrucciones que 
    * tienen un campo requerido
    * @param idPadre ID instruccion padre 
    * @param secuencia Secuencia 
    * @return sql
    */
   public static String getCountInstruccionesRequeridasPadre(String idPadre, String secuencia)
   {
       String sql = "";
       sql = "SELECT COUNT(INS_REQUERIDO) FROM SD_PASO, SD_INSTRUCCION_ASUNTO " +
       		"WHERE INS_PADRE="+idPadre+" AND PAS_SECUENCIA="+secuencia+" " +
       		"AND INS_ESTATUS !=4 AND INS_REQUERIDO=1 " +
       		"AND SD_INSTRUCCION_ASUNTO.INS_PASO=SD_PASO.ID_PASOS";
       return sql;
   }
   
   /**
    * Función que regresa un query donde se mostrara las fechas
    * de inicio y fin de una instrucción por medio de su Id
    * @param strIdInstruccion Contiene el Id de la instrucción
    * @return Query
    */
   public static String getFechasInstruccion(String strIdInstruccion)
   {
       String sql = "";
       sql = "SELECT TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd') " +
       		"FROM SD_INSTRUCCION_ASUNTO " +
       		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
       return sql;
   }
   
   /**
    * Actualiza cambio de fecha 
    * @param fechaCambio Cambio de Fecha 
    * @param idInstruccion ID instruccion 
    * @param comentario comentario 
    * @return sql 
    */
   public static String actualizarFechaCambio(String fechaCambio, String idInstruccion, String comentario)
   {
       String sql = "";
       sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_FECHA_CAMBIO=TO_DATE('"+fechaCambio+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'DD/MM/yyyy HH24:MI:SS'), " +
       		"INS_COMENTARIO='"+comentario+"' " +
       		"WHERE ID_INSTRUCCION_ASUNTO="+idInstruccion;
       return sql;
   }
   
   /**
    * Función que regresa un query, donde muestrs una la fecha de cambio de solicitud,
    * la fecha original de vencimiento y el comentario o Razón por la que se quiere
    * cambiar
    * @param strIdInstruccion Contiene el ID de la instrucción
    * @return Query
    */
   public static String getSolicitudCambio(String strIdInstruccion)
   {
       String sql = "";
       sql = "SELECT TO_CHAR(INS_FECHA_CAMBIO, 'yyyy-MM-dd'), INS_COMENTARIO, TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
       		"USU_NOMBRE, USU_CORREO FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO " +
       		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion+" " +
       		"AND SD_INSTRUCCION_ASUNTO.INS_USUARIO=SD_USUARIO.ID_USUARIO";
       return sql;
   }
   
   /**
    * Función que regresa un query, donde muestrs una la fecha de cambio de solicitud,
    * la fecha original de vencimiento y el comentario o Razón por la que se quiere
    * cambiar
    * @param strIdInstruccion Contiene el ID de la instrucción
    * @return Query
    */
   public static String getSolicitudCambioId(String strIdInstruccion)
   {
       String sql = "";
       sql = "SELECT TO_CHAR(INS_FECHA_CAMBIO, 'yyyy-MM-dd'), INS_COMENTARIO, TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
       		"USU_NOMBRE, USU_CORREO, ID_USUARIO, USU_CARGO FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO " +
       		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion+" " +
       		"AND SD_INSTRUCCION_ASUNTO.INS_USUARIO=SD_USUARIO.ID_USUARIO";
       return sql;
   }
   
   /**
    * Función que regresa un query, donde se actualiza la fecha de terminación de
    * una instruccion, al ser aceptado el cambio de fecha
    * @param strIdInstruccion Contiene el ID de la instrucción
    * @param fecha Contiene la fecha que sera cambiada
    * @return Query
    */
   public static String actualizaFechaVencimiento(String strIdInstruccion, String fecha)
   {
       String sql = "";
       sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_FECHA_TERMINACION=TO_DATE('"+fecha+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'dd/MM/yyyy HH24:MI:SS'), INS_FECHA_CAMBIO=null " +
       		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
       return sql;
   }
   
   /**
    * Función que regresa un query, donde actualiza si la instrución va a ser habilitada
    * @param idInstruccion Contiene el Id de la Instrución
    * @param n con esta varialbe se determina si la instruccion se habilitara o deshbilitara
    * @param strB Bandera de instruccion 
    * @return Query
    */
   public static String actualizaHabilitado(String idInstruccion, int n, String strB)
   {
       String sql = "";
       //** n = 1 prepara la instrucción para habilitar turnado
       if(n == 1){
           sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_HABILITADA=1, INS_BANDERA3="+strB+" " +
       			"WHERE ID_INSTRUCCION_ASUNTO="+idInstruccion;
       }else if(n == 0){//** n = 0 desabilita la instrucción para turnarse
           sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_HABILITADA=0, INS_BANDERA3="+strB+" " +
  			"WHERE ID_INSTRUCCION_ASUNTO="+idInstruccion;
       }
       return sql;
   }
   
   /**
    * Función que regresa un query, donde verifica si es padre la instruccion
    * @param idInstruccion Contiene el Id de la Instruccion
    * @return Query
    */
   public static String getTieneHijos(String idInstruccion)
   {
       String sql = "";
       sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_PADRE="+idInstruccion;
       return sql;
   }
   
   /**
    * Actualiza instruccion informativa 
    * @param strIdInstruccion ID instruccion 
    * @param strFechaTerminacion Fecha de terminacion 
    * @param strTiempoReal Tiempo de terminacion real 
    * @return sql 
    */
   public static String getTerminaInstruccionInsformativa(	String strIdInstruccion, 
   															String strFechaTerminacion, 
															int strTiempoReal){
   		String sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE=0, " +
					" INS_ESTATUS=1, INS_IMG_FIRMA=0 " +
					//" INS_FECHA_TERMINACION_REAL=TO_DATE('"+strFechaTerminacion+"', 'DD/MM/YYYY'), " +
					//" INS_TIEMPO_REAL="+strTiempoReal+" "+
   					" WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
   		return sql;
   }
   
   /**
    * Detalle de las instrucciones 
    * @param strIdAsunto ID Asunto 
    * @return sql 
    */
   public static String getInstruccionesMail(String strIdAsunto){
       String sql = "SELECT INS_FOLIO_TURNADO, USU_NOMBRE,  USU_CORREO, USU_CARGO, USR.ID_USUARIO " +
       		" FROM SD_INSTRUCCION_ASUNTO INS, SD_USUARIO USR " +
       		" WHERE ID_ASUNTO="+strIdAsunto+ " AND INS_PADRE IS NULL "+
       		" AND USR.ID_USUARIO=INS.INS_USUARIO ";
       //System.out.println(sql);
       return sql;
   }
   
   /**
    * Detalle de las instrucciones 
    * @param strIdAsunto ID Asunto 
    * @return sql 
    */
   public static String getInstruccionesDetalle(String strIdAsunto){
       String sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, INS_INSTRUCCION_OTRO, " +
       		"USU_NOMBRE, TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), INS_ESTATUS " +
       		"FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO " +
       		"WHERE ID_ASUNTO="+strIdAsunto+" " +
       		"AND INS_PADRE IS NULL " +
       		"AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
       		"ORDER BY 1";
       return sql;
   }
   
   /**
    * Función que regresa un query, donde regresa el avance de la instruccion
    * @param strIdInstruccion ID instruccion 
    * @return sql 
    */
   public static String getAvance(String strIdInstruccion){
       String sql = "SELECT INS_AVANCE FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
       return sql;
   }
   
   /**
    * Actualiza bandera 
    * @param strIdInstruccion ID instruccion 
    * @return sql
    */
   public static String updateBandera(String strIdInstruccion){
   		String sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_BANDERA=1 WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
   		return sql;
   }
   
   /**
    * Función que trae un query con el id del turnador de la instrucion
    * @param strIdInstruccion ID instruccion 
    * @return sql
    */
   public static String getTurnador(String strIdInstruccion){
   	String sql = "SELECT INS_TURNO FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
		return sql;
   }
   
   	/**
   	 * Función que se encarga de insertar instruccioens a partir de los paras
   	 * @param strIdUs ID usuario 
   	 * @param strIdAsunto ID Asunto
   	 * @param strAt Atencion 
   	 * @param strPas Paso
   	 * @param strIdPadre ID instruccion padre 
   	 * @param strDuracion duración 
   	 * @param strNombreInstruccionDesExt Nombre de la instruccion 
   	 * @return sql
   	 */
   	public static String insertaInstruccionParaCC(	String strIdUs, String strIdAsunto, 
   													String strAt, String strPas,
													String strIdPadre, String strDuracion,
													String strNombreInstruccionDesExt)
   	{
   	
   		String sql = "";
   		sql = "INSERT INTO SD_INSTRUCCION_ASUNTO (ID_INSTRUCCION_ASUNTO, INS_USUARIO, ";
   		sql +="INS_INSTRUCCION, INS_INSTRUCCION_OTRO, INS_TIPO_ATENCION, INS_PASO, INS_TIEMPO, ";
   		sql +="INS_ACCESO, INS_REQUERIDO, INS_CONFIDENCIAL, ID_ASUNTO, ";
   		sql +="INS_ESTATUS, INS_AVANCE, INS_PADRE, INS_AUTO) VALUES (SD_INSTRUCCION_ASUNTO_SEQ.NEXTVAL, "+strIdUs+", ";
   		sql +="null, ";
   		if(strNombreInstruccionDesExt.length()==0)
   			sql +="null, ";
   		else
   			sql +="'"+strNombreInstruccionDesExt+"', ";
   		if(strAt.equals("0"))
   			sql +=" 0, ";
   		else
   			sql +=" 1, ";
   		sql +=""+strPas+", "+strDuracion+", 1, 0, ";
   		sql +="0, ";
   		sql +=""+strIdAsunto+", 0, 0,";
   		if(strIdPadre != null && strIdPadre.length() > 0){
   			sql +=" "+strIdPadre+", 1)";
   		}else{
   			sql +=" null, 1)";
   		}
   		
   	
   		return sql;
   	}
   	
   	/**
   	 * Función que verifica si existen instrucicones hijas nuevas
   	 * @param idInstruccion ID instruccion 
   	 * @return sql 
   	 */
   	public static String getTieneHijosPorTurnar(String idInstruccion)
    {
        String sql = "";
        sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=0 AND INS_PADRE="+idInstruccion;
        return sql;
    }
   	
   	/**
   	 * Función que trae el id de area del usuario que turna el asunto
   	 * original
   	 * @param strIdAsunto ID asunto 
   	 * @return sql 
   	 */
   	public static String getIdAreaOrigen(String strIdAsunto){
   		String sql = "SELECT USU_AREA FROM SD_USUARIO, SD_ASUNTO " +
   				"WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
   				"AND ID_ASUNTO="+strIdAsunto;
   		return sql;
   	}
   	
   	/**
   	 * Función que trae el id de area del usuario que turna la instruccion
   	 * @param strIdInsPadre ID instruccion Padre 
   	 * @return sql 
   	 */
   	public static String getIdAreaOrigenInst(String strIdInsPadre){
   		String sql = "SELECT USU_AREA FROM SD_USUARIO, SD_INSTRUCCION_ASUNTO " +
   				"WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
   				"AND INS_PADRE="+strIdInsPadre;
   		return sql;
   	}
   	
   	/**
   	 * Regresa query de Area por instrucción  
   	 * @param strIdinstruccion ID instruccion 
   	 * @return sql
   	 */
   	public static String getAreaFoleo(String strIdinstruccion){
    	String sql = "SELECT ID_AREA, ARE_CLAVE FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_AREA " +
    			"WHERE SD_INSTRUCCION_ASUNTO.INS_USUARIO=SD_USUARIO.ID_USUARIO " +
    			"AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA AND ID_INSTRUCCION_ASUNTO="+strIdinstruccion; 
    	return sql;
    }
   	
   	/**
   	 * Folio de entrada
   	 * @param strIdInstruccion id instrucción
   	 * @return query
   	 */
   	public static String getExisteFolioEntradaInstruccion(String strIdInstruccion){
    	String sql = "SELECT INS_ENTRADA FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion+"";
    	return sql;
    }
   	
   	/**
   	 * Folio de salida
   	 * @param strIdInstruccion id instrucción
   	 * @return query
   	 */
   	public static String getExisteFolioSalidaInstruccion(String strIdInstruccion){
    	String sql = "SELECT INS_SALIDA FROM SD_INSTRUCCION_ASUNTO ID_INSTRUCCION_ASUNTO="+strIdInstruccion+"";
    	return sql;
    }
   	
   	/**
   	 * Folio de entrada
   	 * @param strFolio folio 
   	 * @param stridInstruccion instrucción
   	 * @return query
   	 */
   	public static String setFolioEntrada(String strFolio ,String stridInstruccion){
    	String sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_ENTRADA='"+strFolio+"' WHERE ID_INSTRUCCION_ASUNTO="+stridInstruccion;
    	return sql;
    }
   	
   	/**
   	 * Folio salida
   	 * @param strFolio  Folio
   	 * @param stridInstruccion Id instrucción
   	 * @return Query
   	 */
   	public static String setFolioSalida(String strFolio ,String stridInstruccion){
    	String sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_SALIDA='"+strFolio+"' WHERE ID_INSTRUCCION_ASUNTO="+stridInstruccion;
    	return sql;
    }
   	
   	/**
   	 * Función que verifica con un query si existen folios de entrada
   	 * @param stridArea ID Area 
   	 * @return query
   	 */
   	public static String getExistenFolioEntradaInst(String stridArea){
   		String sql = "SELECT DISTINCT INS_ENTRADA " +
   				"FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO WHERE INS_ENTRADA IS NOT NULL " +
   				"AND SD_INSTRUCCION_ASUNTO.INS_USUARIO=SD_USUARIO.ID_USUARIO AND INS_BANDERA1=1 AND " +
   				"USU_AREA="+stridArea;
    	return sql;	
   	}
   	
   	/**
   	 * Existe folio de entrada
   	 * @param strIdArea id área
   	 * @return query
   	 */
   	public static String getExisteFolioEntradaAsunto(String strIdArea){
   		String sql = "SELECT DISTINCT ASU_FOLIO_ENTRADA " +
   				"FROM SD_ASUNTO, SD_USUARIO WHERE ASU_FOLIO_ENTRADA IS NOT NULL " +
   				"AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
   				"AND USU_AREA="+strIdArea;
    	return sql;	
   	}
   	
   /**
    * Existen folio de salida
    * @param stridArea id área
    * @return query
    */
   	public static String getExisteFolioSalida(String stridArea){
   		String sql = "SELECT DISTINCT INS_SALIDA " +
   				"FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO WHERE INS_SALIDA IS NOT NULL " +
   				"AND SD_INSTRUCCION_ASUNTO.INS_TURNO=SD_USUARIO.ID_USUARIO AND " +
   				"USU_AREA="+stridArea;
    	return sql;	
   	}
   	
   	/**
   	 * Folio de entrada por instrucciones y asuntos
   	 * @param strIdArea id área
   	 * @param strOrden orden 
   	 * @param tipo tipo
   	 * @return Query
   	 */
   	public static String getFolioEntradasInst(String strIdArea, String strOrden, String tipo){
   		String sql = "SELECT DISTINCT a.INS_ENTRADA, a.ID_ASUNTO, b.USU_AREA, c.ASU_FOLIO_RECEPCION, c.ASU_FOLIO_EXTERNO, c.ASU_DESCRIPCION ";
   		sql+="FROM SD_INSTRUCCION_ASUNTO a, SD_USUARIO B, SD_ASUNTO C";
   		sql+=" WHERE a.INS_ENTRADA IS NOT NULL AND ";
   		sql+="a.INS_USUARIO=b.ID_USUARIO AND ";
   		sql+="a.ID_ASUNTO=c.ID_ASUNTO AND ";
   		sql+="b.USU_AREA="+strIdArea+" AND a.INS_BANDERA1=1 ";
   		/*sql+="UNION ";
   		sql = "SELECT DISTINCT ASU_FOLIO_ENTRADA, ID_ASUNTO, USU_AREA, ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO, ASU_DESCRIPCION ";
   		sql+="FROM SD_ASUNTO, SD_USUARIO ";
   		sql+="WHERE ASU_FOLIO_ENTRADA IS NOT NULL ";
   		sql+="AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO ";
   		sql+="AND USU_AREA="+strIdArea;*/
   		if(tipo.equals("1")){
   			sql+=" ORDER BY 1 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("2")){
			sql+=" ORDER BY 4 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("3")){
			sql+=" ORDER BY 5 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("4")){
			sql+=" ORDER BY 6 "+strOrden+", 1 ASC ";
		}
    	return sql;	
   	}
   	
   	/**
   	 * Folio de entrada del Asunto por Area  
   	 * @param strIdArea ID Area  
   	 * @param strOrden Orden
   	 * @param tipo Tipo de ordenamiento 
   	 * @return sql
   	 */
   	public static String getFolioEntradaAsunto(String strIdArea, String strOrden, String tipo){
   		String sql = "SELECT DISTINCT ASU_FOLIO_ENTRADA, ID_ASUNTO, USU_AREA, ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO, ASU_DESCRIPCION ";
   		sql+="FROM SD_ASUNTO, SD_USUARIO ";
   		sql+="WHERE ASU_FOLIO_ENTRADA IS NOT NULL ";
   		sql+="AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO ";
   		sql+="AND USU_AREA="+strIdArea;
   		if(tipo.equals("1")){
   			sql+=" ORDER BY 1 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("2")){
			sql+=" ORDER BY 4 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("3")){
			sql+=" ORDER BY 5 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("4")){
			sql+=" ORDER BY 6 "+strOrden+", 1 ASC ";
		}
    	return sql;	
   	}
   	
   	/**
   	 * Folio de salida por Area 
   	 * @param strIdArea ID Area 
   	 * @param strOrden Orden 
   	 * @param tipo Tipo de ordenamiento 
   	 * @return sql
   	 */
   	public static String getFolioSalida(String strIdArea, String strOrden, String tipo){
   		String sql = "SELECT DISTINCT a.INS_SALIDA, a.ID_ASUNTO, b.USU_AREA, c.ASU_FOLIO_RECEPCION, c.ASU_FOLIO_EXTERNO ";
   		sql+="FROM SD_INSTRUCCION_ASUNTO a, SD_USUARIO B, SD_ASUNTO C ";
   		sql+="WHERE a.INS_SALIDA IS NOT NULL AND ";
   		sql+="a.INS_USUARIO=b.ID_USUARIO AND ";
   		sql+="a.ID_ASUNTO=c.ID_ASUNTO AND ";
   		sql+="b.USU_AREA="+strIdArea+" AND INS_BANDERA1=1 ";
   		if(tipo.equals("1")){
   			sql+=" ORDER BY 1 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("2")){
			sql+=" ORDER BY 4 "+strOrden+", 1 ASC ";
		}else if(tipo.equals("3")){
			sql+=" ORDER BY 5 "+strOrden+", 1 ASC ";
		}
    	return sql;	
   	}
   	
   	/**
   	 * Regresa el ultimo ID de instruccion 
   	 * @return sql
   	 */ 
   	public static String getUltimoIdInsPadre(){
   		String sql = "SELECT MAX(ID_INSTRUCCION_ASUNTO) FROM SD_INSTRUCCION_ASUNTO";
   		return sql;
   }
   
   /**
    * Estaus de Instrucciones
    * @param strIdAsunto ID del Asunto 
    * @return sql 
    */
   	public static String getEstatusInstrucciones(String strIdAsunto){
   		String sql = "SELECT DISTINCT INS_ESTATUS " +
   				"FROM SD_INSTRUCCION_ASUNTO " +
   				"WHERE ID_ASUNTO="+strIdAsunto+" " +
   				"AND INS_PADRE IS NULL AND INS_TIPO_ATENCION=0 ";
   		return sql;
   }
   
   /**
    * Regresa query con Instrucciones vacia
    * @param strIdAsnuto ID Asunto 
    * @return sql 
    */
   	public static String getInstruccionesVacias(String strIdAsnuto){
   		String sql = "SELECT DISTINCT INS_INSTRUCCION, INS_INSTRUCCION_OTRO " +
   				"FROM SD_INSTRUCCION_ASUNTO WHERE ID_ASUNTO="+strIdAsnuto+" AND INS_PADRE IS NULL";
   		return sql;
   }
   	
    /**
     * Regresa query con Instrucciones vacia
     * @param strIdAsnuto ID Asunto 
     * @return sql 
     */
    	public static String getInstruccionesVacias(String strIdAsnuto, String idInstruccionPadre){
    		String sql = "SELECT DISTINCT INS_INSTRUCCION, INS_INSTRUCCION_OTRO " +
    				"FROM SD_INSTRUCCION_ASUNTO WHERE ID_ASUNTO="+strIdAsnuto+" AND INS_PADRE = "+ idInstruccionPadre;
    		return sql;
    }
   
   /**
    * Regresa query con instrucciones hijas vacias 
    * @param strIdPadre ID de la instruccion Padre 
    * @return sql
    */
   public static String getInstruccionHijasVacias(String strIdPadre){
   		String sql = "SELECT DISTINCT INS_INSTRUCCION, INS_INSTRUCCION_OTRO " +
   				"FROM SD_INSTRUCCION_ASUNTO WHERE INS_PADRE="+strIdPadre;
   		return sql;
   }
   
   /**
    * Regresa Instrucciones atender por Usuario 
    * @param strIdUsuario ID Usuario 
    * @param strOrden Orden 
    * @param strTipo Tipo de ordenamiento 
    * @param strIdArea ID del Area 
    * @param iBandera Bandera 
    * @return sql 
    */
   public static String getInstruccionAtenderUsuarioAsunto(	String strIdUsuario, String strOrden, 
   															String strTipo, String strIdArea,
															int iBandera)
   {	
       	String sql = "";
       	sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, INS_INSTRUCCION_OTRO, ";
       	sql+="TO_CHAR(INS_FECHA_ASIGNACION, 'dd/MM/yyyy'), INS_ESTATUS, ";
       	sql+="ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO, INS_AVANCE, ASU_PRIORIDAD, ASU_DESCRIPCION ";
       	sql+="FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_ASUNTO ";
       	sql+="WHERE ";
       	if(iBandera==0)
       		sql+="INS_USUARIO="+strIdUsuario+" ";
       	else
       		sql+="USU_AREA="+strIdArea+" ";
       	sql+="AND SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO ";
       	sql+="AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO ";
       	sql+="AND INS_ESTATUS=1 AND INS_BANDERA1=1 ";
       	if(strTipo.equals("1")){
       		sql+="ORDER BY LOWER(INS_INSTRUCCION_OTRO) "+strOrden+", LOWER(INS_INSTRUCCION_OTRO) ASC ";
       	}else if(strTipo.equals("2")){
       		sql+="ORDER BY 6 "+strOrden+", LOWER(INS_INSTRUCCION_OTRO) ASC ";
       	}else if(strTipo.equals("3")){
       		sql+="ORDER BY 7 "+strOrden+", LOWER(INS_INSTRUCCION_OTRO) ASC ";
       	}else if(strTipo.equals("4")){
       		sql+="ORDER BY INS_FECHA_ASIGNACION "+strOrden+", LOWER(INS_INSTRUCCION_OTRO) ASC ";
       	}
       return sql;
   }
   
   /**
    * Instrucciones en Tramite por Usuario y Area 
    * @param strIdUsuario ID usuario
    * @param strOrden Orden
    * @param strTipo Tipo de ordenamiento 
    * @param strIdArea ID Area 
    * @param iBandera Bandera 
    * @return sql 
    */
   public static String getInstruccionTramiteUsuarioAsunto(	String strIdUsuario, String strOrden, 
   															String strTipo, String strIdArea,
															int iBandera)
   {
       	String sql = "";
       	sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, INS_INSTRUCCION_OTRO, ";
       	sql+="TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), ";
       	sql+="TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), ";
       	sql+="INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO, ";
       	sql+="INS_AVANCE, ASU_PRIORIDAD, ASU_DESCRIPCION ";
       	sql+="FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, ";
       	sql+="SD_ASUNTO WHERE ";
    	if(iBandera==0)
    		sql+="INS_USUARIO="+strIdUsuario+" AND ";
    	else
    		sql+="USU_AREA="+strIdArea+" AND ";
       	sql+="SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO ";
       	sql+="AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO ";
       	sql+="AND INS_ESTATUS=2 AND INS_BANDERA1=1 ";
       	if(strTipo.equals("1")){
       		sql+="ORDER BY 3 "+strOrden+", 3 ASC ";
   		}else if(strTipo.equals("2")){
   			sql+="ORDER BY 7 "+strOrden+", 3 ASC ";
   		}else if(strTipo.equals("3")){
   			sql+="ORDER BY 8 "+strOrden+", 3 ASC ";
   		}else if(strTipo.equals("4")){
   			sql+="ORDER BY 9 "+strOrden+", 3 ASC ";
   		}else if(strTipo.equals("5")){
   			sql+="ORDER BY INS_FECHA_ASIGNACION "+strOrden+", 3 ASC ";
   		}else if(strTipo.equals("7")){
   			sql+="ORDER BY INS_FECHA_TERMINACION "+strOrden+", 3 ASC ";
   		}
       return sql;
   }
   
   /**
    * Instrucciones terminadas por usuario y area 
    * @param strIdUsuario ID usuario 
    * @param strOrden Orden 
    * @param strTipo Tipo de ordenamiento
    * @param strIdArea ID Area 
    * @param iBandera Bandera 
    * @return sql
    */
   public static String getInstruccionTerminadaUsuarioAsunto(	String strIdUsuario, String strOrden, 
   																String strTipo, String strIdArea,
																int iBandera)
   {
       	String sql = "";
       	sql = "SELECT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, INS_INSTRUCCION_OTRO,";
       	sql+="TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), ";
       	sql+="TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), ";
       	sql+="INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO, ";
       	sql+="INS_AVANCE, ASU_PRIORIDAD, ";
       	sql+="TO_CHAR(INS_FECHA_TERMINACION_REAL, 'yyyy-MM-dd'), ASU_DESCRIPCION ";
       	sql+="FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, ";
       	sql+="SD_ASUNTO WHERE ";
       	if(iBandera==0)
       		sql+="INS_USUARIO="+strIdUsuario+" AND ";
       	else
       		sql+="USU_AREA="+strIdArea+" AND ";
       	sql+="SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO ";
       	sql+="AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO ";
       	sql+="AND INS_ESTATUS=4 AND INS_BANDERA1=1 ";
       	if(strTipo.equals("1")){
       		sql+="ORDER BY 3 "+strOrden+", 3 ASC ";
		}else if(strTipo.equals("2")){
			sql+="ORDER BY 7 "+strOrden+", 3 ASC ";
		}else if(strTipo.equals("3")){
			sql+="ORDER BY 9 "+strOrden+", 3 ASC ";
		}else if(strTipo.equals("4")){
			sql+="ORDER BY INS_FECHA_TERMINACION_REAL "+strOrden+", 3 ASC ";
		}
       return sql;
   }
   
   /**
    * Función que retrna un query que determina si existen Instrucciones
    * en tramite
    * @param strIdUsuario ID usuario 
    * @return sql
    */
   public static String TieneInstruccionesEnTramiteAsunto(String strIdUsuario)
   {
       String sql = "";
       sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=2 AND INS_BANDERA1=1 AND INS_USUARIO="+strIdUsuario;
       return sql;
   }
   
   /**
    * Función que retrna un query que determina si existen Instrucciones
    * por atender
    * @param strIdUsuario ID usuario 
    * @return sql
    */
   public static String TieneInstruccionesPorAtenderAsunto(String strIdUsuario)
   {
       String sql = "";
       sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_AVANCE=0.0 AND INS_ESTATUS=1 AND INS_BANDERA1=1 AND INS_USUARIO="+strIdUsuario;
       return sql;
   }
   
   /**
    * Función que retrna un query que determina si existen Instrucciones
    * Terminadas
    * @param strIdUsuario ID de Usuario
    * @return sql
    */
   public static String TieneInstruccionesTerminadasAsunto(String strIdUsuario)
   {
       String sql = "";
       sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=4 AND INS_BANDERA1=1 AND INS_USUARIO="+strIdUsuario;
       return sql;
   }
   
   /**
  	 * Actualizacion de instrucción Padre
  	 * @param strIdInstrucion ID instruccion 
  	 * @param strAvance Avance 
  	 * @param strEstatus Estatus 
  	 * @param firmarDigitalmente Fima digital 
  	 * @param strFechaTerminacionReal Fecha de terminacion Real
  	 * @param strIdUsuario ID de usuario 
  	 * @return sql
  	 */
   public static String avanceInstruccionPadre(	String strIdInstrucion, String strAvance, 
   												String strEstatus, String firmarDigitalmente, 
												String strFechaTerminacionReal,
												String strIdUsuario){
   	String sql = "";

   	//** Si la instrucción esta por atender y se le asigna un avance < al
   	//** 100%, hace el cambio a una instrucción en tramite
   	if(strEstatus.equals("1") && !strAvance.equals("100")){
   		sql = 	"UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", " +
		"INS_AVANCE_ORIGINAL="+strAvance+", " +
		"INS_ESTATUS=2, INS_IMG_FIRMA="+firmarDigitalmente+" " +
		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
   		////System.out.println("sql="+sql);
   	}
   	//** Si la instrucción esta por atender y le le asigna un avance del
   	//** 100%, entonces cambia el estatus de la instrucción a terminada
   	else if(strEstatus.equals("1") && strAvance.equals("100")){

   		String strDates[][] = ActualizaAsuntoTurnado.FechasAsignacion(strIdInstrucion);
   		String fechaInicio = strDates[0][0];
   		Calendar cFechaInicio	=	Utilerias.StringCalendar(fechaInicio);
   		Calendar cFechaFin 		=	Utilerias.StringCalendar(strFechaTerminacionReal);
   		int real 				= 	Utilerias.DiasdeTrabajoEntre(cFechaInicio, cFechaFin, 0);
   		String strFechaR		=	Utilerias.formatearFechas(strFechaTerminacionReal);
   		
   		String strUsr 			=	ActualizaUsuario.NombreUsuario(strIdUsuario);

   		sql = 	"UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", " +
		"INS_AVANCE_ORIGINAL="+strAvance+", " +
		"INS_ESTATUS=4, INS_IMG_FIRMA="+firmarDigitalmente+", " +
		"INS_FECHA_TERMINACION_REAL=TO_DATE('"+strFechaR+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'DD/MM/YYYY HH24:MI:SS'), " +
		"INS_TIEMPO_REAL="+real+", INS_USUARIO_TERMINO='"+strUsr+"' WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
   		////System.out.println("sql="+sql);
   	}else 	
   	   	//** Si la instrucción esta rechazada y se da por terminada al no tener a quien reasignarla
   	   	//** se da un avance al 100%, entonces cambia el estatus de la instrucción a terminada
   		if(strEstatus.equals("3") && strAvance.equals("100")){

   		String strDates[][] = ActualizaAsuntoTurnado.FechasAsignacion(strIdInstrucion);
   		String fechaInicio = strDates[0][0];
   		Calendar cFechaInicio	=	Utilerias.StringCalendar(fechaInicio);
   		Calendar cFechaFin 		=	Utilerias.StringCalendar(strFechaTerminacionReal);
   		int real 				= 	Utilerias.DiasdeTrabajoEntre(cFechaInicio, cFechaFin, 0);
   		String strFechaR		=	Utilerias.formatearFechas(strFechaTerminacionReal);
   		
   		String strUsr 			=	ActualizaUsuario.NombreUsuario(strIdUsuario);

   		sql = 	"UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", " +
		"INS_AVANCE_ORIGINAL="+strAvance+", " +
		"INS_ESTATUS=4, " +
		"INS_FECHA_TERMINACION_REAL=TO_DATE('"+strFechaR+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'DD/MM/YYYY HH24:MI:SS'), " +
		"INS_TIEMPO_REAL="+real+", INS_USUARIO_TERMINO='"+strUsr+"' WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
   		////System.out.println("sql="+sql);
   	}
   	//** Si la instrucción esta en tramite y se le da un avance que sea menor a
   	//** 100%, entonces actualiza el avance
   	else if(strEstatus.equals("2") && !strAvance.equals("100")){
   		sql = 	"UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", " +
		"INS_AVANCE_ORIGINAL="+strAvance+" " +
		"WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
   		////System.out.println("sql="+sql);
	return sql;
   	}
   	//** Si la instruccion esta en tramite y se le da un avance del 100%,
   	//** entonces cierra la instruccion
   	else if(strEstatus.equals("2") && strAvance.equals("100")){
   		String strDates[][] = ActualizaAsuntoTurnado.FechasAsignacion(strIdInstrucion);
   		String fechaInicio = strDates[0][0];
   		Calendar cFechaInicio	=	Utilerias.StringCalendar(fechaInicio);
   		Calendar cFechaFin 		=	Utilerias.StringCalendar(strFechaTerminacionReal);
   		int real 				= 	Utilerias.DiasdeTrabajoEntre(cFechaInicio, cFechaFin, 0);
   		String strFechaR			=	Utilerias.formatearFechas(strFechaTerminacionReal);
   		String strUsr 			=	ActualizaUsuario.NombreUsuario(strIdUsuario);

   		sql = 	"UPDATE SD_INSTRUCCION_ASUNTO SET INS_AVANCE="+strAvance+", " +
		"INS_AVANCE_ORIGINAL="+strAvance+", " +
		"INS_ESTATUS=4, INS_IMG_FIRMA="+firmarDigitalmente+", " +
		"INS_FECHA_TERMINACION_REAL=TO_DATE('"+strFechaR+" '||TO_CHAR(SYSDATE,'HH24:MI:SS'), 'DD/MM/YYYY HH24:MI:SS'), " +
		"INS_TIEMPO_REAL="+real+", INS_USUARIO_TERMINO='"+strUsr+"' WHERE ID_INSTRUCCION_ASUNTO="+strIdInstrucion;
   		////System.out.println("sql="+sql);
   	}
   	return sql;
   }
  	
  	/**
  	 * Tiempos de Instruccion por Asunto 
  	 * @param strIdAsunto ID asunto 
  	 * @return sql
  	 */
  	public static String getTiempos(String strIdAsunto){
  		String sql = "SELECT INS_TIEMPO FROM SD_INSTRUCCION_ASUNTO " +
  				"WHERE ID_ASUNTO="+strIdAsunto+" AND INS_PADRE IS NULL AND INS_ESTATUS=0 ";
  		return sql;
  	}
  	
  	/**
  	 * Función que regresa un query donde muestra la lista de instrucciones rechazadas por 
  	 * cada turnador
  	 * @param strIdTurnador ID turnador 
  	 * @return sql 
  	 */
  	public static String existeInstruccionesRechazadasPorAtender(String strIdTurnador){
  		String sql = "SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO="+strIdTurnador;
  		return sql;
  	}
  	
  	/**
     * Función que regresa un query de una lista de usuarios que han
     * rechazado la instruccion por los turnadores
     * @param strIdTurnador ID turnador  
     * @return sql
     */
  	public static String UsuarioInstruccionRechazadaPorTurnador(String strIdTurnador)
    {
        String sql = "";
        sql = "SELECT DISTINCT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO " +
        		"WHERE INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO="+strIdTurnador;
        return sql;
    }
  	
  	/**
  	 * Regresa todos los usuarios de atencion con instrucciones rechazadas
  	 * @param strIdArea: ID del area
  	 * @return String con el query
  	 */
  	public static String UsuarioInstruccionRechazadaPorArea(String strIdArea)
    {
        String sql = "";
        sql = "SELECT DISTINCT INS_USUARIO " +
        		"FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO " +
        		"WHERE INS_ESTATUS=3 " +
        		"AND INS_BANDERA1=0 " +
        		"AND SD_INSTRUCCION_ASUNTO.INS_USUARIO = SD_USUARIO.ID_USUARIO " +
        		"AND USU_AREA = " + strIdArea;
        return sql;
    }
    
    /**
     * Regresa un query para verificar si la isntrucciones es normal o esta
     * lista para turnar
     * @param strIdInstruccion ID instruccion 
     * @return sql 
     */
    public static String getHabilitado(String strIdInstruccion){
    	String sql = "";
    	sql = "SELECT INS_HABILITADA FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
    	return sql;
    }
    
    /**
     * Usuario de la instruccion 
     * @param strIdInstruccion ID de instruccion 
     * @return sql
     */
    public static String getUsuario(String strIdInstruccion){
    	String sql = "";
    	sql = "SELECT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
    	return sql;
    }
    
    /**
     * Avance original de Asunto 
     * @param strIdInstruccion ID de instruccion 
     * @return sql
     */
    public static String getAvanceOriginal(String strIdInstruccion){
        String sql = "SELECT INS_AVANCE_ORIGINAL FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
        return sql;
    }
    
    /**
     * Permisos de las instrucciones 
     * @param strIdInstruccion ID de instruccion 
     * @return sql
     */
    public static String getPermiso(String strIdInstruccion){
    	String sql= "SELECT INS_ACCESO, INS_PADRE FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
    	return sql;
    }
    
    /**
     * Actualiza cambio de rechazo 
     * @param strIdInstruccion ID de instrucción 
     * @return sql 
     */
    public static String actualizaRechazoCambio(String strIdInstruccion){
    	String sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_FECHA_CAMBIO=null WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
    	return sql;
    }
    
    /**
     * Actualiza tiempo de Instruccion 
     * @param strIdAsunto ID de Asunto 
     * @param strDuracion Duracion de la instruccion 
     * @return sql
     */
    public static String updateTiempoInst(String strIdAsunto, String strDuracion){
    	String sql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_TIEMPO="+strDuracion+" WHERE ID_ASUNTO="+strIdAsunto;
    	return sql;
    }
    
    /**
     * Regresa la maxima secuencia de paso 
     * @param strIdAsunto ID asunto 
     * @return sql
     */
    public static String getMaxPasos(String strIdAsunto){
    	String sql = "SELECT MAX(PAS_SECUENCIA) FROM SD_INSTRUCCION_ASUNTO, SD_PASO " +
    			"WHERE ID_ASUNTO="+strIdAsunto+" " +
    			"AND SD_INSTRUCCION_ASUNTO.INS_PASO=SD_PASO.ID_PASOS " +
    			"AND INS_ESTATUS=0 AND INS_PADRE IS NULL";
    	return sql;
    }
    
    /**
     * Funcion que regresa 0 si las instrucciones ya tienen el estatus 4
     * @param strIdInstruccion ID de instruccion 
     * @return sql
     */
    public static String getInstruccionesTerminadas(String strIdInstruccion){
    	String sql = "SELECT COUNT(*) FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_PASO " +
    				"WHERE INS_PADRE="+strIdInstruccion+" " +
					"AND SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
					"AND SD_PASO.ID_PASOS=SD_INSTRUCCION_ASUNTO.INS_PASO " +
					"AND INS_ESTATUS<>4 AND INS_TIPO_ATENCION=0"; 
    	return sql;
    }
    
    /**
     * Reporte de folio de entrada 
     * @param strIdArea ID de la UA 
     * @return sql 
     */
   	public static String getFolioEntradaReporte(String strIdArea){
   		String sql = "SELECT DISTINCT a.INS_ENTRADA, c.ASU_FOLIO_RECEPCION, c.ASU_FOLIO_EXTERNO, " +
   				"ASU_DESCRIPCION, " +
   				"CASE ASU_CONTROL 	" +
   				"	WHEN 0 THEN (SELECT RMT_NOMBRE FROM SD_REMITENTE WHERE ID_REMITENTE = ASU_REMITENTE) " +
   				"	WHEN 1 THEN (SELECT USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO = ASU_REMITENTE) " +
   				"END AS REMITENTE, " +
   				"CASE ASU_CONTROL 	" +
   				"	WHEN 0 THEN (SELECT ENT_NOMBRE FROM SD_REMITENTE, SD_ENTIDAD WHERE ID_REMITENTE = ASU_REMITENTE AND ID_ENTIDAD = RMT_ENTIDAD) " +
   				"	WHEN 1 THEN (SELECT ARE_NOMBRE FROM SD_USUARIO, SD_AREA WHERE ID_USUARIO = ASU_REMITENTE AND ID_AREA = USU_AREA) " +
   				"END AS UA_REMITENTE, " +
   				"CASE ASU_CONTROL_FOLIO " +
   				"	WHEN 0 THEN 'Entrada' " +
   				"	WHEN 1 THEN 'Salida' " +
   				"END AS TIPO_ES, " +
   				"ASU_AVANCE||'%' AS AVANCE, " +
   				"TO_CHAR(ASU_FECHA_CAPTURA,'DD/MM/YYYY HH24:MI:SS') AS FECHA_CAPTURA, " +
   				"TO_CHAR(ASU_FECHA_RECEPCION,'DD/MM/YYYY HH24:MI:SS') AS FECHA_RECEPCION, " +
   				"TO_CHAR(ASU_FECHA_DOCTO,'DD/MM/YYYY') AS FECHA_DOCTO, " +
   				"TO_CHAR(ASU_FECHA_CADUCIDAD,'DD/MM/YYYY HH24:MI:SS') AS FECHA_COMPROMISO, " +
   				"CASE ASU_ESTATUS  " +
   				"	WHEN 0 THEN 'No has sido Terminada' " +
   				"	WHEN 1 THEN 'No has sido Terminada' " +
   				"	WHEN 2 THEN 'No has sido Terminada' " +
   				"	WHEN 3 THEN TO_CHAR(ASU_FECHA_TERMINACION,'DD/MM/YYYY HH24:MI:SS') " +
   				"END AS FECHA_TERMINACION, " +
   				"CASE ASU_ESTATUS " +
   				"	WHEN 0 THEN 'En Recepción' " +
   				"	WHEN 1 THEN 'Por Turnar' " +
   				"	WHEN 2 THEN 'En Tramite' " +
   				"	WHEN 3 THEN 'Terminada' " +
   				"END AS ESTATUS, " +
   				"ASU_LISTAIDS_PARA, " +
   				"ASU_LISTAIDS_CC, " +
   				"ASU_ESTATUS, C.ID_ASUNTO " +
   				"FROM SD_INSTRUCCION_ASUNTO a, SD_USUARIO B, SD_ASUNTO C " +
   				"WHERE a.INS_ENTRADA IS NOT NULL AND " +
   				"a.INS_USUARIO=b.ID_USUARIO AND " +
   				"a.ID_ASUNTO=c.ID_ASUNTO AND b.USU_AREA="+strIdArea+" AND a.INS_BANDERA1=1 " +
   				"UNION " +
   				"SELECT DISTINCT ASU_FOLIO_ENTRADA, ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO, " +
   				"ASU_DESCRIPCION, " +
   				"CASE ASU_CONTROL " +
   				"	WHEN 0 THEN (SELECT RMT_NOMBRE FROM SD_REMITENTE WHERE ID_REMITENTE = ASU_REMITENTE) " +
   				"	WHEN 1 THEN (SELECT USU_CARGO FROM SD_USUARIO WHERE ID_USUARIO = ASU_REMITENTE) " +
   				"END AS REMITENTE, " +
   				"CASE ASU_CONTROL " +
   				"	WHEN 0 THEN (SELECT ENT_NOMBRE FROM SD_REMITENTE, SD_ENTIDAD WHERE ID_REMITENTE = ASU_REMITENTE AND ID_ENTIDAD = RMT_ENTIDAD) " +
   				"	WHEN 1 THEN (SELECT ARE_NOMBRE FROM SD_USUARIO, SD_AREA WHERE ID_USUARIO = ASU_REMITENTE AND ID_AREA = USU_AREA) " +
   				"END AS UA_REMITENTE, " +
   				"CASE ASU_CONTROL_FOLIO " +
   				"	WHEN 0 THEN 'Entrada' " +
   				"	WHEN 1 THEN 'Salida' " +
   				"END AS TIPO_ES, " +
   				"ASU_AVANCE||'%' AS AVANCE, " +
   				"TO_CHAR(ASU_FECHA_CAPTURA,'DD/MM/YYYY HH24:MI:SS') AS FECHA_CAPTURA, " +
   				"TO_CHAR(ASU_FECHA_RECEPCION,'DD/MM/YYYY HH24:MI:SS') AS FECHA_RECEPCION, " +
   				"TO_CHAR(ASU_FECHA_DOCTO,'DD/MM/YYYY') AS FECHA_DOCTO, " +
   				"TO_CHAR(ASU_FECHA_CADUCIDAD,'DD/MM/YYYY HH24:MI:SS') AS FECHA_COMPROMISO, " +
   				"CASE ASU_ESTATUS " +
   				"	WHEN 0 THEN 'No has sido Terminada' " +
   				"	WHEN 1 THEN 'No has sido Terminada' " +
   				"	WHEN 2 THEN 'No has sido Terminada' " +
   				"	WHEN 3 THEN TO_CHAR(ASU_FECHA_TERMINACION,'DD/MM/YYYY HH24:MI:SS') " +
   				"END AS FECHA_TERMINACION, " +
   				"CASE ASU_ESTATUS " +
   				"	WHEN 0 THEN 'En Recepción' " +
   				"	WHEN 1 THEN 'Por Turnar' " +
   				"	WHEN 2 THEN 'En Tramite' " +
   				"	WHEN 3 THEN 'Terminada' " +
   				"END AS ESTATUS, " +
   				"ASU_LISTAIDS_PARA, " +
   				"ASU_LISTAIDS_CC, " +
   				"ASU_ESTATUS, SD_ASUNTO.ID_ASUNTO  " +
   				"FROM SD_ASUNTO, SD_USUARIO " +
   				"WHERE ASU_FOLIO_ENTRADA IS NOT NULL " +
   				"AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
   				"AND USU_AREA=" + strIdArea +
   				"ORDER BY 1 ASC ";
    	return sql;	
   	}
   	
   	/**
   	 * Regresa 0 si el área o UA aplica el turnado por subventanilla
     * @param strIdArea	Id área
   	 * @return	Regresa el query correcpondiente
   	 */
   	public static String getAreaSubventanilla(String strIdArea){
    	String sql = "SELECT ARE_SUBVENTANILLA FROM SD_AREA WHERE ID_AREA="+strIdArea;
    	return sql;
    }
   	
   	/**
   	 * Regresa el Id del Puesto a partir del cual podra turnar
   	 * @param strIdTurnador	Id Turnador
   	 * @return Regresa el query correcpondiente
   	 */
   	public static String getUsuarioSubventanilla(String strIdTurnador){
    	String sql = "SELECT USU_SUBVENTANILLA FROM SD_USUARIO WHERE ID_USUARIO="+strIdTurnador;
    	return sql;
    }
   	
   	/**
   	 * Jefe del turnador
   	 * @param strIdInstruccion id instruccion
   	 * @param strTurnador Turnador
   	 * @return
   	 */
   	public static String getTurnadorJefe(String strIdInstruccion,String strTurnador){
   		String sql ="select id_usuario from sd_instruccion_asunto, sd_usuario where id_instruccion_asunto="+strIdInstruccion+" and id_usuario=ins_usuario and usu_jefe=" + strTurnador;
   		return sql;
   	}
   	
   	/**
   	 * Regresa el estatus de una instruccion por su ID
   	 * @param strIdInstruccion ID de la instruccion 
   	 * @return String con el query correspondinete
   	 */
   	public static String getEstatusPorInstruccion(String strIdInstruccion){
    	String sql = "SELECT INS_ESTATUS " +
    			"FROM SD_INSTRUCCION_ASUNTO " +
    			"WHERE ID_INSTRUCCION_ASUNTO = "+strIdInstruccion;
    	return sql;
    }
   	
   	/**
  	 * Función que regresa un query donde muestra la lista de instrucciones rechazadas por 
  	 * el supervisor del área
  	 * @param idArea ID área 
  	 * @return sql 
  	 */
  	public static String existeInstRechazadasAtenderSup(String idArea){
  		String sql = "SELECT COUNT(*) FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO " +
  				"WHERE INS_ESTATUS=3 " +
  				"AND INS_BANDERA1=0 " +
  				"AND SD_INSTRUCCION_ASUNTO.INS_USUARIO=SD_USUARIO.ID_USUARIO " +
  				"AND USU_AREA="+idArea;
  		return sql;
  	}
  	
  	/**
  	 * Devuelve el Id del usuario titular de la instrucción
  	 * @param idInstruccion Id Instruccion
  	 * @return Query
  	 */
  	public static String getIdUsuarioInstruccion(String idInstruccion){
  		String sql = "SELECT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="+idInstruccion;
  		return sql;
  	}
   	

}