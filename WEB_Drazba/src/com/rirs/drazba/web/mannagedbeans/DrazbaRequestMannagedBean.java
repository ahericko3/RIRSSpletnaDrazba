package com.rirs.drazba.web.mannagedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.rirs.drazba.ejb.dao.IDrazbaDAO;
import com.rirs.drazba.entity.Drazba;

public class DrazbaRequestMannagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	IDrazbaDAO drazbaDAO;

	public Drazba drazba;

	@ManagedProperty(value = "#{prijavaMB}")
	private PrijavaMannagedBean prijava;

	public void init() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String id = (String) facesContext.getExternalContext()
					.getRequestParameterMap().get("idDrazba");

			drazba = drazbaDAO.vrniDrazba(Integer.parseInt(id));
		} catch (Exception e) {

		}
	}

	public Drazba getDrazba(int idDrazba) {
		return drazbaDAO.vrniDrazba(idDrazba);
	}

	public Drazba getDrazba() {
		return drazba;
	}

	public void setDrazba(Drazba drazba) {
		this.drazba = drazba;
	}

	public PrijavaMannagedBean getPrijava() {
		return prijava;
	}

	public void setPrijava(PrijavaMannagedBean prijava) {
		this.prijava = prijava;
	}
}
