<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>   
<HTML>
<HEAD>

<%@ taglib uri="meve_combo" prefix="meve_combo"%>
<%@ taglib uri="cewolf" prefix="cewolf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*, com.meve.sigma.reportes.*,de.laures.cewolf.*,java.text.*,java.util.*,com.meve.sigma.util.*"%>
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
	String strInicio	=	"";
	String strFin		=	"";
	String strFecha		=	"";
	String strIdReporte = 	"";
	String strIDMax		=	"";
	String strAccion	=	"";
	String nombreDoctos	=	"";
	String numAsuntos	=	"";
	String porcentaje	=	"";

	int iReporte		=	0;
	int i				=	0;
	int count			=	0;
	
	String strDatosReportes[][] = null;
	String strDocotos[]	=	null;
	
	boolean bInsertar	=	false;

	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
	SimpleDateFormat sdf=	new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date f 				=	new Date();
	strFecha			=	sdf.format(f);
	
	strIdReporte	=	request.getParameter("id_rep");
	strAccion		=	request.getParameter("accion");

	/** Se manda a llamar el ultimo Id de la tabla de reportes **/
	String idRep[][]=	ActualizaReportes.getMaxID();
	strIDMax 		= 	idRep[0][0];
	/** Fin llamada ID reportes **/

	if(strIDMax.length() == 0){
		strIDMax = "0";
		iReporte = new Integer(strIDMax).intValue();
	}else{
		iReporte = new Integer(strIDMax).intValue();
	}
	
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strInicio	=	request.getParameter("inicioTim");
		strFin		=	request.getParameter("finTim");
		i			=	iReporte + 1;
		String strTipoRep = "4";
		String strTitulo	=	"";
		String strReporte[][]  =	ActualizaReportes.getReportePorTiempos(strInicio, strFin, BUsuario.getIdArea());
		
		strTitulo 	=	"Reporte Generado del "+strInicio+" al "+strFin;
		bInsertar	=	ActualizaReportes.insertarReportesTiempos(i, strReporte, strTipoRep, 
														strFecha, strTitulo, BUsuario.getIdArea());
		try{
			response.sendRedirect("ViewTiempos.jsp");
		}catch(java.io.IOException io){
			//System.err.println("Error-->"+io);
		} 
	}

	if(strIdReporte != null)
	{
		strDatosReportes = ActualizaReportes.getReporteTiempos(strIdReporte);
	}
	
	if (pageContext.getAttribute("initFlag") == null) {
		DatasetProducer TimePlan = new BeanTimePlanChart(strDatosReportes);
		pageContext.setAttribute("TimePlanChar", TimePlan);

		DatasetProducer TimeReal = new BeanTimeRealChart(strDatosReportes);
		pageContext.setAttribute("TimeRealChar", TimeReal);
	}
%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Reporte por Tiempo de Respuesta</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>

