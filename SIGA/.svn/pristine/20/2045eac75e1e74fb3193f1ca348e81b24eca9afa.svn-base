
package com.meve.sigma.actualiza;

import java.sql.SQLException;
import java.util.Vector;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLTipo_Doc;

/**
 * Clase para Insertar, Eliminar, Editar y Obtener informacion de los Tpos de Documento
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaTipo_Doc {
	
	/**
	 * Inserta Tipos de Docuemnto en la Base de Datos
	 * @param id ID del Tipo de Documento
	 * @param strTipo_Doc Tipo de Documento 
	 * @param strTipo_DocArea Unidad Administrativa
	 * @param strTipo_DocClave Clave
	 * @param strCreador1 Usuario que lo edita
	 * @param strFechaCreacion Fecha de creación
	 * @param strEstatus Estatus
	 * @param strConsecutivo Consecutivo
	 * 
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */
	public static boolean InsertarTipo_Doc(	String id, String strTipo_Doc, 
	        								String strTipo_DocArea, String strTipo_DocClave,
											String strCreador1, String strFechaCreacion, 
											String strEstatus, String strConsecutivo)
			{
				int r = 0;
				String strSql="";
				try
				{
					if (id!=null)
		        	{
						String datos[][] = ActualizaTipo_Doc.getTipos_Doc(id);
		        		strSql = SQLTipo_Doc.getActualizaTipo_Doc(id, strTipo_Doc, strTipo_DocArea, strTipo_DocClave,
		        				strCreador1, strFechaCreacion, strEstatus, strConsecutivo);
		        		r = ConexionDS.ejecutarActualizacion(strSql);
		        		boolean b = ActualizaBitacora.InsertarEventoCambioTipoDoc(strCreador1,strTipo_DocClave,strTipo_DocArea,id,datos);
		        	}
		        	else{
		        		
		        			strSql = SQLTipo_Doc.getInsertaTipo_Doc(strTipo_Doc, strTipo_DocArea, 
		        			        								strTipo_DocClave, strCreador1, 
		        			        								strFechaCreacion,strEstatus, strConsecutivo);
							r = ConexionDS.ejecutarActualizacion(strSql);
		        			boolean b = ActualizaBitacora.InsertarEventoAltaTipoDoc(strCreador1,strTipo_DocClave,strTipo_DocArea);
		        	}
				}
				catch (SQLException sqle)
				{
					//System.out.println("InsertaTipoDocumento:"+sqle.getMessage());
					sqle.printStackTrace();
					return false;
				}
				return (r>0);
			}
	
	/**
	 * Obtiene los campos del tipo de docuemto por su ID
	 * @param idTipo_Doc ID del Tipo de Documento
	 * @return Regresa el String[][] correspondiente
	 */
	public static String[][] getTipos_Doc(String idTipo_Doc)
	{	
		try
		{
			String strsql=SQLTipo_Doc.getTipo_Doc(idTipo_Doc);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getTipos_Doc:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}

	/**
	 * Elimina logicamente los registros de Tipo de Documento
	 * @param strIds ID's de los Tipos de documento
	 * @param strIdUsuario ID del Usuario que ejecuta la accion
	 * @return Regresa un Vector vacio si la operacion fue exitosa, en caso contrario contiene ID que no fueron eliminados
	 */
    public static Vector deleteTipo_Doc(String strIds[], String strIdUsuario)
	{
    	Vector vTiene = new Vector();
		int r=0;
		if(strIds==null || strIds.length<0)
			return vTiene;
		
		try
		{ 
			for(int i=0;i<strIds.length;i++){
				
				boolean bPasos	= getCountGeneral(SQLTipo_Doc.getCountPasos(strIds[i]));
				boolean bRuta	= getCountGeneral(SQLTipo_Doc.getCountRuta(strIds[i]));
				boolean bAsunto	= getCountGeneral(SQLTipo_Doc.getCountAsuntos(strIds[i]));
				
				if ( bPasos && bRuta && bAsunto){
					
					String strsql=SQLTipo_Doc.getDeleteTipo_Doc(strIds[i]);
					boolean b = ActualizaBitacora.InsertarEventoEliminarTipoDoc(strIdUsuario,getTipos_Doc(strIds[i])[0][2],getTipos_Doc(strIds[i])[0][1],strIds[i]);
					r= ConexionDS.ejecutarActualizacion(strsql);		
				}else{
					String msg = "";
					if(!bPasos)
						msg += "Pasos, ";
					if(!bRuta)
						msg += "Rutas Automaticas, ";
					if(!bAsunto)
						msg += "Asuntos generados, ";
					vTiene.add(strIds[i]);
					vTiene.add(msg);
				}
			}
		}
		catch(SQLException sqle)
		{
			//System.out.println("deleteTipo_Doc:"+sqle.getMessage());
			sqle.printStackTrace();
		}						
		return vTiene;	
	}
    
    /**
     * Regresa una lista ordenada de los Tipos de Documento
     * @param strOrden Campor por el cual se ordena la lista
     * @param tipo Ordenamiento ascendente o descendente
     * @return Regresa el String[][] correspondiente
     */
    public static String[][] getListaTipos_Doc(String strOrden, String tipo)
	{	
		try
		{
			String strsql=SQLTipo_Doc.getTipos_Doc(strOrden, tipo);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getListaTipos_Doc:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Regresa los campos de Tipo de Documento por ID
     * @param strIdTipoDocto ID del Tipo de Documento
     * @return Regresa el String[][] correspondiente
     */
    public static String[][] getTipoDoctoFolio(String strIdTipoDocto)
	{	
		try
		{
			String strsql =	SQLTipo_Doc.getTipoDoctoFolio(strIdTipoDocto);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getTipoDoctoFolio:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa los campos de Tipo de Documento por UA
     * @param strIdArea ID de la Unidad Administrativa
     * @return Regresa el String[][] correspondiente
     */
    public static String[][] getDoctosArea(String strIdArea)
	{	
		try
		{
			String strsql =	SQLTipo_Doc.getDoctosArea(strIdArea);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDoctosArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Regresa el nombre del Tipo de Documento segun su ID
     * @param idDocto ID del Tipo de Documento
     * @return Regresa un String con el resultado
     */
    public static String getNombreTipoDocto(String idDocto)
	{
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLTipo_Doc.getNombreTipoDocto(idDocto));
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getNombreTipoDocto:"+sqle);
			sqle.printStackTrace();
			return null;		
		}
	}
    
    /**
     * Regresa una lista con los ID's de tipo de Documento
     * @return Regresa el String[][] correspondiente
     */
    public static String[][] getIdDocto0()
	{	
		try
		{
			String strsql=SQLTipo_Doc.getIdDocto0();
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getIdDocto0:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Función que ejecuta un query, donde se actualiza
     * el consecutivo de un tipo de documento
     * @param iConsecutivo Consecutivo
     * @param strIdTD ID del tipo de Documento
     * @return Regresa un True si la operacion fue exitosa y False en caso contrario
     */
    public static boolean ActualizaConsecutivoFolio(int iConsecutivo, String strIdTD)
    {
    	int r=0;
    	try{
    	    	String strCOnsecutivo = String.valueOf(iConsecutivo);
    			String strsql = SQLTipo_Doc.getActualizaConsecutivoTD(strCOnsecutivo, strIdTD);
    			////System.out.println("ActualizaConsecutivoFolio:"+strsql);
    			r=ConexionDS.ejecutarActualizacion(strsql);
    		}
    		catch(SQLException sqle){
    			//System.out.println("ActualizaConsecutivoFolio:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return false;
    		}
    		return (r>0);
    }
    
    /**
     * Verifica si Existe un Tipo de Docto por su Clave y UA, ademas de compararlos con sus datos antes de ser editados
     * @param strClave Clave
     * @param strArea Unidad Administrativa 
     * @param strAux Clave del Tipo de Docto antes de ser editado
     * @param strAux2 Unidad Administrativa  antes de ser editado
     * @return Regresa 1 si Existe, 2 si no existe y -1 si hubo un Error
     */
    public static int getTipoDocExiste(String strClave, String strAux, String strArea, String strAux2)
	{	
		try
		{
			String strSQL = SQLTipo_Doc.getTipoDocExiste(strClave.trim(),strAux.trim(),strArea.trim(),strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getTipoDocExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getTipoDocExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}
    
    /**
     * Determina si el resultado de un Query tiene 1 o mas registros
     * @param sql Query a ejecutar
     * @return Regresa True si la busqueda arrojo 1 o mas registros o False en caso contrario
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
     * Regresa el Estatus de un Tipo de Documento  
     * @param strIdTipoDoc ID del Tipo de Documento  
     * @return Regresa un String con el registros correspondientes
     */
    public static String getEstatusTipoDoc(String strIdTipoDoc)
	{		
		try
		{
			String strsql = SQLTipo_Doc.getEstatusTipoDoc(strIdTipoDoc);
			////System.out.println("getEstatusTipoDoc:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strResult!=null && strResult.length > 0)
			    return strResult[0][0];
			else 
				return "";
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEstatusTipoDoc:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}	
	}
}
