<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Ruta Automatica</TITLE>
<%@ page language="java"contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*, com.meve.sigma.taglib.*,com.meve.sigma.beans.*"%>
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
	String strIdArea		=	"";
	String strIdTipoDocto	=	"";
	String strIdTipoAsunto	=	"";
	String strDescripcion	=	"";
	String strCreador		=	"";
	String strCreador1		=	"";		
	String strFechaCreacion	=	"";
	String strFechaCreacion2=	"";
	String strAccion		=	"";
	String strEstatus		=	"1";
	String strIdFlujo			=	"";
	String strFlujos[][]		=	null;

	String strAux = "1a2b3c", strAux2 = "1a2b3c";
	int valida = -2;
	boolean bInsertar		=	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	strFechaCreacion2 				=	strFechaCreacion;

	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
	strIdFlujo		=	request.getParameter("id_flujo");
	strAccion		=	request.getParameter("accion");
	strIdArea		=	request.getParameter("id_area");

	String url = request.getRequestURI();
	String server = application.getInitParameter("servername");
	String URL = server+url+"?id_flujo="+strIdFlujo;
	////System.err.println("URL="+URL);
	//////System.out.println("IdArea"+strIdArea);
	if(strIdFlujo != null)
	{
		strFlujos=ActualizaFlujo.getFlujos(strIdFlujo);
		strIdArea=strFlujos[0][0];		
		strIdTipoDocto=strFlujos[0][1];
		strIdTipoAsunto=strFlujos[0][2];
		strDescripcion=strFlujos[0][3];
		strCreador			=	ActualizaUsuario.NombreUsuario(strFlujos[0][4]);
		strFechaCreacion2	=	strFlujos[0][5];

		
		strAux = strDescripcion;
		strAux2 = strIdArea;
	}	
	
	if(strIdArea != null)
	{
		//strIdArea = request.getParameter("id_area");
		String TipDocArea[][] = ActualizaTipo_Doc.getDoctosArea(strIdArea);
	}
	
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strIdArea		=	request.getParameter("flujoArea");
		strIdTipoDocto		=	request.getParameter("flujoTipoDocto");
		strIdTipoAsunto		=	request.getParameter("flujoTipoAsunto");
		strDescripcion		=	request.getParameter("flujoDescripcion");

		valida = ActualizaFlujo.getRutaExiste(strDescripcion, strAux, strIdArea, strAux2);

		if (valida == 2){
			bInsertar	=	ActualizaFlujo.InsertarFlujo(	strIdFlujo, strIdArea, strIdTipoDocto, strIdTipoAsunto,
															strCreador1, strFechaCreacion, strEstatus, strDescripcion);
			try{
				response.sendRedirect("FlujoAtencionView.jsp");
			}catch(java.io.IOException io){
				//System.err.println("Error de redirección="+io);
			}
		}
	}else if(strAccion != null && strAccion.equals("guardar1")){
		strIdArea		=	request.getParameter("flujoArea");
		strIdTipoDocto		=	request.getParameter("flujoTipoDocto");
		strIdTipoAsunto		=	request.getParameter("flujoTipoAsunto");
		strDescripcion		=	request.getParameter("flujoDescripcion");
		strAux				=	request.getParameter("aux");
		strAux2				=	request.getParameter("aux2");

		valida = ActualizaFlujo.getRutaExiste(strDescripcion, strAux, strIdArea, strAux2);

		if (valida == 2){
			bInsertar	=	ActualizaFlujo.InsertarFlujo(	strIdFlujo, strIdArea, strIdTipoDocto, strIdTipoAsunto,
															strCreador1, strFechaCreacion, strEstatus, strDescripcion);
			
			String strIdRutaUltima = ActualizaFlujo.getUltimoIDRuta();
			
			String url1 = request.getRequestURI();
			String server1 = application.getInitParameter("servername");
			String URL1 = server+url+"?id_flujo="+strIdRutaUltima;
			
			try{
				response.sendRedirect("VisualizaInstrucciones.jsp?Ruta="+strIdRutaUltima+"&Url="+URL1);
			}catch(java.io.IOException io){
				//System.err.println("Error de redirección="+io);
			}
		}
	}
