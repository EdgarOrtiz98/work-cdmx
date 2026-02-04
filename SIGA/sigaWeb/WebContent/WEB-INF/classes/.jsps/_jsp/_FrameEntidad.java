package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.Utilerias;
import com.meve.sigma.taglib.*;
import com.meve.sigma.beans.*;
import java.util.*;


public class _FrameEntidad extends com.orionserver.http.OrionHttpJspPage {


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
    _FrameEntidad page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strProcedencia 				=   "";
          String strIdArea 					= 	"";
      	String strGral						=	"";
      	String strInterna					=	"";
      	String strArea						=	"";
      	String strb							=	"";
      	String a							=	"1";
      	String c							=	"0";
      	
      	String strEntidad					=	"";
      	String strEntidadClasificacion		=	"";
      	String strEntidadDireccion			=	"";
      	String strEntidadTel				=	"";
      	String strCreador					=	"";
      	String strFechaCreacion				=	"";
      	String strAccion					=	"";
      	String strEstatus					=	"1";
      	String strIdEntidad					=	null;
      	String strIdAsunto					=	"";
      	String strTipo						=	"";
      	String strBusqueda					=	"";
      	String strOrden 					=	"";
      	String num							=	"";
      	String strRefEntidad				=	"";
      	int valida 							= 	-2;
      	
      	String strDatosEntidadArea[][]		=	null;
      	
