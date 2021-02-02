package no.hvl.dat108.oppgave2;


import java.util.Arrays;
import java.util.List;
import java.util.function.*;



public class Oppg2 {

	private static Kjonn m = Kjonn.MANN;
	private static Kjonn k = Kjonn.KVINNE;
	

	
	public static void main(String[] args) {

		Ansatt a1 = new Ansatt("Hans", "Hanse", m, "kokk", 400000);
		Ansatt b = new Ansatt("Joar", "Hansen", m, "Servitor", 200000);
		Ansatt c = new Ansatt("Silvy", "Listhaug", k, "Resepsjonist", 300000);
		Ansatt d = new Ansatt("Helga", "Andresen", k, "Servitor", 200000);
		Ansatt e = new Ansatt("Inger Marie", "Storhaug", k, "Daglig leder", 600000);
		

		List<Ansatt> ansatte = Arrays.asList(a1, b, c, d, e);
		
		Function<Ansatt,Integer> kronetillegg = a -> a.getAarslonn() + 50000;
		Function<Ansatt,Integer> prosenttillegg = a -> (a.getAarslonn() + (a.getAarslonn()*3/100));
		
		lonnsoppgjor(ansatte,kronetillegg, a-> true);
		System.out.println("Kronetillegg alle ansatte");
		printAll(ansatte);
		
		lonnsoppgjor(ansatte,prosenttillegg, a-> true);
		System.out.println("Prosenttilegg alle ansatte");
		printAll(ansatte);
		
		lonnsoppgjor(ansatte,kronetillegg, a -> a.getAarslonn() < 300000);
		System.out.println("Kronetillegg mindre enn 300000");
		printAll(ansatte);
		
		lonnsoppgjor(ansatte,kronetillegg, a -> a.getKjonn() == m);
		System.out.println("Kronetillegg for menn");
		printAll(ansatte);
		
	
	}
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt,Integer> lambda, Predicate<Ansatt> pa) {
		for(Ansatt a :ansatte ) {
			if(pa.test(a)) {
				a.setAarslonn(lambda.apply(a));
			}
		}
	}
	private static void printAll(List<Ansatt> ansatte) {
		ansatte.forEach(System.out::println);
		System.out.println();
	}

}
