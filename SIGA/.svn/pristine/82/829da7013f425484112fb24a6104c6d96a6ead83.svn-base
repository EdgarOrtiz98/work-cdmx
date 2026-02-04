package com.meve.sigma.db2;

/**
* Clase que contiene metodos para Lenguaje de Definicion de Datos y  Lenguaje de
* Manipulacion de Datos hacia la base datos de Oracle y usando un Datasoruce para la conexion.
*
* @author  Gustavo Gonzalez Esquivel gustavo_g_e@hotmail.com
* @version 1.0
* @see     http://java.sun.com/
*/


//import com.meve.sigma.util.ServiceLocator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//import javax.sql.*;

/*******************************************
 * @author	Gustavo Gonzalez Esquivel.
 *******************************************/

public class ConexionDS 
{
	private	static	String	strJndi="jdbc/ds1sigma";
	
	/********************************************************************
	 * Función que obtiene una nueva conexión del DataSource.
	 * 
	 * @return	Regresa un obejto Connection, que es la conexión obtenida
	 * 			del DataSource.
	 ********************************************************************/
	public static Connection getConexion() throws SQLException,NamingException
	{
		Context	ctxContexto = new InitialContext();
                
		DataSource dsOrigenDatos = (DataSource) ctxContexto.lookup("java:comp/env/" + strJndi);
                ctxContexto.close();
                //System.out.println("Abriendo Conexion");
		return dsOrigenDatos.getConnection();
	}
	
	/********************************************************************
	 * Función que cierra la conexión in que se le pasa como parámetro.
	 * 
	 * @param con	Es un objeto de tipo Connection, que es la conexión 
	 * 				referente al DataSource que se desea cerrar.
	 ********************************************************************/
	public static void cerrarConexion(Connection con) throws SQLException
	{
		if( con != null)
		{
			try
			{
				if(!con.isClosed())
					con.close();
			}catch(SQLException sqlEx)
			{
				throw new SQLException("Error al cerrar la conexión: " + sqlEx.toString());
			}
		}
	}
	
	/********************************************************************
	 * Función que elimina valores nulos, es decir, evalúa si el valor
	 * que es pasado como parámetro, tiene un valor nulo o contiene el texto 
	 * NULL.
	 * 
	 * @param	strCampo	Es un String que contiene el valor a evaluar.
	 * 
	 * @return	Regresa un String que contiene el valor incial en caso de que
	 * 			el objeto no se nulo o no contenga el valor NULL. En caso 
	 * 			contrario regresa una cadena vacía.
	 *********************************************************************/
	private static String eliminaNulo(String strCampo)
	{
		if(strCampo == null)
			strCampo="";
		if(strCampo.equalsIgnoreCase("NULL"))
			strCampo="";
		
		return strCampo.trim();
	}
	
