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
	String at = "";
	String ac = "";
	String strTipo	=	request.getParameter("cls");
	String strDatos[][] = ActualizaExpArchivado.getExpedienteAtAc(strTipo);
		at		=	strDatos[0][0];
		ac		=	strDatos[0][1];
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
<TITLE>Detalle de Clasificacion</TITLE>
</HEAD>
<SCRIPT language="JavaScript" type="text/javascript">
function AtAc(at,ac) { 
	parent.window.document.getElementById('ano_AT').value = at;
	parent.window.document.getElementById('ano_AC').value = ac;
	}
</SCRIPT>
<BODY background="../Imagenes/fondo_claro.jpg" onload="AtAc(<%=at%>,<%=ac%>);">
<FORM name="ClasifDetalle" action="ClasifDetalle.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<input name="tmpCopyToRef" type="hidden" value="">
<input name="idsCC" type="hidden" value="">
<DIV align="center">
<TABLE width="100%" border="0">
<TBODY>
 <TR bgcolor="#00204f">
		<TD width="10%" align="center" colspan="7">
		<FONT size="2" color="white" face="verdana">DETALLE INSTRUMENTO</FONT>
		</TD>
 </TR>
	<TR bgcolor="#00204f">
		<TD width="15%" align="center">
			<b><FONT size="2" color="white" face="verdana">Fondo</FONT></b>
        </TD>
		<TD width="15%" align="center">
			<b><FONT size="2" color="white" face="verdana">Subfondo</FONT></b>
        </TD>
        <TD width="15%" align="center">
			<b><FONT size="2" color="white" face="verdana">Seccion</FONT></b>
        </TD>
        <TD width="15%" align="center">
			<b><FONT size="2" color="white" face="verdana">Serie</FONT></b>
        </TD>
        <TD width="15%" align="center">
			<b><FONT size="2" color="white" face="verdana">Subserie</FONT></b>
        </TD>
        <TD width="15%" align="center">
			<b><FONT size="2" color="white" face="verdana">Valoracion</FONT></b>
        </TD>
        <TD width="10%" align="center">
			<b><FONT size="2" color="white" face="verdana">Seleccion</FONT></b>
        </TD>
    </TR>
	<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosClasificacionDeta(strTipo) %>" campo="campo">
	<TR vAlign=top>
		<TD width="15%">
    		<FONT face=Arial color=#000080 size=1>
		   <%= campo7 %>
    		</FONT>
	   	</TD> 
		<TD width="15%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<%=campo5%>
			</FONT>
		</TD>
		<TD width="15%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<%=campo3%>
			</FONT>
		</TD>
		<TD width="15%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<%=campo6%>
			</FONT>
		</TD>
		<TD width="15%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<%=campo4%>
			</FONT>
		</TD>
		<TD width="15%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<%=campo1%>
			</FONT>
		</TD>
		<TD width="10%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<%=campo2%>
			</FONT>
		</TD>		
	</TR>
	</meve_front:ListaDatos>
	<TR vAlign=top>	
	<TD COLSPAN="7" align="center">
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
