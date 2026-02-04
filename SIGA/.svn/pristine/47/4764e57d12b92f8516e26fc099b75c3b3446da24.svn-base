<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,
			com.meve.sigma.util.Utilerias,
			com.meve.sigma.beans.*,
			com.meve.sigma.taglib.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
    String strProcedencia 	=   "";
	String strIdArea 		= 	"";
	String strIdArea1 		= 	"";
	String strControl		=	"";
	
	String strNombre		=	"";
	String strCargo			=	"";
	String strIdEntidad		=	"";
	String strTelefono		=	"";
	String strCorreo		=	"";
	String strDireccion		=	"";
	String strFax			=	"";
	String strCreador		=	"";
	String strFechaCreacion	=	"";
	String strAccion		=	"";
	String strIdRemitente	=	null;
	
	boolean bInsertar		=	false;
	boolean	bExisteReg 		= 	false;
	
	int valida 				= 	-2;
	
	strProcedencia			=	request.getParameter("porcedencia");
	strIdArea 				= 	(request.getParameter("id_us")!=null)?request.getParameter("id_us"):"";
	strControl				=	(request.getParameter("con")!=null)?request.getParameter("con"):"";
	String strIdAsunto 		= 	(request.getParameter("ida")!=null)?request.getParameter("ida"):"";
	String num 				=	request.getParameter("num");
	strAccion				=	request.getParameter("accion");
	String retURI 			= 	(request.getParameter("retURI")!=null)?request.getParameter("retURI"):"portalPrincipal.jsp";
	String strIdRmt 		= 	(request.getParameter("idRemitente")!=null)?request.getParameter("idRemitente"):"";

	String strBusqueda = (request.getParameter("buscar")!=null)?request.getParameter("buscar"):"";
	boolean bBuscar 	= Utilerias.detectaCEBuscar(strBusqueda)?true:false;
	strBusqueda 		= Utilerias.detectaCEBuscar(strBusqueda)?"":strBusqueda;
	
	String strBusqueda2 = (request.getParameter("buscar2")!=null)?request.getParameter("buscar2"):"";
	boolean bBuscar2 	= Utilerias.detectaCEBuscar(strBusqueda2)?true:false;
	strBusqueda2 		= Utilerias.detectaCEBuscar(strBusqueda2)?"":strBusqueda2;
	
	bExisteReg				=	ActualizaRemitente.getExistenRemitentes();
	
	if(strAccion != null && strAccion.equals("guardar")){
		strNombre		=	request.getParameter("remitente");
		strIdArea1		=	request.getParameter("remitenteArea");
		strCargo		=	request.getParameter("remitenteCargo");
		strIdEntidad	=	request.getParameter("remitenteEntidad");
		strDireccion	=	request.getParameter("remitenteDireccion");
		strTelefono		=	request.getParameter("remitenteTelefono");
		strFax			=	request.getParameter("remitenteFax");
		strCorreo		=	request.getParameter("remitenteCorreo");

		valida = ActualizaRemitente.getRemitenteExiste(strNombre, "1a2b3c", strIdEntidad, "1a2b3c");

		if (valida == 2)
		{
			bInsertar	= 	ActualizaRemitente.InsertarRemitente(	strIdRemitente, strNombre, strCargo, strIdArea1, strIdEntidad, strTelefono,
																	strCorreo, BUsuario.getIdUsuario(), strFechaCreacion, "1", strDireccion, strFax);
			strIdRmt = "0";
			if(bInsertar){
				strIdRmt = ActualizaRemitente.ultimoIdRemitente();
			}
			try{
				if("receptor".equals(strProcedencia)){
					response.sendRedirect(retURI);
			}else{ 
			    response.sendRedirect("FrameRemitente.jsp?id_us="+strIdArea+"&con="+strControl+"&ida="+strIdAsunto+"&num=1&idRemitente="+strIdRmt);
			}
			}catch(Exception io){
				//System.out.println("ErrorRedirect-->"+io);
			}
		}
	}
%>


