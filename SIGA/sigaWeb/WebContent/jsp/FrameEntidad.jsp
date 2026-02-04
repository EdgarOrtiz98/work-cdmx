<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_front" prefix="meve_front"%>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<%@ page language="java"
	import="com.meve.sigma.actualiza.*,
			com.meve.sigma.util.Utilerias,
			com.meve.sigma.taglib.*,
			com.meve.sigma.beans.*,java.util.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strProcedencia 				=   "";
    String strIdArea 					= 	"";
	String strGral						=	"";
	String strInterna					=	"";
	String strArea						=	"";
	String strb							=	"";
	String a							=	"1";
	String c							=	"0";
	
	String strEntidad					=	"";
	String strEntidadClasificacion		=	"";
	String strEntidadDireccion			=	"";
	String strEntidadTel				=	"";
	String strCreador					=	"";
	String strFechaCreacion				=	"";
	String strAccion					=	"";
	String strEstatus					=	"1";
	String strIdEntidad					=	null;
	String strIdAsunto					=	"";
	String strTipo						=	"";
	String strBusqueda					=	"";
	String strOrden 					=	"";
	String num							=	"";
	String strRefEntidad				=	"";
	int valida 							= 	-2;
	
	String strDatosEntidadArea[][]		=	null;
	
	boolean	bExisteReg 		= 	false;
	boolean bInsertar		=	false;
	strProcedencia			=	request.getParameter("porcedencia");
	strIdArea 				= 	request.getParameter("id_us");
	strGral					=	request.getParameter("gral");
	strInterna				=	request.getParameter("int");
	strb					=	request.getParameter("b");
	num 					=	request.getParameter("num");
	strRefEntidad			=	(request.getParameter("refEntidad")!=null)?request.getParameter("refEntidad"):"";
	strAccion				=	request.getParameter("accion");
	strOrden		 		= 	(request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	strTipo 				= 	(request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
	strIdAsunto 			= 	(request.getParameter("ida")!=null)?request.getParameter("ida"):"";
	strBusqueda				= 	(request.getParameter("buscar")!=null)?request.getParameter("buscar"):"";
	String retURI 			= 	(request.getParameter("retURI")!=null)?request.getParameter("retURI"):"portalPrincipal.jsp";
	String strIdEntidadRef = "";
	StringTokenizer refEntToken = new StringTokenizer(strRefEntidad,"|");
	if (refEntToken.countTokens()>0){
		strIdEntidadRef = refEntToken.nextToken();
	}
		
	boolean bBuscar 	= Utilerias.detectaCEBuscar(strBusqueda)?true:false;
	strBusqueda 		= Utilerias.detectaCEBuscar(strBusqueda)?"":strBusqueda;
	
	if(strIdArea != null && strIdArea.length() > 0){
		strDatosEntidadArea		=	ActualizaEntidad.getEntidadArea(strIdArea);
	}
	bExisteReg				=	ActualizaEntidad.getExisteEntidad();
	
	//Sección de la alta de una entidad
	if(strAccion != null && strAccion.equals("guardar")){
		strEntidad				=	request.getParameter("entidad");
		strIdArea				=	request.getParameter("entidadArea");
		strEntidadClasificacion	=	request.getParameter("entidadClasificacion");
		strEntidadDireccion		=	request.getParameter("direccion");
		strEntidadTel			=	request.getParameter("tel");

		valida = ActualizaEntidad.getEntidadExiste(strEntidad, "1a2b3c", strIdArea, "1a2b3c");

		if (valida == 2)
		{
			bInsertar	=	ActualizaEntidad.InsertarEntidad(	strIdEntidad, strEntidad, strIdArea, strEntidadClasificacion,
																strEntidadDireccion, strEntidadTel, 
																BUsuario.getIdUsuario(), strFechaCreacion, strEstatus);
			String strIdEnt = "0";
			if(bInsertar)
				strIdEnt = ActualizaEntidad.ultimoIdEntidad();
			%>
			<SCRIPT language=JavaScript type=text/javascript>
			{	
			<%if("receptor".equals(strProcedencia)){%>
				location.assign('<%= retURI %>');
			<%}else{ %>
			    location.assign('<%= "FrameEntidad.jsp?id_us="+ strIdArea +"&b=0&refEntidad="+strIdEnt+"|"+strEntidad+"/0" %>');
			<%}%>
			}
			</SCRIPT>
			<%
		}
	}//Fin Sección de la alta de una entidad
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Entidad</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language="JavaScript" type="text/javascript">

	function verGrales(){
		location.assign('FrameEntidad.jsp?gral=0&id_us=<%=strIdArea%>&b=1&num=<%=num%>');
	}
	function verInternas(){
		location.assign('FrameEntidad.jsp?int=1&id_us=<%=strIdArea%>&b=1&num=<%=num%>');
	}
	function verArea(){
		location.assign('FrameEntidad.jsp?id_us=<%=strIdArea%>&b=0&num=<%=num%>');
	}
	function verNuevaEntidad(idArea){
		location.assign('FrameEntidad.jsp?id_us='+idArea+'&b=2&retURI=<%=Utilerias.codificaPostHTML("FrameEntidad.jsp?int=1&id_us="+ strIdArea +"&b="+strb+"&num="+num+"&refEntidad="+strRefEntidad)%>');
	}
	function cambio(o, t){
		doc = document.frameentidad;
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
</SCRIPT>
 
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" 
	onunload="opener.hay_hija=true">
<form name="frameentidad" action="FrameEntidad.jsp" method="post">
         <p>
            <input type="hidden" value="" name="accion"/>
            <input name="id_us"  value="<%= strIdArea %>" type="hidden"/>
            <input name="gral"   value="0" type="hidden"/>
            <input name="int" value="<%=strInterna%>"  type="hidden"/>
            <input name="area" value="2" type="hidden"/>
            <input name="num" value="<%=num%>"type="hidden"/>
            <input name="b"   value="<%=strb%>"type="hidden"/>
            <input name="orden"value="<%= strOrden %>"type="hidden"/>
            <input name="tipo"value="<%= strTipo %>"type="hidden"/>
            <input name="retURI"value="<%= retURI %>" type="hidden"/>
            <input name="idEntidadRef"value="<%= strIdEntidadRef %>"type="hidden"/>
            <input name="porcedencia"value="<%= strProcedencia %>"type="hidden"/>
            <%if(!strb.equals("2")){%>
         </p>
         <h2>
            &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <font color="#2121ff" face="Arial">
               <strong><em>Directorio</em></strong>
            </font>
         </h2>
         <table border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr valign="top">
		<td width="15%">
			<div align="left">
				<input type="button" onclick="verInternas()" value="U.A. de la SHCP" class="blue100a">
			</div>
		</td>
		<td width="15%">
			<div align="center">
				<input type="button" onclick="verArea()" value="Areas Externas" class="blue100a">
			</div>
		</td>
		
		<td width="20%">&nbsp;

		</td>
		<td width="50%">
			<div align="right">
				<input type="button" onclick="verNuevaEntidad(<%=strIdArea%>)" value="Otra Entidad..." class="blue100a">
				<input type="button" onclick="AceptarEntidadFrame(<%=strIdArea%>)" value="Aceptar" class="blue100a">
				<input type="button" value="Cancelar" class="blue100a" onclick="Cancelar()">
			</div>
		</td>
	</tr>
</table>
<div align="left">
Buscar: &nbsp;
<INPUT name="buscar" type="text" value="<%= strBusqueda %>" class="blue200" maxlength="199">
<A title="Buscar" onclick="buscarEntidad();"><IMG border="0" src="../Imagenes/ico_bus.gif" width="26" height="26" ></A><br>
</div>
<% if(strIdArea != null && strIdArea.length() > 0 && strb.equals("0")){ %>
<BR>
<table width="100%" border="0">
	<tr BGCOLOR="00204F">
		<TD WIDTH='100%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Entidades de la Unidad Administrativa
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font>
		</TD>
	</tr>
</table>
<% }else if(strInterna != null && strInterna.length() > 0 &&  strInterna.equals("1")){ %>
<br>
<TABLE WIDTH='100%' BORDER=0>
	<TR BGCOLOR="00204F">
		<TD WIDTH='80%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
			<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Unidad Administrativa
			<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font>
		</TD>
		<TD WIDTH='20%' align="center">
			<FONT SIZE=1 COLOR="FFFFFF" FACE="verdana">
			<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
			Operando en SIGA
			<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
			</font>
		</TD>
	</TR>
</TABLE>
<%}%>
<%}%>
<% if(bExisteReg){ %><%--Verifica si exisnten entidades de la unidad o externas--%>
<DIV class=documentBody id=Body>
<% if(strIdArea != null && strIdArea.length() > 0 && strb.equals("0")){ %><%--Lista de las entidades --%>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
	<%if(ActualizaEntidad.getEntidadGralExt(strIdArea,strBusqueda, strOrden).length!=0){%>
	<meve_front:ListaDatos datos="<%= ActualizaEntidad.getEntidadGralExt(strIdArea,strBusqueda, strOrden) %>" campo="campo">
		<TR valign="top">
			<TD width="100%">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<TD width="5%">
						<INPUT type="radio" value="<%= campo1 %>|<%= campo2 %>/<%=c%>" name="Sel" <%= (strRefEntidad.equals(campo1+"|"+campo2+"/"+c))?"checked=\"checked\"":""%>>
					</TD>
					<TD width="95%">
						<!-- <IMG height=1 src="../Imagenes/ecblank.gif" width=16 border=0> -->
						<FONT face=Arial color=#000080 size=1>
							<A title="<%= campo2 %>"> <%= Utilerias.recortaString(campo2,100) %> </A>
						</FONT>
					</TD>
				</tr>
			</table>
			</TD>
		</TR>
	</meve_front:ListaDatos>
	<%}%>
</TABLE>
<br>
</DIV>
<!-- script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script-->
<% }else if(strInterna != null && strInterna.length() > 0 &&  strInterna.equals("1")){ %>
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
	<%if(ActualizaEntidad.getEntidadesInternas(strBusqueda, strOrden, strTipo).length!=0){%>
	<meve_front:ListaDatos datos="<%=ActualizaEntidad.getEntidadesInternas(strBusqueda, strOrden, strTipo)%>" campo="campo">
		<TR valign="top">
			<TD width="100%">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<TD width="80%">
						<INPUT type="radio" value="<%= campo1 %>|<%= campo2 %>/<%= a %>" name="Sel" <%= (strRefEntidad.equals(campo1+"|"+campo2+"/"+a))?"checked=\"checked\"":""%>>
						<%if(campo3.equals("No")){%>
						<FONT face=Arial color="red" size=1>
							<A title="<%= campo2 %>"> <%= Utilerias.recortaString(campo2,80) %> </A>
						</FONT>
						<%}else{%>
						<FONT face=Arial color="#000080" size=1>
							<A title="<%= campo2 %>"> <%= Utilerias.recortaString(campo2,80) %> </A>
						</FONT>
						<%}%>
					</TD>
					<TD width="20%" align="center">
						<%if(campo3.equals("No")){%>
						<FONT face=Arial color="red" size=1>
							<%= campo3 %>
						</FONT>
						<%}else{%>
						<FONT face=Arial color="#000080" size=1>
							<%= campo3 %>
						</FONT>
						<%}%>
					</TD>
				</tr>
			</table>
			</TD>
		</TR>
	</meve_front:ListaDatos>
	<%}%>
</TABLE>
<BR>
</DIV>
<!-- <script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
 --><%}%>
<%}else{%>
<CENTER>
<table cellspacing="2" cellpadding="2">
	<tr>
		<TD align="center">
			<DIV align="center">
				<FONT face="verdana" size="4">***** No se han encontrado Entidades *****</FONT>
			</DIV>
		</TD>
	</tr>
</table>
</CENTER>
<% } %>
<%if(strb.equals("2")){%>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD width="150">
			<!-- <a onclick="verInternas()"> -->
			<a href="<%= retURI %>">
			<img src="../Imagenes/NavLeft.gif" title="Regresar" border="0">
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a onclick="guardarEntidadOtro1()">
			<img src="../Imagenes/Save.gif" title="Guardar"  border="0">
			</a>
		&nbsp;</TD>
		<TD width="150">

		&nbsp;</TD>
		<TD width="150">&nbsp;</TD>
		<TD width="217">&nbsp;</TD>
	</TR>
</TBODY>
</TABLE>
</DIV>
<BR>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
<TR valign="top">
<TD width="336" colspan="2"><B><FONT face="Verdana" color="#00204f" size="2">Entidad</FONT></B></TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>
<TR valign="top">
<td width="672" bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
        </TR>

	<TR valign="top">
		<TD width="144">
			<FONT face="Verdana" size="2">&nbsp;</FONT>
		</TD>
		<TD width="528" align="right" colspan="3">&nbsp;</td>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
		<TD width="144">&nbsp;</TD>
		<TD width="192">&nbsp;</TD>
    </TR>

<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2"><B>Unidad Administrativa:</B></FONT></TD>
<TD width="528" colspan="3">
		<FONT face="Verdana" size="2">
			<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(strIdArea) %>" 
					size="1" name="entidadArea" 
					classHtml="blue500a" selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
		</FONT>
</TD>
</TR>
<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2"><B>Entidad:</B></FONT>
<%if (valida == 1) {%><br>
<FONT color="red"><B>*Esta Entidad ya existe* </B></FONT><%} %>
</TD>
<TD width="528" colspan="3"><FONT face="Verdana" size="2">
<INPUT class="blue500" name="entidad" value="<%= strEntidad  %>" maxlength="199"></FONT></TD>
</TR>
<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2">Clasificación:</FONT></TD>
<TD width="528" colspan="3"><FONT face="Verdana" size="2">
	<SELECT name="entidadClasificacion" class="blue200a">
		<OPTION value="Privada" <%=(strEntidadClasificacion.trim().equals("Privada")?"selected":"")%>>Privada</OPTION>
		<OPTION value="Pública" <%=(strEntidadClasificacion.trim().equals("Pública")?"selected":"")%>>Pública</OPTION>
	</SELECT>
	</FONT></TD>
</TR>
<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>


<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2">Dirección:</FONT></TD>
<TD width="528" colspan="3"><FONT face="Verdana" size="2">
	<TEXTAREA class="blue500" name="direccion" rows="3"
		onKeyDown="limitaTextArea(document.frameentidad.direccion,'Dirección','200')";><%= strEntidadDireccion  %></TEXTAREA> 
</FONT></TD>
        </TR>
<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2">Teléfono:</FONT></TD>
<TD width="528" colspan="3"><FONT face="Arial" size="2"><INPUT class="blue500" name="tel" value="<%= strEntidadTel  %>" maxlength="199"></FONT></TD>
        </TR>
<TR valign="top">
<TD width="672" colspan="4">&nbsp;</TD>
        </TR>
    </TBODY>
</TABLE>
</DIV>
<%}%>
<SCRIPT language="JavaScript" type="text/javascript">
	if (<%= bBuscar %>)
		alert("No se permiten caracteres especiales ( % , & , \' ) en la Busqueda "+ "\n");
</SCRIPT>
</form>
</BODY>
</HTML>