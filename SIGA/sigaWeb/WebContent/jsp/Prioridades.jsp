<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML>
<HEAD>
<TITLE>Prioridades</TITLE>
<%@ page language="java"contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*,com.meve.sigma.taglib.*,com.meve.sigma.beans.*"%>
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
	String strPrioridad		=	"";
	String strIdArea		=	"";
	String strHexagesimal	=	"";
	String strCreador		=	"";
	String strCreador1		=	"";		
	String strFechaCreacion	=	"";
	String strFechaCreacion2=	"";
	String strAccion		=	"";
	String strEstatus		=	"1";
	String strPrioridades[][]		=	null;
	String strIdPrioridad	=	"";

	String retURI = (request.getParameter("retURI")== null)?"PrioridadesView.jsp":request.getParameter("retURI");
	String strAux = "1a2b3c", strAux2 = "1a2b3c";
	int valida = -2;
	boolean bInsertar		=	false;

	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
	java.util.Date f 				=	new java.util.Date();
	strFechaCreacion 				=	sdf.format(f);
	strFechaCreacion2 				=	strFechaCreacion;

	strCreador1		=	BUsuario.getIdUsuario();
	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
	strIdPrioridad	=	request.getParameter("id_prioridad");
	strAccion		=	request.getParameter("accion");
	
	if(strIdPrioridad != null)
	{
		strPrioridades=ActualizaPrioridad.getPrioridades(strIdPrioridad);
		strPrioridad=strPrioridades[0][0];		
		strIdArea=strPrioridades[0][1];
		strHexagesimal=strPrioridades[0][2];
		strCreador = ActualizaUsuario.NombreUsuario(strPrioridades[0][3]);
		strFechaCreacion2 = strPrioridades[0][4];

		strAux = strPrioridad;
		strAux2 = strIdArea;
	} 
	if(strAccion != null && strAccion.equals("guardar"))
	{
		strPrioridad	=	request.getParameter("prioridad");
		strIdArea		=	request.getParameter("prioridadArea");
		strHexagesimal	=	request.getParameter("prioridadHexa");

		strAux	=	request.getParameter("aux");
		strAux2	=	request.getParameter("aux2");

		// Delimitación de la longitud de los campos de acuerdo a la Base de Datos. Prioridades
		strPrioridad	=	(strPrioridad.length()<= 200) ? strPrioridad : strPrioridad.substring(0,200);

		valida = ActualizaPrioridad.getPrioridadExiste(strPrioridad, strAux, strIdArea, strAux2);	

		if (valida == 2){
			bInsertar	=	ActualizaPrioridad.InsertarPrioridad(	strIdPrioridad, strPrioridad, strIdArea, strHexagesimal,
																	strCreador1, strFechaCreacion, strEstatus);
%>
<SCRIPT language=JavaScript type=text/javascript>
{
	location.assign('<%= retURI %>');
}
</SCRIPT>
<%
		}
	}
