<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerCiudadano.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.util.*"
%>
<%
	String strIdSolicitud = "";
	strIdSolicitud 	=	(request.getParameter("id_solicitud") != null)?request.getParameter("id_solicitud"):"";
	BeanCiudadano BCiudadano = (BeanCiudadano)session.getAttribute("CiudadanoBean");
	String strTmp=request.getRequestURI();
//	//System.out.println("strTMP-->"+strTmp);
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
//	//System.out.println("strTMP-->"+strTmp);
	if(BCiudadano==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp+"?id_solicitud="+strIdSolicitud);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	} 
	//System.err.println("BusarioNombre-->"+BCiudadano.getNombre());
%>
<%
	
	String strIdAsunto = "";
	String strGetSolicitus[][] = null;
	String strGetFechaVen[][] = null;
	String strFechaHora		=	"";
	String strFechaVen		=	"";
	int k = 0;
	

	if(strIdSolicitud != null && strIdSolicitud.length() > 0){
		strGetSolicitus = ActualizaCiudadano.getDatosCiudadanoDetalle(strIdSolicitud);
		strIdAsunto = strGetSolicitus[0][6];
		strFechaHora = strGetSolicitus[0][8];

		strGetFechaVen = ActualizaAsunto.getAsuntos(strIdAsunto);
		strFechaVen = strGetFechaVen[0][15];
		
		if(strFechaHora.length()>3){
			strFechaHora = strFechaHora.substring(0, strFechaHora.length()-2);
		}
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
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<TITLE>seguimiento.jsp</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
	function ImprPDF(){
		window.open("../Report?id_sol="+<%=strIdSolicitud%>);
	}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM action="seguimiento.jsp" name="seguimientoForm" method="post">
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
				<a onclick="ImprPDF();"><IMG border="0" src="../Imagenes/Imprimir.gif" width="32"
				height="32"></a>
			</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="268"></TD>
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
			Seguimiento</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="420">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#00204f" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>
<br>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR VALIGN=top>
		<!-- <TD width="200"><IMG border="0" src="../Imagenes/logoPortal.jpg"
				width="145" height="116"></TD>-->
		<TD width="200"><IMG border="0" src="../Imagenes/issste.jpg"
				width="145" height="150"></TD>
		<TD width="400" align="center"><b><font size="2" color="#004080" face="Arial"><br><br><br><br>
				Solicitud de Acceso a la información Pública<br>
				del Gobierno del Estado de Baja California</FONT></b></TD>
		<TD width="286" align="right"><br><br><br><br><br><br>
			<FONT SIZE=2 FACE="Verdana">
			<u><b><%=strGetSolicitus[0][2]%></b></u><br>
			No. de Solicitud
			</FONT>
		</TD>
	</TR>
</TBODY>
</table>	
</DIV>
<br>
<BR>
<BR>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR VALIGN=top>
		<TD width="300">
			<b><font size="2" color="#004080" face="Arial">
			DATOS DEL SOLICITANTE</font></b>
		</TD>
		<TD width="300">&nbsp;</TD>
		<TD width="286" align="right">&nbsp;</TD>
	</TR>
</TBODY>
</table>	
</DIV>
<br>
<br>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR VALIGN=top>
		<TD width="300">
			<b><font size="2" color="#004080" face="Arial">
			Nombre/Razón Social:</font></b>
		</TD>
		<TD width="300"><FONT SIZE=2 FACE="Verdana">
		<%=BCiudadano.getNombre()+" "+BCiudadano.getApellidoPaterno()+" "+BCiudadano.getApellidoMaterno()%>
		</FONT></TD>
		<TD width="286" align="right">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="300">&nbsp;</TD>
		<TD width="300">&nbsp;</TD>
		<TD width="286">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="300">
			<b><font size="2" color="#004080" face="Arial">
			Domicilio:</font></b>
		</TD>
		<TD width="300"><FONT SIZE=2 FACE="Verdana">
		<%=BCiudadano.getDomicilio()%>
		</FONT></TD>
		<TD width="286" align="right">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="300">&nbsp;</TD>
		<TD width="300">&nbsp;</TD>
		<TD width="286">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="300">
			<b><font size="2" color="#004080" face="Arial">
			País:</font></b>
		</TD>
		<TD width="300"><FONT SIZE=2 FACE="Verdana">
		<%=BCiudadano.getPais()%>
		</FONT></TD>
		<TD width="286" align="right">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="300">&nbsp;</TD>
		<TD width="300">&nbsp;</TD>
		<TD width="286">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="300">
			<b><font size="2" color="#004080" face="Arial">
			Estado:</font></b>
		</TD>
		<TD width="300"><FONT SIZE=2 FACE="Verdana">
		<%=BCiudadano.getEstado()%>
		</FONT></TD>
		<TD width="286" align="right">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="300">&nbsp;</TD>
		<TD width="300">&nbsp;</TD>
		<TD width="286">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="300">
			<b><font size="2" color="#004080" face="Arial">
			Municipio:</font></b>
		</TD>
		<TD width="300"><FONT SIZE=2 FACE="Verdana">
		<%=BCiudadano.getMunicipio()%>
		</FONT></TD>
		<TD width="286" align="right">&nbsp;</TD>
	</TR>
</TBODY>
</table>	
</DIV>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<td width="301">&nbsp;</td>
		<td width="251"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="170"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="163"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<td width="301"><b><font size="2" color="#004080" face="Arial">Correo Electrónico:</font></b>
		</td>
		<td width="251"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getMail()%></font>
		</td>
		<td width="170"><b><font size="2" color="#004080" face="Arial">Telefono:</font></b>
		</td>
		<td width="163"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getTelefono()%></font><br></td>
	</TR>
	<TR valign="top">
		<td width="301">&nbsp;</td>
		<td width="251"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="170"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="163"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<td width="301"><b><font size="2" color="#004080" face="Arial">Ocupación:</font></b>
		</td>
		<td width="251"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getOcupacion()%></font>
		</td>
		<td width="170"><b><font size="2" color="#004080" face="Arial">Sector:</font></b>
		</td>
		<td width="163"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getSector()%></font><br></td>
	</TR>
	<TR valign="top">
		<td width="301">&nbsp;</td>
		<td width="251"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="170"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="163"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TBODY>
</table>
</DIV>
<BR><BR><BR>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR VALIGN=top>
		<TD width="300">
			<b><font size="2" color="#004080" face="Arial">
			INFORMACIÓN QUE SOLICITA</font></b>
		</TD>
		<TD width="300">&nbsp;</TD>
		<TD width="286" align="right">&nbsp;</TD>
	</TR>
</TBODY>
</table>	
</DIV>
<BR><BR>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR VALIGN=top>
		<TD width="884">
		<font size="2" color="#004080" face="Arial"><%=strGetSolicitus[0][7]%></font></TD>
	</TR>
</TBODY>
</table>	
</DIV>
<br><br><br><br>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR VALIGN=top> 
		<TD width="450">
			<b><font size="2" color="#004080" face="Arial">
			Fecha y Hora de Recepción:</font></b>&nbsp;&nbsp;&nbsp;<u><%=strFechaHora%></u>
		</TD>
		<TD width="99">&nbsp;</TD>
		<TD align="right" width="337"></TD>
	</TR>
	<TR VALIGN=top> 
		<TD width="450">
			&nbsp;
		</TD>
		<TD width="99">&nbsp;</TD>
		<TD align="right" width="337">&nbsp;</TD>
	</TR>
</TBODY>
</table>	
</DIV>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR VALIGN=top> 
		<TD width="549">
			<font size="2" FACE="Arial">
			Le Recordamos que el termino para atender su solicitud es de 10 días por lo que<br>
			sugerimos que con su usuario y contraseña de seguimiento de a partir del <u><%=Utilerias.formatearFechas(strFechaVen)%></u> 
			</font>
		</TD>
		
	</TR>
</TBODY>
</table>
</DIV>
<br><br><br><br><br><br>
</FORM>
</BODY>
</HTML>
