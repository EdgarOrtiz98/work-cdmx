<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Días Festivos</TITLE>
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
		String recCreador[][] 	= null;
		String recDiaFestivo[][]= null;
		String strIdDiaFestivo 	= "";
		String strFecha			= "";
		String strDescripcion	= "";
		String strCreador 		= "";
		String strCreador1 		= "";
		String strFechaCreacion = "";
		String strFechaCreacion2= "";
		String strAccion 		= "";
		String strEstatus 		= "1";

		String strFecha2 = "01/01/0001";
		String retURI = (request.getParameter("retURI")== null)?"DiasFestivosView.jsp":request.getParameter("retURI");

		boolean bInsertar = false;
		boolean bActualizar = false;
		boolean bFormato = true;

		int valida = -2;
		Vector finesSemana = com.meve.sigma.util.Utilerias.getFinesSemana(1,1);

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
		//java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-mm-dd");
		java.util.Date f = new java.util.Date();
		strFechaCreacion 	= sdf.format(f);
		strFechaCreacion2 	= strFechaCreacion;
		
		strCreador1 = 	BUsuario.getIdUsuario();
		strCreador	=	ActualizaUsuario.NombreUsuario(strCreador1);
		
		strAccion 	= 	request.getParameter("accion");
		
		if (strAccion != null && strAccion.equals("consultar")) {
			strIdDiaFestivo = request.getParameter("DiaFestivo_IdDiaFestivo");
			if (strIdDiaFestivo != null) {
				recDiaFestivo 	= ActualizaDiaFestivo.getDiaFestivo(strIdDiaFestivo);
				strFecha 		= recDiaFestivo[0][1];
				strDescripcion 	= recDiaFestivo[0][2];
				strCreador		= ActualizaUsuario.NombreUsuario(recDiaFestivo[0][3]);
				strFechaCreacion2 = recDiaFestivo[0][4];
				strFecha2 		= strFecha;
			}
		}
		if (strAccion != null && strAccion.equals("cambiar")) {
			strIdDiaFestivo = request.getParameter("DiaFestivo_IdDiaFestivo");
			if (strIdDiaFestivo != null) {
				strFecha 		= request.getParameter("DiaFestivo_Fecha");
				strDescripcion 	= request.getParameter("DiaFestivo_Descripcion");
				strFecha2 		= request.getParameter("Fecha2");

				valida = ActualizaDiaFestivo.getDiaFestivoExiste(strFecha, strFecha2);
				//out.print("----------- "+valida+" -------------");
				if (valida == 2){
					String datos[][] = ActualizaDiaFestivo.getDiaFestivo(strIdDiaFestivo);
					bInsertar 		= ActualizaDiaFestivo.ActualizarDiaFestivo(strIdDiaFestivo,
							strFecha, strDescripcion, strCreador1, strFechaCreacion);
					boolean c = ActualizaBitacora.InsertarEventoCambioDia(BUsuario.getIdUsuario(),strFecha,strIdDiaFestivo,datos);
					//out.print("----------- "+c+" -------------");
					bFormato = bInsertar;
				}
			}
		}

		if (strAccion != null && strAccion.equals("guardar")) {
			strFecha 		= request.getParameter("DiaFestivo_Fecha");
			strDescripcion 	= request.getParameter("DiaFestivo_Descripcion");

			valida = ActualizaDiaFestivo.getDiaFestivoExiste(strFecha, strFecha2);

			if (valida == 2){
				bInsertar 		= ActualizaDiaFestivo.InsertarDiaFestivo(strFecha, strDescripcion,
									strCreador1, strFechaCreacion, strEstatus);
				boolean c = ActualizaBitacora.InsertarEventoAltaDia(BUsuario.getIdUsuario(),strFecha);

				bFormato = bInsertar;

	//			strFecha		= "";
	//			strDescripcion 	= "";
			}
		}
		//recCreador  = ActualizaUsuario.getUsuario(strCreador1);
		//strCreador	= recCreador[0][0];
		if(strAccion!=null && (strAccion.equals("cambiar") || strAccion.equals("guardar")) && bInsertar)
		{
			strAccion 			= "";
%>
<SCRIPT language=JavaScript type=text/javascript>
	location.assign("<%= retURI %>");
</SCRIPT>
<%
		}
