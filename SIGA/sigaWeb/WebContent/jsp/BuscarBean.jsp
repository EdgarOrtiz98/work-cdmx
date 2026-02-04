<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="header.jsp" flush="false"></jsp:include>
<jsp:useBean id="BeanBuscar"
	class="com.meve.sigma.beans.search.BuscarCampoIns" scope="page">
	<jsp:setProperty name="BeanBuscar" property="*" />
</jsp:useBean>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="com.meve.sigma.beans.*,com.meve.sigma.beans.search.*,com.meve.sigma.actualiza.*,
			com.meve.sigma.util.*, java.util.*, gob.hacienda.cgtic.siga.util.*"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
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
<%

	String contentUri = application.getInitParameter("content");
	String passContent = application.getInitParameter("user");
	String userContent = application.getInitParameter("passwd");
	String pathContent = application.getInitParameter("path");
	String strCreador1 = 	BUsuario.getIdUsuario();
	String strAreaUs	=	BUsuario.getIdArea();
	String[] strBusqueda = null;
	String[] strIdAsunto = null;
	StringTokenizer tokens;
	
	String strContenido = request.getParameter("buscaSobreContenido");
	String strBusquedaContent = request.getParameter("buscaContenido");
	
	if (strBusquedaContent== null || strBusquedaContent == ""){
		strBusquedaContent = "0";
	}

	String strResultado[][]		= null;
	String strEstatus = "99";
	String strTipoAte = "99";
	
	String strOrden = (request.getParameter("orden")!=null)?request.getParameter("orden"):"asc";
	String strTipo = (request.getParameter("tipo")!=null)?request.getParameter("tipo"):"2";
	int contPag 	= Integer.parseInt((request.getParameter("contPag")!=null)?request.getParameter("contPag"):"0");
	int contligas 	= Integer.parseInt((request.getParameter("contligas")!=null)?request.getParameter("contligas"):"0");

	int regPorPagina = 20;
	int muestraPaginas = 20;
	int iSAmarillo = 70;
	String[][] strConfig = com.meve.sigma.actualiza.ActualizaConfiguracion.getDatosConf();
	if(strConfig != null && strConfig.length > 0){
		regPorPagina 	= Integer.parseInt(strConfig[0][3]);
		muestraPaginas 	= Integer.parseInt(strConfig[0][4]);
		iSAmarillo		=	Integer.parseInt(strConfig[0][2]);
	}
	int numRegistros = 0;
	int numPaginas = 0;

	if(BeanBuscar.getbuscaEstatus() == null || BeanBuscar.getbuscaEstatus().equals("")){

		BeanBuscar 			= (BuscarCampoIns)session.getAttribute("UsuarioBuscaBeanIns");
		strResultado 		= (String[][])session.getAttribute("ResultadoBuscar");
		strContenido 		= (String)session.getAttribute("buscaSobreContenido");
		strBusquedaContent 	= (String)session.getAttribute("buscaContenido");
                int criterio = (strOrden.equalsIgnoreCase("ASC"))?1:0;
                int campo = 0;
                switch (Integer.parseInt(strTipo)) {
                    case 1:
                        campo = 1;
                    break;
                    case 2:
                        campo = 5;
                    break;
                    case 3:
                        campo = 15;
                    break;
                    case 4:
                        campo = 3;
                    break;
                    case 5:
                        campo = 2;
                    break;
                    default:
                        campo = 1;
                    break;
                }
                Arrays.sort(strResultado,new ComparatorIntruccionesResult(criterio,campo)); 
	}else {
                //Si no es asistente busca las instrucciones propias
                if(!BUsuario.getAsistente()) {
                    strResultado = ActualizaBuscar.getBuscarMultiCampoInstruccion(
                                            BeanBuscar,
                                            strOrden, strTipo,
                                            BUsuario.getIdUsuario(), 
                                            BUsuario.getIdArea(),
                                            strBusquedaContent);
                }
                
                //Si es asistente Busca las instrucciones de sus jefes
                if(BUsuario.getAsistente()) {
                    String[][] strJefes = ActualizaUsuario.getJefesDeAsistente(BUsuario.getIdUsuario());
                    ArrayList<String[]> resultadoJefes = new ArrayList<String[]>();
                    for(String[] jefe : strJefes ) {
                        String areaUsuario = ActualizaUsuario.getAreaUsuario(jefe[0]);
                        String[][] strResultadoAsistente = ActualizaBuscar.getBuscarMultiCampoInstruccion(
                                            BeanBuscar,
                                            strOrden, strTipo,
                                            jefe[0], 
                                            areaUsuario,
                                            strBusquedaContent);
                        for(String[] registro : strResultadoAsistente) {
                            resultadoJefes.add(registro);
                        }
                    }
                    strResultado = new String[resultadoJefes.size()][];
                    int i = 0;
                    for(String[] registro : resultadoJefes) {
                        strResultado[i++] = registro;
                    }
                    int criterio = (strOrden.equalsIgnoreCase("ASC"))?1:0;
                    int campo = 0;
                    switch (Integer.parseInt(strTipo)) {
                        case 1:
                            campo = 1;
                        break;
                        case 2:
                            campo = 5;
                        break;
                        case 3:
                            campo = 15;
                        break;
                        case 4:
                            campo = 3;
                        break;
                        case 5:
                            campo = 2;
                        break;
                        default:
                            campo = 1;
                        break;
                    }
                    Arrays.sort(strResultado,new ComparatorIntruccionesResult(criterio,campo));
		}

		if (strBusquedaContent.equals("5")){

			strBusqueda = com.meve.sigma.servlet.SearchArchiveByContent.searchByContent1(
								strContenido, strResultado, strAreaUs, contentUri, passContent, userContent, pathContent, "I");  

			if ( strBusqueda!=null && strBusqueda.length>0 && strResultado!=null && strResultado.length>0){
				////System.out.println("busqueda ....." + strBusqueda.length);

				Vector vContenido = new Vector();
				for (int i = 0; i < strBusqueda.length ; i++){

					if (!strBusqueda[i].equals("") && strBusqueda[i].length()>0){
						tokens=new StringTokenizer(strBusqueda[i], "|");
						int nDatos=tokens.countTokens();
						String[] datos=new String[nDatos];		
						int j=0;
					
						while(tokens.hasMoreTokens()){
   			         		String str=tokens.nextToken();
   		        		 	datos[j]=str;
   			         		//System.out.println(datos[j]);
   		    	     		j++;
   		     			}
				
						////System.out.println("  ***************  "+i+".- Folio="+datos[3]+" Archivo="+datos[0]);
						
						for (int k=0; k<strResultado.length; k++){
							if (strResultado[k][17].equals(datos[3]) && strResultado[k][16].equals(datos[0])){
								vContenido.add(strResultado[k]);
							}
						}
						
					}else{
						////System.out.println("  ***************  "+i+"    NADA    ");
					}
				}

				strResultado = new String[vContenido.size()][strResultado[0].length];
				for (int k=0; k<vContenido.size(); k++){
					strResultado[k] = (String[])vContenido.get(k);
				}

			}else {
				strResultado = new String[0][strResultado.length];
				////System.out.println("Sin resultados");
			}
		}

		String[] semaforo = BeanBuscar.getSemaforoAsunto();
		String strSemaforo = "";
		if (semaforo!=null && semaforo.length>0){
			for (int i=0; i<semaforo.length; i++){
				strSemaforo += semaforo[i];
			}
		}

		if (strResultado!=null && strResultado.length>0){
			Vector vResult = new Vector();

			for (int i=0; i<strResultado.length; i++){

				float fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(strResultado[i][13]).intValue(), strResultado[i][11], strResultado[i][12], 5);
				float iAvance = new Float(strResultado[i][14]).floatValue();
				if(fPorcentaje > 100){
					if (strSemaforo.indexOf('r')!=-1)
						vResult.add(strResultado[i]);				
				}else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
					if(fPorcentaje<=iAvance){
						if (strSemaforo.indexOf('v')!=-1)
							vResult.add(strResultado[i]);				
					}else{
						if (strSemaforo.indexOf('a')!=-1)
							vResult.add(strResultado[i]);				
					}
				}else if(fPorcentaje<iSAmarillo){
					if (strSemaforo.indexOf('v')!=-1)
						vResult.add(strResultado[i]);				
				} 
			}
		
			strResultado = new String[vResult.size()][strResultado[0].length];
			for (int i=0; i<vResult.size(); i++){
				strResultado[i] = (String[])vResult.get(i);
			}
		}
	}

	session.setAttribute("UsuarioBuscaBeanIns",BeanBuscar);
	session.setAttribute("ResultadoBuscar",strResultado);
	session.setAttribute("buscaSobreContenido",strContenido);
	session.setAttribute("buscaContenido",strBusquedaContent);
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
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<TITLE>Buscar por Instrucción</TITLE>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript">
<!--
	function cambio(o, t){
		doc = document.BuscarBean;
		doc.orden.value=o;
		doc.tipo.value=t;
		doc.submit();
	}
	function pagina(contador){
		doc = document.BuscarBean;
		doc.contPag.value=contador;
		doc.submit();
	}
	function paginaLiga(contador){
		doc = document.BuscarBean;
		doc.contligas.value=contador;
		doc.submit();
	}
