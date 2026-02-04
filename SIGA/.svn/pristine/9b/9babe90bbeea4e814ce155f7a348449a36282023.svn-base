/*
 * Creado el 8/05/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.reportes;

import com.meve.sigma.util.Utilerias;

/**
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class BeanReporteBuscarInst {

	String remitente;
	String asunto;
	String instruccion;
	String instruccionOtro;
	String tipoAtencion;
	String fechaGeneracion;
	String fechaVencimiento;
	String estatus;
	String avance;
	String asignadaPor;
	String folioRecepcion;
	String folioIntermedio;
	String folioControl;
	String docAnexados;
	String contenidoDocAnexados;
	String semaforo;
	String expediente;
	
	/**
	 * Llena los campos del Bean con los campos del reporte de Folios de Control
	 * 
	 * @param datos Datos del reporte
	 */
	public void setCampos(String[] datos) {
		if (datos!=null && datos.length>0){
			
			setRemitente(datos[0]);
			setAsunto(datos[1]);
			setInstruccion(datos[2]);
			setInstruccionOtro(datos[3]);
			setTipoAtencion(datos[4]);
			setFechaGeneracion(datos[5]);
			setFechaVencimiento(datos[6]);
			setEstatus(datos[7]);
			setAvance(datos[8]);
			setAsignadaPor(datos[9]);
			setFolioRecepcion(datos[10]);
			setFolioIntermedio(datos[11]);
			setFolioControl(datos[12]);
			setExpediente(datos[13]);
			
			if (datos[2].equals("null") || datos[2].equals("")){
				setInstruccion(datos[3]);
			}
			if (datos[11].equals("null") || datos[11].equals("")){
				setFolioIntermedio("Sin Folio Intermedio");
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
			
			setRemitente(datos[0]);
			setAsunto(datos[1]);
			setInstruccion(datos[2]);
			setInstruccionOtro(datos[3]);
			setTipoAtencion(datos[4]);
			setFechaGeneracion(datos[5]);
			setFechaVencimiento(datos[6]);
			setEstatus(datos[7]);
			setAvance(datos[8]);
			setAsignadaPor(datos[9]);
			setFolioRecepcion(datos[10]);
			setFolioIntermedio(datos[11]);
			setFolioControl(datos[12]);
			setExpediente(datos[13]);
			
			if (datos[2].equals("null") || datos[2].equals("")){
				setInstruccion(datos[3]);
			}
			if (datos[11].equals("null") || datos[11].equals("")){
				setFolioIntermedio("Sin Folio Intermedio");
			}
			
			int iSAmarillo = 70;
			String[][] strConfig = com.meve.sigma.actualiza.ActualizaConfiguracion.getDatosConf();
			if(strConfig != null && strConfig.length > 0){
				iSAmarillo		=	Integer.parseInt(strConfig[0][2]);
			}
			float fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(strResultado[13]).intValue(), strResultado[11], strResultado[12], 5);
			float iAvance = new Float(strResultado[14]).floatValue();
			if(fPorcentaje > 100){
				setSemaforo("Rojo");	
			}else if(fPorcentaje>=iSAmarillo &&  fPorcentaje<=100){
				if(fPorcentaje<=iAvance){
					setSemaforo("Verde");		
				}else{
					setSemaforo("Amarillo");			
				}
			}else if(fPorcentaje<iSAmarillo){
				setSemaforo("Verde");			
			} 
		}
	}
	
	/**
	 * @return Devuelve asignadaPor.
	 */
	public String getAsignadaPor() {
		return asignadaPor;
	}
	/**
	 * @param asignadaPor El asignadaPor a establecer.
	 */
	public void setAsignadaPor(String asignadaPor) {
		this.asignadaPor = asignadaPor;
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
		return avance;	}
	/**
	 * @param avance El avance a establecer.
	 */
	public void setAvance(String avance) {
		this.avance = avance;
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
	 * @return Devuelve fechaGeneracion.
	 */
	public String getFechaGeneracion() {
		return fechaGeneracion;
	}
	/**
	 * @param fechaGeneracion El fechaGeneracion a establecer.
	 */
	public void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	/**
	 * @return Devuelve fechaVencimiento.
	 */
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	/**
	 * @param fechaVencimiento El fechaVencimiento a establecer.
	 */
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	/**
	 * @return Devuelve folioControl.
	 */
	public String getFolioControl() {
		return folioControl;
	}
	/**
	 * @param folioControl El folioControl a establecer.
	 */
	public void setFolioControl(String folioControl) {
		this.folioControl = folioControl;
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
	 * @return Devuelve folioRecepcion.
	 */
	public String getFolioRecepcion() {
		return folioRecepcion;
	}
	/**
	 * @param folioRecepcion El folioRecepcion a establecer.
	 */
	public void setFolioRecepcion(String folioRecepcion) {
		this.folioRecepcion = folioRecepcion;
	}
	/**
	 * @return Devuelve instruccion.
	 */
	public String getInstruccion() {
		return instruccion;
	}
	/**
	 * @param instruccion El instruccion a establecer.
	 */
	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}
	/**
	 * @return Devuelve instruccionOtro.
	 */
	public String getInstruccionOtro() {
		return instruccionOtro;
	}
	/**
	 * @param instruccionOtro El instruccionOtro a establecer.
	 */
	public void setInstruccionOtro(String instruccionOtro) {
		this.instruccionOtro = instruccionOtro;
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
	 * @return Devuelve tipoAtencion.
	 */
	public String getTipoAtencion() {
		return tipoAtencion;
	}
	/**
	 * @param tipoAtencion El tipoAtencion a establecer.
	 */
	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
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
	 * @return Devuelve contenidoDocAnexados.
	 */
	public String getContenidoDocAnexados() {
		return contenidoDocAnexados;
	}
	/**
	 * @param contenidoDocAnexados El contenidoDocAnexados a establecer.
	 */
	public void setContenidoDocAnexados(String contenidoDocAnexados) {
		this.contenidoDocAnexados = contenidoDocAnexados;
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
}
