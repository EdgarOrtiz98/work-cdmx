package com.meve.sigma.db2;

/**
* Clase que contiene metodos para la Obtencion de una conexion a la Base de Datos usando el DriverConnection
*
* @author  Gustavo Gonzalez Esquivel gustavo_g_e@hotmail.com
* @version 1.0
* @see     http://java.sun.com/
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
//import java.net.*;
import javax.sql.DataSource;

public class ConnectionPool {
	
	/*private  String strUser;
	private  String strPassword;
	private  String strDriverType;
	private  String strPortNumer;
	private  String strDataBaseName;
	private  String strServerName;*/
	private	static	String	strJndi="jdbc/ds1sigma";

	public   ConnectionPool()
	{
		/*strUser="sigmadoc";
		strPassword="sigmadoc";
		strDriverType="thin";
		strPortNumer="1521";
		strDataBaseName="sigmadoc";
		strServerName="192.168.0.6";*/
	}
	/********************************************************************
	 * Función que obtiene una nueva conexión del DataSource.
	 * 
	 * @return	Regresa un obejto Connection, que es la conexión obtenida
	 * 			del DataSource.
	 ********************************************************************/
	public static Connection getConnection()
	{

		try
		{
	       
                    //DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());		     
                    //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@172.20.7.64:1521:DSIGA","SIGA","ensure38"); //DESARROLLO
                    
                    Context ctxContexto = new InitialContext();
                    DataSource dsOrigenDatos = (DataSource) ctxContexto.lookup("java:comp/env/" + strJndi);
                    ctxContexto.close();


                    return dsOrigenDatos.getConnection();		   								     
		     
		    
				
		}catch(Exception e)
		{
			//System.out.println("Error ----> " + e.toString());
			return null;
		}
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
	public static String[][] ejecutarSQL(String strQuery) throws SQLException{
	    String strResultado[][]=null;
	    Vector vRegistros = new Vector();
	    int iColumnas=0;
	    int i;
	    Connection con=null;
	    try{
	        con= getConnection();
	        PreparedStatement pstSentencia = con.prepareStatement(strQuery);
	        ResultSet rsConsulta = pstSentencia.executeQuery();
	        ResultSetMetaData rsmdMeta = rsConsulta.getMetaData();
	        iColumnas = rsmdMeta.getColumnCount();
	        while(rsConsulta.next()){
	            String[] strRegistro = new String[iColumnas];							
	            for(i=0;i<iColumnas;i++)
	                strRegistro[i]=eliminaNulo(rsConsulta.getString(i+1));
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
	}catch(Exception Ex){
	            try {
	                con.rollback();
	            }catch(SQLException rollEx){
	                throw new SQLException("Error al realizar el rollback: " + rollEx.toString());
	        }
	        throw new SQLException("Error General al ejecutar el query: " + Ex.toString());
	}finally{
		//cerrarConexion(con);
		con.close();
	}
	
	strResultado =  new String[vRegistros.size()][iColumnas];
	
	for(i=0;i<vRegistros.size();i++)
		strResultado[i]=(String[])vRegistros.elementAt(i);
	
	return strResultado;
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
		
	public static int ejecutarActualizacion(String query)throws SQLException
	{ 

		Connection con = null;
		int registros  = 0;

		try 
		{
			con = getConnection();
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
			
		}finally
		{
			con.close();
		}
		return registros;
	} 	
}	