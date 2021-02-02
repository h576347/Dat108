package no.hvl.dat108.oppgave3;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Rutsjebane {

	private final int MAX_BURGERE = 5;

	private int burgereServert = 0;
	private int burgereFerdig = 0;
	private BlockingQueue<Integer> aList = new ArrayBlockingQueue(5);
	

	
	public void lagtPaaTab() throws InterruptedException {

		burgereFerdig++;
		aList.put(burgereFerdig);
		
	}
	
	public void servertTab() {	

		burgereServert++;
		aList.remove();

	}

	public boolean erTom() {
		return aList.isEmpty();
	}
	
	public boolean erFullt() {
		return aList.size() == MAX_BURGERE;
	}
	public BlockingQueue<Integer> getAList(){
		return aList;
	}

	public synchronized int getServerte() {
		return burgereServert;
	}
	
	public synchronized int getLagde() {
		return burgereFerdig;
	}

}
