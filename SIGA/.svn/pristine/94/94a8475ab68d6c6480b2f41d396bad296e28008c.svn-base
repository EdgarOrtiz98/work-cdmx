<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*,com.meve.sigma.actualiza.*,java.util.ArrayList,com.meve.sigma.taglib.*"
%>
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
	String strSeleccion		=	""; 
	String strUsuarioSel	=	"";
	String strAreaSel		=	"";
	String strSupervisor	=	"";
	String strOrganigrama	=	"";
	String strAsistente		=	"";

	String strCompanieros[][]		=	null;
	java.util.Stack st = new java.util.Stack();
	String cadenaMandoUsuario[][]	=	null;
	String usuario [][]				=	null;
	String area[][]					=	null;
	String strMiembros[][]			=	null;
	ArrayList subalternosUsuario	=	null;

	strSeleccion	=	request.getParameter("laSeleccion");
	strUsuarioSel	=	request.getParameter("usuarioSeleccionado");
	strAreaSel		=	request.getParameter("areaSeleccionada");
	strOrganigrama	=	request.getParameter("Organigrama");
	if(strSeleccion != null)
		strSeleccion=strSeleccion.toLowerCase();
 
 	boolean existeSeleccion	=	strSeleccion != null;
	
 	String usuarios[][]	=	ActualizaUsuario.getListaUsuarios();
 	String areas[][]	=	ActualizaUsuario.getAreas();
	
	//** Se ejecuta cuando es seleccionado un Usuario
	if(strUsuarioSel != null && strUsuarioSel.length() > 0)
	{
		usuario	=	ActualizaUsuario.getIDUsuarioBean(strUsuarioSel); 
		if(usuario!=null)
		{
			String areaUsuario				=	usuario[0][5];
			String idUsuario				=	usuario[0][0];
			strCompanieros	=	ActualizaUsuario.getCompanierosArea(idUsuario);
			strAsistente	=	strCompanieros[0][8];
			st = ActualizaUsuario.getCadenaDeMandoPara(idUsuario);
			
			subalternosUsuario	=	ActualizaUsuario.getSubalternosDe(idUsuario);
			//UsuarioBean asistenteUsuario	=	ActualizaUsuario.getAsistenteDe(idUsuario);
			
        	int i=0;
        	for(;i<areas.length;i++)
				if(areas[i][0].trim().equalsIgnoreCase(areaUsuario.trim())){
					areaUsuario=areas[i][1];
                	break;
				}
				if(i==areas.length){
           			areaUsuario="Desconocida";
				}
		}
	}

	//** Se ejecuta cuando es seleccionado un Área
	if(strAreaSel != null && strAreaSel.length() > 0)
	{
		area	=	ActualizaArea.getIDArea(strAreaSel);
		strMiembros		=	ActualizaArea.getMiembrosArea(strAreaSel);
		if(area.length != 0)
		{
			strSupervisor	=	area[0][2];
		}else{
			strSupervisor	=	"La UA no tiene un Supervisor asignado";
		}
	}

