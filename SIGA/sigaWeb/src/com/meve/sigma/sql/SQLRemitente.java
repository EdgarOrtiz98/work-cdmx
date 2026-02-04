/*
 * Created on Sep 19, 2005
 */
package com.meve.sigma.sql;

/**
 * Clase para generar codigo SQL para Remitentes
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class SQLRemitente {
    
	/**
	 * Construye un SQL Query para Insertar remitentes en la Base de Datos
	 * 
	 * @param nombre Nombre 
	 * @param cargo Cargo 
	 * @param strArea Unidad administrativa
	 * @param idEntidad Entidad 
	 * @param telefono Telefono 
	 * @param correo Correo Electronico
	 * @param UsUpdate Usuario que actualizo 
	 * @param FechaUpdate Fecha de Actualización
	 * @param estatus Estatus 
	 * @param direccion Direccion fisica 
	 * @param fax Fax
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getInsertaRemitente(	String nombre, String strArea, String cargo,
            									String idEntidad, String telefono,
												String correo, String UsUpdate, String FechaUpdate,
												String estatus, String direccion, String fax)
    {
        String sql =	"INSERT INTO SD_REMITENTE (ID_REMITENTE, RMT_NOMBRE, RMT_AREA, RMT_CARGO, RMT_ENTIDAD," +
        " RMT_TELEFONO, RMT_CORREO, RMT_USR_ACTUALIZO, RMT_FEC_ACTUALIZACION, RMT_ESTATUS, RMT_DIRECCION, RMT_FAX) " +
        " VALUES (SD_REMITENTE_SEQ.NEXTVAL,'"+nombre+"', "+strArea+", '"+cargo+"', "+idEntidad+", '"+telefono+"', " +
        //" '"+correo+"',"+UsUpdate+", '"+FechaUpdate+"', "+estatus+", '"+direccion+"', '"+fax+"')";
        " '"+correo+"',"+UsUpdate+", SYSDATE, "+estatus+", '"+direccion+"', '"+fax+"')";

        return sql;
    }

    /**
     * Construye un SQL Query para Regresar una lis ta de remitentes ordenados por Nombre
     * @return Regresa un String con el Query correspondiente 
     */
    public static String getRemitenteCombo()
    {
        String strSql="";		
		strSql=	"SELECT ID_REMITENTE, RMT_NOMBRE FROM SD_REMITENTE ORDER BY RMT_NOMBRE";												
		return strSql;	
    }
    
    /**
     * Construye un SQL Query para Regresar una lista de Remitentes por UA
     * @param strIdArea Unidad Administrativa 
     * @return Regresa un String con el Query correspondiente 
     */
    public static String getRemitenteAreaCombo(String strIdArea)
    {
        String strSql = "";
        strSql = "SELECT ID_REMITENTE, RMT_NOMBRE, RMT_CARGO, RMT_CORREO FROM SD_REMITENTE WHERE RMT_AREA="+strIdArea+" ORDER BY RMT_NOMBRE";
        return strSql;
    }
    
    /**
     * Construye un SQL Query para Regresar una lista de Remitentes por Entidad
     * @param strIdEntidad Entidad
     * @return Regresa un String con el Query correspondiente
     */
    public static String getRemitenteFrame(String strIdEntidad)
    {
        String strSql = "";
        strSql = "SELECT ID_REMITENTE, RMT_NOMBRE, RMT_CARGO, RMT_CORREO " +
        		"FROM SD_REMITENTE WHERE RMT_ENTIDAD="+strIdEntidad+" " +
        		"ORDER BY RMT_NOMBRE";
        return strSql;
    }
    
    /**
     * Construye un SQL Query para Regresar una lista de Remitentes por Unidad Administrativa
     * @param strIdArea Unidad Administrativa
     * @return Regresa un String con el Query correspondiente
     */
    public static String getRemitenteInternas(String strIdArea)
    {
        String sql = "";
        sql = "SELECT ID_USUARIO, USU_NOMBRE, USU_CARGO, USU_CORREO " +
        		"FROM SD_USUARIO WHERE USU_AREA="+strIdArea+" " +
        		"ORDER BY 2";
        return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar una lista de Remitentes ordenada
     * @param strOrden Campo por el que se hace el ordenamiento 
     * @param tipo Ordenamiento ascendente o descendente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getRemitentes(String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT RMT_NOMBRE, ID_REMITENTE, RMT_AREA, ARE_NOMBRE, ENT_NOMBRE, RMT_CARGO ";
		strSql+="FROM SD_REMITENTE, SD_AREA, SD_ENTIDAD WHERE RMT_ESTATUS=1 ";
		strSql+="AND SD_REMITENTE.RMT_AREA=SD_AREA.ID_AREA ";
		strSql+="AND SD_ENTIDAD.ID_ENTIDAD=SD_REMITENTE.RMT_ENTIDAD ";
		strSql+="AND ID_REMITENTE <> 0 ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 6 "+strOrden+", 6 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 6 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 5 "+strOrden+", 6 ASC ";
		}
		return strSql;	
	}
    
    /**
     * Construye un SQL Query para Obtiener los datos del remitente por su ID
     * @param idRemitente ID del remitente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getRemitente(String idRemitente)
	{
		String strSql="";		
		strSql=	" SELECT RMT_NOMBRE, RMT_AREA, RMT_CARGO, RMT_ENTIDAD, RMT_TELEFONO, RMT_CORREO, RMT_DIRECCION, RMT_FAX, RMT_USR_ACTUALIZO, TO_CHAR(RMT_FEC_ACTUALIZACION, 'DD/MM/YYYY HH:MI:SS AM') " +
				" FROM SD_REMITENTE WHERE ID_REMITENTE="+idRemitente; 
		return strSql;	
	}
    
    /**
     * Construye un SQL Query para Eliminar logicamente los registros de Remitentes
     * @param strIds ID del remitente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDeleteRemitente(String strIds)
	{
	    String strSql="";
		strSql=	" UPDATE SD_REMITENTE SET RMT_ESTATUS=0, RMT_FEC_ACTUALIZACION=SYSDATE WHERE "	+
				"ID_REMITENTE IN ("+strIds+")";
		return strSql;
	}
    
    
    /**
	 * Construye un SQL Query para Actualizar remitentes en la Base de Datos
	 * 
	 * @param strId ID del remitente
	 * @param nombre Nombre 
	 * @param cargo Cargo 
	 * @param strArea Unidad administrativa
	 * @param idEntidad Entidad 
	 * @param telefono Telefono 
	 * @param correo Correo Electronico
	 * @param UsUpdate Usuario que actualizo 
	 * @param FechaUpdate Fecha de Actualización
	 * @param estatus Estatus 
	 * @param direccion Direccion fisica 
	 * @param fax Fax
	 * @return Regresa un String con el Query correspondiente
	 */
    public static String getActualizaRemitente(	String strId, String nombre, String strArea, 
            									String cargo, String idEntidad, String telefono,
            									String correo, String UsUpdate, String FechaUpdate,
            									String estatus, String direccion, String fax)
    {
    	String sql ="UPDATE SD_REMITENTE SET RMT_NOMBRE='"+nombre+"', RMT_AREA="+strArea+", RMT_CARGO='"+cargo+"', RMT_ENTIDAD="+idEntidad
					+", RMT_TELEFONO='"+telefono+"', RMT_CORREO='"+correo+"', " +
					"RMT_USR_ACTUALIZO="+UsUpdate+", " +
					//"RMT_FEC_ACTUALIZACION=TO_DATE('"+FechaUpdate+"', 'DD/MM/YYYY'), " +
					"RMT_FEC_ACTUALIZACION=SYSDATE, " +
					"RMT_ESTATUS="+estatus+", RMT_DIRECCION='"+direccion+"', RMT_FAX='"+fax+"' WHERE "+"ID_REMITENTE IN ("+ strId + ")";

   		return sql;
    }
    
    /**
     * Determina si existen remitentes 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getExistenRemitentes()
    {
        String sql = "";
        sql = "SELECT * FROM SD_REMITENTE WHERE RMT_ESTATUS=1";
        return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar el Nombre del Remitente segun su ID 
     * @param ID ID del Remitente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getNombreRemitente(String ID)
    {
        String sql = "";
        sql = "SELECT RMT_NOMBRE FROM SD_REMITENTE WHERE ID_REMITENTE="+ID;
        return sql;
    }
    
    /**
     * Función que regresa un query, donde inserta un remitente 
     * al momento de crear un nuevo asunto
     * @param strIdArea Contiene el Id del Area
     * @param strIdEntidad Contiene el Id de la entidad
     * @param strRemitente Nombre del remitente
     * @param strCargo Cargo del remitente
     * @param strCorreo Correo del remitente
     * @param strCreador Id del usuario que crea el registro del remitente
     * @param strFechaCreacion Fecha de la creación del registro
     * @return Query
     */
    public static String insertarRemitenteDesdeAsunto(String strIdArea, String strIdEntidad,
            										String strRemitente, String strCargo, String strCorreo,	
													String strCreador, String strFechaCreacion)
    {
        String sql = "";
        sql = "INSERT INTO SD_REMITENTE (ID_REMITENTE, RMT_NOMBRE, RMT_AREA, RMT_CARGO, RMT_ENTIDAD, RMT_CORREO, " +
        		"RMT_USR_ACTUALIZO, RMT_FEC_ACTUALIZACION, RMT_ESTATUS) " +
        		"VALUES (SD_REMITENTE_SEQ.NEXTVAL,'"+strRemitente+"', "+strIdArea+", '"+strCargo+"', "+strIdEntidad+", '"+strCorreo+"', "+strCreador+", '"+strFechaCreacion+"',1)";
        return sql;
    }

    /**
     * Función que regresa un query con el ultimo ID de los
     * registros de remitentes en el catalogo 
     * @return Query
     */
    public static String ultimoIdRemitente()
    {
        String sql = "SELECT MAX(ID_REMITENTE) FROM SD_REMITENTE";
        return sql;
    }
    
    /**
     * devuelve un query, donde verifica si el remitente ya existe
     * al momento de generar una solicitud en el portal
     * ciudadano
     * @param strNombre Nombre del ciudadano
     * @return Query
     */
    public static String existeRemitente(String strNombre){
        String sql = "SELECT COUNT(*) FROM SD_REMITENTE WHERE RMT_NOMBRE='"+strNombre+"'";
        return sql;
    }
    
    /**
     * devuelve el Id del remitente
     * @param strNombre Nombre del remitente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getIdRemitente(String strNombre){
        String sql = "SELECT ID_REMITENTE FROM SD_REMITENTE WHERE RMT_NOMBRE='"+strNombre+"'";
        return sql;
    }
    
    /**
     * Construye un SQL Query para Verificar si Existe un remitente por su Nombre y Entidad 
     * @param strNombre Nombre del remitente
     * @param idEntidad Entidad 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getRemitenteExiste(String strNombre, String idEntidad){
    	String sql = "SELECT RMT_NOMBRE FROM SD_REMITENTE WHERE LOWER(RMT_NOMBRE) = LOWER('"+strNombre+"') AND LOWER(RMT_ENTIDAD) = LOWER('"+idEntidad+"')";
    	return sql;
    }
    
    /**
     * Construye un SQL Query para Verificar si Existe un remitente por su Nombre y Entidad, ademas de compararlos con sus datos antes de ser editados
     * @param strNombre Nombre del remitente
     * @param strEntidad Entidad 
     * @param strAux Nombre del remitente antes de ser editado
     * @param strAux2 Entidad  antes de ser editado
     * @return Regresa un String con el Query correspondiente
     */
    public static String getRemitenteExiste(String strNombre, String strAux, String strEntidad, String strAux2)
    {   
		String strSql=	"SELECT RMT_NOMBRE FROM SD_REMITENTE WHERE " +
		"NOT (LOWER(RMT_NOMBRE) 	= LOWER('" + strAux + "') " +
		"AND  LOWER(RMT_ENTIDAD) 	= LOWER('" + strAux2 + "')) " +
		"AND  LOWER(RMT_NOMBRE) 	= LOWER('" + strNombre + "') " +
		"AND  LOWER(RMT_ENTIDAD) 	= LOWER('" + strEntidad + "') " +
		"AND RMT_ESTATUS = 1";
    
		return strSql;
    }

    /**
     * Construye un SQL Query para regresar todos los Asuntos asociados a un remitente 
     * 
     * @param strIdArea ID del Remitente
     * 
     * @return Regresa un String con el Query correspondiente
     */
    public static String getCountAsuntos(String strIdArea){
    	String sql = "SELECT COUNT(ASU_REMITENTE) FROM SD_ASUNTO WHERE ASU_REMITENTE="+strIdArea+" AND (ASU_ESTATUS<>3 AND ASU_ESTATUS<>4) AND ASU_CONTROL=0";
    	return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar los Remitentes por Entidad, Puesto y Responsable 
     * @param strIdEntidad Entidad 
     * @param buscaPuesto Puesto 
     * @param buscaResponsable Responsable
     * @return Regresa un String con el Query correspondiente
     */
    public static String getRemitenteFrame(String strIdEntidad, String buscaPuesto, String buscaResponsable)
    {
        String strSql = "";
        strSql = "SELECT ID_REMITENTE, RMT_NOMBRE, RMT_CARGO, RMT_CORREO " +
        		"FROM SD_REMITENTE WHERE RMT_ENTIDAD="+strIdEntidad+" " +
        		"AND LOWER(RMT_CARGO) LIKE LOWER('%"+buscaPuesto+"%') " +
        		"AND LOWER(RMT_NOMBRE) LIKE LOWER('%"+buscaResponsable+"%') " +
        		"AND RMT_ESTATUS=1 " +
        		"ORDER BY RMT_NOMBRE";
        return strSql;
    }
    
    /**
     * Construye un SQL Query para Regresar los Remitentes por UA, Puesto y Responsable 
     * @param strIdArea Unidad Administrativa 
     * @param buscaPuesto Puesto 
     * @param buscaResponsable Responsable
     * @return Regresa un String con el Query correspondiente
     */
    public static String getRemitenteInternas(String strIdArea, String buscaPuesto, String buscaResponsable)
    {
        String sql = "";
        sql = "SELECT ID_USUARIO, USU_NOMBRE, USU_CARGO, USU_CORREO " +
        		"FROM SD_USUARIO WHERE USU_AREA="+strIdArea+" " +
        		"AND LOWER(USU_CARGO) LIKE LOWER('%"+buscaResponsable+"%') " +
        		"AND LOWER(USU_NOMBRE) LIKE LOWER('%"+buscaPuesto+"%') " +
        		"AND USU_ESTATUS=1 " +
        		"ORDER BY 2";
        return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar el Estatus de un remitente 
     * @param strIdRemitente ID del remitente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getEstatusRemitente(String strIdRemitente)
    {
        String sql = "";
        sql = "SELECT RMT_ESTATUS FROM SD_REMITENTE WHERE ID_REMITENTE="+strIdRemitente;
        return sql;
    }
    
    /**
     * Construye un SQL Query para Regresar el ID de la UA del remitente
     * @param strIdRemitente ID del remitente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getIdArea(String strIdRemitente)
    {
        String sql = "";
        sql = "SELECT RMT_AREA FROM SD_REMITENTE WHERE ID_REMITENTE="+strIdRemitente;
        return sql;
    }
    
    /**
     * Función que regresa el registro de un remitente con su entidad
     * @param strIdRemitente ID del Remitente
     * @return Regresa un String con el Query correspondiente
     */
    public static String getDestExt(String strIdRemitente){
    	String sql = "SELECT RMT_NOMBRE || ' - ' || ENT_NOMBRE " +
    			"FROM SD_REMITENTE, SD_ENTIDAD " +
    			"WHERE ID_REMITENTE="+strIdRemitente+" " +
    			"AND SD_REMITENTE.RMT_ENTIDAD=SD_ENTIDAD.ID_ENTIDAD";
    	return sql;
    }

}
