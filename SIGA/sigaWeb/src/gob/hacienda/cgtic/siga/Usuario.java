package gob.hacienda.cgtic.siga;

import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.db2.ConexionDS;

public class Usuario {
    public Usuario() {}
    
    public static boolean equalsTitular(String idUsuario,String idArea){
        String[][] titular=null;
        String sql="SELECT ARE_SUPERVISOR FROM SD_AREA WHERE ID_AREA = "+idArea;
        boolean resultado=false;
        try{
            titular=ConexionDS.ejecutarSQL(sql);
            resultado=titular[0][0].trim().equals(idUsuario)?true:false;
        }catch(Exception e){
            //System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }
    
    public static boolean equalsTitular(String idUsuario){
        String[][] titular=null;
        String sql="SELECT ARE_SUPERVISOR FROM SD_AREA INNER JOIN SD_USUARIO ON ID_AREA = USU_AREA WHERE ID_AREA = (SELECT USU_AREA FROM SD_USUARIO WHERE USU_ACTIVO = 1 AND USU_ESTATUS = 1 AND ID_USUARIO = "+idUsuario+")";
        boolean resultado=false;
        try{
            titular=ConexionDS.ejecutarSQL(sql);
            resultado=titular[0][0].trim().equals(idUsuario)?true:false;
        }catch(Exception e){
            //System.out.println("Error Usuario.equalsTitular: "+sql+"\n"+e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }
    
    public static String getTitular(String idArea){
        String[][] resultado=null;
        try{
            resultado=ConexionDS.ejecutarSQL("SELECT ARE_SUPERVISOR FROM SD_AREA WHERE ID_AREA="+idArea);
        }catch(Exception e){
            //System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return resultado[0][0];
    }
    
    public static String aTitular(String idAsistente){
        String sql = "SELECT ASI_USUARIO FROM SD_ASISTENTES WHERE ASI_ASISTENTE = "+idAsistente+" ORDER BY 1 ASC";
        try{
            return ConexionDS.ejecutarSQL(sql)[0][0];
        }catch(Exception e){
            //System.err.println("Usuario.aTitular(...): "+sql+"\n");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return "";
    }
    
    public static String enNombreTitular(String idAsistente){
        String sql = "SELECT 'en nombre de '||usu_cargo||'/'||usu_nombre from sd_usuario where id_usuario = ("+aTitular(idAsistente)+")";
        try{
            return ConexionDS.ejecutarSQL(sql)[0][0];
        }catch(Exception e){
            return "";
        }
    }
    
/*    
    public static String getIdTitularHistorial(String idAsistente,String idInstruccion){
        String sqlTitular = "SELECT ID_USUARIO,USU_CARGO ||'/'USU_NOMBRE FROM SD_HISTORIAL_INSTRUCCIONES INNER JOIN SD_USUARIO ON HIS_USUARIO = ID_USUARIO WHERE ID_INSTRUCCION_ASUNTO = "+idInstruccion"+ ORDER BY ID_HISTORIAL DESC";
        try{
            return ConexionDS.ejecutarSQL(sql)[0][0];
        }catch(Exception e){
            //System.err.println("Usuario.aTitular(...): "+sql+"\n");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
  */
    
    public static boolean equalsAsistenteTitular(String idUsuario,String idArea){
        String[][] asistenteTitular=null;
        String sql="SELECT ASI_ASISTENTE FROM SD_ASISTENTES, SD_AREA, SD_USUARIO WHERE SD_AREA.ARE_SUPERVISOR=SD_ASISTENTES.ASI_USUARIO AND SD_AREA.ARE_SUPERVISOR = SD_USUARIO.ID_USUARIO AND SD_USUARIO.USU_AREA = "+idArea;
        boolean resultado=false;
        try{
            asistenteTitular=ConexionDS.ejecutarSQL(sql);
            for(int indice=0;indice<asistenteTitular.length;indice++)
                if(asistenteTitular[indice][0].trim().equals(idUsuario))
                    resultado=true;
            if(asistenteTitular.length > 0 ) {
                resultado=asistenteTitular[0][0].trim().equals(idUsuario)?true:false;
            } else {
                resultado = false;
            }
            
        }catch(Exception e){
            //System.out.println("Erro: "+e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }
    
    /**
     * Query que obtiene a todos los usuarios con rol de atencion que asiste el usuari ode atencion
     * @param idUsuario.
     * @return Una cadena con cada uno de los titularec oncatencada por comas.
     */
    public static String getTitulares(String idUsuario){
        String sql="SELECT ASI_USUARIO FROM SD_ASISTENTES WHERE ASI_ASISTENTE="+idUsuario+" ORDER BY 1";
        String idTitulares="";
        String[][] idTitular=null;
        try{
            //System.out.println(sql);
            idTitular=ConexionDS.ejecutarSQL(sql);
            for(int indice=0;indice<idTitular.length-1;indice++)
                idTitulares+=idTitular[indice][0]+",";
            idTitulares+=idTitular[idTitular.length-1][0];
        }catch(Exception e){
            //System.out.println("Erro: "+e.getMessage());
            e.printStackTrace();
        }
        ////System.out.println("Titulares del asistente: "+sql);
        return idTitulares;
    }
    
    public static boolean tieneSubordinados(String idUsuario){
        boolean resultado = false;
        String[][] rs = null;
        String sql = "SELECT ID_ROL FROM SD_USUARIO_ROL WHERE ID_USUARIO1 = "+idUsuario;
        String[][] idRoles = null;

        try{
            idRoles=ConexionDS.ejecutarSQL(sql);
            for(int indice=0;indice<idRoles.length;indice++){
                switch(Integer.parseInt(idRoles[indice][0])){
                    case 1:
                        try{
                            sql = "SELECT COUNT(DISTINCT A.ID_USUARIO) FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE A.ID_USUARIO != "+idUsuario+" AND B.ID_ROL NOT IN (4,5) AND A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.ID_USUARIO = "+idUsuario+" CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE";
                            rs=ConexionDS.ejecutarSQL(sql);
                            if(Integer.parseInt(rs[0][0])>0)
                                resultado = true;
                        }catch(Exception e){
                        }
                    break;
                    
                    case 4:
                        try{
                            sql = "SELECT COUNT(DISTINCT ID_USUARIO) FROM SD_USUARIO INNER JOIN SD_USUARIO_ROL ON ID_USUARIO = ID_USUARIO1 WHERE ID_ROL IN (1,5,6) AND USU_ESTATUS = 1 AMD USU_ACTIVO = 1 AND USU_AREA = (SELECT USU_AREA FROM SD_USUARIO WHERE ID_USAURIO = "+idUsuario+")";
                            rs=ConexionDS.ejecutarSQL(sql);
                            if(Integer.parseInt(rs[0][0])>0)
                                resultado = true;
                        }catch(Exception e){
                        }
                    break;
                    case 5:
                        try{
                            sql = "SELECT COUNT(DISTINCT ID_USUARIO) FROM SD_USUARIO INNER JOIN SD_USUARIO_ROL ON ID_USUARIO = ID_USUARIO1 WHERE ID_ROL IN (1,5,6) AND USU_ESTATUS = 1 AMD USU_ACTIVO = 1 AND USU_AREA = (SELECT USU_AREA FROM SD_USUARIO WHERE ID_USAURIO = "+idUsuario+")";
                            rs=ConexionDS.ejecutarSQL(sql);
                            if(Integer.parseInt(rs[0][0])>0)
                                resultado = true;
                        }catch(Exception e){
                        }
                    break;
                    case 6:
                        try{
                            sql = "SELECT COUNT(DISTINCT A.ID_USUARIO) FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE A.ID_USUARIO != "+idUsuario+"AND B.ID_ROL NOT IN (4,5) AND A.USU_ESTATUS = 1 AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 START WITH A.ID_USUARIO IN ("+getTitulares(idUsuario)+") CONNECT BY PRIOR A.ID_USUARIO = A.USU_JEFE";
                            //System.out.println("Usuario.tieneSubordinados(...): "+sql);
                            rs = ConexionDS.ejecutarSQL(sql);
                            if(Integer.parseInt(rs[0][0])>0)
                                resultado = true;
                        }catch(Exception e){            
                        }
                    break;
                    default:;
                }
            }
        }catch(Exception e){
            //System.err.println("Error en clase Usuario.tieneSubordinados(...): "+sql);
            e.printStackTrace();
        }
        return resultado;
    }
    
    public static boolean esVentanilla(String idUsuario){
        String sql = "SELECT ID_ROL FROM SD_USUARIO INNER JOIN SD_USUARIO_ROL ON ID_USUARIO=ID_USUARIO1 WHERE ID_USUARIO = "+idUsuario;
        String[][] arreglo=null;
        boolean boleano=false;
        try{
            //System.out.println("esVentanilla: "+sql);
            arreglo = ConexionDS.ejecutarSQL(sql);
            for(int indice=0;indice<arreglo.length;indice++){
                if(arreglo[indice][0].trim().equals(("4"))||arreglo[indice][0].trim().equals("5"))
                    boleano=true;
            }
        }catch(Exception e){boleano = false;}
        return boleano;
    }
    
    public static boolean esAsistente(String idUsuario){
        boolean boleano = false;
        String sql = "SELECT ID_ROL FROM SD_USUARIO_ROL WHERE ID_USUARIO1 = "+idUsuario+" AND ID_ROL = 6";        
        try{
            boleano = ConexionDS.ejecutarSQL(sql)[0][0].trim().equals("6")?true:false;
        }catch(Exception e){
            boleano = false;
        }
        return boleano;
    }
    
    /*Metodo incrementado el Día 12 de febrero de 2008*/
    public static boolean asiste(String idAsistente,String idAtencion){
        String sql = "SELECT ASI_ASISTENTE FROM SD_ASISTENTES WHERE ASI_USUARIO = "+idAtencion;
        String[][] atencion=null;
        boolean boleano = false;
        try{
            atencion = ConexionDS.ejecutarSQL(sql);
            for(int indice=0;indice<atencion.length;indice++)
                if(atencion[indice][0].trim().equals(idAsistente)){
                    boleano = true;
                }
        }catch(Exception e){
            System.out.println("Error: "+sql);
            System.out.println(e.getMessage());
            e.printStackTrace();
            boleano = false;
        }
        return boleano;
    }
    
}
