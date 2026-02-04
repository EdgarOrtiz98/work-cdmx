package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.taglib.*;


public class _DestExtView extends com.orionserver.http.OrionHttpJspPage {


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
    _DestExtView page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      com.meve.sigma.beans.BeanAreaView BAreaView;
      synchronized (pageContext) {
        if ((BAreaView = (com.meve.sigma.beans.BeanAreaView) pageContext.getAttribute( "BAreaView", PageContext.PAGE_SCOPE)) == null) {
          BAreaView = (com.meve.sigma.beans.BeanAreaView) new com.meve.sigma.beans.BeanAreaView();
          pageContext.setAttribute( "BAreaView", BAreaView, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[0]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)BAreaView, true);
          out.write(__oracle_jsp_text[1]);
          {
            String __url=OracleJspRuntime.toStr("headerC.jsp");
            // Include 
            pageContext.include( __url,false);
            if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
          }

          out.write(__oracle_jsp_text[2]);
          out.write(__oracle_jsp_text[3]);
          out.write(__oracle_jsp_text[4]);
          out.write(__oracle_jsp_text[5]);
          out.write(__oracle_jsp_text[6]);
          
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
          
          
          out.write(__oracle_jsp_text[7]);
           if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
          		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
          		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
          		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
          		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
          out.write(__oracle_jsp_text[8]);
          if (true) {
            String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
            // Forward 
            pageContext.forward( __url);
            return;
          }

          out.write(__oracle_jsp_text[9]);
           } 
          out.write(__oracle_jsp_text[10]);
          
          	boolean bOperacion = false;
          	int t = 0;
          	String regIDArea = (request.getParameter("regIDArea")==null)?"":request.getParameter("regIDArea");
          	String strIdArea = (BAreaView.getIdArea()== null)?regIDArea:BAreaView.getIdArea();
          	String strAccion = ""; 
          	String strIds_Borrar[] = null;
          
          	String retURI = strTmp + "?regIDArea=" + strIdArea;
          
