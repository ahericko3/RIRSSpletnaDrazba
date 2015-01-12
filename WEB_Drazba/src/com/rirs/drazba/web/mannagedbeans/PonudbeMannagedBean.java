package com.rirs.drazba.web.mannagedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.entity.Ponudba;

public class PonudbeMannagedBean {
	private static final long serialVersionUID = 1L;

	@EJB
	IDrazbaDAO drazbaDAO;

	public List<Ponudba> ponudbe;
	public Drazba drazba;

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String id = (String) facesContext.getExternalContext()
				.getRequestParameterMap().get("idDrazba");

		int idDrazbe = Integer.parseInt(id);
		ponudbe = drazbaDAO.getPonudbe(idDrazbe);
		drazba = drazbaDAO.vrniDrazba(idDrazbe);
	}
	
	public Drazba getDrazba() {
		return drazba;
	}

	public void setDrazba(Drazba drazba) {
		this.drazba = drazba;
	}

	public List<Ponudba> getPonudbe() {
		return ponudbe;
	}

	public void setPonudbe(List<Ponudba> ponudbe) {
		this.ponudbe = ponudbe;
	}
}
