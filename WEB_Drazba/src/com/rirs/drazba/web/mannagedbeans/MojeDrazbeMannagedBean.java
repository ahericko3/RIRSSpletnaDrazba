package com.rirs.drazba.web.mannagedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.entity.Drazba;

public class MojeDrazbeMannagedBean implements Serializable {
	
	@EJB
	IDrazbaDAO drazbaDAO;

    @ManagedProperty(value="#{prijavaMB}") 
    private PrijavaMannagedBean prijavaMB;
    
	public List<Drazba> mojeDrazbe;
	
	@PostConstruct
	public void init(){
		mojeDrazbe=drazbaDAO.vrniVseDrazbeIzdajatelja(prijavaMB.getUporabnik());
	}


	public List<Drazba> getMojeDrazbe() {
		return mojeDrazbe;
	}
	
	public void setMojeDrazbe(List<Drazba> mojeDrazbe) {
		this.mojeDrazbe = mojeDrazbe;
	}
	
}
