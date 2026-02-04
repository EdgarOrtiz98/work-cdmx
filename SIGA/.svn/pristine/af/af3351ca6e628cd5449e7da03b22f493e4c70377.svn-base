package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.UsuarioBean;
import java.util.Date;
import com.meve.util.DateFormatter;


public class _puestoEdicion extends com.orionserver.http.OrionHttpJspPage {


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
    _puestoEdicion page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      {
        String __url=OracleJspRuntime.toStr("headerSIGAConf.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[4]);
      out.write(__oracle_jsp_text[5]);
      out.write(__oracle_jsp_text[6]);
      out.write(__oracle_jsp_text[7]);
      out.write(__oracle_jsp_text[8]);
      
      			UsuarioBean usuario = (UsuarioBean) session
      			.getAttribute("UsuarioBean");
      	String strTmp = request.getRequestURI();
      	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
      			.length());
      	if (usuario == null) {
      		try {
      			response.sendRedirect("index.jsp?pagina=" + strTmp);
      		} catch (java.io.IOException io) {
      		}
      	}
      
      out.write(__oracle_jsp_text[9]);
      com.meve.sigma.organizacional.puesto.PuestoForm puestoForm;
      synchronized (session) {
        if ((puestoForm = (com.meve.sigma.organizacional.puesto.PuestoForm) pageContext.getAttribute( "puestoForm", PageContext.SESSION_SCOPE)) == null) {
          puestoForm = (com.meve.sigma.organizacional.puesto.PuestoForm) new com.meve.sigma.organizacional.puesto.PuestoForm();
          pageContext.setAttribute( "puestoForm", puestoForm, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[10]);
      out.print(puestoForm.getChecksAsistentes());
      out.write(__oracle_jsp_text[11]);
      out.print(puestoForm.getChecksRoles());
      out.write(__oracle_jsp_text[12]);
      {
        org.apache.struts.taglib.html.FormTag __jsp_taghandler_1=(org.apache.struts.taglib.html.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.FormTag.class,"org.apache.struts.taglib.html.FormTag action");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("puesto");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[13]);
            out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${puestoForm.accion}",java.lang.String.class, __ojsp_varRes, null));
            out.write(__oracle_jsp_text[14]);
            out.print(usuario.getCargo());
            out.write(__oracle_jsp_text[15]);
            out.print(DateFormatter.getFecha(new Date().getTime()) );
            out.write(__oracle_jsp_text[16]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_2=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setMaxlength("20");
              __jsp_taghandler_2.setProperty("usuario");
              __jsp_taghandler_2.setSize("50");
              __jsp_taghandler_2.setStyleClass("blue600a");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[17]);
            {
              org.apache.struts.taglib.html.PasswordTag __jsp_taghandler_3=(org.apache.struts.taglib.html.PasswordTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.PasswordTag.class,"org.apache.struts.taglib.html.PasswordTag maxlength property styleClass size");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_taghandler_3.setMaxlength("15");
              __jsp_taghandler_3.setProperty("password");
              __jsp_taghandler_3.setStyleClass("blue600a");
              __jsp_taghandler_3.setSize("50");
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[18]);
            
            		if (false) {
            		
            out.write(__oracle_jsp_text[19]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_4=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag property styleClass");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setProperty("usuarioLdap");
              __jsp_taghandler_4.setStyleClass("blue500a");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[20]);
                  {
                    org.apache.struts.taglib.html.OptionTag __jsp_taghandler_5=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                    __jsp_taghandler_5.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_5.setValue("-1");
                    __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_5,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[21]);
                      } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,3);
                  }
                  out.write(__oracle_jsp_text[22]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_6=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name type");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_4);
                    __jsp_taghandler_6.setId("registro");
                    __jsp_taghandler_6.setName("puestosLdap");
                    __jsp_taghandler_6.setType("java.lang.String");
                    java.lang.String registro = null;
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_6,__jsp_tag_starteval,out);
                      do {
                        registro = (java.lang.String) pageContext.findAttribute("registro");
                        out.write(__oracle_jsp_text[23]);
                        {
                          org.apache.struts.taglib.html.OptionTag __jsp_taghandler_7=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                          __jsp_taghandler_7.setParent(__jsp_taghandler_6);
                          __jsp_taghandler_7.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro}",java.lang.String.class, __ojsp_varRes,null));
                          __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_7,__jsp_tag_starteval,out);
                            do {
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro}",java.lang.String.class, __ojsp_varRes, null));
                            } while (__jsp_taghandler_7.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,4);
                        }
                        out.write(__oracle_jsp_text[24]);
                      } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[25]);
                } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[26]);
            
            		}
            		
            out.write(__oracle_jsp_text[27]);
            {
              org.apache.struts.taglib.html.SelectTag __jsp_taghandler_8=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag onchange property styleClass");
              __jsp_taghandler_8.setParent(__jsp_taghandler_1);
              __jsp_taghandler_8.setOnchange("submitForm(puestoForm,'nuevoPuesto','seleccionaArea');return false;");
              __jsp_taghandler_8.setProperty("idUnidadAdministrativa");
              __jsp_taghandler_8.setStyleClass("blue500a");
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_8,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[28]);
                  {
                    org.apache.struts.taglib.html.OptionTag __jsp_taghandler_9=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                    __jsp_taghandler_9.setParent(__jsp_taghandler_8);
                    __jsp_taghandler_9.setValue("-1");
                    __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_9,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[29]);
                      } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                  }
                  out.write(__oracle_jsp_text[30]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_10=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name type");
                    __jsp_taghandler_10.setParent(__jsp_taghandler_8);
                    __jsp_taghandler_10.setId("registro");
                    __jsp_taghandler_10.setName("areas");
                    __jsp_taghandler_10.setType("com.meve.sigma.organizacional.vo.AreaVO");
                    com.meve.sigma.organizacional.vo.AreaVO registro = null;
                    __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_10,__jsp_tag_starteval,out);
                      do {
                        registro = (com.meve.sigma.organizacional.vo.AreaVO) pageContext.findAttribute("registro");
                        out.write(__oracle_jsp_text[31]);
                        {
                          org.apache.struts.taglib.html.OptionTag __jsp_taghandler_11=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                          __jsp_taghandler_11.setParent(__jsp_taghandler_10);
                          __jsp_taghandler_11.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.idArea}",java.lang.String.class, __ojsp_varRes,null));
                          __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_11,__jsp_tag_starteval,out);
                            do {
                              out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.nombreHTML}",java.lang.String.class, __ojsp_varRes, null));
                            } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,4);
                        }
                        out.write(__oracle_jsp_text[32]);
                      } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,3);
                  }
                  out.write(__oracle_jsp_text[33]);
                } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[34]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_12=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
              __jsp_taghandler_12.setParent(__jsp_taghandler_1);
              __jsp_taghandler_12.setMaxlength("199");
              __jsp_taghandler_12.setProperty("puesto");
              __jsp_taghandler_12.setSize("50");
              __jsp_taghandler_12.setStyleClass("blue600a");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[35]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_13=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
              __jsp_taghandler_13.setParent(__jsp_taghandler_1);
              __jsp_taghandler_13.setMaxlength("199");
              __jsp_taghandler_13.setProperty("responsable");
              __jsp_taghandler_13.setSize("50");
              __jsp_taghandler_13.setStyleClass("blue600a");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[36]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_14=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
              __jsp_taghandler_14.setParent(__jsp_taghandler_1);
              __jsp_taghandler_14.setMaxlength("100");
              __jsp_taghandler_14.setProperty("correo");
              __jsp_taghandler_14.setSize("50");
              __jsp_taghandler_14.setStyleClass("blue600a");
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[37]);
            {
              org.apache.struts.taglib.html.TextTag __jsp_taghandler_15=(org.apache.struts.taglib.html.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.TextTag.class,"org.apache.struts.taglib.html.TextTag maxlength property size styleClass");
              __jsp_taghandler_15.setParent(__jsp_taghandler_1);
              __jsp_taghandler_15.setMaxlength("199");
              __jsp_taghandler_15.setProperty("telefono");
              __jsp_taghandler_15.setSize("100");
              __jsp_taghandler_15.setStyleClass("blue600a");
              __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
              if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
            }
            out.write(__oracle_jsp_text[38]);
            {
              org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_16=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
              __jsp_taghandler_16.setParent(__jsp_taghandler_1);
              __jsp_taghandler_16.setName("puestoForm");
              __jsp_taghandler_16.setProperty("idUnidadAdministrativa");
              __jsp_taghandler_16.setValue("-1");
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[39]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_17=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag property styleClass");
                    __jsp_taghandler_17.setParent(__jsp_taghandler_16);
                    __jsp_taghandler_17.setProperty("idJefe");
                    __jsp_taghandler_17.setStyleClass("blue600a");
                    __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_17,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[40]);
                        {
                          org.apache.struts.taglib.html.OptionTag __jsp_taghandler_18=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                          __jsp_taghandler_18.setParent(__jsp_taghandler_17);
                          __jsp_taghandler_18.setValue("-1");
                          __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_18,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[41]);
                            } while (__jsp_taghandler_18.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,4);
                        }
                        out.write(__oracle_jsp_text[42]);
                        {
                          org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_19=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name type");
                          __jsp_taghandler_19.setParent(__jsp_taghandler_17);
                          __jsp_taghandler_19.setId("registro");
                          __jsp_taghandler_19.setName("puestosPadre");
                          __jsp_taghandler_19.setType("com.meve.sigma.organizacional.vo.PuestoVO");
                          com.meve.sigma.organizacional.vo.PuestoVO registro = null;
                          __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_19,__jsp_tag_starteval,out);
                            do {
                              registro = (com.meve.sigma.organizacional.vo.PuestoVO) pageContext.findAttribute("registro");
                              out.write(__oracle_jsp_text[43]);
                              {
                                org.apache.struts.taglib.html.OptionTag __jsp_taghandler_20=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                                __jsp_taghandler_20.setParent(__jsp_taghandler_19);
                                __jsp_taghandler_20.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.idUsuario}",java.lang.String.class, __ojsp_varRes,null));
                                __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_20,__jsp_tag_starteval,out);
                                  do {
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.nombre}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[44]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.cargo}",java.lang.String.class, __ojsp_varRes, null));
                                  } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,5);
                              }
                              out.write(__oracle_jsp_text[45]);
                            } while (__jsp_taghandler_19.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,4);
                        }
                        out.write(__oracle_jsp_text[46]);
                        {
                          org.apache.struts.taglib.html.OptionTag __jsp_taghandler_21=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                          __jsp_taghandler_21.setParent(__jsp_taghandler_17);
                          __jsp_taghandler_21.setValue("-1");
                          __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_21,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[47]);
                            } while (__jsp_taghandler_21.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,4);
                        }
                        out.write(__oracle_jsp_text[48]);
                        {
                          org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_22=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name type");
                          __jsp_taghandler_22.setParent(__jsp_taghandler_17);
                          __jsp_taghandler_22.setId("registro");
                          __jsp_taghandler_22.setName("puestos");
                          __jsp_taghandler_22.setType("com.meve.sigma.organizacional.vo.PuestoVO");
                          com.meve.sigma.organizacional.vo.PuestoVO registro = null;
                          __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_22,__jsp_tag_starteval,out);
                            do {
                              registro = (com.meve.sigma.organizacional.vo.PuestoVO) pageContext.findAttribute("registro");
                              out.write(__oracle_jsp_text[49]);
                              {
                                org.apache.struts.taglib.html.OptionTag __jsp_taghandler_23=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                                __jsp_taghandler_23.setParent(__jsp_taghandler_22);
                                __jsp_taghandler_23.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.idUsuario}",java.lang.String.class, __ojsp_varRes,null));
                                __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_23,__jsp_tag_starteval,out);
                                  do {
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.nombre}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[50]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.cargo}",java.lang.String.class, __ojsp_varRes, null));
                                  } while (__jsp_taghandler_23.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,5);
                              }
                              out.write(__oracle_jsp_text[51]);
                            } while (__jsp_taghandler_22.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,4);
                        }
                        out.write(__oracle_jsp_text[52]);
                      } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,3);
                  }
                  out.write(__oracle_jsp_text[53]);
                  if (false) {
                  out.write(__oracle_jsp_text[54]);
                  out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${puestoForm.jefe}",java.lang.String.class, __ojsp_varRes, null));
                  out.write(__oracle_jsp_text[55]);
                  
                  			}
                  			
                  out.write(__oracle_jsp_text[56]);
                  
                  				if (true) {
                  				
                  out.write(__oracle_jsp_text[57]);
                  {
                    org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_24=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name property type");
                    __jsp_taghandler_24.setParent(__jsp_taghandler_16);
                    __jsp_taghandler_24.setId("asistente");
                    __jsp_taghandler_24.setName("puestoForm");
                    __jsp_taghandler_24.setProperty("asistentes");
                    __jsp_taghandler_24.setType("com.meve.sigma.organizacional.vo.AsistenteVO");
                    com.meve.sigma.organizacional.vo.AsistenteVO asistente = null;
                    __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_24,__jsp_tag_starteval,out);
                      do {
                        asistente = (com.meve.sigma.organizacional.vo.AsistenteVO) pageContext.findAttribute("asistente");
                        out.write(__oracle_jsp_text[58]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asistente.idUsuario}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[59]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asistente.nombre}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[60]);
                        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asistente.cargo}",java.lang.String.class, __ojsp_varRes, null));
                        out.write(__oracle_jsp_text[61]);
                      } while (__jsp_taghandler_24.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,3);
                  }
                  out.write(__oracle_jsp_text[62]);
                  
                  				}
                  				
                  out.write(__oracle_jsp_text[63]);
                  {
                    org.apache.struts.taglib.html.SelectTag __jsp_taghandler_25=(org.apache.struts.taglib.html.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.SelectTag.class,"org.apache.struts.taglib.html.SelectTag property styleClass");
                    __jsp_taghandler_25.setParent(__jsp_taghandler_16);
                    __jsp_taghandler_25.setProperty("idSubventanilla");
                    __jsp_taghandler_25.setStyleClass("blue600a");
                    __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
                    if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                    {
                      out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_25,__jsp_tag_starteval,out);
                      do {
                        out.write(__oracle_jsp_text[64]);
                        {
                          org.apache.struts.taglib.html.OptionTag __jsp_taghandler_26=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                          __jsp_taghandler_26.setParent(__jsp_taghandler_25);
                          __jsp_taghandler_26.setValue("0");
                          __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_26,__jsp_tag_starteval,out);
                            do {
                              out.write(__oracle_jsp_text[65]);
                            } while (__jsp_taghandler_26.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,4);
                        }
                        out.write(__oracle_jsp_text[66]);
                        {
                          org.apache.struts.taglib.logic.IterateTag __jsp_taghandler_27=(org.apache.struts.taglib.logic.IterateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.IterateTag.class,"org.apache.struts.taglib.logic.IterateTag id name type");
                          __jsp_taghandler_27.setParent(__jsp_taghandler_25);
                          __jsp_taghandler_27.setId("registro");
                          __jsp_taghandler_27.setName("puestosAtencion");
                          __jsp_taghandler_27.setType("com.meve.sigma.organizacional.vo.PuestoVO");
                          com.meve.sigma.organizacional.vo.PuestoVO registro = null;
                          __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
                          if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                          {
                            out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_27,__jsp_tag_starteval,out);
                            do {
                              registro = (com.meve.sigma.organizacional.vo.PuestoVO) pageContext.findAttribute("registro");
                              out.write(__oracle_jsp_text[67]);
                              {
                                org.apache.struts.taglib.html.OptionTag __jsp_taghandler_28=(org.apache.struts.taglib.html.OptionTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.html.OptionTag.class,"org.apache.struts.taglib.html.OptionTag value");
                                __jsp_taghandler_28.setParent(__jsp_taghandler_27);
                                __jsp_taghandler_28.setValue((java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.idUsuario}",java.lang.String.class, __ojsp_varRes,null));
                                __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
                                if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
                                {
                                  out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_28,__jsp_tag_starteval,out);
                                  do {
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.nombre}",java.lang.String.class, __ojsp_varRes, null));
                                    out.write(__oracle_jsp_text[68]);
                                    out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro.cargo}",java.lang.String.class, __ojsp_varRes, null));
                                  } while (__jsp_taghandler_28.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                                  out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                                }
                                if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                  return;
                                OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,5);
                              }
                              out.write(__oracle_jsp_text[69]);
                            } while (__jsp_taghandler_27.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                          }
                          if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                            return;
                          OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,4);
                        }
                        out.write(__oracle_jsp_text[70]);
                      } while (__jsp_taghandler_25.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
                    }
                    if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,3);
                  }
                  out.write(__oracle_jsp_text[71]);
                  if (usuario.getSupervisor()) {
                  out.write(__oracle_jsp_text[72]);
                  } else {
                  out.write(__oracle_jsp_text[73]);
                  {
                    org.apache.struts.taglib.logic.EqualTag __jsp_taghandler_29=(org.apache.struts.taglib.logic.EqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.EqualTag.class,"org.apache.struts.taglib.logic.EqualTag name property value");
                    __jsp_taghandler_29.setParent(__jsp_taghandler_16);
                    __jsp_taghandler_29.setName("puestoForm");
                    __jsp_taghandler_29.setProperty("idUnidadAdministrativa");
                    __jsp_taghandler_29.setValue("0");
                    __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[74]);
                      } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,3);
                  }
                  out.write(__oracle_jsp_text[75]);
                  {
                    org.apache.struts.taglib.logic.NotEqualTag __jsp_taghandler_30=(org.apache.struts.taglib.logic.NotEqualTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts.taglib.logic.NotEqualTag.class,"org.apache.struts.taglib.logic.NotEqualTag name property value");
                    __jsp_taghandler_30.setParent(__jsp_taghandler_16);
                    __jsp_taghandler_30.setName("puestoForm");
                    __jsp_taghandler_30.setProperty("idUnidadAdministrativa");
                    __jsp_taghandler_30.setValue("0");
                    __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
                    if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                    {
                      do {
                        out.write(__oracle_jsp_text[76]);
                      } while (__jsp_taghandler_30.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                    }
                    if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,3);
                  }
                  out.write(__oracle_jsp_text[77]);
                  }
                  out.write(__oracle_jsp_text[78]);
                } while (__jsp_taghandler_16.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[79]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[80]);

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
  private static final char __oracle_jsp_text[][]=new char[81][];
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
    "\n<HTML>\n<HEAD>\n<TITLE>Puestos</TITLE>\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\n<LINK href=\"./theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"./css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<STYLE type=\"text/css\">\n</STYLE>\n<SCRIPT src=\"./js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<script src=\"./js/SigaJS.js\" type=\"text/javascript\"></script>\n<script src=\"./js/estructuraOrganizacional.js\" type=\"text/javascript\"></script>\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<STYLE type=text/css>\nBODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY onload=\"setChecksAsistentes(".toCharArray();
    __oracle_jsp_text[11] = 
    ");setCheckRoles(".toCharArray();
    __oracle_jsp_text[12] = 
    ");return false;\">\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t<input type=\"hidden\" name=\"accion\" value=\"\" />\n\t<input type=\"hidden\" name=\"idLink\" value=\"\" />\n\t<DIV align=\"center\"><BR>\n\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"125\">\n\t\t\t\t   <a href=\"javascript:;\" onclick=\"submitForm(puestoForm,'regresar','');return false;\"> \n\t\t\t\t      <IMG border=\"0\" src=\"./Imagenes/NavLeft.gif\" alt=\"Regresar\">\n\t\t\t\t   </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n\t\t\t\t   <a href=\"javascript:;\" onclick=\"submitForm(puestoForm,'".toCharArray();
    __oracle_jsp_text[14] = 
    "','guardar');return false;\"> \n\t\t\t\t      <IMG border=\"0\" src=\"./Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t\t   </a>\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"125\"></TD>\n\t\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t\t<TD width=\"142\"></TD>\n\t\t\t</TR>\n\t\t</TBODY>\n\t</TABLE>\n\t</DIV>\n\t<DIV align=\"center\"></DIV>\n\t<br>\n\t<DIV class=documentBody id=Body>\n\t<DIV align=\"center\">\n\t<TABLE width=\"820\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"50%\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\t\tsize=\"2\">Registro de Puesto</FONT></B></TD>\n\t\t\t\t<TD width=\"50%\" align=\"right\">**Los datos marcados con negritas\n\t\t\t\tson obligatorios&nbsp;<FONT face=\"Verdana\" size=\"2\"><I></I></FONT></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t\t<TD colspan=\"2\"></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t\t<TD colspan=\"2\"></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD align=\"right\" colspan=\"2\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t\tCreado por: <I>".toCharArray();
    __oracle_jsp_text[15] = 
    " - ".toCharArray();
    __oracle_jsp_text[16] = 
    "</I></FONT></TD>\n\t\t\t</TR>\n\t\t</TBODY>\n\t</TABLE>\n\t<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"531\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR VALIGN=top>\n\t\t\t<TD width=\"218\"><FONT SIZE=\"2\" FACE=\"Verdana\" color=\"#004080\"><B>Usuario:</B></FONT><BR>\n\t\t\t</TD>\n\t\t\t<TD width=\"531\"><FONT SIZE=\"2\" FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"531\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR VALIGN=top>\n\t\t\t<TD width=\"218\"><FONT SIZE=\"2\" FACE=\"Verdana\" color=\"#004080\"><B>Contraseña:</B></FONT></TD>\n\t\t\t<TD width=\"531\"><FONT SIZE=\"2\" FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"531\">&nbsp;</TD>\n\t\t</TR>\n\t</table>\n\t</DIV>\n\t<DIV align=\"center\">\n\t<TABLE width=\"820\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TBODY>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Datos\n\t\t\t\tPersonales</FONT></B></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD bgcolor=\"#00204f\"><img src=\"./Imagenes/shim.gif\" width=\"1\"\n\t\t\t\t\theight=\"2\" alt=\"\"></TD>\n\t\t\t</TR>\n\t\t</TBODY>\n\t</TABLE>\n\t<DIV align=\"center\">\n\t<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR VALIGN=top>\n\t\t\t<TD width=\"218\"><FONT SIZE=\"2\" FACE=\"Verdana\" color=\"#004080\">Buscar\n\t\t\tDatos:</FONT></TD>\n\t\t\t<TD width=\"529\"><FONT SIZE=\"2\" FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    " ---------------- Selecciona un Puesto ---------------- ".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR VALIGN=top>\n\t\t\t<TD width=\"218\"><FONT SIZE=\"2\" FACE=\"Verdana\" color=\"#004080\"><B>Unidad\n\t\t\tAdministrativa:</B></FONT></TD>\n\t\t\t<TD width=\"529\"><FONT SIZE=\"2\" FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "------------- Seleccione una Unidad Administrativa ------------- ".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    " </FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR VALIGN=top>\n\t\t\t<TD width=\"218\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t<B>Puesto:</B> </FONT><BR>\n\t\t\t</TD>\n\t\t\t<TD width=\"529\"><FONT SIZE=\"2\" FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR VALIGN=top>\n\t\t\t<TD width=\"218\"><FONT SIZE=\"2\" FACE=\"Verdana\" color=\"#004080\">\n\t\t\t<B>Responsable:</B></FONT><BR>\n\t\t\t</TD>\n\t\t\t<TD width=\"529\"><FONT SIZE=\"2\" FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[36] = 
    " </FONT></TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR VALIGN=top>\n\t\t\t<TD width=\"218\"><FONT SIZE=\"2\" FACE=\"Verdana\" color=\"#004080\"><B>Correo\n\t\t\tElectrónico:</B></FONT></TD>\n\t\t\t<TD width=\"529\"><FONT SIZE=\"2\" FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR VALIGN=top>\n\t\t\t<TD width=\"218\"><FONT SIZE=\"2\" FACE=\"Verdana\" color=\"#004080\">Teléfono:</FONT></TD>\n\t\t\t<TD width=\"529\"><FONT SIZE=\"2\" FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t<TR VALIGN=top>\n\t\t\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">Jefe\n\t\t\t\t(Puesto): </FONT></TD>\n\t\t\t\t<TD width=\"529\">\n\t\t\t\t ".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "------------ Puesto UA Padre ------------".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "/".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "------------ Puestos UA ------------".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "/".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">Nombre\n\t\t\t\tdel Jefe:</FONT></TD>\n\t\t\t\t<TD width=\"529\">".toCharArray();
    __oracle_jsp_text[55] = 
    "</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t<TR VALIGN=top>\n\t\t\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">\n\t\t\t\t</FONT></TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t\t<TD width=\"600\">\n\t\t\t\t<FIELDSET dir=\"ltr\" class=\"bluethinBorder\"><LEGEND align=\"left\"><FONT\n\t\t\t\t\tSIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Asistentes</B></FONT></LEGEND> <FONT\n\t\t\t\t\tSIZE=2 FACE=\"Verdana\">\n\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t<tbody>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t\t\t\t\t\t<tr><td width=\"100%\">\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"idAsistentes\"\n\t\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[59] = 
    "\">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "/".toCharArray();
    __oracle_jsp_text[61] = 
    "</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t\t\t</tbody>\n\t\t\t\t</table>\n\t\t\t\t</FONT></FIELDSET>\n\t\t\t\t</TD>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t<TR VALIGN=top>\n\t\t\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">atención\n\t\t\t\tDestinatarios Externos:</FONT></TD>\n\t\t\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT\n\t\t\t\t\ttype=\"checkbox\" name=\"atencionExternos\" id=\"chkAtencionExternos\" value=\"1\" />Si </FONT></TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t\n\t\t\t<TR VALIGN=top>\n\t\t      <TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">atención SubVentanilla:</FONT></TD>\n\t\t      <TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> \n\t\t\t  ".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "------------ Puestos Atencion ------------".toCharArray();
    __oracle_jsp_text[66] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "/".toCharArray();
    __oracle_jsp_text[69] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t      </FONT></TD>\n\t        </TR>\n\t        <TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t\t</TR>\n\n\t\t\t<TR VALIGN=top>\n\t\t\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\">&nbsp;</FONT></TD>\n\t\t\t\t<TD width=\"600\">\n\t\t\t\t<FIELDSET dir=\"ltr\" class=\"bluethinBorder\"><LEGEND align=\"left\"><FONT\n\t\t\t\t\tSIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Rol de Usuario</B></FONT></LEGEND>\n\t\t\t\t<TABLE width=\"100%\">\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD width=\"25%\"><FONT SIZE=1 FACE=\"Verdana\"> \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t\t\t\t   <INPUT value=\"0\" name=\"idRoles\" type=\"checkbox\" disabled=\"disabled\" >Administrador \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    " \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t\t\t\t\t   <INPUT value=\"0\" name=\"idRoles\" type=\"checkbox\" onclick=\"seleccionaRol(this);\">Administrador\n\t\t\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t\t\t\t\t       <INPUT value=\"0\" id=\"chkAdministrador\" name=\"idRoles\" type=\"checkbox\" \n\t\t\t\t\t\t              disabled=\"disabled\" onclick=\"seleccionaRol(this);\">Administrador\n\t\t\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    " \n                           </FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"25%\"><FONT SIZE=1 FACE=\"Verdana\"><INPUT \n\t\t\t\t\t\t\t\tvalue=\"1\" id=\"chkAtencion\" name=\"idRoles\" type=\"checkbox\" \n\t\t\t\t\t\t\t\tonclick=\"seleccionaRol(this);\">atención </FONT></TD>\n\n\t\t\t\t\t\t\t<TD width=\"25%\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT \n\t\t\t\t\t\t\t\tvalue=\"3\" id=\"chkRecepcion\" name=\"idRoles\" type=\"checkbox\" \n\t\t\t\t\t\t\t\tonclick=\"seleccionaRol(this);\">Recepción </FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"25%\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT\n\t\t\t\t\t\t\t\tvalue=\"2\" id=\"chkSCP\" name=\"idRoles\" type=\"checkbox\" \n\t\t\t\t\t\t\t\tonclick=\"seleccionaRol(this);\">SCP </FONT></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD width=\"25%\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT \n\t\t\t\t\t\t\t\tvalue=\"4\" id=\"chkSupervisor\" name=\"idRoles\" type=\"checkbox\" \n\t\t\t\t\t\t\t\tonclick=\"seleccionaRol(this);\">Supervisor área\n\t\t\t\t\t\t\t</FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"25%\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT \n\t\t\t\t\t\t\t\tvalue=\"5\" id=\"chkTurnador\" name=\"idRoles\" type=\"checkbox\" \n\t\t\t\t\t\t\t\tonclick=\"seleccionaRol(this);\">Turnado </FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"25%\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT \n\t\t\t\t\t\t\t\tvalue=\"6\" id=\"chkAsistente\" name=\"idRoles\" type=\"checkbox\" \n\t\t\t\t\t\t\t\tonclick=\"seleccionaRol(this);\">Asistente </FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"25%\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT \n\t\t\t\t\t\t\t\tvalue=\"7\" id=\"chkAsistente\" name=\"idRoles\" type=\"checkbox\" \n\t\t\t\t\t\t\t\tonclick=\"seleccionaRol(this);\">SubSCP </FONT>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t\t</FIELDSET>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t\t</TR>\n\n\t\t\t<TR VALIGN=top>\n\t\t\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\">&nbsp;</FONT></TD>\n\t\t\t\t<TD width=\"600\">\n\t\t\t\t<FIELDSET dir=\"ltr\" class=\"bluethinBorder\"><LEGEND align=\"left\"><FONT\n\t\t\t\t\tSIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Configuración\n\t\t\t\tde Correos de Salida</B></FONT></LEGEND>\n\t\t\t\t<TABLE>\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD width=\"172\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT  id=\"chkMailNuevoAsu\"\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t\t\tname=\"idCorreosSalida\" type=\"checkbox\" value=\"0\" align=\"middle\">Nuevo\n\t\t\t\t\t\t\tAsunto </FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"172\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT  id=\"chkMailTurnarIns\"\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t\t\tname=\"idCorreosSalida\" type=\"checkbox\" value=\"1\" align=\"middle\">Turnar\n\t\t\t\t\t\t\tInstrucciones </FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"173\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT  id=\"chkMailResponderIns\"\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t\t\tname=\"idCorreosSalida\" type=\"checkbox\" value=\"2\" align=\"middle\">Responder\n\t\t\t\t\t\t\tinstrucción </FONT></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD width=\"172\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT  id=\"chkMailRechazarIns\"\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t\t\tname=\"idCorreosSalida\" type=\"checkbox\" value=\"3\" align=\"middle\">Rechazar\n\t\t\t\t\t\t\tinstrucción </FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"172\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT  id=\"chkMailDelegarIns\"\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t\t\tname=\"idCorreosSalida\" type=\"checkbox\" value=\"4\" align=\"middle\">Delegar\n\t\t\t\t\t\t\tinstrucción </FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"173\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT  id=\"chkMailReasignarIns\"\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t\t\tname=\"idCorreosSalida\" type=\"checkbox\" value=\"5\" align=\"middle\">Reasignar\n\t\t\t\t\t\t\tinstrucción </FONT></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD width=\"172\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT id=\"chkMailHabilitarIns\"\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t\t\tname=\"idCorreosSalida\" type=\"checkbox\" value=\"6\" align=\"middle\">Habilitar\n\t\t\t\t\t\t\tinstrucción </FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"172\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT  id=\"chkMailCambioFechaIns\"\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t\t\tname=\"idCorreosSalida\" type=\"checkbox\" value=\"7\" align=\"middle\">Solicitud\n\t\t\t\t\t\t\tde cambio de fecha de una instrucción </FONT></TD>\n\t\t\t\t\t\t\t<TD width=\"173\"><FONT SIZE=1 FACE=\"Verdana\"> <INPUT id=\"chkMailResCambioFechaIns\"\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t\t\tname=\"idCorreosSalida\" type=\"checkbox\" value=\"8\" align=\"middle\">Respuesta\n\t\t\t\t\t\t\tde cambio de fecha de una instrucción </FONT></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t\t</FIELDSET>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t\t</TR>\n\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"600\">\n\t\t\t\t<fieldset dir=\"ltr\" class=\"bluethinBorder\"><legend><FONT SIZE=2\n\t\t\t\t\tFACE=\"Verdana\" color=\"#004080\"><B>Configuración de\n\t\t\t\tCorreos de Entrada</B></FONT></legend>\n\t\t\t\t<table width=\"98%\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"46%\"><FONT SIZE=1 FACE=\"Verdana\"> <input\n\t\t\t\t\t\t\tname=\"corresEntrada\" type=\"checkbox\" value=\"0\" align=\"middle\"\n\t\t\t\t\t\t\tchecked=\"checked\">Recibir Notificaciones </FONT></td>\n\t\t\t\t\t\t<td width=\"54%\"><FONT SIZE=1 FACE=\"Verdana\"></FONT></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</fieldset>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"529\">&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t<TD width=\"600\">\n\t\t\t\t<fieldset dir=\"ltr\" class=\"bluethinBorder\"><legend><FONT SIZE=2\n\t\t\t\t\tFACE=\"Verdana\" color=\"#004080\"><B>Configuraci&oacute;n\n\t\t\t\tde Cat&aacute;logos </B></FONT></legend>\n\t\t\t\t<table width=\"98%\" border=\"0\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"46%\"><FONT SIZE=1 FACE=\"Verdana\"> <input\n\t\t\t\t\t\t\tname=\"catalogoArchivado\" type=\"checkbox\" value=\"1\" align=\"middle\">Cat&aacute;logo\n\t\t\t\t\t\tde Archivado</FONT></td>\n\t\t\t\t\t\t<td width=\"54%\"><FONT SIZE=1 FACE=\"Verdana\"></FONT></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</fieldset>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t</TABLE>\n\t<br>\n\t</DIV>\n\t<br>\n\t<BR>\n\t<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n\t</DIV>\n".toCharArray();
    __oracle_jsp_text[80] = 
    "\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
