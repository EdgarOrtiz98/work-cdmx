/*
 **************************************************************
 * Copyright (C) 2007 SHCP 
 * CGTIyC - alejandro_gavia@hacienda.gob.mx
 * 
 * $$Archivo: 	Puesto.java
 * $$Revisión: 	DARG - AOA - Creación del objeto Puesto.
 * $$Fecha: 	23 de Enero de 2007
 * 
 * Este software es información propietaria y confidencial de la SHCP - CGTIyC. 
 ***************************************************************
 */

package gob.hacienda.cgtic.siga;

import com.meve.sigma.db2.ConexionDS;
import java.sql.SQLException;

 /**
  * Objeto Puesto. representa un puesto dentro del sistema SIGA, el 
  * cual se puede utilizar para extraer información al respecto de los 
  * puestos existentes en el SIGA y en los asuntos y documentos relacionados.
  *
  * @version 1.0.3 23 Ene 2007
  * @author Daniel Rangel - Alberto Ortiz
  */
  public class Puesto {

    private String idUsuario;        // Identificador del usuario
    private String nombre;           // Nombre del puesto
    private String cargo;            // Nombre del responsable del puesto
    private String correo;           // Correo Electrónico del Usuario asociado al puesto
    private String telefono;         // Teléfono del Usuario asociado al puesto
    private String idArea;           // Id del Area del usario
    private String nameArea;           // Descripción del Area del usario
      /**
      * Constructor básico de la clase, crea una instancia de la clase sin valores
      */
     public Puesto() {
     }

     /**
     * Constructor que recive como parámetro el IdUsuario y lo asigna a la variable 
     * de clase correspondiente
     *
     * @param idUsuario Identificador del Usuario
     */
     public Puesto(String idUsuario) {
     
     // Asigna el parámetro idUsuario a la variable de clase
     setIdUsuario(idUsuario);
     }

      /**
      * Asigna el valor pasado como parámetro a la variable correpondinte (idUsuario)
      *
      * @param idUsuario Identificador del Usuario
      */
      public void setIdUsuario(String idUsuario) {
          // Verifica si| trae como parámetro el valor "null" asigna un cero
          this.idUsuario = (idUsuario.equalsIgnoreCase("null"))?"0":idUsuario;
      }

      /**
      * Regresa el valor de la variable IdUsuario.
      *
      * @return String (IdUsuario) Identificador del usuario
      */
      public String getIdUsuario() {
          return idUsuario;
      }

      /**
      * Asigna el valor pasado como parámetro a la variable correpondinte (nombre)
      *
      * @param nombre Nombre del puesto
      */
      public void setNombre(String nombre) {
          this.nombre = nombre;
      }

      /**
      * Regresa el valor de la variable nombre.
      *
      * @return String (nombre) Nombre del puesto
      */
      public String getNombre() {
          return nombre;
      }

      /**
      * Asigna el valor pasado como parámetro a la variable correpondinte (cargo)
      *
      * @param cargo Nombre del responsable del puesto
      */
      public void setCargo(String cargo) {
          this.cargo = cargo;
      }

      /**
      * Regresa el valor de la variable cargo.
      *
      * @return String (cargo) Nombre del responsable del puesto
      */
      public String getCargo() {
          return cargo;
      }

      /**
      * Asigna el valor pasado como parámetro a la variable correpondinte (correo)
      *
      * @param correo Correo Electrónico del Usuario asociado al puesto
      */
      public void setCorreo(String correo) {
          this.correo = correo;
      }

      /**
      * Regresa el valor de la variable correo.
      *
      * @return String (correo) Correo Electrónico del Usuario asociado al puesto
      */
      public String getCorreo() {
          return correo;
      }

      /**
      * Asigna el valor pasado como parámetro a la variable correpondinte (telefono)
      *
      * @param telefono Teléfono del Usuario asociado al puesto
      */
       public void setTelefono(String telefono) {
           this.telefono = telefono;
       }
       
       /**
       * Regresa el valor de la variable telefono.
       *
       * @return String (telefono) Teléfono del Usuario asociado al puesto
       */
       public String getTelefono() {
           return telefono;
       }

    public void setIdArea(String idArea) {
      this.idArea = idArea;
    }
    
    public String getIdArea() {
      return this.idArea;
    }

    public void setAreaName(String dArea) {
        this.nameArea = dArea;
    }
    
    public String getAreaName() {
        return this.nameArea;
    }
      
      
      
     /**
     * Consulta en al Base de datos un puesto, obtiene los valores y los deja en las
     * variables correspondientes validando que sus valores no sean nulos.
     * 
     * Los campos que se obtienen son: nombre, cargo, correo y telefono
     *
     * @return boolean Regresa verdadero en caso de que la consulta se haya podido realizar
     * sin problemas y la información haya sido arrojada a las variables correspondientes y 
     * falso en caso de que por alguna Razón no se haya podido realizar la consulta.
     */
     public boolean consultaPuesto(){
     
         String sqlPuesto;      // Contiene el postulado SQL para la consulta en la BD
         String strResultado[][];
         
         // Construye el postulado SQL
         sqlPuesto = "SELECT USU_NOMBRE, USU_CARGO, USU_CORREO, USU_TELEFONO, " + 
            "USU_AREA, A.ARE_NOMBRE FROM SD_USUARIO, SD_AREA A " + 
            "WHERE  ID_USUARIO =" + getIdUsuario() +" AND USU_AREA = A.ID_AREA";
         
         // Manda a la consola el SQL de consulta de Puesto
         ////System.out.println("Puesto.consultaPuesto: " + sqlPuesto);
         
         // Realiza la consulta y el resultado lo deja en las variables correspondintes
         // En caso de que no se pueda realizar la consulta se regresa falso
         try {
             strResultado = ConexionDS.ejecutarSQL(sqlPuesto);
         } catch (SQLException sqle) {
             //System.out.println("Ocurrio el siguiente error en Puesto.consultaPuesto: " + sqle.getMessage());
             sqle.printStackTrace();
             return false;
         }
         
         if (strResultado.length > 0){
             // Asigna los valores obtenidos de la consulta a las varibles de clase
             setNombre(strResultado[0][0]);
             setCargo(strResultado[0][1]);
             setCorreo(strResultado[0][2]);
             setTelefono(strResultado[0][3]);
             setIdArea(strResultado[0][4]);
             setAreaName(strResultado[0][5]);
         }else{
              // En caso de no traer valores asignar blancos
             setNombre("");
             setCargo("");
             setCorreo("");
             setTelefono("");
             setIdArea("");
             setAreaName("");
         }
         
         return true;
     }

     /**
     * Consulta en al Base de datos un puesto, obtiene los campos: Nombre y Campo.
     *
     * @return String Regresa los campos: Nombre y Campo; concatenados con un /
     *         en caso de que no se haya podido realizar la consulta regresa null.
     */
    public String getPuestoById(){
        this.consultaPuesto();
        if (getNombre()!=null && getCargo()!= null)
            return (getCargo() + " / " + getNombre());
        else
            return null;        
    }

      /**
      * Consulta en al Base de datos un puesto, obtiene los campos: Nombre y Campo.
      *
      * @return String Regresa los campos: Nombre y Campo; concatenados con un /
      *         en caso de que no se haya podido realizar la consulta regresa null.
      */
      public String getUaName(){
         consultaPuesto();
          if (getIdArea()!=null && getAreaName()!= null)
              return (getAreaName());
          else
              return null;        
      }


  }