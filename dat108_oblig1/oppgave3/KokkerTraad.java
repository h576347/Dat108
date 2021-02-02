package no.hvl.dat108.oppgave3;

import java.util.ArrayList;

public class KokkerTraad extends Thread {


	private Rutsjebane rb;
	private String navn;


	public KokkerTraad(Rutsjebane rb, String navn) {
		this.rb = rb;
		this.navn = navn;
	}
	
	@Override
	public void run() {
		
			while(true) {
				
				int tall = (int) (Math.random() * 5) + 2;
				tall *= 1000;
				
				try {
					Thread.sleep(tall);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

					if(rb.erFullt()) {

							System.out.println("### " + navn +" er klar med hamburgeren, men rutsjebana er full. Venter! ##" );

						}
				
					
				
						
						if(!rb.erFullt()) {
						try {
							rb.lagtPaaTab();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(navn + " legger på en hamburger nr (" +rb.getLagde() + 
								")" + " => (" +  rb.getAList()+ ")");
						
						
					
						
						
					}
				}
				
				
			
			
				
		}
	

	
	

}
