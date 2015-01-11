package com.rirs.drazba.ejb.dao;

import com.rirs.drazba.entity.Drazba;
import com.rirs.drazba.entity.Ponudba;

public interface IPonudbaDAO {
	
	public void oddajPonudbo(Drazba drazba, Ponudba ponudba);

	void dodaj(Ponudba ponudba);
}
