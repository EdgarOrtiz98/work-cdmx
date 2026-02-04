package com.meve.sigma.organizacional.puesto;

import java.util.ArrayList;
import java.util.List;

import com.meve.sigma.struts.SigaForm;

public class PuestoForm extends SigaForm {

	private static final long serialVersionUID = -9059478131931478710L;

	private int idPuesto;
	private int idUnidadAdministrativa = -1;
	private int idJefe=-1;
	private int idSubventanilla=0;
	private int consecutivo;
	private int idUsuarioActualizo;
	private String usuario;
	private String password;
	private String puesto;
	private String responsable;
	private String unidadAdministrativa;
	private String correo;
	private String telefono;
	private String jefe;
	private String[] idAsistentes;
	private String[] idRoles;
	private String[] idCorreosSalida;
	private boolean corresEntrada;
	private boolean catalogoArchivado;
	private boolean atencionExternos;
	private List roles = new ArrayList();
	private List companieros = new ArrayList();
	private List subordinados = new ArrayList();
	private List asistentes = new ArrayList();

	public List getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List asistentes) {
		this.asistentes = asistentes;
	}

	public List getCompanieros() {
		return companieros;
	}

	public void setCompanieros(List companieros) {
		this.companieros = companieros;
	}

	public List getRoles() {
		return roles;
	}

	public void setRoles(List roles) {
		this.roles = roles;
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

	public String getUnidadAdministrativa() {
		return unidadAdministrativa;
	}

	public void setUnidadAdministrativa(String unidadAdministrativa) {
		this.unidadAdministrativa = unidadAdministrativa;
	}

	public int getIdPuesto() {
		return idPuesto;
	}

	public void setIdPuesto(int idPuesto) {
		this.idPuesto = idPuesto;
	}

	public List getSubordinados() {
		return subordinados;
	}

	public void setSubordinados(List subordinados) {
		this.subordinados = subordinados;
	}

	public int getIdUnidadAdministrativa() {
		return idUnidadAdministrativa;
	}

	public void setIdUnidadAdministrativa(int idUnidadAdministrativa) {
		this.idUnidadAdministrativa = idUnidadAdministrativa;
	}

	public int getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String[] getIdAsistentes() {
		return idAsistentes;
	}
	
	public String getChecksAsistentes() {
		StringBuffer sb = new StringBuffer("[");
		for(int i=0;i<idAsistentes.length;i++){
			sb.append(idAsistentes[i]+",");
		}
		sb.append("-1]");
		return sb.toString();
	}

	public void setIdAsistentes(String[] idAsistentes) {
		this.idAsistentes = idAsistentes;
	}

	public String[] getIdRoles() {
		return idRoles;
	}

	public String getChecksRoles() {
		StringBuffer sb = new StringBuffer("[");
		for(int i=0;i<idRoles.length;i++){
			sb.append(idRoles[i]+",");
		}
		sb.append("-1]");
		return sb.toString();
	}
	
	public void setIdRoles(String[] idRoles) {
		this.idRoles = idRoles;
	}

	public String[] getIdCorreosSalida() {
		return idCorreosSalida;
	}

	public String getChecksCorreosSalida() {
		StringBuffer sb = new StringBuffer("[");
		for(int i=0;i<idCorreosSalida.length;i++){
			sb.append(idCorreosSalida[i]+",");
		}
		sb.append("-1]");
		return sb.toString();
	}
	
	public void setIdCorreosSalida(String[] idCorreosSalida) {
		this.idCorreosSalida = idCorreosSalida;
	}

	public boolean isCorresEntrada() {
		return corresEntrada;
	}

	public void setCorresEntrada(boolean corresEntrada) {
		this.corresEntrada = corresEntrada;
	}

	public boolean isCatalogoArchivado() {
		return catalogoArchivado;
	}

	public void setCatalogoArchivado(boolean catalogoArchivado) {
		this.catalogoArchivado = catalogoArchivado;
	}

	public int getIdJefe() {
		return idJefe;
	}

	public void setIdJefe(int idJefe) {
		this.idJefe = idJefe;
	}

	public String getJefe() {
		return jefe;
	}

	public void setJefe(String jefe) {
		this.jefe = jefe;
	}

	public boolean isAtencionExternos() {
		return atencionExternos;
	}

	public void setAtencionExternos(boolean atencionExternos) {
		this.atencionExternos = atencionExternos;
	}

	public int getIdUsuarioActualizo() {
		return idUsuarioActualizo;
	}

	public void setIdUsuarioActualizo(int idUsuarioActualizo) {
		this.idUsuarioActualizo = idUsuarioActualizo;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id Puesto: "+idPuesto);
		sb.append("id UnidadAdministrativa: "+idUnidadAdministrativa);
		sb.append("id Jefe: "+idJefe);
		sb.append("consecutivo: "+consecutivo);
		sb.append("id UsuarioActualizo: "+idUsuarioActualizo);
		sb.append("usuario: "+usuario);
		sb.append("password: "+password);
		sb.append("responsable: "+responsable);
		sb.append("unidad Administrativa: "+unidadAdministrativa);
		sb.append("correo: "+correo);
		sb.append("telefono: "+telefono);
		sb.append("jefe: "+jefe);
		
		sb.append("idAsistentes: "+idAsistentes);
		sb.append("idRoles: "+idRoles);
		sb.append("idCorreoSalida: "+idCorreosSalida);
		sb.append("corresEntrada: "+corresEntrada);
		sb.append("catalogoArchivado: "+catalogoArchivado);
		sb.append("atencionExternos: "+atencionExternos);
		sb.append("roles: "+roles);
		sb.append("companieros: "+companieros);
		sb.append("subordinados: "+subordinados);
		sb.append("asistentes: "+asistentes);
		return sb.toString();
	}

	public void limpiarForm(){
		idPuesto=0;
		idUnidadAdministrativa = -1;
		idJefe=-1;
		consecutivo=0;
		idUsuarioActualizo=0;
		usuario="";
		password="";
		puesto="";
		responsable="";
		unidadAdministrativa="";
		correo="";
		telefono="";
		jefe="";
		idAsistentes=new String[0];
		idRoles=new String[0];
		idCorreosSalida=new String[0];
	}

	public int getIdSubventanilla() {
		return idSubventanilla;
	}

	public void setIdSubventanilla(int idSubventanilla) {
		this.idSubventanilla = idSubventanilla;
	}
	
}
