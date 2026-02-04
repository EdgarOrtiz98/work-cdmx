<jsp:include page="header.jsp" flush="false"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"%>
<%@ page import="com.meve.sigma.util.*,java.util.*"%>
<%@ page import="javax.mail.MessagingException"%>
<%@ page import="java.io.UnsupportedEncodingException"%>
<%@ page import="gob.hacienda.cgtic.siga.instruccion.Actualiza"%>
<%@ page import="gob.hacienda.cgtic.siga.actualiza.AtenderInstrucciones"%>
<%
	String strIdAsunto = "";
	String strIdInstruc = "";
	String strAvance = "";
	String strUsrOrg = "";
	String strUsuario = "";
	strIdInstruc = (request.getParameter("id_ins") != null) ? request
			.getParameter("id_ins") : "";
	strIdAsunto = (request.getParameter("id_asunto") != null) ? request
			.getParameter("id_asunto") : "";
	strAvance = (request.getParameter("ava") != null) ? request
			.getParameter("ava") : "";
	strUsrOrg = (request.getParameter("usr_ori") != null) ? request
			.getParameter("usr_ori") : "";
	strUsuario = (request.getParameter("id_usuario") != null) ? request
			.getParameter("id_usuario") : "";
	UsuarioBean BUsuario = (UsuarioBean) session
			.getAttribute("UsuarioBean");
	String strTmp = request.getRequestURI();
	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
			.length());
	if (BUsuario == null) {
		try {
			response.sendRedirect("index.jsp?pagina=" + strTmp
			+ "?id_ins=" + strIdInstruc + "&id_asunto="
			+ strIdAsunto + "&ava=" + strAvance + "&usr_ori="
			+ strUsrOrg);
		} catch (java.io.IOException io) {
			;
		}
	}
