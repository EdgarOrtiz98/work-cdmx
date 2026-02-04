<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.meve.sigma.beans.*"
%>
<%
UsuarioBean BUsuarioheader = (UsuarioBean)session.getAttribute("UsuarioBean");
boolean bAtencion = false;
if(BUsuarioheader==null){
}else{
	if((BUsuarioheader.getAtencion() || BUsuarioheader.getAsistente()) && !(BUsuarioheader.getTurnado() ||	BUsuarioheader.getRecepcion() ||BUsuarioheader.getSupervisor()))
		bAtencion = true;
%>

<%@page import="com.meve.sigma.actualiza.ActualizaArea"%>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/link.css" />
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/link.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TR>
    	<TD background=../Imagenes/L2h1.jpg colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width=0 align=right border=0>
        	<TR>        	
                    <% if ((BUsuarioheader.getAdmon()) || (BUsuarioheader.getSupervisor()) ) { %>
                    <TD>    
                        <A onmouseover="MM_swapImage('Image19','','../Imagenes/L2b1_conf.jpg',1)" 
            		   onmouseout=MM_swapImgRestore() 
                           href="UsuariosView.jsp">
                           <IMG height=17 src="../Imagenes/L2b1_conf.jpg" width=123 border=0 name=Image19>
                        </A>
                    </TD>
                    <%}%>
                    <TD>
						<A onmouseover="dropdownmenu(this, event, 'menuHelp')">
                        	<IMG height="17" src="../Imagenes/L2b1_ayu.jpg" width="75" border="0" name="Image18">
                        </A> 
                        <div id="menuHelp" class="anylinkcssHelp" style="width: 65px; background-color: lightblue">
                                <a href="../DownLoadDicument?fol=HelpSIGA&name=manual_siga.pdf" target="_blank" >Manual</a>												
                                <a href="../DownLoadDicument?fol=HelpSIGA&name=fqa_siga.pdf" target="_blank" >F.A.Q.</a>
                        </div>             
                    </TD>
                    <TD>
                        <A onmouseover="MM_swapImage('Image20','','../Imagenes/L2b1_sal.jpg',1)" 
                            onmouseout="MM_swapImgRestore()" 
                            href="estructuraGestion.jsp" target="_top">
                            <IMG src="../Imagenes/b1_estruct.jpg" border="0" name="Image20">
                        </A>
                    </TD>
                    <TD>
                        <A onmouseover="MM_swapImage('Image20','','../Imagenes/L2b1_sal.jpg',1)" 
                            onmouseout="MM_swapImgRestore()" 
                            href="index.jsp" target="_top">
                            <IMG height="17" src="../Imagenes/L2b1_sal.jpg" width="68" border="0" name="Image20">
                        </A>
                    </TD>
                </TR>
            </TABLE>
        </TD>
    </TR>
    <TR>
        <TD background=../Imagenes/fon_head_shcp.jpg>
            <IMG height=20 src="../Imagenes/header_shcp.jpg" width=771>
        </TD>
        <TD align="right"  background=../Imagenes/fon_head_shcp.jpg>
           <B style="color: white; size: 11px;"><%=ActualizaArea.getNombreArea(BUsuarioheader.getIdArea())%>&nbsp;&nbsp;&nbsp;</B>
        </TD>
    </TR>
    <TR>
    	<TD background=../Imagenes/L2h2.jpg colspan="2">
            <TABLE cellSpacing=0 cellPadding=0 width=0 border=0>
        	<TR>
                    <TD>
                        <IMG height=21 src="../Imagenes/L2b_ini.jpg" width=12>
                    </TD>
                    <TD>
                        <A onmouseover="MM_swapImage('Image50','','../Imagenes/b_inicio.jpg',0)" 
                            onmouseout=MM_swapImgRestore() 
                            href="portalPrincipal.jsp">
                            <IMG height=24 src="../Imagenes/b_inicio.jpg" width=62 border=0 name=Image50>
                        </A>
                    </TD>
                    <%if(!bAtencion){
                    if(BUsuarioheader.getRecepcion()||BUsuarioheader.getTurnado()){%>
                    <TD>
                        <A onmouseover="MM_swapImage('Image51','','../Imagenes/b_nue_asu.gif',0)" 
                            onmouseout=MM_swapImgRestore() 
                            href="Asuntos.jsp"> 
                            <IMG height=24 src="../Imagenes/b_nue_asu.gif" width=106 border=0 name=Image51>
                        </A>
                    </TD>
                    <%}%>
                    <%}%>
                    <TD>
                        <A onmouseover="dropdownmenu(this, event, 'anylinkmenu6')">
                            <IMG height=24 src="../Imagenes/b_bus.jpg" width=89 border=0 name=Image16>
                        </A>
                        <div id="anylinkmenu6" class="anylinkcss" style="width: 155px; background-color: lightblue">
                            <a href="Buscar.jsp">Buscar por Instrucción</a>
           
                            <a href="BuscarCampo.jsp">Buscar por Asunto</a>
 
                            <a href="rastreoRuta.jsp">Trayectoria de Asunto</a>
                        </div>             
                    </TD>
                     <TD>
                        <A onmouseover="dropdownmenu(this, event, 'menuReporte')">
                            <IMG height=24 src="../Imagenes/b_rep.jpg" width=89 border=0 name=Image16>
                        </A>
                         <div id="menuReporte" class="anylinkcss" style="width: 155px; background-color: lightblue">
                            <%if(BUsuarioheader.getTurnado()){ %>
                               <a href="../reporteador.siga?accion=mostrarAsuntos">Reporte de Asuntos</a>
                            <%}else{ %>
                            <a style="color: gray">Reporte de Asuntos</a>
                            <%} %>
                            <%if(BUsuarioheader.getAtencion()||BUsuarioheader.getAsistente()){ %>
                            <a href="../reporteador.siga?accion=mostrarInstrucciones">Reporte de Instrucciones</a>
                            <%}else{ %>
                            <a style="color: gray">Reporte de Instrucciones</a>
                            <%} %>
                        </div>            
                    </TD>
                    <TD align="right" width="100%">
                       <b style="size: 11px;">Bienvenido: <%=BUsuarioheader.getCargo()%> / <%=BUsuarioheader.getNombre()%>&nbsp;&nbsp;&nbsp;</b>
                    </TD>
                </TR>
            </TABLE>
        </TD>
    </TR>
</TABLE>
<%}%>