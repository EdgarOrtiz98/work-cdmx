<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
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
	String strClave			=	"";
	String strInact			=	"";
	String strFecInac		=	"";
	String strJustInac		=	"";
	String ver				=	"";
	String horafec			=	"";
	String strsoloDesc 		=	"";
	String strAux = "1234567";

		int valida		=	0;
	boolean bInsertar		=	false;
	int bInsertar1		=	0;	
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
			strClave	=	request.getParameter("clave");
						
			bInsertar1	=	ActualizaExpArchivado.insertarValor(strCodigo, strSeccion,
																strFecha, BUsuario.getIdUsuario(),strClave,strAux);
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
			strClave	=	request.getParameter("clave");	
			strInact	=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
			strFecInac	=	request.getParameter("fecinact");
			strJustInac =	request.getParameter("justif");						
			strAux 		= 	request.getParameter("aux"); 
			 
			bInsertar1 = ActualizaExpArchivado.actualizaValor(strsoloDesc,strCodigo, strSeccion, strFecha, 
															BUsuario.getIdUsuario(), strIdSubfondo,strClave,
															strFecInac,strJustInac,strInact, strAux);

			if(bInsertar1 != 2){
				try{
					response.sendRedirect(retURI);
				}catch(java.io.IOException io){;}
			}
		}
	}
	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
	{
		String strDatosSubfondo[][] = ActualizaExpArchivado.getValor(strIdSubfondo);
		strCodigo		=	strDatosSubfondo[0][0];
		strSeccion		=	strDatosSubfondo[0][1];
		strFecha		=	strDatosSubfondo[0][2];
		strUsrActualiza	=	strDatosSubfondo[0][3];
		strClave		=	strDatosSubfondo[0][4];	
		strFecInac		=	strDatosSubfondo[0][5];	
		strJustInac		=	strDatosSubfondo[0][6];	
		strInact		=	strDatosSubfondo[0][7];	
		horafec			=	strDatosSubfondo[0][8];	
		ver				=	"si";				
		strAux			=  	strClave;
		
		valida	=	ActualizaExpArchivado.getValidaValor(strIdSubfondo);
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
<TITLE>Valor</TITLE>
<script type="text/javascript" src="../js/valida.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
<!-- 
	function limpiarCampos(){
		document.valorf.reset();
	}
	function rValidando() {
		<%if(valida == 2) 
		{%>
		alert("Como este registro ya cuenta con registros dependientes, solo podra ser modificado su descripción");
		<%
		}%>
	}	
	function alfaNumerico(ob){
		var ok=false;
		var texto=ob.value
		var codigo=texto.charCodeAt(texto.length-1);
		if( (codigo>=48&&codigo<=57)||(codigo>=65&&codigo<=90)||(codigo>=97&&codigo<=122)||(codigo==32)
		   )
			ok=true;
		if(!ok){
			texto=texto.substring(0,texto.length-1);
			ob.value=texto;
		}
	}
	function habilita2()
	{
		if(document.valorf.inactivo.checked == true)
		{
		document.valorf.fecinact.value = "<%=horafec%>";
		document.valorf.fecinact.disabled = false;
		document.valorf.justif.disabled = false;
		}else
		{
		document.valorf.fecinact.value = "";
		document.valorf.justif.value = "";
		document.valorf.fecinact.disabled = true;
		document.valorf.justif.disabled = true;
		}
	}		

</SCRIPT>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
</HEAD>


<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;rValidando();setFormFocusValor();limpiarCampos();timer_load();" 
	onKeyPress="timer_reload();" 
	onmousemove="limitaTextArea(document.valorf.subSeccion,'Descripción','4000');"
	onClick="timer_reload();">



<FORM action="ValorArch.jsp" name="valorf" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdSubfondo%>" name="id_sub">
<INPUT type="hidden" value="<%=strAux%>" name="aux">
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
		<TR>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
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
			<TD  colspan="2" width="196"><a href="<%= retURI %>"> 
			<IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar" > </a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>

				<a></a>
			<%	}else{%>	
				<a>	<img src="../Imagenes/Save.gif" title="Guardar" onclick="GuardarValor()"></a>
			<%}%>							
				</TD>
			<TD width="125">&nbsp;</TD>	
			<TD width="48"></TD>
		</TR>
		<TR><td></td><td></td><td></td></TR>
		<TR><td></td><td></td><td></td></TR>
		<TR valign="top">
			<TD colspan="2" width="196"><B><FONT face="Verdana" color="#00204f"
				size="2"><B><FONT size="+1" color="#004080">Valor</FONT></B></FONT></B></TD>
			<TD width="62">&nbsp;</TD>
			<TD width="414" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top">
			<TD width="196" colspan="2" bgcolor="#004080"></TD>
			<TD width="62" bgcolor="#004080"></TD>
			<TD width="414" align="right" bgcolor="#004080"></TD>
		</TR>
		<TR valign="top">
			<TD width="196" bgcolor="#004080" colspan="2"></TD>
			<TD width="62" bgcolor="#004080"></TD>
			<TD width="414" align="right" bgcolor="#004080"></TD>
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
			Nombre:</FONT></B></TD>
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
					onKeyDown="limitaTextArea(document.valorf.subSeccion,'Descripción','4000');"
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>	
					class="blue500"><%=strSeccion%></TEXTAREA> 
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
					onKeyDown="limitaTextArea(document.valorf.justif,'Justificación','1000');"
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