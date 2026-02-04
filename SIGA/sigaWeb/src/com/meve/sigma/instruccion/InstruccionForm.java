package com.meve.sigma.instruccion;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meve.sigma.struts.SigaForm;
import com.meve.util.Comparadores;
import com.meve.util.DateFormatter;
import com.meve.util.Encabezado;
import com.meve.util.Ordenable;

public class InstruccionForm extends SigaForm implements Ordenable {

	private static final long serialVersionUID = 3451312451757918595L;

	public InstruccionForm() {

	}

	public InstruccionForm(ResultSet rs) throws SQLException {

		idInstruccion = rs.getInt("ID_INSTRUCCION_ASUNTO");
		idAsutno = rs.getInt("ID_ASUNTO");
		idUsuario = rs.getInt("INS_USUARIO");
		idUsuarioAsigno = rs.getInt("ASU_USR_TURNA");
		idInstruccionDescripcion = rs.getInt("INS_INSTRUCCION");
		instruccionDescripcionOtro = rs.getString("INS_INSTRUCCION_OTRO");
		ejecutoria = rs.getInt("INS_TIPO_ATENCION") == 0;
		paso = rs.getInt("INS_PASO");
		tiempo = rs.getInt("INS_TIEMPO");
		conAccesoAlDocumentoOriginal = rs.getInt("INS_ACCESO") == 1;
		folioTurnado = rs.getString("INS_FOLIO_TURNADO");
		folioControl = rs.getString("ASU_FOLIO_EXTERNO");
		folioIntermedio = rs.getString("ASU_FOLIO_INTERMEDIO") != null
				&& !rs.getString("ASU_FOLIO_INTERMEDIO").equals("null") ? rs
				.getString("ASU_FOLIO_INTERMEDIO") : "Sin Folio Intermedio";
		estatus = rs.getInt("INS_ESTATUS");
		avance = rs.getInt("INS_AVANCE");
		asunto = rs.getString("ASU_DESCRIPCION");
		ejecutoria = rs.getInt("INS_TIPO_ATENCION") == 0;
		fechaAsignacion = rs.getDate("INS_FECHA_ASIGNACION") != null ? rs
				.getDate("INS_FECHA_ASIGNACION").getTime() : -1;
		fechaVencimiento = rs.getDate("INS_FECHA_TERMINACION") != null ? rs
				.getDate("INS_FECHA_TERMINACION").getTime() : -1;
		usuarioNombre = rs.getString("USU_CARGO");
		usuarioCargo = rs.getString("USU_NOMBRE");
		usuarioAsignoNombre = rs.getString("USR_TURNO_NOMBRE");
		usuarioAsignoCargo = rs.getString("USR_TURNO_CARGO");
	}

	private int idInstruccion;
	private int idAsutno;
	private int idUsuario;
	private int idUsuarioAsigno;
	private int idinstruccionPadre;
	private int idInstruccionDescripcion;
	private String asunto;
	private String instruccionDescripcion;
	private String instruccionDescripcionOtro;
	private String folioTurnado;
	private String folioControl;
	private String folioIntermedio;
	private String usuarioNombre;
	private String usuarioCargo;
	private String usuarioAsignoNombre;
	private String usuarioAsignoCargo;
	private boolean ejecutoria;
	private int paso;
	private int tiempo;
	private boolean conAccesoAlDocumentoOriginal;
	private int estatus;
	private String estatusNombre;
	private int avance;
	private int semaforo;
	private long fechaAsignacion;
	private long fechaTerminacion;
	private long fechaVencimiento;
	private int totalPorEstatus;

	public int getTotalPorEstatus() {
		return totalPorEstatus;
	}

	public void setTotalPorEstatus(int totalPorEstatus) {
		this.totalPorEstatus = totalPorEstatus;
	}

	public int getIdInstruccion() {
		return idInstruccion;
	}

	public void setIdInstruccion(int idInstruccion) {
		this.idInstruccion = idInstruccion;
	}

	public int getIdAsutno() {
		return idAsutno;
	}

