 /*
  **************************************************************
  * Copyright (C) 2007 SHCP
  * CGTIyC - alberto_ortiz@hacienda.gob.mx
  *
  * $$Archivo:   Ruta.java
  * $$Revisión:  AOA - Creación del objeto Puesto.
  * $$Fecha:     30 de Enero de 2007
  *
  * Este software es información propietaria y confidencial de la SHCP - CGTIyC.
  ***************************************************************
  */

package gob.hacienda.cgtic.siga.seguimiento;

//import com.meve.sigma.db2.ConexionDS;
import java.sql.SQLException;
import java.lang.NumberFormatException;

public class Ruta {

    private int idAsunto;
    private String descAsunto;
    private String folio;
    private String unidadAdministrativa;
    private String remitente;
    private String firmante;
    private String comentarios;
    private String error;
    private String salida[][];
    private String AsuntosViejos[][];
    private String nodos[][];
    private String sesion = "";
    public String relacionIDFolio = "";
    
    private int numReg= 0;                  // Número de registros
    private int numNodos = 0;               // Número de nodos
    private int numAsuntosViejos;            // Número de asuntos Viejos



    /**
    * Constructor básico de la clase Ruta, crea una instancia de la clase sin valores
    */
    public Ruta() {
        setIdAsunto(-1);
    }

    /**
    * Constructor que recive como parámetro el Identificador del asunto
    *
    * @param idAsunto Identificador del Asunto
    */
    public Ruta(int idAsunto) {
        setIdAsunto(idAsunto);
    }

    /**
    * Constructor que recive como parámetro el folio asociado al asunto
    *
    * @param folio Folio asociado al asunto
    */
    public Ruta(String folio) {
        setFolio(folio);
        setIdAsunto(-1);
    }

    /**
    * Ejecuta el Stored Procedure SP_RUTA_ASUNTOS_RELACIONADOS, él cual obtiene todos
    * los asuntos relacionados con un asunto origen y los deja en una tabla temporal
    *
    * @return boolean Regresa verdadero en caso de que el Stored Procedure se haya ejecutado
    * de forma adecuada y falso en caso de que por alguna Razón no se haya podido ejecutar
    * el Stored Procedure.
    */
    public boolean ObtenerAsuntosRelacionados(){
    String strResultadoSP[] = null;  // Obtiene la salida del SP
    String SP = null;

        SP = "{ call SP_RUTA_ASUNTOS_RELACIONADOS(?, ?, ?, ?) }";
        try {
            strResultadoSP = AuxDB.ejecutarSP(SP,getIdAsunto(),getSesion());

        } catch (SQLException sqle) {
             //System.out.println("Error en Ruta.consultaRutaAsuntos.SP_RUTA_ASUNTOS_RELACIONADOS : " + sqle.getMessage());
             sqle.printStackTrace();
             setError("Error al intentar ejecutar la consulta:  " + sqle.getMessage());
             return false;
        }

        if (!strResultadoSP[0].equalsIgnoreCase("0"))
        {
            setError("Error al intentar ejecutar la consulta:  " + strResultadoSP[0]);
            return false;
        }
        setNumReg(Integer.parseInt(strResultadoSP[1]));
        return true;
    }

    /**
    * Consulta en la Base los asuntos relacionados a un asunto, antes de invocar este metodo
    * necesario invocar el Método ObtenerAsuntosRelacionados
    *
    * Los campos que se obtienen son:
    *
    * - nodos Arreglo de asuntos
    *
    * @return boolean Regresa verdadero en caso de que la consulta se haya podido realizar
    * sin problemas y la información haya sido arrojada a las variables correspondientes y
    * falso en caso de que por alguna Razón no se haya podido realizar la consulta.
    */
    public boolean consultaAsuntos(){
        String sqlAsuntos = null;        // Contiene el postulado SQL para la consulta a la BD
        String strResultado[][] = null; // Obtiene el resultado de la consulta

        // Se construye el postulado SQL
        sqlAsuntos = "SELECT DISTINCT B.ASU_FOLIO_RECEPCION " +
        "FROM SD_ASUNTOS_REL_SP A, SD_ASUNTO B " +
        "WHERE SESION = '" + getSesion() + "' " +
        " AND ID_ASUNTO_ORIGEN = " + getIdAsunto() +
        " AND A.ID_ASUNTO_REL = B.ID_ASUNTO ";

        //System.out.println("Ruta.consultaAsuntos: " + sqlAsuntos);
        try{
            // Ejecuta el postulado SQL
            strResultado = AuxDB.ejecutarSQL(sqlAsuntos);
        }catch(SQLException sqle){
            //System.out.println("Error en Ruta.consultaAsuntos: " + sqle.getMessage());
            sqle.printStackTrace();
            setError("Error al intentar realizar la consulta:  " + sqle.getMessage());
            return false;
        }

        // Asigna la salida de la consulta a las variables de la clase.
        setNodos(strResultado);
        setNumNodos(strResultado.length);
        return true;
    }

