package com.rirs.drazba.web.mannagedbeans;

import javax.ejb.EJB;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.ejb.dao.IPonudbaDAO;
import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.entity.Ponudba;

public class OddajPonudboMannagedBean {
	@EJB 
	IDrazbaDAO drazbaDAO;
	@EJB
	IPonudbaDAO ponudbeDAO;
	
	private Double ponudba;
	private PrijavaMannagedBean prijava;
	private DrazbaMannagedBean drazba;

	public java.lang.Double getPonudba() {
		return ponudba;
	}

	public void setPonudba(java.lang.Double ponudba) {
		this.ponudba = ponudba;
	}

	public com.rirs.drazba.web.mannagedbeans.PrijavaMannagedBean getPrijava() {
		return prijava;
	}

	public void setPrijava(
			com.rirs.drazba.web.mannagedbeans.PrijavaMannagedBean prijava) {
		this.prijava = prijava;
	}

	public com.rirs.drazba.web.mannagedbeans.DrazbaMannagedBean getDrazba() {
		return drazba;
	}

	public void setDrazba(
			com.rirs.drazba.web.mannagedbeans.DrazbaMannagedBean drazba) {
		this.drazba = drazba;
	}
	
	public void oddajPonudbo(){
		System.out.println("oddajPonudbo");
		Ponudba p=new Ponudba();
		p.setDatum(new java.util.Date());
		p.setDrazba(drazba.getDrazba());
		p.setPonudba(ponudba);
		p.setUporabnik(prijava.getUporabnik());
		
		Drazba d=new Drazba();
		try{
			if(drazba.getDrazba().getPonudbe()!=null){
				d=drazba.getDrazba();
				d.getPonudbe().add(p);
				d.setPonudba(p);
			}
		}catch(Exception e){
			
		}
		//drazbaDAO.uredi(d);
		ponudbeDAO.dodaj(p);
		
	}

}
