/*
 * Contacto.java
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

import java.io.IOException;
import java.util.Enumeration;

import javax.mail.internet.AddressException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Contacto extends HttpServlet {

	private static final long serialVersionUID = 2283403480900906971L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String action = request.getParameter("action");
            if("SendMail".equals(action)){
                String returnPage = request.getParameter("return");
                String origin = request.getParameter("origin");
                String to = request.getParameter("to");
                String cc = request.getParameter("cc");
                StringBuffer resp = new StringBuffer();
                StringBuffer header = new StringBuffer();
                StringBuffer content = new StringBuffer();
                Enumeration enuma = request.getParameterNames();
                while(enuma.hasMoreElements()){
                    String param = (String) enuma.nextElement();
                    if (!param.equals("return") && !param.equals("origin") && !param.equals("to")){
                        String value = request.getParameter(param);
                        resp.append(param).append("=").append(value).append("\n");
                        header.append(param).append("|");
                        content.append(value).append("|");
                    }//if
                }//while
                resp.append("\n").append(header).append("\n").append(content);
                enviaMail("mimail@dominio.com", to, cc, "Envio de informacion "+ origin, resp.toString());
                response.sendRedirect(response.encodeURL(returnPage));
            }else{response.sendRedirect(response.encodeURL("error.jsp"));}
	}

	private void enviaMail(String from, String to, String cc, String subject,String message){
            try{
                MailTask mtOperador = new MailTask(from, to, cc, subject, message,MailTask.SERVER);
                TaskQueues.getQueue("MAIL", 10).addTask(mtOperador);
            } catch (AddressException e){throw new RuntimeException(e);}
	}
}