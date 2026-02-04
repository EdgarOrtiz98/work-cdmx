<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<jsp:include page="headerSIGAConf.jsp" flush="false" />
<%@page import="com.meve.sigma.beans.UsuarioBean"%>
<%@page import="java.util.Date"%>
<%@page import="com.meve.util.DateFormatter"%>
<HTML>
<HEAD>
<TITLE>Puestos</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%
			UsuarioBean usuario = (UsuarioBean) session
			.getAttribute("UsuarioBean");
	String strTmp = request.getRequestURI();
	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
			.length());
	if (usuario == null) {
		try {
			response.sendRedirect("index.jsp?pagina=" + strTmp);
		} catch (java.io.IOException io) {
		}
	}
%>

<LINK href="./theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="./css/menu.css" rel="stylesheet" type="text/css">
<STYLE type="text/css">
</STYLE>
<SCRIPT src="./js/SigmaJS.js" type=text/javascript></SCRIPT>
<script src="./js/SigaJS.js" type="text/javascript"></script>
<script src="./js/estructuraOrganizacional.js" type="text/javascript"></script>
<jsp:useBean id="puestoForm" scope="session"
	class="com.meve.sigma.organizacional.puesto.PuestoForm"
	type="com.meve.sigma.organizacional.puesto.PuestoForm"></jsp:useBean>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY onload="setChecksAsistentes(<%=puestoForm.getChecksAsistentes()%>);setCheckRoles(<%=puestoForm.getChecksRoles()%>);return false;">
