/*
 * Creado el 30/03/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.util;

import com.meve.sigma.actualiza.*;

/**
 * @author Administrator
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class HistorialInstruccion {

	/**
	 *Id de la instrucción
	 */
	private String strId;
	
	/**
	 * Cadena de l historial de la instrucción
	 */
	private static String strCadena = "";
	
	/**
	 * Contructor para generar historial de la instrucción
	 */
	public HistorialInstruccion(String strId) {
		this.strId = strId;
		historial(strId);
	}
	
	/**
	 * Genera la cadena para el historial de un instrucción
	 * @param strId id instrucción
	 */
	public static String historial(String strId){
		String strCadena1 = "";
                
                String strDatosInstrucciones[][]        =       ActualizaInstrucciones.getInstruccionDatos(strId);
                String strHistorial[][] = ActualizaHistorial.getHistorialInstruccion(strId);
		String strDelegado             =       strDatosInstrucciones[0][21];
		    
		if(strHistorial!=null && strHistorial.length!=0){
			//System.err.println(strHistorial.length);
			for(int i=0;i<strHistorial.length;i++){
				//System.err.println(i);
				strCadena1 += strHistorial[i][2]+"---->\n";
				  
				if(new Integer(strHistorial[i][6]).intValue()==1) {
                                        if(strHistorial[i][5].equals("Actualización de la instruccion Padre")) {
                                            strCadena1 += "Se ha alcanzado el estatus de \"Terminado\" en todas las Instrucciones delegadas\nAvance de: 99%\n\n";
                                        } else {
                                            strCadena1 += "Avance del Usuario: "+((strHistorial[i][7].indexOf(" / ")!=-1)?strHistorial[i][7]:strHistorial[i][7]+" / "+ActualizaUsuario.NombrePuesto(strHistorial[i][3])) +"\nAvance de: "+strHistorial[i][4]+"% \n\n";
                                        }
                                }
				if(new Integer(strHistorial[i][6]).intValue()==2) {
					strCadena1 += "'Documento Rechazado por: "+strHistorial[i][9]+"\nRazón de Rechazo: "+strHistorial[i][5]+"\n\n";
                                }
                                
                                if(new Integer(strHistorial[i][6]).intValue()==3) {
					strCadena1 += "Documento Reasignado a : "+ActualizaInstrucciones.NombreUsuarioInstruccion(strId)+" por el Usuario: "+((strHistorial[i][7].indexOf(" / ")!=-1)?strHistorial[i][7]:strHistorial[i][7]+" / "+ActualizaUsuario.NombrePuesto(strHistorial[i][3]))+"\nComentarios adicionales:"+strHistorial[i][5]+"\n\n";
                                }
				if(new Integer(strHistorial[i][6]).intValue()==4) {
                                        strCadena1 += "Documento Delegado a : " +ActualizaUsuario.NombreUsuario(strDelegado) + "\nComentarios Adicionales: " + strHistorial[i][4] + "\n\n";
                                }
                                if(new Integer(strHistorial[i][6]).intValue()==5) {
                                        strCadena1 += "El Usuario: "+((strHistorial[i][7].indexOf(" / ")!=-1)?strHistorial[i][7]:strHistorial[i][7]+" / "+ActualizaUsuario.NombrePuesto(strHistorial[i][3])) +" Generó Instrucciones para Atender la solicitud\n\n";
                                }
                                if(new Integer(strHistorial[i][6]).intValue()==6) {
                                        strCadena1 += "Puesto: " + strHistorial[i][7] + "\nComentario: "+strHistorial[i][5]+"\n\n";
                                }
                                if(new Integer(strHistorial[i][6]).intValue()==7) {
                                        strCadena1 += "El Usuario: "+((strHistorial[i][7].indexOf(" / ")!=-1)?strHistorial[i][7]:strHistorial[i][7]+" / "+ActualizaUsuario.NombrePuesto(strHistorial[i][3])) +"\nComentario: "+strHistorial[i][5]+"\n\n";
                                }
                                if(new Integer(strHistorial[i][6]).intValue()==8) {
                                        strCadena1 += "El Usuario: "+((strHistorial[i][7].indexOf(" / ")!=-1)?strHistorial[i][7]:strHistorial[i][7]+" / "+ActualizaUsuario.NombrePuesto(strHistorial[i][3]))+"\nComentario: "+strHistorial[i][5]+"\n\n";
                                }
                                if(new Integer(strHistorial[i][6]).intValue()==9) {
                                        strCadena1 += "El Usuario: "+((strHistorial[i][7].indexOf(" / ")!=-1)?strHistorial[i][7]:strHistorial[i][7]+" / "+ActualizaUsuario.NombrePuesto(strHistorial[i][3])) +"\nComentario: "+strHistorial[i][5]+"\n\n";
                                }
			}   
                }
		return strCadena1;
	}
	
	/**
	 * @return devuelve Historial de la instrucción
	 */
	public String getHistorial(){
		return strCadena;
	}

	
}
