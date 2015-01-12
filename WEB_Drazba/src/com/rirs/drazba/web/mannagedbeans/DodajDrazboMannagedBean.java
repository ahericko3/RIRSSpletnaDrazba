package com.rirs.drazba.web.mannagedbeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.enumi.Kategorija;
import com.rirs.drazba.enumi.PlacilnaSredstva;
import com.rirs.drazba.enumi.StanjePredmeta;

public class DodajDrazboMannagedBean {

	@EJB
	IDrazbaDAO drazbaDAO;

	private java.lang.String imePredmeta;
	private com.rirs.drazba.entity.Uporabnik izdajatelj;
	private java.util.Date konecDrazbe;
	private java.lang.String porekloDrzava;
	private String opisPredmeta;
	private StanjePredmeta stanje;
	private String sklicnaCena;
	private String cenaPosiljanja;
	private List<PlacilnaSredstva> placilnaSredstva;

	@ManagedProperty(value = "#{prijavaMB}")
	private PrijavaMannagedBean prijava;

	private String kategorija;

	
	public PrijavaMannagedBean getPrijava() {
		return prijava;
	}

	public void setPrijava(PrijavaMannagedBean prijava) {
		this.prijava = prijava;
	}

	private PlacilnaSredstva[] pp;

	public StanjePredmeta[] getStanjePredmeta() {
		return StanjePredmeta.values();
	}

	public String getCenaPosiljanja() {
		return cenaPosiljanja;
	}

	public void setCenaPosiljanja(String cenaPosiljanja) {
		this.cenaPosiljanja = cenaPosiljanja;
	}

	public String getSklicnaCena() {
		return sklicnaCena;
	}

	public void setSklicnaCena(String sklicnaCena) {
		this.sklicnaCena = sklicnaCena;
	}

	public PlacilnaSredstva[] getPp() {
		return PlacilnaSredstva.values();
	}

	public String getOpisPredmeta() {
		return opisPredmeta;
	}

	public void setOpisPredmeta(String opisPredmeta) {
		this.opisPredmeta = opisPredmeta;
	}

	public List<PlacilnaSredstva> getPlacilnaSredstva() {
		return placilnaSredstva;
	}

	public void setPlacilnaSredstva(List<PlacilnaSredstva> placilnaSredstva) {
		this.placilnaSredstva = placilnaSredstva;
	}

	public void setPp(PlacilnaSredstva[] pp) {
		this.pp = pp;
	}

	public java.lang.String getImePredmeta() {
		return imePredmeta;
	}

	public void setImePredmeta(java.lang.String imePredmeta) {
		this.imePredmeta = imePredmeta;
	}

	public com.rirs.drazba.entity.Uporabnik getIzdajatelj() {
		return izdajatelj;
	}

	public void setIzdajatelj(com.rirs.drazba.entity.Uporabnik izdajatelj) {
		this.izdajatelj = izdajatelj;
	}

	public Date getKonecDrazbe() {
		return konecDrazbe;
	}

	public void setKonecDrazbe(Date konecDrazbe) {
		this.konecDrazbe = konecDrazbe;
	}

	public java.lang.String getPorekloDrzava() {
		return porekloDrzava;
	}

	public void setPorekloDrzava(java.lang.String porekloDrzava) {
		this.porekloDrzava = porekloDrzava;
	}

	public com.rirs.drazba.enumi.StanjePredmeta getStanje() {
		return stanje;
	}

	public void setStanje(com.rirs.drazba.enumi.StanjePredmeta stanje) {
		this.stanje = stanje;
	}

	public void dodajDrazbo() {
		System.out.println("Dodajam");
		Drazba d = new Drazba();
		d.setImePredmeta(imePredmeta);
		d.setKoneDrazbe(konecDrazbe);
		d.setPlacilnaSredstva(placilnaSredstva);
		d.setPorekloDrzava(porekloDrzava);
		d.setStanje(stanje);
		d.setCenaPakiranja(Double.valueOf(cenaPosiljanja));
		d.setSklicnaCena(Double.valueOf(sklicnaCena));
		d.setKonec(false);
		
		d.setOpisPredmeta(opisPredmeta);
		System.out.println(prijava);
		d.setIzdajatelj(prijava.getUporabnik());
		d.setKategorija(Kategorija.valueOf(kategorija));
		drazbaDAO.dodaj(d);

	}

	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected",
						format.format(event.getObject())));
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public void click() {
		RequestContext requestContext = RequestContext.getCurrentInstance();

		requestContext.update("form:display");
		requestContext.execute("PF('dlg').show()");
	}

}
