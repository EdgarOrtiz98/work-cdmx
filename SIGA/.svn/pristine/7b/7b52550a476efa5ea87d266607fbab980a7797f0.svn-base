<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Entidad</TITLE>
<%@ page language="java"contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.taglib.*,com.meve.sigma.beans.*"%>
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
	String strEntidad		=	"";
	String strIdArea		=	"";
	String strEntidadClasificacion	=	"";
	String strEntidadDireccion	=	"";
	String strEntidadTel	=	"";
	String strCreador		=	"";
	String strCreador1		=	"";		
	String strFechaCreacion	=	"";
	String strFechaCreacion2=	"";
	String strAccion		=	"";
	String strEstatus		=	"1";
	String strEntidades[][]		=	null;
	String strIdEntidad		=	"";

	String strAux = "1a2b3c", strAux2 = "1a2b3c";
	int valida = -2;
	String retURI = (request.getParameter("retURI")== null)?"EntidadView.jsp":request.getParameter("retURI");

	boolean bInsertar		=	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	strFechaCreacion2 				=	strFechaCreacion;

	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
	strIdEntidad	=	request.getParameter("id_entidad");
	strAccion		=	request.getParameter("accion");
	
	if(strIdEntidad != null)
	{
		strEntidades			=	ActualizaEntidad.getEntidades(strIdEntidad);
		strEntidad				=	strEntidades[0][0];
		strIdArea				=	strEntidades[0][1];		
		strEntidadClasificacion	=	strEntidades[0][2];
		strEntidadDireccion		=	strEntidades[0][3];
		strEntidadTel			=	strEntidades[0][4];
		strCreador				=	ActualizaUsuario.NombreUsuario(strEntidades[0][5]);
		strFechaCreacion2		=	strEntidades[0][6];
		
		strAux = strEntidad;
		strAux2 = strIdArea;
	}
	
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strEntidad					=	request.getParameter("entidad");
		strIdArea					=	request.getParameter("entidadArea");
		strEntidadClasificacion		=	request.getParameter("entidadClasificacion");
		strEntidadDireccion			=	request.getParameter("direccion");
		strEntidadTel				=	request.getParameter("tel");
		strAux						=	request.getParameter("aux");
		strAux2						=	request.getParameter("aux2");

		valida = ActualizaEntidad.getEntidadExiste(strEntidad, strAux, strIdArea, strAux2);

		if (valida == 2){
			bInsertar	=	ActualizaEntidad.InsertarEntidad(	strIdEntidad, strEntidad, strIdArea, strEntidadClasificacion,
																strEntidadDireccion, strEntidadTel, 
																strCreador1, strFechaCreacion, strEstatus);
	
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
<% if(strIdEntidad!=null && strIdEntidad.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>

function guardar() { 

	doc = document.Entidad;
	
	//valida = 0;
	msg="";
	mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \')\nPresione Aceptar para modificarlos automaticamente\no Cancelar para regresar'
//	else 	{
		if(detectaCE(doc.entidad.value) || detectaCE(doc.direccion.value)){
			if (confirm(mensaje)){

				doc.entidad.value	=quitaCE(doc.entidad.value);
				doc.direccion.value	=quitaCE(doc.direccion.value);
				doc.aux.value		=quitaCE(doc.aux.value);
				
				doc.accion.value="guardar";
//				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar";
//			doc.submit();
		}
//	}
	if (doc.entidadArea[doc.entidadArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Unidad	"+ "\n";
	}
	if (Trim(doc.entidad.value) =="") {
		valida =1;
		msg = msg + " Debes capturar el nombre de la Entidad	"+ "\n";
	}
	if (!isTelefono(Trim(doc.tel.value))) {
		valida =1;
		msg = msg + " El número de Teléfono es inválido	"+ "\n";
	}
	if (Trim(quitaPuntos(doc.entidad.value)) =="" && doc.entidad.value!="") {
		valida =1;
		msg = msg + " El Nombre de la Entidad no es válido"+ "\n";
	}
	if (Trim(quitaPuntos(doc.direccion.value)) =="" && doc.direccion.value!="") {
		valida =1;
		msg = msg + " La Dirección no es válida"+ "\n";
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
	document.Entidad.reset();
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
	onMouseMove="limitaTextArea(document.Entidad.direccion,'Dirección','200')">
<FORM action="Entidad.jsp" name="Entidad" method="post">
<%if (strIdEntidad!=null){ %>
<INPUT type="hidden" value="<%=strIdEntidad %>" name="id_entidad">
<%}%>
<INPUT type="hidden" value="<%=strAux %>" name="aux">
<INPUT type="hidden" value="<%=strAux2 %>" name="aux2">
<INPUT type="hidden" value="<%=retURI %>" name="retURI">
<INPUT type="hidden" value="" name="accion">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="125">
			<A href="<%= retURI %>">
			<IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar"></A>
			<a onclick="guardar()">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<img src="../Imagenes/Save.gif" title="Guardar">
			</a>
		</TD>
		<TD width="125">

		</TD>
		<TD></TD>
		<TD width="125">&nbsp;</TD>
		<TD width="125">&nbsp;</TD>
		<TD width="164">&nbsp;</TD>
    </TR>
</TBODY>
</TABLE>
</DIV>

<DIV align="center">
<BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
				<TD colspan="2"><B><FONT color="#004080" size="0"></FONT></B><FONT
				color="#00204f" size="37777777777"><B><FONT size="+1"
				color="#004080">Entidad</FONT></B></FONT></TD>
				<TD colspan="2" align="right">&nbsp;<FONT color="black">**Los datos	marcados con negritas son obligatorios</FONT></TD>
        </TR>
<TR valign="top">
<td bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
        </TR>

	<TR valign="top">
		<TD width="161">
			<FONT face="Verdana" size="2">&nbsp;</FONT>
		</TD>
		<TD align="right" colspan="3">
			<FONT face="Verdana" size="2">
				<%=(strIdEntidad!=null && !strIdEntidad.equals(""))?"Última modificación por: ":"Creado por: "%><I><%= strCreador %> - <%= strFechaCreacion2 %></I></FONT>
		</TD>
	</TR>

<TR valign="top">
<TD width="161"><BR>
			<BR></TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>
<TD width="493">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="161"><FONT face="Verdana" size="2"> </FONT><FONT
				face="Verdana" size="2" color="#004080"><B>Unidad Administrativa</B>:</FONT></TD>
<TD colspan="3">
		<FONT face="Verdana" size="2">
			<% if(BUsuario.getSupervisor()){
				if(strIdEntidad==null){
					strIdArea = BUsuario.getIdArea();
				} 
			%>
			<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" 
					size="1" name="entidadArea" 
					classHtml="blue600a" selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
			<% }else{ %>
			<meve_combo:comboseleccion data="<%= ComboData.getAreasComboAll() %>" 
					size="1" name="entidadArea" 
					classHtml="blue600a" selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
			<% } %>
		</FONT>
</TD>
</TR>
<TR valign="top">
<TD width="161">&nbsp;</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>
<TD width="493">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="161"><FONT face="Verdana" size="2" color="#004080"><B>Entidad</B></FONT><FONT
				face="Verdana" size="2">:</FONT>
<%if (valida == 1) {%> <br>
<FONT color="red"><B>*Esta Entidad ya existe* </B></FONT><%} %>
</TD>
<TD colspan="3"><FONT face="Verdana" size="2">
<INPUT class="blue600a" name="entidad" onkeydown="" value="<%= strEntidad  %>" maxlength="199"></FONT></TD>
</TR>
<TR valign="top">
<TD width="161">&nbsp;</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>
<TD width="493">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="161"><FONT face="Verdana" size="2" color="#004080">Clasificación:</FONT></TD>
<TD colspan="3"><FONT face="Verdana" size="2">
	<SELECT name="entidadClasificacion" class="blue200a">
		<OPTION value="Privada" <%=(strEntidadClasificacion.trim().equals("Privada")?"selected":"")%>>Privada</OPTION>
		<OPTION value="Pública" <%=(strEntidadClasificacion.trim().equals("Pública")?"selected":"")%>>Pública</OPTION>
	</SELECT>
	</FONT></TD>
</TR>
<TR valign="top">
<TD width="161">&nbsp;</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>
<TD width="493">&nbsp;</TD>
        </TR>


<TR valign="top">
<TD width="161"><FONT face="Verdana" size="2" color="#004080">Dirección:</FONT></TD>
<TD colspan="3"><FONT face="Verdana" size="2">
	<TEXTAREA class="blue600a" rows="3" name="direccion"
		onKeyDown="limitaTextArea(document.Entidad.direccion,'Dirección','200')"><%= strEntidadDireccion  %></TEXTAREA> 
<!-- El campo esta delimitado a 500 caracteres -->
</FONT></TD>
        </TR>
<TR valign="top">
<TD width="161">&nbsp;</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>
<TD width="493">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="161"><FONT face="Verdana" size="2" color="#004080">Teléfono:</FONT></TD>
<TD colspan="3"><FONT face="Arial" size="2"><INPUT class="blue600a" name="tel"  value="<%= strEntidadTel  %>" maxlength="199"></FONT></TD>
        </TR>
<TR valign="top">
<TD colspan="4">&nbsp;</TD>
        </TR>
    </TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>