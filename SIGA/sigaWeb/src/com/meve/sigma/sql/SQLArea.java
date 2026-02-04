/*
 * Created on Sep 14, 2005
 */
package com.meve.sigma.sql;

/**
 * SQLArea es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_AREA
 * 
 * @author Meve Soluciones SA de CV
 *
 */
public class SQLArea {
    
    /**
     * Inserta la Unidad Administrativa del sistema
     * @param id			Id del área
     * @param nombre		Nombre del área
     * @param descripcion	Descripción del área
     * @param idResponsable	Id Responsable del área
     * @param fechaUpdate	Fecha de Actualización
     * @param UsUpdate		Usuario que actualizo
     * @param estatus		Estatus del área
     * @param horaEntrada	Hora de entrada
     * @param horaSalida	Hora de salida
     * @param minEntrada	Minuto de entrada
     * @param minSalida		Minuto de salida
     * @param bandera		Bandera para determinar si el área opera en el sistema
     * @param strClave		Clave del área
     * @param strIdPadre	Id del área padre del área
     * @param strEnt		Número consecutivo para el folio de control
     * @param strSal		Año para el folio de control
     * @param strBandera	Bandera para determinar si el área opera en el sistema
     * @param strSubVent	Subventanilla
     * @return Regresa un String con el Query correspondiente
     */
    public static String getInsertaArea(String nombre, String descripcion, String idResponsable,
            							String fechaUpdate, String usUpdate, String estatus,
										String horaEntrada, String horaSalida, 
										String minEntrada, String minSalida, int bandera,
										String strClave, String strIdPadre, String strEnt, 
										String strSal, String strBandera, String strSubVent)
    {
    	String sql = "";
    	if(bandera == 0){
        sql = 	"INSERT INTO SD_AREA (ID_AREA,ARE_NOMBRE, ARE_DESCRIPCION, ARE_SUPERVISOR," +
        				" ARE_FEC_ACTUALIZACION, ARE_USR_ACTUALIZO, ARE_ESTATUS, ARE_HR_ENTRADA, ARE_HR_SALIDA, " +
        				" ARE_MIN_ENTRADA, ARE_MIN_SALIDA, ARE_CLAVE, ARE_ID_PADRE, ARE_ENTRADA, ARE_SALIDA, ARE_BANDERA, ARE_SUBVENTANILLA) " +
        				" VALUES (SD_AREA_SEQ.NEXTVAL,'"+nombre+"', '"+descripcion+"', "+idResponsable+", SYSDATE, " +
        				" "+usUpdate+", "+estatus+", "+horaEntrada+", "+horaSalida+", "+minEntrada+", "+minSalida+", " +
        				" '"+strClave+"', "+strIdPadre+", "+strEnt+", "+strSal+", "+strBandera+", "+strSubVent+")";
    	}else{
    	sql = 	"INSERT INTO SD_AREA (ID_AREA,ARE_NOMBRE, ARE_DESCRIPCION, ARE_SUPERVISOR," +
						" ARE_FEC_ACTUALIZACION, ARE_USR_ACTUALIZO, ARE_ESTATUS, ARE_HR_ENTRADA, ARE_HR_SALIDA, " +
						" ARE_MIN_ENTRADA, ARE_MIN_SALIDA, ARE_LOGO, ARE_CLAVE, ARE_ID_PADRE, ARE_ENTRADA, ARE_SALIDA, ARE_BANDERA, ARE_SUBVENTANILLA) " +
						" VALUES (SD_AREA_SEQ.NEXTVAL,'"+nombre+"', '"+descripcion+"', "+idResponsable+", SYSDATE, " +
						" "+usUpdate+", "+estatus+", "+horaEntrada+", "+horaSalida+", "+minEntrada+", "+minSalida+", ?)";	
    	}
        
        return sql;
    }
    
