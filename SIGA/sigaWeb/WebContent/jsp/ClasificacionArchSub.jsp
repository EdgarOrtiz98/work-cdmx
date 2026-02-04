<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
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
	String strIdSubfondoSr	=	"";
	String strCodigo		=	"";
	String strSeccion		=	"";
	String strUsrActualiza	=	"";
	String strFecha			=	"";
	String strAccion		=	"";
	String strFondo			=	"";
	String strFondoP		=   (request.getParameter("fondoP") != null)?request.getParameter("fondoP"):"0"; 
	String strSubfondo		=	(request.getParameter("subfondo") != null)?request.getParameter("subfondo"):"0"; 
	String strSerie			=	"";
	String strSerieP		=	(request.getParameter("serieP") != null)?request.getParameter("serieP"):"0"; 
	String strSerieP2		=	"";
	String strsubSerieP		=	(request.getParameter("serie") != null)?request.getParameter("serie"):"0"; 
	String strSeccionA		=	"";
	String stridSeccion		=	(request.getParameter("idSeccion") != null)?request.getParameter("idSeccion"):"0";
	String strobservacion	=	"";
	String strFechaAT		=	"";
	String strFechaAC		=	"";
	String strFechaTotal	=	"";
	String strAnosPUB		=	"";
	String strAnosSISI		=	"";
	String strConf			=	"";
	String strClave			=	"";
	String strstruc			=	"";	
	String strReserva		=	"";
	String strClv1			=	"";	
	String strClv2			=	"";	
	String strClv3			=	"";	
	String strClv4			=	"";	
	String strClv5			=	"";
	String strCarga			=	(request.getParameter("cargaclv") != null)?request.getParameter("cargaclv"):"";
	String strInact			=	"";
	String strFecInac		=	"";
	String strJustInac		=	"";	
	String ver				=	"";		
	String vertodo			=	"";
	String horafec			=	"";
	String strFechaATSer	=	"";
	String strFechaACSer	=	"";
	String bloqclv			=	"";
	String Idpas			= 	"";
	String strsoloDesc 		=	"";
				
	String strAux = "1234567";	
	
	boolean bInsertar		=	false;
	int bInsertar1		=	0;
		int valida		=	0;	
	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFecha						=	sdf.format(f);

	String retURI = (request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
	strAccion		=	request.getParameter("accion");
	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
	strIdSubfondoSr	=	(request.getParameter("id_subsr") != null)?request.getParameter("id_subsr"):"";
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			strSeccionA	=   request.getParameter("seleccion");
			strSerie	=   request.getParameter("valor");
			strFondo	=   request.getParameter("comb");
			strSeccion	=	request.getParameter("subSeccion");
			strCodigo	=	request.getParameter("subCodigo");
			strobservacion		=	request.getParameter("obvser");
			strFechaAT		=	(request.getParameter("vigenciaat")!= null)?request.getParameter("vigenciaat"):request.getParameter("vigenciaat2");
			strFechaAC		=	(request.getParameter("vigenciaac")!= null)?request.getParameter("vigenciaac"):request.getParameter("vigenciaac2");
			strFechaTotal	=	(request.getParameter("vigenciatot")!= null)?request.getParameter("vigenciatot"):request.getParameter("vigenciatot2");
			strAnosPUB		=	request.getParameter("anopub");
			strAnosSISI		=	request.getParameter("anosisi");
			strConf			=	request.getParameter("conf");
			strClave	=	request.getParameter("clave"); 	
			strReserva	=	request.getParameter("reserv"); 
			
			bInsertar1	=	ActualizaExpArchivado.insertarClasifsub(strCodigo, strSeccion,
																strFecha, BUsuario.getIdUsuario(),strSerie,strSeccionA,
																strFechaAT,strFechaAC,strFechaTotal,strAnosSISI,strConf,strClave,strReserva,
																strFondoP,strSubfondo,stridSeccion,strSerieP,strsubSerieP,strobservacion,strAux);
													
			if(bInsertar1 == 2)
			{
			//msg ="La clave existe";
				vertodo 		= "true";
				strCarga 		= "CARGA";
			}
			else{
				try{
					//response.sendRedirect("ClasificacionArchSubview.jsp?msg="+msg);
					response.sendRedirect(retURI+"&msg="+msg);
				}catch(java.io.IOException io){
					//System.out.println("Error-->"+io);
				}
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strsoloDesc		=	request.getParameter("soloDesc");
			strSeccionA		=   request.getParameter("selec2");
			strSerie		=   request.getParameter("valor2");
			//strFondo		=   request.getParameter("combina2");
			strSeccion		=	request.getParameter("subSeccion");
			strCodigo		=	request.getParameter("subCodigo");
			strobservacion	=	request.getParameter("obvser");
			strFechaAT		=	(request.getParameter("vigenciaat")!= null)?request.getParameter("vigenciaat"):request.getParameter("vigenciaat2");
			strFechaAC		=	(request.getParameter("vigenciaac")!= null)?request.getParameter("vigenciaac"):request.getParameter("vigenciaac2");
			strFechaTotal	=	(request.getParameter("vigenciatot")!= null)?request.getParameter("vigenciatot"):request.getParameter("vigenciatot2");
			strSerieP	=	request.getParameter("SerieP2");
			strAnosSISI		=	request.getParameter("anosisi");
			strConf			=	request.getParameter("conf");
			strClave		=	request.getParameter("clave"); 		
			strInact		=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
			strFecInac		=	request.getParameter("fecinact");
			strJustInac 	=	request.getParameter("justif");			
			strReserva		=	request.getParameter("reserv");				
			strAux 			= 	request.getParameter("aux"); 
			 
			bInsertar1 = ActualizaExpArchivado.actualizaClasificacionsub(strsoloDesc,strCodigo, strSeccion, strFecha, 
															BUsuario.getIdUsuario(), strSerie, strSeccionA,
															strFechaAT,strFechaAC,strFechaTotal,strAnosSISI,strConf,strIdSubfondo,strClave
															,strFecInac,strJustInac,strInact,strReserva,strobservacion,strSerieP,strAux);

			if(bInsertar1 != 2){
				try{
					//response.sendRedirect("ClasificacionArchSubview.jsp?msg="+msg);
					response.sendRedirect(retURI+"&msg="+msg);
				}catch(java.io.IOException io){
					//System.out.println("Error-->"+io);
				}
			}
			else
				{
					vertodo 		= "true";
					strCarga 		= "CARGA";
					Idpas			= strIdSubfondo;
					strIdSubfondoSr = null;
					////System.out.println("Busca1:"+Idpas);
				}
		}
	}


	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
	{

		String strDatosSubfondo[][] = ActualizaExpArchivado.getClasificacionsub(strIdSubfondo);
		strCodigo		=	strDatosSubfondo[0][0];
		strSeccion		=	strDatosSubfondo[0][1];
		strFecha		=	strDatosSubfondo[0][2];
		strUsrActualiza	=	strDatosSubfondo[0][3];
		strSerie		=	strDatosSubfondo[0][4];
		strSeccionA		=	strDatosSubfondo[0][5];
		strFechaAT		=	strDatosSubfondo[0][6];
		strFechaAC		=	strDatosSubfondo[0][7];
		strFechaTotal	=	strDatosSubfondo[0][8];
		strAnosSISI		=	strDatosSubfondo[0][9];
		strConf			=	strDatosSubfondo[0][10];
		strClave		=	strDatosSubfondo[0][11];		 
		strReserva		=	strDatosSubfondo[0][12];	
		strFondoP		=	strDatosSubfondo[0][13];
		strSubfondo		=	strDatosSubfondo[0][14];
		stridSeccion	=	strDatosSubfondo[0][15];
		strSerieP		=	strDatosSubfondo[0][16];
		strsubSerieP 	=	strDatosSubfondo[0][17];
		strobservacion	=	strDatosSubfondo[0][18];
		strFecInac		=	strDatosSubfondo[0][19];	
		strJustInac		=	strDatosSubfondo[0][20];	
		strInact		=	strDatosSubfondo[0][21];
		horafec			=	strDatosSubfondo[0][22];	
		strFechaATSer	=	strDatosSubfondo[0][23];	
		strFechaACSer	=	strDatosSubfondo[0][24];		
		strAux			=  	strClave;				
		ver				=	"si";	
		vertodo 		=   "true";
		strCarga 		=   "CARGA";
		bloqclv 		= 	"true";		
		valida	=	ActualizaExpArchivado.getValidaClasificacionsub(strIdSubfondo);		
	}
	
	if(strIdSubfondoSr != null && strIdSubfondoSr.trim().length()>0)
	{
		String strDatosSubfondo[][] = ActualizaExpArchivado.getClasificacion(strIdSubfondoSr);

		strCodigo		=	strDatosSubfondo[0][0];
		strSeccion		=	strDatosSubfondo[0][1];
		strFecha		=	strDatosSubfondo[0][2];
		strUsrActualiza	=	strDatosSubfondo[0][3];
		strSerie	=		strDatosSubfondo[0][4];
		strSeccionA	=		strDatosSubfondo[0][5];
		 strFechaAT	=		strDatosSubfondo[0][6];
		 strFechaATSer	=	strDatosSubfondo[0][6];
		 strFechaAC	=		strDatosSubfondo[0][7];
		 strFechaACSer	=	strDatosSubfondo[0][7];
		 strFechaTotal =	strDatosSubfondo[0][8];
		 strAnosSISI=		strDatosSubfondo[0][9];
		 strConf	=		strDatosSubfondo[0][10];
		//strClave		=	strDatosSubfondo[0][11];		 
		strReserva		=	strDatosSubfondo[0][12];	
		//strFondoP		=	strDatosSubfondo[0][13];
		//strSubfondo	=	strDatosSubfondo[0][14];
		//stridSeccion	=	strDatosSubfondo[0][15];
		//strSerieP		=	strDatosSubfondo[0][16];
		//strsubSerieP 	=	strDatosSubfondo[0][17];
		strobservacion	=	strDatosSubfondo[0][18];
		strFecInac		=	strDatosSubfondo[0][19];	
		strJustInac		=	strDatosSubfondo[0][20];	
		strInact		=	strDatosSubfondo[0][21];
		horafec			=	strDatosSubfondo[0][22];		
		strAux			=  	strClave;				
		vertodo 		= "true";
		strCarga 		= "CARGA";

	}

	if(strCarga!=null && strCarga.trim().length()>0)
		{
		
		if(strFondoP!=null && strFondoP.trim().length()>0)
		{
			String strDatosclv1[][] = ActualizaExpArchivado.getCargafon(strFondoP);
			if (strDatosclv1.length >0)
			strClv1 = strDatosclv1[0][0];
		}
		
		strClv2 = "0";
		if(strSubfondo !=null && strSubfondo.trim().length()>0)
			{
			String strDatosclv2[][] = ActualizaExpArchivado.getCargasubfon(strSubfondo);
			if (strDatosclv2.length >0)
			strClv2 = strDatosclv2[0][0];	
			}	
		if(stridSeccion!=null && stridSeccion.trim().length()>0)
		{
			String strDatosclv3[][] = ActualizaExpArchivado.getCargasec(stridSeccion);				
			if (strDatosclv3.length >0)
				{
				strClv3 = strDatosclv3[0][0];
							}
		}
		if(strSerieP!=null && strSerieP.trim().length()>0)
		{		
			String strDatosclv4[][] = ActualizaExpArchivado.getCargaser(strSerieP);
			if (strDatosclv4.length >0)
			{
				strClv4 = strDatosclv4[0][0];		
				vertodo = "true";
			}
		}
		if(Integer.parseInt(strClv2) > 0)
		{
		 
		strstruc = strClv1 +"."+strClv2+"."+strClv3+"."+strClv4;
		}else
		{
		strstruc = strClv1 +"."+strClv3+"."+strClv4;
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
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/Menu2.js"></script>
<TITLE>Instrumento</TITLE>
<script type="text/javascript" src="../js/valida.js"></script>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
<SCRIPT language="JavaScript" type="text/javascript">
function sum() { 
 var at = parseInt(document.clsfsub.vigenciaat.value);
 var ac = parseInt(document.clsfsub.vigenciaac.value);

	if (isNaN(at)==true) 
	at = 0;
	if (isNaN(ac)==true) 
	ac = 0;
	
   suma = at + ac;
   document.clsfsub.vigenciatot.value = suma

}

function limpiarCampos(){
	document.clsfsub.reset();
}
 function detalle2() {
	cambio(); 
	//det2= document.clsfsub.comb.value;
	//document.getElementById('detalle2').src= "CombDetalle.jsp?cls="+det2;
	}	
 function detalle() { 
	cambio();  
	det= document.clsfsub.valor.value;
	document.getElementById('detalle').src= "DetalleValor.jsp?cls="+det;
	}
 function copiar()
 {
 anio= document.clsfsub.reserv.value;
 document.clsfsub.anopub.value = anio;
 }
 function rValidando() {
	<%if(valida == 2) 
	{%>
	alert("Como este registro ya cuenta con registros dependientes, solo podra ser modificado su descripción ");
	<%
	}%>
 } 
 function cambio(){
	doc = document.clsfsub;
	
	val2 = doc.valor.value;
	doc.valor2.value = val2;
	val3 = doc.seleccion.value;
	doc.selec2.value = val3;		
 } 
 function windowAbre(s)
 	{
 	window.open( s ,'window','width=620,height=450,status=yes');
 	window.focus;
 	}
 	
function reload() {
	
	doc = document.clsfsub;
	//doc.cargaclv.value="CARGA";
	doc.accion.value="reload";
	doc.submit();

} 
function claved() {
	doc = document.clsfsub;
	doc.cargaclv.value="CARGA";
}	
function indefinido()
 {
 doc = document.clsfsub;
 	if (doc.vigIndef.checked == true) {
 	doc.vigenciaac.value = "99";
 	doc.vigenciaat.value = "99";
 	doc.vigenciatot.value = "999";
 	doc.vigenciaac2.value = "99";
 	doc.vigenciaat2.value = "99";
 	doc.vigenciatot2.value = "999";
 	doc.vigenciaac.disabled = true;
 	doc.vigenciaat.disabled = true;
 	doc.vigenciatot.disabled = true;
 	}
 	else
 	{
 	doc.vigenciaac.disabled =false;
 	doc.vigenciaat.disabled =false;
 	doc.vigenciatot.disabled =false;
 	doc.vigenciaac.value = doc.vigenciaac3.value;
 	doc.vigenciaat.value = doc.vigenciaat3.value;
 	doc.vigenciatot.value = doc.vigenciatot3.value;
 	}
 }

function habilita2()
	{
		if(document.clsfsub.inactivo.checked == true)
		{
		document.clsfsub.fecinact.value = "<%=horafec%>";
		document.clsfsub.fecinact.disabled = false;
		document.clsfsub.justif.disabled = false;
		}else
		{
		document.clsfsub.fecinact.value = "";
		document.clsfsub.justif.value = "";
		document.clsfsub.fecinact.disabled = true;
		document.clsfsub.justif.disabled = true;
		}
	}	
function idllena()	
{
	id = document.clsfsub.serieP.value;
	document.clsfsub.id_subsr.value = id;
}
function validanum()	
{
	val = parseInt(document.clsfsub.vigenciaat.value);
	numv= parseInt(<%=strFechaATSer%>);
	if(val > numv)
		{
		alert("El valor no puede ser mayor al predefinido por la Serie");
		document.clsfsub.vigenciaat.value = numv;
		return false;
		}
	else
		{
		sum();
		}
}
function validanum2()	
{
	val = parseInt(document.clsfsub.vigenciaac.value);
	numv= parseInt(<%=strFechaACSer%>);
	if(val > numv)
		{
		alert("El valor no puede ser mayor al predefinido por la Serie");
		document.clsfsub.vigenciaac.value = numv;
		return false;
		}
	else
		{
		sum();
		}
}

function llenando()		
	{
	var a =  document.clsfsub.clave.value;
	num = a.length;
	var af = "";
	if(num < 3)
		{
			for (i=num; i<3; i++){
				af = af + "0";
			}
		}
	document.clsfsub.clave.value = af+a;
	}
function validaAniosRerv()		
	{
	var a =  document.clsfsub.reserv.value;
	if (eval(a)>12)	
		{
			alert("Los años de reserva no puenden ser mayor a 12 años¡");
			document.clsfsub.reserv.value ="12";
		}
	}	
</SCRIPT>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0;rValidando();limpiarCampos();timer_load();detalle()" 
	onKeyPress="timer_reload();" 
	onmousemove="	limitaTextArea(document.clsfsub.subSeccion,'Descripción','4000');
					limitaTextArea(document.clsfsub.obvser,'Observaciones','1000');"
	onClick="timer_reload();">
<FORM action="ClasificacionArchSub.jsp" name="clsfsub" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="" name="cargaclv">
<INPUT type="hidden" value="<%=strFechaAC%>" name="vigenciaac2">
<INPUT type="hidden" value="<%=strFechaAT%>" name="vigenciaat2">
<INPUT type="hidden" value="<%=strFechaTotal%>" name="vigenciatot2">
<INPUT type="hidden" value="<%=strFechaAC%>" name="vigenciaac3">
<INPUT type="hidden" value="<%=strFechaAT%>" name="vigenciaat3">
<INPUT type="hidden" value="<%=strFechaTotal%>" name="vigenciatot3">
<INPUT type="hidden" value="<%=strIdSubfondo%>" name="id_sub">
<INPUT type="hidden" value="<%=strIdSubfondo%>" name="id_subsr">
<INPUT type="hidden" value="<%=strAux%>" name="aux"> 
<INPUT type="hidden" value="<%=strFondo%>" name="combina2">
<INPUT type="hidden" value="<%=strSerie%>" name="valor2">
<INPUT type="hidden" value="<%=strSeccionA%>" name="selec2">
<INPUT type="hidden" value="<%=retURI%>" name="retURI">
<INPUT type="hidden" value="<%=strSerieP%>" name="SerieP2">
<%if(valida == 2){
		strsoloDesc = "1";
	}
	%>
<INPUT type="hidden" value="<%=strsoloDesc%>" name="soloDesc">

<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><a href="<%= retURI %>"> <IMG
				border="0" src="../Imagenes/NavLeft.gif" title="Regresar"> </a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%if(vertodo=="true") {%>
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						<a></a>
					<%	}else{%>	
						<a><img	src="../Imagenes/Save.gif" title="Guardar"	onclick="GuardarClasfsub()"></a> 
					<%}%>			
			<%}%>
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


<DIV class="documentBody" id="Body" style="HEIGHT: 441px">
<DIV align="center">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD colspan="2" width="204"><B><FONT face="Verdana" color="#00204f"
				size="2"><FONT size="+1" color="#004080">Instrumento Clasificación y Disposición Documental (Subserie)</FONT></FONT></B></TD>
			<TD width="26">&nbsp;</TD>
			<TD width="442" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD width="204" colspan="2"></TD>
			<TD width="26"></TD>
			<TD width="442" align="right"></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD width="204" colspan="2"></TD>
			<TD width="26"></TD>
			<TD width="442" align="right"></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">&nbsp;</FONT></B></FONT></TD>
			<% if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ %>
			<TD width="528" align="right"><FONT face="Verdana" size="2">Creado
			por: <I><%=ActualizaUsuario.NombreUsuario(strUsrActualiza)%> - <%= strFecha %></I></FONT>
			</TD>
			<% }else{ %>
			<TD width="528" align="right"><FONT face="Verdana" size="2">Creado
			por: <I><%= BUsuario.getNombre() %> - <%= strFecha %></I></FONT>
			</TD>
			<% }%>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Fondo:</FONT></B></FONT>&nbsp;<A href="#" onclick="windowAbre('FondoArch.jsp')"><FONT color="Blue" size="1"></FONT></A></TD>
			<TD width="528">
			<%if(bloqclv == "true") 
						{%>			
					<meve_combo:comboseleccion
						data="<%= ComboData.getFondoC() %>" size="1" name="fondoP"
						classHtml="blue500" selected="<%= strFondoP %>"
						textoNoSeleccion=" ------------ Seleccione un Fondo------------ "
						valorNoSeleccion="-1" 
						disabled="true"
						script="onchange='claved();reload()'"/>
			<%
			} else
			{%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getFondoC() %>" size="1" name="fondoP"
						classHtml="blue500" selected="<%= strFondoP %>"
						textoNoSeleccion=" ------------ Seleccione un Fondo------------ "
						valorNoSeleccion="-1" 
						script="onchange='claved();reload()'"/>
			<%
			}%>	

			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			SubFondo:</FONT></B></FONT>&nbsp;<A href="#" onclick="windowAbre('SubfondoArch.jsp')"><FONT color="Blue" size="1"></FONT></A></TD>
			<TD width="528">
			<%if(bloqclv == "true") 
						{%>
			<meve_combo:comboseleccion
						data="<%=ComboData.getSubFondoC(strFondoP)%>" size="1" name="subfondo"
						classHtml="blue500" selected="<%= strSubfondo %>"
						textoNoSeleccion=" ------------ Seleccione un Subfondo------------ "
						valorNoSeleccion="0" 
						disabled="true"
						script="onchange='claved();reload()'"/>
			<%
			} else
			{%>
				<meve_combo:comboseleccion
						data="<%=ComboData.getSubFondoC(strFondoP)%>" size="1" name="subfondo"
						classHtml="blue500" selected="<%= strSubfondo %>"
						textoNoSeleccion=" ------------ Seleccione un Subfondo------------ "
						valorNoSeleccion="0" 
						script="onchange='claved();reload()'"/>
			
			<%
			}%>							
			</TD>
		</TR>		
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
			<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Sección:</FONT></B></FONT>&nbsp;<A href="#" onclick="windowAbre('SeccionArch.jsp')"><FONT color="Blue" size="1"></FONT></A></TD>
			<TD width="528">
			<%if(bloqclv == "true") 
						{%>
					<meve_combo:comboseleccion
						data="<%=ComboData.getSeccionComboInst(strFondoP,strSubfondo)%>" size="1" name="idSeccion"
						classHtml="blue500" selected="<%= stridSeccion %>"
						textoNoSeleccion=" ------------ Seleccione una Sección------------ "
						valorNoSeleccion="0" 
						disabled="true"
						script="onchange='claved();reload()'"/>
			<%
			} else
			{%>
					<meve_combo:comboseleccion
						data="<%=ComboData.getSeccionComboInst(strFondoP,strSubfondo)%>" size="1" name="idSeccion"
						classHtml="blue500" selected="<%= stridSeccion %>"
						textoNoSeleccion=" ------------ Seleccione una Sección------------ "
						valorNoSeleccion="0" 
						script="onchange='claved();reload()'"/>
			
			<%
			}%>	
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>                                                                                                                                                                                      
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Serie:</FONT></B></FONT></TD>
			<TD width="528">
			<%if(bloqclv == "true") 
				{%>			
				<meve_combo:comboseleccion
				data="<%=ComboData.getSerieComboP(stridSeccion) %>" size="1" name="serieP"
				classHtml="blue500" selected="<%= strSerieP %>"
				textoNoSeleccion=" ------------ Seleccione un Serie------------ "
				valorNoSeleccion="0" 
				disabled="true"
				script="onchange='idllena();claved();reload()'"/>
			<%
			} else
			{%>
				<meve_combo:comboseleccion
				data="<%=ComboData.getSerieComboP(stridSeccion) %>" size="1" name="serieP"
				classHtml="blue500" selected="<%= strSerieP %>"
				textoNoSeleccion=" ------------ Seleccione un Serie------------ "
				valorNoSeleccion="0" 
				script="onchange='idllena();claved();reload()'"/>
			<%
			}%>							
			</TD>
		</TR>		
		<%if(vertodo=="true") {%>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>                                                                                                                                                                                      
		</TR>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">
			Estructura:<BR>
			</FONT>
			</TD>
			<TD width="528">
				<INPUT name="struct" value="<%=strstruc%>" MAXLENGTH="200" 
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>	
					<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
				type="text" class="blue500" onfocus="blur();" onkeypress="AceptaSoloTeclaNumericaYPunto();" readonly>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
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
						disabled="disabled"
						<%
						}%>
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>		
				  type="text" class="blue100"  onblur="llenando();"
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>				
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Nombre:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT name="subCodigo" value="<%=strCodigo%>" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>		
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>			
				type="text" class="blue500" maxlength="200">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080">&nbsp;</FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Descripción:</FONT></B></FONT></TD>
			<TD width="528">
			<TEXTAREA name="subSeccion" rows="5" cols="65" 
				onKeyDown="limitaTextArea(document.clsfsub.subSeccion,'Descripción','4000');"
				<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>
				class="blue500"><%=strSeccion%></TEXTAREA> 
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">
			&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
			<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Valoración:</FONT></B></FONT></TD>
			<TD width="528">
			<%
			String voice = "";
			
		String strDatosVal[][] = ActualizaExpArchivado.getValClasificacionsub(strSerie);
			if (strDatosVal.length >0)
			{
			voice = strDatosVal[0][0];	
			}

			
			if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)  ){%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getValorComboSub(voice) %>" size="1" name="valor"
						classHtml="blue500" selected="<%= strSerie %>"
						textoNoSeleccion=" ------------ Seleccione una Valoración------------ "
						valorNoSeleccion="-1" 
						disabled="true" 
						script="onchange='detalle();'"/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getValorComboSub(voice) %>" size="1" name="valor"
						classHtml="blue500" selected="<%= strSerie %>"
						textoNoSeleccion=" ------------ Seleccione una Valoración------------ "
						valorNoSeleccion="-1" 
						disabled="true" 
						script="onchange='detalle();'"/>
					<%}%>
			<%}else{%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getValorComboSub(voice) %>" size="1" name="valor"
						classHtml="blue500" selected="<%= strSerie %>"
						textoNoSeleccion=" ------------ Seleccione una Valoración------------ "
						valorNoSeleccion="-1" 
						script="onchange='detalle();'"/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getValorComboSub(voice) %>" size="1" name="valor"
						classHtml="blue500" selected="<%= strSerie %>"
						textoNoSeleccion=" ------------ Seleccione una Valoración------------ "
						valorNoSeleccion="-1" 
						script="onchange='detalle();'"/>
					<%}%>
			<%}%>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">
			<INPUT type="button" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>				
			onclick="document.getElementById('pop9').style.visibility='visible';" class="s-dropdown-btn">
			<DIV class="popup" id="pop9">
				<IFRAME src="#"  WIDTH="700" HEIGHT="200" frameborder=1 id="detalle"></IFRAME>
			</DIV>
			</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Vigencia Indefinida:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT type=checkbox  value="si"  
				name="vigIndef"
			<%if(strFechaAT == "99" || strFechaAT.equals("99")) 
			{%>
				checked
			<%
			}%>	
				<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>	
				onclick="indefinido();">
			</TD>
		</TR>			
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD> 
		</TR>
		
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Vigencia AT:</FONT></B></FONT></TD>
			<TD width="528">
			<INPUT name="vigenciaat" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
						<%if(strFechaAT == "99" || strFechaAT.equals("99")) 
					{%>
						disabled="disabled"
					<%
						}%>		
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>	
			value="<%=strFechaAT%>" MAXLENGTH="2" type="text" class="blue100"
			onblur="validanum()" 
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Vigencia AC:</FONT></B></FONT></TD>
			<TD width="528">
			<INPUT name="vigenciaac" value="<%=strFechaAC%>" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
					<%if(strFechaAT == "99" || strFechaAT.equals("99")) 
					{%>
						disabled="disabled"
					<%}%>				
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>	
			MAXLENGTH="2" onblur="validanum2();" type="text" class="blue100"
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Vigencia TOTAL:</FONT></B></FONT></TD>
			<TD width="528">
			<INPUT name="vigenciatot"  value="<%=strFechaTotal%>" MAXLENGTH="3" type="text" class="blue100" onfocus="blur();"
					<%if(strFechaAT == "99" || strFechaAT.equals("99")) 
					{%>
						disabled="disabled"
					<%}%>
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>	
					<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>						
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD> 
		</TR>		
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Técnica de Selección:</FONT></B></FONT></TD>
			<TD width="528">
			<%if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)){%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSeleccionCombo() %>" size="1" name="seleccion"
						classHtml="blue500" selected="<%= strSeccionA %>"
						textoNoSeleccion=" ---------- Elija un Tipo de Selección ---------- "
						valorNoSeleccion="-1" 
						disabled="true"
						script="onchange='cambio();'"/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSeleccionCombo() %>" size="1" name="seleccion"
						classHtml="blue500" selected=""
						textoNoSeleccion=" ---------- Elija un Tipo de Selección ---------- "
						valorNoSeleccion="-1" 
						disabled="true"
						script="onchange='cambio();'"/>
					<%}%>
			<%}else{%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSeleccionCombo() %>" size="1" name="seleccion"
						classHtml="blue500" selected="<%= strSeccionA %>"
						textoNoSeleccion=" ---------- Elija un Tipo de Selección ---------- "
						valorNoSeleccion="-1" 
						script="onchange='cambio();'"/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getSeleccionCombo() %>" size="1" name="seleccion"
						classHtml="blue500" selected="<%= strSeccionA %>"
						textoNoSeleccion=" ---------- Elija un Tipo de Selección ---------- "
						valorNoSeleccion="-1" 
						script="onchange='cambio();'"/>
					<%}%>
			<%}%>	
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			Observaciónes:</FONT></FONT></TD>
			<TD width="528">
			<TEXTAREA name="obvser" rows="3" cols="65" 
				onkeydown="limitaTextArea(document.clsfsub.obvser,'Descripción','1000');"
				<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>
					<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
				class="blue500"><%=strobservacion%></TEXTAREA> 
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Años Reserva:</FONT></B></FONT></TD>
			<TD width="528">
			<INPUT name="reserv" value="<%=strReserva%>" onkeyup="validaAniosRerv()" 
					<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>		
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>	
			 MAXLENGTH="4" type="text" class="blue100"
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Confidencial:</FONT></B></FONT></TD>
			<TD width="528">
			<%if(valida == 2)
			{%>		
				<INPUT type=checkbox  value="si"  disabled="disabled"
				<%if(strConf != null && strConf.trim().length()>0)
				 {%>
				 checked
				 <%} %>
				name="conf">
				<%if(strConf != null && strConf.trim().length()>0)
				 {%>
				<INPUT type="hidden" value="si" name="conf">
				<%} %>
			<%}else{%>		
				<INPUT type=checkbox  value="si"  
				<%if(strConf != null && strConf.trim().length()>0)
				 {%>
				 checked
				 <%} %>
				name="conf">
			<%}%>	
			</TD>
		</TR>		
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			Inactivo:</FONT></FONT></TD>
			<TD width="528">
				<INPUT type=checkbox onclick="habilita2()" value="3" 
						<%if(strInact == "3" || strInact.equals("3")) 
						{%>
						 checked
						<%
						}%>	
						<%if(ver!="si") {%>
						disabled="disabled"
						<%
						}%>
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>		
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>	
				name="inactivo">
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			Fecha Inactivo:</FONT></FONT></TD>
			<TD width="528">
				<INPUT name="fecinact" value="<%=strFecInac%>"
						onfocus="blur();"
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>	
					<%if(valida == 2) 
						{%>
						disabled="disabled"
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
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			Justificacion:</FONT></FONT></TD>
			<TD width="528">
				<TEXTAREA name="justif" id="justif" rows="3" cols="65" 
					onkeypress="limitaTextArea(document.clsfsub.justif,'Justificación','1000');"
					disabled="disabled"
					<%if(valida == 2) 
					{%>
					disabled="disabled"
					<%
					}%>
					
					<%if(ver!="si") {%>
					disabled="disabled"
					<%
					}%>	
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
		
						disabled="disabled"
					<%	}%>
					class="blue500"><%=strJustInac%></TEXTAREA>
			</TD>
		</TR>
		<%
		}%>													
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