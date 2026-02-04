package com.meve.sigma.catalogos;

import com.meve.sigma.struts.SigaForm;

public class CatalogoTramite extends SigaForm implements CatalogoGenerico {

	private int id;
	private String nombre;
	private String clave;
	private String descripcion;
	private String tiempo;
	private long fechaCreacion;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public long getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(long fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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
	
	public String getTipoCatalogo(){
		return Catalogos.CATALOGO_TRAMITE;
	}

}
