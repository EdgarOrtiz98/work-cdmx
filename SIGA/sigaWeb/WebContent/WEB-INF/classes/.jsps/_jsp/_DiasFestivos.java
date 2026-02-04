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


public class _DiasFestivos extends com.orionserver.http.OrionHttpJspPage {


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
    _DiasFestivos page = this;
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
      
      		String recCreador[][] 	= null;
      		String recDiaFestivo[][]= null;
      		String strIdDiaFestivo 	= "";
      		String strFecha			= "";
      		String strDescripcion	= "";
      		String strCreador 		= "";
      		String strCreador1 		= "";
      		String strFechaCreacion = "";
      		String strFechaCreacion2= "";
      		String strAccion 		= "";
      		String strEstatus 		= "1";
      
      		String strFecha2 = "01/01/0001";
      		String retURI = (request.getParameter("retURI")== null)?"DiasFestivosView.jsp":request.getParameter("retURI");
      
      		boolean bInsertar = false;
      		boolean bActualizar = false;
      		boolean bFormato = true;
      
      		int valida = -2;
      		Vector finesSemana = com.meve.sigma.util.Utilerias.getFinesSemana(1,1);
      
      		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
      		//java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-mm-dd");
      		java.util.Date f = new java.util.Date();
      		strFechaCreacion 	= sdf.format(f);
      		strFechaCreacion2 	= strFechaCreacion;
      		
      		strCreador1 = 	BUsuario.getIdUsuario();
      		strCreador	=	ActualizaUsuario.NombreUsuario(strCreador1);
      		
      		strAccion 	= 	request.getParameter("accion");
      		
      		if (strAccion != null && strAccion.equals("consultar")) {
      			strIdDiaFestivo = request.getParameter("DiaFestivo_IdDiaFestivo");
      			if (strIdDiaFestivo != null) {
      				recDiaFestivo 	= ActualizaDiaFestivo.getDiaFestivo(strIdDiaFestivo);
      				strFecha 		= recDiaFestivo[0][1];
      				strDescripcion 	= recDiaFestivo[0][2];
      				strCreador		= ActualizaUsuario.NombreUsuario(recDiaFestivo[0][3]);
      				strFechaCreacion2 = recDiaFestivo[0][4];
      				strFecha2 		= strFecha;
      			}
      		}
      		if (strAccion != null && strAccion.equals("cambiar")) {
      			strIdDiaFestivo = request.getParameter("DiaFestivo_IdDiaFestivo");
      			if (strIdDiaFestivo != null) {
      				strFecha 		= request.getParameter("DiaFestivo_Fecha");
      				strDescripcion 	= request.getParameter("DiaFestivo_Descripcion");
      				strFecha2 		= request.getParameter("Fecha2");
      
      				valida = ActualizaDiaFestivo.getDiaFestivoExiste(strFecha, strFecha2);
      				//out.print("----------- "+valida+" -------------");
      				if (valida == 2){
      					String datos[][] = ActualizaDiaFestivo.getDiaFestivo(strIdDiaFestivo);
      					bInsertar 		= ActualizaDiaFestivo.ActualizarDiaFestivo(strIdDiaFestivo,
      							strFecha, strDescripcion, strCreador1, strFechaCreacion);
      					boolean c = ActualizaBitacora.InsertarEventoCambioDia(BUsuario.getIdUsuario(),strFecha,strIdDiaFestivo,datos);
      					//out.print("----------- "+c+" -------------");
      					bFormato = bInsertar;
      				}
      			}
      		}
      
      		if (strAccion != null && strAccion.equals("guardar")) {
      			strFecha 		= request.getParameter("DiaFestivo_Fecha");
      			strDescripcion 	= request.getParameter("DiaFestivo_Descripcion");
      
      			valida = ActualizaDiaFestivo.getDiaFestivoExiste(strFecha, strFecha2);
      
      			if (valida == 2){
      				bInsertar 		= ActualizaDiaFestivo.InsertarDiaFestivo(strFecha, strDescripcion,
      									strCreador1, strFechaCreacion, strEstatus);
      				boolean c = ActualizaBitacora.InsertarEventoAltaDia(BUsuario.getIdUsuario(),strFecha);
      
      				bFormato = bInsertar;
      
      	//			strFecha		= "";
      	//			strDescripcion 	= "";
      			}
      		}
      		//recCreador  = ActualizaUsuario.getUsuario(strCreador1);
      		//strCreador	= recCreador[0][0];
      		if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")) && bInsertar)
      		{
      			strAccion 			= "";
      
      out.write(__oracle_jsp_text[9]);
      out.print( retURI );
      out.write(__oracle_jsp_text[10]);
      
      		}
      
