package com.rirs.drazba.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		/*TypedQuery<Uporabnik> query = em.createQuery("SELECT u FROM Uporabnik u WHERE u.email = '" + email + "' AND u.geslo = '"+geslo+  "'", Uporabnik.class);
		try{	
			return query.getSingleResult();
		if(query.getSingleResult()!=null){
			System.out.println("T");
			return query.getSingleResult();
			}
		} catch(Exception e){
			System.out.println("F");
			return null;
        }*/

		//System.out.println("F");
		//return null;
		List<Uporabnik> leti = em.createQuery("select l from Uporabnik l where l.geslo=:ges AND l.email=:em",Uporabnik.class)
				.setParameter("ges", geslo)
				.setParameter("em", email)
				.getResultList();
				
				return leti.get(0);
	}

}
