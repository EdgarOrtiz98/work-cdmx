<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%> 
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.taglib.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	String 	cat			= BUsuario.getCatArchivado();
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
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<%
	String msg = "";
	String strIdArea = (request.getParameter("idArea")!= null)?request.getParameter("idArea"):BUsuario.getIdArea();
	String strIdSubfondo	=	"";
	String strCodigo		=	"";
	String strSeccion		=	"";
	String strUsrActualiza	=	"";
	String strFecha			=	"";
	String strAccion		=	"";
	String strClave			=	"";	
	String strComb			=	"";	
	String strMotivo		=	"";	
	String strFunda			=	"";	
	String strSerie			=	"";	
	String strSubserie		=	"";		
	String strSerID			=	"0";	
	String strSubsID		=	"0";	
	int bInsertar1		=	0;
	String strInact			=	"";
	String strFecInac		=	"";
	String strJustInac		=	"";	
	String ver				=	"";		
	String horafec			=	"";
	String strsoloDesc 		=	"";

	String strAux = "1234567";
	String strAux2 = "1234567";

		int valida		=	0;
	boolean bInsertar		=	false;
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFecha						=	sdf.format(f);

	String retURI = (request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
	strAccion		=	request.getParameter("accion");
	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
	
	

	
	
	
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo");
			strClave	=	request.getParameter("clave").toUpperCase(); 			
			strIdArea	=	request.getParameter("idArea"); 
			strComb		=	request.getParameter("comb"); 
			strMotivo	=	request.getParameter("motivo");
			strFunda	=	request.getParameter("fundar");
			strSubserie	=	(request.getParameter("Subserie") != null)?request.getParameter("Subserie"):"null";
			strSerie	=	(request.getParameter("Serie") != null)?request.getParameter("Serie"):"null";
						
			bInsertar1	=	ActualizaExpArchivado.insertarTipCed(strCodigo, strSeccion,
																strFecha, BUsuario.getIdUsuario(),strClave,strIdArea,strComb,strAux,strAux2,
																strMotivo,strFunda,strSubserie,strSerie);

			if(bInsertar1 == 2){;}
			else{
				try{
					response.sendRedirect(retURI+"&msg="+msg);
				}catch(java.io.IOException io){;}	
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strsoloDesc =	request.getParameter("soloDesc");
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo");
			 if (strsoloDesc!="1" && !strsoloDesc.equalsIgnoreCase("1"))
    	        {
				strClave	=	request.getParameter("clave").toUpperCase(); 
				}
			strIdArea	=	request.getParameter("idarea2"); 
			strComb		=	request.getParameter("comb2"); 			
			strAux 		= 	request.getParameter("aux"); 
			strAux2 	= 	request.getParameter("aux2"); 
			strMotivo	=	request.getParameter("motivo");
			strFunda	=	request.getParameter("fundar");
			strSubserie	=	(request.getParameter("Subserie") != null)?request.getParameter("Subserie"):request.getParameter("idsubr");
			strSerie	=	(request.getParameter("Serie") != null)?request.getParameter("Serie"):request.getParameter("idserr");
			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
			strFecInac	=	request.getParameter("fecinact");
			strJustInac =	request.getParameter("justif");				
					 
			bInsertar1 = ActualizaExpArchivado.actualizaTipCed(strsoloDesc, strCodigo, strSeccion, strFecha, 
															BUsuario.getIdUsuario(), strIdSubfondo,strClave,strIdArea,strComb,strAux,strAux2,
															strMotivo,strFunda,strSubserie,strSerie,strFecInac,strJustInac,strInact);

			if(bInsertar1 != 2){
				try{
					response.sendRedirect(retURI);
				}catch(java.io.IOException io){;}
			}
		}
	}
	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
	{
		String strDatosSubfondo[][] = ActualizaExpArchivado.getTipCed(strIdSubfondo);
		strCodigo		=	strDatosSubfondo[0][0];
		strSeccion		=	strDatosSubfondo[0][1];
		strFecha		=	strDatosSubfondo[0][2];
		strUsrActualiza	=	strDatosSubfondo[0][3];
		strClave		=	strDatosSubfondo[0][4];		
		strIdArea		=	strDatosSubfondo[0][5];	
		strMotivo		=	strDatosSubfondo[0][6];	
		strFunda		=	strDatosSubfondo[0][7];	
		strSubserie		=	strDatosSubfondo[0][8];	
		strSerie		=	strDatosSubfondo[0][9];	
		strFecInac		=	strDatosSubfondo[0][10];	
		strJustInac		=	strDatosSubfondo[0][11];	
		strInact		=	strDatosSubfondo[0][12];	
		horafec			=	strDatosSubfondo[0][13];	
		ver				=	"si";		
		strAux			=  	strClave;				
		strAux2			=  	strIdArea;				

		
		valida	=	ActualizaExpArchivado.getValidaCedula(strIdSubfondo);
		
	}
	if(strIdArea!=null && strIdArea.trim().length()>0)
	{
		strSerID		=	strIdArea;
		strSubsID		=	strIdArea;
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
<TITLE>Cédula Tipo</TITLE>
<script type="text/javascript" src="../js/valida.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
<!-- 
	function limpiarCampos(){
		document.tipcedf.reset();
	}
</SCRIPT>
<SCRIPT language="JavaScript" type="text/javascript">


 function detalle2() { 
	}	
 function rValidando() {
	<%if(valida == 2) 
	{%>
	alert("Como este registro ya cuenta con registros dependientes, solo podra ser modificado su descripción");
	<%
	}%>
 }

 function cambio(){
	doc = document.tipcedf;
	val = doc.idArea.value;
	doc.idarea2.value = val;
	doc.submit();
	} 
	

function habilita2()
	{
		if(document.tipcedf.inactivo.checked == true)
		{
		document.tipcedf.fecinact.value = "<%=horafec%>";
		document.tipcedf.fecinact.disabled = false;
		document.tipcedf.justif.disabled = false;
		}else
		{
		document.tipcedf.fecinact.value = "";
		document.tipcedf.justif.value = "";
		document.tipcedf.fecinact.disabled = true;
		document.tipcedf.justif.disabled = true;
		}
	}	
	
function desSub()
	{
		doc = document.tipcedf;
		doc.Subserie[doc.Subserie.selectedIndex].value == -1;
		alert();
	}
function desSerie()
	{
		doc = document.tipcedf;
		doc.Serie[doc.Serie.selectedIndex].value == -1;
	}		

</SCRIPT>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;rValidando();setFormFocusTipCed();limpiarCampos();timer_load();detalle2();" 
	onKeyPress="timer_reload();" 
	onmousemove="limitaTextArea(document.tipcedf.subSeccion,'Descripción','4000')"
	onClick="timer_reload();">
<FORM action="TipoCedArch.jsp" name="tipcedf" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdSubfondo%>" name="id_sub">
<INPUT type="hidden" value="<%=strAux%>" name="aux">
<INPUT type="hidden" value="<%=strAux2%>" name="aux2">
<INPUT type="hidden" value="<%=strIdArea%>" name="idarea2">
<INPUT type="hidden" value="<%=strComb%>" name="comb2">
<INPUT type="hidden" value="<%=retURI%>" name="retURI">
<INPUT type="hidden" value="<%=strSubserie%>" name="idsubr">
<INPUT type="hidden" value="<%=strSerie%>" name="idserr">
<%if(valida == 2){
		strsoloDesc = "1";
	}
	%>
<INPUT type="hidden" value="<%=strsoloDesc%>" name="soloDesc">
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><a href="<%= retURI %>"> <IMG
				border="0" src="../Imagenes/NavLeft.gif" title="Regresar"> </a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
				<a></a>
			<%	}else{%>	
				<a><img	src="../Imagenes/Save.gif" title="Guardar" border="0" onclick="GuardarTipCed()"></a>
			<%}%>				</TD>
			<TD width="125">
			</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="48"></TD>
		</TR>
		<TR valign="top">
			<TD></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>


