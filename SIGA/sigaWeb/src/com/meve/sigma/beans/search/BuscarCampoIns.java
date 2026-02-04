/*
 * Clase:						BuscarCampo.java
 * 
 * Paquete:						com.meve.sigma.beans.search		
 * 
 * Versión						1.0
 * 
 * Fecha Creación:				Nov 16, 2005
 * 
 * @author: 					Rodrigo Soto Ch.
 * 								rodrigo_s_ch@yahoo.com.mx, rodrigo.soto.ch@gmail.com
 * 			
 * Empresa:						Meve Soluciones S.A. de C.V.
 * 
 * Contacto:					http://www.tecnoaplicada.com
 * 
 * Descripción de la clase:		
 */

package com.meve.sigma.beans.search;

/**
 * Bean para guardar los campos de Busqueda por instrucción
 * 
 * @author Meve Soluciones S.A. de C.V.
 */
public class BuscarCampoIns {
    
    String buscaResponsable;
    String buscaTipoAte[];
    String buscaFechaGenI;
    String buscaFechaGenF;
    String buscaFechaVenI;
    String buscaFechaVenF;
    String buscaEstatus[];
    String buscaNomIns;
    String buscaFolio;
    String buscaAsunto;
    String buscaAsignadaPor;
    String buscaFolioInter;
    String avanceAsuntoI;
    String avanceAsuntoF;
    String buscaFolioControl;
    String semaforoAsunto[];
    String buscaExpediente;
    
	/**
	 * @return Devuelve semaforoAsunto.
	 */
	public String[] getSemaforoAsunto() {
		return semaforoAsunto;
	}
	/**
	 * @param semaforoAsunto El semaforoAsunto a establecer.
	 */
	public void setSemaforoAsunto(String[] semaforoAsunto) {
		this.semaforoAsunto = semaforoAsunto;
	}
    /**
     * @param buscaResponsable El buscaResponsable a establecer.
	 */
    public void setbuscaResponsable(String buscaResponsable)
    {
        this.buscaResponsable = buscaResponsable;
    }

	/**
	 * @return Devuelve buscaResponsable.
	 */
    public String getbuscaResponsable()
    {
        return buscaResponsable;
    }
    
    /**
     * @param buscaTipoAte El buscaTipoAte a establecer.
	 */
    public void setbuscaTipoAte(String buscaTipoAte[])
    {
        this.buscaTipoAte = buscaTipoAte;
    }

	/**
	 * @return Devuelve buscaTipoAte.
	 */
    public String[] getbuscaTipoAte()
    {
        return buscaTipoAte;
    }
    
    /**
     * @param buscaFechaGenI El buscaFechaGenI a establecer.
	 */
    public void setbuscaFechaGenI(String buscaFechaGenI)
    {
        this.buscaFechaGenI = buscaFechaGenI;
    }

	/**
	 * @return Devuelve buscaFechaGenI.
	 */
    public String getbuscaFechaGenI()
    {
        return buscaFechaGenI;
    }
    
    /**
     * @param buscaFechaGenF El buscaFechaGenF a establecer.
	 */
    public void setbuscaFechaGenF(String buscaFechaGenF)
    {
        this.buscaFechaGenF = buscaFechaGenF;
    }

	/**
	 * @return Devuelve buscaFechaGenF.
	 */
    public String getbuscaFechaGenF()
    {
        return buscaFechaGenF;
    }
    
    /**
     * @param buscaFechaVenI El buscaFechaVenI a establecer.
	 */
    public void setbuscaFechaVenI(String buscaFechaVenI)
    {
        this.buscaFechaVenI = buscaFechaVenI;
    }

	/**
	 * @return Devuelve buscaFechaVenI.
	 */
    public String getbuscaFechaVenI()
    {
        return buscaFechaVenI;
    }
    
    /**
     * @param buscaFechaVenF El buscaFechaVenF a establecer.
	 */
    public void setbuscaFechaVenF(String buscaFechaVenF)
    {
        this.buscaFechaVenF = buscaFechaVenF;
    }

