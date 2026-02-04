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
import java.util.Vector;
import com.meve.sigma.util.*;
import java.util.*;


public class _ConsultaExpediente extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }

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
    _ConsultaExpediente page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      com.meve.sigma.beans.BeanAreaView BAreaView;
      synchronized (pageContext) {
        if ((BAreaView = (com.meve.sigma.beans.BeanAreaView) pageContext.getAttribute( "BAreaView", PageContext.PAGE_SCOPE)) == null) {
          BAreaView = (com.meve.sigma.beans.BeanAreaView) new com.meve.sigma.beans.BeanAreaView();
          pageContext.setAttribute( "BAreaView", BAreaView, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[0]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)BAreaView, true);
          out.write(__oracle_jsp_text[1]);
          {
            String __url=OracleJspRuntime.toStr("headerC.jsp");
            // Include 
            pageContext.include( __url,false);
            if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
          }

          out.write(__oracle_jsp_text[2]);
          out.write(__oracle_jsp_text[3]);
          out.write(__oracle_jsp_text[4]);
          out.write(__oracle_jsp_text[5]);
          out.write(__oracle_jsp_text[6]);
          out.write(__oracle_jsp_text[7]);
          
          	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
          	String strTmp=request.getRequestURI();
          	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
          	String 	cat	= BUsuario.getCatArchivado();
          	if(BUsuario==null){
          		try{
          			response.sendRedirect("index.jsp?pagina="+ strTmp);
          		}
          		catch(java.io.IOException io){
          			//System.out.println("ERROR:"+io.getMessage());
          		}
          	}
          
          
          out.write(__oracle_jsp_text[8]);
           if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
          		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
          		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
          		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
          		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
          out.write(__oracle_jsp_text[9]);
          if (true) {
            String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
            // Forward 
            pageContext.forward( __url);
            return;
          }

          out.write(__oracle_jsp_text[10]);
           } 
          out.write(__oracle_jsp_text[11]);
          
          	boolean bOperacion = false;
          	boolean bMostrar   = false;
          	int t = 0;
          
          	String strClaveExp = (request.getParameter("claveExp") != null)?request.getParameter("claveExp"):"";
          	String strDenomExp = (request.getParameter("denomExp") != null)?request.getParameter("denomExp"):"";
          
          
          	String strIdArea = (request.getParameter("idExp") != null)?request.getParameter("idExp"):"0";
          	String strAccion = "";
          	String strIds_Borrar[] = null;
          
          	strAccion = request.getParameter("accion");
          	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
          	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
          	String strpasa[][] = null;
          
          	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
          	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
          	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"0";
          	int regPorPagina = 20;
          	int muestraPaginas = 20;
          	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
          	if(strConfig != null && strConfig.length > 0){
          		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
          		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
          	}
          	int numRegistros = 0;
          	int numPaginas = 0;
          
          out.write(__oracle_jsp_text[12]);
          out.write(__oracle_jsp_text[13]);
          out.print( strOrden );
          out.write(__oracle_jsp_text[14]);
          out.print( strTipo );
          out.write(__oracle_jsp_text[15]);
          out.print( strIdUsuario );
          out.write(__oracle_jsp_text[16]);
          out.print( contPag );
          out.write(__oracle_jsp_text[17]);
          out.print( contligas );
          out.write(__oracle_jsp_text[18]);
           if(BUsuario.getSupervisor()){ 
          out.write(__oracle_jsp_text[19]);
          out.print((strIdArea.trim().equals("todoexp")?"selected":""));
          out.write(__oracle_jsp_text[20]);
          out.print((strIdArea.trim().equals("sinexp")?"selected":""));
          out.write(__oracle_jsp_text[21]);
          out.print((strIdArea.trim().equals("todo")?"selected":""));
          out.write(__oracle_jsp_text[22]);
          out.print((strIdArea.trim().equals("sin")?"selected":""));
          out.write(__oracle_jsp_text[23]);
          }else{
          out.write(__oracle_jsp_text[24]);
          out.print((strIdArea.trim().equals("todoexp")?"selected":""));
          out.write(__oracle_jsp_text[25]);
          out.print((strIdArea.trim().equals("sinexp")?"selected":""));
          out.write(__oracle_jsp_text[26]);
          out.print((strIdArea.trim().equals("todo")?"selected":""));
          out.write(__oracle_jsp_text[27]);
          out.print((strIdArea.trim().equals("sin")?"selected":""));
          out.write(__oracle_jsp_text[28]);
          }
          out.write(__oracle_jsp_text[29]);
          	String[][] num = ActualizaExpArchivado.getporExpediente_Consulta(strIdArea, strOrden, strTipo, strClaveExp, strDenomExp, BUsuario.getIdArea());
          			for (int i=0; i<num.length; i++){
          			String regis = num[i][2];
          			if (BUsuario.getAdmon() || BUsuario.getIdArea().equals(regis) || cat.equalsIgnoreCase("1"))
          				{numRegistros = numRegistros + 1;
          				}
          			}
          
          out.write(__oracle_jsp_text[30]);
          	numPaginas = numRegistros/regPorPagina;	
          			if (numRegistros%regPorPagina != 0)
          				numPaginas++; 
          out.write(__oracle_jsp_text[31]);
          	if (numRegistros > 0){	
          out.write(__oracle_jsp_text[32]);
          out.print( numRegistros );
          out.write(__oracle_jsp_text[33]);
          	} 
          out.write(__oracle_jsp_text[34]);
          	if (numPaginas > 1){	
          out.write(__oracle_jsp_text[35]);
          out.print( contPag+1 );
          out.write(__oracle_jsp_text[36]);
          out.print( numPaginas );
          out.write(__oracle_jsp_text[37]);
           	} 
          out.write(__oracle_jsp_text[38]);
          if(strIdArea.length() != 0){
          out.write(__oracle_jsp_text[39]);
           int j = 0; 
          out.write(__oracle_jsp_text[40]);
          	String[][] sql = ActualizaExpArchivado.getporExpediente_Consulta(strIdArea, strOrden, strTipo, strClaveExp, strDenomExp, BUsuario.getIdArea());
          			for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
          				String Lista1 = sql[i][0];
          				String Lista2 = sql[i][1];
          				String Lista3 = sql[i][2];
          		
          out.write(__oracle_jsp_text[41]);
           		bMostrar = strIdUsuario.equals(Lista1);
          		 if (BUsuario.getAdmon() || Lista3.equals(BUsuario.getIdArea()) || cat.equalsIgnoreCase("1")){ 
          		
          out.write(__oracle_jsp_text[42]);
          out.print(Lista1);
          out.write(__oracle_jsp_text[43]);
          out.print(Lista2);
          out.write(__oracle_jsp_text[44]);
          out.print((bMostrar)?"collapse.gif":"expand.gif");
          out.write(__oracle_jsp_text[45]);
           if(strIdArea.equals("sin")){ 
          out.write(__oracle_jsp_text[46]);
          out.print(Utilerias.recortaString(Lista2,45));
          out.write(__oracle_jsp_text[47]);
           }else{ 
          out.write(__oracle_jsp_text[48]);
          out.print( Lista1 );
          out.write(__oracle_jsp_text[49]);
          out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&idUs="+strIdUsuario+"&idExp="+strIdArea) );
          out.write(__oracle_jsp_text[50]);
          out.print(Lista2);
          out.write(__oracle_jsp_text[51]);
          out.print(Utilerias.recortaString(Lista2,45));
          out.write(__oracle_jsp_text[52]);
           } 
          out.write(__oracle_jsp_text[53]);
          }
          			
          			if(strIdUsuario.equals(Lista1)){ 
          out.write(__oracle_jsp_text[54]);
          if(ActualizaExpArchivado.getporExpedienteAsunto(Lista1, strOrden, strTipo) != null
          			&& ActualizaExpArchivado.getporExpedienteAsunto(Lista1, strOrden, strTipo).length > 0) {
          out.write(__oracle_jsp_text[55]);
          {
            com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
            __jsp_taghandler_1.setParent(null);
            __jsp_taghandler_1.setDatos(ActualizaExpArchivado.getporExpedienteAsunto(Lista1, strOrden, strTipo));
            __jsp_taghandler_1.setCampo("usuario");
            java.lang.String usuario1 = null;
            java.lang.String usuario2 = null;
            java.lang.String usuario3 = null;
            java.lang.String usuario4 = null;
            java.lang.String usuario5 = null;
            java.lang.String usuario6 = null;
            java.lang.String usuario7 = null;
            java.lang.String usuario8 = null;
            java.lang.String usuario9 = null;
            java.lang.String usuario10 = null;
            java.lang.String usuario11 = null;
            java.lang.String usuario12 = null;
            java.lang.String usuario13 = null;
            java.lang.String usuario14 = null;
            java.lang.String usuario15 = null;
            java.lang.String usuario16 = null;
            java.lang.String usuario17 = null;
            java.lang.String usuario18 = null;
            java.lang.String usuario19 = null;
            java.lang.String usuario20 = null;
            __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
            if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
            {
              out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
              do {
                usuario1 = (java.lang.String) pageContext.findAttribute("usuario1");
                usuario2 = (java.lang.String) pageContext.findAttribute("usuario2");
                usuario3 = (java.lang.String) pageContext.findAttribute("usuario3");
                usuario4 = (java.lang.String) pageContext.findAttribute("usuario4");
                usuario5 = (java.lang.String) pageContext.findAttribute("usuario5");
                usuario6 = (java.lang.String) pageContext.findAttribute("usuario6");
                usuario7 = (java.lang.String) pageContext.findAttribute("usuario7");
                usuario8 = (java.lang.String) pageContext.findAttribute("usuario8");
                usuario9 = (java.lang.String) pageContext.findAttribute("usuario9");
                usuario10 = (java.lang.String) pageContext.findAttribute("usuario10");
                usuario11 = (java.lang.String) pageContext.findAttribute("usuario11");
                usuario12 = (java.lang.String) pageContext.findAttribute("usuario12");
                usuario13 = (java.lang.String) pageContext.findAttribute("usuario13");
                usuario14 = (java.lang.String) pageContext.findAttribute("usuario14");
                usuario15 = (java.lang.String) pageContext.findAttribute("usuario15");
                usuario16 = (java.lang.String) pageContext.findAttribute("usuario16");
                usuario17 = (java.lang.String) pageContext.findAttribute("usuario17");
                usuario18 = (java.lang.String) pageContext.findAttribute("usuario18");
                usuario19 = (java.lang.String) pageContext.findAttribute("usuario19");
                usuario20 = (java.lang.String) pageContext.findAttribute("usuario20");
                out.write(__oracle_jsp_text[56]);
                 if ( BUsuario.getAdmon() || usuario9.equals(BUsuario.getIdArea()) || cat.equalsIgnoreCase("1")){ 
                out.write(__oracle_jsp_text[57]);
                 t++; 
                out.write(__oracle_jsp_text[58]);
                if(par(t)==true){
                }else{
                out.write(__oracle_jsp_text[59]);
                }
                out.write(__oracle_jsp_text[60]);
                out.print(usuario2);
                out.write(__oracle_jsp_text[61]);
                out.print( usuario1 );
                out.write(__oracle_jsp_text[62]);
                out.print(usuario3);
                out.write(__oracle_jsp_text[63]);
                out.print(com.meve.sigma.util.Utilerias.recortaString(usuario3,20));
                out.write(__oracle_jsp_text[64]);
                out.print(usuario3);
                out.write(__oracle_jsp_text[65]);
                out.print(usuario3);
                out.write(__oracle_jsp_text[66]);
                out.print(usuario4);
                out.write(__oracle_jsp_text[67]);
                out.print(usuario4);
                out.write(__oracle_jsp_text[68]);
                out.print(usuario6);
                out.write(__oracle_jsp_text[69]);
                out.print(usuario6);
                out.write(__oracle_jsp_text[70]);
                out.print(usuario7);
                out.write(__oracle_jsp_text[71]);
                out.print(usuario7);
                out.write(__oracle_jsp_text[72]);
                out.print(usuario8);
                out.write(__oracle_jsp_text[73]);
                }
                out.write(__oracle_jsp_text[74]);
              } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
            }
            if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
          }
          out.write(__oracle_jsp_text[75]);
           }
          		 }
          out.write(__oracle_jsp_text[76]);
           j++; 
          out.write(__oracle_jsp_text[77]);
           } 
          out.write(__oracle_jsp_text[78]);
           if(j == 0){ 
          out.write(__oracle_jsp_text[79]);
           }else{ 
          out.write(__oracle_jsp_text[80]);
          
          			if (contligas>0 && numPaginas > muestraPaginas){  
          out.write(__oracle_jsp_text[81]);
          out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
          out.write(__oracle_jsp_text[82]);
          out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
          out.write(__oracle_jsp_text[83]);
          	}
          			if (contPag > 0){  
          				if (contPag > contligas){
          out.write(__oracle_jsp_text[84]);
          out.print(contligas);
          out.write(__oracle_jsp_text[85]);
          out.print(contPag-1);
          out.write(__oracle_jsp_text[86]);
          	}else{
          out.write(__oracle_jsp_text[87]);
          out.print(contligas-1);
          out.write(__oracle_jsp_text[88]);
          out.print(contPag-1);
          out.write(__oracle_jsp_text[89]);
          	} 
          			}
          			if (numPaginas > 1){
          				for (int i=contligas; i<muestraPaginas+contligas && i<numPaginas; i++){ 
          					if (i==contPag){  
          out.write(__oracle_jsp_text[90]);
          out.print(i);
          out.write(__oracle_jsp_text[91]);
          out.print(i+1);
          out.write(__oracle_jsp_text[92]);
          		}else{ 
          out.write(__oracle_jsp_text[93]);
          out.print(i);
          out.write(__oracle_jsp_text[94]);
          out.print(i+1);
          out.write(__oracle_jsp_text[95]);
          		}
          				}
          			} 
          			if (contPag < numPaginas-1){  
          				if (contPag < contligas + muestraPaginas-1){
          out.write(__oracle_jsp_text[96]);
          out.print(contligas);
          out.write(__oracle_jsp_text[97]);
          out.print(contPag+1);
          out.write(__oracle_jsp_text[98]);
          	}else{
          out.write(__oracle_jsp_text[99]);
          out.print(contligas+1);
          out.write(__oracle_jsp_text[100]);
          out.print(contPag+1);
          out.write(__oracle_jsp_text[101]);
          	} 
          			}
          			if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  
          out.write(__oracle_jsp_text[102]);
          out.print( contligas+muestraPaginas );
          out.write(__oracle_jsp_text[103]);
          out.print( contligas+muestraPaginas );
          out.write(__oracle_jsp_text[104]);
          	
          			} 
          out.write(__oracle_jsp_text[105]);
           } 
          out.write(__oracle_jsp_text[106]);
          }
          out.write(__oracle_jsp_text[107]);
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
  private static final char __oracle_jsp_text[][]=new char[108][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    " \n<HTML>\n<HEAD>\n<TITLE>Consulta Expediente</TITLE>\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\nfunction reload() {\n\tdoc = document.Consulta;\n\tval = doc.idExp.value;\n\tif(val==\"\")\n\t{\n\t\treturn false;\n\t}\n\tdoc.accion.value=\"reload\";\n\tdoc.idUs.value=0;\n\tdoc.contPag.value=0;\n\tdoc.contligas.value=0;\n\tdoc.submit();\n}\nfunction cambio(o, t){\n\tdoc = document.Consulta;\n\tdoc.orden.value=o;\n\tdoc.tipo.value=t;\n\tdoc.submit();\n}\nfunction pagina(contador){\n\tdoc = document.Consulta;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.Consulta;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n\nfunction desplegar(id){\n\tdoc = document.Consulta;\n\tif (id==doc.idUs.value){\n\t\tdoc.idUs.value=0;\n\t\tdoc.submit();\n\t}else{\n\t\tdoc.idUs.value=id;\n\t\tdoc.contPag.value=0;\n\t\tdoc.contligas.value=0;\n\t\tdoc.submit();\n\t}\n}\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"timer_load();\" onKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload();\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM action=\"ConsultaExpediente.jsp\" name=\"Consulta\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"idUs\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"contligas\">\n\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" bgcolor=\"#00204f\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n\n<TABLE width=\"100%\">\n\t\t<TR>      \n\t\t\t<TD class=\"etiquetas\" align=\"right\" width=\"30%\"><b>Expediente:</b></TD>\n\t\t\t<TD align=\"left\" width=\"70%\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t<SELECT name=\"idExp\" class=\"blue500\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\" onchange=\"reload()\">\n\t\t\t\t\t<OPTION value=\"todoexp\" ".toCharArray();
    __oracle_jsp_text[20] = 
    ">-- Todos Expedientes --</OPTION>\n\t\t\t\t\t<OPTION value=\"sinexp\" ".toCharArray();
    __oracle_jsp_text[21] = 
    ">-- Expedientes sin Asuntos --</OPTION>\n\t\t\t\t\t<OPTION value=\"todo\" ".toCharArray();
    __oracle_jsp_text[22] = 
    ">-- Expedientes con Asuntos --</OPTION>\n\t\t\t\t\t<OPTION value=\"sin\" ".toCharArray();
    __oracle_jsp_text[23] = 
    ">-- Asuntos sin Expediente  --</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\n\t\t\t\t<SELECT name=\"idExp\" class=\"blue500\" onKeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\" onclick=\"borrar_buffer()\" onchange=\"reload()\">\n\t\t\t\t\t<OPTION value=\"todoexp\" ".toCharArray();
    __oracle_jsp_text[25] = 
    ">-- Todos Expedientes --</OPTION>\n\t\t\t\t\t<OPTION value=\"sinexp\" ".toCharArray();
    __oracle_jsp_text[26] = 
    ">-- Expedientes sin Asuntos --</OPTION>\n\t\t\t\t\t<OPTION value=\"todo\" ".toCharArray();
    __oracle_jsp_text[27] = 
    ">-- Expedientes con Asuntos --</OPTION>\n\t\t\t\t\t<OPTION value=\"sin\" ".toCharArray();
    __oracle_jsp_text[28] = 
    ">-- Asuntos sin Expediente  --</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t</TD>\n                </tr>\n                <tr>\n\t\t\t<TD class=\"etiquetas\" align=\"right\" width=\"30%\"><b>Clave:</b></TD>\n\t\t\t<TD align=\"left\" width=\"70%\">\n                            <INPUT id=\"claveExp\"  name=\"claveExp\" type=\"text\" style=\"width:100%\">\n\t\t\t</TD>\n                </tr>\n                <tr>\n\t\t\t<TD class=\"etiquetas\" align=\"right\" width=\"30%\"><b>Denominación:</b></TD>\n\t\t\t<TD align=\"left\" width=\"70%\">\n                            <INPUT id=\"denomExp\"  name=\"denomExp\" type=\"text\" style=\"width:100%\">\n\t\t\t</TD>\n                </tr>\n                <tr>\n\t\t\t<TD class=\"etiquetas\" colspan=2 align=\"center\" width=\"100%\">\n                            <INPUT id=\"execFilter\"  name=\"execFilter\" type=\"button\" onclick=\"submit()\" value=\"Buscar...\">\n                        </TD>\n\t\t</TR>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY>\n\t<TR valign=\"top\">\n\t\t<TD width=\"43%\" align=\"left\">\n\t\t\t<A href=\"Archivado.jsp\">\n\t\t\t<IMG border=\"0\" alt=\"Regresar\" src=\"../Imagenes/NavLeft.gif\" width=\"30\" height=\"27\">\n\t\t\t</A>\n\t\t</TD>\n\t\t<TD width=\"57%\" align=\"right\" valign=\"middle\">\n\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    " registros mostrados.\n\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[36] = 
    " de ".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n        </TD>\n    </TR>\n</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n<TBODY align=\"center\">\n\t<TR bgcolor=\"#00204f\">\n\t\t<TD align=\"center\" >&nbsp;\n\t\t\t\t\t<FONT size=\"2\" color=\"white\" face=\"verdana\">CATALOGO DE CONSULTAS DE EXPEDIENTES POR ASUNTO</FONT>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"100%\" colspan=\"2\"></TD>\n    </TR>\n</TABLE>\n<TABLE width=\"100%\" border=\"0\">\n\t\t<TR bgcolor=\"#00204f\">\n\t\t\t<TD width=\"25%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Expediente</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD id=\"Asunto_HD\" width=\"15%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Asunto</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD id=\"Asunto_HD2\" width=\"15%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Identificador</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD id=\"Asunto_HD3\" width=\"15%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Folio Recepción</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD id=\"Asunto_HD4\" width=\"15%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Folio Control</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"15%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 4)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Fecha del Documento</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 4)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\t\t\t\t\t\t\n\t\t</TR>\n</TABLE>\n<BR>\n".toCharArray();
    __oracle_jsp_text[39] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"> \n\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\n\t\t\t<tr>\n\t\t\t\t<td colspan=\"4\" width=\"800\">\n\t\t\t\t\t<a onClick=\"desplegar(".toCharArray();
    __oracle_jsp_text[43] = 
    ")\" title=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "\">\n\t\t\t\t\t<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[45] = 
    "\" border=\"0\" height=\"16\" width=\"16\"></a>&nbsp; \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t\t\t<A \thref=\"ExpedienteArch.jsp?id_sub=".toCharArray();
    __oracle_jsp_text[49] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[50] = 
    "\"\n\t\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[51] = 
    " (detalle)\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "</A> \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t\t<TR valign=\"top\" ".toCharArray();
    __oracle_jsp_text[59] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[60] = 
    ">\n\t\t\t<TD width=\"100%\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"25%\" align=\"center\"><FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t\t\t\t</FONT></td>\n\t\t\t\t\t<td width=\"15%\" align=\"center\">\n\t\t\t\t\t<!-- <a href=\"AsuntoTurnado.jsp?id_asunto=".toCharArray();
    __oracle_jsp_text[62] = 
    "\" title=\"".toCharArray();
    __oracle_jsp_text[63] = 
    "\">".toCharArray();
    __oracle_jsp_text[64] = 
    "</a> -->\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[65] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[66] = 
    "','Asunto_HD'));</script></a>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\" align=\"center\">\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[67] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[68] = 
    "','Asunto_HD2'));</script></a>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\" align=\"center\">\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[69] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[70] = 
    "','Asunto_HD3'));</script></a>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\" align=\"center\">\n\t\t\t\t\t<a title=\"".toCharArray();
    __oracle_jsp_text[71] = 
    "\"><script> document.write(trunc('".toCharArray();
    __oracle_jsp_text[72] = 
    "','Asunto_HD4'));</script></a>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\" align=\"center\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</TD> \n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t<TR>\n\t\t\t\t<TD width=\"100%\">\n\t\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No Hay Expedientes\n\t\t\t\tpara el área******</FONT></div>\n\t\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t<TR>\n\t\t<TD colspan=\"5\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[82] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[83] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[85] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[86] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[88] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[89] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[91] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[92] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[94] = 
    ")\">".toCharArray();
    __oracle_jsp_text[95] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[97] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[98] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[100] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[101] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[103] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[104] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[106] = 
    "\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[107] = 
    "\n<br>\n\n<BR>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
