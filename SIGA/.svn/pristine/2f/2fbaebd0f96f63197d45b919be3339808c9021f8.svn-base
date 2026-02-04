<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}catch(java.io.IOException io){
			//System.out.println("ERROR:"+io.getMessage());
		}
	}

%>
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERUsuarioInvalido.jsp"></jsp:forward>
<% } %>
<% if(!BUsuario.getAdmon()){ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<%
	String strDuracion 	= 	"10";
	String strAmarillo 	= 	"";
	String strIdConf 	=	"";
	String strRegistros =	"";
	String strPaginas	=	"";
	String strDatos[][] =	null;
	String strAccion = request.getParameter("accion");

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	java.util.Date f 				=	new java.util.Date();
	String strFechaCreacion			=	sdf.format(f);

	boolean bActualizar = false;
	
	strDatos = ActualizaConfiguracion.getDatosConf();
	if(strDatos != null && strDatos.length > 0){
		strIdConf 		= strDatos[0][0];
		strDuracion 	= strDatos[0][1];
		strAmarillo 	= strDatos[0][2];
		strRegistros 	= strDatos[0][3];
		strPaginas 		= strDatos[0][4];
	}
	
	if(strAccion != null && strAccion.equals("guardar")){
		strDuracion = request.getParameter("confDuracion");
		strAmarillo = request.getParameter("confAmarillo");
		strRegistros = request.getParameter("registros");
		strPaginas = request.getParameter("paginas");
		bActualizar = ActualizaConfiguracion.getInsertaConf(strDuracion, strAmarillo, strFechaCreacion, strRegistros, strPaginas);
		boolean bBitacora = ActualizaBitacora.InsertarEventoModificaConfig(BUsuario.getIdUsuario(),strDuracion,strAmarillo);
		try{
			response.sendRedirect("UsuariosView.jsp");
		}catch(java.io.IOException io){
			//System.err.println("Error redireccion->"+io);
		}
	}
	if(strAccion != null && strAccion.equals("cambiar")){
		strDuracion = request.getParameter("confDuracion");
		strAmarillo = request.getParameter("confAmarillo");
		strRegistros = request.getParameter("registros");
		strPaginas = request.getParameter("paginas");
		strIdConf	= request.getParameter("id_conf");
		bActualizar = ActualizaConfiguracion.getUpdateConf(strDuracion, strAmarillo, strIdConf, strFechaCreacion, strRegistros, strPaginas);
		boolean bBitacora = ActualizaBitacora.InsertarEventoModificaConfig(BUsuario.getIdUsuario(),strDuracion,strAmarillo);
		try{
			response.sendRedirect("UsuariosView.jsp");
		}catch(java.io.IOException io){
			//System.err.println("Error redireccion->"+io);
		}
	}
	
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<TITLE>Configuraciones</TITLE>
<script type="text/javascript">
<!--

//-->
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0; timer_load();" 
	onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="confForm" action="Configuraciones.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIdConf%>" name="id_conf">
<TABLE cellspacing="0" cellpadding="0" width="99%" border="0">
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
			<TD width="125"><A href="../jsp/UsuariosView.jsp"> <IMG border="0"
				src="../Imagenes/NavLeft.gif" title="Regresar"> </A>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
				<a onclick="guardarConf()">
				<img src="../Imagenes/Save.gif" title="Guardar">
				</a>
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
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336" colspan="2" class="etiquetas1v"><B><FONT face="Verdana" color="#004080"
				size="2"></FONT><FONT size="+1"><B>Configuraciones</B></FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="672" bgcolor="#004080" colspan="4"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR VALIGN=top>
			
			<TD width="672">
				<FIELDSET dir="ltr">
				<LEGEND align="left"><FONT SIZE=2 FACE="Verdana">Semaforización</FONT></LEGEND>	
				<TABLE>
					<TBODY>
						<TR>        
							<TD>
							<FONT SIZE=1 FACE="Verdana">
							No. de días de caducidad de un Asunto:&nbsp;&nbsp;&nbsp;
							<INPUT name="confDuracion" type="text" class="blue50" value="<%=strDuracion%>" onKeyPress='AceptaSoloTeclaNumericaYPunto();'>
							</FONT>
							</TD>
						</TR>
						<TR>
							<TD>&nbsp;</TD>
						</TR>
						<TR>
							<TD>
							<FONT SIZE=1 FACE="Verdana">
							Semáforo Amarillo:&nbsp;&nbsp;&nbsp;
							<INPUT name="confAmarillo" type="text" class="blue50" value="<%=strAmarillo%>" onKeyPress='AceptaSoloTeclaNumericaYPunto();'>%
							</FONT>
							</TD>
						</TR>
						<TR>
							<TD>&nbsp;</TD>
						</TR>
					</TBODY>
				</TABLE>
			</FIELDSET>
		</TD>
	</TR>
		<TR VALIGN=top>
			
			<TD width="672">
				<FIELDSET dir="ltr">
				<LEGEND align="left"><FONT SIZE=2 FACE="Verdana">Paginación</FONT></LEGEND>	
				<TABLE>
					<TBODY>
						<TR>
							<TD>
							<FONT SIZE=1 FACE="Verdana">
							<BR>Registros por página:&nbsp;&nbsp;&nbsp;
							<INPUT name="registros" type="text" class="blue50" value="<%=strRegistros%>" onKeyPress='AceptaSoloTeclaNumerica();'>
							<BR>Páginas por pantalla:&nbsp;&nbsp;&nbsp;
							<INPUT name="paginas" type="text" class="blue50" value="<%=strPaginas%>" onKeyPress='AceptaSoloTeclaNumerica();'>
							</FONT>
							</TD>
						</TR>
						<TR>
							<TD>&nbsp;</TD>
						</TR>
					</TBODY>
				</TABLE>
			</FIELDSET>
		</TD>
	</TR>
	</TBODY>
</TABLE>
</DIV>

</FORM>
</BODY>
</HTML>