%>
<% if(strIdFlujo!=null && strIdFlujo.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT language=JavaScript type=text/javascript>

function guardarRuta() { 

	doc = document.FlujoAtencion;
	
	valida = 0;
	msg="";
	
	if (doc.flujoArea[doc.flujoArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Unidad	"+ "\n";
	}
	if (doc.flujoTipoDocto[doc.flujoTipoDocto.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar un Tipo de Documento	"+ "\n";
	}
	if (doc.flujoTipoAsunto[doc.flujoTipoAsunto.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar un Tipo de Asunto	"+ "\n";
	}
	if(Trim(doc.flujoDescripcion.value) == "" ){
		valida =1;
		msg = msg + " Debes capturar la descripción de la Ruta	"+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		return false;
	} 
	else 
	{
		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \' )\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.flujoDescripcion.value)){
			if (confirm(mensaje)){

				doc.flujoDescripcion.value	= quitaCE(doc.flujoDescripcion.value);

				doc.aux.value	= quitaCE(doc.aux.value);
				
				doc.accion.value="guardar";
				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar";
			doc.submit();
		}
	}
}
function areaRuta(){

	doc = document.FlujoAtencion;
	var a = doc.flujoArea.value;
	location.assign('FlujoAtencion.jsp?id_area='+a);
}
function regresarRuta(){
	location.assign('FlujoAtencionView.jsp');
}
function cargaApplet(){

	doc = document.FlujoAtencion;
	
	valida = 0;
	msg="";
	
	if (doc.flujoArea[doc.flujoArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Unidad	"+ "\n";
	}
	if (doc.flujoTipoDocto[doc.flujoTipoDocto.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar un Tipo de Documento	"+ "\n";
	}
	if (doc.flujoTipoAsunto[doc.flujoTipoAsunto.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar un Tipo de Asunto	"+ "\n";
	}
	if(Trim(doc.flujoDescripcion.value) == "" ){
		valida =1;
		msg = msg + " Debes capturar la descripción de la Ruta	"+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		return false;
	} 
	else 
	{
		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \')\nPresione Aceptar para eliminaros automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.flujoDescripcion.value)){
			if (confirm(mensaje)){

				doc.flujoDescripcion.value	= quitaCE(doc.flujoDescripcion.value);

				doc.aux.value	= quitaCE(doc.aux.value);
				
				doc.accion.value="guardar1";
				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar1";
			doc.submit();
		}
	}
	//location.assign('VisualizaInstrucciones.jsp?Ruta=strIdFlujo%>&Url==URL%>');
}
function cargaApplet1(){
	location.assign('VisualizaInstrucciones.jsp?Ruta=<%=strIdFlujo%>&Url=<%=URL%>');
}
	var digitos=10 //cantidad de digitos buscados 
	var puntero=0 
	var buffer=new Array(digitos) //declaración del array Buffer 
	var cadena="" 

	function buscar_opFLU(obj){
		var forma=document.FlujoAtencion;
	   	var letra = String.fromCharCode(event.keyCode)
	   	if(puntero >= digitos){ 
	    	cadena=""; 
	       	puntero=0; 
	    } 
	   	if (event.keyCode == 13){ 
	    	borrar_buffer(); 
			var cad="";
			if(obj.options[obj.selectedIndex].value!="-1")
			{
				var a = forma.flujoArea.value;
				location.assign('FlujoAtencion.jsp?id_area='+a);
			}
	    } 
	   	else{ 
	       	buffer[puntero]=letra; 
	       	cadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array 
	       	puntero++; 
	
	       	for (var opcombo=0;opcombo < obj.length;opcombo++){ 
	          	if(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ 
	          		obj.selectedIndex=opcombo; 
	        	} 
	       	} 
	    } 
	   	event.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter 
	}
	function borrar_bufferFLU(){ 
    	cadena=""; 
    	puntero=0; 
	}

	function limpiarCampos(){
		document.FlujoAtencion.reset();
	}

</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load(); limpiarCampos();" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="FlujoAtencion" method="post">
<INPUT type="hidden" value="<%= strAccion %>" name="accion">
<%if (strIdFlujo!=null){ %>
<INPUT type="hidden" value="<%=strIdFlujo %>" name="id_flujo">
<%}%>
<INPUT type="hidden" value="<%=strIdArea %>" name="id_area">
<INPUT type="hidden" value="<%=strAux %>" name="aux">
<INPUT type="hidden" value="<%=strAux2 %>" name="aux2">
<input type="hidden" name="vari" value="">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY>
	<TR valign="top">
		<TD width="99%" colspan="2">&nbsp;</TD>
		<TD width="1%">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="99%" colspan="2">
			<DIV align="right">
			</DIV>
		</TD>
		<TD width="1%">&nbsp;</TD>
	</TR>
</TBODY>
</TABLE>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="125">
			<A onclick="regresarRuta()" >
				<IMG border="0" src="../Imagenes/Regresar.gif" width="82" height="26">
			</A>
		</TD>
		<TD width="125">
			<a onclick="guardarRuta()">
			<img src="../Imagenes/Guardar.gif" width="81" border="0">
			</a>
		</TD>
		<TD></TD>
		<TD width="125">&nbsp;</TD>
		<TD width="344">&nbsp;</TD>
	</TR>
	</TBODY>
</TABLE>
</DIV><DIV align="center"><BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183"><B><FONT size="37777777777" color="#004080"
				face="Arial"></FONT></B><FONT
				color="#00204f" size="37777777777"><B><FONT size="+1"
				color="#004080">Ruta Automática</FONT></B></FONT></td>
		<td width="190"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="53"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td align="right" width="305"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""><FONT color="black">**Los datos marcados
			con negritas son obligatorios</FONT></td>
	</tr>
	<tr valign="top">
		<td bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</tr>
</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="183">
			<FONT face="Verdana" size="2">&nbsp;</FONT>
		</TD>
		<TD colspan="3" align="right" width="548">
			<FONT face="Verdana" size="2">Creado por: <I><%= strCreador %> - <%= strFechaCreacion2 %></I></FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="183"><BR>
			<BR>
			&nbsp;</TD>
		<TD colspan="3" width="548">&nbsp;</TD>
    </TR>
</TBODY>
</TABLE>
</DIV>
<DIV class=documentBody id=Body>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="183">
			<FONT face="Verdana" size="2" color="#004080"><B>Unidad Administrativa:</B></FONT>
		</TD>
		<TD colspan="3">
			<FONT face="Verdana" size="2">
				<% if(BUsuario.getSupervisor()){ %>
				<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" 
						size="1" name="flujoArea" 
						classHtml="blue500" selected="<%= strIdArea %>" 
						textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
						valorNoSeleccion="-1" script="onchange='area()' onKeypress='buscar_opFLU(this)' onblur='borrar_bufferFLU()' onclick='borrar_bufferFLU()'"/>
				<% }else{ %>
				<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo() %>" 
						size="1" name="flujoArea" 
						classHtml="blue500" selected="<%= strIdArea %>" 
						textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
						valorNoSeleccion="-1" script="onchange='areaRuta()' onKeypress='buscar_opFLU(this)' onblur='borrar_bufferFLU()' onclick='borrar_bufferFLU()'"/>
				<% } %>
            </FONT>
		</TD>
	</TR>
	<TR>
		<td width="183">&nbsp;</td>
		<td width="233">&nbsp;</td>
		<td width="67">&nbsp;</td>
		<TD width="246">&nbsp;</TD>
	</TR>
	<TR valign="top">
		<TD width="183">
			<FONT face="Verdana" size="2" color="#004080"><B>Tipo de Documento:</B></FONT>
		</TD>
		<TD colspan="3">
			<FONT face="Verdana" size="2">
				<% if(strIdArea != null){ %>
				<meve_combo:comboseleccion data="<%= ComboData.getTipoDoctoCombo(strIdArea) %>" size="1" name="flujoTipoDocto" classHtml="blue500" selected="<%= strIdTipoDocto %>" textoNoSeleccion=" ------------ Selecciona un Tipo de Documento ------------ " valorNoSeleccion="-1" />
				<% }else{ %>
				<SELECT class="blue100" name="flujoTipoDocto">
					<OPTION value="-1">---</OPTION>
				</SELECT>
				<% } %>
			</FONT>
		</TD>
	</TR>
	<TR>
		<td width="183">&nbsp;</td>
		<td width="233">&nbsp;</td>
		<td width="67">&nbsp;</td>
		<TD width="246">&nbsp;</TD>
	</TR>
	<TR valign="top">
		<TD width="183"><FONT face="Verdana" size="2" color="#004080"><B>Tipo de Asunto:</B></FONT></TD>
		<TD colspan="3">
			<FONT face="Verdana" size="2">
				<% if(strIdArea != null){ %>
				<meve_combo:comboseleccion data="<%= ComboData.getTipoAsuntoCombo(strIdArea) %>" size="1" name="flujoTipoAsunto" classHtml="blue500" selected="<%= strIdTipoAsunto %>" textoNoSeleccion=" ------------ Selecciona un Tipo de Asunto ------------ " valorNoSeleccion="-1" />
				<% }else{ %>
				<SELECT class="blue100" name="flujoTipoAsunto">
					<OPTION value="-1">---</OPTION>
				</SELECT>
				<% } %>
		        </FONT>
	</TR>
	<TR valign="top">
		<TD colspan="4">&nbsp;</TD>
	</TR>
	<TR valign="top">
		<TD width="183"><FONT face="Verdana" size="2" color="#004080"><B>Descripción:</B></FONT>
		<%if (valida == 1) {%><br>
		<FONT color="red"><B>*Esta Descripción ya existe* </B></FONT><%} %>
		</TD>
		<TD colspan="3">
			<FONT face="Verdana" size="2">
				<INPUT name="flujoDescripcion" value="<%=strDescripcion %>" class="blue200" maxlength="199">
	        </FONT>
	</TR>
	<TR valign="top">
		<TD colspan="4">&nbsp;</TD>
	</TR>
	<TR valign="top">
		<TD colspan="4" align="center">
			<% if(strIdFlujo != null){ %>
			<INPUT type="button" value="Ver Ruta" class="blue200" onclick="cargaApplet1()">
			<% }else{ %>
			<INPUT type="button" value="Crear Ruta" class="blue200" onclick="cargaApplet()">
			<% } %>
		</TD>
	</TR>
	
</TBODY>
</TABLE>
<br>
</DIV>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>