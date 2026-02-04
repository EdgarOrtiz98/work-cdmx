<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerCiudadano.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.search.*,com.meve.sigma.actualiza.*,com.meve.sigma.taglib.*"
%>
<%
	int j = 0;
	String strConsulta[][] = null;
	String strAccion 		= 	"";
	String strFechaInicio 	= 	"";
	String strFechaFin 		= 	"";
	String strSolicitud 	= 	"";
	String strFolio			=	"";
	String strFecha			=	"";
	String strEstatus		=	"";
	String strRespuesta		=	"";
	String strArea			=	"";
	String strTipoRespuesta	=	"";
	
	strAccion		=	request.getParameter("accion");
	strFechaInicio	=	(request.getParameter("bi") != null)?request.getParameter("bi"):"";
	strFechaFin		=	(request.getParameter("bf") != null)?request.getParameter("bf"):"";
	strArea			=	(request.getParameter("ba") != null)?request.getParameter("ba"):"";
	strTipoRespuesta=	(request.getParameter("btr") != null)?request.getParameter("btr"):"";

	if(strAccion != null && strAccion.equals("consultar")){
		
		strFechaInicio	=	request.getParameter("bi");
		strFechaFin		=	request.getParameter("bf");
		strArea			=	request.getParameter("ba");
		strTipoRespuesta=	request.getParameter("btr");
		//strConsulta		=	ActualizaBuscar.getConsultaCiudadano(strFechaInicio, strFechaFin);
		try{
			response.sendRedirect("ConsultaPublica.jsp?bi="+strFechaInicio+"&bf="+strFechaFin+"&ba="+strArea+"&btr="+strTipoRespuesta);
		}catch(java.io.IOException io){
			//System.err.println("Error redireccion-->"+io);
		}
	}
	if(strFechaInicio.length() > 0 && strFechaInicio != null
		&& strFechaFin.length() > 0 && strFechaFin != null){
		strConsulta	=	ActualizaBuscar.getConsultaCiudadanoTerminados(strFechaInicio, strFechaFin, 
																strTipoRespuesta, strArea); 
	}
	
%>
<%!
	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
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
<TITLE>ConsultaPublica.jsp</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM name="consultaPublicaForm" action="ConsultaPublica.jsp" method="post">
<INPUT type="hidden" name="accion" value="">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%" colspan="2">
			<DIV align="right"></DIV>
			</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="#004080" size="2">
			Consulta Pública</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="380">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#00204f" colspan="4"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br><br>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<tr valign="top">
		<td width="183">
		<div align="right"><b><font size="2" color="#004080" face="Arial">Fecha Inicio:&nbsp;&nbsp;</font></b>
		</div>
		</td>
		<td width="233" valign="middle"><font size="2" face="Arial"> <input
			name="bi" value="" onfocus="blur()" onkeydown=""
			class="blue100"> </font><a><img src="../Imagenes/cal.gif" border="0"
			title="Selecciona una Fecha" width="16" height="16"
			onclick='show_calendar("forms[1].bi");'></a> <font
			size="1" color="#004080" face="Arial">(dd/mm/aaaa)</font>
			<!-- <input type="button" onclick="" value="" class="s-dropdown-btn"> -->
		</td>
		<td width="171">
		<div align="right"><b><font size="2" color="#004080" face="Arial">Fecha Fin:&nbsp;&nbsp;</font></b>
		</div>
		</td>
		<td valign="middle" width="275"><font size="2" face="Arial"> <input
			name="bf" value="" onfocus="" onclick="blur()" class="blue100">
		</font><a><img src="../Imagenes/cal.gif" border="0"
			title="Selecciona una Fecha" width="16" height="16"
			onclick='show_calendar("forms[1].bf");'></a> <font
			size="1" color="#004080" face="Arial">(dd/mm/aaaa)</font> <!-- <input type="button" onclick="" value="" class="s-dropdown-btn"> -->
		</td>
	</tr>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="171"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="275"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<TD width="183" align="left"><b><font size="2" color="#004080" face="Arial">Por Tipo de Respuesta:</FONT>&nbsp;&nbsp;</b></TD>
		<TD colspan="3">
			<FONT SIZE=2 FACE="Verdana">
			<%
				String strTipoRespuestas[][] = null;
				strTipoRespuestas = ComboData.getTipoRespuestaCombo();
			%>
			<SELECT name="btr" class="blue500" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()">
				<OPTION value="-1">--TODAS--</OPTION>
				<% for(int i=0;i<strTipoRespuestas.length;i++){ %>
				<OPTION value="<%=strTipoRespuestas[i][0]%>"><%=strTipoRespuestas[i][1]%></OPTION>
				<% } %>
			</SELECT>
			</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="171"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="275"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<TD width="183" align="left"><b><font size="2" color="#004080" face="Arial">Área:</FONT>&nbsp;&nbsp;</b></TD>
		<TD colspan="3">
			<FONT SIZE=2 FACE="Verdana">
			<%
				String strAreas[][] = null;
				strAreas = ActualizaArea.getAreasCiudadano();
			%>
			<SELECT name="ba" class="blue500" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()">
				<OPTION value="-1">--TODAS--</OPTION>
				<% for(int i=0;i<strAreas.length;i++){ %>
				<OPTION value="<%=strAreas[i][0]%>"><%=strAreas[i][1]%></OPTION>
				<% } %>
			</SELECT>
			</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="171"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="275"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TBODY>
