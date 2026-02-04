<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Tipo de Documento</TITLE>
<%@ page language="java"contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.taglib.*,com.meve.sigma.beans.*" %>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){;}
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
	String strTipo_Doc		=	"";
	String strIdArea		=	"";
	String strTipo_DocClave	=	"";
	String strCreador		=	"";
	String strCreador1		=	"";		
	String strFechaCreacion	=	"";
	String strFechaCreacion2=	"";
	String strConsecutivo	=	"";//nuevo
	String strAccion		=	"";
	String strEstatus		=	"1";
	String strTipos_Doc[][]	=	null;
	String strIdTipo_Doc	=	"";
	String strConfFolio		=	application.getInitParameter("genFolio");

	String retURI = (request.getParameter("retURI")== null)?"TipoDocumentoView.jsp":request.getParameter("retURI");
	String strAux = "1a2b3c", strAux2 = "1a2b3c";
	int valida = -2;

	boolean bInsertar		=	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	strFechaCreacion2 				=	strFechaCreacion;

	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
	strIdTipo_Doc	=	request.getParameter("id_tipo_doc");
	strAccion		=	request.getParameter("accion");
	
	if(strIdTipo_Doc != null)
	{
		strTipos_Doc=ActualizaTipo_Doc.getTipos_Doc(strIdTipo_Doc);
		strTipo_Doc=strTipos_Doc[0][0];		
		strIdArea=strTipos_Doc[0][1];
		strTipo_DocClave=strTipos_Doc[0][2];
		strConsecutivo = strTipos_Doc[0][3];//nuevo

		strCreador 			= ActualizaUsuario.NombreUsuario(strTipos_Doc[0][4]);
		strFechaCreacion2	= strTipos_Doc[0][5];

		strAux = strTipo_DocClave;
		strAux2 = strIdArea;
	} 
		
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strTipo_Doc		=	request.getParameter("tipo_doc");
		strIdArea		=	request.getParameter("tipo_docArea");
		strTipo_DocClave	=	request.getParameter("cveTipoDoc");
		if(strConfFolio.equals("1"))
			strConsecutivo	=	request.getParameter("cveConsecutivo"); 
		else
			strConsecutivo 	=	"0";
		
		valida = ActualizaTipo_Doc.getTipoDocExiste(strTipo_DocClave, strAux, strIdArea, strAux2);	

		if (valida == 2){
			bInsertar	=	ActualizaTipo_Doc.InsertarTipo_Doc(	strIdTipo_Doc, strTipo_Doc, 
																strIdArea, strTipo_DocClave,
																strCreador1, strFechaCreacion, 
																strEstatus, strConsecutivo);
	%>
<SCRIPT language=JavaScript type=text/javascript>
{
	location.assign('<%= retURI %>');
}
</SCRIPT>
<%
		}
	}
