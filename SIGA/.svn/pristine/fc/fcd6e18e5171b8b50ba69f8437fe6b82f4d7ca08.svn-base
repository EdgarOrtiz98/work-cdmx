package com.meve.sigma.servlet;

/*
 * Copyright (c) 2005, Oracle. All rights reserved.
 */

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

import java.rmi.RemoteException;

import java.util.Map;

import com.meve.oracle.cm.ConnectionWebService;
import com.meve.oracle.cm.WsConnection;
import com.meve.oracle.cm.WsUtility;
import com.meve.sigma.actualiza.ActualizaArchivo;

import HTTPClient.Cookie;
import HTTPClient.CookieModule;
import HTTPClient.HTTPConnection;
import HTTPClient.HTTPResponse;
import HTTPClient.HttpOutputStream;
import HTTPClient.ModuleException;
import HTTPClient.ProtocolNotSuppException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import oracle.ifs.fdk.AttributeRequest;
import oracle.ifs.fdk.Attributes;
import oracle.ifs.fdk.CategoryManager;
import oracle.ifs.fdk.ClientUtils;
import oracle.ifs.fdk.FdkConstants;
import oracle.ifs.fdk.FdkException;
import oracle.ifs.fdk.FdkExceptionEntry;
import oracle.ifs.fdk.FileManager;
import oracle.ifs.fdk.Item;
import oracle.ifs.fdk.NamedValue;
import oracle.ifs.fdk.Options;
import oracle.ifs.fdk.SearchExpression;
import oracle.ifs.fdk.SearchManager;
import oracle.ifs.fdk.VersionManager;

import org.apache.commons.fileupload.FileItem;


/**
 * Sube al OCS un documento en particular
 * @author Meve Soluciones
 * @version 1.0
 */
public class Dos {
    /**
     * Verifica el estatus del servicion de content services.
     * 
     * @param uriCont	Url para ivocar al ws de OCS
     * @param userCont	Usuario de content
     * @param passCont	Password de content
     * 
     * @throws RemoteException    Si ocurre un error durante la ejecución de un Método remoto
     */
    public static String statusContent(String uriCont, String userCont, 
                                       String passCont) throws RemoteException {

        WsConnection s_WsCon = null;
        String content = "activo";

        /*try {
            try {
                String serverUrl = uriCont + "/content/ws";
                // authenticate to content services
                ConnectionWebService c = 
                    new ConnectionWebService(uriCont, userCont, passCont);
                s_WsCon = c.conectaOcs();
                return content;
            } finally {
                s_WsCon.logout();
            }

        } catch (Throwable t) {
            //System.out.println("Exception" + t.toString());
            content = t.toString();
            return content;

        }*/
    return content; //Mike 03JUN2011 Eliminacion Content
    }

    /**
     * Guarda en OCS un documento
     * 
     * @param content	Documento a subir
     * @param	strArchivo	Nombre del archivo
     * @param strIdArchivo	Id del archivo
     * @param strFolder	Nombre del Folder
     * @param strIdAsunto	Id del asunto
     * @param uriContent	Url para ivocar al ws de OCS
     * @param usrContent	Usuario de content
     * @param pwdContent	Password de content}
     * @param pathContent	Ruta del espacio de trabajo del CS
     * 
     */
    public static String guardar(FileItem content, String strArchivo, 
                                 String strIdArchivo, String strFolder, 
                                 String strIdAsunto, String uriContent, 
                                 String usrContent, String pwdContent, 
                                 String pathContent) {
        String server = "";
        String user = "";
        String clave = "";
        String folder = "";
        String status = "success";
        String config[];
        int caracter = 0;


        ////System.out.println("uriContent"+uriContent);
        try {
            ////System.out.println("****uriCont****" + uriContent);
            ////System.out.println("****userCont****" + usrContent);
            WsConnection s_WsCon;
            ConnectionWebService c = 
                new ConnectionWebService(uriContent, usrContent, pwdContent);
            s_WsCon = c.conectaOcs();
            try {
                //log-in user's personal workspace 
                FileManager fm = s_WsCon.getFileManager();
                Item workspace = fm.resolvePath(pathContent, null);
                if (strFolder.equals("folio por asignar"))
                    strFolder = strIdAsunto;

                //Search a existing folder
                boolean flag = attributSearch(strFolder, s_WsCon);

                if (flag == false) {
                    //create Folder
                    Item newFolder = 
                        createFolder(strFolder, strFolder, workspace, s_WsCon);
                    Item doc = 
                        uploadDocument(pathContent + "/" + newFolder.getName(), 
                                       "" + strArchivo + "", content, 
                                       strIdArchivo, s_WsCon);

                    return status;
                } else {
                    // create a document using the content
                    Item doc = 
                        uploadDocument(pathContent + "/" + strFolder, "" + 
                                       strArchivo + "", content, strIdArchivo, 
                                       s_WsCon);
                    return status;
                }
            } finally {
                s_WsCon.logout();
            }
        } catch (Throwable t) {
            FdkException error = (FdkException)(t);
            FdkExceptionEntry[] error2;
            error2 = error.getExceptionEntries();

            //get the exception entries
            FdkExceptionEntry[] fdkee = error.getExceptionEntries();

            if (error2 != null) {
                status = error2[0].getDetailedErrorCode();
            } else if (error2 == null) {
                status = error.toString();
            }
            return status;
        }
    }