%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Organigrama</TITLE>
<SCRIPT language="JavaScript" type="text/javascript">
	
	function seleccion(valor)
	{
  		document.laForma.laSeleccion.value=''+valor+'';
  		
  		if(document.laForma.laSeleccion.value=='usuario')
		{
	    	valorSeleccionado=obtenSeleccion(document.laForma.usuarios);
			if(valorSeleccionado == -1){
				alert('Selecciona un Usuario');
			}
			location.assign('Organigrama.jsp?usuarioSeleccionado='+valorSeleccionado);
	  	}
		if(document.laForma.laSeleccion.value=='area')
		{
			valorSeleccionado=obtenSeleccion(document.laForma.areas);
			if(valorSeleccionado == -1){
				alert('Selecciona una Unidad');
			}
			location.assign('Organigrama.jsp?areaSeleccionada='+valorSeleccionado);
	   	}
		if(document.laForma.laSeleccion.value=='organigrama')
		{
			valorSeleccionado = valor;
			location.assign('Organigrama.jsp?Organigrama='+valorSeleccionado);
		}
	}

	function obtenSeleccion(control)
	{
    	if(control.selected)
			return control.value;
		else
    		for(var i=0;i<control.length;i++){

        	if(control[i].selected)
				return control[i].value;
		}
	}

	var digitos=10 //cantidad de digitos buscados 
	var puntero=0 
	var buffer=new Array(digitos) //declaración del array Buffer 
	var cadena="" 

	function buscar_opOR(obj){
		var forma=document.laForma;
	   	var letra = String.fromCharCode(event.keyCode)
	   	if(puntero >= digitos){ 
	    	cadena=""; 
	       	puntero=0; 
	    } 
	   	if (event.keyCode == 13){ 
	    	borrar_buffer(); 
			var cad="";
			if(obj.options[obj.selectedIndex].value!="-1")
			{
				var a = forma.usuarios.value;
				//location.assign('Pasos.jsp?id_area='+a);
				location.assign('Organigrama.jsp?usuarioSeleccionado='+a);
			}
	    } 
	   	else{ 
	       	buffer[puntero]=letra; 
	       	cadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array 
	       	puntero++; 
	
	       	for (var opcombo=0;opcombo < obj.length;opcombo++){ 
	          	if(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ 
	          		obj.selectedIndex=opcombo; 
	        	} 
	       	} 
	    } 
	   	event.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter 
	}
	function borrar_bufferOR(){ 
    	cadena=""; 
    	puntero=0; 
	}

	function buscar_opAR(obj){
		var forma=document.laForma;
	   	var letra = String.fromCharCode(event.keyCode)
	   	if(puntero >= digitos){ 
	    	cadena=""; 
	       	puntero=0; 
	    } 
	   	if (event.keyCode == 13){ 
	    	borrar_buffer(); 
			var cad="";
			if(obj.options[obj.selectedIndex].value!="-1")
			{
				var a = forma.areas.value;
				//location.assign('Pasos.jsp?id_area='+a);
				location.assign('Organigrama.jsp?areaSeleccionada='+a);
			}
	    } 
	   	else{ 
	       	buffer[puntero]=letra; 
	       	cadena=cadena+buffer[puntero]; //armo una cadena con los datos que van ingresando al array 
	       	puntero++; 
	
	       	for (var opcombo=0;opcombo < obj.length;opcombo++){ 
	          	if(obj[opcombo].text.substr(0,puntero).toLowerCase()==cadena.toLowerCase()){ 
	          		obj.selectedIndex=opcombo; 
	        	} 
	       	} 
	    } 
	   	event.returnValue = false; //invalida la acción de pulsado de tecla para evitar busqueda del primer caracter 
	}
	function borrar_bufferAR(){ 
    	cadena=""; 
    	puntero=0; 
	}


</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg"
	onLoad="timer_load()" onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="laForma" action="Organigrama.jsp" method="post">
<input type="hidden" name="laSeleccion" value="">
<input type="hidden" name="usuarioSeleccionado" value="<%=strUsuarioSel%>">
<input type="hidden" name="areaSeleccionada" value="<%=strAreaSel%>">
<input type="hidden" name="Organigrama" value="<%=strOrganigrama%>">
<br>
<DIV align="center">
<TABLE border="1">
	<TR>
		<TD align="center" width="300"><b>Puesto</b></TD>
		<TD align="center" width="300"><b>Unidad Administrativa</b></TD>
		<!-- <TD align="center" width="229"><b>Organigrama</b></TD> -->
		
	</TR>
	<TR align="center">
		<TD align="center" width="300"><meve_combo:comboseleccion
			data="<%= ComboData.getUsuarioCombo() %>" size="1"
			name="usuarios" classHtml="blue300a" selected=""
			textoNoSeleccion=" -- Seleccionar Puesto --" valorNoSeleccion="-1"
			script="onchange=seleccion('usuario') onKeypress='buscar_opOR(this)' onblur='borrar_bufferOR()' onclick='borrar_bufferOR()'" />
		</TD>
		<TD align="center" width="300"><meve_combo:comboseleccion
			data="<%= ActualizaUsuario.getAreas() %>" size="1" name="areas"
			classHtml="blue300a" selected=""
			textoNoSeleccion=" -- Seleccionar Unidad --" valorNoSeleccion="-1"
			script="onchange=seleccion('area') onKeypress='buscar_opAR(this)' onblur='borrar_bufferAR()' onclick='borrar_bufferAR()'" />
		</TD>
		<!-- <TD align="center" rowspan="2" Valign="bottom" width="229">
			<INPUT type="button" value="Organigrama" name="organigramaBtn" onclick="seleccion('organigrama')">
		</TD> -->
	</TR>
