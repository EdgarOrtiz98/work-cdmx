<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.util.*,java.util.*,com.meve.sigma.reportes.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null)
	try{
		response.sendRedirect("index.jsp?pagina="+ strTmp);
	}catch(java.io.IOException io){;}
	String strIdAreaUsuario = BUsuario.getIdArea();
	String strIdArea = BUsuario.getIdArea();
	String strAccion = request.getParameter("accion");

	java.text.SimpleDateFormat sdf	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	String strFechaActual			=	sdf.format(f);

	String strDoctosDetenidos[][] 	= 	null;
	String strDiasVenAsuntos[][]	=	null;
	String strDoctosEnTramite[][]	=	null;

	if(strAccion != null && strAccion.equals("guardar")){
		strIdArea = request.getParameter("id_area");
		try{
			response.sendRedirect("ViewDoctosDetenidos.jsp?id_area="+strIdArea);
		}catch(java.io.IOException io){;}
	}
	if(strIdArea != null && strIdArea.length() > 0){
		strDoctosDetenidos 	= 	ActualizaAsunto.getAsuntosPorTurnarRetrasados(strIdArea);
		strDiasVenAsuntos	=	ActualizaConfiguracion.getDatosConf();
		strDoctosEnTramite	=	ActualizaAsunto.getAsuntosEnTramiteRetrasados(strIdArea);
	}
	
