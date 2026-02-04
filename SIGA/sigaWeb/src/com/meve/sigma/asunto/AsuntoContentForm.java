package com.meve.sigma.asunto;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.meve.sigma.struts.SigaForm;


public class AsuntoContentForm extends SigaForm  {

	//private static final long serialVersionUID = 3451312451757918595L;

	public AsuntoContentForm() {

	}

	/*public AsuntoContentForm(ResultSet rs) throws SQLException {

		
		idAsunto = rs.getString("ID_ASUNTO");
		folio = rs.getString("asu_folio_recepcion");
		idReferencia=rs.getString("ID_REFERENCIA");
		//idAsuntoContent=rs.getInt("ID_ASUNTO_CONTENT");
		NombreArchivo= rs.getString("NOMBRE_ARCHIVO");
		ContentType= rs.getString("CONTENT_TYPE");
		idItemDoc= rs.getString("ID_ITEM_DOC");
		idUsuario=rs.getString("ID_USUARIO_CONTENT");
		idInsContent=rs.getString("ID_INS_CONTENT");
		TipoDocumento= rs.getString("TIPO_DOCUMENTO");		
	}*/

	private String idAsunto;	
	private String folio;
	private String idReferencia;
	/*private int idAsuntoContent;*/
	private String NombreArchivo;
	private String ContentType;
	private String idItemDoc;
	private String idUsuario;
	private String idInsContent;
	private String TipoDocumento;	
	
	

	public String getIdAsunto() {
		return idAsunto;
	}
	public void setIdAsunto(String idAsunto) {
		this.idAsunto = idAsunto;
	}
	
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getNombreArchivo() {
		return NombreArchivo;
	}
	public void setNombreArchivo(String NombreArchivo) {
		this.NombreArchivo = NombreArchivo;
	}
	
	public String getContentType() {
		return ContentType;
	}
	public void setContentType(String ContentType) {
		this.ContentType = ContentType;
	}
	
	public String getIdItemDoc() {
		return idItemDoc;
	}
	public void setIdItemDoc(String idItemDoc) {
		this.idItemDoc = idItemDoc;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getIdInsContent() {
		return idInsContent;
	}
	public void setIdInsContent(String idInsContent) {
		this.idInsContent = idInsContent;
	}
	
	public String getTipoDocumento() {
		return TipoDocumento;
	}
	public void setTipoDocumento(String TipoDocumento) {
		this.TipoDocumento = TipoDocumento;
	}

    public void setIdReferencia(String idReferencia) {
        this.idReferencia = idReferencia;
    }

    public String getIdReferencia() {
        return idReferencia;
    }
}
