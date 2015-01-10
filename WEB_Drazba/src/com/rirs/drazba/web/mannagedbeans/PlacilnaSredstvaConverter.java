package com.rirs.drazba.web.mannagedbeans;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import com.rirs.drazba.enumi.PlacilnaSredstva;

@FacesConverter(value="placilnaSredstvaConverter")
public class PlacilnaSredstvaConverter extends EnumConverter{
public PlacilnaSredstvaConverter(){
	super(PlacilnaSredstva.class);
}
}
