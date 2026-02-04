package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import java.util.ArrayList;
import com.meve.sigma.taglib.*;


public class _HistorialAsunto extends com.orionserver.http.OrionHttpJspPage {


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
    _HistorialAsunto page = this;
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
      
      	String strSeleccion		=	""; 
      	String strUsuarioSel	=	"";
      	String strAreaSel		=	"";
      	String strSupervisor	=	"";
      	String strOrganigrama	=	"";
      	String strMes	=	"";
      	String strAsistente		=	"";
      
      	String strCompanieros[][]		=	null;
      	java.util.Stack st = new java.util.Stack();
      	String cadenaMandoUsuario[][]	=	null;
      	String usuario [][]				=	null;
      	String area[][]					=	null;
      	String strMiembros[][]			=	null;
      	ArrayList subalternosUsuario	=	null;
      
      	strSeleccion	=	request.getParameter("laSeleccion");
      	strUsuarioSel	=	request.getParameter("usuarioSeleccionado");
      	strAreaSel		=	request.getParameter("areaSeleccionada");
      	strOrganigrama	=	request.getParameter("Organigrama");
      	strMes	=	request.getParameter("mesSeleccionado");
      
      	if(strSeleccion != null)
      		strSeleccion=strSeleccion.toLowerCase();
       
       	boolean existeSeleccion	=	strSeleccion != null;
      	
       	String usuarios[][]	=	ActualizaUsuario.getListaUsuarios();
       	String areas[][]	=	ActualizaUsuario.getAreas();
      	
