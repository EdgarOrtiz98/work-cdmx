<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<jsp:useBean id="Asunto" class="com.meve.sigma.beans.Asunto" scope="page">
	<jsp:setProperty name="Asunto" property="*" />
<%@ page language="java"contentType="text/html; charset=ISO-8859-1"
%>
<%@ page import="com.meve.sigma.beans.*, java.util.*, 
		com.meve.sigma.beans.search.*, 
		com.meve.sigma.actualiza.*"
	import="com.meve.sigma.actualiza.*"
%>
<%
	String strDatosAsuntoAnt[][] = null;
	String strDatosAsuntoAntRef[][] = null; 
	String strIdAsuntoPrimarios	= "";
	String idAsuntoAnt	=	(Asunto.getIdAsuntoAnt()== null)?"":Asunto.getIdAsuntoAnt();
	String idAsuntoRef	=	(Asunto.getIdAsuntoRef()== null)?"":Asunto.getIdAsuntoRef();         
	String strIdAsunto	=	(Asunto.getIdAsuntoRefencia()== null)?"":Asunto.getIdAsuntoRefencia(); 
	String strAccion 	= 	(request.getParameter("strAccion") == null )?"":request.getParameter("strAccion");
	String stridArea	=	"";
	String stridUsuario	=	"";

	strIdAsunto 	=	request.getParameter("strIdAsunto");
	stridArea		=	request.getParameter("idArea");
	stridUsuario	=	request.getParameter("idUs");
	strIdAsuntoPrimarios = strIdAsunto;
	idAsuntoAnt =  request.getParameter("idAsuntoAnt");
	idAsuntoRef =	request.getParameter("idAsuntoRef");

	boolean bValidaEstatus = false;
	String strEstValidacion		=	(request.getParameter("estValidacion")== null)?"":request.getParameter("estValidacion");
	if (strIdAsunto!=null && !strIdAsunto.equals("")){
		if (strEstValidacion.equals("")){
			strEstValidacion = ActualizaAsunto.getEstatus(strIdAsunto);
		}
		String strEstatusValida = ActualizaAsunto.getEstatus(strIdAsunto);
		if (!strEstatusValida.equals(strEstValidacion) || strEstValidacion.equalsIgnoreCase("4")){ 
			bValidaEstatus = true; 
		}
	}

	if (!bValidaEstatus && strAccion.equals("guardar") && strAccion.length()>0){	
		ActualizaAsunto.InsertarAsuntosAnt(strIdAsunto,idAsuntoAnt,idAsuntoRef); %>

<script type="text/javascript">
<!--
		window.opener.document.Asunto.submit();
		window.close();
//-->
</script>

<%	}

	if (!bValidaEstatus && strAccion.equals("borrar") && strAccion.length()>0){

		ActualizaAsunto.EliminarAsuntosAnt(strIdAsunto,idAsuntoAnt,idAsuntoRef);

	}
