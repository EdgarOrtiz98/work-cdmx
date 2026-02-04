/*
 * Clase:						CiudadanoBean.java
 * 
 * Paquete:						com.meve.sigma.beans		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Jan 5, 2006
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		
 */

package com.meve.sigma.beans;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import com.meve.sigma.actualiza.ActualizaCiudadano;
import com.meve.sigma.util.SenderMail;

/**
 * Bean que almacena los datos de un ciudadano
 * 
 * @author Meve Soluciones SA de CV
 */
public class CiudadanoBean {
    
	/**
	 * Método qeu guarda los datos de un ciudadano a la base de datos
	 * @param request	Request form
	 * @param Smail		Servidor mail
	 * @param PMail		Puerto salida mail
	 * @param SN		Nombre servidor
	 * @return	0 guardado, -1 usuario existente, -2 no coincide password
	 */
    public synchronized int guardarCiudadano(HttpServletRequest request, String Smail, String PMail, String SN){
        
        int GUARDADO = 0;
        int USUARIO_EXISTENTE = -1;
        int PASSWORD_NO_COINCIDE = -2;
        boolean bExisteUsuario = false;
        
        String strFN			=	"";
        String strNombre 		= 	request.getParameter("reg_nombre");
        String strApePaterno 	= 	request.getParameter("reg_apellidoP");
        String strApeMaterno 	= 	request.getParameter("reg_apellidoM");
        String strDia			=	request.getParameter("reg_dia");
        String strMes			=	request.getParameter("reg_mes");
        String strYear			=	request.getParameter("reg_year");
        String strSexo			=	request.getParameter("reg_sexo");
        String strOcupacion		=	request.getParameter("reg_ocupacion");
        String strDomicilio		=	request.getParameter("reg_domicilio");
        String strPais			=	request.getParameter("reg_pais");
        String strEstado		=	request.getParameter("reg_estado");
        String strMunicipio		=	request.getParameter("reg_municipio");
        //String strMunicipio1		=	request.getParameter("reg_municipio1");
        String strTelefono		=	request.getParameter("reg_telefono");
        String strMail			=	request.getParameter("reg_mail");
        String strUsuario		=	request.getParameter("reg_usuario");
        String strPassword		=	request.getParameter("reg_con1");
        String strCPassword		=	request.getParameter("reg_con2");
        String strSector		=	request.getParameter("reg_sector");
        String strMun			=	"";
        
        if(strDomicilio == null && strDomicilio.length() == 0)
            strDomicilio = "null";
        if(strTelefono == null && strTelefono.length() == 0)
            strTelefono = "null";
        
        if(strDia.equals("-1") && strMes.equals("-1") && strYear.equals("-1")){
        	strFN = "null";
        }
        else{
            if(strDia.length()==1){
                strDia = "0"+strDia;
                strFN	=	strDia+"/"+strMes+"/"+strYear;
            }else{
                strFN	=	strDia+"/"+strMes+"/"+strYear;
            }
        }
        
        if(strSexo.equals("-1"))
        	strSexo = "null";
        //if(strOcupacion.length()==0)
        if(strOcupacion.equals("-1"))
        	strOcupacion = "null";
        if(strPais.equals("-1"))
        	strPais = "null";
        if(strEstado.equals("-1"))
        	strEstado = "null";
        if(strMail.length()==0)
        	strMail = "null";
        if(strSector.equals("-1"))
        	strSector = "null";
        
        
        if(strApePaterno.length() == 0)
            strApePaterno = "";
        if(strApeMaterno.length() == 0)
            strApeMaterno = "";
        
        if(strMunicipio.length() == 0){
        	strMun = "";
        }
        else{
            strMun = strMunicipio;
        }
        bExisteUsuario = ActualizaCiudadano.getExisteUsuario(strUsuario);
        if(bExisteUsuario){
            //String[] strDatos1 = {"1"};
            return USUARIO_EXISTENTE;
            //return strDatos1;
        }else if(!strPassword.equals(strCPassword)){
            String[] strDatos2 = {"2"};
            //strDatos[0] = "2";
            return PASSWORD_NO_COINCIDE;
            //return strDatos2;
        }else{
            
            boolean bnsertar = ActualizaCiudadano.insertaCiudadano(strNombre, strApePaterno, strApeMaterno, 
                    									strFN, strSexo, strOcupacion, strDomicilio, strPais, 
                    									strEstado, strMun, strTelefono, strMail, 
                    									strUsuario, strPassword, strSector);
            
            String strUltimoId = ActualizaCiudadano.getUltimoIdCiudadano();
            try{
            GUARDADO = Integer.parseInt(strUltimoId);
            }catch(NumberFormatException nfe){
                //System.err.println("CiudadanoBean.java ----> guardarCiudadano() ----> NumberFormatException: " + nfe.toString());
            }
            if(strMail.equals("null")){
            	//System.out.println("no envia mail");
            }else{
            	////System.err.println("envia mail");
            	SenderMail send = new SenderMail();
            	try{
            		send.sendConfirmacionCiudadano(strNombre, strMail, strUsuario, strPassword, SN,request.getContextPath(),request.getSession().getServletContext());
            	}catch(MessagingException me){
            		//System.err.println("Mensaje="+me.getMessage());
            	}catch(UnsupportedEncodingException uee){
            		//System.err.println("Mensaje1="+uee.getMessage());
            	}
            }
		    //String[] strDatos3 = {"0",strUsuario};
            return GUARDADO;
		    //return strDatos3;
        }
        
    }
    
