package com.meve.sigma.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meve.oracle.cm.ConnectionWebService;
import com.meve.oracle.cm.WsConnection;
import com.meve.oracle.cm.WsUtility;
import com.meve.sigma.actualiza.ActualizaArchivo;

import oracle.ifs.fdk.AttributeRequest;
import oracle.ifs.fdk.Attributes;
import oracle.ifs.fdk.ClientUtils;
import oracle.ifs.fdk.CommonManager;
import oracle.ifs.fdk.FdkConstants;
import oracle.ifs.fdk.FdkException;
import oracle.ifs.fdk.FileManager;
import oracle.ifs.fdk.Item;
import oracle.ifs.fdk.NamedValue;
import oracle.ifs.fdk.Options;
import oracle.ifs.fdk.SearchExpression;
import oracle.ifs.fdk.SearchManager;

import HTTPClient.Cookie;
import HTTPClient.CookieModule;
import HTTPClient.HTTPConnection;
import HTTPClient.HTTPResponse;
import HTTPClient.ModuleException;
import HTTPClient.ProtocolNotSuppException;

import com.meve.sigma.db2.ConexionDocs;
import com.meve.sigma.sql.SQLDocs;

public class DownLoadDicument extends HttpServlet implements Servlet {

	private static String strUriContent;
	private static String strUserContet;
	private static String strPassContent;
	private static String strPathContent;
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public DownLoadDicument() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

		String strIdA="";
		String srtCarpeta = "";
		String strName = "";
		String strPdfName = "";
		byte[] byArchivo = null;
		String[] configContent = new String[3];
		
		/*try{	
			strUriContent = getServletConfig().getServletContext().getInitParameter("content");
			strUserContet =  getServletConfig().getServletContext().getInitParameter("user");
			strPassContent = getServletConfig().getServletContext().getInitParameter("passwd");
			strPathContent	=	getServletConfig().getServletContext().getInitParameter("path");
                        System.out.println("strUriContent: "+strUriContent);
                        System.out.println("strPathContent: "+strPathContent);
		}catch(Exception e){
			//System.err.println(e.toString());

		}*/
		strIdA=arg0.getParameter("ida");
		srtCarpeta = arg0.getParameter("fol");
		strName = arg0.getParameter("name");
		String strIdItem = "";
		strPdfName = arg0.getParameter("name");
		
