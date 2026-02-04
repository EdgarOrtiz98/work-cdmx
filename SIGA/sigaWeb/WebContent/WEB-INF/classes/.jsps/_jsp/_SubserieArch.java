package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _SubserieArch extends com.orionserver.http.OrionHttpJspPage {


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
    _SubserieArch page = this;
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
       if(!BUsuario.getAdmon() && !BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[5]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[6]);
       } 
      out.write(__oracle_jsp_text[7]);
      
      	String msg = "";
      	String strIdSubfondo	=	"";
      	String strCodigo		=	"";
      	String strSeccion		=	"";
      	String strUsrActualiza	=	"";
      	String strFecha			=	"";
      	String strAccion		=	"";
      	String stridSerie		=	request.getParameter("IdSerie");	
      	String strFondo			=	"";
      	String strClave			=	"";	
      
      	String strAux = "9999999", strAux2 = "9999999";
      
      		int valida		=	0;
      	boolean bInsertar		=	false;
      	int bInsertar1		=	0;	
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha						=	sdf.format(f);
      
      	strAccion		=	request.getParameter("accion");
      	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strFondo	=   request.getParameter("fondo"); 
      			strClave	=	request.getParameter("clave"); 
      						
      			bInsertar1	=	ActualizaExpArchivado.insertarSubserie(strCodigo, strSeccion,
      																strFecha, BUsuario.getIdUsuario(),stridSerie,strClave,strAux,strAux2);
      			if(bInsertar1 == 2)
      			{
      			//msg ="La clave ya existe";
      			}																
      			else {
      				//try{
      					//response.sendRedirect("SubseriesArchview.jsp?msg="+msg);
      					
      out.write(__oracle_jsp_text[8]);
      
      				//}catch(java.io.IOException io){
      				//	//System.out.println("Error-->"+io);
      				//}
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strFondo	=   request.getParameter("fondoCamb");
      			strClave	=	request.getParameter("clave"); 
      						  
      			strAux 		= 	request.getParameter("aux"); 
      			strAux2 	= 	request.getParameter("aux2"); 
      
      			bInsertar1 = ActualizaExpArchivado.actualizaSubSerie(strCodigo, strSeccion, strFecha, 
      															BUsuario.getIdUsuario(), strFondo, strIdSubfondo,strClave,strAux,strAux2);
      			if (bInsertar1 != 2){
      				try{
      					response.sendRedirect("SubseriesArchview.jsp");
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}
      	}
      	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	{
      		String strDatosSubfondo[][] = ActualizaExpArchivado.getSubSerie(strIdSubfondo);
      		strCodigo		=	strDatosSubfondo[0][0];
      		strSeccion		=	strDatosSubfondo[0][1];
      		strFecha		=	strDatosSubfondo[0][2];
      		strUsrActualiza	=	strDatosSubfondo[0][3];
      		strFondo	=		strDatosSubfondo[0][4];
      		strClave	=		strDatosSubfondo[0][5];
      
      		strAux			=  	strClave;
      		strAux2			=  	strFondo;
      		
      		valida	=	ActualizaExpArchivado.getValidaSubserie(strIdSubfondo);
      	}
      
      out.write(__oracle_jsp_text[9]);
      if(valida == 2) 
      	{
      out.write(__oracle_jsp_text[10]);
      
      	}
      out.write(__oracle_jsp_text[11]);
      out.print(strIdSubfondo);
      out.write(__oracle_jsp_text[12]);
      out.print(strAux);
      out.write(__oracle_jsp_text[13]);
      out.print(strAux2);
      out.write(__oracle_jsp_text[14]);
      out.print(strFondo);
      out.write(__oracle_jsp_text[15]);
      out.print(stridSerie);
      out.write(__oracle_jsp_text[16]);
       if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[17]);
      out.print(ActualizaUsuario.NombreUsuario(strUsrActualiza));
      out.write(__oracle_jsp_text[18]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[19]);
       }else{ 
      out.write(__oracle_jsp_text[20]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[21]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[22]);
       } 
      out.write(__oracle_jsp_text[23]);
      if(bInsertar1 == 2){ 
      out.write(__oracle_jsp_text[24]);
      } 
      out.write(__oracle_jsp_text[25]);
      out.print(strClave);
      out.write(__oracle_jsp_text[26]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[27]);
      
      						}
      out.write(__oracle_jsp_text[28]);
      out.print(strCodigo);
      out.write(__oracle_jsp_text[29]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[30]);
      
      						}
      out.write(__oracle_jsp_text[31]);
      out.print(strSeccion);
      out.write(__oracle_jsp_text[32]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[33]);
      
      						}
      out.write(__oracle_jsp_text[34]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[35]);
      
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
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML> \n<HEAD>\n".toCharArray();
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
    "\n\t\t\t\t\t<SCRIPT language=JavaScript type=text/javascript>\n\t\t\t\t\topener.document.clsf.submit();\n\t\t\t\t\twindow.close();\n\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Subserie</TITLE>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\tfunction limpiarCampos(){\n\t\tdocument.subfondo1AS.reset();\n\t}\n\tfunction rValidando() {\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\talert(\"El registro consultado no puede ser modificado\");\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t}\t\n\tfunction cambio(){\n\tdoc = document.subfondo1AS;\n\tval = doc.fondo.value;\n\tdoc.fondoCamb.value = val;\n\t}\t\n</SCRIPT>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"rValidando();timer_load();\" \n\tonKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload();\">\n<FORM action=\"SubserieArch.jsp\" name=\"subfondo1AS\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" name=\"id_sub\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"fondoCamb\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"IdSerie\">\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"../jsp/SubseriesArchview.jsp\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/Regresar.gif\" width=\"82\" height=\"26\"> </a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\"><a><img\n\t\t\t\tsrc=\"../Imagenes/Guardar.gif\" width=\"81\" border=\"0\"\n\t\t\t\tonclick=\"GuardarSubfondoAS()\"></a></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"204\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><FONT size=\"+1\" color=\"#004080\">Subseries</FONT></FONT></B></TD>\n\t\t\t<TD width=\"76\">&nbsp;</TD>\n\t\t\t<TD width=\"392\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"204\" colspan=\"2\" bgcolor=\"#004080\"></TD>\n\t\t\t<TD width=\"76\" bgcolor=\"#004080\"></TD>\n\t\t\t<TD width=\"392\" bgcolor=\"#004080\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"204\" colspan=\"2\" bgcolor=\"#004080\"></TD>\n\t\t\t<TD width=\"76\" bgcolor=\"#004080\"></TD>\n\t\t\t<TD width=\"392\" bgcolor=\"#004080\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[18] = 
    " - ".toCharArray();
    __oracle_jsp_text[19] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[21] = 
    " - ".toCharArray();
    __oracle_jsp_text[22] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tClave:</FONT></B><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "<B><FONT color=\"red\">*Esta clave ya existe*</FONT>\n\t\t\t</B>".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"clave\" value=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\t\t\t\t\n\t\t\t\tMAXLENGTH=\"3\" type=\"text\" class=\"blue100\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tNombre:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"subCodigo\" value=\"".toCharArray();
    __oracle_jsp_text[29] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\t\t\t\t\n\t\t\t\ttype=\"text\" class=\"blue500\" MAXLENGTH=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tDescripción:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<textarea name=\"subSeccion\" rows=\"8\" cols=\"60\">".toCharArray();
    __oracle_jsp_text[32] = 
    "</textarea>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tInactivo:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=checkbox  value=\"si\"  \n\t\t\t\tname=\"inactivo\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFecha Inactivo:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"fecinact\" value=\"\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\t\t\t\t\n\t\t\t\ttype=\"text\" class=\"blue100\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tJustificacion:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"justif\" value=\"\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\t\t\t\t\n\t\t\t\ttype=\"text\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\t\t\t\t\t\t\n\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
