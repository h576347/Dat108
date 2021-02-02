package no.hvl.dat108.Oppgave2;

public class Servitorer {
	
	private  Thread[] sTraad = new Thread[2];
	private final int ANT_SERVITORERTRAAD = 2;
	private int nr =1;
	
	public void s_start(Rutsjebane rb) {
		for(int i = 0; i < ANT_SERVITORERTRAAD; i++) {
			sTraad[i] = new Thread(new ServitorerTraad(rb, "Servitør: " + nr));
			nr++;
			sTraad[i].start();
		}
		

	}

	
	

}
