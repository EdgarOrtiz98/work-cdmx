package com.meve.sigma.organizacional.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.meve.util.Comparadores;
import com.meve.util.Ordenable;
import com.meve.util.WebApps;

public class PuestoVO implements Ordenable {

	private int idUsuario;
	private int idArea;
	private int idJefe;
	public String nombre;
	public String cargo;
	private List subordinados = new ArrayList();
	private List asistentes = new ArrayList();
	private List roles = new ArrayList();
	private boolean desplegado;
	private boolean seleccionado = false;
	private boolean habilitado=true;

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
		List subordinados = getSubordinados(false);
		for(int i=0;i<subordinados.size();i++){
			PuestoVO subordinado = (PuestoVO)subordinados.get(i);
			subordinado.setHabilitado(habilitado);
		}
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public PuestoVO() {
	}

	public PuestoVO(PuestoVO puesto) {
		this.idUsuario = puesto.getIdUsuario();
		this.idArea = puesto.getIdArea();
		this.idJefe = puesto.getIdJefe();
		this.nombre = puesto.getNombre();
		this.cargo = puesto.getCargo();
		for (int i = 0; i < puesto.getSubordinados(false).size(); i++) {
			subordinados.add(new PuestoVO((PuestoVO) puesto.getSubordinados(
					false).get(i)));
		}
		for (int i = 0; i < puesto.getAsistentes().size(); i++) {
			asistentes.add(new AsistenteVO((AsistenteVO) puesto.getAsistentes()
					.get(i)));
		}
		for (int i = 0; i < puesto.getRoles().size(); i++) {
			roles.add(new Integer(((Integer) puesto.getRoles().get(i))
					.intValue()));
		}
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getIdJefe() {
		return idJefe;
	}

	public void setIdJefe(int idJefe) {
		this.idJefe = idJefe;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List getSubordinados(boolean all) {
		if (!all) {
			return subordinados;
		} else {
			List puestosRes = new ArrayList();
			for (int i = 0; i < subordinados.size(); i++) {
				PuestoVO puesto = (PuestoVO) subordinados.get(i);
				puestosRes.add(puesto);
				puestosRes.addAll(puesto.getSubordinados(true));
			}
			return puestosRes;
		}
	}

	public void setSubordinados(List puestos) {
		for (int i = 0; i < puestos.size(); i++) {
			PuestoVO puesto = (PuestoVO) puestos.get(i);
			if (this.getIdUsuario() == puesto.getIdJefe()) {
				puesto.setSubordinados(puestos);
				subordinados.add(puesto);
			}
		}

	}

	public PuestoVO getSubordinado(int idUsuario) {
		for (int i = 0; i < subordinados.size(); i++) {
			PuestoVO puesto = (PuestoVO) subordinados.get(i);
			if (idUsuario == puesto.getIdUsuario()) {
				return puesto;
			} else {
				PuestoVO puestoResultado = puesto.getSubordinado(idUsuario);
				if (puestoResultado != null) {
					return puestoResultado;
				}
			}
		}
		return null;
	}

	public Element getHTML(Element input) {
		WebApps.ordenaLista(subordinados, "cargo", false);
		Element divPrincipal = new Element("DIV");
		divPrincipal.setAttribute("id", "puesto_" + idUsuario);
		Element dl = new Element("DL");
		Element dt = new Element("DT");
		Element icono = new Element("IMG");
		if (hasSubordinados()) {
			if (isDesplegado()) {
				icono.setAttribute("src", "./Imagenes/nolines_minus.gif");
			} else {
				icono.setAttribute("src", "./Imagenes/nolines_plus.gif");
			}
			icono.setAttribute("id", "expadir_" + idUsuario);
			icono.setAttribute("onclick",
					"muestraOcultaSubordinados('subordinados_" + idUsuario
							+ "',this);return false;");
		} else {
			icono.setAttribute("src", "./Imagenes/noLines_join.gif");
		}
		dt.addContent(icono);
		if (input != null && habilitado) {
			input = (Element)input.clone();
			input.setAttribute("id", "input_" + idUsuario);
			input.setAttribute("value", String.valueOf(idUsuario));
			dt.addContent(input);
		}
		Element ancla = new Element("A");
		if (habilitado) {
			ancla.setAttribute("href",
					"./puesto.siga?accion=mostrarPuesto&idLink=" + idUsuario);
			ancla.setAttribute("title", nombre);
			if (seleccionado) {
				Element bold = new Element("B");
				bold.setText(cargo + "/" + nombre);
				ancla.addContent(bold);
			} else {
				ancla.setText(cargo + "/" + nombre);
			}
			dt.addContent(ancla);
		}else{
			ancla.setText(cargo + "/" + nombre);
			ancla.setAttribute("style","color:#999999");
			dt.addContent(ancla);
		}
		if (hasSubordinados()) {
			Element divSub = new Element("DIV");
			if (isDesplegado()) {
				divSub.setAttribute("style", "display: block;");
			} else {
				divSub.setAttribute("style", "display: none;");
			}
			divSub.setAttribute("id", "subordinados_" + idUsuario);
			for (int i = 0; i < subordinados.size(); i++) {
				divSub.addContent(((PuestoVO) subordinados.get(i))
						.getHTML(input));
			}
			dt.addContent(divSub);
		}
		dl.addContent(dt);
		divPrincipal.addContent(dl);
		return divPrincipal;
	}

	public Element getXML() {
		Element puesto = new Element("Puesto");
		puesto.setAttribute("idUsuario", String.valueOf(idUsuario));
		puesto.setAttribute("idArea", String.valueOf(idArea));
		puesto.setAttribute("idJefe", String.valueOf(idJefe));
		puesto.setAttribute("nombre", nombre);
		puesto.setAttribute("cargo", cargo);
		puesto.setAttribute("desplegado", String.valueOf(desplegado));
		puesto.setAttribute("seleccionado", String.valueOf(seleccionado));
		for (int i = 0; i < subordinados.size(); i++) {
			puesto.addContent(((PuestoVO) subordinados.get(i)).getXML());
		}

		return puesto;
	}

	protected boolean isEnLista(List puestos) {
		for (int i = 0; i < puestos.size(); i++) {
			PuestoVO puesto = (PuestoVO) puestos.get(i);
			if (puesto.getIdUsuario() == idUsuario) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n" + idUsuario + ":" + idArea + ":" + idJefe + ":"
				+ asistentes.size() + ":" + nombre + ":" + cargo);
		for (int i = 0; i < subordinados.size(); i++) {
			sb.append(" " + ((PuestoVO) subordinados.get(i)).toString());
		}
		return sb.toString();
	}

	public boolean isDesplegado() {
		return desplegado;
	}

	public void setDesplegado(boolean desplegado) {
		this.desplegado = desplegado;
	}

	public boolean hasSubordinados() {
		return subordinados.size() > 0;
	}

	public void addAsistente(AsistenteVO asistente) {
		asistentes.add(asistente);
	}

	public void addSubordinado(PuestoVO puesto) {
		subordinados.add(puesto);
	}

	public List getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List asistentes) {
		this.asistentes = asistentes;
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
		PuestoVO po = (PuestoVO) obj;
		Field field = po.getClass().getDeclaredField(fieldName);
		String fieldType = field.getType().getName();
		if ("java.lang.String".equals(fieldType)) {
			return Comparadores
					.compare((String) field.get(po), (String) this.getClass()
							.getDeclaredField(fieldName).get(this), ascOrder);
		}
		if ("java.util.Date".equals(fieldType)) {
			return Comparadores
					.compare((Date) field.get(po), (Date) this.getClass()
							.getDeclaredField(fieldName).get(this), ascOrder);
		}
		if ("int".equals(fieldType)) {
			return Comparadores.compare(field.getInt(po), this.getClass()
					.getDeclaredField(fieldName).getInt(this), ascOrder);
		}
		if ("long".equals(fieldType)) {
			return Comparadores.compare(field.getLong(po), this.getClass()
					.getDeclaredField(fieldName).getLong(this), ascOrder);
		}
		return -1;
	}

	public List getRoles() {
		return roles;
	}

	public void setRoles(List roles) {
		this.roles = roles;
	}

}
