/*
 * Clase:						ActualizaUbicacion.java
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
import com.meve.sigma.sql.SQLUbicacion;

/**
 * Clase para Insertar, Eliminar, Editar y Obtener informacion de la Ubicación
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaUbicacion {
    
	/**
	 * Inserta una Ubicación en la Base de Datos
	 * @param idArea Unidad Administrativa
	 * @param ubicacion Ubicación 
	 * @param idActualizo Usuario que actualizá
	 * @param fechaUpdate Fecha de Actualización
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */
    public static boolean InsertarUbicacion(	String idArea, String ubicacion, 
			String idActualizo,	String fechaUpdate)
    {
        int r = 0;
        try
        {
            String strSql = SQLUbicacion.getInsertaUbicacion(idArea, ubicacion, idActualizo, fechaUpdate);
            ////System.out.println("InsertarUbicacion:"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertarUbicacion:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
	 * Regresa una lista de las Ubicaciones 
	 * @param strOrden Campo por el cual se ordena la lista 
	 * @param tipo Ordenamiento ascendente o descendente
	 * @return Regresa el String[][] correspondiente
	 */
    public static String[][] getListaUbicacion(String strOrden, String tipo)
	{	
		try
		{
			String strsql = SQLUbicacion.getListaUbicacion(strOrden, tipo);
			////System.out.println("getListaUbicacion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getListaUbicacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Valida si existen Ubicaciones
     * @return Regresa True si existen Ubicaciones o False en caso contrario
     */
    public static boolean getExiste()
	{		
		try
		{
			String strsql = SQLUbicacion.getExiste();
			////System.out.println("ExistenUbicacion:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			////System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("ExistenUbicacion:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
		
			
	}
    
    /**
	 * Elimina logicamente el tramite
	 * @param strIds ID's de los Tramites
	 * @param idBUsuario ID del usuario que ejecuta la acción
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */
    public static boolean deleteUbicacion(String strIds[], String idBUsuario)
	{
		int r=0;
		if(strIds==null || strIds.length<0)
			return false;
		
		try
		{
			for (int i=0; i<strIds.length; i++){
				String strsql = SQLUbicacion.getDeleteUbicacion(strIds[i]);
				////System.out.println("DeleteUbicacion:"+strsql); 
				boolean b = ActualizaBitacora.InsertarEventoEliminarUbicacion(idBUsuario,getDatosUbicacion(strIds[i])[0][1],getDatosUbicacion(strIds[i])[0][0],strIds[i]);
				r= ConexionDS.ejecutarActualizacion(strsql);		
			}
		}
		catch(SQLException sqle)
		{
				//System.out.println("DeleteUbicacion:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}						
		return (r>0);
	}
    
    /**
     * Regresa los campos de la Ubicación segun su ID
     * @param strIdUbicacion ID de Ubicacion
     * @return Regresa el String[][] correspondiente
     */
    public static String[][] getDatosUbicacion(String strIdUbicacion)
	{	
		try
		{
			String strsql = SQLUbicacion.getDatosUbicacion(strIdUbicacion);
			////System.out.println("getDatosUbicacion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosUbicacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Actualiza una Ubicación en la Base de Datos
     * @param strIdArea Unidad Administrativa
     * @param strDescripcion Descripción
     * @param strUsrUpdate Usuario que actualizá
     * @param strFechaUpdate Fecha de Actualización 
     * @param strIdUbi ID de Ubicación
     * @return Regresa un True si la operacion fue exitosa y False en caso contrario
     */
    public static boolean ActualizarUbicacion(	String strIdArea,String strDescripcion,
            									String strUsrUpdate, String strFechaUpdate, String strIdUbi)
	{		
		int r=0;
		try
		{
			String strsql = SQLUbicacion.getActualizarUbicacion(strIdArea, strDescripcion,
			        											strUsrUpdate, strFechaUpdate, strIdUbi);
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
     * Regresa el Nombre de la Ubicación segun su ID 
     * @param strIdUbicacion ID de la Ubicación
     * @return Regresa el String correspondiente
     */
    public static String[][] getNombreUbicacion(String strIdUbicacion)
	{	
		try
		{
			String strsql = SQLUbicacion.getNombreUbicacion(strIdUbicacion);
			////System.out.println("getNombreUbicacion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getNombreUbicacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Verifica si una Ubicación ya existe segun su Descripcion y Unidad Administrativa
     * @param strDescripcion Descripción
     * @param strAux Descripcion antes de ser editada de 
     * @param strArea Unidad Administrativa
     * @param strAux2 Unidad Administrativa antes de ser editada
     * @return Regresa 1 si ya existe, 2 si no existe y -1 si hubo algun error
     */
    public static int getUbicacionExiste(String strDescripcion, String strAux, String strArea, String strAux2)
	{	
		try
		{
			String strSQL = SQLUbicacion.getUbicacionExiste(strDescripcion.trim(),strAux.trim(),strArea.trim(),strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getUbicacionExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getUbicacionExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}

}

