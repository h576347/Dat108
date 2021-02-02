package no.hvl.dat108;

public class Validering {
	
	
	public static boolean erGyldige(String fNavn, String eNavn, String mobil, String pass, String passRep, String kjonn) {
		
		if(gyldigNavn(fNavn) 
				&& gyldigNavn(eNavn) 
				&& gyldigMobil(mobil) 
				&& gyldigPassord(pass)
				&& gyldigPassordRepetert(pass,passRep)
				&& gyldigKjonn(kjonn)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean gyldigNavn (String navn) {
		if( navn.length() > 1 &&  navn.length() < 21
				&& !navn.isBlank() 
				&& !(navn.contains("[0-9]+"))  
				&& navn.substring(0, 1).matches("[A-ZÆØÅ]+")
				&& navn.matches("^([A-ZØÆÅ][\\-\\sa-zA-ZæøåÆØÅ]+)")){
				System.out.println(1);
				return true;
			
			
		}
		return false;
	}
	
	public static boolean gyldigMobil(String mobil) {
		if((mobil.matches("[0-9]+")) 
				&& mobil.length() == 8 
				&& !mobil.isBlank()) {
			System.out.println(2);
			return true;
		}
		return false;
	}
	
	public static boolean gyldigPassord(String passord) {
		if(passord.length() > 3 
				&& !passord.isBlank()) {
			return true;
		}
		
		return false;
	}
	
	
	public static boolean gyldigPassordRepetert(String passord, String passordRepetert) {
		if(passord.contentEquals(passordRepetert)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean gyldigKjonn(String kjonn) {
		if(kjonn == null || kjonn.isBlank()) {
			return false;
		}
		return true;
	}

}
