package com.meve.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Clase con los metodos necesarios para ordenar y paginar una tabla.
 * @author Meve Soluciones, SA
 *
 */
public class WebApps {

	public static void setOrden(HttpServletRequest request, String tmString,
			String accion, String idLink) {
		if ("asc".equals(accion)) {
			ManejadorDeTablas tm = (ManejadorDeTablas) request.getSession().getAttribute(
					tmString);
			tm.setOrden(Integer.parseInt(idLink), false);
		} else if ("desc".equals(accion)) {
		   ManejadorDeTablas tm = (ManejadorDeTablas) request.getSession().getAttribute(
					tmString);
			tm.setOrden(Integer.parseInt(idLink), true);
		}
	}

	
	public static void setPaginacion(HttpServletRequest request,
			String tmString, String accion, String idLink) {
//		if ("first".equals(accion)) {
//			ManejadorDeTablas tm = (ManejadorDeTablas) request.getSession().getAttribute(
//					tmString);
//			tm.setFirstPage();
//		} else if ("last".equals(accion)) {
//			ManejadorDeTablas tm = (ManejadorDeTablas) request.getSession().getAttribute(
//					tmString);
//			tm.setLastPage();
//		} else 
			if ("move".equals(accion)) {
			ManejadorDeTablas tm = (ManejadorDeTablas) request.getSession().getAttribute(
					tmString);
			tm.setPaginaActual(Integer.parseInt(idLink));
		}
	}
	
	public static void ordenaLista(List registros, final String columna, final boolean ascOrden) {
		Collections.sort(registros, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				Ordenable s1 = (Ordenable) obj1;
				Ordenable s2 = (Ordenable) obj2;
				try {
					return s1.compareTo(s2, columna, ascOrden);
				} catch (Exception e) {
					e.printStackTrace();
					return -1;
				}
			}
		});

	}

}
