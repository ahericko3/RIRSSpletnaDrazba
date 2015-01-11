package com.rirs.drazba.web.mannagedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.enumi.Kategorija;

public class MojeDrazbeMannagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	IDrazbaDAO drazbaDAO;

	@ManagedProperty(value = "#{prijavaMB}")
	private PrijavaMannagedBean prijava;
    
	public List<Drazba> mojeDrazbe;
	
	@PostConstruct
	public void init(){
		//mojeDrazbe=drazbaDAO.vrniVseDrazbeIzdajatelja(prijava.getUporabnik());
		mojeDrazbe=drazbaDAO.vrniVseDrazbeKategorija(Kategorija.AVDIO_VIDEO);
	}


	public List<Drazba> getMojeDrazbe() {
		return mojeDrazbe;
	}
	
	public void setMojeDrazbe(List<Drazba> mojeDrazbe) {
		this.mojeDrazbe = mojeDrazbe;
	}

	public PrijavaMannagedBean getPrijava() {
		return prijava;
	}

	public void setPrijava(PrijavaMannagedBean prijava) {
		this.prijava = prijava;
	}

	
}
