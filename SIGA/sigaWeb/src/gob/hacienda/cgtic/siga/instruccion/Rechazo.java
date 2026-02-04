package gob.hacienda.cgtic.siga.instruccion;

import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.db2.ConexionDS;

import com.meve.sigma.sql.SQLUsuario;

import gob.hacienda.cgtic.siga.Usuario;

import java.util.StringTokenizer;

public class Rechazo {
    public Rechazo() {}
    
    public static String[][] getInsRechazadas(String[][] idUsuario){
        String sqli = "SELECT DISTINCT ID_USUARIO, USU_CARGO, USU_NOMBRE FROM SD_USUARIO, SD_INSTRUCCION_ASUNTO WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO AND INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO IN (";
        String sqlm = "";
        String sqlf = ") ORDER BY USU_CARGO";
        String sql  = "";
        String[][] resultado=null;
        
        for(int indice=0;indice<idUsuario.length-1;indice++)
            sqlm+=idUsuario[indice][0]+",";
        sqlm+=idUsuario[idUsuario.length-1][0];
        sql=sqli+sqlm+sqlf;
        try{
            resultado=ConexionDS.ejecutarSQL(sql);
            //System.out.println("getInsRechazadas()... "+sql);
        }catch(Exception e){
            //System.out.println();
            e.printStackTrace();
        }
        return resultado;
    }
    
    /*Modificación 20080213*/
    public static String[][] getInsRechazadasOtros(String idUsuario, String idArea){
            String[][] resultado = null;
            //String sql  = Usuario.equalsTitular(idUsuario,idArea)?"SELECT DISTINCT INS_USUARIO, USU_CARGO, USU_NOMBRE FROM SD_USUARIO, SD_INSTRUCCION_ASUNTO WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO AND INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO IN (SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_AREA=(SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="+idUsuario+")) ORDER BY USU_CARGO":"SELECT DISTINCT INS_USUARIO, USU_CARGO, USU_NOMBRE FROM SD_USUARIO, SD_INSTRUCCION_ASUNTO WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO AND INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_USUARIO IN (SELECT DISTINCT A.ID_USUARIO FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE B.ID_ROL<>5 AND A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.USU_JEFE ="+idUsuario+" CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE) ORDER BY USU_CARGO";
            //String sql = Usuario.equalsTitular(idUsuario,idArea)?"SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_INSTRUCCION_ASUNTO INNER JOIN SD_USUARIO ON ID_USUARIO = INS_USUARIO WHERE INS_ESTATUS = 3 AND INS_TURNO IN (SELECT DISTINCT ID_USUARIO FROM SD_USUARIO INNER JOIN SD_USUARIO_ROL ON ID_USUARIO = ID_USUARIO1 WHERE ID_ROL<>5 AND USU_ESTATUS = 1 AND USU_ACTIVO =1 AND USU_AREA = "+idArea+")  ORDER BY 3":"SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_INSTRUCCION_ASUNTO INNER JOIN SD_USUARIO ON ID_USUARIO = INS_USUARIO WHERE INS_ESTATUS = 3 AND INS_TURNO IN (SELECT DISTINCT A.ID_USUARIO FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE B.ID_ROL<>5 AND A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.ID_USUARIO ="+idUsuario+" CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE) ORDER BY 3";
            //1.-String sql = Usuario.equalsTitular(idUsuario,idArea)?"SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_INSTRUCCION_ASUNTO INNER JOIN SD_USUARIO ON ID_USUARIO = INS_USUARIO WHERE INS_ESTATUS = 3 AND INS_TURNO IN (SELECT DISTINCT ID_USUARIO FROM SD_USUARIO INNER JOIN SD_USUARIO_ROL ON ID_USUARIO = ID_USUARIO1 WHERE ID_ROL NOT IN (4,5) AND USU_ESTATUS = 1 AND USU_ACTIVO =1 AND USU_AREA = "+idArea+")  ORDER BY 3":"SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_INSTRUCCION_ASUNTO INNER JOIN SD_USUARIO ON ID_USUARIO = INS_USUARIO WHERE INS_ESTATUS = 3 AND INS_TURNO IN (SELECT DISTINCT A.ID_USUARIO FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE B.ID_ROL NOT IN (4,5) AND A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.ID_USUARIO ="+idUsuario+" CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE) ORDER BY 3";
            //2.-String sql = Usuario.equalsTitular(idUsuario,idArea)?"SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_INSTRUCCION_ASUNTO INNER JOIN SD_USUARIO ON ID_USUARIO = INS_USUARIO WHERE INS_TURNO IN (SELECT DISTINCT ID_USUARIO FROM SD_USUARIO INNER JOIN SD_USUARIO_ROL ON ID_USUARIO = ID_USUARIO1 WHERE ID_ROL NOT IN (4,5) AND USU_ESTATUS = 1 AND USU_ACTIVO =1 AND USU_AREA = "+idArea+")  ORDER BY 3":"SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_INSTRUCCION_ASUNTO INNER JOIN SD_USUARIO ON ID_USUARIO = INS_USUARIO WHERE INS_TURNO IN (SELECT DISTINCT A.ID_USUARIO FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE B.ID_ROL NOT IN (4,5) AND A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.ID_USUARIO ="+idUsuario+" CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE) ORDER BY 3";
            //String sql=Usuario.equalsTitular(idUsuario,idArea)?"SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_USUARIO WHERE ID_USUARIO IN(SELECT ID_USUARIO1 FROM SD_USUARIO_ROL INNER JOIN SD_USUARIO ON ID_USUARIO = ID_USUARIO1 WHERE ID_ROL NOT IN (4,5) AND USU_AREA = (SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="+idUsuario+")) ORDER BY 3":"SELECT DISTINCT A.ID_USUARIO,A.USU_CARGO, A.USU_NOMBRE FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE B.ID_ROL NOT IN (3,4,5) AND A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.USU_JEFE ="+idUsuario+" CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE ORDER BY 2";
            String sql=Usuario.equalsTitular(idUsuario,idArea)?"SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_USUARIO WHERE ID_USUARIO IN(SELECT ID_USUARIO1 FROM SD_USUARIO_ROL INNER JOIN SD_USUARIO ON ID_USUARIO = ID_USUARIO1 WHERE USU_AREA = (SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="+idUsuario+")) ORDER BY 3":"SELECT DISTINCT A.ID_USUARIO,A.USU_CARGO, A.USU_NOMBRE FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.USU_JEFE ="+idUsuario+" CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE ORDER BY 2";
            //System.out.println("Rechazo.getInsRechazadasOtros(...): "+sql);
            //System.out.println("Rechazo.getInsRechazadasOtros: "+sql);
            try{
                resultado=ConexionDS.ejecutarSQL(sql);
//                //System.out.println("getInsRechazadasOtros(...): "+sql);
//                resultado=getInsRechazadas(resultado);
            }catch(Exception e){
                //System.err.println("\tError Rechazo.getInsRechazadasOtros: "+e.getMessage()+"\n");
                e.printStackTrace();
            }
            return resultado;
        }
        /***********************/
        
