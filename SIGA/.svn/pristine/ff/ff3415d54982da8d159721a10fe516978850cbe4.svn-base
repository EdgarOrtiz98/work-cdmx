<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"	
	
	import="com.meve.sigma.beans.*"
	import="com.meve.sigma.asunto.dao.*"	
	import="java.sql.Connection"
	import="com.meve.sigma.db2.DB2DataSource"
	import="com.meve.sigma.db2.ConexionDS"
	import="com.meve.sigma.db2.ConnectionPool"
	import="java.util.List"
	import="java.sql.SQLException"
	import="java.util.ArrayList"
	import="java.util.Iterator"
	import="com.meve.sigma.asunto.AsuntoContentForm"
	import="com.meve.sigma.servlet.DownLoadDicument"
	import="com.meve.sigma.sql.SQLArchivo"
	import="java.lang.Number"	
	import="java.io.*"        
	import="oracle.ifs.fdk.Item"
	import="com.meve.oracle.cm.WsConnection"
	import="com.meve.oracle.cm.ConnectionWebService"
	import="oracle.ifs.fdk.FileManager"
        import="com.meve.sigma.db2.ConexionDocs"
        import="com.meve.sigma.sql.SQLDocs"
        import="java.lang.StringBuffer.*"
        import="java.sql.PreparedStatement"
        import="java.sql.ResultSet"
