
package com.meve.sigma.reportes;

import java.util.StringTokenizer;
import java.util.Vector;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaAsunto;
import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaPrioridad;
import com.meve.sigma.actualiza.ActualizaTipoAsunto;
import com.meve.sigma.actualiza.ActualizaTipo_Doc;
import com.meve.sigma.actualiza.ActualizaTramite;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.beans.search.ActualizaBuscar;
import com.meve.sigma.util.Utilerias;

/**
 * Bean para exportar los Reportes de Folios de Control
 *
 * @author Meve Soluciones S.A. de C.V.
 */

public class BeanReporteFolioDeControl {
	
	String folio_control;
	String folio_recepcion;
	String folio_externo;
	String asunto;
	String remitente;
	String ua_remitente;
	String tipo_es;
	String destinatarios;
	String avance;
	String fecha_captura;
	String fecha_recepcion;
	String fecha_docto;
	String fecha_compromiso;
	String fecha_terminacion;
	String estatus;
	String docAnexados;
	
	String semaforo;
	String firmante;
	String tipoDocumento;
	String tramite;
	String folioIntermedio;
	String descripcion;
	String expediente;
	String fechaEvento;
	String lugarEvento;
	String prioridad;
	String tipoAsunto;
	String contenidoDocAnexos;
	String relacionesAnexas;
	/*
	Relaciones Anexadas
	semáforo
	*/
		
	

	/**
	 * Llena los campos del Bean con los campos del reporte de Folios de Control
	 * 
	 * @param datos Datos del reporte
	 */

	public void setCampos(String[] datos) {
		if (datos!=null && datos.length>0){
			
			String strIdAsunto = datos[17];
			String folioRecepcion = datos[1];
			
			setFolio_control(datos[0]);
			setFolio_recepcion(datos[1]);
			setFolio_externo(datos[2]);
			setAsunto(datos[3]);
			setRemitente(datos[4]);
			setUa_remitente(datos[5]);
			setTipo_es(datos[6]);
			setAvance(datos[7]);
			setFecha_captura(datos[8]);
			setFecha_recepcion(datos[9]);
			setFecha_docto(datos[10]);
			setFecha_compromiso(datos[11]);
			setFecha_terminacion(datos[12]);
			setEstatus(datos[13]);
			
			if (datos[16].equals("0") || datos[16].equals("1")){
				String dest = "";
				StringTokenizer strToken = new StringTokenizer(datos[14],",");
				while(strToken.hasMoreElements()){
					String strIdUsuario = strToken.nextToken();
					if (strIdUsuario!=null && !strIdUsuario.equals("") && !strIdUsuario.equals("null")){
						dest += ActualizaUsuario.NombreUsuario(strIdUsuario) + "/" + 
						ActualizaUsuario.NombrePuesto(strIdUsuario) + " -- " + 
						ActualizaArea.NombreArea(ActualizaUsuario.getIdAreaUs(strIdUsuario));
						if (strToken.countTokens()!=0){
							dest += "\n";
						}
					}
				}
				strToken = new StringTokenizer(datos[15],",");
				if (strToken.countTokens()>0){
					dest += "\n\n -- Destinatarios CC -- \n";
				}
				while(strToken.hasMoreElements()){
					String strIdUsuario = strToken.nextToken();
					if (strIdUsuario!=null && !strIdUsuario.equals("") && !strIdUsuario.equals("null")){
						dest += ActualizaUsuario.NombreUsuario(strIdUsuario) + "/" + 
						ActualizaUsuario.NombrePuesto(strIdUsuario) + " -- " + 
						ActualizaArea.NombreArea(ActualizaUsuario.getIdAreaUs(strIdUsuario));
						if (strToken.countTokens()!=0){
							dest += "\n";
						}
					}
				}
				setDestinatarios(dest);
				
			}else{
				String dest = "";
				strIdAsunto = datos[17];
				String strPara[][] = ActualizaAsuntoTurnado.getDesPara(strIdAsunto);
				if (strPara!=null && strPara.length>0){
					for (int i=0; i<strPara.length; i++){
						dest += strPara[i][0];
						dest += (i!=strPara.length-1)?"\n":"";
					}
				}
				String strCC[][] = ActualizaAsuntoTurnado.getDesCC(strIdAsunto);
				if (strCC!=null && strCC.length>0){
					dest += "\n\n -- Destinatarios CC -- \n";
					for (int i=0; i<strCC.length; i++){
						dest += strCC[i][0];
						dest += (i!=strCC.length-1)?"\n":"";
					}
				}
				setDestinatarios(dest);
			}
		}
	}
	
