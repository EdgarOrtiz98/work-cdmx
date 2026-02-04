
	var botonBandera = true;	

	function alfaNumerico(ob){
		var ok=false;
		var texto=ob.value
		var codigo=texto.charCodeAt(texto.length-1);
		if( (codigo>=48&&codigo<=57)||(codigo>=65&&codigo<=90)||(codigo>=97&&codigo<=122)||(codigo==32)
		   )
			ok=true;
		if(!ok){
			texto=texto.substring(0,texto.length-1);
			ob.value=texto;
		}
	}
	var hay_hija = new Boolean(false);
	var hija = new Object(); 
	var bandera = <%= strBandera %>;

	function resetTimer(){
		timer_reload();
	}
	function AbrirAnex(idAsunto, ids, refs){
		bandera = "false"; //document.Asunto.strBandera.value;
		var isCenter ='true';
		var features = '';

		if(bandera == "true"){
			if(confirm("Al Seleccionar esta opci\xF3n, los cambios que no hayan sido guardados se perderan,\n¿Deseas continuar?")){
				if(window.screen)if(isCenter)if(isCenter=="true"){
				    var myLeft = (screen.width-760)/2;
				    var myTop = (screen.height-360)/2;
				    features+=(features!='')?',':'';
				    features+=',left='+myLeft+',top='+myTop; 
				}
				//BloquearElementos();
				hija = window.open('AnexarReferencia.jsp?strIdAsunto='+ idAsunto + '&idAsuntoAnt=' + ids + '&idAsuntoRef=' + refs + '&idArea=<%=BUsuario.getIdArea()%>&idUs=<%=BUsuario.getIdUsuario()%>&estValidacion=<%=strEstValidacion%>','hija',features+((features!='')?',':'')+'width=760, height=360, status=yes');
				hay_hija = true; 
			}
		} else{
			if(window.screen)if(isCenter)if(isCenter=="true"){
			    var myLeft = (screen.width-760)/2;
			    var myTop = (screen.height-360)/2;
			    features+=(features!='')?',':'';
			    features+=',left='+myLeft+',top='+myTop; 
			}
			//BloquearElementos();
			hija = window.open('AnexarReferencia.jsp?strIdAsunto='+ idAsunto + '&idAsuntoAnt=' + ids + '&idAsuntoRef=' + refs + '&idArea=<%=BUsuario.getIdArea()%>&idUs=<%=BUsuario.getIdUsuario()%>&estValidacion=<%=strEstValidacion%>','hija',features+((features!='')?',':'')+'width=760, height=360, status=yes');
			hay_hija = true; 
		}
	}
	function agregarContent(){
		doc = document.Asunto;
		bandera = document.Asunto.strBandera.value;

		if(doc.id_asunto.value == ""){
			validacionesAsunto11();
		}else{
			if(bandera == "true"){
				if(confirm("Se detectaron cambios en el Asunto.\nPulse Aceptar para guardar los cambios y continuar o\npulse Cancelar para continuar sin guardar los cambios.")){
					guardarAsunto('guardarInsertarArchivo');
				}else{
					location.assign('ImportarCM.jsp?Folio=<%=strFolioGenerado%>&IdAsunto=<%=strIdAsunto%>&a=<%=strA%>&estValidacion=<%=strEstValidacion%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
				}
			} else{
				location.assign('ImportarCM.jsp?Folio=<%=strFolioGenerado%>&IdAsunto=<%=strIdAsunto%>&a=<%=strA%>&estValidacion=<%=strEstValidacion%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
			}
		}
	}
	function agregar() 
	{
		location.assign('ImportarCM.jsp?Folio=<%=strFolioGenerado%>&IdAsunto=<%=strIdAsunto%>&a=<%=strA%>&retURI=<%= Utilerias.codificaPostHTML(strTmp+"?id_asunto="+strIdAsunto+"&retURI="+Utilerias.codificaPostHTML(retURI)) %>');
	}
	function cargaApplet21(){
		validacionesAsunto();
	}
	function cargaApplet1(){
		location.assign('VisualizaInstrucciones.jsp?idAsunto=<%=strIdAsunto%>&Url=<%=URL%>');
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

	function regresarURI(){
		doc = document.Asunto;
		bandera = document.Asunto.strBandera.value;

		if(bandera == "true"){
			if(confirm("Se detectaron cambios en el Asunto.\nPulse Aceptar para guardar los cambios y continuar o\npulse Cancelar para continuar sin guardar los cambios.")){
				guardarAsunto('guardarRegresarURI');
			}else{
				location.assign('<%= retURI %>');
			}
		} else{
			location.assign('<%= retURI %>');
		}
	}

	function ventanaHija(){
		if (hija!= null && hay_hija == true){ 
			try{
				hija.focus(); 
			}catch(err){
				hay_hija = new Boolean(false);
				hija = new Object(); 
			}
		}
	}
