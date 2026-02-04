package com.meve.sigma.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meve.sigma.asunto.dao.AsuntoDao;
import com.meve.sigma.beans.UsuarioBean;
import com.meve.sigma.db2.ConexionDS;

public class AjaxUtil extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -2431676388422920226L;

	public AjaxUtil() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion") != null ? request
				.getParameter("accion") : "";

		if ("compruebaAreaDestinatarios".equals(accion)) {
			response.setContentType("text/xml");
			PrintWriter pw = response.getWriter();
			pw.write(compruebaAreaDestinatarios(request));
			pw.flush();
			pw.close();
		}

	}

	protected String compruebaAreaDestinatarios(HttpServletRequest request) {

		String listaIdsDestinatariosPara = request.getParameter("listaPara");
		String listaIdsDestinatariosCC = request.getParameter("listaCC");
		String idAreaRemitente = request.getParameter("idAreaGen");
		StringTokenizer stPara = new StringTokenizer(listaIdsDestinatariosPara, ",");
		StringTokenizer stCC = new StringTokenizer(listaIdsDestinatariosCC, ",");
		Connection conn = null;
		try {
			conn = ConexionDS.getConexion();
			while (stPara.hasMoreTokens()) {
				UsuarioBean usuario = AsuntoDao.getDestinatario(conn, Integer
						.parseInt(stPara.nextToken()));
				if (!usuario.getIdArea().equals(idAreaRemitente)) {
					String mensaje = "Cuando un asunto es de entrada (de origen externo), " +
							"NO se generaran instrucciones \nPara las personas externas que sean " +
							"seleccionadas en los campos PARA y CCP.";
					return "<alerta mensaje ='"+mensaje+"' />";
				}

			}
			while (stCC.hasMoreTokens()) {
				UsuarioBean usuario = AsuntoDao.getDestinatario(conn, Integer
						.parseInt(stCC.nextToken()));
				if (!usuario.getIdArea().equals(idAreaRemitente)) {
					String mensaje = "Cuando un asunto es de entrada (de origen externo), " +
							"NO se generaran instrucciones \nPara las personas externas que sean " +
							"seleccionadas en los campos PARA y CCP.";
					return "<alerta mensaje ='"+mensaje+"' />";
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			ConexionDS.endConnection(null, null, conn);
		}
		return "<alerta mensaje ='OK' />";
	}

}
