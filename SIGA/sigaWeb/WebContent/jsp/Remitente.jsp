<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Remitente</TITLE>
<jsp:useBean id="Bremitente" class="com.meve.sigma.beans.BeanRemitente" scope="page">
	<jsp:setProperty name="Bremitente" property="*" />
<%@ page language="java"contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.taglib.*,com.meve.sigma.actualiza.*,com.meve.sigma.beans.*" %>
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
	String strNombre		=	(Bremitente.getRemitente()== null)?"":Bremitente.getRemitente();
	String strCargo			=	(Bremitente.getRemitenteCargo()== null)?"":Bremitente.getRemitenteCargo();
	String strIdArea		=	(Bremitente.getRemitenteArea()== null)?"":Bremitente.getRemitenteArea();
	String strIdEntidad		=	(Bremitente.getRemitenteEntidad()== null)?"":Bremitente.getRemitenteEntidad();
	String strTelefono		=	(Bremitente.getRemitenteTelefono()== null)?"":Bremitente.getRemitenteTelefono();
	String strCorreo		=	(Bremitente.getRemitenteCorreo()== null)?"":Bremitente.getRemitenteCorreo();
	String strDireccion		=	(Bremitente.getRemitenteDireccion()== null)?"":Bremitente.getRemitenteDireccion();
	String strFax			=	(Bremitente.getRemitenteFax()== null)?"":Bremitente.getRemitenteFax();

	String strIdRemitente	=	"";
	String strCreador		=	"";
	String strCreador1		=	"";
	String strFechaCreacion	=	"";
	String strFechaCreacion2=	"";
	String strAccion		=	"";
	String strEstatus		=	"1";
	String strEntidades[][] = 	null;
	String strRemitentes[][]=	null;
	
	String retURI = (request.getParameter("retURI")== null)?"RemitenteView.jsp":request.getParameter("retURI");
	String strAux = "1a2b3c", strAux2 = "1a2b3c"; 
	int valida = -2;
	boolean bInsertar =	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	strFechaCreacion2 				=	strFechaCreacion;

	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
	strIdRemitente	=	request.getParameter("id_remitente");

	strAccion		=	request.getParameter("accion");

	if(strIdRemitente != null && strAccion == null)
	{
		strRemitentes=ActualizaRemitente.getRemitentes(strIdRemitente);
		strNombre		=	strRemitentes[0][0];
		strIdArea		=	strRemitentes[0][1];
		strCargo		=	strRemitentes[0][2];
		strIdEntidad	=	strRemitentes[0][3];
		strTelefono		=	strRemitentes[0][4];
		strCorreo		=	strRemitentes[0][5];
		strDireccion	=	strRemitentes[0][6];
		strFax			=	strRemitentes[0][7];
		strCreador			=	ActualizaUsuario.NombreUsuario(strRemitentes[0][8]);
		strFechaCreacion2	=	strRemitentes[0][9];

		strAux = strNombre;
		strAux2 = strIdEntidad;
	}
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strNombre		=	request.getParameter("remitente");
		strIdArea		=	request.getParameter("remitenteArea");
		strCargo		=	request.getParameter("remitenteCargo");
		strIdEntidad	=	request.getParameter("remitenteEntidad");
		strDireccion	=	request.getParameter("remitenteDireccion");
		strTelefono		=	request.getParameter("remitenteTelefono");
		strFax			=	request.getParameter("remitenteFax");
		strCorreo		=	request.getParameter("remitenteCorreo");

		strAux		=	request.getParameter("aux");
		strAux2		=	request.getParameter("aux2");

		valida = ActualizaRemitente.getRemitenteExiste(strNombre, strAux, strIdEntidad, strAux2);	

		if (valida == 2){
			bInsertar	= 	ActualizaRemitente.InsertarRemitente(	strIdRemitente, strNombre, strCargo, strIdArea, strIdEntidad, strTelefono,
																	strCorreo, strCreador1, strFechaCreacion, strEstatus, strDireccion, strFax);

			try{
				response.sendRedirect(retURI);
			}catch(java.io.IOException io){
				//System.out.println("ErrorRedirect-->"+io);
			}
		}
	}
