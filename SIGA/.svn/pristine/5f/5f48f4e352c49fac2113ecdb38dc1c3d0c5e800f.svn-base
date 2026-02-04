package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.taglib.*;


public class _TipoCedArch extends com.orionserver.http.OrionHttpJspPage {


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
    _TipoCedArch page = this;
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
      	String 	cat			= BUsuario.getCatArchivado();
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){;}
      	}
      
      out.write(__oracle_jsp_text[5]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
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
      	String strIdArea = (request.getParameter("idArea")!= null)?request.getParameter("idArea"):BUsuario.getIdArea();
      	String strIdSubfondo	=	"";
      	String strCodigo		=	"";
      	String strSeccion		=	"";
      	String strUsrActualiza	=	"";
      	String strFecha			=	"";
      	String strAccion		=	"";
      	String strClave			=	"";	
      	String strComb			=	"";	
      	String strMotivo		=	"";	
      	String strFunda			=	"";	
      	String strSerie			=	"";	
      	String strSubserie		=	"";		
      	String strSerID			=	"0";	
      	String strSubsID		=	"0";	
      	int bInsertar1		=	0;
      	String strInact			=	"";
      	String strFecInac		=	"";
      	String strJustInac		=	"";	
      	String ver				=	"";		
      	String horafec			=	"";
      	String strsoloDesc 		=	"";
      
      	String strAux = "1234567";
      	String strAux2 = "1234567";
      
      		int valida		=	0;
      	boolean bInsertar		=	false;
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
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strClave	=	request.getParameter("clave").toUpperCase(); 			
      			strIdArea	=	request.getParameter("idArea"); 
      			strComb		=	request.getParameter("comb"); 
      			strMotivo	=	request.getParameter("motivo");
      			strFunda	=	request.getParameter("fundar");
      			strSubserie	=	(request.getParameter("Subserie") != null)?request.getParameter("Subserie"):"null";
      			strSerie	=	(request.getParameter("Serie") != null)?request.getParameter("Serie"):"null";
      						
      			bInsertar1	=	ActualizaExpArchivado.insertarTipCed(strCodigo, strSeccion,
      																strFecha, BUsuario.getIdUsuario(),strClave,strIdArea,strComb,strAux,strAux2,
      																strMotivo,strFunda,strSubserie,strSerie);
      
      			if(bInsertar1 == 2){;}
      			else{
      				try{
      					response.sendRedirect(retURI+"&msg="+msg);
      				}catch(java.io.IOException io){;}	
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strsoloDesc =	request.getParameter("soloDesc");
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			 if (strsoloDesc!="1" && !strsoloDesc.equalsIgnoreCase("1"))
          	        {
      				strClave	=	request.getParameter("clave").toUpperCase(); 
      				}
      			strIdArea	=	request.getParameter("idarea2"); 
      			strComb		=	request.getParameter("comb2"); 			
      			strAux 		= 	request.getParameter("aux"); 
      			strAux2 	= 	request.getParameter("aux2"); 
      			strMotivo	=	request.getParameter("motivo");
      			strFunda	=	request.getParameter("fundar");
      			strSubserie	=	(request.getParameter("Subserie") != null)?request.getParameter("Subserie"):request.getParameter("idsubr");
      			strSerie	=	(request.getParameter("Serie") != null)?request.getParameter("Serie"):request.getParameter("idserr");
      			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
      			strFecInac	=	request.getParameter("fecinact");
      			strJustInac =	request.getParameter("justif");				
      					 
      			bInsertar1 = ActualizaExpArchivado.actualizaTipCed(strsoloDesc, strCodigo, strSeccion, strFecha, 
      															BUsuario.getIdUsuario(), strIdSubfondo,strClave,strIdArea,strComb,strAux,strAux2,
      															strMotivo,strFunda,strSubserie,strSerie,strFecInac,strJustInac,strInact);
      
      			if(bInsertar1 != 2){
      				try{
      					response.sendRedirect(retURI);
      				}catch(java.io.IOException io){;}
      			}
      		}
      	}
      	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	{
      		String strDatosSubfondo[][] = ActualizaExpArchivado.getTipCed(strIdSubfondo);
      		strCodigo		=	strDatosSubfondo[0][0];
      		strSeccion		=	strDatosSubfondo[0][1];
      		strFecha		=	strDatosSubfondo[0][2];
      		strUsrActualiza	=	strDatosSubfondo[0][3];
      		strClave		=	strDatosSubfondo[0][4];		
      		strIdArea		=	strDatosSubfondo[0][5];	
      		strMotivo		=	strDatosSubfondo[0][6];	
      		strFunda		=	strDatosSubfondo[0][7];	
      		strSubserie		=	strDatosSubfondo[0][8];	
      		strSerie		=	strDatosSubfondo[0][9];	
      		strFecInac		=	strDatosSubfondo[0][10];	
      		strJustInac		=	strDatosSubfondo[0][11];	
      		strInact		=	strDatosSubfondo[0][12];	
      		horafec			=	strDatosSubfondo[0][13];	
      		ver				=	"si";		
      		strAux			=  	strClave;				
      		strAux2			=  	strIdArea;				
      
      		
      		valida	=	ActualizaExpArchivado.getValidaCedula(strIdSubfondo);
      		
      	}
      	if(strIdArea!=null && strIdArea.trim().length()>0)
      	{
      		strSerID		=	strIdArea;
      		strSubsID		=	strIdArea;
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
      out.print(strAux2);
      out.write(__oracle_jsp_text[15]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[16]);
      out.print(strComb);
      out.write(__oracle_jsp_text[17]);
      out.print(retURI);
      out.write(__oracle_jsp_text[18]);
      out.print(strSubserie);
      out.write(__oracle_jsp_text[19]);
      out.print(strSerie);
      out.write(__oracle_jsp_text[20]);
      if(valida == 2){
      		strsoloDesc = "1";
      	}
      	
      out.write(__oracle_jsp_text[21]);
      out.print(strsoloDesc);
      out.write(__oracle_jsp_text[22]);
      out.print( retURI );
      out.write(__oracle_jsp_text[23]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[24]);
      	}else{
      out.write(__oracle_jsp_text[25]);
      }
      out.write(__oracle_jsp_text[26]);
       if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[27]);
      out.print(ActualizaUsuario.NombreUsuario(strUsrActualiza));
      out.write(__oracle_jsp_text[28]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[29]);
       }else{ 
      out.write(__oracle_jsp_text[30]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[31]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[32]);
       } 
      out.write(__oracle_jsp_text[33]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){
      out.write(__oracle_jsp_text[34]);
       if(BUsuario.getSupervisor() && !cat.equalsIgnoreCase("1")){ 
      out.write(__oracle_jsp_text[35]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("idArea");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_1.setDisabled(true);
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onchange='cambio();'");
        __jsp_taghandler_1.setTextoNoSeleccion("---------- Selecciona área ----------");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[36]);
      }else{
      out.write(__oracle_jsp_text[37]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasCombo());
        __jsp_taghandler_2.setName("idArea");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_2.setDisabled(true);
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setScript("onchange='cambio();'");
        __jsp_taghandler_2.setTextoNoSeleccion("---------- Selecciona área ----------");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[38]);
      }
      out.write(__oracle_jsp_text[39]);
      }else{
      out.write(__oracle_jsp_text[40]);
       if(BUsuario.getSupervisor() && !cat.equalsIgnoreCase("1")){ 
      out.write(__oracle_jsp_text[41]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_3.setName("idArea");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_3.setClassHtml("blue500");
        __jsp_taghandler_3.setScript("onchange='cambio();'");
        __jsp_taghandler_3.setTextoNoSeleccion("---------- Selecciona área ----------");
        __jsp_taghandler_3.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[42]);
      }else{
      out.write(__oracle_jsp_text[43]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getAreasCombo());
        __jsp_taghandler_4.setName("idArea");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( strIdArea));
        __jsp_taghandler_4.setClassHtml("blue500");
        __jsp_taghandler_4.setScript("onchange='cambio();'");
        __jsp_taghandler_4.setTextoNoSeleccion("---------- Selecciona área ----------");
        __jsp_taghandler_4.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[44]);
      }
      out.write(__oracle_jsp_text[45]);
      }
      out.write(__oracle_jsp_text[46]);
      if(bInsertar1 == 2){ 
      out.write(__oracle_jsp_text[47]);
      } 
      out.write(__oracle_jsp_text[48]);
      out.print(strClave);
      out.write(__oracle_jsp_text[49]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[50]);
      	}
      out.write(__oracle_jsp_text[51]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[52]);
      
      						}
      out.write(__oracle_jsp_text[53]);
      out.print(strCodigo);
      out.write(__oracle_jsp_text[54]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[55]);
      
      						}
      out.write(__oracle_jsp_text[56]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[57]);
      	}
      out.write(__oracle_jsp_text[58]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[59]);
      	}
      out.write(__oracle_jsp_text[60]);
      out.print(strSeccion);
      out.write(__oracle_jsp_text[61]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[62]);
      
      						}
      out.write(__oracle_jsp_text[63]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[64]);
      	}
      out.write(__oracle_jsp_text[65]);
      out.print(strFunda);
      out.write(__oracle_jsp_text[66]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[67]);
      
      						}
      out.write(__oracle_jsp_text[68]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[69]);
      	}
      out.write(__oracle_jsp_text[70]);
      out.print(strMotivo);
      out.write(__oracle_jsp_text[71]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){
      out.write(__oracle_jsp_text[72]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[73]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_5=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setData(ComboData.getComboICDDSer(strSerID));
        __jsp_taghandler_5.setName("Serie");
        __jsp_taghandler_5.setSize(1);
        __jsp_taghandler_5.setSelected(OracleJspRuntime.toStr( strSerie));
        __jsp_taghandler_5.setDisabled(true);
        __jsp_taghandler_5.setClassHtml("blue500");
        __jsp_taghandler_5.setScript("");
        __jsp_taghandler_5.setTextoNoSeleccion(" ---------- Seleccione una serie ICDD ---------- ");
        __jsp_taghandler_5.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[74]);
      }
      					else {
      out.write(__oracle_jsp_text[75]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_6=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setData(ComboData.getComboICDDSer(strSerID));
        __jsp_taghandler_6.setName("Serie");
        __jsp_taghandler_6.setSize(1);
        __jsp_taghandler_6.setSelected("");
        __jsp_taghandler_6.setDisabled(true);
        __jsp_taghandler_6.setClassHtml("blue500");
        __jsp_taghandler_6.setScript("");
        __jsp_taghandler_6.setTextoNoSeleccion(" ---------- Seleccione una serie ICDD --------- ");
        __jsp_taghandler_6.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[76]);
      }
      out.write(__oracle_jsp_text[77]);
      }else{
      out.write(__oracle_jsp_text[78]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[79]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_7=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setData(ComboData.getComboICDDSer(strSerID));
        __jsp_taghandler_7.setName("Serie");
        __jsp_taghandler_7.setSize(1);
        __jsp_taghandler_7.setSelected(OracleJspRuntime.toStr( strSerie));
        __jsp_taghandler_7.setClassHtml("blue500");
        __jsp_taghandler_7.setScript("");
        __jsp_taghandler_7.setTextoNoSeleccion(" ---------- Seleccione una serie ICDD ---------- ");
        __jsp_taghandler_7.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[80]);
      }
      					else {
      out.write(__oracle_jsp_text[81]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_8=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setData(ComboData.getComboICDDSer(strSerID));
        __jsp_taghandler_8.setName("Serie");
        __jsp_taghandler_8.setSize(1);
        __jsp_taghandler_8.setSelected("");
        __jsp_taghandler_8.setClassHtml("blue500");
        __jsp_taghandler_8.setScript("");
        __jsp_taghandler_8.setTextoNoSeleccion(" ---------- Seleccione una serie ICDD --------- ");
        __jsp_taghandler_8.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      out.write(__oracle_jsp_text[82]);
      }
      out.write(__oracle_jsp_text[83]);
      }
      out.write(__oracle_jsp_text[84]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){
      out.write(__oracle_jsp_text[85]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[86]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_9=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_9.setParent(null);
        __jsp_taghandler_9.setData(ComboData.getComboICDDSubSer(strSubsID));
        __jsp_taghandler_9.setName("Subserie");
        __jsp_taghandler_9.setSize(1);
        __jsp_taghandler_9.setSelected(OracleJspRuntime.toStr( strSubserie));
        __jsp_taghandler_9.setDisabled(true);
        __jsp_taghandler_9.setClassHtml("blue500");
        __jsp_taghandler_9.setScript("");
        __jsp_taghandler_9.setTextoNoSeleccion(" ---------- Seleccione una Subserie de ICDD ---------- ");
        __jsp_taghandler_9.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
        if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,1);
      }
      out.write(__oracle_jsp_text[87]);
      }
      					else {
      out.write(__oracle_jsp_text[88]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_10=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_10.setParent(null);
        __jsp_taghandler_10.setData(ComboData.getComboICDDSubSer(strSubsID));
        __jsp_taghandler_10.setName("Subserie");
        __jsp_taghandler_10.setSize(1);
        __jsp_taghandler_10.setSelected("");
        __jsp_taghandler_10.setDisabled(true);
        __jsp_taghandler_10.setClassHtml("blue500");
        __jsp_taghandler_10.setScript("");
        __jsp_taghandler_10.setTextoNoSeleccion(" ---------- Seleccione una Subserie de ICDD --------- ");
        __jsp_taghandler_10.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
        if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,1);
      }
      out.write(__oracle_jsp_text[89]);
      }
      out.write(__oracle_jsp_text[90]);
      }else{
      out.write(__oracle_jsp_text[91]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[92]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_11=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_11.setParent(null);
        __jsp_taghandler_11.setData(ComboData.getComboICDDSubSer(strSubsID));
        __jsp_taghandler_11.setName("Subserie");
        __jsp_taghandler_11.setSize(1);
        __jsp_taghandler_11.setSelected(OracleJspRuntime.toStr( strSubserie));
        __jsp_taghandler_11.setClassHtml("blue500");
        __jsp_taghandler_11.setScript("");
        __jsp_taghandler_11.setTextoNoSeleccion(" ---------- Seleccione una Subserie de ICDD ---------- ");
        __jsp_taghandler_11.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
        if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,1);
      }
      out.write(__oracle_jsp_text[93]);
      }
      					else {
      out.write(__oracle_jsp_text[94]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_12=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_12.setParent(null);
        __jsp_taghandler_12.setData(ComboData.getComboICDDSubSer(strSubsID));
        __jsp_taghandler_12.setName("Subserie");
        __jsp_taghandler_12.setSize(1);
        __jsp_taghandler_12.setSelected("");
        __jsp_taghandler_12.setClassHtml("blue500");
        __jsp_taghandler_12.setScript("");
        __jsp_taghandler_12.setTextoNoSeleccion(" ---------- Seleccione una Subserie de ICDD --------- ");
        __jsp_taghandler_12.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
        if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,1);
      }
      out.write(__oracle_jsp_text[95]);
      }
      out.write(__oracle_jsp_text[96]);
      }
      out.write(__oracle_jsp_text[97]);
      if(strInact == "3" || strInact.equals("3")) 
      						{
      out.write(__oracle_jsp_text[98]);
      
      						}
      out.write(__oracle_jsp_text[99]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[100]);
      
      						}
      out.write(__oracle_jsp_text[101]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[102]);
      
      						}
      out.write(__oracle_jsp_text[103]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[104]);
      	}
      out.write(__oracle_jsp_text[105]);
      out.print(strFecInac);
      out.write(__oracle_jsp_text[106]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[107]);
      	}
      out.write(__oracle_jsp_text[108]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[109]);
      
      						}
      out.write(__oracle_jsp_text[110]);
      if(valida == 2) 
      					{
      out.write(__oracle_jsp_text[111]);
      
      					}
      out.write(__oracle_jsp_text[112]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[113]);
      
      					}
      out.write(__oracle_jsp_text[114]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[115]);
      	}
      out.write(__oracle_jsp_text[116]);
      out.print(strJustInac);
      out.write(__oracle_jsp_text[117]);

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
  private static final char __oracle_jsp_text[][]=new char[118][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    " \n<HTML>\n<HEAD>\n".toCharArray();
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Cédula Tipo</TITLE>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\tfunction limpiarCampos(){\n\t\tdocument.tipcedf.reset();\n\t}\n</SCRIPT>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\n\n function detalle2() { \n\t}\t\n function rValidando() {\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\talert(\"Como este registro ya cuenta con registros dependientes, solo podra ser modificado su Descripción\");\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n }\n\n function cambio(){\n\tdoc = document.tipcedf;\n\tval = doc.idArea.value;\n\tdoc.idarea2.value = val;\n\tdoc.submit();\n\t} \n\t\n\nfunction habilita2()\n\t{\n\t\tif(document.tipcedf.inactivo.checked == true)\n\t\t{\n\t\tdocument.tipcedf.fecinact.value = \"".toCharArray();
    __oracle_jsp_text[12] = 
    "\";\n\t\tdocument.tipcedf.fecinact.disabled = false;\n\t\tdocument.tipcedf.justif.disabled = false;\n\t\t}else\n\t\t{\n\t\tdocument.tipcedf.fecinact.value = \"\";\n\t\tdocument.tipcedf.justif.value = \"\";\n\t\tdocument.tipcedf.fecinact.disabled = true;\n\t\tdocument.tipcedf.justif.disabled = true;\n\t\t}\n\t}\t\n\t\nfunction desSub()\n\t{\n\t\tdoc = document.tipcedf;\n\t\tdoc.Subserie[doc.Subserie.selectedIndex].value == -1;\n\t\talert();\n\t}\nfunction desSerie()\n\t{\n\t\tdoc = document.tipcedf;\n\t\tdoc.Serie[doc.Serie.selectedIndex].value == -1;\n\t}\t\t\n\n</SCRIPT>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;rValidando();setFormFocusTipCed();limpiarCampos();timer_load();detalle2();\" \n\tonKeyPress=\"timer_reload();\" \n\tonmousemove=\"limitaTextArea(document.tipcedf.subSeccion,'Descripción','4000')\"\n\tonClick=\"timer_reload();\">\n<FORM action=\"TipoCedArch.jsp\" name=\"tipcedf\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"id_sub\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"idarea2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"comb2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"retURI\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"idsubr\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"idserr\">\n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"soloDesc\">\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"> </a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t<a></a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\t\n\t\t\t\t<a><img\tsrc=\"../Imagenes/Save.gif\" alt=\"Guardar\" border=\"0\" onclick=\"GuardarTipCed()\"></a>\n\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\t\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"199\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><FONT size=\"+1\" color=\"#004080\">Cédula Tipo</FONT></FONT></B></TD>\n\t\t\t<TD width=\"44\">&nbsp;</TD>\n\t\t\t<TD width=\"429\" align=\"right\">&nbsp;&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD width=\"199\" colspan=\"2\"></TD>\n\t\t\t<TD width=\"44\"></TD>\n\t\t\t<TD width=\"429\" align=\"right\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD width=\"199\" colspan=\"2\"></TD>\n\t\t\t<TD width=\"44\"></TD>\n\t\t\t<TD width=\"429\" align=\"right\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[28] = 
    " - ".toCharArray();
    __oracle_jsp_text[29] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[31] = 
    " - ".toCharArray();
    __oracle_jsp_text[32] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">Unidad Administrativa:\n\t\t\t</FONT></FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
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
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tClave:</FONT></B></FONT><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "<B><FONT color=\"red\">*Esta clave ya existe*</FONT>\n\t\t\t</B>".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"clave\"  value=\"".toCharArray();
    __oracle_jsp_text[49] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t\t\t\tdisabled =\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\t\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\t\t\n\t\t\t\t MAXLENGTH=\"4\" type=\"text\" class=\"blue100\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tNombre:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"subCodigo\" value=\"".toCharArray();
    __oracle_jsp_text[54] = 
    "\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\t\t\t\t\t\n\t\t\t\t type=\"text\" class=\"blue500\" MAXLENGTH=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tDescripción:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\n\t\t\t\t<TEXTAREA name=\"subSeccion\" rows=\"5\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.tipcedf.subSeccion,'Descripción','4000');\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\t\t\t\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[61] = 
    "</TEXTAREA> \n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFundamento Jurídico:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<textarea name=\"fundar\" rows=\"8\" cols=\"60\"  \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\t\t\t\n\t\t\tonKeyDown=\"limitaTextArea(document.tipcedf.fundar,'Descripción','1000')\">".toCharArray();
    __oracle_jsp_text[66] = 
    "</textarea>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tMotivación:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<textarea name=\"motivo\" rows=\"8\" cols=\"60\" \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\t\t\t\n\t\t\tonKeyDown=\"limitaTextArea(document.tipcedf.motivo,'Descripción','4000')\">".toCharArray();
    __oracle_jsp_text[71] = 
    "</textarea>\n\t\t\t</TD>\n\t\t</TR>\t\t\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\">&nbsp;</FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tICDD(Serie):</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\">&nbsp;</FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tICDD(Subserie):</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[97] = 
    "\n\t\t\t</TD>\n\t\t</TR>\t\t\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tInactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=checkbox onclick=\"habilita2()\" value=\"3\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\n\t\t\t\t\t\t checked\n\t\t\t\t\t       \t".toCharArray();
    __oracle_jsp_text[99] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[100] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\t\t\t\n\t\t\t\tname=\"inactivo\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFecha Inactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"fecinact\" value=\"".toCharArray();
    __oracle_jsp_text[106] = 
    "\"\n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[109] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\t\n\t\t\t\ttype=\"text\" class=\"blue100\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tJustificacion:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<TEXTAREA name=\"justif\" id=\"justif\" rows=\"3\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.tipcedf.justif,'Justificación','1000');\"\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[111] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[112] = 
    "\n\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[117] = 
    "</TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\t\t\t\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
