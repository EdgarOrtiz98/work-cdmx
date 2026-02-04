package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import java.util.ArrayList;
import java.util.*;
import com.meve.sigma.util.*;


public class _estructuraPuestoGestion extends com.orionserver.http.OrionHttpJspPage {


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
    _estructuraPuestoGestion page = this;
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
      
      	String strIdUsuario = (request.getParameter("id")== null)?"":request.getParameter("id");
      	String strIdArea 	= (request.getParameter("area")== null)?"":request.getParameter("area");
      	String strAccion = request.getParameter("accion");
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
      	String strIdsRol[][] = null;
      	Vector vTiene = new Vector();
      	String strIds_Borrar[] = new String[1];
      	strIds_Borrar[0] = strIdUsuario;
      
      	if (strIdUsuario.equals("") || strIdArea.equals("")){
      		try{
      			response.sendRedirect(retURI);
      		}
      		catch(java.io.IOException io){;}
      	}
      
      	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
      		vTiene = ActualizaUsuario.deleteUsuario(strIds_Borrar,BUsuario.getIdUsuario());
      	}
      
      	String usuario[][] 			= 	null;
      	String strCompanieros[][]	=	null;
      	String areas[][]			=	null;
      	String asistentes[]			=	null;//Multiasistentes
      	java.util.Stack st 			= 	new java.util.Stack();
      	ArrayList subalternosUsuario	=	null;
      	Vector vNombres1 				= 	new Vector();
      	Vector vIds 					= 	new Vector();
      	Vector vIdsMando 				= 	new Vector();
      	if(strIdUsuario != null && strIdUsuario.length() > 0)
      	{
      		usuario	=	ActualizaUsuario.getIDUsuarioBean(strIdUsuario);
      		asistentes	=	ActualizaUsuario.getAsistentes(strIdUsuario); 
      		if(usuario!=null)
      		{
      			String areaUsuario				=	usuario[0][1];
      			String idUsuario				=	usuario[0][0];
      			strCompanieros	=	ActualizaUsuario.getCompanierosArea(idUsuario);
      			st = ActualizaUsuario.getCadenaDeMandoPara(idUsuario);
      			
      			String strUsuarios[][] = ActualizaUsuario.getSubalternoSinRol(idUsuario);
      			Arboles tree = new Arboles(strUsuarios, strIdArea, Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+Utilerias.codificaPostHTML(retURI)));
      			vNombres1 = tree.getNombresHtmlGestion();
      			vIds = tree.getIds();
      			vIds.add(strIdUsuario);
      		}
      
      		strIdsRol	=	ActualizaRol.getRoles(strIdUsuario);
      
      	}
      
      out.write(__oracle_jsp_text[4]);
      out.print(retURI);
      out.write(__oracle_jsp_text[5]);
      out.print(strIdUsuario);
      out.write(__oracle_jsp_text[6]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[7]);
      out.print(strAccion);
      out.write(__oracle_jsp_text[8]);
      if(vTiene.size()>0){
      out.write(__oracle_jsp_text[9]);
      	for(int i=0;i<vTiene.size();i++){
      out.write(__oracle_jsp_text[10]);
      out.print(ActualizaUsuario.NombreUsuario((String)vTiene.get(i)));
      out.write(__oracle_jsp_text[11]);
      	} 
      out.write(__oracle_jsp_text[12]);
      }else{
      	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
      		try{
      			response.sendRedirect(retURI);
      		}
      		catch(java.io.IOException io){;}
      	}
        }
      out.write(__oracle_jsp_text[13]);
      out.print(retURI);
      out.write(__oracle_jsp_text[14]);
      out.print(usuario[0][2]);
      out.write(__oracle_jsp_text[15]);
      out.print(usuario[0][3]);
      out.write(__oracle_jsp_text[16]);
      	for (int i=0; i<strIdsRol.length; i++){ 
      out.write(__oracle_jsp_text[17]);
      out.print((strIdsRol[i][0].equals("0"))?"Administrador":"");
      out.write(__oracle_jsp_text[18]);
      out.print((strIdsRol[i][0].equals("1"))?"atención":"");
      out.write(__oracle_jsp_text[19]);
      out.print((strIdsRol[i][0].equals("2"))?"SCP":"");
      out.write(__oracle_jsp_text[20]);
      out.print((strIdsRol[i][0].equals("3"))?"Recepción":"");
      out.write(__oracle_jsp_text[21]);
      out.print((strIdsRol[i][0].equals("4"))?"Supervisor de área":"");
      out.write(__oracle_jsp_text[22]);
      out.print((strIdsRol[i][0].equals("5"))?"Turnador":"");
      out.write(__oracle_jsp_text[23]);
      out.print((strIdsRol[i][0].equals("6"))?"Asistente":"");
      out.write(__oracle_jsp_text[24]);
      	} 
      out.write(__oracle_jsp_text[25]);
      out.print( usuario[0][5].equals("1")?"atención Destinatarios Externos <BR>":"" );
      out.write(__oracle_jsp_text[26]);
      out.print( usuario[0][6].equals("1")?"Catálogo de Archivado <BR>":"" );
      out.write(__oracle_jsp_text[27]);
      out.print(ActualizaArea.NombreArea(usuario[0][1]));
      out.write(__oracle_jsp_text[28]);
      	if(st.size() > 1){
      			for(int y1 = 0; y1<st.size();y1++){
      				int y = st.size()-y1-1;
      		
      out.write(__oracle_jsp_text[29]);
       if(st.elementAt(y) != null){ 
      out.write(__oracle_jsp_text[30]);
       String strIdMando = ActualizaUsuario.getIdUsuarioxResponsable((String)st.elementAt(y)); 
      out.write(__oracle_jsp_text[31]);
       vIdsMando.add(strIdMando); 
      out.write(__oracle_jsp_text[32]);
       if (ActualizaUsuario.getAreaUsuario(strIdMando).equals(strIdArea)){ 
      out.write(__oracle_jsp_text[33]);
      out.print(strIdMando);
      out.write(__oracle_jsp_text[34]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[35]);
      out.print(Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+Utilerias.codificaPostHTML(retURI)));
      out.write(__oracle_jsp_text[36]);
      out.print( ActualizaUsuario.NombreUsuario(strIdMando));
      out.write(__oracle_jsp_text[37]);
      out.print( ActualizaUsuario.NombrePuesto(strIdMando));
      out.write(__oracle_jsp_text[38]);
       }else{ 
      out.write(__oracle_jsp_text[39]);
      out.print( ActualizaUsuario.NombreUsuario(strIdMando));
      out.write(__oracle_jsp_text[40]);
      out.print( ActualizaArea.NombreArea(ActualizaUsuario.getAreaUsuario(strIdMando)) );
      out.write(__oracle_jsp_text[41]);
      out.print( ActualizaUsuario.NombrePuesto(strIdMando));
      out.write(__oracle_jsp_text[42]);
       } 
      out.write(__oracle_jsp_text[43]);
       }
      out.write(__oracle_jsp_text[44]);
      	}
      out.write(__oracle_jsp_text[45]);
      out.print( usuario[0][3] );
      out.write(__oracle_jsp_text[46]);
      out.print(usuario[0][2]);
      out.write(__oracle_jsp_text[47]);
      	for(int y = 0; y<st.size();y++){ 
      				if(st.elementAt(y) != null){ 
      out.write(__oracle_jsp_text[48]);
       		} 
      out.write(__oracle_jsp_text[49]);
      	}
      out.write(__oracle_jsp_text[50]);
      	}else{
      		
      out.write(__oracle_jsp_text[51]);
      }
      out.write(__oracle_jsp_text[52]);
      	if(vNombres1.size()>0){
      out.write(__oracle_jsp_text[53]);
      out.print( usuario[0][3] );
      out.write(__oracle_jsp_text[54]);
      out.print(usuario[0][2]);
      out.write(__oracle_jsp_text[55]);
      	for(int t=0;t<vNombres1.size();t++){
      		
      out.write(__oracle_jsp_text[56]);
      out.print(vNombres1.get(t));
      out.write(__oracle_jsp_text[57]);
      	}
      out.write(__oracle_jsp_text[58]);
      	}else{
      		
      out.write(__oracle_jsp_text[59]);
      
      			}
      		
      out.write(__oracle_jsp_text[60]);
      if(asistentes.length>0){
      out.write(__oracle_jsp_text[61]);
      for(int i=0;i<asistentes.length;i++){
      out.write(__oracle_jsp_text[62]);
      out.print(asistentes[i]);
      out.write(__oracle_jsp_text[63]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[64]);
      out.print(Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+Utilerias.codificaPostHTML(retURI)));
      out.write(__oracle_jsp_text[65]);
      out.print( ActualizaUsuario.NombreUsuario(asistentes[i]));
      out.write(__oracle_jsp_text[66]);
      out.print( ActualizaUsuario.NombrePuesto(asistentes[i]));
      out.write(__oracle_jsp_text[67]);
      }
      out.write(__oracle_jsp_text[68]);
       }else{ 
      out.write(__oracle_jsp_text[69]);
       } 
      out.write(__oracle_jsp_text[70]);
       if(strCompanieros.length > 0){ 
      out.write(__oracle_jsp_text[71]);
       for(int i=0;i<strCompanieros.length;i++){ 
      out.write(__oracle_jsp_text[72]);
       	boolean bandera = true;
      					if (ActualizaUsuario.esAsistente(strCompanieros[i][0], asistentes))
      						bandera = false;
      					if (bandera && vIds!=null){
      						for (int k=0; k<vIds.size(); k++){
      							if (strCompanieros[i][0].equals((String)vIds.get(k)))
      								bandera = false;
      						} 
      					}
      					if (bandera && vIdsMando!=null){
      						for (int k=0; k<vIdsMando.size(); k++){
      							if (strCompanieros[i][0].equals((String)vIdsMando.get(k)))
      								bandera = false;
      						} 
      					}
      				
      out.write(__oracle_jsp_text[73]);
      		if (bandera){ 
      out.write(__oracle_jsp_text[74]);
      out.print(strCompanieros[i][0]);
      out.write(__oracle_jsp_text[75]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[76]);
      out.print( Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+Utilerias.codificaPostHTML(retURI)) );
      out.write(__oracle_jsp_text[77]);
      out.print(strCompanieros[i][2]);
      out.write(__oracle_jsp_text[78]);
      out.print(strCompanieros[i][1]);
      out.write(__oracle_jsp_text[79]);
       } 
      out.write(__oracle_jsp_text[80]);
       } 
      out.write(__oracle_jsp_text[81]);
       }else{ 
      out.write(__oracle_jsp_text[82]);
       } 
      out.write(__oracle_jsp_text[83]);

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
  private static final char __oracle_jsp_text[][]=new char[84][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/link.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\">\n<!--\nfunction borrarUsuario(){\n\tdoc=document.forms[0];\n\tif (confirm(\"¿está usted seguro que desea borrar este Registro?\")){    \n\t\tdoc.accion.value=\"borrar\";\n\t\tdoc.submit();\n\t}else \n\t\talert(\"Su petición de borrado ya fue cancelada\");\n}\n//-->\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY  background=\"../Imagenes/fondo_claro.jpg\">\n<FORM name=\"puestoOrg\" action=\"estructuraPuestoGestion.jsp\" method=\"post\">\n<INPUT name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "\" type=\"hidden\">\n<INPUT name=\"id\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\" type=\"hidden\">\n<INPUT name=\"area\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\" type=\"hidden\">\n<INPUT name=\"accion\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" type=\"hidden\">\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"70%\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"75%\" class=\"etiquetas\">\n\t\t\t\t<FONT size=\"1\" color=\"RED\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    ",\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t\t\t<br>No se puede eliminar por que tiene referencias con Puestos y Asuntos</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"70%\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"500\">\n\t\t\t\t<A href=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"></A>\n\t\t\t</TD>\n\t\t\t<TD width=\"69\">&nbsp;</TD>\n\t\t\t<TD width=\"134\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE></DIV>\n<BR>\n<DIV align=\"center\">\n<TABLE border=\"0\" width=\"70%\">\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Puesto</B>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Responsable</B>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Roles del Usuario</B>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t<UL>\n\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    " \n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    " \n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    " \n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    " \n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    " \n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    " \n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    " \n\t\t\t<BR>\n\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t</UL>\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Unidad Administrativa</B>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Cadena de Mando</B>\n\t\t</TD>\n\t</tr>\n\t<tr align=\"left\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t<UL><LI>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t\t\t<A href=\"estructuraPuestoGestion.jsp?id=".toCharArray();
    __oracle_jsp_text[34] = 
    "&area=".toCharArray();
    __oracle_jsp_text[35] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[36] = 
    "\"\n\t\t\t\t\t\tclass=\"etiquetas\" title=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "\">".toCharArray();
    __oracle_jsp_text[38] = 
    "</A><BR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t\t\t\t<A class=\"etiquetas\" title=\"".toCharArray();
    __oracle_jsp_text[40] = 
    " -- ".toCharArray();
    __oracle_jsp_text[41] = 
    "\">".toCharArray();
    __oracle_jsp_text[42] = 
    "</A><BR>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t<UL><LI>\n\t\t\t<A class=\"etiquetas\" title=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\"><B><U>".toCharArray();
    __oracle_jsp_text[47] = 
    "</U></B></A>\n\t\t\t</LI></UL>\n\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t</LI></UL>\n\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t** No tiene Jefes Asignados **\n\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Subalternos</B>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t<UL>\n\t\t\t<LI><A class=\"etiquetas\" title=\"".toCharArray();
    __oracle_jsp_text[54] = 
    "\"><B><U>".toCharArray();
    __oracle_jsp_text[55] = 
    "</U></B></A>\n\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t\t</LI>\n\t\t</UL>\n\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t** No tiene Subalternos asignados **\n\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Asistente</B>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<!--  if(!usuario[0][4].equals(\"\") && usuario[0][4]!=null && !usuario[0][4].equals(\"-1\")){ %>-->\n\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t<td align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t<A href=\"estructuraPuestoGestion.jsp?id=".toCharArray();
    __oracle_jsp_text[63] = 
    "&area=".toCharArray();
    __oracle_jsp_text[64] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[65] = 
    "\"\n\t\t\t\tclass=\"etiquetas\" title=\"".toCharArray();
    __oracle_jsp_text[66] = 
    "\">".toCharArray();
    __oracle_jsp_text[67] = 
    "</A>\n\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t</td>\n\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t\t** No tiene asignado un Asistente **\n\t\t</TD>\n\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\n\t</tr>\n\t<tr bgcolor=\"#004080\">\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\">\n\t\t\t<B>Compañeros de la Unidad</B>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\">\n\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t<A href=\"estructuraPuestoGestion.jsp?id=".toCharArray();
    __oracle_jsp_text[75] = 
    "&area=".toCharArray();
    __oracle_jsp_text[76] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[77] = 
    "\" class=\"etiquetas\"\n\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[78] = 
    "\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "</A><BR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    " <FONT face=\"Verdana\" size=\"2\">No tiene Compañeros</FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "</TD>\n\t</tr>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
