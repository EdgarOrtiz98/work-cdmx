/* 
 * Nombre de Clase:     ActualizaDiaFestivo.java
 * Paquete:             
 * Versión             1.0
 * Fecha Creación:      23/09/2005
 * Autor:               Administrador
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
import com.meve.sigma.sql.SQLDiaFestivo;

/**
 * 	ActualizaDiaFestivo es una clase que ejecuta Querys de Consulta y Actualización
 * 	de registros de la Tabla de dias festivos
 * 
 * @author Meve Soluciones SA de CV
 */
public class ActualizaDiaFestivo {
    
	/**
	 * Inserta registro del Día festivo
	 * @param DiaFestivoFecha	Día festivo
	 * @param Descripcion		Descripción
	 * @param actualizo			Usuario que actualizo el registro
	 * @param fecha				Fecha de Actualización
	 * @param estatus			Estatus
	 * @return	true si inserta correctamente
	 */
	public static boolean InsertarDiaFestivo(String DiaFestivoFecha, String Descripcion,
    										String actualizo, String fecha, String estatus)
    {
        int r = 0;
        try
        {
            String strSql = SQLDiaFestivo.getInsertaDiaFestivo(	DiaFestivoFecha, Descripcion,
            											actualizo, fecha, estatus);
            ////System.out.println("InsertaDiaFestivo"+strSql);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
       	catch (SQLException sqle)
       	{
       	    //System.out.println("InsertaDiaFestivo:"+sqle.getMessage());
       	    sqle.printStackTrace();
       	    return false;
       	}
       	return (r>0);
    }
    
    /**
     * Datos del registro de un Día festivo 
     * @param idDiaFestivo	Id Día festivo
     * @return	regresa un arreglo con los datos del Día festivo
     */
    public static String[][] getDiaFestivo(String idDiaFestivo)
	{	
		try
		{
			String strsql=SQLDiaFestivo.getDiaFestivo(idDiaFestivo);
			////System.out.println("getDiaFestivo:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDiaFestivo:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
    
    /**
     * Elimina registros de Días festivos
     * @param strIds	Ids de los Días festivos que se eliminarón
     * @return	true si Eliminó correctamente
     */
	public static boolean deleteDiaFestivo(String strIds[], String idBUsuario)
	{
		int r=0;
		if(strIds==null || strIds.length<0)
			return false;
		
		try
		{
			for (int i=0; i<strIds.length; i++){
				String strsql=SQLDiaFestivo.getDeleteDiaFestivo(strIds[i]);
				////System.out.println("deleteDiaFestivo:"+strsql); 
				boolean c = ActualizaBitacora.InsertarEventoEliminarDia(idBUsuario,getDiaFestivo(strIds[i])[0][1],strIds[i]);
				r= ConexionDS.ejecutarActualizacion(strsql);		
			}
		}
		catch(SQLException sqle)
		{
			//System.out.println("deleteDiaFestivo:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}						
		return (r>0);
	}
	
	/**
	 * Lista de los Días festivos para la vista del catalogo
	 * @param strOrden	Orden de columnas
	 * @param tipo		Tipo de orden 
	 * @return	regresa un arreglo con la lista de los Días festivos
	 */
	public static String[][] getListaDiasFestivos(String strOrden, String tipo)
	{	
		try
		{
			String strsql=SQLDiaFestivo.getDiasFestivos(strOrden, tipo);
			////System.out.println("getListaDiaFestivos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getListaDiaFestivos:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
	
	/**
	 * Lista de los Días festivos
	 * @return	regresa arreglo de los Días festivos
	 */
	public static String[][] getListaDiasFestivos()
	{	
		try
		{
			String strsql=SQLDiaFestivo.getDiasFestivos();
			////System.out.println("getListaDiaFestivos:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
			//System.out.println("getListaDiaFestivos:"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}						
	}
	
	/**
	 * Actualiza los Días festivos
	 * @param idDiaFestivo		Id Día festivo
	 * @param DiaFestivoFecha	fecha del Día festivo
	 * @param Descripcion		Descripción
	 * @param actualizo			usuario que actualizo el registro
	 * @param fecha				fecha de Actualización
	 * @return  true si actualiza correctamente
	 */
    public static boolean ActualizarDiaFestivo(	String idDiaFestivo, String DiaFestivoFecha, 
    											String Descripcion, 
    											String actualizo, String fecha)
    {
    	int r=0;
    	try{
    			String strsql = SQLDiaFestivo.getActualizarDiaFestivo(idDiaFestivo, DiaFestivoFecha, Descripcion, 
						actualizo, fecha);
    			////System.out.println("ActualizarDiaFestivo:"+strsql);
    			r=ConexionDS.ejecutarActualizacion(strsql);
    		}
    		catch(SQLException sqle){
    			//System.out.println("ActualizarDiaFestivo:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return false;
    		}
    		return (r>0);
    }
    
    /**
     * Verifica si existe el Día festivo
     * @param DiaFestivoFecha		nuevo Día festivo
     * @param DiaFestivoFechaPrevia	fecha previa
     * @return	1 si existe, 2 no existe
     */
    public static int getDiaFestivoExiste(String DiaFestivoFecha, String DiaFestivoFechaPrevia)
	{	
		try
		{
			String sqlReturn = SQLDiaFestivo.getDiaFestivoExiste(DiaFestivoFecha.trim(),DiaFestivoFechaPrevia.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(sqlReturn);
			////System.out.println("getDiaFestivoExiste:" + sqlReturn);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDiaFestivoExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}
}