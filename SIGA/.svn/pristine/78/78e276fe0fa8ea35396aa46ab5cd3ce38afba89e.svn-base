package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _FlujoAtencionView extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }

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
    _FlujoAtencionView page = this;
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
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[7]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[8]);
       } 
      out.write(__oracle_jsp_text[9]);
      
      	String [][] sql	=null;
      	boolean bOperacion		=	false;
      	String strIds_Borrar[]	=	null;
      	int t = 0;
      	String strAccion		=	"";
      	strAccion				=	request.getParameter("accion");
      	strIds_Borrar			=	request.getParameterValues("Borrar");
      	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
      	{
      		bOperacion	=	ActualizaFlujo.deleteFlujo(strIds_Borrar,BUsuario.getIdUsuario());
      	}
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
       
      out.write(__oracle_jsp_text[10]);
      out.write(__oracle_jsp_text[11]);
       int j = 0; 
      out.write(__oracle_jsp_text[12]);
      sql=ActualizaFlujo.getListaFlujos(strOrden, strTipo);
      out.write(__oracle_jsp_text[13]);
      if(sql==null){
      out.write(__oracle_jsp_text[14]);
      }else {
      out.write(__oracle_jsp_text[15]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(sql);
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
            out.write(__oracle_jsp_text[16]);
             if(	BUsuario.getAdmon() ||
            				BUsuario.getIdArea().equals(campo3)){ 
            out.write(__oracle_jsp_text[17]);
             t++; 
            out.write(__oracle_jsp_text[18]);
            if(par(t)==true){
            }else{
            out.write(__oracle_jsp_text[19]);
            }
            out.write(__oracle_jsp_text[20]);
            out.print(campo2);
            out.write(__oracle_jsp_text[21]);
            out.print(campo2);
            out.write(__oracle_jsp_text[22]);
            out.print(campo1);
            out.write(__oracle_jsp_text[23]);
            out.print(campo1);
            out.write(__oracle_jsp_text[24]);
            out.print(campo2);
            out.write(__oracle_jsp_text[25]);
             j++; 
            out.write(__oracle_jsp_text[26]);
             } 
            out.write(__oracle_jsp_text[27]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[28]);
       } 
      out.write(__oracle_jsp_text[29]);
       if(j==0){ 
      out.write(__oracle_jsp_text[30]);
       } 
      out.write(__oracle_jsp_text[31]);

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
  private static final char __oracle_jsp_text[][]=new char[32][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "  \n<HTML>\n<HEAD>\n<TITLE>Ruta Automatica</TITLE>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "  \n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.FlujoAtencionView;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM action=\"FlujoAtencionView.jsp\" name=\"FlujoAtencionView\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" colspan=\"2\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"43%\"><A href=\"FlujoAtencion.jsp\" target=\"_self\"> <IMG\n\t\t\t\theight=\"26\" src=\"../Imagenes/Nuevo.gif\" width=\"27\" border=\"0\" alt=\"Nueva Ruta Automática\"></A> <FONT\n\t\t\t\tface=\"Tahoma\" size=\"2\"></FONT> <A href=\"javascript:Borrar()\"\n\t\t\t\ttarget=\"_self\"> <IMG border=\"0\" src=\"../Imagenes/borrar2.gif\"\n\t\t\t\twidth=\"30\" height=\"27\" alt=\"Borrar Ruta Automática\"></A></TD>\n\t\t\t<TD width=\"57%\" align=\"right\" valign=\"bottom\">\n\t\t\t<IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/masbien.gif\" width=\"20\" height=\"20\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/menosbien.gif\" width=\"20\" height=\"20\">\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR bgcolor=\"#00204f\">\n\t\t\t<TD id=\"Asunto_HD\" width=\"50%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Ruta\tAutomatica</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"50%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Id del Documento</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body>\n<DIV id=\"view\"><BR>\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n<TABLE width=\"100%\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD nowrap>&nbsp;<FONT face=\"Arial\" color=\"#000080\" size=\"2\"></FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD nowrap></TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No Hay Rutas\n\t\t\tAutomaticas capturadas******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    " \n\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t<TR vAlign=top ".toCharArray();
    __oracle_jsp_text[19] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[20] = 
    ">\n\t\t\t\t<TD width=\"50%\"><INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\"\n\t\t\t\t\tname=\"Borrar\"><FONT face=Arial color=#000080 size=1> <A\thref=\"FlujoAtencion.jsp?id_flujo=".toCharArray();
    __oracle_jsp_text[22] = 
    "\" title=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\">\n\t\t\t\t\t<script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[24] = 
    "','Asunto_HD'));</script></A> </FONT>\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"50%\" align=\"center\"><FONT face=Arial color=#000080 size=1> ".toCharArray();
    __oracle_jsp_text[25] = 
    " </FONT>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No hay Rutas Automaticas\n\t\t\tCapturados en su Unidad Administrativa ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
