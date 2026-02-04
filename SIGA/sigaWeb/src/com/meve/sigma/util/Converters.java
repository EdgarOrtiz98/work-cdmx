/*
 * Created on 28/06/2007
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.meve.sigma.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Clase que contiene metodos para la manipulacion de cadenas
 * 
 * @author Meve Soluciones, SA
 */
public class Converters {

	public static String getJavaScriptLogString(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		List log = (List) request.getSession().getAttribute("log");
		if (log == null) {
			log = new ArrayList();
		}
		for (int i = 0; i < log.size(); i++) {
			sb.append((String) log.get(i)).append("\\n");
		}
		request.getSession().setAttribute("log", new ArrayList());
		return sb.toString();
	}

	public static String getJavaScriptErrorString(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		if (request.getAttribute(Globals.ERROR_KEY) != null) {
			ActionMessages aes = (ActionMessages) request
					.getAttribute(Globals.ERROR_KEY);
			Iterator iter = aes.get();
			ResourceBundle resource = (ResourceBundle) request.getSession()
					.getServletContext().getAttribute("resource");
			while (iter.hasNext()) {
				ActionMessage ae = (ActionMessage) iter.next();
				String msg = resource.getString(ae.getKey());
				if (ae.getValues() != null && ae.getValues().length != 0) {
					msg = msg.replaceAll("\\{0\\}", (String) ae.getValues()[0]);
				}
				sb.append(msg).append("\\n");
			}
		}
		return sb.toString();
	}

	public static String convertPlainToHtml(String plain) {
		String result = plain != null ? plain : "";
		result = result.replaceAll("\n", "<br>");
		result = result.replaceAll("\r", "");
		result = result.replaceAll("  ", "&nbsp;");
		result = result.replaceAll("\t", "&nbsp;");
		result = result.replaceAll("\"", "");
		result = result.replaceAll("'", "");
		return result;
	}

	public static String convertDocumentToString(Document doc) {
		Format format = Format.getPrettyFormat();
		format.setEncoding("iso-8859-1");
		XMLOutputter xmlOutputer = new XMLOutputter(format);
		return xmlOutputer.outputString(doc);
	}
	
	public static String convertElementToString(Element doc) {
		Format format = Format.getPrettyFormat();
		format.setEncoding("iso-8859-1");
		XMLOutputter xmlOutputer = new XMLOutputter(format);
		return xmlOutputer.outputString(doc);
	}
}
