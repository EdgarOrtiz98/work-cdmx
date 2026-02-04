package _jsp;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;
import com.meve.sigma.taglib.*;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.beans.*;
import java.util.*;


public class _ExpedienteArch extends com.orionserver.http.OrionHttpJspPage {


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
    _ExpedienteArch page = this;
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
      	String 	cat	= BUsuario.getCatArchivado();
      	if(BUsuario==null){
      		try{
      			response.sendRedirect("index.jsp?pagina="+ strTmp);
      		}
      		catch(java.io.IOException io){
      			//System.out.println("ERROR:"+io.getMessage());
      		}
      	}
      
      out.write(__oracle_jsp_text[5]);
       if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
      		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
      		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
      out.write(__oracle_jsp_text[6]);
      if (true) {
        String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
        // Forward 
        pageContext.forward( __url);
        return;
      }

      out.write(__oracle_jsp_text[7]);
       } 
      out.write(__oracle_jsp_text[8]);
      
      
      	String msg = "";
      	String strpasaAnio		= 	"";
      	String strIdSubfondo	=	"";
      	String strCodigo		=	"";
      	String strSeccion		=	"";
      	String strUsrActualiza	=	"";
      	String strFecha			=	"";
      	String strAccion		=	"";
      	String cls				=	"";
      	String cve_UA			=	"";
      	String strareatxt		= 	"";
      	String ano_exp			=	"";
      	String ced_tip			=	"";
      	String strinterno		=	"";
      	String strdenom			=	"";
      	String strtotaldisp		=	"";
      	String strfundamento	=	"";
      	String strmotivo		=	"";
      	String strobserv		=	"";
      	String stranioresv		=	"";
      	String stranioreal		=	"";
      	String strtotalcls		=	"";
      	String sisiConsulcls	=	"";
      	String strano_Amp		=	"";
      	String strfecAmpli		=	"";	
      	String strano_reduc		=	"";	
      	String stranioguard		=	"";	
      	String fec_apert		=	"";
      	String fec_cierre		=	"";	
      	String ano_AC			=	"";		
      	String ano_AT			=	"";		
      	String strClave			=	"";	
      	String strValor			=	"";
      	String strClasifInf		=	"";		
      	String strConsec		=	"";	
      	String strUbica			=	"";
      	String strUbicaFis		=	"";	
      	String strInact			=	"";
      	String strFecInac		=	"";
      	String strsisiConsuldisp=	"";
      	String strJustInac		=	"";	
      	String ver				=	"";		
      	String horafec			=	"";
      	String strsoloDesc 		=	"";
      	
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha						=	sdf.format(f);
      	
      	String strAux = "1234567";
      	String strAux2 = "1234567";
      	String strAux3 = "1234567";
      	String voice = "";
      	strSeccion	=	(request.getParameter("subSeccion")!= null)?request.getParameter("subSeccion"):"";
      	strCodigo	=	(request.getParameter("subCodigo")!= null)?request.getParameter("subCodigo"):"";
      	cls			=   (request.getParameter("cls")!= null)?request.getParameter("cls"):"";
      	cve_UA			=	(request.getParameter("cve_UA")!= null)?request.getParameter("cve_UA"):BUsuario.getIdArea();
      	ano_exp			=	(request.getParameter("ano_exp")!= null)?request.getParameter("ano_exp"):"";
      	ced_tip			=	(request.getParameter("ced_tip")!= null)?request.getParameter("ced_tip"):"";
      	fec_apert		=	(request.getParameter("fec_apert")!= null)?request.getParameter("fec_apert"):strFecha;
      	fec_cierre		=	(request.getParameter("fec_cierre")!= null)?request.getParameter("fec_cierre"):"";
      	ano_AC			=	(request.getParameter("ano_AC")!= null)?request.getParameter("ano_AC"):"";
      	ano_AT			=	(request.getParameter("ano_AT")!= null)?request.getParameter("ano_AT"):"";
      	strClave		=	(request.getParameter("clave")!= null)?request.getParameter("clave"):"";			
      	strClasifInf	=	(request.getParameter("idclsinf")!= null)?request.getParameter("idclsinf"):"";		
      	strConsec		=	(request.getParameter("consec")!= null)?request.getParameter("consec"):"";
      	strUbica		=	(request.getParameter("ubica")!= null)?request.getParameter("ubica"):"";
      	strUbica		=	(request.getParameter("ubicaFis")!= null)?request.getParameter("ubicaFis"):"";
      	strareatxt		= 	(request.getParameter("areatxt")!= null)?request.getParameter("areatxt"):"";
      	strUbicaFis		= 	(request.getParameter("UbicaFis")!= null)?request.getParameter("UbicaFis"):"";
      	strpasaAnio		= 	(request.getParameter("pasaanio")!= null)?request.getParameter("pasaanio"):"";
      	boolean bInsertar		=	false;
      		int bInsertar1		=	0;
      		int valida		=	0;
      
      	Vector finesSemana = com.meve.sigma.util.Utilerias.getFinesSemana(1,1);
      	String diasFestivos[][] = ActualizaDiaFestivo.getListaDiasFestivos();
      	if (diasFestivos!=null && diasFestivos.length>0){
      		for (int i=0; i<diasFestivos.length; i++){
      			finesSemana.add(com.meve.sigma.util.Utilerias.formatearFechas(diasFestivos[i][1]));
      		}
      	}
      
      	String retURI = (request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
      	strAccion		=	request.getParameter("accion");
      	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      				strSeccion		=	request.getParameter("subSeccion");
      				strCodigo 	 	=	request.getParameter("subCodigo");
      				cve_UA			=	request.getParameter("cve_UA"); 
      				strareatxt		=	request.getParameter("areatxt"); 
      				ano_exp			=	request.getParameter("ano_exp"); 
      				ced_tip			=	request.getParameter("ced_tip"); 
      				strinterno		=	request.getParameter("interno"); 
      				strdenom		=	request.getParameter("denom"); 
      				strValor		=	request.getParameter("valor"); 
      				fec_apert		=	request.getParameter("fec_apert"); 
      				ano_AC			=	(request.getParameter("ano_AC")!= null)?request.getParameter("ano_AC"):request.getParameter("ano_AC2");	
      				ano_AT			=	(request.getParameter("ano_AT")!= null)?request.getParameter("ano_AT"):request.getParameter("ano_AT2");	 
      				strsisiConsuldisp=	request.getParameter("sisiConsuldisp"); 
      				strClave		=	request.getParameter("clave").toUpperCase();				
      				strClasifInf	=	request.getParameter("idclsinf");		
      				strConsec		=	request.getParameter("consec");		
      				strUbica 		=	request.getParameter("ubica");	
      				strUbicaFis		=	request.getParameter("UbicaFis");
      				strfundamento	=	request.getParameter("fundamento");
      				strmotivo 		=	request.getParameter("motivo");
      				stranioreal		=	request.getParameter("anioresv");	
      				stranioresv 	=	stranioreal;
      				strobserv 		=	request.getParameter("observ");	
      				sisiConsulcls	=	request.getParameter("sisiConsulcls");	
      				strtotaldisp	=	(request.getParameter("totaldisp")!= null)?request.getParameter("totaldisp"):request.getParameter("totaldisp2");	
      				strtotalcls		=	request.getParameter("totalcls");	
      				strano_Amp		=	request.getParameter("ano_Amp");
      				strfecAmpli		=	request.getParameter("fecAmpli");
      				stranioguard	=	request.getParameter("anioguard");
      										
      
      			bInsertar1	=	ActualizaExpArchivado.insertarExpediente(cve_UA,strareatxt, ced_tip,strClave,strinterno,
      									strUbica,strdenom,strSeccion,
      									strValor,fec_cierre,ano_AT,ano_AC,strsisiConsuldisp,strtotaldisp,strClasifInf,strmotivo,
      									strfundamento, strobserv,stranioresv,stranioreal,sisiConsulcls,strtotalcls,strano_Amp,strfecAmpli,
      									stranioguard,BUsuario.getIdUsuario(),fec_apert,strConsec,strUbicaFis,strAux, strAux2, strAux3);
      			 
      			
      		if(bInsertar1 != 2){
      							try{
      								response.sendRedirect(retURI+"&msg="+msg);
      							}catch(java.io.IOException io){
      								//System.err.println("io->"+io);
      							}
      							String strDatoIdExp[][] = ActualizaExpArchivado.getExpedienteID(strClave);
      							strIdSubfondo = strDatoIdExp[0][0];
      							}
      				
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      				strsoloDesc 	=	request.getParameter("soloDesc");
      				cve_UA			=	request.getParameter("cve_UA2"); 
      				ced_tip			=	request.getParameter("ced_tip2"); 
      				strClasifInf	=	request.getParameter("idclsinf2");	
      				strSeccion		=	request.getParameter("subSeccion");
      				strareatxt		=	request.getParameter("areatxt"); 
      				ano_exp			=	request.getParameter("ano_exp"); 
      				ced_tip			=	request.getParameter("ced_tip"); 
      				strinterno		=	request.getParameter("interno"); 
      				strdenom		=	request.getParameter("denom"); 
      				strValor		=	request.getParameter("valor"); 
      				fec_apert		=	request.getParameter("fec_apert"); 
      				fec_cierre		=	request.getParameter("fec_cierre"); 	
      				ano_AC			=	(request.getParameter("ano_AC")!= null)?request.getParameter("ano_AC"):request.getParameter("ano_AC2");	
      				ano_AT			=	(request.getParameter("ano_AT")!= null)?request.getParameter("ano_AT"):request.getParameter("ano_AT2");	 
      				strsisiConsuldisp=	request.getParameter("sisiConsuldisp"); 
      				if (strsoloDesc!="1" && !strsoloDesc.equalsIgnoreCase("1"))
          	        {
      				strClave	=	request.getParameter("clave").toUpperCase(); 
      				}
      				strConsec		=	request.getParameter("consec");		
      				strUbica 		=	request.getParameter("ubica");	
      				strUbicaFis		=	request.getParameter("UbicaFis");				
      				strfundamento	=	request.getParameter("fundamento");
      				strmotivo 		=	request.getParameter("motivo");
      				stranioreal		=	request.getParameter("anioreal");	
      				stranioresv 	=	request.getParameter("anioresv");
      				strobserv 		=	request.getParameter("observ");	
      				sisiConsulcls	=	request.getParameter("sisiConsulcls");	
      				strtotaldisp	=	(request.getParameter("totaldisp")!= null)?request.getParameter("totaldisp"):request.getParameter("totaldisp2");
      				strtotalcls		=	request.getParameter("totalcls");	
      				strano_Amp		=	request.getParameter("ano_Amp");
      				strano_reduc	=	request.getParameter("ano_reduc");
      				strfecAmpli		=	request.getParameter("fecAmpli");
      				stranioguard	=	request.getParameter("anioguard");		
      				strInact		=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
      				strFecInac		=	request.getParameter("fecinact");
      				strJustInac		=	request.getParameter("justif");	
      				strAux 		= 	request.getParameter("aux"); 
      				strAux2 	= 	request.getParameter("aux2"); 
      				strAux3 	= 	request.getParameter("aux3"); 
      			
      			    
      			bInsertar1 = ActualizaExpArchivado.actualizaExpediente(strsoloDesc,cve_UA, strareatxt,  ced_tip , 
      								                 strClave, strinterno, strUbica , strdenom  ,
      								                 strSeccion  , strValor ,  fec_cierre ,
      								                 ano_AT , ano_AC, strsisiConsuldisp,  strtotaldisp, strClasifInf , 
      								                 strmotivo ,  strfundamento , strobserv , stranioresv , stranioreal,
      								                 sisiConsulcls,  strtotalcls, strano_Amp ,  strfecAmpli , 
      								                 stranioguard,  BUsuario.getIdUsuario(),fec_apert,strUbicaFis,strano_reduc, strIdSubfondo
      								                 ,strFecInac,strJustInac,strInact,strAux, strAux2, strAux3);
      			if(bInsertar1 != 2){
      				try{
      					response.sendRedirect(retURI+"&msg="+msg);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}
      	}
      	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	{
      		String strDatosSubfondo[][] = ActualizaExpArchivado.getExpedienteArch(strIdSubfondo);
      		cve_UA			=	strDatosSubfondo[0][0];
      		strareatxt		=	strDatosSubfondo[0][1];
      		ced_tip			=	strDatosSubfondo[0][2];
      		fec_apert		=	strDatosSubfondo[0][3];
      		strClave		=	strDatosSubfondo[0][4];
      		strinterno		=	strDatosSubfondo[0][5];
      		strUbica		=	strDatosSubfondo[0][6];
      		strdenom		=	strDatosSubfondo[0][7];
      		strSeccion		=	strDatosSubfondo[0][8];
      		strValor 		=	strDatosSubfondo[0][9];
      		fec_cierre		=	strDatosSubfondo[0][10];		
      		ano_AT			= 	strDatosSubfondo[0][11];
      		ano_AC			=	strDatosSubfondo[0][12];	
      		strsisiConsuldisp=	strDatosSubfondo[0][13];			
      		strtotaldisp	=	strDatosSubfondo[0][14];	
      		strClasifInf	=	strDatosSubfondo[0][15];
      		strmotivo 		=	strDatosSubfondo[0][16];					
      		strfundamento 	=	strDatosSubfondo[0][17];
      		strobserv 		=	strDatosSubfondo[0][18];
      		stranioresv		=	strDatosSubfondo[0][19];
      		stranioreal 	=	strDatosSubfondo[0][20];
      		sisiConsulcls	=	strDatosSubfondo[0][21];
      		strtotalcls		=	strDatosSubfondo[0][22];
      		strano_Amp 		=	strDatosSubfondo[0][23];
      		strfecAmpli 	=	strDatosSubfondo[0][24];
      		stranioguard	=	strDatosSubfondo[0][25];
      		strFecha 		=	strDatosSubfondo[0][26];
      		strInact		=	strDatosSubfondo[0][27];
      		strFecInac		=	strDatosSubfondo[0][28];
      		strJustInac		=	strDatosSubfondo[0][29];			
      		strUbicaFis		=	strDatosSubfondo[0][30];
      		strano_reduc	=	strDatosSubfondo[0][31];			
      		horafec 		=	strDatosSubfondo[0][32];					
      		strUsrActualiza	=	strDatosSubfondo[0][33];					
      		strAux			=  	strClave;				
      		strAux2			=  	cve_UA;				
      		strAux3			=  	ced_tip;
      		ver				=	"si";
      		valida	=	ActualizaExpArchivado.getValidaExpedienteArch(strIdSubfondo);
      	}
      
      	if(ced_tip != null && ced_tip.trim().length()>0)
      	{
      			String strDatosVal[][] = ActualizaExpArchivado.getValExpediente(ced_tip);
      			if (strDatosVal.length >0)
      			{
      			voice = strDatosVal[0][0];	
      			}
      	}
      
      out.write(__oracle_jsp_text[9]);
      if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	   {
      	   }
      	   else
      	   {
      	   
      out.write(__oracle_jsp_text[10]);
      }
      	   
      out.write(__oracle_jsp_text[11]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[12]);
      }
      out.write(__oracle_jsp_text[13]);
      if(valida != 2) 
      	{
      out.write(__oracle_jsp_text[14]);
      
      	}
      out.write(__oracle_jsp_text[15]);
      if(valida == 2) 
      	{
      out.write(__oracle_jsp_text[16]);
      
      	}
      out.write(__oracle_jsp_text[17]);
      out.print(horafec);
      out.write(__oracle_jsp_text[18]);
      out.print(ano_AT);
      out.write(__oracle_jsp_text[19]);
      if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	 	{
      out.write(__oracle_jsp_text[20]);
      out.print(strIdSubfondo);
      out.write(__oracle_jsp_text[21]);
      }
      out.write(__oracle_jsp_text[22]);
      for (int ik=0; ik<finesSemana.size(); ik++){ 
      out.write(__oracle_jsp_text[23]);
      out.print( (String)finesSemana.get(ik) );
      out.write(__oracle_jsp_text[24]);
      }
      out.write(__oracle_jsp_text[25]);
      out.print(strpasaAnio);
      out.write(__oracle_jsp_text[26]);
      out.print(ano_AT);
      out.write(__oracle_jsp_text[27]);
      out.print(ano_AC);
      out.write(__oracle_jsp_text[28]);
      out.print(strtotaldisp);
      out.write(__oracle_jsp_text[29]);
      out.print(strIdSubfondo);
      out.write(__oracle_jsp_text[30]);
      out.print(strAux);
      out.write(__oracle_jsp_text[31]);
      out.print(strAux2);
      out.write(__oracle_jsp_text[32]);
      out.print(strAux3);
      out.write(__oracle_jsp_text[33]);
      out.print(cve_UA);
      out.write(__oracle_jsp_text[34]);
      out.print(ced_tip);
      out.write(__oracle_jsp_text[35]);
      out.print(cls);
      out.write(__oracle_jsp_text[36]);
      out.print(strClasifInf);
      out.write(__oracle_jsp_text[37]);
      out.print(retURI);
      out.write(__oracle_jsp_text[38]);
      if(valida == 2){
      		strsoloDesc = "1";
      	}
      	
      out.write(__oracle_jsp_text[39]);
      out.print(strsoloDesc);
      out.write(__oracle_jsp_text[40]);
      out.print( retURI );
      out.write(__oracle_jsp_text[41]);
       if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[42]);
      out.print(ActualizaUsuario.NombreUsuario(strUsrActualiza));
      out.write(__oracle_jsp_text[43]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[44]);
       }else{ 
      out.write(__oracle_jsp_text[45]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[46]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[47]);
       } 
      out.write(__oracle_jsp_text[48]);
      if(valida == 2 || (strIdSubfondo != null && strIdSubfondo.trim().length()>0)){
      out.write(__oracle_jsp_text[49]);
       if(BUsuario.getSupervisor() && !cat.equalsIgnoreCase("1")){ 
      out.write(__oracle_jsp_text[50]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_1.setName("cve_UA");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( cve_UA));
        __jsp_taghandler_1.setDisabled(true);
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onchange='reload();'");
        __jsp_taghandler_1.setTextoNoSeleccion("---------- Selecciona área ----------");
        __jsp_taghandler_1.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[51]);
      }else{
      out.write(__oracle_jsp_text[52]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getAreasCombo());
        __jsp_taghandler_2.setName("cve_UA");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( cve_UA));
        __jsp_taghandler_2.setDisabled(true);
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setScript("onchange='reload();'");
        __jsp_taghandler_2.setTextoNoSeleccion("---------- Selecciona área ----------");
        __jsp_taghandler_2.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[53]);
      }
      out.write(__oracle_jsp_text[54]);
      }else{
      out.write(__oracle_jsp_text[55]);
       if(BUsuario.getSupervisor() && !cat.equalsIgnoreCase("1")){ 
      out.write(__oracle_jsp_text[56]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
        __jsp_taghandler_3.setName("cve_UA");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( cve_UA));
        __jsp_taghandler_3.setClassHtml("blue500");
        __jsp_taghandler_3.setScript("onchange='reload();'");
        __jsp_taghandler_3.setTextoNoSeleccion("---------- Selecciona área ----------");
        __jsp_taghandler_3.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[57]);
      }else{
      out.write(__oracle_jsp_text[58]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getAreasCombo());
        __jsp_taghandler_4.setName("cve_UA");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( cve_UA));
        __jsp_taghandler_4.setClassHtml("blue500");
        __jsp_taghandler_4.setScript("onchange='reload();'");
        __jsp_taghandler_4.setTextoNoSeleccion("---------- Selecciona área ----------");
        __jsp_taghandler_4.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[59]);
      }
      out.write(__oracle_jsp_text[60]);
      }
      out.write(__oracle_jsp_text[61]);
      out.print(strareatxt);
      out.write(__oracle_jsp_text[62]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[63]);
      
      						}
      out.write(__oracle_jsp_text[64]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[65]);
      	}
      out.write(__oracle_jsp_text[66]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[67]);
      
      						}
      out.write(__oracle_jsp_text[68]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[69]);
      	}
      out.write(__oracle_jsp_text[70]);
      out.print(fec_apert);
      out.write(__oracle_jsp_text[71]);
      if(valida != 2) 
      						{
      out.write(__oracle_jsp_text[72]);
      
      						}
      out.write(__oracle_jsp_text[73]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[74]);
      	}
      out.write(__oracle_jsp_text[75]);
      if(valida == 2  || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){
      out.write(__oracle_jsp_text[76]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[77]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_5=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setData(ComboData.getCedCombo(cve_UA));
        __jsp_taghandler_5.setName("ced_tip");
        __jsp_taghandler_5.setSize(1);
        __jsp_taghandler_5.setSelected(OracleJspRuntime.toStr( ced_tip));
        __jsp_taghandler_5.setDisabled(true);
        __jsp_taghandler_5.setClassHtml("blue500");
        __jsp_taghandler_5.setScript("onchange='ponerfecha();'");
        __jsp_taghandler_5.setTextoNoSeleccion(" ---------- Seleccione una Cédula Tipo --------- ");
        __jsp_taghandler_5.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[78]);
      } 
      					else {
      out.write(__oracle_jsp_text[79]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_6=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setData(ComboData.getCedCombo(cve_UA));
        __jsp_taghandler_6.setName("ced_tip");
        __jsp_taghandler_6.setSize(1);
        __jsp_taghandler_6.setSelected(OracleJspRuntime.toStr( ced_tip));
        __jsp_taghandler_6.setDisabled(true);
        __jsp_taghandler_6.setClassHtml("blue500");
        __jsp_taghandler_6.setScript("onchange='ponerfecha();'");
        __jsp_taghandler_6.setTextoNoSeleccion(" ---------- Seleccione una Cédula Tipo --------- ");
        __jsp_taghandler_6.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[80]);
      }
      out.write(__oracle_jsp_text[81]);
      }else{
      out.write(__oracle_jsp_text[82]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[83]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_7=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setData(ComboData.getCedCombo(cve_UA));
        __jsp_taghandler_7.setName("ced_tip");
        __jsp_taghandler_7.setSize(1);
        __jsp_taghandler_7.setSelected(OracleJspRuntime.toStr( ced_tip));
        __jsp_taghandler_7.setDisabled(true);
        __jsp_taghandler_7.setClassHtml("blue500");
        __jsp_taghandler_7.setScript("onchange='ponerfecha();'");
        __jsp_taghandler_7.setTextoNoSeleccion(" ---------- Seleccione una Cédula Tipo --------- ");
        __jsp_taghandler_7.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[84]);
      } 
      					else { 
      out.write(__oracle_jsp_text[85]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_8=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setData(ComboData.getCedCombo(cve_UA));
        __jsp_taghandler_8.setName("ced_tip");
        __jsp_taghandler_8.setSize(1);
        __jsp_taghandler_8.setSelected(OracleJspRuntime.toStr( ced_tip));
        __jsp_taghandler_8.setClassHtml("blue500");
        __jsp_taghandler_8.setScript("onchange='ponerfecha();'");
        __jsp_taghandler_8.setTextoNoSeleccion(" ---------- Seleccione una Cédula Tipo --------- ");
        __jsp_taghandler_8.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      out.write(__oracle_jsp_text[86]);
      }
      out.write(__oracle_jsp_text[87]);
      }
      out.write(__oracle_jsp_text[88]);
      if(valida == 2 ) 
      						{
      out.write(__oracle_jsp_text[89]);
      
      						}
      out.write(__oracle_jsp_text[90]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[91]);
      	}
      out.write(__oracle_jsp_text[92]);
      if(bInsertar1 == 2){ 
      out.write(__oracle_jsp_text[93]);
      } 
      out.write(__oracle_jsp_text[94]);
      out.print(strClave);
      out.write(__oracle_jsp_text[95]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[96]);
      
      						}
      out.write(__oracle_jsp_text[97]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[98]);
      	}
      out.write(__oracle_jsp_text[99]);
      out.print(strinterno);
      out.write(__oracle_jsp_text[100]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[101]);
      	}
      out.write(__oracle_jsp_text[102]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[103]);
      
      						}
      out.write(__oracle_jsp_text[104]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[105]);
      
      						}
      out.write(__oracle_jsp_text[106]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[107]);
      	}
      out.write(__oracle_jsp_text[108]);
      out.print(strUbica);
      out.write(__oracle_jsp_text[109]);
      if(valida == 2  || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){
      out.write(__oracle_jsp_text[110]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[111]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_9=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_9.setParent(null);
        __jsp_taghandler_9.setData(ComboData.getComboUbi(cve_UA));
        __jsp_taghandler_9.setName("UbicaFis");
        __jsp_taghandler_9.setSize(1);
        __jsp_taghandler_9.setSelected(OracleJspRuntime.toStr( strUbicaFis));
        __jsp_taghandler_9.setDisabled(true);
        __jsp_taghandler_9.setClassHtml("blue500");
        __jsp_taghandler_9.setScript("");
        __jsp_taghandler_9.setTextoNoSeleccion(" ---------- Seleccione una Ubicación Fisica --------- ");
        __jsp_taghandler_9.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
        if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,1);
      }
      out.write(__oracle_jsp_text[112]);
      } 
      					else {
      out.write(__oracle_jsp_text[113]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_10=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_10.setParent(null);
        __jsp_taghandler_10.setData(ComboData.getComboUbi(cve_UA));
        __jsp_taghandler_10.setName("UbicaFis");
        __jsp_taghandler_10.setSize(1);
        __jsp_taghandler_10.setSelected(OracleJspRuntime.toStr( strUbicaFis));
        __jsp_taghandler_10.setDisabled(true);
        __jsp_taghandler_10.setClassHtml("blue500");
        __jsp_taghandler_10.setScript("");
        __jsp_taghandler_10.setTextoNoSeleccion(" ---------- Seleccione una Ubicación Fisica --------- ");
        __jsp_taghandler_10.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
        if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,1);
      }
      out.write(__oracle_jsp_text[114]);
      }
      out.write(__oracle_jsp_text[115]);
      }else{
      out.write(__oracle_jsp_text[116]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[117]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_11=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_11.setParent(null);
        __jsp_taghandler_11.setData(ComboData.getComboUbi(cve_UA));
        __jsp_taghandler_11.setName("UbicaFis");
        __jsp_taghandler_11.setSize(1);
        __jsp_taghandler_11.setSelected(OracleJspRuntime.toStr( strUbicaFis));
        __jsp_taghandler_11.setClassHtml("blue500");
        __jsp_taghandler_11.setScript("");
        __jsp_taghandler_11.setTextoNoSeleccion(" ---------- Seleccione una Ubicación Fisica --------- ");
        __jsp_taghandler_11.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
        if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,1);
      }
      out.write(__oracle_jsp_text[118]);
      } 
      					else {
      out.write(__oracle_jsp_text[119]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_12=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_12.setParent(null);
        __jsp_taghandler_12.setData(ComboData.getComboUbi(cve_UA));
        __jsp_taghandler_12.setName("UbicaFis");
        __jsp_taghandler_12.setSize(1);
        __jsp_taghandler_12.setSelected(OracleJspRuntime.toStr( strUbicaFis));
        __jsp_taghandler_12.setClassHtml("blue500");
        __jsp_taghandler_12.setScript("");
        __jsp_taghandler_12.setTextoNoSeleccion(" ---------- Seleccione una Ubicación Fisica --------- ");
        __jsp_taghandler_12.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
        if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,1);
      }
      out.write(__oracle_jsp_text[120]);
      }
      out.write(__oracle_jsp_text[121]);
      }
      out.write(__oracle_jsp_text[122]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[123]);
      
      						}
      out.write(__oracle_jsp_text[124]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[125]);
      	}
      out.write(__oracle_jsp_text[126]);
      out.print(strdenom);
      out.write(__oracle_jsp_text[127]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[128]);
      	}
      out.write(__oracle_jsp_text[129]);
      out.print(strSeccion);
      out.write(__oracle_jsp_text[130]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){
      out.write(__oracle_jsp_text[131]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[132]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_13=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_13.setParent(null);
        __jsp_taghandler_13.setData(ComboData.getValorComboSub(voice));
        __jsp_taghandler_13.setName("valor");
        __jsp_taghandler_13.setSize(1);
        __jsp_taghandler_13.setSelected(OracleJspRuntime.toStr( strValor));
        __jsp_taghandler_13.setDisabled(true);
        __jsp_taghandler_13.setClassHtml("blue500");
        __jsp_taghandler_13.setScript("onchange=''");
        __jsp_taghandler_13.setTextoNoSeleccion(" ------------ Seleccione una Valoración------------ ");
        __jsp_taghandler_13.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
        if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,1);
      }
      out.write(__oracle_jsp_text[133]);
      }
      					else {
      out.write(__oracle_jsp_text[134]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_14=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_14.setParent(null);
        __jsp_taghandler_14.setData(ComboData.getValorComboSub(voice));
        __jsp_taghandler_14.setName("valor");
        __jsp_taghandler_14.setSize(1);
        __jsp_taghandler_14.setSelected(OracleJspRuntime.toStr( strValor));
        __jsp_taghandler_14.setDisabled(true);
        __jsp_taghandler_14.setClassHtml("blue500");
        __jsp_taghandler_14.setScript("onchange=''");
        __jsp_taghandler_14.setTextoNoSeleccion(" ------------ Seleccione una Valoración------------ ");
        __jsp_taghandler_14.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
        if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,1);
      }
      out.write(__oracle_jsp_text[135]);
      }
      out.write(__oracle_jsp_text[136]);
      }else{
      out.write(__oracle_jsp_text[137]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[138]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_15=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_15.setParent(null);
        __jsp_taghandler_15.setData(ComboData.getValorComboSub(voice));
        __jsp_taghandler_15.setName("valor");
        __jsp_taghandler_15.setSize(1);
        __jsp_taghandler_15.setSelected(OracleJspRuntime.toStr( strValor));
        __jsp_taghandler_15.setClassHtml("blue500");
        __jsp_taghandler_15.setScript("onchange=''");
        __jsp_taghandler_15.setTextoNoSeleccion(" ------------ Seleccione una Valoración------------ ");
        __jsp_taghandler_15.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
        if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,1);
      }
      out.write(__oracle_jsp_text[139]);
      }
      					else {
      out.write(__oracle_jsp_text[140]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_16=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_16.setParent(null);
        __jsp_taghandler_16.setData(ComboData.getValorComboSub(voice));
        __jsp_taghandler_16.setName("valor");
        __jsp_taghandler_16.setSize(1);
        __jsp_taghandler_16.setSelected(OracleJspRuntime.toStr( strValor));
        __jsp_taghandler_16.setClassHtml("blue500");
        __jsp_taghandler_16.setScript("onchange=''");
        __jsp_taghandler_16.setTextoNoSeleccion(" ------------ Seleccione una Valoración------------ ");
        __jsp_taghandler_16.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
        if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,1);
      }
      out.write(__oracle_jsp_text[141]);
      }
      out.write(__oracle_jsp_text[142]);
      }
      out.write(__oracle_jsp_text[143]);
      out.print(ano_AT);
      out.write(__oracle_jsp_text[144]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[145]);
      
      						}
      out.write(__oracle_jsp_text[146]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[147]);
      	}
      out.write(__oracle_jsp_text[148]);
      out.print(ano_AC);
      out.write(__oracle_jsp_text[149]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[150]);
      
      						}
      out.write(__oracle_jsp_text[151]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[152]);
      	}
      out.write(__oracle_jsp_text[153]);
      if(strsisiConsuldisp == "1" || strsisiConsuldisp.equals("1")) 
      					{
      out.write(__oracle_jsp_text[154]);
      }
      out.write(__oracle_jsp_text[155]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[156]);
      	}
      out.write(__oracle_jsp_text[157]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[158]);
      
      						}
      out.write(__oracle_jsp_text[159]);
      out.print(strtotaldisp);
      out.write(__oracle_jsp_text[160]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[161]);
      
      						}
      out.write(__oracle_jsp_text[162]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[163]);
      	}
      out.write(__oracle_jsp_text[164]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)){
      out.write(__oracle_jsp_text[165]);
       if(BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[166]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_17=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_17.setParent(null);
        __jsp_taghandler_17.setData(ComboData.getClasifInfCombo());
        __jsp_taghandler_17.setName("idclsinf");
        __jsp_taghandler_17.setSize(1);
        __jsp_taghandler_17.setSelected(OracleJspRuntime.toStr( strClasifInf));
        __jsp_taghandler_17.setDisabled(true);
        __jsp_taghandler_17.setClassHtml("blue500");
        __jsp_taghandler_17.setScript("onchange='cambio();'");
        __jsp_taghandler_17.setTextoNoSeleccion("---------- Clasificacion Informacion ----------");
        __jsp_taghandler_17.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
        if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,1);
      }
      out.write(__oracle_jsp_text[167]);
      }else{
      out.write(__oracle_jsp_text[168]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_18=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_18.setParent(null);
        __jsp_taghandler_18.setData(ComboData.getClasifInfCombo());
        __jsp_taghandler_18.setName("idclsinf");
        __jsp_taghandler_18.setSize(1);
        __jsp_taghandler_18.setSelected(OracleJspRuntime.toStr( strClasifInf));
        __jsp_taghandler_18.setDisabled(true);
        __jsp_taghandler_18.setClassHtml("blue500");
        __jsp_taghandler_18.setScript("onchange='cambio();'");
        __jsp_taghandler_18.setTextoNoSeleccion("---------- Clasificacion Informacion ----------");
        __jsp_taghandler_18.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
        if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,1);
      }
      out.write(__oracle_jsp_text[169]);
      }
      out.write(__oracle_jsp_text[170]);
      }else{
      out.write(__oracle_jsp_text[171]);
       if(BUsuario.getSupervisor()){ 
      out.write(__oracle_jsp_text[172]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_19=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_19.setParent(null);
        __jsp_taghandler_19.setData(ComboData.getClasifInfCombo());
        __jsp_taghandler_19.setName("idclsinf");
        __jsp_taghandler_19.setSize(1);
        __jsp_taghandler_19.setSelected(OracleJspRuntime.toStr( strClasifInf));
        __jsp_taghandler_19.setClassHtml("blue500");
        __jsp_taghandler_19.setScript("onchange='cambio();'");
        __jsp_taghandler_19.setTextoNoSeleccion("---------- Clasificacion Informacion ----------");
        __jsp_taghandler_19.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
        if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,1);
      }
      out.write(__oracle_jsp_text[173]);
      }else{
      out.write(__oracle_jsp_text[174]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_20=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_20.setParent(null);
        __jsp_taghandler_20.setData(ComboData.getClasifInfCombo());
        __jsp_taghandler_20.setName("idclsinf");
        __jsp_taghandler_20.setSize(1);
        __jsp_taghandler_20.setSelected(OracleJspRuntime.toStr( strClasifInf));
        __jsp_taghandler_20.setClassHtml("blue500");
        __jsp_taghandler_20.setScript("onchange='cambio();'");
        __jsp_taghandler_20.setTextoNoSeleccion("---------- Clasificacion Informacion ----------");
        __jsp_taghandler_20.setValorNoSeleccion("");
        __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
        if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,1);
      }
      out.write(__oracle_jsp_text[175]);
      }
      out.write(__oracle_jsp_text[176]);
      }
      out.write(__oracle_jsp_text[177]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[178]);
      
      						}
      out.write(__oracle_jsp_text[179]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[180]);
      	}
      out.write(__oracle_jsp_text[181]);
      out.print(strfundamento);
      out.write(__oracle_jsp_text[182]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[183]);
      
      						}
      out.write(__oracle_jsp_text[184]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[185]);
      	}
      out.write(__oracle_jsp_text[186]);
      out.print(strmotivo);
      out.write(__oracle_jsp_text[187]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[188]);
      
      						}
      out.write(__oracle_jsp_text[189]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[190]);
      	}
      out.write(__oracle_jsp_text[191]);
      out.print(strobserv);
      out.write(__oracle_jsp_text[192]);
      out.print(stranioresv);
      out.write(__oracle_jsp_text[193]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[194]);
      
      						}
      out.write(__oracle_jsp_text[195]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[196]);
      	}
      out.write(__oracle_jsp_text[197]);
      out.print(stranioreal);
      out.write(__oracle_jsp_text[198]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[199]);
      
      						}
      out.write(__oracle_jsp_text[200]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[201]);
      
      						}
      out.write(__oracle_jsp_text[202]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[203]);
      	}
      out.write(__oracle_jsp_text[204]);
      if(sisiConsulcls == "1" || sisiConsulcls.equals("1")) 
      				{
      out.write(__oracle_jsp_text[205]);
      }
      out.write(__oracle_jsp_text[206]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[207]);
      	}
      out.write(__oracle_jsp_text[208]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[209]);
      
      						}
      out.write(__oracle_jsp_text[210]);
      out.print(strtotalcls);
      out.write(__oracle_jsp_text[211]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[212]);
      
      						}
      out.write(__oracle_jsp_text[213]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[214]);
      	}
      out.write(__oracle_jsp_text[215]);
      out.print(strano_Amp);
      out.write(__oracle_jsp_text[216]);
      out.print(stranioguard);
      out.write(__oracle_jsp_text[217]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[218]);
      	}
      out.write(__oracle_jsp_text[219]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[220]);
      
      						}
      out.write(__oracle_jsp_text[221]);
      if(ver=="si" || ver.equalsIgnoreCase("si")) {
      out.write(__oracle_jsp_text[222]);
      out.print(strIdSubfondo);
      out.write(__oracle_jsp_text[223]);
      out.print(strsoloDesc);
      out.write(__oracle_jsp_text[224]);
      
      				}
      out.write(__oracle_jsp_text[225]);
      if(strInact == "3" || strInact.equals("3")) 
      						{
      out.write(__oracle_jsp_text[226]);
      
      						}
      out.write(__oracle_jsp_text[227]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[228]);
      
      						}
      out.write(__oracle_jsp_text[229]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[230]);
      	}
      out.write(__oracle_jsp_text[231]);
      out.print(strFecInac);
      out.write(__oracle_jsp_text[232]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[233]);
      	}
      out.write(__oracle_jsp_text[234]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[235]);
      
      						}
      out.write(__oracle_jsp_text[236]);
      if(valida == 2) 
      					{
      out.write(__oracle_jsp_text[237]);
      
      					}
      out.write(__oracle_jsp_text[238]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[239]);
      
      					}
      out.write(__oracle_jsp_text[240]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[241]);
      	}
      out.write(__oracle_jsp_text[242]);
      out.print(strJustInac);
      out.write(__oracle_jsp_text[243]);

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
  private static final char __oracle_jsp_text[][]=new char[244][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML>\n<HEAD>\n".toCharArray();
    __oracle_jsp_text[4] = 
    " \n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n".toCharArray();
    __oracle_jsp_text[8] = 
    "\n".toCharArray();
    __oracle_jsp_text[9] = 
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/Menu2.js\"></script>\n<script type=\"text/javascript\" src=\"../js/SigmaJS.js\"></script>\n<script type=\"text/javascript\" src=\"../js/link.js\"></script>\t\n<TITLE>Expedientes</TITLE>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<SCRIPT language=JavaScript type=text/javascript>\n<!-- \n\tfunction limpiarCampos(){\n\t\tdocument.expedientef.reset();\n\t}\n</SCRIPT>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\nvar claveexpediente = \"\";\n\n\tfunction asignavalor()\n\t{\n\tclaveexpediente = \"true\";\n\t}\n\t\n\tfunction anio() { \n\t\tanio= document.expedientef.fec_apert.value;\n\t\tdocument.expedientef.pasaanio.value = anio.substring(6);\n\t\t}\n\t\n\tfunction anio2() { \n\t   if(claveexpediente.length > 1)\n\t   {\n\t   ".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\t\t\tanio= document.expedientef.fec_apert.value;\n\t\t\tcv1= document.expedientef.clvExpdic.value;\n\t\t\tcv2= document.expedientef.ct.value;\n\t\t\tcv3= document.expedientef.consec.value;\n\t\t\t//document.expedientef.ano_exp.value = anio.substring(6);\n\t\t\tdocument.expedientef.clave.value = cv1+\".\"+anio.substring(6)+\".\"+cv2+ \".\" + cv3;\n\t\t\tclaveexpediente = \"\";\n\t\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n\t\t}\n\t\t}\t\t\nfunction detalle() { \n\tcambio();\n//\tdet= document.expedientef.cls.value;\n//\tdocument.getElementById('detalle').src= \"ClasifDetalle.jsp?cls=\"+det;\n\t}\nfunction detalle2() {\n\tcambio();\n\tval = \"pasa\";\n\t".toCharArray();
    __oracle_jsp_text[12] = 
    "\n\tval = \"\";\n\t".toCharArray();
    __oracle_jsp_text[13] = 
    "\n\taniocon = document.expedientef.pasaanio.value;\n\tdet2= document.expedientef.ced_tip.value;\n\tdocument.getElementById('detalle2').src= \"CedulaDetalle.jsp?cls=\"+det2+\"&anio=\"+aniocon+\"&valor=\"+val;\n\t}\t\nfunction reload() {\n\tcambio();\n\tdoc = document.expedientef;\n\tdoc.accion.value=\"reload\";\n\t".toCharArray();
    __oracle_jsp_text[14] = 
    "\n\tdoc.submit();\n\t".toCharArray();
    __oracle_jsp_text[15] = 
    "\n}\nfunction rValidando() {\n\t".toCharArray();
    __oracle_jsp_text[16] = 
    "\n\t//alert(\"El registro consultado no puede ser modificado\");\n\talert(\"Como este registro ya cuenta con registros dependientes, solo podra ser modificado su Descripción o ser cerrado.\");\n\t".toCharArray();
    __oracle_jsp_text[17] = 
    "\n}\nfunction cambio(){\n\tdoc = document.expedientef;\n\tval = doc.cve_UA.value;\n\tdoc.cve_UA2.value = val;\n\tval2 = doc.ced_tip.value;\n\tdoc.ced_tip2.value = val2;\t\n//\tval3 = doc.cls.value;\n//\tdoc.cls2.value = val3;\n\tval4 = doc.idclsinf.value;\n\tdoc.idclsinf2.value = val4;\t\t\n}\n\n\n\tfunction habilita2()\n\t{\n\t\tif(document.expedientef.inactivo.checked == true)\n\t\t{\n\t\tdocument.expedientef.fecinact.value = \"".toCharArray();
    __oracle_jsp_text[18] = 
    "\";\n\t\tdocument.expedientef.fecinact.disabled = false;\n\t\tdocument.expedientef.justif.disabled = false;\n\t\t}else\n\t\t{\n\t\tdocument.expedientef.fecinact.value = \"\";\n\t\tdocument.expedientef.justif.value = \"\";\n\t\tdocument.expedientef.fecinact.disabled = true;\n\t\tdocument.expedientef.justif.disabled = true;\n\t\t}\n\t}\t\n\tfunction sum() { \n\t var at = parseInt(document.expedientef.ano_AT.value);\n\t var ac = parseInt(document.expedientef.ano_AC.value);\n\t\n\t   suma = at + ac;\n\t   document.expedientef.totaldisp.value = suma\n\tmayor();\n\t}\t\n\n\tfunction unudisp()\n\t{\n\t\tif(document.expedientef.sisiConsulcls.checked == true)\n\t\t{\n\t\t\tdocument.expedientef.sisiConsulcls.checked = false;\n\t\t}else\n\t\t{\n\t\t\tdocument.expedientef.sisiConsulcls.checked = true;\n\t\t}\n\t}\n\n\tfunction sum2() { \n\t var at = parseInt(document.expedientef.ano_AT.value);\n\t var ac = parseInt(document.expedientef.ano_AC.value);\n\t var acs = parseInt(document.expedientef.sisi.value);\n\t\n\tif (document.expedientef.sisiConsuldisp.checked == true)\n\t\t{\n\t\t   suma = at + ac + acs;\n\t\t   document.expedientef.totaldisp.value = suma;\n\t\t}\n\tif (document.expedientef.sisiConsuldisp.checked == false)\n\t\t{\n\t\tsuma = at + ac;\n\t\tdocument.expedientef.totaldisp.value = suma;\n\t\t}\n\tmayor();\n\t}\t\n\t\t\n\tfunction indefinido()\n\t {\n\t doc = document.expedientef;\n\t \t//if (doc.expedientef.checked == true) {\n\t \tdoc.ano_AT.value = \"99\";\n\t \tdoc.ano_AC.value = \"99\";\n\t \tdoc.ano_AT2.value = \"99\";\n\t \tdoc.ano_AC2.value = \"99\";\n\t \tdoc.totaldisp.value = \"999\";\n\t \tdoc.totaldisp2.value = \"999\";\n\t \tdoc.ano_AT.disabled = true;\n\t \tdoc.ano_AC.disabled = true;\n\t \tdoc.totaldisp.disabled = true;\n\t \tdoc.sisiConsuldisp.disabled = true;\n /*\t}\n \telse\n \t{\n \tdoc.sisi.disabled = false;\n \tdoc.ano_AT.disabled =false;\n \tdoc.vigenciaat.disabled =false;\n \tdoc.vigenciatot.disabled =false;\n \t}*/\n \t}\n \tfunction habilIndef()\n \t{\n\t \tat =  \"".toCharArray();
    __oracle_jsp_text[19] = 
    "\";\n\t \tif\t(parseInt(at) == 99)\n\t\t\tindefinido();\n \t}\n \tfunction real()\n \t{\n\t \tdoc = document.expedientef;\n\t \t\n\t\ta = \"0\";\n\t\tb = \"0\";\n\t\tc = \"0\";\n\t\n\t \tif(Trim(doc.anioresv.value) != \"\")\n\t \t{\n\t \t\ta = parseInt(doc.anioresv.value);\n\t \t}\n\t\tif(Trim(doc.ano_Amp.value) != \"\")\n\t \t{\n\t \t\tb = parseInt(doc.ano_Amp.value);\n\t \t}\t\n\t\n\t\tb = parseInt(a) + parseInt(b);\n\t \tdoc.anioreal.value = parseInt(b);\n\t \ttotalclsif();\n\t \tmayor();\n \t}\n \tfunction mayor()\n \t{\n\t \tdoc = document.expedientef;\n\t \tif( parseInt(doc.totalcls.value) < parseInt(doc.totaldisp.value))\n\t\t \t{\n\t\t \tdoc.ano_guard.value = doc.totaldisp.value;\n\t\t \t}else\n\t\t \t{\n\t\t \tdoc.ano_guard.value = doc.totalcls.value;\n\t\t \t}\n\t \tif( parseInt(doc.totalcls.value) == parseInt(doc.totaldisp.value))\n\t\t \tdoc.ano_guard.value = doc.totaldisp.value;\n\t \t}\n\tfunction windowDetalle()\n\t \t{\n\t \t".toCharArray();
    __oracle_jsp_text[20] = 
    "\n\t \t\twindow.open('AniosDetalle.jsp?valor=".toCharArray();
    __oracle_jsp_text[21] = 
    "','window','width=420,height=250');\n\t \t\twindow.focus;\n\t \t".toCharArray();
    __oracle_jsp_text[22] = 
    "\n \t}\n \t\n \tfunction totalclsif()\n \t{\t\n\t\tdoc = document.expedientef;\n\t\ta = parseInt(doc.anioreal.value) + parseInt(doc.anioreal.value);\n\n\t\tif (document.expedientef.sisiConsulcls.checked == true)\n\t\t{\n\t\t\t\ta = a + parseInt(doc.sisi.value);\n\t\t}\n\tdoc.totalcls.value = a;\n\tmayor();\n  \t}\n  \t\n  \tfunction une()\n  \t{\n  \t\tdoc = document.expedientef;\n  \t\t\n\t  \tif(document.expedientef.sisiConsuldisp.checked == true)\n\t\t{\n\t\t\tdocument.expedientef.sisiConsuldisp.checked = false;\n\t\t}else\n\t\t{\n\t\t\tdocument.expedientef.sisiConsuldisp.checked = true;\n\t\t}\n  \t\tif(parseInt(doc.totaldisp.value) != 999)\n\t \t{\n\t \tsum2();\n\t \t}\n\t mayor();\n  \t}\nfunction validaFormatoFechaEx(){\n\t//alert();\n\tdoc = document.expedientef;\t\n\tFR = doc.fec_apert.value;\n\tfecha = FR;\n\tmes\t =\tfecha.substring(3, 5); \n\tdia\t =\tfecha.substring(0, 2); \n   \tanio =\tfecha.substring(6,10);     \n\tif (Trim(fecha) != \"\"){\n\t\tvar bandera=false;\n\t\tif(fecha.length != 10){\n\t\t\tbandera=true;\n\t\t}\n\t\tif(fecha.charAt(2) != '/' || fecha.charAt(5) != '/'){\n\t\t\tbandera=true;\n\t\t}\n\t\tif(mes>12 || mes<1){\n\t\t\tbandera=true;\n\t\t}\n\t\telse{\n\t\t\tif(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){\n\t\t\t\tif (dia<1 || dia>31)\n\t\t\t\t\tbandera=true;\n\t\t\t}\n\t\t\telse{\n\t\t\t\tif (dia<1 || dia>30)\n\t\t\t\t\tbandera=true;\n\t\t\t}\n\t\t\tif(mes==2 && anio%4==0){\n\t\t\t\tif (dia<1 || dia>29)\n\t\t\t\t\tbandera=true;\n\t\t\t}\n\t\t\tif(mes==2 && anio%4!=0){\n\t\t\t\tif (dia<1 || dia>28)\n\t\t\t\t\tbandera=true;\n\t\t\t}\n\t\t}\t\t\n\t\tif(bandera){\n\t\talert(\"El formato de fecha es invalido\");\n\t\tdoc.fec_apert.value = \"\";\n\t\t}\n\t\tif (doc.ced_tip[doc.ced_tip.selectedIndex].value > -1) {\n\t\treload();\n\t\t}\n\t  }  \t\n\t}\n\tfunction ponerfecha()\n\t{\n\tdoc = document.expedientef;\t\n\tFR = doc.fec_apert.value;\n\t  if (Trim(FR) == \"\"){\n\t  alert(\"Debe asignar una Fecha de Apertura\");\n\t  doc.ced_tip.value = \"-1\";\n\t  return false;\n\t  }\n\t  reload();\n\t}\n\n\tfunction validaFechaFinesSem(campoFecha){\n\n\t\tvar valida = 0 \n\t\t".toCharArray();
    __oracle_jsp_text[23] = 
    "\t\n\t\tif (campoFecha != null && campoFecha.value == \"".toCharArray();
    __oracle_jsp_text[24] = 
    "\") {\n\t\t\tvalida =1;\n\t\t}\n\t\t".toCharArray();
    __oracle_jsp_text[25] = 
    "\n\t\tif (valida == 1){\n\t\t\talert(\"La fecha seleccionada no es laborable\");\n\t\t\tcampoFecha.value = \"\";\n\t\t} \n\t}\n\nfunction validaAniosRerv()\t\t\n\t{\n\tvar a =  document.expedientef.anioresv.value;\n\tvar b =  document.expedientef.anioreal.value;\n\tif (eval(a)>12)\t\n\t\t{\n\t\t\talert(\"Los Años de reserva no puenden ser mayor a 12 Años!\");\n\t\t\tdocument.expedientef.anioresv.value =\"12\";\n\t\t\treal();\n\t\t}\n\tif (eval(b)>12)\t\n\t\t{\n\t\t\talert(\"Los Años de reserva no puenden ser mayor a 12 Años!\");\n\t\t\tdocument.expedientef.anioreal.value =\"12\";\n\t\t\treal();\n\t\t}\n\t}\t\n</SCRIPT>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" \n\tonload=\"valida=0;anio();rValidando();detalle2();habilIndef();real();setFormFocusExpediente();limpiarCampos();timer_load();\n\t\t\tvalidaFechaFinesSem(document.expedientef.fec_apert);\"  \n\tonKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload();\">\n<FORM action=\"ExpedienteArch.jsp\" name=\"expedientef\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\" name=\"pasaanio\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[27] = 
    "\" name=\"ano_AT2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "\" name=\"ano_AC2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[29] = 
    "\" name=\"totaldisp2\">\n<INPUT type=\"hidden\" value=\"\" name=\"ct\" id=\"ct\">\n<INPUT type=\"hidden\" value=\"\" name=\"clvExpdic\" id=\"clvExpdic\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[30] = 
    "\" name=\"id_sub\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[32] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "\" name=\"aux3\">\n<INPUT type=\"hidden\" value=\"\" name=\"consec\" id=\"consec\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[34] = 
    "\" name=\"cve_UA2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\" name=\"ced_tip2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[36] = 
    "\" name=\"cls2\">\n<INPUT type=\"hidden\" value=\"\" name=\"sisi\" id=\"sisi\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "\" name=\"idclsinf2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[38] = 
    "\" name=\"retURI\">\n".toCharArray();
    __oracle_jsp_text[39] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[40] = 
    "\" name=\"soloDesc\">\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"".toCharArray();
    __oracle_jsp_text[41] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"> </a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a><img\tsrc=\"../Imagenes/Save.gif\" alt=\"Guardar\"\tonclick=\"GuardarExpediente()\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"168\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><FONT size=\"+1\" color=\"#004080\">Expedientes</FONT></FONT></B></TD>\n\t\t\t<TD width=\"68\">&nbsp;</TD>\n\t\t\t<TD width=\"436\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD width=\"168\" colspan=\"2\"></TD>\n\t\t\t<TD width=\"68\"></TD>\n\t\t\t<TD width=\"436\" align=\"right\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD width=\"168\" colspan=\"2\"></TD>\n\t\t\t<TD width=\"68\"></TD>\n\t\t\t<TD width=\"436\" align=\"right\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[42] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">última Modificación por: \n\t\t\t<I>".toCharArray();
    __oracle_jsp_text[43] = 
    " - ".toCharArray();
    __oracle_jsp_text[44] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado por: \n\t\t\t<I>".toCharArray();
    __oracle_jsp_text[46] = 
    " - ".toCharArray();
    __oracle_jsp_text[47] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">Unidad Administrativa:\n\t\t\t</FONT></FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tArea:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"areatxt\" value=\"".toCharArray();
    __oracle_jsp_text[62] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\t\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[65] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\t\t\n\t\t\t\ttype=\"text\" class=\"blue500\" maxlength=\"500\">\n\t\t\t</TD>\n\t\t</TR>\t\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tFecha de Apertura:</FONT></B></TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t<INPUT type=\"text\" size=\"5\" name=\"fec_apert\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\t\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "\t\t\n\t\t\t\t maxlength=\"10\"  class=\"blue100\" value=\"".toCharArray();
    __oracle_jsp_text[71] = 
    "\" onblur=\"validaFormatoFechaEx();\" \n\t\t\t\t\t onKeyPress=\"AceptaSoloTeclaNumericaYDiagonal();\">\n\t\t\t</FONT>\n\t\t\t<A><IMG height=\"20\" src=\"../Imagenes/act_calFormat.gif\"  width=\"20\" border=\"0\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[72] = 
    "\n\t\t\t\t\t\tonclick='asignavalor();show_calendar(\"forms[0].fec_apert\");'\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\t\t\n\t\t\t></A>&nbsp;<FONT face=\"Arial\" color=\"#004080\" size=\"1\"> dd/mm/aaaa</FONT><BR>\n        </TD> \n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tCédula Tipo:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>\n\t\t\t<INPUT type=\"button\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\t\t\n\t\t\tonclick=\"document.getElementById('pop10').style.visibility='visible';\" class=\"s-dropdown-btn\">\n\t\t\t<DIV class=\"popup\" id=\"pop10\">\n\t\t\t\t<IFRAME src=\"#\" width=\"700\" height=\"200\" frameborder=\"1\" id=\"detalle2\"></IFRAME>\n\t\t\t</DIV>\n\t\t\t&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tClave:</FONT></B></FONT><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "<B><FONT color=\"red\">*Esta clave ya existe*</FONT>\n\t\t\t</B>".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"clave\" value=\"".toCharArray();
    __oracle_jsp_text[95] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[97] = 
    "\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\t\t\t\n\t\t\t\tMAXLENGTH=\"200\" type=\"text\" class=\"blue500\" onkeypress=\"NoAceptaCaracter()\" readonly=\"readonly\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tIdentificador Interno:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"interno\"  \n\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[100] = 
    "\" type=\"text\" \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\t\n\t\t\t\tclass=\"blue500\" maxlength=\"200\" >\n\t\t\t</TD>\n\t\t</TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tUbicación Topográfica:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"ubica\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[106] = 
    "\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\t\t\t\n\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[109] = 
    "\" type=\"text\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tUbicación Fisica:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[111] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[112] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[117] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[118] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[120] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[121] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[122] = 
    "\t\t\t\t\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tDenominacion:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"denom\"  \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[125] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\t\t\t\n\t\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[127] = 
    "\" type=\"text\" class=\"blue500\" maxlength=\"200\" >\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tDescripción:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<TEXTAREA name=\"subSeccion\" rows=\"3\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.expedientef.subSeccion,'Descripción','4000');\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\t\t\t\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[130] = 
    "</TEXTAREA>\t\t\t\t\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\t\n\t\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tValoración:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[134] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[135] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[136] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[137] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[138] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[139] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[140] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[141] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[142] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[143] = 
    "\n\t\t\t</TD>\n\t\t</TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tVIGENCIA POR DISPOSICION:</FONT></B></TD>\n\t\t\t<TD colspan=\"3\">\n\t\t\t<FONT face=\"Verdana\" size=\"2\">\n\t\t\t</FONT>\n        </TD> \n        </TR>\t\t\n\t\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t- Año AT:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"ano_AT\" id=\"ano_AT\" value=\"".toCharArray();
    __oracle_jsp_text[144] = 
    "\" type=\"text\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[145] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[146] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[147] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[148] = 
    "\t\t\t\t\n\t\t\t\tid=\"ano_AT\" class=\"blue100\" onblur=\"sum()\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t- Año AC:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"ano_AC\" id=\"ano_AC\" value=\"".toCharArray();
    __oracle_jsp_text[149] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[150] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[151] = 
    "\t\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[152] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[153] = 
    "\t\t\t\n\t\t\t\ttype=\"text\" id=\"ano_AC\" class=\"blue100\" onblur=\"sum()\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t- Consulta SISI:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<INPUT type=checkbox  value=\"1\"  onclick=\"unudisp();sum2();totalclsif();\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[154] = 
    "\t checked".toCharArray();
    __oracle_jsp_text[155] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[156] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[157] = 
    "\t\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[158] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[159] = 
    "\t\n\t\t\t\tname=\"sisiConsuldisp\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t- Vigencia Total:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"totaldisp\" value=\"".toCharArray();
    __oracle_jsp_text[160] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[161] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[162] = 
    "\t\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[163] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[164] = 
    "\t\t\t\n\t\t\t\ttype=\"text\"  class=\"blue100\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t<B>Clasificación de información:</B></FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[165] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[166] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[167] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[168] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[169] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[170] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[171] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[172] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[173] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[174] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[175] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[176] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[177] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFundamento Jurídico:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<textarea name=\"fundamento\" rows=\"8\" cols=\"60\"  \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[178] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[179] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[180] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[181] = 
    "\t\t\n\t\t\tonKeyDown=\"limitaTextArea(document.expedientef.fundamento,'Descripción','200')\">".toCharArray();
    __oracle_jsp_text[182] = 
    "</textarea>\t\t\t\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tMotivacion:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<textarea name=\"motivo\" rows=\"8\" cols=\"60\"  \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[183] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[184] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[185] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[186] = 
    "\t\t\n\t\t\tonKeyDown=\"limitaTextArea(document.expedientef.motivo,'Descripción','200')\">".toCharArray();
    __oracle_jsp_text[187] = 
    "</textarea>\t\t\t\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tObservaciones:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<textarea name=\"observ\" rows=\"8\" cols=\"60\"  \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[188] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[189] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[190] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[191] = 
    "\t\t\n\t\t\tonKeyDown=\"limitaTextArea(document.expedientef.observ,'Descripción','200')\">".toCharArray();
    __oracle_jsp_text[192] = 
    "</textarea>\t\t\t\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t\n        <TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD  colspan=\"4\" ><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tVIGENCIA POR Clasificación:</FONT></B></TD>\n        </TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t- Años Reserva:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"anioresv\" id=\"anioresv\" value=\"".toCharArray();
    __oracle_jsp_text[193] = 
    "\" type=\"text\" onkeyup=\"validaAniosRerv();real();\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[194] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[195] = 
    "\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[196] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[197] = 
    "\t\t\t\n\t\t\t\t class=\"blue100\" \n\t\t\t\t onkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t- Reserva Real:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"anioreal\" id=\"anioreal\" value=\"".toCharArray();
    __oracle_jsp_text[198] = 
    "\" onkeyup=\"validaAniosRerv();real();\" \n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[199] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[200] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[201] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "\t\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[204] = 
    "\t\t\n\t\n\t\t\t\ttype=\"text\"  class=\"blue100\" \n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t- Consulta SISI:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<INPUT type=checkbox  onclick=\"totalclsif();une();\" value=\"1\"  \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[205] = 
    "\t \n\t\t\t\tchecked\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[206] = 
    "\t\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[207] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[208] = 
    "\t\t\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[209] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[210] = 
    "\n\t\t\t\tname=\"sisiConsulcls\" >\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\t- Vigencia Total:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"totalcls\" id=\"totalcls\" value=\"".toCharArray();
    __oracle_jsp_text[211] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[212] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\t\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[214] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[215] = 
    "\t\t\t\t\n\t\t\t\ttype=\"text\" class=\"blue100\"\n\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[216] = 
    "\" name=\"ano_Amp\" id=\"ano_Amp\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<tr valign=\"top\">\n\t\t<td colspan=\"2\">\n\t\t</td>\n\t\t</tr>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT color=\"#004080\">&nbsp;</FONT></B></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tPeriodo Total de Guarda:</FONT></B></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"anioguard\"  value=\"".toCharArray();
    __oracle_jsp_text[217] = 
    "\" \n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[218] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[219] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[220] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[221] = 
    "\t\n\t\t\t\ttype=\"text\" id=\"ano_guard\" class=\"blue100\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[222] = 
    "\n\t\t\t\t<IFRAME src=\"Acomulable.jsp?ida=".toCharArray();
    __oracle_jsp_text[223] = 
    "&num=1&soloDesc=".toCharArray();
    __oracle_jsp_text[224] = 
    "\" WIDTH=400 HEIGHT=100 frameborder=0 id=\"acom\"></IFRAME>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[225] = 
    "\t\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tCerrado:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=checkbox onclick=\"habilita2()\" value=\"3\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[226] = 
    "\n\t\t\t\t\t\t checked\n\t\t\t\t\t       \t".toCharArray();
    __oracle_jsp_text[227] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[228] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[229] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[230] = 
    "\n\t\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[231] = 
    "\t\t\n\n\t\t\t\tname=\"inactivo\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFecha Cierre:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"fecinact\" value=\"".toCharArray();
    __oracle_jsp_text[232] = 
    "\"\n\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[233] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[234] = 
    "\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[235] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[236] = 
    "\n\t\t\t\ttype=\"text\" class=\"blue100\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tJustificacion:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<TEXTAREA name=\"justif\" id=\"justif\" rows=\"3\" cols=\"65\" \n\t\t\t\t\tonKeyDown=\"limitaTextArea(document.expedientef.justif,'Justificación','1000');\"\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[237] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[238] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[239] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[240] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[241] = 
    "\n\t\t\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[242] = 
    "\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[243] = 
    "</TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\t\t\t\t\t\t\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
