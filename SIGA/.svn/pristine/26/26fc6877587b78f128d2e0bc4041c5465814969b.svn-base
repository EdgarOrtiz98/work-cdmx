<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.beans.*"
%>
<%
boolean bRolUserAdmon;
boolean bRolUserSuper;
UsuarioBean BUsuarioCat = (UsuarioBean)session.getAttribute("UsuarioBean");

if(BUsuarioCat==null){
}else{
		
	bRolUserSuper = BUsuarioCat.getSupervisor();
	bRolUserAdmon = BUsuarioCat.getAdmon();
	String strImagen = application.getInitParameter("Imagen");
	String strFolio = "HelpSIGA";
	String strManual = "manual_siga.pdf";
	String strFqa = "fqa_siga.pdf";
%>
<%@page import="com.meve.sigma.actualiza.ActualizaArea"%>
<HEAD>
<SCRIPT type="text/javascript">
</SCRIPT></HEAD><META http-equiv=Content-Type content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="./css/link.css" />
<script type="text/javascript" src="./js/link.js">

</script> 
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
<script type="text/javascript" src="./js/SigmaJS.js"></script>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
<TBODY>
  	<TR>
    	<TD background=./Imagenes/h1.jpg colspan="2">
      		<TABLE cellSpacing=0 cellPadding=0 width=0 align=right border=0>
        	<TBODY>
        	<TR>
          		<TD>
					<A onmouseover="dropdownmenu(this, event, 'menuHelp')">
						<IMG height=17 src="./Imagenes/L2b1_ayu.jpg" width=75 
            			border=0 name=Image18>
					</A> 
					<div id="menuHelp" class="anylinkcssHelp" style="width: 65px; background-color: lightblue">
						<a href="./DownLoadDicument?fol=<%=strFolio %>&name=<%=strManual %>" target="_blank" >Manual</a>												
						<a href="./DownLoadDicument?fol=<%=strFolio %>&name=<%=strFqa %>" target="_blank" >F.A.Q.</a>
					</div>             
            	</TD>
          		<TD>
					<A onmouseover="MM_swapImage('Image20','','./Imagenes/b1_sal.jpg',1)" 
            			onmouseout=MM_swapImgRestore() 
            			href="jsp/index.jsp" target="_top">
					<IMG height=17 src="./Imagenes/b1_sal.jpg" width=68 
            			border=0 name=Image20>
					</A>
				</TD>
			</TR>
			</TBODY>
			</TABLE>
		</TD>
	</TR>
  	<TR>
    	    <TD background=./Imagenes/fon_head_shcp.jpg> 
               <IMG height=20 src="./Imagenes/header_shcp.jpg" width=771>
            </TD>
		    <TD align="right" background=./Imagenes/fon_head_shcp.jpg><B
				style="color: white;"><%=ActualizaArea.getNombreArea(BUsuarioCat.getIdArea())%>&nbsp;&nbsp;&nbsp;</B>
			</TD>
	</TR>
  	<TR>
    	<TD background=./Imagenes/h2.jpg colspan="2">
      		<TABLE cellSpacing=0 cellPadding=0 width=0 border=0>
        	<TBODY>
        	<TR id="TablaUno">
				<TD>
					<A onmouseover="MM_swapImage('Image49','','./Imagenes/b_inicio.jpg',0)" 
            			onmouseout=MM_swapImgRestore() 
            			href="jsp/portalPrincipal.jsp">
						<IMG height=24 src="./Imagenes/b_inicio.jpg" width=62 border=0 name=Image49>
					</A>
				</TD>
				<%if (bRolUserAdmon == true){ %>
				<TD>
					<A onmouseover="dropdownmenu(this, event, 'anylinkmenu6')">
						<IMG height=24 src="./Imagenes/b_cat.gif" width=84 border=0 name=Image30>
					</A>
					<div id="anylinkmenu6" class="anylinkcss" style="width: 155px; background-color: lightblue">
						<a href="./jsp/Archivado.jsp">Archivado</a>
						<a href="./jsp/AreaView.jsp">Unidades Administrativas</a>
						<a href="./jsp/UsuariosView.jsp">Puestos</a>
						<a href="./jsp/EntidadView.jsp">Entidades</a>
						<a href="./jsp/RemitenteView.jsp">Remitentes</a>
						<a href="./jsp/tramitesView.jsp">Tramites</a>
						<a href="./jsp/TipoDocumentoView.jsp">Tipo de Documentos</a>
						<a href="./jsp/TipoAsuntoView.jsp">Tipo de Asuntos</a>
						<a href="./jsp/PrioridadesView.jsp">Prioridades</a>
						<a href="./jsp/FoliosView.jsp">Folios</a>
						<a href="./jsp/PasosView.jsp">Pasos</a>
						<a href="./jsp/InstruccionesView.jsp">Instrucciones</a>
						<a href="./jsp/RazonesRechazoView.jsp">Razones de Rechazo</a>
						<a href="./jsp/DiasFestivosView.jsp">Días Festivos</a>
						<a href="./jsp/Configuraciones.jsp">Configuracion SIGA</a>
						<a href="ma1.jsp">Migrar Content</a>
					</div>
				</TD>
				<%}%> 
				<%if (bRolUserSuper == true){ %>
				<TD>
					<A onmouseover="dropdownmenu(this, event, 'anylinkmenu6')">
						<IMG height=24 src="./Imagenes/b_cat.gif" width=84 border=0 name=Image30>
					</A>
					<div id="anylinkmenu6" class="anylinkcss" style="width: 155px; background-color: lightblue">
						<a href="./jsp/Archivado.jsp">Archivado</a>
						<a href="./jsp/AreaView.jsp">Unidad Administrativa</a>
						<a href="./jsp/UsuariosView.jsp">Puestos</a>
						<a href="./jsp/EntidadView.jsp">Entidades</a>
						<a href="./jsp/RemitenteView.jsp">Remitentes</a>
						<a href="./jsp/ramitesView.jsp">Tramites</a>
						<a href="./jsp/TipoDocumentoView.jsp">Tipo de Documentos</a>
						<a href="./jsp/FoliosView.jsp">Folios</a>
					</div>
				</TD>
				<%} %>
				<%if (bRolUserAdmon == true){ %>
				<TD>
                        <A href="./parametros.siga?accion=mostrarParametros">
                            <IMG height=24 src="./Imagenes/b_param.JPG" width=89 border=0 name=Image16>
                        </A> 
                </TD>
                <%} %>
                 <TD align="right" width="100%">
						    <b>Bienvenido: <%=BUsuarioCat.getCargo()%> / <%=BUsuarioCat.getNombre()%>&nbsp;&nbsp;&nbsp;</b>
			     </TD>
			</TR>
			</TBODY>
			</TABLE>
		</TD>
	</TR>
</TBODY>
</TABLE>
<%}%>
