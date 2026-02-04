<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
    import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<TITLE>Imprimir Instrucci&oacute;n Terminada</TITLE>

<SCRIPT language="JavaScript"> 

	function imprime(){

   		document.forma.imprimeBtn.style.display='none';
		self.window.print();
        self.close();
	}

</SCRIPT>
</HEAD>
<BODY onBlur="window.focus()" background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">

<%
	String strIdInstruccion		=	""; //Contiene el ID de la instrucción
	strIdInstruccion		=	(request.getParameter("idInstruccion") != null)?request.getParameter("idInstruccion"):"";
    String strDelegado =(request.getParameter("delegado")!=null)?request.getParameter("delegado"):"";
    
    boolean bHistorial=false;
    if(strIdInstruccion !=null)
    	bHistorial	=	ActualizaHistorial.TieneHistorial(strIdInstruccion);
    request.setAttribute("idInstruccion",strIdInstruccion);
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp = request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp+"?id_ins="+strIdInstruccion);
		}
		catch(java.io.IOException io){
			//System.out.println("E/RROR:"+io.getMessage());
		}
	}
	String [][]historialInstruccion=ActualizaHistorial.getHistorialInstruccion(strIdInstruccion);
	request.setAttribute("historial",historialInstruccion);
%>
<%

String strIdAsunto			=	""; //Contiene el ID del Asunto
	String strNombre			=	"";
	String strTelefono			=	"";
	String strCorreo			=	"";
	String strTipoAtencion		=	"";
	String strAcceso			=	"";
	String strAsunto			=	"";
	String strPaso				=	"";
	String strFecGeneracion		=	"";
	String strFecVencimiento	=	"";
	String strEstatus			=	"";
	String strTurnadoPor		=	"";
	String strFolioRecepcion	=	"";
	String strFolioTurnado		=	"";
	String strFolioIntermedio	=	"";
	String strInstruccion		=	"";
	String strInstruccionOtro	=	"";
	String strSintesis			=	"";
	String strAtencion			=	"";
	String strVerDocto			=	"";
	String strNombreInstruccion	=	"";
	String strAvance			=	"";
	String strMostrarHabilitado	=	"";
	String strUsuarioOriginal	=	"";
    String strFirmaDigital		= 	"";
    String strFechaTerminacionReal = "";

 %>



<%

    strMostrarHabilitado	=	request.getParameter("tur");
	
	if(strInstruccion != null)
	{
		String strDatosInstrucciones[][]	=	ActualizaInstrucciones.getInstruccionDatos(strIdInstruccion);
		
		strIdAsunto			=	ActualizaInstrucciones.getIdAsuntoInstruccion(strIdInstruccion);
		strNombre			=	strDatosInstrucciones[0][13];
		strTelefono			=	strDatosInstrucciones[0][14];
		strCorreo			=	strDatosInstrucciones[0][15];
		strTipoAtencion		=	strDatosInstrucciones[0][3];
		strAcceso			=	strDatosInstrucciones[0][4];
		strAsunto			=	strDatosInstrucciones[0][10];
		//strPaso				=	strDatosInstrucciones[0][17];
		strFecGeneracion	=	strDatosInstrucciones[0][7];
		strFecVencimiento	=	strDatosInstrucciones[0][8];
		strTurnadoPor		=	strDatosInstrucciones[0][12];
		strFolioRecepcion	=	strDatosInstrucciones[0][16];
		strFolioIntermedio	=	strDatosInstrucciones[0][17];
		strInstruccion		=	strDatosInstrucciones[0][1];
		strInstruccionOtro	=	strDatosInstrucciones[0][9];
		strSintesis			=	strDatosInstrucciones[0][11];
		strFolioTurnado		=	strDatosInstrucciones[0][18];
		strEstatus			=	strDatosInstrucciones[0][19];
		strAvance			=	strDatosInstrucciones[0][20];
		strDelegado			=	strDatosInstrucciones[0][21];
		strUsuarioOriginal	=	strDatosInstrucciones[0][0];
		strFirmaDigital		= 	strDatosInstrucciones[0][23];
        strFechaTerminacionReal = strDatosInstrucciones[0][24];
        
		request.setAttribute("delegado",strDelegado);
        
		
		////System.out.println("Avance="+strAvance);
		////System.out.println("DelegadoA="+strDelegado);
		
		if(strTipoAtencion.equals("0"))
			strAtencion = "Ejecutor";
		else
			strAtencion = "Informativo";
		
		if(strAcceso.equals("0"))
			strVerDocto = "No";
		else
			strVerDocto = "Si";
		
		//** Verifica si del query trae el ID de la instrucción
		//** ú otra Instrucción 
		if(strInstruccion.length() == 0)
			strNombreInstruccion = strInstruccionOtro;

		bHistorial	=	ActualizaHistorial.TieneHistorial(strIdInstruccion);
        request.setAttribute("existeHistorial",Boolean.valueOf(bHistorial));
		
	}











 %>



