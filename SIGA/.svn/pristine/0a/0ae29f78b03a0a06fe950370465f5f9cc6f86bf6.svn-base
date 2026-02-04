package com.meve.sigma.organizacional;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.meve.sigma.catalogos.CatalogoRol;
import com.meve.sigma.catalogos.Catalogos;
import com.meve.sigma.organizacional.vo.AreaVO;
import com.meve.sigma.organizacional.vo.PuestoVO;
import com.meve.sigma.util.HistorialPagina;
import com.meve.util.ManejadorDeTablas;
import com.meve.util.WebApps;

public class EstructuraOrganizacionalAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		EstructuraOrganizacionalForm eof = (EstructuraOrganizacionalForm) form;
		String accion = request.getParameter("accion");
		String idLink = request.getParameter("idLink");
		if ("mostrar".equals(accion)) {
			return mapping.findForward(mostrarEstructuraOrganizacional(request,
					eof, idLink));
		}
		if ("mostrarPorRoles".equals(accion)) {
			return mapping.findForward(mostrarEstructuraPorRoles(request,
					idLink, eof));
		}
		if ("regresar".equals(accion)) {
			return mapping.findForward("estructuraOrganizaiconal");
		}
		return mapping.findForward("estructuraOrganizacionalPorRoles");
	}

	private String mostrarEstructuraOrganizacional(HttpServletRequest request,
			EstructuraOrganizacionalForm eof, String idLink) {
		HistorialPagina historial = (HistorialPagina) request.getSession()
				.getAttribute("historial");
		if (historial == null) {
			historial = new HistorialPagina();
			request.getSession().setAttribute("historial", historial);
		}
		int idArea = idLink != null ? Integer.parseInt(idLink) : 0;
		EstructuraOrganizacional eOrg = (EstructuraOrganizacional) request
				.getSession().getServletContext().getAttribute(
						Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL);
		List areas = eOrg.getAreas(true);
		WebApps.ordenaLista(areas, "nombre", false);
		request.getSession().setAttribute("areas", areas);
		AreaVO area = eOrg.getArea(idArea);
		request.getSession().setAttribute("area", area);
		eof.setIdArea(area.getIdArea());
		eof.setAreaNombre(area.getNombreHTML());
		PuestoVO responsable = area.getPuesto(area.getIdResponsable());
		if (responsable != null) {
			eof.setIdResponsable(responsable.getIdUsuario());
			eof.setResponsableNombre(responsable.getNombre());
			eof.setCargoNombre(responsable.getCargo());
		} else {
			eof.setIdResponsable(-1);
			eof.setResponsableNombre("No se ha asignado a ningun responsable");
			eof.setCargoNombre("");
		}
		historial.setPagina("estructuraOrganizacional", "mostrar", idLink);
		return "estructuraOrganizacional";
	}

	private String mostrarEstructuraPorRoles(HttpServletRequest request,
			String idLink, EstructuraOrganizacionalForm eof) {
		EstructuraOrganizacional eOrg = (EstructuraOrganizacional) request
				.getSession().getServletContext().getAttribute(
						Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL);
		AreaVO area = eOrg.getArea(eof.getIdArea());
		request.getSession().setAttribute("area", area);
		List roles = (List) request.getSession().getServletContext()
				.getAttribute(Catalogos.CATALOGO_ROL);
		for (int i = 0; i < roles.size(); i++) {
			CatalogoRol rol = (CatalogoRol) roles.get(i);
			ManejadorDeTablas tm = new ManejadorDeTablas();
			tm.setRegistros(area.getPuestosPorRol(rol.getId()));
			tm.setAtributos(new String[] { "cargo", "nombre" });
			tm.setOrden(new String[] { "asc", "asc" });
			tm.setPaginaActual(0);
			tm.setRegistrosPorPagina(20);
			request.getSession().setAttribute(
					ManejadorDeTablas.TABLE_MANAGER + "_" + rol.getId(), tm);
		}
		HistorialPagina historial = (HistorialPagina) request.getSession()
				.getAttribute("historial");
		if (historial == null) {
			historial = new HistorialPagina();
			request.getSession().setAttribute("historial", historial);
		}
		historial.setPagina("estructuraOrganizacional", "mostrarPorRoles",
				idLink);
		return "estructuraOrganizacionalPorRoles";
	}

	private void Ordena(HttpServletRequest request, String accion, String idLink) {
		List roles = (List) request.getSession().getServletContext()
				.getAttribute(Catalogos.CATALOGO_ROL);
		for (int i = 0; i < roles.size(); i++) {
			WebApps.setOrden(request, ManejadorDeTablas.TABLE_MANAGER, accion,
					idLink);
		}
	
	}
}
