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

import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaCiudadano;
import com.meve.sigma.actualiza.ActualizaRemitente;
import com.meve.sigma.actualiza.ActualizaTipo_Doc;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.beans.AsuntoBean;
import com.meve.sigma.beans.UsuarioBean;
//import com.meve.sigma.db2.DB2DataSource;
//import com.meve.sigma.sql.SQLCiudadano;
import com.meve.sigma.util.UploadFile;
import com.meve.sigma.util.Utilerias;

public class CrearAsuntoCiudadanoUCT extends HttpServlet implements Servlet {
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CrearAsuntoCiudadanoUCT() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	    doPost(arg0, arg1);
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	    String strAccion 	=	""; 
	    
	    String strIdCiudadano=	"";
	    String stridDestinatarioUCT = "";
		String strMailUCT	=	"";
		String strName		=	"";
		String strMailCiu	=	"";
		String strIdDestinatario = "";
		String strMailDest	=	"";
		String strNombreRem	=	"";
		String strMailRem	=	"";
		String strDes		=	"";
		String strAsunto	=	"";
		String strSolicitud =	"";
		String strArchivo 	= 	"";
		String strArea		=	"";
		
		String strFecha		=	"";
		String strFechaFol  =	"";
		String strIdRem		=	"";
		
		String strUrl		=	"";
		String strFechaHora		=	"";
		String strfechaCaducidad = "";
		String strConfFolio = 	"";
		
		String itemType = "";
		String strIdUsuario = "";
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date f = new java.util.Date();
		strFecha = sdf.format(f);
		
		String strFechaIncio = Utilerias.getFechaInicio(strFecha, "", "");
		Calendar cFechaInicio	=	Utilerias.StringCalendar2(strFechaIncio);
		strfechaCaducidad	= Utilerias.getFechaTerminacion((Calendar)cFechaInicio.clone(), "10");
		
		String serverContentManager	= "";// 	getInitParameter("content");

		java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("ddMMyyyy");
		java.util.Date f1 = new java.util.Date();
		strFechaFol = sdf1.format(f1);
		
		java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date f2 = new java.util.Date();
		strFechaHora = sdf2.format(f2);

		String serverMail = "";
		String portServer = "";
		String serverName = "";
		
		AsuntoBean BAsunto = new AsuntoBean();
		
