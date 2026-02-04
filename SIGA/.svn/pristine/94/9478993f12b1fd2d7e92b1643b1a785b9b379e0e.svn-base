<jsp:useBean id="BAreaView" class="com.meve.sigma.beans.BeanAreaView" scope="page">
	<jsp:setProperty name="BAreaView" property="*" />
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%> 
<HTML>
<HEAD>
<TITLE>Puestos</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.taglib.*,java.util.*,com.meve.sigma.util.*"%>
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
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERUsuarioInvalido.jsp"></jsp:forward>
<% } %>
<%

	boolean bOperacion = false;
	boolean bMostrar = false;
	int t = 0;
	Vector vTiene = new Vector();
	String regIDArea = (request.getParameter("regIDArea")==null)?BUsuario.getIdArea():request.getParameter("regIDArea");
	String strIdArea = (BAreaView.getIdArea()== null)?regIDArea:BAreaView.getIdArea();
	String strIdRoles = (request.getParameter("idRol")!=null)?request.getParameter("idRol"):"0";
	String strAccion = "";
	String strIds_Borrar[] = null;

	strAccion = request.getParameter("accion");
	strIds_Borrar = request.getParameterValues("Borrar");
	
	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
		vTiene = ActualizaUsuario.deleteUsuario(strIds_Borrar,BUsuario.getIdUsuario());
	}
	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";

	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");

	String retURI = strTmp+"?regIDArea="+strIdArea+"&orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas;
	retURI = Utilerias.codificaPostHTML(retURI);

	int regPorPagina = 20;
	int muestraPaginas = 20;
	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
	if(strConfig != null && strConfig.length > 0){
		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
	}	

	String[][] strRoles = ActualizaUsuario.getRolesPorArea(strIdArea);

	Vector vRegistros = new Vector();
	int numeroRegistros = 0;
	String sql[][] = ActualizaUsuario.getUsuariosPorAreaRol(strIdArea, strIdRoles, strOrden, strTipo);
	if (sql!=null && sql.length>0){
		for (int ix=0; ix<sql.length; ix++){
			if(BUsuario.getAdmon() || BUsuario.getIdArea().equals(sql[ix][3])){ 
				numeroRegistros++;
				vRegistros.addElement(sql[ix]);
			}
		}
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
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT language="JavaScript" src="../js/GeneralFunctions.js"></SCRIPT>
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>
function reload() {
	doc = document.UsuariosView;
	doc.idRol.value=0;
	doc.accion.value="reload";
	doc.submit();
}
function cambio(o, t){
	doc = document.UsuariosView;
	doc.orden.value=o;
	doc.tipo.value=t;
	doc.submit();
}
function referenciaRet(retURI){
	location.assign("Usuarios.jsp?retURI=" + retURI.value);
}

function pagina(contador){
	doc = document.UsuariosView;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.UsuariosView;
	doc.contligas.value=contador;
	doc.submit();
}
function desplegar(id){
	doc = document.UsuariosView;
	if (id==doc.idRol.value){
		doc.idRol.value=0;
		doc.submit();
	}else{
		doc.idRol.value=id;
		doc.contPag.value=0;
		doc.contligas.value=0;
		doc.submit();
	}
}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<span id="ruler" style="visibility:hidden;"></span> 
<FORM action="UsuariosRolView.jsp" name="UsuariosView" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%= retURI %>" name="retURI">
<INPUT type="hidden" name="orden" value="<%= strOrden %>">
<INPUT type="hidden" name="tipo" value="<%= strTipo %>">
<INPUT type="hidden" value="<%= contPag %>" name="contPag">
<INPUT type="hidden" value="<%= contligas %>" name="contligas">
<INPUT type="hidden" value="<%= strIdRoles %>" name="idRol">
<%if(vTiene.size()>0){%>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR>
			<TD width="75%" class="etiquetas">
				<FONT size="1" color="RED">
				<%for(int i=0;i<vTiene.size();i++){%>
				<%=ActualizaUsuario.NombreUsuario((String)vTiene.get(i))%>,
				<%}%>
				<br>No se puede(n) eliminar por que tiene referencias con Puestos y Asuntos</FONT>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<br>
<%}%>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="40%">
				<A href="estructura.jsp?area=<%= strIdArea %>" target="_self"> 
				<IMG src="../Imagenes/NavLeft.gif" border="0" title="Regresar"> </A> 
			</TD>
			<TD width="50%" valign="middle">
			<DIV align="right">
				<% 
				if (vRegistros.size()>0){
					int numeroPaginas = numeroRegistros/regPorPagina;	
					if (numeroRegistros%regPorPagina != 0)
						numeroPaginas++; %>
				<%	if (numeroRegistros > 0){	%>
						<%= numeroRegistros %> registros mostrados.
				<%	} %>
				<%	if (numeroPaginas > 1){	%>
						Pagina <%= contPag+1 %> de <%= numeroPaginas %>
				<% 	} %>
				<%} %>
			</DIV>
			</TD>
			<TD width="10%"> &nbsp;
			</TD>
		</TR>
	</TBODY>
</TABLE>
<% if (BUsuario.getAdmon()){ %>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="100%" bgcolor="#00204f"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<TABLE width="100%">
	<TBODY>
		<TR>      
			<TD class="etiquetas" align="right" width="30%"><b>Unidad Administrativa:</b></TD>
			<TD align="left" width="70%">
				<% if(BUsuario.getSupervisor()){ %>
				<meve_combo:comboseleccion
				data="<%=ComboData.getAreasCombo(BUsuario.getIdArea())%>" size="" name="idArea"
				classHtml="blue500a" selected="<%=strIdArea%>"
				textoNoSeleccion="-------------------- Selecciona un Opción --------------------" valorNoSeleccion=""
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='reload()'" />
				<%}else{%>
				<meve_combo:comboseleccion
				data="<%=ComboData.getAreasComboAll()%>" size="1" name="idArea"
				classHtml="blue500a" selected="<%=strIdArea%>"
				textoNoSeleccion="-------------------- Selecciona un Opción --------------------" valorNoSeleccion=""
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='reload()'" />
				<%}%>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<% } %>
<TABLE width="100%" border="0">
	<TBODY>
		<TR bgcolor="#00204f">
			<TD id="Asunto_HD" width="60%" align="center">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Puestos</FONT></b>
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD id="Asunto_HD2" width="40%" align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Responsable</FONT></b>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV class=documentBody id=Body><BR>
<%if(strIdArea.length() != 0){%>
<% if (vRegistros.size()>0 || strRoles.length>0){ %>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0"> 

		<% if (strRoles!=null && strRoles.length>0){ %>
		<% for (int ir=0; ir<strRoles.length; ir++){ 
			String strRol = strRoles[ir][0];
			String strNombreRol = strRoles[ir][1];
			bMostrar = strIdRoles.equals(strRol);
		%>
		<tr valign="top">
			<td colspan="2" width="800">
				<a onClick="desplegar(<%=strRol%>)" >
				<img src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>"
					border="0" height="16" width="16"><%= strNombreRol %>
				</a> 
			</td>
		</tr>
		
		<% if (bMostrar){ %>
	<% int j = 0; 

		String strDatos[][] = ActualizaUsuario.getUsuariosPorAreaRol(strIdArea, strIdRoles, strOrden, strTipo);		
		int numeroPaginas = numeroRegistros/regPorPagina;	
		if (numeroRegistros%regPorPagina != 0)
			numeroPaginas++; 

		for (int i=contPag*regPorPagina; i<vRegistros.size() && i<(contPag+1)*regPorPagina; i++){

			String sqlAux[] = (String[])vRegistros.get(i);
			strDatos[i]=sqlAux;

			String Lista1 = strDatos[i][0];
			String Lista2 = strDatos[i][1];
			String Lista3 = strDatos[i][2];
			String Lista4 = strDatos[i][3];
			String Lista5 = strDatos[i][4];
			String Lista6 = strDatos[i][5];
%>
	<% if(	BUsuario.getAdmon() ||
			BUsuario.getIdArea().equals(Lista4)){ %>
	<%		String strRolLIsta = ActualizaRol.getRoles(Lista1)[0][0]; %>
	<% t++; %>
		<TR valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
			<TD width="100%">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="60%" align="center"><FONT face=Arial color=#000080 size=1> 
					<A <% if (BUsuario.getSupervisor() && strRolLIsta.equals("0")){} else{ %>href="Usuarios.jsp?accion=consultar&id_usuario=<%=Lista1 %>&retURI=<%=Utilerias.codificaPostHTML(strTmp+"?regIDArea="+strIdArea+"&orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&idRol="+strIdRoles) %>" <%}%> title="<%=Lista2%>"><script>document.write(trunc('<%=Lista2%>','Asunto_HD'));</script></A>
					</FONT></td>
					<td width="40%" align="center"><A onmouseover="title='<%=Lista5%>'"><script>document.write(trunc('<%=Lista5%>','Asunto_HD2'));</script></A></td>
				</tr>
			</table>
			</TD>
		</TR>
	<% j++; %>
	<% } %>
	<% } 	%>
	<% if(j == 0){ %>
	<TR>
			<TD width="100%">
			<div align=center><FONT face="verdana" size="4">******No Hay Usuarios
			Capturados de su Unidad Administrativa******</FONT></div>
			</TD>
	</TR>
	<% } else {%>
	<TR>
		<TD colspan="3" align="center"><BR>
		<%
			if (contligas>0 && numeroPaginas > muestraPaginas){  %>
				<A onclick="paginaLiga(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);pagina(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;
		<%	}
			if (contPag > 0){  
				if (contPag > contligas){%>
					<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
			<%	}else{%>
					<A onclick="paginaLiga(<%=contligas-1%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
			<%	} 
			}
			if (numeroPaginas > 1){
				for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
					if (i==contPag){  %>
						<A onclick="pagina(<%=i%>)"><FONT color="red"><B>[<%=i+1%>]</B></FONT></A> &nbsp;
			<%		}else{ %>
						<A onclick="pagina(<%=i%>)"><%=i+1%></A> &nbsp;
			<%		}
				}
			} 
			if (contPag < numeroPaginas-1){  
				if (contPag < contligas + muestraPaginas-1){%>
					<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
			<%	}else{%>
					<A onclick="paginaLiga(<%=contligas+1%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
			<%	} 
			}
			if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  %>
				<A onclick="paginaLiga(<%= contligas+muestraPaginas %>);pagina(<%= contligas+muestraPaginas %>);"> <B> | Siguiente&gt;&gt;</B> </A>
		<%	
			} %>
		</TD>
	</TR>
	<% } %>
	<% } %>
	<% } %>
	<% } %>
</TABLE>
<%}else if(!strIdArea.equals("0")){%>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
	<TR>
		<TD width="100%">
		<div align=center><FONT face="verdana" size="4">******No Hay Usuarios Capturados de la Unidad Administrativa******</FONT></div>
		</TD>
	</TR>
</TABLE>
<%}%>
<%}%>
<br>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<BR>
</FORM>
</BODY>
</HTML>
</jsp:useBean>