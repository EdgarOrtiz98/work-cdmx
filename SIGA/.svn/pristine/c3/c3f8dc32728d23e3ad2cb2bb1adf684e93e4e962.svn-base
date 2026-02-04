<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerCiudadano.jsp" flush="false"></jsp:include>
<jsp:useBean id="BCiudadano" class="com.meve.sigma.beans.CiudadanoBean" scope="page"></jsp:useBean>
<HTML>
<HEAD>
<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.meve.sigma.actualiza.*"
%>
<!-- Se hace una instancia al Bean del usuario para la sesión -->
<%
	int dia = 31;
	int year = 1995;
	int ir = 0;
	String strDatos[] = null;
	String strAccion 	= 	"";
	String strNombre 	=	(request.getParameter("reg_nombre") != null)?request.getParameter("reg_nombre"):"";
	String strAP 		=	(request.getParameter("reg_apellidoP") != null)?request.getParameter("reg_apellidoP"):"";
	String strAM		=	(request.getParameter("reg_apellidoM") != null)?request.getParameter("reg_apellidoM"):"";
	String strDia		=	(request.getParameter("reg_dia") != null)?request.getParameter("reg_dia"):"";
	String strMes		=	(request.getParameter("reg_mes") != null)?request.getParameter("reg_mes"):"";
	String strYear		=	(request.getParameter("reg_year") != null)?request.getParameter("reg_year"):"";
	String strSexo		=	(request.getParameter("reg_sexo") != null)?request.getParameter("reg_sexo"):"";
	String strOcupacion	=	(request.getParameter("reg_ocupacion") != null)?request.getParameter("reg_ocupacion"):"";
	String strDomicilio	=	(request.getParameter("reg_domicilio") != null)?request.getParameter("reg_domicilio"):"";
	String strPais		=	(request.getParameter("reg_pais") != null)?request.getParameter("reg_pais"):"";
	String strEstado	=	(request.getParameter("reg_estado") != null)?request.getParameter("reg_estado"):"";
	String strMunicipio	=	(request.getParameter("reg_municipio") != null)?request.getParameter("reg_municipio"):"";
	String strTelefono	=	(request.getParameter("reg_telefono") != null)?request.getParameter("reg_telefono"):"";
	String strMail		=	(request.getParameter("reg_mail") != null)?request.getParameter("reg_mail"):"";
	String strUsuario	=	(request.getParameter("reg_usuario") != null)?request.getParameter("reg_usuario"):"";
	String strSector	=	(request.getParameter("reg_sector") != null)?request.getParameter("reg_sector"):"";

	String mun = request.getParameter("mun");
	
	strAccion = request.getParameter("accion");

	if(strAccion != null && strAccion.equals("guardar")){
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");
		ir = BCiudadano.guardarCiudadano(request, serverMail, portServer, serverName); 
		//ir = new Integer(strDatos[0]).intValue();
		//if(ir == 0){
			//String stridCiudadano = ActualizaCiudadano.getUltimoIdCiudadano();
		if(ir >= 0){
			String stridCiudadano = Integer.toString(ir);
			try{
				response.sendRedirect("confirmacion.jsp?id_ciu="+stridCiudadano);
			}catch(java.io.IOException io){
				//System.err.println("Error de redirección-->"+io);
			}
		}
	}
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
	function cambioMun(opcion){
		doc = document.registroCiuForm;
		valida = 0;
		msg="";
		if(opcion.options[opcion.selectedIndex].value=="BAJA CALIFORNIA"){
			
   			doc.reg_municipio1.style.display='inline';  
   			doc.reg_municipio.style.display='none';
		}else{
			doc.reg_municipio1.style.display='none';  
   			doc.reg_municipio.style.display='inline';
		}
		
	}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY BGCOLOR="FFFFFF" background="../Imagenes/fondo_claro.jpg">
<FORM action="../ciudadano/RegistroCiudadano.jsp" name="registroCiuForm" method="post">
<INPUT type="hidden" value="" name="accion">
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
<% if(ir == -1){%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="536"><B><FONT face="Verdana" color="RED" size="3">El Usuario que ingresaste ya existe. Ingresa uno nuevo</FONT></B></TD>
			<TD width="44">&nbsp;</TD>
			<TD width="265">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<% } %>
