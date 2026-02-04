package com.meve.sigma.asunto;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meve.sigma.catalogos.CatalogoEntidad;
import com.meve.sigma.struts.SigaForm;
import com.meve.sigma.util.Utilerias;
import com.meve.util.Comparadores;
import com.meve.util.DateFormatter;
import com.meve.util.Encabezado;
import com.meve.util.Ordenable;

/**
 * Form que contiene los datos de un asunto de registros de la Tabla de área
 * 
 * @author Xgress
 */
public class AsuntoForm extends SigaForm implements Ordenable {

	public AsuntoForm() {
	}

	public AsuntoForm(ResultSet rs) {
		try {
			this.setIdAsunto(rs.getInt("ID_ASUNTO"));
			this.setEstatus(rs.getInt("ASU_ESTATUS"));
			this.setControl(rs.getInt("ASU_CONTROL")==1?"Interno":"Externo");
			this.setAsunto(rs.getString("ASU_DESCRIPCION"));
			this.setIdentificadorDocumento(rs.getString("ASU_FOLIO_EXTERNO"));
			//this.setFolioRecepcion(rs.getString("ASU_FOLIO_RECEPCION"));
			this.setIdArea(rs.getInt("ASU_ENTIDAD"));
			this.setDescripcion(rs.getString("ASU_SINTESIS"));
			this.setIdEntidad(rs.getInt("ASU_ENTIDAD"));
			this.setIdRemitente(rs.getInt("ASU_REMITENTE"));
			this.setFirmanteNombre(rs.getString("ASU_FIRMANTE"));
			this.setIdTipoDocumento(rs.getInt("ASU_TIP_DOCTO"));
			this
					.setFechaRecepcion(rs.getString("ASU_FECHA_RECEPCION") != null ? rs
							.getString("ASU_FECHA_RECEPCION")
							: "");
			this.setFechaDocto(rs.getString("ASU_FECHA_DOCTO") != null ? rs
					.getString("ASU_FECHA_DOCTO"): "");
			this.setFechaCad(rs.getString("ASU_FECHA_CADUCIDAD") != null ? rs
					.getString("ASU_FECHA_CADUCIDAD"): "");
			this.setFechaCaptura(rs.getString("ASU_FECHA_CAPTURA") != null ? rs
					.getString("ASU_FECHA_CAPTURA"): "");
			this
					.setFechaTerminacion(rs.getString("ASU_FECHA_TERMINACION") != null ? rs
							.getString("ASU_FECHA_TERMINACION")
							: "");
			this.setFechaEvento(rs.getString("ASU_FECHA_EVENTO")!=null?rs.getString("ASU_FECHA_EVENTO"):"");
			this.setFolioExt(rs.getString("ASU_FOLIO_EXTERNO"));
			this.setFolioInt(rs.getString("ASU_FOLIO_INTERMEDIO")==null?"Sin folio Intermedio":rs.getString("ASU_FOLIO_INTERMEDIO"));
			this.setSintesis(rs.getString("ASU_SINTESIS"));
			this.setComentario(rs.getString("ASU_COMENTARIOS"));
			this.setPalabraClave(rs.getString("ASU_PALABRA_CLAVE"));
			this.setIdPrioridad(rs.getInt("ASU_PRIORIDAD"));
			this.setFolioRecepcion(rs.getString("ASU_FOLIO_RECEPCION"));
			this.setIdUsuarioCaptura(rs.getInt("ASU_USUARIO_CAPTURA"));
			this.setAvance(rs.getFloat("ASU_AVANCE"));
			this.setFolioControl(rs.getString("ASU_FOLIO_ENTRADA"));
			this.setEntidad(rs.getInt("ASU_CONTROL")==0?rs.getString("REMITENTE_ENTIDAD"):"");
			//this.setRemitenteNombre(rs.getInt("ASU_CONTROL")==1?rs.getString("RMT_NOMBRE"):"");
			//this.setRemitenteNombre("LIBORIO");
			//System.out.println("NOMBRER1:"+ rs.getString("RMT_NOMBRE")+"idremitente:"+rs.getString("ID_ASUNTO"));
			//System.out.println("control:"+rs.getInt("ASU_CONTROL")+"NOMBRER2:"+ getRemitenteNombre());
			
			this.setAsuntoPara(rs.getString("ASU_LISTAIDS_PARA"));
			this.setLugarEvento(rs.getString("ASU_LUGAR_EVENTO")==null?"":rs.getString("ASU_LUGAR_EVENTO"));
			this.setIdTipoAsunto(rs.getInt("ASU_TIPO_ASUNTO"));
			this.setIdTramite(rs.getString("ASU_TRAMITE")==null?-1:rs.getInt("ASU_TRAMITE"));
			
			
			this.sethora_evento(rs.getString("ASU_HORA_EVENTO")==null?"":rs.getString("ASU_HORA_EVENTO")+":");
			this.setMin_evento(rs.getString("ASU_MIN_EVENTO")==null?"":rs.getString("ASU_MIN_EVENTO"));	
			this.setAsuntoIdsCC(rs.getString("ASU_LISTAIDS_CC"));
			this.setidUsuarioTurna(rs.getInt("ASU_USR_TURNA"));			
			this.setAsuntoIdsParaE(rs.getString("ASU_LISTAIDS_PARA_EXT"));
			//this.setRemitenteCargo(rs.getString("RMT_CARGO"));
			
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static final long serialVersionUID = -8172029433665268958L;

	private int idAsunto;

	private int estatus;

	private String estatusNombre;

	private String asunto;

	private String cadenaBusqueda;

	private String segundaCadenaBusqueda;
	
	private String descripcion;

	private CatalogoEntidad ua;// TODO: eliminar

	private String entidad;

	private int idEntidad = -1;

	private String puesto;

	private int idPuesto;

	private String responsable;

	private String idResponsable;
	
	private String identificadorDocumento;
	
	private String area;

	private int idArea = -1;

	private int entidadPermiso;

	private int idRemitente;
	
	private String remitente;

	private String remitenteNombre="";

	private String cargo;

	private String correo;

	private String firmanteNombre;

	private int idDestinatario;

	private String destinatarioNombre;

	private String asuntoCargoDest;

	private String asuntoAreaDest;

	private String mailDest;

	private int idTipoAsunto;
	
	private String tipoAsuntoNombre;

	private String tipoDocto;

	private String fechaRecepcion;

	private String fechaDocto;

	private String fechaCad;

	private String fechaCaptura;

	private String fechaTerminacion;
	
	private String fechaEvento;

	private String folioExt;

	private String folioInt;


	private String folioControl;

	private String asuntoSintesis;

	private float avance;

	private String comentario;

	private String sintesis;

	private String palabraClave;

	private String anterior;

	private int idPrioridad;
	
	private String prioridadNombre;

	private String tipoAsunto;

	private String rutaAuto;

	private String control;

	private String url;

	private String folioRecepcion;

	private int idTipoDocumento;

	private int idUsuarioCaptura;
	
	private String usuarioCaptura;

	private String procedencia;

	private String tipoAsu;

	private String asuntoPara;

	private String asuntoCC;

	private String asuntoIdsPara;

	private String asuntoIdsCC;


	private String lugarEvento;

	private String hora_evento;

	private String min_evento;

	private String strDuplicado;

	private String asuntoIdsParaE;

	private String asuntoParaE;

	private int idAsuntoAnt;

	private int idAsuntoRef;
	
	private int idTramite;

	private String tramiteNombre;

	private int asuntoTipoFolio;

	private String horaRecepcion;

	private String minRecepcion;

	private int totalPorEstatus;

	private String asuntosRelacionados;

	private int semaforo;
	
	private String respuestaAsunto;
	
	private String Pruebas;
	
	private String Asuntid;
	private String UsuarioTurna;
	private int idUsuarioTurna;
	//private String remitenteCargo;
	
	/*private String hora_evento;
	private String min_evento;*/
	

	public String getRespuestaAsunto() {
		return respuestaAsunto;
	}

	public void setRespuestaAsunto(String respuestaAsunto) {
		this.respuestaAsunto = respuestaAsunto;
	}
	public String getAsuntid(){
		return Asuntid;
	}
	public void setAsuntid(String Asuntid){
		this.Asuntid=Asuntid;
	}
	public String getPruebas(){
		return Pruebas;
	}
	public void setPruebas(String Pruebas){
		this.Pruebas=Pruebas;
	}

	public int getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(int semaforo) {
		this.semaforo = semaforo;
	}

	public int getIdAsunto() {
		return idAsunto;
	}

	public void setIdAsunto(int idAsunto) {
		this.idAsunto = idAsunto;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public int getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

	public int getIdRemitente() {
		return idRemitente;
	}

	public void setIdRemitente(int idRemitente) {
		this.idRemitente = idRemitente;
	}

	public String getRemitenteNombre() {
		return remitenteNombre;
	}

	public void setRemitenteNombre(String remitenteNom) {
		this.remitenteNombre = remitenteNom;
	}		

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFirmanteNombre() {
		return firmanteNombre;
	}

	public void setFirmanteNombre(String firmanteNombre) {
		this.firmanteNombre = firmanteNombre;
	}

	public int getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(int idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public String getDestinatarioNombre() {
		return destinatarioNombre;
	}

	public void setDestinatarioNombre(String destinatarioNombre) {
		this.destinatarioNombre = destinatarioNombre;
	}

	public String getAsuntoCargoDest() {
		return asuntoCargoDest;
	}

	public void setAsuntoCargoDest(String asuntoCargoDest) {
		this.asuntoCargoDest = asuntoCargoDest;
	}

	public String getAsuntoAreaDest() {
		return asuntoAreaDest;
	}

	public void setAsuntoAreaDest(String asuntoAreaDest) {
		this.asuntoAreaDest = asuntoAreaDest;
	}

	public String getMailDest() {
		return mailDest;
	}

	public void setMailDest(String mailDest) {
		this.mailDest = mailDest;
	}


	public String getTipoDocto() {
		return tipoDocto;
	}

	public void setTipoDocto(String tipoDocto) {
		this.tipoDocto = tipoDocto;
	}

	public String getFechaTerminacionLong() {
		return fechaTerminacion;
	}

	public String getFechaTerminacion() {
		return fechaTerminacion;
	}

	public void setFechaTerminacion(String fechaTerminacion) {
		this.fechaTerminacion = fechaTerminacion;
	}

	public String getFechaRecepcionLong() {
		return fechaRecepcion;
	}

	public String getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getFechaDoctoLong() {
		return fechaDocto;
	}

	public String getFechaDocto() {
		return fechaDocto;
	}

	public void setFechaDocto(String fechaDocto) {
		this.fechaDocto = fechaDocto;
	}

	public String getFechaCadLong() {
		return fechaCad;
	}

	public String getFechaCad() {
		return fechaCad;
	}

	public void setFechaCad(String fechaCad) {
		this.fechaCad = fechaCad;
	}

	public String getFechaEventoLong() {
		return fechaEvento;
	}

	public String getFechaEvento(){
		return fechaEvento;
	}
	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	
	public String getFolioExt() {
		return folioExt;
	}

	public void setFolioExt(String folioExt) {
		this.folioExt = folioExt;
	}

	public String getFolioInt() {
		if (folioInt.equals(null) || folioInt.equals("")||folioInt.equals("null")){
			return "Sin folio Intermedio";			
		}
		else{
			return folioInt;
		}					
	}

	public void setFolioInt(String folioInt) {
		this.folioInt = folioInt;
	}

	public String getAsuntoSintesis() {
		return asuntoSintesis;
	}

	public void setAsuntoSintesis(String asuntoSintesis) {
		this.asuntoSintesis = asuntoSintesis;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getPalabraClave() {
		return palabraClave;
	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}

	public String getAnterior() {
		return anterior;
	}

	public void setAnterior(String anterior) {
		this.anterior = anterior;
	}

	public String getTipoAsunto() {
		return tipoAsunto;
	}

	public void setTipoAsunto(String tipoAsunto) {
		this.tipoAsunto = tipoAsunto;
	}

	public String getRutaAuto() {
		return rutaAuto;
	}

	public void setRutaAuto(String rutaAuto) {
		this.rutaAuto = rutaAuto;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String pro) {
		this.procedencia = pro;
	}

	public String getTipoAsu() {
		return tipoAsu;
	}

	public void setTipoAsu(String tipoAsu) {
		this.tipoAsu = tipoAsu;
	}

	public String getAsuntoPara() {
		return asuntoPara;
	}

	public void setAsuntoPara(String asuntoPara) {
		this.asuntoPara = asuntoPara;
	}

	public String getAsuntoCC() {
		return asuntoCC;
	}

	public void setAsuntoCC(String asuntoCC) {
		this.asuntoCC = asuntoCC;
	}

	public String getAsuntoIdsPara() {
		return asuntoIdsPara;
	}

	public void setAsuntoIdsPara(String asuntoIdsPara) {
		this.asuntoIdsPara = asuntoIdsPara;
	}

	public String getAsuntoIdsCC() {
		return asuntoIdsCC;
	}

	public void setAsuntoIdsCC(String asuntoIdsCC) {
		this.asuntoIdsCC = asuntoIdsCC;
	}


	public String getLugarEvento() {
		if (lugarEvento.equals("null"))
			return "";		
		else
			return lugarEvento;		
	}

	public void setLugarEvento(String lugarEvento) {
		this.lugarEvento = lugarEvento;
	}

	public String gethora_evento() {
		return hora_evento;
	}

	public void sethora_evento(String hora_evento) {
		this.hora_evento = hora_evento;
	}

	public String getMin_evento() {
		return (min_evento.equals("0")?"00":min_evento);
	}

	public void setMin_evento(String min_evento) {
		this.min_evento = min_evento;
	}

	public String getStrDuplicado() {
		return strDuplicado;
	}

	public void setStrDuplicado(String strDuplicado) {
		this.strDuplicado = strDuplicado;
	}

	public String getAsuntoIdsParaE() {
		return asuntoIdsParaE;
	}

	public void setAsuntoIdsParaE(String asuntoIdsParaE) {
		this.asuntoIdsParaE = asuntoIdsParaE;
	}

	public String getAsuntoParaE() {
		return asuntoParaE;
	}

	public void setAsuntoParaE(String asuntoParaE) {
		this.asuntoParaE = asuntoParaE;
	}

	public int getIdAsuntoAnt() {
		return idAsuntoAnt;
	}

	public void setIdAsuntoAnt(int idAsuntoAnt) {
		this.idAsuntoAnt = idAsuntoAnt;
	}

	public int getIdAsuntoRef() {
		return idAsuntoRef;
	}

	public void setIdAsuntoRef(int idAsuntoRef) {
		this.idAsuntoRef = idAsuntoRef;
	}


	public int getAsuntoTipoFolio() {
		return asuntoTipoFolio;
	}

	public void setAsuntoTipoFolio(int asuntoTipoFolio) {
		this.asuntoTipoFolio = asuntoTipoFolio;
	}

	public String getHoraRecepcion() {
		return horaRecepcion;
	}

	public void setHoraRecepcion(String horaRecepcion) {
		this.horaRecepcion = horaRecepcion;
	}

	public String getMinRecepcion() {
		return minRecepcion;
	}

	public void setMinRecepcion(String minRecepcion) {
		this.minRecepcion = minRecepcion;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public CatalogoEntidad getUa() {
		return ua;
	}

	public void setUa(CatalogoEntidad ua) {
		this.ua = ua;
	}

	public String getCadenaBusqueda() {
		return cadenaBusqueda;
	}

	public void setCadenaBusqueda(String cadenaBusqueda) {
		this.cadenaBusqueda = cadenaBusqueda;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getEntidadPermiso() {
		return entidadPermiso;
	}

	public void setEntidadPermiso(int entidadPermiso) {
		this.entidadPermiso = entidadPermiso;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public int getIdPuesto() {
		return idPuesto;
	}

	public void setIdPuesto(int idPuesto) {
		this.idPuesto = idPuesto;
	}

	public String getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(String idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getSegundaCadenaBusqueda() {
		return segundaCadenaBusqueda;
	}

	public void setSegundaCadenaBusqueda(String segundaCadenaBusqueda) {
		this.segundaCadenaBusqueda = segundaCadenaBusqueda;
	}

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getSintesis() {
		return sintesis;
	}

	public void setSintesis(String sintesis) {
		this.sintesis = sintesis;
	}

	public String getFolioRecepcion() {
		return folioRecepcion;
	}

	public void setFolioRecepcion(String folioRecepcion) {
		this.folioRecepcion = folioRecepcion;
	}

	public int getIdUsuarioCaptura() {
		return idUsuarioCaptura;
	}

	public void setIdUsuarioCaptura(int idUsuarioCaptura) {
		this.idUsuarioCaptura = idUsuarioCaptura;
	}	
	public String getFechaCapturaLong() {
		return fechaCaptura;
	}

	public String getFechaCaptura() {		
		return fechaCaptura;
	}

	public void setFechaCaptura(String fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}


	public String getAsuntoCorto() {
		return Utilerias.recortaString(asunto, 30);
	}

	public int getTotalPorEstatus() {
		return totalPorEstatus;
	}

	public void setTotalPorEstatus(int totalPorEstatus) {
		this.totalPorEstatus = totalPorEstatus;
	}

	public String getUsuarioTurna() {
		return UsuarioTurna;
	}

	public void setUsuarioTurna(String UsuarioTurna) {
		this.UsuarioTurna = UsuarioTurna;
	}
	public int getidUsuarioTurna() {
		return idUsuarioTurna;
	}

	public void setidUsuarioTurna(int idUsuarioTurna) {
		this.idUsuarioTurna = idUsuarioTurna;
	}
	public String getEstatusNombre() {
		return estatusNombre;
	}

	public void setEstatusNombre(String estatusNombre) {
		this.estatusNombre = estatusNombre;
	}
	/*
	public void sethora_evento(String hora_evento) {
		this.hora_evento = hora_evento;
	}
	public String gethora_evento() {
		return hora_evento;		
	}
	public void setmin_evento(String min_evento) {
		this.min_evento = min_evento;
	}
	public String getmin_evento() {
		return min_evento;		
	}*/	
	

	public int compareTo(Ordenable obj, String fieldName, boolean ascOrder)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		if (this == obj) {
			return 0;
		}
		if (!obj.getClass().getName().equals(this.getClass().getName())) {
			return -1;
		}
		AsuntoForm af = (AsuntoForm) obj;
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
		Encabezado encabezadoAsunto = new Encabezado();
		encabezadoAsunto.setTitulo("Asunto");
		encabezadoAsunto.setWidth(25);

		Encabezado encabezadoFolio = new Encabezado();
		encabezadoFolio.setTitulo("Folio");
		encabezadoFolio.setWidth(20);

		Encabezado encabezadoRecepcion = new Encabezado();
		encabezadoRecepcion.setTitulo("Fecha de Recepción");
		encabezadoRecepcion.setWidth(15);

		Encabezado encabezadoDocumento = new Encabezado();
		encabezadoDocumento.setTitulo("Documento");
		encabezadoDocumento.setWidth(15);

		Encabezado encabezadoOrigen = new Encabezado();
		encabezadoOrigen.setTitulo("Origen");
		encabezadoOrigen.setWidth(15);

		Encabezado encabezadoEstatus = new Encabezado();
		encabezadoEstatus.setTitulo("Estatus");
		encabezadoEstatus.setWidth(10);

		encabezados.add(encabezadoAsunto);
		encabezados.add(encabezadoFolio);
		encabezados.add(encabezadoRecepcion);
		encabezados.add(encabezadoDocumento);
		encabezados.add(encabezadoOrigen);
		encabezados.add(encabezadoEstatus);

		return encabezados;
	}

	public static List getAtributos() {
		List atributos = new ArrayList();
		atributos.add("asunto");
		atributos.add("folioRecepcion");
		atributos.add("fechaRecepcion");
		atributos.add("fechaDocto");
		atributos.add("procedencia");
		atributos.add("estatusNombre");
		return atributos;
	}

	public static List getAtributosTotales() {
		List atributos = new ArrayList();
		atributos.add("totalPorEstatus");
		atributos.add("estatusNombre");
		atributos.add("procedencia");
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

	public float getAvance() {
		return avance;
	}

	public void setAvance(float avance) {
		this.avance = avance;
	}

	public String getFolioControl() {
		return folioControl;
	}

	public void setFolioControl(String folioControl) {
		this.folioControl = folioControl;
	}

	public String getAsuntosRelacionados() {
		return asuntosRelacionados;
	}

	public void setAsuntosRelacionados(String asuntosRelacionados) {
		this.asuntosRelacionados = asuntosRelacionados;
	}

	public int getIdTramite() {
		return idTramite;
	}

	public void setIdTramite(int idTramite) {
		this.idTramite = idTramite;
	}

	public String getTramiteNombre() {
		return tramiteNombre;
	}

	public void setTramiteNombre(String tramiteNombre) {
		this.tramiteNombre = tramiteNombre;
	}

	public String getIdentificadorDocumento() {
		return identificadorDocumento;
	}

	public void setIdentificadorDocumento(String identificadorDocumento) {
		this.identificadorDocumento = identificadorDocumento;
	}

	public int getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(int idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public String getPrioridadNombre() {
		return prioridadNombre;
	}

	public void setPrioridadNombre(String prioridadNombre) {
		this.prioridadNombre = prioridadNombre;
	}

	public int getIdTipoAsunto() {
		return idTipoAsunto;
	}

	public void setIdTipoAsunto(int idTipoAsunto) {
		this.idTipoAsunto = idTipoAsunto;
	}

	public String getTipoAsuntoNombre() {
		return tipoAsuntoNombre;
	}

	public void setTipoAsuntoNombre(String tipoAsuntoNombre) {
		this.tipoAsuntoNombre = tipoAsuntoNombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuarioCaptura() {
		return usuarioCaptura;
	}

	public void setUsuarioCaptura(String usuarioCaptura) {
		this.usuarioCaptura = usuarioCaptura;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}


}
