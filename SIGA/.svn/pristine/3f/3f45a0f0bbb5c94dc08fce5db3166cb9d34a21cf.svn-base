package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _ValorArch extends com.orionserver.http.OrionHttpJspPage {


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
    _ValorArch page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("headerC.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){;}
      	}
      
      out.write(__oracle_jsp_text[3]);
       if(!BUsuario.getAdmon() && !BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[4]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[5]);
       } 
      out.write(__oracle_jsp_text[6]);
      
      	String msg = "";
      	String strIdSubfondo	=	"";
      	String strCodigo		=	"";
      	String strSeccion		=	"";
      	String strUsrActualiza	=	"";
      	String strFecha			=	"";
      	String strAccion		=	"";
      	String strClave			=	"";
      	String strInact			=	"";
      	String strFecInac		=	"";
      	String strJustInac		=	"";
      	String ver				=	"";
      	String horafec			=	"";
      	String strsoloDesc 		=	"";
      	String strAux = "1234567";
      
      		int valida		=	0;
      	boolean bInsertar		=	false;
      	int bInsertar1		=	0;	
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha						=	sdf.format(f);
      
      	String retURI = (request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
      
      	strAccion		=	request.getParameter("accion");
      	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strClave	=	request.getParameter("clave");
      						
      			bInsertar1	=	ActualizaExpArchivado.insertarValor(strCodigo, strSeccion,
      																strFecha, BUsuario.getIdUsuario(),strClave,strAux);
      			if(bInsertar1 == 2){;}
      			else{
      				try{
      					response.sendRedirect(retURI+"&msg="+msg);
      				}catch(java.io.IOException io){;}
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      		
      			strsoloDesc =	request.getParameter("soloDesc");
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strClave	=	request.getParameter("clave");	
      			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
      			strFecInac	=	request.getParameter("fecinact");
      			strJustInac =	request.getParameter("justif");						
      			strAux 		= 	request.getParameter("aux"); 
      			 
      			bInsertar1 = ActualizaExpArchivado.actualizaValor(strsoloDesc,strCodigo, strSeccion, strFecha, 
      															BUsuario.getIdUsuario(), strIdSubfondo,strClave,
      															strFecInac,strJustInac,strInact, strAux);
      
      			if(bInsertar1 != 2){
      				try{
      					response.sendRedirect(retURI);
      				}catch(java.io.IOException io){;}
      			}
      		}
      	}
      	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	{
      		String strDatosSubfondo[][] = ActualizaExpArchivado.getValor(strIdSubfondo);
      		strCodigo		=	strDatosSubfondo[0][0];
      		strSeccion		=	strDatosSubfondo[0][1];
      		strFecha		=	strDatosSubfondo[0][2];
      		strUsrActualiza	=	strDatosSubfondo[0][3];
      		strClave		=	strDatosSubfondo[0][4];	
      		strFecInac		=	strDatosSubfondo[0][5];	
      		strJustInac		=	strDatosSubfondo[0][6];	
      		strInact		=	strDatosSubfondo[0][7];	
      		horafec			=	strDatosSubfondo[0][8];	
      		ver				=	"si";				
      		strAux			=  	strClave;
      		
      		valida	=	ActualizaExpArchivado.getValidaValor(strIdSubfondo);
      	}
      
      out.write(__oracle_jsp_text[7]);
      if(valida == 2) 
      		{
      out.write(__oracle_jsp_text[8]);
      
      		}
      out.write(__oracle_jsp_text[9]);
      out.print(horafec);
      out.write(__oracle_jsp_text[10]);
      out.print(strIdSubfondo);
      out.write(__oracle_jsp_text[11]);
      out.print(strAux);
      out.write(__oracle_jsp_text[12]);
      out.print(retURI);
      out.write(__oracle_jsp_text[13]);
      if(valida == 2){
      		strsoloDesc = "1";
      	}
      	
      out.write(__oracle_jsp_text[14]);
      out.print(strsoloDesc);
      out.write(__oracle_jsp_text[15]);
      out.print( retURI );
      out.write(__oracle_jsp_text[16]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[17]);
      	}else{
      out.write(__oracle_jsp_text[18]);
      }
      out.write(__oracle_jsp_text[19]);
       if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[20]);
      out.print(ActualizaUsuario.NombreUsuario(strUsrActualiza));
      out.write(__oracle_jsp_text[21]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[22]);
       }else{ 
      out.write(__oracle_jsp_text[23]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[24]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[25]);
       } 
      out.write(__oracle_jsp_text[26]);
      if(bInsertar1 == 2){ 
      out.write(__oracle_jsp_text[27]);
      } 
      out.write(__oracle_jsp_text[28]);
      out.print(strClave);
      out.write(__oracle_jsp_text[29]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[30]);
      
      						}
      out.write(__oracle_jsp_text[31]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[32]);
      	}
      out.write(__oracle_jsp_text[33]);
      out.print(strCodigo);
      out.write(__oracle_jsp_text[34]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[35]);
      
      						}
      out.write(__oracle_jsp_text[36]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[37]);
      	}
      out.write(__oracle_jsp_text[38]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[39]);
      	}
      out.write(__oracle_jsp_text[40]);
      out.print(strSeccion);
      out.write(__oracle_jsp_text[41]);
      if(strInact == "3" || strInact.equals("3")) 
      						{
      out.write(__oracle_jsp_text[42]);
      
      						}
      out.write(__oracle_jsp_text[43]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[44]);
      
      						}
      out.write(__oracle_jsp_text[45]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[46]);
      
      						}
      out.write(__oracle_jsp_text[47]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[48]);
      	}
      out.write(__oracle_jsp_text[49]);
      out.print(strFecInac);
      out.write(__oracle_jsp_text[50]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[51]);
      	}
      out.write(__oracle_jsp_text[52]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[53]);
      
      						}
      out.write(__oracle_jsp_text[54]);
      if(valida == 2) 
      					{
      out.write(__oracle_jsp_text[55]);
      
      					}
      out.write(__oracle_jsp_text[56]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[57]);
      
      					}
      out.write(__oracle_jsp_text[58]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[59]);
      	}
      out.write(__oracle_jsp_text[60]);
      out.print(strJustInac);
      out.write(__oracle_jsp_text[61]);

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
  private static final char __oracle_jsp_text[][]=new char[62][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML> \n<HEAD>\n".toCharArray();
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Valor</TITLE>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\tfunction limpiarCampos(){\n\t\tdocument.valorf.reset();\n\t}\n\tfunction rValidando() {\n\t\t".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\talert(\"Como este registro ya cuenta con registros dependientes, solo podra ser modificado su Descripción\");\n\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t}\t\n\tfunction alfaNumerico(ob){\n\t\tvar ok=false;\n\t\tvar texto=ob.value\n\t\tvar codigo=texto.charCodeAt(texto.length-1);\n\t\tif( (codigo>=48&&codigo<=57)||(codigo>=65&&codigo<=90)||(codigo>=97&&codigo<=122)||(codigo==32)\n\t\t   )\n\t\t\tok=true;\n\t\tif(!ok){\n\t\t\ttexto=texto.substring(0,texto.length-1);\n\t\t\tob.value=texto;\n\t\t}\n\t}\n\tfunction habilita2()\n\t{\n\t\tif(document.valorf.inactivo.checked == true)\n\t\t{\n\t\tdocument.valorf.fecinact.value = \"".toCharArray();
    __oracle_jsp_text[10] = 
    "\";\n\t\tdocument.valorf.fecinact.disabled = false;\n\t\tdocument.valorf.justif.disabled = false;\n\t\t}else\n\t\t{\n\t\tdocument.valorf.fecinact.value = \"\";\n\t\tdocument.valorf.justif.value = \"\";\n\t\tdocument.valorf.fecinact.disabled = true;\n\t\tdocument.valorf.justif.disabled = true;\n\t\t}\n\t}\t\t\n\n</SCRIPT>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n\n\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;rValidando();setFormFocusValor();limpiarCampos();timer_load();\" \n\tonKeyPress=\"timer_reload();\" \n\tonmousemove=\"limitaTextArea(document.valorf.subSeccion,'Descripción','4000');\"\n\tonClick=\"timer_reload();\">\n\n\n\n<FORM action=\"ValorArch.jsp\" name=\"valorf\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\" name=\"id_sub\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"retURI\">\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"soloDesc\">\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD  colspan=\"2\" width=\"196\"><a href=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\"> \n\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\" > </a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\n\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\n\t\t\t\t<a></a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\t\n\t\t\t\t<a>\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\" onclick=\"GuardarValor()\"></a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\t\t\t\t\t\t\t\n\t\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\t\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR><td></td><td></td><td></td></TR>\n\t\t<TR><td></td><td></td><td></td></TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"196\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><B><FONT size=\"+1\" color=\"#004080\">Valor</FONT></B></FONT></B></TD>\n\t\t\t<TD width=\"62\">&nbsp;</TD>\n\t\t\t<TD width=\"414\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"196\" colspan=\"2\" bgcolor=\"#004080\"></TD>\n\t\t\t<TD width=\"62\" bgcolor=\"#004080\"></TD>\n\t\t\t<TD width=\"414\" align=\"right\" bgcolor=\"#004080\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"196\" bgcolor=\"#004080\" colspan=\"2\"></TD>\n\t\t\t<TD width=\"62\" bgcolor=\"#004080\"></TD>\n\t\t\t<TD width=\"414\" align=\"right\" bgcolor=\"#004080\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[21] = 
    " - ".toCharArray();
    __oracle_jsp_text[22] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[24] = 
    " - ".toCharArray();
    __oracle_jsp_text[25] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tClave:</FONT></B><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "<B><FONT color=\"red\">*Esta clave ya existe*</FONT>\n\t\t\t</B>".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"clave\" value=\"".toCharArray();
    __oracle_jsp_text[29] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\n\t\t\t\tdisabled=\"disabled\"\n\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\t\t\n\t\t\t\tMAXLENGTH=\"2\" type=\"text\" class=\"blue100\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tNombre:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"subCodigo\" value=\"".toCharArray();
    __oracle_jsp_text[34] = 
    "\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\t\t\t\n\t\t\t\t type=\"text\" class=\"blue500\" MAXLENGTH=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tDescripción:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\n\t\t\t\t<TEXTAREA name=\"subSeccion\" rows=\"5\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.valorf.subSeccion,'Descripción','4000');\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\t\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[41] = 
    "</TEXTAREA> \n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tInactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=checkbox onclick=\"habilita2()\" value=\"3\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t\t\t checked\n\t\t\t\t\t       \t".toCharArray();
    __oracle_jsp_text[43] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\t\n\t\t\t\tname=\"inactivo\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFecha Inactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"fecinact\" value=\"".toCharArray();
    __oracle_jsp_text[50] = 
    "\"\n\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\t\n\t\t\t\ttype=\"text\" class=\"blue100\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t<TD width=\"528\">&nbsp;</TD>\t\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tJustificacion:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<TEXTAREA name=\"justif\" id=\"justif\" rows=\"3\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.valorf.justif,'Justificación','1000');\"\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[61] = 
    "</TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\t\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
