package com.meve.sigma.organizacional.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.xml.parser.v2.XMLOutputStream;

import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.meve.sigma.organizacional.vo.AreaVO;
import com.meve.sigma.organizacional.vo.PuestoVO;
import com.meve.sigma.quartz.EnviaAlertaInst;

public class EstructuraOrganizacionalAjax extends HttpServlet implements
		Servlet {

	private static final long serialVersionUID = 7724556329282328094L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion") != null ? request
				.getParameter("accion") : "";
		System.out.println("Accion: " + accion);
		if ("buscar".equals(accion)) {
			response.setContentType("text/xml");
			PrintWriter pw = response.getWriter();
			pw.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
			pw.write(buscarPuesto(request));
			pw.flush();
			pw.close();

		}else if("seleccionar".equals(accion)){
			response.setContentType("text/xml");
			PrintWriter pw = response.getWriter();
			pw.write(seleccionaPuesto(request));
			pw.flush();
			pw.close();
		}

	}

	private String buscarPuesto(HttpServletRequest request) {
		String cadenaBusqueda = request.getParameter("cadena");
		cadenaBusqueda = convierteHTML(cadenaBusqueda.toLowerCase());
		AreaVO area = (AreaVO) request.getSession().getAttribute("area");
		List puestos = area.getPuestos(true);
		StringBuffer sb = new StringBuffer("<usuarios>");
		if (cadenaBusqueda != null && !"".equals(cadenaBusqueda)) {
			for (int i = 0; i < puestos.size(); i++) {
				PuestoVO puesto = (PuestoVO) puestos.get(i);
				if (puesto.getNombre().toLowerCase().indexOf(cadenaBusqueda)!=-1) {
					sb.append("<usuario id = \" " + puesto.getIdUsuario()
							+ "\" nombre = \" ");
					sb.append(convierteHTML(puesto.getNombre()) + "\" />");
				}
			}
		}
		sb.append("</usuarios>");
		return sb.toString();

	}

	private String seleccionaPuesto(HttpServletRequest request) {
		int idUsuario = Integer.parseInt(request.getParameter("idPuesto"));
		AreaVO area = (AreaVO) request.getSession().getAttribute("area");
		List puestos = area.getPuestos(true);
		for(int i=0;i<puestos.size();i++){
			((PuestoVO)puestos.get(i)).setDesplegado(false);
			((PuestoVO)puestos.get(i)).setSeleccionado(false);
		}
		area.despliegaRutaPuesto(idUsuario);
		PuestoVO puesto = area.getPuesto(idUsuario);
		puesto.setSeleccionado(true);
		Document doc = new Document(area.getXML());
		Format format = Format.getPrettyFormat();
		format.setEncoding("iso-8859-1");
		XMLOutputter xmlOutputer =new XMLOutputter(format);
		return xmlOutputer.outputString(doc); 
	}

	protected String convierteHTML(String texto) {
		return texto.replaceAll("á", "a").replaceAll("é", "e").replaceAll("í",
				"i").replaceAll("ó", "o").replaceAll("ú", "u");
	}
}
