package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _SubseriesArchview extends com.orionserver.http.OrionHttpJspPage {


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
    _SubseriesArchview page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
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
      
      out.write(__oracle_jsp_text[3]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[4]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[5]);
       } 
      out.write(__oracle_jsp_text[6]);
      
      	boolean bExiste			=	false;
      	boolean bOperacion		=	false;
      	int bOperacion1		=	0;	
      	String strIds_Borrar[]	=	null;
      	String strAccion		=	"";
      	String msg				=	request.getParameter("msg");	
      	int t = 0;
      	strAccion				=	request.getParameter("accion");
      	strIds_Borrar			=	request.getParameterValues("Borrar");
      
      	bExiste					=	ActualizaExpArchivado.getExisteSubSer();	
      
      	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
      	{
      		bOperacion1	=	ActualizaExpArchivado.getDeleteSer(strIds_Borrar,BUsuario.getIdUsuario());
      			if(bOperacion1 == 2)
      			{
      			msg ="Existen registros asociados, el proceso de borrado no fue exitoso";
      			}
      	}
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      
      out.write(__oracle_jsp_text[7]);
      out.write(__oracle_jsp_text[8]);
      if(msg!= null && msg.trim().length()>0)
      		{
      		
      out.write(__oracle_jsp_text[9]);
      out.print(msg);
      out.write(__oracle_jsp_text[10]);
      
      		}
      		
      out.write(__oracle_jsp_text[11]);
       if(bExiste){ 
      out.write(__oracle_jsp_text[12]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaExpArchivado.getDatosSubSerieA(strOrden, strTipo));
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
            out.write(__oracle_jsp_text[13]);
             if(BUsuario.getAdmon()){ 
            out.write(__oracle_jsp_text[14]);
             t++; 
            out.write(__oracle_jsp_text[15]);
            if(par(t)==true){
            }else{
            out.write(__oracle_jsp_text[16]);
            }
            out.write(__oracle_jsp_text[17]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[18]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[19]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[20]);
            out.print(campo3);
            out.write(__oracle_jsp_text[21]);
            out.print(campo4);
            out.write(__oracle_jsp_text[22]);
            out.print(campo5);
            out.write(__oracle_jsp_text[23]);
             } 
            out.write(__oracle_jsp_text[24]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[25]);
       } else { 
      out.write(__oracle_jsp_text[26]);
       } 
      out.write(__oracle_jsp_text[27]);

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
  private static final char __oracle_jsp_text[][]=new char[28][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n<HTML> \n<HEAD>\n".toCharArray();
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Subserie</TITLE>\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.subsviewA;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n\tfunction validaReg() { \n\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\talert(\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\");\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t}\t\n</script>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"validaReg();timer_load();\" \n\tonKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload();\">\n<FORM action=\"SubseriesArchview.jsp\" name=\"subsviewA\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"100%\" colspan=\"2\"></TD>\n    </TR>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"43%\">\n\t\t\t<A href=\"SubserieArch.jsp\">\n\t\t\t\t<IMG height=\"26\" alt=\"Agregar Subserie\" src=\"../Imagenes/Nuevo.gif\" width=\"27\" border=\"0\"></A>\n\t\t\t\t<FONT face=\"Tahoma\" size=\"2\">\n\t\t\t\t</FONT>\n\t\t\t\t<A href=\"javascript:Borrar()\">\n\t\t\t\t<IMG border=\"0\" alt=\"Borrar Subserie\" src=\"../Imagenes/borrar2.gif\" width=\"30\" height=\"27\">\n\t\t\t\t</A>\n\t\t</TD>\n\t\t<TD width=\"57%\" align=\"right\" valign=\"bottom\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/masbien.gif\" width=\"20\" height=\"20\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/menosbien.gif\" width=\"20\" height=\"20\">\n        </TD>\n    </TR>\n</TBODY>\n</TABLE>\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD width=\"25%\" align=\"center\">\n            <IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Nombre Subserie</FONT></b>\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\">\n        </TD>\n\t\t<TD width=\"25%\" align=\"center\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Descripcion</FONT></b>\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\">\n        </TD>\n        <TD width=\"25%\" align=\"center\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Serie</FONT></b>\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\">\n        </TD>\n        <TD width=\"25%\" align=\"center\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\">\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Clave</FONT></b>\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\">\n        </TD>        \n    </TR>\n</TBODY>\n</TABLE>\n<DIV id=\"msg\"></DIV>\n<DIV id=\"view\">\n<TABLE width=\"100%\" border=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t<TR vAlign=top ".toCharArray();
    __oracle_jsp_text[16] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[17] = 
    ">\n\t\t<TD width=\"25%\">\n    \t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"Borrar\">\n    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t    <A href=\"SubserieArch.jsp?id_sub=".toCharArray();
    __oracle_jsp_text[19] = 
    "\">".toCharArray();
    __oracle_jsp_text[20] = 
    "</A>\n    \t\t</FONT>\n\t   \t</TD> \n\t\t<TD width=\"25%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"25%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\n\t\t<TD width=\"25%\" align=\"center\">\n\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t</FONT>\n\t\t</TD>\t\t\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t<TR> \n\t\t<TD width=\"100%\">\n\t\t\t<div align=center>\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No Hay Subseries capturados******</FONT>\n\t\t\t</div>\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n</TBODY>\n</TABLE>\n</DIV>\n<BR>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
