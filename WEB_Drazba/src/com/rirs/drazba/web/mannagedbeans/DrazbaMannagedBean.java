package com.rirs.drazba.web.mannagedbeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.ejb.dao.IPonudbaDAO;
import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.entity.Ponudba;

public class DrazbaMannagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	IDrazbaDAO drazbaDAO;
	@EJB
	IPonudbaDAO ponudbeDAO;

	public Drazba drazba;
	public double min;
	public double max;
	public double ponudba;
	public Date doKonca;

	private long sekunde;
	private long minute;
	private long ure;
	private long dnevi;
	private String datum;

	@ManagedProperty(value = "#{prijavaMB}")
	private PrijavaMannagedBean prijava;

	public void increment() {
		// number++;
		Date now = new Date();
		long diff = drazba.getKoneDrazbe().getTime() - now.getTime();
		sekunde = TimeUnit.MILLISECONDS.toSeconds(diff)%60; 
		minute = TimeUnit.MILLISECONDS.toMinutes(diff)%60; 
		ure = TimeUnit.MILLISECONDS.toHours(diff)%24; 
		dnevi = TimeUnit.MILLISECONDS.toDays(diff); 

		if (dnevi > 0)
			datum = dnevi + " " + "dni " + ure + "h "
					+ minute + "min " + sekunde + "s";
		else if (ure > 0)
			datum = ure + "h " + minute + "min " + sekunde + "s";
		else if (minute > 0)
			datum = minute + "min " + sekunde + "s";
		else if (sekunde > 0)
			datum = sekunde + "s";
	}

	public long getSekunde() {
		return sekunde;
	}

	public void setSekunde(long sekunde) {
		this.sekunde = sekunde;
	}

	public long getMinute() {
		return minute;
	}

	public void setMinute(long minute) {
		this.minute = minute;
	}

	public long getUre() {
		return ure;
	}

	public void setUre(long ure) {
		this.ure = ure;
	}

	public long getDnevi() {
		return dnevi;
	}

	public void setDnevi(long dnevi) {
		this.dnevi = dnevi;
	}

	@PostConstruct
	public void init() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String id = (String) facesContext.getExternalContext()
					.getRequestParameterMap().get("idDrazba");

			drazba = drazbaDAO.vrniDrazba(Integer.parseInt(id));
		} catch (Exception e) {

		}
		
		if (drazba.getPonudba() != null)
			min = drazba.getPonudba().getPonudba() * 11 / 10;
		else
			min = drazba.getSklicnaCena();
		
		if (min * 5 < 100)
			max = 100;
		else
			max = min * 5;
		
		increment();
	}

	public void onTimeout() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "BOOM", null));
	}

	public Date getDoKonca() {
		return doKonca;
	}

	public void setDoKonca(Date doKonca) {
		this.doKonca = doKonca;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getPonudba() {
		return ponudba;
	}

	public void setPonudba(double ponudba) {
		this.ponudba = ponudba;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public Drazba getDrazba() {
		return drazba;
	}

	public void setDrazba(Drazba drazba) {
		this.drazba = drazba;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public PrijavaMannagedBean getPrijava() {
		return prijava;
	}

	public void setPrijava(PrijavaMannagedBean prijava) {
		this.prijava = prijava;
	}

}
