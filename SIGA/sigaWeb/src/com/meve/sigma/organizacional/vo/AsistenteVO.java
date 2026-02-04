package com.meve.sigma.organizacional.vo;

import java.util.ArrayList;
import java.util.List;

public class AsistenteVO extends PuestoVO {

	List asistidos = new ArrayList();
	public String cargo;
	public AsistenteVO(PuestoVO puesto,List asistidos) {
		this.setIdUsuario(puesto.getIdUsuario());
		this.setIdArea(puesto.getIdArea());
		this.setIdJefe(puesto.getIdJefe());
		this.setAsistentes(puesto.getAsistentes());
		this.setNombre(puesto.getNombre());
		this.setCargo(puesto.getCargo());
		List subordinados = new ArrayList();
		this.setAsistidos(asistidos);
		for (int i = 0; i < puesto.getSubordinados(false).size(); i++) {
			subordinados.add(new PuestoVO((PuestoVO) puesto.getSubordinados(
					false).get(i)));
		}
		setSubordinados(subordinados);

	}
	
	public AsistenteVO(AsistenteVO asistente) {
		this.setIdUsuario(asistente.getIdUsuario());
		this.setIdArea(asistente.getIdArea());
		this.setIdJefe(asistente.getIdJefe());
		this.setAsistentes(asistente.getAsistentes());
		this.setNombre(asistente.getNombre());
		this.setCargo(asistente.getCargo());
		List subordinados = new ArrayList();
		this.setAsistidos(asistente.getAsistidos());
		for (int i = 0; i < asistente.getSubordinados(false).size(); i++) {
			subordinados.add(new PuestoVO((PuestoVO) asistente.getSubordinados(
					false).get(i)));
		}
		
		setSubordinados(subordinados);

	}

	public AsistenteVO() {
	}

	public List getAsistidos() {
		return asistidos;
	}

	public void setAsistidos(List asistidos) {
		this.asistidos = asistidos;
	}

	public void addAsistido(PuestoVO puesto){
		asistidos.add(puesto);
	}
}
