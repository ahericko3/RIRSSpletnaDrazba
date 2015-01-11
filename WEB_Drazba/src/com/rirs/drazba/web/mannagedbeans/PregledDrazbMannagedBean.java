package com.rirs.drazba.web.mannagedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.entity.Drazba;

public class PregledDrazbMannagedBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	IDrazbaDAO drazbaDAO;
	
	public List<Drazba> aktualneDrazbe;
	
	@PostConstruct
	public void init(){
		aktualneDrazbe=drazbaDAO.vrniAktualneDrazbe();
		
	}

	public List<Drazba> getAktualneDrazbe() {
		return aktualneDrazbe;
	}

	public void setAktualneDrazbe(List<Drazba> aktualneDrazbe) {
		this.aktualneDrazbe = aktualneDrazbe;
	}
}
