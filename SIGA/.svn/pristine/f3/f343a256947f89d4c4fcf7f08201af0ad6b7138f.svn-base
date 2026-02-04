/*
 * Clase:						ActualizaCiudadano.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Jan 6, 2006
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

import com.meve.sigma.beans.BeanCiudadano;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLCiudadano;

/**
 * 	ActualizaCiudadano es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Ciudadano
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaCiudadano {
    
    /**
     * Inserta cuidadano
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
     * @return	true si inserta correctamente
     */
    public static boolean insertaCiudadano(String strNombre, String strAP, String strAM,
											String strFechaNac, String strSexo, String strOcupacion,
											String strDomicilio, String strPais, String strEstado,
											String strMunicipio, String strTelefono, String strMail,
											String strUsuario, String strClave, String strSector)
    {
        int r = 0;
        try
        {
            String strSql = SQLCiudadano.insertaCiudadano(strNombre, strAP, strAM, strFechaNac, strSexo, 
                    									strOcupacion, strDomicilio, strPais, strEstado, 
                    									strMunicipio, strTelefono, strMail, strUsuario, 
                    									strClave, strSector);
            ////System.out.println("insertaCiudadano="+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("insertaCiudadano="+sqle.getMessage()); 
            sqle.printStackTrace();
            return false;
        }
        return (r>0); 
    }
    
    /**
     * 
     * @param strIdCiudadano Id Ciudadano
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
     * @return true si actualiza correctamente
     */
    public static boolean actualizaCiudadano(	String strIdCiudadano, String strNombre, String strAP, String strAM,
												String strFechaNac, String strSexo, String strOcupacion,
												String strDomicilio, String strPais, String strEstado,
												String strMunicipio, String strTelefono, String strMail,
												String strSector)
    {
        int r = 0;
        try
		{
            String sql = SQLCiudadano.actualizaCiudadano(strIdCiudadano, strNombre, strAP, strAM,
														strFechaNac, strSexo, strOcupacion,
														strDomicilio, strPais, strEstado,
														strMunicipio, strTelefono, strMail,
														strSector);
            ////System.out.println("actualizaCiudadano:"+sql);
			r =  ConexionDS.ejecutarActualizacion(sql);
		}catch(SQLException sqle)
		{
			//System.out.println("actualizaCiudadano:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r>0);
    }
    
    /**
     * Actualiza password de ciudadano
     * @param strIdCiudadano	Id ciudadano
     * @param strPassword		password nuevo
     * @return	true si actualiza correctamente
     */
    public static boolean actualizaPassword(String strIdCiudadano, String strPassword)
    {
        int r = 0;
        try
        {
            String sql = SQLCiudadano.actualizaPassword(strIdCiudadano, strPassword);
            ////System.out.println("actualizaPassword:"+sql);
            r =  ConexionDS.ejecutarActualizacion(sql);
        }catch(SQLException sqle)
        {
            //System.out.println("actualizaPassword:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Datos de consulta del ciudadano
     * @param strIdUsuarioCreador	Id Ciudadano
     * @return	regresa arreglo con los datos del ciudadano
     */
    public static String[][] getDatosCiudadanoConsulta(String strIdUsuarioCreador)
    {
        try
		{
			String strsql = SQLCiudadano.getDatosCiudadanoConsulta(strIdUsuarioCreador);
		//	//System.out.println("getDatosCiudadanoConsulta:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosCiudadanoConsulta:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Verifica si existe el ciudadano
     * @param strUsuario	Id ciudadano
     * @return	true si existe
     */
    public static boolean getExisteUsuario(String strUsuario)
	{
        int r=0;
		int nusuario=0;
		try
		{
			String strsql = SQLCiudadano.getExisteUsuario(strUsuario);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			if(strResultado.length == 0)
			    nusuario = 0;
			else
			    nusuario = 1;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getExisteUsuario:"+sqle.getMessage());
				sqle.printStackTrace();
				nusuario=0;	
		}
		catch(NumberFormatException nfe)
		{		
			nusuario=0;				
		}	
		
		if(nusuario==1)
			return true;			
		return false;
	}
    
    /**
     * Bean para cargar los datos en la sessión de un ciudadano en la aplicación
     * @param strUsuario	Username del usuario
     * @return	BeanCiudadano
     */
    public static BeanCiudadano getCiudadanoBean(String strUsuario){
        
        try{
            String strResult[][]	=	ConexionDS.ejecutarSQL(SQLCiudadano.getCiudadano(strUsuario));
        
            return new BeanCiudadano(strResult[0][0], strResult[0][1], strResult[0][2], strResult[0][3],
                    				strResult[0][4], strResult[0][5], strResult[0][6], strResult[0][7],
                    				strResult[0][8], strResult[0][9], strResult[0][10], strResult[0][11],
                    				strResult[0][12], strResult[0][13], strResult[0][14]);
        }catch(SQLException sqle)
		{
			//System.out.println("getUsuarioBean:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;		
		}
    }
    
    /**
     * Inserta solicitud sin archivo
     * @param strDescripcion	Descripción de la solicitud
     * @param strFecha			Fecha de la solicitud
     * @param strCiuCreador		Ciudadano creador
     * @param strFolio			Folio
     * @param strDetalle		Detalle
     * @param strFechaHora		Fecha Hora de la solicitud
     * @return	ultimo Id del asunto o solicitud
     */
    public synchronized static String insertarSolicitudSinArch(	String strDescripcion, String strFecha, 
			String strCiuCreador, String strFolio, String strDetalle, String strFechaHora)
    {
    	int r = 0;
    	try
		{
    		String strSql = SQLCiudadano.insertarSolicitudSinArch(strDescripcion, strFecha, 
    				strCiuCreador, strFolio, strDetalle, strFechaHora);
    		////System.out.println("insertarSolicitudSinArch="+strSql);
    		r = ConexionDS.ejecutarActualizacion(strSql);
    		
		}
    	catch (SQLException sqle)
		{
    		//System.out.println("insertarSolicitudSinArch="+sqle.getMessage());
    		sqle.printStackTrace();
    		//return getUltimoIdSolicitud();
		}
    	return getUltimoIdSolicitud();
    }
    
    /**
     * Función que regresa un query, donde se inserta la solicitud
     * de información de un ciudadano. Se se agrega archivo
     * @param strDescripcion Descripcion o nombre de la solicitud o asunto
     * @param strFecha Fecha en la que se creo la solicitud
     * @param strCiuCreador Clave del ciudadano que ha solicitado la información
     * @param strFolio Folio generado para dar referencia a la solicitud
     * @return true si actualizazo correctamente
     */
    public static boolean insertarSolicitudConArch(	String strDescripcion, String strFecha, 
													String strCiuCreador, String strFolio, String strDetalle, String strFechaHora)
    {
        int r = 0;
        try
        {
            String strSql = SQLCiudadano.insertarSolicitudConArch(	strDescripcion, strFecha, 
																	strCiuCreador, strFolio, strDetalle, strFechaHora);
            ////System.out.println("insertarSolicitudConArch="+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("insertarSolicitudConArch="+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Ejecuta un query, donde me regresa el Ultimo Id creado en la 
     * tabla de SD_ASUNTO_CIUDADANO
     * @return Ultimo Id Ciudadano
     */
    public synchronized static String getUltimoIdSolicitud()
    {
        try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLCiudadano.getUltimoIDSolicitud());
			////System.out.println("getUltimoIdSolicitud:"+strResult[0][0]);
			if(strResult!=null && strResult.length>0)
				return strResult[0][0];
			return "";
		}
		catch(SQLException sqle)
		{
			//System.out.println("getUltimoIdSolicitud:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Ultimo Id del ciudadno creado
     * @return	Id ciudadano
     */
    public synchronized static String getUltimoIdCiudadano()
    {
        try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLCiudadano.getUltimoIDCiudadano());
			////System.out.println("getUltimoIdCiudadano:"+strResult[0][0]);
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getUltimoIdCiudadano:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Función que ejecuta un query donde se actualiza
     * el folio de la solicitud
     * @param strIdSolicitud Id de la solicitud
     * @param strFolio Folio a actualizar
     * @return True o False
     */
    public static boolean actualizarFolioSolicitud(String strIdSolicitud, String strFolio, String strIdAsunto)
    {
        int r = 0;
        try
		{
            String sql = SQLCiudadano.actualizaFolioSolicitud(strIdSolicitud, strFolio, strIdAsunto);
           // //System.out.println("ActualizarAsuntos:"+sql);
			r =  ConexionDS.ejecutarActualizacion(sql);
		}catch(SQLException sqle)
		{
			//System.out.println("ActualizarAsuntos:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r>0);
    }
    
    /**
     * Función que ejecuta un query donde se muestran los datos a detalle 
     * de las solicitudes por usuario
     * @param strIdUsuario Id del usuario
     * @return String[][]
     */
    public static String[][] getDatosCiudadanoPortal(String strIdUsuario)
    {
        try
		{
			String strsql = SQLCiudadano.getDatosCiudadanoPortal(strIdUsuario);
		//	//System.out.println("getDatosCiudadanoPortal:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosCiudadanoPortal:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Datos de un ciudadano a editar
     * @param strIdCiudadano 
     * @return	regresa arreglo de con los datos del ciudadnao a editar
     */
    public static String[][] getCiudadanoEditar(String strIdCiudadano)
    {
        try
		{
			String strsql = SQLCiudadano.getCiudadanoEditar(strIdCiudadano);
			////System.out.println("getCiudadanoEditar:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getCiudadanoEditar:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Lista de los usuarios por el portal
     * @return	regresa arreglo de ciudadanos
     */
    public static String[][] getDatosCiudadanoPortal()
    {
        try
		{
			String strsql = SQLCiudadano.getDatosCiudadanoPortal();
			////System.out.println("getDatosCiudadanoPortal:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosCiudadanoPortal:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Datos del ciudadano
     * @param strIDUsuario
     * @return	regresa arreglo de los datos del ciudano
     */
    public static String[][] getDatosCiudadano(String strIDUsuario)
    {
        try
		{
			String strsql = SQLCiudadano.getDatosCiudadano(strIDUsuario);
			////System.out.println("getDatosCiudadano:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosCiudadano:"+sqle.getMessage());
			sqle.printStackTrace();
			String strDatos[][] = new String[1][15];
			strDatos[0][0]="";
			strDatos[0][1]="";
			strDatos[0][2]="";
			strDatos[0][3]="";
			strDatos[0][4]="";
			strDatos[0][5]="";
			strDatos[0][6]="";
			strDatos[0][7]="";
			strDatos[0][8]="";
			strDatos[0][9]="";
			strDatos[0][10]="";
			strDatos[0][11]="";
			strDatos[0][12]="";
			strDatos[0][13]="";
			strDatos[0][14]="";
			return strDatos;
		
		}
    }
    
    /**
     * Función que ejecuta un query, donde verifica si existen
     * solicitudes del usuario en el portal
     * @param strIdUsuario Id del usuario
     * @return True o False
     */
    public static boolean getExisteSolicitud(String strIdUsuario)
	{		
		try
		{
			String strsql = SQLCiudadano.getExisteSolicitud(strIdUsuario);
			////System.out.println("getExisteSolicitud:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExisteSolicitud:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Verifica si existen solicitudes
     * @return	true si existen
     */
    public static boolean getExisteSolicitud()
	{		
		try
		{
			String strsql = SQLCiudadano.getExisteSolicitud();
			////System.out.println("getExisteSolicitud:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExisteSolicitud:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
	}
    
    /**
     * Función que ejecuta un query donde se muestra los datos
     * de una solicitud a detalle
     * @param strIdSolicitud Id de la Solicitud
     * @return regresa arreglo de los datos detallados del ciudadano
     */
    public static String[][] getDatosCiudadanoDetalle(String strIdSolicitud)
    {
        try
		{
			String strsql = SQLCiudadano.getDatosCiudadanoDetalle(strIdSolicitud);
			////System.out.println("getDatosCiudadanoDetalle:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosCiudadanoDetalle:"+sqle.getMessage());
			sqle.printStackTrace();
			String strDatos[][] = new String[1][12];
			strDatos[0][0]="";
			strDatos[0][1]="";
			strDatos[0][2]="";
			strDatos[0][3]="";
			strDatos[0][4]="";
			strDatos[0][5]="";
			strDatos[0][6]="";
			strDatos[0][7]="";
			strDatos[0][8]="";
			strDatos[0][9]="";
			strDatos[0][10]="";
			strDatos[0][11]="";
			return strDatos;
		}
    }
    
    /**
     * Función que ejecuta un query para actualizar el avance de una solicitud
     * @param strIdAsunto
     * @param strAvance
     * @return true si actualiza correctamente
     */
    public static boolean actualizaAvanceSolicitud(String strIdAsunto, String strAvance)
    {
        int r = 0;
        try
		{
            String sql = SQLCiudadano.actualizaAvanceSolicitud(strIdAsunto, strAvance);
            ////System.out.println("actualizaAvanceSolicitud:"+sql);
			r =  ConexionDS.ejecutarActualizacion(sql);
		}catch(SQLException sqle)
		{
			//System.out.println("actualizaAvanceSolicitud:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r>0);
    }
    
    /**
     * Función que ejecuta un query donde se inserta las notificaciones 
     * o respuestas a un ciudadano
     * @param strRespuesta
     * @param strIdAsunto
     * @param strNombreFuncionario
     * @param strMail
     * @param strFecha
     * @return	true si inserta correctamente
     */
    public static boolean insertarNotificacion(String strRespuesta, String strIdAsunto,
											String strNombreFuncionario, String strMail,
											String strFecha, String strIdRespuesta, 
											String strEstatus, String strCerrar, String strRespondio, int activo)
    {
        int r = 0;
        try
        {
            String strSql = SQLCiudadano.insertarNotificacion(strRespuesta, strIdAsunto, 
                    										strNombreFuncionario, strMail,
                    										strFecha, strIdRespuesta, strEstatus, strCerrar, strRespondio, activo);
            ////System.out.println("insertarNotificacion="+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("insertarNotificacion="+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Verifica si exisnte notificaciones por asunto
     * @param strIdAsunto	Id asunto
     * @return	trus si existe
     */
    public static boolean getExistenNotificaciones(String strIdAsunto)
	{
        int r=0;
		int nusuario=0;
		try
		{
			String strsql = SQLCiudadano.getExistenNotificaciones(strIdAsunto);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			if(strResultado.length == 0)
			    nusuario = 0;
			else
			    nusuario = 1;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExistenNotificaciones:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario=0;	
		}
		catch(NumberFormatException nfe)
		{		
			nusuario=0;				
		}	
		
		if(nusuario==1)
			return true;			
		return false;
	}
    
    /**
     * Funcion que ejecuta un query, donde trae los datos de las respuesta de una 
     * notificacion
     * @param strIdAsunto Id del asunto
     * @return	regresa arreglo de las notificaciones
     */
    public static String[][] getDatosNotificacion(String strIdAsunto)
    {
        try
		{
			String strsql = SQLCiudadano.getDatosNotificacion(strIdAsunto);
			////System.out.println("getDatosNotificacion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosNotificacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Datos de las notificaciones
     * @param strIdAsunto	Id notificación
     * @return	regresa arreglo de notificación
     */
    public static String[][] getDatosNot(String strIdAsunto)
    {
        try
		{
			String strsql = SQLCiudadano.getDatosNot(strIdAsunto);
			////System.out.println("getDatosNot:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDatosNot:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Desactiva la notificación de un asunto
     * @param strIdAsunto	Id asunto
     * @return	id notificación
     */
    public static String getNotificacionDesacticar(String strIdAsunto)
    {
        try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLCiudadano.getNotificacionDesacticar(strIdAsunto));
			////System.out.println("getNotificacionDesacticar:"+strResult[0][0]);
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getNotificacionDesacticar:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Actualiza la nueva notificación
     * @param strIdNotificacion	Id notificación
     * @return	true si actualiza correctamente
     */
    public static boolean actualizaActivarNuevaNot(String strIdNotificacion)
    {
        int r = 0;
        try
		{
            String sql = SQLCiudadano.actualizaActivarNuevaNot(strIdNotificacion);
            ////System.out.println("actualizaActivarNuevaNot:"+sql);
			r =  ConexionDS.ejecutarActualizacion(sql);
		}catch(SQLException sqle)
		{
			//System.out.println("actualizaActivarNuevaNot:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r>0);
    }
    
    /**
     * Verifica si alguna notificación tiene el cierre
     * @param strIdAsunto	Id asunto
     * @return	true si tiene la notifiación de cierre
     */
    public static boolean getCerrar(String strIdAsunto)
	{
		int r=0;
		int nusuario=0;
		try
		{
			String strsql = SQLCiudadano.getCerrar(strIdAsunto);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			nusuario = new Integer(strResultado[0][0]).intValue();
		}
		catch(SQLException sqle)
		{
			//System.out.println("getCerrar:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario=0;	
		}
		catch(NumberFormatException nfe)
		{		
			nusuario=0;				
		}	
		if(nusuario==0)
			return false;			
		return true;	
	}
    
    /**
     * Lista de asuntos por tiempo de respuesta
     * @param strIdTipRespuesta	Id respuesta
     * @return	regresa arreglo de asuntos por tipo de respuesta
     */
    public static String[][] getAsuntosPorTipoRespuesta(String strIdTipRespuesta)
    {
        try
		{
			String strsql = SQLCiudadano.getAsuntosPorTipoRespuesta(strIdTipRespuesta);
			////System.out.println("getAsuntosPorTipoRespuesta:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntosPorTipoRespuesta:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Verifica si existe respuesta
     * @param strIdRespuesta	id respuesta
     * @return	true si existe respuesta
     */
    public static boolean getExisteRespuestas(String strIdRespuesta)
	{
        int r=0;
		int nusuario=0;
		try
		{
			String strsql = SQLCiudadano.getExisteRespuestas(strIdRespuesta);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			if(strResultado.length == 0)
			    nusuario = 0;
			else
			    nusuario = 1;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getExisteRespuestas:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario=0;	
		}
		catch(NumberFormatException nfe)
		{		
			nusuario=0;				
		}	
		
		if(nusuario==1)
			return true;			
		return false;
	}
    
    /**
     * Envia la ultima respuesta del ciudadano
     * @param strIdAsunto	id asunto
     * @return	Ultima respuesta
     */
    public static String getUltimaRespuestaCiudadano(String strIdAsunto)
	{
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLCiudadano.getUltimaRespuestaCiudadano(strIdAsunto));
			////System.out.println("UltimaRespuestaCiudadano-->"+strResult[0][0]);
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getUltimaRespuestaCiudadano:"+sqle);
			sqle.printStackTrace();
			return null;		
		}
	}
    
    /**
     * Verifica si la solicitus tiene contestación
     * @param strIdAsunto	Id asunto
     * @return	true si tiene contestación
     */
    public static boolean getTieneContestacion(String strIdAsunto)
	{
        int r=0;
		int nusuario=0;
		try
		{
			String strsql = SQLCiudadano.getTieneContestacion(strIdAsunto);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			////System.out.println("getTieneContestacion="+strsql);
			if(strResultado.length == 0)
			    nusuario = 0;
			else
			    nusuario = 1;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getTieneContestacion:"+sqle.getMessage());
			sqle.printStackTrace();
			nusuario=0;	
		}
		catch(NumberFormatException nfe)
		{		
			nusuario=0;				
		}	
		
		if(nusuario==1)
			return true;			
		return false;
	}
    
    /**
     * Lista de asuntos notificados
     * @return	regresa arreglo de asuntos notificados
     */
    public static String[][] getAsuntosNotificados()
    {
        try
		{
			String strsql = SQLCiudadano.getAsuntosNotificados();
			////System.out.println("getAsuntosNotificados:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getAsuntosNotificados:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Catalogo de Ocupación
     * @return	regresa arreglo de Ocupación
     */
    public static String[][] getListaOcupacion(){
		try
		{
			String strsql = SQLCiudadano.getListaOcupacion();
			////System.out.println("getListaOcupacion:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getListaOcupacion:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}
    
    
    /**
     * Catalogo de Estados
     * @return	regresa arreglo de Estados
     */
    public static String[][] getListaEstado(){
		try
		{
			String strsql = SQLCiudadano.getListaEstado();
			////System.out.println("getListaEstado:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getListaEstado:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}
    
    /**
     *Catalogo de Municipios 
     * @return	regresa arreglo de Municipios
     */
    public static String[][] getListaMunicipio(){
		try
		{
			String strsql = SQLCiudadano.getListaMunicipio();
			////System.out.println("getListaMunicipio:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getListaMunicipio:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
	}
    
}

