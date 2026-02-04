/*
 **************************************************************
 * Copyright (C) 2007 SHCP 
 * CGTIyC - alejandro_gavia@hacienda.gob.mx
 * 
 * $$Archivo: 	Instruccion.java
 * $$Revisión: 	DARG - Creación del objeto instrucción.
 * $$Fecha: 	10 de Enero de 2007
 * 
 * Este software es información propietaria y confidencial de la SHCP - CGTIyC. 
 ***************************************************************
 */
package gob.hacienda.cgtic.siga;

import com.meve.sigma.db2.*;
import gob.hacienda.cgtic.siga.beans.tablaInstruccionesBean;

import java.sql.SQLException;


/**
 * Objeto instrucción. representa una instrucción dentro del sistema SIGA, el 
 * cual se puede utilizar para extraer información al respecto de las 
 * insrtrucciones relacionadas en el seguimiento de un asunto y relacionadas a 
 * un documento.
 *
 * @version 1.0.0 10 Ene 2007
 * @author Daniel Rangel
 */
public class Instruccion {
    
    public Instruccion() {
    
    }

    /**
     * @param idArea Identificador de Area para filtrar las instrucciones.
     * @return Un arreglo bidimiencional con los registros extraidos de las 
     * instrucciones solicitadas por área.
     */
    public String[][] getInstruccionesPorArea(String idArea){
        try
        {
            String strsql = "SELECT ID_INSTRUCCION, INS_NOMBRE FROM " +
                "SD_INSTRUCCION WHERE INS_AREA="+idArea+" AND INS_ESTATUS1=1 ORDER BY INS_NOMBRE ";
            //System.out.println("Instruccion.getInstruccionesPorArea: " +strsql);
            return ConexionDS.ejecutarSQL(strsql);
        }catch(SQLException sqle){
            ////System.out.println("Instruccion.getInstruccionesPorArea: " + 
            //    sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }        
    }

    public String[][] getInstruccionesPorArea(String idArea, boolean generales){
        try
        {
            String strsql = "SELECT ID_INSTRUCCION, INS_NOMBRE FROM " +
                "SD_INSTRUCCION WHERE INS_AREA="+idArea+" AND INS_ESTATUS1=1 ";
            if (generales){
                strsql += " UNION ALL SELECT ID_INSTRUCCION, INS_NOMBRE FROM " + 
                    "SD_INSTRUCCION WHERE INS_AREA=0 AND INS_ESTATUS1=1 ";
            }else{
                strsql += " ORDER BY INS_NOMBRE ";
            }
            ////System.out.println("Instruccion.getInstruccionesPorArea: " +strsql);
            return ConexionDS.ejecutarSQL(strsql);
        }catch(SQLException sqle){
            ////System.out.println("Instruccion.getInstruccionesPorArea: " + 
            //    sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }        
    }

    /**
     * @param idArea Identificador de Area para filtrar las instrucciones.
     * @return Una cadena de texto HTML con las opciones de Instruccion que 
     * tenemos en base al área solicitada.
     */
    public String getComboInstrucciones(String idArea){
        String cmbInstr="<option value='null'>[Seleccionar]</option>";
        cmbInstr += "<optgroup label='Del área'>";
        String [][] regInstr = getInstruccionesPorArea(idArea);
        for(int i=0;i<regInstr.length;i++){
            cmbInstr += "<option value='" + regInstr[i][0] + "' ";
            if ((regInstr[i][1]).length()>60) {
                cmbInstr += "alt='" + regInstr[i][1]+"' >" +  
                    (regInstr[i][1]).substring(0,60) + "... </option>";
            }else{
                cmbInstr += ">" + regInstr[i][1] + "</option>";                
            }
        }
        cmbInstr += "</optgroup><optgroup label='Generales'>";
        String [][] regInstrG = getInstruccionesPorArea("0");
        for(int i=0;i<regInstrG.length;i++){
            cmbInstr += "<option value='" + regInstrG[i][0] + "' ";
            if ((regInstrG[i][1]).length()>60) {
                cmbInstr += "alt='" + regInstrG[i][1]+"' >" +  
                    (regInstrG[i][1]).substring(0,60) + "... </option>";
            }else{
                cmbInstr += ">" + regInstrG[i][1] + "</option>";                
            }
        }
        cmbInstr+="</optgroup><option value='[otra]'>[ Otra ]...</option>";
        return cmbInstr;
    }

    /**
     * Regresa Instrucciones por asunto 
     * @param idAsunto ID Asunto 
     * @return String[][] de datos 
     */
    public String[][] getInstruccionesPorAsunto(String idAsunto){
        try
        {
            String strsql = "SELECT ID_INSTRUCCION, INS_NOMBRE FROM " +
                "SD_INSTRUCCION WHERE ID_ASUNTO="+idAsunto+" ORDER BY INS_NOMBRE";
            //System.out.println("Instruccion.getInstruccionesPorAsunto: " +strsql);
            return ConexionDS.ejecutarSQL(strsql);
        }catch(SQLException sqle){
            //System.out.println("Instruccion.getInstruccionesPorAsunto: " + sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }        
    }

    /**
     * Regresa las instrucciones Relacionadas 
     * @param idAsunto ID Asunto 
     * @param idInstr ID Instruccion 
     * @return String[][] de datos 
     */
    public String[][] getInstruccionesRelacionadas(String idAsunto, 
                String idInstr){
        try
        {
            
            String strSql = "SELECT " + 
            "    INS.ID_INSTRUCCION_ASUNTO, " + 
            "    INS.INS_USUARIO, " + 
            "    USU.USU_CARGO||' / '||USU.USU_NOMBRE, " + 
            "    INS.INS_INSTRUCCION, " + 
            "    INS.INS_TIPO_ATENCION, " + 
            "    INS.INS_TIEMPO, " + 
            "    INS.INS_ACCESO, " + 
            "    INS.INS_REQUERIDO, " + 
            "    INS.INS_CONFIDENCIAL, " + 
            "    INS.INS_INSTRUCCION_OTRO, " + 
            "    INS.INS_ESTATUS, " +
            "    INS.INS_AUTO " +
            "FROM " + 
            "    SD_INSTRUCCION_ASUNTO INS, " + 
            "    SD_USUARIO USU " + 
            "WHERE ID_ASUNTO=" + idAsunto + " " +
            "AND INS.INS_USUARIO = USU.ID_USUARIO ";
            
            if(!idInstr.equals("")){
                strSql += "AND INS_PADRE = " + idInstr;
            }else{
                strSql += "AND INS_PADRE IS NULL";                
            }
            strSql += " ORDER BY 1 ";

            ////System.out.println("Instruccion.getInstruccionesRelacionadas: "
            //    +strSql);
            return ConexionDS.ejecutarSQL(strSql);
        }catch(SQLException sqle){
            ////System.out.println("Instruccion.getInstruccionesRelacionadas: " + 
            //    sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }        
    }

    public tablaInstruccionesBean getTablaInstruccionesBean(String idAsunto, 
                String idInstr){
        return new tablaInstruccionesBean(idAsunto,idInstr);
    }

    /**
     * Regresa el nombre de un instrucción 
     * @param idInstr ID de la instrucción 
     * @return Nombre de la instrucción
     */
    public String getInstructionById(int idInstr){
        try
        {
            String strSql = "SELECT INS_NOMBRE from SD_INSTRUCCION " + 
            "WHERE ID_INSTRUCCION=" + idInstr;// + " AND INS_ESTATUS1=1";
            
            ////System.out.println("Instruccion.getInstructionById: "+strSql);
            String rsTmp[][] = ConexionDS.ejecutarSQL(strSql);
            
            return rsTmp[0][0];
        }catch(SQLException sqle){
            ////System.out.println("Instruccion.getInstructionById: " + 
            //    sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }        
    }
    
    public int getTiempoEstimado(String idAsunto){
        try
        {
            int resultInt; 
            String strSql = "SELECT DIAS_HABILES(SYSDATE, (SELECT ASU_FECHA_CADUCIDAD " +
                "FROM SD_ASUNTO WHERE ID_ASUNTO=" + idAsunto + ") )FROM SYS.DUAL";
            String rsTmp[][] = ConexionDS.ejecutarSQL(strSql);
            resultInt = Integer.parseInt(rsTmp[0][0].trim());
            
            if (resultInt<0)
                resultInt = 0;
            
            return resultInt;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return 0;
        }        
        
    }

    public int getTiempoEstimado(String idAsunto, String idInstr){
        try
        {
            int resultInt=0; 
            String strSql = "SELECT DIAS_HABILES(SYSDATE, (SELECT INS_FECHA_TERMINACION " + 
            " FROM SD_INSTRUCCION_ASUNTO WHERE ID_ASUNTO=" + idAsunto + 
            " AND ID_INSTRUCCION_ASUNTO = " + idInstr + ")) DIAS_HABILES FROM SYS.DUAL";
            String rsTmp[][] = ConexionDS.ejecutarSQL(strSql);
            if (rsTmp.length>0){
                resultInt = Integer.parseInt(rsTmp[0][0]);
                if (resultInt < 0)
                    resultInt = 0;
                return resultInt;
            }else{
                return getTiempoEstimado(idAsunto);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return 0;
        }        
    }
    
    public void updateIntrsExtra(String idAsunto){
        if (idAsunto=="") return;
        try{
            String strSql = "UPDATE SD_INSTRUCCION_ASUNTO SET INS_INSTRUCCION_OTRO = ' ' " +
                "WHERE ID_ASUNTO=" + idAsunto + " AND INS_PADRE IS NOT NULL " +
                "AND INS_FOLIO_TURNADO IS NULL AND INS_INSTRUCCION IS NULL " +
                "AND INS_INSTRUCCION_OTRO IS NULL AND INS_ESTATUS=0";
            ////System.out.println("Instruccion.updateIntrsExtra: "+strSql);
            ConexionDS.ejecutarActualizacion(strSql);
        }catch(SQLException sqle){
            ////System.out.println("Instruccion.updateIntrsExtra: " + 
            //    sqle.getMessage());
            sqle.printStackTrace();
        }        
    }

    /**
     * Acceso a las Instrucciones
     * @param idAsunto ID del asunto 
     * @param idInstr ID de instrucción
     * @return Regresa "1" si la instruccion tiene acceso al asunto o "0" en caso contrario 
     */
    public String getTipoAcceso(String idAsunto, String idInstr){
        if (idAsunto==""||idInstr=="") return "0";
        try{
            String res_str="";
            String strSql = "SELECT INS_ACCESO FROM SD_INSTRUCCION_ASUNTO " + 
            " WHERE ID_ASUNTO="+ idAsunto + "AND ID_INSTRUCCION_ASUNTO=" + idInstr;
            String rsTmp[][] = ConexionDS.ejecutarSQL(strSql);
            res_str = rsTmp[0][0].trim();
           
            return res_str;
        }catch(SQLException sqle){
            //System.out.println("tablaInstruccionesBean.updateIntrsExtra: " + sqle.getMessage());
            sqle.printStackTrace();
        }        
        return "0";

    }
    
    /**
     * Verifica si la instrucciones es uinformativa o no
     * @param strIdInstruccion
     * @return Query
     */
    public boolean getEsInformativa(String strIdInstruccion){
    	String[][] str = null;
        try
        {
            String strsql = "SELECT INS_TIPO_ATENCION FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO="+strIdInstruccion;
            ////System.out.println("getEsInformativa: " +strsql);
            str = ConexionDS.ejecutarSQL(strsql);
            if(str.length!=0){
            	return str[0][0].equals("1");
            }
            return false;
        }catch(SQLException sqle){
            ////System.out.println("Instruccion.getInstruccionesPorArea: " + 
            //    sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }        
    }
}
