package com.meve.sigma.parametros;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meve.sigma.asunto.AsuntoForm;
import com.meve.sigma.struts.SigaForm;
import com.meve.util.Comparadores;
import com.meve.util.Encabezado;
import com.meve.util.Ordenable;

public class ParametrosForm extends SigaForm implements Ordenable {

	String parametroId;
	String parametroDescripcion;
	String parametroValor;
	String[] registros;

	public String[] getRegistros() {
		return registros;
	}

	public void setRegistros(String[] registros) {
		this.registros = registros;
	}

	public String getParametroId() {
		return parametroId;
	}

	public void setParametroId(String parametroId) {
		this.parametroId = parametroId;
	}

	public String getParametroDescripcion() {
		return parametroDescripcion;
	}

	public void setParametroDescripcion(String parametroDescripcion) {
		this.parametroDescripcion = parametroDescripcion;
	}

	public String getParametroValor() {
		return parametroValor;
	}

	public void setParametroValor(String parametroValor) {
		this.parametroValor = parametroValor;
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
		ParametrosForm pf = (ParametrosForm) obj;
		Field field = pf.getClass().getDeclaredField(fieldName);
		String fieldType = field.getType().getName();
		if ("java.lang.String".equals(fieldType)) {
			return Comparadores
					.compare((String) field.get(pf), (String) this.getClass()
							.getDeclaredField(fieldName).get(this), ascOrder);
		}
		if ("java.util.Date".equals(fieldType)) {
			return Comparadores
					.compare((Date) field.get(pf), (Date) this.getClass()
							.getDeclaredField(fieldName).get(this), ascOrder);
		}
		if ("int".equals(fieldType)) {
			return Comparadores.compare(field.getInt(pf), this.getClass()
					.getDeclaredField(fieldName).getInt(this), ascOrder);
		}
		if ("long".equals(fieldType)) {
			return Comparadores.compare(field.getLong(pf), this.getClass()
					.getDeclaredField(fieldName).getLong(this), ascOrder);
		}
		return -1;
	}

	public static List getEncabezados() {
		List encabezados = new ArrayList();
		Encabezado encabezadoAsunto = new Encabezado();
		encabezadoAsunto.setTitulo("Id Parametro");
		encabezadoAsunto.setWidth(35);
		Encabezado encabezadoFolio = new Encabezado();
		encabezadoFolio.setTitulo("Descripcion");
		encabezadoFolio.setWidth(35);
		Encabezado encabezadoRecepcion = new Encabezado();
		encabezadoRecepcion.setTitulo("Valor");
		encabezadoRecepcion.setWidth(30);
		encabezados.add(encabezadoAsunto);
		encabezados.add(encabezadoFolio);
		encabezados.add(encabezadoRecepcion);
		return encabezados;
	}
	
	public static List getAtributos() {
		List atributos = new ArrayList();
		atributos.add("parametroId");
		atributos.add("parametroDescripcion");
		atributos.add("parametroValor");
		return atributos;
	}
	
	public static List getOrden() {
		List orden = new ArrayList();
		orden.add("asc");
		orden.add("asc");
		orden.add("asc");
		return orden;
	}
}
