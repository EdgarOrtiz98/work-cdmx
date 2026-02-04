
<%
			UsuarioBean BUsuario = (UsuarioBean) session
			.getAttribute("UsuarioBean");
	if (BUsuario == null) {
		try {
			response.sendRedirect("./jsp/index.jsp");
			return;
		} catch (Exception io) {
			System.out.println("ERROR:" + io.getMessage());
		}
	}
%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@taglib uri="c" prefix="c"%>
<%@ taglib prefix="xg" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="com.meve.sigma.asunto.AsuntoForm"%>
<HTML>
<HEAD>
<TITLE>Nuevo Asunto</TITLE>
<%@ page import="com.meve.sigma.taglib.*,com.meve.sigma.actualiza.*"%>
<%@ page
	import="com.meve.sigma.beans.*,com.meve.sigma.util.*,java.util.*,com.meve.sigma.beans.search.*"%>

<LINK href="./theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="./css/menu.css" rel="stylesheet" type="text/css">
<LINK href="./css/calendar.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="./css/link.css" />
<script type="text/javascript" src="./js/menu.js"></script>
<script type="text/javascript" src="./js/valida.js"></script>
<script type="text/javascript" src="./js/SigaJS.js"></script>
<script type="text/javascript" src="./js/ventana/ventanas.js"></script>
<script type="text/javascript" src="./js/link.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<jsp:include page="headerSIGA.jsp" flush="false" />
<BODY background="./Imagenes/fondo_claro.jpg"">
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", 0);
%>
<html:form action="captura.siga">
	<INPUT type="hidden" value="" name="accion">
	<INPUT type="hidden" value="" name="idLink">
	<TABLE cellspacing="0" cellpadding="0" width="99%" border="0">
		<TBODY>
			<TR valign="top">
				<TD width="99%" colspan="2">
				<DIV align="right"></DIV>
				</TD>
				<TD width="1%">&nbsp;</TD>
			</TR>
		</TBODY>
	</TABLE>
	<BR />
	<DIV align="center">
	<table border="0" cellspacing="0" cellpadding="0">
		<tr valign="top">
			<td width="863"><logic:equal name="asuntoForm"
				property="estatus"
				value="<%=String.valueOf(Estatus.ASU_EN_RECEPCION)%>">
				<div align="right"><b><font size="4" color="#00204F"
					face="Verdana">Asunto En Recepci&oacute;n</font></b></div>
			</logic:equal> <logic:equal name="asuntoForm" property="estatus"
				value="<%=String.valueOf(Estatus.ASU_POR_TURNAR)%>">
				<div align="right"><b><font size="4" color="#00204F"
					face="Verdana">Asunto Por Turnar</font></b></div>
			</logic:equal> <logic:equal name="asuntoForm" property="estatus"
				value="<%=String.valueOf(Estatus.ASU_TURNADO)%>">
				<div align="right"><b><font size="4" color="#00204F"
					face="Verdana">Asunto En Tr&aacute;mite</font></b></div>
			</logic:equal> <logic:equal name="asuntoForm" property="estatus"
				value="<%=String.valueOf(Estatus.ASU_TERMINADO)%>">
				<div align="right"><b><font size="4" color="#00204F"
					face="Verdana">Asunto Terminado</font></b></div>
			</logic:equal></td>
		</tr>
	</table>
	</DIV>
	<BR />
	<jsp:include page="./menuOperacionAsunto.jsp" />
	<DIV align="center">
	<TABLE>
		<TBODY>
			<TR>
				<TD width="863" align="center"><FONT face="Arial" color="red"
					size="4"></FONT></TD>
			</TR>
		</TBODY>
	</TABLE>
	</DIV>
	<BR>
	<DIV align="center">
	<TABLE cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<tr valign="top">
				<td width="183"><b><font size="2" color="#004080"
					face="Arial">Datos Generales</font></b></td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="380">
				<DIV align="right"><FONT face="Arial" color="#00204f" size="2">**Los
				datos marcados con negritas son obligatorios</FONT></DIV>
				</td>
			</tr>
			<tr valign="top">
				<td width="847" bgcolor="#004080" colspan="4"><img
					src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
			</tr>
		</TBODY>
	</TABLE>
	</DIV>
	<DIV align="center">
	<TABLE cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<TR valign="top">
				<td width="183"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<TD width="380">
				<DIV align="right"><FONT face="Verdana" size="2">Creado
				por: <I><%=BUsuario.getCargo()%> - <%=new java.util.Date()%></I></FONT>
				</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	</DIV>
	<%--Datos del Remitente--%>
	<br>
	<DIV align="center">
	<TABLE cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<tr valign="top">
				<td width="183"><b><font size="2" color="#004080"
					face="Arial">Datos del Remitente</font></b></td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="363"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
			<tr valign="top">
				<td bgcolor="#004080" colspan="4"><img
					src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
			</tr>
		</TBODY>
	</TABLE>
	</DIV>

	<DIV align="center">
	<TABLE cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="360"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
			<TR valign="top">
				<TD width="183"><B><FONT face="Arial" color="#004080"
					size="2">&Aacute;rea Generadora:</FONT></B> <INPUT name="botEntidad"
					type="button"
					onclick="cargaVentana('ventana','directorio.siga?accion=directorio&idLink=cargaInternos');return false; "
					class="s-dropdown-btn"></TD>

				<TD colspan="3">
				   <logic:equal value="-1" property="idEntidad" name="asuntoForm">
					   <FONT face="Arial" size="2"> 
					   <input type="text" size="80"  class="blue600a"  readonly="readonly" value="${asuntoForm.area}"> 
					   </FONT>
				    </logic:equal> 
				   <logic:notEqual value="-1" property="idEntidad" name="asuntoForm">
					   <FONT face="Arial" size="2"> 
					       <input type="text" size="80"  class="blue600a"  readonly="readonly" value="${asuntoForm.entidad}"> 
				   </logic:notEqual>
				</TD>
			</TR>

			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="360"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>

			<TR valign="top">
				<TD width="183"><B><FONT face="Arial" color="#004080"
					size="2">De:</FONT></B> <INPUT name="botDe" type="button"
					onclick="cargaVentana('ventana','remitente.siga?accion=remitentes&idLink=cargaRemitentes&idArea=${asuntoForm.idArea}&idEntidad=${asuntoForm.idEntidad}');return false; "
					class="s-dropdown-btn"></TD>
				<TD colspan="3"><FONT face="Arial" size="2"> 
				
				<input type="text" class="blue600a" size="80" readonly="readonly" value="${asuntoForm.remitenteNombre}${asuntoForm.puesto}"/> </FONT></TD>
			</TR>

			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="360"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>

			<TR valign="top">
				<TD width="183"><FONT face="Arial" color="#004080" size="2">Firmante:</FONT>
				</TD>
				<TD colspan="3"><html:text property="firmanteNombre" styleClass="blue600a" size="80" value="${asuntoForm.remitenteNombre}"/></TD>
			</TR>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="360"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
			<TR valign="top">
				<TD width="183"><FONT face="Arial" color="#004080" size="2"><B>Documento
				de:</B></FONT></TD>
				<TD colspan="3"><font size="2" color="#004080" face="Arial">
				${asuntoForm.tipoAsunto}
				 </font></TD>
			</TR>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="360"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
		</TBODY>
	</TABLE>
	</DIV>
	<br>
	<DIV align="center">
	<TABLE cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<tr valign="top">
				<td width="183"><b><font size="2" color="#004080"
					face="Arial">Datos de Ventanilla</font></b></td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="363"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
			<tr valign="top">
				<td bgcolor="#004080" colspan="4"><img
					src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
			</tr>
		</TBODY>
	</TABLE>
	</DIV>
	<br>
	<DIV align="center">
	<TABLE cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="364"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
			<TR valign="top">
				<TD width="183"><B><FONT face="Arial" color="#004080"
					size="2">Responsable del<BR>
				Turno:</FONT></B> <INPUT name="botVentanilla" type="button"
					onclick="AbrirV('FrameVentanilla.jsp?idArea=&ida=&num=1');"
					class="s-dropdown-btn"></TD>
				<TD colspan="3"><html:text property="destinatarioNombre" /></TD>
			</TR>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="360"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
		</TBODY>
	</TABLE>
	</DIV>
	<br>
	<DIV align="center">
	<TABLE cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<tr valign="top">
				<td width="183"><b><font size="2" color="#004080"
					face="Arial">Destinatarios</font></b></td>
				<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="363"><img src="./Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
			<tr valign="top">
				<td bgcolor="#004080" colspan="4"><img
					src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
			</tr>
		</TBODY>
	</TABLE>
	</DIV>
	<br>
	<DIV align="center">
	<TABLE cellspacing="0" cellpadding="0" border="0">
		<TBODY>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
			<TR valign="top">
				<TD width="183"><B><FONT face="Arial" color="#004080"
					size="2">Destinatarios Internos<BR>
				de la SHCP :</FONT></B> <INPUT type="button"
					onclick="document.Asunto.strBandera.value=true;Abrir('', '', '', '' );"
					class="s-dropdown-btn"></TD>
				<TD colspan="3"></TD>
			</TR>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>

			<TR valign="top">
				<TD width="183"><B><FONT face="Arial" color="#004080"
					size="2">Para:</FONT></B></TD>
				<TD colspan="3"><FONT face="Arial" size="2"> <SELECT
					name="listTO" size="6" class="blue600a" multiple="multiple">

				</SELECT> </FONT></TD>
			</TR>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
			<TR valign="top">
				<TD width="183"><FONT face="Arial" color="#004080" size="2">Ccp:</FONT>
				</TD>
				<TD colspan="3"><FONT face="Arial" size="2"> <SELECT
					name="listCC" size="6" class="blue600a" multiple="multiple">
				</SELECT> </FONT></TD>
			</TR>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>

			<TR valign="top">
				<TD width="183"><FONT face="Arial" color="#004080" size="2">Destinatarios
				Externos:</FONT> <INPUT type="button"
					onclick="document.Asunto.strBandera.value=true;AbrirDest('');"
					class="s-dropdown-btn"></TD>
				<TD colspan="3"></TD>
			</TR>
			<tr valign="top">
				<td width="183"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="360"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>

			<TR valign="top">
				<TD width="183"><FONT face="Arial" color="#004080" size="2">Para:</FONT>
				</TD>
				<TD colspan="3"><FONT face="Arial" size="2"> <SELECT
					name="listTOE" size="6" class="blue600a" multiple="multiple">
				</SELECT> </FONT></TD>
			</TR>
			<tr valign="top">
				<td width="183">&nbsp;</td>
				<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="364"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
		</TBODY>
	</TABLE>
	</DIV>
	<br>
	<xg:ventana id="ventana" url="jsp/cargando.jsp" titulo="Areas" width="800" height="450"
		top="30px" left="370px" />
</html:form>
</BODY>
</HTML>
