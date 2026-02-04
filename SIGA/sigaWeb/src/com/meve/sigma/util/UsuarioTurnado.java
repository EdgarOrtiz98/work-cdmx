/*
 * Creado el 24/11/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.util;

import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaUsuario;

/**
 * Clase que detremina si un usuario Turno una instrucción
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class UsuarioTurnado {

	public static boolean bSiTurno = false;
	public static String strIdUsuario = null;
	public static String strIdUsuAtencion = null;
	public static String strIdInstruccion = null;
	/**
	 * Inicializacion de los parametro de la clase
	 * @param strIdUsu Usuario referencia 
	 * @param strIdUsuAte Usuario de Atencion 
	 * @param strIdInst ID de la instrucción
	 */
	public UsuarioTurnado(String strIdUsu, String strIdUsuAte,String strIdInst) {
		strIdUsuario = strIdUsu;
		strIdUsuAtencion = strIdUsuAte;
		strIdInstruccion = strIdInst;
		getUsuarioTurnado(strIdUsuario, strIdUsuAtencion, strIdInstruccion);
	}
	
	/**
	 * 
	 * @return Regresa True si el Usuario es el turnado o un False en caso contrario 
	 */
	public boolean getEsTurnado(){
		return bSiTurno;
	}
	/**
	 * Determina si el Usuario referencia es un Turnado de la instrucción
	 * 
	 * @param IdUsuario Usuario referencia
	 * @param IdUsuarioAtencion Usuario de Atencion 
	 * @param IdInstruccion ID de la instrucción
	 */
	public static void getUsuarioTurnado(String IdUsuario, String IdUsuarioAtencion,String IdInstruccion){
//		//System.out.println("UsuarioTurnado.getUsuarioTurnado(...): 1.- "+IdUsuarioAtencion+" 2.- "+IdInstruccion);
		String strTurno = ActualizaUsuario.getUsuarioTurno(IdUsuarioAtencion, IdInstruccion);
//                //System.out.println("UsuarioTurnado.getUsuarioTurnado(...): 1.- "+strTurno);
		if(IdUsuario.equals(strTurno)){
			bSiTurno = true;
		}else if(strTurno.length()>0){
			boolean bEsHijo	= ActualizaAsuntoTurnado.getEsHijo(IdInstruccion);
			if(bEsHijo){
				String idPadre	= ActualizaAsuntoTurnado.getIdPadre(IdInstruccion);
				getUsuarioTurnado(IdUsuario, strTurno, idPadre);
			}else{
				bSiTurno = false;
			}
			
		}
	}

}
