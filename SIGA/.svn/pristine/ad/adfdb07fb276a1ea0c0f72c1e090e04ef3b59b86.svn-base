<%--
*******************************************************************************
* Copyright (C) 2007 SHCP 
* CGTIyC - alejandro_gavia@hacienda.gob.mx
* 
* $$Archivo 	AsuntosRelacionados.jsp
* $$Revisión 	AOA  - Creación del archivo. 
*               DARG - Modificaciones y adaptaciones para SIGA. 
* $$Fecha 	27 Marzo 2007
* $$Descripción Formulario que contiene los campos necesarios para la captura
*                modificación y eliminación de instrucciones, de asuntos por 
*                atender.
*                
* 
* Este software es información propietaria y confidencial de la SHCP - CGTIyC. 
*******************************************************************************
--%>
<%@ page import=" gob.hacienda.cgtic.siga.seguimiento.*, com.meve.sigma.beans.*"%>
<SCRIPT language="JavaScript" type="text/javascript">

// Pone el foco en el campo cuyo id se indique
function foco(id){
    var foliof=document.getElementById(id);
    foliof.focus();
    foliof.select();
}


function validarFormulario(formulario) {
    if(formulario.folio.value == '') {
        alert('El campo Folio es obligatorio');
        return false;
    }
    return true;
}
</SCRIPT>

<%
    UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
    String idUsr = BUsuario.getIdUsuario();
    
    String server = (application.getInitParameter("servername")==null)?
                "":application.getInitParameter("servername");
    String strRutaBase = (application.getInitParameter("RutaBase")==null)?
                "/SIGA":application.getInitParameter("RutaBase");	
    String urlSIGA = server + strRutaBase;

    String folio = request.getParameter("folio");
    HttpSession sesion = request.getSession(true);
    
    boolean resultadoOK = false;
    boolean consulto = false;
    Ruta ruta = null;
    
   // System.out.println(this.getClass()+" Folio: "+folio);
    if (folio!= null){
        // Instancia la clase sura y asocia valores iniciales para crear la ruta de asuntos
        ruta = new Ruta(folio);
        ruta.setSesion(sesion.getId().toString());
        
//        //System.out.println("Session ID: " + sesion.getId().toString());
        
        // Obtiene el idAsunto a partir del folio
       // System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.cosultaIdAsunto(): "+ruta.consultaIdAsunto());
        /*
            Se obtiene:
                idAsunto;
                descAsunto;
                firmante;
                unidadAdministrativa;
                remitente;
                comentarios;
        */
        if (resultadoOK = ruta.consultaIdAsunto()){
//            System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.ObtenerAsuntosRelacionados(): "+ruta.ObtenerAsuntosRelacionados());
            /*Manda a llamar a SP_RUTA_ASUNTOS_RELACIONADOS(idAsunto,session,error,out); y regresa un error o el número de asuntos relacionados.*/
            if (resultadoOK = ruta.ObtenerAsuntosRelacionados()){
//                System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.consultaAsuntos(): "+ruta.consultaAsuntos());
                /*Carga los nodos encontrados por el store*/
                if (resultadoOK = ruta.consultaAsuntos()){
//                    System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.consultaRelaciones(): "+ruta.consultaRelaciones());
                    /*Carga los nodos encontrados por el store*/
                    if (resultadoOK = ruta.consultaRelaciones()){
//                        System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.consultaAsuntosViejos(): "+ruta.consultaAsuntosViejos());
                        /*Carga los nodos encontrados por sentencia SQL*/
                        if (resultadoOK = ruta.consultaAsuntosViejos()){
//                            System.out.println(this.getClass()+" resultadoOk: "+resultadoOK+" : ruta.borraAsuntosAsociados()");
                            /*Elimina consultas*/
                            resultadoOK = ruta.borraAsuntosAsociados();
                        }
                    }
                }
            }
        }
        //consulto = true;
        consulto = request.getParameter("folio").length()>0?true:false;
    }

%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>AsuntosRelacionados</title>
    <link rel="stylesheet" type="text/css" href="<%=strRutaBase %>/cgtic/css/cgtic-siga.css"/>
    <STYLE type=text/css>BODY {
	MARGIN: 0px
    }
    </STYLE>
  </head>
  <body background="../Imagenes/fondo_claro.jpg" onload="foco('foliof')">
  <form name="formaFolio" action="rastreoRuta.jsp" method="POST" onSubmit="return validarFormulario(this);")>
        <span class="rowElementTitle">
          Folio:
        </span>
      <input type="text" name="folio" id="foliof" maxlength="50" size="50"/>
      <input type="submit" name="submit" id="submit" value="Buscar..."/>
      
    </form><p>
    
<%
    // Pone la descripción del Asunto en caso de que se tenga
    if (consulto && resultadoOK){
%>    
        <jsp:include page="/cgtic/seguimiento/datosAsunto.jsp" flush="false">
            <jsp:param name="folio" value="<%=folio %>"/>
        </jsp:include>
<%  }%> 
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>   
<br>
<br>
<br>
<br>
<br>
<br>
    <hr style="border-color:rgb(82,140,255);" size="1"></hr>
