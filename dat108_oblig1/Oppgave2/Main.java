package no.hvl.dat108.Oppgave2;


public class Main {

	static Kokker kokk = new Kokker();
	static Servitorer sev = new Servitorer();
	static Rutsjebane rb = new Rutsjebane();

	
	public static void main(String[] args) {

		sev.s_start(rb);

		kokk.k_start(rb);
		
		
		

	}
	
	

}
