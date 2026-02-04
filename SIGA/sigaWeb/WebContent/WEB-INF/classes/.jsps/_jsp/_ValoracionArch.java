package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;


public class _ValoracionArch extends com.orionserver.http.OrionHttpJspPage {


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
    _ValoracionArch page = this;
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
      
      	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp=request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){;}
      	}
      
      out.write(__oracle_jsp_text[5]);
       if(!BUsuario.getAdmon() && !BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[6]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[7]);
       } 
      out.write(__oracle_jsp_text[8]);
      
      	String msg = "";
      	String strIdSubfondo	=	"";
      	String strCodigo		=	"";
      	String strSeccion		=	"";
      	String strUsrActualiza	=	"";
      	String strFecha			=	"";
      	String strAccion		=	"";
      	String strFondo		=	"";
      	String Val4  	=	"";
      	String Val1[]	=	null;
      	String Val2		=	"";
      	String Val3		=	"";
      	String strClave			=	"";
      	String strInact			=	"";
      	String strFecInac		=	"";
      	String strJustInac		=	"";	
      	String ver				=	"";		
      	String horafec			=	"";	
      	String strIds_guard[]	=	null;
      	String strsoloDesc 		=	"";
      
      	String strAux = "1234567";
      
      		int valida		=	0;	
      	boolean bInsertar		=	false;
      	int bInsertar1		=	0;	
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha						=	sdf.format(f);
      
      	strAccion		=	request.getParameter("accion");
      	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			Val1 =	request.getParameterValues("agregar");	
      			Val2 =	request.getParameter("agregar2");
      			Val3 =	request.getParameter("agregar3");
      			strClave	=	request.getParameter("clave"); 			
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo"); 
      			bInsertar1	=	 ActualizaExpArchivado.insertarValoracion(strCodigo, strSeccion,strFecha, BUsuario.getIdUsuario(),Val1,Val2,Val3,strClave,strAux);
      			if(bInsertar1 == 2){;}
      			else {
      				try{
      					response.sendRedirect("ValoracionArchview.jsp?msg="+msg);
      				}catch(java.io.IOException io){;}
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strsoloDesc =	request.getParameter("soloDesc");
      			strIds_guard =	request.getParameterValues("agregar");
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strClave	=	request.getParameter("clave"); 			
      			Val1 =	request.getParameterValues("agregar");
      			Val2 =	request.getParameter("agregar2");
      			Val3 =	request.getParameter("agregar3");
      			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
      			strFecInac	=	request.getParameter("fecinact");
      			strJustInac =	request.getParameter("justif");	
      			strAux 		= 	request.getParameter("aux"); 
      			bInsertar1 =  ActualizaExpArchivado.actualizaValoracion(strsoloDesc,strCodigo, strSeccion, strFecha, 
      															BUsuario.getIdUsuario(), strIdSubfondo,Val1,Val2,Val3,strClave,
      															strFecInac,strJustInac,strInact,strAux);
      
      			if(bInsertar1 != 2){
      				try{
      					response.sendRedirect("ValoracionArchview.jsp");
      				}catch(java.io.IOException io){;}
      			}
      		}
      	}
      	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	{
      		String strDatosSubfondo[][] =  ActualizaExpArchivado.getValoracion(strIdSubfondo);
      		strCodigo		=	strDatosSubfondo[0][0];
      		strSeccion		=	strDatosSubfondo[0][1];
      		strFecha		=	strDatosSubfondo[0][2];
      		strUsrActualiza	=	strDatosSubfondo[0][3];
      		Val4	=		strDatosSubfondo[0][4];
      		Val2	=		strDatosSubfondo[0][5];
      		Val3	=		strDatosSubfondo[0][6];	
      		strClave		=	strDatosSubfondo[0][7];	
      		strFecInac		=	strDatosSubfondo[0][8];	
      		strJustInac		=	strDatosSubfondo[0][9];	
      		strInact		=	strDatosSubfondo[0][10];	
      		horafec			=	strDatosSubfondo[0][11];
      		ver				=	"si";			
      		strAux			=  	strClave;				
      
      		valida	=	ActualizaExpArchivado.getValidaValoraciones(strIdSubfondo);		
      	}
      
      out.write(__oracle_jsp_text[9]);
      if(valida == 2) 
      	{
      out.write(__oracle_jsp_text[10]);
      
      	}
      out.write(__oracle_jsp_text[11]);
      out.print(horafec);
      out.write(__oracle_jsp_text[12]);
      out.print(strIdSubfondo);
      out.write(__oracle_jsp_text[13]);
      out.print(strAux);
      out.write(__oracle_jsp_text[14]);
      if(valida == 2){
      		strsoloDesc = "1";
      	}
      	
      out.write(__oracle_jsp_text[15]);
      out.print(strsoloDesc);
      out.write(__oracle_jsp_text[16]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[17]);
      	}else{
      out.write(__oracle_jsp_text[18]);
      }
      out.write(__oracle_jsp_text[19]);
       if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[20]);
      out.print(ActualizaUsuario.NombreUsuario(strUsrActualiza));
      out.write(__oracle_jsp_text[21]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[22]);
       }else{ 
      out.write(__oracle_jsp_text[23]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[24]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[25]);
       } 
      out.write(__oracle_jsp_text[26]);
      if(bInsertar1 == 2){ 
      out.write(__oracle_jsp_text[27]);
      } 
      out.write(__oracle_jsp_text[28]);
      out.print(strClave);
      out.write(__oracle_jsp_text[29]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[30]);
      
      						}
      out.write(__oracle_jsp_text[31]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[32]);
      	}
      out.write(__oracle_jsp_text[33]);
      out.print(strCodigo);
      out.write(__oracle_jsp_text[34]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[35]);
      
      						}
      out.write(__oracle_jsp_text[36]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[37]);
      	}
      out.write(__oracle_jsp_text[38]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[39]);
      	}
      out.write(__oracle_jsp_text[40]);
      out.print(strSeccion);
      out.write(__oracle_jsp_text[41]);
      if(valida == 2){
      out.write(__oracle_jsp_text[42]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[43]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaExpArchivado.getDatosValores(Val4, Val2, Val3));
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
            out.write(__oracle_jsp_text[44]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[45]);
            if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
            out.write(__oracle_jsp_text[46]);
            	}
            out.write(__oracle_jsp_text[47]);
            out.print(campo2);
            out.write(__oracle_jsp_text[48]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[49]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_2=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setDatos(ActualizaExpArchivado.getDatosValores2(Val4, Val2, Val3));
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
            out.write(__oracle_jsp_text[50]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[51]);
            if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
            out.write(__oracle_jsp_text[52]);
            	}
            out.write(__oracle_jsp_text[53]);
            out.print(campo2);
            out.write(__oracle_jsp_text[54]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[55]);
          } while (__jsp_taghandler_2.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[56]);
      }
      			else {
      out.write(__oracle_jsp_text[57]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_3=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setDatos(ActualizaExpArchivado.getDatosTodoValor());
        __jsp_taghandler_3.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[58]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[59]);
            if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
            out.write(__oracle_jsp_text[60]);
            	}
            out.write(__oracle_jsp_text[61]);
            out.print(campo2);
            out.write(__oracle_jsp_text[62]);
          } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[63]);
      }
      out.write(__oracle_jsp_text[64]);
      }else{
      out.write(__oracle_jsp_text[65]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[66]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_4=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setDatos(ActualizaExpArchivado.getDatosValores(Val4, Val2, Val3));
        __jsp_taghandler_4.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[67]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[68]);
            if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
            out.write(__oracle_jsp_text[69]);
            	}
            out.write(__oracle_jsp_text[70]);
            out.print(campo2);
            out.write(__oracle_jsp_text[71]);
          } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[72]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_5=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setDatos(ActualizaExpArchivado.getDatosValores2(Val4, Val2, Val3));
        __jsp_taghandler_5.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_5,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[73]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[74]);
            if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
            out.write(__oracle_jsp_text[75]);
            	}
            out.write(__oracle_jsp_text[76]);
            out.print(campo2);
            out.write(__oracle_jsp_text[77]);
          } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[78]);
      }
      			else {
      out.write(__oracle_jsp_text[79]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_6=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setDatos(ActualizaExpArchivado.getDatosTodoValor());
        __jsp_taghandler_6.setCampo("campo");
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
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_6,__jsp_tag_starteval,out);
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
            out.write(__oracle_jsp_text[80]);
            out.print( campo1 );
            out.write(__oracle_jsp_text[81]);
            if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
            out.write(__oracle_jsp_text[82]);
            	}
            out.write(__oracle_jsp_text[83]);
            out.print(campo2);
            out.write(__oracle_jsp_text[84]);
          } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[85]);
      }
      out.write(__oracle_jsp_text[86]);
      }
      out.write(__oracle_jsp_text[87]);
      if(strInact == "3" || strInact.equals("3")) 
      						{
      out.write(__oracle_jsp_text[88]);
      
      						}
      out.write(__oracle_jsp_text[89]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[90]);
      
      						}
      out.write(__oracle_jsp_text[91]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[92]);
      
      						}
      out.write(__oracle_jsp_text[93]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[94]);
      	}
      out.write(__oracle_jsp_text[95]);
      out.print(strFecInac);
      out.write(__oracle_jsp_text[96]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[97]);
      	}
      out.write(__oracle_jsp_text[98]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[99]);
      
      						}
      out.write(__oracle_jsp_text[100]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[101]);
      
      						}
      out.write(__oracle_jsp_text[102]);
      if(valida == 2) 
      					{
      out.write(__oracle_jsp_text[103]);
      
      					}
      out.write(__oracle_jsp_text[104]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[105]);
      
      					}
      out.write(__oracle_jsp_text[106]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[107]);
      	}
      out.write(__oracle_jsp_text[108]);
      out.print(strJustInac);
      out.write(__oracle_jsp_text[109]);

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
  private static final char __oracle_jsp_text[][]=new char[110][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Valoración Documental</TITLE>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\tfunction limpiarCampos(){\n\t\tdocument.valoracionf.reset();\n\t}\nfunction rValidando() {\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\talert(\"Como este registro ya cuenta con registros dependientes, solo podra ser modificado su Descripción \");\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\t\n}\n\tfunction habilita2()\n\t{\n\t\tif(document.valoracionf.inactivo.checked == true)\n\t\t{\n\t\tdocument.valoracionf.fecinact.value = \"".toCharArray();
    __oracle_jsp_text[12] = 
    "\";\n\t\tdocument.valoracionf.fecinact.disabled = false;\n\t\tdocument.valoracionf.justif.disabled = false;\n\t\t}else\n\t\t{\n\t\tdocument.valoracionf.fecinact.value = \"\";\n\t\tdocument.valoracionf.justif.value = \"\";\n\t\tdocument.valoracionf.fecinact.disabled = true;\n\t\tdocument.valoracionf.justif.disabled = true;\n\t\t}\n\t}\t\t\n</SCRIPT>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;rValidando();setFormFocusValoraciones();limpiarCampos();timer_load();\" \n\tonKeyPress=\"timer_reload();\" \n\tonmousemove=\"limitaTextArea(document.valoracionf.subSeccion,'Descripción','4000');\"\n\tonClick=\"timer_reload();\">\n<FORM action=\"ValoracionArch.jsp\" name=\"valoracionf\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"id_sub\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"aux\">\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"soloDesc\">\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"../jsp/ValoracionArchview.jsp\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"> </a>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t\t<a></a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\t\n\t\t\t\t<a><img\tsrc=\"../Imagenes/Save.gif\" alt=\"Guardar\" onclick=\"GuardarValoraciones()\"></a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\t\t\t\t\t\t\t\t\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"220\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><B><FONT size=\"+1\" color=\"#004080\">Valoraciones</FONT></B></FONT></B></TD>\n\t\t\t<TD width=\"58\">&nbsp;</TD>\n\t\t\t<TD width=\"394\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"220\" colspan=\"2\" bgcolor=\"#004080\"></TD>\n\t\t\t<TD width=\"58\" bgcolor=\"#004080\"></TD>\n\t\t\t<TD width=\"394\" bgcolor=\"#004080\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"220\" bgcolor=\"#004080\" colspan=\"2\"></TD>\n\t\t\t<TD width=\"58\" bgcolor=\"#004080\"></TD>\n\t\t\t<TD width=\"394\" bgcolor=\"#004080\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[21] = 
    " - ".toCharArray();
    __oracle_jsp_text[22] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[24] = 
    " - ".toCharArray();
    __oracle_jsp_text[25] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tClave:</FONT></B><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "<B><FONT color=\"red\">*Esta clave ya existe*</FONT>\n\t\t\t</B>".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"clave\" value=\"".toCharArray();
    __oracle_jsp_text[29] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\t\t\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\t\n\t\t\t\tMAXLENGTH=\"2\" type=\"text\" class=\"blue100\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tNombre: </FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"subCodigo\" value=\"".toCharArray();
    __oracle_jsp_text[34] = 
    "\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\t\t\t\n\t\t\t\t type=\"text\" class=\"blue500\" MAXLENGTH=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tDescripción:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<TEXTAREA name=\"subSeccion\" rows=\"5\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.valoracionf.subSeccion,'Descripción','4000');\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\t\t\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[41] = 
    "</TEXTAREA> \n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tValores:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t    </TD>\n\t\t</TR>\n".toCharArray();
    __oracle_jsp_text[42] = 
    "\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD  colspan=\"2\">\n\t\t    \t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[45] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\t\n\t\t\t\t\tname=\"agregar\" disabled=\"disabled\">\n\t\t    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t    \t\t</FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t<TR valign=\"top\"> \n\t\t\t<TD colspan=\"2\">\n\t\t    \t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[51] = 
    "\" checked  \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\t\n\t\t\t\t\tname=\"agregar\" disabled=\"disabled\">\n\t\t    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t    \t\t</FONT><INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[55] = 
    "\" name=\"agregar\">\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\">\n\t\t    \t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[59] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\t\n\t\t\t\t\tname=\"agregar\" disabled=\"disabled\">\n\t\t    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t    \t\t</FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n".toCharArray();
    __oracle_jsp_text[65] = 
    "\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\">\n\t\t    \t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[68] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\t\n\t\t\t\t\t\tname=\"agregar\">\n\t\t    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t   ".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t    \t\t</FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t<TR valign=\"top\"> \n\t\t\t<TD colspan=\"2\">\n\t\t    \t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[74] = 
    "\" checked\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\t\n\t\t\t\t\t  name=\"agregar\">\n\t\t    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t    \t\t</FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\">\n\t\t    \t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[81] = 
    "\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\t\n\t\t\t\t\t name=\"agregar\">\n\t\t    \t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t    ".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t    \t\t</FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[87] = 
    "\t\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tInactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=checkbox onclick=\"habilita2()\" value=\"3\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\t\t\t\t\t checked\n\t\t\t\t\t       \t".toCharArray();
    __oracle_jsp_text[89] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[91] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "\t\n\t\t\t\tname=\"inactivo\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFecha Inactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"fecinact\" value=\"".toCharArray();
    __oracle_jsp_text[96] = 
    "\"\n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[97] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[100] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t\t\ttype=\"text\" class=\"blue100\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tJustificacion:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<TEXTAREA name=\"justif\" id=\"justif\" rows=\"3\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.valoracionf.justif,'Justificación','1000');\"\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[106] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[109] = 
    "</TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\t\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
