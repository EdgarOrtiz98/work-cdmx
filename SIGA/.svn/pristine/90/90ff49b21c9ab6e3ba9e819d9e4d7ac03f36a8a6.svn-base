
package com.meve.sigma.util;

import java.util.Vector;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaUsuario;

/**
 * Genera cadenas de mando con jerarquias de Arbol
 * 
 * @author Meve Soluciones S.A. de C.V.
 */

public class SubOtraUa {

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
	public SubOtraUa(String[][] sNom) {
		sNom1 		= sNom;
		vNom 		= new Vector();
		vNomHtml 	= new Vector();
		vNomHtmlGes	= new Vector();
		vIds 		= new Vector();
		RecorreDocumentos(sNom1);
		//RecorreAreas(sNom1);
	}
	
	/**
	 * Inicializacion para obtener una cadena de mando con codigo HTML para desplegarlo en forma de Arbol, vinculos, nombres y ID's de usuario
	 * 
	 * @param sNom Primer nivel de subordinados del jefe base
	 * @param strIdArea Unidad Administrativa del jefe base
	 * @param retURI URL de retorno, para los liks de navegacion
	 */
	public SubOtraUa(String[][] sNom, String strIdArea, String retURI) {
		sNom1 		= sNom;
		vNom 		= new Vector();
		vNomHtml 	= new Vector();
		vNomHtmlGes	= new Vector();
		vIds 		= new Vector();
		RecorreDocumentos(sNom1, strIdArea, retURI);
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
	               	String strUsuario[][] = ActualizaUsuario.getSubalterno(strValores[i][0]);
	               	RecorreDocumentos(strUsuario);
	  				
				}
	            vNomHtml.add("</LI>");
	        } 
			vNomHtml.add("</LI></UL>");
		}
    }
	
	/**
	 * Recorre la linea de mando y genera los nombres, ID's y estructura HTML con links de retorno
	 * 
	 * @param strValores Primer nivel de subordinados del jefe base
	 */
	public static void RecorreDocumentos(String[][] strValores, String strIdArea, String retURI)
    {		
		if (strValores.length > 0){
			vNomHtml.add("<UL>");
			vNomHtmlGes.add("<UL>");
	        for(int i=0; i<strValores.length; i++)
	        {
	            boolean hijos = false; 
	            
	            vNomHtml.add("<LI>");
	            vNomHtmlGes.add("<LI>");
	            if(ActualizaUsuario.getAreaUsuario(strValores[i][0]).equals(strIdArea)){
	            	vNomHtml.add("<A href=\"estructuraPuesto.jsp?id="+strValores[i][0]+"&area="+strIdArea+"&retURI="+retURI+"\" class=\"etiquetas\" title=\""+strValores[i][1]+"\">"+strValores[i][2]+"</A><BR>");
	            	vNomHtmlGes.add("<A href=\"estructuraPuestoGestion.jsp?id="+strValores[i][0]+"&area="+strIdArea+"&retURI="+retURI+"\" class=\"etiquetas\" title=\""+strValores[i][1]+"\">"+strValores[i][2]+"</A><BR>");
	            }else{
	            	vNomHtml.add("<A class=\"etiquetas\" title=\""+strValores[i][1]+" -- "+ActualizaArea.NombreArea(ActualizaUsuario.getAreaUsuario(strValores[i][0]))+"\">"+strValores[i][2]+"</A><BR>");
	            	vNomHtmlGes.add("<A class=\"etiquetas\" title=\""+strValores[i][1]+" -- "+ActualizaArea.NombreArea(ActualizaUsuario.getAreaUsuario(strValores[i][0]))+"\">"+strValores[i][2]+"</A><BR>");
	            }
	            
	            vNom.add(strValores[i][1]);
	            vIds.add(strValores[i][0]);
	            hijos = ActualizaUsuario.tieneHijosSinRol((String)strValores[i][0]);
	            if(hijos)
	            {
	               	String strUsuario[][] = ActualizaUsuario.getSubalternoSinRol(strValores[i][0]);
	               	RecorreDocumentos(strUsuario,strIdArea,retURI);
	  				
				}
	            vNomHtml.add("</LI>");
	            vNomHtmlGes.add("</LI>");
	        } 
			vNomHtml.add("</LI></UL>");
			vNomHtmlGes.add("</LI></UL>");
		}
    }
	
	/**
	 * Genera una cadena de mando para las unidades administrativas padres - hijas
	 * 
	 * @param strValores
	 */
	public static void RecorreAreas(String[][] strValores)
    {		
        for(int i=0; i<strValores.length; i++)
        {
            boolean hijos = false; 
            //vNom.add(strValores[i][1]);
            vIds.add(strValores[i][0]);
            //System.out.println("IdArea="+strValores[i][0]+"--Area="+ActualizaArea.NombreArea(strValores[i][0]));
            hijos = ActualizaUsuario.tieneHijosAreas((String)strValores[i][1]);
            if(hijos)
            {
            	//System.out.println("Si tiene");
               	String strUsuario[][] = ActualizaUsuario.getIdsAreas(strValores[i][1]);
               	RecorreAreas(strUsuario);
			}
        } 
    }

}
