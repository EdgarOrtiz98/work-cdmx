<jsp:useBean id="BAreaView" class="com.meve.sigma.beans.BeanAreaView" scope="page">
	<jsp:setProperty name="BAreaView" property="*" />
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%> 
<HTML>
<HEAD>
<TITLE>Destinatarios Externos</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,com.meve.sigma.taglib.*"%> 
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
	int t = 0;
	String regIDArea = (request.getParameter("regIDArea")==null)?"":request.getParameter("regIDArea");
	String strIdArea = (BAreaView.getIdArea()== null)?regIDArea:BAreaView.getIdArea();
	String strAccion = ""; 
	String strIds_Borrar[] = null;

	String retURI = strTmp + "?regIDArea=" + strIdArea;

	strAccion = request.getParameter("accion");
	strIds_Borrar = request.getParameterValues("Borrar");

	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {
		bOperacion = ActualizaDestino.deleteDestino(strIds_Borrar,BUsuario.getIdUsuario()); 
	}
	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
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
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>
	function reload() {
		doc = document.DestExtView;
		doc.accion.value="reload";
		doc.submit();
	}
	function cambio(o, t){
		doc = document.DestExtView;
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
	function referenciaRet(retURI){
		location.assign("DestExt.jsp?retURI=" + retURI.value);
	}

</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load();" onKeyPress="timer_reload();" 
	onClick="timer_reload();">
<span id="ruler" style="visibility:hidden;"></span> 
<FORM action="DestExtView.jsp" name="DestExtView" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" name="orden" value="">
<INPUT type="hidden" name="tipo" value="">
<INPUT type="hidden" value="<%=retURI %>" name="retURI">

<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="43%"><A onClick="referenciaRet(document.DestExtView.retURI);" target="_self"> <IMG
				height="26" src="../Imagenes/Nuevo.gif" width="27" border="0"
				title="Nuevo Destino"> </A> <FONT face="Tahoma" size="2"></FONT> <A
				href="javascript:Borrar()" target="_self"><IMG border="0"
				src="../Imagenes/borrar2.gif" width="30" height="27"
				title="Borrar Destino(s)"></A></TD>
			<TD width="57%">
			<DIV align="right"> &nbsp; </DIV>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="100%" bgcolor="#00204f"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<TABLE width="100%">
	<TBODY>
		<TR>      
			<TD class="etiquetas" align="right" width="30%"><b>Unidad Administrativa:</b></TD>
			<TD align="left" width="70%">
				<% if(BUsuario.getSupervisor()){ %>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="idArea"
				classHtml="blue500a" selected="<%=strIdArea%>"
				textoNoSeleccion="---------- Selecciona un Opción ----------" valorNoSeleccion=""
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='reload()'" />
				<%}else{%>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo() %>" size="1" name="idArea"
				classHtml="blue500a" selected="<%=strIdArea%>"
				textoNoSeleccion="---------- Selecciona un Opción ----------" valorNoSeleccion=""
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='reload()'" />
				<%}%>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<TABLE width="100%" border="0">
	<TBODY>
		<TR bgcolor="#00204f">
			<TD id="Asunto_HD"  width="25%" align="center">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Destinatario</FONT></b>
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
			<TD width="25%" align="center">
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			<b><FONT size="2" color="white" face="verdana">Direccion Electronica</FONT></b>
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV class=documentBody id=Body><BR>
<%if(strIdArea.length() != 0){%>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0"> 
	<% int j = 0; %>
	<meve_front:ListaDatos datos="<%=ActualizaDestino.getDestinoPorArea(strIdArea, strOrden, strTipo)%>" campo="Lista">
	<% if(	BUsuario.getAdmon() ||
			BUsuario.getIdArea().equals(Lista4)){ %>
	<% t++; %>
		<TR valign="top" <%if(par(t)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
			<TD width="100%">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="50%"><INPUT type=checkbox value="<%=Lista1 %>"
						name="Borrar"><FONT face=Arial color=#000080 size=1> <A href="DestExt.jsp?accion=consultar&id_usuario=<%=Lista1 %>&retURI=<%=retURI %>"
						title="<%=Lista2%>"><script>document.write(trunc('<%=Lista2%>','Asunto_HD'));</script></A>
					</FONT></td>
					<td align="center" width="50%">
					<a title="<%=Lista5%>"><script>document.write(trunc('<%=Lista5%>','Asunto_HD'));</script></a>
					</td>
				</tr>
			</table>
			</TD>
		</TR>
	<% j++; %>
	<% } %>
	</meve_front:ListaDatos>
	<% if(j == 0){ %>
	<TR>
			<TD width="100%">
			<div align=center><FONT face="verdana" size="4">******No Hay Destinos
			Capturados de su Unidad Administrativa******</FONT></div>
			</TD>
	</TR>
	<% } %>
</TABLE>
<%}%>
<br>
</DIV>

<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<BR>
</FORM>
</BODY>
</HTML>
</jsp:useBean>