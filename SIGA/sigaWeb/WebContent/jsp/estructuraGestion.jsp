<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<TITLE>Puestos</TITLE>
<%@ taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,java.util.*,com.meve.sigma.util.*"
%>
<% 
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){}
	}

%>
<%
	String strSupervisor			=	"";
	String strCargo					=	"";
	String strIdSupervisor			=	"";
	String area[][]					=	null;
	String strMiembros[][]			=	null;
	
	String strUsuarios[][] = null;
	Arboles tree = null;
	Vector vNombres = null;
	Vector vIds = null;

	String strIdArea = (request.getParameter("area")== null)?BUsuario.getIdArea():request.getParameter("area");
	if(strIdArea != null && strIdArea.length()>0){
		area			=	ActualizaArea.getIDArea(strIdArea);
		strMiembros		=	ActualizaArea.getMiembrosArea(strIdArea);
		if(area.length != 0)
		{
			strSupervisor	=	area[0][2];
			strCargo		=	area[0][3];
			strIdSupervisor	=	area[0][4];
		}else{
			strSupervisor	=	"La UA no tiene un Supervisor asignado";
		}
		if (!strIdSupervisor.equals("")){
			strUsuarios = ActualizaUsuario.getSubalternoSinRol(strIdSupervisor);
			tree = new Arboles(strUsuarios,strIdArea,Utilerias.codificaPostHTML(strTmp+"?area="+strIdArea));
			vNombres = tree.getNombresHtmlGestion();
			vIds = tree.getIds();
			vIds.add(strIdSupervisor);
		}
	}
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/link.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
	function cambioArea(opcion){
		doc = document.estructura;
		var cadena = "";
		if(opcion.options[opcion.selectedIndex].value != "-1"){
			cadena = opcion.options[opcion.selectedIndex].value;
			doc.area.value = cadena;
			doc.submit();
		}
	}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM name="estructura" action="estructuraGestion.jsp" method="post">
<INPUT type="hidden" value="<%=strIdArea%>" name="area">
<% if (BUsuario.getAdmon()){ %>
<DIV align="center">
<TABLE border="0">
	<TR>
		<TD align="center" width="500"><b>Unidad Administrativa</b></TD>
	</TR>
	<TR align="center">
		<TD align="center" width="500"><meve_combo:comboseleccion
			data="<%= ActualizaUsuario.getAreas() %>" size="1" name="areas"
			classHtml="blue500a" selected="<%=strIdArea%>"
			textoNoSeleccion=" -------------------- Seleccionar Unidad Administrativa --------------------"
			valorNoSeleccion="-1" script="onchange='cambioArea(this)'" />
	</TR>
</TABLE>
</DIV>
<% } %>
<DIV align="center">
<TABLE border="0" width="70%">
	<TBODY>
		<TR valign="middle">
			<TD class="etiquetas1v" align="left">
				<B><FONT size="+1">&nbsp;&nbsp;Puestos</FONT></B>
			</TD>
		</TR>
		<TR valign="middle">
			<td bgcolor="#004080">
			<img src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>
	</TBODY>
</TABLE>
</DIV> 
<% if(strIdArea != null && strIdArea.length() > 0){ %>
<DIV align="center">
<TABLE border="0" width="70%">
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Responsable de la Unidad Administrativa: <%= ActualizaArea.NombreArea(strIdArea) %></B>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696" class="etiquetas">
			<A href="estructuraPuestoGestion.jsp?id=<%= strIdSupervisor %>&area=<%= strIdArea %>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?area="+strIdArea) %>" class="etiquetas" 
				title="<%= strCargo %>"><B><U><%=strSupervisor%></U></B></A>
		</TD>
	</tr>
	<TR><TD> &nbsp;</TD></TR>
	<% 	if(!strIdSupervisor.equals("") && vIds.size()>1){ %>
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Organigrama de la Unidad</B>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696" class="etiquetas">
			<%	if(vNombres.size()>0){%>
			<UL>
				<LI>
					<A href="estructuraPuestoGestion.jsp?id=<%= strIdSupervisor %>&area=<%= strIdArea %>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?area="+strIdArea) %>" class="etiquetas" 
						title="<%= strCargo %>"><B><U><%=strSupervisor%></U></B></A>
			<%	for(int t=0;t<vNombres.size();t++){
			%>
					<%=vNombres.get(t)%>
			<%	}%>
				</LI>
			</UL>
			<%	}else{
			%>
			** No tiene Subalternos asignados **
			<%
				}
			%>
		</TD>
	</tr>
	<%	} %>
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Puestos de la Unidad sin relación al Organigrama principal</B>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696" class="etiquetas">
			<% 	int jx = 0;
				if(strMiembros.length > 0){ %>
				<% for(int j=0;j<strMiembros.length;j++){ %>
					<% 	boolean bandera = true;
						if (vIds!=null){
							for (int k=0; k<vIds.size(); k++){
								if (strMiembros[j][0].equals((String)vIds.get(k)))
									bandera = false;
							} 
						}
					%>
				<%		if (bandera){ %>
					<A href="estructuraPuestoGestion.jsp?id=<%=strMiembros[j][0]%>&area=<%=strIdArea%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?area="+strIdArea) %>" class="etiquetas" 
						title="<%=strMiembros[j][2]%>" >
						<%=strMiembros[j][1]%></A><BR>
				<% 		jx++;
						} %>
				<% } %>
			<% }else{ 
				jx = -1; %>
				<FONT face="Verdana" size="2">*** No hay puestos sin relación ***</FONT>
			<% } %>
			<% if (jx==0){ %>
				<FONT face="Verdana" size="2">*** No hay puestos sin relación ***</FONT>
			<% } %>
		</TD>
	</tr>
</TABLE>
</DIV>
<% } %>
</FORM>
</BODY>
</HTML>
