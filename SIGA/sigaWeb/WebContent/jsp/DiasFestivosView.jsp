<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Días Festivos</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.util.*"%>
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
	boolean bOperacion = false;
	String strIds_Borrar[] = null;
	String strAccion = "";
	int t = 0;
	strAccion = request.getParameter("accion"); 
	strIds_Borrar = request.getParameterValues("Borrar");
	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
		bOperacion = ActualizaDiaFestivo.deleteDiaFestivo(strIds_Borrar,BUsuario.getIdUsuario());
	}
	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";

	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");

	int regPorPagina = 20;
	int muestraPaginas = 20;
	String[][] strConfig = ActualizaConfiguracion.getDatosConf();
	if(strConfig != null && strConfig.length > 0){
		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
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
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">   
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT language="JavaScript" src="../js/GeneralFunctions.js"></SCRIPT>
<script language="JavaScript" type="text/javascript">
	function cambio(o, t){
		doc = document.DiasFestivosView;
		doc.accion.value="reload";
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
function pagina(contador){
	doc = document.DiasFestivosView;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.DiasFestivosView;
	doc.contligas.value=contador;
	doc.submit();
}

</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="DiasFestivosView.jsp" name="DiasFestivosView" method="get">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="orden" value="<%= strOrden %>">
<INPUT type="hidden" name="tipo" value="<%= strTipo %>">
<INPUT type="hidden" value="<%= contPag %>" name="contPag">
<INPUT type="hidden" value="<%= contligas %>" name="contligas">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR>
			<TD width="40%"><A href="DiasFestivos.jsp?retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" target="_self"> <IMG
				height="26" src="../Imagenes/nuevo1.gif" width="27" border="0"
				title="Nuevo Día Festivo"> </A> <FONT face="Tahoma" size="2"></FONT> <A
				href="javascript:Borrar()" target="_self"><IMG border="0"
				src="../Imagenes/borrar1.gif" width="30" height="27"
				title="Borrar Día Festivo"></A></TD>
			<TD width="50%">
			<DIV align="right">
				<% 
				if (ActualizaDiaFestivo.getListaDiasFestivos(strOrden, strTipo)!=null && ActualizaDiaFestivo.getListaDiasFestivos(strOrden, strTipo).length > 0){
					String strDatos[][] = ActualizaDiaFestivo.getListaDiasFestivos(strOrden, strTipo);		

					int numeroPaginas = strDatos.length/regPorPagina;	
					if (strDatos.length%regPorPagina != 0)
						numeroPaginas++; %>
				<%	if (strDatos.length > 0){	%>
						<%= strDatos.length %> registros mostrados.
				<%	} %>
				<%	if (numeroPaginas > 1){	%>
						Pagina <%= contPag+1 %> de <%= numeroPaginas %>
				<% 	} %>
				<%} %>
			</DIV>
			</TD>
			<TD width="10%"> &nbsp;
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE width="100%" border="0">
	<TBODY>
		<TR bgcolor="#00204f">
			<TD width="20%" align="center">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Fecha</FONT></b>
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD width="80%" align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Descripción</FONT></b>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV id="msg"></DIV>
<DIV id="view"><BR>
<% if (ActualizaDiaFestivo.getListaDiasFestivos(strOrden, strTipo)!= null && ActualizaDiaFestivo.getListaDiasFestivos(strOrden, strTipo).length>0){ %>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
	<% 	int numeroPaginas = ActualizaDiaFestivo.getListaDiasFestivos(strOrden, strTipo).length/regPorPagina;	
		if (ActualizaDiaFestivo.getListaDiasFestivos(strOrden, strTipo).length%regPorPagina != 0)
				numeroPaginas++; 

		String [][] strDatos = 	ActualizaDiaFestivo.getListaDiasFestivos(strOrden, strTipo);
		for (int i=contPag*regPorPagina; i<strDatos.length && i<(contPag+1)*regPorPagina; i++){
			String Lista1 = strDatos[i][0];
			String Lista2 = strDatos[i][1];
			String Lista3 = strDatos[i][2];
	%>
	<% t++; %>
		<TR valign="top"  <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>> 
			<TD>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="20%">
						<INPUT type=checkbox value="<%=Lista1 %>" name="Borrar">
						<FONT face=Arial color=#000080 size=1>
						<A href="DiasFestivos.jsp?accion=consultar&DiaFestivo_IdDiaFestivo=<%=Lista1 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>">
						<%=Utilerias.formatearFechas(Lista2)%></A>
						</FONT>
					</td>
					<td width="80%" align="center">
						<FONT size="1" face="Arial" color="#000080">
						<%= Utilerias.cambioSaltosDeLinea(Lista3)%>
						</FONT>
					</td> 
				</tr>
			</table>
			</TD>
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
</TABLE>
<% } %>
</DIV>
<BR>
<BR>
</FORM>
</BODY>
</HTML>