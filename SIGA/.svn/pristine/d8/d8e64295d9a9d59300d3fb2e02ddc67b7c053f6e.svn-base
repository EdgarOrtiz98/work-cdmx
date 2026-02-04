<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="headerC.jsp" flush="false"></jsp:include>
<%@taglib uri="meve_combo" prefix="meve_combo"%>
<%@ page import="com.meve.sigma.taglib.*"%>
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.meve.sigma.actualiza.*,com.meve.sigma.beans.*,
			java.util.*"
%> 
<%

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
%>
<% if(	(BUsuario.getAtencion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getGestion() && !BUsuario.getSupervisor()) ||
		(BUsuario.getRecepcion() && !BUsuario.getSupervisor()) || 
		(BUsuario.getTurnado() && !BUsuario.getSupervisor()) ||
		(BUsuario.getAsistente() && !BUsuario.getSupervisor())){ %>
<jsp:forward page="../Error/ERNoAccesoInstruccion.jsp"></jsp:forward>
<% } %>
<%

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
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="../theme/Master.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/calendar.css" rel="stylesheet"
	type="text/css">
<LINK href="../css/menu.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="../js/Menu2.js"></script>
<script type="text/javascript" src="../js/SigmaJS.js"></script>
<script type="text/javascript" src="../js/link.js"></script>	
<TITLE>Expedientes</TITLE>
<script type="text/javascript" src="../js/valida.js"></script>
<SCRIPT language=JavaScript type=text/javascript>
<!-- 
	function limpiarCampos(){
		document.expedientef.reset();
	}
</SCRIPT>
<STYLE type=text/css>
	BODY {
		margin: 0px;
	}
</STYLE>
<SCRIPT language="JavaScript" type="text/javascript">
var claveexpediente = "";

	function asignavalor()
	{
	claveexpediente = "true";
	}
	
	function anio() { 
		anio= document.expedientef.fec_apert.value;
		document.expedientef.pasaanio.value = anio.substring(6);
		}
	
	function anio2() { 
	   if(claveexpediente.length > 1)
	   {
	   <%if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
	   {
	   }
	   else
	   {
	   %>
			anio= document.expedientef.fec_apert.value;
			cv1= document.expedientef.clvExpdic.value;
			cv2= document.expedientef.ct.value;
			cv3= document.expedientef.consec.value;
			//document.expedientef.ano_exp.value = anio.substring(6);
			document.expedientef.clave.value = cv1+"."+anio.substring(6)+"."+cv2+ "." + cv3;
			claveexpediente = "";
		<%}
	   %>
		}
		}		
function detalle() { 
	cambio();
//	det= document.expedientef.cls.value;
//	document.getElementById('detalle').src= "ClasifDetalle.jsp?cls="+det;
	}
function detalle2() {
	cambio();
	val = "pasa";
	<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
	val = "";
	<%}%>
	aniocon = document.expedientef.pasaanio.value;
	det2= document.expedientef.ced_tip.value;
	document.getElementById('detalle2').src= "CedulaDetalle.jsp?cls="+det2+"&anio="+aniocon+"&valor="+val;
	}	
