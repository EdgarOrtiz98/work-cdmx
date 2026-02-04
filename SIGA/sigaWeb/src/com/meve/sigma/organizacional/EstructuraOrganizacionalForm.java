package com.meve.sigma.organizacional;

import com.meve.sigma.struts.SigaForm;

public class EstructuraOrganizacionalForm extends SigaForm{

	private static final long serialVersionUID = -402627702620448591L;
	
	private int idArea;
	
	private int idResponsable;
	
	private String responsableNombre;
	
	private String cargoNombre;
	
	private String areaNombre;
	

	public String getResponsableNombre() {
		return responsableNombre;
	}

	public void setResponsableNombre(String responsableNombre) {
		this.responsableNombre = responsableNombre;
	}

	public String getAreaNombre() {
		return areaNombre;
	}

	public void setAreaNombre(String areaNombre) {
		this.areaNombre = areaNombre;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getCargoNombre() {
		return cargoNombre;
	}

	public void setCargoNombre(String cargoNombre) {
		this.cargoNombre = cargoNombre;
	}

}
