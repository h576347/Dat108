package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class FormattertListe {
	
	private String navn;
	private String mobil;
	private String kjonn;
	
	
	public FormattertListe(String navn, String mobil, String kjonn) {
	
		this.navn = navn;
		this.mobil = mobil;
		this.kjonn = kjonn;
	}
	
	public FormattertListe() {}
	
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getMobil() {
		return mobil;
	}
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	public String getKjonn() {
		return kjonn;
	}
	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	public List<FormattertListe> formattert(List <Deltager> del){
		
		List<FormattertListe> hListe = new ArrayList<FormattertListe>();
		for(int i = 0; i < del.size(); i++) {
			Deltager listeDel = del.get(i);
			String navn = listeDel.getfNavn() + listeDel.geteNavn();
			String kjonn;
			String mob = listeDel.getMobil();
			String nyMob = (mob.substring(0,3) + " " + mob.substring(3,5) + " " + mob.substring(5));
			
			if(listeDel.getKjonn() == 'k') {
				kjonn = "&#9792";
			}else {
				kjonn = "&#9794";
			}
			FormattertListe listeDeltager= new FormattertListe(navn,kjonn,nyMob);
			hListe.add(listeDeltager);
		}
		return hListe;
	}

}
