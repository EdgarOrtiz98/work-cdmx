/*
 * Clase:						ActualizaReportes.java
 * 
 * Paquete:						com.meve.sigma.reportes		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Oct 22, 2005
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

import java.sql.SQLException;
import java.text.NumberFormat;

import com.meve.sigma.db2.ConexionDS;

/**
 * Clase para Insertar, Borrar y Editar los Reportes
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaReportes {
    
	/**
     * Regresa un arreglo con el numero mas grande de los ID de Reportes
     * 
     * @return Regresa un String[][] con el numero mas grande de los ID de Reportes
     */
    public static String[][] getMaxID()
	{	
        String SQL = "SELECT MAX(ID_REPORTE) FROM SD_REPORTES";
		try
		{
			String strsql	=	SQL;
			////System.out.println("getMaxID:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getMaxID:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Inserta n numero de registros de reportes de Asuntos, donde n es el numero de filas de strReporte.
     * Calcúla el porcentaje de Asuntos con referencia al Total de los mismos
     * 
     * @param idReporte ID del Reporte
     * @param strReporte Arreglo con los parametros del reporte
     * @param strTipoReporte Tipo de reporte
     * @param strFecha Fecha de creacion del reporte
     * @param total Total de Asuntos
     * @param strTitulo Título del Reporte
     * @param strIdArea ID del la UA a la que pertenece el reporte
     * 
     * @return Regresa True si se pudo insertar el Reporte y False si hubo una problema
     */
    public static boolean InsertarAsunto(int idReporte, String[][] strReporte, String strTipoReporte,
            							String strFecha, int total, String strTitulo, String strIdArea)
    {
        int r = 0;
        int avg = 0;
        float avg1= 0;
        float avg2=0;
        
        
        
        try
        {
            String strSql = "";//SQLAsunto.getInsertaAsunto();
            ////System.out.println("\tID---->"+idReporte);
            for(int j=0;j<strReporte.length;j++){
                
                avg = new Integer(strReporte[j][2]).intValue();
                if(total==0)
                	avg1 = 0;
                else
                	avg1 = (float)(avg*100)/total;
                NumberFormat df = NumberFormat.getNumberInstance();
                df.setMaximumFractionDigits(2);
                String text = df.format(avg1);
                ////System.out.println("\t*** Porcentaje--->"+text);
                strSql = SQLReportes.InsertarReportes(	idReporte, strTipoReporte, strReporte[j][0], 
                        								strReporte[j][1], strReporte[j][2], 
                        								text, strFecha, strTitulo, strIdArea);
                // //System.out.println("InsertaAsunto="+strSql);
            	r = ConexionDS.ejecutarActualizacion(strSql);
            }
            	
        }
        catch (SQLException sqle)
        {
           //System.out.println("InsertaAsunto:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Inserta n numero de registros de reportes de Asuntos Remitidos, donde n es el numero de filas de strReporte.
     * Calcúla el porcentaje de Asuntos con referencia al Total de los mismos
     * 
     * @param idReporte ID del Reporte
     * @param strReporte Arreglo con los parametros del reporte
     * @param strTipoReporte Tipo de reporte
     * @param strFecha Fecha de creacion del reporte
     * @param total Total de Asuntos
     * @param strTitulo Título del Reporte
     * @param strIdArea ID del la UA a la que pertenece el reporte
     * 
     * @return Regresa True si se pudo insertar el Reporte y False si hubo una problema
     */
    public static boolean InsertarAsuntoRemitido(int idReporte, String[][] strReporte, String strTipoReporte,
			String strFecha, int total, String strTitulo, String strIdArea)
    {
        int r = 0;
        int avg = 0;
        float avg1= 0;
        float avg2=0;
        
        try
        {
            String strSql = "";
            for(int j=0;j<strReporte.length;j++){

                avg = new Integer(strReporte[j][2]).intValue();
                avg1 = (float)(avg*100)/total;
                NumberFormat df = NumberFormat.getNumberInstance();
                df.setMaximumFractionDigits(2);
                String text = df.format(avg1);
                
                strSql = SQLReportes.InsertarReportes(	idReporte, strTipoReporte, strReporte[j][0], 
                			strReporte[j][1], strReporte[j][2], 
							text, strFecha, strTitulo, strIdArea);
                // //System.out.println("InsertarAsuntoRemitido="+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
            }
            
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertarAsuntoRemitido:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Inserta n numero de registros de reportes de Asuntos por Estatus, donde n es el numero de filas de strReporte.
     * 
     * @param idReporte ID del Reporte
     * @param strReporte Arreglo con los parametros del reporte
     * @param strTipoReporte Tipo de reporte
     * @param strFecha Fecha de creacion del reporte
     * @param strIdArea ID del area del reporte
     * 
     * @return Regresa True si se pudo insertar el Reporte y False si hubo una problema
     */

    public static boolean InsertarAsuntoEstatus(int idReporte, String[][] strReporte, String strTipoReporte,
			String strFecha, String strTitulo, String strIdArea)
    {
        int r = 0;
        String avg = "0";
        try
        {
            String strSql = "";//SQLAsunto.getInsertaAsunto();
            for(int j=0;j<strReporte.length;j++){
                strSql = SQLReportes.InsertarReportesEstatus(	idReporte, strTipoReporte, strReporte[j][0], 
								strReporte[j][1], strReporte[j][2], strReporte[j][3], strReporte[j][4],  
								strFecha, strReporte[j][5], strReporte[j][6], strIdArea, strTitulo);
                // //System.out.println("InsertarReportesEstatus="+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
            }

        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertarReportesEstatus:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Inserta n numero de registros de reportes de Asuntos por Tiempos de Respuesta, donde n es el numero de filas de strReporte.
     * 
     * @param idReporte ID del Reporte
     * @param strReporte Arreglo con los parametros del reporte
     * @param strTipoReporte Tipo de reporte
     * @param strFecha Fecha de creacion del reporte
     * @param strTitulo Título del Reporte
     * @param strIdArea ID del la UA a la que pertenece el reporte
     * 
     * @return Regresa True si se pudo insertar el Reporte y False si hubo una problema
     */
    public static boolean insertarReportesTiempos(int idReporte, String[][] strReporte, String strTipoReporte,
            										String strFecha, String strTitulo, String strIdArea) 
    {
        int r = 0;
        int avg = 0;
        float avg1= 0;
        float avg2=0;
        
        
        
        try
        {
            String strSql = "";
            for(int j=0;j<strReporte.length;j++){
                
                strSql = SQLReportes.insertarReportesTiempos(idReporte, strTipoReporte, strReporte[j][0], 
                        								strReporte[j][1], strReporte[j][2], strReporte[j][3],
                        								strReporte[j][4], strReporte[j][5], strReporte[j][6],
                        								strReporte[j][7], strReporte[j][8],
                        								strFecha, strTitulo, strIdArea);
                // //System.out.println("insertarReportesTiempos="+strSql);
            	r = ConexionDS.ejecutarActualizacion(strSql);
            }
            	
        }
        catch (SQLException sqle)
        {
           //System.out.println("insertarReportesTiempos:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Inserta n numero de registros de reportes de Asuntos por Fecha de Creacion, donde n es el numero de filas de strReporte.
     * 
     * @param idReporte ID del Reporte
     * @param strReporte Arreglo con los parametros del reporte
     * @param strTipoReporte Tipo de reporte
     * @param strFecha Fecha de creacion del reporte
     * @param strTitulo Título del Reporte
     * @param strIdArea ID del la UA a la que pertenece el reporte
     * 
     * @return Regresa True si se pudo insertar el Reporte y False si hubo una problema
     */
    public static boolean insertarPorFechaCap(int idReporte, String[][] strReporte, String strTipoReporte,
											String strFecha, String strTitulo, String strIdArea) 
    {
        int r = 0;
        int avg = 0;
        float avg1= 0;
        float avg2=0;
        String strFechaCap = "";

        try
        {
            String strSql = "";
            for(int j=0;j<strReporte.length;j++){
                strFechaCap = strReporte[j][0];
                strSql = SQLReportes.insertarPorFechaCap(idReporte, strTitulo, strTipoReporte, 
                										strReporte[j][1], strReporte[j][0], 
                										strReporte[j][2], strFecha, strIdArea);
                r = ConexionDS.ejecutarActualizacion(strSql);
            }

        }
        catch (SQLException sqle)
        {
            //System.out.println("insertarPorFechaCap:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    
    /**
     * Regresa un arreglo con los campos de Reportes por Asuntos asociados a un ID de Reporte
     * 
     * @param strIdReporte ID de Reporte
     * 
     * @return Regresa un String[][] con los campos de los Reportes
     */
    public static String[][] getDatosReportes(String strIdReporte)
	{	
		try
		{
			String strsql	=	SQLReportes.getDatosReportes(strIdReporte);
			////System.out.println("getDatosReportes:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getDatosReportes:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Regresa un arreglo con los campos de Reportes por Fecha de Captura asociados a un ID de Reporte
     * 
     * @param strIdReporte ID de Reporte
     * 
     * @return Regresa un String[][] con los campos de los Reportes
     */
    public static String[][] getDatosReportesPorFechaCap(String strIdReporte)
	{	
		try
		{
			String strsql	=	SQLReportes.getDatosReportesPorFechaCap(strIdReporte);
			////System.out.println("getDatosReportesPorFechaCap:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getDatosReportesPorFechaCap:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Regresa un arreglo con los campos de Reportes por Estatus asociados a un ID de Reporte y a una UA
     * 
     * @param strIdReporte ID de Reporte
     * @param strIdArea ID de la UA
     * 
     * @return Regresa un String[][] con los campos de los Reportes
     */
    public static String[][] getDatosReportesEstatus(String strIdReporte, String strIdArea)
	{	
		try
		{
			String strsql	=	SQLReportes.getDatosReportesEstatus(strIdReporte, strIdArea);
			////System.out.println("getDatosReportes:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getDatosReportes:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Genera datos para los Reportes por Asunto
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReporte(String inicio, String fin, String strIdArea)
	{	
		try
		{
			String strsql	=	SQLReportes.getReporte(inicio, fin, strIdArea);
			////System.out.println("getReporte()"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReporte():"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Genera datos para los Reportes por Tiempso de Respuesta
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportePorTiempos(String inicio, String fin, String strIdArea)
	{	
		try
		{
			String strsql	=	SQLReportes.getReportePorTiempos(inicio, fin, strIdArea);
			////System.out.println("getReportePorTiempos():"+strsql);
			String strResultados[][] = ConexionDS.ejecutarSQL(strsql);
			return strResultados;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportePorTiempos():"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Genera datos para los Reportes por Remitentes
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportePorRemitente(String inicio, String fin, String strIdArea)
	{	
		try
		{
			String strsql	=	SQLReportes.getReportePorRemitente(inicio, fin, strIdArea);
			////System.out.println("getReportePorRemitente()"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportePorRemitente():"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Genera datos para los Reportes por Remitentes Internos
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportePorRemitenteI(String inicio, String fin, String strIdArea)
	{	
		try
		{
			String strsql	=	SQLReportes.getReportePorRemitenteI(inicio, fin, strIdArea);
			////System.out.println("getReportePorRemitenteI()"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportePorRemitenteI():"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Genera datos para los Reportes por Destinatarios
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportePorDestinatario(String inicio, String fin, String strIdArea)
	{	
		try 
		{
			String strsql	=	SQLReportes.getReportePorDestinatario(inicio, fin, strIdArea);
			////System.out.println("getReportePorDestinatario()"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportePorDestinatario():"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Genera datos para los Reportes por Estatus
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea Id de la Unidad Administrativa del Usuario
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportePorEstatus(String inicio, String fin, String strIdArea)
	{	
		String strsql	=	SQLReportes.getReportePorEstatus(inicio, fin, strIdArea);
		try
		{
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getReportePorEstatus"+strsql);
			//System.out.println("getReportePorEstatus:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Genera datos para los Reportes por Fecha
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportePorFechaLim()
	{	
		try
		{
			String strsql	=	SQLReportes.getReportePorFechaLim();
			////System.out.println("getReportePorFechaLim:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportePorFechaLim:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}		
	}                      
    
    /**
     * Genera datos para los Reportes por Asuntos
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportePorAsuntos(String inicio, String fin, String strIdArea) 
	{	
		try
		{
			String strsql	=	SQLReportes.getReportePorAsuntos(inicio, fin, strIdArea);
			////System.out.println("getReportePorAsuntos():"+strsql);
			String strResultados[][] = ConexionDS.ejecutarSQL(strsql);
			return strResultados;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportePorAsuntos():"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Genera datos para los Reportes por Asuntos Remitidos 
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param stridArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportePorAsuntosRemitidos(	String inicio, 
    														String fin, 
															String stridArea) 
	{	
		try
		{
			String strsql	=	SQLReportes.getReportePorAsuntosRemitidos(inicio, fin, stridArea);
			////System.out.println("getReportePorAsuntosRemitidos()"+strsql);
			String strResultados[][] = ConexionDS.ejecutarSQL(strsql);
			return strResultados;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportePorAsuntosRemitidos():"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Genera datos para los Reportes por Fecha de Captura
     * 
     * @param inicio limite inferior de la Fecha de Creacion del Asunto
     * @param fin limite superior de la Fecha de Creacion del Asunto
     * @param stridArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportePorFechaCaptura(String inicio, String fin, String stridArea) 
	{	
		try
		{
			String strsql	=	SQLReportes.getReportePorFechaCaptura(inicio, fin, stridArea);
			////System.out.println("getReportePorFechaCaptura():"+strsql);
			String strResultados[][] = ConexionDS.ejecutarSQL(strsql);
			return strResultados;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportePorFechaCaptura():"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Genera datos para los Reportes por Tiempos de Respuesta
     * 
     * @param strIdReporte Id del reporte
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReporteTiempos(String strIdReporte)
	{	
		try
		{
			String strsql	=	SQLReportes.getReporteTiempos(strIdReporte);
			////System.out.println("getReporteTiempos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReporteTiempos:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Regresa los datos de los Reportes por ID de UA, y los ordena por Orden y Tipo
     * 
     * @param strIdArea ID de la UA
     * @param strOrden Determina el campo por el cual se hará el ordenamiento
     * @param strTipo Ascendente o Descendente
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportesPorID(String strIdArea, String strOrden, String strTipo)
    {
        String SQL = 	"SELECT DISTINCT ID_REPORTE, REP_DESCRIPCION, TO_CHAR(REP_FECHA_CREACION, 'DD/MM/YYYY HH24:MI:SS'), REP_FECHA_CREACION " +
        				"FROM SD_REPORTES WHERE REP_TIPO_REPORTE=0 AND REP_ID_AREA="+strIdArea+" ORDER BY "+strTipo+" "+strOrden+", 1 ASC ";
        try
		{
			String strsql	=	SQL;
			////System.out.println("getReportesPorID:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportesPorID:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
    }
    
    /**
     * Regresa los datos de los Reportes de Remitentes por ID de UA, y los ordena por Orden y Tipo
     * 
     * @param strIdArea ID de la UA
     * @param strOrden Determina el campo por el cual se hará el ordenamiento
     * @param strTipo Ascendente o Descendente
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportesPorRemitente(String strIdArea, String strOrden, String strTipo)
    {
        String SQL = 	"SELECT DISTINCT ID_REPORTE, REP_DESCRIPCION, TO_CHAR(REP_FECHA_CREACION, 'DD/MM/YYYY HH24:MI:SS'), REP_FECHA_CREACION " +
        				"FROM SD_REPORTES WHERE REP_TIPO_REPORTE=1 AND REP_ID_AREA="+strIdArea+" ORDER BY "+strTipo+" "+strOrden+", 1 ASC ";
        try
		{
			String strsql	=	SQL;
			////System.out.println("getReportesPorRemitente:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportesPorRemitente:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
    }
    
    /**
     * Regresa los datos de los Reportes de Remitentes Internos por ID de UA, y los ordena por Orden y Tipo
     * 
     * @param strIdArea ID de la UA
     * @param strOrden Determina el campo por el cual se hará el ordenamiento
     * @param strTipo Ascendente o Descendente
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportesPorRemitenteI(String strIdArea, String strOrden, String strTipo)
    {
        String SQL = 	"SELECT DISTINCT ID_REPORTE, REP_DESCRIPCION, TO_CHAR(REP_FECHA_CREACION, 'DD/MM/YYYY HH24:MI:SS'), REP_FECHA_CREACION " +
        				"FROM SD_REPORTES WHERE REP_TIPO_REPORTE=15 AND REP_ID_AREA="+strIdArea+" ORDER BY "+strTipo+" "+strOrden+", 1 ASC ";
        try
		{
			String strsql	=	SQL;
			////System.out.println("getReportesPorRemitente:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportesPorRemitente:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
    }
    
    /**
     * Regresa los datos de los Reportes de Estatus por Unidad Administrativa, y los ordena por Orden y Tipo
     * 
     * @param strArea Unidad Administrativa 
     * @param strOrden Determina el campo por el cual se hará el ordenamiento
     * @param strTipo Ascendente o Descendente
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportesPorEstatus(String strOrden, String strTipo, String strArea)
    {
        String SQL = 	"SELECT DISTINCT ID_REPORTE, REP_DESCRIPCION, TO_CHAR(REP_FECHA_CREACION, 'DD/MM/YYYY HH24:MI:SS'), REP_FECHA_CREACION " +
        				"FROM SD_REPORTES WHERE REP_TIPO_REPORTE=2 AND REP_ID_AREA = "+strArea+" ORDER BY "+strTipo+" "+strOrden+", 1 ASC ";
        try
		{
			String strsql	=	SQL;
			////System.out.println("getReportesPorEstatus:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportesPorEstatus:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
    }
    
    /**
     * Regresa los datos de los Reportes de Fecha Limite
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportesPorFechaLim()
    {
        String SQL = 	"SELECT DISTINCT ID_REPORTE, REP_DESCRIPCION, TO_CHAR(REP_FECHA_CREACION, 'DD/MM/YYYY HH24:MI:SS') " +
        				"FROM SD_REPORTES WHERE REP_TIPO_REPORTE=3 ORDER BY 1";
        try
		{
			String strsql	=	SQL;
			////System.out.println("getReportesPorFechaLim:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportesPorFechaLim:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
    }
    
    /**
     * Regresa los datos de los Reportes de Tiempos de Respuesta por ID de UA, y los ordena por Orden y Tipo
     * 
     * @param strIdArea ID de la UA
     * @param strOrden Determina el campo por el cual se hará el ordenamiento
     * @param strTipo Ascendente o Descendente
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportesPorTiempos(String strIdArea, String strOrden, String strTipo) 
    {
        String SQL = 	"SELECT DISTINCT ID_REPORTE, REP_DESCRIPCION, TO_CHAR(REP_FECHA_CREACION, 'DD/MM/YYYY HH24:MI:SS'), REP_FECHA_CREACION " +
        				"FROM SD_REPORTES WHERE REP_TIPO_REPORTE=4 AND REP_ID_AREA="+strIdArea+" ORDER BY "+strTipo+" "+strOrden+", 1 ASC ";
        try
		{
			String strsql	=	SQL;
			////System.out.println("getReportesPorTiempos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportesPorTiempos:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
    }
    
    /**
     * Regresa los datos de los Reportes de Tipo de Asunto por ID de UA, y los ordena por Orden y Tipo
     * 
     * @param strIdArea ID de la UA
     * @param strOrden Determina el campo por el cual se hará el ordenamiento
     * @param strTipo Ascendente o Descendente
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportesPorTA(String strIdArea, String strOrden, String strTipo)
    {
        String SQL = 	"SELECT DISTINCT ID_REPORTE, REP_DESCRIPCION, TO_CHAR(REP_FECHA_CREACION, 'DD/MM/YYYY HH24:MI:SS'), REP_FECHA_CREACION " +
        				"FROM SD_REPORTES WHERE REP_TIPO_REPORTE=5 AND REP_ID_AREA="+strIdArea+" ORDER BY "+strTipo+" "+strOrden+", 1 ASC ";
        try
		{
			String strsql	=	SQL;
			////System.out.println("getReportesPorTA:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportesPorTA:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
    }
    
    /**
     * Regresa los datos de los Reportes de Destinatarios por ID de UA, y los ordena por Orden y Tipo
     * 
     * @param strIdArea ID de la UA 
     * @param strOrden Determina el campo por el cual se hará el ordenamiento
     * @param strTipo Ascendente o Descendente
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportesPorDestinatario(String strIdArea, String strOrden, String strTipo)
    {
        String SQL = 	"SELECT DISTINCT ID_REPORTE, REP_DESCRIPCION, TO_CHAR(REP_FECHA_CREACION, 'DD/MM/YYYY HH24:MI:SS'), REP_FECHA_CREACION " +
        				"FROM SD_REPORTES WHERE REP_TIPO_REPORTE=6 AND REP_ID_AREA="+strIdArea+" ORDER BY "+strTipo+" "+strOrden+", 1 ASC ";
        try
		{
			String strsql	=	SQL;
			////System.out.println("getReportesPorDestinatario:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportesPorDestinatario:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
    }
    
    /**
     * Regresa los datos de los Reportes de Asuntos Remitidos por ID de UA, y los ordena por Orden y Tipo
     * 
     * @param stridArea ID de la UA
     * @param strOrden Determina el campo por el cual se hará el ordenamiento
     * @param strTipo Ascendente o Descendente
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportesPorARemitidos(String stridArea, String strOrden, String strTipo)
    {
        String SQL = 	"SELECT DISTINCT ID_REPORTE, REP_DESCRIPCION, TO_CHAR(REP_FECHA_CREACION, 'DD/MM/YYYY HH24:MI:SS'), REP_FECHA_CREACION " +
        				"FROM SD_REPORTES WHERE REP_TIPO_REPORTE=7 " +
        				"AND REP_ID_AREA="+stridArea+" ORDER BY "+strTipo+" "+strOrden+", 1 ASC ";
        try
		{
			String strsql	=	SQL;
			////System.out.println("getReportesPorARemitidos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportesPorARemitidos:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
    }
    
    /**
     * Regresa los datos de los Reportes de Fecha de Captura por ID de UA, y los ordena por Orden y Tipo
     * 
     * @param strIdArea ID de la UA
     * @param strOrden Determina el campo por el cual se hará el ordenamiento
     * @param strTipo Ascendente o Descendente
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String[][] getReportesPorFechaCaptura(String strIdArea, String strOrden, String strTipo)
    {
        String SQL = 	"SELECT DISTINCT ID_REPORTE, REP_DESCRIPCION, TO_CHAR(REP_FECHA_CREACION, 'DD/MM/YYYY HH24:MI:SS'), REP_FECHA_CREACION " +
        				"FROM SD_REPORTES WHERE REP_TIPO_REPORTE=8 AND REP_ID_AREA="+strIdArea+" ORDER BY "+strTipo+" "+strOrden+", 1 ASC ";
        try
		{
			String strsql	=	SQL;
			////System.out.println("getReportesPorFechaCaptura:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getReportesPorFechaCaptura:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
    }
    
    
    /**
     * Verifica si existen Reportes de Tipo de Documento asociados a una UA
     * 
     * @param strIdArea ID de la UA
     * 
     * @return Regresa True si SI existen reportes y False si NO existen o si falló la consulta
     */
    public static boolean getExistenRTD(String strIdArea)   
	{
        String SQL = "SELECT * FROM SD_REPORTES WHERE REP_TIPO_REPORTE=0 AND REP_ID_AREA="+strIdArea;
		try
		{
			String strsql = SQL;
			////System.out.println("getExistenRTD:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			////System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenRTD:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Verifica si existen Reportes de Asuntos Remitidos asociados a una UA
     * 
     * @param strIdArea ID de la UA
     * 
     * @return Regresa True si SI existen reportes y False si NO existen o si falló la consulta
     */
    public static boolean getExistenRem(String strIdArea)
	{
        String SQL = "SELECT * FROM SD_REPORTES WHERE REP_TIPO_REPORTE=1 AND REP_ID_AREA="+strIdArea;
		try
		{
			String strsql = SQL;
			////System.out.println("getExistenRem:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			////System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenRem:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Verifica si existen Reportes de Remitentes Internos asociados a una UA
     * 
     * @param strIdArea ID de la UA
     * 
     * @return Regresa True si SI existen reportes y False si NO existen o si falló la consulta
     */
    public static boolean getExistenRemI(String strIdArea)
	{
        String SQL = "SELECT * FROM SD_REPORTES WHERE REP_TIPO_REPORTE=15 AND REP_ID_AREA="+strIdArea;
		try
		{
			String strsql = SQL;
			////System.out.println("getExistenRemI:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			////System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenRemI:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Verifica si existen Reportes de Estatus asociados a una UA
     * 
     * @return Regresa True si SI existen reportes y False si NO existen o si falló la consulta
     */
    public static boolean getExistenEstatus()
	{
        String SQL = "SELECT * FROM SD_REPORTES WHERE REP_TIPO_REPORTE=2";
		try
		{
			String strsql = SQL;
			////System.out.println("getExistenEstatus:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenEstatus:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Verifica si existen Reportes de Tiempo de Respuesta asociados a una UA
     * 
     * @return Regresa True si SI existen reportes y False si NO existen o si falló la consulta
     */
    public static boolean getExistenTiempoLim()
	{
        String SQL = "SELECT * FROM SD_REPORTES WHERE REP_TIPO_REPORTE=3";
		try
		{
			String strsql = SQL;
			////System.out.println("getExistenTiempoLim:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			////System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenTiempoLim:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Verifica si existen Reportes de Tiempo de Respuesta asociados a una UA
     * 
     * @param strIdArea ID de la UA
     * 
     * @return Regresa True si SI existen reportes y False si NO existen o si falló la consulta
     */
    public static boolean getExistenRTiempos(String strIdArea)
	{
        String SQL = "SELECT * FROM SD_REPORTES WHERE REP_TIPO_REPORTE=4 AND REP_ID_AREA="+strIdArea;
		try
		{
			String strsql = SQL;
			////System.out.println("getExistenRTiempos:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			////System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenRTiempos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Verifica si existen Reportes de Tipo de Asunto asociados a una UA
     * 
     * @param strIdArea ID de la UA
     * 
     * @return Regresa True si SI existen reportes y False si NO existen o si falló la consulta
     */
    public static boolean getExistenRTA(String strIdArea)
	{
        String SQL = "SELECT * FROM SD_REPORTES WHERE REP_TIPO_REPORTE=5 AND REP_ID_AREA="+strIdArea;
		try
		{
			String strsql = SQL;
			////System.out.println("getExistenRTA:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenRTA:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Verifica si existen Reportes de Destinatarios asociados a una UA
     * 
     * @param strIdArea ID de la UA
     * 
     * @return Regresa True si SI existen reportes y False si NO existen o si falló la consulta
     */
    public static boolean getExistenDes(String strIdArea)
	{
        String SQL = "SELECT * FROM SD_REPORTES WHERE REP_TIPO_REPORTE=6 AND REP_ID_AREA="+strIdArea;
		try
		{
			String strsql = SQL;
			////System.out.println("getExistenDes:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			////System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenDes:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Verifica si existen Reportes de Asuntos Remitidos asociados a una UA
     * 
     * @param strIdArea ID de la UA
     * 
     * @return Regresa True si SI existen reportes y False si NO existen o si falló la consulta
     */
    public static boolean getExistenRRemitido(String strIdArea)
	{
        String SQL = "SELECT * FROM SD_REPORTES WHERE REP_TIPO_REPORTE=7 AND REP_ID_AREA="+strIdArea;
		try
		{
			String strsql = SQL;
			////System.out.println("getExistenRRemitido:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenRRemitido:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Verifica si existen Reportes de Fecha de Recepción asociados a una UA
     * 
     * @param strIdArea ID de la UA
     * 
     * @return Regresa True si SI existen reportes y False si NO existen o si falló la consulta
     */
    public static boolean getExistenRPorFechaC(String strIdArea)
	{
        String SQL = "SELECT * FROM SD_REPORTES WHERE REP_TIPO_REPORTE=8 AND REP_ID_AREA="+strIdArea;
		try
		{
			String strsql = SQL;
			////System.out.println("getExistenRPorFechaC:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenRPorFechaC:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Genera datos para los Reportes por Fecha de Captura
     * 
     * @param strfecha Fecha de Creacion del Asunto
     * @param strIdArea ID de la UA a la que pertenece el reporte
     * 
     * @return Regresa un String[][] con los datos del reporte
     */
    public static String getAsuntoPorFechaCap(String strfecha, String strIdArea)
    {
        try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLReportes.getAsuntoPorFechaCap(strfecha, strIdArea));
			////System.out.println("getAsuntoPorFechaCap:"+SQLReportes.getAsuntoPorFechaCap(strfecha));
			if(strResult!=null && strResult.length>0)
			    return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntoPorFechaCap:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
	 * Borra los Reportes asiciadas a un arreglo de Id's
	 * 
	 * @param ids Arreglo de ID's de Instrucciones que se quieren borrar
	 * 
 	 * @return Regresa True si se pudieron eliminar las Instrucciones y False si hubo una problema
	 */
    public static boolean deleteReportes(String ids[]){
    	int r=0;
    	if(ids==null || ids.length<0)
			return false;
    	try
		{
    		for(int i=0;i<ids.length;i++){
    			String sql = SQLReportes.deleteReportes(ids[i]);
    			////System.out.println("deleteReportes="+sql);
    			r= ConexionDS.ejecutarActualizacion(sql);
    		}
		}catch(SQLException sqle){
			//System.out.println("deleteReportes:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r>0);
    }

}

