<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Instrucciones</TITLE>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.taglib.*,com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"%>
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
	String stridInstruccion = "";
	String strInstruccion = "";
	String strIdArea = "";
	String strfecha = "";
	String strfecha2 = "";
	String strCreador = "";
	String strCreador1 = "";
	String strAccion = "";
	stridInstruccion	=	(request.getParameter("id_inst") != null)?request.getParameter("id_inst"):"";
	strAccion = request.getParameter("accion");

	String retURI = (request.getParameter("retURI")== null)?"InstruccionesView.jsp":request.getParameter("retURI");
	String strAux = "1a2b3c", strAux2 = "1a2b3c"; 
	int valida = -2;

	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f = new java.util.Date();
	strfecha = sdf.format(f);
	strfecha2 = strfecha;

	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);

	if(stridInstruccion != null && stridInstruccion.trim().length()>0)
	{
		String strInst[][] = com.meve.sigma.reportes.ActualizaInst.getInstrucciones(stridInstruccion);
		strIdArea = strInst[0][0];
		strInstruccion = strInst[0][1];
		strCreador	=	ActualizaUsuario.NombreUsuario(strInst[0][2]);
		strfecha2	=	strInst[0][3];

		strAux = strInstruccion;
		strAux2 = strIdArea;
	}
	
	if(strAccion!=null && strAccion.trim().length()>0)
	{
		if(strAccion != null && strAccion.equals("guardar"))
		{
			strIdArea = request.getParameter("instArea");
			strInstruccion = request.getParameter("instDescripcion");  

			valida = com.meve.sigma.reportes.ActualizaInst.getInstruccionExiste(strInstruccion, strAux, strIdArea, strAux2);	

			if (valida == 2){
				boolean b = com.meve.sigma.reportes.ActualizaInst.getInsertaInstruccion(strIdArea, strInstruccion,
															BUsuario.getIdUsuario(), strfecha);
				boolean c = ActualizaBitacora.InsertarEventoAltaInstruccion(BUsuario.getIdUsuario(),strInstruccion,strIdArea);
				try{
					//response.sendRedirect("InstruccionesView.jsp");
					response.sendRedirect(retURI);
				}catch(java.io.IOException io){
					//System.out.println("Error-->"+io);
				}
			}
		}
		else if(strAccion != null && strAccion.equals("cambiar"))
		{
			strIdArea = request.getParameter("instArea");
			strInstruccion = request.getParameter("instDescripcion"); 
			stridInstruccion = request.getParameter("id_inst"); 
			strAux 	= request.getParameter("aux"); 
			strAux2 = request.getParameter("aux2"); 

			valida = com.meve.sigma.reportes.ActualizaInst.getInstruccionExiste(strInstruccion, strAux, strIdArea, strAux2);	

			if (valida == 2){

				String datos[][] = com.meve.sigma.reportes.ActualizaInst.getInstrucciones(stridInstruccion);
				boolean c = com.meve.sigma.reportes.ActualizaInst.getActualizarInstruccio(stridInstruccion, strIdArea,
						 strInstruccion, BUsuario.getIdUsuario(), strfecha);

				boolean d = ActualizaBitacora.InsertarEventoCambioInstruccion(BUsuario.getIdUsuario(),strInstruccion,strIdArea,stridInstruccion,datos);	

				try{
					//response.sendRedirect("InstruccionesView.jsp");
					response.sendRedirect(retURI);
				}catch(java.io.IOException io){
					//System.out.println("Error-->"+io);
				}
			}
		}	
	}
