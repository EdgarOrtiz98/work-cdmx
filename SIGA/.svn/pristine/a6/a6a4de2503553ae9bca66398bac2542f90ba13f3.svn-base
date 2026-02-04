<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ attribute name="id" required="true"%>
<%@ attribute name="url" required="true"%>
<%@ attribute name="titulo" %>
<%@ attribute name="width" %>
<%@ attribute name="height" %>
<%@ attribute name="top" %>
<%@ attribute name="left" %>
<script type="text/javascript" src="./js/ventanas.js"></script>
<link rel="stylesheet" type="text/css" href="./css/gantt.css" />
		<div class="cargando" id="transparencia">
			<table width="100%;" height="600">
				<tr>
					<td></td>
				</tr>
			</table>
		</div>
<div id="${id}" style="display: none; position: absolute; top: ${top}; left: ${left}">
	<table  bgcolor="White">
		<th class="ventana" colspan="4"
			onmousedown="mueveVentana(event,'${id}');return false;"
			onmouseover="this.style.cursor='move'">
			<table width="100%">
			  <tr>
				<td align="left"><a style="color: #3366CC">${titulo}</a></td>
				<td align="right"><a style="color: #3366CC" href="javascript:;"
					onclick="escondeVentanas('${id}');return false;">X</a></td>
			  </tr>
		    </table>
		</th>
		<tr><td>
		<IFRAME ID="${id}_frame" 
				SRC="${url}" align="middle"
				WIDTH="${width}" HEIGHT="${height}" frameborder=0>
			</IFRAME>
		</td></tr>
</table>
</div>