<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Folios</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>  
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,java.util.*"%>
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
		bOperacion = ActualizaFolio.deleteFolio(strIds_Borrar,BUsuario.getIdUsuario());
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

	Vector vRegistros = new Vector();
	int numeroRegistros = 0;
	String sql[][] = ActualizaFolio.getListaFolios(strOrden, strTipo);
	if (sql!=null && sql.length>0){
		for (int ix=0; ix<sql.length; ix++){
			if(BUsuario.getAdmon() || BUsuario.getIdArea().equals(sql[ix][8])){ 
				numeroRegistros++;
				vRegistros.addElement(sql[ix]);
			}
		}
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
		doc = document.FoliosView;
		doc.accion.value="reload";
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
function pagina(contador){
	doc = document.FoliosView;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.FoliosView;
	doc.contligas.value=contador;
	doc.submit();
}

function BorrarFolios(){
	doc=document.forms[0];
	var form = document.forms[0]; 
	var cadena="";

	for (var i = 0; i < form.elements.length; i++) 
	{  
		if (form.elements[i].type == 'checkbox') 
		{      
			if (form.elements[i].name == 'Borrar') 
			{       
				if (form.elements[i].checked == true)
				{
					valor = form.elements[i].value;
					if(valor != "") 
						cadena = cadena +valor + ' ';        
				}
			}
		}
	}
	if (cadena == "") 
	alert("Debe seleccionar un Registro");
	else 
	{
		if (confirm("El Folio es requerido en el proceso de gestión,\nsi se elimina(n) provocará una inconsistencia.\n\nEstá usted seguro de que desea borrar el/los Registro(s)?")) 
		{    
			 doc.accion.value="borrar";
			 doc.submit();
		} 
		else 
			alert("Su petición de borrado ya fue cancelada");
	}
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
<span id="ruler" style="visibility:hidden;"></span> 
<FORM action="FoliosView.jsp" name="FoliosView" method="get">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="orden" value="<%= strOrden %>">
<INPUT type="hidden" name="tipo" value="<%= strTipo %>">
<INPUT type="hidden" value="<%= contPag %>" name="contPag">
<INPUT type="hidden" value="<%= contligas %>" name="contligas">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR>
			<TD width="40%"><A href="Folios.jsp?retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" target="_self"> <IMG height="26"
				src="../Imagenes/nuevo1.gif" width="27" border="0" title="Nuevo Folio">
			</A> <FONT face="Tahoma" size="2"></FONT> <A
				onclick="BorrarFolios();" target="_self"><IMG border="0"
				src="../Imagenes/borrar1.gif" width="30" height="27"
				title="Borrar Folio(s)"></A></TD>
			<TD width="50%">
			<DIV align="right">
				<% 
				if (vRegistros.size()>0){
					int numeroPaginas = numeroRegistros/regPorPagina;	
					if (numeroRegistros%regPorPagina != 0)
						numeroPaginas++; %>
				<%	if (numeroRegistros > 0){	%>
						<%= numeroRegistros %> registros mostrados.
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
			<TD id="Asunto_HD" width="35%" align="center">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Unidad Administrativa</FONT></b>
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD width="35%" align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Tipo de Folio</FONT></b>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD id="Asunto_HD2" width="30%" align="center">
			<a onclick="cambio('asc', 3)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Clave</FONT></b>
			<a onclick="cambio('desc', 3)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV class=documentBody id=Body>
<DIV id="view"><BR>
<% int j=0; %>
<% if (vRegistros.size()>0){ %>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
	<% 	int numeroPaginas = numeroRegistros/regPorPagina;	
			if (numeroRegistros%regPorPagina != 0)
				numeroPaginas++; 

		String [][] strDatos = 	ActualizaFolio.getListaFolios(strOrden, strTipo);
		for (int i=contPag*regPorPagina; i<vRegistros.size() && i<(contPag+1)*regPorPagina; i++){

			String sqlAux[] = (String[])vRegistros.get(i);
			strDatos[i]=sqlAux;

			String Lista1 = strDatos[i][0];
			String Lista2 = strDatos[i][1];
			String Lista3 = strDatos[i][2];
			String Lista4 = strDatos[i][3];
			String Lista5 = strDatos[i][4];
			String Lista6 = strDatos[i][5];
			String Lista7 = strDatos[i][6];
			String Lista8 = strDatos[i][7];
			String Lista9 = strDatos[i][8];
	%>
	<% if(	BUsuario.getAdmon() ||
			BUsuario.getIdArea().equals(Lista9)){ %>
	<% t++; %>
		<TR valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
			<TD width="100%">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="35%"><INPUT type=checkbox value="<%=Lista1 %>"
						name="Borrar"> <IMG height=1 src="../Imagenes/ecblank.gif"
						width=16 border=0><FONT face=Arial color=#000080 size=1> <A
						href="Folios.jsp?accion=consultar&folio_idFolio=<%=Lista1 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" 
							title="<%=Lista2%>">
							<script> document.write(trunc('<%=Lista2%>','Asunto_HD'));</script>
							</A>
					</FONT></td>
					<td width="35%" align="center" valign="middle"><%=Lista3%></td>
					<td width="30%" align="center" valign="middle"><A title="<%=Lista4%>">
					<script> document.write(trunc('<%=Lista4%>','Asunto_HD'));</script></A></td>
				</tr>
			</table>
			</TD>
		</TR>
	<% j++; %>
	<% } %>
	<% } %>
	<% if(j==0){ %>
	<TR>
		<TD width="100%">
		<div align=center><FONT face="verdana" size="4">******No hay Folios
		Capturados en su Unidad Administrativa ******</FONT></div>
		</TD>
	</TR>
		<% } else {%>
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
	<% } %>
</TABLE>
<% } %>
</DIV>
<BR>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
