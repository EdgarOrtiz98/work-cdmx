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
import java.util.*;
import com.meve.sigma.util.*;


public class _UsuariosRolView extends com.orionserver.http.OrionHttpJspPage {


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
    _UsuariosRolView page = this;
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
          
          	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
          	String strTmp=request.getRequestURI();
          	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
          	if(BUsuario==null){
          		try{
          			response.sendRedirect("index.jsp?pagina="+ strTmp);
          		}
          		catch(java.io.IOException io){;}
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
          
          
          	boolean bOperacion = false;
          	boolean bMostrar = false;
          	int t = 0;
          	Vector vTiene = new Vector();
          	String regIDArea = (request.getParameter("regIDArea")==null)?BUsuario.getIdArea():request.getParameter("regIDArea");
          	String strIdArea = (BAreaView.getIdArea()== null)?regIDArea:BAreaView.getIdArea();
          	String strIdRoles = (request.getParameter("idRol")!=null)?request.getParameter("idRol"):"0";
          	String strAccion = "";
          	String strIds_Borrar[] = null;
          
          	strAccion = request.getParameter("accion");
          	strIds_Borrar = request.getParameterValues("Borrar");
          	
          	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
          		vTiene = ActualizaUsuario.deleteUsuario(strIds_Borrar,BUsuario.getIdUsuario());
          	}
          	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
          	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
          
          	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
          	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
          
          	String retURI = strTmp+"?regIDArea="+strIdArea+"&orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas;
          	retURI = Utilerias.codificaPostHTML(retURI);
          
          	int regPorPagina = 20;
          	int muestraPaginas = 20;
          	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
          	if(strConfig != null && strConfig.length > 0){
          		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
          		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
          	}	
          
          	String[][] strRoles = ActualizaUsuario.getRolesPorArea(strIdArea);
          
          	Vector vRegistros = new Vector();
          	int numeroRegistros = 0;
          	String sql[][] = ActualizaUsuario.getUsuariosPorAreaRol(strIdArea, strIdRoles, strOrden, strTipo);
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
          out.print( retURI );
          out.write(__oracle_jsp_text[13]);
          out.print( strOrden );
          out.write(__oracle_jsp_text[14]);
          out.print( strTipo );
          out.write(__oracle_jsp_text[15]);
          out.print( contPag );
          out.write(__oracle_jsp_text[16]);
          out.print( contligas );
          out.write(__oracle_jsp_text[17]);
          out.print( strIdRoles );
          out.write(__oracle_jsp_text[18]);
          if(vTiene.size()>0){
          out.write(__oracle_jsp_text[19]);
          for(int i=0;i<vTiene.size();i++){
          out.write(__oracle_jsp_text[20]);
          out.print(ActualizaUsuario.NombreUsuario((String)vTiene.get(i)));
          out.write(__oracle_jsp_text[21]);
          }
          out.write(__oracle_jsp_text[22]);
          }
          out.write(__oracle_jsp_text[23]);
          out.print( strIdArea );
          out.write(__oracle_jsp_text[24]);
           
