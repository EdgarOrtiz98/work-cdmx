package com.meve.sigma.asunto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.meve.sigma.catalogos.CatalogoPrioridad;
import com.meve.sigma.catalogos.CatalogoTipoAsunto;
import com.meve.sigma.catalogos.CatalogoTipoDocumento;
import com.meve.sigma.catalogos.CatalogoTramite;
import com.meve.sigma.catalogos.CatalogoUtil;
import com.meve.sigma.catalogos.Catalogos;
import com.meve.sigma.organizacional.EstructuraOrganizacional;
import com.meve.sigma.organizacional.vo.AreaVO;
import com.meve.sigma.organizacional.vo.PuestoVO;

public class AsuntoUtil {

	public static void setCatalogos(HttpServletRequest request, List asuntos) {
		List catalogoTramite = (List) request.getSession().getServletContext()
				.getAttribute(Catalogos.CATALOGO_TRAMITE);
		List catalogoPrioridad = (List) request.getSession()
				.getServletContext().getAttribute(Catalogos.CATALOGO_PRIORIDAD);
		List catalogoTipoAsunto = (List) request.getSession()
				.getServletContext().getAttribute(
						Catalogos.CATALOGO_TIPO_ASUNTO);
		List catalogoTipoDocumento = (List) request.getSession()
				.getServletContext().getAttribute(
						Catalogos.CATALOGO_TIPO_DOCUMENTO);
		EstructuraOrganizacional eOrg = (EstructuraOrganizacional) request
				.getSession().getServletContext().getAttribute(
						Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL);
		for (int i = 0; i < asuntos.size(); i++) {
			AsuntoForm asunto = (AsuntoForm) asuntos.get(i);
			CatalogoTramite tramite = (CatalogoTramite) CatalogoUtil
					.getCatalogo(catalogoTramite, asunto.getIdTramite());
			CatalogoPrioridad prioridad = (CatalogoPrioridad) CatalogoUtil
					.getCatalogo(catalogoPrioridad, asunto.getIdPrioridad());
			CatalogoTipoAsunto tipoAsunto = (CatalogoTipoAsunto) CatalogoUtil
					.getCatalogo(catalogoTipoAsunto, asunto.getIdTipoAsunto());
			CatalogoTipoDocumento tipoDocumento = (CatalogoTipoDocumento) CatalogoUtil
					.getCatalogo(catalogoTipoDocumento, asunto
							.getIdTipoDocumento());
			asunto.setTramiteNombre(tramite != null ? tramite.getNombre(): "Sin Trámite");
			asunto.setPrioridadNombre(prioridad != null ? prioridad.getNombre(): "");
			asunto.setTipoAsuntoNombre(tipoAsunto != null ? tipoAsunto.getNombre() : "");
			asunto.setTipoDocto(tipoDocumento != null ? tipoDocumento.getNombre() : "");
			if (asunto.getControl() != "EXTERIOR") {
				AreaVO area = eOrg.getArea(asunto.getIdArea());
				if (area != null) {
					asunto.setEntidad(area.getNombre());
					PuestoVO puesto = area.getPuesto(asunto.getIdRemitente());
					if (puesto != null) {
						asunto.setRemitenteNombre(puesto.getNombre());
					}
				}
			}
		}

	}

}
