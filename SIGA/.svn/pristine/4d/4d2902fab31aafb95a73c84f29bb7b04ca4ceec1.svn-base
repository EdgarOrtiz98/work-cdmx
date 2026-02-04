<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.taglib.*,com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,com.meve.sigma.util.*"
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
<%
	String strIdAsunto		=	"";
	String strUnidad		=	"";
	String strArea			=	"";
	String strFondo			=	"";
	String strSubFondo		=	"";
	String strSeccion		=	"";
	String strSerie			=	"";
	String strSubserie		=	"";
	String strFechaApertura	=	"";
	String strFechaCierre	=	"";
	String strAsunto		=	"";
	String strValorDocto	=	"";
	String strVigenciaDocto	=	"";
	String strFojas			=	"";
	String strLegajos		=	"";	
	String strTipoAsunto 	= 	"";
	String strFechaCla		=	"";
	String strFundamento	=	"";
	String strPeriodoReserva=	"";
	String strDesclasificacion= "";
	String strAmpliacion	=	"";
	String strNumAnios		=	"";
	String strDesclasificacion1="";
	String strResponsableExp=	"";
	String strResponsableCla=	"";
	String strAccion		=	"";
	String strA				=	"";
	String strIdSubfondo	=	"";

	strIdAsunto	= 	(request.getParameter("idAsunto") != null)?request.getParameter("idAsunto"):"";
	strAsunto	= 	(request.getParameter("asunto") != null)?request.getParameter("asunto"):"";
	strAccion	= 	request.getParameter("accion");
	strA		= 	(request.getParameter("a") != null)?request.getParameter("a"):"";
	strArea		=	(request.getParameter("area") != null)?request.getParameter("area"):"";
	strIdSubfondo=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
	strSubFondo	=	(request.getParameter("id_sec") != null)?request.getParameter("id_sec"):"";
	
	if(strIdAsunto != null && strAccion != null && strAccion.equals("guardar")){
		//strUnidad		=	request.getParameter("archivadoUnidad");
		//strArea			=	request.getParameter("archivadoArea");
		//strFondo		=	request.getParameter("archivadoFondo");
		strSubFondo		=	request.getParameter("archivadoSubfondo");
		strSeccion		=	request.getParameter("archivadoSeccion");
		strSerie		=	request.getParameter("archivadoSerie");
		strSubserie		=	request.getParameter("archivadoSubserie");
		strFechaApertura=	request.getParameter("archivadoFechaApertura");
		strFechaCierre	=	request.getParameter("archivadoFechaCierre");
		//strAsunto		=	request.getParameter("archivadoAsunto");
		strValorDocto	=	request.getParameter("archivadoValorDocto");
		strVigenciaDocto=	request.getParameter("archivadoVigenciaDocto");
		strFojas		=	request.getParameter("archivadoFojas");
		strLegajos		=	request.getParameter("archivadoLegajos");
		strTipoAsunto 	= 	request.getParameter("archivadoTipoAsunto");
		strFechaCla		=	request.getParameter("archivadoFechaCla");
		strFundamento	=	request.getParameter("archivadoFundamento");
		strPeriodoReserva=	request.getParameter("archivadoPeriodoReserva");
		strDesclasificacion= request.getParameter("archivadoDesclasificacion");
		strAmpliacion	=	request.getParameter("archivadoAmpliacion");
		strNumAnios		=	request.getParameter("archivadoNumAnios");
		strDesclasificacion1=request.getParameter("archivadoDesclasificacion1");
		strResponsableExp=	request.getParameter("archivadoResponsableExp");
		strResponsableCla=	request.getParameter("archivadoResponsableCla");
		strIdAsunto		=	request.getParameter("idAsunto");
		
		boolean bInserta = ActualizaArchivado.InsertarArchivado(strSubFondo,
																strSeccion, strSerie, strSubserie, strFechaApertura,
																strFechaCierre, strValorDocto, strVigenciaDocto,
																strFojas, strLegajos, strTipoAsunto, strFechaCla,
																strFundamento, strPeriodoReserva, strDesclasificacion, strAmpliacion,
																strNumAnios, strDesclasificacion1, strResponsableExp, strResponsableCla,
																strIdAsunto);
		try{
			response.sendRedirect("AsuntoTurnado.jsp?id_asunto="+strIdAsunto);
		}catch(java.io.IOException io){
			//System.err.println("Error de redireccionamiento-->"+io);
		}
	}
	if(strA != null && strA.length() > 0){
		String strDatos[][] = 	ActualizaArchivado.getDatosArchivado(strIdAsunto);
		//String strArea		=	ActualizaArea.NombreArea()
		strSubFondo		=	strDatos[0][0];
		strSeccion		=	strDatos[0][1];
		strSerie		=	strDatos[0][2];
		strSubserie		=	strDatos[0][3];
		strFechaApertura=	Utilerias.formatearFechas(strDatos[0][4]);
		strFechaCierre	=	Utilerias.formatearFechas(strDatos[0][5]);
		strValorDocto	=	strDatos[0][6];
		strVigenciaDocto=	Utilerias.formatearFechas(strDatos[0][7]);
		strFojas		=	strDatos[0][8];
		strLegajos		=	strDatos[0][9];
		strTipoAsunto 	= 	strDatos[0][10];
		strFechaCla		=	Utilerias.formatearFechas(strDatos[0][11]);
		strFundamento	=	strDatos[0][12];
		strPeriodoReserva=	strDatos[0][13];
		strDesclasificacion= Utilerias.formatearFechas(strDatos[0][14]);
		strAmpliacion	=	strDatos[0][15];
		strNumAnios		=	strDatos[0][16];
		strDesclasificacion1=Utilerias.formatearFechas(strDatos[0][17]);
		strResponsableExp=	strDatos[0][18];
		strResponsableCla=	strDatos[0][19];
	}
