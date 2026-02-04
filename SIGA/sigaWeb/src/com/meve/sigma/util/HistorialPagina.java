package com.meve.sigma.util;

import java.util.ArrayList;
import java.util.List;

public class HistorialPagina {

	int paginaActual;

	List historial = new ArrayList();

	public HistorialPagina(){
		paginaActual=-1;
	}
	public void setPagina(String nombrePagina, String accion, String idLink) {
		Pagina pagina = new Pagina();
		pagina.setPagina(nombrePagina);
		pagina.setAccion(accion);
		pagina.setIdLink(idLink);
		historial.add(++paginaActual,pagina);
	}

	public Pagina getPaginaActual(){
		return((Pagina)historial.get(paginaActual));
	}
	
	public Pagina getPaginaAnterior(){
		paginaActual--;//TODO hacer una exepcion si la pagina actual es -1
		return((Pagina)historial.get(paginaActual));
	}
}
