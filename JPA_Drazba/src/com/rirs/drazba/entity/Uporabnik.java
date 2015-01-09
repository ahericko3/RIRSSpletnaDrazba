package com.rirs.drazba.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Uporabnik
 *
 */
@Entity
public class Uporabnik implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	private String ime;
	private String priimek;
	private String geslo;
	private String email;

	
	
	public Uporabnik() {
		super();
	}
	
	public int getId() {
		return this.id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getGeslo() {
		return geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}
   
	
}
