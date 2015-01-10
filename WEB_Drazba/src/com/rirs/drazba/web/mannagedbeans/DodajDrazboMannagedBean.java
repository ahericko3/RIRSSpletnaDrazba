package com.rirs.drazba.web.mannagedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import com.rirs.drazba.enumi.PlacilnaSredstva;
import com.rirs.drazba.enumi.StanjePredmeta;

public class DodajDrazboMannagedBean {

	private java.lang.String imePredmeta;
	private com.rirs.drazba.entity.Uporabnik izdajatelj;
	private java.sql.Date konecDrazbe;
	private java.lang.String porekloDrzava;
	private StanjePredmeta stanje;
	private List<PlacilnaSredstva> placilnaSredstva;
	
	private PlacilnaSredstva[] pp;
	
	


	public PlacilnaSredstva[] getPp() {
		return PlacilnaSredstva.values();
	}

	public void setPp(PlacilnaSredstva[] pp) {
		this.pp = pp;
	}

	public java.lang.String getImePredmeta() {
		return imePredmeta;
	}

	public void setImePredmeta(java.lang.String imePredmeta) {
		this.imePredmeta = imePredmeta;
	}

	public com.rirs.drazba.entity.Uporabnik getIzdajatelj() {
		return izdajatelj;
	}

	public void setIzdajatelj(com.rirs.drazba.entity.Uporabnik izdajatelj) {
		this.izdajatelj = izdajatelj;
	}

	public java.sql.Date getKonecDrazbe() {
		return konecDrazbe;
	}

	public void setKonecDrazbe(java.sql.Date konecDrazbe) {
		this.konecDrazbe = konecDrazbe;
	}

	public java.lang.String getPorekloDrzava() {
		return porekloDrzava;
	}

	public void setPorekloDrzava(java.lang.String porekloDrzava) {
		this.porekloDrzava = porekloDrzava;
	}

	public com.rirs.drazba.enumi.StanjePredmeta getStanje() {
		return stanje;
	}

	public void setStanje(com.rirs.drazba.enumi.StanjePredmeta stanje) {
		this.stanje = stanje;
	}

	

}
