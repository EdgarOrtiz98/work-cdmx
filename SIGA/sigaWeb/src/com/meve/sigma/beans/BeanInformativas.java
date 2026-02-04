/*
 * Clase:						ResponderBean.java
 * 
 * Paquete:						com.meve.sigma.beans		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Nov 1, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		La Función calcula el avance final de una instrucción informativa,
 * 								asi como el avance general del asunto al que pertenece la instrucción.
 * 								
 */
package com.meve.sigma.beans;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.Calendar;

import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.util.Utilerias;


/**
 * Bean que almacena las instrucciones informativas
 * 
 * @author Meve Soluciones SA de CV
 */
public class BeanInformativas {
	
	/**
	 * Procesa los datos de una instrucción informativa
	 * @param IdAsunto	Id asunto
	 * @param strIdInstruccion	id instrucción
	 * @param strFechaCreacion	Fecha creación
	 * @param BUsuario	Bean usuario
	 * @param Smail		Servidor mail
	 * @param PMail		Puerto salida mail
	 * @param SN		Nombre servidor
	 * @param strBase	Contexto aplicación
	 */
	public void instruccionesInformativas(	String IdAsunto, String strIdInstruccion,
											String strFechaCreacion, UsuarioBean BUsuario, 
											String Smail, String PMail, String SN,
											String strBase){
		
		boolean bActualizaInf = false;
		boolean bInsertar 	= 	false;
		
		String strCount[][] = 	null;
		String strSum[][] 	=	null;
		
		Date fechaTerminacionReal	=	new Date(new java.util.Date().getTime());
		String strFechaReal 		= 	fechaTerminacionReal.toString();
		String strDates[][] 		= 	ActualizaAsuntoTurnado.FechasAsignacion(strIdInstruccion);
        String fechaInicio 			= 	strDates[0][0];
        Calendar cFechaInicio		=	Utilerias.StringCalendar(fechaInicio);
        Calendar cFechaFin 			=	Utilerias.StringCalendar(strFechaReal);
        int real 					= 	Utilerias.DiasdeTrabajoEntre(cFechaInicio, cFechaFin, 0);
		
		bActualizaInf 	= 	ActualizaInstrucciones.getTerminaInstruccionInsformativa(strIdInstruccion, strFechaCreacion, real);
		//bInsertar		=	ActualizaHistorial.InsertarRespuesta(strIdInstruccion, IdAsunto, "instrucción Informativa",
		//												BUsuario.getIdUsuario(), "99", strFechaCreacion, BUsuario.getCargo());
		
		strCount		=	ActualizaAsuntoTurnado.getCountInstruccion(IdAsunto);
    	strSum			=	ActualizaAsuntoTurnado.getSumInstruccion(IdAsunto);
    	String strAva	=	"0";
    	float fAvance = new Float("0").floatValue();
    	float su= new Float(strSum[0][0]).floatValue();
    	float a = new Float(strAva).floatValue();
    	float c = new Float(strCount[0][0]).floatValue();
    	float dif = a - fAvance;
    	float total = (su+dif)/c;
    	NumberFormat df = NumberFormat.getNumberInstance();
    	df.setMaximumFractionDigits(2);
    	String strTotal = df.format(total);
    	boolean bAct = ActualizaAsuntoTurnado.ActualizaAvanceAsunto(IdAsunto, strTotal);//Actualiza avance del asunto
	}

}
