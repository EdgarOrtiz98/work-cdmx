<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Unidad Administrativa</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page
	import="com.meve.sigma.actualiza.*,com.meve.sigma.taglib.*,com.meve.sigma.beans.*"
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
	String strIdArea	=	"";
	String strIdArea1 	= 	ActualizaUsuario.getAreaUsuario(BUsuario.getIdUsuario());
	strIdArea			=	(request.getParameter("id_area")== null)?"":request.getParameter("id_area");
%>
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERUsuarioInvalido.jsp"></jsp:forward>
<%}%>
<% if(BUsuario.getAdmon() ||
		(BUsuario.getSupervisor() && strIdArea.equals(BUsuario.getIdArea()))){ %>
<%}else{%>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<%}%>
<%
	String strArea			=	(request.getParameter("area")== null)?"":request.getParameter("area");
	String strDescripcion	=	(request.getParameter("areaDescripcion")== null)?"":request.getParameter("areaDescripcion");
	String strIdResponsable	=	(request.getParameter("areaResponsable")== null)?"":request.getParameter("areaResponsable");
	String strCreador		=	"";
	String strCreador1		=	"";		
	String strFechaCreacion	=	"";
	String strAccion		=	"";
	String strEstatus		=	"1";
	String strAreas[][]		=	null;
	String strHoraEntrada	=	(request.getParameter("hora_entrada")== null)?"":request.getParameter("hora_entrada");
	String strHoraSalida	=	(request.getParameter("hora_salida")== null)?"":request.getParameter("hora_salida");
	String strMinEntrada	=	(request.getParameter("min_entrada")== null)?"":request.getParameter("min_entrada");
	String strMinSalida		=	(request.getParameter("min_salida")== null)?"":request.getParameter("min_salida");
	String strLogo			=	"";
	String strClave			=	(request.getParameter("areaClave")== null)?"":request.getParameter("areaClave");
	String strIdAreaPadre	=	(request.getParameter("areaPadre")== null)?"":request.getParameter("areaPadre");
	String strIdResponTMP	=	(request.getParameter("idres")== null)?"":request.getParameter("idres");
	String strBandera		=	(request.getParameter("areaExterna")== null)?"0":request.getParameter("areaExterna");
	String strSubVent		=	(request.getParameter("areaSubventanilla")== null)?"0":request.getParameter("areaSubventanilla");
	String strCtrlEnt		=	"0";
	String strCtrlSal		=	"0";

	String strArea2 = "1a2b3c";
	String retURI = (request.getParameter("retURI")== null)?"AreaView.jsp":request.getParameter("retURI");

	boolean bInsertar		=	false;
	int valida = -2;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	String strFechaCreacion2 		=	strFechaCreacion;
	
	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
	
	strAccion		=	request.getParameter("accion");
	
	if(strIdArea != null && strIdArea.length()!=0)
	{
		strAreas=ActualizaArea.getAreas(strIdArea);
		strArea=strAreas[0][0];		
		strDescripcion=strAreas[0][1];
		strIdResponsable=strAreas[0][2];
		strHoraEntrada = strAreas[0][3];
		strHoraSalida = strAreas[0][4];
		strMinEntrada = strAreas[0][5];
		strMinSalida = strAreas[0][6];
		strClave = strAreas[0][7];
		strIdAreaPadre = strAreas[0][8];
		strCtrlEnt = strAreas[0][9];
		strCtrlSal = strAreas[0][10];
		strCreador = ActualizaUsuario.NombreUsuario(strAreas[0][11]);
		strFechaCreacion2 = strAreas[0][12];
		strBandera = strAreas[0][13];
		strSubVent = strAreas[0][14];
		strArea2 = strArea;
	}

	if(strHoraEntrada.length()==1)
		strHoraEntrada = "0"+strHoraEntrada;
	if(strHoraSalida.length()==1)
		strHoraSalida = "0"+strHoraSalida;
	if(strMinEntrada.length()==1)
		strMinEntrada = "0"+strMinEntrada;
	if(strMinSalida.length()==1)
		strMinSalida = "0"+strMinSalida;
	
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strArea				=	request.getParameter("area");
		strDescripcion		=	request.getParameter("areaDescripcion");
		strIdResponsable	=	request.getParameter("areaResponsable");
		strHoraEntrada		=	request.getParameter("hora_entrada");
		strMinEntrada		=	request.getParameter("min_entrada");
		strHoraSalida		=	request.getParameter("hora_salida");
		strMinSalida		=	request.getParameter("min_salida");
		strClave			=	request.getParameter("areaClave");
		strIdAreaPadre		=	request.getParameter("areaPadre");
		strCtrlEnt			=	request.getParameter("areaCtrlEntrada"); 
		strCtrlSal			=	request.getParameter("areaCtrlSalida");
		strArea2			=	request.getParameter("area2");
		strBandera			=	(request.getParameter("areaExterna")== null)?"1":request.getParameter("areaExterna");
		strSubVent			=	(request.getParameter("areaSubventanilla")== null)?"1":request.getParameter("areaSubventanilla");
		////System.err.println("strBandera="+strBandera);
		
		valida = ActualizaArea.getAreaExiste(strArea, strArea2);

		if (valida == 2){ 
			bInsertar	=	ActualizaArea.InsertarArea(	strIdArea, strArea, strDescripcion, strIdResponsable,
														strFechaCreacion, strCreador1, strEstatus,
														strHoraEntrada, strHoraSalida, strMinEntrada,
														strMinSalida, 0, strClave, strIdAreaPadre,
														strCtrlEnt, strCtrlSal, strBandera, strSubVent);
			try{ 
				//response.sendRedirect("AreaView.jsp");
				response.sendRedirect(retURI);
			}catch(java.io.IOException io){
				//System.out.println("io->"+io);
			}
		}			
	}
	
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="valida=0;timer_load();" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="Area.jsp" name="Area" method="post">
<INPUT type="hidden" value="" name="accion">
<%if (strIdArea!=null && strIdArea.length()!=0){ %> 
<INPUT type="hidden" value="<%=strIdArea %>" name="id_area">
<%}%>
<INPUT type="hidden" value="<%=strArea2 %>" name="area2">
<INPUT type="hidden" value="<%=strIdResponTMP %>" name="idres">
<INPUT type="hidden" value="<%=retURI %>" name="retURI">

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD colspan="2"><A href="<%= retURI %>"> <IMG border="0"
				src="../Imagenes/NavLeft.gif" title="Regresar"> </A>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a onclick="guardarArea()">
				<img src="../Imagenes/Save.gif" title="Guardar">
				</a>
			</TD>
		</TR>
		<TR valign="top">
			<TD colspan="2" class="etiquetas1v"><B><FONT size="+1">Unidad
			Administrativa</FONT></B></TD>
			<TD colspan="2" align="right">&nbsp;<FONT color="black">**Los datos
			marcados con negritas son obligatorios</FONT></TD>
		</TR>
		<TR valign="top">
			<td width="672" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>

		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<TD align="right" colspan="3"><FONT face="Verdana"
				size="2"><%=(strIdArea!=null && strIdArea.length()!=0)?"Última modificación por: ":"Creado por: "%><I><%= strCreador %> - <%= strFechaCreacion2 %></I></FONT>
			</TD> 
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;<BR></TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144" class="etiquetas"><b>Nombre Unidad:</b>
			<%if (valida == 1) {%><br>
			<FONT color="red"><B>*Esta Unidad ya existe* </B></FONT><%} %>
			</TD>
			<TD width="528" colspan="3">
				<FONT face="Verdana" size="2">
				<%if(BUsuario.getAdmon()){%>
				<INPUT type="text" class="blue600a" size="80" name="area" value="<%=strArea %>" maxlength="199">
				<INPUT type="hidden" name="bandera" value="1">
				<%}else{%>
				<INPUT type="text" class="blue600a" size="80" name="area1" value="<%=strArea %>" maxlength="199" disabled="disabled">
				<INPUT type="hidden" name="area" value="<%=strArea %>">
				<INPUT type="hidden" name="bandera" value="2">
				<%}%>
				</FONT>
			</TD>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		
		<TR valign="top">
			<TD width="144" class="etiquetas"><b>Clave de la Unidad:</b></TD>
			<TD width="528" colspan="3">
				<FONT face="Verdana" size="2">
				<%if(BUsuario.getAdmon()){%>
				<INPUT class="blue200a" size="80" name="areaClave" value="<%=strClave %>" maxlength="49">
				<%}else{%>
				<INPUT class="blue200a" size="80" name="areaClave1" value="<%=strClave %>" maxlength="49" disabled="disabled">
				<INPUT type="hidden" name="areaClave" value="<%=strClave %>">
				<%}%>
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
			<TD width="144" class="etiquetas">Descripción:</TD>
			<TD width="528" colspan="3">
				<FONT face="Verdana" size="2">
				<%if(BUsuario.getAdmon()){%>
				<INPUT class="blue600a" size="80" name="areaDescripcion" value="<%=strDescripcion %>" maxlength="199">
				<%}else{%>
				<INPUT class="blue600a" size="80" name="areaDescripcion1" value="<%=strDescripcion %>" maxlength="199" disabled="disabled">
				<INPUT type="hidden" name="areaDescripcion" value="<%=strDescripcion %>">
				<%}%>
				</FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<%if(strIdArea != null && strIdArea.length()!=0){%>
		<TR valign="top">
			<TD width="144" class="etiquetas">Puesto:</TD>
			<%if(BUsuario.getAdmon()){%>
			<%if(strIdResponTMP.length()>0){%>
			<TD width="528" colspan="3"><FONT SIZE=2 FACE="Verdana"><meve_combo:comboseleccion
				data="<%= ComboData.getUsuarioCombo(strIdArea) %>" size="1"
				name="areaResponsable" classHtml="blue600a"
				selected="<%= strIdResponTMP%>" textoNoSeleccion="-- Selecciona un Puesto --"
				valorNoSeleccion="null" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='cambioArea(this)'"/> </FONT>
			</TD>
			<%}else{%>
			<TD width="528" colspan="3"><FONT SIZE=2 FACE="Verdana"><meve_combo:comboseleccion
				data="<%= ComboData.getUsuarioCombo(strIdArea) %>" size="1"
				name="areaResponsable" classHtml="blue600a"
				selected="<%= strIdResponsable%>" textoNoSeleccion="-- Selecciona un Puesto --"
				valorNoSeleccion="null" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='cambioArea(this)'"/> </FONT>
			</TD>
			<%}%>
			<%}else{%>
			<TD width="528" colspan="3"><FONT SIZE=2 FACE="Verdana"><meve_combo:comboseleccion
				data="<%= ComboData.getUsuarioCombo(strIdArea) %>" size="1"
				name="areaResponsable1" classHtml="blue600a"
				selected="<%= strIdResponsable%>" textoNoSeleccion="-- Selecciona un Puesto --"
				valorNoSeleccion="null" disabled="true"
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='cambioArea(this)'"/> </FONT>
				<INPUT type="hidden" name="areaResponsable" value="<%= strIdResponsable%>">
			</TD>
			<%}%>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080">Responsable:</FONT></TD>
			<TD width="192">
				<%if(strIdResponTMP.length()>0){%>
					<%if(!strIdResponTMP.equals("null")){%>
					<%=ActualizaUsuario.NombreUsuario(strIdResponTMP)%>
					<%}else{%>
					No tiene Responsable Asignado
					<%}%>
				<%}else{%>
					<%if(strIdResponsable.length()!=0){%>					
					<%=ActualizaUsuario.NombreUsuario(strIdResponsable)%>
					<%}else{%>
					No tiene Responsable Asignado
					<%}%>
				<%}%>
			</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<%}else{%> 
		<TR valign="top">
			<TD>&nbsp;</TD>
			<TD>&nbsp;
			<INPUT name="areaResponsable" type="hidden" value="null">
			</TD>
		</TR>
		<%}%>
		<TR valign="top">
			<TD width="144" class="etiquetas">Unidad Padre:</TD>
			<%if(BUsuario.getAdmon()){%>
			<TD width="528" colspan="3">
				<%if(strIdArea.length()!=0){%>
					<meve_combo:comboseleccion
					data="<%= ComboData.getAreaComboExcluyeId(strIdArea) %>" size="1" name="areaPadre"
					classHtml="blue600a" selected="<%= strIdAreaPadre %>"
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
					valorNoSeleccion="null" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<%}else{%>
					<meve_combo:comboseleccion
					data="<%= ComboData.getAreasCombo() %>" size="1" name="areaPadre"
					classHtml="blue600a" selected="<%= strIdAreaPadre %>"
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
					valorNoSeleccion="null" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<%}%>
			</TD>
			<%}else{%>
			<TD width="528" colspan="3">
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreaComboExcluyeId(strIdArea) %>" size="1" name="areaPadre1"
				classHtml="blue600a" selected="<%= strIdAreaPadre %>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="null" disabled="true"
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<INPUT type="hidden" name="areaPadre" value="<%= strIdAreaPadre %>">
			</TD>
			<%}%>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144" class="etiquetas"><b>Hora de Entrada:</b></TD>
			<%if(BUsuario.getAdmon()){%>
			<TD width="528" colspan="3">
				<SELECT name="hora_entrada" class="blue50a">
					<OPTION value="-1">--</OPTION>
					<%for(int i=0;i<24;i++){%>
					<%
					String a = String.valueOf(i);
					if(a.length()==1)
						a="0"+a;
					%>
					<OPTION value="<%=a%>" <%=(strHoraEntrada.trim().equals(""+a+"")?"selected":"")%>><%=a%></OPTION>
					<%}%>
				</SELECT>
				<FONT face="Verdana" size="2">:</FONT>
				<SELECT name="min_entrada" class="blue50a">
					<OPTION value="-1">--</OPTION>
					<%for(int i=0;i<60;i++){%>
					<%
					String a = String.valueOf(i);
					if(a.length()==1)
						a="0"+a;
					%>
					<OPTION value="<%=a%>" <%=(strMinEntrada.trim().equals(""+a+"")?"selected":"")%>><%=a%></OPTION>
					<%}%>
				</SELECT>
			</TD>
			<%}else{%>
			<TD width="528" colspan="3">
				<SELECT name="hora_entrada1" class="blue50a" disabled="disabled">
					<OPTION value="-1">--</OPTION>
					<%for(int i=0;i<24;i++){%>
					<%
					String a = String.valueOf(i);
					if(a.length()==1){
						a="0"+a;
					}
					%>
					<OPTION value="<%=a%>" <%=(strHoraEntrada.trim().equals(""+a+"")?"selected":"")%>><%=a%></OPTION>
					<%}%>
				</SELECT>
				<INPUT type="hidden" name="hora_entrada" value="<%=strHoraEntrada%>">
				<FONT face="Verdana" size="2">:</FONT>
				<SELECT name="min_entrada1" class="blue50a" disabled="disabled">
					<OPTION value="-1">--</OPTION>
					<%for(int i=0;i<60;i++){%>
					<%
					String a = String.valueOf(i);
					if(a.length()==1){
						a="0"+a;
					}
					%>
					<OPTION value="<%=a%>" <%=(strMinEntrada.trim().equals(""+a+"")?"selected":"")%>><%=a%></OPTION>
					<%}%>
				</SELECT>
				<INPUT type="hidden" name="min_entrada" value="<%=strMinEntrada%>">
			</TD>
			<%}%>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144" class="etiquetas"><b>Hora de Salida:</b></TD>
			<%if(BUsuario.getAdmon()){%>
			<TD width="528" colspan="3">
				<SELECT name="hora_salida" class="blue50a">
					<OPTION value="-1">--</OPTION>
					<%for(int i=0;i<24;i++){%>
					<%
					String a = String.valueOf(i);
					if(a.length()==1)
						a="0"+a;
					%>
					<OPTION value="<%=a%>" <%=(strHoraSalida.trim().equals(""+a+"")?"selected":"")%>><%=a%></OPTION>
					<%}%>
				</SELECT>
				<FONT face="Verdana" size="2">:</FONT>
				<SELECT name="min_salida" class="blue50a">
					<OPTION value="-1">--</OPTION>
					<%for(int i=0;i<60;i++){%>
					<%
					String a = String.valueOf(i);
					if(a.length()==1)
						a="0"+a;
					%>
					<OPTION value="<%=a%>" <%=(strMinSalida.trim().equals(""+a+"")?"selected":"")%>><%=a%></OPTION>
					<%}%>
				</SELECT>
			</TD>
			<%}else{%>
			<TD width="528" colspan="3">
				<SELECT name="hora_salida1" class="blue50a" disabled="disabled">
					<OPTION value="-1">--</OPTION>
					<%for(int i=0;i<24;i++){%>
					<%
					String a = String.valueOf(i);
					if(a.length()==1)
						a="0"+a;
					%>
					<OPTION value="<%=a%>" <%=(strHoraSalida.trim().equals(""+a+"")?"selected":"")%>><%=a%></OPTION>
					<%}%>
				</SELECT>
				<INPUT type="hidden" name="hora_salida" value="<%=strHoraSalida%>">
				<FONT face="Verdana" size="2">:</FONT>
				<SELECT name="min_salida1" class="blue50a" disabled="disabled">
					<OPTION value="-1">--</OPTION>
					<%for(int i=0;i<60;i++){%>
					<%
					String a = String.valueOf(i);
					if(a.length()==1)
						a="0"+a;
					%>
					<OPTION value="<%=a%>" <%=(strMinSalida.trim().equals(""+a+"")?"selected":"")%>><%=a%></OPTION>
					<%}%>
				</SELECT>
				<INPUT type="hidden" name="min_salida" value="<%=strMinSalida%>">
			</TD>
			<%}%>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144" class="etiquetas">Operando en SIGA:</TD>
			<TD width="528" colspan="3">
				<FONT face="Verdana" size="2">
				<%if(BUsuario.getAdmon()){%>
				<INPUT type="checkbox" name="areaExterna" value="0" <%=(strBandera.equals("0")?"checked":"")%>>Si
				<%}else{%>
				<INPUT type="checkbox" name="areaExterna1" disabled="disabled" value="0" <%=(strBandera.equals("0")?"checked":"")%>>Si
				<INPUT type="hidden" name="areaExterna" value="<%=strBandera%>">
				<%}%>
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
			<TD width="144" class="etiquetas">Manejo de Subventanilla:</TD>
			<TD width="528" colspan="3">
				<FONT face="Verdana" size="2">
				<INPUT type="checkbox" name="areaSubventanilla" value="0" <%=(strSubVent.equals("0")?"checked":"")%>>Si
				</FONT>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<%--
		<TR valign="top">
			<TD width="144" class="etiquetas"><B>Control de Entrada:</B></TD>
			<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT
				class="blue50" size="80" name="areaCtrlEntrada"
				value="<%=strCtrlEnt %>" maxlength="5" onKeyPress='AceptaSoloTeclaNumericaYPunto();'></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B>&nbsp;</B></TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144" class="etiquetas"><B>A&ntilde;o:</B></TD>
			<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT
				class="blue50" size="80" name="areaCtrlSalida"
				value="<%=strCtrlSal%>" maxlength="4" onKeyPress='AceptaSoloTeclaNumerica();'></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		--%>
		<TR valign="top">
			<TD width="100%" colspan="4">
				<FIELDSET dir="ltr">
					<LEGEND align="left">
						<FONT SIZE=2 FACE="Verdana"  color="#004080"><B>Folio de Control</B></FONT>
					</LEGEND>
					<TABLE>
					<TBODY>
						<TR valign="top">
							<TD width="144">&nbsp;</TD>
							<TD width="192">&nbsp;</TD>
							<TD width="144">&nbsp;</TD>
							<TD width="192">&nbsp;</TD>
						</TR>
						<TR valign="top">
							<TD width="144" class="etiquetas"><B>A&ntilde;o:</B></TD>
							<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT
								class="blue50a" size="80" name="areaCtrlSalida"
								value="<%=strCtrlSal%>" maxlength="4" onKeyPress='AceptaSoloTeclaNumerica();'></FONT></TD>
						</TR>
						<TR valign="top">
							<TD width="144">&nbsp;</TD>
							<TD width="192">&nbsp;</TD>
							<TD width="144">&nbsp;</TD>
							<TD width="192">&nbsp;</TD>
						</TR>
						<TR valign="top">
							<TD width="144" class="etiquetas"><B>Consecutivo:</B></TD>
							<TD width="528" colspan="3"><FONT face="Verdana" size="2"><INPUT
								class="blue50a" size="80" name="areaCtrlEntrada"
								value="<%=strCtrlEnt %>" maxlength="5" onKeyPress='AceptaSoloTeclaNumericaYPunto();'></FONT></TD>
						</TR>
						<TR valign="top">
							<TD width="144">&nbsp;</TD>
							<TD width="192">&nbsp;</TD>
							<TD width="144">&nbsp;</TD>
							<TD width="192">&nbsp;</TD>
						</TR>
					</TBODY>
					</TABLE>
				</FIELDSET>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>

</FORM>
</BODY>
</HTML>
