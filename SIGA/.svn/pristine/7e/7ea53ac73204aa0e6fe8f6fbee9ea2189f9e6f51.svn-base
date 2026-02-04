package com.meve.sigma.reportes;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
//import java.sql.Connection;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaEntidad;
import com.meve.sigma.actualiza.ActualizaFlujo;
import com.meve.sigma.actualiza.ActualizaPrioridad;
import com.meve.sigma.actualiza.ActualizaRemitente;
import com.meve.sigma.actualiza.ActualizaTipoAsunto;
import com.meve.sigma.actualiza.ActualizaTipo_Doc;
import com.meve.sigma.actualiza.ActualizaTramite;
import com.meve.sigma.actualiza.ActualizaUbicacion;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.db2.ConexionDS;
//import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.util.Utilerias;

public class ReportAsunto extends HttpServlet implements Servlet {
    
    private String strIdAsunto="";
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ReportAsunto() {  
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
	    strIdAsunto = (arg0.getParameter("id_asu")==null)?"":arg0.getParameter("id_asu");
	    String strGetAsuntoTurnado[][] = null;
	    String strGetDatosRem[][] = null;
	    
            String strEntidad = "";
	    String strRem = "";
	    String strCargoRem = "";
	    String strCorreoRem = "";
	    String strDes = "";
	    String strDesCargo = "";
	    String strDesArea = "";
	    String strExpediente = "";
	    String strUbicacion = "";
	    String strTipoDocto = "";
	    String strFechaRep = "";
	    String strFechaDoc = "";
	    String strFechaCad = "";
	    String strPrioridad = "";
	    String strTipoAsunto = "";
	    String strRutaAuto = "";
	    String strEstatus = "";
	    String strTramite = "";
	    String strFechaEvento = "";
	    String strHoraEvento = "";
	    String strMinEvento = "";
	    String strLugarEvento = "";
	    Vector strPara = new Vector();
	    Vector strCC = new Vector();
	    Vector strParaExt = new Vector();
            Connection con=null;
            
            String strComentarios[][] = null;
	    String strComentario = "";
	    
		
		//**Se hace una llamada a un query, para crear los parametros dque conforman al reporte
		if(strIdAsunto != null && strIdAsunto.length() > 0){
		    strGetAsuntoTurnado		= 	ActualizaAsuntoTurnado.getAsuntoTurnadoReporte(strIdAsunto);
                    strComentarios              =       ActualizaComentario.getDatosComentarios(strIdAsunto);
                    
		    if(strGetAsuntoTurnado[0][34].equals("1")){//Control
		    	////System.out.println("Es usuario");
			}else{
				strGetDatosRem	=	ActualizaRemitente.getRemitentes(strGetAsuntoTurnado[0][2]);
			}
		}
		
		//**Destinatario y Remitente
		if(strGetAsuntoTurnado[0][34].equals("1")){
		    strEntidad 	= 	ActualizaArea.NombreArea(strGetAsuntoTurnado[0][0]);
		    strRem		=	ActualizaUsuario.getUsuarioPuesto(strGetAsuntoTurnado[0][2]);
		    strCargoRem	=	ActualizaUsuario.getMailCargoUsuario(strGetAsuntoTurnado[0][2])[0][0];
		    strCorreoRem=	ActualizaUsuario.getMailCargoUsuario(strGetAsuntoTurnado[0][2])[0][1];
		}else{
		    strEntidad 	= 	ActualizaEntidad.getNombreEntidad(strGetAsuntoTurnado[0][0]);
		    strRem		=	strGetDatosRem[0][2] +" / "+ strGetDatosRem[0][0];
		    strCargoRem =	strGetDatosRem[0][2];
		    strCorreoRem=	strGetDatosRem[0][5];
		}
		
		//**Ventanilla o Destinatario
		if(strGetAsuntoTurnado[0][32].length() != 0){
		    String dest[][] = ActualizaUsuario.getNombreCargoAreaUsr(strGetAsuntoTurnado[0][32]); 
			strDes 		= 	dest[0][0];
			strDesCargo = 	dest[0][1];
			strDesArea 	=	dest[0][2];
		}
		
		//**Expediente
		if(strGetAsuntoTurnado[0][6].length() != 0){
		    //strExpediente = ActualizaExpediente.getNombreExpediente(strGetAsuntoTurnado[0][6])[0][0];
		    strExpediente = strGetAsuntoTurnado[0][7];
		}
		
		//**Ubicación
		if(strGetAsuntoTurnado[0][8].length() != 0){
		    strUbicacion = ActualizaUbicacion.getNombreUbicacion(strGetAsuntoTurnado[0][8])[0][0];
		}
		
		//**Tipo de Documento
		if(strGetAsuntoTurnado[0][10].length() != 0 && strGetAsuntoTurnado[0][10] != null){
		    strTipoDocto = ActualizaTipo_Doc.getNombreTipoDocto(strGetAsuntoTurnado[0][30]);
		}
		
		//**Fechas de Recepcion, Documento y vencimiento
		if(	strGetAsuntoTurnado[0][13].length() >0 && 
		    strGetAsuntoTurnado[0][14].length() >0 && 
		    strGetAsuntoTurnado[0][15].length() >0){
		    
		    strFechaRep = Utilerias.formatearFechas(strGetAsuntoTurnado[0][13]);
		    strFechaDoc = Utilerias.formatearFechas(strGetAsuntoTurnado[0][14]);
		    strFechaCad = Utilerias.formatearFechas(strGetAsuntoTurnado[0][15]);
		}
		
		//**Datos del Turnado (Prioridad, Tipo de Asunto y Ruta Automatica)
		if(strGetAsuntoTurnado[0][22].length() != 0 && strGetAsuntoTurnado[0][27].length() != 0){
		    strPrioridad	=	ActualizaPrioridad.getNombrePrioridad(strGetAsuntoTurnado[0][22]);
		    strTipoAsunto 	=	ActualizaTipoAsunto.getNombreTipoAsunto(strGetAsuntoTurnado[0][27]);
		    if(strGetAsuntoTurnado[0][35].length() == 0){
		        strRutaAuto =	"NINGUNO";
		    }else{
		        strRutaAuto =	ActualizaFlujo.getFlujos(strGetAsuntoTurnado[0][35])[0][3];
		    }
		}
		
		//**Tramite
		if(strGetAsuntoTurnado[0][43].length() != 0 ){
			strTramite = ActualizaTramite.getNombreTramite(strGetAsuntoTurnado[0][43]);
		}else{
			strTramite = "No tiene Tramite";
		}
		
		//**Evento
		if(strGetAsuntoTurnado[0][38].length() >0){
			strFechaEvento = Utilerias.formatearFechas(strGetAsuntoTurnado[0][38]);
		}
		if(strGetAsuntoTurnado[0][40].length() >0){
			strHoraEvento = strGetAsuntoTurnado[0][40];
		}else{
			strHoraEvento = "--";
		}
		if(strGetAsuntoTurnado[0][41].length() >0){
			strMinEvento = strGetAsuntoTurnado[0][41];
		}else{
			strMinEvento = "--";
		}
                
                //Comentarios
                if( strComentarios != null) {
                    for(int i=0;i<strComentarios.length;i++) {
                        strComentario += "Fecha y Hora: " + strComentarios[i][1] + "\n";  
                        strComentario += "Usuario: " + strComentarios[i][2] + "\n";  
                        strComentario += "Comentario: " + Utilerias.cambioSaltosDeLinea(strComentarios[i][0]) + "\n\n";  
                    }
                }
		
		strPara = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][46].trim(), 1);
		////System.err.println("strGetAsuntoTurnado[0][46]="+strGetAsuntoTurnado[0][46]);
		//String str = strGetAsuntoTurnado[0][46].substring(1, strGetAsuntoTurnado[0][46].length()-1);
		////System.err.println("str="+str);
		strCC = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][47].trim(), 2);
		strParaExt = Utilerias.getRemitenteEntidad(strGetAsuntoTurnado[0][48].trim(),0);
		
		String para = Utilerias.getCadenaBajarLinea(strPara);
		String ccp = Utilerias.getCadenaBajarLinea(strCC);
		String paraD = Utilerias.getCadenaBajarLinea(strParaExt);
		////System.err.println(ccp);
		//**Estatus
		/*if(strGetAsuntoTurnado[0][28].equals("3")){
			strEstatus = "TERMINADO";
		}else if(strGetAsuntoTurnado[0][28].equals("2")){
			strEstatus = "TURNADO";
		}else{
			strEstatus = "Recepción";
		}*/
		
		//**Fin llamada query
		try {
			con = ConexionDS.getConexion();
			ServletContext context = getServletContext();
			System.setProperty("jasper.reports.compile.class.path", context
					.getRealPath("/WEB-INF/lib/jasperreports-6.15.0.jar")
					+ System.getProperty("path.separator")
					+ context.getRealPath("/WEB-INF/"));//
			System.setProperty("jasper.reports.compile.temp", 
                    context.getRealPath("/Reportes/"));  
			//JasperCompileManager.compileReportToFile(context.getRealPath("/Reportes/ReportAsunto.jrxml"));
			File reportFile = new File(context.getRealPath("/Reportes/ReportAsunto.jasper"));
			////System.err.println("Reporte="+context.getRealPath("/Reportes/"));
			Map parameters = new HashMap();      
			parameters.put("URL_IMAGE", context.getRealPath("/Imagenes/logo_word_shcp.gif"));
			parameters.put("SUBREPORT_DIR", context.getRealPath("/Reportes/"));
			//parameters.put("URL_IMAGE", context.getRealPath("/Imagenes/issste.jpg"));
			//**Datos Basicos
			parameters.put("ENTIDAD", strEntidad);
			parameters.put("REMITENTE", strRem);
			parameters.put("CARGO_REM", strCargoRem);
			parameters.put("CORREO_REM", strCorreoRem);
			parameters.put("FIRMANTE", strGetAsuntoTurnado[0][4]);
			parameters.put("DESTINATARIO", strDes);
			parameters.put("CARGO_DES", strDesCargo);
			parameters.put("AREA_DES", strDesArea);
			parameters.put("PARA", para.trim());
			parameters.put("CC", ccp.trim());
			parameters.put("PARA_EXT", paraD.trim());
			parameters.put("ASUNTO", strGetAsuntoTurnado[0][5]);
			parameters.put("EXPEDIENTE", strExpediente);
			parameters.put("UBICACION", strUbicacion);
			parameters.put("REFERENCIA", strGetAsuntoTurnado[0][9]);
			parameters.put("TIPO_DOCTO", strTipoDocto);
			parameters.put("TRAMITE", strTramite);
			parameters.put("FECHA_RECEPCION", strFechaRep);
			parameters.put("HORA", strGetAsuntoTurnado[0][50]);
			parameters.put("FECHA_DOCTO", strFechaDoc);
			parameters.put("FECHA_CADUCIDAD", strFechaCad);
			parameters.put("FOLIO_EXTERNO", strGetAsuntoTurnado[0][16]);
			parameters.put("FOLIO_INTERMEDIO", strGetAsuntoTurnado[0][17]);
			parameters.put("SINTESIS", strGetAsuntoTurnado[0][18]);
			parameters.put("COMENTARIO", strGetAsuntoTurnado[0][19]);
                        parameters.put("COMENTARIOS", strComentario);
                        parameters.put("PALABRA_CLAVE", strGetAsuntoTurnado[0][20]);
			//**Fin Datos Basicos
			//**Evento
			parameters.put("FECHA_EVENTO", strFechaEvento);
			parameters.put("HORA_EVENTO", strHoraEvento);
			parameters.put("MIN_EVENTO", strMinEvento);
			parameters.put("LUGAR_EVENTO", strGetAsuntoTurnado[0][39]);
			//**Fin Evento 
			//**Datos del Turnado
			parameters.put("PRIORIDAD", strPrioridad);
			parameters.put("TIPO_ASUNTO", strTipoAsunto);
			parameters.put("TURNADO_AUTO", strRutaAuto);
			//Fin **Datos del Turnado
			//parameters.put("ESTATUS", strEstatus);
			parameters.put("FOLIO_REP", strGetAsuntoTurnado[0][23]);
			parameters.put("FOLIO_CONTROL", strGetAsuntoTurnado[0][45]);
			parameters.put("TIPO_ASUNTO_1", (strGetAsuntoTurnado[0][49].equals("1")?"Salida":"Entrada"));
			parameters.put("ID_ASUNTO_PARAM", strIdAsunto);
			parameters.put("DIRECTORIO", context.getRealPath("/Reportes/referenciaAsunto.jasper"));
			parameters.put("DIRECTORIO_PARA", context.getRealPath("/Reportes/para.jasper"));
			//parameters.put("DIRECTORIO_CCP", context.getRealPath("/Reportes/ccp.jasper"));
			//parameters.put("DIRECTORIO_PARAD", context.getRealPath("/Reportes/parad.jasper"));
			byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), 
									parameters, con/*new JREmptyDataSource()*/);
			arg1.setContentType("application/pdf"); 
			arg1.setContentLength(bytes.length); 
			ServletOutputStream ouputStream = arg1.getOutputStream(); 
			ouputStream.write(bytes, 0, bytes.length); 
			ouputStream.flush();
			ouputStream.close(); 
			
		}catch(JRException e){
		    //System.out.println("Error:" +e.getLocalizedMessage());
		    //display stack trace in the browser
		    StringWriter stringWriter = new StringWriter();
		    PrintWriter printWriter = new PrintWriter(stringWriter);
		    e.printStackTrace(printWriter);
		    arg1.setContentType("text/plain");
		    arg1.getOutputStream().print(stringWriter.toString());
		}
        catch(Exception e) {
            e.printStackTrace();
            //System.out.println("Error2:" +e.getMessage()); 
        }
	    finally {
	        try{con.close();}catch(Exception e) {;};
	    }

	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	    doGet(arg0, arg1);
	}

}