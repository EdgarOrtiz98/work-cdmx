/*
 * Clase:						UsuarioBean.java
 * Paquete:						com.meve.sigma.beans		
 * Versión						1.0
 * Fecha Creación:				Sep 26, 2005
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * Empresa:						Meve Soluciones S.A. de C.V.
 * Contacto:					http://www.tecnoaplicada.com
 * Descripción de la clase:
 */

package com.meve.sigma.beans;

/**
 * Bean Usuario contiene todos los datos del usuario
 * 
 * @author Meve Soluciones S.A. de C.V.
 */

public class UsuarioBean {
	public final static String 	ORG_USUARIOS = "orgUsuarios";
	/**
	 * Nombre usuario
	 */
	private String strNombre;
	/**
	 * Id usuairo
	 */
	private String strIdUsuario;
	/**
	 * área usuario
	 */
	private String strIdArea;
	/**
	 * Cargo usuario
	 */
	private String strCargo;
	/**
	 * E-mail usuario
	 */
	private String strCorreo;
	/**
	 * Telefono usuario
	 */
	private String strTelefono;
	/**
	 * Intentos fallidos al tratar de logearse
	 */
	private String strConsecutivo;
	/**
	 * Rol usuario
	 */
	private String strIdRol;
	/**
	 * Id Jefe-usuario
	 */
	private String strIdJefe;
	/**
	 * Id asistente
	 */
	private String strIdAsistente;
	/**
	 * UID
	 */
	private String strUID;
	/**
	 * Firma electronica ( bandera )
	 */
	private boolean blnExisteFirma;
	/**
	 * Rol Administración ( bandera )
	 */
	private boolean bAdmon;
	/**
	 * Rol atención ( bandera )
	 */
	private boolean bAtencion;
	/**
	 * Rol gestión ( bandera )
	 */
	private boolean bGestion;
	/**
	 * Rol Recepción ( bandera )
	 */
	private boolean bRecepcion;
	/**
	 * Rol Supervisor ( bandera )
	 */
	private boolean bSupervisor;
	/**
	 * Rol Turnador ( bandera )
	 */
	private boolean bTurnado;
	/**
	 * Rol Asistente ( bandera )
	 */
	private boolean bAsistente;
	/**
	 * notificación de nuevo asunto ( bandera )
	 */
	private boolean bNuevoAsunto;
	/**
	 * notificación turnado ( bandera )
	 */
	private boolean bTurnar;
	/**
	 * notificación de respuesta ( bandera )
	 */
	private boolean bResponder;
	/**
	 * notificación de rechazo ( bandera )
	 */
	private boolean bRechazar;
	/**
	 * notificación de delegado ( bandera )
	 */
	private boolean bDelegar;
	/**
	 * Notificacion de reasignar ( bandera )
	 */
	private boolean bReasignar;
	/**
	 * notificación para Delegación multiple ( bandera )
	 */
	private boolean bHabilitar;
	/**
	 * Solicitud de cambio de fecha ( bandera )
	 */
	private boolean bSolCambio;
	/**
	 * notificación de respuesta de cambio de fecha ( bandera )
	 */
	private boolean bRespCambio;
	/**
	 * Acceso a catalogos de archivado
	 */
	private String strCat;

