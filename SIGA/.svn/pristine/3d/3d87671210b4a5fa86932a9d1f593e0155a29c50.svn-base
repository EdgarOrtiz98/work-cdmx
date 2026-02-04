/*
 * Created on Oct 30, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.meve.sigma.servlet;

import oracle.ifs.fdk.FileManager;
import oracle.ifs.fdk.Item;

import com.meve.oracle.cm.ConnectionWebService;
import com.meve.oracle.cm.WsConnection;
import com.meve.oracle.cm.WsUtility;

import com.meve.sigma.db2.ConexionDocs;
import com.meve.sigma.sql.SQLDocs;

import java.rmi.RemoteException;
import java.util.Map;

import oracle.ifs.fdk.AttributeRequest;
import oracle.ifs.fdk.Attributes;
import oracle.ifs.fdk.ClientUtils;
import oracle.ifs.fdk.CommonManager;
import oracle.ifs.fdk.FdkConstants;
import oracle.ifs.fdk.FdkException;
import oracle.ifs.fdk.NamedValue;
import oracle.ifs.fdk.NamedValueSet;
import oracle.ifs.fdk.Options;
import oracle.ifs.fdk.SearchExpression;
import oracle.ifs.fdk.SearchManager;
import oracle.ifs.fdk.SecurityManager;
import oracle.ifs.fdk.TrashManager;
import oracle.ifs.fdk.UserManager;

/**
 * Mueve el contenido de una carpeta a otra y borra la carpeta anterior
 * @author Meve Soluciones
 * @version 1.0
 *
 */
public class FolderAsunto {
	
	  /**
	   * Mueve los archivos de una carpeta a otra.
	   * 
	   * @param strIdAsunto	Id asunto
	   * @param strFolio	Folio asunto
	   * @param strUriContent	Url para ivocar al ws de OCS
	   * @param strUserContet	Usuario de content
	   * @param strPassContent	Password de content}
	   * @param strPathContent	Ruta del espacio de trabajo del CS
	   */
	
	public static void moveArchives (String strIdAsunto, String strFolio, String strUriContent, String strUserContet, String strPassContent,
									 String strPathContent){
		
		try
	    {

			WsConnection s_WsCon; 
	        
			// URL to content services web services servlet
			String serverUrl = strUriContent +"/content/ws";
	      
			// authenticate to content services
        	ConnectionWebService c = new ConnectionWebService(strUriContent, strUserContet, strPassContent);
        	s_WsCon = c.conectaOcs();
        
	  		FileManager fm = s_WsCon.getFileManager();
	  		CommonManager cm = s_WsCon.getCommonManager();
	  		Item workspace = fm.resolvePath(strPathContent, null);
	  		//Item workspace = fm.resolvePath("/hacienda/SIGA_WS/SIGA_LIB", null);
	    
	  		Item[] ItArchives = null;
	  		Item   ItFolderRecep = null;
	      
	  		try
			{
	  			try{
	      	
	  				Item ItFolder = searchFolder(strIdAsunto,s_WsCon);
	      
	  				if (ItFolder != null){
	      		
	  					AttributeRequest[] urlAR = 
	  						WsUtility.newAttributeRequestArray(Attributes.NAME);

	  					ItArchives = searchItems(ItFolder,s_WsCon);
	      	
	  					ItFolderRecep =
	  						createFolder(strFolio, strIdAsunto, workspace,s_WsCon);
	  					
	  					for (int i = 0; ItArchives.length > i; i++ ){
	  						moveDocument(ItArchives[i], ItFolderRecep,s_WsCon);
	  					}
	  					deleteFolder(ItFolder,s_WsCon);
	  					cleanup(ItFolder,s_WsCon);
	
	  				}
	  			}catch(Throwable t){
	  				//System.out.println("Aún no existen documentos para este Asunto/Instruccion");
	  			}
	      }
	      finally
	      {
	      	
	      	s_WsCon.logout();
	      }
	    }
	    catch (Throwable t)
	    {
	      t.printStackTrace();
	    }
		
	}
	