    /**
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAreaCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA " +
				"WHERE ARE_ESTATUS=1 AND ARE_BANDERA=0 ORDER BY ARE_NOMBRE";												
		return strSql;	
	}
    
    /**
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAreaComboListDes()
	{
		String strSql="";		
		strSql=	"SELECT DISTINCT USU_AREA, ARE_NOMBRE, ARE_BANDERA " +
				"FROM SD_USUARIO, SD_USUARIO_ROL, SD_AREA " +
				"WHERE USU_ESTATUS = 1 " +
				"AND ARE_ESTATUS=1 " +
				"AND SD_USUARIO.ID_USUARIO = SD_USUARIO_ROL.ID_USUARIO1 " +
				"AND SD_USUARIO_ROL.ID_ROL = 5 " +
				"AND SD_AREA.ID_AREA = SD_USUARIO.USU_AREA " +
				"ORDER BY ARE_NOMBRE ";												
		return strSql;	
	}
    
    public static String getAreaComboExcluyeId(String strIdArea)
	{
		String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA " +
				"WHERE ARE_ESTATUS=1 AND ARE_BANDERA=0 AND ID_AREA<>"+strIdArea+" ORDER BY ARE_NOMBRE";												
		return strSql;	
	}
    
    /**
     * 
     * @param IdArea
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAreaCombo(String IdArea)
	{
		String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA WHERE ARE_ESTATUS=1 " +
				"AND ID_AREA="+IdArea+" ORDER BY ARE_NOMBRE";												
		return strSql;	
	}

    /**
     * Lista de las áreas del sistema
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAreas(String strOrden, String tipo, String strOrdenExt, String tipoExt)
	{
		String strSql="";		
		strSql=	" SELECT ARE_NOMBRE, ID_AREA, USU_NOMBRE, USU_CARGO ";
		strSql+="FROM SD_AREA LEFT OUTER JOIN SD_USUARIO ";
		strSql+="ON SD_AREA.ARE_SUPERVISOR=SD_USUARIO.ID_USUARIO ";
		strSql+="WHERE ARE_ESTATUS=1 ";
		strSql+="ORDER BY "+tipo+" "+strOrden+", 1 ASC ";
		return strSql;	
	}
    
    /**
     * área o Ua por su ID
     * @param idArea	Id del área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getArea(String idArea)
	{
		String strSql="";		
		strSql=	" SELECT ARE_NOMBRE, ARE_DESCRIPCION, ARE_SUPERVISOR, ARE_HR_ENTRADA, " 
			+"ARE_HR_SALIDA, ARE_MIN_ENTRADA, ARE_MIN_SALIDA, ARE_CLAVE, ARE_ID_PADRE," 
			+"ARE_ENTRADA, ARE_SALIDA, ARE_USR_ACTUALIZO, " 
			+"TO_CHAR(ARE_FEC_ACTUALIZACION, 'DD/MM/YYYY HH:MI:SS AM'), ARE_BANDERA, ARE_SUBVENTANILLA " 
			+", ARE_CANONICAL "
			+"FROM SD_AREA WHERE ARE_ESTATUS=1 AND ID_AREA="+idArea; 
		return strSql;	
	}
    
    /**
     * Elimina registros de varias áreas
     * @param strIds ID área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDeleteArea(String strIds)
	{
    	String strSql="";
		strSql=	" UPDATE SD_AREA SET ARE_ESTATUS=0, ARE_FEC_ACTUALIZACION=SYSDATE WHERE ID_AREA IN ("+strIds+")";
			
		return strSql;
	}
    
    /**
     * 
     * @param strId
     * @return Regresa un String con el Query correspondiente
     */
    public static String findAreas(String strId)
	{
		String strSql="";		
		strSql=	" SELECT ID_AREA FROM SD_AREA WHERE ARE_ESTATUS=1 AND ARE_NOMBRE='"+strId+"'"; 
		return strSql;	
	}
    
