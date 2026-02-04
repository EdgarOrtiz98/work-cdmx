/*
 * Clase:						BeanTimePlanChart.java
 * 
 * Paquete:						com.meve.sigma.reportes		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Apr 21, 2006
 * 
 * @author: 					Meve Soluciones
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		
 */

package com.meve.sigma.reportes;

import java.util.StringTokenizer;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaUsuario;

/**
 * Bean para exportar los Reportes de Asuntos Atrasados por Turnar
 *
 * @author Meve Soluciones S.A. de C.V.
 */
public class BeanReporteAtrasados {

	String folio_recepcion;
	String folio_externo;
	String asunto;
	String remitente;
	String destinatarios;
	String atraso;
	String estatus;
	
	/**
	 * Llena los campos del Bean con los campos del reporte de Asuntos Atrasados por Turnar
	 * 
	 * @param datos Datos del reporte
	 */
	public void setCampos(String[] datos) {
		if (datos!=null && datos.length>0){
			
			setFolio_recepcion(datos[6]);
			setFolio_externo(datos[7]);
			setAsunto(datos[2]);
			setRemitente(datos[3]);
			
			String dest = "";
			StringTokenizer strToken = new StringTokenizer(datos[8],",");
			while(strToken.hasMoreElements()){
				String strIdUsuario = strToken.nextToken();
                                if (strIdUsuario!=null && !strIdUsuario.trim().equals("") && !strIdUsuario.equals("null")){
					dest += ActualizaUsuario.NombreUsuario(strIdUsuario) + " (" + 
					ActualizaArea.NombreArea(ActualizaUsuario.getIdAreaUs(strIdUsuario)) + ")";
					if (strToken.countTokens()!=0){
						dest += "\n";
					}
				}
			}
			strToken = new StringTokenizer(datos[9],",");
			if (strToken.countTokens()>0){
				dest += "\n\n -- Destinatarios CC -- \n";
			}
			while(strToken.hasMoreElements()){
				String strIdUsuario = strToken.nextToken();
				if (strIdUsuario!=null && !strIdUsuario.trim().equals("") && !strIdUsuario.equals("null")){
					dest += ActualizaUsuario.NombreUsuario(strIdUsuario) + " (" + 
					ActualizaArea.NombreArea(ActualizaUsuario.getIdAreaUs(strIdUsuario)) + ")";
					if (strToken.countTokens()!=0){
						dest += "\n";
					}
				}
			}
			
			setDestinatarios(dest);
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
	 * @return Devuelve atraso.
	 */
	public String getAtraso() {
		return atraso;
	}
	/**
	 * @param atraso El atraso a establecer.
	 */
	public void setAtraso(String atraso) {
		this.atraso = atraso;
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
}
