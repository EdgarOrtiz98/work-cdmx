/*
 * Clase:						ActualizaSeccion.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Dec 7, 2005
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
import com.meve.sigma.sql.SQLSeccion;


/**
 * Clase para Insertar, Eliminar, Editar y Obtener informacion de las Secciones
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaSeccion {
    
    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de SD_SECCION
     * @param codigo Codigo de seccion
     * @param seccion Seccion del seccion
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @return Regresa True si el proceso fue satisfactorio o False en caso contrario
     */
    public static boolean insertarSeccion(	String codigo, String seccion, String idSub,
											String fecha, String Usr)
    {
        int r = 0;
        try
        {
            String strSql = SQLSeccion.insertarSeccion(codigo, seccion, idSub, fecha, Usr);
            // //System.out.println("insertarSeccion"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("insertarSeccion:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Regresa los registros ordenados de Seccion
     * @param strOrden Campo por el cual se hace el ordenamiento 
     * @param tipo Ordenamiento ascendente o descendente
     * @return Regresa el String[][] correspondiente
     */
    public static String[][] getDatosSeccion(String strOrden, String tipo)
    {
        try
		{
			String strsql = SQLSeccion.getDatosSeccion(strOrden, tipo);
			////System.out.println("getDatosSeccion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosSeccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Verfica si hay registros de Seccion
     * @return True si hay registros o False en caso contrario
     */
    public static boolean getExisteSec()
    {
        try
		{
			String strsql = SQLSeccion.getExisteSec();
			////System.out.println("ggetExisteSec:"+strsql);
			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strClasificacion.length > 0)
			    return true;
			
			////System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getExisteSec:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
    }
    
    /**
     * Función que ejecuta un query, donde muestra los datos de un SubAsunto
     * dependiendo de su ID
     * @param strIdSec Contiene el ID del seccion
     * @return String[][] correspondiente
     */
    public static String[][] getSeccion(String strIdSec)
	{	
		try
		{
			String strsql = SQLSeccion.getSeccion(strIdSec);
			////System.out.println("getSeccion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getSeccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Función que ejecuta un query donde se hace un borrado logico
     * @param strIds Contiene los id de los seccion a borrar
     * @return True si se pudo hacer el borrado logico o False en caso contrario
     */
    public static boolean getDeleteSec(String strIds[])
	{
		int r=0;
		if(strIds==null || strIds.length<0)
			return false;
		
		try
		{
			String strsql = SQLSeccion.getDeleteSec(strIds);
			////System.out.println("getDeleteSec:"+strsql); 
			r= ConexionDS.ejecutarActualizacion(strsql);		
		}
		catch(SQLException sqle)
		{
				//System.out.println("getDeleteSec:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}						
		return (r>0);
	}
    
    /**
     * Función que ejecuta un query, donde actualiza los datos de la 
     * tabla de seccion
     * @param codigo codigo del seccion
     * @param seccion Sección del seccion
     * @param idSeccion Id del registro
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo IdSubfondo
     * @return Regresa True si el proceso fue satisfactorio o False en caso contrario
     */
    public static boolean actualizaSeccion(String codigo, String seccion, String idSeccion,
											String fecha, String Usr, String IdSubfondo)
    {		
        int r=0;
        try
        {
            String strsql = SQLSeccion.actualizaSeccion(codigo, seccion, idSeccion,
											fecha, Usr, IdSubfondo);
            ////System.out.println("actualizaSeccion:"+strsql);
            r=ConexionDS.ejecutarActualizacion(strsql);
        }
        catch(SQLException sqle)
        {
            //System.out.println("actualizaSeccion:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }	
        return (r>0);
    }

}

