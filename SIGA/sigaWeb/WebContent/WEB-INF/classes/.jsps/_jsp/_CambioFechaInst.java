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
import java.util.*;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;


public class _CambioFechaInst extends com.orionserver.http.OrionHttpJspPage {


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
    _CambioFechaInst page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("header.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      com.meve.sigma.beans.EscrituraBean BEscritura;
      synchronized (pageContext) {
        if ((BEscritura = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura", PageContext.PAGE_SCOPE)) == null) {
          BEscritura = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
          pageContext.setAttribute( "BEscritura", BEscritura, PageContext.PAGE_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[6]);
      
      	String strIdInstruccion		=	"";
      	String strIdUsuarioTurno	=	"";
      	String strNombre			=	"";
      	String strCargo	    		=	"";
      	String strCorreo			=	"";
      	String strAccion			=	"";
      	String strComentario		=	"";
      	String strFechaCambio		=	"";
      	String strTieneFecha		=	"";
      	String strRechazar			=	"";
      	String strAceptar			=	"";
      	String strNombreRed			=	"";
      	String strNombreCorreo[][]	=	null;
      	String strFechas[][]		=	null;
      	boolean bCambioFecha		=	false;
      
      	String strRutaBase 			= "";
      
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
              //System.out.println("Pagina siguiente: " + retURI);
      	Vector finesSemana = com.meve.sigma.util.Utilerias.getFinesSemana(1,1);
      	String diasFestivos[][] = ActualizaDiaFestivo.getListaDiasFestivos();
      	if (diasFestivos!=null && diasFestivos.length>0){
      		for (int i=0; i<diasFestivos.length; i++){
      			finesSemana.add(com.meve.sigma.util.Utilerias.formatearFechas(diasFestivos[i][1]));
      		}
      	}
      
      	strIdUsuarioTurno	=	request.getParameter("tur");
      	strIdInstruccion	=	request.getParameter("id_ins");
      	strTieneFecha		=	(request.getParameter("i")==null)?"":request.getParameter("i");
      	strAccion			=	request.getParameter("accion");
      	strRechazar			=	request.getParameter("rechazar1");
      	strAceptar			=	request.getParameter("aceptar1");
      	String strRedirec	=	request.getParameter("re");
      	String strIdAsunto	=	request.getParameter("id_asunto");
      	strNombreCorreo		=	ActualizaUsuario.NombreMailUsuario(strIdUsuarioTurno);
      	strFechas			=	ActualizaInstrucciones.getFechasInstruccion(strIdInstruccion);
      	if(strNombreCorreo != null && strNombreCorreo.length > 0){
      		strNombre	=	strNombreCorreo[0][0];
      		strCorreo	=	strNombreCorreo[0][1];
      		strCargo = strNombreCorreo[0][2];
      	}
      
      	strRutaBase =  (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
      
      	boolean bValidaEstatus = false;
      	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
      	if (strIdInstruccion!=null && !strIdInstruccion.equals("")){
      		if (strEstValidacion.equals("")){
      			strEstValidacion = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
      		}
      		String strEstatusValida = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruccion);
      		if (!strEstatusValida.equals(strEstValidacion)){ 
      			bValidaEstatus = true; 
      		}
      	}
      
      	//**Cuando el responsable de la instrución hace la solicitud de cambio
      	if(!bValidaEstatus && strAccion != null && strAccion.equals("cambio")){
      		strComentario		=	request.getParameter("comentarioFecha");
      		strIdInstruccion	=	request.getParameter("id_ins");
      		strFechaCambio		=	request.getParameter("cambioFechaFin");
      		String fecha		=	request.getParameter("fechaVenci");
      		strIdAsunto		=	request.getParameter("id_asunto");
      		String serverMail 	= 	session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer 	= 	application.getInitParameter("PortMail");
      		String serverName 	= 	application.getInitParameter("servername");
                      
      		bCambioFecha	=	ActualizaInstrucciones.actualizarFechaCambio(strFechaCambio, 
      															strIdInstruccion, strComentario);
      
      		boolean bInsHis	=	ActualizaHistorial.insertarSolCambioFecha(strIdInstruccion,
      							strComentario, Utilerias.formatearFechas(fecha), strFechaCambio,  
      							BUsuario.getCargo()+" / "+BUsuario.getNombre(), BUsuario.getIdUsuario(), strIdAsunto);
      
      		if(BUsuario.getSolCambio()){
      				SenderMail sender = new SenderMail();
      				if (ActualizaUsuario.getNotificacionMail(strIdUsuarioTurno)){
      					sender.sendSolCambioFechaInst(	BUsuario.getCargo()+"/"+BUsuario.getNombre(), BUsuario.getCorreo(), 
      												strCargo, strCorreo, strIdInstruccion,
      												strComentario, serverName,strRutaBase,session.getServletContext());
      				}
      		}
      		/*if(strRedirec.equals("1")){
      			strNombreRed = "InstruccionesAtender";
      		}
      		if(strRedirec.equals("2")){
      			strNombreRed = "InstruccionHija";
      		}
      		if(strRedirec.equals("3")){
      			strNombreRed = "InstruccionTurnada";
      		}*/
      		try{
                 response.sendRedirect(retURI);
      		}catch(java.io.IOException io){
      		}
      	}
      	else if(!bValidaEstatus && strRechazar != null && strRechazar.equals("Re")){
      		strComentario	=	request.getParameter("comentarioFecha");
      		strIdInstruccion=	request.getParameter("id_ins");
      		String fecha	=	request.getParameter("fechaVenci");
      		strIdAsunto		=	request.getParameter("id_asunto");
      		String strD[][]	=	ActualizaInstrucciones.getSolicitudCambioId(strIdInstruccion);
      		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer = application.getInitParameter("PortMail");
      		String serverName = application.getInitParameter("servername");
      		
      		bCambioFecha	=	ActualizaInstrucciones.actualizaRechazoCambio(strIdInstruccion);
      		boolean bInsHis	=	ActualizaHistorial.insertarSolCambioFechaRechazo(strIdInstruccion,
      							strComentario, 
      							BUsuario.getCargo()+" / "+BUsuario.getNombre(), BUsuario.getIdUsuario(), strIdAsunto);
      
      		//if(BUsuario.getRespCambio()){
      		if(true){
      		
      				SenderMail sender = new SenderMail();
      				if (ActualizaUsuario.getNotificacionMail(strD[0][5])){
      					sender.sendRespuestaCambioFecha(BUsuario.getCargo()+"/"+BUsuario.getNombre(), BUsuario.getCorreo(),
      							strD[0][6], strD[0][4],
      							strIdInstruccion, strComentario,
      							2, serverMail,session.getServletContext());
      				}
      		}
      		/*if(strRedirec.equals("1")){
      			strNombreRed = "InstruccionesAtender";
      		}
      		if(strRedirec.equals("2")){
      			strNombreRed = "InstruccionHija";
      		}
      		if(strRedirec.equals("3")){
      			strNombreRed = "InstruccionTurnada";
      		}*/
      		try{
                          //	response.sendRedirect(""+strNombreRed+".jsp?id_ins="+strIdInstruccion);
                          response.sendRedirect(retURI);
      		}catch(java.io.IOException io){
      			//System.err.println("Error de response->"+io);
      		}
      	}
      	else if(!bValidaEstatus && strAceptar != null && strAceptar.equals("Ac")){
      		strComentario	=	request.getParameter("comentarioFecha");
      		strIdInstruccion=	request.getParameter("id_ins");
      		String fecha	=	request.getParameter("fechaVenci");
      		strIdAsunto		=	request.getParameter("id_asunto");
      		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer = application.getInitParameter("PortMail");
      		String serverName = application.getInitParameter("servername");
      		String strD[][]	=	ActualizaInstrucciones.getSolicitudCambioId(strIdInstruccion);
      		bCambioFecha	=	ActualizaInstrucciones.actualizaFechaVencimiento(strIdInstruccion, Utilerias.formatearFechas(strD[0][0]));
      
      		boolean bInsHis	=	ActualizaHistorial.insertarSolCambioFechaAceptacion(strIdInstruccion,
      							strComentario, 
      							BUsuario.getCargo()+" / "+BUsuario.getNombre(), BUsuario.getIdUsuario(), strIdAsunto);
      		
      		//if(BUsuario.getRespCambio()){
      		if(true){
      				SenderMail sender = new SenderMail();
      				if (ActualizaUsuario.getNotificacionMail(strD[0][5])){
      					sender.sendRespuestaCambioFecha(BUsuario.getCargo()+"/"+BUsuario.getNombre(), BUsuario.getCorreo(),
      												strD[0][6], strD[0][4],
      												strIdInstruccion, strComentario,
      												1, serverMail, session.getServletContext());
      				}
      		}
      		/*if(strRedirec.equals("1")){
      			strNombreRed = "InstruccionesAtender";
      		}
      		if(strRedirec.equals("2")){
      			strNombreRed = "InstruccionHija";
      		}
      		if(strRedirec.equals("3")){
      			strNombreRed = "InstruccionTurnada";
      		}*/
      		try{
      		    //	response.sendRedirect(""+strNombreRed+".jsp?id_ins="+strIdInstruccion);
                          response.sendRedirect(retURI);
      		}catch(java.io.IOException io){
      			//System.err.println("Error de response->"+io);
      		}
      	}
      
      	if(BUsuario.getIdUsuario().equals(strIdUsuarioTurno))
      		BEscritura.setValue(true);
      	else
      		BEscritura.setValue(false);
      
      out.write(__oracle_jsp_text[7]);
       	for (int ik=0; ik<finesSemana.size(); ik++){ 
      out.write(__oracle_jsp_text[8]);
      out.print( (String)finesSemana.get(ik) );
      out.write(__oracle_jsp_text[9]);
      	} 
      out.write(__oracle_jsp_text[10]);
      out.print(Utilerias.getFechaActual());
      out.write(__oracle_jsp_text[11]);
      out.print(strIdUsuarioTurno);
      out.write(__oracle_jsp_text[12]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[13]);
      out.print(strRedirec);
      out.write(__oracle_jsp_text[14]);
      out.print(retURI);
      out.write(__oracle_jsp_text[15]);
      out.print(strFechas[0][1]);
      out.write(__oracle_jsp_text[16]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[17]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[18]);
       if(strTieneFecha.equals("2")){ 
      out.write(__oracle_jsp_text[19]);
       }else if(strTieneFecha.equals("1")){ 
      out.write(__oracle_jsp_text[20]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_1=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_1.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[21]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_2=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[22]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[23]);
            {
              org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_3=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[24]);
                } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[25]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[26]);
       } 
      out.write(__oracle_jsp_text[27]);
       if(strTieneFecha.equals("2")){ 
      out.write(__oracle_jsp_text[28]);
      out.print(Utilerias.formatearFechas(strFechas[0][0]));
      out.write(__oracle_jsp_text[29]);
      out.print(Utilerias.formatearFechas(strFechas[0][1]));
      out.write(__oracle_jsp_text[30]);
      out.print(ActualizaUsuario.NombreUsuario(strIdUsuarioTurno));
      out.write(__oracle_jsp_text[31]);
       
      	} else if(strTieneFecha.equals("1")){
      		String strDatos[][] = ActualizaInstrucciones.getSolicitudCambio(strIdInstruccion);
      
      out.write(__oracle_jsp_text[32]);
      out.print(strDatos[0][3]);
      out.write(__oracle_jsp_text[33]);
      out.print(Utilerias.formatearFechas(strDatos[0][2]));
      out.write(__oracle_jsp_text[34]);
      out.print(Utilerias.formatearFechas(strDatos[0][0]));
      out.write(__oracle_jsp_text[35]);
      out.print(strDatos[0][1] );
      out.write(__oracle_jsp_text[36]);
      {
        org.apache.taglibs.standard.tag.common.core.ChooseTag __jsp_taghandler_4=(org.apache.taglibs.standard.tag.common.core.ChooseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.ChooseTag.class,"org.apache.taglibs.standard.tag.common.core.ChooseTag");
        __jsp_taghandler_4.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[37]);
            {
              org.apache.taglibs.standard.tag.rt.core.WhenTag __jsp_taghandler_5=(org.apache.taglibs.standard.tag.rt.core.WhenTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.WhenTag.class,"org.apache.taglibs.standard.tag.rt.core.WhenTag test");
              __jsp_taghandler_5.setParent(__jsp_taghandler_4);
              __jsp_taghandler_5.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${BEscritura.value}",java.lang.Boolean.class, __ojsp_varRes,null)));
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[38]);
                } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[39]);
            {
              org.apache.taglibs.standard.tag.common.core.OtherwiseTag __jsp_taghandler_6=(org.apache.taglibs.standard.tag.common.core.OtherwiseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class,"org.apache.taglibs.standard.tag.common.core.OtherwiseTag");
              __jsp_taghandler_6.setParent(__jsp_taghandler_4);
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[40]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[41]);
          } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[42]);
       } 
      out.write(__oracle_jsp_text[43]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[44]);

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
  private static final char __oracle_jsp_text[][]=new char[45][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Cambio de Fecha</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\">\n<!--\n\t\n\tfunction validaFechaFinesSem(campoFecha){\n\t\tdoc = document.cambioFecha;\n\t\tvar valida = 0 \n\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\t\n\t\tif (campoFecha != null && campoFecha.value == \"".toCharArray();
    __oracle_jsp_text[9] = 
    "\") {\n\t\t\tvalida =1;\n\t\t}\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\tif (valida == 1){\n\t\t\talert(\"La fecha seleccionada no es laborable\");\n\t\t\tcampoFecha.value = \"\";\n\t\t}\n\t\tif (valida==0 && doc.cambioFechaFin.value!=\"\" && comparaFechas(doc.cambioFechaFin.value,\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\")==-1){\n\t\t\talert(\"La Fecha no puede ser menor a la fecha actual\");\n\t\t\tcampoFecha.value = \"\";\n\t\t}\n\t}\n//-->\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\"\n\tonMouseMove=\"limitaTextArea(document.cambioFecha.comentarioFecha,'Comentario','4000');\n\t\tvalidaFechaFinesSem(document.cambioFecha.cambioFechaFin);\">\n<FORM name=\"cambioFecha\" action=\"CambioFechaInst.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"cambiar\" name=\"accion\">\n<INPUT type=\"hidden\" value=\" \" name=\"rechazar1\">\n<INPUT type=\"hidden\" value=\" \" name=\"aceptar1\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"tur\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"id_ins\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"re\">\n<INPUT name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" type=\"hidden\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"fechaVenci\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"id_asunto\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"92\">&nbsp;</TD>\n\t\t\t<TD width=\"44\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"344\" align=\"right\"><b><font size=\"4\" color=\"#00204F\"\n\t\t\t\tface=\"Verdana\"> Solicitud de Cambio de Fecha</font></b></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\">".toCharArray();
    __oracle_jsp_text[19] = 
    " <INPUT\n\t\t\t\tclass=\"blue100\" onclick=\"regresarCambio()\" type=\"button\"\n\t\t\t\tvalue=\"Cancelar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <INPUT\n\t\t\t\tclass=\"blue100\" onclick=\"solicitarCambio()\" type=\"button\"\n\t\t\t\tvalue=\"Aceptar\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t<INPUT\n\t\t\t\tclass=\"blue100\" onclick=\"regresarCambio()\" type=\"button\"\n\t\t\t\tvalue=\"Regresar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<INPUT\n\t\t\t\tclass=\"blue100\" onclick=\"rechazarCambio()\" type=\"button\"\n\t\t\t\tvalue=\"Rechazar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <INPUT\n\t\t\t\tclass=\"blue100\" onclick=\"aceptarCambio()\" type=\"button\"\n\t\t\t\tvalue=\"Aceptar\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t<INPUT\n\t\t\t\tclass=\"blue100\" onclick=\"regresarCambio()\" type=\"button\"\n\t\t\t\tvalue=\"Regresar\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"672\" bgcolor=\"#00204f\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n".toCharArray();
    __oracle_jsp_text[28] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"390\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha\n\t\t\tInicio:</FONT></b></TD>\n\t\t\t<TD width=\"192\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t</FONT></TD>\n\t\t\t<TD width=\"144\"><b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Fecha\n\t\t\tFin:</FONT></b></TD>\n\t\t\t<TD width=\"390\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">".toCharArray();
    __oracle_jsp_text[30] = 
    "</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"390\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Nueva\n\t\t\tFecha Solicitada:</FONT></b></TD>\n\t\t\t<TD width=\"192\"><INPUT name=\"cambioFechaFin\" value=\"\"\n\t\t\t\tonfocus=\"blur();\"\n\t\t\t\tonclick=\"document.forms.cambioFecha.cambioFechaFin.value=''\"\n\t\t\t\tclass=\"blue100\"> <A><IMG height=\"20\" alt=\"\"\n\t\t\t\tsrc=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\"\n\t\t\t\tonclick='show_calendar(\"forms[0].cambioFechaFin\");'></A> <FONT\n\t\t\t\tface=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"390\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"390\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Turnador:</FONT></b>\n\t\t\t</TD>\n\t\t\t<TD colspan=\"3\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"> ".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"390\">&nbsp;</TD>\n\t\t</TR> \n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Razón\n\t\t\tde Cambio:</FONT></b></TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t\t<TEXTAREA cols=\"50\" rows=\"5\" class=\"blue500\"\n\t\t\t\tname=\"comentarioFecha\"\n\t\t\t\tonKeyDown=\"limitaTextArea(document.cambioFecha.comentarioFecha,'Comentario','4000')\"></TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[32] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"71\">&nbsp;</TD>\n\t\t\t<TD width=\"95\">&nbsp;</TD>\n\t\t\t<TD width=\"59\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"644\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"> El\n\t\t\tPuesto: <b>".toCharArray();
    __oracle_jsp_text[33] = 
    " </b>, ha solicitado que se haga una\n\t\t\tprorroga en la Fecha de Vencimiento de la instrucción que\n\t\t\toriginalmente termina el <b>".toCharArray();
    __oracle_jsp_text[34] = 
    "</b>\n\t\t\ta la fecha solicitada por el usuario que es el <b>".toCharArray();
    __oracle_jsp_text[35] = 
    "</b>\n\t\t\t</FONT></TD>\n\t\t\t<TD width=\"71\">&nbsp;</TD>\n\t\t\t<TD width=\"95\">&nbsp;</TD>\n\t\t\t<TD width=\"59\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"71\">&nbsp;</TD>\n\t\t\t<TD width=\"95\">&nbsp;</TD>\n\t\t\t<TD width=\"59\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"644\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"> La Razón\n\t\t\tde la solicitud de cambio de fecha es la siguiente: </FONT></TD>\n\t\t\t<TD width=\"71\">&nbsp;</TD>\n\t\t\t<TD width=\"95\">&nbsp;</TD>\n\t\t\t<TD width=\"59\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"71\">&nbsp;</TD>\n\t\t\t<TD width=\"95\">&nbsp;</TD>\n\t\t\t<TD width=\"59\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"644\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\"> <b>".toCharArray();
    __oracle_jsp_text[36] = 
    "</b>\n\t\t\t</FONT></TD>\n\t\t\t<TD width=\"71\">&nbsp;</TD>\n\t\t\t<TD width=\"95\">&nbsp;</TD>\n\t\t\t<TD width=\"59\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"71\">&nbsp;</TD>\n\t\t\t<TD width=\"95\">&nbsp;</TD>\n\t\t\t<TD width=\"59\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">\n\t\t\tComentarios: </FONT></TD>\n\t\t\t<TD width=\"71\">&nbsp;</TD>\n\t\t\t<TD width=\"95\">&nbsp;</TD>\n\t\t\t<TD width=\"59\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"644\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\"> <TEXTAREA\n\t\t\t\tcols=\"50\" rows=\"5\" class=\"blue500\" name=\"comentarioFecha\"\n\t\t\t\tonKeyDown=\"limitaTextArea(document.cambioFecha.comentarioFecha,'Comentario','4000')\"></TEXTAREA>\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "&nbsp;".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"71\">&nbsp;</TD>\n\t\t\t<TD width=\"95\">&nbsp;</TD>\n\t\t\t<TD width=\"59\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[43] = 
    "\n<script type=\"text/javascript\">\n<!--\nif (".toCharArray();
    __oracle_jsp_text[44] = 
    "){\n\talert(\"Esta instrucción ha sido modificada por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n//-->\n</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
