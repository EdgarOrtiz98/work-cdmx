package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import java.util.*;
import com.meve.sigma.util.*;


public class _estructuraGestion extends com.orionserver.http.OrionHttpJspPage {


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
    _estructuraGestion page = this;
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
       
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){}
      	}
      
      
      out.write(__oracle_jsp_text[4]);
      
      	String strSupervisor			=	"";
      	String strCargo					=	"";
      	String strIdSupervisor			=	"";
      	String area[][]					=	null;
      	String strMiembros[][]			=	null;
      	
      	String strUsuarios[][] = null;
      	Arboles tree = null;
      	Vector vNombres = null;
      	Vector vIds = null;
      
      	String strIdArea = (request.getParameter("area")== null)?BUsuario.getIdArea():request.getParameter("area");
      	if(strIdArea != null && strIdArea.length()>0){
      		area			=	ActualizaArea.getIDArea(strIdArea);
      		strMiembros		=	ActualizaArea.getMiembrosArea(strIdArea);
      		if(area.length != 0)
      		{
      			strSupervisor	=	area[0][2];
      			strCargo		=	area[0][3];
      			strIdSupervisor	=	area[0][4];
      		}else{
      			strSupervisor	=	"La UA no tiene un Supervisor asignado";
      		}
      		if (!strIdSupervisor.equals("")){
      			strUsuarios = ActualizaUsuario.getSubalternoSinRol(strIdSupervisor);
      			tree = new Arboles(strUsuarios,strIdArea,Utilerias.codificaPostHTML(strTmp+"?area="+strIdArea));
      			vNombres = tree.getNombresHtmlGestion();
      			vIds = tree.getIds();
      			vIds.add(strIdSupervisor);
      		}
      	}
      
      out.write(__oracle_jsp_text[5]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[6]);
       if (BUsuario.getAdmon()){ 
      out.write(__oracle_jsp_text[7]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ActualizaUsuario.getAreas());
        __jsp_taghandler_1.setName("areas");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_1.setClassHtml("blue500a");
        __jsp_taghandler_1.setScript("onchange='cambioArea(this)'");
        __jsp_taghandler_1.setTextoNoSeleccion(" -------------------- Seleccionar Unidad Administrativa --------------------");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[8]);
       } 
      out.write(__oracle_jsp_text[9]);
       if(strIdArea != null && strIdArea.length() > 0){ 
      out.write(__oracle_jsp_text[10]);
      out.print( ActualizaArea.NombreArea(strIdArea) );
      out.write(__oracle_jsp_text[11]);
      out.print( strIdSupervisor );
      out.write(__oracle_jsp_text[12]);
      out.print( strIdArea );
      out.write(__oracle_jsp_text[13]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?area="+strIdArea) );
      out.write(__oracle_jsp_text[14]);
      out.print( strCargo );
      out.write(__oracle_jsp_text[15]);
      out.print(strSupervisor);
      out.write(__oracle_jsp_text[16]);
       	if(!strIdSupervisor.equals("") && vIds.size()>1){ 
      out.write(__oracle_jsp_text[17]);
      	if(vNombres.size()>0){
      out.write(__oracle_jsp_text[18]);
      out.print( strIdSupervisor );
      out.write(__oracle_jsp_text[19]);
      out.print( strIdArea );
      out.write(__oracle_jsp_text[20]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?area="+strIdArea) );
      out.write(__oracle_jsp_text[21]);
      out.print( strCargo );
      out.write(__oracle_jsp_text[22]);
      out.print(strSupervisor);
      out.write(__oracle_jsp_text[23]);
      	for(int t=0;t<vNombres.size();t++){
      			
      out.write(__oracle_jsp_text[24]);
      out.print(vNombres.get(t));
      out.write(__oracle_jsp_text[25]);
      	}
      out.write(__oracle_jsp_text[26]);
      	}else{
      			
      out.write(__oracle_jsp_text[27]);
      
      				}
      			
      out.write(__oracle_jsp_text[28]);
      	} 
      out.write(__oracle_jsp_text[29]);
       	int jx = 0;
      				if(strMiembros.length > 0){ 
      out.write(__oracle_jsp_text[30]);
       for(int j=0;j<strMiembros.length;j++){ 
      out.write(__oracle_jsp_text[31]);
       	boolean bandera = true;
      						if (vIds!=null){
      							for (int k=0; k<vIds.size(); k++){
      								if (strMiembros[j][0].equals((String)vIds.get(k)))
      									bandera = false;
      							} 
      						}
      					
      out.write(__oracle_jsp_text[32]);
      		if (bandera){ 
      out.write(__oracle_jsp_text[33]);
      out.print(strMiembros[j][0]);
      out.write(__oracle_jsp_text[34]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[35]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?area="+strIdArea) );
      out.write(__oracle_jsp_text[36]);
      out.print(strMiembros[j][2]);
      out.write(__oracle_jsp_text[37]);
      out.print(strMiembros[j][1]);
      out.write(__oracle_jsp_text[38]);
       		jx++;
      						} 
      out.write(__oracle_jsp_text[39]);
       } 
      out.write(__oracle_jsp_text[40]);
       }else{ 
      				jx = -1; 
      out.write(__oracle_jsp_text[41]);
       } 
      out.write(__oracle_jsp_text[42]);
       if (jx==0){ 
      out.write(__oracle_jsp_text[43]);
       } 
      out.write(__oracle_jsp_text[44]);
       } 
      out.write(__oracle_jsp_text[45]);

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
  private static final char __oracle_jsp_text[][]=new char[46][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Puestos</TITLE>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction cambioArea(opcion){\n\t\tdoc = document.estructura;\n\t\tvar cadena = \"\";\n\t\tif(opcion.options[opcion.selectedIndex].value != \"-1\"){\n\t\t\tcadena = opcion.options[opcion.selectedIndex].value;\n\t\t\tdoc.area.value = cadena;\n\t\t\tdoc.submit();\n\t\t}\n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n<FORM name=\"estructura\" action=\"estructuraGestion.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\" name=\"area\">\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n<DIV align=\"center\">\n<TABLE border=\"0\">\n\t<TR>\n\t\t<TD align=\"center\" width=\"500\"><b>Unidad Administrativa</b></TD>\n\t</TR>\n\t<TR align=\"center\">\n\t\t<TD align=\"center\" width=\"500\">".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t</TR>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<DIV align=\"center\">\n<TABLE border=\"0\" width=\"70%\">\n\t<TBODY>\n\t\t<TR valign=\"middle\">\n\t\t\t<TD class=\"etiquetas1v\" align=\"left\">\n\t\t\t\t<B><FONT size=\"+1\">&nbsp;&nbsp;Puestos</FONT></B>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"middle\">\n\t\t\t<td bgcolor=\"#004080\">\n\t\t\t<img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV> \n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<DIV align=\"center\">\n<TABLE border=\"0\" width=\"70%\">\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Responsable de la Unidad Administrativa: ".toCharArray();
    __oracle_jsp_text[11] = 
    "</B>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t<A href=\"estructuraPuestoGestion.jsp?id=".toCharArray();
    __oracle_jsp_text[12] = 
    "&area=".toCharArray();
    __oracle_jsp_text[13] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[14] = 
    "\" class=\"etiquetas\" \n\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\"><B><U>".toCharArray();
    __oracle_jsp_text[16] = 
    "</U></B></A>\n\t\t</TD>\n\t</tr>\n\t<TR><TD> &nbsp;</TD></TR>\n\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Organigrama de la Unidad</B>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t<UL>\n\t\t\t\t<LI>\n\t\t\t\t\t<A href=\"estructuraPuestoGestion.jsp?id=".toCharArray();
    __oracle_jsp_text[19] = 
    "&area=".toCharArray();
    __oracle_jsp_text[20] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[21] = 
    "\" class=\"etiquetas\" \n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\"><B><U>".toCharArray();
    __oracle_jsp_text[23] = 
    "</U></B></A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t</LI>\n\t\t\t</UL>\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t** No tiene Subalternos asignados **\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t</TD>\n\t</tr>\n\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Puestos de la Unidad sin relación al Organigrama principal</B>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t\t<A href=\"estructuraPuestoGestion.jsp?id=".toCharArray();
    __oracle_jsp_text[34] = 
    "&area=".toCharArray();
    __oracle_jsp_text[35] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[36] = 
    "\" class=\"etiquetas\" \n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "\" >\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "</A><BR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">*** No hay puestos sin relación ***</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">*** No hay puestos sin relación ***</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t</TD>\n\t</tr>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[45] = 
    "\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