  /**
   * Busca un Folder en particular
   * 
   * @param searchString	Cadena que contiene el nombre del objeto a buscar
   * @param s_WsCon	Objeto conexión WS
   * 
   * @return  Regresa el folder item
   * 
   * @throws FdkException    Si ocurre un high-level error.
   * @throws RemoteException    Si ocurre un error durante la ejecución de un Método remoto
   */
	
	public static Item searchFolder(String searchString, WsConnection s_WsCon)
    throws FdkException, RemoteException, Exception
  {
  	boolean search = false;
  	Item[] resulItem = null;
  	Item folder = null;
  	
    // get the Manager instances
  	FileManager fm = s_WsCon.getFileManager();
    SearchManager sem = s_WsCon.getSearchManager();
    ////System.out.println("Attributes.URL->"+Attributes.ATTRIBUTE_NAME);
    AttributeRequest[] urlAR = WsUtility.newAttributeRequestArray(Attributes.URL);

    NamedValue[] nv = WsUtility.newNamedValueArray(new Object[][] {
      { Options.SEARCH_VERSION_HISTORY, Boolean.TRUE },
      { Options.SEARCH_FOR_DOCUMENTS, Boolean.FALSE },
      { Options.SEARCH_FOR_FOLDERS, Boolean.TRUE },
      { Options.RETURN_COUNT, new Integer(100) } });

    // get search expresiion
    SearchExpression seExp = new SearchExpression();
    // add a wildcard at both ends
    //if ((searchString.indexOf('*') < 0) && (searchString.indexOf('?') < 0))
    //{
    //  searchString = "*" + searchString + "*";
    //}
    //System.out.println("searchString   .... "+searchString);
    seExp = new SearchExpression();
    seExp.setOperator(FdkConstants.OPERATOR_EQUAL);
    seExp.setLeftOperand("NAME");
    seExp.setRightOperand(searchString);

    // search documents
    NamedValue[] result = sem.search(seExp, nv, urlAR);
    // search result display
    //WsUtility.log("search items based upon attribute value");
    //System.out.println("leght->"+result.length);
    for (int i = 0; i < result.length; i++)
    {
      if (result[i].getName().equals(Options.SEARCH_RESULTS))
      {
      	////System.out.println("result[i].getName()"+result[i].getValue());
        resulItem = (Item[]) result[i].getValue();
        if (resulItem != null)
        {
        	
          for (int j = 0; j < resulItem.length; j++)
          {
            //WsUtility.log(resulItem[j].getName());
          //	System.out.println(resulItem.length);
            ////System.out.println("Nombre->"+resulItem[j].getName());
           // //System.out.println("typo->"+resulItem[j].getType());
          }
        }
      }
    }
    folder = resulItem[0];    
    return folder;
    
  }
	  /**
	   * Busca archivos dentro de un Folder en especifico
	   * 
	   * @param folder	Nombre del folder
	   * @param s_WsCon	Objeto conexión WS
	   * 
	   * @return regresa un arrayde tipo Item que contiene el o los archivos
	   * 
	   * @throws FdkException    Si ocurre un high-level error.
	   * @throws RemoteException    Si ocurre un error durante la ejecución de un Método remoto
	   */
	
	public static Item[] searchItems(Item folder, WsConnection s_WsCon) throws FdkException, RemoteException
	  	  {
	  	    // get the Manager instances
	  	    SearchManager sem = s_WsCon.getSearchManager();
	  	    String searchString = "*";
	  	    // define search options
	  	    NamedValue[] nv = WsUtility.newNamedValueArray(new Object[][] {
	  	      { Options.FOLDER_RESTRICTION, new Long(folder.getId()) },
	  	      { Options.SEARCH_VERSION_HISTORY, Boolean.TRUE },
	  	      { Options.RETURN_COUNT, new Integer(100) } });

	  	    // get search expresiion
	  	    SearchExpression seExp = new SearchExpression();
	  	    // if the value does not contain an explicit wildcard character then
	  	    // add a wildcard at both ends
	  	
	  	    seExp = new SearchExpression();
	  	    seExp.setOperator(FdkConstants.OPERATOR_EQUAL);
	  	    seExp.setLeftOperand(Attributes.NAME);
	  	    seExp.setRightOperand(searchString);

	  	    // search documents
	  	    NamedValue[] result = sem.search(seExp, nv, null);
	  	    // Search result display
	  	    Item[] resulItem = (Item[]) result[0].getValue();
	  	    WsUtility.log("search items in the specified folder");
	  	    for (int i = 0; i < resulItem.length; i++)
	  	    {
	  	      WsUtility.log("archive  " + resulItem[i].getName());
	  	    }
	  	    
	  	    return resulItem;
	  	  }
	
