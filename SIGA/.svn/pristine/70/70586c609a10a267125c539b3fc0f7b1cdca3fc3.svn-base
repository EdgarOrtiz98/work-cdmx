
package com.meve.sigma.sql;

/**
 * SQLArchivo es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_ARCHIVO
 * 
 * @author Meve Soluciones SA de CV
 *
 */
    public class SQLDocs {
    
    /**
	 * Función que realiza la conexión a la base de datos de oracle, con los datos parametrizados.
	 * @return	boolean	    Regresa un valor booleano. Regresa un valor de true en caso de que
	 * 							la conexion se realizó exitosamente, y false en caso de que no se
	 * 							pueda realizar la conexión.
	 */	
    public static String insArchivo(String str_idReferencia,String str_idAsuntoContext,String pstr_nombreARchivo,String pstr_nombreFolder){
            String strSql="INSERT INTO FILES_IN (ID_REFERENCIA, ID_ASUNTO_CONTENT, NOMBRE_ARCHIVO, NOMBRE_FOLDER, ARCHIVO) VALUES " +
            "( '"+str_idReferencia+"','"+str_idAsuntoContext+"' ,'"+pstr_nombreARchivo+"' ,'"+pstr_nombreFolder+"' ,? )";
            return strSql;
    }

    public static String delArchivo(String str_idFolio,String pstr_nombreARchivo){
            String strSql="DELETE FROM FILES_IN \n" +
            "WHERE NOMBRE_FOLDER = '" +str_idFolio + "'\n" +
            "AND NOMBRE_ARCHIVO = '"+pstr_nombreARchivo+"'";
            return strSql;
    }

    public static String getArchivoBinario(String pstr_nombreFolder,String pstr_nombreArchivo)
        {
            
            String strSql= "SELECT ARCHIVO\n" + 
                            "FROM FILES_IN\n" + 
                            "WHERE (NOMBRE_FOLDER = '"+pstr_nombreFolder+"' OR NOMBRE_FOLDER = 'folio por asignar')\n" + 
                            "AND NOMBRE_ARCHIVO = '"+pstr_nombreArchivo+"'";
            return strSql;
        }
    
    public static String setFolio(String pstr_nombreARchivo,String str_idAsuntoContext, String pstr_nombreFolder)
    {
        
        String strSql= "UPDATE FILES_IN SET NOMBRE_FOLDER = '" + pstr_nombreFolder +"' \n"+
                        
                        "WHERE ID_ASUNTO_CONTENT = '"+str_idAsuntoContext+"' AND NOMBRE_FOLDER = 'folio por asignar' \n" ; 
                        
        return strSql;
    }
}

