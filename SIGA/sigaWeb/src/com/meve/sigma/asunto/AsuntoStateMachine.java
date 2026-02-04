package com.meve.sigma.asunto;

import javax.servlet.http.HttpServletRequest;

import com.meve.sigma.beans.UsuarioBean;

/**
 * Clase que maneja los diferentes estados por los que pasa un asunto
 * 
 * @author Meve Soluciones, S.A.
 */
public class AsuntoStateMachine {

	private static boolean canDo(HttpServletRequest request, UsuarioBean usuario,
			int estatus) {
		return true;
	}


	private static boolean hasConditions(HttpServletRequest request,
			AsuntoForm af, int estatus) {
		return true;
	}

	public static boolean canChangeStateSolicitud(HttpServletRequest request,
			int estatus) {
		UsuarioBean usuario = (UsuarioBean) request.getSession()
				.getAttribute("UsuarioBean");
		AsuntoForm af = (AsuntoForm) request.getSession().getAttribute(
				"asuntoForm");
		if (af == null || usuario == null)
			return false;
		if (!canDo(request, usuario, estatus))
			return false;
		if (!hasConditions(request, af, estatus))
			return false;
		
		return true;
	}

	


	

}
