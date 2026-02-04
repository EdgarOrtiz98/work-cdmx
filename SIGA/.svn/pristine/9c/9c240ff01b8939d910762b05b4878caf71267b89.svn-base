<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Folios</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*"%>
<%@ page import="com.meve.sigma.taglib.*,com.meve.sigma.beans.*"%>    
<%
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
%>
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERUsuarioInvalido.jsp"></jsp:forward>
<% } %>
<%
		
		String recCreador[][] 	=	null;
		String recFolio[][] 	= 	null;
		String strIdFolio 		=	"";
		String strIdArea 		= 	"";
		String strTipoFolio 	= 	"";
		String strClave 		= 	"";
		String strConsecutivo 	= 	"";
		String strOrden 		= 	"";
		String strCreador 		= 	"";
		String strCreador1 		= 	"";
		String strFechaCreacion	=	"";
		String strFechaCreacion2=	"";
		String strAccion 		= 	"";
		String strEstatus 		= 	"1";
		String strConfFolio 	= 	application.getInitParameter("genFolio");

		String retURI = (request.getParameter("retURI")== null)?"FoliosView.jsp":request.getParameter("retURI");
		String strAux = "1a2b3c", strAux2 = "1a2b3c";
		int valida = -2;
		boolean bInsertar = false;
		boolean bActualizar = false;
		boolean bvalida = true;
		boolean bvalidaClave = true;

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"dd/MM/yyyy");
		java.util.Date f = new java.util.Date();
		strFechaCreacion = sdf.format(f);
		strFechaCreacion2=	strFechaCreacion;

		strCreador1	=	BUsuario.getIdUsuario();
		strCreador	=	ActualizaUsuario.NombreUsuario(strCreador1);
		
		strAccion 	= 	request.getParameter("accion");
		
		if (strAccion != null && strAccion.equals("consultar")) {
			strIdFolio = request.getParameter("folio_idFolio");
			if (strIdFolio != null) {
				recFolio 		= ActualizaFolio.getFolio(strIdFolio);
				strIdArea 		= recFolio[0][0];
				strTipoFolio 	= recFolio[0][1];
				strClave 		= recFolio[0][2];
				strConsecutivo 	= recFolio[0][3];
				strOrden 		= recFolio[0][4];
				strCreador1		= recFolio[0][5];
				strCreador		= ActualizaUsuario.NombreUsuario(recFolio[0][5]);
				strFechaCreacion2 = recFolio[0][6];

				strAux = strClave;
				strAux2 = strIdArea;
			}
		}
		if (strAccion != null && strAccion.equals("cambiar")) {
			strIdFolio = request.getParameter("folio_idFolio");
			////System.out.println("strIdFolio=" + strIdFolio);
			if (strIdFolio != null) {
				strIdArea 		= request.getParameter("folio_area");
				strTipoFolio 	= request.getParameter("folio_tipo");
				strClave 		= request.getParameter("folio_clave");
				strOrden 		= request.getParameter("folio_orden");
				strAux 			= request.getParameter("aux");
				strAux2			= request.getParameter("aux2");
				if(strConfFolio.equals("1"))
					strConsecutivo = "0";
				else
					strConsecutivo 	= request.getParameter("folio_consecutivo");

				// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Folio
				strClave	=	(strClave.length()<= 200) ? strClave : strClave.substring(0,200);

				if (strTipoFolio.equals("1"))
					bvalida = ActualizaFolio.getFolioExiste(strIdArea, strIdFolio);	
				else
					bvalida = true;

				bvalidaClave = ActualizaFolio.getClaveFolioExiste(strClave, strIdFolio);				

				if (bvalida && bvalidaClave){
					String datos[][] = ActualizaFolio.getFolio(strIdFolio);
					bInsertar 		= ActualizaFolio.ActualizarFolio(strIdFolio,
							strIdArea, strTipoFolio, strClave, strConsecutivo,
							strOrden, strCreador1, strFechaCreacion);
					boolean b = ActualizaBitacora.InsertarEventoCambioFolio(BUsuario.getIdUsuario(),strClave,strIdArea,strIdFolio,datos);
				}
			}
		}

		if (strAccion != null && strAccion.equals("guardar")) {
			strIdArea 		= request.getParameter("folio_area");
			strTipoFolio 	= request.getParameter("folio_tipo");
			strClave 		= request.getParameter("folio_clave");
			strOrden 		= request.getParameter("folio_orden");
			if(strConfFolio.equals("1"))
				strConsecutivo = "0";
			else
				strConsecutivo 	= request.getParameter("folio_consecutivo");

			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Folio
			strClave	=	(strClave.length()<= 200) ? strClave : strClave.substring(0,200);

			if (strTipoFolio.equals("1"))
				bvalida = ActualizaFolio.getFolioExiste(strIdArea, "-1");	
			else
				bvalida = true;

			bvalidaClave = ActualizaFolio.getClaveFolioExiste(strClave, "-1");				

			if (bvalida && bvalidaClave){
				bInsertar 		= ActualizaFolio.InsertarFolio(strIdArea, strTipoFolio,
								strClave, strConsecutivo, strOrden, strCreador1,
								strFechaCreacion, strEstatus);
				boolean b = ActualizaBitacora.InsertarEventoAltaFolio(BUsuario.getIdUsuario(),strClave,strIdArea);
//				strIdArea 		= "";
//				strTipoFolio 	= "";
//				strClave 		= "";
//				strConsecutivo 	= "";
			}
		}
		//recCreador  = ActualizaUsuario.getUsuario(strCreador1);
		//strCreador	= recCreador[0][0];
		if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")) && bInsertar)
		{
			strAccion 			= "";
%>
<SCRIPT language=JavaScript type=text/javascript>
	location.assign("<%= retURI %>");
</SCRIPT>
<%
		}
