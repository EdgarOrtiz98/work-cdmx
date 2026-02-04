/*
 * Created on Sep 6, 2005
 */
package com.meve.sigma.taglib;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
//import java.sql.*;
import java.io.*;


/**
 * Crea una etiqueta tipo tree-menu Instrucciones
 * @author Meve Soluciones S.A. de C.V.
 * @version	1.0
 */
public class TglArbolInstrucciones extends TagSupport{
    
    private String strId_Asunto = null;
	private String strNombre = null;
	private String strFiltro = null;	
	/**
	 * Asigna id de asunto
	 * @param pId_asunto Id asunto
	 */
	public void setid_asunto(String pId_asunto)
	{
		strId_Asunto = pId_asunto;
	}	
	/**
	 * Asigna nombre de asunto
	 * @param pNombre nombre asunto
	 */
	public void setnombre(String pNombre)
	{
		strNombre = pNombre;
	}
	/**
	 * semáforo
	 * @param pFiltro
	 */
	public void setfiltro(String pFiltro)
	{
		strFiltro = pFiltro;
	}
	/**
	 * Método que será invocado cuando se encuEntró el tag de comienzo. 
	 * Este Método debe retornar un valor entero, definido por 2 constantes:
	 * EVAL_BODY_INCLUDE: El body debe ser evaluado.
	 * SKIP_BODY: Salta directamente al doEndTag, salteando el body.
	 * @throws JspException Constructs a new JSP exception when the JSP needs to throw an exception and include a message about the "root cause" exception that interfered with its normal operation. 
	 */
	public int doStartTag()throws JspException{
		try
		{						
			JspWriter out = pageContext.getOut();			
			out.println(Html.creaArbolActividades(strId_Asunto,strNombre,strFiltro));			
			
		}catch(IOException ioE){
			throw new JspException("Error de tipo IO al Crear Arbol de Actividades: " + ioE);
		}
		return SKIP_BODY;		
	}

}