%>
<% if(!BUsuario.getAdmon()){ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<META name="GENERATOR" content="IBM WebSphere Studio">
<LINK rel="stylesheet" type="text/css" href="../theme/Master.css">
<LINK rel="stylesheet" type="text/css" href="../css/menu.css">
<script type="text/javascript" src="../js/menu.js"></script>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>
	function limpiarCampos(){
		document.DiaFestivo.reset();
	}

</SCRIPT>
<script type="text/javascript">
<!--
	function validaFechaFinesSem(campoFecha){

		var valida = 0 
	<%	for (int ik=0; ik<finesSemana.size(); ik++){ %>	
		if (campoFecha != null && campoFecha.value == "<%= (String)finesSemana.get(ik) %>") {
			valida =1;
		}
	<%	} %>
		if (valida == 1){
			alert("La fecha seleccionada no es laborable");
			campoFecha.value = "";
		} 
	}
//-->
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="valida=0;timer_load();limpiarCampos();" onKeyPress="timer_reload()" 
	onClick="timer_reload()"
	onMouseMove="validaFecha();limitaTextArea(document.DiaFestivo.DiaFestivo_Descripcion,'Comentario','200');
		validaFechaFinesSem(document.DiaFestivo.DiaFestivo_Fecha);">

<FORM action="DiasFestivos.jsp" name="DiaFestivo" method="post">
<INPUT type="hidden" name="accion" value="guardar">
<INPUT type="hidden" name="DiaFestivo_IdDiaFestivo" value="<%=strIdDiaFestivo%>">
<INPUT type="hidden" name="Fecha2" value="<%=strFecha2%>">
<INPUT type="hidden" name="retURI" value="<%=retURI%>">
<CENTER>
<BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>

		<TR valign="top">
			<TD colspan="2"><A href="<%= retURI %>"> <IMG
				border="0" src="../Imagenes/NavLeft.gif" title="Regresar"
				title="Regresar"> </A>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a onclick="guardar()">
				<img src="../Imagenes/Save.gif" title="Guardar">
				</a>
			</TD>
		</TR>

	<TR valign="top">
		<TD width="336" colspan="2">
			<FONT color="#00204f" size="37777777777"><B><FONT size="+1" color="#004080">Días Festivos</FONT></B></FONT><FONT></FONT>
		</TD>
		<TD width="53">&nbsp;</TD>
		<TD align="right" width="355">&nbsp;<FONT color="black">**Los datos
			marcados con negritas son obligatorios</FONT></TD>
    </TR>
	<TR valign="top">
		<td bgcolor="#004080" colspan="4"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD colspan="3">
			<DIV align="right">
				<FONT face="Verdana" color="#002100" size="2"><I></I></FONT><FONT
				face="Verdana" size="2">
					<%=(strIdDiaFestivo!=null && !strIdDiaFestivo.equals(""))?"Última modificación por: ":"Creado por: "%><I><%= strCreador %> - <%= strFechaCreacion2 %></I></FONT>
			</DIV>
    	</TD>
    </TR>
		<TR valign="top">
			<TD width="144"><BR>
			<BR></TD>
			<TD width="192"></TD>
			<TD width="53"></TD>
			<TD width="355"></TD>
		</TR>
		<TR valign="top">
		<TD width="144">
			<FONT face="Verdana" size="2" color="#004080"><B>Día Festivo:</B></FONT><FONT
				color="#004080"></FONT>
			<%if (valida == 1) {%><br>
			<FONT color="red"><B>*Este día festivo ya existe* </B></FONT><%} %>
		</TD>
		<TD colspan="3">
		<% if (strAccion != null && (strAccion.equals("cambiar") || strAccion.equals("consultar"))){%>
			<FONT face="Verdana" size="2">
				<INPUT type="text" size="5" name="DiaFestivo_Fecha" maxlength="10" class="blue100a" value="<%=strFecha%>" readonly>
			</FONT>
		<%} else { %>
			<FONT face="Verdana" size="2">
				<INPUT type="text" size="5" name="DiaFestivo_Fecha" maxlength="10" class="blue100a" value="<%=strFecha%>"
					onblur="validaFormatFecha();" onKeyPress="AceptaSoloTeclaNumericaYDiagonal();"
					onKeyUp = "validaFecha();">
			</FONT>
			<A><IMG height="20" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='show_calendar("forms[0].DiaFestivo_Fecha");'></A><BR>
			<%if (!bFormato || valida == -1) {%><br>
			<FONT color="red"><B>*El formato de la fecha no es correcto* </B></FONT><%} %>
		<% } %>
        </TD>      
        </TR>
<TR valign="top">
<TD width="144">&nbsp;</TD>
<TD width="192">&nbsp;</TD>
<TD width="53">&nbsp;</TD>
<TD width="355">&nbsp;</TD>
        </TR>
<TR valign="top">
<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Descripción: </B></FONT></TD>
<TD colspan="3">
	<TEXTAREA name="DiaFestivo_Descripcion" rows="3" cols="65" 
		onmousemove="limitaTextArea(document.DiaFestivo.DiaFestivo_Descripcion,'Descripción','200')"
		class="blue600a"><%=strDescripcion%></TEXTAREA> 
</TD>
        </TR>
<TR valign="top">
<TD colspan="4">&nbsp;</TD>
        </TR>
    </TBODY>
</TABLE>
</CENTER>
</FORM>
<SCRIPT language="JavaScript" type="text/javascript">
<!-- 
function guardar() {
	var doc = document.forms[0]
	//var valida = 0;
	var msg="";

//	if (valida != 1){

		mensaje = 'Algunos de los campos tienen caracteres invalidos (`, ´, &, ", <, >, \')\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.DiaFestivo_Fecha.value) || detectaCE(doc.DiaFestivo_Descripcion.value)){
			if (confirm(mensaje)){

				doc.DiaFestivo_Fecha.value	= quitaCE(doc.DiaFestivo_Fecha.value);
				doc.DiaFestivo_Descripcion.value	= quitaCE(doc.DiaFestivo_Descripcion.value);
				doc.Fecha2.value	= quitaCE(doc.Fecha2.value);
				
				if(doc.DiaFestivo_IdDiaFestivo.value != "")
					doc.accion.value="cambiar";
				if(doc.DiaFestivo_IdDiaFestivo.value == "")
					doc.accion.value="guardar";
//				doc.submit();
			}
			else 
		doc.accion.value="";
		}
		else{
			if(doc.DiaFestivo_IdDiaFestivo.value != ""){
				doc.accion.value="cambiar";
			}
			if(doc.DiaFestivo_IdDiaFestivo.value == "")
				doc.accion.value="guardar";
//			doc.submit();

		}
//	}
//	doc.submit();
//	alert(doc.DiaFestivo_Descripcion.value);
	if (Trim(doc.DiaFestivo_Fecha.value) =="") {
		valida =1;
		msg = msg + " Debe capturar la Fecha"+ "\n";
	}
	if (Trim(doc.DiaFestivo_Descripcion.value) =="") {
		valida =1;
		msg = msg + " Debe capturar la Descripción del Día Festivo"+ "\n";
	}
	if (Trim(quitaPuntos(doc.DiaFestivo_Descripcion.value)) =="" && doc.DiaFestivo_Descripcion.value!="") {
		valida =1;
		msg = msg + " La Descripción no es válida"+ "\n";
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

function validaFormatFecha(){

	fecha = document.DiaFestivo.DiaFestivo_Fecha.value;	
	mes	 =	fecha.substring(3, 5); 
	dia	 =	fecha.substring(0, 2); 
   	anio =	fecha.substring(6,10);     

	bandera=false;
	if (Trim(fecha) != ""){
		if(fecha.length != 10){
			bandera=true;
		}
		if(fecha.charAt(2) != '/' || fecha.charAt(5) != '/'){
			bandera=true;
		}
		if(mes>12 || mes<1){
			bandera=true;
		}
		else{
			if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
				if (dia<1 || dia>31)
					bandera=true;
			}
			else{
				if (dia<1 || dia>30)
					bandera=true;
			}
			if(mes==2 && anio%4==0){
				if (dia<1 || dia>29)
					bandera=true;
			}
			if(mes==2 && anio%4!=0){
				if (dia<1 || dia>28)
					bandera=true;
			}
		}		
		if(bandera){
		alert("El formato de la Fecha es invalido");
		document.DiaFestivo.DiaFestivo_Fecha.value = "";
		}
	}
}

function validaFecha(){

	accion = "<%= strAccion%>";
	//alert(accion);
	fecha = document.DiaFestivo.DiaFestivo_Fecha.value;	

	if (fecha.length >= 10 && accion != "cambiar" && accion != "consultar"){	

		today = new Date();
		day   = "" + today.getDate();
		month = "" + (today.getMonth() + 1);
		year  = "" + today.getFullYear();

		if (day.length == 1)
			day = "0" + day;
		if (month.length == 1)
			month = "0" + month;

		fechaActual = day + "/" + month + "/" + year;
		//alert(comparaFechas(fecha,fechaActual));

		if (comparaFechas(fecha,fechaActual)==-1){
			alert("La Fecha debe ser mayor o igual a la actual: " + fechaActual);
			document.DiaFestivo.DiaFestivo_Fecha.value = "";
		}
	}
}
</SCRIPT>
</BODY>
</HTML>