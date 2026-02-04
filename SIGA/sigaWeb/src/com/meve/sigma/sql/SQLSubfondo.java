/*
 * Clase:						SQLSubfondo.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Dec 7, 2005
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
 * Clase para generar codigo SQL para SubFondos
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLSubfondo {
    
    /**
     * Función que regresa un query donde se inserta datos a la
     * tabla de SD_SUBFONDO
     * @param codigo Codigo de subfondo
     * @param seccion Seccion del subfondo
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @return Regresa un String con el Query correspondiente
     */
    public static String insertarSubfondo(	String codigo, String seccion,
            								String fecha, String Usr)
    {
        String sql = "";
        sql = "INSERT INTO SD_SUBFONDO (ID_SUBFONDO, SUB_CODIGO, SUB_SECCION, SUB_FECHA_CREACION, " +
        		"SUB_USR_ACTUALIZO, SUB_ESTATUS) VALUES (SD_SUBFONDO_SEQ.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		"SYSDATE, "+Usr+", 1)";
        return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar los registros ordenados de SubFondos
     * @param strOrden Campo por el cual se hace el ordenamiento 
     * @param tipo Ordenamiento ascendente o descendente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosSubFondo(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT ID_SUBFONDO, SUB_CODIGO, SUB_SECCION ";
        strSql+="FROM SD_SUBFONDO WHERE SUB_ESTATUS=1";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC  ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC  ";
		}
        return strSql;
    }
    
    /**
     * Función que regresa un query con los datos de un subfondo 
     * por medio de si id
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @return Regresa un String con el Query correspondiente
     */
    public static String getSubfondo(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT SUB_CODIGO, SUB_SECCION, to_char(SUB_FECHA_CREACION, 'dd/MM/yyyy'), SUB_USR_ACTUALIZO " +
        		"FROM SD_SUBFONDO WHERE ID_SUBFONDO="+strIdSubfondo;
        return sql;
    }
    
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExisteSub()
    {
        String sql = "SELECT * FROM SD_SUBFONDO";
        return sql;
    }
    
    /**
     * Construye un SQL Query para hacer un borrado logico
     * @param strIds Contiene los id de los subfondos a borrar
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDeleteSub(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);				
		strSql=	" UPDATE SD_SUBFONDO SET"	+
				" SUB_ESTATUS=0 WHERE ID_SUBFONDO IN ("+ids+")";				
		return strSql;
    }
    
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de SD_SUBFONDO 
     * @param codigo codigo del subfondo
     * @param seccion Sección del subfondo
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo Id del registro
     * @return Regresa un String con el Query correspondiente
     */
    public static String actualizaSubfondo(String codigo, String seccion,
									String fecha, String Usr, String IdSubfondo)
    {
        String sql = "";
        sql = "UPDATE SD_SUBFONDO SET SUB_CODIGO='"+codigo+"', SUB_SECCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"SUB_FECHA_CREACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), SUB_USR_ACTUALIZO="+Usr+" " +
        		"WHERE ID_SUBFONDO="+IdSubfondo;
        return sql;
    }
    
    /**
     * Función que regresa un query, para contruir un combo
     * @return Query
     */
    public static String getSubfondoCombo()
    {
        String sql = "";
        sql = "SELECT ID_SUBFONDO, SUB_CODIGO || ' - ' || SUB_SECCION " +
        		"FROM SD_SUBFONDO WHERE SUB_ESTATUS=1";
        return sql;
    }
    
    /**
     * Construye un SQL Query para hacer un borrado logico
     * @param strIds Contiene los id de los subfondos a borrar
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDeleteSubA(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);				
		strSql=	" UPDATE SD_SUBFONDOARCH SET"	+
				" SUBF_ESTATUS=0 WHERE SUBF_STATUS IN ("+ids+")";				
		return strSql;
    }

}