          				if (vRegistros.size()>0){
          					int numeroPaginas = numeroRegistros/regPorPagina;	
          					if (numeroRegistros%regPorPagina != 0)
          						numeroPaginas++; 
          out.write(__oracle_jsp_text[25]);
          	if (numeroRegistros > 0){	
          out.write(__oracle_jsp_text[26]);
          out.print( numeroRegistros );
          out.write(__oracle_jsp_text[27]);
          	} 
          out.write(__oracle_jsp_text[28]);
          	if (numeroPaginas > 1){	
          out.write(__oracle_jsp_text[29]);
          out.print( contPag+1 );
          out.write(__oracle_jsp_text[30]);
          out.print( numeroPaginas );
          out.write(__oracle_jsp_text[31]);
           	} 
          out.write(__oracle_jsp_text[32]);
          } 
          out.write(__oracle_jsp_text[33]);
           if (BUsuario.getAdmon()){ 
          out.write(__oracle_jsp_text[34]);
           if(BUsuario.getSupervisor()){ 
          out.write(__oracle_jsp_text[35]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_1.setParent(null);
            __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
            __jsp_taghandler_1.setName("idArea");
            __jsp_taghandler_1.setSize(0);
            __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_1.setClassHtml("blue500a");
            __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='reload()'");
            __jsp_taghandler_1.setTextoNoSeleccion("-------------------- Selecciona un opción --------------------");
            __jsp_taghandler_1.setValorNoSeleccion("");
            __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
            if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
          }
          out.write(__oracle_jsp_text[36]);
          }else{
          out.write(__oracle_jsp_text[37]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_2.setParent(null);
            __jsp_taghandler_2.setData(ComboData.getAreasComboAll());
            __jsp_taghandler_2.setName("idArea");
            __jsp_taghandler_2.setSize(1);
            __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_2.setClassHtml("blue500a");
            __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='reload()'");
            __jsp_taghandler_2.setTextoNoSeleccion("-------------------- Selecciona un opción --------------------");
            __jsp_taghandler_2.setValorNoSeleccion("");
            __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
            if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
          }
          out.write(__oracle_jsp_text[38]);
          }
          out.write(__oracle_jsp_text[39]);
           } 
          out.write(__oracle_jsp_text[40]);
          if(strIdArea.length() != 0){
          out.write(__oracle_jsp_text[41]);
           if (vRegistros.size()>0 || strRoles.length>0){ 
          out.write(__oracle_jsp_text[42]);
           if (strRoles!=null && strRoles.length>0){ 
          out.write(__oracle_jsp_text[43]);
           for (int ir=0; ir<strRoles.length; ir++){ 
          			String strRol = strRoles[ir][0];
          			String strNombreRol = strRoles[ir][1];
          			bMostrar = strIdRoles.equals(strRol);
          		
          out.write(__oracle_jsp_text[44]);
          out.print(strRol);
          out.write(__oracle_jsp_text[45]);
          out.print((bMostrar)?"collapse.gif":"expand.gif");
          out.write(__oracle_jsp_text[46]);
          out.print( strNombreRol );
          out.write(__oracle_jsp_text[47]);
           if (bMostrar){ 
          out.write(__oracle_jsp_text[48]);
           int j = 0; 
          
          		String strDatos[][] = ActualizaUsuario.getUsuariosPorAreaRol(strIdArea, strIdRoles, strOrden, strTipo);		
          		int numeroPaginas = numeroRegistros/regPorPagina;	
          		if (numeroRegistros%regPorPagina != 0)
          			numeroPaginas++; 
          
          		for (int i=contPag*regPorPagina; i<vRegistros.size() && i<(contPag+1)*regPorPagina; i++){
          
          			String sqlAux[] = (String[])vRegistros.get(i);
          			strDatos[i]=sqlAux;
          
          			String Lista1 = strDatos[i][0];
          			String Lista2 = strDatos[i][1];
          			String Lista3 = strDatos[i][2];
          			String Lista4 = strDatos[i][3];
          			String Lista5 = strDatos[i][4];
          			String Lista6 = strDatos[i][5];
          
          out.write(__oracle_jsp_text[49]);
           if(	BUsuario.getAdmon() ||
          			BUsuario.getIdArea().equals(Lista4)){ 
          out.write(__oracle_jsp_text[50]);
          		String strRolLIsta = ActualizaRol.getRoles(Lista1)[0][0]; 
          out.write(__oracle_jsp_text[51]);
           t++; 
          out.write(__oracle_jsp_text[52]);
          if(par(t)==true){
          }else{
          out.write(__oracle_jsp_text[53]);
          }
          out.write(__oracle_jsp_text[54]);
           if (BUsuario.getSupervisor() && strRolLIsta.equals("0")){} else{ 
          out.write(__oracle_jsp_text[55]);
          out.print(Lista1 );
          out.write(__oracle_jsp_text[56]);
          out.print(Utilerias.codificaPostHTML(strTmp+"?regIDArea="+strIdArea+"&orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&idRol="+strIdRoles) );
          out.write(__oracle_jsp_text[57]);
          }
          out.write(__oracle_jsp_text[58]);
          out.print(Lista2);
          out.write(__oracle_jsp_text[59]);
          out.print(Lista2);
          out.write(__oracle_jsp_text[60]);
          out.print(Lista5);
          out.write(__oracle_jsp_text[61]);
          out.print(Lista5);
          out.write(__oracle_jsp_text[62]);
           j++; 
          out.write(__oracle_jsp_text[63]);
           } 
          out.write(__oracle_jsp_text[64]);
           } 	
          out.write(__oracle_jsp_text[65]);
           if(j == 0){ 
          out.write(__oracle_jsp_text[66]);
           } else {
          out.write(__oracle_jsp_text[67]);
          
          			if (contligas>0 && numeroPaginas > muestraPaginas){  
          out.write(__oracle_jsp_text[68]);
          out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
          out.write(__oracle_jsp_text[69]);
          out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
          out.write(__oracle_jsp_text[70]);
          	}
          			if (contPag > 0){  
          				if (contPag > contligas){
          out.write(__oracle_jsp_text[71]);
          out.print(contligas);
          out.write(__oracle_jsp_text[72]);
          out.print(contPag-1);
          out.write(__oracle_jsp_text[73]);
          	}else{
          out.write(__oracle_jsp_text[74]);
          out.print(contligas-1);
          out.write(__oracle_jsp_text[75]);
          out.print(contPag-1);
          out.write(__oracle_jsp_text[76]);
          	} 
          			}
          			if (numeroPaginas > 1){
          				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
          					if (i==contPag){  
          out.write(__oracle_jsp_text[77]);
          out.print(i);
          out.write(__oracle_jsp_text[78]);
          out.print(i+1);
          out.write(__oracle_jsp_text[79]);
          		}else{ 
          out.write(__oracle_jsp_text[80]);
          out.print(i);
          out.write(__oracle_jsp_text[81]);
          out.print(i+1);
          out.write(__oracle_jsp_text[82]);
          		}
          				}
          			} 
          			if (contPag < numeroPaginas-1){  
          				if (contPag < contligas + muestraPaginas-1){
          out.write(__oracle_jsp_text[83]);
          out.print(contligas);
          out.write(__oracle_jsp_text[84]);
          out.print(contPag+1);
          out.write(__oracle_jsp_text[85]);
          	}else{
          out.write(__oracle_jsp_text[86]);
          out.print(contligas+1);
          out.write(__oracle_jsp_text[87]);
          out.print(contPag+1);
          out.write(__oracle_jsp_text[88]);
          	} 
          			}
          			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
          out.write(__oracle_jsp_text[89]);
          out.print( contligas+muestraPaginas );
          out.write(__oracle_jsp_text[90]);
          out.print( contligas+muestraPaginas );
          out.write(__oracle_jsp_text[91]);
          	
          			} 
          out.write(__oracle_jsp_text[92]);
           } 
          out.write(__oracle_jsp_text[93]);
           } 
          out.write(__oracle_jsp_text[94]);
           } 
          out.write(__oracle_jsp_text[95]);
           } 
          out.write(__oracle_jsp_text[96]);
          }else if(!strIdArea.equals("0")){
          out.write(__oracle_jsp_text[97]);
          }
          out.write(__oracle_jsp_text[98]);
          }
          out.write(__oracle_jsp_text[99]);
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
  private static final char __oracle_jsp_text[][]=new char[100][];
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
    " \n<HTML>\n<HEAD>\n<TITLE>Puestos</TITLE>\n".toCharArray();
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\nfunction reload() {\n\tdoc = document.UsuariosView;\n\tdoc.idRol.value=0;\n\tdoc.accion.value=\"reload\";\n\tdoc.submit();\n}\nfunction cambio(o, t){\n\tdoc = document.UsuariosView;\n\tdoc.orden.value=o;\n\tdoc.tipo.value=t;\n\tdoc.submit();\n}\nfunction referenciaRet(retURI){\n\tlocation.assign(\"Usuarios.jsp?retURI=\" + retURI.value);\n}\n\nfunction pagina(contador){\n\tdoc = document.UsuariosView;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.UsuariosView;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\nfunction desplegar(id){\n\tdoc = document.UsuariosView;\n\tif (id==doc.idRol.value){\n\t\tdoc.idRol.value=0;\n\t\tdoc.submit();\n\t}else{\n\t\tdoc.idRol.value=id;\n\t\tdoc.contPag.value=0;\n\t\tdoc.contligas.value=0;\n\t\tdoc.submit();\n\t}\n}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM action=\"UsuariosRolView.jsp\" name=\"UsuariosView\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\" name=\"retURI\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"contligas\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"idRol\">\n".toCharArray();
    __oracle_jsp_text[19] = 
    "\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"75%\" class=\"etiquetas\">\n\t\t\t\t<FONT size=\"1\" color=\"RED\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    ",\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t<br>No se puede(n) eliminar por que tiene referencias con Puestos y Asuntos</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<br>\n".toCharArray();
    __oracle_jsp_text[23] = 
    "\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"40%\">\n\t\t\t\t<A href=\"estructura.jsp?area=".toCharArray();
    __oracle_jsp_text[24] = 
    "\" target=\"_self\"> \n\t\t\t\t<IMG src=\"../Imagenes/NavLeft.gif\" border=\"0\" alt=\"Regresar\"> </A> \n\t\t\t</TD>\n\t\t\t<TD width=\"50%\" valign=\"middle\">\n\t\t\t<DIV align=\"right\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    " registros mostrados.\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[30] = 
    " de ".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t</DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"10%\"> &nbsp;\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[34] = 
    "\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" bgcolor=\"#00204f\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE width=\"100%\">\n\t<TBODY>\n\t\t<TR>      \n\t\t\t<TD class=\"etiquetas\" align=\"right\" width=\"30%\"><b>Unidad Administrativa:</b></TD>\n\t\t\t<TD align=\"left\" width=\"70%\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[40] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR bgcolor=\"#00204f\">\n\t\t\t<TD id=\"Asunto_HD\" width=\"60%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Puestos</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD id=\"Asunto_HD2\" width=\"40%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 2)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Responsable</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 2)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body><BR>\n".toCharArray();
    __oracle_jsp_text[41] = 
    "\n".toCharArray();
    __oracle_jsp_text[42] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"> \n\n\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t<tr valign=\"top\">\n\t\t\t<td colspan=\"2\" width=\"800\">\n\t\t\t\t<a onClick=\"desplegar(".toCharArray();
    __oracle_jsp_text[45] = 
    ")\" >\n\t\t\t\t<img src=\"../Imagenes/".toCharArray();
    __oracle_jsp_text[46] = 
    "\"\n\t\t\t\t\tborder=\"0\" height=\"16\" width=\"16\">".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t\t</a> \n\t\t\t</td>\n\t\t</tr>\n\t\t\n\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t<TR valign=\"top\" ".toCharArray();
    __oracle_jsp_text[53] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[54] = 
    ">\n\t\t\t<TD width=\"100%\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"60%\" align=\"center\"><FONT face=Arial color=#000080 size=1> \n\t\t\t\t\t<A ".toCharArray();
    __oracle_jsp_text[55] = 
    "href=\"Usuarios.jsp?accion=consultar&id_usuario=".toCharArray();
    __oracle_jsp_text[56] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[57] = 
    "\" ".toCharArray();
    __oracle_jsp_text[58] = 
    " title=\"".toCharArray();
    __oracle_jsp_text[59] = 
    "\"><script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[60] = 
    "','Asunto_HD'));</script></A>\n\t\t\t\t\t</FONT></td>\n\t\t\t\t\t<td width=\"40%\" align=\"center\"><A onmouseover=\"title='".toCharArray();
    __oracle_jsp_text[61] = 
    "'\"><script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[62] = 
    "','Asunto_HD2'));</script></A></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</TD>\n\t\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\n\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No Hay Usuarios\n\t\t\tCapturados de su Unidad Administrativa******</FONT></div>\n\t\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t<TR>\n\t\t<TD colspan=\"3\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[69] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[70] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[72] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[73] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[75] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[76] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[78] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[79] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[81] = 
    ")\">".toCharArray();
    __oracle_jsp_text[82] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[84] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[85] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[87] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[88] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[90] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[91] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\n\t\t</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[95] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[97] = 
    "\n<TABLE width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<TR>\n\t\t<TD width=\"100%\">\n\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No Hay Usuarios Capturados de la Unidad Administrativa******</FONT></div>\n\t\t</TD>\n\t</TR>\n</TABLE>\n".toCharArray();
    __oracle_jsp_text[98] = 
    "\n".toCharArray();
    __oracle_jsp_text[99] = 
    "\n<br>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<BR>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
