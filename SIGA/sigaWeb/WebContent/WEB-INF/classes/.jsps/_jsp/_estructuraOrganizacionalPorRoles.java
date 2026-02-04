package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.util.Utilerias;
import com.meve.sigma.catalogos.CatalogoRol;
import com.meve.sigma.catalogos.CatalogoUtil;
import com.meve.util.ManejadorDeTablas;


public class _estructuraOrganizacionalPorRoles extends com.orionserver.http.OrionHttpJspPage {


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
    _estructuraOrganizacionalPorRoles page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      out.write(__oracle_jsp_text[8]);
      com.meve.sigma.beans.UsuarioBean UsuarioBean;
      synchronized (session) {
        if ((UsuarioBean = (com.meve.sigma.beans.UsuarioBean) pageContext.getAttribute( "UsuarioBean", PageContext.SESSION_SCOPE)) == null) {
          UsuarioBean = (com.meve.sigma.beans.UsuarioBean) new com.meve.sigma.beans.UsuarioBean();
          pageContext.setAttribute( "UsuarioBean", UsuarioBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[9]);
      java.util.List catalogoRol;
      synchronized (application) {
        if ((catalogoRol = (java.util.List) pageContext.getAttribute( "catalogoRol", PageContext.APPLICATION_SCOPE)) == null) {
          catalogoRol = (java.util.List) new java.util.ArrayList();
          pageContext.setAttribute( "catalogoRol", catalogoRol, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[10]);
      java.util.List areas;
      synchronized (session) {
        if ((areas = (java.util.List) pageContext.getAttribute( "areas", PageContext.SESSION_SCOPE)) == null) {
          areas = (java.util.List) new java.util.ArrayList();
          pageContext.setAttribute( "areas", areas, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[11]);
      com.meve.sigma.organizacional.vo.AreaVO area;
      synchronized (session) {
        if ((area = (com.meve.sigma.organizacional.vo.AreaVO) pageContext.getAttribute( "area", PageContext.SESSION_SCOPE)) == null) {
          area = (com.meve.sigma.organizacional.vo.AreaVO) new com.meve.sigma.organizacional.vo.AreaVO();
          pageContext.setAttribute( "area", area, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[12]);
      {
        String __url=OracleJspRuntime.toStr("headerSIGA.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[13]);
      
      	String strTmp = request.getRequestURI();
      	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
      			.length());
      	if (UsuarioBean == null) {
      		try {
      			response.sendRedirect("index.jsp?pagina=" + strTmp);
      		} catch (java.io.IOException io) {
      		}
      	}
      
      out.write(__oracle_jsp_text[14]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("estructuraOrganizacional");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[15]);
            
            	if (UsuarioBean.getAdmon()) {
            	
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_2=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag onchange property styleClass");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setOnchange("submitForm(estructuraOrganizacionalForm,'mostrarPorRoles','');return false;");
              __jsp_taghandler_2.setProperty("idArea");
              __jsp_taghandler_2.setStyleClass("blue500a");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[17]);
                  {
                    org.apache.struts.taglib.html.OptionTag __jsp_taghandler_3=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setValue("-1");
                    __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[18]);
                      } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,3);
                  }
                  out.write(__oracle_jsp_text[19]);
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
                        out.write(__oracle_jsp_text[20]);
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
                        out.write(__oracle_jsp_text[21]);
                      } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[22]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[23]);
            }
            out.write(__oracle_jsp_text[24]);
            {
              org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_6=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name type");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setId("rol");
              __jsp_taghandler_6.setIndexId("idx");
              __jsp_taghandler_6.setName("catalogoRol");
              __jsp_taghandler_6.setType("com.meve.sigma.catalogos.CatalogoRol");
              com.meve.sigma.catalogos.CatalogoRol rol = null;
              java.lang.Integer idx = null;
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_6,__jsp_tag_starteval,out);
                do {
                  rol = (com.meve.sigma.catalogos.CatalogoRol) pageContext.findAttribute("rol");
                  idx = (java.lang.Integer) pageContext.findAttribute("idx");
                  out.write(__oracle_jsp_text[25]);
                  ManejadorDeTablas tableManager = (ManejadorDeTablas)session.getAttribute(ManejadorDeTablas.TABLE_MANAGER+"_"+rol.getId()); 
                  out.write(__oracle_jsp_text[26]);
                  {
                    org.apache.struts.taglib.logic.NotEmptyTag __jsp_taghandler_7=(org.apache.struts.taglib.logic.NotEmptyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEmptyTag.class,"org.apache.struts.taglib.logic.NotEmptyTag name property scope");
                    __jsp_taghandler_7.setParent(__jsp_taghandler_6);
                    __jsp_taghandler_7.setName((java.lang.String) ("tableManager_"+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rol.id}",java.lang.String.class, __ojsp_varRes, null)));
                    __jsp_taghandler_7.setProperty("registros");
                    __jsp_taghandler_7.setScope("session");
                    __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[27]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rol.id}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[28]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rol.id}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[29]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rol.nombre}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[30]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rol.id}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[31]);
                        {
                          _oracle._jsp._tag._sortedHeader_tag __jsp_taghandler_8=(_oracle._jsp._tag._sortedHeader_tag)OracleJspRuntime.getSimpleTagHandler(_oracle._jsp._tag._sortedHeader_tag.class, pageContext);
                          __jsp_taghandler_8.setParent(__jsp_taghandler_7);
                          __jsp_taghandler_8.setJspContext(pageContext);
                          __jsp_taghandler_8.setId("0");
                          __jsp_taghandler_8.setKey("Puesto");
                          __jsp_taghandler_8.setForm("estructuraOrganizacionalForm");
                          __jsp_taghandler_8.setOrden(OracleJspRuntime.toStr( tableManager.getOrden(0)));
                          __jsp_taghandler_8.doTag();
                          OracleJspRuntime.simpleReleaseTagHandler(__jsp_taghandler_8, pageContext);
                        }
                        out.write(__oracle_jsp_text[32]);
                        {
                          _oracle._jsp._tag._sortedHeader_tag __jsp_taghandler_9=(_oracle._jsp._tag._sortedHeader_tag)OracleJspRuntime.getSimpleTagHandler(_oracle._jsp._tag._sortedHeader_tag.class, pageContext);
                          __jsp_taghandler_9.setParent(__jsp_taghandler_7);
                          __jsp_taghandler_9.setJspContext(pageContext);
                          __jsp_taghandler_9.setId("1");
                          __jsp_taghandler_9.setKey("Responsable");
                          __jsp_taghandler_9.setForm("estructuraOrganizacionalForm");
                          __jsp_taghandler_9.setOrden(OracleJspRuntime.toStr( tableManager.getOrden(1)));
                          __jsp_taghandler_9.doTag();
                          OracleJspRuntime.simpleReleaseTagHandler(__jsp_taghandler_9, pageContext);
                        }
                        out.write(__oracle_jsp_text[33]);
                        {
                          org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_10=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id indexId name property scope type");
                          __jsp_taghandler_10.setParent(__jsp_taghandler_7);
                          __jsp_taghandler_10.setId("registro");
                          __jsp_taghandler_10.setIndexId("contador");
                          __jsp_taghandler_10.setName((java.lang.String) ("tableManager_"+ (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${rol.id}",java.lang.String.class, __ojsp_varRes, null)));
                          __jsp_taghandler_10.setProperty("registrosPaginaActual");
                          __jsp_taghandler_10.setScope("session");
                          __jsp_taghandler_10.setType("com.meve.sigma.organizacional.vo.PuestoVO");
                          com.meve.sigma.organizacional.vo.PuestoVO registro = null;
                          java.lang.Integer contador = null;
                          __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_10,__jsp_tag_starteval,out);
                            do {
                              registro = (com.meve.sigma.organizacional.vo.PuestoVO) pageContext.findAttribute("registro");
                              contador = (java.lang.Integer) pageContext.findAttribute("contador");
                              out.write(__oracle_jsp_text[34]);
                              if((contador.intValue()%2)==0){
                              out.write(__oracle_jsp_text[35]);
                              }
                              out.write(__oracle_jsp_text[36]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.idUsuario}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[37]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.cargo}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[38]);
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.nombre}",java.lang.String.class, __ojsp_varRes, null));
                              out.write(__oracle_jsp_text[39]);
                            } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,4);
                        }
                        out.write(__oracle_jsp_text[40]);
                        out.print(tableManager.getPaginacionHTML("estructuraOrganizacionalForm"));
                        out.write(__oracle_jsp_text[41]);
                      } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,3);
                  }
                  out.write(__oracle_jsp_text[42]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[43]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[44]);

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
  private static final char __oracle_jsp_text[][]=new char[45][];
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
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Puestos</TITLE>\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/link.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"./js/SigaJS.js\"></script>\n<script type=\"text/javascript\" src=\"./js/estructuraOrganizacional.js\"></script>\n<script type=\"text/javascript\" src=\"./js/ajax.js\"></script>\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n<BODY background=\"../Imagenes/fondo_claro.jpg\">\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n\t<input type=\"hidden\" value=\"\" name=\"accion\" />\n\t<input type=\"hidden\" value=\"\" name=\"idLink\" />\n\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t<DIV align=\"center\">\n\t<TABLE border=\"0\">\n\t\t<TR>\n\t\t\t<TD align=\"center\" width=\"500\"><b>Unidad Administrativa</b></TD>\n\t\t</TR>\n\t\t<TR align=\"center\">\n\t\t\t<TD align=\"center\" width=\"500\">".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "------------- Seleccione una Unidad Administrativa ------------- ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "</TD>\n\t\t</TR>\n\t</TABLE>\n\t</DIV>\n\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n  <TABLE width=\"900\" align=\"center\">\n   ".toCharArray();
    __oracle_jsp_text[25] = 
    "\n   ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n      ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n      <TR><TD width=\"900\">\n        <a onclick=\"muestraOcultaRoles('".toCharArray();
    __oracle_jsp_text[28] = 
    "');return false;\">\n           <img src=\"./Imagenes/expand.gif\" border=\"0\" height=\"16\" width=\"16\" id=\"img_".toCharArray();
    __oracle_jsp_text[29] = 
    "\" >".toCharArray();
    __oracle_jsp_text[30] = 
    "\n        </a>\n      <div id=\"div_".toCharArray();
    __oracle_jsp_text[31] = 
    "\" style=\"display: none;\">\n       <TABLE width=\"100%\" border=\"0\">\n\t\t   <TR bgcolor=\"#00204f\">\n\t\t\t <TD width=\"50%\" align=\"center\">\n\t\t\t   ".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"50%\" align=\"center\">\n\t\t\t  ".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t    </TD>\n\t\t  </TR>\n       </TABLE>\n       <TABLE width=\"100%\" align=\"center\" border=\"0\">\n\t   ".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t <tr ".toCharArray();
    __oracle_jsp_text[35] = 
    "bgcolor=\"#D6F6FF\"".toCharArray();
    __oracle_jsp_text[36] = 
    ">\n\t\t\t<td WIDTH='50%'><A href = \"./puesto.siga?accion=mostrarPuesto&idLink=".toCharArray();
    __oracle_jsp_text[37] = 
    "\">".toCharArray();
    __oracle_jsp_text[38] = 
    "</a></td>\n\t\t\t<td WIDTH='50%'>".toCharArray();
    __oracle_jsp_text[39] = 
    "</td>\n\t\t </tr>\n\t   ".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t     <tr><td colspan=\"6\">\n\t\t   <TABLE align=\"center\">\n\t\t\t <tr>".toCharArray();
    __oracle_jsp_text[41] = 
    "</tr>\n\t\t   </TABLE>\n\t\t</td></tr>\n      </TABLE>\n    </div>\n    </TD></TR>\n   ".toCharArray();
    __oracle_jsp_text[42] = 
    "   \n   ".toCharArray();
    __oracle_jsp_text[43] = 
    "\n   </TABLE>\n".toCharArray();
    __oracle_jsp_text[44] = 
    "\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
