package com.rirs.drazba.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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
	private Double sklicnaCena;
	private Double cenaPakiranja;
	private Date koneDrazbe;
	private String porekloDrzava;
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
	@OneToMany(mappedBy = "drazba", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Ponudba> ponudbe;
	@OneToMany(targetEntity=Fotografija.class,mappedBy = "drazba", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Fotografija> fotografije;
	private Uporabnik izdajatelj;
	
	
	
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
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="uporabnik_id")
	public Uporabnik getIzdajatelj() {
		return izdajatelj;
	}

	public void setIzdajatelj(Uporabnik izdajatelj) {
		this.izdajatelj = izdajatelj;
	}
   
	
}
