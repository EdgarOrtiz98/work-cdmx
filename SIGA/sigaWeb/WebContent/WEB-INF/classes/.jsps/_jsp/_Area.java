package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.beans.*;


public class _Area extends com.orionserver.http.OrionHttpJspPage {


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
    _Area page = this;
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
      out.write(__oracle_jsp_text[3]);
      out.write(__oracle_jsp_text[4]);
      
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
      	String strIdArea	=	"";
      	String strIdArea1 	= 	ActualizaUsuario.getAreaUsuario(BUsuario.getIdUsuario());
      	strIdArea			=	(request.getParameter("id_area")== null)?"":request.getParameter("id_area");
      
      out.write(__oracle_jsp_text[5]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[6]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[7]);
      }
      out.write(__oracle_jsp_text[8]);
       if(BUsuario.getAdmon() ||
      		(BUsuario.getSupervisor() && strIdArea.equals(BUsuario.getIdArea()))){ 
      out.write(__oracle_jsp_text[9]);
      }else{
      out.write(__oracle_jsp_text[10]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[11]);
      }
      out.write(__oracle_jsp_text[12]);
      
      	String strArea			=	(request.getParameter("area")== null)?"":request.getParameter("area");
      	String strDescripcion	=	(request.getParameter("areaDescripcion")== null)?"":request.getParameter("areaDescripcion");
      	String strIdResponsable	=	(request.getParameter("areaResponsable")== null)?"":request.getParameter("areaResponsable");
      	String strCreador		=	"";
      	String strCreador1		=	"";		
      	String strFechaCreacion	=	"";
      	String strAccion		=	"";
      	String strEstatus		=	"1";
      	String strAreas[][]		=	null;
      	String strHoraEntrada	=	(request.getParameter("hora_entrada")== null)?"":request.getParameter("hora_entrada");
      	String strHoraSalida	=	(request.getParameter("hora_salida")== null)?"":request.getParameter("hora_salida");
      	String strMinEntrada	=	(request.getParameter("min_entrada")== null)?"":request.getParameter("min_entrada");
      	String strMinSalida		=	(request.getParameter("min_salida")== null)?"":request.getParameter("min_salida");
      	String strLogo			=	"";
      	String strClave			=	(request.getParameter("areaClave")== null)?"":request.getParameter("areaClave");
      	String strIdAreaPadre	=	(request.getParameter("areaPadre")== null)?"":request.getParameter("areaPadre");
      	String strIdResponTMP	=	(request.getParameter("idres")== null)?"":request.getParameter("idres");
      	String strBandera		=	(request.getParameter("areaExterna")== null)?"0":request.getParameter("areaExterna");
      	String strSubVent		=	(request.getParameter("areaSubventanilla")== null)?"0":request.getParameter("areaSubventanilla");
      	String strCtrlEnt		=	"0";
      	String strCtrlSal		=	"0";
      
      	String strArea2 = "1a2b3c";
      	String retURI = (request.getParameter("retURI")== null)?"AreaView.jsp":request.getParameter("retURI");
      
      	boolean bInsertar		=	false;
      	int valida = -2;
      
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFechaCreacion 				=	sdf.format(f);
      	String strFechaCreacion2 		=	strFechaCreacion;
      	
      	strCreador1		=	BUsuario.getIdUsuario();
      	strCreador		=	ActualizaUsuario.NombreUsuario(strCreador1);
      	
      	strAccion		=	request.getParameter("accion");
      	
      	if(strIdArea != null && strIdArea.length()!=0)
      	{
      		strAreas=ActualizaArea.getAreas(strIdArea);
      		strArea=strAreas[0][0];		
      		strDescripcion=strAreas[0][1];
      		strIdResponsable=strAreas[0][2];
      		strHoraEntrada = strAreas[0][3];
      		strHoraSalida = strAreas[0][4];
      		strMinEntrada = strAreas[0][5];
      		strMinSalida = strAreas[0][6];
      		strClave = strAreas[0][7];
      		strIdAreaPadre = strAreas[0][8];
      		strCtrlEnt = strAreas[0][9];
      		strCtrlSal = strAreas[0][10];
      		strCreador = ActualizaUsuario.NombreUsuario(strAreas[0][11]);
      		strFechaCreacion2 = strAreas[0][12];
      		strBandera = strAreas[0][13];
      		strSubVent = strAreas[0][14];
      		strArea2 = strArea;
      	}
      
      	if(strHoraEntrada.length()==1)
      		strHoraEntrada = "0"+strHoraEntrada;
      	if(strHoraSalida.length()==1)
      		strHoraSalida = "0"+strHoraSalida;
      	if(strMinEntrada.length()==1)
      		strMinEntrada = "0"+strMinEntrada;
      	if(strMinSalida.length()==1)
      		strMinSalida = "0"+strMinSalida;
      	
      	if(strAccion != null && strAccion.equals("guardar"))
      	{
      		strArea				=	request.getParameter("area");
      		strDescripcion		=	request.getParameter("areaDescripcion");
      		strIdResponsable	=	request.getParameter("areaResponsable");
      		strHoraEntrada		=	request.getParameter("hora_entrada");
      		strMinEntrada		=	request.getParameter("min_entrada");
      		strHoraSalida		=	request.getParameter("hora_salida");
      		strMinSalida		=	request.getParameter("min_salida");
      		strClave			=	request.getParameter("areaClave");
      		strIdAreaPadre		=	request.getParameter("areaPadre");
      		strCtrlEnt			=	request.getParameter("areaCtrlEntrada"); 
      		strCtrlSal			=	request.getParameter("areaCtrlSalida");
      		strArea2			=	request.getParameter("area2");
      		strBandera			=	(request.getParameter("areaExterna")== null)?"1":request.getParameter("areaExterna");
      		strSubVent			=	(request.getParameter("areaSubventanilla")== null)?"1":request.getParameter("areaSubventanilla");
      		////System.err.println("strBandera="+strBandera);
      		
      		valida = ActualizaArea.getAreaExiste(strArea, strArea2);
      
      		if (valida == 2){ 
      			bInsertar	=	ActualizaArea.InsertarArea(	strIdArea, strArea, strDescripcion, strIdResponsable,
      														strFechaCreacion, strCreador1, strEstatus,
      														strHoraEntrada, strHoraSalida, strMinEntrada,
      														strMinSalida, 0, strClave, strIdAreaPadre,
      														strCtrlEnt, strCtrlSal, strBandera, strSubVent);
      			try{ 
      				//response.sendRedirect("AreaView.jsp");
      				response.sendRedirect(retURI);
      			}catch(java.io.IOException io){
      				//System.out.println("io->"+io);
      			}
      		}			
      	}
      	
      
      out.write(__oracle_jsp_text[13]);
      if (strIdArea!=null && strIdArea.length()!=0){ 
      out.write(__oracle_jsp_text[14]);
      out.print(strIdArea );
      out.write(__oracle_jsp_text[15]);
      }
      out.write(__oracle_jsp_text[16]);
      out.print(strArea2 );
      out.write(__oracle_jsp_text[17]);
      out.print(strIdResponTMP );
      out.write(__oracle_jsp_text[18]);
      out.print(retURI );
      out.write(__oracle_jsp_text[19]);
      out.print( retURI );
      out.write(__oracle_jsp_text[20]);
      out.print((strIdArea!=null && strIdArea.length()!=0)?"última Modificación por: ":"Creado por: ");
      out.write(__oracle_jsp_text[21]);
      out.print( strCreador );
      out.write(__oracle_jsp_text[22]);
      out.print( strFechaCreacion2 );
      out.write(__oracle_jsp_text[23]);
      if (valida == 1) {
      out.write(__oracle_jsp_text[24]);
      } 
      out.write(__oracle_jsp_text[25]);
      if(BUsuario.getAdmon()){
      out.write(__oracle_jsp_text[26]);
      out.print(strArea );
      out.write(__oracle_jsp_text[27]);
      }else{
      out.write(__oracle_jsp_text[28]);
      out.print(strArea );
      out.write(__oracle_jsp_text[29]);
      out.print(strArea );
      out.write(__oracle_jsp_text[30]);
      }
      out.write(__oracle_jsp_text[31]);
      if(BUsuario.getAdmon()){
      out.write(__oracle_jsp_text[32]);
      out.print(strClave );
      out.write(__oracle_jsp_text[33]);
      }else{
      out.write(__oracle_jsp_text[34]);
      out.print(strClave );
      out.write(__oracle_jsp_text[35]);
      out.print(strClave );
      out.write(__oracle_jsp_text[36]);
      }
      out.write(__oracle_jsp_text[37]);
      if(BUsuario.getAdmon()){
      out.write(__oracle_jsp_text[38]);
      out.print(strDescripcion );
      out.write(__oracle_jsp_text[39]);
      }else{
      out.write(__oracle_jsp_text[40]);
      out.print(strDescripcion );
      out.write(__oracle_jsp_text[41]);
      out.print(strDescripcion );
      out.write(__oracle_jsp_text[42]);
      }
      out.write(__oracle_jsp_text[43]);
      if(strIdArea != null && strIdArea.length()!=0){
      out.write(__oracle_jsp_text[44]);
      if(BUsuario.getAdmon()){
      out.write(__oracle_jsp_text[45]);
      if(strIdResponTMP.length()>0){
      out.write(__oracle_jsp_text[46]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getUsuarioCombo(strIdArea));
        __jsp_taghandler_1.setName("areaResponsable");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strIdResponTMP));
        __jsp_taghandler_1.setClassHtml("blue600a");
        __jsp_taghandler_1.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='cambioArea(this)'");
        __jsp_taghandler_1.setTextoNoSeleccion("-- Selecciona un Puesto --");
        __jsp_taghandler_1.setValorNoSeleccion("null");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[47]);
      }else{
      out.write(__oracle_jsp_text[48]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getUsuarioCombo(strIdArea));
        __jsp_taghandler_2.setName("areaResponsable");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdResponsable));
        __jsp_taghandler_2.setClassHtml("blue600a");
        __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='cambioArea(this)'");
        __jsp_taghandler_2.setTextoNoSeleccion("-- Selecciona un Puesto --");
        __jsp_taghandler_2.setValorNoSeleccion("null");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[49]);
      }
      out.write(__oracle_jsp_text[50]);
      }else{
      out.write(__oracle_jsp_text[51]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getUsuarioCombo(strIdArea));
        __jsp_taghandler_3.setName("areaResponsable1");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strIdResponsable));
        __jsp_taghandler_3.setDisabled(true);
        __jsp_taghandler_3.setClassHtml("blue600a");
        __jsp_taghandler_3.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='cambioArea(this)'");
        __jsp_taghandler_3.setTextoNoSeleccion("-- Selecciona un Puesto --");
        __jsp_taghandler_3.setValorNoSeleccion("null");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[52]);
      out.print( strIdResponsable);
      out.write(__oracle_jsp_text[53]);
      }
      out.write(__oracle_jsp_text[54]);
      if(strIdResponTMP.length()>0){
      out.write(__oracle_jsp_text[55]);
      if(!strIdResponTMP.equals("null")){
      out.write(__oracle_jsp_text[56]);
      out.print(ActualizaUsuario.NombreUsuario(strIdResponTMP));
      out.write(__oracle_jsp_text[57]);
      }else{
      out.write(__oracle_jsp_text[58]);
      }
      out.write(__oracle_jsp_text[59]);
      }else{
      out.write(__oracle_jsp_text[60]);
      if(strIdResponsable.length()!=0){
      out.write(__oracle_jsp_text[61]);
      out.print(ActualizaUsuario.NombreUsuario(strIdResponsable));
      out.write(__oracle_jsp_text[62]);
      }else{
      out.write(__oracle_jsp_text[63]);
      }
      out.write(__oracle_jsp_text[64]);
      }
      out.write(__oracle_jsp_text[65]);
      }else{
      out.write(__oracle_jsp_text[66]);
      }
      out.write(__oracle_jsp_text[67]);
      if(BUsuario.getAdmon()){
      out.write(__oracle_jsp_text[68]);
      if(strIdArea.length()!=0){
      out.write(__oracle_jsp_text[69]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getAreaComboExcluyeId(strIdArea));
        __jsp_taghandler_4.setName("areaPadre");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( strIdAreaPadre));
        __jsp_taghandler_4.setClassHtml("blue600a");
        __jsp_taghandler_4.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_4.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_4.setValorNoSeleccion("null");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[70]);
      }else{
      out.write(__oracle_jsp_text[71]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_5=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setData(ComboData.getAreasCombo());
        __jsp_taghandler_5.setName("areaPadre");
        __jsp_taghandler_5.setSize(1);
        __jsp_taghandler_5.setSelected(OracleJspRuntime.toStr( strIdAreaPadre));
        __jsp_taghandler_5.setClassHtml("blue600a");
        __jsp_taghandler_5.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_5.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_5.setValorNoSeleccion("null");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[72]);
      }
      out.write(__oracle_jsp_text[73]);
      }else{
      out.write(__oracle_jsp_text[74]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_6=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setData(ComboData.getAreaComboExcluyeId(strIdArea));
        __jsp_taghandler_6.setName("areaPadre1");
        __jsp_taghandler_6.setSize(1);
        __jsp_taghandler_6.setSelected(OracleJspRuntime.toStr( strIdAreaPadre));
        __jsp_taghandler_6.setDisabled(true);
        __jsp_taghandler_6.setClassHtml("blue600a");
        __jsp_taghandler_6.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
        __jsp_taghandler_6.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
        __jsp_taghandler_6.setValorNoSeleccion("null");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[75]);
      out.print( strIdAreaPadre );
      out.write(__oracle_jsp_text[76]);
      }
      out.write(__oracle_jsp_text[77]);
      if(BUsuario.getAdmon()){
      out.write(__oracle_jsp_text[78]);
      for(int i=0;i<24;i++){
      out.write(__oracle_jsp_text[79]);
      
      					String a = String.valueOf(i);
      					if(a.length()==1)
      						a="0"+a;
      					
      out.write(__oracle_jsp_text[80]);
      out.print(a);
      out.write(__oracle_jsp_text[81]);
      out.print((strHoraEntrada.trim().equals(""+a+"")?"selected":""));
      out.write(__oracle_jsp_text[82]);
      out.print(a);
      out.write(__oracle_jsp_text[83]);
      }
      out.write(__oracle_jsp_text[84]);
      for(int i=0;i<60;i++){
      out.write(__oracle_jsp_text[85]);
      
      					String a = String.valueOf(i);
      					if(a.length()==1)
      						a="0"+a;
      					
      out.write(__oracle_jsp_text[86]);
      out.print(a);
      out.write(__oracle_jsp_text[87]);
      out.print((strMinEntrada.trim().equals(""+a+"")?"selected":""));
      out.write(__oracle_jsp_text[88]);
      out.print(a);
      out.write(__oracle_jsp_text[89]);
      }
      out.write(__oracle_jsp_text[90]);
      }else{
      out.write(__oracle_jsp_text[91]);
      for(int i=0;i<24;i++){
      out.write(__oracle_jsp_text[92]);
      
      					String a = String.valueOf(i);
      					if(a.length()==1){
      						a="0"+a;
      					}
      					
      out.write(__oracle_jsp_text[93]);
      out.print(a);
      out.write(__oracle_jsp_text[94]);
      out.print((strHoraEntrada.trim().equals(""+a+"")?"selected":""));
      out.write(__oracle_jsp_text[95]);
      out.print(a);
      out.write(__oracle_jsp_text[96]);
      }
      out.write(__oracle_jsp_text[97]);
      out.print(strHoraEntrada);
      out.write(__oracle_jsp_text[98]);
      for(int i=0;i<60;i++){
      out.write(__oracle_jsp_text[99]);
      
      					String a = String.valueOf(i);
      					if(a.length()==1){
      						a="0"+a;
      					}
      					
      out.write(__oracle_jsp_text[100]);
      out.print(a);
      out.write(__oracle_jsp_text[101]);
      out.print((strMinEntrada.trim().equals(""+a+"")?"selected":""));
      out.write(__oracle_jsp_text[102]);
      out.print(a);
      out.write(__oracle_jsp_text[103]);
      }
      out.write(__oracle_jsp_text[104]);
      out.print(strMinEntrada);
      out.write(__oracle_jsp_text[105]);
      }
      out.write(__oracle_jsp_text[106]);
      if(BUsuario.getAdmon()){
      out.write(__oracle_jsp_text[107]);
      for(int i=0;i<24;i++){
      out.write(__oracle_jsp_text[108]);
      
      					String a = String.valueOf(i);
      					if(a.length()==1)
      						a="0"+a;
      					
      out.write(__oracle_jsp_text[109]);
      out.print(a);
      out.write(__oracle_jsp_text[110]);
      out.print((strHoraSalida.trim().equals(""+a+"")?"selected":""));
      out.write(__oracle_jsp_text[111]);
      out.print(a);
      out.write(__oracle_jsp_text[112]);
      }
      out.write(__oracle_jsp_text[113]);
      for(int i=0;i<60;i++){
      out.write(__oracle_jsp_text[114]);
      
      					String a = String.valueOf(i);
      					if(a.length()==1)
      						a="0"+a;
      					
      out.write(__oracle_jsp_text[115]);
      out.print(a);
      out.write(__oracle_jsp_text[116]);
      out.print((strMinSalida.trim().equals(""+a+"")?"selected":""));
      out.write(__oracle_jsp_text[117]);
      out.print(a);
      out.write(__oracle_jsp_text[118]);
      }
      out.write(__oracle_jsp_text[119]);
      }else{
      out.write(__oracle_jsp_text[120]);
      for(int i=0;i<24;i++){
      out.write(__oracle_jsp_text[121]);
      
      					String a = String.valueOf(i);
      					if(a.length()==1)
      						a="0"+a;
      					
      out.write(__oracle_jsp_text[122]);
      out.print(a);
      out.write(__oracle_jsp_text[123]);
      out.print((strHoraSalida.trim().equals(""+a+"")?"selected":""));
      out.write(__oracle_jsp_text[124]);
      out.print(a);
      out.write(__oracle_jsp_text[125]);
      }
      out.write(__oracle_jsp_text[126]);
      out.print(strHoraSalida);
      out.write(__oracle_jsp_text[127]);
      for(int i=0;i<60;i++){
      out.write(__oracle_jsp_text[128]);
      
      					String a = String.valueOf(i);
      					if(a.length()==1)
      						a="0"+a;
      					
      out.write(__oracle_jsp_text[129]);
      out.print(a);
      out.write(__oracle_jsp_text[130]);
      out.print((strMinSalida.trim().equals(""+a+"")?"selected":""));
      out.write(__oracle_jsp_text[131]);
      out.print(a);
      out.write(__oracle_jsp_text[132]);
      }
      out.write(__oracle_jsp_text[133]);
      out.print(strMinSalida);
      out.write(__oracle_jsp_text[134]);
      }
      out.write(__oracle_jsp_text[135]);
      if(BUsuario.getAdmon()){
      out.write(__oracle_jsp_text[136]);
      out.print((strBandera.equals("0")?"checked":""));
      out.write(__oracle_jsp_text[137]);
      }else{
      out.write(__oracle_jsp_text[138]);
      out.print((strBandera.equals("0")?"checked":""));
      out.write(__oracle_jsp_text[139]);
      out.print(strBandera);
      out.write(__oracle_jsp_text[140]);
      }
      out.write(__oracle_jsp_text[141]);
      out.print((strSubVent.equals("0")?"checked":""));
      out.write(__oracle_jsp_text[142]);
      out.write(__oracle_jsp_text[143]);
      out.print(strCtrlSal);
      out.write(__oracle_jsp_text[144]);
      out.print(strCtrlEnt );
      out.write(__oracle_jsp_text[145]);

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
  private static final char __oracle_jsp_text[][]=new char[146][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<HTML>\n<HEAD>\n<TITLE>Unidad Administrativa</TITLE>\n".toCharArray();
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
    "\n".toCharArray();
    __oracle_jsp_text[11] = 
    "\n".toCharArray();
    __oracle_jsp_text[12] = 
    "\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n}\n</STYLE>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\"\n\tonLoad=\"valida=0;timer_load();\" onKeyPress=\"timer_reload()\" \n\tonClick=\"timer_reload()\">\n<FORM action=\"Area.jsp\" name=\"Area\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n".toCharArray();
    __oracle_jsp_text[14] = 
    " \n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"id_area\">\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"area2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"idres\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"retURI\">\n\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\"><A href=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\"> <IMG border=\"0\"\n\t\t\t\tsrc=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"> </A>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<a onclick=\"guardarArea()\">\n\t\t\t\t<img src=\"../Imagenes/Save.gif\" alt=\"Guardar\">\n\t\t\t\t</a>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" class=\"etiquetas1v\"><B><FONT size=\"+1\">Unidad\n\t\t\tAdministrativa</FONT></B></TD>\n\t\t\t<TD colspan=\"2\" align=\"right\">&nbsp;<FONT color=\"black\">**Los datos\n\t\t\tmarcados con negritas son obligatorios</FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<td width=\"672\" bgcolor=\"#004080\" colspan=\"4\"><img\n\t\t\tsrc=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></td>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t<TD align=\"right\" colspan=\"3\"><FONT face=\"Verdana\"\n\t\t\t\tsize=\"2\">".toCharArray();
    __oracle_jsp_text[21] = 
    "<I>".toCharArray();
    __oracle_jsp_text[22] = 
    " - ".toCharArray();
    __oracle_jsp_text[23] = 
    "</I></FONT>\n\t\t\t</TD> \n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;<BR></TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\" class=\"etiquetas\"><b>Nombre Unidad:</b>\n\t\t\t".toCharArray();
    __oracle_jsp_text[24] = 
    "<br>\n\t\t\t<FONT color=\"red\"><B>*Esta Unidad ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[26] = 
    "\n\t\t\t\t<INPUT type=\"text\" class=\"blue600a\" size=\"80\" name=\"area\" value=\"".toCharArray();
    __oracle_jsp_text[27] = 
    "\" maxlength=\"199\">\n\t\t\t\t<INPUT type=\"hidden\" name=\"bandera\" value=\"1\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[28] = 
    "\n\t\t\t\t<INPUT type=\"text\" class=\"blue600a\" size=\"80\" name=\"area1\" value=\"".toCharArray();
    __oracle_jsp_text[29] = 
    "\" maxlength=\"199\" disabled=\"disabled\">\n\t\t\t\t<INPUT type=\"hidden\" name=\"area\" value=\"".toCharArray();
    __oracle_jsp_text[30] = 
    "\">\n\t\t\t\t<INPUT type=\"hidden\" name=\"bandera\" value=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[31] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\" class=\"etiquetas\"><b>Clave de la Unidad:</b></TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t<INPUT class=\"blue200a\" size=\"80\" name=\"areaClave\" value=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "\" maxlength=\"49\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\n\t\t\t\t<INPUT class=\"blue200a\" size=\"80\" name=\"areaClave1\" value=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\" maxlength=\"49\" disabled=\"disabled\">\n\t\t\t\t<INPUT type=\"hidden\" name=\"areaClave\" value=\"".toCharArray();
    __oracle_jsp_text[36] = 
    "\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t\t</FONT>\n\t\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\" class=\"etiquetas\">Descripción:</TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[38] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"areaDescripcion\" value=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\" maxlength=\"199\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t\t<INPUT class=\"blue600a\" size=\"80\" name=\"areaDescripcion1\" value=\"".toCharArray();
    __oracle_jsp_text[41] = 
    "\" maxlength=\"199\" disabled=\"disabled\">\n\t\t\t\t<INPUT type=\"hidden\" name=\"areaDescripcion\" value=\"".toCharArray();
    __oracle_jsp_text[42] = 
    "\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\" class=\"etiquetas\">Puesto:</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t<TD width=\"528\" colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[47] = 
    " </FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t\t<TD width=\"528\" colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[49] = 
    " </FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t<TD width=\"528\" colspan=\"3\"><FONT SIZE=2 FACE=\"Verdana\">".toCharArray();
    __oracle_jsp_text[52] = 
    " </FONT>\n\t\t\t\t<INPUT type=\"hidden\" name=\"areaResponsable\" value=\"".toCharArray();
    __oracle_jsp_text[53] = 
    "\">\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\">Responsable:</FONT></TD>\n\t\t\t<TD width=\"192\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t\t\t\tNo tiene Responsable Asignado\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t\t\tNo tiene Responsable Asignado\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    " \n\t\t<TR valign=\"top\">\n\t\t\t<TD>&nbsp;</TD>\n\t\t\t<TD>&nbsp;\n\t\t\t<INPUT name=\"areaResponsable\" type=\"hidden\" value=\"null\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\" class=\"etiquetas\">Unidad Padre:</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t\t\t<INPUT type=\"hidden\" name=\"areaPadre\" value=\"".toCharArray();
    __oracle_jsp_text[76] = 
    "\">\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\" class=\"etiquetas\"><b>Hora de Entrada:</b></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<SELECT name=\"hora_entrada\" class=\"blue50a\">\n\t\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[81] = 
    "\" ".toCharArray();
    __oracle_jsp_text[82] = 
    ">".toCharArray();
    __oracle_jsp_text[83] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t\t<SELECT name=\"min_entrada\" class=\"blue50a\">\n\t\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[87] = 
    "\" ".toCharArray();
    __oracle_jsp_text[88] = 
    ">".toCharArray();
    __oracle_jsp_text[89] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<SELECT name=\"hora_entrada1\" class=\"blue50a\" disabled=\"disabled\">\n\t\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[94] = 
    "\" ".toCharArray();
    __oracle_jsp_text[95] = 
    ">".toCharArray();
    __oracle_jsp_text[96] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[97] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t<INPUT type=\"hidden\" name=\"hora_entrada\" value=\"".toCharArray();
    __oracle_jsp_text[98] = 
    "\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t\t<SELECT name=\"min_entrada1\" class=\"blue50a\" disabled=\"disabled\">\n\t\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[100] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[101] = 
    "\" ".toCharArray();
    __oracle_jsp_text[102] = 
    ">".toCharArray();
    __oracle_jsp_text[103] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t<INPUT type=\"hidden\" name=\"min_entrada\" value=\"".toCharArray();
    __oracle_jsp_text[105] = 
    "\">\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[106] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\" class=\"etiquetas\"><b>Hora de Salida:</b></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<SELECT name=\"hora_salida\" class=\"blue50a\">\n\t\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[109] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[110] = 
    "\" ".toCharArray();
    __oracle_jsp_text[111] = 
    ">".toCharArray();
    __oracle_jsp_text[112] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t\t<SELECT name=\"min_salida\" class=\"blue50a\">\n\t\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[116] = 
    "\" ".toCharArray();
    __oracle_jsp_text[117] = 
    ">".toCharArray();
    __oracle_jsp_text[118] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[120] = 
    "\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<SELECT name=\"hora_salida1\" class=\"blue50a\" disabled=\"disabled\">\n\t\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[121] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[123] = 
    "\" ".toCharArray();
    __oracle_jsp_text[124] = 
    ">".toCharArray();
    __oracle_jsp_text[125] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t<INPUT type=\"hidden\" name=\"hora_salida\" value=\"".toCharArray();
    __oracle_jsp_text[127] = 
    "\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">:</FONT>\n\t\t\t\t<SELECT name=\"min_salida1\" class=\"blue50a\" disabled=\"disabled\">\n\t\t\t\t\t<OPTION value=\"-1\">--</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[130] = 
    "\" ".toCharArray();
    __oracle_jsp_text[131] = 
    ">".toCharArray();
    __oracle_jsp_text[132] = 
    "</OPTION>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t\t\t</SELECT>\n\t\t\t\t<INPUT type=\"hidden\" name=\"min_salida\" value=\"".toCharArray();
    __oracle_jsp_text[134] = 
    "\">\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[135] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\" class=\"etiquetas\">Operando en SIGA:</TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[136] = 
    "\n\t\t\t\t<INPUT type=\"checkbox\" name=\"areaExterna\" value=\"0\" ".toCharArray();
    __oracle_jsp_text[137] = 
    ">Si\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[138] = 
    "\n\t\t\t\t<INPUT type=\"checkbox\" name=\"areaExterna1\" disabled=\"disabled\" value=\"0\" ".toCharArray();
    __oracle_jsp_text[139] = 
    ">Si\n\t\t\t\t<INPUT type=\"hidden\" name=\"areaExterna\" value=\"".toCharArray();
    __oracle_jsp_text[140] = 
    "\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[141] = 
    "\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\" class=\"etiquetas\">Manejo de Subventanilla:</TD>\n\t\t\t<TD width=\"528\" colspan=\"3\">\n\t\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t<INPUT type=\"checkbox\" name=\"areaSubventanilla\" value=\"0\" ".toCharArray();
    __oracle_jsp_text[142] = 
    ">Si\n\t\t\t\t</FONT>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[143] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"100%\" colspan=\"4\">\n\t\t\t\t<FIELDSET dir=\"ltr\">\n\t\t\t\t\t<LEGEND align=\"left\">\n\t\t\t\t\t\t<FONT SIZE=2 FACE=\"Verdana\"  color=\"#004080\"><B>Folio de Control</B></FONT>\n\t\t\t\t\t</LEGEND>\n\t\t\t\t\t<TABLE>\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t\t\t<TD width=\"144\" class=\"etiquetas\"><B>A&ntilde;o:</B></TD>\n\t\t\t\t\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT\n\t\t\t\t\t\t\t\tclass=\"blue50a\" size=\"80\" name=\"areaCtrlSalida\"\n\t\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[144] = 
    "\" maxlength=\"4\" onKeyPress='AceptaSoloTeclaNumerica();'></FONT></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t\t\t<TD width=\"144\" class=\"etiquetas\"><B>Consecutivo:</B></TD>\n\t\t\t\t\t\t\t<TD width=\"528\" colspan=\"3\"><FONT face=\"Verdana\" size=\"2\"><INPUT\n\t\t\t\t\t\t\t\tclass=\"blue50a\" size=\"80\" name=\"areaCtrlEntrada\"\n\t\t\t\t\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[145] = 
    "\" maxlength=\"5\" onKeyPress='AceptaSoloTeclaNumericaYPunto();'></FONT></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR valign=\"top\">\n\t\t\t\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t\t\t\t\t<TD width=\"192\">&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t</TBODY>\n\t\t\t\t\t</TABLE>\n\t\t\t\t</FIELDSET>\n\t\t\t</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