    /**
     * Sube al CS un documento
     * 
     * @param strFolderPath Ruta del folder donde se guardara el documento
     * @param strDocName	Nombre del documento
     * @param	content	Contenido del documento
     * @param	strIdArchivo	Id de del documento
     * @param s_WsCon	Obejeto de conexión WS
     * 
     * @throws FdkException    Si ocurre un high-level error.
     * @throws IOException     Si ocurre I/O error.
     * @throws ModuleException Si ocurre HTTP error.
     */
    public static Item uploadDocument(String strFolderPath, String strDocName, 
                                      FileItem content, String strIdArchivo, 
                                      WsConnection s_WsCon) throws FdkException, 
                                                                   IOException, 
                                                                   ModuleException {
        // get the Manager instance

        FileManager fm = s_WsCon.getFileManager();
        CategoryManager cm = s_WsCon.getCategoryManager();
        VersionManager versionM = s_WsCon.getVersionManager();

        WsUtility.log("\nLooking up folder " + strFolderPath + " ...");

        // create an AttributeRequest[] for the URL attribute
        AttributeRequest[] urlAR = 
            WsUtility.newAttributeRequestArray(Attributes.URL);
        Item docDef = 
            fm.createDocumentDefinition(WsUtility.newNamedValueArray(new Object[][] { { Attributes.NAME, 
                                                                                        strDocName } }), 
                                        urlAR);

        // get the URL attribute from the docDef Item
        NamedValue[] attrs = docDef.getRequestedAttributes();
        Map attrMap = ClientUtils.namedValuesToMap(attrs);
        String docUrl = (String)attrMap.get(Attributes.URL);
        URL url = new URL(docUrl);
        ////System.out.println("docUrl->"+docUrl);
        // upload content into docDef using HTTP
        HTTPConnection httpCon = createHttpConnection(url, s_WsCon);
        HttpOutputStream escrituraArchivoContent = new HttpOutputStream((int)content.getSize());
        HTTPResponse rsp = 
            httpCon.Put(url.getFile(), escrituraArchivoContent);
        //System.out.println("TamAño: " + content.getSize());
        InputStream flujoEntrada = content.getInputStream();
        int caracteresLeidos = 0;
        byte buffer[] = new byte[2048];
        while ((caracteresLeidos = flujoEntrada.read(buffer)) != -1) {
            escrituraArchivoContent.write(buffer,0,caracteresLeidos);
        }
        escrituraArchivoContent.close();
        flujoEntrada.close();
        // check the response
        if (rsp.getStatusCode() >= 300) {
            ////System.err.println("Error: " + rsp.getReasonLine());
        }
        // create the Document using the docDef
        Item folder = fm.resolvePath(strFolderPath, null);
        ////System.out.println("IdDocumento->"+docDef.getId());
        boolean ac = 
            ActualizaArchivo.updateReferencia(strIdArchivo, new Long(docDef.getId()));

        Item newDoc =
            //{ Options.CATEGORY_DEFINITION, updatecatdef },
            fm.createDocument(WsUtility.newNamedValueArray(new Object[][] { { Options.DESTFOLDER, 
                                                                              new Long(folder.getId()) }, 
                                                                            { Options.NEWVERSION, 
                                                                              Boolean.TRUE }, 
                                                                            { Options.USE_SAVED_DEFINITION, 
                                                                              new Long(docDef.getId()) } }), 
                              null, urlAR);


        return newDoc;
    }





    /**
     * Baja e imprime el contenido del documento.
     * 
     * @param doc Docuemento a bajar.
     * @param s_WsCon	Objeto conexión WS
     * 
     * @throws FdkException    Si ocurre un high-level error.
     * @throws IOException     Si ocurre un I/O error.
     * @throws ModuleException Si ocurre un HTTP error.
     */
    public static void downloadDocument(Item doc, 
                                        WsConnection s_WsCon) throws FdkException, 
                                                                     IOException, 
                                                                     ModuleException {
        // get the URL attribute from the docDef Item
        NamedValue[] attrs = doc.getRequestedAttributes();
        Map attrMap = ClientUtils.namedValuesToMap(attrs);
        String docUrl = (String)attrMap.get(Attributes.URL);
        URL url = new URL(docUrl);
        ////System.out.println("url->"+url.toString());
        // download the document content using HTTP
        HTTPConnection httpCon = createHttpConnection(url, s_WsCon);
        HTTPResponse rsp = httpCon.Get(url.getFile());

        // check the response
        if (rsp.getStatusCode() >= 300) {
            WsUtility.log("Error: " + rsp.getReasonLine());
        }

        // write downloaded content in the file
        WsUtility.log("write downloaded content in the file:");
        InputStream content = rsp.getInputStream();

    }

