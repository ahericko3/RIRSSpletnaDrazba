package com.rirs.drazba.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ponudba
 *
 */
@Entity
public class Ponudba implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	private double ponudba;
	private Date datum;
	@ManyToOne
	private Drazba drazba;
	@ManyToOne
	private Uporabnik uporabnik;
	
	public Ponudba() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPonudba() {
		return ponudba;
	}

	public void setPonudba(double ponudba) {
		this.ponudba = ponudba;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	@ManyToOne(targetEntity=Drazba.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="drazba_id")
	public Drazba getDrazba() {
		return drazba;
	}

	public void setDrazba(Drazba drazba) {
		this.drazba = drazba;
	}
	
	@ManyToOne(targetEntity=Uporabnik.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="uporabnik_id")
	public Uporabnik getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}
   
	
}
