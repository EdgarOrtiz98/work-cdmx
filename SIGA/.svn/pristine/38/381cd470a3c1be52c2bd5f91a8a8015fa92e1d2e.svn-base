package com.meve.sigma.actualiza;

import java.sql.SQLException;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLFolio;

/**
 * 	ActualizaFolio es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de Estatus
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaFolio {
    
    /**
     * Inserta registro de un folio
     * @param idArea	Id área
     * @param tipoFolio	tipo de folio
     * @param clave		clave
     * @param consecutivo	consecutivo
     * @param orden			orden 
     * @param actualizo		usuario que actualizo
     * @param fecha			fecha de Actualización
     * @param estatus		Estatus
     * @return	true si inserta correctamente un folio
     */
    public static boolean InsertarFolio(String idArea, String tipoFolio, 
    									String clave, String consecutivo, 
										String orden, String actualizo, 
										String fecha, String estatus)
    {
        int r = 0;
        try
        {
            String strSql = SQLFolio.getInsertaFolio(	idArea, tipoFolio, clave, consecutivo, 
						orden, actualizo, fecha, estatus);
            ////System.out.println("InsertaFolio"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
       	catch (SQLException sqle)
       	{
       	    //System.out.println("InsertaFolio:"+sqle.getMessage());
       	    sqle.printStackTrace();
       	    return false;
       	}
       	return (r>0);
    }
    
    /**
     * Datos para la generación del folio como consecutivo, clave
     * @param idArea	id área
     * @return	datos de la generación del área
     */
    public static String[][] getGeneracionFolio(String idArea)
	{
	    try
		{
			String strsql	=	SQLFolio.getGeneracionFolio(idArea);
			////System.out.println("getGeneracionFolio:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getGeneracionFolio:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
	}
    
    /**
     * Datos del folio
     * @param idFolio	id folio
     * @return	regresa arreglo de los datos del folio
     */
    public static String[][] getFolio(String idFolio)
	{	
		try
		{
			String strsql=SQLFolio.getFolio(idFolio);
			////System.out.println("getFolio:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getFolio:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Eliminó los registros de los folios seleccionados
     * @param strIds	ids folios
     * @return	true si es correcta la eliminación
     */
	public static boolean deleteFolio(String strIds[], String idBUsuario)
	{
		int r=0;
		if(strIds==null || strIds.length<0)
			return false;
		
		try
		{
			for (int i=0; i<strIds.length; i++){
				String strsql=SQLFolio.getDeleteFolio(strIds[i]);
				////System.out.println("deleteFolio:"+strsql); 
				boolean b = ActualizaBitacora.InsertarEventoEliminarFolio(idBUsuario,getFolio(strIds[i])[0][2],getFolio(strIds[i])[0][0],strIds[i]);
				r= ConexionDS.ejecutarActualizacion(strsql);
			}
		}
		catch(SQLException sqle)
		{
				//System.out.println("deleteFolio:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}						
		return (r>0);
	}
	
	/***
	 * Lista de los folios para la consulta en el catalogo
	 * @return	regresa arreglo con la lista de folios de las áreas
	 * @param strOrden	Orden
	 * @param tipo		tipo de orden
	 * @return	regresa lista de folios
	 */
	public static String[][] getListaFolios(String strOrden, String tipo)
	{	
		try
		{
			String strsql=SQLFolio.getFolios(strOrden, tipo);
			////System.out.println("getListaFolios:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getListaFolios:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
	
	/**
	 * Actualización de un registro de folio
	 * @param idFolio	id folio
	 * @param idArea	Id área
     * @param tipoFolio	tipo de folio
     * @param clave		clave
     * @param consecutivo	consecutivo
     * @param orden			orden 
     * @param actualizo		usuario que actualizo
     * @param fecha			fecha de Actualización
     * @return	true si realizo la actualizacion correctamente
	 */
    public static boolean ActualizarFolio(	String idFolio, String idArea, String tipoFolio, String clave, String consecutivo, 
			String orden, String actualizo, String fecha)
    {
    	int r=0;
    	try{
    			String strsql = SQLFolio.getActualizarFolio(idFolio, idArea, tipoFolio, clave, consecutivo, 
						orden, actualizo, fecha);
    			////System.out.println("ActualizarFolio:"+strsql);
    			r=ConexionDS.ejecutarActualizacion(strsql);
    		}
    		catch(SQLException sqle){
    			//System.out.println("ActualizarFolio:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return false;
    		}
    		return (r>0);
    }
    
    /**
     * Actualización del consecutivo del folio
     * @param iConsecutivo	Consecutivo
     * @param strIdFolio		id Folio
     * @return	true si es correcta la Actualización
     */
    public static boolean ActualizaConsecutivoFolio(int iConsecutivo, String strIdFolio)
    {
    	int r=0;
    	try{
    	    	String strCOnsecutivo = String.valueOf(iConsecutivo);
    			String strsql = SQLFolio.getActualizaConsecutivoFolio(strCOnsecutivo, strIdFolio);
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
     * Verifica si existe el folio
     * @param strIdArea	id área
     * @return	true si existe
     */
    public static boolean ExisteFolio(String strIdArea)
    {
        try
		{
			String strsql = SQLFolio.getExisteFolio(strIdArea);
			////System.out.println("ExisteFolio:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("ExisteFolio:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
    }
    
    /**
     * Función que ejecuta un query que trae un registro del folio de turnado
     * @param idArea	Id área
     * @return	Folio turnado
     */
    public static String[][] getGeneracionFolioTurnado(String idArea)
	{
	    try
		{
			String strsql	=	SQLFolio.getGeneracionFolioTurnado(idArea);
			////System.out.println("getGeneracionFolioTurnado:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getGeneracionFolioTurnado:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
	}
    
    /**
     * Verifica que exitan Folios en una UA
     * @param strIdArea		Unidad Administrativa
     * @param strIdFolio	ID del Folio
     * @return	Regresa TRUE si NO exiten folios o false en caso contrario  
     */
    public static boolean getFolioExiste(String strIdArea, String strIdFolio)
	{	
		try
		{
			String strSQL = SQLFolio.getFolioExiste(strIdArea, strIdFolio);
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getFolioExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return strResult[0][0].equals("0");
			}
			else 
				return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getFolioExiste:"+sqle);
			sqle.printStackTrace();
			return false;		
		}
	}

    /**
     * Verifica que exitan Claves de Folios
     * @param strClave		Clave del Folio
     * @param strIdFolio	ID del Folio
     * @return	Regresa TRUE si NO exiten folios o false en caso contrario  
     */
    public static boolean getClaveFolioExiste(String strClave, String strIdFolio)
	{	
		try
		{
			String strSQL = SQLFolio.getClaveFolioExiste(strClave, strIdFolio);
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getFolioExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return strResult[0][0].equals("0");
			}
			else 
				return false;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getClaveFolioExiste:"+sqle);
			sqle.printStackTrace();
			return false;		
		}
	}

}

