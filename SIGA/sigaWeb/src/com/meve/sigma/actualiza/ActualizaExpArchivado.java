/**
 * Metodos para Actualizar, Modificar y Editar los las tablas de Archivado
 * 
 * @author Meve Soluciones S.A. de C.V.
 */

package com.meve.sigma.actualiza;
import java.sql.SQLException;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.sql.SQLExpArchivado;


//import com.meve.sigma.sql.SQLSubfondo;

public class ActualizaExpArchivado { 

    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp Tipo de consulta
     * @param strOrden Tipo de ordenamiento
     * @param tipo Criterio de ordenamiento
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String[][] getporExpediente(String exp, String strOrden, String tipo)
	{	
		try
		{
		    String strsql = null;
		    if("".equalsIgnoreCase(exp))exp="0";
		    
		    if(exp == "sinexp" || exp.equalsIgnoreCase("sinexp"))
		    {
		        strsql = SQLExpArchivado.getporExpedienteAsu4(strOrden, tipo);
				return ConexionDS.ejecutarSQL(strsql);
		    }
		    
		    if(exp == "todoexp" || exp.equalsIgnoreCase("todoexp"))
		    {
		        strsql = SQLExpArchivado.getporExpedienteAsu5(strOrden, tipo);
				return ConexionDS.ejecutarSQL(strsql);
		    }
		    
		    if(exp == "sin" || exp.equalsIgnoreCase("sin"))
		    {
		        strsql = SQLExpArchivado.getporExpedienteAsu2(exp, strOrden, tipo);
		    }else
		    {
		        if(exp == "todo" || exp.equalsIgnoreCase("todo"))
			    {
			        strsql = SQLExpArchivado.getporExpedienteAsu3(exp, strOrden, tipo);
			    }else
			    {
			        strsql = SQLExpArchivado.getporExpedienteUnico(exp, strOrden, tipo);
			    }
		    }
                   // //System.out.println("Rafael -> " + strsql);
                    return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getporExpediente:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
	

        /**
         * Función que ejecuta un query, donde se crea una lista de 
             * los usuarios pertenecientes a un area
         * 
         * @param exp Tipo de consulta
         * @param strOrden Tipo de ordenamiento
         * @param tipo Criterio de ordenamiento
         * @return Regresa un String[][] con los expedientes y asuntos requeridos.
         */
            public static String[][] getporExpediente_Consulta(String exp, String strOrden, String tipo, String clave, String denominacion, String idUA)
            {       
                    try
                    {
                        
                        String strsql = null;
                        strsql = SQLExpArchivado.get_Expediente_Asunto_Consulta(exp, strOrden, tipo, clave, denominacion, idUA);
                        return ConexionDS.ejecutarSQL(strsql);
                    }
                    catch(SQLException sqle)
                    {
                                    //System.out.println("getporExpediente:"+sqle.getMessage());
                                    sqle.printStackTrace();
                                    return null;
                    }                                               
            }

    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp Tipo de consulta
     * @param strOrden Tipo de ordenamiento
     * @param tipo Criterio de ordenamiento
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String[][] getporExpedienteInst(String exp, String strOrden, String tipo)
	{	
		try
		{
		    String strsql = null;
		    if("".equalsIgnoreCase(exp))exp="0";
		    
		    if(exp == "sinexp" || exp.equalsIgnoreCase("sinexp"))
		    {
		        strsql = SQLExpArchivado.getporExpedienteInst4(strOrden, tipo);
				return ConexionDS.ejecutarSQL(strsql);
		    }
		    
		    if(exp == "todoexp" || exp.equalsIgnoreCase("todoexp"))
		    {
		        strsql = SQLExpArchivado.getporExpedienteInst5(strOrden, tipo);
				return ConexionDS.ejecutarSQL(strsql);
		    }
		    
		    if(exp == "sin" || exp.equalsIgnoreCase("sin"))
		    {
		        strsql = SQLExpArchivado.getporExpedienteInst2(exp, strOrden, tipo);
		    }else
		    {
		        if(exp == "todo" || exp.equalsIgnoreCase("todo"))
			    {
			        strsql = SQLExpArchivado.getporExpedienteInst3(exp, strOrden, tipo);
			    }else
			    {
			        strsql = SQLExpArchivado.getporExpedienteUnico(exp, strOrden, tipo);
			    }
		    }
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getporExpedienteInst:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}	
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp Tipo de consulta
     * @param strOrden Tipo de ordenamiento
     * @param tipo Criterio de ordenamiento
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String[][] getporExpedienteAsunto(String exp, String strOrden, String tipo)
	{	
		try
		{
		    String strsql = null;
		    
		    if(exp == "0" || exp.equalsIgnoreCase("0"))
		    {
		        strsql = strsql = SQLExpArchivado.getporExpediente2(exp, strOrden, tipo);
				return ConexionDS.ejecutarSQL(strsql);
		    }else{
		        strsql = SQLExpArchivado.getporExpediente(exp, strOrden, tipo);
		    }
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getporExpediente:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
	
    /**
     * Función que ejecuta un query, donde se crea una lista de 
	 * los usuarios pertenecientes a un area
     * 
     * @param exp Tipo de consulta
     * @param strOrden Tipo de ordenamiento
     * @param tipo Criterio de ordenamiento
     * @return Regresa un String[][] con los expedientes y asuntos requeridos.
     */
	public static String[][] getporExpedienteInstruccion(String exp, String strOrden, String tipo)
	{	
		try
		{
		    String strsql = null;
		    
		    if(exp == "0" || exp.equalsIgnoreCase("0"))
		    {
		        strsql = strsql = SQLExpArchivado.getporInst2(exp, strOrden, tipo);
		        ////System.out.println("getporExpedienteAsu2:"+strsql);
				return ConexionDS.ejecutarSQL(strsql);
		    }else{
		        strsql = SQLExpArchivado.getporInst(exp, strOrden, tipo);
		    }

			////System.out.println("getporExpediente:"+strsql);
			return ConexionDS.ejecutarSQL(strsql);
		}
		catch(SQLException sqle)
		{
				//System.out.println("getporExpediente:"+sqle.getMessage());
				sqle.printStackTrace();
				return null;
		}						
	}
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de SD_SUBFONDO
         * @param codigo Codigo de subfondo
         * @param seccion Seccion del subfondo
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @return Consultas para Archivado
         */
        public static boolean insertarSubfondo(	String codigo, String seccion,
    											String fecha, String Usr)
        {
            int r = 0;
            try
            {
                String strSql = SQLExpArchivado.insertarSubfondo(codigo, seccion, fecha, Usr);
                ////System.out.println("InsertarArchivado"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
            }
            catch (SQLException sqle)
            {
                //System.out.println("InsertaAsunto:"+sqle.getMessage());
                sqle.printStackTrace();
                return false;
            }
            return (r>0);
        }
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Subfondo Archivado
         * @param codigo Nombre del Subfondo
         * @param seccion Descripcion del Subfondo
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @return Consultas para Archivado
         */
        public static boolean insertarSubfondoA(	String codigo, String seccion,
    											String fecha, String Usr)
        {
            int r = 0;
            try
            {
                String strSql = SQLExpArchivado.insertarSubfondoA(codigo, seccion, fecha, Usr);
                ////System.out.println("InsertarArchivado"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
            }
            catch (SQLException sqle)
            {
                //System.out.println("InsertaAsunto:"+sqle.getMessage());
                sqle.printStackTrace();
                return false;
            }
            return (r>0);
        }   
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Valoracion
         * @param codigo Nonbre validacion.
         * @param seccion Descripcion de la validacion.
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param val1 Identificadores de los valores 
         * @param val2 Tipo de Valor2
         * @param val3 Tipo de Valor3
         * @param clv Clave del Registro 
         * @param Aux Clave para Validacion  
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarValoracion(	String codigo, String seccion,
    											String fecha, String Usr,String val1[],String val2,String val3, String clv, String Aux)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaValoracion(clv,Aux);
    			////System.out.println("validaValoracion------->:");
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 } 
                String strSql = SQLExpArchivado.insertarValoracion(codigo, seccion, fecha, Usr, val1, val2, val3,clv);
                ////System.out.println("insertarValoracion"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaValoracion(Usr,clv, codigo, seccion);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarValoracion:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }
        
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla del cuadro de Diposicion Documental
         * @param area Identificador del Area
         * @param seccion Identificador de la seccion
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param series Identificadores de la series
         * @param subser Identificadores de la Subseries
         * @return Consultas para Archivado
         */
        public static int insertarIcdd(	String area, String seccion,
    											String fecha, String Usr,String series[],String subser[])
        {
            int r = 0;
            try
            {
        		String ids="";
        		String idsub="";
                /*String str = SQLExpArchivado.validaValoracion(clv,Aux);
    			//System.out.println("validaValoracion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				
    				    return 2;
    				 } */
             if(series != null)
        	 {
        			for(int i=0; i<series.length;i++)
        			{
		        			ids = series[i];
		        			String strSql = SQLExpArchivado.insertarIcdd(area, seccion, fecha, Usr, ids, null);
		                    ////System.out.println("insertarIcdd"+strSql);
		                    r = ConexionDS.ejecutarActualizacion(strSql);
        			}
        	 }
        	 if(subser != null)
        	 {
        			for(int i=0; i<subser.length;i++)
        			{ 
        		    idsub =subser[i];
        			String strSql = SQLExpArchivado.insertarIcdd(area, seccion, fecha, Usr,null, idsub);
                    ////System.out.println("insertarIcdd"+strSql);
                    r = ConexionDS.ejecutarActualizacion(strSql);
        			}
        	 }
                
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaICDDUnidad(area,seccion,fecha,Usr);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarIcdd:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }

        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Seccion
         * @param fondo Identificador del fondo
         * @param subfondo Identificador del subfondo
         * @param codigo Codigo de Seccion
         * @param seccion Seccion del Seccion
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clave Clave del Registro 
         * @param Aux Clave para Validacion 
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarSeccion(		String fondo, String subfondo,
                								String codigo, String seccion,
    											String fecha, String Usr, String clave, String Aux)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaSeccion(clave,Aux,fondo,subfondo);
    			////System.out.println("validaClasificacion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strSql = SQLExpArchivado.insertarSeccion(fondo, subfondo,codigo, seccion, fecha, Usr,clave);
                ////System.out.println("insertarSeccion"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaSeccionArch(Usr,clave,fondo,
                																	subfondo,codigo,
																					seccion);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarSeccion:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }  
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Subserie
         * @param codigo Codigo de Subserie
         * @param seccion Seccion del Subserie
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clv Clave del Registro 
         * @param Aux Clave para Validacion 
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarSubserie(	String codigo, String seccion,
    											String fecha, String Usr, String serie, String clv, String Aux, String Aux2)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaSubserie(clv,serie,Aux,Aux2);
    			////System.out.println("validaSubserie:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strSql = SQLExpArchivado.insertarSubserie(codigo, seccion, fecha, Usr, serie,clv);
                ////System.out.println("InsertarArchivado"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaSubSerie(Usr,clv,serie);
            }
            catch (SQLException sqle)
            {
                //System.out.println("InsertaAsunto:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Expedientes
         * @param EXP_CVE_UA Clave Identificador del Area
         * @param EXP_AREA_DESC Descripcion del Area
         * @param EXP_CED_TIPO Identificador de Cedula tipo
         * @param EXP_CLAVE Clave del Expediente
         * @param EXP_INTERNO Descrpcion Interna
         * @param EXP_UBICACION Ubicacion Topografica
         * @param EXP_DENOMINACION Nombre del Expediente
         * @param EXP_DESCRIPCION Descripcion
         * @param EXP_VALORACION Identificador de la Valoracion
         * @param EXP_FEC_CIERRE Fecha de Cierre
         * @param EXP_ANO_AT Numero de Años de Tramite
         * @param EXP_ANO_AC Numero de Años de Concentracion
         * @param EXP_SISI_DISP Muestra si es consultado por SISI
         * @param EXP_ANIOS_TOTAL_DISP Usuario que actualizo
         * @param EXP_CVE_CLASF_INF Identificador de la clsificacion informativa
         * @param EXP_MOTIVO Motivo del Expediente
         * @param EXP_FUNDAMENTO Fundamentos para expediente
         * @param EXP_OBSERVA Observaciones
         * @param EXP_ANO_RESERV Numero de Años reservados
         * @param EXP_ANO_REAL Numero de Años reales de vigencia
         * @param EXP_SISI_CLS Muestra si es consultado por SISI
         * @param EXP_ANIOS_TOTAL_CLS Numero Total de Años por clasificacion
         * @param EXP_ANIOS_AMPLI Numero de Años a ampliar
         * @param EXP_FEC_AMPLI Fecha en q se aplica una ampliacion
         * @param EXP_ANIOS_GUARDA Numero de Años de guarda
         * @param EXP_USUARIO Id de Usuario q guarda
         * @param EXP_FEC_APERTURA Fecha de apertura del Expediente
         * @param CONSECUTIVO Consecutivo del Expediente
         * @param EXP_UB_FISICA Dirección Fisica del Expediente
         * @param Aux Clave para Validacion   
         * @param Aux2 Clave para Validacion 
         * @param Aux3 Clave para Validacion 
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarExpediente(String EXP_CVE_UA, String EXP_AREA_DESC, String EXP_CED_TIPO , 
                String EXP_CLAVE,String EXP_INTERNO,String EXP_UBICACION ,
                String EXP_DENOMINACION  , String EXP_DESCRIPCION  ,String EXP_VALORACION , String EXP_FEC_CIERRE ,
                String EXP_ANO_AT , String EXP_ANO_AC, String EXP_SISI_DISP, String EXP_ANIOS_TOTAL_DISP, String EXP_CVE_CLASF_INF , 
                String EXP_MOTIVO , String EXP_FUNDAMENTO ,String EXP_OBSERVA ,String EXP_ANO_RESERV ,String EXP_ANO_REAL,
                String EXP_SISI_CLS, String EXP_ANIOS_TOTAL_CLS,String EXP_ANIOS_AMPLI , String EXP_FEC_AMPLI , 
                String EXP_ANIOS_GUARDA, String EXP_USUARIO,String EXP_FEC_APERTURA,String CONSECUTIVO,String EXP_UB_FISICA, String Aux, String Aux2, String Aux3)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaExpd(EXP_CLAVE,EXP_CVE_UA,EXP_CED_TIPO,Aux,Aux2,Aux3);
    			////System.out.println("validaClasificacion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    	        ////System.out.println("guar2-"+EXP_ANIOS_GUARDA);
                String strSql = SQLExpArchivado.insertarExpediente(EXP_CVE_UA, EXP_AREA_DESC, EXP_CED_TIPO , 
                        EXP_CLAVE, EXP_INTERNO, EXP_UBICACION, EXP_DENOMINACION, EXP_DESCRIPCION, EXP_VALORACION, EXP_FEC_CIERRE,
                        EXP_ANO_AT ,EXP_ANO_AC,EXP_SISI_DISP, EXP_ANIOS_TOTAL_DISP,EXP_CVE_CLASF_INF , 
                        EXP_MOTIVO , EXP_FUNDAMENTO ,EXP_OBSERVA ,EXP_ANO_RESERV ,EXP_ANO_REAL,
                        EXP_SISI_CLS, EXP_ANIOS_TOTAL_CLS,EXP_ANIOS_AMPLI , EXP_FEC_AMPLI , 
                        EXP_ANIOS_GUARDA, EXP_USUARIO,EXP_FEC_APERTURA,CONSECUTIVO,EXP_UB_FISICA);
                ////System.out.println("insertarExpediente  :"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaExpe(EXP_USUARIO,EXP_CLAVE,EXP_CVE_UA,EXP_CED_TIPO);
                ////System.out.println("ENCONTRANDO ERROR DE EXPEDIENTE........");

            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarExpediente:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Valores
         * @param codigo Nombre del Valor
         * @param seccion Descripcion del Valor
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clave Clave del Valor
         * @param Aux Clave para Validacion  
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarValor(	String codigo, String seccion,
    											String fecha, String Usr,String clave, String Aux)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaValor(clave,Aux);
    			////System.out.println("validaValor:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strSql = SQLExpArchivado.insertarValor(codigo, seccion, fecha, Usr,clave);
                ////System.out.println("InsertarArchivado"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaValore(Usr,clave, codigo, seccion);
            }
            catch (SQLException sqle)
            {
                //System.out.println("InsertaAsunto:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Cedula Tipo
         * @param codigo Nombre de la Cedula Tipo
         * @param seccion Descripcion de la Cedula Tipo
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clv clave de la Cedula Tipo
         * @param area Identificador de Unidad Administrativa
         * @param comb Identificador de la Combinacion Generada
         * @param strMotivo Descripcion del motivo de la cedula
         * @param strFunda  Descripcion del fundamiento de la cedula
         * @param strSubserie Identificador de la Subserie
         * @param strSerie Identificador de la Serie
         * @param Aux Clave para Validacion 
         * @param Aux2 Clave para Validacion 
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarTipCed(	String codigo, String seccion,
    											String fecha, String Usr, String clv, String area, String comb, String Aux, String Aux2,
    											String strMotivo, String strFunda, String strSubserie, String strSerie)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaCedula(clv,area,Aux,Aux2);
    			////System.out.println("validaCedula:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strSql = SQLExpArchivado.insertaTipCed(codigo, seccion, fecha, Usr, clv,area,comb,strMotivo,strFunda,strSubserie,strSerie);
                ////System.out.println("insertaTipCed"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaCedTipo(Usr,clv,area);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertaTipCed:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Selecciones
         * @param codigo Nombre de la Seleccion
         * @param seccion Descripcion de la Seleccion
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clv Clave del Seleccion
         * @param Aux Clave para Validacion  
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarSelecccion(	String codigo, String seccion,
    											String fecha, String Usr, String clv, String Aux)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaSelect(clv, Aux);
    			////System.out.println("validaSelect:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strSql = SQLExpArchivado.insertarSeleccion(codigo, seccion, fecha, Usr,clv);
                ////System.out.println("insertarSeleccion"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaSeleccion(Usr,clv,codigo,seccion);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarSeleccion:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Fondos
         * @param codigo Nombre del Fondo
         * @param seccion Descripcion de la Fondo
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param sisi Numero de Años sisi
         * @param clv Clave del Fondo
         * @param strAux Clave para Validacion  
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarFondo(	String codigo, String seccion,
    											String fecha, String Usr, String clv, 
												String sisi, String strAux)
        {
            int r = 0;
            try
            {
                clv = clv.toUpperCase();
                String str = SQLExpArchivado.validaFondo(clv, strAux);
    			////System.out.println("validaFondo:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strSql = SQLExpArchivado.insertarFondo(codigo, seccion, fecha, Usr,clv,sisi);
                ////System.out.println("insertarFondo"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
    			boolean bBitacora = ActualizaBitacora.InsertarEventoAltaFondo(Usr, clv,codigo,seccion,sisi);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarFondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Combinaciones
         * 
         * @param codigo Nombre
         * @param seccion descripccion
         * @param fecha fecha
         * @param Usr usuario
         * @param sub subserie
         * @param serie serie
         * @param sec seccion
         * @param tipcomb tipo de comb
         * @param clave clave del la comb
         * @param Aux Validacion
         * @return Consultas para Archivado
         */
        public static int insertarComb(	String codigo, String seccion,
    											String fecha, String Usr,String sub,String serie, String sec, String tipcomb ,String clave, String Aux)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaComb(clave,Aux);
    			////System.out.println("validaComb:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strSql = SQLExpArchivado.insertarComb(codigo, seccion, fecha, Usr, sub, serie, sec,tipcomb,clave);
                ////System.out.println("insertarComb"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaCombinacion(Usr,clave);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarComb:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Verifica si se modifican las combinaciones
         * @param id id combinacion
         * @return Consulta String[][]
         */
        public static int verifComb(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.verifComb(id);
    			////System.out.println("verifComb:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("verifComb:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Verifica si se modifican los Expedientes
         * @param id id expediente
         * @return Consulta String[][]
         */

        public static int getValidaExpedienteArch(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaExpedienteArch(id);
    			////System.out.println("getValidaExpedienteArch:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaExpedienteArch:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }
        /**
         * Verifica si se modifican los tipos de cedula
         * @param id id cedula
         * @return Consulta String[][]
         */
        public static int getValidaCedula(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaCedula(id);
    			////System.out.println("getValidaCedula:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaCedula:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }        
        /**
         * Verifica si se modifican los Clasificacion
         * @param id id clasif
         * @return Consulta String[][]
         */
        public static int getValidaClasificacion(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaClasificacion(id);
    			////System.out.println("getValidaClasificacion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaClasificacion:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }   
        /**
         * Verifica si se modifican los Clasificacion Subserie
         * @param id id serie
         * @return Consulta String[][]
         */
        public static int getValidaClasificacionsub(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaClasificacionsub(id);
    			////System.out.println("getValidaClasificacionsub:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaClasificacionsub:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }          
        /**
         * Verifica si se modifican las clasificaciones de la informacion
         * @param id id clasif
         * @return Consulta String[][]
         */
        public static int getValidaClasifInfo(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaClasifInfo(id);
    			////System.out.println("getValidaClasifInfo:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaClasifInfo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }        
        /**
         * Verifica si se modifican las selecciones
         * @param id id seleccion
         * @return Consulta String[][]
         */
        public static int getValidaSeleccion(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaSeleccion(id);
    			////System.out.println("getValidaSeleccion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaSeleccion:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }        
        /**
         * Verifica si se modifican las valoraciones
         * @param id id valor
         * @return Consulta String[][]
         */
        public static int getValidaValoraciones(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaValoraciones(id);
    			////System.out.println("getValidaValoraciones:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaValoraciones:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }        
        /**
         * Verifica si se modifican los Valores
         * @param id id valor
         * @return Consulta String[][]
         */
        public static int getValidaValor(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaValor(id);
    			////System.out.println("getValidaValor:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaValor:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }        
        /**
         * Verifica si se modifican los Subserie
         * @param id Consulta String[][]
         * @return Consulta String[][]
         */
        public static int getValidaSubserie(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaSubserie(id);
    			////System.out.println("getValidaSubserie:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaSubserie:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }        
        /**
         * Verifica si se modifican las Secciones
         * @param id id valor
         * @return Consulta String[][]
         */
        public static int getValidaSeccion(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaSeccion(id);
    			////System.out.println("getValidaSeccion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaSeccion:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }         
        /**
         * Verifica si se modifican las series
         * @param id id valor
         * @return Consulta String[][]
         */
        public static int getValidaSerie(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaSerie(id);
    			////System.out.println("getValidaSerie:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaSerie:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }        
        /**
         * Verifica si se modifican los subfondos
         * @param id id valor
         * @return Consulta String[][]
         */
        public static int getValidaSubfondo(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaSubfondo(id);
    			////System.out.println("getValidaSubfondo:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaSubfondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }         
        /**
         * Verifica si se modifican los Fondos
         * @param id id de fondo
         * @return Consulta String[][]
         */
        public static int getValidaFondo(String id)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.getValidaFondo(id);
    			////System.out.println("getValidaFondo:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
           }
            catch (SQLException sqle)
            {
                //System.out.println("getValidaFondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }         
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Clasificacion Serie
         * @param codigo Nombre de Serie
         * @param seccion Descripcion del Serie
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param serie Identificador de la Valoracion
         * @param sec Identificador de la Seccion
         * @param strFechaAT Numero de Años de Tramite
         * @param strFechaAC Numero de Años de Concentracion
         * @param strAnosSISI Muestra si es consultado por SISI
         * @param strFechaTotal Numero de Años totales
         * @param rerv Numero de Años reservados
         * @param obvser Observaciones
         * @param strConf Si es confidencial
         * @param clv Clave
         * @param idfn Identificador Fondo
         * @param idsubfn Identificador SubFondo
         * @param idsec Identificador seccion
         * @param idser Identificador serie
         * @param idsubsr dentificador Subserie
         * @param Aux Clave para Validacion   
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarClasif(	String codigo, String seccion,
    											String fecha, String Usr,String serie, String sec,
    											String strFechaAT,String strFechaAC,String strFechaTotal,
    											String strAnosSISI,String strConf, String clv, String rerv,
    											String idfn, String idsubfn, String idsec, String idser,
    											String idsubsr, String obvser, String Aux)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaClasificacion(idsec,clv,Aux);
    			////System.out.println("validaClasificacion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			////System.out.println("Paso2");
                String strSql = SQLExpArchivado.insertarClasif(codigo, seccion, fecha, Usr, serie, sec,strFechaAT,
                        										strFechaAC,strFechaTotal,strAnosSISI,strConf,
                        										clv,rerv, idfn, idsubfn, idsec, idser, idsubsr, obvser);
                ////System.out.println("insertarComb"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaICDD(Usr,clv,codigo,seccion,idfn,idsubfn,idsec);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarComb:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Clasificacion SubSerie
         * @param codigo Nombre de SubSerie
         * @param seccion Descripcion del SubSerie
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param serie Identificador de la Valoracion
         * @param sec Identificador de la Seccion
         * @param strFechaAT Numero de Años de Tramite
         * @param strFechaAC Numero de Años de Concentracion
         * @param strAnosSISI Muestra si es consultado por SISI
         * @param strFechaTotal Numero de Años totales
         * @param rerv Numero de Años reservados
         * @param obvser Observaciones
         * @param strConf Si es confidencial
         * @param clv Clave
         * @param idfn Identificador Fondo
         * @param idsubfn Identificador SubFondo
         * @param idsec Identificador seccion
         * @param idser Identificador serie
         * @param idsubsr dentificador Subserie
         * @param Aux Clave para Validacion   
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarClasifsub(	String codigo, String seccion,
    											String fecha, String Usr,String serie, String sec,
    											String strFechaAT,String strFechaAC,String strFechaTotal,
    											String strAnosSISI,String strConf, String clv, String rerv,
    											String idfn, String idsubfn, String idsec, String idser,
    											String idsubsr, String obvser, String Aux)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaClasificacionsub(idser,clv,Aux);
    			////System.out.println("validaClasificacion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			////System.out.println("Paso2");
                String strSql = SQLExpArchivado.insertarClasifsub(codigo, seccion, fecha, Usr, serie, sec,strFechaAT,
                        										strFechaAC,strFechaTotal,strAnosSISI,strConf,
                        										clv,rerv, idfn, idsubfn, idsec, idser, idsubsr, obvser);
                ////System.out.println("insertarClasifsub"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaICDDsub(Usr,clv,codigo,seccion,idfn,idsubfn,idsec,idser);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarComb:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }         
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Clasificacion Serie
         * @param codigo Nombre de Serie
         * @param seccion Descripcion del SubSerie
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clv Clave
         * @param idSecc Identificador seccion
         * @param Aux Clave para Validacion   
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarSerie(	String codigo, String seccion,
    											String fecha, String Usr, String clv, String Aux,String idSecc)
        {
            int r = 0;
            try
            {
                String str = SQLExpArchivado.validaSerie(clv,Aux);
    			////System.out.println("validaSerie:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strSql = SQLExpArchivado.insertarSerie(codigo, seccion, fecha, Usr, clv,idSecc);
                ////System.out.println("insertarFondo"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaSerie(Usr,clv);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarFondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de INSTRUCCIONES
         * @param idInst Identificador Instruccion
         * @param idExp Identificador Expediente
         * @return Consultas para Archivado
         */
        public static int insertarExpInstruccion(	String idInst, String idExp)
        {
            int r = 0;
            try
            {
                String desc = null;
                String str = SQLExpArchivado.getDescExp(idExp);
    			////System.out.println("getDescExp:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if (strval!=null && strval.length>0){
    				desc = strval[0][0];
    			}else{
    				desc = "";
    			}
                String strSql = SQLExpArchivado.insertaExpInst(idInst,idExp, desc);
                ////System.out.println("insertaExpInst"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
               // boolean bBitacora = ActualizaBitacora.InsertarEventoAltaSerie(Usr,clv);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarFondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }         
        
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Asuntos
         * @param strIdAsunto Id asunto
         * @param idExp	Id expediente
         * @return Consultas para Archivado
         */
        public static int insertarExpAsunto(String strIdAsunto, String idExp)
        {
            int r = 0;
            try
            {
                String desc = null;
                String str = SQLExpArchivado.getDescExp(idExp);
    			////System.out.println("getDescExp:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if (strval!=null && strval.length>0){
    				desc = strval[0][0];
    			}else{
    				desc = "";
    			}
    			
                String strSql = SQLExpArchivado.insertaExpAsunto(strIdAsunto,idExp, desc);
                ////System.out.println("insertarExpAsunto"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
               // boolean bBitacora = ActualizaBitacora.InsertarEventoAltaSerie(Usr,clv);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarExpAsunto:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }         
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de Clasificacion de Informacion
         * @param codigo Nombre de la Clasificacion de Informacion
         * @param seccion Descripcion de la Clasificacion de Informacion
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clv Clave
         * @param Aux Clave para Validacion   
         * @return Numero entero :Indica la validez del registro
         */
        public static int insertarClasifInf(	String codigo, String seccion,
    											String fecha, String Usr, String clv, String Aux)
        {
            int r = 0;
            try
            {
                
                String str = SQLExpArchivado.validaClasifInf(clv,Aux);
    			////System.out.println("validaClasifInf:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strSql = SQLExpArchivado.insertarClasifInf(codigo, seccion, fecha, Usr, clv);
                ////System.out.println("insertarFondo"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaCDI(Usr,clv,codigo,seccion);
            }
            catch (SQLException sqle)
            {
                //System.out.println("insertarFondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        } 
        /**
         * Función que ejecuta un query, donde muestra los datos de subfondo
         * @param strOrden
         * @param tipo
         * @return Consulta String[][]
         */
        public static String[][] getDatosSubFondo(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSubFondo(strOrden, tipo);
    			////System.out.println("getDatosSubFondo:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSubFondo:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra los datos de subfondo
         * @param strOrden
         * @param tipo
         * @return Consulta String[][]
         */
        public static String[][] getDatosSubFondoA(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSubFondoA(strOrden, tipo);
    			////System.out.println("getDatosSubFondo:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSubFondo:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra los datos de Valoracion
         * @param strOrden
         * @param tipo
         * @return Consulta String[][]
         */       
        public static String[][] getDatosValoracion(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosValoracion(strOrden, tipo);
    			////System.out.println("getDatosValoracion:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosValoracion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        
        /**
         * Función que ejecuta un query, donde muestra Fecha del servidor
         * @return Consulta String[][]
         */
        public static String[][] getDate()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDate();
    			////System.out.println("getDate:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDate:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        } 
        
        /**
         * Función que ejecuta un query, donde muestra Datos del Cuadro de disposicion
         * @param idsec
         * @param area
         * @return Consulta String[][]
         */
        public static String[][] getDatosSeccionIcdd(String idsec, String area)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSeccionIcdd(idsec,area);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSeccionIcdd:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }     
        /**
         * Función que ejecuta un query, donde muestra Datos de serie  del Cuadro de disposicion
         * @param idsec Id Seccion
         * @param idsecS Id Serie
         * @return Consulta String[][]
         */
        public static String[][] getDatosSeccionIcddIds(String idsec, String idsecS)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSeccionIcddIds(idsec,idsecS);
    			////System.out.println("getDatosSeccionIcddIds:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSeccionIcddIds:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de serie  del Cuadro de disposicion
         * @param idsec Id Seccion
         * @param idsecS Id Serie
         * @return String[][]
         */
        public static String[][] getDatosSeccionIcddIds2(String idsec, String idsecS)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSeccionIcddIds2(idsec,idsecS);
    			////System.out.println("getDatosSeccionIcddIds2:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSeccionIcddIds2:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        
        /**
         * Función que ejecuta un query, donde muestra Datos del Cuadro de disposicion por seccion
         * @param idsec Id Seccion
         * @param area
         * @return String[][]
         */
        public static String[][] getDatosSeccionIcddSub(String idsec, String area)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSeccionIcddSub(idsec, area);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSeccionIcddSub:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        } 
        /**
         * Función que ejecuta un query, donde muestra Datos de subSerie  del Cuadro de disposicion
         * @param idsec Id Seccion
         * @param idsecS Id subSerie
         * @return String[][]
         */
        public static String[][] getDatosSeccionIcddSubIds(String idsec, String idsecS)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSeccionIcddSubIds(idsec,idsecS);
    			////System.out.println("getDatosSeccionIcddSubIds:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSeccionIcddSubIds:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }  
        /**
         * Función que ejecuta un query, donde muestra Datos de subSerie  del Cuadro de disposicion
         * @param idsec Id Seccion
         * @param idsecS Id subSerie
         * @return String[][]
         */
        public static String[][] getDatosSeccionIcddSubIds2(String idsec, String idsecS)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSeccionIcddSubIds2(idsec, idsecS);
    			////System.out.println("getDatosSeccionIcddSubIds2:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSeccionIcddSubIds2:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }  
        /**
         * Función que ejecuta un query, donde muestra Datos Valoracion
         * @param val1 Id Seccion
         * @param val2 Id subSerie
         * @param val3 Id subSerie
         * @return String[][]
         */
        public static String[][] getDatosValores(String val1, String val2, String val3)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosValores(val1, val2, val3);
    			////System.out.println("getDatosValores:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosValores:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos Valoracion
         * @param val1 Id Seccion
         * @param val2 Id subSerie
         * @param val3 Id subSerie
         * @return String[][]
         */
        public static String[][] getDatosValores2(String val1, String val2, String val3)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosValores2(val1, val2, val3);
    			////System.out.println("getDatosValores:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosValores:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de Valor
         * @return String[][]
         */
        public static String[][] getDatosTodoValor()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosTodoValor();
    			////System.out.println("getDatosValores:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosValores:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de secciones
         * @param strOrden orden 
         * @param tipo Tipo
         * @return Consulta String[][]
         */
        public static String[][] getDatosSeccion(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSeccion(strOrden, tipo);
    			////System.out.println("getDatosSubFondo:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSubFondo:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de Series
         * @param strOrden
         * @param tipo
         * @return Consulta String[][]
         */
        public static String[][] getDatosSubSerieA(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSubSerieA(strOrden, tipo);
    			////System.out.println("getDatosSubserie:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSubserie:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de Expedientes
         * @param strOrden ordenamiento
         * @param tipo tipo de orden
         * @return Query 
         */     
        public static String[][] getDatosExpediente(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosXpediente(strOrden, tipo);
    			////System.out.println("getDatosXpediente:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosXpediente:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         *  Función que ejecuta un query, donde muestra Datos de Valor
         * @param strOrden ordenamiento
         * @param tipo tipo de orden
         * @return Consulta String[][]
         */    
        public static String[][] getDatosValor(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosValor(strOrden, tipo);
    			////System.out.println("getDatosValor:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosValor:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de Cedulas Tipo
         * @param strOrden ordenamiento
         * @param tipo tipo de orden
         * @return Consulta String[][]
         */
        public static String[][] getDatosTipoCedula(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosTipoCedula(strOrden, tipo);
    			////System.out.println("getDatosValor:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosValor:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de Selecciones
         * @param strOrden
         * @param tipo
         * @return Consulta String[][]
         */
        public static String[][] getDatosSeleccion(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSeleccion(strOrden, tipo);
    			////System.out.println("getDatosSubserie:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSubserie:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de Fondo
         * @param strOrden
         * @param tipo
         * @return Query
         */
        public static String[][] getDatosFondo(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosFondo(strOrden, tipo);
    			////System.out.println("getDatosSubserie:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSubserie:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de Cuadro de Disposicion
         * @param strOrden
         * @param tipo
         * @return Consulta String[][]
         */
        public static String[][] getDatosicddview(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosicddview(strOrden, tipo);
    			////System.out.println("getDatosicddview:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosicddview:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de Combinaciones
         * @param strOrden ordenamiento
         * @param tipo tipo de orden
         * @return Consulta String[][]
         */
        
        public static String[][] getDatosCombinacion(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosCombinacion(strOrden, tipo);
    			////System.out.println("getDatosCombinacion:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosCombinacion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de Serie
         * @param strOrden ordenamiento
         * @param tipo tipo de orden
         * @return Consultas para Archivado
         */
        public static String[][] getDatosClasificacion(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosClasificacion(strOrden, tipo);
    			////System.out.println("getDatosClasificacion:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosClasificacion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         *  Función que ejecuta un query, donde muestra Datos de SubSerie
         * @param strOrden
         * @param tipo tipo de orden
         * @return Consultas para Archivado
         */
        public static String[][] getDatosClasificacionsub(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosClasificacionsub(strOrden, tipo);
    			////System.out.println("getDatosClasificacion:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosClasificacion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }  
        /**
         * Función que ejecuta un query, donde muestra Datos de Serie Detallado
         * @param tipo tipo de orden
         * @return Consultas para Archivado
         */
        public static String[][] getDatosClasificacionDeta(String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosClasificacionDeta(tipo);
    			////System.out.println("getDatosCombinacion:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosCombinacion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de subSerie
         * @param tipo tipo de orden
         * @return Consultas para Archivado
         */
        public static String[][] getDatosClasificacionDetasub(String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosClasificacionDetasub(tipo);
    			////System.out.println("getDatosClasificacionDetasub:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosClasificacionDetasub:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         *  Función que ejecuta un query, donde muestra Datos Cedulas Tipoo
         * @param tipo tipo de orden
         * @return Consultas para Archivado
         */
        public static String[][] getDatosCedulaDeta(String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosCedulaDeta(tipo);
    			////System.out.println("getDatosCombinacion:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosCombinacion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        
        /**
         *  Función que ejecuta un query, donde muestra Datos del Detalle de expedientes
         * @param tipo tipo de orden
         * @return Consultas para Archivado
         */   
        public static String[][] getDatosDetalle(String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosDetalle(tipo);
    			////System.out.println("getDatosDetalle:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosDetalle:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }  
        /**
         * Función que ejecuta un query, donde muestra Datos del Detalle de las Claves generadas
         * @param tipo tipo de orden
         * @return Consultas para Archivado
         */  
        public static String[][] getDatosCedulaClave(String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosCedulaClave(tipo);
    			////System.out.println("getDatosCedulaClave:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosCedulaClave:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos Cedulas
         * @param tipo tipo de orden
         * @return Consultas para Archivado
         */   
        public static String[][] getDatosCedulaClave2(String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosCedulaClave2(tipo);
    			////System.out.println("getDatosCedulaClave2:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosCedulaClave2:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }  
        /**
         * Función que ejecuta un query, donde muestra Datos de los valores genrados
         * @param tipo tipo de orden
         * @return Consulta String[][]
         */ 
        public static String[][] getDatosValorDeta(String tipo)//Emmanuel
        {
            try
    		{
                String strsql = SQLExpArchivado.getDatosValorDeta(tipo);
    			////System.out.println("getDatosValorDeta:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);

    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosValorDeta:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de los valores genrados
         * @param tipo tipo de orden
         * @return Consulta String[][]
         */         
        public static String[][] getDatosValorDeta2(String tipo)
        {
            try
    		{

    			    String strsql = SQLExpArchivado.getDatosValor2Deta(tipo);
    			    ////System.out.println("getDatosValorDeta2:"+strsql);
    			    return ConexionDS.ejecutarSQL(strsql);
    			
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosValorDeta:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de Años acumulados para expedientes
         * @param id id de expediente
         * @return Consultas para Archivado
         */        
        public static String[][] getDatosExpAcom(String id)
        {
            try
    		{
                String strsql = SQLExpArchivado.getDatosExpAcom(id);
    			////System.out.println("getDatosValorAcom:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);

    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosValorAcom:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }    
        /**
         *  Función que ejecuta un query, donde muestra Datos de combinaciones
         * @param tipo tipo de orden
         * @return Consultas para Archivado
         */
        public static String[][] getDatosCombiDeta(String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosCombiDeta(tipo);
    			////System.out.println("getDatosCombiDeta:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosCombiDeta:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos de seires
         * @param strOrden ordenamiento
         * @param tipo tipo de orden
         * @return Consulta String[][]
         */          
        public static String[][] getDatosSerie(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getDatosSerie(strOrden, tipo);
    			////System.out.println("getDatosSerie:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSubserie:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra Datos Clasificaciones de informacion
         * @param strOrden
         * @param tipo
         * @return Consultas para Archivado
         */   
        public static String[][] getDatosClasiInf(String strOrden, String tipo)
        {
            try
    		{
    			String strsql = SQLExpArchivado.getClasifInf(strOrden, tipo);
    			////System.out.println("getDatosSerie:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getDatosSubserie:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra si exiten Datos de seires
         * @return String[][]
         */   
        public static boolean getExisteSub()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteSub();
    			////System.out.println("getExisteSub:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteSub:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra si exiten Datos de subseires
         * @return String[][]
         */
        public static boolean getExisteSubS()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteSubS();
    			////System.out.println("getExisteSub:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteSub:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla expedientes
         * @return True
         */
        public static boolean getExisteExped()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteExped();
    			////System.out.println("getExisteExped:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteExped:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla cedulas tipo
         * @return True
         */
        public static boolean getExisteCed()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteCed();
    			////System.out.println("getExisteCed:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteCed:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla clasificaciones
         * @return True
         */
        public static boolean getExisteCls()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteCls();
    			////System.out.println("getExisteCls:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteCls:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        } 
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla subseries
         * @return True
         */
        public static boolean getExisteClssub()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteClssub();
    			////System.out.println("getExisteClssub:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteCls:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }         
        /**
         * Función que ejectua un query, donde verifica si tiene datos la clasificacion de la informacion
         * @return True
         */
        public static boolean getExisteClsInf()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteClsInf();
    			////System.out.println("getExisteClsInf:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteClsInf:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
     
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla selecciones
         * @return True
         */
        public static boolean getExisteSeleccion()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteSeleccion();
    			////System.out.println("getExisteSeleccion:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteSeleccion:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla de Valor
         * @return True
         */
        public static boolean getExisteValor()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteValor();
    			////System.out.println("getExisteValor:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteValor:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla Combinaciones
         * @return True
         */
        public static boolean getExisteComb()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteComb();
    			////System.out.println("getExisteComb:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteComb:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla Valoraciones
         * @return True
         */
        public static boolean getExisteValoracion()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteValoracion();
    			////System.out.println("getExisteValoracion:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteValoracion:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla Subseries
         * @return True
         */
        public static boolean getExisteSubSer()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteSubSer();
    			////System.out.println("getExisteSubSer:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteSubSer:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla series
         * @return True
         */
        public static boolean getExisteSerie()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteSerie();
    			////System.out.println("getExisteSerie:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteSerie:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla fondos
         * @return True
         */
        public static boolean getExisteFon()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteFon();
    			////System.out.println("getExisteFon:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteFon:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla cuadro de disposicion
         * @return True
         */
        public static boolean getExisteIcdd()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteIcdd();
    			////System.out.println("getExisteIcdd:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteIcdd:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejectua un query, donde verifica si tiene datos la tabla secciones
         * @return True
         */
        public static boolean getExisteSeccion()
        {
            try
    		{
    			String strsql = SQLExpArchivado.getExisteSeccion();
    			////System.out.println("getExisteSeccion:"+strsql);
    			String strClasificacion[][] = ConexionDS.ejecutarSQL(strsql); 
    			if(strClasificacion.length > 0)
    			    return true;
    			
    			////System.out.println("="+false);
    			return false;
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getExisteSeccion:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}
        }
        /**
         * Función que ejecuta un query, donde muestra los datos de un SubFondos
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Subfondo
         * @return String[][]    ---------
         */       
        
        public static String[][] getSubfondoA(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getSubfondoA(strIdSub);
    			////System.out.println("getSubfondo:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getSubfondo:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de un SubFondos
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Subfondo
         * @return String[][]
         */
        public static String[][] getSubfondo(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getSubfondo(strIdSub);
    			////System.out.println("getSubfondo:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getSubfondo:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}
        /**
         * Función que ejecuta un query, donde actualiza datos a la 
         * tabla de Subfondo Archivado
         * @param soloDesc solo guarda descripcion
         * @param codigo Nombre del Subfondo
         * @param seccion Descripcion del Subfondo
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clv Clave del Subfondo
         * @param fondo id de fondo
         * @param IdSubfondo id subfondo
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo
         * @param Aux Clave para Validacion   
         * @param Aux2 Clave para Validacion 
         * @return Consultas para Archivado
         */
        public static int actualizaSubfondoA(String soloDesc,String codigo, String seccion,
    											String fecha, String Usr,String fondo, String IdSubfondo, String clv,
    											String fecInac,String JusInac ,String inac, String Aux, String Aux2 )
        {		
            int r=0;
            try
            {
            	String datosAnt[][] = getSubfondoA(IdSubfondo);
                String str = SQLExpArchivado.validaSubfondo(clv, fondo, Aux, Aux2);
    			////System.out.println("validaSubfondo:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strsql = SQLExpArchivado.actualizaSubfondoA(soloDesc, codigo, seccion,
    											fecha, Usr, fondo, IdSubfondo,clv, fecInac, JusInac,inac);
                ////System.out.println("actualizaSubfondo:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioSubFondo(Usr,clv,fondo,IdSubfondo,datosAnt);
           }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSubfondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza datos a la 
         * tabla de Valoracion Archivado
         * @param soloDesc solo guarda descripcion
         * @param codigo nombre
         * @param seccion descripcion
         * @param fecha fecha
         * @param Usr usuario
         * @param IdSubfondo Id Subfondo
         * @param Val1 Valor 1
         * @param Val2 Valor 2
         * @param Val3 Valor 3
         * @param clv Clave
         * @param fecInac Fecha Inictivo
         * @param JusInac Justificacion
         * @param inac Inactivo
         * @param Aux Clave para Validacion 
         * @return Consultas para Archivado
         */
        public static int actualizaValoracion(String soloDes, String codigo, String seccion,
    											String fecha, String Usr, String IdSubfondo,String Val1[],String Val2,String Val3, String clv,
    											String fecInac,String JusInac ,String inac,String Aux)
        {		
            int r=0;
            try
            {
                String str = SQLExpArchivado.validaValoracion(clv,Aux);
    			////System.out.println("validaValoracion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 } 
    			String[][] datosPrevios = getValoracion(IdSubfondo);
                String strsql = SQLExpArchivado.actualizaValoracion(soloDes, codigo, seccion,
    											fecha, Usr,  IdSubfondo, Val1, Val2, Val3,clv, fecInac, JusInac,inac);
                ////System.out.println("actualizaSubfondo:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioValoracion(Usr,clv,IdSubfondo, datosPrevios);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSubfondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza datos a la 
         * tabla de Icdd Archivado
         * @param fecha Fecha en la que se actualiza el registro
         * @param ser Identificadores de la series
         * @param subs Identificadores de la Subseries
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo  
         * @param IdSubfondo id del ICDD
         * @return Numero entero :Indica la validez del registro
         */
        public static int actualizaIcdd(String ser[], String subs[],
										String fecha, String IdSubfondo,String fecInac,
										String JusInac ,String inac, String Usr)
        {		
            int r=0;
            try
            {
            	String datosAnt[][] = getIcddId(IdSubfondo);
                String strsql = SQLExpArchivado.actualizaIcdd( ser,  subs, fecha,  IdSubfondo, fecInac, JusInac , inac);
                ////System.out.println("actualizaIcdd:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioICDDUnidad(Usr,IdSubfondo,datosAnt);
            }
            catch(SQLException sqle)
            {
                ////System.out.println("actualizaIcdd:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }        
        /**
         * Función que ejecuta un query, donde inserta datos a la 
         * tabla de SD_SUBFONDO
         * @param codigo nombre
         * @param seccion descripcion
         * @param fecha fecha de actualizacion
         * @param Usr usuario
         * @param fondo id de fondo
         * @param clv clave
         * @param Aux Clave para Validacion
         * @param Aux2 Clave para Validacion2
         * @return Consultas para Archivado
         */
        public static int insertarSubfondoA(	String codigo, String seccion,
    											String fecha, String Usr, String fondo,String clv, String Aux, String Aux2)
        {
            int r = 0;
            try
            {
          /*      String clv_sub2 = "";
                int clv_sub = Integer.parseInt(clv) -1;
                if(clv_sub<10)
                	{
                    clv_sub2 = "0" + clv_sub;
                	}
                
                String strv = SQLExpArchivado.validaSubfondov(clv_sub2);
                //System.out.println("validaSubfondov:"+clv_sub2);
                String strvalv[][] = ConexionDS.ejecutarSQL(strv);
                if(strvalv!=null && strvalv.lengt>0)
				{
                    //System.out.println("Valido subfondo");
				 }else
				 {
				     return 2;
				     }*/
                
                String str = SQLExpArchivado.validaSubfondo(clv, fondo, Aux, Aux2);
    			////System.out.println("validaSubfondo:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strSql = SQLExpArchivado.insertarSubfondoA(codigo, seccion, fecha, Usr, fondo, clv);
                ////System.out.println("InsertarArchivado"+strSql);
                r = ConexionDS.ejecutarActualizacion(strSql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoAltaSubFondo(Usr,clv,fondo);
            }
            catch (SQLException sqle)
            {
                //System.out.println("InsertaAsunto:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }
            return 0;
        }
        
        /**
         * Función que ejecuta un query, donde muestra los datos de una Valoracion
         * dependiendo de su ID
         * @param strIdSub Contiene el ID de la Valoracion
         * @return String[][]
         */
        public static String[][] getValoracion(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getValoracion(strIdSub);
    			////System.out.println("getValoracion:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getValoracion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de una Valoracion
         * dependiendo de su IDs de valores
         * @param val1 Id Valor1 
         * @param val2 Id Valor2
         * @param val3 Id Valor3
         * @return Consultas para Archivado
         */
        public static String[][] getExiteValoracion(String val1, String val2, String val3)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getExiteValoracion(val1,val2,val3);
    			////System.out.println("getExiteValoracion:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getExiteValoracion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de una Seccion
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Seccion
         * @return String[][]
         */
        public static String[][] getSeccion(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getSeccion(strIdSub);
    			////System.out.println("getSeccion:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getSeccion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de un Icdd
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Icdd
         * @return String[][]
         */
        public static String[][] getIcddId(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getIcddId(strIdSub);
    			////System.out.println("getIcddId:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getIcddId:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}         
        /**
         * Función que ejecuta un query, donde muestra los datos de una Subserie
         * dependiendo de su ID
         * @param strIdSub Contiene el ID de una Subserie
         * @return String[][]
         */
        public static String[][] getSubSerie(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getSubserie(strIdSub);
    			////System.out.println("getSubserie:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getSubserie:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de un Expediente
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Expediente
         * @return String[][]
         */
        public static String[][] getExpedienteArch(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getExpedienteArch(strIdSub);
    			////System.out.println("getExpedienteArch:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getExpedienteArch:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}
        /**
         * Función que ejecuta un query, donde muestra los datos de un Expediente
         * dependiendo de su ID
         * @param strIdSub Contiene la clave del Expediente
         * @return String[][]
         */
        public static String[][] getExpedienteID(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getExpedienteID(strIdSub);
    			////System.out.println("getExpedienteID:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getExpedienteID:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}
        
        /**
         * Función que ejecuta un query, donde muestra los datos de una vigencia de Expedientes
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Expediente
         * @return String[][]
         */
        public static String[][] getExpedienteAtAc(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getExpedienteAtAc(strIdSub);
    			////System.out.println("getExpedienteArch:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getExpedienteArch:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
       
        /**
         * Función que ejecuta un query, donde muestra los datos cosecitivo de expediente
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del expediente
         * @param anio Año actual
         * @return Consultas para Archivado
         */
        public static String[][] getExpedienteConsec(String strIdSub, String anio)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getExpedienteConsec(strIdSub,anio);
    			////System.out.println("getExpedienteConsec:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getExpedienteConsec:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de un Valor
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Valor
         * @return String[][]
         */
        public static String[][] getValor(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getValor(strIdSub);
    			////System.out.println("getValor:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getValor:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de un Tipo de Cedula
         * dependiendo de su ID
         * @param strIdSub Contiene el ID de un Tipo de Cedula
         * @return String[][]
         */
        public static String[][] getTipCed(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getTipCed(strIdSub);
    			////System.out.println("getTipCed:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getTipCed:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de series de una  Cedula
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Traer Series
         * @return String[][]
         */
        public static String[][] getTipCedSer(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getTipCedSer(strIdSub);
    			////System.out.println("getTipCedSer:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getTipCedSer:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de series de una  Cedula
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Traer Subseries
         * @return String[][]
         */        
        public static String[][] getTipCedSubSer(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getTipCedSubSer(strIdSub);
    			////System.out.println("getTipCedSubSer:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getTipCedSubSer:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de un Selecccion
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Selecccion
         * @return String[][]
         */
        public static String[][] getSubSelecccion(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getSubseleccion(strIdSub);
    			////System.out.println("getSubfondo:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getSubfondo:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de un Fondo
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Fondo
         * @return String[][]
         */
        public static String[][] getFondo(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getfondo(strIdSub);
    			////System.out.println("getfondo:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getSubfondo:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}
        /**
         * Función que ejecuta un query, donde muestra los datos de una Combinacion
         * dependiendo de su ID
         * @param strIdSub Contiene el ID de  Combinacion
         * @return String[][]
         */
        public static String[][] getCombinacion(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getcombinacion(strIdSub);
    			////System.out.println("getfondo:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getSubfondo:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}
        /**
         * Función que ejecuta un query, donde muestra los datos de un Fondo
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Fondo
         * @return String[][]
         */
        public static String[][] getCargafon(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getCargafon(strIdSub);
    			////System.out.println("getCargafon:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getCargafon:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}        
        /**
         * Función que ejecuta un query, donde muestra los datos de un SubFondo
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del SubFondo
         * @return String[][]
         */
        public static String[][] getCargasubfon(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getCargasubfon(strIdSub);
    			////System.out.println("getfogetCargasubfondo:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getCargasubfon:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}  
        /**
         * Función que ejecuta un query, donde muestra los datos de un seccion
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del seccion
         * @return String[][]
         */       
        public static String[][] getCargasec(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getCargasec(strIdSub);
    			////System.out.println("getCargasec:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getCargasec:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}  
        /**
         * Función que ejecuta un query, donde muestra los datos de un serie
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del serie
         * @return String[][]
         */        
        public static String[][] getCargaser(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getCargaser(strIdSub);
    			////System.out.println("getCargaser:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getCargaser:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de un Subserie
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Subserie
         * @return String[][]
         */         
        public static String[][] getCargasubser(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getCargasubser(strIdSub);
    			////System.out.println("getCargasubser:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getCargasubser:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}          
        /**
         * Función que ejecuta un query, donde muestra los datos de un Clasificacion
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Clasificacion
         * @return String[][]
         */
        public static String[][] getClasificacion(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getclasificacion(strIdSub);
    			////System.out.println("getclasificacion:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getclasificacion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}
        /**
         * Función que ejecuta un query, donde muestra los datos de una Clasificacion de subserie
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del subserie
         * @return String[][]
         */
        public static String[][] getClasificacionsub(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getclasificacionsub(strIdSub);
    			////System.out.println("getclasificacionsub:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getclasificacionsub:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de un Clasificacion de una valoracion
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del subserie
         * @return String[][]
         */
        public static String[][] getValClasificacionsub(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getValclasificacionsub(strIdSub);
    			////System.out.println("getValclasificacionsub:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getValclasificacionsub:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
        /**
         * Función que ejecuta un query, donde muestra los datos de un Expediente
         * dependiendo de su ID
         * @param strIdSub id del expediente
         * @return String[][]
         */
        public static String[][] getValExpediente(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getValExpediente(strIdSub);
    			////System.out.println("getValExpediente:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getValExpediente:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}         
        /**
         * Función que ejecuta un query, donde muestra los datos de un Serie
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del Serie
         * @return String[][]
         */
        public static String[][] getSerie(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getserie(strIdSub);
    			////System.out.println("getserie:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getserie:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}
        /**
         * Función que ejecuta un query, donde muestra los datos de una Clasifincacion de la informacion
         * dependiendo de su ID
         * @param strIdSub Contiene el ID del una Clasifincacion de la informacion
         * @return String[][]
         */
        public static String[][] getClasifInf(String strIdSub)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getClasifInf(strIdSub);
    			////System.out.println("getClasifInf:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getClasifInf:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}
        /**
         * Función que ejecuta un query, donde muestra los datos de Expediente con Instruccion
         * @param strId Contiene el ID del Expediente
         * @return String[][]
         */
        public static String[][] getExpedienteInst(String strId)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getExpedienteInst(strId);
    			////System.out.println("getExpedienteInst:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getExpedienteInst:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}        
        /**
         * Función que ejecuta un query, donde muestra los datos de Expediente con Instruccion
         * @param strId Contiene el ID del Expediente
         * @return String[][]
         */
        public static String[][] getExpedienteAsunto(String strId)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getExpedienteAsunto(strId);
    			////System.out.println("getExpedienteAsunto:"+strsql);
    			return ConexionDS.ejecutarSQL(strsql);
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getExpedienteAsunto:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	}        
        /**
         * Función que ejecuta un query donde se hace un borrado logico de un subfondo
         * @param strIds Contiene los id de los subfondos a borrar
         * @return True
         */
        public static boolean getDeleteSub(String strIds[])
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return false;
    		
    		try
    		{
    			String strsql = SQLExpArchivado.getDeleteSub(strIds);
    			////System.out.println("getDeleteSub:"+strsql); 
    			r= ConexionDS.ejecutarActualizacion(strsql);		
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSub:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}						
    		return (r>0);
    	}
        /**
         * Función que ejecuta un query donde se hace un borrado logico de un subfondo
         * @param strIds Contiene los id de los subfondos a borrar
         * @return True
         */
        public static boolean getDeleteSubA(String strIds[])
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return false;
    		
    		try
    		{
    			String strsql = SQLExpArchivado.getDeleteSubA(strIds);
    			////System.out.println("getDeleteSub:"+strsql); 
    			r= ConexionDS.ejecutarActualizacion(strsql);		
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSub:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}						
    		return (r>0);
    	}   
        /**
         * Función que ejecuta un query donde se hace un borrado logico de una Seccion
         * @param strIds Contiene los id de los Secciones a borrar
         * @return True
         */
        public static int getDeleteSeccion(String strIds[], String IdUser)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraSeccion(strIds);
    			////System.out.println("validaBorraSeccion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				}
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteSeccion(strIds[i]);
        			////System.out.println("getDeleteSeccion:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.
											InsertarEventoEliminarSeccionArch(IdUser,getSeccion(strIds[i])[0][4],strIds[i],
																				getSeccion(strIds[i])[0][0], 
																				getSeccion(strIds[i])[0][1]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSeccion:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}  
        
        /**
         * Función que ejecuta un query donde se hace un borrado logico de un SubFondo
         * @param strIds Contiene los id de los subfondos a borrar
         * @param idUsuario usuario que lo realiza
         * @return Consulta String[][]
         */
        public static int getDeleteSubFon(String strIds[], String idUsuario)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraSubFondo(strIds);
    			////System.out.println("validaBorraSubFondo:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteSubFond(strIds[i]);
        			////System.out.println("getDeleteSub:"+strsql); 
   			        boolean bBitacora = ActualizaBitacora.InsertarEventoEliminarSubFondo(idUsuario,getSubfondoA(strIds[i])[0][5],getSubfondoA(strIds[i])[0][4],strIds[i]);
   	    			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}

    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSub:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	} 
        
        /**
         * Función que ejecuta un query donde se hace un borrado logico de una valoracion
         * @param strIds Contiene los id de las valoraciones a borrar
         * @param Usr Id de usuario que lo realiza
         * @return True
         */
        public static int getDeleteValoracion(String strIds[], String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraValoracion(strIds);
    			////System.out.println("validaBorraValoracion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
    				String strsql = SQLExpArchivado.getDeleteValoracion(strIds[i]);
        			////System.out.println("getDeleteValoracion:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.
												InsertarEventoEliminarValoracion(Usr,getValoracion(strIds[i])[0][7],
														strIds[i], getValoracion(strIds[i])[0][0],
														getValoracion(strIds[i])[0][1]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteValoracion:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}
        /**
         * Función que ejecuta un query donde se hace un borrado logico de una SUBSERIE
         * @param strIds Contiene los id de los SUBSERIES a borrar
         * @return True
         */
        public static boolean getDeleteSubSA(String strIds[])
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return false;
    		
    		try
    		{
    			String strsql = SQLExpArchivado.getDeleteSubSA(strIds);
    			////System.out.println("getDeleteSubSA:"+strsql); 
    			r= ConexionDS.ejecutarActualizacion(strsql);		
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSubSA:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return false;
    		}						
    		return (r>0);
    	}        
        /**
         * Función que ejecuta un query donde se hace un borrado logico de un valor
         * @param strIds Contiene los id de los valores a borrar
         * @param Usr Id de usuario que lo realiza
         * @return True
         */
        public static int getDeleteValor(String strIds[], String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraValor(strIds);
    			////System.out.println("validaBorraValor:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteValor(strIds[i]);
        			////System.out.println("getDeleteValor:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.
											InsertarEventoEliminarValore(Usr,getValor(strIds[i])[0][4],strIds[i],
																		getValor(strIds[i])[0][0], getValor(strIds[i])[0][1]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteValor:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}        
        
        /**
         * Función que ejecuta un query donde se hace un borrado logico de una Cedula
         * @param strIds Contiene los id de las Cedulas a borrar
         * @param Usr Id de usuario que lo realiza
         * @return True
         */
        public static int getDeleteTipCed(String strIds[], String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraCedula(strIds);
    			////System.out.println("validaBorraCedula:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteTipCed(strIds[i]);
        			////System.out.println("getDeleteTipCed:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.InsertarEventoEliminarCedTipo(Usr,getTipCed(strIds[i])[0][4],getTipCed(strIds[i])[0][5],strIds[i]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteTipCed:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}  
        /**
         * Función que ejecuta un query donde se hace un borrado logico de una Seleccion
         * @param strIds Contiene los id de las Selecciones a borrar
         * @param Usr Id de usuario que lo realiza
         * @return True
         */
        public static int getDeleteSeleccion(String strIds[], String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraSeleccion(strIds);
    			////System.out.println("getDeleteSeleccion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteSeleccion(strIds[i]);
        			////System.out.println("getDeleteSeleccion:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.
												InsertarEventoEliminarSeleccion(Usr,getSubSelecccion(strIds[i])[0][4],strIds[i], 
																				getSubSelecccion(strIds[i])[0][0],
																				getSubSelecccion(strIds[i])[0][1]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSeleccion:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}         
        /**
         * Función que ejecuta un query donde se hace un borrado logico de la serie
         * @param strIds Contiene los id de las series a borrar
         * @param Usr Id de usuario que lo realiza
         * @return True
         */
        public static int getDeleteSer(String strIds[], String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraSubserie(strIds);
    			////System.out.println("validaBorraSubserie:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			
    			for (int i=0; i<strIds.length; i++){
    				String strsql = SQLExpArchivado.getDeleteSubSer(strIds[i]);
        			////System.out.println("getDeleteSubSer:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.InsertarEventoEliminarSubSerie(Usr,getSubSerie(strIds[i])[0][5],getSubSerie(strIds[i])[0][4],strIds[i]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSubSer:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}
        /**
         * Función que ejecuta un query donde se hace un borrado logico de un expediente
         * @param strIds Contiene los id de los expedientes a borrar
         * @param Usr Id de usuario que lo realiza
         * @return True
         */
        public static int  getDeleteExp(String strIds[], String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    		    return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraExp(strIds);
    			////System.out.println("validaBorraExp:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteSubExp(strIds[i]);
        			////System.out.println("getDeleteSubExp:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.
											InsertarEventoEliminarExpe(Usr,getExpedienteArch(strIds[i])[0][4],
																		getExpedienteArch(strIds[i])[0][0],
																		getExpedienteArch(strIds[i])[0][2],
																		strIds[i]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSubExp:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}
        
        /** getDeleteSer
         * Función que ejecuta un query donde se hace un borrado logico de un fondo
         * @param strIds Contiene los id de los fondos a borrar
         * @param idUsuario Id de usuario que lo realiza
         * @return True
         */
        public static int getDeleteFondo(String strIds[], String idUsuario)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraFondo(strIds);
    			////System.out.println("validaBorraFondo:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteFondo(strIds[i]);
        			////System.out.println("getDeleteFondo:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.
											InsertarEventoEliminarFondo(idUsuario,getFondo(strIds[i])[0][4],strIds[i],
																		getFondo(strIds[i])[0][0],
																		getFondo(strIds[i])[0][1]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteFondo:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	} 
        /** getDeleteSer
         * Función que ejecuta un query donde se hace un borrado logico de una clasificacion de Serie
         * @param strIds Contiene los id de las clasificaciones a borrar
         * @param Usr Id de usuario que lo realiza
         * @return True
         */
        public static int getDeleteCls(String strIds[], String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraCls(strIds);
    			////System.out.println("validaBorraCls:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteCls(strIds[i]);
        			////System.out.println("getDeleteCls:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.
												InsertarEventoEliminarICDD(Usr,getClasificacion(strIds[i])[0][14],strIds[i],
														getClasificacion(strIds[i])[0][0],
														getClasificacion(strIds[i])[0][1]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		    				
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteCls:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	} 
        /** getDeleteSer
         * Función que ejecuta un query donde se hace un borrado logico Icdd
         * @param strIds Contiene los id de los Icdds a borrar
         * @param idUsuario Id de usuario que lo realiza
         * @return True
         */
        public static int getDeleteIcddd(String strIds[], String idUsuario)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraIcdd(strIds);
    			////System.out.println("validaBorraIcdd:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteIcdd(strIds[i]);
        			////System.out.println("getDeleteIcdd:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.InsertarEventoEliminarICDDUnidad(idUsuario,strIds[i],
        														getIcddId(strIds[i])[0][0],
																getIcddId(strIds[i])[0][1],
																getIcddId(strIds[i])[0][5]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSub:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}         
        /** getDeleteSer
         * Función que ejecuta un query donde se hace un borrado logico de una clasificacion de SubSerie
         * @param strIds Contiene los id de las clasificaciones a borrar
         * @param Usr Id de usuario que lo realiza
         * @return True
         */
        public static int getDeleteClssub(String strIds[], String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraClssub(strIds);
    			////System.out.println("validaBorraClssub:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteClssub(strIds[i]);
        			////System.out.println("getDeleteClssub:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.
													InsertarEventoEliminarICDDSub(Usr,getClasificacionsub(strIds[i])[0][11],strIds[i],
															getClasificacionsub(strIds[i])[0][0],
															getClasificacionsub(strIds[i])[0][1]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		    				
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteCls:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}         
        /**
         * Función que ejecuta un query donde se hace un borrado logico de una Combinacion
         * @param strIds Contiene los id de las combinaciones a borrar
         * @param Usr Id de usuario que lo realiza
         * @return True
         */
        
        public static int getDeleteComb(String strIds[], String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraComb(strIds);
    			////System.out.println("validaBorraComb:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String str2 = SQLExpArchivado.validaBorraComb2(strIds);
    			////System.out.println("validaBorraComb:"+str2);
    			String strval2[][] = ConexionDS.ejecutarSQL(str2);
    			if(strval2!=null && strval2.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
    				String strsql = SQLExpArchivado.getDeleteComb(strIds[i]);
    				////System.out.println("getDeleteSub:"+strsql); 
    				boolean bBitacora = ActualizaBitacora.InsertarEventoEliminarCombinacion(Usr,getCombinacion(strIds[i])[0][8],strIds[i]);
    				r= ConexionDS.ejecutarActualizacion(strsql);
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSub:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	} 
        /**
         *  Borrado de serie
         * @param strIds id serie
         * @param Usr usuario
         * @return Consulta String[][]
         */
        public static int getDeleteSerie(String strIds[],String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraSerie(strIds);
    			////System.out.println("validaBorraSerie:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteSerie(strIds[i]);
        			////System.out.println("getDeleteSub:"+strsql); 
                    boolean bBitacora = ActualizaBitacora.InsertarEventoEliminarSerie(Usr,getSerie(strIds[i])[0][4],strIds[i]);
                    r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteSub:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}
        /**
         * Función que ejecuta un query donde se hace un borrado logico de Clasificaciones de la informacion
         * @param strIds Contiene los id de las Clasificaciones a borrar
         * @param Usr Id de usuario que lo realiza
         * @return True
         */
        public static int getDeleteClasifInf(String strIds[], String Usr)
    	{
    		int r=0;
    		if(strIds==null || strIds.length<0)
    			return 0;
    		
    		try
    		{
                String str = SQLExpArchivado.validaBorraClasifInf(strIds);
    			////System.out.println("validaBorraClasifInf:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			for (int i=0; i<strIds.length; i++){
        			String strsql = SQLExpArchivado.getDeleteClasifInf(strIds[i]);
        			////System.out.println("getDeleteClasifInf:"+strsql); 
        			boolean bBitacora = ActualizaBitacora.
													InsertarEventoEliminarCDI(Usr,getClasifInf(strIds[i])[0][4],strIds[i],
																				getClasifInf(strIds[i])[0][0],
																				getClasifInf(strIds[i])[0][1]);
        			r= ConexionDS.ejecutarActualizacion(strsql);		
    			}
    		}
    		catch(SQLException sqle)
    		{
    				//System.out.println("getDeleteClasifInf:"+sqle.getMessage());
    				sqle.printStackTrace();
    				return 0;
    		}						
    		return 0;
    	}
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de Subfondo
         * @param codigo codigo del subfondo
         * @param seccion Sección del subfondo
         * @param fecha fecha en la que se actualiza
         * @param Usr Usuario que actualiza
         * @param IdSubfondo Id del registro
         * @return Consultas para Archivado
         */
        public static boolean actualizaSubfondo(String codigo, String seccion,
    											String fecha, String Usr, String IdSubfondo)
        {		
            int r=0;
            try
            {
                String strsql = SQLExpArchivado.actualizaSubfondo(codigo, seccion,
    											fecha, Usr, IdSubfondo);
                ////System.out.println("actualizaSubfondo:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSubfondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return false;
            }	
            return (r>0);
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de Subfondo
         * @param codigo codigo del subfondo
         * @param seccion Sección del subfondo
         * @param fecha fecha en la que se actualiza
         * @param Usr Usuario que actualiza
         * @param IdSubfondo Id del registro
         * @return Consultas para Archivado
         */
        public static boolean actualizaSubfondoA(String codigo, String seccion,
    											String fecha, String Usr, String IdSubfondo)
        {		
            int r=0;
            try
            {
                String strsql = SQLExpArchivado.actualizaSubfondoA(codigo, seccion,
    											fecha, Usr, IdSubfondo);
                ////System.out.println("actualizaSubfondo:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSubfondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return false;
            }	
            return (r>0);
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de seccion
         * @param soloDesc solo guarda descripcion
         * @param codigo nombre del seccion
         * @param seccion descripcion de seccion del seccion
         * @param fecha fecha en la que se actualiza
         * @param Usr Usuario que actualiza
         * @param IdSubfondo Id del registro
         * @param clave Clave del Registro 
         * @param Aux Clave para Validacion  
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo
         * @return Numero entero :Indica la validez del registro
         */
        public static int actualizaSeccion(String soloDesc, String codigo, String seccion,
    											String fecha, String Usr, String IdSubfondo,String clave,
    											String fecInac,String JusInac ,String inac,String Aux)
        {		
            int r=0;
            try
            {
            /*    String str = SQLExpArchivado.validaSeccion(clave,Aux);
    			//System.out.println("validaClasificacion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }*/
            	String datosAnt[][] = getSeccion(IdSubfondo);
                String strsql = SQLExpArchivado.actualizaSeccion(soloDesc, codigo, seccion,
    											fecha, Usr, IdSubfondo, clave, fecInac, JusInac,inac);
                ////System.out.println("actualizaSubfondo:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioSeccionArch(	Usr,clave,IdSubfondo,datosAnt);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSubfondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de seccion
         * @param codigo nombre del seccion
         * @param seccion descripcion de seccion del seccion
         * @param fecha fecha en la que se actualiza
         * @param Usr Usuario que actualiza
         * @param serie Id de serie
         * @param IdSubfondo Id del registro
         * @param clv Clave del Registro 
         * @param Aux Clave para Validacion
         * @param Aux2 Clave para Validacion
         * @return Numero entero :Indica la validez del registro
         */
        public static int actualizaSubSerie(String codigo, String seccion,
    											String fecha, String Usr,String serie, String IdSubfondo, 
												String clv, String Aux, String Aux2)
        {		
            int r=0;
            try
            {
                String str = SQLExpArchivado.validaSubserie(clv,serie,Aux,Aux2);
    			////System.out.println("validaSubserie:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strsql = SQLExpArchivado.actualizaSubserie(codigo, seccion,
    											fecha, Usr, serie, IdSubfondo,clv);
                ////System.out.println("actualizaSubfondo:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioSubSerie(Usr,clv,serie,IdSubfondo);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSubfondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de Expedientes
         * @param soloDesc solo guarda descripcion
         * @param EXP_CVE_UA Clave Identificador del Area
         * @param EXP_AREA_DESC Descripcion del Area
         * @param EXP_CED_TIPO Identificador de Cedula tipo
         * @param EXP_CLAVE Clave del Expediente
         * @param EXP_INTERNO Descrpcion Interna
         * @param EXP_UBICACION Ubicacion Topografica
         * @param EXP_DENOMINACION Nombre del Expediente
         * @param EXP_DESCRIPCION Descripcion
         * @param EXP_VALORACION Identificador de la Valoracion
         * @param EXP_FEC_CIERRE Fecha de Cierre
         * @param EXP_ANO_AT Numero de Años de Tramite
         * @param EXP_ANO_AC Numero de Años de Concentracion
         * @param EXP_SISI_DISP Muestra si es consultado por SISI
         * @param EXP_ANIOS_TOTAL_DISP Usuario que actualizo
         * @param EXP_CVE_CLASF_INF Identificador de la clsificacion informativa
         * @param EXP_MOTIVO Motivo del Expediente
         * @param EXP_FUNDAMENTO Fundamentos para expediente
         * @param EXP_OBSERVA Observaciones
         * @param EXP_ANO_RESERV Numero de Años reservados
         * @param EXP_ANO_REAL Numero de Años reales de vigencia
         * @param EXP_SISI_CLS Muestra si es consultado por SISI
         * @param EXP_ANIOS_TOTAL_CLS Numero Total de Años por clasificacion
         * @param EXP_ANIOS_AMPLI Numero de Años a ampliar
         * @param EXP_FEC_AMPLI Fecha en q se aplica una ampliacion
         * @param EXP_ANIOS_GUARDA Numero de Años de guarda
         * @param EXP_USUARIO Id de Usuario q guarda
         * @param EXP_FEC_APERTURA Fecha de apertura del Expediente
         * @param EXP_UB_FISICA Dirección Fisica del Expediente
         * @param IdSubfondo Id del registro
         * @param Aux Clave para Validacion   
         * @param Aux2 Clave para Validacion 
         * @param Aux3 Clave para Validacion 
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo
         * @return Numero entero :Indica la validez del registro
         */
        public static int actualizaExpediente(String soloDesc, String EXP_CVE_UA,String EXP_AREA_DESC, String EXP_CED_TIPO , 
							                String EXP_CLAVE,String EXP_INTERNO,String EXP_UBICACION ,
							                String EXP_DENOMINACION  , String EXP_DESCRIPCION  ,String EXP_VALORACION , String EXP_FEC_CIERRE ,
							                String EXP_ANO_AT ,String EXP_ANO_AC,String EXP_SISI_DISP, String EXP_ANIOS_TOTAL_DISP,String EXP_CVE_CLASF_INF , 
							                String EXP_MOTIVO , String EXP_FUNDAMENTO ,String EXP_OBSERVA ,String EXP_ANO_RESERV ,String EXP_ANO_REAL,
							                String EXP_SISI_CLS, String EXP_ANIOS_TOTAL_CLS,String EXP_ANIOS_AMPLI , String EXP_FEC_AMPLI , 
							                String EXP_ANIOS_GUARDA, String EXP_USUARIO,String EXP_FEC_APERTURA,String EXP_UB_FISICA,String EXP_ANIOS_REDUC, String IdSubfondo,   		    								
							                String fecInac,String JusInac ,String inac, String Aux, String Aux2, String Aux3)
        {		
            int r=0;
            try
            {
            	String datoAnt[][] = getExpedienteArch(IdSubfondo);
                String str = SQLExpArchivado.validaExpd(EXP_CLAVE,EXP_CVE_UA,EXP_CED_TIPO,Aux,Aux2,Aux3);
    			////System.out.println("validaClasificacion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strsql = SQLExpArchivado.actualizaExpediente( soloDesc,EXP_AREA_DESC,  EXP_CED_TIPO , 
		                 EXP_CLAVE, EXP_INTERNO, EXP_UBICACION , EXP_DENOMINACION  , 
		                 EXP_DESCRIPCION  , EXP_VALORACION ,  EXP_FEC_CIERRE ,
		                 EXP_ANO_AT , EXP_ANO_AC, EXP_SISI_DISP,  EXP_ANIOS_TOTAL_DISP, EXP_CVE_CLASF_INF , 
		                 EXP_MOTIVO ,  EXP_FUNDAMENTO , EXP_OBSERVA , EXP_ANO_RESERV , EXP_ANO_REAL,
		                 EXP_SISI_CLS,  EXP_ANIOS_TOTAL_CLS, EXP_ANIOS_AMPLI ,  EXP_FEC_AMPLI , 
		                 EXP_ANIOS_GUARDA,  EXP_USUARIO, EXP_FEC_APERTURA, EXP_UB_FISICA, EXP_ANIOS_REDUC, IdSubfondo, fecInac, JusInac,inac);
                ////System.out.println("actualizaSubserie:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                
               /* String strsqld = SQLExpArchivado.actualizaDetalle(IdSubfondo,EXP_ANO_RESERV,EXP_ANIOS_AMPLI,EXP_ANIOS_REDUC,EXP_USUARIO);
                //System.out.println("actualizaDetalle:"+strsqld);
                r=ConexionDS.ejecutarActualizacion(strsqld);*/
                
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioExpe(EXP_USUARIO,EXP_CLAVE,EXP_CVE_UA,EXP_CED_TIPO,IdSubfondo, datoAnt);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSubserie:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0 ;
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de Expedientes referente al acomulado
         * @param Opera Oprecion realizada
         * @param stracom acomulado total
         * @param usu Usuario que actualiza
         * @param IdSubfondo Id del registro
         * @param EXP_ANO_REAL Numero de Años reales de vigencia
         * @param EXP_ANIOS_TOTAL_CLS Numero Total de Años por clasificacion
         * @param EXP_ANIOS_AMPLI Numero de Años a ampliar
         * @param EXP_ANIOS_GUARDA Numero de Años de guarda
         * @return Numero entero :Indica la validez del registro
         */
        public static int actualizaExpedienteAcom(String EXP_ANO_REAL,
                String EXP_ANIOS_TOTAL_CLS, String EXP_ANIOS_AMPLI ,  String EXP_ANIOS_GUARDA,
                String  IdSubfondo, String usu, String stracom, String Opera )
        {		
            int r=0;
            try
            {

                String strsql = SQLExpArchivado.actualizaExpedienteAcom(  EXP_ANO_REAL,
		                 EXP_ANIOS_TOTAL_CLS, EXP_ANIOS_AMPLI , 
		                 EXP_ANIOS_GUARDA,  IdSubfondo);
                ////System.out.println("actualizaSubserie:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                
                String strsqld = SQLExpArchivado.actualizaDetalle(IdSubfondo,EXP_ANO_REAL,stracom,EXP_ANIOS_TOTAL_CLS,usu,Opera);
                ////System.out.println("actualizaDetalle:"+strsqld);
                r=ConexionDS.ejecutarActualizacion(strsqld);
                

            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSubserie:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0 ;
        }        
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de Valores
         * @param soloDesc solo guarda descripcion
         * @param codigo nombre del Valor
         * @param seccion descripcion de seccion del Valor
         * @param fecha fecha en la que se actualiza
         * @param Usr Usuario que actualiza
         * @param IdSubfondo Id del registro
         * @param clave Clave del Registro 
         * @param Aux Clave para Validacion
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo
         * @return Numero entero :Indica la validez del registro
         */
        public static int actualizaValor(String soloDes, String codigo, String seccion,
    											String fecha, String Usr, String IdSubfondo,String clave,
    											String fecInac,String JusInac ,String inac,String Aux)
        {		
            int r=0;
            try
            {
                String str = SQLExpArchivado.validaValor(clave,Aux);
    			////System.out.println("validaValor:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    			String datosPrevios[][] = getValor(IdSubfondo);
                String strsql = SQLExpArchivado.actualizaValor(soloDes, codigo, seccion,
    											fecha, Usr, IdSubfondo,clave, fecInac, JusInac,inac);
                ////System.out.println("actualizaValor:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioValore(Usr,clave,IdSubfondo, datosPrevios);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaValor:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de una cedula
         * @param soloDesc solo guarda descripcion
         * @param codigo Nombre de la Cedula Tipo
         * @param seccion Descripcion de la Cedula Tipo
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param IdSubfondo Id del subfondo
         * @param clv clave de la Cedula Tipo
         * @param area Identificador de Unidad Administrativa
         * @param comb Identificador de la Combinacion Generada
         * @param strMotivo Descripcion del motivo de la cedula
         * @param strFunda  Descripcion del fundamiento de la cedula
         * @param strSubserie Identificador de la Subserie
         * @param strSerie Identificador de la Serie
         * @param Aux Clave para Validacion 
         * @param Aux2 Clave para Validacion 
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo
         * @return Numero entero :Indica la validez del registro
         */
        public static int actualizaTipCed(String soloDesc, String codigo, String seccion,
    											String fecha, String Usr, String IdSubfondo, String clv, String area, String comb, String Aux, String Aux2,
    											String strMotivo, String strFunda, String strSubserie, String strSerie,
    											String fecInac,String JusInac ,String inac)
        {		
            int r=0;
            try
            {

                String str = SQLExpArchivado.validaCedula(clv,area,Aux,Aux2);
    			////System.out.println("validaCedula:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strsql = SQLExpArchivado.actualizaTipCed(soloDesc, codigo, seccion,
    											fecha, Usr, IdSubfondo,clv,area,comb,strMotivo,strFunda,strSubserie,strSerie, fecInac, JusInac,inac);
                ////System.out.println("actualizaTipCed:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                

                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioCedTipo(Usr,clv,area,IdSubfondo);

            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaTipCed:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de seleccion
         * @param soloDesc solo guarda descripcion
         * @param codigo Nombre de la Seleccion
         * @param seccion Descripcion de la Seleccion
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clv clave de la Cedula Tipo
         * @param Aux Clave para Validacion 
         * @param IdSubfondo Id del registro
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo
         * @return Numero entero :Indica la validez del registro
         */
        public static int actualizaSeleccion(String soloDesc, String codigo, String seccion,
    											String fecha, String Usr, String IdSubfondo, String clv,
    											String fecInac,String JusInac ,String inac,String Aux)
        {		
            int r=0;
            try
            {
            	String[][] datosAnteriores = getSubSelecccion(IdSubfondo);
                String str = SQLExpArchivado.validaSelect(clv, Aux);
    			////System.out.println("validaSelect:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strsql = SQLExpArchivado.actualizaSeleccion(soloDesc,codigo, seccion,
    											fecha, Usr, IdSubfondo,clv, fecInac, JusInac,inac);
                ////System.out.println("actualizaSeleccion:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioSeleccion(Usr,clv,IdSubfondo,datosAnteriores);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSeleccion:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de fondos
         * @param soloDesc solo guarda descripcion
         * @param codigo Nombre de la fondo
         * @param seccion Descripcion de la fondo
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clave clave del Fondo
         * @param strAux Clave para Validacion 
         * @param sisi numero de Años en sisi
         * @param id Id del registro
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo
         * @return Numero entero :Indica la validez del registro
         */
        public static int actualizaFondo(String soloDesc, String codigo, String seccion,
    											String fecha, String Usr, String id ,String clave,String  sisi,
    											String fecInac,String JusInac ,String inac,String strAux)
        {		
            int r=0;
            try
            {
            	String datosAnt[][] = getFondo(id);
                if (soloDesc!="1" && !soloDesc.equalsIgnoreCase("1"))
    	        {
                clave = clave.toUpperCase();
                String str = SQLExpArchivado.validaFondo(clave, strAux);
    			////System.out.println("validaFondo:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
    	        }
                String strsql = SQLExpArchivado.actualizaFondo(soloDesc, codigo, seccion,
    											fecha, Usr, id, clave, sisi, fecInac, JusInac,inac);
                ////System.out.println("actualizaSubfondo:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
    			boolean bBitacora = ActualizaBitacora.InsertarEventoCambioFondo(Usr, clave, id, datosAnt);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSubfondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de combinacion
         * @param codigo codigo del combinacion
         * @param seccion Sección del combinacion
         * @param fecha fecha en la que se actualizaf
         * @param Usr Usuario que actualiza
         * @param IdSubfondo Id del registro
         * @param idserie Id serie
         * @param idsec Id seccion
         * @param tipcomb tipo de combinacion
         * @param clave Clave de la combinacion
         * @param Aux Clave para Validacion 
         * @return Consultas para Archivado
         */
        public static int actualizaComb(String codigo, String seccion,
    											String fecha, String Usr, String IdSubfondo,String idserie, String idsec, String id,String tipcomb ,String clave, String Aux)
        {		
            int r=0;
            try
            {
                String str = SQLExpArchivado.validaComb(clave,Aux);
    			////System.out.println("validaComb:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }

                String strsql = SQLExpArchivado.actualizaComb(codigo, seccion,
    											fecha, Usr, IdSubfondo,idserie,idsec,id,tipcomb,clave);
                ////System.out.println("actualizaComb:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioCombinacion(Usr,clave,id);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaComb:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de Serie
         * @param soloDesc solo guarda descripcion
         * @param codigo Nombre de Serie
         * @param seccion Descripcion del Serie
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param idserie Identificador de la Valoracion
         * @param secp2 Identificador de la Seccion
         * @param idsec Identificador de la seleccion
         * @param strFechaAT Numero de Años de Tramite
         * @param strFechaAC Numero de Años de Concentracion
         * @param strAnosSISI Muestra si es consultado por SISI
         * @param strFechaTotal Numero de Años totales
         * @param rerv Numero de Años reservados
         * @param obv Observaciones
         * @param strConf Si es confidencial
         * @param clv Clave
         * @param Aux Clave para Validacion  
         * @param id Id del registro
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo
         * @return Consultas para Archivado
         */
        public static int actualizaClasificacion(String soloDesc, String codigo, String seccion,
    											String fecha, String Usr,String idserie, String idsec, 
    											String strFechaAT, String strFechaAC, String strFechaTotal,
    											String strAnosSISI, String strConf,String id, String clv, 
    											String fecInac,String JusInac ,String inac, String rerv, String obv, String Aux,String secp2)
        {		
            int r=0;
            try
            {
            	String datosAnt[][] = getClasificacion(id);
                String str = SQLExpArchivado.validaClasificacion(secp2,clv,Aux);
    			////System.out.println("validaClasificacion:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }
                String strsql = SQLExpArchivado.actualizaClasif(soloDesc, codigo, seccion,
    											fecha, Usr, idserie,idsec,
    											strFechaAT,strFechaAC,strFechaTotal,strAnosSISI,strConf,id,clv
    											,fecInac, JusInac,inac, rerv,obv);
                ////System.out.println("actualizaClasif:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioICDD(Usr,clv,id, datosAnt);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaClasif:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de SubSerie
         * @param soloDesc solo guarda descripcion
         * @param codigo Nombre de Serie
         * @param seccion Descripcion del Serie
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param idserie Identificador de la Valoracion
         * @param idser Identificador de la Serie
         * @param idsec Identificador de la seleccion
         * @param strFechaAT Numero de Años de Tramite
         * @param strFechaAC Numero de Años de Concentracion
         * @param strAnosSISI Muestra si es consultado por SISI
         * @param strFechaTotal Numero de Años totales
         * @param rerv Numero de Años reservados
         * @param obv Observaciones
         * @param strConf Si es confidencial
         * @param clv Clave
         * @param Aux Clave para Validacion  
         * @param id Id del registro
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo
         * @return Numero entero :Indica la validez del registro
         */
        
        public static int actualizaClasificacionsub(String soloDesc, String codigo, String seccion,
				String fecha, String Usr,String idserie, String idsec, 
				String strFechaAT, String strFechaAC, String strFechaTotal,
				String strAnosSISI, String strConf,String id, String clv, 
				String fecInac,String JusInac ,String inac, String rerv, String obv, String idser,String Aux)
					{		
					int r=0;
					try
					{
					String datosAnt[][] = getClasificacionsub(id);
					String str = SQLExpArchivado.validaClasificacionsub(idser,clv,Aux);
					////System.out.println("validaClasificacion:"+str);
					String strval[][] = ConexionDS.ejecutarSQL(str);
					if(strval!=null && strval.length>0)
					{
					return 2;
					}
					String strsql = SQLExpArchivado.actualizaClasifsub(soloDesc, codigo, seccion,
									fecha, Usr, idserie,idsec,
									strFechaAT,strFechaAC,strFechaTotal,strAnosSISI,strConf,id,clv
									,fecInac, JusInac,inac, rerv,obv);
					////System.out.println("actualizaClasif:"+strsql);
					r=ConexionDS.ejecutarActualizacion(strsql);
					boolean bBitacora = ActualizaBitacora.InsertarEventoCambioICDDSub(Usr,clv,id,datosAnt);
					}
					catch(SQLException sqle)
					{
					//System.out.println("actualizaClasif:"+sqle.getMessage());
					sqle.printStackTrace();
					return 0;
					}	
					return 0;
					}

        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de serie
         * @param codigo codigo del serie
         * @param seccion Sección del serie
         * @param fecha fecha en la que se actualiza
         * @param Usr Usuario que actualiza
         * @param id Id del registro
         * @param Aux Clave para Validacion  
         * @param clv Clave
         * @return Numero entero :Indica la validez del registro
         */
        public static int actualizaSerie(String codigo, String seccion,
    											String fecha, String Usr, String id, String clv, String Aux)
        {		
            int r=0;
            try
            {
                String str = SQLExpArchivado.validaSerie(clv,Aux);
    			////System.out.println("validaSerie:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }

                String strsql = SQLExpArchivado.actualizaSerie(codigo, seccion,
    											fecha, Usr, id,clv);
                ////System.out.println("actualizaSubfondo:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioSerie(Usr,clv,id);
            }
            catch(SQLException sqle)
            {
                //System.out.println("actualizaSubfondo:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        /**
         * Función que ejecuta un query, donde actualiza los datos de la 
         * tabla de Clasificacion de la Informacion
         * @param soloDesc solo guarda descripcion
         * @param codigo Nombre de la Clasificacion
         * @param seccion Descripcion de la Clasificacion
         * @param fecha Fecha en la que se actualiza el registro
         * @param Usr Usuario que actualizo
         * @param clv clave de la Clasificacion
         * @param Aux Clave para Validacion 
         * @param id Id del registro
         * @param fecInac Fecha de de inactivo
         * @param JusInac Descripcion de Inactivo
         * @param inac Status de Inactivo
         * @return Numero entero :Indica la validez del registro
         */
        public static int  actualizaClasifInf(String soloDesc, String codigo, String seccion,
    											String fecha, String Usr, String id, String clv,
    											String fecInac,String JusInac ,String inac,String Aux)
        {		
            int r=0;
            try
            {
            	String datosAnt[][] = getClasifInf(id);
                String str = SQLExpArchivado.validaClasifInf(clv,Aux);
    			////System.out.println("validaClasifInf:"+str);
    			String strval[][] = ConexionDS.ejecutarSQL(str);
    			if(strval!=null && strval.length>0)
    				{
    				    return 2;
    				 }

                String strsql = SQLExpArchivado.actualizaClasifInf(soloDesc, codigo, seccion,
    											fecha, Usr, id,clv, fecInac, JusInac,inac);
                ////System.out.println("actualizaClasifInf:"+strsql);
                r=ConexionDS.ejecutarActualizacion(strsql);
                boolean bBitacora = ActualizaBitacora.InsertarEventoCambioCDI(Usr,clv,id,datosAnt);
            }
            catch(SQLException sqle)
            {
                
                //System.out.println("actualizaClasifInf:"+sqle.getMessage());
                sqle.printStackTrace();
                return 0;
            }	
            return 0;
        }
        
        /**
         * Nombre de la Sección
         * @param idSeccion Id Sección
         * @return Nombre Sección
         */
        public static String getICDDUnidadSeccion(String idSeccion)
    	{	
    		try
    		{
    			String strsql = SQLExpArchivado.getICDDUnidadSeccion(idSeccion);
    			String[][] dato = ConexionDS.ejecutarSQL(strsql);
    			if(dato!=null && dato.length>0)
    				return dato[0][0];
    			return "";
    		}
    		catch(SQLException sqle)
    		{
    			//System.out.println("getICDDUnidadSeccion:"+sqle.getMessage());
    			sqle.printStackTrace();
    			return null;
    		}						
    	} 
    }
