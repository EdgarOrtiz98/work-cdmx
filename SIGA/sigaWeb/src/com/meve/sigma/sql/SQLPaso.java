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
 * 								actualizacion y lectura de la tabla PASO
 */

package com.meve.sigma.sql;

/**
 * SQLPaso es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_PASOS
 * @author Meve Soluciones SA de CV
 */
public class SQLPaso {

    /**
     * Datos del registro de un paso
     * @param strIdPaso	Id Paso
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getPaso(String strIdPaso)
	{
		String strSql="";		
		strSql=	"SELECT PAS_TIPO_DOCTO, PAS_SECUENCIA, PAS_DESCRIPCION," +
				" PAS_USR_ACTUALIZO, PAS_FEC_ACTUALIZACION, TIP_DOCTO_AREA, PAS_USR_ACTUALIZO, TO_CHAR(PAS_FEC_ACTUALIZACION, 'DD/MM/YYYY HH:MI:SS AM') " +
				" FROM SD_PASO, SD_TIPO_DOCUMENTO" +
				" WHERE ID_PASOS=" + strIdPaso+" " +
				" AND SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO=SD_PASO.PAS_TIPO_DOCTO";
				
		return strSql;
	}
    
    /**
     * Función que ejecuta un query para la inserción de un Paso
	* @param idTipoDocto String Contiene el ID del tipo de documento
	* @param secuencia 	 String Contiene la secuencia del paso 
	* @param descripcion String Describe la secuencia del paso
	* @param actualizo   String Contiene el ID del usuario que actualizo o registro el paso
	* @param fecha 		 String Contiene la fecha en la que se creo o actualizo el registro del paso
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getInsertaPaso(String idTipoDocto, String secuencia, String descripcion,
    									String actualizo, String fecha)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_PASO" +
        		" (ID_PASOS ,PAS_TIPO_DOCTO, PAS_SECUENCIA, PAS_DESCRIPCION," +
        		" PAS_USR_ACTUALIZO, PAS_FEC_ACTUALIZACION, PAS_ESTATUS)" +
        		" VALUES (SD_PASO_SEQ.NEXTVAL,"+idTipoDocto+", "+secuencia+", '"+descripcion+"', "+
				//" "+actualizo+", '"+fecha+"', 1)";
        		" "+actualizo+", SYSDATE, 1)";
        return sql;
    }
    
    /**
     * Lista de los pasos exisntents en el ctalogo
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getPasos()
	{
		String strSql="";
		strSql=	"SELECT ID_PASOS, TIP_DOCTO_NOMBRE, PAS_SECUENCIA, PAS_DESCRIPCION," +
				" PAS_USR_ACTUALIZO, PAS_FEC_ACTUALIZACION" +
				" FROM SD_PASO , SD_TIPO_DOCUMENTO" +
				" WHERE PAS_ESTATUS=1 AND SD_PASO.PAS_TIPO_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO" +
				" ORDER BY 3";												
		return strSql;	
	}
    
    /**
     * Lista de pasos para la vista del catalogo
     * @param strIdTipoDocto	Id tipo de docto.
     * @param strOrden		Orden de las columnas
     * @param tipo			Tipo de orden de las columnas(asc o desc)
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getPasos(String strIdTipoDocto, String strOrden, String tipo)
	{
		String strSql="";
		strSql=	"SELECT ID_PASOS, TIP_DOCTO_NOMBRE, PAS_SECUENCIA, PAS_DESCRIPCION,";
		strSql+=" PAS_USR_ACTUALIZO, PAS_FEC_ACTUALIZACION";
		strSql+=" FROM SD_PASO , SD_TIPO_DOCUMENTO";
		strSql+=" WHERE PAS_TIPO_DOCTO="+strIdTipoDocto+" ";
		strSql+=" AND PAS_ESTATUS=1 AND SD_PASO.PAS_TIPO_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 4 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 4 ASC ";
		}else{
			strSql+="ORDER BY 4 "+strOrden+", 4 ASC ";
		}
		return strSql;	
	}

	/**
	 * Actualiza el registro de un paso
     * @param idPaso	id paso
     * @param idTipoDocto String Contiene el ID del tipo de documento
     * @param secuencia 	 String Contiene la secuencia del paso 
     * @param descripcion String Describe la secuencia del paso
     * @param actualizo   String Contiene el ID del usuario que actualizo o registro el paso
     * @param fecha 		 String Contiene la fecha en la que se creo o actualizo el registro del paso
	 * @return	Regresa un String con el Query correspondiente
	 */
    public static String getActualizarPaso(	String idPaso, String idTipoDocto, String secuencia,
    										String descripcion, String actualizo, String fecha)
    {
    	String strSql="";
    	strSql=	"UPDATE SD_PASO SET " +
		"PAS_TIPO_DOCTO="+idTipoDocto+", PAS_SECUENCIA="+secuencia+", PAS_DESCRIPCION='" + descripcion +"', "+
    	//"PAS_USR_ACTUALIZO="+actualizo+", PAS_FEC_ACTUALIZACION='"+fecha+"' " +
		"PAS_USR_ACTUALIZO="+actualizo+", " +
		//"PAS_FEC_ACTUALIZACION=TO_DATE('"+fecha+"','DD/MM/YYYY') " +
		"PAS_FEC_ACTUALIZACION=SYSDATE " +
		"WHERE ID_PASOS="+idPaso;
    	return strSql;
    }
    