		if (srtCarpeta.equals("HelpSIGA")  ){
			byArchivo = downLoad(strIdItem, strPdfName, srtCarpeta);
			if(byArchivo != null)
			{
				OutputStream ou = arg1.getOutputStream();			
				arg1.setContentType("application/pdf ");
				arg1.setHeader(
					"Content-Disposition; target='_blank'",
					"attachment; filename=\"" + strPdfName + "\"");
				arg1.setContentLength(byArchivo.length);
				arg1.setBufferSize(4000);
				ou.write(byArchivo);	
				ou.flush();
				arg1.flushBuffer();
			}
		
		}else{
			
			String strArchivos[][] = ActualizaArchivo.getArchivosReferenciaContentID(strIdA);
			strIdItem = strArchivos[0][3];
			byArchivo = downLoad(strIdItem, strArchivos[0][1], srtCarpeta);
			//System.out.println("item="+strIdItem+"archivo="+strArchivos[0][1]+"carpeta="+srtCarpeta);
			if(byArchivo != null)
			{
				OutputStream archive = arg1.getOutputStream();				
				arg1.setContentType(strArchivos[0][2]);
				arg1.setHeader(
					"Content-Disposition",
					"attachment; filename=\"" + strArchivos[0][1] + "\"");
				arg1.setContentLength(byArchivo.length);
				arg1.setBufferSize(4000);
				archive.write(byArchivo);	
				archive.flush();
				arg1.flushBuffer();
			}
		}
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	  /**
	   * Baja e imprime el contenido del documento.
	   * 
	   * @param strIdItem Docuemento a bajar.
	   * @param strNombre	Nombre del documento
	   * @param  srtCarpeta Carpeta donde se encuentra el documento
	   * 
	   * @return el documento
	   */
	public static byte[] downLoad(String strIdItem, String strNombre, String srtCarpeta)
	{
		byte[] byArchivo =null;
		
		try{//Mike
			/*WsConnection s_WsCon;
			Item newDocumento;
			Item workspace;

        	ConnectionWebService c = new ConnectionWebService(strUriContent, strUserContet, strPassContent);
        	s_WsCon = c.conectaOcs(); 
				
			String serverUrl = strUriContent+"/content/ws";
			FileManager fm = s_WsCon.getFileManager();
			
			workspace = fm.resolvePath( strPathContent + "/" +  srtCarpeta, null);
			newDocumento = searchItems(strNombre, workspace,s_WsCon); */
 
			try{
				// download and show the document's contents				
				//byArchivo = downloadDocument(newDocumento,s_WsCon);
                                byArchivo = ConexionDocs.getBlob(SQLDocs.getArchivoBinario(srtCarpeta,strNombre),"ARCHIVO");
			}
			finally{
				//s_WsCon.logout();
			}
		}
		catch (Throwable t){
			t.printStackTrace();
		}
		return byArchivo;
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
	  public static byte[] downloadDocument(Item doc, WsConnection s_WsCon)
	    throws FdkException, IOException, ModuleException
	  {
	  	FileManager fm = s_WsCon.getFileManager();
	    CommonManager cm = s_WsCon.getCommonManager();
	  	 
	  	AttributeRequest[] urlAR = 
	        WsUtility.newAttributeRequestArray(Attributes.URL);
	  	
	    doc = cm.getItem(doc.getId(), urlAR);
	    
	    NamedValue[] attrs = doc.getRequestedAttributes();
	    Map attrMap = ClientUtils.namedValuesToMap(attrs);
	   
	    String docUrl = (String) attrMap.get(Attributes.URL);
	    URL url = new URL(docUrl);

	    // download the document content using HTTP
	    HTTPConnection httpCon = createHttpConnection(url,s_WsCon);
	    HTTPResponse rsp = httpCon.Get(url.getFile());
	    
	    // check the response
	    if (rsp.getStatusCode() >= 300)
	    {
	      WsUtility.log("Error: " + rsp.getReasonLine());
	    }

	    // write downloaded content in the file
	    WsUtility.log("write downloaded content in the file:");
	    byte[] Arreglo = (byte[])rsp.getData();	    
	    return Arreglo;
	  } 
	  
	  /**
	   * Crea una HttpConnection para subir o bajar documentos.
	   * 
	   * @param url  URL  para el docDef Item
	   * @param s_WsCon	Objeto conexión WS
	   * 
	   * @throws ProtocolNotSuppException	Si ocurre un protocolo error.
	   */ 
	  private static HTTPConnection createHttpConnection(URL url,WsConnection s_WsCon)
	    throws ProtocolNotSuppException
	  {
	    // create the HTTPClient cookie, using the session cookie
	    //   -> we specify "/content" as the cookie path because
	    //      it is always first in content services URLs
	    String[] sessionCookies = s_WsCon.getSessionCookie();
	    String sessionCookie = sessionCookies[0];
	    Cookie cookie = new Cookie("c1", sessionCookie, url.getHost(), "/content",
	      null, false);

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
	   * Busca un objeto en particular con restricción de folder
	   * 
	   * @param searchString	Cadena que contiene el nombre del objeto a buscar
	   * @param folder	Nombre del folder
	   * @param s_WsCon	Objeto conexión WS
	   * 
	   * @return regresa el objeto encontrado
	   * 
	   * @throws FdkException    Si ocurre un high-level error.
	   * @throws RemoteException    Si ocurre un error durante la ejecución de un Método remoto
	   */
	  public static Item searchItems(
	  	    String searchString, Item folder, WsConnection s_WsCon) throws FdkException, RemoteException
	  	  {
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
	  	    
	  	    Item resultado = resulItem[0];
	  	    
	  	    return resultado;
	  	  }
	  	
}