<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.util.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}

%>
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERUsuarioInvalido.jsp"></jsp:forward>
<% } %>
<%
		boolean bOperacion = false;
		String strIds_Borrar[] = null;
		String strAccion = "";
		boolean bexiste = false;
		bexiste = ActualizaEstatus.existenEstatus();
		int t = 0;
		strAccion = request.getParameter("accion");
		strIds_Borrar = request.getParameterValues("Borrar");
		if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
			bOperacion = ActualizaEstatus.getDeleteEstatus(strIds_Borrar);
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
<TITLE>Estatus</TITLE>
<SCRIPT language="JavaScript" src="../js/GeneralFunctions.js"></SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="estatusViewForm" action="EstatusView.jsp" method="post">
<INPUT type="hidden" name="accion" size="20">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="43%"><A href="Estatus.jsp" target="_self"> <IMG
				height="26" src="../Imagenes/Nuevo.gif" width="27" border="0"
				title="Nuevo Tipo de Respuesta"> </A> <FONT face="Tahoma" size="2"></FONT> <A
				href="javascript:Borrar()" target="_self"><IMG border="0"
				src="../Imagenes/borrar2.gif" width="30" height="27"
				title="Borrar Tipo de Respuesta"></A></TD>
			<TD width="57%">
			<DIV align="right"><IMG border="0" src="../Imagenes/flech_cal1.gif"
				width="11" height="9"> <IMG border="0"
				src="../Imagenes/flech_cal.gif" width="11" height="9"> &nbsp; <IMG
				border="0" src="../Imagenes/masbien.gif" width="20" height="20"> <IMG
				border="0" src="../Imagenes/menosbien.gif" width="20" height="20"></DIV>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="100%" bgcolor="#002060"></TD>
		</TR>
	</TBODY>
</TABLE>
<BR>
<TABLE width="100%" border="0">
	<TBODY>
		<TR bgcolor="#00204f">
			<TD width="70%">
			<CENTER><FONT size="2" face="verdana" color="white">Nombre del Estatus</FONT></CENTER>
			</TD>
			<TD width="30%">
			<CENTER><FONT size="2" face="verdana" color="white">Fecha de Registro</FONT></CENTER>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV id="msg"></DIV>
<DIV id="view"><BR>
<% int j=0; %>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
	<% if(bexiste){ %>
	<meve_front:ListaDatos datos="<%= ActualizaEstatus.getEstatus() %>"
		campo="Lista">
	<% if(	BUsuario.getAdmon() ||
			BUsuario.getSupervisor()){ %>
		<% t++; %>
		<TR valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
			<TD width="100%">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="70%"><INPUT type=checkbox value="<%=Lista1 %>"
						name="Borrar"> <IMG height=1 src="../Imagenes/ecblank.gif"
						width=16 border=0><FONT face=Arial color=#000080 size=1>
						<A href="Estatus.jsp?id_estatus=<%=Lista1%>"><%=Lista2%></A>
					</FONT></td>
					<td width="2%">&nbsp;</td>
					<td width="28%"><%=Lista4%></td>
				</tr>
			</table>
			</TD>
		</TR>
	<% j++; %>
	<% } %>
	</meve_front:ListaDatos>
	<% if(j==0){ %>
	<TR>
		<TD width="100%">
		<div align=center><FONT face="verdana" size="4">******No hay Estatus capturados ******</FONT></div>
		</TD>
	</TR>
	<% } %>
	<% }else{ %>
	<tr>
		<TD width="100%">
		<div align=center><FONT face="verdana" size="4">******No hay Estatus capturados ******</FONT></div>
		</TD>
	</tr>
	<% } %>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>
