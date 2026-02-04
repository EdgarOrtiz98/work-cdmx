<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="meve_front" prefix="meve_front"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.servlet.*"
	import="com.meve.sigma.actualiza.*"
	import="com.meve.sigma.beans.*"
        import="java.io.*"
%>
<%
	
	String strIdAsunto = request.getParameter("IdAsunto");
	String strSeguridad= request.getParameter("bo");
	String strEstatus = request.getParameter("est");
	String strMessage = (request.getParameter("mess")==null)?"":request.getParameter("mess");
	String strName = (request.getParameter("name")==null)?"":request.getParameter("name");
	String srtExcp = (request.getParameter("excp")==null)?"":request.getParameter("excp");
	String strIdDoc = (request.getParameter("strIdDoc")==null)?"":request.getParameter("strIdDoc");
	String strFolio = (request.getParameter("fol")==null)?"":request.getParameter("fol");
	String strFolioCarp = (request.getParameter("strFolioCarp")==null)?"":request.getParameter("strFolioCarp");
	String strInstruccion = (request.getParameter("IdInst")== null)?request.getParameter("IdInstruccion"):request.getParameter("IdInst");

	String bInst = (request.getParameter("inst")== null)?"":request.getParameter("inst");
	String strIds_Borrar[] = null;
	String strAccion = request.getParameter("accion");
	strIds_Borrar = request.getParameterValues("archivo");
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	String strIdUsuario =  BUsuario.getIdUsuario();

	
	if(strInstruccion == null || strInstruccion == "" ){
		strInstruccion = "";
	}

	int contar = 0;
	boolean bExisteArchivos = false;
	boolean bExisteArchivoDocS = false;
	boolean bOperacion = false;
	boolean bInsTurno = false;
	String content;
	String nameObject;
	String strMessageAlert = "";
	
	bInst = (bInst == "null")?"":bInst;
	if (bInst== "null"){ bInst = "";}
	

	if(strIdAsunto != null && strIdAsunto.length()> 0 && strInstruccion.length()== 0)
	{	
		bExisteArchivos = ActualizaArchivo.getExisteArchivo(strIdAsunto);//ActualizaArchivo.getExisteArchivoReferencia(strIdAsunto);
		bExisteArchivoDocS = ActualizaArchivo.getExisteArchivoDocS(strIdAsunto);
		if (bInst != null && bInst.length()  > 0 ){
                        strIdUsuario = ActualizaArchivo.getIdDocPrincipalArc(strIdAsunto); 
		}
	}
	else if(strInstruccion!=null && strInstruccion.length() > 0 && strIdAsunto != null){

		bExisteArchivos = ActualizaArchivo.getExisteArchivoInstruccion(strInstruccion);
                bExisteArchivoDocS = ActualizaArchivo.getExisteArchivoInsDocS(strInstruccion);
		if (bInst.length() > 0 ){
			strIdUsuario = ActualizaArchivo.getIdDocPrincipalArc(strIdAsunto); 
		}
                

	}else{
		bExisteArchivos = false;
                }

	if (strAccion != null && strAccion.trim().length() > 0 && strAccion.equals("borrar")) {	

		bOperacion = ActualizaArchivo.deleteArchivo(strIds_Borrar);
		
		
		if(strIdAsunto != null && strIdAsunto.length()> 0 && strInstruccion.length()== 0){	

			bExisteArchivos = ActualizaArchivo.getExisteArchivo(strIdAsunto);
			bExisteArchivoDocS = ActualizaArchivo.getExisteArchivoDocS(strIdAsunto);
			if (bInst != null && bInst.length()  > 0 ){
					strIdUsuario = ActualizaArchivo.getIdDocPrincipalArc(strIdAsunto); 
			}
		}else		
	 		if(strInstruccion!=null && strInstruccion.length() > 0 && strIdAsunto != null){	
				bExisteArchivos = ActualizaArchivo.getExisteArchivoInstruccion(strInstruccion);
				bExisteArchivoDocS = ActualizaArchivo.getExisteArchivoInsDocS(strInstruccion);
				if (bInst.length() > 0 ){
					strIdUsuario = ActualizaArchivo.getIdDocPrincipalArc(strIdAsunto); 
				}
			}else
				bExisteArchivos = false;
	}

	 

	if(srtExcp.startsWith("java.io.FileNotFoundException",0)){

		strMessageAlert =  "El archivo que intentó anexar no se encuentra en la ruta especificada \n" +
					   "o puede que este tratando de subir un archivo sin contenido" ;
	}

	if(srtExcp.equals("ORACLE.FDK.QuotaReached")&& srtExcp.length() > 0 ){

	strMessageAlert = "No se cuenta con espacio suficiente para anexar el archivo." +
					  " Contacte a su administrador";
	}

	if(srtExcp.equals("ORACLE.FDK.ServerError")&& srtExcp.length() > 0 ){

	strMessageAlert = "Ya se ha anexado un archivo con el nombre " + strName ;
	}
	
	if(srtExcp.equals("yaexistearchivo")&& srtExcp.length() > 0 ){

	strMessageAlert = "Ya se ha anexado un archivo con el nombre " + strName ;
	}
	
	if(srtExcp.equals("ORACLE.FDK.SessionError:ORACLE.FDK.SessionNotConnected")&& srtExcp.length() > 0 ){

	strMessageAlert = "Perdida de Conexión OCS" ;
	}

