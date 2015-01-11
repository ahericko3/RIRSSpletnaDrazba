package com.rirs.drazba.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.entity.Ponudba;

@Stateless
public class PonudbaDAOBean implements IPonudbaDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void oddajPonudbo(Drazba drazba, Ponudba ponudba) {
		
	}
	
	@Override
	public void dodaj(Ponudba ponudba) {
		try {
			em.persist(ponudba);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