function reload() {
	cambio();
	doc = document.expedientef;
	doc.accion.value="reload";
	<%if(valida != 2) 
	{%>
	doc.submit();
	<%
	}%>
}
function rValidando() {
	<%if(valida == 2) 
	{%>
	//alert("El registro consultado no puede ser modificado");
	alert("Como este registro ya cuenta con registros dependientes, solo podra ser modificado su descripción o ser cerrado.");
	<%
	}%>
}
function cambio(){
	doc = document.expedientef;
	val = doc.cve_UA.value;
	doc.cve_UA2.value = val;
	val2 = doc.ced_tip.value;
	doc.ced_tip2.value = val2;	
//	val3 = doc.cls.value;
//	doc.cls2.value = val3;
	val4 = doc.idclsinf.value;
	doc.idclsinf2.value = val4;		
}


	function habilita2()
	{
		if(document.expedientef.inactivo.checked == true)
		{
		document.expedientef.fecinact.value = "<%=horafec%>";
		document.expedientef.fecinact.disabled = false;
		document.expedientef.justif.disabled = false;
		}else
		{
		document.expedientef.fecinact.value = "";
		document.expedientef.justif.value = "";
		document.expedientef.fecinact.disabled = true;
		document.expedientef.justif.disabled = true;
		}
	}	
	function sum() { 
	 var at = parseInt(document.expedientef.ano_AT.value);
	 var ac = parseInt(document.expedientef.ano_AC.value);
	
	   suma = at + ac;
	   document.expedientef.totaldisp.value = suma
	mayor();
	}	

	function unudisp()
	{
		if(document.expedientef.sisiConsulcls.checked == true)
		{
			document.expedientef.sisiConsulcls.checked = false;
		}else
		{
			document.expedientef.sisiConsulcls.checked = true;
		}
	}

	function sum2() { 
	 var at = parseInt(document.expedientef.ano_AT.value);
	 var ac = parseInt(document.expedientef.ano_AC.value);
	 var acs = parseInt(document.expedientef.sisi.value);
	
	if (document.expedientef.sisiConsuldisp.checked == true)
		{
		   suma = at + ac + acs;
		   document.expedientef.totaldisp.value = suma;
		}
	if (document.expedientef.sisiConsuldisp.checked == false)
		{
		suma = at + ac;
		document.expedientef.totaldisp.value = suma;
		}
	mayor();
	}	
		
	function indefinido()
	 {
	 doc = document.expedientef;
	 	//if (doc.expedientef.checked == true) {
	 	doc.ano_AT.value = "99";
	 	doc.ano_AC.value = "99";
	 	doc.ano_AT2.value = "99";
	 	doc.ano_AC2.value = "99";
	 	doc.totaldisp.value = "999";
	 	doc.totaldisp2.value = "999";
	 	doc.ano_AT.disabled = true;
	 	doc.ano_AC.disabled = true;
	 	doc.totaldisp.disabled = true;
	 	doc.sisiConsuldisp.disabled = true;
 /*	}
 	else
 	{
 	doc.sisi.disabled = false;
 	doc.ano_AT.disabled =false;
 	doc.vigenciaat.disabled =false;
 	doc.vigenciatot.disabled =false;
 	}*/
 	}
 	function habilIndef()
 	{
	 	at =  "<%=ano_AT%>";
	 	if	(parseInt(at) == 99)
			indefinido();
 	}
 	function real()
 	{
	 	doc = document.expedientef;
	 	
		a = "0";
		b = "0";
		c = "0";
	
	 	if(Trim(doc.anioresv.value) != "")
	 	{
	 		a = parseInt(doc.anioresv.value);
	 	}
		if(Trim(doc.ano_Amp.value) != "")
	 	{
	 		b = parseInt(doc.ano_Amp.value);
	 	}	
	
		b = parseInt(a) + parseInt(b);
	 	doc.anioreal.value = parseInt(b);
	 	totalclsif();
	 	mayor();
 	}
 	function mayor()
 	{
	 	doc = document.expedientef;
	 	if( parseInt(doc.totalcls.value) < parseInt(doc.totaldisp.value))
		 	{
		 	doc.ano_guard.value = doc.totaldisp.value;
		 	}else
		 	{
		 	doc.ano_guard.value = doc.totalcls.value;
		 	}
	 	if( parseInt(doc.totalcls.value) == parseInt(doc.totaldisp.value))
		 	doc.ano_guard.value = doc.totaldisp.value;
	 	}
	function windowDetalle()
	 	{
	 	<%if(strIdSubfondo != null && strIdSubfondo.trim().length()>0)
	 	{%>
	 		window.open('AniosDetalle.jsp?valor=<%=strIdSubfondo%>','window','width=420,height=250');
	 		window.focus;
	 	<%}%>
 	}
 	
 	function totalclsif()
 	{	
		doc = document.expedientef;
		a = parseInt(doc.anioreal.value) + parseInt(doc.anioreal.value);

		if (document.expedientef.sisiConsulcls.checked == true)
		{
				a = a + parseInt(doc.sisi.value);
		}
	doc.totalcls.value = a;
	mayor();
  	}
  	
  	function une()
  	{
  		doc = document.expedientef;
  		
	  	if(document.expedientef.sisiConsuldisp.checked == true)
		{
			document.expedientef.sisiConsuldisp.checked = false;
		}else
		{
			document.expedientef.sisiConsuldisp.checked = true;
		}
  		if(parseInt(doc.totaldisp.value) != 999)
	 	{
	 	sum2();
	 	}
	 mayor();
  	}
