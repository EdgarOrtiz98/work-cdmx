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


public class _Organigrama extends com.orionserver.http.OrionHttpJspPage {


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
    _Organigrama page = this;
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
      
      
      out.write(__oracle_jsp_text[4]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[5]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[6]);
       } 
      out.write(__oracle_jsp_text[7]);
      
      	String strSeleccion		=	""; 
      	String strUsuarioSel	=	"";
      	String strAreaSel		=	"";
      	String strSupervisor	=	"";
      	String strOrganigrama	=	"";
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
      	if(strSeleccion != null)
      		strSeleccion=strSeleccion.toLowerCase();
       
       	boolean existeSeleccion	=	strSeleccion != null;
      	
       	String usuarios[][]	=	ActualizaUsuario.getListaUsuarios();
       	String areas[][]	=	ActualizaUsuario.getAreas();
      	
      	//** Se ejecuta cuando es seleccionado un Usuario
      	if(strUsuarioSel != null && strUsuarioSel.length() > 0)
      	{
      		usuario	=	ActualizaUsuario.getIDUsuarioBean(strUsuarioSel); 
      		if(usuario!=null)
      		{
      			String areaUsuario				=	usuario[0][5];
      			String idUsuario				=	usuario[0][0];
      			strCompanieros	=	ActualizaUsuario.getCompanierosArea(idUsuario);
      			strAsistente	=	strCompanieros[0][8];
      			st = ActualizaUsuario.getCadenaDeMandoPara(idUsuario);
      			
      			subalternosUsuario	=	ActualizaUsuario.getSubalternosDe(idUsuario);
      			//UsuarioBean asistenteUsuario	=	ActualizaUsuario.getAsistenteDe(idUsuario);
      			
              	int i=0;
              	for(;i<areas.length;i++)
      				if(areas[i][0].trim().equalsIgnoreCase(areaUsuario.trim())){
      					areaUsuario=areas[i][1];
                      	break;
      				}
      				if(i==areas.length){
                 			areaUsuario="Desconocida";
      				}
      		}
      	}
      
      	//** Se ejecuta cuando es seleccionado un área
      	if(strAreaSel != null && strAreaSel.length() > 0)
      	{
      		area	=	ActualizaArea.getIDArea(strAreaSel);
      		strMiembros		=	ActualizaArea.getMiembrosArea(strAreaSel);
      		if(area.length != 0)
      		{
      			strSupervisor	=	area[0][2];
      		}else{
      			strSupervisor	=	"La UA no tiene un Supervisor asignado";
      		}
      	}
      
      
      out.write(__oracle_jsp_text[8]);
      out.print(strUsuarioSel);
      out.write(__oracle_jsp_text[9]);
      out.print(strAreaSel);
      out.write(__oracle_jsp_text[10]);
      out.print(strOrganigrama);
      out.write(__oracle_jsp_text[11]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getUsuarioCombo());
        __jsp_taghandler_1.setName("usuarios");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected("");
        __jsp_taghandler_1.setClassHtml("blue300a");
        __jsp_taghandler_1.setScript("onchange=seleccion('usuario') onKeypress='buscar_opOR(this)' onblur='borrar_bufferOR()' onclick='borrar_bufferOR()'");
        __jsp_taghandler_1.setTextoNoSeleccion(" -- Seleccionar Puesto --");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[12]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ActualizaUsuario.getAreas());
        __jsp_taghandler_2.setName("areas");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected("");
        __jsp_taghandler_2.setClassHtml("blue300a");
        __jsp_taghandler_2.setScript("onchange=seleccion('area') onKeypress='buscar_opAR(this)' onblur='borrar_bufferAR()' onclick='borrar_bufferAR()'");
        __jsp_taghandler_2.setTextoNoSeleccion(" -- Seleccionar Unidad --");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[13]);
       if(strUsuarioSel != null && strUsuarioSel.length() > 0){ 
      out.write(__oracle_jsp_text[14]);
      out.print(usuario[0][1]);
      out.write(__oracle_jsp_text[15]);
      out.print(ActualizaArea.NombreArea(usuario[0][5]));
      out.write(__oracle_jsp_text[16]);
       if(strCompanieros.length > 0){ 
      out.write(__oracle_jsp_text[17]);
       for(int i=0;i<strCompanieros.length;i++){ 
      out.write(__oracle_jsp_text[18]);
      out.print(strCompanieros[i][1]);
      out.write(__oracle_jsp_text[19]);
       if(!(i == strCompanieros.length-1)){ 
      out.write(__oracle_jsp_text[20]);
       } 
      out.write(__oracle_jsp_text[21]);
       } 
      out.write(__oracle_jsp_text[22]);
       }else{ 
      out.write(__oracle_jsp_text[23]);
       } 
      out.write(__oracle_jsp_text[24]);
      
      			if(st.size() > 0){
      			for(int y = 0; y<st.size();y++){
      		
      out.write(__oracle_jsp_text[25]);
       if(st.elementAt(y) != null){ 
      out.write(__oracle_jsp_text[26]);
      out.print(st.elementAt(y));
      out.write(__oracle_jsp_text[27]);
       }
      out.write(__oracle_jsp_text[28]);
      
      			}}
      		
      out.write(__oracle_jsp_text[29]);
      
      			if(subalternosUsuario.size()>0)
      			for(int t=0;t<subalternosUsuario.size();t++){
      		
      out.write(__oracle_jsp_text[30]);
      out.print(subalternosUsuario.get(t));
      out.write(__oracle_jsp_text[31]);
       if(!(t==subalternosUsuario.size()-1)){ 
      out.write(__oracle_jsp_text[32]);
       } 
      out.write(__oracle_jsp_text[33]);
      
      			}
      		
      out.write(__oracle_jsp_text[34]);
       if(!strCompanieros[0][8].equals("-1")){ 
      out.write(__oracle_jsp_text[35]);
      out.print(ActualizaUsuario.NombreUsuario(strCompanieros[0][8]));
      out.write(__oracle_jsp_text[36]);
       }else{ 
      out.write(__oracle_jsp_text[37]);
       } 
      out.write(__oracle_jsp_text[38]);
       } 
      out.write(__oracle_jsp_text[39]);
       if(strAreaSel != null && strAreaSel.length() > 0){ 
      out.write(__oracle_jsp_text[40]);
      out.print(strSupervisor);
      out.write(__oracle_jsp_text[41]);
       if(strMiembros.length > 0){ 
      out.write(__oracle_jsp_text[42]);
       for(int j=0;j<strMiembros.length;j++){ 
      out.write(__oracle_jsp_text[43]);
      out.print(strMiembros[j][0]);
      out.write(__oracle_jsp_text[44]);
       if(!(j == strMiembros.length-1)){ 
      out.write(__oracle_jsp_text[45]);
       } 
      out.write(__oracle_jsp_text[46]);
       } 
      out.write(__oracle_jsp_text[47]);
       }else{ 
      out.write(__oracle_jsp_text[48]);
       } 
      out.write(__oracle_jsp_text[49]);
       } 
      out.write(__oracle_jsp_text[50]);
       if(strOrganigrama != null && strOrganigrama.length() > 0){ 
      out.write(__oracle_jsp_text[51]);
      
      	////System.out.println("** Entra al bloque del organigrama **");
      		ArrayList jerarquia = ActualizaUsuario.getOrganigrama();
          	for(int i=0;i<jerarquia.size();i++){
      			if(jerarquia.get(i) instanceof ArrayList){
      
          		ArrayList nivel=(ArrayList)jerarquia.get(i);
              	for(int k=0;k<nivel.size();k++){
              		if(nivel.get(k) instanceof UsuarioBean){
              	    	UsuarioBean usuario1=(UsuarioBean)nivel.get(k);
      
      out.write(__oracle_jsp_text[52]);
      out.print((usuario1.getCargo()!=null && usuario1.getCargo().length()>0?usuario1.getCargo():"----"));
      out.write(__oracle_jsp_text[53]);
      out.print((usuario1.getNombre()!=null && usuario1.getNombre().length()>0?usuario1.getNombre():"----"));
      out.write(__oracle_jsp_text[54]);
      out.print((usuario1.getIdJefe()!=null && usuario1.getIdJefe().length()>0?usuario1.getIdJefe():"----" ));
      out.write(__oracle_jsp_text[55]);
       				}
      			}
      			}
      		}
      	}
      
      out.write(__oracle_jsp_text[56]);

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
  private static final char __oracle_jsp_text[][]=new char[57][];
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
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<TITLE>Organigrama</TITLE>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n\t\n\tfunction seleccion(valor)\n\t{\n  \t\tdocument.laForma.laSeleccion.value=''+valor+'';\n  \t\t\n  \t\tif(document.laForma.laSeleccion.value=='usuario')\n\t\t{\n\t    \tvalorSeleccionado=obtenSeleccion(document.laForma.usuarios);\n\t\t\tif(valorSeleccionado == -1){\n\t\t\t\talert('Selecciona un Usuario');\n\t\t\t}\n\t\t\tlocation.assign('Organigrama.jsp?usuarioSeleccionado='+valorSeleccionado);\n\t  \t}\n\t\tif(document.laForma.laSeleccion.value=='area')\n\t\t{\n\t\t\tvalorSeleccionado=obtenSeleccion(document.laForma.areas);\n\t\t\tif(valorSeleccionado == -1){\n\t\t\t\talert('Selecciona una Unidad');\n\t\t\t}\n\t\t\tlocation.assign('Organigrama.jsp?areaSeleccionada='+valorSeleccionado);\n\t   \t}\n\t\tif(document.laForma.laSeleccion.value=='organigrama')\n\t\t{\n\t\t\tvalorSeleccionado = valor;\n\t\t\tlocation.assign('Organigrama.jsp?Organigrama='+valorSeleccionado);\n\t\t}\n\t}\n\n\tfunction obtenSeleccion(control)\n\t{\n    \tif(control.selected)\n\t\t\treturn control.value;\n\t\telse\n    \t\tfor(var i=0;i<control.length;i++){\n\n        \tif(control[i].selected)\n\t\t\t\treturn control[i].value;\n\t\t}\n\t}\n\n\tvar digitos=10 //cantidad de digitos buscados \n\tvar puntero=0 \n\tvar buffer=new Array(digitos) //declaración del array Buffer \n\tvar cadena=\"\" \n\n\tfunction buscar_opOR(obj){\n\t\tvar forma=document.laForma;\n\t   \tvar letra = String.fromCharCode(event.keyCode)\n\t   \tif(puntero >= digitos){ \n\t    \tcadena=\"\"; \n\t       \tpuntero=0; \n\t    } \n\t   \tif (event.keyCode == 13){ \n\t    \tborrar_buffer(); \n\t\t\tvar cad=\"\";\n\t\t\tif(obj.options[obj.selectedIndex].value!=\"-1\")\n\t\t\t{\n\t\t\t\tvar a = forma.usuarios.value;\n\t\t\t\t//location.assign('Pasos.jsp?id_area='+a);\n\t\t\t\tlocation.assign('Organigrama.jsp?usuarioSeleccionado='+a);\n\t\t\t}\n\t    } \n\t   \telse{ \n\t       \tbuffer[puntero]=letra; \n\t       \tcadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array \n\t       \tpuntero++; \n\t\n\t       \tfor (var opcombo=0;opcombo < obj.length;opcombo++){ \n\t          \tif(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ \n\t          \t\tobj.selectedIndex=opcombo; \n\t        \t} \n\t       \t} \n\t    } \n\t   \tevent.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter \n\t}\n\tfunction borrar_bufferOR(){ \n    \tcadena=\"\"; \n    \tpuntero=0; \n\t}\n\n\tfunction buscar_opAR(obj){\n\t\tvar forma=document.laForma;\n\t   \tvar letra = String.fromCharCode(event.keyCode)\n\t   \tif(puntero >= digitos){ \n\t    \tcadena=\"\"; \n\t       \tpuntero=0; \n\t    } \n\t   \tif (event.keyCode == 13){ \n\t    \tborrar_buffer(); \n\t\t\tvar cad=\"\";\n\t\t\tif(obj.options[obj.selectedIndex].value!=\"-1\")\n\t\t\t{\n\t\t\t\tvar a = forma.areas.value;\n\t\t\t\t//location.assign('Pasos.jsp?id_area='+a);\n\t\t\t\tlocation.assign('Organigrama.jsp?areaSeleccionada='+a);\n\t\t\t}\n\t    } \n\t   \telse{ \n\t       \tbuffer[puntero]=letra; \n\t       \tcadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array \n\t       \tpuntero++; \n\t\n\t       \tfor (var opcombo=0;opcombo < obj.length;opcombo++){ \n\t          \tif(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ \n\t          \t\tobj.selectedIndex=opcombo; \n\t        \t} \n\t       \t} \n\t    } \n\t   \tevent.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter \n\t}\n\tfunction borrar_bufferAR(){ \n    \tcadena=\"\"; \n    \tpuntero=0; \n\t}\n\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load()\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"laForma\" action=\"Organigrama.jsp\" method=\"post\">\n<input type=\"hidden\" name=\"laSeleccion\" value=\"\">\n<input type=\"hidden\" name=\"usuarioSeleccionado\" value=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\">\n<input type=\"hidden\" name=\"areaSeleccionada\" value=\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\">\n<input type=\"hidden\" name=\"Organigrama\" value=\"".toCharArray();
    __oracle_jsp_text[11] = 
    "\">\n<br>\n<DIV align=\"center\">\n<TABLE border=\"1\">\n\t<TR>\n\t\t<TD align=\"center\" width=\"300\"><b>Puesto</b></TD>\n\t\t<TD align=\"center\" width=\"300\"><b>Unidad Administrativa</b></TD>\n\t\t<!-- <TD align=\"center\" width=\"229\"><b>Organigrama</b></TD> -->\n\t\t\n\t</TR>\n\t<TR align=\"center\">\n\t\t<TD align=\"center\" width=\"300\">".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\t\t</TD>\n\t\t<TD align=\"center\" width=\"300\">".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\t\t</TD>\n\t\t<!-- <TD align=\"center\" rowspan=\"2\" Valign=\"bottom\" width=\"229\">\n\t\t\t<INPUT type=\"button\" value=\"Organigrama\" name=\"organigramaBtn\" onclick=\"seleccion('organigrama')\">\n\t\t</TD> -->\n\t</TR>\n</TABLE>\n</DIV>\n<br>\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n<DIV align=\"center\">\n<TABLE border=\"1\">\n\t<tr bgcolor=\"#00204f\">\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT size=\"2\" face=\"verdana\" color=\"white\"><B>Puesto</B></FONT>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">".toCharArray();
    __oracle_jsp_text[15] = 
    "</FONT>\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#00204f\">\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT size=\"2\" face=\"verdana\" color=\"white\"><B>Unidad Administrativa</B></FONT>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">".toCharArray();
    __oracle_jsp_text[16] = 
    "</FONT>\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#00204f\">\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT size=\"2\" face=\"verdana\" color=\"white\"><B>Compañeros de la Unidad</B></FONT>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\">\n\t\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[18] = 
    "\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[19] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t\t\t\t,\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[21] = 
    "\n\t\t\t</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n\t\t\n\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    " <FONT face=\"Verdana\" size=\"2\">No tiene Compañeros</FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "</TD>\n\t</tr>\n\t<tr bgcolor=\"#00204f\">\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT size=\"2\" face=\"verdana\" color=\"white\"><B>Cadena de Mando</B></FONT>\n\t\t</TD>\n\t</tr>\n\t<tr align=\"left\">\n\t\t<TD align=\"left\" width=\"696\">\n\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t</FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#00204f\">\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT size=\"2\" face=\"verdana\" color=\"white\"><B>SubAlternos</B></FONT>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\">\n\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t,\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t</FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#00204f\">\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT size=\"2\" face=\"verdana\" color=\"white\"><B>Asistente</B></FONT>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t<td align=\"left\" width=\"696\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t</FONT>\n\t\t</td>\n\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">** No tiene asignado un Asistente **</FONT>\n\t\t</TD>\n\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t</tr>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[39] = 
    "\n".toCharArray();
    __oracle_jsp_text[40] = 
    "\n<DIV align=\"center\">\n<TABLE border=\"1\">\n\t<tr bgcolor=\"#00204f\">\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT size=\"2\" face=\"verdana\" color=\"white\"><B>Responsable de la Unidad</B></FONT>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">".toCharArray();
    __oracle_jsp_text[41] = 
    "</FONT>\n\t\t</TD>\n\t</tr>\n\t<tr bgcolor=\"#00204f\">\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t<FONT size=\"2\" face=\"verdana\" color=\"white\"><B>Miembros de la Unidad</B></FONT>\n\t\t</TD>\n\t</tr>\n\t<tr>\n\t\t<TD align=\"left\" width=\"696\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t\t\t,\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t</FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">No tiene Puesto registrados en la Unidad</FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t</TD>\n\t</tr>\n</TABLE>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[50] = 
    "\n".toCharArray();
    __oracle_jsp_text[51] = 
    "\n".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[53] = 
    "<br>\n\t".toCharArray();
    __oracle_jsp_text[54] = 
    "<br>\n\t".toCharArray();
    __oracle_jsp_text[55] = 
    "<br>\n\t---------------------<br><br>\n".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\n\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
