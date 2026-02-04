<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ taglib uri="cewolf" prefix="cewolf"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.reportes.*,de.laures.cewolf.*"
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
	String strM			=	"";
	String strY			=	"";
	String strFecha		=	"";
	String strIdReporte = 	"";
	String strIDMax		=	"";
	String strAccion	=	"";
	int iReporte		=	0;
	int i				=	0;
	boolean bInsertar	=	false;
	String strDatosReportes[][] = null;
	String nombreDoctos	=	"";
	String numRecepcion	=	"";
	String numTurnados	=	"";
	String numTerminados=	"";
	
	java.text.SimpleDateFormat sdfMes 	=	new java.text.SimpleDateFormat("MM");
	java.text.SimpleDateFormat sdfanio	=	new java.text.SimpleDateFormat("yyyy");
	java.text.SimpleDateFormat sdf		=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date f 					=	new java.util.Date();
	strMes 								=	sdfMes.format(f);
	stryear								=	sdfanio.format(f);
	strFecha							=	sdf.format(f);
	
	strIdReporte	=	request.getParameter("id_rep");
	strAccion		=	request.getParameter("accion");

	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");

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
		strM	=	request.getParameter("inicioR");
		strY	=	request.getParameter("finR");
		i		=	iReporte + 1;
		String strTipoRep = "2";
		String strReporte[][]  =	ActualizaReportes.getReportePorEstatus(strM, strY, BUsuario.getIdArea());
		
		String strTitulo	=	"Reporte Generado del "+strM+" al "+strY;
		bInsertar	=	ActualizaReportes.InsertarAsuntoEstatus(i, strReporte, strTipoRep, strFecha, strTitulo, BUsuario.getIdArea());
		try{
			response.sendRedirect("ViewEstatus.jsp");
		}catch(java.io.IOException io){
			//System.err.println("Error-->"+io);
		} 
	}

	if(strIdReporte != null)
	{
		strDatosReportes = ActualizaReportes.getDatosReportesEstatus(strIdReporte,com.meve.sigma.actualiza.ActualizaArea.NombreArea(BUsuario.getIdArea()));
	}

	if (pageContext.getAttribute("initFlag") == null) {

		DatasetProducer EstatusTramite = new BeanPlanChartEstatus(strDatosReportes);
		pageContext.setAttribute("EstatusTramite", EstatusTramite);

		DatasetProducer EstatusTerminado = new BeanPlanChartEstatusTerminado(strDatosReportes);
		pageContext.setAttribute("EstatusTerminado", EstatusTerminado);
	}

%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Reporte por Estatus</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>

