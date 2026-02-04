/*
 * Clase:						ActualizaComentario.java
 * 
 * Paquete:						com.meve.sigma.reportes		
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

package com.meve.sigma.reportes;

import java.sql.SQLException;

import com.meve.sigma.db2.ConexionDS;

/**
 * Clase para Insertar, Borrar y Editar los Comentarios de los Asuntos
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaComentario {
    
    /**
     * Inserta un Comentario a un Asunto asociado a idAsnto
     * 
     * @param comentario Comentario que se va a insertar
     * @param Usr ID del Usuario 
     * @param fecha Fecha en la que se inserta el comentario 
     * @param idAsnto ID del asunto al que se le inserta el comentario 
     * @param UsrNombre Nombre del Usuario
     * 
     * @return Regresa True si se pudo insertar el comentario y False si hubo una problema
     */
    public static boolean InsertarEventoResponder(String comentario, String Usr, String fecha, String idAsnto, String UsrNombre)
    {
        int r = 0;
        try
        {
            String sql = SQLComentario.InsertarComentario(comentario, Usr, fecha, idAsnto, UsrNombre);
            ////System.out.println("InsertarEventoResponder="+sql);
            r = ConexionDS.ejecutarActualizacion(sql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertarEventoResponder:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Verifica si existen registros de comentarios para determinado ID de Asunto
     * 
     * @param strIdAsunto ID del Asunto 
     * 
     * @return Regresa True si el Asunto tiene Comentarios asociados y False si no los tiene 
     */
    public static boolean getExistenComentarios(String strIdAsunto)
	{		
		try
		{
			String strsql = SQLComentario.getExistenComentarios(strIdAsunto);
			////System.out.println("getExistenComentarios:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			////System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenComentarios"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Regresa un arreglo con todos los Comentarios Asociados a un ID de Asunto
     * 
     * @param strIdAsunto ID del Asunto
     * 
     * @return Regresa un String[][] con los comentarios del asunto y su fecha
     */
    public static String[][] getDatosComentarios(String strIdAsunto)
	{	
		try
		{
			String strsql = SQLComentario.getDatosComentarios(strIdAsunto);
			////System.out.println("getDatosComentarios:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosComentarios:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}

    
    public static String[][] getDatosComentariosComplementarios(String strIdAsunto)
	{	
		try
		{
			String strsql = SQLComentario.getDatosComentariosComplementario(strIdAsunto);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}						
	}
    
}

