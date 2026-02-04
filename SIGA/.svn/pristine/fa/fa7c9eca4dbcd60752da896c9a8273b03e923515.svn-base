<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<TITLE>Puestos</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,
			java.util.ArrayList,
			java.util.*,com.meve.sigma.util.*"
%>
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

%>
<%
	String strIdUsuario = (request.getParameter("id")== null)?"":request.getParameter("id");
	String strIdArea 	= (request.getParameter("area")== null)?"":request.getParameter("area");
	String strAccion = request.getParameter("accion");
	String retURI = (request.getParameter("retURI")== null)?"portalPrincipal.jsp":request.getParameter("retURI");
	String strIdsRol[][] = null;
	Vector vTiene = new Vector();
	String strIds_Borrar[] = new String[1];
	strIds_Borrar[0] = strIdUsuario;

	if (strIdUsuario.equals("") || strIdArea.equals("")){
		try{
			response.sendRedirect(retURI);
		}
		catch(java.io.IOException io){;}
	}

	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
		vTiene = ActualizaUsuario.deleteUsuario(strIds_Borrar,BUsuario.getIdUsuario());
	}

	String usuario[][] 			= 	null;
	String strCompanieros[][]	=	null;
	String areas[][]			=	null;
	String asistentes[]			=	null;//Multiasistentes
	java.util.Stack st 			= 	new java.util.Stack();
	ArrayList subalternosUsuario	=	null;
	Vector vNombres1 				=	new Vector();
	Vector vIds 					= 	new Vector();
	Vector vIdsMando 				= 	new Vector();
	if(strIdUsuario != null && strIdUsuario.length() > 0)
	{
		usuario		=	ActualizaUsuario.getIDUsuarioBean(strIdUsuario);
		asistentes	=	ActualizaUsuario.getAsistentes(strIdUsuario);
		if(usuario!=null)
		{
			String areaUsuario				=	usuario[0][1];
			String idUsuario				=	usuario[0][0];
			strCompanieros	=	ActualizaUsuario.getCompanierosArea(idUsuario);
			st = ActualizaUsuario.getCadenaDeMandoPara(idUsuario);
			
			String strUsuarios[][] = ActualizaUsuario.getSubalternoSinRol(idUsuario);
			Arboles tree = new Arboles(strUsuarios, strIdArea, Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+Utilerias.codificaPostHTML(retURI)));
			vNombres1 = tree.getNombresHtml();
			vIds = tree.getIds();
			vIds.add(strIdUsuario);
		}

		strIdsRol	=	ActualizaRol.getRoles(strIdUsuario);

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
<script type="text/javascript">
<!--
function borrarUsuario(){
	doc=document.forms[0];
	if (confirm("¿Está usted seguro que desea borrar este Registro?")){    
		doc.accion.value="borrar";
		doc.submit();
	}else 
		alert("Su petición de borrado ya fue cancelada");
}
//-->
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY  background="../Imagenes/fondo_claro.jpg">
<FORM name="puestoOrg" action="estructuraPuesto.jsp" method="post">
<INPUT name="retURI" value="<%=retURI%>" type="hidden">
<INPUT name="id" value="<%=strIdUsuario%>" type="hidden">
<INPUT name="area" value="<%=strIdArea%>" type="hidden">
<INPUT name="accion" value="<%=strAccion%>" type="hidden">
<%if(vTiene.size()>0){%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" width="70%" border="0">
	<TBODY>
		<TR>
			<TD width="75%" class="etiquetas">
				<FONT size="1" color="RED">
				<%	for(int i=0;i<vTiene.size();i++){%>
						<%=ActualizaUsuario.NombreUsuario((String)vTiene.get(i))%>,
				<%	} %>
				<br>No se puede eliminar por que tiene referencias con Puestos y Asuntos</FONT>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<%}else{
	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
		try{
			response.sendRedirect(retURI);
		}
		catch(java.io.IOException io){;}
	}
  }%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0" width="70%">
	<TBODY>
		<TR valign="top">
			<TD width="500">
				<A href="<%=retURI%>">
				<IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar"></A>
			<% if (BUsuario.getAdmon() || BUsuario.getSupervisor()){ %>
				<A href="Usuarios.jsp?retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>" target="_self"> 
				<IMG border="0" src="../Imagenes/nuevo1.gif"  title="Nuevo Puesto"></A> 
				<A href="Usuarios.jsp?accion=consultar&id_usuario=<%=strIdUsuario %>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>" target="_self"> 
				<IMG border="0" src="../Imagenes/Edit2.gif"  title="Editar Puesto"></A> 
				<A onclick="borrarUsuario();" target="_self">
				<IMG border="0" src="../Imagenes/borrar1.gif" title="Borrar Puesto"></A>
			<% } %>
			</TD>
			<TD width="3"></TD>
			<TD width="200" align="right" valign="middle">
				<a href="Bitacora.jsp?id_usuario=<%=strIdUsuario%>&retURI=<%=Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+ Utilerias.codificaPostHTML(retURI))%>">
				<u><FONT SIZE=2 FACE="Verdana">Bitácora del Usuario</FONT></u>
				</a>
			</TD>
		</TR>
	</TBODY>