    /**
     * Inserta la Unidad Administrativa del sistema
     * @param id			Id del área
     * @param nombre		Nombre del área
     * @param descripcion	Descripción del área
     * @param idResponsable	Id Responsable del área
     * @param fechaUpdate	Fecha de Actualización
     * @param UsUpdate		Usuario que actualizo
     * @param estatus		Estatus del área
     * @param horaEntrada	Hora de entrada
     * @param horaSalida	Hora de salida
     * @param minEntrada	Minuto de entrada
     * @param minSalida		Minuto de salida
     * @param bandera		Bandera para determinar si el área opera en el sistema
     * @param strClave		Clave del área
     * @param strIdPadre	Id del área padre del área
     * @param strEnt		Número consecutivo para el folio de control
     * @param strSal		Año para el folio de control
     * @param strBandera	Bandera para determinar si el área opera en el sistema
     * @param strSubVent	Subventanilla
     * @return Regresa un String con el Query correspondiente
     */
    public static String getActualizaArea(	String strId, String strArea, String strDescripcion, 
            								String strResponsable, String strCreador1, 
            								String strFechaCreacion, String strEstatus,
											String horaEntrada, String horaSalida, 
											String minEntrada, String minSalida, int bandera,
											String strClave, String strIdPadre, String strEnt, 
											String strSal, String strBandera, String strSubVent)
    {
    	String sql = "";
    	if(bandera == 0){
    		sql =	"UPDATE SD_AREA SET ARE_NOMBRE='"+strArea+"', ARE_DESCRIPCION='"+strDescripcion
			+"', ARE_SUPERVISOR="+strResponsable+", ARE_USR_ACTUALIZO="+strCreador1+", " +
			//"ARE_FEC_ACTUALIZACION='"+strFechaCreacion+"', ARE_ESTATUS="+strEstatus+", " +
			//"ARE_FEC_ACTUALIZACION=TO_DATE('"+strFechaCreacion+"','DD/MM/YYYY'), " +
			"ARE_FEC_ACTUALIZACION=SYSDATE, " +
			"ARE_ESTATUS="+strEstatus+", " +
			"ARE_HR_ENTRADA="+horaEntrada+", ARE_HR_SALIDA="+horaSalida+", " +
			"ARE_MIN_ENTRADA="+minEntrada+" , ARE_MIN_SALIDA="+minSalida+"," +
			"ARE_CLAVE='"+strClave+"', ARE_ID_PADRE="+strIdPadre+", ARE_ENTRADA="+strEnt+", " +
			"ARE_SALIDA="+strSal+", " +
			"ARE_BANDERA="+strBandera+", ARE_SUBVENTANILLA="+strSubVent+" " +
			"WHERE "+"ID_AREA IN ("+ strId + ")";
    	}else{
    		sql =	"UPDATE SD_AREA SET ARE_NOMBRE='"+strArea+"', ARE_DESCRIPCION='"+strDescripcion
			+"', ARE_SUPERVISOR="+strResponsable+", ARE_USR_ACTUALIZO="+strCreador1+", " +
			//"ARE_FEC_ACTUALIZACION='"+strFechaCreacion+"', ARE_ESTATUS="+strEstatus+", " +
			"ARE_FEC_ACTUALIZACION=TO_DATE('"+strFechaCreacion+"','DD/MM/YYYY'), ARE_ESTATUS="+strEstatus+", " +
			"ARE_HR_ENTRADA="+horaEntrada+", ARE_HR_SALIDA="+horaSalida+", " +
			"ARE_MIN_ENTRADA="+minEntrada+" , ARE_MIN_SALIDA="+minSalida+", ARE_LOGO=? " +
			"WHERE "+"ID_AREA IN ("+ strId + ")";
    	}
    	return sql;
	}
    
    /**
     * Nombre del área para formar el folio
     * @param idUsuario	Id usuario
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAreaFolio(String idArea)
    {
        String strSql = "";
        strSql	=	"SELECT ARE_NOMBRE FROM SD_AREA WHERE ID_AREA="+idArea;
        return strSql;
    }
    
    /**
     * Nombre del área
     * @param idArea	Id Area
     * @return Regresa un String con el Query correspondiente
     */
    public static String NombreArea(String idArea)
	{
	    String strSql="";		
		strSql=	"SELECT ARE_NOMBRE FROM SD_AREA WHERE ID_AREA="+idArea+"";
		return strSql;
	}
    
