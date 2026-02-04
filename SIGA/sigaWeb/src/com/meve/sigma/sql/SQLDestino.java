/*
 * Clase:						SQLDestino.java
 * 
 * Paquete:						com.meve.sigma.sql		
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

package com.meve.sigma.sql;

/**
 * SQLDestino es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_DESTINATARIOS
 * @author Administrator
 *
 */
public class SQLDestino {

	/**
	 * Función que ejecuta un query, donde devuelve el id del Destino
	 * @param strIdArea	Usuarios por área
	 * @param strOrden				Orden de las columnas
	 * @param tipo					Tipo de Orden
	 * @return	Regresa un String con el Query correspondiente un arreglo con los destinatarios del área
	 */
    public static String getDestinoPorArea(String strIdArea, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	"SELECT ID_USUARIO, DES_NOMBRE, DES_DESCRIPCION, DES_AREA, DES_CORREO";
		strSql+=" FROM SD_DESTINATARIO , SD_AREA";
		strSql+=" WHERE SD_DESTINATARIO.DES_AREA=SD_AREA.ID_AREA";
		strSql+=" AND  DES_AREA="+strIdArea+" AND DES_ESTATUS=1 ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}
	
    /**
     * Elimina los registros de los destinatarios
     * @param strIds	Ids de los destinatarios a eliminar
     * @return	Regresa un String con el Query correspondiente
     */
	public static String getDeleteDestino(String strIds)
	{
		String strSql="UPDATE SD_DESTINATARIO SET DES_ESTATUS=0 WHERE ID_USUARIO ="+strIds+" ";
		////System.out.println("Borrando destino: " + strSql); 
		return strSql;    	
	}
	
	/**
	* Inserta registro del destinatario
	 * @param nombre	Nombre destinatario
	 * @param idArea	Id área que pertenece
	 * @param desc		Descripción
	 * @param correo	Mail
	 * @param telefono	Teléfono
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getInsertaDestino(String nombre, String idArea, String desc, String correo,String telefono)
	{
		String sql = "";
		sql = 	"Insert into SD_DESTINATARIO (ID_USUARIO, DES_DESCRIPCION, DES_NOMBRE, DES_CORREO, DES_TELEFONO, DES_AREA, DES_FEC_ACTUALIZACION, DES_ESTATUS)" +
		" VALUES (destino_seq.nextval,'"+desc+"', '"+nombre +"', '"+correo+"', '"+telefono+"',"+idArea+", SYSDATE, 1)";
		return sql;
	}
	
	/**
	 * Datos del destinatario
	 * @param DN	id destinatario
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getDestino(String DN)
	{
		String strSql="";		
		strSql=	"SELECT * FROM SD_DESTINATARIO " +
				" WHERE ID_USUARIO="+DN;
		return strSql;
	}

	/**
	 * 
	* @param idUsuario	Id destinatario
	 * @param nombre	Nombre destinatario
	 * @param idArea	Id área
	 * @param desc		Descripción
	 * @param correo	mail
	 * @param telefono	Teléfono
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getActualizarDestino(String idUsuario, String nombre, String idArea, String desc, String correo,
			String telefono)
    {
    	String strSql="";
    	strSql=	"UPDATE SD_DESTINATARIO SET " +		
		"DES_NOMBRE='"+nombre+"', DES_AREA="+idArea+", DES_DESCRIPCION='" + desc +"', "+
		"DES_CORREO='"+correo+ "', DES_TELEFONO='"+telefono+ "' WHERE ID_USUARIO="+idUsuario;
    	return strSql;
    }
	
	/**
	 * 
	 * Verifica si el destinatario existe
	 * @param strNombre	Nombre destinatario
	 * @param strAux	Auxiliar
	 * @param strArea	área
	 * @param strAux2	Auxiliar 2
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getDestinatarioExiste(String strNombre, String strAux, String strArea, String strAux2)
    {   
		String strSql=	"SELECT DES_NOMBRE FROM SD_DESTINATARIO WHERE " +
		"NOT (LOWER(DES_NOMBRE)	= LOWER('" + strAux + "') " +
		"AND  LOWER(DES_AREA) 	= LOWER('" + strAux2 + "')) " +
		"AND  LOWER(DES_NOMBRE)	= LOWER('" + strNombre + "') " +
		"AND  LOWER(DES_AREA) 	= LOWER('" + strArea + "') " +
		"AND  DES_ESTATUS = 1";
    
		return strSql;
    }   
	
}

