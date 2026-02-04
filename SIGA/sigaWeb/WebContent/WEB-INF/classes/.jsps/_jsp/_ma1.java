package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.beans.*;
import com.meve.sigma.asunto.dao.*;
import java.sql.Connection;
import com.meve.sigma.db2.DB2DataSource;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.db2.ConnectionPool;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import com.meve.sigma.asunto.AsuntoContentForm;
import com.meve.sigma.servlet.DownLoadDicument;
import com.meve.sigma.sql.SQLArchivo;
import java.lang.Number;
import java.io.*;
import oracle.ifs.fdk.Item;
import com.meve.oracle.cm.WsConnection;
import com.meve.oracle.cm.ConnectionWebService;
import oracle.ifs.fdk.FileManager;
import com.meve.sigma.db2.ConexionDocs;
import com.meve.sigma.sql.SQLDocs;
import java.lang.StringBuffer.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class _ma1 extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html; charset=ISO-8859-1");
    /* set up the intrinsic variables using the pageContext goober:
    ** session = HttpSession
    ** application = ServletContext
    ** out = JspWriter
    ** page = this
    ** config = ServletConfig
    ** all session/app beans declared in globals.jsa
    */
    PageContext pageContext = JspFactory.getDefaultFactory().getPageContext( this, request, response, null, true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    int __jsp_tag_starteval;
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _ma1 page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        String __url=OracleJspRuntime.toStr("headerC.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      
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
      
      out.write(__oracle_jsp_text[3]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[4]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[5]);
       } 
      out.write(__oracle_jsp_text[6]);
       if(!BUsuario.getAdmon()){ 
      out.write(__oracle_jsp_text[7]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[8]);
       } 
      out.write(__oracle_jsp_text[9]);
      
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
      
      out.write(__oracle_jsp_text[10]);
      out.print( asuntosencontrados);
      out.write(__oracle_jsp_text[11]);
      out.print(strIdArea);
      out.write(__oracle_jsp_text[12]);
      out.print(strFechaDesde);
      out.write(__oracle_jsp_text[13]);
      out.print(strFechaHasta);
      out.write(__oracle_jsp_text[14]);
      
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
                 
      out.write(__oracle_jsp_text[15]);
      
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
      	
      out.write(__oracle_jsp_text[16]);

    }
    catch (Throwable e) {
      if (!(e instanceof javax.servlet.jsp.SkipPageException)){
        try {
          if (out != null) out.clear();
        }
        catch (Exception clearException) {
        }
        pageContext.handlePageException(e);
      }
    }
    finally {
      OracleJspRuntime.extraHandlePCFinally(pageContext, true);
      JspFactory.getDefaultFactory().releasePageContext(pageContext);
    }

  }
  private static final char __oracle_jsp_text[][]=new char[17][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n".toCharArray();
    __oracle_jsp_text[10] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\" type=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<TITLE>Migración de Archivos</TITLE>\n<script type=\"text/javascript\">\n\n    function fmigrar(){\n        document.forms[0].accion.value=\"migrar\";\n        document.forms[0].submit();\n    }\n\n</script>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0; timer_load();\" \n\tonKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM name=\"confForm\" action=\"ma1.jsp\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" width=\"99%\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"99%\" colspan=\"2\">\n\t\t\t<DIV align=\"right\"></DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"1%\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><A href=\"../jsp/UsuariosView.jsp\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"> </A>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t\t\t\t\n\t\t\t\t<!--a onclick=\"checarCantAsuntos()\">\n\t\t\t\t<img src=\"../Imagenes/Turnar.png\" alt=\"Validar\">\n\t\t\t\t</a-->\n\t\t\t\t</TD>\n\t\t\t\t<TD>\n\t\t\t\t\t<a onclick=\"fmigrar()\">\n\t\t\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Migrar\">\n\t\t\t\t\t</a>\n\t\t\t\t</TD>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t<TD width=\"125\">\n\t\t\t</TD>\t\t\t\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"336\" colspan=\"2\" class=\"etiquetas1v\"><B><FONT face=\"Verdana\" color=\"#004080\"\n\t\t\t\tsize=\"2\"></FONT><FONT size=\"+1\"><B>Migración Content</B></FONT></B></TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"672\" bgcolor=\"#004080\" colspan=\"4\"><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR VALIGN=top>\n\t\t\t\n\t\t\t<TD width=\"672\">\n\t\t\t\t<FIELDSET dir=\"ltr\">\n\t\t\t\t<LEGEND align=\"left\"><FONT SIZE=2 FACE=\"Verdana\">Filtro</FONT></LEGEND>\t\n\t\t\t\t<TABLE>\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD>&nbsp;</TD>\n\t\t\t\t\t\t</TR>\t\t\t\t\t\n\t\t\t\t\t\t<TR>  \n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t\t<!-- Archivos Encontrados=<FONT SIZE=4 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[11] = 
    "</FONT> -->\n\t\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>      \n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD>&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t\tPor Unidad Administrativa:&nbsp;&nbsp;\n\t\t\t\t\t\t\t<INPUT name=\"idarea\" type=\"text\" class=\"blue50\" value=\"".toCharArray();
    __oracle_jsp_text[12] = 
    "\" onKeyPress='AceptaSoloTeclaNumerica();'>\n\t\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD>&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t\tPor Fecha:&nbsp;&nbsp;de&nbsp;&nbsp;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<INPUT type=\"text\" size=\"5\" name=\"Fecha_desde\" maxlength=\"10\" class=\"blue100a\" value=\"".toCharArray();
    __oracle_jsp_text[13] = 
    "\"\n\t\t\t\t\t\t\t\t\tonKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\"\n\t\t\t\t\t\t\t\t\tonKeyUp = \"validaFecha();\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<A><IMG height=\"20\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='show_calendar(\"forms[0].Fecha_desde\");'></A>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t&nbsp;&nbsp;a&nbsp;&nbsp;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<INPUT type=\"text\" size=\"5\" name=\"Fecha_hasta\" maxlength=\"10\" class=\"blue100a\" value=\"".toCharArray();
    __oracle_jsp_text[14] = 
    "\"\n\t\t\t\t\t\t\t\t\tonKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\"\n\t\t\t\t\t\t\t\t\tonKeyUp = \"validaFecha();\">\n\t\t\t\t\t\t\t\t<A><IMG height=\"20\" src=\"../Imagenes/act_calFormat.gif\" width=\"20\" border=\"0\" onclick='show_calendar(\"forms[0].Fecha_hasta\");'></A>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t              \t\t\t\t\t\t\n\t\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t\t</TD>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD>&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n                                            <TR>\t\t\t\t\t\t\t\t\n                                                <TD align=\"left\">\n                                                        <FONT face=\"Arial\" size=\"2\"><b>Se terminó la carga de archivos.</b></FONT>\n                                                </TD>\n                                            </TR>\n           ".toCharArray();
    __oracle_jsp_text[16] = 
    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\t\t\t</FIELDSET>\n\t\t</TD>\n\t</TR>\n\n\t</TBODY>\n</TABLE>\n</DIV>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