function validaFormatoFechaEx(){
	//alert();
	doc = document.expedientef;	
	FR = doc.fec_apert.value;
	fecha = FR;
	mes	 =	fecha.substring(3, 5); 
	dia	 =	fecha.substring(0, 2); 
   	anio =	fecha.substring(6,10);     
	if (Trim(fecha) != ""){
		var bandera=false;
		if(fecha.length != 10){
			bandera=true;
		}
		if(fecha.charAt(2) != '/' || fecha.charAt(5) != '/'){
			bandera=true;
		}
		if(mes>12 || mes<1){
			bandera=true;
		}
		else{
			if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
				if (dia<1 || dia>31)
					bandera=true;
			}
			else{
				if (dia<1 || dia>30)
					bandera=true;
			}
			if(mes==2 && anio%4==0){
				if (dia<1 || dia>29)
					bandera=true;
			}
			if(mes==2 && anio%4!=0){
				if (dia<1 || dia>28)
					bandera=true;
			}
		}		
		if(bandera){
		alert("El formato de fecha es invalido");
		doc.fec_apert.value = "";
		}
		if (doc.ced_tip[doc.ced_tip.selectedIndex].value > -1) {
		reload();
		}
	  }  	
	}
	function ponerfecha()
	{
	doc = document.expedientef;	
	FR = doc.fec_apert.value;
	  if (Trim(FR) == ""){
	  alert("Debe asignar una Fecha de Apertura");
	  doc.ced_tip.value = "-1";
	  return false;
	  }
	  reload();
	}

	function validaFechaFinesSem(campoFecha){

		var valida = 0 
		<%for (int ik=0; ik<finesSemana.size(); ik++){ %>	
		if (campoFecha != null && campoFecha.value == "<%= (String)finesSemana.get(ik) %>") {
			valida =1;
		}
		<%}%>
		if (valida == 1){
			alert("La fecha seleccionada no es laborable");
			campoFecha.value = "";
		} 
	}

function validaAniosRerv()		
	{
	var a =  document.expedientef.anioresv.value;
	var b =  document.expedientef.anioreal.value;
	if (eval(a)>12)	
		{
			alert("Los años de reserva no puenden ser mayor a 12 años!");
			document.expedientef.anioresv.value ="12";
			real();
		}
	if (eval(b)>12)	
		{
			alert("Los años de reserva no puenden ser mayor a 12 años!");
			document.expedientef.anioreal.value ="12";
			real();
		}
	}	
</SCRIPT>
</HEAD>
<BODY background="../Imagenes/fondo_claro.jpg" 
	onload="valida=0;anio();rValidando();detalle2();habilIndef();real();setFormFocusExpediente();limpiarCampos();timer_load();
			validaFechaFinesSem(document.expedientef.fec_apert);"  
	onKeyPress="timer_reload();" 
	onClick="timer_reload();">
<FORM action="ExpedienteArch.jsp" name="expedientef" method="post">
<INPUT type="hidden" value="" name="accion">
<INPUT type="hidden" value="<%=strpasaAnio%>" name="pasaanio">
<INPUT type="hidden" value="<%=ano_AT%>" name="ano_AT2">
<INPUT type="hidden" value="<%=ano_AC%>" name="ano_AC2">
<INPUT type="hidden" value="<%=strtotaldisp%>" name="totaldisp2">
<INPUT type="hidden" value="" name="ct" id="ct">
<INPUT type="hidden" value="" name="clvExpdic" id="clvExpdic">
<INPUT type="hidden" value="<%=strIdSubfondo%>" name="id_sub">
<INPUT type="hidden" value="<%=strAux%>" name="aux">
<INPUT type="hidden" value="<%=strAux2%>" name="aux2">
<INPUT type="hidden" value="<%=strAux3%>" name="aux3">
<INPUT type="hidden" value="" name="consec" id="consec">
<INPUT type="hidden" value="<%=cve_UA%>" name="cve_UA2">
<INPUT type="hidden" value="<%=ced_tip%>" name="ced_tip2">
<INPUT type="hidden" value="<%=cls%>" name="cls2">
<INPUT type="hidden" value="" name="sisi" id="sisi">
<INPUT type="hidden" value="<%=strClasifInf%>" name="idclsinf2">
<INPUT type="hidden" value="<%=retURI%>" name="retURI">
<%if(valida == 2){
		strsoloDesc = "1";
	}
	%>
