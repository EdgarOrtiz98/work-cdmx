package com.meve.sigma.sql;




public class SQLConsultas 
{
	/******************************************************
	 * 
	 */
	public static String getRegistroUsuario(String strNickname,String strPassword)
	{
		String strSql="";
		
		strSql=	" SELECT * FROM USUARIOS WHERE " +
				" NICKNAME 		= '" + strNickname + "'" +
				" AND PASSWORD	= '" + strPassword + "'";
		
		return strSql;
	}
	
	/******************************************************
	 * 
	 */
	public static String getModificarRegistro(String strNickname,String strPassword,String strNombre,
											  String strApePaterno, String strApeMaterno, String strEdad)
	{
		String strSql="";
		
		strSql=	" UPDATE USUARIOS SET "	+
				" PASSWORD		= '"	+	strPassword		+ "',"	+
				" NOMBRE		= '"	+	strNombre		+ "',"	+
				" APE_PATERNO	= '"	+	strApePaterno 	+ "',"	+
				" APE_MATERNO	= '"	+	strApeMaterno 	+ "',"	+
				" EDAD			= "		+	strEdad 		+ 
				" WHERE NICKNAME = '"	+	strNickname		+ "'";
		
		return strSql;
	}
	
	/******************************************************
	 * 
	 */
	public static String getBorrarRegistro(String strNickname,String strPassword)
	{
		String strSql="";
		
		strSql=	" DELETE FROM USUARIOS WHERE "	+
				" NICKNAME		='"	+	strNickname	+	"'"	+
				" AND PASSWORD	='"	+	strPassword	+	"'";
		
		return strSql;
	}
	
	/******************************************************
	 * 
	 */
	public static String getInsertarRegistro(String strNickname,String strPassword,String strNombre,
											 String strApePaterno, String strApeMaterno, String strEdad)
	{
		String strSql="";
		
		strSql=	" INSERT INTO USUARIOS(NICKNAME,PASSWORD,NOMBRE,APE_PATERNO,APE_MATERNO,EDAD) VALUES " +
				" ('"	+	strNickname		+
				"','"	+	strPassword		+
				"','"	+	strNombre		+
				"','"	+	strApePaterno	+
				"','"	+	strApeMaterno	+
				"',"	+	strEdad			+")";
		
		return strSql;
	}
	
	/******************************************************
	 * 
	 */
	public static String getInsertaArchivo(String strNickname,String strNombreArchivo,String strContentType)	
	{
		String strSql="";
		
		strSql=	" INSERT INTO ARCHIVOS(NICKNAME,NOMBRE_ARCHIVO,CONTETNTYPE,ARCHIVO) VALUES "	+
				" ('"	+	strNickname			+
				"','"	+	strNombreArchivo	+
				"','"	+	strContentType		+
				"',?)";
		
		return strSql;
	}
	
	/******************************************************
	 * 
	 */
	public static String getBorrarArchivos(String strNickname)
	{
		String strSql="";
		
		strSql=	" DELETE FROM ARCHIVOS WHERE NICKNAME='"+strNickname +"'";
		
		return strSql;
	} 
	
	public static String getArchivosUsuario(String strNickname)
	{
		String strSql="";
		
		strSql=	" SELECT NOMBRE_ARCHIVO FROM ARCHIVOS WHERE NICKNAME='"+strNickname+"'";
		
		return strSql;
	}
	
	public static String getArchivoBinario(String strNickname,String strNombreArchivo)
	{
		String strSql="";
		
		strSql=	" SELECT ARCHIVO FROM ARCHIVOS WHERE " 				+
				" NICKNAME				='"	+	strNickname			+	"'"	+
				" AND NOMBRE_ARCHIVO	='"	+	strNombreArchivo	+	"'";
		
		return strSql;
	}
	
	public static String getContentType(String strNickname,String strNombreArchivo)
	{
		String strSql="";
		
		strSql=	" SELECT CONTETNTYPE FROM ARCHIVOS WHERE "			+
				" NICKNAME				='"	+	strNickname			+	"' "	+
				" AND NOMBRE_ARCHIVO	='"	+	strNombreArchivo	+	"'";
		
		return strSql;
	}



