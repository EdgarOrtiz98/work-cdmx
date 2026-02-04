package com.meve.sigma.catalogos;

import com.meve.sigma.struts.SigaForm;

public class CatalogoPrioridad extends SigaForm implements CatalogoGenerico {

	private static final long serialVersionUID = -6691106225589745917L;
	private int id;
	private String nombre;
	private String colorHex;
	private long fechaActualizacion;
	private int estatus;
	private int idArea;
	private int idUsuarioActualizo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public long getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(long fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getIdUsuarioActualizo() {
		return idUsuarioActualizo;
	}

	public void setIdUsuarioActualizo(int idUsuarioActualizo) {
		this.idUsuarioActualizo = idUsuarioActualizo;
	}


	public String getColorHex() {
		return colorHex;
	}

	public void setColorHex(String colorHex) {
		this.colorHex = colorHex;
	}

	public String getTipoCatalogo() {
		return Catalogos.CATALOGO_PRIORIDAD;
	}
}
