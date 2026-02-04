package com.meve.sigma.asunto;

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

import HTTPClient.Request;

import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.catalogos.CatalogoArea;
import com.meve.sigma.catalogos.CatalogoEntidad;
import com.meve.sigma.catalogos.dao.CatalogoDao;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.util.HistorialPagina;

public class AsuntoAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		AsuntoForm af = (AsuntoForm) form;
		String accion = request.getParameter("accion");
		String idLink = request.getParameter("idLink");
		if (af.getTipoAsunto() == null || "".equals(af.getTipoAsunto().trim())) {
			af.setTipoAsunto("Por Asignar");
		}
		if ("nuevoAsunto".equals(accion)) {
			return mapping.findForward(nuevoAsunto(af));
		} else if ("directorio".equals(accion)) {
			if ("cargaInternos".equals(idLink)) {
				af.setCadenaBusqueda("");
				return mapping.findForward(cargaInternas(af, request));
			}
			if ("cargaExternos".equals(idLink)) {
				af.setCadenaBusqueda("");
				return mapping.findForward(cargaExternas(af, request));
			}
			if ("buscaInternos".equals(idLink)) {
				return mapping.findForward(cargaInternas(af, request));
			}
			if ("buscaExternos".equals(idLink)) {
				return mapping.findForward(cargaExternas(af, request));
			}
			if ("guardaArea".equals(idLink)) {
				return mapping.findForward(guardaArea(af, request));
			}
			if ("nuevaEntidad".equals(idLink)) {
				return mapping.findForward(cargaNuevaEntidad(request));
			}
			return mapping.findForward("directorio");
		} else if ("remitentes".equals(accion)) {
			if ("cargaRemitentes".equals(idLink)) {
				if (af.getCadenaBusqueda() == null) {
					af.setCadenaBusqueda("");
				}
				if (af.getSegundaCadenaBusqueda() == null) {
					af.setSegundaCadenaBusqueda("");
				}
				return mapping.findForward(cargaRemitentes(request, af));
			}
			if ("guardaRemitente".equals(idLink)) {
				return mapping.findForward(guardaRemitente(request, af));
			}
			if ("nuevoRemitente".equals(idLink)) {
				return mapping.findForward(cargaNuevoRemitente(request));
			}
		}
		return mapping.findForward("captura");
	}

	protected String nuevoAsunto(AsuntoForm af) {
		af.setTipoAsunto("Por Asignar");
		return "captura";
	}

	protected String cargaInternas(AsuntoForm af, HttpServletRequest request) {
		HistorialPagina historial = (HistorialPagina) request.getSession()
				.getAttribute("HistorialDirectorio");
		if (historial == null) {
			historial = new HistorialPagina();
			request.getSession().setAttribute("HistorialDirectorio", historial);
		}
		historial.setPagina("directorio", "directorio", "cargaInternos");
		af.setIdEntidad(-1);
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			request.getSession().setAttribute("externas", null);
			request.getSession().setAttribute("tipoEntidades", "internas");
			request.getSession().setAttribute(
					"unidades",
					CatalogoDao.getEntidadesInternas(conn, af
							.getCadenaBusqueda(), "1", "asc"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return "directorio";
	}

	protected String cargaExternas(AsuntoForm af, HttpServletRequest request) {
		HistorialPagina historial = (HistorialPagina) request.getSession()
				.getAttribute("HistorialDirectorio");
		if (historial == null) {
			historial = new HistorialPagina();
			request.getSession().setAttribute("HistorialDirectorio", historial);
		}
		historial.setPagina("directorio", "directorio", "cargaExternos");
		af.setIdArea(-1);
		Connection conn = null;
		UsuarioBean BUsuario = (UsuarioBean) request.getSession().getAttribute(
				"UsuarioBean");
		request.getSession().setAttribute("unidades", null);
		request.getSession().setAttribute("tipoEntidades", "externas");
		try {
			conn = ConexionDS.getConexion();
			request.getSession().setAttribute(
					"externas",
					CatalogoDao.getEntidadesExternas(conn, af
							.getCadenaBusqueda(), "1", "asc", Integer
							.parseInt(BUsuario.getIdArea())));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return "directorio";
	}

	protected String guardaArea(AsuntoForm af, HttpServletRequest request) {
		HistorialPagina historial = (HistorialPagina) request.getSession()
				.getAttribute("HistorialDirectorio");
		if (historial == null) {
			historial = new HistorialPagina();
			request.getSession().setAttribute("HistorialDirectorio", historial);
		}
		historial.setPagina("submit", "directorio", "guardaArea");

		AsuntoForm afReal = (AsuntoForm) request.getSession().getAttribute(
				"asuntoForm");
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			request.getSession().setAttribute("tipoEntidades", null);
			if (af.getIdArea() != -1) {
				request.getSession().setAttribute("tipoEntidad", "internas");
				request.getSession().setAttribute("idArea",
						String.valueOf(af.getIdArea()));
				afReal.setArea(CatalogoDao.getArea(conn, af.getIdArea())
						.getNombre());
				afReal.setIdArea(af.getIdArea());
				UsuarioBean BUsuario = (UsuarioBean) request.getSession()
						.getAttribute("UsuarioBean");
				if (afReal.getIdArea() == Integer
						.parseInt(BUsuario.getIdArea())) {
					afReal.setTipoAsunto("Salida");
				} else {
					afReal.setTipoAsunto("Entrada");
				}
			}
			if (af.getIdEntidad() != -1) {
				request.getSession().setAttribute("tipoEntidad", "externas");
				request.getSession().setAttribute("idEntidad",
						String.valueOf(af.getIdEntidad()));
				afReal.setEntidad(CatalogoDao.getEntidad(conn,
						af.getIdEntidad()).getNombre());
				afReal.setIdEntidad(af.getIdEntidad());
				afReal.setTipoAsunto("Entrada");
			}
			afReal.setRemitenteNombre("");
			afReal.setPuesto("");
			request.getSession().setAttribute("asuntoForm", afReal);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return "submit";
	}

	protected String cargaNuevaEntidad(HttpServletRequest request) {
		HistorialPagina historial = (HistorialPagina) request.getSession()
				.getAttribute("HistorialDirectorio");
		if (historial == null) {
			historial = new HistorialPagina();
			request.getSession().setAttribute("HistorialDirectorio", historial);
		}
		historial.setPagina("nuevaEntidad", "directorio", "nuevaEntidad");
		UsuarioBean BUsuario = (UsuarioBean) request.getSession().getAttribute(
				"UsuarioBean");
		BUsuario.getIdArea();
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			List areas = new ArrayList();
			areas.add(CatalogoDao.getArea(conn, Integer.parseInt(BUsuario
					.getIdArea())));
			request.getSession().setAttribute("catalogoArea", areas);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return "nuevaEntidad";
	}

	public String cargaRemitentes(HttpServletRequest request, AsuntoForm af) {
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			List remitentes = new ArrayList();
			if ("internas".equals(request.getSession().getAttribute(
					"tipoEntidad"))) {
				remitentes = CatalogoDao.getRemitentesInternos(conn, Integer
						.parseInt(request.getSession().getAttribute("idArea")
								.toString()), af.getCadenaBusqueda(), af
						.getSegundaCadenaBusqueda());
			} else if ("externas".equals(request.getSession().getAttribute(
					"tipoEntidad"))) {
				remitentes = CatalogoDao.getRemitentesExternos(conn, Integer
						.parseInt(request.getSession()
								.getAttribute("idEntidad").toString()), af
						.getCadenaBusqueda(), af.getSegundaCadenaBusqueda());
			}
			
			request.getSession().setAttribute("remitentes", remitentes);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}

		return "remitentes";
	}

	public String guardaRemitente(HttpServletRequest request, AsuntoForm af) {
		Connection conn = null;
		AsuntoForm afReal = (AsuntoForm) request.getSession().getAttribute(
				"asuntoForm");
		try {
			conn = ConexionDS.getConexion();
			if ("internas".equals(request.getSession().getAttribute(
					"tipoEntidad"))) {
				UsuarioBean remitente = CatalogoDao.getRemitenteInterno(conn,
						af.getIdRemitente());
				afReal.setRemitenteNombre(remitente.getNombre());
				afReal.setPuesto(remitente.getCargo());				
				afReal.setIdRemitente(af.getIdRemitente());
			} else {
				UsuarioBean remitente = CatalogoDao.getRemitenteExterno(conn,
						af.getIdRemitente());
				afReal.setRemitenteNombre(remitente.getNombre());				
				afReal.setPuesto("/" + remitente.getCargo());
				afReal.setIdRemitente(af.getIdRemitente());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("asuntoForm", afReal);
		return "submit";
	}

	protected String cargaNuevoRemitente(HttpServletRequest request) {
		HistorialPagina historial = (HistorialPagina) request.getSession()
				.getAttribute("HistorialRemitente");
		if (historial == null) {
			historial = new HistorialPagina();
			request.getSession().setAttribute("HistorialRemitente", historial);
		}
		historial.setPagina("nuevoRemitente", "remitentes", "nuevoRemitente");
		UsuarioBean BUsuario = (UsuarioBean) request.getSession().getAttribute(
				"UsuarioBean");
		BUsuario.getIdArea();
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			List areas = new ArrayList();
			areas.add(CatalogoDao.getArea(conn, Integer.parseInt(BUsuario
					.getIdArea())));
			request.getSession().setAttribute("catalogoArea", areas);
			request.getSession().setAttribute("catalogoEntidad",
					CatalogoDao.getEntidadesPorArea(conn, Integer.parseInt(BUsuario.getIdArea())));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return "nuevoRemitente";
	}

}
