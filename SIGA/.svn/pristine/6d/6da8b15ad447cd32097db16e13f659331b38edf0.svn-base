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


public class _SeccionArch extends com.orionserver.http.OrionHttpJspPage {


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
    _SeccionArch page = this;
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
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
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
      	String strClave			=	"";
      	String strfondo			=	request.getParameter("fondo");
      	String strsubfondo		=	"";
      	String strInact			=	"";
      	String strFecInac		=	"";
      	String strJustInac		=	"";	
      	String ver				=	"";		
      	String horafec			=	"";
      	String strsoloDesc 		=	"";
      		
      	String strAux = "1234567";
      
      		int valida		=	0;	
      	boolean bInsertar		=	false;
      	int bInsertar1		=	0;	
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha						=	sdf.format(f);
      
      	String retURI = (request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
      	strAccion		=	request.getParameter("accion");
      	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			strsubfondo	=	request.getParameter("subfondo");
      			strfondo	=	request.getParameter("fondo");
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strClave	=	request.getParameter("clave");		
      			bInsertar1	=	ActualizaExpArchivado.insertarSeccion(strfondo, strsubfondo, strCodigo, strSeccion,
      																strFecha, BUsuario.getIdUsuario(), strClave, strAux);
      			if(bInsertar1 == 2)
      			{
      			//msg ="La clave ya existe";
      			}
      			else{
      				try{
      					//response.sendRedirect("SeccionArchview.jsp?msg="+msg);
      					response.sendRedirect(retURI+"&msg="+msg);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strsoloDesc =	request.getParameter("soloDesc");
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strClave	=	request.getParameter("clave");
      			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
      			strFecInac	=	request.getParameter("fecinact");
      			strJustInac =	request.getParameter("justif");			
      			strAux 		= 	request.getParameter("aux"); 
      						
      			bInsertar1 = ActualizaExpArchivado.actualizaSeccion(strsoloDesc, strCodigo, strSeccion, strFecha, 
      															BUsuario.getIdUsuario(), strIdSubfondo, strClave,
      															strFecInac,strJustInac,strInact, strAux);
      			if(bInsertar1 != 2){
      				try{
      					//response.sendRedirect("SeccionArchview.jsp");
      					response.sendRedirect(retURI);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}
      	}
      	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	{
      		String strDatosSubfondo[][] = ActualizaExpArchivado.getSeccion(strIdSubfondo);
      		strCodigo		=	strDatosSubfondo[0][0];
      		strSeccion		=	strDatosSubfondo[0][1];
      		strFecha		=	strDatosSubfondo[0][2];
      		strUsrActualiza	=	strDatosSubfondo[0][3];
      		strClave		=	strDatosSubfondo[0][4];	
      		strFecInac		=	strDatosSubfondo[0][5];	
      		strJustInac		=	strDatosSubfondo[0][6];	
      		strInact		=	strDatosSubfondo[0][7];
      		strfondo		=	strDatosSubfondo[0][8];	
      		strsubfondo		=	strDatosSubfondo[0][9];	
      		horafec			=	strDatosSubfondo[0][10];	
      		strAux			=  	strClave;		
      		ver				=	"si";			
      		valida	=	ActualizaExpArchivado.getValidaSeccion(strIdSubfondo);		
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
      out.print(retURI);
      out.write(__oracle_jsp_text[15]);
      if(valida == 2){
      		strsoloDesc = "1";
      	}
      	
      out.write(__oracle_jsp_text[16]);
      out.print(strsoloDesc);
      out.write(__oracle_jsp_text[17]);
      out.print( retURI );
      out.write(__oracle_jsp_text[18]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[19]);
      	}else{
      out.write(__oracle_jsp_text[20]);
      }
      out.write(__oracle_jsp_text[21]);
       if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[22]);
      out.print(ActualizaUsuario.NombreUsuario(strUsrActualiza));
      out.write(__oracle_jsp_text[23]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[24]);
       }else{ 
      out.write(__oracle_jsp_text[25]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[26]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[27]);
       } 
      out.write(__oracle_jsp_text[28]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)){
      out.write(__oracle_jsp_text[29]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[30]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getSubFondosCombo());
        __jsp_taghandler_1.setName("fondo");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strfondo));
        __jsp_taghandler_1.setDisabled(true);
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onchange='reload()'");
        __jsp_taghandler_1.setTextoNoSeleccion(" ------------ Selecciona un Fondo------------ ");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[31]);
      }
      
      					else {
      out.write(__oracle_jsp_text[32]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getSubFondosCombo());
        __jsp_taghandler_2.setName("fondo");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strfondo));
        __jsp_taghandler_2.setDisabled(true);
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setScript("onchange='reload()'");
        __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Selecciona un Fondo------------ ");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[33]);
      }
      out.write(__oracle_jsp_text[34]);
      }else{
      out.write(__oracle_jsp_text[35]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[36]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getSubFondosCombo());
        __jsp_taghandler_3.setName("fondo");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strfondo));
        __jsp_taghandler_3.setClassHtml("blue500");
        __jsp_taghandler_3.setScript("onchange='reload()'");
        __jsp_taghandler_3.setTextoNoSeleccion(" ------------ Selecciona un Fondo------------ ");
        __jsp_taghandler_3.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[37]);
      }
      					else {
      out.write(__oracle_jsp_text[38]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getSubFondosCombo());
        __jsp_taghandler_4.setName("fondo");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( strfondo));
        __jsp_taghandler_4.setClassHtml("blue500");
        __jsp_taghandler_4.setScript("onchange='reload()'");
        __jsp_taghandler_4.setTextoNoSeleccion(" ------------ Selecciona un Fondo------------ ");
        __jsp_taghandler_4.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[39]);
      }
      out.write(__oracle_jsp_text[40]);
      }
      out.write(__oracle_jsp_text[41]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)){
      out.write(__oracle_jsp_text[42]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[43]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_5=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setData(ComboData.getSubFondoC(strfondo));
        __jsp_taghandler_5.setName("subfondo");
        __jsp_taghandler_5.setSize(1);
        __jsp_taghandler_5.setSelected(OracleJspRuntime.toStr( strsubfondo));
        __jsp_taghandler_5.setDisabled(true);
        __jsp_taghandler_5.setClassHtml("blue500");
        __jsp_taghandler_5.setScript("");
        __jsp_taghandler_5.setTextoNoSeleccion(" ------------ Selecciona un SubFondo------------ ");
        __jsp_taghandler_5.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[44]);
      }
      
      					else {
      out.write(__oracle_jsp_text[45]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_6=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setData(ComboData.getSubFondoC(strfondo));
        __jsp_taghandler_6.setName("subfondo");
        __jsp_taghandler_6.setSize(1);
        __jsp_taghandler_6.setSelected(OracleJspRuntime.toStr( strsubfondo));
        __jsp_taghandler_6.setDisabled(true);
        __jsp_taghandler_6.setClassHtml("blue500");
        __jsp_taghandler_6.setScript("");
        __jsp_taghandler_6.setTextoNoSeleccion(" ------------ Selecciona un SubFondo------------ ");
        __jsp_taghandler_6.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[46]);
      }
      out.write(__oracle_jsp_text[47]);
      }else{
      out.write(__oracle_jsp_text[48]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[49]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_7=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setData(ComboData.getSubFondoC(strfondo));
        __jsp_taghandler_7.setName("subfondo");
        __jsp_taghandler_7.setSize(1);
        __jsp_taghandler_7.setSelected(OracleJspRuntime.toStr( strsubfondo));
        __jsp_taghandler_7.setClassHtml("blue500");
        __jsp_taghandler_7.setScript("");
        __jsp_taghandler_7.setTextoNoSeleccion(" ------------ Selecciona un SubFondo------------ ");
        __jsp_taghandler_7.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[50]);
      }
      					else {
      out.write(__oracle_jsp_text[51]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_8=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setData(ComboData.getSubFondoC(strfondo));
        __jsp_taghandler_8.setName("subfondo");
        __jsp_taghandler_8.setSize(1);
        __jsp_taghandler_8.setSelected(OracleJspRuntime.toStr( strsubfondo));
        __jsp_taghandler_8.setClassHtml("blue500");
        __jsp_taghandler_8.setScript("");
        __jsp_taghandler_8.setTextoNoSeleccion(" ------------ Selecciona un SubFondo------------ ");
        __jsp_taghandler_8.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      out.write(__oracle_jsp_text[52]);
      }
      out.write(__oracle_jsp_text[53]);
      }
      out.write(__oracle_jsp_text[54]);
      if(bInsertar1 == 2){ 
      out.write(__oracle_jsp_text[55]);
      } 
      out.write(__oracle_jsp_text[56]);
      out.print(strClave);
      out.write(__oracle_jsp_text[57]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[58]);
      
      						}
      out.write(__oracle_jsp_text[59]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[60]);
      	}
      out.write(__oracle_jsp_text[61]);
      out.print(strCodigo);
      out.write(__oracle_jsp_text[62]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[63]);
      
      						}
      out.write(__oracle_jsp_text[64]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[65]);
      	}
      out.write(__oracle_jsp_text[66]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[67]);
      	}
      out.write(__oracle_jsp_text[68]);
      out.print(strSeccion);
      out.write(__oracle_jsp_text[69]);
      if(strInact == "3" || strInact.equals("3")) 
      						{
      out.write(__oracle_jsp_text[70]);
      
      						}
      out.write(__oracle_jsp_text[71]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[72]);
      
      						}
      out.write(__oracle_jsp_text[73]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[74]);
      
      						}
      out.write(__oracle_jsp_text[75]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[76]);
      	}
      out.write(__oracle_jsp_text[77]);
      out.print(strFecInac);
      out.write(__oracle_jsp_text[78]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[79]);
      	}
      out.write(__oracle_jsp_text[80]);
      if(valida == 2) 
      					{
      out.write(__oracle_jsp_text[81]);
      
      					}
      out.write(__oracle_jsp_text[82]);
      if(valida == 2) 
      					{
      out.write(__oracle_jsp_text[83]);
      
      					}
      out.write(__oracle_jsp_text[84]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[85]);
      
      					}
      out.write(__oracle_jsp_text[86]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[87]);
      	}
      out.write(__oracle_jsp_text[88]);
      out.print(strJustInac);
      out.write(__oracle_jsp_text[89]);

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
  private static final char __oracle_jsp_text[][]=new char[90][];
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
    " \n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Secciones</TITLE>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/Menu2.js\"></script>\t\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\tfunction limpiarCampos(){\n\t\tdocument.seccionf.reset();\n\t}\nfunction rValidando() {\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\talert(\"Como este registro ya cuenta con registros dependientes, solo podra ser modificado su Descripción \");\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n}\t\n\tfunction reload() {\n\t\tdoc = document.seccionf;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.submit();\n\t} \n\n\tfunction habilita2()\n\t{\n\t\tif(document.seccionf.inactivo.checked == true)\n\t\t{\n\t\tdocument.seccionf.fecinact.value = \"".toCharArray();
    __oracle_jsp_text[12] = 
    "\";\n\t\tdocument.seccionf.fecinact.disabled = false;\n\t\tdocument.seccionf.justif.disabled = false;\n\t\t}else\n\t\t{\n\t\tdocument.seccionf.fecinact.value = \"\";\n\t\tdocument.seccionf.justif.value = \"\";\n\t\tdocument.seccionf.fecinact.disabled = true;\n\t\tdocument.seccionf.justif.disabled = true;\n\t\t}\n\t}\n\tfunction llenando()\t\t\n\t{\n\tvar a =  document.seccionf.clave.value;\n\tnum = a.length;\n\tvar af = \"\";\n\tif(num < 6)\n\t\t{\n\t\t\tfor (i=num; i<6; i++){\n\t\t\t\taf = af + \"0\";\n\t\t\t}\n\t\t}\n\tdocument.seccionf.clave.value = af+a;\n\t}\n\n\n\t\n</SCRIPT>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;rValidando();setFormFocusSeccionArch();limpiarCampos();timer_load();\" \n\tonKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"SeccionArch.jsp\" name=\"seccionf\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"id_sub\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"retURI\">\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"soloDesc\">\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"> </a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t<a></a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\t\n\t\t\t\t<a><img\tsrc=\"../Imagenes/Save.gif\" alt=\"Guardar\" border=\"0\"\tonclick=\"GuardarSeccionArch()\"></a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\t\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\t\t\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"234\" height=\"30\"><B><FONT face=\"Verdana\"\n\t\t\t\tcolor=\"#002850\" size=\"2\"></FONT><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><B><FONT size=\"+1\" color=\"#004080\">Secciones</FONT></B></FONT></B></TD>\n\t\t\t<TD width=\"38\" height=\"30\">&nbsp;</TD>\n\t\t\t<TD width=\"400\" align=\"right\" height=\"30\">&nbsp;&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"234\" bgcolor=\"#004080\" height=\"2\"></TD>\n\t\t\t<TD width=\"38\" bgcolor=\"#004080\" height=\"2\"></TD>\n\t\t\t<TD width=\"400\" bgcolor=\"#004080\" height=\"2\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[23] = 
    " - ".toCharArray();
    __oracle_jsp_text[24] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[26] = 
    " - ".toCharArray();
    __oracle_jsp_text[27] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFondo:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\n\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t</TD>\n\t\t</TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tSubFondo:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\n\n\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\n\n\n\t\t\t</TD>\n\t\t</TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#002850\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\t</FONT><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">Clave:</FONT></B></FONT><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "<B><FONT color=\"red\">*Esta clave ya existe*</FONT>\n\t\t\t</B>".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"clave\" value=\"".toCharArray();
    __oracle_jsp_text[57] = 
    "\" MAXLENGTH=\"6\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\t\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\t\t\n\t\t\t\ttype=\"text\" class=\"blue100\"  onblur=\"llenando();\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\t\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tNombre: </FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"subCodigo\" value=\"".toCharArray();
    __oracle_jsp_text[62] = 
    "\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\t\t\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\t\t\n\t\t\t\ttype=\"text\" class=\"blue500\" MAXLENGTH=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tDescripción:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<textarea name=\"subSeccion\" \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\t\n\t\t\tonKeyDown=\"limitaTextArea(document.seccionf.subSeccion,'Descripción','4000');\"\t\n\t\t\t rows=\"8\" cols=\"60\">".toCharArray();
    __oracle_jsp_text[69] = 
    "</textarea>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tInactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=checkbox onclick=\"habilita2()\" value=\"3\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\n\t\t\t\t\t\t checked\n\t\t\t\t\t       \t".toCharArray();
    __oracle_jsp_text[71] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\t\t\n\t\t\t\tname=\"inactivo\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFecha Inactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"fecinact\" value=\"".toCharArray();
    __oracle_jsp_text[78] = 
    "\"\n\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t\t\ttype=\"text\" class=\"blue100\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tJustificacion:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<TEXTAREA name=\"justif\" id=\"justif\" rows=\"3\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.seccionf.justif,'Justificación','1000');\"\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[89] = 
    "</TEXTAREA>\t\t\t\t\n\t\t\t</TD>\n\t\t</TR>\t\t\t\t\t\t\t\t\t\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
