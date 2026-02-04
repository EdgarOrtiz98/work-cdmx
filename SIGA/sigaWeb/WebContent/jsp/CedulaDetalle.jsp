<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
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
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERUsuarioInvalido.jsp"></jsp:forward>
<% } %>
<%
	String strTipo	=	(request.getParameter("cls")!= null)?request.getParameter("cls"):"0";
	String valor	=	(request.getParameter("valor")!= null)?request.getParameter("valor"):"";
	String anio	=	(request.getParameter("anio")!= null)?request.getParameter("anio"):"";
	String consec = "0";
	String name = "";
	String datoExp = "";
	String sisi = "";
	String ac ="";
	String at ="";
	String reserva ="";
	String val ="";
	String datoExpP = "";
	String datoExpF = "";
	String datoExpSec = "";
	String datoExpSr = "";
	String datoExpSubSr = "";
	String datoExpUA = "";
	String datoExpCT = "";
	String voice = "";
	String funda = "";
	String moti = "";



	
	String strDatos[][] = ActualizaExpArchivado.getExpedienteConsec(strTipo,anio);
	if (strDatos.length >0)
		consec		=	strDatos[0][0];
		
		
		
	String strDatosExp[][] = ActualizaExpArchivado.getDatosCedulaClave(strTipo);
	if (strDatosExp.length >0)
	{
	datoExpP =		strDatosExp[0][0];
	datoExpF =		strDatosExp[0][1];
	datoExpSec =	strDatosExp[0][2];
	datoExpSr =		strDatosExp[0][3];
	datoExpSubSr =	strDatosExp[0][4];
	datoExpUA =		strDatosExp[0][5];
	datoExpCT =		strDatosExp[0][6];
	name =			strDatosExp[0][7];
	sisi =			strDatosExp[0][8]; 
	at =			strDatosExp[0][9]; 
	ac =			strDatosExp[0][10]; 
	reserva =  		strDatosExp[0][11]; 
	funda 	=   	strDatosExp[0][12];
	moti 	=   	strDatosExp[0][13];
	
			if(Integer.parseInt(datoExpSr) > 0)
			{
				datoExp = datoExpSubSr+"."+datoExpSr+"."+datoExpSec+"."+datoExpF+"."+ datoExpP+"-"+datoExpUA;
			}else
			{
				datoExp = datoExpSubSr+"."+datoExpSec+"."+datoExpF+"."+ datoExpP+"-"+datoExpUA;
			}
	}else
	{
	
	String strDatosExp2[][] = ActualizaExpArchivado.getDatosCedulaClave2(strTipo);
		if (strDatosExp2.length >0)
		{
			datoExpF =		strDatosExp2[0][0];
			datoExpSec =	strDatosExp2[0][1];
			datoExpSr =		strDatosExp2[0][2];
			datoExpSubSr =	strDatosExp2[0][3];
			datoExpUA =		strDatosExp2[0][4];
			datoExpCT =		strDatosExp2[0][5];
			name 	=		strDatosExp2[0][6];
			sisi 	=		strDatosExp2[0][7]; 
			at 		=		strDatosExp2[0][8]; 
			ac 		=		strDatosExp2[0][9]; 			
			reserva =   	strDatosExp2[0][10];
			funda 	=   	strDatosExp2[0][11];
			moti 	=   	strDatosExp2[0][12];
			
			if(Integer.parseInt(datoExpSr) > 0)
			{
				datoExp = datoExpSubSr+"."+datoExpSr+"."+datoExpSec+"."+datoExpF+".00-"+datoExpUA;
			}else
			{
				datoExp = datoExpSubSr+"."+datoExpSec+"."+datoExpF+".00-"+datoExpUA;
			}
			
			
		}
	}
	//datoExp = datoExpP+datoExpF+"."+datoExpSec+"."+datoExpSr+"."+datoExpSubSr+"."+datoExpUA;


%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/link.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript" src="../js/link.js"></script>
<TITLE>Detalle de Clasificacion</TITLE>
</HEAD>
<SCRIPT language="JavaScript" type="text/javascript">

function llenando(cstivo)		
	{
	var a =  String(cstivo);
	num = a.length;
	var af = "";
	if(num < 6)
		{
			for (i=num; i<6; i++){
				af = af + "0";
			}
		}
	parent.window.document.getElementById('consec').value = af+a;
	}

