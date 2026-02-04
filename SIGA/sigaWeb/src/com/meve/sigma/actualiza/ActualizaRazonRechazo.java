/* 
 * Nombre de Clase:     ActualizaRazonRechazo.java
 * Paquete:             
 * Versión             1.0
 * Fecha Creación:      26/09/2005
 * Autor:               Administrador
 * Empresa:             Meve Soluciones
 * Contacto:            corichi@yahoo.com.mx
 * Modificación:        21/Sep/2005 
 * Descripción de Clase:
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.actualiza;

import java.sql.SQLException;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLRazonRechazo;

/**
 * 	ActualizaRazonRechazo es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de SD_RAZON_RECHAZO
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaRazonRechazo {
	
	/**
	 * Inserta el registro de una Razón de rechazo
	 * @param IdArea	Id área
	 * @param Descripcion	Descripción de la Razón de rechazo	
	 * @param actualizo		usuario que actualizá
	 * @param fecha			fecha de Actualización
	 * @param estatus		Estatus
	 * @return	true o false
	 */
	public static boolean InsertarRazonRechazo(String IdArea, String Descripcion, 
			String actualizo, String fecha, String estatus)
	{
	    int r = 0;
	    try
	    {
	        String strSql = SQLRazonRechazo.getInsertaRazonRechazo(	IdArea, Descripcion, 
	            				actualizo, fecha, estatus);
	            ////System.out.println("InsertaRazonRechazo"+strSql);
	            r = ConexionDS.ejecutarActualizacion(strSql);
	        }
	       	catch (SQLException sqle)
	       	{
	       	    //System.out.println("InsertaRazonRechazo:"+sqle.getMessage());
	       	    sqle.printStackTrace();
	       	    return false;
	       	}
	       	return (r>0);
	}
	    
	    /**
	     * Datos de una Razón de rechazo
	     * @param IdRazonRechazo	id Razón de rechazo
	     * @return	regresa arreglo de los datos de la Razón de rechazo
	     */
	    public static String[][] getRazonRechazo(String IdRazonRechazo)
		{	
			try
			{
				String strsql=SQLRazonRechazo.getRazonRechazo(IdRazonRechazo);
				////System.out.println("getRazonRechazo:"+strsql);
				return ConexionDS.ejecutarSQL(strsql);
			}
			catch(SQLException sqle)
			{
					//System.out.println("getRazonRechazo:"+sqle.getMessage());
					sqle.printStackTrace();
					return null;
			}						
		}
	    
	    /**
	     * Elimina las razones de rechazo
	     * @param strIds	Ids de las razones de rechazo
	     * @return	true si elimina correctamente
	     */
		public static boolean deleteRazonRechazo(String strIds[], String idBUsuario)
		{
			int r=0;
			if(strIds==null || strIds.length<0)
				return false;
			
			try
			{
				for (int i=0; i<strIds.length; i++){
					String strsql=SQLRazonRechazo.getDeleteRazonRechazo(strIds[i]);
					////System.out.println("deleteRazonRechazo:"+strsql); 
					boolean c = ActualizaBitacora.InsertarEventoEliminarRazon(idBUsuario,getRazonRechazo(strIds[i])[0][1],getRazonRechazo(strIds[i])[0][0],strIds[i]);
					r= ConexionDS.ejecutarActualizacion(strsql);		
				}
			}
			catch(SQLException sqle)
			{
					//System.out.println("deleteRazonRechazo:"+sqle.getMessage());
					sqle.printStackTrace();
					return false;
			}						
			return (r>0);
		}
		
		/**
		 * Lista de las razones de rechazo
		 * @param strOrden	Orden de columnas
		 * @param tipo		Tipo de orden de columnas(asc o desc)
		 * @return	regresa arreglo de la lista de razones de rechazo
		 */
		public static String[][] getListaRazonRechazos(String strOrden, String tipo)
		{	
			try
			{
				String strsql=SQLRazonRechazo.getRazonRechazos(strOrden, tipo);
				////System.out.println("getListaRazonRechazos:"+strsql);
				return ConexionDS.ejecutarSQL(strsql);
			}
			catch(SQLException sqle)
			{
				//System.out.println("getListaRazonRechazos:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
			}						
		}
		
	/**
	 * Actualiza el registro de un Razón de rechazo
	 * @param IdRazon	id Razón de rechazo
	 * @param IdArea	Id área
	 * @param Descripcion	Descripción de la Razón de rechazo	
	 * @param actualizo		usuario que actualizá
	 * @param fecha			fecha de Actualización
	 * @return	true o false
	 */
	public static boolean ActualizarRazonRechazo(String IdRazon, String IdArea, String Descripcion, 
								String actualizo, String fecha)
	{
	   	int r=0;
	   	try{ 
	   	    String strsql = SQLRazonRechazo.getActualizarRazonRechazo(IdRazon, IdArea, Descripcion, 
	    							actualizo, fecha);
	    	////System.out.println("ActualizarRazonRechazo:"+strsql);
	    	r=ConexionDS.ejecutarActualizacion(strsql);
	    }
	    catch(SQLException sqle){
	    	//System.out.println("ActualizarRazonRechazo:"+sqle.getMessage());
	    	sqle.printStackTrace();
	    	return false;
	    }
	    return (r>0);
	}
	
	/**
	 * Razones de rechazo por área
	 * @param strIdArea	id área
	 * @return	regresa arreglo de las razones de rechazo por áreas
	 */
	public static String[][] getRazones(String strIdArea)
	{	
		try
		{
			String strsql = SQLRazonRechazo.getRazones(strIdArea);
			////System.out.println("getRazones:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getRazones:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
	
	/**
	 * Razones de rechazo generales
	 * @param strIdArea	Id área
	 * @param strIdAreaGeneral	general
	 * @return	regresa arreglo de las razones por generales
	 */
	public static String[][] getRazonesYGeneral(String strIdArea,String strIdAreaGeneral)
	{	
		try
		{
			String strsql = SQLRazonRechazo.getRazonesYGeneral(strIdArea,strIdAreaGeneral);
			////System.out.println("getRazonesYGeneral:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getRazonesYGeneral:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
	
	/**
	 * Verifica si existe un registro en el catalogo de las razones rechazadas
	 * @param strNombre	Razón de rechazo
	 * @param strAux	Auxiliar
	 * @param strArea	área
	 * @param strAux2	Auxiliar2
	 * @return	1 existe, 2 no existe
	 */
	public static int getRazonExiste(String strNombre, String strAux, String strArea, String strAux2)
	{	
		try
		{
			String strSQL = SQLRazonRechazo.getRazonExiste(strNombre.trim(),strAux.trim(),strArea.trim(),strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getRazonExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getRazonExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}
}