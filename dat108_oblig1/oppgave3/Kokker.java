package no.hvl.dat108.oppgave3;


public class Kokker {
	
	private Thread[] kTraad = new Thread[3];
	private final int ANT_KOKKER = 3;
	private String navn = "Kokk nr. ";
	private int nr = 1;
	

	public void k_start(Rutsjebane rb) {

		for(int i = 0; i < ANT_KOKKER; i++) {
			kTraad[i] = new Thread(new KokkerTraad(rb, navn + nr));
			nr++;
			kTraad[i].start();
		}
		
	
	}

}
