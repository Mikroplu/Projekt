package com.pubiapplication.app;

public class Pubid {

	private String nimi;
	private String asukoht;
	private int laudade_arv;

	public Pubid(String nimi, String asukoht, int laudade_arv) {
		this.setNimi(nimi);
		this.setAsukoht(asukoht);
		this.setLaudade_arv(laudade_arv);
	}

	public Pubid() {

	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public void setAsukoht(String asukoht){
		this.asukoht = asukoht;
	}
	public void setLaudade_arv(int laudade_arv){
		this.laudade_arv = laudade_arv;
	}

	public String getNimi() {
		return nimi;
	}
	public String getAsukoht() {
		return asukoht;
	}
	public int getLaudade_arv() {
		return laudade_arv;
	}
}
