/**
 * Metodos con Querys para ejecutar en las tablas de Archivado
 * 
 * @author Meve Soluciones S.A. de C.V.
 */

package com.meve.sigma.sql;

import com.meve.sigma.db2.ConexionDS;

import java.util.StringTokenizer;



public class SQLExpArchivado {
    
    
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp Id de expediente
     * @param strOrden Tipo de ordenamiento
     * @param tipo Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */	
	public static String getporExpedienteInst2(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	"SELECT distinct '0', 'INSTRUCCIONES SIN EXPEDIENTE','0' ";
		strSql+=" FROM sd_instruccion_asunto  a   ";
		strSql+=" where  a.INS_EXPEDIENTE_ID is null ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}

		return strSql;
	}
	/**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp Id de expediente
     * @param strOrden Tipo de ordenamiento
     * @param tipo Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String getporExpedienteInst3(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT distinct b.ID_EXPEDIENTE, b.EXP_DENOMINACION, b.EXP_CVE_UA ";
		strSql+=" FROM sd_instruccion_asunto  a , SD_EXPEDIENTES b ";
		strSql+=" where a.INS_EXPEDIENTE_ID= b.ID_EXPEDIENTE ";
		strSql+=" and b.EXP_STATUS in(1,3) ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * @param strOrden ordenamiento
     * @param tipo tipo de orden
     * @return Query de consulta
     */
	public static String getporExpedienteInst4( String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT distinct b.ID_EXPEDIENTE, b.EXP_DENOMINACION, b.EXP_CVE_UA FROM sd_instruccion_asunto  a , SD_EXPEDIENTES b  ";
		strSql+=" where   b.ID_EXPEDIENTE  not in (	SELECT INS_EXPEDIENTE_ID FROM sd_instruccion_asunto  WHERE INS_EXPEDIENTE_ID > 0) ";
		strSql+=" AND b.ID_EXPEDIENTE  not in a.INS_EXPEDIENTE_ID";
		strSql+=" and b.EXP_STATUS in(1,3) ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param strOrden  Tipo de ordenamiento
     * @param tipo  Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String getporExpedienteInst5( String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT distinct b.ID_EXPEDIENTE, b.EXP_DENOMINACION, b.EXP_CVE_UA  ";
		strSql+=" FROM  SD_EXPEDIENTES b ";
		strSql+=" where  b.EXP_STATUS in(1,3) ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
		return strSql;
	} 
 
 
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp  Id de expediente
     * @param strOrden  Tipo de ordenamiento
     * @param tipo  Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String getporExpedienteAsunto(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT a.ID_asunto, b.EXP_DENOMINACION, a.asu_descripcion,a.asu_Folio_Externo,asu_Folio_Externo, ";
		strSql+=" a.ASU_FOLIO_RECEPCION,  a.ASU_CONTROL_FOLIO ,TO_CHAR(a.ASU_FECHA_DOCTO, 'DD/MM/YYYY'),b.EXP_CVE_UA ";
		strSql+=" FROM sd_asunto a , SD_EXPEDIENTES b ";
		strSql+=" where a.asu_expediente= b.ID_EXPEDIENTE";
		strSql+="  AND a.ID_asunto="+exp+" ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}



    /**
     * RME . Developed 
     */
        public static String getExpediente_Asunto(String exp, String strOrden, String tipo, String clave, String denominacion)
        {
                String strSql="";               
                strSql= " SELECT a.ID_asunto, b.EXP_DENOMINACION, a.asu_descripcion,a.asu_Folio_Externo,asu_Folio_Externo, ";
                strSql+=" a.ASU_FOLIO_RECEPCION,  a.ASU_CONTROL_FOLIO ,TO_CHAR(a.ASU_FECHA_DOCTO, 'DD/MM/YYYY'),b.EXP_CVE_UA ";
                strSql+=" FROM sd_asunto a , SD_EXPEDIENTES b ";
                strSql+=" where a.asu_expediente= b.ID_EXPEDIENTE";
                strSql+="  AND a.ID_asunto="+exp+" ";
                if(tipo.equals("1")){
                        strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
                }else if(tipo.equals("2")){
                        strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
                }else if(tipo.equals("3")){
                        strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
                }else if(tipo.equals("4")){
                        strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
                }
                return strSql;
        }



    /**
    * RME . Developed
    */ 
    public static String get_Expediente_Asunto_Consulta(String exp, String strOrden, String tipo, String clave, String denominacion, String idUA)
    {
        String strSql="";               

        if(exp == "sin" || exp.equalsIgnoreCase("sin")) //Asuntos sin expediente.
        {
            strSql =  "SELECT DISTINCT '0', 'ASUNTOS SIN EXPEDIENTE' , '0' ";
            strSql += " FROM SD_ASUNTO A , SD_USUARIO B   ";
            strSql += " WHERE A.ASU_EXPEDIENTE IS NULL ";
            strSql += " AND   A.ASU_USR_TURNA = B.ID_USUARIO ";
            strSql += " AND   B.USU_AREA = "+ idUA;
        } else {
            if(exp == "sinexp" || exp.equalsIgnoreCase("sinexp"))
            {
                strSql =  " SELECT DISTINCT B.ID_EXPEDIENTE, B.EXP_DENOMINACION, B.EXP_CVE_UA";
                strSql += " FROM SD_ASUNTO A , SD_EXPEDIENTES B  ";
                strSql += " WHERE B.ID_EXPEDIENTE NOT IN A.ASU_EXPEDIENTE";
                strSql += " AND   A.ASU_EXPEDIENTE IS NOT NULL";
                strSql += " AND   A.ASU_EXPEDIENTE > 0 ";
                strSql += " AND   B.EXP_STATUS IN (1,3) ";
            } else if(exp == "todo" || exp.equalsIgnoreCase("todo"))
            {
                strSql =  " SELECT DISTINCT B.ID_EXPEDIENTE, B.EXP_DENOMINACION, B.EXP_CVE_UA ";
                strSql += " FROM   SD_ASUNTO A, SD_EXPEDIENTES B ";
                strSql += " WHERE  A.ASU_EXPEDIENTE = B.ID_EXPEDIENTE ";
                strSql += " AND    B.EXP_STATUS IN (1,3) ";
            } else 
            {
                strSql =  " SELECT DISTINCT B.ID_EXPEDIENTE, B.EXP_DENOMINACION, B.EXP_CVE_UA  ";
                strSql += " FROM   SD_EXPEDIENTES B ";
                strSql += " WHERE  B.EXP_STATUS IN (1,3) ";
            }
            strSql += " AND   B.EXP_CVE_UA = "+ idUA;

            if ( clave != "" ) {
                strSql += " AND   B.EXP_CLAVE LIKE '%" +  clave + "%' ";            
            }

            if ( denominacion != "" ) {
                strSql += " AND   B.EXP_DENOMINACION LIKE '%" +  denominacion + "%' ";            
            }
        }
    
    
        if(tipo.equals("1")){
                strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
        }else if(tipo.equals("2")){
                strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
        }
        return strSql;
    }


    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp : Id de expediente
     * @param strOrden : Tipo de ordenamiento
     * @param tipo : Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */	
	public static String getporExpedienteAsu2(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	"SELECT distinct '0', 'ASUNTOS SIN EXPEDIENTE' , '0' ";
		strSql+=" FROM sd_asunto a , sd_usuario b   ";
		strSql+=" where  a.asu_expediente is null ";
		strSql+=" and  a.ASU_USR_TURNA = b.id_usuario ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}

		return strSql;
	}
	/**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp : Id de expediente
     * @param strOrden : Tipo de ordenamiento
     * @param tipo : Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String getporExpedienteAsu3(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT distinct b.ID_EXPEDIENTE, b.EXP_DENOMINACION, b.EXP_CVE_UA ";
		strSql+=" FROM sd_asunto a , SD_EXPEDIENTES b ";
		strSql+=" where a.asu_expediente= b.ID_EXPEDIENTE ";
		strSql+=" and b.EXP_STATUS in(1,3) ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}
	/**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp : Id de expediente
     * @param strOrden : Tipo de ordenamiento
     * @param tipo : Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String getporExpedienteUnico(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT distinct b.ID_EXPEDIENTE, b.EXP_DENOMINACION, b.EXP_CVE_UA ";
		strSql+=" FROM  SD_EXPEDIENTES b ";
		strSql+=" where b.ID_EXPEDIENTE = "+exp;
		strSql+=" and b.EXP_STATUS in(1,3) ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param strOrden Tipo de ordenamiento
     * @param tipo  Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String getporExpedienteAsu4( String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT distinct b.ID_EXPEDIENTE, b.EXP_DENOMINACION, b.EXP_CVE_UA FROM sd_asunto a , SD_EXPEDIENTES b  ";
		strSql+=" where   b.ID_EXPEDIENTE  not in (	SELECT asu_expediente	FROM sd_asunto WHERE asu_expediente>0) ";
		strSql+=" AND b.ID_EXPEDIENTE  not in a.asu_expediente";
		strSql+=" and b.EXP_STATUS in(1,3) ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param strOrden : Tipo de ordenamiento
     * @param tipo : Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String getporExpedienteAsu5( String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT distinct b.ID_EXPEDIENTE, b.EXP_DENOMINACION, b.EXP_CVE_UA  ";
		strSql+=" FROM  SD_EXPEDIENTES b ";
		strSql+=" where b.EXP_STATUS in(1,3) ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}    
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp : Id de expediente
     * @param strOrden : Tipo de ordenamiento
     * @param tipo : Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.REFRES
     */
	public static String getporExpediente(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT a.ID_asunto, b.EXP_CLAVE, a.asu_descripcion,a.asu_Folio_Externo,asu_Folio_Entrada, ";
		strSql+=" a.ASU_FOLIO_RECEPCION,  a.asu_Folio_Entrada ,TO_CHAR(a.ASU_FECHA_DOCTO, 'DD/MM/YYYY'),b.EXP_CVE_UA ";
		strSql+=" FROM sd_asunto a , SD_EXPEDIENTES b ";
		strSql+=" where a.asu_expediente= b.ID_EXPEDIENTE";
		strSql+="  AND a.asu_expediente="+exp+" ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp : Id de expediente
     * @param strOrden : Tipo de ordenamiento
     * @param tipo : Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */	
	public static String getporExpediente2(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT a.ID_asunto, 'Sin Expediente' campo, a.asu_descripcion,a.asu_Folio_Externo,a.asu_Folio_Externo, ";
		strSql+=	" a.ASU_FOLIO_RECEPCION,  a.asu_Folio_Entrada ,TO_CHAR(a.ASU_FECHA_DOCTO, 'DD/MM/YYYY'), a.asu_area_recepcion ";
		strSql+=" FROM sd_asunto a   ";
		strSql+=" where  a.asu_expediente is null ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}

		return strSql;
	}
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp : Id de expediente
     * @param strOrden : Tipo de ordenamiento
     * @param tipo : Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */	
	public static String getporInst2(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT a.id_instruccion_asunto, 'Sin Expediente' campo, a.ins_instruccion_otro, ";
		strSql+=" a.ins_folio_turnado,  b.usu_area ";
		strSql+=" FROM sd_instruccion_asunto a, sd_usuario b   ";
		strSql+=" where  a.INS_EXPEDIENTE_ID is null "; 
		strSql+=" and  a.ins_usuario = b.id_usuario ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}	
	
	/**
	 * Resgresa los datos de una intruccion referente a un Expediente
	 * @param exp Id de expediente
	 * @param strOrden tipo de ordenamiento
	 * @param tipo Criterio de ordenamiento
	 * @return Query consulta
	 */
	public static String getporInst(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT a.id_instruccion_asunto, b.EXP_CLAVE, a.ins_instruccion_otro, ";
		strSql+=" a.ins_folio_turnado,b.EXP_CVE_UA ";
		strSql+=" FROM sd_instruccion_asunto a , SD_EXPEDIENTES b ";
		strSql+=" where a.INS_EXPEDIENTE_ID = b.ID_EXPEDIENTE";
		strSql+="  AND a.INS_EXPEDIENTE_ID="+exp+" ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp Id de expediente
     * @param strOrden Tipo de ordenamiento
     * @param tipo Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String getporExpediente3(String exp, String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT a.ID_asunto, b.EXP_DENOMINACION, a.asu_descripcion,a.asu_Folio_Externo,asu_Folio_Externo, ";
		strSql+=" a.ASU_FOLIO_RECEPCION,  a.ASU_CONTROL_FOLIO ,TO_CHAR(a.ASU_FECHA_DOCTO, 'DD/MM/YYYY'),b.EXP_CVE_UA ";
		strSql+=" FROM sd_asunto a , SD_EXPEDIENTES b ";
		strSql+=" where a.asu_expediente= b.ID_EXPEDIENTE ";
		strSql+=" and b.EXP_STATUS in(1,3) ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param strOrden : Tipo de ordenamiento
     * @param tipo : Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String getporExpediente4( String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT distinct '', b.EXP_DENOMINACION, 'sin descripcion','sin clave','sin folio', " ;
		strSql+=" a.ASU_FOLIO_RECEPCION,  a.ASU_CONTROL_FOLIO ,TO_CHAR(a.ASU_FECHA_DOCTO, 'DD/MM/YYYY'),b.EXP_CVE_UA FROM sd_asunto a , SD_EXPEDIENTES b  ";
		strSql+=" where   b.ID_EXPEDIENTE  not in (	SELECT asu_expediente	FROM sd_asunto WHERE asu_expediente>0) ";
		strSql+=" AND b.ID_EXPEDIENTE  not in a.asu_expediente";
		strSql+=" and b.EXP_STATUS in(1,3) ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param strOrden  Tipo de ordenamiento
     * @param tipo  Criterio de ordenamiento
     * 
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String getporExpediente5( String strOrden, String tipo)
	{
		String strSql="";		
		strSql=	" SELECT a.ID_asunto, b.EXP_DENOMINACION, a.asu_descripcion,a.asu_Folio_Externo,a.asu_Folio_Externo, ";
		strSql+=" a.ASU_FOLIO_RECEPCION,  a.ASU_CONTROL_FOLIO ,TO_CHAR(a.ASU_FECHA_DOCTO, 'DD/MM/YYYY'),b.EXP_CVE_UA  ";
		strSql+=" FROM sd_asunto a , SD_EXPEDIENTES b ";
		strSql+=" where a.asu_expediente (+)= b.ID_EXPEDIENTE ";
		strSql+=" and b.EXP_STATUS in(1,3) ";
		if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 4 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 2 ASC ";
		}
		return strSql;
	}

    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de SD_SUBFONDO
     * @param codigo Codigo de subfondo
     * @param seccion Seccion del subfondo
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @return Query consulta
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
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de Subfondo Archivado
     * @param codigo Nombre del Subfondo
     * @param seccion Descripcion del Subfondo
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @return Query consulta
     */
    public static String insertarSubfondoA(	String codigo, String seccion,
            								String fecha, String Usr)
    {
        String sql = "";
        sql = "INSERT INTO SD_SUBFONDOARCH (ID_SUBFONDO, SUBF_NOMBRE, SUBF_DESCRIPCION,SUBF_USUARIO,SUBF_STATUS, SUBF_FEC_ACTUALIZACION " +
        		") VALUES (subfondo_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', "+Usr+", 1,SYSDATE)";
        return sql;
    }
    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de Valoracion
     * @param codigo Nonbre validacion.
     * @param seccion Descripcion de la validacion.
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param val1 Identificadores de los valores 
     * @param val2 Tipo de Valor2
     * @param val3 Tipo de Valor3
     * @param clv Clave del Registro 
     * @return Numero entero :Indica la validez del registro
     */
    public static String insertarValoracion(	String codigo, String seccion,
            								String fecha, String Usr,String val1[], String val2,String val3, String clv)
    {
		String ids="";
		for(int i=0; i<val1.length;i++)
		ids+=val1[i]+",";
		ids=ids.substring(0,ids.length()-1);
        String sql = "";
        
        sql = "INSERT INTO SD_VALORACION (ID_VALORACION, VAL_NOMBRE, VAL_DESCRIPCION,VAL_USUARIO,VAL_STATUS, VAL_FEC_ACTUALIZACION, VAL_VALORACIONES1, VAL_VALORACIONES2, VAL_VALORACIONES3,VAL_CLAVE  " +
        ") VALUES (valoracion_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', "+Usr+", 1,SYSDATE,trim(' "+ids+"'),"+val2+","+val3+","+clv+")";

        return sql;
    }

    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla del cuadro de Diposicion Documental
     * @param area Identificador del Area
     * @param seccion Identificador de la seccion
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param series  Identificadores de la series
     * @param subser  Identificadores de la Subseries
     * @return Query consulta
     */
    public static String insertarIcdd(String area, String seccion,
												String fecha, String Usr,String series,String subser)
    {



        String sql = "";
        sql = "INSERT INTO SD_ICDD_UA (ID_ICDD_UA,ICDD_CLAVE_UA,ICDD_SECCION,ICDD_CLAVES_SERIES,  " +
        " ICDD_CLAVES_SUBSERIES,ICDD_FEC_REGISTRO,ICDD_STATUS,ICDD_USUARIO,ICDD_FEC_ACTUALIZACION)"+
        " VALUES (IcddUA_seq.NEXTVAL,"+area+","+seccion+", "+series+", "+subser+", '"+fecha+"',1,"+Usr+",SYSDATE)";

        return sql;
    }
    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de Seccion
     * @param fondo Identificador del fondo
     * @param subfondo Identificador del subfondo
     * @param codigo Codigo de Seccion
     * @param seccion Seccion del Seccion
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param clave Clave del Registro 
     * @return Numero entero :Indica la validez del registro
     */
    public static String insertarSeccion(	String fondo, String subfondo, String codigo, String seccion,
            								String fecha, String Usr, String clave)
    {
        String sql = "";
        sql = "INSERT INTO SD_SECCION_ARCH  (	SEC_FONDO,SEC_SUBFONDO,ID_SECCION, SEC_NOMBRE, SEC_DESCRIPCION,SEC_USUARIO,SEC_STATUS, SEC_FEC_ACTUALIZACION ,SEC_CLAVE" +
        		") VALUES (" +fondo+"," +subfondo+",  seccion_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,'"+clave+"')";
        return sql;
    }
    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de Subserie
     * @param codigo Codigo de Subserie
     * @param seccion Seccion del Subserie
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param clv Clave del Registro 
     * @param serie id serie
     * @return Numero entero :Indica la validez del registro
     */
    public static String insertarSubserie(	String codigo, String seccion,
            								String fecha, String Usr, String serie, String clv)
    {
        String sql = "";
        sql = "INSERT INTO SD_SUBSERIE (ID_SUBSERIE, SUBS_NOMBRE, SUBS_DESCRIPCION,SUBS_USUARIO,SUBS_STATUS, SUBS_FEC_ACTUALIZACION,SUBS_SERIE,SUBS_CLAVE" +
        		") VALUES (subserie_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,"+serie+",'"+clv+"')";
        return sql;
    }
    
    
    /**
     * Función con query, donde inserta datos a la 
     * tabla de Expedientes
     * @param EXP_CVE_UA Clave Identificador del Area
     * @param EXP_AREA_DESC Descripcion del Area
     * @param EXP_CED_TIPO Identificador de Cedula tipo
     * @param EXP_CLAVE Clave del Expediente
     * @param EXP_INTERNO Descrpcion Interna
     * @param EXP_UBICACION Ubicacion Topografica
     * @param EXP_DENOMINACION Nombre del Expediente
     * @param EXP_DESCRIPCION Descripcion
     * @param EXP_VALORACION Identificador de la Valoracion
     * @param EXP_FEC_CIERRE Fecha de Cierre
     * @param EXP_ANO_AT Numero de Años de Tramite
     * @param EXP_ANO_AC Numero de Años de Concentracion
     * @param EXP_SISI_DISP Muestra si es consultado por SISI
     * @param EXP_ANIOS_TOTAL_DISP Usuario que actualizo
     * @param EXP_CVE_CLASF_INF Identificador de la clsificacion informativa
     * @param EXP_MOTIVO Motivo del Expediente
     * @param EXP_FUNDAMENTO Fundamentos para expediente
     * @param EXP_OBSERVA Observaciones
     * @param EXP_ANO_RESERV Numero de Años reservados
     * @param EXP_ANO_REAL Numero de Años reales de vigencia
     * @param EXP_SISI_CLS Muestra si es consultado por SISI
     * @param EXP_ANIOS_TOTAL_CLS Numero Total de Años por clasificacion
     * @param EXP_ANIOS_AMPLI Numero de Años a ampliar
     * @param EXP_FEC_AMPLI Fecha en q se aplica una ampliacion
     * @param EXP_ANIOS_GUARDA Numero de Años de guarda
     * @param EXP_USUARIO Id de Usuario q guarda
     * @param EXP_FEC_APERTURA Fecha de apertura del Expediente
     * @param CONSECUTIVO Consecutivo del Expediente
     * @param EXP_UB_FISICA Dirección Fisica del Expediente
     * @return Query consulta
     */
    public static String insertarExpediente(String EXP_CVE_UA, String EXP_AREA_DESC, String EXP_CED_TIPO , 
            String EXP_CLAVE,String EXP_INTERNO,String EXP_UBICACION ,
            String EXP_DENOMINACION  , String EXP_DESCRIPCION  ,String EXP_VALORACION , String EXP_FEC_CIERRE ,
            String EXP_ANO_AT ,String EXP_ANO_AC,String EXP_SISI_DISP, String EXP_ANIOS_TOTAL_DISP,String EXP_CVE_CLASF_INF , 
            String EXP_MOTIVO , String EXP_FUNDAMENTO ,String EXP_OBSERVA ,String EXP_ANO_RESERV ,String EXP_ANO_REAL,
            String EXP_SISI_CLS, String EXP_ANIOS_TOTAL_CLS,String EXP_ANIOS_AMPLI , String EXP_FEC_AMPLI , 
             String EXP_ANIOS_GUARDA, String EXP_USUARIO,String EXP_FEC_APERTURA, String CONSECUTIVO, String EXP_UB_FISICA)
    {
        String sql = "";
        sql = "INSERT INTO SD_EXPEDIENTES (ID_EXPEDIENTE , EXP_CVE_UA, EXP_AREA_DESC, EXP_CED_TIPO , "+
				" EXP_CLAVE,EXP_INTERNO,EXP_UBICACION , "+
            	" EXP_DENOMINACION  , EXP_DESCRIPCION  ,EXP_VALORACION ,  "+
            	" EXP_ANO_AT ,EXP_ANO_AC, EXP_SISI_DISP, EXP_ANIOS_TOTAL_DISP,EXP_CVE_CLASF_INF ,  "+
            	" EXP_MOTIVO , EXP_FUNDAMENTO ,EXP_OBSERVA ,EXP_ANO_RESERV ,EXP_ANO_REAL, "+
            	" EXP_SISI_CLS, EXP_ANIOS_TOTAL_CLS,  "+
            	" EXP_ANIOS_GUARDA, EXP_USUARIO, EXP_STATUS , EXP_FEC_ACTUALIZACION,EXP_FEC_APERTURA,EXP_CED_TIPO_CONSEC,EXP_UB_FISICA "+
        		") VALUES (expediente_seq.nextval,'"+EXP_CVE_UA+"', '"+EXP_AREA_DESC+"', " +
         		""+EXP_CED_TIPO+",'"+EXP_CLAVE+"','"+EXP_INTERNO+"','"+EXP_UBICACION+"','"+EXP_DENOMINACION+"'," +
         		"'"+EXP_DESCRIPCION+"',"+EXP_VALORACION+","+
         		""+EXP_ANO_AT+","+EXP_ANO_AC+","+EXP_SISI_DISP+","+EXP_ANIOS_TOTAL_DISP+","+EXP_CVE_CLASF_INF+"," +
         		"'"+EXP_MOTIVO+"','"+EXP_FUNDAMENTO+"','"+EXP_OBSERVA+"',"+
         		""+EXP_ANO_RESERV+","+EXP_ANO_REAL+","+EXP_SISI_CLS+","+EXP_ANIOS_TOTAL_CLS+"," +
         		""+EXP_ANIOS_GUARDA+",'"+EXP_USUARIO+"'," +
   				" 1,TO_DATE(SYSDATE, 'DD/MM/YYYY'),TO_DATE('"+EXP_FEC_APERTURA+"', 'DD/MM/YYYY'),"+CONSECUTIVO+","+EXP_UB_FISICA+")";
        return sql;
    }
    

    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de Valores
     * @param codigo Nombre del Valor
     * @param seccion Descripcion del Valor
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param clave Clave del Valor
     * @return Numero entero :Indica la validez del registro
     */
    public static String insertarValor(	String codigo, String seccion,
            								String fecha, String Usr,String clave)
    {
        String sql = "";
        sql = "INSERT INTO SD_VALOR (ID_VALOR, V_NOMBRE, V_DESCRIPCION, V_USUARIO, V_STATUS, V_FEC_ACTUALIZACION,V_CLAVE" +
        		") VALUES (valor_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,"+clave+")";
        return sql;
    }
    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de Cedula Tipo
     * @param codigo Nombre de la Cedula Tipo
     * @param seccion Descripcion de la Cedula Tipo
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param clv clave de la Cedula Tipo
     * @param area Identificador de Unidad Administrativa
     * @param comb Identificador de la Combinacion Generada
     * @param strMotivo Descripcion del motivo de la cedula
     * @param strFunda  Descripcion del fundamiento de la cedula
     * @param strSubserie Identificador de la Subserie
     * @param strSerie Identificador de la Serie
     * @return Numero entero :Indica la validez del registro
     */
    public static String insertaTipCed(	String codigo, String seccion,
			String fecha, String Usr, String clv, String area, String comb,
			String strMotivo, String strFunda, String strSubserie, String strSerie)
			{
		if(strSubserie == null || strSubserie.equalsIgnoreCase(""))strSubserie="null";
		if(strSerie == null || strSerie.equalsIgnoreCase(""))strSerie="null";
		
		String sql = "";
		sql = "INSERT INTO SD_TIPO_CEDULA (ID_CEDULA, CED_NOMBRE, CED_DESCRIPCION, CED_USUARIO, CED_STATUS, CED_FEC_ACTUALIZACION, " +
				" CED_CLAVE, CED_CVE_UA, CED_MOTIVO, CED_FUNDAMENTO, CED_ICDD_UASub , CED_ICDD_UAS " +
			") VALUES (tip_cedula_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
			//"'"+fecha+"', "+Usr+", 1)";
			""+Usr+", 1,SYSDATE,'"+clv+"','"+area+"','"+strMotivo+"','"+strFunda+"',"+strSubserie+","+strSerie+")";
		return sql;
			}
    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de Selecciones
     * @param codigo Nombre de la Seleccion
     * @param seccion Descripcion de la Seleccion
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param clv Clave del Seleccion
     * @return Numero entero :Indica la validez del registro
     */
    public static String insertarSeleccion(	String codigo, String seccion,
            								String fecha, String Usr, String clv)
    {
        String sql = "";
        sql = "INSERT INTO SD_SELECCION (ID_SELECCION, SEL_NOMBRE, SEL_DESCRIPCION,SEL_USUARIO,SEL_STATUS, SEL_FEC_ACTUALIZACION, SEL_CLAVE " +
        		") VALUES (selec_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,"+clv+")";
        return sql;
    }
    /**
     * Función con un query, donde inserta datos a la 
     * tabla de Fondos
     * @param codigo Nombre del Fondo
     * @param seccion Descripcion de la Fondo
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param clv Clave del Fondo
     * @param sisi Numero de Años sisi  
     * @return Query consulta 
     */
    public static String insertarFondo(	String codigo, String seccion,
            								String fecha, String Usr, String clv, String sisi)
    {
        String sql = "";
        sql = "INSERT INTO SD_FONDO_ARCH (ID_FONDO, FON_NOMBRE, FON_DESCRIPCION,FON_USUARIO,FON_STATUS, FON_FEC_ACTUALIZACION, FON_CLAVE,FON_SISI" +
        		") VALUES (fondoa_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,'"+clv+"',"+sisi+")";
        return sql;
    }  
    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de Combinaciones
     * @param codigo Codigo de subfondo
     * @param seccion Seccion del subfondo
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param sub id subserie
     * @param serie id serie
     * @param sec id seccion
     * @param tipcomb tipo de combinacion
     * @param clave clave de la combinacion
     * @return Query consulta
     */
    public static String insertarComb(	String codigo, String seccion,
            								String fecha, String Usr, String sub, String serie, String sec, String tipcomb ,String clave)
    {
        String sql = "";
        sql = "INSERT INTO SD_COMBINACION (ID_COMBINACION, COM_NOMBRE, COM_DESCRIPCION,COM_USUARIO,COM_STATUS, COM_FEC_ACTUALIZACION, COM_FONDO, COM_SERIE, COM_SECCION,COM_TIP_COMBINACION,COM_CLAVE " +
        		") VALUES (combinacion_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,"+ sub +","+serie+","+sec+",'"+tipcomb+"','" +clave+ "')";
        return sql;
    } 
    /**
     *  Función con un query, donde inserta datos a la 
     * tabla de Clasificacion Serie
     * @param codigo Nombre de Serie
     * @param seccion Descripcion del Serie
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param serie Identificador de la Valoracion
     * @param sec Identificador de la Seccion
     * @param strFechaAT Numero de Años de Tramite
     * @param strFechaAC Numero de Años de Concentracion
     * @param strAnosSISI Muestra si es consultado por SISI
     * @param strFechaTotal Numero de Años totales
     * @param rerv Numero de Años reservados
     * @param obvser Observaciones
     * @param strConf Si es confidencial
     * @param clv Clave
     * @param idfn Identificador Fondo
     * @param idsubfn Identificador SubFondo
     * @param idsec Identificador seccion
     * @param idser Identificador serie
     * @param idsubsr dentificador Subserie
     * @return Query consulta
     */
    public static String insertarClasif(	String codigo, String seccion,
            								String fecha, String Usr, String serie, String sec,
            								 String strFechaAT,String strFechaAC,String strFechaTotal,
											 String strAnosSISI,String strConf, String clv, String rerv,
											 String idfn, String idsubfn, String idsec, 
											 String idser,String idsubsr, String obvser)
    {
        String sql = "";
        sql = "INSERT INTO SD_CLASIFICACION (ID_CLASIFICACION, CLS_NOMBRE, CLS_DESCRIPCION, CLS_USUARIO, CLS_STATUS, CLS_FEC_ACTUALIZACION, CLS_VALORACION,CLS_SELECCION, " +
        		"  CLS_VIGENCIA_AT, CLS_VIGENCIA_AC, CLS_VIGENCIA_TOTAL, CLS_ANOS_SISI, CLS_CONFIDENCIAL,CLS_CLAVE,CLS_ANOS_RESERVA, "+
        		"  CLS_FONDO, CLS_SUBFONDO,CLS_SECCION, CLS_SERIE, CLS_SUBSERIE,CLS_OBSERVACIONES "+
        		") VALUES (clasificacion_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,"+serie+","+sec+","+strFechaAT+","+strFechaAC+","+strFechaTotal+","+
        		""+strAnosSISI+",'"+ strConf+ "','"+clv+"',"+rerv+","+idfn+","+idsubfn+","+idsec+","+idser+","+idsubsr+",'"+obvser+"')";
        return sql;
    }
    
    /**
     * Función de query, donde inserta datos a la 
     * tabla de Clasificacion SubSerie
     * @param codigo Nombre de SubSerie
     * @param seccion Descripcion del SubSerie
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param serie Identificador de la Valoracion
     * @param sec Identificador de la Seccion
     * @param strFechaAT Numero de Años de Tramite
     * @param strFechaAC Numero de Años de Concentracion
     * @param strAnosSISI Muestra si es consultado por SISI
     * @param strFechaTotal Numero de Años totales
     * @param rerv Numero de Años reservados
     * @param obvser Observaciones
     * @param strConf Si es confidencial
     * @param clv Clave
     * @param idfn Identificador Fondo
     * @param idsubfn Identificador SubFondo
     * @param idsec Identificador seccion
     * @param idser Identificador serie
     * @param idsubsr dentificador Subserie
     * @return Query consulta 
     */
    public static String insertarClasifsub(	String codigo, String seccion,
            								String fecha, String Usr, String serie, String sec,
            								 String strFechaAT,String strFechaAC,String strFechaTotal,
											 String strAnosSISI,String strConf, String clv, String rerv,
											 String idfn, String idsubfn, String idsec, 
											 String idser,String idsubsr, String obvser)
    {
        String sql = "";
        sql = "INSERT INTO SD_CLASIFICACION_SUB (ID_CLASIFICACION, CLS_NOMBRE, CLS_DESCRIPCION, CLS_USUARIO, CLS_STATUS, CLS_FEC_ACTUALIZACION, CLS_VALORACION,CLS_SELECCION, " +
        		"  CLS_VIGENCIA_AT, CLS_VIGENCIA_AC, CLS_VIGENCIA_TOTAL, CLS_ANOS_SISI, CLS_CONFIDENCIAL,CLS_CLAVE,CLS_ANOS_RESERVA, "+
        		"  CLS_FONDO, CLS_SUBFONDO,CLS_SECCION, CLS_SERIE, CLS_SUBSERIE,CLS_OBSERVACIONES "+
        		") VALUES (clasificacionsub_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,"+serie+","+sec+","+strFechaAT+","+strFechaAC+","+strFechaTotal+","+
        		""+strAnosSISI+",'"+ strConf+ "','"+clv+"',"+rerv+","+idfn+","+idsubfn+","+idsec+","+idser+","+idsubsr+",'"+obvser+"')";
        return sql;
    }    
    /**
     * Función de query, donde inserta datos a la 
     * tabla de Clasificacion Serie
     * @param codigo Nombre de Serie
     * @param seccion Descripcion del SubSerie
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param clv Clave
     * @param idSecc Identificador seccion
     * @return Query consulta
     */
    public static String insertarSerie(	String codigo, String seccion,
            								String fecha, String Usr, String clv, String idSecc)
    {
        String sql = "";
        sql = "INSERT INTO SD_SERIE (ID_SERIE, SER_NOMBRE, SER_DESCRIPCION,SER_USUARIO,SER_STATUS, SER_FEC_ACTUALIZACION, SER_CLAVE, SER_SECCION " +
        		") VALUES (serie_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,'"+ clv+"',"+idSecc+")";
        return sql;
    } 
    
    /**
     * Insertar expediente a una instruccion
     * @param idins id instruccion
     * @param idexp id expediente
     * @param descexp descripcion del expediente
     * @return Query consulta
     */
    public static String insertaExpInst(	String idins, String idexp, String descexp)
    {
        String sql = "";
        sql = "UPDATE sd_instruccion_asunto set INS_EXPEDIENTE_ID =" +idexp+
        		", INS_EXPEDIENTE_NOMBRE ='"+descexp+"'" +
        		" WHERE ID_INSTRUCCION_ASUNTO ="+idins;
        return sql;
    }     
    
    /**
     * Insertar expediente a un Asunto
     * @param strIdAsunto Id Asunto
     * @param idexp id expediente
     * @param descexp descripcion del expediente
     * @return Query consulta
     */
    public static String insertaExpAsunto(String strIdAsunto, String idexp, String descexp)
    {
        String sql = "";
        sql = "UPDATE SD_ASUNTO set ASU_EXPEDIENTE =" +idexp+
        		", ASU_EXPEDIENTE_OTRO ='"+descexp+"'" +
        		" WHERE ID_ASUNTO ="+strIdAsunto;
        return sql;
    }     
    /**
     * Función de query, donde inserta datos a la 
     * tabla de Clasificacion de Informacion
     * @param codigo Nombre de la Clasificacion de Informacion
     * @param seccion Descripcion de la Clasificacion de Informacion
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param clv Clave
     * @return Query consulta 
     */
    public static String insertarClasifInf(	String codigo, String seccion,
            								String fecha, String Usr, String clv)
    {
        String sql = "";
        sql = "INSERT INTO SD_CLASIF_INF (ID_CLASIF_INF, CLSI_NOMBRE, CLSI_DESCRIPCION,CLSI_USUARIO,CLSI_STATUS, CLSI_FEC_ACTUALIZACION, CLSI_CLAVE " +
        		") VALUES (serie_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,"+ clv+")";
        return sql;
    } 
    /**
     * Función que regresa un quey donde muesta los datos del subfondo
     * @param strOrden orden de lista
     * @param tipo tipo de orden
     * @return Query consulta
     */
    public static String getDatosSubFondo(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT ID_SUBFONDO, SUB_CODIGO, SUB_SECCION ";
        strSql+="FROM SD_SUBFONDO WHERE SUB_ESTATUS=1";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del subfondo
     * @param strOrden orden de lista
     * @param tipo tipo de orden
     * @return Query consulta
     */
    public static String getDatosSubFondoA(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT a.ID_SUBFONDO, a.SUBF_NOMBRE, a.SUBF_DESCRIPCION,b.FON_CLAVE, a.SUBF_CLAVE,b.FON_NOMBRE,decode(a.SUBF_STATUS ,1,'Activo',3,'Inactivo')";
        strSql+="FROM SD_SUBFONDOARCH a, SD_FONDO_ARCH b WHERE a.SUBF_STATUS in(1,3) AND b.ID_FONDO = a.SUBF_FONDO ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 4 "+strOrden+", 5 "+strOrden+" ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 5 "+strOrden+", 4 "+strOrden+" ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 2 "+strOrden+", 4 "+strOrden+", 5 "+strOrden+" ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 3 "+strOrden+", 4 "+strOrden+", 5 "+strOrden+" ";
		}else if(tipo.equals("5")){
			strSql+="ORDER BY 7 "+strOrden+", 4 "+strOrden+", 5 "+strOrden+" ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del valoracion
     * @param strOrden orden de lista
     * @param tipo tipo de orden
     * @return Query consulta
     */
    public static String getDatosValoracion(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT ID_VALORACION, VAL_NOMBRE, VAL_DESCRIPCION, ";
        strSql+=" VAL_CLAVE,decode(VAL_STATUS ,1,'Activo',3,'Inactivo') ";
       // strSql+=" decode(VAL_VALORACIONES2, 1, 'Legal', 2, 'Administrativa', 3, 'Contable' ) result2 , ";
        //strSql+=" decode(VAL_VALORACIONES3, 1, 'Legal', 2, 'Administrativa',  3, 'Contable') result3 ";
        strSql+=" FROM SD_VALORACION  where VAL_STATUS in(1,3) ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 4 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 2 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 3 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 4 ASC ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos de una valoracion por sus valores
     * @param val1 valor 1
     * @param val2 valor 2
     * @param val3 valor 3
     * @return Query consulta
     */
    public static String getDatosValores(String val1, String val2, String val3)
    {
     //   if(val1== null || val1.equalsIgnoreCase(""))val1="0";
      //  if(val2== null || val2.equalsIgnoreCase(""))val2="0";
      //  if(val3== null || val3.equalsIgnoreCase(""))val3="0";
        String strSql = "";
        strSql = "SELECT ID_VALOR, V_NOMBRE ";
        strSql+=" FROM SD_VALOR  WHERE V_STATUS=1 AND ID_VALOR not in ("+val1+") ORDER BY  2 ";
       // strSql+=" AND ID_VALOR <> "+val2+" AND ID_VALOR <> "+val3+" ";

        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos de una valoracion por sus valores
     * @param val1 valor 1
     * @param val2 valor 2
     * @param val3 valor 3
     * @return Query consulta
     */
    public static String getDatosValores2(String val1, String val2, String val3)
    {
        //if(val1== null || val1.equalsIgnoreCase(""))val1="0";
       // if(val2== null || val2.equalsIgnoreCase(""))val2="0";
       // if(val3== null || val3.equalsIgnoreCase(""))val3="0";
        String strSql = "";
        strSql = "SELECT ID_VALOR, V_NOMBRE ";
        strSql+=" FROM SD_VALOR  WHERE V_STATUS=1 AND ID_VALOR in( "+val1+") ORDER BY 2";
      //  strSql+=" "+val2+" ,"+val3+") ";

        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del cuadro de disposicion
     * @param idsec id seccion
     * @param idsecS id serie
     * @return Query consulta
     */
    public static String getDatosSeccionIcddIds(String idsec, String idsecS)
    {

        String strSql = "";
        
        
        strSql = " SELECT ID_CLASIFICACION,  CLS_CLAVE || ' / ' || CLS_NOMBRE NOMBRE, '00 / SIN SUBSERIE' FROM SD_CLASIFICACION "; 
        strSql+=" WHERE  CLS_SECCION = "+idsec+" AND ID_CLASIFICACION  IN("+idsecS+")";

        return strSql;
    }  
    /**
     * Función que regresa un quey donde muesta los datos del cuadro de disposicion
     * @param idsec id seccion
     * @param idsecS id serie
     * @return Query consulta
     */   
    public static String getDatosSeccionIcddIds2(String idsec, String idsecS)
    {

        String strSql = "";
        
        
        strSql = " SELECT ID_CLASIFICACION,  CLS_CLAVE || ' / ' || CLS_NOMBRE NOMBRE, '00 / SIN SUBSERIE' FROM SD_CLASIFICACION "; 
        strSql+=" WHERE  CLS_SECCION = "+idsec+" AND ID_CLASIFICACION not in("+idsecS+")";

        return strSql;
    }  
    /**
     * Función que regresa un quey donde muesta los datos del cuadro de disposicion por seccion
     * @param idsec id seccion
     * @param area
     * @return Query consulta
     */   
    public static String getDatosSeccionIcdd(String idsec, String area)
    {

        String strSql = "";
        strSql =" SELECT  distinct ID_CLASIFICACION, CLS_CLAVE || ' / ' || CLS_NOMBRE NOMBRE, '00 / SIN SUBSERIE' "; 
        strSql+="FROM SD_CLASIFICACION WHERE CLS_SECCION = "+idsec+" AND CLS_STATUS = 1 ";
        strSql+=" AND ID_CLASIFICACION NOT IN (SELECT ICDD_CLAVES_SERIES FROM SD_ICDD_UA ";
        strSql+=" WHERE ICDD_STATUS = '1' AND ICDD_CLAVE_UA ="+area+" AND ICDD_SECCION = "+idsec+" AND ICDD_CLAVES_SUBSERIES IS NULL)";

        return strSql;
    }   
    /**
     * Función que regresa un quey donde muesta los datos del cuadro de disposicion por seccion
     * @param idsec id seccion
     * @param area 
     * @return Query consulta
     */     
    public static String getDatosSeccionIcddSub(String idsec, String area)
    {

        String strSql = "";
      
        strSql =" SELECT A.ID_CLASIFICACION, B.CLS_CLAVE || ' / ' || B.CLS_NOMBRE NOMBRESUB,  A.CLS_CLAVE || ' / ' || A.CLS_NOMBRE NOMBRE "; 
        strSql+=" FROM SD_CLASIFICACION_SUB A, SD_CLASIFICACION B";
        strSql+=" WHERE  A.CLS_SERIE = B.ID_CLASIFICACION";
        strSql+=" AND  A.CLS_STATUS = 1";
        strSql+=" AND  A.CLS_SECCION = "+idsec+"";
        strSql+=" AND  A.ID_CLASIFICACION NOT IN (SELECT ICDD_CLAVES_SUBSERIES FROM SD_ICDD_UA ";
        strSql+=" WHERE ICDD_STATUS = '1' AND ICDD_CLAVE_UA ="+area+" AND ICDD_SECCION = "+idsec+" AND ICDD_CLAVES_SUBSERIES > 0)";
        return strSql;
    }
    
    /**
     * Función que regresa un quey donde muesta los datos del cuadro de disposicion
     * @param idsec id seccion
     * @param idsecS id serie
     * @return Query consulta
     */    
     public static String getDatosSeccionIcddSubIds(String idsec, String idsecS)
    {

        String strSql = "";
      
        strSql =" SELECT A.ID_CLASIFICACION,  B.CLS_CLAVE || ' / ' || B.CLS_NOMBRE NOMBRESUB, A.CLS_CLAVE || ' / ' || A.CLS_NOMBRE NOMBRE"; 
        strSql+=" FROM SD_CLASIFICACION_SUB A, SD_CLASIFICACION B";
        strSql+=" WHERE  A.CLS_SERIE = B.ID_CLASIFICACION";
        strSql+=" AND    A.CLS_SECCION = "+idsec+" AND A.ID_CLASIFICACION IN("+idsecS+")";
        return strSql;
    }
     /**
      * Función que regresa un quey donde muesta los datos del cuadro de disposicion
      * @param idsec id seccion
      * @param idsecS id serie
      * @return Query consulta
      */       
    public static String getDatosSeccionIcddSubIds2(String idsec, String idsecS)
    {

        String strSql = "";
      
        strSql =" SELECT A.ID_CLASIFICACION,  B.CLS_CLAVE || ' / ' || B.CLS_NOMBRE NOMBRESUB, A.CLS_CLAVE || ' / ' || A.CLS_NOMBRE NOMBRE"; 
        strSql+=" FROM SD_CLASIFICACION_SUB A, SD_CLASIFICACION B";
        strSql+=" WHERE  A.CLS_SERIE = B.ID_CLASIFICACION";
        strSql+=" AND    A.CLS_SECCION = "+idsec+" AND A.ID_CLASIFICACION NOT IN("+idsecS+")";
        return strSql;
    }
    
  /**
   * Funcion que regresa la fecha del servidor 
   * @return Query consulta
   */  
    public static String getDate()
    {

        String strSql = "";
        strSql =" SELECT TO_CHAR(SYSDATE,'dd/MM/yyyy') FROM  DUAL"; 
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del tipo de valor
     * @return Query
     */
    public static String getDatosTodoValor()
    {
        String strSql = "";
        strSql = "SELECT ID_VALOR, V_NOMBRE ";
        strSql+=" FROM SD_VALOR  WHERE V_STATUS=1 ORDER BY 2";

        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos dela lista de seccion
     * @param strOrden orden
     * @param tipo tipo de orden
     * @return Query consulta
     */
    public static String getDatosSeccion(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = " SELECT D.FON_NOMBRE, D.FON_CLAVE, B.SUBF_NOMBRE, B.SUBF_CLAVE, ";
        strSql+="  A.ID_SECCION ,A.SEC_CLAVE ,  A.SEC_NOMBRE, A.SEC_DESCRIPCION, decode(A.SEC_STATUS ,1,'Activo',3,'Inactivo')";
        strSql+=" FROM SD_SECCION_ARCH A, SD_SUBFONDOARCH B,  SD_FONDO_ARCH D ";
        strSql+=" WHERE D.ID_FONDO = A.SEC_FONDO and B.ID_SUBFONDO = A.SEC_SUBFONDO AND";
        strSql+=" A.SEC_STATUS in (1,3)";
        if(tipo.equals("1")){
			strSql+="ORDER BY 6 "+strOrden+", 2 "+strOrden+", 4 "+strOrden+" ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 2 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+" ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 4 "+strOrden+", 6 "+strOrden+", 2 "+strOrden+" ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 7 "+strOrden+", 6 "+strOrden+", 2 "+strOrden+", 4 "+strOrden+" ";
		}else if(tipo.equals("5")){
			strSql+="ORDER BY 8 "+strOrden+", 6 "+strOrden+", 2 "+strOrden+", 4 "+strOrden+" ";
		}else if(tipo.equals("6")){
			strSql+="ORDER BY 9 "+strOrden+", 6 "+strOrden+", 2 "+strOrden+", 4 "+strOrden+" ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos dela lista de subserie
     * @param strOrden orden
     * @param tipo tipo de orden
     * @return Query consulta
     */
    public static String getDatosSubSerieA(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT a.ID_SUBSERIE, a.SUBS_NOMBRE, a.SUBS_DESCRIPCION, b.SER_NOMBRE,a.SUBS_CLAVE ";
        strSql+=" FROM SD_SUBSERIE a,SD_SERIE b WHERE SUBS_STATUS=1 AND a.SUBS_SERIE = b.ID_SERIE ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del expediente
     * @param strOrden orden
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosXpediente(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT ex.ID_EXPEDIENTE, ex.EXP_DENOMINACION, ex.EXP_DESCRIPCION, ex.EXP_CLAVE,decode(ex.EXP_STATUS ,1,'Activo',3,'Inactivo') ";
        strSql+=" , ex.EXP_CVE_UA, cv.ARE_CLAVE";
        strSql+=" FROM SD_EXPEDIENTES ex, SD_AREA cv  WHERE EXP_STATUS in (1,3) and cv.ID_AREA	= ex.EXP_CVE_UA ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 4 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 2 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 3 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("5")){
			strSql+="ORDER BY 7 "+strOrden+", 4 ASC ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del tipo de valor
     * @param strOrden orden
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosValor(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT ID_VALOR, V_NOMBRE, V_DESCRIPCION, V_CLAVE,decode(V_STATUS ,1,'Activo',3,'Inactivo') ";
        strSql+="FROM SD_VALOR WHERE V_STATUS in (1,3)";
        if(tipo.equals("1")){
			strSql+="ORDER BY 4 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 2 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 3 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 4 ASC ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del tipo de cedula
     * @param strOrden orden
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosTipoCedula(String strOrden, String tipo)
    {
        String strSql = "";
	    strSql = " SELECT f.CLS_CLAVE, s.CLS_CLAVE, h.SEC_CLAVE, g.SUBF_CLAVE, d.FON_CLAVE,";
	    strSql+=" f.CLS_NOMBRE, s.CLS_NOMBRE, h.SEC_NOMBRE, g.SUBF_NOMBRE, d.FON_NOMBRE, ";
	    strSql+="  a.CED_NOMBRE, DECODE(a.CED_STATUS ,1,'Activo',3,'Inactivo'), a.ID_CEDULA, a.CED_CVE_UA,cv.ARE_CLAVE,a.CED_CLAVE";
	    strSql+=" FROM SD_TIPO_CEDULA a, SD_CLASIFICACION_SUB  f, SD_SUBFONDOARCH  g, ";
	    strSql+=" SD_SECCION_ARCH h , SD_FONDO_ARCH d, SD_CLASIFICACION s , SD_AREA cv";
	    strSql+=" WHERE  d.ID_FONDO = f.CLS_FONDO ";
	    strSql+=" AND cv.ID_AREA	= a.CED_CVE_UA  ";
	    strSql+=" AND g.ID_SUBFONDO = f.CLS_SUBFONDO  ";
	    strSql+=" AND h.ID_SECCION  = f.CLS_SECCION ";
	    strSql+=" AND s.ID_CLASIFICACION = f.CLS_SERIE ";
	    strSql+=" AND CED_ICDD_UASUB = f.ID_CLASIFICACION ";
	    strSql+=" AND a.CED_STATUS in( 1,3)";
	    strSql+=" UNION ";
	    strSql+= " SELECT 'Sin Subserie', f.CLS_CLAVE, h.SEC_CLAVE, g.SUBF_CLAVE, d.FON_CLAVE,";
	    strSql+=" 'Sin Subserie', f.CLS_NOMBRE, h.SEC_NOMBRE, g.SUBF_NOMBRE, d.FON_NOMBRE,";
	    strSql+="  a.CED_NOMBRE, DECODE(a.CED_STATUS ,1,'Activo',3,'Inactivo'), a.ID_CEDULA, a.CED_CVE_UA,cv.ARE_CLAVE,a.CED_CLAVE";
	    strSql+=" FROM SD_TIPO_CEDULA a, SD_SUBFONDOARCH  g, ";
	    strSql+=" SD_SECCION_ARCH h , SD_FONDO_ARCH d, SD_CLASIFICACION f, SD_AREA cv ";
	    strSql+=" WHERE  d.ID_FONDO = f.CLS_FONDO ";
	    strSql+=" AND cv.ID_AREA	= a.CED_CVE_UA  ";
	    strSql+=" AND g.ID_SUBFONDO = f.CLS_SUBFONDO  ";
	    strSql+=" AND h.ID_SECCION  = f.CLS_SECCION ";
	    strSql+=" AND a.CED_ICDD_UAS = f.ID_CLASIFICACION ";
	    strSql+=" AND a.CED_STATUS IN( 1,3)";
        
        
        
        if(tipo.equals("1")){
			strSql+="ORDER BY 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+" ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+", 5 "+strOrden+" ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+" ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+" ";
		}else if(tipo.equals("5")){
			strSql+="ORDER BY 1 "+strOrden+", 14 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+" ";
		}else if(tipo.equals("6")){
			strSql+="ORDER BY 11 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+" ";
		}else if(tipo.equals("7")){
			strSql+="ORDER BY 12 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+" ";
		}else if(tipo.equals("8")){
			strSql+="ORDER BY 14 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+" ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del Seleccion
     * @param strOrden orden
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosSeleccion(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT ID_SELECCION, SEL_NOMBRE, SEL_DESCRIPCION,SEL_CLAVE,DECODE(SEL_STATUS,1,'Activo',3,'Inactivo') ";
        strSql+="FROM SD_SELECCION WHERE SEL_STATUS IN (1,3)";
        if(tipo.equals("1")){
			strSql+="ORDER BY 4 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 2 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 3 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 4 ASC ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del fondo
     * @param strOrden orden
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosFondo(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT ID_FONDO, FON_NOMBRE, FON_DESCRIPCION ,FON_CLAVE,decode(FON_STATUS ,1,'Activo',3,'Inactivo') ";
        strSql+="FROM SD_FONDO_ARCH   WHERE FON_STATUS in (1,3) ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 4 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 2 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 3 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 4 ASC ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del cuadro de disposicion
     * @param strOrden orden
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosicddview(String strOrden, String tipo)
    {
        String strSql = "";
	    strSql = " SELECT f.CLS_CLAVE, s.CLS_CLAVE, h.SEC_CLAVE, g.SUBF_CLAVE, d.FON_CLAVE,";
	    strSql+=" f.CLS_NOMBRE, s.CLS_NOMBRE, h.SEC_NOMBRE, g.SUBF_NOMBRE, d.FON_NOMBRE, ";
	    strSql+="  TO_CHAR(a.ICDD_FEC_REGISTRO, 'dd/MM/yyyy'), DECODE(a.ICDD_STATUS ,1,'Activo',3,'Inactivo'),a.ID_ICDD_UA, cv.ARE_CLAVE, cv.ID_AREA ";
	    strSql+=" FROM SD_ICDD_UA a, SD_CLASIFICACION_SUB  f, SD_SUBFONDOARCH  g, ";
	    strSql+=" SD_SECCION_ARCH h , SD_FONDO_ARCH d, SD_CLASIFICACION s, SD_AREA cv ";
	    strSql+=" WHERE  d.ID_FONDO = f.CLS_FONDO ";
	    strSql+=" AND cv.ID_AREA	= a.ICDD_CLAVE_UA  ";
	    strSql+=" AND g.ID_SUBFONDO = f.CLS_SUBFONDO  ";
	    strSql+=" AND h.ID_SECCION  = f.CLS_SECCION ";
	    strSql+=" AND s.ID_CLASIFICACION = f.CLS_SERIE ";
	    strSql+=" AND a.ICDD_CLAVES_SUBSERIES = f.ID_CLASIFICACION ";
	    strSql+=" AND a.ICDD_STATUS IN( 1,3)";
	    strSql+=" UNION ";
	    strSql+= " SELECT 'Sin Subserie', f.CLS_CLAVE, h.SEC_CLAVE, g.SUBF_CLAVE, d.FON_CLAVE,";
	    strSql+=" 'Sin Subserie', f.CLS_NOMBRE, h.SEC_NOMBRE, g.SUBF_NOMBRE, d.FON_NOMBRE,";
	    strSql+="  TO_CHAR(a.ICDD_FEC_REGISTRO, 'dd/MM/yyyy'),DECODE(a.ICDD_STATUS ,1,'Activo',3,'Inactivo'),a.ID_ICDD_UA, cv.ARE_CLAVE, cv.ID_AREA ";
	    strSql+=" FROM SD_ICDD_UA a, SD_SUBFONDOARCH  g, ";
	    strSql+=" SD_SECCION_ARCH h , SD_FONDO_ARCH d, SD_CLASIFICACION f, SD_AREA cv ";
	    strSql+=" WHERE  d.ID_FONDO = f.CLS_FONDO ";
	    strSql+=" AND cv.ID_AREA	= a.ICDD_CLAVE_UA  ";
	    strSql+=" AND g.ID_SUBFONDO = f.CLS_SUBFONDO  ";
	    strSql+=" AND h.ID_SECCION  = f.CLS_SECCION ";
	    strSql+=" AND a.ICDD_CLAVES_SERIES = f.ID_CLASIFICACION ";
	    strSql+=" AND a.ICDD_STATUS in( 1,3)";
	    
        if(tipo.equals("1")){
			strSql+="ORDER BY 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+" ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+", 5 "+strOrden+" ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+" ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+" ";
		}else if(tipo.equals("5")){
			strSql+="ORDER BY 1 "+strOrden+", 14 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+" ";
		}else if(tipo.equals("6")){
			strSql+="ORDER BY 11 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+" ";
		}else if(tipo.equals("7")){
			strSql+="ORDER BY 12 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+", 14 "+strOrden+" ";
		}else if(tipo.equals("8")){
			strSql+="ORDER BY 14 "+strOrden+", 5 "+strOrden+", 4 "+strOrden+", 3 "+strOrden+", 2 "+strOrden+", 1 "+strOrden+" ";
		}
        return strSql;
    }
    /**
     * Función que regresa un quey donde muesta los datos del combinacion
     * @param strOrden orden
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosCombinacion(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT a.ID_COMBINACION, a.COM_CLAVE,a.COM_DESCRIPCION, b.SUBS_NOMBRE,c.SEC_NOMBRE,d.SUBF_NOMBRE,e.SER_NOMBRE,f.FON_NOMBRE ";
        strSql+=" FROM SD_COMBINACION a, SD_SUBSERIE b, SD_SECCION_ARCH c,SD_SUBFONDOARCH d,SD_FONDO_ARCH f, SD_SERIE e WHERE a.COM_STATUS=1  AND a.COM_FONDO = d.ID_SUBFONDO ";
        strSql+=" AND  a.COM_SERIE = b.ID_SUBSERIE AND a.COM_SECCION = c.ID_SECCION and d.SUBF_FONDO = f.ID_FONDO and e.ID_SERIE = b.SUBS_SERIE ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
        return strSql;
    }
    /**
     * Función que regresa un query donde muesta los datos del clasificacion serie
     * @param strOrden orden
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosClasificacion(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT f.ID_CLASIFICACION, f.CLS_CLAVE, d.FON_NOMBRE, d.FON_CLAVE, ";
        strSql+=" g.SUBF_NOMBRE, g.SUBF_CLAVE,  h.SEC_NOMBRE, h.SEC_CLAVE, f.CLS_NOMBRE, f.CLS_DESCRIPCION,decode(f.CLS_STATUS ,1,'Activo',3,'Inactivo') ";
        strSql+=" FROM SD_CLASIFICACION f, SD_SUBFONDOARCH  g, SD_SECCION_ARCH h , SD_FONDO_ARCH d  WHERE  d.ID_FONDO = f.CLS_FONDO ";
        strSql+=" AND g.ID_SUBFONDO = f.CLS_SUBFONDO   AND h.ID_SECCION  = f.CLS_SECCION  ";
        strSql+=" AND f.CLS_STATUS in(1,3) ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+", 2 "+strOrden+" ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 6 "+strOrden+", 8 "+strOrden+", 2 "+strOrden+", 4 "+strOrden+" ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 8 "+strOrden+", 2 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+" ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 2 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+" ";
		}else if(tipo.equals("5")){
			strSql+="ORDER BY 9 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+", 2 "+strOrden+" ";
		}else if(tipo.equals("6")){
			strSql+="ORDER BY 10 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+", 2 "+strOrden+" ";
		}else if(tipo.equals("7")){
			strSql+="ORDER BY 11 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+", 2 "+strOrden+" ";
		}
        return strSql;
    }
    /**
     * Función que regresa un query donde muesta los datos del clasificacion subserie
     * @param strOrden orden
     * @param tipo tipo de ordeno
     * @return Query
     */
    public static String getDatosClasificacionsub(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = " SELECT f.ID_CLASIFICACION , f.CLS_CLAVE, d.FON_NOMBRE, d.FON_CLAVE, ";
        strSql+=" g.SUBF_NOMBRE, g.SUBF_CLAVE,  h.SEC_NOMBRE, h.SEC_CLAVE,";
        strSql+=" s.CLS_NOMBRE, s.CLS_CLAVE,f.CLS_NOMBRE, f.CLS_DESCRIPCION ,DECODE(f.CLS_STATUS,1,'Activo',3,'Inactivo')";
        strSql+=" FROM SD_CLASIFICACION_SUB  f, SD_SUBFONDOARCH  g, ";
        strSql+=" SD_SECCION_ARCH h , SD_FONDO_ARCH d, SD_CLASIFICACION s ";
        strSql+=" WHERE  d.ID_FONDO = f.CLS_FONDO  AND g.ID_SUBFONDO = f.CLS_SUBFONDO ";
        strSql+=" AND h.ID_SECCION  = f.CLS_SECCION AND  s.ID_CLASIFICACION = f.CLS_SERIE ";
        strSql+=" AND f.CLS_STATUS  in(1,3) ";        
        if(tipo.equals("1")){
			strSql+="ORDER BY 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+", 10 "+strOrden+", 2 "+strOrden+" ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 6 "+strOrden+", 8 "+strOrden+", 10 "+strOrden+", 2 "+strOrden+", 4 "+strOrden+" ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 8 "+strOrden+", 10 "+strOrden+", 2 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+" ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 10 "+strOrden+", 2 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+" ";
		}else if(tipo.equals("5")){
			strSql+="ORDER BY 2 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+", 10 "+strOrden+" ";
		}else if(tipo.equals("6")){
			strSql+="ORDER BY 11 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+", 10 "+strOrden+", 2 "+strOrden+" ";
		}else if(tipo.equals("7")){
			strSql+="ORDER BY 12 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+", 10 "+strOrden+", 2 "+strOrden+" ";
		}else if(tipo.equals("8")){
			strSql+="ORDER BY 13 "+strOrden+", 4 "+strOrden+", 6 "+strOrden+", 8 "+strOrden+", 10 "+strOrden+", 2 "+strOrden+" ";
		}
        return strSql;
    }    
    /**
     * Función que regresa un query donde muesta los datos del clasificacion detalle serie
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosClasificacionDeta(String tipo)
    {
        String strSql = "";
        strSql = " SELECT d.VAL_NOMBRE,b.SEL_NOMBRE,h.SEC_NOMBRE,f.SUBS_NOMBRE,g.SUBF_NOMBRE ,e.SER_NOMBRE,m.FON_NOMBRE ";
            strSql+=" FROM  SD_CLASIFICACION a,SD_SELECCION b,SD_COMBINACION  c, SD_VALORACION d, ";
                strSql+=" SD_SUBSERIE f, SD_SUBFONDOARCH  g, SD_SECCION_ARCH h , SD_FONDO_ARCH m, SD_SERIE e ";
                    strSql+=" WHERE a.CLS_COMBINACION = c.ID_COMBINACION ";
                        strSql+=" AND a.CLS_VALORACION = d.ID_VALORACION   ";
                            strSql+=" AND a.CLS_SELECCION = b.ID_SELECCION ";
                                strSql+=" AND c.COM_SECCION= h.ID_SECCION  ";
                                    strSql+=" AND c.COM_SERIE = f.ID_SUBSERIE ";
                                        strSql+=" AND c.COM_FONDO = g.ID_SUBFONDO ";
                                        	strSql+=" AND g.SUBF_FONDO = m.ID_FONDO AND e.ID_SERIE = f.SUBS_SERIE ";
                                        		strSql+=" AND id_CLASIFICACION = "+tipo+" ";
          return strSql;
    }
    /**
     * Función que regresa un query donde muesta los datos del clasificacion detalle subserie
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosClasificacionDetasub(String tipo)
    {
        String strSql = "";
        strSql = " SELECT d.VAL_NOMBRE,b.SEL_NOMBRE,h.SEC_NOMBRE,f.SUBS_NOMBRE,g.SUBF_NOMBRE ,e.SER_NOMBRE,m.FON_NOMBRE ";
            strSql+=" FROM  SD_CLASIFICACION_SUB a,SD_SELECCION b,SD_COMBINACION  c, SD_VALORACION d, ";
                strSql+=" SD_SUBSERIE f, SD_SUBFONDOARCH  g, SD_SECCION_ARCH h , SD_FONDO_ARCH m, SD_SERIE e ";
                    strSql+=" WHERE a.CLS_COMBINACION = c.ID_COMBINACION ";
                        strSql+=" AND a.CLS_VALORACION = d.ID_VALORACION   ";
                            strSql+=" AND a.CLS_SELECCION = b.ID_SELECCION ";
                                strSql+=" AND c.COM_SECCION= h.ID_SECCION  ";
                                    strSql+=" AND c.COM_SERIE = f.ID_SUBSERIE ";
                                        strSql+=" AND c.COM_FONDO = g.ID_SUBFONDO ";
                                        	strSql+=" AND g.SUBF_FONDO = m.ID_FONDO AND e.ID_SERIE = f.SUBS_SERIE ";
                                        		strSql+=" AND id_CLASIFICACION = "+tipo+" ";
          return strSql;
    }    
    /**
     * Función que regresa un query donde muesta los datos del cedula detalle 
     * @param tipo tipo de orden
     * @return Query
     */
    public static String getDatosCedulaDeta(String tipo)
    {
        String strSql = "";
	    strSql = " SELECT f.CLS_CLAVE, s.CLS_CLAVE, h.SEC_CLAVE, g.SUBF_CLAVE, d.FON_CLAVE,";
	    strSql+=" f.CLS_NOMBRE, s.CLS_NOMBRE, h.SEC_NOMBRE, g.SUBF_NOMBRE, d.FON_NOMBRE ";
	    strSql+=" FROM SD_TIPO_CEDULA a, SD_CLASIFICACION_SUB  f, SD_SUBFONDOARCH  g, ";
	    strSql+=" SD_SECCION_ARCH h , SD_FONDO_ARCH d, SD_CLASIFICACION s ";
	    strSql+=" WHERE  d.ID_FONDO = f.CLS_FONDO ";
	    strSql+=" AND g.ID_SUBFONDO = f.CLS_SUBFONDO  ";
	    strSql+=" AND h.ID_SECCION  = f.CLS_SECCION ";
	    strSql+=" AND s.ID_CLASIFICACION = f.CLS_SERIE ";
	    strSql+=" AND a.CED_ICDD_UASUB = f.ID_CLASIFICACION ";
	    strSql+=" AND a.ID_CEDULA = "+tipo+" ";
	    strSql+=" UNION ";
	    strSql+= " SELECT 'NINGUNO', f.CLS_CLAVE, h.SEC_CLAVE, g.SUBF_CLAVE, d.FON_CLAVE,";
	    strSql+=" 'NINGUNO', f.CLS_NOMBRE, h.SEC_NOMBRE, g.SUBF_NOMBRE, d.FON_NOMBRE ";
	    strSql+=" FROM SD_TIPO_CEDULA a, SD_SUBFONDOARCH  g, ";
	    strSql+=" SD_SECCION_ARCH h , SD_FONDO_ARCH d, SD_CLASIFICACION f ";
	    strSql+=" WHERE  d.ID_FONDO = f.CLS_FONDO ";
	    strSql+=" AND g.ID_SUBFONDO = f.CLS_SUBFONDO  ";
	    strSql+=" AND h.ID_SECCION  = f.CLS_SECCION ";
	    strSql+=" AND a.CED_ICDD_UAS = f.ID_CLASIFICACION ";
	    strSql+=" AND a.ID_CEDULA = "+tipo+" ";
          return strSql;
    }
    /**
     * Función que regresa un query donde muesta los datos de Años acumalados detalle 
     * @param tipo id expediente
     * @return Query
     */
    public static String getDatosDetalle(String tipo)
    {
        String strSql = "";
	    strSql = " SELECT DISTINCT EXP_OPERACION , EXP_ANIO_SUMA, EXP_FEC_ACTUALIZACION, EXP_USUARIO ";
	    strSql+=" FROM SD_EXPEDIENTES_DETALLE ";
	    strSql+=" WHERE EXP_EXPEDIENTE = "+tipo+" ORDER BY EXP_FEC_ACTUALIZACION";

          return strSql;
    }
    /**
     * Función que regresa un query donde muesta los datos del detalle de una clave de cedula tipo
     * @param tipo id cedula
     * @return Query
     */
    public static String getDatosCedulaClave(String tipo)
    {
        String strSql = "";
	    strSql = " SELECT f.CLS_CLAVE, s.CLS_CLAVE, h.SEC_CLAVE, g.SUBF_CLAVE, d.FON_CLAVE ,cv.ARE_CLAVE,a.CED_CLAVE,a.CED_NOMBRE, d.FON_SISI,";
	    strSql+=" f.CLS_VIGENCIA_AT, f.CLS_VIGENCIA_AC, f.CLS_ANOS_RESERVA, a.CED_FUNDAMENTO, a.CED_MOTIVO  ";
	    strSql+=" FROM SD_TIPO_CEDULA a, SD_CLASIFICACION_SUB  f, SD_SUBFONDOARCH  g, ";
	    strSql+=" SD_SECCION_ARCH h , SD_FONDO_ARCH d, SD_CLASIFICACION s, SD_AREA cv ";
	    strSql+=" WHERE  d.ID_FONDO = f.CLS_FONDO ";
	    strSql+=" AND cv.ID_AREA	= a.CED_CVE_UA  ";	
	    strSql+=" AND g.ID_SUBFONDO = f.CLS_SUBFONDO  ";
	    strSql+=" AND h.ID_SECCION  = f.CLS_SECCION ";
	    strSql+=" AND s.ID_CLASIFICACION = f.CLS_SERIE ";
	    strSql+=" AND a.CED_ICDD_UASUB = f.ID_CLASIFICACION ";
	    strSql+=" AND a.ID_CEDULA = "+tipo+" ";
                                      
          return strSql;
    }
    /**
     * Función que regresa un query donde muesta los datos del detalle de una clave de cedula tipo
     * @param tipo id cedual
     * @return Query
     */
    public static String getDatosCedulaClave2(String tipo)
    {
        String strSql = "";
	    strSql = "SELECT f.CLS_CLAVE, h.SEC_CLAVE, g.SUBF_CLAVE, d.FON_CLAVE ,cv.ARE_CLAVE,a.CED_CLAVE,a.CED_NOMBRE, d.FON_SISI, ";
	    strSql+=" f.CLS_VIGENCIA_AT, f.CLS_VIGENCIA_AC, f.CLS_ANOS_RESERVA, a.CED_FUNDAMENTO, a.CED_MOTIVO   ";
	    strSql+=" FROM SD_TIPO_CEDULA a, SD_CLASIFICACION f, SD_SUBFONDOARCH  g, ";
	    strSql+=" SD_SECCION_ARCH h , SD_FONDO_ARCH d , SD_AREA cv";
	    strSql+=" WHERE  d.ID_FONDO = f.CLS_FONDO ";
	    strSql+=" AND cv.ID_AREA	= a.CED_CVE_UA  ";	    
	    strSql+=" AND g.ID_SUBFONDO = f.CLS_SUBFONDO  ";
	    strSql+=" AND h.ID_SECCION  = f.CLS_SECCION ";
	    strSql+=" AND a.CED_ICDD_UAS = f.ID_CLASIFICACION ";
	    strSql+=" AND a.ID_CEDULA = "+tipo+" ";
                                      
          return strSql;
    }   
    /**
     * Función que regresa un query donde muesta los datos del valoracion
     * @param tipo id valoracion
     * @return Query
     */
    public static String getDatosValorDeta(String tipo)
    {
        String strSql = "";
        strSql = " SELECT VAL_VALORACIONES1 FROM SD_VALORACION ";
        strSql+=" WHERE ID_VALORACION = "+tipo+" ";
          return strSql;
    }
    /**
     * Función que regresa un query donde muesta los Años acomulados para expediente
     * @param id id expediente
     * @return Query
     */
    public static String getDatosExpAcom(String id)
    {
        String strSql = "";
        strSql = " SELECT  NVL(Max(EXP_ANIOS_AMPLI),0) FROM SD_EXPEDIENTES  ";
        strSql+=" WHERE ID_EXPEDIENTE = "+id+" ";
          return strSql;
    }
    /**
     * Función que regresa un query donde muesta los datos del valor
     * @param tipo id valor
     * @return Query
     */
    public static String getDatosValor2Deta(String tipo)
    {
        String strSql = "";
        strSql = " SELECT V_nombre FROM SD_VALOR ";
        strSql+="  WHERE ID_VALOR IN ("+tipo+")";
          return strSql;
    }
    /**
     * Función que regresa un query donde muesta los datos de la combinacion
     * @param tipo id combinacion
     * @return Query
     */
    public static String getDatosCombiDeta(String tipo)
    {
        String strSql = "";

          
        strSql = " SELECT h.SEC_NOMBRE,f.SUBS_NOMBRE,g.SUBF_NOMBRE,e.SER_NOMBRE,d.FON_NOMBRE ";
        strSql+=" FROM SD_COMBINACION  c, ";
            strSql+=" SD_SUBSERIE f, SD_SUBFONDOARCH  g, SD_SECCION_ARCH h , SD_FONDO_ARCH d, SD_SERIE e ";
                    strSql+=" WHERE c.COM_SECCION= h.ID_SECCION   ";
                        strSql+=" AND c.COM_SERIE = f.ID_SUBSERIE ";
                            strSql+=" AND c.COM_FONDO = g.ID_SUBFONDO ";
                            strSql+=" AND g.SUBF_FONDO = d.ID_FONDO AND e.ID_SERIE = f.SUBS_SERIE ";
                            strSql+=" AND c.COM_STATUS = 1 ";
                                        strSql+=" AND  c.ID_COMBINACION= "+tipo+" ";                                            
           return strSql;
    }
    /**
     * Función que regresa un query donde muesta los datos de la serie
     * @param tipo tipo de orden
     * @param strOrden ordenamiento
     * @return Query consulta
     */
    public static String getDatosSerie(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT ID_SERIE, SER_NOMBRE, SER_DESCRIPCION, SER_CLAVE ";
        strSql+="FROM SD_SERIE   WHERE SER_STATUS=1   ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 2 "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
        return strSql;
    }
    /**
     * Función que regresa un query donde muesta los datos de la clasificacion de la informacion
     * @param tipo tipo de orden
     * @param strOrden ordenamiento
     * @return Query consulta
     */
    public static String getClasifInf(String strOrden, String tipo)
    {
        String strSql = "";
        strSql = "SELECT ID_CLASIF_INF, CLSI_NOMBRE,CLSI_DESCRIPCION, CLSI_CLAVE,decode(CLSI_STATUS ,1,'Activo',3,'Inactivo') ";
        strSql+="FROM SD_CLASIF_INF   WHERE CLSI_STATUS in (1,3)   ";
        if(tipo.equals("1")){
			strSql+="ORDER BY 4 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 2 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("3")){
			strSql+="ORDER BY 3 "+strOrden+", 4 ASC ";
		}else if(tipo.equals("4")){
			strSql+="ORDER BY 5 "+strOrden+", 4 ASC ";
		}
        return strSql;
    }
    /**
     * Llenar combo de expedientes por Area
     * @param IdArea id del area 
     * @return Query consulta
     */
    public static String getConsulExpCombo(String IdArea)
	{
		String strSql="";		
		strSql=	" SELECT ID_EXPEDIENTE, EXP_DENOMINACION FROM SD_EXPEDIENTES  WHERE EXP_STATUS=1  " +
				"AND EXP_CVE_UA="+IdArea+" ORDER BY EXP_DENOMINACION";												
		return strSql;	
	}
    /**
     * Llenar combo de expedientes 
     * @return Query consulta
     */
    public static String getConsulExpCombo()
	{
		String strSql="";		
		strSql=	" SELECT ID_EXPEDIENTE, EXP_DENOMINACION FROM SD_EXPEDIENTES  WHERE EXP_STATUS=1  " +
		" ORDER BY EXP_DENOMINACION";												
		return strSql;	
	}
    /**
     * Llenar combo de subfondos por subfondo
     * @param Id id subfondo
     * @return Query consulta
     */
    public static String getFondoCombo(String Id)
	{
		String strSql="";		
		strSql=	"SELECT ID_SUBFONDO,SUBF_CLAVE || ' / ' || SUBF_NOMBRE NOMBRE  FROM SD_SUBFONDOARCH WHERE SUBF_STATUS=1 " +
				"AND ID_SUBFONDO="+Id+" ORDER BY SUBF_NOMBRE";												
		return strSql;	
	}
    /**
     * Llenar combo de fondos 
     * @return Query consulta
     */
    public static String getFondoCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_FONDO,FON_CLAVE || ' / ' || FON_NOMBRE NOMBRE FROM SD_FONDO_ARCH WHERE FON_STATUS=1 " +
				" ORDER BY FON_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Llenar combo de subfondos por subfondo
     * @param id id subfondo
     * @return Query consulta
     */
    public static String getSubFondoC(String id)
	{
		String strSql="";		
		strSql=	"SELECT ID_SUBFONDO,SUBF_CLAVE || ' / ' || SUBF_NOMBRE NOMBRE  FROM SD_SUBFONDOARCH WHERE SUBF_STATUS=1 " +
				"AND SUBF_FONDO ="+id+" ORDER BY SUBF_NOMBRE";												
		return strSql;	
	}
    /**
     * Llenar combo de fondos
     * @return Query consulta
     */
    public static String getFondoC()
	{
		String strSql="";		
		strSql=	"SELECT ID_FONDO,FON_CLAVE || ' / ' || FON_NOMBRE NOMBRE  FROM SD_FONDO_ARCH WHERE FON_STATUS=1 " +
				" ORDER BY FON_NOMBRE";												
		return strSql;	
	}
    /**
     * Llenar combo de combinaciones
     * @return Query consulta
     */
    public static String getCombinacionCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_COMBINACION,COM_CLAVE ||' - '||COM_NOMBRE CAMPO1  FROM SD_COMBINACION WHERE COM_STATUS=1 " +
				" ORDER BY COM_NOMBRE";												
		return strSql;	
	}
    /**
     * Llenar combo de valoraciones
     * @return Query consulta
     */
    public static String getValorCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_VALORACION,VAL_NOMBRE  FROM SD_VALORACION WHERE VAL_STATUS=1 " +
				" ORDER BY VAL_NOMBRE";												
		return strSql;	
	}
    /**
     * Listas de valoraciones
     * @param a ids de valor
     * @return Query consulta
     */
    public static String getValorComboSub(String a)
	{
       String b = "";
    	StringTokenizer tokens=new StringTokenizer(a,",");
    	while(tokens.hasMoreTokens()){
                b = b + tokens.nextToken();
                if(tokens.hasMoreTokens())
                    b = b + "','";
            }
    	////System.out.println("Emmanuel envia: "+b);
		String strSql="";		
		strSql=	"SELECT ID_VALORACION,VAL_NOMBRE  FROM SD_VALORACION WHERE VAL_STATUS=1 " +
				" AND  VAL_VALORACIONES1 IN ('"+b+"','"+a+"')" +
				" ORDER BY VAL_NOMBRE";												
		return strSql;	
	}    
    /**
     * Llenar combo de selecciones
     * @return Query consulta
     */
    public static String getSeleccionCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_SELECCION,SEL_NOMBRE  FROM SD_SELECCION WHERE SEL_STATUS=1 " +
				" ORDER BY SEL_NOMBRE";												
		return strSql;	
	}
    /**
     * Llenar combo de series
     * @return Query consulta
     */
    public static String getSerieComboA()
	{
		String strSql="";		
		strSql=	"SELECT ID_SERIE,SER_NOMBRE  FROM SD_SERIE WHERE SER_STATUS=1 " +
				" ORDER BY SER_NOMBRE";											
		return strSql;	
	}
    /**
     * Llenar combo de series por id
     * @param id id de la serie
     * @return
     */
    public static String getSerieComboC(String id)
	{
		String strSql="";		
		strSql=	"SELECT ID_SUBSERIE,SUBS_NOMBRE  FROM SD_SUBSERIE WHERE SUBS_STATUS=1 " +
				"AND SUBS_SERIE="+id+" ORDER BY SUBS_NOMBRE";											
		return strSql;	
	}
    /**
     * Llenar combo de series por id de seccion
     * @param idSec id de la seccion
     * @return Query consulta
     */
    public static String getSerieComboP(String idSec)
	{
		String strSql="";		
		strSql=	"SELECT ID_CLASIFICACION,CLS_CLAVE || ' / ' || CLS_NOMBRE NOMBRE  FROM SD_CLASIFICACION  WHERE CLS_STATUS=1 " +
			    "AND CLS_SECCION ="+idSec+" "+
				" ORDER BY CLS_NOMBRE";											
		return strSql;	
	}    
    /**
     * Llenar combo de seccion
     * @return Query consulta
     */
    public static String getSeccionComboA()
	{
		String strSql="";		
		/*strSql=	"SELECT ID_SECCION,SEC_CLAVE || ' / ' || SEC_NOMBRE NOMBRE  from SD_SECCION_ARCH WHERE SEC_STATUS=1 " +
			" ORDER BY SEC_NOMBRE";	*/										
		
		strSql=	"SELECT ID_SECCION, " +
				"SEC_CLAVE||'/'||SEC_NOMBRE||' - '||FON_CLAVE||'/'||FON_NOMBRE||' - '||SUBF_CLAVE||'/'||SUBF_NOMBRE " +
				"FROM SD_SECCION_ARCH, SD_FONDO_ARCH, SD_SUBFONDOARCH " +
				"WHERE SEC_STATUS=1 " +
				"AND SEC_FONDO = ID_FONDO " +
				"AND SEC_SUBFONDO = ID_SUBFONDO " +
				"ORDER BY SEC_NOMBRE ";											
		return strSql;	
	}
    /**
     * Listar secciones
     * @param strfondo id fondo
     * @param strSubfondo id subfondo
     * @return Query consulta
     */
    public static String getSeccionComboInst(String strfondo,String strSubfondo)
	{
		String strSql="";		
		strSql=	"SELECT ID_SECCION,SEC_CLAVE || ' / ' || SEC_NOMBRE NOMBRE FROM SD_SECCION_ARCH WHERE SEC_STATUS=1 " +
				" AND SEC_FONDO ="+strfondo+"  AND SEC_SUBFONDO ="+strSubfondo+" ORDER BY SEC_NOMBRE";											
		return strSql;	
	} 
    /**
     * Listar Subseries
     * @param Id subserie
     * @return Query consulta
     */
    public static String getSerieCombo(String Id)
	{
		String strSql="";		
		strSql=	"SELECT ID_SUBSERIE,SUBS_NOMBRE  FROM SD_SUBSERIE WHERE SUBS_STATUS=1 " +
				"AND ID_SUBSERIE="+Id+" ORDER BY SUBS_NOMBRE";												
		return strSql;	
	}
    /**
     * Listar series
     * @return Query consulta
     */
    public static String getSerieCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_SERIE,SER_NOMBRE  FROM SD_SERIE WHERE SER_STATUS=1 " +
				" ORDER BY SER_NOMBRE";												
		return strSql;	
	}
    /**
     * Llenar combo clasificacion por id
     * @param id id de la clasificacion
     * @return Query consulta
     */
    public static String getClasifCombo(String id)
	{
		String strSql="";		
		strSql=	"SELECT a.ID_CLASIFICACION, a.CLS_NOMBRE FROM SD_CLASIFICACION a,SD_TIPO_CEDULA b WHERE a.CLS_STATUS=1 " +
		" AND a.CLS_COMBINACION = b.CED_COMB "+
		" AND b.ID_CEDULA ="+id+
		" ORDER BY a.CLS_DESCRIPCION ";												
		return strSql;	
	}
    /**
     * Llenar combo clasificacion por id
     * @param id id de la clasificacion
     * @return Query consulta
     */
    public static String getClasifCombosub(String id)
	{
		String strSql="";		
		strSql=	"SELECT a.ID_CLASIFICACION, a.CLS_NOMBRE FROM SD_CLASIFICACION_SUB a,SD_TIPO_CEDULA b WHERE a.CLS_STATUS=1 " +
		" AND a.CLS_COMBINACION = b.CED_COMB "+
		" AND b.ID_CEDULA ="+id+
		" ORDER BY a.CLS_DESCRIPCION ";												
		return strSql;	
	}    
    /**
     * Llenar combo de cedula tipo por UA
     * @param id
     * @return Query consulta
     */
    public static String getCedCombo(String id)
	{
		String strSql="";		
		strSql=	"SELECT ID_CEDULA,CED_NOMBRE from SD_TIPO_CEDULA WHERE CED_STATUS=1 " +
				" AND CED_CVE_UA = '" +id+ "'"+
				" ORDER BY CED_DESCRIPCION ";												
		return strSql;	
	}
    /**
     * LLenar combo con ubicaciones
     * @param Ubi
     * @return Query consulta
     */
    public static String getComboUbi(String Ubi)
	{
		String strSql="";		
		strSql=	"SELECT ID_UBICACION,UNI_DESCRIPCION FROM sd_ubicacion " +
				" WHERE UBI_AREA = "+Ubi +
				" AND UBI_ESTATUS = 1"+
				" ORDER BY UNI_DESCRIPCION ";												
		return strSql;	
	}    
    /**
     * Llenar com bo con las clasificaciones de la Informacion
     * @return Query consulta
     */
    public static String getClasifInfCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_CLASIF_INF, CLSI_NOMBRE  FROM SD_CLASIF_INF WHERE CLSI_STATUS=1 " +
				" ORDER BY CLSI_DESCRIPCION ";												
		return strSql;	
	}
    /**
     * Función que regresa un query con los datos de un subfondo 
     * por medio de si id
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @return Query consulta Query
     */
    public static String getSubfondo(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT SUB_CODIGO, SUB_SECCION, TO_CHAR(SUB_FECHA_CREACION, 'dd/MM/yyyy'), SUB_USR_ACTUALIZO " +
        		"FROM SD_SUBFONDO WHERE ID_SUBFONDO="+strIdSubfondo;
        return sql;
    }

    /**
     * Función que regresa un query con los datos de una valoracion
     * por medio de su id
     * @param strIdSubfondo Contiene el Id de valoracion
     * @return Query
     */
    public static String getValoracion(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT VAL_NOMBRE, VAL_DESCRIPCION, TO_CHAR(VAL_FEC_ACTUALIZACION, 'dd/MM/yyyy'), VAL_USUARIO, VAL_VALORACIONES1, VAL_VALORACIONES2, VAL_VALORACIONES3,VAL_CLAVE," +
        " TO_CHAR(VAL_FEC_INACTIVA, 'dd/MM/yyyy'), VAL_JUSTIFICA, VAL_STATUS, TO_CHAR(SYSDATE, 'dd/MM/yyyy') " +
        	  " FROM SD_VALORACION WHERE ID_VALORACION="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que verifica si existe una valoracion
     * @param val1 valor 1
     * @param val2 valor 2
     * @param val3 valor 3
     * @return Query consulta
     */
    public static String getExiteValoracion(String val1, String val2, String val3)
    
    {
        String valor1 = " = " + val1;
        String valor2 = " = " + val2;
        String valor3 = " = " + val3;
        
        
        if(val1== null || val1.equalsIgnoreCase(""))valor1=" IS NULL";
        if(val2== null || val2.equalsIgnoreCase(""))valor2=" IS NULL";
        if(val3== null || val3.equalsIgnoreCase(""))valor3=" IS NULL";
        String sql = "";
        sql = "SELECT VAL_NOMBRE Existe FROM SD_VALORACION WHERE val_status =1 AND VAL_VALORACIONES1 " + valor1 +
        	  " AND VAL_VALORACIONES2 "+valor2+" AND VAL_VALORACIONES3 "+valor3+"";
        return sql;
    }
    
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de SD_SUBFONDO 
     * @param soloDesc solo guarda descripcion
     * @param codigo codigo del subfondo
     * @param seccion Sección del subfondo
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param fondo id de fondo
     * @param IdSubfondo Id del registro
     * @param clv clave subfondo
     * @param fecInac fecha de inactividad
     * @param JusInac justificacion
     * @param inac Inactivo
     * @return Query
     */
    public static String actualizaSubfondoA(String soloDesc, String codigo, String seccion,
									String fecha, String Usr, String fondo, String IdSubfondo, String clv,
									String fecInac,String JusInac ,String inac)
    {
        String sql = "";
        if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
        {
		sql = "UPDATE SD_SUBFONDOARCH SET SUBF_DESCRIPCION='"+seccion+"'" +
		" WHERE ID_SUBFONDO="+IdSubfondo;
		return sql;
        }
        sql = "UPDATE SD_SUBFONDOARCH SET SUBF_NOMBRE='"+codigo+"', SUBF_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"SUBF_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), SUBF_USUARIO="+Usr+", " +
        		"SUBF_FONDO= "+fondo+
        		",SUBF_CLAVE = '"+clv+ "'," +
        		" SUBF_FEC_INACTIVA =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
        		" SUBF_JUSTIFICA = '"+ JusInac + "'," +
        		" SUBF_STATUS = '"+ inac + "'" + 
        		" WHERE ID_SUBFONDO="+IdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de Valoracion
     * @param soloDesc solo guarda descripcion
     * @param codigo codigo del subfondo
     * @param seccion Sección del subfondo
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo Id del registro
     * @param Val1 valor 1
     * @param Val2 valor 2
     * @param Val3 valor 3
     * @param clv clave de la valoracion
     * @param fecInac fecha de inactividad
     * @param JusInac justificacion
     * @param inac inactivo
     * @return Query consulta
     */
    public static String actualizaValoracion(String soloDesc,String codigo, String seccion,
									String fecha, String Usr, String IdSubfondo,String Val1[],String Val2,String Val3, String clv,
									String fecInac,String JusInac ,String inac)
    {
		String ids="";
		for(int i=0; i<Val1.length;i++)
		ids+=Val1[i]+",";
		ids=ids.substring(0,ids.length()-1);
		
        String sql = "";
        if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
        {
				sql = "UPDATE SD_VALORACION SET VAL_DESCRIPCION='"+seccion+"'" +
				" WHERE ID_VALORACION="+IdSubfondo;
				return sql;
        }
        sql = "UPDATE SD_VALORACION SET VAL_NOMBRE='"+codigo+"', VAL_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"VAL_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), VAL_USUARIO="+Usr+", " +
        		" VAL_VALORACIONES1= '"+ids+"'"+
        		" ,VAL_VALORACIONES2= "+Val2+
        		" ,VAL_VALORACIONES3= "+Val3+
        		" ,VAL_CLAVE = "+clv+
        		" , VAL_FEC_INACTIVA =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
        		"  VAL_JUSTIFICA = '"+ JusInac + "'," +
        		"  VAL_STATUS = '"+ inac + "'" +  
        		" WHERE ID_VALORACION="+IdSubfondo;
        return sql;
    }
    /**
     *  Función que regresa un query, donde se actualiza el registro de la 
     * tabla del cuadro de discposicion documental
     * @param series ids serie
     * @param subser ids subseries
     * @param fecha fecha actual
     * @param IdSubfondo id del registro
     * @param fecInac fecha de inactivo
     * @param JusInac justificacion
     * @param inac inactivo
     * @return Query consulta
     */
    public static String actualizaIcdd(String series[], String subser[],
									String fecha, String IdSubfondo,
									String fecInac,String JusInac ,String inac)
    {
		String ids="";
	
		String idsub="";

		
        String sql = "";
        sql = "UPDATE SD_ICDD_UA SET  " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		" ICDD_FEC_REGISTRO=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), " +
        		" ICDD_FEC_INACTIVIDAD =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
        		" ICDD_JUSTIFICACION = '"+ JusInac + "'," +
        		" ICDD_STATUS = '"+ inac + "'" +  
        		" WHERE ID_ICDD_UA="+IdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query donde se inserta datos a la
     * tabla de SD_SUBFONDO
     * @param codigo Codigo de subfondo
     * @param seccion Seccion del subfondo
     * @param fecha Fecha en la que se actualiza el registro
     * @param Usr Usuario que actualizo
     * @param fondo id fondo
     * @param clv clave del fondo
     * @return Query
     */
    public static String insertarSubfondoA(	String codigo, String seccion,
            								String fecha, String Usr, String fondo, String clv)
    {
        String sql = "";
        sql = "INSERT INTO SD_SUBFONDOARCH (ID_SUBFONDO, SUBF_NOMBRE, SUBF_DESCRIPCION,SUBF_USUARIO,SUBF_STATUS, SUBF_FEC_ACTUALIZACION,SUBF_FONDO,SUBF_CLAVE " +
        		") VALUES (subfondo_seq.NEXTVAL,'"+codigo+"', '"+seccion+"', " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+Usr+", 1,SYSDATE,"+fondo+",'"+clv+"')";
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un subfondo 
     * por medio de si id
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @return Query consulta Query---------------
     */
    public static String getSubfondoA(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT SUBF_NOMBRE, SUBF_DESCRIPCION, TO_CHAR(SUBF_FEC_ACTUALIZACION, 'dd/MM/yyyy'), SUBF_USUARIO, SUBF_FONDO, SUBF_CLAVE," +
        		" TO_CAHR(SUBF_FEC_INACTIVA, 'dd/MM/yyyy'), SUBF_JUSTIFICA, SUBF_STATUS,  TO_CHAR(SYSDATE, 'dd/MM/yyyy') " +
        		" FROM SD_SUBFONDOARCH   WHERE   ID_SUBFONDO="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un subSeccionfondo 
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @return Query
     */
    public static String getSeccion(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT SEC_NOMBRE, SEC_DESCRIPCION, TO_CHAR(SEC_FEC_ACTUALIZACION, 'dd/MM/yyyy'), SEC_USUARIO,SEC_CLAVE, " +
        	" TO_CHAR(SEC_FEC_INACTIVA, 'dd/MM/yyyy'), SEC_JUSTIFICA, SEC_STATUS, SEC_FONDO, SEC_SUBFONDO, TO_CHAR(SYSDATE, 'dd/MM/yyyy') " +
        		"FROM SD_SECCION_ARCH WHERE ID_SECCION="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de una icdd
     * por medio de su id
     * @param strId Contiene el Id 
     * @return Query
     */
    public static String getIcddId(String strId)
    {
        String sql = "";
        sql = "SELECT ICDD_CLAVE_UA, ICDD_SECCION, TO_CHAR(ICDD_FEC_ACTUALIZACION, 'dd/MM/yyyy'),ICDD_CLAVES_SERIES , " +
        	" ICDD_CLAVES_SUBSERIES, TO_CHAR(ICDD_FEC_REGISTRO, 'dd/MM/yyyy') , TO_CHAR(ICDD_FEC_INACTIVIDAD, 'dd/MM/yyyy'),  " +
        	" ICDD_JUSTIFICACION, ICDD_STATUS, TO_CHAR(SYSDATE, 'dd/MM/yyyy'), ICDD_USUARIO FROM SD_ICDD_UA "+
        	" WHERE ID_ICDD_UA ="+strId;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un subfondo 
     * por medio de si id
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @return Query
     */
    public static String getSubserie(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT SUBS_NOMBRE, SUBS_DESCRIPCION, TO_CHAR(SUBS_FEC_ACTUALIZACION, 'dd/MM/yyyy'), SUBS_USUARIO, SUBS_SERIE,SUBS_CLAVE " +
        		"FROM SD_SUBSERIE WHERE ID_SUBSERIE="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un expediente
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @return Query
     */
    public static String getExpedienteArch(String strIdSubfondo)
    {
        String sql = "";
       
        sql =  " SELECT  EXP_CVE_UA, EXP_AREA_DESC, EXP_CED_TIPO , "+
		        "  TO_CHAR(EXP_FEC_APERTURA, 'dd/MM/yyyy')," +
		        "  EXP_CLAVE, EXP_INTERNO, EXP_UBICACION , "+
		        "  EXP_DENOMINACION  , EXP_DESCRIPCION  ,EXP_VALORACION , "+
		        "  TO_CHAR(EXP_FEC_CIERRE, 'dd/MM/yyyy'), "+
		        "  EXP_ANO_AT ,EXP_ANO_AC, EXP_SISI_DISP, EXP_ANIOS_TOTAL_DISP, EXP_CVE_CLASF_INF , "+ 
		        "  EXP_MOTIVO , EXP_FUNDAMENTO ,EXP_OBSERVA ,EXP_ANO_RESERV ,EXP_ANO_REAL, "+
		        "  EXP_SISI_CLS, EXP_ANIOS_TOTAL_CLS,EXP_ANIOS_AMPLI , TO_CHAR(EXP_FEC_AMPLI, 'dd/MM/yyyy'), "+ 
		        "  EXP_ANIOS_GUARDA,  TO_CHAR(EXP_FEC_ACTUALIZACION, 'dd/MM/yyyy'), EXP_STATUS , " +
		        "  TO_CHAR(EXP_FEC_INACTIVA, 'dd/MM/yyyy'), EXP_JUSTIFICA, EXP_UB_FISICA, EXP_ANIOS_REDUC, TO_CHAR(SYSDATE, 'dd/MM/yyyy'), " +
		        "  EXP_USUARIO "+ 
        		" FROM SD_EXPEDIENTES WHERE ID_EXPEDIENTE="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un expediente
     * por medio de su id
     * @param strIdSubfondo Contiene clave del Subfondo
     * @return Query
     */
    public static String getExpedienteID(String strIdSubfondo)
    {
        String sql = "";
       
        sql =  " SELECT  ID_EXPEDIENTE FROM SD_EXPEDIENTES WHERE EXP_CLAVE = '"+strIdSubfondo+"'";
        return sql;
    }
    /**
     * Función que regresa un query con las fechas dela clasificacion para expediente
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @return Query
     */
    public static String getExpedienteAtAc(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT 	CLS_VIGENCIA_AT, CLS_VIGENCIA_AC FROM SD_CLASIFICACION WHERE ID_CLASIFICACION ="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un cosecutivo de EXPEDIENTES
     * por medio de si id
     * @param strIdSubfondo Contiene el Id del EXPEDIENTE
     * @param anio Año actual
     * @return Query consulta
     */
    public static String getExpedienteConsec(String strIdSubfondo,String anio)
    {
        String sql = "";
        sql = "SELECT NVL(MAX(EXP_CED_TIPO_CONSEC),0) CONSEC FROM SD_EXPEDIENTES " +
        		" WHERE EXP_CED_TIPO ="+strIdSubfondo+"AND TO_CHAR(EXP_FEC_APERTURA,'yyyy')  = '"+anio+"'";
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un Valor 
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del Valor
     * @return Query
     */
    public static String getValor(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT V_NOMBRE, V_DESCRIPCION, TO_CHAR(V_FEC_ACTUALIZACION, 'dd/MM/yyyy'), V_USUARIO,V_CLAVE," +
        		" TO_CHAR(V_FEC_INACTIVA, 'dd/MM/yyyy'), V_JUSTIFICA, V_STATUS, TO_CHAR(SYSDATE, 'dd/MM/yyyy') " +
        		"FROM SD_VALOR WHERE ID_VALOR="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de una Cedula Tipo
     * por medio de su id
     * @param strIdSubfondo Contiene el Id de una Cedula Tipo
     * @return Query
     */
    public static String getTipCed(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT CED_NOMBRE, CED_DESCRIPCION, TO_CHAR(CED_FEC_ACTUALIZACION, 'dd/MM/yyyy'), CED_USUARIO, CED_CLAVE," +
        		" CED_CVE_UA,  CED_MOTIVO, CED_FUNDAMENTO, CED_ICDD_UASub , CED_ICDD_UAS, " +
        		" TO_CHAR(CED_FEC_FECINACT, 'dd/MM/yyyy'), CED_JUSTIFICACION, CED_STATUS, TO_CHAR(SYSDATE, 'dd/MM/yyyy') " +
        		" FROM SD_TIPO_CEDULA WHERE ID_CEDULA="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un ICDD para series 
     * por medio de si id
     * @param strIdSubfondo Contiene el Id del Area
     * @return Query
     */
    public static String getTipCedSer(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT ICDD_CLAVES_SERIES FROM SD_ICDD_UA WHERE ICDD_CLAVE_UA = "+strIdSubfondo;
        return sql;
    } 
    /**
     * Función que regresa un query con los datos de un ICDD para Subseries 
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del Area
     * @return Query
     */
    public static String getTipCedSubSer(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT ICDD_CLAVES_SUBSERIES FROM SD_ICDD_UA WHERE ICDD_CLAVE_UA = "+strIdSubfondo;
        return sql;
    }      
    /**
     * Función que regresa un query con los datos de un seleccion 
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del seleccion
     * @return Query
     */
    public static String getSubseleccion(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT SEL_NOMBRE, SEL_DESCRIPCION, TO_CHAR(SEL_FEC_ACTUALIZACION, 'dd/MM/yyyy'), SEL_USUARIO,SEL_CLAVE,  " +
        		" TO_CHAR(SEL_FEC_INACTIVA, 'dd/MM/yyyy'), SEL_JUSTIFICA, SEL_STATUS, TO_CHAR(SYSDATE, 'dd/MM/yyyy') " +
        		"FROM SD_SELECCION WHERE ID_SELECCION="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un fondo 
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del fondo
     * @return Query
     */
    public static String getfondo(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT FON_NOMBRE, FON_DESCRIPCION, TO_CHAR(FON_FEC_ACTUALIZACION, 'dd/MM/yyyy'), FON_USUARIO, FON_CLAVE, FON_SISI, " +
        	  " TO_CHAR(FON_FEC_INACTIVA, 'dd/MM/yyyy'), FON_JUSTIFICA, FON_STATUS, TO_CHAR(SYSDATE, 'dd/MM/yyyy') " +
        	  " FROM SD_FONDO_ARCH WHERE ID_FONDO="+strIdSubfondo;
       
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un subfondo 
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @return Query
     */
    public static String getcombinacion(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT a.COM_NOMBRE, a.COM_DESCRIPCION, TO_CHAR(a.COM_FEC_ACTUALIZACION, 'dd/MM/yyyy'),   " +
        " a.COM_USUARIO,a.COM_FONDO,a.COM_SERIE,a.COM_SECCION,a.COM_TIP_COMBINACION,a.COM_CLAVE, d.ID_SERIE,f.ID_FONDO  " + 
        " FROM SD_COMBINACION a, SD_SERIE d ,SD_SUBSERIE c,SD_SUBFONDOARCH s,SD_FONDO_ARCH f  " +
        " WHERE c.ID_SUBSERIE =a.COM_SERIE   " +
        " AND d.ID_SERIE = c.SUBS_SERIE  " +
        " AND s.ID_SUBFONDO =a.COM_FONDO  " +
        " AND s.SUBF_FONDO = f.ID_FONDO  " +
        " AND  a.ID_COMBINACION="+strIdSubfondo;;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un subfondo 
     * por medio de su id
     * @param strId1 Contiene el Id del Subfondo
     * @return Query
     */
    public static String getCargafon(String strId1)
    {
        String sql = "";
        sql = "SELECT FON_CLAVE FROM SD_FONDO_ARCH WHERE ID_FONDO= "+strId1;
        return sql;
    }
    /**
     * Funcion para cargar subfondos
     * @param strId1 id fondo
     * @return Query consulta
     */
    public static String getCargasubfon(String strId1)
    {
        String sql = "";
        sql = "SELECT SUBF_CLAVE FROM SD_SUBFONDOARCH WHERE ID_SUBFONDO = "+strId1;
        return sql;
    }
    /**
     * Funcion para cargar secciones 
     * @param strId1 id seccion
     * @return Query consulta
     */
    public static String getCargasec(String strId1)
    {
        String sql = "";
        sql = "SELECT SEC_CLAVE FROM SD_SECCION_ARCH WHERE ID_SECCION= "+strId1;
        return sql;
    }
    /**
     * Funcion para cargar series 
     * @param strId1 id serie
     * @return Query consulta
     */
    public static String getCargaser(String strId1)
    {
        String sql = "";
        sql = "SELECT CLS_CLAVE FROM SD_CLASIFICACION WHERE ID_CLASIFICACION= "+strId1;
        return sql;
    }
    /**
     * Funcion para cargar subseries
     * @param strId1 id subseries
     * @return Query consulta
     */
    public static String getCargasubser(String strId1)
    {
        String sql = "";
        sql = "SELECT SUBS_CLAVE FROM SD_SUBSERIE WHERE ID_SUBSERIE= "+strId1;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un subfondo 
     * por medio de si id
     * @param strIdSubfondo Contiene el Id de la clasificacion
     * @return Query
     */
    public static String getclasificacion(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT CLS_NOMBRE, CLS_DESCRIPCION, TO_CHAR(CLS_FEC_ACTUALIZACION, 'dd/MM/yyyy'), CLS_USUARIO, CLS_VALORACION, CLS_SELECCION, " +
        	 " CLS_VIGENCIA_AT, CLS_VIGENCIA_AC, CLS_VIGENCIA_TOTAL, "+
        	 " CLS_ANOS_SISI, CLS_CONFIDENCIAL ,CLS_CLAVE, CLS_ANOS_RESERVA, "+
        	 " CLS_FONDO, CLS_SUBFONDO,CLS_SECCION, CLS_SERIE, CLS_SUBSERIE, CLS_OBSERVACIONES, "+
        	 " TO_CHAR(CLS_FEC_FECINACT, 'dd/MM/yyyy'), CLS_JUSTIFICACION, CLS_STATUS, TO_CHAR(SYSDATE, 'dd/MM/yyyy')  " +
        	 " FROM SD_CLASIFICACION WHERE ID_CLASIFICACION="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de subserie 
     * por medio de su id
     * @param strIdSubfondo Contiene el Id de la clasificacion subserie
     * @return Query
     */
    public static String getclasificacionsub(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT A.CLS_NOMBRE, A.CLS_DESCRIPCION, TO_CHAR(A.CLS_FEC_ACTUALIZACION, 'dd/MM/yyyy'), A.CLS_USUARIO, A.CLS_VALORACION, A.CLS_SELECCION, " +
        	 " A.CLS_VIGENCIA_AT, A.CLS_VIGENCIA_AC, A.CLS_VIGENCIA_TOTAL, "+
        	 " A.CLS_ANOS_SISI, A.CLS_CONFIDENCIAL ,A.CLS_CLAVE, A.CLS_ANOS_RESERVA, "+
        	 " A.CLS_FONDO, A.CLS_SUBFONDO,A.CLS_SECCION, A.CLS_SERIE, A.CLS_SUBSERIE, A.CLS_OBSERVACIONES, "+
        	 " TO_CHAR(A.CLS_FEC_FECINACT, 'dd/MM/yyyy'), A.CLS_JUSTIFICACION, A.CLS_STATUS, TO_CHAR(SYSDATE, 'dd/MM/yyyy'),B.CLS_VIGENCIA_AT, B.CLS_VIGENCIA_AC  " +
        	 " FROM SD_CLASIFICACION_SUB A, SD_CLASIFICACION B WHERE A.CLS_SERIE = B.ID_CLASIFICACION AND A.ID_CLASIFICACION="+strIdSubfondo;
        return sql;
    } 
    /**
     * Función que regresa un query con los datos de una valoracion de clasificacion
     * por medio de si id
     * @param strIdSubfondo Contiene el Id de VALORACION
     * @return Query
     */
    public static String getValclasificacionsub(String strIdSubfondo)
    {
        String sql = "";
        sql = " SELECT VAL_VALORACIONES1 FROM SD_VALORACION  WHERE ID_VALORACION ="+strIdSubfondo;
        return sql;
    } 
    /**
     * Función que regresa un query con los datos de una valoracion para Expediente
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del valoracion
     * @return Query
     */
    public static String getValExpediente(String strIdSubfondo)
    {
        String sql = "";
        sql = " SELECT d.VAL_VALORACIONES1  " +
		       " FROM SD_TIPO_CEDULA a, SD_CLASIFICACION_SUB  f, SD_VALORACION d "+
		        " WHERE  f.CLS_VALORACION = d.ID_VALORACION "+
		        " AND a.CED_ICDD_UASUB = f.ID_CLASIFICACION "+
		        " AND a.ID_CEDULA = "+strIdSubfondo+
		        " UNION "+
		        " SEELCT d.VAL_VALORACIONES1 "+
		        " FROM SD_TIPO_CEDULA a, SD_VALORACION d, SD_CLASIFICACION f"+
		        " WHERE f.CLS_VALORACION = d.ID_VALORACION "+
		        " AND a.CED_ICDD_UAS = f.ID_CLASIFICACION"+
		        " AND a.ID_CEDULA ="+strIdSubfondo;
        return sql;
    }     
    /**
     *  Función que regresa un query con los datos de una serie
     * por medio de su id
     * @param idsec id seccion
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @param Aux clave serie para validacion
     * @return Query consulta
     */
    public static String validaClasificacion(String idsec, String strIdSubfondo, String Aux)
    {
        String sql = "";
        sql = "SELECT CLS_NOMBRE "+
        		" FROM SD_CLASIFICACION WHERE CLS_SECCION = "+idsec+" AND CLS_CLAVE='"+strIdSubfondo+"' AND CLS_CLAVE<>'"+Aux+"' AND CLS_STATUS=1";
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un subserie
     * por medio de su id
     * @param ser id serie
     * @param strIdSubfondo clave subserie
     * @param Aux clave para validacion
     * @return Query consulta
     */
    public static String validaClasificacionsub(String ser, String strIdSubfondo, String Aux)
    {
        String sql = "";
        sql = "SELECT CLS_NOMBRE "+
        		" FROM SD_CLASIFICACION_SUB WHERE CLS_SERIE = "+ser+" AND CLS_CLAVE='"+strIdSubfondo+"' AND CLS_CLAVE<>'"+Aux+"' AND CLS_STATUS IN (1,3)";
        return sql;
    }    
    /**
     * Función que regresa un query que borra los datos de un subfondo 
     * por medio de si id
     * @param strIds Contiene el Id del Subfondo
     * @return Query
     */
    public static String validaBorraFondo(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.SUBF_NOMBRE FROM SD_SUBFONDOARCH a,SD_FONDO_ARCH b"+
        	" WHERE a.SUBF_FONDO = b.ID_FONDO"+
        	" AND a.SUBF_STATUS = 1 AND b.ID_FONDO IN ("+ids+")";
        return strSql;
    }
    /**
     * Función que regresa un query que borra los datos de un cuadro de disposicion
     * por medio de si id
     * @param strIds Contiene el Id del cuadro
     * @return Query
     */  
    public static String validaBorraIcdd(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.CED_NOMBRE FROM SD_TIPO_CEDULA a, SD_ICDD_UA b"+
        	"  WHERE nvl(a.CED_ICDD_UAS,'0')= nvl(b.ICDD_CLAVES_SERIES,'0') "+
        	"  AND  nvl(a.CED_ICDD_UASUB,'0') = nvl(b.ICDD_CLAVES_SUBSERIES,'0') "+
        	" AND a.CED_STATUS= 1 AND b.ID_ICDD_UA IN  ("+ids+")";
        return strSql;
    }     
    /**
     * Función que regresa un query que borra los datos de un Expediente 
     * por medio de si id
     * @param strIds ids de expediente
     * @return Query
     */
    public static String validaBorraExp(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = " SELECT a.ID_asunto, b.EXP_DENOMINACION, a.asu_descripcion,asu_tip_docto,asu_Folio_Externo  FROM sd_asunto a , SD_EXPEDIENTES b "+
        	" WHERE a.asu_expediente= b.ID_EXPEDIENTE "+
        	" AND a.asu_expediente  IN ("+ids+")";
        return strSql;
    }
    /**
     * Función que regresa un query que borra  los datos de un subfondo 
     * por medio de si id
     * @param strIds ids clasificacion
     * @return Query
     */
    public static String validaBorraCls(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.CLS_NOMBRE FROM SD_CLASIFICACION_SUB a,SD_CLASIFICACION b"+
    		" WHERE a.CLS_SERIE  = b.ID_CLASIFICACION"+
    		" AND a.CLS_STATUS = 1  and b.ID_CLASIFICACION IN ("+ids+")"+
        	" UNION " +
        	" SELECT a.CED_NOMBRE FROM SD_TIPO_CEDULA   a,SD_CLASIFICACION b"+
        	" WHERE a.CED_STATUS = 1 AND a.CED_ICDD_UAS  = b.ID_CLASIFICACION" +
        	" AND b.ID_CLASIFICACION  IN ("+ids+")";
        return strSql;
    }
    /**
     * Función que regresa un query con que borra datos de un subfondo 
     * por medio de si id
     * @param strIds Contiene el Id del Subfondo
     * @return Query
     */
    public static String validaBorraClssub(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql =  "SELECT a.CED_ICDD_UASUB FROM SD_TIPO_CEDULA  a,SD_CLASIFICACION_SUB b"+
		    	" WHERE a.CED_ICDD_UASUB = b.ID_CLASIFICACION"+
		    	" AND a.CED_STATUS = 1 AND b.ID_CLASIFICACION IN ("+ids+")";
        return strSql;
    }     
    /**
     * Función que regresa un query borra los datos de una cedula 
     * por medio de su id
     * @param strIds Contiene el Id de la cedula
     * @return Query
     */
    public static String validaBorraCedula(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.EXP_DENOMINACION FROM SD_EXPEDIENTES a,SD_TIPO_CEDULA b"+
        	" WHERE a.EXP_CED_TIPO = b.ID_CEDULA "+
        	" AND a.EXP_STATUS = 1 AND b.ID_CEDULA IN ("+ids+")";
        return strSql;
    }
    /**
     * Función que regresa un query que borra los datos de una clasificacion de la informacion 
     * por medio de su id
     * @param strIds Contiene el Id de la clasificacion de la informacion 
     * @return Query
     */
    public static String validaBorraClasifInf(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.EXP_DENOMINACION FROM SD_EXPEDIENTES a,SD_CLASIF_INF b"+
        	" WHERE a.EXP_CVE_CLASF_INF = b.ID_CLASIF_INF "+
        	" AND a.EXP_STATUS = 1 AND b.ID_CLASIF_INF IN ("+ids+")";
        return strSql;
    }
    /**
     * Función que regresa un query que borra los datos de una seleccion
     * por medio de si id
     * @param strIds Contiene el Id del seleccion
     * @return Query
     */
    public static String validaBorraSeleccion(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.CLS_NOMBRE FROM SD_CLASIFICACION a,SD_SELECCION b"+
        	" WHERE a.CLS_SELECCION = b.ID_SELECCION "+
        	" AND a.CLS_STATUS = 1 AND b.ID_SELECCION IN ("+ids+")";
        return strSql;
    }
    /**
     * Función que regresa un query que borra los datos de una valoracion
     * @param strIds Contiene el Id del valoracion
     * @return Query
     */
    public static String validaBorraValoracion(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.CLS_NOMBRE FROM SD_CLASIFICACION a,SD_VALORACION b"+
        	" WHERE a.CLS_VALORACION = b.ID_VALORACION "+
        	" AND a.CLS_STATUS = 1 AND b.ID_VALORACION IN ("+ids+")";
        return strSql;
    }
    /**
     * Función que regresa un query que borra los datos de un valor 
     * por medio de su id
     * @param strIds Contiene el Id del valor
     * @return Query
     */
    public static String validaBorraValor(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.VAL_NOMBRE FROM SD_VALORACION a,SD_VALOR b WHERE a.VAL_VALORACIONES1 LIKE '%"+ids+"%'"+
        	" AND a.VAL_STATUS = 1 ";
      //  	" and b.ID_VALOR in  ("+ids+")";

        return strSql;
    }
    /**
     * Función que regresa un query que borra los datos de una combinacion
     * por medio de su id
     * @param strIds Contiene el Id de la combinacion
     * @return Query
     */
    public static String validaBorraComb(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.CLS_NOMBRE FROM SD_CLASIFICACION a,SD_COMBINACION b"+
        	" WHERE a.CLS_COMBINACION = b.ID_COMBINACION"+
        	" AND a.CLS_STATUS = 1 AND b.ID_COMBINACION IN ("+ids+")";
        return strSql;
    }    
    /**
     * Función que regresa un query que verifica los datos de una combinacion 
     * por medio de si id
     * @param strIds Contiene el Id de una combinacion
     * @return Query
     */
    public static String validaBorraComb2(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.CED_NOMBRE FROM SD_TIPO_CEDULA a,SD_COMBINACION b"+
        	" WHERE a.CED_COMB = b.ID_COMBINACION"+
        	" AND a.CED_STATUS = 1 AND b.ID_COMBINACION IN ("+ids+")";
        return strSql;
    }        
    /**
     * Función que regresa un query que verifica los datos de una serie
     * por medio de si id
     * @param strIds Contiene el Id del serie
     * @return Query
     */
    public static String validaBorraSerie(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.SUBS_NOMBRE FROM SD_SUBSERIE a,SD_SERIE b"+
        	" WHERE a.SUBS_SERIE = b.ID_SERIE"+
        	" AND a.SUBS_STATUS = 1 AND b.ID_SERIE IN ("+ids+")";
        return strSql;
    }
    /**
     * Función que regresa un query que verifica los datos de una subserie
     * por medio de si id
     * @param strIds Contiene el Id del Subfondo
     * @return Query
     */
    public static String validaBorraSubserie(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.COM_NOMBRE FROM SD_COMBINACION  a,SD_SUBSERIE b"+
    	" WHERE a.COM_SERIE = b.ID_SUBSERIE"+
    	" AND a.COM_STATUS = 1 AND b.ID_SUBSERIE IN ("+ids+")";
        return strSql;
    }
    /**
     * Función que regresa un query que verifica los datos de una seccion
     * por medio de si id
     * @param strIds Contiene el Id de la seccion
     * @return Query
     */
    public static String validaBorraSeccion(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.CLS_NOMBRE FROM SD_CLASIFICACION  a,SD_SECCION_ARCH b"+
    	" WHERE a.CLS_SECCION = b.ID_SECCION "+
    	" AND a.CLS_STATUS = 1 AND b.ID_SECCION IN ("+ids+")";
		
		
	
    return strSql;
    }
    /**
     * Función que regresa un query que verifica los datos de un subfondo 
     * por medio de si id
     * @param strIds Contiene el Id del Subfondo
     * @return Query
     */
    public static String validaBorraSubFondo(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);	

		strSql = "SELECT a.SEC_NOMBRE FROM SD_SECCION_ARCH  a,SD_SUBFONDOARCH b"+
        	" WHERE a.SEC_SUBFONDO = b.ID_SUBFONDO"+
        	" AND a.SEC_STATUS = 1 AND b.ID_SUBFONDO IN ("+ids+")";
        return strSql;
    }
    /**
     * Función que regresa un query que valida los datos de un fondo 
     * por medio de su id y clave
     * @param strIdSubfondo clave fondo
     * @param strAux clave validacion
     * @return Query consulta
     */
    public static String validaFondo(String strIdSubfondo, String strAux)
    {
        String sql = "";
        sql = "SELECT FON_NOMBRE "+
        		" FROM SD_FONDO_ARCH WHERE FON_STATUS = 1 AND FON_CLAVE='"+strIdSubfondo+"' AND FON_CLAVE<> '" + strAux + "' ";
        return sql;
    }
    /**
     *  Función que regresa un query que borra los datos de un subfondo 
     * por medio de si id
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @param fondo id de fondo
     * @param Aux valida clave
     * @param Aux2 valida clave2
     * @return Query consulta
     */
    public static String validaSubfondo(String strIdSubfondo, String fondo, String Aux, String Aux2)
    {
        String sql = "";
        sql = "SELECT SUBF_NOMBRE "+
        		" FROM SD_SUBFONDOARCH WHERE SUBF_STATUS = 1 AND " +
        		"NOT(SUBF_CLAVE='"+Aux+"' AND SUBF_FONDO=" + Aux2 + ") " +
        		"AND SUBF_CLAVE='"+strIdSubfondo+"' AND SUBF_FONDO=" + fondo + "";
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un subfondo 
     * por medio de si id
     * @param strIdSubfondo Contiene el Id del Subfondo
     * @return Query
     */
    public static String validaSubfondov(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT SUBF_NOMBRE "+
        		" FROM SD_SUBFONDOARCH WHERE SUBF_STATUS = 1 AND " +
        		" SUBF_CLAVE='"+strIdSubfondo+"'";
        return sql;
    }    
    /**
     * Función que regresa un query que valida los datos de una seccion 
     * por medio de su clave
     * @param strIdSubfondo id clave
     * @param Aux clave seccion
     * @param fondo id fondo
     * @param subfondo id subfondo
     * @return Query consulta
     */
    public static String validaSeccion(String strIdSubfondo,String Aux,String fondo, String subfondo)
    {
        String sql = "";
        sql = "SELECT SEC_NOMBRE "+
        		" FROM SD_SECCION_ARCH WHERE SEC_STATUS = 1 AND  SEC_CLAVE='"+strIdSubfondo+"' AND  SEC_CLAVE<>'"+Aux+"' "+
        		" AND SEC_FONDO="+fondo+" AND SEC_SUBFONDO = "+subfondo+"";
        return sql;
    }
    /**
     * Función que regresa un query que valida los datos de una subserie 
     * por medio de su clave
     * @param strIdSubfondo  clave
     * @param strSr id serie
     * @param Aux clave para validacion
     * @param Aux2 clave para validacion2
     * @return Query consulta
     */
    public static String validaSubserie(String strIdSubfondo, String strSr, String Aux, String Aux2)
    {
        String sql = "";
        sql = "SELECT SUBS_NOMBRE "+
        		" FROM SD_SUBSERIE   WHERE SUBS_STATUS = 1 AND SUBS_CLAVE="+strIdSubfondo+" AND SUBS_SERIE = "+strSr+"" +
        		" AND NOT(SUBS_CLAVE="+Aux+" AND SUBS_SERIE="+Aux2+")";
        return sql;
    }
    /**
     * Función que regresa un query que valida los datos de una serie 
     * por medio de su clave
     * @param strIdSubfondo  clave
     * @param Aux clave para validacion
     * @return Query consulta
     */
    public static String validaSerie(String strIdSubfondo, String Aux)
    {
        String sql = "";
        sql = "SELECT SER_NOMBRE "+
        		" FROM SD_SERIE  WHERE SER_STATUS = 1 AND SER_CLAVE="+strIdSubfondo+" AND SER_CLAVE<>"+Aux;
        return sql;
    }
    /**
     * Función que ejecuta un query, donde inserta datos a la 
     * tabla de INSTRUCCIONES
     * @param strId Identificador Expediente
     * @return Query consulta
     */
    public static String getDescExp(String strId)
    {
        String sql = "";
        sql = "SELECT EXP_CLAVE||'/'||EXP_DENOMINACION FROM SD_EXPEDIENTES WHERE ID_EXPEDIENTE ="+strId;
        return sql;
    }    
    /**
     * Función que regresa un query que valida los datos de un valor 
     * por medio de su clave
     * @param strIdSubfondo  clave
     * @param Aux clave para validacion
     * @return Query consulta
     */
    public static String validaValor(String strIdSubfondo, String Aux)
    {
        String sql = "";
        sql = "SELECT V_NOMBRE "+
        		" FROM SD_VALOR  WHERE V_STATUS = 1 AND V_CLAVE="+strIdSubfondo+" AND V_CLAVE<>"+Aux;
        return sql;
    }
    /**
     * Función que regresa un query que valida los datos de una valoracion 
     * por medio de su clave
     * @param strIdSubfondo  clave
     * @param Aux clave para validacion
     * @return Query consulta
     */
    public static String validaValoracion(String strIdSubfondo, String Aux)
    {
        String sql = "";
        sql = "SELECT VAL_NOMBRE "+
        		" FROM SD_VALORACION WHERE VAL_STATUS = 1 AND VAL_CLAVE="+strIdSubfondo+" AND VAL_CLAVE<>"+Aux;
        return sql;
    }
    /**
     * Función que regresa un query que valida los datos de una seleccion 
     * por medio de su clave
     * @param strIdSubfondo  clave
     * @param Aux clave para validacion
     * @return Query consulta
     */
    public static String validaSelect(String strIdSubfondo, String Aux)
    {
        String sql = "";
        sql = "SELECT SEL_NOMBRE "+
        		" FROM SD_SELECCION WHERE SEL_STATUS = 1 AND SEL_CLAVE="+strIdSubfondo+" AND SEL_CLAVE<>"+Aux;
        return sql;
    }
    /**
     * Función que regresa un query que valida los datos de una combinacion 
     * por medio de su clave
     * @param strIdSubfondo  clave
     * @param Aux clave para validacion
     * @return Query consulta
     */
    public static String validaComb(String strIdSubfondo, String Aux)
    {
        String sql = "";
        sql = "SELECT COM_NOMBRE "+
        		" FROM SD_COMBINACION  WHERE COM_STATUS = 1 AND COM_CLAVE='"+strIdSubfondo+"' AND COM_CLAVE<>'"+Aux+"'";
        return sql;
    }
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId combinacion existente
     * @return Query consulta Query
     */
    public static String verifComb(String strId)
    {
        String sql = "";
        
        
        sql = " SELECT c.CED_COMB FROM 	SD_COMBINACION a, SD_TIPO_CEDULA c "+
        " WHERE c.CED_COMB = a.ID_COMBINACION AND  a.ID_COMBINACION = "+ strId +
        " UNION "+
        " SELECT b.CLS_COMBINACION  FROM SD_COMBINACION a, SD_CLASIFICACION b "+
        " WHERE b.CLS_COMBINACION = a.ID_COMBINACION AND  a.ID_COMBINACION = "+ strId +"";

        return sql;
    }
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida expediente existente
     * @return Query
     */
    public static String getValidaExpedienteArch(String strId)
    {
        String sql = "";
        
        
        sql = " SELECT a.ID_asunto, b.EXP_DENOMINACION, a.asu_descripcion,asu_tip_docto,asu_Folio_Externo  FROM sd_asunto a , SD_EXPEDIENTES b "+
    	" WHERE a.asu_expediente= b.ID_EXPEDIENTE "+
    	" AND a.asu_expediente  = "+strId+"";

        return sql;
    }  
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida cedula existente
     * @return Query
     */
    public static String getValidaCedula(String strId)
    {
        String sql = "";
        
        
        sql = "SELECT a.EXP_DENOMINACION FROM SD_EXPEDIENTES a,SD_TIPO_CEDULA b"+
    	" WHERE a.EXP_CED_TIPO = b.ID_CEDULA "+
    	" AND a.EXP_STATUS = 1 AND b.ID_CEDULA = "+strId+"";

        return sql;
    }      
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida Clasificacion existente
     * @return Query
     */
    public static String getValidaClasificacion(String strId)
    {
        String sql = "";
        
        
        sql =  "SELECT a.CLS_NOMBRE FROM SD_CLASIFICACION_SUB a,SD_CLASIFICACION b"+
    	" WHERE a.CLS_SERIE  = b.ID_CLASIFICACION"+
    	" AND a.CLS_STATUS = 1 AND b.ID_CLASIFICACION = "+strId+""+
    	" UNION " +
    	" SELECT a.CED_NOMBRE FROM SD_TIPO_CEDULA   a,SD_CLASIFICACION b"+
    	" WHERE a.CED_STATUS = 1 AND a.CED_ICDD_UAS  = b.ID_CLASIFICACION" +
    	" AND b.ID_CLASIFICACION  = "+strId+"";

        return sql;
    }   
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida Clasificacion de subserie existente
     * @return Query
     */
    public static String getValidaClasificacionsub(String strId)
    {
        String sql = "";
        
        
        sql =  "SELECT a.CED_ICDD_UASUB FROM SD_TIPO_CEDULA  a,SD_CLASIFICACION_SUB b"+
    	" WHERE a.CED_ICDD_UASUB = b.ID_CLASIFICACION"+
    	" AND a.CED_STATUS = 1 AND b.ID_CLASIFICACION = "+strId+"";

        return sql;
    }     
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida clasificacion de la informacion existente
     * @return Query
     */
    public static String getValidaClasifInfo(String strId)
    {
        String sql = "";
        
        
        sql = " SELECT a.EXP_DENOMINACION FROM SD_EXPEDIENTES a,SD_CLASIF_INF b "+
    	" WHERE a.EXP_CVE_CLASF_INF = b.ID_CLASIF_INF "+
    	" AND a.EXP_STATUS = 1 AND b.ID_CLASIF_INF = "+strId+"";

        return sql;
    }      
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida expediente Seleccion
     * @return Query
     */
    public static String getValidaSeleccion(String strId)
    {
        String sql = "";
        
        
        sql =  "SELECT a.CLS_NOMBRE FROM SD_CLASIFICACION a,SD_SELECCION b"+
    	" WHERE a.CLS_SELECCION = b.ID_SELECCION "+
    	" AND a.CLS_STATUS = 1 AND b.ID_SELECCION = "+strId+"";

        return sql;
    }      
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida valoracion existente
     * @return Query
     */
    public static String getValidaValoraciones(String strId)
    {
        String sql = "";
        
        
        sql =  "SELECT a.CLS_NOMBRE FROM SD_CLASIFICACION a,SD_VALORACION b"+
    	" WHERE a.CLS_VALORACION = b.ID_VALORACION "+
    	" AND a.CLS_STATUS = 1 AND b.ID_VALORACION = "+strId+"";

        return sql;
    }      
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida valor existente
     * @return Query
     */
    public static String getValidaValor(String strId)
    {
        String sql = "";
        
        
        sql =   "SELECT a.VAL_NOMBRE FROM SD_VALORACION a,SD_VALOR b WHERE a.VAL_VALORACIONES1 LIKE '%"+strId+"%'"+
    	" AND a.VAL_STATUS = 1 ";

        return sql;
    }     
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida subserie existente
     * @return Query
     */
    public static String getValidaSubserie(String strId)
    {
        String sql = "";
        
        
        sql = "SELECT a.COM_NOMBRE FROM SD_COMBINACION  a,SD_SUBSERIE b"+
    	" WHERE a.COM_SERIE = b.ID_SUBSERIE"+
    	" AND a.COM_STATUS = 1 AND b.ID_SUBSERIE = "+strId+"";

        return sql;
    }      
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida seccion existente
     * @return Query
     */
    public static String getValidaSeccion(String strId)
    {
        String sql = "";
        
        
        sql = "SELECT a.CLS_NOMBRE FROM SD_CLASIFICACION  a,SD_SECCION_ARCH b"+
    	" WHERE a.CLS_SECCION = b.ID_SECCION "+
    	" AND a.CLS_STATUS = 1 AND b.ID_SECCION = "+strId+"";

        return sql;
    }      
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida serie existente
     * @return Query
     */
    public static String getValidaSerie(String strId)
    {
        String sql = "";
        
        
        sql = "SELECT a.SUBS_NOMBRE FROM SD_SUBSERIE a,SD_SERIE b"+
    	" WHERE a.SUBS_SERIE = b.ID_SERIE"+
    	" AND a.SUBS_STATUS = 1 AND b.ID_SERIE = "+strId+"";

        return sql;
    }      
    /**
     * Función que regresa una Subfondo 
     * por medio de si id
     * @param strId valida subfondo existente
     * @return Query
     */
    public static String getValidaSubfondo(String strId)
    {
        String sql = "";
        
        
        sql = "SELECT a.SEC_NOMBRE FROM SD_SECCION_ARCH a,SD_SUBFONDOARCH b"+
    	" WHERE a.SEC_SUBFONDO = b.ID_SUBFONDO"+
    	" AND a.SEC_STATUS = 1 AND b.ID_SUBFONDO = "+strId+"";

        return sql;
    }       
    /**
     * Función que regresa una validacion 
     * por medio de si id
     * @param strId valida fondo existente
     * @return Query
     */
    public static String getValidaFondo(String strId)
    {
        String sql = "";
        
        
        sql = "SELECT a.SUBF_NOMBRE FROM SD_SUBFONDOARCH a,SD_FONDO_ARCH b"+
    	" WHERE a.SUBF_FONDO = b.ID_FONDO"+
    	" AND a.SUBF_STATUS = 1 AND b.ID_FONDO = "+strId+"";

        return sql;
    }      
    /**
     * Función que regresa un query que valida los datos de una combinacion
     * por medio de su clave
     * @param strIdSubfondo Contiene el Id de la combinacion
     * @return Query
     */
    public static String validaComb3(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT COM_NOMBRE "+
        		" FROM SD_COMBINACION  WHERE COM_CLAVE="+strIdSubfondo+"";
        return sql;
    }
    /**
     * Función que regresa un query con los datos de una clasificacion de Informacion
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del clasificacion
     * @param Aux clave para validar
     * @return Query
     */
    public static String validaClasifInf(String strIdSubfondo, String Aux)
    {
        String sql = "";
        sql = "SELECT CLSI_NOMBRE "+
        		" FROM SD_CLASIF_INF WHERE CLSI_STATUS = 1 AND CLSI_CLAVE="+strIdSubfondo+" AND CLSI_CLAVE<>"+Aux;
        return sql;
    }
    /**
     * Función que regresa un query que valida los datos de una cedula 
     * por medio de su clave
     * @param strIdSubfondo Contiene el Id de cedula
     * @param idArea id del area
     * @param Aux clave para validar
     * @param Aux2 clave para validar
     * @return Query consulta
     */
    public static String validaCedula(String strIdSubfondo, String idArea, String Aux, String Aux2)
    {
        String sql = "";
        sql = "SELECT CED_NOMBRE "+
        		" FROM SD_TIPO_CEDULA   WHERE CED_STATUS = 1 AND CED_CLAVE='"+strIdSubfondo+"' AND CED_CVE_UA='"+idArea+"' " +
        		"AND NOT(CED_CLAVE='"+Aux+"' AND CED_CVE_UA='"+Aux2+"')";
        return sql;
    }
    /**
     * Función que regresa un query que valida los datos de un expediente
     * por medio de su clave
     * @param strIdSubfondo Contiene el Id del expediente
     * @param idArea id del area
     * @param cedTipo id cedula tipo
     * @param Aux clave para validar
     * @param Aux2 clave2 para validar
     * @param Aux3 clave3 para validar
     * @return Query consulta
     */
    public static String validaExpd(String strIdSubfondo, String idArea, String cedTipo, String Aux, String Aux2, String Aux3)
    {
        String sql = "";
        sql = "SELECT EXP_DENOMINACION "+
        		" FROM SD_EXPEDIENTES  WHERE EXP_STATUS = 1 AND " +
        		"EXP_CLAVE='"+strIdSubfondo+"' AND EXP_CVE_UA="+idArea+" AND EXP_CED_TIPO="+cedTipo+" AND " +
        		"NOT (EXP_CLAVE='"+Aux+"' AND EXP_CVE_UA="+Aux2+" AND EXP_CED_TIPO="+Aux3+")";
        return sql;
    }
    /**
     * Función que regresa un query con los datos de una serie 
     * por medio de su id
     * @param strIdSubfondo Contiene el Id de la serie
     * @return Query
     */
    public static String getserie(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT SER_NOMBRE, SER_DESCRIPCION, TO_CHAR(SER_FEC_ACTUALIZACION, 'dd/MM/yyyy'), SER_USUARIO,SER_CLAVE " +
        		" FROM SD_SERIE WHERE ID_SERIE="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un clasificacion de inf.
     * por medio de su id
     * @param strIdSubfondo Contiene el Id del clasificacion
     * @return Query
     */
    public static String getClasifInf(String strIdSubfondo)
    {
        String sql = "";
        sql = "SELECT CLSI_NOMBRE, CLSI_DESCRIPCION, TO_CHAR(CLSI_FEC_ACTUALIZACION, 'dd/MM/yyyy'), CLSI_USUARIO,CLSI_CLAVE, " +
        	" TO_CHAR(CLSI_FEC_INACTIVA, 'dd/MM/yyyy'), CLSI_JUSTIFICA, CLSI_STATUS, TO_CHAR(SYSDATE, 'dd/MM/yyyy') " +
        		" FROM SD_CLASIF_INF WHERE ID_CLASIF_INF="+strIdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un expediente
     * por medio de si id
     * @param strId Contiene el Id del expediente
     * @return Query
     */
    public static String getExpedienteInst(String strId)
    {
        String sql = "";
        sql = "SELECT INS_EXPEDIENTE_ID,INS_EXPEDIENTE_NOMBRE, INS_FOLIO_TURNADO " +
        		"FROM sd_instruccion_asunto "+  
				"WHERE ID_INSTRUCCION_ASUNTO="+strId;
        return sql;
    }
    /**
     * Función que regresa un query con los datos de un expediente
     * por medio de si id
     * @param strIdAsunto Contiene el Id del expediente
     * @return Query
     */
    public static String getExpedienteAsunto(String strIdAsunto)
    {
        String sql = "";
        sql = "SELECT ASU_EXPEDIENTE,ASU_EXPEDIENTE_OTRO, ASU_FOLIO_RECEPCION " +
        		"FROM SD_ASUNTO "+  
				"WHERE ID_ASUNTO="+strIdAsunto;
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla subfondo
     * @return True
     */
    public static String getExisteSub()
    {
        String sql = "SELECT * FROM SD_SUBFONDOARCH ";
        return sql;
    }
    
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla subserie
     * @return True
     */
    public static String getExisteSubS()
    {
        String sql = "SELECT * FROM SD_SUBSERIE";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla expedientes
     * @return True
     */
    public static String getExisteExped()
    {
        String sql = "SELECT * FROM SD_EXPEDIENTES";
        return sql;
    }  
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  cedula tipo
     * @return True
     */
    public static String getExisteCed()
    {
        String sql = "SELECT * FROM SD_TIPO_CEDULA";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  clasificacion serie
     * @return True
     */
    public static String getExisteCls()
    {
        String sql = "SELECT * FROM SD_CLASIFICACION";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  clasificacion subserie
     * @return True
     */
    public static String getExisteClssub()
    {
        String sql = "SELECT * FROM SD_CLASIFICACION_SUB";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  clasificacion de inf.
     * @return True
     */
    public static String getExisteClsInf()
    {
        String sql = "SELECT * FROM SD_CLASIF_INF";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  seleccion
     * @return True
     */    
    public static String getExisteSeleccion()
    {
        String sql = "SELECT * FROM SD_SELECCION";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  valores
     * @return True
     */      
    public static String getExisteValor()
    {
        String sql = "SELECT * FROM SD_VALOR ";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  combinacion
     * @return True
     */  
    public static String getExisteComb()
    {
        String sql = "SELECT * FROM SD_COMBINACION ";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  valoracion
     * @return True
     */  
    public static String getExisteValoracion()
    {
        String sql = "SELECT * FROM SD_VALORACION ";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  subserie
     * @return True
     */  
    public static String getExisteSubSer()
    {
        String sql = "SELECT * FROM SD_SUBSERIE";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  serie
     * @return True
     */  
    public static String getExisteSerie()
    {
        String sql = "SELECT * FROM SD_SERIE";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla fondo
     * @return True
     */  
    public static String getExisteFon()
    {
        String sql = "SELECT * FROM SD_FONDO_ARCH";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla ICDD
     * @return True
     */  
    public static String getExisteIcdd()
    {
        String sql = "SELECT * FROM SD_ICDD_UA";
        return sql;
    }
    /**
     * Función que regresa un query, donde verifica si existen datos en la tabla  seccion
     * @return True
     */  
    public static String getExisteSeccion()
    {
        String sql = "SELECT * FROM SD_SECCION_ARCH";
        return sql;
    }
    /**
     * Borra logicamente el subfondo
     * @param strIds id de subfondo
     * @return Query consulta
     */ 
    public static String getDeleteSub(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);				
		strSql=	" UPDATE SD_SUBFONDOARCH  SET"	+
				" SUB_ESTATUS=0 WHERE ID_SUBFONDO IN ("+ids+")";				
		return strSql;
    }
    /**
     * Borra logicamente el subfondo
     * @param strIds id de subfondo
     * @return Query consulta
     */ 
    public static String getDeleteSubA(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);				
		strSql=	" UPDATE SD_SUBFONDOARCH SET"	+
				" SUBF_ESTATUS=0 WHERE ID_SUBFONDO IN ("+ids+")";				
		return strSql;
    }
    /**
     * Borra logicamente el seccion
     * @param strIds id de seccion
     * @return Query 
     */ 
    public static String getDeleteSeccion(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_SECCION_ARCH SET"	+
				" SEC_STATUS=0 WHERE ID_SECCION IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente el subfondo
     * @param strIds id de subfondo
     * @return Query 
     */    
    public static String getDeleteSubFond(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_SUBFONDOARCH SET"	+
				" SUBF_STATUS=0 WHERE ID_SUBFONDO IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente el valoracion
     * @param strIds id de valoracion
     * @return Query 
     */    
    public static String getDeleteValoracion(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_VALORACION SET"	+
				" VAL_STATUS=0 WHERE ID_VALORACION IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente el subserie
     * @param strIds id de subserie
     * @return Query 
     */
    public static String getDeleteSubSA(String strIds[])
    {
        String strSql="";
		String ids="";
		for(int i=0; i<strIds.length;i++)
		ids+=strIds[i]+",";
		ids=ids.substring(0,ids.length()-1);				
		strSql=	" UPDATE SD_SUBSERIE SET"	+
				" SUBS_ESTATUS=0 WHERE ID_SUBSERIE IN ("+ids+")";				
		return strSql;
    }
    /**
     * Borra logicamente el valor
     * @param strIds id de valor
     * @return Query 
     */
    public static String getDeleteValor(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_VALOR  SET"	+
				" V_STATUS=0 WHERE ID_VALOR IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente la cedula
     * @param strIds id de cedula
     * @return Query 
     */ 
    public static String getDeleteTipCed(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_TIPO_CEDULA SET"	+
				" CED_STATUS=0 WHERE ID_CEDULA IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente la seleccion
     * @param strIds id de seleccion
     * @return Query 
     */    
    public static String getDeleteSeleccion(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_SELECCION SET"	+
				" SEL_STATUS=0 WHERE ID_SELECCION IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente la subserie
     * @param strIds id de subserie
     * @return Query 
     */    
    public static String getDeleteSubSer(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_SUBSERIE SET"	+
				" SUBS_STATUS=0 WHERE ID_SUBSERIE IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente del expediente
     * @param strIds id del expediente
     * @return Query 
     */    
    public static String getDeleteSubExp(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_EXPEDIENTES SET"	+
				" EXP_STATUS=0 WHERE ID_EXPEDIENTE IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente el fondo
     * @param strIds id del fondo
     * @return Query 
     */    
    public static String getDeleteFondo(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_FONDO_ARCH  SET "	+
				" FON_STATUS= 0 WHERE ID_FONDO IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente del Icdd
     * @param strIds id del icdd
     * @return Query 
     */
    public static String getDeleteIcdd(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_ICDD_UA  SET "	+
				" ICDD_STATUS= 0 WHERE ID_ICDD_UA IN ("+strIds+")";				
		return strSql;
    } 
    /**
     * Borra logicamente la clasificacion serie
     * @param strIds id de la clasificacion serie
     * @return Query 
     */    
    public static String getDeleteCls(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_CLASIFICACION  SET "	+
				" CLS_STATUS= 0 WHERE ID_CLASIFICACION IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente la clasificacion subserie
     * @param strIds id de la clasificacion subserie
     * @return Query 
     */
    public static String getDeleteClssub(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_CLASIFICACION_SUB  SET "	+
				" CLS_STATUS= 0 WHERE ID_CLASIFICACION IN ("+strIds+")";				
		return strSql;
    }    
    /**
     * Borra logicamente la combinacion
     * @param strIds id de la combinacion
     * @return Query 
     */
    public static String getDeleteComb(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_COMBINACION  SET "	+
				" COM_STATUS= 0 WHERE ID_COMBINACION IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente la serie
     * @param strIds id de la serie
     * @return Query 
     */
    public static String getDeleteSerie(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_SERIE SET "	+
				" SER_STATUS ='0' WHERE ID_SERIE IN ("+strIds+")";				
		return strSql;
    }
    /**
     * Borra logicamente la clasificacion de inf.
     * @param strIds id de la clasificacion
     * @return Query 
     */
    public static String getDeleteClasifInf(String strIds)
    {
        String strSql="";
		strSql=	" UPDATE SD_CLASIF_INF SET "	+
				" CLSI_STATUS ='0' WHERE ID_CLASIF_INF IN ("+strIds+")";				
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
     * @return Query
     */
    public static String actualizaSubfondoA(String codigo, String seccion,
									String fecha, String Usr, String IdSubfondo)
    {
        String sql = "";
        sql = "UPDATE SD_SUBFONDOARCH SET SUBF_NOMBRE='"+codigo+"', SUBF_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"SUBF_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), SUBF_USUARIO="+Usr+" " +
        		"WHERE ID_SUBFONDO="+IdSubfondo;
        return sql;
    }
    /**
     *  Función que regresa un query, donde se actualiza el registro de la 
     * tabla de Seccion
     * @param soloDesc solo guarda descripcion
     * @param codigo nombre del Seccion
     * @param seccion descripcion del Seccion
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo Id del registro
     * @param clv clave del registro
     * @param fecInac fecha de inactivo
     * @param JusInac justificacion
     * @param inac inactivo
     * @return Query 
     */
    public static String actualizaSeccion(String soloDesc, String codigo, String seccion,
									String fecha, String Usr, String IdSubfondo, String clv,
									String fecInac,String JusInac ,String inac)
    {
        String sql = "";
        if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
        {
		sql = "UPDATE SD_SECCION_ARCH SET SEC_DESCRIPCION='"+seccion+"' " +
		" WHERE ID_SECCION="+IdSubfondo;
		return sql;
        }
        sql = "UPDATE SD_SECCION_ARCH SET SEC_NOMBRE='"+codigo+"', SEC_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		" SEC_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), SEC_USUARIO="+Usr+", " +
        		" SEC_CLAVE='"+clv+"', "+
        		" SEC_FEC_INACTIVA =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
        		" SEC_JUSTIFICA = '"+ JusInac + "'," +
        		" SEC_STATUS = '"+ inac + "'" +         		
        		" WHERE ID_SECCION="+IdSubfondo;
        return sql;
    }
    /**
     *  Función que regresa un query, donde se actualiza el registro de la 
     * tabla de subserie
     * @param codigo nombre 
     * @param seccion descripcion 
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo Id del registro
     * @param clv clave del registro
     * @param serie id serie
     * @return Query 
     */
    public static String actualizaSubserie(String codigo, String seccion,
									String fecha, String Usr, String serie, String IdSubfondo, String clv)
    {
        String sql = "";
        sql = "UPDATE SD_SUBSERIE  SET SUBS_NOMBRE='"+codigo+"', SUBS_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"SUBS_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), SUBS_USUARIO="+Usr+", " +
        		"SUBS_SERIE="+serie+","+
        		"SUBS_CLAVE="+clv+
        		" WHERE ID_SUBSERIE="+IdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla del expediente
     * @param soloDesc solo guarda descripcion
     * @param EXP_AREA_DESC descripcion area
     * @param EXP_CED_TIPO id cedula
     * @param EXP_CLAVE clave
     * @param EXP_INTERNO id interno
     * @param EXP_UBICACION ubicacion del exp
     * @param EXP_DENOMINACION nombre del exp
     * @param EXP_DESCRIPCION descripcion
     * @param EXP_VALORACION valoracion
     * @param EXP_FEC_CIERRE fecha de cierre
     * @param EXP_ANO_AT Años en atencion
     * @param EXP_ANO_AC Años en concentracion
     * @param EXP_SISI_DISP Años sisi
     * @param EXP_ANIOS_TOTAL_DISP Años total en disposicion
     * @param EXP_CVE_CLASF_INF id de clasificacion
     * @param EXP_MOTIVO motivo
     * @param EXP_FUNDAMENTO fundamento
     * @param EXP_OBSERVA observaciones
     * @param EXP_ANO_RESERV Años reservado
     * @param EXP_ANO_REAL Años reales
     * @param EXP_SISI_CLS Años sisi
     * @param EXP_ANIOS_TOTAL_CLS Años totales por clasificacion
     * @param EXP_ANIOS_AMPLI Años ampliados
     * @param EXP_FEC_AMPLI  fecha de ampliacion
     * @param EXP_ANIOS_GUARDA Años totales de guarda
     * @param EXP_USUARIO id del ususario
     * @param EXP_FEC_APERTURA fecha de apertura
     * @param EXP_UB_FISICA ubicacion fisica
     * @param EXP_ANIOS_REDUC  Años reducidos
     * @param IdSubfondo id del registro
     * @param fecInac fecha de inactivo
     * @param JusInac justificacion
     * @param inac inactivo
     * @return Query 
     */
    public static String actualizaExpediente(String soloDesc, String EXP_AREA_DESC, String EXP_CED_TIPO , 
            String EXP_CLAVE,String EXP_INTERNO,String EXP_UBICACION ,
            String EXP_DENOMINACION  , String EXP_DESCRIPCION  ,String EXP_VALORACION , String EXP_FEC_CIERRE ,
            String EXP_ANO_AT ,String EXP_ANO_AC,String EXP_SISI_DISP, String EXP_ANIOS_TOTAL_DISP,String EXP_CVE_CLASF_INF , 
            String EXP_MOTIVO , String EXP_FUNDAMENTO ,String EXP_OBSERVA ,String EXP_ANO_RESERV ,String EXP_ANO_REAL,
            String EXP_SISI_CLS, String EXP_ANIOS_TOTAL_CLS,String EXP_ANIOS_AMPLI , String EXP_FEC_AMPLI , 
            String EXP_ANIOS_GUARDA, String EXP_USUARIO,String EXP_FEC_APERTURA,String EXP_UB_FISICA,String EXP_ANIOS_REDUC, String IdSubfondo,
            String fecInac,String JusInac ,String inac)
					{
			        if(EXP_ANIOS_REDUC == null || EXP_ANIOS_REDUC.equalsIgnoreCase(""))EXP_ANIOS_REDUC="null";
					if(EXP_ANIOS_AMPLI == null || EXP_ANIOS_AMPLI.equalsIgnoreCase(""))EXP_ANIOS_AMPLI="null";
        		
					String sql = "";
					  if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
				        {
						sql = "UPDATE SD_EXPEDIENTES  SET  EXP_DESCRIPCION='"+EXP_DESCRIPCION+"', " +
						" EXP_FEC_INACTIVA =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
		        		" EXP_JUSTIFICA = '"+ JusInac + "'," +
		        		" EXP_STATUS = '"+ inac + "'" + 
						" WHERE ID_EXPEDIENTE="+IdSubfondo;
						return sql;
				        }
					sql = "UPDATE SD_EXPEDIENTES  SET EXP_DENOMINACION='"+EXP_DENOMINACION+"', EXP_DESCRIPCION='"+EXP_DESCRIPCION+"', " +
					//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
					" EXP_FEC_ACTUALIZACION=TO_DATE(SYSDATE, 'DD/MM/YYYY'), EXP_USUARIO="+EXP_USUARIO+" " +
					",EXP_AREA_DESC='"+EXP_AREA_DESC+"'"+
					",EXP_INTERNO='"+EXP_INTERNO+"'"+
					",EXP_UBICACION='"+EXP_UBICACION+"'"+
					",EXP_UB_FISICA="+EXP_UB_FISICA+" "+
					",EXP_FEC_APERTURA= TO_DATE('"+EXP_FEC_APERTURA+"', 'DD/MM/YYYY')"+
					",EXP_ANO_AT="+EXP_ANO_AT+
					",EXP_ANO_AC="+EXP_ANO_AC+
					",EXP_SISI_DISP="+EXP_SISI_DISP+" "+
					",EXP_ANIOS_TOTAL_DISP="+EXP_ANIOS_TOTAL_DISP+" "+
					",EXP_CVE_CLASF_INF="+EXP_CVE_CLASF_INF+" "+
					",EXP_MOTIVO='"+EXP_MOTIVO+"'"+
					",EXP_FUNDAMENTO='"+EXP_FUNDAMENTO+"'"+
					",EXP_OBSERVA='"+EXP_OBSERVA+"'"+
					",EXP_ANO_RESERV="+EXP_ANO_RESERV+""+
					",EXP_ANO_REAL="+EXP_ANO_REAL+""+
					",EXP_SISI_CLS="+EXP_SISI_CLS+""+
					",EXP_ANIOS_TOTAL_CLS="+EXP_ANIOS_TOTAL_CLS+""+
					",EXP_ANIOS_AMPLI="+EXP_ANIOS_AMPLI+" "+
					",EXP_ANIOS_REDUC="+EXP_ANIOS_REDUC+" "+
					",EXP_ANIOS_GUARDA="+EXP_ANIOS_GUARDA+", "+
	        		" EXP_FEC_INACTIVA =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
	        		" EXP_JUSTIFICA = '"+ JusInac + "'," +
	        		" EXP_STATUS = '"+ inac + "'" +  
					" WHERE ID_EXPEDIENTE="+IdSubfondo;
					return sql;
					}
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla del Acomulado
     * @param EXP_ANO_REAL Años reales
     * @param EXP_ANIOS_TOTAL_CLS Años totales
     * @param EXP_ANIOS_AMPLI Años de ampliacion
     * @param EXP_ANIOS_GUARDA Años de guarda
     * @param IdSubfondo Id del registro  
     * @return Query 
     */
    public static String actualizaExpedienteAcom(String EXP_ANO_REAL,String EXP_ANIOS_TOTAL_CLS,
            String EXP_ANIOS_AMPLI , 
            String EXP_ANIOS_GUARDA,String IdSubfondo)
					{
					if(EXP_ANIOS_AMPLI == null || EXP_ANIOS_AMPLI.equalsIgnoreCase(""))EXP_ANIOS_AMPLI="null";
        		
					String sql = "";
					sql = "UPDATE SD_EXPEDIENTES  SET  " +
					//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
					" EXP_ANO_REAL="+EXP_ANO_REAL+""+
					",EXP_ANIOS_TOTAL_CLS="+EXP_ANIOS_TOTAL_CLS+""+
					",EXP_ANIOS_AMPLI="+EXP_ANIOS_AMPLI+" "+
					",EXP_ANIOS_GUARDA="+EXP_ANIOS_GUARDA+" "+

					" WHERE ID_EXPEDIENTE="+IdSubfondo;
					return sql;
					}    
    /**
     * Función que regresa un query donde se inserta datos a la
     * tabla de SD_EXPEDIENTES_DETALLE
     * @param id id expediente
     * @param reser Años reserva
     * @param suma Años sumados
     * @param res Años restados
     * @param usu id usuario
     * @param opera tipo de operacion
     * @return Query 
     */
    public static String actualizaDetalle(	String id, String reser,
            								String suma, String res, String usu, String opera)
    {
        String sql = "";
        sql = "INSERT INTO SD_EXPEDIENTES_DETALLE (ID_DETALLE, EXP_EXPEDIENTE, EXP_ANIO_SUMA, EXP_ANIO_RESTA, EXP_ANIOS_RESV, EXP_USUARIO, EXP_FEC_ACTUALIZACION,EXP_OPERACION) " +
        		" VALUES (detalle_seq.NEXTVAL,"+id+", "+suma+", "+res+", " +
        		//"'"+fecha+"', "+Usr+", 1)";
        		""+reser+",'"+usu+"',TO_DATE(SYSDATE, 'DD/MM/YYYY'),'"+opera+"')";
        return sql;
    }    
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de Valor
     * @param soloDesc solo guarda descripcion
     * @param codigo nombre
     * @param seccion descripcion
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo Id del registro
     * @param clave clave del valor
     * @param fecInac fecha de inactivo
     * @param JusInac justificacion
     * @param inac inactivo
     * @return Query 
     */
    public static String actualizaValor(String soloDesc, String codigo, String seccion,
									String fecha, String Usr, String IdSubfondo,String clave,
									String fecInac,String JusInac ,String inac)
    {
        String sql = "";
        if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
        {
		sql = "UPDATE SD_VALOR  SET  V_DESCRIPCION='"+seccion+"' " +
		" WHERE ID_VALOR="+IdSubfondo;
		return sql;
        }
        sql = "UPDATE SD_VALOR  SET V_NOMBRE='"+codigo+"', V_DESCRIPCION='"+seccion+"', " +
		" V_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), V_USUARIO="+Usr+" " +
		",V_CLAVE="+ clave+
		",V_FEC_INACTIVA =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
		" V_JUSTIFICA = '"+ JusInac + "'," +
		" V_STATUS = '"+ inac + "'" +   
		" WHERE ID_VALOR="+IdSubfondo;
		return sql;
    }
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de Cedula Tipo 
     * @param soloDesc solo guarda descripcion
     * @param codigo nombre
     * @param seccion descripcion
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo Id del registro
     * @param clv clave
     * @param area id del area
     * @param comb combinacion
     * @param strMotivo motivacion
     * @param strFunda Fundamento
     * @param strSubserie id subserie
     * @param strSerie id serie
     * @param fecInac fecha de inactivo
     * @param JusInac justificacion
     * @param inac inactivo
     * @return Query 
     */
    public static String actualizaTipCed(String soloDesc, String codigo, String seccion,
									String fecha, String Usr, String IdSubfondo, String clv, String area, String comb,
									String strMotivo, String strFunda, String strSubserie, String strSerie,
									String fecInac,String JusInac ,String inac)
    {
        if(strSubserie == null || strSubserie.equalsIgnoreCase(""))strSubserie="null";
		if(strSerie == null || strSerie.equalsIgnoreCase(""))strSerie="null";
		
        String sql = "";
        if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
        {
		sql = "UPDATE SD_TIPO_CEDULA  SET  CED_DESCRIPCION='"+seccion+"' " +
		" WHERE ID_CEDULA ="+IdSubfondo;
		return sql;
        }
        sql = "UPDATE SD_TIPO_CEDULA  SET CED_NOMBRE ='"+codigo+"', CED_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		" CED_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), CED_USUARIO="+Usr+", " +
        		" CED_CLAVE='"+clv+"',"+
        		" CED_MOTIVO='"+strMotivo+"',"+
        		" CED_FUNDAMENTO='"+strFunda+"',"+
        		" CED_ICDD_UAS="+strSerie+","+
        		" CED_ICDD_UASub="+strSubserie+","+
        		" CED_CVE_UA='"+area+"',"+
        		" CED_FEC_FECINACT =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
        		" CED_JUSTIFICACION = '"+ JusInac + "'," +
        		" CED_STATUS = '"+ inac + "'" +   
        		" WHERE ID_CEDULA ="+IdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de Seleccion
     * @param soloDesc solo guarda descripcion
     * @param codigo nombre
     * @param seccion descripcion
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo Id del registro
     * @param clv clave
     * @param fecInac fecha de inactivo
     * @param JusInac justificacion
     * @param inac inactivo
     * @return Query 
     */
    public static String actualizaSeleccion(String soloDesc,String codigo, String seccion,
									String fecha, String Usr, String IdSubfondo, String clv,
									String fecInac,String JusInac ,String inac)
    {
        String sql = "";
        
        if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
        {
		sql = "UPDATE SD_SELECCION SET SEL_DESCRIPCION='"+seccion+"'" +
		" WHERE ID_SELECCION="+IdSubfondo;
		return sql;
        }
        sql = "UPDATE SD_SELECCION  SET SEL_NOMBRE='"+codigo+"', SEL_DESCRIPCION='"+seccion+"', " +
        		"SEL_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), SEL_USUARIO="+Usr+" " +
        		", SEL_CLAVE="+clv+
        		", SEL_FEC_INACTIVA =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
        		"  SEL_JUSTIFICA = '"+ JusInac + "'," +
        		"  SEL_STATUS = '"+ inac + "'" +          		
        		" WHERE ID_SELECCION="+IdSubfondo;
        return sql;
    }
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de FONDO 
     * @param soloDesc solo guarda descripcion
     * @param codigo nombre
     * @param seccion descripcion
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param id Id del registro
     * @param clave clave del registro
     * @param sisi numero de Años sisi
     * @param fecInac fecha de inactivo
     * @param JusInac justificacion
     * @param inac inactivo
     * @return Query 
     */
    public static String actualizaFondo(String soloDesc, String codigo, String seccion,
									String fecha, String Usr, String id, String clave, String  sisi,
									String fecInac, String JusInac, String inac)
    {
        String sql = "";
        
	        if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
	        {
			sql = "UPDATE SD_FONDO_ARCH  SET FON_DESCRIPCION='"+seccion+"' " +
    		" WHERE ID_FONDO="+id;
			return sql;
	        }
	        
        sql = "UPDATE SD_FONDO_ARCH  SET FON_NOMBRE='"+codigo+"', FON_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"FON_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), FON_USUARIO="+Usr+" ," +
        		" FON_CLAVE= '"+clave+"' ," +
        		" FON_SISI = "+sisi + "," +  
        		" FON_FEC_INACTIVA =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
        		" FON_JUSTIFICA = '"+ JusInac + "'," +
        		" FON_STATUS = '"+ inac + "'" +  
        		" WHERE ID_FONDO="+id;
        return sql;
    }
    /**
     *  Función que regresa un query, donde se actualiza el registro de la 
     * tabla Combinacion
     * @param codigo nombre
     * @param seccion descripcion
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param id  fondo
     * @param idserie id serie
     * @param idsec id seccion
     * @param id del registro
     * @param tipcomb tipo de combinacion
     * @param clave clave del registro
     * @return Query 
     */
    public static String actualizaComb(String codigo, String seccion,
									String fecha, String Usr, String IdSubfondo, String idserie, String idsec,String id,String tipcomb ,String clave)
    {
        String sql = "";
        sql = "UPDATE SD_COMBINACION  SET COM_NOMBRE='"+codigo+"', COM_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"COM_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), COM_USUARIO="+Usr+", " +
        		" COM_FONDO = "+IdSubfondo+
        		" ,COM_SERIE = "+idserie+
        		" ,COM_SECCION = "+idsec+
        		" ,COM_CLAVE  = '"+clave+"'"+
        		" ,COM_TIP_COMBINACION = '"+tipcomb+"'"+
        		" WHERE ID_COMBINACION="+id;
        return sql;
    }
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de Clasificacion serie
     * @param soloDesc solo guarda descripcion
     * @param codigo nombre
     * @param seccion descripcion
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param idserie id serie
     * @param idsec id seccion
     * @param strFechaAT Años tramite
     * @param strFechaAC Años conserva
     * @param strFechaTotal Años totales
     * @param strAnosSISI Años sisi
     * @param strConf confidencial
     * @param id Id del registro
     * @param clv clave del registro
     * @param fecInac fecha de inactivo
     * @param JusInac justificacion
     * @param inac inactivo
     * @param rerv reserva
     * @param obv observaciones
     * @return Query 
     */
    public static String actualizaClasif(String soloDesc, String codigo, String seccion,
									String fecha, String Usr, String idserie, String idsec,
									String strFechaAT, String strFechaAC, String strFechaTotal,
									String strAnosSISI, String strConf, String id, String clv,
									String fecInac,String JusInac ,String inac, String rerv, String obv)
    {
        String sql = "";
        if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
        {
		sql = "UPDATE SD_CLASIFICACION   SET CLS_DESCRIPCION='"+seccion+"' " +
		" WHERE ID_CLASIFICACION="+id;
		return sql;
        }
        sql = "UPDATE SD_CLASIFICACION   SET CLS_NOMBRE='"+codigo+"', CLS_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"CLS_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), CLS_USUARIO="+Usr+", " +
        		" CLS_VALORACION = "+idserie+
        		" ,CLS_SELECCION = "+idsec+
        		" ,CLS_VIGENCIA_AT = "+strFechaAT+
        		" ,CLS_VIGENCIA_AC = "+strFechaAC+
        		" ,CLS_VIGENCIA_TOTAL ="+strFechaTotal+
        		" ,CLS_ANOS_SISI = "+strAnosSISI+
        		" ,CLS_CONFIDENCIAL = '"+strConf+"'"+
        		" ,CLS_ANOS_RESERVA = "+rerv+""+
        		" ,CLS_CLAVE = '"+clv+"',"+       
        		" CLS_FEC_FECINACT =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
        		" CLS_JUSTIFICACION = '"+ JusInac + "'," +
        		" CLS_STATUS = '"+ inac + "'," +
        		" CLS_OBSERVACIONES = '"+ obv + "'" +
        		" WHERE ID_CLASIFICACION="+id;
        return sql;
    }
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de Clasificacion Subserie
     * @param soloDesc solo guarda descripcion
     * @param codigo nombre
     * @param seccion descripcion
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param idserie id serie
     * @param idsec id seccion
     * @param strFechaAT Años tramite
     * @param strFechaAC Años conserva
     * @param strFechaTotal Años totales
     * @param strAnosSISI Años sisi
     * @param strConf confidencial
     * @param id Id del registro
     * @param clv clave del registro
     * @param fecInac fecha de inactivo
     * @param JusInac justificacion
     * @param inac inactivo
     * @param rerv reserva
     * @param obv observaciones
     * @return Query 
     */
    public static String actualizaClasifsub(String soloDesc, String codigo, String seccion,
									String fecha, String Usr, String idserie, String idsec,
									String strFechaAT, String strFechaAC, String strFechaTotal,
									String strAnosSISI, String strConf, String id, String clv,
									String fecInac,String JusInac ,String inac, String rerv, String obv)
    {
        String sql = "";
        if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
        {
		sql = "UPDATE SD_CLASIFICACION_SUB   SET CLS_DESCRIPCION='"+seccion+"' " +
		" WHERE ID_CLASIFICACION="+id;
		return sql;
        }
        sql = "UPDATE SD_CLASIFICACION_SUB   SET CLS_NOMBRE='"+codigo+"', CLS_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"CLS_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), CLS_USUARIO="+Usr+", " +
        		" CLS_VALORACION = "+idserie+
        		" ,CLS_SELECCION = "+idsec+
        		" ,CLS_VIGENCIA_AT = "+strFechaAT+
        		" ,CLS_VIGENCIA_AC = "+strFechaAC+
        		" ,CLS_VIGENCIA_TOTAL ="+strFechaTotal+
        		" ,CLS_ANOS_SISI = "+strAnosSISI+
        		" ,CLS_CONFIDENCIAL = '"+strConf+"'"+
        		" ,CLS_ANOS_RESERVA = "+rerv+""+
        		" ,CLS_CLAVE = '"+clv+"',"+       
        		" CLS_FEC_FECINACT =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
        		" CLS_JUSTIFICACION = '"+ JusInac + "'," +
        		" CLS_STATUS = '"+ inac + "'," +
        		" CLS_OBSERVACIONES = '"+ obv + "'" +
        		" WHERE ID_CLASIFICACION="+id;
        return sql;
    }    
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de Serie
     * @param codigo codigo del subfondo
     * @param seccion Sección del subfondo
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param id Id del registro
     * @param clv clave del registro
     * @return Query  Query
     */
    public static String actualizaSerie(String codigo, String seccion,
									String fecha, String Usr, String id, String clv)
    {
        String sql = "";
        sql = "UPDATE SD_SERIE  SET SER_NOMBRE='"+codigo+"', SER_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"SER_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), SER_USUARIO='"+Usr+"'," +
        		" SER_CLAVE="+clv+
        		" WHERE ID_SERIE="+id;
        return sql;
    }
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de Clasificacion de la Informacion
     * @param soloDesc solo guarda descripcion
     * @param codigo nombre
     * @param seccion Descripcion
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param id Id del registro
     * @param clv clave del registro
     * @param fecInac fecha de inactivo
     * @param JusInac justificacion
     * @param inac inactivo
     * @return Query
     */
    public static String actualizaClasifInf(String soloDesc, String codigo, String seccion,
									String fecha, String Usr, String id, String clv,
									String fecInac, String JusInac, String inac)
    {
        String sql = "";
        
        if (soloDesc=="1" ||soloDesc.equalsIgnoreCase("1"))
        {
		sql = "UPDATE SD_CLASIF_INF  SET CLSI_DESCRIPCION='"+seccion+"'" +
		" WHERE ID_CLASIF_INF="+id;
		return sql;
        }
        sql = "UPDATE SD_CLASIF_INF  SET CLSI_NOMBRE='"+codigo+"', CLSI_DESCRIPCION='"+seccion+"', " +
        		//"SUB_FECHA_CREACION='"+fecha+"', SUB_USR_ACTUALIZO="+Usr+" " +
        		"CLSI_FEC_ACTUALIZACION=TO_DATE('"+fecha+"', 'DD/MM/YYYY'), CLSI_USUARIO='"+Usr+"'," +
        		" CLSI_CLAVE="+clv+
        		" ,CLSI_FEC_INACTIVA =TO_DATE('"+fecInac+"', 'DD/MM/YYYY')," +
        		" CLSI_JUSTIFICA = '"+ JusInac + "'," +
        		" CLSI_STATUS = '"+ inac + "'" +  
        		" WHERE ID_CLASIF_INF="+id;
        return sql;
    }
    /**
     * Función que regresa un query, donde se actualiza el registro de la 
     * tabla de SD_SUBFONDO 
     * @param codigo codigo del subfondo
     * @param seccion Sección del subfondo
     * @param fecha fecha en la que se actualiza
     * @param Usr Usuario que actualiza
     * @param IdSubfondo Id del registro
     * @return Query
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
     * Función para crear un combo de subfondo
     * @return Query
     */
    public static String getSubfondoCombo()
    {
        String sql = "";
        sql = "SELECT ID_SUBFONDO, SUB_CODIGO || ' - ' || SUB_SECCION " +
        		"FROM SD_SUBFONDOARCH  WHERE SUB_ESTATUS=1";
        return sql;
    }
    /**
     * Función para crear un combo de areas
     * @return Query consulta
     */
    public static String getAreaCombo()
	{
		String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA " +
				"WHERE ARE_ESTATUS=1 ORDER BY ARE_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Función para crear un combo de areas por Id
     * @param IdArea Id del area
     * @return Query consulta
     */
    public static String getAreaCombo(String IdArea)
	{
		String strSql="";		
		strSql=	"SELECT ID_AREA, ARE_NOMBRE FROM SD_AREA WHERE ARE_ESTATUS=1 " +
				"AND ID_AREA="+IdArea+" ORDER BY ARE_NOMBRE";												
		return strSql;	
	}
    /**
     * Función para crear un combo de Cuadro de Disposicion por areab para serie
     * @param IdArea id del area
     * @return Query consulta
     */
    public static String getComboICDDSer(String IdArea)
	{
		String strSql="";		
		strSql="Select A.ID_CLASIFICACION, A.CLS_CLAVE || ' / ' || A.CLS_NOMBRE NOMBRE" +
			" FROM SD_CLASIFICACION A, SD_ICDD_UA B" +
			" WHERE A.ID_CLASIFICACION  = B.ICDD_CLAVES_SERIES " +
			" AND B.ICDD_CLAVE_UA ="+ IdArea +" " +
			" AND B.ICDD_STATUS=1";												
		return strSql;	
	}   
    /**
     * Función para crear un combo de Cuadro de Disposicion por areab para Subserie
     * @param IdArea id del area
     * @return Query consulta
     */
    public static String getComboICDDSubSer(String IdArea)
	{
		String strSql="";		
		strSql="Select A.ID_CLASIFICACION, A.CLS_CLAVE || ' / ' || A.CLS_NOMBRE NOMBRE" +
				" FROM SD_CLASIFICACION_SUB A, SD_ICDD_UA B" +
				" WHERE A.ID_CLASIFICACION  = B.ICDD_CLAVES_SUBSERIES " +
				" AND B.ICDD_CLAVE_UA ="+ IdArea +" " +
				" AND B.ICDD_STATUS=1";													
		return strSql;	
	}
    /**
     * Función para crear un combo para listar areas
     * @return Query consulta
     */
    public static String getAreaComboExp()
	{
		String strSql="";		
		strSql=	"SELECT NVL(ARE_CLAVE,'S/N'), ARE_NOMBRE FROM SD_AREA " +
				"WHERE ARE_ESTATUS=1 ORDER BY ARE_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Función para crear un combo para listar areas por ID
     * @param IdArea id del area
     * @return Query consulta
     */
    public static String getAreaComboExp(String IdArea)
	{
		String strSql="";		
		strSql=	"SELECT NVL(ARE_CLAVE,'S/N'), ARE_NOMBRE FROM SD_AREA WHERE ARE_ESTATUS=1 " +
				"AND ID_AREA="+IdArea+" ORDER BY ARE_NOMBRE";												
		return strSql;	
	}
    
    /**
     * Nombre de la Sección
     * @param idSeccion Id Sección
     * @return Query
     */
    public static String getICDDUnidadSeccion(String idSeccion)
	{
		String strSql="";		
		/*strSql=	"SELECT ID_SECCION,SEC_CLAVE || ' / ' || SEC_NOMBRE NOMBRE  from SD_SECCION_ARCH WHERE SEC_STATUS=1 " +
			" ORDER BY SEC_NOMBRE";	*/										
		
		strSql=	"SELECT SEC_CLAVE||'/'||SEC_NOMBRE||' - '||FON_CLAVE||'/'||FON_NOMBRE||' - '||SUBF_CLAVE||'/'||SUBF_NOMBRE " +
				"from SD_SECCION_ARCH, SD_FONDO_ARCH, SD_SUBFONDOARCH " +
				"WHERE SEC_STATUS=1 " +
				"AND SEC_FONDO = ID_FONDO " +
				"AND SEC_SUBFONDO = ID_SUBFONDO " +
				"AND ID_SECCION = "+idSeccion+" " +
				"ORDER BY SEC_NOMBRE ";											
		return strSql;	
	}
}