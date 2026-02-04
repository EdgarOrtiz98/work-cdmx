/*
 * Creado el 24/11/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.util;

import com.meve.sigma.actualiza.ActualizaUsuario;

/**
 * Clase para validar usuarios en una cadena de mando
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class CadenaMando {

	public static boolean bEsJefe = false;
	public static String strIdUsuario = null;
	public static String strIdUsuarioJefe = null;

	/**
	 * Inicializacion de los parametros
	 * 
	 * @param stridUs Usuario subalterno
	 * @param strIdUsjefe Usuario Jefe 
	 */
	public CadenaMando(String stridUs, String strIdUsjefe) {
		strIdUsuario = stridUs;
		strIdUsuarioJefe = strIdUsjefe;
		getCadena(strIdUsuario, strIdUsuarioJefe);
	}
	
	/**
	 * 
	 * @return Regresa un True si el Usuario Jefe es jefe del Usuario Subalterno
	 */
	public boolean getEsJefe(){
		return bEsJefe;
	}
	
	/**
	 * Determina si idJefe es parte de la cadena de mando del usuario idUsuario 
	 * 
	 * @param IdUsuario Usuario subalterno
	 * @param idJefe Usuario Jefe 
	 */
	public static void getCadena(String IdUsuario, String idJefe){

		String strIdJefe = ActualizaUsuario.getCadenaMando(IdUsuario);
		if(strIdJefe!=null && IdUsuario!=null && idJefe.equals(strIdJefe)){
			bEsJefe = true;
		}else{
			if(IdUsuario.equals("-1") || IdUsuario.equals("") || IdUsuario.equals("null")){
				bEsJefe = false;
			}else{
				if(strIdJefe.equals("") || strIdJefe.equals("null")){
					bEsJefe = false;
				}else{
					getCadena(strIdJefe, idJefe);
				}
			}
			
		}
	}

}
