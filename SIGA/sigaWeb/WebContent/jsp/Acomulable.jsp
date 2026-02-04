<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page import="com.meve.sigma.taglib.*,com.meve.sigma.actualiza.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*"
%> 
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());

%>
<%
	String strAccion =	"";
	String strVal = "";
	String strAreaUs = BUsuario.getIdArea();
	String strIdExpediente	=	"";
	String strReal	 =	"";
	String strTotcls =	"";
	String strAcom	 =	"";
	String strTotGur =	"";
	String stracom	 =  "";
	String stropera	 =  "";
	int valida	 =  0;
	String strsoloDesc 	=	request.getParameter("soloDesc");
	String strInstruccion = (request.getParameter("ida")!= null)?request.getParameter("ida"):"";
	strAreaUs	=	BUsuario.getIdArea();
	String strTipo	=	(request.getParameter("cls")!= null)?request.getParameter("cls"):"0";


	
	strAccion	=	request.getParameter("accion");
	

	
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
		strIdExpediente = request.getParameter("ida");
		strReal = request.getParameter("real");
		strTotcls = request.getParameter("totalcls");
		strAcom = request.getParameter("acomuguard");
		strTotGur = request.getParameter("totalGuar");
		stracom = request.getParameter("anioacom"); 
		stropera = request.getParameter("operacion");
		ActualizaExpArchivado.actualizaExpedienteAcom(strReal,strTotcls,strAcom,strTotGur,
														strIdExpediente,BUsuario.getIdArea(),stracom,stropera);
		}
	}
	
	String var[][] =	ActualizaExpArchivado.getDatosExpAcom(strInstruccion);
	if (var.length >0) 
		{
			strVal = var[0][0];
		}
	else 
		{
		strVal = "0";
		}
	
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
<TITLE>Acomulable.jsp</TITLE>
</HEAD>
<SCRIPT language="JavaScript" type="text/javascript">
function Consec(con) { 

	}
function Aplicar(){ 

		if(document.acomulableForm.anioacom.value == "")
		{
		alert("Es necesario introducir un valor");
		return false;
		}
		 valor1 = document.acomulableForm.anioacom.value;
		 valor2 = document.acomulableForm.acomu.value;
		 verif = parent.window.document.getElementById('anioreal').value;
		
		if(document.acomulableForm.operarc[0].checked)
			{
			document.acomulableForm.operacion.value = "Ampliacion";
			valor3 = parseInt(valor1) + parseInt(valor2);
			}
		if(document.acomulableForm.operarc[1].checked)
			{
			document.acomulableForm.operacion.value = "Reduccion";
			valor3 = parseInt(valor2) - parseInt(valor1);
				if(parseInt(valor1)>verif)
				{
				 alert("No se puede reducir mas años a los asignados")
				 document.acomulableForm.anioacom.value ="";
				 return false;
				}
			}
		parent.window.document.getElementById('ano_Amp').value = valor3;
		parent.window.real();
		
		document.acomulableForm.real.value = parent.window.document.getElementById('anioreal').value;
		document.acomulableForm.totalcls.value = parent.window.document.getElementById('totalcls').value;
		document.acomulableForm.totalGuar.value = parent.window.document.getElementById('ano_guard').value;
		document.acomulableForm.acomuguard.value = valor3;
		document.acomulableForm.accion.value="guardar";
		document.acomulableForm.submit();
		}
		
	function windowDetalle()
	 	{
	 		window.open('AniosDetalle.jsp?valor=<%=strInstruccion%>','window','width=420,height=250');
	 		window.focus;
 	}		
</SCRIPT>
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM name="acomulableForm" action="Acomulable.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<input name="tmpCopyToRef" type="hidden" value="">
<input name="idsCC" type="hidden" value="">
<input name="ida" type="hidden" value="<%=strInstruccion%>">
<input name="real" type="hidden" value="">
<input name="totalcls" type="hidden" value="">
<input name="totalGuar" type="hidden" value="">
<input name="operacion" type="hidden" value="">
<input name="acomu" type="hidden" value="<%=strVal%>">
<input name="acomuguard" type="hidden" value="">
<DIV align="center">
<TABLE width="100%" border="0">
<TBODY>
	<TR valign="top">
		<TD width="150">
			<INPUT TYPE=RADIO NAME="operarc" checked="checked" 
			<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
			VALUE="sum"><FONT face="Arial" color="#004080" size="2">Ampliar</FONT><BR>
			<INPUT TYPE=RADIO NAME="operarc" 
			<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
			VALUE="res"><FONT face="Arial" color="#004080" size="2">Reducir</FONT>
		</TD>
		<TD>
			<FONT face="Arial" size="2">
			<INPUT name="anioacom" id="anioacom" value="" type="text" 
			<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
			class="blue100">
			</FONT> 
			<INPUT type="button" style="width:65;height:20;font: bold 12px Arial" onclick="Aplicar('');"
				<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
			  value="Aplicar">
		</TD>
	</TR>
	<TR valign="top">
		<TD width="150">
			<FONT face="Arial" color="#004080" size="2">Acomulado:</FONT>
		</TD>
		<TD>
		<FONT face="Arial" color="#004080" size="2"><B><%=strVal%></B></FONT>&nbsp;&nbsp;<A href="#" onclick="windowDetalle()"><FONT color="Blue" size="1">Detalle</FONT></A>
		</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>

