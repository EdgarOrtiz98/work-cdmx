 /*
  **************************************************************
  * Copyright (C) 2007 SHCP 
  * CGTIyC - alberto_ortiz@hacienda.gob.mx
  * 
  * $$Archivo:   Puestos.java
  * $$Revisión:  AOA - Creación del objeto Puesto.
  * $$Fecha:     24 de Enero de 2007
  * 
  * Este software es información propietaria y confidencial de la SHCP - CGTIyC. 
  ***************************************************************
  */

package gob.hacienda.cgtic.siga;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.actualiza.*;
import com.meve.sigma.util.ArbolTurnado;
import java.sql.SQLException;
import java.util.*;

public class Puestos {

    private int numReg= 0;                  // Número de registros
    private Puesto salPuestos[] = null;     // Arreglo de puestos (Resultado de las consultas)
    private boolean filtradoPuestos = false;

     /**
     * Constructor básico de la clase, crea una instancia de la clase sin valores
     */
    public Puestos() {
    }

    /**
    * Asigna el Número de registros obtenidos de una consulta
    *
    * @param numReg Número de registros de una consulta
    */
    private void setNumReg(int numReg) {
        this.numReg = numReg;
    }

    /**
    * Regresa el Número de registros que se obtuvieron de una consulta.
    *
    * @return int (numReg) Número de registros de una consulta
    */
    public int getNumReg() {
        return numReg;
    }

    public boolean ConsultaPorUA(String UniAdmin, boolean filtUsu, String strIdTur, String strban){
        this.filtradoPuestos = filtUsu;
        return ConsultaPorUA(UniAdmin, strIdTur, strban);
    }
    /**
    * Realiza la consulta de puestos por Unidad Administrativa, dejando el 
    * resultado en un arreglo de Puestos
    *
    * @param UniAdmin Unidad Administrativa a consultar
    */
    public boolean ConsultaPorUA(String UniAdmin, String strIdTur, String strban){
        String sqlPuestos;        // Contiene el postulado SQL para la consulta en la BD
        String strResultado[][];  // Obtiene la salida de la consulta
        String strSub[][] = null; // Obtiene la lista de subordinados a turnar
        
        //Verifica si el área tiene la asignación de subventanilla
        String strSubventanilla = ActualizaInstrucciones.getAreaSubventanilla(UniAdmin);
        
        if(strSubventanilla.equals("0") && strban.equals("0")){
        	String strIdUsr = ActualizaInstrucciones.getUsuarioSubventanilla(strIdTur);
        	strSub = ActualizaUsuario.getSubalternosTurnadorSub(strIdUsr);
        	
        	ArbolTurnado arbol = new ArbolTurnado(strSub);
        	Vector vIds = new Vector();
        	Vector vNombre = new Vector();
        	Vector vPuesto = new Vector();
        	Vector vMail = new Vector();
        	Vector vTel = new Vector();
        	vIds	=	arbol.getIds();
        	vNombre	=	arbol.getNombre();
        	vPuesto	=	arbol.getPuesto();
        	vMail	=	arbol.getMail();
        	vTel	=	arbol.getTel();
        	//Asocia el Número de registros
        	setNumReg(arbol.getIds().size());

        	// Crea el arreglo de puestos de longitud igual al Número de registros
        	salPuestos= new Puesto[getNumReg()];
        	
        	// Vacia el resultado en el arreglo de puestos
        	for (int cont= 0;cont<getNumReg();cont++){
        		salPuestos[cont] = new Puesto();
             
            	salPuestos[cont].setIdUsuario((String)vIds.get(cont));
            	salPuestos[cont].setNombre((String)vNombre.get(cont));
            	salPuestos[cont].setCargo((String)vPuesto.get(cont));
            	salPuestos[cont].setCorreo((String)vMail.get(cont));
            	salPuestos[cont].setTelefono((String)vTel.get(cont));
        	}

        }else{
        
        	// Construye el postulado SQL
        	sqlPuestos = "SELECT ID_USUARIO, USU_NOMBRE, USU_CARGO, USU_CORREO, USU_TELEFONO " + 
                     " FROM SD_USUARIO " +
                     " WHERE  USU_AREA = '" + UniAdmin +"' " +
                     " AND USU_ESTATUS = 1 " +
                     " AND USU_ACTIVO = 1 ";
        	if (this.filtradoPuestos){
            	sqlPuestos += " AND ID_USUARIO IN " + 
				" (SELECT DISTINCT ID_USUARIO1 FROM SD_USUARIO_ROL WHERE ID_ROL=1) ";
        	}
        	sqlPuestos += " ORDER BY 3 ";
        
        	// Manda a la consola el SQL de consulta de Puesto
        	////System.out.println("Puestos.ConsultaPorUA: " + sqlPuestos);
        
        	// Realiza la consulta y el resultado lo deja en las variables correspondintes
        	// En caso de que no se pueda realizar la consulta se regresa falso
        	try {
            	strResultado = ConexionDS.ejecutarSQL(sqlPuestos);
        	} catch (SQLException sqle) {
            	//System.out.println("Ocurrio el siguiente error en Puesto.ConsultaPorUA: " + sqle.getMessage());
            	sqle.printStackTrace();
            	return false;
        	}
        	// Asocia el Número de registros
        	setNumReg(strResultado.length);

        	// Crea el arreglo de puestos de longitud igual al Número de registros
        	salPuestos= new Puesto[getNumReg()];

        	// Vacia el resultado en el arreglo de puestos
        	for (int cont= 0;cont<getNumReg();cont++){
        		salPuestos[cont] = new Puesto();
             
            	salPuestos[cont].setIdUsuario(strResultado[cont][0]);
            	salPuestos[cont].setNombre(strResultado[cont][1]);
            	salPuestos[cont].setCargo(strResultado[cont][2]);
            	salPuestos[cont].setCorreo(strResultado[cont][3]);
            	salPuestos[cont].setTelefono(strResultado[cont][4]);
        	}
        }
        return true;
    }

