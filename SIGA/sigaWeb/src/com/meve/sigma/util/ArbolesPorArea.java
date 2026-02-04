
package com.meve.sigma.util;

import java.util.Vector;

import com.meve.sigma.actualiza.ActualizaUsuario;

/**
 * Clase para generar jerarquias para las Unidades Administrativas
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class ArbolesPorArea {

	/**
	 * 
	 */
	public static Vector vNom = null;//new Vector();
	public static Vector vIds = null;//new Vector();
	public static String[][] sNom1 = null;
	
	/**
	 * Inicializacion de la estructura
	 * @param sNom Primero nivel de UA subordinadas
	 */
	public ArbolesPorArea(String[][] sNom) {
		sNom1 = sNom;
		vNom = new Vector();
		vIds = new Vector();
		//RecorreDocumentos(sNom1);
		RecorreAreas(sNom1);
	}
	
	/**
	 * 
	 * @return Regresa un vector jerarquizado con los nombres de las UA
	 */
	public Vector getNombres(){
		return vNom;
	}
	
	/**
	 * 
	 * @return Regresa un vector jerarquizado con los ID's de las UA
	 */
	public Vector getIds(){
		return vIds;
	}
	
	/**
	 * Función que recorre la linea de comando de un jefe
	 * @param strValores Primero nivel de UA subordinadas
	 */
	public static void RecorreDocumentos(String[][] strValores)
    {		
        for(int i=0; i<strValores.length; i++)
        {
            boolean hijos = false; 
            vNom.add(strValores[i][1]);
            vIds.add(strValores[i][0]);
            hijos = ActualizaUsuario.tieneHijos((String)strValores[i][0]);
            if(hijos)
            {
               	String strUsuario[][] = ActualizaUsuario.getSubalterno(strValores[i][0]);
               	RecorreDocumentos(strUsuario);
  				
			}
        } 
    }
	
	/**
	 * Función que recorre la linea de comando de una UA jefe 
	 * @param strValores Primero nivel de UA subordinadas
	 */
	public static void RecorreAreas(String[][] strValores)
    {		
        for(int i=0; i<strValores.length; i++)
        {
            boolean hijos = false; 
            //vNom.add(strValores[i][1]);
            vIds.add(strValores[i][0]);
            ////System.out.println("IdArea="+strValores[i][0]+"--Area="+ActualizaArea.NombreArea(strValores[i][0]));
            hijos = ActualizaUsuario.tieneHijosAreas((String)strValores[i][1]);
            if(hijos)
            {
            	////System.out.println("Si tiene");
               	String strUsuario[][] = ActualizaUsuario.getIdsAreas(strValores[i][1]);
               	RecorreAreas(strUsuario);
			}
        } 
    }
}