<DIV class="documentBody" id="Body" style="HEIGHT: 441px">
<DIV align="center">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD colspan="2" width="199"><B><FONT face="Verdana" color="#00204f"
				size="2"><FONT size="+1" color="#004080">Cédula Tipo</FONT></FONT></B></TD>
			<TD width="44">&nbsp;</TD>
			<TD width="429" align="right">&nbsp;&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD width="199" colspan="2"></TD>
			<TD width="44"></TD>
			<TD width="429" align="right"></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD width="199" colspan="2"></TD>
			<TD width="44"></TD>
			<TD width="429" align="right"></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<% if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ %>
			<TD width="528" align="right"><FONT face="Verdana" size="2">Creado
			por: <I><%=ActualizaUsuario.NombreUsuario(strUsrActualiza)%> - <%= strFecha %></I></FONT>
			</TD>
			<% }else{ %>
			<TD width="528" align="right"><FONT face="Verdana" size="2">Creado
			por: <I><%= BUsuario.getNombre() %> - <%= strFecha %></I></FONT>
			</TD>
			<% } %>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
	
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080"><FONT face="Verdana" size="2">Unidad Administrativa:
			</FONT></FONT></B></TD>
			<TD width="528">
			<%if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){%>
				<% if(BUsuario.getSupervisor() && !cat.equalsIgnoreCase("1")){ %>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="idArea"
				disabled="true"
				classHtml="blue500" selected="<%=strIdArea%>"
				textoNoSeleccion="---------- Selecciona Área ----------" valorNoSeleccion="-1"
				script="onchange='cambio();'" />
				<%}else{%>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo() %>" size="1" name="idArea"
				disabled="true"
				classHtml="blue500" selected="<%=strIdArea%>"
				textoNoSeleccion="---------- Selecciona Área ----------" valorNoSeleccion="-1"
				script="onchange='cambio();'" />
				<%}%>
			<%}else{%>
				<% if(BUsuario.getSupervisor() && !cat.equalsIgnoreCase("1")){ %>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="idArea"
				classHtml="blue500" selected="<%=strIdArea%>"
				textoNoSeleccion="---------- Selecciona Área ----------" valorNoSeleccion="-1"
				script="onchange='cambio();'" />
				<%}else{%>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo() %>" size="1" name="idArea"
				classHtml="blue500" selected="<%=strIdArea%>"
				textoNoSeleccion="---------- Selecciona Área ----------" valorNoSeleccion="-1"
				script="onchange='cambio();'" />
				<%}%>
			<%}%>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Clave:</FONT></B></FONT><BR>
			<%if(bInsertar1 == 2){ %><B><FONT color="red">*Esta clave ya existe*</FONT>
			</B><%} %>
			</TD>
			<TD width="528">
				<INPUT name="clave"  value="<%=strClave%>" 
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled ="disabled"
						<%	}%>			
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>		
				 MAXLENGTH="4" type="text" class="blue100">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Nombre:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT name="subCodigo" value="<%=strCodigo%>"
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>		
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>					
				 type="text" class="blue500" MAXLENGTH="200">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Descripción:</FONT></B></FONT></TD>
			<TD width="528">

				<TEXTAREA name="subSeccion" rows="5" cols="65" 
					onKeyDown="limitaTextArea(document.tipcedf.subSeccion,'Descripción','4000');"
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
					class="blue500"><%=strSeccion%></TEXTAREA> 
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Fundamento Jurídico:</FONT></B></FONT></TD>
			<TD width="528">
			<textarea name="fundar" rows="8" cols="60"  
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
			onKeyDown="limitaTextArea(document.tipcedf.fundar,'Descripción','1000')"><%=strFunda%></textarea>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Motivación:</FONT></B></FONT></TD>
			<TD width="528">
			<textarea name="motivo" rows="8" cols="60" 
							<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
			onKeyDown="limitaTextArea(document.tipcedf.motivo,'Descripción','4000')"><%=strMotivo%></textarea>
			</TD>
		</TR>				
		<TR valign="top">
			<TD width="144"><FONT color="#004080">&nbsp;</FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			ICDD(Serie):</FONT></B></TD>
			<TD width="528">
			<%if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboICDDSer(strSerID) %>" size="1" name="Serie"
						classHtml="blue500" selected="<%=strSerie%>"
						textoNoSeleccion=" ---------- Seleccione una serie ICDD ---------- "
						valorNoSeleccion=""
						disabled="true"						 
						script=""/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboICDDSer(strSerID) %>" size="1" name="Serie"
						classHtml="blue500" selected=""
						textoNoSeleccion=" ---------- Seleccione una serie ICDD --------- "
						valorNoSeleccion="" 
						disabled="true"
						script=""/>
					<%}%>
			<%}else{%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboICDDSer(strSerID) %>" size="1" name="Serie"
						classHtml="blue500" selected="<%=strSerie%>"
						textoNoSeleccion=" ---------- Seleccione una serie ICDD ---------- "
						valorNoSeleccion="" 
						script=""/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboICDDSer(strSerID) %>" size="1" name="Serie"
						classHtml="blue500" selected=""
						textoNoSeleccion=" ---------- Seleccione una serie ICDD --------- "
						valorNoSeleccion="" 
						script=""/>
					<%}%>
			<%}%>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080">&nbsp;</FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			ICDD(Subserie):</FONT></B></TD>
			<TD width="528">
			<%if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboICDDSubSer(strSubsID) %>" size="1" name="Subserie"
						classHtml="blue500" selected="<%=strSubserie%>"
						textoNoSeleccion=" ---------- Seleccione una Subserie de ICDD ---------- "
						valorNoSeleccion=""
						disabled="true"						 
						script=""/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboICDDSubSer(strSubsID) %>" size="1" name="Subserie"
						classHtml="blue500" selected=""
						textoNoSeleccion=" ---------- Seleccione una Subserie de ICDD --------- "
						valorNoSeleccion="" 
						disabled="true"
						script=""/>
					<%}%>
			<%}else{%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboICDDSubSer(strSubsID) %>" size="1" name="Subserie"
						classHtml="blue500" selected="<%=strSubserie%>"
						textoNoSeleccion=" ---------- Seleccione una Subserie de ICDD ---------- "
						valorNoSeleccion="" 
						script=""/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboICDDSubSer(strSubsID) %>" size="1" name="Subserie"
						classHtml="blue500" selected=""
						textoNoSeleccion=" ---------- Seleccione una Subserie de ICDD --------- "
						valorNoSeleccion="" 
						script=""/>
					<%}%>
			<%}%>
			</TD>
		</TR>		

		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			Inactivo:</FONT></FONT></TD>
			<TD width="528">
				<INPUT type=checkbox onclick="habilita2()" value="3" 
						<%if(strInact == "3" || strInact.equals("3")) 
						{%>
						 checked
					       	<%
						}%>	
						<%if(ver!="si") {%>
						disabled="disabled"
						<%
						}%>	
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
				name="inactivo">
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			Fecha Inactivo:</FONT></FONT></TD>
			<TD width="528">
				<INPUT name="fecinact" value="<%=strFecInac%>"
						onfocus="blur();"
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>		
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
				type="text" class="blue100" maxlength="200">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			Justificacion:</FONT></FONT></TD>
			<TD width="528">
				<TEXTAREA name="justif" id="justif" rows="3" cols="65" 
					onKeyDown="limitaTextArea(document.tipcedf.justif,'Justificación','1000');"
					disabled="disabled"
					<%if(valida == 2) 
					{%>
					disabled="disabled"
					<%
					}%>
					
					<%if(ver!="si") {%>
					disabled="disabled"
					<%
					}%>	
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
		
						disabled="disabled"
					<%	}%>
					class="blue500"><%=strJustInac%></TEXTAREA>
			</TD>
		</TR>			
	</TBODY>
</TABLE>
<BR>
<BR>
</DIV>
</DIV>
</DIV>
</FORM>
</BODY>
</HTML>