%>
<% if(strIdRemitente!=null && strIdRemitente.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>


function soloNumeros(ob){
	var ok=false;
	var texto=ob.value
	var codigo=texto.charCodeAt(texto.length-1);
	if((codigo>=48&&codigo<=57))
	ok=true;
	if(!ok){
		texto=texto.substring(0,texto.length-1);
		ob.value=texto;
		}
	}
function guardar() {

	doc = document.Remitente;
	//valida = 0;
	msg="";

//	else 	{
		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \', `, ´)\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'

		if(detectaCE(doc.remitente.value) || detectaCE(doc.remitenteCargo.value) || detectaCE(doc.remitenteDireccion.value)){

			if (confirm(mensaje)){

				doc.remitente.value	= quitaCE(doc.remitente.value);
				doc.remitenteCargo.value	= quitaCE(doc.remitenteCargo.value);
				doc.remitenteDireccion.value	= quitaCE(doc.remitenteDireccion.value);
	
				doc.aux.value	= quitaCE(doc.aux.value);
				doc.accion.value="guardar";
//				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			doc.accion.value="guardar";
//			doc.submit();
		}
//	}
		if (doc.remitenteArea[doc.remitenteArea.selectedIndex].value == -1) {
			valida =1;
			msg = msg + " Debes seleccionar una Unidad Administrativa"+ "\n";
		}
		if (Trim(doc.remitente.value) =="") {
			valida =1;
			msg = msg + " Debes capturar el Nombre del Remitente	"+ "\n";
		}
		if (Trim(doc.remitenteCargo.value) =="") {
			valida =1;
			msg = msg + " Debes capturar el Cargo del Remitente	"+ "\n";
		}
		if (doc.remitenteEntidad[doc.remitenteEntidad.selectedIndex].value == -1) {
			valida =1;
			msg = msg + " Debes seleccionar una Entidad para el Remitente	"+ "\n";
		}
		if (!isCorreo(Trim(doc.remitenteCorreo.value))) {
			valida =1;
			msg = msg + " El Correo Electrónico es inválido	"+ "\n";
		}
		if (!isTelefono(Trim(doc.remitenteTelefono.value))) {
			valida =1;
			msg = msg + " El número de Teléfono es inválido	"+ "\n";
		}
		if (!isTelefono(Trim(doc.remitenteFax.value))) {
			valida =1;
			msg = msg + " El número de Fax es inválido	"+ "\n";
		}
		if (Trim(quitaPuntos(doc.remitente.value)) =="" && doc.remitente.value!="") {
			valida =1;
			msg = msg + " El Nombre del Remitente no es válido"+ "\n";
		}
		if (Trim(quitaPuntos(doc.remitenteCargo.value)) =="" && doc.remitenteCargo.value!="") {
			valida =1;
			msg = msg + " El Cargo no es válido"+ "\n";
		}
		if (Trim(quitaPuntos(doc.remitenteDireccion.value)) =="" && doc.remitenteDireccion.value!="") {
			valida =1;
			msg = msg + " La Dirección no es válida"+ "\n";
		}
		if (valida == 1) 
		{
			alert(msg);
			valida=0;
			return false;
		}else if(valida == 2){
			alert("Su solicitud ya fue enviada");
			return false;
		}else{
			valida=2;
			doc.submit();
		}
}

function entidades() {
	doc = document.Remitente;
	doc.accion.value="reload";
	doc.submit();
}
function regresarRemitente(){
	location.assign("<%= retURI %>");
}

</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="valida=0;timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="Remitente.jsp" name="Remitente" method="post">
<INPUT type="hidden" value="" name="accion">
<%if (strIdRemitente!=null){ %>
<INPUT type="hidden" value="<%=strIdRemitente %>" name="id_remitente"><%}%><BR>
<INPUT type="hidden" value="<%=strAux %>" name="aux">
<INPUT type="hidden" value="<%=strAux2 %>" name="aux2">
<INPUT type="hidden" value="<%=retURI %>" name="retURI">

<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<TR valign="top">
		<TD colspan="4">
			<a onclick="regresarRemitente()">
			<IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar">
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a onclick="guardar()">
			<img src="../Imagenes/Save.gif" title="Guardar">
			</a>
		</TD>
    </TR>

        <TR valign="top">
            <TD colspan="2"><B><FONT face="Verdana" color="#00204f" size="2"><FONT
				size="+1" color="#004080">Remitente</FONT></FONT></B></TD>
            <TD colspan="2" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
        </TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2"></TD>
			<TD colspan="2"></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2"></TD>
			<TD colspan="2"></TD>
		</TR>

	<TR valign="top">
		<TD width="144">
			<FONT face="Verdana" size="2">&nbsp;</FONT>
		</TD>
		<TD colspan="3" align="right">
			<FONT face="Verdana" size="2">
				<%=(strIdRemitente!=null && !strIdRemitente.equals(""))?"Última modificación por: ":"Creado por: "%><I><%= strCreador %> - <%= strFechaCreacion2 %></I></FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="183"><BR>
			<BR>
			</TD>
		<TD width="233">&nbsp;</TD>
		<TD width="67">&nbsp;</TD>
		<TD width="272">&nbsp;</TD>
    </TR>
		<TR valign="top">
		<TD width="183"><FONT face="Verdana" size="2" color="#004080"><B>Unidad
			Administrativa:</B></FONT></TD>
		<TD colspan="3">
		<FONT face="Verdana" size="2">
			<% if(BUsuario.getSupervisor()){ 
				if(strIdRemitente==null){
					strIdArea = BUsuario.getIdArea();
				} 
			%>
			<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" 
					name="remitenteArea" classHtml="blue600a" 
					selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='entidades()'"/>
			<% }else{ %>
			<meve_combo:comboseleccion data="<%= ComboData.getAreasComboAll() %>" size="1" 
					name="remitenteArea" classHtml="blue600a" 
					selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='entidades()'"/>
			<% } %>
		</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD width="233">&nbsp;</TD>
		<TD width="67">&nbsp;</TD>
		<TD width="272">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Nombre:</B></FONT>
		<%if (valida == 1) {%><br>
		<FONT color="red"><B>*Esta Nombre ya existe* </B></FONT><%} %>
		</TD>
		<TD colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue600a" name="remitente" value="<%=strNombre %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD width="233">&nbsp;</TD>
		<TD width="67">&nbsp;</TD>
		<TD width="272">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Cargo:</B></FONT></TD>
		<TD colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue600a" name="remitenteCargo"  value="<%=strCargo %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD width="233">&nbsp;</TD>
		<TD width="67">&nbsp;</TD>
		<TD width="272">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="183"><FONT face="Verdana" size="2" color="#004080"><B>Entidad:</B></FONT></TD>
		<TD colspan="3">
			<FONT face="Verdana" size="2">
				<%if(strIdArea.length() > 0){%>
				<meve_combo:comboseleccion data="<%= ComboData.getEntidadAreaCombo(strIdArea) %>" 
					size="1" name="remitenteEntidad" classHtml="blue600a" 
					selected="<%= strIdEntidad %>" 
					textoNoSeleccion=" ------------ Selecciona una Entidad ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<%}else{%>
				<SELECT class="blue600a" name="remitenteEntidad">
					<OPTION value="-1">------------ Selecciona una Entidad ------------</OPTION>
				</SELECT>
				<%}%>
			</FONT>
		</TD>
    </TR>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD width="233">&nbsp;</TD>
		<TD width="67">&nbsp;</TD>
		<TD width="272">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="183"><FONT face="Verdana" size="2" color="#004080">Dirección:</FONT></TD>
		<TD colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue600a" name="remitenteDireccion" value="<%=strDireccion %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="183"><FONT color="#004080">&nbsp;</FONT></TD>
		<TD width="233">&nbsp;</TD>
		<TD width="67">&nbsp;</TD>
		<TD width="272">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="183"><FONT face="Verdana" size="2" color="#004080">Teléfono:</FONT></TD>
		<TD colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue600a" name="remitenteTelefono" onkeydown="soloNumeros(this)" value="<%=strTelefono %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="183"><FONT color="#004080">&nbsp;</FONT></TD>
		<TD width="233">&nbsp;</TD>
		<TD width="67">&nbsp;</TD>
		<TD width="272">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080">Fax:</FONT></TD>
		<TD colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue600a" name="remitenteFax" onkeydown="soloNumeros(this)" value="<%=strFax %>" maxlength="49"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="183"><FONT color="#004080">&nbsp;</FONT></TD>
		<TD width="233">&nbsp;</TD>
		<TD width="67">&nbsp;</TD>
		<TD width="272">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080">Correo Electrónico:</FONT></TD>
		<TD colspan="3"><FONT face="Verdana" size="2"><INPUT class="blue600a" name="remitenteCorreo" value="<%=strCorreo %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="183">&nbsp;</TD>
		<TD width="233">&nbsp;</TD>
		<TD width="67">&nbsp;</TD>
		<TD width="272">&nbsp;</TD>
    </TR>
    </TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>
</jsp:useBean>