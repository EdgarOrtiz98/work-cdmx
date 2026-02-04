<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML> 
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
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
	boolean bExiste			=	false;
	boolean bOperacion		=	false;
	int bOperacion1		=	0;	
	String strIds_Borrar[]	=	null;
	String strAccion		=	"";
	String msg				=	request.getParameter("msg");	
	int t = 0;
	strAccion				=	request.getParameter("accion");
	strIds_Borrar			=	request.getParameterValues("Borrar");

	bExiste					=	ActualizaExpArchivado.getExisteSubSer();	

	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
	{
		bOperacion1	=	ActualizaExpArchivado.getDeleteSer(strIds_Borrar,BUsuario.getIdUsuario());
			if(bOperacion1 == 2)
			{
			msg ="Existen registros asociados, el proceso de borrado no fue exitoso";
			}
	}
	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
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
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Subserie</TITLE>
<SCRIPT language="JavaScript" src="../js/GeneralFunctions.js"></SCRIPT>
<script language="JavaScript" type="text/javascript">
	function cambio(o, t){
		doc = document.subsviewA;
		doc.accion.value="reload";
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
	function validaReg() { 
		<%if(msg!= null && msg.trim().length()>0)
		{
		%>
		alert("<%=msg%>");
		<%
		}
		%>
	}	
</script>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="validaReg();timer_load();" 
	onKeyPress="timer_reload();" 
	onClick="timer_reload();">
<FORM action="SubseriesArchview.jsp" name="subsviewA" method="post">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="orden" value="">
<INPUT type="hidden" name="tipo" value="">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY>
	<TR valign="top">
		<TD width="100%" colspan="2"></TD>
    </TR>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY>
	<TR valign="top">
		<TD width="43%">
			<A href="SubserieArch.jsp">
				<IMG height="26" title="Agregar Subserie" src="../Imagenes/Nuevo.gif" width="27" border="0"></A>
				<FONT face="Tahoma" size="2">
				</FONT>
				<A href="javascript:Borrar()">
				<IMG border="0" title="Borrar Subserie" src="../Imagenes/borrar2.gif" width="30" height="27">
				</A>
		</TD>
		<TD width="57%" align="right" valign="bottom">
				<IMG border="0" src="../Imagenes/masbien.gif" width="20" height="20">
				<IMG border="0" src="../Imagenes/menosbien.gif" width="20" height="20">
        </TD>
    </TR>
</TBODY>
</TABLE>
<TABLE width="100%" border="0">
<TBODY>
	<TR bgcolor="#00204f">
		<TD width="25%" align="center">
            <IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10">
			<b><FONT size="2" color="white" face="verdana">Nombre Subserie</FONT></b>
			<IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10">
        </TD>
		<TD width="25%" align="center">
			<IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10">
			<b><FONT size="2" color="white" face="verdana">Descripcion</FONT></b>
			<IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10">
        </TD>
        <TD width="25%" align="center">
			<IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10">
			<b><FONT size="2" color="white" face="verdana">Serie</FONT></b>
			<IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10">
        </TD>
        <TD width="25%" align="center">
			<IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10">
			<b><FONT size="2" color="white" face="verdana">Clave</FONT></b>
			<IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10">
        </TD>        
    </TR>
</TBODY>
</TABLE>
<DIV id="msg"></DIV>
<DIV id="view">
<TABLE width="100%" border="0">
<TBODY>
	<% if(bExiste){ %>
	<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosSubSerieA(strOrden, strTipo) %>" campo="campo">
	<% if(BUsuario.getAdmon()){ %>
	<% t++; %>
	<TR vAlign=top <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<TD width="25%">
    		<INPUT type=checkbox value="<%= campo1 %>" name="Borrar">
    		<FONT face=Arial color=#000080 size=1>
		    <A href="SubserieArch.jsp?id_sub=<%= campo1 %>"><%= campo2 %></A>
    		</FONT>
	   	</TD> 
		<TD width="25%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<%=campo3%>
			</FONT>
		</TD>
		<TD width="25%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<%=campo4%>
			</FONT>
		</TD>
		<TD width="25%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<%=campo5%>
			</FONT>
		</TD>		
	</TR>
	<% } %>
	</meve_front:ListaDatos>
	<% } else { %>
	<TR> 
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">******No Hay Subseries capturados******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
</TBODY>
</TABLE>
</DIV>
<BR>

</FORM>
</BODY>
</HTML>