	public static String getCombo(String strNombre)
	{
		String strSql="";
		
		strSql=	" SELECT * FROM USUARIOS WHERE "			+
				" NOMBRE				='"	+	strNombre			+	"'";
		
		return strSql;
	}
	
	public static String setUsuario(String strNombre,String strArea,String strEmail,String strTelefono,String strRol,String strJefe)
	{
		String strSql="";
		
		strSql=	" INSERT INTO USUARIOS (NOMBRE,AREA,EMAIL,TELEFONO,ROL,JEFE) VALUES  "	+
				" ('"	+	strNombre 	+
				"','"	+	strArea		+
				"','"	+	strEmail	+
				"','"	+	strTelefono	+
				"','"	+	strRol		+
				"','"	+	strJefe		+
				"')";
				//System.out.print(strSql);
		return strSql;
	}
	
	public static String setFlujoAtencion(String strTipodocumento,String strTipoasunto,String strArea,String strNombre,String strInstruccion,String strTipoatencion,int strPaso,int strTiempoResp)
	{
		String strSql="";
		
		strSql=	" INSERT INTO FLUJOATENCION (TIPODOCUMENTO,TIPOASUNTO,AREA,NOMBRE,INSTRUCCION,TIPOATENCION,PASO,TIEMPORESPUESTA) VALUES  "	+
				" ('"	+	strTipodocumento 	+
				"','"	+	strTipoasunto		+
				"','"	+	strArea	+
				"','"	+	strNombre	+
				"','"	+	strInstruccion		+
				"','"	+	strTipoatencion		+
				"',"	+	strPaso		+
				","	+	strTiempoResp		+
				")";
				//System.out.print(strSql);
		return strSql;
	}
	
	public static String setInstruccion(String strInstruccion)
	{
		String strSql="";
		
		strSql=	" INSERT INTO INSTRUCCIONES (INSTRUCCION) VALUES  "	+
				" ('"	+	strInstruccion 	+"')";
				//System.out.print(strSql);
		return strSql;
	}
	
	public static String setPrioridad(String strPrioridad,String strHexagecimal)
	{
		String strSql="";
		
		strSql=	" INSERT INTO PRIORIDADES (PRIORIDAD,NOHEXAGECIMAL) VALUES  "	+
				" ('"	+	strPrioridad 	+
				"','"	+	strHexagecimal		+"')";
				//System.out.print(strSql);
		return strSql;
	}
	
	
	public static String setTipoAsunto(String strTipoAsunto)
	{
		String strSql="";
		
		strSql=	" INSERT INTO TIPOASUNTO (TIPOASUNTO) VALUES  "	+
				" ('"	+	strTipoAsunto 	+"')";
				//System.out.print(strSql);
		return strSql;
	}
	
	public static String setFolios(String strArea,String strClave,String strTipo, int strConsecutivo)
	{
		String strSql="";
		
		strSql=	" INSERT INTO FOLIOS (AREA,CLAVE,TIPOFOLIO,CONSECUTIVO) VALUES  "	+
				" ('"	+	strArea		 	+
				"','"	+	strClave	+
				"','"	+	strTipo	+
				"',"	+	strConsecutivo		+ ")";
				//System.out.print(strSql);
		return strSql;
	}
	
	public static String setTipoDocumento(String strTipoDocumento,String strClaveDocumento)
	{
		String strSql="";
		
		strSql=	" INSERT INTO TIPODOCUMENTO (TIPODOCUMENTO,CLAVEDOCUMENTO) VALUES  "	+
				" ('"	+	strTipoDocumento		 	+
				"','"	+	strClaveDocumento		+"')";
				//System.out.print(strSql);
		return strSql;
	}
	
