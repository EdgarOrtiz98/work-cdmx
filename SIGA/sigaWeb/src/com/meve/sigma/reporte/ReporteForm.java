package com.meve.sigma.reporte;

import java.util.Date;

import com.meve.sigma.struts.SigaForm;
import com.meve.util.DateFormatter;

public class ReporteForm extends SigaForm {

	public static final int FECHA_CAPTURA = 1;
	public static final int FECHA_RECEPCION = 2;
	public static final int FECHA_DOCUMENTO = 3;

	private static final long serialVersionUID = -6504196059400168135L;

	private long fechaInicial = new Date().getTime();
	private long fechaFinal = new Date().getTime();
	private String[] estatus;
	private String[] estatusOtrasVentanillas;
	private String[] subordinados;
	private boolean muestraSubordinados;
	private boolean otrasVentanillas;
	private boolean totales;
	private int tipoFecha;

	public long getFechaInicialLong() {
		return DateFormatter.normalizaDiaInicio(fechaInicial);
	}

	public void setFechaInicialLong(long fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaInicial() {
		return DateFormatter.getFecha(fechaInicial);
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = DateFormatter.getTimeStamp(fechaInicial);
	}

	public long getFechaFinalLong() {
		return DateFormatter.normalizaDiaFinal(fechaFinal);
	}

	public void setFechaFinalLong(long fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getFechaFinal() {
		return DateFormatter.getFecha(fechaFinal);
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = DateFormatter.getTimeStamp(fechaFinal);
	}

	public String[] getEstatus() {
		return estatus;
	}

	public void setEstatus(String[] estatus) {
		this.estatus = estatus;
	}

	public boolean isTotales() {
		return totales;
	}

	public void setTotales(boolean totales) {
		this.totales = totales;
	}

	public String[] getEstatusOtrasVentanillas() {
		return estatusOtrasVentanillas;
	}

	public void setEstatusOtrasVentanillas(String[] estatusOtrasVentanillas) {
		this.estatusOtrasVentanillas = estatusOtrasVentanillas;
	}

	public int getTipoFecha() {
		return tipoFecha;
	}

	public void setTipoFecha(int tipoFecha) {
		this.tipoFecha = tipoFecha;
	}

	public String getTipoFechaNombre() {
		switch (tipoFecha) {
		case FECHA_CAPTURA:
			return "Fecha de Captura";

		case FECHA_DOCUMENTO:
			return "Fecha del Documento";

		case FECHA_RECEPCION:
			return "Fecha de Recepción";
		}

		return "N/A";
	}

	public String getTipoFechaCampo() {
		switch (tipoFecha) {
		case FECHA_CAPTURA:

			//return "TO_CHAR(ASU_FECHA_CAPTURA, 'DD/MM/YYYY')";
			return "TO_CHAR(ASU_FECHA_CAPTURA, 'YYYY-MM-DD')";
			//return " ASU_FECHA_CAPTURA ";

		case FECHA_DOCUMENTO:
			//return "TO_CHAR(ASU_FECHA_DOCTO, 'DD/MM/YYYY')";
			return "TO_CHAR(ASU_FECHA_DOCTO, 'YYYY-MM-DD')";

		case FECHA_RECEPCION:
			//return "TO_CHAR(ASU_FECHA_RECEPCION, 'DD/MM/YYYY')";
			return "TO_CHAR(ASU_FECHA_RECEPCION, 'YYYY-MM-DD')";
		}

		return null;
	}

	public String[] getSubordinados() {
		return subordinados;
	}

	public void setSubordinados(String[] subordinados) {
		this.subordinados = subordinados;
	}

	public boolean isMuestraSubordinados() {
		return muestraSubordinados;
	}

	public void setMuestraSubordinados(boolean muestraSubordinados) {
		this.muestraSubordinados = muestraSubordinados;
	}

	public String getEstatusChecks(int valorCheck) {
		if (estatus != null) {
			for (int i = 0; i < estatus.length; i++) {
				if (valorCheck == Integer.parseInt(this.getEstatus()[i])) {
					return "CHECKED";
				}
			}
			return "";
		} else {
			return "CHECKED";
		}

	}

	public String getSubordinadosChecks(int valorCheck) {
		if (subordinados != null) {
			for (int i = 0; i < subordinados.length; i++) {
				if (valorCheck == Integer.parseInt(subordinados[i])) {
					return "CHECKED";
				}
			}
			return "";
		} else {
			return "CHECKED";
		}

	}

	public String getComboSelected(int valorCheck) {
		if (valorCheck == this.tipoFecha) {
			return "SELECTED";
		}
		return "";
	}

	public String getEstatusOVChecks(int valorCheck) {
		if (estatusOtrasVentanillas != null) {
			for (int i = 0; i < estatusOtrasVentanillas.length; i++) {
				if (valorCheck == Integer.parseInt(this
						.getEstatusOtrasVentanillas()[i])) {
					return "CHECKED";
				}
			}
			return "";
		} else {
			return "CHECKED";
		}
	}

	public boolean isOtrasVentanillas() {
		return otrasVentanillas;
	}

	public void setOtrasVentanillas(boolean otrasVentanillas) {
		this.otrasVentanillas = otrasVentanillas;
	}

	public String getOtrasVentanillasCheck() {
		if (otrasVentanillas) {
			return "CHECKED";
		}
		return "";
	}

	public String getSubordinadosCheck() {
		if (muestraSubordinados) {
			return "CHECKED";
		}
		return "";
	}

	public void limpiaForm() {
		fechaInicial = new Date().getTime();
		fechaFinal = new Date().getTime();
		estatus = null;
		estatusOtrasVentanillas = null;
		subordinados = null;
		muestraSubordinados = false;
		otrasVentanillas = false;
		totales = false;
		tipoFecha = 0;
	}

	public String getSubordinadosToString() {
		StringBuffer sb = new StringBuffer("[");
		if (subordinados != null) {
			for (int i = 0; i < subordinados.length; i++) {
				sb.append(subordinados[i] + ",");
			}

		} 
		sb.append("-1]");
		return sb.toString();
	}
}