    /**
     * Función que devuelve un query con la información del responsable del área
     * @param strIdArea String Contiene el ID del Area
     * @return Regresa un String con el Query correspondiente strSql Query
     */
    public static String getIDArea(String strIdArea)
    {
        String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE, USU_NOMBRE, USU_CARGO, ARE_SUPERVISOR " +
				"FROM SD_AREA, SD_USUARIO " +
				"WHERE ID_AREA="+strIdArea+" " +
				"AND SD_USUARIO.ID_USUARIO=SD_AREA.ARE_SUPERVISOR ";
		return strSql;
    }
    
    /**
     * Función que devuelve un query que trae una lista de 
     * los usuarios que formen parte del área
     * @param idArea String Contiene el ID del área
     * @return Regresa un String con el Query correspondiente strSql Query
     */
    public static String getMiembrosArea(String idArea)
    {
        String strSql="";		
		strSql=	"SELECT ID_USUARIO, USU_NOMBRE, USU_CARGO FROM SD_USUARIO " +
				"WHERE USU_AREA="+idArea+" AND USU_ESTATUS=1 ORDER BY 2";
		return strSql;
    }
    
    /**
     * Función que regresa el ID del área
     * @param idArea Contiene el ID del área
     * @return Regresa un String con el Query correspondiente Query
     */
    public static String getIdArea(String idArea)
    {
        String sql = "";
        sql = "";
        return sql;
    }
    
    /**
     * devuelve el nombre y el Id del area para la busqueda del potal ciudadano
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAreasCiudadano(){
        String sql = "SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA WHERE ARE_ESTATUS=1 AND ID_AREA <> 0 ORDER BY 2";
        return sql;
    }
    
    /**
     * Función que regresa un query con el id del área padre
     * @param strIdArea
     * @return Regresa un String con el Query correspondiente
     */
    public static String getIdArePadre(String strIdArea){
    	String sql = "SELECT ARE_ID_PADRE FROM SD_AREA WHERE ID_AREA="+strIdArea;
    	return sql;
    }
    
    /**
     * Actualiza la entrada del folio de un área
     * @param iConsecutivo	Consewcutivo
     * @param strIdArea	Id Area
     * @return Regresa un String con el Query correspondiente
     */
    public static String actualizaEntrada(String strConse, String strIdArea){
    	String sql = "";
    	sql = "UPDATE SD_AREA SET ARE_ENTRADA="+strConse+" WHERE ID_AREA="+strIdArea;
    	return sql;
    }
    
    /**
     * Actualiza la salida del folio de un área
     * @param iConsecutivo
     * @param strIdArea
     * @return Regresa un String con el Query correspondiente
     */
    public static String actualizaSalida(String strConse, String strIdArea){
    	String sql = "";
    	sql = "UPDATE SD_AREA SET ARE_SALIDA="+strConse+" WHERE ID_AREA="+strIdArea;
    	return sql;
    }
    
    /**
     * Número consecutivo de entrada 
     * @param strIdArea	Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getEntrada(String strIdArea){
    	String sql = "SELECT ARE_ENTRADA FROM SD_AREA WHERE ID_AREA="+strIdArea;
    	return sql;
    }
    
    /**
     * Número consecutivo de salida
     * @param strIdArea
     * @return Regresa un String con el Query correspondiente
     */
    public static String getSalida(String strIdArea){
    	String sql = "SELECT ARE_SALIDA FROM SD_AREA WHERE ID_AREA="+strIdArea;
    	return sql;
    }
    