      	//** Se ejecuta cuando es seleccionado un Usuario
      	if(strUsuarioSel != null && strUsuarioSel.length() > 0)
      	{
      		ActualizaUsuario.getHistConfig(strUsuarioSel,strAreaSel,strMes); 
      
      	}
      
      
      out.write(__oracle_jsp_text[4]);
      out.print(strUsuarioSel);
      out.write(__oracle_jsp_text[5]);
      out.print(strAreaSel);
      out.write(__oracle_jsp_text[6]);
      out.print(strOrganigrama);
      out.write(__oracle_jsp_text[7]);
      out.print(strMes);
      out.write(__oracle_jsp_text[8]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getUsuarioCombo());
        __jsp_taghandler_1.setName("usuarios");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected("");
        __jsp_taghandler_1.setClassHtml("blue200");
        __jsp_taghandler_1.setScript("onclick=''");
        __jsp_taghandler_1.setTextoNoSeleccion(" -- Seleccionar Usuario --");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[9]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ActualizaUsuario.getAreas());
        __jsp_taghandler_2.setName("areas");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected("");
        __jsp_taghandler_2.setClassHtml("blue200");
        __jsp_taghandler_2.setScript("onclick=''");
        __jsp_taghandler_2.setTextoNoSeleccion(" -- Seleccionar Unidad Administrativa --");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[10]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ActualizaUsuario.getMeses());
        __jsp_taghandler_3.setName("mes");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected("");
        __jsp_taghandler_3.setClassHtml("blue200");
        __jsp_taghandler_3.setScript("onclick=''");
        __jsp_taghandler_3.setTextoNoSeleccion(" -- Seleccionar Rango --");
        __jsp_taghandler_3.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[11]);

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
  private static final char __oracle_jsp_text[][]=new char[12][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Historial</TITLE>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\t\n\tfunction seleccion()\n\t{\n  \t\t\n\n\t\tusu = document.historiaform.usuarios.value;\n\t\tarea = document.historiaform.areas.value;\n\t\tmes = document.historiaform.mes.value;\n\n\tlocation.assign('HistorialAsunto.jsp?usuarioSeleccionado='+usu+'&areaSeleccionada='+area+'&mesSeleccionado='+mes);\n\n\t}\n\n\tfunction obtenSeleccion(control)\n\t{\n    \tif(control.selected)\n\t\t\treturn control.value;\n\t\telse\n    \t\tfor(var i=0;i<control.length;i++){\n\n        \tif(control[i].selected)\n\t\t\t\treturn control[i].value;\n\t\t}\n\t}\n\n\tvar digitos=10 //cantidad de digitos buscados \n\tvar puntero=0 \n\tvar buffer=new Array(digitos) //declaración del array Buffer \n\tvar cadena=\"\" \n\n\tfunction buscar_opOR(obj){\n\t\tvar forma=document.laForma;\n\t   \tvar letra = String.fromCharCode(event.keyCode)\n\t   \tif(puntero >= digitos){ \n\t    \tcadena=\"\"; \n\t       \tpuntero=0; \n\t    } \n\t   \tif (event.keyCode == 13){ \n\t    \tborrar_buffer(); \n\t\t\tvar cad=\"\";\n\t\t\tif(obj.options[obj.selectedIndex].value!=\"-1\")\n\t\t\t{\n\t\t\t\tvar a = forma.usuarios.value;\n\t\t\t\t//location.assign('Pasos.jsp?id_area='+a);\n\t\t\t\tlocation.assign('Organigrama.jsp?usuarioSeleccionado='+a);\n\t\t\t}\n\t    } \n\t   \telse{ \n\t       \tbuffer[puntero]=letra; \n\t       \tcadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array \n\t       \tpuntero++; \n\t\n\t       \tfor (var opcombo=0;opcombo < obj.length;opcombo++){ \n\t          \tif(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ \n\t          \t\tobj.selectedIndex=opcombo; \n\t        \t} \n\t       \t} \n\t    } \n\t   \tevent.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter \n\t}\n\tfunction borrar_bufferOR(){ \n    \tcadena=\"\"; \n    \tpuntero=0; \n\t}\n\n\tfunction buscar_opAR(obj){\n\t\tvar forma=document.laForma;\n\t   \tvar letra = String.fromCharCode(event.keyCode)\n\t   \tif(puntero >= digitos){ \n\t    \tcadena=\"\"; \n\t       \tpuntero=0; \n\t    } \n\t   \tif (event.keyCode == 13){ \n\t    \tborrar_buffer(); \n\t\t\tvar cad=\"\";\n\t\t\tif(obj.options[obj.selectedIndex].value!=\"-1\")\n\t\t\t{\n\t\t\t\tvar a = forma.areas.value;\n\t\t\t\t//location.assign('Pasos.jsp?id_area='+a);\n\t\t\t\tlocation.assign('Organigrama.jsp?areaSeleccionada='+a);\n\t\t\t}\n\t    } \n\t   \telse{ \n\t       \tbuffer[puntero]=letra; \n\t       \tcadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array \n\t       \tpuntero++; \n\t\n\t       \tfor (var opcombo=0;opcombo < obj.length;opcombo++){ \n\t          \tif(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ \n\t          \t\tobj.selectedIndex=opcombo; \n\t        \t} \n\t       \t} \n\t    } \n\t   \tevent.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter \n\t}\n\tfunction borrar_bufferAR(){ \n    \tcadena=\"\"; \n    \tpuntero=0; \n\t}\n\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"historiaform\" action=\"HistorialAsunto.jsp\" method=\"post\">\n<input type=\"hidden\" name=\"laSeleccion\" value=\"\">\n<input type=\"hidden\" name=\"usuarioSeleccionado\" value=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "\">\n<input type=\"hidden\" name=\"areaSeleccionada\" value=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\">\n<input type=\"hidden\" name=\"Organigrama\" value=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "\">\n<input type=\"hidden\" name=\"mesSeleccionada\" value=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\">\n<br>\n<DIV align=\"center\">\n<TABLE border=\"1\">\n\t<TR>\n\t\t<TD align=\"center\" width=\"228\"><b>Historial</b></TD>\n\t\t\n\t</TR>\n\t<TR align=\"center\">\n\t\t<TD align=\"center\" width=\"228\">".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t</TD>\n\t</TR>\n\t<TR align=\"center\">\n\t\t<TD align=\"center\" width=\"228\">".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t</TD>\n\t</TR>\n\t<TR align=\"center\">\n\t\t<TD align=\"center\" width=\"228\">".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t</TD>\n\t</TR>\n\t<TR align=\"center\">\n\t\t<TD align=\"center\" rowspan=\"2\" Valign=\"bottom\" width=\"229\">\n\t\t\t<!-- <INPUT type=\"button\" value=\"Organigrama\" name=\"organigramaBtn\" onclick=\"seleccion('organigrama')\"> -->\n\t\t\t<INPUT type=\"button\" value=\"Aplicar\" name=\"aplicar\" onclick=\"seleccion()\">\n\t\t</TD>\n\t</TR>\n</TABLE>\n</DIV>\n<br>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
