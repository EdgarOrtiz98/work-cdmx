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


public class _IcddArch extends com.orionserver.http.OrionHttpJspPage {


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
    _IcddArch page = this;
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
       if(!BUsuario.getAdmon() && !BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[7]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[8]);
       } 
      out.write(__oracle_jsp_text[9]);
      
      	String msg = "";
      	String strIdSubfondo	=	"";
      	String strSeries[]		=	null;
      	String strSubSeries[]	=	null;
      	String strSeriesIds		=	"";
      	String strSubSeriesIds	=	"";
      	String strUsrActualiza	=	"";
      	String strFecha			=	"";
      	String strFechaicdd		=	"";
      	String strAccion		=	"";
      	String strClave			=	"";
      	String strIdArea 		= 	(request.getParameter("idArea")!= null)?request.getParameter("idArea"):"";
      	String strSeccion		= 	(request.getParameter("secciona")!= null)?request.getParameter("secciona"):"";	
      	String strInact			=	"";
      	String strFecInac		=	"";
      	String strJustInac		=	"";
      	String ver				=	"";
      	String horafec			=	"";
      
      	String strAux = "1234567";
      
      		int valida		=	0;	
      	boolean bInsertar	=	false;
      	int bInsertar1		=	0;	
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha						=	sdf.format(f);
      
      	String retURI = (request.getParameter("retURI")==null)?"Icddview.jsp":request.getParameter("retURI");
      	strAccion		=	request.getParameter("accion");
      	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			strSeccion	 =	request.getParameter("secciona");
      			strIdArea 	 = 	request.getParameter("idArea");
      			strSeries	 =	request.getParameterValues("series");
      			strSubSeries =	request.getParameterValues("subseries");
      			strFechaicdd =  request.getParameter("fecinicio");
      			
      			bInsertar1	=	ActualizaExpArchivado.insertarIcdd(strIdArea, strSeccion,
      															strFechaicdd, BUsuario.getIdUsuario(), strSeries, strSubSeries);
      			if(bInsertar1 == 2)
      			{
      			//msg ="La clave ya existe";
      			}
      			else{
      				try{
      					//response.sendRedirect("Icddview.jsp");
      					response.sendRedirect(retURI);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strSeccion	 =	request.getParameter("secciona");
      			strIdArea 	 = 	request.getParameter("idArea");
      			strSeries	 =	request.getParameterValues("series");
      			strSubSeries =	request.getParameterValues("subseries");
      			strFechaicdd =  request.getParameter("fecinicio");
      			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
      			strFecInac	=	request.getParameter("fecinact");
      			strJustInac =	request.getParameter("justif");	
      			 
      			strClave	=	request.getParameter("clave");
      			strAux 		= 	request.getParameter("aux"); 
      						
      			bInsertar1 = ActualizaExpArchivado.actualizaIcdd(strSeries, strSubSeries, strFechaicdd, 
      															strIdSubfondo, strFecInac, strJustInac, 
      															strInact, BUsuario.getIdUsuario());
      			if(bInsertar1 != 2){
      				try{
      					//response.sendRedirect("Icddview.jsp");
      					response.sendRedirect(retURI);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}
      	}
      	
      	if(strSeccion != null && strSeccion.trim().length()>0)
      	{
      	String strDatosDate[][] = ActualizaExpArchivado.getDate();
      	strFechaicdd		=	strDatosDate[0][0];
      	}
      	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	{
      		String strDatosSubfondo[][] = ActualizaExpArchivado.getIcddId(strIdSubfondo);
      		strIdArea		=	strDatosSubfondo[0][0];
      		strSeccion		=	strDatosSubfondo[0][1];
      		strFecha		=	strDatosSubfondo[0][2];
      		strSeriesIds	=	strDatosSubfondo[0][3];
      		strSubSeriesIds	=	strDatosSubfondo[0][4];
      		strFechaicdd	=	strDatosSubfondo[0][5];
      		strFecInac		=	strDatosSubfondo[0][6];	
      		strJustInac		=	strDatosSubfondo[0][7];	
      		strInact		=	strDatosSubfondo[0][8];	
      		horafec			=	strDatosSubfondo[0][9];
      		strUsrActualiza	=	strDatosSubfondo[0][10];
      		strAux			=  	strClave;		
      		ver				=	"si";
      		
      	//	valida	=	ActualizaExpArchivado.getValidaSeccion(strIdSubfondo);		
      	}
      
      out.write(__oracle_jsp_text[10]);
      if(valida == 2) 
      	{
      out.write(__oracle_jsp_text[11]);
      
      	}
      out.write(__oracle_jsp_text[12]);
      out.print(horafec);
      out.write(__oracle_jsp_text[13]);
      out.print(strIdSubfondo);
      out.write(__oracle_jsp_text[14]);
      out.print(strAux);
      out.write(__oracle_jsp_text[15]);
      out.print(retURI);
      out.write(__oracle_jsp_text[16]);
      out.print( retURI );
      out.write(__oracle_jsp_text[17]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[18]);
      	}else{
      out.write(__oracle_jsp_text[19]);
      }
      out.write(__oracle_jsp_text[20]);
       if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[21]);
      out.print(ActualizaUsuario.NombreUsuario(strUsrActualiza));
      out.write(__oracle_jsp_text[22]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[23]);
       }else{ 
      out.write(__oracle_jsp_text[24]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[25]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[26]);
       } 
      out.write(__oracle_jsp_text[27]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)){
      out.write(__oracle_jsp_text[28]);
       if(BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[29]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo());
        __jsp_taghandler_1.setName("idArea");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_1.setDisabled(true);
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("");
        __jsp_taghandler_1.setTextoNoSeleccion("---------- Selecciona un opción ----------");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[30]);
      }else{
      out.write(__oracle_jsp_text[31]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasCombo());
        __jsp_taghandler_2.setName("idArea");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_2.setDisabled(true);
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setScript("");
        __jsp_taghandler_2.setTextoNoSeleccion("---------- Selecciona un opción ----------");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[32]);
      }
      out.write(__oracle_jsp_text[33]);
      }else{
      out.write(__oracle_jsp_text[34]);
       if(BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[35]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getAreasCombo());
        __jsp_taghandler_3.setName("idArea");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_3.setClassHtml("blue500");
        __jsp_taghandler_3.setScript("");
        __jsp_taghandler_3.setTextoNoSeleccion("---------- Selecciona un opción ----------");
        __jsp_taghandler_3.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[36]);
      }
      			else{
      out.write(__oracle_jsp_text[37]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getAreasCombo());
        __jsp_taghandler_4.setName("idArea");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_4.setClassHtml("blue500");
        __jsp_taghandler_4.setScript("");
        __jsp_taghandler_4.setTextoNoSeleccion("---------- Selecciona un opción ----------");
        __jsp_taghandler_4.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[38]);
      }
      out.write(__oracle_jsp_text[39]);
      }
      out.write(__oracle_jsp_text[40]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){
      out.write(__oracle_jsp_text[41]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[42]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_5=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setData(ComboData.getSeccionComboA());
        __jsp_taghandler_5.setName("secciona");
        __jsp_taghandler_5.setSize(1);
        __jsp_taghandler_5.setSelected(OracleJspRuntime.toStr( strSeccion));
        __jsp_taghandler_5.setDisabled(true);
        __jsp_taghandler_5.setClassHtml("blue500a");
        __jsp_taghandler_5.setScript("onchange='claved()'");
        __jsp_taghandler_5.setTextoNoSeleccion(" ------------ Seleccione una Sección------------ ");
        __jsp_taghandler_5.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[43]);
      }
      					else {
      out.write(__oracle_jsp_text[44]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_6=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setData(ComboData.getSeccionComboA());
        __jsp_taghandler_6.setName("secciona");
        __jsp_taghandler_6.setSize(1);
        __jsp_taghandler_6.setSelected(OracleJspRuntime.toStr( strSeccion));
        __jsp_taghandler_6.setDisabled(true);
        __jsp_taghandler_6.setClassHtml("blue500a");
        __jsp_taghandler_6.setScript("onchange='claved()'");
        __jsp_taghandler_6.setTextoNoSeleccion(" ------------ Seleccione una Sección------------ ");
        __jsp_taghandler_6.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[45]);
      }
      out.write(__oracle_jsp_text[46]);
      }else{
      out.write(__oracle_jsp_text[47]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[48]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_7=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setData(ComboData.getSeccionComboA());
        __jsp_taghandler_7.setName("secciona");
        __jsp_taghandler_7.setSize(1);
        __jsp_taghandler_7.setSelected(OracleJspRuntime.toStr( strSeccion));
        __jsp_taghandler_7.setClassHtml("blue500a");
        __jsp_taghandler_7.setScript("onchange='claved()'");
        __jsp_taghandler_7.setTextoNoSeleccion(" ------------ Seleccione una Sección------------ ");
        __jsp_taghandler_7.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[49]);
      }
      					else {
      out.write(__oracle_jsp_text[50]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_8=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setData(ComboData.getSeccionComboA());
        __jsp_taghandler_8.setName("secciona");
        __jsp_taghandler_8.setSize(1);
        __jsp_taghandler_8.setSelected(OracleJspRuntime.toStr( strSeccion));
        __jsp_taghandler_8.setClassHtml("blue500a");
        __jsp_taghandler_8.setScript("onchange='claved()'");
        __jsp_taghandler_8.setTextoNoSeleccion(" ------------ Seleccione una Sección------------ ");
        __jsp_taghandler_8.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      out.write(__oracle_jsp_text[51]);
      }
      out.write(__oracle_jsp_text[52]);
      }
      out.write(__oracle_jsp_text[53]);
       if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      					if (strSeriesIds != null && strSeriesIds.trim().length()>0){
      			
      out.write(__oracle_jsp_text[54]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_9=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_9.setParent(null);
        __jsp_taghandler_9.setDatos(ActualizaExpArchivado.getDatosSeccionIcddIds(strSeccion,strSeriesIds));
        __jsp_taghandler_9.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_9,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[55]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[56]);
            if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
            out.write(__oracle_jsp_text[57]);
            	}
            out.write(__oracle_jsp_text[58]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[59]);
            out.print( campo3);
            out.write(__oracle_jsp_text[60]);
          } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,1);
      }
      out.write(__oracle_jsp_text[61]);
      }
      					if (strSubSeriesIds != null && strSubSeriesIds.trim().length()>0){
      					
      out.write(__oracle_jsp_text[62]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_10=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_10.setParent(null);
        __jsp_taghandler_10.setDatos(ActualizaExpArchivado.getDatosSeccionIcddSubIds(strSeccion,strSubSeriesIds));
        __jsp_taghandler_10.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_10,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[63]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[64]);
            if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
            out.write(__oracle_jsp_text[65]);
            	}
            out.write(__oracle_jsp_text[66]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[67]);
            out.print( campo3);
            out.write(__oracle_jsp_text[68]);
          } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,1);
      }
      out.write(__oracle_jsp_text[69]);
      }
      			}else
      			{
      			if (strSeccion != null && strSeccion.trim().length()>0){
      out.write(__oracle_jsp_text[70]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_11=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_11.setParent(null);
        __jsp_taghandler_11.setDatos(ActualizaExpArchivado.getDatosSeccionIcdd(strSeccion,strIdArea));
        __jsp_taghandler_11.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_11,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[71]);
            if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
            out.write(__oracle_jsp_text[72]);
            	}
            out.write(__oracle_jsp_text[73]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[74]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[75]);
            out.print( campo3);
            out.write(__oracle_jsp_text[76]);
          } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,1);
      }
      out.write(__oracle_jsp_text[77]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_12=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_12.setParent(null);
        __jsp_taghandler_12.setDatos(ActualizaExpArchivado.getDatosSeccionIcddSub(strSeccion,strIdArea));
        __jsp_taghandler_12.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_12,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[78]);
            if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
            out.write(__oracle_jsp_text[79]);
            	}
            out.write(__oracle_jsp_text[80]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[81]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[82]);
            out.print( campo3);
            out.write(__oracle_jsp_text[83]);
          } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,1);
      }
      out.write(__oracle_jsp_text[84]);
      }
      			}
      out.write(__oracle_jsp_text[85]);
      out.print( strFechaicdd);
      out.write(__oracle_jsp_text[86]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[87]);
      	}
      out.write(__oracle_jsp_text[88]);
      if(strInact == "3" || strInact.equals("3")) 
      						{
      out.write(__oracle_jsp_text[89]);
      
      						}
      out.write(__oracle_jsp_text[90]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[91]);
      
      						}
      out.write(__oracle_jsp_text[92]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[93]);
      
      						}
      out.write(__oracle_jsp_text[94]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[95]);
      	}
      out.write(__oracle_jsp_text[96]);
      out.print(strFecInac);
      out.write(__oracle_jsp_text[97]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[98]);
      	}
      out.write(__oracle_jsp_text[99]);
      if(valida == 2) 
      					{
      out.write(__oracle_jsp_text[100]);
      
      					}
      out.write(__oracle_jsp_text[101]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[102]);
      
      					}
      out.write(__oracle_jsp_text[103]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[104]);
      	}
      out.write(__oracle_jsp_text[105]);
      out.print(strJustInac);
      out.write(__oracle_jsp_text[106]);

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
  private static final char __oracle_jsp_text[][]=new char[107][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    " \n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>ICDD Unidad Administrativa</TITLE>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\tfunction limpiarCampos(){\n\t//\tdocument.Icdd.reset();\n\t}\nfunction rValidando() {\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\talert(\"El registro consultado no puede ser modificado\");\n\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n}\t\nfunction claved() {\n\tdoc = document.Icdd;\n\tdoc.submit();\n}\n\tfunction habilita2()\n\t{\n\t\tif(document.Icdd.inactivo.checked == true)\n\t\t{\n\t\tdocument.Icdd.fecinact.value = \"".toCharArray();
    __oracle_jsp_text[13] = 
    "\";\n\t\tdocument.Icdd.fecinact.disabled = false;\n\t\tdocument.Icdd.justif.disabled = false;\n\t\t}else\n\t\t{\n\t\tdocument.Icdd.fecinact.value = \"\";\n\t\tdocument.Icdd.justif.value = \"\";\n\t\tdocument.Icdd.fecinact.disabled = true;\n\t\tdocument.Icdd.justif.disabled = true;\n\t\t}\n\t}\t\n</SCRIPT>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;rValidando();limpiarCampos();timer_load();\" \n\tonKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"IcddArch.jsp\" name=\"Icdd\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"id_sub\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"retURI\">\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"> </a>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t<a></a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\t\n\t\t\t\t<A><img src=\"../Imagenes/Save.gif\" alt=\"Guardar\"  border=\"0\" onclick=\"GuardarIcdd()\"></A> \n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t\n\t\t\t</TD>\n\t\t\t<TD width=\"125\"></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\"> \n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"234\" height=\"30\"><B><FONT face=\"Verdana\"\n\t\t\t\tcolor=\"#002850\" size=\"2\"></FONT><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><B><FONT size=\"+1\" color=\"#004080\">Clasificación de Instrumento por Unidad Administrativa</FONT></B></FONT></B></TD>\n\t\t\t<TD width=\"38\" height=\"30\">&nbsp;</TD>\n\t\t\t<TD width=\"400\" align=\"right\" height=\"30\">&nbsp;&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"234\" bgcolor=\"#004080\" height=\"2\"></TD>\n\t\t\t<TD width=\"38\" bgcolor=\"#004080\" height=\"2\"></TD>\n\t\t\t<TD width=\"400\" bgcolor=\"#004080\" height=\"2\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[22] = 
    " - ".toCharArray();
    __oracle_jsp_text[23] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[25] = 
    " - ".toCharArray();
    __oracle_jsp_text[26] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tUnidad Administrativa:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\t\t\n\t\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tSección - Fondo - Subfondo:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\t\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"></TD>\n\t\t\t<TD width=\"528\"><FONT color=\"#004080\"><B>Series  ::::  Subseries</B></FONT></TD>\n\t\t</TR>\t\t\n\n\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t<TD width=\"144\">\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD width=\"528\">\n\t\t\t\t\t\t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[56] = 
    "\" \n\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\t\n\t\t\t\t\t\t\tchecked name=\"series\">\n\t\t\t\t    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[59] = 
    " :::: ".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t\t    \t\t</FONT>\n\t\t\t\t    </TD>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[64] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\t\n\t\t\t\t\t checked name=\"subseries\">\n\t\t    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[67] = 
    " :::: ".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t    \t\t</FONT>\n\t\t    </TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\n\n\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">\n\t\t\t</TD> \n\t\t\t<TD width=\"528\">\n\t\t\t\t\t<INPUT type=checkbox \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\t\n\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[74] = 
    "\" name=\"series\">\n\t\t    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[75] = 
    " :::: ".toCharArray();
    __oracle_jsp_text[76] = 
    " \n\t\t    \t\t</FONT>\n\t\t    </TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t\t<INPUT type=checkbox \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\t\n\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[81] = 
    "\" name=\"subseries\">\n\t\t    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[82] = 
    " :::: ".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t    \t\t</FONT>\n\t\t    </TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFecha Inicio:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"fecinicio\" value=\"".toCharArray();
    __oracle_jsp_text[86] = 
    "\" \n\t\t\t\t\t\tonfocus=\"blur();\"\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\t\t\t\n\t\t\t\ttype=\"text\" class=\"blue100\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tInactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=checkbox onclick=\"habilita2();\" value=\"3\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t\t\t\t\t checked\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\t\n\t\t\t\tname=\"inactivo\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFecha Inactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"fecinact\" value=\"".toCharArray();
    __oracle_jsp_text[97] = 
    "\"\n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\t\n\t\t\t\ttype=\"text\" class=\"blue100\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tJustificacion:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<TEXTAREA name=\"justif\" id=\"justif\" rows=\"3\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.Icdd.justif,'Justificación','1000');\"\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[100] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[106] = 
    "</TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\t\t\t\t\n\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
