<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="xg" tagdir="/WEB-INF/tags"%>
<%@page import="com.meve.sigma.util.Utilerias"%>
<%@page import="com.meve.sigma.catalogos.CatalogoRol"%>
<%@page import="com.meve.sigma.catalogos.CatalogoUtil"%>
<%@page import="com.meve.util.ManejadorDeTablas"%>
<HTML>
<HEAD>
<TITLE>Puestos</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="./theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="./css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="./css/link.css" rel="stylesheet" type="text/css">
<LINK href="./css/menu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./js/SigaJS.js"></script>
<script type="text/javascript" src="./js/estructuraOrganizacional.js"></script>
<script type="text/javascript" src="./js/ajax.js"></script>
<jsp:useBean id="UsuarioBean" scope="session"
	type="com.meve.sigma.beans.UsuarioBean"
	class="com.meve.sigma.beans.UsuarioBean" />
<jsp:useBean id="catalogoRol" scope="application"
	type="java.util.List"
	class="java.util.ArrayList" />
<jsp:useBean id="areas" scope="session" class="java.util.ArrayList"
	type="java.util.List"></jsp:useBean>
<jsp:useBean id="area" scope="session"
	class="com.meve.sigma.organizacional.vo.AreaVO"
	type="com.meve.sigma.organizacional.vo.AreaVO"></jsp:useBean>
<STYLE type=text/css>
BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<jsp:include page="headerSIGA.jsp" flush="false" />
<BODY background="../Imagenes/fondo_claro.jpg">
<%
	String strTmp = request.getRequestURI();
	strTmp = strTmp.substring(strTmp.indexOf('/', 2) + 5, strTmp
			.length());
	if (UsuarioBean == null) {
		try {
			response.sendRedirect("index.jsp?pagina=" + strTmp);
		} catch (java.io.IOException io) {
		}
	}
%>
<html:form action="estructuraOrganizacional">
	<input type="hidden" value="" name="accion" />
	<input type="hidden" value="" name="idLink" />
	<%
	if (UsuarioBean.getAdmon()) {
	%>
	<DIV align="center">
	<TABLE border="0">
		<TR>
			<TD align="center" width="500"><b>Unidad Administrativa</b></TD>
		</TR>
		<TR align="center">
			<TD align="center" width="500"><html:select property="idArea"
				onchange="submitForm(estructuraOrganizacionalForm,'mostrarPorRoles','');return false;"
				styleClass="blue500a">
				<html:option value="-1">------------- Seleccione una Unidad Administrativa ------------- </html:option>
				<logic:iterate id="registro" name="areas"
					type="com.meve.sigma.organizacional.vo.AreaVO">
					<html:option value="${registro.idArea}">${registro.nombreHTML}</html:option>
				</logic:iterate>
			</html:select></TD>
		</TR>
	</TABLE>
	</DIV>
	<%}%>
  <TABLE width="900" align="center">
   <logic:iterate id="rol" name="catalogoRol" type="com.meve.sigma.catalogos.CatalogoRol" indexId="idx">
   <%ManejadorDeTablas tableManager = (ManejadorDeTablas)session.getAttribute(ManejadorDeTablas.TABLE_MANAGER+"_"+rol.getId()); %>
      <logic:notEmpty name="tableManager_${rol.id}" property="registros" scope="session">
      <TR><TD width="900">
        <a onclick="muestraOcultaRoles('${rol.id}');return false;">
           <img src="./Imagenes/expand.gif" border="0" height="16" width="16" id="img_${rol.id}" >${rol.nombre}
        </a>
      <div id="div_${rol.id}" style="display: none;">
       <TABLE width="100%" border="0">
		   <TR bgcolor="#00204f">
			 <TD width="50%" align="center">
			   <xg:sortedHeader key="Puesto" id="0" form="estructuraOrganizacionalForm" orden="<%=tableManager.getOrden(0)%>" />
			</TD>
			<TD width="50%" align="center">
			  <xg:sortedHeader key="Responsable" id="1" form="estructuraOrganizacionalForm" orden="<%=tableManager.getOrden(1)%>" />
		    </TD>
		  </TR>
       </TABLE>
       <TABLE width="100%" align="center" border="0">
	   <logic:iterate id="registro" name="tableManager_${rol.id}" property="registrosPaginaActual" scope="session"
		type="com.meve.sigma.organizacional.vo.PuestoVO" indexId="contador" >
		 <tr <%if((contador.intValue()%2)==0){%>bgcolor="#D6F6FF"<%}%>>
			<td WIDTH='50%'><A href = "./puesto.siga?accion=mostrarPuesto&idLink=${registro.idUsuario}">${registro.cargo}</a></td>
			<td WIDTH='50%'>${registro.nombre}</td>
		 </tr>
	   </logic:iterate>
	     <tr><td colspan="6">
		   <TABLE align="center">
			 <tr><%=tableManager.getPaginacionHTML("estructuraOrganizacionalForm")%></tr>
		   </TABLE>
		</td></tr>
      </TABLE>
    </div>
    </TD></TR>
   </logic:notEmpty>   
   </logic:iterate>
   </TABLE>
</html:form>
</BODY>
</HTML>