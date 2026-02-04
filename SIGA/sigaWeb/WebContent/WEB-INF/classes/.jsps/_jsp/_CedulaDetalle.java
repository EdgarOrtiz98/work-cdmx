package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _CedulaDetalle extends com.orionserver.http.OrionHttpJspPage {


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
    _CedulaDetalle page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
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
      
      
      out.write(__oracle_jsp_text[4]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[5]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[6]);
       } 
      out.write(__oracle_jsp_text[7]);
      
      	String strTipo	=	(request.getParameter("cls")!= null)?request.getParameter("cls"):"0";
      	String valor	=	(request.getParameter("valor")!= null)?request.getParameter("valor"):"";
      	String anio	=	(request.getParameter("anio")!= null)?request.getParameter("anio"):"";
      	String consec = "0";
      	String name = "";
      	String datoExp = "";
      	String sisi = "";
      	String ac ="";
      	String at ="";
      	String reserva ="";
      	String val ="";
      	String datoExpP = "";
      	String datoExpF = "";
      	String datoExpSec = "";
      	String datoExpSr = "";
      	String datoExpSubSr = "";
      	String datoExpUA = "";
      	String datoExpCT = "";
      	String voice = "";
      	String funda = "";
      	String moti = "";
      
      
      
      	
      	String strDatos[][] = ActualizaExpArchivado.getExpedienteConsec(strTipo,anio);
      	if (strDatos.length >0)
      		consec		=	strDatos[0][0];
      		
      		
      		
      	String strDatosExp[][] = ActualizaExpArchivado.getDatosCedulaClave(strTipo);
      	if (strDatosExp.length >0)
      	{
      	datoExpP =		strDatosExp[0][0];
      	datoExpF =		strDatosExp[0][1];
      	datoExpSec =	strDatosExp[0][2];
      	datoExpSr =		strDatosExp[0][3];
      	datoExpSubSr =	strDatosExp[0][4];
      	datoExpUA =		strDatosExp[0][5];
      	datoExpCT =		strDatosExp[0][6];
      	name =			strDatosExp[0][7];
      	sisi =			strDatosExp[0][8]; 
      	at =			strDatosExp[0][9]; 
      	ac =			strDatosExp[0][10]; 
      	reserva =  		strDatosExp[0][11]; 
      	funda 	=   	strDatosExp[0][12];
      	moti 	=   	strDatosExp[0][13];
      	
      			if(Integer.parseInt(datoExpSr) > 0)
      			{
      				datoExp = datoExpSubSr+"."+datoExpSr+"."+datoExpSec+"."+datoExpF+"."+ datoExpP+"-"+datoExpUA;
      			}else
      			{
      				datoExp = datoExpSubSr+"."+datoExpSec+"."+datoExpF+"."+ datoExpP+"-"+datoExpUA;
      			}
      	}else
      	{
      	
      	String strDatosExp2[][] = ActualizaExpArchivado.getDatosCedulaClave2(strTipo);
      		if (strDatosExp2.length >0)
      		{
      			datoExpF =		strDatosExp2[0][0];
      			datoExpSec =	strDatosExp2[0][1];
      			datoExpSr =		strDatosExp2[0][2];
      			datoExpSubSr =	strDatosExp2[0][3];
      			datoExpUA =		strDatosExp2[0][4];
      			datoExpCT =		strDatosExp2[0][5];
      			name 	=		strDatosExp2[0][6];
      			sisi 	=		strDatosExp2[0][7]; 
      			at 		=		strDatosExp2[0][8]; 
      			ac 		=		strDatosExp2[0][9]; 			
      			reserva =   	strDatosExp2[0][10];
      			funda 	=   	strDatosExp2[0][11];
      			moti 	=   	strDatosExp2[0][12];
      			
      			if(Integer.parseInt(datoExpSr) > 0)
      			{
      				datoExp = datoExpSubSr+"."+datoExpSr+"."+datoExpSec+"."+datoExpF+".00-"+datoExpUA;
      			}else
      			{
      				datoExp = datoExpSubSr+"."+datoExpSec+"."+datoExpF+".00-"+datoExpUA;
      			}
      			
      			
      		}
      	}
      	//datoExp = datoExpP+datoExpF+"."+datoExpSec+"."+datoExpSr+"."+datoExpSubSr+"."+datoExpUA;
      
      
      
      out.write(__oracle_jsp_text[8]);
      out.print(name);
      out.write(__oracle_jsp_text[9]);
      out.print(valor);
      out.write(__oracle_jsp_text[10]);
      out.print(sisi);
      out.write(__oracle_jsp_text[11]);
      out.print(ac);
      out.write(__oracle_jsp_text[12]);
      out.print(at);
      out.write(__oracle_jsp_text[13]);
      out.print(reserva);
      out.write(__oracle_jsp_text[14]);
      out.print(funda);
      out.write(__oracle_jsp_text[15]);
      out.print(moti);
      out.write(__oracle_jsp_text[16]);
      out.print(datoExp);
      out.write(__oracle_jsp_text[17]);
      out.print(datoExp);
      out.write(__oracle_jsp_text[18]);
      out.print(datoExpCT);
      out.write(__oracle_jsp_text[19]);
      out.print(sisi);
      out.write(__oracle_jsp_text[20]);
      if (valor == "pasa" || valor.equalsIgnoreCase("pasa")){
      	
      out.write(__oracle_jsp_text[21]);
      out.print(consec);
      out.write(__oracle_jsp_text[22]);
      }else
       	{
      out.write(__oracle_jsp_text[23]);
      }
      out.write(__oracle_jsp_text[24]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaExpArchivado.getDatosCedulaDeta(strTipo));
        __jsp_taghandler_1.setCampo("campo");
        java.lang.String campo1 = null;
        java.lang.String campo2 = null;
        java.lang.String campo3 = null;
        java.lang.String campo4 = null;
        java.lang.String campo5 = null;
        java.lang.String campo6 = null;
        java.lang.String campo7 = null;
        java.lang.String campo8 = null;
        java.lang.String campo9 = null;
        java.lang.String campo10 = null;
        java.lang.String campo11 = null;
        java.lang.String campo12 = null;
        java.lang.String campo13 = null;
        java.lang.String campo14 = null;
        java.lang.String campo15 = null;
        java.lang.String campo16 = null;
        java.lang.String campo17 = null;
        java.lang.String campo18 = null;
        java.lang.String campo19 = null;
        java.lang.String campo20 = null;
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
          do {
            campo1 = (java.lang.String) pageContext.findAttribute("campo1");
            campo2 = (java.lang.String) pageContext.findAttribute("campo2");
            campo3 = (java.lang.String) pageContext.findAttribute("campo3");
            campo4 = (java.lang.String) pageContext.findAttribute("campo4");
            campo5 = (java.lang.String) pageContext.findAttribute("campo5");
            campo6 = (java.lang.String) pageContext.findAttribute("campo6");
            campo7 = (java.lang.String) pageContext.findAttribute("campo7");
            campo8 = (java.lang.String) pageContext.findAttribute("campo8");
            campo9 = (java.lang.String) pageContext.findAttribute("campo9");
            campo10 = (java.lang.String) pageContext.findAttribute("campo10");
            campo11 = (java.lang.String) pageContext.findAttribute("campo11");
            campo12 = (java.lang.String) pageContext.findAttribute("campo12");
            campo13 = (java.lang.String) pageContext.findAttribute("campo13");
            campo14 = (java.lang.String) pageContext.findAttribute("campo14");
            campo15 = (java.lang.String) pageContext.findAttribute("campo15");
            campo16 = (java.lang.String) pageContext.findAttribute("campo16");
            campo17 = (java.lang.String) pageContext.findAttribute("campo17");
            campo18 = (java.lang.String) pageContext.findAttribute("campo18");
            campo19 = (java.lang.String) pageContext.findAttribute("campo19");
            campo20 = (java.lang.String) pageContext.findAttribute("campo20");
            out.write(__oracle_jsp_text[25]);
            out.print(campo10 );
            out.write(__oracle_jsp_text[26]);
            out.print(campo5);
            out.write(__oracle_jsp_text[27]);
            out.print(campo9 );
            out.write(__oracle_jsp_text[28]);
            out.print(campo4);
            out.write(__oracle_jsp_text[29]);
            out.print(campo8 );
            out.write(__oracle_jsp_text[30]);
            out.print(campo3);
            out.write(__oracle_jsp_text[31]);
            out.print(campo7 );
            out.write(__oracle_jsp_text[32]);
            out.print(campo2);
            out.write(__oracle_jsp_text[33]);
            out.print(campo6 );
            out.write(__oracle_jsp_text[34]);
            out.print(campo1);
            out.write(__oracle_jsp_text[35]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[36]);

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
  private static final char __oracle_jsp_text[][]=new char[37][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<TITLE>Detalle de Clasificacion</TITLE>\n</HEAD>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\nfunction llenando(cstivo)\t\t\n\t{\n\tvar a =  String(cstivo);\n\tnum = a.length;\n\tvar af = \"\";\n\tif(num < 6)\n\t\t{\n\t\t\tfor (i=num; i<6; i++){\n\t\t\t\taf = af + \"0\";\n\t\t\t}\n\t\t}\n\tparent.window.document.getElementById('consec').value = af+a;\n\t}\n\nfunction Consec(con) { \n    consec= parseInt(con);\n    consec2 = consec +1;\n\n\tllenando(consec2);\n\n\tname = \"".toCharArray();
    __oracle_jsp_text[9] = 
    "\";\n\tvalor = \"".toCharArray();
    __oracle_jsp_text[10] = 
    "\";\n\tsisi =  \"".toCharArray();
    __oracle_jsp_text[11] = 
    "\";\n\tac =  \"".toCharArray();
    __oracle_jsp_text[12] = 
    "\";\n\tat =  \"".toCharArray();
    __oracle_jsp_text[13] = 
    "\";\n\treserva =  \"".toCharArray();
    __oracle_jsp_text[14] = 
    "\";\n\tfunda =  \"".toCharArray();
    __oracle_jsp_text[15] = 
    "\";\n\tmoti =  \"".toCharArray();
    __oracle_jsp_text[16] = 
    "\";\n\t\n\t if  (name.length > 0 && valor.length > 0)\n\t\t{\n\t\t\tparent.window.document.getElementById('denom').value = name;\n\t\t\tparent.window.document.getElementById('fundamento').value = funda;\n\t\t\tparent.window.document.getElementById('motivo').value = moti;\n\t\t}\n\t\t\n\t if  (sisi.length > 0 && sisi.length > 0)\n\t\tparent.window.document.getElementById('sisi').value = sisi;\t\t\n\t\t\n\t if  (ac.length > 0)\n\t\tparent.window.document.getElementById('ano_AC').value = ac;\t\t\t\n\t\n\t if  (at.length > 0)\n\t\tparent.window.document.getElementById('ano_AT').value = at;\n\t\n\t if\t(parseInt(at) == 99)\n\t\t{\n\t\t\tparent.window.indefinido();\n\t\t}else\n\t\t{\n\t\t\tparent.window.sum();\n\t\t}\n\n\t if  (reserva.length > 0)\n\t\tparent.window.document.getElementById('anioresv').value = reserva;\t\t\n\t\t\n\tparent.window.real();\n\t}\nfunction Cvexp() { \n\tsetdato = \"".toCharArray();
    __oracle_jsp_text[17] = 
    "\";\n\tparent.window.document.getElementById('clvExpdic').value = \"".toCharArray();
    __oracle_jsp_text[18] = 
    "\";\n\tparent.window.document.getElementById('ct').value = \"".toCharArray();
    __oracle_jsp_text[19] = 
    "\";\n\tif(setdato.length > 0)\n\tparent.window.asignavalor();\n\tparent.window.anio2();\n\t}\n\t\nfunction vale()\n\t{\n\tsisi =  \"".toCharArray();
    __oracle_jsp_text[20] = 
    "\";\n\tif  (sisi.length > 0 && sisi.length > 0)\n\t\tparent.window.document.getElementById('sisi').value = sisi;\n\n\t}\n\t\n</SCRIPT>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t onload=\"Consec(".toCharArray();
    __oracle_jsp_text[22] = 
    ");Cvexp();\"\n \t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n \tonload=\"vale();\"\n \t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n >\n<FORM name=\"CedulaDetalle\" action=\"CedulaDetalle.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<input name=\"tmpCopyToRef\" type=\"hidden\" value=\"\">\n<input name=\"idsCC\" type=\"hidden\" value=\"\">\n<DIV align=\"center\">\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n <TR bgcolor=\"#00204f\">\n\t\t<TD width=\"10%\" align=\"center\" colspan=\"5\">\n\t\t<FONT size=\"2\" color=\"white\" face=\"verdana\">DETALLE CEDULA</FONT>\n\t\t</TD>\n </TR>\n\t<TR bgcolor=\"#00204f\">\n        <TD width=\"20%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Fondo</FONT></b>\n        </TD>\n        <TD width=\"20%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Subfondo</FONT></b>\n        </TD>\n        <TD width=\"20%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Seccion</FONT></b>\n        </TD>                \n        <TD width=\"20%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Serie</FONT></b>\n        </TD>\n        <TD width=\"20%\" align=\"center\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Subserie</FONT></b>\n        </TD>\n    </TR>\n\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t<TR vAlign=top>\n\t\t<TD width=\"20%\">\n    \t\t<FONT face=Arial color=#000080 size=1>\n    \t\t<A class =\"etiquetas\" title= \"".toCharArray();
    __oracle_jsp_text[26] = 
    "\"><B><U>".toCharArray();
    __oracle_jsp_text[27] = 
    "</U></B></A>\n    \t\t</FONT>\n\t   \t</TD> \n\t   \t<TD width=\"20%\">\n    \t\t<FONT face=Arial color=#000080 size=1>\n    \t\t<A class =\"etiquetas\" title= \"".toCharArray();
    __oracle_jsp_text[28] = 
    "\"><B><U>".toCharArray();
    __oracle_jsp_text[29] = 
    "</U></B></A>\n\t   \t\t</FONT>\n\t   \t</TD> \n\t\t<TD width=\"20%\">\n    \t\t<FONT face=Arial color=#000080 size=1>\n    \t\t<A class =\"etiquetas\" title= \"".toCharArray();
    __oracle_jsp_text[30] = 
    "\"><B><U>".toCharArray();
    __oracle_jsp_text[31] = 
    "</U></B></A>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A class =\"etiquetas\" title= \"".toCharArray();
    __oracle_jsp_text[32] = 
    "\"><B><U>".toCharArray();
    __oracle_jsp_text[33] = 
    "</U></B></A>\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t<A class =\"etiquetas\" title= \"".toCharArray();
    __oracle_jsp_text[34] = 
    "\"><B><U>".toCharArray();
    __oracle_jsp_text[35] = 
    "</U></B></A>\n\t\t\t</FONT>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t<TR vAlign=top>\t\n\t<TD COLSPAN=\"5\" align=\"center\">\n\t<input type=\"button\"\n\t\t\t\tonclick=\"parent.window.document.getElementById('pop10').style.visibility='hidden';\"\n\t\t\t\tvalue=\" Cancel\" class=\"blue100\">\n\t</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
