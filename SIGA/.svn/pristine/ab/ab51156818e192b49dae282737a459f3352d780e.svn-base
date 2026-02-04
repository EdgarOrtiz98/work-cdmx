package gob.hacienda.cgtic.siga.actualiza;

import com.meve.sigma.actualiza.ActualizaUsuario;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.util.AsignarArbol;

import java.util.Vector;
/*
 * Actualiza Instruccion
 * @autor Javier Vega Tecalco.
 * SGTIC
 * Secretaría de Hacienda y Crédito Público.
 */


public class RechazoInstruccion{

    /*Modificación 20080213*/
    public static boolean boleanInstruccionRechazadaVentannilla(String idArea){
        String sql = "SELECT COUNT (DISTINCT INS_USUARIO) FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS = 3 AND INS_TURNO IN (SELECT ID_USUARIO  FROM SD_USUARIO INNER JOIN SD_USUARIO_ROL ON ID_USUARIO = ID_USUARIO1 AND ID_ROL IN (3,4,5) AND USU_AREA = "+idArea+")";
        String[][] datos = null;
        boolean resultado = false;
        try{
//            //System.out.println("bolean InstruccionRechazadaVentanilla()... "+sql);
            datos=ConexionDS.ejecutarSQL(sql);
            resultado = Integer.parseInt(datos[0][0])>0?true:false;
        }catch(Exception e){
            resultado = false;
            //System.out.println("Error en la consulta de instrucciones rechazadas por turnador "+sql);
            e.printStackTrace();
        }
        return resultado;
    }
    /*****************************/

    public static boolean getInstruccionesRechazadas(String id_usuario){
        boolean boleano=false;
        String [][]resultado=null;
        try{
            resultado=ConexionDS.ejecutarSQL("SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO IN (SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_AREA=(SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="+id_usuario+")) ORDER BY 12 DESC");
            boleano=(resultado!=null || resultado.length>0)?true:false;
//            //System.out.println("strSql: SELECT * FROM SD_INSTRUCCION_ASUNTO WHERE INS_ESTATUS=3 AND INS_BANDERA1=0 AND INS_TURNO IN (SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_AREA=(SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="+id_usuario+")) ORDER BY 12 DESC");
        }catch(Exception e){
            //System.out.println("Exception al buscar instrucciones rechazadas del area");
            //System.out.println(" Exception: "+e.getMessage());
            e.printStackTrace();
        }
        return boleano;
    }
    
    /*Modificación 20080213*/
    public static String[][] getDatosInstruccionRechazados(String idArea){    
        String[][] resultado=null;
        String sql = "SELECT DISTINCT INS_USUARIO,USU_NOMBRE FROM SD_INSTRUCCION_ASUNTO, SD_USUARIO, SD_ASUNTO WHERE INS_TURNO IN (SELECT ID_USUARIO FROM SD_USUARIO INNER JOIN SD_USUARIO_ROL ON ID_USUARIO = ID_USUARIO1 AND ID_ROL IN (3,4,5) AND USU_AREA = "+idArea+") AND "+
       		"SD_ASUNTO.ID_ASUNTO=SD_INSTRUCCION_ASUNTO.ID_ASUNTO AND "+
       		"SD_USUARIO.ID_USUARIO=SD_INSTRUCCION_ASUNTO.INS_USUARIO "+
       		"AND INS_ESTATUS=3 ORDER BY USU_NOMBRE";
        try{
            resultado = ConexionDS.ejecutarSQL(sql);
//            //System.out.println("getDatosInstruccionRechazados()... "+sql);
        }catch(Exception e){
            //System.out.println("Error al consultar instrucciones rechazadas de area: "+sql+"\n"+e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }
    /**********************************/
    
    
    public static String[][] getJerarquiaRechazo(String idUsuario){
        String [][] resultado=null;
        String sql= "SELECT DISTINCT A.ID_USUARIO, A.USU_CARGO, A.USU_NOMBRE  " + 
                    " FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE  A.USU_ESTATUS = 1 " +
                    " AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 AND B.ID_ROL = 1 " + 
                    " START WITH A.USU_JEFE = " + idUsuario + " CONNECT BY PRIOR A.ID_USUARIO = " +
                    " A.USU_JEFE ORDER BY 2";
        try{
            resultado=ConexionDS.ejecutarSQL(sql);
            //System.out.println(sql);
        }catch(Exception e){
            //System.out.println("Error al consutlar jerarquia del usuario: "+e.getMessage());            
            e.printStackTrace();
            //System.out.println(sql);
        }
        return resultado;
    }
    
    public static boolean myInstruccion(String idAsuntoInstruccion,String idUsuario){
        String [][] resultado;
        boolean boleano=false;
        //Valida que los datos de entrada no esten vacios o nulos
        if( idAsuntoInstruccion == null || 
            idAsuntoInstruccion.equals("") || 
            idAsuntoInstruccion.equalsIgnoreCase("null") ||
            idUsuario == null || 
            idUsuario.equals("") || 
            idUsuario.equalsIgnoreCase("null")
        ) {
            return boleano;
        }
        String sql="SELECT * FROM SD_HISTORIAL_INSTRUCCIONES WHERE ID_INSTRUCCION_ASUNTO="+idAsuntoInstruccion+" AND ID_HISTORIAL=(SELECT MAX(ID_HISTORIAL) FROM SD_HISTORIAL_INSTRUCCIONES WHERE ID_INSTRUCCION_ASUNTO="+idAsuntoInstruccion+" AND HIS_EVENTO=3)";
        try{
            //Consulta dentro de la botácora de instrucciones, quien fue el último en aceptar la instrucción, ya que esa persona retomara el contro de dicha instrucción//
            resultado=ConexionDS.ejecutarSQL(sql);
            //Realizamos una comparación, para ver si al usuario logeado le corresponde dicha instruccion//
            if(resultado.length!=0)
                boleano=idUsuario.equals(resultado[0][5])?true:false;
        }catch(Exception e){
            boleano = false;
            System.err.println("RechazoInstruccion(...): "+sql+"\n"+e.getMessage());
            e.printStackTrace();
        }
        return boleano;
    }
    
    public static String[][] myBoss(String idUsuario){
        String[][] resultado=null;
        try{
            resultado=ConexionDS.ejecutarSQL("SELECT ID_USUARIO,USU_NOMBRE,USU_CARGO FROM SD_USUARIO WHERE USU_AREA=(SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="+idUsuario+") AND ID_USUARIO <> (select ARE_SUPERVISOR from sd_area where id_area=(SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="+idUsuario+")) AND USU_ACTIVO=1 order by 3");
        }catch(Exception e){
            //System.out.println("Error al consultar todos los subordinados del usuario: "+e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }


    public static boolean iAmBoss(String idUsuario){
        boolean result=false;
        String[][] datos=null;
        try{
            datos=ConexionDS.ejecutarSQL("SELECT ID_AREA,ARE_NOMBRE,ARE_SUPERVISOR FROM SD_AREA WHERE ID_AREA=(SELECT USU_AREA FROM SD_USUARIO WHERE ID_USUARIO="+idUsuario+")");
            result=datos[0][2].equals(idUsuario)?true:false;
        }catch(Exception e){
            //System.out.println("Error al comparar al usuario logeado con el jefe del area: "+e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
}