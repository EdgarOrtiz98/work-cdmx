<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.meve.sigma.taglib.*,
			com.meve.sigma.beans.*,
			com.meve.sigma.beans.catalogos.*,
			com.meve.sigma.actualiza.*,java.util.*"%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){;}
	}
 if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERUsuarioInvalido.jsp"></jsp:forward>
<% } %>
<%
	String strAccion = "";
	String strIdTramite = (request.getParameter("tIdTramite")== null)?"":request.getParameter("tIdTramite");
	String strIdArea = (request.getParameter("tArea")== null)?"":request.getParameter("tArea");
	String strNombre = (request.getParameter("tNombre")== null)?"":request.getParameter("tNombre");
	String strClave = (request.getParameter("tClave")== null)?"":request.getParameter("tClave");
	String strDescripción = (request.getParameter("tDescripcion")== null)?"":request.getParameter("tDescripcion");
	String strTiempo = (request.getParameter("tTiempo")==null)?"":request.getParameter("tTiempo");
	String strFecha = "";
	String strUsuario = "";
	Vector mensajes = new Vector();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f = new java.util.Date();
	String strFechaCreacion = sdf.format(f);
	
	String retURI = (request.getParameter("retURI")== null)?"tramitesView.jsp":request.getParameter("retURI");
	
	String strTramites[][] = null;
	strAccion	=	request.getParameter("accion");
        
	if(strIdTramite != null && strIdTramite.length()>0){
		strTramites = ActualizaTramite.getTramite(strIdTramite);
		strIdArea = strTramites[0][1];
		strNombre = strTramites[0][2];
		strClave = strTramites[0][3];
		strDescripción = strTramites[0][4];
		strTiempo = strTramites[0][5];
		strFecha = strTramites[0][6];
		strUsuario = strTramites[0][7];
	}
        
        
	if(strAccion != null && strAccion.equals("guardar")){
		Tramite tramite = new Tramite();
//                request.setAttribute("msg",msg);
		mensajes = tramite.procesoTramite(request, BUsuario);
		try{
			if(mensajes.get(5).equals("si"))
				response.sendRedirect(retURI);
		}catch(java.io.IOException io){;}
	}else{
		mensajes.add("");
		mensajes.add("");
		mensajes.add("");
		mensajes.add("");
		mensajes.add("");
	}
%>
<% if(strIdTramite!=null && strIdTramite.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/link.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJsCat.js"></script>
<TITLE>Tramites</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
function limpiarCampos(){
	document.tramites.reset();
}

</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="valida=0;timer_load();limpiarCampos();" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="tramites" action="tramites.jsp" method="post">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="tIdTramite" value="<%=strIdTramite%>">
<INPUT type="hidden" value="<%=strClave %>" name="aux">
<INPUT type="hidden" value="<%=strIdArea %>" name="aux2">
<INPUT type="hidden" value="<%=retURI %>" name="retURI">

<DIV align="center">
<BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>

	<TR valign="top">
		<TD colspan="4">
			<A href="<%= retURI %>">
			<IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar"></A>
			<a onclick="guardarTramite()">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<img src="../Imagenes/Save.gif" title="Guardar">
			</a>
		</TD>
    </TR>
	<TR valign="top">
		<TD colspan="4"></TD>
    </TR>

	<TR valign="top">
		<TD colspan="2" class="etiquetas1v"><B><FONT face="Verdana" color="#00204f" size="2"><FONT size="+1"
				color="#004080">Tramites</FONT></FONT></B></TD>
		<TD colspan="2" align="right">&nbsp;**Los datos marcados con negritas son obligatorios&nbsp;</TD>
	</TR>
	<TR valign="top">
		<td bgcolor="#004080" colspan="4"><img
		src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
	</TR>
	<TR valign="top">
		<TD align="right" colspan="4">
			<%if(strIdTramite!=null && strIdTramite.length()>0){%>
			<FONT face="Verdana" size="2">
				<%=(strIdTramite!=null && !strIdTramite.equals(""))?"Última modificación por: ":"Creado por: "%>
				<I><%=ActualizaUsuario.NombreUsuario(strUsuario)%> - <%=strFecha%></I></FONT>
			<%}else{%>
			<FONT face="Verdana" size="2">
				<%=(strIdTramite!=null && !strIdTramite.equals(""))?"Última modificación por: ":"Creado por: "%>
				<I><%=ActualizaUsuario.NombreUsuario(BUsuario.getIdUsuario())%> - <%=strFechaCreacion%></I></FONT>
			<%}%>
		</TD>
	</TR>
	<TR valign="top">
		<TD colspan="4">&nbsp;</TD>
    </TR>

	<TR valign="top">
		<TD width="162">&nbsp;</TD>
		<TD width="174">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="162" class="etiquetas"><FONT face="Verdana" size="2" color="#004080">
			<B>Unidad Administrativa:</B></FONT>
		</TD>
		<TD colspan="3" class="etiquetas">
			<% if(BUsuario.getSupervisor()){ 
				if(strIdTramite.equals("")){
					strIdArea = BUsuario.getIdArea();
				} 
			%>
			<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" 
				size="1" name="tArea" 
				classHtml="blue600a" selected="<%= strIdArea %>" 
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
				valorNoSeleccion="-1" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<BR><FONT color="red" size="1"><%=mensajes.get(0)%></FONT>
			<%}else{%>
			<meve_combo:comboseleccion data="<%= ComboData.getAreasComboAll() %>"
				size="1" name="tArea" 
				classHtml="blue600a" selected="<%=strIdArea%>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1"
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'" />
				<BR><FONT color="red" size="1"><%=mensajes.get(0)%></FONT>
			<%}%>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="162">&nbsp;</TD>
		<TD width="174">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="162" class="etiquetas"><FONT face="Verdana" size="2" color="#004080">
			<B>Nombre:</B></FONT>
		</TD>
		<TD colspan="3" class="etiquetas">
			<INPUT type="text" class="blue600a" maxlength="199" name="tNombre" onkeydown="" value="<%=strNombre.trim()%>">
			<BR><FONT color="red" size="1"><%=mensajes.get(1)%></FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="162">&nbsp;</TD>
		<TD width="174">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="162" class="etiquetas"><FONT face="Verdana" size="2" color="#004080">
			<B>Clave:</B></FONT>
		</TD>
		<TD colspan="3" class="etiquetas">
			<INPUT type="text" class="blue200a" maxlength="50" name="tClave" onkeydown="" value="<%=strClave.trim()%>">
			<BR><FONT color="red" size="1"><%=mensajes.get(2)%><%=mensajes.get(4)%></FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="162">&nbsp;</TD>
		<TD width="174">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="162" class="etiquetas"><FONT face="Verdana" size="2" color="#004080">
			Descripción:</FONT>
		</TD>
		<TD colspan="3" class="etiquetas">
			<INPUT type="text" class="blue600a" maxlength="199" name="tDescripcion" onkeydown="" value="<%=strDescripción%>">
		</TD>
	</TR>
	<TR valign="top">
		<TD width="162">&nbsp;</TD>
		<TD width="174">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="162" class="etiquetas"><FONT face="Verdana" size="2" color="#004080">
			<B>Tiempo del Tramite:</B></FONT>
		</TD>
		<TD colspan="3" class="etiquetas">
			<INPUT type="text" class="blue200a" maxlength="3" onKeyPress='AceptaSoloTeclaNumericaYPunto();' name="tTiempo" value="<%=strTiempo%>">
			&nbsp;Día(s)
			<BR><FONT color="red" size="1"><%=mensajes.get(3)%></FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="162">&nbsp;</TD>
		<TD width="174">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
</TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>