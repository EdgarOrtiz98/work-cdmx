<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<TITLE>Destinatarios Externos</TITLE>
<HEAD>
<jsp:useBean id="BUsuario1" class="com.meve.sigma.beans.AreaBean" scope="page">
	<jsp:setProperty name="BUsuario1" property="*" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*"%>
<%@ page import="com.meve.sigma.taglib.*"%>
<%@ page import="com.meve.sigma.beans.*"%>
<%@ page import="com.meve.sigma.ldap.*"%> 
<jsp:useBean id="BEscritura" class="com.meve.sigma.beans.EscrituraBean"
	scope="page"></jsp:useBean>
<!-- Se hace una instancia al Bean del usuario para la sesión -->
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
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		//(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		//(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERError.jsp"></jsp:forward>
<% } %>
<!-- Fin bloque sesión -->
<%
	String recCreador[][]  	= 	null;
	String recUsuario[][] 	= 	null;
	String strIdsRol[][]	=	null;
	String strIdsCorreos[][]=	null;
	String strUsrLDAP[][]	=	null;
	String strIdUsuario 	= 	"";
	String strUsuario 		= 	"";//(BUsuario1.getUsuarioNombre()== null)?"":BUsuario1.getUsuarioNombre();
	String strIdArea 		= 	"";//(BUsuario1.getUsuarioArea()== null)?"":BUsuario1.getUsuarioArea();
	String strDesc 		= 	"";//(BUsuario1.getUsuarioCargo()== null)?"":BUsuario1.getUsuarioCargo();
	String strCorreo 		= 	"";//(BUsuario1.getUsuarioEmail()== null)?"":BUsuario1.getUsuarioEmail();
	String strTelefono 		= 	"";//(BUsuario1.getUsuarioTelefono()== null)?"":BUsuario1.getUsuarioTelefono();
	String strConsecutivo 	= 	"";//(BUsuario1.getUsuarioConsecutivo()== null)?"0":BUsuario1.getUsuarioConsecutivo();
	String strIdRol			=	"";//(BUsuario1.getUsuarioRol1()== null)?"":BUsuario1.getUsuarioRol1();
	String strIdJefe 		= 	"";//(BUsuario1.getUsuarioJefe()== null)?"":BUsuario1.getUsuarioJefe();
	String strIdAsistente 	= 	"";//(BUsuario1.getUsuarioAsistente()== null)?"":BUsuario1.getUsuarioAsistente();
	String strCadenaMando 	= 	"";
	String strcompasArea 	= 	"";
	String strCreador 		= 	"";
	String strCreador1 		= 	"";
	String strFechaCreacion	=	"";
	String strAccion 		= 	"";
	String strEstatus 		= 	"1";

	String strUID			=	"";//(BUsuario1.getUid()== null)?"":BUsuario1.getUid();
	String strUID1			=	"";
	String strActivarLDAP	=	application.getInitParameter("ActivarLDAP");

	String strAux = "1a2b3c", strAux2 = "1a2b3c";
	int valida = -2;
	boolean insertado = false;
    
	boolean blnExisteFirma	=	false; //Para comprobar si existe una firma digital
	boolean bInsertar 		= 	false; //Insertar un nuevo usuario
	boolean bActualizar 	= 	false; //Actualizar datos de un usuario
	boolean bExisteUsuario	=	false; //Si existe un usuario en la base de datos
	boolean bInsertaRol		=	false; //Inserta el rol del usuario
	boolean bInsertaCorreo	=	false; //Inserta la configuración de correos
	boolean bExisteUSR		=	false;
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f = new java.util.Date();
	strFechaCreacion = sdf.format(f);

	strCreador1	=	BUsuario.getIdUsuario();
	strCreador	=	BUsuario.getNombre();
		
	strIdUsuario = (request.getParameter("id_usuario")!=null)?request.getParameter("id_usuario"):"";
	strAccion 	= 	request.getParameter("accion");
	//** Cuando se desea ver la insformación de un usuario en especifico
	//** se manda a ejecutar un query con todos los datos del usuario para
	//** ser mostrados en la vista del Usuario
	if (strAccion != null && strAccion.equals("consultar"))
	{
		strIdUsuario = (request.getParameter("id_usuario")!=null)?request.getParameter("id_usuario"):"";
		if (strIdUsuario != null) {
			recUsuario       	= 	ActualizaDestino.getDestino(strIdUsuario);

			String ini = recUsuario[0][0];
			strDesc	     		= 	recUsuario[0][1];
			strUsuario        	= 	recUsuario[0][2];
			strCorreo        	= 	recUsuario[0][3];
			strTelefono      	= 	recUsuario[0][4];
			strIdArea       	= 	recUsuario[0][5];

			strAux = strUsuario;
			strAux2 = strIdArea;
		}
	}//** Fin Consultar Información Usuario

	//** Si se va a actualizar algun cambio en los datos de un usuario
	//** se ejecuta este blooque de codigo
	//** Si se va a crear un nuevo usuario
	//** se ejecuta este bloque de codigo
	if (strAccion != null && strAccion.equals("guardar"))
	{
		if (strIdUsuario == null || strIdUsuario.equalsIgnoreCase("") ) {
			strUsuario		= 	request.getParameter("usuarioNombre");
			strUID			=	request.getParameter("uid");
			strIdArea		= 	request.getParameter("usuarioArea");
			strDesc			= 	request.getParameter("usuarioDesc");
			strCorreo		= 	request.getParameter("usuarioEmail");
			strTelefono 	= 	request.getParameter("usuarioTelefono");
		
			// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Destinatario externo
			strUsuario	=	(strUsuario.length()<= 100) ? strUsuario : strUsuario.substring(0,100);
			strDesc		=	(strDesc.length()<= 200) ? strDesc : strDesc.substring(0,200);
			strCorreo	=	(strCorreo.length()<= 50) ? strCorreo : strCorreo.substring(0,50);
			strTelefono	=	(strTelefono.length()<= 50) ? strTelefono : strTelefono.substring(0,50);

			valida = ActualizaDestino.getDestinatarioExiste(strUsuario, strAux, strIdArea, strAux2);	

			if (valida == 2){
				boolean insertar = ActualizaDestino.InsertarDestino(strUsuario, strIdArea,strDesc, strCorreo, strTelefono);
				insertado = insertar;
					%>
		<SCRIPT language=JavaScript type=text/javascript>
		{
			opener.document.getElementById('Externo').contentWindow.location.reload();
			window.close();
		}
		</SCRIPT>
<%
			}
		}
	}//** Fin Guardar un nuevo usuario	
	recCreador  = ActualizaUsuario.getUsuario(strCreador1);
	strCreador	= recCreador[0][0];

	//** Se redirecciona a la pagina de UsuarioView cuando se ejecutan
	//** los eventos de cambiar o guardar un Usuario

	