<html:form action="puesto">
	<input type="hidden" name="accion" value="" />
	<input type="hidden" name="idLink" value="" />
	<DIV align="center"><BR>
	<TABLE cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<TR valign="top">
				<TD width="125">
				   <a href="javascript:;" onclick="submitForm(puestoForm,'regresar','');return false;"> 
				      <IMG border="0" src="./Imagenes/NavLeft.gif" title="Regresar">
				   </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				   <a href="javascript:;" onclick="submitForm(puestoForm,'${puestoForm.accion}','guardar');return false;"> 
				      <IMG border="0" src="./Imagenes/Save.gif" title="Guardar">
				   </a>
				</TD>
				<TD width="125"></TD>
				<TD width="125">&nbsp;</TD>
				<TD width="125">&nbsp;</TD>
				<TD width="125">&nbsp;</TD>
				<TD width="142"></TD>
			</TR>
		</TBODY>
	</TABLE>
	</DIV>
	<DIV align="center"></DIV>
	<br>
	<DIV class=documentBody id=Body>
	<DIV align="center">
	<TABLE width="820" cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<TR valign="top">
				<TD width="50%"><B><FONT face="Verdana" color="#00204f"
					size="2">Registro de Puesto</FONT></B></TD>
				<TD width="50%" align="right">**Los datos marcados con negritas
				son obligatorios&nbsp;<FONT face="Verdana" size="2"><I></I></FONT></TD>
			</TR>
			<TR valign="top" bgcolor="#004080">
				<TD colspan="2"></TD>
			</TR>
			<TR valign="top" bgcolor="#004080">
				<TD colspan="2"></TD>
			</TR>
			<TR valign="top">
				<TD align="right" colspan="2"><FONT face="Verdana" size="2">
				Creado por: <I><%=usuario.getCargo()%> - <%=DateFormatter.getFecha(new Date().getTime()) %></I></FONT></TD>
			</TR>
		</TBODY>
	</TABLE>
	<table cellspacing="0" cellpadding="0" border="0">
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="531">&nbsp;</TD>
		</TR>
		<TR VALIGN=top>
			<TD width="218"><FONT SIZE="2" FACE="Verdana" color="#004080"><B>Usuario:</B></FONT><BR>
			</TD>
			<TD width="531"><FONT SIZE="2" FACE="Verdana"> <html:text
				property="usuario" size="50" styleClass="blue600a" maxlength="20" />
			</FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="531">&nbsp;</TD>
		</TR>
		<TR VALIGN=top>
			<TD width="218"><FONT SIZE="2" FACE="Verdana" color="#004080"><B>Contraseña:</B></FONT></TD>
			<TD width="531"><FONT SIZE="2" FACE="Verdana"> <html:password
				property="password" size="50" styleClass="blue600a" maxlength="15" />
			</FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="531">&nbsp;</TD>
		</TR>
	</table>
	</DIV>
	<DIV align="center">
	<TABLE width="820" cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<TR valign="top">
				<TD><B><FONT face="Verdana" color="#00204f" size="2">Datos
				Personales</FONT></B></TD>
			</TR>
			<TR valign="top">
				<TD bgcolor="#00204f"><img src="./Imagenes/shim.gif" width="1"
					height="2" title=""></TD>
			</TR>
		</TBODY>
	</TABLE>
	<DIV align="center">
	<table cellspacing="0" cellpadding="0" border="0">
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<TD width="529">&nbsp;</TD>
		</TR>
		<%
		if (false) {
		%>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="529">&nbsp;</TD>
		</TR>
		<TR VALIGN=top>
			<TD width="218"><FONT SIZE="2" FACE="Verdana" color="#004080">Buscar
			Datos:</FONT></TD>
			<TD width="529"><FONT SIZE="2" FACE="Verdana"> <html:select
				property="usuarioLdap" styleClass="blue500a">
				<html:option value="-1"> ---------------- Selecciona un Puesto ---------------- </html:option>
				<logic:iterate id="registro" name="puestosLdap"
					type="java.lang.String">
					<html:option value="${registro}">${registro}</html:option>
				</logic:iterate>
			</html:select> </FONT></TD>
		</TR>
		<%
		}
		%>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="529">&nbsp;</TD>
		</TR>
		<TR VALIGN=top>
			<TD width="218"><FONT SIZE="2" FACE="Verdana" color="#004080"><B>Unidad
			Administrativa:</B></FONT></TD>
			<TD width="529"><FONT SIZE="2" FACE="Verdana"> <html:select
				property="idUnidadAdministrativa"
				onchange="submitForm(puestoForm,'nuevoPuesto','seleccionaArea');return false;"
				styleClass="blue500a">
				<html:option value="-1">------------- Seleccione una Unidad Administrativa ------------- </html:option>
				<logic:iterate id="registro" name="areas"
					type="com.meve.sigma.organizacional.vo.AreaVO">
					<html:option value="${registro.idArea}">${registro.nombreHTML}</html:option>
				</logic:iterate>
			</html:select> </FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="529">&nbsp;</TD>
		</TR>
		<TR VALIGN=top>
			<TD width="218"><FONT face="Verdana" size="2" color="#004080">
			<B>Puesto:</B> </FONT><BR>
			</TD>
			<TD width="529"><FONT SIZE="2" FACE="Verdana"> <html:text
				property="puesto" size="50" maxlength="199" styleClass="blue600a" />
			</FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="529">&nbsp;</TD>
		</TR>
		<TR VALIGN=top>
			<TD width="218"><FONT SIZE="2" FACE="Verdana" color="#004080">
			<B>Responsable:</B></FONT><BR>
			</TD>
			<TD width="529"><FONT SIZE="2" FACE="Verdana"> <html:text
				property="responsable" size="50" maxlength="199"
				styleClass="blue600a" /> </FONT></TD>
		</TR>

		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="529">&nbsp;</TD>
		</TR>
		<TR VALIGN=top>
			<TD width="218"><FONT SIZE="2" FACE="Verdana" color="#004080"><B>Correo
			Electrónico:</B></FONT></TD>
			<TD width="529"><FONT SIZE="2" FACE="Verdana"> <html:text
				property="correo" maxlength="100" size="50" styleClass="blue600a" />
			</FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="529">&nbsp;</TD>
		</TR>
		<TR VALIGN=top>
			<TD width="218"><FONT SIZE="2" FACE="Verdana" color="#004080">Teléfono:</FONT></TD>
			<TD width="529"><FONT SIZE="2" FACE="Verdana"> <html:text
				property="telefono" size="100" maxlength="199" styleClass="blue600a" />
			</FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="529">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="529">&nbsp;</TD>
		</TR>
		<logic:notEqual value="-1" property="idUnidadAdministrativa"
			name="puestoForm">
			<TR VALIGN=top>
				<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">Jefe
				(Puesto): </FONT></TD>
				<TD width="529">
				 <html:select property="idJefe"
					styleClass="blue600a">
					<html:option value="-1">------------ Puesto UA Padre ------------</html:option>
					<logic:iterate id="registro" name="puestosPadre"
						type="com.meve.sigma.organizacional.vo.PuestoVO">
						<html:option value="${registro.idUsuario}">${registro.nombre}/${registro.cargo}</html:option>
					</logic:iterate>
					<html:option value="-1">------------ Puestos UA ------------</html:option>
					<logic:iterate id="registro" name="puestos"
						type="com.meve.sigma.organizacional.vo.PuestoVO">
						<html:option value="${registro.idUsuario}">${registro.nombre}/${registro.cargo}</html:option>
					</logic:iterate>
				</html:select>
				</TD>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="529">&nbsp;</TD>
			</TR>
			<%if (false) {%>
			<TR valign="top">
				<TD width="144"><FONT SIZE=2 FACE="Verdana" color="#004080">Nombre
				del Jefe:</FONT></TD>
				<TD width="529">${puestoForm.jefe}</TD>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="529">&nbsp;</TD>
			</TR>
			<%
			}
			%>
			<TR VALIGN=top>
				<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">
				</FONT></TD>
				<%
				if (true) {
				%>
				<TD width="600">
				<FIELDSET dir="ltr" class="bluethinBorder"><LEGEND align="left"><FONT
					SIZE=2 FACE="Verdana" color="#004080"><B>Asistentes</B></FONT></LEGEND> <FONT
					SIZE=2 FACE="Verdana">
				<table width="100%">
					<tbody>
						<logic:iterate id="asistente" name="puestoForm"
							property="asistentes"
							type="com.meve.sigma.organizacional.vo.AsistenteVO">
							<tr><td width="100%">
							<input type="checkbox" name="idAsistentes"
								value="${asistente.idUsuario}">
							${asistente.nombre}/${asistente.cargo}</td>
							</tr>
						</logic:iterate>
					</tbody>
				</table>
				</FONT></FIELDSET>
				</TD>
				<%
				}
				%>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="529">&nbsp;</TD>
			</TR>
			<TR VALIGN=top>
				<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">Atención
				Destinatarios Externos:</FONT></TD>
				<TD width="529"><FONT SIZE=2 FACE="Verdana"> <INPUT
					type="checkbox" name="atencionExternos" id="chkAtencionExternos" value="1" />Si </FONT></TD>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="529">&nbsp;</TD>
			</TR>
			
			<TR VALIGN=top>
		      <TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">Atención SubVentanilla:</FONT></TD>
		      <TD width="529"><FONT SIZE=2 FACE="Verdana"> 
			  <html:select property="idSubventanilla" styleClass="blue600a">
					<html:option value="0">------------ Puestos Atencion ------------</html:option>
					<logic:iterate id="registro" name="puestosAtencion"
						type="com.meve.sigma.organizacional.vo.PuestoVO">
						<html:option value="${registro.idUsuario}">${registro.nombre}/${registro.cargo}</html:option>
					</logic:iterate>
				</html:select>
		      </FONT></TD>
	        </TR>
	        <TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="529">&nbsp;</TD>
			</TR>

			<TR VALIGN=top>
				<TD width="218"><FONT SIZE=2 FACE="Verdana">&nbsp;</FONT></TD>
				<TD width="600">
				<FIELDSET dir="ltr" class="bluethinBorder"><LEGEND align="left"><FONT
					SIZE=2 FACE="Verdana" color="#004080"><B>Rol de Usuario</B></FONT></LEGEND>
				<TABLE width="100%">
					<TBODY>
						<TR>
							<TD width="25%"><FONT SIZE=1 FACE="Verdana"> 
							<%if (usuario.getSupervisor()) {%>
							   <INPUT value="0" name="idRoles" type="checkbox" disabled="disabled" >Administrador 
							<%} else {%> 
							<logic:equal value="0" property="idUnidadAdministrativa" name="puestoForm">
							   <INPUT value="0" name="idRoles" type="checkbox" onclick="seleccionaRol(this);">Administrador
						    </logic:equal>
						    <logic:notEqual value="0" property="idUnidadAdministrativa" name="puestoForm">
						       <INPUT value="0" id="chkAdministrador" name="idRoles" type="checkbox" 
						              disabled="disabled" onclick="seleccionaRol(this);">Administrador
						    </logic:notEqual>
							<%}%> 
                           </FONT></TD>
							<TD width="25%"><FONT SIZE=1 FACE="Verdana"><INPUT 
								value="1" id="chkAtencion" name="idRoles" type="checkbox" 
								onclick="seleccionaRol(this);">Atención </FONT></TD>

							<TD width="25%"><FONT SIZE=1 FACE="Verdana"> <INPUT 
								value="3" id="chkRecepcion" name="idRoles" type="checkbox" 
								onclick="seleccionaRol(this);">Recepción </FONT></TD>
							<TD width="25%"><FONT SIZE=1 FACE="Verdana"> <INPUT
								value="2" id="chkSCP" name="idRoles" type="checkbox" 
								onclick="seleccionaRol(this);">SCP </FONT></TD>
						</TR>
						<TR>
							<TD width="25%"><FONT SIZE=1 FACE="Verdana"> <INPUT 
								value="4" id="chkSupervisor" name="idRoles" type="checkbox" 
								onclick="seleccionaRol(this);">Supervisor Área
							</FONT></TD>
							<TD width="25%"><FONT SIZE=1 FACE="Verdana"> <INPUT 
								value="5" id="chkTurnador" name="idRoles" type="checkbox" 
								onclick="seleccionaRol(this);">Turnado </FONT></TD>
							<TD width="25%"><FONT SIZE=1 FACE="Verdana"> <INPUT 
								value="6" id="chkAsistente" name="idRoles" type="checkbox" 
								onclick="seleccionaRol(this);">Asistente </FONT></TD>
							<TD width="25%"><FONT SIZE=1 FACE="Verdana"> <INPUT 
								value="7" id="chkAsistente" name="idRoles" type="checkbox" 
								onclick="seleccionaRol(this);">SubSCP </FONT>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
				</FIELDSET>
				</TD>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="529">&nbsp;</TD>
			</TR>

			<TR VALIGN=top>
				<TD width="218"><FONT SIZE=2 FACE="Verdana">&nbsp;</FONT></TD>
				<TD width="600">
				<FIELDSET dir="ltr" class="bluethinBorder"><LEGEND align="left"><FONT
					SIZE=2 FACE="Verdana" color="#004080"><B>Configuración
				de Correos de Salida</B></FONT></LEGEND>
				<TABLE>
					<TBODY>
						<TR>
							<TD width="172"><FONT SIZE=1 FACE="Verdana"> <INPUT  id="chkMailNuevoAsu"
							disabled="disabled"
								name="idCorreosSalida" type="checkbox" value="0" align="middle">Nuevo
							Asunto </FONT></TD>
							<TD width="172"><FONT SIZE=1 FACE="Verdana"> <INPUT  id="chkMailTurnarIns"
							disabled="disabled"
								name="idCorreosSalida" type="checkbox" value="1" align="middle">Turnar
							Instrucciones </FONT></TD>
							<TD width="173"><FONT SIZE=1 FACE="Verdana"> <INPUT  id="chkMailResponderIns"
							disabled="disabled"
								name="idCorreosSalida" type="checkbox" value="2" align="middle">Responder
							Instrucción </FONT></TD>
						</TR>
						<TR>
							<TD width="172"><FONT SIZE=1 FACE="Verdana"> <INPUT  id="chkMailRechazarIns"
							disabled="disabled"
								name="idCorreosSalida" type="checkbox" value="3" align="middle">Rechazar
							Instrucción </FONT></TD>
							<TD width="172"><FONT SIZE=1 FACE="Verdana"> <INPUT  id="chkMailDelegarIns"
							disabled="disabled"
								name="idCorreosSalida" type="checkbox" value="4" align="middle">Delegar
							Instrucción </FONT></TD>
							<TD width="173"><FONT SIZE=1 FACE="Verdana"> <INPUT  id="chkMailReasignarIns"
							disabled="disabled"
								name="idCorreosSalida" type="checkbox" value="5" align="middle">Reasignar
							Instrucción </FONT></TD>
						</TR>
						<TR>
							<TD width="172"><FONT SIZE=1 FACE="Verdana"> <INPUT id="chkMailHabilitarIns"
							disabled="disabled"
								name="idCorreosSalida" type="checkbox" value="6" align="middle">Habilitar
							Instrucción </FONT></TD>
							<TD width="172"><FONT SIZE=1 FACE="Verdana"> <INPUT  id="chkMailCambioFechaIns"
							disabled="disabled"
								name="idCorreosSalida" type="checkbox" value="7" align="middle">Solicitud
							de cambio de fecha de una Instrucción </FONT></TD>
							<TD width="173"><FONT SIZE=1 FACE="Verdana"> <INPUT id="chkMailResCambioFechaIns"
							disabled="disabled"
								name="idCorreosSalida" type="checkbox" value="8" align="middle">Respuesta
							de cambio de fecha de una Instrucción </FONT></TD>
						</TR>
					</TBODY>
				</TABLE>
				</FIELDSET>
				</TD>
			</TR>

			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="529">&nbsp;</TD>
			</TR>

			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="600">
				<fieldset dir="ltr" class="bluethinBorder"><legend><FONT SIZE=2
					FACE="Verdana" color="#004080"><B>Configuración de
				Correos de Entrada</B></FONT></legend>
				<table width="98%" border="0">
					<tr>
						<td width="46%"><FONT SIZE=1 FACE="Verdana"> <input
							name="corresEntrada" type="checkbox" value="0" align="middle"
							checked="checked">Recibir Notificaciones </FONT></td>
						<td width="54%"><FONT SIZE=1 FACE="Verdana"></FONT></td>
					</tr>
				</table>
				</fieldset>
				</TD>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="529">&nbsp;</TD>
			</TR>
			<TR valign="top">
				<TD width="144">&nbsp;</TD>
				<TD width="600">
				<fieldset dir="ltr" class="bluethinBorder"><legend><FONT SIZE=2
					FACE="Verdana" color="#004080"><B>Configuraci&oacute;n
				de Cat&aacute;logos </B></FONT></legend>
				<table width="98%" border="0">
					<tr>
						<td width="46%"><FONT SIZE=1 FACE="Verdana"> <input
							name="catalogoArchivado" type="checkbox" value="1" align="middle">Cat&aacute;logo
						de Archivado</FONT></td>
						<td width="54%"><FONT SIZE=1 FACE="Verdana"></FONT></td>
					</tr>
				</table>
				</fieldset>
				</TD>
			</TR>
		</logic:notEqual>
	</TABLE>
	<br>
	</DIV>
	<br>
	<BR>
	<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
	</DIV>
</html:form>
</BODY>
</HTML>