//-->
</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg">
<span id="ruler" style="visibility:hidden;"></span> 
<FORM name="BuscarBean" action="BuscarBean.jsp" method="post">
<INPUT type="hidden" name="orden" value="<%=strOrden %>">
<INPUT type="hidden" name="tipo" value="<%=strTipo %>">
<INPUT type="hidden" value="<%=contPag %>" name="contPag">
<INPUT type="hidden" value="<%=contligas %>" name="contligas">
<INPUT type="hidden" value="<%=strContenido %>" name="buscaSobreContenido">
<INPUT type="hidden" value="<%=strBusquedaContent %>" name="buscaContenido">

<TABLE cellspacing="0" cellpadding="0" width="100%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%">&nbsp;</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
<TBODY>
	<TR>
		<TD width="20%" align="center">
			<INPUT type="button" class="blue200" value="Realizar Otra Busqueda" onclick="regresarBCIns()">
		</TD>
		<td width="20%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="40%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="20%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TBODY>
</table>
</DIV> 
<br>
<DIV align="center">
<table border="0" width="100%">
<TBODY>
	<TR bgcolor="#00204f">
		<TD width="15%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				<a onclick="cambio('asc', 1)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
				FOLIO DE RECEPCIÓN 
				<a onclick="cambio('desc', 1)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
				</FONT></b>
			</CENTER>
		</TD>
		<td id="Asunto_HD" width="20%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				<a onclick="cambio('asc', 2)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
				RESPONSABLE DE LA INSTRUCCIÓN
				<a onclick="cambio('desc', 2)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
				</FONT></b>
			</CENTER>
		</td>
		<td width="10%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				<a onclick="cambio('asc', 3)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
				TIPO DE ATENCION
				<a onclick="cambio('desc', 3)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
				</FONT></b>
			</CENTER>
		</td>
		<td id="Asunto_HD2" width="25%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				<a onclick="cambio('asc', 4)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
				INSTRUCCION
				<a onclick="cambio('desc', 4)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
				</FONT></b>
			</CENTER>
		</td>
		<td width="10%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				<a onclick="cambio('asc', 5)"><IMG border="0" src="../Imagenes/arriba.gif" align="middle" width="10" height="10"></a>
				FECHA DE GENERACIÓN
				<a onclick="cambio('desc', 5)"><IMG border="0" src="../Imagenes/abajo.gif" align="middle" width="10" height="10"></a>
				</FONT></b>
			</CENTER>
		</td>
		<td id="Asunto_HD3" width="20%">
			<CENTER>
				<b><FONT size="2" color="white" face="verdana">
				DOCUMENTOS ANEXADOS	
				</FONT></b>
			</CENTER>
		</td>
	</TR>
