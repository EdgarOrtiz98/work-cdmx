package com.meve.sigma.graficas;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Graficas extends HttpServlet implements Servlet {

	public final static int GRAFICA_PIE = 1;
	public final static int GRAFICA_BARRAS = 2;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		switch (tipo) {
		case GRAFICA_PIE:
			DefaultPieDataset datos = ((DefaultPieDataset) request.getSession()
					.getAttribute("datos"));
			if (datos != null) {
				response.setContentType("image/jpeg");
				ServletOutputStream sos = response.getOutputStream();
				try {
					int heigth = 350+(10*datos.getItemCount());
					generaJPG(sos, generaGraficaPie(datos,(String)request.getSession().getAttribute("titulo")), 600, heigth);
				} finally {
					sos.flush();
					sos.close();
				}

			}
			break;

		default:
			break;
		}

	}

	private void generaJPG(OutputStream salida, JFreeChart grafica, int ancho,
			int alto) {
		try {
			ChartUtilities.writeChartAsJPEG(salida, grafica, ancho, alto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void generaJPG(File archivoEscritura, JFreeChart grafica,
			int ancho, int alto, boolean tipo) {
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
