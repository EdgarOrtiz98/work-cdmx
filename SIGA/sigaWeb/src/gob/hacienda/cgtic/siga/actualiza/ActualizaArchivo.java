
package gob.hacienda.cgtic.siga.actualiza;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import java.rmi.RemoteException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.StringTokenizer;
import java.util.Vector;

import oracle.ifs.fdk.FdkException;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLArchivo;

import java.io.FileWriter;
import java.io.PrintWriter;

public class ActualizaArchivo {

    /**
     * Verifica si existen archivos con referencai a instrucciones
     * @param strIdAsunto
     * @return true si existe
     */
    public static boolean getExisteArchivoReferenciaInstruccion(String strIdAsunto,String strInstruccion) {
        try {
            String strsql = 
            "SELECT ID_INSTRUCCION_ASUNTO "+
            "FROM SD_INSTRUCCION_ASUNTO "+
            "WHERE ID_ASUNTO="+strIdAsunto+" AND ID_INSTRUCCION_ASUNTO>="+strInstruccion;
            String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return true;
            return false;
        } catch (SQLException sqle) {
            //System.out.println("getExisteArchivoReferenciaInstruccion:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
    }

     /**
      * Referencia de archivos de content oracle
      * @param strIdAsunto       id asunto
      * @return  regresa arreglo de las referencias
      */
     public static String[][] getArchivosReferenciaContent(String strIdAsunto, 
                                                           String strIdUsuario, 
                                                           String strInstruccion) {
         String strSql = "";
         String strAsunto = "-1";
         if (strIdAsunto.length() > 0 && strInstruccion.length() == 0) {
             try {
                 strSql = "SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " + 
                          "FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DP' AND ID_ASUNTO_CONTENT= " + strIdAsunto;
                 //              Verificacion de sentencia para la consulta de documentos que son de otras ventanillas//                                
                 return ConexionDS.ejecutarSQL(strSql);
             } catch (SQLException sqle) {
             
             //En caso de que se produzca un error, creamos otro log de errores//
             
                 //System.out.println("getArchivosReferenciaContent:" + sqle);
                 sqle.printStackTrace();
                 return null;
             }
         }

         if (strInstruccion.length() > 0) {

             try {
                 strSql = 
                         "SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " +
                         "FROM SD_CONTENT_ORACLE " +
                         "WHERE TIPO_DOCUMENTO  = 'DP' AND ID_ASUNTO_CONTENT ="+strIdAsunto+" AND (ID_INS_CONTENT="+strInstruccion+" OR ID_INS_CONTENT=-1)";

                 //              Verificacion de sentencia para la consulta de documentos que son de otras ventanillas//                                

                 return ConexionDS.ejecutarSQL(strSql);
             } catch (SQLException sqle) {
             
                 //En caso de que se produzca un error, creamos otro log de errores//
                 
                 //System.out.println("getArchivosReferenciaContent:" + sqle);
                 sqle.printStackTrace();
                 return null;
             }
         }
         return null;
     }
}
