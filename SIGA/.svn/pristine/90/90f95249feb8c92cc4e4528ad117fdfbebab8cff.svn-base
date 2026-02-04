/*
 * Clase:						SQLInst.java
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

/**
 * Clase para generar codigo SQL Query para las Instrucciones del Catalogo
 *
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLInst {
    
	
	/**
     * Costruye un SQL Query para regresar un arreglo con el ID y el nombre de la Instruccion
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getInstruccionCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_INSTRUCCION, INS_NOMBRE" +
				" FROM SD_INSTRUCCION" +
				" ORDER BY INS_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Costruye un SQL Query para regresar un arreglo con los campos de las instrucciones asociadas a un ID de Instruccion
     * 
     * @param DN ID de Instruccion
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getInstrucciones(String DN)
	{
		String strSql="";		
		strSql=	"SELECT INS_AREA, INS_NOMBRE, INS_USR_ACTUALIZO, " +
				" TO_CHAR(INS_FEC_ACTUALIZACION, 'DD/MM/YYYY HH:MI:SS AM'), INS_ESTATUS1 " +
				" FROM SD_INSTRUCCION" +
				" WHERE ID_INSTRUCCION=" + DN;
		return strSql;
	}
    
    /**
     * Costruye un SQL Query para regresar un arreglo con los campos de las instrucciones ordenadas por Orden y Tipo
     * 
     * @param strOrden El Campo por el que va a ordenar
     * @param tipo tipo ascendente o descendente 
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getInstrucciones(String strOrden, String tipo)
	{
		String strSql="";
		strSql=	"SELECT ID_INSTRUCCION, INS_NOMBRE, ARE_NOMBRE,";
		strSql+=" INS_FEC_ACTUALIZACION, INS_USR_ACTUALIZO, INS_ESTATUS1, INS_AREA";
		strSql+=" FROM SD_INSTRUCCION , SD_AREA";
		strSql+=" WHERE INS_ESTATUS1=1 AND";
		strSql+=" SD_INSTRUCCION.INS_AREA= SD_AREA.ID_AREA ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}											
		return strSql;	
	}

	/**
	 * Costruye un SQL Query para insertar una Instruccion al catalogo
	 * 
	 * @param area UA al que pertenece la instrucción
	 * @param nombre Nombre de la instrucción
	 * @param actualizo ID del Usuario que insertó la instrucción
	 * @param fecha Fecha de la inserción
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */
	
    public static String getInsertaInstruccion(String area, String nombre, 
			String actualizo, String fecha)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_INSTRUCCION" +
        		" (ID_INSTRUCCION ,INS_AREA, INS_NOMBRE," +
				" INS_USR_ACTUALIZO, INS_FEC_ACTUALIZACION, INS_ESTATUS1)" +
        		" VALUES (SD_INSTRUCCION_SEQ.NEXTVAL,"+area+", '"+nombre+"', "+
        		//" "+actualizo+", '"+fecha+"', 1)";
        		" "+actualizo+", SYSDATE, 1)";
        return sql;
    }
    
	/**
	 * Costruye un SQL Query para actualizar una Instruccion en el catalogo
	 * 
	 * @param idInstruccion ID de la instrucción
	 * @param idArea UA al que pertenece la instrucción
	 * @param nombre Nombre de la instrucción
	 * @param actualizo ID del Usuario que insertó la instrucción
	 * @param fecha Fecha de la inserción
	 * 
	 * @return Regresa un String con el Query correspondiente
	 */

    public static String getActualizarInstruccion(String idInstruccion, String idArea, String nombre, 
			String actualizo, String fecha)
    {
    	String strSql="";
    	strSql=	"UPDATE SD_INSTRUCCION SET" +
		" INS_AREA="+idArea+", INS_NOMBRE='"+nombre+ "', " +
		//" INS_USR_ACTUALIZO="+actualizo+", INS_FEC_ACTUALIZACION='"+fecha+"'" +
		" INS_USR_ACTUALIZO="+actualizo+", " +
		//"INS_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY') " +
		"INS_FEC_ACTUALIZACION=SYSDATE " +
		" WHERE ID_INSTRUCCION="+idInstruccion;
    	return strSql;
    }

	/**
	 * Costruye un SQL Query para borrar las Instrucciones asiciadas a un ID
	 * 
	 * @param strIds ID de la instrucción que se quiere borrar
 	 * 
 	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getDeleteInstruccion(String strIds)
	{
		String strSql="";  
		strSql=	" UPDATE SD_INSTRUCCION SET"	+
		" INS_ESTATUS1=0, INS_FEC_ACTUALIZACION=SYSDATE WHERE ID_INSTRUCCION IN ("+strIds+")";				
		return strSql;    	
	}
	
	/**
     * Costruye un SQL Query para regresar un arreglo con el nombre de la instruccion asociada al ID de Instruccion
     * 
     * @param idInstruccion ID de Instruccion
     * 
     * @return Regresa un String con el Query correspondiente
     */
	public static String getNombreInstruccion(String idInstruccion)
	{
	    String sql = "";
	    sql = "SELECT INS_NOMBRE FROM SD_INSTRUCCION " +
	    		"WHERE ID_INSTRUCCION="+idInstruccion;
           // //System.out.println("getNombreInstruccion(...): "+sql);
	    return sql;
	}
	
	/**
     * Costruye un SQL Query para verificar que no exista duplicidad en los nombres de las Instrucciones de cierta UA
     * 
     * @param strInstruccion Nombre de la instrucción
     * @param strAux Nombre anterior de la instrucción
     * @param strArea UA de la instruccion 
     * @param strAux2 UA anterior de la instrucción
     * 
     * @return Regresa un String con el Query correspondiente
     */
	public static String getInstruccionExiste(String strInstruccion, String strAux, String strArea, String strAux2){
    	String sql = "SELECT INS_NOMBRE FROM SD_INSTRUCCION " +
    			"WHERE NOT(LOWER(INS_NOMBRE) = LOWER('"+strAux+"') " +
				"AND LOWER(INS_AREA) = LOWER('"+strAux2+"')) " +
    			"AND LOWER(INS_NOMBRE) = LOWER('"+strInstruccion+"') " +
    			"AND LOWER(INS_AREA) = LOWER('"+strArea+"') " +
    			"AND INS_ESTATUS1 = 1";
    	return sql;
    }  
    

}

