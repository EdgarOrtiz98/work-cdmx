package com.meve.sigma.organizacional.puesto;

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

import com.meve.sigma.actualiza.ActualizaAutentificacion;
import com.meve.sigma.actualiza.ActualizaBitacora;
import com.meve.sigma.actualiza.ActualizaParamCorreo;
import com.meve.sigma.actualiza.ActualizaRol;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.catalogos.CatalogoRol;
import com.meve.sigma.catalogos.Catalogos;
import com.meve.sigma.catalogos.dao.RolDao;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.organizacional.EstructuraOrganizacional;
import com.meve.sigma.organizacional.dao.EstructuraOrganizacionalDao;
import com.meve.sigma.organizacional.vo.AreaVO;
import com.meve.sigma.organizacional.vo.AsistenteVO;
import com.meve.sigma.organizacional.vo.PuestoVO;
import com.meve.sigma.util.HistorialPagina;
import com.meve.sigma.util.Pagina;
import com.meve.util.WebApps;

public class PuestoAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HistorialPagina historial = (HistorialPagina) request.getSession()
				.getAttribute("historial");
		if (historial == null) {
			historial = new HistorialPagina();
			request.getSession().setAttribute("historial", historial);
		}
		PuestoForm pf = (PuestoForm) form;
		String accion = pf.getAccion();
		String idLink = pf.getIdLink();
		System.out.println("Accion: " + accion);
		System.out.println("idLink: " + idLink);
		if ("mostrarPuesto".equals(accion)) {
			historial.setPagina("puesto", accion, idLink);
			request.getSession().setAttribute("historial", historial);
			return mapping.findForward(mostrarPuesto(pf, request, Integer
					.parseInt(idLink)));
		}
		if ("nuevoPuesto".equals(accion)) {
			if ("mostrar".equals(idLink)) {
				return mapping.findForward(muestraNuevoPuesto(pf, request));
			}
			if ("seleccionaArea".equals(idLink)) {
				return mapping.findForward(seleccionaArea(request, pf));
			}
			if ("guardar".equals(idLink)) {
				String sigPag = insertarPuesto(pf, request);
				return mapping.findForward(sigPag);
			}
		}
		if ("modificarPuesto".equals(accion)) {
			if ("mostrar".equals(idLink)) {
				return mapping.findForward(muestraModificarPuesto(pf, request));
			}
			if ("seleccionaArea".equals(idLink)) {
				return mapping.findForward(seleccionaArea(request, pf));
			}
			if ("guardar".equals(idLink)) {
				System.out.println("Se esta modificando un puesto...");
				System.out.println(pf.toString());
			}
		}
		if ("regresar".equals(accion)) {
			Pagina paginaAnterior = historial.getPaginaAnterior();
			if ("puesto".equals(paginaAnterior.getPagina())) {
				return mapping.findForward(mostrarPuesto(pf, request, Integer
						.parseInt(paginaAnterior.getIdLink())));
			}
			if ("estructuraOrganizacional".equals(paginaAnterior.getPagina())) {
				if ("mostrar".equals(paginaAnterior.getAccion())) {
					return mapping.findForward("estructuraOrganizacional");
				} else {
					return mapping
							.findForward("estructuraOrganizacionalPorRoles");
				}
			}
			return mapping.findForward(paginaAnterior.getPagina());
		}
		return mapping.findForward("estructuraOrganizacional");

	}

	private String mostrarPuesto(PuestoForm pf, HttpServletRequest request,
			int idUsuario) {
		AreaVO area = (AreaVO) request.getSession().getAttribute("area");
		PuestoVO puesto = area.getPuesto(idUsuario);
		pf.setIdPuesto(puesto.getIdUsuario());
		pf.setResponsable(puesto.getNombre());
		pf.setPuesto(puesto.getCargo());
		pf.setUnidadAdministrativa(area.getNombre());
		pf.setCompanieros(area.getCompanieros(idUsuario));
		List asistentes = puesto.getAsistentes();
		WebApps.ordenaLista(asistentes, "cargo", false);
		pf.setAsistentes(asistentes);
		List subordinados = new ArrayList();
		subordinados.add(puesto);
		pf.setSubordinados(subordinados);
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			pf.setRoles(RolDao.getRoles(idUsuario, conn));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return "puesto";
	}

	private String muestraNuevoPuesto(PuestoForm pf, HttpServletRequest request) {
		EstructuraOrganizacional eOrg = (EstructuraOrganizacional) request
				.getSession().getServletContext().getAttribute(
						Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL);
		List areas = eOrg.getAreas(true);
		WebApps.ordenaLista(areas, "nombre", false);
		request.getSession().setAttribute("areas", areas);
		HistorialPagina historial = (HistorialPagina) request.getSession()
				.getAttribute("historial");
		historial.setPagina("puestoEdicion", pf.getAccion(), pf.getIdLink());
		pf.limpiarForm();
		return "puestoEdicion";
	}

	private String muestraModificarPuesto(PuestoForm pf,
			HttpServletRequest request) {
		EstructuraOrganizacional eOrg = (EstructuraOrganizacional) request
				.getSession().getServletContext().getAttribute(
						Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL);
		List areas = eOrg.getAreas(true);
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			EstructuraOrganizacionalDao.setPuesto(conn, pf.getIdPuesto(), pf);
			seleccionaArea(request, pf);
			PuestoVO puesto = eOrg.getPuesto(pf.getIdPuesto());
			List asistentes = puesto.getAsistentes();
			String[] idAsistentes = new String[asistentes.size()];
			for (int i = 0; i < asistentes.size(); i++) {
				idAsistentes[i] = String.valueOf(((AsistenteVO) asistentes
						.get(i)).getIdUsuario());
			}
			pf.setIdAsistentes(idAsistentes);
			WebApps.ordenaLista(areas, "nombre", false);
			request.getSession().setAttribute("areas", areas);
			HistorialPagina historial = (HistorialPagina) request.getSession()
					.getAttribute("historial");
			historial
					.setPagina("puestoEdicion", pf.getAccion(), pf.getIdLink());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return "puestoEdicion";
	}

	private String seleccionaArea(HttpServletRequest request, PuestoForm pf) {
		AreaVO area = null;
		EstructuraOrganizacional eOrg = (EstructuraOrganizacional) request
				.getSession().getServletContext().getAttribute(
						Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL);
		if (pf.getIdUnidadAdministrativa() != -1) {
			area = eOrg.getArea(pf.getIdUnidadAdministrativa());
			List puestos = area.getPuestos(true);
			WebApps.ordenaLista(puestos, "cargo", false);
			request.getSession().setAttribute("puestos", puestos);
			List puestosAtencion = area
					.getPuestosPorRol(CatalogoRol.ROL_ATENCION);
			request.getSession().setAttribute("puestosAtencion",
					puestosAtencion);
			if (area.getIdAreaPadre() != -1) {
				request.getSession().setAttribute("puestosPadre",
						eOrg.getArea(area.getIdAreaPadre()).getPuestos(true));
			} else {
				request.getSession().setAttribute("puestosPadre",
						new ArrayList());
			}
			pf.setAsistentes(area.getAsistentes());

		}
		return "puestoEdicion";
	}

	private synchronized String insertarPuesto(PuestoForm pf,
			HttpServletRequest request) {
		PuestoVO puesto = new PuestoVO();
		puesto.setIdArea(pf.getIdUnidadAdministrativa());
		puesto.setNombre(pf.getResponsable());
		puesto.setCargo(pf.getPuesto());
		puesto.setIdJefe(pf.getIdJefe());
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			conn.setAutoCommit(false);
			if (EstructuraOrganizacionalDao.insertaUsuario(pf, conn)) {
				System.out.println("PuestoForm: " + pf.toString());
				if (ActualizaBitacora.InsertarEventoAltaPuesto(
						pf.getIdPuesto(), pf, conn)) {
					if (ActualizaAutentificacion.insertarDatosUsuario(pf
							.getUsuario(), pf.getPassword(), conn)) {
						if (ActualizaRol.insertaRolUsuario(pf.getIdPuesto(), pf
								.getIdRoles(), conn)) {
							if (ActualizaParamCorreo.insertaParamCorreo(pf
									.getIdPuesto(), pf.getIdCorreosSalida(),
									conn)) {
								if (EstructuraOrganizacionalDao
										.asignaAsistentes(pf, conn)) {
									System.out.println("Asistentes: "
											+ pf.getIdAsistentes().length);
									// conn.commit();
									conn.rollback();
									request
											.getSession()
											.getServletContext()
											.setAttribute(
													Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL,
													new EstructuraOrganizacional(
															conn));
									System.out.println("Termino");
								} else {
									System.out
											.println("Error dando de Alta Asistentes");
									conn.rollback();
								}
							} else {
								System.out
										.println("Error dando de Alta Correos");
								conn.rollback();
							}
						} else {
							System.out.println("Error dando de Alta Roles");
							conn.rollback();
						}
					} else {
						System.out
								.println("Error dando de Alta Datos del Usuario");
						conn.rollback();
					}
				} else {
					System.out.println("Error dando de Alta en Bitacora");
					conn.rollback();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		pf.limpiarForm();
		return "estructuraOrganizacional";
	}
}
