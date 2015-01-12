package com.rirs.drazba.web.mannagedbeans;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

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

	private DrazbaRequestMannagedBean drazbaMB;

	public java.lang.Double getPonudba() {
		return ponudba;
	}

	public void setPonudba(java.lang.Double ponudba) {
		this.ponudba = ponudba;
	}

	public void oddajPonudbo() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String id = (String) facesContext.getExternalContext()
				.getRequestParameterMap().get("idDrazba");
		Ponudba p = new Ponudba();
		p.setDatum(new java.util.Date());
		p.setDrazba(drazbaMB.getDrazba(Integer.parseInt(id)));
		p.setPonudba(ponudba);
		p.setUporabnik(drazbaMB.getPrijava().getUporabnik());
		drazbaDAO.oddajPonudbo(Integer.parseInt(id), p);

		/**
		 * Drazba d = new Drazba(); try { if (drazbaMB.getDrazba().getPonudbe()
		 * != null) { d = drazbaMB.getDrazba(); d.getPonudbe().add(p);
		 * d.setPonudba(p); } else { d = drazbaMB.getDrazba();
		 * ArrayList<Ponudba> ponudbe = new ArrayList<Ponudba>();
		 * ponudbe.add(p); d.setPonudbe(ponudbe); }
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 */
		// drazbaDAO.uredi(d);

	}

	public DrazbaRequestMannagedBean getDrazbaMB() {
		return drazbaMB;
	}

	public void setDrazbaMB(DrazbaRequestMannagedBean drazbaMB) {
		this.drazbaMB = drazbaMB;
	}
}
