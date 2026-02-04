/*
 * Creado el 2/04/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.util;

import java.util.Vector;

import com.meve.sigma.actualiza.ActualizaUsuario;

/**
 * @author Administrator
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ArbolTurnado {
	
	/**
	 * Lista Ids del usuario
	 */
	public static Vector vIdUs = null;
	
	/**
	 * Vector con los nombres de los usuarios
	 */
	public static Vector vNombre = null;
	
	/**
	 * Vector con los puestos de los usuarios
	 */
	public static Vector vPuesto = null;
	
	/**
	 * Vector con los mail de los usuarios
	 */
	public static Vector vMail = null;
	
	/**
	 * Vector con los Teléfonos de los usuarios
	 */
	public static Vector vTel = null;
	
	/**
	 * Lista de los datos de los usuarios subordinados
	 */
	public static String[][] strLista = null;

	/**
	 * Contructor para la Inicialización de 
	 * variables de ArbolTurnado()
	 * @param strLista1 Lista de Usuarios
	 */
	public ArbolTurnado(String[][] strLista1) {
		strLista = strLista1;
		vIdUs	=	new Vector();
		vNombre	=	new Vector();
		vPuesto	=	new Vector();
		vMail	=	new Vector();
		vTel	=	new Vector();
		ListaSubordinados(strLista);
	}
	
	/**
	 * @return Regresa un Vector con los ids de la cadena de mando
	 */
	public Vector getIds(){
		return vIdUs;
	}

	/**
	 * @return Regresa un Vector con los Nombres de la cadena de mando
	 */
	public Vector getNombre(){
		return vNombre;
	}
	
	/**
	 * @return Regresa un Vector con los Puestos de la cadena de mando
	 */
	public Vector getPuesto(){
		return vPuesto;
	}
	
	/**
	 * @return Regresa un Vector con los mails de la cadena de mando
	 */
	public Vector getMail(){
		return vMail;
	}
	
	/**
	 * @return	Regresa un Vector con los teléfonos de la cadena de mando
	 */
	public Vector getTel(){
		return vTel;
	}
	
	/**
	 * Recorre la linea de mando y genera los nombres, ID's
	 * 
	 * @param strValores Primer nivel de subordinados del jefe base
	 */
	public static void ListaSubordinados(String[][] strValores){
		if (strValores.length > 0){
			for(int i=0; i<strValores.length; i++)
	        {
	            boolean hijos = false; 
	            
	            vIdUs.add(strValores[i][0]);
	            vNombre.add(strValores[i][1]);
	            vPuesto.add(strValores[i][2]);
	            vMail.add(strValores[i][3]);
	            vTel.add(strValores[i][4]);
	            hijos = ActualizaUsuario.tieneHijos((String)strValores[i][0]);
	            if(hijos)
	            {
	               	String strUsuario[][] = ActualizaUsuario.getSubalternosTurnador(strValores[i][0]);
	               	ListaSubordinados(strUsuario);
				}
	        } 
		}	
    }

}
