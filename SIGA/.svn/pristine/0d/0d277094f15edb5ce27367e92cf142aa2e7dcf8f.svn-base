/*
 * Clase:						ActualizaExpediente.java
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

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLExpediente;

/**
 * 	ActualizaEstatus es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Estatus
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaExpediente {
    
    /**
     * Inserta los expedientes
     * @param idArea		Id área
     * @param expediente	nombre expediente
     * @param idActualizo	usuario que actualizo
     * @param fechaUpdate	fecha de Actualización
     * @return	true
     */
    public static boolean InsertarExpediente(	String idArea, String expediente, 
            									String idActualizo,	String fechaUpdate)
    {
        int r = 0;
        try
        {
            String strSql = SQLExpediente.getInsertaExpediente(idArea, expediente, idActualizo, fechaUpdate);
            ////System.out.println("InsertaExpediente:"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertaExpediente:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Lista de los expedientes existente con estatus 1
     * @return	regresa arreglo con la lista de expedientes
     */
    public static String[][] getListaExpediente(String strOrden, String tipo)
	{	
		try
		{
			String strsql = SQLExpediente.getListaExpediente(strOrden, tipo);
			////System.out.println("getListaExpediente:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getLListaExpediente:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Función que regresa un True si existen registros en la tabla de SD_EXPEDIENTE,
     * de lo contrario devuelve False
     * @return true o false
     */
    public static boolean getExiste()
	{		
		try
		{
			String strsql = SQLExpediente.getExiste();
			////System.out.println("ExistenExpedientes:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
		//	//System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("ExistenExpedientes:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
		
			
	}
    
    /**
     * Función que regresa un query de borrado logico asignado el valor
     * de EXP_ESTATUS=0
     * @param strIds Ids a eliminar
     * @return true si actualiza correctamente
     */
    public static boolean deleteExpediente(String strIds[])
	{
		int r=0;
		if(strIds==null || strIds.length<0)
			return false;
		
		try
		{
			String strsql = SQLExpediente.getDeleteExpediente(strIds);
			////System.out.println("DeleteExpediente:"+strsql); 
			r= ConexionDS.ejecutarActualizacion(strsql);		
		}
		catch(SQLException sqle)
		{
				//System.out.println("DeleteExpediente:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}						
		return (r>0);
	}
    
    /**
     * Lista de expedientes para formar combo
     * @param strIdExpediente	Id Expediente
     * @return String[][] de datos
     */
    public static String[][] getDatosExpediente(String strIdExpediente)
	{	
		try
		{
			String strsql = SQLExpediente.getDatosExpediente(strIdExpediente);
			////System.out.println("getDatosExpediente:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosExpediente:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Actualiza registro de expedientes
     * @param strIdArea		Id área
     * @param strDescripcion	Descripción
     * @param strUsrUpdate		usuario que actualizá
     * @param strFechaUpdate	fecha Actualización
     * @param strIdExp			id expediente
     * @return	true si la Actualización fue correcta
     */
    public static boolean ActualizarExpediente(	String strIdArea,String strDescripcion,
            									String strUsrUpdate, String strFechaUpdate,
            									String strIdExp)
	{		
		int r=0;
		try
		{
			String strsql = SQLExpediente.getActualizarExpediente(	strIdArea, strDescripcion,
			        												strUsrUpdate, strFechaUpdate, strIdExp);
			////System.out.println("ActualizarUbicacion:"+strsql);
			r=ConexionDS.ejecutarActualizacion(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("ActualizarUbicacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}	
		return (r>0);
	}
    
    /**
     * Nombre del expediente
     * @param strIdExpediente	Id expediente
     * @return	nombre expediente
     */
    public static String[][] getNombreExpediente(String strIdExpediente)
	{	
		try
		{
			String strsql = SQLExpediente.getNombreExpediente(strIdExpediente);
			////System.out.println("getNombreExpediente:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getNombreExpediente:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Verifica si existen los expedientes
     * @param strIdArea	id área
     * @return true si existe expediente
     */
    public static boolean getExisteExpedientesPorArea(String strIdArea)
	{		
		try
		{
			String strsql = SQLExpediente.getExisteExpedientesPorArea(strIdArea);
			////System.out.println("getExisteExpedientesPorArea:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getExisteExpedientesPorArea:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
	}
    /**
     * Verifica si existen los expedientes
     * @param strIdArea	id área
     * @return	true si existe expediente
     */
    public static boolean getExisteExpedientesPorAreaArch(String strIdArea)
	{		
		try
		{
			String strsql = SQLExpediente.getExisteExpedientesPorAreaArch(strIdArea);
			////System.out.println("getExisteExpedientesPorAreaArch:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
		//	//System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getExisteExpedientesPorAreaArch:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
	}

}

