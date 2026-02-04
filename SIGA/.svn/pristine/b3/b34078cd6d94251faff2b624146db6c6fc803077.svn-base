package com.meve.sigma.organizacional.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jdom.Element;

import com.meve.sigma.util.Converters;
import com.meve.util.Comparadores;
import com.meve.util.Ordenable;

public class AreaVO implements Ordenable {

	private int idArea;

	private int idAreaPadre = -1;

	private int idResponsable;

	private String nombre;

	private List asistentes = new ArrayList();

	private List puestos = new ArrayList();

	private List areasSubordinadas = new ArrayList();

	private boolean activa;

	public AreaVO() {
	}

	public AreaVO(AreaVO area) {
		this.idArea = area.getIdArea();
		this.idAreaPadre = area.getIdAreaPadre();
		this.idResponsable = area.getIdResponsable();
		this.nombre = area.getNombre();
		List puestosTemp = area.getPuestos(false);
		for (int j = 0; j < puestosTemp.size(); j++) {
			this.puestos.add(new PuestoVO((PuestoVO) puestosTemp.get(j)));
		}
		for (int i = 0; i < area.getAreasSubordinadas(false).size(); i++) {
			this.areasSubordinadas.add(new AreaVO((AreaVO) area
					.getAreasSubordinadas(false).get(i)));
		}
		for (int i = 0; i < area.getAsistentes().size(); i++) {
			this.asistentes.add(new AsistenteVO((AsistenteVO) area
					.getAsistentes().get(i)));
		}
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
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

	public String getNombre() {
		return nombre;
	}

	public String getNombreHTML() {
		return Converters.convertPlainToHtml(nombre);

	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List getPuestos(boolean all) {
		if (!all) {
			return puestos;
		} else {
			List puestosRes = new ArrayList();
			for (int i = 0; i < puestos.size(); i++) {
				PuestoVO puesto = (PuestoVO) puestos.get(i);
				puestosRes.add(puesto);
				puestosRes.addAll(puesto.getSubordinados(true));
			}
			return puestosRes;
		}
	}

	public List getPuestosPorRol(int idRol) {
		List puestos = getPuestos(true);
		List puestosRol = new ArrayList();
		for (int i = 0; i < puestos.size(); i++) {
			PuestoVO puesto = (PuestoVO) puestos.get(i);
			for (int j = 0; j < puesto.getRoles().size(); j++) {
				if (idRol == ((Integer) puesto.getRoles().get(j)).intValue()) {
					puestosRol.add(puesto);
					break;
				}
			}

		}
		System.out.println("Roles obtenidos: " + puestosRol.size());
		return puestosRol;
	}

	public void setPuestos(List puestos) {
		this.puestos = puestos;
	}

	public int getIdAreaPadre() {
		return idAreaPadre;
	}

	public void setIdAreaPadre(int idAreaPadre) {
		this.idAreaPadre = idAreaPadre;
	}

	public List getAreasSubordinadas(boolean todas) {
		if (!todas) {
			return areasSubordinadas;
		} else {
			List areasSubordinadasTodas = new ArrayList();
			for (int i = 0; i < this.areasSubordinadas.size(); i++) {
				AreaVO area = (AreaVO) areasSubordinadas.get(i);
				areasSubordinadasTodas.add(area);
				areasSubordinadasTodas.addAll(area.getAreasSubordinadas(todas));
			}
			return areasSubordinadasTodas;
		}
	}

	public void setAreasSubordinadas(List areas) {
		for (int i = 0; i < areas.size(); i++) {
			AreaVO area = (AreaVO) areas.get(i);
			if (area.getIdAreaPadre() == idArea) {
				area.setAreasSubordinadas(areas);
				areasSubordinadas.add(area);
			}
		}
	}

	public AreaVO getAreaSubordinada(int idArea) {
		for (int i = 0; i < areasSubordinadas.size(); i++) {
			AreaVO area = (AreaVO) areasSubordinadas.get(i);
			if (idArea == area.getIdArea()) {
				return area;
			} else {
				AreaVO areaResultado = area.getAreaSubordinada(idArea);
				if (areaResultado != null) {
					return areaResultado;
				}
			}
		}
		return null;
	}

	public PuestoVO getPuesto(int idUsuario) {
		for (int i = 0; i < puestos.size(); i++) {
			PuestoVO puesto = (PuestoVO) puestos.get(i);
			if (idUsuario == puesto.getIdUsuario()) {
				return puesto;
			} else {
				PuestoVO puestoResultado = puesto.getSubordinado(idUsuario);
				if (puestoResultado != null) {
					return puestoResultado;
				}
			}
		}
		for (int i = 0; i < areasSubordinadas.size(); i++) {
			AreaVO area = (AreaVO) areasSubordinadas.get(i);
			PuestoVO puestoResultado = area.getPuesto(idUsuario);
			if (puestoResultado != null) {
				return puestoResultado;
			}
		}
		return null;
	}

	public List getCompanieros(int idUsuario) {
		PuestoVO puesto = getPuesto(idUsuario);
		List puestos = getPuestos(true);
		List subordinados = puesto.getSubordinados(true);
		PuestoVO jefeDeJefes = getCadenaMando(idUsuario);
		List jefes = jefeDeJefes.getSubordinados(true);
		jefes.add(jefeDeJefes);
		List companieros = new ArrayList();
		for (int i = 0; i < puestos.size(); i++) {
			PuestoVO puestoTemp = (PuestoVO) puestos.get(i);
			if (puestoTemp.isEnLista(subordinados)
					|| puestoTemp.isEnLista(jefes)) {
				continue;
			}
			PuestoVO newPuesto = new PuestoVO();
			newPuesto.setIdUsuario(puestoTemp.getIdUsuario());
			newPuesto.setIdArea(puestoTemp.getIdArea());
			newPuesto.setIdJefe(puestoTemp.getIdJefe());
			newPuesto.setAsistentes(puestoTemp.getAsistentes());
			newPuesto.setNombre(puestoTemp.getNombre());
			newPuesto.setCargo(puestoTemp.getCargo());
			companieros.add(newPuesto);
		}
		return companieros;
	}

	public void despliegaRutaPuesto(int idUsuario) {
		PuestoVO puesto = getPuesto(idUsuario);
		int idJefe = puesto.getIdJefe();
		while (idJefe != getIdResponsable() && idJefe != -1) {
			PuestoVO jefe = getPuesto(idJefe);
			if(jefe==null){
				break;
			}
			jefe.setDesplegado(true);
			idJefe = jefe.getIdJefe();
		}
		((PuestoVO) getPuesto(idResponsable)).setDesplegado(true);
	}

	public PuestoVO getCadenaMando(int idUsuario) {
		PuestoVO subPuesto = null;
		PuestoVO newPuesto = null;
		while (true) {
			PuestoVO puesto = getPuesto(idUsuario);
			if (puesto == null) {
				return newPuesto;
			}
			newPuesto = new PuestoVO();
			newPuesto.setIdUsuario(idUsuario);
			newPuesto.setIdArea(puesto.getIdArea());
			newPuesto.setIdJefe(puesto.getIdJefe());
			newPuesto.setAsistentes(puesto.getAsistentes());
			newPuesto.setNombre(puesto.getNombre());
			newPuesto.setCargo(puesto.getCargo());
			if (subPuesto != null) {
				List subPuestos = new ArrayList();
				subPuestos.add(subPuesto);
				newPuesto.setSubordinados(subPuestos);
			}
			subPuesto = newPuesto;
			idUsuario = newPuesto.getIdJefe();
		}
	}

	public Element getXML() {
		Element orgElment = new Element("organigrama");
		Element principalElement = new Element("principal");
		orgElment.addContent(principalElement);
		for (int i = 0; i < puestos.size(); i++) {
			principalElement.addContent(((PuestoVO) puestos.get(i)).getXML());
		}
		Element sinRelacionElement = new Element("sinRelacion");
		orgElment.addContent(sinRelacionElement);
		for (int i = 0; i < puestos.size(); i++) {
			if (((PuestoVO) puestos.get(i)).getIdUsuario() != idResponsable) {
				sinRelacionElement.addContent(((PuestoVO) puestos.get(i))
						.getXML());
			}
		}
		return orgElment;
	}

	public Element getOrganigramaPrincipalHTML(Element input) {
		Element orgPrincipal = new Element("DIV");
		for (int i = 0; i < puestos.size(); i++) {
			((PuestoVO) puestos.get(i)).setDesplegado(false);
			if (((PuestoVO) puestos.get(i)).getIdUsuario() == idResponsable) {
				((PuestoVO) puestos.get(i)).setDesplegado(true);
				orgPrincipal.addContent(((PuestoVO) puestos.get(i))
						.getHTML(input));
			}
		}
		if (orgPrincipal.getChildren().isEmpty()) {
			orgPrincipal.setText("** No tiene Puestos asignados **");
		}
		return orgPrincipal;
	}

	public Element getOrganigramaSinRelacionHTML(Element input) {
		Element orgSinRelacion = new Element("DIV");
		for (int i = 0; i < puestos.size(); i++) {
			if (((PuestoVO) puestos.get(i)).getIdUsuario() != idResponsable) {
				orgSinRelacion.addContent(((PuestoVO) puestos.get(i))
						.getHTML(input));
			}
		}
		if (orgSinRelacion.getChildren().isEmpty()) {
			orgSinRelacion.setText("** No tiene Puestos sin relación **");
		}
		return orgSinRelacion;
	}

	public int compareTo(Ordenable obj, String fieldName, boolean ascOrder)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		if (this == obj) {
			return 0;
		}
		if (!obj.getClass().getName().equals(this.getClass().getName())) {
			return -1;
		}
		AreaVO ao = (AreaVO) obj;
		Field field = ao.getClass().getDeclaredField(fieldName);
		String fieldType = field.getType().getName();
		if ("java.lang.String".equals(fieldType)) {
			return Comparadores
					.compare((String) field.get(ao), (String) this.getClass()
							.getDeclaredField(fieldName).get(this), ascOrder);
		}
		if ("java.util.Date".equals(fieldType)) {
			return Comparadores
					.compare((Date) field.get(ao), (Date) this.getClass()
							.getDeclaredField(fieldName).get(this), ascOrder);
		}
		if ("int".equals(fieldType)) {
			return Comparadores.compare(field.getInt(ao), this.getClass()
					.getDeclaredField(fieldName).getInt(this), ascOrder);
		}
		if ("long".equals(fieldType)) {
			return Comparadores.compare(field.getLong(ao), this.getClass()
					.getDeclaredField(fieldName).getLong(this), ascOrder);
		}
		return -1;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n **************" + idArea + ":" + idArea + ":"
				+ idAreaPadre + ":" + idResponsable + ":" + nombre + ":"
				+ puestos.size() + "*************");
		for (int i = 0; i < areasSubordinadas.size(); i++) {
			sb.append(" " + ((AreaVO) areasSubordinadas.get(i)).toString());
		}
		for (int i = 0; i < puestos.size(); i++) {
			sb.append(" " + ((PuestoVO) puestos.get(i)).toString());
		}
		return sb.toString();
	}

	public void addPuesto(PuestoVO puesto) {
		puestos.add(puesto);
	}

	public List getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List asistentes) {
		this.asistentes = asistentes;
	}

	public boolean isAsistente(int idUsuario) {
		for (int i = 0; i < asistentes.size(); i++) {
			if (((AsistenteVO) asistentes.get(i)).getIdUsuario() == idUsuario) {
				return true;
			}
		}
		return false;
	}

	public AsistenteVO getAsistente(int idAsistente) {
		for (int i = 0; i < asistentes.size(); i++) {
			AsistenteVO asistente = (AsistenteVO) asistentes.get(i);
			if (asistente.getIdUsuario() == idAsistente) {
				return asistente;
			}
		}
		return null;
	}

	public void setHabilitaArea(boolean habilitar) {
		List puestos = getPuestos(false);
		for (int i = 0; i < puestos.size(); i++) {
			PuestoVO puesto = (PuestoVO) puestos.get(i);
			puesto.setHabilitado(habilitar);
		}
	}
}