</table>
<br>
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR>
		<TD>
			<INPUT 	name="consulta" value="Consultar" 
					type="button" class="blue200" onclick="consultaBuscar()">
		</TD>
	</TR>
</TBODY>
</table>
</DIV>
<br>
<br>
<% if(strConsulta != null){ %>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR>
		<TD width="283"><b><FONT size="2" color="#004080" face="Arial">
		Resultados: </FONT></b></TD>
		<td width="133"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR>
		<td width="863" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</TR>
</TBODY>
</table>
</DIV>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
<TBODY>
	<TR>
		<TD width="283"><b><FONT size="2" color="#004080" face="Arial">
			Numero de Resultados: <%=strConsulta.length%></FONT></b></TD>
		<td width="133"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TBODY>
</table>
</DIV>
<br>
<DIV align="center">
<TABLE border="0" width="863">
	<TBODY>
		<TR>
			<TD align="left"><FONT size="2" color="#004080" face="Arial">
				Dar click al <b><u>Folio</u></b> para consultar Solicitud. Dar click en <b><u>Tipo de Respuesta</u></b></FONT>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<table border="0" width="863">
<TBODY>
	<TR bgcolor="#00204f">
		<td width="215">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">Folio</FONT></b>
			</CENTER>
		</td>
		<td width="218">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">Tipo de Respuesta</FONT></b>
			</CENTER>
		</td>
		<td width="215">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">Fecha Terminación</FONT></b>
			</CENTER>
		</td>
		<td width="215">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">Estatus</FONT></b>
			</CENTER>
		</td>
	</TR>
</TBODY>
</table>
<DIV class=documentBody id=Body>
<% if(strConsulta.length > 0){ %>
<table border="0" width="863">
<TBODY>
	<meve_front:ListaDatos datos="<%=strConsulta%>" campo="campo">
	<% j++; %>
	<TR <%if(par(j)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<td width="215">
			<CENTER>
				<A href="seguimientoConsulta.jsp?id_solicitud=<%=campo1%>">
				<FONT size="1" color="#000080" face="verdana"><%=campo2%></FONT>
				</A>
			</CENTER>
		</td>

		<td width="218">
			<CENTER>
				<% 
					//boolean bexiste = false;
					//bexiste = ActualizaCiudadano.getExistenNotificaciones(campo3);
					//if(bexiste){ 
					//	String strS[][] = null;
					//	strS = ActualizaCiudadano.getDatosNotificacion(campo3);
					//	for(int s=0;s<strS.length;s++){
				%>
				<FONT size="1" color="#000080" face="verdana">
				<A href="DetalleConsulta.jsp?id_solicitud=<%=campo3%>">
				<%=ActualizaTipoRespuesta.getNombreTipoRespuesta(campo4)[0][0]%>
				</A>
				</FONT><br>
				<!-- //}}else{ %>
				<FONT size="1" color="#000080" face="verdana">No tiene Respuesta</FONT>
				//} %> -->
			</CENTER>
		</td>
		<td width="215">
			<CENTER>
				<FONT size="1" color="#000080" face="verdana"><%=campo6%></FONT>
			</CENTER>
		</td>
		<td width="215">
			<CENTER>
				<FONT size="1" color="#000080" face="verdana">
				<%=ActualizaEstatus.getNombreEstatus(campo5)[0][0]%>
				<!-- 
				if(campo5.equals("1")){ %>
				Por Atender
				 }else if(campo5.equals("2")){ %>
				En proceso
				 }else if(campo5.equals("3")){ %>
				Terminados
				 } %> -->
				</FONT>
			</CENTER>
		</td>
		
		<!-- <td width="172">
			<CENTER>
				<FONT size="1" color="#000080" face="verdana">
				%
					//if(strArea.equals("-1")){
					//	String strAreasAtencion[][] = null;
					//	strAreasAtencion = ActualizaBuscar.getAreasAtencion(campo3);
					//	if(strAreasAtencion.length > 0){
					//		for(int r = 0;r<strAreasAtencion.length;r++){
				%>
					%=//ActualizaArea.NombreArea(strAreasAtencion[r][0])%<br>
					% }}else{ %>
					No se le ha generado ruta de Atención
				% } }else{ %>
					%=campo7%>
				% } %>
				</FONT>
			</CENTER>
		</td>-->
	</TR>
	</meve_front:ListaDatos>
</TBODY>
</table>
<% }else{ %>
<table border="0" width="863">
<TBODY>
	<TR>
		<TD><b><FONT size="3" color="#004080" face="Arial">** No se encontraron Registros **</FONT></b></TD>
	</TR>
</TBODY>
</table>
<% } %>
</DIV>
<% } %>
</DIV>
<BR>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
