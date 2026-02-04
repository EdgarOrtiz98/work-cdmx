package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _Acomulable extends com.orionserver.http.OrionHttpJspPage {


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
    _Acomulable page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      
      
      out.write(__oracle_jsp_text[5]);
      
      	String strAccion =	"";
      	String strVal = "";
      	String strAreaUs = BUsuario.getIdArea();
      	String strIdExpediente	=	"";
      	String strReal	 =	"";
      	String strTotcls =	"";
      	String strAcom	 =	"";
      	String strTotGur =	"";
      	String stracom	 =  "";
      	String stropera	 =  "";
      	int valida	 =  0;
      	String strsoloDesc 	=	request.getParameter("soloDesc");
      	String strInstruccion = (request.getParameter("ida")!= null)?request.getParameter("ida"):"";
      	strAreaUs	=	BUsuario.getIdArea();
      	String strTipo	=	(request.getParameter("cls")!= null)?request.getParameter("cls"):"0";
      
      
      	
      	strAccion	=	request.getParameter("accion");
      	
      
      	
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      		strIdExpediente = request.getParameter("ida");
      		strReal = request.getParameter("real");
      		strTotcls = request.getParameter("totalcls");
      		strAcom = request.getParameter("acomuguard");
      		strTotGur = request.getParameter("totalGuar");
      		stracom = request.getParameter("anioacom"); 
      		stropera = request.getParameter("operacion");
      		ActualizaExpArchivado.actualizaExpedienteAcom(strReal,strTotcls,strAcom,strTotGur,
      														strIdExpediente,BUsuario.getIdArea(),stracom,stropera);
      		}
      	}
      	
      	String var[][] =	ActualizaExpArchivado.getDatosExpAcom(strInstruccion);
      	if (var.length >0) 
      		{
      			strVal = var[0][0];
      		}
      	else 
      		{
      		strVal = "0";
      		}
      	
      
      out.write(__oracle_jsp_text[6]);
      out.print(strInstruccion);
      out.write(__oracle_jsp_text[7]);
      out.print(strInstruccion);
      out.write(__oracle_jsp_text[8]);
      out.print(strVal);
      out.write(__oracle_jsp_text[9]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[10]);
      
      						}
      out.write(__oracle_jsp_text[11]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[12]);
      
      						}
      out.write(__oracle_jsp_text[13]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[14]);
      
      						}
      out.write(__oracle_jsp_text[15]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[16]);
      
      						}
      out.write(__oracle_jsp_text[17]);
      out.print(strVal);
      out.write(__oracle_jsp_text[18]);

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
  private static final char __oracle_jsp_text[][]=new char[19][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[4] = 
    " \n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<TITLE>Acomulable.jsp</TITLE>\n</HEAD>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\nfunction Consec(con) { \n\n\t}\nfunction Aplicar(){ \n\n\t\tif(document.acomulableForm.anioacom.value == \"\")\n\t\t{\n\t\talert(\"Es necesario introducir un valor\");\n\t\treturn false;\n\t\t}\n\t\t valor1 = document.acomulableForm.anioacom.value;\n\t\t valor2 = document.acomulableForm.acomu.value;\n\t\t verif = parent.window.document.getElementById('anioreal').value;\n\t\t\n\t\tif(document.acomulableForm.operarc[0].checked)\n\t\t\t{\n\t\t\tdocument.acomulableForm.operacion.value = \"Ampliacion\";\n\t\t\tvalor3 = parseInt(valor1) + parseInt(valor2);\n\t\t\t}\n\t\tif(document.acomulableForm.operarc[1].checked)\n\t\t\t{\n\t\t\tdocument.acomulableForm.operacion.value = \"Reduccion\";\n\t\t\tvalor3 = parseInt(valor2) - parseInt(valor1);\n\t\t\t\tif(parseInt(valor1)>verif)\n\t\t\t\t{\n\t\t\t\t alert(\"No se puede reducir mas Años a los asignados\")\n\t\t\t\t document.acomulableForm.anioacom.value =\"\";\n\t\t\t\t return false;\n\t\t\t\t}\n\t\t\t}\n\t\tparent.window.document.getElementById('ano_Amp').value = valor3;\n\t\tparent.window.real();\n\t\t\n\t\tdocument.acomulableForm.real.value = parent.window.document.getElementById('anioreal').value;\n\t\tdocument.acomulableForm.totalcls.value = parent.window.document.getElementById('totalcls').value;\n\t\tdocument.acomulableForm.totalGuar.value = parent.window.document.getElementById('ano_guard').value;\n\t\tdocument.acomulableForm.acomuguard.value = valor3;\n\t\tdocument.acomulableForm.accion.value=\"guardar\";\n\t\tdocument.acomulableForm.submit();\n\t\t}\n\t\t\n\tfunction windowDetalle()\n\t \t{\n\t \t\twindow.open('AniosDetalle.jsp?valor=".toCharArray();
    __oracle_jsp_text[7] = 
    "','window','width=420,height=250');\n\t \t\twindow.focus;\n \t}\t\t\n</SCRIPT>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM name=\"acomulableForm\" action=\"Acomulable.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<input name=\"tmpCopyToRef\" type=\"hidden\" value=\"\">\n<input name=\"idsCC\" type=\"hidden\" value=\"\">\n<input name=\"ida\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">\n<input name=\"real\" type=\"hidden\" value=\"\">\n<input name=\"totalcls\" type=\"hidden\" value=\"\">\n<input name=\"totalGuar\" type=\"hidden\" value=\"\">\n<input name=\"operacion\" type=\"hidden\" value=\"\">\n<input name=\"acomu\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\">\n<input name=\"acomuguard\" type=\"hidden\" value=\"\">\n<DIV align=\"center\">\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"150\">\n\t\t\t<INPUT TYPE=RADIO NAME=\"operarc\" checked=\"checked\" \n\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t\tVALUE=\"sum\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Ampliar</FONT><BR>\n\t\t\t<INPUT TYPE=RADIO NAME=\"operarc\" \n\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\tVALUE=\"res\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Reducir</FONT>\n\t\t</TD>\n\t\t<TD>\n\t\t\t<FONT face=\"Arial\" size=\"2\">\n\t\t\t<INPUT name=\"anioacom\" id=\"anioacom\" value=\"\" type=\"text\" \n\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\tclass=\"blue100\">\n\t\t\t</FONT> \n\t\t\t<INPUT type=\"button\" style=\"width:65;height:20;font: bold 12px Arial\" onclick=\"Aplicar('');\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t  value=\"Aplicar\">\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"150\">\n\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">Acomulado:</FONT>\n\t\t</TD>\n\t\t<TD>\n\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\"><B>".toCharArray();
    __oracle_jsp_text[18] = 
    "</B></FONT>&nbsp;&nbsp;<A href=\"#\" onclick=\"windowDetalle()\"><FONT color=\"Blue\" size=\"1\">Detalle</FONT></A>\n\t\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
