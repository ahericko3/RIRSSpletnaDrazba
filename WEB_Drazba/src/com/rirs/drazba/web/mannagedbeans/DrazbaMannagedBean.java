package com.rirs.drazba.web.mannagedbeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.ejb.dao.IPonudbaDAO;
import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.entity.Ponudba;


public class DrazbaMannagedBean implements Serializable{
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
	
	private int number;//sekunde
	 private int sekunde;
	 private int minute;
	 private int dnevi;
	 private String datum;
	 
	 @ManagedProperty(value = "#{prijavaMB}")
		private PrijavaMannagedBean prijava;
	 
    public int getNumber() {
        return number;
    }
    
    public void increment() {
       // number++;
    	Date now=new Date();
		doKonca=new Date(drazba.getKoneDrazbe().getTime()-now.getTime());
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(doKonca);   // assigns calendar to given date 
		
		minute=calendar.get(Calendar.MINUTE);
		dnevi=calendar.get(Calendar.DAY_OF_MONTH);
		sekunde=calendar.get(Calendar.SECOND);
		
		datum=dnevi+" "+"dni "+calendar.get(Calendar.HOUR)+"h "+minute+"min "+sekunde+"s";
    }
	

	public int getSekunde() {
		return sekunde;
	}

	public void setSekunde(int sekunde) {
		this.sekunde = sekunde;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getDnevi() {
		return dnevi;
	}

	public void setDnevi(int dnevi) {
		this.dnevi = dnevi;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@PostConstruct
	public void init(){
		try{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String id = (String) facesContext.getExternalContext().
        getRequestParameterMap().get("idDrazba");
		
		drazba=drazbaDAO.vrniDrazba(Integer.parseInt(id));
		System.out.println(drazba.getImePredmeta());
	    }catch(Exception e){
		
	}
		//min=(drazba.getPonudba().getPonudba()*11/10);
		min=10.0;
		max=min*100;
		
	}

	
	
	public void onTimeout(){  
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"BOOM",null));  
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
