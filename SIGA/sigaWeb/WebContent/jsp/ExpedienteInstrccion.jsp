<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page import="com.meve.sigma.taglib.*,com.meve.sigma.actualiza.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*"
%> 
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	
	String strAccion 			= "";
	String strVal 				= "";
	String strAreaUs 			= BUsuario.getIdArea();
	String strIdExpediente		= "";
	String strDescExpediente	= "";
	String strFolioRecepcion	= "";
	String strDatosExpInst[][] 	= null;

	String strInstruccion = (request.getParameter("ida")!= null)?request.getParameter("ida"):"";
	String strIdAsunto = (request.getParameter("strIdAsunto")!= null)?request.getParameter("strIdAsunto"):"";
        String editable = (request.getParameter("editable") != null)?request.getParameter("editable"):"true";
        

	strAreaUs	=	BUsuario.getIdArea();
	String strTipo	=	(request.getParameter("cls")!= null)?request.getParameter("cls"):"0";

   	String var[][] =	ActualizaExpArchivado.getDatosValorDeta(strTipo);
	if (var.length >0) 
	{
		strVal = var[0][0];
	}
	else 
	{
	strVal = "0";
	}
	
	strAccion	=	request.getParameter("accion");
	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("guardar")){
		strInstruccion = request.getParameter("idInst");
		strIdExpediente = request.getParameter("asuntoExpediente");

		if(strInstruccion!=null && strInstruccion.length()>0){
			strDatosExpInst = ActualizaExpArchivado.getExpedienteInst(strInstruccion);
			if (strDatosExpInst!=null && strDatosExpInst.length>0){
				ActualizaBitacora.InsertarEventoAsignacionExpedienteInst(BUsuario.getIdUsuario(),strInstruccion,strDatosExpInst);
			}
			ActualizaExpArchivado.insertarExpInstruccion(strInstruccion, strIdExpediente);
		}else if(strIdAsunto!=null && strIdAsunto.length()>0){
			strDatosExpInst = ActualizaExpArchivado.getExpedienteAsunto(strIdAsunto);
			if (strDatosExpInst!=null && strDatosExpInst.length>0){
				ActualizaBitacora.InsertarEventoAsignacionExpedienteAsu(BUsuario.getIdUsuario(),strIdAsunto,strDatosExpInst);
			}
			ActualizaExpArchivado.insertarExpAsunto(strIdAsunto, strIdExpediente);
		}
	}

	if(strInstruccion!=null && strInstruccion.length()>0){
		strDatosExpInst = ActualizaExpArchivado.getExpedienteInst(strInstruccion);
	}else if(strIdAsunto!=null && strIdAsunto.length()>0){
		strDatosExpInst = ActualizaExpArchivado.getExpedienteAsunto(strIdAsunto);
	}
	if (strDatosExpInst!=null && strDatosExpInst.length>0){
		strIdExpediente			=	strDatosExpInst[0][0];
		strDescExpediente		=	strDatosExpInst[0][1];
		strFolioRecepcion		= 	strDatosExpInst[0][2];
	}

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
<TITLE>ExpedienteInstrccion.jsp</TITLE>
</HEAD>
<SCRIPT language="JavaScript" type="text/javascript">
function Consec(con) { 

	}
function AgregarExpInst(){ 	

		document.expedienteInst.accion.value="guardar";
		document.expedienteInst.submit();
		}
</SCRIPT>
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM name="expedienteInst" action="ExpedienteInstrccion.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<input name="tmpCopyToRef" type="hidden" value="">
<input name="idsCC" type="hidden" value="">
<input name="idInst" type="hidden" value="<%=strInstruccion%>">
<input name="strIdAsunto" type="hidden" value="<%=strIdAsunto%>">
<input name="editable" type="hidden" value="<%=editable%>">


<DIV align="center">
<TABLE width="100%" border="0">
<TBODY>
    <% if(editable.equalsIgnoreCase("true")) {%>
	<TR valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2">Seleccione Expediente:</FONT>
		</TD>
		<TD colspan="3">
			<FONT face="Arial" size="2">
				<% if(strInstruccion != null && strInstruccion.trim().length()>0){ %>
				<SELECT name="asuntoExpediente" class="blue500a">
					<%
						boolean bExisteExp = false;
						String strExpedienteArea[][] = null; 
						String strExpedienteGral[][] = null;
						strExpedienteArea = ComboData.getExpedienteCombo(strAreaUs);
						strExpedienteGral = ComboData.getExpedienteComboGral();
						bExisteExp = ActualizaExpediente.getExisteExpedientesPorAreaArch(strAreaUs);
					%> 
					<OPTION value="null">----- Expedientes de la Unidad Administrativa -----</OPTION>
					<% for(int z=0;z<strExpedienteArea.length;z++){ %>
					<OPTION value="<%=strExpedienteArea[z][0]%>" <%=(strIdExpediente.trim().equals(strExpedienteArea[z][0])?"selected":"")%>><%=strExpedienteArea[z][1]%></OPTION>
					<% } %>
					
				</SELECT>
				<% }else{ %>
				<SELECT name="asuntoExpediente" class="blue500a">
					<%
						boolean bExisteExp = false;
						String strExpedienteArea[][] = null;
						String strExpedienteGral[][] = null;
						strExpedienteArea = ComboData.getExpedienteCombo(strAreaUs);
						strExpedienteGral = ComboData.getExpedienteComboGral();
						bExisteExp = ActualizaExpediente.getExisteExpedientesPorArea(strAreaUs);
					%>
					<OPTION value="null">------ Expedientes de la Unidad Administrativa ------</OPTION>
					<% for(int z=0;z<strExpedienteArea.length;z++){ %>
					<OPTION value="<%=strExpedienteArea[z][0]%>" <%=(strIdExpediente.trim().equals(strExpedienteArea[z][0])?"selected":"")%>><%=strExpedienteArea[z][1]%></OPTION>
					<% } %>
					
				</SELECT>
				<% } %>
			</FONT> 
			<INPUT type="button" style="width:65;height:20;font: bold 12px Arial" onclick="AgregarExpInst('');"  value="Asignar">
		</TD>
	</TR>
        <%}%>
	<TR valign="top">
		<TD width="183">
			<FONT face="Arial" color="#004080" size="2">Expediente Asignado:</FONT>
		</TD>
		<TD colspan="3">
		<FONT face="Arial" color="#004080" size="2"><%=strDescExpediente%></FONT>
		</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>