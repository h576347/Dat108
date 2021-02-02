package no.hvl.dat108.oppgave1b;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Oppg1 {

	public static void main(String[] args) {
		// i) summen av 12 og 13
		BiFunction<Integer,Integer,Integer> summerFunksjon = ((a,b) -> (a+b));
		System.out.println("Summen av 12 og 13: " + beregn(12, 13, summerFunksjon));

		
		//ii) Den største av -5 og 3
		BiFunction<Integer, Integer,Integer> storsteAv = ((a,b) -> {
			if(a>b) {
				return a;
			}
			return b;
		});
		System.out.println("Største av -5 og 3: " + beregn(-5,3, storsteAv));

		
		//iii Absoluttverdien og differansen mellom 54 og 45
		BiFunction<Integer,Integer,Integer> absoluttverdiAvDifferanse = ((a,b)->(Math.abs(a-b)));
		System.out.println("Absoluttverdi: " + beregn(54,45, absoluttverdiAvDifferanse));
//		System.out.println()
		
		

	}
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> bifun) {
			return bifun.apply(a, b);
		
	}
	
	

}
