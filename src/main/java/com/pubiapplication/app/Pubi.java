package com.pubiapplication.app;

public class Pubi {

	private int ID;
	private String nimi;
	private String asukoht;
	private int laudade_arv;

	public Pubi(String nimi, String asukoht, int laudade_arv) {
		this.setNimi(nimi);
		this.setAsukoht(asukoht);
		this.setLaudade_arv(laudade_arv);
	}

	public Pubi() {

	}
	public void setID(int id) {
		this.ID = id;
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

	public int getID() {
		return ID;
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
