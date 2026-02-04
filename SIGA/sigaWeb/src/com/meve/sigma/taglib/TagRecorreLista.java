package com.meve.sigma.taglib;

//import java.util.Enumeration;
import javax.servlet.jsp.*;
//import javax.servlet.jsp.tagext.*;
import java.io.IOException;
import javax.servlet.jsp.tagext.BodyTagSupport;
 
 
/**
* Taglib que recorre un query sql dejando el body de despligue en el front
*
* @author  Meve Soluciones
* @version 1.0
*/ 
public class TagRecorreLista extends BodyTagSupport
{
    String strDatos[][]=null;
    String strCampo="";
    int iIndice=0;   
    /**
     * Asigna datos correspondiente para el taglib
     * @param strDatos
     */
	public void setDatos(String strDatos[][])
	{
	  this.strDatos = strDatos;
	  iIndice=0;	  
	}
	/**
	 * Asigna el nombre del campo
	 * @param strCampo
	 */
	public void setCampo(String strCampo)
	{
	  this.strCampo = strCampo;
	  iIndice=0;	
	}
	/**
	 * Método que será invocado cuando se encuEntró el tag de comienzo. 
	 * Este Método debe retornar un valor entero, definido por 2 constantes:
	 * EVAL_BODY_INCLUDE: El body debe ser evaluado.
	 * SKIP_BODY: Salta directamente al doEndTag, salteando el body.
	 * @throws JspException Constructs a new JSP exception when the JSP needs to throw an exception and include a message about the "root cause" exception that interfered with its normal operation. 
	 */
	public int doStartTag() throws JspException 
	{
	  return super.EVAL_BODY_AGAIN; 
	}   
	/**
	 * Este Método nos permite modificar el BodyContent antes de que sea evaluado.
	 * @throws JspException Constructs a new JSP exception when the JSP needs to throw an exception and include a message about the "root cause" exception that interfered with its normal operation. 
	 */
	public void doInitBody() throws JspException
	{
		  if (strDatos != null)
		  {
			  if (iIndice < strDatos.length)
			  {			     
			     for(int j=0;j<strDatos[iIndice].length;j++)			     
	        	     pageContext.setAttribute(strCampo+(j+1),strDatos[iIndice][j]);
	        	   iIndice++;
			  }
		  }
	}
	/**
	 * Método que se invoca después de cada evaluación del cuerpo para controlar si el cuerpo será reevaluado o no.
	 * @throws JspException Constructs a new JSP exception when the JSP needs to throw an exception and include a message about the "root cause" exception that interfered with its normal operation.
	 */
	public int doAfterBody() throws JspException
	{

	  if (strDatos != null  && iIndice < strDatos.length)
	  {
	     for(int j=0;j<strDatos[iIndice].length;j++)			     
	   	     pageContext.setAttribute(strCampo+(j+1),strDatos[iIndice][j]);
    	 iIndice++;	        	   
	      return EVAL_BODY_AGAIN;
   	  } else  
   	  {
	   
    	 return SKIP_BODY;
   	  }
	}
	/**
	 * Método que será invocado cuando se encuentre el tag de fin. 
	 * Este Método tambien retorna un entero, definido por otras 2 constantes: 
	 * EVAL_PAGE: indica que se continue evaluando la página.
	 * SKIP_PAGE: indica que se aborte el procesamiento del resto de la página.
	 * @throws JspException Constructs a new JSP exception when the JSP needs to throw an exception and include a message about the "root cause" exception that interfered with its normal operation.
	 */
	public int doEndTag() throws JspException
	{
	  try 	  
	  { 
	  	if(strDatos.length>0)
	  	 	pageContext.getOut().print(bodyContent.getString());
	    return EVAL_PAGE;
  	  }
	  catch (IOException ioe)
	  {
	    //throw new JspException(ioe.getMessage());
	     throw new JspException();
   	  }
	}
	/**
	 * Liberar recursos.
	 */
	public void release() {
		pageContext = null;
		try{
			bodyContent.clear();
		}catch(IOException ioe){
                /*
                    System.err.print(this.getClass()+": "+ioe.getMessage());
                    ioe.printStackTrace();*/
                }catch(Exception e){
                    /*System.err.print(this.getClass()+": "+e.getMessage());
                    e.printStackTrace();*/
                }
		
	}
}
