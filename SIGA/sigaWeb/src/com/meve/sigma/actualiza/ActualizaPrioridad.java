/*
 * 
 * Clase:						ActualizaPrioridad.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 21, 2005
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
import java.util.Vector;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLPrioridad;

/**
 * 	ActualizaPrioridad es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de SD_PRIORIDAD
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaPrioridad {
    
    /**
     * Inserta ó actualiza los registros de un prioridad
     * @param id	Id Prioridad
     * @param strPrioridad	Nombre prioridad
     * @param strPrioridadArea	área a la que pertenece la prioridad
     * @param strPrioridadHexagesimal	Número hexagesimal
     * @param strCreador1	Usuario creador o que actualiza el registro
     * @param strFechaCreacion	fecha de Creación o Actualización
     * @param strEstatus	estatus de la prioridad
     * @return	true si inserta correctamente
     */
	public static boolean InsertarPrioridad(String id, String strPrioridad, String strPrioridadArea, String strPrioridadHexagesimal,
											String strCreador1, String strFechaCreacion, String strEstatus)
	{
		int r = 0;
		String strSql="";
		try
		{
			if (id!=null)
        	{
				String datos[][] = ActualizaPrioridad.getPrioridades(id);
        		strSql = SQLPrioridad.getActualizaPrioridad(id, strPrioridad, strPrioridadArea, 
						strPrioridadHexagesimal, strCreador1,strFechaCreacion,strEstatus);
        		////System.out.println("EditaPrioridad"+strSql);
    			r = ConexionDS.ejecutarActualizacion(strSql);
    			boolean b = ActualizaBitacora.InsertarEventoCambioPrioridades(strCreador1,strPrioridad,strPrioridadArea,id,datos);
        	}
        	else{
        		strSql = SQLPrioridad.getInsertaPrioridad(	strPrioridad, strPrioridadArea, 
			        											strPrioridadHexagesimal, strCreador1, 
			        											strFechaCreacion,strEstatus);
        			////System.out.println("InsertaPrioridad"+strSql);
        			r = ConexionDS.ejecutarActualizacion(strSql);
        			boolean b = ActualizaBitacora.InsertarEventoAltaPrioridades(strCreador1,strPrioridad,strPrioridadArea);
        		//}
        	}
		}
		catch (SQLException sqle)
		{
			//System.out.println("InsertaPrioridad:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r>0);
	}
	
	/**
	 * Lista de las prioridades para la vista del catalogo
	 * @return	regresa arreglo de las prioridades
	 */
	public static String[][] getListaPrioridades(String strOrden, String tipo)
	{	
		try
		{
			String strsql=SQLPrioridad.getPrioridades(strOrden, tipo);
			////System.out.println("getListaPrioridades:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getListaPrioridades:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
	/**
	 * Datos del registro de un prioridad
	 * @param idPrioridad	Id Prioridad
	 * @return	regresa arreglo de los datos de un prioridad
	 */
    public static String[][] getPrioridades(String idPrioridad)
	{	
		try
		{
			String strsql=SQLPrioridad.getPrioridad(idPrioridad);
			////System.out.println("getPrioridades:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getPrioridades:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Elimina registros de prioridades del catalogo
     * @param strIds	Ids de prioridades a eliminar
     * @return	Vector con los ids de prioridades que no se eliminarón
     */
    public static Vector deletePrioridad(String strIds[], String idBUsuario)
	{
		Vector vTiene = new Vector(); 
		int r=0;
		if(strIds==null || strIds.length<0)
			return vTiene;
		
		try
		{
			for (int i=0; i<strIds.length; i++){
				boolean bAsunto		= getCountGeneral(SQLPrioridad.getCountAsuntos(strIds[i]));
				if ( bAsunto ){
					String strsql=SQLPrioridad.getDeletePrioridad(strIds[i]);
					////System.out.println("deletePrioridad:"+strsql);
					boolean b = ActualizaBitacora.InsertarEventoEliminarPrioridades(idBUsuario,getPrioridades(strIds[i])[0][0],getPrioridades(strIds[i])[0][1],strIds[i]);
					r= ConexionDS.ejecutarActualizacion(strsql);	
				}else{
					String msg = "";
					if(!bAsunto)
						msg += "Asuntos generados, ";
					vTiene.add(strIds[i]);
					vTiene.add(msg);
				}
			}
		}
		catch(SQLException sqle)
		{
				//System.out.println("deletePrioridad:"+sqle.getMessage());
				sqle.printStackTrace();
		}						
		return vTiene;	
	}
    
    /**
     * Función que ejecuta un query, donde muestra el nombre de la Prioridad
     * @param idPrioridad Contiene el Id de la Prioridad
     * @return	Nombre prioridad
     */
    public static String getNombrePrioridad(String idPrioridad)
    {
        try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLPrioridad.getNombrePrioridad(idPrioridad));
			////System.out.println("getNombrePrioridad:"+strResult[0][0]);
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getNombrePrioridad:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Verifica si existe el registro de la prioridad en los catalogos
     * @param strPrioridad	Nombre de la prioridad
     * @param strAux		Auxiliar
     * @param strArea		área
     * @param strAux2		Auxiliar2
     * @return	1 si existe, 2 no existe
     */
    public static int getPrioridadExiste(String strPrioridad, String strAux, String strArea, String strAux2){
		try
		{
			String strSQL = SQLPrioridad.getPrioridadExiste(strPrioridad.trim(), strAux.trim(), strArea.trim(), strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getPrioridadExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getPrioridadExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}

    /**
     * Estatus de la prioridad
     * @param strIdPrioridad	Id prioridad
     * @return	Estatus prioridad
     */
    public static String getEstatusPrioridad(String strIdPrioridad)
	{		
		try
		{
			String strsql = SQLPrioridad.getEstatusPrioridad(strIdPrioridad);
			////System.out.println("getEstatusPrioridad:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strResult!=null && strResult.length > 0)
			    return strResult[0][0];
			else 
				return "";
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEstatusPrioridad:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}	
	}
    
    /**
     * Total de registros
     * @param sql	query
     * @return	true o false
     */
    public static boolean getCountGeneral(String sql)
	{
    	boolean bTiene = false;
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(sql);
			//System.out.println(sql);
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

}
