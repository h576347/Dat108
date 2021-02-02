package no.hvl.dat108.oppgave1;

public class Oppgave1 {

	private static Traad melding;

	public static void main(String[] args) {
		
		String stopp = "Stopp";
		
		
		Thread t1 = new Thread(new Traad());
		Thread t2 = new Thread(new Traad2());
		
		t1.start();
		t2.start();
			
			
			} 
			
	

}
