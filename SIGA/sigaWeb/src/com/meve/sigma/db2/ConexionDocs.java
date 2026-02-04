//*******************************************************************************************/
//																							//
//		Nombre Archivo	:	ConexionDocs.java												//
//		Package	        :	com.meve.sigma.db2													//
//		Descripción	:	Esta clase crea una conexión con DB2 a partir de un JNDI, 		//
//							utilizando un DataSource. Tiene Métodos para hacer consultas, 	//
//							inserciones,actualizaciones ó borrado de registros.También 	//
//							puede insertar y obtener objetos de tipo Blob.          	//
//		Empresa			:	Secretaria de Hacienda y Credito Publico			        //
//		página Web		:	www.shcp.gob								//
//		Autor			:	Miguel David Hernandez Canche                                   	//
//		Contacto		:	mcanche@hotmail.com             					//
//		Fecha			:	18/11/2010														//
//		Versión			:	1.0																//
//		Modificaciones	:																	//
//		Fecha Ult Mod	:																	//
//																							//
//*******************************************************************************************/


package com.meve.sigma.db2;

import java.io.OutputStream;
//import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.sql.BLOB;


/*******************************************
 * Esta clase crea una conexión con DB2 a partir de un JNDI, 		//
 	utilizando un DataSource. Tiene Métodos para hacer consultas, 	//
	inserciones,actualizaciones ó borrado de registros.También 
 * @author	David Contreras Cortés - Doogie.
 *******************************************/

public class ConexionDocs 
{
	private	static	String	strJndi="jdbc/SIGA_DOC";
	
	/********************************************************************
	 * Función que obtiene una nueva conexión del DataSource.
	 * 
	 * @return	Regresa un obejto Connection, que es la conexión obtenida
	 * 			del DataSource.
	 ********************************************************************/
	private static Connection getConexion() throws SQLException,NamingException
	{
		Context	ctxContexto = new InitialContext();
		DataSource dsOrigenDatos = (DataSource) ctxContexto.lookup(strJndi);
		ctxContexto.close();
		return dsOrigenDatos.getConnection();
	}
	
	/********************************************************************
	 * Función que cierra la conexión in que se le pasa como parámetro.
	 * 
	 * @param con	Es un objeto de tipo Connection, que es la conexión 
	 * 				referente al DataSource que se desea cerrar.
	 ********************************************************************/
	private static void cerrarConexion(Connection con) throws SQLException
	{
		if( con != null)
		{
			try
			{
				if(!con.isClosed())
					con.close();
			}catch(SQLException sqlEx)
			{
				System.out.println(sqlEx.getStackTrace());
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
	public static String[][] ejecutarSQL(String strQuery) throws SQLException
	{
		String strResultado[][]=null;
		Vector vRegistros = new Vector();
		int iColumnas=0;
		int i;
		Connection con=null;
		try
		{
			con= getConexion();
			PreparedStatement pstSentencia = con.prepareStatement(strQuery);
			ResultSet rsConsulta = pstSentencia.executeQuery();
			ResultSetMetaData rsmdMeta = rsConsulta.getMetaData();
			iColumnas = rsmdMeta.getColumnCount();
			
			while(rsConsulta.next())
			{
				String[] strRegistro = new String[iColumnas];
				
				for(i=0;i<iColumnas;i++)
				{
					strRegistro[i]=eliminaNulo(rsConsulta.getString(i+1));
				}
				
				vRegistros.add(strRegistro);
			}
			
			rsConsulta.close();
			pstSentencia.close();
			con.commit();
			
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
		}finally
		{
			cerrarConexion(con);
		}
		
		if(vRegistros.size()>0)
		{
		
			strResultado =  new String[vRegistros.size()][iColumnas];
		
			for(i=0;i<vRegistros.size();i++)
			{
				strResultado[i]=(String[])vRegistros.elementAt(i);
			}
		}
		else
			strResultado=null;	
		
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
			
			throw new SQLException("Error al ejecutar query: " + sqlEx.toString());
			
		}catch(NamingException namEx)
		{
			throw new SQLException("No se pudo ejecutar el query: " + namEx.toString());
		}finally
		{
			cerrarConexion(con);
		}
		return registros;
	} 
	
	/*******************************************************************
	 * Función que inserta un objeto Blob en la BDs.
	 * 
	 *@param	strSql		Es un String que contiene la sentencia sql
	 * 						para insertar un objeto Blob.
	 * @param	byArchivo	Es un arreglo de bytes que es el archivo en
	 * 						forma de bytes.
	 * @return	Regresa un boolean, true en caso de que el Blob se haya
	 * 			insertado correctamente y false en caso de que no se haya 
	 * 			podido insertar.
	 ********************************************************************/
	public static boolean insertaBlob(String strSql, byte[] byArchivo) throws SQLException
	{
		Connection con=null;//BUENO
				
		try{	
			//ConnectionPool Cpool= new ConnectionPool();//BUENO
			//con=(OracleConnection)Cpool.getConnection();//BUENO
                        try{
                            con=getConexion();
                        }catch(Exception e){System.out.println(e.getMessage());}
			 
			if(con!=null){			
				//System.out.println("si Entró blob="+strSql);
				//BLOB blob = BLOB.createTemporary(con,true, BLOB.DURATION_CALL);
				BLOB blob = BLOB.createTemporary(con,true, BLOB.DURATION_SESSION);				
				OutputStream blobos = blob.getBinaryOutputStream();				
				blobos.write(byArchivo);				
				blobos.flush();				
				PreparedStatement pst = con.prepareStatement(strSql);				
				pst.setBlob(1,blob);					
				int i=0;				
				i=pst.executeUpdate();				
				con.commit();				
				con.close();
				//System.out.println("termina inserción");
				
			}else{
				System.out.println("no Entró blob");
				return false;
			}
			return true;
		}catch(SQLException s){
			s.printStackTrace();
			try{
			con.rollback();
			}catch(Exception e) {
				s.printStackTrace();	
			}				
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		} finally {
            try{
            	cerrarConexion(con);
            }catch(Exception e) {
            	System.out.println(e.getStackTrace());
            };
        }	
	
	}
	
	/*******************************************************************************
	 * Función que regresa el objeto Blob que se obtenga al realizar la consulta del 
	 * campo blob, el archivo es el correspondiente al parametro que se le pasa.
	 * 
	 * @param	strNombreColumna	Es un String que contiene el nombre del archivo
	 * 								que se extraerá de la BDs.
	 * @return	Regresa un arreglo de bytes que corresponden al archivo que se
	 * 			obtuvo de la consulta, con el nombre que se le paso como parámetro.
	 *******************************************************************************/
	public static byte[] getBlob(String strSql,String strNombreColumna) throws SQLException
	{
		Blob blob=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs =null;
		byte[] array=null;
		
		try
		{
			con = getConexion();
			pst = con.prepareStatement(strSql);
			rs=pst.executeQuery();
			if(rs.next())
			{
				blob = rs.getBlob(strNombreColumna);
				array=blob.getBytes(1,(int)blob.length());
			}
			return array;
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
			throw new SQLException("no se pudo ejecutar el query: " + namEx.toString());
		}
		finally
		{
			cerrarConexion(con);
			//return array;
		}
		
		
	}
	
}

