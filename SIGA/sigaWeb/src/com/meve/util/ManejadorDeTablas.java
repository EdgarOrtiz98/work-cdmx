package com.meve.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManejadorDeTablas {

	public final static String TABLE_MANAGER = "tableManager";
	List registros = new ArrayList();

	private int paginaActual;

	private int registrosPorPagina;

	private boolean ascOrden;

	private int columnaOrdenada;

	private List encabezados = new ArrayList();

	private List atributos = new ArrayList();

	private List orden = new ArrayList();

	public String getOrden(int columna) {
		return orden.get(columna).toString();
	}

	public List getEncabezados() {
		return encabezados;
	}

	public void setEncabezados(List encabezados) {
		this.encabezados = encabezados;
	}

	public List getRegistros() {
		return registros;
	}

	public void setRegistros(List registros) {
		this.registros = registros;
	}

	public List getRegistrosPaginaActual() {
		int desde = (paginaActual) * registrosPorPagina;
		int hasta = (paginaActual) * registrosPorPagina + registrosPorPagina;
		if (hasta > getTotalRegistros()) {
			hasta = getTotalRegistros();
		}
		return registros.subList(desde, hasta);
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public void setPaginaActual(int paginaActual) {
		this.paginaActual = paginaActual;
	}

	public int getRegistrosPorPagina() {
		return registrosPorPagina;
	}

	public void setRegistrosPorPagina(int registrosPorPagina) {
		this.registrosPorPagina = registrosPorPagina;
	}

	public int getTotalRegistros() {
		return registros.size();
	}

	public int getNumeroDePaginas() {
		if (getTotalRegistros() % registrosPorPagina == 0) {
			return getTotalRegistros() / registrosPorPagina;
		} else {
			return (getTotalRegistros() / registrosPorPagina) + 1;
		}

	}

	public void setOrden(final int columna, final boolean ascOrden) {
		this.columnaOrdenada = columna;
		this.ascOrden = ascOrden;
		if (!ascOrden) {
			this.orden.set(columna, "desc");
		} else {
			this.orden.set(columna, "asc");
		}
		Collections.sort(registros, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				Ordenable s1 = (Ordenable) obj1;
				Ordenable s2 = (Ordenable) obj2;
				try {
					return s1.compareTo(s2, getAtributos().get(columna)
							.toString(), ManejadorDeTablas.this.ascOrden);
				} catch (Exception e) {
					e.printStackTrace();
					return -1;
				}
			}
		});

	}

	public void setOrden(List orden) {
		this.orden = orden;
	}
	
	public void setOrden(String [] orden) {
		for(int i=0;i<orden.length;i++){
			this.orden.add(orden[i]);
		}
	}

	public String getPaginacionHTML(String form) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < getNumeroDePaginas(); i++) {
			if (paginaActual != i) {
				sb
						.append("<td><a href=\"javascript:;\"  onclick=\"submitForm(document.");
				sb.append(form);
				sb.append(",'move',");
				sb.append(i + ");return false;\">");
				sb.append(i + 1);
				sb.append("</td>");
			} else {
				sb.append("<td><FONT color='red'><B>[");
				sb.append(i + 1);
				sb.append("]</B></FONT></td>");
			}

		}
		return sb.toString();
	}

	public List getAtributos() {
		return atributos;
	}

	public void setAtributos(List atributos) {
		this.atributos = atributos;
	}

	public void setAtributos(String[] atributos) {
		for (int i = 0; i < atributos.length; i++) {
			this.atributos.add(atributos[i]);
		}
	}

	public boolean isAscOrden() {
		return ascOrden;
	}

	public void setAscOrden(boolean ascOrden) {
		this.ascOrden = ascOrden;
	}
}
