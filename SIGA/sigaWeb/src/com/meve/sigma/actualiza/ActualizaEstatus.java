/*
 * Clase:						ActualizaEstatus.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Feb 4, 2006
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
import com.meve.sigma.sql.SQLEstatus;

/**
 * 	ActualizaEstatus es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Estatus
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaEstatus {
    
	/**
	 * Datos del estatus
	 * @param idEstatus	Ids estatus
	 * @return	regresa arreglo con el estatus
	 */
    public static String[][] getEstatus(String idEstatus) {
		try {
			String strsql = SQLEstatus.getEstatus(idEstatus);
			////System.out.println("getEstatus:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getEstatus:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Datos del estatus
	 * @return	regresa un arreglo con los datos del estatus
	 */
	public static String[][] getEstatus() {
		try {
			String strsql = SQLEstatus.getEstatus();
			////System.out.println("getEstatus:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getEstatus:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * inserta registro de un estatus
	 * @param nombre	Nombre estatus
	 * @param esFin		fin del estatus
	 * @param actualizo	usuario que actualizá
	 * @param fecha		fecha de Actualización
	 * @return	true si es correcto
	 */
	public static boolean getInsertaEstatus(String nombre, String esFin,
											String actualizo, String fecha) {
		int r = 0;
		try {
			String strSql = SQLEstatus.getInsertaEstatus(nombre, esFin, 
												actualizo, fecha);
			////System.out.println("getInsertaEstatus:" + strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			//System.out.println("getInsertaEstatus:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * actualza registro de un estatus
     * @param idEstatus	Id Estatus
	 * @param nombre	Nombre estatus
	 * @param esFin		fin del estatus
	 * @param actualizo	usuario que actualizá
	 * @param fecha		fecha de Actualización
	 * @return	true si es correcto
	 */
	public static boolean getActualizarEstatus(	String idEstatus, String nombre, String esFin,
												String actualizo, String fecha) {
		int r = 0;
		try {
			String strsql = SQLEstatus.getActualizarEstatus(idEstatus, nombre, esFin,
			        										actualizo, fecha);
			////System.out.println("getActualizarEstatus:" + strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getActualizarEstatus:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Elimina los estatus
	 * @param strIds	Ids de los estatus ha eliminar
	 * @return	true si fue correcto
	 */
	public static boolean getDeleteEstatus(String strIds[]) {
		int r = 0;
		if (strIds == null || strIds.length < 0)
			return false;

		try {
			String strsql = SQLEstatus.getDeleteEstatus(strIds);
			////System.out.println("getDeleteEstatus:" + strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getDeleteEstatus:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}
	
	/**
	 * Nombre del estatus
	 * @param idEstatus	id estatus
	 * @return	nombre del estatus
	 */
	public static String[][] getNombreEstatus(String idEstatus) {
		try {
			String strsql = SQLEstatus.getNombreEstatus(idEstatus);
			////System.out.println("getNombreEstatus:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getNombreEstatus:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Verifica si existe el estatus
	 * @return	true si existe
	 */
	public static boolean existenEstatus()
	{		
		try
		{
			String strsql = SQLEstatus.existenEstatus();
			////System.out.println("eexistenEstatus:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("existenEstatus:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Ciera el estatus
	 * @param strIdEstatus	id estatus
	 * @return	true difernete de 1
	 */
	public static boolean getCierre(String strIdEstatus)
	{
		int r=0;
		int nusuario=0;
		try
		{
			String strsql = SQLEstatus.getCierre(strIdEstatus);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			nusuario = new Integer(strResultado[0][0]).intValue();
		}
		catch(SQLException sqle)
		{
			//System.out.println("getCierre:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario=0;	
		}
		catch(NumberFormatException nfe)
		{		
			nusuario=0;				
		}	
		if(nusuario==0)
			return false;			
		return true;	
	}
    

}

