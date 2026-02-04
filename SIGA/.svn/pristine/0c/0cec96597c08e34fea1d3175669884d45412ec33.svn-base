/*
 * Creado el 20/08/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.util;

import java.util.Vector;

/**
 * @author Leonardo Lechuga
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class AsignarArbol {
	
	public static Vector vNom = null;//new Vector();
	public static Vector vIds = null;//new Vector();
	
	public AsignarArbol(String datos[][]){
		vNom	=	new Vector();
		vIds 	= 	new Vector();
		getArbol(datos);
	}
	
	public static void getArbol(String datos[][]){
		if(datos!=null && datos.length>0){
			for(int i=0;i<datos.length;i++){
				vNom.add(datos[i][2]);
	            vIds.add(datos[i][0]);
			}
		}
	}
	
	/**
	 * @return Regresa un Vector con los nombre de la cadena de mando
	 */
	public Vector getNombres(){
		return vNom;
	}
	
	/**
	 * @return Regresa un Vector con los ID's de la cadena de mando
	 */
	public Vector getIds(){
		return vIds;
	}

}