        public static String[][] getInsRechazadasVentanilla(String idUsuario){
            String[][] resultado=null;
            //String sql="SELECT DISTINCT ID_USUARIO,USU_CARGO,USU_NOMBRE FROM SD_USUARIO,SD_INSTRUCCION_ASUNTO WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO AND INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_USUARIO IN (SELECT DISTINCT ID_USUARIO FROM SD_USUARIO,SD_USUARIO_ROL WHERE ID_USUARIO=ID_USUARIO1 AND ID_ROL=5 AND USU_AREA = (SELECT ID_AREA FROM SD_USUARIO WHERE ID_USUARIO="+idUsuario+")) ORDER BY USU_CARGO";
            String sql="SELECT DISTINCT ID_USUARIO,USU_CARGO,USU_NOMBRE FROM SD_USUARIO,SD_INSTRUCCION_ASUNTO WHERE SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO AND INS_BANDERA1=0 AND INS_USUARIO IN (SELECT DISTINCT ID_USUARIO FROM SD_USUARIO,SD_USUARIO_ROL WHERE ID_USUARIO=ID_USUARIO1 AND ID_ROL IN (4,5) AND USU_AREA = (SELECT ID_AREA FROM SD_USUARIO WHERE ID_USUARIO="+idUsuario+")) ORDER BY USU_CARGO";
            try{
                resultado=ConexionDS.ejecutarSQL(sql);
            }catch(Exception e){
                //System.out.println("Error: "+e.getMessage());
                e.printStackTrace();
            }
            return resultado;
        }
        
