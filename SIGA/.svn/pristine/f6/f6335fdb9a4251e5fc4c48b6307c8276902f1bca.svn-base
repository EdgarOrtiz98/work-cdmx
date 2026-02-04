package com.meve.sigma.reporte;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.meve.sigma.asunto.AsuntoForm;
import com.meve.sigma.asunto.dao.AsuntoDao;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.catalogos.Catalogos;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.instruccion.InstruccionForm;
import com.meve.sigma.organizacional.EstructuraOrganizacional;
import com.meve.sigma.organizacional.vo.PuestoVO;
import com.meve.sigma.reportes.ActualizaComentario;
import com.meve.util.ManejadorDeTablas;

/**
 * Genera el reporte de excel de las busquedas de solicitud
 * 
 * @author Meve Soluciones, S. A.
 * 
 */

public class GeneraReporte extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1566969868524756889L;
	public static final int REPORTE_ASUNTOS = 1;
	public static final int REPORTE_ASUNTOS_TOTALES = 2;
	public static final int REPORTE_INSTRUCCIONES = 11;
	public static final int REPORTE_INSTRUCCIONES_TOTALES = 12;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int reporte = Integer.parseInt(request.getSession().getAttribute(
				"reporte").toString());
		Map parametros = new HashMap();
		List datos = null;
		Connection conn = null;
		UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute(
				"UsuarioBean");
		switch (reporte) {
		case REPORTE_ASUNTOS:
			datos = ((ManejadorDeTablas) request.getSession().getAttribute(
					ManejadorDeTablas.TABLE_MANAGER)).getRegistros();
			try {
				conn = ConexionDS.getConexion();
				for (int i = 0; i < datos.size(); i++) {
					AsuntoForm asunto = (AsuntoForm) datos.get(i);
					asunto.setAsuntosRelacionados(AsuntoDao
							.getAsuntosRelacionados(conn, asunto.getIdAsunto(),
									asunto.getFolioRecepcion()));
					/*asunto.setSemaforo(ReporteUtil.getSemaforo(conn, asunto
							.getFechaCapturaLong(), asunto.getFechaCadLong()));*/
					asunto
							.setDestinatarioNombre(getDestinatarios(conn,
									asunto));
					//////////////se agregó
					asunto.setAsuntoCC(getDestinatariosCc(conn,asunto));
					asunto.setUsuarioTurna(getUsuarioT(conn, asunto));									
					asunto.setAsuntoParaE(getUsuarioPE(conn, asunto));
					asunto.setRemitente(getRemi(conn, asunto));
					
					// se corrigió query
					String strComentarios[][] = ActualizaComentario.getDatosComentariosComplementarios(String.valueOf(asunto.getIdAsunto()));
					if(strComentarios.length != 0){
						asunto.setRespuestaAsunto(strComentarios[0][1]);
					}					
					//////////////termina se agregó
					EstructuraOrganizacional eOrg = (EstructuraOrganizacional) request
							.getSession()
							.getServletContext()
							.getAttribute(
									Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL);
					PuestoVO puesto = eOrg.getPuesto(asunto
							.getIdUsuarioCaptura());
					if (puesto != null) {
						asunto.setUsuarioCaptura(puesto.getNombre() + "/"
								+ puesto.getCargo());
					}else{
						asunto.setUsuarioCaptura("");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
				ConexionDS.endConnection(null, null, conn);
			}
			parametros.put("ENCABEZADO", "Periodo "
					+ request.getSession().getAttribute("criteriosBusqueda")
							.toString() + " - " + usuario.getNombre() + "/"
					+ usuario.getCargo());
			generaExcel(request, response, "/Reportes/Asuntos.jasper",
					parametros, ((ManejadorDeTablas) request.getSession()
							.getAttribute(ManejadorDeTablas.TABLE_MANAGER))
							.getRegistros());
			break;

		case REPORTE_ASUNTOS_TOTALES:
			parametros.put("ENCABEZADO", "Periodo "
					+ request.getSession().getAttribute("criteriosBusqueda")
							.toString() + " - " + usuario.getNombre() + "/"
					+ usuario.getCargo());
			generaExcel(request, response,
					"/Reportes/TotalAsuntosEstatus.jasper", parametros,
					((ManejadorDeTablas) request.getSession().getAttribute(
							ManejadorDeTablas.TABLE_MANAGER)).getRegistros());
			break;

		case REPORTE_INSTRUCCIONES:
			datos = ((ManejadorDeTablas) request.getSession().getAttribute(
					ManejadorDeTablas.TABLE_MANAGER)).getRegistros();
			try {
				conn = ConexionDS.getConexion();
				for (int i = 0; i < datos.size(); i++) {
					InstruccionForm instruccion = (InstruccionForm) datos
							.get(i);
					instruccion.setSemaforo(ReporteUtil.getSemaforo(conn,
							instruccion.getFechaAsignacionLong(), instruccion
									.getFechaVencimientoLong()));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
				ConexionDS.endConnection(null, null, conn);
			}
			parametros.put("ENCABEZADO", "Periodo "
					+ request.getSession().getAttribute("criteriosBusqueda")
							.toString() + " - " + usuario.getNombre() + "/"
					+ usuario.getCargo());
			generaExcel(request, response, "/Reportes/Instrucciones.jasper",
					parametros, datos);
			break;
		case REPORTE_INSTRUCCIONES_TOTALES:
			parametros.put("ENCABEZADO", "Periodo "
					+ request.getSession().getAttribute("criteriosBusqueda")
							.toString() + " - " + usuario.getNombre() + "/"
					+ usuario.getCargo());
			String archivoGrafica = generaGrafica(request);
			parametros.put("GRAFICA", archivoGrafica);
			try {
				generaExcel(request, response,
						"/Reportes/TotalInstruccionesEstatus.jasper",
						parametros, ((ManejadorDeTablas) request.getSession()
								.getAttribute(ManejadorDeTablas.TABLE_MANAGER))
								.getRegistros());
			} finally {
				File archivo = new File(archivoGrafica);
				archivo.delete();
			}
		default:

			break;
		}

	}

	private void generaExcel(HttpServletRequest request,
			HttpServletResponse response, String reporte, Map parametros,
			List datos) {
		ServletContext context = request.getSession().getServletContext();
		/*System.setProperty("jasper.reports.compile.class.path", context
				.getRealPath("/WEB-INF/lib/jasperreports-1.2.0.jar")
				+ System.getProperty("path.separator")
				+ context.getRealPath("/WEB-INF/"));*/
		System.setProperty("jasper.reports.compile.class.path", context
		.getRealPath("/WEB-INF/lib/jasperreports-6.15.0.jar")
		+ System.getProperty("path.separator")
		+ context.getRealPath("/WEB-INF/"));
		
		System.setProperty("jasper.reports.compile.temp", context
				.getRealPath("/reporte/"));
		File reportFile = new File(context.getRealPath(reporte));
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datos,false);
		
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile
					.getPath(), parametros, ds);
			  double t = Math.random();
	            String strNumero = String.valueOf(t);
	            strNumero = strNumero.substring(13, strNumero.length());
	            String xlsFileName = "Reporte" + strNumero + ".xls";
			/*JExcelApiExporter exporter = new JExcelApiExporter();																
			exporter
					.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
								
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.TRUE);					
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);*/
			JRXlsExporter exporter = new JRXlsExporter();
    		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
    		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsFileName));
    		configuration.setOnePagePerSheet(true);
    		configuration.setDetectCellType(true);
    		configuration.setCollapseRowSpan(false);
    		configuration.setRemoveEmptySpaceBetweenRows(true);
    		exporter.setConfiguration(configuration);
			
			/*byte[] bytes = ReporteUtil.exportReportToBytes(jasperPrint,
					exporter, request);
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=\""
					+ "SIGA" + new Date().getTime() + ".xls" + "\"");
			BufferedOutputStream outs = new BufferedOutputStream(response
					.getOutputStream());
			outs.write(bytes, 0, bytes.length);
			outs.flush();
			outs.close();*/
    		
    		exporter.exportReport();

            //En este punto ya esta Creado el XLS

            //Ahora lo Voy a Leer Y A forzar al Navegador Muestre Dialogo Para descargar el archivo
            //Funciona En IE y Firefox
            //Leer el archivo.
            File f = new File(xlsFileName);

            //Configurar el tipo de archivo.
            response.setContentType("application/vnd.ms-excel");

            //Configurar cabecera y nombre de archivo a desplegar en DialogBox.
            response.setHeader("Content-Disposition", "attachment;filename=\"" + xlsFileName + "\"");

            InputStream in = new FileInputStream(f);
            ServletOutputStream outs = response.getOutputStream();

            int bit = 256;

            /*Modificacion J.V.T. Intento de exportacion de datos de JasperReports//
                    int i = 0;
                    while ((bit) >= 0) {
                        bit = in.read();
                        outs.write(bit);
                    }
            */
            while ((bit = in.read()) != -1)
                outs.write(bit);

            outs.flush();
            outs.close();
            in.close();
		} catch (JRException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	protected String getDestinatarios(Connection conn, AsuntoForm asunto) {
		String destinatarios;
		String asuntoPara = asunto.getAsuntoPara();
		
		if(asuntoPara != null){
			if(!asuntoPara.equals("")){
				if(!asuntoPara.equals("null")){
					StringTokenizer st = new StringTokenizer(asunto.getAsuntoPara(), ",");
					StringBuffer sb = new StringBuffer();
					while (st.hasMoreElements()) {
						String id = st.nextToken();
						if (!id.equals("")){
							UsuarioBean usuario = AsuntoDao.getDestinatario(conn, Integer.parseInt(id));
							sb.append(usuario.getNombre());
							sb.append("/");
							sb.append(usuario.getCargo());
							sb.append("\n");
						}
					}
					destinatarios = sb.toString();
				}else{
					destinatarios = "";
				}
			}else{
				destinatarios = "";
			}
		}else{
			destinatarios = "";
		}
		return destinatarios;
	}
	protected String getRemi(Connection conn, AsuntoForm asunto) {
		String remitente;
		int usuarioid = asunto.getIdRemitente();
		StringBuffer sb = new StringBuffer();
		
		UsuarioBean usuario = AsuntoDao.getDestinatario(conn, usuarioid);
		sb.append(usuario.getNombre());
		sb.append("/");
		sb.append(usuario.getCargo());
		sb.append("\n");
		remitente = sb.toString();
		return remitente;
	}	
	protected String getDestinatariosCc(Connection conn, AsuntoForm asunto) {
		String destinatariosCc;
		String asuntoCc = asunto.getAsuntoIdsCC();
		
		if(asuntoCc != null){
			if(!asuntoCc.equals("")){
				if(!asuntoCc.equals("null")){
					StringTokenizer st = new StringTokenizer(asunto.getAsuntoIdsCC(), ",");
					StringBuffer sb = new StringBuffer();
					while (st.hasMoreElements()) {
						String id = st.nextToken();
						if (!id.equals("")){
							UsuarioBean usuario = AsuntoDao.getDestinatario(conn, Integer.parseInt(id));
							sb.append(usuario.getNombre());
							sb.append("/");
							sb.append(usuario.getCargo());
							sb.append("\n");
						}
					}
					destinatariosCc = sb.toString();
				}else{
					destinatariosCc = "";
				}
			}else{
				destinatariosCc = "";
			}
		}else{
			destinatariosCc = "";
		}
		return destinatariosCc;
	}	
	protected String getUsuarioT(Connection conn, AsuntoForm asunto) {
		String UsuarioT;
		int usuarioid = asunto.getidUsuarioTurna();
		StringBuffer sb = new StringBuffer();
		
		UsuarioBean usuario = AsuntoDao.getDestinatario(conn, usuarioid);
		sb.append(usuario.getNombre());
		/*sb.append("/");
		sb.append(usuario.getCargo());
		sb.append("\n");*/
		UsuarioT = sb.toString();
		return UsuarioT;
	}	

	protected String getUsuarioPE(Connection conn, AsuntoForm asunto) {
		String UsuarioPE;
		String usuarioid = asunto.getAsuntoIdsParaE();
		
		if(usuarioid != null){
			if(!usuarioid.equals("")){
				if(!usuarioid.equals("null")){
					StringTokenizer st = new StringTokenizer(asunto.getAsuntoIdsParaE(), ",");
					StringBuffer sb = new StringBuffer();
					//System.out.println("empieza1-"+asunto.getAsuntoIdsParaE()+"termina1");
					while (st.hasMoreElements()) {						
						String id = st.nextToken();						
						if (!id.equals("")){
							UsuarioBean usuario = AsuntoDao.getUsuarioExt(conn, Integer.parseInt(id));
							sb.append(usuario.getNombre());
						}
					}								
					UsuarioPE = sb.toString();
				}else{
					UsuarioPE = "";
				}
			}else{
				UsuarioPE = "";
			}
		}else{
			UsuarioPE = "";
		}
		return UsuarioPE;
	}	
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
	}

	protected String generaGrafica(HttpServletRequest request) {
		DefaultPieDataset datos = ((DefaultPieDataset) request.getSession()
				.getAttribute("datos"));
		File archivo = null;
		if (datos != null) {
			File dir = new File(request.getSession().getServletContext()
					.getRealPath("/")
					+ "temp/");
			if (!dir.exists()) {
				dir.mkdir();
			}
			archivo = new File(dir.getPath() + "/graficaTemp"
					+ new Date().getTime() + ".jpg");
			int heigth = 350 + (10 * datos.getItemCount());
			generaJPG(archivo, generaGraficaPie(datos, (String) request
					.getSession().getAttribute("titulo")), 600, heigth);

		}
		return archivo.getPath();
	}

	private void generaJPG(File archivoEscritura, JFreeChart grafica,
			int ancho, int alto) {
		try {
			ChartUtilities.saveChartAsJPEG(archivoEscritura, grafica, ancho,
					alto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private JFreeChart generaGraficaPie(DefaultPieDataset dataset, String titulo) {
		final JFreeChart chart = ChartFactory.createPieChart(titulo, dataset,
				true, true, false);
		return chart;
	}
}
