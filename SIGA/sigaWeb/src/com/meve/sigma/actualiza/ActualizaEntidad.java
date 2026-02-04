package com.meve.sigma.actualiza;

import java.sql.SQLException;
import java.util.Vector;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLEntidad;

/**
 * 	ActualizaEntidad es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Destinatarios Externos
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaEntidad {
	
	/**
	 * Actualiza o inserta los datos de una entidad
	 * @param id	Id entidad
	 * @param strEntidad	Nombre entidad
	 * @param strEntidadArea	área de la entidad
	 * @param strEntidadClasificacion	Clasificación de la entidad
	 * @param strEntidadDireccion		Dirección
	 * @param strEntidadTel				Teléfono
	 * @param strCreador1				usuario que créa o atualiza el registro
	 * @param strFechaCreacion			fecha de Creación
	 * @param strEstatus				Estatus
	 * @return	true si la Actualización o inserción es correcta
	 */
	public static boolean InsertarEntidad(	String id, String strEntidad, 
											String strEntidadArea, String strEntidadClasificacion,
											String strEntidadDireccion, String strEntidadTel, 
											String strCreador1, String strFechaCreacion, 
											String strEstatus)
	{
		int r = 0;
		String strSql="";
		try
		{
			if (id!=null)
	       	{
				String datosPrevios[][] = ActualizaEntidad.getEntidades(id);
	       		strSql = SQLEntidad.getActualizaEntidad(id, strEntidad, strEntidadArea, 
						strEntidadClasificacion, strEntidadDireccion, strEntidadTel, strCreador1,
						strFechaCreacion,strEstatus);
				r = ConexionDS.ejecutarActualizacion(strSql);
	       		boolean b = ActualizaBitacora.InsertarEventoCambioEntidad(strCreador1, strEntidad, strEntidadArea, id, datosPrevios);
	       		////System.out.println("EditaEntidad"+strSql);
	       	}
	       	else{
	       		String strEntidades[][] = null;
		        strSql=SQLEntidad.findEntidades(strEntidad,strEntidadArea);
		        ////System.out.println("BuscaEntidad"+strSql);
		        try
				{
					strEntidades=ConexionDS.ejecutarSQL(strSql);
				}
				catch(SQLException sqle)
				{
					//System.out.println("ErrorBuscaEntidades:"+sqle.getMessage());
					sqle.printStackTrace();
					strEntidades= null;
				}
		        if (strEntidades.length>0)
		        {
		        	id=strEntidades[0][0];
		        	String datosPrevios[][] = ActualizaEntidad.getEntidades(id);
		       		strSql = SQLEntidad.getActualizaEntidad(id, strEntidad, strEntidadArea, 
							strEntidadClasificacion, strEntidadDireccion, strEntidadTel, strCreador1,
							strFechaCreacion,strEstatus);
					r = ConexionDS.ejecutarActualizacion(strSql);
		        	boolean b = ActualizaBitacora.InsertarEventoCambioEntidad(strCreador1, strEntidad, strEntidadArea, id, datosPrevios);
		        	////System.out.println("EditaEntidad"+strSql);
		        }
		        else
		        {
		        	strSql = SQLEntidad.getInsertaEntidad(	strEntidad, strEntidadArea, strEntidadClasificacion, strEntidadDireccion, strEntidadTel, strCreador1, strFechaCreacion,strEstatus);
		        	////System.out.println("InsertaEntidad"+strSql);
					r = ConexionDS.ejecutarActualizacion(strSql);
		        	boolean b = ActualizaBitacora.InsertarEventoAltaEntidad(strCreador1,strEntidad,strEntidadArea);
		        }
	       	}
		}
		catch (SQLException sqle)
		{
			//System.out.println("InsertaEntidad:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r>0);
	}
	
	/**
	 * Lista de las entidades
	 * @param strOrden	Orden de las columnas
	 * @param tipo		Tipo de orden (asc o desc)
	 * @return	regresa arreglo de la lista de entidades
	 */
	public static String[][] getListaEntidades(String strOrden, String tipo)
	{	
		try
		{
			String strsql=SQLEntidad.getEntidades(strOrden, tipo);
			////System.out.println("getListaEntidades:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getListaEntidades:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
	/**
	 * Datos de una entidad
	 * @param idEntidad	id de la entidad
	 * @return	regresa un arreglo con los datos de una entidad
	 */
    public static String[][] getEntidades(String idEntidad)
	{	
		try
		{
			String strsql=SQLEntidad.getEntidad(idEntidad);
			////System.out.println("getEntidades:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getEntidades:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * elimina registros de las entidades
     * @param strIds	ids de las entidades a eliminar
     * @param strIdUsuario
     * @return	Vector con los ids de las entidades no eliminadas
     */
    public static Vector deleteEntidad(String strIds[], String strIdUsuario)
	{
    	Vector vTiene = new Vector();
		int r=0;
		if(strIds==null || strIds.length<0)
			return vTiene;
		
		try
		{ 
			for(int i=0;i<strIds.length;i++){
				
				boolean bRemitente	= getCountGeneral(SQLEntidad.getCountRemitente(strIds[i]));
				boolean bAsunto		= getCountGeneral(SQLEntidad.getCountAsuntos(strIds[i]));
				
				if ( bRemitente && bAsunto ){
					
					String strsql=SQLEntidad.getDeleteEntidad(strIds[i]);
					boolean b = ActualizaBitacora.InsertarEventoEliminarEntidad(strIdUsuario,getEntidades(strIds[i])[0][0],getEntidades(strIds[i])[0][1],strIds[i]);
					////System.out.println("deleteEntidad:"+strsql);
					r= ConexionDS.ejecutarActualizacion(strsql);		
				}else{
					String msg = "";
					if(!bRemitente)
						msg += "Remitentes, ";
					if(!bAsunto)
						msg += "Asuntos generados, ";
					vTiene.add(strIds[i]);
					vTiene.add(msg);
				}
			}
		}
		catch(SQLException sqle)
		{
			//System.out.println("deleteEntidad:"+sqle.getMessage());
			sqle.printStackTrace();
		}						
		return vTiene;	
	}

    /**
     * Lista de entidades por un área para generar un combo
     * @param strIdArea	id área
     * @return	regresa arreglo con la lista de entidades por área
     */
    public static String[][] getEntidadArea(String strIdArea)
	{	
		try
		{
			String strsql = SQLEntidad.getEntidadCombo(strIdArea);
			////System.out.println("getEntidadArea:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getEntidadArea:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Lista de entidades generales para generar un combo
     * @param strIdArea	id área
     * @return	regresa arreglo con la lista de entidades generales
     */
    public static String[][] getEntidadGralExt(String strIdArea)
	{	
		try
		{
			String strsql = SQLEntidad.getEntidadGralExt(strIdArea);
			//System.out.println("ENTIDADES EXTERNAS: "+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getEntidadGralExt:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    
    /**
     * Verifica si existe la entidad
     * @return true si existe
     */
    public static boolean getExisteEntidad()
	{		
		try
		{
			String strsql = SQLEntidad.getExisteEntidad();
			////System.out.println("getExisteEntidad:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
		//	//System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getExisteEntidad:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}	
	}
    
    /**
     * Nombre de la entidad
     * @param strId	id entidad
     * @return	Nombre entidad
     */
    public static String getNombreEntidad(String strId)
	{
        String strsql = SQLEntidad.getNombreEntidad(strId);
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(strsql);
			
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getNombreEntidad:"+strsql);
				sqle.printStackTrace();
				return null;		
		}
	}
    
    /**
     * Entidades generales
     * @return	regresa arreglo de entidades generales
     */
    public static String[][] getEntidadesGenerales()
	{	
		try
		{
			String strsql = SQLEntidad.getEntidadesGenerales();
			////System.out.println("getEntidadesGenerales:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getEntidadesGenerales:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Entidades internas(áreas o Uas)
     * @return	regresa un arreglo con las entidades internas
     */
    public static String[][] getEntidadesInternas()
	{	
		try
		{
			String strsql = SQLEntidad.getEntidadesInternas();
			////System.out.println("getEntidadesInternas:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getEntidadesInternas:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Función que ejecuta un query, donde se inserta una entidad que ha sido registrada
     * al capturar un nuevo asunto
     * @param strIdArea Contiene el Id del Area
     * @param strEntidad Nombre de la entidad
     * @param strCreador Id del usuario que crea el asunto
     * @param strFechaCreacion Fecha en la que se creo el registro de la entidad
     * @return True o False
     */
    public static boolean insertarEntidadDesdeAsunto(String strIdArea, String strEntidad, 
            										String strCreador, String strFechaCreacion)
    {
        int r = 0;
        try
        {
            String strSql = SQLEntidad.insertarEntidadDesdeAsunto(strIdArea, strEntidad, strCreador, strFechaCreacion);
            ////System.out.println("insertarEntidadDesdeAsunto:"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("insertarEntidadDesdeAsunto:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Función que ejecuta un query, donde trae el ultimo Id de las entidades
     * en el catalogo
     * @return String
     */
    public static String ultimoIdEntidad()
    {
        try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLEntidad.ultimoIdEntidad());
			////System.out.println("ultimoIdEntidad:"+strResult[0][0]);
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("ultimoIdEntidad:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }

    /**
     * Verifica si existe la entidad
     * @param strEntidad	Id Entidad
     * @return	1 si existe, 2 no existe
     */
    public static int getEntidadExiste(String strEntidad)
	{	
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLEntidad.getEntidadExiste(strEntidad.trim()));
			////System.out.println("getEntidadExiste:" + SQLArea.getAreaExiste(strEntidad));
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEntidadExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}
    
    /**
     * Verifica si la entidad no existe en los catalogos
     * @param strEntidad	Nombre entidad
     * @param strAux		Auxiliar
     * @param strIdArea		área
     * @param strAux2		Auxiliar 2
     * @return	int si existe, 2 no existe
     */
    public static int getEntidadExiste(String strEntidad, String strAux, 
    									String strIdArea, String strAux2)
	{	
		try
		{
			String strSQL = SQLEntidad.getEntidadExiste(strEntidad.trim(), strAux.trim(), strIdArea.trim(), strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getEntidadExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEntidadExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}
    
    /**
     * Total entidades
     * @param sql	Query
     * @return	true si hace la consulta correctamente
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
			//System.out.println("getCountGeneral:"+sqle);
			sqle.printStackTrace();
		}
		return bTiene;
	}
    
    /**
     * Búsqueda de entidades
     * @param strIdArea	Id Áreas
     * @param buscar	criterio de Búsqueda
     * @param strOrden	Orden
     * @return regresa un arreglo con la Búsquedas de entidades
     */
    public static String[][] getEntidadGralExt(String strIdArea, String buscar,
    											String strOrden)
	{	
		try
		{
			String strsql = SQLEntidad.getEntidadGralExt(strIdArea, buscar, strOrden);
			//System.out.println("getEntidadGralExt:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getEntidadGralExt:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Búsqueda entidades 	internas(área)
     * @param buscar		Criterio de Búsqueda
     * @param strOrden		orden de la columna
     * @param strTipo		Tipo de orden(asc o desc)
     * @return	regresa arreglo de las entidades internas
     */
    public static String[][] getEntidadesInternas(String buscar, String strOrden, String strTipo)
	{	
		try
		{
			String strsql = SQLEntidad.getEntidadesInternas(buscar, strOrden, strTipo);
			//System.out.println("getEntidadesInternas:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getEntidadesInternas:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Estatus de la entidad
     * @param strIdEntidad	Id entidad
     * @return	Estatus entidad
     */
    public static String getEstatusEntidad(String strIdEntidad)
	{		
		try
		{
			String strsql = SQLEntidad.getEstatusEntidad(strIdEntidad);
			////System.out.println("getEstatusEntidad:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strResult!=null && strResult.length > 0)
			    return strResult[0][0];
			else 
				return "";
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEstatusEntidad:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}	
	}
    
    /**
     * Buscar entidades externas
     * @param buscar	Criterio de Búsqueda
     * @return Arreglo
     */
    public static String[][] getEntidadesExternas(String buscar)
	{	
		try
		{
			String strsql = SQLEntidad.getEntidadesExternas(buscar);
			////System.out.println("getEntidadesExternas:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getEntidadesExternas:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
}
