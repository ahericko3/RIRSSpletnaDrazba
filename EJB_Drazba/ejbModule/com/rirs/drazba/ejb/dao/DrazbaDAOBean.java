package com.rirs.drazba.ejb.dao;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.entity.Ponudba;
import com.rirs.drazba.entity.Uporabnik;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Stateless
public class DrazbaDAOBean implements IDrazbaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Drazba vrniDrazba(int idDrazbe) {
		List<Drazba> drazbe = em.createQuery("select l from Drazba l where l.id=:iddrazba",Drazba.class)
				.setParameter("iddrazba", idDrazbe).getResultList();
				return drazbe.get(0);
	}

	@Override
	public void dodaj(Drazba drazba) {
		try
		{
			em.persist(drazba);
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}

	@Override
	public void odstrani(Drazba drazba) {
		try
		{
			em.remove(drazba);
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}

	@Override
	public void uredi(Drazba drazba) {
		try
		{
			em.merge(drazba);
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	@Override
	public Date vrniKonecDrazbe(Drazba drazba) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Drazba> vrniVseDrazbe() {
		List<Drazba> drazbe = em.createQuery("select l from Drazba ",Drazba.class)
		.getResultList();
		return drazbe;
	}

	@Override
	public List<Drazba> vrniVseDrazbeMinMax(double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Drazba> vrniVseDrazbeIzKategorije(String kategorija) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Drazba> vrniVseDrazbeIzdajatelja(Uporabnik up) {
		List<Drazba> drazbe = em.createQuery("select l from Drazba l where l.Uporabnik=:up",Drazba.class)
				.setParameter("up", up)
				.getResultList();
				
				return drazbe;
	}

	@Override
	public List<Drazba> vrniVsePotekleDrazbe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Drazba> vrniNajblizjih5Drazb() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void oddajPonudbo(Drazba drazba, Ponudba ponudba) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Drazba> vrniAktualneDrazbe() {
		 List<Drazba> drazbe;  
		  try{
		  //TypedQuery<Drazba> q=em.createQuery("Select * from Drazba where koneDrazbe > NOW() ", Drazba.class);  
		 // drazbe = q.getResultList(); 
		  
		   drazbe = em.createQuery("select l from Drazba l where l.koneDrazbe>:datum",Drazba.class)
					.setParameter("datum", new java.util.Date()).getResultList();
					
		  return drazbe;
		  }catch(Exception e)
		  {
		   e.printStackTrace();
		   return null;
		  }
		  
		  
	}
	
	
}
