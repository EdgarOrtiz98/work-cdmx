package com.meve.sigma.catalogos;

import com.meve.sigma.struts.SigaForm;


public class CatalogoEntidad extends SigaForm implements CatalogoGenerico{

	private static final long serialVersionUID = -8926295895076423606L;

	private int id;
	
	private String nombre;
	
	private boolean activa;
	
	private String clasificacion;
	
	
	private int area;
	
	private String direccion;
	
	private int telefono;

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

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getTipoCatalogo(){
		return Catalogos.CATALOGO_ENTIDAD;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	
}
