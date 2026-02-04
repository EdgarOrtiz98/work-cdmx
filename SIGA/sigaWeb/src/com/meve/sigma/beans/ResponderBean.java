/**
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
 * Descripción de la clase:		Esta clase se encarga de registrar la respuesta de una 
 * 								instrucción
 */

package com.meve.sigma.beans;

import javax.servlet.http.HttpServletRequest;

import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
/**
 * Esta clase se encarga de registrar la respuesta de una instrucción
 * @author Meve Soluciones
 *
 */
public class ResponderBean {
	/**
	 * Registra la respuesta de una instrucción
	 * @param request solicitud
	 * @param BUsuario Bean de usuario
	 * @param Smail nombre del servidor de correos
	 * @param PMail	puerto del servidor
	 * @param SN nombre del servidor
	 * @param strBase contexto
	 * @param strTurnador turnador
	 */
    public void responderInstruccion(HttpServletRequest request, UsuarioBean BUsuario, 
    								String Smail, String PMail, String SN,
									String strBase, String strTurnador)
    {
        String strIdInstruccion		=	"";
    	boolean bEsHijo				=	false;
    	strIdInstruccion	=	request.getParameter("id_ins");
        
        //** determina si es hijo de una instruccion
        bEsHijo	= ActualizaAsuntoTurnado.getEsHijo(strIdInstruccion);
        
        String Bandera 	= ActualizaInstrucciones.getbandera(strIdInstruccion);
    	
        if(bEsHijo){
        	ResponderInstHija hija = new ResponderInstHija();
        	hija.respuestaInstruccionHija(	request, BUsuario, strTurnador,Smail, PMail, SN, strBase, Bandera);
        }else{
        	ResponderInstPadre padre = new ResponderInstPadre();
        	padre.respuestaInstruccionPadre(request, BUsuario, strTurnador,Smail, PMail, SN, strBase, Bandera);
        }
    }
}

