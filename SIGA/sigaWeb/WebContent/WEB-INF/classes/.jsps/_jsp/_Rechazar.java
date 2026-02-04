package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.util.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;


public class _Rechazar extends com.orionserver.http.OrionHttpJspPage {


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
    _Rechazar page = this;
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
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      
      	String strIdInstruccion		=	"";
      	String strIdAsunto			=	"";
      	String strAvance			=	"";
      	String strTurnador			=	"";
      	String strNombreInst		=	"";
      	strIdInstruccion	=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
      	strIdAsunto			=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
      	strAvance			=	(request.getParameter("ava") != null)?request.getParameter("ava"):"";
      	strTurnador			=	(request.getParameter("tur") != null)?request.getParameter("tur"):"";
      	strNombreInst		=	(request.getParameter("ins") != null)?request.getParameter("ins"):"";
      
      	String retURI1 = (request.getParameter("retURI1")== null)?"portalPrincipal.jsp":request.getParameter("retURI1");
      	String retURI2 = (request.getParameter("retURI2")== null)?retURI1:request.getParameter("retURI2");
      	
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp = request.getRequestURI();
      	
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_ins="+strIdInstruccion+"&id_asunto="+strIdAsunto+"&tur="+strTurnador+"&ava="+strAvance+"&ins="+strNombreInst);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("E/RROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[7]);
      
      	
      	String strRazon				=	"";
      	String strIdRazonRechazo	=	"";
      	String strAccion			=	"";
      	String strFechaCreacion		=	"";
      	
      	boolean bInsetarRechazo		=	false;
      	boolean bActualiza			=	false;
      	boolean bInsertarBit		=	false;
      	
      	strAccion			=	request.getParameter("accion");
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      	
      	boolean bValidaEstatus = false;
      	strIdInstruccion  = request.getParameter("id_ins");
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
      
      	if(!bValidaEstatus && strAccion != null && strAccion.equals("guardar")){
      		strIdInstruccion	=	request.getParameter("id_ins");
      		strIdAsunto		=	request.getParameter("id_asunto");
      		strRazon		=	request.getParameter("razonRechazo");
      		strAvance		=	request.getParameter("ava");
      		strTurnador		=	request.getParameter("tur");
      		strNombreInst		=	request.getParameter("ins");
      		if(BUsuario.getAsistente())
                          try{
                              bInsetarRechazo=ActualizaHistorial.InsertarRechazo(strIdInstruccion, strIdAsunto,strRazon, gob.hacienda.cgtic.siga.Usuario.aTitular(BUsuario.getIdUsuario()), strAvance, strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre()+" en Nombre de "+gob.hacienda.cgtic.siga.instruccion.Rechazo.aNombre(BUsuario,strIdInstruccion));  
                          }catch(Exception e){
                          }
                      else
                          bInsetarRechazo=ActualizaHistorial.InsertarRechazo(strIdInstruccion, strIdAsunto,strRazon, BUsuario.getIdUsuario(), strAvance, strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre());  
                          
                      bActualiza = ActualizaInstrucciones.ActualizarRechazo(strIdInstruccion, strAvance);
      		String strFolioBit = ActualizaInstrucciones.getUltimoFolioTurnado(strIdInstruccion);
      		bInsertarBit = ActualizaBitacora.InsertarEventoRechazar(BUsuario.getIdUsuario(), strFolioBit);
      		//Envio de mail
      		String strMailTurnador[][] = ActualizaInstrucciones.getMailNombreTurno(strIdInstruccion);
      		String nombreT 	= 	strMailTurnador[0][0];
      		String cargoT 	= 	strMailTurnador[0][4];
      		String mailT  	= 	strMailTurnador[0][1];
      		String asunto	=	strMailTurnador[0][2];
      		String nombreR	=	BUsuario.getNombre();
      		String mailR	=	BUsuario.getCorreo();
      		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer = application.getInitParameter("PortMail");
      		String serverName = application.getInitParameter("servername");
      		String strBase	  = application.getInitParameter("RutaBase");
      		
      		if(true){
      			try{
      				SenderMail mail = new SenderMail(); 
      				if (ActualizaUsuario.getNotificacionMail(strMailTurnador[0][3])){
      					mail.sendMailRechazo(cargoT, mailT, strRazon, strNombreInst, 
      								asunto, strIdInstruccion, serverName, strBase,session.getServletContext());
      				}
      			}catch(MessagingException me){
              	    
                          me.printStackTrace();
              	}catch(UnsupportedEncodingException uee){
              	    
                          uee.printStackTrace();
              	}
      		}
      	}
      
      out.write(__oracle_jsp_text[8]);
       if(!bValidaEstatus && strAccion!=null && strAccion.equals("guardar")){ 
      out.write(__oracle_jsp_text[9]);
      out.print(retURI2);
      out.write(__oracle_jsp_text[10]);
       } 
      out.write(__oracle_jsp_text[11]);
      out.print(retURI1);
      out.write(__oracle_jsp_text[12]);
      out.print(strIdInstruccion);
      out.write(__oracle_jsp_text[13]);
      out.print(Utilerias.codificaPostHTML(retURI2));
      out.write(__oracle_jsp_text[14]);
      out.print( strIdInstruccion );
      out.write(__oracle_jsp_text[15]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[16]);
      out.print( strAvance );
      out.write(__oracle_jsp_text[17]);
      out.print( strTurnador );
      out.write(__oracle_jsp_text[18]);
      out.print( strNombreInst );
      out.write(__oracle_jsp_text[19]);
      out.print( retURI1 );
      out.write(__oracle_jsp_text[20]);
      out.print( retURI2 );
      out.write(__oracle_jsp_text[21]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[22]);
      out.print(BUsuario.getIdArea());
      out.write(__oracle_jsp_text[23]);
      out.print(BUsuario.getIdArea());
      out.write(__oracle_jsp_text[24]);
      out.print( strIdRazonRechazo );
      out.write(__oracle_jsp_text[25]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[26]);

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
  private static final char __oracle_jsp_text[][]=new char[27][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<SCRIPT language=JavaScript type=text/javascript>\n        location.assign('".toCharArray();
    __oracle_jsp_text[10] = 
    "');\n//\tlocation.assign(\"PortalAtender.jsp\");\n</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Rechazar</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\t\n\tfunction Regresar(){\n\t\tlocation.assign(\"".toCharArray();
    __oracle_jsp_text[12] = 
    "?id_ins=".toCharArray();
    __oracle_jsp_text[13] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[14] = 
    "\");\n\t}\n\t\n\tfunction guardar(){\t\n\t\n\t\tdoc = document.rechazar;\n\t\tvalida = 0;\n\t\tmsg=\"\";\n\n\t\tif (doc.razonRechazo.value == \"\") {\n\t\t\tvalida =1;\n\t\t\tmsg = msg + \" Debe capturar una Razon de rechazo de la instrucción\t\"+ \"\\n\";\n\t\t}\n\t\n\t\tif (valida == 1) \n\t\t{\n\t\t\talert(msg);\n\t\t} \n\t\tif (valida != 1)\n\t\t{\n\t\t\tdoc.accion.value=\"guardar\";\n\t\t\tif (confirm(\"está usted seguro que desea Rechazar la instrucción?\")) \n\t\t\t{\n\t\t\t\tdoc.submit();\n\t\t\t}else{\n\t\t\t\talert(\"Su petición de Rechazo ya fue cancelada\");\n\t\t\t}\n\t\t}\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" onClick=\"timer_reload()\" \n\tonMouseMove=\"limitaTextArea(document.rechazar.razonRechazo,'Razón de Rechazo','4000')\">\n<FORM action=\"Rechazar.jsp\" name=\"rechazar\" method=\"post\">\n<INPUT type=\"hidden\" value=\"guardar\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"id_ins\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"id_asunto\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"ava\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"tur\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"ins\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"retURI1\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" name=\"retURI2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" align=\"left\">\n\t\t\t\t<INPUT class=\"blue100\" onclick=\"Regresar()\" type=\"button\" value=\"Cancelar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<INPUT class=\"blue100\" onclick=\"guardar()\" type=\"button\" value=\"Aceptar\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD width=\"100%\">&nbsp;</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"100%\" bgcolor=\"#00204F\">\n\t\t\t\t<B><FONT face=\"Arial\" color=\"white\" size=\"2\">\n\t\t\t\tCaptura las razones del rechazo de la instrucción:\n\t\t\t\t</FONT></B>\n\t\t\t\t<A onclick=\"if (navigator.appName =='Netscape') {window.open('RechazarVentana.jsp?id_area=".toCharArray();
    __oracle_jsp_text[23] = 
    "','Repeat','status=yes,scrollbars=no,screenX=120,screenY=100,width=640,height=280');} else {window.open('RechazarVentana.jsp?id_area=".toCharArray();
    __oracle_jsp_text[24] = 
    "','Repeat','status=yes,scrollbars=no,top=120,left=100,width=480,height=220');}return false;\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/selec.jpg\" width=\"12\" height=\"8\">\n\t\t\t\t</A>\n\t\t\t</td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\"><TEXTAREA cols=\"70\" rows=\"10\" name=\"razonRechazo\"\n\t\t\t\t\t\t\tonKeyDown=\"limitaTextArea(document.rechazar.razonRechazo,'Razón de Rechazo','4000')\"></TEXTAREA></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\">&nbsp;</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"100%\" bgcolor=\"#00204F\"></td>\n\t\t</tr>\n\t</TBODY>\n</TABLE>\n</DIV>\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\" name=\"idRazon\">\n<script type=\"text/javascript\">\n<!--\nif (".toCharArray();
    __oracle_jsp_text[26] = 
    "){\n\talert(\"Esta instrucción ha sido modificada por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"portalPrincipal.jsp\");\n}\n//-->\n</script>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
