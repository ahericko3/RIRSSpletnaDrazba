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
   
}
