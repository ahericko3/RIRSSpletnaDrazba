package com.rirs.drazba.enumi;

public enum StanjePredmeta {
	NOVO,RABLJENO,ZTIKETO;
	
	private final String description;

    StanjePredmeta() {
      description = toString().toLowerCase();
    }

    StanjePredmeta(String description) {
      this.description = description;
    }

    public String getDescription() {
      return description;
    }
}