</TABLE>
</DIV>
<br>
<% if(strUsuarioSel != null && strUsuarioSel.length() > 0){ %>
<DIV align="center">
<TABLE border="1">
	<tr bgcolor="#00204f">
		<TD align="left" width="696">
			<FONT size="2" face="verdana" color="white"><B>Puesto</B></FONT>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696">
			<FONT face="Verdana" size="2"><%=usuario[0][1]%></FONT>
		</TD>
	</tr>
	<tr bgcolor="#00204f">
		<TD align="left" width="696">
			<FONT size="2" face="verdana" color="white"><B>Unidad Administrativa</B></FONT>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696">
			<FONT face="Verdana" size="2"><%=ActualizaArea.NombreArea(usuario[0][5])%></FONT>
		</TD>
	</tr>
	<tr bgcolor="#00204f">
		<TD align="left" width="696">
			<FONT size="2" face="verdana" color="white"><B>Compañeros de la Unidad</B></FONT>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696">
		<% if(strCompanieros.length > 0){ %>
			<% for(int i=0;i<strCompanieros.length;i++){ %>
			<FONT face="Verdana" size="2">
				<%=strCompanieros[i][1]%>
				<% if(!(i == strCompanieros.length-1)){ %>
				,
				<% } %>
			</FONT>
			<% } %>
		
		<% }else{ %> <FONT face="Verdana" size="2">No tiene Compañeros</FONT>
		<% } %></TD>
	</tr>
	<tr bgcolor="#00204f">
		<TD align="left" width="696">
			<FONT size="2" face="verdana" color="white"><B>Cadena de Mando</B></FONT>
		</TD>
	</tr>
	<tr align="left">
		<TD align="left" width="696">
		<%
			if(st.size() > 0){
			for(int y = 0; y<st.size();y++){
		%>
			<FONT face="Verdana" size="2">
				<% if(st.elementAt(y) != null){ %>
				<%=st.elementAt(y)%>
				<% }%>
			</FONT>
		<%
			}}
		%>
		</TD>
	</tr>
	<tr bgcolor="#00204f">
		<TD align="left" width="696">
			<FONT size="2" face="verdana" color="white"><B>SubAlternos</B></FONT>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696">
		<%
			if(subalternosUsuario.size()>0)
			for(int t=0;t<subalternosUsuario.size();t++){
		%>
			<FONT face="Verdana" size="2">
				<%=subalternosUsuario.get(t)%>
				<% if(!(t==subalternosUsuario.size()-1)){ %>
				,
				<% } %>
			</FONT>
		<%
			}
		%>
		</TD>
	</tr>
	<tr bgcolor="#00204f">
		<TD align="left" width="696">
			<FONT size="2" face="verdana" color="white"><B>Asistente</B></FONT>
		</TD>
	</tr>
	<tr>
		<% if(!strCompanieros[0][8].equals("-1")){ %>
		<td align="left" width="696">
			<FONT face="Verdana" size="2">
				<%=ActualizaUsuario.NombreUsuario(strCompanieros[0][8])%>
			</FONT>
		</td>
		<% }else{ %>
		<TD align="left" width="696">
			<FONT face="Verdana" size="2">** No tiene asignado un Asistente **</FONT>
		</TD>
		<% } %>
	</tr>
</TABLE>
</DIV>
<% } %>
<% if(strAreaSel != null && strAreaSel.length() > 0){ %>
<DIV align="center">
<TABLE border="1">
	<tr bgcolor="#00204f">
		<TD align="left" width="696">
			<FONT size="2" face="verdana" color="white"><B>Responsable de la Unidad</B></FONT>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696">
			<FONT face="Verdana" size="2"><%=strSupervisor%></FONT>
		</TD>
	</tr>
	<tr bgcolor="#00204f">
		<TD align="left" width="696">
			<FONT size="2" face="verdana" color="white"><B>Miembros de la Unidad</B></FONT>
		</TD>
	</tr>
	<tr>
		<TD align="left" width="696">
			<% if(strMiembros.length > 0){ %>
				<% for(int j=0;j<strMiembros.length;j++){ %>
				<FONT face="Verdana" size="2">
					<%=strMiembros[j][0]%>
					<% if(!(j == strMiembros.length-1)){ %>
					,
					<% } %>
				</FONT>
				<% } %>
			<% }else{ %>
				<FONT face="Verdana" size="2">No tiene Puesto registrados en la Unidad</FONT>
			<% } %>
		</TD>
	</tr>
</TABLE>
</DIV>
<% } %>
<% if(strOrganigrama != null && strOrganigrama.length() > 0){ %>
<%
	////System.out.println("** Entra al bloque del organigrama **");
		ArrayList jerarquia = ActualizaUsuario.getOrganigrama();
    	for(int i=0;i<jerarquia.size();i++){
			if(jerarquia.get(i) instanceof ArrayList){

    		ArrayList nivel=(ArrayList)jerarquia.get(i);
        	for(int k=0;k<nivel.size();k++){
        		if(nivel.get(k) instanceof UsuarioBean){
        	    	UsuarioBean usuario1=(UsuarioBean)nivel.get(k);
%>
	<%=(usuario1.getCargo()!=null && usuario1.getCargo().length()>0?usuario1.getCargo():"----")%><br>
	<%=(usuario1.getNombre()!=null && usuario1.getNombre().length()>0?usuario1.getNombre():"----")%><br>
	<%=(usuario1.getIdJefe()!=null && usuario1.getIdJefe().length()>0?usuario1.getIdJefe():"----" )%><br>
	---------------------<br><br>
<% 				}
			}
			}
		}
	}
%>



</FORM>
</BODY>
</HTML>
