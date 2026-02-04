package com.meve.sigma.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Vector;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.db2.DB2DataSource;
import com.meve.sigma.sql.SQLArchivo;
import com.meve.sigma.util.UploadFile;

public class ImportarCM extends HttpServlet implements Servlet {
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ImportarCM() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(arg0,arg1);
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
	    
	    if(arg0.getMethod().equals("POST")){
	     
	        UsuarioBean BUsuario = (UsuarioBean) arg0.getSession().getAttribute("UsuarioBean");
	        ////System.out.println("Entra a subir el archivo");
			UploadFile ufRegistro = new UploadFile();
			try{
				ufRegistro.doUpload(arg0);
			}catch(java.io.IOException io){
				//System.err.println("ERROR--->"+io);
			}
			
			java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date f 				=	new java.util.Date();
			String strFechaCreacion			=	sdf.format(f);
			
			String strAccion = ufRegistro.getCampo("accion");
			String strActivarCM = ufRegistro.getCampo("ActivarCM");
			
			if(strAccion.equalsIgnoreCase("guardar")){
			    String strIdAsunto = ufRegistro.getCampo("IdAsunto");
			    String strIdInst = ufRegistro.getCampo("id_ins");
			    String a1 = ufRegistro.getCampo("a1");
		    	String strUrl = ufRegistro.getCampo("url");
		    	String serverContentManager = ufRegistro.getCampo("cm");
		    	String strArchivo		=	ufRegistro.getCampo("solicitud_archivo");
		    	String strFolio = ufRegistro.getCampo("Folio");
		    	String itemType = ufRegistro.getCampo("ItemType");
		    	String server = ufRegistro.getCampo("server");
		    	String uri = ufRegistro.getCampo("uri");
		    	String url = "";
		    	if(a1.equals("1")){
		    	    url = server+uri+"?cm="+serverContentManager+"&Folio="+strFolio+"&IdAsunto="+strIdAsunto+"&a=1";
		    	    ////System.out.println("url1->"+url);
		    	}else if(a1.equals("2")){
		    	    url = server+uri+"?cm="+serverContentManager+"&Folio="+strFolio+"&IdAsunto="+strIdAsunto+"&a=2&id_ins="+strIdInst;
		    	    ////System.out.println("url2->"+url);
		    	}
		    	else if(a1.equals("4")){
		    		url = server+uri+"?cm="+serverContentManager+"&Folio="+strFolio+"&IdAsunto="+strIdAsunto+"&a=4";
		    		////System.out.println("url4->"+url);
		    	}
		    	else if(a1.equals("5")){
		    		url = server+uri+"?cm="+serverContentManager+"&Folio="+strFolio+"&IdAsunto="+strIdAsunto+"&a=5";
		    		////System.out.println("url4->"+url);
		    	}
			    if(strActivarCM.equals("si")){
			        //** Content de Oracle **//
			        byte archivoCiudadano[]=ufRegistro.getArchivosBytes(strArchivo);
			    	////System.out.println("La lon del archivo es: " + archivoCiudadano.length);

			    	String[] strArchivos 	=	null;
			    	String strContType	=	null;
			    	strArchivos 			=	ufRegistro.getNombreArchivo();
			    	////System.out.println("el archivo es: " + strArchivos[0]);
			    	strContType				=	ufRegistro.getContentType(strArchivos[0]);
			    	
			    	String strNombreUsuario = "";
			
			    	if(BUsuario!=null){
			    	    strNombreUsuario = BUsuario.getNombre();
			    	}
			    	
			    	Vector v1 = new Vector();
			    	Vector v2 = new Vector();
			    	Vector v3 = new Vector();
			
			    	v3.add("");
			    	v3.add("");
			    	v3.add(archivoCiudadano);
			    	////System.out.println("el id del asunto es: " + strIdAsunto);
			    	v2.add(strIdAsunto);
			    	v2.add(strFolio);
			    	v2.add(strNombreUsuario);
			
			    	v1.add(itemType);
			    	////System.out.println("el nombre del archivo es: " + strArchivos[0]);
			    	v1.add(strArchivos[0]);
			    	v1.add(v2);
			    	v1.add(strContType);
			    	//v1.add(FolioGen+strFechaFol);
			    	v1.add(CalculaNombreArchivo(strFolio));
			    	v1.add(v3);
			
			    	String strUrlCM = serverContentManager +"/eclient/ArchivoCM";	
			
			    	////System.out.println("el url es: " + strUrlCM);
			    	if(sentToCM(v1,strUrlCM)==0){
			    	    ////System.err.println("Se guardo el archivo en CM");
			    	}else{
			    	    ////System.err.println("Exisitio un error al enviar el archivo a CM");
			    	}
			    	///&IdAsunto=<%=strIdAsunto%>&url=<%=URL%>&a=1
			    	
			    	arg1.sendRedirect(url);
				}else{
				    ////System.out.println("Inserta Archivo en tabla");
				    boolean bInsertArchivo = false;
				    String[] strArchivos=null; 				 		
					strArchivos = ufRegistro.getNombreArchivo();
					if(strArchivos!=null && strArchivos.length>0) 
					{							
						for(int i=0;i<strArchivos.length;i++)
						{	
							//System.out.println(strArchivos[i]);
							byte arreglo[]=ufRegistro.getArchivosBytes(strArchivos[i]);
							try{
							bInsertArchivo =DB2DataSource.insertaBlob(SQLArchivo.getInsertaArchivo(strArchivos[i],
							        										ufRegistro.getContentType(strArchivos[i]),
							        										strIdAsunto, strIdInst,
							        										BUsuario.getIdUsuario(), 
							        										strFechaCreacion),arreglo);
							}catch(Exception e){
							    //System.err.println("error------------>"+e);
							}
							////System.out.println("Insertando Archivo");
						}
					}
					////System.out.println("URLFinal->"+url);
					arg1.sendRedirect(url);
				}
			}
	    }
	}
	  /**
	   * Verifica el estatus del servicion de content services.
	   * 
	   * @param strfolio	Folio del asunto
	   * @return la cadena que contiene el nombre del archivo
	   */
	private String CalculaNombreArchivo(String strfolio)
    {
        Calendar cCal = Calendar.getInstance();
        String strComplemento = "";
        strComplemento = "" + cCal.get(5) + (cCal.get(2) + 1) + cCal.get(1) + cCal.get(11) + cCal.get(12) + cCal.get(14);
        
        if(strfolio!=null && strfolio.trim().length()>0)
        {
            return strfolio +"_"+ strComplemento;
        }
        else{    
            return strComplemento;
        }
    }

	private int sentToCM(Vector v1,String  strUrl){
	    int res=0;
	    try{
	    URL direccion=new URL(strUrl);
		URLConnection conexion=direccion.openConnection();			
		conexion.setUseCaches(false);
		conexion.setDoOutput(true);			
		ByteArrayOutputStream bs=new ByteArrayOutputStream(1512);
		ObjectOutputStream salida=new ObjectOutputStream(bs);			
		salida.writeObject(v1);
	        ////System.out.println("AppletGestion  ----->  Envio Vectores....");
		conexion.setRequestProperty("Content-Length",String.valueOf(bs.size()));
		conexion.setRequestProperty("Content-Type","application/x-java-serialized-object");
		bs.writeTo(conexion.getOutputStream());
	        
		////System.out.println("AppletGestion  ----->  Envio Vectores....");
		ObjectInputStream entrada=new ObjectInputStream(conexion.getInputStream());	
	        //if(entrada==null)
	            ////System.err.println("la entrada es null");
	        //else
	            ////System.err.println("la entrada no es null");
		String strMensaje=(String)entrada.readObject();
	        
	        entrada.close();
	        
		if(strMensaje!=null && strMensaje.trim().length()>0)
		{
	            //this.setVisible(true);
	             //res= JOptionPane.showConfirmDialog( new JFrame(),strMensaje,"Information", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null );
	            res=0;
		}
	    }catch(Exception e){
	        //System.err.println("ImportarCM --> sentoCM --> Error --> " + e.toString());
	        res=-1;
	    }
	    
	    return res;
	}

}