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
 * Descripción de la clase:		Clase que contiene metodos que construyen sentencias sql para la 
 * 								actualizacion y lectura de la tabla RAZON_RECHAZO
 */

package com.meve.sigma.sql;

/**
 * SQLRazonRechazo es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_RAZON_RECHAZO
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLRazonRechazo {
    
    /**
     * Datos de una Razón de rechazo
	 * @param DN	id Razón de rechazo
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getRazonRechazo(String DN)
	{
		String strSql="";		
		strSql=	"SELECT RAZ_RECH_AREA, RAZ_RECH_DESCRIPCION," +
				" RAZ_RECH_USR_ACTUALIZO, to_char(RAZ_RECH_FEC_ACTUALIZACION, 'dd/MM/yyyy HH:MI:SS AM')" +
				" FROM SD_RAZON_RECHAZO" +
				" WHERE ID_RAZON_RECH=" + DN;
		return strSql;
	}
    
    /**
     Inserta el registro de una Razón de rechazo
	 * @param IdArea	Id área
	 * @param descripcion	Descripción de la Razón de rechazo	
	 * @param actualizo		usuario que actualizá
	 * @param fecha			fecha de Actualización
	 * @param estatus		Estatus
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getInsertaRazonRechazo(String IdArea, String descripcion,
    									String actualizo, String fecha, String estatus)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_RAZON_RECHAZO" +
        		" (ID_RAZON_RECH, RAZ_RECH_AREA, RAZ_RECH_DESCRIPCION," +
				" RAZ_RECH_USR_ACTUALIZO, RAZ_RECH_FEC_ACTUALIZACION, RAZ_RECH_ESTATUS)" +
        		" VALUES (SD_RAZON_RECHAZO_SEQ.NEXTVAL,"+IdArea+", '"+descripcion+"',"+
				//" "+actualizo+", '"+fecha+"', "+estatus+")";
        		" "+actualizo+", SYSDATE, "+estatus+")";
        return sql;
    }
    
    /**
     * Lista de las razones de rechazo
	 * @param strOrden	Orden de columnas
	 * @param tipo		Tipo de orden de columnas(asc o desc)
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getRazonRechazos(String strOrden, String tipo)
	{
		String strSql="";
		strSql=	"SELECT ID_RAZON_RECH, ARE_NOMBRE, RAZ_RECH_DESCRIPCION,";
		strSql+=" RAZ_RECH_USR_ACTUALIZO, RAZ_RECH_FEC_ACTUALIZACION, RAZ_RECH_AREA";
		strSql+=" FROM SD_RAZON_RECHAZO , SD_AREA";
		strSql+=" WHERE RAZ_RECH_ESTATUS=1 AND SD_RAZON_RECHAZO.RAZ_RECH_AREA= SD_AREA.ID_AREA ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 3 "+strOrden+", 3 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 2 "+strOrden+", 3 ASC ";
		}												
		return strSql;	
	}

	/**
	 * Actualiza el registro de un Razón de rechazo
	 * @param IdRazon	id Razón de rechazo
	 * @param IdArea	Id área
	 * @param descripcion	Descripción de la Razón de rechazo	
	 * @param actualizo		usuario que actualizá
	 * @param fecha			fecha de Actualización
	 * @return	Regresa un String con el Query correspondiente
	 */
    public static String getActualizarRazonRechazo(	String IdRazon, String IdArea, String descripcion, 
    										String actualizo, String fecha)
    {
    	String strSql="";
    	strSql=	"UPDATE SD_RAZON_RECHAZO SET " +
		"RAZ_RECH_AREA="+IdArea+", RAZ_RECH_DESCRIPCION='" + descripcion +"', "+
		//"RAZ_RECH_USR_ACTUALIZO="+actualizo+", RAZ_RECH_FEC_ACTUALIZACION='"+fecha+"' " +
		"RAZ_RECH_USR_ACTUALIZO="+actualizo+", " +
		//"RAZ_RECH_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY') " +
		"RAZ_RECH_FEC_ACTUALIZACION=SYSDATE " +
		"WHERE ID_RAZON_RECH="+IdRazon;
    	return strSql;
    }
    
    /**
     * Elimina las razones de rechazo
	     * @param strIds	Id de las razones de rechazo
     * @return	Regresa un String con el Query correspondiente
     */
	public static String getDeleteRazonRechazo(String strIds)
	{
		String strSql="";  
		strSql=	" UPDATE SD_RAZON_RECHAZO SET"	+
		" RAZ_RECH_ESTATUS=0, RAZ_RECH_FEC_ACTUALIZACION=SYSDATE WHERE ID_RAZON_RECH IN ("+strIds+")";				
		return strSql;    	
	}
	
	/**
	 * Función que regresa un query, donde trae una lista de las razones de rechazo 
	 * de un área a la que pertenece un usuario
	 * @param strIdArea String Contiene el ID del área a la que pertenece un usuario
	 * @return strSql
	 */
	public static String getRazones(String strIdArea)
	{
		String strSql="";
		strSql=	"SELECT ID_RAZON_RECH, RAZ_RECH_DESCRIPCION FROM SD_RAZON_RECHAZO " +
				"WHERE RAZ_RECH_AREA="+strIdArea;												
		return strSql;	
	}
	
	/**
	 * Razones de rechazo generales
	 * @param strIdArea	Id área
	 * @param strIdAreaGeneral	general
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getRazonesYGeneral(String strIdArea,String strIdAreaGeneral){
		String strSql = "";
		strSql ="select ID_RAZON_RECH, RAZ_RECH_DESCRIPCION " + 
				"FROM SD_RAZON_RECHAZO " + 
				"WHERE RAZ_RECH_ESTATUS = 1 AND (RAZ_RECH_AREA="+strIdArea+" or RAZ_RECH_AREA="+ strIdAreaGeneral+") ";
		return strSql;
	}
	
	/**
	 * Verifica si existe un registro en el catalogo de las razones rechazadas
	 * @param strNombre	Razón de rechazo
	 * @param strAux	Auxiliar
	 * @param strArea	área
	 * @param strAux2	Auxiliar2
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getRazonExiste(String strNombre, String strAux, String strArea, String strAux2)
    {   
		String strSql=	"SELECT RAZ_RECH_DESCRIPCION FROM SD_RAZON_RECHAZO WHERE " +
		"NOT (LOWER(RAZ_RECH_DESCRIPCION)	= LOWER('" + strAux + "') " +
		"AND  LOWER(RAZ_RECH_AREA) 	= LOWER('" + strAux2 + "')) " +
		"AND  LOWER(RAZ_RECH_DESCRIPCION)	= LOWER('" + strNombre + "') " +
		"AND  LOWER(RAZ_RECH_AREA) 	= LOWER('" + strArea + "') " +
		"AND  RAZ_RECH_ESTATUS = 1";
    
		return strSql;
    }  
}