    /**
     * Actualiza los datos de un ciudadano
     * @param request	Request form
	 * @param Smail		Servidor mail
	 * @param PMail		Puerto salida mail
	 * @param SN		Nombre servidor
     */
    public void ActualizarCiudadano(HttpServletRequest request, String Smail, String PMail, String SN){
        
        String strFN			=	"";
        String stridCiudadano	=	request.getParameter("reg_id");
        String strNombre 		= 	request.getParameter("reg_nombre");
        String strApePaterno 	= 	request.getParameter("reg_apellidoP");
        String strApeMaterno 	= 	request.getParameter("reg_apellidoM");
        String strDia			=	request.getParameter("reg_dia");
        String strMes			=	request.getParameter("reg_mes");
        String strYear			=	request.getParameter("reg_year");
        String strSexo			=	request.getParameter("reg_sexo");
        String strOcupacion		=	request.getParameter("reg_ocupacion");
        String strDomicilio		=	request.getParameter("reg_domicilio");
        String strPais			=	request.getParameter("reg_pais");
        String strEstado		=	request.getParameter("reg_estado");
        String strMunicipio		=	request.getParameter("reg_municipio");
        //String strMunicipio1		=	request.getParameter("reg_municipio1");
        String strTelefono		=	request.getParameter("reg_telefono");
        String strMail			=	request.getParameter("reg_mail");
        String strUsuario		=	request.getParameter("reg_usuario");
        String strPassword		=	request.getParameter("reg_con1");
        String strCPassword		=	request.getParameter("reg_con2");
        String strSector		=	request.getParameter("reg_sector");
        String strMun			=	"";
        
        if(strDomicilio == null && strDomicilio.length() == 0)
            strDomicilio = "null";
        if(strTelefono == null && strTelefono.length() == 0)
            strTelefono = "null";
        
        if(strDia.equals("-1") && strMes.equals("-1") && strYear.equals("-1")){
        	strFN = "null";
        }
        else{
            if(strDia.length()==1){
                strDia = "0"+strDia;
                strFN	=	strDia+"/"+strMes+"/"+strYear;
            }else{
                strFN	=	strDia+"/"+strMes+"/"+strYear;
            }
        }
        
        if(strSexo.equals("-1"))
        	strSexo = "null";
        //if(strOcupacion.length()==0)
        if(strOcupacion.equals("-1"))
        	strOcupacion = "null";
        if(strPais.equals("-1"))
        	strPais = "null";
        if(strEstado.equals("-1"))
        	strEstado = "null";
        if(strMail.length()==0)
        	strMail = "null";
        if(strSector.equals("-1"))
        	strSector = "null";
        
        
        if(strApePaterno.length() == 0)
            strApePaterno = "";
        if(strApeMaterno.length() == 0)
            strApeMaterno = "";
        
        if(strMunicipio.length() == 0){
        	strMun = "";
        }
        else{
            strMun = strMunicipio; 
        }
        
        boolean bActualizar = ActualizaCiudadano.actualizaCiudadano(stridCiudadano, strNombre, strApePaterno, strApeMaterno, strFN, strSexo, strOcupacion, strDomicilio, strPais, strEstado, strMun, strTelefono, strMail, strSector);
    }
    
    /**
     * Editar password de un ciudadano
     * @param request	Request form
	 * @param Smail		Servidor mail
	 * @param PMail		Puerto salida mail
	 * @param SN		Nombre servidor
     * @return	0 guardado, -1 usuario existente, -2 no coincide password
     */
    public synchronized int editarPassword(HttpServletRequest request, String Smail, String PMail, String SN){
        
        int GUARDADO = 0;
        int CLAVE_ANTERIOR_NO_EXISTE = -1; 
        int PASSWORD_NO_COINCIDE = -2;
        boolean bActualizarPass = false;
        
        String strAntPass	=	request.getParameter("pass1");
        String strPassword	=	request.getParameter("pass2");
        String strCPassword	=	request.getParameter("pass3");
        String strIdCiudadano=	request.getParameter("reg_id");
        String strMail		=	request.getParameter("mail");
        String strNombre	=	request.getParameter("nombre");
        String strUsuario	=	request.getParameter("user");
        String strOldPass	=	"";
        
        String strPass[][] 	=	ActualizaCiudadano.getDatosCiudadano(strIdCiudadano);
        if(strPass != null && strPass.length > 0) 
            strOldPass = strPass[0][13];
        
        if(!strAntPass.equals(strOldPass)){
            return CLAVE_ANTERIOR_NO_EXISTE;
        }else if(!strPassword.equals(strCPassword)){
            return PASSWORD_NO_COINCIDE;
        }else{
            bActualizarPass = ActualizaCiudadano.actualizaPassword(strIdCiudadano, strPassword);
            GUARDADO = Integer.parseInt(strIdCiudadano);
            
            if(strMail.length() == 0){
            	//System.err.println("no envia mail");
            }else{
            	////System.err.println("envia mail");
            	SenderMail send = new SenderMail();
            	try{
            		send.sendConfirmacionCiudadanoCambioPass(strNombre, strMail, strUsuario, strPassword, SN, request.getContextPath(),request.getSession().getServletContext());
            	}catch(MessagingException me){
            		//System.err.println("Mensaje="+me.getMessage());
            	}catch(UnsupportedEncodingException uee){
            		//System.err.println("Mensaje1="+uee.getMessage());
            	}
            }
            return GUARDADO;
        }
    }

}