%>
<% if(strIdTipo_Doc!=null && strIdTipo_Doc.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>
<!-- 

function guardar() { 

	doc = document.TipoDoc;
	
	msg="";

		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \' )\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.tipo_doc.value) || detectaCE(doc.cveTipoDoc.value)){
			if (confirm(mensaje)){

				doc.tipo_doc.value		= quitaCE(doc.tipo_doc.value);
				doc.cveTipoDoc.value	= quitaCE(doc.cveTipoDoc.value);
				doc.aux.value	= quitaCE(doc.aux.value);

				doc.accion.value="guardar";
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar";
		}
	if (doc.tipo_docArea[doc.tipo_docArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Unidad	"+ "\n";
	}
	if(Trim(doc.tipo_doc.value) == ""){
		valida =1;
		msg = msg + " Debes capturar el nombre del Tipo de Documento	"+ "\n";
	}
	if(Trim(doc.cveTipoDoc.value) == ""){
		valida =1;
		msg = msg + " Debes capturar la clave del Tipo de Documento	"+ "\n";
	}
	<%if(strConfFolio.equals("1")){%>
	if(Trim(doc.cveConsecutivo.value) == ""){
		valida =1;
		msg = msg + " Debes capturar un Consecutivo al Tipo de Documento	"+ "\n";
	}
	<%}%>
	if (Trim(quitaPuntos(doc.tipo_doc.value)) =="" && doc.tipo_doc.value!="") {
		valida =1;
		msg = msg + " El Tipo de Documento no es válido"+ "\n";
	}
	if (Trim(quitaPuntos(doc.cveTipoDoc.value)) =="" && doc.cveTipoDoc.value!="") {
		valida =1;
		msg = msg + " La Clave de Tipo de Documento no es válida"+ "\n";
	}
	if (Trim(quitaPuntos(doc.cveConsecutivo.value)) =="" && doc.cveConsecutivo.value!="") {
		valida =1;
		msg = msg + " El Cosecutivo al Tipo de Documento no es válido"+ "\n";
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

function limpiarCampos(){
	document.TipoDoc.reset();
}

</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="valida=0;timer_load();limpiarCampos();" onKeyPress="timer_reload()" 
	onClick="timer_reload()"
	onmousemove="validaSoloNumeros(document.TipoDoc.cveConsecutivo,'Consecutivo');">
<FORM action="TipoDocumento.jsp" name="TipoDoc" method="post">
<INPUT type="hidden" value="" name="accion">
<%if (strIdTipo_Doc!=null){ %>
<INPUT type="hidden" value="<%=strIdTipo_Doc %>" name="id_tipo_doc">
<%}%>
<INPUT type="hidden" value="<%=strAux %>" name="aux">
<INPUT type="hidden" value="<%=strAux2 %>" name="aux2">
<INPUT type="hidden" value="<%=retURI %>" name="retURI">

<DIV class="documentBody" id="Body" style="HEIGHT: 441px">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>

	<TR valign="top">
		<TD colspan="2">
			<a href="<%= retURI %>">
			<IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar">
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a onclick="guardar()">
			<img src="../Imagenes/Save.gif" title="Guardar">
			</a>
		</TD>
    </TR>

        <TR valign="top">
            <TD width="30%"><B><FONT face="Verdana" color="#00204f" size="2"><FONT
				size="+1" color="#004080">Tipo de Documento</FONT></FONT></B></TD>
            <TD width="70%" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
        </TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2"></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2"></TD>
		</TR>

	<TR valign="top">
		<TD width="144">
			<FONT face="Verdana" size="2">&nbsp;</FONT>
		</TD>
		<TD width="528" align="right">
			<FONT face="Verdana" size="2">
				<%=(strIdTipo_Doc!=null && !strIdTipo_Doc.equals(""))?"Última modificación por: ":"Creado por: "%><I><%= strCreador %> - <%= strFechaCreacion2 %></I></FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="144"><BR>
			<BR>
			&nbsp;</TD>
		<TD width="528">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Unidad
			Administrativa:</B></FONT></TD>
		<TD width="528">
			<FONT face="Verdana" size="2">
				<% if(BUsuario.getSupervisor()){ 
					if(strIdTipo_Doc==null){
						strIdArea = BUsuario.getIdArea();
					} 
			%>
				<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" 
					size="1" name="tipo_docArea" 
					classHtml="blue600a" selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<% }else{ %>
				<meve_combo:comboseleccion data="<%= ComboData.getAreasComboAll() %>" 
					size="1" name="tipo_docArea" 
					classHtml="blue600a" selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<% } %>
			</FONT>
		</TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="528">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Tipo de Documento:</B></FONT></TD>
		<TD width="528"><FONT face="Verdana" size="2">
			<INPUT class="blue600a" size="80" name="tipo_doc"  value="<%=strTipo_Doc %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="528">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Clave del Documento:</B></FONT>
		<%if (valida == 1) {%><br>
		<FONT color="red"><B>*Esta Clave ya existe* </B></FONT><%} %>
		</TD>
		<TD width="528"><FONT face="Verdana" size="2">
			<INPUT class="blue600a" size="80" name="cveTipoDoc"  value="<%=strTipo_DocClave %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="528">&nbsp;</TD>
    </TR>
	<% if(strConfFolio.equals("1")){ %>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Consecutivo:</B></FONT></TD>
		<TD width="528"><FONT face="Verdana" size="2">
			<INPUT class="blue50a" size="80" name="cveConsecutivo" value="<%=strConsecutivo %>" onKeyPress='AceptaSoloTeclaNumericaYPunto();' maxlength="5"></FONT></TD>
    </TR>
	<% } %>
    </TBODY>
</TABLE>
</DIV>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>