    /**
     * Total de áreas
     * @param strIdArea	Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountAreas(String strIdArea){
    	String sql = "SELECT COUNT(*) FROM SD_USUARIO WHERE USU_AREA="+strIdArea+" AND USU_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Función que regresa un query para verificar si el area tiene a cargo otras
     * @param strIdArea
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountIdPadre(String strIdArea){
    	String sql = "SELECT COUNT(ID_AREA) FROM SD_AREA WHERE ARE_ID_PADRE="+strIdArea+" AND ARE_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Número de asuntos por área
     * @param strIdArea	Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountAsuntosArea(String stridArea){
    	String sql = "SELECT COUNT(*) FROM SD_USUARIO, SD_ASUNTO " +
    			"WHERE SD_USUARIO.ID_USUARIO=SD_ASUNTO.ASU_USR_TURNA " +
    			"AND USU_AREA="+stridArea+" AND ASU_CONTROL=1";
    //	//System.out.println("getCountAsuntosArea="+sql);
    	return sql;
    }
    
    /**
     * Verifica si existe el área con estatus 1
     * @param strArea	Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAreaExiste(String strArea){
    	String sql = "SELECT ARE_NOMBRE FROM SD_AREA WHERE LOWER(ARE_NOMBRE) = LOWER('"+strArea+"')";
    	return sql;
    }
    
    /**
     * Query que verifica la existencia de un área por su nombre
     * @param strArea	área nueva
     * @param strArea2	área anterior
     * @return	Query
     */
    public static String getAreaExiste(String strArea, String strArea2){
    	String sql = "SELECT ARE_NOMBRE FROM SD_AREA " +
    			"WHERE LOWER(ARE_NOMBRE) = LOWER('"+strArea+"') " +
    			"AND LOWER(ARE_NOMBRE) <> LOWER('"+strArea2+"') " +
    			"AND ARE_ESTATUS = 1";
    	return sql;
    }
    
