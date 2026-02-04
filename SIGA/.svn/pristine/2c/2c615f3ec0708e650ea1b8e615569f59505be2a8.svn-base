 /*
  **************************************************************
  * Copyright (C) 2007 SHCP
  * CGTIyC - alejandro_gavia@hacienda.gob.mx
  *
  * $$Archivo:   Asunto.java
  * $$Revisión:  DARG - Creación del objeto Asunto.
  * $$Fecha:     01 de Abril de 2007
  *
  * Este software es información propietaria y confidencial de la SHCP - CGTIyC.
  ***************************************************************
  */

package gob.hacienda.cgtic.siga;

import com.meve.sigma.db2.ConexionDS;
import java.sql.SQLException;

public class Asunto {

    private int idAsunto;
    private String folio;
    private String tipoRegistro;

    /**
    * Constructor básico de la clase Asunto, crea una instancia de la clase sin valores
    */
    public Asunto() {
        setIdAsunto(0);
        setFolio("");
        setTipoRegistro("");
    }

    /**
    * Constructor que recive como parámetro el Identificador del asunto
    *
    * @param idAsunto Identificador del Asunto
    */
    public Asunto(int idAsunto) {
        setIdAsunto(idAsunto);
        setFolio("");
    }

    /**
    * Constructor que recive como parámetro el folio asociado al asunto
    *
    * @param folio Folio asociado al asunto
    */
    public Asunto(String folio) {
        setFolio(folio);
        setIdAsunto(0);
    }

    /**
    * Asigna el valor pasado como parámetro a la variable idAsunto
    *
    * @param idAsunto Identificador del asunto
    */
    public void setIdAsunto(int idAsunto) {
        this.idAsunto = idAsunto;
    }

    /**
    * Regresa el valor de la variable idAsunto.
    *
    * @return int (idAsunto) Identificador del asunto
    */
    public int getIdAsunto() {
        return idAsunto;
    }

    /**
    * Asigna el valor pasado como parámetro a la variable folio
    *
    * @param folio Folio asociado al asunto
    */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
    * Regresa el valor de la variable folio.
    *
    * @return String (folio) Folio asociado al asunto
    */
    public String getFolio() {
        return folio;
    }
    
    public void setTipoRegistro(String tipo){
        this.tipoRegistro = tipo;
    }
    
    public String getTipoRegistro(){
        return this.tipoRegistro;
    }
    
