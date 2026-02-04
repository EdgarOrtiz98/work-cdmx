package gob.hacienda.cgtic.siga.instruccion;

import com.meve.sigma.db2.ConexionDS;

public class Actualiza {
    public Actualiza() {}
    
    public static String getTurnador(String idInstruccion,String idUsuarioLogeado){
        String sql = "SELECT INS_ESTATUS,INS_USUARIO,INS_TURNO FROM (SD_INSTRUCCION_ASUNTO INNER JOIN SD_USUARIO ON INS_USUARIO = ID_USUARIO ) INNER JOIN SD_USUARIO_ROL ON ID_USUARIO = ID_USUARIO1  WHERE ID_INSTRUCCION_ASUNTO="+idInstruccion+" ORDER BY ID_ROL";
        String[][] resultado = null;
        String idUsuario="";
        try{
           // //System.out.println("Actualiza.getTurnador(...): "+sql);
            resultado=ConexionDS.ejecutarSQL(sql);
            if(resultado[0][0].trim().equals("3"))
                idUsuario=resultado[0][2];
            else
                idUsuario=resultado[0][1];
        }catch(Exception e){
            //System.out.println("Error al encontrar usuario para turnar...: "+e.getMessage());
            e.printStackTrace();
        }
       // //System.out.println("idUsuario: "+idUsuario);
        return idUsuario;
    }
    
    public static String[][] getIdPersonalArea(String idArea){
        String sql = "SELECT DISTINCT ID_USUARIO, USU_CARGO, USU_NOMBRE  " + 
				" FROM SD_USUARIO INNER JOIN SD_USUARIO_ROL ON ID_USUARIO = ID_USUARIO1 WHERE  USU_ESTATUS = 1 " +
				" AND USU_ACTIVO = 1 AND ID_ROL = 1 AND USU_AREA = "+idArea+
				"  ORDER BY 2";
        String[][] resultado =null;
        try{
            //System.out.println("getIdPersonalArea: "+sql);
            resultado=ConexionDS.ejecutarSQL(sql);
        }catch(Exception e){}
        return resultado;
    }
    
    public static boolean esTurnador(String idUsuario){
        String sql = "SELECT ID_ROL FROM SD_USUARIO_ROL WHERE ID_USUARIO1 = "+idUsuario;
        String[][] resultado = null;
        boolean boleano = false;
        try{
//            //System.out.println("esTurnador(...): "+sql);
            resultado=ConexionDS.ejecutarSQL(sql);            
            for(int indice=0;indice<resultado.length;indice++){
                if(resultado[indice][0].trim().equals("4")||resultado[indice][0].trim().equals("5")){
                    boleano = true;
                }
            }
        }catch(Exception e){
            boleano = false;
            //System.out.println("Error al obtener el rol del usuario: "+e.getMessage());
            e.printStackTrace();
        }
        return boleano;
    }
    
    public static String getEstatus(String idInstruccion){
        String sql = "SELECT INS_ESTATUS FROM SD_INSTRUCCION_ASUNTO WHERE ID_INSTRUCCION_ASUNTO = "+idInstruccion;
        String[][] resultado = null;
        try{
            //System.out.println("Actualiza.getEstatus(...): "+sql);
            resultado=ConexionDS.ejecutarSQL(sql);
        }catch(Exception e){}
        return resultado[0][0];
    }
    
}