    /**
    * Regresa el puesto que se encuentra en la posición indicada del arreglo. El 
    * arreglo es creado a partir de una consulta.
    *
    * @param posicion posición del arreglo de puestos que se desea
    * @return Puesto puesto que est en la posición pasada como parámetro
    */
    public Puesto getPuesto(int posicion){
        if (posicion <= getNumReg())
            return salPuestos[posicion];
        else
            return null;
    }

    /**
     * Puestos de subordinados 
     * @param IdUsuario ID del Jefe 
     * @return Regresa true si existen o false en caso contrario 
     */
    public boolean getPuestosSubordinados(String IdUsuario){
        String strSql;        // Contiene el postulado SQL para la consulta en la BD
        String strResultado[][];  // Obtiene la salida de la consulta

         // Construye el postulado SQL
        strSql = "SELECT DISTINCT A.ID_USUARIO, A.USU_NOMBRE, A.USU_CARGO " + 
            " FROM SD_USUARIO A, SD_USUARIO_ROL B WHERE  A.USU_ESTATUS = 1 " +
            " AND A.USU_ACTIVO = 1 AND A.ID_USUARIO = B.ID_USUARIO1 AND B.ID_ROL = 1 " + 
            " START WITH A.USU_JEFE = " + IdUsuario + " CONNECT BY PRIOR A.ID_USUARIO = " +
            " A.USU_JEFE ORDER BY 3";
            
        // Manda a la consola el SQL de consulta de puestos subordinados
        ////System.out.println("Puestos.getPuestosSubordinados: "+strSql);
        try
        {
            strResultado = ConexionDS.ejecutarSQL(strSql);
        }catch(SQLException sqle){
            //System.out.println("Puestos.getPuestosSubordinados:" + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }        
        // Asocia el Número de registros
        setNumReg(strResultado.length);
        // Crea el arreglo de puestos de longitud igual al Número de registros
        salPuestos= new Puesto[getNumReg()];

        // Vacia el resultado en el arreglo de puestos
        for (int cont= 0;cont<getNumReg();cont++){
        salPuestos[cont] = new Puesto();
             
            salPuestos[cont].setIdUsuario(strResultado[cont][0]);
            salPuestos[cont].setNombre(strResultado[cont][1]);
            salPuestos[cont].setCargo(strResultado[cont][2]);
        }
        
        return true;
    }

    /**
     * @param IdUsuario Identificador del Puesto (Usuario) del cual se desea obtener 
     *        sus subordinados.
     * @return Regresa un String con los puestos subordinados de un puesto, listo
     *         para incorporarse al cuerpo de un combo
     */
    public String getComboPuestosSubordinados(String IdUsuario){
        String cmbPto="<option value='null'>[Seleccionar]</option>";
        String str_jefe;
        if ((str_jefe = getAsistenteDe(IdUsuario)) == null) {
            str_jefe = IdUsuario;
        }

        if (getPuestosSubordinados(str_jefe))
            for(int i=0;i<getNumReg();i++)
                cmbPto += "<option value='" + getPuesto(i).getIdUsuario() + "'>" + 
                getPuesto(i).getCargo() + " / " +  getPuesto(i).getNombre()  + "</option>";
        return cmbPto;
    }
    
    public String getAsistenteDe(String IdUsuario){
        String strSql;        // Contiene el postulado SQL para la consulta en la BD
        String strResultado[][];  // Obtiene la salida de la consulta

         // Construye el postulado SQL
        //strSql = "SELECT ID_USUARIO FROM SD_USUARIO WHERE USU_ASISTENTE = " + IdUsuario ;
        strSql = "SELECT ASI_USUARIO FROM SD_ASISTENTES WHERE ASI_ASISTENTE="+IdUsuario;
            
        // Manda a la consola el SQL de consulta de puestos subordinados
        ////System.out.println("Puestos.getAsistenteDe: "+strSql);
        try
        {
            strResultado = ConexionDS.ejecutarSQL(strSql);
        }catch(SQLException sqle){
            //System.out.println("Puestos.getAsistenteDe:" + sqle.getMessage());
            sqle.printStackTrace();
            return null;
        }        
        if (strResultado.length>0){
            return strResultado[0][0];        
        }else{
            return null;
        }
        
    }
}