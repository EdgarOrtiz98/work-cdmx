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


public class _SubfondoArch extends com.orionserver.http.OrionHttpJspPage {


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
    _SubfondoArch page = this;
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
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      
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
      
      out.write(__oracle_jsp_text[5]);
       if(!BUsuario.getAdmon() && !BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[6]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[7]);
       } 
      out.write(__oracle_jsp_text[8]);
      
      	String msg = "";
      	String strIdSubfondo	=	"";
      	String strCodigo		=	"";
      	String strSeccion		=	"";
      	String strUsrActualiza	=	"";
      	String strFecha			=	"";
      	String strAccion		=	"";
      	String strFondo			=	"";
      	String strclave			=	"";
      	String strInact			=	"";
      	String strFecInac		=	"";
      	String strJustInac		=	"";	
      	String ver				=	"";	
      	String horafec			=	"";
      	String strsoloDesc 		=	"";
      		
      	String strAux = "9999999", strAux2 = "9999999";
      	
      	boolean bInsertar		=	false;
      	int bInsertar1		=	0;	
      		int valida		=	0;	
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
      			strFondo	=   request.getParameter("fondo");		
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strclave	=	request.getParameter("clave");
      			bInsertar1	=	ActualizaExpArchivado.insertarSubfondoA(strCodigo, strSeccion,
      																strFecha, BUsuario.getIdUsuario(),strFondo,strclave,strAux,strAux2);
      			if(bInsertar1 == 2){}
      			else {
      				try{
      					//response.sendRedirect("SubfondoArchview.jsp?msg="+msg);
      					response.sendRedirect(retURI+"&msg="+msg);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}
      
      
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strsoloDesc =	request.getParameter("soloDesc");
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strFondo	=   request.getParameter("fondoCamb");
      			strclave	=	request.getParameter("clave");
      			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
      			strFecInac	=	request.getParameter("fecinact");
      			strJustInac =	request.getParameter("justif");
      			strAux 		= 	request.getParameter("aux"); 						
      			strAux 		= 	request.getParameter("aux"); 
      			strAux2 	= 	request.getParameter("aux2"); 
      			
      			bInsertar1 = ActualizaExpArchivado.actualizaSubfondoA(strsoloDesc,strCodigo, strSeccion, strFecha, 
      															BUsuario.getIdUsuario(), strFondo, strIdSubfondo,strclave
      															,strFecInac,strJustInac,strInact,strAux,strAux2);
      			if (bInsertar1 != 2){
      				try{
      					//response.sendRedirect("SubfondoArchview.jsp");
      					response.sendRedirect(retURI);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}
      	}
      	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	{
      		String strDatosSubfondo[][] = ActualizaExpArchivado.getSubfondoA(strIdSubfondo);
      		strCodigo		=	strDatosSubfondo[0][0];
      		strSeccion		=	strDatosSubfondo[0][1];
      		strFecha		=	strDatosSubfondo[0][2];
      		strUsrActualiza	=	strDatosSubfondo[0][3];
      		strFondo	=		strDatosSubfondo[0][4];		
      		strclave		=	strDatosSubfondo[0][5];
      		strFecInac		=	strDatosSubfondo[0][6];	
      		strJustInac		=	strDatosSubfondo[0][7];	
      		strInact		=	strDatosSubfondo[0][8];	
      		horafec			=	strDatosSubfondo[0][9];					
      		strAux			=  	strclave;
      		strAux2			=  	strFondo;
      		ver				=	"si";		
      		valida	=	ActualizaExpArchivado.getValidaSubfondo(strIdSubfondo);
      	}
      
      out.write(__oracle_jsp_text[9]);
      if(valida == 2) 
      	{
      out.write(__oracle_jsp_text[10]);
      
      	}
      out.write(__oracle_jsp_text[11]);
      out.print(horafec);
      out.write(__oracle_jsp_text[12]);
      out.print(strIdSubfondo);
      out.write(__oracle_jsp_text[13]);
      out.print(strAux);
      out.write(__oracle_jsp_text[14]);
      out.print(strFondo);
      out.write(__oracle_jsp_text[15]);
      out.print(strAux2);
      out.write(__oracle_jsp_text[16]);
      out.print(retURI);
      out.write(__oracle_jsp_text[17]);
      if(valida == 2){
      		strsoloDesc = "1";
      	}
      	
      out.write(__oracle_jsp_text[18]);
      out.print(strsoloDesc);
      out.write(__oracle_jsp_text[19]);
      out.print( retURI );
      out.write(__oracle_jsp_text[20]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[21]);
      	}else{
      out.write(__oracle_jsp_text[22]);
      }
      out.write(__oracle_jsp_text[23]);
       if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[24]);
      out.print(ActualizaUsuario.NombreUsuario(strUsrActualiza));
      out.write(__oracle_jsp_text[25]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[26]);
       }else{ 
      out.write(__oracle_jsp_text[27]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[28]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[29]);
       } 
      out.write(__oracle_jsp_text[30]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)){
      out.write(__oracle_jsp_text[31]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[32]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getSubFondosCombo());
        __jsp_taghandler_1.setName("fondo");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strFondo));
        __jsp_taghandler_1.setDisabled(true);
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onchange='cambio();'");
        __jsp_taghandler_1.setTextoNoSeleccion(" ------------ Selecciona un Fondo------------ ");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[33]);
      }
      					else {
      out.write(__oracle_jsp_text[34]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getSubFondosCombo());
        __jsp_taghandler_2.setName("fondo");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected("");
        __jsp_taghandler_2.setDisabled(true);
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setScript("onchange='cambio();'");
        __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Selecciona un Fondo------------ ");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[35]);
      }
      out.write(__oracle_jsp_text[36]);
      }else{
      out.write(__oracle_jsp_text[37]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[38]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getSubFondosCombo());
        __jsp_taghandler_3.setName("fondo");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strFondo));
        __jsp_taghandler_3.setClassHtml("blue500");
        __jsp_taghandler_3.setScript("onchange='cambio();'");
        __jsp_taghandler_3.setTextoNoSeleccion(" ------------ Selecciona un Fondo------------ ");
        __jsp_taghandler_3.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[39]);
      }
      					else {
      out.write(__oracle_jsp_text[40]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getSubFondosCombo());
        __jsp_taghandler_4.setName("fondo");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected("");
        __jsp_taghandler_4.setClassHtml("blue500");
        __jsp_taghandler_4.setScript("onchange='cambio();'");
        __jsp_taghandler_4.setTextoNoSeleccion(" ------------ Selecciona un Fondo------------ ");
        __jsp_taghandler_4.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[41]);
      }
      out.write(__oracle_jsp_text[42]);
      }
      out.write(__oracle_jsp_text[43]);
      if(bInsertar1 == 2){ 
      out.write(__oracle_jsp_text[44]);
      } 
      out.write(__oracle_jsp_text[45]);
      out.print(strclave);
      out.write(__oracle_jsp_text[46]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[47]);
      
      						}
      out.write(__oracle_jsp_text[48]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[49]);
      	}
      out.write(__oracle_jsp_text[50]);
      out.print(strCodigo);
      out.write(__oracle_jsp_text[51]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[52]);
      
      						}
      out.write(__oracle_jsp_text[53]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[54]);
      	}
      out.write(__oracle_jsp_text[55]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[56]);
      	}
      out.write(__oracle_jsp_text[57]);
      out.print(strSeccion);
      out.write(__oracle_jsp_text[58]);
      if(strInact == "3" || strInact.equals("3")) 
      						{
      out.write(__oracle_jsp_text[59]);
      
      						}
      out.write(__oracle_jsp_text[60]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[61]);
      
      						}
      out.write(__oracle_jsp_text[62]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[63]);
      
      						}
      out.write(__oracle_jsp_text[64]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[65]);
      	}
      out.write(__oracle_jsp_text[66]);
      out.print(strFecInac);
      out.write(__oracle_jsp_text[67]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[68]);
      	}
      out.write(__oracle_jsp_text[69]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[70]);
      
      						}
      out.write(__oracle_jsp_text[71]);
      if(valida == 2) 
      					{
      out.write(__oracle_jsp_text[72]);
      
      					}
      out.write(__oracle_jsp_text[73]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[74]);
      
      					}
      out.write(__oracle_jsp_text[75]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[76]);
      	}
      out.write(__oracle_jsp_text[77]);
      out.print(strJustInac);
      out.write(__oracle_jsp_text[78]);

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
  private static final char __oracle_jsp_text[][]=new char[79][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Subfondos</TITLE>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/Menu2.js\"></script>\t\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\tfunction limpiarCampos(){\n\t\tdocument.subfondo1A.reset();\n\t}\nfunction rValidando() {\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\talert(\"Como este registro ya cuenta con registros dependientes, solo podra ser modificado su Descripción \");\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n}\n\tfunction cambio(){\n\tdoc = document.subfondo1A;\n\tval = doc.fondo.value;\n\tdoc.fondoCamb.value = val;\n\t}\n\tfunction llena()\n\t{\n\tdoc = document.subfondo1A;\n\ta = doc.clave.value;\n\tif(a.length < 2)\n\t\t{\n\t\t\tdoc.clave.value = \"00\" + a;\t\n\t\t}\n\tif(a.length < 3 && a.length >1)\n\t\t{\n\t\t\tdoc.clave.value = \"0\" + a;\t\n\t\t}\n\t}\n\n\tfunction habilita2()\n\t{\n\t\tif(document.subfondo1A.inactivo.checked == true)\n\t\t{\n\t\tdocument.subfondo1A.fecinact.value = \"".toCharArray();
    __oracle_jsp_text[12] = 
    "\";\n\t\tdocument.subfondo1A.fecinact.disabled = false;\n\t\tdocument.subfondo1A.justif.disabled = false;\n\t\t}else\n\t\t{\n\t\tdocument.subfondo1A.fecinact.value = \"\";\n\t\tdocument.subfondo1A.justif.value = \"\";\n\t\tdocument.subfondo1A.fecinact.disabled = true;\n\t\tdocument.subfondo1A.justif.disabled = true;\n\t\t}\n\t}\n\t\n</SCRIPT>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;rValidando();setFormFocusSubFondoA();limpiarCampos();timer_load();\" \n\tonKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload();\">\n<FORM action=\"SubfondoArch.jsp\" name=\"subfondo1A\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"id_sub\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"fondoCamb\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"retURI\">\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"soloDesc\">\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"> </a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t<a></a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\t\n\t\t\t\t<a><img\tsrc=\"../Imagenes/Save.gif\" alt=\"Guardar\" border=\"0\"\tonclick=\"GuardarSubfondoA()\"></a> \n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\t\t\t\t\t\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"256\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><FONT size=\"+1\" color=\"#004080\">Subfondos</FONT></FONT></B></TD>\n\t\t\t<TD width=\"37\">&nbsp;</TD>\n\t\t\t<TD width=\"379\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"256\" colspan=\"2\" bgcolor=\"#002850\"></TD>\n\t\t\t<TD width=\"37\" bgcolor=\"#002850\"></TD>\n\t\t\t<TD width=\"379\" bgcolor=\"#002850\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"256\" colspan=\"2\" bgcolor=\"#002850\"></TD>\n\t\t\t<TD width=\"37\" bgcolor=\"#002850\"></TD>\n\t\t\t<TD width=\"379\" bgcolor=\"#002850\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\"> \n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></B></FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[25] = 
    " - ".toCharArray();
    __oracle_jsp_text[26] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[28] = 
    " - ".toCharArray();
    __oracle_jsp_text[29] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFondo:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\t\t\t\n\t\t\t</TD>\n\n\n\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tClave:</FONT></B></FONT><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "<B><FONT color=\"red\">*Esta clave ya existe*</FONT>\n\t\t\t</B>".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"clave\" value=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\" MAXLENGTH=\"3\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\t\t\t\n\t\t\t\ttype=\"text\" class=\"blue100\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\"\n\t\t\t\t\tonblur=\"llena();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tNombre: </FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"subCodigo\" value=\"".toCharArray();
    __oracle_jsp_text[51] = 
    "\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\t\t\t\n\t\t\t\t MAXLENGTH=\"200\" type=\"text\" class=\"blue500\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tDescripción:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<textarea name=\"subSeccion\" \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\t\t\t\n\t\t\t\tonKeyDown=\"limitaTextArea(document.subfondo1A.subSeccion,'Descripción','4000');\"\n\t\t\t\trows=\"8\" cols=\"60\">".toCharArray();
    __oracle_jsp_text[58] = 
    "</textarea>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tInactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=checkbox onclick=\"habilita2()\" value=\"3\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t\t\t\t checked\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\t\t\t\n\t\t\t\tname=\"inactivo\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFecha Inactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"fecinact\" value=\"".toCharArray();
    __oracle_jsp_text[67] = 
    "\"\n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\t\t\n\t\t\t\ttype=\"text\" class=\"blue100\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tJustificacion:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<TEXTAREA name=\"justif\" id=\"justif\" rows=\"3\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.subfondo1A.justif,'Justificación','1000');\"\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[78] = 
    "</TEXTAREA>\t\t\t\t\n\t\t\t</TD>\n\t\t</TR>\t\t\t\t\t\t\n\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
