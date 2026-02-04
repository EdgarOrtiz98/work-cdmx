/* 
 * Nombre de Clase:     ActualizaTipoAsunto.java
 * Paquete:             
 * Versión             1.0
 * Fecha Creación:      23/09/2005
 * Autor:               Rodrigo Soto
 * Empresa:             Meve Soluciones
 * Contacto:            corichi@yahoo.com.mx
 * Modificación:        21/Sep/2005 
 * Descripción de Clase:
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
 
package com.meve.sigma.actualiza;

import java.sql.SQLException;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLPaso;

/**
 * 	ActualizaPaso es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de SD_PASOS
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaPaso {
 
	/**
    * Función que ejecuta un query para la inserción de un Paso
	* @param IdTipoDocto String Contiene el ID del tipo de documento
	* @param Descripcion String Describe la secuencia del paso
	* @param actualizo   String Contiene el ID del usuario que actualizo o registro el paso
	* @param fecha 		 String Contiene la fecha en la que se creo o actualizo el registro del paso
    * @return Regresa un True si inserto correctamente el registro, False lo contrario
    */
	public static boolean InsertarPaso(	String IdTipoDocto, String secuencia, String Descripcion, 
										String actualizo, String fecha)
    {
        int r = 0;
        try
        {
            String strSql = SQLPaso.getInsertaPaso(	IdTipoDocto, secuencia, Descripcion, 
            										actualizo, fecha);
            ////System.out.println("InsertaPaso"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
       	catch (SQLException sqle)
       	{
       	    //System.out.println("InsertaPaso:"+sqle.getMessage());
       	    sqle.printStackTrace();
       	    return false;
       	}
       	return (r>0);
    }
    
    /**
     * Datos del registro de un paso
     * @param IdPaso	Id Paso
     * @return	regresa el arreglo de los datos de un paso
     */
    public static String[][] getPaso(String IdPaso)
	{	
		try
		{
			String strsql=SQLPaso.getPaso(IdPaso);
			////System.out.println("getPaso:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getPaso:"+sqle.getMessage());
				sqle.printStackTrace();
				return new String[0][0];//return null;
		}						
	}
    
    /**
     * Lista de pasos para la vista del catalogo
     * @param IdTipoDocto	Id tipo de docto.
     * @param strOrden		Orden de las columnas
     * @param tipo			Tipo de orden de las columnas(asc o desc)
     * @return	regresa arreglo la lista de las pasos por tipo de docto.
     */
    public static String[][] getPasos(String IdTipoDocto, String strOrden, String tipo)
	{	
		try
		{
			String strsql=SQLPaso.getPasos(IdTipoDocto, strOrden, tipo);
			////System.out.println("getPasos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{ 
				//System.out.println("getPasos:"+sqle.getMessage());
				sqle.printStackTrace();
				return new String[0][0];//return null;
		}						
	}
    
    /**
     * Elimina los pasos del catalogo
     * @param strIds	Ids de los pasos
     * @return	true si elimino correctamente
     */
	public static boolean deletePaso(String strIds[], String idBUsuario)
	{
		int r=0;
		if(strIds==null || strIds.length<0)
			return false;
		
		try
		{
			for (int i=0; i<strIds.length; i++){
				String strsql=SQLPaso.getDeletePaso(strIds[i]);
				////System.out.println("deletePaso:"+strsql); 
				boolean b = ActualizaBitacora.InsertarEventoEliminarPaso(idBUsuario,getPaso(strIds[i])[0][1],getPaso(strIds[i])[0][0],strIds[i]);
				r= ConexionDS.ejecutarActualizacion(strsql);
			}
		}
		catch(SQLException sqle)
		{
				//System.out.println("deletePaso:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}						
		return (r>0);
	}
	
	/**
	 * Lista de los pasos exisntents en el ctalogo
	 * @return	regresa arreglo de la lista de pasos
	 */
	public static String[][] getListaPasos()
	{	
		try
		{
			String strsql=SQLPaso.getPasos();
			////System.out.println("getListaPasos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getListaPasos:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
	
    /**
     * Actualiza el registro de un paso
     * @param IdPaso	id paso
     * @param IdTipoDocto String Contiene el ID del tipo de documento
     * @param secuencia 	 String Contiene la secuencia del paso 
     * @param Descripcion String Describe la secuencia del paso
     * @param actualizo   String Contiene el ID del usuario que actualizo o registro el paso
     * @param fecha 		 String Contiene la fecha en la que se creo o actualizo el registro del paso
     * @return	true si actualizá correctamente
     */
	public static boolean ActualizarPaso(	String IdPaso, String IdTipoDocto, String secuencia,
	        								String Descripcion, String actualizo, String fecha)
    {
    	int r=0;
    	try{
    			String strsql = SQLPaso.getActualizarPaso(IdPaso, IdTipoDocto, secuencia, 
    														Descripcion, actualizo, fecha);
    			////System.out.println("ActualizarPaso:"+strsql);
    			r=ConexionDS.ejecutarActualizacion(strsql);
    		}
    		catch(SQLException sqle){
    			//System.out.println("ActualizarPaso:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return false;
    		}
    		return (r>0);
    }
	
	/**
	 * Verifica si existe un paso
	 * @return	trus si existe
	 */
	public static boolean getExiste()
	{		
		try
		{
			String strsql = SQLPaso.getExiste();
			////System.out.println("getExiste:"+strsql);
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
		//	//System.out.println("="+false);
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getExiste:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}	
	}
	
	/**
	 * Lista de los tipos de documentos que tienen pasos asignados
	 * @return	regresa arreglo de los tipos de doctos. 
	 */
	public static String[][] getTipoDoctos(String strOrden)
	{	
		try
		{
			String strsql=SQLPaso.getTipoDoctos(strOrden);			
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();			
			return new String[0][0];
		}						
	}
	
	/**
	 * Secuencia máxima de un tiop de documento
	 * @param IdDocto	Tipo de Docto.
	 * @return	secuencia máxima
	 */
	public static String[][] getSec(String IdDocto)
	{	
		try
		{
			String strsql=SQLPaso.getSec(IdDocto);
			////System.out.println("getSec:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getSec:"+sqle.getMessage());
				sqle.printStackTrace();
				return new String[0][0];//return null;
		}						
	}
	
	/**
	 * Secuencia mínima de un tiop de documento
	 * @param IdDocto	Tipo de Docto.
	 * @return	secuencia mínima
	 */
	public static String[][] getSecMin(String IdDocto)
	{	
		try
		{
			String strsql=SQLPaso.getSecMin(IdDocto);
			////System.out.println("getSecMin:"+strsql);
			String str[][] = ConexionDS.ejecutarSQL(strsql);
			if(str.length==0)
				return null;
			return str;
		}
		catch(SQLException sqle)
		{
			//System.out.println("IdDocto:"+sqle.getMessage());
			sqle.printStackTrace();
			return new String[0][0];//return null;
		}						
	}
	
	/**
	 * Verifica si el paso ya existe en el registro del catalogo
	 * @param strSecuencia	Secuencia
	 * @param strAux		Auxiliar
	 * @param strTipoDoc	Tipo de docto.
	 * @param strAux2		Auxiliar2
	 * @return	1 si existe, 2 no existe
	 */
	public static int getPasoExiste(String strSecuencia, String strAux, String strTipoDoc, String strAux2){
		try
		{
			String strSQL = SQLPaso.getPasoExiste(strSecuencia.trim(), strAux.trim(), strTipoDoc.trim(), strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getPasoExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;//Si tiene pasos repetidos
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getPasoExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}
}