<FORM action="ImprimeInstruccionTerminada.jsp" name="forma">
<p align="left"><input type="button" onclick="imprime()" name="imprimeBtn" value="Imprimir"></p>
<div align="center">
<table border="0" cellspacing="0" cellpadding="0">

	<tr valign="top">
		<td width="21%">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="22%" align="right"><font size="2" color="#00204f"
			face="Verdana">Folio:&nbsp;</font></td>
		<td align="left" width="29%"><font size="2" color="#00204f"
			face="Verdana"><b><%=strFolioTurnado%></b></font></td>
	</tr>
	<tr valign="top">
		<td width="100%" bgcolor="#00204F" colspan="4"></td>
	</tr>
</table>
</div>
<DIV class=documentBody id=Body>
<div align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="21%">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"></td>
	</tr>
	<tr valign="top">
		<td width="21%"><font size="2" color="#004080" face="Arial">Nombre:</font>
		</td>
		<td colspan="3"><font size="2" face="Arial"><%=strNombre%></font></td>
	</tr>
	<tr valign="top">
		<td width="21%">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="21%"><font size="2" color="#004080" face="Arial">Teléfono:</font>
		</td>
		<td width="29%"><font size="2" face="Arial"><%=strTelefono %></font></td>
		<td width="18%"><font size="2" color="#004080" face="Arial">Correo
		Electrónico:</font></td>
		<td width="32%"><font size="2" face="Arial"><%=strCorreo%></font></td>
	</tr>
	<tr valign="top">
		<td width="21%"><img src="../Imagenes/shim.gif" width="1" height="1"
			title="">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="21%"><font size="2" color="#004080" face="Arial">Tipo de
		Atención:</font></td>
		<td width="29%"><font size="2" face="Arial"><%=strAtencion %></font>
		</td>
		<td width="18%"><font size="2" color="#004080" face="Arial">Acceso al
		Documento Original:&nbsp;</font></td>
		<td width="32%"><font size="2" face="Arial"><%=strAcceso%></font>
		</td>
	</tr>
	<tr valign="top">
		<td width="21%"><img src="../Imagenes/shim.gif" width="1" height="1"
			title="">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="21%"><font size="2" color="#004080" face="Arial">Asunto:</font>
		</td>
		<td colspan="3"><font size="2" face="Arial"><%=strAsunto%></font></td>
	</tr>
	<tr valign="top">
		<td width="21%">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="21%"><font size="2" color="#004080" face="Arial">Paso:</font>
		</td>
		<td colspan="3"><font size="2" face="Arial"><%=strPaso%></font></td>
	</tr>
	<tr valign="top">
		<td width="21%">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="21%"><font size="2" color="#004080" face="Arial">Fecha de
		Generación:</font></td>
		<td width="29%"><font size="2" face="Arial"><%=strFecGeneracion%></font>
		</td>
		<td><font size="2" color="#004080" face="Arial">Fecha Vencimiento:</font>
		</td>
		<td width="32%"><font size="2" face="Arial"><%=strFecVencimiento%></font>
		</td>
	</tr>
	<tr valign="top">
		<td width="21%">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="21%"><font size="2" color="#004080" face="Arial">Estatus:</font>
		</td>
		<td width="29%"><font size="2" face="Arial">Notificado</font></td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="21%">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td colspan="2"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="21%">
			<font size="2" color="#004080" face="Arial">Delegado a:</font>
		</td>
		
		<td colspan="3">
			<font size="2" face="Arial">
			 <%=strDelegado %> 
			</font>
		</td>
		
		<td colspan="3"></td>
		
	</tr>
	<tr valign="top">
		<td width="21%">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="21%"><font size="2" color="#004080" face="Arial">Asignada
		por: </font></td>
		<td width="29%"><font size="2" face="Arial"><%=strTurnadoPor%></font>
		</td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td colspan="4"><img src="../Imagenes/shim.gif" width="1" height="1"
			title="">&nbsp;</td>
	</tr>
	<tr valign="top">
		<td width="21%"><font size="2" color="#004080" face="Arial">Folio de
		Recepción:</font> <font size="2" face="Arial"> </font></td>
		<td colspan="3"><font size="2" face="Arial">
         <%=strFolioRecepcion%></font>
		</td>
	</tr>
	<tr valign="top">
		<td colspan="4"><img src="../Imagenes/shim.gif" width="1" height="1"
			title="">&nbsp;</td>
	</tr>
	<tr valign="top">
		<td width="21%"><font size="2" color="#004080" face="Arial">Folio
		Intermedio:</font></td>
		<td width="29%"><font size="2" face="Arial">
        
           </font><%=strFolioIntermedio%>
		</td>
		<td width="18%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="32%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td colspan="4"><img src="../Imagenes/shim.gif" width="1" height="1"
			title="">&nbsp;</td>
	</tr>
