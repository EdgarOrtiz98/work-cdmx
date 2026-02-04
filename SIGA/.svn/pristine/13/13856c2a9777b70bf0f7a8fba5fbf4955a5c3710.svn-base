<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<jsp:include page="headerSIGA.jsp" flush="false" />
<%@page import="com.meve.sigma.organizacional.vo.PuestoVO"%>
<HTML>
<HEAD>
<TITLE>Puestos</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,java.util.ArrayList,java.util.*,com.meve.sigma.util.*"%>
<%
			UsuarioBean BUsuario = (UsuarioBean) session
			.getAttribute("UsuarioBean");
	String strTmp = request.getRequestURI();
	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
			.length());
	if (BUsuario == null) {
		try {
			response.sendRedirect("index.jsp?pagina=" + strTmp);
		} catch (java.io.IOException io) {
			;
		}
	}
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="./theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="./css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="./css/link.css" rel="stylesheet" type="text/css">
<LINK href="./css/menu.css" rel="stylesheet" type="text/css">
<jsp:useBean id="area" scope="session"
	class="com.meve.sigma.organizacional.vo.AreaVO"
	type="com.meve.sigma.organizacional.vo.AreaVO"></jsp:useBean>
<jsp:useBean id="puestoForm" scope="session"
	class="com.meve.sigma.organizacional.puesto.PuestoForm"
	type="com.meve.sigma.organizacional.puesto.PuestoForm"></jsp:useBean>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY>
<html:form action="puesto">
	<input type="hidden" value="" name="accion" />
	<input type="hidden" value="" name="idLink" />
	<DIV align="center">
	<TABLE cellspacing="0" cellpadding="0" border="0" width="70%">
		<TBODY>
			<TR valign="top">
				<TD width="500"><A onclick="submitForm(puestoForm,'regresar','')"> <IMG
					border="0" src="./Imagenes/NavLeft.gif" title="Regresar"></A> 
					<%if (BUsuario.getAdmon() || BUsuario.getSupervisor()) {%> 
                   <A href="javascript:;" target="_self"> 
                      <IMG border="0" src="./Imagenes/nuevo1.gif" title="Nuevo Puesto"/>
				   <A href="javascript:;"target="_self" onclick="submitForm(puestoForm,'modificarPuesto','mostrar');return false;"> 
				      <IMG border="0" src="./Imagenes/Edit2.gif" title="Editar Puesto">
				   </A> 
				   <A onclick="borrarUsuario();" target="_self"> 
					   <IMG border="0" src="./Imagenes/borrar1.gif" title="Borrar Puesto"/>
				   </A> <%
 }
 %>
				</TD>
				<TD width="3"></TD>
				<TD width="200" align="right" valign="middle"><a
					href="Bitacora.jsp?id_usuario=<%=""%>&retURI=<%=Utilerias.codificaPostHTML(strTmp+"?id="+""+"&area="+""+"&retURI="+ Utilerias.codificaPostHTML(""))%>">
				<u><FONT SIZE=2 FACE="Verdana">Bitácora del Usuario</FONT></u> </a></TD>
			</TR>
		</TBODY>
	</TABLE>
	</DIV>
	<BR>
	<DIV align="center">
	<TABLE border="0" width="70%">
		<tr bgcolor="#004080">
			<TD align="left" width="696" class="etiquetasTit"><B>Puesto</B>
			</TD>
		</tr>
		<tr>
			<TD align="left" width="696" class="etiquetas">
			${puestoForm.puesto}</TD>
		</tr>
		<tr bgcolor="#004080">
			<TD align="left" width="696" class="etiquetasTit"><B>Responsable</B>
			</TD>
		</tr>
		<tr>
			<TD align="left" width="696" class="etiquetas">
			${puestoForm.responsable}</TD>
		</tr>
		<tr bgcolor="#004080">
			<TD align="left" width="696" class="etiquetasTit"><B>Roles
			del Usuario</B></TD>
		</tr>
		<tr>
			<TD align="left" width="696" class="etiquetas">
			<UL>
				<logic:iterate id="registro" name="puestoForm" property="roles"
					type="com.meve.sigma.catalogos.CatalogoRol">
                 ${registro.nombre}
				</logic:iterate>
			</UL>
			</TD>
		</tr>
		<tr bgcolor="#004080">
			<TD align="left" width="696" class="etiquetasTit"><B>Unidad
			Administrativa</B></TD>
		</tr>
		<tr>
			<TD align="left" width="696" class="etiquetas">
			${puestoForm.unidadAdministrativa}</TD>
		</tr>
		<tr bgcolor="#004080">
			<TD align="left" width="696" class="etiquetasTit"><B>Cadena
			de Mando</B></TD>
		</tr>
		<tr align="left">
			<TD align="left" width="696" class="etiquetas">
			<%=Converters.convertElementToString(area.getCadenaMando(puestoForm.getIdPuesto()).getHTML(null))%>
			</TD>
		<tr>
		<tr bgcolor="#004080">
			<TD align="left" width="696" class="etiquetasTit"><B>Subalternos</B>
			</TD>
		</tr>
		<tr>
			<TD align="left" width="696" class="etiquetas">
			<logic:iterate
				id="subordinado" name="puestoForm" property="subordinados"
				type="com.meve.sigma.organizacional.vo.PuestoVO">
         	<%=Converters.convertElementToString(subordinado.getHTML(null))%>
			</logic:iterate> 
			<logic:empty name="puestoForm" property="subordinados">
			   **No tiene Subalternos asignados**
			</logic:empty>
			</TD>
		</tr>
		<tr bgcolor="#004080">
			<TD align="left" width="696" class="etiquetasTit"><B>Asistente</B>
			</TD>
		</tr>
		<tr>
			<td align="left" width="696" class="etiquetas">
			<DL><DT>
				<logic:iterate id="asistente" name="puestoForm"
					property="asistentes"
					type="com.meve.sigma.organizacional.vo.AsistenteVO">
						<%=Converters.convertElementToString(asistente.getHTML(null))%>
				</logic:iterate>
				<logic:empty name="puestoForm"property="asistentes" >
				**No tiene Asistentes asignados**
				</logic:empty>
			</DT></DL>
			</td>

		</tr>
		<tr bgcolor="#004080">
			<TD align="left" width="696" class="etiquetasTit"><B>Compañeros
			de la Unidad</B></TD>
		</tr>
		<tr>
			<TD align="left" width="696" class="etiquetas">
			<DL><DT>
				<logic:iterate id="companiero" name="puestoForm"
					property="companieros"
					type="com.meve.sigma.organizacional.vo.PuestoVO">
					<%=Converters.convertElementToString(companiero.getHTML(null))%>
				</logic:iterate>
			</DT></DL>
			</TD>
		</tr>
	</TABLE>
	</DIV>
</html:form>
</BODY>
</HTML>
