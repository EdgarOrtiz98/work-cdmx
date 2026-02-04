
package com.meve.sigma.util;

import java.text.NumberFormat;

import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaInstrucciones;

/**
 * Clase que calcula el avance de Instrucciones y Asuntos
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class CalculoAvance {
	

	public CalculoAvance() {
	}
	
	/**
	 * Calcula el avance de uns instruccion y el avance relativo de un asunto
	 * 
	 * @param strIdAsunto ID del Asunto 
	 * @param strIdInstruccion ID de la Instruccion 
	 */
	public void calculoAvance(String strIdAsunto, String strIdInstruccion){
		String strIdPadre = "";
		float fAvance = 0;
		
        boolean bEsHijo	=	ActualizaAsuntoTurnado.getEsHijo(strIdInstruccion);
        if(bEsHijo){
        	//** Trae el ID del padre
        	strIdPadre	=	ActualizaAsuntoTurnado.getIdPadre(strIdInstruccion);
        	
        	//** trae el total de hijos que tiene el padre
            String countHijos[][]=	ActualizaAsuntoTurnado.getCountInstruccionPadre(strIdPadre);
            ////System.err.println("countHijos"+countHijos[0][0]);
            //** trae la suma de los avances de las instrucciones hijas
            String sumHijos[][]	 =	ActualizaAsuntoTurnado.getSumInstruccionPadre(strIdPadre);
            
            String strSuma = "";
            int bandera = 0;
        	if(sumHijos.length==0 && sumHijos==null){
            	strSuma = "0";
            	bandera = 1;
            	////System.err.println("bandera1");
        	}
            else{
            	strSuma = sumHijos[0][0];
            	bandera = 2;
            	////System.err.println("bandera2");
            }
        	
            float avancePadre = 0;
            String strAvancePadre = ActualizaInstrucciones.getAvanceOriginal(strIdPadre);
            ////System.err.println("strAvancePadre="+strAvancePadre);
            try{
                if (strAvancePadre != null && strAvancePadre.length()!=0/*!strAvancePadre.equals("") && !strAvancePadre.equals("null")*/){
                	avancePadre = Float.parseFloat(strAvancePadre);         
                }
                else {
                	avancePadre = 0;
                }
            }
            catch (Error e){
            	avancePadre = 0;            	
            }
            float suma		=	new Float(strSuma).floatValue();
            float count 	=	new Float(countHijos[0][0]).floatValue();
            ////System.err.println("suma="+suma);
            ////System.err.println("count="+count);
            //fAvance 		= 	suma/count;
            if(bandera==2){
            	fAvance 	= 	((suma/count)*((100f-avancePadre)/100f))+avancePadre;
            	////System.err.println("bandera3="+fAvance);
            }
            else{
            	fAvance		=	100;
            	////System.err.println("bandera4="+fAvance);
            }
            NumberFormat df	=	NumberFormat.getNumberInstance();
            
        	df.setMaximumFractionDigits(2);
        	boolean bAct = false;
        	if(fAvance>=100){
        		////System.err.println("actualiza al 99=");
        		bAct 	=	ActualizaAsuntoTurnado.ActualizaAvancePadre(strIdPadre, "99");
        	}
        	else{
        		String strTotal	=	df.format(fAvance);
        		bAct 	=	ActualizaAsuntoTurnado.ActualizaAvancePadre(strIdPadre, strTotal);
        		////System.err.println("total del padre calculado="+strTotal);
        	}
        	calculoAvance(strIdAsunto, strIdPadre);
        }else{
        	String strCount[][]	=	ActualizaAsuntoTurnado.getCountInstruccion(strIdAsunto);
        	String strSum[][]	=	ActualizaAsuntoTurnado.getSumInstruccion(strIdAsunto);
        	
        	String strSuma = "";
        	int bandera = 0;
        	//if(strSum.length==0 && strSum==null){
        	if(strSum==null || strSum.length==0 || strSum[0][0].equals("")){
            	strSuma = "0";
            	bandera = 1;
            	////System.err.println("bandera1");
        	}
            else{
            	strSuma = strSum[0][0];
            	bandera = 2;
            	////System.err.println("bandera2");
            }
        	/*if(strSum.length==0 && strSum==null)
            	strSuma = "0";
            else
            	strSuma = strSum[0][0];*/
        	
        	float suma		=	new Float(strSuma).floatValue();
            float count 	=	new Float(strCount[0][0]).floatValue();
            if(bandera==2){
            	fAvance 	= 	suma/count;
            }
            else{
            	fAvance		=	100;
            }
            /*if(suma!=0 && count!=0)
            	fAvance 	= 	suma/count;
            else
            	fAvance		=	100;*/
            NumberFormat df	=	NumberFormat.getNumberInstance();
            
        	df.setMaximumFractionDigits(2);
        	
        	boolean bAct = false;
        	if(fAvance>=100){
        		bAct = ActualizaAsuntoTurnado.ActualizaAvanceAsunto(strIdAsunto, "99");
        	}
        	else{
        		String strTotal	=	df.format(fAvance);
        		bAct = ActualizaAsuntoTurnado.ActualizaAvanceAsunto(strIdAsunto, strTotal);
        	}
        }  	
        
	}
	
	/**
	 * Calcula el avance general de un Asunto
	 * @param strIdAsunto ID del Asunto
	 */
	public void calculoAvanceGeneral(String strIdAsunto){
		String strCount[][]	=	ActualizaAsuntoTurnado.getCountInstruccion(strIdAsunto);
    	String strSum[][]	=	ActualizaAsuntoTurnado.getSumInstruccion(strIdAsunto);
    	String strSuma = "";
    	int bandera = 0;
    	if(strSum.length==0 && strSum==null){
    		strSuma = "0";
        	bandera = 1;
        }else{
        	bandera = 2;
        	strSuma = strSum[0][0];
        }
    	
    	float suma		=	new Float(strSuma).floatValue();
        float count 	=	new Float(strCount[0][0]).floatValue();
        float fAvance	=	0;
        if(bandera==2){
        	fAvance	= 	suma/count;
        	if(fAvance==100){
        		fAvance = 99;
        	}
        }else if(bandera==1){
        	fAvance	=	99;
        }
        NumberFormat df	=	NumberFormat.getNumberInstance();
    	df.setMaximumFractionDigits(2);
    	String strTotal	=	df.format(fAvance);
    	boolean bAct = ActualizaAsuntoTurnado.ActualizaAvanceAsunto(strIdAsunto, strTotal);
	}
	
	/**
	 * Calcula el avance general de uns Instruccion Padre
	 * 
	 * @param strIdPadre ID de la instruccion
	 */
	public void calculoAvanceInsPadre(String strIdPadre){
		String countHijos[][]=	ActualizaAsuntoTurnado.getCountInstruccionPadre(strIdPadre);
        String sumHijos[][]	 =	ActualizaAsuntoTurnado.getSumInstruccionPadre(strIdPadre);
        
        float avancePadre = 0;
        String strAvancePadre = ActualizaInstrucciones.getAvanceOriginal(strIdPadre);
        ////System.err.println("strAvancePadre="+strAvancePadre);
        try{
            if (strAvancePadre != null && strAvancePadre.length()!=0/*!strAvancePadre.equals("") && !strAvancePadre.equals("null")*/){
            	avancePadre = Float.parseFloat(strAvancePadre);
            }
            else {
            	avancePadre = 0;
            }
        }
        catch (Error e){
        	avancePadre = 0;            	
        }
        String strSuma = "";
        int bandera = 0;
        if(sumHijos.length==0 || sumHijos==null || sumHijos[0][0].equals("")){
        	strSuma = "0";
        	bandera = 1;
        	////System.err.println("bandera1="+strSuma);
        }else{
        	bandera = 2;
        	strSuma = sumHijos[0][0];
        	////System.err.println("bandera2="+strSuma);
        }
        float suma		=	new Float(strSuma).floatValue();
        float count 	=	new Float(countHijos[0][0]).floatValue();
        ////System.err.println("suma="+suma);
        ////System.err.println("count="+count);
        //float fAvance	= 	suma/count;
        float fAvance 	=	0;
        //if(suma!=0 && count!=0){
        if(bandera==2){
        	fAvance 	= 	((suma/count)*((100f-avancePadre)/100f))+avancePadre;
        	if(fAvance==100)
        		fAvance = 99;
        	////System.err.println("bandera3="+fAvance);
        }
        else{
        	fAvance		=	99;
        	////System.err.println("bandera4="+fAvance);
        }
        NumberFormat df	=	NumberFormat.getNumberInstance();
        
    	df.setMaximumFractionDigits(2);
    	String strTotal	=	df.format(fAvance);
    	boolean bAct 	=	ActualizaAsuntoTurnado.ActualizaAvancePadre(strIdPadre, strTotal);
	}

}
