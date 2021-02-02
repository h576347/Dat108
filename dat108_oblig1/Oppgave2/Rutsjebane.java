package no.hvl.dat108.Oppgave2;

import java.util.ArrayList;

public class Rutsjebane {

	private final int MAX_BURGERE = 5;

	private int burgereServert = 0;
	private int burgereFerdig = 0;
	private ArrayList<Integer> aList = new ArrayList();
	

	
	public synchronized ArrayList<Integer> lagtPaaTab() {

		burgereFerdig++;
		aList.add(burgereFerdig);
		
		return aList;
	}
	
	public synchronized void servertTab() {	

		burgereServert++;
		aList.remove(0);

	}

	public boolean erTom() {
		return aList.isEmpty();
	}
	
	public boolean erFullt() {
		return aList.size() == MAX_BURGERE;
	}
	public ArrayList<Integer> getAList(){
		return aList;
	}

	public synchronized int getServerte() {
		return burgereServert;
	}
	
	public synchronized int getLagde() {
		return burgereFerdig;
	}

}
