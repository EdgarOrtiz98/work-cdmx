/*
 * Creado el 29/01/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.servlet;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import oracle.ifs.fdk.AttributeRequest;
import oracle.ifs.fdk.Attributes;
import oracle.ifs.fdk.CommonManager;
import oracle.ifs.fdk.FdkConstants;
import oracle.ifs.fdk.FdkException;
import oracle.ifs.fdk.FileManager;
import oracle.ifs.fdk.Item;
import oracle.ifs.fdk.NamedValue;
import oracle.ifs.fdk.Options;
import oracle.ifs.fdk.SearchExpression;
import oracle.ifs.fdk.SearchManager;

import com.meve.oracle.cm.WsConnection;
import com.meve.oracle.cm.WsUtility;

/**
 * Busqueda de archivos por contenido
 * @author Enrique
 *
 */
public class SearchArchive {
	
	  /**
	   * Busca en CS archivos sobre contenido
	   * 
	   * @param strArchivo	Nombre del Folder
	   * @param strBusqueda	Cadena que contiene el criterio de Búsqueda
	   * @param strAsunto	Nombre del asunto
	   * @param strUriContent	Url para ivocar al ws de OCS
	   * @param strUserContet	Usuario de content
	   * @param strPassContent	Password de content}
	   * @param strPathContent	Ruta del espacio de trabajo del CS
	   */
	 
	 public static String[] busquedaSobroContenidos(String strArchivo, String strBusqueda, String strAsunto, 
	 											String strUriContent, String strUserContet, String strPassContent,
												String strPathContent, WsConnection s_WsCon){
	 	
	 	String[] strCoincidencias = null;
	 	try
	    {		
			// URL to content services web services servlet
	  		FileManager fm = s_WsCon.getFileManager();
	  		CommonManager cm = s_WsCon.getCommonManager();
	  		Item workspace = fm.resolvePath( strPathContent + "/" + strAsunto , null);   	  		       				
  			strCoincidencias = contentSearch(strBusqueda, workspace , strArchivo, s_WsCon, strAsunto); 
  			return strCoincidencias;

	    }
		catch(Throwable t){
			t.getCause();
		//	System.out.println(t.toString());
			////System.out.println("Aún no existen documentos para este Asunto/Instruccion");
			//strCoincidencias[0] = "-1";
			return strCoincidencias;
  		}
	 
	 }
	
	 /**
	   * Busqueda basada en contenidos
	   * 
	   * @param searchString item contents.
	   * 
	   * @throws FdkException if a high level error occurs.
	   * @throws RemoteException if a low-level remote error occurs.
	   */									
	  public static String[] contentSearch(String searchString, Item folder, String strFolder,WsConnection s_WsCon, String strAsunto)
	    throws RemoteException, FdkException, Exception
	  {
	  	
	  	GregorianCalendar gcFecha;
	  	NamedValue[] attributes;
	  	String[]strCoincidencias = null;	  	
	  	String[] nombreArchivo = null;
	    String strFechaArchivo;
	    String strLongArchivo;
	    String strNombreArchivo;
	    
	  	// get the Manager instances
	    SearchManager sem = s_WsCon.getSearchManager();

	    // get the attributes of item
	    AttributeRequest[] doc_attr = new AttributeRequest[] { 
	  		  WsUtility.newAttributeRequest(Attributes.SIZE),
	  		  WsUtility.newAttributeRequest(Attributes.CREATE_DATE)};
	    
	    // define search options
	    NamedValue[] nv = WsUtility.newNamedValueArray(new Object[][] {
	      { Options.FOLDER_RESTRICTION, new Long(folder.getId()) },
	      { Options.SEARCH_VERSION_HISTORY, Boolean.TRUE },
	      { Options.RETURN_COUNT, new Integer(100) } });

	    // get search expresiion
	    SearchExpression seExp = new SearchExpression();
	    SearchExpression seExpLeft = new SearchExpression();
	    SearchExpression seExpRigth = new SearchExpression();
	    
	    // If the value does not contain an explicit wildcard character
	    // then add a wildcard at both ends
	    if ((searchString.indexOf('*') < 0) && (searchString.indexOf('?') < 0))
	    {
	      searchString = "*" + searchString + "*";
	    }
	   // //System.out.println("Cadena de busqueda = " + searchString );
	    // for content search left hand operand is not required
	    seExpRigth = new SearchExpression();
	    seExpRigth.setOperator(FdkConstants.OPERATOR_CONTAINS);
	    seExpRigth.setRightOperand(searchString);
	   
	    seExpLeft = new SearchExpression();
	    seExpLeft.setOperator(FdkConstants.OPERATOR_EQUAL);
	    seExpLeft.setLeftOperand(Attributes.NAME);
	    seExpLeft.setRightOperand(strFolder);
	    
	    seExp = new SearchExpression();
	    seExp.setLeftOperand(seExpLeft);
	    seExp.setOperator(FdkConstants.OPERATOR_AND);
	    seExp.setLeftOperand(seExpRigth);
	    
	    // search documents
	    NamedValue[] result = sem.search(seExpRigth, nv, doc_attr);

	    // search result display
	    WsUtility.log("search items based upon contents");
	    for (int i = 0; i < result.length; i++)
	    {
	      if (result[i].getName().equals(Options.SEARCH_RESULTS))
	      {
	        Item[] resulItem = (Item[]) result[i].getValue();
	        if (resulItem != null)
	        {	
	        	strCoincidencias = new String[1];
	          for (int j = 0; j < resulItem.length; j++)
	          {
	          	
	          	attributes = resulItem[j].getRequestedAttributes();
	            strLongArchivo = attributes[0].getValue().toString();
	            gcFecha = (GregorianCalendar)attributes[1].getValue();
	            strFechaArchivo = 	gcFecha.get(Calendar.MONTH) + "/"+ gcFecha.get(Calendar.DAY_OF_MONTH) + "/" +
	            gcFecha.get(Calendar.YEAR);			
	            strNombreArchivo = resulItem[j].getName();    
	            
	            if (resulItem[j].getName().toString().equals(strFolder) ){
	            	strCoincidencias[0] = strNombreArchivo+"|"+strLongArchivo+"|"+strFechaArchivo+"|"+strAsunto;
	            //	//System.out.println("......" + strCoincidencias[0]);
	            }    		            
	          }
	        }
	      }
	    }
	    	    
	    if (strCoincidencias != null )
            ;
	       // //System.out.println("archives " + strCoincidencias.length );	    
	    return strCoincidencias;
	  }
	  
}
