package no.hvl.dat108.oppgave1;

public class Traad2 implements Runnable{
	
	private static String melding;
	private boolean kjor = true;
	
	public Traad2() {}
	
	@Override
	public void run() {
		
		while(kjor) {
			melding = Traad.getMelding();
			
			if(melding.equals("Stopp")) {
				stopp();
			}
			else {
			System.out.println(melding);
			
			}try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}}	
	
	public void stopp() {
		kjor = false;
	}

}