	  /**
	   * Crea un Folder en el espacio de trabajo bajo en el que se logeo
	   * 
	   * @param folderName	Nombre del folder
	   * @param	folderDesc	Descripción del folder
	   * @param parent	Item que representa el Folder
	   * @param s_WsCon	Objeto conexión WS
	   * 
	   * @return un array de tipo Item que representa el folder creado
	   * 
	   * @throws FdkException    Si ocurre un high-level error.
	   * @throws RemoteException    Si ocurre un error durante la ejecución de un Método remoto
	   */
	  public static Item createFolder(String folderName, String folderDesc,
	  	    Item parent, WsConnection s_WsCon) throws FdkException, RemoteException
	  	  {
	  	    FileManager fm = s_WsCon.getFileManager();

	  	    // create folder definition
	  	    NamedValue[] folderDef = 
	  	      WsUtility.newNamedValueArray(new Object[][] { 
	  	        { Attributes.NAME, folderName },
	  	        { Attributes.DESCRIPTION, folderDesc } });

	  	    Item folder = fm.createFolder(parent.getId(), folderDef, null);

	  	    // log created folder
	  	    WsUtility.log(WsUtility.INDENT, folder);

	  	    return folder;
	  	  }
	  
	  /**
	   * Mueve los documentos de una carpeta a otra
	   * 
	   * @param document	Documento
	   * @param	destFolder	Folder destino
	   * @param s_WsCon	Objeto conexión WS
	   * 
	   * @throws FdkException    Si ocurre un high-level error.
	   * @throws RemoteException    Si ocurre un error durante la ejecución de un Método remoto
	   */
	  
	  public static void moveDocument(Item document, Item destFolder, WsConnection s_WsCon)
	    throws FdkException, RemoteException
	  {
	    // get the Manager instances
	    FileManager fm = s_WsCon.getFileManager();
	    CommonManager cm = s_WsCon.getCommonManager();
	    
	    NamedValue[] moveDef = WsUtility.newNamedValueArray(new Object[][] { {
	      Options.DESTFOLDER, new Long(destFolder.getId()) } });

	    NamedValueSet[] moveDefs = new NamedValueSet[] { 
	      WsUtility.newNamedValueSet(moveDef) };

	    Item[] doc = fm.move(new long[] { document.getId() }, null, moveDefs);
	    
	    // document attribute request
	    AttributeRequest[] doc_attr = new AttributeRequest[] { 
	      WsUtility.newAttributeRequest(Attributes.PATH) };
	    
	    WsUtility.log("move document attributes");
	    WsUtility.log(WsUtility.INDENT, cm.getItem(doc[0].getId(), doc_attr));
	  }
	  
