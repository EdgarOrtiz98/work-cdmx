<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<TITLE>Entidad</TITLE>
<HEAD>
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
<% if(BUsuario.getTurnado() ||
	BUsuario.getRecepcion()){ %>
<%}else{%>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<%}%>
<%
	String strEntidad		=	"";
	String strIdArea		=	"";
	String strEntidadClasificacion	=	"";
	String strEntidadDireccion	=	"";
	String strEntidadTel	=	"";
	String strCreador		=	"";
	String strCreador1		=	"";		
	String strFechaCreacion	=	"";
	String strAccion		=	"";
	String strEstatus		=	"1";
	String strEntidades[][]		=	null;
	String strIdEntidad		=	"";

	boolean bInsertar		=	false;
	int valida = -2;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);

	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	BUsuario.getNombre();
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
	}
	
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strEntidad		=	request.getParameter("entidad");
		strIdArea		=	request.getParameter("entidadArea");
		strEntidadClasificacion		=	request.getParameter("entidadClasificacion");
		strEntidadDireccion		=	request.getParameter("direccion");
		strEntidadTel		=	request.getParameter("tel");

		valida = ActualizaEntidad.getEntidadExiste(strEntidad, "1a2b3c", strIdArea, "1a2b3c");

		if (valida == 2)
		{
			bInsertar	=	ActualizaEntidad.InsertarEntidad(	strIdEntidad, strEntidad, strIdArea, strEntidadClasificacion,
																strEntidadDireccion, strEntidadTel, 
																strCreador1, strFechaCreacion, strEstatus);
			String strIdEnt = "0";
			if(bInsertar)
				strIdEnt = ActualizaEntidad.ultimoIdEntidad();
			%>
			<SCRIPT language=JavaScript type=text/javascript>
				{
					//opener.document.getElementById('Entidad').contentWindow.location.reload();
					window.opener.document.Asunto.idEntidad.value = <%=strIdEnt%>;
					window.opener.document.Asunto.asuntoEntidad.value = '<%=strEntidad%>';
					window.opener.document.Asunto.control.value = 0;
					window.opener.document.Asunto.asuntoRemitente.value = '';
					window.opener.document.Asunto.asuntoCargo.value = '';
					window.opener.document.Asunto.asuntoCorreo.value = '';
					window.close();
				}
			</SCRIPT>
			<%
		}
	}
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript" src="../js/link.js"></script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onunload="opener.hay_hija=false"
	onClick="opener.resetTimer();"
	onKeyPress="opener.resetTimer();"
	onMouseMove="limitaTextArea(document.dEntidad.direccion,'Dirección','200')";>
<FORM action="DinamicEntidad.jsp" name="dEntidad" method="post">
<%if (strIdEntidad!=null){ %>
<INPUT type="hidden" value="<%=strIdEntidad %>" name="id_entidad">
<%}%>
<INPUT type="hidden" value="" name="accion">
<BR>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="150">
			<a onclick="window.close();">
			<img src="../Imagenes/NavLeft.gif" title="Regresar" border="0">
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a onclick="guardarEntidadOtro()">
			<img src="../Imagenes/Save.gif" title="Guardar"  border="0">
			</a>
		&nbsp;</TD>
		<TD width="150">

		&nbsp;</TD>
		<TD width="150"></TD>
		<TD width="217"></TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
<BR>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
<TR valign="top">
<TD width="336" colspan="2"><B><FONT face="Verdana" color="#00204f" size="2">Entidad</FONT></B></TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>
<TR valign="top">
<td width="672" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
        </TR>

	<TR valign="top">
		<TD width="144">
			<FONT face="Verdana" size="2">&nbsp;</FONT>
		</TD>
		<TD width="528" align="right" colspan="3">
			<FONT face="Verdana" size="2">Creado por: <I><%= strCreador %> - <%= strFechaCreacion %></I></FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>

<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2"><B>Unidad Administrativa:</B></FONT></TD>
<TD width="528" colspan="3">
		<FONT face="Verdana" size="2">
			<% if(BUsuario.getSupervisor() || BUsuario.getRecepcion() || BUsuario.getTurnado()){ %>
			<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" 
					size="1" name="entidadArea" 
					classHtml="blue500a" selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
			<% }else{ %>
			<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo() %>" 
					size="1" name="entidadArea" 
					classHtml="blue500a" selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
			<% } %>
		</FONT>
</TD>
</TR>
<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2"><B>Entidad:</B></FONT>
<%if (valida == 1) {%><br>
<FONT color="red"><B>*Esta Entidad ya existe* </B></FONT><%} %>
</TD>
<TD width="528" colspan="3"><FONT face="Verdana" size="2">
<INPUT class="blue500" name="entidad" value="<%= strEntidad  %>" maxlength="199"></FONT></TD>
</TR>
<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2">Clasificación:</FONT></TD>
<TD width="528" colspan="3"><FONT face="Verdana" size="2">
	<SELECT name="entidadClasificacion" class="blue200a">
		<OPTION value="Privada" <%=(strEntidadClasificacion.trim().equals("Privada")?"selected":"")%>>Privada</OPTION>
		<OPTION value="Pública" <%=(strEntidadClasificacion.trim().equals("Pública")?"selected":"")%>>Pública</OPTION>
	</SELECT>
	</FONT></TD>
</TR>
<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>


<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2">Dirección:</FONT></TD>
<TD width="528" colspan="3"><FONT face="Verdana" size="2">
	<TEXTAREA class="blue500" name="direccion" rows="3"
		onKeyDown="limitaTextArea(document.dEntidad.direccion,'Dirección','200')";><%= strEntidadDireccion  %></TEXTAREA> 
</FONT></TD>
        </TR>
<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2">Teléfono:</FONT></TD>
<TD width="528" colspan="3"><FONT face="Arial" size="2"><INPUT class="blue500" name="tel" value="<%= strEntidadTel  %>" maxlength="199"></FONT></TD>
        </TR>
<TR valign="top">
<TD width="672" colspan="4">&nbsp;</TD>
        </TR>
    </TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>