%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<STYLE type="text/css">
</STYLE>
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>

	function usuarios1() {
		doc = document.DestExtFormDinamic;
		doc.submit();
	}
	 function cerrar()
	 {
	 window.close();
	 }
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
} 
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onunload="opener.hay_hija=false"
	onClick="opener.resetTimer();"
	onKeyPress="opener.resetTimer();">
<FORM action="DinamicExterno.jsp" name="DestExtFormDinamic" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" name="id_usuario" value="<%=strIdUsuario%>">
<INPUT type="hidden" name="usuarioRol1" value="<%=strIdRol%>">
<INPUT type="hidden" name="aux" value="<%=strAux%>">
<INPUT type="hidden" name="aux2" value="<%=strAux2%>">



<DIV align="center">

<BR>
</DIV><DIV class=documentBody id=Body>
<!-- tag para los campos de username y password -->
<!-- fin tag para los campos de username y password -->
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="#00204f" size="2">Destinatarios Externos</FONT></B></TD>
			<TD width="38">&nbsp;</TD>
			<TD width="377" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD width="336"></TD>
			<TD width="38"></TD>
			<TD width="377"></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD width="336" height="0"></TD>
			<TD width="38" height="0"></TD>
			<TD width="377" height="0"></TD>
		</TR>
		<TR valign="top">
			<TD width="336" height="30"></TD>
			<TD width="38" height="30"></TD>
			<TD align="right" width="377" height="30"><FONT face="Verdana" size="2">Creado por: <I><%= strCreador%>
			- <%= strFechaCreacion%></I></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="336" height="30"><BR>
			<BR>
			</TD>
			<TD width="38" height="30"></TD>
			<TD align="right" width="377" height="30"></TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
	<%if(strActivarLDAP.equals("1")){%>
	<TR VALIGN=top>
		<TD width="164"><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Buscar Datos:</B></FONT></TD>
		<TD valign="bottom" width="517"><FONT SIZE=2 FACE="Verdana"> <meve_combo:comboseleccion
			data="<%= ActualizaLdap.getComboUsuariosLdapA() %>" multiple="false"
			name="comboUsuarios1" classHtml="blue500"
			textoNoSeleccion=" ---------------- Selecciona un Puesto ---------------- "
			valorNoSeleccion="-1"
			script=" onblur='borrar_buffer()' onclick='borrar_buffer()'" /> </FONT></TD>
	</TR>
	<%}%>
	<TR VALIGN=top>
		<TD width="164"><B><FONT size="2" face="Verdana" color="#004080">Unidad Administrativa:</FONT></B></TD>
		<% if(BUsuario.getSupervisor()|| BUsuario.getRecepcion() || BUsuario.getTurnado()){ %>
		<TD valign="bottom" width="517"><FONT SIZE=2 FACE="Verdana"> <meve_combo:comboseleccion
			data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="usuarioArea"
			classHtml="blue500" selected="<%= strIdArea %>"
			textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
			valorNoSeleccion="-1" 
			script="onblur='borrar_buffer()' onclick='borrar_buffer()' " />
		</FONT></TD>
		<% }else{ %>
		<TD width="65"><FONT SIZE=2 FACE="Verdana"> <meve_combo:comboseleccion
			data="<%= ComboData.getAreasCombo() %>" size="1" name="usuarioArea"
			classHtml="blue500" selected="<%= strIdArea %>"
			textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
			valorNoSeleccion="-1" 
			script=" onblur='borrar_buffer()' onclick='borrar_buffer()' "/> </FONT></TD>
		<% } %>
	</TR>
	<TR valign="top">
		<TD width="164"></TD>
		<TD valign="bottom" width="517"></TD>
		<TD width="65"></TD>
	</TR>
	<TR valign="top">
		<TD width="164"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
		<TD valign="bottom" width="517">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="164"><B><FONT size="2" face="Verdana" color="#004080">Nombre:</FONT></B>
		<%if (valida == 1) {%><br>
		<FONT color="red"><B>*Este Nombre ya existe* </B></FONT><%} %>
		</TD>
		<TD valign="bottom" width="517"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50" maxlength="199"
			type="text" name="usuarioNombre" class="blue500" value="<%=strUsuario%>"></FONT></TD>
	</TR>
		<TR valign="top">
		<TD width="164"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
		<TD valign="bottom" width="517">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="164"><B><FONT size="2" face="Verdana" color="#004080">Descripcion:</FONT></B></TD>
		<TD valign="bottom" width="517"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50" maxlength="199"
			type="text" name="usuarioDesc" class="blue500" value="<%=strDesc%>"></FONT></TD>
	</TR>
	<TR valign="top">
		<TD width="164"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
		<TD valign="bottom" width="517">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="164"><B><FONT size="2" face="Verdana" color="#004080">Correo Electronico:</FONT></B></TD>
		<TD valign="bottom" width="517"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50"
			type="text" maxlength="199" name="usuarioEmail" class="blue500"
			value="<%=  (strUsuario!=null)?strCorreo:"" %>"></FONT></TD>
	</TR>
	<TR valign="top">
		<TD width="164"><FONT color="#004080">&nbsp;</FONT></TD>
		<TD valign="bottom" width="517">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="164"><FONT SIZE=2 FACE="Verdana" color="#004080">Teléfono:</FONT></TD>
		<TD valign="bottom" width="517"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50"
			type="text" name="usuarioTelefono" class="blue500"
			value="<%=strTelefono%>" maxlength="199"></FONT></TD>
	</TR>
	<TR valign="top">
		<TD width="164"></TD>
		<TD valign="bottom" width="517"></TD>
	</TR>
	<TR valign="top">
		<TD width="164"></TD>
		<TD width="517"></TD>
	</TR>
	<TR align="center">
		<TD width="164" align="center" colspan="2"></TD>
		<TD width="517"></TD>
	</TR>
	<TR align="center">
		<TD  align="left">
			&nbsp;</TD>
		<TD >
			<a onclick="window.close()">
			<img src="../Imagenes/Regresar.gif"  border="0">
			</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a onclick="guardarDestinoExt()">
			<img src="../Imagenes/Guardar.gif"  border="0">
			</a>
		</TD>
	</TR>
</TABLE><BR>
</DIV>
</DIV>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
</jsp:useBean>
