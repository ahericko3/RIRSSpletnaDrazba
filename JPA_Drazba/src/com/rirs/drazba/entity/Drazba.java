package com.rirs.drazba.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.rirs.drazba.enumi.PlacilnaSredstva;
import com.rirs.drazba.enumi.StanjePredmeta;

/**
 * Entity implementation class for Entity: Uporabnik
 *
 */
@Entity
public class Drazba implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	private String imePredmeta;
	private String opisPredmeta;
	private Date koneDrazbe;
	private String porekloDrzava;
	private StanjePredmeta stanje;
	private List<PlacilnaSredstva> placilnaSredstva;
	private List<Ponudba> ponudbe;
	private List<Fotografija> fotografije;
	private Uporabnik izdajatelj;
	
	
	public Drazba() {
		super();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getImePredmeta() {
		return imePredmeta;
	}

	public void setImePredmeta(String imePredmeta) {
		this.imePredmeta = imePredmeta;
	}

	public String getOpisPredmeta() {
		return opisPredmeta;
	}

	public void setOpisPredmeta(String opisPredmeta) {
		this.opisPredmeta = opisPredmeta;
	}

	public Date getKoneDrazbe() {
		return koneDrazbe;
	}

	public void setKoneDrazbe(Date koneDrazbe) {
		this.koneDrazbe = koneDrazbe;
	}

	public String getPorekloDrzava() {
		return porekloDrzava;
	}

	public void setPorekloDrzava(String porekloDrzava) {
		this.porekloDrzava = porekloDrzava;
	}

	public StanjePredmeta getStanje() {
		return stanje;
	}

	public void setStanje(StanjePredmeta stanje) {
		this.stanje = stanje;
	}

	public List<PlacilnaSredstva> getPlacilnaSredstva() {
		return placilnaSredstva;
	}

	public void setPlacilnaSredstva(List<PlacilnaSredstva> placilnaSredstva) {
		this.placilnaSredstva = placilnaSredstva;
	}

	public List<Ponudba> getPonudbe() {
		return ponudbe;
	}

	public void setPonudbe(List<Ponudba> ponudbe) {
		this.ponudbe = ponudbe;
	}

	public List<Fotografija> getFotografije() {
		return fotografije;
	}

	public void setFotografije(List<Fotografija> fotografije) {
		this.fotografije = fotografije;
	}

	public Uporabnik getIzdajatelj() {
		return izdajatelj;
	}

	public void setIzdajatelj(Uporabnik izdajatelj) {
		this.izdajatelj = izdajatelj;
	}
   
	
}
