package com.meve.sigma.reporte;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jfree.data.general.DefaultPieDataset;

import com.meve.sigma.asunto.AsuntoForm;
import com.meve.sigma.asunto.AsuntoUtil;
import com.meve.sigma.asunto.dao.AsuntoDao;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.catalogos.Catalogos;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.instruccion.InstruccionForm;
import com.meve.sigma.instruccion.dao.InstruccionDao;
import com.meve.sigma.organizacional.EstructuraOrganizacional;
import com.meve.sigma.organizacional.vo.AreaVO;
import com.meve.util.ManejadorDeTablas;
import com.meve.util.WebApps;

public class ReporteAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ReporteForm rf = (ReporteForm) form;
		request.getSession().setAttribute("reporteForm", rf);
		String accion = rf.getAccion();
		String idLink = rf.getIdLink();
		WebApps.setOrden(request, ManejadorDeTablas.TABLE_MANAGER, accion,
				idLink);
		WebApps.setPaginacion(request, ManejadorDeTablas.TABLE_MANAGER, accion,
				idLink);
		if ("mostrarAsuntos".equals(accion)) {
			request.getSession().setAttribute("pantallaReporte",
					"reporteAsunto.jsp");
			request.getSession().setAttribute(ManejadorDeTablas.TABLE_MANAGER,
					null);
			rf.limpiaForm();
			return mapping.findForward("reporteador");
		}
		if ("mostrarInstrucciones".equals(accion)) {
			request.getSession().setAttribute("pantallaReporte",
					"reporteInstruccion.jsp");
			request.getSession().setAttribute(ManejadorDeTablas.TABLE_MANAGER,
					null);
			rf.limpiaForm();
			return mapping.findForward("reporteador");
		}
		if ("buscaAsuntos".equals(accion)) {
			return mapping.findForward(buscaAsuntos(request, rf));
		}
		if ("buscaInstrucciones".equals(accion)) {
			return mapping.findForward(buscaInstrucciones(request, rf));
		}
		return mapping.findForward("reporteador");
	}

	private String buscaAsuntos(HttpServletRequest request, ReporteForm rf) {
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			UsuarioBean BUsuario = (UsuarioBean) request.getSession()
					.getAttribute("UsuarioBean");
			rf.setEstatus(request.getParameterValues("estatus"));
			if (rf.getEstatus() == null) {
				rf.setEstatus(new String[] { "-1" });
			}
			// if(rf.getEstatusOtrasVentanillas()==null){
			// rf.setEstatusOtrasVentanillas(new String[]{"-1"});
			// }
			if (rf.isTotales()) {
				List datos = AsuntoDao.getReporteAsuntoTotales(conn, rf,
						Integer.parseInt(BUsuario.getIdArea()));
				DefaultPieDataset datosGrafica = new DefaultPieDataset();
				for (int i = 0; i < datos.size(); i++) {
					datosGrafica.setValue(((AsuntoForm) datos.get(i))
							.getEstatusNombre(), ((AsuntoForm) datos.get(i))
							.getTotalPorEstatus());
				}
				List datosOV = new ArrayList();
				if (request.getParameter("otrasVentanillas") != null) {

					datosOV = AsuntoDao.getReporteOtrasVentanillasTotales(conn,
							rf, Integer.parseInt(BUsuario.getIdArea()));
					for (int i = 0; i < datosOV.size(); i++) {
						datosGrafica.setValue(((AsuntoForm) datosOV.get(i))
								.getEstatusNombre()
								+ " Otras Ventanillas", ((AsuntoForm) datosOV
								.get(i)).getTotalPorEstatus());

					}
					datos.addAll(datosOV);
				} else {
					rf.setOtrasVentanillas(false);
				}

				request.getSession().setAttribute("titulo",
						"Asuntos por Estatus");
				ManejadorDeTablas tm = new ManejadorDeTablas();
				tm.setRegistros(datos);
				tm.setAtributos(AsuntoForm.getAtributosTotales());
				tm.setOrden(AsuntoForm.getOrden());
				tm.setPaginaActual(0);
				tm.setRegistrosPorPagina(20);
				request.getSession().setAttribute(
						ManejadorDeTablas.TABLE_MANAGER, tm);
				request.getSession().setAttribute("datos", datosGrafica);
				request.getSession().setAttribute("reporte",
						String.valueOf(GeneraReporte.REPORTE_ASUNTOS_TOTALES));
				String criterriosBusqueda = "De " + rf.getFechaInicial()
						+ " al " + rf.getFechaFinal();
				request.getSession().setAttribute("criteriosBusqueda",
						criterriosBusqueda);
			} else {
				List asuntos = AsuntoDao.getReporteAsuntoDetalle(conn, rf,
						Integer.parseInt(BUsuario.getIdArea()));
				if (request.getParameter("otrasVentanillas") != null) {
					asuntos.addAll(AsuntoDao.getReporteOtrasVentanillasDetalle(
							conn, rf, Integer.parseInt(BUsuario.getIdArea())));
				} else {
					rf.setOtrasVentanillas(false);
				}
				AsuntoUtil.setCatalogos(request, asuntos);
				ManejadorDeTablas tm = new ManejadorDeTablas();
				tm.setRegistros(asuntos);
				tm.setAtributos(AsuntoForm.getAtributos());
				tm.setEncabezados(AsuntoForm.getEncabezados());
				tm.setOrden(AsuntoForm.getOrden());
				tm.setPaginaActual(0);
				tm.setRegistrosPorPagina(20);
				request.getSession().setAttribute(
						ManejadorDeTablas.TABLE_MANAGER, tm);
				request.getSession().setAttribute("reporte",
						String.valueOf(GeneraReporte.REPORTE_ASUNTOS));
				String criterriosBusqueda = "De " + rf.getFechaInicial()
						+ " al " + rf.getFechaFinal();
				request.getSession().setAttribute("criteriosBusqueda",
						criterriosBusqueda);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return "reporteador";
	}

	private String buscaInstrucciones(HttpServletRequest request, ReporteForm rf) {
		rf
				.setMuestraSubordinados(request
						.getParameter("muestraSubordinados") != null);
		EstructuraOrganizacional eOrg = (EstructuraOrganizacional) request
				.getSession().getServletContext().getAttribute(
						Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL);
		String[] idSubordinados = rf.getSubordinados();
		UsuarioBean usuario = (UsuarioBean) request.getSession().getAttribute(
				"UsuarioBean");
		AreaVO area = (AreaVO)request.getSession().getAttribute("area");
		if(area!=null){
			if (idSubordinados != null) {
				for (int i = 0; i < idSubordinados.length; i++) {
					area.despliegaRutaPuesto(Integer.parseInt(idSubordinados[i]));
				}
			}
		}
		
		if (rf.isTotales()) {
			Connection conn = null;
			try {
				conn = ConexionDS.getConexion();
				List totales = InstruccionDao.getReporteInstruccionTotales(
						conn, Integer.parseInt(usuario.getStrIdUsuario()), rf);
				DefaultPieDataset datosGrafica = new DefaultPieDataset();
				for (int i = 0; i < totales.size(); i++) {
					datosGrafica.setValue(((InstruccionForm) totales.get(i))
							.getEstatusNombre()
							+ "-"
							+ ((InstruccionForm) totales.get(i))
									.getUsuarioNombre(),
							((InstruccionForm) totales.get(i))
									.getTotalPorEstatus());
				}
				ManejadorDeTablas tm = new ManejadorDeTablas();
				tm.setRegistros(totales);
				tm.setAtributos(InstruccionForm.getAtributosTotales());
				tm.setOrden(InstruccionForm.getOrden());
				tm.setPaginaActual(0);
				tm.setRegistrosPorPagina(20);
				request.getSession().setAttribute(
						ManejadorDeTablas.TABLE_MANAGER, tm);
				request.getSession().setAttribute("datos", datosGrafica);
				request
						.getSession()
						.setAttribute(
								"reporte",
								String
										.valueOf(GeneraReporte.REPORTE_INSTRUCCIONES_TOTALES));
				String criterriosBusqueda = "De " + rf.getFechaInicial()
						+ " al " + rf.getFechaFinal();
				request.getSession().setAttribute("criteriosBusqueda",
						criterriosBusqueda);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
				ConexionDS.endConnection(null, null, conn);
			}
		} else {
			Connection conn = null;
			UsuarioBean BUsuario = (UsuarioBean) request.getSession()
					.getAttribute("UsuarioBean");
			try {
				conn = ConexionDS.getConexion();
				List instrucciones = InstruccionDao
						.getReporteInstruccionDetalle(conn, Integer
								.parseInt(BUsuario.getStrIdUsuario()), rf);
				ManejadorDeTablas tm = new ManejadorDeTablas();
				tm.setRegistros(instrucciones);
				tm.setAtributos(InstruccionForm.getAtributos());
				tm.setEncabezados(InstruccionForm.getEncabezados());
				tm.setOrden(InstruccionForm.getOrden());
				tm.setPaginaActual(0);
				tm.setRegistrosPorPagina(20);
				request.getSession().setAttribute(
						ManejadorDeTablas.TABLE_MANAGER, tm);
				request.getSession().setAttribute("reporte",
						String.valueOf(GeneraReporte.REPORTE_INSTRUCCIONES));
				String criterriosBusqueda = "De " + rf.getFechaInicial()
						+ " al " + rf.getFechaFinal();
				request.getSession().setAttribute("criteriosBusqueda",
						criterriosBusqueda);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
				ConexionDS.endConnection(null, null, conn);
			}
		}
		return "reporteador";
	}
}