    /**
     * Elimina los pasos del catalogo
     * @param strIds	Id paso a eliminar
     * @return	Regresa un String con el Query correspondiente
     */
	public static String getDeletePaso(String strIds)
	{
		String strSql="";  
		strSql=	" UPDATE SD_PASO SET"	+
		" PAS_ESTATUS=0, PAS_FEC_ACTUALIZACION=SYSDATE WHERE ID_PASOS IN ("+strIds+")";				
		return strSql;    	
	}
	
	/**
	 * Verifica si existe un paso
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getExiste()
	{
	    String sql = "";
	    sql = "SELECT * FROM SD_PASO WHERE PAS_ESTATUS=1";
	    return sql;
	}
	
	/**
	 * Lista de los tipos de documentos que tienen pasos asignados
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getTipoDoctos(String strOrden)
	{
	    String sql = "";
	    sql = "SELECT DISTINCT PAS_TIPO_DOCTO, TIP_DOCTO_NOMBRE, ARE_NOMBRE, TIP_DOCTO_AREA " +
	    		"FROM SD_PASO, SD_TIPO_DOCUMENTO, SD_AREA " +
	    		"WHERE PAS_ESTATUS=1 " +
	    		"AND SD_PASO.PAS_TIPO_DOCTO=SD_TIPO_DOCUMENTO.ID_TIPO_DOCTO " +
	    		"AND SD_AREA.ID_AREA=SD_TIPO_DOCUMENTO.TIP_DOCTO_AREA " +
	    		"ORDER BY ARE_NOMBRE "+strOrden+ "";
	    return sql;
	}
	
	/**
     * Secuencia máxima de un tiop de documento
	 * @param IdDocto	Tipo de Docto.
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getSec(String IdDocto)
	{
		String strSql="";		
		strSql=	"SELECT MAX(PAS_SECUENCIA) FROM SD_PASO WHERE PAS_TIPO_DOCTO = " + IdDocto+"";
				
		return strSql;
	}
    
    /**
     * Secuencia mínima de un tiop de documento
	 * @param IdDocto	Tipo de Docto.
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getSecMin(String IdDocto)
	{
		String strSql="";		
		//strSql=	"select min(pas_secuencia) FROM SD_PASO where pas_tipo_docto = " + IdDocto+"";
		strSql = "SELECT ID_PASOS, PAS_SECUENCIA FROM SD_PASO WHERE PAS_TIPO_DOCTO="+IdDocto+" AND PAS_ESTATUS=1 ORDER BY 2 ASC";
				
		return strSql;
	}
    
    /**
     * Verifica si el paso ya existe en el registro del catalogo
	 * @param strSecuencia	Secuencia
	 * @param strAux		Auxiliar
	 * @param strTipoDoc	Tipo de docto.
	 * @param strAux2		Auxiliar2
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getPasoExiste(String strSecuencia, String strAux, String strTipoDoc, String strAux2)
	{
    	String strSql = "SELECT * FROM SD_PASO " +
    			"WHERE PAS_SECUENCIA="+strSecuencia+" " +
    			"AND PAS_TIPO_DOCTO="+strTipoDoc+" AND PAS_ESTATUS=1";
			
		return strSql;
	}
    
	
	
}
