<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"
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
	String strIdEstatus		 	=	"";
	String strNombreEstatus		=	"";
	String strCerrar			=	"";
	String strFecha				=	"";
	String strUsuario			=	"";
	String strAccion			=	"";
	
	strAccion		=	request.getParameter("accion");
	strIdEstatus	=	(request.getParameter("id_estatus") != null)?request.getParameter("id_estatus"):"";
	
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f = new java.util.Date();
	strFecha = sdf.format(f);

	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			strNombreEstatus = request.getParameter("nombre_estatus");  
			strCerrar		=	request.getParameter("fin");
			
			if(strCerrar == null)
				strCerrar = "0";
			
			boolean b = ActualizaEstatus.getInsertaEstatus(strNombreEstatus, strCerrar, 
															BUsuario.getIdUsuario(), strFecha);
			try{
				response.sendRedirect("EstatusView.jsp");
			}catch(java.io.IOException io){
				//System.out.println("Error-->"+io);
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strIdEstatus = request.getParameter("id_estatus"); 
			strNombreEstatus = request.getParameter("nombre_estatus"); 
			strCerrar	=	request.getParameter("fin");
			if(strCerrar == null)
				strCerrar = "0"; 
			boolean c = ActualizaEstatus.getActualizarEstatus(strIdEstatus, strNombreEstatus, 
															strCerrar, BUsuario.getIdUsuario(), strFecha);

			try{
				response.sendRedirect("EstatusView.jsp");
			}catch(java.io.IOException io){
				//System.out.println("Error-->"+io);
			}
		}
		
	}
	if(strIdEstatus != null && strIdEstatus.trim().length()>0)
	{
		String strTip[][] = ActualizaEstatus.getEstatus(strIdEstatus);
		strNombreEstatus 	=	strTip[0][0];
		strCerrar			=	strTip[0][1];
		strFecha			=	strTip[0][2];
		strUsuario			=	strTip[0][3];
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
<SCRIPT language="JavaScript" type="text/javascript">
<!-- 
function guardarEstatus() { 
	var doc = document.estatusForm
	var valida = 0;
	var msg="";

	if (doc.nombre_estatus.value =="") {
		valida =1;
		msg = msg + " Debe capturar el nombre del Estatus"+ "\n";
	}
	if (valida == 1){
		alert(msg);
	} 
	if (valida != 1)
	{
	if(doc.id_estatus.value != "")
		doc.accion.value="cambiar";
	if(doc.id_estatus.value == "")
		doc.accion.value="guardar";
	doc.submit();
	}
}
</SCRIPT>
<TITLE>TipoRespuesta.jsp</TITLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="estatusForm" action="Estatus.jsp" method="post">
<INPUT type=hidden value="" name="accion">
<INPUT type=hidden value="<%=strIdEstatus%>" name="id_estatus">
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
			<TD width="125"><A href="EstatusView.jsp"> <IMG
				border="0" src="../Imagenes/Regresar.gif" width="82" height="26"></A></TD>
			<TD width="553">
				<a onclick="guardarEstatus()">
				<img src="../Imagenes/Guardar.gif" width="81" border="0">
				</a>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>

	</TBODY>
</TABLE>
<BR>

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD colspan="2" width="574"><B><FONT face="Verdana" color="#00204f"
				size="2">Estatus a los Tipos de Respuestas</FONT></B></TD>
			<TD width="98">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<td width="672" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>
	</TBODY>
</TABLE>

<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<TD width="528" align="right"><FONT face="Verdana" size="2"><I>
			<% if(strIdEstatus != null && strIdEstatus.trim().length()>0){ %>
			Creado por: <%= ActualizaUsuario.NombreUsuario(strUsuario) %> - <%= strFecha%>
			<% }else{ %>
			Creado por: <%= BUsuario.getNombre() %> - <%= strFecha%>
			<% } %>
			</I></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528" align="right">&nbsp;</TD>
		</TR>
			
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">Estatus:</FONT></TD>
			<TD width="528"><FONT face="Verdana" size="2"><INPUT class="blue500"
				name="nombre_estatus" value="<%=strNombreEstatus%>"></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">Estatus de Cierre:</FONT></TD>
			<TD width="528">
				<FONT face="Verdana" size="2">
				<INPUT 	type="checkbox" value="1" 
						name="fin" <%=(strCerrar.trim().equals("1")?"checked":"")%>>Fin de Flujo
				</FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>

</FORM>
</BODY>
</HTML>
