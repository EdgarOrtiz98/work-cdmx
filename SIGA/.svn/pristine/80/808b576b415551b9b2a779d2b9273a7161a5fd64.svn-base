package com.meve.sigma.catalogos;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.catalogos.dao.CatalogoDao;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.util.HistorialPagina;

public class CatalogoAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CatalogoGenerico cg = (CatalogoGenerico) form;
		String accion = request.getParameter("accion");
		String idLink = request.getParameter("idLink");

		if(Catalogos.CATALOGO_ENTIDAD.equals(cg.getTipoCatalogo())){
			CatalogoEntidad ce = (CatalogoEntidad) cg;
			if ("guardar".equals(accion)) {
				Connection conn = null;
				try {
					conn = ConexionDS.getConexion();
					UsuarioBean ub = (UsuarioBean) request.getSession()
							.getAttribute("UsuarioBean");
					CatalogoDao.insertaEntidad(conn, ce, ub);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NamingException e) {
					e.printStackTrace();
				} finally {
					ConexionDS.endConnection(null, null, conn);
				}
				return mapping.findForward("directorioExternas");
			}
			if ("regresar".equals(accion)) {
				HistorialPagina historial = (HistorialPagina) request
						.getSession().getAttribute("HistorialDirectorio");
				return mapping.findForward(historial.getPaginaAnterior()
						.getPagina());
			}
		}
		if(Catalogos.CATALOGO_REMITENTE.equals(cg.getTipoCatalogo())){
			CatalogoRemitente cr = (CatalogoRemitente) cg;
			if ("guardar".equals(accion)) {
				Connection conn = null;
				try {
					conn = ConexionDS.getConexion();
					UsuarioBean ub = (UsuarioBean) request.getSession()
							.getAttribute("UsuarioBean");
					CatalogoDao.insertaRemitente(conn, cr, ub);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NamingException e) {
					e.printStackTrace();
				} finally {
					ConexionDS.endConnection(null, null, conn);
				}
				return mapping.findForward("directorioExternas");
			}
			if ("regresar".equals(accion)) {
				HistorialPagina historial = (HistorialPagina) request
						.getSession().getAttribute("HistorialDirectorio");
				return mapping.findForward(historial.getPaginaAnterior()
						.getPagina());
			}
		}
		return mapping.findForward("");
	}

}