	  /**
	   * Set security configuration on folder
	   * 
	   * @param folder the folder item.
	   * @param admin the admin user for folder.
	   * @param author the author user for folder.
	   * @param reader the reader user for folder.
	   * 
	   * @throws FdkException if a high level error occurs.
	   * @throws RemoteException if a low-level remote error occurs.
	   */
	  public static void setSecurity(Item folder, String admin, String author,
	    String reader,WsConnection s_WsCon) throws FdkException, RemoteException
	  {
	    // get the Manager instances we need
	    SecurityManager scm = s_WsCon.getSecurityManager();
	    UserManager um = s_WsCon.getUserManager();
	    // Get users id
	    Item adminUser = um.getUser(admin, null);
	    Item authorUser = um.getUser(author, null);
	    Item readerUser = um.getUser(reader, null);

	    // Retrieve the list of folder roles
	    Item adminRole = scm.getRoleByName("ADMINISTRATOR", null);
	    Item authorRole = scm.getRoleByName("AUTHOR", null);
	    Item readerRole = scm.getRoleByName("READER", null);

	    // create a Grant definition for the folder administrator
	    // notice that a Grant definition is made up of a
	    // GRANTEE and a set of ROLES (here we use just one Role)
	    NamedValue[] fdrAdminGrant = WsUtility.newNamedValueArray(new Object[][] {
	      { Attributes.GRANTEE, new Long(adminUser.getId()) },
	      { Attributes.ROLES, new long[] { adminRole.getId() } } });

	    // create a Grant definition for the folder author
	    // -> notice that a Grant definition is made up of a
	    // GRANTEE and a set of ROLES (here we use just one Role)
	    NamedValue[] fdrAuthorGrant = WsUtility.newNamedValueArray(new Object[][] {
	      { Attributes.GRANTEE, new Long(authorUser.getId()) },
	      { Attributes.ROLES, new long[] { authorRole.getId() } } });

	    // create a Grant definition for the folder reader
	    // -> notice that a Grant definition is made up of a
	    // GRANTEE and a set of ROLES (here we use just one Role)
	    NamedValue[] fdrReaderGrant = WsUtility.newNamedValueArray(new Object[][] {
	      { Attributes.GRANTEE, new Long(readerUser.getId()) },
	      { Attributes.ROLES, new long[] { readerRole.getId() } } });

	    // create the Grant array definition
	    // -> notice that the Grant array definition is made up of three
	    // NamedValue[] definitions, one for each Grant
	    // -> each Grant definition is wrapped in a NamedValueSet instance
	    // to avoid the use of two-dimensional arrays

	    NamedValueSet[] fdrGrants = new NamedValueSet[3];
	    fdrGrants[0] = WsUtility.newNamedValueSet(fdrAdminGrant);
	    fdrGrants[1] = WsUtility.newNamedValueSet(fdrAuthorGrant);
	    fdrGrants[2] = WsUtility.newNamedValueSet(fdrReaderGrant);

	    // security attributes request
	    AttributeRequest[] security_attr = 
	      WsUtility.newAttributeRequestArray(
	        WsUtility.newAttributeRequest(
	          Attributes.GRANTS, WsUtility.newAttributeRequestArray(
	            new String[] {
	              Attributes.GRANTEE, Attributes.ROLES })));
	    
	    // set folder security configuration
	    Item folderSec = scm.setSecurityConfiguration(folder.getId(),
	      WsUtility.newNamedValueArray(new Object[][] { 
	        { Attributes.GRANTS, fdrGrants } }), security_attr);
	    
	    WsUtility.log("folder security attributes");
	    WsUtility.log(WsUtility.INDENT, folderSec);
	  }

	  /**
	   * Elimina un folder en especial
	   * 
	   * @param folder el folder item.
	   * 
	   * @throws FdkException if a high level error occurs.
	   * @throws RemoteException if a low-level remote error occurs.
	   */
	  public static void deleteFolder(Item folder, WsConnection s_WsCon)
	    throws FdkException, RemoteException
	  {
	    // get the Manager instances
	    FileManager fm = s_WsCon.getFileManager();

	    // delete folder
	    fm.delete(new long[] { folder.getId() }, null, null);
	  }
	  
