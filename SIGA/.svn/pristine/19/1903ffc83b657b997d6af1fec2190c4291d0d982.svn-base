package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.util.Utilerias;
import com.meve.sigma.util.Converters;


public class _estructuraOrganizacional extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html");
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
    _estructuraOrganizacional page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      com.meve.sigma.beans.UsuarioBean UsuarioBean;
      synchronized (session) {
        if ((UsuarioBean = (com.meve.sigma.beans.UsuarioBean) pageContext.getAttribute( "UsuarioBean", PageContext.SESSION_SCOPE)) == null) {
          UsuarioBean = (com.meve.sigma.beans.UsuarioBean) new com.meve.sigma.beans.UsuarioBean();
          pageContext.setAttribute( "UsuarioBean", UsuarioBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[6]);
      java.util.List areas;
      synchronized (session) {
        if ((areas = (java.util.List) pageContext.getAttribute( "areas", PageContext.SESSION_SCOPE)) == null) {
          areas = (java.util.List) new java.util.ArrayList();
          pageContext.setAttribute( "areas", areas, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[7]);
      com.meve.sigma.organizacional.vo.AreaVO area;
      synchronized (session) {
        if ((area = (com.meve.sigma.organizacional.vo.AreaVO) pageContext.getAttribute( "area", PageContext.SESSION_SCOPE)) == null) {
          area = (com.meve.sigma.organizacional.vo.AreaVO) new com.meve.sigma.organizacional.vo.AreaVO();
          pageContext.setAttribute( "area", area, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[8]);
      {
        String __url=OracleJspRuntime.toStr("headerSIGA.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[9]);
      
      	String strTmp = request.getRequestURI();
      	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
      			.length());
      	if (UsuarioBean == null) {
      		try {
      			response.sendRedirect("index.jsp?pagina=" + strTmp);
      		} catch (java.io.IOException io) {
      		}
      	}
      
      out.write(__oracle_jsp_text[10]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("estructuraOrganizacional");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[11]);
            
            	if (UsuarioBean.getAdmon()) {
            	
            out.write(__oracle_jsp_text[12]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_2=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag onchange property styleClass");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setOnchange("submitForm(estructuraOrganizacionalForm,'mostrar',this.value);return false;");
              __jsp_taghandler_2.setProperty("idArea");
              __jsp_taghandler_2.setStyleClass("blue500a");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[13]);
                  {
                    org.apache.struts.taglib.html.OptionTag __jsp_taghandler_3=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setValue("-1");
                    __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[14]);
                      } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,3);
                  }
                  out.write(__oracle_jsp_text[15]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_4=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name type");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_4.setId("registro");
                    __jsp_taghandler_4.setName("areas");
                    __jsp_taghandler_4.setType("com.meve.sigma.organizacional.vo.AreaVO");
                    com.meve.sigma.organizacional.vo.AreaVO registro = null;
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
                      do {
                        registro = (com.meve.sigma.organizacional.vo.AreaVO) pageContext.findAttribute("registro");
                        out.write(__oracle_jsp_text[16]);
                        {
                          org.apache.struts.taglib.html.OptionTag __jsp_taghandler_5=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                          __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                          __jsp_taghandler_5.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.idArea}",java.lang.String.class, __ojsp_varRes,null));
                          __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_5,__jsp_tag_starteval,out);
                            do {
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.nombreHTML}",java.lang.String.class, __ojsp_varRes, null));
                            } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,4);
                        }
                        out.write(__oracle_jsp_text[17]);
                      } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[18]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[19]);
            
            	}
            	
            out.write(__oracle_jsp_text[20]);
             if (UsuarioBean.getAdmon() || UsuarioBean.getSupervisor()){ 
            out.write(__oracle_jsp_text[21]);
            	} 
            out.write(__oracle_jsp_text[22]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${estructuraOrganizacionalForm.areaNombre}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[23]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${estructuraOrganizacionalForm.responsableNombre}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[24]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${estructuraOrganizacionalForm.cargoNombre}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[25]);
            out.print(Converters.convertElementToString(area.getOrganigramaPrincipalHTML(null)));
            out.write(__oracle_jsp_text[26]);
            out.print(Converters.convertElementToString(area.getOrganigramaSinRelacionHTML(null)));
            out.write(__oracle_jsp_text[27]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[28]);

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
  private static final char __oracle_jsp_text[][]=new char[29][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Puestos</TITLE>\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/link.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"./js/SigaJS.js\"></script>\n<script type=\"text/javascript\" src=\"./js/ajax.js\"></script>\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t<input type=\"hidden\" value=\"\" name=\"accion\" />\n\t<input type=\"hidden\" value=\"\" name=\"idLink\" />\n\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t<DIV align=\"center\">\n\t<TABLE border=\"0\" >\n\t\t<TR>\n\t\t\t<TD align=\"center\" width=\"500\"><b>Unidad Administrativa</b></TD>\n\t\t</TR>\n\t\t<TR align=\"center\">\n\t\t\t<TD align=\"center\" width=\"500\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[14] = 
    "------------- Seleccione una Unidad Administrativa ------------- ".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "</TD>\n\t\t</TR>\n\t</TABLE>\n\t</DIV>\n\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t<DIV align=\"center\">\n\t<TABLE border=\"0\" width=\"70%\">\n\t\t<TBODY>\n\t\t\t<TR valign=\"middle\">\n\t\t\t\t<TD class=\"etiquetas1v\" align=\"left\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t<A href=\"./puesto.siga?accion=nuevoPuesto&idLink=mostrar\"  target=\"_self\"> \n\t\t\t\t<IMG height=\"26\" src=\"./Imagenes/nuevo1.gif\" width=\"27\" border=\"0\" alt=\"Nuevo Puesto\"> \n\t\t\t\t</A> \n\t\t\t    <A href=\"javascript:;\" onclick=\"submitForm(estructuraOrganizacionalForm,'mostrarPorRoles','2');return false;\" target=\"_self\"> \n\t\t\t\t<IMG height=\"26\" src=\"./Imagenes/mostrarPorRoles.gif\" width=\"27\" border=\"0\" alt=\"Mostrar Puestos por Roles\"> \n\t\t\t\t</A> \n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t<B><FONT size=\"+1\">&nbsp;&nbsp;Puestos</FONT></B></TD>\n\t\t\t\t<TD align=\"right\">\n\t\t\t\t   <TABLE ><TR>\n\t\t              <TD><B>Busqueda</B></TD>\n\t\t              <TD><input type=\"text\" class=\"blue200a\" id=\"busqueda\" onkeyup=\"cargaUrl('./EstructuraOrganizacionalAjax?accion=buscar&cadena=',this.value,muestraUsuarios);\"></TD>\n\t\t           </TR></TABLE>\n\t\t           <div id=\"divUsuarios\" style=\"display: none; position: absolute\"></div>\n\t\t        </TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"middle\">\n\t\t\t\t<td bgcolor=\"#004080\" colspan=\"2\"><img src=\"../Imagenes/shim.gif\" width=\"1\" \n\t\t\t\t\theight=\"2\" alt=\"\"></td>\n\t\t\t</TR>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\n\t<DIV align=\"center\">\n\t<TABLE border=\"0\" width=\"70%\">\n\t\t<tr bgcolor=\"#004080\">\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetasTit\"><B>Responsable\n\t\t\tde la Unidad Administrativa: ".toCharArray();
    __oracle_jsp_text[23] = 
    "</B></TD>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<TD align=\"left\" width=\"696\" class=\"etiquetas\"><A\n\t\t\t\thref=\"javascript:;\"\n\t\t\t\tclass=\"etiquetas\"\n\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\"><B><U>\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "</U></B></A></TD>\n\t\t</tr>\n\t\t<TR>\n\t\t\t<TD>&nbsp;</TD>\n\t\t</TR>\n\n\t\t<tr>\n\t\t\t<TD align=\"left\" class=\"etiquetas\">\n\t\t\t<FIELDSET dir=\"ltr\" class=\"bluethinBorder\"><LEGEND align=\"left\"><FONT\n\t\t\t\t\tSIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Organigrama\n\t\t\tde la Unidad</B></FONT></LEGEND> \n\t\t\t   <div id=\"orgPrincipal\">\n\t\t\t      ".toCharArray();
    __oracle_jsp_text[26] = 
    "</div>\n\t\t\t </FIELDSET> \n\t\t\t</TD>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<TD align=\"left\" class=\"etiquetas\">\n\t\t\t<FIELDSET dir=\"ltr\" class=\"bluethinBorder\" ><LEGEND align=\"left\"><FONT\n\t\t\t\t\tSIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Puestos\n\t\t\tde la Unidad sin relación al Organigrama principal</B></FONT></LEGEND> \n\t\t\t<div id=\"orgNoRelacionado\">\n\t\t\t<DL><DT>".toCharArray();
    __oracle_jsp_text[27] = 
    "</DT></DL></div>\n\t\t\t</FIELDSET>\n\t\t\t</TD>\n\t\t</tr>\n\t</TABLE>\n\t</DIV>\n".toCharArray();
    __oracle_jsp_text[28] = 
    "\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
