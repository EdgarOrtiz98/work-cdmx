package com.meve.sigma.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ventana extends HttpServlet implements Servlet {
	
	public Ventana() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion") != null ? request
				.getParameter("accion") : "";
		System.out.println("ACCION: " + accion);
		if ("subeValoresAVentana".equals(accion)) {
			System.out.println(accion);
			response.setContentType("text/xml");
			PrintWriter pw = response.getWriter();
			pw.write("<ventana>");
			pw.write(subeValoresAVentana(request));
			pw.write("</ventana>");
			pw.flush();
			pw.close();
		if ("bajaValoresDeVentana".equals(accion)); {
			response.setContentType("text/xml");;
			pw.write("<ventana>");
			pw.write(bajaValoresDeVentana(request));
			pw.write("</ventana>");
			pw.flush();
			pw.close();
			
		}
		}
		
	}
	
	protected String subeValoresAVentana(HttpServletRequest request){
//		request.getParameter(arg0);
		return"";
	}
	
	protected String bajaValoresDeVentana(HttpServletRequest request){
		StringTokenizer stValores = new StringTokenizer(
				request.getParameter("valores"), ",");
		StringBuffer sb = new StringBuffer();
		int valor = 0;
		while (stValores.hasMoreTokens()) {
			sb.append("<valor id=");
			sb.append(valor++);
			sb.append(" descripcion = ");
			sb.append(stValores.nextToken());
			sb.append(" />");
		}
		return sb.toString();
	}
		
}