	  /**
	   * Elimina objetos creados
	   * 
	   * @param folder el folder item.
	   * @param	s_WsCon	Objeto conexión WS
	   * 
	   * @throws FdkException if a high level error occurs.
	   * @throws RemoteException if a low-level remote error occurs.
	   */
	  public static void cleanup(Item folder, WsConnection s_WsCon)
	    throws FdkException, RemoteException
	  {
	    // get the Manager instances
	    CommonManager cm = s_WsCon.getCommonManager();
	    FileManager fm = s_WsCon.getFileManager();
	    TrashManager tm = s_WsCon.getTrashManager();

	    // TRASH_FOLDER AttributeRequest array
	    AttributeRequest[] trash_attr = 
	      WsUtility.newAttributeRequestArray(Attributes.TRASH_FOLDER);

	    // get TRASH_FOLDER attribute for folder
	    folder = cm.getItem(folder.getId(), trash_attr);
	    NamedValue[] attrs = folder.getRequestedAttributes();
	    Map attrMap = ClientUtils.namedValuesToMap(attrs);
	    Item trashItem = (Item) attrMap.get(Attributes.TRASH_FOLDER);

	    // delete the folder and empty the Trash
	    fm.delete(new long[] { folder.getId() }, null, null);
	    tm.emptyTrash(trashItem.getId());

	  }
	  /**
	   * Busca archivos con restricción de folder
	   * 
	   * @param	searchString cadena q contiene el nombre del archivo a buscar
	   * @param folder el folder item.
	   * @param	s_WsCon	Objeto conexión WS
	   * 
	   * @return regresa el documenton item
	   * 
	   * @throws FdkException if a high level error occurs.
	   * @throws RemoteException if a low-level remote error occurs.
	   */
	  public static Item searchItemsWithFolderRestriction(
	  	    String searchString, Item folder, WsConnection s_WsCon) throws FdkException, RemoteException
	  	  {
	  		Item search = null;
	  	    // get the Manager instances
	  	    SearchManager sem = s_WsCon.getSearchManager();

	  	    // define search options
	  	    NamedValue[] nv = WsUtility.newNamedValueArray(new Object[][] {
	  	      { Options.FOLDER_RESTRICTION, new Long(folder.getId()) },
	  	      { Options.SEARCH_VERSION_HISTORY, Boolean.TRUE },
	  	      { Options.RETURN_COUNT, new Integer(100) } });

	  	    // get search expresiion
	  	    SearchExpression seExp = new SearchExpression();
	  	    // if the value does not contain an explicit wildcard character then
	  	    // add a wildcard at both ends
	  	    if ((searchString.indexOf('*') < 0) && (searchString.indexOf('?') < 0))
	  	    {
	  	      searchString = "*" + searchString + "*";
	  	     // System.out.println(searchString);
	  	    }
	  	    seExp = new SearchExpression();
	  	    seExp.setOperator(FdkConstants.OPERATOR_EQUAL);
	  	    seExp.setLeftOperand(Attributes.NAME);
	  	    seExp.setRightOperand(searchString);

	  	    // search documents
	  	    NamedValue[] result = sem.search(seExp, nv, null);
	  	    // Search result display
	  	    Item[] resulItem = (Item[]) result[0].getValue();
	  	    WsUtility.log("search items in the specified folder");
	  	    for (int i = 0; i < resulItem.length; i++)
	  	    {
	  	      WsUtility.log(resulItem[i].getName());
	  	    }
	  	    
	  	    search = resulItem[0];
	  	    return search;
	  	    
	  	  }
	  /**
	   * Elimina archivos del OCS
	   * 
	   * @param	strFolio Folio del documento
	   * @param nameArchive	arreglo que contiene el nombre de los archivos a eliminar
	   * @param content	Url para ivocar al ws de OCS
	   * @param userContent	Usuario de content
	   * @param passContent	Password de content}
	   * @param pathContent	Ruta del espacio de trabajo del CS
	   *  
	   */
	  public static void deleteArchives(String strFolio, String nameArchive[], String content, String userContent, String passContent,
	  									String pathContent){
	  	try{
	  			Item newDocumento;
	  			Item workspace;
	  		  	String serverUrl = content+ "/content/ws";
	  		  	WsConnection s_WsCon;
	  		  	//s_WsCon = WsConnection.login(serverUrl, userContent,passContent);
	  			//FileManager fm = s_WsCon.getFileManager();
	  	try {	
				////workspace = fm.resolvePath(pathContent + "/" + strFolio, null);
				for (int i = 0; nameArchive.length > i ; i++){
					/*Item archive = searchItemsWithFolderRestriction(nameArchive[i], workspace,s_WsCon);
					deleteFolder(archive,s_WsCon);
					cleanup(archive,s_WsCon);*/
                                    //Mike     
				    try{//Borra docuemnto en base de datos
				        ConexionDocs.ejecutarActualizacion(SQLDocs.delArchivo(strFolio,nameArchive[i]));                                                                
				    }catch(Exception e){System.out.println(e);}

				}
	  	}catch (Throwable t){
	      t.printStackTrace();
	    }finally{
	        //s_WsCon.logout();
	     }	
	  	}catch(Throwable t){
		      t.printStackTrace();
	    }
	  }
}