          	strAccion = request.getParameter("accion");
          	strIds_Borrar = request.getParameterValues("Borrar");
          
          	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
          		bOperacion = ActualizaDestino.deleteDestino(strIds_Borrar,BUsuario.getIdUsuario()); 
          	}
          	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
          	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
          
          out.write(__oracle_jsp_text[11]);
          out.write(__oracle_jsp_text[12]);
          out.print(retURI );
          out.write(__oracle_jsp_text[13]);
           if(BUsuario.getSupervisor()){ 
          out.write(__oracle_jsp_text[14]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_1.setParent(null);
            __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
            __jsp_taghandler_1.setName("idArea");
            __jsp_taghandler_1.setSize(1);
            __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_1.setClassHtml("blue500a");
            __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='reload()'");
            __jsp_taghandler_1.setTextoNoSeleccion("---------- Selecciona un opción ----------");
            __jsp_taghandler_1.setValorNoSeleccion("");
            __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
            if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
          }
          out.write(__oracle_jsp_text[15]);
          }else{
          out.write(__oracle_jsp_text[16]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_2.setParent(null);
            __jsp_taghandler_2.setData(ComboData.getAreasCombo());
            __jsp_taghandler_2.setName("idArea");
            __jsp_taghandler_2.setSize(1);
            __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_2.setClassHtml("blue500a");
            __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='reload()'");
            __jsp_taghandler_2.setTextoNoSeleccion("---------- Selecciona un opción ----------");
            __jsp_taghandler_2.setValorNoSeleccion("");
            __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
            if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
          }
          out.write(__oracle_jsp_text[17]);
          }
          out.write(__oracle_jsp_text[18]);
          if(strIdArea.length() != 0){
          out.write(__oracle_jsp_text[19]);
           int j = 0; 
          out.write(__oracle_jsp_text[20]);
          {
            com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_3=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
            __jsp_taghandler_3.setParent(null);
            __jsp_taghandler_3.setDatos(ActualizaDestino.getDestinoPorArea(strIdArea, strOrden, strTipo));
            __jsp_taghandler_3.setCampo("Lista");
            java.lang.String Lista1 = null;
            java.lang.String Lista2 = null;
            java.lang.String Lista3 = null;
            java.lang.String Lista4 = null;
            java.lang.String Lista5 = null;
            java.lang.String Lista6 = null;
            java.lang.String Lista7 = null;
            java.lang.String Lista8 = null;
            java.lang.String Lista9 = null;
            java.lang.String Lista10 = null;
            java.lang.String Lista11 = null;
            java.lang.String Lista12 = null;
            java.lang.String Lista13 = null;
            java.lang.String Lista14 = null;
            java.lang.String Lista15 = null;
            java.lang.String Lista16 = null;
            java.lang.String Lista17 = null;
            java.lang.String Lista18 = null;
            java.lang.String Lista19 = null;
            java.lang.String Lista20 = null;
            __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
            if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
            {
              out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
              do {
                Lista1 = (java.lang.String) pageContext.findAttribute("Lista1");
                Lista2 = (java.lang.String) pageContext.findAttribute("Lista2");
                Lista3 = (java.lang.String) pageContext.findAttribute("Lista3");
                Lista4 = (java.lang.String) pageContext.findAttribute("Lista4");
                Lista5 = (java.lang.String) pageContext.findAttribute("Lista5");
                Lista6 = (java.lang.String) pageContext.findAttribute("Lista6");
                Lista7 = (java.lang.String) pageContext.findAttribute("Lista7");
                Lista8 = (java.lang.String) pageContext.findAttribute("Lista8");
                Lista9 = (java.lang.String) pageContext.findAttribute("Lista9");
                Lista10 = (java.lang.String) pageContext.findAttribute("Lista10");
                Lista11 = (java.lang.String) pageContext.findAttribute("Lista11");
                Lista12 = (java.lang.String) pageContext.findAttribute("Lista12");
                Lista13 = (java.lang.String) pageContext.findAttribute("Lista13");
                Lista14 = (java.lang.String) pageContext.findAttribute("Lista14");
                Lista15 = (java.lang.String) pageContext.findAttribute("Lista15");
                Lista16 = (java.lang.String) pageContext.findAttribute("Lista16");
                Lista17 = (java.lang.String) pageContext.findAttribute("Lista17");
                Lista18 = (java.lang.String) pageContext.findAttribute("Lista18");
                Lista19 = (java.lang.String) pageContext.findAttribute("Lista19");
                Lista20 = (java.lang.String) pageContext.findAttribute("Lista20");
                out.write(__oracle_jsp_text[21]);
                 if(	BUsuario.getAdmon() ||
                			BUsuario.getIdArea().equals(Lista4)){ 
                out.write(__oracle_jsp_text[22]);
                 t++; 
                out.write(__oracle_jsp_text[23]);
                if(par(t)==true){
                }else{
                out.write(__oracle_jsp_text[24]);
                }
                out.write(__oracle_jsp_text[25]);
                out.print(Lista1 );
                out.write(__oracle_jsp_text[26]);
                out.print(Lista1 );
                out.write(__oracle_jsp_text[27]);
                out.print(retURI );
                out.write(__oracle_jsp_text[28]);
                out.print(Lista2);
                out.write(__oracle_jsp_text[29]);
                out.print(Lista2);
                out.write(__oracle_jsp_text[30]);
                out.print(Lista5);
                out.write(__oracle_jsp_text[31]);
                out.print(Lista5);
                out.write(__oracle_jsp_text[32]);
                 j++; 
                out.write(__oracle_jsp_text[33]);
                 } 
                out.write(__oracle_jsp_text[34]);
              } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
            }
            if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
          }
          out.write(__oracle_jsp_text[35]);
           if(j == 0){ 
          out.write(__oracle_jsp_text[36]);
           } 
          out.write(__oracle_jsp_text[37]);
          }
          out.write(__oracle_jsp_text[38]);
        }
      }

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
  private static final char __oracle_jsp_text[][]=new char[39][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    " \n<HTML>\n<HEAD>\n<TITLE>Destinatarios Externos</TITLE>\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    " \n".toCharArray();
    __oracle_jsp_text[7] = 
    " \n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction reload() {\n\t\tdoc = document.DestExtView;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.submit();\n\t}\n\tfunction cambio(o, t){\n\t\tdoc = document.DestExtView;\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n\tfunction referenciaRet(retURI){\n\t\tlocation.assign(\"DestExt.jsp?retURI=\" + retURI.value);\n\t}\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load();\" onKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload();\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM action=\"DestExtView.jsp\" name=\"DestExtView\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"retURI\">\n\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"43%\"><A onClick=\"referenciaRet(document.DestExtView.retURI);\" target=\"_self\"> <IMG\n\t\t\t\theight=\"26\" src=\"../Imagenes/Nuevo.gif\" width=\"27\" border=\"0\"\n\t\t\t\talt=\"Nuevo Destino\"> </A> <FONT face=\"Tahoma\" size=\"2\"></FONT> <A\n\t\t\t\thref=\"javascript:Borrar()\" target=\"_self\"><IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/borrar2.gif\" width=\"30\" height=\"27\"\n\t\t\t\talt=\"Borrar Destino(s)\"></A></TD>\n\t\t\t<TD width=\"57%\">\n\t\t\t<DIV align=\"right\"> &nbsp; </DIV>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" bgcolor=\"#00204f\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE width=\"100%\">\n\t<TBODY>\n\t\t<TR>      \n\t\t\t<TD class=\"etiquetas\" align=\"right\" width=\"30%\"><b>Unidad Administrativa:</b></TD>\n\t\t\t<TD align=\"left\" width=\"70%\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<TABLE width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR bgcolor=\"#00204f\">\n\t\t\t<TD id=\"Asunto_HD\"  width=\"25%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Destinatario</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"25%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Direccion Electronica</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body><BR>\n".toCharArray();
    __oracle_jsp_text[19] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"> \n\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t<TR valign=\"top\" ".toCharArray();
    __oracle_jsp_text[24] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[25] = 
    ">\n\t\t\t<TD width=\"100%\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"50%\"><INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\"\n\t\t\t\t\t\tname=\"Borrar\"><FONT face=Arial color=#000080 size=1> <A href=\"DestExt.jsp?accion=consultar&id_usuario=".toCharArray();
    __oracle_jsp_text[27] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[28] = 
    "\"\n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[29] = 
    "\"><script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[30] = 
    "','Asunto_HD'));</script></A>\n\t\t\t\t\t</FONT></td>\n\t\t\t\t\t<td align=\"center\" width=\"50%\">\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\"><script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[32] = 
    "','Asunto_HD'));</script></a>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No Hay Destinos\n\t\t\tCapturados de su Unidad Administrativa******</FONT></div>\n\t\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[38] = 
    "\n<br>\n</DIV>\n\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<BR>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
