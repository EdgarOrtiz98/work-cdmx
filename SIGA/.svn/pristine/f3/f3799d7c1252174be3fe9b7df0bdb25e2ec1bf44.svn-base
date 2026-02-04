/*
 * Clase:						Bean3dChart.java
 * 
 * Paquete:						com.meve.sigma.reportes		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Apr 17, 2006
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

package com.meve.sigma.reportes;

import java.util.Date;
import java.util.Map;

import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import de.laures.cewolf.DatasetProducer;

/**
 * Clase para generar graficas 3D
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class Bean3dChart implements DatasetProducer{
    
    
    private String[][] strDocumentos = null;
    
    private String LABEL = "";
    
    private String CONTROL = "";
    
    /**
     * Prepara lo parametros para la construccion de la Grafica
     * 
     * @param strDocumentos Datos de la grafica
     * @param strEtiqueta Etiquetas de los ejes  
     * @param control Control de datos
     * 
     */
    public Bean3dChart(String[][] strDocumentos, String strEtiqueta, String control){
        this.strDocumentos = strDocumentos;
        this.LABEL	=	strEtiqueta;
        this.CONTROL = control;
    }
    
    /**
     * Construye el Objeto DefaultIntervalCategoryDataset para hacer la grafica
     * 
     * @param params Parametros de entrada 
     * 
     * @return Regresa un objeto DefaultIntervalCategoryDataset
     */
    public Object produceDataset(Map params) {
        
        String[] seriesNames = new String[strDocumentos.length];
        for(int y = 0; y<strDocumentos.length;y++){
            if(CONTROL.equals("0"))
            	seriesNames[y] = strDocumentos[y][2];
            else
            	seriesNames[y] = strDocumentos[y][1];
        }
        final String[] categories = { LABEL };
        final Integer[][] startValues = new Integer[seriesNames.length][categories.length];
        final Integer[][] endValues = new Integer[seriesNames.length][categories.length];
        
        for (int i = 0; i < strDocumentos.length; i++) {
            int y = 0;
            startValues[i][0] = new Integer(y);
            endValues[i][0] = new Integer(strDocumentos[i][3]);
        } 
        DefaultIntervalCategoryDataset ds =
          new DefaultIntervalCategoryDataset(seriesNames, categories, startValues, endValues);
        return ds;
    }
    
    public String getProducerId() {
        return "categoryData";
    }
    
    public boolean hasExpired(Map params, Date since) {
        log.debug(this + ".hasExpired()");
        return System.currentTimeMillis() - since.getTime() > 1000L;//false;
    }

    private static final Log log;
    static 
    {
        log = LogFactory.getLog(Bean3dChart.class);
    }
}

