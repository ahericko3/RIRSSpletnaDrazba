package com.rirs.drazba.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Fotografija
 *
 */
@Entity
public class Fotografija implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	private Blob slika;
	private String opis;
	private Drazba drazba;
	
	public Fotografija() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blob getSlika() {
		return slika;
	}

	public void setSlika(Blob slika) {
		this.slika = slika;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@ManyToOne(targetEntity=Drazba.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="drazba_id")
	public Drazba getDrazba() {
		return drazba;
	}

	public void setDrazba(Drazba drazba) {
		this.drazba = drazba;
	}
   
}