    /**
    * Consulta en la Base los asuntos relacionados a un asunto que sean los más viejos,
    * antes de invocar este metodo necesario invocar el Método ObtenerAsuntosRelacionados
    *
    * Los campos que se obtienen son:
    *
    * - nodos Arreglo de asuntos más viejos
    *
    * @return boolean Regresa verdadero en caso de que la consulta se haya podido realizar
    * sin problemas y la información haya sido arrojada a las variables correspondientes y
    * falso en caso de que por alguna Razón no se haya podido realizar la consulta.
    */
    public boolean consultaAsuntosViejos(){
        String sqlAsuntos = null;        // Contiene el postulado SQL para la consulta a la BD
        String strResultado[][] = null; // Obtiene el resultado de la consulta

        // Se construye el postulado SQL
        sqlAsuntos = "SELECT DISTINCT B.ASU_FOLIO_RECEPCION " +
        "FROM SD_ASUNTOS_REL_SP A, SD_ASUNTO B " +
        "WHERE SESION = '" + getSesion() + "' " +
        " AND ID_ASUNTO_ORIGEN = " + getIdAsunto() +
        " AND A.ID_ASUNTO_REL = B.ID_ASUNTO " +
        " AND B.ASU_FECHA_RECEPCION = ( " +
        "    SELECT MAX(D.ASU_FECHA_RECEPCION) " +
        "    FROM SD_ASUNTOS_REL_SP C, SD_ASUNTO D " +
        "    WHERE ID_ASUNTO_ORIGEN = " + getIdAsunto() +
        "    AND SESION = '" + getSesion() + "' " +
        "    AND C.ID_ASUNTO = D.ID_ASUNTO)";


        //System.out.println("Ruta.consultaAsuntosViejos: " + sqlAsuntos);
        try{
            // Ejecuta el postulado SQL
            strResultado = AuxDB.ejecutarSQL(sqlAsuntos);
        }catch(SQLException sqle){
            //System.out.println("Error en Ruta.consultaAsuntosViejos: " + sqle.getMessage());
            sqle.printStackTrace();
            setError("Error al intentar realizar la consulta:  " + sqle.getMessage());
            return false;
        }

        // Asigna la salida de la consulta a las variables de la clase.
        setAsuntosViejos(strResultado);
        setNumAsuntosViejos(strResultado.length);
        return true;
    }


    /**
    * Consulta en la Base las relaciones de los nodos relacionados a un asunto, antes
    * de invocar este metodo necesario invocar el Método ObtenerAsuntosRelacionados
    *
    * Los campos que se obtienen son:
    *
    * - relaciones Arreglo de asuntos
    *
    * @return boolean Regresa verdadero en caso de que la consulta se haya podido realizar
    * sin problemas y la información haya sido arrojada a las variables correspondientes y
    * falso en caso de que por alguna Razón no se haya podido realizar la consulta.
    */
    public boolean consultaRelaciones(){
        String sqlRelaciones = null;        // Contiene el postulado SQL para la consulta a la BD
        String strResultado[][] = null; // Obtiene el resultado de la consulta

        // Se construye el postulado SQL
        sqlRelaciones = "SELECT DISTINCT B.ASU_FOLIO_RECEPCION, C.ASU_FOLIO_RECEPCION, A.TIPO_REF, A.PADRE_HIJO " +
        "FROM SD_ASUNTOS_REL_SP A, SD_ASUNTO B, SD_ASUNTO C " +
        "WHERE SESION = '" + getSesion() + "' " +
        " AND ID_ASUNTO_ORIGEN = " + getIdAsunto() +
        " AND A.NIVEL > 0 " +
        " AND A.ID_ASUNTO = B.ID_ASUNTO " +
        " AND A.ID_ASUNTO_REL = C.ID_ASUNTO ";

//        //System.out.println("Ruta.consultaRelaciones: " + sqlRelaciones);
        try{
            // Ejecuta el postulado SQL
            strResultado = AuxDB.ejecutarSQL(sqlRelaciones);

        }catch(SQLException sqle){
            //System.out.println("Error en Ruta.consultaRelaciones: " + sqle.getMessage());
            sqle.printStackTrace();
            setError("Error al intentar realizar la consulta:  " + sqle.getMessage());
            return false;
        }

        // Asigna la salida de la consulta a las variables de la clase.
        setSalida(strResultado);
        setNumReg(strResultado.length);
        return true;
    }


