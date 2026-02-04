<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<TITLE>Remitentes</TITLE>
<HEAD>
<jsp:useBean id="Bremitente" class="com.meve.sigma.beans.BeanRemitente" scope="page">
	<jsp:setProperty name="Bremitente" property="*" />
<%@ page language="java"contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.taglib.*,com.meve.sigma.actualiza.*,com.meve.sigma.beans.*" %>
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
<% } %>
<% 
	String strNombre		=	(Bremitente.getRemitente()== null)?"":Bremitente.getRemitente();
	String strCargo			=	(Bremitente.getRemitenteCargo()== null)?"":Bremitente.getRemitenteCargo();
	String strIdArea		=	(Bremitente.getRemitenteArea()== null)?"":Bremitente.getRemitenteArea();
	String strIdEntidad		=	(Bremitente.getRemitenteEntidad()== null)?"":Bremitente.getRemitenteEntidad();
	String strTelefono		=	(Bremitente.getRemitenteTelefono()== null)?"":Bremitente.getRemitenteTelefono();
	String strCorreo		=	(Bremitente.getRemitenteCorreo()== null)?"":Bremitente.getRemitenteCorreo();
	String strDireccion		=	(Bremitente.getRemitenteDireccion()== null)?"":Bremitente.getRemitenteDireccion();
	String strFax			=	(Bremitente.getRemitenteFax()== null)?"":Bremitente.getRemitenteFax();

	String strIdRemitente	=	"";
	String strCreador		=	"";
	String strCreador1		=	"";
	String strFechaCreacion	=	"";
	String strAccion		=	"";
	String strEstatus		=	"1";
	String strEntidades[][] = 	null;
	String strRemitentes[][]=	null;
	

	boolean bInsertar		=	false;
	int valida = -2;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);

	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	BUsuario.getNombre();
	strIdRemitente	=	request.getParameter("id_remitente");

	strAccion		=	request.getParameter("accion");

	if(strIdRemitente != null)
	{
		strRemitentes=ActualizaRemitente.getRemitentes(strIdRemitente);
		strNombre		=	strRemitentes[0][0];
		strIdArea		=	strRemitentes[0][1];
		strCargo		=	strRemitentes[0][2];
		strIdEntidad	=	strRemitentes[0][3];
		strTelefono		=	strRemitentes[0][4];
		strCorreo		=	strRemitentes[0][5];
		strDireccion	=	strRemitentes[0][6];
		strFax			=	strRemitentes[0][7];
	}
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strNombre		=	request.getParameter("remitente");
		strIdArea		=	request.getParameter("remitenteArea");
		strCargo		=	request.getParameter("remitenteCargo");
		strIdEntidad	=	request.getParameter("remitenteEntidad");
		strDireccion	=	request.getParameter("remitenteDireccion");
		strTelefono		=	request.getParameter("remitenteTelefono");
		strFax			=	request.getParameter("remitenteFax");
		strCorreo		=	request.getParameter("remitenteCorreo");

		valida = ActualizaRemitente.getRemitenteExiste(strNombre, "1a2b3c", strIdEntidad, "1a2b3c");

		if (valida == 2)
		{
			bInsertar	= 	ActualizaRemitente.InsertarRemitente(	strIdRemitente, strNombre, strCargo, strIdArea, strIdEntidad, strTelefono,
																	strCorreo, strCreador1, strFechaCreacion, strEstatus, strDireccion, strFax);
			
			String strIdRem = "";
			if(bInsertar)
				strIdRem = ActualizaRemitente.ultimoIdRemitente();
			try{
			%>
			<SCRIPT language=JavaScript type=text/javascript>
					{
						//opener.document.getElementById('Remitente').contentWindow.location.reload();
						window.opener.document.Asunto.idRemitente.value = <%=strIdRem%>;
						window.opener.document.Asunto.asuntoRemitente.value = '<%=strNombre%>';
						window.opener.document.Asunto.asuntoCargo.value = '<%=strCargo%>';
						window.opener.document.Asunto.asuntoCorreo.value = '<%=strCorreo%>';
						window.opener.document.Asunto.asuntoFirmante.value = '<%=strNombre%>';
						window.close();
					}
			</SCRIPT>

			<% 
			}catch(Exception io){
				//System.out.println("ErrorRedirect-->"+io);
			}
		}
	}
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
function entidades() {
	doc = document.dRemitente;
	doc.accion.value="reload";
	doc.submit();
}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onunload="opener.hay_hija=false"
	onClick="opener.resetTimer();"
	onKeyPress="opener.resetTimer();">