	public void setIdAsutno(int idAsutno) {
		this.idAsutno = idAsutno;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdInstruccionDescripcion() {
		return idInstruccionDescripcion;
	}

	public void setIdInstruccionDescripcion(int idInstruccionDescripcion) {
		this.idInstruccionDescripcion = idInstruccionDescripcion;
	}

	public String getInstruccionDescripcionOtro() {
		return instruccionDescripcionOtro;
	}

	public void setInstruccionDescripcionOtro(String instruccionDescripcionOtro) {
		this.instruccionDescripcionOtro = instruccionDescripcionOtro;
	}

	public int getIdinstruccionPadre() {
		return idinstruccionPadre;
	}

	public void setIdinstruccionPadre(int idinstruccionPadre) {
		this.idinstruccionPadre = idinstruccionPadre;
	}

	public boolean isEjecutoria() {
		return ejecutoria;
	}

	public void setEjecutoria(boolean ejecutoria) {
		this.ejecutoria = ejecutoria;
	}

	public int getPaso() {
		return paso;
	}

	public void setPaso(int paso) {
		this.paso = paso;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String getFolioTurnado() {
		return folioTurnado;
	}

	public void setFolioTurnado(String folioTurnado) {
		this.folioTurnado = folioTurnado;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public int getAvance() {
		return avance;
	}

	public void setAvance(int avence) {
		this.avance = avence;
	}

	public long getFechaAsignacionLong() {
		return fechaAsignacion;
	}

	public String getFechaAsignacion() {
		return DateFormatter.getFecha(fechaAsignacion);
	}

	public void setFechaAsignacion(long fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public long getFechaTerminacionLong() {
		return fechaTerminacion;
	}

	public String getFechaTerminacion() {
		return DateFormatter.getFecha(fechaTerminacion);
	}

	public void setFechaTerminacion(long fechaTerminacion) {
		this.fechaTerminacion = fechaTerminacion;
	}

	public long getFechaVencimientoLong() {
		return fechaVencimiento;
	}

	public String getFechaVencimiento() {
		return DateFormatter.getFecha(fechaVencimiento);
	}

	public void setFechaVencimiento(long fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public boolean isConAccesoAlDocumentoOriginal() {
		return conAccesoAlDocumentoOriginal;
	}

	public void setConAccesoAlDocumentoOriginal(
			boolean conAccesoAlDocumentoOriginal) {
		this.conAccesoAlDocumentoOriginal = conAccesoAlDocumentoOriginal;
	}

	public String getInstruccionDescripcion() {
		return instruccionDescripcion;
	}

	public void setInstruccionDescripcion(String instruccionDescripcion) {
		this.instruccionDescripcion = instruccionDescripcion;
	}

	public String getEstatusNombre() {
		return estatusNombre;
	}

	public void setEstatusNombre(String estatusNombre) {
		this.estatusNombre = estatusNombre;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
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
		InstruccionForm af = (InstruccionForm) obj;
		Field field = af.getClass().getDeclaredField(fieldName);
		String fieldType = field.getType().getName();
		if ("java.lang.String".equals(fieldType)) {
			return Comparadores
					.compare((String) field.get(af), (String) this.getClass()
							.getDeclaredField(fieldName).get(this), ascOrder);
		}
		if ("java.util.Date".equals(fieldType)) {
			return Comparadores
					.compare((Date) field.get(af), (Date) this.getClass()
							.getDeclaredField(fieldName).get(this), ascOrder);
		}
		if ("int".equals(fieldType)) {
			return Comparadores.compare(field.getInt(af), this.getClass()
					.getDeclaredField(fieldName).getInt(this), ascOrder);
		}
		if ("long".equals(fieldType)) {
			return Comparadores.compare(field.getLong(af), this.getClass()
					.getDeclaredField(fieldName).getLong(this), ascOrder);
		}
		return -1;
	}

	public static List getEncabezados() {
		List encabezados = new ArrayList();

		Encabezado encabezadoinstruccion = new Encabezado();
		encabezadoinstruccion.setTitulo("Instruccion");
		encabezadoinstruccion.setWidth(25);

		Encabezado encabezadoFolio = new Encabezado();
		encabezadoFolio.setTitulo("Folio");
		encabezadoFolio.setWidth(20);

		Encabezado encabezadoAsignacion = new Encabezado();
		encabezadoAsignacion.setTitulo("Fecha de asignación");
		encabezadoAsignacion.setWidth(15);

		Encabezado encabezadoUsuario = new Encabezado();
		encabezadoUsuario.setTitulo("Usuario");
		encabezadoUsuario.setWidth(15);

		Encabezado encabezadoEstatus = new Encabezado();
		encabezadoEstatus.setTitulo("Estatus");
		encabezadoEstatus.setWidth(10);

		Encabezado encabezadoAvance = new Encabezado();
		encabezadoAvance.setTitulo("Avance");
		encabezadoAvance.setWidth(15);

		encabezados.add(encabezadoinstruccion);
		encabezados.add(encabezadoFolio);
		encabezados.add(encabezadoAsignacion);
		encabezados.add(encabezadoUsuario);
		encabezados.add(encabezadoEstatus);
		encabezados.add(encabezadoAvance);

		return encabezados;
	}

	public static List getAtributos() {
		List atributos = new ArrayList();
		atributos.add("instruccionDescripcion");
		atributos.add("folioTurnado");
		atributos.add("fechaAsignacion");
		atributos.add("usuarioNombre");
		atributos.add("estatusNombre");
		atributos.add("avance");
		return atributos;
	}

	public static List getAtributosTotales() {
		List atributos = new ArrayList();
		atributos.add("totalPorEstatus");
		atributos.add("estatusNombre");
		atributos.add("usuarioNombre");
		return atributos;
	}

	public static List getOrden() {
		List orden = new ArrayList();
		orden.add("asc");
		orden.add("asc");
		orden.add("asc");
		orden.add("asc");
		orden.add("asc");
		orden.add("asc");
		return orden;
	}

	public int getIdUsuarioAsigno() {
		return idUsuarioAsigno;
	}

	public void setIdUsuarioAsigno(int idUsuarioAsigno) {
		this.idUsuarioAsigno = idUsuarioAsigno;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getFolioControl() {
		return folioControl;
	}

	public void setFolioControl(String folioControl) {
		this.folioControl = folioControl;
	}

	public String getFolioIntermedio() {
		return folioIntermedio;
	}

	public void setFolioIntermedio(String folioIntermedio) {
		this.folioIntermedio = folioIntermedio;
	}

	public String getUsuarioAsignoNombre() {
		return usuarioAsignoNombre;
	}

	public void setUsuarioAsignoNombre(String usuarioAsignoNombre) {
		this.usuarioAsignoNombre = usuarioAsignoNombre;
	}

	public int getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(int semaforo) {
		this.semaforo = semaforo;
	}

	public String getUsuarioCargo() {
		return usuarioCargo;
	}

	public void setUsuarioCargo(String usuarioCargo) {
		this.usuarioCargo = usuarioCargo;
	}

	public String getUsuarioAsignoCargo() {
		return usuarioAsignoCargo;
	}

	public void setUsuarioAsignoCargo(String usuarioAsignoCargo) {
		this.usuarioAsignoCargo = usuarioAsignoCargo;
	}

}
