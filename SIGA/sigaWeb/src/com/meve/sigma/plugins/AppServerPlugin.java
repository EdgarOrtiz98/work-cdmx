package com.meve.sigma.plugins;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.naming.NamingException;
import javax.servlet.ServletContext;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.meve.sigma.catalogos.Catalogos;
import com.meve.sigma.catalogos.dao.PrioridadDao;
import com.meve.sigma.catalogos.dao.RolDao;
import com.meve.sigma.catalogos.dao.TipoAsuntoDao;
import com.meve.sigma.catalogos.dao.TipoDocumentoDao;
import com.meve.sigma.catalogos.dao.TramiteDao;
import com.meve.sigma.db2.ConexionDS;
import com.meve.sigma.organizacional.EstructuraOrganizacional;
import com.meve.sigma.parametros.ParametrosForm;
import com.meve.sigma.parametros.dao.ParametrosDao;

public class AppServerPlugin implements PlugIn {

	public AppServerPlugin() {
	}

	public void init(ActionServlet servlet, ModuleConfig config) {
		System.out.println("**********Init SIGA Plugin *********");
		Connection conn = null;
		try {
			PropertyResourceBundle res = new PropertyResourceBundle(getClass()
					.getResourceAsStream("/prop_es.properties"));
			servlet.getServletContext().setAttribute("resource", res);
			setParameter(res, servlet, "app.debug");
			setParameter(res, servlet, "app.timeout");
			setParameter(res, servlet, "app.siga.serverMail");
			setParameter(res, servlet, "app.siga.recuperar.uas");
			setParameter(res, servlet, "app.siga.informativas.tiempo.uas");
			conn = ConexionDS.getConexion();
			cargaCatalogos(servlet.getServletContext(), conn);
			updateParametros(servlet.getServletContext());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			
			ConexionDS.endConnection(null, null, conn);
		}
	}

	public void destroy() {
		System.out.println("Terminando PlugIn SIGA");
	}

	public static void setParameter(ResourceBundle res, ActionServlet servlet,
			String parametro) {
		servlet.getServletContext().setAttribute(parametro,
				res.getString(parametro));
		System.out.println("Setting parameter " + parametro);
	}

	private void cargaCatalogos(ServletContext context, Connection conn) {
		System.out.println("********** Cargando Catalogos *********");
		System.out.println("** Catalogo tramite **");
		context.setAttribute(Catalogos.CATALOGO_TRAMITE, TramiteDao
				.getCatalogo(conn));
		System.out.println("** Catalogo Prioridad **");
		context.setAttribute(Catalogos.CATALOGO_PRIORIDAD, PrioridadDao
				.getCatalogo(conn));
		System.out.println("** Catalogo tipo de Documento **");
		context.setAttribute(Catalogos.CATALOGO_TIPO_DOCUMENTO,
				TipoDocumentoDao.getCatalogo(conn));
		System.out.println("** Catalogo tipo de Asunto **");
		context.setAttribute(Catalogos.CATALOGO_TIPO_ASUNTO, TipoAsuntoDao
				.getCatalogo(conn));
		System.out.println("** Catalogo Parametros **");
		context.setAttribute(Catalogos.CATALOGO_PARAMETROS, ParametrosDao
				.getParametros(conn));
		System.out.println("** Catalogo Rol **");
		context.setAttribute(Catalogos.CATALOGO_ROL, RolDao.getCatalogo());
		System.out.println("** Catalogo Estructura Organizacional **");
		context.setAttribute(Catalogos.CATALOGO_ESTRUCTURA_ORGANIZACIONAL, new EstructuraOrganizacional(conn));
		System.out.println("********** Fin Carga Catalogos *********");

	}

	public static void updateParametros(ServletContext context) {
		List params = (List) context
				.getAttribute(Catalogos.CATALOGO_PARAMETROS);
		for (int i = 0; i < params.size(); i++) {
			ParametrosForm param = (ParametrosForm) params.get(i);
			context.setAttribute(String.valueOf(param.getParametroId()), param
					.getParametroValor());
			System.out.println("Loading Param: " + param.getParametroId());
		}
	}

}