%>
<% if(stridInstruccion!=null && stridInstruccion.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<SCRIPT language=JavaScript type=text/javascript>
	function limpiarCampos(){
		document.InstruccionesCat.reset();
	}
</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="valida=0;timer_load();limpiarCampos();" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="Instrucciones.jsp" name="InstruccionesCat" method="post">
<INPUT type=hidden value="<%= strAccion %>" name="accion"> 
<INPUT type=hidden value="<%=stridInstruccion%>" name="id_inst">
<INPUT type=hidden value="<%=strAux%>" name="aux">
<INPUT type=hidden value="<%=strAux2%>" name="aux2">
<INPUT type=hidden value="<%=retURI%>" name="retURI">
<BR>
<BR>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>

		<TR valign="top">
			<TD colspan="2"><A href="<%= retURI %>"> <IMG
				border="0" src="../Imagenes/NavLeft.gif" title="Regresar"></A>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a onclick="guardarInst()">
				<img src="../Imagenes/Save.gif" title="Guardar">
				</a>
			</TD>
		</TR>

		<TR valign="top">
			<TD width="190"><B><FONT face="Verdana" color="#00204f"
				size="2"><FONT color="#00204f" size="37777777777"><FONT
				color="#00204f" size="37777777777"><FONT size="+1" color="#004080">Instrucciones</FONT></FONT></FONT></FONT></B></TD>
			<TD align="right" >&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TH width="190" ></TH>
			<TH align="right" width="490"></TH>
			<TD></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TH width="190" height="0"></TH>
			<TH align="right" width="490" height="0"></TH>
			<TD height="0"></TD>
		</TR>
		<TR valign="top">
			<TD width="190" height="28"></TD>
			<TD align="right" ><FONT face="Verdana" size="2"><I>
				<%=(stridInstruccion!=null && !stridInstruccion.equals(""))?"Última modificación por: ":"Creado por: "%><%= strCreador %> - <%= strfecha2 %></I></FONT></TD>
			<TD height="28"></TD>
		</TR>

		<TR valign="top">
			<TD width="154"><BR>&nbsp;</TD>
			<TD align="right" width="444">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="154"><FONT face="Verdana" size="2" color="#004080"><B>Unidad
			Administrativa:</B></FONT></TD>
			<% if(BUsuario.getSupervisor()){ 
				if(stridInstruccion.equals("")){
					strIdArea = BUsuario.getIdArea();
				} %>
			<TD width="444"><FONT face="Verdana" size="2"> <meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="instArea"
				classHtml="blue600a" selected="<%= strIdArea %>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/> </FONT></TD>
			<% }else{ %>
			<TD width="528"><FONT face="Verdana" size="2"> <meve_combo:comboseleccion
				data="<%=ComboData.getAreasComboAll()%>" size="1" name="instArea"
				classHtml="blue600a" selected="<%= strIdArea %>"
				textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
				valorNoSeleccion="-1" 
				script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/> </FONT></TD>
			<% } %>
		</TR>
		<TR valign="top">
			<TD width="154">&nbsp;</TD>
			<TD width="444">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="154"><FONT face="Verdana" size="2" color="#004080"><B>Instrucción:</B></FONT>
			<%if (valida == 1) {%><br>
			<FONT color="red"><B>*Esta Instrucción ya existe* </B></FONT><%} %>
			</TD>
			<TD width="444"><FONT face="Verdana" size="2"><INPUT class="blue600a"
				name="instDescripcion"  value="<%=strInstruccion%>" maxlength="199"></FONT></TD>
		</TR>
		<TR valign="top">
			<TD width="154">&nbsp;</TD>
			<TD width="444">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV></FORM>
<SCRIPT language="JavaScript" type="text/javascript">
<!-- 
function guardarInst() { 
	var doc = document.InstruccionesCat
	//var valida = 0;
	var msg="";

//	if (valida != 1)	{
		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \', `, ´)\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.instDescripcion.value)){
			if (confirm(mensaje)){

				doc.instDescripcion.value	= quitaCE(doc.instDescripcion.value);
	
				doc.aux.value	= quitaCE(doc.aux.value);
				
				if(doc.id_inst.value != "")
					doc.accion.value="cambiar";
				if(doc.id_inst.value == "")
					doc.accion.value="guardar";
//				doc.submit();
			}
			else 
				doc.accion.value="";
		}
		else{
			if(doc.id_inst.value != "")
				doc.accion.value="cambiar";
			if(doc.id_inst.value == "")
				doc.accion.value="guardar";
//			doc.submit();
		}
//	}
	if (doc.instArea[doc.instArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Unidad  "+ "\n";
	}
	if (Trim(doc.instDescripcion.value) =="") {
		valida =1;
		msg = msg + " Debe capturar el nombre de una Instrucción"+ "\n";
	}
	if (Trim(quitaPuntos(doc.instDescripcion.value)) =="" && doc.instDescripcion.value!="") {
		valida =1;
		msg = msg + " El Nombre de la Instrucción no es válido"+ "\n";
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
</SCRIPT>

</BODY>
</HTML>
