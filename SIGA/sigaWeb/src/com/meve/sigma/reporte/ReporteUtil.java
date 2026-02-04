package com.meve.sigma.reporte;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXmlExporterParameter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;

import org.jdom.Element;

import com.meve.sigma.beans.ConfiguracionBean;
import com.meve.sigma.catalogos.Catalogos;
import com.meve.sigma.organizacional.EstructuraOrganizacional;
import com.meve.sigma.organizacional.vo.AreaVO;
import com.meve.sigma.organizacional.vo.AsistenteVO;
import com.meve.sigma.organizacional.vo.PuestoVO;
import com.meve.sigma.util.Converters;
import com.meve.util.DiasInhabilesManager;

/**
 * Clase que contiene utilerias para generar los reportes
 * 
 * @author Meve Soluciones, S. A.
 * 
 */

public class ReporteUtil {

	public static byte[] exportReportToBytes(JasperPrint jasperPrint,
			JRXlsExporter exporter, HttpServletRequest request) throws JRException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("http://localhost:" + request.getServerPort()
		+ request.getContextPath() + "/JasperPrint.dtd"));
		exporter.exportReport();
/*
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporter.setParameter(JRXmlExporterParameter.OUTPUT_FILE,
				"http://localhost:" + request.getServerPort()
						+ request.getContextPath() + "/JasperPrint.dtd");*/
		exporter.exportReport();
		return baos.toByteArray();
	}

	public static String getSubordinadosHTML(HttpServletRequest request,
			int idUsuario, ReporteForm rf) {
		EstructuraOrganizacional eOrg = (EstructuraOrganizacional) request
				.getSession().getServletContext().getAttribute(
						Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL);
		AreaVO area = (AreaVO) request.getSession().getAttribute("area");//TODO: talvez deberia de subir el area desde que el usuario se loguea
		if (area == null) {
			area = eOrg.getArea(eOrg.getPuesto(idUsuario).getIdArea());
		}
		PuestoVO puesto = area.getPuesto(idUsuario);
		area.setHabilitaArea(false);
		if (area.isAsistente(idUsuario)) {
			AsistenteVO asistente = area.getAsistente(idUsuario);
			List asistidos = asistente.getAsistidos();
			for (int i = 0; i < asistidos.size(); i++) {
				PuestoVO asistido = area
						.getPuesto(((PuestoVO) asistidos.get(i)).getIdUsuario());
				asistido.setHabilitado(true);
				asistido.setSeleccionado(true);
				area.despliegaRutaPuesto(asistido.getIdUsuario());
			}
		} else {
			area.despliegaRutaPuesto(puesto.getIdUsuario());
			puesto.setHabilitado(true);
			puesto.setSeleccionado(true);
		}
		Element input = new Element("INPUT");
		input.setAttribute("type", "checkbox");
		input.setAttribute("name", "subordinados");
		Element table = new Element("TABLE");
		Element tr = new Element("TR");
		Element td1 = new Element("TD");
		td1.addContent(area.getOrganigramaPrincipalHTML(input));
		tr.addContent(td1);
		table.addContent(tr);
		request.getSession().setAttribute("area", area);
		return Converters.convertElementToString(table);
	}

	public static int getSemaforo(Connection conn, long fechaInicio,
			long fechaFin) {
		int iSAmarillo = 70;
		ConfiguracionBean config = com.meve.sigma.actualiza.ActualizaConfiguracion
				.getDatosConf(conn);// TODO:Hacer tabla de parametros y subirlos
		// a contexto
		if (config != null) {
			iSAmarillo = config.getSemaforoPorcentajeAmarillo();
		}
		DiasInhabilesManager dim = new DiasInhabilesManager(new ArrayList());
		return dim.getSemaforo(iSAmarillo, fechaInicio, fechaFin);

	}

}