%>
<%
	String strIdUsuario = "";
	String strComentarios = "";
	String strAccion = "";
	String strFechaCreacion = "";
	boolean bReasignar = false;
	boolean bInsertar = false;
	boolean bInsertarBit = false;
	boolean bEsAtencion = false;

	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
			"dd/MM/yyyy");
	java.util.Date f = new java.util.Date();
	strFechaCreacion = sdf.format(f);

	String strIdAreaUs = BUsuario.getIdArea();
	String strIdUsrReasigna = BUsuario.getIdUsuario();

	strAccion = request.getParameter("accion");
	/*KHCH Navegacion Reasignacion*/
	String retURI2 = request.getParameter("retURI2");
	String retURI = (request.getParameter("retURI") == null) ? "portalPrincipal.jsp"
			: request.getParameter("retURI");

	boolean bValidaEstatus = false;
	String strEstValidacion = (request.getParameter("estValidacion") == null) ? ""
			: request.getParameter("estValidacion");
	if (strIdInstruc != null && !strIdInstruc.equals("")) {
		if (strEstValidacion.equals("")) {
			strEstValidacion = ActualizaInstrucciones
			.getEstatusPorInstruccion(strIdInstruc);
		}
		String strEstatusValida = ActualizaInstrucciones
		.getEstatusPorInstruccion(strIdInstruc);
		if (!strEstatusValida.equals(strEstValidacion)) {
			bValidaEstatus = true;
		}
	}

	if (!bValidaEstatus && strAccion != null
			&& strAccion.equals("guardar")) {
		strIdInstruc = request.getParameter("id_ins");
		strIdAsunto = request.getParameter("id_asunto");
		strAvance = request.getParameter("ava");
		strIdUsuario = request.getParameter("reasignarUsr");
		strComentarios = request.getParameter("reasignarComen");

		if (BUsuario.getAsistente()) {
			try {
		bInsertar = ActualizaHistorial
				.InsertarReasignacion(
				strIdInstruc,
				strIdAsunto,
				strComentarios,
				gob.hacienda.cgtic.siga.Usuario
				.aTitular(BUsuario
						.getIdUsuario()),
				strFechaCreacion,
				BUsuario.getCargo()
				+ " / "
				+ BUsuario.getNombre()
				+ " en Nombre de "
				+ gob.hacienda.cgtic.siga.instruccion.Rechazo
						.aNombre(BUsuario,
						strIdInstruc));
			} catch (Exception e) { //System.err.println("ReasignarRechazo-->"+e.getMessage());
			}
		} else
			bInsertar = ActualizaHistorial.InsertarReasignacion(
			strIdInstruc, strIdAsunto, strComentarios,
			strIdUsrReasigna, strFechaCreacion, BUsuario
			.getCargo()
			+ " / " + BUsuario.getNombre());

		bReasignar = ActualizaInstrucciones.ActualizaReasignar(
		strIdInstruc, strIdUsuario, strAvance);

		String strFolioBit = ActualizaInstrucciones
		.getUltimoFolioTurnado(strIdInstruc);
		bInsertarBit = ActualizaBitacora.InsertarEventoReasignar(
		BUsuario.getIdUsuario(), strFolioBit);

		String strUsr[][] = ActualizaUsuario
		.NombreMailUsuario(strIdUsuario);
		String UsrNombreResponde = BUsuario.getCargo()+"/"+BUsuario.getNombre();
		String UsrNombreDirigido = strUsr[0][2];
		String UsrMailDirigido = strUsr[0][1];
		if (BUsuario.getReasignar()) {
			if (ActualizaUsuario.getNotificacionMail(strIdUsuario)) {
		        SenderMail mail = new SenderMail();
		        mail.sendNotificarInstruccionReasignada(
				UsrMailDirigido, UsrNombreDirigido,
				UsrNombreResponde, Integer
				.parseInt(strIdInstruc),
				strComentarios, session.getServletContext());
			}

		}

		try {
			/*KHCH Navegacion Reasignacion*/
			//response.sendRedirect(retURI);
			response.sendRedirect((retURI2 == null
			|| retURI2.equals("") || retURI2
			.equalsIgnoreCase("null")) ? retURI : retURI2);
		} catch (java.io.IOException io) {
			//System.out.println("E/RROR:"+io.getMessage());
		}
	}
	//	String strTurnador = ActualizaInstrucciones.getTurnador(strIdInstruc);
	String strTurnador = Actualiza.getTurnador(strIdInstruc, BUsuario
			.getIdUsuario());
	bEsAtencion = ActualizaUsuario.getEsAtencion(strTurnador);
	String strUsuarios[][] = null;
	Vector vNombres1 = new Vector();
	Vector vIds = new Vector();
	//	if((strUsrOrg.equals(BUsuario.getIdUsuario())&&BUsuario.getTurnado()) || (Actualiza.esTurnador(strUsrOrg)&&BUsuario.getTurnado())){
	if ((strTurnador.equals(BUsuario.getIdUsuario()) || Actualiza
			.esTurnador(strTurnador))
			&& BUsuario.getTurnado()) {
		strUsuarios = Actualiza.getIdPersonalArea(BUsuario.getIdArea());
		AsignarArbol tree = new AsignarArbol(strUsuarios);
		vNombres1 = tree.getNombres();
		vIds = tree.getIds();
	} else if (strUsrOrg.equals(BUsuario.getIdUsuario())) {
		strUsuarios = ActualizaUsuario.getSubordinados(strUsrOrg);
		AsignarArbol tree = new AsignarArbol(strUsuarios);
		vNombres1 = tree.getNombres();
		vIds = tree.getIds();
	} else {
		if (bEsAtencion && !BUsuario.getAsistente()) {
			//	strUsuarios = ActualizaUsuario.getSubordinados(BUsuario.getIdUsuario());
			strUsuarios = ActualizaUsuario.getSubordinados(strTurnador);
			AsignarArbol tree = new AsignarArbol(strUsuarios);
			vNombres1 = tree.getNombres();
			vIds = tree.getIds();
		} else if (BUsuario.getAsistente()) {
			strUsuarios = ActualizaUsuario.getSubordinados(strTurnador);
			AsignarArbol tree = new AsignarArbol(strUsuarios);
			vNombres1 = tree.getNombres();
			vIds = tree.getIds();
		} else {
			strUsuarios = ActualizaUsuario.getSubordinados(BUsuario
			.getIdUsuario());
			AsignarArbol tree = new AsignarArbol(strUsuarios);
			vNombres1 = tree.getNombres();
			vIds = tree.getIds();
		}
	}
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>Reasignar</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
	
	function regresar(){
		//history.go(-1);
                var url='<%=retURI%>';
		location.assign(url);
	}
	
	function Reasignar(){	
        document.getElementById("btnReasignar").disabled = true;
        doc = document.reasignar1;
		//valida = 0;
		msg="";

		if (doc.reasignarUsr[doc.reasignarUsr.selectedIndex].value == -1){
			valida =1;
			msg = msg + " Debes seleccionar un Usuario	"+ "\n";
		}
		
		if (doc.reasignarComen.value == "") {
			valida =1;
			msg = msg + " Debe capturar un comentario de Reasignación	"+ "\n";
		}
	
		if (valida == 1){
			valida=0;
			alert(msg);
                        document.getElementById("btnReasignar").disabled = false;
			return false;
		}else if(valida==2){
			alert("Su solicitud ya fue enviada");
                        document.getElementById("btnReasignar").disabled = false;
			return false;
		}else{
			doc.accion.value="guardar";
			if (confirm("Está usted seguro que desea Reasignar la instrucción?")){
				valida=2;
				doc.submit();
			}else{
				alert("Su petición de Reasignación ya fue cancelada");
                                document.getElementById("btnReasignar").disabled = false;
			}
		}
	}
