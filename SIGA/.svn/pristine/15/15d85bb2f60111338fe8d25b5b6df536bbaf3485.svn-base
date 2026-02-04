<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*"
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
	String strVal = "";
	String strTipo	=	(request.getParameter("cls")!= null)?request.getParameter("cls"):"0";

   	String var[][] =	ActualizaExpArchivado.getDatosValorDeta(strTipo);
	if (var.length >0) 
	{
		strVal = var[0][0];
	}
	else 
	{
	strVal = "0";
	}
	////System.out.println("IMPRIMIENDO----------"+strVal);

%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/link.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript" src="../js/link.js"></script>
<TITLE>Detalle Valoración</TITLE>
</HEAD>
<SCRIPT language="JavaScript" type="text/javascript">
function Consec(con) { 

	}
</SCRIPT>
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM name="DetalleValor" action="DetalleValor.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<input name="tmpCopyToRef" type="hidden" value="">
<input name="idsCC" type="hidden" value="">
<DIV align="center">
<TABLE width="100%" border="0">
<TBODY>
 <TR bgcolor="#00204f">
		<TD width="10%" align="center" colspan="5">
		<FONT size="2" color="white" face="verdana">DETALLE VALORACION</FONT>
		</TD>
 </TR>
	<TR bgcolor="#00204f">
        <TD width="20%" align="center">
			<b><FONT size="2" color="white" face="verdana">Valores</FONT></b>
        </TD>

    </TR>
	<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosValorDeta2(strVal) %>" campo="campo">
	<TR vAlign=top>
		<TD width="20%">
    		<FONT face=Arial color=#000080 size=1>
		   <%= campo1 %>
    		</FONT>
	   	</TD> 

	</TR>
	</meve_front:ListaDatos>
	<TR vAlign=top>	
	<TD COLSPAN="5" align="center">
	<input type="button"
				onclick="parent.window.document.getElementById('pop9').style.visibility='hidden';"
				value=" Cancel" class="blue100">
	</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>

