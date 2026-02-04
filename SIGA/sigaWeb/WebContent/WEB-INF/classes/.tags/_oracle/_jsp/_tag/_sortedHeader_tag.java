package _oracle._jsp._tag;

import oracle.jsp.runtime.*;
import oracle.jsp.el.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.el.*;


public class _sortedHeader_tag extends javax.servlet.jsp.tagext.SimpleTagSupport  implements oracle.jsp.runtime.OracleTagFile
{


  // ** Begin Declarations


  // ** End Declarations

  private TagInfo tagInfo = null;
  private JspContext jspContext;
  private java.io.Writer _jspFragWriter;
  private java.lang.String id;
  private java.lang.String key;
  private java.lang.String form;
  private java.lang.String orden;

  public void setJspContext(JspContext ctx) 
  {
    super.setJspContext(ctx);
    java.util.ArrayList _nestedVars;
    java.util.ArrayList _atBeginVars;
    java.util.ArrayList _atEndVars;
    _atBeginVars = null;
    _atEndVars = null;
    _nestedVars = null;
    this.jspContext = new oracle.jsp.runtime.OracleJspContextWrapper(ctx, _atBeginVars, _atEndVars, _nestedVars, null);
  }

  public JspContext getJspContext() 
  {
    return this.jspContext;
  }

  public void setId(java.lang.String id)
  {
    this.id = id;
  }

  public java.lang.String getId()
  {
    return this.id;
  }

  public void setKey(java.lang.String key)
  {
    this.key = key;
  }

  public java.lang.String getKey()
  {
    return this.key;
  }

  public void setForm(java.lang.String form)
  {
    this.form = form;
  }

  public java.lang.String getForm()
  {
    return this.form;
  }

  public void setOrden(java.lang.String orden)
  {
    this.orden = orden;
  }

  public java.lang.String getOrden()
  {
    return this.orden;
  }


  public void doTag() throws javax.servlet.jsp.JspException, java.io.IOException { 
    PageContext pageContext = (PageContext) jspContext;
    try { 
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
        HttpSession session = pageContext.getSession();
        ServletContext application = pageContext.getServletContext();
        JspWriter out = jspContext.getOut();
        ServletConfig config = pageContext.getServletConfig();
        int __jsp_tag_starteval;
        javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);
        pageContext.setAttribute("id", getId());
        pageContext.setAttribute("key", getKey());
        pageContext.setAttribute("form", getForm());
        pageContext.setAttribute("orden", getOrden());


        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("\n\n   <a onclick=\"submitForm(document.");
        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${form}",java.lang.String.class, __ojsp_varRes, null));
        out.write(",'asc', ");
        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${id}",java.lang.String.class, __ojsp_varRes, null));
        out.write(");\" >\n      <img border=\"0\" src=\"./Imagenes/arriba.gif\" align=\"middle\">\n   </a>\n   <FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\tFACE=\"verdana\"><b>");
        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${key}",java.lang.String.class, __ojsp_varRes, null));
        out.write("</b></FONT>\n   <a onclick=\"submitForm(document.");
        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${form}",java.lang.String.class, __ojsp_varRes, null));
        out.write(",'desc', ");
        out.write( (java.lang.String)oracle.jsp.runtime.OracleJspRuntime.evaluate("${id}",java.lang.String.class, __ojsp_varRes, null));
        out.write(");\">\n      <img border=\"0\" src=\"./Imagenes/abajo.gif\" align=\"middle\">\n   </a>\n");
      } catch( Throwable t ) {
        if (t instanceof javax.servlet.jsp.SkipPageException)
            throw (javax.servlet.jsp.SkipPageException) t;
        if (t instanceof IllegalStateException)
            throw (IllegalStateException) t;
        if (t instanceof java.io.IOException)
            throw (java.io.IOException) t;
        if (t instanceof javax.servlet.jsp.JspException)
            throw (javax.servlet.jsp.JspException) t;
        throw new javax.servlet.jsp.JspException(t);
      }
      finally {
        ((oracle.jsp.runtime.OracleJspContextWrapper) jspContext).syncVariableEndTagFile();
        OracleJspRuntime.releaseTagHandlers(pageContext);
      }
    }

    public TagInfo getTagInfo(TagLibraryInfo tlib)
    {
      if (tagInfo != null)
        return tagInfo;

      TagVariableInfo[] tagVariableInfos = new TagVariableInfo[0];
      TagAttributeInfo[] tagAttributeInfo = {
        new TagAttributeInfo("id",false,"java.lang.String",true,false),
        new TagAttributeInfo("key",false,"java.lang.String",true,false),
        new TagAttributeInfo("form",false,"java.lang.String",true,false),
        new TagAttributeInfo("orden",false,"java.lang.String",true,false)};

      tagInfo = new TagInfo("sortedHeader","_oracle._jsp._tag._sortedHeader_tag","SCRIPTLESS","null",tlib,null,tagAttributeInfo,"null","null","null",tagVariableInfos,false);
      return tagInfo;
    }

}
