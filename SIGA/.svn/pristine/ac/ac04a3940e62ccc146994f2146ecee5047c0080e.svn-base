<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerCiudadano.jsp" flush="false"></jsp:include>
<jsp:useBean id="CiudadanoBean" class="com.meve.sigma.beans.CiudadanoBean" scope="page"></jsp:useBean>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,java.util.*"
%> 
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
	int dia = 31;
	int year = 1995;
	int ir = 0;
	String strDatosCiudadano[][] = null;
	strDatosCiudadano = ActualizaCiudadano.getCiudadanoEditar(BCiudadano.getIdUsuario()); 
	String strAccion 	= 	"";
	String strNombre 	=	"";
	String strAP 		=	"";
	String strAM		=	"";
	String strDia		=	"";
	String strMes		=	"";
	String strYear		=	"";
	String strSexo		=	"";
	String strOcupacion	=	"";
	String strDomicilio	=	"";
	String strPais		=	"";
	String strEstado	=	"";
	String strMunicipio	=	"";
	String strTelefono	=	"";
	String strMail		=	"";
	String strUsuario	=	"";
	String strSector	=	"";
	String strFechaNac	=	"";
	String strIDCiu		=	"";
	
	strAccion = request.getParameter("accion");

	if(strAccion != null && strAccion.equals("editar")){
		String serverMail = session.getServletContext().getAttribute("app.siga.serverMail").toString();
		String portServer = application.getInitParameter("PortMail");
		String serverName = application.getInitParameter("servername");
		CiudadanoBean.ActualizarCiudadano(request, serverMail, portServer, serverName);  
		
		try{
				response.sendRedirect("PortalCiudadano.jsp");
		}catch(java.io.IOException io){
			//System.err.println("Error de redirección-->"+io);
		}
		
	}
	if(strDatosCiudadano != null && strDatosCiudadano.length > 0){
		strIDCiu	=	strDatosCiudadano[0][0];
		strNombre 	=	strDatosCiudadano[0][1];
		strAP		=	strDatosCiudadano[0][2];
		strAM		=	strDatosCiudadano[0][3];
		strMail		=	strDatosCiudadano[0][4];
		strOcupacion=	strDatosCiudadano[0][6];
		strDomicilio=	strDatosCiudadano[0][7];
		strPais		=	strDatosCiudadano[0][8];
		strEstado	=	strDatosCiudadano[0][9];
		strMunicipio=	strDatosCiudadano[0][10];
		strTelefono	=	strDatosCiudadano[0][11];
		strSector	=	strDatosCiudadano[0][12];
		strSexo		=	strDatosCiudadano[0][13];
		strFechaNac	=	strDatosCiudadano[0][14];
		String strDia1		=	"";
		StringTokenizer strAux = new StringTokenizer(strFechaNac,"-");
		if(strAux.hasMoreTokens())
		{
			strYear = strAux.nextToken();
			strMes	= strAux.nextToken();
			strDia	= strAux.nextToken();
			if(strDia.equals("01"))
				strDia = "1";
			if(strDia.equals("02"))
				strDia = "2";
			if(strDia.equals("03"))
				strDia = "3";
			if(strDia.equals("04"))
				strDia = "4";
			if(strDia.equals("05"))
				strDia = "5";
			if(strDia.equals("06"))
				strDia = "6";
			if(strDia.equals("07"))
				strDia = "7";
			if(strDia.equals("08"))
				strDia = "8";
			if(strDia.equals("09"))
				strDia = "9";
		//	//System.out.println("dia-->"+strDia);
			//strDia1 = strDia1.substring(0);
			////System.out.println("dia-->"+strDia1);
		}
	}
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<TITLE>EditarDatos.jsp</TITLE>
<SCRIPT language=JavaScript type=text/javascript> 
	function cambioMun(opcion){
		doc = document.FormEditar;
		valida = 0;
		msg="";
		if(opcion.options[opcion.selectedIndex].value=="BAJA CALIFORNIA"){
			
   			doc.reg_municipio1.style.display='inline';  
   			doc.reg_municipio.style.display='none';
			doc.reg_municipio.value='';
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
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;">
<FORM name="FormEditar" action="EditarDatos.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strIDCiu%>" name="reg_id">
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
			<TD width="125"><a onclick="EditarSolicitud()"> <img
				src="../Imagenes/Guardar.gif" width="81" border="0" name="guardaImg"> </a></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="227"></TD>
		</TR>
		<TR valign="top">
			<TD></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336"><B><FONT face="Verdana" color="#00204f" size="2">Mis Datos Personales</FONT></B></TD>
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
		<TD width="183"><b><font size="2" color="#004080" face="Arial">Nombre/s*:</FONT></b></TD>
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
		<td width="183"><font size="2" color="#004080" face="Arial">Apellido Paterno:</font>
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
				<SELECT name="reg_estado" class="blue200" onchange="cambioMun(this)" onKeypress="buscar_op1(this)" onblur="borrar_buffer()" onclick="borrar_buffer()">
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
		<td width="276">
			<font size="2" face="Arial">
			<input name="reg_municipio" value="<%=strMunicipio%>" Size=24 class="blue200"></font>
			
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
		<td width="155"><font size="2" color="#004080" face="Arial">Correo Electronico:</font>
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
		<td width="183">
			<A href="EditarPassword.jsp"><u><font size="2" color="#004080" face="Arial">Editar Mi Contraseña</font></u></A>
		</td>
		<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="155"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="276"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	
</TABLE>
<br>
</DIV></DIV></DIV>
</FORM>
</BODY>
</HTML>
