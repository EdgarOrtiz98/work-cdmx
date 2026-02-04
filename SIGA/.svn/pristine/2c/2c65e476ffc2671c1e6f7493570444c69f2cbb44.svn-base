<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerCiudadano.jsp" flush="false"></jsp:include>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<jsp:useBean id="BAsunto" class="com.meve.sigma.beans.AsuntoBean"
	scope="page"></jsp:useBean>
<HTML>
<HEAD>
<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.meve.sigma.beans.*"%>
<!-- Se hace una instancia al Bean del usuario para la sesión -->
<%
	BeanCiudadano BCiudadano = (BeanCiudadano)session.getAttribute("CiudadanoBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+11,strTmp.length());
	if(BCiudadano==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}
%>
<%
	String strAccion 	=	"";
	String strSolicitud =	"";
	String strArchivo 	= 	"";
	String strFecha		=	"";
	String strFechaFol  =	"";
	String strIdRem		=	"";
	//String strTipoSol	=	"";
	String strIdUsuario	=	BCiudadano.getIdUsuario();
	String strNombre	=	BCiudadano.getNombre();
	String strApellidoP	=	BCiudadano.getApellidoPaterno();
	String strApellidoM	=	BCiudadano.getApellidoMaterno();
	String strOcupacion	=	BCiudadano.getOcupacion();
	String strMail		=	BCiudadano.getMail();

	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f = new java.util.Date();
	strFecha = sdf.format(f);

	java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("ddMMyyyy");
	java.util.Date f1 = new java.util.Date();
	strFechaFol = sdf1.format(f1);

	String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
	String portServer = application.getInitParameter("PortMail");
	String serverName = application.getInitParameter("servername");
	String strItemType = application.getInitParameter("ItemType");
	String strConfFolio =	application.getInitParameter("genFolio");

	String strRutaBase = (application.getInitParameter("RutaBase")==null)?"":application.getInitParameter("RutaBase");
	String url = strRutaBase+"/ciudadano/seguimiento.jsp?id_solicitud=";

	String URL = serverName+url;
	
%>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>
	function limpiarSol(){
		document.consultaForm.reset()
		document.consultaForm.solicitud.focus()
		//forma.solicitud.value == "";
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
<FORM 	action="../CrearAsuntoCiudadano" name="consultaForm" 
		method="post" enctype="multipart/form-data">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdUsuario%>" name="id_ciudadano">
<INPUT type="hidden" value="<%=strNombre%>" name="nombre">
<INPUT type="hidden" value="<%=strApellidoP%>" name="AP">
<INPUT type="hidden" value="<%=strApellidoM%>" name="AM">
<INPUT type="hidden" value="<%=strOcupacion%>" name="ocupacion">
<INPUT type="hidden" value="<%=strMail%>" name="mail">
<INPUT type="hidden" value="<%=serverMail%>" name="serverM">
<INPUT type="hidden" value="<%=portServer%>" name="portS">
<INPUT type="hidden" value="<%=serverName%>" name="serverName">
<INPUT type="hidden" value="<%=URL%>" name="url">
<INPUT type="hidden" value="<%=strItemType%>" name="ItemType">
<INPUT type="hidden" value="<%=application.getInitParameter("content")%>" name="cm">
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
			<TD width="125"><a href="PortalCiudadano.jsp"> <IMG border="0"
				src="../Imagenes/Regresar.gif" width="82" height="26"> </a></TD>
			<TD width="125"><a onclick="guardarSolicitud()"> <img
				src="../Imagenes/Guardar.gif" width="81" border="0" name="guardaImg"> </a></TD>
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
			<TD width="336"><B><FONT face="Verdana" color="#00204f" size="2">Favor
			de anotar la descripción de su solicitud</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="446">&nbsp;</TD>
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
		<TD width="183"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
		<TD align="right" colspan="3"><FONT face="Verdana" size="2"><I></I></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
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
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Datos del Solicitante:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getNombre()+" "+BCiudadano.getApellidoPaterno()+" "+BCiudadano.getApellidoMaterno()%></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Domicilio:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getDomicilio()%></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Pais:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getPais()%></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Estado:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getEstado()%></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Municipio:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getMunicipio()%></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<td width="183"><b><font size="2" color="#004080" face="Arial">Correo Electrónico:</font></b>
		</td>
		<td width="233"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getMail()%></font>
		</td>
		<td width="155"><b><font size="2" color="#004080" face="Arial">Telefono:</font></b>
		</td>
		<td width="176"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getTelefono()%></font><br></td>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		<td width="183"><b><font size="2" color="#004080" face="Arial">Ocupación:</font></b>
		</td>
		<td width="233"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getOcupacion()%></font>
		</td>
		<td width="155"><b><font size="2" color="#004080" face="Arial">Sector:</font></b>
		</td>
		<td width="176"><FONT SIZE=2 FACE="Verdana"><%=BCiudadano.getSector()%></font><br></td>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR VALIGN=top>
		
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Detalle de la Solicitud:</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana">Describa la información solicitada y proporcione todos aquellos
		datos que considere puedan<br> facilitar su búsqueda, con el fin de darle un mejor servicio.
		<INPUT name="solicitud1" type="hidden" class="blue500" value="-"></FONT></TD>
	</TR>
	<TR VALIGN=top>
		<TD width="183"><b><font size="2" color="#004080" face="Arial"></FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><TEXTAREA name="solicitud"
			rows="9" cols="70" class="blue700"></TEXTAREA></FONT></TD>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="176"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
	<TR valign="top">
		<TD width="183"><font size="2" color="#004080" face="Arial">Anexar un
		archivo(Opcional):</FONT></TD>
		<TD colspan="3"><input class="blue500" type="file"
			name="solicitud_archivo"></TD>
	</TR>
	<TR valign="top">
		<td width="183">&nbsp;</td>
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
