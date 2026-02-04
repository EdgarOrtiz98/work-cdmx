/*
 * Clase:						ActualizaDestino.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 12, 2006
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
import com.meve.sigma.sql.SQLDestino;

/**
 * 	ActualizaDestino es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Destinatarios Externos
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaDestino {

	/**
	 * Función que ejecuta un query, donde devuelve el id del Destino
	 * @param getUsuariosPorArea	Usuarios por área
	 * @param strOrden				Orden de las columnas
	 * @param tipo					Tipo de Orden
	 * @return	regresa un arreglo con los destinatarios del área
	 */
	public static String[][] getDestinoPorArea(String getUsuariosPorArea, String strOrden, String tipo)
	{	
		try
		{
			String strsql = SQLDestino.getDestinoPorArea(getUsuariosPorArea, strOrden, tipo);
			////System.out.println("getUsuariosPorArea:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getUsuariosPorArea:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
	
    /**
     * Elimina los registros de los destinatarios
     * @param strIds	Ids de los destinatarios a eliminar
     * @param idBUsuario	Id usuario que Eliminó
     * @return	true si Eliminó corectamente
     */
	public static boolean deleteDestino(String strIds[],String idBUsuario)
	{
		int r=0;
		if(strIds==null || strIds.length<0)
			return false;
		
		try
		{
			for(int i=0;i<strIds.length;i++){
				String strsql = SQLDestino.getDeleteDestino(strIds[i]);
				boolean bBitCam = ActualizaBitacora.InsertarEventoEliminarDestExt(idBUsuario,getDestino(strIds[i])[0][2],getDestino(strIds[i])[0][5],strIds[i]); 
				////System.out.println("getDeleteDestino:"+strsql); 
				r= ConexionDS.ejecutarActualizacion(strsql);
			}
		}
		catch(SQLException sqle)
		{
				//System.out.println("getDeleteDestino:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}						
		return (r>0);
	}
	
	/**
	 * Inserta registro del destinatario
	 * @param nombre	Nombre destinatario
	 * @param idArea	Id área que pertenece
	 * @param desc		Descripción
	 * @param correo	Mail
	 * @param telefono	Teléfono
	 * @return	true si inserta correctamente
	 */
	public static boolean InsertarDestino(	String nombre, String idArea, 
											String desc, String correo,
											String telefono)
	{
	    int r = 0;
	    try
	    {     	        
	        String strSql = SQLDestino.getInsertaDestino(nombre, idArea, desc, correo,telefono);
	        r = ConexionDS.ejecutarActualizacion(strSql);
	    }
	    catch (SQLException sqle)
	    {
	        //System.out.println("InsertarDestino:"+sqle.getMessage());
	        sqle.printStackTrace();
	        return false;
	    }
	    return (r>0);
	}
	
	/**
	 * Datos del destinatario
	 * @param idDestino	id destinatario
	 * @return	Regresa arreglo con los datos del destinatario
	 */
	public static String[][] getDestino(String idDestino)
	{	
		try
		{
			String strsql = SQLDestino.getDestino(idDestino);
			////System.out.println("getUsuario:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getUsuario:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
	
	/**
	 * 
	 * @param idUsuario	Id destinatario
	 * @param nombre	Nombre destinatario
	 * @param idArea	Id área
	 * @param desc		Descripción
	 * @param correo	mail
	 * @param telefono	Teléfono
	 * @return	true si actualizá correctamente
	 */
	public static boolean ActualizarDestino(String idUsuario, String nombre, 
											String idArea, String desc, 
											String correo, String telefono)
    {
    	int r=0;
    	try{
    			String strsql = SQLDestino.getActualizarDestino(idUsuario, nombre, idArea, desc, correo,
																telefono);
    			////System.out.println("getActualizarDestino:"+strsql);
    			r=ConexionDS.ejecutarActualizacion(strsql);
    		}
    		catch(SQLException sqle){
    			//System.out.println("getActualizarDestino:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return false;
    		}
    		return (r>0);
    }
	
	/**
	 * Verifica si el destinatario existe
	 * @param strNombre	Nombre destinatario
	 * @param strAux	Auxiliar
	 * @param strArea	área
	 * @param strAux2	Auxiliar 2
	 * @return	1 si existe, 2 no existe
	 */
	public static int getDestinatarioExiste(String strNombre, String strAux, String strArea, String strAux2)
	{	
		try
		{
			String strSQL = SQLDestino.getDestinatarioExiste(strNombre.trim(),strAux.trim(),strArea.trim(),strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getDestinatarioExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDestinatarioExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}

}
