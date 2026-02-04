<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page import="com.meve.sigma.taglib.*"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*"
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
%>
<% if(!BUsuario.getAdmon() && !BUsuario.getSupervisor()){ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<%
	String msg = "";
	String strIdSubfondo	=	"";
	String strCodigo		=	"";
	String strSeccion		=	"";
	String strUsrActualiza	=	"";
	String strFecha			=	"";
	String strAccion		=	"";
	String strFondo			=	"";
	String strclave			=	"";
	String strInact			=	"";
	String strFecInac		=	"";
	String strJustInac		=	"";	
	String ver				=	"";	
	String horafec			=	"";
	String strsoloDesc 		=	"";
		
	String strAux = "9999999", strAux2 = "9999999";
	
	boolean bInsertar		=	false;
	int bInsertar1		=	0;	
		int valida		=	0;	
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
			strFondo	=   request.getParameter("fondo");		
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo");
			strclave	=	request.getParameter("clave");
			bInsertar1	=	ActualizaExpArchivado.insertarSubfondoA(strCodigo, strSeccion,
																strFecha, BUsuario.getIdUsuario(),strFondo,strclave,strAux,strAux2);
			if(bInsertar1 == 2){}
			else {
				try{
					//response.sendRedirect("SubfondoArchview.jsp?msg="+msg);
					response.sendRedirect(retURI+"&msg="+msg);
				}catch(java.io.IOException io){
					//System.out.println("Error-->"+io);
				}
			}
		}


		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strsoloDesc =	request.getParameter("soloDesc");
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo");
			strFondo	=   request.getParameter("fondoCamb");
			strclave	=	request.getParameter("clave");
			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
			strFecInac	=	request.getParameter("fecinact");
			strJustInac =	request.getParameter("justif");
			strAux 		= 	request.getParameter("aux"); 						
			strAux 		= 	request.getParameter("aux"); 
			strAux2 	= 	request.getParameter("aux2"); 
			
			bInsertar1 = ActualizaExpArchivado.actualizaSubfondoA(strsoloDesc,strCodigo, strSeccion, strFecha, 
															BUsuario.getIdUsuario(), strFondo, strIdSubfondo,strclave
															,strFecInac,strJustInac,strInact,strAux,strAux2);
			if (bInsertar1 != 2){
				try{
					//response.sendRedirect("SubfondoArchview.jsp");
					response.sendRedirect(retURI);
				}catch(java.io.IOException io){
					//System.out.println("Error-->"+io);
				}
			}
		}
	}
	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
	{
		String strDatosSubfondo[][] = ActualizaExpArchivado.getSubfondoA(strIdSubfondo);
		strCodigo		=	strDatosSubfondo[0][0];
		strSeccion		=	strDatosSubfondo[0][1];
		strFecha		=	strDatosSubfondo[0][2];
		strUsrActualiza	=	strDatosSubfondo[0][3];
		strFondo	=		strDatosSubfondo[0][4];		
		strclave		=	strDatosSubfondo[0][5];
		strFecInac		=	strDatosSubfondo[0][6];	
		strJustInac		=	strDatosSubfondo[0][7];	
		strInact		=	strDatosSubfondo[0][8];	
		horafec			=	strDatosSubfondo[0][9];					
		strAux			=  	strclave;
		strAux2			=  	strFondo;
		ver				=	"si";		
		valida	=	ActualizaExpArchivado.getValidaSubfondo(strIdSubfondo);
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
<TITLE>Subfondos</TITLE>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/Menu2.js"></script>	
<SCRIPT language=JavaScript type=text/javascript>
<!-- 
	function limpiarCampos(){
		document.subfondo1A.reset();
	}
function rValidando() {
	<%if(valida == 2) 
	{%>
	alert("Como este registro ya cuenta con registros dependientes, solo podra ser modificado su descripción ");
	<%
	}%>
}
	function cambio(){
	doc = document.subfondo1A;
	val = doc.fondo.value;
	doc.fondoCamb.value = val;
	}
	function llena()
	{
	doc = document.subfondo1A;
	a = doc.clave.value;
	if(a.length < 2)
		{
			doc.clave.value = "00" + a;	
		}
	if(a.length < 3 && a.length >1)
		{
			doc.clave.value = "0" + a;	
		}
	}

	function habilita2()
	{
		if(document.subfondo1A.inactivo.checked == true)
		{
		document.subfondo1A.fecinact.value = "<%=horafec%>";
		document.subfondo1A.fecinact.disabled = false;
		document.subfondo1A.justif.disabled = false;
		}else
		{
		document.subfondo1A.fecinact.value = "";
		document.subfondo1A.justif.value = "";
		document.subfondo1A.fecinact.disabled = true;
		document.subfondo1A.justif.disabled = true;
		}
	}
	
</SCRIPT>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;rValidando();setFormFocusSubFondoA();limpiarCampos();timer_load();" 
	onKeyPress="timer_reload();" 
	onClick="timer_reload();">
<FORM action="SubfondoArch.jsp" name="subfondo1A" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdSubfondo%>" name="id_sub">
<INPUT type="hidden" value="<%=strAux%>" name="aux">
<INPUT type="hidden" value="<%=strFondo%>" name="fondoCamb">
<INPUT type="hidden" value="<%=strAux2%>" name="aux2">
<INPUT type="hidden" value="<%=retURI%>" name="retURI">
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
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
				<a></a>
			<%	}else{%>	
				<a><img	src="../Imagenes/Save.gif" title="Guardar" border="0"	onclick="GuardarSubfondoA()"></a> 
			<%}%>					
			</TD>
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
			<TD colspan="2" width="256"><B><FONT face="Verdana" color="#00204f"
				size="2"><FONT size="+1" color="#004080">Subfondos</FONT></FONT></B></TD>
			<TD width="37">&nbsp;</TD>
			<TD width="379" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top">
			<TD width="256" colspan="2" bgcolor="#002850"></TD>
			<TD width="37" bgcolor="#002850"></TD>
			<TD width="379" bgcolor="#002850"></TD>
		</TR>
		<TR valign="top">
			<TD width="256" colspan="2" bgcolor="#002850"></TD>
			<TD width="37" bgcolor="#002850"></TD>
			<TD width="379" bgcolor="#002850"></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" border="0"> 
	<TBODY>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">&nbsp;</FONT></B></FONT></TD>
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
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
				<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Fondo:</FONT></B></FONT></TD>
			<TD width="528">

			<%if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)){%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSubFondosCombo() %>" size="1" name="fondo"
						classHtml="blue500" selected="<%= strFondo %>"
						textoNoSeleccion=" ------------ Selecciona un Fondo------------ "
						valorNoSeleccion="-1"
						disabled="true" 
						script="onchange='cambio();'"/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSubFondosCombo() %>" size="1" name="fondo"
						classHtml="blue500" selected="" 
						textoNoSeleccion=" ------------ Selecciona un Fondo------------ "
						valorNoSeleccion="-1"
						disabled="true" 
						script="onchange='cambio();'"/>
					<%}%>
			<%}else{%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSubFondosCombo() %>" size="1" name="fondo"
						classHtml="blue500" selected="<%= strFondo %>"
						textoNoSeleccion=" ------------ Selecciona un Fondo------------ "
						valorNoSeleccion="-1" 
						script="onchange='cambio();'"/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSubFondosCombo() %>" size="1" name="fondo"
						classHtml="blue500" selected="" 
						textoNoSeleccion=" ------------ Selecciona un Fondo------------ "
						valorNoSeleccion="-1" 
						script="onchange='cambio();'"/>
					<%}%>			
			<%}%>			
			</TD>



		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Clave:</FONT></B></FONT><BR>
			<%if(bInsertar1 == 2){ %><B><FONT color="red">*Esta clave ya existe*</FONT>
			</B><%} %>
			</TD>
			<TD width="528">
				<INPUT name="clave" value="<%=strclave%>" MAXLENGTH="3" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
				type="text" class="blue100"
					onkeypress = "AceptaSoloTeclaNumericaYPunto();"
					onblur="llena();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Nombre: </FONT></B></FONT></TD>
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
				 MAXLENGTH="200" type="text" class="blue500">
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
			<textarea name="subSeccion" 
				<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
					disabled="disabled"
				<%	}%>			
				onKeyDown="limitaTextArea(document.subfondo1A.subSeccion,'Descripción','4000');"
				rows="8" cols="60"><%=strSeccion%></textarea>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
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
					onKeyDown="limitaTextArea(document.subfondo1A.justif,'Justificación','1000');"
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
