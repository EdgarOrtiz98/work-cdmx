/*
 * Clase:						ActualizaArchivo.java
 * 
 * Paquete:						com.meve.sigma.actualiza		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Mar 10, 2006
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

import com.meve.sigma.db2.*;
import com.meve.sigma.sql.SQLArea;

import java.sql.*;
import java.util.Vector;


/**
 * ActualizaArea es una clase que ejecuta Querys de Consulta y Actualización
 * de registros de la Tabla de área
 * @author Meve Soluciones SA de CV
 */
public class ActualizaArea {
    
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
     * @return Query
     */
	public static boolean InsertarArea(	String id, String nombre, String descripcion, String idResponsable,
            							String fechaUpdate, String UsUpdate, String estatus,
										String horaEntrada, String horaSalida, 
										String minEntrada, String minSalida, int bandera,
										String strClave, String strIdPadre, String strEnt, 
										String strSal, String strBandera, String strSubVent)
    {
        int r = 0;
        boolean bInsertarBit = false;
        String strSql="";
		try
		{
			if (id!=null && id.length()!=0)
        	{
				String datosPrevios[][] = ActualizaArea.getAreas(id);
        		strSql = SQLArea.getActualizaArea(id, nombre, descripcion, 
						idResponsable, UsUpdate,fechaUpdate,estatus,
						horaEntrada, horaSalida, minEntrada, minSalida, bandera, 
						strClave, strIdPadre, strEnt, strSal, strBandera, strSubVent);
                r = ConexionDS.ejecutarActualizacion(strSql);
        		bInsertarBit = ActualizaBitacora.InsertarEventoCambioArea(UsUpdate,id,nombre, datosPrevios);
        	}
        	else{
        		
        		String strAreas[][] = null;
        		strSql=SQLArea.findAreas(nombre);
        		try
				{
					strAreas=ConexionDS.ejecutarSQL(strSql);
				}
				catch(SQLException sqle)
				{
						//System.err.println("ErrorBuscaAreas:"+sqle.getMessage());
						sqle.printStackTrace();
						strAreas= null;
				}
        		
        		if (strAreas.length>0)
        		{
        			id=strAreas[0][0];
        			String datosPrevios[][] = ActualizaArea.getAreas(id);
        			strSql = SQLArea.getActualizaArea(id, nombre, descripcion, 
    						idResponsable, UsUpdate,fechaUpdate,estatus,
							horaEntrada, horaSalida, minEntrada, minSalida, bandera,
							strClave, strIdPadre, strEnt, strSal, strBandera, strSubVent);
                    r = ConexionDS.ejecutarActualizacion(strSql);
        			bInsertarBit = ActualizaBitacora.InsertarEventoCambioArea(UsUpdate,id,nombre,datosPrevios);
        		}
        		else
        		{
        			strSql = SQLArea.getInsertaArea(	nombre, descripcion, idResponsable, fechaUpdate,
                    								UsUpdate, estatus, horaEntrada, horaSalida, 
													minEntrada, minSalida, bandera, strClave, strIdPadre,
													strEnt, strSal, strBandera, strSubVent);
                    r = ConexionDS.ejecutarActualizacion(strSql);
        			bInsertarBit = ActualizaBitacora.InsertarEventoAltaArea(UsUpdate,nombre);
        		}
        	}
        }
        catch (SQLException sqle)
        {
            //System.err.println("InsertaArea:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Lista de las áreas del sistema
     * @return	Regresa un arreglo con la lista de áreas existentes
     */
    public static String[][] getListaAreas(String strOrden, String tipo, String strOrdenExt, String tipoExt)
	{	
		try
		{
			String strsql=SQLArea.getAreas(strOrden, tipo, strOrdenExt, tipoExt);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.err.println("getListaAreas:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * área o Ua por su ID
     * @param idArea	Id del área
     * @return	área
     */
    public static String[][] getAreas(String idArea)
	{	
		try
		{
			String strsql=SQLArea.getArea(idArea);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.err.println("getAreas:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Nombre del área para formar el folio
     * @param idArea	Id área
     * @return	Nombre del área
     * @deprecated
     */
    public static String[][] getAreaFolio(String idArea)
	{	
		try
		{
			String strsql = SQLArea.getAreaFolio(idArea);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.err.println("getAreaFolio:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Nombre del área 
     * @param idArea	Id área
     * @return	Nombre del área
     */
    public static String getNombreArea(String idArea)
	{	
		try
		{
			String strsql = SQLArea.getAreaFolio(idArea);
			return ConexionDS.ejecutarSQL(strsql)[0][0];
		}
		catch(SQLException sqle)
		{
				//System.err.println("getAreaFolio:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Nombre del área
     * @param idArea	Id Area
     * @return	Nombre del área
     */
    public static String NombreArea(String idArea){
        String resultado = "";
        if(idArea == null || idArea.equals("") || idArea.equalsIgnoreCase("null")) {
            return null;
        }
        try{
            String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.NombreArea(idArea));
            if(strResult!=null && strResult.length>0)
                resultado = strResult[0][0];
	}catch(SQLException sqle){
            System.err.println("ActualizaArea.NombreArea(...): "+SQLArea.NombreArea(idArea)+"\n"+sqle.getMessage());
            sqle.printStackTrace();
            resultado = "";
        }
        return resultado;
    }
    
    
    /**
     * Función que ejecuta un query para motrar información sobre el encargado 
     * el área
     * @param idArea
     * @return	Id supervisor
     */
    public static String[][] getIDArea(String idArea)
	{	
		try
		{
			String strsql = SQLArea.getIDArea(idArea);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.err.println("getIDArea:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Función que ejecuta un query donde se retorna una lista de
     * los usuarios que pertenecen a un área
     * @param idArea String Contiene el ID del área
     * @return ConexionDS.ejecutarSQL(strsql)
     */
    public static String[][] getMiembrosArea(String idArea)
	{	
		try
		{
			String strsql = SQLArea.getMiembrosArea(idArea);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.err.println("getMiembrosArea:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Ejecuta un query, que muestra una lista del las áreas 
     * para el combo de consulta ciudadana
     * @return	Lista ciudadanos
     */
    public static String[][] getAreasCiudadano()
	{	
		try
		{
			String strsql = SQLArea.getAreasCiudadano();
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.err.println("getAreasCiudadano:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Función que regresa que ejecuta un query, donde se muestra el id del responsable
     * del area
     * @param strIdArea
     * @return	Id área padre
     */
    public static String getIdArePadre(String strIdArea)
	{
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.getIdArePadre(strIdArea));
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;		
		}
	}
    
    /**
     * Actualiza la entrada del folio de un área
     * @param iConsecutivo	Consewcutivo
     * @param strIdArea	Id Area
     * @return	true o false
     */
    public static boolean actualizaEntrada(int iConsecutivo, String strIdArea)
    {
    	int r=0;
    	try{
    	    	String strCOnsecutivo = String.valueOf(iConsecutivo);
    			String strsql = SQLArea.actualizaEntrada(strCOnsecutivo, strIdArea);
    			r=ConexionDS.ejecutarActualizacion(strsql);
    		}
    		catch(SQLException sqle){
    			//System.err.println("actualizaEntrada:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return false;
    		}
    		return (r>0);
    }
    
    /**
     * Actualiza la salida del folio de un área
     * @param iConsecutivo
     * @param strIdArea
     * @return	true o false
     */
    public static boolean actualizaSalida(int iConsecutivo, String strIdArea)
    {
    	int r=0;
    	try{
    	    	String strCOnsecutivo = String.valueOf(iConsecutivo);
    			String strsql = SQLArea.actualizaSalida(strCOnsecutivo, strIdArea);
    			r=ConexionDS.ejecutarActualizacion(strsql);
    		}
    		catch(SQLException sqle){
    			//System.err.println("actualizaSalida:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return false;
    		}
    		return (r>0);
    }
    
    /**
     * Número consecutivo de entrada 
     * @param strIdArea	Id área
     * @return	Consecutivo
     */
    public static String getEntrada(String strIdArea)
	{
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.getEntrada(strIdArea));
			
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
				//System.err.println("getEntrada:"+sqle);
				sqle.printStackTrace();
				return null;		
		}
	}
    
    /**
     * Número consecutivo de salida
     * @param strIdArea
     * @return Año
     */
    public static String getSalida(String strIdArea)
	{
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.getSalida(strIdArea));
			
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
				//System.err.println("getSalida:"+sqle);
				sqle.printStackTrace();
				return null;		
		}
	}
    
    /**
     * Elimina registros de varias áreas
     * @param strIds		Arreglo de los Ids de áreas
     * @param stridUsuario	Id usuario que elimina
     * @return	Vector con los Ids de áreas que no fueron eliminadas
     */
    public static Vector deleteArea(String strIds[], String stridUsuario)
    {
    	Vector vTiene = new Vector();
		int r=0;
		if(strIds==null || strIds.length<0)
			return vTiene;
		
		try
		{ 
			for(int i=0;i<strIds.length;i++){
				
				boolean bArea 		= getCountAreas(strIds[i]);
				boolean bIdPadre	= getCountIdPadre(strIds[i]);
				boolean bAsunto		= getCountAsuntosArea(strIds[i]);
				boolean bDestExt	= getCountDestExt(strIds[i]);
				boolean bEntidad	= getCountGeneral(SQLArea.getCountEntidad(strIds[i]));
				boolean bRemitente	= getCountGeneral(SQLArea.getCountRemitente(strIds[i]));
				boolean bTramites	= getCountGeneral(SQLArea.getCountTramites(strIds[i]));
				boolean bTipoDoc	= getCountGeneral(SQLArea.getCountTipoDoc(strIds[i]));
				boolean bTipoAsu	= getCountGeneral(SQLArea.getCountTipoAsunto(strIds[i]));
				boolean bPrioridad	= getCountGeneral(SQLArea.getCountPrioridad(strIds[i]));
				boolean bFolio		= getCountGeneral(SQLArea.getCountFolios(strIds[i]));
				boolean bUbicacion	= getCountGeneral(SQLArea.getCountUbicacion(strIds[i]));
				boolean bRuta		= getCountGeneral(SQLArea.getCountRuta(strIds[i]));
				boolean bInstruc	= getCountGeneral(SQLArea.getCountInstruccion(strIds[i]));
				
				if ( 	bArea && bIdPadre && bAsunto && bDestExt && bEntidad &&
						bRemitente && bTramites && bTipoDoc && bTipoAsu && bPrioridad &&
						bFolio && bUbicacion && bRuta && bInstruc
						){
					boolean bInsertarBit = ActualizaBitacora.deleteEventoArea(stridUsuario,strIds[i],NombreArea(strIds[i]));
					String strsql=SQLArea.getDeleteArea(strIds[i]);
					////System.err.println("deleteArea:"+strsql);
					r= ConexionDS.ejecutarActualizacion(strsql);
				}else{
					String msg = "";
					if(!bArea)
						msg += "Puestos asignados, ";
					if(!bIdPadre)
						msg += "Unidades que le reportan, ";
					if(!bAsunto)
						msg += "Asuntos generados, ";
					if(!bDestExt)
						msg += "Destinatarios Externos, ";
					if(!bEntidad)
						msg += "Entidades, ";
					if(!bRemitente)
						msg += "Remitentes, ";
					if(!bTramites)
						msg += "Tramites, ";
					if(!bTipoDoc)
						msg += "Tipos de Documento, ";
					if(!bTipoAsu)
						msg += "Tipos de Asunto, ";
					if(!bPrioridad)
						msg += "Prioridades, ";
					if(!bFolio)
						msg += "Folios, ";
					if(!bUbicacion)
						msg += "Ubicaciones, ";
					if(!bRuta)
						msg += "Rutas Automaticas, ";
					if(!bInstruc)
						msg += "Instrucciones, ";
					vTiene.add(strIds[i]);
					vTiene.add(msg);
				}
			}
		}
		catch(SQLException sqle)
		{
			//System.err.println("deleteArea:"+sqle.getMessage());
			sqle.printStackTrace();
		}						
		return vTiene;	
	}
    
    /**
     * Total de áreas
     * @param strIdArea	Id área
     * @return	true si hizo correcta la consulta
     */
    public static boolean getCountAreas(String strIdArea)
	{
    	boolean bTiene = false;
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.getCountAreas(strIdArea));
			
			if(strResult!=null && strResult.length>0){
				if(strResult[0][0].equals("0"))
					bTiene = true;
				else
					bTiene = false;
			}
			
		}
		catch(SQLException sqle)
		{
			//System.err.println("getCountAreas:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}
    
    /**
     * Total de áreas padre
     * @param strIdArea	id área
     * @return	true si hizo correcta la consulta
     */
    public static boolean getCountIdPadre(String strIdArea)
	{
    	boolean bTiene = false;
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.getCountIdPadre(strIdArea));
			
			if(strResult!=null && strResult.length>0){
				if(strResult[0][0].equals("0"))
					bTiene = true;
				else
					bTiene = false;
			}
			
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		return bTiene;
	}
    
    /**
     * Número de asuntos por área
     * @param strIdArea	Id área
     * @return	true si no tiene asuntos por área
     */
    public static boolean getCountAsuntosArea(String strIdArea)
	{
    	boolean bTiene = false;
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.getCountAsuntosArea(strIdArea));
			
			if(strResult!=null && strResult.length>0){
				if(strResult[0][0].equals("0"))
					bTiene = true;
				else
					bTiene = false;
			}
			
		}
		catch(SQLException sqle)
		{
			//System.err.println("getCountAsuntosArea:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}
    
    /**
     * Verifica si existe el área con estatus 1
     * @param strArea	Id área
     * @return	1 si existe, 2 no existe
     */
    public static int getAreaExiste(String strArea)
	{	
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.getAreaExiste(strArea.trim()));
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.err.println("getAreaExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}
    
    /**
     * Verifica la existencia de un área por su nombre
     * @param strArea	área nueva
     * @param area2		área anterior
     * @return	1 sio existe, 2 no existe
     */
    public static int getAreaExiste(String strArea, String area2)
	{	
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.getAreaExiste(strArea.trim(), area2.trim()));
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.err.println("getAreaExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}

    /**
     * Número de destinatarios por área 
     * @param strIdArea	id área
     * @return true si no tiene destinatarios 
     */
    public static boolean getCountDestExt(String strIdArea)
	{
    	boolean bTiene = false;
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.getCountDestExt(strIdArea));
			
			if(strResult!=null && strResult.length>0){
				if(strResult[0][0].equals("0"))
					bTiene = true;
				else
					bTiene = false;
			}
			
		}
		catch(SQLException sqle)
		{
			//System.err.println("getCountDestExt:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}
    
    /**
     * Total de áreas generales
     * @param sql	Query
     * @return	true si no tiene 
     */
    public static boolean getCountGeneral(String sql)
	{
    	boolean bTiene = false;
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(sql);
			
			if(strResult!=null && strResult.length>0){
				if(strResult[0][0].equals("0"))
					bTiene = true;
				else
					bTiene = false;
			}
			
		}
		catch(SQLException sqle)
		{
			//System.err.println("getCountGeneral:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}
    
    /**
     * Estatus del área
     * @param strIdArea	id área
     * @return	regresa arreglo con el estatus
     */
    public static String getEstatusArea(String strIdArea)
	{		
		try
		{
			String strsql = SQLArea.getEstatusArea(strIdArea);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strResult!=null && strResult.length > 0)
			    return strResult[0][0];
			else 
				return "";
		}
		catch(SQLException sqle)
		{
			//System.err.println("getEstatusArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}	
	}

    /**
     * Hora de entrada del área
     * @param strIdArea	id área
     * @return	Hora de entrada
     */
    public static String getHoraEntradaArea(String strIdArea)
	{		
		try
		{
			String hora = "";
			String strsql = SQLArea.getHorarioArea(strIdArea);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			
			if(strResult!=null && strResult.length > 0){
				if (strResult[0][0].length()==1)
					hora = hora+"0"+strResult[0][0]+":";
				else
					hora = hora+strResult[0][0]+":";

				if (strResult[0][1].length()==1)
					hora = hora+"0"+strResult[0][1]+":";
				else
					hora = hora+strResult[0][1]+":";
				
				hora = hora + "00";
				return hora;
			}
			else 
				return null;
		}
		catch(SQLException sqle)
		{
			//System.err.println("getHoraEntradaArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}	
	}   
    
    /**
     * Hora de salida del área
     * @param strIdArea	Id área
     * @return	Hora de salida
     */
    public static String getHoraSalidaArea(String strIdArea)
	{		
		try
		{
			String hora = "";
			String strsql = SQLArea.getHorarioArea(strIdArea);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			
			if(strResult!=null && strResult.length > 0){
				if (strResult[0][2].length()==1)
					hora = hora+"0"+strResult[0][2]+":";
				else
					hora = hora+strResult[0][2]+":";

				if (strResult[0][3].length()==1)
					hora = hora+"0"+strResult[0][3]+":";
				else
					hora = hora+strResult[0][3]+":";
				
				hora = hora + "00";
				return hora;
			}
			else 
				return null;
		}
		catch(SQLException sqle)
		{
			//System.err.println("getHoraSalidaArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}	
	}
    
    /**
     * Función que ejecuta un query, 
     * donde verifica si es una área externa
     * @param strIdArea	Id área
     * @return	true si el area es externa, false interna
     */
    public static boolean getEsAreaExterna(String strIdArea)
	{
    	boolean bTiene = false;
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLArea.getEsAreaExterna(strIdArea));
			
			if(strResult!=null && strResult.length>0){
				if(strResult[0][0].equals("1"))
					bTiene = true;//es externo
				else
					bTiene = false;//es interno
			}
			
		}
		catch(SQLException sqle)
		{
			//System.err.println("getEsAreaExterna:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}
    
    /**
     * Verifica el manejo de ventanilla de un puesto para turnado
     * @param strIdArea Id del área o UA
     * @return Devuelve el valor de ARE_SUBVENTANILLA
     */
    public static String getSubventanilla(String strIdArea)
	{		
		try
		{
			String hora = "";
			String strsql = SQLArea.getSubventanilla(strIdArea);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			
			if(strResult!=null && strResult.length > 0){
				return strResult[0][0];
			}
			else 
				return null;
		}
		catch(SQLException sqle)
		{
			//System.err.println("getSubventanilla:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}	
	}
    
    /**
     * verifica los horarios del área a la
     * que pertenece el usuario que turna
     * @param idUs id del usuario
     * @return Horarios
     */
    public static String[][] getHorarioUsuario(String idUs)
	{	
		try
		{
			String strsql = SQLArea.getHorarioUsuario(idUs);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.err.println("getHorarioUsuario:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Verifica si el usuario es el responsable de una UA
     * @param idArea id área
     * @param idUsuario id usuario
     * @return 1 si es el titular de la Ua
     */
    public static String esEncargadoUA(String idArea, String idUsuario){		
		try
		{
			int iCount = 0;
			String hora = "";
			String strsql = SQLArea.esEncargadoUA(idArea, idUsuario);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			
			if(strResult!=null && strResult.length > 0)
				return strResult[0][0];
			return "";
		}
		catch(SQLException sqle)
		{
			//System.err.println("esEncargadoUA:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}	
	}
}