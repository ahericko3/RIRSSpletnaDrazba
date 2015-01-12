package com.rirs.drazba.web.mannagedbeans;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.entity.Drazba;

public class KonecDrazbe implements SystemEventListener {
	private static Timer t;

	IDrazbaDAO drazbaDAO;

	@Override
	public boolean isListenerForSource(Object arg0) {
		return (arg0 instanceof Application);
	}

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		if (event instanceof PostConstructApplicationEvent) {
			t = getTimer();
		} else if (event instanceof PreDestroyApplicationEvent) {
			t.cancel();
			t = null;
		}
	}

	public Timer getTimer() {
		if (t == null) {
			InitialContext ic;
			try {
				ic = new InitialContext();
				drazbaDAO = (IDrazbaDAO) ic
						.lookup("java:global/EAR_Drazba/EJB_Drazba/DrazbaDAOBean!com.rirs.drazba.ejb.dao.IDrazbaDAO");

				t = new Timer();
				t.schedule(new TimerTask() {
					@Override
					public void run() {
						List<Drazba> drazbe = drazbaDAO
								.vrniVseNedokoncanePotekleDrazbe();
						for (Drazba d : drazbe) {
							if (d.getPonudba() == null) {
								Mail m = new Mail();
								String vsebina = "Pozdravljeni.\r\nNa žalost dražba predmeta "
										+ d.getImePredmeta()
										+ " ni bila uspešna, kar pomeni da noben ni podal nobene ponudbe,"
										+ " ki bi ustrezala vaši podani izklicni ceni. \r\n \r\nLep pozdrav,"
										+ "\r\nspletna dražba HerKos.";
								m.posljiMail("Drazba " + d.getId()
										+ " neuspesna", vsebina, d
										.getIzdajatelj().getEmail());
							} else {
								Mail m = new Mail();
								String vsebina2 = "Pozdravljeni.\r\nPonudba na predmet "
										+ d.getImePredmeta()
										+ " je bila uspešna in je zmagala na dražbi. Predmet ste kupili za "
										+ d.getPonudba().getPonudba()
										+ "€. Kontaktni podatki prodajalca so sledeèi:"
										+ "\r\nIme: "
										+ d.getIzdajatelj().getIme()
										+ "\r\nPriimek: "
										+ d.getIzdajatelj().getPriimek()
										+ "\r\nEmail: "
										+ d.getIzdajatelj().getEmail()
										+ "\r\n \r\nLep pozdrav, \r\nspletna dražba HerKos.";
								m.posljiMail(
										"Drazba " + d.getId() + " uspesna",
										vsebina2, d.getPonudba().getUporabnik()
												.getEmail());

								String vsebina = "Pozdravljeni.\r\nDražba predmeta "
										+ d.getImePredmeta()
										+ " je bila uspešna. Predmet je bil prodan za "
										+ d.getPonudba().getPonudba()
										+ "€. Kontaktni podatki kupca so sledeèi:"
										+ "\r\nIme: "
										+ d.getPonudba().getUporabnik()
												.getIme()
										+ "\r\nPriimek: "
										+ d.getPonudba().getUporabnik()
												.getPriimek()
										+ "\r\nEmail: "
										+ d.getPonudba().getUporabnik()
												.getEmail()
										+ "\r\n \r\nLep pozdrav, \r\nspletna dražba HerKos.";
								m.posljiMail(
										"Drazba " + d.getId() + " uspesna",
										vsebina, d.getIzdajatelj().getEmail());
							}
							drazbaDAO.zakljuciDrazbo(d.getId());
						}
					}
				}, 0, 5000);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return t;
	}

}
