<%--
*******************************************************************************
* Copyright (C) 2007 SHCP 
* CGTIyC - alejandro_gavia@hacienda.gob.mx
* 
* $$Archivo 	deleagarInstrucciones.jsp
* $$Revisión 	DARG - Creación del archivo. 
* $$Fecha 	11 Enero 2007
* $$Descripción Formulario que contiene los campos necesarios para la captura
*                modificación y eliminación de instrucciones, de asuntos por 
*                atender.
*                
* 
* Este software es información propietaria y confidencial de la SHCP - CGTIyC. 
*******************************************************************************
--%>
<%@ page import="gob.hacienda.cgtic.siga.*,com.meve.sigma.beans.*"%>
<%@ page import="com.meve.sigma.actualiza.ActualizaUsuario"%>
<%@ page import="com.meve.sigma.util.AsignarArbol"%>
<%@ page import="java.util.Vector"%>
<%@ page import="gob.hacienda.cgtic.siga.util.*"%>

<%
	String rutaBase = application.getInitParameter("RutaBase");
	rutaBase = request.getContextPath();

	UsuarioBean BUsuario = (UsuarioBean) session
			.getAttribute("UsuarioBean");
	Instruccion instruccion = new Instruccion();
	Puestos puesto = new Puestos();
	String idArea = BUsuario.getIdArea();
	String idUsr = BUsuario.getIdUsuario();
	String idAsunto = "";
	String idInstr = "";
	String indexRow = "";

	boolean bEsInformativa = false; //Instrucciones Informativas
	try {
		if (request.getParameter("idAsunto") == null) {
			out
			.println("<font color='#FF0000'>Error: No hay Id de Asunto.</font>");
		} else {
			idAsunto = request.getParameter("idAsunto");
		}
		if (request.getParameter("Instruccion") != null) {
			idInstr = request.getParameter("Instruccion");
		}
		if (request.getParameter("indexRow") != null) {
			indexRow = request.getParameter("indexRow");
		}
	} catch (java.io.IOException io) {
		//System.out.println("io="+io);
	}
	java.util.ResourceBundle labels = java.util.ResourceBundle
			.getBundle("Etiquetas", java.util.Locale.US);

	if (instruccion.getEsInformativa(idInstr))//Instrucciones Informativas
		bEsInformativa = true;
%>

<!--Menu del JSP -->
<br>
<center>
<table width="850">
	<tr>
		<td class="bodyTitle"><%=labels.getString("delega.titulo")%></td>
	</tr>
	<tr>
		<td>
		<table>
			<tr>
				<td class="btnMenu"><img
					src="<%=request.getContextPath()%>/cgtic/img/salir.gif"
					onclick="javascript:salir();"
					title="<%=labels.getString("instr.regresa")%>" id='btnSalir'></td>
				<td class="btnMenu"><img
					src="<%=request.getContextPath()%>/cgtic/img/mas.gif"
					onclick="javascript:insertRow();"
					title="<%=labels.getString("instr.inserta")%>" id='btnInst'></td>
				<td class="btnMenu"><img
					src="<%=request.getContextPath()%>/cgtic/img/menos.gif"
					onclick="javascript:delRow();"
					title="<%=labels.getString("instr.borra")%>" id='btnDel'></td>
				<td class="btnMenu"><img
					src="<%=request.getContextPath()%>/cgtic/img/guardar.gif"
					onclick="javascript:SaveRows();"
					title="<%=labels.getString("instr.guarda")%>" id='btnGuarda'></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td class="bodyTitle">
		<hr width="850" size="2pt" style="color: #004080;">
		</hr>
		</td>
	</tr>
</table>
<form action="<%=rutaBase%>/cgtic" id="actionForm"><input
	type="hidden" id="indexRow" value="<%=indexRow%>" name="indexRow">
<input type="hidden" id="idAsunto" value="<%=idAsunto%>" name="idAsunto">
<input type="hidden" id="idInstr" value="<%=idInstr%>" name="idInstr">
<input type="hidden" id="instStat" value="0" name="instStat"> <input
	type="hidden" id="auto" value="" name="auto"> <input
	type="text" id="dataLine" value="" name="dataLine" size="1"
	onfocus="javascript:dataLineChanged();"
	style="position: absolute; left: -100">
