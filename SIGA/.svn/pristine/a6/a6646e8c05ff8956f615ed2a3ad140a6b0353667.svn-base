/*
 * Clase:						SQLCiudadano.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Jan 5, 2006
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
 * SQLCiudadano es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_CIUDADANO, SD_ASUNTO_CIUDADANO, SD_NOTIFICACION_CIUDADANO
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLCiudadano {
    
	/**
     * Actualiza cuidadano
     * @param strNombre		Nombre ciudadano
     * @param strAP			Apellido paterno
     * @param strAM			Apellido materno
     * @param strFechaNac	Fecha de nacimiento
     * @param strSexo		Sexo
     * @param strOcupacion	Ocupación
     * @param strDomicilio	Domicilio
     * @param strPais		País
     * @param strEstado		Estado
     * @param strMunicipio	Municipio
     * @param strTelefono	Telefono
     * @param strMail		Mail
     * @param strUsuario	Usuario
     * @param strClave		Clave
     * @param strSector		Sector
     * @return	Regresa un String con el Query correspondiente
     */
    public static String insertaCiudadano(String strNombre, String strAP, String strAM,
            							String strFechaNac, String strSexo, String strOcupacion,
            							String strDomicilio, String strPais, String strEstado,
            							String strMunicipio, String strTelefono, String strMail,
            							String strUsuario, String strClave, String strSector)
    {
        String sql = "";
        sql = "INSERT INTO SD_CIUDADANO (ID_CIUDADANO,CIU_NOMBRE, CIU_APELLIDO_PATERNO, CIU_APELLIDO_MATERNO, ";
        sql +=		"CIU_FECHA_NAC, CIU_SEXO, CIU_OCUPACION, CIU_DOMICILIO, CIU_PAIS, CIU_ESTADO, ";
        sql +=		"CIU_MUNICIPIO, CIU_TELEFONO, CIU_MAIL, CIU_USUARIO, CIU_PASSWORD, CIU_SECTOR) VALUES ";
        sql +=		"(SD_CIUDADANO_SEQ.NEXTVAL,'"+strNombre+"', '"+strAP+"', '"+strAM+"', ";
        if(strFechaNac.equals("null")){
        	sql +=		" null, ";
        }else{
        	sql +=		" '"+strFechaNac+"', ";
        }
        
        sql +=		" "+strSexo+", '"+strOcupacion+"', ";
        sql +=		"'"+strDomicilio+"', '"+strPais+"', '"+strEstado+"', '"+strMunicipio+"', '"+strTelefono+"', ";
        sql +=		"'"+strMail+"', '"+strUsuario+"', '"+strClave+"', '"+strSector+"')";
        return sql;
    }
    
    /**
     * Actualiza cuidadano
     * @param strNombre		Nombre ciudadano
     * @param strAP			Apellido paterno
     * @param strAM			Apellido materno
     * @param strFechaNac	Fecha de nacimiento
     * @param strSexo		Sexo
     * @param strOcupacion	Ocupación
     * @param strDomicilio	Domicilio
     * @param strPais		País
     * @param strEstado		Estado
     * @param strMunicipio	Municipio
     * @param strTelefono	Telefono
     * @param strMail		Mail
     * @param strSector		Sector
     * @return	Regresa un String con el Query correspondiente
     */
    public static String actualizaCiudadano(String strIdCiudadano, String strNombre, String strAP, String strAM,
            								String strFechaNac, String strSexo, String strOcupacion,
            								String strDomicilio, String strPais, String strEstado,
            								String strMunicipio, String strTelefono, String strMail,
            								String strSector){
        String sql = "";
        sql = "UPDATE SD_CIUDADANO SET CIU_NOMBRE='"+strNombre+"', CIU_APELLIDO_PATERNO='"+strAP+"', " ;
        sql +=	"CIU_APELLIDO_MATERNO='"+strAM+"', ";
        if(strFechaNac.equals("null")){
            sql +=	"CIU_FECHA_NAC=null , ";  
//            //System.out.println("no tiene fecha nac");
        }
        else{
        	sql +=	"CIU_FECHA_NAC='"+strFechaNac+"', ";
//        	//System.out.println("si tiene fecha nac");
        }
        sql +=		"CIU_SEXO="+strSexo+", " ;
        sql +=		"CIU_OCUPACION='"+strOcupacion+"', CIU_DOMICILIO='"+strDomicilio+"', CIU_PAIS='"+strPais+"', " ;
        sql +=		"CIU_ESTADO='"+strEstado+"', CIU_MUNICIPIO='"+strMunicipio+"', CIU_TELEFONO='"+strTelefono+"', " ;
        sql +=		"CIU_MAIL='"+strMail+"', CIU_SECTOR='"+strSector+"' WHERE ID_CIUDADANO="+strIdCiudadano;
        return sql;
            
    }
    
    /**
     * Actualiza password de ciudadano
     * @param strIdCiudadano	Id ciudadano
     * @param strPassword		password nuevo
     * @return	Regresa un String con el Query correspondiente
     */
    public static String actualizaPassword(String strIdCiudadano, String strPassword){
        String sql = "UPDATE SD_CIUDADANO SET CIU_PASSWORD='"+strPassword+"' " +
        		" WHERE ID_CIUDADANO="+strIdCiudadano;
        return sql;
    }
    
    /**
     * Datos de consulta del ciudadano
     * @param strIdUsuarioCreador	Id Ciudadano
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDatosCiudadanoConsulta(String strIdUsuarioCreador){
    	String sql = "SELECT CIU_NOMBRE, CIU_APELLIDO_PATERNO, CIU_APELLIDO_MATERNO, " +
    			"CIU_FECHA_NAC, CIU_SEXO, CIU_OCUPACION, CIU_DOMICILIO, CIU_PAIS, CIU_ESTADO, " +
    			"CIU_MUNICIPIO, CIU_TELEFONO, CIU_MAIL, CIU_USUARIO, CIU_PASSWORD, CIU_SECTOR " +
    			"FROM SD_CIUDADANO WHERE ID_CIUDADANO="+strIdUsuarioCreador;
    	return sql;
    }
    
    /**
     * Verifica si existe el ciudadano
     * @param strUsuario	Id ciudadano
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExisteUsuario(String strUsuario)
    {
        String sql = "SELECT * FROM SD_CIUDADANO WHERE CIU_USUARIO='"+strUsuario+"'";
        return sql;
    }
    
    /**
     * Datos para cargar los datos en la sessión de un ciudadano en la aplicación
     * @param strUsuario	Username del usuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getCiudadano(String strUsuario){
        String sql = "SELECT ID_CIUDADANO, CIU_NOMBRE, CIU_APELLIDO_PATERNO, CIU_APELLIDO_MATERNO, " +
        		"CIU_MAIL, CIU_USUARIO, CIU_OCUPACION, CIU_DOMICILIO, CIU_PAIS, CIU_ESTADO," +
        		"CIU_MUNICIPIO, CIU_TELEFONO, CIU_SECTOR, CIU_SEXO, CIU_FECHA_NAC " +
        		"FROM SD_CIUDADANO WHERE CIU_USUARIO='"+strUsuario+"'";
        return sql;
    }
    
    /**
     * Datos de un ciudadano a editar
     * @param strIdCiudadano ciudadano
     * @return Query
     */
    public static String getCiudadanoEditar(String strIdCiudadano){
        String sql = "SELECT ID_CIUDADANO, CIU_NOMBRE, CIU_APELLIDO_PATERNO, CIU_APELLIDO_MATERNO, " +
        		"CIU_MAIL, CIU_USUARIO, CIU_OCUPACION, CIU_DOMICILIO, CIU_PAIS, CIU_ESTADO," +
        		"CIU_MUNICIPIO, CIU_TELEFONO, CIU_SECTOR, CIU_SEXO, CIU_FECHA_NAC " +
        		"FROM SD_CIUDADANO WHERE ID_CIUDADANO="+strIdCiudadano+"";
        return sql;
    }
    
    /**
     * Datos del ciudadano
     * @param strIDUsuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDatosCiudadano(String strIDUsuario){
        String sql = "SELECT ID_CIUDADANO, CIU_NOMBRE, CIU_APELLIDO_PATERNO, CIU_APELLIDO_MATERNO, " +
        		"CIU_MAIL, CIU_USUARIO, CIU_OCUPACION, CIU_DOMICILIO, CIU_PAIS, CIU_ESTADO," +
        		"CIU_MUNICIPIO, CIU_TELEFONO, CIU_SECTOR, CIU_PASSWORD FROM SD_CIUDADANO WHERE ID_CIUDADANO="+strIDUsuario+"";
        return sql;
    }
    
    /**
     * Lista de los ciudadanos
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getComboCiudadano(){
        String sql = "SELECT CIU_USUARIO, CIU_NOMBRE, CIU_MAIL, ID_CIUDADANO FROM SD_CIUDADANO ORDER BY 1";
        return sql;
    }
    
    /**
     * Función que regresa un query, donde se inserta la solicitud
     * de información de un ciudadano. No se agrega archivo
     * @param strDescripcion Descripcion o nombre de la solicitud o asunto
     * @param strFecha Fecha en la que se creo la solicitud
     * @param strCiuCreador Clave del ciudadano que ha solicitado la información
     * @param strFolio Folio generado para dar referencia a la solicitud
     * @return Regresa un String con el Query correspondiente
     */
    public static String insertarSolicitudSinArch(	String strDescripcion, String strFecha, 
            										String strCiuCreador, String strFolio, String strDetalle,
            										String strFechaHora){
        String sql = "INSERT INTO SD_ASUNTO_CIUDADANO (ID_SOLICITUD, SOL_DESCRIPCION_SOLICITUD, SOL_FECHA_CREACION, " +
        			"SOL_CIUDADANO_CREADOR, SOL_FOLIO_SOLICITUD, SOL_AVANCE_SOLICITUD, SOL_ESTATUS, SOL_DETALLE, SOL_FECHA_HORA) " +
        			"VALUES (SD_ASUNTO_CIUDADANO_SEQ.NEXTVAL,'"+strDescripcion+"', '"+strFecha+"', "+strCiuCreador+", '"+strFolio+"', 0, 1, '"+strDetalle+"', '"+strFechaHora+"')";
        return sql;
    }
    
    /**
     * Función que regresa un query, donde se inserta la solicitud
     * de información de un ciudadano. Se se agrega archivo
     * @param strDescripcion Descripcion o nombre de la solicitud o asunto
     * @param strFecha Fecha en la que se creo la solicitud
     * @param strCiuCreador Clave del ciudadano que ha solicitado la información
     * @param strFolio Folio generado para dar referencia a la solicitud
     * @return Regresa un String con el Query correspondiente
     */
    public synchronized static String insertarSolicitudConArch(	String strDescripcion, String strFecha, 
													String strCiuCreador, String strFolio, String strDetalle, String strFechaHora){
        String sql = "INSERT INTO SD_ASUNTO_CIUDADANO (ID_SOLICITUD, SOL_DESCRIPCION_SOLICITUD, SOL_FECHA_CREACION, " +
        			"SOL_CIUDADANO_CREADOR, SOL_FOLIO_SOLICITUD, SOL_AVANCE_SOLICITUD, SOL_ESTATUS, SOL_DETALLE, SOL_FECHA_HORA, SOL_ARCHIVO) " +
        			"VALUES (SD_ASUNTO_CIUDADANO_SEQ.NEXTVAL, '"+strDescripcion+"', '"+strFecha+"', "+strCiuCreador+", '"+strFolio+"', 0, 1, '"+strDetalle+"', '"+strFechaHora+"', ?)";
        return sql;
    }
    
    /**
     * Devuelve el Ultimo ID registrado
     * @return	Regresa un String con el Query correspondiente
     */
    public synchronized static String getUltimoIDSolicitud(){
        String sql = "SELECT MAX(ID_SOLICITUD) FROM SD_ASUNTO_CIUDADANO";
        return sql;
    }
    
    /**
     * Ultimo Id del ciudadano registrado
     * @return	Regresa un String con el Query correspondiente
     */
    public synchronized static String getUltimoIDCiudadano(){
        String sql = "SELECT MAX(ID_CIUDADANO) FROM SD_CIUDADANO";
        return sql;
    }
    
    /**
     * Devuelve un query donde se actualiza el folio de la
     * solicitud
     * @param strIdSol Id de la solicitud
     * @param strFolio Folio que se va a actualizar
     * @return	Regresa un String con el Query correspondiente
     */
    public static String actualizaFolioSolicitud(String strIdSol, String strFolio, String strIdAsunto){
        String sql = "UPDATE SD_ASUNTO_CIUDADANO SET SOL_FOLIO_SOLICITUD='"+strFolio+"', SOL_ID_ASUNTO="+strIdAsunto+" " +
        			"WHERE ID_SOLICITUD="+strIdSol;
        return sql;
    }
    
    /**
     * Devuelve un query donde muestra los datos a detalle
     * de cada solicitus por Ciudadano
     * @param strIdUsuario Id del Ciudadano
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosCiudadanoPortal(String strIdUsuario){
        String sql = "SELECT ID_SOLICITUD, SOL_DESCRIPCION_SOLICITUD, SOL_FOLIO_SOLICITUD, " +
        		"to_char(SOL_FECHA_CREACION, 'yyyy-MM-dd'), SOL_AVANCE_SOLICITUD, SOL_ESTATUS, SOL_ID_ASUNTO " +
        		"FROM SD_ASUNTO_CIUDADANO WHERE SOL_CIUDADANO_CREADOR="+strIdUsuario;
        return sql;
    }
    
    /**
     * Datos del ciudadano
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDatosCiudadanoPortal(){
        String sql = "SELECT ID_SOLICITUD, SOL_DESCRIPCION_SOLICITUD, SOL_FOLIO_SOLICITUD, " +
        		"SOL_FECHA_CREACION, SOL_AVANCE_SOLICITUD, SOL_ESTATUS, SOL_ID_ASUNTO " +
        		"FROM SD_ASUNTO_CIUDADANO";
        return sql;
    }
    
    /**
     * Función que regresa un query donde verifica si hay 
     * solicitudes del usuario en el portal
     * @param strIdUsuario Id del Usuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExisteSolicitud(String strIdUsuario){
        String sql = "SELECT * FROM SD_ASUNTO_CIUDADANO WHERE SOL_CIUDADANO_CREADOR="+strIdUsuario;
        return sql;
    }
    
    /**
     * Verifica si existe la solicitud
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExisteSolicitud(){
        String sql = "SELECT * FROM SD_ASUNTO_CIUDADANO";
        return sql;
    }
    
    /**
     * Devuelve los datos a detalle de la solicitud
     * @param strIdSolicitud Id de la solicitud
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDatosCiudadanoDetalle(String strIdSolicitud){
        String sql = "SELECT ID_SOLICITUD, SOL_DESCRIPCION_SOLICITUD, SOL_FOLIO_SOLICITUD, " +
        			" SOL_FECHA_CREACION, SOL_AVANCE_SOLICITUD, SOL_ESTATUS, SOL_ID_ASUNTO, SOL_DETALLE, " +
        			" SOL_FECHA_HORA, SOL_CIUDADANO_CREADOR FROM SD_ASUNTO_CIUDADANO WHERE ID_SOLICITUD="+strIdSolicitud;
        return sql;
    }
    
    /**
     * devuelve un query, donde actualiza el avance de una solicitud
     * @param strIdAsunto Id de asunto
     * @param strAvance Avance
     * @return	Regresa un String con el Query correspondiente
     */
    public static String actualizaAvanceSolicitud(String strIdAsunto, String strAvance){
        String sql = "UPDATE SD_ASUNTO_CIUDADANO SET SOL_AVANCE_SOLICITUD="+strAvance+" " +
        		" WHERE SOL_ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * devuelve un query donde se inserta los datos de las notificaciones o 
     * respuestas a un ciudadano
     * @param strRespuesta
     * @param strIdAsunto
     * @param strNombreFuncionario
     * @param strMail
     * @param strFecha
     * @return	Regresa un String con el Query correspondiente
     */
    public static String insertarNotificacion(String strRespuesta, String strIdAsunto,
            								String strNombreFuncionario, String strMail,
            								String strFecha, String tipoRespuesta, 
            								String strEstatus, String strCerrar, String strRespondio, 
            								int activo)
    {
        String sql = "INSERT INTO SD_NOTIFICACION_CIUDADANO (ID_NOTIFICACION,NOT_RESPUESTA, NOT_ID_ASUNTO, " +
        		"NOT_FUNCIONARIO, NOT_MAIL, NOT_FECHA, NOT_TIPO_RESPUESTA, NOT_ESTATUS, NOT_ACTIVA, NOT_CERRAR, NOT_RESPONDIO) " +
        		" VALUES(SD_NOTIFICACION_CIUDADANO_SEQ.NEXTVAL, '"+strRespuesta+"', " +
        		""+strIdAsunto+", '"+strNombreFuncionario+"', '"+strMail+"', '"+strFecha+"', " +
        		""+tipoRespuesta+", "+strEstatus+", "+activo+", "+strCerrar+", "+strRespondio+")";
        return sql;
    }
    
    /**
     * devuelve un query para verificar si el seguimiento
     * tiene notificaciones recibidas
     * @param strIdAsunto Id del asunto
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExistenNotificaciones(String strIdAsunto){
        String sql = "SELECT * FROM SD_NOTIFICACION_CIUDADANO WHERE NOT_ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * devuelde los datos a detalle de las notificaciones recibidas
     * por id de asunto
     * @param strIdAsunto Id de Asunto
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDatosNotificacion(String strIdAsunto){
        String sql = "SELECT NOT_RESPUESTA, NOT_FUNCIONARIO, NOT_MAIL, to_char(NOT_FECHA, 'dd/MM/yyyy hh:mm:ss'), NOT_TIPO_RESPUESTA, ID_NOTIFICACION, NOT_ESTATUS " +
        		"FROM SD_NOTIFICACION_CIUDADANO WHERE NOT_ID_ASUNTO="+strIdAsunto+" AND NOT_ACTIVA=1";
        return sql;
    }
    
    /**
     * Datos de las notificaciones
     * @param strIdAsunto id notificación
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDatosNot(String strIdAsunto){
        String sql = "SELECT NOT_RESPUESTA, to_char(NOT_FECHA, 'dd/MM/yyyy hh:mm:ss'), NOT_TIPO_RESPUESTA, NOT_ESTATUS, NOT_RESPONDIO " +
        		"FROM SD_NOTIFICACION_CIUDADANO WHERE NOT_ID_ASUNTO="+strIdAsunto+" ORDER BY 2";
        return sql;
    }
    
    /**
     * Desactiva la notificación de un asunto
     * @param strIdAsunto	Id asunto
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getNotificacionDesacticar(String strIdAsunto){
        String sql = "SELECT ID_NOTIFICACION FROM SD_NOTIFICACION_CIUDADANO " +
        		" WHERE NOT_ACTIVA=1 AND NOT_ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * Actualiza la nueva notificación
     * @param strIdNotificacion	Id notificación
     * @return	Regresa un String con el Query correspondiente
     */
    public static String actualizaActivarNuevaNot(String strIdNotificacion){
        String sql = "UPDATE SD_NOTIFICACION_CIUDADANO SET NOT_ACTIVA=0 WHERE ID_NOTIFICACION="+strIdNotificacion;
        return sql;
    }
    
    /**
     * Verifica si alguna notificación tiene el cierre
     * @param strIdAsunto	Id asunto
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getCerrar(String strIdAsunto){
        String sql = "SELECT COUNT(*) FROM SD_NOTIFICACION_CIUDADANO WHERE NOT_CERRAR=1 AND NOT_ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * Lista de asuntos por tiempo de respuesta
     * @param strIdTipRespuesta	Id respuesta
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getAsuntosPorTipoRespuesta(String strIdTipRespuesta){
    	String sql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_FOLIO_RECEPCION, NOT_ESTATUS, NOT_ID_ASUNTO " +
    				"FROM SD_ASUNTO, SD_NOTIFICACION_CIUDADANO " +
    				"WHERE NOT_TIPO_RESPUESTA="+strIdTipRespuesta+" AND " +
    				"NOT_ACTIVA=1 " +
    				"AND SD_ASUNTO.ID_ASUNTO=SD_NOTIFICACION_CIUDADANO.NOT_ID_ASUNTO " +
    				"ORDER BY 2";
    	return sql;
    }
    
    /**
     * Verifica si existe respuesta
     * @param strIdRespuesta	id respuesta
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getExisteRespuestas(String strIdRespuesta){
    	String sql = "SELECT * FROM SD_NOTIFICACION_CIUDADANO " +
    			"WHERE NOT_TIPO_RESPUESTA="+strIdRespuesta+" AND NOT_ACTIVA = 1 ";// AND NOT_CERRAR = 0 ";
    	return sql;
    }
    
    /**
     * Envia la ultima respuesta del ciudadano
     * @param strIdAsunto	id asunto
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getUltimaRespuestaCiudadano(String strIdAsunto){
    	String sql = "SELECT MAX(NOT_FECHA) FROM SD_NOTIFICACION_CIUDADANO WHERE NOT_ID_ASUNTO="+strIdAsunto+" AND NOT_RESPONDIO=0";
    	return sql;
    }
    
    /**
     * Verifica si la solicitus tiene contestación
     * @param strIdAsunto	Id asunto
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getTieneContestacion(String strIdAsunto){
    	String sql = "SELECT * FROM SD_NOTIFICACION_CIUDADANO WHERE NOT_RESPONDIO=0";
    	return sql;
    }
    
    /**
     * Lista de asuntos notificados
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getAsuntosNotificados(){
        String sql = "SELECT DISTINCT NOT_ID_ASUNTO FROM SD_NOTIFICACION_CIUDADANO";
        return sql;
    }
    
    /**
     * Catalogo de Ocupación
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getListaOcupacion(){
    	String strSql = "SELECT ID_OCUPACION, OCU_DESCRIPCION FROM CAT_OCUPACION ORDER BY 2";
    	return strSql;
    }
    
    /**
     * Catalogo de Estado
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getListaEstado(){
    	String strSql = "SELECT ID_ESTADO, EDO_DESCRIPCION FROM CAT_ESTADOS ORDER BY 2";
    	return strSql;
    }
    
    /**
     * Catalogo Municipio
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getListaMunicipio(){
    	String strSql = "SELECT ID_MUNICIPIO, MUN_DESCRIPCION FROM CAT_MUNICIPIOS ORDER BY 2";
    	return strSql;
    }
    
}

