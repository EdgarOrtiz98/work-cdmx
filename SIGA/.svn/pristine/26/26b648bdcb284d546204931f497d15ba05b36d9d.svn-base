
package com.meve.sigma.actualiza;

import java.sql.SQLException;
import java.util.Vector;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLRemitente;

/**
 * Clase para Insertar, Eliminar, Editar y Obtener informacion de los Remitentes
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ActualizaRemitente {
    
	
	/**
	 * Inserta remitentes en la Base de Datos
	 * 
	 * @param id ID del remitente
	 * @param nombre Nombre 
	 * @param cargo Cargo 
	 * @param strIdArea Unidad administrativa
	 * @param idEntidad Entidad 
	 * @param telefono Telefono 
	 * @param correo Correo Electronico
	 * @param UsUpdate Usuario que actualizo 
	 * @param FechaUpdate Fecha de Actualización
	 * @param estatus Estatus 
	 * @param direccion Direccion fisica 
	 * @param fax Fax
	 * @return Regresa un True si la operacion fue exitosa y False en caso contrario
	 */
    public static boolean InsertarRemitente(String id, String nombre, String cargo, String strIdArea, String idEntidad, String telefono,
			String correo, String UsUpdate, String FechaUpdate, String estatus, String direccion, String fax)
    {
        int r = 0;
        String strSql="";
        ////System.out.println("Inicia Insertar"+id);
        try
        {
            if (id!=null)
            {
            	String datos[][] = ActualizaRemitente.getRemitentes(id);
                strSql = SQLRemitente.getActualizaRemitente(id, nombre, strIdArea, cargo, idEntidad, telefono, correo,
                        UsUpdate, FechaUpdate, estatus, direccion, fax);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean b = ActualizaBitacora.InsertarEventoCambioRemitente(UsUpdate,nombre,idEntidad,id,datos);
            }
            else{
                
                    strSql = SQLRemitente.getInsertaRemitente(	nombre, strIdArea, cargo, idEntidad, telefono, correo,
                            UsUpdate, FechaUpdate, estatus, direccion, fax);
                    r = ConexionDS.ejecutarActualizacion(strSql);
                    boolean b = ActualizaBitacora.InsertarEventoAltaRemitente(UsUpdate,nombre,idEntidad);
            }
        }
        catch (SQLException sqle)
        {
            //System.out.println("InsertaRemitente:"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Obtiene los datos del remitente por su ID
     * @param idRemitente ID del remitente
     * @return Regresa un String[][] con los registros correspondientes
     */
    public static String[][] getRemitentes(String idRemitente)
	{	
		try
		{
			String strsql=SQLRemitente.getRemitente(idRemitente);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getRemitentes:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}

    /**
     * Elimina logicamente los registros de Remitentes
     * @param strIds ID's de los Remitentes
	 * @param strIdUsuario ID del Usuario que ejecuta la accion
	 * @return Regresa un Vector vacio si la operacion fue exitosa, en caso contrario contiene ID que no fueron eliminados
     */
    public static Vector deleteRemitente(String strIds[], String strIdUsuario)
	{
    	Vector vTiene = new Vector(); 
		int r=0;
		if(strIds==null || strIds.length<0)
			return vTiene;
		
		try
		{ 
			for(int i=0;i<strIds.length;i++){
				
				boolean bAsunto		= getCountGeneral(SQLRemitente.getCountAsuntos(strIds[i]));
				
				if ( bAsunto ){
					
					String strsql=SQLRemitente.getDeleteRemitente(strIds[i]);
					////System.out.println("deleteRemitente:"+strsql);
					boolean b = ActualizaBitacora.InsertarEventoEliminarRemitente(strIdUsuario,getNombreRemitente(strIds[i]),getRemitentes(strIds[i])[0][3],strIds[i]);
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
			//System.out.println("deleteRemitente:"+sqle.getMessage());
			sqle.printStackTrace();
		}						
		return vTiene;	
	}

    /**
     * Regresa una lista de Remitentes ordenada
     * @param strOrden Campo por el que se hace el ordenamiento 
     * @param tipo Ordenamiento ascendente o descendente
     * @return Regresa un String[][] con los registros correspondientes
     */
    public static String[][] getListaRemitentes(String strOrden, String tipo)
	{	
		try
		{
			String strsql=SQLRemitente.getRemitentes(strOrden, tipo);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getListaRemitente:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Regresa una lista de Remitentes por UA
     * @param strIdArea Unidad Administrativa 
     * @return Regresa un String[][] con los registros correspondientes
     */
    public static String[][] getRemitenteArea(String strIdArea)
	{	
		try
		{
			String strsql = SQLRemitente.getRemitenteAreaCombo(strIdArea);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getRemitenteArea"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Regresa una lista de Remitentes por Entidad
     * @param strIdEntidad Entidad
     * @return Regresa un String[][] con los registros correspondientes
     */
    public static String[][] getRemitenteFrame(String strIdEntidad)
	{	
		try
		{
			String strsql = SQLRemitente.getRemitenteFrame(strIdEntidad);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getRemitenteFrame"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Regresa una lista de Remitentes por Unidad Administrativa
     * @param strIdArea Unidad Administrativa
     * @return Regresa un String[][] con los registros correspondientes
     */
    public static String[][] getRemitenteInternas(String strIdArea)
	{	
		try
		{
			String strsql = SQLRemitente.getRemitenteInternas(strIdArea);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getRemitenteInternas"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    
    /**
     * Determina si existen remitentes 
     * @return Regresa un True si SI existen y False en caso contrario
     */
    public static boolean getExistenRemitentes()
	{		
		try
		{
			String strsql = SQLRemitente.getExistenRemitentes();
			String strExpediente[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strExpediente.length > 0)
			    return true;
			
			return false;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getExistenRemitentes"+sqle.getMessage());
				sqle.printStackTrace();
				return false;
		}	
	}
    
    /**
     * Regresa el Nombre del Remitente segun su ID 
     * @param strId ID del Remitente
     * @return Regresa el String correspondiente 
     */
    public static String getNombreRemitente(String strId)
	{
        String strsql = SQLRemitente.getNombreRemitente(strId);
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(strsql);
			
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
				//System.out.println("getNombreRemitente"+strsql);
				sqle.printStackTrace();
				return null;		
		}
	}
    
    
    /**
     * Función que ejecuta un query, donde inserta un remitente 
     * al momento de crear un nuevo asunto
     * @param strIdArea Contiene el Id del Area
     * @param strIdEntidad Contiene el Id de la entidad
     * @param strRemitente Nombre del remitente
     * @param strCargo Cargo del remitente
     * @param strCorreo Correo del remitente
     * @param strCreador Id del usuario que crea el registro del remitente
     * @param strFechaCreacion Fecha de la creación del registro
     * @return Regresa un True si el proceso fue satisfactorio o un False en caso contrario
     */
    public static boolean insertarRemitenteDesdeAsunto(String strIdArea, String strIdEntidad,
														String strRemitente, String strCargo, String strCorreo,	
														String strCreador, String strFechaCreacion)
    {
        int r = 0;
        try
        {
            String strSql = SQLRemitente.insertarRemitenteDesdeAsunto(strIdArea, strIdEntidad, 
                    												strRemitente, strCargo, strCorreo,
                    												strCreador, strFechaCreacion);
            r = ConexionDS.ejecutarActualizacion(strSql);
        }
        catch (SQLException sqle)
        {
            //System.out.println("insertarRemitenteDesdeAsunto"+sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return (r>0);
    }
    
    /**
     * Función que ejecuta un query, donde trae el ultimo Id de los remitentes
     * del catalogo
     * @return Regresa el String correspondiente
     */
    public static String ultimoIdRemitente()
    {
        try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLRemitente.ultimoIdRemitente());
			////System.out.println("ultimoIdEntidad"+strResult[0][0]);
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("ultimoIdEntidad"+sqle.getMessage());
			sqle.printStackTrace();
			return null;
		}
    }
    
    /**
     * Función que ejecuta un query, donde verifica si
     * existe el remitente que esta generando el nuevo asunto
     * o solicitud
     * @param strNombre Nombre del ciudadano
     * @return Regresa True si Si existe o False en caso contrario 
     */
    public static boolean existeRemitente(String strNombre)
	{
		int r=0;
		int nusuario=0;
		try
		{
			String strsql = SQLRemitente.existeRemitente(strNombre);
			String strResultado[][] = ConexionDS.ejecutarSQL(strsql);
			nusuario = new Integer(strResultado[0][0]).intValue();
		}
		catch(SQLException sqle)
		{
				//System.out.println("existeRemitente:"+sqle.getMessage());
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
     * Función que ejecuta un query, donde devuelve el id del remitente
     * @param strNombre nombre del remitente
     * @return String con el ID del remitente
     */
    public static String getIdRemitente(String strNombre)
	{
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLRemitente.getIdRemitente(strNombre));
			////System.out.println("getIdRemitente="+SQLRemitente.getIdRemitente(strNombre));
			if(strResult!=null && strResult.length>0)
			return strResult[0][0];
			return null;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getIdRemitente"+sqle);
			sqle.printStackTrace();
			return null;		
		}
	}

    /**
     * Verifica si Existe un remitente por su Nombre y Entidad 
     * @param strNombre Nombre del remitente
     * @param idEntidad Entidad 
     * @return Regresa 1 si Existe, 2 si no existe y -1 si hubo un Error
     */
    public static int getRemitenteExiste(String strNombre, String idEntidad)
	{	
		try
		{
			String strResult[][]=ConexionDS.ejecutarSQL(SQLRemitente.getRemitenteExiste(strNombre.trim(),idEntidad.trim()));
			////System.out.println("getRemitenteExiste:" + SQLRemitente.getRemitenteExiste(strNombre.trim(),idEntidad.trim()));
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getRemitenteExiste:"+sqle);
			sqle.printStackTrace();
			return -1;		
		}
	}
    
    /**
     * Verifica si Existe un remitente por su Nombre y Entidad, ademas de compararlos con sus datos antes de ser editados
     * @param strNombre Nombre del remitente
     * @param strAux Nombre del remitente antes de ser editado
     * @param strEntidad Entidad 
     * @param strAux2 Entidad  antes de ser editado
     * @return Regresa 1 si Existe, 2 si no existe y -1 si hubo un Error
     */
    public static int getRemitenteExiste(String strNombre, String strAux, String strEntidad, String strAux2)
	{	
		try
		{
			String strSQL = SQLRemitente.getRemitenteExiste(strNombre.trim(),strAux.trim(),strEntidad.trim(),strAux2.trim());
			String strResult[][]=ConexionDS.ejecutarSQL(strSQL);
			////System.out.println("getRemitenteExiste:" + strSQL);
			if(strResult!=null && strResult.length>0){
				return 1;
			}
			else 
				return 2;
		}
		catch(SQLException sqle)
		{
			//System.out.println("getRemitenteExiste:"+sqle);
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
     * Regresa los Remitentes por Entidad, Puesto y Responsable 
     * @param strIdEntidad Entidad 
     * @param buscaPuesto Puesto 
     * @param buscaResponsable Responsable
     * @return Regresa un String[][] con los registros correspondientes
     */
    public static String[][] getRemitenteFrame(String strIdEntidad, String buscaPuesto, String buscaResponsable)
	{	
		try
		{
			String strsql = SQLRemitente.getRemitenteFrame(strIdEntidad,buscaPuesto,buscaResponsable);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getRemitenteFrame:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}

    /**
     * Regresa los Remitentes por UA, Puesto y Responsable 
     * @param strIdArea Unidad Administrativa 
     * @param buscaPuesto Puesto 
     * @param buscaResponsable Responsable
     * @return Regresa un String[][] con los registros correspondientes
     */
    public static String[][] getRemitenteInternas(String strIdArea, String buscaPuesto, String buscaResponsable)
	{	
		try
		{
			String strsql = SQLRemitente.getRemitenteInternas(strIdArea,buscaPuesto,buscaResponsable);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getRemitenteInternas:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
    
    /**
     * Regresa el Estatus de un remitente 
     * @param strIdRemitente ID del remitente
     * @return Regresa un String con el registros correspondientes
     */
    public static String getEstatusRemitente(String strIdRemitente)
	{		
		try
		{
			String strsql = SQLRemitente.getEstatusRemitente(strIdRemitente);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strResult!=null && strResult.length > 0)
			    return strResult[0][0];
			else 
				return "";
		}
		catch(SQLException sqle)
		{
			//System.out.println("getEstatusRemitente"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}	
	}

    /**
     * Regresa el ID de la UA del remitente
     * @param strIdRemitente ID del remitente
     * @return Regresa un String con el registros correspondientes
     */
    public static String getIdArea(String strIdRemitente)
	{		
		try
		{
			String strsql = SQLRemitente.getIdArea(strIdRemitente);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strResult!=null && strResult.length > 0)
			    return strResult[0][0];
			else 
				return "";
		}
		catch(SQLException sqle)
		{
			//System.out.println("getIdArea:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}	
	}
    
    /**
     * Función que regresa el registro de un remitente con su entidad
     * @param strIdRemitente ID del remitente
     * @return Regresa un String con el registros correspondientes
     */
    public static String getDestExt(String strIdRemitente)
	{		
		try
		{
			String strsql = SQLRemitente.getDestExt(strIdRemitente);
			////System.out.println("getDestExt:"+strsql);
			String strResult[][] = ConexionDS.ejecutarSQL(strsql); 
			if(strResult!=null && strResult.length > 0)
			    return strResult[0][0];
			else 
				return "";
		}
		catch(SQLException sqle)
		{
			//System.out.println("getDestExt:"+sqle.getMessage());
			sqle.printStackTrace();
			return "";
		}	
	}
}
