package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3_2019", name = "deltager")

public class Deltager {
	
	@Id
	private String mobil;
	
	private String fNavn;
	private String eNavn;
	private char kjonn;
	
	private String passordHash;
	private String passordSalt;
	
	
	@Override
	public String toString() {
		return "Deltager [mobil=" + mobil + ", fNavn=" + fNavn + ", eNavn=" + eNavn + ", kjonn=" + kjonn +"]";
	}


	public Deltager() {}

	
	public Deltager(String fNavn, String eNavn, String mobil, String passordHash, String passordSalt,  char kjonn) {
		this.fNavn = fNavn;
		this.eNavn = eNavn;
		this.mobil = mobil;
		this.kjonn = kjonn;
		this.passordHash = passordHash;
		this.passordSalt = passordSalt;
		
		
	}
	public String getfNavn() {
		return fNavn;
	}
	public void setfNavn(String fNavn) {
		this.fNavn = fNavn;
	}
	public String geteNavn() {
		return eNavn;
	}
	public void seteNavn(String eNavn) {
		this.eNavn = eNavn;
	}
	
	public String getMobil() {
		return (mobil.substring(0,3) + " " + mobil.substring(3,5) + " " + mobil.substring(5));
	}
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	public char getKjonn() {
		return kjonn;
	}
	public void setKjonn(char kjonn) {
		this.kjonn = kjonn;
	}
	
	public String getTegn () {
		if(kjonn == 'm') {
			return "&#9794";
		}else {
			return "&#9792";
		}
	}


	public String getPassordHash() {
		return passordHash;
	}


	public void setPassordHash(String passordHash) {
		this.passordHash = passordHash;
	}


	public String getPassordSalt() {
		return passordSalt;
	}


	public void setPassordSalt(String passordSalt) {
		this.passordSalt = passordSalt;
	}
	
	
	
}