</TABLE></DIV>
<BR>
<DIV align="center">
<TABLE border="0" width="70%">
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Puesto</B>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696" class="etiquetas">
			<%=usuario[0][2]%>
		</TD>
	</tr>
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Responsable</B>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696" class="etiquetas">
			<%=usuario[0][3]%>
		</TD>
	</tr>
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Roles del Usuario</B>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696" class="etiquetas">
		<UL>
		<%	for (int i=0; i<strIdsRol.length; i++){ %>
			<%=(strIdsRol[i][0].equals("0"))?"Administrador":""%> 
			<%=(strIdsRol[i][0].equals("1"))?"Atención":""%> 
			<%=(strIdsRol[i][0].equals("2"))?"SCP":""%> 
			<%=(strIdsRol[i][0].equals("3"))?"Recepción":""%> 
			<%=(strIdsRol[i][0].equals("4"))?"Supervisor de Área":""%> 
			<%=(strIdsRol[i][0].equals("5"))?"Turnador":""%> 
			<%=(strIdsRol[i][0].equals("6"))?"Asistente":""%> 
			<BR>
		<%	} %>
		<%= usuario[0][5].equals("1")?"Atención Destinatarios Externos <BR>":"" %>
		<%= usuario[0][6].equals("1")?"Catálogo de Archivado <BR>":"" %>
		</UL>
		</TD>
	</tr>
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Unidad Administrativa</B>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696" class="etiquetas">
			<%=ActualizaArea.NombreArea(usuario[0][1])%>
		</TD>
	</tr>
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Cadena de Mando</B>
		</TD>
	</tr>
	<tr align="left">
		<TD align="left" width="696" class="etiquetas">
		<%	if(st.size() > 1){
			for(int y1 = 0; y1<st.size();y1++){
				int y = st.size()-y1-1;
		%>
				<% if(st.elementAt(y) != null){ %>
				<% String strIdMando = ActualizaUsuario.getIdUsuarioxResponsable((String)st.elementAt(y)); %>
				<% vIdsMando.add(strIdMando); %>
				<UL><LI>
					<% if (ActualizaUsuario.getAreaUsuario(strIdMando).equals(strIdArea)){ %>
						<A href="estructuraPuesto.jsp?id=<%=strIdMando%>&area=<%=strIdArea%>&retURI=<%=Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+Utilerias.codificaPostHTML(retURI))%>"
						class="etiquetas" title="<%= ActualizaUsuario.NombreUsuario(strIdMando)%>"><%= ActualizaUsuario.NombrePuesto(strIdMando)%></A><BR>
					<% }else{ %>
						<A class="etiquetas" title="<%= ActualizaUsuario.NombreUsuario(strIdMando)%> -- <%= ActualizaArea.NombreArea(ActualizaUsuario.getAreaUsuario(strIdMando)) %>"><%= ActualizaUsuario.NombrePuesto(strIdMando)%></A><BR>
					<% } %>
				<% }%>
		<%	}%>
			<UL><LI>
			<A class="etiquetas" title="<%= usuario[0][3] %>"><B><U><%=usuario[0][2]%></U></B></A>
			</LI></UL>
		<%	for(int y = 0; y<st.size();y++){ 
				if(st.elementAt(y) != null){ %>
				</LI></UL>
		<% 		} %>
		<%	}%>
		<%	}else{
		%>
		** No tiene Jefes Asignados **
		<%}%>
		</TD>
	</tr>
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Subalternos</B>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696" class="etiquetas">
		<%	if(vNombres1.size()>0){%>
		<UL>
			<LI><A class="etiquetas" title="<%= usuario[0][3] %>"><B><U><%=usuario[0][2]%></U></B></A>
		<%	for(int t=0;t<vNombres1.size();t++){
		%>
				<%=vNombres1.get(t)%>
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
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Asistente</B>
		</TD>
	</tr>
	<tr>
		<!--  if(!usuario[0][4].equals("") && usuario[0][4]!=null && !usuario[0][4].equals("-1")){ %>-->
		<%if(asistentes.length>0){%>
		<td align="left" width="696" class="etiquetas">
			<%for(int i=0;i<asistentes.length;i++){%>
			<A href="estructuraPuesto.jsp?id=<%=asistentes[i]%>&area=<%=strIdArea%>&retURI=<%=Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+Utilerias.codificaPostHTML(retURI))%>"
				class="etiquetas" title="<%= ActualizaUsuario.NombreUsuario(asistentes[i])%>"><%= ActualizaUsuario.NombrePuesto(asistentes[i])%></A><br>
			<%}%>
		</td>
		<% }else{ %>
		<TD align="left" width="696" class="etiquetas">
			** No tiene asignado un Asistente **
		</TD>
		<% } %>
	</tr>
	<tr bgcolor="#004080">
		<TD align="left" width="696" class="etiquetasTit">
			<B>Compañeros de la Unidad</B>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696" class="etiquetas">
		<% if(strCompanieros.length > 0){ %>
			<% for(int i=0;i<strCompanieros.length;i++){ 
				 	boolean bandera = true;
					if (ActualizaUsuario.esAsistente(strCompanieros[i][0], asistentes))
						bandera = false;
					if (bandera && vIds!=null){
						for (int k=0; k<vIds.size(); k++){
							if (strCompanieros[i][0].equals((String)vIds.get(k)))
								bandera = false;
						} 
					}
					if (bandera && vIdsMando!=null){
						for (int k=0; k<vIdsMando.size(); k++){
							if (strCompanieros[i][0].equals((String)vIdsMando.get(k)))
								bandera = false;
						} 
					}
					if (bandera){ %>
			<A href="estructuraPuesto.jsp?id=<%=strCompanieros[i][0]%>&area=<%=strIdArea%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id="+strIdUsuario+"&area="+strIdArea+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>" class="etiquetas"
				title="<%=strCompanieros[i][2]%>">
				<%=strCompanieros[i][1]%></A><BR>
				<% } %>
		<% } %>
		<% }else{ %> <FONT face="Verdana" size="2">No tiene Compañeros</FONT>
		<% } %></TD>
	</tr>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>
