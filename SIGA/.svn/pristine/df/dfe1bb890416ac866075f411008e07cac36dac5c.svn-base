/*
 * Creado el 15/11/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.util;


/**
 * Clase para cifrar cadenas de texto
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class Cifrado {

	private static String strTexto = null;

	/**
	 * Inicializa la cadena de texto para cifrar
	 * @param t
	 */
	public Cifrado(String t) {
		strTexto = t;
		//strFinal = new String(); 
	}
	
	/**
	 * Realiza el cifrado mediante desplzamiento de caracteres
	 * 
	 * @return Regresa un String cifrado 
	 */
	public String cifrar() {
		String res = "";
		//A = 65;Z = 90;a = 97;z = 122;
		for (int i=0;i<strTexto.length();i++) {

			char letra =strTexto.charAt(i);
			int codigoASCII = letra;
			//Si pertenece a las letras en minuscula
			if (codigoASCII >= 97 && codigoASCII <= 122) {
				res = res+desplazar(codigoASCII);
			//Si pertenece a las letras en mayuscula
			}else if (codigoASCII >= 65 && codigoASCII <= 90) {
				res = res+desplazar(codigoASCII);
			//no pertenece a las letras
			} else {
				res = res+letra;
			}
		}
		return res;
	}
	
	/**
	 * Calcula los desplazamiento necesarios para cierto caracter
	 * 
	 * @param ascii Representación ASCII del caracter a cifrar
	 * 
	 * @return Regresa el caracter cifrado
	 */
	private char desplazar(int ascii) {

		if (ascii >= 97 && ascii <= 122) {
			if (ascii+6 > 122) {
				ascii = ascii+6 - 122 +96;
			} else {
				ascii = ascii + 6;
			}
		} else {
			if (ascii+6 > 90) {
				ascii = ascii+6 - 90 +64;
			} else {
				ascii = ascii + 6;
			}
		}
		return (char) ascii;
	}
	
	public String getTexto(){
		return cifrar();
	}

}