%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Tipos de Relación</TITLE>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<SCRIPT language=JavaScript type=text/javascript>

	var hay_hija_uno = new Boolean(false);
	var hija_uno = new Object(); 

	function Abrir(){

		var isCenter ='true';
		var features = '';

		if(window.screen)if(isCenter)if(isCenter=="true"){
		    var myLeft = (screen.width-760)/2;
		    var myTop = (screen.height-360)/2;
		    features+=(features!='')?',':'';
		    features+=',left='+myLeft+',top='+myTop; 
		}
		//hija_uno = window.open('BusquedaAsuntoAnt.jsp?idArea=<%=stridArea%>&idAsuntoAntBusca=<%=idAsuntoAnt%>&idAsunto=<%=strIdAsunto%>&idUs=<%=stridUsuario%>','hija_uno',features+((features!='')?',':'')+'width=760, height=360, status=yes');
		//hay_hija_uno = true; 
		location.assign("BusquedaAsuntoAnt.jsp?idArea=<%=stridArea%>&idAsuntoAntBusca=<%=idAsuntoAnt%>&idAsunto=<%=strIdAsunto%>&idUs=<%=stridUsuario%>&idAsuntoRefBusca=" + document.AnexarRef.idAsuntoRef.value + "&estValidacion=<%=strEstValidacion%>");
	}

	function Guardar(){
	
			var form =document.AnexarRef;
			var cadena = "";
			var accion = "guardar";
			var IdValue = "";
		  	var numdoc=0;	
			for (var i = 0; i < form.elements.length; i++) {
		  			if (form.elements[i].name == "RefType") {
		    				valor = form.elements[i].value;
		    				if(valor != ""){
								cadena = cadena + valor  + "|";
		    					numdoc=numdoc + 1;				
							}
				}
			}
			//alert(cadena);
			//if (cadena != ""){
					window.document.forms[0].idAsuntoRef.value = cadena;
					window.document.forms[0].strAccion.value = accion;
			//}
			window.document.AnexarRef.submit();
			//window.opener.document.Asunto.submit();
			//window.close();

	}	

	function Cambio(){
		var form =document.AnexarRef;
		var cadena = "";
		for (var i = 0; i < form.elements.length; i++) {
	  		if (form.elements[i].name == "RefType") {
	    		valor = form.elements[i].value;
	    		if(valor != ""){
					cadena = cadena + valor  + "|";
				}
			}
		}
		form.idAsuntoRef.value = cadena;
	}	

	function EliminarAnex(){
		var form = document.AnexarRef;
  		var cadena = "";
		var IdValue = "";
  		var numdoc=0;
		var cadenaid;
		var seleccionados = 0;

		for (var i = 0; i < form.elements.length; i++) {
    		if (form.elements[i].type == "checkbox") {
      			if (form.elements[i].name == "borrar") {
        			if (form.elements[i].checked == false){
        				valor = form.elements[i].value;
        				if(valor != ""){
							cadena = cadena + valor  + "|";
        					numdoc=numdoc + 1;
							
						}
        			}
      			}
    		}
			if (form.elements[i].name == "borrar") {
        			if (form.elements[i].checked == true){
							seleccionados=seleccionados + 1;
        			}
      			}

		}
		if (seleccionados == "")
			alert("Debe seleccionar un documento"); 
		
		else {	
        		window.parent.document.AnexarRef.idAsuntoAnt.value = cadena;
				window.document.AnexarRef.submit();
		}	

	}

</SCRIPT>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onunload="opener.hay_hija=false;opener.botonBandera=true;" 
		onmouseover="if (hay_hija_uno == true){hija_uno.focus();}" 
		onfocus="if (hay_hija_uno == true){hija_uno.focus();}"
		onclick="opener.timer_reload();"
		onkeypress="opener.timer_reload();" >