</TBODY>
</table>
</DIV>
<BR>
<% if(strResultado == null || strResultado.length == 0){ %>
<DIV align="center">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
<TBODY>
	<TR>
		<TD width="20%"><b><FONT size="2" color="red" face="Arial">
			No se encontraron Documentos</FONT></b></TD>
		<td width="20%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="40%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
		<td width="20%"><img src="../Imagenes/ecblank.gif" border="0"
			height="1" width="1" title=""></td>
	</TR>
</TBODY>
</table>
</DIV>
<% }else{ %>
<DIV class=documentBody id=Body>
<DIV align="center">
<table border="0" width="100%">
<TBODY>
	<TR>
		<TD align="left" colspan="2">
		<%	numRegistros = strResultado.length;
			if (numRegistros>0){ %>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<A onclick="window.open('../ReporteBeanExcel?tip=busquedaInst_beanExcel');" title="Exportar a Excel">
			<img src="../Imagenes/ic_excel.gif" border="0"></A>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<A onclick="window.open('../ReporteBeanPDF?tip=busquedaInst_bean');" title="Exportar a PDF">
			<img src="../Imagenes/ic_pdf.gif" border="0"></A>
		<%	} %>
		</TD>
		<TD align="right" colspan="5">
		<%	numPaginas = numRegistros/regPorPagina;	
			if (numRegistros%regPorPagina != 0)
				numPaginas++; %>
		<%	if (numRegistros > 0){	%>
			<%= numRegistros %> registros mostrados.
		<%	} %>
		<%	if (numPaginas > 1){	%>
			Pagina <%= contPag+1 %> de <%= numPaginas %>
		<% 	} %>
			&nbsp;&nbsp;&nbsp;&nbsp;
		</TD>
	</TR>
	<TR><TD><BR></TD></TR>
	<%	for (int j=contPag*regPorPagina; j<strResultado.length && j<(contPag+1)*regPorPagina; j++){ %>
	<TR <%if(par(j+1)==true){%><%}else{%>bgcolor="#f6f6f6"<%}%>>
		<TD width="15%">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial">
				<!-- <a href="InstruccionesAtender.jsp?id_ins=<%=strResultado[j][0]%>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) %>">
				<%=strResultado[j][1]%>
				</a>  -->
				<% 	if(strResultado[j][9].equals("0")){
						String padre1 = strResultado[j][10];
						if(padre1.length() != 0){ 
				%>
					<A href="InstruccionHija.jsp?id_ins=<%=strResultado[j][0]%>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) %>">
					<%=strResultado[j][1]%>
					</A> 
				<%		}else{ %>
					<A href="InstruccionesAtender.jsp?id_ins=<%=strResultado[j][0]%>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) %>">
					<%=strResultado[j][1]%>
					</A> 
				<% 		} %>
				<% } else if(strResultado[j][9].equals("1")){ %>
					<A href="InstruccionTurnada.jsp?id_ins=<%=strResultado[j][0]%>&retURI=<%= com.meve.sigma.util.Utilerias.codificaPostHTML(strTmp+"?orden="+strOrden+"&tipo="+strTipo+"&contPag="+contPag+"&contligas="+contligas+"&buscaSobreContenido="+strContenido+"&buscaContenido="+strBusquedaContent) %>">
					<%=strResultado[j][1]%>
					</A> 
				<% } %>

				</FONT>
			</CENTER>
		</TD>
		<td width="20%">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial">
				<A title="<%=strResultado[j][5]%>">
				<script> document.write(trunc('<%=strResultado[j][5]%>','Asunto_HD'));</script></A>	
				</FONT>
			</CENTER>
		</td>
		<td width="10%">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial">
				<%=strResultado[j][15]%>
				</FONT>
			</CENTER>
		</td>
		<td width="25%">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial">
				<A title="<%=strResultado[j][3]%>">
			<script> document.write(trunc('<%=strResultado[j][3]%>','Asunto_HD2'));</script></A></FONT>
			</CENTER>
		</td>
		<td width="10%">
			<CENTER>
				<FONT size="1" color="#000080" face="Arial"><%=strResultado[j][2]%></FONT>
			</CENTER>
		</td>
		<td width="20%">
			<CENTER>
				<% if (strBusquedaContent.equals("5")){ %>
					<FONT size="1" color="#000080" face="Arial">
					<A title="<%= strResultado[j][16] %>">
					<script> document.write(trunc('<%=strResultado[j][16]%>','Asunto_HD3'));</script></A></FONT>
					</A></FONT>
				<% }else{ %>
					<FONT size="1" color="#000080" face="Arial">
					<A title="<%= ActualizaArchivo.getStringNombreArchivosIns(strResultado[j][0]) %>">
					<script> document.write(trunc('<%=ActualizaArchivo.getStringNombreArchivosIns(strResultado[j][0])%>','Asunto_HD3'));</script></A></FONT>
				<% } %>
			</CENTER>
		</td>
	</TR>
	<% } %>
	<TR>
	<TD colspan="6" align="center"><BR>
		<%
		if (contligas>0 && numPaginas > muestraPaginas){  %>
			<A onclick="paginaLiga(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);pagina(<%= (contligas-muestraPaginas<0)?0:contligas-muestraPaginas %>);"> <B>&lt;&lt;Anterior | </B> </A> &nbsp;&nbsp;
		<%	}
		if (contPag > 0){  
			if (contPag > contligas){%>
			<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
		<%	}else{%>
			<A onclick="paginaLiga(<%=contligas-1%>);pagina(<%=contPag-1%>);"> <B>&lt;&lt;</B> </A> &nbsp;&nbsp;
		<%	} 
		}
		if (numPaginas > 1){
			for (int ik=contligas; ik<muestraPaginas+contligas && ik<numPaginas; ik++){ 
				if (ik==contPag){  %>
					<A onclick="pagina(<%=ik%>)"><FONT color="red"><B>[<%=ik+1%>]</B></FONT></A> &nbsp;
		<%		}else{ %>
					<A onclick="pagina(<%=ik%>)"><%=ik+1%></A> &nbsp;
		<%		}
			}
		} 
		if (contPag < numPaginas-1){  
			if (contPag < contligas + muestraPaginas-1){%>
				<A onclick="paginaLiga(<%=contligas%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
		<%	}else{%>
			<A onclick="paginaLiga(<%=contligas+1%>);pagina(<%=contPag+1%>);"> &nbsp; <B>&gt;&gt;</B> </A> &nbsp;&nbsp;
		<%	} 
		}
		if (contligas+muestraPaginas<numPaginas && numPaginas > muestraPaginas){  %>
			<A onclick="paginaLiga(<%= numPaginas-muestraPaginas %>);pagina(<%= numPaginas-1 %>);"> <B>FINAL</B> </A>
		<%	
		} %>
	</TD>
	</TR>
</TBODY>
</table>
</DIV>
</DIV>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
<% } %>
</FORM>
</BODY>
</HTML>