      out.write(__oracle_jsp_text[11]);
       if(!BUsuario.getAdmon()){ 
      out.write(__oracle_jsp_text[12]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[13]);
       } 
      out.write(__oracle_jsp_text[14]);
      	for (int ik=0; ik<finesSemana.size(); ik++){ 
      out.write(__oracle_jsp_text[15]);
      out.print( (String)finesSemana.get(ik) );
      out.write(__oracle_jsp_text[16]);
      	} 
      out.write(__oracle_jsp_text[17]);
      out.print(strIdDiaFestivo);
      out.write(__oracle_jsp_text[18]);
      out.print(strFecha2);
      out.write(__oracle_jsp_text[19]);
      out.print(retURI);
      out.write(__oracle_jsp_text[20]);
      out.print( retURI );
      out.write(__oracle_jsp_text[21]);
      out.print((strIdDiaFestivo!=null && !strIdDiaFestivo.equals(""))?"última Modificación por: ":"Creado por: ");
      out.write(__oracle_jsp_text[22]);
      out.print( strCreador );
      out.write(__oracle_jsp_text[23]);
      out.print( strFechaCreacion2 );
      out.write(__oracle_jsp_text[24]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[25]);
      } 
      out.write(__oracle_jsp_text[26]);
       if (strAccion != null && (strAccion.equals("cambiar") || strAccion.equals("consultar"))){
      out.write(__oracle_jsp_text[27]);
      out.print(strFecha);
      out.write(__oracle_jsp_text[28]);
      } else { 
      out.write(__oracle_jsp_text[29]);
      out.print(strFecha);
      out.write(__oracle_jsp_text[30]);
      if (!bFormato || valida == -1) {
      out.write(__oracle_jsp_text[31]);
      } 
      out.write(__oracle_jsp_text[32]);
       } 
      out.write(__oracle_jsp_text[33]);
      out.print(strDescripcion);
      out.write(__oracle_jsp_text[34]);
      out.print( strAccion);
      out.write(__oracle_jsp_text[35]);

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
  private static final char __oracle_jsp_text[][]=new char[36][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Días Festivos</TITLE>\n".toCharArray();
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
    "\n<SCRIPT language=JavaScript type=text/javascript>\n\tlocation.assign(\"".toCharArray();
    __oracle_jsp_text[10] = 
    "\");\n</SCRIPT>\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<LINK rel=\"stylesheet\" type=\"text/css\" href=\"../theme/Master.css\">\n<LINK rel=\"stylesheet\" type=\"text/css\" href=\"../css/menu.css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\tfunction limpiarCampos(){\n\t\tdocument.DiaFestivo.reset();\n\t}\n\n</SCRIPT>\n<script type=\"text/javascript\">\n<!--\n\tfunction validaFechaFinesSem(campoFecha){\n\n\t\tvar valida = 0 \n\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\t\n\t\tif (campoFecha != null && campoFecha.value == \"".toCharArray();
    __oracle_jsp_text[16] = 
    "\") {\n\t\t\tvalida =1;\n\t\t}\n\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n\t\tif (valida == 1){\n\t\t\talert(\"La fecha seleccionada no es laborable\");\n\t\t\tcampoFecha.value = \"\";\n\t\t} \n\t}\n//-->\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load();limpiarCampos();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\"\n\tonMouseMove=\"validaFecha();limitaTextArea(document.DiaFestivo.DiaFestivo_Descripcion,'Comentario','200');\n\t\tvalidaFechaFinesSem(document.DiaFestivo.DiaFestivo_Fecha);\">\n\n<FORM action=\"DiasFestivos.jsp\" name=\"DiaFestivo\" method=\"post\">\n<INPUT type=\"hidden\" name=\"accion\" value=\"guardar\">\n<INPUT type=\"hidden\" name=\"DiaFestivo_IdDiaFestivo\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\">\n<INPUT type=\"hidden\" name=\"Fecha2\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\">\n<INPUT type=\"hidden\" name=\"retURI\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\">\n<CENTER>\n<BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\"><A href=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"\n\t\t\t\talt=\"Regresar\"> </A>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<a onclick=\"guardar()\">\n\t\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t\t</a>\n\t\t\t</TD>\n\t\t</TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"336\" colspan=\"2\">\n\t\t\t<FONT color=\"#00204f\" size=\"37777777777\"><B><FONT size=\"+1\" color=\"#004080\">Días Festivos</FONT></B></FONT><FONT></FONT>\n\t\t</TD>\n\t\t<TD width=\"53\">&nbsp;</TD>\n\t\t<TD align=\"right\" width=\"355\">&nbsp;<FONT color=\"black\">**Los datos\n\t\t\tmarcados con negritas son obligatorios</FONT></TD>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<td bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n    </TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD colspan=\"3\">\n\t\t\t<DIV align=\"right\">\n\t\t\t\t<FONT face=\"Verdana\" color=\"#002100\" size=\"2\"><I></I></FONT><FONT\n\t\t\t\tface=\"Verdana\" size=\"2\">\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[22] = 
    "<I>".toCharArray();
    __oracle_jsp_text[23] = 
    " - ".toCharArray();
    __oracle_jsp_text[24] = 
    "</I></FONT>\n\t\t\t</DIV>\n    \t</TD>\n    </TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><BR>\n\t\t\t<BR></TD>\n\t\t\t<TD width=\"192\"></TD>\n\t\t\t<TD width=\"53\"></TD>\n\t\t\t<TD width=\"355\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t<TD width=\"144\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Día Festivo:</B></FONT><FONT\n\t\t\t\tcolor=\"#004080\"></FONT>\n\t\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "<br>\n\t\t\t<FONT color=\"red\"><B>*Este Día festivo ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t</TD>\n\t\t<TD colspan=\"3\">\n\t\t".toCharArray();
    __oracle_jsp_text[27] = 
    "\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t<INPUT type=\"text\" size=\"5\" name=\"DiaFestivo_Fecha\" maxlength=\"10\" class=\"blue100a\" value=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "\" readonly>\n\t\t\t</FONT>\n\t\t".toCharArray();
    __oracle_jsp_text[29] = 
    "\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t<INPUT type=\"text\" size=\"5\" name=\"DiaFestivo_Fecha\" maxlength=\"10\" class=\"blue100a\" value=\"".toCharArray();
    __oracle_jsp_text[30] = 
    "\"\n\t\t\t\t\tonblur=\"validaFormatFecha();\" onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\"\n\t\t\t\t\tonKeyUp = \"validaFecha();\">\n\t\t\t</FONT>\n\t\t\t<A><IMG height=\"20\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='show_calendar(\"forms[0].DiaFestivo_Fecha\");'></A><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "<br>\n\t\t\t<FONT color=\"red\"><B>*El formato de la fecha no es correcto* </B></FONT>".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n        </TD>      \n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\">&nbsp;</TD>\n<TD width=\"192\">&nbsp;</TD>\n<TD width=\"53\">&nbsp;</TD>\n<TD width=\"355\">&nbsp;</TD>\n        </TR>\n<TR valign=\"top\">\n<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Descripción: </B></FONT></TD>\n<TD colspan=\"3\">\n\t<TEXTAREA name=\"DiaFestivo_Descripcion\" rows=\"3\" cols=\"65\" \n\t\tonmousemove=\"limitaTextArea(document.DiaFestivo.DiaFestivo_Descripcion,'Descripción','200')\"\n\t\tclass=\"blue600a\">".toCharArray();
    __oracle_jsp_text[34] = 
    "</TEXTAREA> \n</TD>\n        </TR>\n<TR valign=\"top\">\n<TD colspan=\"4\">&nbsp;</TD>\n        </TR>\n    </TBODY>\n</TABLE>\n</CENTER>\n</FORM>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\n<!-- \nfunction guardar() {\n\tvar doc = document.forms[0]\n\t//var valida = 0;\n\tvar msg=\"\";\n\n//\tif (valida != 1){\n\n\t\tmensaje = 'Algunos de los campos tienen caracteres invalidos (`,  ´, &, \", <, >, \\')\\nPresione Aceptar para eliminarlos automaticamente\\no Cancelar para regresar'\n\t\tif(detectaCE(doc.DiaFestivo_Fecha.value) || detectaCE(doc.DiaFestivo_Descripcion.value)){\n\t\t\tif (confirm(mensaje)){\n\n\t\t\t\tdoc.DiaFestivo_Fecha.value\t= quitaCE(doc.DiaFestivo_Fecha.value);\n\t\t\t\tdoc.DiaFestivo_Descripcion.value\t= quitaCE(doc.DiaFestivo_Descripcion.value);\n\t\t\t\tdoc.Fecha2.value\t= quitaCE(doc.Fecha2.value);\n\t\t\t\t\n\t\t\t\tif(doc.DiaFestivo_IdDiaFestivo.value != \"\")\n\t\t\t\t\tdoc.accion.value=\"cambiar\";\n\t\t\t\tif(doc.DiaFestivo_IdDiaFestivo.value == \"\")\n\t\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\t\tdoc.submit();\n\t\t\t}\n\t\t\telse \n\t\tdoc.accion.value=\"\";\n\t\t}\n\t\telse{\n\t\t\tif(doc.DiaFestivo_IdDiaFestivo.value != \"\"){\n\t\t\t\tdoc.accion.value=\"cambiar\";\n\t\t\t}\n\t\t\tif(doc.DiaFestivo_IdDiaFestivo.value == \"\")\n\t\t\t\tdoc.accion.value=\"guardar\";\n//\t\t\tdoc.submit();\n\n\t\t}\n//\t}\n//\tdoc.submit();\n//\talert(doc.DiaFestivo_Descripcion.value);\n\tif (Trim(doc.DiaFestivo_Fecha.value) ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debe capturar la Fecha\"+ \"\\n\";\n\t}\n\tif (Trim(doc.DiaFestivo_Descripcion.value) ==\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" Debe capturar la Descripción del Día Festivo\"+ \"\\n\";\n\t}\n\tif (Trim(quitaPuntos(doc.DiaFestivo_Descripcion.value)) ==\"\" && doc.DiaFestivo_Descripcion.value!=\"\") {\n\t\tvalida =1;\n\t\tmsg = msg + \" La Descripción no es válida\"+ \"\\n\";\n\t}\n\tif (valida == 1) \n\t{\n\t\talert(msg);\n\t\tvalida=0;\n\t\treturn false;\n\t}else if(valida == 2){\n\t\talert(\"Su solicitud ya fue enviada\");\n\t\treturn false;\n\t}else{\n\t\tvalida=2;\n\t\tdoc.submit();\n\t}\n}\n\nfunction validaFormatFecha(){\n\n\tfecha = document.DiaFestivo.DiaFestivo_Fecha.value;\t\n\tmes\t =\tfecha.substring(3, 5); \n\tdia\t =\tfecha.substring(0, 2); \n   \tanio =\tfecha.substring(6,10);     \n\n\tbandera=false;\n\tif (Trim(fecha) != \"\"){\n\t\tif(fecha.length != 10){\n\t\t\tbandera=true;\n\t\t}\n\t\tif(fecha.charAt(2) != '/' || fecha.charAt(5) != '/'){\n\t\t\tbandera=true;\n\t\t}\n\t\tif(mes>12 || mes<1){\n\t\t\tbandera=true;\n\t\t}\n\t\telse{\n\t\t\tif(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){\n\t\t\t\tif (dia<1 || dia>31)\n\t\t\t\t\tbandera=true;\n\t\t\t}\n\t\t\telse{\n\t\t\t\tif (dia<1 || dia>30)\n\t\t\t\t\tbandera=true;\n\t\t\t}\n\t\t\tif(mes==2 && anio%4==0){\n\t\t\t\tif (dia<1 || dia>29)\n\t\t\t\t\tbandera=true;\n\t\t\t}\n\t\t\tif(mes==2 && anio%4!=0){\n\t\t\t\tif (dia<1 || dia>28)\n\t\t\t\t\tbandera=true;\n\t\t\t}\n\t\t}\t\t\n\t\tif(bandera){\n\t\talert(\"El formato de la Fecha es invalido\");\n\t\tdocument.DiaFestivo.DiaFestivo_Fecha.value = \"\";\n\t\t}\n\t}\n}\n\nfunction validaFecha(){\n\n\taccion = \"".toCharArray();
    __oracle_jsp_text[35] = 
    "\";\n\t//alert(accion);\n\tfecha = document.DiaFestivo.DiaFestivo_Fecha.value;\t\n\n\tif (fecha.length >= 10 && accion != \"cambiar\" && accion != \"consultar\"){\t\n\n\t\ttoday = new Date();\n\t\tday   = \"\" + today.getDate();\n\t\tmonth = \"\" + (today.getMonth() + 1);\n\t\tyear  = \"\" + today.getYear();\n\n\t\tif (day.length == 1)\n\t\t\tday = \"0\" + day;\n\t\tif (month.length == 1)\n\t\t\tmonth = \"0\" + month;\n\n\t\tfechaActual = day + \"/\" + month + \"/\" + year;\n\t\t//alert(comparaFechas(fecha,fechaActual));\n\n\t\tif (comparaFechas(fecha,fechaActual)==-1){\n\t\t\talert(\"La Fecha debe ser mayor o igual a la actual: \" + fechaActual);\n\t\t\tdocument.DiaFestivo.DiaFestivo_Fecha.value = \"\";\n\t\t}\n\t}\n}\n</SCRIPT>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
