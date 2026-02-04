package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.reportes.*;
import de.laures.cewolf.*;
import com.meve.sigma.actualiza.*;


public class _ReporteRemitido extends com.orionserver.http.OrionHttpJspPage {


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
    _ReporteRemitido page = this;
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
      out.write(__oracle_jsp_text[4]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null)
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}catch(java.io.IOException io){
      			//System.out.println("Error-->"+io);
      		}
      
      
      out.write(__oracle_jsp_text[5]);
      
      	String strMes 		= 	"";
      	String stryear 		= 	"";
      	String strInicio	=	"";
      	String strFin		=	"";
      	String strFecha		=	"";
      	String strIdReporte = 	"";
      	String strIDMax		=	"";
      	String strAccion	=	"";
      	int iReporte		=	0;
      	int i				=	0;
      	int count			=	0;
      	boolean bInsertar	=	false;
      	String strDatosReportes[][] = null;
      	String strDocotos[]	=	null;
      	String nombreDoctos	=	"";
      	String numAsuntos	=	"";
      	String porcentaje	=	"";
      	
      	java.text.SimpleDateFormat sdf		=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      	java.util.Date f 					=	new java.util.Date();
      	strFecha							=	sdf.format(f);
      	
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
      	strIdReporte	=	request.getParameter("id_rep");
      	strAccion		=	request.getParameter("accion"); 
      	String idRep[][]=	ActualizaReportes.getMaxID();
      	strIDMax = idRep[0][0];
      	if(strIDMax.length() == 0){
      		strIDMax = "0";
      		iReporte = new Integer(strIDMax).intValue();
      	}else{
      		iReporte = new Integer(strIDMax).intValue();
      	}
      	if(strAccion != null && strAccion.equals("guardar"))     
      	{
      		strInicio	=	request.getParameter("inicioR");
      		strFin		=	request.getParameter("finR");
      		i			=	iReporte + 1;
      		String strTipoRep = "7";
      		String strTitulo	=	""; 
      		String strReporte[][]  =	ActualizaReportes.getReportePorAsuntosRemitidos(strInicio, strFin, BUsuario.getIdArea());
      		for(int j=0;j<strReporte.length;j++){
      			count += new Integer(strReporte[j][2]).intValue(); 
      		}  
      		strTitulo 	=	"Reporte Generado del "+strInicio+" al "+strFin;
      		bInsertar	=	ActualizaReportes.InsertarAsuntoRemitido(i, strReporte, strTipoRep, 
      																strFecha, count, strTitulo, BUsuario.getIdArea());
      		try{
      			response.sendRedirect("ViewAsuntoRemitido.jsp");
      		}catch(java.io.IOException io){
      			//System.err.println("Error-->"+io); 
      		} 
      	}
      
      	if(strIdReporte != null)
      	{
      		strDatosReportes = ActualizaReportes.getDatosReportes(strIdReporte);
      	}
      	
      	if (pageContext.getAttribute("initFlag") == null) {
      		DatasetProducer categoryData = new Bean3dChart(strDatosReportes, "", "0"); 
      		pageContext.setAttribute("categoryDataChar", categoryData);
      	
      		DatasetProducer pieData = new BeanPieChart(strDatosReportes, "0");
        		pageContext.setAttribute("pieDataChar", pieData);
      	}
      
      out.write(__oracle_jsp_text[6]);
      out.print(retURI);
      out.write(__oracle_jsp_text[7]);
       if(strIdReporte == null && (BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[8]);
      }
      out.write(__oracle_jsp_text[9]);
       if(strIdReporte == null){ 
      out.write(__oracle_jsp_text[10]);
       } 
      out.write(__oracle_jsp_text[11]);
       if(strIdReporte != null && strDatosReportes!=null && strDatosReportes.length>0){ 
      out.write(__oracle_jsp_text[12]);
      out.print( retURI );
      out.write(__oracle_jsp_text[13]);
      out.print(strIdReporte);
      out.write(__oracle_jsp_text[14]);
      out.print(strDatosReportes[0][0]);
      out.write(__oracle_jsp_text[15]);
      out.print(strIdReporte);
      out.write(__oracle_jsp_text[16]);
      out.print(strDatosReportes[0][0]);
      out.write(__oracle_jsp_text[17]);
      out.print(ActualizaArea.NombreArea(BUsuario.getIdArea()));
      out.write(__oracle_jsp_text[18]);
      out.print(strDatosReportes[0][0]);
      out.write(__oracle_jsp_text[19]);
       for(int y=0;y<strDatosReportes.length;y++){ 
      out.write(__oracle_jsp_text[20]);
      out.print(strDatosReportes[y][2]);
      out.write(__oracle_jsp_text[21]);
      out.print(strDatosReportes[y][3]);
      out.write(__oracle_jsp_text[22]);
      out.print(strDatosReportes[y][4]);
      out.write(__oracle_jsp_text[23]);
       } 
      out.write(__oracle_jsp_text[24]);
      {
        de.laures.cewolf.taglib.tags.SimpleChartTag __jsp_taghandler_1=(de.laures.cewolf.taglib.tags.SimpleChartTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.SimpleChartTag.class,"de.laures.cewolf.taglib.tags.SimpleChartTag id type title xaxislabel yaxislabel");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setId("horizontalBarChart3D");
        __jsp_taghandler_1.setType("horizontalBar3D");
        __jsp_taghandler_1.setTitle("Grafica por numero de Asuntos Remitidos");
        __jsp_taghandler_1.setXaxislabel("Control de Folio");
        __jsp_taghandler_1.setYaxislabel("Totales");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[25]);
            {
              de.laures.cewolf.taglib.tags.GradientTag __jsp_taghandler_2=(de.laures.cewolf.taglib.tags.GradientTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.GradientTag.class,"de.laures.cewolf.taglib.tags.GradientTag");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[26]);
                  {
                    de.laures.cewolf.taglib.tags.PointTag __jsp_taghandler_3=(de.laures.cewolf.taglib.tags.PointTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.PointTag.class,"de.laures.cewolf.taglib.tags.PointTag x y color");
                    __jsp_taghandler_3.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_3.setX(0);
                    __jsp_taghandler_3.setY(0);
                    __jsp_taghandler_3.setColor("#FFFFFF");
                    __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
                    if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,3);
                  }
                  out.write(__oracle_jsp_text[27]);
                  {
                    de.laures.cewolf.taglib.tags.PointTag __jsp_taghandler_4=(de.laures.cewolf.taglib.tags.PointTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.PointTag.class,"de.laures.cewolf.taglib.tags.PointTag x y color");
                    __jsp_taghandler_4.setParent(__jsp_taghandler_2);
                    __jsp_taghandler_4.setX(300);
                    __jsp_taghandler_4.setY(0);
                    __jsp_taghandler_4.setColor("#DDDDFF");
                    __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
                    if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,3);
                  }
                  out.write(__oracle_jsp_text[28]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[29]);
            {
              de.laures.cewolf.taglib.tags.DataTag __jsp_taghandler_5=(de.laures.cewolf.taglib.tags.DataTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.DataTag.class,"de.laures.cewolf.taglib.tags.DataTag");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[30]);
                  {
                    de.laures.cewolf.taglib.tags.ProducerTag __jsp_taghandler_6=(de.laures.cewolf.taglib.tags.ProducerTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.ProducerTag.class,"de.laures.cewolf.taglib.tags.ProducerTag id");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_6.setId("categoryDataChar");
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[31]);
                } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[32]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[33]);
      {
        de.laures.cewolf.taglib.tags.ChartImgTag __jsp_taghandler_7=(de.laures.cewolf.taglib.tags.ChartImgTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.ChartImgTag.class,"de.laures.cewolf.taglib.tags.ChartImgTag renderer chartid width height");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setRenderer("/cewolf");
        __jsp_taghandler_7.setChartid("horizontalBarChart3D");
        __jsp_taghandler_7.setWidth(600);
        __jsp_taghandler_7.setHeight(400);
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[34]);
      {
        de.laures.cewolf.taglib.tags.SimpleChartTag __jsp_taghandler_8=(de.laures.cewolf.taglib.tags.SimpleChartTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.SimpleChartTag.class,"de.laures.cewolf.taglib.tags.SimpleChartTag id type title");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setId("pieChart");
        __jsp_taghandler_8.setType("pie");
        __jsp_taghandler_8.setTitle("Grafica de porcentaje por Asuntos Remitidos");
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[35]);
            {
              de.laures.cewolf.taglib.tags.GradientTag __jsp_taghandler_9=(de.laures.cewolf.taglib.tags.GradientTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.GradientTag.class,"de.laures.cewolf.taglib.tags.GradientTag");
              __jsp_taghandler_9.setParent(__jsp_taghandler_8);
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[36]);
                  {
                    de.laures.cewolf.taglib.tags.PointTag __jsp_taghandler_10=(de.laures.cewolf.taglib.tags.PointTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.PointTag.class,"de.laures.cewolf.taglib.tags.PointTag x y color");
                    __jsp_taghandler_10.setParent(__jsp_taghandler_9);
                    __jsp_taghandler_10.setX(0);
                    __jsp_taghandler_10.setY(0);
                    __jsp_taghandler_10.setColor("#FFFFFF");
                    __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                    if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,3);
                  }
                  out.write(__oracle_jsp_text[37]);
                  {
                    de.laures.cewolf.taglib.tags.PointTag __jsp_taghandler_11=(de.laures.cewolf.taglib.tags.PointTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.PointTag.class,"de.laures.cewolf.taglib.tags.PointTag x y color");
                    __jsp_taghandler_11.setParent(__jsp_taghandler_9);
                    __jsp_taghandler_11.setX(300);
                    __jsp_taghandler_11.setY(0);
                    __jsp_taghandler_11.setColor("#DDDDFF");
                    __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                    if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,3);
                  }
                  out.write(__oracle_jsp_text[38]);
                } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[39]);
            {
              de.laures.cewolf.taglib.tags.DataTag __jsp_taghandler_12=(de.laures.cewolf.taglib.tags.DataTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.DataTag.class,"de.laures.cewolf.taglib.tags.DataTag");
              __jsp_taghandler_12.setParent(__jsp_taghandler_8);
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[40]);
                  {
                    de.laures.cewolf.taglib.tags.ProducerTag __jsp_taghandler_13=(de.laures.cewolf.taglib.tags.ProducerTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.ProducerTag.class,"de.laures.cewolf.taglib.tags.ProducerTag id");
                    __jsp_taghandler_13.setParent(__jsp_taghandler_12);
                    __jsp_taghandler_13.setId("pieDataChar");
                    __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                    if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,3);
                  }
                  out.write(__oracle_jsp_text[41]);
                } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[42]);
          } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      out.write(__oracle_jsp_text[43]);
      {
        de.laures.cewolf.taglib.tags.ChartImgTag __jsp_taghandler_14=(de.laures.cewolf.taglib.tags.ChartImgTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.ChartImgTag.class,"de.laures.cewolf.taglib.tags.ChartImgTag renderer chartid width height");
        __jsp_taghandler_14.setParent(null);
        __jsp_taghandler_14.setRenderer("/cewolf");
        __jsp_taghandler_14.setChartid("pieChart");
        __jsp_taghandler_14.setWidth(600);
        __jsp_taghandler_14.setHeight(400);
        __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
        if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,1);
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
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    " \n".toCharArray();
    __oracle_jsp_text[3] = 
    " \n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Reporte por Asunto</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\nfunction guardar() { \n\n\tdoc = document.reporteTRemit;\n\tvalida = 0;\n\tmsg=\"\";\n\n\tif (doc.inicioR.value ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \"- Debes seleccionar la Fecha de Inicio\t\"+ \"\\n\";\n\t}\n\tif (doc.finR.value ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \"- Debes seleccionar la Fecha Final\t\"+ \"\\n\";\n\t}\n\tif (comparaFechas(doc.inicioR.value,getfechaActual())==1){\n\t\tvalida =1;\n\t\tmsg = msg + \"- La Fecha de Inicio debe ser menor o igual a la actual\" + \"\\n\";\n\t}\n\tif (comparaFechas(doc.finR.value,getfechaActual())==1){\n\t\tvalida =1;\n\t\tmsg = msg + \"- La Fecha Final debe ser menor o igual a la actual\" + \"\\n\";\n\t}\n\tif (doc.inicioR.value!=\"\" && doc.finR.value!=\"\" && comparaFechas(doc.inicioR.value,doc.finR.value)==1){\n\t\tvalida =1;\n\t\tmsg = msg + \"- La Fecha de Inicio debe ser menor o igual a la Fecha Final\" + \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\treturn false;\n\t}else{\n\t\tdoc.accion.value=\"guardar\";\n\t\tdoc.submit();\n\t}\n}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"reporteTRemit\" action=\"ReporteRemitido.jsp\" method=\"post\"><INPUT\n\ttype=\"hidden\" value=\"guardar\" name=\"accion\">\n<INPUT name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\" type=\"hidden\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"144\">".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\t\t<A href=\"ViewAsuntoRemitido.jsp\" title=\"Regresar\"> <IMG src=\"../Imagenes/NavLeft.gif\" border=\"0\"></A> &nbsp;&nbsp;&nbsp;\n\t\t\t<A onclick=\"guardar()\" title=\"Generar Reporte\"><IMG src=\"../Imagenes/Report.png\" border=\"0\"></A>\n\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "</td>\n\t\t<td width=\"108\"></td> \n\t\t<td width=\"144\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"144\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</table>\n</DIV>\n<br>\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"546\"><b><font size=\"2\" color=\"#002060\" face=\"Arial\">Condiciones\n\t\tpara Generar Reporte</font></b>\n\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"100%\" bgcolor=\"#002060\"><img src=\"../Imagenes/shim.gif\"\n\t\t\t\t\twidth=\"1\" height=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<br>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"546\">\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"23\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t\t<td width=\"498\"><font size=\"2\" face=\"Arial\">Proporcione la\n\t\t\t\tinformacion solicitada y posteriormente de clic en el botón\n\t\t\t\t&quot;Generar Reporte&quot;. Para salir de clic en el botón\n\t\t\t\t&quot;Regresar&quot;.</font></td>\n\t\t\t\t<td width=\"24\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<hr>\n\t\t<br>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"546\">\n\t\t<center>\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"91\">\n\t\t\t\t<div align=\"center\"><b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">De:</font></b>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"173\"><INPUT name=\"inicioR\" value=\"\" onfocus=\"blur();\"\n\t\t\t\t\tonclick=\"document.forms.reporteTA.inicioR.value=''\" class=\"blue100\">\n\t\t\t\t<A><IMG alt=\"\" src=\"../Imagenes/act_calFormat.gif\" \n\t\t\t\t\tborder=\"0\" onclick='show_calendar(\"forms[0].inicioR\");'></A> <FONT\n\t\t\t\t\tface=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT></td>\n\t\t\t\t<td width=\"90\">\n\t\t\t\t<div align=\"center\"><b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">A:</font></b>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"174\"><INPUT name=\"finR\" value=\"\" onfocus=\"blur();\"\n\t\t\t\t\tonclick=\"document.forms.reporteTA.finR.value=''\" class=\"blue100\"> <A><IMG\n\t\t\t\t\talt=\"\" src=\"../Imagenes/act_calFormat.gif\" border=\"0\"\n\t\t\t\t\tonclick='show_calendar(\"forms[0].finR\");'></A> <FONT face=\"Arial\"\n\t\t\t\t\tcolor=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</center>\n\t\t<br>\n\t\t<hr>\n\t\t<br>\n\t\t</td>\n\t</tr>\n</table>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[11] = 
    " ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"144\"><a href=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\"> <IMG border=\"0\"\n\t\t\tsrc=\"../Imagenes/NavLeft.gif\"> </a></td>\n\t\t<td width=\"108\"><a onclick=\"window.open('../RporTipDocto?id_rep=".toCharArray();
    __oracle_jsp_text[14] = 
    "&tip=AnalisisPorAsuntoRemitido&tit=".toCharArray();
    __oracle_jsp_text[15] = 
    "');\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/ic_pdf.gif\" alt=\"Exportar a PDF\"></a></td>\n\t\t<td width=\"144\"><a onclick=\"window.open('../ReportExcel?id_rep=".toCharArray();
    __oracle_jsp_text[16] = 
    "&tip=AnalisisPorAsuntoRemitidoExcel&tit=".toCharArray();
    __oracle_jsp_text[17] = 
    "');\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/ic_excel.gif\" alt=\"Exportar a Excel\"></a></td>\n\t\t<td width=\"227\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</table>\n<br>\n<table border=\"1\">\n\t<tr valign=\"top\">\n\t\t<td width=\"442\" bgcolor=\"#002060\">\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td width=\"75%\"><b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[18] = 
    "<BR>".toCharArray();
    __oracle_jsp_text[19] = 
    "</font></b>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"25%\">\n\t\t\t\t<div align=\"right\"><i><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\"></font></i>\n\t\t\t\t</div>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"612\">\n\t\t<div align=\"center\">\n\t\t<TABLE BORDER=1 width=\"100%\">\n\t\t\t<TR VALIGN=top align=\"center\">\n\t\t\t\t<TD WIDTH=\"40%\" BGCOLOR=\"002060\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\t\t\tFACE=\"Arial\">Control de Folio</FONT></TD>\n\t\t\t\t<TD WIDTH=\"30%\" BGCOLOR=\"002060\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\t\t\tFACE=\"Arial\">No. Asuntos</FONT></TD>\n\t\t\t\t<TD WIDTH=\"30%\" BGCOLOR=\"002060\"><FONT SIZE=2 COLOR=\"FFFFFF\"\n\t\t\t\t\tFACE=\"Arial\">Porcentaje</FONT></TD>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t<TR VALIGN=top>\n\t\t\t\t<TD WIDTH=\"40%\" align=\"center\"><FONT SIZE=2 FACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[21] = 
    "</FONT>\n\t\t\t\t</TD>\n\t\t\t\t<TD WIDTH=\"30%\" align=\"center\"><FONT SIZE=2 FACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[22] = 
    "</FONT>\n\t\t\t\t</TD>\n\t\t\t\t<TD WIDTH=\"30%\" align=\"center\"><FONT SIZE=2 FACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[23] = 
    "%</FONT>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t</TABLE>\n\t\t</div>\n\t\t</td>\n\t</tr>\n</table>\n</DIV>\n\n<!-- Sección del applet de las graficas --> <br>\n<DIV align=\"center\">\n<TABLE>\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD>".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD>".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    " ".toCharArray();
    __oracle_jsp_text[44] = 
    "</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[45] = 
    " <!-- FIn Sección del applet de las graficas --></FORM>\n\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
