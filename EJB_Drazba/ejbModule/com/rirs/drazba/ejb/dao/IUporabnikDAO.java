package com.rirs.drazba.ejb.dao;

import com.rirs.drazba.entity.Uporabnik;

public interface IUporabnikDAO {
	public void dodaj(Uporabnik uporabnik);
	public void uredi(Uporabnik uporabnik);
	public void odstrani(Uporabnik uporabnik);
	public void vrniUporabnika(int idUporabnik);
	public Uporabnik preveriUporabnika(String email,String geslo);
	
}
