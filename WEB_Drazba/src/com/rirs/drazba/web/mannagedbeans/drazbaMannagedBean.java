package com.rirs.drazba.web.mannagedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.entity.Drazba;


public class drazbaMannagedBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB 
	IDrazbaDAO drazbaDAO;
	
	public int idDrazbe;
	public Drazba drazba;
	
	@PostConstruct
	public void init(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String id = (String) facesContext.getExternalContext().
        getRequestParameterMap().get("idDrazba");
		
		
		idDrazbe=Integer.parseInt(id);
		drazba=drazbaDAO.vrniDrazba(idDrazbe);
	
	}

	public int getIdDrazbe() {
		return idDrazbe;
	}

	public void setIdDrazbe(int idDrazbe) {
		this.idDrazbe = idDrazbe;
	}

	public Drazba getDrazba() {
		return drazba;
	}

	public void setDrazba(Drazba drazba) {
		this.drazba = drazba;
	}
	
	
	
	
}
