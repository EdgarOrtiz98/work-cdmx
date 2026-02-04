/*
 * Clase:						ActualizaBuscar.java
 * 
 * Paquete:						com.meve.sigma.beans.search		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Nov 17, 2005
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

package com.meve.sigma.beans.search;

import java.sql.SQLException;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLBuscar;

/**
 * Clase para Insertar, Borrar y Editar Busquedas
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaBuscar {
    
    /**
     * Regresa todos los Asuntos capturados entre ciertas fechas 
     * 
     * @param fechaInicio Fecha de Inicio de la Fecha de captura
     * @param fechaFin Fecha de Final de la Fecha de captura
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getConsultaCiudadano(String fechaInicio, String fechaFin)
	{	
		try
		{
			String strsql= SQLBuscar.getConsultaCiudadano(fechaInicio, fechaFin);
			//System.out.println("getConsultaCiudadano:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getConsultaCiudadano:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos Ciudadanos entre Fecha Inicial y Fecha Final.
     * 
     * @param strFechaInicio Fecha de Inicio de la Fecha de captura
     * @param strFechaFin Fecha de Final de la Fecha de captura
     * @param strTipoResp Tipo de Respuesta
     * @param strArea Unidad Administrativa
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getConsultaCiudadanoTerminados(String strFechaInicio, String strFechaFin, 
    														String strTipoResp, String strArea)
	{	
		try
		{
			String strsql= SQLBuscar.getConsultaCiudadanoTerminados(strFechaInicio, strFechaFin, strTipoResp, strArea);
			//System.out.println("getConsultaCiudadanoTerminados:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getConsultaCiudadanoTerminados:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa la Unidade Administrativa las Instrucciones Asociadas a un Asunto 
     * 
     * @param strIdAsunto ID del Asunto
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getAreasAtencion(String strIdAsunto)
	{	
		try
		{
			String strsql= SQLBuscar.getAreasAtencion(strIdAsunto);
			//System.out.println("getAreasAtencion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAreasAtencion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}

    /**
     * Regresa la Unidade Administrativa las Instrucciones Asociadas a un Asunto y que sean Ejecutoras 
     * 
     * @param strIdAsunto ID del Asunto
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getAreasAtencionEjecutora(String strIdAsunto)
	{	
		try
		{
			String strsql= SQLBuscar.getAreasAtencionEjecutoras(strIdAsunto);
			//System.out.println("getAreasAtencionEjecutora:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAreasAtencionEjecutora:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa la Unidade Administrativa las Instrucciones Asociadas a un Asunto y que sean Informativa 
     * 
     * @param strIdAsunto ID del Asunto
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getAreasAtencionInformativa(String strIdAsunto)
	{	
		try
		{
			String strsql= SQLBuscar.getAreasAtencionInformativas(strIdAsunto);
			//System.out.println("getAreasAtencionInformativa:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAreasAtencionInformativa:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    

    /**
     * Regresa los Asuntos entre las Fechas de captura Inical y Final 
     * 
     * @param fechaInicio Fecha de captura Inicial
     * @param fechaFin Fecha de captura Final
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getEntreFechasA(String fechaInicio, String fechaFin)
	{	
		try
		{
			String strsql= SQLBuscar.getEntreFechasA(fechaInicio, fechaFin);
			//System.out.println("getEntreFechasA:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEntreFechasA:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos entre las Fechas de captura Inical y Final 
     * 
     * @param fechaInicio Fecha de captura Inicial
     * @param fechaFin Fecha de captura Final
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getEntreFechasI(String fechaInicio, String fechaFin)
	{	
		try
		{
			String strsql= SQLBuscar.getEntreFechasI(fechaInicio, fechaFin);
			//System.out.println("getEntreFechasI:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEntreFechasI:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos que contengan en su descripcion el String campo
     * 
     * @param campo Descripcion del Asunto
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedasAsunto(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedasAsunto(campo);
			//System.out.println("getBusquedasAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedasAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa las Instrucciones que contengan en su descripcion el String campo
     * 
     * @param campo Descripcion de la instrucción
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedasInstruccion(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedasInstruccion(campo);
			//System.out.println("getBusquedasInstrucciones:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedasInstrucciones:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos que contengan en su Folio el String campo
     * 
     * @param campo Folio del Asunto
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaPorFolioA(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedaPorFolioA(campo);
			//System.out.println("getBusquedaPorFolioA:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaPorFolioA:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa las Instrucciones que contengan en su Folio el String campo
     * 
     * @param campo Folio de la instrucción
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaPorFolioI(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedaPorFolioI(campo);
			//System.out.println("getBusquedaPorFolioI:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaPorFolioI:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos por Remitente
     * 
     * @param campo Remitente
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaPorSolicitanteA(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedaPorSolicitanteA(campo);
			//System.out.println("getBusquedaPorSolicitanteA:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaPorSolicitanteA:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa las Instrucciones por Solicitante
     * 
     * @param campo Solicitnate 
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaPorSolicitanteI(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedaPorSolicitanteI(campo);
			//System.out.println("getBusquedaPorSolicitanteI:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaPorSolicitanteI:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos por Nombre de la Unidad Administrativa
     * 
     * @param campo Unidad Administrativa
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaPorAreaA(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedaPorAreaA(campo);
			//System.out.println("getBusquedaPorAreaA:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaPorAreaA:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa las Instrucciones por Nombre de la Unidad Administrativa
     * 
     * @param campo Unidad Administrativa 
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaPorAreaI(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedaPorAreaI(campo);
			//System.out.println("getBusquedaPorAreaI:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaPorAreaI:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos por Fecha de Captura
     * 
     * @param campo Fecha de Captura
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaPorFechaA(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedaPorFechaA(campo);
			//System.out.println("getBusquedaPorFechaA:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaPorFechaA:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}

    /**
     * Regresa las Instrucciones por Fecha de Captura
     * 
     * @param campo Fecha de Captura
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaPorFechaI(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedaPorFechaI(campo);
			//System.out.println("getBusquedaPorFechaI:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaPorFechaI:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos resultado de la busqueda multicriterio
     * 
     * @param BeanBuscar Bean de datos de la busqueda
     * @param strOrden Campo por el cual se ordenará la busqueda
     * @param strTipo Ordenamiento Ascendente o Descendente
     * @param strIdUsuario Usuario que realiza la busqueda
     * @param strIdArea UA del usuario que realiza la busqueda
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBuscarMultiCampoAsunto(
    		BuscarCampo BeanBuscar,
    		String strOrden,
    		String strTipo, 
			String strIdUsuario,  
			String strIdArea, 
			String busquedaContent){	
		try {
			String strsql= SQLBuscar.getBuscarMultiCampoAsunto(
					BeanBuscar,
					strOrden, strTipo,
					strIdUsuario, strIdArea,
					busquedaContent);
			
			System.out.println("getBuscarMultiCampoAsunto:"+strsql);//Mike
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBuscarMultiCampoAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa las Instrucciones resultado de la busqueda multicriterio
     * 
     * @param BeanBuscar Bean de datos de la busqueda
     * @param strOrden Campo por el cual se ordenará la busqueda
     * @param strTipo Ordenamiento Ascendente o Descendente
     * @param strIdUsuario Usuario que realiza la busqueda
     * @param strIdArea UA del usuario que realiza la busqueda
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBuscarMultiCampoInstruccion(
    		BuscarCampoIns BeanBuscar,
    		String strOrden,
			String strTipo,
			String strIdUsuario, 
    		String strIdArea, 
			String busquedaContent){	
		try {
			String strsql= SQLBuscar.getBuscarMultiCampoInstruccion(
					BeanBuscar,
					strOrden,
					strTipo,
					strIdUsuario,
					strIdArea,
					busquedaContent);
			
			//System.out.println("getBuscarMultiCampoInstruccion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBuscarMultiCampoInstruccion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos por su Descripción
     * 
     * @param strAsunto Descripcion del Asunto
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] busquedaAsunto(String strAsunto, String strPP)
	{	
		try
		{
			String strsql= SQLBuscar.busquedaAsunto(strAsunto, strPP);
			//System.out.println("busquedaAsunto:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("busquedaAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos resultado de una busqueda por Folio, Asunto, UA, Tipo de Documento,
     * Fecha inicial de Captura y Fecha final de Captura 
     * 
     * @param strFolio Folio del Asunto
     * @param strArea Unidad Administrativa
     * @param strAsunto Descripcion del Asunto
     * @param strDocto Tipo de Documento 
     * @param strFinicio Fecha inicial de Captura
     * @param strFfin Fecha final de Captura
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] buscarPorAsunto(String strFolio, 
            								String strArea, String strAsunto,
            								String strDocto, String strFinicio,
            								String strFfin){
        
        String strDatos[][] = null;
        try
		{
			String strsql= SQLBuscar.buscarPorAsunto(strFolio, strArea, 
			        								strAsunto, strDocto, 
			        								strFinicio, strFfin);
			//System.out.println("buscarPorAsunto:"+strsql);
			if(strsql.length()>0 && strsql !=null)
				strDatos = ConexionDS.ejecutarSQL(strsql);
			else
			    strDatos = new String[0][0];
		}
		catch(SQLException sqle)
		{
			//System.out.println("buscarPorAsunto:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	    return strDatos;
    }
    
    /**
     * Regresa los Asuntos referenciados por Folio de recepcion
     * 
     * @param campo Folio del Recepción
     * @param stridArea Unidad Administrativa
     * @param strIdAsunto Id del Asunto Actual
     * @param idBusqueda Lista de Id de Asuntos que no se deben de incluir en la busqueda
     * @param strIdUsuario Usuario que realiza la busqueda
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaAsuntAnt(String campo, String stridArea, String strIdAsunto, String idBusqueda, String strIdUsuario)
	{	
		try
		{
			String strsql= SQLBuscar.getAsuntosAnt(campo, stridArea, strIdAsunto, idBusqueda, strIdUsuario);
			//System.out.println("getAsuntosAnt:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntosAnt:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa las Instrucciones-Asuntos referenciados por Folio de recepcion
     * 
     * @param campo Folio del Recepción
     * @param stridArea Unidad Administrativa
     * @param idBusqueda Lista de Id de Asuntos que no se deben de incluir en la busqueda
     * @param strIdUsuario Usuario que realiza la busqueda
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaAsuntAntIns(String campo, String strIdArea, String idBusqueda, String strIdUsuario)
	{	
		try
		{
			String strsql= SQLBuscar.getAsuntosAntIns(campo, strIdArea, idBusqueda, strIdUsuario);
			//System.out.println("getBusquedaAsuntAntIns:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaAsuntAntIns:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
	
    /**
     * Regresa los Asuntos referenciados por Descripción del Asunto
     * 
     * @param campo Descripción del Asunto
     * @param stridArea Unidad Administrativa
     * @param strIdAsunto Id del Asunto Actual
     * @param idBusqueda Lista de Id de Asuntos que no se deben de incluir en la busqueda
     * @param strIdUsuario Usuario que realiza la busqueda
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaAsuntAntD(String campo, String stridArea, String strIdAsunto, String idBusqueda, String strIdUsuario)
	{	
		try
		{
			String strsql= SQLBuscar.getAsuntosAntD(campo, stridArea, strIdAsunto, idBusqueda, strIdUsuario);
			//System.out.println("getBusquedaAsuntAntD:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaAsuntAntD:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa las Instrucciones-Asuntos referenciados por Descripción del Asunto
     * 
     * @param campo Descripción del Asunto
     * @param stridArea Unidad Administrativa
     * @param idBusqueda Lista de Id de Asuntos que no se deben de incluir en la busqueda
     * @param strIdUsuario Usuario que realiza la busqueda
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaAsuntAntDIns(String campo, String strIdArea, String idBusqueda, String strIdUsuario)
	{	
		try
		{
			String strsql= SQLBuscar.getAsuntosAntDIns(campo, strIdArea, idBusqueda, strIdUsuario);
			//System.out.println("getBusquedaAsuntAntDIns:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaAsuntAntDIns:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos referenciados por Identificacior del Documento
     * 
     * @param campo Descripción del Asunto
     * @param stridArea Unidad Administrativa
     * @param strIdAsunto Id del Asunto Actual
     * @param idBusqueda Lista de Id de Asuntos que no se deben de incluir en la busqueda
     * @param strIdUsuario Usuario que realiza la busqueda
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaAsuntAntIdDoc(String campo, String stridArea, String strIdAsunto, String idBusqueda, String strIdUsuario)
	{	
		try
		{
			String strsql= SQLBuscar.getBusquedaAsuntAntIdDoc(campo, stridArea, strIdAsunto, idBusqueda, strIdUsuario);
			//System.out.println("getBusquedaAsuntAntIdDoc:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getBusquedaAsuntAntD:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa las Instrucciones-Asuntos referenciados por Identificacior del Documento
     * 
     * @param campo Descripción del Asunto
     * @param stridArea Unidad Administrativa
     * @param idBusqueda Lista de Id de Asuntos que no se deben de incluir en la busqueda
     * @param strIdUsuario Usuario que realiza la busqueda
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getAsuntosAntIdDocIns(String campo, String strIdArea, String idBusqueda, String strIdUsuario)
	{	
		try
		{
			String strsql= SQLBuscar.getAsuntosAntIdDocIns(campo, strIdArea, idBusqueda, strIdUsuario);
			//System.out.println("getAsuntosAntIdDocIns:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntosAntIdDocIns:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos que tengan como ID a campo y Estatus en Tramite o Terminado
     * 
     * @param campo ID del Asunto
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaAsuntosAnidados(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getAsuntosAnidados(campo);
			//System.out.println("getBusquedaAsuntosAnidados:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntosAnidados:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los Asuntos que tengan como ID a campo 
     * 
     * @param campo ID del Asunto
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getBusquedaAsuntosAnidadosLigado(String campo)
	{	
		try
		{
			String strsql= SQLBuscar.getAsuntosAnidadosLigado(campo);
			////System.out.println("getAsuntosAnidadosLigado:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntosAnidadosLigado:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}

    /**
     * Regresa los Asuntos referenciados por Palabra Clave
     * 
     * @param campo Descripción del Asunto
     * @param stridArea Unidad Administrativa
     * @param strIdAsunto Id del Asunto Actual
     * @param idBusqueda Lista de Id de Asuntos que no se deben de incluir en la busqueda
     * @param strIdUsuario Usuario que realiza la busqueda
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getAsuntosAntPalabraClave(String campo, String stridArea, String strIdAsunto, String idBusqueda, String strIdUsuario)
	{	
		try
		{
			String strsql= SQLBuscar.getAsuntosAntPalabraClave(campo, stridArea, strIdAsunto, idBusqueda, strIdUsuario);
			//System.out.println("getAsuntosAntPalabraClave:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntosAntPalabraClave:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa las Instrucciones-Asuntos referenciados por Palabra Clave
     * 
     * @param campo Descripción del Asunto
     * @param stridArea Unidad Administrativa
     * @param idBusqueda Lista de Id de Asuntos que no se deben de incluir en la busqueda
     * @param strIdUsuario Usuario que realiza la busqueda
     * 
     * @return Regresa un String[][] con los campos correspondientes
     */
    public static String[][] getAsuntosAntPalabraClaveIns(String campo, String strIdArea, String idBusqueda, String strIdUsuario)
	{	
		try
		{
			String strsql= SQLBuscar.getAsuntosAntPalabraClaveIns(campo, strIdArea, idBusqueda, strIdUsuario);
			//System.out.println("getAsuntosAntPalabraClaveIns:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntosAntPalabraClaveIns:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los datos de un Asunto segun su ID para la busqueda
     * @param strIdAsutno ID del Asunto
     * @return Datos del asunto
     */
    public static String[][] getAsuntoBuscar(String strIdAsutno)
	{	
		try
		{
			String strsql= SQLBuscar.getAsuntoBuscar(strIdAsutno);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntoBuscar:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los datos de una Instruccion segun su ID para la busqueda
     * @param strIdAsutno ID de la Instruccion
     * @return Datos de la Instruccion
     */
    public static String[][] getInstruccionBuscar(String strIdInstruccion)
	{	
		try
		{
			String strsql= SQLBuscar.getInstruccionBuscar(strIdInstruccion);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getInstruccionBuscar:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
}