		if(arg0.getMethod().equals("POST")){

			UploadFile ufRegistro = new UploadFile();
			try{
				ufRegistro.doUpload(arg0);
			}catch(java.io.IOException io){
				////System.err.println("ERROR--->"+io);
			}

			strAccion = ufRegistro.getCampo("accion");
			
			if (strAccion != null && strAccion.equals("guardar")){
			    UsuarioBean BUsuario = (UsuarioBean) arg0.getSession().getAttribute("UsuarioBean");
			    String strNombreUsuario = "";
				System.out.println("Cuardando Asunto Ciudadana... ");
				if(BUsuario!=null){
				    strNombreUsuario = BUsuario.getNombre();
				}
			    strIdCiudadano			=	ufRegistro.getCampo("id_ciudadano");
			    stridDestinatarioUCT 	=	ufRegistro.getCampo("idDestinatarioUCT");
			    strMailUCT				=	ufRegistro.getCampo("sol_mail");
			    strNombreRem			=	ufRegistro.getCampo("sol_name");
			    strMailRem				=	ufRegistro.getCampo("sol_mail1");
			    strDes					=	ufRegistro.getCampo("sol_destinatario");
			    strAsunto				=	ufRegistro.getCampo("sol_asunto");
			    strSolicitud			=	ufRegistro.getCampo("solicitud");
				strArchivo				=	ufRegistro.getCampo("solicitud_archivo");
				serverMail				=	ufRegistro.getCampo("serverM");
				portServer				=	ufRegistro.getCampo("portS");
				serverName				=	ufRegistro.getCampo("serverName");
				strUrl					=	ufRegistro.getCampo("url");
				serverContentManager	= 	ufRegistro.getCampo("cm");
				strArea					=	ufRegistro.getCampo("sol_area");
				strIdUsuario			= 	ufRegistro.getCampo("id_usuario");
				itemType 				= 	ufRegistro.getCampo("ItemType");
				strConfFolio			=	ufRegistro.getCampo("confFol");
				String ap = "";
				String am = "";
				String ocu = "";
				String strFolio =	"fol";
				
				String strRespondable[][] = ActualizaUsuario.getCorreoNombreResponsableArea();
				String strIdRes		=	strRespondable[0][0];
				String strNombreRes	=	strRespondable[0][1];
				String strMailRes	=	strRespondable[0][2];
				String strAreaRes	=	strRespondable[0][3];
				
				String[][] strIdDoctos = ActualizaTipo_Doc.getIdDocto0();
				String strIdDoc = strIdDoctos[0][0];
				String strNombreTD = strIdDoctos[0][1];
				if(strArchivo.length() != 0){
					
					byte archivoCiudadano[]=ufRegistro.getArchivosBytes(strArchivo);
					/*String sql = SQLCiudadano.insertarSolicitudConArch(strAsunto, strFecha, 
																		strIdCiudadano, strFolio, strSolicitud, strFechaHora);*/
					
					String[] strArchivos 	=	null;
					String strContType	=	null;
					strArchivos 			=	ufRegistro.getNombreArchivo();
					strContType				=	ufRegistro.getContentType(strArchivos[0]);
					boolean bInsertArchivo = false;
					
					try{
						String ultimoID = ActualizaCiudadano.insertarSolicitudSinArch(strAsunto, strFecha, 
								strIdCiudadano, strFolio, strSolicitud, strFechaHora);
						//String ultimoID =	ActualizaCiudadano.getUltimoIdSolicitud();

						String[][] strDatosCiu = ActualizaCiudadano.getDatosCiudadano(strIdCiudadano);
						ap = strDatosCiu[0][2];
						am = strDatosCiu[0][3];
						ocu = strDatosCiu[0][6];
						
						if(ocu.length() == 0)
						    ocu = "Ninguna";
						String strNombreFormado = strNombreRem+" "+ap+" "+am;
						boolean bExisteRem = ActualizaRemitente.existeRemitente(strNombreFormado);
						if(bExisteRem){
							strIdRem = ActualizaRemitente.getIdRemitente(strNombreFormado);
						}else{
							boolean insertaRemitente = ActualizaRemitente.insertarRemitenteDesdeAsunto("0", "0", 
																			strNombreFormado, 
																			ocu, 
																			strMailRem, 
																			"0", strFecha);
							strIdRem = ActualizaRemitente.ultimoIdRemitente();
						}
						String idAsunto=BAsunto.guardarAsunto("1", strIdRem, null, strAsunto, null, null, null, strIdDoc, null, strFecha, 
										null, strfechaCaducidad, null, null, strSolicitud, null, null, null, null, null, strIdRes, "null", strNombreRes,
										strMailRes, strNombreRem, strMailRem, strAreaRes,
										(strIdUsuario==null)?"1":strIdUsuario, "0", true, serverMail, portServer, 
										serverName,arg0.getContextPath(), strConfFolio, "1",arg0);
						String FolioGen = ActualizaAsunto.getFolioAsunto(idAsunto);
						boolean bActFolio = ActualizaCiudadano.actualizarFolioSolicitud(ultimoID, FolioGen, idAsunto);
						
						
						
						Vector v1 = new Vector();
						Vector v2 = new Vector();
						Vector v3 = new Vector();
						
						v3.add("");
						v3.add("");
						v3.add(archivoCiudadano);
						////System.out.println("el id del asunto es: " + idAsunto);
						v2.add(idAsunto);
						v2.add(FolioGen);
						v2.add(strNombreUsuario);
						
						v1.add(itemType);
						////System.out.println("el nombre del archivo es: " + strArchivos[0]);
						v1.add(strArchivos[0]);
						v1.add(v2);
						v1.add(strContType);
						v1.add(FolioGen+strFechaFol);
						//v1.add(CalculaNombreArchivo(""));
						v1.add(v3);
						
						String strUrlCM = serverContentManager +"/eclient/ArchivoCM";						
						if(sentToCM(v1,strUrlCM)==0){
						    ////System.out.println("Se guardo el archivo en CM");
						}else{
						    ////System.out.println("Exisitio un error al enviar el archivo a CM");
						}
						
						////System.out.println("El valor del url al que se redirecciona es: " + strUrl);
						
						arg1.sendRedirect(strUrl+ultimoID);

					}catch(java.io.IOException io){
						//System.err.println("Error de redireccion->"+io);
					}
				//** If no se insertaron archivos ejecuta el siguiet bloque
				}else{
					////System.out.println("Sin Archivo");
					/*boolean bInsertar = ActualizaCiudadano.insertarSolicitudSinArch(strAsunto, strFecha, 
																				strIdCiudadano, strFolio, strSolicitud, strFechaHora);
					*/
					String ultimoID1 = ActualizaCiudadano.insertarSolicitudSinArch(strAsunto, strFecha, 
							strIdCiudadano, strFolio, strSolicitud, strFechaHora);
					
					String[][] strDatosCiu = ActualizaCiudadano.getDatosCiudadano(strIdCiudadano);
					ap = strDatosCiu[0][2];
					am = strDatosCiu[0][3];
					ocu = strDatosCiu[0][6];
					String strNombreFormado = strNombreRem+" "+ap+" "+am;
					boolean bExisteRem = ActualizaRemitente.existeRemitente(strNombreFormado);
					if(bExisteRem){
						strIdRem = ActualizaRemitente.getIdRemitente(strNombreFormado);
					}else{
						boolean insertaRemitente = ActualizaRemitente.insertarRemitenteDesdeAsunto("0", "0", 
																			strNombreFormado, 
																			ocu, 
																			strMailRem, 
																			"0", strFecha);
						strIdRem = ActualizaRemitente.ultimoIdRemitente();
					}
					String idAsunto=BAsunto.guardarAsunto("1", strIdRem, null, strAsunto, null, null, null, strIdDoc, null, strFecha, 
										null, strfechaCaducidad, null, null, strSolicitud, null, null, null, null, null, strIdRes, "null", strNombreRes,
										strMailRes, strNombreRem, strMailRem, strAreaRes,
										(strIdUsuario==null)?"1":strIdUsuario, "0", true, serverMail, portServer, 
										serverName,arg0.getContextPath(), strConfFolio, "1",arg0);
					
					//boolean bInsertarAsunto = ActualizaAsunto.InsertarAsunto()
					//String idAsunto = ActualizaAsunto.getUltimoIdAsunto();
					String FolioGen = ActualizaAsunto.getFolioAsunto(idAsunto);
					//boolean bActFolio = ActualizaCiudadano.actualizarFolioSolicitud(ultimoID, FolioGen);

					boolean bActFolio1 = ActualizaCiudadano.actualizarFolioSolicitud(ultimoID1, FolioGen, idAsunto);
					try{
					    arg1.sendRedirect(strUrl+ultimoID1);
					    
					}catch(java.io.IOException io){
						//System.err.println("Error de redireccion->"+io);
					}
				}
			}
		}
	}
	
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
	        //System.err.println("CrearAsuntoCuidadano --> sentoCM --> Error --> " + e.toString());
	        res=-1;
	    }
	    
	    return res;
	}


}