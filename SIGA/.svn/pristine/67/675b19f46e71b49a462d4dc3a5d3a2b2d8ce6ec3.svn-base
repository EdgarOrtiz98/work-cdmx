package com.meve.sigma.reportes;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import com.meve.sigma.actualiza.ActualizaAsuntoTurnado;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.util.Utilerias;

/**
 * Servlet implementation class for Servlet: Para
 *
 */
 public class Para extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Para() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strGetAsuntoTurnado[][] 	= 	null;
		strGetAsuntoTurnado				= 	ActualizaAsuntoTurnado.getAsuntoTurnadoReporte("670");
		////System.err.println("strGetAsuntoTurnado="+strGetAsuntoTurnado.length);
		
		try {
			ServletContext context = getServletContext();
			System.setProperty("jasper.reports.compile.class.path", context
					.getRealPath("/WEB-INF/lib/jasperreports-6.15.0.jar")
					+ System.getProperty("path.separator")
					+ context.getRealPath("/WEB-INF/"));//
			System.setProperty("jasper.reports.compile.temp", 
                    context.getRealPath("/Reportes/"));  
			
			File reportFile = new File(context.getRealPath("/Reportes/para.jasper"));
			Map parameters = new HashMap();      
			Vector vPara = new Vector();
			Vector vCCP = new Vector();
			Vector vPE = new Vector();
			
			////System.err.println("b1="+strGetAsuntoTurnado[0][46]);
			vPara = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][46], 1);
			vCCP = Utilerias.getNombrePuesto(strGetAsuntoTurnado[0][47], 2);
			vPE = Utilerias.getRemitenteEntidad(strGetAsuntoTurnado[0][47],0);
			String para = Utilerias.getCadenaBajarLinea(vPara);
			String ccp = Utilerias.getCadenaBajarLinea(vPara);
			String pe = Utilerias.getCadenaBajarLinea(vPara);
			parameters.put("PARA_1", para);
			parameters.put("ccp", ccp);
			parameters.put("para_e", pe);
			
			//strPara.indexOf(new Integer(1));
			
			byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), 
									parameters, new JREmptyDataSource());
			response.setContentType("application/pdf"); 
			response.setContentLength(bytes.length); 
			ServletOutputStream ouputStream = response.getOutputStream(); 
			ouputStream.write(bytes, 0, bytes.length); 
			ouputStream.flush();
			ouputStream.close(); 
			
		}catch(JRException e){
		    //System.out.println("Error:" +e.getLocalizedMessage());
		    //display stack trace in the browser
		    StringWriter stringWriter = new StringWriter();
		    PrintWriter printWriter = new PrintWriter(stringWriter);
		    e.printStackTrace(printWriter);
		    response.setContentType("text/plain");
		    response.getOutputStream().print(stringWriter.toString());
		}
        catch(Exception e) {
            e.printStackTrace();
            //System.out.println("Error2:" +e.getMessage()); 
        }
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}   	  	    
}