	public static String setRazonesRechazo(String strRazonesRechazo)
	{
		String strSql="";
		
		strSql=	" INSERT INTO RAZONESRECHAZO (RAZONRECHAZO) VALUES  "	+
				" ('"	+	strRazonesRechazo		 	+"')";
				//System.out.print(strSql);
		return strSql;
	}
	
	
	public static String setDiaFestivo(String strDiaFestivo,String strDescripcion)
	{
		String strSql="";
		
		strSql=	" INSERT INTO DIAFESTIVO (DIAFESTIVO,DESCRIPCION) VALUES  "	+
				" ('"	+	strDiaFestivo		 	+
				"','"	+	strDescripcion		+"')";
				//System.out.print(strSql);
		return strSql;
		
	}
	public static String setRemitente(String strRemitente,String strCargo,String strEntidad,String strTelefono,String strCorreo)
	{
		String strSql="";
		
		strSql=	" INSERT INTO REMITENTE (NOMBRE,CARGO,ENTIDAD,TELEFONO,CORREO) VALUES  "	+
				" ('"	+	strRemitente 	+
				"','"	+	strCargo		+
				"','"	+	strEntidad	+
				"','"	+	strTelefono	+
				"','"	+	strCorreo		+"')";
				//System.out.print(strSql);
		return strSql;
	
	}
	
				
	public static String setArea(String strArea,String strResponsable,String strRemitentes,String strExpedientes,String strUbicacion,String strEntidad,String strClave,String strConsecutivo)
	{
		String strSql="";
		
		strSql=	" INSERT INTO AREA (AREA,RESPONSABLE,REMITENTES,EXPEDIENTES,UBICACION,ENTIDADES,CLAVE,CONSECUTIVO) VALUES  "	+
				" ('"	+	strArea 	+
				"','"	+	strResponsable		+
				"','"	+	strRemitentes	+
				"','"	+	strExpedientes	+
				"','"	+	strUbicacion	+
				"','"	+	strEntidad		+
				"','"	+	strClave		+
				"',"	+	strConsecutivo	+")";
				//System.out.println(strSql);
		return strSql;
	
	}
	
	public static String setEntidad(String strEntidad,String strDireccion,String strTelefono)
	{
		String strSql="";
		
		strSql=	" INSERT INTO ENTIDAD (ENTIDAD,DIRECCION,TELEFONO) VALUES  "	+
				" ('"	+	strEntidad 	+
				"','"	+	strDireccion		+
				"','"	+	strTelefono	+"')";
				//System.out.print(strSql);
		return strSql;
	
	}
	public static String getUsuarios()
	{
		String strSql="";
		
		strSql= "SELECT NOMBRE FROM USUARIOS ORDER BY NOMBRE";
		return strSql;
	}

	public static String getUsuariosCompleto(String Usuario)
	{
		String strSql="";
		
                strSql= "SELECT NOMBRE, AREA, TELEFONO, EMAIL FROM USUARIOS WHERE NOMBRE = '"+Usuario+"'";
		//System.out.println(strSql);
		return strSql;
	}
	

	
	public static String getArea()
	{
		String strSql="";
		
		strSql= "SELECT AREA FROM AREA ORDER BY AREA";
                
		//System.out.print(strSql);
		return strSql;
	}

	public static String getTipoAsunto()
	{
		String strSql="";
		
		strSql= "SELECT TIPOASUNTO FROM TIPOASUNTO ORDER BY TIPOASUNTO";
		return strSql;
	}
	
	public static String getTipoDocumento()
	{
		String strSql="";
		
		strSql= "SELECT TIPODOCUMENTO FROM TIPODOCUMENTO ORDER BY TIPODOCUMENTO";
		//System.out.print(strSql);
		return strSql;
	}
	
////////////////////////////////Asuntos/////////////////////////

	
	public static String getEntidad()
	{
		String strSql="";
		
		strSql= "SELECT ENTIDAD FROM ENTIDAD ORDER BY ENTIDAD";
		//System.out.print(strSql);
		return strSql;
	}
		
		public static String getRemitente()
	{
		String strSql="";
		
		strSql= "SELECT NOMBRE FROM REMITENTE ORDER BY NOMBRE";
		//System.out.print(strSql);
		return strSql;
	}
		
		public static String getFlujoAtencion()
	{
		String strSql="";
		
		strSql= "SELECT NOMBRE FROM FLUJOATENCION ORDER BY NOMBRE";
		//System.out.print(strSql);
		return strSql;
	}
	
			public static String getUbicacion()
	{
		String strSql="";
		
		strSql= "SELECT UBICACION FROM AREA ORDER BY UBICACION";
		//System.out.print(strSql);
		return strSql;
	}
	