function Consec(con) { 
    consec= parseInt(con);
    consec2 = consec +1;

	llenando(consec2);

	name = "<%=name%>";
	valor = "<%=valor%>";
	sisi =  "<%=sisi%>";
	ac =  "<%=ac%>";
	at =  "<%=at%>";
	reserva =  "<%=reserva%>";
	funda =  "<%=funda%>";
	moti =  "<%=moti%>";
	
	 if  (name.length > 0 && valor.length > 0)
		{
			parent.window.document.getElementById('denom').value = name;
			parent.window.document.getElementById('fundamento').value = funda;
			parent.window.document.getElementById('motivo').value = moti;
		}
		
	 if  (sisi.length > 0 && sisi.length > 0)
		parent.window.document.getElementById('sisi').value = sisi;		
		
	 if  (ac.length > 0)
		parent.window.document.getElementById('ano_AC').value = ac;			
	
	 if  (at.length > 0)
		parent.window.document.getElementById('ano_AT').value = at;
	
	 if	(parseInt(at) == 99)
		{
			parent.window.indefinido();
		}else
		{
			parent.window.sum();
		}

	 if  (reserva.length > 0)
		parent.window.document.getElementById('anioresv').value = reserva;		
		
	parent.window.real();
	}
function Cvexp() { 
	setdato = "<%=datoExp%>";
	parent.window.document.getElementById('clvExpdic').value = "<%=datoExp%>";
	parent.window.document.getElementById('ct').value = "<%=datoExpCT%>";
	if(setdato.length > 0)
	parent.window.asignavalor();
	parent.window.anio2();
	}
	
function vale()
	{
	sisi =  "<%=sisi%>";
	if  (sisi.length > 0 && sisi.length > 0)
		parent.window.document.getElementById('sisi').value = sisi;

	}
	
</SCRIPT>
<BODY background="../Imagenes/fondo_claro.jpg"
	<%if (valor == "pasa" || valor.equalsIgnoreCase("pasa")){
	%>
	 onload="Consec(<%=consec%>);Cvexp();"
 	<%}else
 	{%>
 	onload="vale();"
 	<%}%>
 >
<FORM name="CedulaDetalle" action="CedulaDetalle.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<input name="tmpCopyToRef" type="hidden" value="">
<input name="idsCC" type="hidden" value="">
<DIV align="center">
<TABLE width="100%" border="0">
<TBODY>
 <TR bgcolor="#00204f">
		<TD width="10%" align="center" colspan="5">
		<FONT size="2" color="white" face="verdana">DETALLE CEDULA</FONT>
		</TD>
 </TR>
	<TR bgcolor="#00204f">
        <TD width="20%" align="center">
			<b><FONT size="2" color="white" face="verdana">Fondo</FONT></b>
        </TD>
        <TD width="20%" align="center">
			<b><FONT size="2" color="white" face="verdana">Subfondo</FONT></b>
        </TD>
        <TD width="20%" align="center">
			<b><FONT size="2" color="white" face="verdana">Seccion</FONT></b>
        </TD>                
        <TD width="20%" align="center">
			<b><FONT size="2" color="white" face="verdana">Serie</FONT></b>
        </TD>
        <TD width="20%" align="center">
			<b><FONT size="2" color="white" face="verdana">Subserie</FONT></b>
        </TD>
    </TR>
	<meve_front:ListaDatos datos="<%= ActualizaExpArchivado.getDatosCedulaDeta(strTipo) %>" campo="campo">
	<TR vAlign=top>
		<TD width="20%">
    		<FONT face=Arial color=#000080 size=1>
    		<A class ="etiquetas" title= "<%=campo10 %>"><B><U><%=campo5%></U></B></A>
    		</FONT>
	   	</TD> 
	   	<TD width="20%">
    		<FONT face=Arial color=#000080 size=1>
    		<A class ="etiquetas" title= "<%=campo9 %>"><B><U><%=campo4%></U></B></A>
	   		</FONT>
	   	</TD> 
		<TD width="20%">
    		<FONT face=Arial color=#000080 size=1>
    		<A class ="etiquetas" title= "<%=campo8 %>"><B><U><%=campo3%></U></B></A>
    		</FONT>
	   	</TD> 
		<TD width="20%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<A class ="etiquetas" title= "<%=campo7 %>"><B><U><%=campo2%></U></B></A>
			</FONT>
		</TD>
		<TD width="20%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<A class ="etiquetas" title= "<%=campo6 %>"><B><U><%=campo1%></U></B></A>
			</FONT>
		</TD>
	</TR>
	</meve_front:ListaDatos>
	<TR vAlign=top>	
	<TD COLSPAN="5" align="center">
	<input type="button"
				onclick="parent.window.document.getElementById('pop10').style.visibility='hidden';"
				value=" Cancel" class="blue100">
	</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>
