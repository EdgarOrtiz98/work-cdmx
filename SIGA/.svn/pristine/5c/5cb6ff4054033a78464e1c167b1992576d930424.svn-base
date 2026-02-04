
package com.meve.sigma.actualiza;

import java.sql.SQLException;
import java.util.Vector;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLTramite;

/**
 * Clase para Insertar, Eliminar, Editar y Obtener informacion de los Tramites
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaTramite {

	/**
	 * Metodo de Construccion de la Clase
	 *
	 */
	public ActualizaTramite() {
		super();
	}
	
	/**
	 * Inserta un Tramite en la Base de Datos
	 * @param strNombre Nombre
	 * @param strClave Clave 
	 * @param strDes Descripción
	 * @param strTiempo Tiempo
	 * @param strIdUsuario Usuario que actualiza
	 * @param strArea Unidad Administrativa
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */ 
	public static boolean insertaTramite(String strNombre, String strClave, String strDes,
			String strTiempo, String strIdUsuario, String strArea)
	{
		int r = 0;
		try
		{
			String strSql = SQLTramite.insertaTramite(strNombre, strClave, strDes, strTiempo, strIdUsuario, strArea);
                       // //System.out.println("ActualizaTramite->42. sql: "+strSql);
			r = ConexionDS.ejecutarActualizacion(strSql);
		}
		catch (SQLException sqle)
		{
			//System.out.println("insertaTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return false;
		}
		return (r>0);
	}
	
	/**
	 * Regresa una lista de los tramites ordenados
	 * @param strOrden Campo por el cual se ordena la lista 
	 * @param tipo Ordenamiento ascendente o descendente
	 * @return Regresa el String[][] correspondiente
	 */
	public static String[][] getVistaTramite(String strOrden, String tipo)
	{
	    try
		{
			String strsql	=	SQLTramite.getVistaTramite(strOrden, tipo);
			////System.out.println("getVistaTramite:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getVistaTramite:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
	}
	
	/**
	 * Actualiza un Tramite en la Base de Datos
	 * @param strIdTramite ID del Tramite
	 * @param strIdArea Unidad Administrativa
	 * @param strNombre Nombre 
	 * @param strClave Clave
	 * @param strDescripcion Descripción
	 * @param strTiempo Tiempo
	 * @param strFecha Fecha de Actualización
	 * @param strIdUsuario Usuario que actualiza
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */
	public static boolean actualizaTramite(String strIdTramite, String strIdArea, String strNombre, 
											String strClave, String strDescripcion, String strTiempo, 
											String strFecha, String strIdUsuario)
    {
    	int r=0;
    	try{
    		String strsql = SQLTramite.actualizaTramite(strIdTramite, strIdArea, strNombre, strClave, strDescripcion, 
    													strTiempo, strFecha, strIdUsuario);
    		////System.out.println("actualizaTramite:"+strsql);
    		r=ConexionDS.ejecutarActualizacion(strsql);
    	}
    	catch(SQLException sqle){
    		//System.out.println("actualizaTramite:"+sqle.getMessage());
    		sqle.printStackTrace();
    		return false;
    	}
    	return (r>0);
    }
	
	/**
	 * Regresa el Tramite por su ID
	 * @param strIdTramite ID del Tramite
	 * @return  Regresa el String[][] correspondiente
	 */
	public static String[][] getTramite(String strIdTramite)
	{
	    try
		{
			String strsql	=	SQLTramite.getTramite(strIdTramite);
//			//System.out.println("ActualizaTramite->116::getTramite: "+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getTramite:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
	}
	
	/**
	 * Elimina logicamente el tramite
	 * @param strIds ID's de los Tramites
	 * @param idBUsuario ID del usuario que ejecuta la acción
	 * @return Regresa un Vector vacio si la operación fue exitosa y en caso contrario contiene 
	 * los ID's de los tramites que no se eliminaron
	 */
	public static Vector deleteTramite(String strIds[], String idBUsuario)
	{
		Vector vTiene = new Vector(); 
		int r=0;
		if(strIds==null || strIds.length<0)
			return vTiene;
		
		try
		{
			for (int i=0 ; i<strIds.length; i++){
				boolean bAsunto		= getCountGeneral(SQLTramite.getCountAsuntos(strIds[i]));
				if ( bAsunto ){
					String strsql=SQLTramite.deleteTramite(strIds[i]);
					////System.out.println("deleteTramite:"+strsql); 
					boolean b = ActualizaBitacora.InsertarEventoEliminarTramite(idBUsuario,getTramite(strIds[i])[0][3],getTramite(strIds[i])[0][1],strIds[i]);
					r= ConexionDS.ejecutarActualizacion(strsql);						
				}else{
					String msg = "";
					if(!bAsunto)
						msg += "Asuntos generados, ";
					vTiene.add(strIds[i]);
					vTiene.add(msg);
				}
			}
		}
		catch(SQLException sqle)
		{
				//System.out.println("deleteTramite:"+sqle.getMessage());
				sqle.printStackTrace();
		}						
		return vTiene;
	}
	
	/**
	 * Valida se existen Tramites en una Unidad Administrativa
	 * @param strIdArea Unidad Administrativa
	 * @return Regresa True si existen tramites o False en caso contrario
	 */
	public static boolean getExisteTramite(String strIdArea)
    {
        try
		{
			String strsql = SQLTramite.getExisteTramite(strIdArea);
			////System.out.println("getExisteTramite:"+strsql);
			String strTramite[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strTramite.length > 0)
			    return true;
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getExisteTramite:"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}
    }
	
	/**
	 * Regresa una lista de Tramites segun su UA
	 * @param strIdArea Unidad Administrativa
	 * @return Regresa el String[][] correspondiente
	 */
	public static String[][] getComboTramite(String strIdArea)
	{
	    try
		{
			String strsql	=	SQLTramite.getComboTramite(strIdArea);
			////System.out.println("getComboTramite:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getComboTramite:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
	}
	
	/**
	 * Regresa una lista con todos los Tramites
	 * @return Regresa el String[][] correspondiente
	 */
	public static String[][] getComboTramiteGral()
	{
	    try
		{
			String strsql	=	SQLTramite.getComboTramiteGral();
			////System.out.println("getComboTramiteGral:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getComboTramiteGral:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}
	}
	
	/**
	 * Regresa el nombre del tramite segun su ID
	 * @param strIdTramite ID del Tramite
	 * @return Regresa el String correspondiente
	 */
	public static String getNombreTramite(String strIdTramite)
	{
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLTramite.getNombreTramite(strIdTramite));
			////System.out.println("getNombreTramite="+SQLTramite.getNombreTramite(strIdTramite));
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getNombreTramite:"+sqle);
			sqle.printStackTrace();
			return null;		
		}
	}
	
	/**
	 * Varifica si un tramite ya existe por su Clave y UA 
	 * @param strClave Clave 
	 * @param strAux Clave antes de ser editada
	 * @param strIdArea Unidad Administrativa
	 * @param strAux2 Unidad Administrativa antes de ser editada
	 * @return Regresa 1 si ya existe, 2 si no existe y -1 si hubo algun error
	 */
    public static int getTramiteExiste(String strClave, String strAux, String strIdArea, String strAux2)
	{	
		try
		{
			String strSQL = SQLTramite.getTramiteExiste(strClave.trim(), strAux.trim(), strIdArea.trim(), strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getTramiteExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getTramiteExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}
    
    /**
     * Regresa el Estatus del tramite por su ID
     * @param strIdTramite ID del tramite
     * @return Regresa el String correspondiente
     */
    public static String getEstatusTramite(String strIdTramite)
	{		
		try
		{
			String strsql = SQLTramite.getEstatusTramite(strIdTramite);
			////System.out.println("getEstatusTramite:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strResult!=null && strResult.length > 0)
			    return strResult[0][0];
			else 
				return "";
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEstatusTramite:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
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
			//System.out.println(sql);
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




}
