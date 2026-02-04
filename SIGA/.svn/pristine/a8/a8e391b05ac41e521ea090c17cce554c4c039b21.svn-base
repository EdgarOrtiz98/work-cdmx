/*
 * Clase:						SQLComentario.java
 * 
 * Paquete:						com.meve.sigma.reportes		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 24, 2005
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
 * Clase para generar codigo SQL Query para los Comentarios del Asunto
 *
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLComentario {
    
    /**
     * Construye un SQL Query para insertar un Comentario a un Asunto asociado a idAsnto
     * 
     * @param Comentario Comentario que se va a insertar
     * @param Usr ID del Usuario 
     * @param fecha Fecha en la que se inserta el comentario 
     * @param idAsunto ID del asunto al que se le inserta el comentario 
     * @param UsrNombre Nombre del Usuario
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String InsertarComentario(String Comentario, String Usr, String fecha, String idAsunto, String UsrNombre)
    {
        String sql = "";
        
        sql = "INSERT INTO SD_COMETARIOS_ASUNTO (ID_COMENTARIO, COM_DESCRIPCION, COM_USUARIO, COM_FECHA, COM_ASUNTO, COM_USUARIO_NOMBRE) " +
			"VALUES(SD_COMETARIOS_ASUNTO_SEQ.NEXTVAL,'"+Comentario+"', "+Usr+", SYSDATE, "+idAsunto+", '"+UsrNombre+"')";
        return sql;
    }
    
    /**
     * Construye un SQL Query para verificar si existen registros de comentarios para determinado ID de Asunto
     * 
     * @param strIdAsunto ID del Asunto 
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExistenComentarios(String strIdAsunto)
    {
        String sql = "";
        sql = "SELECT ID_COMENTARIO FROM SD_COMETARIOS_ASUNTO WHERE COM_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * Construye un SQL Query para regresar un arreglo con todos los Comentarios Asociados a un ID de Asunto
     * 
     * @param strIdAsunto ID del Asunto
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosComentarios(String strIdAsunto)
    {
        String sql = "";
        sql = "SELECT COM_DESCRIPCION, TO_CHAR(COM_FECHA, 'DD/MM/YYYY HH:MI:SS AM'), COM_USUARIO_NOMBRE FROM SD_COMETARIOS_ASUNTO WHERE COM_ASUNTO="+strIdAsunto + " ORDER BY ID_COMENTARIO DESC ";
        return sql;
    }
    
    public static String getDatosComentariosComplementario(String strIdAsunto)
    {
        String sql = "";
        //sql = "SELECT * FROM SD_COMETARIOS_ASUNTO WHERE ID_COMENTARIO = (SELECT MAX(ID_COMENTARIO) FROM SD_COMETARIOS_ASUNTO WHERE COM_ASUNTO= " + strIdAsunto + ")";
       
        sql="select * from (SELECT ins.id_instruccion_asunto,hi.his_comentarios   FROM sd_instruccion_asunto ins,sd_historial_instrucciones hi    WHERE ins.ins_estatus = 4   and hi.id_instruccion_asunto=ins.id_instruccion_asunto and hi.his_avance = 100 AND (ins.ins_padre is null or ins.ins_padre = 0) and ins.id_asunto=" + strIdAsunto + " ORDER BY ins.ins_folio_turnado) where rownum=1";
        return sql;
    }

}

