<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.util.*,com.meve.sigma.beans.search.*"
%>
<%
	boolean bExiste = false;
	bExiste = ActualizaCiudadano.getExisteSolicitud();
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<STYLE type="text/css">
</STYLE>
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY BGCOLOR="FFFFFF" background="../Imagenes/fondo_claro.jpg">
<FORM action="Consulta.jsp" name="formCon" method="post">
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
<TABLE width="100%">
	<TBODY>
		<TR>
			<TD align="left" width="65%"><FONT size="2" color="red" face="Arial">
				</FONT>
			</TD>
			<td align="right" width="35%"><B><FONT face="Verdana" color="#00204f" size="2">Historicos de Solicitudes</FONT></B></td>
		</TR>
	</TBODY>
</TABLE>
<DIV class=documentBody id=Body>
<TABLE width="100%" border="1">
	<TR bgcolor="00204F">
		<TD width="15%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Folio Solicitud</FONT></TD>
		<TD width="15%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Fecha de Solicitud</FONT></TD>
		<TD width="20%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Tipo de Respuesta</FONT></TD>
		<TD width="15%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Fecha de Respuesta</FONT></TD>
		<TD width="15%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Estatus</FONT></TD>
		<TD width="10%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Unidad Ejecutora</FONT></TD>
		<TD width="10%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Unidad Informativa</FONT></TD>
	</TR>
	<% if(bExiste){ %>
	<meve_front:ListaDatos datos="<%= ActualizaCiudadano.getDatosCiudadanoPortal() %>" campo="campo">
	<%
		boolean existe = ActualizaCiudadano.getExistenNotificaciones(campo7);
	%>
	<TR>
		<TD width="15%" align="left">
			<FONT size="2" color="#00204f" face="Arial">
				<a href="seguimiento.jsp?id_solicitud=<%=campo1%>"><%=campo3%></a>
			</FONT>
		</TD>
		<TD width="15%" align="center">
			<FONT size="2" color="#00204f" face="Arial"><%=Utilerias.formatearFechas(campo4)%></FONT>
		</TD>
		<TD width="20%" align="center">
			<FONT size="2" color="#00204f" face="Arial">
			<% 
				if(existe){
					String strNotificaciones[][] = null;
					strNotificaciones = ActualizaCiudadano.getDatosNotificacion(campo7);
					String strTipoRespuesta = "";

					//if(strNotificaciones!=null && strNotificaciones.length>0 && strNotificaciones[0].length>=5){
					//	strTipoRespuesta=strNotificaciones[0][4];
					//}
					if(strNotificaciones.length == 0){
			%>			
					--
			<%
					}else{
			%> 
			<a href="DetalleRespuesta.jsp?id_solicitud=<%=campo7%>"><%= ActualizaTipoRespuesta.getNombreTipoRespuesta(strNotificaciones[0][4])[0][0] %></a>
			<% 
					}

			   }else{ %>
			--
			<% } %>
			</FONT>
		</TD>
		
		<TD width="15%" align="center">
			<% 
				if(existe){
					String strNotificaciones[][] = null;
					strNotificaciones = ActualizaCiudadano.getDatosNotificacion(campo7);
					//String strFechaRespuesta = "--";
					//if(strNotificaciones!=null && strNotificaciones.length>0 && strNotificaciones[0].length>=4){
					//	strFechaRespuesta = strNotificaciones[0][3];
					//}
					if(strNotificaciones.length == 0){
			%>
			--
			<% }else{ %>
			<FONT size="2" color="#00204f" face="Arial"><%=strNotificaciones[0][3]%></FONT>
			<% } %>
			
			<% }else{ %>
			<FONT size="2" color="#00204f" face="Arial">--</FONT>
			<% } %>
		</TD>
		<TD width="15%" align="center">
			<%  
				if(existe){
					String strNotificaciones[][] = null;
					//String strAreasAtencion[][] = null;
					//strAreasAtencion = ActualizaBuscar.getAreasAtencion(campo7);
					strNotificaciones = ActualizaCiudadano.getDatosNotificacion(campo7);
					
					if(strNotificaciones==null){
						strNotificaciones = new String[0][0];
					}

					if(strNotificaciones.length==0){
						%>
							<FONT size="2" color="#00204f" face="Arial">
							--
							</FONT>
			<%
					}
					for(int i = 0;i<strNotificaciones.length;i++){
			%>
			<FONT size="2" color="#00204f" face="Arial">
				<%=ActualizaEstatus.getNombreEstatus(strNotificaciones[i][6])[0][0]%><br>
			</FONT>
			<% }}else{ %>
			<FONT size="2" color="#00204f" face="Arial">--</FONT>
			<% } %>
		</TD>
		<TD width="10%" align="center">
			<FONT size="1" color="#000080" face="verdana">
				<%
					String strAreasAtencion[][] = null;
					strAreasAtencion = ActualizaBuscar.getAreasAtencionEjecutora(campo7);
					if(strAreasAtencion.length > 0){
						for(int r = 0;r<strAreasAtencion.length;r++){
				%>
					<%=ActualizaArea.NombreArea(strAreasAtencion[r][0])%><br>
					<% }}else{ %>
					--
				<% }  %>
				
			</FONT>
		</TD>
		<TD width="10%" align="center">
			<FONT size="1" color="#000080" face="verdana">
				<%
					String strAreasAtencion1[][] = null;
					strAreasAtencion1 = ActualizaBuscar.getAreasAtencionInformativa(campo7);
					if(strAreasAtencion.length > 0){
						for(int z = 0;z<strAreasAtencion1.length;z++){
				%>
					<%=ActualizaArea.NombreArea(strAreasAtencion1[z][0])%><br>
					<% }}else{ %>
					--
				<% }  %>
				
			</FONT>
		</TD>
	</TR>
	</meve_front:ListaDatos>
	<% }else{ %>
	<tr>
		<TD width="100%" align="center">
			<b><FONT size="2" color="#00204f" face="Arial">
			** No tiene Solicitudes Registradas **
			</FONT></b>
		</TD>
	</tr>
	<% } %>
</TABLE>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
