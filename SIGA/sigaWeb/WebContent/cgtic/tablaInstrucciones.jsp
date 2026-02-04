<%--
*******************************************************************************
* Copyright (C) 2007 SHCP 
* CGTIyC - alejandro_gavia@hacienda.gob.mx
* 
* $$Archivo 	tablaInstrucciones.jsp
* $$Revisión 	DARG - Creación del archivo. 
* $$Fecha 	11 Enero 2007
* $$Descripción Tabla de instrucciones por asunto.
*                
* 
* Este software es información propietaria y confidencial de la SHCP - CGTIyC. 
*******************************************************************************
--%>
<%@ page import="gob.hacienda.cgtic.siga.*, com.meve.sigma.beans.*,gob.hacienda.cgtic.siga.beans.*" %>

<%
UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
Instruccion instruccion = new Instruccion();
String idUsr = BUsuario.getIdUsuario();
String idArea = BUsuario.getIdArea();
String idAsunto = "";
String idInstr = "";
String strRutaBase = request.getContextPath();// (application.getInitParameter("RutaBase")==null)?"/SIGA":application.getInitParameter("RutaBase");
try{
if (request.getParameter("idAsunto")==null){
    out.println("<font color='#FF0000'>Error: No hay Id de Asunto.");
}else{
    idAsunto = request.getParameter("idAsunto");
}
if (request.getParameter("idInstr")!=null){
    idInstr = request.getParameter("idInstr");
}
}catch(java.io.IOException io){
	//System.err.println("io="+io);
}
java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle(
    "Etiquetas",java.util.Locale.US);
%>
<%@page import="com.meve.sigma.util.Utilerias"%>
<html><head>
<link rel="stylesheet" type="text/css" 
    href="<%=strRutaBase%>/cgtic/css/cgtic-siga.css"/>
<script type="text/javascript" >
function getRowBy(indx){
    var dataLine="";
    var elID = "";
    var styleTR="";
    for (i=0;i<25;i++){
        if (document.getElementById("rowLn"+i)){
        
            if(document.getElementById("R" + i + "C7").value=="0")
                styleTR="tableBody";
            else 
                styleTR="tableBody2";        

            if (document.getElementById("R" + i + "C1").value=="[otra]" &&
                document.getElementById("R" + i + "C1a").value=="") 
                styleTR="tableBodyRed";    

            document.getElementById("rowLn"+i).className = styleTR;
	    document.getElementById("rowLn"+i).style.borderStyle= "solid";    
	    document.getElementById("rowLn"+i).style.borderBottomWidth= "1pt";    
	    document.getElementById("rowLn"+i).style.borderBottomColor= "#c0c0c0";
   	    if(i != indx)
                document.getElementById("iRw"+i).checked = false;
   	    
        }
    }
    document.getElementById("rowLn"+indx).className  ="tableSelect";
    document.getElementById("rowLn"+indx).style.borderWidth= "4pt";    
    document.getElementById("rowLn"+indx).style.borderStyle= "solid";    
    document.getElementById("rowLn"+indx).style.borderColor= "#AAAAFF";
    if(document.getElementById("R" + indx + "C7").value=="1")
        document.getElementById("rowLn"+indx).style.color= "#C0C0C0";        

//Index
    dataLine+= indx + ",";
//Acceso    
    elID = "R" + indx + "C5";
    dataLine += document.getElementById(elID).value + ",";    
//Requerido    
/*
    elID = "R" + indx + "C6";
    dataLine += document.getElementById(elID).value + ",";    
    
    Deja de ser útil el campo requerido, por default se maneja el cero...
*/
    dataLine += "0,";    
    
//Puesto
    elID = "R" + indx + "C2";
    dataLine += document.getElementById(elID).value + ","; 
//Insrtrucción
    elID = "R" + indx + "C1";
    dataLine += document.getElementById(elID).value + ",";    
    elID = "R" + indx + "C1a";
    dataLine += document.getElementById(elID).value + ",";    
//tipo ate.
    elID = "R" + indx + "C3";
    dataLine += document.getElementById(elID).value + ",";    
//tiempo
    elID = "R" + indx + "C4";
    dataLine += document.getElementById(elID).value + ",";    
//iD's
    dataLine += "<%=idAsunto%>,";    
    dataLine += "<%=idInstr%>,";    
//estatus
    elID = "R" + indx + "C7";
    dataLine += document.getElementById(elID).value + ",";    
//UA
    elID = "R" + indx + "C2a";
    dataLine += document.getElementById(elID).value + ",";
//auto
    elID = "R" + indx + "C8";
    dataLine += document.getElementById(elID).value + ",";
//Estado del checkbox
    dataLine += document.getElementById("iRw"+indx).checked;
    
   <%if(Utilerias.isIdInString(idArea,session.getServletContext().getAttribute("app.siga.informativas.tiempo.uas").toString())){ %>
        dataLine += ",1";
    <%}else{%>
        dataLine += ",0";    
    <%}%>   
    top.window.document.getElementById("dataLine").value = dataLine;
    top.window.document.getElementById("dataLine").focus();
}

<%
String action = (request.getParameter("action")==null)?"":
                    request.getParameter("action");
String tipoTabla = "0";                    
String filtro = "";
if (request.getParameter("filtro")!=null)
    filtro = request.getParameter("filtro");
if (request.getParameter("tipoTabla")!=null)
    tipoTabla = request.getParameter("tipoTabla");
    tablaInstruccionesBean instrBean;

