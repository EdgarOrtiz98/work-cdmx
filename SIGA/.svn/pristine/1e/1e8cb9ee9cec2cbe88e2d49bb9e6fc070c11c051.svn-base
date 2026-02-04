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


public class _ReporteEstatus extends com.orionserver.http.OrionHttpJspPage {


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
    _ReporteEstatus page = this;
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
      	String strM			=	"";
      	String strY			=	"";
      	String strFecha		=	"";
      	String strIdReporte = 	"";
      	String strIDMax		=	"";
      	String strAccion	=	"";
      	int iReporte		=	0;
      	int i				=	0;
      	boolean bInsertar	=	false;
      	String strDatosReportes[][] = null;
      	String nombreDoctos	=	"";
      	String numRecepcion	=	"";
      	String numTurnados	=	"";
      	String numTerminados=	"";
      	
      	java.text.SimpleDateFormat sdfMes 	=	new java.text.SimpleDateFormat("MM");
      	java.text.SimpleDateFormat sdfanio	=	new java.text.SimpleDateFormat("yyyy");
      	java.text.SimpleDateFormat sdf		=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      	java.util.Date f 					=	new java.util.Date();
      	strMes 								=	sdfMes.format(f);
      	stryear								=	sdfanio.format(f);
      	strFecha							=	sdf.format(f);
      	
      	strIdReporte	=	request.getParameter("id_rep");
      	strAccion		=	request.getParameter("accion");
      
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
      
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
      		strM	=	request.getParameter("inicioR");
      		strY	=	request.getParameter("finR");
      		i		=	iReporte + 1;
      		String strTipoRep = "2";
      		String strReporte[][]  =	ActualizaReportes.getReportePorEstatus(strM, strY, BUsuario.getIdArea());
      		
