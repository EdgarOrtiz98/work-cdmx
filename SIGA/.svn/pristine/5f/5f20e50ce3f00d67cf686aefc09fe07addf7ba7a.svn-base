/*
 * Clase:						SQLFolio.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 22, 2005
 * 
 * @author: 					Arturo Corichi Guerrero
 * 								corichi@yahoo.com.mx
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		
 */
package com.meve.sigma.actualiza;

import java.sql.SQLException;
import java.util.Vector;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLTipoAsunto;

/**
 * Clase para Insertar, Eliminar, Editar y Obtener informacion de los Tpos de Asunto
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaTipoAsunto {

	/**
	 * Regresa los campos de Tipo de Asunto por ID
	 * @param idTipoAsunto ID del Tipo de Asunto
	 * @return Regresa el String[][] correspondiente
	 */
	public static String[][] getTipoAsunto(String idTipoAsunto) {
		try {
			String strsql = SQLTipoAsunto.getTipoAsunto(idTipoAsunto);
			////System.out.println("getTipoAsunto:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getTipoAsunto:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
     * Regresa una lista de Tipo de Asuntos ordenada
     * @param strOrden Campo por el que se hace el ordenamiento 
     * @param tipo Ordenamiento ascendente o descendente
     * @return Regresa un String[][] con los registros correspondientes
     */
	public static String[][] getListaTipoAsuntos(String strOrden, String tipo) {
		try {
			String strsql = SQLTipoAsunto.getTipoAsuntos(strOrden, tipo);
			////System.out.println("getListaTipoAsuntos:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getListaTipoAsuntos:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Inserta un Tipo de Asunto en la BD
	 * @param idArea Unidad Administrativa
	 * @param nombre Nombre
	 * @param actualizo Usuario que actualizá
	 * @param fecha Fecha de Actualización
	 * @param estatus Estatus 
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */
	public static boolean InsertarTipoAsunto(String idArea, String nombre, 
							String actualizo, String fecha, String estatus) {
		int r = 0;
		try {
			String strSql = SQLTipoAsunto.getInsertaTipoAsunto(idArea,
							nombre, actualizo, fecha, estatus);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			//System.out.println("InsertaTipoAsunto:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Actualiza un Tipo de Asunto en la BD
	 * @param idTipoAsunto ID del Tipo de Asunto
	 * @param idArea Unidad Administrativa
	 * @param nombre Nombre
	 * @param actualizo Usuario que actualizá
	 * @param fecha Fecha de Actualización
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */
	public static boolean ActualizarTipoAsunto(String idTipoAsunto,
			String idArea, String nombre, String actualizo, String fecha) {
		int r = 0;
		try {
			String strsql = SQLTipoAsunto.getActualizarTipoAsunto(idTipoAsunto,
					idArea, nombre, actualizo, fecha);
			////System.out.println("ActualizarTipoAsunto:" + strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			//System.out.println("ActualizarTipoAsunto:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Elimina logicamente los registros de Tipo de Asunto
	 * @param strIds ID's de los Tipos de Asunto
	 * @param stridUsuario ID del Usuario que ejecuta la accion
	 * @return Regresa un Vector vacio si la operacion fue exitosa, en caso contrario contiene ID que no fueron eliminados
	 */
    public static Vector deleteTipoAsunto(String strIds[], String stridUsuario)
	{
    	Vector vTiene = new Vector();
		int r=0;
		if(strIds==null || strIds.length<0)
			return vTiene;
		
		try
		{ 
			for(int i=0;i<strIds.length;i++){
				
				boolean bRuta	= getCountGeneral(SQLTipoAsunto.getCountRuta(strIds[i]));
				boolean bAsunto	= getCountGeneral(SQLTipoAsunto.getCountAsuntos(strIds[i]));
				
				if ( bRuta && bAsunto ){
					
					String strsql = SQLTipoAsunto.getDeleteTipoAsunto(strIds[i]);
					boolean b = ActualizaBitacora.InsertarEventoEliminarTipoAsu(stridUsuario,getTipoAsunto(strIds[i])[0][1],getTipoAsunto(strIds[i])[0][0],strIds[i]);
					r = ConexionDS.ejecutarActualizacion(strsql);
				}else{
					String msg = "";
					if(!bRuta)
						msg += "Rutas Automaticas, ";
					if(!bAsunto)
						msg += "Asuntos generados, ";
					vTiene.add(strIds[i]);
					vTiene.add(msg);
				}
			}
		}
		catch(SQLException sqle)
		{
			//System.out.println("deleteTipoAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
		}						
		return vTiene;	
	}

	/**
	 * Función que ejecuta un query, donde muestra el nombre del
	 * tipo de asunto
	 * @param idTipoAsunto Contiene el Id de Tipo de Asunto
	 * @return Regresa un String[][] con los registros correspondientes
	 */
	public static String getNombreTipoAsunto(String idTipoAsunto)
    {
        try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLTipoAsunto.getNombreTipoAsunto(idTipoAsunto));
			////System.out.println("getNombreTipoAsunto:"+strResult[0][0]);
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getNombreTipoAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
	
	/**
     * Verifica si Existe un Tipo de Asunto por su Nombre y UA, ademas de compararlos con sus datos antes de ser editados
     * @param strNombre Nombre 
     * @param strArea Unidad Administrativa 
     * @param strAux Nombre del Tipo de Asunto antes de ser editado
     * @param strAux2 Unidad Administrativa  antes de ser editado
     * @return Regresa 1 si Existe, 2 si no existe y -1 si hubo un Error
     */
	public static int getTipoAsuntoExiste(String strNombre, String strAux, String strArea, String strAux2)
	{	
		try
		{
			String strSQL = SQLTipoAsunto.getTipoAsuntoExiste(strNombre.trim(),strAux.trim(),strArea.trim(),strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getTipoAsuntoExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getTipoAsuntoExiste"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}
 
	/**
     * Determina si el resultado de un Query tiene 1 o mas registros
     * @param sql Query a ejecutar
     * @return Regresa True si la busqueda arrojo 1 o mas registros o False en caso contrario
     */
	public static boolean getCountGeneral(String sql)
    {
    	boolean bTiene = false;
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(sql);
			
			if(strResult!=null && strResult.length>0){
				if(strResult[0][0].equals("0"))
					bTiene = true;
				else
					bTiene = false;
			}
			
		}
		catch(SQLException sqle)
		{
			//System.out.println("getCountGeneral:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}

	/**
     * Regresa el Estatus de un Tipo de Asunto  
     * @param strIdTipoAsunto ID del Tipo de Asunto  
     * @return Regresa un String con el registros correspondientes
     */
    public static String getEstatusTipoAsunto(String strIdTipoAsunto)
	{		
		try
		{
			String strsql = SQLTipoAsunto.getEstatusTipoAsunto(strIdTipoAsunto);
			////System.out.println("getEstatusTipoAsunto:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strResult!=null && strResult.length > 0)
			    return strResult[0][0];
			else 
				return "";
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEstatusTipoAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}	
	}
}