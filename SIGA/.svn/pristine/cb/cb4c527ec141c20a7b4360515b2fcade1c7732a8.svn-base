/*
 * Clase:						ActualizaHistorial.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 5, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		La clase ActualizaHistorial contiene las Funciónes que mandan
 * 								a ejecutar los diversos querys para la talba SD_HISTORIAL_INSTRUCCION
 */

package com.meve.sigma.actualiza;

import java.sql.SQLException;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLHistorial;

/**
 * 	ActualizaEstatus es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Estatus
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaHistorial {
    
    /**
     * Función que ejecuta el query con la clase ConexionDS.ejecutarActualizacion
     * retorna un true si a sido ejecutado satisfactoriamente o False si es lo contrario
     * @param strIdInstruccion
     * @param strIdAsunto
     * @param strComentario
     * @param strIdUsuario
     * @param strAvance
     * @return (r>0)
     */
    public static boolean InsertarRespuesta(String strIdInstruccion, String strIdAsunto, 
    										String strComentario, String strIdUsuario, 
											String strAvance, String strFecha, String strPuesto)
    {
        int r = 0;
        try
        {
            String strSql = SQLHistorial.InsertarRespuesta(	strIdInstruccion, strIdAsunto, strComentario,
                    										strIdUsuario, strAvance, strFecha, strPuesto);                       
            ////System.out.println("InsertarRespuesta:"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertarRespuesta:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Función que ejecuta el query con la clase ConexionDS.ejecutarActualizacion
     * retorna un true si a sido ejecutado satisfactoriamente o False si es lo contrario
     * @param strIdInstruccion
     * @param strIdAsunto
     * @param strRazon
     * @param strIdUsrRechazo
     * @param strAvance
     * @param strFecha
     * @return ConexionDS.ejecutarActualizacion(strSql)
     */
    public static boolean InsertarRechazo(String strIdInstruccion, String strIdAsunto, String strRazon,String strIdUsrRechazo, String strAvance, String strFecha, String strPuesto){
        int r = 0;
        try{
            String strSql = SQLHistorial.InsertarRechazo(strIdInstruccion, strIdAsunto, strRazon,strIdUsrRechazo, strAvance, strFecha, strPuesto);
           // //System.out.println("InsertarRechazo(...): "+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }catch (SQLException sqle){
            //System.err.println("InsertarRechazo:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Función que ejecuta el query con la clase ConexionDS.ejecutarActualizacion
     * retorna un true si a sido ejecutado satisfactoriamente o False si es lo contrario
     * @param strIdInstruccion
     * @param strIdAsunto
     * @param strComentario
     * @param strIdUsrComentario
     * @param strAvance
     * @param strFecha
     * @return ConexionDS.ejecutarActualizacion(strSql)
     */
    public static boolean InsertarComentario(String strIdInstruccion, String strIdAsunto, String strComentario,
			String strIdUsrComentario, String strAvance, String strFecha, String strPuesto)
    {
        int r = 0;
        try
        {
            String strSql = SQLHistorial.InsertarComentario(	strIdInstruccion, strIdAsunto, strComentario,
															strIdUsrComentario, strAvance, strFecha, strPuesto);
            ////System.out.println("InsertarComentario:"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertarComentario:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    
    
    /**
     * Inserta el historial de la reasignación de una instrucción
     * @param strIdInstruccion	id instrucción
     * @param strIdAsunto		id asunto
     * @param strComentarios	Comentarios
     * @param strIdUsrReasig		Id usuario que se le Reasignó
     * @param strFecha			Fecha de la reasignación
     * @return	true si inserta correctamente
     */
    public static boolean InsertarReasignacion(String strIdInstruccion, String strIdAsunto, String strComentarios,String strIdUsrReasig, String strFecha, String strPuesto){
        int r = 0;
        try{
            String strSql = SQLHistorial.InsertarReasignacion(strIdInstruccion, strIdAsunto, strComentarios,strIdUsrReasig, strFecha, strPuesto);
           // //System.out.println("ActualizaHistorial.InsertarReasignacion:"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }catch (SQLException sqle){
            //System.out.println("InsertarReasignacion:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Inserta el historial de la Delegación de una instrucción
     * @param strIdInstruccion	id instrucción
     * @param strIdAsunto		id asunto
     * @param strComentarios	Comentarios
     * @param strIdUsrReasig	Id usuario que delego
     * @param strFecha			Fecha de la Delegación
     * @param strPuesto			Puesto del usuario
     * @return	true si inserta correctamente
     */
    public static boolean InsertarDelegar(String strIdInstruccion, String strIdAsunto, String strComentarios,
			String strIdUsrReasig, String strFecha, String strPuesto)
    {
        int r = 0;
        try
        {
            String strSql = SQLHistorial.InsertarDelegar(strIdInstruccion, strIdAsunto, strComentarios,
                    strIdUsrReasig, strFecha, strPuesto);
            ////System.out.println("InsertarDelegar:"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertarDelegar:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Inserta el historial de la Delegación multiple de una instrucción
     * @param strIdInstruccion	id instrucción
     * @param strIdAsunto		id asunto
     * @param strUsrResponde	Usuario que responde
     * @param strAvance			Avance
     * @param strFecha			Fecha de la Delegación
     * @return Query
     */
    public static boolean InsertarHabilitado(String strIdInstruccion, String strIdAsunto,
											String strUsrResponde,
											String strAvance, String strFecha, String strPuesto)
    {
        int r = 0;
        try
        {
            String strSql = SQLHistorial.InsertarHabilitado(strIdInstruccion, strIdAsunto,
															strUsrResponde,
															strAvance, strFecha, strPuesto);
            ////System.out.println("InsertarHabilitado:"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertarHabilitado:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Función que ejecuta el query para traer una lista de el historial 
     * de una instrucción dependiendo de su ID
     * @param strIdInstruccion	String Contiene el ID de la instrucción
     * @return	regresa arreglo del historial de las instrucciones
     */
    public static String[][] getHistorialInstruccion(String strIdInstruccion)
	{	
		int r=0;
		try
		{
			String strsql = SQLHistorial.getHistorialInstruccion(strIdInstruccion);
//			//System.out.println("getHistorialInstruccion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getHistorialInstruccion:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Función que ejecuta el query para verificar si tiene datos,
     * devuelve True si tiene datos, de lo contrario False
     * @param strIdInstruccion
     * @return True o False
     */
    public static boolean TieneHistorial(String strIdInstruccion)
	{		
		try
		{
			String strsql = SQLHistorial.TieneHistorial(strIdInstruccion);
			////System.out.println("TieneHistorial:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
		//	//System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("TieneHistorial:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}	
	}
    
    /**
     * Datos de un historial
     * @param strIdHistorial
     * @return	regresa arreglo de los datos de un historial
     */
    public static String[][] getHistorial(String strIdHistorial)
	{	
		int r=0;
		try
		{
			String strsql = SQLHistorial.getHistorial(strIdHistorial);
			////System.out.println("getHistorial:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getHistorial:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Historial de las respuestas por instrucción
     * @param strIdInstruccion	Id instrucción
     * @return	regresa arreglo de las respuestas por instrucciones
     */
    public static String[][] getHistorialRespuestasPorInstruccion(String strIdInstruccion)
	{	
		int r=0;
		try
		{
			String strsql = SQLHistorial.getHistorialRespuestasPorInstruccion(strIdInstruccion);
			////System.out.println("getHistorialRespuestasPorInstruccion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getHistorialRespuestasPorInstruccion:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Inserta el historial del cambio de la fecha de solicitud
     * @param strIdInstruccion	Id de la instrucción
     * @param strComentarios	Comentarios
     * @param strFechaActual	Fecha Actual
     * @param strFechaSolicitud	Fecha Solicitada
     * @param strPuesto			Puesto
     * @param strUsuario		usuario
     * @param strIdAsunto		id usuario
     * @return	True o False
     */
    public static boolean insertarSolCambioFecha(String strIdInstruccion,  
									String strComentarios, String strFechaActual, 
									String strFechaSolicitud, String strPuesto,
									String strUsuario, String strIdAsunto)
    {
    	int r = 0;
    	try
		{
    		String strSql = SQLHistorial.insertarSolCambioFecha(strIdInstruccion,
    				strComentarios, strFechaActual , strFechaSolicitud,
					strPuesto, strUsuario, strIdAsunto);
    		////System.out.println("insertarSolCambioFecha:"+strSql);
    		r = ConexionDS.ejecutarActualizacion(strSql);
		}
    	catch (SQLException sqle)
		{
    		////System.out.println("insertarSolCambioFecha:"+sqle.getMessage());
    		sqle.printStackTrace();
    		return false;
		}
    	return (r>0);
    }
    
    /**
     * Inserta el historial del cambio de la fecha de solicitud rechazada
     * @param strIdInstruccion	Id de la instrucción
     * @param strComentarios	Comentarios
     * @param strPuesto			Puesto
     * @param strUsuario		usuario
     * @param strIdAsunto		id usuario
     * @return	True o False
     */
    public static boolean insertarSolCambioFechaRechazo(String strIdInstruccion,  
													String strComentarios, String strPuesto,
													String strUsuario, String strIdAsunto)
    {
    	int r = 0;
    	try
		{
    		String strSql = SQLHistorial.insertarSolCambioFechaRechazo(strIdInstruccion,
    											strComentarios, 
    											strPuesto, strUsuario, strIdAsunto);
    		////System.out.println("insertarSolCambioFechaRechazo:"+strSql);
    		r = ConexionDS.ejecutarActualizacion(strSql);
		}
    	catch (SQLException sqle)
		{
    		//System.out.println("insertarSolCambioFechaRechazo:"+sqle.getMessage());
    		sqle.printStackTrace();
    		return false;
		}
    	return (r>0);
    }
    
    /**
     * Inserta el historial del cambio de la fecha de solicitud aceptada
     * @param strIdInstruccion	Id de la instrucción
     * @param strComentarios	Comentarios
     * @param strPuesto			Puesto
     * @param strUsuario		usuario
     * @param strIdAsunto		id usuario
     * @return	True o False
     */
    public static boolean insertarSolCambioFechaAceptacion(String strIdInstruccion,  
				String strComentarios, String strPuesto,
				String strUsuario, String strIdAsunto)
    {
    	int r = 0;
    	try
		{
    		String strSql = SQLHistorial.insertarSolCambioFechaAceptacion(strIdInstruccion,
    						strComentarios, 
							strPuesto, strUsuario, strIdAsunto);
    		////System.out.println("insertarSolCambioFechaAceptacion:"+strSql);
    		r = ConexionDS.ejecutarActualizacion(strSql);
		}
    	catch (SQLException sqle)
		{
    		//System.out.println("insertarSolCambioFechaAceptacion:"+sqle.getMessage());
    		sqle.printStackTrace();
    		return false;
		}
    	return (r>0);
    }
    
    
    
    public static String[][] getUsuarioRechazo(String idInstruccion) {
        String[][] resultado = null;
        String strQuery = "SELECT HIS_PUESTO " +
                          "FROM SD_HISTORIAL_INSTRUCCIONES H1 " +
                         "WHERE ID_INSTRUCCION_ASUNTO = " + idInstruccion.trim() + " " +
                           "AND HIS_EVENTO = 2 " +
                           "AND HIS_FECHA = " +
                                          "(SELECT MAX (HIS_FECHA) " +
                                             "FROM SD_HISTORIAL_INSTRUCCIONES H2 " +
                                            "WHERE H1.ID_INSTRUCCION_ASUNTO = H2.ID_INSTRUCCION_ASUNTO " +
                                              "AND HIS_EVENTO = 2) ";
                                              
        try {
            resultado = ConexionDS.ejecutarSQL(strQuery);
        }  catch(Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

}

