<%--
*******************************************************************************
* Copyright (C) 2007 SHCP 
* CGTIyC - alejandro_gavia@hacienda.gob.mx
* 
* $$Archivo 	getPuestosByUA.jsp
* $$Revisión 	DARG. 
* $$Fecha 	11 Enero 2007
* $$Descripción JSP para cargar elementos (Puestos) en la pantalla principal.
* 
* Este software es información propietaria y confidencial de la SHCP - CGTIyC. 
*******************************************************************************
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="gob.hacienda.cgtic.siga.*, com.meve.sigma.beans.*" %>

<html>
  <head>
    <script language="JavaScript" type="text/javascript">
<%
    String action = "";
    String ua = "";
    String usr_ua = "";
    String strOut="";
	String id_tur = "";
	String strBan = (request.getParameter("ban")==null?"":request.getParameter("ban"));
    if (request.getParameter("action")!=null){
        action = request.getParameter("action");
    }
    
    if (action.equals("getPtoByUA")){
        if (request.getParameter("ua")!=null){
            ua = request.getParameter("ua");
			if (request.getParameter("usr_ua")!=null){
                usr_ua = request.getParameter("usr_ua");
            }
			if (request.getParameter("id_tur")!=null){
                id_tur = request.getParameter("id_tur");
            }
			
            Puestos ptos = new Puestos();
            Instruccion instruccion = new Instruccion();
            if (usr_ua.equals(ua)){
                ptos.ConsultaPorUA(ua, true, id_tur, strBan);
            }else{
                ptos.ConsultaPorUA(ua, id_tur, strBan);
            }
                
            Puesto ptoTmp;
            strOut+="var ptoSel = parent.document.getElementById('pto');";
            for (int i= 0;i<ptos.getNumReg();i++){
                ptoTmp = ptos.getPuesto(i);
                strOut+="var opt" + i + " = document.createElement('option');";
                strOut+="opt" + i + ".value='"+ptoTmp.getIdUsuario()+"';";
                strOut+="opt" + i + ".text='" + ptoTmp.getCargo() + " / " + 
                 ptoTmp.getNombre()+ "';";
                strOut+="try{ptoSel.add(opt" + i + ",null);}catch(ex){ptoSel.add(opt" + i + ");}";
            }

            strOut+=" var InsSel = parent.document.getElementById('instrucciones');";
            strOut+="try{InsSel.innerHTML=\""+instruccion.getComboInstrucciones(ua)+"\"}catch(ex){}";
            //String [][] regInstr = instruccion.getInstruccionesPorArea(ua,true);
            //for(int i=0;i<regInstr.length;i++){
                //strOut+="var optI" + i + " = document.createElement('option');";
                //strOut+="optI" + i + ".value='"+ regInstr[i][0] +"';";
            	//if ((regInstr[i][1]).length()>60)
                    //regInstr[i][1] = (regInstr[i][1]).substring(0,60);
                    
                //strOut+="optI" + i + ".text='" + regInstr[i][1] + "';";
                //strOut+="try{InsSel.add(optI" + i + ",null);}catch(ex){InsSel.add(optI" + i + ");}";
            //}
	    //strOut+="var optOtra = document.createElement('option');";
	    //strOut+="optOtra.value='[otra]';";
	    //strOut+="optOtra.text='[ Otra ]...';"; 
	    //strOut+="try{InsSel.add(optOtra,null);}catch(ex){InsSel.add(optOtra);}";

            out.println(strOut);
            out.println("parent.document.getElementById('varPtoInst').focus();");
            
        }
    }
%>

    </script>
  </head>
  <body></body>
</html>