<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<HTML> 
<HEAD>
<TITLE>Puestos</TITLE>
<jsp:useBean id="BUsuario1" class="com.meve.sigma.beans.AreaBean" scope="page">
	<jsp:setProperty name="BUsuario1" property="*" /> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.meve.sigma.actualiza.*"%>
<%@ page import="com.meve.sigma.taglib.*"%>
<%@ page import="com.meve.sigma.beans.*"%>
<%@ page import="com.meve.sigma.ldap.*"%>
<%@ page import="com.meve.sigma.util.*"%>
<%@ page import="java.util.Vector"%>
<jsp:useBean id="BEscritura" class="com.meve.sigma.beans.EscrituraBean"
	scope="page"></jsp:useBean>
<!-- Se hace una instancia al Bean del usuario para la sesión -->
<%
	UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
	String strTmp=request.getRequestURI();
	strTmp=strTmp.substring(strTmp.indexOf('/',2)+5,strTmp.length());
	if(BUsuario==null){
		try{
			response.sendRedirect("index.jsp?pagina="+ strTmp);
		}
		catch(java.io.IOException io){;}
	}

%>
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERUsuarioInvalido.jsp"></jsp:forward>
<% } %>
<!-- Fin bloque sesión -->
<%
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
%>
<% if(strIdUsuario!=null && strIdUsuario.length()!=0){ %>
<% if((BUsuario.getAdmon() || BUsuario.getIdArea().equals(strIdArea))){ %>
<% }else{ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<% } %>

<% 	if(strIdUsuario!=null && strIdUsuario.length()!=0 ){ 
	String strRolLIsta = ActualizaRol.getRoles(strIdUsuario)[0][0];  %>
<% 	if(BUsuario.getSupervisor() && strRolLIsta.equals("0")){ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% 	} %>
<% 	} %>
<LINK href="../theme/Master.css" rel="stylesheet" type="text/css">
<LINK href="../css/menu.css" rel="stylesheet" type="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<STYLE type="text/css">
</STYLE>
<SCRIPT src="../js/menu.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/valida.js" type=text/javascript></SCRIPT>
<SCRIPT src="../js/SigmaJS.js" type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript type=text/javascript>


	function onloadRoles(){
	
		doc = document.usuarioForm;
		if(doc.id_usuario.value != "")
		{
			var admon = <%=admon%>;
			var asistente = <%=asistente%>;
			if(admon == 0){
				doc.usuarioRol[1].disabled = true;
				doc.usuarioRol[2].disabled = true;
				doc.usuarioRol[3].disabled = true;
				doc.usuarioRol[4].disabled = true;
				doc.usuarioRol[5].disabled = true;
				doc.usuarioRol[6].disabled = true;
				
			}
			if(asistente==6){
				doc.usuarioRol[0].disabled = true;
				doc.usuarioRol[1].disabled = true;
				doc.usuarioRol[2].disabled = true;
				doc.usuarioRol[4].disabled = true;
				doc.usuarioRol[5].disabled = true;
			}
		}
	}
	function usuarios1() {
		doc = document.usuarioForm;
		doc.submit();
	}

	function referenciaRet(retURI){
		location.assign(retURI.value);
	}

</SCRIPT>
<STYLE type=text/css>BODY {
	MARGIN: 0px
} 
</STYLE>
</HEAD>
<BODY onload="valida=0;timer_load();onloadRoles();selRecepcionCorreo();selAdminCorreo();
		selAtencionCorreo();selTurnadoCorreo();selectConfigCorreo();" background="../Imagenes/fondo_claro.jpg"
	onKeyPress="timer_reload();" 
	onClick="timer_reload();">
<FORM action="Usuarios.jsp" name="usuarioForm" method="post">
<INPUT type="hidden" value="<%=request.getParameter("accion")%>" name="accionTemp">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" name="id_usuario" value="<%=strIdUsuario%>">
<INPUT type="hidden" name="usuario_duplicado" value="">
<INPUT type="hidden" name="admon" value="<%=admon%>">
<INPUT type="hidden" name="atencion" value="<%=atencion%>">
<INPUT type="hidden" name="gestion" value="<%=gestion%>">
<INPUT type="hidden" name="recepcion" value="<%=recepcion%>">
<INPUT type="hidden" name="supervisor" value="<%=supervisor%>">
<INPUT type="hidden" name="turnado" value="<%=turnado%>">
<INPUT type="hidden" name="asistente" value="<%=asistente%>">
<INPUT type="hidden" name="nuevoAsunto" value="<%=a%>">
<INPUT type="hidden" name="turnar" value="<%=b%>">
<INPUT type="hidden" name="responder" value="<%=c%>">
<INPUT type="hidden" name="rechazar" value="<%=d%>">
<INPUT type="hidden" name="delegar" value="<%=e%>">
<INPUT type="hidden" name="reasignar" value="<%=t%>">
<INPUT type="hidden" name="habilitar" value="<%=g%>">
<INPUT type="hidden" name="solicitudCambio" value="<%=h%>">
<INPUT type="hidden" name="respuestaCambio" value="<%=z%>">
<INPUT type="hidden" name="catArch1" value="<%=catArch%>">
<INPUT type="hidden" name="not1" value="<%=notificacion%>">
<INPUT type="hidden" name="usuarioRol1" value="<%=strIdRol%>">
<INPUT type="hidden" name="usuarioConfMails1" value="<%=strConfMail%>">
<INPUT type="hidden" value="<%=strAux %>" name="aux">
<INPUT type="hidden" value="<%=strAux2 %>" name="aux2">
<INPUT type="hidden" value="<%=strAux3 %>" name="aux3">
<INPUT type="hidden" value="<%=strAux4 %>" name="aux4">
<INPUT type="hidden" value="<%=retURI %>" name="retURI">

<%if(strActivarLDAP.equals("2")){%>
<INPUT type="hidden" name="uid" value="<%= strUID %>">
<%}%>
<DIV align="center">
<BR>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125">
				<a onClick="referenciaRet(document.usuarioForm.retURI);">
				<IMG border="0" src="../Imagenes/NavLeft.gif" title="Regresar" ></a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a onclick="guardarUsuario();"> 
				<IMG border="0" src="../Imagenes/Save.gif" title="Guardar"></a>
			</TD>
			<TD width="125">
			</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="125">&nbsp;</TD>
			<TD width="142"></TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV align="center">

</DIV>
<br><DIV class=documentBody id=Body>
<!-- tag para los campos de username y password -->
<%if(!strActivarLDAP.equals("1")){%>
<DIV align="center">
<TABLE width="820" cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="50%"><B><FONT face="Verdana" color="#00204f" size="2">Registro de Puesto</FONT></B></TD>
			<TD width="50%" align="right" >**Los datos marcados con negritas son obligatorios&nbsp;<FONT face="Verdana" size="2"><I></I></FONT></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2"></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2"></TD>
		</TR>
		<TR valign="top">
			<TD align="right" colspan="2"><FONT face="Verdana" size="2">
				<%=(strIdUsuario!=null && !strIdUsuario.equals(""))?"Última modificación por: ":"Creado por: "%><I><%= strCreador%> - <%= strFechaCreacion%></I></FONT></TD>
		</TR>
	</TBODY>
</TABLE>
<table cellspacing="0" cellpadding="0" border="0">
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="531">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Usuario:</B></FONT><BR>
		</TD>
		<TD width="531"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50" 
			type="text" name="uid" class="blue600a" value="<%=strUID%>" maxlength="20"></FONT></TD>
	</TR>
	<TR valign="top"> 
		<TD width="144">&nbsp;</TD>
		<TD width="531">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Contraseña:</B></FONT></TD>
		<TD width="531"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50"
			type="password" name="usuarioPassword" class="blue600a" value="<%=strPassword%>" maxlength="15"></FONT>
		<INPUT name="controlUSR" type="hidden" value="1"></TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="531">&nbsp;</TD>
	</TR>
</table>
</DIV>
<%}else{%>
<DIV align="center">
<TABLE width="820" cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="50%"><B><FONT face="Verdana" color="#00204f" size="2">Registro de Puesto</FONT></B></TD>
			<TD width="50%" align="right">**Los datos marcados con negritas son obligatorios&nbsp;<FONT face="Verdana" size="2"><I></I></FONT></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2"></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD colspan="2"></TD>
		</TR>
		<TR valign="top">
			<TD colspan="2" align="right"><FONT face="Verdana" size="2">Creado
			por: <I><%= strCreador%> - <%= strFechaCreacion%></I></FONT></TD>
		</TR>
	</TBODY>
</TABLE>
<table cellspacing="0" cellpadding="0" border="0">
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="531">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Usuario:</B></FONT><BR>
       </TD>
		<TD width="531"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50"
			type="text" name="uid" class="blue600a" value="<%=strUID%>" maxlength="20"></FONT></TD>
	</TR>
	<TR valign="top"> 
		<TD width="144">&nbsp;</TD>
		<TD width="531">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Contraseña:</B></FONT></TD>
		<TD width="531"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50"
			type="password" name="usuarioPassword" class="blue600a" value="<%=strPassword%>" maxlength="15"></FONT>
		<INPUT name="controlUSR" type="hidden" value="1"></TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="531">&nbsp;</TD>
	</TR>
</table>
</DIV>

<INPUT name="controlUSR" type="hidden" value="0">
<%}%>
<!-- fin tag para los campos de username y password -->
<DIV align="center">
<TABLE width="820" cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD><B><FONT face="Verdana" color="#00204f" size="2">Datos Personales</FONT></B></TD>
		</TR>
		<TR valign="top">
			<TD bgcolor="#00204f" ><img src="../Imagenes/shim.gif" width="1" height="2" title=""></TD>
		</TR>
	</TBODY>
</TABLE>
<DIV align="center">
<table cellspacing="0" cellpadding="0" border="0">
	<TR valign="top">
		<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<%if(strActivarLDAP.equals("2")){%>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">Buscar Datos:</FONT></TD>
		<TD width="529"><FONT SIZE=2 FACE="Verdana"> <meve_combo:comboseleccion
			data="<%= ActualizaLdap.getComboUsuariosLdapA() %>" multiple="false"
			name="comboUsuarios1" classHtml="blue600a"
			textoNoSeleccion=" ---------------- Selecciona un Puesto ---------------- "
			valorNoSeleccion="-1"
			script="onChange='ActuliazaCorreoA(this);' onKeypress='buscar_op(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'" /> </FONT></TD>
	</TR>
	<%}%> 
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Unidad
		Administrativa:</B></FONT></TD>
		<% if(BUsuario.getSupervisor()){ 
			if(strIdUsuario==null){
				strIdArea = BUsuario.getIdArea();
			}%>
		<% if (Ejemplo.length>0){ %>
		<TD width="529"><FONT SIZE=2 FACE="Verdana"> <meve_combo:comboseleccion
			data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="usuarioArea20"
			classHtml="blue600a" selected="<%=strIdArea%>"
			textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
			valorNoSeleccion="-1" 
			script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='usuarios1()' disabled = 'true'" />
			<SELECT name="usuarioArea" style="display:none">
				<OPTION value="<%=strIdArea%>"></OPTION>
			</SELECT>
		</FONT></TD>
		<%}else { %>
		<TD width="529"><FONT SIZE=2 FACE="Verdana"> <meve_combo:comboseleccion
			data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="usuarioArea"
			classHtml="blue600a" selected="<%= strIdArea %>"
			textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
			valorNoSeleccion="-1" 
			script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='usuarios1()'" />
		</FONT></TD>
		<%} %>

		<% }else{ %>
		<% if (Ejemplo.length>0 ){ %>
		<TD width="517"><FONT SIZE=2 FACE="Verdana"> <meve_combo:comboseleccion
			data="<%=ComboData.getAreasComboAll()%>" size="1" name="usuarioArea20"
			classHtml="blue600a" selected="<%= strIdArea %>"
			textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
			valorNoSeleccion="-1" 
			script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='usuarios1()' disabled = 'true' "/>
			<SELECT name="usuarioArea" style="display:none">
				<OPTION value="<%=strIdArea%>"></OPTION>
			</SELECT>
			</FONT>
		</TD>	
		
		<%}else { %>
		<TD width="517"><FONT SIZE=2 FACE="Verdana"> <meve_combo:comboseleccion
			data="<%=ComboData.getAreasComboAll()%>" size="1" name="usuarioArea"
			classHtml="blue600a" selected="<%= strIdArea %>"
			textoNoSeleccion=" ------------ Selecciona una Unidad Administrativa ------------ "
			valorNoSeleccion="-1" 
			script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()' onchange='usuarios1()' "/> </FONT></TD>
		<%} %>
		<% } %>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="218"><FONT face="Verdana" size="2" color="#004080"><B>Puesto:</B></FONT>
		<BR>
		<%if (valida == 1) {%><FONT color="red"><B>*Este Puesto ya existe* </B></FONT><%} %></TD>
		<TD width="529"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50" maxlength="199"
			type="text" name="usuarioNombre" class="blue600a" value="<%=strUsuario%>"></FONT></TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Responsable:</B></FONT><BR>
		<%if (valida2 == 1) {%><FONT color="red"><B>*Este Responsable ya esta en el sistema* </B></FONT><%} %>
		</TD>
		<TD width="529"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50" maxlength="199"
			type="text" name="usuarioCargo" class="blue600a" value="<%=strCargo%>"></FONT></TD>
	</TR>

	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Correo Electrónico:</B></FONT></TD>
		<TD width="529"><FONT SIZE=2 FACE="Verdana"> <INPUT size="50"
			type="text" maxlength="199" name="usuarioEmail" class="blue600a"
			type="text" maxlength="100" name="usuarioEmail" class="blue600a"
			value="<%=  (strUsuario!=null)?strCorreo:"" %>"></FONT></TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">Teléfono:</FONT></TD>
		<TD width="529"><FONT SIZE=2 FACE="Verdana"> <INPUT size="100" 
			type="text" name="usuarioTelefono" onkeydown="" class="blue600a"
			value="<%=strTelefono%>" maxlength="199"></FONT></TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>

	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">Consecutivo:</FONT></TD>
		<TD width="529"><FONT SIZE=2 FACE="Verdana"> </FONT><INPUT type="text"
			name="usuarioConsecutivo" size="20" class="blue200a"
			value="<%=strConsecutivo%>" onKeyPress='AceptaSoloTeclaNumericaYPunto();' maxlength="5"></TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">Jefe (Puesto): </FONT></TD>
		<% if(BUsuario.getSupervisor()){ %>
			<% if(strIdArea.length() > 0 && !strIdArea.equals("-1")){ %>
		<TD width="529">
			<SELECT name="usuarioJefe" class="blue600a"
					onkeypress="buscar_op1(this)" onblur="borrar_buffer()"
					onclick="borrar_buffer()" onchange="cambio1();">
			<%
				String strDelArea[][] = ComboData.getUsuarioCombo(BUsuario.getIdArea());
				String strIdPadre = ActualizaArea.getIdArePadre(strIdArea);
				String stridPadres[][] = new String[0][1];
				if(strIdPadre.length() > 0){
					stridPadres = ComboData.getUsuarioResponsable(strIdPadre);
				}
				else{
					stridPadres = new String[0][1];
				}
			%>
				<OPTION value="-1">------------ Puesto UA Padre ------------</OPTION>
			<%
				for(int i=0;i<stridPadres.length;i++){
					if(!strIdUsuario.equals(stridPadres[i][0])){
						boolean bJefe = true;
						for (int k=0; k<vSubalternos.size(); k++){
							if(stridPadres[i][0].equals((String)vSubalternos.get(k))){
								bJefe = false;
							}
						}
						if (bJefe){ 
			%>
				<OPTION value="<%=stridPadres[i][0]%>" <%=(strIdJefe.trim().equals(stridPadres[i][0])?"selected":"")%>><%=stridPadres[i][1]%></OPTION>
			<%			
						}
					}
				}
			%>
				<OPTION value="-1">------------ Puestos UA ------------</OPTION>
			<%
				for(int i=0;i<strDelArea.length;i++){
					if(!strIdUsuario.equals(strDelArea[i][0])){
						boolean bJefe = true;
						for (int k=0; k<vSubalternos.size(); k++){
							if(strDelArea[i][0].equals((String)vSubalternos.get(k))){
								bJefe = false;
							}
						}
						if (bJefe){ 
			%>
				<OPTION value="<%=strDelArea[i][0]%>" <%=(strIdJefe.trim().equals(strDelArea[i][0])?"selected":"")%>><%=strDelArea[i][1]%></OPTION>
			<%		
						}
					}
				}
			%>			
			</SELECT>
		</TD>
			<% }else{ %>
			<TD width="517">
			<SELECT class="blue600a" name="usuarioJefe">
				<OPTION value="-1">------------ Selecciona un Jefe ------------</OPTION>
			</SELECT>
			</TD>
			<%}%>	
		<% }else{ %>
		<% if(strIdArea.length() > 0 && !strIdArea.equals("-1")){ %>
		<TD width="517">
			<SELECT name="usuarioJefe" class="blue500a"
					onkeypress="buscar_op1(this)" onblur="borrar_buffer()"
					onclick="borrar_buffer()" onchange="cambio1();">
			<%
				String strDelArea[][] = ComboData.getUsuarioCombo(strIdArea);//Todos los usuarios del area
				String strIdPadre = ActualizaArea.getIdArePadre(strIdArea);//id del ua padre
				String stridPadres[][] = new String[0][1];
				if(strIdPadre.length() > 0){
					stridPadres = ComboData.getUsuarioResponsable(strIdPadre);
				}
			%>
				<OPTION value="-1">------------ Puesto UA Padre ------------</OPTION>
			<%
				for(int i=0;i<stridPadres.length;i++){
					if(!strIdUsuario.equals(stridPadres[i][0])){
						boolean bJefe = true;
						for (int k=0; k<vSubalternos.size(); k++){
							if(stridPadres[i][0].equals((String)vSubalternos.get(k))){
								bJefe = false;
							}
						}
						if (bJefe){ 
			%>
				<OPTION value="<%=stridPadres[i][0]%>" <%=(strIdJefe.trim().equals(stridPadres[i][0])?"selected":"")%>><%=stridPadres[i][1]%></OPTION>
			<%
						}
					}
				}
			%>
				<OPTION value="-1">------------ Puestos UA ------------</OPTION>
			<%
				for(int i=0;i<strDelArea.length;i++){
					if(!strIdUsuario.equals(strDelArea[i][0])){
						boolean bJefe = true;
						for (int k=0; k<vSubalternos.size(); k++){
							if(strDelArea[i][0].equals((String)vSubalternos.get(k))){
								bJefe = false;
							}
						}
						if (bJefe){
			%>
				<OPTION value="<%=strDelArea[i][0]%>" <%=(strIdJefe.trim().equals(strDelArea[i][0])?"selected":"")%>><%=strDelArea[i][1]%></OPTION>
			<%		
						}
					}
				}
			%>			
			</SELECT>
			</TD>
		<% }else{ %>
		<TD width="517">
		<SELECT class="blue600a" name="usuarioJefe">
			<OPTION value="-1">------------ Selecciona un Jefe ------------</OPTION>
		</SELECT>
		</TD>
		<% } %>
		<% } %>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>

	<TR valign="top">
		<TD width="144"><FONT SIZE=2 FACE="Verdana" color="#004080">Nombre del Jefe:</FONT></TD>
		<TD width="529"><%=Jefe %></TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>

	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">
         </FONT></TD>
		<% if(BUsuario.getSupervisor()){ %>
		<TD width="600"><FIELDSET dir="ltr">
                    <LEGEND align="left"><FONT SIZE=2 FACE="Verdana"  color="#004080"><B>Asistentes</B></FONT></LEGEND>
                <FONT SIZE=2 FACE="Verdana"> 
                    
                        <%--
                        <meve_combo:combomultiple
			data="<%= ComboData.getUsuarioAsistente(BUsuario.getIdArea()) %>" name="usuarioAsistente"
			classHtml="blue600a" selected="<%= strIdAsistente %>"
			disabled = "<%= HabComboAsistente %>"
			multiple="true" size="12"
			script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>--%>
                        <%String[][] asistentes = ComboData.getUsuarioAsistente(BUsuario.getIdArea());
                         request.setAttribute("asistentes",asistentes);
                         request.setAttribute("asistentesAsigandos",strIdAsistente);
                         
                        %>
                        <table width="100%">
                        <tbody>
                            <tr>
                                <td width="100%">
                                    <c:forEach items="${asistentes}" var="registro">
                                        <c:set var="seleccion" value=" "/>
                                        <c:forEach items="${asistentesAsigandos}" var="registroAsigando">
                                            <c:if test="${registro[0] == registroAsigando}" >
                                                <c:set var="seleccion" value="checked"/>
                                            </c:if>
                                        </c:forEach>
                                        <FONT SIZE=1 FACE="Verdana">
                                            <input type="checkbox" 
                                                   name="usuarioAsistente" 
                                                   value="<c:out value="${registro[0]}" />" 
                                                   <%= HabComboAsistente?"disabled":"" %> 
                                                   <c:out value="${seleccion}"/>><c:out value="${registro[1]}"/></input><br>
                                        </FONT>
                                    </c:forEach>
                                </td>
                            </tr>
                        </tbody>
                        </table>
                        
                        </FONT></FIELDSET></TD>
		<% }else{ %>
		<% if(strIdArea.length() > 0 && !strIdArea.equals("-1")){ %>
		<TD width="600">
                              			<FIELDSET dir="ltr">
			<LEGEND align="left"><FONT SIZE=2 FACE="Verdana"  color="#004080"><B>Asistentes</B></FONT></LEGEND>
                <FONT SIZE=2 FACE="Verdana">
  
                
                        <%--<meve_combo:combomultiple
			data="<%= ComboData.getUsuarioAsistente(strIdArea) %>"
			name="usuarioAsistente" classHtml="blue600a" 
			selected="<%= strIdAsistente %>"
			disabled = "<%= HabComboAsistente %>"
			multiple="true" size="12"
			script="onKeypress='buscar_op1(this)' onblur='borrar_buffer()' onclick='borrar_buffer()'"/>--%> 
                        
                        <%String[][] asistentes = ComboData.getUsuarioAsistente(strIdArea);
                         request.setAttribute("asistentes",asistentes);
                         request.setAttribute("asistentesAsigandos",strIdAsistente);%>
                         
                        <table width="100%">
                        <tbody>
                            <tr>
                                <td width="100%">
                                    <c:forEach items="${asistentes}" var="registro">
                                        <c:set var="seleccion" value=" "/>
                                        <c:forEach items="${asistentesAsigandos}" var="registroAsigando">
                                            <c:if test="${registro[0] == registroAsigando}" >
                                                <c:set var="seleccion" value="checked"/>
                                            </c:if>
                                        </c:forEach>
                                        <FONT SIZE=1 FACE="Verdana">
                                            <input type="checkbox" 
                                                   name="usuarioAsistente" 
                                                   value="<c:out value="${registro[0]}" />" 
                                                   <%= HabComboAsistente?"disabled":"" %> 
                                                   <c:out value="${seleccion}"/>><c:out value="${registro[1]}"/></input><br>
                                        </FONT>
                                    </c:forEach>
                                </td>
                            </tr>
                        </tbody>
                        </table>
                        
                        </FONT></FIELDSET></TD>
		<% }else{ %>
		<TD width="600">
                			<FIELDSET dir="ltr">
			<LEGEND align="left"><FONT SIZE=2 FACE="Verdana"  color="#004080"><B>Asistentes</B></FONT></LEGEND>
                        <table width="100%">
                        <tbody>
                            <tr>
                                <td width="100%">
                                    <SELECT class="blue600a" name="usuarioAsistente" <%= HabComboAsistente?"disabled=\"disabled\"":"" %>>
                                            <OPTION value="-1">------------ Seleccione un Asistente ------------</OPTION>
                                    </SELECT>
                                </td>
                            </tr>
                        </tbody>
                        </table>
                </FIELDSET>
		</TD>
		<% } %>
		<% } %>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<% if(strIdUsuario.length() != 0){ %>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">Usuario Activo:</FONT></TD>
		<TD width="529"><FONT SIZE=2 FACE="Verdana">
			<SELECT name="usuarioActivo" class="blue100">
				<OPTION value="0" <%=(strActivo.equals("0")?"selected":"")%>>Suspendido</OPTION>
				<OPTION value="1" <%=(strActivo.equals("1")?"selected":"")%>>Activo</OPTION>
			</SELECT>
		</FONT></TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<% } %>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">Atención Destinatarios Externos:</FONT></TD>
		<TD width="529"><FONT SIZE=2 FACE="Verdana">
			<INPUT type="checkbox" name="usuarioDesExt" value="1" <%=(strDesExt.equals("1")?"checked":"")%>>Si
		</FONT></TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<%
	if(strIdArea.length()!=0 && !strIdArea.equals("-1")){
		String strSub = ActualizaArea.getSubventanilla(strIdArea);
	%>
	<%if(strSub.equals("0")){%>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana" color="#004080">Atención SubVentanilla:</FONT></TD>
		<TD width="529"><FONT SIZE=2 FACE="Verdana"> 
			<SELECT name="usuarioSubVent" class="blue500a" disabled>
			<%=ActualizaUsuario.getComboAtencion(strIdArea, strSubVent)%>
			</SELECT>
		</FONT></TD>
	</TR>
	<%}else{%>
	<tr><td><input type="hidden" name="usuarioSubVent" value="0"></td></tr>
	<%}%>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<%}else{%>
	<TR valign="top">
		<TD width="144"><input type="hidden" name="usuarioSubVent" value="0"></TD>
	</TR>
	<%}%>
	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana">&nbsp;</FONT></TD>
		<TD width="600">
			<FIELDSET dir="ltr">
			<LEGEND align="left"><FONT SIZE=2 FACE="Verdana"  color="#004080"><B>Rol
		de Usuario</B></FONT></LEGEND>	
			<TABLE width="100%">
				<TBODY>
					<TR>
						<TD width="25%">
						<FONT SIZE=1 FACE="Verdana">
						<% if(BUsuario.getSupervisor()){ %>
						<INPUT value="0" name="usuarioRol" type="checkbox" <%=(admon.trim().equals("0")?"checked":"")%> disabled="disabled">Administrador
						<% }else{ %>
						<INPUT value="0" name="usuarioRol" type="checkbox" <%=(admon.trim().equals("0")?"checked":"")%> onclick="desavilitarOtrosChecks();selAdminCorreo();">Administrador
						<% } %>
						</FONT>
						</TD>
						<TD width="25%">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT value="1" name="usuarioRol" type="checkbox" onclick="selAtencionCorreo();" <%=(atencion.trim().equals("1")?"checked":"")%>>Atención
						</FONT>
						</TD>
						
						<TD width="25%">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT value="3" name="usuarioRol" type="checkbox" onclick="selRecepcionCorreo();" <%=(recepcion.trim().equals("3")?"checked":"")%>>Recepción
						</FONT>
						</TD>
						<TD width="25%">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT value="2" name="usuarioRol" type="checkbox" onclick="selSCPCorreo();" <%=(gestion.trim().equals("2")?"checked":"")%>>SCP
						</FONT>
						</TD>
					</TR>
					<TR>
						<TD width="25%">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT value="4" name="usuarioRol" type="checkbox" onclick="selAdminCorreo();" <%=(supervisor.trim().equals("4")?"checked":"")%>>Supervisor Área
						</FONT>
						</TD>
						<TD width="25%">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT value="5" name="usuarioRol" type="checkbox" onclick="selTurnadoCorreo();" <%=(turnado.trim().equals("5")?"checked":"")%>>Turnado
						</FONT>
						</TD>
						<TD width="25%">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT value="6" name="usuarioRol" type="checkbox" <%=(asistente.trim().equals("6")?"checked":"")%> onclick="selAtencionCorreo();desavilitarOtrosChecksAsistente();">Asistente
						</FONT>
						</TD>
						<TD width="25%">
						<FONT SIZE=1 FACE="Verdana">
						&nbsp;
						</FONT>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</FIELDSET>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>

	<TR VALIGN=top>
		<TD width="218"><FONT SIZE=2 FACE="Verdana">&nbsp;</FONT></TD>
		<TD width="600">
			<FIELDSET dir="ltr">
			<LEGEND align="left"><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Configuración
		de Correos de Salida</B></FONT></LEGEND>	
			<TABLE>
				<TBODY>
					<!-- <tr>
						<TD colspan="3" width="529">
							<FONT SIZE=1 FACE="Arial">
							<INPUT name="selectAll1" type="checkbox" value="0" align="middle" onclick="seleccionarTodos()"><u>Seleccionar Todos</u>
							</FONT>
						</TD>
					</tr>  -->
					<TR>
						<TD width="172">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT name="usuarioConfMails" type="checkbox" value="0" align="middle" <%=(a.trim().equals("0")?"checked":"")%>>Nuevo Asunto
						</FONT>
						</TD>
						<TD width="172">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT name="usuarioConfMails" type="checkbox" value="1" align="middle" <%=(b.trim().equals("1")?"checked":"")%>>Turnar
						Instrucciones
						</FONT>
						</TD>
						<TD width="173">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT name="usuarioConfMails" type="checkbox" value="2" align="middle" <%=(c.trim().equals("2")?"checked":"")%>>Responder
						Instrucción
						</FONT>
						</TD>
					</TR>
					<TR>
						<TD width="172">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT name="usuarioConfMails" type="checkbox" value="3" align="middle" <%=(d.trim().equals("3")?"checked":"")%>>Rechazar
						Instrucción
						</FONT>
						</TD>
						<TD width="172">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT name="usuarioConfMails" type="checkbox" value="4" align="middle" <%=(e.trim().equals("4")?"checked":"")%>>Delegar
						Instrucción
						</FONT>
						</TD>
						<TD width="173">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT name="usuarioConfMails" type="checkbox" value="5" align="middle" <%=(t.trim().equals("5")?"checked":"")%>>Reasignar
						Instrucción
						</FONT>
						</TD>
					</TR>
					<TR>
						<TD width="172">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT name="usuarioConfMails" type="checkbox" value="6" align="middle" <%=(g.trim().equals("6")?"checked":"")%>>Habilitar
						Instrucción
						</FONT>
						</TD>
						<TD width="172">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT name="usuarioConfMails" type="checkbox" value="7" align="middle" <%=(h.trim().equals("7")?"checked":"")%>>Solicitud de cambio de fecha de una Instrucción
						</FONT>
						</TD>
						<TD width="173">
						<FONT SIZE=1 FACE="Verdana">
						<INPUT name="usuarioConfMails" type="checkbox" value="8" align="middle" <%=(z.trim().equals("8")?"checked":"")%>>Respuesta de cambio de fecha de una Instrucción
						</FONT>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</FIELDSET>
		</TD>
	</TR>
	
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>

	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="600">
			<fieldset dir="ltr">
				<legend><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Configuración de Correos de Entrada</B></FONT></legend>
			<table width="98%" border="0">
			<tr>
				<td width="46%">
				<FONT SIZE=1 FACE="Verdana">
				<%if(strIdUsuario.length()!=0){%>
				<input name="not" type="checkbox" value="0" align="middle"  <%=(notificacion.trim().equals("0")?"checked":"")%>>Recibir Notificaciones
				<%}else{%>
				<input name="not" type="checkbox" value="0" align="middle" checked="checked">Recibir Notificaciones
				<%}%></FONT>
				</td>
				<td width="54%"><FONT SIZE=1 FACE="Verdana"></FONT></td>
			</tr>
			</table>
			</fieldset>
		</TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="529">&nbsp;</TD>
	</TR>
	<TR valign="top">
		<TD width="144">&nbsp;</TD>
		<TD width="600">
			<fieldset dir="ltr">
				<legend><FONT SIZE=2 FACE="Verdana" color="#004080"><B>Configuraci&oacute;n de Cat&aacute;logos
				</B></FONT></legend>
			<table width="98%" border="0">
			<tr>
				<td width="46%">
				<%if(BUsuario.getAdmon()){%>
				<FONT SIZE=1 FACE="Verdana">
				<input name="catArch" type="checkbox" value="1" align="middle"  <%=(catArch.trim().equals("1")?"checked":"")%>>Cat&aacute;logo
				de Archivado</FONT>
				<%}else{%>
					<%if(strIdUsuario.length()==0){%>
						<%if(BUsuario.getCatArchivado().equals("1")){%>
						<FONT SIZE=1 FACE="Verdana">
						<input name="catArch" type="checkbox" value="1" align="middle"  <%=(catArch.trim().equals("1")?"checked":"")%>>Cat&aacute;logo
						de Archivado</FONT>
						<%}else{%>
						<FONT SIZE=1 FACE="Verdana">
						<input name="catArch" type="checkbox" value="1" align="middle"  <%=(catArch.trim().equals("1")?"checked":"")%> disabled="disabled">Cat&aacute;logo
						de Archivado</FONT>
						<%}%>
					<%}else{%>
						<%if(BUsuario.getIdUsuario().equals(strIdUsuario)){%>
						<FONT SIZE=1 FACE="Verdana">
						<input name="catArch_1" type="checkbox" value="1" align="middle"  <%=(catArch.trim().equals("1")?"checked":"")%> disabled="disabled">Cat&aacute;logo
						<INPUT name="catArch" type="hidden" value="<%=catArch%>">
						de Archivado</FONT>
						<%}else if(BUsuario.getCatArchivado().equals("1")){%>
						<FONT SIZE=1 FACE="Verdana">
						<input name="catArch" type="checkbox" value="1" align="middle"  <%=(catArch.trim().equals("1")?"checked":"")%>>Cat&aacute;logo
						de Archivado</FONT>
						<%}else{%>
						<FONT SIZE=1 FACE="Verdana">
						<input name="catArch" type="checkbox" value="1" align="middle"  <%=(catArch.trim().equals("1")?"checked":"")%> disabled="disabled">Cat&aacute;logo
						de Archivado</FONT>
						<%}%>
					<%}%>
				<%}%> 
				</td>
				<td width="54%"><FONT SIZE=1 FACE="Verdana"></FONT></td>
			</tr>
			</table>
			</fieldset>
		</TD>
	</TR>
       <c2:if test="true"/>
      </TABLE>
<br>
<table width="820" cellspacing="0" cellpadding="0" border="0">
<TBODY>
	<% if(strIdUsuario.length() != 0){ %>
	<TR VALIGN=top>
		<TD width="244">
			<a href="Bitacora.jsp?id_usuario=<%=strIdUsuario%>&retURI=<%=Utilerias.codificaPostHTML(strTmp+"?id_usuario="+strIdUsuario+"&accion=consultar&retURI="+ Utilerias.codificaPostHTML(retURI))%>">
			<u><FONT SIZE=2 FACE="Verdana">Acceso a la Bitácora del Usuario</FONT></u>
			</a>
		</TD>
		<TD width="492">&nbsp;</TD>
	</TR>
	<% } %>
</TBODY>
</table>
</DIV>
<br>
</DIV>
<BR>
		<%if (bExisteUsuario && strAccion != null && (strAccion.equals("cambiar") || strAccion.equals("guardar"))) {%>
		<script type="text/javascript">
		if(confirm("El usuario ya existe en las siguientes Unidades Administrativas: <%= ActualizaUsuario.getJSUsuarioArea(strUID)%>"+". \nDesea incluirlo en esta Unidad Administrativa?")){
		   var doc = document.forms[0];
		   doc.usuario_duplicado.value="true";
		   doc.accion.value=doc.accionTemp.value;
		   doc.submit();
		 }
		</script>
		<%} %>
<script>var bodyElement = document.body.all['Body'] ;function LayoutBodyElement() {  bodyElement.style.posHeight = document.body.offsetHeight - bodyElement.offsetTop ;} function document.onreadystatechange() { document.body.scroll = "no" ; LayoutBodyElement( ) ; window.onresize = LayoutBodyElement;}</script>
</FORM>
</BODY>
</HTML>
</jsp:useBean>