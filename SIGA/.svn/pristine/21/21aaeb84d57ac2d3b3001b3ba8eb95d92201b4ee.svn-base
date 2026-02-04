package gob.hacienda.cgtic.siga.seguimiento;


/**
* Clase que contiene metodos para Lenguaje de Definicion de Datos y  Lenguaje de
* Manipulacion de Datos hacia la base datos de Oracle y usando un Datasoruce para la conexion.
*
* @author  Alberto Ortiz Abasolo
* @version 1.0
*/

import com.meve.sigma.db2.ConexionDS;

import java.sql.*;
import javax.naming.*;


public class AuxDB extends ConexionDS{

    public AuxDB() {
        super();
    }

    /*****************************************************************************
     * Método que realiza la ejecución de un Stored Procedure.
     *
     * @param strSP     Es un String que contiene el Stored Procedure a ejecutar.
     *
     * @return          Regresa un String[] que contiene los Parámetros de salida
     *                  del Stored Procedure.
     *                  En caso de que el Stored Procedure no tenga Parámetros
     *                  de salida , el valor retornado es null.
     *****************************************************************************/
    public static String[] ejecutarSP(String strSP,int idAsunto,String sesion) throws SQLException
    {
        Connection con = null;
        CallableStatement cs = null;
        String strResultado[]=null;

        strResultado = new String[3];

        try{
            con= getConexion();
            cs=con.prepareCall(strSP);

            // Asocia tipos a los Parámetros de salida
            cs.registerOutParameter("p_ERROR",Types.VARCHAR);
            cs.registerOutParameter("p_ELEMENTOS",Types.NUMERIC);

            // Asigna los valores del Stored Procedure
            cs.setInt("p_ID_ASUNTO",idAsunto);
            cs.setString("p_SESION",sesion);
            cs.setString("p_ERROR","0");

            // Ejecuta el SP
            cs.execute();

            // Asigna los resultados del SP a la variable de salida
            strResultado[0] = cs.getString("p_ERROR");
            strResultado[1] = new Integer(cs.getInt("p_ELEMENTOS")).toString();
            con.commit();
//            //System.out.println("Elementos procedure: " +  strResultado[1]);

        }catch(SQLException sqlEx){
            try{
                con.rollback();
            }
            catch(SQLException rollEx){
                throw new SQLException("Error al realizar el rollback: " + rollEx.toString());
            }
            throw new SQLException("Error al ejecutar el SP: " + sqlEx.toString());

        }catch(NamingException namEx){
            throw new SQLException("Error no se puedo ejecutar el SP: " + namEx.toString());
        }catch(Exception Ex){
            try{
                            con.rollback();
            }catch(SQLException rollEx){
                    throw new SQLException("Error al realizar el rollback: " + rollEx.toString());
            }
            throw new SQLException("Error General al ejecutar el SP: " + Ex.toString());
        }finally{
            cerrarConexion(con);
        }
        return strResultado;
    }
}