function guardar() { 

	doc = document.reporteEst;
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
<FORM name="reporteEst" action="ReporteEstatus.jsp" method="post">
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
<% if(strIdReporte == null){ %>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
<tr valign="top">
		<td width="144"><%if(strIdReporte == null){%> 
			<A href="<%= retURI %>" title="Regresar"> <IMG src="../Imagenes/NavLeft.gif" border="0"></A> &nbsp;&nbsp;&nbsp;
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
						<INPUT name="inicioR" value="" onfocus="blur();" onclick="document.forms.reporteEst.inicioR.value=''" class="blue100">
						<A><IMG title="" src="../Imagenes/act_calFormat.gif" border="0" onclick='show_calendar("forms[0].inicioR");'></A>
						<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
					</td>
					<td width="90">
						<div align="center">
						<b><FONT face="Arial" color="#004080" size="2">A:</font></b>
						</div>
					</td>
					<td width="174">
						<INPUT name="finR" value="" onfocus="blur();" onclick="document.forms.reporteEst.finR.value=''" class="blue100">
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
<% if(strIdReporte != null && strDatosReportes!=null && strDatosReportes.length>0){ %>

<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="144"><a href="<%= retURI %>"> <IMG border="0"
			src="../Imagenes/NavLeft.gif"> </a></td>
		<td width="108"><a onclick="window.open('../RporTipDocto?id_rep=<%=strIdReporte%>&tip=AnalisisPorEstatus&tit=<%=strDatosReportes[0][0]%>&area=<%=com.meve.sigma.actualiza.ActualizaArea.NombreArea(BUsuario.getIdArea())%>');">
			<IMG border="0" src="../Imagenes/ic_pdf.gif" title="Exportar a PDF"></a></td>
		<td width="144"><a onclick="window.open('../ReportExcel?id_rep=<%=strIdReporte%>&tip=AnalisisPorEstatusExcel&tit=<%=strDatosReportes[0][0]%>&area=<%=com.meve.sigma.actualiza.ActualizaArea.NombreArea(BUsuario.getIdArea())%>');">
			<IMG border="0" src="../Imagenes/ic_excel.gif" title="Exportar a Excel"></a></td>
		<td width="227"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</table>
<BR>
<table border="1">
<tr valign="top">
	<td width="762" bgcolor="#002060">
		<table border="0" cellspacing="0" cellpadding="0">
		<tr valign="top">
			<td width="511">
				<b><font size="2" color="#FFFFFF" face="Arial"><%=strDatosReportes[0][1]%><BR><%=strDatosReportes[0][0]%></font></b>
			</td>
			<td width="250">
			</td>
		</tr>
		</table>
	</td>
</tr>
<tr valign="top">
	<td width="762" height="100">
		<div align="center">
			<TABLE BORDER=1>
				<TR VALIGN=top ALIGN=center VALIGN=middle>
					<TD WIDTH="500" BGCOLOR="002060" ROWSPAN=3 VALIGN=middle>
						<DIV ALIGN=center>
							<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Tipo de Documento</FONT>
						</DIV>
					</TD>
					<TD WIDTH="359" BGCOLOR="002060" COLSPAN=2>
						<DIV ALIGN=center>
							<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Estatus</FONT>
						</DIV>
					</TD>
				</TR>
				<TR VALIGN=top VALIGN=middle>
					<TD WIDTH="179" BGCOLOR="002060" COLSPAN=1>
						<DIV ALIGN=center>
							<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Tramite</FONT>
						</DIV>
					</TD>
					<TD WIDTH="180" BGCOLOR="002060" COLSPAN=1>
						<DIV ALIGN=center>
							<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">Terminado</FONT>
						</DIV>
					</TD>
				</TR>
				<TR VALIGN=top VALIGN=middle>
					<TD WIDTH="179" BGCOLOR="002060" COLSPAN=1>
						<DIV ALIGN=center>
							<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">NV / V</FONT>
						</DIV>
					</TD>
					<TD WIDTH="180" BGCOLOR="002060" COLSPAN=1>
						<DIV ALIGN=center>
							<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial">NV / V</FONT>
						</DIV>
					</TD>
				</TR>
			</TABLE>
			<TABLE border="1">
				<% for(int y=0;y<strDatosReportes.length;y++){ %>
				<TR VALIGN=top>
					<TD width="490">
						<DIV ALIGN=center>
							<FONT SIZE=2  FACE="Arial"><%=strDatosReportes[y][2]%></FONT>
						</DIV>
					</TD><% nombreDoctos += strDatosReportes[y][2]+","; %>
					<!-- <TD width="122">
						<DIV ALIGN=center>
							<FONT SIZE=2  FACE="Arial"><%=strDatosReportes[y][3]%></FONT>
						</DIV>
					</TD> --><% numRecepcion += strDatosReportes[y][3]+","; %>
					<TD width="179">
						<DIV ALIGN=center>
							<FONT SIZE=2  FACE="Arial"><%=strDatosReportes[y][4]%> / <%=strDatosReportes[y][7]%></FONT>
						</DIV>
					</TD><% numTurnados += strDatosReportes[y][4]+","; %>
					<TD width="180">
						<DIV ALIGN=center>
							<FONT SIZE=2  FACE="Arial"><%=strDatosReportes[y][5]%> / <%=strDatosReportes[y][8]%></FONT>
						</DIV>
					</TD><% numTerminados += strDatosReportes[y][5]+","; %>
				</TR>
				<% } %>
			</TABLE>
		</div>
	</td>
</tr>
</table>
</div>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
<tr valign="top">
	<td width="66">
		<div align="right">
			<b><font size="2" face="Arial">Nota:</font></b>
		</div>
	</td>
	<td width="348">
		<b><font size="2" face="Arial">&quot;V&quot;</font></b>
			<font size="2" face="Arial"> indica que son documentos vencidos </font>
	</td>
</tr>
<tr valign="top">
	<td width="66">
		<img src="../Imagenes/ecblank.gif" border="0" height="1" width="1" title="">
	</td>
	<td width="348">
		<b><font size="2" face="Arial">&quot;NV&quot;</font></b>
		<font size="2" face="Arial"> indica que son documentos no vencidos</font>
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
				title="Grafica de Estatus por Asuntos en Tramite" type="horizontalBar3D"
				xaxislabel="Tipo de Documento" yaxislabel="Totales">
				<cewolf:gradientpaint>
					<cewolf:point x="0" y="0" color="#FFFFFF" />
					<cewolf:point x="300" y="0" color="#DDDDFF" />
				</cewolf:gradientpaint>
				<cewolf:data>
					<cewolf:producer id="EstatusTramite" />
				</cewolf:data>
			</cewolf:chart>
				<cewolf:img chartid="horizontalBarChart3D" renderer="/cewolf" width="600" height="400"/>
			</TD>
		</TR>
		<TR>
			<TD><cewolf:chart id="horizontalBarChart3D"
				title="Grafica de Estatus por Asuntos Terminados" type="horizontalBar3D"
				xaxislabel="Tipo de Documento" yaxislabel="Totales">
				<cewolf:gradientpaint>
					<cewolf:point x="0" y="0" color="#FFFFFF" />
					<cewolf:point x="300" y="0" color="#DDDDFF" />
				</cewolf:gradientpaint>
				<cewolf:data>
					<cewolf:producer id="EstatusTerminado" />
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