%>
<% if (	BUsuario.getRecepcion() && 
		!(BUsuario.getAdmon() || BUsuario.getSupervisor() || BUsuario.getAtencion() || BUsuario.getTurnado() || BUsuario.getAsistente())){ %>
	<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Asuntos por Turnar Atrasados</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
	function guardar() {
		doc = document.viewDetenidos;
		valida = 0;
		msg="";
		doc.accion.value="guardar";
		doc.submit();
	}
</SCRIPT>
</HEAD>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="ViewDoctosDetenidos.jsp" name="viewDetenidos" method="post">
<INPUT type="hidden" value="guardar" name="accion">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<br>
<DIV align="center">
<table border="0" width="1000" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="25%"><a
			href="portalPrincipal.jsp"> <img src="../Imagenes/NavLeft.gif" border="0" title="Regresar"> </a> </td>
		<td width="25%">
			<!-- <A onclick="guardar()">
			<IMG src="../Imagenes/bot_nue_tem.gif" width="108" height="29">
			</A> -->
		</td>
		<td width="25%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="25%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</table>
</DIV>
<br>
<!-- 
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="546"><b><font size="2" color="#002060" face="Arial">Condiciones
		para Generar Reporte</font></b>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr valign="top">
				<td width="100%" bgcolor="#002060"><img src="../Imagenes/shim.gif"
					width="1" height="1" title=""></td>
			</tr>
		</table>
		<br>
		</td>
	</tr>
	<tr valign="top">
		<td width="546">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr valign="top">
				<td width="23"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
				<td width="498"><font size="2" face="Arial">Proporcione la
				informacion solicitada y posteriormente de clic en el botón
				&quot;Generar Reporte&quot;. Para salir de clic en el botón
				&quot;Cancelar&quot;.</font></td>
				<td width="24"><img src="../Imagenes/ecblank.gif" border="0"
					height="1" width="1" title=""></td>
			</tr>
		</table>
		<hr>
		<br>
		</td>
	</tr>
	<tr valign="top">
		<td width="546">
		<center>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr valign="top">
				<td width="117">
				<div align="left"><b><FONT face="Arial" color="#004080" size="2">Seleccione Unidad:</font></b>
				</div>
				</td>
				<td width="380">
					<FONT SIZE=2 FACE="Verdana">
					<%--
					<%
						String strAreas[][] = null;
						strAreas = ActualizaArea.getAreasCiudadano();
					%>--%>
					<SELECT name="id_area" class="blue200" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()">
						<OPTION value="<%=BUsuario.getIdArea()%>"><%=ActualizaArea.NombreArea(BUsuario.getIdArea())%></OPTION>
					<%--
					<%if(BUsuario.getSupervisor()){%>
							<OPTION value="-1">--TODAS--</OPTION>
							<% for(int i=0;i<strAreas.length;i++){ %>
							<OPTION value="<%=strAreas[i][0]%>"><%=strAreas[i][1]%></OPTION>
							<%}%>
						<%}else{%>
							<% for(int i=0;i<strAreas.length;i++){ %>
							<%if(BUsuario.getIdArea().equals(strAreas[i][0])){%>
							<OPTION value="<%=strAreas[i][0]%>" <%=(strIdAreaUsuario.trim().equals(strAreas[i][0])?"selected":"")%>><%=strAreas[i][1]%></OPTION>							
							<%}}%>
						<%}%>--%>
					</SELECT>
					</FONT>
				</td>
			</tr>
		</table>
		</center>
		<br>
		<hr>
		<br>
		</td>
	</tr>
</table>
</DIV>
 -->
<%if(strIdArea!= null && strIdArea.length() > 0){%>
<DIV align="center">
<table border="0" cellspacing="1" cellpadding="1">
<TBODY>
	<tr valign="top">
		<td bgcolor="#002060" width="1000">		
			<table border="0" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<td width="968">
						<b><font size="2" color="#FFFFFF" face="Arial"><%=strDoctosDetenidos[0][1]%><BR>Asuntos por Turnar Atrasados</font></b>
					</td>
					<td width="32">
						<div align="right">
							<i><font size="2" color="#FFFFFF" face="Arial"></font></i>
						</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<TR>
		<TD bgcolor="#002060" width="1000">
			<table border="1" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<TD bgcolor="#002060" align="center" width="165">
						<b><font size="2" color="#FFFFFF" face="Arial">Folio</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="303">
						<b><font size="2" color="#FFFFFF" face="Arial">Asunto</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="223">
						<b><font size="2" color="#FFFFFF" face="Arial">Responsable</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="69">
						<b><font size="2" color="#FFFFFF" face="Arial">Días de <br>Atraso</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="236">
						<b><font size="2" color="#FFFFFF" face="Arial">Estatus</font></b>
					</TD>
				</tr>
			</table>
		</TD>
	</TR>
	<TR>
		<TD width="1000"> 
			<table border="1" cellspacing="0" cellpadding="0">
				<%if(strDoctosDetenidos != null && strDoctosDetenidos.length> 0){%>
				<TR>
					<TD align="center">
						<A onclick="window.open('../ReporteBeanExcel?tip=AnalisisPorAtrasadosExcel');" title="Exportar a Excel">
						<img src="../Imagenes/ic_excel.gif" border="0"></A>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<A onclick="window.open('../ReporteBeanPDF?tip=AnalisisPorAtrasados');" title="Exportar a PDF">
						<img src="../Imagenes/ic_pdf.gif" border="0"></A>
					</TD>
				</TR>

				<%ArrayList al = new ArrayList(); %>
				<%for(int i=0;i<strDoctosDetenidos.length;i++){%>
				<%
					Calendar cFechaCap = Utilerias.StringCalendar(strDoctosDetenidos[i][5]);
					String strFecha = Utilerias.getFechaTerminacionInst((Calendar)cFechaCap.clone(), String.valueOf(strDiasVenAsuntos[0][1]));
					Calendar cFechaEst = Utilerias.StringCalendar2(strFecha);
					int iSinDiasFest = Utilerias.getSinDiasFestivos(cFechaCap, cFechaEst);
					String strFechaEst = Utilerias.getFechaTerminacionInst((Calendar)cFechaEst.clone(), String.valueOf(iSinDiasFest));
					Calendar cFechaIni = Utilerias.StringCalendar2(strFechaEst);
					Calendar cFechaAct = Utilerias.StringCalendar2(strFechaActual);
					boolean bAtrasado = Utilerias.fechasAtrasadas(cFechaIni, cFechaAct);
				%>
				<%if(bAtrasado){%>
				<TR valign="top">
					<TD align="center" width="165">
						<b><font size="1" face="Arial"><%=strDoctosDetenidos[i][6]%></font></b>
					</TD>
					<TD align="center" width="303">
						<b><font size="1" face="Arial"><%=strDoctosDetenidos[i][2]%></font></b>
					</TD>
					<TD align="center" width="223">
						<b><font size="1" face="Arial"><%=strDoctosDetenidos[i][3]%></font></b>
					</TD>
					<TD align="center" width="69">
						<%
							int iDiasAtrasado = Utilerias.DiasdeTrabajoEntre1(cFechaIni, cFechaAct);
							int iDiasSinDFest = Utilerias.getSinDiasFestivos(cFechaIni, cFechaAct);
							int iTotal = iDiasAtrasado - iDiasSinDFest;
						%>
						<b><font size="1" face="Arial"><%=iTotal%></font></b>
					</TD>
					<TD align="center" width="236">
						<b><font size="1" face="Arial">
							<%String strCount = ActualizaAsunto.getCountInstSinTurnar(strDoctosDetenidos[i][0]);%>
							<% String estatus = ""; %>
							<%if(strCount.equals("0")){%>
							<% estatus = "No se ha credo Ruta de Atención"; %>
							<%}else{%>
							<% estatus = "Tiene "+ strCount + " Instruccion(es) sin Turnar"; %>
							<%}%>
							<b><%= estatus %></b>
						</font></b>
					</TD>
				</TR>
				<% 	BeanReporteAtrasados BReporte = new BeanReporteAtrasados();
					BReporte.setCampos(strDoctosDetenidos[i]);
					BReporte.setAtraso("" + iTotal);
					BReporte.setEstatus(estatus);
					al.add(BReporte); %>
				<%}%>
				<%}
				session.setAttribute("ArrayReporte",al);
				}else{%>
				<tr>
					<TD align="center" colspan="4" width="1000">
						<b><font size="2" face="Arial">*** No hay Asuntos Atrasados ***</font></b>
					</TD>
				</tr>
				<%}%>
			</table>
		</TD>
	</TR>
</TBODY>
</table>
</DIV>
<br>
<!-- Tabla donde se muestra los asuntos que tienen un atraso, en tramite -->
<DIV align="center">
<table border="0" cellspacing="1" cellpadding="1">
<TBODY>
	<tr valign="top">
		<td bgcolor="#002060" width="1000">		
			<table border="0" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<td width="968">
						<b><font size="2" color="#FFFFFF" face="Arial"><%=strDoctosEnTramite[0][1]%><BR>Asuntos en Tramite Atrasados</font></b>
					</td>
					<td width="32">
						<div align="right">
							<i><font size="2" color="#FFFFFF" face="Arial"></font></i>
						</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<TR>
		<TD bgcolor="#002060" width="1000">
			<table border="1" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<TD bgcolor="#002060" align="center" width="165">
						<b><font size="2" color="#FFFFFF" face="Arial">Folio</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="303">
						<b><font size="2" color="#FFFFFF" face="Arial">Nombre del Docto.</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="223">
						<b><font size="2" color="#FFFFFF" face="Arial">Responsable</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="69">
						<b><font size="2" color="#FFFFFF" face="Arial">Días de <br>Atraso</font></b>
					</TD>
					<TD bgcolor="#002060" align="center" width="236">
						<b><font size="2" color="#FFFFFF" face="Arial">Estatus</font></b>
					</TD>
				</tr>
			</table>
		</TD>
	</TR>
	<TR>
		<TD width="1000"> 
			<table border="1" cellspacing="0" cellpadding="0">
				<%if(strDoctosEnTramite != null && strDoctosEnTramite.length> 0){%>
				<TR>
					<TD align="center">
						<A onclick="window.open('../ReporteBeanExcel?tip=AnalisisPorAtrasadosExcel&control=1');" title="Exportar a Excel">
						<img src="../Imagenes/ic_excel.gif" border="0"></A>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<A onclick="window.open('../ReporteBeanPDF?tip=AnalisisPorAtrasados&control=1');" title="Exportar a PDF">
						<img src="../Imagenes/ic_pdf.gif" border="0"></A>
					</TD>
				</TR>
				<%ArrayList al = new ArrayList(); %>
				<%for(int i=0;i<strDoctosEnTramite.length;i++){%>
				<%
					Calendar cFechaCad = Utilerias.StringCalendar(strDoctosEnTramite[i][6]);
					Calendar cFechaAct = Utilerias.StringCalendar2(strFechaActual);
					boolean bAtrasado = Utilerias.fechasAtrasadas(cFechaCad, cFechaAct);
				%>
				<%if(bAtrasado){%>
				<TR valign="top">
					<TD align="center" width="165">
						<b><font size="1" face="Arial"><%=strDoctosEnTramite[i][7]%></font></b>
					</TD>
					<TD align="center" width="303">
						<b><font size="1" face="Arial"><%=strDoctosEnTramite[i][2]%></font></b>
					</TD>
					<TD align="center" width="223">
						<b><font size="1" face="Arial"><%=strDoctosEnTramite[i][3]%></font></b>
					</TD>
					<TD align="center" width="69">
						<%
							int iDiasAtrasado = Utilerias.DiasdeTrabajoEntre1(cFechaCad, cFechaAct);
							int iDiasSinDFest = Utilerias.getSinDiasFestivos(cFechaCad, cFechaAct);
							int iTotal = iDiasAtrasado - iDiasSinDFest;
						%>
						<b><font size="1" face="Arial"><%=iTotal%></font></b>
					</TD>
					<TD align="center" width="236">
						<font size="1" face="Arial"> 
							<a href="ViewDoctosDetalle.jsp?id_asunto=<%=strDoctosEnTramite[i][0]%>&id_area=<%=strIdArea%>">Ver Detalle</a>
						</font>
					</TD>
				</TR>
				<% 	BeanReporteAtrasados2 BReporte = new BeanReporteAtrasados2();
					BReporte.setCampos(strDoctosEnTramite[i]);
					BReporte.setAtraso("" + iTotal);
					BReporte.setEstatus("Ver Detalle");
					al.add(BReporte); %>
				<%}%>
				<%}
				session.setAttribute("ArrayReporte2",al);
				}else{%>
				<tr>
					<TD align="center" colspan="4" width="1000">
						<b><font size="2" face="Arial">*** No hay Asuntos Atrasados ***</font></b>
					</TD>
				</tr>
				<%}%>
			</table>
		</TD>
	</TR>
</TBODY>
</table>
</DIV>

<%}%>
</FORM>
</BODY>
</HTML>
