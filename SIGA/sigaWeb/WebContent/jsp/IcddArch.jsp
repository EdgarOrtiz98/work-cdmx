<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page import="com.meve.sigma.taglib.*"%>
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
	String strSeries[]		=	null;
	String strSubSeries[]	=	null;
	String strSeriesIds		=	"";
	String strSubSeriesIds	=	"";
	String strUsrActualiza	=	"";
	String strFecha			=	"";
	String strFechaicdd		=	"";
	String strAccion		=	"";
	String strClave			=	"";
	String strIdArea 		= 	(request.getParameter("idArea")!= null)?request.getParameter("idArea"):"";
	String strSeccion		= 	(request.getParameter("secciona")!= null)?request.getParameter("secciona"):"";	
	String strInact			=	"";
	String strFecInac		=	"";
	String strJustInac		=	"";
	String ver				=	"";
	String horafec			=	"";

	String strAux = "1234567";

		int valida		=	0;	
	boolean bInsertar	=	false;
	int bInsertar1		=	0;	
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFecha						=	sdf.format(f);

	String retURI = (request.getParameter("retURI")==null)?"Icddview.jsp":request.getParameter("retURI");
	strAccion		=	request.getParameter("accion");
	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			strSeccion	 =	request.getParameter("secciona");
			strIdArea 	 = 	request.getParameter("idArea");
			strSeries	 =	request.getParameterValues("series");
			strSubSeries =	request.getParameterValues("subseries");
			strFechaicdd =  request.getParameter("fecinicio");
			
			bInsertar1	=	ActualizaExpArchivado.insertarIcdd(strIdArea, strSeccion,
															strFechaicdd, BUsuario.getIdUsuario(), strSeries, strSubSeries);
			if(bInsertar1 == 2)
			{
			//msg ="La clave ya existe";
			}
			else{
				try{
					//response.sendRedirect("Icddview.jsp");
					response.sendRedirect(retURI);
				}catch(java.io.IOException io){
					//System.out.println("Error-->"+io);
				}
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strSeccion	 =	request.getParameter("secciona");
			strIdArea 	 = 	request.getParameter("idArea");
			strSeries	 =	request.getParameterValues("series");
			strSubSeries =	request.getParameterValues("subseries");
			strFechaicdd =  request.getParameter("fecinicio");
			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
			strFecInac	=	request.getParameter("fecinact");
			strJustInac =	request.getParameter("justif");	
			 
			strClave	=	request.getParameter("clave");
			strAux 		= 	request.getParameter("aux"); 
						
			bInsertar1 = ActualizaExpArchivado.actualizaIcdd(strSeries, strSubSeries, strFechaicdd, 
															strIdSubfondo, strFecInac, strJustInac, 
															strInact, BUsuario.getIdUsuario());
			if(bInsertar1 != 2){
				try{
					//response.sendRedirect("Icddview.jsp");
					response.sendRedirect(retURI);
				}catch(java.io.IOException io){
					//System.out.println("Error-->"+io);
				}
			}
		}
	}
	
	if(strSeccion != null && strSeccion.trim().length()>0)
	{
	String strDatosDate[][] = ActualizaExpArchivado.getDate();
	strFechaicdd		=	strDatosDate[0][0];
	}
	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
	{
		String strDatosSubfondo[][] = ActualizaExpArchivado.getIcddId(strIdSubfondo);
		strIdArea		=	strDatosSubfondo[0][0];
		strSeccion		=	strDatosSubfondo[0][1];
		strFecha		=	strDatosSubfondo[0][2];
		strSeriesIds	=	strDatosSubfondo[0][3];
		strSubSeriesIds	=	strDatosSubfondo[0][4];
		strFechaicdd	=	strDatosSubfondo[0][5];
		strFecInac		=	strDatosSubfondo[0][6];	
		strJustInac		=	strDatosSubfondo[0][7];	
		strInact		=	strDatosSubfondo[0][8];	
		horafec			=	strDatosSubfondo[0][9];
		strUsrActualiza	=	strDatosSubfondo[0][10];
		strAux			=  	strClave;		
		ver				=	"si";
		
	//	valida	=	ActualizaExpArchivado.getValidaSeccion(strIdSubfondo);		
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
<TITLE>ICDD Unidad Administrativa</TITLE>
<script type="text/javascript" src="../js/valida.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
<!-- 
	function limpiarCampos(){
	//	document.Icdd.reset();
	}
function rValidando() {
	<%if(valida == 2) 
	{%>
	alert("El registro consultado no puede ser modificado");
	<%
	}%>
}	
function claved() {
	doc = document.Icdd;
	doc.submit();
}
	function habilita2()
	{
		if(document.Icdd.inactivo.checked == true)
		{
		document.Icdd.fecinact.value = "<%=horafec%>";
		document.Icdd.fecinact.disabled = false;
		document.Icdd.justif.disabled = false;
		}else
		{
		document.Icdd.fecinact.value = "";
		document.Icdd.justif.value = "";
		document.Icdd.fecinact.disabled = true;
		document.Icdd.justif.disabled = true;
		}
	}	
</SCRIPT>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;rValidando();limpiarCampos();timer_load();" 
	onKeyPress="timer_reload();" 
	onClick="timer_reload()">
<FORM action="IcddArch.jsp" name="Icdd" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdSubfondo%>" name="id_sub">
<INPUT type="hidden" value="<%=strAux%>" name="aux">
<INPUT type="hidden" value="<%=retURI%>" name="retURI">
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
				<A><img src="../Imagenes/Save.gif" title="Guardar"  border="0" onclick="GuardarIcdd()"></A> 
			<%}%>
				
			</TD>
			<TD width="125"></TD>
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
			<TD colspan="2" width="234" height="30"><B><FONT face="Verdana"
				color="#002850" size="2"></FONT><FONT face="Verdana" color="#00204f"
				size="2"><B><FONT size="+1" color="#004080">Clasificación de Instrumento por Unidad Administrativa</FONT></B></FONT></B></TD>
			<TD width="38" height="30">&nbsp;</TD>
			<TD width="400" align="right" height="30">&nbsp;&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top">
			<TD colspan="2" width="234" bgcolor="#004080" height="2"></TD>
			<TD width="38" bgcolor="#004080" height="2"></TD>
			<TD width="400" bgcolor="#004080" height="2"></TD>
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
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			Unidad Administrativa:</FONT></B></TD>
			<TD width="528">
			<%if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)){%>
				<% if(BUsuario.getSupervisor()){ %>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo() %>" size="1" name="idArea"
				classHtml="blue500" selected="<%=strIdArea%>"
				textoNoSeleccion="---------- Selecciona un Opción ----------" 
				valorNoSeleccion="-1"
				disabled="true" 
				script="" />
				<%}else{%>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo() %>" size="1" name="idArea"
				classHtml="blue500" selected="<%=strIdArea%>"
				textoNoSeleccion="---------- Selecciona un Opción ----------" 
				valorNoSeleccion="-1"
				disabled="true" 
				script="" />
				<%}%>
			<%}else{%>
				<% if(BUsuario.getSupervisor()){ %>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo() %>" size="1" name="idArea"
				classHtml="blue500" selected="<%=strIdArea%>"
				textoNoSeleccion="---------- Selecciona un Opción ----------" 
				valorNoSeleccion="-1"
				script="" />
				<%}
			else{%>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo() %>" size="1" name="idArea"
				classHtml="blue500" selected="<%=strIdArea%>"
				textoNoSeleccion="---------- Selecciona un Opción ----------" 
				valorNoSeleccion="-1"
				script="" />
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
			Sección - Fondo - Subfondo:</FONT></B></FONT></TD>
			<TD width="528">
			<%if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSeccionComboA() %>" size="1" name="secciona"
						classHtml="blue500a" selected="<%= strSeccion %>"
						textoNoSeleccion=" ------------ Seleccione una Sección------------ "
						valorNoSeleccion="-1" 
						disabled="true" 
						script="onchange='claved()'"/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSeccionComboA() %>" size="1" name="secciona"
						classHtml="blue500a" selected="<%= strSeccion %>"
						textoNoSeleccion=" ------------ Seleccione una Sección------------ "
						valorNoSeleccion="-1" 
						disabled="true" 
						script="onchange='claved()'"/>
					<%}%>
			<%}else{%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSeccionComboA() %>" size="1" name="secciona"
						classHtml="blue500a" selected="<%= strSeccion %>"
						textoNoSeleccion=" ------------ Seleccione una Sección------------ "
						valorNoSeleccion="-1" 
						script="onchange='claved()'"/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSeccionComboA() %>" size="1" name="secciona"
						classHtml="blue500a" selected="<%= strSeccion %>"
						textoNoSeleccion=" ------------ Seleccione una Sección------------ "
						valorNoSeleccion="-1" 
						script="onchange='claved()'"/>
					<%}%>
			<%}%>	
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>			
		<TR valign="top">
			<TD width="144"></TD>
			<TD width="528"><FONT color="#004080"><B>Series  ::::  Subseries</B></FONT></TD>
		</TR>		

			<% if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
					if (strSeriesIds != null && strSeriesIds.trim().length()>0){
			%>
					<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosSeccionIcddIds(strSeccion,strSeriesIds) %>" campo="campo">
					<TR valign="top">
					<TD width="144">
					</TD>
					<TD width="528">
							<INPUT type=checkbox value="<%= campo1 %>" 
								<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
									disabled="disabled"
								<%	}%>	
							checked name="series">
				    		<FONT face=Arial color=#000080 size=1>
						    <%= campo2 %> :::: <%= campo3%>
				    		</FONT>
				    </TD>
					</meve_front:ListaDatos>
					<%}
					if (strSubSeriesIds != null && strSubSeriesIds.trim().length()>0){
					%>
			<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosSeccionIcddSubIds(strSeccion,strSubSeriesIds) %>" campo="campo">
			<TR valign="top">
			<TD width="144">
			</TD>
			<TD width="528">
					<INPUT type=checkbox value="<%= campo1 %>" 
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
					 checked name="subseries">
		    		<FONT face=Arial color=#000080 size=1>
				    <%= campo2 %> :::: <%= campo3%>
		    		</FONT>
		    </TD>
			</meve_front:ListaDatos>

		
			<%}
			}else
			{
			if (strSeccion != null && strSeccion.trim().length()>0){%>
			<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosSeccionIcdd(strSeccion,strIdArea) %>" campo="campo">
			<TR valign="top">
			<TD width="144">
			</TD> 
			<TD width="528">
					<INPUT type=checkbox 
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
					value="<%= campo1 %>" name="series">
		    		<FONT face=Arial color=#000080 size=1>
				    <%= campo2 %> :::: <%= campo3%> 
		    		</FONT>
		    </TD>
			</meve_front:ListaDatos>
			<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosSeccionIcddSub(strSeccion,strIdArea) %>" campo="campo">
			<TR valign="top">
			<TD width="144">
			</TD>
			<TD width="528">
					<INPUT type=checkbox 
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
					value="<%= campo1 %>" name="subseries">
		    		<FONT face=Arial color=#000080 size=1>
				    <%= campo2 %> :::: <%= campo3%>
		    		</FONT>
		    </TD>
			</meve_front:ListaDatos>
			<%}
			}%>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>			
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Fecha Inicio:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT name="fecinicio" value="<%= strFechaicdd%>" 
						onfocus="blur();"	
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
				type="text" class="blue100" maxlength="200">
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
				<INPUT type=checkbox onclick="habilita2();" value="3" 
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
					onKeyDown="limitaTextArea(document.Icdd.justif,'Justificación','1000');"
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