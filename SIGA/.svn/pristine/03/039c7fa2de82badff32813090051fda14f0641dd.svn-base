<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="cewolf" prefix="cewolf"%>    
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*, com.meve.sigma.reportes.*,
			de.laures.cewolf.*,com.meve.sigma.actualiza.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null)
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}catch(java.io.IOException io){
			//System.out.println("Error-->"+io);
		}

%>
<%
	String strMes 		= 	"";
	String stryear 		= 	"";
	String strInicio	=	"";
	String strFin		=	"";
	String strFecha		=	"";
	String strIdReporte = 	"";
	String strIDMax		=	"";
	String strAccion	=	"";
	int iReporte		=	0;
	int i				=	0;
	int count 			=	0;
	boolean bInsertar	=	false;
	String strDatosReportes[][] = null;
	String nombreDoctos	=	"";
	String numAsuntos	=	"";
	String porcentaje	=	"";
	
	java.text.SimpleDateFormat sdfMes 	=	new java.text.SimpleDateFormat("MM");
	java.text.SimpleDateFormat sdfanio	=	new java.text.SimpleDateFormat("yyyy");
	java.text.SimpleDateFormat sdf		=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date f 					=	new java.util.Date();
	strMes 								=	sdfMes.format(f);
	stryear								=	sdfanio.format(f);
	strFecha							=	sdf.format(f);
	
	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
	strIdReporte	=	request.getParameter("id_rep");
	strAccion		=	request.getParameter("accion");
	String idRep[][]=	ActualizaReportes.getMaxID();
	strIDMax = idRep[0][0];
	if(strIDMax.length() == 0){
		strIDMax = "0";
		iReporte = new Integer(strIDMax).intValue();
	}else{
		iReporte = new Integer(strIDMax).intValue();
	}
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strInicio	=	request.getParameter("inicioR");
		strFin		=	request.getParameter("finR");
		i			=	iReporte + 1;
		String strTipoRep = "15"; 
		String strReporte[][]  =	ActualizaReportes.getReportePorRemitenteI(strInicio, strFin, BUsuario.getIdArea());
		for(int j=0;j<strReporte.length;j++){
			count += new Integer(strReporte[j][2]).intValue();
		}
		String strTitulo	=	"Reporte Generado del "+strInicio+" al "+strFin;
		bInsertar	=	ActualizaReportes.InsertarAsunto(i, strReporte, strTipoRep, strFecha, count, 
														strTitulo, BUsuario.getIdArea());
		try{
			response.sendRedirect("ViewRemitenteI.jsp");
		}catch(java.io.IOException io){
			//System.err.println("Error-->"+io);
		} 
	}

	if(strIdReporte != null)
	{
		strDatosReportes = ActualizaReportes.getDatosReportes(strIdReporte);
	}

	if (pageContext.getAttribute("initFlag") == null) {
		DatasetProducer categoryData = new Bean3dChart(strDatosReportes, "", "0");
		pageContext.setAttribute("categoryDataChar", categoryData);
	
		DatasetProducer pieData = new BeanPieChart(strDatosReportes, "0"); 
  		pageContext.setAttribute("pieDataChar", pieData);
	}

%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Reporte por Remitentes Internos</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>

