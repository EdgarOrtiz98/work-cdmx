package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import java.util.*;
import com.meve.sigma.beans.search.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.actualiza.*;


public class _AnexarReferencia extends com.orionserver.http.OrionHttpJspPage {


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
    _AnexarReferencia page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      com.meve.sigma.beans.Asunto Asunto;
      synchronized (pageContext) {
        if ((Asunto = (com.meve.sigma.beans.Asunto) pageContext.getAttribute( "Asunto", PageContext.PAGE_SCOPE)) == null) {
          Asunto = (com.meve.sigma.beans.Asunto) new com.meve.sigma.beans.Asunto();
          pageContext.setAttribute( "Asunto", Asunto, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[2]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)Asunto, true);
          out.write(__oracle_jsp_text[3]);
          out.write(__oracle_jsp_text[4]);
          out.write(__oracle_jsp_text[5]);
          
          	String strDatosAsuntoAnt[][] = null;
          	String strDatosAsuntoAntRef[][] = null; 
          	String strIdAsuntoPrimarios	= "";
          	String idAsuntoAnt	=	(Asunto.getIdAsuntoAnt()== null)?"":Asunto.getIdAsuntoAnt();
          	String idAsuntoRef	=	(Asunto.getIdAsuntoRef()== null)?"":Asunto.getIdAsuntoRef();         
          	String strIdAsunto	=	(Asunto.getIdAsuntoRefencia()== null)?"":Asunto.getIdAsuntoRefencia(); 
          	String strAccion 	= 	(request.getParameter("strAccion") == null )?"":request.getParameter("strAccion");
          	String stridArea	=	"";
          	String stridUsuario	=	"";
          
          	strIdAsunto 	=	request.getParameter("strIdAsunto");
          	stridArea		=	request.getParameter("idArea");
          	stridUsuario	=	request.getParameter("idUs");
          	strIdAsuntoPrimarios = strIdAsunto;
          	idAsuntoAnt =  request.getParameter("idAsuntoAnt");
          	idAsuntoRef =	request.getParameter("idAsuntoRef");
          
          	boolean bValidaEstatus = false;
          	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
          	if (strIdAsunto!=null && !strIdAsunto.equals("")){
          		if (strEstValidacion.equals("")){
          			strEstValidacion = ActualizaAsunto.getEstatus(strIdAsunto);
          		}
          		String strEstatusValida = ActualizaAsunto.getEstatus(strIdAsunto);
          		if (!strEstatusValida.equals(strEstValidacion) || strEstValidacion.equalsIgnoreCase("4")){ 
          			bValidaEstatus = true; 
          		}
          	}
          
          	if (!bValidaEstatus && strAccion.equals("guardar") && strAccion.length()>0){	
          		ActualizaAsunto.InsertarAsuntosAnt(strIdAsunto,idAsuntoAnt,idAsuntoRef); 
          out.write(__oracle_jsp_text[6]);
          	}
          
          	if (!bValidaEstatus && strAccion.equals("borrar") && strAccion.length()>0){
          
          		ActualizaAsunto.EliminarAsuntosAnt(strIdAsunto,idAsuntoAnt,idAsuntoRef);
          
          	}
          
          out.write(__oracle_jsp_text[7]);
          out.print(stridArea);
          out.write(__oracle_jsp_text[8]);
          out.print(idAsuntoAnt);
          out.write(__oracle_jsp_text[9]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[10]);
          out.print(stridUsuario);
          out.write(__oracle_jsp_text[11]);
          out.print(stridArea);
          out.write(__oracle_jsp_text[12]);
          out.print(idAsuntoAnt);
          out.write(__oracle_jsp_text[13]);
          out.print(strIdAsunto);
          out.write(__oracle_jsp_text[14]);
          out.print(stridUsuario);
          out.write(__oracle_jsp_text[15]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[16]);
          out.print( idAsuntoAnt );
          out.write(__oracle_jsp_text[17]);
          out.print( idAsuntoRef );
          out.write(__oracle_jsp_text[18]);
          out.print( strAccion );
          out.write(__oracle_jsp_text[19]);
          out.print( strIdAsunto );
          out.write(__oracle_jsp_text[20]);
          out.print( stridArea );
          out.write(__oracle_jsp_text[21]);
          out.print( stridUsuario );
          out.write(__oracle_jsp_text[22]);
          out.print(strEstValidacion);
          out.write(__oracle_jsp_text[23]);
          if (idAsuntoAnt!= null){
          		Vector lista = new Vector();
          		StringTokenizer tokens=new StringTokenizer(idAsuntoAnt, "|");
          		StringTokenizer tokens1=new StringTokenizer(idAsuntoRef, "|");
          		int nDatos=tokens.countTokens();
          		int nDatos1=tokens1.countTokens();
          		String[] datos = new String[nDatos];
          		String strDatos[] = new String[nDatos1];	
          			int i=0;
          			int y =0;
          			int x = 0;
          			while(tokens.hasMoreTokens()){
          				String str=tokens.nextToken();
          				datos[i]= str;
          				if (lista.contains(datos[i])){
          					
          				}else{
          					lista.add(datos[i]);
          				}			        
          				i++;
          			}
          		
          		while(tokens1.hasMoreTokens()){
          				String str=tokens1.nextToken();
          				strDatos[x] = str;
          				x++;
          			}
          	
          		
          		
          out.write(__oracle_jsp_text[24]);
          
          		String strConsulta[][];
          		String strEstato		=	"";
          		for (int j = 0; j < lista.size(); j++){			
          		strConsulta = ActualizaBuscar.getBusquedaAsuntosAnidados(lista.get(j).toString());
                          switch(Integer.parseInt(strConsulta[0][3])){
                              case 0:
                                  strEstato = "Recepción";
                              break;
                              case 1:
                                  strEstato = "Por Turnar";
                              break;
                              case 2: 
                                  strEstato = "Turnado";
                              break;
                              case 3:
                                  strEstato = "Terminado";
                              break;
                              default:
                              break;
                          }                	
          	
          out.write(__oracle_jsp_text[25]);
          out.print(strConsulta[0][0]);
          out.write(__oracle_jsp_text[26]);
          out.print( strConsulta[0][1] );
          out.write(__oracle_jsp_text[27]);
          out.print(strConsulta[0][2]);
          out.write(__oracle_jsp_text[28]);
          out.print( strConsulta[0][3] );
          out.write(__oracle_jsp_text[29]);
          if (strDatos[j].equals("a")) {
          out.write(__oracle_jsp_text[30]);
          }else 
          out.write(__oracle_jsp_text[31]);
          if (strDatos[j].equals("r")){
          out.write(__oracle_jsp_text[32]);
          }else
          				if (strDatos[j].equals("f")){
          out.write(__oracle_jsp_text[33]);
           } 
          out.write(__oracle_jsp_text[34]);
          }
          out.write(__oracle_jsp_text[35]);
          }
          out.write(__oracle_jsp_text[36]);
          out.print( bValidaEstatus );
          out.write(__oracle_jsp_text[37]);
        }
      }

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
  private static final char __oracle_jsp_text[][]=new char[38][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n\n<script type=\"text/javascript\">\n<!--\n\t\twindow.opener.document.Asunto.submit();\n\t\twindow.close();\n//-->\n</script>\n\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Tipos de relación</TITLE>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n\n\tvar hay_hija_uno = new Boolean(false);\n\tvar hija_uno = new Object(); \n\n\tfunction Abrir(){\n\n\t\tvar isCenter ='true';\n\t\tvar features = '';\n\n\t\tif(window.screen)if(isCenter)if(isCenter==\"true\"){\n\t\t    var myLeft = (screen.width-760)/2;\n\t\t    var myTop = (screen.height-360)/2;\n\t\t    features+=(features!='')?',':'';\n\t\t    features+=',left='+myLeft+',top='+myTop; \n\t\t}\n\t\t//hija_uno = window.open('BusquedaAsuntoAnt.jsp?idArea=".toCharArray();
    __oracle_jsp_text[8] = 
    "&idAsuntoAntBusca=".toCharArray();
    __oracle_jsp_text[9] = 
    "&idAsunto=".toCharArray();
    __oracle_jsp_text[10] = 
    "&idUs=".toCharArray();
    __oracle_jsp_text[11] = 
    "','hija_uno',features+((features!='')?',':'')+'width=760, height=360, status=yes');\n\t\t//hay_hija_uno = true; \n\t\tlocation.assign(\"BusquedaAsuntoAnt.jsp?idArea=".toCharArray();
    __oracle_jsp_text[12] = 
    "&idAsuntoAntBusca=".toCharArray();
    __oracle_jsp_text[13] = 
    "&idAsunto=".toCharArray();
    __oracle_jsp_text[14] = 
    "&idUs=".toCharArray();
    __oracle_jsp_text[15] = 
    "&idAsuntoRefBusca=\" + document.AnexarRef.idAsuntoRef.value + \"&estValidacion=".toCharArray();
    __oracle_jsp_text[16] = 
    "\");\n\t}\n\n\tfunction Guardar(){\n\t\n\t\t\tvar form =document.AnexarRef;\n\t\t\tvar cadena = \"\";\n\t\t\tvar accion = \"guardar\";\n\t\t\tvar IdValue = \"\";\n\t\t  \tvar numdoc=0;\t\n\t\t\tfor (var i = 0; i < form.elements.length; i++) {\n\t\t  \t\t\tif (form.elements[i].name == \"RefType\") {\n\t\t    \t\t\t\tvalor = form.elements[i].value;\n\t\t    \t\t\t\tif(valor != \"\"){\n\t\t\t\t\t\t\t\tcadena = cadena + valor  + \"|\";\n\t\t    \t\t\t\t\tnumdoc=numdoc + 1;\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t//alert(cadena);\n\t\t\t//if (cadena != \"\"){\n\t\t\t\t\twindow.document.forms[0].idAsuntoRef.value = cadena;\n\t\t\t\t\twindow.document.forms[0].strAccion.value = accion;\n\t\t\t//}\n\t\t\twindow.document.AnexarRef.submit();\n\t\t\t//window.opener.document.Asunto.submit();\n\t\t\t//window.close();\n\n\t}\t\n\n\tfunction Cambio(){\n\t\tvar form =document.AnexarRef;\n\t\tvar cadena = \"\";\n\t\tfor (var i = 0; i < form.elements.length; i++) {\n\t  \t\tif (form.elements[i].name == \"RefType\") {\n\t    \t\tvalor = form.elements[i].value;\n\t    \t\tif(valor != \"\"){\n\t\t\t\t\tcadena = cadena + valor  + \"|\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tform.idAsuntoRef.value = cadena;\n\t}\t\n\n\tfunction EliminarAnex(){\n\t\tvar form = document.AnexarRef;\n  \t\tvar cadena = \"\";\n\t\tvar IdValue = \"\";\n  \t\tvar numdoc=0;\n\t\tvar cadenaid;\n\t\tvar seleccionados = 0;\n\n\t\tfor (var i = 0; i < form.elements.length; i++) {\n    \t\tif (form.elements[i].type == \"checkbox\") {\n      \t\t\tif (form.elements[i].name == \"borrar\") {\n        \t\t\tif (form.elements[i].checked == false){\n        \t\t\t\tvalor = form.elements[i].value;\n        \t\t\t\tif(valor != \"\"){\n\t\t\t\t\t\t\tcadena = cadena + valor  + \"|\";\n        \t\t\t\t\tnumdoc=numdoc + 1;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n        \t\t\t}\n      \t\t\t}\n    \t\t}\n\t\t\tif (form.elements[i].name == \"borrar\") {\n        \t\t\tif (form.elements[i].checked == true){\n\t\t\t\t\t\t\tseleccionados=seleccionados + 1;\n        \t\t\t}\n      \t\t\t}\n\n\t\t}\n\t\tif (seleccionados == \"\")\n\t\t\talert(\"Debe seleccionar un documento\"); \n\t\t\n\t\telse {\t\n        \t\twindow.parent.document.AnexarRef.idAsuntoAnt.value = cadena;\n\t\t\t\twindow.document.AnexarRef.submit();\n\t\t}\t\n\n\t}\n\n</SCRIPT>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onunload=\"opener.hay_hija=false;opener.botonBandera=true;\" \n\t\tonmouseover=\"if (hay_hija_uno == true){hija_uno.focus();}\" \n\t\tonfocus=\"if (hay_hija_uno == true){hija_uno.focus();}\"\n\t\tonclick=\"opener.timer_reload();\"\n\t\tonkeypress=\"opener.timer_reload();\" >\n<form name=\"AnexarRef\" action=\"AnexarReferencia.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"idAsuntoAnt\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"idAsuntoRef\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"strAccion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"strIdAsunto\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" name=\"idArea\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"idUs\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" name=\"estValidacion\">\n<table width=\"667\" border=\"0\">\n\t<tr>\n\t\t<td valign=\"top\" width=\"83%\">".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t<TABLE border=\"0\" width=\"545\">\n\t\t\t<TR bgcolor=\"#00204f\">\n\t\t\t\t<TH width=\"30\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\"></FONT></b></CENTER>\n\t\t\t\t</TH>\n\t\t\t\t<TH width=\"153\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">FOLIO</FONT></b>\n\t\t\t\t</CENTER>\n\t\t\t\t</TH>\n\t\t\t\t<TH width=\"197\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">FOLIO\n\t\t\t\tDOCUMENTO</FONT></b></CENTER>\n\t\t\t\t</TH>\n\t\t\t\t<TH width=\"106\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">ESTATUS</FONT></b></CENTER>\n\t\t\t\t</TH>\n\t\t\t\t<TH width=\"138\">\n\t\t\t\t<CENTER><b><FONT size=\"1\" color=\"white\" face=\"verdana\">TIPO DE relación</FONT></b></CENTER>\n\t\t\t\t</TH>\n\t\t\t</TR>\n\t\t</TABLE>\n\t\t<DIV class=documentBody id=Body>\n\t\t<TABLE border=\"0\" width=\"545\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t<TR>\n\t\t\t\t<TD width=\"30\">\n\t\t\t\t<CENTER><INPUT type=checkbox name=\"borrar\"\n\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\"></CENTER>\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"153\">\n\t\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[27] = 
    "</FONT>\n\t\t\t\t</CENTER>\n\t\t\t\t</TD>\n\t\t\t\t<td width=\"197\">\n\t\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[28] = 
    "</FONT>\n\t\t\t\t</CENTER>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"106\">\n\t\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\">".toCharArray();
    __oracle_jsp_text[29] = 
    "</FONT>\n\t\t\t\t</CENTER>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"138\">\n\t\t\t\t<CENTER><FONT size=\"1\" color=\"#000080\" face=\"Arial\"> \n\t\t\t<SELECT\tNAME=\"RefType\" SIZE=\"1\" onchange=\"Cambio();\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t<OPTION VALUE=\"a\" selected=\"selected\">Alcance</OPTION>\n\t\t\t<OPTION VALUE=\"r\">Respuesta</OPTION>\n\t\t\t<OPTION VALUE=\"f\">Referencia</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t<OPTION VALUE=\"a\">Alcance</OPTION>\n\t\t\t<OPTION VALUE=\"r\" selected=\"selected\">Respuesta</OPTION> \n\t\t\t<OPTION VALUE=\"f\">Referencia</OPTION>\n\t         ".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t<OPTION VALUE=\"a\">Alcance</OPTION>\n\t\t\t<OPTION VALUE=\"r\">Respuesta</OPTION> \n\t\t\t<OPTION VALUE=\"f\" selected=\"selected\">Referencia</OPTION>\n   \t\t\t\t ".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t</SELECT> </FONT></CENTER>\n\t\t\t\t</td>\n\t\t\t</TR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t</TABLE>\n\t\t</DIV><script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "</td>\n\t\t<td valign=\"top\" width=\"17%\"><INPUT type=\"button\" class=\"blue100\"\n\t\t\tvalue=\"Anexar\" onclick=\"Abrir();\"> <br>\n\t\t<br>\n\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Eliminar\"\n\t\t\tonclick=\"EliminarAnex();\"> <br>\n\t\t<br>\n\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Guardar\"\n\t\t\tonclick=\"Guardar();\"> <br>\n\t\t<br>\n\t\t<br>\n\t\t<br>\n\t\t<INPUT type=\"button\" class=\"blue100\" value=\"Cancelar\"\n\t\t\tonclick=\"opener.hay_hija=false; Cancelar();\"></td>\n\n\t</tr>\n</table>\n<script type=\"text/javascript\">\n<!--\nif (".toCharArray();
    __oracle_jsp_text[37] = 
    "){\n\t//alert(\"Este Asunto ha sido modificado por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\twindow.opener.document.Asunto.submit();\n\twindow.close();\n}\n//-->\n</script>\n</form>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