<%
    String[][] resultadoConsulta = (String[][])request.getAttribute("resultadoConsulta");
    if (consulto /*&& resultadoConsulta != null && resultadoConsulta.length > 0*/){
%>    
    <table class="tableInstr" width="50%" cellspacing="0">
<%
        if (!resultadoOK){
            if (folio != null && !folio.equals("")) {
%>    
              <tr>
                <th>
                  <div align="left">
                    Ocurrio el siguiente error: <%=ruta.getError()%>
                  </div>
                </th>
              </tr>
            
<%}      
    }else{
    String nombres = "";
    String relaciones = "";
    String asuntosViejos = "";
    String asuntosConPermiso="";
    String relacionIDFolioStr="";
    int elementos = 0;
    
            
            
            // Crea el parámetro nombres
            for(int i=0;i<ruta.getNumNodos();i++)
                nombres+= ruta.getNodos()[i][0] +  ",";
            nombres = nombres.substring(0,nombres.length()-1);
            
            // Crea el parámetro relaciones
            for(int i=0;i<ruta.getNumReg();i++)
                relaciones+= ruta.getSalida()[i][0] + "@" +ruta.getSalida()[i][1] 
                + "@" +ruta.getSalida()[i][2] + "@" +ruta.getSalida()[i][3] + ",";
            
            relaciones = relaciones.substring(0, (relaciones.length()>0)?relaciones.length()-1:0);

            // Crea el parámetro AsuntosViejos
            for(int i=0;i<ruta.getNumAsuntosViejos();i++)
                asuntosViejos+= ruta.getAsuntosViejos()[i][0] +  ",";


            asuntosViejos = asuntosViejos.substring(0,(asuntosViejos.length()>0)?asuntosViejos.length()-1:0);

            // Asigna el número de elementos(Asuntos) a tratar
            elementos = ruta.getNumNodos() + ruta.getNumReg();
            
            // Asigna los folios dentro del conjunto de relaciones a los cuales el usuario tiene permiso
            asuntosConPermiso = ruta.asuntosConPermiso(nombres, idUsr);
            relacionIDFolioStr = ruta.relacionIDFolio ;
            out.println("<!--");
            out.println("<br>Lista de folios: " + nombres);
            out.println("<br>Lista de folios con permiso: " + asuntosConPermiso);
            out.println("<br>idUsr: " + idUsr);
            out.println("-->");
            if(relaciones != null && !relaciones.equals("") ) {
                // Invocación del Applet
                // out.println("<applet Archive='DiagramaAsuntos.jar,lib/jgraph.jar,lib/jgraphlayout.jar' ");
                // out.println("<applet Archive='lib/jgraph.jar,lib/jgraphlayout.jar' ");
                // out.println("CODE='DiagramaAsuntos.class' WIDTH='1000' HEIGHT='800' ALIGN='BOTTOM'>");
                
                
                String urlDetalle = request.getScheme() +"://" + request.getServerName() + (request.getServerPort()!= 80? ":" + request.getServerPort():"") + request.getContextPath() + "/jsp/AsuntoTurnado.jsp";
                String urlRuta = request.getScheme() +"://" + request.getServerName() + (request.getServerPort()!= 80? ":" + request.getServerPort():"") + request.getContextPath() + "/jsp/rastreoRuta.jsp";
                out.println("<applet Archive='lib/jgraph.jar,lib/jgraphlayout.jar'  style='background:transparent;' ");
                out.println("CODEBASE='../cgtic/seguimiento' CODE='DiagramaAsuntos.class' WIDTH='800' HEIGHT='600' ALIGN='BOTTOM'>");
                out.println("<param name='elementos' value='" + elementos + "'>");
                out.println("<param name='inicio' value='" + ruta.getFolio() + "'>");
                out.println("<param name='masViejo' value='" + asuntosViejos + "'>");
                out.println("<param name='conPermiso' value='"+ asuntosConPermiso + "'>");
                out.println("<param name='nombres' value='" + nombres + "'>");
                out.println("<param name='relaciones' value='" + relaciones + "'>");
                out.println("<param name='relacionIDFolioStr' value='" + relacionIDFolioStr + "'>");
                out.println("<param name='urlDetalle' value='" + urlDetalle + "'>");
                out.println("<param name='urlRuta' value='" + urlRuta + "'>");
                out.println("<param name='w' value='120'>");
                out.println("<param name='h' value='30'>");
                out.println("</applet>");
            } else {
                out.println("No existen Relaciones para el asunto: " + ruta.getFolio());
            }
        }// Termina if (!resultadoOK)
%>
    </table>
    <input type="hidden" name="creado" id="creado" value="0"/>
<%  }  // Termina if(consulto && resultadoConsulta != null && resultadoConsulta.length > 0)
    else if(consulto&&! resultadoOK){ %>
    <table class="tableInstr" width="50%" cellspacing="0">
      <tr>
        <th>
          <div align="left">
            No existe una rutas de Rastreo para el asunto: <%=ruta.getFolio()%>
          </div>
        </th>
      </tr>
      </table>
    <%}else{%>
    <table class="tableInstr" width="50%" cellspacing="0">
      <tr>
        <th>
          <div align="left">
            Escriba un n&uacute;mero de folio...
          </div>
        </th>
      </tr>
      </table>
    <%}%>
  </body>
</html>

