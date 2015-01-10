package com.rirs.drazba.web.mannagedbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.rirs.drazba.ejb.dao.IUporabnikDAO;
import com.rirs.drazba.entity.Uporabnik;

public class RegistracijaMannagedBean {
	@EJB
	IUporabnikDAO uporabnikDAO;
	
	private java.lang.String geslo;
	private java.lang.String email;
	private java.lang.String priimek;
	private java.lang.String ime;

	public java.lang.String getGeslo() {
		return geslo;
	}

	public void setGeslo(java.lang.String geslo) {
		this.geslo = geslo;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getPriimek() {
		return priimek;
	}

	public void setPriimek(java.lang.String priimek) {
		this.priimek = priimek;
	}

	public java.lang.String getIme() {
		return ime;
	}

	public void setIme(java.lang.String ime) {
		this.ime = ime;
	}
	
	public void registracija() {
		try{
		Uporabnik up=new Uporabnik();
		up.setIme(ime);
		up.setPriimek(priimek);
		up.setGeslo(geslo);
		up.setEmail(email);
		uporabnikDAO.dodaj(up);
		ime="";
		priimek="";
		geslo="";
		email="";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Uporabnik uspešno registriran."));
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Registracija ne neuspešna."));
		}
		
		
	}


}
