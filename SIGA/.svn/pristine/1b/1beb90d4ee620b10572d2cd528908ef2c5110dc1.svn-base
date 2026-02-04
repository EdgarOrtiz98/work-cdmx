<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
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
	String strIds_Borrar[]	=	null;
	String strAccion		=	"";
	int t = 0;
	strAccion				=	request.getParameter("accion");
	strIds_Borrar			=	request.getParameterValues("Borrar");
	bExiste					=	ActualizaClasificacion.getExiste();	
	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
	{
		bOperacion	=	ActualizaClasificacion.getDeleteClasificacion(strIds_Borrar);	
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
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Clasificacion Asunto</TITLE>
<SCRIPT language="JavaScript" src="../js/GeneralFunctions.js"></SCRIPT>
<script language="JavaScript" type="text/javascript">
	function cambio(o, t){
		doc = document.ClaView;
		doc.accion.value="reload";
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="ClasificacionAsuntoView.jsp" name="ClaView" method="get">
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
	<TR>
		<TD width="43%">
			<A href="ClasificacionAsunto.jsp">
				<IMG height="26" src="../Imagenes/Nuevo.gif" width="27" border="0"></A>
				<FONT face="Tahoma" size="2">
				</FONT>
				<A href="javascript:Borrar()" target="_self">
				<IMG border="0" src="../Imagenes/borrar2.gif" width="30" height="27"></A>
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
		<TD width="50%" align="center">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Clasificación de Asuntos</FONT></b>
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
        </TD>
		<TD width="50%" align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Fecha de Creación</FONT></b>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
        </TD>
    </TR>
</TBODY>
</TABLE>
<DIV id="msg"></DIV>
<DIV id="view">
<TABLE width="100%" border="0">
<TBODY>
	<TR valign="top">
		<TD nowrap>&nbsp;
			<FONT face="Arial" color="#000080" size="2"> </FONT>
		</TD>
	</TR>
    <TR>
    	<TD nowrap></TD>
	</TR>
	<% if(bExiste){ %>
	<meve_front:ListaDatos datos="<%= ActualizaClasificacion.getListaClasificacion(strOrden, strTipo) %>" campo="campo">
	<% if(BUsuario.getAdmon()){ %>
	<% t++; %>
	<TR vAlign=top <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<TD width="50%">
    		<INPUT type=checkbox value="<%= campo1 %>" name="Borrar">
    		<FONT face=Arial color=#000080 size=1>
		    <A href="ClasificacionAsunto.jsp?id_cla=<%= campo1 %>"><%= campo2 %></A>
    		</FONT>
	   	</TD> 
		<TD width="50%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<%=campo3%>
			</FONT>
		</TD>
	</TR>
	<% } %>
	</meve_front:ListaDatos>
	<% } else { %>
	<TR> 
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">******No Hay Clasificación de asuntos capturados******</FONT>
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
