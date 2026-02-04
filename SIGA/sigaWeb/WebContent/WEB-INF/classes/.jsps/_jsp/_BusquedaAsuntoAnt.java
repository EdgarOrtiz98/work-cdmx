package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.search.*;
import java.util.*;
import com.meve.sigma.actualiza.ActualizaRol;


public class _BusquedaAsuntoAnt extends com.orionserver.http.OrionHttpJspPage {


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
    _BusquedaAsuntoAnt page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      	
      	String buscarAsunto 	= 	"";
      	String buscarTipo		=	"";
      	String strBuscarTipo	=	"";
      	String strSearch		=	"";
      	String strIdAsunto 		= 	"";
      	String idAsuntoAnt		= 	"";
      	String stridArea		=	"";
      	String strIdUsuario		=	"";
      	String buscar1[][]	=	new String[0][0];
      	String buscar2[][]	=	new String[0][0];
          String roles[][] = new String[0][0];
      	strIdAsunto 	=	request.getParameter("idAsunto");
      	buscarAsunto	=	(request.getParameter("campo1") != null)?request.getParameter("campo1"):"";
      	buscarTipo 		=	(request.getParameter("tipo") != null)?request.getParameter("tipo"):"";
      	strBuscarTipo	=	request.getParameter("searchOpt");
      	strSearch		=	request.getParameter("searchOption");
      	stridArea		=	request.getParameter("idArea");
      	strIdUsuario	=	request.getParameter("idUs");
          roles = ActualizaRol.getRoles(strIdUsuario);
      
      	String idAsuntoAntBusca 	= (request.getParameter("idAsuntoAntBusca")==null)?"":request.getParameter("idAsuntoAntBusca");
      	String idAsuntoRefBusca 	= (request.getParameter("idAsuntoRefBusca")==null)?"":request.getParameter("idAsuntoRefBusca");
      	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
      
      	StringTokenizer tokens=new StringTokenizer(idAsuntoAntBusca, "|");
      	int nDatos=tokens.countTokens();
      	String datos = "";
      
      	while(tokens.hasMoreTokens()){
      		String str=tokens.nextToken();
      		if (!str.equals(""))
      			datos = datos + str + ",";
      	}
      	if (!datos.equals(""))
      		datos = datos.substring(0,datos.length()-1);
      	else
      		datos = "-1";
      
      
      	if(strSearch != null && strBuscarTipo.equals("title")){
      		strBuscarTipo	=	request.getParameter("searchOpt");
      		strSearch	=	request.getParameter("searchOption");
      		stridArea	=	request.getParameter("idArea");
      		strIdAsunto 	=	request.getParameter("idAsunto");
      		strIdUsuario	=	request.getParameter("idUs");
      
      		try{
      			response.sendRedirect("BusquedaAsuntoAnt.jsp?campo1="+strSearch+"&tipo="+strBuscarTipo+"&idArea="+stridArea+"&idAsunto="+strIdAsunto+"&idUs="+strIdUsuario+"&idAsuntoAntBusca="+idAsuntoAntBusca+"&idAsuntoRefBusca="+idAsuntoRefBusca+"&estValidacion="+strEstValidacion);
      		}catch(java.io.IOException io){
      			//System.err.println("Error de reDirección->"+io);
      		}
      	}
      
      	if(strSearch != null && strBuscarTipo.equals("folio")){
      		strBuscarTipo	=	request.getParameter("searchOpt");
      		strSearch	=	request.getParameter("searchOption");
      		stridArea	=	request.getParameter("idArea");
      		strIdAsunto 	=	request.getParameter("idAsunto");
      		strIdUsuario	=	request.getParameter("idUs");
      
      		try{
      			response.sendRedirect("BusquedaAsuntoAnt.jsp?campo1="+strSearch+"&tipo="+strBuscarTipo+"&idArea="+stridArea+"&idAsunto="+strIdAsunto+"&idUs="+strIdUsuario+"&idAsuntoAntBusca="+idAsuntoAntBusca+"&idAsuntoRefBusca="+idAsuntoRefBusca+"&estValidacion="+strEstValidacion);
      		}catch(java.io.IOException io){
      			//System.err.println("Error de reDirección->"+io);
      		}
      	}
      