    /**
     * Crea una HttpConnection para subir o bajar documentos.
     * 
     * @param url  URL  para el docDef Item
     * @param s_WsCon	Objeto conexión WS
     * 
     * @throws ProtocolNotSuppException	Si ocurre un protocolo error.
     */
    private static HTTPConnection createHttpConnection(URL url, 
                                                       WsConnection s_WsCon) throws ProtocolNotSuppException {
        // create the HTTPClient cookie, using the session cookie
        //   -> we specify "/content" as the cookie path because
        //      it is always first in content services URLs
        String[] sessionCookies = s_WsCon.getSessionCookie();
        String sessionCookie = sessionCookies[0];
        Cookie cookie = 
            new Cookie("c1", sessionCookie, url.getHost(), "/content", null, 
                       false);

        // create a context object and add the cookie to it
        Object ctx = new Object();
        CookieModule.addCookie(cookie, ctx);

        // create an HttpConnection to the Document and set its context
        HTTPConnection httpCon = new HTTPConnection(url);
        httpCon.setContext(ctx);

        // turn off interactive mode
        httpCon.setAllowUserInteraction(false);

        return httpCon;
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
                                    Item parent, 
                                    WsConnection s_WsCon) throws FdkException, 
                                                                 RemoteException {
        // get the Manager instances
        FileManager fm = s_WsCon.getFileManager();

        // create folder definition
        NamedValue[] folderDef = 
            WsUtility.newNamedValueArray(new Object[][] { { Attributes.NAME, 
                                                            folderName }, 
                                                          { Attributes.DESCRIPTION, 
                                                            folderDesc } });

        // folder attributes request
        AttributeRequest[] foldr_attr = 
            new AttributeRequest[] { WsUtility.newAttributeRequest(Attributes.PATH), 
                                     WsUtility.newAttributeRequest(Attributes.DESCRIPTION) };

        // create folder
        // -> no AttributeRequest is specified (third argument is null)
        Item folder = fm.createFolder(parent.getId(), folderDef, foldr_attr);

        WsUtility.log("folder attributes");
        WsUtility.log(WsUtility.INDENT, folder);

        return folder;
    }

    /**
     * Busca un objeto en particular
     * 
     * @param searchString	Cadena que contiene el nombre del objeto a buscar
     * @param s_WsCon	Objeto conexión WS
     * 
     * @return regresa un booleano, falso - no encontro el documento,
     *		true - encontro el documento en el CS
     * 
     * @throws FdkException    Si ocurre un high-level error.
     * @throws RemoteException    Si ocurre un error durante la ejecución de un Método remoto
     */
    public static boolean attributSearch(String searchString, 
                                         WsConnection s_WsCon) throws FdkException, 
                                                                      RemoteException, 
                                                                      Exception {

        boolean search = false;
        Item[] resulItem = null;

        // get the Manager instances
        FileManager fm = s_WsCon.getFileManager();
        SearchManager sem = s_WsCon.getSearchManager();
        //////System.out.println("Attributes.URL->"+Attributes.ATTRIBUTE_NAME);
        AttributeRequest[] urlAR = 
            WsUtility.newAttributeRequestArray(Attributes.URL);

        // define search options
        // This action search into Folders ( OnlY )
        NamedValue[] nv = 
            WsUtility.newNamedValueArray(new Object[][] { { Options.SEARCH_VERSION_HISTORY, 
                                                            Boolean.TRUE }, 
                                                          { Options.SEARCH_FOR_DOCUMENTS, 
                                                            Boolean.FALSE }, 
                                                          { Options.SEARCH_FOR_FOLDERS, 
                                                            Boolean.TRUE }, 
                                                          { Options.RETURN_COUNT, 
                                                            new Integer(5) } });

        // get search expresion
        SearchExpression seExp = new SearchExpression();
        ////System.out.println("searchString   .... "+searchString);
        seExp = new SearchExpression();
        seExp.setOperator(FdkConstants.OPERATOR_EQUAL);
        seExp.setLeftOperand("NAME");
        seExp.setRightOperand(searchString);

        // search documents
        NamedValue[] result = sem.search(seExp, nv, urlAR);
        // search result display
        //WsUtility.log("search items based upon attribute value");
        ////System.out.println("leght->"+result.length);
        for (int i = 0; i < result.length; i++) {
            if (result[i].getName().equals(Options.SEARCH_RESULTS)) {
                ////System.out.println("result[i].getName()"+result[i].getValue());
                resulItem = (Item[])result[i].getValue();
                if (resulItem != null) {

                    for (int j = 0; j < resulItem.length; j++) {
                        //WsUtility.log(resulItem[j].getName());
                        //System.out.println(resulItem.length);
                        ////System.out.println("Nombre->"+resulItem[j].getName());
                        ////System.out.println("typo->"+resulItem[j].getType());
                    }
                }
            }
        }
        if (resulItem == null) {

            search = false;

        } else
            search = true;

        return search;

    }
}
// EOF