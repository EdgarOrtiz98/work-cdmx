<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerCiudadano.jsp" flush="false"></jsp:include>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"
%>
<%
	BeanCiudadano BCiudadano = (BeanCiudadano)session.getAttribute("CiudadanoBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
	if(BCiudadano==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
	boolean bExiste = false;
	bExiste = ActualizaCiudadano.getExisteSolicitud(BCiudadano.getIdUsuario());
	int t = 0;
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
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<STYLE type="text/css">
</STYLE>
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<script language="JavaScript" type="text/javascript">

function goSolicitud(){
	location.assign('ConsultaCiudadano.jsp');
}
function goEditar(){
	location.assign('EditarDatos.jsp');
}
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY BGCOLOR="FFFFFF" background="../Imagenes/fondo_claro.jpg">
<FORM action="PortalCiudadano.jsp" name="formPortalCiu" method="post">
<INPUT type="hidden" value="guardar" name="accion">
<TABLE cellspacing="2" cellpadding="2">
	<TBODY>
		<TR>
			<TD class="dominoSelTopTab"><A onclick="goSolicitud()";>Ingresar una Solicitud nueva</A></TD>
			<TD class="dominoSelTopTab"><A onclick="goEditar()";>Editar mis datos</A></TD>
		</TR>
	</TBODY>
</TABLE>
<br>
<TABLE width="100%">
	<TBODY>
		<TR>
			<TD align="left" width="65%"><FONT size="2" color="red" face="Arial">
				Dar click al <b><u>Folio</u></b> para consultar Solicitud. Si tu Solicitud ha sido contestada, da click en <b><u>Tipo de Respuesta</u></b></FONT>
			</TD>
			<td align="right" width="35%"><B><FONT face="Verdana" color="#00204f" size="2">Historicos de Solicitudes</FONT></B></td>
		</TR>
	</TBODY>
</TABLE>
<TABLE width="100%" border="1">
	<TR bgcolor="00204F">
		<TD width="20%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Folio Solicitud</FONT></TD>
		<TD width="20%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Fecha de Solicitud</FONT></TD>
		<TD width="20%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Tipo de Respuesta</FONT></TD>
		<TD width="20%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Fecha de Respuesta</FONT></TD>
		<TD width="20%" align="center"><FONT size="2" color="FFFFFF"
			face="Arial">Estatus</FONT></TD>
	</TR>
</TABLE>
<DIV class="documentBody" id="Body">
<TABLE width="100%">
	<% if(bExiste){  %>
	<meve_front:ListaDatos datos="<%= ActualizaCiudadano.getDatosCiudadanoPortal(BCiudadano.getIdUsuario()) %>" campo="campo">
	<% t++; %>
	<%
		boolean existe = ActualizaCiudadano.getExistenNotificaciones(campo7);
	%>
	<TR valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<TD width="20%" align="left">
			<FONT size="2" color="#00204f" face="Arial">
				<a href="seguimiento.jsp?id_solicitud=<%=campo1%>"><%=campo3%></a>
			</FONT>
		</TD>
		<TD width="20%" align="center">
			<FONT size="2" color="#00204f" face="Arial"><%=campo4%></FONT>
		</TD>
		<TD width="20%" align="center">
			<FONT size="2" color="#00204f" face="Arial">
			<% 
				if(existe){
					String strNotificaciones[][] = null;
					strNotificaciones = ActualizaCiudadano.getDatosNotificacion(campo7);
					String strTipoRespuesta = "";

					if(strNotificaciones!=null && strNotificaciones.length>0 && strNotificaciones[0].length>=5){
						strTipoRespuesta=strNotificaciones[0][4];
					}

					if(strTipoRespuesta.length()!=0){
			%> 
			<a href="DetalleRespuesta.jsp?id_solicitud=<%=campo7%>"><%= ActualizaTipoRespuesta.getNombreTipoRespuesta(strTipoRespuesta)[0][0] %></a>
			<% 
					}else{ 
						%>
							--
						<%
					}

			   }else{ %>
			Sin Respuesta
			<% } %>
			</FONT>
		</TD>
		
		<TD width="20%" align="center">
			<% 
				if(existe){
					String strNotificaciones[][] = null;
					strNotificaciones = ActualizaCiudadano.getDatosNotificacion(campo7);
					String strFechaRespuesta = "--";
					if(strNotificaciones!=null && strNotificaciones.length>0 && strNotificaciones[0].length>=4){
						strFechaRespuesta = strNotificaciones[0][3];
					}
					
			%>
			<FONT size="2" color="#00204f" face="Arial"><%=strFechaRespuesta%></FONT>
			<% }else{ %>
			<FONT size="2" color="#00204f" face="Arial">--</FONT>
			<% } %>
		</TD>
		<TD width="20%" align="center">
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
