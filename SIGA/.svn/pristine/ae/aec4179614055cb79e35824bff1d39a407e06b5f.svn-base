/*
 * Clase:						ActualizaFlujo.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 23, 2005
 * 
 * @author: 					Luis Melgoza.
 * 								luis.melgoza@tecnoaplicada.com
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
import com.meve.sigma.sql.SQLFlujo;

/**
 * 	ActualizaFlujo es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de ruta de atención
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaFlujo {
    
	/**
	 * Lista de ruta de atención
	 * @param strOrden	orden
	 * @param tipo		tipo de orden
	 * @return	regresa arreglo de la listas de la ruta Automática
	 */
    public static String[][] getListaFlujos(String strOrden, String tipo)
	{	
	    try
		{
			String strsql=SQLFlujo.getFlujos(strOrden, tipo);
			////System.out.println("getListaFlujos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getListaFlujos:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}

    /**
     * Datos de la ruta de atención
     * @param idFlujo	id flujo
     * @return	regresa arreglo con los datos de la ruta de atención
     */
	public static String[][] getFlujos(String idFlujo)
	{	
		try
		{
			String strsql=SQLFlujo.getFlujo(idFlujo);
			////System.out.println("getFlujos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getFlujos:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
	
	/**
	 * Elimina la ruta Automática
	 * @param strIds	ids Ruta
	 * @param idBUsuario	ids usuario que Eliminó
	 * @return	true al eliminar correctamente
	 */
	public static boolean deleteFlujo(String strIds[], String idBUsuario)
	{
	     int r=0;
	     if(strIds==null || strIds.length<0)
	         return false;
		
	     try
	     {
	     	for (int i=0; i<strIds.length; i++){
		         String strsql=SQLFlujo.getDeleteFlujo(strIds[i]);
		         ////System.out.println("deleteFlujo:"+strsql);
		         boolean b = ActualizaBitacora.InsertarEventoEliminarRuta(idBUsuario,getFlujos(strIds[i])[0][3],getFlujos(strIds[i])[0][0],strIds[i]);
		         r= ConexionDS.ejecutarActualizacion(strsql);		
	     	}
	     }
	     catch(SQLException sqle)
	     {
	         //System.out.println("deleteFlujo:"+sqle.getMessage());
	         sqle.printStackTrace();
	         return false;
	     }						
	     return (r>0);	
	 }
	 
	 /**
	  * Inserta ruta Automática
	  * @param id	id ruta
	  * @param strArea	área
	  * @param strIdTipoDocto	tipo de documento
	  * @param strIdTipoAsunto	Tipo de asunto
	  * @param strCreador1		usuario que actualiza o crea el registro
	  * @param strFechaCreacion	fecha Creación
	  * @param strEstatus		Estatus
	  * @param strDescripcion	Descripción
	  * @return	true al insertar correctamente
	  */
	 public static boolean InsertarFlujo(	String id, String strArea, String strIdTipoDocto,
	         								String strIdTipoAsunto, String strCreador1, 
	         								String strFechaCreacion, String strEstatus, 
	         								String strDescripcion)
	 {
	 	int r = 0;
	 	String strSql="";
	 	try
	 	{
	 	    if (id!=null)
	 		{
	 	        strSql = SQLFlujo.getActualizaFlujo(id, strArea, strIdTipoDocto, strIdTipoAsunto, 
	 		      									strCreador1, strFechaCreacion, strEstatus, 
	 		      									strDescripcion);
	 		    ////System.out.println("EditaFlujo"+strSql);
		 		r = ConexionDS.ejecutarActualizacion(strSql);
	 		    boolean b = ActualizaBitacora.InsertarEventoCambioRuta(strCreador1,strDescripcion,strArea,id);
	 		}
	 		else{
	 		       		
	 		    strSql = SQLFlujo.getInsertaFlujo(	strArea, strIdTipoDocto, 
	 													strIdTipoAsunto, strCreador1, strFechaCreacion,
	 													strEstatus, strDescripcion);
	 				////System.out.println("InsertaFlujo"+strSql);
	 		 		r = ConexionDS.ejecutarActualizacion(strSql);
	 				boolean b = ActualizaBitacora.InsertarEventoAltaRuta(strCreador1,strDescripcion,strArea);
	 		    //}
	 		}
	 		        		
	 	}
	 	catch (SQLException sqle)
	 	{
	 		//System.out.println("InsertaFlujo:"+sqle.getMessage());
	 		sqle.printStackTrace();
	 		return false;
	 	}
	 	return (r>0);
	 }
	 
	 /**
	  * Detalle de la ruta
	  * @param strIdRuta	id ruta
	  * @return	regresa arreglo de la ruta Automática
	  */
	 public static String[][] getDetalleRuta(String strIdRuta)
	 {	
	     try
	     {
	         String strsql=SQLFlujo.getDetalleRuta(strIdRuta);
	         ////System.out.println("getDetalleRuta:"+strsql);
	         return ConexionDS.ejecutarSQL(strsql);
	     }
	     catch(SQLException sqle)
	     {
	         //System.out.println("getDetalleRuta:"+sqle.getMessage());
	         sqle.printStackTrace();
	         return null;
	     }						
	 }
	 
	 /**
	  * Ultimo Id de la ruta
	  * @return	id ruta
	  */
	public static String getUltimoIDRuta()
	{	
	    try
		{
			String strsql = SQLFlujo.getUltimoIDRuta();
			////System.out.println("getUltimoIDRuta:"+strsql);
			String IdMax[][] = ConexionDS.ejecutarSQL(strsql);
			if(IdMax != null && IdMax.length > 0)
			    return IdMax[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getUltimoIDRuta:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
	
	/**
	 * Verifica si existe la ruta Automática
	 * @param strDescripcion	Descripción de la ruta
	 * @param strAux			Auxiliar
	 * @param strArea			área
	 * @param strAux2			Auxiliar2
	 * @return	true si existe
	 */
	public static int getRutaExiste(String strDescripcion, String strAux, String strArea, String strAux2)
	{	
		try
		{
			String strSQL = SQLFlujo.getRutaExiste(strDescripcion.trim(), strAux.trim(), strArea.trim(), strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getRutaExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getRutaExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}

}

