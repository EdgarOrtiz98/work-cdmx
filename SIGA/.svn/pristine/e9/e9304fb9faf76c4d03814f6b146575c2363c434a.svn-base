/*
 * Clase:						SQLEstatus.java
 * 
 * Paquete:						com.meve.sigma.sql		
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

package com.meve.sigma.sql;

/**
 * SQLEntidad es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_ENTIDAD
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLEstatus {
    
	/**
	 * Lista de estatus para combo
	 * @return	Regresa un String con el Query correspondiente
	 */
    public static String getEstatusCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_ESTATUS, EST_NOMBRE" +
				" FROM SD_ESTATUS_CIUDADANO WHERE EST_ESTATUS=1 " +
				" ORDER BY 2";												
		return strSql;	
	}
    
    /**
     * Datos del estatus
	 * @param stridEstatus	Ids estatus
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEstatus(String stridEstatus)
	{
		String strSql="";		
		strSql=	"SELECT EST_NOMBRE, EST_FIN, to_char(EST_FECHA, 'dd/MONTH/yyyy'), EST_USR " +
				" FROM SD_ESTATUS_CIUDADANO " +
				" WHERE ID_ESTATUS="+stridEstatus;
		return strSql;
	}
    
    /**
     * Datos del estatus
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getEstatus()
	{
		String strSql="";
		strSql=	"SELECT ID_ESTATUS, EST_NOMBRE, EST_FIN," +
				" to_char(EST_FECHA, 'dd/MONTH/yyyy'), EST_USR, EST_ESTATUS " +
				" FROM SD_ESTATUS_CIUDADANO " +
				" WHERE EST_ESTATUS=1 " +
				" ORDER BY 2";												
		return strSql;	
	}

    /**
     * inserta registro de un estatus
	 * @param nombre	Nombre estatus
	 * @param esFin		fin del estatus
	 * @param actualizo	usuario que actualizá
	 * @param fecha		fecha de Actualización
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getInsertaEstatus(String nombre, String esFin,
											String actualizo, String fecha)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_ESTATUS_CIUDADANO" +
        		" (ID_ESTATUS, EST_NOMBRE, EST_FIN, EST_FECHA," +
				" EST_ESTATUS, EST_USR)" +
        		//" VALUES (SD_ESTATUS_CIUDADANO_SEQ.NEXTVAL, '"+nombre+"', "+esFin+", '"+fecha+"', "+
				" VALUES (SD_ESTATUS_CIUDADANO_SEQ.NEXTVAL, '"+nombre+"', "+esFin+", SYSDATE, "+
        		" 1, "+actualizo+")";
        return sql;
    }
    
    /**
     * actualza registro de un estatus
     * @param idEstatus	Id Estatus
	 * @param nombre	Nombre estatus
	 * @param esFin		fin del estatus
	 * @param actualizo	usuario que actualizá
	 * @param fecha		fecha de Actualización
     * @return	Regresa un String con el Query correspondiente
     */
	public static String getActualizarEstatus(String idEstatus, String nombre, String esFin,
													String actualizo, String fecha)
    {
    	String strSql="";
    	strSql=	"UPDATE SD_ESTATUS_CIUDADANO SET" +
		" EST_NOMBRE='"+nombre+"', EST_USR="+actualizo+", " +
		//" EST_FECHA='"+fecha+"', EST_FIN="+esFin+" " +
		" EST_FECHA=TO_DATE('"+fecha+"','DD/MM/YYYY'), EST_FIN="+esFin+" " +
		" WHERE ID_ESTATUS="+idEstatus;
    	return strSql;
    }

	/**
	 * Elimina los estatus
	 * @param strIds	Id de los estatus ha eliminar
	 * @return	Regresa un String con el Query correspondiente
	 */
    public static String getDeleteEstatus(String strIds[])
	{
		String strSql="";  
		String ids="";  
		for(int i=0; i<strIds.length;i++) 
			ids+=strIds[i]+","; 
		ids=ids.substring(0,ids.length()-1);
		strSql=	" UPDATE SD_ESTATUS_CIUDADANO SET"	+
		" EST_ESTATUS=0 WHERE ID_ESTATUS IN ("+ids + ")";				
		return strSql;    	
	}
	
	/**
	 * Nombre del estatus
	 * @param idEstatus	id estatus
	 * @return	Regresa un String con el Query correspondiente
	 */
    public static String getNombreEstatus(String idEstatus)
	{
	    String sql = "";
	    sql = "SELECT EST_NOMBRE FROM SD_ESTATUS_CIUDADANO " +
	    		"WHERE ID_ESTATUS="+idEstatus;
	    return sql;
	}
	
	/**
	 * * Verifica si existe el estatus
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String existenEstatus(){
	    String sql = "SELECT * FROM SD_ESTATUS_CIUDADANO";
	    return sql;
	}
	
	/**
	 * Ciera el estatus
	 * @param strIdEstatus	id estatus
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getCierre(String strIdEstatus){
	    String sql = "SELECT COUNT(*) FROM SD_ESTATUS_CIUDADANO WHERE EST_FIN=1 AND ID_ESTATUS="+strIdEstatus;
	    return sql;
	}

    

}

