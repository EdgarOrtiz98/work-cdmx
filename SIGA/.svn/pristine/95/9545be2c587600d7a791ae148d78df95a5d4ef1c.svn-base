package com.meve.sigma.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meve.sigma.actualiza.ActualizaArchivo;

public class Ver extends HttpServlet implements Servlet {
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Ver() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
	    String strFile="";
		//String strId="";
		String strIdA="";				
		strFile=arg0.getParameter("file");
		strIdA=arg0.getParameter("ida");						
		if(strIdA != null)
		{				
			OutputStream ou = arg1.getOutputStream();				
			////System.out.println("contenttype: " + ActualizaArchivo.getContentType(strIdA));				
			byte archivo[]=ActualizaArchivo.getBlob(strIdA);
			////System.out.println("Archivo Longitud:"+archivo.length);				
			arg1.setContentType(ActualizaArchivo.getContentType(strIdA));
			arg1.setHeader(
				"Content-Disposition",
				"attachment; filename=\"" + strFile + "\"");
			arg1.setContentLength(archivo.length);		
			//resp.setBufferSize(4000);
			ou.write(archivo);	
			ou.flush();
			arg1.flushBuffer();						
		}
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}