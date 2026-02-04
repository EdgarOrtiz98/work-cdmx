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
import javax.servlet.http.HttpSession;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.db2.ConexionDS;

//import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;

public class RporTipDocto extends HttpServlet implements Servlet {
    
    private String strIdReporte="";
    private String strTipoReporte = "";
    private String strTitulo = "";
    private String strArea = "";
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public RporTipDocto() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

	    strIdReporte = (arg0.getParameter("id_rep")==null)?"":arg0.getParameter("id_rep");
	    strTipoReporte = (arg0.getParameter("tip")==null)?"":arg0.getParameter("tip");
	    strTitulo = (arg0.getParameter("tit")==null)?"":arg0.getParameter("tit");
	    strArea = (arg0.getParameter("area")==null)?"":arg0.getParameter("area");
	    
	    HttpSession session = arg0.getSession();
		UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
		
	    Connection con=null;
		try {
			con = ConexionDS.getConexion();
			ServletContext context = getServletContext();
			System.setProperty("jasper.reports.compile.class.path", context
					.getRealPath("/WEB-INF/lib/jasperreports-6.15.0.jar")
					+ System.getProperty("path.separator")
					+ context.getRealPath("/WEB-INF/"));//
			System.setProperty("jasper.reports.compile.temp", 
                    context.getRealPath("/Reportes/")); 
			//JasperCompileManager.compileReportToFile(context.getRealPath("/Reportes/"+strTipoReporte+".jrxml"));
			File reportFile = new File(context.getRealPath("/Reportes/"+strTipoReporte+".jasper"));
			Map parameters = new HashMap();
			parameters.put("ID_REPORTE", strIdReporte);
			parameters.put("REPORTE_FECHA_RANGO", strTitulo);
			parameters.put("STR_AREA", strArea);
			parameters.put("URL_IMAGE", context.getRealPath("/Imagenes/logoPortal.jpg"));
			parameters.put("AREA_USUARIO", ActualizaArea.NombreArea(BUsuario.getIdArea()));
			//parameters.put("URL_IMAGE", context.getRealPath("/Imagenes/issste.jpg"));
			byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), 
			//						parameters, new JREmptyDataSource());
									parameters, con);
			arg1.setContentType("application/pdf");
			arg1.setContentLength(bytes.length);
			ServletOutputStream ouputStream = arg1.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length); 
			ouputStream.flush();
			ouputStream.close(); 
			
		}catch(JRException e){
		    //System.out.println("Error->" +e.getLocalizedMessage());
		    //		  display stack trace in the browser
		    StringWriter stringWriter = new StringWriter();
		    PrintWriter printWriter = new PrintWriter(stringWriter);
		    e.printStackTrace(printWriter);
		    arg1.setContentType("text/plain");
		    arg1.getOutputStream().print(stringWriter.toString());
		}
        catch(Exception e) {
            e.printStackTrace();
            //System.out.println("Error2->" +e.getMessage()); 
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