function guardar() { 

	doc = document.reporteRemI;
	valida = 0;
	msg="";
	
	if (doc.inicioR.value =="") {
		valida =1;
		msg = msg + "- Debes seleccionar la Fecha de Inicio	"+ "\n";
	}
	if (doc.finR.value =="") {
		valida =1;
		msg = msg + "- Debes seleccionar la Fecha Final	"+ "\n";
	}
	if (comparaFechas(doc.inicioR.value,getfechaActual())==1){
		valida =1;
		msg = msg + "- La Fecha de Inicio debe ser menor o igual a la actual" + "\n";
	}
	if (comparaFechas(doc.finR.value,getfechaActual())==1){
		valida =1;
		msg = msg + "- La Fecha Final debe ser menor o igual a la actual" + "\n";
	}
	if (doc.inicioR.value!="" && doc.finR.value!="" && comparaFechas(doc.inicioR.value,doc.finR.value)==1){
		valida =1;
		msg = msg + "- La Fecha de Inicio debe ser menor o igual a la Fecha Final" + "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		return false;
	}else{
		doc.accion.value="guardar";
		doc.submit();
	}
}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="reporteRemI" action="ReporteRemitenteI.jsp" method="post">
<INPUT type="hidden" value="guardar" name="accion">
<INPUT name="retURI" value="<%=retURI%>" type="hidden">
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
<table border="0" cellspacing="0" cellpadding="0">
<tr valign="top">
	<td width="144">
		<% if(strIdReporte == null && (BUsuario.getSupervisor())){ %>
			<A href="ViewRemitenteI.jsp" title="Regresar"> <IMG src="../Imagenes/NavLeft.gif" border="0"></A> &nbsp;&nbsp;&nbsp;
			<A onclick="guardar()" title="Generar Reporte"><IMG src="../Imagenes/Report.png" border="0"></A>
		<%}%></td>
		<td width="108"></td> 
		<td width="144"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="144"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>