	/**
	 * @return Devuelve buscaFechaVenF.
	 */
    public String getbuscaFechaVenF()
    {
        return buscaFechaVenF;
    }
    
    /**
     * @param buscaEstatus El buscaEstatus a establecer.
	 */
    public void setbuscaEstatus(String buscaEstatus[])
    {
        this.buscaEstatus = buscaEstatus;
    }

	/**
	 * @return Devuelve buscaEstatus.
	 */
    public String[] getbuscaEstatus()
    {
   		return buscaEstatus;
    }
    
    /**
     * @param buscaNomIns El buscaNomIns a establecer.
	 */
    public void setbuscaNomIns(String buscaNomIns)
    {
        this.buscaNomIns = buscaNomIns;
    }

	/**
	 * @return Devuelve buscaNomIns.
	 */
    public String getbuscaNomIns()
    {
        return buscaNomIns;
    }    
    
    /**
     * @param buscaFolio El buscaFolio a establecer.
	 */
    public void setbuscaFolio(String buscaFolio)
    {
        this.buscaFolio = buscaFolio;
    }

	/**
	 * @return Devuelve buscaFolio.
	 */
    public String getbuscaFolio()
    {
        return buscaFolio;
    }    
	/**
	 * @return Devuelve buscaAsignadaPor.
	 */
	public String getBuscaAsignadaPor() {
		return buscaAsignadaPor;
	}
	/**
	 * @param buscaAsignadaPor El buscaAsignadaPor a establecer.
	 */
	public void setBuscaAsignadaPor(String buscaAsignadaPor) {
		this.buscaAsignadaPor = buscaAsignadaPor;
	}
	/**
	 * @return Devuelve buscaAsunto.
	 */
	public String getBuscaAsunto() {
		return buscaAsunto;
	}
	/**
	 * @param buscaAsunto El buscaAsunto a establecer.
	 */
	public void setBuscaAsunto(String buscaAsunto) {
		this.buscaAsunto = buscaAsunto;
	}
	/**
	 * @return Devuelve buscaFolioInter.
	 */
	public String getBuscaFolioInter() {
		return buscaFolioInter;
	}
	/**
	 * @param buscaFolioInter El buscaFolioInter a establecer.
	 */
	public void setBuscaFolioInter(String buscaFolioInter) {
		this.buscaFolioInter = buscaFolioInter;
	}
	/**
	 * @return Devuelve avanceAsuntoF.
	 */
	public String getAvanceAsuntoF() {
		return avanceAsuntoF;
	}
	/**
	 * @param avanceAsuntoF El avanceAsuntoF a establecer.
	 */
	public void setAvanceAsuntoF(String avanceAsuntoF) {
		this.avanceAsuntoF = avanceAsuntoF;
	}
	/**
	 * @return Devuelve avanceAsuntoI.
	 */
	public String getAvanceAsuntoI() {
		return avanceAsuntoI;
	}
	/**
	 * @param avanceAsuntoI El avanceAsuntoI a establecer.
	 */
	public void setAvanceAsuntoI(String avanceAsuntoI) {
		this.avanceAsuntoI = avanceAsuntoI;
	}
	/**
	 * @return Devuelve buscaFolioControl.
	 */
	public String getBuscaFolioControl() {
		return buscaFolioControl;
	}
	/**
	 * @param buscaFolioControl El buscaFolioControl a establecer.
	 */
	public void setBuscaFolioControl(String buscaFolioControl) {
		this.buscaFolioControl = buscaFolioControl;
	}
	/**
	 * @return Devuelve buscaExpediente.
	 */
	public String getBuscaExpediente() {
		return buscaExpediente;
	}
	/**
	 * @param buscaExpediente El buscaExpediente a establecer.
	 */
	public void setBuscaExpediente(String buscaExpediente) {
		this.buscaExpediente = buscaExpediente;
	}
}

