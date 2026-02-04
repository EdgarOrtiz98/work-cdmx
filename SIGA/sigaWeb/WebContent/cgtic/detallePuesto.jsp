<!--
**************************************************************
* Copyright (C) 2007 SHCP 
* CGTIyC - alberto_ortiz@hacienda.gob.mx
* 
* $$Archivo: 	  detallePuesto.jsp
* $$Revisión: 	  AOA - detalle del puesto
* $$Fecha: 	  14 Ene 2007
* $$Descripción:  Muestra el detalle de un puesto seleccionado en la pantalla
*                 que invoca
* 
* Este software es información propietaria y confidencial de la SHCP - CGTIyC. 
**************************************************************
-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="gob.hacienda.cgtic.siga.*"%>

<%
  // Variable que sirve para verificar si la consulta a la BD fué correcta
    boolean consultaOK = false; 
    String puestoPar= "";
    Puesto puesto=null;
  // Verificamos que el parametro no sea null, para evitar un NullPointerException...
    if (request.getParameter("puestoPar")!=null){
      // Obtiene el parámetro puestoPar que trae el IdUsuario
      puestoPar = request.getParameter("puestoPar");
      
      // Crea una instancia de la clase puesto y realiza la consulta a la BD
      puesto = new Puesto(puestoPar);
      consultaOK = puesto.consultaPuesto();
  }
%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>detallePuesto</title>
    <link rel="stylesheet" type="text/css" href="../cgtic/css/cgtic-siga.css"/>
  </head>
  <body background="../Imagenes/fondo_claro.jpg">
  <!--<hr width="600" size="1pt" style="color=#004080;">-->
    <% 
    /* En caso de que no se haya podido realizar la consulta manda un mensaje de 
    * error a pantalla, en caso que contrario muestra la información solicitada
    */
    if(!consultaOK){
    %>
        <p class="rowElementTitle"><strong>No se ha podido obtener informaci&oacute;n del puesto</strong></p>
    <% 
    }else{
      /* Crea la variable de propiedades, para obtener las etiquetas del archivo
      * de propiedades Etiquetas.properties
      */
      java.util.ResourceBundle etiquetas = java.util.ResourceBundle.getBundle(
      "Etiquetas",java.util.Locale.US);
    
      /* Procede a pintar la tabla con los valores obtenidos, las etiqutas
      * se obtienen de la clase etiquetas y los valores de la clase puesto
      */
    %>
    <table cellspacing="0" cellpadding="3" border="0" width="600" align="left">
      <tr>
        <td width="100" height="10" class="rowElementTitle">
          <div align="left">
            <%out.println(etiquetas.getString("detallePuesto.cargo")+":");%>
          </div>
        </td>
        <td width="600" class="tableBody" colspan="3"><%=puesto.getCargo()%></td>
      </tr>
      <tr>
        <th width="100" height="10" class="rowElementTitle">
          <div align="left">
            <%out.println(etiquetas.getString("detallePuesto.telefono")+":");%>
          </div>
        </th>
        <td width="300" class="tableBody"><%=puesto.getTelefono()%></td>
        <th width="100" height="10" class="rowElementTitle">
          <div align="left">
            <%out.println(etiquetas.getString("detallePuesto.correo")+":");%>
          </div>
        </th>
        <td width="300" class="tableBody"><%=puesto.getCorreo()%></td>
      </tr>
    </table>
    <% }%>
    </body>
</html>