<form name="AnexarRef" action="AnexarReferencia.jsp" method="post">
<INPUT type="hidden" value="<%= idAsuntoAnt %>" name="idAsuntoAnt">
<INPUT type="hidden" value="<%= idAsuntoRef %>" name="idAsuntoRef">
<INPUT type="hidden" value="<%= strAccion %>" name="strAccion">
<INPUT type="hidden" value="<%= strIdAsunto %>" name="strIdAsunto">
<INPUT type="hidden" value="<%= stridArea %>" name="idArea">
<INPUT type="hidden" value="<%= stridUsuario %>" name="idUs">
<INPUT type="hidden" value="<%=strEstValidacion%>" name="estValidacion">
<table width="667" border="0">
	<tr>
		<td valign="top" width="83%"><%if (idAsuntoAnt!= null){
		Vector lista = new Vector();
		StringTokenizer tokens=new StringTokenizer(idAsuntoAnt, "|");
		StringTokenizer tokens1=new StringTokenizer(idAsuntoRef, "|");
		int nDatos=tokens.countTokens();
		int nDatos1=tokens1.countTokens();
		String[] datos = new String[nDatos];
		String strDatos[] = new String[nDatos1];	
			int i=0;
			int y =0;
			int x = 0;
			while(tokens.hasMoreTokens()){
				String str=tokens.nextToken();
				datos[i]= str;
				if (lista.contains(datos[i])){
					
				}else{
					lista.add(datos[i]);
				}			        
				i++;
			}
		
		while(tokens1.hasMoreTokens()){
				String str=tokens1.nextToken();
				strDatos[x] = str;
				x++;
			}
	
		
		%>
		<TABLE border="0" width="545">
			<TR bgcolor="#00204f">
				<TH width="30">
				<CENTER><b><FONT size="1" color="white" face="verdana"></FONT></b></CENTER>
				</TH>
				<TH width="153">
				<CENTER><b><FONT size="1" color="white" face="verdana">FOLIO</FONT></b>
				</CENTER>
				</TH>
				<TH width="197">
				<CENTER><b><FONT size="1" color="white" face="verdana">FOLIO
				DOCUMENTO</FONT></b></CENTER>
				</TH>
				<TH width="106">
				<CENTER><b><FONT size="1" color="white" face="verdana">ESTATUS</FONT></b></CENTER>
				</TH>
				<TH width="138">
				<CENTER><b><FONT size="1" color="white" face="verdana">TIPO DE RELACIÓN</FONT></b></CENTER>
				</TH>
			</TR>
		</TABLE>
		<DIV class=documentBody id=Body>
		<TABLE border="0" width="545">
			<%
		String strConsulta[][];
		String strEstato		=	"";
		for (int j = 0; j < lista.size(); j++){			
		strConsulta = ActualizaBuscar.getBusquedaAsuntosAnidados(lista.get(j).toString());
                switch(Integer.parseInt(strConsulta[0][3])){
                    case 0:
                        strEstato = "Recepción";
                    break;
                    case 1:
                        strEstato = "Por Turnar";
                    break;
                    case 2: 
                        strEstato = "Turnado";
                    break;
                    case 3:
                        strEstato = "Terminado";
                    break;
                    default:
                    break;
                }                	
	%>
			<TR>
				<TD width="30">
				<CENTER><INPUT type=checkbox name="borrar"
					value="<%=strConsulta[0][0]%>"></CENTER>
				</TD>
				<TD width="153">
				<CENTER><FONT size="1" color="#000080" face="Arial"> <%= strConsulta[0][1] %></FONT>
				</CENTER>
				</TD>
				<td width="197">
				<CENTER><FONT size="1" color="#000080" face="Arial"><%=strConsulta[0][2]%></FONT>
				</CENTER>
				</td>
				<td width="106">
				<CENTER><FONT size="1" color="#000080" face="Arial"><%= strConsulta[0][3] %></FONT>
				</CENTER>
				</td>
				<td width="138">
				<CENTER><FONT size="1" color="#000080" face="Arial"> 
			<SELECT	NAME="RefType" SIZE="1" onchange="Cambio();">
					<%if (strDatos[j].equals("a")) {%>
			<OPTION VALUE="a" selected="selected">Alcance</OPTION>
			<OPTION VALUE="r">Respuesta</OPTION>
			<OPTION VALUE="f">Referencia</OPTION>
			<%}else %>
				<%if (strDatos[j].equals("r")){%>
			<OPTION VALUE="a">Alcance</OPTION>
			<OPTION VALUE="r" selected="selected">Respuesta</OPTION> 
			<OPTION VALUE="f">Referencia</OPTION>
	         <%}else
				if (strDatos[j].equals("f")){%>
			<OPTION VALUE="a">Alcance</OPTION>
			<OPTION VALUE="r">Respuesta</OPTION> 
			<OPTION VALUE="f" selected="selected">Referencia</OPTION>
   				 <% } %>
				</SELECT> </FONT></CENTER>
				</td>
			</TR>
			<%}%>
		</TABLE>
		</DIV><script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
		<%}%></td>
		<td valign="top" width="17%"><INPUT type="button" class="blue100"
			value="Anexar" onclick="Abrir();"> <br>
		<br>
		<INPUT type="button" class="blue100" value="Eliminar"
			onclick="EliminarAnex();"> <br>
		<br>
		<INPUT type="button" class="blue100" value="Guardar"
			onclick="Guardar();"> <br>
		<br>
		<br>
		<br>
		<INPUT type="button" class="blue100" value="Cancelar"
			onclick="opener.hay_hija=false; Cancelar();"></td>

	</tr>
</table>
<script type="text/javascript">
<!--
if (<%= bValidaEstatus %>){
	//alert("Este Asunto ha sido modificado por otro usuario y cambió su Estatus,\npor lo que la acción solicitada será cancelada");
	window.opener.document.Asunto.submit();
	window.close();
}
//-->
</script>
</form>
</BODY>
</HTML>
</jsp:useBean>