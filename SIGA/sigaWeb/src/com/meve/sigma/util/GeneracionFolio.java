/*
 * Clase:						GeneracionFolio.java
 * 
 * Paquete:						com.meve.sigma.util		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Sep 21, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		Esta clase genera el folio de un asunto, a partir de los catalogos
 * 								de Folio y tipos de Documentos.
 */

package com.meve.sigma.util;


public class GeneracionFolio {
    
    /**
     *	Almacenara el folio
     */
    private static String strClaveFolio; 
    
    /**
     *  Almacenara el tipo de folio, ya sea recepcion o turnado
     */
    private static String strTipoFolio;
    
    /**
     * 	Verifica si se va a anteponer la clave del Documento
     */
    private static String strAnteponerClaveDocto;
    
    /**
     * 	Almacena el Orden en el que el usuario configurara el formato del Folio
     */
    private static String strOrden;
    
    /**
     * 	Almacena el numero consecutivo de un folio cuando es creado un Asunto
     */
    private static String strConsecutivo;
    
    /**
     * 	Almacena el ID del Tipo de Documento que selecciono el usuario al crear el Asunto
     */
    private static String strClaveTipoDocto;
    
    /**
     * Genera el folio mediante los parametros de entrada
     * @param claveTipoDocto Clave del Tipo de Documento
     * @param claveFolio Clave del Tipo de Folio 
     * @param consecutivo Consecutivo del Folio
     * @param orden Orden de construcción del folio 
     * 
     * @return Regresa un String con el folio generado
     */    
    public static String setGeneracionFolios(	String claveTipoDocto, String claveFolio, 
            									String consecutivo, String orden)
    {
        String folioFormado	=	"";
        strConsecutivo	=	consecutivo;
        strOrden		=	orden;
        
        if(claveTipoDocto == null)
        {
            strClaveFolio	=	"SCVE";
        }
        else
        {
            strClaveTipoDocto	=	claveTipoDocto;
        }
        
        if(claveFolio == null)
            strClaveFolio	=	"";
        else
            strClaveFolio	=	claveFolio;
        
        if(strConsecutivo.length() == 1)
            strConsecutivo	=	"0000000"+strConsecutivo;
        else if(strConsecutivo.length() == 2)
            strConsecutivo	=	"000000"+strConsecutivo;
        else if(strConsecutivo.length() == 3)
            strConsecutivo	=	"00000"+strConsecutivo;
        else if(strConsecutivo.length() == 4)
            strConsecutivo	=	"0000"+strConsecutivo;
        else if(strConsecutivo.length() == 5)
            strConsecutivo	=	"000"+strConsecutivo;
        else if(strConsecutivo.length() == 6)
            strConsecutivo	=	"00"+strConsecutivo;
        else if(strConsecutivo.length() == 7)
            strConsecutivo	=	"0"+strConsecutivo;
        else if(strConsecutivo.length() == 8)
            strConsecutivo	=	""+strConsecutivo;
        
        folioFormado	=	GeneracionFolio.getGeneraOrdenFolio(strOrden, strClaveTipoDocto,
                												strClaveFolio, strConsecutivo);
        
        ////System.out.println("***FOLIO="+folioFormado);
        
        return folioFormado;
        
    }
    
    /**
     * Determina la estructira de construccion del folio
     * 
     * @param orden Orden de construcción del folio 
     * @param claveDocto Clave del Documento
     * @param claveFolio Clave del Folio
     * @param consecutivo Consecutivo del Folio
     * 
     * @return Regresa un String con el Folio Ordenado 
     */
    public static String getGeneraOrdenFolio(	String orden, String claveDocto,
            									String claveFolio, String consecutivo)
    {
        String folioOrdenado = "";
        if(orden.length() == 3)
        {
            if(orden.equals("DAC"))
                folioOrdenado = claveDocto+"-"+claveFolio+"-"+consecutivo;
            if(orden.equals("DCA"))
                folioOrdenado = claveDocto+"-"+consecutivo+"-"+claveFolio;
            if(orden.equals("CAD"))
                folioOrdenado = consecutivo+"-"+claveFolio+"-"+claveDocto;
            if(orden.equals("CDA"))
                folioOrdenado = consecutivo+"-"+claveDocto+"-"+claveFolio;
            if(orden.equals("ADC"))
                folioOrdenado = claveFolio+"-"+claveDocto+"-"+consecutivo;
            if(orden.equals("ACD"))
                folioOrdenado = claveFolio+"-"+consecutivo+"-"+claveDocto;
        }
        else
        {
            if(orden.equals("AC"))
                folioOrdenado = claveFolio+"-"+consecutivo;
            if(orden.equals("CA"))
                folioOrdenado = consecutivo+"-"+claveFolio;
        }
        
        return folioOrdenado;
    }
    
    /**
     * Genera folio cuando no se encuentran en el catalogo
     * 
     * @param strNombreArea Nombre de la Unidad Administrativa
     * 
     * @return Regresa un String con el Folio generado
     */
    public static String setGeneracionSinFolio(String strNombreArea)
    {
        String strFolioGenerado = "";
        
        strFolioGenerado = strNombreArea + "-00000001";
        // //System.out.println("strfolioGenerado="+strFolioGenerado);
        
        return strFolioGenerado;
    }
}