function guardar() { 

	doc = document.reporteTime;
	valida = 0;
	msg="";

	if (doc.inicioTim.value =="") {
		valida =1;
		msg = msg + "- Debes seleccionar la Fecha de Inicio	"+ "\n";
	}
	if (doc.finTim.value =="") {
		valida =1;
		msg = msg + "- Debes seleccionar la Fecha Final	"+ "\n";
	}
	if (comparaFechas(doc.inicioTim.value,getfechaActual())==1){
		valida =1;
		msg = msg + "- La Fecha de Inicio debe ser menor o igual a la actual" + "\n";
	}
	if (comparaFechas(doc.finTim.value,getfechaActual())==1){
		valida =1;
		msg = msg + "- La Fecha Final debe ser menor o igual a la actual" + "\n";
	}
	if (doc.inicioTim.value!="" && doc.finTim.value!="" && comparaFechas(doc.inicioTim.value,doc.finTim.value)==1){
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
<FORM name="reporteTime" action="ReporteTiempos.jsp" method="post"><INPUT
	type="hidden" value="guardar" name="accion">
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
		<td width="144"><%if(strIdReporte == null){%> 
			<A href="ViewTiempos.jsp" title="Regresar"> <IMG src="../Imagenes/NavLeft.gif" border="0"></A> &nbsp;&nbsp;&nbsp;
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
				&quot;Regresar&quot;.</font></td>
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
				<td width="91">
				<div align="center"><b><FONT face="Arial" color="#004080" size="2">De:</font></b>
				</div>
				</td>
				<td width="173"><INPUT name="inicioTim" value="" onfocus="blur();"
					onclick="document.forms.reporteTime.inicioTim.value=''" class="blue100">
				<A><IMG title="" src="../Imagenes/act_calFormat.gif" 
					border="0" onclick='show_calendar("forms[0].inicioTim");'></A> <FONT
					face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT></td>
				<td width="90"> 
				<div align="center"><b><FONT face="Arial" color="#004080" size="2">A:</font></b>
				</div>
				</td>
				<td width="174"><INPUT name="finTim" value="" onfocus="blur();"
					onclick="document.forms.reporteTime.finTim.value=''" class="blue100"> <A><IMG
					title="" src="../Imagenes/act_calFormat.gif" border="0"
					onclick='show_calendar("forms[0].finTim");'></A> <FONT face="Arial"
					color="#004080" size="1"> dd/mm/aaaa</FONT></td>
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
<% } %> <% if(strIdReporte != null){ %>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="144"><a href="<%= retURI %>"> <IMG border="0"
			src="../Imagenes/NavLeft.gif" > </a></td>
		<td width="108"><a onclick="window.open('../RporTipDocto?id_rep=<%=strIdReporte%>&tip=AnalisisPorTiempoRespuesta&tit=<%=strDatosReportes[0][0]%>');">
			<IMG border="0" src="../Imagenes/ic_pdf.gif" title="Exportar a PDF"></a></td>
		<td width="144"><a onclick="window.open('../ReportExcel?id_rep=<%=strIdReporte%>&tip=AnalisisPorTiempoRespuestaExcel&tit=<%=strDatosReportes[0][0]%>');">
			<IMG border="0" src="../Imagenes/ic_excel.gif" title="Exportar a Excel"></a></td>
		<td width="227"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</table>
<br>
</DIV>
<DIV align="center">
<table border="1">
<tr valign="top">
	<td width="607" bgcolor="#002060">		
		<table border="0" cellspacing="0" cellpadding="0">
			<tr valign="top">
				<td width="573">
					<b><font size="2" color="#FFFFFF" face="Arial"><%=strDatosReportes[0][1]%><BR><%=strDatosReportes[0][0]%></font></b>
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
<tr valign="top">
	<td width="607">
		<div align="center">
			<TABLE BORDER=1>
				<TR VALIGN=top ALIGN=center>
					<TD WIDTH="304" BGCOLOR="002060" ROWSPAN=2 VALIGN=middle>
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Tipos de Documento</FONT>
					</TD>
					<TD WIDTH="54" BGCOLOR="002060" ROWSPAN=2 VALIGN=middle>
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">No.</FONT><BR>
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Asuntos</FONT>
					</TD>
					<TD WIDTH="183" BGCOLOR="002060" COLSPAN=3>
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Tiempos de Solucion Planeada (Días)</FONT>
					</TD>
					<TD WIDTH="183" BGCOLOR="002060" COLSPAN=3>
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Tiempos de Solucion <br> Real (Días)</FONT>
					</TD>
				</TR>
				<TR VALIGN=top align=center>
					<TD WIDTH="60" BGCOLOR="002060">
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Promedio</FONT>
					</TD>
					<TD WIDTH="64" BGCOLOR="002060">
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Mas corto</FONT>
					</TD>
					<TD WIDTH="61" BGCOLOR="002060">
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Mas largo</FONT>
					</TD>
					<TD WIDTH="61" BGCOLOR="002060">
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Promedio</FONT>
					</TD>
					<TD WIDTH="61" BGCOLOR="002060">
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Mas corto</FONT>
					</TD>
					<TD WIDTH="61" BGCOLOR="002060">
						<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Mas largo</FONT>
					</TD>
				</TR>
				<% for(int t=0;t<strDatosReportes.length;t++){ %>
				<TR VALIGN=top ALIGN=center>
					<TD WIDTH="304" ALIGN=left>
						<FONT SIZE=2 FACE="Arial"><%=strDatosReportes[t][2]%></FONT>
					</TD>
					<TD WIDTH="54">
						<FONT SIZE=2  FACE="Arial"><%=strDatosReportes[t][3]%></FONT>
					</TD>
					<TD WIDTH="61" >
						<FONT SIZE=2 FACE="Arial"><%=Utilerias.getNumeroFlotante(strDatosReportes[t][7])%></FONT>
					</TD>
					<TD WIDTH="61" >
						<FONT SIZE=2  FACE="Arial"><%=strDatosReportes[t][5]%></FONT>
					</TD>
					<TD WIDTH="61" >
						<FONT SIZE=2 FACE="Arial"><%=strDatosReportes[t][6]%></FONT>
					</TD>
					<TD WIDTH="61" >
						<FONT SIZE=2 FACE="Arial"><%=Utilerias.getNumeroFlotante(strDatosReportes[t][10])%></FONT>
					</TD>
					<TD WIDTH="61" >
						<FONT SIZE=2 FACE="Arial"><%=strDatosReportes[t][8]%></FONT>
					</TD>
					<TD WIDTH="61" >
						<FONT SIZE=2  FACE="Arial"><%=strDatosReportes[t][9]%></FONT>
					</TD>
				</TR>
				<%}%>
			</TABLE>
		</div>
	</td>
</tr>
</table>
</DIV>

<!-- Sección del applet de las graficas --> <br>
<DIV align="center">
<TABLE>
	<TBODY>
		<TR>
			<TD><cewolf:chart id="horizontalBarChart3D"
				title="Grafica por Tiempos de Solución Planeada" type="horizontalBar3D"
				xaxislabel="Tipo de Documento" yaxislabel="Totales">
				<cewolf:gradientpaint>
					<cewolf:point x="0" y="0" color="#FFFFFF" />
					<cewolf:point x="300" y="0" color="#DDDDFF" />
				</cewolf:gradientpaint>
				<cewolf:data>
					<cewolf:producer id="TimePlanChar" />
				</cewolf:data>
			</cewolf:chart>
				<cewolf:img chartid="horizontalBarChart3D" renderer="/cewolf" width="600" height="400"/>
			</TD>
		</TR>
		<TR>
		</TR>
		<TR>
			<TD><cewolf:chart id="horizontalBarChart3D"
				title="Grafica por Tiempos de Solución Real" type="horizontalBar3D"
				xaxislabel="Tipo de Documento" yaxislabel="Totales">
				<cewolf:gradientpaint>
					<cewolf:point x="0" y="0" color="#FFFFFF" />
					<cewolf:point x="300" y="0" color="#DDDDFF" />
				</cewolf:gradientpaint>
				<cewolf:data>
					<cewolf:producer id="TimeRealChar" />
				</cewolf:data>
			</cewolf:chart>
				<cewolf:img chartid="horizontalBarChart3D" renderer="/cewolf" width="600" height="400"/>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<% } %> <!-- FIn sección del applet de las graficas -->
</FORM>
</BODY>
</HTML>