<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Remitente</TITLE>
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language="JavaScript" type="text/javascript">
function cambioVista(){
	doc = document.frameremitente;
	doc.id_us.value = doc.id_us.value;
	doc.con.value = doc.con.value;
	doc.ida.value = doc.ida.value;
	doc.num.value = 2;
	doc.retURI.value = "<%= "FrameRemitente.jsp?id_us="+strIdArea+"&con="+strControl+"&ida="+strIdAsunto+"&num=1&idRemitente="+strIdRmt %>"
	doc.submit();

}
function cambioVista1(){
	doc = document.frameremitente;
	doc.id_us.value = doc.id_us.value;
	doc.con.value = doc.con.value;
	doc.ida.value = doc.ida.value;
	doc.num.value = 1;
	doc.submit();
}
</SCRIPT>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" 
	onunload="opener.hay_hija=true"
	onClick="opener.resetTimer();"
	onKeyPress="opener.resetTimer();">
<form name="frameremitente" action="FrameRemitente.jsp" method="post">
<INPUT type="hidden" name="id_us" value="<%=strIdArea%>">
<INPUT type="hidden" name="con" value="<%=strControl%>">
<INPUT type="hidden" name="ida" value="<%=strIdAsunto%>">
<INPUT type="hidden" name="num" value="<%=num%>">
<INPUT type="hidden" name="accion" value="">
<INPUT name="retURI" value="<%= retURI %>" type="hidden">
<INPUT name="idRemitente" value="<%= strIdRmt %>" type="hidden">
<input name="porcedencia"value="<%= strProcedencia %>"type="hidden"/>
<%if(num.equals("1")){%>
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="367" class="etiquetas"> 
			<div align="left">
				<!--<input type="button" onclick="" value="Internas" class="blue100">-->
				Puesto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT name="buscar" type="text" value="<%= strBusqueda %>" class="blue200" width="50" maxlength="199"><BR>
				Responsable:&nbsp;
				<INPUT name="buscar2" type="text" value="<%= strBusqueda2 %>" class="blue200" width="50" maxlength="199">
				Buscar:&nbsp;<A title="Buscar" onclick="buscarRemitente();"><IMG border="0" src="../Imagenes/ico_bus.gif" width="26" height="26" ></A><br>
			</div>
		</td>
		<td width="10">
			<div align="right">
				
			</div>
		</td>
		<td width="">
			&nbsp;
		</td>

		<td width="500">
			<DIV align="right">
				<input type="button" value="Otro Remitente..." class="blue200a" onclick="cambioVista()">
				<input type="button" value="Aceptar" class="blue100a" onclick="AceptarRemitenteFrame(<%=strControl%>)">
				<input type="button" value="Cancelar" class="blue100a" onclick="Cancelar()">
			</DIV>
		</td>
	</tr>
</table>
<BR>
<div align="left">
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="100%">
			<b><font size="2" color="#00204F" face="Verdana">Remitentes</font></b>
			<b><font size="2" color="#00204F" face="Verdana">de la Unidad</font></b>
		</td>
	</tr>
</table>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='50%' align="center">
			<FONT SIZE=2 COLOR="FFFFFF" FACE="verdana"><b>Puesto</b></font>
		</TD>
		<TD WIDTH='50%' align="center">
			<FONT SIZE=2 COLOR="FFFFFF" FACE="verdana"><b>Responsable</b></font>
		</TD>
	</TR>	
</TABLE>
<DIV class=documentBody id=Body>
<% if(bExisteReg){ %>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
	<% if(strControl.equals("0")){ %>
	<meve_front:ListaDatos datos="<%= ActualizaRemitente.getRemitenteFrame(strIdArea,strBusqueda,strBusqueda2) %>" campo="campo">
		<TR valign="top">
			<TD width="5%">
				<INPUT type="radio" name="Sel" value="<%= campo1 %>|<%= campo2 %>/<%= campo3 %>*<%= campo4 %>" <%= (strIdRmt.equals(campo1))?"checked=\"checked\"":""%>>
			</TD>
			<TD width="42%">
				<FONT face=Arial color=#000080 size=1>
					<A title="<%= campo3 %>"> <%= Utilerias.recortaString(campo3,60) %> </A>
				</FONT>
			</TD>
			<TD width="5%"> &nbsp;&nbsp;</TD>
			<TD width="48%">
				<FONT face=Arial color=#000080 size=1>
					<A title="<%= campo2 %>"> <%= Utilerias.recortaString(campo2,60) %> </A>
				</FONT>
			</TD>
		</TR>
	</meve_front:ListaDatos>
	<% }else if(strControl.equals("1")){ %>
	<meve_front:ListaDatos datos="<%= ActualizaRemitente.getRemitenteInternas(strIdArea,strBusqueda,strBusqueda2) %>" campo="campo">
		<TR valign="top">
			<TD width="5%">
				<INPUT type="radio" name="Sel" value="<%= campo1 %>|<%= campo2 %>/<%= campo3 %>*<%= campo4 %>" <%= (strIdRmt.equals(campo1))?"checked=\"checked\"":""%>>
			</TD>
			<TD width="42%">
				<FONT face=Arial color=#000080 size=1>
					<A title="<%= campo2 %>"> <%= Utilerias.recortaString(campo2,60) %> </A>
				</FONT>
			</TD>
			<TD width="5%"> &nbsp;&nbsp;</TD>
			<TD width="48%">
				<FONT face=Arial color=#000080 size=1>
					<A title="<%= campo3 %>"> <%= Utilerias.recortaString(campo3,60) %> </A>
				</FONT>
			</TD>
		</TR>
	</meve_front:ListaDatos>
	<% } %>
</TABLE>
<% } else { %>
<CENTER>
<table cellspacing="2" cellpadding="2">
	<tr>
		<TD align="center">
			<DIV align="center">
				<p><FONT size="4" face="Verdana">***** No se han encontrado
		Documentos ***** </FONT></DIV>
		</TD>
	</tr>
</table>
</CENTER>
<SCRIPT language="JavaScript" type="text/javascript">
	if (<%= bBuscar %>)
		alert("No se permiten caracteres especiales ( % , & , \' ) en la Busqueda "+ "\n");
</SCRIPT>
<%}%>
<BR>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<%}%>
<%if(num.equals("2")){%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="150">
			<!-- <a onclick="cambioVista1()"> -->
			<a href="<%= retURI %>">
			<img src="../Imagenes/NavLeft.gif" title="Regresar" border="0">
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a onclick="guardarRemitenteOtro1()">
			<img src="../Imagenes/Save.gif" title="Guardar" border="0">
			</a>
		&nbsp;</TD>
		<TD width="150">

		&nbsp;</TD>
		<TD width="150"></TD>
		<TD width="217"></TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
<BR>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
        <TR valign="top">
            <TD width="336" colspan="2"><B><FONT face="Verdana" color="#00204f" size="2">Remitentes</FONT></B></TD>
            <TD width="144">&nbsp;</TD>
            <TD width="192">&nbsp;</TD>
        </TR>
        <TR valign="top">
			<td bgcolor="#004080" colspan="4" width="672"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>
		<TR valign="top">
			<TD width="144">
				<FONT face="Verdana" size="2">&nbsp;</FONT>
			</TD>
			<TD align="right" colspan="3" width="528">
				<FONT face="Verdana" size="2"></FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
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
		<TD width="144"><FONT face="Verdana" size="2"><B>Unidad
			Administrativa:</B></FONT></TD>
		<TD width="528" colspan="3">
		<FONT face="Verdana" size="2">
			<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1"
					name="remitenteArea" classHtml="blue500a" 
					selected="<%=BUsuario.getIdArea()%>" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
		</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2"><B>Nombre:</B></FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitente" value="<%=strNombre %>" maxlength="199"></FONT>
		<%if (valida == 1) {%><br>
		<FONT color="red"><B>*Este Nombre ya existe en esta Entidad* </B></FONT><%} %>
		</TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2"><B>Cargo:</B></FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitenteCargo" value="<%=strCargo %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2"><B>Entidad:</B></FONT></TD>
		<TD width="528" colspan="3">
			<FONT face="Verdana" size="2">
				<meve_combo:comboseleccion data="<%= ComboData.getEntidadAreaCombo(BUsuario.getIdArea()) %>" 
					size="1" name="remitenteEntidad" classHtml="blue500a" 
					selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Entidad ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
			</FONT>
		</TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2">Dirección:</FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitenteDireccion" value="<%=strDireccion %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2">Telefono:</FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitenteTelefono" value="<%=strTelefono %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2">Fax:</FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitenteFax" value="<%=strFax %>" maxlength="49"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2">Correo:</FONT></TD>
		<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue500" name="remitenteCorreo" value="<%=strCorreo %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>
	
    </TBODY>
</TABLE>
</DIV>
<%}%>
</form>
</BODY>
</HTML>
