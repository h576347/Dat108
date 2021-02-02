package no.hvl.dat108.oppgave3;


public class Main {

	static Kokker kokk = new Kokker();
	static Servitorer sev = new Servitorer();
	static Rutsjebane rb = new Rutsjebane();

	
	public static void main(String[] args) {
		System.out.println("Oppgave3");

		sev.s_start(rb);

		kokk.k_start(rb);
		
		
		

	}
	
	

}
