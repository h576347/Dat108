package no.hvl.dat108.oppgave1;

import javax.swing.JOptionPane;

public class Traad implements Runnable{
	
	private static  String melding = "";
	
	private  boolean kjor = true;
	
	public Traad() {}
	
	@Override
	public void run() {
		
		while(kjor) {
			melding = JOptionPane.showInputDialog("Skriv inn en melding:  eller skriv 'Stopp' for å stoppe");
			
			if(melding.equals("Stopp")) {
				stopp();
			}
		}
		
	}
	
	public static String getMelding() {
		return melding;
	}
	
	public void stopp() {
		kjor = false;
	}

}
