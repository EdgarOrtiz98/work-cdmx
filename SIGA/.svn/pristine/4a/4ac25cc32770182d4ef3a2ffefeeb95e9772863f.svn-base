package com.meve.sigma.scp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreaAsuntos extends HttpServlet implements Servlet {

	public CreaAsuntos() { 
		super();
	}

protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)throws ServletException, IOException {

		String[][] idAsuntoInsertado;
		String strIdAsunto = (arg0.getParameter("idAsunto") == null)? "" :arg0.getParameter("idAsunto"); //Solo
		String strInserta = (arg0.getParameter("inAs")== null)? "" :arg0.getParameter("inAs");
		
		String strIdEntidad = (arg0.getParameter("arg1_")==null)? "" :arg0.getParameter("arg1_");//16
		String strIdRemitente = (arg0.getParameter("arg2")==null)? "" :arg0.getParameter("arg2");//23
		String strFirmante = (arg0.getParameter("arg3")==null)? "" :arg0.getParameter("arg3"); 
		String strAsunto = (arg0.getParameter("arg4")==null)? "" :arg0.getParameter("arg4");													 // SERVLET
		String strIdExpediente = (arg0.getParameter("arg5")==null)? "" :arg0.getParameter("arg5");//null
		String strIdTipoDocto = (arg0.getParameter("arg6")==null)? "" :arg0.getParameter("arg6");//null
		String strFechaRecepcion = (arg0.getParameter("arg7")==null)? "" :arg0.getParameter("arg7"); //19/04/2007															  // 02:04:00
		String strFechaDocto = (arg0.getParameter("arg8")==null)? "" :arg0.getParameter("arg8");//19/04/2007
		String strFechaCaducidad = (arg0.getParameter("arg9")==null)? "" :arg0.getParameter("arg9"); //27/04/2007															  // 05:04:00
		String strFolioExterno = (arg0.getParameter("arg10")==null)? "" :arg0.getParameter("arg10"); //fdgdfgdf3465365465sdfdsfsdf
		String strFolioIntermedio = (arg0.getParameter("arg11")==null)? "" :arg0.getParameter("arg11");//""
		String strSintesis = (arg0.getParameter("arg12")==null)? "" :arg0.getParameter("arg12"); //""
		String strComentarios = (arg0.getParameter("arg13")==null)? "" :arg0.getParameter("arg13"); //""
		String strPalabraClave = (arg0.getParameter("arg14")==null)? "" :arg0.getParameter("arg14");//""
		String strAsuntoAnterior = (arg0.getParameter("arg15")==null)? "" :arg0.getParameter("arg15"); //""
		String strIdPrioridad = (arg0.getParameter("arg17")==null)? "" :arg0.getParameter("arg17"); //""
		String strFolioGenerado = (arg0.getParameter("arg18")==null)? "" :arg0.getParameter("arg18");//folio
		String strIdUsrCaptura = (arg0.getParameter("arg19")==null)? "" :arg0.getParameter("arg19"); //25
		String strFechaCreacion = (arg0.getParameter("arg20")==null)? "" :arg0.getParameter("arg20"); //19/04/2007
		String strAreaUs = (arg0.getParameter("arg21")==null)? "" :arg0.getParameter("arg21"); //16
		String strIdTipoAsunto = (arg0.getParameter("arg22")==null)? "" :arg0.getParameter("arg22");//null
		String strIdDestinatario = (arg0.getParameter("arg23")==null)? "" :arg0.getParameter("arg23");//25
		String strControl = (arg0.getParameter("arg24")==null)? "" :arg0.getParameter("arg24"); //1
		String strEstatus = (arg0.getParameter("arg25")==null)? "" :arg0.getParameter("arg25");//0
		String strPara = (arg0.getParameter("arg26")==null)? "" :arg0.getParameter("arg26"); //ate_05/ate_05|CDDDR/Asistente
		String strCC = (arg0.getParameter("arg27")==null)? "" :arg0.getParameter("arg27"); //10|CE/Asistente
		String strIdsPara = (arg0.getParameter("arg28")==null)? "" :arg0.getParameter("arg28"); //,145,146,140,
		String strIdsCC = (arg0.getParameter("arg29")==null)? "" :arg0.getParameter("arg29"); //null
		String lugarEvento = (arg0.getParameter("arg30")==null)? "" :arg0.getParameter("arg30"); //null
		String stringHoraEvento = (arg0.getParameter("arg31")==null)? "" :arg0.getParameter("arg31");//-1
		String strFechaEvento = (arg0.getParameter("arg32")==null)? "" :arg0.getParameter("arg32"); //null
		String stringMinEvento = (arg0.getParameter("arg33")==null)? "" :arg0.getParameter("arg33"); //-1
		String strParaE = (arg0.getParameter("arg34")==null)? "" :arg0.getParameter("arg34");
		String strIdsParaE = (arg0.getParameter("arg35")==null)? "" :arg0.getParameter("arg35"); //,77,76,
		String strTramite = (arg0.getParameter("arg36")==null)? "" :arg0.getParameter("arg36"); //-1
		String strTipoFolio = (arg0.getParameter("arg37")==null)? "" :arg0.getParameter("arg37");//1

		if (strInserta.equals("1")) {
			
			GeneraAsunto.asuntoInsercion(strIdEntidad, strIdRemitente,
					strFirmante, strAsunto, "", "", 
					strFechaRecepcion, strFechaDocto, strFechaCaducidad,
					strFolioExterno, strFolioIntermedio, strSintesis,
					strComentarios, strPalabraClave, strAsuntoAnterior,
					/*strIdPrioridad*/"", strFolioGenerado, strIdUsrCaptura,
					strFechaCreacion, strAreaUs, /*strIdTipoAsunto*/"",
					strIdDestinatario, strControl, strEstatus, strPara, strCC,
					strIdsPara, strIdsCC, lugarEvento, /*stringHoraEvento*/"",
					/*strFechaEvento*/"", /*stringMinEvento*/"", strParaE, strIdsParaE,
					/*strTramite*/"", strTipoFolio);

			if (strFolioIntermedio != null) {
				idAsuntoInsertado = GeneraAsunto
						.getIdAsuntoSIGA(strFolioIntermedio);
				String idAsuntoSiga = idAsuntoInsertado[0][0];
				//System.out.println(idAsuntoSiga);
				PrintWriter pw = arg1.getWriter();
				pw.println(idAsuntoInsertado);
			}
			
		} else {

			String strAvance = GeneraAsunto.getAvanceAsunto(strIdAsunto);
			String strInstAsunt = GeneraAsunto
					.getCountInstSinTurnar(strIdAsunto);
			String strFolioAsu = GeneraAsunto.getFolioAsunto(strIdAsunto);
			String strFechaInicio = GeneraAsunto
					.getFechaInicioAsunto(strIdAsunto);
			String strFechaven = GeneraAsunto.getFechaVencimiento(strIdAsunto);

		}
	}	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
			doGet(arg0, arg1);
	}

}