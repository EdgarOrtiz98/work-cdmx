/*
 * Clase:						TagArbolPortal.java
 * 
 * Paquete:						com.meve.sigma.taglib		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Dec 3, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		
 */

package com.meve.sigma.taglib;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import java.io.*;
/**
* Crea una etiqueta tipo tree-menu instrucciones
* @author  Meve Soluciones
*/ 

public class TagArbolPortal extends TagSupport{
    
    private String strId_Instruccion = null;
	private String strNombre = null;
	private String strFiltro = null;	
	/**
	 * Asignaid instrucción
	 * @param pId_instruccion id instrucción
	 */
	public void setid_instruccion(String pId_instruccion)
	{
		strId_Instruccion = pId_instruccion;
	}
	/**
	 * Asigna nombre elemento carpeta
	 * @param pNombre nombre elemento carpeta
	 */
	public void setnombre(String pNombre)
	{
		strNombre = pNombre;
	}
	/**
	 * Asigna Indicador
	 * @param pFiltro
	 */
	public void setfiltro(String pFiltro)
	{
		strFiltro = pFiltro;
	}
	/**
	 * Crea el  taglib para el arbol de las instrucciones
	 * @return regresa un entero que inidca el exito 
	 */
	public int doStartTag()throws JspException{
		try
		{						
			JspWriter out = pageContext.getOut();			
			out.println(Html.arbolInstrionesAtender(strId_Instruccion,strNombre,strFiltro));			
			
		}catch(IOException ioE){
			throw new JspException("Error de tipo IO al Crear Arbol de Actividades: " + ioE);
		}
		return SKIP_BODY;		
	}

}

