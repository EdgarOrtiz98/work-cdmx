/*
 * Created on Sep 6, 2005
 */
package com.meve.sigma.taglib;

import com.meve.sigma.actualiza.ActualizaClasificacion;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.util.Utilerias;

//import java.sql.*;
//import java.util.*;



/**
 * Crea etiquetas HTML
 * @author 	Meve Soluciones
 *
 * @version	1.0
 */
public class Html {
    
    private Html(){
	}
	/**
	 * Crea una etiqueta tipo SELECT
	 * @param data el valor que sera asociado 
	 * @param name nombre identificador al campo
	 * @param size  Número de opciones visibles
	 * @param selected opción por defecto
	 * @param disabled opción que desactiva la lista
	 * @param multiple opción permite elegir varias de las opciones a la vez
	 * @param classHtml clase asociada
	 * @param style	opcion que permite agregar un estilo
	 * @param script script relacionado a la etiqueta
	 * @param textoNoSeleccion  Texto de cabecera para la etiqueta
	 * @param valorNoSeleccion valor de texto no seleccionado
	 * @return cadena que representa la etiqueta
	 */
	public static String creaSelect(	String data[][], 
										String name, 
										int size, 
										String selected, 
										boolean disabled, 
										boolean multiple, 
										String classHtml, 
										String style, 
										String script, 
										String textoNoSeleccion, 
										String valorNoSeleccion)
	{
		StringBuffer select = new StringBuffer();
		
		select.append("\n\t<select ");
		if(name != null)
			select.append(" name =\"" + name + "\" ");
			
		select.append(" size=\"" + size + "\" ");
		
		if(disabled)
			select.append(" disabled ");
			
		if(multiple)
			select.append(" multiple ");
			
		if(classHtml != null)
			select.append(" class=\"" + classHtml + "\" ");
			
		if(style != null)
			select.append(" style=\"" + style + "\" ");
			
		if(script != null)
			select.append(" " + script + " ");
			
		select.append(" >");
		
		if(textoNoSeleccion != null && valorNoSeleccion != null)
		{
			select.append("\n\t\t<option value=\"" + valorNoSeleccion + "\" title=\"" + textoNoSeleccion + "\">");
			select.append(textoNoSeleccion);
			select.append("</option>");			
		}
		
		if(data != null)
			for(int i = 0; i < data.length; i++)
			{
				select.append("\n\t\t<option value=\"" + data[i][0] + "\" title=\"" + data[i][1] + "\"");
				if(selected != null && data[i][0].equalsIgnoreCase(selected))
					select.append(" selected ");
				select.append(">");
				select.append(data[i][1]);
				select.append("</option>");
			}
			
		select.append("\n\t</select>");
		
		return select.toString();
	}
	
	/**
	 * Crea una etiqueta tipo tree-menu
	 * @param strId_Proy id asunto
	 * @param strNombre nombre elemento carpeta
	 * @param strFiltro Indicador
	 * @return cadena que representa la etiqueta
	 */
	public static String creaArbolActividades(	String strId_Proy,
												String strNombre, 
												String strFiltro)
	{
	    StringBuffer strbArbol = new StringBuffer();				
	    String strIdClasificacion	=	"";
	    String strTipoClasificacion	=	"";
	    String strInfoAsunto		=	"";
	    String strUrlAsunto			=	"";
	    String strToolAsunto		=	"";
	    String strImagen			=	"../Imagenes/";
	    String strPadre				=	"";
	    String strNombreCla			=	"Clasificación de Asuntos";
	    String strClaAsuntos[][]	=	ActualizaClasificacion.getListaClasificacion("1", "asc");
	    String strAsuntos[][]		=	null;
	    if(strClaAsuntos.length > 0){
	        
	    }
	    	
	    strbArbol.append("\n<SCRIPT type=text/javascript>	");				
	    strbArbol.append("\n	"+strNombre+" = new dTree('"+strNombre+"');");
	    strbArbol.append("\n	"+strNombre+".add(0,-1,'"+strNombreCla+"');");
	    int a = 1;
	    int h = 1;
	    for(int i=0;i<strClaAsuntos.length;i++){
	        String strIdCla 		=	strClaAsuntos[i][0];
	        String strNombreTipo 	= 	strClaAsuntos[i][1];
	        //a = a;
	        //h = i+1;
	        strbArbol.append("\n	"+strNombre+".add("+a+",0,'"+strNombreTipo+"','','','','');");
	        strAsuntos = ActualizaClasificacion.getAsuntosHijos(strIdCla);
	        for(int j=0;j<strAsuntos.length;j++){
	            strbArbol.append("\n	"+strNombre+".add("+(a+1)+","+h+",'"+strAsuntos[j][1]+"','AsuntoTurnado.jsp?id_asunto="+strAsuntos[j][0]+"','Ver detalle Asunto','','');");
	            a = a+1;
	        }
	        a = a+1;
	        h = a;
	    }	
	    strbArbol.append("\n	document.write("+strNombre+");");
	    strbArbol.append("\n</SCRIPT>");			
	    return strbArbol.toString();
	}
	/**
	 * Crea una etiqueta tipo tree-menu
	 * @param strIdInstruccion id instrucción
	 * @param strNombre nombre elemento carpeta
	 * @param strFiltro Indicador
	 * @return cadena que representa la etiqueta
	 */
	public static String arbolInstrionesAtender(String strIdInstruccion,
	        									String strNombre,
	        									String strFiltro)
	{
	    StringBuffer strbArbol = new StringBuffer();
	    String strIdClasificacion	=	"";
	    String strTipoClasificacion	=	"";
	    String strInfoInstruccion	=	"";
	    String strUrlInstruccion	=	"";
	    String strToolInstruccion	=	"";
	    String strImagen			=	"../Imagenes/";
	    String strPadre				=	"";
	    String strNombreCla			=	"Instrucciones en Tramite";
	    String strInstAtender[][]	=	ActualizaInstrucciones.UsuarioInstruccionAtender("");
	    String strInstUsrAtender[][]=	null;
	    float fPorcentaje = 0;
	    
	    strbArbol.append("\n<SCRIPT type=text/javascript>	");				
	    strbArbol.append("\n	"+strNombre+" = new dTree('"+strNombre+"');");
	    strbArbol.append("\n	"+strNombre+".add(0,-1,'"+strNombreCla+"');");
	    int a = 1;
	    int h = 1;
	    for(int i=0;i<strInstAtender.length;i++){
	        String strIdUsuario = ActualizaUsuario.NombreUsuario(strInstAtender[i][0]);
	        strbArbol.append("\n	"+strNombre+".add("+a+",0,'"+strIdUsuario+"','','','','');");
	        strInstUsrAtender = ActualizaInstrucciones.getInstruccionAtenderUsuario(strInstAtender[i][0]);
	        for(int j=0;j<strInstUsrAtender.length;j++){
	            String Info = "";
	            String Inst = "";
	            String folio = strInstUsrAtender[j][5]; //Folio
	            String Desc	=  strInstUsrAtender[j][6]; // Descripcion_Asunto
	            String fechaI = strInstUsrAtender[j][2]; // Fecha Inicio
	            String fechaF = strInstUsrAtender[j][3]; // Fecha Fin
	            
	            fPorcentaje = Utilerias.getPorcentajeDebido(new Integer(strInstUsrAtender[j][8]).intValue(), strInstUsrAtender[j][2], strInstUsrAtender[j][3], 5);
				float iAvance = new Float(strInstUsrAtender[j][9]).floatValue();
				//if(fPorcentaje >= 100)
	            if(strInstUsrAtender[j][1].length() == 0)
					Inst = strInstUsrAtender[j][7];
				else
				    Inst = strInstUsrAtender[j][1];
	            
	            Info = folio +"                             "+ Desc+"("+Inst+")				"+fechaI+" -- "+fechaF+" 		";
	            
	            strbArbol.append("\n	"+strNombre+".add("+(a+1)+","+h+",'"+Info+"','InstruccionesAtender.jsp?id_ins="+strInstUsrAtender[j][0]+"','Ver detalle Asunto','','');");
	            a = a+1;
	        }
	        a = a+1;
	        h = a;
	    }
	    strbArbol.append("\n	document.write("+strNombre+");");
	    strbArbol.append("\n</SCRIPT>");
	    return strbArbol.toString();
	}
	