     /**
     * Borra la información relacionada a la generación de una ruta de los asuntos
     * relacionados a un asunto origen
     *
     *
     * @return boolean Regresa verdadero en caso de que la consulta se haya podido realizar
     * sin problemas y la información haya sido arrojada a las variables correspondientes y
     * falso en caso de que por alguna Razón no se haya podido realizar la consulta.
     */
     public boolean borraAsuntosAsociados(){
         String sqlBorraAsuntos = null;     // Contiene el postulado SQL para borrar información de la BD
         int registros = 0;                 // Obtiene el resultado del borrado

         // Se construye el postulado SQL
         sqlBorraAsuntos = "DELETE FROM SD_ASUNTOS_REL_SP " +
         "WHERE SESION = '" + getSesion() + "' " +
         " AND ID_ASUNTO_ORIGEN = " + getIdAsunto();

         //System.out.println("Ruta.borraAsuntosAsociados: " + sqlBorraAsuntos);
         try{
             // Ejecuta el postulado SQL
             registros = AuxDB.ejecutarActualizacion(sqlBorraAsuntos);
         }catch(SQLException sqle){
             //System.out.println("Error en Ruta.borraAsuntosAsociados: " + sqle.getMessage());
             sqle.printStackTrace();
             setError("Error al intentar realizar la consulta:  " + sqle.getMessage());
             return false;
         }
         return true;
     }

    /**
    * Consulta en al Base de datos la información relacionada a la ruta de un folio
    * o de un identificador de asunto, obtiene los valores y los deja en las
    * variables correspondientes validando que sus valores no sean nulos.
    *
    * Los campos que se obtienen son:
    *
    * - RUTA
    * - DESCRIPCION
    * - ESTATUS
    *
    * @return boolean Regresa verdadero en caso de que la consulta se haya podido realizar
    * sin problemas y la información haya sido arrojada a las variables correspondientes y
    * falso en caso de que por alguna Razón no se haya podido realizar la consulta.
    */
/*    public boolean consultaRutaInstruccion(){
        String sqlInstruccion;          // Contiene el postulado SQL para la consulta a la BD
        String strResultado[][] = null; // Obtiene el resultado de la consulta

        // Se construye el postulado SQL
        sqlInstruccion = "SELECT " +
        "INS_ASU.INS_FOLIO_TURNADO AS FOLIO_TURNADO," +
        "USU.USU_NOMBRE AS PUESTO," +
        "INS.INS_NOMBRE AS INSTRUCCION_ASIGNADA," +
        "DECODE(INS_ASU.INS_TIPO_ATENCION,0,'ejecución',1,'Informativa',INS_TIPO_ATENCION) AS TIPO_ATENCION," +
        "DECODE(INS_ASU.INS_ESTATUS,0,'No turnada',1,'Por atender',2,'En tramite',3,'Rechazada',4,'Terminada',INS_ESTATUS) AS ESTATUS, " +
        "CONCAT(INS_ASU.INS_AVANCE,' %') AS AVANCE," +
        "INS_ASU.ID_INSTRUCCION_ASUNTO  AS INSTRUCCION, "+
        "REPLACE(INS_ASU.INS_FOLIO_TURNADO,'-','A') AS FOLIO_ORDEN " +
        " FROM SD_INSTRUCCION_ASUNTO INS_ASU,  SD_USUARIO USU, SD_INSTRUCCION INS " +
        "WHERE INS_ASU.ID_ASUNTO = " + getIdAsunto() +
        "        AND INS_ASU.INS_USUARIO = USU.ID_USUARIO" +
        "        AND INS_ASU.INS_INSTRUCCION = INS.ID_INSTRUCCION" +
        " ORDER BY FOLIO_ORDEN, PUESTO";
        //System.out.println("Ruta.consultaRuta: " + sqlInstruccion);
        try{
            // Ejecuta el postulado SQL
            strResultado = AuxDB.ejecutarSQL(sqlInstruccion);
        }catch(SQLException sqle){
            //System.out.println("Error en Ruta.consultaRuta: " + sqle.getMessage());
            sqle.printStackTrace();
            setError("Error al intentar realizar la consulta:  " + sqle.getMessage());
            return false;
        }

        // Asigna la salida de la consulta a las variables de la clase.
        setSalida(strResultado);
        setNumReg(strResultado.length);
        return true;
    }
*/