	/*****************************************************************************
	 * Función que realiza la ejecución de una consulta. Esta Función solo realiza
	 * consultas.
	 * 
	 * @param strQuery	Es un String que contiene la consulta que se ejecutará.
	 * 
	 * @return	Regresa un String[][] que contiene el resultado de la consulta.
	 * 			En caso de que la consulta no contenga datos, el valor 
	 * 			retornado es null.			
	 *****************************************************************************/
//Muy peligroso este metodo, alenta la aplicacion abriendo y cerrando conexiones
	public static String[][] ejecutarSQL(String strQuery) throws SQLException{
            String strResultado[][]=null;
            Vector vRegistros = new Vector();
            int iColumnas=0;
            int i;
            Connection con=null;
            try{
                con= getConexion();
                PreparedStatement pstSentencia = con.prepareStatement(strQuery);
                ResultSet rsConsulta = pstSentencia.executeQuery();
                ResultSetMetaData rsmdMeta = rsConsulta.getMetaData();
                iColumnas = rsmdMeta.getColumnCount();
                while(rsConsulta.next()){
                    String[] strRegistro = new String[iColumnas];
                    
                    for(i=0;i<iColumnas;i++) {
                    	String type =rsmdMeta.getColumnTypeName(i+1);
                    	if(!type.equals("BLOB"))
                    		strRegistro[i]=eliminaNulo(rsConsulta.getString(i+1));
                    	else {
                    		if(rsConsulta.getBytes(i+1) != null) {
                    			strRegistro[i]=rsConsulta.getBytes(i+1).toString();
                    		}else {
                    			strRegistro[i]="";
                    		}
                    	}
                    }
                    vRegistros.add(strRegistro);
             }
		rsConsulta.close();
		pstSentencia.close();
		//con.commit();
		}catch(SQLException sqlEx){
                    sqlEx.printStackTrace();
                    try{
                        con.rollback();
                    }catch(SQLException rollEx){
                        throw new SQLException("Error al realizar el rollback: " + rollEx.toString());
                    }
                    throw new SQLException("Error al ejecutar el query: " + sqlEx.toString());
		}catch(NamingException namEx){
                    throw new SQLException("Error no se puedo ejecutar el query: " + namEx.toString());
		}catch(Exception Ex){
                    try {
                        con.rollback();
                    }catch(SQLException rollEx){
                        throw new SQLException("Error al realizar el rollback: " + rollEx.toString());
                    }
                    throw new SQLException("Error General al ejecutar el query: " + Ex.toString());
		}finally{
			cerrarConexion(con);
		}
		
		strResultado =  new String[vRegistros.size()][iColumnas];
		
		for(i=0;i<vRegistros.size();i++)
			strResultado[i]=(String[])vRegistros.elementAt(i);
		
		return strResultado;
	}
	
	
	/************************************************************************
	 * Función que realiza la inserción, Actualización o borrado de registros
	 * por medio  de una sentencia sql.
	 * 
	 * @param	query	Es un String que contiene sql que se ejecutará.
	 * 
	 * @return	Regresa un valor entero. Regresa el numero de registros que
	 * 			fueron actualizados.En caso de que el valor regresado sea 0
	 * 			significa que no se actualizá ningun registro.
	 ************************************************************************/
	public static int ejecutarActualizacion(String query)throws SQLException
	{ 

		Connection con = null;
		int registros  = 0;

		try 
		{
			con = getConexion();
			//System.out.println("query="+query);
			PreparedStatement pstmt = con.prepareStatement(query);
			registros = pstmt.executeUpdate();

			pstmt.close();
			con.commit();

		}catch(SQLException sqlEx)
		{
			try
			{
				con.rollback();
				
			}catch(SQLException rollEx)
			{
				throw new SQLException("Error al realizar rollback: " + rollEx.toString());
			}
			
			throw new SQLException("Error al ejecutar query de delete: " + sqlEx.toString());
			
		}catch(NamingException namEx)
		{
			throw new SQLException("No se pudo ejecutar el query de delete: " + namEx.toString());
		}finally
		{
			cerrarConexion(con);
		}
		return registros;
	} 
	public static void adquiereCommit()throws SQLException
	{
		Connection con = null;
		try 
		{
			con = getConexion();
			con.commit();
		}catch(SQLException sqlEx)
		{
			try
			{
				con.rollback();				
			}catch(SQLException rollEx)
			{
				throw new SQLException("Error al realizar rollback: " + rollEx.toString());
			}			
			throw new SQLException("Error al ejecutar query: " + sqlEx.toString());			
		}catch(NamingException namEx)
		{
			throw new SQLException("No se pudo ejecutar el query: " + namEx.toString());
		}finally
		{
			cerrarConexion(con);
		}	
	}
	
	
	public static String[][] ejecutarSQL1(String strQuery) throws SQLException
	{
		String strResultado[][]=null;
		Vector vRegistros = new Vector();
		int iColumnas=0;
		int i;
		Connection con=null;
		try
		{
			con= getConexion();
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//PreparedStatement pstSentencia = s.prepareStatement(strQuery);
			//ResultSet rsConsulta = pstSentencia.executeQuery();
			ResultSet rs = s.executeQuery(strQuery);
			ResultSetMetaData rsmdMeta = rs.getMetaData();
			iColumnas = rsmdMeta.getColumnCount();
			rs.absolute(10);
			while(rs.next())
			{
				String[] strRegistro = new String[iColumnas];							
				for(i=0;i<iColumnas;i++)
				{
					strRegistro[i]=eliminaNulo(rs.getString(i+1));
				}
				
				vRegistros.add(strRegistro);
			}
			
			rs.close();
			s.close();
			//con.commit();
			
		}catch(SQLException sqlEx)
		{
			try 
			{
					con.rollback();
			}catch(SQLException rollEx)
			{
				throw new SQLException("Error al realizar el rollback: " + rollEx.toString());
			}
			throw new SQLException("Error al ejecutar el query: " + sqlEx.toString());
			
		}catch(NamingException namEx)
		{
			throw new SQLException("Error no se puedo ejecutar el query: " + namEx.toString());
		}
		catch(Exception Ex)
		{
			try 
			{
					con.rollback();
			}catch(SQLException rollEx)
			{
				throw new SQLException("Error al realizar el rollback: " + rollEx.toString());
			}
			throw new SQLException("Error General al ejecutar el query: " + Ex.toString());
			
		}finally
		{
			cerrarConexion(con);
		}
		
		strResultado =  new String[vRegistros.size()][iColumnas];
		
		for(i=0;i<vRegistros.size();i++)
		{
			strResultado[i]=(String[])vRegistros.elementAt(i);
		}
		
		return strResultado;
	}
	
	/**
	 * 
	 * @param rs
	 * @param pstmt
	 * @param conn
	 * @return
	 */
	public static boolean endConnection(ResultSet rs, PreparedStatement pstmt,
			Connection conn) {
		boolean result = false;
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
				result = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/*public static Connection getConexionQ(String user, String pass, String driverType, 
			String portNumer, String db, String sn) {

		try {
			String urlDB = "jdbc:oracle:" + driverType + ":@"
					+ sn + ":" + portNumer + ":"
					+ db;
			OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
			ds.setURL(urlDB);
			return ds.getConnection(user, pass);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/

}

