<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Tipo de Asunto</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*"%> 
<%@ page import="com.meve.sigma.taglib.*,com.meve.sigma.beans.*"%>
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
		String recCreador[][] 		= null;
		String recTipoAsunto[][]	= null;
		String strIdTipoAsunto 		= "";
		String strIdArea 			= "";
		String strNombreTipoAsunto 	= "";
		String strCreador 			= "";
		String strCreador1 			= "";
		String strFechaCreacion 	= "";
		String strFechaCreacion2 	= "";
		String strAccion 			= "";
		String strEstatus 			= "1";

		String retURI = (request.getParameter("retURI")== null)?"TipoAsuntoView.jsp":request.getParameter("retURI");
		String strAux = "1a2b3c", strAux2 = "1a2b3c";
		int valida = -2;

		boolean bInsertar = false;
		boolean bActualizar = false;
		boolean b = false;

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
		//java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-mm-dd");
		java.util.Date f = new java.util.Date();
		strFechaCreacion = sdf.format(f);
		strFechaCreacion2 = strFechaCreacion;

		strCreador1	=	BUsuario.getIdUsuario();
		strCreador	=	ActualizaUsuario.NombreUsuario(strCreador1);
		strAccion 	= 	request.getParameter("accion");
		
		if (strAccion != null && strAccion.equals("consultar")) {
			strIdTipoAsunto = request.getParameter("TipoAsunto_idTipoAsunto");
			if (strIdTipoAsunto != null) {
				recTipoAsunto 		= ActualizaTipoAsunto.getTipoAsunto(strIdTipoAsunto);
				strIdArea 			= recTipoAsunto[0][0];
				strNombreTipoAsunto	= recTipoAsunto[0][1];
				strCreador			= ActualizaUsuario.NombreUsuario(recTipoAsunto[0][2]);
				strFechaCreacion2 	= recTipoAsunto[0][3];

				strAux = strNombreTipoAsunto;
				strAux2 = strIdArea;
			}
		}
		if (strAccion != null && strAccion.equals("cambiar")) {
			strIdTipoAsunto = request.getParameter("TipoAsunto_idTipoAsunto");
			if (strIdTipoAsunto != null) { 
				strIdArea 				= request.getParameter("TipoAsunto_area");
				strNombreTipoAsunto 	= request.getParameter("TipoAsunto_Nombre");
				
				strAux 	= request.getParameter("aux");
				strAux2 = request.getParameter("aux2");

				valida = ActualizaTipoAsunto.getTipoAsuntoExiste(strNombreTipoAsunto, strAux, strIdArea, strAux2);	

				if (valida == 2){
					
					String [][] datos = ActualizaTipoAsunto.getTipoAsunto(strIdTipoAsunto);
					bInsertar 				= ActualizaTipoAsunto.ActualizarTipoAsunto(strIdTipoAsunto,
										strIdArea, strNombreTipoAsunto, strCreador1, strFechaCreacion);
					b = ActualizaBitacora.InsertarEventoCambioTipoAsu(BUsuario.getIdUsuario(),strNombreTipoAsunto,strIdArea,strIdTipoAsunto,datos);
					try{
						//response.sendRedirect("TipoAsuntoView.jsp");
						response.sendRedirect(retURI);
					}catch(java.io.IOException io){
						//System.err.println("Error Redirección->"+io);
					}
				}
			}
		}

		if (strAccion != null && strAccion.equals("guardar")) {
			strIdArea 			= request.getParameter("TipoAsunto_area");
			strNombreTipoAsunto = request.getParameter("TipoAsunto_Nombre"); 

			valida = ActualizaTipoAsunto.getTipoAsuntoExiste(strNombreTipoAsunto, strAux, strIdArea, strAux2);	

			if (valida == 2){
				bInsertar 			= ActualizaTipoAsunto.InsertarTipoAsunto(strIdArea, strNombreTipoAsunto,
										strCreador1, strFechaCreacion, strEstatus);
				b = ActualizaBitacora.InsertarEventoAltaTipoAsu(BUsuario.getIdUsuario(),strNombreTipoAsunto,strIdArea);
				try{
					//response.sendRedirect("TipoAsuntoView.jsp");
					response.sendRedirect(retURI);
				}catch(java.io.IOException io){
					//System.err.println("Error Redirección->"+io);
				}
			}
			//strIdArea 			= ""; 
			//strNombreTipoAsunto = "";
		}
		//recCreador  = ActualizaUsuario.getUsuario(strCreador1);
		//strCreador	= recCreador[0][0];
		//if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")))
		//{
		//	strAccion 			= "";