%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<TITLE>Importar Archivos</TITLE>
<SCRIPT language=JavaScript type=text/javascript>
	function Eliminar(){
		doc = document.archivoForm1;
		valida = 0;
		msg="";
		var cadena="";	
		var folio ="";
		var idFolio = "";
		for (var i = 0; i < doc.elements.length; i++) 
		{  
			if (doc.elements[i].type == 'checkbox') 
			{      
				if (doc.elements[i].name == 'archivo') 
				{       
					if (doc.elements[i].checked == true)
					{
						valor = doc.elements[i].value;
						if(valor != "") 
							cadena = cadena +valor + "|";        
					}
				}
			}
		}
		
		for ( var j = 0; j < doc.elements.length; j++){
				if (doc.elements[j].name == "fol"){
					folio =	doc.elements[j].value;
				}
		}

		if (cadena == "") 
			alert("Debe seleccionar un documento");
		else 
		{
			if (confirm("Está usted seguro de que desea borrar el/los documento(s)?")) 
			{    
				 doc.accion.value="borrar";
				 document.forms[0].fol.value = folio;
				 document.forms[0].strIdDoc.value = cadena;
				 
				
				 doc.submit();
				 document.forms[0].fol.value = folio;
				 document.forms[0].strIdDoc.value = cadena;
				 
			} 
			else 
				alert("Su petición de borrado ya fue cancelada");
		}

		//doc.accion.value="borrar";
		//doc.submit();
	}
</SCRIPT>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM name="archivoForm1" action="ImportarAR.jsp" method="post">
<INPUT type="hidden" name="accion" value="borrar">
<INPUT type="hidden" name="IdAsunto" value="<%=strIdAsunto%>">
<INPUT type="hidden" name="IdInstruccion" value="<%=strInstruccion%>">
<INPUT type="hidden" name="fol" value="<%=strFolio%>">
<INPUT type="hidden" name="bo" value="<%=strSeguridad%>">
<INPUT type="hidden" name="est" value="<%=strEstatus%>">
<INPUT type="hidden" name="strIdDoc" value="<%=strIdDoc%>">
<%if(strMessage.equals("s") && strName.length()> 0){%>
<table width="75%" border="0">
  <tr>
    <td width="27">&nbsp;</td>
    <td width="670"><div align="center"><B><font face="Arial" color="#FF0000" size="2"><%=strMessageAlert %></font><B></div></td>
    <td width="24">&nbsp;</td>
  </tr>
</table>
<%} %>
<table>
<% if(strSeguridad.equals("true")){ %>
<tr>
	<%if(strEstatus.equals("0") || strEstatus.equals("1")){%>
	<TD>
		<INPUT type="button" class="blue100" value="Eliminar" onclick="Eliminar()">
	</TD>
	<%}%>
</tr>
<%}%>
<tr>
	<tr>
		<td><B><FONT face="Arial" color="#004080" size="2">Documentos Principales</FONT></B></td>
	</tr>
<%
if(bExisteArchivos){%>
<meve_front:ListaDatos datos="<%=ActualizaArchivo.getArchivos(strIdAsunto, strInstruccion)%>" campo="campo" >
	<%contar++;%>
	<%if(contar==0){%>
	<TR>
		<TD>
		<%
		}else 
                if((contar%3)==1 || (contar%3)==2){
		%>
		<TD>
		<%
		}else 
                if((contar%3)==0){
		%>
	</TR>
	<TR>
		<TD>
		<%
		}
		if(strSeguridad.equals("true"))
		{
		%>
		<%if(strEstatus.equals("0") || strEstatus.equals("1")){%>
		<input type="checkbox" name="archivo" value="<%=campo1%>">
		<%}%>
		<%
		}
                String image= TypeDoc.tipoDoc(campo2); 
		%>
		<a href="../Ver?ida=<%=campo1%>&file=<%=campo2 %>">
		<FONT size = "1" face = "Arial">
		<img src="<%=image%>" border="0" title=""><br>
		<%=campo2%>
		</FONT>
		</a>
		</TD>
		<%if((contar+1)>=ActualizaArchivo.getArchivosReferenciaContent(strIdAsunto, strIdUsuario, strInstruccion).length){		%>
	</TR>
	<%}%>
</meve_front:ListaDatos>
<% }else{ %>
<TD align="center">
	<FONT face="Arial" size="1"><b>No se encontraron archivos que mostrar...</b></FONT>
</TD>
<% } %>
 
<tr>
	<tr>
		<td><B><FONT face="Arial" color="#004080" size="2">Documentos Soporte</FONT></B></td>
	</tr>
<% if(bExisteArchivoDocS){ %>
<meve_front:ListaDatos datos="<%=ActualizaArchivo.getArchivosDocS(strIdAsunto, strInstruccion)%>" campo="campo" >
	<%contar++;%>
	<%if(contar==0){%>
	<TR>
		<TD>
		<%
		}else if((contar%3)==1 || (contar%3)==2){
		%>
		<TD>
		<%
		}else if((contar%3)==0){
		%>
	</TR>
	<TR>
		<TD>
		<%
		}
		if(strSeguridad.equals("true"))
		{
		%>
		<%if(strEstatus.equals("0") || strEstatus.equals("1")){%>
		<input type="checkbox" name="archivo" value="<%=campo1%>">
		<%}%>
		<%
		}
			String image = TypeDoc.tipoDoc(campo2);
		%>	
		<a href="../Ver?ida=<%=campo1%>&file=<%=campo2 %>">
		<FONT size = "1" face = "Arial">
		<img src="<%=image%>" border="0" title=""><br>
		<%=campo2%>
		</FONT>
		</a>
		</TD>
		<%if((contar+1)>=ActualizaArchivo.getArchivosDocS(strIdAsunto, strInstruccion).length){%>
	</TR>
	<%}%>
</meve_front:ListaDatos>
<% }else{ %>
<TD align="center">
	<FONT face="Arial" size="1"><b>No se encontraron archivos que mostrar...</b></FONT>
</TD>
<%} %>
</table>
</FORM>
</BODY>
</HTML>
