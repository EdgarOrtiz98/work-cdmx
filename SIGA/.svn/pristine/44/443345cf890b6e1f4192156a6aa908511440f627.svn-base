package gob.hacienda.cgtic.siga.util;

import com.meve.sigma.db2.ConexionDS;

public class Items {
    public Items() {}

    public static String[][] getColaboradoresAsistente(String idUsuario){
        String sql = esAsistenteDeTitular(idUsuario)?querySubordinadosArea(idUsuario):querySubordinadosAsistente(idUsuario);
        String [][] result = null;
        try{
            //System.out.println("GetColaboradoresAsistente: "+sql);
            result=ConexionDS.ejecutarSQL(sql);
        }catch(Exception e){    
            //System.out.println("Error en datos de combo: "+sql+"\n"+e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
    public static String querySubordinadosArea(String idUsuario){
        return "SELECT DISTINCT ID_USUARIO, USU_CARGO, USU_NOMBRE FROM SD_USUARIO WHERE ASU_ESTATUS = 1 AND ASU_ACTIVO = 1 AND USU_AREA = (SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO = "+idUsuario+")";
    }
    
    public static String querySubordinadosAsistente(String idUsuario){
        return "SELECT DISTINCT ID_USUARIO,USU_CARGO, USU_NOMBRE FROM SD_USUARIO WHERE USU_ESTATUS = 1 AND USU_ACTIVO = 1 START WITH USU_JEFE  IN (SELECT ASI_USUARIO FROM SD_ASISTENTES WHERE ASI_ASISTENTE="+idUsuario+") CONNECT BY PRIOR ID_USUARIO = USU_JEFE ORDER BY USU_CARGO";
    }
    
    
    public static boolean esAsistenteDeTitular(String idUsuario){
        String sql = "SELECT ASI_ASISTENTE FROM SD_ASISTENTES WHERE ASI_USUARIO = (SELECT ARE_SUPERVISOR FROM SD_AREA WHERE ID_AREA = (SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO = "+idUsuario+" ))";
        String[][] idAsistentes = null;
        boolean resultado = false;
        try{
            idAsistentes = ConexionDS.ejecutarSQL(sql);
            for (int indice = 0; indice<idAsistentes.length; indice++)
                if(idAsistentes[indice][0].equals(idUsuario))
                    resultado = true;
            
        }catch(Exception e){
            resultado = false;
            //System.out.println("Error al consultar el asistente del titular");
        }
        return resultado;
    }
    
    public static String idInstruccionUsuario(String idInstruccion){
        String sql  = "SELECT INS_USUARIO FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO = "+idInstruccion;
        String [][] resultado=null;
        try{
            //System.out.println("SQL : "+sql);
            resultado=ConexionDS.ejecutarSQL(sql);
        }catch(Exception e){
            //System.out.println("Error al consultar el titular de la instrucción. "+e.getMessage());
            e.printStackTrace();
        }
     return resultado[0][0];
    }
    
    public static String[][] listarSubordinadosTitular(String idArea){
        String sql = "SELECT DISTINCT ID_USUARIO, USU_CARGO, USU_NOMBRE  " + 
				" FROM SD_USUARIO INNER JOIN SD_USUARIO_ROL ON ID_USUARIO = ID_USUARIO1 WHERE  USU_ESTATUS = 1 " +
				" AND USU_ACTIVO = 1 AND ID_ROL = 1 AND USU_AREA ="+idArea+" ORDER  BY 2";
        String[][] resultado = null;
        try{
            resultado=ConexionDS.ejecutarSQL(sql);
        }catch(Exception e){}
        return resultado;
    }
    

}
