
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*"
	import = "java.util.*"
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
<TITLE>Cargar Sisi</TITLE>
</HEAD>
<%
	Vector a = new Vector();
	String solicitud_sisi = request.getParameter("solicitud_sisi");
//	System.out.println ("Dato: " + solicitud_sisi );
	if(solicitud_sisi != null && !solicitud_sisi.equalsIgnoreCase(""))
    a.addElement(ActualizaArchivo.getCargaSisi(solicitud_sisi));
%>
<SCRIPT language=JavaScript type=text/javascript>

  function agregarContentS()
	{
		document.cargarSisi.submit();
	}
 function folios()
	{
	folio =<%=a.size()%>;
	if(folio > 0)
	{
<%for (int i=0; i< a.size();i++) {%>
		alert('Se insertaron los siguientes folios:<%=a.elementAt(i)%>');
			
<% }%>
	}
	}
</SCRIPT>
<BODY background="../Imagenes/fondo_claro.jpg" onload="folios();timer_load();"
	onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM 	action="CargarSisi.jsp" name="cargarSisi" 
		method="post">

<SCRIPT language=JavaScript type=text/javascript>
folios();
</SCRIPT>
<TABLE>
<TR valign="top">
		<TD width="183"><font size="2" color="#004080" face="Arial">Agregar archivo Sisi:</FONT></TD>
		<TD colspan="3"><input class="blue500" type="file"
			name="solicitud_sisi"></TD>
</TR>
<TR valign="top">
								<TD>
									&nbsp;
								</TD>
</TR>
<TR valign="top">
					<TD>
					&nbsp;
					</TD>
					<TD align="center">
						<INPUT type="button" class="blue200" value="Aceptar" onclick="agregarContentS();">
					</TD>
</TR>
</TABLE>
</FORM>
</BODY>
</html>
