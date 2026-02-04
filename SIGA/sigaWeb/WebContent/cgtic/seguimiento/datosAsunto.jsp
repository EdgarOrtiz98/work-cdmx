<%@ page contentType="text/html;charset=ISO-8859-1" import="gob.hacienda.cgtic.siga.Asunto" %>

<%
    String folio = request.getParameter("folio");
    Asunto asu = new Asunto(folio);

        /*
         0 - A.ID_ASUNTO
         1 - A.ASU_FOLIO_RECEPCION
         2 - A.ASU_ENTIDAD 
         3 - B.ENT_NOMBRE 
         4 - A.ASU_REMITENTE 
         5 - C.RMT_NOMBRE 
         6 - A.ASU_FIRMANTE 
         7 - A.ASU_TIP_DOCTO
         8 - D.TIP_DOCTO_NOMBRE 
         9 - A.ASU_LISTAIDS_PARA 
         10 - A.ASU_LISTAIDS_CC 
         11 - A.ASU_DESCRIPCION     //Esconder
         12 - A.ASU_TRAMITE 
         13 - A.ASU_FECHA_CAPTURA 
         14 - A.ASU_FECHA_RECEPCION 
         15 - A.ASU_FECHA_DOCTO 
         16 - A.ASU_FECHA_CADUCIDAD 
         17 - A.ASU_AVANCE 
         18 - A.ASU_ESTATUS 
         19 - A.ASU_FOLIO_EXTERNO 
         20 - A.ASU_FOLIO_INTERMEDIO 
         21 - A.ASU_FECHA_EVENTO 
         22 - A.ASU_HORA_EVENTO
         23 - A.ASU_LUGAR_EVENTO 
         24 - A.ASU_PRIORIDAD 
         25 - E.PRI_NOMBRE
         26 - A.ASU_TIPO_ASUNTO  
         27 - F.TIP_ASU_NOMBRE
         */
    String [][] regAsu = asu.getDatos();
    request.setAttribute("resultadoConsulta",regAsu);
    //for(int i=0;i<regAsu.length;i++) {
       // //System.out.println("regAsu["+ regAsu.length + "][" + regAsu[i].length+"]");
    //}
    if (regAsu != null){
        if (asu.getTipoRegistro().equalsIgnoreCase("variable")){
%>
    <table cellspacing="0" cellpadding="2" border="0" width="800">
      <tr>
        <td class="rowElementTitle">Folio</td>
        <td class="rowElementBody">
            <%try{out.println(regAsu[0][1]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
        <td class="rowElementTitle">Entidad</td>
        <td class="rowElementBody">
            <%try{out.println(regAsu[0][2]+" - "+regAsu[0][3]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
      </tr>
      <tr>
        <td class="rowElementTitle">Fecha de Captura</td>
        <td class="rowElementBody">
            <%try{out.println(regAsu[0][13]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
        <td class="rowElementTitle">Fecha de Recepción</td>
        <td class="rowElementBody">
            <%try{out.println(regAsu[0][14]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
      </tr>
      <tr>
        <td class="rowElementTitle">Fecha del Documento</td>
        <td class="rowElementBody">
            <%try{out.println(regAsu[0][15]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
        <td class="rowElementTitle">Fecha de Caducidad</td>
        <td class="rowElementBody">
            <%try{out.println(regAsu[0][16]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
      </tr>
      <tr>
        <td class="rowElementBody" colspan="4" align="right">
        <div id="info_lab"><a href="javascript:moreInfo();">
        [+] Ver más
        </a></div>
        </td>
      </tr>
      <tr>
        <td class="rowElementBody" colspan="4">
        <div id="mInfo" style="visibility:hidden;position:absolute;" name="mInfo">
        <table cellspacing="0" cellpadding="2" border="0" width="800">
	  <tr>
	    <td class="rowElementBody" colspan="4"><hr>
	  </tr>
          <tr>
            <td class="rowElementTitle">Remitente</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][5]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Firmante</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][6]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Tipo de Documento</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][8]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Tramite</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][12]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Avance</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][17]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Estatus</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][12]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Folio Externo</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][19]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Folio Intermedio</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][20]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Fecha de Evento</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][21]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Hora de Evento</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][22]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Lugar de Evento</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][23]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Prioridad</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][24]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Tipo de Asunto</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][27]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">&nbsp;</td>
            <td class="rowElementBody">
                &nbsp;
            </td>
          </tr>
        </table>
        </div>           
        </td>
      </tr>
    </table>
	    
<% 
        }
        /*
         0 - ID_ASUNTO_REF           
         1 - ASU_REF_AREA_RECEPCION  
         2 - ASU_REF_ENTIDAD         
         3 - ASU_REF_REMITENTE       
         4 - ASU_REF_REMITENTE_NOMBRE
         5 - ASU_REF_REMITENTE_CORREO
         6 - ASU_REF_CONTROL         
         7 - ASU_TURNADOR_PUESTO     
         8 - ASU_TURNADOR_NOMBRE     
         9 - ASU_REF_TURNADOR_AREA   
         10 - ASU_REF_TIPO_DOCTO      
         11 - ASU_REF_EXPEDIENTE      
         12 - ASU_REF_TRAMITE         
         13 - ASU_REF_TIPO_ASUNTO     
         14 - ASU_REF_PRIORIDAD       
         15 - ASU_REF_USR_CAPTURA     
        */

        if (asu.getTipoRegistro().equalsIgnoreCase("fijo")){
%>
    <table cellspacing="0" cellpadding="2" border="0" width="800">
      <tr>
        <td class="rowElementTitle">Folio</td>
        <td class="rowElementBody">
            <%=folio %>
        </td>
        <td class="rowElementTitle">Entidad</td>
        <td class="rowElementBody">
           <%try{out.println(regAsu[0][2]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
      </tr>
      <tr>
        <td class="rowElementTitle">Fecha de Captura</td>
        <td class="rowElementBody">
            <%try{out.println(regAsu[0][41]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
        <td class="rowElementTitle">Fecha de Recepción</td>
        <td class="rowElementBody">
            <%try{out.println(regAsu[0][31]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
      </tr>
      <tr>
        <td class="rowElementTitle">Fecha del Documento</td>
        <td class="rowElementBody">
            <%try{out.println(regAsu[0][32]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
        <td class="rowElementTitle">Fecha de Caducidad</td>
        <td class="rowElementBody">
            <%try{out.println(regAsu[0][33]);}catch(Exception e){out.println("&nbsp;");}%>
        </td>
      </tr>
      <tr>
        <td class="rowElementBody" colspan="4" align="right">
        <div id="info_lab"><a href="javascript:moreInfo();">
        [+] Ver más
        </a></div>
        </td>
      </tr>
      <tr>
        <td class="rowElementBody" colspan="4">
        <div id="mInfo" style="visibility:hidden;position:absolute;" name="mInfo">
        <table cellspacing="0" cellpadding="2" border="0" width="800">
	  <tr>
	    <td class="rowElementBody" colspan="4"><hr>
	  </tr>
          <tr>
            <td class="rowElementTitle">Remitente</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][4]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Firmante</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][22]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Tipo de Documento</td>
            <td class="rowElementBody">
               <%try{out.println(regAsu[0][10]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Tramite</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][65]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Avance</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][44]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Estatus</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][43]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Folio Externo</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][34]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Folio Intermedio</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][35]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Fecha de Evento</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][58]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Hora de Evento</td>
            <td class="rowElementBody">
               <%try{out.println(regAsu[0][57]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Lugar de Evento</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][59]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">Prioridad</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][14]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
          </tr>
          <tr>
            <td class="rowElementTitle">Tipo de Asunto</td>
            <td class="rowElementBody">
                <%try{out.println(regAsu[0][13]);}catch(Exception e){out.println("&nbsp;");}%>
            </td>
            <td class="rowElementTitle">&nbsp;</td>
            <td class="rowElementBody">
                &nbsp;
            </td>
          </tr>
        </table>
        </div>           
        </td>
      </tr>
    </table>
	    
<%
        }
        
    }
%>

<script>
var info_hidden = true;

function moreInfo(){
	//alert(info_hidden);
	if (info_hidden){
	    info_hidden = false;
	    writeText("info_lab", "<a href='javascript:moreInfo();'>[-] Ocultar</a>");
	    document.getElementById("mInfo").style.visibility ="visible";
	    document.getElementById("mInfo").style.position="fixed";
	}else{
	    info_hidden = true;
	    writeText("info_lab", "<a href='javascript:moreInfo();'>[+] Ver más</a>");
	    document.getElementById("mInfo").style.visibility ="hidden";
	    document.getElementById("mInfo").style.position="absolute";
	}
}

function writeText(id, text)
{
	if (document.getElementById)
	{
		obj = document.getElementById(id);
		obj.innerHTML = '';
		obj.innerHTML = text;
	}
	else if (document.all)
	{
		obj = document.all[id];
		obj.innerHTML = text;
	}
	else if (document.layers)
	{
		obj = document.layers[id];
		text2 = "<P CLASS='rowElementBody'>" + text + "</P>";
		obj.document.open();
		obj.document.write(text2);
		obj.document.close();
	}
}

</script>