      	boolean	bExisteReg 		= 	false;
      	boolean bInsertar		=	false;
      	strProcedencia			=	request.getParameter("porcedencia");
      	strIdArea 				= 	request.getParameter("id_us");
      	strGral					=	request.getParameter("gral");
      	strInterna				=	request.getParameter("int");
      	strb					=	request.getParameter("b");
      	num 					=	request.getParameter("num");
      	strRefEntidad			=	(request.getParameter("refEntidad")!=null)?request.getParameter("refEntidad"):"";
      	strAccion				=	request.getParameter("accion");
      	strOrden		 		= 	(request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	strTipo 				= 	(request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      	strIdAsunto 			= 	(request.getParameter("ida")!=null)?request.getParameter("ida"):"";
      	strBusqueda				= 	(request.getParameter("buscar")!=null)?request.getParameter("buscar"):"";
      	String retURI 			= 	(request.getParameter("retURI")!=null)?request.getParameter("retURI"):"portalPrincipal.jsp";
      	String strIdEntidadRef = "";
      	StringTokenizer refEntToken = new StringTokenizer(strRefEntidad,"|");
      	if (refEntToken.countTokens()>0){
      		strIdEntidadRef = refEntToken.nextToken();
      	}
      		
      	boolean bBuscar 	= Utilerias.detectaCEBuscar(strBusqueda)?true:false;
      	strBusqueda 		= Utilerias.detectaCEBuscar(strBusqueda)?"":strBusqueda;
      	
      	if(strIdArea != null && strIdArea.length() > 0){
      		strDatosEntidadArea		=	ActualizaEntidad.getEntidadArea(strIdArea);
      	}
      	bExisteReg				=	ActualizaEntidad.getExisteEntidad();
      	
      	//Sección de la alta de una entidad
      	if(strAccion != null && strAccion.equals("guardar")){
      		strEntidad				=	request.getParameter("entidad");
      		strIdArea				=	request.getParameter("entidadArea");
      		strEntidadClasificacion	=	request.getParameter("entidadClasificacion");
      		strEntidadDireccion		=	request.getParameter("direccion");
      		strEntidadTel			=	request.getParameter("tel");
      
      		valida = ActualizaEntidad.getEntidadExiste(strEntidad, "1a2b3c", strIdArea, "1a2b3c");
      
      		if (valida == 2)
      		{
      			bInsertar	=	ActualizaEntidad.InsertarEntidad(	strIdEntidad, strEntidad, strIdArea, strEntidadClasificacion,
      																strEntidadDireccion, strEntidadTel, 
      																BUsuario.getIdUsuario(), strFechaCreacion, strEstatus);
      			String strIdEnt = "0";
      			if(bInsertar)
      				strIdEnt = ActualizaEntidad.ultimoIdEntidad();
      			
      out.write(__oracle_jsp_text[4]);
      if("receptor".equals(strProcedencia)){
      out.write(__oracle_jsp_text[5]);
      out.print( retURI );
      out.write(__oracle_jsp_text[6]);
      }else{ 
      out.write(__oracle_jsp_text[7]);
      out.print( "FrameEntidad.jsp?id_us="+ strIdArea +"&b=0&refEntidad="+strIdEnt+"|"+strEntidad+"/0" );
      out.write(__oracle_jsp_text[8]);
      }
      out.write(__oracle_jsp_text[9]);
      
      		}
      	}//Fin Sección de la alta de una entidad
      
      out.write(__oracle_jsp_text[10]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[11]);
      out.print(num);
      out.write(__oracle_jsp_text[12]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[13]);
      out.print(num);
      out.write(__oracle_jsp_text[14]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[15]);
      out.print(num);
      out.write(__oracle_jsp_text[16]);
      out.print(Utilerias.codificaPostHTML("FrameEntidad.jsp?int=1&id_us="+ strIdArea +"&b="+strb+"&num="+num+"&refEntidad="+strRefEntidad));
      out.write(__oracle_jsp_text[17]);
      out.print( strIdArea );
      out.write(__oracle_jsp_text[18]);
      out.print(strInterna);
      out.write(__oracle_jsp_text[19]);
      out.print(num);
      out.write(__oracle_jsp_text[20]);
      out.print(strb);
      out.write(__oracle_jsp_text[21]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[22]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[23]);
      out.print( retURI );
      out.write(__oracle_jsp_text[24]);
      out.print( strIdEntidadRef );
      out.write(__oracle_jsp_text[25]);
      out.print( strProcedencia );
      out.write(__oracle_jsp_text[26]);
      if(!strb.equals("2")){
      out.write(__oracle_jsp_text[27]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[28]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[29]);
      out.print( strBusqueda );
      out.write(__oracle_jsp_text[30]);
       if(strIdArea != null && strIdArea.length() > 0 && strb.equals("0")){ 
      out.write(__oracle_jsp_text[31]);
       }else if(strInterna != null && strInterna.length() > 0 &&  strInterna.equals("1")){ 
      out.write(__oracle_jsp_text[32]);
      }
      out.write(__oracle_jsp_text[33]);
      }
      out.write(__oracle_jsp_text[34]);
       if(bExisteReg){ 
      out.write(__oracle_jsp_text[35]);
       if(strIdArea != null && strIdArea.length() > 0 && strb.equals("0")){ 
      out.write(__oracle_jsp_text[36]);
      if(ActualizaEntidad.getEntidadGralExt(strIdArea,strBusqueda, strOrden).length!=0){
      out.write(__oracle_jsp_text[37]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaEntidad.getEntidadGralExt(strIdArea,strBusqueda, strOrden));
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
            out.write(__oracle_jsp_text[38]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[39]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[40]);
            out.print(c);
            out.write(__oracle_jsp_text[41]);
            out.print( (strRefEntidad.equals(campo1+"|"+campo2+"/"+c))?"checked=\"checked\"":"");
            out.write(__oracle_jsp_text[42]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[43]);
            out.print( Utilerias.recortaString(campo2,100) );
            out.write(__oracle_jsp_text[44]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[45]);
      }
      out.write(__oracle_jsp_text[46]);
       }else if(strInterna != null && strInterna.length() > 0 &&  strInterna.equals("1")){ 
      out.write(__oracle_jsp_text[47]);
      if(ActualizaEntidad.getEntidadesInternas(strBusqueda, strOrden, strTipo).length!=0){
      out.write(__oracle_jsp_text[48]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_2=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setDatos(ActualizaEntidad.getEntidadesInternas(strBusqueda, strOrden, strTipo));
        __jsp_taghandler_2.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_2,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[49]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[50]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[51]);
            out.print( a );
            out.write(__oracle_jsp_text[52]);
            out.print( (strRefEntidad.equals(campo1+"|"+campo2+"/"+a))?"checked=\"checked\"":"");
            out.write(__oracle_jsp_text[53]);
            if(campo3.equals("No")){
            out.write(__oracle_jsp_text[54]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[55]);
            out.print( Utilerias.recortaString(campo2,80) );
            out.write(__oracle_jsp_text[56]);
            }else{
            out.write(__oracle_jsp_text[57]);
            out.print( campo2 );
            out.write(__oracle_jsp_text[58]);
            out.print( Utilerias.recortaString(campo2,80) );
            out.write(__oracle_jsp_text[59]);
            }
            out.write(__oracle_jsp_text[60]);
            if(campo3.equals("No")){
            out.write(__oracle_jsp_text[61]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[62]);
            }else{
            out.write(__oracle_jsp_text[63]);
            out.print( campo3 );
            out.write(__oracle_jsp_text[64]);
            }
            out.write(__oracle_jsp_text[65]);
          } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[66]);
      }
      out.write(__oracle_jsp_text[67]);
      }
      out.write(__oracle_jsp_text[68]);
      }else{
      out.write(__oracle_jsp_text[69]);
       } 
      out.write(__oracle_jsp_text[70]);
      if(strb.equals("2")){
      out.write(__oracle_jsp_text[71]);
      out.print( retURI );
      out.write(__oracle_jsp_text[72]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getAreasCombo(strIdArea));
        __jsp_taghandler_3.setName("entidadArea");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_3.setClassHtml("blue500a");
        __jsp_taghandler_3.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_3.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_3.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[73]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[74]);
      } 
      out.write(__oracle_jsp_text[75]);
      out.print( strEntidad  );
      out.write(__oracle_jsp_text[76]);
      out.print((strEntidadClasificacion.trim().equals("Privada")?"selected":""));
      out.write(__oracle_jsp_text[77]);
      out.print((strEntidadClasificacion.trim().equals("Pública")?"selected":""));
      out.write(__oracle_jsp_text[78]);
      out.print( strEntidadDireccion  );
      out.write(__oracle_jsp_text[79]);
      out.print( strEntidadTel  );
      out.write(__oracle_jsp_text[80]);
      }
      out.write(__oracle_jsp_text[81]);
      out.print( bBuscar );
      out.write(__oracle_jsp_text[82]);

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
  private static final char __oracle_jsp_text[][]=new char[83][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\t\t\t<SCRIPT language=JavaScript type=text/javascript>\n\t\t\t{\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[5] = 
    "\n\t\t\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[6] = 
    "');\n\t\t\t".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\t\t\t    location.assign('".toCharArray();
    __oracle_jsp_text[8] = 
    "');\n\t\t\t".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\t}\n\t\t\t</SCRIPT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Entidad</TITLE>\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\n\tfunction verGrales(){\n\t\tlocation.assign('FrameEntidad.jsp?gral=0&id_us=".toCharArray();
    __oracle_jsp_text[11] = 
    "&b=1&num=".toCharArray();
    __oracle_jsp_text[12] = 
    "');\n\t}\n\tfunction verInternas(){\n\t\tlocation.assign('FrameEntidad.jsp?int=1&id_us=".toCharArray();
    __oracle_jsp_text[13] = 
    "&b=1&num=".toCharArray();
    __oracle_jsp_text[14] = 
    "');\n\t}\n\tfunction verArea(){\n\t\tlocation.assign('FrameEntidad.jsp?id_us=".toCharArray();
    __oracle_jsp_text[15] = 
    "&b=0&num=".toCharArray();
    __oracle_jsp_text[16] = 
    "');\n\t}\n\tfunction verNuevaEntidad(idArea){\n\t\tlocation.assign('FrameEntidad.jsp?id_us='+idArea+'&b=2&retURI=".toCharArray();
    __oracle_jsp_text[17] = 
    "');\n\t}\n\tfunction cambio(o, t){\n\t\tdoc = document.frameentidad;\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\n</SCRIPT>\n \n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" \n\tonunload=\"opener.hay_hija=true\"\n\tonClick=\"opener.resetTimer();\"\n\tonKeyPress=\"opener.resetTimer();\">\n<form name=\"frameentidad\" action=\"FrameEntidad.jsp\" method=\"post\">\n         <p>\n            <input type=\"hidden\" value=\"\" name=\"accion\"/>\n            <input name=\"id_us\"  value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" type=\"hidden\"/>\n            <input name=\"gral\"   value=\"0\" type=\"hidden\"/>\n            <input name=\"int\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\"  type=\"hidden\"/>\n            <input name=\"area\" value=\"2\" type=\"hidden\"/>\n            <input name=\"num\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\"type=\"hidden\"/>\n            <input name=\"b\"   value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\"type=\"hidden\"/>\n            <input name=\"orden\"value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\"type=\"hidden\"/>\n            <input name=\"tipo\"value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\"type=\"hidden\"/>\n            <input name=\"retURI\"value=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\" type=\"hidden\"/>\n            <input name=\"idEntidadRef\"value=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\"type=\"hidden\"/>\n            <input name=\"porcedencia\"value=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\"type=\"hidden\"/>\n            ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n         </p>\n         <h2>\n            &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n            <font color=\"#2121ff\" face=\"Arial\">\n               <strong><em>Directorio</em></strong>\n            </font>\n         </h2>\n         <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\n\t<tr valign=\"top\">\n\t\t<td width=\"15%\">\n\t\t\t<div align=\"left\">\n\t\t\t\t<input type=\"button\" onclick=\"verInternas()\" value=\"U.A. de la SHCP\" class=\"blue100a\">\n\t\t\t</div>\n\t\t</td>\n\t\t<td width=\"15%\">\n\t\t\t<div align=\"center\">\n\t\t\t\t<input type=\"button\" onclick=\"verArea()\" value=\"Areas Externas\" class=\"blue100a\">\n\t\t\t</div>\n\t\t</td>\n\t\t\n\t\t<td width=\"20%\">&nbsp;\n\n\t\t</td>\n\t\t<td width=\"50%\">\n\t\t\t<div align=\"right\">\n\t\t\t\t<input type=\"button\" onclick=\"verNuevaEntidad(".toCharArray();
    __oracle_jsp_text[28] = 
    ")\" value=\"Otra Entidad...\" class=\"blue100a\">\n\t\t\t\t<input type=\"button\" onclick=\"AceptarEntidadFrame(".toCharArray();
    __oracle_jsp_text[29] = 
    ")\" value=\"Aceptar\" class=\"blue100a\">\n\t\t\t\t<input type=\"button\" value=\"Cancelar\" class=\"blue100a\" onclick=\"Cancelar()\">\n\t\t\t</div>\n\t\t</td>\n\t</tr>\n</table>\n<div align=\"left\">\nBuscar: &nbsp;\n<INPUT name=\"buscar\" type=\"text\" value=\"".toCharArray();
    __oracle_jsp_text[30] = 
    "\" class=\"blue200\" maxlength=\"199\">\n<A title=\"Buscar\" onclick=\"buscarEntidad();\"><IMG border=\"0\" src=\"../Imagenes/ico_bus.gif\" width=\"26\" height=\"26\" ></A><br>\n</div>\n".toCharArray();
    __oracle_jsp_text[31] = 
    "\n<BR>\n<table width=\"100%\" border=\"0\">\n\t<tr BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='100%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tEntidades de la Unidad Administrativa\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t</tr>\n</table>\n".toCharArray();
    __oracle_jsp_text[32] = 
    "\n<br>\n<TABLE WIDTH='100%' BORDER=0>\n\t<TR BGCOLOR=\"00204F\">\n\t\t<TD WIDTH='80%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tUnidad Administrativa\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t\t<TD WIDTH='20%' align=\"center\">\n\t\t\t<FONT SIZE=1 COLOR=\"FFFFFF\" FACE=\"verdana\">\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\tOperando en SIGA\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</font>\n\t\t</TD>\n\t</TR>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[33] = 
    "\n".toCharArray();
    __oracle_jsp_text[34] = 
    "\n".toCharArray();
    __oracle_jsp_text[35] = 
    "\n<DIV class=documentBody id=Body>\n".toCharArray();
    __oracle_jsp_text[36] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<TD width=\"5%\">\n\t\t\t\t\t\t<INPUT type=\"radio\" value=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "|".toCharArray();
    __oracle_jsp_text[40] = 
    "/".toCharArray();
    __oracle_jsp_text[41] = 
    "\" name=\"Sel\" ".toCharArray();
    __oracle_jsp_text[42] = 
    ">\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD width=\"95%\">\n\t\t\t\t\t\t<!-- <IMG height=1 src=\"../Imagenes/ecblank.gif\" width=16 border=0> -->\n\t\t\t\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[43] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[44] = 
    " </A>\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n</TABLE>\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n".toCharArray();
    __oracle_jsp_text[47] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<TD width=\"80%\">\n\t\t\t\t\t\t<INPUT type=\"radio\" value=\"".toCharArray();
    __oracle_jsp_text[50] = 
    "|".toCharArray();
    __oracle_jsp_text[51] = 
    "/".toCharArray();
    __oracle_jsp_text[52] = 
    "\" name=\"Sel\" ".toCharArray();
    __oracle_jsp_text[53] = 
    ">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t\t\t\t<FONT face=Arial color=\"red\" size=1>\n\t\t\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[55] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[56] = 
    " </A>\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t\t\t\t<FONT face=Arial color=\"#000080\" size=1>\n\t\t\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[58] = 
    "\"> ".toCharArray();
    __oracle_jsp_text[59] = 
    " </A>\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t\t<TD width=\"20%\" align=\"center\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t\t\t\t\t<FONT face=Arial color=\"red\" size=1>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t\t\t\t<FONT face=Arial color=\"#000080\" size=1>\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n</TABLE>\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n".toCharArray();
    __oracle_jsp_text[68] = 
    "\n".toCharArray();
    __oracle_jsp_text[69] = 
    "\n<CENTER>\n<table cellspacing=\"2\" cellpadding=\"2\">\n\t<tr>\n\t\t<TD align=\"center\">\n\t\t\t<DIV align=\"center\">\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">***** No se han encontrado Entidades *****</FONT>\n\t\t\t</DIV>\n\t\t</TD>\n\t</tr>\n</table>\n</CENTER>\n".toCharArray();
    __oracle_jsp_text[70] = 
    "\n".toCharArray();
    __oracle_jsp_text[71] = 
    "\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"150\">\n\t\t\t<!-- <a onclick=\"verInternas()\"> -->\n\t\t\t<a href=\"".toCharArray();
    __oracle_jsp_text[72] = 
    "\">\n\t\t\t<img src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\" border=\"0\">\n\t\t\t</a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a onclick=\"guardarEntidadOtro1()\">\n\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\"  border=\"0\">\n\t\t\t</a>\n\t\t&nbsp;</TD>\n\t\t<TD width=\"150\">\n\n\t\t&nbsp;</TD>\n\t\t<TD width=\"150\">&nbsp;</TD>\n\t\t<TD width=\"217\">&nbsp;</TD>\n\t</TR>\n</TBODY>\n</TABLE>\n</DIV>\n<BR>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n<TR valign=\"top\">\n<TD width=\"336\" colspan=\"2\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Entidad</FONT></B></TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<td width=\"672\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n        </TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT>\n\t\t</TD>\n\t\t<TD width=\"528\" align=\"right\" colspan=\"3\">&nbsp;</td>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"192\">&nbsp;</TD>\n    </TR>\n\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Unidad Administrativa:</B></FONT></TD>\n<TD width=\"528\" colspan=\"3\">\n\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t</FONT>\n</TD>\n</TR>\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\"><B>Entidad:</B></FONT>\n".toCharArray();
    __oracle_jsp_text[74] = 
    "<br>\n<FONT color=\"red\"><B>*Esta Entidad ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[75] = 
    "\n</TD>\n<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n<INPUT class=\"blue500\" name=\"entidad\" value=\"".toCharArray();
    __oracle_jsp_text[76] = 
    "\" maxlength=\"199\"></FONT></TD>\n</TR>\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Clasificación:</FONT></TD>\n<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t<SELECT name=\"entidadClasificacion\" class=\"blue200a\">\n\t\t<OPTION value=\"Privada\" ".toCharArray();
    __oracle_jsp_text[77] = 
    ">Privada</OPTION>\n\t\t<OPTION value=\"Pública\" ".toCharArray();
    __oracle_jsp_text[78] = 
    ">Pública</OPTION>\n\t</SELECT>\n\t</FONT></TD>\n</TR>\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n\n\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Dirección:</FONT></TD>\n<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\">\n\t<TEXTAREA class=\"blue500\" name=\"direccion\" rows=\"3\"\n\t\tonKeyDown=\"limitaTextArea(document.frameentidad.direccion,'Dirección','200')\";>".toCharArray();
    __oracle_jsp_text[79] = 
    "</TEXTAREA> \n</FONT></TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">Teléfono:</FONT></TD>\n<TD width=\"528\" colspan=\"3\"><FONT face=\"Arial\" size=\"2\"><INPUT class=\"blue500\" name=\"tel\" value=\"".toCharArray();
    __oracle_jsp_text[80] = 
    "\" maxlength=\"199\"></FONT></TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"672\" colspan=\"4\">&nbsp;</TD>\n        </TR>\n    </TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[81] = 
    "\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\tif (".toCharArray();
    __oracle_jsp_text[82] = 
    ")\n\t\talert(\"No se permiten caracteres especiales ( % , & , \\' ) en la Busqueda \"+ \"\\n\");\n</SCRIPT>\n</form>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