      	if(strSearch != null && strBuscarTipo.equals("idDoc")){
      		strBuscarTipo	=	request.getParameter("searchOpt");
      		strSearch	=	request.getParameter("searchOption");
      		stridArea	=	request.getParameter("idArea");
      		strIdAsunto 	=	request.getParameter("idAsunto");
      		strIdUsuario	=	request.getParameter("idUs");
      
      		try{
      			response.sendRedirect("BusquedaAsuntoAnt.jsp?campo1="+strSearch+"&tipo="+strBuscarTipo+"&idArea="+stridArea+"&idAsunto="+strIdAsunto+"&idUs="+strIdUsuario+"&idAsuntoAntBusca="+idAsuntoAntBusca+"&idAsuntoRefBusca="+idAsuntoRefBusca+"&estValidacion="+strEstValidacion);
      		}catch(java.io.IOException io){
      			//System.err.println("Error de reDirección->"+io); 
      		}
      	} 
      
      	if(strSearch != null && strBuscarTipo.equals("pClave")){
      		strBuscarTipo	=	request.getParameter("searchOpt");
      		strSearch	=	request.getParameter("searchOption");
      		stridArea	=	request.getParameter("idArea");
      		strIdAsunto 	=	request.getParameter("idAsunto");
      		strIdUsuario	=	request.getParameter("idUs");
      
      		try{
      			response.sendRedirect("BusquedaAsuntoAnt.jsp?campo1="+strSearch+"&tipo="+strBuscarTipo+"&idArea="+stridArea+"&idAsunto="+strIdAsunto+"&idUs="+strIdUsuario+"&idAsuntoAntBusca="+idAsuntoAntBusca+"&idAsuntoRefBusca="+idAsuntoRefBusca+"&estValidacion="+strEstValidacion);
      		}catch(java.io.IOException io){
      			//System.err.println("Error de reDirección->"+io); 
      		}
      	} 
      
      
      	if(buscarAsunto!= null && buscarTipo != null && buscarAsunto.length() > 0 && buscarTipo.length() > 0 ){
      			if(buscarAsunto != null && buscarAsunto.length() > 0 && buscarTipo.equals("folio")){
      				buscar1	=	ActualizaBuscar.getBusquedaAsuntAnt(buscarAsunto, stridArea, strIdAsunto, datos, strIdUsuario);
                                      //Buscar Asuntos Intrucciones si el usuario es turnador
                                      for(int i=0;i<roles.length;i++) {
                                          if(roles[i][0].equals("5")) {
                                              buscar2	= ActualizaBuscar.getBusquedaAsuntAntIns(buscarAsunto, stridArea, datos, strIdUsuario);
                                              break;
                                          } else {
                                              buscar2 = new String[0][0]; 
                                          }
                                      }
      			}
      		
      			if(buscarAsunto != null && buscarAsunto.length() > 0 && buscarTipo.equals("title")){
      				buscar1	=	ActualizaBuscar.getBusquedaAsuntAntD(buscarAsunto, stridArea, strIdAsunto, datos, strIdUsuario);
      				//Buscar Asuntos Intrucciones si el usuario es turnador
                                      for(int i=0;i<roles.length;i++) {
                                          if(roles[i][0].equals("5")) {
                                              buscar2	= ActualizaBuscar.getBusquedaAsuntAntDIns(buscarAsunto, stridArea, datos, strIdUsuario);
                                              break;
                                          } else {
                                              buscar2 = new String[0][0]; 
                                          }
                                      }
      			}
      		
      			if(buscarAsunto != null && buscarAsunto.length() > 0 && buscarTipo.equals("idDoc")){
      				buscar1	=	ActualizaBuscar.getBusquedaAsuntAntIdDoc(buscarAsunto, stridArea, strIdAsunto, datos, strIdUsuario);
      				//Buscar Asuntos Intrucciones si el usuario es turnador
                                      for(int i=0;i<roles.length;i++) {
                                          if(roles[i][0].equals("5")) {
                                              buscar2	=	ActualizaBuscar.getAsuntosAntIdDocIns(buscarAsunto, stridArea, datos, strIdUsuario);
                                              break;
                                          } else {
                                              buscar2 = new String[0][0]; 
                                          }
                                      }
      			}
      		
      			if(buscarAsunto != null && buscarAsunto.length() > 0 && buscarTipo.equals("pClave")){
      				buscar1	=	ActualizaBuscar.getAsuntosAntPalabraClave(buscarAsunto, stridArea, strIdAsunto, datos, strIdUsuario);
      				//Buscar Asuntos Intrucciones si el usuario es turnador
                                      for(int i=0;i<roles.length;i++) {
                                          if(roles[i][0].equals("5")) {
                                              buscar2	=	ActualizaBuscar.getAsuntosAntPalabraClaveIns(buscarAsunto, stridArea, datos, strIdUsuario);
                                              break;
                                          } else {
                                              buscar2 = new String[0][0]; 
                                          }
                                      }
      			}
      	}
       
