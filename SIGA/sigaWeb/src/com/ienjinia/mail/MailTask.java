/*
 * MailTask.java
 *  
 * Copyright (C) Ienjinia, S.C. 2007. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of IENJINIA
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with  IENJINIA
 * or his authorized licensees.
 * 
 * MEVE SOLUCIONES MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT
 * THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. IENJINIA
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF
 * USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *  
 */

package com.ienjinia.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MailTask implements Runnable {

        private static Log log = LogFactory.getLog(MailTask.class);
        public final static String SERVER = "mundojava.com";
	private InternetAddress from;
	private InternetAddress[] to;
	private String subject;
	private String text;
	private String mailServer;

	public MailTask(String from, String to, String cc, String subject,String text, String mailServer) throws AddressException{
		
                if(from == null){throw new NullPointerException("from es nulo");}
		if(from.length() == 0){throw new IllegalArgumentException("from esta vacio");}
		if(to == null){throw new NullPointerException("to es nulo");}
		if(to.length() == 0){throw new IllegalArgumentException("to esta vacio");}
		if(subject == null){throw new NullPointerException("subject es nulo");}
		if(subject.length() == 0){throw new IllegalArgumentException("subject esta vacio");}
		if(text == null){throw new NullPointerException("text es nulo");}
		if(text.length() == 0){throw new IllegalArgumentException("text esta vacio");}
		if(mailServer == null){throw new NullPointerException("mail server es nulo");}
		if(mailServer.length() == 0){throw new IllegalArgumentException("mail server esta vacio");}
		
                this.from = new InternetAddress(from);
		if(cc != null){this.to = new InternetAddress[] { new InternetAddress(to),new InternetAddress(cc) };
		}else{this.to = new InternetAddress[] { new InternetAddress(to) };}
		
                this.subject = subject;
		this.text = text;
		this.mailServer = mailServer;
	}

	public void run() {
		try {
                    Properties props = new Properties();
                    props.put("mail.smtp.host", mailServer);
                    Session session = Session.getInstance(props);
                    Message msg = new MimeMessage(session);
                    msg.setFrom(from);
                    msg.setRecipients(Message.RecipientType.TO, to);
                    msg.setSubject(subject);
                    msg.setText(text);
                    msg.saveChanges();
                    Transport.send(msg);
            } catch (MessagingException e) {
                    log.error("********Fallo al enviar el correo*******");
                    log.error("Subject: "+subject);
                    log.error("To: ");
                    for (int i = 0; i < to.length; i++) {
                            log.error(to[i].toString());
                    }
                    log.error("Text:");
                    log.error(text);
                    log.error("***************************************");
                    throw new RuntimeException(e);
            }
	}
}