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


public class _ClasificacionArchSub extends com.orionserver.http.OrionHttpJspPage {


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
    _ClasificacionArchSub page = this;
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
      
      out.write(__oracle_jsp_text[5]);
       if(!BUsuario.getAdmon() && !BUsuario.getSupervisor()){ 
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
      	String strIdSubfondo	=	"";
      	String strIdSubfondoSr	=	"";
      	String strCodigo		=	"";
      	String strSeccion		=	"";
      	String strUsrActualiza	=	"";
      	String strFecha			=	"";
      	String strAccion		=	"";
      	String strFondo			=	"";
      	String strFondoP		=   (request.getParameter("fondoP") != null)?request.getParameter("fondoP"):"0"; 
      	String strSubfondo		=	(request.getParameter("subfondo") != null)?request.getParameter("subfondo"):"0"; 
      	String strSerie			=	"";
      	String strSerieP		=	(request.getParameter("serieP") != null)?request.getParameter("serieP"):"0"; 
      	String strSerieP2		=	"";
      	String strsubSerieP		=	(request.getParameter("serie") != null)?request.getParameter("serie"):"0"; 
      	String strSeccionA		=	"";
      	String stridSeccion		=	(request.getParameter("idSeccion") != null)?request.getParameter("idSeccion"):"0";
      	String strobservacion	=	"";
      	String strFechaAT		=	"";
      	String strFechaAC		=	"";
      	String strFechaTotal	=	"";
      	String strAnosPUB		=	"";
      	String strAnosSISI		=	"";
      	String strConf			=	"";
      	String strClave			=	"";
      	String strstruc			=	"";	
      	String strReserva		=	"";
      	String strClv1			=	"";	
      	String strClv2			=	"";	
      	String strClv3			=	"";	
      	String strClv4			=	"";	
      	String strClv5			=	"";
      	String strCarga			=	(request.getParameter("cargaclv") != null)?request.getParameter("cargaclv"):"";
      	String strInact			=	"";
      	String strFecInac		=	"";
      	String strJustInac		=	"";	
      	String ver				=	"";		
      	String vertodo			=	"";
      	String horafec			=	"";
      	String strFechaATSer	=	"";
      	String strFechaACSer	=	"";
      	String bloqclv			=	"";
      	String Idpas			= 	"";
      	String strsoloDesc 		=	"";
      				
      	String strAux = "1234567";	
      	
      	boolean bInsertar		=	false;
      	int bInsertar1		=	0;
      		int valida		=	0;	
      	java.text.SimpleDateFormat sdf 	=	new java.text.SimpleDateFormat("dd/MM/yyyy");
      	java.util.Date f 				=	new java.util.Date();
      	strFecha						=	sdf.format(f);
      
      	String retURI = (request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
      	strAccion		=	request.getParameter("accion");
      	strIdSubfondo	=	(request.getParameter("id_sub") != null)?request.getParameter("id_sub"):"";
      	strIdSubfondoSr	=	(request.getParameter("id_subsr") != null)?request.getParameter("id_subsr"):"";
      	if(strAccion!=null && strAccion.trim().length()>0)
      	{
      		if(strAccion != null && strAccion.equals("guardar"))
      		{
      			strSeccionA	=   request.getParameter("seleccion");
      			strSerie	=   request.getParameter("valor");
      			strFondo	=   request.getParameter("comb");
      			strSeccion	=	request.getParameter("subSeccion");
      			strCodigo	=	request.getParameter("subCodigo");
      			strobservacion		=	request.getParameter("obvser");
      			strFechaAT		=	(request.getParameter("vigenciaat")!= null)?request.getParameter("vigenciaat"):request.getParameter("vigenciaat2");
      			strFechaAC		=	(request.getParameter("vigenciaac")!= null)?request.getParameter("vigenciaac"):request.getParameter("vigenciaac2");
      			strFechaTotal	=	(request.getParameter("vigenciatot")!= null)?request.getParameter("vigenciatot"):request.getParameter("vigenciatot2");
      			strAnosPUB		=	request.getParameter("anopub");
      			strAnosSISI		=	request.getParameter("anosisi");
      			strConf			=	request.getParameter("conf");
      			strClave	=	request.getParameter("clave"); 	
      			strReserva	=	request.getParameter("reserv"); 
      			
      			bInsertar1	=	ActualizaExpArchivado.insertarClasifsub(strCodigo, strSeccion,
      																strFecha, BUsuario.getIdUsuario(),strSerie,strSeccionA,
      																strFechaAT,strFechaAC,strFechaTotal,strAnosSISI,strConf,strClave,strReserva,
      																strFondoP,strSubfondo,stridSeccion,strSerieP,strsubSerieP,strobservacion,strAux);
      													
      			if(bInsertar1 == 2)
      			{
      			//msg ="La clave existe";
      				vertodo 		= "true";
      				strCarga 		= "CARGA";
      			}
      			else{
      				try{
      					//response.sendRedirect("ClasificacionArchSubview.jsp?msg="+msg);
      					response.sendRedirect(retURI+"&msg="+msg);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      		}
      		else if(strAccion != null && strAccion.equals("cambiar"))
      		{
      			strsoloDesc		=	request.getParameter("soloDesc");
      			strSeccionA		=   request.getParameter("selec2");
      			strSerie		=   request.getParameter("valor2");
      			//strFondo		=   request.getParameter("combina2");
      			strSeccion		=	request.getParameter("subSeccion");
      			strCodigo		=	request.getParameter("subCodigo");
      			strobservacion	=	request.getParameter("obvser");
      			strFechaAT		=	(request.getParameter("vigenciaat")!= null)?request.getParameter("vigenciaat"):request.getParameter("vigenciaat2");
      			strFechaAC		=	(request.getParameter("vigenciaac")!= null)?request.getParameter("vigenciaac"):request.getParameter("vigenciaac2");
      			strFechaTotal	=	(request.getParameter("vigenciatot")!= null)?request.getParameter("vigenciatot"):request.getParameter("vigenciatot2");
      			strSerieP	=	request.getParameter("SerieP2");
      			strAnosSISI		=	request.getParameter("anosisi");
      			strConf			=	request.getParameter("conf");
      			strClave		=	request.getParameter("clave"); 		
      			strInact		=	(request.getParameter("inactivo")!= null)?request.getParameter("inactivo"):"1";
      			strFecInac		=	request.getParameter("fecinact");
      			strJustInac 	=	request.getParameter("justif");			
      			strReserva		=	request.getParameter("reserv");				
      			strAux 			= 	request.getParameter("aux"); 
      			 
      			bInsertar1 = ActualizaExpArchivado.actualizaClasificacionsub(strsoloDesc,strCodigo, strSeccion, strFecha, 
      															BUsuario.getIdUsuario(), strSerie, strSeccionA,
      															strFechaAT,strFechaAC,strFechaTotal,strAnosSISI,strConf,strIdSubfondo,strClave
      															,strFecInac,strJustInac,strInact,strReserva,strobservacion,strSerieP,strAux);
      
      			if(bInsertar1 != 2){
      				try{
      					//response.sendRedirect("ClasificacionArchSubview.jsp?msg="+msg);
      					response.sendRedirect(retURI+"&msg="+msg);
      				}catch(java.io.IOException io){
      					//System.out.println("Error-->"+io);
      				}
      			}
      			else
      				{
      					vertodo 		= "true";
      					strCarga 		= "CARGA";
      					Idpas			= strIdSubfondo;
      					strIdSubfondoSr = null;
      					////System.out.println("Busca1:"+Idpas);
      				}
      		}
      	}
      
      
      	if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
      	{
      
      		String strDatosSubfondo[][] = ActualizaExpArchivado.getClasificacionsub(strIdSubfondo);
      		strCodigo		=	strDatosSubfondo[0][0];
      		strSeccion		=	strDatosSubfondo[0][1];
      		strFecha		=	strDatosSubfondo[0][2];
      		strUsrActualiza	=	strDatosSubfondo[0][3];
      		strSerie		=	strDatosSubfondo[0][4];
      		strSeccionA		=	strDatosSubfondo[0][5];
      		strFechaAT		=	strDatosSubfondo[0][6];
      		strFechaAC		=	strDatosSubfondo[0][7];
      		strFechaTotal	=	strDatosSubfondo[0][8];
      		strAnosSISI		=	strDatosSubfondo[0][9];
      		strConf			=	strDatosSubfondo[0][10];
      		strClave		=	strDatosSubfondo[0][11];		 
      		strReserva		=	strDatosSubfondo[0][12];	
      		strFondoP		=	strDatosSubfondo[0][13];
      		strSubfondo		=	strDatosSubfondo[0][14];
      		stridSeccion	=	strDatosSubfondo[0][15];
      		strSerieP		=	strDatosSubfondo[0][16];
      		strsubSerieP 	=	strDatosSubfondo[0][17];
      		strobservacion	=	strDatosSubfondo[0][18];
      		strFecInac		=	strDatosSubfondo[0][19];	
      		strJustInac		=	strDatosSubfondo[0][20];	
      		strInact		=	strDatosSubfondo[0][21];
      		horafec			=	strDatosSubfondo[0][22];	
      		strFechaATSer	=	strDatosSubfondo[0][23];	
      		strFechaACSer	=	strDatosSubfondo[0][24];		
      		strAux			=  	strClave;				
      		ver				=	"si";	
      		vertodo 		=   "true";
      		strCarga 		=   "CARGA";
      		bloqclv 		= 	"true";		
      		valida	=	ActualizaExpArchivado.getValidaClasificacionsub(strIdSubfondo);		
      	}
      	
      	if(strIdSubfondoSr != null && strIdSubfondoSr.trim().length()>0)
      	{
      		String strDatosSubfondo[][] = ActualizaExpArchivado.getClasificacion(strIdSubfondoSr);
      
      		strCodigo		=	strDatosSubfondo[0][0];
      		strSeccion		=	strDatosSubfondo[0][1];
      		strFecha		=	strDatosSubfondo[0][2];
      		strUsrActualiza	=	strDatosSubfondo[0][3];
      		strSerie	=		strDatosSubfondo[0][4];
      		strSeccionA	=		strDatosSubfondo[0][5];
      		 strFechaAT	=		strDatosSubfondo[0][6];
      		 strFechaATSer	=	strDatosSubfondo[0][6];
      		 strFechaAC	=		strDatosSubfondo[0][7];
      		 strFechaACSer	=	strDatosSubfondo[0][7];
      		 strFechaTotal =	strDatosSubfondo[0][8];
      		 strAnosSISI=		strDatosSubfondo[0][9];
      		 strConf	=		strDatosSubfondo[0][10];
      		//strClave		=	strDatosSubfondo[0][11];		 
      		strReserva		=	strDatosSubfondo[0][12];	
      		//strFondoP		=	strDatosSubfondo[0][13];
      		//strSubfondo	=	strDatosSubfondo[0][14];
      		//stridSeccion	=	strDatosSubfondo[0][15];
      		//strSerieP		=	strDatosSubfondo[0][16];
      		//strsubSerieP 	=	strDatosSubfondo[0][17];
      		strobservacion	=	strDatosSubfondo[0][18];
      		strFecInac		=	strDatosSubfondo[0][19];	
      		strJustInac		=	strDatosSubfondo[0][20];	
      		strInact		=	strDatosSubfondo[0][21];
      		horafec			=	strDatosSubfondo[0][22];		
      		strAux			=  	strClave;				
      		vertodo 		= "true";
      		strCarga 		= "CARGA";
      
      	}
      
      	if(strCarga!=null && strCarga.trim().length()>0)
      		{
      		
      		if(strFondoP!=null && strFondoP.trim().length()>0)
      		{
      			String strDatosclv1[][] = ActualizaExpArchivado.getCargafon(strFondoP);
      			if (strDatosclv1.length >0)
      			strClv1 = strDatosclv1[0][0];
      		}
      		
      		strClv2 = "0";
      		if(strSubfondo !=null && strSubfondo.trim().length()>0)
      			{
      			String strDatosclv2[][] = ActualizaExpArchivado.getCargasubfon(strSubfondo);
      			if (strDatosclv2.length >0)
      			strClv2 = strDatosclv2[0][0];	
      			}	
      		if(stridSeccion!=null && stridSeccion.trim().length()>0)
      		{
      			String strDatosclv3[][] = ActualizaExpArchivado.getCargasec(stridSeccion);				
      			if (strDatosclv3.length >0)
      				{
      				strClv3 = strDatosclv3[0][0];
      							}
      		}
      		if(strSerieP!=null && strSerieP.trim().length()>0)
      		{		
      			String strDatosclv4[][] = ActualizaExpArchivado.getCargaser(strSerieP);
      			if (strDatosclv4.length >0)
      			{
      				strClv4 = strDatosclv4[0][0];		
      				vertodo = "true";
      			}
      		}
      		if(Integer.parseInt(strClv2) > 0)
      		{
      		 
      		strstruc = strClv1 +"."+strClv2+"."+strClv3+"."+strClv4;
      		}else
      		{
      		strstruc = strClv1 +"."+strClv3+"."+strClv4;
      		}
      	}	
      	
      
      out.write(__oracle_jsp_text[9]);
      if(valida == 2) 
      	{
      out.write(__oracle_jsp_text[10]);
      
      	}
      out.write(__oracle_jsp_text[11]);
      out.print(horafec);
      out.write(__oracle_jsp_text[12]);
      out.print(strFechaATSer);
      out.write(__oracle_jsp_text[13]);
      out.print(strFechaACSer);
      out.write(__oracle_jsp_text[14]);
      out.print(strFechaAC);
      out.write(__oracle_jsp_text[15]);
      out.print(strFechaAT);
      out.write(__oracle_jsp_text[16]);
      out.print(strFechaTotal);
      out.write(__oracle_jsp_text[17]);
      out.print(strFechaAC);
      out.write(__oracle_jsp_text[18]);
      out.print(strFechaAT);
      out.write(__oracle_jsp_text[19]);
      out.print(strFechaTotal);
      out.write(__oracle_jsp_text[20]);
      out.print(strIdSubfondo);
      out.write(__oracle_jsp_text[21]);
      out.print(strIdSubfondo);
      out.write(__oracle_jsp_text[22]);
      out.print(strAux);
      out.write(__oracle_jsp_text[23]);
      out.print(strFondo);
      out.write(__oracle_jsp_text[24]);
      out.print(strSerie);
      out.write(__oracle_jsp_text[25]);
      out.print(strSeccionA);
      out.write(__oracle_jsp_text[26]);
      out.print(retURI);
      out.write(__oracle_jsp_text[27]);
      out.print(strSerieP);
      out.write(__oracle_jsp_text[28]);
      if(valida == 2){
      		strsoloDesc = "1";
      	}
      	
      out.write(__oracle_jsp_text[29]);
      out.print(strsoloDesc);
      out.write(__oracle_jsp_text[30]);
      out.print( retURI );
      out.write(__oracle_jsp_text[31]);
      if(vertodo=="true") {
      out.write(__oracle_jsp_text[32]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[33]);
      	}else{
      out.write(__oracle_jsp_text[34]);
      }
      out.write(__oracle_jsp_text[35]);
      }
      out.write(__oracle_jsp_text[36]);
       if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ 
      out.write(__oracle_jsp_text[37]);
      out.print(ActualizaUsuario.NombreUsuario(strUsrActualiza));
      out.write(__oracle_jsp_text[38]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[39]);
       }else{ 
      out.write(__oracle_jsp_text[40]);
      out.print( BUsuario.getNombre() );
      out.write(__oracle_jsp_text[41]);
      out.print( strFecha );
      out.write(__oracle_jsp_text[42]);
       }
      out.write(__oracle_jsp_text[43]);
      if(bloqclv == "true") 
      						{
      out.write(__oracle_jsp_text[44]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setData(ComboData.getFondoC());
        __jsp_taghandler_1.setName("fondoP");
        __jsp_taghandler_1.setSize(1);
        __jsp_taghandler_1.setSelected(OracleJspRuntime.toStr( strFondoP));
        __jsp_taghandler_1.setDisabled(true);
        __jsp_taghandler_1.setClassHtml("blue500");
        __jsp_taghandler_1.setScript("onchange='claved();reload()'");
        __jsp_taghandler_1.setTextoNoSeleccion(" ------------ Seleccione un Fondo------------ ");
        __jsp_taghandler_1.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[45]);
      
      			} else
      			{
      out.write(__oracle_jsp_text[46]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setData(ComboData.getFondoC());
        __jsp_taghandler_2.setName("fondoP");
        __jsp_taghandler_2.setSize(1);
        __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strFondoP));
        __jsp_taghandler_2.setClassHtml("blue500");
        __jsp_taghandler_2.setScript("onchange='claved();reload()'");
        __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Seleccione un Fondo------------ ");
        __jsp_taghandler_2.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[47]);
      
      			}
      out.write(__oracle_jsp_text[48]);
      if(bloqclv == "true") 
      						{
      out.write(__oracle_jsp_text[49]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setData(ComboData.getSubFondoC(strFondoP));
        __jsp_taghandler_3.setName("subfondo");
        __jsp_taghandler_3.setSize(1);
        __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strSubfondo));
        __jsp_taghandler_3.setDisabled(true);
        __jsp_taghandler_3.setClassHtml("blue500");
        __jsp_taghandler_3.setScript("onchange='claved();reload()'");
        __jsp_taghandler_3.setTextoNoSeleccion(" ------------ Seleccione un Subfondo------------ ");
        __jsp_taghandler_3.setValorNoSeleccion("0");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[50]);
      
      			} else
      			{
      out.write(__oracle_jsp_text[51]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setData(ComboData.getSubFondoC(strFondoP));
        __jsp_taghandler_4.setName("subfondo");
        __jsp_taghandler_4.setSize(1);
        __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( strSubfondo));
        __jsp_taghandler_4.setClassHtml("blue500");
        __jsp_taghandler_4.setScript("onchange='claved();reload()'");
        __jsp_taghandler_4.setTextoNoSeleccion(" ------------ Seleccione un Subfondo------------ ");
        __jsp_taghandler_4.setValorNoSeleccion("0");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[52]);
      
      			}
      out.write(__oracle_jsp_text[53]);
      if(bloqclv == "true") 
      						{
      out.write(__oracle_jsp_text[54]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_5=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setData(ComboData.getSeccionComboInst(strFondoP,strSubfondo));
        __jsp_taghandler_5.setName("idSeccion");
        __jsp_taghandler_5.setSize(1);
        __jsp_taghandler_5.setSelected(OracleJspRuntime.toStr( stridSeccion));
        __jsp_taghandler_5.setDisabled(true);
        __jsp_taghandler_5.setClassHtml("blue500");
        __jsp_taghandler_5.setScript("onchange='claved();reload()'");
        __jsp_taghandler_5.setTextoNoSeleccion(" ------------ Seleccione una Sección------------ ");
        __jsp_taghandler_5.setValorNoSeleccion("0");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[55]);
      
      			} else
      			{
      out.write(__oracle_jsp_text[56]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_6=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setData(ComboData.getSeccionComboInst(strFondoP,strSubfondo));
        __jsp_taghandler_6.setName("idSeccion");
        __jsp_taghandler_6.setSize(1);
        __jsp_taghandler_6.setSelected(OracleJspRuntime.toStr( stridSeccion));
        __jsp_taghandler_6.setClassHtml("blue500");
        __jsp_taghandler_6.setScript("onchange='claved();reload()'");
        __jsp_taghandler_6.setTextoNoSeleccion(" ------------ Seleccione una Sección------------ ");
        __jsp_taghandler_6.setValorNoSeleccion("0");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[57]);
      
      			}
      out.write(__oracle_jsp_text[58]);
      if(bloqclv == "true") 
      				{
      out.write(__oracle_jsp_text[59]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_7=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setData(ComboData.getSerieComboP(stridSeccion));
        __jsp_taghandler_7.setName("serieP");
        __jsp_taghandler_7.setSize(1);
        __jsp_taghandler_7.setSelected(OracleJspRuntime.toStr( strSerieP));
        __jsp_taghandler_7.setDisabled(true);
        __jsp_taghandler_7.setClassHtml("blue500");
        __jsp_taghandler_7.setScript("onchange='idllena();claved();reload()'");
        __jsp_taghandler_7.setTextoNoSeleccion(" ------------ Seleccione un Serie------------ ");
        __jsp_taghandler_7.setValorNoSeleccion("0");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[60]);
      
      			} else
      			{
      out.write(__oracle_jsp_text[61]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_8=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setData(ComboData.getSerieComboP(stridSeccion));
        __jsp_taghandler_8.setName("serieP");
        __jsp_taghandler_8.setSize(1);
        __jsp_taghandler_8.setSelected(OracleJspRuntime.toStr( strSerieP));
        __jsp_taghandler_8.setClassHtml("blue500");
        __jsp_taghandler_8.setScript("onchange='idllena();claved();reload()'");
        __jsp_taghandler_8.setTextoNoSeleccion(" ------------ Seleccione un Serie------------ ");
        __jsp_taghandler_8.setValorNoSeleccion("0");
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      out.write(__oracle_jsp_text[62]);
      
      			}
      out.write(__oracle_jsp_text[63]);
      if(vertodo=="true") {
      out.write(__oracle_jsp_text[64]);
      out.print(strstruc);
      out.write(__oracle_jsp_text[65]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[66]);
      	}
      out.write(__oracle_jsp_text[67]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[68]);
      
      						}
      out.write(__oracle_jsp_text[69]);
      if(bInsertar1 == 2){ 
      out.write(__oracle_jsp_text[70]);
      } 
      out.write(__oracle_jsp_text[71]);
      out.print(strClave);
      out.write(__oracle_jsp_text[72]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[73]);
      
      						}
      out.write(__oracle_jsp_text[74]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[75]);
      	}
      out.write(__oracle_jsp_text[76]);
      out.print(strCodigo);
      out.write(__oracle_jsp_text[77]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[78]);
      
      						}
      out.write(__oracle_jsp_text[79]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[80]);
      	}
      out.write(__oracle_jsp_text[81]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[82]);
      	}
      out.write(__oracle_jsp_text[83]);
      out.print(strSeccion);
      out.write(__oracle_jsp_text[84]);
      
      			String voice = "";
      			
      		String strDatosVal[][] = ActualizaExpArchivado.getValClasificacionsub(strSerie);
      			if (strDatosVal.length >0)
      			{
      			voice = strDatosVal[0][0];	
      			}
      
      			
      			if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)  ){
      out.write(__oracle_jsp_text[85]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[86]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_9=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_9.setParent(null);
        __jsp_taghandler_9.setData(ComboData.getValorComboSub(voice));
        __jsp_taghandler_9.setName("valor");
        __jsp_taghandler_9.setSize(1);
        __jsp_taghandler_9.setSelected(OracleJspRuntime.toStr( strSerie));
        __jsp_taghandler_9.setDisabled(true);
        __jsp_taghandler_9.setClassHtml("blue500");
        __jsp_taghandler_9.setScript("onchange='detalle();'");
        __jsp_taghandler_9.setTextoNoSeleccion(" ------------ Seleccione una Valoración------------ ");
        __jsp_taghandler_9.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
        if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,1);
      }
      out.write(__oracle_jsp_text[87]);
      }
      					else {
      out.write(__oracle_jsp_text[88]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_10=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_10.setParent(null);
        __jsp_taghandler_10.setData(ComboData.getValorComboSub(voice));
        __jsp_taghandler_10.setName("valor");
        __jsp_taghandler_10.setSize(1);
        __jsp_taghandler_10.setSelected(OracleJspRuntime.toStr( strSerie));
        __jsp_taghandler_10.setDisabled(true);
        __jsp_taghandler_10.setClassHtml("blue500");
        __jsp_taghandler_10.setScript("onchange='detalle();'");
        __jsp_taghandler_10.setTextoNoSeleccion(" ------------ Seleccione una Valoración------------ ");
        __jsp_taghandler_10.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
        if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,1);
      }
      out.write(__oracle_jsp_text[89]);
      }
      out.write(__oracle_jsp_text[90]);
      }else{
      out.write(__oracle_jsp_text[91]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[92]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_11=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_11.setParent(null);
        __jsp_taghandler_11.setData(ComboData.getValorComboSub(voice));
        __jsp_taghandler_11.setName("valor");
        __jsp_taghandler_11.setSize(1);
        __jsp_taghandler_11.setSelected(OracleJspRuntime.toStr( strSerie));
        __jsp_taghandler_11.setClassHtml("blue500");
        __jsp_taghandler_11.setScript("onchange='detalle();'");
        __jsp_taghandler_11.setTextoNoSeleccion(" ------------ Seleccione una Valoración------------ ");
        __jsp_taghandler_11.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
        if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,1);
      }
      out.write(__oracle_jsp_text[93]);
      }
      					else {
      out.write(__oracle_jsp_text[94]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_12=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_12.setParent(null);
        __jsp_taghandler_12.setData(ComboData.getValorComboSub(voice));
        __jsp_taghandler_12.setName("valor");
        __jsp_taghandler_12.setSize(1);
        __jsp_taghandler_12.setSelected(OracleJspRuntime.toStr( strSerie));
        __jsp_taghandler_12.setClassHtml("blue500");
        __jsp_taghandler_12.setScript("onchange='detalle();'");
        __jsp_taghandler_12.setTextoNoSeleccion(" ------------ Seleccione una Valoración------------ ");
        __jsp_taghandler_12.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
        if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,1);
      }
      out.write(__oracle_jsp_text[95]);
      }
      out.write(__oracle_jsp_text[96]);
      }
      out.write(__oracle_jsp_text[97]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[98]);
      
      						}
      out.write(__oracle_jsp_text[99]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[100]);
      	}
      out.write(__oracle_jsp_text[101]);
      if(strFechaAT == "99" || strFechaAT.equals("99")) 
      			{
      out.write(__oracle_jsp_text[102]);
      
      			}
      out.write(__oracle_jsp_text[103]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[104]);
      
      						}
      out.write(__oracle_jsp_text[105]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[106]);
      	}
      out.write(__oracle_jsp_text[107]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[108]);
      
      						}
      out.write(__oracle_jsp_text[109]);
      if(strFechaAT == "99" || strFechaAT.equals("99")) 
      					{
      out.write(__oracle_jsp_text[110]);
      
      						}
      out.write(__oracle_jsp_text[111]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[112]);
      	}
      out.write(__oracle_jsp_text[113]);
      out.print(strFechaAT);
      out.write(__oracle_jsp_text[114]);
      out.print(strFechaAC);
      out.write(__oracle_jsp_text[115]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[116]);
      
      						}
      out.write(__oracle_jsp_text[117]);
      if(strFechaAT == "99" || strFechaAT.equals("99")) 
      					{
      out.write(__oracle_jsp_text[118]);
      }
      out.write(__oracle_jsp_text[119]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[120]);
      	}
      out.write(__oracle_jsp_text[121]);
      out.print(strFechaTotal);
      out.write(__oracle_jsp_text[122]);
      if(strFechaAT == "99" || strFechaAT.equals("99")) 
      					{
      out.write(__oracle_jsp_text[123]);
      }
      out.write(__oracle_jsp_text[124]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[125]);
      	}
      out.write(__oracle_jsp_text[126]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[127]);
      
      						}
      out.write(__oracle_jsp_text[128]);
      if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)){
      out.write(__oracle_jsp_text[129]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[130]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_13=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_13.setParent(null);
        __jsp_taghandler_13.setData(ComboData.getSeleccionCombo());
        __jsp_taghandler_13.setName("seleccion");
        __jsp_taghandler_13.setSize(1);
        __jsp_taghandler_13.setSelected(OracleJspRuntime.toStr( strSeccionA));
        __jsp_taghandler_13.setDisabled(true);
        __jsp_taghandler_13.setClassHtml("blue500");
        __jsp_taghandler_13.setScript("onchange='cambio();'");
        __jsp_taghandler_13.setTextoNoSeleccion(" ---------- Elija un Tipo de Selección ---------- ");
        __jsp_taghandler_13.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
        if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,1);
      }
      out.write(__oracle_jsp_text[131]);
      }
      					else {
      out.write(__oracle_jsp_text[132]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_14=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected disabled classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_14.setParent(null);
        __jsp_taghandler_14.setData(ComboData.getSeleccionCombo());
        __jsp_taghandler_14.setName("seleccion");
        __jsp_taghandler_14.setSize(1);
        __jsp_taghandler_14.setSelected("");
        __jsp_taghandler_14.setDisabled(true);
        __jsp_taghandler_14.setClassHtml("blue500");
        __jsp_taghandler_14.setScript("onchange='cambio();'");
        __jsp_taghandler_14.setTextoNoSeleccion(" ---------- Elija un Tipo de Selección ---------- ");
        __jsp_taghandler_14.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
        if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,1);
      }
      out.write(__oracle_jsp_text[133]);
      }
      out.write(__oracle_jsp_text[134]);
      }else{
      out.write(__oracle_jsp_text[135]);
      if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){
      out.write(__oracle_jsp_text[136]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_15=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_15.setParent(null);
        __jsp_taghandler_15.setData(ComboData.getSeleccionCombo());
        __jsp_taghandler_15.setName("seleccion");
        __jsp_taghandler_15.setSize(1);
        __jsp_taghandler_15.setSelected(OracleJspRuntime.toStr( strSeccionA));
        __jsp_taghandler_15.setClassHtml("blue500");
        __jsp_taghandler_15.setScript("onchange='cambio();'");
        __jsp_taghandler_15.setTextoNoSeleccion(" ---------- Elija un Tipo de Selección ---------- ");
        __jsp_taghandler_15.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
        if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,1);
      }
      out.write(__oracle_jsp_text[137]);
      }
      					else {
      out.write(__oracle_jsp_text[138]);
      {
        com.meve.sigma.taglib.CreaCombo __jsp_taghandler_16=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
        __jsp_taghandler_16.setParent(null);
        __jsp_taghandler_16.setData(ComboData.getSeleccionCombo());
        __jsp_taghandler_16.setName("seleccion");
        __jsp_taghandler_16.setSize(1);
        __jsp_taghandler_16.setSelected(OracleJspRuntime.toStr( strSeccionA));
        __jsp_taghandler_16.setClassHtml("blue500");
        __jsp_taghandler_16.setScript("onchange='cambio();'");
        __jsp_taghandler_16.setTextoNoSeleccion(" ---------- Elija un Tipo de Selección ---------- ");
        __jsp_taghandler_16.setValorNoSeleccion("-1");
        __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
        if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,1);
      }
      out.write(__oracle_jsp_text[139]);
      }
      out.write(__oracle_jsp_text[140]);
      }
      out.write(__oracle_jsp_text[141]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[142]);
      	}
      out.write(__oracle_jsp_text[143]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[144]);
      
      						}
      out.write(__oracle_jsp_text[145]);
      out.print(strobservacion);
      out.write(__oracle_jsp_text[146]);
      out.print(strReserva);
      out.write(__oracle_jsp_text[147]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[148]);
      
      						}
      out.write(__oracle_jsp_text[149]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[150]);
      	}
      out.write(__oracle_jsp_text[151]);
      if(valida == 2)
      			{
      out.write(__oracle_jsp_text[152]);
      if(strConf != null && strConf.trim().length()>0)
      				 {
      out.write(__oracle_jsp_text[153]);
      } 
      out.write(__oracle_jsp_text[154]);
      if(strConf != null && strConf.trim().length()>0)
      				 {
      out.write(__oracle_jsp_text[155]);
      } 
      out.write(__oracle_jsp_text[156]);
      }else{
      out.write(__oracle_jsp_text[157]);
      if(strConf != null && strConf.trim().length()>0)
      				 {
      out.write(__oracle_jsp_text[158]);
      } 
      out.write(__oracle_jsp_text[159]);
      }
      out.write(__oracle_jsp_text[160]);
      if(strInact == "3" || strInact.equals("3")) 
      						{
      out.write(__oracle_jsp_text[161]);
      
      						}
      out.write(__oracle_jsp_text[162]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[163]);
      
      						}
      out.write(__oracle_jsp_text[164]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[165]);
      
      						}
      out.write(__oracle_jsp_text[166]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[167]);
      	}
      out.write(__oracle_jsp_text[168]);
      out.print(strFecInac);
      out.write(__oracle_jsp_text[169]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[170]);
      	}
      out.write(__oracle_jsp_text[171]);
      if(valida == 2) 
      						{
      out.write(__oracle_jsp_text[172]);
      
      						}
      out.write(__oracle_jsp_text[173]);
      if(valida == 2) 
      					{
      out.write(__oracle_jsp_text[174]);
      
      					}
      out.write(__oracle_jsp_text[175]);
      if(ver!="si") {
      out.write(__oracle_jsp_text[176]);
      
      					}
      out.write(__oracle_jsp_text[177]);
      if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {
      out.write(__oracle_jsp_text[178]);
      	}
      out.write(__oracle_jsp_text[179]);
      out.print(strJustInac);
      out.write(__oracle_jsp_text[180]);
      
      		}
      out.write(__oracle_jsp_text[181]);

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
  private static final char __oracle_jsp_text[][]=new char[182][];
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
    "\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<META name=\"GENERATOR\" content=\"IBM Software Development Platform\">\n<META http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/calendar.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\"\n\ttype=\"text/css\">\n<script type=\"text/javascript\" src=\"../js/menu.js\"></script>\n<script type=\"text/javascript\" src=\"../js/Menu2.js\"></script>\n<TITLE>Instrumento</TITLE>\n<script type=\"text/javascript\" src=\"../js/valida.js\"></script>\n<STYLE type=text/css>\n\tBODY {\n\t\tmargin: 0px;\n\t}\n</STYLE>\n<SCRIPT language=\"JavaScript\" type=\"text/javascript\">\nfunction sum() { \n var at = parseInt(document.clsfsub.vigenciaat.value);\n var ac = parseInt(document.clsfsub.vigenciaac.value);\n\n\tif (isNaN(at)==true) \n\tat = 0;\n\tif (isNaN(ac)==true) \n\tac = 0;\n\t\n   suma = at + ac;\n   document.clsfsub.vigenciatot.value = suma\n\n}\n\nfunction limpiarCampos(){\n\tdocument.clsfsub.reset();\n}\n function detalle2() {\n\tcambio(); \n\t//det2= document.clsfsub.comb.value;\n\t//document.getElementById('detalle2').src= \"CombDetalle.jsp?cls=\"+det2;\n\t}\t\n function detalle() { \n\tcambio();  \n\tdet= document.clsfsub.valor.value;\n\tdocument.getElementById('detalle').src= \"DetalleValor.jsp?cls=\"+det;\n\t}\n function copiar()\n {\n anio= document.clsfsub.reserv.value;\n document.clsfsub.anopub.value = anio;\n }\n function rValidando() {\n\t".toCharArray();
    __oracle_jsp_text[10] = 
    "\n\talert(\"Como este registro ya cuenta con registros dependientes, solo podra ser modificado su Descripción \");\n\t".toCharArray();
    __oracle_jsp_text[11] = 
    "\n } \n function cambio(){\n\tdoc = document.clsfsub;\n\t\n\tval2 = doc.valor.value;\n\tdoc.valor2.value = val2;\n\tval3 = doc.seleccion.value;\n\tdoc.selec2.value = val3;\t\t\n } \n function windowAbre(s)\n \t{\n \twindow.open( s ,'window','width=620,height=450,status=yes');\n \twindow.focus;\n \t}\n \t\nfunction reload() {\n\t\n\tdoc = document.clsfsub;\n\t//doc.cargaclv.value=\"CARGA\";\n\tdoc.accion.value=\"reload\";\n\tdoc.submit();\n\n} \nfunction claved() {\n\tdoc = document.clsfsub;\n\tdoc.cargaclv.value=\"CARGA\";\n}\t\nfunction indefinido()\n {\n doc = document.clsfsub;\n \tif (doc.vigIndef.checked == true) {\n \tdoc.vigenciaac.value = \"99\";\n \tdoc.vigenciaat.value = \"99\";\n \tdoc.vigenciatot.value = \"999\";\n \tdoc.vigenciaac2.value = \"99\";\n \tdoc.vigenciaat2.value = \"99\";\n \tdoc.vigenciatot2.value = \"999\";\n \tdoc.vigenciaac.disabled = true;\n \tdoc.vigenciaat.disabled = true;\n \tdoc.vigenciatot.disabled = true;\n \t}\n \telse\n \t{\n \tdoc.vigenciaac.disabled =false;\n \tdoc.vigenciaat.disabled =false;\n \tdoc.vigenciatot.disabled =false;\n \tdoc.vigenciaac.value = doc.vigenciaac3.value;\n \tdoc.vigenciaat.value = doc.vigenciaat3.value;\n \tdoc.vigenciatot.value = doc.vigenciatot3.value;\n \t}\n }\n\nfunction habilita2()\n\t{\n\t\tif(document.clsfsub.inactivo.checked == true)\n\t\t{\n\t\tdocument.clsfsub.fecinact.value = \"".toCharArray();
    __oracle_jsp_text[12] = 
    "\";\n\t\tdocument.clsfsub.fecinact.disabled = false;\n\t\tdocument.clsfsub.justif.disabled = false;\n\t\t}else\n\t\t{\n\t\tdocument.clsfsub.fecinact.value = \"\";\n\t\tdocument.clsfsub.justif.value = \"\";\n\t\tdocument.clsfsub.fecinact.disabled = true;\n\t\tdocument.clsfsub.justif.disabled = true;\n\t\t}\n\t}\t\nfunction idllena()\t\n{\n\tid = document.clsfsub.serieP.value;\n\tdocument.clsfsub.id_subsr.value = id;\n}\nfunction validanum()\t\n{\n\tval = parseInt(document.clsfsub.vigenciaat.value);\n\tnumv= parseInt(".toCharArray();
    __oracle_jsp_text[13] = 
    ");\n\tif(val > numv)\n\t\t{\n\t\talert(\"El valor no puede ser mayor al predefinido por la Serie\");\n\t\tdocument.clsfsub.vigenciaat.value = numv;\n\t\treturn false;\n\t\t}\n\telse\n\t\t{\n\t\tsum();\n\t\t}\n}\nfunction validanum2()\t\n{\n\tval = parseInt(document.clsfsub.vigenciaac.value);\n\tnumv= parseInt(".toCharArray();
    __oracle_jsp_text[14] = 
    ");\n\tif(val > numv)\n\t\t{\n\t\talert(\"El valor no puede ser mayor al predefinido por la Serie\");\n\t\tdocument.clsfsub.vigenciaac.value = numv;\n\t\treturn false;\n\t\t}\n\telse\n\t\t{\n\t\tsum();\n\t\t}\n}\n\nfunction llenando()\t\t\n\t{\n\tvar a =  document.clsfsub.clave.value;\n\tnum = a.length;\n\tvar af = \"\";\n\tif(num < 3)\n\t\t{\n\t\t\tfor (i=num; i<3; i++){\n\t\t\t\taf = af + \"0\";\n\t\t\t}\n\t\t}\n\tdocument.clsfsub.clave.value = af+a;\n\t}\nfunction validaAniosRerv()\t\t\n\t{\n\tvar a =  document.clsfsub.reserv.value;\n\tif (eval(a)>12)\t\n\t\t{\n\t\t\talert(\"Los Años de reserva no puenden ser mayor a 12 Años!\");\n\t\t\tdocument.clsfsub.reserv.value =\"12\";\n\t\t}\n\t}\t\n</SCRIPT>\n</HEAD>\n<BODY background=\"../Imagenes/fondo_claro.jpg\" onload=\"valida=0;rValidando();limpiarCampos();timer_load();detalle()\" \n\tonKeyPress=\"timer_reload();\" \n\tonmousemove=\"\tlimitaTextArea(document.clsfsub.subSeccion,'Descripción','4000');\n\t\t\t\t\tlimitaTextArea(document.clsfsub.obvser,'Observaciones','1000');\"\n\tonClick=\"timer_reload();\">\n<FORM action=\"ClasificacionArchSub.jsp\" name=\"clsfsub\" method=\"post\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" value=\"\" name=\"cargaclv\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[15] = 
    "\" name=\"vigenciaac2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[16] = 
    "\" name=\"vigenciaat2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[17] = 
    "\" name=\"vigenciatot2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[18] = 
    "\" name=\"vigenciaac3\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[19] = 
    "\" name=\"vigenciaat3\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[20] = 
    "\" name=\"vigenciatot3\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[21] = 
    "\" name=\"id_sub\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\" name=\"id_subsr\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[23] = 
    "\" name=\"aux\"> \n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[24] = 
    "\" name=\"combina2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[25] = 
    "\" name=\"valor2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\" name=\"selec2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[27] = 
    "\" name=\"retURI\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[28] = 
    "\" name=\"SerieP2\">\n".toCharArray();
    __oracle_jsp_text[29] = 
    "\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[30] = 
    "\" name=\"soloDesc\">\n\n<br>\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\"><a href=\"".toCharArray();
    __oracle_jsp_text[31] = 
    "\"> <IMG\n\t\t\t\tborder=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\"> </a>\n\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t".toCharArray();
    __oracle_jsp_text[32] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[33] = 
    "\n\t\t\t\t\t\t<a></a>\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[34] = 
    "\t\n\t\t\t\t\t\t<a><img\tsrc=\"../Imagenes/Save.gif\" alt=\"Guardar\"\tonclick=\"GuardarClasfsub()\"></a> \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[35] = 
    "\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[36] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"48\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD></TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n\n\n<DIV class=\"documentBody\" id=\"Body\" style=\"HEIGHT: 441px\">\n<DIV align=\"center\">\n<DIV align=\"center\">\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" width=\"204\"><B><FONT face=\"Verdana\" color=\"#00204f\"\n\t\t\t\tsize=\"2\"><FONT size=\"+1\" color=\"#004080\">Instrumento Clasificación y Disposición Documental (Subserie)</FONT></FONT></B></TD>\n\t\t\t<TD width=\"26\">&nbsp;</TD>\n\t\t\t<TD width=\"442\" align=\"right\">&nbsp;**Los datos marcados con negritas son obligatorios</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD width=\"204\" colspan=\"2\"></TD>\n\t\t\t<TD width=\"26\"></TD>\n\t\t\t<TD width=\"442\" align=\"right\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD width=\"204\" colspan=\"2\"></TD>\n\t\t\t<TD width=\"26\"></TD>\n\t\t\t<TD width=\"442\" align=\"right\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></B></FONT></TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[37] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[38] = 
    " - ".toCharArray();
    __oracle_jsp_text[39] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[40] = 
    "\n\t\t\t<TD width=\"528\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[41] = 
    " - ".toCharArray();
    __oracle_jsp_text[42] = 
    "</I></FONT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[43] = 
    "\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFondo:</FONT></B></FONT>&nbsp;<A href=\"#\" onclick=\"windowAbre('FondoArch.jsp')\"><FONT color=\"Blue\" size=\"1\"></FONT></A></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[44] = 
    "\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[45] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[46] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[47] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[48] = 
    "\t\n\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tSubFondo:</FONT></B></FONT>&nbsp;<A href=\"#\" onclick=\"windowAbre('SubfondoArch.jsp')\"><FONT color=\"Blue\" size=\"1\"></FONT></A></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[49] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[50] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[51] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[52] = 
    "\n\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[53] = 
    "\t\t\t\t\t\t\t\n\t\t\t</TD>\n\t\t</TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tSección:</FONT></B></FONT>&nbsp;<A href=\"#\" onclick=\"windowAbre('SeccionArch.jsp')\"><FONT color=\"Blue\" size=\"1\"></FONT></A></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[54] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[55] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[56] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[57] = 
    "\n\t\t\t\n\t\t\t".toCharArray();
    __oracle_jsp_text[58] = 
    "\t\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>                                                                                                                                                                                      \n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tSerie:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[59] = 
    "\t\t\t\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[60] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[61] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[62] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "\t\t\t\t\t\t\t\n\t\t\t</TD>\n\t\t</TR>\t\t\n\t\t".toCharArray();
    __oracle_jsp_text[64] = 
    "\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>                                                                                                                                                                                      \n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tEstructura:<BR>\n\t\t\t</FONT>\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"struct\" value=\"".toCharArray();
    __oracle_jsp_text[65] = 
    "\" MAXLENGTH=\"200\" \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[66] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[67] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[68] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[69] = 
    "\t\n\t\t\t\ttype=\"text\" class=\"blue500\" onfocus=\"blur();\" onkeypress=\"AceptaSoloTeclaNumericaYPunto();\" readonly>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><B><FONT face=\"Verdana\" size=\"2\" color=\"#004080\">\n\t\t\tClave:</FONT></B><BR>\n\t\t\t".toCharArray();
    __oracle_jsp_text[70] = 
    "<B><FONT color=\"red\">*Esta clave ya existe*</FONT>\n\t\t\t</B>".toCharArray();
    __oracle_jsp_text[71] = 
    "\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"clave\" value=\"".toCharArray();
    __oracle_jsp_text[72] = 
    "\" MAXLENGTH=\"3\"  \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[73] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[75] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[76] = 
    "\t\t\n\t\t\t\t  type=\"text\" class=\"blue100\"  onblur=\"llenando();\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\t\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tNombre:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"subCodigo\" value=\"".toCharArray();
    __oracle_jsp_text[77] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[79] = 
    "\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[80] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\t\t\t\n\t\t\t\ttype=\"text\" class=\"blue500\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\">&nbsp;</FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tDescripción:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<TEXTAREA name=\"subSeccion\" rows=\"5\" cols=\"65\" \n\t\t\t\tonKeyDown=\"limitaTextArea(document.clsfsub.subSeccion,'Descripción','4000');\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[84] = 
    "</TEXTAREA> \n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">\n\t\t\t&nbsp;</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tValoración:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[87] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[89] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[93] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[94] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[97] = 
    "\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\">\n\t\t\t<INPUT type=\"button\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[98] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[99] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[100] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\t\t\t\t\n\t\t\tonclick=\"document.getElementById('pop9').style.visibility='visible';\" class=\"s-dropdown-btn\">\n\t\t\t<DIV class=\"popup\" id=\"pop9\">\n\t\t\t\t<IFRAME src=\"#\"  WIDTH=\"700\" HEIGHT=\"200\" frameborder=1 id=\"detalle\"></IFRAME>\n\t\t\t</DIV>\n\t\t\t</TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tVigencia Indefinida:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=checkbox  value=\"si\"  \n\t\t\t\tname=\"vigIndef\"\n\t\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t\t\tchecked\n\t\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\t\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[105] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[106] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[107] = 
    "\t\n\t\t\t\tonclick=\"indefinido();\">\n\t\t\t</TD>\n\t\t</TR>\t\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD> \n\t\t</TR>\n\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tVigencia AT:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<INPUT name=\"vigenciaat\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[109] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[110] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[111] = 
    "\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[112] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\t\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[114] = 
    "\" MAXLENGTH=\"2\" type=\"text\" class=\"blue100\"\n\t\t\tonblur=\"validanum()\" \n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tVigencia AC:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<INPUT name=\"vigenciaac\" value=\"".toCharArray();
    __oracle_jsp_text[115] = 
    "\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[117] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[118] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[120] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[121] = 
    "\t\n\t\t\tMAXLENGTH=\"2\" onblur=\"validanum2();\" type=\"text\" class=\"blue100\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tVigencia TOTAL:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<INPUT name=\"vigenciatot\"  value=\"".toCharArray();
    __oracle_jsp_text[122] = 
    "\" MAXLENGTH=\"3\" type=\"text\" class=\"blue100\" onfocus=\"blur();\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[125] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[126] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[127] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\t\t\t\t\t\t\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD> \n\t\t</TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tTécnica de Selección:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[132] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[134] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[135] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[136] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[137] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[138] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[139] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[140] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[141] = 
    "\t\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tObservaciónes:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<TEXTAREA name=\"obvser\" rows=\"3\" cols=\"65\" \n\t\t\t\tonkeydown=\"limitaTextArea(document.clsfsub.obvser,'Descripción','1000');\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[142] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[143] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[144] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[145] = 
    "\n\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[146] = 
    "</TEXTAREA> \n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tAños Reserva:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t<INPUT name=\"reserv\" value=\"".toCharArray();
    __oracle_jsp_text[147] = 
    "\" onkeyup=\"validaAniosRerv()\" \n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[148] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[149] = 
    "\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[150] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[151] = 
    "\t\n\t\t\t MAXLENGTH=\"4\" type=\"text\" class=\"blue100\"\n\t\t\t\t\tonkeypress = \"AceptaSoloTeclaNumericaYPunto();\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B><FONT face=\"Verdana\" size=\"2\">\n\t\t\tConfidencial:</FONT></B></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[152] = 
    "\t\t\n\t\t\t\t<INPUT type=checkbox  value=\"si\"  disabled=\"disabled\"\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[153] = 
    "\n\t\t\t\t checked\n\t\t\t\t ".toCharArray();
    __oracle_jsp_text[154] = 
    "\n\t\t\t\tname=\"conf\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[155] = 
    "\n\t\t\t\t<INPUT type=\"hidden\" value=\"si\" name=\"conf\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[156] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[157] = 
    "\t\t\n\t\t\t\t<INPUT type=checkbox  value=\"si\"  \n\t\t\t\t".toCharArray();
    __oracle_jsp_text[158] = 
    "\n\t\t\t\t checked\n\t\t\t\t ".toCharArray();
    __oracle_jsp_text[159] = 
    "\n\t\t\t\tname=\"conf\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[160] = 
    "\t\n\t\t\t</TD>\n\t\t</TR>\t\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tInactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT type=checkbox onclick=\"habilita2()\" value=\"3\" \n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[161] = 
    "\n\t\t\t\t\t\t checked\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[162] = 
    "\t\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[163] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[164] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[165] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[166] = 
    "\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[167] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[168] = 
    "\t\n\t\t\t\tname=\"inactivo\">\n\t\t\t</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\t\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tFecha Inactivo:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<INPUT name=\"fecinact\" value=\"".toCharArray();
    __oracle_jsp_text[169] = 
    "\"\n\t\t\t\t\t\tonfocus=\"blur();\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[170] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[171] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[172] = 
    "\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[173] = 
    "\n\t\t\t\ttype=\"text\" class=\"blue100\" maxlength=\"200\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><B>&nbsp;</B></FONT></TD>\n\t\t\t<TD width=\"528\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"144\"><FONT color=\"#004080\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\tJustificacion:</FONT></FONT></TD>\n\t\t\t<TD width=\"528\">\n\t\t\t\t<TEXTAREA name=\"justif\" id=\"justif\" rows=\"3\" cols=\"65\" \n\t\t\t\t\tonkeypress=\"limitaTextArea(document.clsfsub.justif,'Justificación','1000');\"\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[174] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[175] = 
    "\n\t\t\t\t\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[176] = 
    "\n\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[177] = 
    "\t\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[178] = 
    "\n\t\t\n\t\t\t\t\t\tdisabled=\"disabled\"\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[179] = 
    "\n\t\t\t\t\tclass=\"blue500\">".toCharArray();
    __oracle_jsp_text[180] = 
    "</TEXTAREA>\n\t\t\t</TD>\n\t\t</TR>\n\t\t".toCharArray();
    __oracle_jsp_text[181] = 
    "\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t</TBODY>\n</TABLE>\n<BR>\n<BR>\n</DIV>\n</DIV>\n</DIV>\n</FORM>\n</BODY>\n</HTML>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