    /**
    * Consulta un Identificador de asunto y su Descripción correspondiente
    * obtiene los valores y los deja en las variables correspondientes validando
    * que sus valores no sean nulos.
    *
    * Los campos que se obtienen son:
    *
    * - ID_ASUNTO
    * - DESCRIPCION DEL ASUNTO
    *
    * @return boolean Regresa verdadero en caso de que la consulta se haya podido realizar
    * sin problemas y la información haya sido arrojada a las variables correspondientes y
    * falso en caso de que por alguna Razón no se haya podido realizar la consulta.
    */
    public boolean consultaIdAsunto(){
        String sqlAsunto;
        String strResultado[][];

        // Si no se trae ningún valor en folio no se realiza la consulta
        if (getFolio() == null){
            setError("No se ha proporcionado el folio para realizar la consulta");
            return false;
        }

        // Se construye el postulado SQL
        sqlAsunto = "SELECT ASU.ID_ASUNTO," +
                    " ASU.ASU_DESCRIPCION," +
                    " ASU.ASU_FIRMANTE," +
                    " ARE.ARE_NOMBRE AS UA_RECEPCION," +
                    " USU.USU_NOMBRE AS REMITENTE," +
                    " ASU.ASU_COMENTARIOS " +
                    "FROM SD_ASUNTO ASU, SD_AREA ARE, SD_USUARIO USU " +
                    "WHERE ASU.ASU_FOLIO_RECEPCION = '" + getFolio() + "'" +
                    " AND ASU.ASU_AREA_RECEPCION = ARE.ID_AREA" +
                    " AND ASU.ASU_REMITENTE = USU.ID_USUARIO";

        //System.out.println("Ruta.consultaIdAsunto: " + sqlAsunto);

        try{
            // Ejecuta el postulado SQL
            strResultado = AuxDB.ejecutarSQL(sqlAsunto);
        }catch(SQLException sqle){
            //System.out.println("Error en Ruta.consultaIdAsunto: " + sqle.getMessage());
            sqle.printStackTrace();
            setError("Error al intentar realizar la consulta:  " + sqle.getMessage());
            return false;
        }

        // Asigna la salida de la consulta a las variables de la clase.
        try{
            if (strResultado.length == 0){
                setIdAsunto(0);
                setError("No esta registrado el folio indicado");
                return false;
            }
            setIdAsunto(Integer.parseInt(strResultado[0][0]));
            setDescAsunto(strResultado[0][1]);
            setFirmante(strResultado[0][2]);
            setUnidadAdministrativa(strResultado[0][3]);
            setRemitente(strResultado[0][4]);
            setComentarios(strResultado[0][5]);
        }catch(NumberFormatException nfe){
            setIdAsunto(0);
            setError("No se obtuvo un valor númerico en el IdAsunto asociado al folio");
            return false;
        }
        return true;
    }