</tr>
</table>
</DIV>
<br>
<% if(strIdReporte == null){ %>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="546">
			<b><font size="2" color="#002060" face="Arial">Condiciones para Generar Reporte</font></b>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<td width="100%" bgcolor="#002060"><img src="../Imagenes/shim.gif" width="1" height="1" title=""></td>
				</tr>
			</table>
			<br>
		</td>
	</tr>
	<tr valign="top">
		<td width="546">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<td width="23">
						<img src="../Imagenes/ecblank.gif" border="0" height="1" width="1" title="">
					</td>
					<td width="498">
						<font size="2" face="Arial">Proporcione la informacion solicitada y posteriormente de clic en el botón &quot;Generar Reporte&quot;.    Para salir de clic en el botón &quot;Regresar&quot;.</font>
					</td>
					<td width="24">
						<img src="../Imagenes/ecblank.gif" border="0" height="1" width="1" title="">
					</td>
				</tr>
			</table>
			<hr><br>
		</td>
	</tr>
	<tr valign="top">
		<td width="546"><center>
			<table border="0" cellspacing="0" cellpadding="0">
				<tr valign="top">
					<td width="91">
						<div align="center">
						<b><FONT face="Arial" color="#004080" size="2">De:</font></b>
						</div>
					</td>
					<td width="173">
						<INPUT name="inicioR" value="" onfocus="blur();" onclick="document.forms.reporteRem.inicioR.value=''" class="blue100">
						<A><IMG title="" src="../Imagenes/act_calFormat.gif" border="0" onclick='show_calendar("forms[0].inicioR");'></A>
						<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
					</td>
					<td width="90">
						<div align="center">
						<b><FONT face="Arial" color="#004080" size="2">A:</font></b>
						</div>
					</td>
					<td width="174">
						<INPUT name="finR" value="" onfocus="blur();" onclick="document.forms.reporteRem.finR.value=''" class="blue100">
						<A><IMG title="" src="../Imagenes/act_calFormat.gif" border="0" onclick='show_calendar("forms[0].finR");'></A>
						<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
					</td>
				</tr>
			</table>
			</center><br><hr><br>
		</td>
	</tr>
</table>
</DIV>
<% } %>
<% if(strIdReporte != null){ %>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="144"><a href="<%= retURI %>"> <IMG border="0"
			src="../Imagenes/NavLeft.gif" > </a></td>
		<td width="108"><a onclick="window.open('../RporTipDocto?id_rep=<%=strIdReporte%>&tip=AnalisisPorRemitenteI&tit=<%=strDatosReportes[0][0]%>');">
			<IMG border="0" src="../Imagenes/ic_pdf.gif" title="Exportar a PDF"></a></td>
		<td width="144"><a onclick="window.open('../ReportExcel?id_rep=<%=strIdReporte%>&tip=AnalisisPorRemitenteExcelI&tit=<%=strDatosReportes[0][0]%>');">
			<IMG border="0" src="../Imagenes/ic_excel.gif" title="Exportar a Excel"></a></td>
		<td width="227"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</table>
<br>
<table border="1">
<tr valign="top">
	<td width="442" bgcolor="#002060">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr valign="top">
				<td width="80%">
					<b><font size="2" color="#FFFFFF" face="Arial"><%=ActualizaArea.NombreArea(BUsuario.getIdArea())%><BR><%=strDatosReportes[0][0]%></font></b>
				</td>
				<td width="20%">
					<div align="right">
						<i><font size="2" color="#FFFFFF" face="Arial"></font></i>
					</div>
				</td>
			</tr>
		</table>
	</td>
</tr>
<tr valign="top">
	<td width="612">
		<div align="center">
			<TABLE BORDER=1 width="100%">
			<TR VALIGN=top  align="center">
				<TD WIDTH="40%" BGCOLOR="002060">
					<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Remitentes Internos</FONT>
				</TD>
				<TD WIDTH="30%" BGCOLOR="002060">
					<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">No. Asuntos<BR>Solicitados</FONT></TD>
				<TD WIDTH="30%" BGCOLOR="002060">
					<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Porcentaje</FONT>
				</TD>
			</TR>
			<% for(int y=0;y<strDatosReportes.length;y++){ %>
			<TR VALIGN=top>
				<TD WIDTH="40%">
					<FONT SIZE=2 FACE="Arial"><%=strDatosReportes[y][2]%></FONT>
				</TD><% nombreDoctos += strDatosReportes[y][2]+","; %>
				<TD WIDTH="30%" align="center">
					<FONT SIZE=2 FACE="Arial"><%=strDatosReportes[y][3]%></FONT>
				</TD><% numAsuntos += strDatosReportes[y][3]+","; %>
				<TD WIDTH="30%" align="center">
					<FONT SIZE=2 FACE="Arial"><%=strDatosReportes[y][4]%>%</FONT>
				</TD><% porcentaje += strDatosReportes[y][4]+","; %>
			</TR>
			<% } %>
		</TABLE>
	</div>
</td>
</tr>
</table>
</DIV>

<!-- Sección del applet de las graficas -->
<br>
<div align="center">
	
<table border="0" cellspacing="0" cellpadding="0">
	<TR>
			<TD><cewolf:chart id="horizontalBarChart3D"
				title="Grafica por No. Asuntos por Remitentes Internos" type="horizontalBar3D"
				xaxislabel="Remitentes Internos" yaxislabel="Totales">
				<cewolf:gradientpaint>
					<cewolf:point x="0" y="0" color="#FFFFFF" />
					<cewolf:point x="300" y="0" color="#DDDDFF" />
				</cewolf:gradientpaint>
				<cewolf:data>
					<cewolf:producer id="categoryDataChar" />
				</cewolf:data>
			</cewolf:chart>
				<cewolf:img chartid="horizontalBarChart3D" renderer="/cewolf" width="750" height="650"/>
			</TD>
		</TR>
		<tr valign="top">
			<td width="600"><br></td>
		</tr>
		<TR>
			<TD><cewolf:chart id="pieChart"
				title="Grafica de Porcentaje de Asuntos por Remitentes Internos" type="pie">
				<cewolf:gradientpaint>
					<cewolf:point x="0" y="0" color="#FFFFFF" />
					<cewolf:point x="300" y="0" color="#DDDDFF" />
				</cewolf:gradientpaint>
				<cewolf:data>
					<cewolf:producer id="pieDataChar" />
				</cewolf:data>
			</cewolf:chart> <cewolf:img chartid="pieChart" renderer="/cewolf"
				width="750" height="650" /></TD>
		</TR>
</table>
</div>
<% } %>
<!-- FIn sección del applet de las graficas -->

</FORM>
</BODY>

</HTML>