      		String strTitulo	=	"Reporte Generado del "+strM+" al "+strY;
      		bInsertar	=	ActualizaReportes.InsertarAsuntoEstatus(i, strReporte, strTipoRep, strFecha, strTitulo, BUsuario.getIdArea());
      		try{
      			response.sendRedirect("ViewEstatus.jsp");
      		}catch(java.io.IOException io){
      			//System.err.println("Error-->"+io);
      		} 
      	}
      
      	if(strIdReporte != null)
      	{
      		strDatosReportes = ActualizaReportes.getDatosReportesEstatus(strIdReporte,com.meve.sigma.actualiza.ActualizaArea.NombreArea(BUsuario.getIdArea()));
      	}
      
      	if (pageContext.getAttribute("initFlag") == null) {
      
      		DatasetProducer EstatusTramite = new BeanPlanChartEstatus(strDatosReportes);
      		pageContext.setAttribute("EstatusTramite", EstatusTramite);
      
      		DatasetProducer EstatusTerminado = new BeanPlanChartEstatusTerminado(strDatosReportes);
      		pageContext.setAttribute("EstatusTerminado", EstatusTerminado);
      	}
      
      
      out.write(__oracle_jsp_text[6]);
      out.print(retURI);
      out.write(__oracle_jsp_text[7]);
       if(strIdReporte == null){ 
      out.write(__oracle_jsp_text[8]);
      if(strIdReporte == null){
      out.write(__oracle_jsp_text[9]);
      out.print( retURI );
      out.write(__oracle_jsp_text[10]);
      }
      out.write(__oracle_jsp_text[11]);
       } 
      out.write(__oracle_jsp_text[12]);
       if(strIdReporte != null && strDatosReportes!=null && strDatosReportes.length>0){ 
      out.write(__oracle_jsp_text[13]);
      out.print( retURI );
      out.write(__oracle_jsp_text[14]);
      out.print(strIdReporte);
      out.write(__oracle_jsp_text[15]);
      out.print(strDatosReportes[0][0]);
      out.write(__oracle_jsp_text[16]);
      out.print(com.meve.sigma.actualiza.ActualizaArea.NombreArea(BUsuario.getIdArea()));
      out.write(__oracle_jsp_text[17]);
      out.print(strIdReporte);
      out.write(__oracle_jsp_text[18]);
      out.print(strDatosReportes[0][0]);
      out.write(__oracle_jsp_text[19]);
      out.print(com.meve.sigma.actualiza.ActualizaArea.NombreArea(BUsuario.getIdArea()));
      out.write(__oracle_jsp_text[20]);
      out.print(strDatosReportes[0][1]);
      out.write(__oracle_jsp_text[21]);
      out.print(strDatosReportes[0][0]);
      out.write(__oracle_jsp_text[22]);
       for(int y=0;y<strDatosReportes.length;y++){ 
      out.write(__oracle_jsp_text[23]);
      out.print(strDatosReportes[y][2]);
      out.write(__oracle_jsp_text[24]);
       nombreDoctos += strDatosReportes[y][2]+","; 
      out.write(__oracle_jsp_text[25]);
      out.print(strDatosReportes[y][3]);
      out.write(__oracle_jsp_text[26]);
       numRecepcion += strDatosReportes[y][3]+","; 
      out.write(__oracle_jsp_text[27]);
      out.print(strDatosReportes[y][4]);
      out.write(__oracle_jsp_text[28]);
      out.print(strDatosReportes[y][7]);
      out.write(__oracle_jsp_text[29]);
       numTurnados += strDatosReportes[y][4]+","; 
      out.write(__oracle_jsp_text[30]);
      out.print(strDatosReportes[y][5]);
      out.write(__oracle_jsp_text[31]);
      out.print(strDatosReportes[y][8]);
      out.write(__oracle_jsp_text[32]);
       numTerminados += strDatosReportes[y][5]+","; 
      out.write(__oracle_jsp_text[33]);
       } 
      out.write(__oracle_jsp_text[34]);
      {
        de.laures.cewolf.taglib.tags.SimpleChartTag __jsp_taghandler_1=(de.laures.cewolf.taglib.tags.SimpleChartTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.SimpleChartTag.class,"de.laures.cewolf.taglib.tags.SimpleChartTag id type title xaxislabel yaxislabel");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setId("horizontalBarChart3D");
        __jsp_taghandler_1.setType("horizontalBar3D");
        __jsp_taghandler_1.setTitle("Grafica de Estatus por Asuntos en Tramite");
        __jsp_taghandler_1.setXaxislabel("Tipo de Documento");
        __jsp_taghandler_1.setYaxislabel("Totales");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[35]);
            {
              de.laures.cewolf.taglib.tags.GradientTag __jsp_taghandler_2=(de.laures.cewolf.taglib.tags.GradientTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.GradientTag.class,"de.laures.cewolf.taglib.tags.GradientTag");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[36]);
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
                  out.write(__oracle_jsp_text[37]);
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
                  out.write(__oracle_jsp_text[38]);
                } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[39]);
            {
              de.laures.cewolf.taglib.tags.DataTag __jsp_taghandler_5=(de.laures.cewolf.taglib.tags.DataTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.DataTag.class,"de.laures.cewolf.taglib.tags.DataTag");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[40]);
                  {
                    de.laures.cewolf.taglib.tags.ProducerTag __jsp_taghandler_6=(de.laures.cewolf.taglib.tags.ProducerTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.ProducerTag.class,"de.laures.cewolf.taglib.tags.ProducerTag id");
                    __jsp_taghandler_6.setParent(__jsp_taghandler_5);
                    __jsp_taghandler_6.setId("EstatusTramite");
                    __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
                    if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,3);
                  }
                  out.write(__oracle_jsp_text[41]);
                } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[42]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[43]);
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
      out.write(__oracle_jsp_text[44]);
      {
        de.laures.cewolf.taglib.tags.SimpleChartTag __jsp_taghandler_8=(de.laures.cewolf.taglib.tags.SimpleChartTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.SimpleChartTag.class,"de.laures.cewolf.taglib.tags.SimpleChartTag id type title xaxislabel yaxislabel");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setId("horizontalBarChart3D");
        __jsp_taghandler_8.setType("horizontalBar3D");
        __jsp_taghandler_8.setTitle("Grafica de Estatus por Asuntos Terminados");
        __jsp_taghandler_8.setXaxislabel("Tipo de Documento");
        __jsp_taghandler_8.setYaxislabel("Totales");
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
        {
          do {
            out.write(__oracle_jsp_text[45]);
            {
              de.laures.cewolf.taglib.tags.GradientTag __jsp_taghandler_9=(de.laures.cewolf.taglib.tags.GradientTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.GradientTag.class,"de.laures.cewolf.taglib.tags.GradientTag");
              __jsp_taghandler_9.setParent(__jsp_taghandler_8);
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[46]);
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
                  out.write(__oracle_jsp_text[47]);
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
                  out.write(__oracle_jsp_text[48]);
                } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[49]);
            {
              de.laures.cewolf.taglib.tags.DataTag __jsp_taghandler_12=(de.laures.cewolf.taglib.tags.DataTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.DataTag.class,"de.laures.cewolf.taglib.tags.DataTag");
              __jsp_taghandler_12.setParent(__jsp_taghandler_8);
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[50]);
                  {
                    de.laures.cewolf.taglib.tags.ProducerTag __jsp_taghandler_13=(de.laures.cewolf.taglib.tags.ProducerTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.ProducerTag.class,"de.laures.cewolf.taglib.tags.ProducerTag id");
                    __jsp_taghandler_13.setParent(__jsp_taghandler_12);
                    __jsp_taghandler_13.setId("EstatusTerminado");
                    __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                    if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,3);
                  }
                  out.write(__oracle_jsp_text[51]);
                } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[52]);
          } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
        }
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      out.write(__oracle_jsp_text[53]);
      {
        de.laures.cewolf.taglib.tags.ChartImgTag __jsp_taghandler_14=(de.laures.cewolf.taglib.tags.ChartImgTag)OracleJspRuntime.getTagHandler(pageContext,de.laures.cewolf.taglib.tags.ChartImgTag.class,"de.laures.cewolf.taglib.tags.ChartImgTag renderer chartid width height");
        __jsp_taghandler_14.setParent(null);
        __jsp_taghandler_14.setRenderer("/cewolf");
        __jsp_taghandler_14.setChartid("horizontalBarChart3D");
        __jsp_taghandler_14.setWidth(600);
        __jsp_taghandler_14.setHeight(400);
        __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
        if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,1);
      }
      out.write(__oracle_jsp_text[54]);
       } 
      out.write(__oracle_jsp_text[55]);

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
  private static final char __oracle_jsp_text[][]=new char[56][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "  \n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Reporte por Estatus</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\nfunction guardar() { \n\n\tdoc = document.reporteEst;\n\tvalida = 0;\n\tmsg=\"\";\n\n\tif (doc.inicioR.value ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \"- Debes seleccionar la Fecha de Inicio\t\"+ \"\\n\";\n\t}\n\tif (doc.finR.value ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \"- Debes seleccionar la Fecha Final\t\"+ \"\\n\";\n\t}\n\tif (comparaFechas(doc.inicioR.value,getfechaActual())==1){\n\t\tvalida =1;\n\t\tmsg = msg + \"- La Fecha de Inicio debe ser menor o igual a la actual\" + \"\\n\";\n\t}\n\tif (comparaFechas(doc.finR.value,getfechaActual())==1){\n\t\tvalida =1;\n\t\tmsg = msg + \"- La Fecha Final debe ser menor o igual a la actual\" + \"\\n\";\n\t}\n\tif (doc.inicioR.value!=\"\" && doc.finR.value!=\"\" && comparaFechas(doc.inicioR.value,doc.finR.value)==1){\n\t\tvalida =1;\n\t\tmsg = msg + \"- La Fecha de Inicio debe ser menor o igual a la Fecha Final\" + \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\treturn false;\n\t}else{\n\t\tdoc.accion.value=\"guardar\";\n\t\tdoc.submit();\n\t}\n}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"reporteEst\" action=\"ReporteEstatus.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"guardar\" name=\"accion\">\n<INPUT name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\" type=\"hidden\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<br>\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr valign=\"top\">\n\t\t<td width=\"144\">".toCharArray();
    __oracle_jsp_text[9] = 
    " \n\t\t\t<A href=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\" title=\"Regresar\"> <IMG src=\"../Imagenes/NavLeft.gif\" border=\"0\"></A> &nbsp;&nbsp;&nbsp;\n\t\t\t<A onclick=\"guardar()\" title=\"Generar Reporte\"><IMG src=\"../Imagenes/Report.png\" border=\"0\"></A>\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "</td>\n\t\t<td width=\"108\"></td> \n\t\t<td width=\"144\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"144\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n</tr>\n</table>\n</DIV>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"546\">\n\t\t\t<b><font size=\"2\" color=\"#002060\" face=\"Arial\">Condiciones para Generar Reporte</font></b>\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<td width=\"100%\" bgcolor=\"#002060\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"1\" alt=\"\"></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<br>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"546\">\n\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<td width=\"23\">\n\t\t\t\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"1\" alt=\"\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"498\">\n\t\t\t\t\t\t<font size=\"2\" face=\"Arial\">Proporcione la informacion solicitada y posteriormente de clic en el botón &quot;Generar Reporte&quot;.    Para salir de clic en el botón &quot;Regresar&quot;.</font>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"24\">\n\t\t\t\t\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"1\" alt=\"\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<hr><br>\n\t\t</td>\n\t</tr>\n\t<tr valign=\"top\">\n\t\t<td width=\"546\"><center>\n\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr valign=\"top\">\n\t\t\t\t\t<td width=\"91\">\n\t\t\t\t\t\t<div align=\"center\">\n\t\t\t\t\t\t<b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">De:</font></b>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"173\">\n\t\t\t\t\t\t<INPUT name=\"inicioR\" value=\"\" onfocus=\"blur();\" onclick=\"document.forms.reporteEst.inicioR.value=''\" class=\"blue100\">\n\t\t\t\t\t\t<A><IMG alt=\"\" src=\"../Imagenes/act_calFormat.gif\" border=\"0\" onclick='show_calendar(\"forms[0].inicioR\");'></A>\n\t\t\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"90\">\n\t\t\t\t\t\t<div align=\"center\">\n\t\t\t\t\t\t<b><FONT face=\"Arial\" color=\"#004080\" size=\"2\">A:</font></b>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"174\">\n\t\t\t\t\t\t<INPUT name=\"finR\" value=\"\" onfocus=\"blur();\" onclick=\"document.forms.reporteEst.finR.value=''\" class=\"blue100\">\n\t\t\t\t\t\t<A><IMG alt=\"\" src=\"../Imagenes/act_calFormat.gif\" border=\"0\" onclick='show_calendar(\"forms[0].finR\");'></A>\n\t\t\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</center><br><hr><br>\n\t\t</td>\n\t</tr>\n</table>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr valign=\"top\">\n\t\t<td width=\"144\"><a href=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\"> <IMG border=\"0\"\n\t\t\tsrc=\"../Imagenes/NavLeft.gif\"> </a></td>\n\t\t<td width=\"108\"><a onclick=\"window.open('../RporTipDocto?id_rep=".toCharArray();
    __oracle_jsp_text[15] = 
    "&tip=AnalisisPorEstatus&tit=".toCharArray();
    __oracle_jsp_text[16] = 
    "&area=".toCharArray();
    __oracle_jsp_text[17] = 
    "');\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/ic_pdf.gif\" alt=\"Exportar a PDF\"></a></td>\n\t\t<td width=\"144\"><a onclick=\"window.open('../ReportExcel?id_rep=".toCharArray();
    __oracle_jsp_text[18] = 
    "&tip=AnalisisPorEstatusExcel&tit=".toCharArray();
    __oracle_jsp_text[19] = 
    "&area=".toCharArray();
    __oracle_jsp_text[20] = 
    "');\">\n\t\t\t<IMG border=\"0\" src=\"../Imagenes/ic_excel.gif\" alt=\"Exportar a Excel\"></a></td>\n\t\t<td width=\"227\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</tr>\n</table>\n<BR>\n<table border=\"1\">\n<tr valign=\"top\">\n\t<td width=\"762\" bgcolor=\"#002060\">\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t<tr valign=\"top\">\n\t\t\t<td width=\"511\">\n\t\t\t\t<b><font size=\"2\" color=\"#FFFFFF\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[21] = 
    "<BR>".toCharArray();
    __oracle_jsp_text[22] = 
    "</font></b>\n\t\t\t</td>\n\t\t\t<td width=\"250\">\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t</td>\n</tr>\n<tr valign=\"top\">\n\t<td width=\"762\" height=\"100\">\n\t\t<div align=\"center\">\n\t\t\t<TABLE BORDER=1>\n\t\t\t\t<TR VALIGN=top ALIGN=center VALIGN=middle>\n\t\t\t\t\t<TD WIDTH=\"500\" BGCOLOR=\"002060\" ROWSPAN=3 VALIGN=middle>\n\t\t\t\t\t\t<DIV ALIGN=center>\n\t\t\t\t\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\">Tipo de Documento</FONT>\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD WIDTH=\"359\" BGCOLOR=\"002060\" COLSPAN=2>\n\t\t\t\t\t\t<DIV ALIGN=center>\n\t\t\t\t\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\">Estatus</FONT>\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t\t<TR VALIGN=top VALIGN=middle>\n\t\t\t\t\t<TD WIDTH=\"179\" BGCOLOR=\"002060\" COLSPAN=1>\n\t\t\t\t\t\t<DIV ALIGN=center>\n\t\t\t\t\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\">Tramite</FONT>\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD WIDTH=\"180\" BGCOLOR=\"002060\" COLSPAN=1>\n\t\t\t\t\t\t<DIV ALIGN=center>\n\t\t\t\t\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\">Terminado</FONT>\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t\t<TR VALIGN=top VALIGN=middle>\n\t\t\t\t\t<TD WIDTH=\"179\" BGCOLOR=\"002060\" COLSPAN=1>\n\t\t\t\t\t\t<DIV ALIGN=center>\n\t\t\t\t\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\">NV / V</FONT>\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD WIDTH=\"180\" BGCOLOR=\"002060\" COLSPAN=1>\n\t\t\t\t\t\t<DIV ALIGN=center>\n\t\t\t\t\t\t\t<FONT SIZE=2 COLOR=\"FFFFFF\" FACE=\"Arial\">NV / V</FONT>\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>\n\t\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t\t<TABLE border=\"1\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t<TR VALIGN=top>\n\t\t\t\t\t<TD width=\"490\">\n\t\t\t\t\t\t<DIV ALIGN=center>\n\t\t\t\t\t\t\t<FONT SIZE=2  FACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[24] = 
    "</FONT>\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t\t<!-- <TD width=\"122\">\n\t\t\t\t\t\t<DIV ALIGN=center>\n\t\t\t\t\t\t\t<FONT SIZE=2  FACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[26] = 
    "</FONT>\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD> -->".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t<TD width=\"179\">\n\t\t\t\t\t\t<DIV ALIGN=center>\n\t\t\t\t\t\t\t<FONT SIZE=2  FACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[28] = 
    " / ".toCharArray();
    __oracle_jsp_text[29] = 
    "</FONT>\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t\t<TD width=\"180\">\n\t\t\t\t\t\t<DIV ALIGN=center>\n\t\t\t\t\t\t\t<FONT SIZE=2  FACE=\"Arial\">".toCharArray();
    __oracle_jsp_text[31] = 
    " / ".toCharArray();
    __oracle_jsp_text[32] = 
    "</FONT>\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t</TD>".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t</TR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t</TABLE>\n\t\t</div>\n\t</td>\n</tr>\n</table>\n</div>\n<br>\n<DIV align=\"center\">\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<tr valign=\"top\">\n\t<td width=\"66\">\n\t\t<div align=\"right\">\n\t\t\t<b><font size=\"2\" face=\"Arial\">Nota:</font></b>\n\t\t</div>\n\t</td>\n\t<td width=\"348\">\n\t\t<b><font size=\"2\" face=\"Arial\">&quot;V&quot;</font></b>\n\t\t\t<font size=\"2\" face=\"Arial\"> indica que son documentos vencidos </font>\n\t</td>\n</tr>\n<tr valign=\"top\">\n\t<td width=\"66\">\n\t\t<img src=\"../Imagenes/ecblank.gif\" border=\"0\" height=\"1\" width=\"1\" alt=\"\">\n\t</td>\n\t<td width=\"348\">\n\t\t<b><font size=\"2\" face=\"Arial\">&quot;NV&quot;</font></b>\n\t\t<font size=\"2\" face=\"Arial\"> indica que son documentos no vencidos</font>\n\t</td>\n</tr>\n</table>\n</DIV>\n\n<!-- Sección del applet de las graficas --> <br>\n<DIV align=\"center\">\n<TABLE>\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD>".toCharArray();
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
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD>".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[55] = 
    " <!-- FIn Sección del applet de las graficas -->\n\n</FORM>\n</BODY>\n\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