	/**
	 * 
	 * @param nombre
	 *            Nombre usuario
	 * @param idUsuario
	 *            Id usuairo
	 * @param idArea
	 *            área usuario
	 * @param cargo
	 *            Cargo usuario
	 * @param correo
	 *            E-mail usuario
	 * @param telefono
	 *            Teléfono usuario
	 * @param consecutivo
	 *            Intentos fallidos al tratar de logearse
	 * @param idRol
	 *            Rol usuario
	 * @param idJefe
	 *            Id Jefe-usuario
	 * @param idAsistente
	 *            Id asistente
	 * @param admin
	 *            Rol Administración ( bandera )
	 * @param atencion
	 *            Rol atención ( bandera )
	 * @param gestion
	 *            Rol gestión ( bandera )
	 * @param recepcion
	 *            Rol Recepción ( bandera )
	 * @param supervisor
	 *            Rol Supervisor ( bandera )
	 * @param turnado
	 *            Rol Turnador ( bandera )
	 * @param asistente
	 *            Rol Asistente ( bandera )
	 * @param nuevoAsunto
	 *            notificación de nuevo asunto ( bandera )
	 * @param turnar
	 *            notificación turnado ( bandera )
	 * @param responder
	 *            notificación de respuesta ( bandera )
	 * @param rechazar
	 *            notificación de rechazo ( bandera )
	 * @param delegar
	 *            Notificacion de reasignar ( bandera )
	 * @param reasignar
	 *            Notificacion de reasignar ( bandera )
	 * @param habilitar
	 *            notificación para Delegación multiple ( bandera )
	 * @param solCambio
	 *            Solicitud de cambio de fecha ( bandera )
	 * @param respCambio
	 *            notificación de respuesta de cambio de fecha ( bandera )
	 * @param UID
	 *            UID
	 * @param Cat
	 *            Acceso a catalogos de archivado
	 */
	public UsuarioBean(String nombre, String idUsuario, String idArea,
			String cargo, String correo, String telefono, String consecutivo,
			String idRol, String idJefe, String idAsistente, /* Object firma, */
			boolean admin, boolean atencion, boolean gestion,
			boolean recepcion, boolean supervisor, boolean turnado,
			boolean asistente, boolean nuevoAsunto, boolean turnar,
			boolean responder, boolean rechazar, boolean delegar,
			boolean reasignar, boolean habilitar, boolean solCambio,
			boolean respCambio, String UID, String Cat) {
		strNombre = nombre;
		strIdUsuario = idUsuario;
		strIdArea = idArea;
		strCargo = cargo;
		strCorreo = correo;
		strTelefono = telefono;
		strConsecutivo = consecutivo;
		strIdRol = idRol;
		strIdJefe = idJefe;
		strIdAsistente = idAsistente;
		/*
		 * if(firma!=null) blnExisteFirma=true;
		 */
		bAdmon = admin;
		bAtencion = atencion;
		bGestion = gestion;
		bRecepcion = recepcion;
		bSupervisor = supervisor;
		bTurnado = turnado;
		bAsistente = asistente;
		bNuevoAsunto = nuevoAsunto;
		bTurnar = turnar;
		bResponder = responder;
		bRechazar = rechazar;
		bDelegar = delegar;
		bReasignar = reasignar;
		bHabilitar = habilitar;
		bSolCambio = solCambio;
		bRespCambio = respCambio;
		strUID = UID;
		strCat = Cat;
	}

	/**
	 * Constructor por defecto
	 */
	public UsuarioBean() {

	}

	/**
	 * Extrae Nombre usuario
	 * 
	 * @return Nombre usuario
	 */
	public String getNombre() {
		return strNombre;
	}

	/**
	 * Extrae Id de usuario
	 * 
	 * @return Id de usuario
	 */
	public String getIdUsuario() {
		return strIdUsuario;
	}

	/**
	 * Extrae id area
	 * 
	 * @return id area
	 */
	public String getIdArea() {
		return strIdArea;
	}

	public void setIdArea(String strIdArea) {
		this.strIdArea = strIdArea;
	}

	/**
	 * Extrae Cargo usuario
	 * 
	 * @return Cargo usuario
	 */
	public String getCargo() {
		return strCargo;
	}

	/**
	 * Extrae E-mail usuario
	 * 
	 * @return E-mail usuario
	 */
	public String getCorreo() {
		return strCorreo;
	}

	/**
	 * Extrae Teléfono usuario
	 * 
	 * @return Teléfono usuario
	 */
	public String getTelefono() {
		return strTelefono;
	}

	/**
	 * Extrae Intentos fallidos al tratar de logearse
	 * 
	 * @return Intentos fallidos al tratar de logearse
	 */
	public String getConsecutivo() {
		return strConsecutivo;
	}

	/**
	 * Extrae Rol usuario
	 * 
	 * @return Rol usuario
	 */
	public String getIdRol() {
		return strIdRol;
	}

	/**
	 * Extrae Id Jefe-usuario
	 * 
	 * @return Id Jefe-usuario
	 */
	public String getIdJefe() {
		return strIdJefe;
	}

	/**
	 * Extrae Id asistente
	 * 
	 * @return Id asistente
	 */
	public String getIdAsistente() {
		return strIdAsistente;
	}

	/*
	 * public boolean existeFirma(){ return blnExisteFirma; }
	 */

	/**
	 * Extrae Rol Administración ( bandera )
	 * 
	 * @return Rol Administración
	 */
	public boolean getAdmon() {
		return bAdmon;
	}

	/**
	 * Extrae Rol atención ( bandera )
	 * 
	 * @return Rol atención
	 */
	public boolean getAtencion() {
		return bAtencion;
	}

	/**
	 * Extrae Rol gestión ( bandera )
	 * 
	 * @return Rol gestión
	 */
	public boolean getGestion() {
		return bGestion;
	}

	/**
	 * 
	 * @return Rol gestión
	 */
	public boolean getSCP() {
		return bGestion;
	}

