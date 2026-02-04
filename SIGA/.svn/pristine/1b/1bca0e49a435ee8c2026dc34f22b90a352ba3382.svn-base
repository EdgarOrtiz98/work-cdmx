/**
 * Clase:						SQLAsunto.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 22, 2005
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

import com.meve.sigma.util.Utilerias;

/**
 * SQLArchivado es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_ARCHIVADO
 * 
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLAsunto {
    
    /**
     * Inserta el registro de un Asunto
	 * 
	 * @param strIdEntidad		Id de la Entidad
	 * @param strIdRemitente	Id del Remitente
	 * @param strFirmante		Firmante del Asunto
	 * @param strAsunto			Descripción del Asunto
	 * @param strIdExpediente	Id del Expediente
	 * @param strIdTipoDocto	Id Tipo Docto.
	 * @param strFechaRep		Fecha de Recepción del Asunto
	 * @param strFechaDoc		Fecha del Documento
	 * @param strFechaCad		Fecha Compromiso del Asunto
	 * @param strFolioExt		Identificador del Documento
	 * @param strFolioInt		Folio Intermedio
	 * @param strSintesis		Descripción del Asunto
	 * @param strComentarios	Comentarios del Asunto
	 * @param strPalabraClave	Palabra Clave
	 * @param strAsuntoAnt		Referencia del Asunto
	 * @param strIdPrioridad	Id Prioridad
	 * @param FolioGenerado		Folio Generado
	 * @param strUsUpdate		Usuario que Actualizo el Asunto
	 * @param strFecUpdate		Fecha de Actualización
	 * @param strAreaRecepcion	área o UA de Recepción
	 * @param strIdTipoAsunto	Id Tipo Asunto
	 * @param strUsrTurnar		Id del Turnador o Ventanilla
	 * @param strControl		Control de un Asunto(0=Entidad, 1=UA ó área)
	 * @param strEstatus		Estatus del Asunto
	 * @param strPara			Lista de Para
	 * @param strCC				Lista de CC
	 * @param strIdsPara		Lista Ids Para
	 * @param strIdsCC			Lista Ids CC
	 * @param lugarEvento		Lugar de Evento
	 * @param stringHoraEvento	Hora de Recepción
	 * @param strFechaEvento	Fecha del Evento
	 * @param stringMinEvento	Minuto del Evento
	 * @param strParaE			Lista Para Destinatarios Externos
	 * @param strIdsParaE		Lista Ids Para Destinatarios Externos
	 * @param strTramite		Trámite de un Asunto
	 * @param strTipoFolio		Tipo de Folio
     * @return Regresa un String con el Query correspondiente
     */
	public synchronized static String getInsertaAsunto(	String strIdEntidad, String strIdRemitente,
			String strFirmante, String strAsunto, 
			String strIdExpediente,  
			/*String strUbicacion, String strReferencia,*/ String strIdTipoDocto,
			/*String strCategoria,*/ String strFechaRep,
			String strFechaDoc, String strFechaCad, String strFolioExt, 
			String strFolioInt, String strSintesis, String strComentarios, 
			String strPalabraClave, String strAsuntoAnt, String strIdPrioridad,
			String FolioGenerado, String strUsUpdate, String strFecUpdate,
			String strAreaRecepcion, String strIdTipoAsunto, String strUsrTurnar,
			String strControl, String strEstatus, String strPara, String strCC,
			String strIdsPara, String strIdsCC, String strLugarEvento, String stringHoraEvento, 
			String strFechaEvento, String stringMinEvento, String strParaE,
			String strIdsParaE, String strTramite, String strTipoFolio)
	{
		
		/*if(!strTramite.equals("-1")){
			strTramite = strTramite.substring(0,strTramite.indexOf("|"));
		}*/

		String strSql = "INSERT INTO SD_ASUNTO ";
		strSql +=	"(ID_ASUNTO,ASU_ENTIDAD, ASU_REMITENTE, ASU_FIRMANTE,";
		//strSql +=	" ASU_DESCRIPCION, ASU_EXPEDIENTE, ASU_UBICACION, ASU_REF_EXPEDIENTE,";
		strSql +=	" ASU_DESCRIPCION, ASU_EXPEDIENTE,";
		strSql +=	" ASU_TIP_DOCTO, ASU_FECHA_RECEPCION, ASU_FECHA_DOCTO,";
		strSql +=	" ASU_FECHA_CADUCIDAD, ASU_FOLIO_EXTERNO, ASU_FOLIO_INTERMEDIO, ASU_SINTESIS, ASU_COMENTARIOS,";
		strSql +=	" ASU_PALABRA_CLAVE, ASU_REF_ASUNTO_ANTERIOR, ASU_PRIORIDAD, ASU_FOLIO_RECEPCION,";
		strSql +=	" ASU_USUARIO_CAPTURA, ASU_FECHA_CAPTURA, ASU_AREA_RECEPCION, ASU_TIPO_ASUNTO, ";
		strSql +=	" ASU_ESTATUS, ASU_AVANCE, ASU_USR_TURNA, ASU_CONTROL, asu_lista_para, asu_lista_cc, ";
		strSql +=	" asu_listaids_para, asu_listaids_cc, ASU_LUGAR_EVENTO, ASU_FECHA_EVENTO, ASU_HORA_EVENTO, ASU_MIN_EVENTO,";
		strSql +=	" asu_lista_para_Ext, asu_listaids_para_Ext, ASU_TRAMITE, ASU_CONTROL_FOLIO) ";
		strSql +=	" VALUES (SD_ASUNTO_SEQ.NEXTVAL,"+strIdEntidad+", "+strIdRemitente+", ";
		strSql +=			" '"+strFirmante+"', '"+strAsunto+"', "+strIdExpediente+", ";
		//strSql +=			" "+strUbicacion+", '"+strReferencia+"', "+strIdTipoDocto+", ";
		strSql +=			" "+strIdTipoDocto+", ";
		//strSql +=			" "+strCategoria+",";
		if(strFechaRep == null){
			strSql +=			" null, ";
		}
		else{
			if (strFechaRep.length()>10){
				strSql +=	" TO_DATE('"+strFechaRep+"', 'DD/MM/YYYY HH24:MI:SS'), ";
			}else{
				strSql +=	" TO_DATE('"+strFechaRep+"', 'DD/MM/YYYY'), ";
			}
		}

		if(strFechaDoc == null){
			strSql +=			" null, ";
		}
		else{
			strSql +=			"TO_DATE('"+strFechaDoc+"', 'DD/MM/YYYY'), ";
		}

		if(strFechaCad == null){
			strSql +=			" null, ";
		}
		else{
			if (strFechaRep.length()>10){
				strSql +=	"TO_DATE('"+strFechaCad+"', 'DD/MM/YYYY HH24:MI:SS'), ";
			}else{
				strSql +=	"TO_DATE('"+strFechaCad+"', 'DD/MM/YYYY'), ";
			}
		}
		strSql +=			" '"+strFolioExt+"', '"+strFolioInt+"', '"+strSintesis+"', '"+strComentarios+"',";
		strSql +=			" '"+strPalabraClave+"','"+strAsuntoAnt+"', "+strIdPrioridad+", '"+FolioGenerado+"',";
		//strSql +=			" "+strUsUpdate+", '"+strFecUpdate+"', "+strAreaRecepcion+", "+strIdTipoAsunto+", ";
		strSql +=			" "+strUsUpdate+", SYSDATE, "+strAreaRecepcion+", "+strIdTipoAsunto+", ";
		//strSql +=			" "+strEstatus+", 0, "+strUsrTurnar+", "+strControl+", '"+strPara+"', '"+strCC+"', '"+strIdsPara+"', '"+strIdsCC+"', ";
		strSql +=			" "+strEstatus+", 0, "+strUsrTurnar+", "+strControl+", '', '', '"+strIdsPara+"', '"+strIdsCC+"', ";
		if(strLugarEvento == null){
			strSql +=	"null ,";
		}else{
			strSql += "'"+strLugarEvento+"' ,";
		}
		if(strFechaEvento == null){
			strSql +=	"null ,";
		}else{
			strSql += "TO_DATE('"+strFechaEvento + "', 'DD/MM/YYYY'), ";
		}
		if(stringHoraEvento.equals("-1")){
			strSql +=	"null, ";
		}else{
			strSql += ""+ stringHoraEvento + ", ";
		}
		if(stringMinEvento.equals("-1")){
			strSql +=	"null, ";
		}else{
			strSql += ""+ stringMinEvento + ", ";
		}
		//strSql += "'"+ strParaE+"', '"+strIdsParaE+"', ";
		strSql += "'', '"+strIdsParaE+"', ";
		if(strTramite.equals("-1")){
			strSql +=	"null, ";
		}else{
			strSql += ""+strTramite+", ";
		}
		strSql += ""+strTipoFolio+")";
				
		return strSql;
	}
    
    /**
     * Función que regresa un query para verificar si existen Asuntos
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExistenAsuntos(String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO " +
        		"WHERE ASU_ESTATUS=1 AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND USU_AREA="+strIdArea+" "+
        		"AND ID_USUARIO<>"+strIdUsuario+" " +
        		"";
        return strSql;
    }
    
    /**
     * Verifica si existen asuntos por Solicitante Externo 
     * @return Regresa un String con el Query correspondiente
     */
    public static String existenAsuntosPorSolicitanteExterno(){
    	String sql = "SELECT DISTINCT ASU_REMITENTE, ASU_CONTROL " +
        	"FROM SD_ASUNTO WHERE ASU_ESTATUS=1 AND ASU_CONTROL=0 ";
    	return sql;
    }
    
    /**
     * Función que regresa un query verificando si existen 
     * asuntos en tramite
     * @return strSql String Contiene el query
     */
    public static String getExistenAsuntosTramite(String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT DISTINCT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO " +
        		"WHERE ASU_ESTATUS=2 AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND USU_AREA="+strIdArea+" "+
        		"AND ID_USUARIO<>"+strIdUsuario+" ";
        return strSql;
    }
    
    /**
     * Función que regresa un query verificando si existen
     * asuntos terminados
     * @return strSql String Contiene el query
     */
    public static String getExistenAsuntosTerminado(String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT * FROM SD_ASUNTO, SD_USUARIO WHERE ASU_ESTATUS=3 " +
        		"AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
				"AND USU_AREA="+strIdArea+" "+
				"AND ID_USUARIO<>"+strIdUsuario+" ";
        return strSql;
    }
    
    /**
     * Función que regresa un query verificando si existen
     * asuntos dependiendo de la fecha
     * @param strFechaHoy String Contiene la fecha actual
     * @return String Contiene el query
     */
    public static String getExistenAsuntosHoy(String strFechaHoy)
    {
        String strSql = "";
        strSql = "SELECT * FROM SD_ASUNTO WHERE ASU_FECHA_CAPTURA='"+strFechaHoy+"'";
        return strSql;
    }
    
    /**
     * Función que regresa un query verificando si existen
     * asuntos de un turnador
     * @param strIdUsuario
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExistenMisAsuntos(String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO " +
        		"WHERE ASU_ESTATUS=1 AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND ASU_USR_TURNA="+strIdUsuario+" ";
        return strSql;
    }
    
    /**
     * Verifica la existencia de Asuntos el la pestaña de asuntos en Trámite
     * @param strIdUsuario	Id del Usuario que tiene asignado como turnador de un asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExistenMisAsuntosTramite(String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO " +
        		"WHERE ASU_ESTATUS=2 AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND ASU_USR_TURNA="+strIdUsuario+" ";
        return strSql;
    }
    
    /**
     * Verifica la existencia de Asuntos el la pestaña de asuntos Terminados
     * @param strIdUsuario	Id del Usuario que tiene asignado como turnador de un asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExistenMisAsuntosTerminados(String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO " +
        		"WHERE ASU_ESTATUS=3 AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND ASU_USR_TURNA="+strIdUsuario+" ";
        return strSql;
    }
    
    /**
     * Lista de Asuntos por atender
     * @param strOrden		Orden de la columna
     * @param strTipo		Tipo (Ascendente o descendente)
     * @param stridArea		Id del área
     * @param strIdUsuario	Id Usuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDatosAsunto(String strOrden, String tipo,
    									String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
        strSql+="ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, ASU_USUARIO_CAPTURA, ";
        strSql+="to_char(ASU_FECHA_CAPTURA, 'dd/MM/yyyy'), ASU_FOLIO_EXTERNO, ";
        strSql+="to_char(ASU_FECHA_RECEPCION, 'dd/MM/yyyy HH24:MI'), ";
    	strSql+="to_char(ASU_FECHA_DOCTO, 'dd/MM/yyyy') ";
        strSql+="FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD ";
        strSql+="ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO ";
        strSql+="WHERE  ASU_ESTATUS=1 ";
        strSql+="AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
        strSql+="AND USU_AREA="+strIdArea+" ";
        strSql+="AND ID_USUARIO<>"+strIdUsuario+" ";
		if(tipo.equals("1")){
			strSql+="ORDER BY LOWER(ASU_DESCRIPCION) "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 10 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY ASU_FECHA_RECEPCION "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}else if(tipo.equals("5")){
			strSql+="ORDER BY ASU_FECHA_DOCTO "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}
			return strSql;
    }
    
    /**
     * Función que ejecuta un query que muestra una lista de los asuntos de un 
     * turnador
     * @param strOrden		Orden de la columna
     * @param strTipo		Tipo (Ascendente o descendente)
     * @param strIdUsuario	Id Usuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDatosMisAsunto(String strOrden, String tipo,
											String strIdUsuario)
    {
    	String strSql = "";
    	strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
    	strSql+="ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, ASU_USUARIO_CAPTURA, ";
    	strSql+="to_char(ASU_FECHA_CAPTURA, 'dd/MM/yyyy'), ASU_FOLIO_EXTERNO, ";
    	strSql+="to_char(ASU_FECHA_RECEPCION, 'dd/MM/yyyy HH24:MI'), ";
    	strSql+="to_char(ASU_FECHA_DOCTO, 'dd/MM/yyyy'), ASU_FECHA_RECEPCION, ASU_FECHA_DOCTO ";
    	strSql+="FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD ";
    	strSql+="ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO ";
    	strSql+="WHERE ASU_ESTATUS=1 ";
    	strSql+="AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
    	strSql+="AND ASU_USR_TURNA="+strIdUsuario+" ";
    	if(tipo.equals("1")){
    		strSql+="ORDER BY LOWER(ASU_DESCRIPCION) "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
    	}else if(tipo.equals("2")){
    		strSql+="ORDER BY 4 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
    	}else if(tipo.equals("3")){
    		strSql+="ORDER BY 10 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
    	}else if(tipo.equals("4")){
    		strSql+="ORDER BY 13 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
    	}else if(tipo.equals("5")){
    		strSql+="ORDER BY 14 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
    	}
    	return strSql;
    }
    
    /**
     * Función que ejecuta un query que muestra una lista de los asuntos
     * que estan siendo en Trámite
     * @param strOrden		Orden de la columna
     * @param tipo			Tipo (Ascendente o descendente)
     * @param strIdUsuario	IdUsuario
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosMisAsuntosTramite(String strOrden, String tipo,
													String strIdUsuario)
    {
    	String strSql = "";
    	strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
    	strSql+="ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, TO_CHAR(ASU_FECHA_CADUCIDAD, 'yyyy-MM-dd'), ";
    	strSql+="TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), ASU_FOLIO_EXTERNO, ";
    	strSql+="TO_CHAR(ASU_FECHA_RECEPCION, 'dd/MM/yyyy HH24:MI'), ";
    	strSql+="TO_CHAR(ASU_FECHA_DOCTO, 'dd/MM/yyyy'), " +
    			"TO_CHAR(ASU_FECHA_CADUCIDAD, 'dd/MM/yyyy HH24:MI') ";
    	strSql+="FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD ";
    	strSql+="ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO ";
    	strSql+="WHERE ASU_ESTATUS=2 ";
    	strSql+="AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
    	strSql+="AND ASU_USR_TURNA="+strIdUsuario+" ";
    	if(tipo.equals("1")){
    		strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("2")){
    		strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("3")){
    		strSql+="ORDER BY 10 "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("4")){
    		strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("5")){
    		strSql+="ORDER BY ASU_FECHA_RECEPCION "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("6")){
    		strSql+="ORDER BY ASU_FECHA_DOCTO "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("7")){
    		strSql+="ORDER BY ASU_FECHA_CADUCIDAD "+strOrden+", 2 ASC ";
    	}
    	return strSql;
    }
    
    /**
     * Función que ejecuta un query que muestra una lista de los asuntos
     * que estan siendo en Trámite
     * @param strOrden		Orden de la columna
     * @param tipo			Tipo (Ascendente o descendente)
     * @param strIdArea		Id área
     * @param strIdUsuario	Id Usuario
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosAsuntoTramite(String strOrden, String tipo,
    											String strIdArea, String strIdUsuario)
    {
        String strSql = "";
      
        strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
        strSql+="ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, TO_CHAR(ASU_FECHA_CADUCIDAD, 'yyyy-MM-dd'), ";
        strSql+="TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), ASU_FOLIO_EXTERNO, ";
        strSql+="TO_CHAR(ASU_FECHA_RECEPCION, 'dd/MM/yyyy HH24:MI'), ";
    	strSql+="TO_CHAR(ASU_FECHA_DOCTO, 'dd/MM/yyyy'), " +
    			"TO_CHAR(ASU_FECHA_CADUCIDAD, 'dd/MM/yyyy HH24:MI') ";
        strSql+="FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD ";
        strSql+="ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO ";
        strSql+="WHERE ASU_ESTATUS=2 ";
        strSql+="AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
        strSql+="AND USU_AREA="+strIdArea+" ";
        strSql+="AND ID_USUARIO<>"+strIdUsuario+" ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 10 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("5")){
    		strSql+="ORDER BY ASU_FECHA_RECEPCION "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("6")){
    		strSql+="ORDER BY ASU_FECHA_DOCTO "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("7")){
    		strSql+="ORDER BY ASU_FECHA_CADUCIDAD "+strOrden+", 2 ASC ";
    	}
        return strSql;
    }
    
    /**
     * Lista de Asuntos en Trámite por atención
     * @param strOrden	Orden de la columna
     * @param tipo		Tipo (Ascendente o descendente)
     * @param strIdUs	Id Usuario
     * @return query
     */
    public static String getDatosAsuntoTramitePorAtencion(String strOrden, String tipo,
    														String stridUsuario)
    {
        String strSql = "";
        strSql = "SELECT A.ID_ASUNTO, A.ASU_DESCRIPCION, A.ASU_ESTATUS, A.ASU_FOLIO_RECEPCION, ";
        strSql+="A.ASU_AVANCE, U.USU_AREA, P.PRI_NUMERO_HEX, TO_CHAR(A.ASU_FECHA_CADUCIDAD, 'yyyy-MM-dd'), ";
        strSql+="TO_CHAR(A.ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), A.ASU_FOLIO_EXTERNO ";
        strSql+="FROM SD_ASUNTO A LEFT OUTER JOIN SD_PRIORIDAD P ";
        strSql+="ON A.ASU_PRIORIDAD=P.ID_PRIORIDADES, SD_USUARIO U, SD_INSTRUCCION_ASUNTO I ";
        strSql+="WHERE A.ASU_ESTATUS=2 ";
        strSql+="AND U.ID_USUARIO=A.ASU_USR_TURNA ";
        strSql+="AND A.ID_ASUNTO=I.ID_ASUNTO ";
        strSql+="AND INS_USUARIO="+stridUsuario+" ";
        strSql+="AND INS_ACCESO=1 ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 10 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}
        return strSql;
    }
    
    /**
     * Lista de Asuntos Terminados
     * @param strOrden		Orden de la columna
     * @param tipo			Tipo (Ascendente o descendente)
     * @param strIdArea		Id área
     * @param strIdUsuario	Id Usuario
     * @return strSql String Contiene el query
     */
    public static String getDatosAsuntoTerminado(String strOrden, String tipo,
    											String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
        strSql+=" ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, TO_CHAR(ASU_FECHA_REAL, 'dd/MM/yyyy HH24:mm:ss'), ASU_FOLIO_EXTERNO ";
        strSql+=" FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD";
        strSql+=" ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO";
        strSql+=" WHERE ASU_ESTATUS=3 ";
        strSql+=" AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA  ";
        strSql+="AND USU_AREA="+strIdArea+" ";
        strSql+="AND ID_USUARIO<>"+strIdUsuario+" ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY ASU_FECHA_REAL "+strOrden+", 2 ASC ";
		}
        return strSql;
    }
    
    /**
     * Lista de Asuntos terminados por turnador
     * @param strOrden		Orden de la columna
     * @param tipo			Tipo (Ascendente o descendente)
     * @param strIdUsuario	Id Usuario
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosMisAsuntosTerminado(String strOrden, String tipo, 
    												String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
        strSql+=" ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, TO_CHAR(ASU_FECHA_REAL, 'dd/MM/yyyy HH24:mm:ss'), ASU_FOLIO_EXTERNO ";
        strSql+=" FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD";
        strSql+=" ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO";
        strSql+=" WHERE ASU_ESTATUS=3 ";
        strSql+=" AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA  ";
        strSql+="AND ASU_USR_TURNA="+strIdUsuario+" ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY ASU_FECHA_REAL "+strOrden+", 2 ASC ";
		}
        return strSql;
    }
    
    /**
     * Lista de asuntos terminados por atención
     * @param strOrden	Orden de la columna
     * @param tipo		Tipo (Ascendente o descendente)
     * @param strIdUs	Id usuario
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDatosAsuntoTerminadoPorAtencion(String strOrden, String tipo, String strIdUs)
    {
        String strSql = "";
        strSql = "SELECT A.ID_ASUNTO, A.ASU_DESCRIPCION, A.ASU_ESTATUS, A.ASU_FOLIO_RECEPCION, ";
        strSql+=" A.ASU_AVANCE, U.USU_AREA, P.PRI_NUMERO_HEX, A.ASU_FECHA_REAL, A.ASU_FOLIO_EXTERNO ";
        strSql+=" FROM SD_ASUNTO A LEFT OUTER JOIN SD_PRIORIDAD P ";
        strSql+=" ON A.ASU_PRIORIDAD=P.ID_PRIORIDADES, SD_USUARIO U, SD_INSTRUCCION_ASUNTO I";
        strSql+=" WHERE A.ASU_ESTATUS=3 ";
        strSql+=" AND U.ID_USUARIO=A.ASU_USR_TURNA  ";
        strSql+=" AND A.ID_ASUNTO=I.ID_ASUNTO  ";
        strSql+=" AND INS_USUARIO="+strIdUs+" ";
        strSql+=" AND INS_ACCESO=1 ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 8 "+strOrden+", 2 ASC ";
		}
        return strSql;
    }
    
    /**
     * Lista de Asuntos de la fecha actual
     * @param strFechaHoy	Fecha Actual
     * @return strSql String Contiene el query
     */
    public static String getDatosAsuntoHoy(String strFechaHoy)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, USU_AREA FROM SD_ASUNTO, SD_USUARIO " +
        		"WHERE ASU_FECHA_CAPTURA='"+strFechaHoy+"'" +
        		" AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA" +
        		" ORDER BY 3";
        return strSql;
    }
    
    /**
     * Datos de un Asuntos al consultarse
     * @param strIdAsunto	Id del Asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAsuntos(String strIdAsunto)
    {
        String sql = "";
        sql = 	"SELECT ASU_ENTIDAD, ASU_ENTIDAD_OTRO, ASU_REMITENTE, ASU_REMITENTE_OTRO, ASU_FIRMANTE," +
        		" ASU_DESCRIPCION, ASU_EXPEDIENTE, ASU_EXPEDIENTE_OTRO, ASU_UBICACION, ASU_REF_EXPEDIENTE," +
        		" ASU_TIP_DOCTO, ASU_TIP_DOCTO_OTRO, ASU_CATEGORIA, to_char(ASU_FECHA_RECEPCION, 'yyyy-MM-dd')," +
        		" to_char(ASU_FECHA_DOCTO, 'yyyy-MM-dd'), to_char(ASU_FECHA_CADUCIDAD, 'yyyy-MM-dd'), " +
        		" ASU_FOLIO_EXTERNO, ASU_FOLIO_INTERMEDIO, ASU_SINTESIS, ASU_COMENTARIOS," +
        		" ASU_PALABRA_CLAVE, ASU_REF_ASUNTO_ANTERIOR, ASU_PRIORIDAD, ASU_FOLIO_RECEPCION," +
        		" ASU_USUARIO_CAPTURA, to_char(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), ASU_AREA_RECEPCION, ASU_TIPO_ASUNTO," +
        		" ASU_ESTATUS, ASU_AVANCE, ASU_USR_TURNA, USU_NOMBRE, USU_ASISTENTE, USU_JEFE, USU_CORREO, USU_CARGO, " +
        		" ASU_REMITENTE, ASU_REMITENTE, ASU_REMITENTE, ARE_NOMBRE, " +
        		" ASU_PRIORIDAD, ASU_TIP_DOCTO, ASU_TIPO_ASUNTO, ASU_RUTA_AUTOMATICA, USU_AREA, ASU_CONTROL," +
        		" asu_lista_para, asu_lista_cc, asu_listaids_para, asu_listaids_cc, ASU_LUGAR_EVENTO, to_char(ASU_FECHA_EVENTO,'yyyy-MM-dd'), ASU_HORA_EVENTO, ASU_MIN_EVENTO, " +
        		" asu_lista_para_Ext, asu_listaids_para_Ext, ASU_TRAMITE, ASU_CONTROL_FOLIO, " +
        		" TO_CHAR(ASU_FECHA_RECEPCION, 'HH24'), TO_CHAR(ASU_FECHA_RECEPCION, 'MI') " +
        		" FROM SD_ASUNTO, SD_USUARIO, SD_AREA " +
        		" WHERE ID_ASUNTO="+strIdAsunto+" " +
        		" AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		" AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA ";
        return sql;
    }
    
    /**
     * Actualiza el asunto
     * @param strIdEntidad		Id de la Entidad
	 * @param strIdRemitente	Id del Remitente
	 * @param strFirmante		Firmante del Asunto
	 * @param strAsunto			Descripción del Asunto
	 * @param strIdExpediente	Id del Expediente
	 * @param strIdTipoDocto	Id Tipo Docto.
	 * @param strFechaRep		Fecha de Recepción del Asunto
	 * @param strFechaDoc		Fecha del Documento
	 * @param strFechaCad		Fecha Compromiso del Asunto
	 * @param strFolioExt		Identificador del Documento
	 * @param strFolioInt		Folio Intermedio
	 * @param strSintesis		Descripción del Asunto
	 * @param strComentarios	Comentarios del Asunto
	 * @param strPalabraClave	Palabra Clave
	 * @param strAsuntoAnt		Referencia del Asunto
	 * @param strIdPrioridad	Id Prioridad
	 * @param FolioGenerado		Folio Generado
	 * @param strUsUpdate		Usuario que Actualizo el Asunto
	 * @param strFecUpdate		Fecha de Actualización
	 * @param strAreaRecepcion	área o UA de Recepción
	 * @param strIdTipoAsunto	Id Tipo Asunto
	 * @param strUsrTurnar		Id del Turnador o Ventanilla
	 * @param strControl		Control de un Asunto(0=Entidad, 1=UA ó área)
	 * @param strEstatus		Estatus del Asunto
	 * @param strPara			Lista de Para
	 * @param strCC				Lista de CC
	 * @param strIdsPara		Lista Ids Para
	 * @param strIdsCC			Lista Ids CC
	 * @param lugarEvento		Lugar de Evento
	 * @param stringHoraEvento	Hora de Recepción
	 * @param strFechaEvento	Fecha del Evento
	 * @param stringMinEvento	Minuto del Evento
	 * @param strParaE			Lista Para Destinatarios Externos
	 * @param strIdsParaE		Lista Ids Para Destinatarios Externos
	 * @param strTramite		Trámite de un Asunto
	 * @param strTipoFolio		Tipo de Folio
     * @return Regresa un String con el Query correspondiente
     */
    public static String getActualizarAsuntos(String strIdEntidad, String strIdRemitente,
								String strFirmante, String strAsunto, 
								String strIdExpediente, String strIdTipoDocto,String strFechaRep,
								String strFechaDoc, String strFechaCad, String strFolioExt, 
								String strFolioInt, String strSintesis, String strComentarios, 
								String strPalabraClave, String strAsuntoAnt, String strIdPrioridad,
								String strIdTipoAsunto, String strIdAsunto, int numero, 
								String strEstatus, String strFolioRep, String strPara, String strCC, 
								String strIdsPara, String strIdsCC, String lugarEvento, String stringHoraEvento, 
								String strFechaEvento, String stringMinEvento, String strParaE, String strIdsParaE,
								String strControl, String strTramite, String strIdDestinarario, String strTipoFolio)
    {
    	String strSql = "";
    	/*if(!strTramite.equals("-1")){
			strTramite = strTramite.substring(0,strTramite.indexOf("|"));
		}*/
    	if(numero == 0){

    		strSql += "UPDATE SD_ASUNTO SET ASU_ENTIDAD="+strIdEntidad+", ";
    		strSql += " ASU_REMITENTE="+strIdRemitente+", ";
    		strSql += " ASU_FIRMANTE='"+strFirmante+"', ASU_DESCRIPCION='"+strAsunto+"', ASU_EXPEDIENTE="+strIdExpediente+", ";
    		//strSql += " ASU_UBICACION="+strUbicacion+", ASU_REF_EXPEDIENTE='"+strReferencia+"', ";
    		//strSql += " ASU_CATEGORIA="+strCategoria+", ";
    		if(strFechaRep == null){
    		}else{
    			if (strFechaRep.length()>10){
        			strSql += " ASU_FECHA_RECEPCION=TO_DATE('"+strFechaRep+"', 'DD/MM/YYYY HH24:MI:SS'), ";
    			}else{
        			strSql += " ASU_FECHA_RECEPCION=TO_DATE('"+strFechaRep+"', 'DD/MM/YYYY'), ";
    			}
    		}

    		if(strFechaDoc == null){
    		}else{
    			strSql += " ASU_FECHA_DOCTO=TO_DATE('"+strFechaDoc+"', 'DD/MM/YYYY'),";
    		}

    		if(strFechaCad == null){
    		}else{
    			if (strFechaCad.length()>10){
        			strSql += " ASU_FECHA_CADUCIDAD=TO_DATE('"+strFechaCad+"', 'DD/MM/YYYY HH24:MI:SS'), ";
    			}else{
        			strSql += " ASU_FECHA_CADUCIDAD=TO_DATE('"+strFechaCad+"', 'DD/MM/YYYY'), ";
    			}
    		}
    		strSql += " ASU_FOLIO_EXTERNO='"+strFolioExt+"', ASU_FOLIO_INTERMEDIO='"+strFolioInt+"', ASU_SINTESIS='"+strSintesis+"', ASU_COMENTARIOS='"+strComentarios+"',";
    		strSql += " ASU_PALABRA_CLAVE='"+strPalabraClave+"', ASU_REF_ASUNTO_ANTERIOR='"+strAsuntoAnt+"', ASU_ESTATUS="+strEstatus+", ASU_USR_TURNA="+strIdDestinarario+", ";
    		//strSql += "asu_lista_para='"+strPara+"', asu_lista_cc='"+strCC+"', ";
    		strSql += "asu_listaids_para='"+strIdsPara+"', asu_listaids_cc='"+strIdsCC+"', ";
    		strSql += "ASU_LUGAR_EVENTO='"+lugarEvento+"', ";
    		if(strFechaEvento == null){
    			strSql +=	"ASU_FECHA_EVENTO=null ,";
    		}else{
    			strSql += "ASU_FECHA_EVENTO=TO_DATE('"+strFechaEvento+"', 'DD/MM/YYYY'), ";
    		}
    		if(stringHoraEvento.equals("-1")){
    			strSql +=	"ASU_HORA_EVENTO=null, ";
    		}else{
    			strSql += "ASU_HORA_EVENTO="+stringHoraEvento+", ";
    		}
    		if(stringMinEvento.equals("-1")){
    			strSql +=	"ASU_MIN_EVENTO=null, ";
    		}else{
    			strSql += "ASU_MIN_EVENTO="+stringMinEvento+", ";
    		}
    		//strSql += "ASU_HORA_EVENTO="+stringHoraEvento+" , ASU_MIN_EVENTO="+stringMinEvento+", ";
    		//strSql += "ASU_LISTA_PARA_EXT='"+strParaE+"', ASU_LISTAIDS_PARA_EXT='"+strIdsParaE+"', ASU_CONTROL="+strControl+", ";
    		strSql += "ASU_LISTA_PARA_EXT='', ASU_LISTAIDS_PARA_EXT='"+strIdsParaE+"', ASU_CONTROL="+strControl+", ";
    		if(strTramite.equals("-1")){
    			strSql +=	"ASU_TRAMITE=null, ";
    		}else{
    			strSql += "ASU_TRAMITE="+strTramite+", ";
    		}
			strSql += "ASU_CONTROL_FOLIO="+strTipoFolio+", ";
			strSql += "ASU_PRIORIDAD="+strIdPrioridad+", ASU_TIPO_ASUNTO="+strIdTipoAsunto+", ASU_TIP_DOCTO="+strIdTipoDocto+" ";
    		strSql += " WHERE ID_ASUNTO="+strIdAsunto;

    	}else if(numero == 1){

    		strSql += "UPDATE SD_ASUNTO SET ASU_ENTIDAD="+strIdEntidad+", ";
    		strSql += " ASU_REMITENTE="+strIdRemitente+", ";
    		strSql += " ASU_FIRMANTE='"+strFirmante+"', ASU_DESCRIPCION='"+strAsunto+"', ASU_EXPEDIENTE="+strIdExpediente+", ";
    		//strSql += " ASU_UBICACION="+strUbicacion+", ASU_REF_EXPEDIENTE='"+strReferencia+"', ";
    		//strSql += " ASU_CATEGORIA="+strCategoria+", ";
    		if(strFechaRep == null){
    		}else{
    			if (strFechaRep.length()>10){
        			strSql += " ASU_FECHA_RECEPCION=TO_DATE('"+strFechaRep+"', 'DD/MM/YYYY HH24:MI:SS'), ";
    			}else{
        			strSql += " ASU_FECHA_RECEPCION=TO_DATE('"+strFechaRep+"', 'DD/MM/YYYY'),";
    			}
    		}

    		if(strFechaDoc == null){
    			//	strSql += " ASU_FECHA_DOCTO='null' ,";
    		}else{
    			//strSql += " ASU_FECHA_DOCTO='"+strFechaDoc+"',";
    			strSql += " ASU_FECHA_DOCTO=TO_DATE('"+strFechaDoc+"', 'DD/MM/YYYY'), ";
    		}

    		if(strFechaCad == null){
    		}else{
    			if (strFechaCad.length()>10){
        			strSql += " ASU_FECHA_CADUCIDAD=TO_DATE('"+strFechaCad+"', 'DD/MM/YYYY HH24:MI:SS'), ";
    			}else{
        			strSql += " ASU_FECHA_CADUCIDAD=TO_DATE('"+strFechaCad+"', 'DD/MM/YYYY'), ";
    			}
    		}
    		strSql += " ASU_FOLIO_EXTERNO='"+strFolioExt+"', ASU_FOLIO_INTERMEDIO='"+strFolioInt+"', ASU_SINTESIS='"+strSintesis+"', ASU_COMENTARIOS='"+strComentarios+"',";
    		strSql += " ASU_PALABRA_CLAVE='"+strPalabraClave+"', ASU_REF_ASUNTO_ANTERIOR='"+strAsuntoAnt+"', ASU_TIP_DOCTO="+strIdTipoDocto+", ";

    		strSql += " ASU_PRIORIDAD="+strIdPrioridad+", ASU_TIPO_ASUNTO="+strIdTipoAsunto+", ASU_USR_TURNA="+strIdDestinarario+", ";
    		strSql += "ASU_ESTATUS="+strEstatus+", ASU_FOLIO_RECEPCION='"+strFolioRep+"', " ;
    		//strSql += "asu_lista_para='"+strPara+"', asu_lista_cc='"+strCC+"', ";
    		strSql += "asu_listaids_para='"+strIdsPara+"', asu_listaids_cc='"+strIdsCC+"', ";
    		strSql += "ASU_LUGAR_EVENTO='"+lugarEvento+"', ";
    		if(strFechaEvento == null){
    			strSql +=	"ASU_FECHA_EVENTO=null ,";
    		}else{
    			strSql += "ASU_FECHA_EVENTO=TO_DATE('"+strFechaEvento+"', 'DD/MM/YYYY'), ";
    		}
    		//		"ASU_FECHA_EVENTO=TO_DATE('"+strFechaEvento+"', 'DD/MM/YYYY'), ";
    		if(stringHoraEvento.equals("-1")){
    			strSql +=	"ASU_HORA_EVENTO=null, ";
    		}else{
    			strSql += "ASU_HORA_EVENTO="+stringHoraEvento+", ";
    		}
    		if(stringMinEvento.equals("-1")){
    			strSql +=	"ASU_MIN_EVENTO=null, ";
    		}else{
    			strSql += "ASU_MIN_EVENTO="+stringMinEvento+", ";
    		}
    		//strSql += "ASU_HORA_EVENTO="+stringHoraEvento+" , ASU_MIN_EVENTO="+stringMinEvento+", ";
    		//strSql += "ASU_LISTA_PARA_EXT='"+strParaE+"', ASU_LISTAIDS_PARA_EXT='"+strIdsParaE+"', ASU_CONTROL="+strControl+",  ";
    		strSql += "ASU_LISTA_PARA_EXT='', ASU_LISTAIDS_PARA_EXT='"+strIdsParaE+"', ASU_CONTROL="+strControl+",  ";
    		if(strTramite.equals("-1")){
    			strSql +=	"ASU_TRAMITE=null, ";
    		}else{
    			strSql += "ASU_TRAMITE="+strTramite+", ";
    		}
    		strSql += "ASU_CONTROL_FOLIO="+strTipoFolio+" ";
    		strSql += " WHERE ID_ASUNTO="+strIdAsunto;

    	}else if(numero == 2){
    		strSql += "UPDATE SD_ASUNTO SET ASU_EXPEDIENTE="+strIdExpediente+" ";
    		strSql += "WHERE ID_ASUNTO="+strIdAsunto;
    	}
		return strSql;
    }
    
    /**
     * Elimina un Asunto
     * @param strIdAsunto	Id Asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDeleteAsunto(String strIdAsunto)
    {
        String sql = "";
        //sql = "DELETE FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
        sql = "UPDATE SD_ASUNTO SET ASU_ESTATUS=4 WHERE ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * Función que regresa un String[][] con las fechas de un asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String AsuntosPorFecha()
    {
        String sql = "";
        sql = "SELECT DISTINCT TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd') FROM SD_ASUNTO " +
        	" WHERE ASU_ESTATUS=1 " +
        	" ORDER BY 1 ASC";
        return sql;
    }
    
    /**
     * Lista de asuntos por fecha de vencimiento
     * @return Regresa un String con el Query correspondiente
     */
    public static String AsuntosPorFechaRV()
    {
        String sql = "";
        sql = "SELECT DISTINCT TO_CHAR(ASU_FECHA_CADUCIDAD, 'yyyy-MM-dd') FROM SD_ASUNTO " +
        	" WHERE ASU_ESTATUS=1 ORDER BY 1 ASC";
        return sql;
    }
    
    /**
     * Lista de asuntos por fecha de asuntos en Trámite
     * @return Regresa un String con el Query correspondiente
     */
    public static String AsuntosPorFechaTV()
    {
        String sql = "";
        sql = "SELECT DISTINCT TO_CHAR(ASU_FECHA_CADUCIDAD, 'yyyy-MM-dd') FROM SD_ASUNTO " +
        	" WHERE ASU_ESTATUS=2 ORDER BY 1 ASC";
        return sql;
    }
    
    /**
     * Asuntos por solicitantes externos
     * @return Regresa un String con el Query correspondiente
     */
    public static String AsuntosPorSolicitanteExterno()
    {
        String sql = "";
        sql = "SELECT DISTINCT ASU_REMITENTE, ASU_CONTROL " +
        	"FROM SD_ASUNTO WHERE ASU_ESTATUS=1 AND ASU_CONTROL=0 " +
        	"ORDER BY 1";
        return sql;
    }
    
    /**
     * Asuntos por solicitantes internos
     * @return Regresa un String con el Query correspondiente
     */
    public static String AsuntosPorSolicitanteInternos()
    {
        String sql = "";
        sql = "SELECT DISTINCT ASU_REMITENTE, ASU_CONTROL " +
        	"FROM SD_ASUNTO WHERE ASU_ESTATUS=1 AND ASU_CONTROL=1 " +
        	"ORDER BY 1";
        return sql;
    }
    
    /**
     * * Asuntos por solicitante
     * @return query
     */
    public static String AsuntosPorSolicitanteT()
    {
        String sql = "";
        sql = "SELECT DISTINCT ASU_REMITENTE, ASU_CONTROL " +
        		"FROM SD_ASUNTO WHERE ASU_ESTATUS=2 AND ASU_CONTROL=1 " +
        		"ORDER BY 1";
        return sql;
    }
    
    /**
     * * Asuntos por solicitantes externos
     * @return Query
     */
    public static String AsuntosPorSolicitanteExternoT()
    {
        String sql = "";
        sql = "SELECT DISTINCT ASU_REMITENTE, ASU_CONTROL " +
        		"FROM SD_ASUNTO WHERE ASU_ESTATUS=2 AND ASU_CONTROL=0 " +
        		"ORDER BY 1";
        return sql;
    }
    
    /**
     * Lista de asuntos por folios
     * @param strIdAsunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String AsuntosPorFolio()
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, ASU_REMITENTE, ASU_ESTATUS, " +
        		"to_char(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), USU_AREA, ASU_CONTROL " +
        		"FROM SD_ASUNTO, SD_USUARIO WHERE ASU_ESTATUS=1 " +
        		"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
        		"ORDER BY 2 ASC";
        return sql;
    }
    
    /**
     * Asuntos por Folio en Trámite
     * @return	Arreglo de asuntos por folio en Trámite
     */
    public static String AsuntosPorFolioT()
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, " +
        		"ASU_REMITENTE, ASU_ESTATUS, to_char(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), ASU_CONTROL " +
        		"FROM SD_ASUNTO WHERE ASU_ESTATUS=2 ORDER BY 2 ASC";
        return sql;
    }
    
    /**
     * Asuntos por área
     * @return	Arreglo de asuntos por área
     */
    public static String AsuntosPorArea()
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_AREA FROM SD_ASUNTO WHERE ASU_ESTATUS=1 " +
        		"ORDER BY ASU_FOLIO_RECEPCION ASC";
        return sql;
    }
    
    /**
     * Asuntos por Recepción
     * @param strIdAsunto	Id Asunto
     * @return	Arreglo de asuntos en Recepción
     */
    public static String getAsuntosRep(String strIdAsunto)
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, ASU_REMITENTE, ASU_ESTATUS, " +
        		"TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd') FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto+" " +
        		"AND ASU_ESTATUS=1 ORDER BY 2 ASC";
        return sql;
    }
    
    /**
     * Función que regresa un query con algunos datos de la tabla de SD_ASUNTO
     * dependiendo del ID del Asunto y del Estatus de Recepción
     * @param strIdAsunto	Id Asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getRemitenteAsunto(String strControl, String strId, String strOrden, String strTipo)
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, ASU_REMITENTE, ASU_ESTATUS, " +
        		"to_char(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), ASU_FECHA_CAPTURA FROM SD_ASUNTO WHERE ASU_REMITENTE="+strId+ " AND ASU_CONTROL="+strControl+" " +
        		"AND ASU_ESTATUS=1 ORDER BY "+strTipo+" "+strOrden+", 2 ASC ";
        return sql;
    }
    
    /**
     * Función que regresa un query con algunos datos de la tabla de SD_ASUNTO
     * dependiendo del ID del Asunto y del Estatus de Turnado
     * @param strIdRemitente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getRemitenteAsuntoT(String strIdRemitente, String strOrden, String strTipo)
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, ASU_REMITENTE, ASU_ESTATUS, " +
        		"to_char(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), to_char(ASU_FECHA_CADUCIDAD, 'yyyy-MM-dd'), " +
        		"ASU_FECHA_CAPTURA, ASU_FECHA_CADUCIDAD " +
        		"FROM SD_ASUNTO WHERE ASU_REMITENTE="+strIdRemitente+ " " +
        		"AND ASU_ESTATUS=2 ORDER BY "+strTipo+" "+strOrden+", 2 ASC ";
        return sql;
    }
    
    /**
     * Asuntos por fecha
     * @param strIdRemitente Id Remitente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getFechaAsunto(String strfecha)
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, ASU_REMITENTE, ASU_ESTATUS, ASU_CONTROL " +
        		"FROM SD_ASUNTO WHERE ASU_FECHA_CAPTURA='"+Utilerias.formatearFechas(strfecha)+"' " +
        		"AND ASU_ESTATUS=1 ORDER BY 2 ASC";
        return sql;
    }
    
    /**
     * Asuntos por fecha
     * @param strfecha Fecha Actual
     * @return Regresa un String con el Query correspondiente
     */
    public static String getFechaAsuntoRV(String strfecha)
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, ASU_REMITENTE, ASU_ESTATUS " +
        		"FROM SD_ASUNTO WHERE ASU_FECHA_CADUCIDAD='"+strfecha+"' " +
        		"AND ASU_ESTATUS=1 ORDER BY 2 ASC";
        return sql;
    }
    
    /**
     * Asuntos por fecha en Trámite
     * @param strfecha	fecha actual
     * @return Regresa un String con el Query correspondiente
     */
    public static String getFechaAsuntoTV(String strfecha)
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, ASU_REMITENTE, ASU_ESTATUS " +
        		"FROM SD_ASUNTO WHERE ASU_FECHA_CADUCIDAD='"+strfecha+"' " +
        		"AND ASU_ESTATUS=2 ORDER BY 2 ASC";
        return sql;
    }
    
    /**
     * Función que regresa un query con una lista de ID de area a la
     * que pertenece un usuario
     * @return Query
     */
    public static String getIdsAreaPertenece()
    {
        String sql = "";
        sql = 	"SELECT DISTINCT USU_AREA FROM SD_USUARIO, SD_ASUNTO " +
        		"WHERE ASU_ESTATUS=1 " +
        		"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA";
        return sql;
    }
    
    /**
     * Función que regresa un query donde muestra el nombre del usuario
     * y su mail
     * @param strIdAsunto String Contiene el ID del usuario
     * @return Query
     */
    public static String getNombreCorreo(String strIdAsunto)
    {
        String sql = "";
        sql = 	"SELECT USU_NOMBRE, USU_CORREO " +
        		"FROM SD_ASUNTO, SD_USUARIO " +
        		"WHERE ID_ASUNTO="+strIdAsunto+" " +
        		"AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO";
        return sql;
    }
    
    /**
     * Función que regresa un query, donde se muestra el ultimo ID
     * de un asunto en la Tabla SD_ASUNTO
     * @return SELECT MAX(ID_ASUNTO) FROM SD_ASUNTO
     */
    public synchronized static String getUltimoIdAsunto()
    {
        String sql = "";
        sql = "SELECT MAX(ID_ASUNTO) FROM SD_ASUNTO";
        return sql;
    }
    
    /**
     * Folio de Recepción de un asunto
     * @param strIdAsunto	Id Asuntos
     * @return	Folio Recepción
     */
    public static String getFolioAsunto(String strIdAsunto){
        String sql = "SELECT ASU_FOLIO_RECEPCION FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * Folio de Recepción de un asunto 
     * @param strIdInstruccion	Id instrucción
     * @return	Folio Recepción
     */
    public static String getFolioAsuntoIns(String strIdInstruccion){
        String sql = "SELECT ASU_FOLIO_RECEPCION FROM SD_ASUNTO, SD_INSTRUCCION_ASUNTO " +
        		"WHERE SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO " +
        		"AND ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
        return sql;
    }
    
    /**
     * Fecha de Inicio de un asunto
     * @param strIdAsunto	Id Asunto
     * @return	Fecha de inicio
     */
    public static String getFechaInicioAsunto(String strIdAsunto){
        String sql ="SELECT TO_CHAR(ASU_FECHA_RECEPCION, 'yyyy-MM-dd') FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * Función que muestra una lista de los asutnos que no han sido turnados,
     * para que se determinen cuales estan atrasados
     * @param strIdArea Id del Area
     * @return Asuntos retrasados
     */
    public static String getAsuntosPorTurnarRetrasados(String strIdArea){
        
        String sql = "";
        if(strIdArea.equals("-1")){
            sql = "SELECT ID_ASUNTO, ARE_NOMBRE, ASU_DESCRIPCION, USU_NOMBRE, ASU_ESTATUS, " +
            	"TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO, " +
            	"ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC " +
				"FROM SD_ASUNTO, SD_AREA, SD_USUARIO " +
				"WHERE ASU_ESTATUS=1 " +
				"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
				"AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA " +
				"AND ASU_FECHA_CAPTURA IS NOT NULL " +
        		"ORDER BY 2";
        }else{
            sql = "SELECT ID_ASUNTO, ARE_NOMBRE, ASU_DESCRIPCION, USU_NOMBRE, ASU_ESTATUS, " +
            	"TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO, " +
            	"ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC " +
				"FROM SD_ASUNTO, SD_AREA, SD_USUARIO " +
            	"WHERE ASU_ESTATUS=1 AND ID_AREA="+strIdArea+" " +
            	"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
            	"AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA " +
            	"AND ASU_FECHA_CAPTURA IS NOT NULL " +
            	"ORDER BY 2";
        }
        return sql;
    }
    
    /**
     * Función que regresa un query, donde contabiliza cuantas instrucciones tiene
     * el asunto que no ha sido turnado
     * @param strIdAsunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountInstSinTurnar(String strIdAsunto){
        String sql = "SELECT COUNT(*) FROM SD_INSTRUCCION_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * Función que muestra una lista de los asutnos que estan siendo atendidos,
     * para que se determinen cuales estan atrasados
     * @param strIdArea Id del Area
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAsuntosEnTramiteRetrasados(String strIdArea){
        
        String sql = "";
        if(strIdArea.equals("-1")){
            sql = "SELECT ID_ASUNTO, ARE_NOMBRE, ASU_DESCRIPCION, USU_NOMBRE, ASU_ESTATUS, " +
            		"TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), TO_CHAR(ASU_FECHA_ESTIMADA, 'yyyy-MM-dd'), " +
            		"ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO,  " +
            		"ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC " +
					"FROM SD_ASUNTO, SD_AREA, SD_USUARIO " +
    				"WHERE ASU_ESTATUS=2 " +
    				"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
    				"AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA " +
    				"AND ASU_FECHA_CAPTURA IS NOT NULL " +
            		"AND ASU_FECHA_ESTIMADA IS NOT NULL " +
            		"ORDER BY 2";
        }else{
            sql = "SELECT ID_ASUNTO, ARE_NOMBRE, ASU_DESCRIPCION, USU_NOMBRE, ASU_ESTATUS, " +
            		"TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), TO_CHAR(ASU_FECHA_ESTIMADA, 'yyyy-MM-dd'), " +
            		"ASU_FOLIO_RECEPCION, ASU_FOLIO_EXTERNO,  " +
            		"ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC " +
					"FROM SD_ASUNTO, SD_AREA, SD_USUARIO " +
            		"WHERE ASU_ESTATUS=2 " +
            		"AND ID_AREA="+strIdArea+" " +
            		"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
            		"AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA " +
            		"AND ASU_FECHA_CAPTURA IS NOT NULL " +
            		"AND ASU_FECHA_ESTIMADA IS NOT NULL " +
            		"ORDER BY 2";
        }
        return sql;
    }
    
    /**
     * Función que regresa un query para verificar si existen Asuntos
     * en atención, el estatus es 0
     * @return strSql
     */
    public static String getExistenAsuntosEnAtencion()
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO FROM SD_ASUNTO WHERE ASU_ESTATUS=0";
        return strSql;
    }
    
    /**
     * Función que regresa un query donde muestra una lista de los asuntos 
     * en Recepción
     * @return strSql String Contiene el query
     */
    public static String getAsuntoEnAtencion(String strOrden, String strTipo)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
        strSql+="ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, ASU_USUARIO_CAPTURA, ASU_FECHA_CAPTURA, ASU_FOLIO_EXTERNO ";
        strSql+="FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD ";
        strSql+="ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO ";
        strSql+="WHERE  ASU_ESTATUS=0 ";
        strSql+="AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
		if(strTipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(strTipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(strTipo.equals("3")){
			strSql+="ORDER BY 10 "+strOrden+", 2 ASC ";
		}
        return strSql;
    }

    /**
     * Función que regresa un query donde muestra una lista de los asuntos 
     * en Recepción
     * @return strSql String Contiene el query
     */
    public static String getAsuntoEnAtencion(String strOrden, String strTipo, String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
        strSql+="ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, ASU_USUARIO_CAPTURA, ASU_FECHA_CAPTURA, ASU_FOLIO_EXTERNO ";
        strSql+="FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD ";
        strSql+="ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO ";
        strSql+="WHERE  ASU_ESTATUS=0 ";
        strSql+="AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
        strSql+="AND USU_AREA="+strIdArea+" ";
		if(strTipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(strTipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(strTipo.equals("3")){
			strSql+="ORDER BY 10 "+strOrden+", 2 ASC ";
		}
        return strSql;
    }
    
    /**
     * Función que tres la lsita de los usuarios para y cc de cada asunto, para
     * ser cargados al applet
     * @param strIdAsunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getParaCC(String strIdAsunto){
    	String sql = "";
    	//sql = "SELECT ASU_LISTA_PARA, ASU_LISTA_CC, ASU_LISTAIDS_PARA, ASU_LISTAIDS_CC, ASU_TIP_DOCTO " +
    	//		"FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
    	sql = "SELECT ASU_LISTA_PARA, ASU_LISTA_CC, ASU_LISTAIDS_PARA, " +
    			"ASU_LISTAIDS_CC, ASU_TIP_DOCTO, USU_AREA, ASU_LISTAIDS_PARA_EXT " +
    			"FROM SD_ASUNTO, SD_USUARIO WHERE ID_ASUNTO="+strIdAsunto+" " +
    			"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA";
    	return sql;
    }
    
    /**
     * Funcipon que arroja un query para verificar si existe el folio del
     * documento
     * @param strFolio
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExisteFolioExterno(String strFolio, String strFechaDoc, 
    											String strControl, String strEntidad,
												String strRemitente, String idArea){
    	String sql = "SELECT ID_ASUNTO FROM SD_ASUNTO WHERE ASU_FOLIO_EXTERNO='"+strFolio+"' " +
    			"AND ASU_FECHA_DOCTO=TO_DATE('"+strFechaDoc+"','DD/MM/YYYY') " +
    			"AND ASU_CONTROL="+strControl+" AND ASU_ENTIDAD="+strEntidad+" " +
    			"AND ASU_REMITENTE="+strRemitente+" AND ASU_ESTATUS<>4 AND ASU_AREA_RECEPCION<>"+idArea; 
    	return sql;
    }
    
    /**
     * Verifica si existe folio de salida de un asunto
     * @param strIdAsunto	Id Asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExisteFolioSalidaAsunto(String strIdAsunto){
    	String sql = "SELECT ASU_FOLIO_ENTRADA FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto+"";
    	return sql;
    }
    
    /**
     * Clave del área para le foleo del asunto
     * @param strIdAsunto	Id Asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAreaFoleo(String strIdAsunto){
    	String sql = "SELECT ID_AREA, ARE_CLAVE FROM SD_ASUNTO, SD_USUARIO, SD_AREA " +
    			"WHERE SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
    			"AND SD_USUARIO.USU_AREA=SD_AREA.ID_AREA " +
    			"AND ID_ASUNTO="+strIdAsunto;
    	return sql;
    }
    
    /**
     * Folio de entrada
     * @param strFolio		Folio de entrada
     * @param stridAsunto	Id Asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String setFolioEntrada(String strFolio ,String stridAsunto){
    	String sql = "UPDATE SD_ASUNTO SET ASU_FOLIO_ENTRADA='"+strFolio+"' WHERE ID_ASUNTO="+stridAsunto;
    	return sql;
    }
    
    /**
     * Descripción de asunto e identificador del área
     * @param strIdAsunto	Id Asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAsuntoFoleo(String strIdAsunto){
    	String sql = "SELECT ASU_DESCRIPCION, ASU_FOLIO_EXTERNO, ASU_ESTATUS " +
    			"FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
    	return sql;
    }
    
    /**
     * Descripción de asunto e identificador del área
     * @param strIdAsunto	Id Asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAsuntoRecuperado(String strIdAsunto){
    	String sql = "SELECT ASU_DESCRIPCION, ASU_FOLIO_RECEPCION " +
    			"FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
    	return sql;
    }
    
    /**
    * Insertar la relación de asuntos
    * @param strIdsAsunto 	Ids Asuntos de relación
    * @param strIdAsunto	Id Asuntos al que se le relacionan
    * @return strSql
    */
    public static String InsertarAsuntosAnt(String strIdsAsunto, String strIdAsunto)
    {
        String strSql = "";
        strSql = "INSERT INTO SD_ASUNTOS__ANT (ID_ASUNTO, ID_ASUNTOS_REL) VALUES (" +strIdAsunto + 
		" , '" + strIdsAsunto + "')" ;
        return strSql;
    }
    
    /**
     * Actualiza un registro cuando se envia notificación de terminación de asunto
     * y no se envíen mas notificaciones
     * @param strIdAsunto Id Asunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getUpdateMail(String strIdAsunto){
    	String sql = "UPDATE SD_ASUNTO SET ASU_MAIL=1 WHERE ID_ASUNTO="+strIdAsunto;
    	return sql;
    }
    
    /**
     * Lista de asuntos 
     * @param idAsunto	Id Asuntos
     * @return query
     */
    public static String getIdsAsuntosAnt(String idAsunto)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTOS_REL FROM SD_ASUNTOS__ANT " +
				 "WHERE ID_ASUNTO = " + idAsunto ;
        return strSql;
    }
    
    /**
     * Lista de asuntos referenciados
     * @param idAsunto	id Asuntos
     * @return query
     */
    public static String getIdsAsuntosRef(String idAsunto)
    {
        String strSql = "";
        strSql = "SELECT TIPO_REF FROM SD_ASUNTOS__ANT " +
				 "WHERE ID_ASUNTO = " + idAsunto ;
        return strSql;
    }
    
    /**
     * Lista de Ids de referencias
     * @param strIdAsunto	Id Asunto
     * @return query
     */
    public static String getidsAsunt(String idAsunto){
    	
        String strSql = "";
        strSql = "SELECT ID_ASUNTOS_REL,TIPO_REF  FROM SD_ASUNTOS_ANEX " +
				 "WHERE ID_ASUNTO = " + idAsunto ;
        return strSql;
    
    }
    
    /**
     * Función que regresa un query para verificar si existen Asuntos
     * @return strSql
     */
    public static String EliminarAsuntosAnt(String strIdAsunto)
    {
        String strSql = "";
        strSql = "DELETE FROM SD_ASUNTOS__ANT WHERE ID_ASUNTOS_REL  = " + strIdAsunto ;
        return strSql;
    }
    
    /**
     * Lista de asuntos referenciados
     * @param strIdAsunto	Id Asunto
     * @return query
     */
    public static String getAsuntosAnt(String idAsunto)
    {
        String strSql = "";
        strSql = "SELECT id_asuntos_rel, " +
        		"CASE TIPO_REF WHEN 'r' THEN 'Respuesta' WHEN 'f' THEN 'Referencia' WHEN 'a' THEN 'Alcance' END AS REFERENCIA " +
        		"FROM SD_ASUNTOS__ANT " +
				 "WHERE ID_ASUNTO = "+idAsunto+" ORDER BY 1";
        return strSql;
    }
    
    /**
     * Lista de ids asuntos referenciados
     * @param strIdAsunto	id Asuntos
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAsuntosAntRef(String idAsunto){
    	
        String strSql = "";
        strSql = "SELECT CASE TIPO_REF WHEN 'r' THEN 'Respuesta' WHEN 'f' THEN 'Referencia' WHEN 'a' THEN 'Alcance'" +
        		"FROM SD_ASUNTOS__ANT " +
				 "WHERE ID_ASUNTO = " + idAsunto ;
        return strSql;
    
    }
    
    /**
     * Función que regresa un query para verificar si existen Asuntos
     * @return strSql
     */
    public static String InsertarAsuntosAnt(String strIdsAsunto, String strIdAsunto, String strAsuntoRef)
    {
        String strSql = "";
        strSql = "INSERT INTO SD_ASUNTOS__ANT (ID_ASUNTO, ID_ASUNTOS_REL, TIPO_REF) VALUES (" +strIdAsunto + 
		" , '" + strIdsAsunto + " ','" + strAsuntoRef +"')" ;
        return strSql;
    }
    
    /**
     * Función que regresa un query para verificar si existen Asuntos
     * @return strSql
     */
    public static String InsertarAsuntosAnex(String strIdsAsunto, String strIdAsunto, String strAsuntoRef)
    {
        String strSql = "";
        strSql = "INSERT INTO SD_ASUNTOS_ANEX (ID_ASUNTO, ID_ASUNTOS_REL, TIPO_REF) VALUES (" +strIdAsunto + 
		" , '" + strIdsAsunto + " ','" + strAsuntoRef +"')" ;
        return strSql;
    }
    
    /**
     * Asunto anexo 
     * @param strIdAsunto Id asunto
     * @return Query
     */
    public static String EliminaAsuntosAnexRef(String strIdAsunto)
    {
        String strSql = "";
        strSql = "DELETE FROM  SD_ASUNTOS_ANEX  WHERE id_asunto = " + strIdAsunto ; 
        return strSql;
    }
    
    /**
     * Elimina anexo
     * @param strIdAsunto id asunto
     * @return Query
     */
    public static String EliminaAsuntosAnex(String strIdAsunto)
    {
        String strSql = "";
        strSql = "DELETE FROM  SD_ASUNTOS__ANT WHERE id_asunto = " + strIdAsunto ; 
        return strSql;
    }
    
    /**
	 * Consulta la fecha compromiso de un asunto
	 * @param strIdAsunto
	 * @return Regresa un String con el Query correspondiente
	 */
	public static String getFechaVencimiento(String strIdAsunto){
		String sql = "SELECT TO_CHAR(ASU_FECHA_CADUCIDAD, 'dd/MM/yyyy') FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
		return sql;
	}
	
	/**
	 * Verifia si un usuario tiene acceso a un asunto
     * @param strIdAsunto	Id Asunto
     * @param strIdUsuario	Id Usuario
	 * @return query
	 */
    public static String getAccesoAsunto(String strIdAsunto, String strIdUsuario){
    	
        String strSql = "";
        strSql = "SELECT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO " +
        		"WHERE ID_ASUNTO = "+strIdAsunto+" AND INS_USUARIO = "+strIdUsuario+" AND INS_ACCESO = 1";
        return strSql;
    }
       
    /**
     * Ids de ruta de acceso
     * @param strIdAsunto	Id Asunto
     * @return query
     */
    public static String getIdsRutaAcceso(String strIdAsunto){
    	
        String strSql = "";
        strSql = "SELECT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO " +
        		"WHERE ID_ASUNTO = "+strIdAsunto+" AND INS_ACCESO = 1";
        return strSql;
    }
       
    /**
     * Control de un asunto para verificar si viene de una entidad o un área interna	
     * @param strIdAsunto	Id Asunto
     * @return query
     */
    public static String getControl(String strIdAsunto)
    {
        String sql = "";
        sql = "SELECT ASU_CONTROL FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * Lista de asuntos por folio
     * @param strIdArea	Id área
     * @param orden		Orden del campo
     * @param tipo		Tipo de orden
     * @return query
     */
    public static String AsuntosPorFolio(String strIdArea, String orden, String tipo)
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, ASU_REMITENTE, ASU_ESTATUS, " +
        		"to_char(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), USU_AREA, ASU_CONTROL " +
        		"FROM SD_ASUNTO, SD_USUARIO WHERE ASU_ESTATUS=1 " +
        		"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
        		"AND USU_AREA="+strIdArea+" " +
        		"ORDER BY "+tipo+" "+orden+", 2 ASC ";
        return sql;
    }
    
    /**
     * Asuntos por folio en Trámite
     * @param orden	Orden de la columna
     * @param tipo	Orden
     * @return Regresa un String con el Query correspondiente
     */
    public static String AsuntosPorFolioT(String strIdArea, String orden, String tipo)
    {
        String sql = "";
        sql = 	"SELECT ID_ASUNTO, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, " +
        		"ASU_REMITENTE, ASU_ESTATUS, to_char(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), ASU_CONTROL " +
        		"FROM SD_ASUNTO, SD_USUARIO WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
        		"AND ASU_ESTATUS=2 AND USU_AREA="+strIdArea+" ORDER BY "+tipo+" "+orden+", 2 ASC ";
        return sql;
    }
    
    /**
     * Regresa los asuntos segun su remitente 
     * @param strIdUsuario ID Usuario
     * @param strOrden Orden 
     * @param tipo Tipo de ordenamiento 
     * @param stridArea ID de la UA
     * @return String con el query 
     */
    public static String getAsuntosSolicitados(String strIdusuario, String strOrden, 
    										String tipo, String strIdArea){
    	String sql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_FOLIO_RECEPCION, " +
    					"ASU_AVANCE, ASU_FOLIO_EXTERNO, ASU_ESTATUS, USU_CARGO " +
    					"FROM SD_ASUNTO, SD_USUARIO " +
    					"WHERE ASU_REMITENTE="+strIdusuario+" " +
    					"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USUARIO_CAPTURA " +
    					"AND ASU_CONTROL=1 AND USU_AREA="+strIdArea+" ";
    	
    	if(tipo.equals("1")){
    		sql+="ORDER BY LOWER(ASU_DESCRIPCION) "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}else if(tipo.equals("2")){
			sql+="ORDER BY 3 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC  ";
		}else if(tipo.equals("3")){
			sql+="ORDER BY 5 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC  ";
		}else if(tipo.equals("4")){
			sql+="ORDER BY 4 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC  ";
		}else if(tipo.equals("5")){
			sql+="ORDER BY 7 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC  ";
		}
		
    	return sql;
    }
    
    /**
     * Regresa los asuntos segun su remitente 
     * @param strIdUsuario ID Usuario
     * @param strOrden Orden 
     * @param tipo Tipo de ordenamiento 
     * @param stridArea ID de la UA
     * @return String con el query 
     */
    public static String getAsuntosSolicitadosOtrasUA(String strIdusuario, String strOrden, 
    										String tipo, String strIdArea){
    	String sql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_FOLIO_RECEPCION, " +
    					"ASU_AVANCE, ASU_FOLIO_EXTERNO, ASU_ESTATUS, USU_CARGO " +
    					"FROM SD_ASUNTO, SD_USUARIO " +
    					"WHERE ASU_REMITENTE="+strIdusuario+" " +
    					"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USUARIO_CAPTURA " +
    					"AND ASU_CONTROL=1 AND USU_AREA<>"+strIdArea+" ";
    	
    	if(tipo.equals("1")){
    		sql+="ORDER BY LOWER(ASU_DESCRIPCION) "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}else if(tipo.equals("2")){
			sql+="ORDER BY 3 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC  ";
		}else if(tipo.equals("3")){
			sql+="ORDER BY 5 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC  ";
		}else if(tipo.equals("4")){
			sql+="ORDER BY 4 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC  ";
		}else if(tipo.equals("5")){
			sql+="ORDER BY 7 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC  ";
		}
		
    	return sql;
    }
    
    /**
     * verifica si existen asuntos solicitados por el remitente interno 
     * @param strIdUsuario	Id Usuario
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExistenAsuntosSolicitadas(String strIdUsuario, String strIdArea){
    	String sql = "SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO " +
    			"WHERE ASU_REMITENTE="+strIdUsuario+" AND ASU_CONTROL=1 " +
    			"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_REMITENTE AND USU_AREA="+strIdArea;
    	return sql;
    }
    
    /**
     * Función que liga a asuntos que tengan ligados respuestas, alcances, etc
     * @param strIdAsunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAsuntosLigados(String strIdAsunto){
    	String strSql = "SELECT id_asunto, " +
    			"CASE tipo_ref WHEN 'r' THEN 'Respuesta' WHEN 'f' THEN 'Referencia' WHEN 'a' THEN 'Alcance' END AS REFERENCIA " +
    			"FROM SD_ASUNTOS__ANT WHERE ID_ASUNTOS_REL="+strIdAsunto;
    	return strSql;
    }
    
    /**
     * Construye un query para regresar el Estatus del Asunto
     * @param strIdAsunto
     * @return Regresa un String con el Query correspondiente
     */
    public static String getEstatus(String strIdAsunto){
    	String strSql = "SELECT ASU_ESTATUS " +
    			"FROM SD_ASUNTO " +
    			"WHERE ID_ASUNTO = " + strIdAsunto;
//        //System.out.println("Estatus: "+strSql);
    	return strSql;
    }
    
    /**
     * Obtiene el avance de una asunto
     * @param strIdAsunto
     * @return Query
     */
    public static String getAvanceAsunto(String strIdAsunto){
        String sql = "SELECT ASU_AVANCE FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    
    /**
     * Query que regresa el id del turnador de un asunto
     * @param strIdAsunto Id del asunto
     * @return Query
     */
    public static String getAsuntoTurnado(String strIdAsunto){
    	String sql = "SELECT ASU_USR_TURNA FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
    	return sql;
    }

    /**
     * Query que regresa el id del turnador de un asunto
     * @param strIdAsunto Id del asunto
     * @return Query
     */
    public static String getTieneTramite(String strIdAsunto){
    	String sql = "SELECT ASU_TRAMITE FROM SD_ASUNTO WHERE ID_ASUNTO="+strIdAsunto;
    	return sql;
    }
    
    /**
     * Turnadores del área, no muestra al usuario que consulta
     * @param idArea id de la unidad administrativa
     * @param idusuario id del usuario que no se tomara en cuenta
     * @return Turnadores de la ua
     */
    public static String getTurnadoreUnidad(String idArea, String idusuario){
    	/*String sql = "SELECT ID_USUARIO, USU_CARGO || '/' || USU_NOMBRE " +
    			"FROM SD_USUARIO, SD_AREA, SD_USUARIO_ROL " +
    			"WHERE USU_ESTATUS=1 AND ID_ROL=5 " +
    			"AND USU_ACTIVO=1 " +
    			"AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA " +
    			"AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO " +
    			"AND ID_AREA="+idArea+" " +
    			"AND ID_USUARIO<>"+idusuario+" " +
    			"ORDER BY USU_CARGO";*/
    	String sql = "SELECT distinct ASU_USR_TURNA, USU_CARGO || '/' || USU_NOMBRE " +
    			"FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD " +
    			"ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO " +
    			"WHERE ASU_ESTATUS=1 " +
    			"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
    			"AND USU_AREA="+idArea+"" +
    			"AND ID_USUARIO<>"+idusuario+"" +
				"ORDER BY 2 ";
    			
    	return sql;
    }
    
    /**
     * Verifica si existen asuntos por el turnador
     * @param strIdArea Id ua
     * @param strIdUsuario usuario turnador
     * @return query
     */
    public static String existeAsuntoTurnadorAtender(String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO " +
        		"WHERE ASU_ESTATUS=1 AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND USU_AREA="+strIdArea+" "+
        		"AND ID_USUARIO="+strIdUsuario+" ";
        return strSql;
    }
    
    /**
     * Lista de Asuntos por atender
     * @param strOrden		Orden de la columna
     * @param strTipo		Tipo (Ascendente o descendente)
     * @param stridArea		Id del área
     * @param strIdUsuario	Id Usuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String datosAsuntoTurnadorAtender(String strOrden, String tipo,
    												String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
        strSql+="ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, ASU_USUARIO_CAPTURA, ";
        strSql+="to_char(ASU_FECHA_CAPTURA, 'dd/MM/yyyy'), ASU_FOLIO_EXTERNO, ";
        strSql+="to_char(ASU_FECHA_RECEPCION, 'dd/MM/yyyy HH24:MI'), ";
    	strSql+="to_char(ASU_FECHA_DOCTO, 'dd/MM/yyyy') ";
        strSql+="FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD ";
        strSql+="ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO ";
        strSql+="WHERE  ASU_ESTATUS=1 ";
        strSql+="AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
        strSql+="AND USU_AREA="+strIdArea+" ";
        strSql+="AND ID_USUARIO="+strIdUsuario+" ";
		if(tipo.equals("1")){
			strSql+="ORDER BY LOWER(ASU_DESCRIPCION) "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 10 "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY ASU_FECHA_RECEPCION "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}else if(tipo.equals("5")){
			strSql+="ORDER BY ASU_FECHA_DOCTO "+strOrden+", LOWER(ASU_DESCRIPCION) ASC ";
		}
			return strSql;
    }
    
    /**
     * Turnadores del área, no muestra al usuario que consulta
     * @param idArea id de la unidad administrativa
     * @param idusuario id del usuario que no se tomara en cuenta
     * @return Turnadores de la ua
     */
    public static String getTurnadoreUnidadTramite(String idArea, String idusuario){
    	/*String sql = "SELECT ID_USUARIO, USU_CARGO || '/' || USU_NOMBRE " +
    			"FROM SD_USUARIO, SD_AREA, SD_USUARIO_ROL " +
    			"WHERE USU_ESTATUS=1 AND ID_ROL=5 " +
    			"AND USU_ACTIVO=1 " +
    			"AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA " +
    			"AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO " +
    			"AND ID_AREA="+idArea+" " +
    			"AND ID_USUARIO<>"+idusuario+" " +
    			"ORDER BY USU_CARGO";*/
    	String sql = "SELECT distinct ASU_USR_TURNA, USU_CARGO || '/' || USU_NOMBRE " +
    			"FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD " +
    			"ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO " +
    			"WHERE ASU_ESTATUS=2 " +
    			"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
    			"AND USU_AREA="+idArea+"" +
    			"AND ID_USUARIO<>"+idusuario+"" +
				"ORDER BY 2 ";
    			
    	return sql;
    }
    
    /**
     * Verifica si existen asuntos por el turnador
     * @param strIdArea Id ua
     * @param strIdUsuario usuario turnador
     * @return query
     */
    public static String existeAsuntoTurnadorTramite(String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO " +
        		"WHERE ASU_ESTATUS=2 AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND USU_AREA="+strIdArea+" "+
        		"AND ID_USUARIO="+strIdUsuario+" ";
        return strSql;
    }
    
    /**
     * Lista de Asuntos por atender
     * @param strOrden		Orden de la columna
     * @param strTipo		Tipo (Ascendente o descendente)
     * @param stridArea		Id del área
     * @param strIdUsuario	Id Usuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String datosAsuntoTurnadorTramite(String strOrden, String tipo,
    												String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
        strSql+="ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, TO_CHAR(ASU_FECHA_CADUCIDAD, 'yyyy-MM-dd'), ";
        strSql+="TO_CHAR(ASU_FECHA_CAPTURA, 'yyyy-MM-dd'), ASU_FOLIO_EXTERNO, ";
        strSql+="TO_CHAR(ASU_FECHA_RECEPCION, 'dd/MM/yyyy HH24:MI'), ";
    	strSql+="TO_CHAR(ASU_FECHA_DOCTO, 'dd/MM/yyyy'), " +
    			"TO_CHAR(ASU_FECHA_CADUCIDAD, 'dd/MM/yyyy HH24:MI') ";
        strSql+="FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD ";
        strSql+="ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO ";
        strSql+="WHERE ASU_ESTATUS=2 ";
        strSql+="AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA ";
        strSql+="AND USU_AREA="+strIdArea+" ";
        strSql+="AND ID_USUARIO="+strIdUsuario+" ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 10 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("5")){
    		strSql+="ORDER BY ASU_FECHA_RECEPCION "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("6")){
    		strSql+="ORDER BY ASU_FECHA_DOCTO "+strOrden+", 2 ASC ";
    	}else if(tipo.equals("7")){
    		strSql+="ORDER BY ASU_FECHA_CADUCIDAD "+strOrden+", 2 ASC ";
    	}
		return strSql;
    }
    
    /**
     * Turnadores del área, no muestra al usuario que consulta
     * @param idArea id de la unidad administrativa
     * @param idusuario id del usuario que no se tomara en cuenta
     * @return Turnadores de la ua
     */
    public static String getTurnadoreUnidadTerminado(String idArea, String idusuario){
    	/*String sql = "SELECT ID_USUARIO, USU_CARGO || '/' || USU_NOMBRE " +
    			"FROM SD_USUARIO, SD_AREA, SD_USUARIO_ROL " +
    			"WHERE USU_ESTATUS=1 AND ID_ROL=5 " +
    			"AND USU_ACTIVO=1 " +
    			"AND SD_AREA.ID_AREA=SD_USUARIO.USU_AREA " +
    			"AND SD_USUARIO_ROL.ID_USUARIO1=SD_USUARIO.ID_USUARIO " +
    			"AND ID_AREA="+idArea+" " +
    			"AND ID_USUARIO<>"+idusuario+" " +
    			"ORDER BY USU_CARGO";*/
    	String sql = "SELECT distinct ASU_USR_TURNA, USU_CARGO || '/' || USU_NOMBRE " +
    			"FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD " +
    			"ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO " +
    			"WHERE ASU_ESTATUS=3 " +
    			"AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
    			"AND USU_AREA="+idArea+"" +
    			"AND ID_USUARIO<>"+idusuario+"" +
				"ORDER BY 2 ";
    			
    	return sql;
    }
    
    /**
     * Verifica si existen asuntos por el turnador
     * @param strIdArea Id ua
     * @param strIdUsuario usuario turnador
     * @return query
     */
    public static String existeAsuntoTurnadorTerminado(String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO FROM SD_ASUNTO, SD_USUARIO " +
        		"WHERE ASU_ESTATUS=3 AND SD_ASUNTO.ASU_USR_TURNA=SD_USUARIO.ID_USUARIO " +
        		"AND USU_AREA="+strIdArea+" "+
        		"AND ID_USUARIO="+strIdUsuario+" ";
        return strSql;
    }
    
    /**
     * Lista de Asuntos por atender
     * @param strOrden		Orden de la columna
     * @param strTipo		Tipo (Ascendente o descendente)
     * @param stridArea		Id del área
     * @param strIdUsuario	Id Usuario
     * @return	Regresa un String con el Query correspondiente
     */
    public static String datosAsuntoTurnadorTerminado(String strOrden, String tipo,
    												String strIdArea, String strIdUsuario)
    {
        String strSql = "";
        strSql = "SELECT ID_ASUNTO, ASU_DESCRIPCION, ASU_ESTATUS, ASU_FOLIO_RECEPCION, ";
        strSql+=" ASU_AVANCE, USU_AREA, PRI_NUMERO_HEX, TO_CHAR(ASU_FECHA_REAL, 'dd/MM/yyyy HH24:mm:ss'), ASU_FOLIO_EXTERNO ";
        strSql+=" FROM SD_ASUNTO LEFT OUTER JOIN SD_PRIORIDAD";
        strSql+=" ON SD_ASUNTO.ASU_PRIORIDAD=SD_PRIORIDAD.ID_PRIORIDADES, SD_USUARIO";
        strSql+=" WHERE ASU_ESTATUS=3 ";
        strSql+=" AND SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA  ";
        strSql+="AND USU_AREA="+strIdArea+" ";
        strSql+="AND ID_USUARIO="+strIdUsuario+" ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY ASU_FECHA_REAL "+strOrden+", 2 ASC ";
		}
		return strSql;
    }
    
    /**
     * Acceso al pool de turnadores, verificando si es el área a la que
     * es el rol de atención
     * @param idArea Id área
     * @param idAsunto Id Asunto
     * @return query
     */
    public static String getAccesoTurnadores(String idArea, String idAsunto){
    	String sql = "SELECT USU_AREA FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO " +
    			"WHERE ID_ASUNTO="+idAsunto+" " +
    			"AND SD_INSTRUCCION_ASUNTO.INS_USUARIO=SD_USUARIO.ID_USUARIO " +
    			"AND USU_AREA="+idArea+" AND INS_PADRE IS NULL";
    	return sql;
    }
    
    /**
     * Trae la hora de la base de datos
     * @return
     */
    public static String getHora(){
    	String sql = "SELECT TO_CHAR(SYSDATE, 'HH24')FROM DUAL";
    	return sql;
    }
    
    /**
     * Funcipon que arroja un query para verificar si existe el folio del
     * documento
     * @param strFolio
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExisteFolioExternoRepTur(String strFolio, String strFechaDoc, 
    											String strControl, String strEntidad,
												String strRemitente, String idArea){
    	String sql = "SELECT ID_ASUNTO FROM SD_ASUNTO WHERE ASU_FOLIO_EXTERNO='"+strFolio+"' " +
    			"AND ASU_FECHA_DOCTO=TO_DATE('"+strFechaDoc+"','DD/MM/YYYY') " +
    			"AND ASU_CONTROL="+strControl+" AND ASU_ENTIDAD="+strEntidad+" " +
    			"AND ASU_REMITENTE="+strRemitente+" AND ASU_ESTATUS=1"; 
    	return sql;
    }
    
    
}

