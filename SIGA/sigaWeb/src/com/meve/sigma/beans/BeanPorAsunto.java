/*
 * Clase:						BeanPorAsunto.java
 * 
 * Paquete:						com.meve.sigma.beans		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Mar 1, 2006
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

package com.meve.sigma.beans;

/**
 * Bean para almacenar las busquedas de un asunto
 * 
 * @author Meve Soluciones SA de CV
 */
public class BeanPorAsunto {
    
	/**
	 * Buscar por Recepción
	 */
    String buscarRecepcion;
    
    /**
     * Buscar por área
     */
    String buscarArea;
    
    /**
     * Buscar por Asunto
     */
    String buscarAsunto;
    
    /**
     * Buscar por tipo de documento
     */
    String buscarTDocto;
    
    /**
     * Buscar por fecha de generación
     */
    String buscarFechaGen;	
    
    /**
     * Buscar por fecha de vencimiento
     */
    String buscarFechaVen;
    
    
    /**
     * @param buscarRecepcion Recepción a establecer
     */
    public void setBuscarRecepcion(String buscarRecepcion)
    {
        this.buscarRecepcion = buscarRecepcion;
    }
    
    /**
     * @return Devuelve Recepción
     */
    public String getBuscarRecepcion()
    {
        return buscarRecepcion;
    }
    
    /**
     * @param buscarArea área a establecer
     */
    public void setBuscarArea(String buscarArea)
    {
        this.buscarArea = buscarArea;
    }
    
    /**
     * @return	Devuelve área
     */
    public String getBuscarArea()
    {
        return buscarArea;
    }
    
    /**
     * @param buscarAsunto Asunto a establecer
     */
    public void setBuscarAsunto(String buscarAsunto)
    {
        this.buscarAsunto = buscarAsunto;
    }
    
    /**
     * @return Devuelve asunto
     */
    public String getBuscarAsunto()
    {
        return buscarAsunto;
    }
    
    /**
     * @param buscarTDocto Tipo de docto a establecer
     */
    public void setBuscarTDocto(String buscarTDocto)
    {
        this.buscarTDocto = buscarTDocto;
    }
    
    /**
     * @return Devuelve tipo de docto.
     */
    public String getBuscarTDocto()
    {
        return buscarTDocto;
    }
    
    /**
     * @param buscarFechaGen Fecha de generación a establecer
     */
    public void setBuscarFechaGen(String buscarFechaGen)
    {
        this.buscarFechaGen = buscarFechaGen;
    }
    
    /**
     * @return Devuelve Fecha generación 
     */
    public String getBuscarFechaGen()
    {
        return buscarFechaGen;
    }
    
    /**
     * @param buscarFechaVen Fecha vencimiento a establecer
     */
    public void setBuscarFechaVen(String buscarFechaVen)
    {
        this.buscarFechaVen = buscarFechaVen;
    }
    
    /**
     * @return Devuelve fecha vencimiento
     */
    public String getBuscarFechaVen()
    {
        return buscarFechaVen;
    }

}

