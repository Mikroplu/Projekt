package com.pubiapplication.app;

public class Linnad {

	private String nimi;

	public Linnad(String nimi) {
		this.setNimi(nimi);
	}

	public Linnad() {

	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getNimi() {
		return nimi;
	}
}
