<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>  
<HTML>
<HEAD>
<TITLE>Ruta Automatica</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>  
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*"%>
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
	String [][] sql	=null;
	boolean bOperacion		=	false;
	String strIds_Borrar[]	=	null;
	int t = 0;
	String strAccion		=	"";
	strAccion				=	request.getParameter("accion");
	strIds_Borrar			=	request.getParameterValues("Borrar");
	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
	{
		bOperacion	=	ActualizaFlujo.deleteFlujo(strIds_Borrar,BUsuario.getIdUsuario());
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
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">

<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT language="JavaScript" src="../js/GeneralFunctions.js"></SCRIPT>
<script language="JavaScript" type="text/javascript">
	function cambio(o, t){
		doc = document.FlujoAtencionView;
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
<span id="ruler" style="visibility:hidden;"></span> 
<FORM action="FlujoAtencionView.jsp" name="FlujoAtencionView" method="post">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="orden" value="">
<INPUT type="hidden" name="tipo" value="">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="100%" colspan="2"></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR>
			<TD width="43%"><A href="FlujoAtencion.jsp" target="_self"> <IMG
				height="26" src="../Imagenes/Nuevo.gif" width="27" border="0" title="Nueva Ruta Automática"></A> <FONT
				face="Tahoma" size="2"></FONT> <A href="javascript:Borrar()"
				target="_self"> <IMG border="0" src="../Imagenes/borrar2.gif"
				width="30" height="27" title="Borrar Ruta Automática"></A></TD>
			<TD width="57%" align="right" valign="bottom">
			<IMG
				border="0" src="../Imagenes/masbien.gif" width="20" height="20"> <IMG
				border="0" src="../Imagenes/menosbien.gif" width="20" height="20">
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE width="100%" border="0">
	<TBODY>
		<TR bgcolor="#00204f">
			<TD id="Asunto_HD" width="50%" align="center">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Ruta	Automatica</FONT></b>
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD width="50%" align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Id del Documento</FONT></b>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV class=documentBody id=Body>
<DIV id="view"><BR>
<% int j = 0; %>
<TABLE width="100%">
	<TBODY>
		<TR valign="top">
			<TD nowrap>&nbsp;<FONT face="Arial" color="#000080" size="2"></FONT>
			</TD>
		</TR>
		<TR>
			<TD nowrap></TD>
		</TR>
		<%sql=ActualizaFlujo.getListaFlujos(strOrden, strTipo);%>
		<%if(sql==null){%>
		<TR>
			<TD width="100%">
			<div align=center><FONT face="verdana" size="4">******No Hay Rutas
			Automaticas capturadas******</FONT></div>
			</TD>
		</TR>
		<%}else {%> 
		<meve_front:ListaDatos datos="<%= sql %>" campo="campo">
		<% if(	BUsuario.getAdmon() ||
				BUsuario.getIdArea().equals(campo3)){ %>
		<% t++; %>
			<TR vAlign=top <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
				<TD width="50%"><INPUT type=checkbox value="<%=campo2%>"
					name="Borrar"><FONT face=Arial color=#000080 size=1> <A	href="FlujoAtencion.jsp?id_flujo=<%=campo2%>" title="<%=campo1%>">
					<script> document.write(trunc('<%=campo1%>','Asunto_HD'));</script></A> </FONT>
				</TD>
				<TD width="50%" align="center"><FONT face=Arial color=#000080 size=1> <%=campo2%> </FONT>
				</TD>
			</TR>
		<% j++; %>
		<% } %>
		</meve_front:ListaDatos>
		<% } %>
		<% if(j==0){ %>
		<TR>
			<TD width="100%">
			<div align=center><FONT face="verdana" size="4">******No hay Rutas Automaticas
			Capturados en su Unidad Administrativa ******</FONT></div>
			</TD>
		</TR>
		<% } %>
	</TBODY>
</TABLE>
</DIV>
<BR>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