        /*Modificación 20080213*/
        public static String[][] getInsRechazadasTitular(String idArea){
            String[][] resultado=null;
            String sql="SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_USUARIO WHERE ID_USUARIO IN(SELECT ID_USUARIO1 FROM SD_USUARIO_ROL INNER JOIN SD_USUARIO ON ID_USUARIO = ID_USUARIO1 WHERE ID_ROL NOT IN (3,4,5) AND USU_AREA = (SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="+idArea+")) ORDER BY 3";
            try{
                //System.out.println("getInsRechazadasTitular().. "+sql);
                resultado=ConexionDS.ejecutarSQL(sql);                
            }catch(Exception e){
                //System.out.println("Error: "+e.getMessage());
                e.printStackTrace();
            }
            return resultado;
        }
        /***************************/
        /*Modificación 20080213*/
        public static String[][] getInsRechazadasAsistente(String idUsuario,String idArea){
            String sql="";
            //String sqli="SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_INSTRUCCION_ASUNTO INNER JOIN SD_USUARIO ON ID_USUARIO = INS_USUARIO WHERE INS_ESTATUS = 3 AND INS_TURNO IN (SELECT DISTINCT A.ID_USUARIO FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE B.ID_ROL<>5 AND A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.ID_USUARIO  IN (";
            //String sqli="SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_INSTRUCCION_ASUNTO INNER JOIN SD_USUARIO ON ID_USUARIO = INS_USUARIO WHERE INS_ESTATUS = 3 AND INS_TURNO IN (SELECT DISTINCT A.ID_USUARIO FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE B.ID_ROL NOT IN (3,4,5) AND A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.ID_USUARIO  IN (";
             String[][] resultado=null;
            try{
            StringTokenizer titulares = new StringTokenizer(Usuario.getTitulares(idUsuario),",");
            //Se obtienen los colaboradores del primer titular
            if(titulares.hasMoreTokens()) {
                sql= "SELECT DISTINCT A.ID_USUARIO, A.USU_CARGO, A.USU_NOMBRE " +
                           "FROM SD_USUARIO A, SD_USUARIO_ROL B " +
                          "WHERE A.USU_ESTATUS = 1 " +
                            "AND A.USU_ACTIVO = 1 " +
                            "AND A.ID_USUARIO = B.ID_USUARIO1 " +
                     "START WITH A.USU_JEFE = " + titulares.nextToken() + " " +
                     "CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE " +
                     "ORDER BY 2 ASC";
                ////System.out.println("getInsRechazadasAsistente(...): "+sql);
                ////System.out.println("Asistente del titular: "+Usuario.equalsAsistenteTitular(idUsuario,idArea));
                if(Usuario.equalsAsistenteTitular(idUsuario,idArea))                    
                    resultado=getInsRechazadasTitular(idArea);
                else
                    resultado=ConexionDS.ejecutarSQL(sql);
            }
            
            //Se realiza un ciclo para los demas colaboradores, y se van añadiendo los del anterior
                while(titulares.hasMoreTokens()) {
                String colaboradores = "";
                for(int i=0;i<resultado.length-1;i++) {
                    colaboradores += resultado[i][0] + ",";
                }
                colaboradores += resultado[resultado.length-1][0];
                sql= "SELECT DISTINCT A.ID_USUARIO, A.USU_CARGO, A.USU_NOMBRE " +
                           "FROM SD_USUARIO A, SD_USUARIO_ROL B " +
                          "WHERE A.USU_ESTATUS = 1 " +
                            "AND A.USU_ACTIVO = 1 " +
                            "AND A.ID_USUARIO = B.ID_USUARIO1 " +
                     "START WITH A.USU_JEFE = " + titulares.nextToken() + " " +
                     "CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE " +
                "UNION " +
                "SELECT DISTINCT A.ID_USUARIO, A.USU_CARGO, A.USU_NOMBRE " +
                      "FROM SD_USUARIO A, SD_USUARIO_ROL B " +
                     "WHERE A.ID_USUARIO in (" + colaboradores + ") " +
                     "ORDER BY 2 ASC"; 
                if(Usuario.equalsAsistenteTitular(idUsuario,idArea))                    
                    resultado=getInsRechazadasTitular(idArea);
                else
                    resultado=ConexionDS.ejecutarSQL(sql);
            }
            
            
            }catch(Exception e){
                //System.err.println("Error: "+e.getMessage());
                e.printStackTrace();
            }
            return resultado;
        }
        /**********************************/
        
        /*Modificación 20080213*/
        public static String[][] getDatosInstruccionUsuario(String idUsuario,String strOrden,String strTipo){
/*            String sql="SELECT DISTINCT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
                "INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, INS_INSTRUCCION_OTRO, INS_TIEMPO, INS_AVANCE, INS_USUARIO, USU_ASISTENTE, USU_JEFE, " +
                "INS_FECHA_ASIGNACION, INS_HABILITADA, INS_PADRE "+
                "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, " +
                "SD_ASUNTO, SD_USUARIO_ROL WHERE INS_USUARIO="+idUsuario+" AND " +
                "SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO AND " +
                "SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
                "AND INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO = ID_USUARIO1 AND ID_ROL<>5" +
                "ORDER BY "+strTipo+" "+strOrden + ", 7 ASC";
*/                
            String sql="SELECT DISTINCT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
       		"INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, INS_INSTRUCCION_OTRO, INS_TIEMPO, INS_AVANCE, INS_USUARIO, USU_ASISTENTE, USU_JEFE, " +
       		"INS_FECHA_ASIGNACION, INS_HABILITADA, INS_PADRE "+
                "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO,SD_ASUNTO, SD_USUARIO_ROL " +
                "WHERE INS_USUARIO="+idUsuario+" AND " +
       		"SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO AND " +
       		"SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
       		"AND INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO = ID_USUARIO1 AND ID_ROL NOT IN (3,4,5)" +
       		"ORDER BY "+strTipo+" "+strOrden + ", 7 ASC";
            String[][] resultado=null;
            //System.out.println("Rechazo.getDatosInstruccionUsuario(...): "+sql);
            try{
                resultado=ConexionDS.ejecutarSQL(sql);                
            }catch(Exception e){
                resultado=null;
                //System.err.println("\tError: "+e.getMessage()+"\n");
                e.printStackTrace();
            }
            return resultado;
        }
        
