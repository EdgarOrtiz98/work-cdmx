package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.*;
import gob.hacienda.cgtic.siga.beans.*;


public class _Responder extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html; charset=ISO-8859-1");
    /* set up the intrinsic variables using the pageContext goober:
    ** session = HttpSession
    ** application = ServletContext
    ** out = JspWriter
    ** page = this
    ** config = ServletConfig
    ** all session/app beans declared in globals.jsa
    */
    PageContext pageContext = JspFactory.getDefaultFactory().getPageContext( this, request, response, null, true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    int __jsp_tag_starteval;
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _Responder page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("header.jsp");
        // Include 
        pageContext.include( __url,true);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      com.meve.sigma.beans.ResponderBean BResponder;
      synchronized (pageContext) {
        if ((BResponder = (com.meve.sigma.beans.ResponderBean) pageContext.getAttribute( "BResponder", PageContext.PAGE_SCOPE)) == null) {
          BResponder = (com.meve.sigma.beans.ResponderBean) new com.meve.sigma.beans.ResponderBean();
          pageContext.setAttribute( "BResponder", BResponder, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
      	String strAvance		=	"";
      	String strEstatus		=	"";
      	String strIdInstruccion	=	"";
      	String strIdAsunto		=	"";
      	String strIdHistorial	=	"";
      	String Avance1			=	"";
      	String machote			=	""; 
      	String strUsrOrg		=	"";
      	String strFolio			=	"";
      	String enviaEmailCheck	=	"";
      	
      	strIdInstruccion	=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
      	strIdAsunto			=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
      	strIdHistorial		=	(request.getParameter("id_his") != null)?request.getParameter("id_his"):"";
      	strEstatus			=	(request.getParameter("id_es") != null)?request.getParameter("id_es"):"";
      	strAvance			=	(request.getParameter("ava") != null)?request.getParameter("ava"):"";
      	Avance1				=	(request.getParameter("ava") != null)?request.getParameter("ava"):"";
      	machote				=	(request.getParameter("ma") != null)?request.getParameter("ma"):"";
      	strUsrOrg			=	(request.getParameter("us_or") != null)?request.getParameter("us_or"):"";
      	
      	if(strIdHistorial.trim().length()==0)
      		strFolio			=	ActualizaAsunto.getFolioAsunto(strIdAsunto);
      	
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp = request.getRequestURI();
      	////System.err.println("strTmp="+strTmp);
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("E/RROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[4]);
      
      	
      	String strIdUsuario		=	"";
      	String strIdUsrResp		=	"";
      	String strRespuesta		=	"";
      	String strResponderA	=	"";
      	String strAccion		=	"";
      	String strFechaCreacion	=	"";
      	String strIdMachote		=	"";
      	String nota				=	"";
      	String oficio			=	"";
      	String strIdPadre		=	"";
      	String strCount[][]		=	null;
      	String strSum[][]		=	null;
      	String strDescripcionMachote[][] = null;
      	
      	boolean esHijo = false;
      
      	strAccion	=	request.getParameter("accion");
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
              String retURI2 = (request.getParameter("retURI2")== null)?retURI:request.getParameter("retURI2");
      
      	String mensajeJS = "";
      	boolean bValidaEstatus = false;
      	strIdInstruccion  = request.getParameter("id_ins");
      	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
      	boolean eviamailResIns=   ActualizaUsuario.getEnviaEmailRespIns(session.getServletContext(),BUsuario.getIdArea());
      	boolean recibeMailRemitente=ActualizaUsuario.getNotificacionMail(ActualizaInstrucciones.getTurnador(strIdInstruccion));
      	enviaEmailCheck		=	(request.getParameter("enviaEmailCheckF") != null)?request.getParameter("enviaEmailCheckF"):"";
      	
      	if (strIdInstruccion!=null && !strIdInstruccion.equals("")){
      		if (strEstValidacion.equals(""))
      			strEstValidacion = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
                             // //System.out.println("strEstatusValidacion: "+strEstValidacion);
      		String strEstatusValida = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
                     // //System.out.println("strEstatusValida: "+strEstatusValida);
      		if (!strEstatusValida.equals(strEstValidacion)){ 
      			bValidaEstatus = true; 
      			mensajeJS = "Esta instrucción ha sido modificada por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada";
      		}
      	}
      	if (!bValidaEstatus && ActualizaAsuntoTurnado.getCountInstNoTerminadas(strIdInstruccion)){
      		bValidaEstatus = true; 
      		mensajeJS = "Esta instrucción tiene Instrucciones hijas que no han sido terminadas,\\npor lo que la acción solicitada será cancelada";
      	}
      
      	if(!bValidaEstatus && strAccion != null && strAccion.equals("guardar")){
      //                //System.err.println("Procedimiento para guardar: ");
      		strIdInstruccion  = request.getParameter("id_ins");
      		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer = application.getInitParameter("PortMail");
      		String serverName = application.getInitParameter("servername");
      		String strBase	  =	application.getInitParameter("RutaBase"); 
      		String strTurnador= ActualizaInstrucciones.getTurnador(strIdInstruccion);
      		//System.out.println("chec="+enviaEmailCheck+",parametro="+eviamailResIns);
      		if (enviaEmailCheck=="true" || enviaEmailCheck.equals("true")){
      			eviamailResIns=true;
      		}
      		else{
      			eviamailResIns=false;
      		}
      		
      	    gob.hacienda.cgtic.siga.beans.ResponderBean.responderInstruccion(request,BUsuario,strTurnador,serverName,strBase,eviamailResIns,session.getServletContext());
      	    
      	    
      		
      		String ava = ActualizaInstrucciones.getAvance(strIdInstruccion);
      		strAvance	=	ava;//request.getParameter("responderAvance");
      		float iAvance = new Float(strAvance).floatValue();
      		if(iAvance >= 100){
      
      out.write(__oracle_jsp_text[5]);
      out.print( retURI2 );
      out.write(__oracle_jsp_text[6]);
      			
      		}else{
      
      out.write(__oracle_jsp_text[7]);
      out.print( retURI );
      out.write(__oracle_jsp_text[8]);
      
      		}//cierre if de 100%
      	}//fin guardar
      	
      
      	if(!bValidaEstatus && strIdHistorial != null && strIdHistorial.trim().length()>0)
      	{
      		String strHistorial[][]	= ActualizaHistorial.getHistorial(strIdHistorial);
      		strRespuesta	=	strHistorial[0][0];
      		strAvance		=	strHistorial[0][1];
      	}
      
      out.write(__oracle_jsp_text[9]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[10]);
      out.print(strFolio);
      out.write(__oracle_jsp_text[11]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[12]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[13]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?id_ins="+strIdInstruccion+"&id_asunto="+strIdAsunto+"&id_es="+strEstatus+"&ava="+strAvance+"&us_or="+strUsrOrg+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[14]);
      out.print(nota );
      out.write(__oracle_jsp_text[15]);
      out.print(oficio );
      out.write(__oracle_jsp_text[16]);
      out.print( strIdInstruccion );
      out.write(__oracle_jsp_text[17]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[18]);
      out.print( strEstatus );
      out.write(__oracle_jsp_text[19]);
      out.print( Avance1 );
      out.write(__oracle_jsp_text[20]);
      out.print( strIdUsuario );
      out.write(__oracle_jsp_text[21]);
      out.print( strFechaCreacion );
      out.write(__oracle_jsp_text[22]);
      out.print(retURI);
      out.write(__oracle_jsp_text[23]);
      out.print(retURI2);
      out.write(__oracle_jsp_text[24]);
      out.print(strUsrOrg);
      out.write(__oracle_jsp_text[25]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[26]);
       if(strIdHistorial != null && strIdHistorial.trim().length()>0){ 
      out.write(__oracle_jsp_text[27]);
      out.print( com.meve.sigma.util.Utilerias.cambioSaltosDeLinea(strRespuesta) );
      out.write(__oracle_jsp_text[28]);
      out.print( strAvance );
      out.write(__oracle_jsp_text[29]);
       }else{ 
      out.write(__oracle_jsp_text[30]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[31]);
      
      			if (eviamailResIns && recibeMailRemitente){
      			
      out.write(__oracle_jsp_text[32]);
      
      			}
      			else{
      out.write(__oracle_jsp_text[33]);
      
      			}			
      			
      out.write(__oracle_jsp_text[34]);
      out.write(__oracle_jsp_text[35]);
       } 
      out.write(__oracle_jsp_text[36]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[37]);
      out.print( mensajeJS );
      out.write(__oracle_jsp_text[38]);

    }
    catch (Throwable e) {
      if (!(e instanceof javax.servlet.jsp.SkipPageException)){
        try {
          if (out != null) out.clear();
        }
        catch (Exception clearException) {
        }
        pageContext.handlePageException(e);
      }
    }
    finally {
      OracleJspRuntime.extraHandlePCFinally(pageContext, true);
      JspFactory.getDefaultFactory().releasePageContext(pageContext);
    }

  }
  private static final char __oracle_jsp_text[][]=new char[39][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\n<SCRIPT language=JavaScript type=text/javascript> \n\t//location.assign(\"PortalTerminado.jsp\");\n\tlocation.assign(\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\");\n</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\n<SCRIPT language=JavaScript type=text/javascript> \n\t//location.assign(\"PortalTramite.jsp\");\n\tlocation.assign(\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\");\n</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<TITLE>Responder</TITLE>\n<STYLE type=text/css>.clsCursor {\n\tCURSOR: hand\n} </STYLE>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\nvar botonBandera = true; \n\nfunction SaveHTMLPage() {\n\tdoc = document.responder;\n\tvalida = 0;\n\tmsg=\"\";\n\tavance = ".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\n\tif (doc.responderEnviarEmail.checked){\n\t\tdoc.enviaEmailCheckF.value=\"true\";\t\t\n\t}\n\telse{\t\t\n\t\tdoc.enviaEmailCheckF.value=\"false\";\n\t}\t\n\tif (doc.responderAvance.value == avance){\n\t\tvalida = 1;\n\t\tmsg = msg + \" Debe capturar el Avance de la instrucción \"+ \"\\n\";\n\t}\n\tif (doc.responderAvance.value > 100){\n\t\tvalida = 1;\n\t\tmsg = msg + \" El Avance maximo de una instrucción es el 100% \"+ \"\\n\";\n\t}\n\tif (doc.responderAvance.value <= 0){\n\t\tvalida = 1;\n\t\tmsg = msg + \" El Avance no puede ser menor o igual a cero \"+ \"\\n\";\n\t}\n\t//if (doc.responderAvance.value < avance){\n\t//\tvalida = 1;\n\t//\tmsg = msg + \" El Avance debe ser mayor al \"+avance+\"% \"+ \"\\n\";\n\t//}\n//\tif (!validaCorreos(doc.responderA.value)){\n//\t\tvalida = 1;\n//\t\tmsg = msg + \" El campo \\\"Informar a\\\" contiene información invalida \"+ \"\\n\";\n//\t}\n\tif (valida == 0){\n\t\t//limitaTextArea(doc.contestar,'Respuesta a la instrucción', '4000');\n\n\t\tmensaje = 'El campo Respuesta a la instrucción contiene caracteres invalidos \\nPresione Aceptar para modificarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.contestar.value)){\n\t\t\tif (confirm(mensaje)){\n\t\t\t\tdoc.contestar.value = quitaCE(doc.contestar.value);\n\t\t\t\t//alert(doc.contestar.value);\n\t\t\t}\n\t\t\telse{\n\t\t\t\tvalida = 2;\n\t\t\t\tbotonBandera = true; \n\t\t\t}\n\t\t}\n\t}\n\tif (Trim(doc.contestar.value) == \"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debe capturar una Respuesta a la instrucción\t\"+ \"\\n\";\n\t}\n\tif (valida == 1){\n\t\talert(msg);\n\t\tbotonBandera = true; \n\t} \n\n\tif (valida == 0){\n\t\tdoc.accion.value=\"guardar\";\n\t\tif (confirm(\"está usted seguro que desea Responder la instrucción?\")) \n\t\t{\n\t\t\tdoc.submit();\n\t\t}else{\n\t\t\talert(\"Su petición de Respuesta ya fue cancelada\");\n\t\t\tbotonBandera = true; \n\t\t}\n\t}\n}\n\nfunction detectaComilla(texto){\n\n\tif (texto.indexOf('\\'')>=0){\n\t\treturn true;\n\t}\n\telse{ \n\t\treturn false;\n\t}\n}\n\nfunction quitaComilla(texto){\n\n\tfor (i=0; i<texto.length; i++){\n\t\tc=texto.charAt(i);\n\t\tif(c=='\\''){\n\t\t\taux1 = texto.substring(0,i);\n\t\t\taux2 = texto.substring(i+1,texto.length);\n\t\t\ttexto = aux1 + aux2;\n\t\t\tcontinue;\n\t\t}\n\t}\n\t\n\treturn texto;\n}\n\nfunction quitaSaltoDeLinea(texto){\n\n\twhile (texto.indexOf('\\n')!=-1){\n\t\ti = texto.indexOf('\\n')\n\t\taux1 = texto.substring(0,i-1);\n\t\taux2 = texto.substring(i+1,texto.length);\n\t\ttexto = aux1 + '' + aux2;\n\t}\n\treturn texto;\n}\n\nfunction validaCorreos(texto){\n\n\twhile (texto.indexOf(',')!=-1){\n\t\ti=texto.indexOf(',');\n\t\tmail \t= texto.substring(0,i);\n\t\ttexto \t= texto.substring(i+1,texto.length);\n\t\tif (!isCorreo(mail)){\n\t\t\treturn false;\n\t\t}\n\t\tif (Trim(mail)==\"\"){\n\t\t\treturn false;\n\t\t}\n\t}\n\tmail = texto;\n\tif (!isCorreo(mail)){\n\t\treturn false;\n\t}\n\treturn true;\n}\n\nfunction AnexarArchivoRes(){\n\tlocation.assign('ImportarCM.jsp?Folio=".toCharArray();
    __oracle_jsp_text[11] = 
    "&IdAsunto=".toCharArray();
    __oracle_jsp_text[12] = 
    "&a=6&id_ins=".toCharArray();
    __oracle_jsp_text[13] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[14] = 
    "');\n}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"timer_load();\"\n\t\tonMouseMove=\"limitaTextArea(document.responder.contestar,'Respuesta a la instrucción','4000');\n\t\t\t\t\tlimitaTextArea(document.responder.responderA,'Informar a','300')\"\n\t\tonKeyPress=\"timer_reload();\" onClick=\"timer_reload();\">\n\n<FORM action=\"Responder.jsp\" name=\"responder\" method=\"post\">\n<INPUT type=\"hidden\" name=\"enviaEmailCheckF\" value=\"otro\">\n<INPUT type=\"hidden\" name=\"nota\" value='".toCharArray();
    __oracle_jsp_text[15] = 
    "'>\n<INPUT type=\"hidden\" name=\"oficio\" value='".toCharArray();
    __oracle_jsp_text[16] = 
    "'>\n<INPUT type=\"hidden\" value=\"guardar\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"id_ins\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"id_asunto\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"id_es\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"ava\">\n<INPUT type=\"hidden\" name=\"idUsuario\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"fechaIni\">\n<INPUT name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" type=\"hidden\">\n<INPUT name=\"retURI2\" value=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\" type=\"hidden\">\n<INPUT name=\"us_or\" value=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\" type=\"hidden\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"1000\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"34%\"><INPUT class=\"blue100\" onclick=\"RegresarResp()\"\n\t\t\t\ttype=\"button\" value=\"Regresar\"></TD>\n\t\t\t<TD width=\"20%\">\n\t\t\t\t&nbsp;\n\t\t\t</TD>\n\t\t\t<TD width=\"20%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<DIV class=documentBody id=Body align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"1000\">\n\t<TBODY>\n\t\t<TR align=\"left\">\n\t\t\t<TD align=\"left\" width=\"90%\"><font face=\"Arial\" color=\"#004080\" size=\"2\">".toCharArray();
    __oracle_jsp_text[28] = 
    "</font>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\" align=\"left\"> \n\t\t\t<td align=\"left\" width=\"15%\">&nbsp;</td>\n\t\t</tr>\n\t\t<TR align=\"left\">\n\t\t\t<TD width=\"10%\" align=\"left\" ><font face=\"Arial\" color=\"#004080\" size=\"2\">Avance: ".toCharArray();
    __oracle_jsp_text[29] = 
    "%</font>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<br>\n".toCharArray();
    __oracle_jsp_text[30] = 
    "\n<!-- \n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY><tr>\n\n\t\t\t<TD width=\"994\">\n\t\t\t<font face=\"Arial\" color=\"#004080\" size=\"2\">Informar\n\t\t\ta: (correo Electrónico)<BR>\n\t\t\t</font>  <INPUT type=\"hidden\" name=\"contestar\">  \n\t\t\t<font face=\"Verdana\" color=\"#00204f\"\n\t\t\tsize=\"2\"> \n\t\t\t<TEXTAREA name=\"responderA\" cols=80 rows=\"3\" class=\"blue500\" onfocus=\"\" \n\t\t\t\t\t\tonkeypress=\"NoAceptaSaltosDeLinea();\"\n\t\t\t\t\t\tonKeyDown=\"limitaTextArea(document.responder.responderA,'Informar a','300')\"></TEXTAREA>\n\t\t\t</font>\n\t\t\t</TD>\n\t\t</tr>\n</table>\n</DIV> \n<br>\n-->\n\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\n\t<tr valign=\"top\">\t\t\n\t\t<td width=231><font face=\"Arial\" color=\"#004080\" size=\"2\">Avance:</font>\n\t\t<input name=\"responderAvance\" value=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\" Size=4 onKeyPress='AceptaSoloTeclaNumericaYPunto();'\n\t\t\tclass=\"blue50\" maxlength=\"4\"> <font face=\"Arial\" color=\"#004080\" size=\"2\">%</font>\n\t\t</td>\n\t\t\n\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t<td width=\"527\"><font face=\"Arial\" color=\"#004080\" size=\"2\"> <input\n\t\t\ttype=\"checkbox\" name=\"responderEnviarEmail\" value=\"\" checked > ¿Desea enviar respuesta al remitente por correo Electrónico? </font>\n\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t<td width=\"527\"><font face=\"Arial\" color=\"#004080\" size=\"2\"> <input\n\t\t\t\ttype=\"hidden\" name=\"responderEnviarEmail\" value=\"\" ></font>\t\t\t\t\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t</td>\t\n\t</tr>\n\t\n\t<tr valign=\"top\">\n\t\t<td width=\"231\"><font face=\"Arial\" color=\"#004080\" size=\"2\"> <input\n\t\t\ttype=\"checkbox\" name=\"responderTerminar\" value=\"\"\n\t\t\tonclick=\"terminarInstruccion()\"> Dar por terminada la instrucción? </font>\n\t\t</td>\t\t\t\t\t\t\t\t\t\t\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"231\"><input type=\"checkbox\" name=\"firmaDigital\"\n\t\t\tstyle=\"display:none\" onclick=\"firmarDigitalmente()\" value=\"off\">\n\t\t&nbsp;<input type=\"text\" name=\"label1\" style=\"display:none\"\n\t\t\tvalue=\"¿Firmar digitalmente?\" disabled></td>\n\t</tr>\n\t\t\n\t<tr valign=\"top\">\n\t\t<td width=\"471\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n\t\n\t<tr valign=\"top\">\n\t\t<td width=\"758\" bgcolor=\"#00204F\" colspan=\"2\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t</tr>\n</table>\n<br>\n\n<TABLE cellSpacing=0 cellPadding=0 border=0 width=\"1000\">\n  <TBODY>\n  \t<TR align=\"left\">\n    \t<TD align=\"left\">\n\t\t\t<A \tonclick=\"if(botonBandera){botonBandera=false; RegresarResp();&#13;return false;}\" onMouseOver=\"document.Regresar.src='../Imagenes/NavLeft2.gif';\"\n\t\t\t\tonMouseOut=\"document.Regresar.src='../Imagenes/NavLeft.gif';\">\n\t\t\t<IMG src=\"../Imagenes/NavLeft.gif\" border=0 alt=\"Regresar\" name=\"Regresar\"></A>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<A onclick=\"if(botonBandera){botonBandera=false; SaveHTMLPage();return false;}\" onMouseOver=\"document.Salvar.src='../Imagenes/Save2.gif';\"\n\t\t\t\tonMouseOut=\"document.Salvar.src='../Imagenes/Save.gif';\">\n\t\t\t<IMG alt=\"Guardar Respuesta\" src=\"../Imagenes/Save.gif\" border=\"0\" name=\"Salvar\"></A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t<br>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<TD>\n\t\t\t<TEXTAREA name=\"contestar\" class=\"blue1000\" rows=\"20\"\n\t\t\t\tonKeyDown=\"limitaTextArea(document.responder.contestar,'Respuesta a la instrucción','4000');\"></TEXTAREA>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[36] = 
    " <INPUT type=\"hidden\" value=false name=\"autenticado\"></FORM>\n<script type=\"text/javascript\">\n\nif (".toCharArray();
    __oracle_jsp_text[37] = 
    "){\n\tvar mensaje = '".toCharArray();
    __oracle_jsp_text[38] = 
    "';\n\talert(mensaje);\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n\n</script>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
