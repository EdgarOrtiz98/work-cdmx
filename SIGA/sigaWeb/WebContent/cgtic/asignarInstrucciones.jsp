<%--
*******************************************************************************
* Copyright (C) 2007 SHCP 
* CGTIyC - alejandro_gavia@hacienda.gob.mx
* 
* $$Archivo 	asignarInstrucciones.jsp
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
<%@ page
	import="gob.hacienda.cgtic.siga.*,com.meve.sigma.beans.*,com.meve.sigma.actualiza.*"%>

<%
	String rutaBase = request.getContextPath();
	UsuarioBean BUsuario = (UsuarioBean) session
			.getAttribute("UsuarioBean");
	Instruccion instruccion = new Instruccion();
	Puestos puesto = new Puestos();
	Unidad unidad = new Unidad();

	String idArea = BUsuario.getIdArea();
	String idUsr = BUsuario.getIdUsuario();
	String idAsunto = "";
	String idInstr = "";
	String indexRow = "";

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
	int tiempoEstimado;
	if (idInstr == null || "".equals(idInstr)) {
		tiempoEstimado = instruccion.getTiempoEstimado(idAsunto);
	} else {
		tiempoEstimado = instruccion.getTiempoEstimado(idAsunto,idInstr);
	}
	java.util.ResourceBundle labels = java.util.ResourceBundle
			.getBundle("Etiquetas", java.util.Locale.US);

	instruccion.updateIntrsExtra(idAsunto);
%>
<!--Menu del JSP -->
<%@page import="com.meve.sigma.util.Utilerias"%>
<br>
<center>
<table width="850">
	<tr>
		<td class="bodyTitle"><%=labels.getString("turnar.titulo")%></td>
	</tr>
	<tr>
		<td>
		<table>
			<tr>
				<td class="btnMenu"><img
					src="<%=rutaBase%>/cgtic/img/salir.gif"
					onclick="javascript:salir();"
					title="<%=labels.getString("instr.regresa")%>" id='btnSalir'></td>
				<td class="btnMenu"><img src="<%=rutaBase%>/cgtic/img/mas.gif"
					onclick="javascript:insertRow();"
					title="<%=labels.getString("instr.inserta")%>" id='btnInst'></td>
				<td class="btnMenu"><img
					src="<%=rutaBase%>/cgtic/img/menos.gif"
					onclick="javascript:delRow();"
					title="<%=labels.getString("instr.borra")%>" id='btnDel'></td>
				<td class="btnMenu"><img
					src="<%=rutaBase%>/cgtic/img/guardar.gif"
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
<form action="<%=rutaBase%>/cgtic/guardaInstruccion.jsp" id="actionForm">
<input type="hidden" id="indexRow" value="<%=indexRow%>" name="indexRow">
<input type="hidden" id="idAsunto" value="<%=idAsunto%>" name="idAsunto">
<input type="hidden" id="idInstr" value="<%=idInstr%>" name="idInstr">
<input type="hidden" id="instStat" value="0" name="instStat"> <input
	type="hidden" id="auto" value="" name="auto"> <input
	type="hidden" name="retURI" value='<%=request.getParameter("retURI")%>' />
<input type="text" id="dataLine" value="" name="dataLine" size="1"
	onfocus="javascript:dataLineChanged();"
	style="position: absolute; left: -100"> <input type="text"
	id="varPtoInst" value="" name="varPtoInst" size="1"
	onfocus="javascript:ptoInstChanged();"
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
		<td class="rowElementBody" width="320" colspan>
		<input type="checkbox" name="B" id="B" checked="1" value="1" tabindex="0"></td>			

		<td class="rowElementTitle">&nbsp;</td>
		<td class="rowElementBody"><input type="checkbox" name="R" id="R"
			checked="0" value="1" tabindex="1" style="visibility: hidden;"></td>
	</tr>
	<tr>
		<td class="rowElementTitle"><br><%=labels.getString("ua")%></td>
		<td class="rowElementBody" colspan="3"><select name="ua" id="ua"
			onchange="javascript:changeUA(this.value);" tabindex="1" size="1"
			style="position: absolute; left: -1000">
			<%=unidad.getComboUnidades()%>
		</select>
		<div id="uaLabel" class="rowElementBody"></div>
		</td>
	</tr>
	<tr>
		<td class="rowElementTitle"><br><%=labels.getString("pto")%></td>
		<td class="rowElementBody" colspan="3"><select name="pto"
			id="pto" onchange="javascript:changePuesto(this.value);" tabindex="2">
			<option value="null" selected="selected">[Seleccionar]</option>
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
			<div id="instrucciones" name="instrucciones">
			   <%=instruccion.getComboInstrucciones(idArea)%>
			</div>
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
		<%
					if (Utilerias.isIdInString(BUsuario.getIdArea(), session
					.getServletContext().getAttribute(
					"app.siga.informativas.tiempo.uas").toString())) {
		%>
		<td class="rowElementBody"><select name="ta" id="ta" tabindex="5"
			onchange="javascript:changeTAEspecial(this.value);">
			<option value="0"><%=labels.getString("E")%></option>
			<option value="1"><%=labels.getString("I")%></option>
		</select></td>
		<%
		} else {
		%>
		<td class="rowElementBody"><select name="ta" id="ta" tabindex="5"
			onchange="javascript:changeTA(this.value);">
			<option value="0"><%=labels.getString("E")%></option>
			<option value="1"><%=labels.getString("I")%></option>
		</select></td>
		<%
		}
		%>
		<td class="rowElementTitle"><%=labels.getString("tiemp")%>(<%=tiempoEstimado%>)</td>
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
			+ "&call=New&tipoTabla=1&filtro=AS\" width='852' height='600' frameborder='0'>"
			+ "</iframe>");
		} else {
			out
			.println("<br><center>No hay instruciones relacionadas.</center>");
		}
	} catch (java.io.IOException io) {
	}
%> <iframe id="iFrmSupport" src="" width='1' height='1' frameborder='0'
	style="position: absolute; top: 200; left: 0; filter: alpha(opacity = 50);">
</iframe> <script type="text/javascript">
    // Establece el tiempo estimado
    tiempoEstimado = <%=tiempoEstimado%>;    
    //Define el tipo de la tabla a 1, tabla de turnado de instrucciones
    tipoTabla=1;
    // Establece el ID de la Unidad Administrativa
    idArea=<%=idArea%>;
	idUsr=<%=idUsr%>;
    clearFields();
</script>