package com.meve.sigma.catalogos;

import com.meve.sigma.struts.SigaForm;

public class CatalogoRol extends SigaForm implements CatalogoGenerico {
	
	public final static int ROL_ADMINISTRADOR = 0;
	public final static int ROL_ATENCION = 1;
	public final static int ROL_SCP = 2;
	public final static int ROL_RECEPCION = 3;
	public final static int ROL_SUPERVISOR = 4;
	public final static int ROL_TURNADOR = 5;
	public final static int ROL_ASISTENTE = 6;

	private static final long serialVersionUID = -6691106225589745917L;
	private int id;
	private String nombre;
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

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

	public String getTipoCatalogo() {
		return Catalogos.CATALOGO_ROL;
	}
}
