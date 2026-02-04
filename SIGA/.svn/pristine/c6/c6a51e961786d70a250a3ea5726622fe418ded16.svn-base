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
import com.meve.sigma.ldap.*;
import com.meve.sigma.util.*;
import java.util.Vector;


public class _Usuarios extends com.orionserver.http.OrionHttpJspPage {


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
    _Usuarios page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      {
        String __url=OracleJspRuntime.toStr("headerC.jsp");
        // Include 
        pageContext.include( __url,false);
        if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) return;
      }

      out.write(__oracle_jsp_text[2]);
      out.write(__oracle_jsp_text[3]);
      com.meve.sigma.beans.AreaBean BUsuario1;
      synchronized (pageContext) {
        if ((BUsuario1 = (com.meve.sigma.beans.AreaBean) pageContext.getAttribute( "BUsuario1", PageContext.PAGE_SCOPE)) == null) {
          BUsuario1 = (com.meve.sigma.beans.AreaBean) new com.meve.sigma.beans.AreaBean();
          pageContext.setAttribute( "BUsuario1", BUsuario1, PageContext.PAGE_SCOPE);
          out.write(__oracle_jsp_text[4]);
          OracleJspRuntime.__jspSetAllParams(request, (Object)BUsuario1, true);
          out.write(__oracle_jsp_text[5]);
          out.write(__oracle_jsp_text[6]);
          out.write(__oracle_jsp_text[7]);
          out.write(__oracle_jsp_text[8]);
          out.write(__oracle_jsp_text[9]);
          out.write(__oracle_jsp_text[10]);
          out.write(__oracle_jsp_text[11]);
          out.write(__oracle_jsp_text[12]);
          com.meve.sigma.beans.EscrituraBean BEscritura;
          synchronized (pageContext) {
            if ((BEscritura = (com.meve.sigma.beans.EscrituraBean) pageContext.getAttribute( "BEscritura", PageContext.PAGE_SCOPE)) == null) {
              BEscritura = (com.meve.sigma.beans.EscrituraBean) new com.meve.sigma.beans.EscrituraBean();
              pageContext.setAttribute( "BEscritura", BEscritura, PageContext.PAGE_SCOPE);
            }
          }
          out.write(__oracle_jsp_text[13]);
          
          	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
          	String strTmp=request.getRequestURI();
          	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
          	if(BUsuario==null){
          		try{
          			response.sendRedirect("index.jsp?pagina="+ strTmp);
          		}
          		catch(java.io.IOException io){;}
          	}
          
          
          out.write(__oracle_jsp_text[14]);
           if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
          		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
          		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
          		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
          		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ 
          out.write(__oracle_jsp_text[15]);
          if (true) {
            String __url=OracleJspRuntime.toStr("../Error/ERUsuarioInvalido.jsp");
            // Forward 
            pageContext.forward( __url);
            return;
          }

          out.write(__oracle_jsp_text[16]);
           } 
          out.write(__oracle_jsp_text[17]);
          
          	String recCreador	[][]= 	null;
          	String recUsuario	[][]= 	null;
          	String strIdsRol	[][]=	null;
          	String strIdsCorreos[][]=	null;
          	String strUsrLDAP	[][]=	null;
          	String strJefePuesto[][]=	null;
          	String Ejemplo		[][]=	null;
          	String strIdUsuario 	= 	"";
           
          	String strUsuario 		= 	(BUsuario1.getUsuarioNombre()== null)?"":BUsuario1.getUsuarioNombre();
          	String strIdArea 		= 	(BUsuario1.getUsuarioArea()== null)?"":BUsuario1.getUsuarioArea();
          	String strCargo 		= 	(BUsuario1.getUsuarioCargo()== null)?"":BUsuario1.getUsuarioCargo();
          	String strCorreo 		= 	(BUsuario1.getUsuarioEmail()== null)?"":BUsuario1.getUsuarioEmail();
          	String strTelefono 		= 	(BUsuario1.getUsuarioTelefono()== null)?"":BUsuario1.getUsuarioTelefono();
          	String strConsecutivo 	= 	(BUsuario1.getUsuarioConsecutivo()== null)?"0":BUsuario1.getUsuarioConsecutivo();
          	String strIdRol			=	(BUsuario1.getUsuarioRol1()== null)?"":BUsuario1.getUsuarioRol1();
          	String strIdJefe 		= 	(BUsuario1.getUsuarioJefe()== null)?"":BUsuario1.getUsuarioJefe();
          	String admon			=	(BUsuario1.getAdmon()==null)?"-1":BUsuario1.getAdmon();
          	String atencion			=	(BUsuario1.getAtencion()==null)?"":BUsuario1.getAtencion();
          	String gestion			=	(BUsuario1.getGestion()==null)?"":BUsuario1.getGestion();
          	String recepcion		=	(BUsuario1.getRecepcion()==null)?"":BUsuario1.getRecepcion();
          	String supervisor		=	(BUsuario1.getSupervisor()==null)?"":BUsuario1.getSupervisor();
          	String turnado			=	(BUsuario1.getTurnado()==null)?"":BUsuario1.getTurnado();
          	String asistente		=	(BUsuario1.getAsistente()==null)?"-1":BUsuario1.getAsistente();
          	String strConfMail		=	(BUsuario1.getUsuarioConfMails1()== null)?"":BUsuario1.getUsuarioConfMails1();
          	String strActivo		=	(BUsuario1.getUsuarioActivo()== null)?"":BUsuario1.getUsuarioActivo();
          	String strUID			=	(BUsuario1.getUid()== null)?"":BUsuario1.getUid();
          	String strPassword		=	(BUsuario1.getUsuarioPassword()== null)?"":BUsuario1.getUsuarioPassword();
          	String a				=	(BUsuario1.getNuevoAsunto()==null)?"":BUsuario1.getNuevoAsunto();
          	String b				=	(BUsuario1.getTurnar()==null)?"":BUsuario1.getTurnar();
          	String c				=	(BUsuario1.getResponder()==null)?"":BUsuario1.getResponder();
          	String d				=	(BUsuario1.getRechazar()==null)?"":BUsuario1.getRechazar();
          	String e				=	(BUsuario1.getDelegar()==null)?"":BUsuario1.getDelegar();
          	String t				=	(BUsuario1.getReasignar()==null)?"":BUsuario1.getReasignar();
          	String g				=	(BUsuario1.getHabilitar()==null)?"":BUsuario1.getHabilitar();
          	String h				=	(BUsuario1.getSolicitudCambio()==null)?"":BUsuario1.getSolicitudCambio();
          	String z				=	(BUsuario1.getRespuestaCambio()==null)?"":BUsuario1.getRespuestaCambio();
          	String catArch			= 	(BUsuario1.getCatArch()==null)?"0":request.getParameter("catArch1");
          	String notificacion		=	(BUsuario1.getNot()==null)?"1":request.getParameter("not1");
          	String strDesExt		=	(BUsuario1.getUsuarioDesExt()==null)?"0":request.getParameter("usuarioDesExt");
          	String strSubVent		=	(BUsuario1.getUsuarioSubVent()==null)?"0":request.getParameter("usuarioSubVent");
          	String[] strIdAsistente = 	(BUsuario1.getUsuarioAsistente()== null)?null:BUsuario1.getUsuarioAsistente();
                  String strCadenaMando 	= 	"";
          	String strcompasArea 	= 	"";
          	String strCreador 		= 	"";
          	String strCreador1 		= 	"";
          	String strFechaCreacion	=	"";
          	String strAccion 		= 	"";
          	String strFirma			=	"";
          	String strEstatus 		= 	"1";
          	String strUsuario12		=	"";
          	String strUID1			=	"";
          	
          
          	boolean HabComboAsistente = true;
          	boolean esSupervisor	=	false;
          
          	String strActivarLDAP	=	application.getInitParameter("ActivarLDAP");
          
          	String retURI = (request.getParameter("retURI")==null)?"UsuariosView.jsp":request.getParameter("retURI");
          
          	String strAux = "1a2b3c", strAux2 = "1a2b3c", strAux3 = "1a2b3c", strAux4 = "1a2b3c4d5e"; 
          	int valida = -2, valida2 = -2;
              
          	boolean blnExisteFirma	=	false; //Para comprobar si existe una firma digital
          	boolean bInsertar 		= 	false; //Insertar un nuevo usuario
          	boolean bActualizar 	= 	false; //Actualizar datos de un usuario
          	boolean bExisteUsuario	=	false; //Si existe un usuario en la base de datos
          	boolean bExisteUsuarioUA	=	false; //Si existe un usuario en la unidad administrativa
          	boolean bExisteUSR		=	false;
          	boolean bBitacora 		= 	false;
          	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
          	java.util.Date f = new java.util.Date();
          	strFechaCreacion = sdf.format(f);
          
          	strCreador1	=	BUsuario.getIdUsuario();
          	strCreador	=	BUsuario.getNombre();
          		
          	strIdUsuario = (request.getParameter("id_usuario")!=null)?request.getParameter("id_usuario"):"";
          	strAccion 	= 	(request.getParameter("accion")!=null)?request.getParameter("accion"):"";
          	strAux		=	request.getParameter("aux");
          	strAux2		=	request.getParameter("aux2");
          	strAux3		=	request.getParameter("aux3");
          	strAux4		=	request.getParameter("aux4");
          
          	if (strIdUsuario.length() == 0){
          		String strIdUsuario2 = "-1";
          		Ejemplo = ComboData.getDependencia(strIdUsuario2);
          	}else{
          		Ejemplo = ComboData.getDependencia(strIdUsuario);
          	}
          
          	Vector vSubalternos = new Vector();
          
          	if (strAccion != null && strAccion.equals("consultar"))
          	{
          		strIdUsuario = (request.getParameter("id_usuario")!=null)?request.getParameter("id_usuario"):"";
          
          		if (strIdUsuario.equals("0")) {
          			response.sendRedirect(retURI);
          		}
          
          		if (strIdUsuario != null) {
          			String strUsuarios[][] = ActualizaUsuario.getSubordinadosSinRol(strIdUsuario);
          			AsignarArbol tree = new AsignarArbol(strUsuarios);
          			vSubalternos = tree.getIds();
          			recUsuario       	= 	ActualizaUsuario.getUsuario(strIdUsuario);
          			strIdsRol			=	ActualizaRol.getRoles(strIdUsuario);
          			strIdsCorreos		=	ActualizaParamCorreo.getParamCorreo(strIdUsuario);
          			strIdAsistente		=	ActualizaUsuario.getAsistentes(strIdUsuario);
          			strUsuario       	= 	recUsuario[0][0];
          			strIdArea 	     	= 	recUsuario[0][1];
          			strCargo         	= 	recUsuario[0][2];
          			strCorreo        	= 	recUsuario[0][3];
          			strTelefono      	= 	recUsuario[0][4];
          			strConsecutivo	 	= 	recUsuario[0][5];
          			strIdJefe        	= 	recUsuario[0][6];
          			strCreador       	= 	ActualizaUsuario.NombreUsuario(recUsuario[0][8]);
          			strFechaCreacion 	= 	recUsuario[0][9];
          			strFirma			=	recUsuario[0][11];
          			strActivo			=	recUsuario[0][12];
          			strUID				=	recUsuario[0][13];
          			catArch				= 	recUsuario[0][14];
          			notificacion		=	recUsuario[0][15];
          			strDesExt			=	recUsuario[0][16];
          			strSubVent			=	recUsuario[0][17];
          
          			if(BUsuario.getIdUsuario().equals(catArch))
          				esSupervisor = true;
          			
          			strAux  = strUsuario;
          			strAux2 = strIdArea;
          			strAux3 = strCargo;
          			strAux4 = strUID;
          
          			if(strActivarLDAP.equals("0")){
          				strUsrLDAP = ActualizaAutentificacion.getDatosUsuario(strUID);
          				if(strUsrLDAP.length == 0){
          					strUsrLDAP = new String[1][2];
          				}else{
          					strUID1		= strUsrLDAP[0][0];
          					strPassword = strUsrLDAP[0][1];
          					if(strUID1 != null)
          						strUID = strUID1;
          				}
          			}else{
          				strUsrLDAP = ActualizaAutentificacion.getDatosUsuario(strUID);
          				if(strUsrLDAP.length == 0){
          					strUsrLDAP = new String[1][2];
          				}else{
          					strUID1		= strUsrLDAP[0][0];
          					strPassword = strUsrLDAP[0][1];
          					if(strUID1 != null)
          						strUID = strUID1;
          				}
          			}
          				
          			for(int i=0;i<strIdsRol.length;i++){
          				if(new Integer(strIdsRol[i][0]).intValue() == 0)
          					admon = "0";
          				if(new Integer(strIdsRol[i][0]).intValue() == 1)
          					atencion = "1";
          				if(new Integer(strIdsRol[i][0]).intValue() == 2)
          					gestion = "2";
          				if(new Integer(strIdsRol[i][0]).intValue() == 3)
          					recepcion = "3";
          				if(new Integer(strIdsRol[i][0]).intValue() == 4)
          					supervisor = "4";
          				if(new Integer(strIdsRol[i][0]).intValue() == 5)
          					turnado = "5";
          				if(new Integer(strIdsRol[i][0]).intValue() == 6)
          					asistente = "6";
          			}
          			for(int s=0;s<strIdsCorreos.length;s++){
          				if(new Integer(strIdsCorreos[s][0]).intValue() == 0)
          					a = "0";
          				if(new Integer(strIdsCorreos[s][0]).intValue() == 1)
          					b = "1";
          				if(new Integer(strIdsCorreos[s][0]).intValue() == 2)
          					c = "2";
          				if(new Integer(strIdsCorreos[s][0]).intValue() == 3)
          					d = "3";
          				if(new Integer(strIdsCorreos[s][0]).intValue() == 4)
          					e = "4";
          				if(new Integer(strIdsCorreos[s][0]).intValue() == 5)
          					t = "5";
          				if(new Integer(strIdsCorreos[s][0]).intValue() == 6)
          					g = "6";
          				if(new Integer(strIdsCorreos[s][0]).intValue() == 7)
          					h = "7";
          				if(new Integer(strIdsCorreos[s][0]).intValue() == 8)
          					z = "8";
          			}
          			if(recUsuario[0][11]!=null){
                     		if((recUsuario[0][11] instanceof String) && (recUsuario[0][11].toString().trim().equals("-") || 
          					recUsuario[0][11].toString().trim().length()==0));
                         	else
          					blnExisteFirma=true;
          			}
          		
          		}
          	}
          
          	if (strAccion != null && strAccion.equals("cambiar"))
          	{
          		strIdUsuario = request.getParameter("id_usuario");
          		if (strIdUsuario != null) {
          			strUsuario		= 	request.getParameter("usuarioNombre");
          			strUID			=	request.getParameter("uid");
          			if(strActivarLDAP.equals("0")){
          				strPassword	=	request.getParameter("usuarioPassword");
          			}else{
          				strPassword	=	request.getParameter("usuarioPassword");
          			}
          			strIdArea		= 	request.getParameter("usuarioArea");
          			strCargo		= 	request.getParameter("usuarioCargo");
          			strCorreo		= 	request.getParameter("usuarioEmail");
          			strTelefono 	= 	request.getParameter("usuarioTelefono");
          			strConsecutivo	= 	request.getParameter("usuarioConsecutivo");
          			strIdJefe		= 	request.getParameter("usuarioJefe");
          			strIdAsistente	= 	request.getParameterValues("usuarioAsistente");
                                  strIdRol		=	request.getParameter("usuarioRol1");
          			String firma 	=  	request.getParameter("firmaDigital");
          			strConfMail		=	request.getParameter("usuarioConfMails1");
          			strActivo		=	request.getParameter("usuarioActivo");
          			catArch			= 	request.getParameter("catArch1");
          			notificacion	=	request.getParameter("not1");
          			strDesExt		=	(request.getParameter("usuarioDesExt")==null?"0":request.getParameter("usuarioDesExt"));
          			strSubVent		=	(request.getParameter("usuarioSubVent")==null?"0":request.getParameter("usuarioSubVent"));
          				
          			strAux		=	request.getParameter("aux");
          			strAux2		=	request.getParameter("aux2");
          			strAux3		=	request.getParameter("aux3");
          			strAux4		=	request.getParameter("aux4");
          	
          			bExisteUsuario	=	ActualizaUsuario.getExisteUsuario(strUID,strAux4); //Verifica si existe el usuario
          			if(request.getParameter("usuario_duplicado")!=null&&"true".equals(request.getParameter("usuario_duplicado"))){
          				bExisteUsuario = false;
          			}
          			valida  = 2;
          			valida2 = ActualizaUsuario.getResponsableExiste(strCargo, strAux3);		
          			if(!bExisteUsuario){ 
          
          				if (valida == 2 && valida2 == 2){
          					String datos[][] = ActualizaUsuario.getUsuario(strIdUsuario);
          					bInsertar	= ActualizaUsuario.
          										ActualizarUsuario1(strIdUsuario,strUsuario, strIdArea,
          															strCargo, strCorreo, strTelefono, 
          															strConsecutivo, strIdJefe, strIdAsistente, 
          															strCreador1, strFechaCreacion, 
          															strActivo, strUID, catArch, 
          															notificacion, strDesExt, strSubVent,
          															strActivarLDAP, BUsuario.getIdUsuario(),
          															datos, strPassword, strIdRol, strConfMail);	
          
          				}		
          			}
          		}
          	}
          
          	if (strAccion != null && strAccion.equals("guardar"))
          	{
          		strUsuario		= 	request.getParameter("usuarioNombre");
          		strUID			=	request.getParameter("uid");
          		if(strActivarLDAP.equals("0")){
          			strPassword	=	request.getParameter("usuarioPassword");
          		}else{
          			strPassword	=	request.getParameter("usuarioPassword");
          		}
          		strIdArea		= 	request.getParameter("usuarioArea");
          		strCargo		= 	request.getParameter("usuarioCargo");
          		strCorreo		= 	request.getParameter("usuarioEmail");
          		strTelefono 	= 	request.getParameter("usuarioTelefono");
          		strConsecutivo	= 	request.getParameter("usuarioConsecutivo");
          		strIdJefe		= 	request.getParameter("usuarioJefe");
          		strIdAsistente	= 	request.getParameterValues("usuarioAsistente");
          		strIdRol		= 	request.getParameter("usuarioRol1");				
          		String firma 	=  	request.getParameter("firmaDigital");
          		strConfMail		=	request.getParameter("usuarioConfMails1");
          		catArch			= 	request.getParameter("catArch1");
          		notificacion	=	request.getParameter("not1");
          		strDesExt		=	(request.getParameter("usuarioDesExt")==null?"0":request.getParameter("usuarioDesExt"));
          		strSubVent		=	(request.getParameter("usuarioSubVent")==null?"0":request.getParameter("usuarioSubVent"));
          		
          		bExisteUsuario	=	ActualizaUsuario.getExisteUsuario(strUID,strAux4);
          		if(request.getParameter("usuario_duplicado")!=null&&"true".equals(request.getParameter("usuario_duplicado"))){
          			bExisteUsuario = false;
          		}
          		valida  = 2;
          		valida2 = ActualizaUsuario.getResponsableExiste(strCargo, strAux3);	
          		if(!bExisteUsuario){ 
          			if (valida == 2 && valida2 == 2){ 
          				boolean insertar = ActualizaUsuario.InsertarUsuario1(strUsuario, strIdArea, 
          											strCargo, strCorreo, strTelefono, strConsecutivo,
          											strIdJefe, strIdAsistente, strCreador1, 
          											strFechaCreacion, strEstatus, strUID, catArch, 
          											notificacion, strDesExt, strSubVent,
          											strActivarLDAP, BUsuario.getIdUsuario(),
          											strPassword, strIdRol, strConfMail);
          
          				try
          				{
          					response.sendRedirect(retURI);
          				}
          				catch(java.io.IOException io){
          					System.out. println("ERROR:"+io.getMessage());
          				}
          			}
          		}
          	}
          
          	if(strAccion!=null && strAccion.equals("cambiar") && valida == 2 && valida2 == 2 && !bExisteUsuario)
          	{
          		strAccion	=	"";
          		try
          		{
          			response.sendRedirect(retURI);
          		}
          		catch(java.io.IOException io){;}
          	}
          	
          	String strIdJefePr		= 	strIdJefe;
          	String Jefe = null;
          	if(strIdJefePr.length() == 0 || strIdJefePr.equals("-1")){
          			Jefe = "No tiene Jefe Asignado";			
          	}else{
          		strJefePuesto = ComboData.getJefePuesto(strIdJefePr);
          		Jefe = strJefePuesto[0][0];
          	}
          
          	HabComboAsistente = atencion.trim().equals("1")?false:HabComboAsistente;
          
          out.write(__oracle_jsp_text[18]);
           if(strIdUsuario!=null && strIdUsuario.length()!=0){ 
          out.write(__oracle_jsp_text[19]);
           if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ 
          out.write(__oracle_jsp_text[20]);
           }else{ 
          out.write(__oracle_jsp_text[21]);
          if (true) {
            String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
            // Forward 
            pageContext.forward( __url);
            return;
          }

          out.write(__oracle_jsp_text[22]);
           } 
          out.write(__oracle_jsp_text[23]);
           } 
          out.write(__oracle_jsp_text[24]);
           	if(strIdUsuario!=null && strIdUsuario.length()!=0 ){ 
          	String strRolLIsta = ActualizaRol.getRoles(strIdUsuario)[0][0];  
          out.write(__oracle_jsp_text[25]);
           	if(BUsuario.getSupervisor() && strRolLIsta.equals("0")){ 
          out.write(__oracle_jsp_text[26]);
          if (true) {
            String __url=OracleJspRuntime.toStr("../Error/ERNoAccesoInstruccion.jsp");
            // Forward 
            pageContext.forward( __url);
            return;
          }

          out.write(__oracle_jsp_text[27]);
           	} 
          out.write(__oracle_jsp_text[28]);
           	} 
          out.write(__oracle_jsp_text[29]);
          out.print(admon);
          out.write(__oracle_jsp_text[30]);
          out.print(asistente);
          out.write(__oracle_jsp_text[31]);
          out.print(request.getParameter("accion"));
          out.write(__oracle_jsp_text[32]);
          out.print(strIdUsuario);
          out.write(__oracle_jsp_text[33]);
          out.print(admon);
          out.write(__oracle_jsp_text[34]);
          out.print(atencion);
          out.write(__oracle_jsp_text[35]);
          out.print(gestion);
          out.write(__oracle_jsp_text[36]);
          out.print(recepcion);
          out.write(__oracle_jsp_text[37]);
          out.print(supervisor);
          out.write(__oracle_jsp_text[38]);
          out.print(turnado);
          out.write(__oracle_jsp_text[39]);
          out.print(asistente);
          out.write(__oracle_jsp_text[40]);
          out.print(a);
          out.write(__oracle_jsp_text[41]);
          out.print(b);
          out.write(__oracle_jsp_text[42]);
          out.print(c);
          out.write(__oracle_jsp_text[43]);
          out.print(d);
          out.write(__oracle_jsp_text[44]);
          out.print(e);
          out.write(__oracle_jsp_text[45]);
          out.print(t);
          out.write(__oracle_jsp_text[46]);
          out.print(g);
          out.write(__oracle_jsp_text[47]);
          out.print(h);
          out.write(__oracle_jsp_text[48]);
          out.print(z);
          out.write(__oracle_jsp_text[49]);
          out.print(catArch);
          out.write(__oracle_jsp_text[50]);
          out.print(notificacion);
          out.write(__oracle_jsp_text[51]);
          out.print(strIdRol);
          out.write(__oracle_jsp_text[52]);
          out.print(strConfMail);
          out.write(__oracle_jsp_text[53]);
          out.print(strAux );
          out.write(__oracle_jsp_text[54]);
          out.print(strAux2 );
          out.write(__oracle_jsp_text[55]);
          out.print(strAux3 );
          out.write(__oracle_jsp_text[56]);
          out.print(strAux4 );
          out.write(__oracle_jsp_text[57]);
          out.print(retURI );
          out.write(__oracle_jsp_text[58]);
          if(strActivarLDAP.equals("2")){
          out.write(__oracle_jsp_text[59]);
          out.print( strUID );
          out.write(__oracle_jsp_text[60]);
          }
          out.write(__oracle_jsp_text[61]);
          if(!strActivarLDAP.equals("1")){
          out.write(__oracle_jsp_text[62]);
          out.print((strIdUsuario!=null && !strIdUsuario.equals(""))?"última Modificación por: ":"Creado por: ");
          out.write(__oracle_jsp_text[63]);
          out.print( strCreador);
          out.write(__oracle_jsp_text[64]);
          out.print( strFechaCreacion);
          out.write(__oracle_jsp_text[65]);
          out.print(strUID);
          out.write(__oracle_jsp_text[66]);
          out.print(strPassword);
          out.write(__oracle_jsp_text[67]);
          }else{
          out.write(__oracle_jsp_text[68]);
          out.print( strCreador);
          out.write(__oracle_jsp_text[69]);
          out.print( strFechaCreacion);
          out.write(__oracle_jsp_text[70]);
          out.print(strUID);
          out.write(__oracle_jsp_text[71]);
          out.print(strPassword);
          out.write(__oracle_jsp_text[72]);
          }
          out.write(__oracle_jsp_text[73]);
          if(strActivarLDAP.equals("2")){
          out.write(__oracle_jsp_text[74]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_1=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name multiple classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_1.setParent(null);
            __jsp_taghandler_1.setData(ActualizaLdap.getComboUsuariosLdapA());
            __jsp_taghandler_1.setName("comboUsuarios1");
            __jsp_taghandler_1.setMultiple(false);
            __jsp_taghandler_1.setClassHtml("blue600a");
            __jsp_taghandler_1.setScript("onChange='ActuliazaCorreoA(this);' onKeypress='buscar_op(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'");
            __jsp_taghandler_1.setTextoNoSeleccion(" ---------------- Selecciona un Puesto ---------------- ");
            __jsp_taghandler_1.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
            if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
          }
          out.write(__oracle_jsp_text[75]);
          }
          out.write(__oracle_jsp_text[76]);
           if(BUsuario.getSupervisor()){ 
          			if(strIdUsuario==null){
          				strIdArea = BUsuario.getIdArea();
          			}
          out.write(__oracle_jsp_text[77]);
           if (Ejemplo.length>0){ 
          out.write(__oracle_jsp_text[78]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_2=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_2.setParent(null);
            __jsp_taghandler_2.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
            __jsp_taghandler_2.setName("usuarioArea20");
            __jsp_taghandler_2.setSize(1);
            __jsp_taghandler_2.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_2.setClassHtml("blue600a");
            __jsp_taghandler_2.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='usuarios1()' disabled = 'true'");
            __jsp_taghandler_2.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
            __jsp_taghandler_2.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
            if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
          }
          out.write(__oracle_jsp_text[79]);
          out.print(strIdArea);
          out.write(__oracle_jsp_text[80]);
          }else { 
          out.write(__oracle_jsp_text[81]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_3=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_3.setParent(null);
            __jsp_taghandler_3.setData(ComboData.getAreasCombo(BUsuario.getIdArea()));
            __jsp_taghandler_3.setName("usuarioArea");
            __jsp_taghandler_3.setSize(1);
            __jsp_taghandler_3.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_3.setClassHtml("blue600a");
            __jsp_taghandler_3.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='usuarios1()'");
            __jsp_taghandler_3.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
            __jsp_taghandler_3.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
            if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
          }
          out.write(__oracle_jsp_text[82]);
          } 
          out.write(__oracle_jsp_text[83]);
           }else{ 
          out.write(__oracle_jsp_text[84]);
           if (Ejemplo.length>0 ){ 
          out.write(__oracle_jsp_text[85]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_4=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_4.setParent(null);
            __jsp_taghandler_4.setData(ComboData.getAreasComboAll());
            __jsp_taghandler_4.setName("usuarioArea20");
            __jsp_taghandler_4.setSize(1);
            __jsp_taghandler_4.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_4.setClassHtml("blue600a");
            __jsp_taghandler_4.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='usuarios1()' disabled = 'true' ");
            __jsp_taghandler_4.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
            __jsp_taghandler_4.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
            if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
          }
          out.write(__oracle_jsp_text[86]);
          out.print(strIdArea);
          out.write(__oracle_jsp_text[87]);
          }else { 
          out.write(__oracle_jsp_text[88]);
          {
            com.meve.sigma.taglib.CreaCombo __jsp_taghandler_5=(com.meve.sigma.taglib.CreaCombo)OracleJspRuntime.getTagHandler(pageContext,com.meve.sigma.taglib.CreaCombo.class,"com.meve.sigma.taglib.CreaCombo data name size selected classHtml script textoNoSeleccion valorNoSeleccion");
            __jsp_taghandler_5.setParent(null);
            __jsp_taghandler_5.setData(ComboData.getAreasComboAll());
            __jsp_taghandler_5.setName("usuarioArea");
            __jsp_taghandler_5.setSize(1);
            __jsp_taghandler_5.setSelected(OracleJspRuntime.toStr( strIdArea));
            __jsp_taghandler_5.setClassHtml("blue600a");
            __jsp_taghandler_5.setScript("onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='usuarios1()' ");
            __jsp_taghandler_5.setTextoNoSeleccion(" ------------ Selecciona una Unidad Administrativa ------------ ");
            __jsp_taghandler_5.setValorNoSeleccion("-1");
            __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
            if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
          }
          out.write(__oracle_jsp_text[89]);
          } 
          out.write(__oracle_jsp_text[90]);
           } 
          out.write(__oracle_jsp_text[91]);
          if (valida == 1) {
          out.write(__oracle_jsp_text[92]);
          } 
          out.write(__oracle_jsp_text[93]);
          out.print(strUsuario);
          out.write(__oracle_jsp_text[94]);
          if (valida2 == 1) {
          out.write(__oracle_jsp_text[95]);
          } 
          out.write(__oracle_jsp_text[96]);
          out.print(strCargo);
          out.write(__oracle_jsp_text[97]);
          out.print(  (strUsuario!=null)?strCorreo:"" );
          out.write(__oracle_jsp_text[98]);
          out.print(strTelefono);
          out.write(__oracle_jsp_text[99]);
          out.print(strConsecutivo);
          out.write(__oracle_jsp_text[100]);
           if(BUsuario.getSupervisor()){ 
          out.write(__oracle_jsp_text[101]);
           if(strIdArea.length() > 0 && !strIdArea.equals("-1")){ 
          out.write(__oracle_jsp_text[102]);
          
          				String strDelArea[][] = ComboData.getUsuarioCombo(BUsuario.getIdArea());
          				String strIdPadre = ActualizaArea.getIdArePadre(strIdArea);
          				String stridPadres[][] = new String[0][1];
          				if(strIdPadre.length() > 0){
          					stridPadres = ComboData.getUsuarioResponsable(strIdPadre);
          				}
          				else{
          					stridPadres = new String[0][1];
          				}
          			
          out.write(__oracle_jsp_text[103]);
          
          				for(int i=0;i<stridPadres.length;i++){
          					if(!strIdUsuario.equals(stridPadres[i][0])){
          						boolean bJefe = true;
          						for (int k=0; k<vSubalternos.size(); k++){
          							if(stridPadres[i][0].equals((String)vSubalternos.get(k))){
          								bJefe = false;
          							}
          						}
          						if (bJefe){ 
          			
          out.write(__oracle_jsp_text[104]);
          out.print(stridPadres[i][0]);
          out.write(__oracle_jsp_text[105]);
          out.print((strIdJefe.trim().equals(stridPadres[i][0])?"selected":""));
          out.write(__oracle_jsp_text[106]);
          out.print(stridPadres[i][1]);
          out.write(__oracle_jsp_text[107]);
          			
          						}
          					}
          				}
          			
          out.write(__oracle_jsp_text[108]);
          
          				for(int i=0;i<strDelArea.length;i++){
          					if(!strIdUsuario.equals(strDelArea[i][0])){
          						boolean bJefe = true;
          						for (int k=0; k<vSubalternos.size(); k++){
          							if(strDelArea[i][0].equals((String)vSubalternos.get(k))){
          								bJefe = false;
          							}
          						}
          						if (bJefe){ 
          			
          out.write(__oracle_jsp_text[109]);
          out.print(strDelArea[i][0]);
          out.write(__oracle_jsp_text[110]);
          out.print((strIdJefe.trim().equals(strDelArea[i][0])?"selected":""));
          out.write(__oracle_jsp_text[111]);
          out.print(strDelArea[i][1]);
          out.write(__oracle_jsp_text[112]);
          		
          						}
          					}
          				}
          			
          out.write(__oracle_jsp_text[113]);
           }else{ 
          out.write(__oracle_jsp_text[114]);
          }
          out.write(__oracle_jsp_text[115]);
           }else{ 
          out.write(__oracle_jsp_text[116]);
           if(strIdArea.length() > 0 && !strIdArea.equals("-1")){ 
          out.write(__oracle_jsp_text[117]);
          
          				String strDelArea[][] = ComboData.getUsuarioCombo(strIdArea);//Todos los usuarios del area
          				String strIdPadre = ActualizaArea.getIdArePadre(strIdArea);//id del ua padre
          				String stridPadres[][] = new String[0][1];
          				if(strIdPadre.length() > 0){
          					stridPadres = ComboData.getUsuarioResponsable(strIdPadre);
          				}
          			
          out.write(__oracle_jsp_text[118]);
          
          				for(int i=0;i<stridPadres.length;i++){
          					if(!strIdUsuario.equals(stridPadres[i][0])){
          						boolean bJefe = true;
          						for (int k=0; k<vSubalternos.size(); k++){
          							if(stridPadres[i][0].equals((String)vSubalternos.get(k))){
          								bJefe = false;
          							}
          						}
          						if (bJefe){ 
          			
          out.write(__oracle_jsp_text[119]);
          out.print(stridPadres[i][0]);
          out.write(__oracle_jsp_text[120]);
          out.print((strIdJefe.trim().equals(stridPadres[i][0])?"selected":""));
          out.write(__oracle_jsp_text[121]);
          out.print(stridPadres[i][1]);
          out.write(__oracle_jsp_text[122]);
          
          						}
          					}
          				}
          			
          out.write(__oracle_jsp_text[123]);
          
          				for(int i=0;i<strDelArea.length;i++){
          					if(!strIdUsuario.equals(strDelArea[i][0])){
          						boolean bJefe = true;
          						for (int k=0; k<vSubalternos.size(); k++){
          							if(strDelArea[i][0].equals((String)vSubalternos.get(k))){
          								bJefe = false;
          							}
          						}
          						if (bJefe){
          			
          out.write(__oracle_jsp_text[124]);
          out.print(strDelArea[i][0]);
          out.write(__oracle_jsp_text[125]);
          out.print((strIdJefe.trim().equals(strDelArea[i][0])?"selected":""));
          out.write(__oracle_jsp_text[126]);
          out.print(strDelArea[i][1]);
          out.write(__oracle_jsp_text[127]);
          		
          						}
          					}
          				}
          			
          out.write(__oracle_jsp_text[128]);
           }else{ 
          out.write(__oracle_jsp_text[129]);
           } 
          out.write(__oracle_jsp_text[130]);
           } 
          out.write(__oracle_jsp_text[131]);
          out.print(Jefe );
          out.write(__oracle_jsp_text[132]);
           if(BUsuario.getSupervisor()){ 
          out.write(__oracle_jsp_text[133]);
          out.write(__oracle_jsp_text[134]);
          String[][] asistentes = ComboData.getUsuarioAsistente(BUsuario.getIdArea());
                                   request.setAttribute("asistentes",asistentes);
                                   request.setAttribute("asistentesAsigandos",strIdAsistente);
                                   
                                  
          out.write(__oracle_jsp_text[135]);
          {
            org.apache.taglibs.standard.tag.rt.core.ForEachTag __jsp_taghandler_6=(org.apache.taglibs.standard.tag.rt.core.ForEachTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.ForEachTag.class,"org.apache.taglibs.standard.tag.rt.core.ForEachTag items var");
            __jsp_taghandler_6.setParent(null);
            __jsp_taghandler_6.setItems((java.lang.Object)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asistentes}",java.lang.Object.class, __ojsp_varRes,null));
            __jsp_taghandler_6.setVar("registro");
            try {
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[136]);
                  {
                    org.apache.taglibs.standard.tag.rt.core.SetTag __jsp_taghandler_7=(org.apache.taglibs.standard.tag.rt.core.SetTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.SetTag.class,"org.apache.taglibs.standard.tag.rt.core.SetTag var value");
                    __jsp_taghandler_7.setParent(__jsp_taghandler_6);
                    __jsp_taghandler_7.setVar("seleccion");
                    __jsp_taghandler_7.setValue(" ");
                    __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
                    if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
                  }
                  out.write(__oracle_jsp_text[137]);
                  {
                    org.apache.taglibs.standard.tag.rt.core.ForEachTag __jsp_taghandler_8=(org.apache.taglibs.standard.tag.rt.core.ForEachTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.ForEachTag.class,"org.apache.taglibs.standard.tag.rt.core.ForEachTag items var");
                    __jsp_taghandler_8.setParent(__jsp_taghandler_6);
                    __jsp_taghandler_8.setItems((java.lang.Object)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asistentesAsigandos}",java.lang.Object.class, __ojsp_varRes,null));
                    __jsp_taghandler_8.setVar("registroAsigando");
                    try {
                      __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                      {
                        do {
                          out.write(__oracle_jsp_text[138]);
                          {
                            org.apache.taglibs.standard.tag.rt.core.IfTag __jsp_taghandler_9=(org.apache.taglibs.standard.tag.rt.core.IfTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.IfTag.class,"org.apache.taglibs.standard.tag.rt.core.IfTag test");
                            __jsp_taghandler_9.setParent(__jsp_taghandler_8);
                            __jsp_taghandler_9.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro[0] == registroAsigando}",java.lang.Boolean.class, __ojsp_varRes,null)));
                            __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
                            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                            {
                              do {
                                out.write(__oracle_jsp_text[139]);
                                {
                                  org.apache.taglibs.standard.tag.rt.core.SetTag __jsp_taghandler_10=(org.apache.taglibs.standard.tag.rt.core.SetTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.SetTag.class,"org.apache.taglibs.standard.tag.rt.core.SetTag var value");
                                  __jsp_taghandler_10.setParent(__jsp_taghandler_9);
                                  __jsp_taghandler_10.setVar("seleccion");
                                  __jsp_taghandler_10.setValue("checked");
                                  __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
                                  if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                    return;
                                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,4);
                                }
                                out.write(__oracle_jsp_text[140]);
                              } while (__jsp_taghandler_9.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            }
                            if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                              return;
                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,3);
                          }
                          out.write(__oracle_jsp_text[141]);
                        } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      }
                      if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                    } catch (Throwable th) {
                      __jsp_taghandler_8.doCatch(th);
                    } finally {
                      __jsp_taghandler_8.doFinally();
                    }
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
                  }
                  out.write(__oracle_jsp_text[142]);
                  {
                    org.apache.taglibs.standard.tag.rt.core.OutTag __jsp_taghandler_11=(org.apache.taglibs.standard.tag.rt.core.OutTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.OutTag.class,"org.apache.taglibs.standard.tag.rt.core.OutTag value");
                    __jsp_taghandler_11.setParent(__jsp_taghandler_6);
                    __jsp_taghandler_11.setValue((java.lang.Object)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro[0]}",java.lang.Object.class, __ojsp_varRes,null));
                    __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
                    if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
                  }
                  out.write(__oracle_jsp_text[143]);
                  out.print( HabComboAsistente?"disabled":"" );
                  out.write(__oracle_jsp_text[144]);
                  {
                    org.apache.taglibs.standard.tag.rt.core.OutTag __jsp_taghandler_12=(org.apache.taglibs.standard.tag.rt.core.OutTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.OutTag.class,"org.apache.taglibs.standard.tag.rt.core.OutTag value");
                    __jsp_taghandler_12.setParent(__jsp_taghandler_6);
                    __jsp_taghandler_12.setValue((java.lang.Object)oracle.jsp.runtime.OracleJspRuntime.evaluate("${seleccion}",java.lang.Object.class, __ojsp_varRes,null));
                    __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                    if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
                  }
                  out.write(__oracle_jsp_text[145]);
                  {
                    org.apache.taglibs.standard.tag.rt.core.OutTag __jsp_taghandler_13=(org.apache.taglibs.standard.tag.rt.core.OutTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.OutTag.class,"org.apache.taglibs.standard.tag.rt.core.OutTag value");
                    __jsp_taghandler_13.setParent(__jsp_taghandler_6);
                    __jsp_taghandler_13.setValue((java.lang.Object)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro[1]}",java.lang.Object.class, __ojsp_varRes,null));
                    __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
                    if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
                  }
                  out.write(__oracle_jsp_text[146]);
                } while (__jsp_taghandler_6.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
            } catch (Throwable th) {
              __jsp_taghandler_6.doCatch(th);
            } finally {
              __jsp_taghandler_6.doFinally();
            }
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
          }
          out.write(__oracle_jsp_text[147]);
           }else{ 
          out.write(__oracle_jsp_text[148]);
           if(strIdArea.length() > 0 && !strIdArea.equals("-1")){ 
          out.write(__oracle_jsp_text[149]);
          out.write(__oracle_jsp_text[150]);
          String[][] asistentes = ComboData.getUsuarioAsistente(strIdArea);
                                   request.setAttribute("asistentes",asistentes);
                                   request.setAttribute("asistentesAsigandos",strIdAsistente);
          out.write(__oracle_jsp_text[151]);
          {
            org.apache.taglibs.standard.tag.rt.core.ForEachTag __jsp_taghandler_14=(org.apache.taglibs.standard.tag.rt.core.ForEachTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.ForEachTag.class,"org.apache.taglibs.standard.tag.rt.core.ForEachTag items var");
            __jsp_taghandler_14.setParent(null);
            __jsp_taghandler_14.setItems((java.lang.Object)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asistentes}",java.lang.Object.class, __ojsp_varRes,null));
            __jsp_taghandler_14.setVar("registro");
            try {
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
              {
                do {
                  out.write(__oracle_jsp_text[152]);
                  {
                    org.apache.taglibs.standard.tag.rt.core.SetTag __jsp_taghandler_15=(org.apache.taglibs.standard.tag.rt.core.SetTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.SetTag.class,"org.apache.taglibs.standard.tag.rt.core.SetTag var value");
                    __jsp_taghandler_15.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_15.setVar("seleccion");
                    __jsp_taghandler_15.setValue(" ");
                    __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                    if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
                  }
                  out.write(__oracle_jsp_text[153]);
                  {
                    org.apache.taglibs.standard.tag.rt.core.ForEachTag __jsp_taghandler_16=(org.apache.taglibs.standard.tag.rt.core.ForEachTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.ForEachTag.class,"org.apache.taglibs.standard.tag.rt.core.ForEachTag items var");
                    __jsp_taghandler_16.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_16.setItems((java.lang.Object)oracle.jsp.runtime.OracleJspRuntime.evaluate("${asistentesAsigandos}",java.lang.Object.class, __ojsp_varRes,null));
                    __jsp_taghandler_16.setVar("registroAsigando");
                    try {
                      __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                      if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                      {
                        do {
                          out.write(__oracle_jsp_text[154]);
                          {
                            org.apache.taglibs.standard.tag.rt.core.IfTag __jsp_taghandler_17=(org.apache.taglibs.standard.tag.rt.core.IfTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.IfTag.class,"org.apache.taglibs.standard.tag.rt.core.IfTag test");
                            __jsp_taghandler_17.setParent(__jsp_taghandler_16);
                            __jsp_taghandler_17.setTest(OracleJspRuntime.toBoolean( (java.lang.Boolean)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro[0] == registroAsigando}",java.lang.Boolean.class, __ojsp_varRes,null)));
                            __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
                            if (OracleJspRuntime.checkStartTagEval(__jsp_tag_starteval))
                            {
                              do {
                                out.write(__oracle_jsp_text[155]);
                                {
                                  org.apache.taglibs.standard.tag.rt.core.SetTag __jsp_taghandler_18=(org.apache.taglibs.standard.tag.rt.core.SetTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.SetTag.class,"org.apache.taglibs.standard.tag.rt.core.SetTag var value");
                                  __jsp_taghandler_18.setParent(__jsp_taghandler_17);
                                  __jsp_taghandler_18.setVar("seleccion");
                                  __jsp_taghandler_18.setValue("checked");
                                  __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                                  if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                    return;
                                  OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,4);
                                }
                                out.write(__oracle_jsp_text[156]);
                              } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            }
                            if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                              return;
                            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,3);
                          }
                          out.write(__oracle_jsp_text[157]);
                        } while (__jsp_taghandler_16.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      }
                      if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                    } catch (Throwable th) {
                      __jsp_taghandler_16.doCatch(th);
                    } finally {
                      __jsp_taghandler_16.doFinally();
                    }
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
                  }
                  out.write(__oracle_jsp_text[158]);
                  {
                    org.apache.taglibs.standard.tag.rt.core.OutTag __jsp_taghandler_19=(org.apache.taglibs.standard.tag.rt.core.OutTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.OutTag.class,"org.apache.taglibs.standard.tag.rt.core.OutTag value");
                    __jsp_taghandler_19.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_19.setValue((java.lang.Object)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro[0]}",java.lang.Object.class, __ojsp_varRes,null));
                    __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                    if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,2);
                  }
                  out.write(__oracle_jsp_text[159]);
                  out.print( HabComboAsistente?"disabled":"" );
                  out.write(__oracle_jsp_text[160]);
                  {
                    org.apache.taglibs.standard.tag.rt.core.OutTag __jsp_taghandler_20=(org.apache.taglibs.standard.tag.rt.core.OutTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.OutTag.class,"org.apache.taglibs.standard.tag.rt.core.OutTag value");
                    __jsp_taghandler_20.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_20.setValue((java.lang.Object)oracle.jsp.runtime.OracleJspRuntime.evaluate("${seleccion}",java.lang.Object.class, __ojsp_varRes,null));
                    __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
                    if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
                  }
                  out.write(__oracle_jsp_text[161]);
                  {
                    org.apache.taglibs.standard.tag.rt.core.OutTag __jsp_taghandler_21=(org.apache.taglibs.standard.tag.rt.core.OutTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.taglibs.standard.tag.rt.core.OutTag.class,"org.apache.taglibs.standard.tag.rt.core.OutTag value");
                    __jsp_taghandler_21.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_21.setValue((java.lang.Object)oracle.jsp.runtime.OracleJspRuntime.evaluate("${registro[1]}",java.lang.Object.class, __ojsp_varRes,null));
                    __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                    if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,2);
                  }
                  out.write(__oracle_jsp_text[162]);
                } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
            } catch (Throwable th) {
              __jsp_taghandler_14.doCatch(th);
            } finally {
              __jsp_taghandler_14.doFinally();
            }
            OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,1);
          }
          out.write(__oracle_jsp_text[163]);
           }else{ 
          out.write(__oracle_jsp_text[164]);
          out.print( HabComboAsistente?"disabled=\"disabled\"":"" );
          out.write(__oracle_jsp_text[165]);
           } 
          out.write(__oracle_jsp_text[166]);
           } 
          out.write(__oracle_jsp_text[167]);
           if(strIdUsuario.length() != 0){ 
          out.write(__oracle_jsp_text[168]);
          out.print((strActivo.equals("0")?"selected":""));
          out.write(__oracle_jsp_text[169]);
          out.print((strActivo.equals("1")?"selected":""));
          out.write(__oracle_jsp_text[170]);
           } 
          out.write(__oracle_jsp_text[171]);
          out.print((strDesExt.equals("1")?"checked":""));
          out.write(__oracle_jsp_text[172]);
          
          	if(strIdArea.length()!=0 && !strIdArea.equals("-1")){
          		String strSub = ActualizaArea.getSubventanilla(strIdArea);
          	
          out.write(__oracle_jsp_text[173]);
          if(strSub.equals("0")){
          out.write(__oracle_jsp_text[174]);
          out.print(ActualizaUsuario.getComboAtencion(strIdArea, strSubVent));
          out.write(__oracle_jsp_text[175]);
          }else{
          out.write(__oracle_jsp_text[176]);
          }
          out.write(__oracle_jsp_text[177]);
          }else{
          out.write(__oracle_jsp_text[178]);
          }
          out.write(__oracle_jsp_text[179]);
           if(BUsuario.getSupervisor()){ 
          out.write(__oracle_jsp_text[180]);
          out.print((admon.trim().equals("0")?"checked":""));
          out.write(__oracle_jsp_text[181]);
           }else{ 
          out.write(__oracle_jsp_text[182]);
          out.print((admon.trim().equals("0")?"checked":""));
          out.write(__oracle_jsp_text[183]);
           } 
          out.write(__oracle_jsp_text[184]);
          out.print((atencion.trim().equals("1")?"checked":""));
          out.write(__oracle_jsp_text[185]);
          out.print((recepcion.trim().equals("3")?"checked":""));
          out.write(__oracle_jsp_text[186]);
          out.print((gestion.trim().equals("2")?"checked":""));
          out.write(__oracle_jsp_text[187]);
          out.print((supervisor.trim().equals("4")?"checked":""));
          out.write(__oracle_jsp_text[188]);
          out.print((turnado.trim().equals("5")?"checked":""));
          out.write(__oracle_jsp_text[189]);
          out.print((asistente.trim().equals("6")?"checked":""));
          out.write(__oracle_jsp_text[190]);
          out.print((a.trim().equals("0")?"checked":""));
          out.write(__oracle_jsp_text[191]);
          out.print((b.trim().equals("1")?"checked":""));
          out.write(__oracle_jsp_text[192]);
          out.print((c.trim().equals("2")?"checked":""));
          out.write(__oracle_jsp_text[193]);
          out.print((d.trim().equals("3")?"checked":""));
          out.write(__oracle_jsp_text[194]);
          out.print((e.trim().equals("4")?"checked":""));
          out.write(__oracle_jsp_text[195]);
          out.print((t.trim().equals("5")?"checked":""));
          out.write(__oracle_jsp_text[196]);
          out.print((g.trim().equals("6")?"checked":""));
          out.write(__oracle_jsp_text[197]);
          out.print((h.trim().equals("7")?"checked":""));
          out.write(__oracle_jsp_text[198]);
          out.print((z.trim().equals("8")?"checked":""));
          out.write(__oracle_jsp_text[199]);
          if(strIdUsuario.length()!=0){
          out.write(__oracle_jsp_text[200]);
          out.print((notificacion.trim().equals("0")?"checked":""));
          out.write(__oracle_jsp_text[201]);
          }else{
          out.write(__oracle_jsp_text[202]);
          }
          out.write(__oracle_jsp_text[203]);
          if(BUsuario.getAdmon()){
          out.write(__oracle_jsp_text[204]);
          out.print((catArch.trim().equals("1")?"checked":""));
          out.write(__oracle_jsp_text[205]);
          }else{
          out.write(__oracle_jsp_text[206]);
          if(strIdUsuario.length()==0){
          out.write(__oracle_jsp_text[207]);
          if(BUsuario.getCatArchivado().equals("1")){
          out.write(__oracle_jsp_text[208]);
          out.print((catArch.trim().equals("1")?"checked":""));
          out.write(__oracle_jsp_text[209]);
          }else{
          out.write(__oracle_jsp_text[210]);
          out.print((catArch.trim().equals("1")?"checked":""));
          out.write(__oracle_jsp_text[211]);
          }
          out.write(__oracle_jsp_text[212]);
          }else{
          out.write(__oracle_jsp_text[213]);
          if(BUsuario.getIdUsuario().equals(strIdUsuario)){
          out.write(__oracle_jsp_text[214]);
          out.print((catArch.trim().equals("1")?"checked":""));
          out.write(__oracle_jsp_text[215]);
          out.print(catArch);
          out.write(__oracle_jsp_text[216]);
          }else if(BUsuario.getCatArchivado().equals("1")){
          out.write(__oracle_jsp_text[217]);
          out.print((catArch.trim().equals("1")?"checked":""));
          out.write(__oracle_jsp_text[218]);
          }else{
          out.write(__oracle_jsp_text[219]);
          out.print((catArch.trim().equals("1")?"checked":""));
          out.write(__oracle_jsp_text[220]);
          }
          out.write(__oracle_jsp_text[221]);
          }
          out.write(__oracle_jsp_text[222]);
          }
          out.write(__oracle_jsp_text[223]);
           if(strIdUsuario.length() != 0){ 
          out.write(__oracle_jsp_text[224]);
          out.print(strIdUsuario);
          out.write(__oracle_jsp_text[225]);
          out.print(Utilerias.codificaPostHTML(strTmp+"?id_usuario="+strIdUsuario+"&accion=consultar&retURI="+ Utilerias.codificaPostHTML(retURI)));
          out.write(__oracle_jsp_text[226]);
           } 
          out.write(__oracle_jsp_text[227]);
          if (bExisteUsuario && strAccion != null && (strAccion.equals("cambiar") || strAccion.equals("guardar"))) {
          out.write(__oracle_jsp_text[228]);
          out.print( ActualizaUsuario.getJSUsuarioArea(strUID));
          out.write(__oracle_jsp_text[229]);
          } 
          out.write(__oracle_jsp_text[230]);
        }
      }

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
  private static final char __oracle_jsp_text[][]=new char[231][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n".toCharArray();
    __oracle_jsp_text[3] = 
    "\n<HTML> \n<HEAD>\n<TITLE>Puestos</TITLE>\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[5] = 
    " \n".toCharArray();
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
    "\n<!-- Se hace una instancia al Bean del usuario para la Sesión -->\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n".toCharArray();
    __oracle_jsp_text[16] = 
    "\n".toCharArray();
    __oracle_jsp_text[17] = 
    "\n<!-- Fin bloque Sesión -->\n".toCharArray();
    __oracle_jsp_text[18] = 
    "\n".toCharArray();
    __oracle_jsp_text[19] = 
    "\n".toCharArray();
    __oracle_jsp_text[20] = 
    "\n".toCharArray();
    __oracle_jsp_text[21] = 
    "\n".toCharArray();
    __oracle_jsp_text[22] = 
    "\n".toCharArray();
    __oracle_jsp_text[23] = 
    "\n".toCharArray();
    __oracle_jsp_text[24] = 
    "\n\n".toCharArray();
    __oracle_jsp_text[25] = 
    "\n".toCharArray();
    __oracle_jsp_text[26] = 
    "\n".toCharArray();
    __oracle_jsp_text[27] = 
    "\n".toCharArray();
    __oracle_jsp_text[28] = 
    "\n".toCharArray();
    __oracle_jsp_text[29] = 
    "\n<LINK href=\"../theme/Master.css\" rel=\"stylesheet\" type=\"text/css\">\n<LINK href=\"../css/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\n<STYLE type=\"text/css\">\n</STYLE>\n<SCRIPT src=\"../js/menu.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/valida.js\" type=text/javascript></SCRIPT>\n<SCRIPT src=\"../js/SigmaJS.js\" type=text/javascript></SCRIPT>\n<SCRIPT language=JavaScript type=text/javascript>\n\n\n\tfunction onloadRoles(){\n\t\n\t\tdoc = document.usuarioForm;\n\t\tif(doc.id_usuario.value != \"\")\n\t\t{\n\t\t\tvar admon = ".toCharArray();
    __oracle_jsp_text[30] = 
    ";\n\t\t\tvar asistente = ".toCharArray();
    __oracle_jsp_text[31] = 
    ";\n\t\t\tif(admon == 0){\n\t\t\t\tdoc.usuarioRol[1].disabled = true;\n\t\t\t\tdoc.usuarioRol[2].disabled = true;\n\t\t\t\tdoc.usuarioRol[3].disabled = true;\n\t\t\t\tdoc.usuarioRol[4].disabled = true;\n\t\t\t\tdoc.usuarioRol[5].disabled = true;\n\t\t\t\tdoc.usuarioRol[6].disabled = true;\n\t\t\t\t\n\t\t\t}\n\t\t\tif(asistente==6){\n\t\t\t\tdoc.usuarioRol[0].disabled = true;\n\t\t\t\tdoc.usuarioRol[1].disabled = true;\n\t\t\t\tdoc.usuarioRol[2].disabled = true;\n\t\t\t\tdoc.usuarioRol[4].disabled = true;\n\t\t\t\tdoc.usuarioRol[5].disabled = true;\n\t\t\t}\n\t\t}\n\t}\n\tfunction usuarios1() {\n\t\tdoc = document.usuarioForm;\n\t\tdoc.submit();\n\t}\n\n\tfunction referenciaRet(retURI){\n\t\tlocation.assign(retURI.value);\n\t}\n\n</SCRIPT>\n<STYLE type=text/css>BODY {\n\tMARGIN: 0px\n} \n</STYLE>\n</HEAD>\n<BODY onload=\"valida=0;timer_load();onloadRoles();selRecepcionCorreo();selAdminCorreo();\n\t\tselAtencionCorreo();selTurnadoCorreo();selectConfigCorreo();\" background=\"../Imagenes/fondo_claro.jpg\"\n\tonKeyPress=\"timer_reload();\" \n\tonClick=\"timer_reload();\">\n<FORM action=\"Usuarios.jsp\" name=\"usuarioForm\" method=\"post\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[32] = 
    "\" name=\"accionTemp\">\n<INPUT type=\"hidden\" value=\"\" name=\"accion\">\n<INPUT type=\"hidden\" name=\"id_usuario\" value=\"".toCharArray();
    __oracle_jsp_text[33] = 
    "\">\n<INPUT type=\"hidden\" name=\"usuario_duplicado\" value=\"\">\n<INPUT type=\"hidden\" name=\"admon\" value=\"".toCharArray();
    __oracle_jsp_text[34] = 
    "\">\n<INPUT type=\"hidden\" name=\"atencion\" value=\"".toCharArray();
    __oracle_jsp_text[35] = 
    "\">\n<INPUT type=\"hidden\" name=\"gestion\" value=\"".toCharArray();
    __oracle_jsp_text[36] = 
    "\">\n<INPUT type=\"hidden\" name=\"recepcion\" value=\"".toCharArray();
    __oracle_jsp_text[37] = 
    "\">\n<INPUT type=\"hidden\" name=\"supervisor\" value=\"".toCharArray();
    __oracle_jsp_text[38] = 
    "\">\n<INPUT type=\"hidden\" name=\"turnado\" value=\"".toCharArray();
    __oracle_jsp_text[39] = 
    "\">\n<INPUT type=\"hidden\" name=\"asistente\" value=\"".toCharArray();
    __oracle_jsp_text[40] = 
    "\">\n<INPUT type=\"hidden\" name=\"nuevoAsunto\" value=\"".toCharArray();
    __oracle_jsp_text[41] = 
    "\">\n<INPUT type=\"hidden\" name=\"turnar\" value=\"".toCharArray();
    __oracle_jsp_text[42] = 
    "\">\n<INPUT type=\"hidden\" name=\"responder\" value=\"".toCharArray();
    __oracle_jsp_text[43] = 
    "\">\n<INPUT type=\"hidden\" name=\"rechazar\" value=\"".toCharArray();
    __oracle_jsp_text[44] = 
    "\">\n<INPUT type=\"hidden\" name=\"delegar\" value=\"".toCharArray();
    __oracle_jsp_text[45] = 
    "\">\n<INPUT type=\"hidden\" name=\"reasignar\" value=\"".toCharArray();
    __oracle_jsp_text[46] = 
    "\">\n<INPUT type=\"hidden\" name=\"habilitar\" value=\"".toCharArray();
    __oracle_jsp_text[47] = 
    "\">\n<INPUT type=\"hidden\" name=\"solicitudCambio\" value=\"".toCharArray();
    __oracle_jsp_text[48] = 
    "\">\n<INPUT type=\"hidden\" name=\"respuestaCambio\" value=\"".toCharArray();
    __oracle_jsp_text[49] = 
    "\">\n<INPUT type=\"hidden\" name=\"catArch1\" value=\"".toCharArray();
    __oracle_jsp_text[50] = 
    "\">\n<INPUT type=\"hidden\" name=\"not1\" value=\"".toCharArray();
    __oracle_jsp_text[51] = 
    "\">\n<INPUT type=\"hidden\" name=\"usuarioRol1\" value=\"".toCharArray();
    __oracle_jsp_text[52] = 
    "\">\n<INPUT type=\"hidden\" name=\"usuarioConfMails1\" value=\"".toCharArray();
    __oracle_jsp_text[53] = 
    "\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[54] = 
    "\" name=\"aux\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[55] = 
    "\" name=\"aux2\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[56] = 
    "\" name=\"aux3\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[57] = 
    "\" name=\"aux4\">\n<INPUT type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[58] = 
    "\" name=\"retURI\">\n\n".toCharArray();
    __oracle_jsp_text[59] = 
    "\n<INPUT type=\"hidden\" name=\"uid\" value=\"".toCharArray();
    __oracle_jsp_text[60] = 
    "\">\n".toCharArray();
    __oracle_jsp_text[61] = 
    "\n<DIV align=\"center\">\n<BR>\n<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"125\">\n\t\t\t\t<a onClick=\"referenciaRet(document.usuarioForm.retURI);\">\n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/NavLeft.gif\" alt=\"Regresar\" ></a>\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<a onclick=\"guardarUsuario();\"> \n\t\t\t\t<IMG border=\"0\" src=\"../Imagenes/Save.gif\" alt=\"Guardar\"></a>\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">\n\t\t\t</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"125\">&nbsp;</TD>\n\t\t\t<TD width=\"142\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n</DIV>\n<DIV align=\"center\">\n\n</DIV>\n<br><DIV class=documentBody id=Body>\n<!-- tag para los campos de username y password -->\n".toCharArray();
    __oracle_jsp_text[62] = 
    "\n<DIV align=\"center\">\n<TABLE width=\"820\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"50%\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Registro de Puesto</FONT></B></TD>\n\t\t\t<TD width=\"50%\" align=\"right\" >**Los datos marcados con negritas son obligatorios&nbsp;<FONT face=\"Verdana\" size=\"2\"><I></I></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD align=\"right\" colspan=\"2\"><FONT face=\"Verdana\" size=\"2\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[63] = 
    "<I>".toCharArray();
    __oracle_jsp_text[64] = 
    " - ".toCharArray();
    __oracle_jsp_text[65] = 
    "</I></FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"531\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Usuario:</B></FONT><BR>\n\t\t</TD>\n\t\t<TD width=\"531\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\" \n\t\t\ttype=\"text\" name=\"uid\" class=\"blue600a\" value=\"".toCharArray();
    __oracle_jsp_text[66] = 
    "\" maxlength=\"20\"></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\"> \n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"531\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Contraseña:</B></FONT></TD>\n\t\t<TD width=\"531\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\"\n\t\t\ttype=\"password\" name=\"usuarioPassword\" class=\"blue600a\" value=\"".toCharArray();
    __oracle_jsp_text[67] = 
    "\" maxlength=\"15\"></FONT>\n\t\t<INPUT name=\"controlUSR\" type=\"hidden\" value=\"1\"></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"531\">&nbsp;</TD>\n\t</TR>\n</table>\n</DIV>\n".toCharArray();
    __oracle_jsp_text[68] = 
    "\n<DIV align=\"center\">\n<TABLE width=\"820\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD width=\"50%\"><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Registro de Puesto</FONT></B></TD>\n\t\t\t<TD width=\"50%\" align=\"right\">**Los datos marcados con negritas son obligatorios&nbsp;<FONT face=\"Verdana\" size=\"2\"><I></I></FONT></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\" bgcolor=\"#004080\">\n\t\t\t<TD colspan=\"2\"></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD colspan=\"2\" align=\"right\"><FONT face=\"Verdana\" size=\"2\">Creado\n\t\t\tpor: <I>".toCharArray();
    __oracle_jsp_text[69] = 
    " - ".toCharArray();
    __oracle_jsp_text[70] = 
    "</I></FONT></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"531\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Usuario:</B></FONT><BR>\n       </TD>\n\t\t<TD width=\"531\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\"\n\t\t\ttype=\"text\" name=\"uid\" class=\"blue600a\" value=\"".toCharArray();
    __oracle_jsp_text[71] = 
    "\" maxlength=\"20\"></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\"> \n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"531\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Contraseña:</B></FONT></TD>\n\t\t<TD width=\"531\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\"\n\t\t\ttype=\"password\" name=\"usuarioPassword\" class=\"blue600a\" value=\"".toCharArray();
    __oracle_jsp_text[72] = 
    "\" maxlength=\"15\"></FONT>\n\t\t<INPUT name=\"controlUSR\" type=\"hidden\" value=\"1\"></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"531\">&nbsp;</TD>\n\t</TR>\n</table>\n</DIV>\n\n<INPUT name=\"controlUSR\" type=\"hidden\" value=\"0\">\n".toCharArray();
    __oracle_jsp_text[73] = 
    "\n<!-- fin tag para los campos de username y password -->\n<DIV align=\"center\">\n<TABLE width=\"820\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TBODY>\n\t\t<TR valign=\"top\">\n\t\t\t<TD><B><FONT face=\"Verdana\" color=\"#00204f\" size=\"2\">Datos Personales</FONT></B></TD>\n\t\t</TR>\n\t\t<TR valign=\"top\">\n\t\t\t<TD bgcolor=\"#00204f\" ><img src=\"../Imagenes/shim.gif\" width=\"1\" height=\"2\" alt=\"\"></TD>\n\t\t</TR>\n\t</TBODY>\n</TABLE>\n<DIV align=\"center\">\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT face=\"Verdana\" size=\"2\">&nbsp;</FONT></TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[74] = 
    "\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">Buscar Datos:</FONT></TD>\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[75] = 
    " </FONT></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[76] = 
    " \n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Unidad\n\t\tAdministrativa:</B></FONT></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[77] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[78] = 
    "\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[79] = 
    "\n\t\t\t<SELECT name=\"usuarioArea\" style=\"display:none\">\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[80] = 
    "\"></OPTION>\n\t\t\t</SELECT>\n\t\t</FONT></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[81] = 
    "\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[82] = 
    "\n\t\t</FONT></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[83] = 
    "\n\n\t\t".toCharArray();
    __oracle_jsp_text[84] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[85] = 
    "\n\t\t<TD width=\"517\"><FONT SIZE=2 FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[86] = 
    "\n\t\t\t<SELECT name=\"usuarioArea\" style=\"display:none\">\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[87] = 
    "\"></OPTION>\n\t\t\t</SELECT>\n\t\t\t</FONT>\n\t\t</TD>\t\n\t\t\n\t\t".toCharArray();
    __oracle_jsp_text[88] = 
    "\n\t\t<TD width=\"517\"><FONT SIZE=2 FACE=\"Verdana\"> ".toCharArray();
    __oracle_jsp_text[89] = 
    " </FONT></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[90] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[91] = 
    "\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT face=\"Verdana\" size=\"2\" color=\"#004080\"><B>Puesto:</B></FONT>\n\t\t<BR>\n\t\t".toCharArray();
    __oracle_jsp_text[92] = 
    "<FONT color=\"red\"><B>*Este Puesto ya existe* </B></FONT>".toCharArray();
    __oracle_jsp_text[93] = 
    "</TD>\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\" maxlength=\"199\"\n\t\t\ttype=\"text\" name=\"usuarioNombre\" class=\"blue600a\" value=\"".toCharArray();
    __oracle_jsp_text[94] = 
    "\"></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Responsable:</B></FONT><BR>\n\t\t".toCharArray();
    __oracle_jsp_text[95] = 
    "<FONT color=\"red\"><B>*Este Responsable ya esta en el sistema* </B></FONT>".toCharArray();
    __oracle_jsp_text[96] = 
    "\n\t\t</TD>\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\" maxlength=\"199\"\n\t\t\ttype=\"text\" name=\"usuarioCargo\" class=\"blue600a\" value=\"".toCharArray();
    __oracle_jsp_text[97] = 
    "\"></FONT></TD>\n\t</TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Correo Electrónico:</B></FONT></TD>\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"50\"\n\t\t\ttype=\"text\" maxlength=\"199\" name=\"usuarioEmail\" class=\"blue600a\"\n\t\t\ttype=\"text\" maxlength=\"100\" name=\"usuarioEmail\" class=\"blue600a\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[98] = 
    "\"></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">Teléfono:</FONT></TD>\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> <INPUT size=\"100\" \n\t\t\ttype=\"text\" name=\"usuarioTelefono\" onkeydown=\"\" class=\"blue600a\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[99] = 
    "\" maxlength=\"199\"></FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">Consecutivo:</FONT></TD>\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> </FONT><INPUT type=\"text\"\n\t\t\tname=\"usuarioConsecutivo\" size=\"20\" class=\"blue200a\"\n\t\t\tvalue=\"".toCharArray();
    __oracle_jsp_text[100] = 
    "\" onKeyPress='AceptaSoloTeclaNumericaYPunto();' maxlength=\"5\"></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">Jefe (Puesto): </FONT></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[101] = 
    "\n\t\t\t".toCharArray();
    __oracle_jsp_text[102] = 
    "\n\t\t<TD width=\"529\">\n\t\t\t<SELECT name=\"usuarioJefe\" class=\"blue600a\"\n\t\t\t\t\tonkeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\"\n\t\t\t\t\tonclick=\"borrar_buffer()\" onchange=\"cambio1();\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[103] = 
    "\n\t\t\t\t<OPTION value=\"-1\">------------ Puesto UA Padre ------------</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[104] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[105] = 
    "\" ".toCharArray();
    __oracle_jsp_text[106] = 
    ">".toCharArray();
    __oracle_jsp_text[107] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[108] = 
    "\n\t\t\t\t<OPTION value=\"-1\">------------ Puestos UA ------------</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[109] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[110] = 
    "\" ".toCharArray();
    __oracle_jsp_text[111] = 
    ">".toCharArray();
    __oracle_jsp_text[112] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[113] = 
    "\t\t\t\n\t\t\t</SELECT>\n\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[114] = 
    "\n\t\t\t<TD width=\"517\">\n\t\t\t<SELECT class=\"blue600a\" name=\"usuarioJefe\">\n\t\t\t\t<OPTION value=\"-1\">------------ Selecciona un Jefe ------------</OPTION>\n\t\t\t</SELECT>\n\t\t\t</TD>\n\t\t\t".toCharArray();
    __oracle_jsp_text[115] = 
    "\t\n\t\t".toCharArray();
    __oracle_jsp_text[116] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[117] = 
    "\n\t\t<TD width=\"517\">\n\t\t\t<SELECT name=\"usuarioJefe\" class=\"blue500a\"\n\t\t\t\t\tonkeypress=\"buscar_op1(this)\" onblur=\"borrar_buffer()\"\n\t\t\t\t\tonclick=\"borrar_buffer()\" onchange=\"cambio1();\">\n\t\t\t".toCharArray();
    __oracle_jsp_text[118] = 
    "\n\t\t\t\t<OPTION value=\"-1\">------------ Puesto UA Padre ------------</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[119] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[120] = 
    "\" ".toCharArray();
    __oracle_jsp_text[121] = 
    ">".toCharArray();
    __oracle_jsp_text[122] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[123] = 
    "\n\t\t\t\t<OPTION value=\"-1\">------------ Puestos UA ------------</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[124] = 
    "\n\t\t\t\t<OPTION value=\"".toCharArray();
    __oracle_jsp_text[125] = 
    "\" ".toCharArray();
    __oracle_jsp_text[126] = 
    ">".toCharArray();
    __oracle_jsp_text[127] = 
    "</OPTION>\n\t\t\t".toCharArray();
    __oracle_jsp_text[128] = 
    "\t\t\t\n\t\t\t</SELECT>\n\t\t\t</TD>\n\t\t".toCharArray();
    __oracle_jsp_text[129] = 
    "\n\t\t<TD width=\"517\">\n\t\t<SELECT class=\"blue600a\" name=\"usuarioJefe\">\n\t\t\t<OPTION value=\"-1\">------------ Selecciona un Jefe ------------</OPTION>\n\t\t</SELECT>\n\t\t</TD>\n\t\t".toCharArray();
    __oracle_jsp_text[130] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[131] = 
    "\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">Nombre del Jefe:</FONT></TD>\n\t\t<TD width=\"529\">".toCharArray();
    __oracle_jsp_text[132] = 
    "</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">\n         </FONT></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[133] = 
    "\n\t\t<TD width=\"600\"><FIELDSET dir=\"ltr\">\n                    <LEGEND align=\"left\"><FONT SIZE=2 FACE=\"Verdana\"  color=\"#004080\"><B>Asistentes</B></FONT></LEGEND>\n                <FONT SIZE=2 FACE=\"Verdana\"> \n                    \n                        ".toCharArray();
    __oracle_jsp_text[134] = 
    "\n                        ".toCharArray();
    __oracle_jsp_text[135] = 
    "\n                        <table width=\"100%\">\n                        <tbody>\n                            <tr>\n                                <td width=\"100%\">\n                                    ".toCharArray();
    __oracle_jsp_text[136] = 
    "\n                                        ".toCharArray();
    __oracle_jsp_text[137] = 
    "\n                                        ".toCharArray();
    __oracle_jsp_text[138] = 
    "\n                                            ".toCharArray();
    __oracle_jsp_text[139] = 
    "\n                                                ".toCharArray();
    __oracle_jsp_text[140] = 
    "\n                                            ".toCharArray();
    __oracle_jsp_text[141] = 
    "\n                                        ".toCharArray();
    __oracle_jsp_text[142] = 
    "\n                                        <FONT SIZE=1 FACE=\"Verdana\">\n                                            <input type=\"checkbox\" \n                                                   name=\"usuarioAsistente\" \n                                                   value=\"".toCharArray();
    __oracle_jsp_text[143] = 
    "\" \n                                                   ".toCharArray();
    __oracle_jsp_text[144] = 
    " \n                                                   ".toCharArray();
    __oracle_jsp_text[145] = 
    ">".toCharArray();
    __oracle_jsp_text[146] = 
    "</input><br>\n                                        </FONT>\n                                    ".toCharArray();
    __oracle_jsp_text[147] = 
    "\n                                </td>\n                            </tr>\n                        </tbody>\n                        </table>\n                        \n                        </FONT></FIELDSET></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[148] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[149] = 
    "\n\t\t<TD width=\"600\">\n                              \t\t\t<FIELDSET dir=\"ltr\">\n\t\t\t<LEGEND align=\"left\"><FONT SIZE=2 FACE=\"Verdana\"  color=\"#004080\"><B>Asistentes</B></FONT></LEGEND>\n                <FONT SIZE=2 FACE=\"Verdana\">\n  \n                \n                        ".toCharArray();
    __oracle_jsp_text[150] = 
    " \n                        \n                        ".toCharArray();
    __oracle_jsp_text[151] = 
    "\n                         \n                        <table width=\"100%\">\n                        <tbody>\n                            <tr>\n                                <td width=\"100%\">\n                                    ".toCharArray();
    __oracle_jsp_text[152] = 
    "\n                                        ".toCharArray();
    __oracle_jsp_text[153] = 
    "\n                                        ".toCharArray();
    __oracle_jsp_text[154] = 
    "\n                                            ".toCharArray();
    __oracle_jsp_text[155] = 
    "\n                                                ".toCharArray();
    __oracle_jsp_text[156] = 
    "\n                                            ".toCharArray();
    __oracle_jsp_text[157] = 
    "\n                                        ".toCharArray();
    __oracle_jsp_text[158] = 
    "\n                                        <FONT SIZE=1 FACE=\"Verdana\">\n                                            <input type=\"checkbox\" \n                                                   name=\"usuarioAsistente\" \n                                                   value=\"".toCharArray();
    __oracle_jsp_text[159] = 
    "\" \n                                                   ".toCharArray();
    __oracle_jsp_text[160] = 
    " \n                                                   ".toCharArray();
    __oracle_jsp_text[161] = 
    ">".toCharArray();
    __oracle_jsp_text[162] = 
    "</input><br>\n                                        </FONT>\n                                    ".toCharArray();
    __oracle_jsp_text[163] = 
    "\n                                </td>\n                            </tr>\n                        </tbody>\n                        </table>\n                        \n                        </FONT></FIELDSET></TD>\n\t\t".toCharArray();
    __oracle_jsp_text[164] = 
    "\n\t\t<TD width=\"600\">\n                \t\t\t<FIELDSET dir=\"ltr\">\n\t\t\t<LEGEND align=\"left\"><FONT SIZE=2 FACE=\"Verdana\"  color=\"#004080\"><B>Asistentes</B></FONT></LEGEND>\n                        <table width=\"100%\">\n                        <tbody>\n                            <tr>\n                                <td width=\"100%\">\n                                    <SELECT class=\"blue600a\" name=\"usuarioAsistente\" ".toCharArray();
    __oracle_jsp_text[165] = 
    ">\n                                            <OPTION value=\"-1\">------------ Seleccione un Asistente ------------</OPTION>\n                                    </SELECT>\n                                </td>\n                            </tr>\n                        </tbody>\n                        </table>\n                </FIELDSET>\n\t\t</TD>\n\t\t".toCharArray();
    __oracle_jsp_text[166] = 
    "\n\t\t".toCharArray();
    __oracle_jsp_text[167] = 
    "\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[168] = 
    "\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">Usuario Activo:</FONT></TD>\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t\t<SELECT name=\"usuarioActivo\" class=\"blue100\">\n\t\t\t\t<OPTION value=\"0\" ".toCharArray();
    __oracle_jsp_text[169] = 
    ">Suspendido</OPTION>\n\t\t\t\t<OPTION value=\"1\" ".toCharArray();
    __oracle_jsp_text[170] = 
    ">Activo</OPTION>\n\t\t\t</SELECT>\n\t\t</FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[171] = 
    "\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">atención Destinatarios Externos:</FONT></TD>\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\">\n\t\t\t<INPUT type=\"checkbox\" name=\"usuarioDesExt\" value=\"1\" ".toCharArray();
    __oracle_jsp_text[172] = 
    ">Si\n\t\t</FONT></TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[173] = 
    "\n\t".toCharArray();
    __oracle_jsp_text[174] = 
    "\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\">atención SubVentanilla:</FONT></TD>\n\t\t<TD width=\"529\"><FONT SIZE=2 FACE=\"Verdana\"> \n\t\t\t<SELECT name=\"usuarioSubVent\" class=\"blue500a\" disabled>\n\t\t\t".toCharArray();
    __oracle_jsp_text[175] = 
    "\n\t\t\t</SELECT>\n\t\t</FONT></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[176] = 
    "\n\t<tr><td><input type=\"hidden\" name=\"usuarioSubVent\" value=\"0\"></td></tr>\n\t".toCharArray();
    __oracle_jsp_text[177] = 
    "\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[178] = 
    "\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\"><input type=\"hidden\" name=\"usuarioSubVent\" value=\"0\"></TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[179] = 
    "\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\">&nbsp;</FONT></TD>\n\t\t<TD width=\"600\">\n\t\t\t<FIELDSET dir=\"ltr\">\n\t\t\t<LEGEND align=\"left\"><FONT SIZE=2 FACE=\"Verdana\"  color=\"#004080\"><B>Rol\n\t\tde Usuario</B></FONT></LEGEND>\t\n\t\t\t<TABLE width=\"100%\">\n\t\t\t\t<TBODY>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"25%\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[180] = 
    "\n\t\t\t\t\t\t<INPUT value=\"0\" name=\"usuarioRol\" type=\"checkbox\" ".toCharArray();
    __oracle_jsp_text[181] = 
    " disabled=\"disabled\">Administrador\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[182] = 
    "\n\t\t\t\t\t\t<INPUT value=\"0\" name=\"usuarioRol\" type=\"checkbox\" ".toCharArray();
    __oracle_jsp_text[183] = 
    " onclick=\"desavilitarOtrosChecks();selAdminCorreo();\">Administrador\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[184] = 
    "\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"25%\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT value=\"1\" name=\"usuarioRol\" type=\"checkbox\" onclick=\"selAtencionCorreo();\" ".toCharArray();
    __oracle_jsp_text[185] = 
    ">atención\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<TD width=\"25%\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT value=\"3\" name=\"usuarioRol\" type=\"checkbox\" onclick=\"selRecepcionCorreo();\" ".toCharArray();
    __oracle_jsp_text[186] = 
    ">Recepción\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"25%\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT value=\"2\" name=\"usuarioRol\" type=\"checkbox\" onclick=\"selSCPCorreo();\" ".toCharArray();
    __oracle_jsp_text[187] = 
    ">SCP\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"25%\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT value=\"4\" name=\"usuarioRol\" type=\"checkbox\" onclick=\"selAdminCorreo();\" ".toCharArray();
    __oracle_jsp_text[188] = 
    ">Supervisor área\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"25%\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT value=\"5\" name=\"usuarioRol\" type=\"checkbox\" onclick=\"selTurnadoCorreo();\" ".toCharArray();
    __oracle_jsp_text[189] = 
    ">Turnado\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"25%\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT value=\"6\" name=\"usuarioRol\" type=\"checkbox\" ".toCharArray();
    __oracle_jsp_text[190] = 
    " onclick=\"selAtencionCorreo();desavilitarOtrosChecksAsistente();\">Asistente\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"25%\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t</FIELDSET>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\n\t<TR VALIGN=top>\n\t\t<TD width=\"218\"><FONT SIZE=2 FACE=\"Verdana\">&nbsp;</FONT></TD>\n\t\t<TD width=\"600\">\n\t\t\t<FIELDSET dir=\"ltr\">\n\t\t\t<LEGEND align=\"left\"><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Configuración\n\t\tde Correos de Salida</B></FONT></LEGEND>\t\n\t\t\t<TABLE>\n\t\t\t\t<TBODY>\n\t\t\t\t\t<!-- <tr>\n\t\t\t\t\t\t<TD colspan=\"3\" width=\"529\">\n\t\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Arial\">\n\t\t\t\t\t\t\t<INPUT name=\"selectAll1\" type=\"checkbox\" value=\"0\" align=\"middle\" onclick=\"seleccionarTodos()\"><u>Seleccionar Todos</u>\n\t\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</tr>  -->\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"172\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT name=\"usuarioConfMails\" type=\"checkbox\" value=\"0\" align=\"middle\" ".toCharArray();
    __oracle_jsp_text[191] = 
    ">Nuevo Asunto\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"172\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT name=\"usuarioConfMails\" type=\"checkbox\" value=\"1\" align=\"middle\" ".toCharArray();
    __oracle_jsp_text[192] = 
    ">Turnar\n\t\t\t\t\t\tInstrucciones\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"173\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT name=\"usuarioConfMails\" type=\"checkbox\" value=\"2\" align=\"middle\" ".toCharArray();
    __oracle_jsp_text[193] = 
    ">Responder\n\t\t\t\t\t\tinstrucción\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"172\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT name=\"usuarioConfMails\" type=\"checkbox\" value=\"3\" align=\"middle\" ".toCharArray();
    __oracle_jsp_text[194] = 
    ">Rechazar\n\t\t\t\t\t\tinstrucción\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"172\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT name=\"usuarioConfMails\" type=\"checkbox\" value=\"4\" align=\"middle\" ".toCharArray();
    __oracle_jsp_text[195] = 
    ">Delegar\n\t\t\t\t\t\tinstrucción\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"173\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT name=\"usuarioConfMails\" type=\"checkbox\" value=\"5\" align=\"middle\" ".toCharArray();
    __oracle_jsp_text[196] = 
    ">Reasignar\n\t\t\t\t\t\tinstrucción\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD width=\"172\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT name=\"usuarioConfMails\" type=\"checkbox\" value=\"6\" align=\"middle\" ".toCharArray();
    __oracle_jsp_text[197] = 
    ">Habilitar\n\t\t\t\t\t\tinstrucción\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"172\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT name=\"usuarioConfMails\" type=\"checkbox\" value=\"7\" align=\"middle\" ".toCharArray();
    __oracle_jsp_text[198] = 
    ">Solicitud de cambio de fecha de una instrucción\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"173\">\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<INPUT name=\"usuarioConfMails\" type=\"checkbox\" value=\"8\" align=\"middle\" ".toCharArray();
    __oracle_jsp_text[199] = 
    ">Respuesta de cambio de fecha de una instrucción\n\t\t\t\t\t\t</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TBODY>\n\t\t\t</TABLE>\n\t\t\t</FIELDSET>\n\t\t</TD>\n\t</TR>\n\t\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"600\">\n\t\t\t<fieldset dir=\"ltr\">\n\t\t\t\t<legend><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Configuración de Correos de Entrada</B></FONT></legend>\n\t\t\t<table width=\"98%\" border=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td width=\"46%\">\n\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[200] = 
    "\n\t\t\t\t<input name=\"not\" type=\"checkbox\" value=\"0\" align=\"middle\"  ".toCharArray();
    __oracle_jsp_text[201] = 
    ">Recibir Notificaciones\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[202] = 
    "\n\t\t\t\t<input name=\"not\" type=\"checkbox\" value=\"0\" align=\"middle\" checked=\"checked\">Recibir Notificaciones\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[203] = 
    "</FONT>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"54%\"><FONT SIZE=1 FACE=\"Verdana\"></FONT></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</fieldset>\n\t\t</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"529\">&nbsp;</TD>\n\t</TR>\n\t<TR valign=\"top\">\n\t\t<TD width=\"144\">&nbsp;</TD>\n\t\t<TD width=\"600\">\n\t\t\t<fieldset dir=\"ltr\">\n\t\t\t\t<legend><FONT SIZE=2 FACE=\"Verdana\" color=\"#004080\"><B>Configuraci&oacute;n de Cat&aacute;logos\n\t\t\t\t</B></FONT></legend>\n\t\t\t<table width=\"98%\" border=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td width=\"46%\">\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[204] = 
    "\n\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t<input name=\"catArch\" type=\"checkbox\" value=\"1\" align=\"middle\"  ".toCharArray();
    __oracle_jsp_text[205] = 
    ">Cat&aacute;logo\n\t\t\t\tde Archivado</FONT>\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[206] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[207] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[208] = 
    "\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<input name=\"catArch\" type=\"checkbox\" value=\"1\" align=\"middle\"  ".toCharArray();
    __oracle_jsp_text[209] = 
    ">Cat&aacute;logo\n\t\t\t\t\t\tde Archivado</FONT>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[210] = 
    "\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<input name=\"catArch\" type=\"checkbox\" value=\"1\" align=\"middle\"  ".toCharArray();
    __oracle_jsp_text[211] = 
    " disabled=\"disabled\">Cat&aacute;logo\n\t\t\t\t\t\tde Archivado</FONT>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[212] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[213] = 
    "\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[214] = 
    "\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<input name=\"catArch_1\" type=\"checkbox\" value=\"1\" align=\"middle\"  ".toCharArray();
    __oracle_jsp_text[215] = 
    " disabled=\"disabled\">Cat&aacute;logo\n\t\t\t\t\t\t<INPUT name=\"catArch\" type=\"hidden\" value=\"".toCharArray();
    __oracle_jsp_text[216] = 
    "\">\n\t\t\t\t\t\tde Archivado</FONT>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[217] = 
    "\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<input name=\"catArch\" type=\"checkbox\" value=\"1\" align=\"middle\"  ".toCharArray();
    __oracle_jsp_text[218] = 
    ">Cat&aacute;logo\n\t\t\t\t\t\tde Archivado</FONT>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[219] = 
    "\n\t\t\t\t\t\t<FONT SIZE=1 FACE=\"Verdana\">\n\t\t\t\t\t\t<input name=\"catArch\" type=\"checkbox\" value=\"1\" align=\"middle\"  ".toCharArray();
    __oracle_jsp_text[220] = 
    " disabled=\"disabled\">Cat&aacute;logo\n\t\t\t\t\t\tde Archivado</FONT>\n\t\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[221] = 
    "\n\t\t\t\t\t".toCharArray();
    __oracle_jsp_text[222] = 
    "\n\t\t\t\t".toCharArray();
    __oracle_jsp_text[223] = 
    " \n\t\t\t\t</td>\n\t\t\t\t<td width=\"54%\"><FONT SIZE=1 FACE=\"Verdana\"></FONT></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</fieldset>\n\t\t</TD>\n\t</TR>\n       <c2:if test=\"true\"/>\n      </TABLE>\n<br>\n<table width=\"820\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n<TBODY>\n\t".toCharArray();
    __oracle_jsp_text[224] = 
    "\n\t<TR VALIGN=top>\n\t\t<TD width=\"244\">\n\t\t\t<a href=\"Bitacora.jsp?id_usuario=".toCharArray();
    __oracle_jsp_text[225] = 
    "&retURI=".toCharArray();
    __oracle_jsp_text[226] = 
    "\">\n\t\t\t<u><FONT SIZE=2 FACE=\"Verdana\">Acceso a la botácora del Usuario</FONT></u>\n\t\t\t</a>\n\t\t</TD>\n\t\t<TD width=\"492\">&nbsp;</TD>\n\t</TR>\n\t".toCharArray();
    __oracle_jsp_text[227] = 
    "\n</TBODY>\n</table>\n</DIV>\n<br>\n</DIV>\n<BR>\n\t\t".toCharArray();
    __oracle_jsp_text[228] = 
    "\n\t\t<script type=\"text/javascript\">\n\t\tif(confirm(\"El usuario ya existe en las siguientes Unidades Administrativas: ".toCharArray();
    __oracle_jsp_text[229] = 
    "\"+\". \\nDesea incluirlo en esta Unidad Administrativa?\")){\n\t\t   var doc = document.forms[0];\n\t\t   doc.usuario_duplicado.value=\"true\";\n\t\t   doc.accion.value=doc.accionTemp.value;\n\t\t   doc.submit();\n\t\t }\n\t\t</script>\n\t\t".toCharArray();
    __oracle_jsp_text[230] = 
    "\n<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = \"no\" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>\n</FORM>\n</BODY>\n</HTML>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
