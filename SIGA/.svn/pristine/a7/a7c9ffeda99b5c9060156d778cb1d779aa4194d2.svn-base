<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.util.*"
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
	String strIdUsuario = "";
	boolean bExiste 	= false;
	String strNombre = "";
	String stBit[][] = null;

	String retURI 	= 	(request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
	strIdUsuario 	= 	(request.getParameter("id_usuario")==null)?"":request.getParameter("id_usuario");
	bExiste			=	ActualizaBitacora.getExisteBitacoraUsr(strIdUsuario);

	String strOrden 	= (request.getParameter("orden")!=null)?request.getParameter("orden"):"desc";
	String strTipo 		= (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"4";
	String strAccion 	= (request.getParameter("accion")!=null)?request.getParameter("accion"):"";
	String strFechaIni 	= (request.getParameter("fechaInicial")!=null)?request.getParameter("fechaInicial"):"";
	String strFechaFin 	= (request.getParameter("fechaFinal")!=null)?request.getParameter("fechaFinal"):"";
	String strDetalleEvento	= (request.getParameter("buscaEvento")!=null)?request.getParameter("buscaEvento"):"";
	
	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");

	int regPorPagina = 30;
	int muestraPaginas = 20;
	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
	if(strConfig != null && strConfig.length > 0){
		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
	}

//	if(bExiste){
//		stBit = ActualizaBitacora.getBitacoraUsuarioNombre(strIdUsuario);
//		strNombre = ActualizaUsuario.NombreUsuario(stBit[0][0]);
//	}
	strNombre = ActualizaUsuario.NombreUsuario(strIdUsuario);
	if (strNombre==null){
		response.sendRedirect("UsuariosView.jsp");
	}

%>
<%!
	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Bitácora</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>

function regresarBit(){
	doc=document.bitacora1;
	location.assign("<%=retURI %>");
}

function cambio(o, t){
	doc = document.bitacora1;
	doc.orden.value=o;
	doc.tipo.value=t;
	doc.submit();
}

function pagina(contador){
	doc = document.bitacora1;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.bitacora1;
	doc.contligas.value=contador;
	doc.submit();
}

function verBuscar(){
	doc = document.bitacora1;	
	doc.accion.value="buscar";
	doc.submit();
}

function cancelar(){
	doc = document.bitacora1;	
	doc.accion.value="";
	doc.submit();
}

function verTodosRegistros(){
	doc = document.bitacora1;
	doc.accion.value="";
	doc.fechaInicial.value = "";
	doc.fechaFinal.value = "";
	doc.buscaEvento.value = "";
	pagina(0);
	paginaLiga(0);
	doc.submit();
}

function borrarCampos(){
	doc = document.bitacora1;
	doc.fechaDe.value="";
	doc.fechaA.value="";
	doc.detalle.value="";
}

function buscarRegistros(){
	doc = document.bitacora1;
	valida = 0;
	msg="";
	
	doc.detalle.value = Trim(doc.detalle.value);
	
	/*if (Trim(doc.fechaDe.value) =="") {
		valida =1;
		msg = msg + "Debe capturar la Fecha Inicial "+ "\n";
	}
	if (Trim(doc.fechaA.value) =="") {
		valida =1;
		msg = msg + "Debe capturar la Fecha Final "+ "\n";
	}*/
	if (comparaFechas(doc.fechaDe.value,getfechaActual())==1) {
		valida =1;
		msg = msg + "La Fecha Inicial debe ser menor o igual a la actual"+ "\n";
	}
	if (comparaFechas(doc.fechaA.value,getfechaActual())==1) {
		valida =1;
		msg = msg + "La Fecha Final debe ser menor o igual a la actual"+ "\n";
	}
	if (valida!=1 && Trim(doc.fechaDe.value)!="" && Trim(doc.fechaA.value)!="" && comparaFechas(doc.fechaDe.value,doc.fechaA.value)==1) {
		valida =1;
		msg = msg + "La Fecha Inicial debe ser menor o igual a la Fecha Final "+ "\n";
	}
	if (detectaCEBusquedaB(doc.detalle.value)){
		valida = 1;
		msg = msg + "No son permitidos los caracteres ( ' & < >  ` ´  ) "+ "\n";
	}	
	if( doc.detalle.value == '"'){
		valida = 1;
		msg = msg + "No esta permitido colocar solo una comilla " + "\n";
	}
	if (valida == 1){
		alert(msg);
	}
	else{
		doc.accion.value = "";
		doc.fechaInicial.value = doc.fechaDe.value;
		doc.fechaFinal.value = doc.fechaA.value;
		doc.buscaEvento.value = doc.detalle.value;
		pagina(0);
		paginaLiga(0);
		doc.submit();
	}
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
<FORM action="Bitacora.jsp" name="bitacora1" method="post">
<INPUT type="hidden" name="orden" value="<%=strOrden %>">
<INPUT type="hidden" name="tipo" value="<%=strTipo %>">
<INPUT type="hidden" value="<%=retURI %>" name="retURI">
<INPUT type="hidden" value="<%=strIdUsuario %>" name="id_usuario">
<INPUT type="hidden" value="<%=contPag %>" name="contPag">
<INPUT type="hidden" value="<%=contligas %>" name="contligas">
<INPUT type="hidden" value="<%=strAccion %>" name="accion">
<INPUT type="hidden" value="<%=strFechaIni %>" name="fechaInicial">
<INPUT type="hidden" value="<%=strFechaFin %>" name="fechaFinal">
<INPUT type="hidden" value="<%=strDetalleEvento %>" name="buscaEvento">
<DIV align="center">
<table border="0" width="874">
	<TBODY>
		<TR>
			<TD width="50%">
			<%	if (bExiste && strAccion.equals("buscar")){ %>
				<INPUT type="button" class="blue100" value="Cancelar" onclick="cancelar()">
				<INPUT type="button" class="blue100" value="Borrar" onclick="borrarCampos()">
			<%	} %>
			<%	if (!strAccion.equals("buscar")){ %>
				<INPUT type="button" class="blue100" value="Regresar" onclick="regresarBit()">
			<%	} %>
			<%	if (bExiste && !strAccion.equals("buscar") && (!strFechaIni.equals("") || !strFechaFin.equals("") || !strDetalleEvento.equals(""))){ %>
				<INPUT type="button" class="blue100" value="Ver Todo" onclick="verTodosRegistros();">
			<%	} %>
			<%	if (bExiste && !strAccion.equals("buscar")){ %>
				<INPUT type="button" class="blue100" value="Buscar" onclick="verBuscar();">
			<%	} %>
			</TD>
			<TD width="50%" align="right">
			<%	if (bExiste && !strFechaIni.equals("") && !strFechaFin.equals("") && !strAccion.equals("buscar")){ %>
				&nbsp;&nbsp;<B> Resultados del <%= strFechaIni %> al <%= strFechaFin %> </B>
			<% }%>
			</TD>
		</TR>
	</TBODY>
</table>
<br>
<table border="0" width="874">
	<TBODY>
		<TR>
			<TD width="75%"><b><FONT face="Verdana" size="2" color="#004080">
			Bitacora de Acceso del Usuario: <%=strNombre%> </FONT></b>
			</TD>
			<TD width="25%" align="right">
			<% 
			if(bExiste && !strAccion.equals("buscar")){
				String strBitacoraDatos[][] = ActualizaBitacora.getBitacoraUsuario(strIdUsuario,strOrden,strTipo,strFechaIni,strFechaFin,strDetalleEvento);	

				int numeroPaginas = strBitacoraDatos.length/regPorPagina;	
				if (strBitacoraDatos.length%regPorPagina != 0)
					numeroPaginas++; %>
			<%	if (strBitacoraDatos.length > 0){	%>
					<%= strBitacoraDatos.length %> registros mostrados.
			<%	} %>
			<%	if (numeroPaginas > 1){	%>
					Pagina <%= contPag+1 %> de <%= numeroPaginas %>
			<% 	} %>
			<%} %>
			</TD>
		</TR>
	</TBODY>
</table>
</DIV>
<DIV align="center">
<table border="0" width="874">
	<TBODY>
	<% 	if (!strAccion.equals("buscar")) {%>
		<TR bgcolor="#004080">
			<TD width="75%" align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Evento</FONT></b>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD width="25%" align="center">
			<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Fecha del Evento</FONT></b>
			<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
		</TR>
	<% 	} else { %>
		<TR bgcolor="#004080">
			<TD width="75%" align="center" colspan="2">
			<b><FONT size="2" color="white" face="verdana">Buscar por Fecha</FONT></b>
			</TD>
		</TR>
	</TBODY>
</table>
<table border="0" width="874">
	<TBODY>
		<TR>
			<TD width="25%" colspan="2" align="left">
				<BR>
				<A onclick="buscarRegistros()" title="Buscar Evento">
				<FONT SIZE=2 FACE="Verdana" color="#004080"><B>Buscar Evento</B></FONT>				
				<IMG border="0" src="../Imagenes/ico_bus.gif" width="26" height="26"></A>
				<BR>
			</TD>
		</TR>
		<TR>
			<TD colspan="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD width="25%">
				<FONT SIZE=2 FACE="Verdana" color="#004080"><B>Fecha Inicial: &nbsp;</B></FONT>
			</TD>
			<TD width="75%">
				<INPUT class="blue100"  name="fechaDe" onfocus="blur();" value="<%= strFechaIni %>">
				<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" 
					onclick='show_calendar("forms[0].fechaDe");'></A> 
				<BR>
			</TD>
		</TR>
		<TR>
			<TD colspan="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD width="25%">
				<FONT SIZE=2 FACE="Verdana" color="#004080"><B>Fecha Final: &nbsp;</B></FONT>
			</TD>
			<TD width="75%">
				<INPUT class="blue100"  name="fechaA" onfocus="blur();" value="<%= strFechaFin %>">
				<A><IMG height="20" title="" src="../Imagenes/act_calFormat.gif" width="20" border="0" 
					onclick='show_calendar("forms[0].fechaA");'></A>
				<BR>
			</TD>
		</TR>
		<TR>
			<TD colspan="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD width="25%">
				<FONT SIZE=2 FACE="Verdana" color="#004080"><B>Detalle del Evento:&nbsp;</B></FONT>
			</TD>
			<TD width="75%">
				<INPUT class="blue500" name="detalle" value="<%= strDetalleEvento %>">
			</TD>
		</TR>
	<% 	} %>
	</TBODY>
</table>
</DIV>
<BR>
<DIV class=documentBody id=Body>
<DIV align="center">
<table border="0" width="874" cellpadding="0">
	<TBODY>
		<% 
		if(bExiste && !strAccion.equals("buscar")){

		String strBitacoraDatos[][] = ActualizaBitacora.getBitacoraUsuario(strIdUsuario,strOrden,strTipo,strFechaIni,strFechaFin,strDetalleEvento);
		int numeroPaginas = strBitacoraDatos.length/regPorPagina;
		if (strBitacoraDatos.length%regPorPagina != 0)
			numeroPaginas++; 

		if (numeroPaginas == 0){%>
		<TR>
			<TD width="100%" colspan="2" align="center"><FONT size="2" color="red" face="verdana"> 
			<BR>
			<BR>
			**** No hay registros en la bitacora para esta consulta **** 
			</FONT></TD>
		</TR>
		<% }
		for(int i=contPag*regPorPagina; i<strBitacoraDatos.length && i<(contPag+1)*regPorPagina; i++){ %>
		<% int a = i+1; %>
		<TR <%if(par(a)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
			<TD width="5%"><FONT size="1" color="#00204f" face="verdana">  <%=i+1%>.- </FONT></TD>
			<TD width="70%"><FONT size="1" color="#00204f" face="verdana"> <%=strBitacoraDatos[i][1]%> </FONT></TD>
			<TD align="center" width="25%"><FONT size="1" color="#00204f" face="verdana"> <%=strBitacoraDatos[i][2]%> </FONT></TD>
		</TR>
		<% } %>
		<TR>
			<TD colspan="3" align="center"><BR>
			<%
				if (contligas>0 && numeroPaginas > muestraPaginas){  %>
					<A onclick="paginaLiga(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);pagina(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;
			<%	}
				if (contPag > 0){  
					if (contPag > contligas){%>
						<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
				<%	}else{%>
						<A onclick="paginaLiga(<%=contligas-1%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
				<%	} 
				}
				if (numeroPaginas > 1){
					for (int i=contligas; i<muestraPaginas+contligas && i<numeroPaginas; i++){ 
						if (i==contPag){  %>
							<A onclick="pagina(<%=i%>)"><FONT color="red"><B>[<%=i+1%>]</B></FONT></A> &nbsp;
				<%		}else{ %>
							<A onclick="pagina(<%=i%>)"><%=i+1%></A> &nbsp;
				<%		}
					}
				} 
				if (contPag < numeroPaginas-1){  
					if (contPag < contligas + muestraPaginas-1){%>
						<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
				<%	}else{%>
						<A onclick="paginaLiga(<%=contligas+1%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
				<%	} 
				}
				if (contligas+muestraPaginas<numeroPaginas && numeroPaginas > muestraPaginas){  %>
					<A onclick="paginaLiga(<%= contligas+muestraPaginas %>);pagina(<%= contligas+muestraPaginas %>);"> <B> | Siguiente&gt;&gt;</B> </A>
			<%	
				} %>
			</TD>
		</TR>
		<% }else if(!strAccion.equals("buscar")){ %>
		<TR>
			<TD width="100%" colspan="2" align="center"><FONT size="2" color="red" face="verdana"> 
			<BR>
			<BR>
			**** El Usuario &quot;<%=strNombre%>&quot; no tiene registros en la Bitacora **** 
			</FONT></TD>
		</TR>
		<% } %>
	</TBODY>
</table>
</DIV>
<br>
</DIV>
<BR>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
