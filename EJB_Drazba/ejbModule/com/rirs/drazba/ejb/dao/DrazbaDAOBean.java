package com.rirs.drazba.ejb.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.entity.Ponudba;
import com.rirs.drazba.entity.Uporabnik;
import com.rirs.drazba.enumi.Kategorija;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Stateless
public class DrazbaDAOBean implements IDrazbaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Drazba vrniDrazba(int idDrazbe) {
		List<Drazba> drazbe = em
				.createQuery("select l from Drazba l where l.id=:iddrazba",
						Drazba.class).setParameter("iddrazba", idDrazbe)
				.getResultList();
		return drazbe.get(0);
	}

	@Override
	public void dodaj(Drazba drazba) {
		try {
			em.persist(drazba);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void odstrani(Drazba drazba) {
		try {
			em.remove(drazba);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void uredi(Drazba drazba) {
		try {
			em.merge(drazba);
		} catch (Exception e) {
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
		List<Drazba> drazbe = em.createQuery("select l from Drazba ",
				Drazba.class).getResultList();
		return drazbe;
	}

	@Override
	public List<Drazba> vrniVseDrazbeMinMax(double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Drazba> vrniVseDrazbeIzdajatelja(Uporabnik up) {
		List<Drazba> drazbe = em
				.createQuery("select l from Drazba l where l.izdajatelj=:up",
						Drazba.class).setParameter("up", up).getResultList();

		return drazbe;
	}

	@Override
	public List<Drazba> vrniVseDrazbeKategorija(Kategorija k) {
		List<Drazba> drazbe = new ArrayList<Drazba>();
		if (k == Kategorija.AVDIO_VIDEO) {
			drazbe.addAll(vrniVseDrazbeKategorija(Kategorija.TV_SPREJEMNIK));
			drazbe.addAll(vrniVseDrazbeKategorija(Kategorija.AKUSTIKA));
		}
		if (k == Kategorija.RACUNALNISTVO) {
			drazbe.addAll(vrniVseDrazbeKategorija(Kategorija.PRENOSNIKI));
			drazbe.addAll(vrniVseDrazbeKategorija(Kategorija.TABLICNI_RACUNALNIKI));
			drazbe.addAll(vrniVseDrazbeKategorija(Kategorija.KOMPONENTE));
		}
		if (k == Kategorija.TELEFONIJA) {
			drazbe.addAll(vrniVseDrazbeKategorija(Kategorija.STACIONARNA_TELEFONIJA));
			drazbe.addAll(vrniVseDrazbeKategorija(Kategorija.MOBILNA_TELEFONIJA));
		}

		drazbe.addAll(em
				.createQuery("select l from Drazba l where l.kategorija=:k",
						Drazba.class).setParameter("k", k).getResultList());

		return drazbe;
	}

	@Override
	public List<Drazba> vrniVsePotekleDrazbe() {
		List<Drazba> drazbe;
		try {
			drazbe = em
					.createQuery(
							"select l from Drazba l where l.koneDrazbe<:datum",
							Drazba.class)
					.setParameter("datum", new java.util.Date())
					.getResultList();

			return drazbe;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Drazba> vrniNajblizjih5Drazb() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void oddajPonudbo(int idDrazbe, Ponudba ponudba) {
	     Drazba drazba = em.find(Drazba.class, idDrazbe);
	     drazba.setPonudba(ponudba);
	     ponudba.setDrazba(drazba);
	     em.persist(ponudba);

	}

	@Override
	public List<Drazba> vrniAktualneDrazbe() {
		List<Drazba> drazbe;
		try {
			drazbe = em
					.createQuery(
							"select l from Drazba l where l.koneDrazbe>:datum",
							Drazba.class)
					.setParameter("datum", new java.util.Date())
					.getResultList();

			return drazbe;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Ponudba> getPonudbe(int idDrazbe) {
		List<Ponudba> ponudbe;
		try {
			ponudbe = em
					.createQuery(
							"select l from Ponudba l where l.drazba.id=:idDrazbe",
							Ponudba.class)
					.setParameter("idDrazbe", idDrazbe)
					.getResultList();

			return ponudbe;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Drazba> vrniVseNedokoncanePotekleDrazbe() {
		List<Drazba> drazbe;
		try {
			drazbe = em
					.createQuery(
							"select l from Drazba l where l.koneDrazbe<:datum and konec=false",
							Drazba.class)
					.setParameter("datum", new java.util.Date())
					.getResultList();

			return drazbe;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void zakljuciDrazbo(int id){
	     Drazba drazba = em.find(Drazba.class, id);
	     drazba.setKonec(true);
	}

}
