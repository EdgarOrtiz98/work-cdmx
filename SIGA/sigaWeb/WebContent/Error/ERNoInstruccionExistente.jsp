<jsp:include page="headerE.jsp" flush="false"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>ERNoAccesoInstruccion.jsp</TITLE>
<script type="text/javascript">
function retorno(){
	location.assign("<%=retURI%>");
}
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
} 
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM name="formError">
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
<CENTER>
<TABLE border="1">
	<TBODY>
		<TR>
			<TD align="center"><FONT face="Verdana" color="red" size="2">
			<b>LA INSTRUCCIÓN A LA QUE QUIERE ACCESAR YA NO EXISTE, ES POSIBLE QUE HAYA SIDO RECUPERADA POR LA VENTANILLA ORIGEN</b>
			</FONT>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</CENTER>
<BR><BR>
<CENTER>
<TABLE border="0">
	<TBODY>
		<TR>
			<TD align="center">
				<INPUT name="regresar" type="button" class="blue100" value="Regresar" onclick="retorno();">
			</TD>
		</TR>
	</TBODY>
</TABLE>
</CENTER>
</FORM>
</BODY>
</HTML>