    public String[][] getDatos(){
        String[][] tmpReg;
        try
        {
            String strsql = ""; 
        /*
         0 - ID_ASUNTO_REF           
         1 - ASU_REF_AREA_RECEPCION  
         2 - ASU_REF_ENTIDAD         
         3 - ASU_REF_REMITENTE       
         4 - ASU_REF_REMITENTE_NOMBRE
         5 - ASU_REF_REMITENTE_CORREO
         6 - ASU_REF_CONTROL         
         7 - ASU_TURNADOR_PUESTO     
         8 - ASU_TURNADOR_NOMBRE     
         9 - ASU_REF_TURNADOR_AREA   
         10 - ASU_REF_TIPO_DOCTO      
         11 - ASU_REF_EXPEDIENTE      
         12 - ASU_REF_TRAMITE         
         13 - ASU_REF_TIPO_ASUNTO     
         14 - ASU_REF_PRIORIDAD       
         15 - ASU_REF_USR_CAPTURA     
        */
        /*
         //System.out.println("GetFolio: "+this.getFolio());
         //System.out.println("GetIdAsunto: "+this.getIdAsunto());
         //System.out.println("GetFolio: "+this.getFolio());*/
         strsql = "SELECT * FROM SD_ASUNTO_DESCRIPCION A, SD_ASUNTO B"; 
         if (!getFolio().equals("") || getIdAsunto()!=0){
             if (!getFolio().equals("")){
                 strsql += " WHERE A.ID_ASUNTO_REF = (SELECT ID_ASUNTO FROM SD_ASUNTO WHERE ";
                 strsql += " ASU_FOLIO_RECEPCION = '" + getFolio()+ "') " ;
             } else if (getIdAsunto()!=0){
                 strsql += " WHERE A.ID_ASUNTO_REF = " + getIdAsunto()+ " " ;
             }
             strsql += " AND B.ID_ASUNTO=A.ID_ASUNTO_REF ORDER BY ID_ASUNTO_REF ";
             
             //System.out.println("Asunto.getDatos: " +strsql);
             tmpReg = ConexionDS.ejecutarSQL(strsql);
             if (tmpReg==null || tmpReg.length == 0 ){
                 setTipoRegistro("null");
             }else{
                 setTipoRegistro("fijo");
                 return tmpReg;
             }
         }else{
             setTipoRegistro("null");
         }
        /*
         0 - A.ID_ASUNTO
         1 - A.ASU_FOLIO_RECEPCION
         2 - A.ASU_ENTIDAD 
         3 - B.ENT_NOMBRE 
         4 - A.ASU_REMITENTE 
         5 - C.RMT_NOMBRE 
         6 - A.ASU_FIRMANTE 
         7 - A.ASU_TIP_DOCTO
         8 - D.TIP_DOCTO_NOMBRE 
         9 - A.ASU_LISTAIDS_PARA 
         10 - A.ASU_LISTAIDS_CC 
         11 - A.ASU_DESCRIPCION 
         12 - A.ASU_TRAMITE 
         13 - A.ASU_FECHA_CAPTURA 
         14 - A.ASU_FECHA_RECEPCION 
         15 - A.ASU_FECHA_DOCTO 
         16 - A.ASU_FECHA_CADUCIDAD 
         17 - A.ASU_AVANCE 
         18 - A.ASU_ESTATUS 
         19 - A.ASU_FOLIO_EXTERNO 
         20 - A.ASU_FOLIO_INTERMEDIO 
         21 - A.ASU_FECHA_EVENTO 
         22 - A.ASU_HORA_EVENTO
         23 - A.ASU_LUGAR_EVENTO 
         24 - A.ASU_PRIORIDAD 
         25 - E.PRI_NOMBRE
         26 - A.ASU_TIPO_ASUNTO  
         27 - F.TIP_ASU_NOMBRE
         */
         if (getTipoRegistro().equalsIgnoreCase("null")||getTipoRegistro().equals("")){
            strsql = "SELECT A.ID_ASUNTO, A.ASU_FOLIO_RECEPCION, A.ASU_ENTIDAD, B.ENT_NOMBRE, " + 
            "A.ASU_REMITENTE, C.RMT_NOMBRE, A.ASU_FIRMANTE, A.ASU_TIP_DOCTO, " +
            "D.TIP_DOCTO_NOMBRE, A.ASU_LISTAIDS_PARA, A.ASU_LISTAIDS_CC, A.ASU_DESCRIPCION,  " +
            "A.ASU_TRAMITE, A.ASU_FECHA_CAPTURA, A.ASU_FECHA_RECEPCION, A.ASU_FECHA_DOCTO,  " +
            "A.ASU_FECHA_CADUCIDAD, A.ASU_AVANCE, A.ASU_ESTATUS, A.ASU_FOLIO_EXTERNO,  " +
            "A.ASU_FOLIO_INTERMEDIO, A.ASU_FECHA_EVENTO, A.ASU_HORA_EVENTO, " +
            "A.ASU_LUGAR_EVENTO, G.PRI_NOMBRE, A.ASU_TIPO_ASUNTO FROM SD_ASUNTO A, " +
            "SD_ENTIDAD B, SD_REMITENTE C, SD_TIPO_DOCUMENTO D, SD_PRIORIDAD E, SD_TIPO_ASUNTO F, SD_PRIORIDAD G ";

            if (!getFolio().equals("") || getIdAsunto()!=0){
                if (!getFolio().equals("")){
                    strsql += " WHERE A.ASU_FOLIO_RECEPCION = '"+getFolio()+"' ";
                } else if (getIdAsunto()!=0){
                    strsql += " WHERE ID_ASUNTO = "+getIdAsunto();
                }
                strsql += " AND B.ID_ENTIDAD(+) = A.ASU_ENTIDAD " +
                "AND C.ID_REMITENTE(+) = A.ASU_REMITENTE " +
                "AND D.ID_TIPO_DOCTO(+) = A.ASU_TIP_DOCTO " +
                "AND E.ID_PRIORIDADES(+) = A.ASU_PRIORIDAD " +
                "AND F.ID_TIPO_ASUNTO(+) = A.ASU_TIPO_ASUNTO " +
                "AND G.ID_PRIORIDADES(+) = A.ASU_PRIORIDAD ";

                //System.out.println("Asunto.java193\nStrSql: "+strsql);
                tmpReg = ConexionDS.ejecutarSQL(strsql);
                if (tmpReg==null){
                    setTipoRegistro("null");
                    return null;
                }else{
                    setTipoRegistro("variable");
                    return tmpReg;
                }
            }else{
                setTipoRegistro("null");
                return null;
            }
         }
        }catch(SQLException sqle){
            //System.out.println("Asunto.getDatos: " + sqle.getMessage());
            sqle.printStackTrace();
            setTipoRegistro("null");
            return null;
        }        
        setTipoRegistro("null");
        return null;
    }


}
