package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.util.*;
import java.util.*;


public class _PasosView extends com.orionserver.http.OrionHttpJspPage {


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
    _PasosView page = this;
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
      out.write(__oracle_jsp_text[6]);
      
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
      
      
      out.write(__oracle_jsp_text[7]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[8]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[9]);
       } 
      out.write(__oracle_jsp_text[10]);
      
      	boolean bExiste			=	false;
      	boolean bOperacion		=	false;
      	boolean bMostrar		=	false;
      
      	int t = 0;
      
      	String strIds_Borrar[]	=	null;
      	String strAccion		=	"";
      
      	strAccion				=	request.getParameter("accion");
      	strIds_Borrar			=	request.getParameterValues("Borrar");
      
      	bExiste					=	ActualizaPaso.getExiste();	
      
      	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
      	{
      		bOperacion	=	ActualizaPaso.deletePaso(strIds_Borrar, BUsuario.getIdUsuario());
      	}
      	String strId = "";
      	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"0";
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";	
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      
      	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
      	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
      
      	int regPorPagina = 20;
      	int muestraPaginas = 20;
      	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
      	if(strConfig != null && strConfig.length > 0){
      		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
      		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
      	}	
      
      	Vector vRegistros = new Vector();
      	int numeroRegistros = 0;
      	
      	
      	String sql[][] = ActualizaPaso.getTipoDoctos(strOrden);
      	if (sql!=null && sql.length>0){
      		for (int ix=0; ix<sql.length; ix++){
      			if(BUsuario.getAdmon() || BUsuario.getIdArea().equals(sql[ix][3])){ 
      				numeroRegistros++;
      				vRegistros.addElement(sql[ix]);
      			}
      		}
      	}
      
      out.write(__oracle_jsp_text[11]);
      out.write(__oracle_jsp_text[12]);
      out.print( strIdUsuario );
      out.write(__oracle_jsp_text[13]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[14]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[15]);
      out.print( contPag );
      out.write(__oracle_jsp_text[16]);
      out.print( contligas );
      out.write(__oracle_jsp_text[17]);
      out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[18]);
       
      				if (vRegistros.size()>0){
      					int numeroPaginas = numeroRegistros/regPorPagina;	
      					if (numeroRegistros%regPorPagina != 0)
      						numeroPaginas++; 
      out.write(__oracle_jsp_text[19]);
      	if (numeroRegistros > 0){	
      out.write(__oracle_jsp_text[20]);
      out.print( numeroRegistros );
      out.write(__oracle_jsp_text[21]);
      	} 
      out.write(__oracle_jsp_text[22]);
      	if (numeroPaginas > 1){	
      out.write(__oracle_jsp_text[23]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[24]);
      out.print( numeroPaginas );
      out.write(__oracle_jsp_text[25]);
       	} 
      out.write(__oracle_jsp_text[26]);
      } 
      out.write(__oracle_jsp_text[27]);
      out.print(strIdUsuario);
      out.write(__oracle_jsp_text[28]);
      out.print(strIdUsuario);
      out.write(__oracle_jsp_text[29]);
      out.print(strIdUsuario);
      out.write(__oracle_jsp_text[30]);
      out.print(strIdUsuario);
      out.write(__oracle_jsp_text[31]);
       int j = 0; 
      out.write(__oracle_jsp_text[32]);
       if(bExiste){ 
      		int numeroPaginas = numeroRegistros/regPorPagina;	
      		if (numeroRegistros%regPorPagina != 0)
      			numeroPaginas++;
      
      		String [][] strDatos = 	ActualizaPaso.getTipoDoctos(strOrden);
      		//System.out.println("1:"+strDatos[i][2]);
      		for (int i=contPag*regPorPagina; i<vRegistros.size() && i<(contPag+1)*regPorPagina; i++){
      
      			String sqlAux[] = (String[])vRegistros.get(i);
      			strDatos[i]=sqlAux;
      
      			String campo1 = strDatos[i][0];
      			String campo2 = strDatos[i][1];
      			String campo3 = strDatos[i][2];
      			String campo4 = strDatos[i][3];			
      		
      out.write(__oracle_jsp_text[33]);
       if(	BUsuario.getAdmon() ||
      				BUsuario.getIdArea().equals(campo4)){
      				bMostrar = strIdUsuario.equals(campo1);
      		
      out.write(__oracle_jsp_text[34]);
       strId = campo1; 
      out.write(__oracle_jsp_text[35]);
      out.print(strId);
      out.write(__oracle_jsp_text[36]);
      out.print(campo3);
      out.write(__oracle_jsp_text[37]);
      out.print( campo2 );
      out.write(__oracle_jsp_text[38]);
      out.print((bMostrar)?"collapse.gif":"expand.gif");
      out.write(__oracle_jsp_text[39]);
      out.print(Utilerias.recortaString(campo3,50));
      out.write(__oracle_jsp_text[40]);
      out.print( Utilerias.recortaString(campo2,50) );
      out.write(__oracle_jsp_text[41]);
      if(bMostrar){ 
      out.write(__oracle_jsp_text[42]);
      {
        com.meve.sigma.taglib.TagRecorreLista __jsp_taghandler_1=(com.meve.sigma.taglib.TagRecorreLista)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.TagRecorreLista.class,"com.meve.sigma.taglib.TagRecorreLista datos campo");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setDatos(ActualizaPaso.getPasos(campo1, strOrden, strTipo));
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
            out.write(__oracle_jsp_text[43]);
             t++; 
            out.write(__oracle_jsp_text[44]);
            if(par(t)==true){
            }else{
            out.write(__oracle_jsp_text[45]);
            }
            out.write(__oracle_jsp_text[46]);
            out.print(usuario1);
            out.write(__oracle_jsp_text[47]);
            out.print( usuario1 );
            out.write(__oracle_jsp_text[48]);
            out.print( com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) );
            out.write(__oracle_jsp_text[49]);
            out.print( usuario4 );
            out.write(__oracle_jsp_text[50]);
            out.print( Utilerias.recortaString(usuario4,80) );
            out.write(__oracle_jsp_text[51]);
            out.print( usuario3 );
            out.write(__oracle_jsp_text[52]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[53]);
       } 
      out.write(__oracle_jsp_text[54]);
       j++; 
      out.write(__oracle_jsp_text[55]);
       } 
      out.write(__oracle_jsp_text[56]);
       } 
      out.write(__oracle_jsp_text[57]);
       if(j==0){ 
      out.write(__oracle_jsp_text[58]);
       } else {
      out.write(__oracle_jsp_text[59]);
      
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[60]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[61]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[62]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[63]);
      out.print(contligas);
      out.write(__oracle_jsp_text[64]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[65]);
      	}else{
      out.write(__oracle_jsp_text[66]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[67]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[68]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[69]);
      out.print(i);
      out.write(__oracle_jsp_text[70]);
      out.print(i+1);
      out.write(__oracle_jsp_text[71]);
      		}else{ 
      out.write(__oracle_jsp_text[72]);
      out.print(i);
      out.write(__oracle_jsp_text[73]);
      out.print(i+1);
      out.write(__oracle_jsp_text[74]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[75]);
      out.print(contligas);
      out.write(__oracle_jsp_text[76]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[77]);
      	}else{
      out.write(__oracle_jsp_text[78]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[79]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[80]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[81]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[82]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[83]);
      	
      			} 
      out.write(__oracle_jsp_text[84]);
       } 
      out.write(__oracle_jsp_text[85]);
       } else { 
      out.write(__oracle_jsp_text[86]);
       } 
      out.write(__oracle_jsp_text[87]);

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
  private static final char __oracle_jsp_text[][]=new char[88][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Pasos</TITLE>\n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\nfunction desplegar(id){\n\t/*doc = document.pasosView;\n\tdoc.idUs.value=id;\n\tdoc.submit();*/\n\tdoc = document.pasosView;\n\tif (id==doc.idUs.value){\n\t\tdoc.idUs.value=0;\n\t\tdoc.submit();\n\t}else{\n\t\tdoc.idUs.value=id;\n\t\t//doc.contPag.value=0;\n\t\t//doc.contligas.value=0;\n\t\tdoc.submit();\n\t}\n}\nfunction cambio(o, t, id){\n\tdoc = document.pasosView;\n\tdoc.orden.value=o;\n\tdoc.tipo.value=t;\n\tdoc.idUs.value=id;\n\tdoc.submit();\n}\nfunction pagina(contador){\n\tdoc = document.pasosView;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.pasosView;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"PasosView.jsp\" name=\"pasosView\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"idUs\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"contligas\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" colspan=\"2\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"40%\"><A href=\"Pasos.jsp?retURI=".toCharArray();
    __oracle_jsp_text[18] = 
    "\" target=\"_self\"> <IMG height=\"26\"\n\t\t\t\tsrc=\"../Imagenes/nuevo1.gif\" width=\"27\" border=\"0\" alt=\"Nuevos Pasos\"></A> <FONT\n\t\t\t\tface=\"Tahoma\" size=\"2\"> </FONT> <A href=\"javascript:Borrar()\"\n\t\t\t\ttarget=\"_self\"> <IMG border=\"0\" src=\"../Imagenes/borrar1.gif\"\n\t\t\t\twidth=\"30\" height=\"27\" alt=\"Borrar Pasos\"></A></TD>\n\t\t\t<TD width=\"50%\">\n\t\t\t<DIV align=\"right\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    " registros mostrados.\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\n\t\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[24] = 
    " de ".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t</DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"10%\"> &nbsp;\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR bgcolor=\"#00204f\">\n\t\t\t<TD width=\"60%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 1, ".toCharArray();
    __oracle_jsp_text[28] = 
    ")\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Paso</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 1, ".toCharArray();
    __oracle_jsp_text[29] = 
    ")\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"40%\"  align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2, ".toCharArray();
    __oracle_jsp_text[30] = 
    ")\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Secuencia</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 2, ".toCharArray();
    __oracle_jsp_text[31] = 
    ")\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body>\n<DIV id=\"view\">\n".toCharArray();
    __oracle_jsp_text[32] = 
    "\n<TABLE width=\"100%\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t<tr valign=\"top\">\n\t\t\t\t<td colspan=\"2\" width=\"800\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t\t<a onClick=\"desplegar(".toCharArray();
    __oracle_jsp_text[36] = 
    ")\" title=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "(".toCharArray();
    __oracle_jsp_text[38] = 
    ")\">\n\t\t\t\t\t\t<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[39] = 
    "\"\n\t\t\t\t\t\t\tborder=\"0\" height=\"16\" width=\"16\"> \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "(".toCharArray();
    __oracle_jsp_text[41] = 
    ")\n\t\t\t\t\t</a> \n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t<tr valign=\"top\" ".toCharArray();
    __oracle_jsp_text[45] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[46] = 
    ">\n\t\t\t\t<td align=\"left\"  width=\"60%\">\n\t\t\t\t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[47] = 
    "\" name=\"Borrar\">\n    \t\t\t\t<font size=\"2\" color=\"#000080\" face=\"Arial\">\n\t\t\t\t\t<A href=\"Pasos.jsp?id_pas=".toCharArray();
    __oracle_jsp_text[48] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[49] = 
    "\" \n\t\t\t\t\t\ttitle=\"".toCharArray();
    __oracle_jsp_text[50] = 
    "\">".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t\t</A>\n\t\t\t\t\t</font>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"center\" width=\"40%\" valign=\"middle\"><font size=\"2\" color=\"#000080\"\n\t\t\t\t\tface=\"Arial\"> ".toCharArray();
    __oracle_jsp_text[52] = 
    " </font></td>\n\t\t\t</tr>\n\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\" align=\"center\">\n\t\t\t\t<FONT face=\"verdana\" size=\"4\">******No hay Pasos\n\t\t\t\tCapturados en su Unidad Administrativa ******</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t<TR>\n\t\t<TD colspan=\"3\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[61] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[62] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[64] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[65] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[67] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[68] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[70] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[71] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[73] = 
    ")\">".toCharArray();
    __oracle_jsp_text[74] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[76] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[77] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[79] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[80] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[82] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[83] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t</TD>\n\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No Hay Pasos\n\t\t\tcapturados******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t</TBODY>\n</TABLE>\n</DIV>\n</DIV>\n<BR>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
