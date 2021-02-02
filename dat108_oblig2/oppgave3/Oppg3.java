package no.hvl.dat108.oppgave3;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import no.hvl.dat108.oppgave2.Ansatt;
import no.hvl.dat108.oppgave2.Kjonn;

public class Oppg3 {


	private static Kjonn m = Kjonn.MANN;
	private static Kjonn k = Kjonn.KVINNE;
	
	public static void main(String[] args) {
		Ansatt a1 = new Ansatt("Hans", "Hansen", m, "Sjefskokk", 400000);
		Ansatt a2 = new Ansatt("Joar", "Hansen", m, "Servitor", 200000);
		Ansatt a3 = new Ansatt("Silvy", "Listhaug", k, "Resepsjonist", 300000);
		Ansatt a4 = new Ansatt("Helga", "Andresen", k, "Servitor", 200000);
		Ansatt a5 = new Ansatt("Inger Marie", "Storhaug", k, "Sjef", 850000);
		

		List<Ansatt> ansatte = Arrays.asList(a1, a2, a3, a4, a4,a5);

		
		
		//oppgave a
		List<String> nyList = ansatte.stream()
				.map(Ansatt::getEtternavn)
				.collect(Collectors.toList());
		
		System.out.println("a) ny liste" + nyList + "\n");
		
		
		
		//oppgave b
		long antKvinner = ansatte.stream()
			.filter(s -> (s.getKjonn() == k))
			.count();
		System.out.println("b) Anatall kvinner: " + antKvinner + "\n");
		
		
		
		//oppgave c
		double gjennomsnittKvinner = (ansatte.stream()
			.filter(s -> (s.getKjonn() == k))
			.collect(Collectors.averagingInt( a -> (a.getAarslonn()))));
		System.out.println("c) Gjennomsnittsinntekt kvinner: " + gjennomsnittKvinner + "\n");
		
		
		
		//oppgave d
		List<Ansatt> sjefer = ansatte;
		sjefer.stream()
			.filter(a -> a.getStilling().contains("sjef"))
			.forEach(a -> a.setAarslonn((int) (a.getAarslonn()*1.07)));
		System.out.println("d) sjefene i på arbeidsplassen er: " + sjefer+ "\n");
		
		
		
		//oppgave e
		boolean k = ansatte.stream()
			.anyMatch(a -> a.getAarslonn() > 800000);
		System.out.println("e) Tjener mer enn 800 000: " + k + "\n");
		
		
		
		//oppgave f
		System.out.println("f) Skriver ut alle ansatte: ");
		ansatte.stream()
			.forEach(System.out::println);
		System.out.println();
		
		
		
		//oppgave g
		Ansatt ansLavestLonn = ansatte.stream()
				.min((a,s)-> (a.getAarslonn()- s.getAarslonn()))
				.orElseThrow(NoSuchElementException::new);
		System.out.println("g) Ansatt med lavest lønn: " +ansLavestLonn);
		System.out.println();
		
		
		
		//oppgave h
		int sum = IntStream.range(1, 1000)
				.filter(tall -> tall % 3 == 0 || tall % 5 == 0)
				.sum();
		System.out.println("h) Summen av alle tall mellom 1 og 1000 som er delelig på 3 eller 5: " + sum);
		System.out.println();
		
		
;
		

	
			
		
		
	}

}