			public static String getExpedientes()
	{
		String strSql="";
		
		strSql= "SELECT EXPEDIENTES FROM AREA ORDER BY EXPEDIENTES";
		//System.out.print(strSql);
		return strSql;
	}

			public static String getDiaFestivo()
	{
		String strSql="";
		
		strSql= "SELECT DIAFESTIVO FROM DIAFESTIVO ORDER BY DIAFESTIVO";
		//System.out.print(strSql);
		return strSql;
	}	
	
				public static String getPrioridad()
	{
		String strSql="";
		
		strSql= "SELECT PRIORIDAD FROM PRIORIDADES ORDER BY PRIORIDAD";
		//System.out.print(strSql);
		return strSql;
	}

				public static String getInstrucciones()
	{
		String strSql="";
		
		strSql= "select instruccion from instrucciones order by instruccion";
		//System.out.print(strSql);
		return strSql;
	}
	
				public static String getRazonRechazo()
	{
		//String strSql = " select razonrechazo from razonesrechazo order by razonrechazo";
                String strSql = " SELECT RAZONRECHAZO FROM RAZONESRECHAZO ORDER BY RAZONRECHAZO";
		//System.out.println(strSql);
		return strSql;
	}
			
			public static String setAsuntos(String strEntidad,String strEntidad2,String strRemitente,String strRemitente2,String strCargo,String strRemitenteEmail,String strPortador,String strAsunto,String strUbicacion,String strTipoDocumento,String strTipoDocumento2,String strFechaDoc,String strFolioExt,String strFechaCad,String strFolioInter,String strSintesis,String strExpediente,String strExpediente2,String strPalabrasClave,String strLigarAsunto,String strPrioridad,String strCategoria,String strCategoria2)
	{
		String strSql="";
		
		strSql=	" INSERT INTO ASUNTOS (ENTIDAD,ENTIDAD2,REMITENTE,REMITENTE2,CARGO,REMITENTEEMAIL,PORTADOR,ASUNTO,UBICACION,TIPODOC,TIPODOC2,FECHADOC,FOLIOEXT,FECHACAD,FOLIOINTER,SINTESIS,EXPEDIENTE,EXPEDIENTE2,PALABRASCLAVE,LIGARASUNTO,PRIORIDAD,CATEGORIA,CATEGORIA2) VALUES  "	+
				" ('"	+	strEntidad 			+
				"','"	+	strEntidad2			+
				"','"	+	strRemitente		+
				"','"	+	strRemitente2		+
				"','"	+	strCargo			+
				"','"	+	strRemitenteEmail	+
				"','"	+	strPortador			+
				"','"	+	strAsunto			+
				"','"	+	strUbicacion		+
				"','"	+	strTipoDocumento	+
				"','"	+	strTipoDocumento2	+
				"','"	+	strFechaDoc			+
				"','"	+	strFolioExt			+
				"','"	+	strFechaCad			+
				"','"	+	strFolioInter		+
				"','"	+	strSintesis			+
				"','"	+	strExpediente		+
				"','"	+	strExpediente2		+
				"','"	+	strPalabrasClave	+
				"','"	+	strLigarAsunto		+
				"','"	+	strPrioridad		+
				"','"	+	strCategoria		+
				"','"	+	strCategoria2		+"')";
				//System.out.print(strSql);
		return strSql;
	}
	
	
	public static String getInsertaArchivoAsuntos(String strAsunto,String strNombreArchivo,String strContentType)	
	{
		String strSql="";
		
		strSql=	" INSERT INTO ARCHIVOS (ASUNTO,NOMBRE_ARCHIVO,CONTETNTYPE,ARCHIVO) VALUES "	+
				" ('"	+	strAsunto			+
				"','"	+	strNombreArchivo	+
				"','"	+	strContentType		+
				"',?)";
		
		return strSql;
	}
	
///////////////Consecutivos Globales para Asuntos	////////
				public static String getConsecutivoGlobal()
	{
		String strfolio = "SELECT FOLIO FROM CONTADOR";//"select folio from contador";
		//System.out.print(strfolio);
		return strfolio;
	}
	
				
				public static String setConsecutivoGlobal(int anterior,int nuevo)
	{
		String strSql="";		
		strSql= "UPDATEN CONTADOR SET FOLIO="+nuevo+" WHERE FOLIO="+anterior+"";
		//System.out.print(strSql);
		return strSql;
	}
	
	
//////////////Borrado de Vistas//////////////////////
				
