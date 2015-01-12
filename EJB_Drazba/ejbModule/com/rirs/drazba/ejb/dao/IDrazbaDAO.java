package com.rirs.drazba.ejb.dao;
import java.sql.Date;
import java.util.List;

import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.entity.Ponudba;
import com.rirs.drazba.entity.Uporabnik;
import com.rirs.drazba.enumi.Kategorija;


public interface IDrazbaDAO {
	public Drazba vrniDrazba(int idDrazbe);
	public void dodaj(Drazba drazba);
	public void odstrani(Drazba drazba);
	public void uredi(Drazba drazba);
	public Date vrniKonecDrazbe(Drazba drazba);//bedna menda?:P
	public void zakljuciDrazbo(int id);
	
	public List<Drazba> vrniVseDrazbe();
	public List<Drazba> vrniVseDrazbeMinMax(double min, double max); //vrne dražbe v določenem intervalu
	public List<Drazba> vrniVseDrazbeIzdajatelja(Uporabnik up);
	public List<Drazba> vrniVsePotekleDrazbe();
	public List<Drazba> vrniVseNedokoncanePotekleDrazbe();
	public List<Drazba> vrniNajblizjih5Drazb();
	public List<Drazba> vrniAktualneDrazbe();
	public List<Drazba> vrniVseDrazbeKategorija(Kategorija k);
	
	public void oddajPonudbo(int idDrazbe,Ponudba ponudba);
	public List<Ponudba> getPonudbe(int idDrazbe);
	
}
