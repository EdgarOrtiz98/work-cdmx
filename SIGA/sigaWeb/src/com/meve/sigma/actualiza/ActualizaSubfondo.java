/*
 * Clase:						ActualizaSubfondo.java
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
import com.meve.sigma.sql.SQLSubfondo;

/**
 * Clase para Insertar, Eliminar, Editar y Obtener informacion de los SubFondos
 * 
 * @author Meve Soluciones S.A. de C.V.
 */

public class ActualizaSubfondo {
    
    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de SD_SUBFONDO
     * @param codigo Codigo de subfondo
     * @param seccion Seccion del subfondo
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @return Regresa True si el proceso fue satisfactorio o False en caso contrario
     */
    public static boolean insertarSubfondo(	String codigo, String seccion,
											String fecha, String Usr)
    {
        int r = 0;
        try
        {
            String strSql = SQLSubfondo.insertarSubfondo(codigo, seccion, fecha, Usr);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertaAsunto:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Regresa los registros ordenados de SubFondos
     * @param strOrden Campo por el cual se hace el ordenamiento 
     * @param tipo Ordenamiento ascendente o descendente
     * @return Regresa el String[][] correspondiente
     */
    public static String[][] getDatosSubFondo(String strOrden, String tipo)
    {
        try
		{
			String strsql = SQLSubfondo.getDatosSubFondo(strOrden, tipo);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosSubFondo:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Función que ejectua un query, donde verifica si tiene datos la tabla
     * @return True si hay registros o False en caso contrario
     */
    public static boolean getExisteSub()
    {
        try
		{
			String strsql = SQLSubfondo.getExisteSub();
			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strClasificacion.length > 0)
			    return true;
			
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getExisteSub:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
    }
    
    /**
     * Función que ejecuta un query, donde muestra los datos de un SubAsunto
     * dependiendo de su ID
     * @param strIdSub Contiene el ID del Subfondo
     * @return String[][] correspondiente
     */
    public static String[][] getSubfondo(String strIdSub)
	{	
		try
		{
			String strsql = SQLSubfondo.getSubfondo(strIdSub);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getSubfondo:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Función que ejecuta un query donde se hace un borrado logico
     * @param strIds Contiene los id de los subfondos a borrar
     * @return True si se pudo hacer el borrado logico o False en caso contrario
     */
    public static boolean getDeleteSub(String strIds[])
	{
		int r=0;
		if(strIds==null || strIds.length<0)
			return false;
		
		try
		{
			String strsql = SQLSubfondo.getDeleteSub(strIds);
			r= ConexionDS.ejecutarActualizacion(strsql);		
		}
		catch(SQLException sqle)
		{
				//System.out.println("getDeleteSub:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}						
		return (r>0);
	}
    
    /**
     * Función que ejecuta un query, donde actualiza los datos de la 
     * tabla de Subfondo
     * @param codigo codigo del subfondo
     * @param seccion Sección del subfondo
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo Id del registro
     * @return Regresa True si el proceso fue satisfactorio o False en caso contrario
     */
    public static boolean actualizaSubfondo(String codigo, String seccion,
											String fecha, String Usr, String IdSubfondo)
    {		
        int r=0;
        try
        {
            String strsql = SQLSubfondo.actualizaSubfondo(codigo, seccion,
											fecha, Usr, IdSubfondo);
           r=ConexionDS.ejecutarActualizacion(strsql);
        }
        catch(SQLException sqle)
        {
            //System.out.println("actualizaSubfondo:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }	
        return (r>0);
    }
    

    /**
     * Función que ejecuta un query donde se hace un borrado logico
     * @param strIds Contiene los id de los subfondos a borrar
     * @return True si se pudo hacer el borrado logico o False en caso contrario
     */
    public static boolean getDeleteSubA(String strIds[])
	{
		int r=0;
		if(strIds==null || strIds.length<0)
			return false;
		
		try
		{
			String strsql = SQLSubfondo.getDeleteSubA(strIds);
			r= ConexionDS.ejecutarActualizacion(strsql);		
		}
		catch(SQLException sqle)
		{
				//System.out.println("getDeleteSub:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}						
		return (r>0);
	}

}

