/*
 * Creado el 20/07/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.util;

import java.util.Vector;

import com.meve.sigma.actualiza.ActualizaUsuario;

/**
 * @author Administrador
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class SubAlternos {
	
	/**
	 * 
	 */
	public static Vector vNom = null;//new Vector();
	public static Vector vNomHtml = null;//new Vector();
	public static Vector vNomHtmlGes = null;//new Vector();
	public static Vector vIds = null;//new Vector();
	public static String[][] sNom1 = null;
	
	/**
	 * Inicializacion para obtener una cadena de mando sencilla con nombres y ID's de usuario
	 * 
	 * @param sNom Primer nivel de subordinados del jefe base
	 */
	public SubAlternos(String[][] sNom) {
		sNom1 		= sNom;
		vNom 		= new Vector();
		vNomHtml 	= new Vector();
		vNomHtmlGes	= new Vector();
		vIds 		= new Vector();
		RecorreDocumentos(sNom1);
		//RecorreAreas(sNom1);
	}
	
	/**
	 * @return Regresa un Vector con los nombre de la cadena de mando
	 */
	public Vector getNombres(){
		return vNom;
	}

	/**
	 * @return Regresa un Vector con estructura de arbol con los nombres en formato HTML para Catalogos
	 */
	public Vector getNombresHtml(){
		return vNomHtml;
	}
	
	/**
	 * @return Regresa un Vector con estructura de arbol con los nombres en formato HTML para gestión
	 */
	public Vector getNombresHtmlGestion(){
		return vNomHtmlGes;
	}
	
	/**
	 * @return Regresa un Vector con los ID's de la cadena de mando
	 */
	public Vector getIds(){
		return vIds;
	}
	
	/**
	 * Recorre la linea de mando y genera los nombres, ID's y estructura HTML
	 * 
	 * @param strValores Primer nivel de subordinados del jefe base
	 */
	public static void RecorreDocumentos(String[][] strValores)
    {		
		if (strValores.length > 0){
			vNomHtml.add("<UL>");
	        for(int i=0; i<strValores.length; i++)
	        {
	            boolean hijos = false; 
	            
	            vNomHtml.add("<LI>");
	            vNomHtml.add(strValores[i][2]);

	            vNom.add(strValores[i][2]);
	            vIds.add(strValores[i][0]);
	            hijos = ActualizaUsuario.tieneHijos((String)strValores[i][0]);
	            if(hijos)
	            {
	               	String strUsuario[][] = ActualizaUsuario.getSubalternoSinRol(strValores[i][0]);
	               	RecorreDocumentos(strUsuario);
	  				
				}
	            vNomHtml.add("</LI>");
	        } 
			vNomHtml.add("</LI></UL>");
		}
    }
}
