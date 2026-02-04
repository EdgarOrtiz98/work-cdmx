/*
 **************************************************************
 * Copyright (C) 2007 SHCP 
 * CGTIyC - alejandro_gavia@hacienda.gob.mx
 * 
 * $$Archivo: 	Unidad.java
 * $$Revisión: 	DARG - Creación del objeto instrucción.
 * $$Fecha: 	22 de Enero de 2007
 * 
 * Este software es información propietaria y confidencial de la SHCP - CGTIyC. 
 ***************************************************************
 */
 
package gob.hacienda.cgtic.siga;

import com.meve.sigma.db2.*;

import java.sql.SQLException;

public class Unidad {

    public Unidad() {
    }

    /**
     * @return Unidades
     */
    public String[][] getUnidades(){
        try
        {
            String strsql = "SELECT ID_AREA, ARE_NOMBRE from SD_AREA " + 
            "WHERE ARE_ESTATUS = 1 ORDER BY 2";
//            System.out.println("Unidad.getUnidades: " +strsql);
            return ConexionDS.ejecutarSQL(strsql);
        }catch(SQLException sqle){
            //System.out.println("Unidad.getUnidades: " + sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }        
    }

    public String[][] getUnidades(String idAsunto){
        try
        {
            String strsql = "SELECT ASU_CONTROL_FOLIO, ASU_AREA_RECEPCION, A.ARE_NOMBRE " + 
                " FROM SD_ASUNTO, SD_AREA A WHERE ID_ASUNTO=" + idAsunto + 
                " AND A.ID_AREA=ASU_AREA_RECEPCION";
    
            ////System.out.println("Unidad.getUnidades: " +strsql);
            return ConexionDS.ejecutarSQL(strsql);
        }catch(SQLException sqle){
            //System.out.println("Unidad.getUnidades: " + sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }        
    }



    /**
     * Combo de unidades
     * @return String de codigo HTML
     */
    public String getComboUnidades(){
        String cmbUA="<option value='null'>[Seleccionar]</option>";
        String [][] regInstr = getUnidades();
        
        for(int i=0;i<regInstr.length;i++){
            cmbUA += "<option value='" + regInstr[i][0] + "' ";
            if ((regInstr[i][1]).length()>60) {
                cmbUA += "alt='" + regInstr[i][1]+"' >" +  
                    (regInstr[i][1]).substring(0,60) + "... </option>";
            }else{
                cmbUA += ">" + regInstr[i][1] + "</option>";                
            }
        }
        return cmbUA;
    }    
    
    public String getComboUnidades(String idAsunto){

        String [][] regInstr = getUnidades(idAsunto);
        if (regInstr.length>0){        
            if (regInstr[0][0]==null || regInstr[0][0]=="0" || regInstr[0][0]==""){
                return getComboUnidades();
            }else{
                String cmbUA="<option value='null'>[Seleccionar]</option>";
                cmbUA += "<option value='" + regInstr[0][1] + "' ";
                
                if ((regInstr[0][2]).length()>60) {
                    cmbUA += "alt='" + regInstr[0][2]+"' >" +  
                        (regInstr[0][2]).substring(0,60) + "... </option>";
                }else{
                    cmbUA += ">" + regInstr[0][2] + "</option>";                
                }
                return cmbUA;
            }
        }else{
            return getComboUnidades();            
        }
    }    
    
    
}