<INPUT type="hidden" value="<%=strsoloDesc%>" name="soloDesc">
<br>
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="125"><a href="<%= retURI %>"> <IMG
				border="0" src="../Imagenes/NavLeft.gif" title="Regresar"> </a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a><img	src="../Imagenes/Save.gif" title="Guardar"	onclick="GuardarExpediente()"></a>
			</TD>
			<TD width="125">

			</TD>
			<TD width="125">&nbsp;</TD>
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


<DIV class="documentBody" id="Body" style="HEIGHT: 441px">
<DIV align="center">
<DIV align="center">
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD colspan="2" width="168"><B><FONT face="Verdana" color="#00204f"
				size="2"><FONT size="+1" color="#004080">Expedientes</FONT></FONT></B></TD>
			<TD width="68">&nbsp;</TD>
			<TD width="436" align="right">&nbsp;**Los datos marcados con negritas son obligatorios</TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD width="168" colspan="2"></TD>
			<TD width="68"></TD>
			<TD width="436" align="right"></TD>
		</TR>
		<TR valign="top" bgcolor="#004080">
			<TD width="168" colspan="2"></TD>
			<TD width="68"></TD>
			<TD width="436" align="right"></TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE cellspacing="0" cellpadding="0" border="0">
	<TBODY>
		<TR valign="top">
			<TD width="144"><FONT face="Verdana" size="2">&nbsp;</FONT></TD>
			<% if(strIdSubfondo != null && strIdSubfondo.trim().length()>0){ %>
			<TD width="528" align="right"><FONT face="Verdana" size="2">Última modificación por: 
			<I><%=ActualizaUsuario.NombreUsuario(strUsrActualiza)%> - <%= strFecha %></I></FONT>
			</TD>
			<% }else{ %>
			<TD width="528" align="right"><FONT face="Verdana" size="2">Creado por: 
			<I><%= BUsuario.getNombre() %> - <%= strFecha %></I></FONT>
			</TD>
			<% } %>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080"><FONT face="Verdana" size="2">Unidad Administrativa:
			</FONT></FONT></B></TD>
			<TD width="528">
			<%if(valida == 2 || (strIdSubfondo != null && strIdSubfondo.trim().length()>0)){%>
				<% if(BUsuario.getSupervisor() && !cat.equalsIgnoreCase("1")){ %>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="cve_UA"
				disabled="true"
				classHtml="blue500" selected="<%=cve_UA%>"
				textoNoSeleccion="---------- Selecciona Área ----------" valorNoSeleccion=""
				script="onchange='reload();'" />
				<%}else{%>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo() %>" size="1" name="cve_UA"
				disabled="true"
				classHtml="blue500" selected="<%=cve_UA%>"
				textoNoSeleccion="---------- Selecciona Área ----------" valorNoSeleccion=""
				script="onchange='reload();'" />
				<%}%>
			<%}else{%>
				<% if(BUsuario.getSupervisor() && !cat.equalsIgnoreCase("1")){ %>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo(BUsuario.getIdArea()) %>" size="1" name="cve_UA"
				classHtml="blue500" selected="<%=cve_UA%>"
				textoNoSeleccion="---------- Selecciona Área ----------" valorNoSeleccion=""
				script="onchange='reload();'" />
				<%}else{%>
				<meve_combo:comboseleccion
				data="<%= ComboData.getAreasCombo() %>" size="1" name="cve_UA"
				classHtml="blue500" selected="<%=cve_UA%>"
				textoNoSeleccion="---------- Selecciona Área ----------" valorNoSeleccion=""
				script="onchange='reload();'" />
				<%}%>
			<%}%>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Area:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT name="areatxt" value="<%=strareatxt%>" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>			
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>		
				type="text" class="blue500" maxlength="500">
			</TD>
		</TR>			
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
			<TD width="528">&nbsp;</TD>
		</TR>

		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			Fecha de Apertura:</FONT></B></TD>
			<TD colspan="3">
			<FONT face="Verdana" size="2">
				<INPUT type="text" size="5" name="fec_apert" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>			
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>		
				 maxlength="10"  class="blue100" value="<%=fec_apert%>" onblur="validaFormatoFechaEx();" 
					 onKeyPress="AceptaSoloTeclaNumericaYDiagonal();">
			</FONT>
			<A><IMG height="20" src="../Imagenes/act_calFormat.gif"  width="20" border="0" 
						<%if(valida != 2) 
						{%>
						onclick='asignavalor();show_calendar("forms[0].fec_apert");'
						<%
						}%>
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							
						<%	}%>		
			></A>&nbsp;<FONT face="Arial" color="#004080" size="1"> dd/mm/aaaa</FONT><BR>
        </TD> 
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Cédula Tipo:</FONT></B></FONT></TD>
			<TD width="528">
			<%if(valida == 2  || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){ %>
					<meve_combo:comboseleccion 
						data="<%= ComboData.getCedCombo(cve_UA) %>" size="1" name="ced_tip"
						classHtml="blue500" selected="<%= ced_tip %>"
						disabled="true"
						textoNoSeleccion=" ---------- Seleccione una Cédula Tipo --------- "
						valorNoSeleccion="-1" 
						script="onchange='ponerfecha();'"/>
					<%} 
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getCedCombo(cve_UA) %>" size="1" name="ced_tip"
						classHtml="blue500" selected="<%= ced_tip %>"
						disabled="true"
						textoNoSeleccion=" ---------- Seleccione una Cédula Tipo --------- "
						valorNoSeleccion="-1" 
						script="onchange='ponerfecha();'"/>
					<%}%>
			<%}else{%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){ %>
					<meve_combo:comboseleccion
						data="<%= ComboData.getCedCombo(cve_UA) %>" size="1" name="ced_tip"
						classHtml="blue500" selected="<%= ced_tip %>"
						textoNoSeleccion=" ---------- Seleccione una Cédula Tipo --------- "
						valorNoSeleccion="-1" 
						disabled="true"
						script="onchange='ponerfecha();'"/>
					<%} 
					else { %>
					<meve_combo:comboseleccion
						data="<%= ComboData.getCedCombo(cve_UA) %>" size="1" name="ced_tip"
						classHtml="blue500" selected="<%= ced_tip %>"
						textoNoSeleccion=" ---------- Seleccione una Cédula Tipo --------- "
						valorNoSeleccion="-1" 
						script="onchange='ponerfecha();'"/>
					<%}%>
			<%}%>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>
			<INPUT type="button" 
						<%if(valida == 2 ) 
						{%>
						disabled="disabled"
						<%
						}%>
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>		
			onclick="document.getElementById('pop10').style.visibility='visible';" class="s-dropdown-btn">
			<DIV class="popup" id="pop10">
				<IFRAME src="#" width="700" height="200" frameborder="1" id="detalle2"></IFRAME>
			</DIV>
			&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Clave:</FONT></B></FONT><BR>
			<%if(bInsertar1 == 2){ %><B><FONT color="red">*Esta clave ya existe*</FONT>
			</B><%} %>
			</TD>
			<TD width="528">
				<INPUT name="clave" value="<%=strClave%>" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>		
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
				MAXLENGTH="200" type="text" class="blue500" onkeypress="NoAceptaCaracter()" readonly="readonly">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>			
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Identificador Interno:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT name="interno"  
				value="<%=strinterno%>" type="text" 
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>	
					<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
				class="blue500" maxlength="200" >
			</TD>
		</TR>		
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Ubicación Topográfica:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT name="ubica" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>		
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
				value="<%=strUbica%>" type="text" class="blue500" maxlength="200">
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Ubicación Fisica:</FONT></B></FONT></TD>
			<TD width="528">
			<%if(valida == 2  || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboUbi(cve_UA) %>" size="1" name="UbicaFis"
						classHtml="blue500" selected="<%=strUbicaFis%>"
						disabled="true"
						textoNoSeleccion=" ---------- Seleccione una Ubicación Fisica --------- "
						valorNoSeleccion="-1" 
						script=""/>
					<%} 
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboUbi(cve_UA) %>" size="1" name="UbicaFis"
						classHtml="blue500" selected="<%=strUbicaFis%>"
						disabled="true"
						textoNoSeleccion=" ---------- Seleccione una Ubicación Fisica --------- "
						valorNoSeleccion="-1" 
						script=""/>
					<%}%>
			<%}else{%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboUbi(cve_UA) %>" size="1" name="UbicaFis"
						classHtml="blue500" selected="<%=strUbicaFis%>"
						textoNoSeleccion=" ---------- Seleccione una Ubicación Fisica --------- "
						valorNoSeleccion="-1" 
						script=""/>
					<%} 
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getComboUbi(cve_UA) %>" size="1" name="UbicaFis"
						classHtml="blue500" selected="<%=strUbicaFis%>"
						textoNoSeleccion=" ---------- Seleccione una Ubicación Fisica --------- "
						valorNoSeleccion="-1" 
						script=""/>
					<%}%>
			<%}%>				
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
			<TD width="528">&nbsp;</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Denominacion:</FONT></B></FONT></TD>
			<TD width="528">
				<INPUT name="denom"  
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>		
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
				value="<%=strdenom%>" type="text" class="blue500" maxlength="200" >
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Descripción:</FONT></B></FONT></TD>
			<TD width="528">
				<TEXTAREA name="subSeccion" rows="3" cols="65" 
					onKeyDown="limitaTextArea(document.expedientef.subSeccion,'Descripción','4000');"
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
					class="blue500"><%=strSeccion%></TEXTAREA>				
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>		
			<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Valoración:</FONT></B></FONT></TD>
			<TD width="528">
			<%if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) ){%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getValorComboSub(voice) %>" size="1" name="valor"
						classHtml="blue500" selected="<%= strValor %>"
						textoNoSeleccion=" ------------ Seleccione una Valoración------------ "
						valorNoSeleccion="-1" 
						disabled="true" 
						script="onchange=''"/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getValorComboSub(voice) %>" size="1" name="valor"
						classHtml="blue500" selected="<%= strValor %>"
						textoNoSeleccion=" ------------ Seleccione una Valoración------------ "
						valorNoSeleccion="-1" 
						disabled="true" 
						script="onchange=''"/>
					<%}%>
			<%}else{%>
					<%if (strIdSubfondo != null && strIdSubfondo.trim().length()>0){%>
					<meve_combo:comboseleccion
						data="<%= ComboData.getValorComboSub(voice) %>" size="1" name="valor"
						classHtml="blue500" selected="<%= strValor %>"
						textoNoSeleccion=" ------------ Seleccione una Valoración------------ "
						valorNoSeleccion="-1" 
						script="onchange=''"/>
					<%}
					else {%>
					<meve_combo:comboseleccion
						data="<%=ComboData.getValorComboSub(voice)%>" size="1" name="valor"
						classHtml="blue500" selected="<%= strValor %>"
						textoNoSeleccion=" ------------ Seleccione una Valoración------------ "
						valorNoSeleccion="-1" 
						script="onchange=''"/>
					<%}%>
			<%}%>
			</TD>
		</TR>		
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD colspan="2"><B><FONT face="Verdana" size="2" color="#004080">
			VIGENCIA POR DISPOSICION:</FONT></B></TD>
			<TD colspan="3">
			<FONT face="Verdana" size="2">
			</FONT>
        </TD> 
        </TR>		
			<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			- Año AT:</FONT></B></TD>
			<TD width="528">
				<INPUT name="ano_AT" id="ano_AT" value="<%=ano_AT%>" type="text" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>				
				id="ano_AT" class="blue100" onblur="sum()"
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			- Año AC:</FONT></B></TD>
			<TD width="528">
				<INPUT name="ano_AC" id="ano_AC" value="<%=ano_AC%>" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>			
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
				type="text" id="ano_AC" class="blue100" onblur="sum()"
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			- Consulta SISI:</FONT></B></TD>
			<TD width="528">
			<INPUT type=checkbox  value="1"  onclick="unudisp();sum2();totalclsif();"
				<%if(strsisiConsuldisp == "1" || strsisiConsuldisp.equals("1")) 
					{%>	 checked<%}%>
				<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
					disabled="disabled"
				<%	}%>	
				<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
				name="sisiConsuldisp">
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			- Vigencia Total:</FONT></B></TD>
			<TD width="528">
				<INPUT name="totaldisp" value="<%=strtotaldisp%>" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>			
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
				type="text"  class="blue100"
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			<B>Clasificación de Información:</B></FONT></FONT></TD>
			<TD width="528">
			<%if(valida == 2 || (strInact.trim().length()>0 && Integer.parseInt(strInact) == 3)){%>
				<% if(BUsuario.getSupervisor()){ %>
				<meve_combo:comboseleccion
				data="<%= ComboData.getClasifInfCombo() %>" size="1" name="idclsinf"
				disabled="true"
				classHtml="blue500" selected="<%=strClasifInf%>"
				textoNoSeleccion="---------- Clasificacion Informacion ----------" valorNoSeleccion=""
				script="onchange='cambio();'" />
				<%}else{%>
				<meve_combo:comboseleccion
				data="<%= ComboData.getClasifInfCombo() %>" size="1" name="idclsinf"
				disabled="true"
				classHtml="blue500" selected="<%=strClasifInf%>"
				textoNoSeleccion="---------- Clasificacion Informacion ----------" valorNoSeleccion=""
				script="onchange='cambio();'" />
				<%}%>
			<%}else{%>
				<% if(BUsuario.getSupervisor()){ %>
				<meve_combo:comboseleccion
				data="<%= ComboData.getClasifInfCombo() %>" size="1" name="idclsinf"
				classHtml="blue500" selected="<%=strClasifInf%>"
				textoNoSeleccion="---------- Clasificacion Informacion ----------" valorNoSeleccion=""
				script="onchange='cambio();'" />
				<%}else{%>
				<meve_combo:comboseleccion
				data="<%= ComboData.getClasifInfCombo() %>" size="1" name="idclsinf"
				classHtml="blue500" selected="<%=strClasifInf%>"
				textoNoSeleccion="---------- Clasificacion Informacion ----------" valorNoSeleccion=""
				script="onchange='cambio();'" />
				<%}%>
			<%}%>
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
			<TD width="528">&nbsp;</TD>
		</TR>		
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Fundamento Jurídico:</FONT></B></FONT></TD>
			<TD width="528">
			<textarea name="fundamento" rows="8" cols="60"  
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>		
			onKeyDown="limitaTextArea(document.expedientef.fundamento,'Descripción','200')"><%=strfundamento%></textarea>			
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Motivacion:</FONT></B></FONT></TD>
			<TD width="528">
			<textarea name="motivo" rows="8" cols="60"  
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>		
			onKeyDown="limitaTextArea(document.expedientef.motivo,'Descripción','200')"><%=strmotivo%></textarea>			
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B><FONT face="Verdana" size="2">
			Observaciones:</FONT></B></FONT></TD>
			<TD width="528">
			<textarea name="observ" rows="8" cols="60"  
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>		
			onKeyDown="limitaTextArea(document.expedientef.observ,'Descripción','200')"><%=strobserv%></textarea>			
			</TD>
		</TR>	
		
        <TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;</TD>
		</TR>	
		<TR valign="top">
			<TD  colspan="4" ><B><FONT face="Verdana" size="2" color="#004080">
			VIGENCIA POR CLASIFICACIÓN:</FONT></B></TD>
        </TR>		
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			- Años Reserva:</FONT></B></TD>
			<TD width="528">
				<INPUT name="anioresv" id="anioresv" value="<%=stranioresv%>" type="text" onkeyup="validaAniosRerv();real();" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>		
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>			
				 class="blue100" 
				 onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			- Reserva Real:</FONT></B></TD>
			<TD width="528">
				<INPUT name="anioreal" id="anioreal" value="<%=stranioreal%>" onkeyup="validaAniosRerv();real();" 
						onfocus="blur();"
						<%if(ver!="si") {%>
						disabled="disabled"
						<%
						}%>	
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>			
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>		
	
				type="text"  class="blue100" 
					onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			- Consulta SISI:</FONT></B></TD>
			<TD width="528">
			<INPUT type=checkbox  onclick="totalclsif();une();" value="1"  
				<%if(sisiConsulcls == "1" || sisiConsulcls.equals("1")) 
				{%>	 
				checked
				<%}%>	
				<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
					disabled="disabled"
				<%	}%>		
				<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
				name="sisiConsulcls" >
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			- Vigencia Total:</FONT></B></TD>
			<TD width="528">
				<INPUT name="totalcls" id="totalcls" value="<%=strtotalcls%>" 
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>		
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>				
				type="text" class="blue100"
				onkeypress = "AceptaSoloTeclaNumericaYPunto();">
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"></TD>
			<TD width="528">
				<INPUT type="hidden" value="<%=strano_Amp%>" name="ano_Amp" id="ano_Amp">
			</TD>
		</TR>
		<tr valign="top">
		<td colspan="2">
		</td>
		</tr>
		<TR valign="top">
			<TD width="144"><B><FONT color="#004080">&nbsp;</FONT></B></TD>
			<TD width="528">&nbsp;</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><B><FONT face="Verdana" size="2" color="#004080">
			Periodo Total de Guarda:</FONT></B></TD>
			<TD width="528">
				<INPUT name="anioguard"  value="<%=stranioguard%>" 
						onfocus="blur();"
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>	
						<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>	
				type="text" id="ano_guard" class="blue100">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144">&nbsp;</TD>
			<TD width="528">&nbsp;
				<%if(ver=="si" || ver.equalsIgnoreCase("si")) {%>
				<IFRAME src="Acomulable.jsp?ida=<%=strIdSubfondo%>&num=1&soloDesc=<%=strsoloDesc%>" WIDTH=400 HEIGHT=100 frameborder=0 id="acom"></IFRAME>
				<%
				}%>	
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			Cerrado:</FONT></FONT></TD>
			<TD width="528">
				<INPUT type=checkbox onclick="habilita2()" value="3" 
						<%if(strInact == "3" || strInact.equals("3")) 
						{%>
						 checked
					       	<%
						}%>	
						<%if(ver!="si") {%>
						disabled="disabled"
						<%
						}%>	
						<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
							disabled="disabled"
						<%	}%>		

				name="inactivo">
			</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>	
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			Fecha Cierre:</FONT></FONT></TD>
			<TD width="528">
				<INPUT name="fecinact" value="<%=strFecInac%>"
					onfocus="blur();"
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
						disabled="disabled"
					<%	}%>		
					<%if(valida == 2) 
						{%>
						disabled="disabled"
						<%
						}%>
				type="text" class="blue100" maxlength="200">
			</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><B>&nbsp;</B></FONT></TD>
			<TD width="528">&nbsp;</TD>
		</TR>
		<TR valign="top">
			<TD width="144"><FONT color="#004080"><FONT face="Verdana" size="2">
			Justificacion:</FONT></FONT></TD>
			<TD width="528">
				<TEXTAREA name="justif" id="justif" rows="3" cols="65" 
					onKeyDown="limitaTextArea(document.expedientef.justif,'Justificación','1000');"
					disabled="disabled"
					<%if(valida == 2) 
					{%>
					disabled="disabled"
					<%
					}%>
					<%if(ver!="si") {%>
					disabled="disabled"
					<%
					}%>	
					<%if(strInact.trim().length()>0 && Integer.parseInt(strInact) == 3) {%>
		
						disabled="disabled"
					<%	}%>
					class="blue500"><%=strJustInac%></TEXTAREA>
			</TD>
		</TR>						
	</TBODY>
</TABLE>
<BR>
<BR>
</DIV>
</DIV>
</DIV>
</FORM>
</BODY>
</HTML>