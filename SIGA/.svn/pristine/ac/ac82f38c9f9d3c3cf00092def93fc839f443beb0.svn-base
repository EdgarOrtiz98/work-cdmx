<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	String strIdSeccion		=	request.getParameter("IdSeccion");
	String strUsrActualiza	=	"";
	String strFecha			=	"";
	String strAccion		=	"";
	String strClave			=	"";
	//String strFondo		=	"";

	String strAux = "1234567";

	boolean bInsertar		=	false;
	int bInsertar1		=	0;	
	int valida		=	0;
	
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFecha						=	sdf.format(f);

	strAccion		=	request.getParameter("accion");
	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			//strFondo	=   request.getParameter("fondo");
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo");
			strClave	=	request.getParameter("clave"); 			
			bInsertar1	=	ActualizaExpArchivado.insertarSerie(strCodigo, strSeccion,
																strFecha, BUsuario.getIdUsuario(),strClave,strAux,strIdSeccion);
			if(bInsertar1 == 2)
			{
			//msg ="La clave ya existe";
			}
			else{
				//try{
					//response.sendRedirect("SerieArchview.jsp?msg="+msg);
					%>
					<SCRIPT language=JavaScript type=text/javascript>
					opener.document.clsf.submit();
					window.close();
					</SCRIPT>
					<%
				//}catch(java.io.IOException io){
				//	//System.out.println("Error-->"+io);
				//}
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo");
			strClave	=	request.getParameter("clave"); 
			//strFondo	=   request.getParameter("fondo");
			strAux 		= 	request.getParameter("aux"); 

			bInsertar1 = ActualizaExpArchivado.actualizaSerie(strCodigo, strSeccion, strFecha, 
															BUsuario.getIdUsuario(),strIdSubfondo,strClave,strAux);

			
			if(bInsertar1 != 2){
				try{
					response.sendRedirect("SerieArchview.jsp");
				}catch(java.io.IOException io){
					//System.out.println("Error-->"+io);
				}
			}
		}
	}
	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
	{
		String strDatosSubfondo[][] = ActualizaExpArchivado.getSerie(strIdSubfondo);
		strCodigo		=	strDatosSubfondo[0][0];
		strSeccion		=	strDatosSubfondo[0][1];
		strFecha		=	strDatosSubfondo[0][2];
		strUsrActualiza	=	strDatosSubfondo[0][3];
		strClave	=		strDatosSubfondo[0][4];
		strAux			=  	strClave;				
		
		valida	=	ActualizaExpArchivado.getValidaSerie(strIdSubfondo);		
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
<TITLE>Series</TITLE>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript" src="../js/link.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
<!-- 
	function limpiarCampos(){
		document.serief.reset();
	}
function rValidando() {
	<%if(valida == 2) 
	{%>
	alert("El registro consultado no puede ser modificado");
	<%
	}%>
}	
</SCRIPT>

<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="rValidando();setFormFocusserie();limpiarCampos();timer_load();" 
	onKeyPress="timer_reload();" 
	onClick="timer_reload();">
<FORM action="SerieArch.jsp" name="serief" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdSubfondo%>" name="id_sub">
<INPUT type="hidden" value="<%=strIdSeccion%>" name="IdSeccion">
<INPUT type="hidden" value="<%=strAux%>" name="aux">
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><a href="../jsp/SerieArchview.jsp"> <IMG
				border="0" src="../Imagenes/Regresar.gif" width="82" height="26"> </a>
			</TD>
			<TD width="125"><a><img
				src="../Imagenes/Guardar.gif" width="81" border="0"
				onclick="Guardarserie()"></a></TD>
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
				size="2"><B><B><FONT size="+1" color="#004080">Series</FONT></B></B></FONT></B></TD>
			<TD width="69">&nbsp;</TD>
			<TD width="404" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top">
			<TD width="199" colspan="2" bgcolor="#004080"></TD>
			<TD width="69" bgcolor="#004080"></TD>
			<TD width="404" align="right" bgcolor="#004080"></TD>
		</TR>
		<TR valign="top">
			<TD width="199" bgcolor="#004080" colspan="2"></TD>
			<TD width="69" bgcolor="#004080"></TD>
			<TD width="404" align="right" bgcolor="#004080"></TD>
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
				<INPUT name="clave" value="<%=strClave%>" MAXLENGTH="3"  
					<%if(valida == 2) 
						{%>
						onfocus="blur();"
						<%
						}%>
				  type="text" class="blue100"
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			Nombre:</FONT></B></TD>
			<TD width="528">
				<INPUT name="subCodigo" value="<%=strCodigo%>" 
						<%if(valida == 2) 
						{%>
						onfocus="blur();"
						<%
						}%>
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
				<textarea name="subSeccion" rows="8" cols="60"><%=strSeccion%></textarea>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Inactivo:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT type=checkbox  value="si"  
				name="inactivo">
			</TD>
		</TR>		
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Fecha Inactivo:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT name="fecinact" value="" 
						<%if(valida == 2) 
						{%>
						onfocus="blur();"
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
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Justificacion:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT name="justif" value="" 
						<%if(valida == 2) 
						{%>
						onfocus="blur();"
						<%
						}%>				
				type="text" class="blue500" maxlength="200">
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