%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Archivado Asunto</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
	function regresar(){
		location.assign('AsuntoTurnado.jsp?id_asunto=<%=strIdAsunto%>');
		//history.go(-1);
	}
	function subfondo(){
		doc = document.archivadoAsunto;
		var a = doc.archivadoSubfondo.value;
		var b = doc.archivadoSubfondo.value;
		var c = doc.area.value;
		var d = doc.asunto.value;
		<% if(strA != null && strA.length() > 0){ %>
		<%//System.err.println("Area="+strArea);%>
		<%//System.err.println("Asunto="+strAsunto);%>
		location.assign('ArchivadoAsunto.jsp?idAsunto=<%=strIdAsunto%>&asunto='+d+'&area='+c+'&id_sub='+a+'&id_sec='+b+'&a=1');
		<% }else{ %>
		location.assign('ArchivadoAsunto.jsp?idAsunto=<%=strIdAsunto%>&asunto='+d+'&area='+c+'&id_sub='+a+'&id_sec='+b);
		<% } %>
		//location.assign('FlujoAtencion.jsp?id_area=1');
	}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>

</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="ArchivadoAsunto.jsp" name="archivadoAsunto" method="post">
<INPUT type="hidden" name="accion" value="guardar">
<INPUT type="hidden" name="idAsunto" value="<%=strIdAsunto%>">
<INPUT type="hidden" name="area" value="<%=strArea%>">
<INPUT type="hidden" name="asunto" value="<%=strAsunto%>">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<TBODY>
		<tr valign="top">
			<td width="110"><input type="button" onclick="regresar()"
				value="Regresar" class="blue100">&nbsp;</td>
			<% if(!strA.equals("1")){ %>
			<td width="110"><input type="button" onclick="guardarArchivado()"
				value="Guardar" class="blue100"></td>
			<% }else{ %>
			<td width="110">&nbsp;</td>
			<% } %>
			<td width="263"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="400"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
	</TBODY>
</table>
</DIV>
<br>
<DIV class=documentBody id=Body>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<tr valign="top">
			<td width="183"><b><font size="2" color="#004080" face="Arial">Datos
			Básicos</font></b></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="386"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
	</TBODY>
