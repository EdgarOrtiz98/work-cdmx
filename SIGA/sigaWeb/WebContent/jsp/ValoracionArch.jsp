<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ taglib uri="meve_front" prefix="meve_front"%>
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
		catch(java.io.IOException io){;}
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
	String strFondo		=	"";
	String Val4  	=	"";
	String Val1[]	=	null;
	String Val2		=	"";
	String Val3		=	"";
	String strClave			=	"";
	String strInact			=	"";
	String strFecInac		=	"";
	String strJustInac		=	"";	
	String ver				=	"";		
	String horafec			=	"";	
	String strIds_guard[]	=	null;
	String strsoloDesc 		=	"";

	String strAux = "1234567";

		int valida		=	0;	
	boolean bInsertar		=	false;
	int bInsertar1		=	0;	
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFecha						=	sdf.format(f);

	strAccion		=	request.getParameter("accion");
	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			Val1 =	request.getParameterValues("agregar");	
			Val2 =	request.getParameter("agregar2");
			Val3 =	request.getParameter("agregar3");
			strClave	=	request.getParameter("clave"); 			
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo"); 
			bInsertar1	=	 ActualizaExpArchivado.insertarValoracion(strCodigo, strSeccion,strFecha, BUsuario.getIdUsuario(),Val1,Val2,Val3,strClave,strAux);
			if(bInsertar1 == 2){;}
			else {
				try{
					response.sendRedirect("ValoracionArchview.jsp?msg="+msg);
				}catch(java.io.IOException io){;}
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strsoloDesc =	request.getParameter("soloDesc");
			strIds_guard =	request.getParameterValues("agregar");
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo");
			strClave	=	request.getParameter("clave"); 			
			Val1 =	request.getParameterValues("agregar");
			Val2 =	request.getParameter("agregar2");
			Val3 =	request.getParameter("agregar3");
			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
			strFecInac	=	request.getParameter("fecinact");
			strJustInac =	request.getParameter("justif");	
			strAux 		= 	request.getParameter("aux"); 
			bInsertar1 =  ActualizaExpArchivado.actualizaValoracion(strsoloDesc,strCodigo, strSeccion, strFecha, 
															BUsuario.getIdUsuario(), strIdSubfondo,Val1,Val2,Val3,strClave,
															strFecInac,strJustInac,strInact,strAux);

			if(bInsertar1 != 2){
				try{
					response.sendRedirect("ValoracionArchview.jsp");
				}catch(java.io.IOException io){;}
			}
		}
	}
	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
	{
		String strDatosSubfondo[][] =  ActualizaExpArchivado.getValoracion(strIdSubfondo);
		strCodigo		=	strDatosSubfondo[0][0];
		strSeccion		=	strDatosSubfondo[0][1];
		strFecha		=	strDatosSubfondo[0][2];
		strUsrActualiza	=	strDatosSubfondo[0][3];
		Val4	=		strDatosSubfondo[0][4];
		Val2	=		strDatosSubfondo[0][5];
		Val3	=		strDatosSubfondo[0][6];	
		strClave		=	strDatosSubfondo[0][7];	
		strFecInac		=	strDatosSubfondo[0][8];	
		strJustInac		=	strDatosSubfondo[0][9];	
		strInact		=	strDatosSubfondo[0][10];	
		horafec			=	strDatosSubfondo[0][11];
		ver				=	"si";			
		strAux			=  	strClave;				

		valida	=	ActualizaExpArchivado.getValidaValoraciones(strIdSubfondo);		
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
<TITLE>Valoración Documental</TITLE>
<script type="text/javascript" src="../js/valida.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
<!-- 
	function limpiarCampos(){
		document.valoracionf.reset();
	}
function rValidando() {
	<%if(valida == 2) 
	{%>
	alert("Como este registro ya cuenta con registros dependientes, solo podra ser modificado su descripción ");
	<%
	}%>	
}
	function habilita2()
	{
		if(document.valoracionf.inactivo.checked == true)
		{
		document.valoracionf.fecinact.value = "<%=horafec%>";
		document.valoracionf.fecinact.disabled = false;
		document.valoracionf.justif.disabled = false;
		}else
		{
		document.valoracionf.fecinact.value = "";
		document.valoracionf.justif.value = "";
		document.valoracionf.fecinact.disabled = true;
		document.valoracionf.justif.disabled = true;
		}
	}		
</SCRIPT>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;rValidando();setFormFocusValoraciones();limpiarCampos();timer_load();" 
	onKeyPress="timer_reload();" 
	onmousemove="limitaTextArea(document.valoracionf.subSeccion,'Descripción','4000');"
	onClick="timer_reload();">
<FORM action="ValoracionArch.jsp" name="valoracionf" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdSubfondo%>" name="id_sub">
<INPUT type="hidden" value="<%=strAux%>" name="aux">
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
			<TD width="125"><a href="../jsp/ValoracionArchview.jsp"> <IMG
				border="0" src="../Imagenes/NavLeft.gif" title="Regresar"> </a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
				<a></a>
			<%	}else{%>	
				<a><img	src="../Imagenes/Save.gif" title="Guardar" onclick="GuardarValoraciones()"></a>
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
			<TD colspan="2" width="220"><B><FONT face="Verdana" color="#00204f"
				size="2"><B><FONT size="+1" color="#004080">Valoraciones</FONT></B></FONT></B></TD>
			<TD width="58">&nbsp;</TD>
			<TD width="394" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top">
			<TD width="220" colspan="2" bgcolor="#004080"></TD>
			<TD width="58" bgcolor="#004080"></TD>
			<TD width="394" bgcolor="#004080"></TD>
		</TR>
		<TR valign="top">
			<TD width="220" bgcolor="#004080" colspan="2"></TD>
			<TD width="58" bgcolor="#004080"></TD>
			<TD width="394" bgcolor="#004080"></TD>
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
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			Clave:</FONT></B><BR>
			<%if(bInsertar1 == 2){ %><B><FONT color="red">*Esta clave ya existe*</FONT>
			</B><%} %>
			</TD>
			<TD width="528">
				<INPUT name="clave" value="<%=strClave%>" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>				
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
				MAXLENGTH="2" type="text" class="blue100"
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			Nombre: </FONT></B></TD>
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
			<TD width="144"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			Descripción:</FONT></B></TD>
			<TD width="528">
				<TEXTAREA name="subSeccion" rows="5" cols="65" 
					onKeyDown="limitaTextArea(document.valoracionf.subSeccion,'Descripción','4000');"
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>		
					class="blue500"><%=strSeccion%></TEXTAREA> 
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			Valores:</FONT></B></TD>
			<TD width="528">
		    </TD>
		</TR>
<%if(valida == 2){%>		
			<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
			<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosValores(Val4, Val2, Val3) %>" campo="campo">
		<TR valign="top">
			<TD  colspan="2">
		    		<INPUT type=checkbox value="<%= campo1 %>" 
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
					name="agregar" disabled="disabled">
		    		<FONT face=Arial color=#000080 size=1>
				   <%=campo2%>
		    		</FONT>
			</TD>
			</meve_front:ListaDatos>
			<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosValores2(Val4, Val2, Val3) %>" campo="campo">
		<TR valign="top"> 
			<TD colspan="2">
		    		<INPUT type=checkbox value="<%= campo1 %>" checked  
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
					name="agregar" disabled="disabled">
		    		<FONT face=Arial color=#000080 size=1>
				    <%=campo2%>
		    		</FONT><INPUT type="hidden" value="<%= campo1 %>" name="agregar">
			</TD>
			</meve_front:ListaDatos>
			<%}
			else {%>
			<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosTodoValor() %>" campo="campo" >
			<TR valign="top">
			<TD colspan="2">
		    		<INPUT type=checkbox value="<%= campo1 %>" 
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
					name="agregar" disabled="disabled">
		    		<FONT face=Arial color=#000080 size=1>
				    <%=campo2%>
		    		</FONT>
			</TD>
			</meve_front:ListaDatos>
			<%}%>
<%}else{%>	
			<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
			<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosValores(Val4, Val2, Val3) %>" campo="campo">
		<TR valign="top">
			<TD colspan="2">
		    		<INPUT type=checkbox value="<%= campo1 %>" 
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
						name="agregar">
		    		<FONT face=Arial color=#000080 size=1>
				   <%=campo2%>
		    		</FONT>
			</TD>
			</meve_front:ListaDatos>
			<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosValores2(Val4, Val2, Val3) %>" campo="campo">
		<TR valign="top"> 
			<TD colspan="2">
		    		<INPUT type=checkbox value="<%= campo1 %>" checked
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
					  name="agregar">
		    		<FONT face=Arial color=#000080 size=1>
				    <%=campo2%>
		    		</FONT>
			</TD>
			</meve_front:ListaDatos>
			<%}
			else {%>
			<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosTodoValor() %>" campo="campo">
			<TR valign="top">
			<TD colspan="2">
		    		<INPUT type=checkbox value="<%= campo1 %>"
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
					 name="agregar">
		    		<FONT face=Arial color=#000080 size=1>
				    <%=campo2%>
		    		</FONT>
			</TD>
			</meve_front:ListaDatos>
			<%}%>

<%}%>			
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
					<%if(ver!="si") {%>
						disabled="disabled"
						<%
						}%>	
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
					onKeyDown="limitaTextArea(document.valoracionf.justif,'Justificación','1000');"
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