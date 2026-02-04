<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>  
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,java.util.*"
%> 
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	String 	cat	= BUsuario.getCatArchivado();
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){;}
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
	int bOperacion1		=	0;	
	String strIds_Borrar[]	=	null;
	String strAccion		=	"";
	String msg				=	request.getParameter("msg");
	int t = 0;
	strAccion				=	request.getParameter("accion");
	strIds_Borrar			=	request.getParameterValues("Borrar");

	bExiste					=	ActualizaExpArchivado.getExisteCed();	

	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
	{
	
		bOperacion1	=	ActualizaExpArchivado.getDeleteTipCed(strIds_Borrar,BUsuario.getIdUsuario());	
			if(bOperacion1 == 2)
			{
			msg ="Existen registros asociados, el proceso de borrado no fue exitoso";
			}		
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
	int numRegistros = 0;
	int numPaginas = 0;

	numRegistros = 0;
	Vector vRegistros = new Vector();
	String[][] sqlVec = ActualizaExpArchivado.getDatosTipoCedula(strOrden, strTipo);
	if (sqlVec!=null && sqlVec.length>0){
		for (int ix=0; ix<sqlVec.length; ix++){
			if(BUsuario.getAdmon() || sqlVec[ix][13].equals(BUsuario.getIdArea())){ 
				numRegistros++;
				vRegistros.addElement(sqlVec[ix]);
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
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Cédula Tipo</TITLE>
<SCRIPT language="JavaScript" src="../js/GeneralFunctions.js"></SCRIPT>
<script language="JavaScript" type="text/javascript">
	function cambio(o, t){
		doc = document.tipocedv;
		doc.accion.value="reload";
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
		function validaReg() { 
		<%if(msg!= null && msg.trim().length()>0)
		{
		%>
		alert("<%=msg%>");
		<%
		}
		%>
	}
function pagina(contador){
	doc = document.tipocedv;
	doc.contPag.value=contador;
	doc.submit();
}

function paginaLiga(contador){
	doc = document.tipocedv;
	doc.contligas.value=contador;
	doc.submit();
}
</script>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="validaReg();timer_load();" 
	onKeyPress="timer_reload();" 
	onClick="timer_reload();">
<span id="ruler" style="visibility:hidden;"></span> 
<FORM action="TipoCedArchview.jsp" name="tipocedv" method="post">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="orden" value="<%= strOrden %>">
<INPUT type="hidden" name="tipo" value="<%= strTipo %>">
<INPUT type="hidden" value="<%= contPag %>" name="contPag">
<INPUT type="hidden" value="<%= contligas %>" name="contligas">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY>
	<TR valign="top">
		<TD width="100%" colspan="2"></TD>
    </TR>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY>
	<TR valign="top">
		<TD width="43%">
			<A href="Archivado.jsp">
			<IMG border="0" title="Regresar" src="../Imagenes/NavLeft.gif" width="30" height="27">
			</A>
			<A href="TipoCedArch.jsp?retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>">
				<IMG height="26" title="Agregar Tipo Cedula" src="../Imagenes/nuevo1.gif" width="27" border="0"></A>
				<FONT face="Tahoma" size="2">
				</FONT>
				<A href="javascript:Borrar()">
				<IMG border="0" title="Borrar Tipo Cedula" src="../Imagenes/borrar1.gif" width="30" height="27">
			</A>
		</TD>
		<TD width="57%" align="right" valign="middle">
		<%	numPaginas = numRegistros/regPorPagina;	
			if (numRegistros%regPorPagina != 0)
				numPaginas++; %>
		<%	if (numRegistros > 0){	%>
			<%= numRegistros %> registros mostrados.
		<%	} %>
		<%	if (numPaginas > 1){	%>
			Pagina <%= contPag+1 %> de <%= numPaginas %>
		<% 	} %>
			&nbsp;&nbsp;&nbsp;&nbsp;
        </TD>
    </TR>
</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY align="center">
	<TR bgcolor="#00204f">
		<TD align="center" >&nbsp;
					<FONT size="2" color="white" face="verdana">CATALOGO CEDULAS TIPO</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="100%" colspan="2"></TD>
    </TR>
</TABLE>
<TABLE width="100%" border="0">
<TBODY>
	<TR bgcolor="#00204f">
		<TD width="10%" align="center">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Fondo</FONT></b>
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
        </TD>
		<TD width="15%" align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">SubFondo</FONT></b>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
        </TD>
		<TD width="10%" align="center">
			<a onclick="cambio('asc', 3)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Sección</FONT></b>
			<a onclick="cambio('desc', 3)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
        </TD>        
		<TD width="10%" align="center">
			<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Serie</FONT></b>
			<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
        </TD>  
		<TD width="15%" align="center">
			<a onclick="cambio('asc', 5)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Subserie</FONT></b>
			<a onclick="cambio('desc', 5)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
        </TD>
		<TD width="15%" align="center">
			<a onclick="cambio('asc', 8)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Clave UA</FONT></b>
			<a onclick="cambio('desc', 8)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
        </TD>   
		<TD id="Asunto_HD" width="15%" align="center">
			<a onclick="cambio('asc', 6)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Clave CT</FONT></b>
			<a onclick="cambio('desc', 6)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
        </TD>                     
		<TD width="15%" align="center">
			<a onclick="cambio('asc', 7)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Estatus</FONT></b>
			<a onclick="cambio('desc', 7)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
        </TD>      
   </TR>
</TBODY>
</TABLE>
<DIV id="msg"></DIV>
<DIV id="view">
<TABLE width="100%" border="0">
<TBODY>
	<% if(bExiste){ %>
	<% t=0; %>
		<%	String[][] sql = ActualizaExpArchivado.getDatosTipoCedula(strOrden, strTipo);
			for (int i=contPag*regPorPagina; i<sql.length && i<(contPag+1)*regPorPagina; i++){
				String campo1 = sql[i][0];
				String campo2 = sql[i][1];
				String campo3 = sql[i][2];
				String campo4 = sql[i][3];
				String campo5 = sql[i][4];
				String campo6 = sql[i][5];
				String campo7 = sql[i][6];
				String campo8 = sql[i][7];
				String campo9 = sql[i][8];
				String campo10 = sql[i][9];
				String campo11 = sql[i][10];
				String campo12 = sql[i][11];
				String campo13 = sql[i][12];
				String campo14 = sql[i][13];
				String campo15 = sql[i][14];
				String campo16 = sql[i][15];
		%>
	<% if (BUsuario.getAdmon() || campo14.equals(BUsuario.getIdArea()) || cat.equalsIgnoreCase("1")){ %>
	<% t++; %>
	<TR vAlign="middle" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<TD width="10%">
    		<INPUT type=checkbox value="<%= campo13 %>" name="Borrar">
    		<FONT face=Arial color=#000080 size=1>
    		<A href="TipoCedArch.jsp?id_sub=<%= campo13 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" class ="etiquetas" title= "<%=campo10 %>"><%=campo5%></A>
    		</FONT>
	   	</TD> 
		<TD width="15%" align="center">
			<FONT face=Arial color=#000080 size=1>
    		<A href="TipoCedArch.jsp?id_sub=<%= campo13 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" class ="etiquetas" title= "<%=campo9 %>"><%=campo4%></A>
    		</FONT>
		</TD>
		<TD width="10%" align="center">
			<FONT face=Arial color=#000080 size=1>
    		<A href="TipoCedArch.jsp?id_sub=<%= campo13 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" class ="etiquetas" title= "<%=campo8 %>"><%=campo3%></A>
    		</FONT>
		</TD>
		<TD width="10%" align="center">
			<FONT face=Arial color=#000080 size=1>
    		<A href="TipoCedArch.jsp?id_sub=<%= campo13 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" class ="etiquetas" title= "<%=campo7 %>"><%=campo2%></A>
    		</FONT>
		</TD>
		<TD width="15%" align="center">
			<FONT face=Arial color=#000080 size=1>
    		<A href="TipoCedArch.jsp?id_sub=<%= campo13 %>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas) %>" class ="etiquetas" title= "<%=campo6 %>"><%=campo1%></A>
    		</FONT>
		</TD>
		<TD width="15%" align="center">
			<FONT face=Arial color=#000080 size=1>
    		<A  class ="etiquetas" ><%=campo15%></A>
    		</FONT>
		</TD>
		<TD width="15%" align="center">
			<FONT face=Arial color=#000080 size=1>
			<A class ="etiquetas"  title="<%=campo11%>"><script> document.write(trunc('<%=campo16%>','Asunto_HD'));</script></A>
    		</FONT>
		</TD>		
		<TD width="15%" align="center">
			<FONT face=Arial color=#000080 size=1>
    		<A  class ="etiquetas" ><%=campo12%></A>
    		</FONT>
		</TD>						
	</TR>
	<% } %>
	<% } %>
	<% if (t==0){ %>
		<TR> 
			<TD width="100%">
				<div align=center>
					<FONT face="verdana" size="4">******No Hay Tipos Capturados******</FONT>
				</div>
			</TD>
		</TR>
	<% }else{ %>
		<TR>
		<TD colspan="7" align="center"><BR>
		<%
			if (contligas>0 && numPaginas > muestraPaginas){  %>
				<A onclick="paginaLiga(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);pagina(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;
		<%	}
			if (contPag > 0){  
				if (contPag > contligas){%>
					<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
			<%	}else{%>
					<A onclick="paginaLiga(<%=contligas-1%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
			<%	} 
			}
			if (numPaginas > 1){
				for (int i=contligas; i<muestraPaginas+contligas && i<numPaginas; i++){ 
					if (i==contPag){  %>
						<A onclick="pagina(<%=i%>)"><FONT color="red"><B>[<%=i+1%>]</B></FONT></A> &nbsp;
			<%		}else{ %>
						<A onclick="pagina(<%=i%>)"><%=i+1%></A> &nbsp;
			<%		}
				}
			} 
			if (contPag < numPaginas-1){  
				if (contPag < contligas + muestraPaginas-1){%>
					<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
			<%	}else{%>
					<A onclick="paginaLiga(<%=contligas+1%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
			<%	} 
			}
			if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  %>
				<A onclick="paginaLiga(<%= contligas+muestraPaginas %>);pagina(<%= contligas+muestraPaginas %>);"> <B> | Siguiente&gt;&gt;</B> </A>
		<%	
			} %>
		</TD>
		</TR>
	<% } %>
	<% } else { %>
	<TR> 
		<TD width="100%">
			<div align=center>
				<FONT face="verdana" size="4">******No Hay Tipos Capturados******</FONT>
			</div>
		</TD>
	</TR>
	<% } %>
</TBODY>
</TABLE>
</DIV>
<BR>

</FORM>
</BODY>
</HTML>
