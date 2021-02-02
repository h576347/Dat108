package no.hvl.dat108.oppgave3;

public class ServitorerTraad extends Thread{
	
	private final int ANT_SERVITORER = 1;
	private int antServInne = 0;

	private Rutsjebane rb;
	private String navn;

	public ServitorerTraad(Rutsjebane rb, String navn) {
		this.rb = rb;
		this.navn = navn;
	}

	
	@Override
	public  void run() {
		
			
			while(true){
				int tall = (int) (Math.random() * 5) + 2;
				tall *= 1000;
				try {
					Thread.sleep(tall);
				} catch (InterruptedException a) {
				a.printStackTrace();
				}
				
				
					if(rb.erTom()) {
	
			
							System.out.println("### " + navn + " vil ta en hamburger, men rutsjebanenen tom. Venter!###");
							
							
						
				}
			
			
						if(!rb.erTom()) {
					
						rb.servertTab();
						
						System.out.println(navn + " tar av hamburger" + "(" + rb.getServerte() + ")" + " => ( " 
								+ rb.getAList() + " )");
					
					
						
						
						
				}
				}
			
				
		}
		
	
			
		
		
	
	
	

}
