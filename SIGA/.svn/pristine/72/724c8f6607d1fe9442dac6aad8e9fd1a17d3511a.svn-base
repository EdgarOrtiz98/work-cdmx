package com.meve.sigma.quartz;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Clase que envia correos a destinatarios especificos
 * @author Meve Soluciones S.A. de C.V.
 * @deprecated
 */
public class SenderMail {
	/**
	 * Método que envia un Mail solicitando el cambio de fecha de una instrucción en tiempo real	
	 * @param strNombreAsu Nombre Asunto
	 * @param strMail	Mail Mail del solicitante
	 * @param strSema	Semaforo (Rojo - Amarillo -Verde)
	 * @param strServerMail	Servidor de Correo
	 * @param strMailPort Puerto de servidor de correo
	 * @throws MessagingException  cuando no encuentra el nombre del jdbc
	 * @throws UnsupportedEncodingException	Configuración de correo
	 * @deprecated
	 */
    public void sendConfirmacionCambioSemaforo(String strNombreAsu, String strMail, 
    		String strSema, String strServerMail, String strMailPort, String folio)
    throws MessagingException, UnsupportedEncodingException{
        try{
            Properties props = System.getProperties();
            props = new Properties();
            	
            props.put("mail.smtp.host",strServerMail);
            props.put("mail.port",strMailPort);
            props.put("mail.store.protocol", "smtp");
    		props.put("mail.transport.protocol", "smtp");
            
            Session session = Session.getDefaultInstance(props, null);

            MimeMessage message = new MimeMessage(session);
            
            StringBuffer sb = new StringBuffer();
            
            sb.append("Saludos!\n");
            sb.append("\nLe informamos que el Asunto: ");
            sb.append(" "+strNombreAsu+" \n");
            sb.append("\ncon folio: "+folio+" ");
            sb.append(" ha cambiado a color ");
            sb.append(" "+strSema+" ");
            sb.append(" \n");
            sb.append(" \n");
            sb.append(" \n");
            sb.append("Gracias. \n");
            sb.append(" \n");
            sb.append(" \n");
            message.setContent(sb.toString(), "text/plain; charset=iso-8859-1");
            message.setSubject("Aviso! Cambio de semáforo del un asunto con el folio: "+folio+" ");
            Address address = new InternetAddress("siga@hacienda.gob.mx");
            message.setFrom(address);
            Address toAddress = new InternetAddress(strMail);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            Transport.send(message);
        }catch(Exception e){
            //System.err.println("Mensaje="+e.toString());
        }
    }
    
    /**
	 * Método que envia un Mail solicitando el cambio de fecha de una instrucción en tiempo real	
	 * @param strNombreAsu Nombre Asunto
	 * @param strMail	Mail Mail del solicitante
	 * @param strSema	Semaforo (Rojo - Amarillo -Verde)
	 * @param strServerMail	Servidor de Correo
	 * @param strMailPort Puerto de servidor de correo
	 * @throws MessagingException  cuando no encuentra el nombre del jdbc
	 * @throws UnsupportedEncodingException	Configuración de correo
	 * @deprecated
	 */
    public void sendConfirmacionCambioSemaforoInst(String strNombreAsu, String strMail, 
    		String strSema, String strServerMail, String strMailPort, String folio)
    throws MessagingException, UnsupportedEncodingException{
        try{
            Properties props = System.getProperties();
            props = new Properties();
            	
            props.put("mail.smtp.host",strServerMail);
            props.put("mail.port",strMailPort);
            props.put("mail.store.protocol", "smtp");
    		props.put("mail.transport.protocol", "smtp");
            
            Session session = Session.getDefaultInstance(props, null);

            MimeMessage message = new MimeMessage(session);
            
            StringBuffer sb = new StringBuffer();
            
            sb.append("Saludos!\n");
            sb.append("\nLe informamos que el Asunto: ");
            sb.append(" "+strNombreAsu+" ");
            sb.append("\ncon folio: "+folio+" ");
            sb.append(" ha cambiado a color ");
            sb.append(" "+strSema+" ");
            sb.append(" \n");
            sb.append(" \n");
            sb.append(" \n");
            sb.append("Gracias. \n");
            sb.append(" \n");
            sb.append(" \n");
            message.setContent(sb.toString(), "text/plain; charset=iso-8859-1");
            message.setSubject("Aviso! Cambio de semáforo en Instrucciones con el folio: "+folio+" ");
            Address address = new InternetAddress("siga@hacienda.gob.mx");
            message.setFrom(address);
            Address toAddress = new InternetAddress(strMail);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            Transport.send(message);
        }catch(Exception e){
            //System.err.println("Mensaje="+e.toString());
        }
    }
    /**
     * Envia un correo al vencerse el tiempo de respuesta
     * @param strNombreAsu Nombre del asunto
     * @param strMail Mail del asunto
     * @param strfolioNom Folio del asunto
     * @param strMailServer  Servidor de Correo
     * @param strPortServer Puerto de servidor de correo
     * @return Regresa un indicador de éxito
	 * @throws MessagingException  cuando no encuentra el nombre del jdbc
	 * @throws UnsupportedEncodingException	Configuración de correo
	 * @deprecated
     */    
    public void sendConfirmacionCaduca(String strNombreAsu, String strMail, String strfolioNom, 
    		String MailServer, String PortServer)
    throws MessagingException, UnsupportedEncodingException
     {
         try{
             Properties props = System.getProperties();
             props = new Properties();
             	
             props.put("mail.smtp.host",MailServer);
             props.put("mail.port",PortServer);
             props.put("mail.store.protocol", "smtp");
     		 props.put("mail.transport.protocol", "smtp");
             
             Session session = Session.getDefaultInstance(props, null);
             MimeMessage message = new MimeMessage(session);            
             StringBuffer sb = new StringBuffer();
             
             sb.append("Saludos!\n");
             sb.append("\nLe informamos que el Asunto: ");
             sb.append(" "+strNombreAsu+" ");
             sb.append(" con numero de folio ");
             sb.append(" "+strfolioNom+" ");
             sb.append(" ha vencido de la fecha compromiso. \n");
             sb.append(" \n");
             sb.append(" \n");
             sb.append("Esperamos pueda darle el seguimiento correspondiente a la brevedad posible. \n");
             sb.append("Gracias. \n");
             sb.append(" \n");
             sb.append(" \n");
             message.setContent(sb.toString(), "text/plain; charset=iso-8859-1");
             message.setSubject("Aviso! Asunto vencido");
             Address address = new InternetAddress("siga@hacienda.gob.mx");
             message.setFrom(address);
             Address toAddress = new InternetAddress(strMail);
             message.addRecipient(Message.RecipientType.TO, toAddress);
             Transport.send(message);
 	     }catch(Exception e){
             //System.err.println("Mensaje="+e.toString());
         }
     }
}


