<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*"
%>
<%
	String strIdArea	= 	(request.getParameter("idArea")!=null)?request.getParameter("idArea"):"";
	String strIdAsunto 	= 	(request.getParameter("ida")!=null)?request.getParameter("ida"):"";
	String num 			=	request.getParameter("num");
	String strDatosRemitenteArea[][]	=	null;
	
	boolean	bExisteReg = false;
	bExisteReg		   = ActualizaUsuario.getExistenUsuarios();
	int t = 0;
	boolean bMostrar	=	false;
	String strAccion = request.getParameter("accion");
%>
<%!
	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }
%> 
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>FrameDestinatario.jsp</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language="JavaScript" type="text/javascript">
	
	function aceptar(numero){
		
		var form = document.framevent;
		var form = document.forms[0];
		var formP = opener.window.document.forms[0];
  		var cadena = "";
  		var numdoc=0;
		for (var i = 0; i < form.elements.length; i++) {
    		if (form.elements[i].type == "radio") {
      			if (form.elements[i].name == "Sel") {
        			if (form.elements[i].checked == true){
        				valor = form.elements[i].value;
        				if(valor != ""){
							cadena = cadena + valor;
        					numdoc=numdoc + 1;
						}
        			}
      			}
    		}
		}
		if (cadena == "")
			alert("Debe seleccionar un puesto"); 

		else {
        	if (numdoc >1)
					alert("Debe seleccionar sólo un documento");
           	else {
				var ID = valor.substring(0, valor.indexOf("|"));
				var nombre = valor.substring(valor.indexOf("|")+1, valor.indexOf("/"));
				var cargo = valor.substring(valor.indexOf("/")+1, valor.indexOf("*"));
				var area = valor.substring(valor.indexOf("*")+1, valor.indexOf("&"));
				var correo = valor.substring(valor.indexOf("&")+1, valor.length);

				opener.window.document.forms[0].idDestinatario.value = ID;
				opener.window.document.forms[0].asuntoDestinatario.value = cargo+" / "+nombre;
				opener.window.document.forms[0].asuntoCargoDest.value = cargo;
				opener.window.document.forms[0].asuntoAreaDest.value = area;
				opener.window.document.forms[0].mailDest.value = correo;
				opener.window.document.forms[0].banderaVent.value = "1";

				opener.hay_hija = new Boolean(false);
				opener.hija = null;

				//cerrarIframe('pop4', '<%=strIdAsunto%>', numero);
				window.opener.document.Asunto.submit();
				window.close();
			}
		}
	}
</SCRIPT>

</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onunload="opener.hay_hija=true"
	onClick="opener.resetTimer();"
	onKeyPress="opener.resetTimer();">
<form name="framevent" action="FrameVentanilla.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="50%">
			<DIV>
				<input type="button" value="Aceptar" class="blue100" onclick="aceptar(<%=num%>)">
				<!-- <input type="button" value="Cancelar" class="blue100" onclick="cerrarIframe('pop4', '<%=strIdAsunto%>', <%=num%>);"> -->
				<input type="button" value="Cancelar" class="blue100" onclick="Cancelar();">
			</DIV>                                                    
		</td>
		<td width="50%" align="right">
			<b><font size="2" color="#00204F" face="Verdana"></font></b>
		</td>
	</tr>
</table>
<TABLE width="100%" BORDER="0">
	<TR BGCOLOR="00204F">
		<TD WIDTH="50%" align="center">
			<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial"><b>Puesto</b></font>
		</TD>
		<TD WIDTH="50%" align="center">
			<FONT SIZE=2 COLOR="FFFFFF" FACE="Arial"><b>Responsable</b></font>
		</TD>
	</TR>	
</TABLE>
<DIV class=documentBody id=Body>
<%if(bExisteReg){%>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
	<meve_front:ListaDatos datos="<%= ActualizaUsuario.getUsuarioPorRol(strIdArea) %>" campo="usuario">
	<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<td width="5%" align="left">
			<INPUT type="radio" name="Sel" value="<%= usuario1 %>|<%= usuario2 %>/<%= usuario3 %>*<%= usuario4 %>&<%= usuario5 %>">
		</td>
		<td width="41%" align="left">
			<!-- <IMG height=1 src="../Imagenes/ecblank.gif" width=16 border=0>  -->
			<FONT face=Arial color=#000080 size=1>
				<A title="<%= usuario2 %>"> <%= com.meve.sigma.util.Utilerias.recortaString(usuario2,35) %> </A>
			</FONT>
		</td>
		<TD width="5%"> &nbsp;&nbsp;</TD>
		<TD width="49%" align="left">
			<FONT face=Arial color=#000080 size=1>
				<A title="<%= usuario3 %>"> <%= com.meve.sigma.util.Utilerias.recortaString(usuario3,35) %> </A>
			</FONT>
		</TD>
	</tr>
	</meve_front:ListaDatos>
</TABLE>
<%}else{%>
<CENTER>
<table cellspacing="2" cellpadding="2">
	<tr>
		<TD align="center">
			<DIV align="center">
				<p><FONT size="4" face="Verdana">** No hay Puestos Registrados ** </FONT></DIV>
		</TD>
	</tr>
</table>
</CENTER>
<%}%>
<BR>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</form>
</BODY>
</HTML>
