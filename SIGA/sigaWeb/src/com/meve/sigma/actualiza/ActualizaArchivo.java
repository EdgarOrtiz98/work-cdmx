/*
 * Clase:						ActualizaArchivo.java
 *
 * Paquete:						com.meve.sigma.actualiza		
 *
 * Versión						1.0
 *
 * Fecha Creación:				Mar 10, 2006
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

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.rmi.RemoteException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.StringTokenizer;
import java.util.Vector;

import oracle.ifs.fdk.FdkException;
import oracle.jdbc.OracleConnection;
import oracle.sql.BLOB;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.db2.ConnectionPool;
import com.meve.sigma.sql.SQLArchivo;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 	ActualizaArchivo es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Archivos
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaArchivo {

	
	/***********************************************************    BLOB   ***************************************************/
    /**
     * Datos de un archivo
     * @param strIdAsunto	Id asunto
     * @return	regresa arreglo con el id y nombre del archivo
     */
    public static String[][] getArchivos(String strIdAsunto,String strInstruccion){
    	String strSql = "";
        try {
            strSql = SQLArchivo.getArchivos(strIdAsunto,strInstruccion);
                                               
            return ConnectionPool.ejecutarSQL(strSql);
        } catch (SQLException sqle) {            
            sqle.printStackTrace();
            return null;
        }
    }
    
    public static String[][] getArchivosDocS(String strIdAsunto,String strInstruccion){
    	String strSql = "";
        try {
            strSql = SQLArchivo.getArchivosDocS(strIdAsunto,strInstruccion);
                                               
            return ConnectionPool.ejecutarSQL(strSql);
        } catch (SQLException sqle) {            
            sqle.printStackTrace();
            return null;
        }
    }    

    /**
     * Verifica si existe el archivo en la base de datos por id de asunto
     * @param strIdAsunto	Id asunto
     * @return	true si existe
     */
    public static boolean getExisteArchivo(String strIdAsunto) {
        try {
            String strsql = SQLArchivo.getExisteArchivo(strIdAsunto);
            String strExpediente[][] = ConnectionPool.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return true;
            return false;
        } catch (SQLException sqle) {
            //System.err.println("getExisteArchivo:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina archivo
     * @param strIds	Ids de los archivos a eliminar
     * @return	true si elimino correctamente
     */
    public static boolean deleteArchivo(String[] strIds) {
        int r = 0;
        if (strIds == null || strIds.length < 0)
            return false;

        try {
            String strsql = SQLArchivo.deleteArchivo(strIds);
            r = ConnectionPool.ejecutarActualizacion(strsql);
        } catch (SQLException sqle) {
            //System.err.println("deleteArchivo:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r > 0);  
    }

    /**
     * Verifica si existe referencia con archivos secundarios con asuntos
     * @param strIdAsunto	Id asunto
     * @return	true si existe
     */
    public static boolean getExisteArchivoDocS(String strIdAsunto) {
        try {
            String strsql = 
                "SELECT * FROM sd_archivos WHERE arc_tipo_doc  = 'DS' AND   ARC_ASUNTO=" + 
                strIdAsunto + " AND ARC_INSTRUCCION  = -1";
            String strExpediente[][] = ConnectionPool.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return true;

            return false;
        } catch (SQLException sqle) {
            System.err.println("getExisteArchivo:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
    }
    
    public static boolean getExisteArchivoInstruccion(String strInstruccion) {
        try {
            String strsql = 
                "select * from sd_archivos where arc_tipo_doc='DP' AND ARC_INSTRUCCION=" + 
                strInstruccion;
            String strExpediente[][] = ConnectionPool.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return true;
            return false;
        } catch (SQLException sqle) {
            System.err.println("getExisteArchivoInstruccion:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
    }    
    public static boolean getExisteArchivoInsDocS(String strInstruccion) {
        try {
            String strsql = 
                "select * from sd_archivos where arc_tipo_doc='DP' AND ARC_INSTRUCCION=" + 
                strInstruccion;
            String strExpediente[][] = ConnectionPool.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return true;

            return false;
        } catch (SQLException sqle) {
            System.err.println("getExisteArchivoinsdocs:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
    }    
    public static String getIdDocPrincipalArc(String strIdAsunto) {
        try {
            String strsql = 
               // "SELECT ID_USUARIO_CONTENT FROM SD_CONTENT_ORACLE WHERE ID_ASUNTO_CONTENT = " + 
            	"select arc_usuario from sd_archivos where arc_instruccion=-1 and arc_asunto=" +
                strIdAsunto;
            String strExpediente[][] = ConnectionPool.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return strExpediente[0][0];
            else
                return "";

        } catch (SQLException sqle) {
            //System.err.println("getIdDocPrincipal:" + sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }
    }
    /***********************************************************    BLOB   ***************************************************/
    /**
     * Content Type del archivo
     * @param strId_Archivo	Id archivo
     * @return	Content Type 
     */
    public static String getContentType(String strId_Archivo) {

        int r = 0;
        try {
            String strsql = SQLArchivo.getContentType(strId_Archivo);
            String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
            if (strResultado != null && strResultado.length > 0)
                return strResultado[0][0];
            return null;
        } catch (SQLException sqle) {
            //System.err.println("getContentType:"+sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }
    }

    /**
     * Obtiene el arreglo de bytes de un archivo
     * @param strId_Archivo	Id archivo
     * @return	byte[] arreglo de bytes
     */
    public static byte[] getBlob(String strId_Archivo) {
        InputStream blobarra = null;
        byte[] arra = new byte[256];
        byte[] arr = new byte[256];
        Vector w = new Vector();
        ByteArrayOutputStream b = null;
        int lon = 0;
        Connection con = null;
        Statement st = null;
        ResultSet rsResultadosBlob = null;;
        try {
            //con = ConexionDS.getConexion();
        	con = ConnectionPool.getConnection();
            st = con.createStatement();
            

            rsResultadosBlob = 
                    st.executeQuery(SQLArchivo.getArchivoBinario(strId_Archivo));

            if (rsResultadosBlob.next()) {
                blobarra = rsResultadosBlob.getBinaryStream("ARC_ARCHIVO");
                int y = 0;

                do {
                    y = blobarra.read(arra);
                    if (y != -1) {
                        lon += y;
                    }
                    w.addElement(arra);
                    arra = new byte[256];

                } while (y != -1);
            } else
                return null;

            rsResultadosBlob = 
                    st.executeQuery(SQLArchivo.getArchivoBinario(strId_Archivo));

            if (rsResultadosBlob.next()) {
                byte ar[] = new byte[lon];
                blobarra = rsResultadosBlob.getBinaryStream("ARC_ARCHIVO");
                blobarra.read(ar);
                return ar;
            } else
                return null;

        } catch (Exception e) {
            //System.out.println(e.getMessage() + "\n" + e.toString());
            return null;
        } finally {
            try {rsResultadosBlob.close();} catch(Exception e){;};
            try {st.close();} catch(Exception e){;};
            try {con.close();} catch(Exception e){;};
            
        }
    }

    /**
     * Vector que carga los datos del SIS
     * @param solicitud_sisi	Solicitud sisi
     * @return	Vector con los datos a cargar
     */
    public static Vector getCargaSisi(String solicitud_sisi) {
        String in_filename = solicitud_sisi;
        int sx1 = 0;
        String sx2 = new String(); //, sy1 = 0, sy2 = 0;
        String sx3 = new String(); //, sy1 = 0, sy2 = 0;
        BufferedReader fd_in = null;
        Vector fol = new Vector();
        try {
            fd_in = new BufferedReader(new FileReader(in_filename));
        } catch (FileNotFoundException e) {
            //System.err.println("El archivo " + in_filename + " no existe");
            return null;
        }

        try {
            String line = null;

            while ((line = fd_in.readLine()) != null) {
                sx2 = line.substring(0, line.indexOf(";"));
                sx3 = line.substring(line.lastIndexOf(";") + 1);
                fol.addElement(sx2);
                String strsql = SQLArchivo.getInsertaSisi(sx3, sx2);
                ConexionDS.ejecutarActualizacion(strsql);
            }

            fd_in.close();
        } catch (IOException e) {
            //System.err.println("Error de I/O " + e);
            return null;
        } catch (SQLException e) {
            //System.err.println("Error de I/O " + e);
            return null;
        }
        return fol;
    }

    /**
     * Parametros de un archivo
     * @param strIdAsunto Id asunto
     * @return	Parametros
     */
    public static String[][] getParameters(String strIdAsunto) {
        String strSql = "";
        try {
            strSql = 
                    "SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DP' AND  ID_ASUNTO_CONTENT=" + 
                    strIdAsunto;
            return ConexionDS.ejecutarSQL(strSql);
        } catch (SQLException sqle) {
            //System.err.println("getArchivosReferenciaContent:" + sqle);
            sqle.printStackTrace();
            return null;
        }
    }

    /**
     * Verifica si el usuario turno la instrucción
     * @param strIdAsunto	Id asunto
     * @return	true si s el usuario que turno
     */
    public static boolean getInstruccionTurno(String strIdUsuario, 
                                              String strIdAsunto) {
        String strSql = "";
        String[][] res;
        boolean flag = false;
        try {
            strSql ="SELECT DISTINCT INS_TURNO FROM SD_INSTRUCCION_ASUNTO WHERE INS_TURNO = "+
                    strIdUsuario + " AND ID_ASUNTO = " + strIdAsunto;

            res = ConexionDS.ejecutarSQL(strSql);
            if (res.length > 0) {
                flag = true;
            }
            return flag;
        } catch (SQLException sqle) {
            //System.err.println("getArchivosReferenciaContent:" + sqle);
            sqle.printStackTrace();
        }

        return flag;
    }

    /**
     * Referencia de archivos de content oracle
     * @param strIdAsunto	id asunto
     * @return	regresa arreglo de las referencias
     */
    public static String[][] getArchivosReferenciaContent(String strIdAsunto, 
                                                          String strIdUsuario, 
                                                          String strInstruccion) {
        String strSql = "";
        String strAsunto = "-1";
        if (strIdAsunto.length() > 0 && strInstruccion.length() == 0) {
            try {
                strSql = 
                        "SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DP' AND  ID_ASUNTO_CONTENT=" + 
                        strIdAsunto + " AND ID_INS_CONTENT  = " + strAsunto;
                //              Verificacion de sentencia para la consulta de documentos que son de otras ventanillas//                                
                return ConexionDS.ejecutarSQL(strSql);
            } catch (SQLException sqle) {            
            //En caso de que se produzca un error, creamos otro log de errores//            
                //System.err.println("getArchivosReferenciaContent:" + sqle);
                sqle.printStackTrace();
                return null;
            }
        }

        if (strInstruccion.length() > 0) {

            try {
                strSql = 
                        "SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DP' AND  ID_INS_CONTENT=" + 
                        strInstruccion;
                //              Verificacion de sentencia para la consulta de documentos que son de otras ventanillas//                                
                return ConexionDS.ejecutarSQL(strSql);
            } catch (SQLException sqle) {            
                //En caso de que se produzca un error, creamos otro log de errores//                
                //System.err.println("getArchivosReferenciaContent:" + sqle);
                sqle.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * Referencia de archivos de content oracle secundarios
     * @param strIdAsunto id asunto
     * @return	regresa arreglo de las referencias de archivos secundarios
     */
    public static String[][] getArchivosReferenciaContentDocSec(String strIdAsunto, 
                                                                String strIdUsuario, 
                                                                String strInstruccion) {
        String strSql = "";
        String strAsunto = "-1";
        if (strIdAsunto.length() > 0 && strInstruccion.length() == 0) {
            try {
                strSql = 
                        "SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DS' AND  ID_ASUNTO_CONTENT = " + 
                        strIdAsunto + "  AND ID_INS_CONTENT  = " + strAsunto;
                return ConexionDS.ejecutarSQL(strSql);
            } catch (SQLException sqle) {
                System.err.println("getArchivosReferenciaContentDocSec:" + sqle);
                sqle.printStackTrace();
                return null;
            }
        }
        if (strInstruccion.length() > 0) {
            try {
                strSql = 
                        "SELECT ID_REFERENCIA, NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DS' AND  ID_INS_CONTENT=" + 
                        strInstruccion;
                return ConexionDS.ejecutarSQL(strSql);
            } catch (SQLException sqle) {
                System.err.println("getArchivosReferenciaContentDocSec:" +  sqle);
                sqle.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * Verifica si existe referencias de archivos
     * @param strIdAsunto	Id asunto
     * @return	true si existe
     */
    public static boolean getExisteArchivoReferencia(String strIdAsunto) {
        try {
            String strsql = 
                "SELECT * FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DP' " + 
                " AND ID_ASUNTO_CONTENT=" + strIdAsunto + 
                "AND ID_INS_CONTENT = -1";
            String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return true;

            return false;
        } catch (SQLException sqle) {
            System.err.println("getExisteArchivoReferencia:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
    }

    /**
     * Verifica si existen archivos con referencai a instrucciones
     * @param strIdAsunto
     * @return true si existe
     */
    public static boolean getExisteArchivoReferenciaInstruccion(String strInstruccion) {
        try {
            String strsql = 
                "SELECT * FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DP' AND ID_INS_CONTENT=" + 
                strInstruccion;
            String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return true;
            return false;
        } catch (SQLException sqle) {
            System.err.println("getExisteArchivoReferenciaInstruccion:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
    }
    

    /**
     * Verifica si existe referencia con archivos secundarios con asuntos
     * @param strIdAsunto	Id asunto
     * @return	true si existe
     */
    public static boolean getExisteArchivoReferenciaDocS(String strIdAsunto) {
        try {
            String strsql = 
                "SELECT * FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DS' AND   ID_ASUNTO_CONTENT=" + 
                strIdAsunto + " AND ID_INS_CONTENT  = -1";
            String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return true;

            return false;
        } catch (SQLException sqle) {
            System.err.println("getExisteArchivoReferencia:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
    }

    /**
     * Verifica si existe referencia con archivos secundarios con instrucciones
     * @param strIdAsunto	Id asunto
     * @return	true si existe
     */
    public static boolean getExisteArchivoReferenciaInsDocS(String strInstruccion) {
        try {
            String strsql = 
                "SELECT * FROM SD_CONTENT_ORACLE WHERE TIPO_DOCUMENTO  = 'DS' AND ID_INS_CONTENT=" + 
                strInstruccion;
            String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return true;

            return false;
        } catch (SQLException sqle) {
            System.err.println("getExisteArchivoReferencia:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
    }
    

    /**
     * Elimina los archivos referenciados a un asunto
     * @param strIds ids
     * @return
     */
    public static boolean deleteArchivoReferencia(String[] strIds) throws FdkException, 
                                                                          RemoteException {
        Vector ids = new Vector();
        int r = 0;
        if (strIds == null || strIds.length < 0)
            return false;

        try {
            String strsql = SQLArchivo.deleteArchivoReferencia(strIds);
            r = ConexionDS.ejecutarActualizacion(strsql);
        } catch (SQLException sqle) {
            //System.err.println("deleteArchivoReferencia:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r > 0);
    }

    /**
     * Actualiza referencias 
     * @param stridArchivo	Id archivo
     * @param strIdItem		Item
     * @return	true si actualiza correctamente
     */
    public static boolean updateReferencia(String stridArchivo, 
                                           Long strIdItem) {
        int r = 0;
        try {
            String strsql = 
                SQLArchivo.updateReferencia(stridArchivo, strIdItem);
            r = ConexionDS.ejecutarActualizacion(strsql);
        } catch (SQLException sqle) {
            //System.err.println("updateReferencia:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r > 0);
    }

    /**
     * Datos de un archivo referenciado
     * @param strIdArchivo	Id archivo
     * @return	regresa arreglo de archivos referenciados
     */
    public static String[][] getArchivosReferenciaContentID(String strIdArchivo) {
        String strSql = "";
        try {
            strSql = 
                    "SELECT ID_REFERENCIA, NOMBRE_ARCHIVO, CONTENT_TYPE, ID_ITEM_DOC " + 
                    "FROM SD_CONTENT_ORACLE WHERE ID_REFERENCIA=" + 
                    strIdArchivo;
            return ConexionDS.ejecutarSQL(strSql);
        } catch (SQLException sqle) {
            //System.err.println("getArchivosReferenciaContentID:" + sqle);
            sqle.printStackTrace();
            return null;
        }
    }

    /**
     * Datos de archivos principales por asunto
     * @param strIdAsunto Id asunto
     * @return	Id usuario content
     */
    public static String getIdDocPrincipal(String strIdAsunto) {
        try {
            String strsql = 
                "SELECT ID_USUARIO_CONTENT FROM SD_CONTENT_ORACLE WHERE ID_ASUNTO_CONTENT = " + 
            	//"select arc_usuario from sd_archivos where arc_instruccion=-1 and arc_asunto=" +
                strIdAsunto;
            String strExpediente[][] = ConnectionPool.ejecutarSQL(strsql);
            if (strExpediente.length > 0)
                return strExpediente[0][0];
            else
                return "";

        } catch (Exception sqle) {
            //System.err.println("getIdDocPrincipal:" + sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }
    }

    /**
     * Nombre del archivo
     * @param strIdAsunto	Id asunto
     * @param strIdDoc		Id docto
     * @return	Arreglo 
     */
    public static String[] getNombreArchivo(String strIdAsunto, 
                                            String strIdDoc) {
        String name = "";

        StringTokenizer tokens = new StringTokenizer(strIdDoc, "|");
        int nDatos = tokens.countTokens();
        String strDatoAsu[] = new String[nDatos];
        String strResultados[] = new String[nDatos];

        int i = 0;
        int y = 0;
        int x = 0;

        while (tokens.hasMoreTokens()) {
            String str = tokens.nextToken();
            strDatoAsu[x] = str;
            x++;
        }
        try {
            for (i = 0; strDatoAsu.length > i; i++) {

                String strsql = 
                    "SELECT NOMBRE_ARCHIVO FROM SD_CONTENT_ORACLE WHERE ID_ASUNTO_CONTENT = " + 
                    strIdAsunto + " AND ID_REFERENCIA = " + strDatoAsu[i];
                String strExpediente[][] = ConexionDS.ejecutarSQL(strsql);
                strResultados[i] = strExpediente[0][0];


            }
            return strResultados;
        } catch (SQLException sqle) {
            System.err.println("getNombreArchivo --- --- :" + sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }
    }

    /**
     * Regresa el nombre de los archivos asociados a un documento
     * @param strIdAsunto ID del documento
     * @return Strin con el nombre de los archivos 
     */
    public static String getStringNombreArchivos(String strIdAsunto) {
        String strSql = 
            "SELECT NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE " + "WHERE ID_ASUNTO_CONTENT = " + 
            strIdAsunto + " " + "AND ID_INS_CONTENT = -1 ";

        try {
            String strResultado[][] = ConexionDS.ejecutarSQL(strSql);
            if (strResultado != null && strResultado.length > 0) {
                String strArchivos = "";
                for (int i = 0; i < strResultado.length; i++) {
                    strArchivos += strResultado[i][0] + ", ";
                }
                return strArchivos;
            } else
                return "Sin Documentos Anexados";

        } catch (SQLException sqle) {
            //System.err.println("getStringNombreArchivos:" + sqle.getMessage());
            sqle.printStackTrace();
            return "";
        }
    }

    /**
     * Regresa el nombre de los archivos asociados a un documento
     * @param strIdInstruccion ID de la Instruccion
     * @return Strin con el nombre de los archivos 
     */
    public static String getStringNombreArchivosIns(String strIdInstruccion) {
        String strSql = 
            "SELECT NOMBRE_ARCHIVO " + "FROM SD_CONTENT_ORACLE " + "WHERE ID_INS_CONTENT = " + 
            strIdInstruccion + " ";

        try {
            String strResultado[][] = ConexionDS.ejecutarSQL(strSql);
            if (strResultado != null && strResultado.length > 0) {
                String strArchivos = "";
                for (int i = 0; i < strResultado.length; i++) {
                    strArchivos += strResultado[i][0] + ", ";
                }
                return strArchivos;
            } else
                return "Sin Documentos Anexados";

        } catch (SQLException sqle) {
            System.err.println("getStringNombreArchivosIns:" + sqle.getMessage());
            sqle.printStackTrace();
            return "";
        }
    }

}

