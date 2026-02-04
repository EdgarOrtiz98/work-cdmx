/*
 * Clase:						BeanTimePlanChart.java
 * 
 * Paquete:						com.meve.sigma.reportes		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Apr 21, 2006
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.data.category.DefaultIntervalCategoryDataset;

import de.laures.cewolf.DatasetProducer;

/**
 * Bean para exportar los Reportes de Tiempo Planeado
 *
 * @author Meve Soluciones S.A. de C.V.
 */
public class BeanTimePlanChart implements DatasetProducer{
    
    /**
     * strDocumentos Contiene el nombre de los tipos de documentos
     */
    private String[][] strDocumentos = null;
    
    /**
     * Prepara lo parametros para la construccion de la Grafica
     * 
     * @param strDocumentos Datos de la grafica
     * 
     */
    public BeanTimePlanChart(String[][] strDocumentos){
        this.strDocumentos = strDocumentos;
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
        String[] categories = {"Mas Corto", "Mas Largo", "Promedio"};//new String[strDocumentos.length];
        for(int y = 0; y<strDocumentos.length;y++){
        	seriesNames[y] = strDocumentos[y][2];
        }
        
        final Double[][] startValues = new Double[seriesNames.length][categories.length];
        final Double[][] endValues = new Double[seriesNames.length][categories.length];
        
        for (int series = 0; series < seriesNames.length; series++) {
            int z = 5;
            for (int i = 0; i < categories.length; i++) {
                int y = 0;
                startValues[series][i] = new Double(y);
                endValues[series][i] = new Double(strDocumentos[series][z]);
                z++;
            } 
        } 
        DefaultIntervalCategoryDataset ds =
          new DefaultIntervalCategoryDataset(seriesNames, categories, startValues, endValues);
        return ds;
    }
    
    /**
     * @return Caneda TimePlanChar
     */
    public String getProducerId() {
        return "TimePlanChar";
    }
    
    /**
     * @return Regresa un booleano si ha expirado
     */
    public boolean hasExpired(Map params, Date since) {
        log.debug(this + ".hasExpired()");
        return System.currentTimeMillis() - since.getTime() > 1000L;//false;
    }

    private static final Log log;
    static 
    {
        log = LogFactory.getLog(BeanTimePlanChart.class);
    }

}

