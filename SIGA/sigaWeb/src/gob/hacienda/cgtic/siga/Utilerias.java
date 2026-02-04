/*
 **************************************************************
 * Copyright (C) 2007 SHCP
 * CGTIyC - alejandro_gavia@hacienda.gob.mx
 *
 * $$Archivo: 	Utilerias.java
 * $$Revisión: 	DARG - Utilerias para el SIGA.
 * $$Fecha: 	08 de Febrero de 2007
 *
 * Este software es información propietaria y confidencial de la SHCP - CGTIyC.
 ***************************************************************
 */
package gob.hacienda.cgtic.siga;


/**
 *
 * @version 1 08 Feb 2007
 * @author Daniel Rangel
 */
 public class Utilerias {

	public static String codificaPostHTML (String cadena){

		int j=0;
		while (cadena.indexOf('%',j)!=-1){
			int i=cadena.indexOf('%',j);
			j=i+1;
			String aux = cadena.substring(0,i) + "%25" + cadena.substring(i+1,cadena.length());
			cadena = aux;
		}
		while (cadena.indexOf('?')!=-1){
			int i=cadena.indexOf('?');
			String aux = cadena.substring(0,i) + "%3F" + cadena.substring(i+1,cadena.length());
			cadena = aux;
		}
		while (cadena.indexOf('&')!=-1){
			int i=cadena.indexOf('&');
			String aux = cadena.substring(0,i) + "%26" + cadena.substring(i+1,cadena.length());
			cadena = aux;
		}
		return cadena;
	}

}
