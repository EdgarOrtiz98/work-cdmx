/*
 * Clase:						ActualizaArchivado.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Dec 7, 2005
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

import java.sql.SQLException;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLArchivado;

/**
 * 	ActualizaArchivado es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Archivado
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaArchivado {
    
	/**
	 * Función que ejecuta un query, donde se inserta los datos de un archivado 
	 * @param strSubFondo		Subfondo
	 * @param strSeccion		Sección
	 * @param strSerie			Seríe
	 * @param strSubserie		Subseríe
	 * @param strFechaApertura	Fecha de apertura
	 * @param strFechaCierre	Fecha cierre
	 * @param strValorDocto		Valor docto.
	 * @param strVigenciaDocto	Vigencia docto.
	 * @param strFojas			Fojas
	 * @param strLegajos		Legajos
	 * @param strTipoAsunto		Tipo asunto
	 * @param strFechaCla		Fecha Calsificación
	 * @param strFundamento		Fundamento
	 * @param strPeriodoReserva	Periodo reserva
	 * @param strDesclasificacion	desclasificación
	 * @param strAmpliacion			Ampliación
	 * @param strNumAnios			Número de Años
	 * @param strDesclasificacion1	desclasificación
	 * @param strResponsableExp		Responsable
	 * @param strResponsableCla		Responsable claificación
	 * @param strIdAsunto			Id asunto
	 * @return	true si inserto correctamente
	 */
    public static boolean InsertarArchivado(String strSubFondo,
            String strSeccion, String strSerie, String strSubserie, String strFechaApertura,
            String strFechaCierre, String strValorDocto, String strVigenciaDocto,
            String strFojas, String strLegajos, String strTipoAsunto, String strFechaCla,
            String strFundamento, String strPeriodoReserva, String strDesclasificacion, String strAmpliacion,
            String strNumAnios, String strDesclasificacion1, String strResponsableExp, String strResponsableCla,
            String strIdAsunto)   
    {
        int r = 0;
        try
        {
            String strSql = SQLArchivado.getInsertaArchivado(strSubFondo,
						strSeccion, strSerie, strSubserie, strFechaApertura,
						strFechaCierre, strValorDocto, strVigenciaDocto,
						strFojas, strLegajos, strTipoAsunto, strFechaCla,
						strFundamento, strPeriodoReserva, strDesclasificacion, strAmpliacion,
						strNumAnios, strDesclasificacion1, strResponsableExp, strResponsableCla,
						strIdAsunto);
            
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.err.println("InsertaAsunto: "+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Función que ejecuta un query donde verifica si el
     * asunto tiene datos en el archivado
     * @param idAsunto Contiene el ID del Asunto
     * @return True
     */
    public static boolean getTieneArchivado(String idAsunto)
	{		
		try
		{
			String strsql = SQLArchivado.getTieneArchivado(idAsunto);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			return false;
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Función que ejecuta un query, donde se muestra una lista de 
     * los campos de un archivado de un asunto
     * @param stridAsunto Contiene el Id del Asunto
     * @return String[][]
     */
    public static String[][] getDatosArchivado(String stridAsunto)
    {
        try
		{
			String strsql = SQLArchivado.getDatosArchivado(stridAsunto);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.err.println("getDatosArchivado:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }

}