<table class="tableForm" width="850">
	<tr>
		<td colspan="4" align="right"><input type="button" tabindex="7"
			value="<%=labels.getString("instr.nueva")%>"
			onclick="javascript:clearFields();"> <input type="button"
			tabindex="7" value="<%=labels.getString("instr.actualiza")%>"
			onclick="javascript:updateInstr();" id='btnActInst'></td>
	</tr>
	<tr>
		<td class="rowElementTitle"><%=labels.getString("A")%></td>
		<td> <INPUT TYPE=CHECKBOX NAME="B" ID="B" VALUE="1" TABINDEX="1" CHECKED><td>		
								
		<td class="rowElementTitle">&nbsp;</td>
		<td class="rowElementBody"><input type="checkbox" name="R" id="R"			
			checked="0" value="1" tabindex="1" style="visibility: hidden;"></td>
	</tr>
	<tr>
		<td class="rowElementTitle"><br><%=labels.getString("pto")%></td>
		<td class="rowElementBody" colspan="3"><select name="pto"
			id="pto" onchange="javascript:changePuesto(this.value);" tabindex="2">
			<%=puesto.getComboPuestosSubordinados(Items
							.idInstruccionUsuario(idInstr))%>
		</select></td>
	</tr>
	<tr>
		<td class="rowElementTitle">&nbsp;</td>
		<td colspan="3" height="0">
		<div id="iFrmPtoDiv"
			style="posotion: absolute; visibility: hidden; height: 0;"><iframe
			src="<%=rutaBase%>/cgtic/detallePuesto.jsp" height="0" id="iFrmPto"
			scrolling="no" frameborder="0"></iframe></div>
		</td>
	</tr>
	<tr>
		<td class="rowElementTitle"><%=labels.getString("instr")%></td>
		<td class="rowElementBody" colspan="3"><select name="instr"
			id="instr" onchange="javascript:selInstr();" tabindex="3">
			<%=instruccion.getComboInstrucciones(idArea)%>
		</select><input type="button" value="Modificar >>"
			onclick="javascript:modificaInstruccion();" id='btnModIns'
			style="font-size: 8pt"></td>
	</tr>
	<tr>
		<td class="rowElementTitle">&nbsp;</td>
		<td class="rowElementBody" colspan="3"><input name="otraInstr"
			value="" id="otraInstr" size="100" maxlength="100" tabindex="4"
			onkeypress="return soloAlfanumerico(event)"></td>
	</tr>
	<tr>
		<td class="rowElementTitle"><%=labels.getString("ta")%></td>
		<td class="rowElementBody"><select name="ta" id="ta" tabindex="5"
			onchange="javascript:changeTA(this.value);">
			<%
			if (!bEsInformativa) {
			%>
			<option value="0"><%=labels.getString("E")%></option>
			<%
			}
			%>
			<option value="1"><%=labels.getString("I")%></option>
		</select></td>
		<td class="rowElementTitle"><%=labels.getString("tiemp")%> (<%=instruccion.getTiempoEstimado(idAsunto, idInstr)%>)</td>
		<td class="rowElementBody"><input type="text" size="4"
			name="tiemp" tabindex="6" id="tiemp" maxlength="3"
			onkeypress="return soloNumeros(event)"></td>
	</tr>
</table>
</form>
<%
		try {
		if (idAsunto != null || idInstr != null) {
			out
			.println("<iframe id=\"tableInstr\" src=\""
			+ rutaBase
			+ "/cgtic/tablaInstrucciones.jsp?idAsunto="
			+ idAsunto
			+ "&idInstr="
			+ idInstr
			+ "&call=New&tipoTabla=0\" width='852' height='600' frameborder='0'>"
			+ "</iframe>");
		} else {
			out
			.println("<br><center>No hay instruciones relacionadas.</center>");
		}
	} catch (java.io.IOException io) {
		//System.out.println("io="+io);
	}
%> <script type="text/javascript">
    idArea=<%=idArea %>;
    tiempoEstimado = <%=instruccion.getTiempoEstimado(idAsunto, idInstr) %>;    
    tipoAcceso = <%=instruccion.getTipoAcceso(idAsunto, idInstr) %>;    
    //Define el tipo de la tabla a 0, tabla de delegado de instrucciones
    tipoTabla=0;
    clearFields();
</script>