%>
<% if(strIdPrioridad!=null && strIdPrioridad.length()!=0){ %>
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


function guardarPrioridad() { 

	doc = document.Prioridad;
	
	//valida = 0;
	msg="";

//	else 	{
		mensaje = 'Algunos de los campos tienen caracteres invalidos (&, ", <, >, \' )\nPresione Aceptar para eliminarlos automaticamente\no Cancelar para regresar'
		if(detectaCE(doc.prioridad.value)){
			if (confirm(mensaje)){

				doc.prioridad.value	= quitaCE(doc.prioridad.value);
	
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
	if (doc.prioridadArea[doc.prioridadArea.selectedIndex].value == -1) {
		valida =1;
		msg = msg + " Debes seleccionar una Unidad	"+ "\n";
	}
	if (Trim(doc.prioridad.value) =="") {
		valida =1;
		msg = msg + " Debes capturar el nombre de la Prioridad	"+ "\n";
	}
	if (Trim(doc.prioridadHexa.value) =="") {
		valida =1;
		msg = msg + " Debes seleccionar un Color para la Prioridad	"+ "\n";
	}
	if (Trim(quitaPuntos(doc.prioridad.value)) =="" && doc.prioridad.value!="") {
		valida =1;
		msg = msg + " La Prioridad no es válida"+ "\n";
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

function limpiarCampos(){
	document.Prioridad.reset();
}

</SCRIPT>
<script type="text/javascript" src="../js/domapi/core_c.js"></script>
  <script type="text/javascript">
    core.loadUnit("colorpicker");
    onload=function(){
	<%if(strHexagesimal!=null){%>
      elm1=Colorpicker({x:450,y:355,kind:0,c:"<%=strHexagesimal%>"});
	<%} else {%>
	elm1=Colorpicker({x:450,y:355,kind:0});
	<%}%>
      //label1=core.createElm(null,250,70);
     /* elm1.onbeforechange=function(c){
        return c="";
      };*/
	  elm1.onchange=function(){
			color = elm1.value;
			valcolor = 0;
			if(color.length!=7){
				valcolor = 1;
			}
			if(color.charAt(0)!='#'){
				valcolor = 1;
			}
			for(i=1; i<color.length; i++){
				if(	color.charAt(i)!='0' && color.charAt(i)!='1' && color.charAt(i)!='2' && color.charAt(i)!='3' && color.charAt(i)!='4' && 
					color.charAt(i)!='5' && color.charAt(i)!='6' && color.charAt(i)!='7' && color.charAt(i)!='8' &&	color.charAt(i)!='9' && 
					color.charAt(i)!='a' && color.charAt(i)!='b' && color.charAt(i)!='c' && 
					color.charAt(i)!='d' && color.charAt(i)!='e' && color.charAt(i)!='f' && 
					color.charAt(i)!='A' && color.charAt(i)!='B' && color.charAt(i)!='C' && 
					color.charAt(i)!='D' && color.charAt(i)!='E' && color.charAt(i)!='F' ){
					valcolor = 1;
				}
			}
			if (valcolor==1){
				alert("El numero Hexagecimal no es válido");
				elm1.value="#FFFFFF";
			}
			window.document.forms[0].prioridadHexa.value=elm1.value;
		};
      elm1.onchange();
      //elm1.dropBtn.onclick();
      // ---- relative test
     // Colorpicker({parent:core.getElm("t1").rows[1].cells[1]});
     // exampleInit();
     // elm1.attachToForm(f,"elm1_value");
    }
  </script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="valida=0;timer_load();limpiarCampos();" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM action="Prioridades.jsp" name="Prioridad" method="post">
<INPUT type="hidden" value="" name="accion">
<%if (strIdPrioridad!=null){ %>
<INPUT type="hidden" value="<%=strIdPrioridad %>" name="id_prioridad"><%}%>
<INPUT type="hidden" value="<%=strAux %>" name="aux">
<INPUT type="hidden" value="<%=strAux2 %>" name="aux2">
<INPUT type="hidden" value="<%=retURI %>" name="retURI">
<BR>
<DIV align="center">
<BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
<TBODY>

	<TR valign="top">
		<TD colspan="2">
			<a href="<%= retURI %>">
			<IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar">
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a onclick="guardarPrioridad()">
			<img src="../Imagenes/Save.gif" title="Guardar">
			</a>
		</TD>
    </TR>

        <TR valign="top">
            <TD width="20%"><B><FONT face="Verdana" color="#00204f" size="2"><FONT
				size="+1" color="#004080">Prioridades</FONT></FONT></B></TD>
            <TD width="80%" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
        </TR>
        <TR valign="top">
			<td bgcolor="#004080" colspan="2"><img
			src="../Imagenes/shim.gif" width="1" height="2" title=""></td>
		</TR>

	<TR valign="top">
		<TD width="144">
			<FONT face="Verdana" size="2">&nbsp;</FONT>
		</TD>
		<TD width="528" align="right">
			<FONT face="Verdana" size="2">
				<%=(strIdPrioridad!=null && !strIdPrioridad.equals(""))?"Última modificación por: ":"Creado por: "%><I><%= strCreador %> - <%= strFechaCreacion2 %></I></FONT>
		</TD>
	</TR>
		<TR valign="top">
			<TD width="144"><BR>
			<BR>
			</TD>
			<TD width="528"></TD>
		</TR>
		<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Unidad
			Administrativa:</B></FONT></TD>
		<TD width="528">
			<FONT face="Verdana" size="2">
				<% if(BUsuario.getSupervisor()){ 
					if(strIdPrioridad==null){
						strIdArea = BUsuario.getIdArea();
					} 
			%>
				<meve_combo:comboseleccion data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" 
					name="prioridadArea" classHtml="blue600a" 
					selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<% }else{ %>
				<meve_combo:comboseleccion data="<%=ComboData.getAreasComboAll()%>" size="1" 
					name="prioridadArea" classHtml="blue600a" 
					selected="<%= strIdArea %>" 
					textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ " 
					valorNoSeleccion="-1" 
					script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>
				<% } %>
			</FONT>
		</TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="528">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080"><B>Prioridad:</B></FONT>
		<%if (valida == 1) {%><br>
		<FONT color="red"><B>*Esta Prioridad ya existe* </B></FONT><%} %>
		</TD>
		<TD width="528"><FONT face="Verdana" size="2"><INPUT class="blue600a" name="prioridad"  value="<%= strPrioridad  %>" maxlength="199"></FONT></TD>
    </TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="528">&nbsp;</TD>
    </TR>
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2" color="#004080">No. Hexagecimal</FONT></TD>
		<TD width="528"><FONT face="Verdana" size="2"><INPUT class="blue600a" name="prioridadHexa" value="<%=strHexagesimal %>" type="hidden"></FONT></TD>
        </TR>
    </TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>