package com.rirs.drazba.web.mannagedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.enumi.Kategorija;

public class PregledDrazbMannagedBean implements Serializable {

	private static final long serialVersionUID = 1L;


	@EJB
	IDrazbaDAO drazbaDAO;
	
	public List<Drazba> aktualneDrazbe;
	

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String kategorija = (String) facesContext.getExternalContext().
                getRequestParameterMap().get("kategorija");
		if (kategorija != null)
			aktualneDrazbe = drazbaDAO.vrniVseDrazbeKategorija(Kategorija
					.valueOf(kategorija));
		else
			aktualneDrazbe = drazbaDAO.vrniAktualneDrazbe();
		
	}

	public List<Drazba> getAktualneDrazbe() {
		return aktualneDrazbe;
	}

	public void setAktualneDrazbe(List<Drazba> aktualneDrazbe) {
		this.aktualneDrazbe = aktualneDrazbe;
	}
}