	/**
	 * Crea una etiqueta tipo SELECT
	 * @param data el valor que sera asociado 
	 * @param name nombre identificador al campo
	 * @param size  Número de opciones visibles
	 * @param selected opción por defecto
	 * @param disabled opción que desactiva la lista
	 * @param multiple opción permite elegir varias de las opciones a la vez
	 * @param classHtml clase asociada
	 * @param style	opcion que permite agregar un estilo
	 * @param script script relacionado a la etiqueta
	 * @param textoNoSeleccion  Texto de cabecera para la etiqueta
	 * @param valorNoSeleccion valor de texto no seleccionado
	 * @return cadena que representa la etiqueta
	 */
	public static String creaSelectMultiple(String data[][], 
										String name, 
										int size, 
										String[] selected, 
										boolean disabled, 
										boolean multiple, 
										String classHtml, 
										String style, 
										String script, 
										String textoNoSeleccion, 
										String valorNoSeleccion)
	{
		StringBuffer select = new StringBuffer();
		
		select.append("\n\t<select ");
		if(name != null)
			select.append(" name =\"" + name + "\" ");
			
		select.append(" size=\"" + size + "\" ");
		
		if(disabled)
			select.append(" disabled ");
			
		if(multiple)
			select.append(" multiple ");
			
		if(classHtml != null)
			select.append(" class=\"" + classHtml + "\" ");
			
		if(style != null)
			select.append(" style=\"" + style + "\" ");
			
		if(script != null)
			select.append(" " + script + " ");
			
		select.append(" >");
		
		if(textoNoSeleccion != null && valorNoSeleccion != null)
		{
			select.append("\n\t\t<option value=\"" + valorNoSeleccion + "\" title=\"" + textoNoSeleccion + "\">");
			select.append(textoNoSeleccion);
			select.append("</option>");			
		}
		
		if(data != null)
			for(int i = 0; i < data.length; i++)
			{
				select.append("\n\t\t<option value=\"" + data[i][0] + "\" title=\"" + data[i][1] + "\"");
				//if(selected != null && data[i][0].equalsIgnoreCase(selected[i]))
				if(selected != null && getSelected(data[i][0], selected))
					select.append(" selected ");
				select.append(">");
				select.append(data[i][1]);
				select.append("</option>");
			}
			
		select.append("\n\t</select>");
		
		return select.toString();
	}
	
	/**
	 * Función que verifica si el id del asitente es igual al del combo
	 * para mostrarlo como seleccionado en la lista
	 * @param idAsistente Id del asistente
 	 * @param selected Arreglo de los ids de asistentes
	 * @return true si es igual
	 */
	public static boolean getSelected(String idAsistente, String selected[]){
		boolean bEquals = false;
		for(int i=0;i<selected.length;i++){
			if(idAsistente.equals(selected[i]))
				bEquals = true;
		}
		return bEquals;
	}
}