    public String asuntosConPermiso(String elem, String idUsr){
        String strResultado[][];
        String sqlStr = null;     // Contiene el postulado SQL para borrar información de la BD
        int registros = 0;                 // Obtiene el resultado del borrado
        String foliosConPermiso= "";

        // Se construye el postulado SQL
        
        elem= "'" + elem.replaceAll(",","','") + "'";
        sqlStr = "SELECT DISTINCT INS.ID_ASUNTO, ASU.ASU_FOLIO_RECEPCION " + 
                 "  FROM SD_INSTRUCCION_ASUNTO INS, SD_ASUNTO ASU " + 
                 " WHERE INS.ID_ASUNTO IN (SELECT ID_ASUNTO " + 
                                            "FROM SD_ASUNTO " +
                                           "where ASU_FOLIO_RECEPCION IN ("+ elem + ")) " + 
                                            " AND (INS.INS_TURNO = " + idUsr + " OR INS.INS_USUARIO = " + idUsr + ") " + 
                                            " AND ASU.ID_ASUNTO = INS.ID_ASUNTO " +
                                            " AND INS.INS_ACCESO = 1";

        //System.out.println("Ruta.asuntosConPermiso: " + sqlStr );

        try{
            // Ejecuta el postulado SQL
            strResultado = AuxDB.ejecutarSQL(sqlStr);
            for(int i=0;i<strResultado.length;i++){
                foliosConPermiso+= strResultado[i][1] +  ",";
                relacionIDFolio += strResultado[i][1] + "-" + strResultado[i][0] + ",";
            }
            if (foliosConPermiso.length()>0){
                foliosConPermiso = foliosConPermiso.substring(0,foliosConPermiso.length()-1);
            }
            if (relacionIDFolio.length()>0){
                relacionIDFolio = relacionIDFolio.substring(0,relacionIDFolio.length()-1);
            }
            
        }catch(SQLException sqle){
            //System.out.println("Error en Ruta.asuntosConPermiso: " + sqle.getMessage());
            sqle.printStackTrace();
            setError("Error al intentar realizar la consulta:  " + sqle.getMessage());
            return "-1";
        }
        return foliosConPermiso;
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

    /**
    * Asigna el valor pasado como parámetro a la variable salida
    *
    * @param salida Resultado de una consulta SQL
    */
    public void setSalida(String[][] salida) {
        this.salida = salida;
    }

    /**
    * Regresa el valor de la variable salida.
    *
    * @return String[][] (salida) Resultado de una consulta SQL
    */
    public String[][] getSalida() {
        return salida;
    }

    /**
    * Asigna el valor pasado como parámetro a la variable error
    *
    * @param error Error que ocurra durante la consulta de datos
    */
    public void setError(String error) {
        this.error = error;
    }

    /**
    * Regresa el valor de la variable error.
    *
    * @return String (error) Error ocurrido en la consulta.
    */
    public String getError() {
        return error;
    }

    /**
    * Asigna el valor pasado como parámetro a la variable numReg
    *
    * @param numReg Número de registros obtenidos de la consulta de la ruta
    */
    public void setNumReg(int numReg) {
        this.numReg = numReg;
    }

    /**
    * Regresa el valor de la variable numReg.
    *
    * @return int (numReg) Número de registros obtenidos de la consulta de la ruta.
    */
    public int getNumReg() {
        return numReg;
    }

    /**
    * Asigna el valor pasado como parámetro a la variable descAsunto
    *
    * @param descAsunto Descripción del asunto
    */
    public void setDescAsunto(String descAsunto) {
        this.descAsunto = descAsunto;
    }

    /**
    * Regresa el valor de la variable descAsunto.
    *
    * @return String (descAsunto) Descripción del asunto
    */
    public String getDescAsunto() {
        return descAsunto;
    }

    public void setUnidadAdministrativa(String unidadAdministrativa) {
        this.unidadAdministrativa = unidadAdministrativa;
    }

    public String getUnidadAdministrativa() {
        return unidadAdministrativa;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setFirmante(String firmante) {
        this.firmante = firmante;
    }

    public String getFirmante() {
        return firmante;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setNumNodos(int numNodos) {
        this.numNodos = numNodos;
    }

    public int getNumNodos() {
        return numNodos;
    }

    public void setNodos(String[][] nodos) {
        this.nodos = nodos;
    }

    public String[][] getNodos() {
        return nodos;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public String getSesion() {
        return sesion;
    }

    public void setAsuntosViejos(String[][] asuntosViejos) {
        this.AsuntosViejos = asuntosViejos;
    }

    public String[][] getAsuntosViejos() {
        return AsuntosViejos;
    }

    public void setNumAsuntosViejos(int numAsuntosViejos) {
        this.numAsuntosViejos = numAsuntosViejos;
    }

    public int getNumAsuntosViejos() {
        return numAsuntosViejos;
    }
}
