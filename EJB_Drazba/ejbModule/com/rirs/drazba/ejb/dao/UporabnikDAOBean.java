package com.rirs.drazba.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.entity.Uporabnik;

@Stateless
public class UporabnikDAOBean implements IUporabnikDAO{
	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public void dodaj(Uporabnik uporabnik) {
		try
		{
			em.persist(uporabnik);
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

	@Override
	public void uredi(Uporabnik uporabnik) {
		try
		{
			em.merge(uporabnik);
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void odstrani(Uporabnik uporabnik) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vrniUporabnika(int idUporabnik) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Uporabnik preveriUporabnika(String email, String geslo) {
		// TODO Auto-generated method stub
		return null;
	}

}