    /**
     * Query con el Número de destinatarios por área 
     * @param strIdArea	id área
     * @return	Query
     */
    public static String getCountDestExt(String strIdArea){
    	String sql = "SELECT COUNT(DES_AREA) FROM SD_DESTINATARIO WHERE DES_AREA="+strIdArea+" AND DES_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Total de entidades
     * @param strIdArea Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountEntidad(String strIdArea){
    	String sql = "SELECT COUNT(ENT_AREA) FROM SD_ENTIDAD WHERE ENT_AREA="+strIdArea+" AND ENT_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Total remitentes
     * @param strIdArea Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountRemitente(String strIdArea){
    	String sql = "SELECT COUNT(RMT_AREA) FROM SD_REMITENTE WHERE RMT_AREA="+strIdArea+" AND RMT_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Total Trámites
     * @param strIdArea Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountTramites(String strIdArea){
    	String sql = "SELECT COUNT(TRA_AREA) FROM SD_TRAMITE WHERE TRA_AREA="+strIdArea+" AND TRA_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Total tipo de documentos
     * @param strIdArea Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountTipoDoc(String strIdArea){
    	String sql = "SELECT COUNT(TIP_DOCTO_AREA) FROM SD_TIPO_DOCUMENTO WHERE TIP_DOCTO_AREA="+strIdArea+" AND TIP_DOCTO_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Total tipo de asuntos
     * @param strIdArea Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountTipoAsunto(String strIdArea){
    	String sql = "SELECT COUNT(TIP_ASU_AREA) FROM SD_TIPO_ASUNTO WHERE TIP_ASU_AREA="+strIdArea+" AND TIP_ASU_ESTATUS=1";
    	return sql;
    }

    /**
     * Total prioridad
     * @param strIdArea Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountPrioridad(String strIdArea){
    	String sql = "SELECT COUNT(PRI_AREA) FROM SD_PRIORIDAD WHERE PRI_AREA="+strIdArea+" AND PRI_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Total folios
     * @param strIdArea Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountFolios(String strIdArea){
    	String sql = "SELECT COUNT(FOL_AREA) FROM SD_FOLIO WHERE FOL_AREA="+strIdArea+" AND FOL_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Total Ubicación
     * @param strIdArea Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountUbicacion(String strIdArea){
    	String sql = "SELECT COUNT(UBI_AREA) FROM SD_UBICACION WHERE UBI_AREA="+strIdArea+" AND UBI_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Total Ruta
     * @param strIdArea Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountRuta(String strIdArea){
    	String sql = "SELECT COUNT(RUT_AUT_AREA) FROM SD_RUTA_AUTOMATICA WHERE RUT_AUT_AREA="+strIdArea+" AND RUT_AUT_ESTATUS=1";
    	return sql;
    }
    
    /**
     * Total de instrucciones
     * @param strIdArea Id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountInstruccion(String strIdArea){
    	String sql = "SELECT COUNT(INS_AREA) FROM SD_INSTRUCCION WHERE INS_AREA="+strIdArea+" AND INS_ESTATUS1=1";
    	return sql;
    }
    
    /**
     * Total de instrucciones rechazadas
     * @param strIdArea id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountRechazo(String strIdArea){
    	String sql = "SELECT COUNT(INS_AREA) FROM SD_INSTRUCCION WHERE INS_AREA="+strIdArea+" AND INS_ESTATUS1=1";
    	return sql;
    }
    
    /**
     * Estatus del área
     * @param strIdArea	id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getEstatusArea(String strIdArea)
    {
        String sql = "";
        sql = "SELECT ARE_ESTATUS FROM SD_AREA WHERE ID_AREA="+strIdArea;
        return sql;
    }
    
    /**
     * Horario área
     * @param strIdArea id área
     * @return Regresa un String con el Query correspondiente
     */
    public static String getHorarioArea(String strIdArea)
    {
        String sql = "";
        sql = "SELECT ARE_HR_ENTRADA, ARE_MIN_ENTRADA, ARE_HR_SALIDA, ARE_MIN_SALIDA FROM SD_AREA WHERE ID_AREA="+strIdArea;
        return sql;
    }
    
    /**
     * todas las áreas
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAreaComboAll()
	{
		String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA " +
				"WHERE ARE_ESTATUS=1 ORDER BY ARE_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Lista de áreas externas
     * @return Regresa un String con el Query correspondiente
     */
    public static String getAreaComboExternas()
	{
		String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA " +
				"WHERE ARE_ESTATUS=1 AND ARE_BANDERA=1 ORDER BY ARE_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Función que regresa un query para verificar si es una
     * área externa
     * @param strIdArea
     * @return Regresa un String con el Query correspondiente
     */
    public static String getEsAreaExterna(String strIdArea){
    	String sql = "SELECT ARE_BANDERA FROM SD_AREA WHERE ID_AREA="+strIdArea;
    	return sql;
    }
    
    /**
     * Verifica si el área o UA se le podra configurar 
     * manejo de subventanilla
     * @param strIdArea Id del área o UA
     * @return String Query con el campo de Subventanilla 
     */
    public static String getSubventanilla(String strIdArea){
    	String sql = "SELECT ARE_SUBVENTANILLA FROM SD_AREA WHERE ID_AREA="+strIdArea;
    	return sql;
    }
    
    /**
     * verifica los horarios del área a la
     * que pertenece el usuario que turna
     * @param idUs id del usuario
     * @return
     */
    public static String getHorarioUsuario(String idUs){
    	String sql = "SELECT ID_AREA, ARE_HR_ENTRADA, ARE_HR_SALIDA " +
    				"FROM SD_AREA, SD_USUARIO " +
    				"WHERE SD_AREA.ID_AREA=SD_USUARIO.USU_AREA " +
    				"AND ID_USUARIO="+idUs;
    	return sql;
    }
    
    /**
     * Verifica si el usuario es el responsable de una UA
     * @param idArea id área
     * @param idUsuario id usuario
     * @return query
     */
    public static String esEncargadoUA(String idArea, String idUsuario){
    	String sql = "SELECT COUNT(*) FROM SD_AREA WHERE ID_AREA="+idArea+" AND ARE_SUPERVISOR="+idUsuario+" ";
    	return sql;
    }
 
}