// primera entrada...
if (request.getParameter("call")!=null){
    if (request.getParameter("call").equals("New")){
        instrBean = instruccion.getTablaInstruccionesBean(idAsunto, idInstr);
        //Verifica el tipo de tabla que se requiere construir...
        if (tipoTabla.equals("0"))
            instrBean.setTipoTabla(tablaInstruccionesBean.TIPO_DELEGADO);
        else
            instrBean.setTipoTabla(tablaInstruccionesBean.TIPO_TURNADO);
        session.setAttribute("tablaInstruccionesBean", instrBean);
    }
}    
// Si no existe el objeto....
if (session.getAttribute("tablaInstruccionesBean")==null){
    instrBean = instruccion.getTablaInstruccionesBean(idAsunto, idInstr);
    instrBean.setTipoTabla((tipoTabla.equals("0"))?tablaInstruccionesBean.TIPO_DELEGADO:tablaInstruccionesBean.TIPO_TURNADO);
}else{
    instrBean = (tablaInstruccionesBean) session.getAttribute("tablaInstruccionesBean");
    instrBean.setTipoTabla((tipoTabla.equals("0"))?tablaInstruccionesBean.TIPO_DELEGADO:tablaInstruccionesBean.TIPO_TURNADO);
}

// Borrar una instrucción...
if (action.equalsIgnoreCase("delete")){
    instrBean.delRow(Integer.parseInt(request.getParameter("indexRow")) );
    //out.println("DELETED!");
}

// Instertar una instrucción...
if (action.equalsIgnoreCase("insert")){
    String A= request.getParameter("A");
    String R= request.getParameter("R");
    String pto= request.getParameter("pto");
    String instr= request.getParameter("instr");
    if (instr.equals("[otra]"))
        instr = "0";
    String otraInstr= request.getParameter("otraInstr");
    //char tiat[]= request.getParameter("ta").toCharArray();
	String tiat = request.getParameter("ta");
    String tiemp= request.getParameter("tiemp");

    instrBean.insertRow(Integer.parseInt(A), Integer.parseInt(R), Integer.parseInt(pto),
        Integer.parseInt(instr), otraInstr, tiat, Integer.parseInt(tiemp));
    //out.println("INSERTED!"); 
}

// Actualizar una instrucción...
if (action.equalsIgnoreCase("update")){
    String A= request.getParameter("A");
    String R= request.getParameter("R");
    String pto= request.getParameter("pto");
    String instr= request.getParameter("instr");
    if (instr.equals("[otra]"))
        instr = "0";
    String otraInstr= request.getParameter("otraInstr");
    //char tiat[]= request.getParameter("ta").toCharArray();
	String tiat = request.getParameter("ta");
    String tiemp= request.getParameter("tiemp");
    String instStat = request.getParameter("instStat");
    String indxRow = request.getParameter("indxRow");
	String auto = request.getParameter("auto");
     
    instrBean.updateRow(Integer.parseInt(A), Integer.parseInt(R), Integer.parseInt(pto),
        Integer.parseInt(instr), otraInstr, tiat, Integer.parseInt(tiemp), 
        Integer.parseInt(instStat), Integer.parseInt(indxRow), Integer.parseInt(auto));
    //out.println("INSERTED!");
}
try{
// Guardar todas las instrucciones...
if (action.equalsIgnoreCase("saveAll")){
    try{
        instrBean.Save();
        out.println("alert(\"Las instrucciones se han guardado exitosamente.\");");
    }catch(Exception e){
        out.println("alert('El tipo de documento no tiene pasos configurados');");
    }
	instrBean = instruccion.getTablaInstruccionesBean(idAsunto, idInstr);
        instrBean.setTipoTabla((tipoTabla.equals("0"))?tablaInstruccionesBean.TIPO_DELEGADO:tablaInstruccionesBean.TIPO_TURNADO);
    
}

%>
</script>
</head><body  background="../Imagenes/fondo_claro.jpg">
<form action="tablaInstrucciones.jsp" id='tableIns'>
<table class="tableInstr" cellspacing="0" width="800">
  <tr>
    <td class="tableTitle">&nbsp;</td>
<%
    String wTD="300";
    if (Integer.parseInt(tipoTabla)==tablaInstruccionesBean.TIPO_TURNADO){
        wTD = "200";
        out.print("<td class='tableTitle' width='" + wTD + "'>");
        out.print(labels.getString("ua") + "</td>");
    }
%>
    <td class="tableTitle" width='<%=wTD%>'><%=labels.getString("usu-pto")%></td>
    <td class="tableTitle" width='<%=wTD%>'><%=labels.getString("instr")%></td>
    <td class="tableTitle"><%=labels.getString("ta_short")%></td>
    <td class="tableTitle"><%=labels.getString("tiemp_short")%></td>
    <td class="tableTitle"><%=labels.getString("A_short")%></td>
<!--
    <td class="tableTitle"><%=labels.getString("R")%></td>
-->
  </tr>
<%
out.println(instrBean.getHTML());
session.setAttribute("tablaInstruccionesBean", instrBean);
}catch(java.io.IOException io){
	//System.err.println("io="+io);
}
%>
</table>
<table>  
  <tr>
    <td colspan="8" style="{font-family:Arial,Helvetica;color:#FF2020;
    font-size:10pt;background:transparent;}">(*) Instrucciones incompletas.
    </td>
  </tr>
</table>
</form>
</body></html>