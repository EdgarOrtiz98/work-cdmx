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
<jsp:useBean id="reporteForm" type="com.meve.sigma.reporte.ReporteForm"
	class="com.meve.sigma.reporte.ReporteForm" scope="session" />
<HTML>

<BODY background="./Imagenes/fondo_claro.jpg">


<table align="center" width="900">
	<tr>
		<td>
		<h2>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <font
			color="#2121ff" face="Arial"> <strong><em>Reporte
		 Asunto</em></strong> </font></h2>
		</td>
	</tr>
	<tr>
		<td align="left"><a
			onclick="submitForm(document.reporteForm,'buscaAsuntos','');"> <img
			src="Imagenes/buscarCat.gif" title="Genera Reporte"></a> 
			<%if(tableManager!=null&& tableManager.getTotalRegistros()!= 0){ %>
		<a href="GeneraReporte"><img src="Imagenes/ic_excel.gif"
			border="0" title="Genera Reporte"></a> <%}%>
		</td>
	</tr>
	<tr>
		<td>
		<TABLE border="0" width="100%" align="center">
			<tr>
				<td>
				<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
					<TBODY>
						<tr valign="top">
							<td ><b><font size="2" color="#004080"
								face="Arial">Rango de Fechas</font></b></td>
						</tr>
						<tr valign="top">
							<td width="100%" bgcolor="#004080" colspan="4"><img
								src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
						</tr>
					</TBODY>
				</TABLE>
				</td>
			</tr>
			<tr>
				<td>&nbsp;
				<TABLE width="100%" border="0">
					<tr>
						<td width="40px">&nbsp;</td>
						<td>Del</td>
						<td>
						<INPUT class="blue100a"  name="fechaInicial" value="" maxlength="10" onblur="validaFormatoFecha(forms[0].fechaInicial,forms[0].fechaFinal);" onKeyUp="validaRangoFechas(forms[0].fechaInicial,forms[0].fechaFinal,'verifique');return false;" onKeyPress="AceptaSoloTeclaNumericaYDiagonal();" />
						<A><IMG height="20px"
							src="Imagenes/act_calFormat.gif" width="20px" 
							onclick='show_calendar("forms[0].fechaInicial");' /></A></td>
						<td width="50px" align="center">al</td>
						<td width="300px">
						<INPUT class="blue100a"  name="fechaFinal" value="" maxlength="10" onblur="validaFormatoFecha(forms[0].fechaInicial,forms[0].fechaFinal);" onKeyUp="validaRangoFechas(forms[0].fechaInicial,forms[0].fechaFinal,'verifique');return false;" onKeyPress="AceptaSoloTeclaNumericaYDiagonal();" />
						<a><IMG height="20px"
							src="Imagenes/act_calFormat.gif" width="20px" 
							onclick='show_calendar("forms[0].fechaFinal");'></a></td>
						<td width="50px">Filtrado por:</td>
						<td width="200px"><html:select size="1" 
							property="tipoFecha" styleClass="blue250" >
							<option value="1" <%=reporteForm.getComboSelected(1)%>>Fecha de Captura</option>
							<option value="2" <%=reporteForm.getComboSelected(2)%>>Fecha de Recepcion</option>
							<option value="3" <%=reporteForm.getComboSelected(3)%>>Fecha del Documento</option>
						</html:select></td>
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
				<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
					<tr valign="top">
						<td width="100%"><b><font size="2" color="#004080"
							face="Arial">Estatus de Mis Asuntos y Asuntos de la Ventanilla</font></b></td>
					</tr>
					<tr valign="top" >
						<td width="100%" bgcolor="#004080" colspan="4"><img
							src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
					</tr>
				</TABLE>
				</td>
			</tr>
			<tr>
				<td>&nbsp;
				<TABLE width="90%" align="center">
					<tr>
						<td width="25%"><input type="checkbox" name="estatus" 
							value="<%=String.valueOf(Estatus.ASU_EN_RECEPCION)%>" 
							<%=reporteForm.getEstatusChecks(Estatus.ASU_EN_RECEPCION)%>/>Recepci&oacute;n
						</td>
						<td width="25%">&nbsp;&nbsp;<input type="checkbox" name="estatus"
							value="<%=String.valueOf(Estatus.ASU_POR_TURNAR)%>" 
							<%=reporteForm.getEstatusChecks(Estatus.ASU_POR_TURNAR)%>/>Por Turnar</td>
						<td width="25%">&nbsp;&nbsp;<input type="checkbox" name="estatus"
							value="<%=String.valueOf(Estatus.ASU_TURNADO)%>" 
							<%=reporteForm.getEstatusChecks(Estatus.ASU_TURNADO)%>/>En Tr&aacute;mite</td>
						<td width="25%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="checkbox" name="estatus" 
							value="<%=String.valueOf(Estatus.ASU_TERMINADO)%>" 
							<%=reporteForm.getEstatusChecks(Estatus.ASU_TERMINADO)%>/>Terminado</td>
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
				<td>
				<TABLE cellspacing="0" cellpadding="0" width="100%">
					<TBODY>
						<tr valign="top">
							<td><b><font size="2" color="#004080"
								face="Arial">Estatus de Otras Ventanillas</font></b> <input type="checkbox"
								name="otrasVentanillas" 
								onclick="muestraOcultaDIV('estatusOV');" 
								<%=reporteForm.getOtrasVentanillasCheck()%>
								/></td>
						</tr>
						<tr valign="top">
							<td width="100%" bgcolor="#004080" colspan="5"><img
								src="./Imagenes/shim.gif" width="1" height="2" title=""></td>
						</tr>
					</TBODY>
				</TABLE>
				</td>
			</tr>
			<tr>
				<td>&nbsp;
				<%if(reporteForm.isOtrasVentanillas()){%>
				<div style="display: block;" id="estatusOV">
				<%}else{%>
				<div style="display: none;" id="estatusOV">
				<%} %>
				<TABLE width="90%" align="center">
					<tr>
					    <td width="25%">&nbsp;</td>
						<td width="25%"><input type="checkbox" name="estatusOtrasVentanillas"
							value="<%=String.valueOf(Estatus.OV_POR_TURNAR)%>" 
							<%=reporteForm.getEstatusOVChecks(Estatus.OV_POR_TURNAR) %>/>Por Turnar</td>
						<td width="25%">&nbsp;&nbsp;<input type="checkbox"
							name="estatusOtrasVentanillas" 
							value="<%=String.valueOf(Estatus.OV_TURNADA)%>"
							<%=reporteForm.getEstatusOVChecks(Estatus.OV_TURNADA) %>/>En Tr&aacute;mite</td>
						<td width="25%">&nbsp;&nbsp;<input type="checkbox"
							name="estatusOtrasVentanillas"
							value="<%=String.valueOf(Estatus.OV_TERMINADA)%>" 
							<%=reporteForm.getEstatusOVChecks(Estatus.OV_TERMINADA) %>/>Terminado</td>
					</tr>
				</table>
				</div>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<TABLE border="0" width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<TABLE cellspacing="0" cellpadding="0" border="0" width="100%">
					<TBODY>
						<tr valign="top">
							<td><b><font size="2" color="#004080"
								face="Arial">Tipo de Reporte</font></b></td>
						</tr>
						<tr valign="top">
							<td width="100%" bgcolor="#004080" colspan="4"><img
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
	<jsp:include page="tablaAsuntosTotales.jsp" flush="false" />
</logic:equal>
<logic:equal value="false" parameter="totales">
	<jsp:include page="tablaAsuntos.jsp" flush="false" />
</logic:equal>
</BODY>
</HTML>