<% if(ir == -2){%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="RED" size="3">La Clave no coincide</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="365">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<% } %>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="#00204f" size="3">Registro de Usuario</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="368">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="#00204f" size="2">Datos Personales</FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="365">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#004080" colspan="4"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
<DIV class=documentBody id=Body>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
	<TR valign="top">
		<TD width="183"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
		<TD colspan="3"><FONT face="Verdana" size="2"><I></I></FONT></TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR VALIGN=top>
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Nombre(s): *</FONT></b></TD>
		<TD colspan="3"><FONT SIZE=2 FACE="Verdana"><INPUT size="50"
			type="text" name="reg_nombre" class="blue200a" value="<%=strNombre%>"> </FONT></TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR VALIGN=top>
		<td width="183"><b><font size="2" color="#004080" face="Arial">Apellido Paterno: *</font></b>
		</td>
		<td width="233"><font size="2" face="Arial"> <input
			name="reg_apellidoP" value="<%=strAP%>" Size=25 onfocus="" class="blue200a"> </font>
		</td>
		<td width="155"><font size="2" color="#004080" face="Arial">Apellido Materno:</font>
		</td>
		<td width="276"><font size="2" face="Arial"> <input name="reg_apellidoM"
			value="<%=strAM%>" Size=24 class="blue200a"> </font></td>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR VALIGN=top>
		<td width="183"><font size="2" color="#004080" face="Arial">Fecha de Nacimiento:</font>
		</td>
		<td colspan="3">
			<font size="2" face="Arial">Día:
				<SELECT name="reg_dia" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()" class="blue50a">
					<OPTION value="-1">-dd-</OPTION>
					<% for(int i=1;i<=dia;i++){ %>
					<OPTION value="<%=i%>" <%=(strDia.trim().equals(""+i+"")?"selected":"")%>><%=i%></OPTION>
					<% } %>
				</SELECT>
				Mes:
				<SELECT name="reg_mes" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()" class="blue100a">
					<OPTION value="-1">-Mes-</OPTION>
					<OPTION value="01" <%=(strMes.trim().equals("01")?"selected":"")%>>Enero</OPTION>
					<OPTION value="02" <%=(strMes.trim().equals("02")?"selected":"")%>>Febrero</OPTION>
					<OPTION value="03" <%=(strMes.trim().equals("03")?"selected":"")%>>Marzo</OPTION>
					<OPTION value="04" <%=(strMes.trim().equals("04")?"selected":"")%>>Abril</OPTION>
					<OPTION value="05" <%=(strMes.trim().equals("05")?"selected":"")%>>Mayo</OPTION>
					<OPTION value="06" <%=(strMes.trim().equals("06")?"selected":"")%>>Junio</OPTION>
					<OPTION value="07" <%=(strMes.trim().equals("07")?"selected":"")%>>Julio</OPTION>
					<OPTION value="08" <%=(strMes.trim().equals("08")?"selected":"")%>>Agosto</OPTION>
					<OPTION value="09" <%=(strMes.trim().equals("09")?"selected":"")%>>Septiembre</OPTION>
					<OPTION value="10" <%=(strMes.trim().equals("10")?"selected":"")%>>Octubre</OPTION>
					<OPTION value="11" <%=(strMes.trim().equals("11")?"selected":"")%>>Noviembre</OPTION>
					<OPTION value="12" <%=(strMes.trim().equals("12")?"selected":"")%>>Diciembre</OPTION>
				</SELECT>
				Año:
				<SELECT name="reg_year" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()" class="blue100a">
					<OPTION value="-1">-aaaa-</OPTION>
					<% for(int y=1920;y<=year;y++){ %>
					<OPTION value="<%=y%>" <%=(strYear.trim().equals(""+y+"")?"selected":"")%>><%=y%></OPTION>
					<% } %>
				</SELECT>
			</font>
		</td>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR VALIGN=top>
		<td width="183"><font size="2" color="#004080" face="Arial">Sexo:</font>
		</td>
		<td colspan="3">
			<font size="2" face="Arial">
				<SELECT name="reg_sexo" class="blue200a">
					<OPTION value="-1">-Selecciona-</OPTION>
					<OPTION value="0" <%=(strSexo.trim().equals("0")?"selected":"")%>>Femenino</OPTION>
					<OPTION value="1" <%=(strSexo.trim().equals("1")?"selected":"")%>>Masculino</OPTION>
				</SELECT>
			</font>
		</td>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR VALIGN=top>
		<td width="183"><font size="2" color="#004080" face="Arial">Ocupación:</font>
		</td>
		<td width="233">
			<FONT size="2" face="Arial">
				<SELECT name="reg_ocupacion" class="blue200a">
				<%
				String strOcu[][] = ActualizaCiudadano.getListaOcupacion();
				%>
					<OPTION value="-1">--Selecciona--</OPTION>
				<%
				for(int i=0;i<strOcu.length;i++){
				%>
					<OPTION value="<%=strOcu[i][0]%>" <%=(strOcupacion.equals(strOcu[i][1])?"selected":"")%>><%=strOcu[i][1]%></OPTION>
				<%}%>
			</SELECT>
			</FONT>
		</td>
		<TD width="155"><font size="2" color="#004080" face="Arial">Sector:</FONT></TD>
		<TD width="276">
			<FONT size="2" face="Arial">
				<SELECT name="reg_sector" class="blue200a">
					<OPTION value="-1">--Selecciona--</OPTION>
					<OPTION value="EMPRESARIAL" <%=(strSector.trim().equals("EMPRESARIAL")?"selected":"")%>>Empresarial</OPTION>
					<OPTION value="GOBIERNO" <%=(strSector.trim().equals("GOBIERNO")?"selected":"")%>>Gobierno</OPTION>
					<OPTION value="ACÁDEMICO" <%=(strSector.trim().equals("ACÁDEMICO")?"selected":"")%>>Acedémico</OPTION>
					<OPTION value="MEDIOS DE COMUNICACIÓN" <%=(strSector.trim().equals("MEDIOS DE COMUNICACIÓN")?"selected":"")%>>Medios de Comunicación</OPTION>
					<OPTION value="PARTICULAR" <%=(strSector.trim().equals("PARTICULAR")?"selected":"")%>>Particular</OPTION>
				</SELECT>
			</FONT>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR VALIGN=top>
		<TD width="183"><font size="2" color="#004080" face="Arial">Domicilio:</FONT></TD>
		<TD colspan="3"><FONT size="2" face="Arial"> <INPUT size="50"
			type="text" name="reg_domicilio" class="blue600a" value="<%=strDomicilio%>"></FONT></TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR VALIGN=top>
		<TD width="183"><font size="2" color="#004080" face="Arial">Pais:</FONT></TD>
		<TD colspan="3">
			<FONT size="2" face="Arial">
				<SELECT name="reg_pais" class="blue200a">
					<OPTION value="-1">-Selecciona-</OPTION>
					<OPTION value="MEXICO" <%=(strPais.trim().equals("MEXICO")?"selected":"")%>>México</OPTION>
				</SELECT>
			</FONT>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR VALIGN=top>
		<td width="183"><font size="2" color="#004080" face="Arial">Estado:</font>
		</td>
		<td width="233">
			<font size="2" face="Arial">
				<%String strEst[][] = ActualizaCiudadano.getListaEstado();%>
				<SELECT name="reg_estado" class="blue200a" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()">
					<OPTION value="-1">- Selecciona -</OPTION>
					<%for(int i=0;i<strEst.length;i++){%>
					<OPTION value="<%=strEst[i][0]%>" <%=(strEstado.equals(strEst[i][0])?"selected":"")%>><%=strEst[i][1]%></OPTION>
					<%}%>
				</SELECT>
			</font>
		</td>
		<td width="155"><font size="2" color="#004080" face="Arial">Municipio:</font>
		</td>
		<td width="276"><font size="2" face="Arial">
			<%String strMun[][] = ActualizaCiudadano.getListaMunicipio();%>
			<SELECT name="reg_municipio" class="blue200a" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()">
				<OPTION value="-1">- Selecciona -</OPTION>
				<%for(int i=0;i<strMun.length;i++){%>
				<OPTION value="<%=strMun[i][0]%>" <%=(strMunicipio.equals(strMun[i][0])?"selected":"")%>><%=strMun[i][1]%></OPTION>
				<%}%>
			</SELECT>
		</td>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR VALIGN=top>
		<td width="183"><font size="2" color="#004080" face="Arial">Telefono:</font>
		</td>
		<td width="233"><font size="2" face="Arial"> <input
			name="reg_telefono" value="<%=strTelefono%>" Size=25 onfocus="" class="blue200a"> </font>
		</td>
		<td width="155"><b><font size="2" color="#004080" face="Arial">Correo Electronico: *</font></b>
		</td>
		<td width="276"><font size="2" face="Arial"> <input name="reg_mail"
			value="<%=strMail%>" Size=24 class="blue200a"> </font></td>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<!-- separación -->
	<tr valign="top">
		<TD colspan="4">
			<B><FONT face="Verdana" color="#00204f" size="2">Datos de Usuario</FONT></B>
		</TD>
	</tr>
	<tr valign="top">
		<TD bgcolor="#004080" colspan="4"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Usuario*:</FONT></b></TD>
		<TD colspan="3"><FONT size="2" face="Arial"><INPUT size="50"
			type="text" name="reg_usuario" class="blue200a" maxlength="10" value="<%=strUsuario%>"></FONT><br>
			<%if(ir == 1){%><FONT size="1" face="Arial" color="red">El Usuario ya existe</FONT><%}%>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Clave*:</FONT></b></TD>
		<TD colspan="3"><FONT size="2" face="Arial"><INPUT size="50"
			type="password" name="reg_con1" class="blue200a" maxlength="8"></FONT></TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<TR valign="top">
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Confirmar Clave*:</FONT></b></TD>
		<TD colspan="3"><FONT size="2" face="Arial"><INPUT size="50"
			type="password" name="reg_con2" class="blue200a" maxlength="8"></FONT><br>
			<%if(ir == 2){%><FONT size="1" face="Arial" color="red">Ingresa la misma Clave para los mismos casilleros</FONT><%}%>
		</TD>
	</TR>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="183">&nbsp;</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td colspan="4" align="center">
			<INPUT type="button" class="blue100" value="Enviar" onclick="guardarCiudadano()">&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT type="button" class="blue100" value="Limpiar" onclick="limpiarRegistro()">&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT type="button" class="blue100" value="Cancelar" onclick="CancelarRegistroCiu()">
		</td>
	</tr>
</TABLE>
<br>
</DIV></DIV></DIV></FORM>
</BODY>
</HTML>
