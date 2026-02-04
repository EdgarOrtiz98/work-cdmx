<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerUCT.jsp" flush="false"></jsp:include>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<jsp:useBean id="BAsunto" class="com.meve.sigma.beans.AsuntoBean"
	scope="page"></jsp:useBean>
<HTML>
<HEAD> 
<%@  
	page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.taglib.*"%>
<!-- Se hace una instancia al Bean del usuario para la sesión -->
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("login.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
	////System.err.println("BusarioNombre-->"+BUsuario.getNombre());
%>
<%
	String strAccion 	=	"";
	String stridDestinatarioUCT = "";
	String strMailUCT	=	"";
	String strName		=	"";
	String strMailCiu	=	"";
	String strIdCiudadano=	"";
	String strArea		=	"";

	String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
	String portServer = application.getInitParameter("PortMail");
	String serverName = application.getInitParameter("servername");
	String strItemType = application.getInitParameter("ItemType");
	String strConfFolio =	application.getInitParameter("genFolio");

	String strRutaBase = (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
	String url = strRutaBase+"/ciudadano/seguimientoUCT.jsp?id_solicitud=";
	String URL = serverName+url;
	
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript" src="../js/link.js"></script>
<SCRIPT language=JavaScript type=text/javascript> 
	function limpiarSol(){
		document.SolUCT.reset()
		document.SolUCT.sol_asunto.focus()
		//forma.solicitud.value == "";
	}
	function cambioMun(opcion){
		doc = document.SolUCT;
		valida = 0;
		msg="";
		if(opcion.options[opcion.selectedIndex].value=="BAJA CALIFORNIA"){
			
   			doc.sol_municipio1.style.display='inline';  
   			doc.sol_municipio.style.display='none';
		}else{
			doc.sol_municipio1.style.display='none';  
   			doc.sol_municipio.style.display='inline';
		}
		
	}
	function area(opcion){
		doc = document.SolUCT;
		var cadena="";
		if(opcion.options[opcion.selectedIndex].value != -1)
		{
			cadena = opcion.options[opcion.selectedIndex].value.substring(0, (opcion.options[opcion.selectedIndex].value.indexOf('|')));
			doc.sol_name.value = cadena;
			cadena = opcion.options[opcion.selectedIndex].value.substring((opcion.options[opcion.selectedIndex].value.indexOf('|')+1), (opcion.options[opcion.selectedIndex].value.indexOf('/')));
			doc.sol_mail1.value = cadena;
			cadena = opcion.options[opcion.selectedIndex].value.substring((opcion.options[opcion.selectedIndex].value.indexOf('/')+1), opcion.options[opcion.selectedIndex].value.length);
			doc.id_ciudadano.value = cadena;
		}
		else{
			doc.sol_name.value = "";
			doc.sol_mail1.value = "";
			doc.id_ciudadano.value = "";
		}
	}

var digitos=10 //cantidad de digitos buscados 
var puntero=0 
var buffer=new Array(digitos) //declaración del array Buffer 
var cadena="" 

function buscar_opUCT(obj){
	var forma=document.SolUCT;
   	var letra = String.fromCharCode(event.keyCode)
   	if(puntero >= digitos){ 
    	cadena=""; 
       	puntero=0; 
    } 
   	//si se presiona la tecla ENTER, borro el array de teclas presionadas y salto a otro objeto... 
   	if (event.keyCode == 13){ 
    	borrar_buffer(); 
       	//if(objfoco!=0) objfoco.focus(); //evita foco a otro objeto si objfoco=0
		var cad="";
		if(obj.options[obj.selectedIndex].value!="-1")
		{	
			cad = obj.options[obj.selectedIndex].value.substring(0,(obj.options[obj.selectedIndex].value.indexOf('|')));
			forma.sol_name.value = cad;
			cad = obj.options[obj.selectedIndex].value.substring((obj.options[obj.selectedIndex].value.indexOf('|')+1),(obj.options[obj.selectedIndex].value.indexOf('/')));
			forma.sol_mail1.value = cad;
			cad = obj.options[obj.selectedIndex].value.substring((obj.options[obj.selectedIndex].value.indexOf('/')+1), obj.options[obj.selectedIndex].value.length);
			forma.id_ciudadano.value = cad;
		}
		else{
			forma.sol_name.value = "";
			forma.sol_mail1.value = "";
			forma.id_ciudadano.value = "";
		}
    } 
   	//sino busco la cadena tipeada dentro del combo... 
   	else{ 
       	buffer[puntero]=letra; 
       	//guardo en la posicion puntero la letra tipeada 
       	cadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array 
       	puntero++; 

       	//barro todas las opciones que contiene el combo y las comparo la cadena... 
       	for (var opcombo=0;opcombo < obj.length;opcombo++){ 
          	if(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ 
          		obj.selectedIndex=opcombo; 
        	} 
       	} 
    } 
   	event.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter 
}
function borrar_bufferUCT(){ 
   	//inicializa la cadena buscada 
    cadena=""; 
    puntero=0; 
} 
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;limpiarSol();">
<!-- <FORM action="ConsultaCiudadano.jsp" name="consultaForm" method="post"
	ENCTYPE="multipart/form-data">-->
<FORM 	action="../CrearAsuntoCiudadanoUCT" name="SolUCT" 
		method="post" enctype="multipart/form-data">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdCiudadano%>" name="id_ciudadano">
<INPUT type="hidden" value="<%=serverMail%>" name="serverM">
<INPUT type="hidden" value="<%=portServer%>" name="portS">
<INPUT type="hidden" value="<%=serverName%>" name="serverName">
<INPUT type="hidden" value="<%=URL%>" name="url">
<INPUT type="hidden" value="<%=application.getInitParameter("content")%>" name="cm">
<INPUT type="hidden" value="<%=stridDestinatarioUCT%>" name="idDestinatarioUCT">
<INPUT type="hidden" value="<%=strMailUCT%>" name="sol_mail">
<INPUT type="hidden" value="<%=strArea%>" name="sol_area">
<INPUT type="hidden" value="<%=strItemType%>" name="ItemType">
<INPUT type="hidden" value="<%=BUsuario.getIdUsuario()%>" name="id_usuario"> 
<INPUT type="hidden" value="" name="sol_destinatario">
<INPUT type="hidden" value="<%=strConfFolio%>" name="confFol">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%" colspan="2">
			<DIV align="right"></DIV>
			</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><a href="SolicitudUCT.jsp"> <IMG border="0"
				src="../Imagenes/Regresar.gif" width="82" height="26"> </a></TD>
			<TD width="125"><a onclick="guardarSolicitudUCT()"> <img
				src="../Imagenes/Guardar.gif" width="81" border="0"> </a></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="293"></TD>
		</TR>
		<TR valign="top">
			<TD></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV class=documentBody id=Body>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="#00204f" size="2">Datos
			del Ciudadano</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="423">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#00204f" colspan="4"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
	<TR valign="top">
		<TD width="205"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
		<TD align="right" colspan="3"><FONT face="Verdana" size="2"><I></I></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="205">&nbsp;</td>
		<td width="211"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="333"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<!-- <TR VALIGN=top>
		<TD width="144"><b><font size="2" color="#004080" face="Arial">Tipo de
		Solicitud:</FONT></b></TD>
		<TD width="517"><FONT SIZE=2 FACE="Verdana"> <SELECT name="tipo_sol"
			class="blue200">
			<OPTION value="1">Pública</OPTION>
			<OPTION value="2">Datos Personales</OPTION>
			<OPTION value="3">Modificación de datos</OPTION>
		</SELECT> </FONT></TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="517">&nbsp;</TD>
	</TR>-->
	<TR VALIGN=top>
		<TD width="205"><b><font size="2" color="#004080" face="Arial">Datos del Solicitante:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana">
			<%
				String[][] strCombo = ComboData.getCiudadanoCombo();
			%>
			<SELECT name="sol_usuario" class="blue200" onchange="area(this)" onKeypress="buscar_opUCT(this)" onblur="borrar_bufferUCT()" onclick="borrar_bufferUCT()">
				<OPTION value="-1">-- Clave Usuario --</OPTION>
				<% for(int i=0;i<strCombo.length;i++){ %>
				<OPTION value="<%=strCombo[i][1]%>|<%=strCombo[i][2]%>/<%=strCombo[i][3]%>"><%=strCombo[i][0]%></OPTION>
				<% } %>
			</SELECT>
		</FONT></TD>
	</TR>
	<TR valign="top">
		<td width="205">&nbsp;</td>
		<td width="211"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="333"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<TD width="205"><b><font size="2" color="#004080" face="Arial">Nombre:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><INPUT name="sol_name" value="" class="blue200"></FONT>
		</TD>
	</TR>
	<TR valign="top">
		<td width="205">&nbsp;</td>
		<td width="211"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="333"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<TD width="205"><b><font size="2" color="#004080" face="Arial">Mail:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><INPUT name="sol_mail1" value="" class="blue200"></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="205">&nbsp;</td>
		<td width="211"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="333"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	
</table>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="#00204f" size="2">Datos
			de la Solicitud</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="423">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#00204f" colspan="4"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
	<TR valign="top">
		<td width="203">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<!-- <TR VALIGN=top>
		<TD width="183">
			<b><font size="2" color="#004080" face="Arial">Destinatario:</FONT></b>
			<INPUT type="button" onclick="document.getElementById('pop4').style.visibility='visible';" class="s-dropdown-btn">
			<DIV class="popup" id="pop4">
				<IFRAME src="FrameDestinatarioUCT.jsp" WIDTH=600 HEIGHT=300 frameborder=1></IFRAME>
			</DIV>
		</TD>
		<TD colspan="3">
			<FONT SIZE=2 FACE="Verdana">
			<INPUT class="blue500" name="sol_destinatario" value="" onfocus="blur();">
			</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<td width="203">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>-->
	<TR VALIGN=top>
		<TD width="203"><b><font size="2" color="#004080" face="Arial">Asunto:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><INPUT name="sol_asunto" class="blue500"></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="203">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<TD width="203"><b><font size="2" color="#004080" face="Arial">Detalle de la Solicitud:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana">Describa la información solicitada y proporcione todos aquellos
		datos que considere puedan<br> facilitar su búsqueda, con el fin de darle un mejor servicio.
		</FONT></TD>
	</TR>
	<TR VALIGN=top>
		<TD width="203"><b><font size="2" color="#004080" face="Arial"></FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><TEXTAREA name="solicitud"
			rows="9" cols="70" class="blue700"></TEXTAREA></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="203">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR valign="top">
		<td width="203">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR valign="top">
		<TD width="203"><font size="2" color="#004080" face="Arial">Anexar un
		archivo(Opcional):</FONT></TD>
		<TD colspan="3"><input class="blue500" type="file"
			name="solicitud_archivo"></TD>
	</TR>
	<TR valign="top">
		<td width="203">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TABLE>
</DIV>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
