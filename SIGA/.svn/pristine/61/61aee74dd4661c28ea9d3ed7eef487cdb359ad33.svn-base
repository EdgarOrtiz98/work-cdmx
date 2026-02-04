/**
 * Clase:						SQLDiaFestivo.java
 * 
 * Paquete:						com.meve.sigma.sql		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 22, 2005
 * 
 * @author: 					Arturo Corichi Guerrero
 * 								corichi@yahoo.com.mx
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		Clase que contiene metodos que construyen sentencias sql para la 
 * 								actualizacion y lectura de la tabla DIAS_FESTIVOS
 */

package com.meve.sigma.sql;

/**
 * SQLDestino es una clase que contiene los querys que hacen consultas y actualizaciones
 * a la tabla de SD_DESTINATARIOS
 * @author Administrator
 *
 */
public class SQLDiaFestivo {

    /**
     * Datos del registro de un Día festivo 
     * @param DN	Id Día festivo
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDiaFestivo(String DN)
	{
		String strSql="";		
		strSql=	"SELECT ID_DIA_FESTIVO, TO_CHAR(DIA_FEST_FECHA, 'dd/MM/yyyy'), DIA_FEST_DESCRIPCION," +
				" DIA_FEST_USR_ACTUALIZO, to_char(DIA_FEST_FEC_ACTUALIZACION, 'dd/mm/yyyy HH:MI:SS AM')" +
				" FROM SD_DIA_FESTIVO" +
				" WHERE ID_DIA_FESTIVO=" + DN;
		return strSql;
	}
    
    /**
     * Inserta registro del Día festivo
	 * @param DiaFestivoFecha	Día festivo
	 * @param Descripcion		Descripción
	 * @param actualizo			Usuario que actualizo el registro
	 * @param fecha				Fecha de Actualización
	 * @param estatus			Estatus
     * @return	 Regresa un String con el Query correspondiente
     */
    public static String getInsertaDiaFestivo(String DiaFestivoFecha, String Descripcion,
    									String actualizo, String fecha, String estatus)
    {
        String sql = "";
        sql = 	"INSERT INTO SD_DIA_FESTIVO" +
        		" (ID_DIA_FESTIVO,DIA_FEST_FECHA, DIA_FEST_DESCRIPCION," +
				" DIA_FEST_USR_ACTUALIZO, DIA_FEST_FEC_ACTUALIZACION, DIA_FEST_ESTATUS)" +
        		" VALUES (SD_DIA_FESTIVO_SEQ.NEXTVAL, TO_DATE('"+DiaFestivoFecha+"', 'DD/MM/YYYY'), '"+Descripcion+"',"+
				//" "+actualizo+", '"+fecha+"', "+estatus+")";
        		" "+actualizo+", SYSDATE, "+estatus+")";
        return sql;
    }
    
    /**
     * Lista de los Días festivos para la vista del catalogo
	 * @param strOrden	Orden de columnas
	 * @param tipo		Tipo de orden 
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDiasFestivos(String strOrden, String tipo)
	{
		String strSql="";
		strSql=	"SELECT ID_DIA_FESTIVO, to_char(DIA_FEST_FECHA,'yyyy-MM-dd'), DIA_FEST_DESCRIPCION,";
		strSql+=" DIA_FEST_USR_ACTUALIZO, DIA_FEST_FEC_ACTUALIZACION";
		strSql+=" FROM SD_DIA_FESTIVO";
		strSql+=" WHERE DIA_FEST_ESTATUS=1";
		if(tipo.equals("1")){
			strSql+="ORDER BY DIA_FEST_FECHA "+strOrden+", 2 ASC ";
		}else if(tipo.equals("2")){
			strSql+="ORDER BY 3 "+strOrden+", 2 ASC ";
		}
		return strSql;	
	}
    
    /**
     * Lista de los Días festivos
     * @return	Regresa un String con el Query correspondiente
     */
    public static String getDiasFestivos()
	{
		String strSql="";
		strSql=	"SELECT ID_DIA_FESTIVO, to_char(DIA_FEST_FECHA,'yyyy-MM-dd'), DIA_FEST_DESCRIPCION,";
		strSql+=" DIA_FEST_USR_ACTUALIZO, DIA_FEST_FEC_ACTUALIZACION";
		strSql+=" FROM SD_DIA_FESTIVO";
		strSql+=" WHERE DIA_FEST_ESTATUS=1 ORDER BY 2";
		return strSql;	
	}

	/**
	 * Actualiza los Días festivos
	 * @param idDiaFestivo		Id Día festivo
	 * @param DiaFestivoFecha	fecha del Día festivo
	 * @param Descripcion		Descripción
	 * @param actualizo			usuario que actualizo el registro
	 * @param fecha				fecha de Actualización
	 * @return	Regresa un String con el Query correspondiente
	 */
    public static String getActualizarDiaFestivo(String idDiaFestivo, String DiaFestivoFecha, 
    								String Descripcion, String actualizo, String fecha)
    {
    	String strSql="";
    	strSql=	"UPDATE SD_DIA_FESTIVO SET " +
		"ID_DIA_FESTIVO="+idDiaFestivo+", DIA_FEST_FECHA=TO_DATE('"+DiaFestivoFecha+"', 'DD/MM/YYYY'), " +
		"DIA_FEST_DESCRIPCION='" + Descripcion +"', "+
		"DIA_FEST_USR_ACTUALIZO="+actualizo+", " +
		//"DIA_FEST_FEC_ACTUALIZACION='"+fecha+"' " +
		//"DIA_FEST_FEC_ACTUALIZACION=TO_DATE('"+fecha+"','DD/MM/YYYY') " +
		"DIA_FEST_FEC_ACTUALIZACION=SYSDATE " +
		"WHERE ID_DIA_FESTIVO="+idDiaFestivo;
    	return strSql;
    }
    
    /**
     * Elimina registros de Días festivos
     * @param strIds	Id de los Días festivos que se eliminarón
     * @return	Regresa un String con el Query correspondiente
     */
	public static String getDeleteDiaFestivo(String strIds)
	{
		String strSql="";  
		strSql=	" UPDATE SD_DIA_FESTIVO SET"	+
		" DIA_FEST_ESTATUS=0, DIA_FEST_FEC_ACTUALIZACION=SYSDATE WHERE ID_DIA_FESTIVO IN ("+strIds+")";				
		return strSql;    	
	}
	
	/**
	 * Verifica si existe el Día festivo
     * @param DiaFestivoFecha		nuevo Día festivo
     * @param DiaFestivoFechaPrevia	fecha previa
	 * @return	Regresa un String con el Query correspondiente
	 */
	public static String getDiaFestivoExiste(String DiaFestivoFecha, String DiaFestivoFechaPrevia){
    	String sql = "SELECT to_char(DIA_FEST_FECHA,'yyyy-MM-dd') " +
					"FROM SD_DIA_FESTIVO " +
					"WHERE DIA_FEST_FECHA = TO_DATE('"+DiaFestivoFecha+"', 'DD/MM/YYYY') " +
					"AND DIA_FEST_FECHA <> TO_DATE('"+DiaFestivoFechaPrevia+"', 'DD/MM/YYYY') " +
					"AND DIA_FEST_ESTATUS = 1";
    	return sql;
    }
}
