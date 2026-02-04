<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<TITLE>Remitente</TITLE>
<%@ page language="java"contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,java.util.*,com.meve.sigma.util.*"%>
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
	String [][] sql	=null;
	boolean bOperacion		=	false;
	Vector vTiene = new Vector();
	String strIds_Borrar[]	=	null;
	String strAccion		=	"";
	int t = 0;
	strAccion				=	request.getParameter("accion");
	strIds_Borrar			=	request.getParameterValues("Borrar");
	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
	{
		vTiene	=	ActualizaRemitente.deleteRemitente(strIds_Borrar, BUsuario.getIdUsuario());
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

	int numeroRegistros = 0;
	Vector vRegistros = new Vector();
	sql = ActualizaRemitente.getListaRemitentes(strOrden, strTipo);
	if (sql!=null && sql.length>0){
		for (int ix=0; ix<sql.length; ix++){
			if(BUsuario.getAdmon() || BUsuario.getIdArea().equals(sql[ix][2])){ 
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
		doc = document.RemitenteView;
		doc.accion.value="reload";
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
function pagina(contador){
	doc = document.RemitenteView;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.RemitenteView;
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
<span id="ruler" style="visibility:hidden;"></span> 
<FORM action="RemitenteView.jsp" name="RemitenteView" method="post">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="orden" value="<%= strOrden %>">
<INPUT type="hidden" name="tipo" value="<%= strTipo %>">
<INPUT type="hidden" value="<%= contPag %>" name="contPag">
<INPUT type="hidden" value="<%= contligas %>" name="contligas">
<%if(vTiene.size()>0){%>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR>
			<TD width="43%" class="etiquetas">
				<FONT size="1" color="RED">
				&nbsp;&nbsp;No se pueden eliminar los siguientes Remitentes (razones)<BR><BR>
				<%for(int i=0;i<vTiene.size();i=i+2){%>
				<A title="<%=ActualizaRemitente.getNombreRemitente((String)vTiene.get(i))%>">
				&nbsp;&nbsp;** <%=Utilerias.recortaString(ActualizaRemitente.getNombreRemitente((String)vTiene.get(i)),80)%> **&nbsp;&nbsp;</A> tiene <%=(String)vTiene.get(i+1)%><BR>
				<%}%>
				</FONT>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<br>
<%}%>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY>
<TR valign="top">
<TD width="100%" colspan="2">&nbsp;</TD>
        </TR>
    </TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY>
	<TR valign="top">
		<TD width="40%">
			<A href="Remitente.jsp?retURI=<%= Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" target="_self">
				<IMG height="26" src="../Imagenes/nuevo1.gif" width="27" border="0" title="Nuevo Remitente">
			</A>
			<FONT face="Tahoma" size="2"></FONT>
			<A href="javascript:Borrar()" target="_self">
			<IMG border="0" src="../Imagenes/borrar1.gif" width="30" height="27" title="Borrar Remitente"></A>
		</TD>
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
	<b><FONT size="2" color="white" face="verdana">Remitentes</FONT></b>
	<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
</TD>
<TD id="Asunto_HD2" width="30%" align="center">
	<a onclick="cambio('asc', 3)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
	<b><FONT size="2" color="white" face="verdana">Entidad</FONT></b>
	<a onclick="cambio('desc', 3)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
</TD>
<TD id="Asunto_HD3" width="35%" align="center">
	<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
	<b><FONT size="2" color="white" face="verdana">Unidad Administrativa</FONT></b>
	<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
</TD>

</TR>
    </TBODY>
</TABLE>
<DIV class=documentBody id=Body>
<DIV id="view">
<% int j = 0; %>
<TABLE width="100%" border="0">
<TBODY>
	<% sql=ActualizaRemitente.getListaRemitentes(strOrden, strTipo);%>
	<%if(vRegistros.size()==0){%>
	<%}else {			
			int numeroPaginas = numeroRegistros/regPorPagina;	
			if (numeroRegistros%regPorPagina != 0)
				numeroPaginas++; 

			for (int i=contPag*regPorPagina; i<vRegistros.size() && i<(contPag+1)*regPorPagina; i++){

				String sqlAux[] = (String[])vRegistros.get(i);
				sql[i]=sqlAux;

				String campo1 = sql[i][0];
				String campo2 = sql[i][1];
				String campo3 = sql[i][2];
				String campo4 = sql[i][3];
				String campo5 = sql[i][4];
				String campo6 = sql[i][5];
%>
	<% if(	BUsuario.getAdmon() ||
			BUsuario.getIdArea().equals(campo3)){ %>
	<% t++; %>
		  <TR vAlign=top <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		    <TD width="35%">
    			<INPUT type=checkbox value="<%=campo2%>" name="Borrar">
    			<FONT face=Arial color=#000080 size=1>
		    	<A href="Remitente.jsp?id_remitente=<%=campo2%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" 
					title="<%= campo1 %>"><script> document.write(trunc('<%=campo6%>','Asunto_HD'));</script></A>
    			</FONT>
	    	</TD>
			<TD align="center" width="30%" valign="middle">
				<FONT face=Arial color=#000080 size=1>
				<a title="<%=campo5%>"><script> document.write(trunc('<%=campo5%>','Asunto_HD'));</script></a></FONT>
			</TD>
			<TD align="center" width="35%" valign="middle">
				<FONT face=Arial color=#000080 size=1>
				<a title="<%=campo4%>"><script> document.write(trunc('<%=campo4%>','Asunto_HD'));</script></a></FONT>
			</TD>
		 </TR>
	<% j++; %>
	<% } %>
	<% } %>
	<% } %>
	<% if(j == 0){ %>
	<TR>
		<TD width="100%">
		<div align=center><FONT face="verdana" size="4">******No hay Remitentes
		Capturados en tu Unidad Administrativa ******</FONT></div>
		</TD>
	</TR>
	<% } else {%>
	<TR>
		<TD colspan="3" align="center"><BR>
		<%
			int numeroPaginas = (sql!=null)?numeroRegistros/regPorPagina:0;	
			if (numeroRegistros%regPorPagina != 0)
				numeroPaginas++; 
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
</TBODY>
</TABLE>
</DIV>
<BR>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>