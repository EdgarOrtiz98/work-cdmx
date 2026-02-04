/*
 * Clase:						ActualizaInst.java
 * 
 * Paquete:						com.meve.sigma.reportes		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 25, 2005
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
import com.meve.sigma.reportes.SQLInst;
import com.meve.sigma.actualiza.*;

/**
 * Clase para Insertar, Borrar y Editar las Instrucciones del Catalogo
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaInst {
    
    /**
     * Regresa un arreglo con los campos de las instrucciones asociadas a un ID de Instruccion
     * 
     * @param idInstruccion ID de Instruccion
     * 
     * @return Regresa un String[][] con los datos de la Instruccion.
     */
	public static String[][] getInstrucciones(String idInstruccion) {
		try {
			String strsql = SQLInst.getInstrucciones(idInstruccion);
			////System.out.println("getInstrucciones:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getInstrucciones:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

    /**
     * Regresa un arreglo con los campos de las instrucciones ordenadas por Orden y Tipo
     * 
     * @param strOrden El Campo por el que va a ordenar
     * @param tipo tipo ascendente o descendente 
     * 
     * @return Regresa un String[][] con los datos de las Instrucciones.
     */
	public static String[][] getInstrucciones(String strOrden, String tipo) {
		try {
			String strsql = SQLInst.getInstrucciones(strOrden, tipo);
			////System.out.println("getInstrucciones:" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getInstrucciones:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Inserta una Instruccion al catalogo
	 * 
	 * @param idArea UA al que pertenece la instrucción
	 * @param nombre Nombre de la instrucción
	 * @param actualizo ID del Usuario que insertó la instrucción
	 * @param fecha Fecha de la inserción
	 * 
	 * @return Regresa True si se pudo insertar la instrucción y False si hubo una problema
	 */
	public static boolean getInsertaInstruccion(String idArea, String nombre, 
							String actualizo, String fecha) {
		int r = 0;
		try {
			String strSql = SQLInst.getInsertaInstruccion(idArea,
							nombre, actualizo, fecha);
			////System.out.println("getInsertaInstruccion:" + strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		} catch (SQLException sqle) {
			//System.out.println("getInsertaInstruccion:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Actualiza una Instruccion en el catalogo
	 * 
	 * @param idTipoAsunto ID de la instrucción
	 * @param idArea UA al que pertenece la instrucción
	 * @param nombre Nombre de la instrucción
	 * @param actualizo ID del Usuario que insertó la instrucción
	 * @param fecha Fecha de la inserción
	 * 
	 * @return Regresa True si se pudo actualizar la instrucción y False si hubo una problema
	 */

	public static boolean getActualizarInstruccio(String idTipoAsunto,
			String idArea, String nombre, String actualizo, String fecha) {
		int r = 0;
		try {
			String strsql = SQLInst.getActualizarInstruccion(idTipoAsunto,
					idArea, nombre, actualizo, fecha);
			////System.out.println("getActualizarInstruccion:" + strsql);
			r = ConexionDS.ejecutarActualizacion(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getActualizarInstruccion:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}

	/**
	 * Borra las Instrucciones asiciadas a un arreglo de Id's
	 * 
	 * @param strIds Arreglo de ID's de Instrucciones que se quieren borrar
	 * @param idBUsuario ID del Usuario que borra las instrucciones
 	 * 
 	 * @return Regresa True si se pudieron eliminar las Instrucciones y False si hubo una problema
	 */
	public static boolean getDeleteInstruccion(String strIds[], String idBUsuario) {
		int r = 0;
		if (strIds == null || strIds.length < 0)
			return false;

		try {
			for (int i=0; i<strIds.length; i++){
				String strsql = SQLInst.getDeleteInstruccion(strIds[i]);
				////System.out.println("getDeleteInstruccion:" + strsql);
				boolean b = ActualizaBitacora.InsertarEventoEliminarInstruccion(idBUsuario,getInstrucciones(strIds[i])[0][1],getInstrucciones(strIds[i])[0][0],strIds[i]);
				r = ConexionDS.ejecutarActualizacion(strsql);
			}
		} catch (SQLException sqle) {
			//System.out.println("getDeleteInstruccion:" + sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r > 0);
	}
	
	/**
     * Regresa un arreglo con el nombre de la instruccion asociada al ID de Instruccion
     * 
     * @param idInstruccion ID de Instruccion
     * 
     * @return Regresa un String[][] con el nombre de la instrucción.
     */
	public static String[][] getNombreInstruccion(String idInstruccion) {
		try {
			String strsql = SQLInst.getNombreInstruccion(idInstruccion);
			////System.out.println("getNombreInstruccion" + strsql);
			return ConexionDS.ejecutarSQL(strsql);
		} catch (SQLException sqle) {
			//System.out.println("getNombreInstruccion:" + sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}
	
	/**
     * Regresa un String con el nombre de la instruccion asociada al ID de Instruccion
     * 
     * @param idInstruccion ID de Instruccion
     * 
     * @return Regresa un String con el nombre de la instrucción.
     */
	public static String getNombreInstruccion1(String idInstruccion) {
            String result = null;
		try {
			String strsql = SQLInst.getNombreInstruccion(idInstruccion);
		//	//System.out.println("getNombreInstruccion:" + strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql);
                        result = strResult[0][0]==null?null:strResult[0][0];
		} catch (SQLException sqle) {
			//System.out.println("getNombreInstruccion:" + sqle.getMessage());
			sqle.printStackTrace();
			result = null;
		}
            return result;
	}
	
	/**
     * Verifica que no exista duplicidad en los nombres de las Instrucciones de cierta UA
     * 
     * @param strInstruccion Nombre de la instrucción
     * @param strAux Nombre anterior de la instrucción
     * @param strArea UA de la instruccion 
     * @param strAux2 UA anterior de la instrucción
     * 
     * @return Regresa un 1 si NO existe duplicidad, un 2 si SI existe duplicidad y un -1 si hubo un error
     */
	public static int getInstruccionExiste(String strInstruccion, String strAux, String strArea, String strAux2){
		try
		{
			String strSQL = SQLInst.getInstruccionExiste(strInstruccion.trim(), strAux.trim(), strArea.trim(), strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getInstruccionExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getInstruccionExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}

}