</TABLE>
</DIV>
<br>

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Unidad Administrativa:</FONT>
			</TD>
			<TD colspan="3">
				<FONT face="Arial" size="2">
					<INPUT name="archivadoUnidad" class="blue500" value="<%=strUnidad%>">
				</FONT>
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Unidad Generadora:</FONT>
			</TD>
			<TD colspan="3">
				<FONT face="Arial" size="2">
					<INPUT name="archivadoArea" class="blue500" value="<%=strArea%>">
				</FONT>
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Fondo:</FONT>
			</TD>
			<TD colspan="3">
				<INPUT name="archivadoFondo" class="blue200" value="<%=strFondo%>">
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>

		<TR valign="top">
			<TD width="190">
				<b><FONT face="Arial" color="#004080" size="2">Subfondo:</FONT></b>
			</TD>
			<TD colspan="3">
				<meve_combo:comboseleccion data="<%= ComboData.getSubFondoCombo() %>" 
					size="1" name="archivadoSubfondo" classHtml="blue500" 
					selected="<%=strSubFondo%>" textoNoSeleccion="-- Selecciona una opción --" 
					valorNoSeleccion="-1" script="onchange='subfondo()'"/>
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<b><FONT face="Arial" color="#004080" size="2">Sección:</FONT></b>
			</TD>
			<% if(strA != null && strA.length() > 0){ %>
			<% //System.err.println("Entra si a == null"); %>
			<TD colspan="3">
				<% //System.err.println("*******"); %>
				<meve_combo:comboseleccion data="<%= ComboData.getSeccionCombo(strSubFondo) %>" 
					size="1" name="archivadoSeccion" classHtml="blue500" 
					selected="<%=strSeccion%>" textoNoSeleccion="-- Selecciona una opción --" 
					valorNoSeleccion="-1" />
			</TD>
			<% }else{ %>
			<TD colspan="3">
			<% if(strIdSubfondo != null && strIdSubfondo.length() > 0){ %>
				<meve_combo:comboseleccion data="<%= ComboData.getSeccionCombo(strIdSubfondo) %>" 
					size="1" name="archivadoSeccion" classHtml="blue500" 
					selected="<%=strSeccion%>" textoNoSeleccion="-- Selecciona una opción --" 
					valorNoSeleccion="-1" />
			<% }else{ %>
				<SELECT name="archivadoSeccion" class="blue500">
					<OPTION value="-1">-- Selecciona una opción --</OPTION>
				</SELECT>
			<% } %>
			</TD>
			<% } %>
			
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Serie:</FONT>
			</TD>
			<TD width="226">
				<INPUT name="archivadoSerie" class="blue200" value="<%=strSerie%>">
			</TD>
			<TD width="67">
				<FONT face="Arial" color="#004080" size="2">Subserie:</FONT>
			</TD>
			<TD width="380">
				<INPUT name="archivadoSubserie" class="blue200" value="<%=strSubserie%>">
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Fecha de Apertura:</FONT>
			</TD>
			<TD width="226">
				<INPUT name="archivadoFechaApertura" class="blue100" value="<%=strFechaApertura%>">
				<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='show_calendar("forms[0].archivadoFechaApertura");'></A>
				<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
			</TD>
			<TD width="67">
				<FONT face="Arial" color="#004080" size="2">Fecha de Cierre:</FONT>
			</TD>
			<TD width="380">
				<INPUT name="archivadoFechaCierre" class="blue100" value="<%=strFechaCierre%>">
				<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='show_calendar("forms[0].archivadoFechaCierre");'></A>
				<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Asunto:</FONT>
			</TD>
			<TD colspan="3">
				<INPUT name="archivadoAsunto" class="blue500" value="<%=strAsunto%>">
			</TD>
			
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Valor Documental:</FONT>
			</TD>
			<TD width="226">
				<INPUT name="archivadoValorDocto" class="blue200" value="<%=strValorDocto%>">
			</TD>
			<TD width="67">
				<FONT face="Arial" color="#004080" size="2">Vigencia Documental:</FONT>
			</TD>
			<TD width="380">
				<INPUT name="archivadoVigenciaDocto" class="blue100" value="<%=strVigenciaDocto%>">
				<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='show_calendar("forms[0].archivadoVigenciaDocto");'></A>
				<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Número de Fojas Útiles:</FONT>
			</TD>
			<TD width="226">
				<INPUT name="archivadoFojas" class="blue200" value="<%=strFojas%>">
			</TD>
			<TD width="67">
				<FONT face="Arial" color="#004080" size="2">Número de Legajos:</FONT>
			</TD>
			<TD width="380">
				<INPUT name="archivadoLegajos" class="blue200" value="<%=strLegajos%>">
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="380"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<tr valign="top">
			<td width="183"><b><font size="2" color="#004080" face="Arial">Carácter
			de la Información</font></b></td>
			<td width="233"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="386"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<tr valign="top">
			<td bgcolor="#004080" colspan="4"><img
				src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</tr>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="190">
				<b><FONT face="Arial" color="#004080" size="2">Clasificación del Asunto:</FONT></b>
			</TD>
			<TD colspan="3">
				<FONT face="Arial" size="2">
					<meve_combo:comboseleccion 	data="<%= ComboData.getClasificacionAreaCombo() %>" 
												size="1" name="archivadoTipoAsunto" 
												classHtml="blue500" 
												selected="<%= strTipoAsunto %>" 
												textoNoSeleccion="-- Selecciona un opción --" 
												valorNoSeleccion="-1"/>
				</FONT>
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="356"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Fecha de Clasificación:</FONT>
			</TD>
			<TD colspan="3">
				<FONT face="Arial" size="2">
					<INPUT name="archivadoFechaCla" class="blue100" value="<%=strFechaCla%>">
					<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='show_calendar("forms[0].archivadoFechaCla");'></A>
					<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
				</FONT>
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="356"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Fundamento Legal:</FONT>
			</TD>
			<TD colspan="3">
				<FONT face="Arial" size="2">
					<INPUT name="archivadoFundamento" class="blue500" value="<%=strFundamento%>">
				</FONT>
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="356"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Periodo de Reserva:</FONT>
			</TD>
			<TD width="226">
				<INPUT name="archivadoPeriodoReserva" class="blue200" value="<%=strPeriodoReserva%>">
			</TD>
			<TD width="67">
				<FONT face="Arial" color="#004080" size="2">Fecha de Desclasificación:</FONT>
			</TD>
			<TD width="356">
				<INPUT name="archivadoDesclasificacion" class="blue100" value="<%=strDesclasificacion%>">
				<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='show_calendar("forms[0].archivadoDesclasificacion");'></A>
				<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="356"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Ampliación del Periodo de Reserva:</FONT>
			</TD>
			<TD width="226">
				<SELECT name="archivadoAmpliacion" class="blue50">
					<OPTION value="0">Si</OPTION>
					<OPTION value="1">No</OPTION>
				</SELECT>
			</TD>
			<TD width="67">
				<FONT face="Arial" color="#004080" size="2">Numero de Años:</FONT>
			</TD>
			<TD width="356">
				<INPUT name="archivadoNumAnios" class="blue100" value="<%=strNumAnios%>">
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td width="226"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="67"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="356"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
		<TR valign="top">
			<TD width="190">
				<FONT face="Arial" color="#004080" size="2">Fecha de Desclasificación:</FONT>
			</TD>
			<TD colspan="3">
				<FONT face="Arial" size="2">
					<INPUT name="archivadoDesclasificacion1" class="blue100" value="<%=strDesclasificacion1%>">
					<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='show_calendar("forms[0].archivadoDesclasificacion1");'></A>
					<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT>
				</FONT>
			</TD>
		</TR>
		<tr valign="top">
			<td width="190">&nbsp;</td>
			<td><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
			<td width="356"><img src="../Imagenes/ecblank.gif" border="0"
				height="1" width="1" title=""></td>
		</tr>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="432" align="center">
			<FONT face="Arial" size="2">
				<INPUT name="archivadoResponsableExp" class="blue200" value="<%=strResponsableExp%>">
			</FONT>
		</TD>
		<TD width="431" align="center">
			<FONT face="Arial" size="2">
				<INPUT name="archivadoResponsableCla" class="blue200" value="<%=strResponsableCla%>">
			</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="432" align="center">
			<FONT face="Arial" size="2" color="#004080">
				Nombre del Responsable del<br>
				de la Unidad Generadora del Expediente
			</FONT>
		</TD>
		<TD width="431" align="center">
			<FONT face="Arial" size="2" color="#004080">
				Nombre del Responsable de<br>
				la Clasificación de la Información
			</FONT>
		</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
<br>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
