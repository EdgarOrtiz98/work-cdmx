<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerCiudadano.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"
%>
<%
	String strIdNotificacion = "";
	String strIdSol	= "";
	strIdNotificacion = request.getParameter("id_not");
	strIdSol = request.getParameter("id_solicitud");
	BeanCiudadano BCiudadano = (BeanCiudadano)session.getAttribute("CiudadanoBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
	if(BCiudadano==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp+"id_not="+strIdNotificacion+"&id_solicitud="+strIdSol);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
%>
<%
	String strCM = application.getInitParameter("content");
	String strItemType  =  (application.getInitParameter("ItemType")==null)?"":application.getInitParameter("ItemType");
	String strActivarCM 		= 	application.getInitParameter("ActivarContent");
	String server	=	application.getInitParameter("servername");


//	//System.out.println("idSol="+strIdSol);
	String getDetalle[][] = null;
	if(strIdSol != null && strIdSol.length() > 0){
		getDetalle = ActualizaCiudadano.getDatosNot(strIdSol);
	}
	boolean bCerrar = false;
	bCerrar = ActualizaCiudadano.getCerrar(strIdSol);
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
<TITLE>DetalleRespuesta.jsp</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
	
	function responder(){
		location.assign('Responder.jsp?id_solicitud=<%= strIdSol %>');
	}
	
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg">
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
			<TD width="125"><a href="PortalCiudadano.jsp"> <IMG
				border="0" src="../Imagenes/Regresar.gif" width="82" height="26"> </a>
			</TD>
			<TD width="125">
				<% if(!bCerrar){ %>
				<INPUT type="button" class="blue100" value="Responder" onclick="responder()">
				<% } %>
			</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="305"></TD>
		</TR>
		<TR valign="top">
			<TD></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="#004080" size="2">
			Detalle de la Notificación</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="451">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#00204f" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<% for(int i=0;i<getDetalle.length;i++){ %>
	<TR VALIGN=top>
		<TD width="23"><IMG border="0" src="../Imagenes/expand.gif"
				width="16" height="16"></TD>
		<TD width="906">
			<font size="2" color="#004080" face="Arial">
			<%
				String strRespondio = "";
				if(getDetalle[i][4].equals("1")){
					strRespondio = "SIGMA";
				}else{
					strRespondio = "Ciudadano";
				}
			%>
			<%=getDetalle[i][1]%>(<%=strRespondio%>)
			
			</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="23">&nbsp;</TD>
		<TD width="906">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="23"><b><font size="2" color="#004080" face="Arial"></FONT></b></TD>
		<TD width="906">
			<font size="2" color="#004080" face="Arial">
			<% if(getDetalle[i][2].length() > 0){ %>
			<%=ActualizaTipoRespuesta.getNombreTipoRespuesta(getDetalle[i][2])[0][0]%>
			<% } %>
			</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="23">&nbsp;</TD>
		<TD width="906">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="23"><b><font size="2" color="#004080" face="Arial"></FONT></b></TD>
		<TD width="906">
		<font size="2" color="#004080" face="Arial">
			<%=getDetalle[i][0]%><br>
			-------------------------------------------------------------------------
			</FONT>
		</TD>
	</TR>
	<% } %>
</TBODY>
</table>
</DIV>
<br><br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="#004080" size="2">
			Documentos Anexados</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="451">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#00204f" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="451">&nbsp;</TD>
		</TR>
		
		<TR VALIGN=top>
			<TD colspan="3">
				<div>
					<% if(strActivarCM.equals("si")){ %>
					<IFRAME ID="frame1" SRC="<%= strCM %>/eclient/SIGMA/Buscar.jsp?id=<%=strIdSol%>&bo=false&it=<%=strItemType%>" WIDTH="800" HEIGHT="200" frameborder=0></IFRAME>
					<% }else{ %>
					<IFRAME ID="frame1" SRC="../jsp/ImportarAR.jsp?IdAsunto=<%=strIdSol%>&bo=false" WIDTH="650" HEIGHT="200" frameborder=0></IFRAME>
					<% } %>
					
				</div>
			</TD>
		</TR> 
	</TBODY>
</TABLE>
</DIV>

</BODY>
</HTML>