%>
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}catch(java.io.IOException io){
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
<% if(!BUsuario.getAdmon()){ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<%
	String strAccion =request.getParameter("accion");
	int asuntosencontrados=0;
	String strIdArea	= request.getParameter("idarea");
	String strFechaDesde	= request.getParameter("Fecha_desde");
	String strFechaHasta	= request.getParameter("Fecha_hasta");
	if(strFechaDesde==null) strFechaDesde="";
	if(strFechaHasta==null) strFechaHasta="";
	if(strIdArea==null) strIdArea="";
	String contentUri = application.getInitParameter("content");
	String userContent = application.getInitParameter("user");
	String passContent = application.getInitParameter("passwd");
	String pathContent = application.getInitParameter("path");
	//System.out.println("contentUri: "+contentUri);
        //System.out.println("pathContent: "+pathContent);
        String strIdAsunto ="";	
	String strName ="";		
	String strFolio ="";	
	String strInstruccion ="";		
	String strIdUsuario ="";
	String content="";
	String Item="";
	String tipodoc="";
        String referencia = "";
	int cantasuntos = 1;//Integer.parseInt(request.getParameter("casuntos"));
        /*if(cantasuntos==1){
            System.out.println("Dentro");
        }*/
	//int cantasuntos =1;
	boolean bExisteArchivos = false;
	boolean bExisteArchivoDocS = false;	
	
	//if(strAccion != null && strAccion.equals("checarCantAsuntos"))
        /*if(cantasuntos==1)
        {
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			List asuntos = new ArrayList();	
			asuntos = AsuntoDao.getAsuntoscontent(conn,strIdArea,strFechaDesde,strFechaHasta);
			asuntosencontrados=asuntos.size();			
		}
		catch (Throwable t){
			t.printStackTrace();
		}								
	}*/	
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/valida.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<TITLE>Migración de Archivos</TITLE>
<script type="text/javascript">

    function fmigrar(){
        document.forms[0].accion.value="migrar";
        document.forms[0].submit();
    }

</script>
<STYLE type=text/css>BODY {
	MARGIN: 0px
}
</STYLE>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" onload="valida=0; timer_load();" 
	onKeyPress="timer_reload()" 
	onClick="timer_reload()">
<FORM name="confForm" action="ma1.jsp" method="post">
<INPUT type="hidden" value="" name="accion">
<TABLE cellspacing="0" cellpadding="0" width="99%" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="99%" colspan="2">
			<DIV align="right"></DIV>
			</TD>
			<TD width="1%">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><A href="../jsp/UsuariosView.jsp"> <IMG border="0"
				src="../Imagenes/NavLeft.gif" title="Regresar"> </A>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;				
				<!--a onclick="checarCantAsuntos()">
				<img src="../Imagenes/Turnar.png" title="Validar">
				</a-->
				</TD>
				<TD>
					<a onclick="fmigrar()">
					<img src="../Imagenes/Save.gif" title="Migrar">
					</a>
				</TD>														
			<TD width="125">
			</TD>			
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="48"></TD>
		</TR>
		<TR valign="top">
			<TD></TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="336" colspan="2" class="etiquetas1v"><B><FONT face="Verdana" color="#004080"
				size="2"></FONT><FONT size="+1"><B>Migración Content</B></FONT></B></TD>
			<TD width="144">&nbsp;</TD>
			<TD width="192">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="672" bgcolor="#004080" colspan="4"><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR VALIGN=top>
			
			<TD width="672">
				<FIELDSET dir="ltr">
				<LEGEND align="left"><FONT SIZE=2 FACE="Verdana">Filtro</FONT></LEGEND>	
				<TABLE>
					<TBODY>
						<TR>
							<TD>&nbsp;</TD>
						</TR>					
						<TR>  
							<TD>
							<FONT SIZE=1 FACE="Verdana">
							<!-- Archivos Encontrados=<FONT SIZE=4 FACE="Verdana"><%= asuntosencontrados%></FONT> -->
							</FONT>
							</TD>
						</TR>      
						<TR>
							<TD>&nbsp;</TD>
						</TR>
						<TR>							
							<TD>
							<FONT SIZE=1 FACE="Verdana">
							Por Unidad Administrativa:&nbsp;&nbsp;
							<INPUT name="idarea" type="text" class="blue50" value="<%=strIdArea%>" onKeyPress='AceptaSoloTeclaNumerica();'>
							</FONT>
							</TD>
						</TR>
						<TR>
							<TD>&nbsp;</TD>
						</TR>
						<TR>
							<TD>
							<FONT SIZE=1 FACE="Verdana">
							Por Fecha:&nbsp;&nbsp;de&nbsp;&nbsp;																
							<INPUT type="text" size="5" name="Fecha_desde" maxlength="10" class="blue100a" value="<%=strFechaDesde%>"
									onKeyPress="AceptaSoloTeclaNumericaYDiagonal();"
									onKeyUp = "validaFecha();">																
							<A><IMG height="20" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='show_calendar("forms[0].Fecha_desde");'></A>							
							&nbsp;&nbsp;a&nbsp;&nbsp;														
							<INPUT type="text" size="5" name="Fecha_hasta" maxlength="10" class="blue100a" value="<%=strFechaHasta%>"
									onKeyPress="AceptaSoloTeclaNumericaYDiagonal();"
									onKeyUp = "validaFecha();">
								<A><IMG height="20" src="../Imagenes/act_calFormat.gif" width="20" border="0" onclick='show_calendar("forms[0].Fecha_hasta");'></A>																																			              						
							</FONT>
							</TD>																				
						</TR>
						<TR>
							<TD>&nbsp;</TD>
						</TR>
						
						
<%
	if(strAccion != null && strAccion.equals("migrar")){				
            //////////////////   CONECTARSE AL CONTENT ////////////////////
            WsConnection s_WsCon=null;
            try{
                ConnectionWebService c = new ConnectionWebService(contentUri, userContent, passContent);
                s_WsCon = c.conectaOcs();
                //////////////////   MIGRAR ARCHIVOS ////////////////////
                if(s_WsCon!=null){
                    Connection conn = null;
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;
                    byte[] byArchivo = null;
                    try {
                        conn = ConexionDS.getConexion();
                        if(conn!=null)
                            if(conn.isClosed()==false){
                                StringBuffer sb = new StringBuffer(" SELECT  asunto.id_asunto,asunto.asu_folio_recepcion,contentm.* ");
                                sb.append(" FROM SD_ASUNTO asunto,sd_content_oracle contentm ");
                                sb.append(" where asunto.id_asunto=contentm.id_asunto_content ");
                                sb.append(" AND id_item_doc is null ");
                                if (strIdArea!="" && strIdArea.length()>0)
                                    sb.append(" and  asunto.asu_area_recepcion="+strIdArea);
                                if(strFechaDesde!="" && strFechaHasta!="" && strFechaDesde.length()>0 && strFechaHasta.length()>0)
                                    sb.append(" and asunto.asu_fecha_recepcion between TO_DATE('"+strFechaDesde+"','dd/mm/yyyy') and TO_DATE('"+strFechaHasta+"','dd/mm/yyyy') ");
                                sb.append(" order by asunto.id_asunto desc ");
                                //System.out.println(sb);
                                try {
                                    pstmt = conn.prepareStatement(sb.toString());								
                                    rs = pstmt.executeQuery();
                                    while (rs.next()) {
                                            strIdAsunto=rs.getString("ID_ASUNTO");          //System.out.println("strIdAsunto :"+strIdAsunto);
                                            strName=rs.getString("NOMBRE_ARCHIVO");         //System.out.println("strName :"+strName);
                                            strFolio=rs.getString("ASU_FOLIO_RECEPCION");   //System.out.println("strFolio :"+strFolio);
                                            content=rs.getString("CONTENT_TYPE");           //System.out.println("content :"+content);
                                            strIdUsuario=rs.getString("ID_USUARIO_CONTENT");//System.out.println("strIdUsuario :"+strIdUsuario);
                                            Item=rs.getString("ID_ITEM_DOC");               //System.out.println("Item :"+Item);
                                            strInstruccion=rs.getString("ID_INS_CONTENT");  //System.out.println("strInstruccion :"+strInstruccion);
                                            tipodoc=rs.getString("TIPO_DOCUMENTO");         //System.out.println("tipodoc :"+tipodoc);
                                            referencia=rs.getString("ID_REFERENCIA");       //System.out.println("referencia :"+referencia);
                                            ///////////////////////   DOWNLOAD   ///////////////////////			
                                            byArchivo = null;
                                            try{
                                                Item newDocumento=null;
                                                Item workspace;
                                                String serverUrl = contentUri+"/content/ws";
                                                FileManager fm = s_WsCon.getFileManager();				
                                                workspace = fm.resolvePath( pathContent + "/" +  strFolio, null);
                                                newDocumento = DownLoadDicument.searchItems(strName, workspace,s_WsCon); 	 
                                                if(newDocumento!=null){
                                                    ConexionDS.ejecutarActualizacion("UPDATE SD_CONTENT_ORACLE SET ID_ITEM_DOC = 2 WHERE ID_ASUNTO_CONTENT = '"+strIdAsunto+"' AND ID_REFERENCIA = '"+referencia+"'  AND NOMBRE_ARCHIVO = '"+strName+"' AND ID_USUARIO_CONTENT= '"+strIdUsuario+"'");
                                                    byArchivo = DownLoadDicument.downloadDocument(newDocumento,s_WsCon);				
                                                }else System.out.println("No se encontro el archivo el archivo: idasunto="+strIdAsunto+",instrucción="+strInstruccion+",archivo="+strName+",usuario="+strIdUsuario);
                                            }catch (Exception ea){System.out.println(ea.getMessage());}
                                            //////////////////   INSERTA ARCHIVO EN BLOB ////////////////////
                                            if(byArchivo!=null && byArchivo.length > 0){
                                            boolean bInsertArchivo = false;
                                            int exito = 0;
                                            try{
                                                bInsertArchivo = ConexionDocs.insertaBlob(SQLDocs.insArchivo(referencia,strIdAsunto,strName,strFolio),byArchivo);
                                                if (bInsertArchivo){
                                                    exito =ConexionDS.ejecutarActualizacion("UPDATE SD_CONTENT_ORACLE SET ID_ITEM_DOC = 1 WHERE ID_ASUNTO_CONTENT = '"+strIdAsunto+"' AND ID_REFERENCIA = '"+referencia+"'  AND NOMBRE_ARCHIVO = '"+strName+"' AND ID_USUARIO_CONTENT= '"+strIdUsuario+"'");
                                                    if(exito!=1)System.out.println("No se actualizo campo id_item_doc de: "+"referencia="+referencia+", strIdAsunto: "+strIdAsunto+", strName:"+strName+", strFolio: "+strFolio);
                                                }else{System.out.println("No se inserto archivo en base de datos docs: idasunto="+strIdAsunto+",instrucción="+strInstruccion+",archivo="+strName+",usuario="+strIdUsuario);}
                                            }catch(Exception e){System.out.println(e.getMessage());}
                                            }else System.out.println("No se pudo bajar el archivo del content: referencia="+referencia+", strIdAsunto: "+strIdAsunto+", strName:"+strName+", strFolio: "+strFolio);
                                    }//while
           %>
                                            <TR>								
                                                <TD align="left">
                                                        <FONT face="Arial" size="2"><b>Se terminó la carga de archivos.</b></FONT>
                                                </TD>
                                            </TR>
           <%
                               }catch (SQLException e){System.out.println(e.getMessage());
                               }finally {ConexionDS.endConnection(rs, pstmt, null);}
                            }else System.out.println("ma1.jsp -> conn.isClosed()==true");
                        else System.out.println("ma1.jsp -> conn==null");
                    }catch (SQLException e){System.out.println(e.getMessage());
                    }finally {ConexionDS.endConnection(null, null, conn);}	
                }else System.out.println("Error al conectarse al Content Oracle");
            }catch(Exception ec){System.out.println(ec.getMessage());
            }finally{if(s_WsCon!=null)s_WsCon.logout();}   
        }//if
	%>																				
					</TBODY>
				</TABLE>
			</FIELDSET>
		</TD>
	</TR>

	</TBODY>
</TABLE>
</DIV>
</FORM>
</BODY>
</HTML>