	/**
	 * Llena los campos del Bean con los campos del reporte de Folios de Control
	 * 
	 * @param datos Datos de los registros del reporte
	 * @param strResultado Datos para el calculo de semaforos
	 */
	public void setCampos(String[] datos, String[] strResultado) {
		if (datos!=null && datos.length>0){
			
			String strIdAsunto = datos[17];
			String folioRecepcion = datos[1];
			
			setFolio_control(datos[0]);
			setFolio_recepcion(datos[1]);
			setFolio_externo(datos[2]);
			setAsunto(datos[3]);
			setRemitente(datos[4]);
			setUa_remitente(datos[5]);
			setTipo_es(datos[6]);
			setAvance(datos[7]);
			setFecha_captura(datos[8]);
			setFecha_recepcion(datos[9]);
			setFecha_docto(datos[10]);
			setFecha_compromiso(datos[11]);
			setFecha_terminacion(datos[12]);
			setEstatus(datos[13]);
			
			if (datos[16].equals("0") || datos[16].equals("1")){
				String dest = "";
				StringTokenizer strToken = new StringTokenizer(datos[14],",");
				while(strToken.hasMoreElements()){
					String strIdUsuario = strToken.nextToken();
					if (strIdUsuario!=null && !strIdUsuario.equals("") && !strIdUsuario.equals("null")){
						dest += ActualizaUsuario.NombreUsuario(strIdUsuario) + "/" + 
						ActualizaUsuario.NombrePuesto(strIdUsuario) + " -- " + 
						ActualizaArea.NombreArea(ActualizaUsuario.getIdAreaUs(strIdUsuario));
						if (strToken.countTokens()!=0){
							dest += "\n";
						}
					}
				}
				strToken = new StringTokenizer(datos[15],",");
				if (strToken.countTokens()>0){
					dest += "\n\n -- Destinatarios CC -- \n";
				}
				while(strToken.hasMoreElements()){
					String strIdUsuario = strToken.nextToken();
					if (strIdUsuario!=null && !strIdUsuario.equals("") && !strIdUsuario.equals("null")){
						dest += ActualizaUsuario.NombreUsuario(strIdUsuario) + "/" + 
						ActualizaUsuario.NombrePuesto(strIdUsuario) + " -- " + 
						ActualizaArea.NombreArea(ActualizaUsuario.getIdAreaUs(strIdUsuario));
						if (strToken.countTokens()!=0){
							dest += "\n";
						}
					}
				}
				setDestinatarios(dest);
				
			}else{
				String dest = "";
				strIdAsunto = datos[17];
				String strPara[][] = ActualizaAsuntoTurnado.getDesPara(strIdAsunto);
				if (strPara!=null && strPara.length>0){
					for (int i=0; i<strPara.length; i++){
						dest += strPara[i][0];
						dest += (i!=strPara.length-1)?"\n":"";
					}
				}
				String strCC[][] = ActualizaAsuntoTurnado.getDesCC(strIdAsunto);
				if (strCC!=null && strCC.length>0){
					dest += "\n\n -- Destinatarios CC -- \n";
					for (int i=0; i<strCC.length; i++){
						dest += strCC[i][0];
						dest += (i!=strCC.length-1)?"\n":"";
					}
				}
				setDestinatarios(dest);
			}
			
			setFirmante(datos[18]);
			setFolioIntermedio(datos[21]);
			setDescripcion(datos[22]);
			setExpediente(datos[23]);
			setFechaEvento(datos[24]+" "+datos[25]+":"+datos[26]);
			setLugarEvento(datos[27]);
			
			//System.out.println("*********" + folioRecepcion);
			
			if (datos[16].equals("0") || datos[16].equals("1")){
				if(datos[19]!="" && datos[19]!="null"){
					setTipoDocumento((ActualizaTipo_Doc.getNombreTipoDocto(datos[19])==null)?"No tiene Tipo de Documento":ActualizaTipo_Doc.getNombreTipoDocto(datos[19]));
				}else{
					setTipoDocumento("No tiene Tipo de Documento");
				}
				if(datos[20]!="" && datos[20]!="null"){
					setTramite((ActualizaTramite.getNombreTramite(datos[20])==null)?"No tiene Trámite":ActualizaTramite.getNombreTramite(datos[20]));
				}else{
					setTramite("No tiene Trámite");
				}
				if(datos[28]!="" && datos[28]!="null"){
					setPrioridad((ActualizaPrioridad.getNombrePrioridad(datos[28])==null)?"No tiene Prioridad":ActualizaPrioridad.getNombrePrioridad(datos[28]));
				}else{
					setPrioridad("No tiene Prioridad");
				}
				if(datos[29]!="" && datos[29]!="null"){
					setTipoAsunto((ActualizaTipoAsunto.getNombreTipoAsunto(datos[29])==null)?"No tiene Tipo de Asunto":ActualizaTipoAsunto.getNombreTipoAsunto(datos[29]));
				}else{
					setTipoAsunto("No tiene Tipo de Asunto");
				}
			}else{
				String[][] strDatosDes = ActualizaAsuntoTurnado.getDatosDes(strIdAsunto);
				
				if (strDatosDes!=null && strDatosDes.length>0){
					setTipoDocumento(strDatosDes[0][9]);
					setTramite(strDatosDes[0][11]);
					setPrioridad(strDatosDes[0][13]);
					setTipoAsunto(strDatosDes[0][12]);
				}else{
					setTipoDocumento("No tiene Tipo de Documento");
					setTramite("No tiene Trámite");
					setPrioridad("No tiene Prioridad");
					setTipoAsunto("No tiene Tipo de Asunto");					
				}
			}
			
			String relacinesAnexadas = "";
			String[][] strDatosAsuntoAnt 	= 	ActualizaAsunto.getAsuntosAnt(strIdAsunto);
			String[][] strDatosAsuntoLigas	=	ActualizaAsunto.getAsuntosLigados(strIdAsunto);
			if(strDatosAsuntoAnt!=null && strDatosAsuntoAnt.length>0){
				for (int i=0; i<strDatosAsuntoAnt.length; i++){
					relacinesAnexadas += folioRecepcion + " es " + strDatosAsuntoAnt[i][1] + " de " + ActualizaAsunto.getFolioAsunto(strDatosAsuntoAnt[i][0]) + "\n";
				}
			}
			if(strDatosAsuntoLigas!=null && strDatosAsuntoLigas.length>0){
				for (int i=0; i<strDatosAsuntoLigas.length; i++){
					relacinesAnexadas += ActualizaAsunto.getFolioAsunto(strDatosAsuntoLigas[i][0]) + " es " + strDatosAsuntoLigas[i][1] + " de " + folioRecepcion + "\n";
				}
			}
			setRelacionesAnexas(relacinesAnexadas);
			

			int iDuracion = 0;
			float fPorcentaje = 0;
			float fAvance = 0;
			int iSAmarillo = 70;
			String[][] strConfig = com.meve.sigma.actualiza.ActualizaConfiguracion.getDatosConf();
			if(strConfig != null && strConfig.length > 0){
				iSAmarillo		=	Integer.parseInt(strConfig[0][2]);
			}

			if (strResultado!=null && strResultado.length>0){
				
				iDuracion = Utilerias.DiasdeTrabajoEntre(Utilerias.StringCalendar(strResultado[9]), Utilerias.StringCalendar(strResultado[8]), 0);
				fPorcentaje = Utilerias.getPorcentajeDebido(iDuracion, strResultado[9], strResultado[8], 5);
				fAvance = new Float(strResultado[10]).floatValue();
				if(fPorcentaje>100){
					setSemaforo("Rojo");
				}else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
					if(fPorcentaje<=fAvance){
						setSemaforo("Verde");		
					}else{	
						setSemaforo("Amarillo");			
					}
				}else if(fPorcentaje<iSAmarillo){
					setSemaforo("Verde");	
				}
			}
		}
	}
	
	/**
	 * @return Devuelve asunto.
	 */
	public String getAsunto() {
		return asunto;
	}
	/**
	 * @param asunto El asunto a establecer.
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	/**
	 * @return Devuelve avance.
	 */
	public String getAvance() {
		return avance;
	}
	/**
	 * @param avance El avance a establecer.
	 */
	public void setAvance(String avance) {
		this.avance = avance;
	}
	/**
	 * @return Devuelve destinatarios.
	 */
	public String getDestinatarios() {
		return destinatarios;
	}
	/**
	 * @param destinatarios El destinatarios a establecer.
	 */
	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}
	/**
	 * @return Devuelve estatus.
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus El estatus a establecer.
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return Devuelve fecha_captura.
	 */
	public String getFecha_captura() {
		return fecha_captura;
	}
	/**
	 * @param fecha_captura El fecha_captura a establecer.
	 */
	public void setFecha_captura(String fecha_captura) {
		this.fecha_captura = fecha_captura;
	}
	/**
	 * @return Devuelve fecha_compromiso.
	 */
	public String getFecha_compromiso() {
		return fecha_compromiso;
	}
	/**
	 * @param fecha_compromiso El fecha_compromiso a establecer.
	 */
	public void setFecha_compromiso(String fecha_compromiso) {
		this.fecha_compromiso = fecha_compromiso;
	}
	/**
	 * @return Devuelve fecha_recepcion.
	 */
	public String getFecha_recepcion() {
		return fecha_recepcion;
	}
	/**
	 * @param fecha_recepcion El fecha_recepcion a establecer.
	 */
	public void setFecha_recepcion(String fecha_recepcion) {
		this.fecha_recepcion = fecha_recepcion;
	}
	/**
	 * @return Devuelve fecha_terminacion.
	 */
	public String getFecha_terminacion() {
		return fecha_terminacion;
	}
	/**
	 * @param fecha_terminacion El fecha_terminacion a establecer.
	 */
	public void setFecha_terminacion(String fecha_terminacion) {
		this.fecha_terminacion = fecha_terminacion;
	}
	/**
	 * @return Devuelve folio_control.
	 */
	public String getFolio_control() {
		return folio_control;
	}
	/**
	 * @param folio_control El folio_control a establecer.
	 */
	public void setFolio_control(String folio_control) {
		this.folio_control = folio_control;
	}
	/**
	 * @return Devuelve folio_externo.
	 */
	public String getFolio_externo() {
		return folio_externo;
	}
	/**
	 * @param folio_externo El folio_externo a establecer.
	 */
	public void setFolio_externo(String folio_externo) {
		this.folio_externo = folio_externo;
	}
	/**
	 * @return Devuelve folio_recepcion.
	 */
	public String getFolio_recepcion() {
		return folio_recepcion;
	}
	/**
	 * @param folio_recepcion El folio_recepcion a establecer.
	 */
	public void setFolio_recepcion(String folio_recepcion) {
		this.folio_recepcion = folio_recepcion;
	}
	/**
	 * @return Devuelve remitente.
	 */
	public String getRemitente() {
		return remitente;
	}
	/**
	 * @param remitente El remitente a establecer.
	 */
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	/**
	 * @return Devuelve tipo_es.
	 */
	public String getTipo_es() {
		return tipo_es;
	}
	/**
	 * @param tipo_es El tipo_es a establecer.
	 */
	public void setTipo_es(String tipo_es) {
		this.tipo_es = tipo_es;
	}
	/**
	 * @return Devuelve ua_remitente.
	 */
	public String getUa_remitente() {
		return ua_remitente;
	}
	/**
	 * @param ua_remitente El ua_remitente a establecer.
	 */
	public void setUa_remitente(String ua_remitente) {
		this.ua_remitente = ua_remitente;
	}
	/**
	 * @return Devuelve fecha_docto.
	 */
	public String getFecha_docto() {
		return fecha_docto;
	}
	/**
	 * @param fecha_docto El fecha_docto a establecer.
	 */
	public void setFecha_docto(String fecha_docto) {
		this.fecha_docto = fecha_docto;
	}
	/**
	 * @return Devuelve docAnexados.
	 */
	public String getDocAnexados() {
		return docAnexados;
	}
	/**
	 * @param docAnexados El docAnexados a establecer.
	 */
	public void setDocAnexados(String docAnexados) {
		this.docAnexados = docAnexados;
	}
	/**
	 * @return Devuelve contenidoDocAnexos.
	 */
	public String getContenidoDocAnexos() {
		return contenidoDocAnexos;
	}
	/**
	 * @param contenidoDocAnexos El contenidoDocAnexos a establecer.
	 */
	public void setContenidoDocAnexos(String contenidoDocAnexos) {
		this.contenidoDocAnexos = contenidoDocAnexos;
	}
	/**
	 * @return Devuelve descripcion.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion El descripcion a establecer.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return Devuelve expediente.
	 */
	public String getExpediente() {
		return expediente;
	}
	/**
	 * @param expediente El expediente a establecer.
	 */
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	/**
	 * @return Devuelve fechaEvento.
	 */
	public String getFechaEvento() {
		return fechaEvento;
	}
	/**
	 * @param fechaEvento El fechaEvento a establecer.
	 */
	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	/**
	 * @return Devuelve firmante.
	 */
	public String getFirmante() {
		return firmante;
	}
	/**
	 * @param firmante El firmante a establecer.
	 */
	public void setFirmante(String firmante) {
		this.firmante = firmante;
	}
	/**
	 * @return Devuelve folioIntermedio.
	 */
	public String getFolioIntermedio() {
		return folioIntermedio;
	}
	/**
	 * @param folioIntermedio El folioIntermedio a establecer.
	 */
	public void setFolioIntermedio(String folioIntermedio) {
		this.folioIntermedio = folioIntermedio;
	}
	/**
	 * @return Devuelve lugarEvento.
	 */
	public String getLugarEvento() {
		return lugarEvento;
	}
	/**
	 * @param lugarEvento El lugarEvento a establecer.
	 */
	public void setLugarEvento(String lugarEvento) {
		this.lugarEvento = lugarEvento;
	}
	/**
	 * @return Devuelve prioridad.
	 */
	public String getPrioridad() {
		return prioridad;
	}
	/**
	 * @param prioridad El prioridad a establecer.
	 */
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	/**
	 * @return Devuelve relacionesAnexas.
	 */
	public String getRelacionesAnexas() {
		return relacionesAnexas;
	}
	/**
	 * @param relacionesAnexas El relacionesAnexas a establecer.
	 */
	public void setRelacionesAnexas(String relacionesAnexas) {
		this.relacionesAnexas = relacionesAnexas;
	}
	/**
	 * @return Devuelve semaforo.
	 */
	public String getSemaforo() {
		return semaforo;
	}
	/**
	 * @param semaforo El semaforo a establecer.
	 */
	public void setSemaforo(String semaforo) {
		this.semaforo = semaforo;
	}
	/**
	 * @return Devuelve tipoAsunto.
	 */
	public String getTipoAsunto() {
		return tipoAsunto;
	}
	/**
	 * @param tipoAsunto El tipoAsunto a establecer.
	 */
	public void setTipoAsunto(String tipoAsunto) {
		this.tipoAsunto = tipoAsunto;
	}
	/**
	 * @return Devuelve tipoDocumento.
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	/**
	 * @param tipoDocumento El tipoDocumento a establecer.
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	/**
	 * @return Devuelve tramite.
	 */
	public String getTramite() {
		return tramite;
	}
	/**
	 * @param tramite El tramite a establecer.
	 */
	public void setTramite(String tramite) {
		this.tramite = tramite;
	}
}
