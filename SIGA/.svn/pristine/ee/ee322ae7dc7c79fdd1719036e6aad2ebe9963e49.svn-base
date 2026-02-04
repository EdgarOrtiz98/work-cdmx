package com.meve.sigma.parametros;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.meve.sigma.catalogos.Catalogos;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.parametros.dao.ParametrosDao;
import com.meve.sigma.plugins.AppServerPlugin;
import com.meve.util.ManejadorDeTablas;
import com.meve.util.WebApps;

public class ParametrosAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ParametrosForm pf = (ParametrosForm) form;
		String accion = request.getParameter("accion");
		String idLink = pf.getIdLink();
		WebApps.setOrden(request, ManejadorDeTablas.TABLE_MANAGER, accion,
				idLink);
		WebApps.setPaginacion(request, ManejadorDeTablas.TABLE_MANAGER, accion,
				idLink);
		if ("mostrarParametros".equals(accion)) {
			Connection conn = null;
			try {
				conn = ConexionDS.getConexion();
				List parametros = ParametrosDao.getParametros(conn);
				ManejadorDeTablas tm = new ManejadorDeTablas();
				tm.setRegistros(parametros);
				tm.setAtributos(ParametrosForm.getAtributos());
				tm.setEncabezados(ParametrosForm.getEncabezados());
				tm.setOrden(ParametrosForm.getOrden());
				tm.setPaginaActual(0);
				tm.setRegistrosPorPagina(20);
				request.getSession().setAttribute(
						ManejadorDeTablas.TABLE_MANAGER, tm);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
				ConexionDS.endConnection(null, null, conn);
			}
			return mapping.findForward("mostrarParametros");
		}
		if ("nuevoParametro".equals(accion)) {
			return mapping.findForward("nuevoParametro");
		}
		if ("actualizarParametros".equals(accion)) {
			AppServerPlugin.updateParametros(request.getSession()
					.getServletContext());
			return mapping.findForward("mostrarParametros");

		}
		if ("verModificarParametro".equals(accion)) {
			List parametros = (List) request.getSession().getServletContext()
					.getAttribute(Catalogos.CATALOGO_PARAMETROS);
			for (int i = 0; i < parametros.size(); i++) {
				ParametrosForm parametro = (ParametrosForm) parametros.get(i);
				if (parametro.getParametroId().equals(idLink)) {
					request.getSession().setAttribute("paremetrosForm",
							parametro);
					return mapping.findForward("modificarParametro");
				}
			}
			return mapping.findForward("mostrarParametros");
		}
		if ("insertarParametro".equals(accion)) {
			ActionMessages errors = new ActionMessages();
			if ("".equals(pf.getParametroId().trim())
					|| pf.getParametroId() == null) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.parametros.id"));

			}
			if ("".equals(pf.getParametroId().trim())
					|| pf.getParametroId() == null) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.parametros.value"));

			}
			if (!errors.isEmpty()) {
				////saveErrors(request, errors);
				return mapping.findForward("nuevoParametro");
			}
			Connection conn = null;
			try {
				conn = ConexionDS.getConexion();
				if (ParametrosDao.insertaParametro(conn, pf)) {
					List parametros = ParametrosDao.getParametros(conn);
					request.getSession().getServletContext().setAttribute(
							Catalogos.CATALOGO_PARAMETROS, parametros);
					AppServerPlugin.updateParametros(request.getSession()
							.getServletContext());
					ManejadorDeTablas tm = new ManejadorDeTablas();
					tm.setRegistros(parametros);
					tm.setAtributos(ParametrosForm.getAtributos());
					tm.setEncabezados(ParametrosForm.getEncabezados());
					tm.setOrden(ParametrosForm.getOrden());
					tm.setPaginaActual(0);
					tm.setRegistrosPorPagina(20);
					request.getSession().setAttribute(
							ManejadorDeTablas.TABLE_MANAGER, tm);
					return (mapping.findForward("mostrarParametros"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
				ConexionDS.endConnection(null, null, conn);
			}
			return mapping.findForward("mostrarParametros");
		}
		if ("actualizarParametro".equals(accion)) {
			ActionMessages errors = new ActionMessages();
			if ("".equals(pf.getParametroId().trim())
					|| pf.getParametroId() == null) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.parametros.id"));

			}
			if ("".equals(pf.getParametroId().trim())
					|| pf.getParametroId() == null) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.parametros.value"));

			}
			if (!errors.isEmpty()) {
				////saveErrors(request, errors);
				return mapping.findForward("nuevoParametro");
			}
			Connection conn = null;
			try {
				conn = ConexionDS.getConexion();
				if (ParametrosDao.modificaParametro(conn, pf)) {
					List parametros = ParametrosDao.getParametros(conn);
					request.getSession().getServletContext().setAttribute(
							Catalogos.CATALOGO_PARAMETROS, parametros);
					AppServerPlugin.updateParametros(request.getSession()
							.getServletContext());
					ManejadorDeTablas tm = new ManejadorDeTablas();
					tm.setRegistros(parametros);
					tm.setAtributos(ParametrosForm.getAtributos());
					tm.setEncabezados(ParametrosForm.getEncabezados());
					tm.setOrden(ParametrosForm.getOrden());
					tm.setPaginaActual(0);
					tm.setRegistrosPorPagina(20);
					request.getSession().setAttribute(
							ManejadorDeTablas.TABLE_MANAGER, tm);
					return (mapping.findForward("mostrarParametros"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
				ConexionDS.endConnection(null, null, conn);
			}
			return mapping.findForward("mostrarParametros");
		}
		if ("eliminarParametros".equals(accion)) {
			ActionMessages errors = new ActionMessages();
			if ("".equals(pf.getParametroId().trim())
					|| pf.getParametroId() == null) {
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"error.borrar.parametros"));
			}
			if (!errors.isEmpty()) {
				////saveErrors(request, errors);
				return mapping.findForward("mostrarParametros");
			}
			Connection conn = null;
			try {
				conn = ConexionDS.getConexion();
				for (int i = 0; i < pf.getRegistros().length; i++) {
					ParametrosDao.eliminaParametro(conn, pf.getRegistros()[i]);
				}
				List parametros = ParametrosDao.getParametros(conn);
				request.getSession().getServletContext().setAttribute(
						Catalogos.CATALOGO_PARAMETROS, parametros);
				AppServerPlugin.updateParametros(request.getSession()
						.getServletContext());
				ManejadorDeTablas tm = (ManejadorDeTablas) request.getSession()
						.getAttribute(ManejadorDeTablas.TABLE_MANAGER);
				tm.setRegistros(parametros);

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			} finally {
				ConexionDS.endConnection(null, null, conn);
			}
		}

		return mapping.findForward("mostrarParametros");
	}
}
