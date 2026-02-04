package com.meve.sigma.util;

import java.util.Vector;

import com.meve.sigma.actualiza.ActualizaUsuario;

/**
 * Clase que instancia y contruye la lista de Puestos 
 * con el rol de atención para ser mostrados en un combo 
 * que aplicará a la subventanilla
 * 
 * @author Meve Soluciones SA de CV
 */
public class JerarquiaAtencion {

	/**
	 * Lista en forma jerarquica de los Puestos de atención
	 */
	public static Vector vNombrePuesto = null;
	
	/**
	 * Lista con los ids de los puestos
	 */
	public static Vector vIds = null;
	
	/**
	 * Id del área
	 */
	private String strIdArea ;
	
	/**
	 * Contructor para inicializar el recorrido de los usuarios de 
	 * atención jerarquizada
	 */
	public JerarquiaAtencion(String[][] strAtencion, String strIdA) {
		vNombrePuesto 	=	new Vector();
		vIds 			=	new Vector();
		strIdArea		=	strIdA;
		jerarquiaAtencion(strAtencion, 2, strIdArea);
	}
	
	/**
	 * Nombre del puesto
	 * @return Devuelve Vector vNombrePuesto con el Nombre/Puesto
	 */
	public Vector getNombrePuesto(){
		return vNombrePuesto;
	}
	
	/**
	 * Id del puesto
	 * @return Devuelve los Ids de los Nombre/Puesto de cada Usuario
	 */
	public Vector getIds(){
		return vIds;
	}
	
	/**
	 * Función recursiva que hace el recorrido de los roles a atención
	 * @param strAtencion Arreglo que contiene a los subordinados directos de un supervisor
	 */
	public static void jerarquiaAtencion(String[][] strAtencion, int iIdent, String strIdArea){
		if (strAtencion.length > 0){
			for(int i=0; i<strAtencion.length; i++)
	        {
	            boolean hijos = false; 
	            vNombrePuesto.add(getEspacio(iIdent)+strAtencion[i][1]);
	            vIds.add(strAtencion[i][0]);
	            hijos = ActualizaUsuario.tieneHijos((String)strAtencion[i][0]);
	            if(hijos)
	            {
	               	String strUsuario[][] = ActualizaUsuario.getSubalternosSubVentanilla(strAtencion[i][0], strIdArea);
	               	jerarquiaAtencion(strUsuario, iIdent+1, strIdArea);
				}
	        } 
		}
	}
	
	/**
	 * Agrega Identación 
	 * @param iIdent Número de Identación de un registro
	 * @return String con el Número de Identación
	 */
	public static String getEspacio(int iIdent){
		String strEspacio = "";
		if(iIdent==1)
			strEspacio = ""+String.valueOf(iIdent)+"-";
		if(iIdent==2)
			strEspacio = "&nbsp;"+String.valueOf(iIdent)+"-";
		if(iIdent==3)
			strEspacio = "&nbsp;&nbsp;"+String.valueOf(iIdent)+"-";
		if(iIdent==4)
			strEspacio = "&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+"-";
		if(iIdent==5)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+"-";
		if(iIdent==6)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+".-";
		if(iIdent==7)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+".-";
		if(iIdent==8)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+".-";
		if(iIdent==9)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+".-";
		if(iIdent==10)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+".-";
		if(iIdent==11)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+".-";
		if(iIdent==12)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+".-";
		if(iIdent==13)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+".-";
		if(iIdent==14)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+".-";
		if(iIdent==15)
			strEspacio = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+String.valueOf(iIdent)+".-";
		return strEspacio;
	}

	
}
