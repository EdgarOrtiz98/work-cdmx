<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ taglib uri="meve_front" prefix="meve_front"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	boolean supervisor	= BUsuario.getSupervisor();
	boolean admin 		= BUsuario.getAdmon();
	String 	cat			= BUsuario.getCatArchivado();

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
	boolean bExiste			=	false;
	boolean bOperacion		=	false;
	String strIds_Borrar[]	=	null;
	String strAccion		=	"";
	int t = 0;
	strAccion				=	request.getParameter("accion");
	strIds_Borrar			=	request.getParameterValues("Borrar");
	bExiste					=	ActualizaClasificacion.getExiste();	
	if(strAccion!=null && strAccion.trim().length()>0 && strAccion.equals("borrar"))
	{
		bOperacion	=	ActualizaClasificacion.getDeleteClasificacion(strIds_Borrar);	
	} 
	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"1";
%>
<%!
	public static boolean par(int num)
    {
        boolean p = false;
        if (num % 2 == 0) 
        {
            p = true;
        }    
        return p;
    }
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<TITLE>Catálogos Archivo</TITLE>
<SCRIPT language="JavaScript" src="../js/GeneralFunctions.js"></SCRIPT>
<script language="JavaScript" type="text/javascript">
	function cambio(o, t){
		doc = document.ClaView;
		doc.accion.value="reload";
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg">
<FORM action="ClasificacionAsuntoView.jsp" name="ClaView" method="get">
<INPUT type="hidden" name="accion" value="">
<INPUT type="hidden" name="orden" value="">
<INPUT type="hidden" name="tipo" value="">
<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
<TBODY align="center">
	<TR bgcolor="#00204f">
		<TD align="center" >&nbsp;
					<FONT size="2" color="white" face="verdana">CATALOGOS ARCHIVOS</FONT>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="100%" colspan="2"></TD>
    </TR>
</TABLE>
<TABLE width="70%" height="40%" border="0">
<TBODY>
<%if(supervisor == true && !cat.equalsIgnoreCase("1")){%>
	<TR valign=top height="20">
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="TipoCedArchview.jsp">Cédula Tipo</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>	
	<TR valign=top height="20">
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ExpedienteArchview.jsp">Expedientes</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top height="20">
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ConsultaExpediente.jsp">Consultas por Asunto</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ConsultaExpedienteInst.jsp">Consultas por Instrucción</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
<%}%>
    <TR>
    	<TD nowrap></TD>
	</TR>
<%if((admin == true && supervisor == false) ){ %>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ValorArchview.jsp">Tipo de Valores</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ValoracionArchview.jsp">Valoración</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="SeleccionArchview.jsp">Técnica de Selección</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ClasifInfArchview.jsp">Clasificación de Información</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="UbicacionView.jsp">Ubicaciones</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>			
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="FondoArchview.jsp">Fondo</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="SubfondoArchview.jsp">Subfondo</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="SeccionArchview.jsp">Sección</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ClasificacionArchview.jsp">Instrumento Clasificación y Disposición Documental Serie</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD>
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ClasificacionArchSubview.jsp">Instrumento Clasificación y Disposición Documental Subserie</A></b>
    		</FONT>
	   	</TD> 
		<TD align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="Icddview.jsp">ICDD por Unidad</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="TipoCedArchview.jsp">Cédula Tipo</A></b>
    		</FONT>
	   	</TD> 
		<TD align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>	
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ExpedienteArchview.jsp">Expedientes</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ConsultaExpediente.jsp">Consultas por Asunto</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>	
		<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ConsultaExpedienteInst.jsp">Consultas por Instrucción</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
<%} %>

<%if(supervisor == true && cat.equals("1")){%>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ValorArchview.jsp">Tipo de Valores</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ValoracionArchview.jsp">Valoración</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		     <b>* <A href="SeleccionArchview.jsp">Técnica de Selección</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ClasifInfArchview.jsp">Clasificación de Información</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="UbicacionView.jsp">Ubicaciones</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>		
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		   <b>* <A href="FondoArchview.jsp">Fondo</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		   <b>* <A href="SubfondoArchview.jsp">Subfondo</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		   <b>* <A href="SeccionArchview.jsp">Sección</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ClasificacionArchview.jsp">Instrumento Clasificación y Disposición Documental Serie</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ClasificacionArchSubview.jsp">Instrumento Clasificación y Disposición Documental Subserie</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>	
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		   <b>* <A href="Icddview.jsp">ICDD por Unidad</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>		
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="TipoCedArchview.jsp">Cédula Tipo</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>	
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ExpedienteArchview.jsp">Expedientes</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ConsultaExpediente.jsp">Consultas por Asunto</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
	<TR valign=top>
		<TD >
    		<FONT face=Arial color=#000080 size=1>
		    <b>* <A href="ConsultaExpedienteInst.jsp">Consultas por Instrucción</A></b>
    		</FONT>
	   	</TD> 
		<TD  align="center">
			<FONT face=Arial color=#000080 size=1>
			</FONT>
		</TD>
	</TR>
<%}%>
</TBODY>
</TABLE>
<BR>
</FORM>
</BODY>
</HTML>