%>
<% if(strIdFolio!=null && strIdFolio.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<STYLE type="text/css">
</STYLE>
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language="JavaScript" type="text/javascript"
	src="../js/domapi/core_c.js"></script>
<SCRIPT language="JavaScript" type="text/javascript"
	src="../js/domapi/examples_c.js"></script>

<SCRIPT language=JavaScript type=text/javascript>

	function limpiarCampos(){
		document.Folio.reset();
	}
</SCRIPT>

<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="valida=0;";
	onKeyPress="timer_load();timer_reload()" 
	onClick="timer_load();timer_reload()">
<FORM action="Folios.jsp" name="Folio" method="post">
<INPUT type="hidden" name="accion" value="<%= strAccion %>"> 
<INPUT type="hidden" name="folio_orden" value="<%=strOrden%>"> 
<INPUT type="hidden" name="folio_idFolio" value="<%=strIdFolio%>">
<INPUT type="hidden" name="aux" value="<%=strAux%>">
<INPUT type="hidden" name="aux2" value="<%=strAux2%>">
<INPUT type="hidden" name="retURI" value="<%=retURI%>">
<DIV class="documentBody" id="Body" style="HEIGHT: 459px">
<CENTER>
<BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD colspan="3"><A href="<%= retURI %>"> <IMG
				border="0" src="../Imagenes/NavLeft.gif" title="Regresar"
				title="Regresar"> </A>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a onclick="guardarFolio()">
				<img src="../Imagenes/Save.gif" title="Guardar">
				</a>
			</TD>
		</TR>

		<TR valign="top">
			<TD width="159"><B><FONT face="Verdana" color="#00204f" size="2"><FONT
				color="#00204f" size="37777777777"><FONT color="#00204f"
				size="37777777777"><FONT size="+1" color="#004080">Folios</FONT></FONT></FONT></FONT></B></TD>
			<TD align="right" colspan="2">&nbsp;<FONT color="black">**Los datos
			marcados con negritas son obligatorios</FONT></TD>
		</TR>
		<TR valign="top">
			<td bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>
		<TR valign="top">
			<TD width="159"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<TD align="right" colspan="2"><FONT face="Verdana" size="2">
				<%=(strIdFolio!=null && !strIdFolio.equals(""))?"Última modificación por: ":"Creado por: "%><I><%= strCreador %> - <%= strFechaCreacion2 %></I></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="159"><BR>
			<BR>
			</TD>
			<TD width="479">&nbsp;</TD>
			<TD width="11">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="159"><FONT face="Verdana" size="2" color="#004080"><B>Unidad
			Administrativa:</B></FONT></TD>
			<% if(BUsuario.getSupervisor()){ 
				if(strIdFolio.equals("")){
					strIdArea = BUsuario.getIdArea();
				} 
			%>
			<TD colspan="2"><FONT size="2" face="Verdana"> <meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="folio_area"
				classHtml="blue600a" selected="<%= strIdArea %>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/></FONT></TD>
			<% }else{ %>
			<TD colspan="2"><FONT size="2" face="Verdana"> <meve_combo:comboseleccion
				data="<%= ComboData.getAreasComboAll() %>" size="1" name="folio_area"
				classHtml="blue600a" selected="<%= strIdArea %>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/></FONT></TD>
			<% } %>
		</TR>
		<%if (!bvalida) {%>
		<TR>
			<TD colspan="2">
				<FONT color="red"><B>*Ya existe un Folio de Recepción en esta Unidad Administrativa* </B></FONT>
			</TD>
		</TR>
		<%} %>
		<TR valign="top">
			<TD width="159">&nbsp;</TD>
			<TD width="479">&nbsp;</TD>
			<TD width="11">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="159"><FONT face="Verdana" size="2" color="#004080">Tipo de Folio:</FONT></TD>
			<TD width="479"><FONT face="Verdana" size="2"> <INPUT type="radio"
				value="1" name="folio_tipo"
				<%=strTipoFolio.trim().equals("1")? "CHECKED":""%> checked>Recepción <INPUT
				type="radio" value="0" name="folio_tipo"
				<%=strTipoFolio.trim().equals("0")? "CHECKED":""%>>Turnado</FONT></TD>
			<TD width="11"></TD>
		</TR>
		<TR valign="top">
			<TD width="159">&nbsp;</TD>
			<TD width="479">&nbsp;</TD>
			<TD width="11">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="159"><FONT face="Verdana" size="2" color="#004080"><B>Clave:</B></FONT></TD>
			<TD width="479"><FONT face="Verdana" size="2"><INPUT
				name="folio_clave"  class="blue200a" value="<%=strClave%>" maxlength="199"></FONT></TD>
			<TD width="11">&nbsp;</TD>
		</TR>
		<%if (!bvalidaClave) {%>
		<TR>
			<TD colspan="2">
				<FONT color="red"><B>*Ya existe esta Clave* </B></FONT>
			</TD>
		</TR>
		<%} %>
		<TR valign="top">
			<TD width="159">&nbsp;</TD>
			<TD width="479">&nbsp;</TD>
			<TD width="11">&nbsp;</TD>
		</TR>
		<% if(!strConfFolio.equals("1")){ %>
		<TR valign="top">
			<TD width="159"><FONT face="Verdana" size="2" color="#004080">Consecutivo:</FONT></TD>
			<TD width="479"><FONT face="Verdana" size="2"><INPUT size="5"
				name="folio_consecutivo" class="blue100" value="<%=strConsecutivo%>" onKeyPress='AceptaSoloTeclaNumericaYPunto();' maxlength="5"></FONT></TD>
			<TD width="11">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="159">&nbsp;</TD>
			<TD width="479">&nbsp;</TD>
			<TD width="11">&nbsp;</TD>
		</TR>
		<% } %>
		<TR valign="top">
			<TD width="159"><FONT face="Verdana" size="2"></FONT></TD>
			<TD width="479"><FONT face="Verdana" size="2" color="#004080"><B>Orden</B></FONT></TD>
			<TD width="11">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="159">&nbsp;</TD>
			<TD width="479">&nbsp;&nbsp;<FONT size="-2">Arrastre las opciones de
			la lista según el orden de importancia</FONT></TD>
			<TD width="11">&nbsp;</TD>
		</TR>

		<TR valign="top">
			<TD colspan="3">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</CENTER>
</DIV>
</FORM>
<SCRIPT language="JavaScript" type="text/javascript">
<!-- 
	var doc = document.forms[0];
	core.loadUnit("listbox");
    core.loadUnit("drag");
	var Lista = doc.folio_orden.value; 
    var valores1='';
    var valores2='';
	for(i=0;i<Lista.length;i++){
		//alert("[" +i+ "]="+Lista.charAt(i)+"\nvalores1=" + valores1);
		if(Lista.charAt(i)=='D')
			valores2 = valores2 + "Clave de Tipo de Documento,";
		else if(Lista.charAt(i)=='A')
			valores2 = valores2 + "Clave,";
		else if(Lista.charAt(i)=='C')
			valores2 = valores2 + "Consecutivo,";
	}
	if(Lista.indexOf('D')<0)
		valores1 = valores1 + "Clave de Tipo de Documento,";
	if(Lista.indexOf('A')<0)
		valores1 = valores1 + "Clave,";
	if(Lista.indexOf('C')<0)
		valores1 = valores1 + "Consecutivo,";
	//alert('valores1=' + valores1 + '\nvalores2=' + valores2);
	if(valores1 != '' )	valores1= valores1.substring(0, valores1.length-1);		
	if(valores2 != '' ) valores2= valores2.substring(0, valores2.length-1);		

    onload=function(){
      elm1=Listbox({x:430,y:450,w:170,h:70});
      elm2=Listbox({x:630,y:450,w:170,h:70});	
      if(valores1 != '' ) elm1.delimitedText(valores1);
      if(valores2 != '' ) elm2.delimitedText(valores2);
		
      for(var a=0;a<elm1.items.length;a++){
        core.Elm(elm1.items[a].id);
        elm1.items[a].turnOnDrag(null,core.drag.dtDragDrop);
      }
      for(var a=0;a<elm2.items.length;a++){
        core.Elm(elm2.items[a].id);
        elm2.items[a].turnOnDrag(null,core.drag.dtDragDrop);
      }
      elm1.ondragdrop=function(){return true};
      elm2.ondragdrop=function(){return true};
    }

function GetList()
{
	var doc = document.forms[0];
	var Lista='';
	for(var a=0;a<elm2.items.length;a++){
		if(elm2.items[a].outerText == 'Clave de Tipo de Documento')
			Lista=Lista + 'D';
		if(elm2.items[a].outerText == 'Clave')
			Lista=Lista + 'A';
		if(elm2.items[a].outerText == 'Consecutivo')
			Lista=Lista + 'C';
    }
	doc.folio_orden.value=Lista;
}

function guardarFolio() { 

	var doc = document.Folio
	//var valida = 0;
	var msg="";
	GetList();
	Lista=doc.folio_orden.value;

//	if (valida != 1)	{
		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \', `, ´)\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.folio_clave.value)){
			if (confirm(mensaje)){

				doc.folio_clave.value	= quitaCE(doc.folio_clave.value);
				doc.aux.value	= quitaCE(doc.aux.value);
				
				if(doc.folio_idFolio.value != "")
					doc.accion.value="cambiar";
				if(doc.folio_idFolio.value == "")
					doc.accion.value="guardar";
//				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			if(doc.folio_idFolio.value != "")
				doc.accion.value="cambiar";
			if(doc.folio_idFolio.value == "")
				doc.accion.value="guardar";
//			doc.submit();
		}
//	}
	if (doc.folio_area[doc.folio_area.selectedIndex].value == -1) {
		valida =1;
		msg = msg + "Debe seleccionar una Unidad	"+ "\n";
	}
	if(Trim(doc.folio_clave.value) == ""){
		valida =1;
		msg = msg + "Debe capturar la clave del Folio	"+ "\n";
	}
	<%if(!strConfFolio.equals("1")){%>
	if(doc.folio_consecutivo.value == ""){
		valida =1;
		msg = msg + "Debe capturar el numero Consecutivo	"+ "\n";
	}
	<%}%>
	if(Lista.indexOf('A')<0){		
		valida =1;
		msg = msg + "El Orden debe incluir a la Clave"+ "\n";
	}
	if(Lista.indexOf('D')<0){		
		valida =1;
		msg = msg + "El Orden debe incluir a la Clave de Tipo de Documento"+ "\n";
	}
	if(Lista.indexOf('C')<0){
		valida =1;
		msg = msg + "El Orden debe incluir al Consecutivo"+ "\n";
	}
	if (Trim(quitaPuntos(doc.folio_clave.value)) =="" && doc.folio_clave.value!="") {
		valida =1;
		msg = msg + "La Clave no es válida"+ "\n";
	}

	if (valida == 1) 
	{
		alert(msg);
		valida=0;
		return false;
	}else if(valida == 2){
		alert("Su solicitud ya fue enviada");
		return false;
	}else{
		valida=2;
		doc.submit();
	}
}
</SCRIPT>
</BODY>
</HTML>