        /************************************************/
        
    public static String[][] getDatosInstruccionUsuarioVentanilla(String idUsuario,String strOrden,String strTipo){
    /*            String sql="SELECT DISTINCT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
            "INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, INS_INSTRUCCION_OTRO, INS_TIEMPO, INS_AVANCE, INS_USUARIO, USU_ASISTENTE, USU_JEFE, " +
            "INS_FECHA_ASIGNACION, INS_HABILITADA, INS_PADRE "+
            "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, " +
            "SD_ASUNTO, SD_USUARIO_ROL WHERE INS_USUARIO="+idUsuario+" AND " +
            "SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO AND " +
            "SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
            "AND INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO = ID_USUARIO1 AND ID_ROL<>5" +
            "ORDER BY "+strTipo+" "+strOrden + ", 7 ASC";
    */
        String sql="SELECT DISTINCT ID_INSTRUCCION_ASUNTO, INS_INSTRUCCION, TO_CHAR(INS_FECHA_ASIGNACION, 'yyyy-MM-dd'), TO_CHAR(INS_FECHA_TERMINACION, 'yyyy-MM-dd'), " +
            "INS_ESTATUS, ASU_FOLIO_RECEPCION, ASU_DESCRIPCION, INS_INSTRUCCION_OTRO, INS_TIEMPO, INS_AVANCE, INS_USUARIO, USU_ASISTENTE, USU_JEFE, " +
            "INS_FECHA_ASIGNACION, INS_HABILITADA, INS_PADRE "+
            "FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, " +
            "SD_ASUNTO, SD_USUARIO_ROL WHERE INS_USUARIO="+idUsuario+" AND " +
            "SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO AND " +
            "SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO " +
            "AND INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO = ID_USUARIO1 AND ID_ROL not IN (3,4,6)" +
            "ORDER BY "+strTipo+" "+strOrden + ", 7 ASC";
        String[][] resultado=null;
//        //System.out.println("getDatosInstruccionUsuario(...): "+sql);
        try{
            resultado=ConexionDS.ejecutarSQL(sql);                
        }catch(Exception e){
            resultado=null;
            //System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }
 
/*Funcion incrementada el Día  01/02/2008*/
    public static String aNombre(UsuarioBean usuario,String idInstruccion)throws Exception{
        String sqlHistorial = "SELECT HIS_USUARIO FROM SD_HISTORIAL_INSTRUCCIONES WHERE ID_INSTRUCCION_ASUNTO = "+idInstruccion+" ORDER BY ID_HISTORIAL DESC";
        String sqlAsiste    = "SELECT ASI_USUARIO FROM SD_ASISTENTES WHERE ASI_ASISTENTE = "+usuario.getIdUsuario();
        String[][] idUsuarioHistorial = null;
        String[][] idUsuarioAtencion = null;
        try{
            idUsuarioHistorial = ConexionDS.ejecutarSQL(sqlHistorial);
            idUsuarioAtencion = ConexionDS.ejecutarSQL(sqlAsiste);
            for(int ihis=0;ihis<idUsuarioHistorial.length;ihis++){
                for(int ias=0;ias<idUsuarioAtencion.length;ias++)
                    if(idUsuarioAtencion[ias][0].trim().equals(idUsuarioHistorial[ihis][0].trim()))
                        return ConexionDS.ejecutarSQL("SELECT USU_CARGO||' / '||USU_NOMBRE FROM SD_USUARIO WHERE ID_USUARIO ="+idUsuarioAtencion[ias][0])[0][0];
            }            
        }catch(Exception e){            
        }
        return ConexionDS.ejecutarSQL("SELECT USU_CARGO||' / '||USU_NOMBRE FROM SD_ASISTENTES INNER JOIN SD_USUARIO ON ID_USUARIO = ASI_USUARIO WHERE ASI_ASISTENTE = "+usuario.getIdUsuario())[0][0];
    }
}