      out.write(__oracle_jsp_text[3]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[4]);
      out.print( stridArea );
      out.write(__oracle_jsp_text[5]);
      out.print( strIdUsuario );
      out.write(__oracle_jsp_text[6]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[7]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[8]);
      out.print( stridArea );
      out.write(__oracle_jsp_text[9]);
      out.print( strIdUsuario );
      out.write(__oracle_jsp_text[10]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[11]);
      out.print( idAsuntoAntBusca );
      out.write(__oracle_jsp_text[12]);
      out.print( idAsuntoRefBusca );
      out.write(__oracle_jsp_text[13]);
      out.print(stridArea);
      out.write(__oracle_jsp_text[14]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[15]);
      out.print(strIdUsuario);
      out.write(__oracle_jsp_text[16]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[17]);
      out.print( buscarAsunto );
      out.write(__oracle_jsp_text[18]);
      out.print( (buscarTipo.equals("title") || buscarTipo.equals(""))?"checked":"" );
      out.write(__oracle_jsp_text[19]);
      out.print( (buscarTipo.equals("folio"))?"checked":"" );
      out.write(__oracle_jsp_text[20]);
      out.print( (buscarTipo.equals("idDoc"))?"checked":"" );
      out.write(__oracle_jsp_text[21]);
      out.print( (buscarTipo.equals("pClave"))?"checked":"" );
      out.write(__oracle_jsp_text[22]);
       if(buscarAsunto!= null && buscarTipo != null && buscarAsunto.length() > 0 && buscarTipo.length() > 0 ){
      out.write(__oracle_jsp_text[23]);
       if(buscar1.length == 0 && buscar2.length == 0){ 
      out.write(__oracle_jsp_text[24]);
       }else{ 
      out.write(__oracle_jsp_text[25]);
       if(buscarTipo.equals("title")){
      out.write(__oracle_jsp_text[26]);
       for(int i=0;i<buscar1.length;i++){
      			
      			String strEstatus		=	"";
      			switch(Integer.parseInt(buscar1[i][4])){
                          case 0:
                              strEstatus = "Recepción";
                          break;
                          case 1:
                              strEstatus = "Por Turnar";
                          break;
                          case 2: 
                              strEstatus = "Turnado";
                          break;
                          case 3:
                              strEstatus = "Terminado";
                          break;
                          default:
                          break;
      		}			
      		 
      out.write(__oracle_jsp_text[27]);
      out.print(buscar1[i][0]);
      out.write(__oracle_jsp_text[28]);
      out.print(buscar1[i][1]);
      out.write(__oracle_jsp_text[29]);
      out.print(buscar1[i][2]);
      out.write(__oracle_jsp_text[30]);
      out.print(buscar1[i][3]);
      out.write(__oracle_jsp_text[31]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[32]);
       } 
      out.write(__oracle_jsp_text[33]);
       for(int i=0;i<buscar2.length;i++){
      			
      			String strEstatus		=	"";
                          switch(Integer.parseInt(buscar2[i][4])){
                          case 0:
                              strEstatus = "Recepción";
                          break;
                          case 1:
                              strEstatus = "Por Turnar";
                          break;
                          case 2: 
                              strEstatus = "Turnado";
                          break;
                          case 3:
                              strEstatus = "Terminado";
                          break;
                          default:
                          break;
                      } 
      					
      		 
      out.write(__oracle_jsp_text[34]);
      out.print(buscar2[i][0]);
      out.write(__oracle_jsp_text[35]);
      out.print(buscar2[i][1]);
      out.write(__oracle_jsp_text[36]);
      out.print(buscar2[i][2]);
      out.write(__oracle_jsp_text[37]);
      out.print(buscar2[i][3]);
      out.write(__oracle_jsp_text[38]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[39]);
       } 
      out.write(__oracle_jsp_text[40]);
       }else{ 
      out.write(__oracle_jsp_text[41]);
       if(buscarTipo.equals("folio")){ 
      out.write(__oracle_jsp_text[42]);
       for(int i=0;i<buscar1.length;i++){ 
      			
      			String strEstatus		=	"";
                              switch(Integer.parseInt(buscar1[i][4])){
                          case 0:
                              strEstatus = "Recepción";
                          break;
                          case 1:
                              strEstatus = "Por Turnar";
                          break;
                          case 2: 
                              strEstatus = "Turnado";
                          break;
                          case 3:
                              strEstatus = "Terminado";
                          break;
                          default:
                          break;
                          }		
      
      		
      out.write(__oracle_jsp_text[43]);
      out.print(buscar1[i][0]);
      out.write(__oracle_jsp_text[44]);
      out.print(buscar1[i][1]);
      out.write(__oracle_jsp_text[45]);
      out.print(buscar1[i][2]);
      out.write(__oracle_jsp_text[46]);
      out.print(buscar1[i][3]);
      out.write(__oracle_jsp_text[47]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[48]);
      }
      out.write(__oracle_jsp_text[49]);
       for(int i=0;i<buscar2.length;i++){ 
      			
      			String strEstatus		=	"";
      			switch(Integer.parseInt(buscar2[i][4])){
                          case 0:
                              strEstatus = "Recepción";
                          break;
                          case 1:
                              strEstatus = "Por Turnar";
                          break;
                          case 2: 
                              strEstatus = "Turnado";
                          break;
                          case 3:
                              strEstatus = "Terminado";
                          break;
                          default:
                          break;
                          }
      
      		
      out.write(__oracle_jsp_text[50]);
      out.print(buscar2[i][0]);
      out.write(__oracle_jsp_text[51]);
      out.print(buscar2[i][1]);
      out.write(__oracle_jsp_text[52]);
      out.print(buscar2[i][2]);
      out.write(__oracle_jsp_text[53]);
      out.print(buscar2[i][3]);
      out.write(__oracle_jsp_text[54]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[55]);
      }
      out.write(__oracle_jsp_text[56]);
      }
      out.write(__oracle_jsp_text[57]);
      }
      out.write(__oracle_jsp_text[58]);
       if(buscarTipo.equals("idDoc")){ 
      out.write(__oracle_jsp_text[59]);
       for(int i=0;i<buscar1.length;i++){ 
      
      			String strEstatus		=	"";
      			switch(Integer.parseInt(buscar1[i][4])){
                          case 0:
                              strEstatus = "Recepción";
                          break;
                          case 1:
                              strEstatus = "Por Turnar";
                          break;
                          case 2: 
                              strEstatus = "Turnado";
                          break;
                          case 3:
                              strEstatus = "Terminado";
                          break;
                          default:
                          break;
                          }
      		
      out.write(__oracle_jsp_text[60]);
      out.print(buscar1[i][0]);
      out.write(__oracle_jsp_text[61]);
      out.print(buscar1[i][1]);
      out.write(__oracle_jsp_text[62]);
      out.print(buscar1[i][2]);
      out.write(__oracle_jsp_text[63]);
      out.print(buscar1[i][3]);
      out.write(__oracle_jsp_text[64]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[65]);
      }
      out.write(__oracle_jsp_text[66]);
       for(int i=0;i<buscar2.length;i++){ 
      
      			String strEstatus = "";
      			switch(Integer.parseInt(buscar2[i][4])){
                          case 0:
                              strEstatus = "Recepción";
                          break;
                          case 1:
                              strEstatus = "Por Turnar";
                          break;
                          case 2: 
                              strEstatus = "Turnado";
                          break;
                          case 3:
                              strEstatus = "Terminado";
                          break;
                          default:
                          break;
                          }
      		
      out.write(__oracle_jsp_text[67]);
      out.print(buscar2[i][0]);
      out.write(__oracle_jsp_text[68]);
      out.print(buscar2[i][1]);
      out.write(__oracle_jsp_text[69]);
      out.print(buscar2[i][2]);
      out.write(__oracle_jsp_text[70]);
      out.print(buscar2[i][3]);
      out.write(__oracle_jsp_text[71]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[72]);
      }
      out.write(__oracle_jsp_text[73]);
      }
      out.write(__oracle_jsp_text[74]);
       if(buscarTipo.equals("pClave")){ 
      out.write(__oracle_jsp_text[75]);
       for(int i=0;i<buscar1.length;i++){ 
      
      			String strEstatus		=	"";
      			switch(Integer.parseInt(buscar1[i][4])){
                          case 0:
                              strEstatus = "Recepción";
                          break;
                          case 1:
                              strEstatus = "Por Turnar";
                          break;
                          case 2: 
                              strEstatus = "Turnado";
                          break;
                          case 3:
                              strEstatus = "Terminado";
                          break;
                          default:
                          break;
                          }	
      
      		
      out.write(__oracle_jsp_text[76]);
      out.print(buscar1[i][0]);
      out.write(__oracle_jsp_text[77]);
      out.print(buscar1[i][1]);
      out.write(__oracle_jsp_text[78]);
      out.print(buscar1[i][2]);
      out.write(__oracle_jsp_text[79]);
      out.print(buscar1[i][3]);
      out.write(__oracle_jsp_text[80]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[81]);
      }
      out.write(__oracle_jsp_text[82]);
       for(int i=0;i<buscar2.length;i++){ 
      
      			String strEstatus		=	"";
      			switch(Integer.parseInt(buscar2[i][4])){
                          case 0:
                              strEstatus = "Recepción";
                          break;
                          case 1:
                              strEstatus = "Por Turnar";
                          break;
                          case 2: 
                              strEstatus = "Turnado";
                          break;
                          case 3:
                              strEstatus = "Terminado";
                          break;
                          default:
                          break;
                          }
      
      		
      out.write(__oracle_jsp_text[83]);
      out.print(buscar2[i][0]);
      out.write(__oracle_jsp_text[84]);
      out.print(buscar2[i][1]);
      out.write(__oracle_jsp_text[85]);
      out.print(buscar2[i][2]);
      out.write(__oracle_jsp_text[86]);
      out.print(buscar2[i][3]);
      out.write(__oracle_jsp_text[87]);
      out.print(strEstatus);
      out.write(__oracle_jsp_text[88]);
      }
      out.write(__oracle_jsp_text[89]);
      }
      out.write(__oracle_jsp_text[90]);
       } 
      out.write(__oracle_jsp_text[91]);
      }  
      out.write(__oracle_jsp_text[92]);

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
  private static final char __oracle_jsp_text[][]=new char[93][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Anexar Referencia</TITLE>\n<SCRIPT language=JavaScript type=text/javascript>\n\n\tfunction aceptar(){\n\t\tvar form = document.searchOpt;\n  \t\tvar cadena = \"\";\n\t\tvar cadena2 = \"\";\n\t\tvar IdValue = \"\";\n  \t\tvar numdoc=0;\n\t\tvar numdoc2=0;\n\t\tvar cadenaid;\n\t\t//var idsAnt = window.opener.document.forms[0].idAsuntoAnt.value;\n\t\t//var idsRef = window.opener.document.forms[0].idAsuntoRef.value;\n\t\tvar idsAnt = form.idAsuntoAntBusca.value;\n\t\tvar idsRef = form.idAsuntoRefBusca.value;\n\n\t\t/**\n\t\t*\tExtrae id de Asunto para generar una  liga.\n\t\t*/\n\t\tfor (var i = 0; i < form.elements.length; i++) {\n    \t\tif (form.elements[i].type == \"checkbox\") {\n      \t\t\tif (form.elements[i].name == \"asuAnt\") {\n        \t\t\tif (form.elements[i].checked == true){\n        \t\t\t\tvalor = form.elements[i].value;\n        \t\t\t\tif(valor != \"\"){\n\t\t\t\t\t\t\tcadena = cadena + valor  + \"|\";\n\t\t\t\t\t\t\tcadena2 = cadena2 + \"r\" + \"|\";\n        \t\t\t\t\tnumdoc=numdoc + 1;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n        \t\t\t}\n      \t\t\t}\n    \t\t}\n\t\t}\n\t\tif (cadena == \"\")\n\t\t\talert(\"Debe seleccionar un documento\"); \n\t\t\n\t\telse {\n        \tcadena  = cadena  + idsAnt;\n\t\t\tcadena2 = cadena2 + idsRef;\n\t\t\t/*window.opener.document.AnexarRef.idAsuntoAnt.value = cadena;\n\t\t\twindow.opener.document.AnexarRef.idAsuntoRef.value = cadena2;\n\t\t\twindow.opener.document.AnexarRef.submit();\n\t\t\twindow.close();*/\n\t\t\tlocation.assign('AnexarReferencia.jsp?strIdAsunto=".toCharArray();
    __oracle_jsp_text[4] = 
    "&idAsuntoAnt='+ cadena +'&idAsuntoRef='+ cadena2 +'&idArea=".toCharArray();
    __oracle_jsp_text[5] = 
    "&idUs=".toCharArray();
    __oracle_jsp_text[6] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[7] = 
    "');\n\t\t\t\t\t\t\t\t \n\t\t}\t\n\n\t}\n\n\tfunction cancelar(){\n\t\tvar form = document.searchOpt;\n\t\tvar idsAnt = form.idAsuntoAntBusca.value;\n\t\tvar idsRef = form.idAsuntoRefBusca.value;\n\t\tlocation.assign('AnexarReferencia.jsp?strIdAsunto=".toCharArray();
    __oracle_jsp_text[8] = 
    "&idAsuntoAnt='+ idsAnt +'&idAsuntoRef='+ idsRef +'&idArea=".toCharArray();
    __oracle_jsp_text[9] = 
    "&idUs=".toCharArray();
    __oracle_jsp_text[10] = 
    "&estValidacion=".toCharArray();
    __oracle_jsp_text[11] = 
    "');\n\t}\n\n</SCRIPT>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" LEFTMARGIN=\"0\" TOPMARGIN=\"0\" MARGINWIDTH=\"0\" MARGINHEIGHT=\"0\" \n\t\tonload=\"document.searchOpt.searchOption.focus();\" onunload=\"opener.hay_hija_uno=false\">\n<form name=\"searchOpt\" action=\"BusquedaAsuntoAnt.jsp\" method=\"post\">\n<INPUT type=\"hidden\" name=\"idAsuntoAntBusca\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\">\n<INPUT type=\"hidden\" name=\"idAsuntoRefBusca\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\">\n<INPUT type=\"hidden\" name=\"idArea\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n<INPUT type=\"hidden\" name=\"idAsunto\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\">\n<INPUT type=\"hidden\" name=\"idUs\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"estValidacion\">\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n  <tr> \n    <td width=\"10%\">&nbsp;</td>\n    <td width=\"20%\">&nbsp;</td>\n    <td width=\"20%\" align=\"center\">&nbsp;\n\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Aceptar\" alt=\"aceptar\"  onclick=\"aceptar();\">\n    <td width=\"20%\" align=\"center\">&nbsp;\n\t\t<input type=\"button\" value=\"Cancelar\" class=\"blue100\" onclick=\"cancelar();\">\n\t</td>\n    <td width=\"20%\" colspan=\"2\">Ayuda:&nbsp;<BR>\n\t\t<A title=\"Para hacer una busqueda exacta escriba el criterio (p.ej. Asunto interno de CGTIC)\">\n\t\t<U>Búsqueda exacta</U> &nbsp;</A><BR>\n\t\t<A title=\"Para hacer una busqueda multicriterio escriba los criterios separados por comas (p.ej. CGTIC, instrucción rechazada, Asunto interno)\">\n\t\t<U>Búsqueda multicriterio</U> &nbsp; </A></td>\n    <td width=\"10%\">&nbsp;</td>\n  </tr>\n  <tr> \n    <td width=\"10%\">&nbsp;</td>\n    <td width=\"20%\">&nbsp;</td>\n    <td width=\"20%\">&nbsp;</td>\n    <td width=\"20%\">&nbsp;</td>\n    <td width=\"20%\">&nbsp;</td>\n    <td width=\"10%\">&nbsp;</td>\n  </tr>\n  <tr> \n    <td colspan=\"6\" align=\"center\">\n\t\t<input type=\"text\" name=\"searchOption\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" class=\"blue200\" onblur=\"focus()\";>&nbsp;&nbsp;\n\t\t<IMG src=\"../Imagenes/ico_bus.gif\" alt=\"Buscar Asuntos\" onclick=\"validSearch()\">\n\t</td>\n  </tr>\n</table>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n  <tr> \n    <td width=\"25%\" align=\"center\">\n\t\t<input type=\"radio\" name=\"searchOpt\" value=\"title\" ".toCharArray();
    __oracle_jsp_text[19] = 
    "> T&iacute;tulo </td>\n    <td width=\"25%\" align=\"center\">\n    \t<input type=\"radio\" name=\"searchOpt\" value=\"folio\" ".toCharArray();
    __oracle_jsp_text[20] = 
    "> Folio </td>\n    <td width=\"25%\" align=\"center\">\n\t\t<input type=\"radio\" name=\"searchOpt\" value=\"idDoc\" ".toCharArray();
    __oracle_jsp_text[21] = 
    "> Identificador de Documento </td>\n    <td width=\"25%\" align=\"center\">\n\t\t<input type=\"radio\" name=\"searchOpt\" value=\"pClave\" ".toCharArray();
    __oracle_jsp_text[22] = 
    "> Palabra Clave </td>\n  </tr>\n</table>\n\n".toCharArray();
    __oracle_jsp_text[23] = 
    "\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"283\"><b><FONT size=\"2\" color=\"#004080\" face=\"Arial\">\n\t\t\tResultados encontrados en SIGA </FONT></b></TD>\n\t\t\t<td width=\"133\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<td width=\"863\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\t</TBODY>\n</table>\n<BR>\n".toCharArray();
    __oracle_jsp_text[24] = 
    "\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n<TBODY>\n\t<TR>\n\t\t<TD width=\"383\"><b><FONT size=\"2\" color=\"red\" face=\"Arial\">\n\t\t\tNo se encontraron Documentos</FONT></b></TD>\n\t\t<td width=\"33\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"67\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t\t<td width=\"380\"><img src=\"../Imagenes/ecblank.gif\" border=\"0\"\n\t\t\theight=\"1\" width=\"1\" alt=\"\"></td>\n\t</TR>\n</TBODY>\n</table>\n".toCharArray();
    __oracle_jsp_text[25] = 
    "\n<DIV class=documentBody id=Body>\n<table border=\"0\" width=\"608\" align=\"center\">\n\t<TR bgcolor=\"#00204f\">\n\t\t<TH width=\"30\">\n\t\t<CENTER><b><FONT size=\"2\" color=\"white\" face=\"verdana\"></FONT></b></CENTER>\n\t\t</TH>\n\t\t<TH width=\"133\">\n\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">FOLIO</FONT></b>\n\t\t</CENTER>\n\t\t</TH>\n\t\t<TH width=\"172\">\n\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">NOMBRE DEL\n\t\tASUNTO</FONT></b></CENTER>\n\t\t</TH>\n\t\t<TH width=\"168\">\n\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">FOLIO DOCUMENTO</FONT></b></CENTER>\n\t\t</TH>\n\t\t<TH width=\"95\">\n\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">ESTATUS</FONT></b>\n\t\t</CENTER>\n\t</TR>\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"30\">\n\t\t\t<CENTER><input type=checkbox name=\"asuAnt\" value=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "\"></CENTER>\n\t\t\t</TD>\n\t\t\t<TD width=\"133\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[29] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</TD>\n\t\t\t<td width=\"172\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[30] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"168\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[31] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"95\">\n\t\t\t<CENTER><input type=\"hidden\" value=\"r\" name=\"ref\">\n\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[32] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"30\">\n\t\t\t<CENTER><input type=checkbox name=\"asuAnt\" value=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\"></CENTER>\n\t\t\t</TD>\n\t\t\t<TD width=\"133\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[36] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</TD>\n\t\t\t<td width=\"172\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[37] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"168\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[38] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"95\">\n\t\t\t<CENTER><input type=\"hidden\" value=\"r\" name=\"ref\">\n\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[39] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"30\">\n\t\t\t<CENTER><input type=checkbox name=\"asuAnt\" value=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "\"></CENTER>\n\t\t\t</TD>\n\t\t\t<TD width=\"133\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[45] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</TD>\n\t\t\t<td width=\"172\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[46] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"168\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[47] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"95\">\n\t\t\t<CENTER><input type=\"hidden\" value=\"r\" name=\"ref\">\n\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[48] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"30\">\n\t\t\t<CENTER><input type=checkbox name=\"asuAnt\" value=\"".toCharArray();
    __oracle_jsp_text[51] = 
    "\"></CENTER>\n\t\t\t</TD>\n\t\t\t<TD width=\"133\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[52] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</TD>\n\t\t\t<td width=\"172\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[53] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"168\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[54] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"95\">\n\t\t\t<CENTER><input type=\"hidden\" value=\"r\" name=\"ref\">\n\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[55] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"30\">\n\t\t\t<CENTER><input type=checkbox name=\"asuAnt\" value=\"".toCharArray();
    __oracle_jsp_text[61] = 
    "\"></CENTER>\n\t\t\t</TD>\n\t\t\t<TD width=\"133\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[62] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</TD>\n\t\t\t<td width=\"172\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[63] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"168\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[64] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"95\">\n\t\t\t<CENTER><input type=\"hidden\" value=\"r\" name=\"ref\">\n\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[65] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"30\">\n\t\t\t<CENTER><input type=checkbox name=\"asuAnt\" value=\"".toCharArray();
    __oracle_jsp_text[68] = 
    "\"></CENTER>\n\t\t\t</TD>\n\t\t\t<TD width=\"133\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[69] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</TD>\n\t\t\t<td width=\"172\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[70] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"168\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[71] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"95\">\n\t\t\t<CENTER><input type=\"hidden\" value=\"r\" name=\"ref\">\n\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[72] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"30\">\n\t\t\t<CENTER><input type=checkbox name=\"asuAnt\" value=\"".toCharArray();
    __oracle_jsp_text[77] = 
    "\"></CENTER>\n\t\t\t</TD>\n\t\t\t<TD width=\"133\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[78] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</TD>\n\t\t\t<td width=\"172\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[79] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"168\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[80] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"95\">\n\t\t\t<CENTER><input type=\"hidden\" value=\"r\" name=\"ref\">\n\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[81] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"30\">\n\t\t\t<CENTER><input type=checkbox name=\"asuAnt\" value=\"".toCharArray();
    __oracle_jsp_text[84] = 
    "\"></CENTER>\n\t\t\t</TD>\n\t\t\t<TD width=\"133\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[85] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</TD>\n\t\t\t<td width=\"172\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[86] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"168\">\n\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[87] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t\t<td width=\"95\">\n\t\t\t<CENTER><input type=\"hidden\" value=\"r\" name=\"ref\">\n\t\t\t<FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[88] = 
    "</FONT>\n\t\t\t</CENTER>\n\t\t\t</td>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t</TBODY>\n</table>\n<BR>\n</DIV>\n<BR>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n".toCharArray();
    __oracle_jsp_text[91] = 
    "\n".toCharArray();
    __oracle_jsp_text[92] = 
    "\n<BR>\n</form>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