</SCRIPT>
<SCRIPT src="../js/SigmaJsCat.js" type=text/javascript></SCRIPT>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load();valida = 0;" onKeyPress="timer_reload()"
	onClick="timer_reload()"
	onMouseMove="limitaTextArea(document.reasignar1.reasignarComen,'Comentarios','4000')">
<FORM action="Reasignar.jsp" name="reasignar1" method="post"><INPUT
	type="hidden" value="" name="accion"> <INPUT type="hidden"
	value="<%=strIdInstruc%>" name="id_ins"> <INPUT type="hidden"
	value="<%=strIdAsunto%>" name="id_asunto"> <INPUT type="hidden"
	value="<%=strAvance%>" name="ava"> <INPUT type="hidden"
	value="<%=strUsrOrg%>" name="usr_ori"> <INPUT type="hidden"
	value="<%=strUsuario%>" name="id_usuario"> <INPUT type="hidden"
	value="<%=retURI%>" name="retURI"> <%--KHCH Navegacion Reasignacion--%>
<INPUT type="hidden" value="<%=retURI2%>" name="retURI2"> <INPUT
	type="hidden" value="<%=strEstValidacion%>" name="estValidacion">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336" colspan="2"><INPUT class="blue100"
				onclick="regresar();" type="button" value="Cancelar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT id="btnReasignar" name="btnReasignar" class="blue100"
				onclick="Reasignar();" type="button" value="Aceptar">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="672" bgcolor="#00204f" colspan="4"><FONT size="0">&nbsp;</FONT></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>


<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Puesto:</FONT></TD>
			<TD width="528" colspan="3"><SELECT name="reasignarUsr"
				onkeypress="buscar_op1(this)" onblur="borrar_buffer()"
				onclick="borrar_buffer()" class="blue500a" onchange='puestoReg()'>
				<OPTION value="-1">-- Compañeros de la Unidad a Reasignar
				--</OPTION>
				<%
				for (int i = 0; i < vNombres1.size(); i++) {
				%>
				<OPTION value="<%=vIds.get(i)%>"
					<%=(strUsuario.equals(vIds.get(i))?"selected":"")%>><%=ActualizaUsuario.NombreUsuario((String) vIds.get(i))%>/<%=vNombres1.get(i)%></OPTION>
				<%
				}
				%>
			</SELECT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<%
		if (!bEsAtencion) {
		%>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Responsable:</FONT></TD>
			<TD width="528" colspan="3">
			<%
			if (strUsuario != null && strUsuario.length() != 0) {
			%> <FONT face="Arial" color="#004080" size="2"><%=ActualizaUsuario.NombreUsuario(strUsuario)%></FONT>
			<%
			} else {
			%> <FONT face="Arial" color="#004080" size="2">----</FONT> <%
 }
 %>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<%
		}
		%>
		<TR valign="top">
			<TD width="144"><FONT face="Arial" color="#004080" size="2">Comentarios:</FONT></TD>
			<TD width="528" colspan="3"><TEXTAREA cols="50" rows="5"
				class="blue500a" name="reasignarComen"
				onKeyDown="limitaTextArea(document.reasignar1.reasignarComen,'Comentarios','4000')"></TEXTAREA>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<script type="text/javascript">
<!--
if (<%= bValidaEstatus %>){
	alert("Esta Instrucción ha sido modificada por otro usuario y cambió su Estatus,\npor lo que la acción solicitada será cancelada");
	location.assign("portalPrincipal.jsp");
}
//-->
</script></FORM>
</BODY>
</HTML>