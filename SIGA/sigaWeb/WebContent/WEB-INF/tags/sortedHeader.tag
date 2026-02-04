<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ attribute name="id" %>
<%@ attribute name="key" %>
<%@ attribute name="form" %>
<%@ attribute name="orden" %>

   <a onclick="submitForm(document.${form},'asc', ${id});" >
      <img border="0" src="./Imagenes/arriba.gif" align="middle">
   </a>
   <FONT SIZE=2 COLOR="FFFFFF"
			FACE="verdana"><b>${key}</b></FONT>
   <a onclick="submitForm(document.${form},'desc', ${id});">
      <img border="0" src="./Imagenes/abajo.gif" align="middle">
   </a>
