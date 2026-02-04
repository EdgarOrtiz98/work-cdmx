<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Pasos</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*"%>
<%@ page import="com.meve.sigma.beans.*,com.meve.sigma.util.*,java.util.*"%>
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
	boolean bExiste			=	false;
	boolean bOperacion		=	false;
	boolean bMostrar		=	false;

	int t = 0;

	String strIds_Borrar[]	=	null;
	String strAccion		=	"";

	strAccion				=	request.getParameter("accion");
	strIds_Borrar			=	request.getParameterValues("Borrar");

	bExiste					=	ActualizaPaso.getExiste();	

	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
	{
		bOperacion	=	ActualizaPaso.deletePaso(strIds_Borrar, BUsuario.getIdUsuario());
	}
	String strId = "";
	String strIdUsuario = (request.getParameter("idUs")!=null)?request.getParameter("idUs"):"0";
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
	
	
	String sql[][] = ActualizaPaso.getTipoDoctos(strOrden);
	if (sql!=null && sql.length>0){
		for (int ix=0; ix<sql.length; ix++){
			if(BUsuario.getAdmon() || BUsuario.getIdArea().equals(sql[ix][3])){ 
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
function desplegar(id){
	/*doc = document.pasosView;
	doc.idUs.value=id;
	doc.submit();*/
	doc = document.pasosView;
	if (id==doc.idUs.value){
		doc.idUs.value=0;
		doc.submit();
	}else{
		doc.idUs.value=id;
		//doc.contPag.value=0;
		//doc.contligas.value=0;
		doc.submit();
	}
}
function cambio(o, t, id){
	doc = document.pasosView;
	doc.orden.value=o;
	doc.tipo.value=t;
	doc.idUs.value=id;
	doc.submit();
}
function pagina(contador){
	doc = document.pasosView;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.pasosView;
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
<FORM action="PasosView.jsp" name="pasosView" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%= strIdUsuario %>" name="idUs">
<INPUT type="hidden" name="orden" value="<%= strOrden %>">
<INPUT type="hidden" name="tipo" value="<%= strTipo %>">
<INPUT type="hidden" value="<%= contPag %>" name="contPag">
<INPUT type="hidden" value="<%= contligas %>" name="contligas">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="100%" colspan="2">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>

<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR>
			<TD width="40%"><A href="Pasos.jsp?retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>" target="_self"> <IMG height="26"
				src="../Imagenes/nuevo1.gif" width="27" border="0" title="Nuevos Pasos"></A> <FONT
				face="Tahoma" size="2"> </FONT> <A href="javascript:Borrar()"
				target="_self"> <IMG border="0" src="../Imagenes/borrar1.gif"
				width="30" height="27" title="Borrar Pasos"></A></TD>
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
			<TD width="60%" align="center">
			<a onclick="cambio('asc', 1, <%=strIdUsuario%>)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Paso</FONT></b>
			<a onclick="cambio('desc', 1, <%=strIdUsuario%>)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD width="40%"  align="center">
			<a onclick="cambio('asc', 2, <%=strIdUsuario%>)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Secuencia</FONT></b>
			<a onclick="cambio('desc', 2, <%=strIdUsuario%>)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV class=documentBody id=Body>
<DIV id="view">
<% int j = 0; %>
<TABLE width="100%">
	<TBODY>
		<% if(bExiste){ 
		int numeroPaginas = numeroRegistros/regPorPagina;	
		if (numeroRegistros%regPorPagina != 0)
			numeroPaginas++;

		String [][] strDatos = 	ActualizaPaso.getTipoDoctos(strOrden);
		//System.out.println("1:"+strDatos[i][2]);
		for (int i=contPag*regPorPagina; i<vRegistros.size() && i<(contPag+1)*regPorPagina; i++){

			String sqlAux[] = (String[])vRegistros.get(i);
			strDatos[i]=sqlAux;

			String campo1 = strDatos[i][0];
			String campo2 = strDatos[i][1];
			String campo3 = strDatos[i][2];
			String campo4 = strDatos[i][3];			
		%>
		<% if(	BUsuario.getAdmon() ||
				BUsuario.getIdArea().equals(campo4)){
				bMostrar = strIdUsuario.equals(campo1);
		%>
			<tr valign="top">
				<td colspan="2" width="800">
					<% strId = campo1; %>
					<a onClick="desplegar(<%=strId%>)" title="<%=campo3%>(<%= campo2 %>)">
						<img src="../Imagenes/<%=(bMostrar)?"collapse.gif":"expand.gif"%>"
							border="0" height="16" width="16"> 
						<%=Utilerias.recortaString(campo3,50)%>(<%= Utilerias.recortaString(campo2,50) %>)
					</a> 
				</td>
			</tr>
			<%if(bMostrar){ %>
			<meve_front:ListaDatos
				datos="<%= ActualizaPaso.getPasos(campo1, strOrden, strTipo) %>" campo="usuario">
			<% t++; %>
			<tr valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
				<td align="left"  width="60%">
					<INPUT type=checkbox value="<%=usuario1%>" name="Borrar">
    				<font size="2" color="#000080" face="Arial">
					<A href="Pasos.jsp?id_pas=<%= usuario1 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&idUs="+strIdUsuario+"&contPag="+contPag+"&contligas="+contligas) %>" 
						title="<%= usuario4 %>"><%= Utilerias.recortaString(usuario4,80) %>
					</A>
					</font>
				</td>
				<td align="center" width="40%" valign="middle"><font size="2" color="#000080"
					face="Arial"> <%= usuario3 %> </font></td>
			</tr>
			</meve_front:ListaDatos>
		<% } %>
		<% j++; %>
		<% } %>
		<% } %>
		<% if(j==0){ %>
		<TR>
			<TD width="100%" align="center">
				<FONT face="verdana" size="4">******No hay Pasos
				Capturados en su Unidad Administrativa ******</FONT>
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
		<% } else { %>
		<TR>
			<TD width="100%">
			<div align=center><FONT face="verdana" size="4">******No Hay Pasos
			capturados******</FONT></div>
			</TD>
		</TR>
		<% } %>
	</TBODY>
</TABLE>
</DIV>
</DIV>
<BR>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
