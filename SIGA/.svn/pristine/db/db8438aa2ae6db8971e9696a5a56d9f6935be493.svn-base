/*
 * Creado el 9/07/2007
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.meve.sigma.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Administrador
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComboMultiple extends TagSupport{
	
	private String data[][] 		= 	null;
	private String name 			= 	null;
	private int size 				= 	1;
	private String[] selected 		= 	null;
	private boolean disabled 		= 	false;
	private boolean multiple 		= 	false;
	private String classHtml 		= 	null;
	private String style 			= 	null;
	private String script 			=	null;
	private String textoNoSeleccion	= 	null;
	private String valorNoSeleccion = 	null;
	
	/**
	 * Asigna el valor que sera asociado a la etiqueta
	 * @param pdata valor asociado 
	*/
	public void setData(String[][] pdata){
		data = pdata;
	}
	/**
	 * Asigna el nombre identificador al campo
	 * @param pname nombre identificador
	*/	
	public void setName(String pname){
		name = pname;
	}
	/**
	 * Asigna el Número de opciones visibles
	 * @param psize	Número de opciones visibles
	*/	
	public void setSize(int psize){
		size = psize;
	}
	/**
	 * Asigna la opción por defecto
	 * @param pselected opción por defecto
	*/	
	public void setSelected(String[] pselected){
		selected = pselected;
	}
	/**
	 * Asigna la opción que desactiva la lista
	 * @param pdisabled opción para desactivar la lista
	*/	
	public void setDisabled(boolean pdisabled){
		disabled = pdisabled;
	}
	/**
	 * Asigna la opción que permite elegir varias de las opciones a la vez
	 * @param pmultiple opción que permite elegir varias de las opciones a la vez
	*/	
	public void setMultiple(boolean pmultiple){
		multiple = pmultiple;
	}
	/**
	 * Asigna la clase asociada a la etiqueta
	 * @param pclassHtml clase asociada
	*/	
	public void setClassHtml(String pclassHtml){
		classHtml = pclassHtml;
	}
	/**
	 * Asigna la opcion que permite agregar un estilo
	 * @param pstyle opcion que permite agregar un estilo
	*/	
	public void setStyle(String pstyle){
		style = pstyle;
	}
	/**
	 * Asigna script relacionado a la etiqueta
	 * @param pscript script relacionado a la etiqueta
	*/		
	public void setScript(String pscript){
		script = pscript;
	}
	/**
	 * Asigna Texto de cabecera para la etiqueta
	 * @param ptextoNoSeleccion	Texto de cabecera para la etiqueta
	*/
	public void setTextoNoSeleccion(String ptextoNoSeleccion){
		textoNoSeleccion = ptextoNoSeleccion;
	}
	/**
	 * Asigna valor de texto no seleccionado
	 * @param pvalorNoSeleccion	valor de texto no seleccionados
	*/
	public void setValorNoSeleccion(String pvalorNoSeleccion){
		valorNoSeleccion = pvalorNoSeleccion;
	}
	/**
	 * Elabora la etiqueta html SELECT
	 * @see com.meve.sigma.taglib.Html
	*/
	public int doStartTag()throws JspException{
		try
		{
		    JspWriter out = pageContext.getOut();			
			out.println(Html.creaSelectMultiple(data, name, size, selected, disabled, multiple, classHtml, style, script, textoNoSeleccion, valorNoSeleccion));
			
		}catch(IOException ioE){
			throw new JspException("Error de tipo IO al crear comboMultiple: " + ioE);
		}

		return SKIP_BODY;	
	}

}
