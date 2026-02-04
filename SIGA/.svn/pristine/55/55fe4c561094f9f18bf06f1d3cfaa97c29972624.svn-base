/*
 * Clase:						ActualizaClasificacion.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 24, 2005
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
import com.meve.sigma.sql.SQLClasificacion;

/**
 * 	ActualizaClasificación es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Clasificación
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaClasificacion {
    
	/**
	 * Inserta la Clasificación de un asunto
	 * @param strTipo	Tipo de Clasificación
	 * @param strUsrActualizo	usuario que actualizo
	 * @param strFecha	fecah de Actualización
	 * @return true si inserta correctamente
	 */
    public static boolean InsertarClasificacion(String strTipo,
												String strUsrActualizo, 
												String strFecha)
    {
        int r = 0;
        try
        {
            String strSql = SQLClasificacion.InsertarClasificacion(strTipo, strUsrActualizo, strFecha);
            ////System.out.println("InsertarClasificacion:"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertarClasificacion:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Actualiza la Clasificación de un asunto
     * @param strIdCla	Id Clasificación
     * @param strTipo		Tipo de Clasificación
     * @param strUsrActualizo	usuario que actualiza
     * @param strFecha		Fecha de Actualización
     * @return	true si actualiaza correctamente
     */
    public static boolean ActualizarClasificacion(String strIdCla, String strTipo,
													String strUsrActualizo, String strFecha)
    {		
        int r=0;
        try
        {
            String strsql = SQLClasificacion.getActualizarExpediente(strIdCla, strTipo,
                    												strUsrActualizo, strFecha);
            ////System.out.println("ActualizarClasificacion:"+strsql);
            r=ConexionDS.ejecutarActualizacion(strsql);
        }
        catch(SQLException sqle)
        {
            //System.out.println("ActualizarClasificacion:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }	
        return (r>0);
    }
    
    /**
     * Datos de la Clasificación de un asunto
     * @param strIdCla	Id Clasificación
     * @return	regresa arreglo de los datos de la Clasificación de un asunto
     */
    public static String[][] getDatosClasificacion(String strIdCla)
	{	
		try
		{
			String strsql = SQLClasificacion.getDatosClasificacion(strIdCla);
			////System.out.println("getDatosClasificacion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosClasificacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Elimina registros de la Clasificación de asuntos
     * @param strIds	Ids a eliminar
     * @return	true si elimina correctamente
     */
    public static boolean getDeleteClasificacion(String strIds[])
	{
		int r=0;
		if(strIds==null || strIds.length<0)
			return false;
		
		try
		{
			String strsql = SQLClasificacion.getDeleteClasificacion(strIds);
			////System.out.println("getDeleteClasificacion:"+strsql); 
			r= ConexionDS.ejecutarActualizacion(strsql);		
		}
		catch(SQLException sqle)
		{
				//System.out.println("getDeleteClasificacion:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}						
		return (r>0);
	}
    
    /**
     * Verifica si existen registros de la Clasificación de asuntos
     * @return	true si existen
     */
    public static boolean getExiste()
	{		
		try
		{
			String strsql = SQLClasificacion.getExiste();
			////System.out.println("getExiste:"+strsql);
			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strClasificacion.length > 0)
			    return true;
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getExiste:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
	}
    
    /**
     * Lista de registros de la Clasificación de asuntos
     * @param strOrden	Orden
     * @param tipo		Tipo de orden(asc o desc)
     * @return	regresa arreglo de la lista de Clasificación
     */
    public static String[][] getListaClasificacion(String strOrden, String tipo)
	{	
		try
		{
			String strsql = SQLClasificacion.getListaClasificacion(strOrden, tipo);
			////System.out.println("getListaClasificacion():"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getListaClasificacion():"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Función que ejecuta un query, donde regresa el nombre del tipo de 
     * Clasificación de un asunto
     * @param idClaAsunto Contiene el ID de la Clasificación del asunto
     * @return ConexionDS.ejecutarSQL(strsql)
     */
    public static String[][] getNombreTipoClasificacion(String idClaAsunto)
	{	
		try
		{
			String strsql = SQLClasificacion.getNombreTipoClasificacion(idClaAsunto);
		//	//System.out.println("getNombreTipoClasificacion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getNombreTipoClasificacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Función que ejecuta un queru, donde regresa una lista de asuntos que pertenece
     * a cada Clasificación de asunto
     * @param IdCla Contiene el ID de la Clasificación de asunto
     * @return String[][]
     */
    public static String[][] getAsuntosHijos(String IdCla)
	{	
		try
		{
			String strsql = SQLClasificacion.getAsuntosHijos(IdCla);
		//	//System.out.println("getAsuntosHijos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntosHijos:"+sqle.getMessage());
			sqle.printStackTrace();
			return new String[0][0];//return null;
		}						
	}
}