	/**
	 * Extrae Rol Recepción ( bandera )
	 * 
	 * @return Rol Recepción
	 */
	public boolean getRecepcion() {
		return bRecepcion;
	}

	/**
	 * Extrae Rol Supervisor ( bandera )
	 * 
	 * @return Rol Supervisor
	 */
	public boolean getSupervisor() {
		return bSupervisor;
	}

	/**
	 * Extrae Turnador ( bandera )
	 * 
	 * @return Turnador
	 */
	public boolean getTurnado() {
		return bTurnado;
	}

	/**
	 * Extrae Rol Asistente ( bandera )
	 * 
	 * @return Rol Asistente
	 */
	public boolean getAsistente() {
		return bAsistente;
	}

	/**
	 * Extrae notificación de nuevo asunto ( bandera )
	 * 
	 * @return notificación de nuevo asunto
	 */
	public boolean getNuevoAsunto() {
		return bNuevoAsunto;
	}

	/**
	 * Extrae notificación turnado ( bandera )
	 * 
	 * @return notificación turnado
	 */
	public boolean getTurnar() {
		return bTurnar;
	}

	/**
	 * Extrae notificación de respuesta ( bandera )
	 * 
	 * @return notificación de respuesta
	 */
	public boolean getResponder() {
		return bResponder;
	}

	/**
	 * Extrae notificación de rechazo ( bandera )
	 * 
	 * @return notificación de rechazo
	 */
	public boolean getRechazar() {
		return bRechazar;
	}

	/**
	 * Extrae Notificacion de reasignar ( bandera )
	 * 
	 * @return Notificacion de reasignar
	 */
	public boolean getDelegar() {
		return bDelegar;
	}

	/**
	 * Extrae Notificacion de reasignar ( bandera )
	 * 
	 * @return Notificacion de reasignar
	 */
	public boolean getReasignar() {
		return bReasignar;
	}

	/**
	 * Extrae notificación para Delegación multiple ( bandera )
	 * 
	 * @return notificación para Delegación multiple
	 */
	public boolean getHabilitar() {
		return bHabilitar;
	}

	/**
	 * Extrae Solicitud de cambio de fecha ( bandera )
	 * 
	 * @return Solicitud de cambio de fecha
	 */
	public boolean getSolCambio() {
		return bSolCambio;
	}

	/**
	 * Extrae notificación de respuesta de cambio de fecha ( bandera )
	 * 
	 * @return notificación de respuesta de cambio de fecha
	 */
	public boolean getRespCambio() {
		return bRespCambio;
	}

	/**
	 * Extrae UID
	 * 
	 * @return UID
	 */
	public String getUID() {
		return strUID;
	}

	/**
	 * Extrae Acceso a catalogos de archivado (bandera)
	 * 
	 * @return Acceso a catalogos de archivado
	 */
	public String getCatArchivado() {
		return strCat;
	}

	public String getStrNombre() {
		return strNombre;
	}

	public void setStrNombre(String strNombre) {
		this.strNombre = strNombre;
	}

	public String getStrIdUsuario() {
		return strIdUsuario;
	}

	public void setStrIdUsuario(String strIdUsuario) {
		this.strIdUsuario = strIdUsuario;
	}

	public String getStrIdArea() {
		return strIdArea;
	}

	public void setStrIdArea(String strIdArea) {
		this.strIdArea = strIdArea;
	}

	public String getStrCargo() {
		return strCargo;
	}

	public void setStrCargo(String strCargo) {
		this.strCargo = strCargo;
	}

	public String getStrCorreo() {
		return strCorreo;
	}

	public void setStrCorreo(String strCorreo) {
		this.strCorreo = strCorreo;
	}

	public String getStrTelefono() {
		return strTelefono;
	}

	public void setStrTelefono(String strTelefono) {
		this.strTelefono = strTelefono;
	}

	public String getStrConsecutivo() {
		return strConsecutivo;
	}

	public void setStrConsecutivo(String strConsecutivo) {
		this.strConsecutivo = strConsecutivo;
	}

	public String getStrIdRol() {
		return strIdRol;
	}

	public void setStrIdRol(String strIdRol) {
		this.strIdRol = strIdRol;
	}

	public String getStrIdJefe() {
		return strIdJefe;
	}

	public void setStrIdJefe(String strIdJefe) {
		this.strIdJefe = strIdJefe;
	}

	public String getStrIdAsistente() {
		return strIdAsistente;
	}

	public void setStrIdAsistente(String strIdAsistente) {
		this.strIdAsistente = strIdAsistente;
	}

	public String getStrCat() {
		return strCat;
	}

	public void setStrCat(String strCat) {
		this.strCat = strCat;
	}

}