</table>
</div>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="21%"><b><font size="2" color="#004080" face="Arial">INSTRUCCION</font></b>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="21%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="150%" bgcolor="#00204F" colspan="4"></td>
	</tr>
	<tr valign="top">
		<td width="21%"><img src="../Imagenes/shim.gif" width="1" height="1"
			title="">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="21%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="100%" colspan="4"><font size="2" face="Arial"><%=strNombreInstruccion%></font></td>

	</tr>
	<tr valign="top">
		<td width="21%"><img src="../Imagenes/shim.gif" width="1" height="1"
			title="">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="21%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
</table>
</DIV>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="21%"><b><font size="2" color="#004080" face="Arial">SINTESIS</font></b>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="21%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	<tr valign="top">
		<td width="100%" colspan="4"><font size="2" face="Arial"><%=strSintesis%></font></td>
	</tr>
	<tr valign="top">
		<td width="21%"><img src="../Imagenes/shim.gif" width="1" height="1"
			title="">&nbsp;</td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="21%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="29%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="100%" bgcolor="#00204F" colspan="4"></td>
	</tr>
</table>
</DIV>
<br>
<br>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0">
	<tr valign="top">
		<td width="64%" colspan="2"><b><font size="2" color="#004080"
			face="Arial">Historia de la Instrucción</font></b>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td width="21%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="14%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</tr>
	<tr valign="top">
		<td width="100%" bgcolor="#00204F" colspan="4"></td>
	</tr>
	<tr valign="top">
		<td width="100%" colspan="4">&nbsp;</td>
	</tr>
	<tr valign="top">
		<% if(bHistorial){ %>
		<td width="100%" colspan="4">
		<font size="1" color="#004080" face="Arial">
			<meve_front:ListaDatos datos="<%=historialInstruccion%>" campo="campo">
				<% if(campo7.equals("1")){ %>
				<%= campo3 %>----><br><%String avanceUsuario=ActualizaUsuario.NombreUsuario(campo4);%>
				Avance del Usuario: <%=avanceUsuario%>/meve<br>
				<a href="Responder.jsp?id_his=<%= campo1 %>">
					<font size="1" color="#004080" face="Arial">
						<U>Avance de: <%= campo5 %>%</U><input type="hidden" name="avanceDeHdn" value="<%=campo5%>">
					</font>
				</a><br>
				Comentarios Adicionales: <%= campo6 %><br><br>
				<% }else if(campo7.equals("2")){ %>
				<%= campo3 %>----><br>
				Documento Rechazado por: <%= ActualizaUsuario.NombreUsuario(campo4) %>/meve<br>
				Razon de Rechazo: <%= campo6 %><br><br>
				<% }else if(campo7.equals("3")){ %>
				<%= campo3 %>----><br>
				Documento Resignado a: <%= ActualizaInstrucciones.NombreUsuarioInstruccion(strIdInstruccion) %>
				por el Usuario: <%= ActualizaUsuario.NombreUsuario(campo4) %>/meve<br>
				Comentarios Adicionales: <%= campo6 %><br><br>
				<% }else if(campo7.equals("4")){ %>
				<%= campo3 %>----><br>
				Documento Delegado a : <%=ActualizaUsuario.NombreUsuario(strDelegado)%><br>
				Comentarios Adicionales: <%= campo6 %><br><br>
				<% } %>
					
			</meve_front:ListaDatos>
		</font>
		</td>
		<% }else{ %>
		<td width="100%" colspan="4">&nbsp;</td>
		<% } %>
	</tr>
	<tr valign="top">
		<td width="100%" colspan="4">&nbsp;</td>
	</tr>
	<tr valign="top">
		<td width="100%" bgcolor="#00204F" colspan="4"></td>
	</tr>
	<% 
     boolean firmado=strFirmaDigital.equals("1");

	if(firmado){%>
  
        <tr valign="top" id="hileraFirmaId" style="display:none">        
		<td width="64%" colspan="2"><b><font size="2" color="#004080"
		face="Arial">Firmado</font></b>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td width="21%"><img src="../Imagenes/ecblank.gif" border="0"
		height="1" width="1" title=""></td>
		<td width="14%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1\" width="1" title=""></td>
		</tr>
 
        <tr valign="top">
		<td width="100%" bgcolor="#00204F" colspan="4"></td>
		</tr>
        <tr valign="top">
         <td align="center">
         <b>Usuario</b>
         </td>
		 <td align="center">
         <b>Fecha</b>
		</td>
		<TD align="center">		
		</TD>
        </tr>
        <tr valign="top">
         <td align="center">
			
		</td>
        </tr>
        <tr valign="top">
        <td align="center">
         <%=strNombre%> 
		</td>
        <td align="center">
         <%=strFechaTerminacionReal%>
        </td>
        <td align="center">
        <IMG src="../Imagenes/0.jpg" title="firmado" width="30" height="30">
        </td>
        </tr>
	<%
 }    
%>
</table>
</DIV>
</DIV>
</FORM>


</BODY>
</HTML>
