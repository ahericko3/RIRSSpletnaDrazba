package com.rirs.drazba.web.mannagedbeans;

import javax.ejb.EJB;

import com.rirs.drazba.ejb.dao.IUporabnikDAO;
import com.rirs.drazba.entity.Uporabnik;


public class PrijavaMannagedBean {

	@EJB
	IUporabnikDAO uporabnikDAO;
	
	private Uporabnik uporabnik;
	private java.lang.String email;
	private java.lang.String geslo;
	private java.lang.Boolean jePrijavlen;

	
	
	public com.rirs.drazba.entity.Uporabnik getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(com.rirs.drazba.entity.Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getGeslo() {
		return geslo;
	}

	public void setGeslo(java.lang.String geslo) {
		this.geslo = geslo;
	}

	public java.lang.Boolean getJePrijavlen() {
		return jePrijavlen;
	}

	public void setJePrijavlen(java.lang.Boolean jePrijavlen) {
		this.jePrijavlen = jePrijavlen;
	}
	
	public void prijaviUporabnika() {
		System.out.println("Prijavljam");
		try{
		this.uporabnik=uporabnikDAO.preveriUporabnika(email, geslo);
		
		}catch(Exception e){
			
		}
	}

}
