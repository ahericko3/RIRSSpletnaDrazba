package com.rirs.drazba.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.rirs.drazba.enumi.Kategorija;
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
	private Double sklicnaCena;
	private Double cenaPakiranja;
	private Date koneDrazbe;
	private String porekloDrzava;
	private boolean konec;
	@ManyToOne
	private Ponudba ponudba;
	
	//@Enumerated(EnumType.STRING)
	private StanjePredmeta stanje;
	//@Enumerated
	//@ElementCollection(targetClass = PlacilnaSredstva.class)
	//@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass=PlacilnaSredstva.class)
    @Enumerated(EnumType.STRING) // Possibly optional (I'm not sure) but defaults to ORDINAL.
    @CollectionTable(name="drazba_placilnaSredstva")
    @Column(name="placilnoSredstvo") // Column name in person_interest
	private Collection<PlacilnaSredstva> placilnaSredstva;
	@OneToMany(targetEntity=Ponudba.class, mappedBy = "drazba", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Ponudba> ponudbe;
	@OneToMany(targetEntity=Fotografija.class,mappedBy = "drazba", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Fotografija> fotografije;
	@ManyToOne
	private Uporabnik izdajatelj;
	
	private Kategorija kategorija;
	
	
	
	public Ponudba getPonudba() {
		return ponudba;
	}

	public void setPonudba(Ponudba ponudba) {
		this.ponudba = ponudba;
	}

	public Double getSklicnaCena() {
		return sklicnaCena;
	}

	public void setSklicnaCena(Double sklicnaCena) {
		this.sklicnaCena = sklicnaCena;
	}

	public Double getCenaPakiranja() {
		return cenaPakiranja;
	}

	public void setCenaPakiranja(Double cenaPakiranja) {
		this.cenaPakiranja = cenaPakiranja;
	}

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
	
	
	public Collection<PlacilnaSredstva> getPlacilnaSredstva() {
		return placilnaSredstva;
	}

	public void setPlacilnaSredstva(Collection<PlacilnaSredstva> placilnaSredstva) {
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
	
	@ManyToOne(targetEntity=Uporabnik.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinColumn(name="uporabnik_id")
	public Uporabnik getIzdajatelj() {
		return izdajatelj;
	}

	public void setIzdajatelj(Uporabnik izdajatelj) {
		this.izdajatelj = izdajatelj;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public boolean isKonec() {
		return konec;
	}

	public void setKonec(boolean konec) {
		this.konec = konec;
	} 
	
}