%>
<% if(strIdTipoAsunto!=null && strIdTipoAsunto.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>
<!-- <SCRIPT language=JavaScript type=text/javascript>
	location.assign("TipoAsuntoView.jsp");
</SCRIPT> -->
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<STYLE type="text/css">
</STYLE>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="valida=0;timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="TipoAsunto.jsp" name="TipoAsunto" method="post">
<INPUT type=hidden value="<%= strAccion %>" name="accion"> 
<INPUT type=hidden value="<%=strIdTipoAsunto%>" name="TipoAsunto_idTipoAsunto">
<INPUT type=hidden value="<%=strAux%>" name="aux">
<INPUT type=hidden value="<%=strAux2%>" name="aux2">
<INPUT type=hidden value="<%=retURI%>" name="retURI">

<DIV align="center">
<BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>

		<TR valign="top">
			<TD colspan="2"><A href="<%= retURI %>"> <IMG
				border="0" src="../Imagenes/NavLeft.gif" title="Regresar"
				title="Regresar"> </A>
				<a onclick="guardar()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="../Imagenes/Save.gif" title="Guardar">
				</a>
			</TD>
		</TR>

		<TR valign="top">
			<TD width="20%"><B><FONT face="Verdana" color="#00204f"
				size="2"><FONT size="+1" color="#004080">Tipo de Asunto</FONT></FONT></B></TD>
			<TD width="80%" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2" ></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2" ></TD>
		</TR>

		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<TD width="528" align="right"><FONT face="Verdana" size="2"><I>
				<%=(strIdTipoAsunto!=null && !strIdTipoAsunto.equals(""))?"Última modificación por: ":"Creado por: "%><%= strCreador %> - <%= strFechaCreacion2 %></I></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144"><BR>
			<BR>
			&nbsp;</TD>
			<TD width="528" align="right">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Unidad
			Administrativa:</B></FONT></TD>
			<% if(BUsuario.getSupervisor()){ 
				if(strIdTipoAsunto==null){
					strIdArea = BUsuario.getIdArea();
				} 
			%>
			<TD width="528"><FONT face="Verdana" size="2"><meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1"
				name="TipoAsunto_area" classHtml="blue600a"
				selected="<%= strIdArea %>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/></FONT></TD>
			<% }else{ %>
			<TD width="528"><FONT face="Verdana" size="2"><meve_combo:comboseleccion
				data="<%=ComboData.getAreasComboAll()%>" size="1"
				name="TipoAsunto_area" classHtml="blue600a"
				selected="<%= strIdArea %>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/></FONT></TD>
			<% } %>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Tipo
			de Asunto:</B></FONT>
			<%if (valida == 1) {%><br>
			<FONT color="red"><B>*Este Tipo de Asunto ya existe* </B></FONT><%} %>
			</TD>
			<TD width="528"><FONT face="Verdana" size="2"><INPUT class="blue600a"
				name="TipoAsunto_Nombre" value="<%=strNombreTipoAsunto%>" maxlength="199"></FONT></TD>
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
<SCRIPT language="JavaScript" type="text/javascript">
<!-- 


function guardar() { 
	var doc = document.TipoAsunto
	//var valida = 0;
	var msg="";


//	if (valida != 1)	{
		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \' )\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.TipoAsunto_Nombre.value)){
			if (confirm(mensaje)){

				doc.TipoAsunto_Nombre.value	= quitaCE(doc.TipoAsunto_Nombre.value);
	
				doc.aux.value	= quitaCE(doc.aux.value);
				
				if(doc.TipoAsunto_idTipoAsunto.value != "")
					doc.accion.value="cambiar";
				if(doc.TipoAsunto_idTipoAsunto.value == "")
					doc.accion.value="guardar";
//				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			if(doc.TipoAsunto_idTipoAsunto.value != "")
				doc.accion.value="cambiar";
			if(doc.TipoAsunto_idTipoAsunto.value == "")
				doc.accion.value="guardar";
//			doc.submit();
		}
//	}
	if (doc.TipoAsunto_area[doc.TipoAsunto_area.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar un Área	"+ "\n";
	}
	if (Trim(doc.TipoAsunto_Nombre.value) =="") {
		valida =1;
		msg = msg + " Debe capturar el Tipo de Asunto"+ "\n";
	}
	if (Trim(quitaPuntos(doc.TipoAsunto_Nombre.value)) =="" && doc.TipoAsunto_Nombre.value!="") {
		valida =1;
		msg = msg + " El Tipo de Asunto no es válido"+ "\n";
	}
	if (valida == 1) 
	{
		alert(msg);
		valida=0;
		return false;
	}else if(valida == 2){
		alert("Su solicitud ya fue enviada");
		return false;
	}else{
		valida=2;
		doc.submit();
	}
}
</SCRIPT>
</BODY>
</HTML>
