/*
 * Created on Sep 17, 2005
 */
package com.meve.sigma.taglib;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.*;

import java.sql.*;

/**
 * Utilerias para el llenado de combos
 * @author 	Meve Soluciones S.A. de C.V. *
 * @version	1.0
 */
public class ComboData {
    
    /**
     * Metodo que genera una consulta en DB2, para crear el combo de área
     * @return ConexionDS.ejecutarSQL(strsql)
     */
	public static String[][] getAreasCombo()
	{		
		try
		{			 
			String strsql = SQLArea.getAreaCombo();
			////System.out.println("getAreaCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreaCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	
	/**
	 * Obtiene una lista de Areas
	 * @return	 un array que contiene el listado de Areas
	 */
	public static String[][] getAreaComboListDes()
	{		
		try
		{			 
			String strsql = SQLArea.getAreaComboListDes();
			////System.out.println("getAreaComboListDes:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAreaComboListDes:"+sqle);
			sqle.printStackTrace();
			return null;		
		}
	}
	/**
	 * Obtiene un listado de areas
	 * @param idArea Id de area
	 * @return un array que contienen el listado de Areas
	 */
	public static String[][] getAreasCombo(String idArea)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getAreaCombo(idArea);
			////System.out.println("getAreasCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreasCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	
	
	
    /**
     * Metodo que genera una consulta en DB2, para crear el combo de área
     * @return ConexionDS.ejecutarSQL(strsql)
     */
	public static String[][] getAreasComboExp()
	{		
		try
		{			 
			String strsql = SQLExpArchivado.getAreaComboExp();
			////System.out.println("getAreaComboExp:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreaCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**********************************Cedula Combos****************************************************************/
    /**
     * Metodo que genera una consulta en DB2, para llenar el combos de Serie respectivos a una Unidad Admnistrativa
     * @return ConexionDS.ejecutarSQL(strsql)
     */
	public static String[][] getComboICDDSer(String idArea)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getComboICDDSer(idArea);
			////System.out.println("getComboICDDSer:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getComboICDDSer:");
				sqle.printStackTrace();
				return null;		
		}
	}
	
	
	
    /**
     * Metodo que genera una consulta en DB2,  para llenar el combos de SubSerie respectivos a una Unidad Admnistrativa
     * @return ConexionDS.ejecutarSQL(strsql)
     */
	public static String[][] getComboICDDSubSer(String idArea)
	{		
		try
		{			 
			String strsql = SQLExpArchivado.getComboICDDSubSer(idArea);
			////System.out.println("getComboICDDSubSer:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getComboICDDSubSer:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/************************************************************************************************************/
    /**
     * Metodo que genera una consulta en DB2, para llenar el combos de Areas por una Unidad Admnistrativa
     * @return ConexionDS.ejecutarSQL(strsql)
     */
	public static String[][] getAreasComboExp(String idArea)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getAreaComboExp(idArea); 
			////System.out.println("getAreaComboExp:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreaComboExp:");
				sqle.printStackTrace();
				return null;		
		}
	}
	
	
	
	
	
	
	
	/**
	 * Clase que genera una consulta en DB2, para crear el combo de Entidad
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getEntidadCombo()
	{		
		try
		{			 
			String strsql = SQLEntidad.getEntidadCombo();
			////System.out.println("getEntidadCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEntidadCombo:");
			sqle.printStackTrace();
			return null;		
		}
	}
	
	/**
	 * Ejecuta una consulta para crear un combo con la lista de entidades
	 * @return un arreglo con las entidades
	 */
	public static String[][] getEntidadCombo1()
	{		
		try
		{			 
			String strsql = SQLEntidad.getEntidadCombo1();
			////System.out.println("getEntidadCombo1:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEntidadCombo1:");
			sqle.printStackTrace();
			return null;		
		}
	}
	/**
	 * Ejecuta una consulta para crear un combo con la lista de entidades por área
	 * @param strIdArea id área
	 * @return un arreglo con las entidades
	 */
	public static String[][] getEntidadAreaCombo(String strIdArea)
	{		
		try
		{			 
			String strsql = SQLEntidad.getEntidadCombo(strIdArea);
			////System.out.println("getEntidadAreaCombo:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEntidadAreaCombo:");
			sqle.printStackTrace();
			return null;		
		}
	}
	/**
	 * Ejecuta una consulta para crear un combo con la lista de remitentes
	 * @return un arreglo con las remitentes
	 */
	public static String [][] getRemitenteCombo()
	{
	    try
	    {
	        String strsql = SQLRemitente.getRemitenteCombo();
	        // //System.out.println("getRemitenteCombo:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getRemitenteCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	/**
	 * Ejecuta una consulta para crear un combo con la lista de remitentes por área
	 * @param strIdArea id área
	 * @return un arreglo con las remitentes
	 */
	public static String [][] getRemitenteAreaCombo(String strIdArea)
	{
	    try
	    {
	        String strsql = SQLRemitente.getRemitenteAreaCombo(strIdArea);
	        ////System.out.println("getRemitenteCombo:"+strsql);
	        String rem[][] = ConexionDS.ejecutarSQL(strsql);
			for(int i=0;i<rem.length;i++){
			    rem[i][0] = rem[i][0] +"|"+ rem[i][2] +"$"+ rem[i][3];
			    rem[i][1] = rem[i][1];
			    ////System.out.println("rem[i][0]"+rem[i][0]);
			    ////System.out.println("rem[i][1]"+rem[i][1]);
			}
			return rem;
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getRemitenteCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Ejecuta una consulta para crear un combo con la lista de tipos de documento
	 * @return un arreglo con los tipos de documento
	 */
	public static String [][] getTipoDoctoCombo()
	{
	    try
	    {
	        String strsql = SQLTipo_Doc.getTipoDoctoCombo();
	        ////System.out.println("getTipoDoctoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getTipoDoctoCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Ejecuta una consulta para crear un combo con la lista de tipos de documento
	 * @param strIdArea id área
	 * @return un arreglo con los tipos de documento
	 */
	public static String [][] getTipoDoctoCombo(String strIdArea)
	{
	    try
	    {
	        String strsql = SQLTipo_Doc.getTipoDoctoCombo(strIdArea);
	        ////System.out.println("getTipoDoctoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getTipoDoctoCombo:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Ejecuta una consulta para crear un combo con la lista de tipos de documento por área
	 * @param strIdArea id área
	 * @return un arreglo con los tipos de documento
	 */
	public static String [][] getTipoDoctoAreaCombo(String strIdArea)
	{
	    try
	    {
	        String strsql = SQLTipo_Doc.getTipoDoctoCombo(strIdArea);
	        ////System.out.println("getTipoDoctoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getTipoDoctoCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Ejecuta una consulta para crear un combo con la lista de tipos de documento generales
	 * @return un arreglo con los tipos de documento
	 */
	public static String [][] getTipoDoctosGralesCombo()
	{
	    try
	    {
	        String strsql = SQLTipo_Doc.getTipoDoctosGralesCombo();
	        ////System.out.println("getTipoDoctosGralesCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getTipoDoctosGralesCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Ejecuta una consulta para crear un combo con la lista de prioridades
	 * @return un arreglo con los tipos de prioridades
	 */
	public static String [][] getPrioridadCombo()
	{
	    try
	    {
	        String strsql = SQLPrioridad.getPrioridadCombo();
	        ////System.out.println("getPrioridadCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getPrioridadCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Ejecuta una consulta para crear un combo con la lista de prioridades por área
	 * @param strIdArea id area
	 * @return un arreglo con los tipos de prioridades
	 */
	public static String [][] getPrioridadAreaCombo(String strIdArea)
	{
	    try
	    {
	        String strsql = SQLPrioridad.getPrioridadCombo(strIdArea);
	        ////System.out.println("getPrioridadCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getPrioridadCombo:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	/**
	 * Ejecuta una consulta para crear un combo con la lista de prioridades generales por área
	 * @return un arreglo con los tipos de prioridades
	 */
	public static String [][] getPrioridadAreaComboGral()
	{
	    try
	    {
	        String strsql = SQLPrioridad.getPrioridadComboGral();
	        ////System.out.println("getPrioridadComboGral:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getPrioridadComboGral:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Ejecuta una consulta para crear un combo con la lista de usuarios
	 * @return un arreglo con los tipos de usuarios
	 */
	public static String [][] getUsuarioCombo()
	{
	    //String strOrganizacion	=	"TecnoAplicada";
	    try
	    {
	        String strsql = SQLUsuario.getUsuariosCombo();
	        // //System.out.println("getUsuarioCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getUsuarioCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Ejecuta una consulta para crear un combo con la lista de usuarios por área
	 * @param strIdArea
	 * @return un arreglo con los tipos de usuarios
	 */
	public static String [][] getUsuarioCombo(String strIdArea)
	{
	    //String strOrganizacion	=	"TecnoAplicada";
	    try
	    {
	        String strsql = SQLUsuario.getUsuariosCombo(strIdArea);
	        // //System.out.println("getUsuarioCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getUsuarioCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Lista combo con los expedientes disponibles por Unidad Administrativa
	 * @param strExpediente Número de expediente
	 * @return lista de expedientes disponibles
	 */
	public static String [][] getExpedienteCombo(String strExpediente)
	{
	    try
	    {
	        String strsql = SQLExpediente.getExpedienteCombo(strExpediente);
	        //  //System.out.println("getExpedienteCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getExpedienteCombo:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Lista combo con los expedientes disponibles 
	 * @return lista de expedientes disponibles
	 */
	public static String [][] getExpedienteComboGral()
	{
	    try
	    {
	        String strsql = SQLExpediente.getExpedienteComboGral();
	        // //System.out.println("getExpedienteComboGral:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getExpedienteComboGral:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que ejecuta un query para mostrar los datos en el combo en
	 * Ubicaciones por Unidad Administrativa
	 * @param strUbicacion Ubicación 
	 * @return una lista de ubicaciones de las Unidad Administrativa
	 */
	public static String [][] getUbicacionCombo(String strUbicacion)
	{
	    try
	    {
	        String strsql = SQLUbicacion.getUbicacionCombo(strUbicacion);
	        //  //System.out.println("getUbicacionCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getUbicacionCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que ejecuta un query para mostrar los datos en el combo en Ubicaciones
	 * @return un lista de las ubicaciones
	 */
	public static String [][] getUbicacionCombo()
	{
	    try
	    {
	        String strsql = SQLUbicacion.getUbicacionCombo();
	        // //System.out.println("getUbicacionCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getUbicacionCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que ejecuta una consulta para mostrar el combo de tipos de asunto
	 * @return un lista con los tipos de asunto
	 */
	public static String [][] getTipoAsuntoCombo()
	{
	    try
	    {
	        String strsql = SQLTipoAsunto.getTipoAsuntoCombo();
	        // //System.out.println("getTipoAsuntoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getTipoDoctoCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	/**
	 * Función que ejecuta una consulta para mostrar el combo de tipos de asunto
	 * @param strIdArea Id de área
	 * @return un lista con los tipos de asunto
	 */
	public static String [][] getTipoAsuntoCombo(String strIdArea)
	{
	    try
	    {
	        String strsql = SQLTipoAsunto.getTipoAsuntoCombo(strIdArea);
	        //  //System.out.println("getTipoAsuntoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getTipoDoctoCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	/**
	 * Función que ejecuta una consulta para mostrar el combo de tipos de asunto por area
	 * @param strIdArea Id de área
	 * @return un lista con los tipos de asunto
	 */
	public static String [][] getTipoAsuntoAreaCombo(String strIdArea)
	{
	    try
	    {
	        String strsql = SQLTipoAsunto.getTipoAsuntoCombo(strIdArea);
	        // //System.out.println("getTipoAsuntoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getTipoDoctoCombo:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	/**
	 * Función que ejecuta una consulta para mostrar el combo de tipos de asunto
	 * @return un lista con los tipos de asunto
	 */
	public static String [][] getTipoAsuntoAreaComboGral()
	{
	    try
	    {
	        String strsql = SQLTipoAsunto.getTipoAsuntoComboGral();
	        // //System.out.println("getTipoAsuntoComboGral:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getTipoDoctoComboGral:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que ejecuta una consulta para mostrar el combo de  tipo de flujo
	 * @return un lista con los tipos de asunto
	 */
	public static String [][] getFlujoCombo()
	{
	    try
	    {
	        String strsql = SQLFlujo.getFlujoCombo();
	        // //System.out.println("getFlujoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getFlujoCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	/**
	 * Función que ejecuta una consulta para mostrar el combo de tipo de flujo
	 * @param strIdDocto Id del documento
	 * @return un lista con los tipos de asunto
	 */
	public static String [][] getFlujoAreaCombo(String strIdDocto)
	{
	    try
	    {
	        String strsql = SQLFlujo.getFlujoAreaCombo(strIdDocto);
	        // //System.out.println("getFlujoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getFlujoCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que ejecuta una consulta para mostrar el combo de Clasificación de un asunto por area
	 * @return un lista con los tipos de Clasificación
	 */
	public static String [][] getClasificacionAreaCombo()
	{
	    try
	    {
	        String strsql = SQLClasificacion.getClasificacionCombo();
	        // //System.out.println("getClasificacionAreaCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getClasificacionAreaCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que manda a ejecutar un query, para la construcción
	 * de un combo de los catalogos de subfondo
	 * @return String[][]
	 */
	public static String [][] getSubFondoCombo()
	{
	    try
	    {
	        String strsql = SQLSubfondo.getSubfondoCombo();
	        // //System.out.println("getSubFondoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getSubFondoCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que manda a ejecutar un query, para la construcción
	 * de un combo de los catalogos de Sección
	 * @return lista con catalogos de Sección
	 */
	public static String [][] getSeccionCombo(String idSubfondo)
	{
	    try
	    {
	        String strsql = SQLSeccion.getSeccionCombo(idSubfondo);
	        // //System.out.println("getSeccionCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getSeccionCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	/**
	 * Lista Todas la secciones
	 * @return lista con todas las secciones
	 */
	
	public static String [][] getSeccionCombo()
	{
	    try
	    {
	        String strsql = SQLSeccion.getSeccionCombo();
	        // //System.out.println("getSeccionCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getSeccionCombo:");
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que manda a ejecutar una consulta  para el tipo de respuesta, Portal Ciudadano
	 * @return lista con los tipos de respuesta
	 */
	public static String[][] getTipoRespuestaCombo()
	{		
		try
		{			 
			String strsql = SQLTipoRespuesta.getTipoRespuestaCombo();
			////System.out.println("getTipoRespuestaCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getTipoRespuestaCombo:"+sqle);
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
	 * Función que manda a ejecutar una consulta para el estatus de Portal Ciudadano
	 * @return lista con los estatus del portal
	 */
	public static String[][] getEstatusCombo()
	{		
		try
		{			 
			String strsql = SQLEstatus.getEstatusCombo();
			// //System.out.println("getEstatusCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getEstatusCombo:"+sqle);
				sqle.printStackTrace();
				return null;		
		}
	}
	
	
	/**
	 * Función que manda a ejecutar una consulta para obtener los ciudadanos registrados en Portal Ciudadano
	 * @return lista de los ciudadanos registrados
	 */
	public static String[][] getCiudadanoCombo()
	{		
		try
		{			 
			String strsql = SQLCiudadano.getComboCiudadano();
			////System.out.println("getCiudadanoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getCiudadanoCombo:"+sqle);
				sqle.printStackTrace();
				return null;		
		}
	}
	
	/**
	 * Función que manda a ejecutar una consulta para obtener usuarios asistente
	 * @param strIdArea Id del área
	 * @return lista de usuarios
	 */
	public static String [][] getUsuarioAsistente(String strIdArea)
	{
	    try
	    {
	        String strsql = SQLUsuario.getComboAsistente(strIdArea);
	        ////System.out.println("getComboAsistente:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getComboAsistente:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que manda a ejecutar una consulta para obtener usuarios asistente
	 * @return  lista de usuarios
	 */
	public static String [][] getUsuarioAsistente()
	{
	    //String strOrganizacion	=	"TecnoAplicada";
	    try
	    {
	        String strsql = SQLUsuario.getComboAsistente();
	        ////System.out.println("getUsuarioAsistente:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getUsuarioAsistente:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que ejecuta un query con la lista de usuarios que dependen de 
	 * un puesto o por jerarquía
	 * @param strIdArea id del área
	 * @return lista de usuarios de un puesto o jerarquía
	 */
	public static String [][] getUsuariosJerarquia(String strIdArea)
	{
	    try
	    {
	        String strsql = SQLUsuario.getUsuariosJerarquia(strIdArea);
	        // //System.out.println("getUsuariosJerarquia:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getUsuariosJerarquia:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que manda a ejecutar una consulta para obtener usuarios responsable
	 * @param strIdArea id del área
	 * @return  lista de usuarios
	 */
	public static String [][] getUsuarioResponsable(String strIdArea)
	{
	    try
	    {
	        String strsql = SQLUsuario.getUsuarioResponsable(strIdArea);
	        ////System.out.println("getUsuarioResponsable:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getUsuarioResponsable:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	/**
	 * Función que manda a ejecutar una consulta para obtener usuarios Jefe
	 * @param strIdJefe id de usuario
	 * @return  lista de usuarios
	 */
	public static String [][] getJefePuesto(String strIdJefe)
	{
	    try
	    {
	        String strsql = SQLUsuario.getPuestoJefe(strIdJefe);
	        //  //System.out.println("getPuestoJefe:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getPuestoJefe:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	
	/**
	 * Función que manda a ejecutar una consulta para obtener Lista Todos los Subfondos
	 * @param id id de subfondo
	 * @return lista de subfondos
	 */
	public static String[][] getSubFondosCombo(String id)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getFondoCombo(id);
			////System.out.println("getFondoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreasCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
	 * Función que manda a ejecutar una consulta para obtener Lista los Fondos diponibles
	 * @return lista de fondos
	 */
	public static String[][] getSubFondosCombo()
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getFondoCombo();
			////System.out.println("getFondoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreasCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}

	/**
	 * Función que manda a ejecutar una consulta para obtener Lista Subfondos diponibles por Fondo
	 * @param id id de fondo
	 * @return lista de subfondos
	 */
	public static String[][] getSubFondoC(String id)
	{
	    try
		{			  
			String strsql = SQLExpArchivado.getSubFondoC(id);
			////System.out.println("getFondoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getFondoCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
	 * Función que manda a ejecutar una consulta para obtener Lista Combinaciones diponibles 
	 * @return  Lista Combinaciones diponibles 
	 */
	public static String[][] getCombinacionCombo()
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getCombinacionCombo();
			////System.out.println("getCombinacionCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getCombinacionCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
	 * Lista las valoraciones disponibles para una serie o subserie
	 *  
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getValorCombo()
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getValorCombo();
			////System.out.println("getValorCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getValorCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
	 * Lista las valoraciones disponibles para una serie o subserie
	 * @param a serie, subserie
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getValorComboSub(String a)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getValorComboSub(a);
			return ConexionDS.ejecutarSQL(strsql); 
		}
		catch(SQLException sqle)
		{
				//System.out.println("getValorCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
	 * Lista todas la selecciones diponibles
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getSeleccionCombo()
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getSeleccionCombo();
			////System.out.println("getSeleccionCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getSeleccionCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
	 * Lista todas la series disponibles
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getSerieComboA()
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getSerieComboA();
			////System.out.println("getSerieComboA:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getSerieComboA:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
	 * Lista todas la Unidades Administrativas disponibles
     * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getAreasComboarch()
	{		
		try
		{			 
			String strsql = SQLExpArchivado.getAreaCombo();
			////System.out.println("getAreaCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreaCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	
	/**
	 * Lista las areas diponibles por Indetificador filtrado
	 * @param idArea id del area
     * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getAreasComboArch(String idArea)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getAreaCombo(idArea);
			////System.out.println("getAreasCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreasCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
	 * Lista subserie diponibles en base a un expediente
	 * @param Id de subserie
     * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getSerieComboC(String Id)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getSerieComboC(Id);
			////System.out.println("getSerieComboC:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getSerieComboC:");
				sqle.printStackTrace();
				return null;		
		}
	}

	/**
	 * Lista secciones diponibles
     * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getSeccionComboA()
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getSeccionComboA();
			////System.out.println("getSerieComboA:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getSerieComboA:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
     * Lista secciones diponibles para un Fondo y un Subfondo
     * @param strfondo fondo
     * @param strSubfondo subfondo
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getSeccionComboInst(String strfondo,String strSubfondo)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getSeccionComboInst(strfondo,strSubfondo);
			////System.out.println("getSeccionComboInst:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getSeccionComboInst:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
     * Lista las series disponibles 
     * @param id Identificador unico de la serie
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getSerieCombo(String id)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getSerieCombo(id);
			////System.out.println("getFondoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreasCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
     * Lista las series disponibles 
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getSerieCombo()
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getSerieCombo();
			////System.out.println("getFondoCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreasCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
     * Método que genera una consulta, para crear el combo de series disponibles para una cedula tipo
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getCalsifCombo(String id)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getClasifCombo(id);
			////System.out.println("getCalsifCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getCalsifCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
     * Método que genera una consulta, para crear el combo de Cédulas tipo  disponibles
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getCedCombo(String id)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getCedCombo(id);
			////System.out.println("getCedCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getCedCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
     * Método que genera una consulta, para crear el combo de ubicaciones fisicas disponibles
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getComboUbi(String ubi)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getComboUbi(ubi);
			////System.out.println("getComboUbi:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getComboUbi:");
				sqle.printStackTrace();
				return null;		
		}
	}		
	/**
     * Método que genera una consulta, para crear el combo de  clasificaciones de expedientes disponibles
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getClasifInfCombo()
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getClasifInfCombo();
			////System.out.println("getCedCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getCedCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
     * Método que genera una consulta, para crear el combo de fondos disponibles
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getFondoC()
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getFondoC();
			////System.out.println("getFondoC:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getFondoC:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
     * Método que genera una consulta, para crear el combo de Series disponibles
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getSerieComboP(String idSec)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getSerieComboP(idSec);
			////System.out.println("getSerieComboP:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getSerieComboP:");
				sqle.printStackTrace();
				return null;		
		}
	}
    /**
     * Traer consulta del combo de expedientes
     * @return ConexionDS.ejecutarSQL(strsql)
     */
	public static String[][] getConsultaExpCombo()
	{		
		try
		{			 
			String strsql = SQLExpArchivado.getConsulExpCombo();
			////System.out.println("getConsultaExpCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getConsultaExpCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}	
	/**
     * Método que genera una consulta, para crear el combo de expedientes disponibles
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getConsultaExpCombo(String idArea)
	{
	    try
		{			 
			String strsql = SQLExpArchivado.getConsulExpCombo(idArea);
			////System.out.println("getConsulExpCombo:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getConsulExpCombo:");
				sqle.printStackTrace();
				return null;		
		}
	}
	/**
     * Método que genera una consulta, para crear el combo de Entidades por Area
     * @return ConexionDS.ejecutarSQL(strsql)
     */	
	public static String[][] getEntidadComboXArea(String idArea)
	{		
		try
		{			 
			String strsql = SQLEntidad.getEntidadComboXArea(idArea);
			////System.out.println("getEntidadComboXArea:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEntidadComboXArea:");
			sqle.printStackTrace();
			return null;		
		}
	}
	
	/**
	 * Verifica si existen dependencia puesto-jefe
	 * @param strIdJefe id Jefe
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String [][] getDependencia(String strIdJefe)
	{
	    try
	    {	
	    	////System.out.println("strIdJefestrIdJefestrIdJefe"  +strIdJefe);
		    String strsql = SQLUsuario.getDependencia(strIdJefe);
		    // //System.out.println("getPuestoJefe:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
	    }
	    catch(SQLException sqle)
	    {
	        //System.out.println("getPuestoJefe:"+sqle);
			sqle.printStackTrace();
			return null;
	    }
	}
	/**
     * Método que genera una consulta, para crear el combo de área Excluyentes
     * @return ConexionDS.ejecutarSQL(strsql)
     */
	public static String[][] getAreaComboExcluyeId(String strIdArea)
	{		
		try
		{			 
			String strsql = SQLArea.getAreaComboExcluyeId(strIdArea);
			////System.out.println("getAreaComboExcluyeId:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getAreaComboExcluyeId:");
				sqle.printStackTrace();
				return null;		
		}
	}
	
	/**
     * Método que genera una consulta, para crear el combo de área
     * @return ConexionDS.ejecutarSQL(strsql)
     */
	public static String[][] getAreasComboAll()
	{		
		try
		{			 
			String strsql = SQLArea.getAreaComboAll();
			////System.out.println("getAreasComboAll:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAreasComboAll:");
			sqle.printStackTrace();
			return null;		
		}
	}
	
	/**
	 * Método que genera una consulta, para crear el combo de áreas Externas
	 * @return ConexionDS.ejecutarSQL(strsql)
	 */
	public static String[][] getAreaComboExternas()
	{		
		try
		{			 
			String strsql = SQLArea.getAreaComboExternas();
			////System.out.println("getAreaComboExternas:"+strsql); 
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAreaComboExternas:");
			sqle.printStackTrace();
			return null;		
		}
	}
	
}