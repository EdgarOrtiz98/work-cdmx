package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import java.util.*;
import com.meve.sigma.util.*;


public class _AreaView extends com.orionserver.http.OrionHttpJspPage {


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
    _AreaView page = this;
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
      
      	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
      	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");
      
      	int regPorPagina = 20;
      	int muestraPaginas = 20;
      	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
      	if(strConfig != null && strConfig.length > 0){
      		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
      		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
      	}	
      
      out.write(__oracle_jsp_text[5]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[6]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[7]);
       } 
      out.write(__oracle_jsp_text[8]);
      
      	String [][] sql	=null;
      	Vector vTiene = new Vector();
      	String strIds_Borrar[]	=	null;
      	int t = 0;
      	String strAccion		=	"";
      	strAccion				=	request.getParameter("accion");
      	strIds_Borrar			=	request.getParameterValues("Borrar");
      	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
      	{
      		vTiene	=	ActualizaArea.deleteArea(strIds_Borrar, BUsuario.getIdUsuario()); 
      	}
      	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
      	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
      	String strOrdenExt = (request.getParameter("ordenExt")!=null)?request.getParameter("ordenExt"):"asc";
      	String strTipoExt = (request.getParameter("tipoExt")!=null)?request.getParameter("tipoExt"):"1";
      
      	Vector vRegistros = new Vector();
      	int numeroRegistros = 0;
      	sql = ActualizaArea.getListaAreas(strOrden, strTipo, strOrdenExt, strTipoExt);
      	if (sql!=null && sql.length>0){
      		for (int ix=0; ix<sql.length; ix++){
      			if(BUsuario.getAdmon() || BUsuario.getIdArea().equals(sql[ix][1])){ 
      				numeroRegistros++;
      				vRegistros.addElement(sql[ix]);
      			}
      		}
      	}
       
      out.write(__oracle_jsp_text[9]);
      out.write(__oracle_jsp_text[10]);
      out.print( strOrden );
      out.write(__oracle_jsp_text[11]);
      out.print( strTipo );
      out.write(__oracle_jsp_text[12]);
      out.print( strOrdenExt );
      out.write(__oracle_jsp_text[13]);
      out.print( strTipoExt );
      out.write(__oracle_jsp_text[14]);
      out.print( contPag );
      out.write(__oracle_jsp_text[15]);
      out.print( contligas );
      out.write(__oracle_jsp_text[16]);
      if(vTiene.size()>0){
      out.write(__oracle_jsp_text[17]);
      for(int i=0;i<vTiene.size();i=i+2){
      out.write(__oracle_jsp_text[18]);
      out.print(ActualizaArea.NombreArea((String)vTiene.get(i)));
      out.write(__oracle_jsp_text[19]);
      out.print(Utilerias.recortaString(ActualizaArea.NombreArea((String)vTiene.get(i)),80));
      out.write(__oracle_jsp_text[20]);
      out.print((String)vTiene.get(i+1));
      out.write(__oracle_jsp_text[21]);
      }
      out.write(__oracle_jsp_text[22]);
      }
      out.write(__oracle_jsp_text[23]);
       if (BUsuario.getAdmon()){ 
      out.write(__oracle_jsp_text[24]);
      out.print( Utilerias.codificaPostHTML("AreaView.jsp?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[25]);
       } 
      out.write(__oracle_jsp_text[26]);
       
      				if (vRegistros.size()>0){
      					int numeroPaginas = numeroRegistros/regPorPagina;	
      					if (numeroRegistros%regPorPagina != 0)
      						numeroPaginas++; 
      out.write(__oracle_jsp_text[27]);
      	if (numeroRegistros > 0){	
      out.write(__oracle_jsp_text[28]);
      out.print( numeroRegistros );
      out.write(__oracle_jsp_text[29]);
      	} 
      out.write(__oracle_jsp_text[30]);
      	if (numeroPaginas > 1){	
      out.write(__oracle_jsp_text[31]);
      out.print( contPag+1 );
      out.write(__oracle_jsp_text[32]);
      out.print( numeroPaginas );
      out.write(__oracle_jsp_text[33]);
       	} 
      out.write(__oracle_jsp_text[34]);
      } 
      out.write(__oracle_jsp_text[35]);
       int j = 0; 
      out.write(__oracle_jsp_text[36]);
       sql=ActualizaArea.getListaAreas(strOrden, strTipo, strOrdenExt, strTipoExt);
      out.write(__oracle_jsp_text[37]);
      if(vRegistros.size()==0){
      out.write(__oracle_jsp_text[38]);
      }else {
      			int numeroPaginas = numeroRegistros/regPorPagina;	
      			if (numeroRegistros%regPorPagina != 0)
      				numeroPaginas++; 
      
      			for (int i=contPag*regPorPagina; i<vRegistros.size() && i<(contPag+1)*regPorPagina; i++){
      
      				String sqlAux[] = (String[])vRegistros.get(i);
      				sql[i]=sqlAux;
      
      				String campo1 = sql[i][0];
      				String campo2 = sql[i][1];
      				String campo3 = sql[i][2];
      				String campo4 = sql[i][3];
      		
      out.write(__oracle_jsp_text[39]);
       if(	BUsuario.getAdmon() || BUsuario.getIdArea().equals(campo2)){ 
      out.write(__oracle_jsp_text[40]);
       t++; 
      out.write(__oracle_jsp_text[41]);
      if(par(t)==true){
      }else{
      out.write(__oracle_jsp_text[42]);
      }
      out.write(__oracle_jsp_text[43]);
      out.print(campo2);
      out.write(__oracle_jsp_text[44]);
      out.print(campo2);
      out.write(__oracle_jsp_text[45]);
      out.print( Utilerias.codificaPostHTML("AreaView.jsp?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) );
      out.write(__oracle_jsp_text[46]);
      out.print(campo1);
      out.write(__oracle_jsp_text[47]);
      out.print(campo1);
      out.write(__oracle_jsp_text[48]);
       if(campo3.length() > 0 && campo3 != null){ 
      out.print(campo3);
      out.write(__oracle_jsp_text[49]);
      out.print(campo4);
       } 
      out.write(__oracle_jsp_text[50]);
       if(campo3.length() > 0 && campo3 != null){ 
      out.write(__oracle_jsp_text[51]);
      out.print(campo3);
      out.write(__oracle_jsp_text[52]);
      out.print(campo4);
      out.write(__oracle_jsp_text[53]);
       }else{ 
      out.write(__oracle_jsp_text[54]);
       } 
      out.write(__oracle_jsp_text[55]);
       j++; 
      out.write(__oracle_jsp_text[56]);
       } 
      out.write(__oracle_jsp_text[57]);
       } 
      out.write(__oracle_jsp_text[58]);
       } 
      out.write(__oracle_jsp_text[59]);
       if(j == 0){ 
      out.write(__oracle_jsp_text[60]);
       } else {
      out.write(__oracle_jsp_text[61]);
      
      			int numeroPaginas = (sql!=null)?numeroRegistros/regPorPagina:0;	
      			if (numeroRegistros%regPorPagina != 0)
      				numeroPaginas++; 
      			if (contligas>0 && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[62]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[63]);
      out.print( (contligas-muestraPaginas<0)?0:contligas-muestraPaginas );
      out.write(__oracle_jsp_text[64]);
      	}
      			if (contPag > 0){  
      				if (contPag > contligas){
      out.write(__oracle_jsp_text[65]);
      out.print(contligas);
      out.write(__oracle_jsp_text[66]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[67]);
      	}else{
      out.write(__oracle_jsp_text[68]);
      out.print(contligas-1);
      out.write(__oracle_jsp_text[69]);
      out.print(contPag-1);
      out.write(__oracle_jsp_text[70]);
      	} 
      			}
      			if (numeroPaginas > 1){
      				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
      					if (i==contPag){  
      out.write(__oracle_jsp_text[71]);
      out.print(i);
      out.write(__oracle_jsp_text[72]);
      out.print(i+1);
      out.write(__oracle_jsp_text[73]);
      		}else{ 
      out.write(__oracle_jsp_text[74]);
      out.print(i);
      out.write(__oracle_jsp_text[75]);
      out.print(i+1);
      out.write(__oracle_jsp_text[76]);
      		}
      				}
      			} 
      			if (contPag < numeroPaginas-1){  
      				if (contPag < contligas + muestraPaginas-1){
      out.write(__oracle_jsp_text[77]);
      out.print(contligas);
      out.write(__oracle_jsp_text[78]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[79]);
      	}else{
      out.write(__oracle_jsp_text[80]);
      out.print(contligas+1);
      out.write(__oracle_jsp_text[81]);
      out.print(contPag+1);
      out.write(__oracle_jsp_text[82]);
      	} 
      			}
      			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  
      out.write(__oracle_jsp_text[83]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[84]);
      out.print( contligas+muestraPaginas );
      out.write(__oracle_jsp_text[85]);
       	} 
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
    "\n<HTML>\n<HEAD>\n<TITLE>Unidad Administrativa</TITLE>\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\n".toCharArray();
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
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT language=\"JavaScript\" src=\"../js/GeneralFunctions.js\"></SCRIPT>\n<script language=\"JavaScript\" type=\"text/javascript\">\n\tfunction cambio(o, t){\n\t\tdoc = document.AreaView;\n\t\tdoc.accion.value=\"reload\";\n\t\tdoc.ordenExt.value=doc.orden.value;\n\t\tdoc.tipoExt.value=doc.tipo.value;\n\t\tdoc.orden.value=o;\n\t\tdoc.tipo.value=t;\n\t\tdoc.submit();\n\t}\nfunction pagina(contador){\n\tdoc = document.AreaView;\n\tdoc.contPag.value=contador;\n\tdoc.submit();\n}\n\nfunction paginaLiga(contador){\n\tdoc = document.AreaView;\n\tdoc.contligas.value=contador;\n\tdoc.submit();\n}\n\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<span id=\"ruler\" style=\"visibility:hidden;\"></span> \n<FORM action=\"AreaView.jsp\" name=\"AreaView\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"\">\n<INPUT type=\"hidden\" name=\"orden\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipo\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\">\n<INPUT type=\"hidden\" name=\"ordenExt\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\">\n<INPUT type=\"hidden\" name=\"tipoExt\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"contPag\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"contligas\">\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"43%\" class=\"etiquetas\">\n\t\t\t\t<FONT size=\"1\" color=\"RED\">\n\t\t\t\t&nbsp;&nbsp;No se pueden eliminar las siguientes Unidades Administrativas (razones)<BR><BR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\">\n\t\t\t\t&nbsp;&nbsp;** ".toCharArray();
    __oracle_jsp_text[20] = 
    " **&nbsp;&nbsp;</A> tiene ".toCharArray();
    __oracle_jsp_text[21] = 
    "<BR>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<br>\n".toCharArray();
    __oracle_jsp_text[23] = 
    "\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR>\n\t\t\t<TD width=\"40%\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\t\t\t\t<A href=\"Area.jsp?retURI=".toCharArray();
    __oracle_jsp_text[25] = 
    "\" target=\"_self\"> \n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/nuevo1.gif\" width=\"27\" height=\"26\" alt=\"Nueva Unidad Administrativa\"> </A> \n\t\t\t\t<A href=\"javascript:Borrar()\" target=\"_self\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/borrar1.gif\" width=\"30\" height=\"27\" alt=\"Borrar Unidad Administrativa\"></A>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t</TD>\n\t\t\t<TD width=\"50%\">\n\t\t\t<DIV align=\"right\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    " registros mostrados.\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t\t\tPagina ".toCharArray();
    __oracle_jsp_text[32] = 
    " de ".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t\t</DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"10%\"> &nbsp;\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t<TR bgcolor=\"#00204f\">\n\t\t\t<TD id=\"Asunto_HD\" width=\"50%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 1)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Unidad Administrativa</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 1)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"50%\" align=\"center\">\n\t\t\t<a onclick=\"cambio('asc', 3)\"><IMG border=\"0\" src=\"../Imagenes/arriba.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t<b><FONT size=\"2\" color=\"white\" face=\"verdana\">Puesto -- Responsable</FONT></b>\n\t\t\t<a onclick=\"cambio('desc', 3)\"><IMG border=\"0\" src=\"../Imagenes/abajo.gif\" align=\"middle\" width=\"10\" height=\"10\"></a>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV class=documentBody id=Body>\n<DIV id=\"view\">\n".toCharArray();
    __oracle_jsp_text[36] = 
    "\n<TABLE width=\"100%\" border=\"0\">\n\t<TBODY>\n\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t<TR>\n\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No Hay Areas\n\t\t\tCapturadas******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[39] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "\n\t\t\t<TR vAlign=top ".toCharArray();
    __oracle_jsp_text[42] = 
    "bgcolor=\"#f6f6f6\"".toCharArray();
    __oracle_jsp_text[43] = 
    " >\n\t\t\t\t<TD width=\"50%\">\n\t\t\t\t\t<INPUT type=checkbox value=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "\" name=\"Borrar\">\n\t\t\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t\t<A href=\"Area.jsp?id_area=".toCharArray();
    __oracle_jsp_text[45] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[46] = 
    "\" title=\"".toCharArray();
    __oracle_jsp_text[47] = 
    "\">\n\t\t\t\t\t\t<script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[48] = 
    "','Asunto_HD'));</script></A>\n\t\t\t\t\t</FONT>\n\t\t\t\t</TD>\n\t\t\t\t<TD width=\"50%\" align=\"center\" valign=\"middle\">\n\t\t\t\t\t<A title=\"".toCharArray();
    __oracle_jsp_text[49] = 
    " -- ".toCharArray();
    __oracle_jsp_text[50] = 
    "\" >\n\t\t\t\t\t<FONT face=Arial color=#000080 size=1>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t\t<script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[52] = 
    "','Asunto_HD2'));</script> -- <script>document.write(trunc('".toCharArray();
    __oracle_jsp_text[53] = 
    "','Asunto_HD2'));</script>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "[No tiene Supervisor Asignado]".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t\t\t</FONT>\n\t\t\t\t\t</A>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t<TR>\n\t\t\t<TD width=\"100%\">\n\t\t\t<div align=center><FONT face=\"verdana\" size=\"4\">******No hay Alguna Unidad Administrativa\n\t\t\tCapturada ******</FONT></div>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t<TR>\n\t\t<TD colspan=\"3\" align=\"center\"><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[63] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[64] = 
    ");\"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;\n\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[66] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[67] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[69] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[70] = 
    ");\"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[72] = 
    ")\"><FONT color=\"red\"><B>[".toCharArray();
    __oracle_jsp_text[73] = 
    "]</B></FONT></A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t\t\t\t<A onclick=\"pagina(".toCharArray();
    __oracle_jsp_text[75] = 
    ")\">".toCharArray();
    __oracle_jsp_text[76] = 
    "</A> &nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[78] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[79] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[81] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[82] = 
    ");\"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t\t<A onclick=\"paginaLiga(".toCharArray();
    __oracle_jsp_text[84] = 
    ");pagina(".toCharArray();
    __oracle_jsp_text[85] = 
    ");\"> <B> | Siguiente&gt;&gt;</B> </A>\n\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t</TD>\n\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t</TBODY>\n</TABLE>\n</DIV>\n<BR>\n</DIV>\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n<BR>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
