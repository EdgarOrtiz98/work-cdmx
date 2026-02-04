package com.meve.sigma.util;

import java.util.Enumeration;
import javax.servlet.jsp.*;
//import javax.servlet.jsp.tagext.*;
import java.io.IOException;
import  javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Clase que contruye taglib en forma de lista
 * 
 * @author Meve Soluciones SA de CV
 */
public class ParamLoopTag extends BodyTagSupport{
	
	/**
	 * Enumeration
	 */
    Enumeration enumP=null;
    
    /**
     * Valro Enumerattion
     * @param enum	Enumeration
     */
	public void setEnum(Enumeration enumE)
	{
	  this.enumP = enumE;
	}
	
	/**
	 * Inicializa taglib
	 */
	public int doStartTag() throws JspException 
	{
	  return EVAL_BODY_AGAIN;
	}
    
	/**
	 * Contruye taglib
	 */
	public void doInitBody() throws JspException
	{
		  if (enumP != null)
		  {
			  if (enumP.hasMoreElements())
			  {
			     pageContext.setAttribute("nextParamName", enumP.nextElement());
        	     pageContext.setAttribute("campo1", pageContext.getAttribute("nextParamName"));
			  }
		  }
	}
	
	/**
	 * contruye eltaglib
	 */
	public int doAfterBody() throws JspException
	{
	  if (enumP.hasMoreElements())
	  {
	     pageContext.setAttribute("nextParamName", enumP.nextElement());
   	     pageContext.setAttribute("campo1", pageContext.getAttribute("nextParamName"));
	     //Continue looping
	      return EVAL_BODY_AGAIN;


   	  } else 
   	  {
	     // We're done
    	 return SKIP_BODY;
   	  }
	}
	
	/**
	 * Ejecuta el taglib
	 */
	public int doEndTag() throws JspException
	{
	  try 
	  {
    	// Get the current bodyContent for this tag and 
	    //write it to the original JSP writer
    	pageContext.getOut().print(bodyContent.getString());
	    return EVAL_PAGE;
  	  }
	  catch (IOException ioe)
	  {
	    throw new JspException(ioe.getMessage());
   	  }
	}
}
