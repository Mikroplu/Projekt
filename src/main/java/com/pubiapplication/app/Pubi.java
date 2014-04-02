package com.pubiapplication.app;

public class Pubi {

	private int id;
	private String nimi;
	private String asukoht;
	private int laudade_arv;

	public Pubi(int id, String nimi, String asukoht, int laudade_arv) {
		this.setId(id);
		this.setNimi(nimi);
		this.setAsukoht(asukoht);
		this.setLaudade_arv(laudade_arv);
	}

	public Pubi() {

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

	public void setId(int id){
		this.id = id;
	}

	public int getId() {
		return id;
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
