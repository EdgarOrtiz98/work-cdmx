package com.meve.sigma.reportes;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import com.meve.sigma.db2.ConexionDS;

public class ReportCiudadano extends HttpServlet implements Servlet {
	
    private String strIdCiudadano="";
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ReportCiudadano() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
	    strIdCiudadano = (arg0.getParameter("id_ciu")==null)?"":arg0.getParameter("id_ciu");
		Connection con=null;
		try {
			con = ConexionDS.getConexion();
			ServletContext context = getServletContext();

			System.setProperty("jasper.reports.compile.class.path", context
					.getRealPath("/WEB-INF/lib/jasperreports-6.15.0.jar")
					+ System.getProperty("path.separator")
					+ context.getRealPath("/WEB-INF/"));
			System.setProperty("jasper.reports.compile.temp", 
                    context.getRealPath("/Reportes/")); 

			//JasperCompileManager.compileReportToFile(context.getRealPath("/Reportes/ReportCiudadano.jrxml"));
			File reportFile = new File(context.getRealPath("/Reportes/ReportCiudadano.jasper"));
			Map parameters = new HashMap();      
			parameters.put("ID_CIUDADANO", strIdCiudadano);
			parameters.put("URL_IMAGE", context.getRealPath("/Imagenes/logo_word_shcp.gif"));
			//parameters.put("URL_IMAGE", context.getRealPath("/Imagenes/issste.jpg"));
			//System.out.println(reportFile.getPath());
			byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), 
									parameters, con);
			arg1.setContentType("application/pdf");
			arg1.setContentLength(bytes.length);
			ServletOutputStream ouputStream = arg1.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length); 
			ouputStream.flush();
			ouputStream.close();

			
		}catch(JRException e){
		    //System.out.println("Error:" +e.getLocalizedMessage());
		    StringWriter stringWriter = new StringWriter();
		    PrintWriter printWriter = new PrintWriter(stringWriter);
		    e.printStackTrace(printWriter);
		    arg1.setContentType("text/plain");
		    arg1.getOutputStream().print(stringWriter.toString());
		}
        catch(Exception e) {
            e.printStackTrace();
            //System.out.println("Error2:" +e.getMessage()); 
        }
	    finally {
	        try{con.close();}catch(Exception e) {;};
	    }

	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	    doGet(arg0, arg1);
	}

}