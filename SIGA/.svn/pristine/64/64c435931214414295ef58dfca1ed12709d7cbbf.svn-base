package com.meve.sigma.reportes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperRunManager;
//import net.sf.jasperreports.engine.export.JExcelApiExporter;
//import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.db2.ConexionDS;

public class ReportExcel extends HttpServlet implements Servlet {
    
    private String strIdReporte="";
    private String strTipoReporte = "";
    private String strTitulo = "";
    private String strArea = "";
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ReportExcel() {
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
			parameters.put("AREA_USUARIO", ActualizaArea.NombreArea(BUsuario.getIdArea()));
			
			//Generar XLS. Preparacion del reporte (en esta etapa se inserta el valor del query en el reporte).
			JasperPrint jasperPrint=JasperFillManager.fillReport(reportFile.getPath(), parameters, con);
			
			//Nombre archivo resultado. Sugerencia: traten de generar un nombre 
			//dinamico concatenando fecha y hora para evitar 
			//se pisen los reportes al tener el mismo nombre.
			double t = Math.random();
			String strNumero = String.valueOf(t);
			strNumero = strNumero.substring(13,strNumero.length());
			String xlsFileName = "Reporte"+strNumero+".xls";
			
			//Creacion del XLS
			/*JExcelApiExporter exporter = new JExcelApiExporter();
			exporter.setParameter(JExcelApiExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JExcelApiExporterParameter.OUTPUT_FILE_NAME,xlsFileName);
			exporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			//exporter.setParameter(JExcelApiExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
			exporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.exportReport();*/
			 JRXlsExporter exporter = new JRXlsExporter();
	    		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	    		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsFileName));
	    		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
	    		configuration.setOnePagePerSheet(true);
	    		configuration.setDetectCellType(true);
	    		configuration.setCollapseRowSpan(false);
	    		configuration.setRemoveEmptySpaceBetweenRows(true);
	    		exporter.setConfiguration(configuration);
	    		exporter.exportReport();

			//En este punto ya esta Creado el XLS
			
			//Ahora lo Voy a Leer Y A forzar al Navegador Muestre Dialogo Para descargar el archivo
			//Funciona En IE y Firefox
			//Leer el archivo.
			File f = new File (/*xlsFilesSource + */xlsFileName);
			
			//Configurar el tipo de archivo.
			arg1.setContentType ("application/vnd.ms-excel;charset=UTF-8");
							
			//Obtener el Nombre del archivo.
			String name = f.getName().substring(f.getName().lastIndexOf("/") + 1,f.getName().length());
							
			//Configurar cabecera y nombre de archivo a desplegar en DialogBox.
			arg1.setHeader ("Content-Disposition", "attachment;filename=\"" + xlsFileName + "\"");
							
			InputStream in = new FileInputStream(f);
			ServletOutputStream outs = arg1.getOutputStream();
					
			int bit = 256;
			int i = 0;
							
			while ((bit) >= 0) {
			        	bit = in.read();
			        	outs.write(bit);
			}
								
			outs.flush();
			outs.close();
			in.close();
			
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
		// TODO Auto-generated method stub
	}

}