<FORM action="DinamicRemitente.jsp" name="dRemitente" method="post">
<INPUT type="hidden" value="" name="accion">
<%if (strIdRemitente!=null){ %>
<INPUT type="hidden" value="<%=strIdRemitente %>" name="id_remitente">
<%}%>
<BR>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="150">
			<a onclick="window.close();">
			<img src="../Imagenes/NavLeft.gif" title="Regresar" border="0">
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a onclick="guardarRemitenteOtro()">
			<img src="../Imagenes/Save.gif" title="Guardar" border="0">
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
            <TD width="336" colspan="2"><B><FONT face="Verdana" color="#00204f" size="2">Remitentes</FONT></B></TD>
            <TD width="144">&nbsp;</TD>
            <TD width="192">&nbsp;</TD>
        </TR>
        <TR valign="top">
			<td bgcolor="#004080" colspan="4" width="672"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>
		<TR valign="top">
			<TD width="144">
				<FONT face="Verdana" size="2">&nbsp;</FONT>
			</TD>
			<TD align="right" colspan="3" width="528">
				<FONT face="Verdana" size="2">Creado por: <I><%= strCreador %> - <%= strFechaCreacion %></I></FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
    	</TR>
    </TBODY>
</TABLE>
</DIV>




<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2"><B>Unidad
			Administrativa:</B></FONT></TD>
		<TD width="528" colspan="3">
		<FONT face="Verdana" size="2">
			<% if(BUsuario.getSupervisor() || BUsuario.getRecepcion() || BUsuario.getTurnado()){ %>
			<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" 
					name="remitenteArea" classHtml="blue500a" 
					selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='entidades()'"/>
			<% }else{ %>
			<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo() %>" size="1" 
					name="remitenteArea" classHtml="blue500a" 
					selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='entidades()'"/>
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
		<TD width="144"><FONT face="Verdana" size="2"><B>Nombre:</B></FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitente" value="<%=strNombre %>" maxlength="199"></FONT>
		<%if (valida == 1) {%><br>
		<FONT color="red"><B>*Este Nombre ya existe en esta Entidad* </B></FONT><%} %>
		</TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2">Cargo:</FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitenteCargo" value="<%=strCargo %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2"><B>Entidad:</B></FONT></TD>
		<TD width="528" colspan="3">
			<FONT face="Verdana" size="2">
				<%if(strIdArea.length() > 0){%>
				<meve_combo:comboseleccion data="<%= ComboData.getEntidadAreaCombo(strIdArea) %>" 
					size="1" name="remitenteEntidad" classHtml="blue500a" 
					selected="<%= strIdEntidad %>" 
					textoNoSeleccion=" ------------ Selecciona una Entidad ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<%}else{%>
				<SELECT class="blue500a" name="remitenteEntidad">
					<OPTION value="-1">------------ Selecciona una Entidad ------------</OPTION>
				</SELECT>
				<%}%>
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
		<TD width="144"><FONT face="Verdana" size="2">Dirección:</FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitenteDireccion" value="<%=strDireccion %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2">Telefono:</FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitenteTelefono" value="<%=strTelefono %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2">Fax:</FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitenteFax" value="<%=strFax %>" maxlength="49"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2">Correo:</FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitenteCorreo" value="<%=strCorreo %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	
    </TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>
</jsp:useBean>