<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="com.meve.sigma.util.Estatus"%>

<%@page import="java.util.Date"%>
<%@page import="com.meve.util.DateFormatter"%>
<%@page import="com.meve.sigma.graficas.Graficas"%>
<jsp:useBean id="tableManager" type="com.meve.util.ManejadorDeTablas"
	class="com.meve.util.ManejadorDeTablas" scope="session" />
<jsp:useBean id="UsuarioBean" scope="session"
	type="com.meve.sigma.beans.UsuarioBean"
	class="com.meve.sigma.beans.UsuarioBean" />
<jsp:useBean id="reporteForm" type="com.meve.sigma.reporte.ReporteForm"
	class="com.meve.sigma.reporte.ReporteForm" scope="session" />
<%@page import="com.meve.sigma.reporte.ReporteUtil"%>
<HTML>

<BODY background="./Imagenes/fondo_claro.jpg" onload="verificarCheck(<%=reporteForm.getSubordinadosToString()%>,'subordinados');return false;">


<table align="center" width="900">
	<tr>
		<td>
		<h2>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <font
			color="#2121ff" face="Arial"> <strong><em>Reporte
		Instrucci&oacute;n</em></strong> </font></h2>
		</td>
	</tr>
	<tr>
		<td align="left"><a
			onclick="submitForm(document.reporteForm,'buscaInstrucciones','');">
		<img src="Imagenes/buscarCat.gif" title="Genera Reporte"></a> <%
 if (tableManager != null && tableManager.getTotalRegistros() != 0) {
 %>
		<a href="GeneraReporte"> <img src="Imagenes/ic_excel.gif"
			border="0" title="Genera Reporte"> </a> <%
 }
 %>
		</td>
	</tr>
	<tr>
		<td>
		<TABLE border="0" width="100%" align="center">
			<tr>
				<td>
				<TABLE cellspacing="0" cellpadding="0" border="0">
					<TBODY>
						<tr valign="top">
							<td width="183"><b><font size="2" color="#004080"
								face="Arial">Rango de Fechas</font></b></td>
							<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
								height="1" width="1" title=""></td>
							<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
								height="1" width="1" title=""></td>
							<td width="380"></td>
						</tr>
						<tr valign="top">
							<td width="847" bgcolor="#004080" colspan="4"><img
								src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
						</tr>
					</TBODY>
				</TABLE>
				</td>
			</tr>
			<tr>
				<td>&nbsp;
				<TABLE width="70%" border="0">
					<tr>
						<td width="40">&nbsp;</td>
						<td>Del</td>
						<td>
						<INPUT class="blue100a"  name="fechaInicial" value="" maxlength="10" onblur="validaFormatoFecha();keyTra()" onKeyUp="validaRangoFechas(forms[0].fechaInicial,forms[0].fechaFinal,'verifique');return false;" onKeyPress="AceptaSoloTeclaNumericaYDiagonal();" />
						<A><IMG height="20px"
							src="Imagenes/act_calFormat.gif" width="20px" 
							onclick='show_calendar("forms[0].fechaInicial");' /></A></td>
						<td width="50px" align="center">al</td>
						<td width="300px">
						<INPUT class="blue100a"  name="fechaFinal" value="" maxlength="10" onblur="validaFormatoFecha();keyTra()" onKeyUp="validaRangoFechas(forms[0].fechaInicial,forms[0].fechaFinal,'verifique');return false;" onKeyPress="AceptaSoloTeclaNumericaYDiagonal();" />
						<a><IMG height="20px"
							src="Imagenes/act_calFormat.gif" width="20px" 
							onclick='show_calendar("forms[0].fechaFinal");'></a></td>

					</tr>

				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<TABLE border="0" width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td>&nbsp;
				<TABLE cellspacing="0" cellpadding="0" border="0">
					<tr valign="top">
						<td width="183"><b><font size="2" color="#004080"
							face="Arial">Estatus</font></b></td>
						<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
							height="1" width="1" title=""></td>
						<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
							height="1" width="1" title=""></td>
						<td width="380"></td>
					</tr>
					<tr valign="top">
						<td width="847" bgcolor="#004080" colspan="4"><img
							src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
					</tr>
				</TABLE>
				</td>
			</tr>
			<tr>
				<td>&nbsp;
				<TABLE width="90%" align="center">
					<tr>
						<td><input type="checkbox" name="estatus" 
							value="<%=String.valueOf(Estatus.INS_POR_ATENDER)%>"
							<%=reporteForm.getEstatusChecks(Estatus.INS_POR_ATENDER)%> />Por
						Atender</td>
						<td>&nbsp;&nbsp;<input type="checkbox" name="estatus"
							value="<%=String.valueOf(Estatus.INS_EN_TRAMITE)%>"
							<%=reporteForm.getEstatusChecks(Estatus.INS_EN_TRAMITE)%> />En
						tr&aacute;mite</td>
						<td>&nbsp;&nbsp;<input type="checkbox" name="estatus"
							value="<%=String.valueOf(Estatus.INS_TERMINADA)%>"
							<%=reporteForm.getEstatusChecks(Estatus.INS_TERMINADA)%> />Terminada</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="checkbox" name="estatus"
							value="<%=String.valueOf(Estatus.INS_RECHAZADA)%>"
							<%=reporteForm.getEstatusChecks(Estatus.INS_RECHAZADA)%> />Rechazadas</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<DIV >
		<TABLE border="0" width="100%" cellpadding="0" cellspacing="0" >
			<tr>
				<td>
				<TABLE cellspacing="0" cellpadding="0">
					<TBODY>
						<tr valign="top">
							<td width="183"><b><font size="2" color="#004080"
								face="Arial">Subordinados</font></b> <input type="checkbox"
								name="muestraSubordinados"
								onclick="muestraOcultaDIV('subordinados');"
								<%=reporteForm.getSubordinadosCheck()%> /></td>
							<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
								height="1" width="1" title=""></td>
							<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
								height="1" width="1" title=""></td>
							<td width="380"></td>
						</tr>
						<tr valign="top">
							<td width="847" bgcolor="#004080" colspan="5"><img
								src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
						</tr>
					</TBODY>
				</TABLE>
				</td>
			</tr>
			<tr>
				<td>&nbsp; 
				<%if (reporteForm.isMuestraSubordinados()) {%>
				<div style="display: block" id="subordinados">
				<%} else {%>
				<div style="display: none" id="subordinados">
				<%}%> 
				<%=ReporteUtil.getSubordinadosHTML(request,Integer
									.parseInt(UsuarioBean.getIdUsuario()),
									reporteForm)%>
				</div>
				</td>
			</tr>
		</table>
		</DIV>
		</td>
	</tr>
	<tr>
		<td>
		<TABLE border="0" width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<TABLE cellspacing="0" cellpadding="0" border="0">
					<TBODY>
						<tr valign="top">
							<td width="183"><b><font size="2" color="#004080"
								face="Arial">Tipo de Reporte</font></b></td>
							<td width="233"><img src="./Imagenes/ecblank.gif" border="0"
								height="1" width="1" title=""></td>
							<td width="67"><img src="./Imagenes/ecblank.gif" border="0"
								height="1" width="1" title=""></td>
							<td width="380"></td>
						</tr>
						<tr valign="top">
							<td width="847" bgcolor="#004080" colspan="4"><img
								src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
						</tr>
					</TBODY>
				</TABLE>
				</td>
			</tr>
			<tr>
				<td>&nbsp;
				<TABLE width="200" border="0">
					<tr>
						<td width="40">&nbsp;</td>
						<td><html:radio property="totales" value="false" />Detalle</td>
						<td><html:radio property="totales" value="true" />Totales</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>

</table>
<logic:equal value="true" parameter="totales">
	<jsp:include page="tablaInstruccionesTotales.jsp" flush="false" />
</logic:equal>
<logic:equal value="false" parameter="totales">
	<jsp:include page="tablaInstrucciones.jsp" flush="false" />
</logic:equal>
</BODY>
</HTML>