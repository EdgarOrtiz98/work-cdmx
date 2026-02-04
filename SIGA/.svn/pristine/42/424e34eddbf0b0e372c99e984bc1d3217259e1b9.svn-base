package com.meve.sigma.reportes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.ArrayList;
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
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
//import net.sf.jasperreports.engine.export.JExcelApiExporter;
//import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.actualiza.ActualizaArchivo;
import com.meve.sigma.actualiza.ActualizaArea;
import com.meve.sigma.actualiza.ActualizaInstrucciones;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.beans.search.ActualizaBuscar;

public class ReporteBeanExcel extends HttpServlet implements Servlet {
    
    private String strIdReporte="";
    private String strTipoReporte = "";
    private String strTitulo = "";
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ReporteBeanExcel() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
	    strTipoReporte = (arg0.getParameter("tip")==null)?"":arg0.getParameter("tip"); //"porturnar_01";
	    String strIdRemitente = (arg0.getParameter("id_remitente")==null)?"":arg0.getParameter("id_remitente"); 
	    String strControl = (arg0.getParameter("control")==null)?"":arg0.getParameter("control"); 
	    String strBuscar = (arg0.getParameter("buscar")==null)?"":arg0.getParameter("buscar"); 
	    
	    HttpSession session = arg0.getSession();
		UsuarioBean BUsuario = (UsuarioBean)session.getAttribute("UsuarioBean");
		if (strTipoReporte.equals("busca_asu")){
			strBuscar = (String)session.getAttribute("SQLDinamicaAsu");
		} else if (strTipoReporte.equals("busca_inst")){
			strBuscar = (String)session.getAttribute("SQLDinamicaInst");
		}

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
			parameters.put("USU_NOMBRE", BUsuario.getCargo());
			parameters.put("USU_PUESTO", BUsuario.getNombre());
			parameters.put("ID_USUARIO", BUsuario.getIdUsuario());
			parameters.put("USU_AREA", BUsuario.getIdArea());
			parameters.put("AREA_NOMBRE", ActualizaArea.NombreArea(BUsuario.getIdArea()));
			parameters.put("ID_REMITENTE", strIdRemitente);
			parameters.put("CONTROL", strControl);
			parameters.put("ARG_BUSCAR", strBuscar);
			
			ArrayList al = null;
			if (!strControl.equals("1")){
				if (strTipoReporte.equals("foliodecontrol_beanExcel") || 
					strTipoReporte.equals("foliodecontrol_bean")){
					
					al = new ArrayList();
					String datosReporte[][] = ActualizaInstrucciones.getFolioEntradaReporte(BUsuario.getIdArea());
					if(datosReporte != null && datosReporte.length>0){
						for (int i=0; i<datosReporte.length; i++){
							BeanReporteFolioDeControl BReporte = new BeanReporteFolioDeControl();
							BReporte.setCampos(datosReporte[i]);
							al.add(BReporte);
						}
					} 
					
				}else if (strTipoReporte.equals("busqueda_beanExcel") || 
						strTipoReporte.equals("busqueda_bean")){
					
					al = new ArrayList();
					String datosReporte[][] 	= (String[][])session.getAttribute("ResultadoBuscar");
					String strContenido 		= (String)session.getAttribute("buscaSobreContenido");
					String strBusquedaContent 	= (String)session.getAttribute("buscaContenido");
					if(datosReporte != null && datosReporte.length>0){
						for (int i=0; i<datosReporte.length; i++){
							String strBuqueda[][] = ActualizaBuscar.getAsuntoBuscar(datosReporte[i][4]);
							if (strBuqueda!=null && strBuqueda.length>0){
								BeanReporteFolioDeControl BReporte = new BeanReporteFolioDeControl();
								BReporte.setCampos(strBuqueda[0], datosReporte[i]);
								BReporte.setContenidoDocAnexos(strContenido);
								if (strBusquedaContent.equals("5")){
									BReporte.setDocAnexados(datosReporte[i][12]);
								}else{
									BReporte.setDocAnexados(ActualizaArchivo.getStringNombreArchivos(datosReporte[i][4]));
								}
								al.add(BReporte);
							}
						}
					} 
						
				}else if (strTipoReporte.equals("busquedaInst_beanExcel") || 
						strTipoReporte.equals("busquedaInst_bean")){
					
					al = new ArrayList();
					String datosReporte[][] = (String[][])session.getAttribute("ResultadoBuscar");
					String strContenido 		= (String)session.getAttribute("buscaSobreContenido");
					String strBusquedaContent 	= (String)session.getAttribute("buscaContenido");
					if(datosReporte != null && datosReporte.length>0){
						for (int i=0; i<datosReporte.length; i++){
							String strBuqueda[][] = ActualizaBuscar.getInstruccionBuscar(datosReporte[i][0]);
							if (strBuqueda!=null && strBuqueda.length>0){
								BeanReporteBuscarInst BReporte = new BeanReporteBuscarInst();
								BReporte.setCampos(strBuqueda[0], datosReporte[i]);
								BReporte.setContenidoDocAnexados(strContenido);
								if (strBusquedaContent.equals("5")){
									BReporte.setDocAnexados(datosReporte[i][16]);
								}else{
									BReporte.setDocAnexados(ActualizaArchivo.getStringNombreArchivosIns(datosReporte[i][0]));
								}
								al.add(BReporte);
							}
						}
					} 
						
				}else {
					al = (ArrayList)session.getAttribute("ArrayReporte");
				}
			}else{
				al = (ArrayList)session.getAttribute("ArrayReporte2");
			}
			
	        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(al,false);

	        //Generar XLS. Preparacion del reporte (en esta etapa se inserta el valor del query en el reporte).
			JasperPrint jasperPrint=JasperFillManager.fillReport(reportFile.getPath(), parameters, ds);
			
			//Nombre archivo resultado. Sugerencia: traten de generar un nombre 
			//dinamico concatenando fecha y hora para evitar 
			//se pisen los reportes al tener el mismo nombre.
			double t = Math.random();
			String strNumero = String.valueOf(t);
			strNumero = strNumero.substring(13,strNumero.length());
			String xlsFileName = "Reporte"+strNumero+".xls";
			
			
		/*	JExcelApiExporter exporter = new JExcelApiExporter();				
				exporter.setParameter(JExcelApiExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JExcelApiExporterParameter.OUTPUT_FILE_NAME,xlsFileName);
				exporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
				//exporter.setParameter(JExcelApiExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE);
				exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
				exporter.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
				exporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
				exporter.exportReport();																								
				*/
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
			arg1.setContentType ("application/vnd.ms-excel");
							
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