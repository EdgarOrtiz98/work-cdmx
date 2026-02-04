<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerUCT.jsp" flush="false"></jsp:include>
<jsp:useBean id="BCiudadano" class="com.meve.sigma.beans.CiudadanoBean" scope="page"></jsp:useBean>
<HTML>
<HEAD>
<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"
%>
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
%>
<%
	int dia = 31;
	int year = 1995;
	int ir = 0;
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
		//if(ir == 0){
			//String stridCiudadano = ActualizaCiudadano.getUltimoIdCiudadano();
		if(ir >= 0){
			String stridCiudadano = Integer.toString(ir);
			try{
				response.sendRedirect("confirmacionUCT.jsp?id_ciu="+stridCiudadano);
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
		doc = document.registroCiuFormUCT;
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
	function cancelar(){
		location.assign('SolicitudUCT.jsp');
	}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY BGCOLOR="FFFFFF" background="../Imagenes/fondo_claro.jpg">
<FORM action="RegistroCiudadanoUCT.jsp" name="registroCiuFormUCT" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="1" name="UCT">
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
			type="text" name="reg_nombre" class="blue200" value="<%=strNombre%>"> </FONT></TD>
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
			name="reg_apellidoP" value="<%=strAP%>" Size=25 onfocus="" class="blue200"> </font>
		</td>
		<td width="155"><font size="2" color="#004080" face="Arial">Apellido Materno:</font>
		</td>
		<td width="276"><font size="2" face="Arial"> <input name="reg_apellidoM"
			value="<%=strAM%>" Size=24 class="blue200"> </font></td>
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
				<SELECT name="reg_dia" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()">
					<OPTION value="-1">-dd-</OPTION>
					<% for(int i=1;i<=dia;i++){ %>
					<OPTION value="<%=i%>" <%=(strDia.trim().equals(""+i+"")?"selected":"")%>><%=i%></OPTION>
					<% } %>
				</SELECT>
				Mes:
				<SELECT name="reg_mes" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()">
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
				<SELECT name="reg_year" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()">
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
				<SELECT name="reg_sexo" class="blue200">
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
				<SELECT name="reg_ocupacion" class="blue200">
					<OPTION value="-1">--Selecciona--</OPTION>
					<OPTION value="HOGAR" <%=(strOcupacion.trim().equals("HOGAR")?"selected":"")%>>Hogar</OPTION>
					<OPTION value="ESTUDIANTE" <%=(strOcupacion.trim().equals("ESTUDIANTE")?"selected":"")%>>Estudiante</OPTION>
					<OPTION value="PROFESIONISTA" <%=(strOcupacion.trim().equals("PROFESIONISTA")?"selected":"")%>>Profesionista</OPTION>
					<OPTION value="EMPLEADO" <%=(strOcupacion.trim().equals("EMPLEADO")?"selected":"")%>>Empleado</OPTION>
					<OPTION value="INVESTIGADOR" <%=(strOcupacion.trim().equals("INVESTIGADOR")?"selected":"")%>>Investigador</OPTION>
					<OPTION value="PROFESOR" <%=(strOcupacion.trim().equals("PROFESOR")?"selected":"")%>>Profesor</OPTION>
					<OPTION value="REPORTERO" <%=(strOcupacion.trim().equals("REPORTERO")?"selected":"")%>>Reportero</OPTION>
					<OPTION value="OTRO" <%=(strOcupacion.trim().equals("OTRO")?"selected":"")%>>Otro</OPTION>
				</SELECT>
			</FONT>
		</td>
		<TD width="155"><font size="2" color="#004080" face="Arial">Sector:</FONT></TD>
		<TD width="276">
			<FONT size="2" face="Arial">
				<SELECT name="reg_sector" class="blue200">
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
			type="text" name="reg_domicilio" class="blue500" value="<%=strDomicilio%>"></FONT></TD>
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
				<SELECT name="reg_pais" class="blue200">
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
				<SELECT name="reg_estado" class="blue200" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()">
					<OPTION value="-1">- Selecciona -</OPTION>
					<OPTION value="AGUASCALIENTES" <%=(strEstado.trim().equals("AGUASCALIENTES")?"selected":"")%>>Aguascalientes</OPTION>
					<OPTION value="BAJA CALIFORNIA" <%=(strEstado.trim().equals("BAJA CALIFORNIA")?"selected":"")%>>Baja California</OPTION>
					<OPTION value="BAJA CALIFORNIA SUR" <%=(strEstado.trim().equals("BAJA CALIFORNIA SUR")?"selected":"")%>>Baja California Sur</OPTION>
					<OPTION value="CAMPECHE" <%=(strEstado.trim().equals("CAMPECHE")?"selected":"")%>>Campeche</OPTION>
					<OPTION value="CHIAPAS" <%=(strEstado.trim().equals("CHIAPAS")?"selected":"")%>>Chiapas</OPTION>
					<OPTION value="CHIHUAHUA" <%=(strEstado.trim().equals("CHIHUAHUA")?"selected":"")%>>Chihuahua</OPTION>
					<OPTION value="COAHUILA" <%=(strEstado.trim().equals("COAHUILA")?"selected":"")%>>Coahuila</OPTION>
					<OPTION value="COLIMA" <%=(strEstado.trim().equals("COLIMA")?"selected":"")%>>Colima</OPTION>
					<OPTION value="DISTRITO FEDERAL" <%=(strEstado.trim().equals("DISTRITO FEDERAL")?"selected":"")%>>Distrito Federal</OPTION>
					<OPTION value="DURANGO" <%=(strEstado.trim().equals("DURANGO")?"selected":"")%>>Durango</OPTION>
					<OPTION value="GUANAJUATO" <%=(strEstado.trim().equals("GUANAJUATO")?"selected":"")%>>Guanajuato</OPTION>
					<OPTION value="GUERRERO" <%=(strEstado.trim().equals("GUERRERO")?"selected":"")%>>Guerrero</OPTION>
					<OPTION value="HIDALGO" <%=(strEstado.trim().equals("HIDALGO")?"selected":"")%>>Hidalgo</OPTION>
					<OPTION value="JALISCO" <%=(strEstado.trim().equals("JALISCO")?"selected":"")%>>Jalisco</OPTION>
					<OPTION value="MICHOACAN" <%=(strEstado.trim().equals("MICHOACAN")?"selected":"")%>>Michoacan</OPTION>
					<OPTION value="MORELOS" <%=(strEstado.trim().equals("MORELOS")?"selected":"")%>>Morelos</OPTION>
					<OPTION value="EDOMEXICO" <%=(strEstado.trim().equals("EDOMEXICO")?"selected":"")%>>Edo. de México</OPTION>
					<OPTION value="NAYARIT" <%=(strEstado.trim().equals("NAYARIT")?"selected":"")%>>Nayarit</OPTION>
					<OPTION value="NUEVO LEON" <%=(strEstado.trim().equals("NUEVO LEON")?"selected":"")%>>Nuevo León</OPTION>
					<OPTION value="OAXACA" <%=(strEstado.trim().equals("OAXACA")?"selected":"")%>>Oaxaca</OPTION>
					<OPTION value="PUEBLA" <%=(strEstado.trim().equals("PUEBLA")?"selected":"")%>>Puebla</OPTION>
					<OPTION value="QUERETARO" <%=(strEstado.trim().equals("QUERETARO")?"selected":"")%>>Querétaro</OPTION>
					<OPTION value="QUINTANA ROO" <%=(strEstado.trim().equals("QUINTANA ROO")?"selected":"")%>>Quintana Roo</OPTION>
					<OPTION value="SAN LUIS POTOSI" <%=(strEstado.trim().equals("SAN LUIS POTOSI")?"selected":"")%>>San Luis Potosí</OPTION>
					<OPTION value="SINALOA" <%=(strEstado.trim().equals("SINALOA")?"selected":"")%>>Sinaloa</OPTION>
					<OPTION value="SONORA" <%=(strEstado.trim().equals("SONORA")?"selected":"")%>>Sonora</OPTION>
					<OPTION value="TABASCO" <%=(strEstado.trim().equals("TABASCO")?"selected":"")%>>Tabasco</OPTION>
					<OPTION value="TAMAULIPAS" <%=(strEstado.trim().equals("TAMAULIPAS")?"selected":"")%>>Tamaulipas</OPTION>
					<OPTION value="TLAXCALA" <%=(strEstado.trim().equals("TLAXCALA")?"selected":"")%>>Tlaxcala</OPTION>
					<OPTION value="VERACRUZ" <%=(strEstado.trim().equals("VERACRUZ")?"selected":"")%>>Veracruz</OPTION>
					<OPTION value="YUCATAN" <%=(strEstado.trim().equals("YUCATAN")?"selected":"")%>>Yucatán</OPTION>
					<OPTION value="ZACATECAS" <%=(strEstado.trim().equals("ZACATECAS")?"selected":"")%>>Zacatecas</OPTION>
				</SELECT>
			</font>
		</td>
		<td width="155"><font size="2" color="#004080" face="Arial">Municipio:</font>
		</td>
		<td width="276"><font size="2" face="Arial"> <input name="reg_municipio"
			value="<%=strMunicipio%>" Size=24 class="blue200"> </font>
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
			name="reg_telefono" value="<%=strTelefono%>" Size=25 onfocus="" class="blue200"> </font>
		</td>
		<td width="155"><b><font size="2" color="#004080" face="Arial">Correo Electronico: *</font></b>
		</td>
		<td width="276"><font size="2" face="Arial"> <input name="reg_mail"
			value="<%=strMail%>" Size=24 class="blue200"> </font></td>
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
			type="text" name="reg_usuario" class="blue200" maxlength="10" value="<%=strUsuario%>"></FONT><br>
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
			type="password" name="reg_con1" class="blue200" maxlength="8"></FONT></TD>
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
			type="password" name="reg_con2" class="blue200" maxlength="8"></FONT><br>
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
			<INPUT type="button" class="blue100" value="Cancelar" onclick="cancelar()">&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT type="button" class="blue100" value="Enviar" onclick="guardarCiudadanoUCT()">&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT type="button" class="blue100" value="Limpiar" onclick="limpiarRegistroUCT()">
		</td>
	</tr>
</TABLE>
<br>
</DIV></DIV></DIV></FORM>
</BODY>
</HTML>
