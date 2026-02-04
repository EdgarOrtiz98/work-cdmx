/*
 * Clase:						BeanPieChart.java
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.data.general.DefaultPieDataset;

import de.laures.cewolf.DatasetProducer;

/**
 * Clase para generar graficas 3D tipo Pie
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class BeanPieChart  implements DatasetProducer {
    
    private String[][] strEtiquetas = null;
    
    private String CONTROL = "";

    /**
     * Prepara lo parametros para la construccion de la Grafica
     * 
     * @param strEtiquetas Datos de la grafica
     * @param control Control de datos
     * 
     */
    public BeanPieChart(String[][] strEtiquetas, String control){
        this.strEtiquetas = strEtiquetas;
        this.CONTROL = control;
    }
    
    /**
     * Construye el Objeto DefaultIntervalCategoryDataset para hacer la grafica
     * 
     * @param params Parametros de entrada 
     * 
     * @return Regresa un objeto DefaultIntervalCategoryDataset
     */

    public Object produceDataset(Map params){

      	DefaultPieDataset ds = new DefaultPieDataset();
      	for (int i = 0; i < strEtiquetas.length; i++) {
      	    double a = new Double(strEtiquetas[i][4]).doubleValue();
      	  if(CONTROL.equals("0"))
      	      ds.setValue(strEtiquetas[i][2], new Double(strEtiquetas[i][4]).doubleValue());
      	  else
      	      ds.setValue(strEtiquetas[i][1], new Double(strEtiquetas[i][4]).doubleValue());
      	}
      	return ds;
    }
    
    public String getProducerId() {
    	return "pieData";
    }
    public boolean hasExpired(Map params, Date since) {
        log.debug(this + ".hasExpired()");
        return System.currentTimeMillis() - since.getTime() > 1000L;
    }
    
    private static final Log log;
    static 
    {
        log = LogFactory.getLog(Bean3dChart.class);
    }

}

