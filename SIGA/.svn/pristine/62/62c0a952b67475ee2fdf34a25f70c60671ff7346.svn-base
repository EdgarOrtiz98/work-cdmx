package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.taglib.*;
import java.util.*;
import com.meve.sigma.util.*;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import gob.hacienda.cgtic.siga.Usuario;
import gob.hacienda.cgtic.siga.util.Items;
import gob.hacienda.cgtic.siga.instruccion.Rechazo;


public class _ReasignarRechazo extends com.orionserver.http.OrionHttpJspPage {


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
    _ReasignarRechazo page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("header.jsp");
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
      out.write(__oracle_jsp_text[7]);
      out.write(__oracle_jsp_text[8]);
      out.write(__oracle_jsp_text[9]);
      
      	String strIdAsunto		=	"";
      	String strIdInstruc		=	"";
      	String strAvance		=	"";
      	strIdInstruc			=	(request.getParameter("id_ins") != null)?request.getParameter("id_ins"):"";
      	strIdAsunto				=	(request.getParameter("id_asunto") != null)?request.getParameter("id_asunto"):"";
      	strAvance				=	(request.getParameter("ava") != null)?request.getParameter("ava"):""; 
      	String turno			=	ActualizaInstrucciones.getTurnador(strIdInstruc);
              UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
      	String strTmp = request.getRequestURI();
      	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+strTmp+"?id_ins="+strIdInstruc+"&id_asunto="+strIdAsunto+"&ava="+strAvance);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("E/RROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[10]);
      
      	
      	String strIdUsuario		=	"";
      	String strComentarios	=	"";
      	String strAccion		=	"";
      	String strFechaCreacion	=	"";
      	String strIdArea		=	"";
      	boolean bReasignar		=	false;
      	boolean bInsertar		=	false;
      	boolean bInsertarBit	=	false;
      	
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      	
      	String strIdUsrReasigna	=	BUsuario.getIdUsuario();
      	
      	strAccion	=	request.getParameter("accion");
      	strIdArea	=	(request.getParameter("id_area") != null)?request.getParameter("id_area"):"";
      	strIdUsuario=	(request.getParameter("id_usuario") != null)?request.getParameter("id_usuario"):"";
      	strComentarios= (request.getParameter("reasignarComen") != null)?request.getParameter("reasignarComen"):"";
      
      	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
              String retURI2 = (request.getParameter("retURI2")== null)?"portalPrincipal.jsp":request.getParameter("retURI2");
      	boolean bValidaEstatus = false;
      	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
      	if (strIdInstruc!=null && !strIdInstruc.equals("")){
      		if (strEstValidacion.equals("")){
      			strEstValidacion = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruc);
      		}
      		String strEstatusValida = ActualizaInstrucciones.getEstatusPorInstruccion(strIdInstruc);
      		if (!strEstatusValida.equals(strEstValidacion)){ 
      			bValidaEstatus = true; 
      		}
      	}
      
      	if(!bValidaEstatus && strAccion != null && strAccion.equals("guardar")){
      		strIdInstruc	=	request.getParameter("id_ins");
      		strIdAsunto		=	request.getParameter("id_asunto");
      		strAvance		=	request.getParameter("ava");
      		strIdUsuario	=	request.getParameter("reasignarUsr");
      		strComentarios	=	request.getParameter("reasignarComen");
      		strIdArea		=	request.getParameter("id_area");
                      
                      if(BUsuario.getAsistente()){
                          try{
                              bInsertar = ActualizaHistorial.InsertarReasignacion(strIdInstruc, strIdAsunto, strComentarios,Usuario.aTitular(BUsuario.getIdUsuario()), strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre()+" en Nombre de "+Rechazo.aNombre(BUsuario,strIdInstruc));
                          }catch(Exception e){ 
                          }
                      }
                      else
                          bInsertar = ActualizaHistorial.InsertarReasignacion(strIdInstruc, strIdAsunto, strComentarios,strIdUsrReasigna, strFechaCreacion, BUsuario.getCargo()+" / "+BUsuario.getNombre());
                      
                      bReasignar = ActualizaInstrucciones.ActualizaReasignar(strIdInstruc, strIdUsuario, strAvance);
      
      		String strFolioBit = ActualizaInstrucciones.getUltimoFolioTurnado(strIdInstruc);
      		bInsertarBit	=	ActualizaBitacora.InsertarEventoReasignar(BUsuario.getIdUsuario(), strFolioBit);
      		
      		String strUsr[][]			=	ActualizaUsuario.NombreMailUsuario(strIdUsuario);
      		String UsrNombreResponde = BUsuario.getCargo()+"/"+BUsuario.getNombre();
      		String UsrMailResponde		=	BUsuario.getCorreo();
      		String UsrDirigido			=	strUsr[0][2];
      		String UsrMailDirigido		=	strUsr[0][1];
      		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
      		String portServer = application.getInitParameter("PortMail");
      		String serverName = application.getInitParameter("servername");
      		String strRutaBase = (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
      		
      		
      				if (ActualizaUsuario.getNotificacionMail(strIdUsuario)){
      					SenderMail mail = new SenderMail();
      					mail.sendNotificarInstruccionReasignada(
      							UsrMailDirigido, UsrDirigido,
      							UsrNombreResponde, Integer
      							.parseInt(strIdInstruc),
      							strComentarios, session.getServletContext());
      				}
      				
      		try{
                          response.sendRedirect(retURI2);
      		}catch(java.io.IOException io){
      		}
      	}
      	
      
      out.write(__oracle_jsp_text[11]);
      out.print(strIdInstruc);
      out.write(__oracle_jsp_text[12]);
      out.print( retURI );
      out.write(__oracle_jsp_text[13]);
      out.print(strIdInstruc);
      out.write(__oracle_jsp_text[14]);
      out.print(strIdAsunto);
      out.write(__oracle_jsp_text[15]);
      out.print(strAvance);
      out.write(__oracle_jsp_text[16]);
      out.print( strIdInstruc );
      out.write(__oracle_jsp_text[17]);
      out.print( strIdAsunto );
      out.write(__oracle_jsp_text[18]);
      out.print( strAvance );
      out.write(__oracle_jsp_text[19]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[20]);
      out.print(strIdUsuario);
      out.write(__oracle_jsp_text[21]);
      out.print(retURI);
      out.write(__oracle_jsp_text[22]);
      out.print(retURI2);
      out.write(__oracle_jsp_text[23]);
      out.print(strEstValidacion);
      out.write(__oracle_jsp_text[24]);
       if( (BUsuario.getAtencion()||BUsuario.getAsistente()) && !BUsuario.getTurnado() && !BUsuario.getSupervisor()){ 
                              String[][] strSubAlternos = null;
                       	if(Usuario.equalsTitular(BUsuario.getIdUsuario())&&Usuario.equalsTitular(turno))
                                  strSubAlternos = Items.listarSubordinadosTitular(BUsuario.getIdArea());
                              else{
                                  turno = gob.hacienda.cgtic.siga.util.Jefe.getAtencion(turno);
                                  strSubAlternos = ActualizaUsuario.getSubordinados(turno);//ActualizaUsuario.getSubalterno(BUsuario.getIdUsuario());
                              }
      			//Arboles tree = new Arboles(strSubAlternos);
      			AsignarArbol tree = new AsignarArbol(strSubAlternos);
      			Vector vIdsCadena = tree.getIds();
       		
      out.write(__oracle_jsp_text[25]);
       if(vIdsCadena != null && vIdsCadena.size()!=0){ 
      out.write(__oracle_jsp_text[26]);
      	for(int i=0; i<vIdsCadena.size(); i++){ 
      out.write(__oracle_jsp_text[27]);
      out.print( (String)vIdsCadena.get(i) );
      out.write(__oracle_jsp_text[28]);
      out.print( (strIdUsuario.equals((String)vIdsCadena.get(i)))?"selected=\"selected\"":"" );
      out.write(__oracle_jsp_text[29]);
      out.print( ActualizaUsuario.NombreUsuario((String)vIdsCadena.get(i)) );
      out.write(__oracle_jsp_text[30]);
      out.print( ActualizaUsuario.NombrePuesto((String)vIdsCadena.get(i)) );
      out.write(__oracle_jsp_text[31]);
      	} 
      out.write(__oracle_jsp_text[32]);
       }else{ 
      out.write(__oracle_jsp_text[33]);
       } 
      out.write(__oracle_jsp_text[34]);
      }else if(BUsuario.getSupervisor() || BUsuario.getTurnado()){
      out.write(__oracle_jsp_text[35]);
            String[][] strSubAlternos=null;
                              if(Usuario.esVentanilla(turno))
                                  strSubAlternos = Items.listarSubordinadosTitular(BUsuario.getIdArea());
                              else
                                  strSubAlternos= ActualizaUsuario.getSubordinados(turno);//ActualizaUsuario.getSubalterno(turno);
      			//Arboles tree = new Arboles(strSubAlternos);
      			AsignarArbol tree = new AsignarArbol(strSubAlternos);
      			Vector vIdsCadena = tree.getIds();
       		
      out.write(__oracle_jsp_text[36]);
       if(vIdsCadena != null && vIdsCadena.size()!=0){ 
      out.write(__oracle_jsp_text[37]);
      	for(int i=0; i<vIdsCadena.size(); i++){ 
      out.write(__oracle_jsp_text[38]);
      out.print( (String)vIdsCadena.get(i) );
      out.write(__oracle_jsp_text[39]);
      out.print( (strIdUsuario.equals((String)vIdsCadena.get(i)))?"selected=\"selected\"":"" );
      out.write(__oracle_jsp_text[40]);
      out.print( ActualizaUsuario.NombreUsuario((String)vIdsCadena.get(i)) );
      out.write(__oracle_jsp_text[41]);
      out.print( ActualizaUsuario.NombrePuesto((String)vIdsCadena.get(i)) );
      out.write(__oracle_jsp_text[42]);
      	} 
      out.write(__oracle_jsp_text[43]);
       }else{ 
      out.write(__oracle_jsp_text[44]);
       } 
      out.write(__oracle_jsp_text[45]);
      }
      out.write(__oracle_jsp_text[46]);
      String nombre = ActualizaUsuario.NombreUsuario(strIdUsuario)==null? "---" : ActualizaUsuario.NombreUsuario(strIdUsuario);
      out.write(__oracle_jsp_text[47]);
      out.print(nombre);
      out.write(__oracle_jsp_text[48]);
      if(strIdUsuario!= null && strIdUsuario.length()!=0){
      out.write(__oracle_jsp_text[49]);
      out.print(ActualizaUsuario.NombreUsuario(strIdUsuario));
      out.write(__oracle_jsp_text[50]);
      }
      out.write(__oracle_jsp_text[51]);
      out.print(strComentarios.trim());
      out.write(__oracle_jsp_text[52]);
      out.print( bValidaEstatus );
      out.write(__oracle_jsp_text[53]);
      out.print(retURI);
      out.write(__oracle_jsp_text[54]);

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
  private static final char __oracle_jsp_text[][]=new char[55][];
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
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<TITLE>Reasignar Rechazadas</TITLE>\n<SCRIPT src=\"../js/SigmaJsCat.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\t\n\tfunction regresar(){\n\t\t//location.assign('InstruccionesAtender.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[12] = 
    "');\n\t\tlocation.assign('".toCharArray();
    __oracle_jsp_text[13] = 
    "');\n\t}\n\t\n\tvar digitos=10 //cantidad de digitos buscados \n\tvar puntero=0 \n\tvar buffer=new Array(digitos) //declaración del array Buffer \n\tvar cadena=\"\" \n\n\tfunction buscar_opRAZ(obj){\n\t\tvar forma=document.reasignarRec;\n\t   \tvar letra = String.fromCharCode(event.keyCode)\n\t   \tif(puntero >= digitos){ \n\t    \tcadena=\"\"; \n\t       \tpuntero=0; \n\t    } \n\t   \tif (event.keyCode == 13){ \n\t    \tborrar_buffer(); \n\t\t\tvar cad=\"\";\n\t\t\tif(obj.options[obj.selectedIndex].value!=\"-1\")\n\t\t\t{\n\t\t\t\tvar a = forma.areaReasignar.value;\n\t\t\t\tlocation.assign('ReasignarRechazo.jsp?id_ins=".toCharArray();
    __oracle_jsp_text[14] = 
    "&id_asunto=".toCharArray();
    __oracle_jsp_text[15] = 
    "&ava=".toCharArray();
    __oracle_jsp_text[16] = 
    "&id_area='+a);\t\n\t\t\t}\n\t    } \n\t   \telse{ \n\t       \tbuffer[puntero]=letra; \n\t       \tcadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array \n\t       \tpuntero++; \n\t       \tfor (var opcombo=0;opcombo < obj.length;opcombo++){ \n\t          \tif(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ \n\t          \t\tobj.selectedIndex=opcombo; \n\t        \t} \n\t       \t} \n\t    }\n\t   \tevent.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter \n\t}\n\tfunction borrar_bufferRAZ(){ \n    \tcadena=\"\"; \n    \tpuntero=0; \n\t}\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"timer_load();valida=0;\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\"\n\tonMouseMove=\"limitaTextArea(document.reasignarRec.reasignarComen,'Comentarios','1000')\">\n<FORM name=\"reasignarRec\" action=\"ReasignarRechazo.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"id_ins\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"id_asunto\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"ava\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"id_area\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" name=\"id_usuario\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"retURI\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" name=\"retURI2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\" name=\"estValidacion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\">&nbsp;</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\">\n\t\t\t\t<INPUT class=\"blue100\" onclick=\"regresar();\" type=\"button\" value=\"Cancelar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<INPUT id=\"btnReasignar\" name=\"btnReasignar\" class=\"blue100\" onclick=\"ReasignarRechazo();\" type=\"button\" value=\"Aceptar\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"672\" bgcolor=\"#00204f\" colspan=\"4\"><FONT size=\"0\">&nbsp;</FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Puesto:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t<SELECT name=\"reasignarUsr\" class=\"blue500a\" \n\t\t\t\t\tonchange='puestoRR()' onKeypress='buscar_op1(this)' \n\t\t\t\t\tonblur='borrar_buffer()' onclick='borrar_buffer()'>\n\t\t\t\t\t<OPTION value=\"-1\">------------------------------ Selecciona un Puesto ------------------------------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "\" \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    ">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[30] = 
    "/".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t\t\t</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t<SELECT class=\"blue100a\" name=\"reasignarUsr\">\n\t\t\t\t\t<OPTION value=\"-1\">---</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t</TD>\n\t\t\n\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Puesto:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t<SELECT name=\"reasignarUsr\" class=\"blue500a\" \n\t\t\t\t\tonchange='puestoRR()' onKeypress='buscar_op1(this)' \n\t\t\t\t\tonblur='borrar_buffer()' onclick='borrar_buffer()'>\n\t\t\t\t\t<OPTION value=\"-1\">------------------------------ Selecciona un Puesto ------------------------------</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\" \n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    ">\n\t\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[41] = 
    "/".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t\t\t\t</OPTION>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t\t\t<SELECT class=\"blue100a\" name=\"reasignarUsr\">\n\t\t\t\t\t<OPTION value=\"-1\">---</OPTION>\n\t\t\t\t</SELECT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t</TD>\n\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Responsable:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n                        ".toCharArray();
    __oracle_jsp_text[47] = 
    "\n                        <FONT face=\"Arial\" color=\"#004080\" size=\"2\">".toCharArray();
    __oracle_jsp_text[48] = 
    "</FONT>\n                        <!--\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t<FONT face=\"Arial\" color=\"#004080\" size=\"2\">".toCharArray();
    __oracle_jsp_text[50] = 
    "</FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t-->\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Arial\" color=\"#004080\" size=\"2\">Comentarios:</FONT></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<TEXTAREA cols=\"50\" rows=\"5\" class=\"blue500\" name=\"reasignarComen\"\n\t\t\t\tonKeyDown=\"limitaTextArea(document.reasignarRec.reasignarComen,'Comentarios','1000')\">".toCharArray();
    __oracle_jsp_text[52] = 
    "</TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<script type=\"text/javascript\">\n<!--\nif (".toCharArray();
    __oracle_jsp_text[53] = 
    "){\n\talert(\"Esta instrucción ha sido modificada por otro usuario y Cambió su Estatus,\\npor lo que la acción solicitada será cancelada\");\n\tlocation.assign(\"".toCharArray();
    __oracle_jsp_text[54] = 
    "\");\n}\n//-->\n</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
