package com.meve.sigma.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.ifs.fdk.CommonManager;
import oracle.ifs.fdk.FdkException;
import oracle.ifs.fdk.FileManager;


import HTTPClient.Cookie;
import HTTPClient.CookieModule;
import HTTPClient.HTTPConnection;
import HTTPClient.HTTPResponse;
import HTTPClient.ModuleException;
import HTTPClient.ParseException;
import HTTPClient.ProtocolNotSuppException;

import com.meve.oracle.cm.WsConnection;
import com.meve.oracle.cm.WsUtility;
import com.meve.sigma.actualiza.ActualizaArchivo;

public class VerContent extends HttpServlet implements Servlet {
	
	//property object
	private static Properties s_Prop;
	
	private static WsConnection s_WsCon;
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public VerContent() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		String strIdA="";
		strIdA=arg0.getParameter("ida");
		String srtCarpeta = "";
		srtCarpeta = arg0.getParameter("fol");
		String strIdItem = "";
		
		String strArchivos[][] = ActualizaArchivo.getArchivosReferenciaContentID(strIdA);
		byte[] byArchivo = null;
		strIdItem = strArchivos[0][3];
		byArchivo = guardar(strIdItem, strArchivos[0][1], srtCarpeta);
		////System.out.println("Regreso Algo-->"+byArchivo.length);
		if(byArchivo != null)
		{
			OutputStream ou = arg1.getOutputStream();				
			////System.out.println("contenttype: " + strArchivos[0][2]);				
			arg1.setContentType(strArchivos[0][2]);
			arg1.setHeader(
				"Content-Disposition",
				"attachment; filename=\"" + strArchivos[0][1] + "\"");
			arg1.setContentLength(byArchivo.length);
			arg1.setBufferSize(4000);
			ou.write(byArchivo);	
			ou.flush();
			arg1.flushBuffer();
		}
		
		
		
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public static byte[] guardar(String strIdItem, String strNombre, String srtCarpeta)
	{
		byte[] byArchivo =null;
		String server = "";
		String user = "";
		String clave = "";
		String doc = "";
		try
		{
			ResourceBundle res = ResourceBundle.getBundle("content");
			try{
				server = res.getString("SERVER_URL").trim();
				user = res.getString("USER_CONTENT").trim();
				clave = res.getString("PASSWORD_CONTENT").trim();
				doc = res.getString("DOC_URL").trim();
				//server = Class.forName(statusOCS.server);                
            }catch (MissingResourceException mre){
                mre.printStackTrace();
            }
			// get property object
			//s_Prop = WsUtility.getProperty("c:/sct2.gif");
      
			// URL to content services web services servlet
			//String serverUrl = "http://linux.meve.com:7778/content/ws";
			//String serverUrl = "http://vmserver2.meve.com/content/ws";
			////String serverUrl = "http://bdmprd1.hacienda.gob.mx:7778/content/ws";
                        String serverUrl = "http://192.168.247.24:7778/content/ws";//Mike
                        
            //String serverUrl = server;//"http://bdmprd1.hacienda.gob.mx:7778/content/ws";
			
			
			// authenticate to content services
			//s_WsCon = WsConnection.login(serverUrl, "orcladmin","password1");
			s_WsCon = WsConnection.login(serverUrl, "adm_siga","adm_siga1");
            //s_WsCon = WsConnection.login(serverUrl, user,clave);
			
			try
			{
				// download and show the document's contents
				
				byArchivo = downloadDocument(strIdItem, strNombre, srtCarpeta, doc);
			}
			finally
			{
				s_WsCon.logout();
			}
		}
		catch (Throwable t)
		{
			t.printStackTrace();
			//System.out.println("t-------->"+t);
		}
		return byArchivo;
	}
	
	public static byte[] downloadDocument(String strIdItem, String strNombre, String srtCarpeta, String doc1)
    throws FdkException, IOException, ModuleException, ParseException
	{
		FileManager fm = s_WsCon.getFileManager();
		CommonManager cm = s_WsCon.getCommonManager();
		
		/*AttributeRequest[] urlAR = WsUtility.newAttributeRequestArray(Attributes.URL);
		Item document = cm.getItem(new Long(strIdItem).longValue(), urlAR);
		NamedValue[] attrs = document.getRequestedAttributes();
		Map attrMap = ClientUtils.namedValuesToMap(attrs);*/
		//String docUrl = "http://linux.meve.com:80/content/dav/meve/SIGMA/gestion/contenedor/"+strNombre;
		//String docUrl = "http://vmserver2.meve.com/content/dav/meve/SIGA_WS/SIGA_LIB/"+srtCarpeta+"/"+strNombre;
		//String docUrl = "http://bdmprd1.hacienda.gob.mx:7778/content/dav/hacienda/SIGA_WS/SIGA_LIB/"+srtCarpeta+"/"+strNombre;
		 String docUrl = "http://192.168.247.24:7778/content/dav/hacienda/SIGA_WS/SIGA_LIB/"+srtCarpeta+"/"+strNombre;//Mike
            
		//System.out.println("docUrldocUrldocUrl "+ docUrl);
		//(String) attrMap.get(Attributes.URL);
		URL url = new URL(docUrl);
		//System.out.println("docUrl.toString()->"+docUrl.toString());
		// download the document content using HTTP
		HTTPConnection httpCon = createHttpConnection(url);
		HTTPResponse rsp = httpCon.Get(url.getFile());
		//System.out.println("getReasonLine->"+rsp.getStatusCode());
		// check the response
		if (rsp.getStatusCode() >= 300)
		{
			WsUtility.log("Error------------------>: " + rsp.getReasonLine());
		}
		// write downloaded content in the file
		WsUtility.log("write downloaded content in the file:");
		//InputStream content = rsp.getInputStream();
		byte[] Arreglo = (byte[])rsp.getData();
		//System.out.println("Arreglo="+Arreglo.length);
		/*FileOutputStream fos = new FileOutputStream(strNombre);
	    int c1 = -1;
	    while ((c1 = content.read()) != -1)
	    {
	      fos.write(c1);
	    }*/
		
		
		/*ByteArrayOutputStream baosArchivoBinario = new ByteArrayOutputStream();
		ByteArrayOutputStream baosAuxiliar = new ByteArrayOutputStream();
		int MAXLON=1024;
		
		byte[] line = new byte[MAXLON];
		int c = -1;
		int iBytes = content.read(line,0,MAXLON);
		//System.out.println("iBytes="+iBytes);
		baosAuxiliar.write(line, 0, iBytes);
		int iLimite = iBytes -2;
		while(iBytes!=-1)
		{
			iBytes = content.read(line,0,MAXLON);
			
			if((iBytes == iLimite+2 || iBytes==iLimite+4))
			{
				baosArchivoBinario.write(baosAuxiliar.toByteArray(),0,baosAuxiliar.size()-2);
			}
			else
			{
				baosArchivoBinario.write(baosAuxiliar.toByteArray(),0,baosAuxiliar.size());
			}
			
		}
		byte[] byArchivo =null;
		byArchivo = baosArchivoBinario.toByteArray();*/
		
	    
		return Arreglo;
		
	}
	
	/**
	* Creates an HttpConnection ready to be used for uploading and downloading.
	*/
	private static HTTPConnection createHttpConnection(URL url)
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

}