				public static String BorradoVista(String Tabla,String Parametro,String Registro)
	{
		String strSql = " DELETE FROM "+Tabla+" WHERE "+Parametro+"="+Registro+"";
		//System.out.println(strSql);
		return strSql;
		
	}
	
///////////////Verificacion de Elementos no duplicados///////
		
				public static String VerificaArea(String Area)
	{
		String strSql = " SEELCT AREA FROM AREA WHERE AREA='"+Area+"'";
		//System.out.println(strSql);
		return strSql;
		
	}
	
					
					public static String VerificaDiaFestivo(String Dia)
	{
		String strSql = " SELECT DIAFESTIVO FROM DUAFESTIVO WHERE DIAFESTIVO='"+Dia+"'";
		////System.out.println("verificacion:"+ strSql);
		return strSql;
		
	}
	
						public static String VerificaEntidad(String Entidad)
	{
		String strSql = " SELECT ENTIDAD FROM ENTIDAD WHERE ENTIDAD='"+Entidad+"'";
		//System.out.println(strSql);
		return strSql;
		
	}
	
//pendiente
							public static String VerificaFlujo(String Flujo)
	{
		String strSql = " SELECT INSTRUCCION FROM INSTRUCCIONES WHERE INSTRUCCION='"+Flujo+"'";
		//System.out.println(strSql);
		return strSql;
		
	}
							public static String VerificaInstruccion(String Instruccion)
	{
		String strSql = " SELECT INSTRUCCION FROM INSTRUCCIONES WHERE INSTRUCCION='"+Instruccion+"'";
		//System.out.println(strSql);
		return strSql;
		
	}

							public static String VerificaPrioridad(String Prioridad)
	{
		String strSql = " SELECT PRIORIDAD FROM PRIORIDADES WHERE PRioridad='"+Prioridad+"'";
		//System.out.println(strSql);
		return strSql;
		
	}

								public static String VerificaRazonRechazo(String Razon)
	{
		String strSql = " SELECT RAZONRECHAZO FROM RAZONESRECHAZO WHERE RAZONRECHAZO='"+Razon+"'";
		//System.out.println(strSql);
		return strSql;
		
	}
									public static String VerificaRemitente(String Remitente)
	{
		String strSql = " SEELCT NOMBRE FROM REMITENTE WHERE NOMBRE='"+Remitente+"'";
		//System.out.println(strSql);
		return strSql;
		
	}
	
									public static String VerificaTipoAsunto(String Tipo)
	{
		String strSql = " SELECT TIPOASUNTO FROM TIPOASUNTO WHERE TIPOASUNTO='"+Tipo+"'";
		//System.out.println(strSql);
		return strSql;
		
	}
									public static String VerificaTipoDoc(String TipoDoc)
	{
		String strSql = " SELECT TIPODOCUMENTO FROM TIPODOCUMENTO WHERE TIPODOCUMENTO='"+TipoDoc+"'";
		//System.out.println(strSql);
		return strSql;
		
	}
									public static String VerificaUsuario(String Usuario)
	{
		String strSql = " SELECT NOMBRE FROM USUARIOS WHERE NOMBRE='"+Usuario+"'";
		//System.out.println(strSql);
		return strSql;
		
	}
	
	public static String replace (String target, String from, String to) {
	// target is the original string
	// from is the string to be replaced
	// to is the string which will used to replace
			int start = target.indexOf (from);
			if (start==-1) return target;
			int lf = from.length();
			char [] targetChars = target.toCharArray();
			StringBuffer buffer = new StringBuffer();
			int copyFrom=0;
			while (start != -1) {
			buffer.append (targetChars, copyFrom, start-copyFrom);
			buffer.append (to);
			copyFrom=start+lf;
			start = target.indexOf (from, copyFrom);
			}
			buffer.append (targetChars, copyFrom, targetChars.length-copyFrom);
			return buffer.toString();
	}
}//fin de public class SQLConsultas 
	